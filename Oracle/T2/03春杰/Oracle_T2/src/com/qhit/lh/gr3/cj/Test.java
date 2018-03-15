package com.qhit.lh.gr3.cj;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.qhit.lh.gr3.cj.utils.DButil;

public class Test {

	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		Connection con = DButil.getConnection();
		String sql = "select * from dual";
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while (rs != null && rs.next()) {
				String name = rs.getString("user");
				list.add(name);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				// 关闭资源
				rs.close();
				ps.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
		for(String name:list){
			System.out.println(name);
			}
		}
	}


