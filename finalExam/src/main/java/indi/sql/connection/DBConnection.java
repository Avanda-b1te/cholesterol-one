package indi.sql.connection;

import java.sql.*;
//数据库连接类
public class DBConnection {
	static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
	static final String URL = "jdbc:mysql://localhost:3306/zg?serverTimezone=UTC";
	static final String USER = "root";
	static final String PWD = "hh123456";
	
	Connection conn = null;
	PreparedStatement stmt = null;
	
	public PreparedStatement DB(String sql) {
	try {
		Class.forName(JDBC_DRIVER);
		conn=DriverManager.getConnection(URL,USER,PWD);
		stmt=conn.prepareStatement(sql);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return stmt;
	}
	
	public void close() {
		try {
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}