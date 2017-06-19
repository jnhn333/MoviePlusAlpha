package Crawling.test;

import java.sql.SQLException;

import Crawling.dao.MovieDAO;
import Crawling.vo.MovieScoreVO;
import Crawling.vo.MovieVO;

public class CrawlingTest {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		MovieScoreVO msvo = new MovieScoreVO(1, 7.4, 7.1, 7.7, 4.7, 8.2, 6.4, 9.3);
		MovieVO mvo = new MovieVO(1, "세상에이런일이", "oh my god", "스릴러", "한국","조민철", "120분", "2012.08.16", "15세 이상", 1570, msvo);
		
		new MovieDAO().insertObject(mvo);
	}
}
