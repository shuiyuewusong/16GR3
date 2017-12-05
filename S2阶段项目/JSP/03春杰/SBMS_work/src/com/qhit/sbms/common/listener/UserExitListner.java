/**
 * 
 */
package com.qhit.sbms.common.listener;

import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import com.qhit.sbms.um.Bean.User;



/**
 * @author admin
 * 2017年11月13日
 */
public class UserExitListner implements HttpSessionListener {

	@Override
	public void sessionCreated(HttpSessionEvent arg0) {
		System.out.println("session初始化");
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent arg0) {
		System.out.println("session销毁");
		HttpSession session = arg0.getSession();
		User user = (User) session.getAttribute("user");
		//先获取application对象
		ServletContext application = session.getServletContext();
		//获取在线用户集合
		List<User> users = (List<User>) application.getAttribute("online");
		//从在线用户集合中移除当前退出的用户
		users.remove(user);
		//更新application对象中在线用户集合
		application.setAttribute("online", users);
	}

}
