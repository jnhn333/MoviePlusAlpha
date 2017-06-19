package subtitle.utility;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Iterator;

import common.dao.QueryPackage;
import common.factory.DAOConnectionFactory;

public class MorphemeParserUtility{

	public static void main(String[] args) throws IOException, ClassNotFoundException, SQLException {
		MorphemeParser mp = new MorphemeParser();
		String filePath = args[0];
		//		String filePath = "C:\\Users\\mccho8865\\Desktop\\result\\10001.srt";
		File file = new File(filePath);
		//check to exist output folder

		for(File srcFile : file.listFiles())
			if(!srcFile.isDirectory()){
				mp.parseFromFile(srcFile, "CP949");
				//write to file
//				mp.writeToFile(srcFile, "CP949");
				//write to database
				mp.writeToDatabase(DAOConnectionFactory.getInstance().getConnection(),file.getName().split("[.]")[0]);
			}
	}

}

class MorphemeParser {
	HashMap<String, String> morphemeList;
	HashMap<String, Integer> wordCounter;
	public MorphemeParser() {
		// TODO Auto-generated constructor stub
		morphemeList = new HashMap<String, String>();
		wordCounter = new HashMap<String, Integer>();
	}

	void parseFromFile(File file, String charset) throws IOException{
		BufferedReader br = new BufferedReader(
				new InputStreamReader(
						new FileInputStream(file),charset));
		String line;
		while(br.ready()){
			line = br.readLine();
			String[] split = line.split("\t");
			if(split[1].contains("+")){
				String[] morpheme = split[1].split("[+]");
				for(String sp : morpheme)
					insertToArrayList(sp);
			} else  
				insertToArrayList(split[1]);
		}
	}

	public void insertToArrayList(String st){
		String[] str = st.split("[/]");
		//str[0] = 나, str[1] = NNG
		if(str.length != 2)
			return;

		//string trim
		String key = str[0].trim();
		String value = str[1].trim();

		//insert to morphemeList
		if(!morphemeList.containsKey(key))
			morphemeList.put(key, value);

		//insert to wordCount
		if(!wordCounter.containsKey(key))
			wordCounter.put(key, 1);
		else 
			wordCounter.replace(key, wordCounter.get(key)+1);
	}

	public void writeToFile(File file, String charset) throws IOException{
		//list iterator
		Iterator<String> morphemeIter = morphemeList.keySet().iterator();
		Iterator<String> wordCountIter = wordCounter.keySet().iterator();

		if(file.isDirectory()){
			if(!new File(file.getPath() + "\\morphemeList\\").exists())
				new File(file.getPath() + "\\morphemeList\\").mkdirs();
			if(!new File(file.getPath() + "\\wordCount\\").exists())
				new File(file.getPath() + "\\wordCount\\").mkdirs();
		}
		
		//Writer Stream Generator
		BufferedWriter morphemeListWriter = new BufferedWriter(
				new OutputStreamWriter(
						new FileOutputStream(
								new File(file.getParentFile().getPath() + "\\morphemeList\\" + file.getName())),charset));
		BufferedWriter wordCounterWriter = new BufferedWriter(
				new OutputStreamWriter(
						new FileOutputStream(
								new File(file.getParentFile().getPath() + "\\wordCount\\" + file.getName())),charset));

		//file store
		while(morphemeIter.hasNext()){
			String key = morphemeIter.next();
			morphemeListWriter.write(key+ "\t" + morphemeList.get(key) + "\n");
		}

		while(wordCountIter.hasNext()){
			String key = wordCountIter.next();
			wordCounterWriter.write(key+ "\t" + wordCounter.get(key) +"\n");
		}
		//close sentence for stream flush!
		morphemeListWriter.close();
		wordCounterWriter.close();
	}

	public void writeToDatabase(Connection conn, String fileID) throws SQLException{
		Iterator<String> morphemeIter = morphemeList.keySet().iterator();
		Iterator<String> wordCountIter = wordCounter.keySet().iterator();
		
		PreparedStatement pstmt = conn.prepareStatement(QueryPackage.INSERT_MORPHEME);
		while(morphemeIter.hasNext()){
			String key = morphemeIter.next();
			pstmt.setString(1, key);
			pstmt.setString(2, morphemeList.get(key));
			pstmt.executeQuery();
		}
		pstmt.close();
		pstmt = conn.prepareStatement(QueryPackage.INSERT_WORD_COUNT);
		while(wordCountIter.hasNext()){
			String key = wordCountIter.next();
			pstmt.setInt(1, Integer.parseInt(fileID));
			pstmt.setString(2, key);
			pstmt.setInt(3, wordCounter.get(key));
			pstmt.executeQuery();
		}
		pstmt.close();
	}
}