package com.qhit.lh.gr3.cj.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * 类名:DButil 创建时间:2018年3月15日 创建人:Disdain
 */
public class DButil {
	private static String ODriver= "oracle.jdbc.driver.OracleDriver";
	private static String url = "jdbc:oracle:thin:@localhost:1521:orcl";
	private static String user = "sys as sysdba";
	private static String password = "123456";
	public static Connection con = null;

	public static Connection getConnection() {
		try {
			Class.forName(ODriver);
			con = DriverManager.getConnection(url, user, password);
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return con;

	}
}
