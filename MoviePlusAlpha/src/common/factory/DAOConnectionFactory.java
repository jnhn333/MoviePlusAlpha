package common.factory;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DAOConnectionFactory {
	private static DAOConnectionFactory factory;
	private Connection conn;
	private String url="jdbc:mariadb://mccho-mariadb-01.ddns.net:3306/BDC_EDA";
	private String id="bdcuser";
	private String pw="bigdata";
	private DAOConnectionFactory() throws ClassNotFoundException, SQLException{
		String className="org.mariadb.jdbc.Driver";
		Class.forName(className);
		conn=DriverManager.getConnection(url, id, pw);
	}
	public static DAOConnectionFactory getInstance() throws ClassNotFoundException, SQLException{
		if(factory == null) factory=new DAOConnectionFactory();
		return factory;
	}
	public Connection getConnection() throws SQLException{
		if(conn==null) DriverManager.getConnection(url, id, pw);
		return conn;
	}
}
