package Crawling.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import Crawling.vo.MovieScoreVO;
import common.dao.QueryPackage;
import common.factory.DAOConnectionFactory;

public class MovieScoreDAO {
	Connection conn;
	MovieScoreDAO() throws ClassNotFoundException, SQLException{
		conn = DAOConnectionFactory.getInstance().getConnection();
	}

	public boolean insertObject(MovieScoreVO msvo) throws SQLException{
		PreparedStatement pstmt = conn.prepareStatement(QueryPackage.INSERT_MOVIE_SCORE);
		pstmt.setInt(1, msvo.getMovieId());
		pstmt.setDouble(2, msvo.getScoreTotal());
		pstmt.setDouble(3, msvo.getScoreMale());
		pstmt.setDouble(4, msvo.getScoreFemale());
		pstmt.setDouble(5, msvo.getScore_10());
		pstmt.setDouble(6, msvo.getScore_20());
		pstmt.setDouble(7, msvo.getScore_30());
		pstmt.setDouble(8, msvo.getScore_40());
		pstmt.executeQuery();
		return true;
	}
}
