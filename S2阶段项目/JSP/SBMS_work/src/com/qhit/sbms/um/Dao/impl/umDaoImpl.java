package com.qhit.sbms.um.Dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.qhit.sbms.common.bean.PageBean;
import com.qhit.sbms.um.Bean.User;
import com.qhit.sbms.um.Dao.umDao;
import com.qhit.sbms.util.DBManager;

public class umDaoImpl implements umDao {
	private Connection con = null;
	private PreparedStatement ps = null;
	private User user = null;
	
	public PageBean getPageBean(PageBean pageBean) {
		User user = null;
		con = DBManager.getConnection();
		String sql = "select top " 
		+ pageBean.getPagesize()
				+ " u.userId,u.userName,u.userSex,u.userAge,u.telephone,u.address,u.type,u.pic " 
				+ " from tb_user u "
				+ " where u.userId " 
				+ " not in ( " 
				+ " select top " 
				+ pageBean.getPagesize() * (pageBean.getP() - 1)
				+ " u.userId  " 
				+ " from tb_user u ) ; " ;

		try {
			ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				user = new User(
						rs.getInt("userId"),
						rs.getString("userName"),
						rs.getString("userSex"),
						rs.getInt("userAge"),
						rs.getString("telephone"),
						rs.getString("address"),
						rs.getInt("type"),
						rs.getString("pic")
					
						);

				pageBean.addData(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(ps, con);
		}
		return pageBean;

	}
	@Override
	public User doLogin(String userName, String userPassWord) {
		
		con = DBManager.getConnection();
		String sql = "select * from tb_user where userName = ? and userPassword = ? ";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, userName);
			ps.setString(2, userPassWord);
			ResultSet rs = ps.executeQuery();
			if(rs.next()){
				user = new User(
							rs.getInt("userId"), 
							userName, 
							userPassWord, 
							rs.getString("userSex"), 
							rs.getInt("userAge"), 
							rs.getString("telephone"), 
							rs.getString("addRess"), 
							rs.getString("pic"), 
							rs.getInt("type"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBManager.close(ps, con);
		}
		return user;
	}

	@Override
	public int addUser(User user) {
		con = DBManager.getConnection();
		String sql = "insert into tb_user values (?,?,?,?,?,?,?,?)";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, user.getUserName());
			ps.setString(2, user.getUserPassword());
			ps.setString(3, user.getUserSex());
			ps.setInt(4, user.getUserAge());
			ps.setString(5, user.getTelephone());
			ps.setString(6, user.getAddress());
			ps.setString(7, user.getPic());
			ps.setInt(8, user.getType());
			return ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return 0;
	}

}
