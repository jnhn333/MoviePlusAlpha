package Crawling.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import Crawling.vo.MovieVO;
import common.dao.QueryPackage;
import common.factory.DAOConnectionFactory;

public class MovieDAO {
	Connection conn;
	public MovieDAO() throws ClassNotFoundException, SQLException {
		// TODO Auto-generated constructor stub
		conn = DAOConnectionFactory.getInstance().getConnection();
	}
	
	public boolean insertObject(MovieVO mvo) throws SQLException, ClassNotFoundException{
		PreparedStatement pstmt = conn.prepareStatement(QueryPackage.INSERT_MOVIE);
		pstmt.setInt(1, mvo.getId());
		pstmt.setString(2, mvo.getTitle());
		pstmt.setString(3, mvo.getGenre());
		pstmt.setString(4, mvo.getNation());
		pstmt.setString(5, mvo.getDirector());
		pstmt.setInt(6, mvo.getPlayTime());
		pstmt.setString(7, mvo.getSubTitle());
		pstmt.setString(8, mvo.getPubDate());
		pstmt.setString(9, mvo.getAgeGrade());
		pstmt.setInt(10, mvo.getEvaluatorCount());
		pstmt.executeQuery();
		pstmt.close();
		new MovieScoreDAO().insertObject(mvo.getMsvo());
		return true;
	}
}
