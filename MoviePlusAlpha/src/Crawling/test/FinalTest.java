package Crawling.test;

import java.io.IOException;
import java.sql.SQLException;

import Crawling.dao.MovieDAO;
import Crawling.utility.JSoupParser;
import Crawling.vo.MovieVO;

public class FinalTest {
	public static void main(String[] args) throws IOException, ClassNotFoundException, SQLException {
		int queryId = 121051;
		JSoupParser jsp = new JSoupParser();
		MovieDAO mdao = new MovieDAO();
		MovieVO mvo = jsp.executeParse(queryId);
		System.out.println(mvo);
		if(mvo != null)
		mdao.insertObject(mvo);
	}
}
