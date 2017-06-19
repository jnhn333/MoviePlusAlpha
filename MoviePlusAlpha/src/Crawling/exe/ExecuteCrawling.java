package Crawling.exe;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import Crawling.dao.MovieDAO;
import Crawling.utility.JSoupParser;
import Crawling.vo.MovieVO;

public class ExecuteCrawling {
	public static void main(String[] args) throws ClassNotFoundException, SQLException, FileNotFoundException {
		JSoupParser jsp = new JSoupParser();
		MovieDAO mdao = new MovieDAO();
		MovieVO mvo = new MovieVO();
		for(int queryId = 10000; ; queryId++){
			//프로그램 종료는 console 문장을 확인하고 수동 종료 하여야함.
			try {
				mvo = jsp.executeParse(queryId);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				System.out.println(e.getMessage());
			}
			if(mvo != null)
				try {
					mdao.insertObject(mvo);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					System.out.println(e.getMessage() );
				} 
		}
	}
}