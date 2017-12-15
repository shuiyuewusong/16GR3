/**
 * 
 */
package com.qhit.lh.gr3.cj.t3.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import com.qhit.lh.gr3.cj.t3.service.BaseService;
import com.qhit.lh.gr3.cj.t3.service.impl.BaseServiceImpl;
import com.qhit.lh.gr3.cj.t3.bean.Account;
import com.qhit.lh.gr3.cj.t3.bean.User;
import com.qhit.lh.gr3.cj.t3.bean.Work;

/**
 * @author 03春杰
 * TODO
 * 2017年12月13日上午10:00:35	
 */
public class AllTest {
	private BaseService baseService = new BaseServiceImpl();

	/**
	 * 添加员工，并分配一个账户
	 */
	@Test
	public void add() {
		//声明员工对象
		User user = new User();
		user.setUname("张2");
		user.setSex("男");
		//分配一个账户
		Account account = new Account();

		account.setUname("zhang2");
		account.setPassword("123456");
		//建立一对一关系
		user.setAccount(account);//指定当前员工的账户
		account.setUser(user);//指定当前账户所属的员工
		
		Work work = new Work();
		work = (Work) baseService.getObjectById(work, 1);
		
		user.setWork(work);
		//级联操作
		baseService.add(user);

	}

	@Test
	public void delete() {
		User user = new User();
		user = (User) baseService.getObjectById(user,1);
		baseService.delete(user);
	}

	@Test
	public void update() {
		//声明员工对象
		User user = new User();
		user = (User) baseService.getObjectById(user, 1);
		user.setUname("张6");
		user.setSex("男");

		//分配一个账户
		Account account = user.getAccount();
		account.setUname("zhang6");
		account.setPassword("123456");

		//建立一对一关系
		user.setAccount(account);//指定当前员工的账户
		account.setUser(user);//指定当前账户所属的员工
		
		Work work = new Work();
		work = (Work) baseService.getObjectById(work, 1);
		user.setWork(work);
		
		//级联操作
		baseService.update(user);
	}

	@Test
	public void query() {
		List<Object> list = baseService.query("from User");
		
		for (Object object : list) {
			User user = (User) object;
			System.out.println(user.toString());
		}
	}
}
