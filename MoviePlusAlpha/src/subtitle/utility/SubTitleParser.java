package subtitle.utility;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.io.Writer;

public class SubTitleParser {
	public static void main(String[] args) throws IOException {
		//String filePath = "Watchmen.srt";
		SubTitleParser stp = new SubTitleParser();
		File dir = new File(args[0]);
		File[] fileList = dir.listFiles();
		for(File file : fileList)
			if(!file.isDirectory()){
				System.out.println(file.getPath()+ " attempt ...");
				stp.subTitleParser(file);
				System.out.println(file.getPath() + " Success! \n");
				//stp.textFileToANSIEncoder(file);
			}
	}

	void subTitleParser(File file) throws IOException{
		InputStreamReader isr = new InputStreamReader(new FileInputStream(file.getPath()),"UTF8");
		File destDir = new File(file.getParentFile().getPath() + "\\output\\");
		if(!destDir.exists()){
			destDir.mkdirs();
		}
		OutputStreamWriter osw = new OutputStreamWriter(
				new FileOutputStream(
						destDir.getPath()+"\\"+file.getName()),"CP949");
		BufferedReader br = new BufferedReader(isr);
		String line;
		int num = 1;
		String floatTime;
		StringBuilder sb;
		while(br.readLine().equals(Integer.toString(num)));
		num++;
		while(br.ready()){
			sb = new StringBuilder();
			floatTime = br.readLine().split("-->")[0].substring(0, 8);
			while(br.ready()){
				line = br.readLine();
				if(line.equals(Integer.toString(num)))
					break;
				sb.append(line);
			}
			//System.out.println("num : "+ num + ", float Time : " + floatTime + ", script : " + sb);
			osw.write(sb+"\n");
			num++;
		}
	}

//	void textFileToANSIEncoder(File file) throws IOException{
//		Reader in = new BufferedReader(new InputStreamReader(
//				new FileInputStream(file.getParentFile().getPath() + "\\output\\" + file.getName()), "UTF-8"));
//		File destDir = new File(file.getParentFile().getPath()+"\\encoding");
//		if(!destDir.exists())
//			destDir.mkdirs();
//		Writer out = new BufferedWriter(new OutputStreamWriter(
//				new FileOutputStream(destDir+"\\"+file.getName()), "CP949"));
//
//		while(in.ready()){
//			out.write(in.read());
//		}
//	}
}
