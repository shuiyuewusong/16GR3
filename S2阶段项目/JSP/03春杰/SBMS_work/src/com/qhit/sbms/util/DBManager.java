package com.qhit.sbms.util;

/**
 * DB数据库操作系统
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * DB数据库操作系统
 */
public class DBManager {
	public static String driverName = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	public static String url = "jdbc:sqlserver://localhost:1433;DatabaseName=db_sbm";
	public static String username = "sa";
	public static String password = "123456";

	public static Connection getConnection() {
		Connection con = null;
		try {
			Class.forName(driverName);
			con = DriverManager.getConnection(url, username, password);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return con;
	}
	public static void close(Statement statement,Connection con){
		try {
			statement.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}