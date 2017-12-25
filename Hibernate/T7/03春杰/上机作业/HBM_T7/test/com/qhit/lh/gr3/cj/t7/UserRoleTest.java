/**
 * 
 */
package com.qhit.lh.gr3.cj.t7;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import com.qhit.lh.gr3.cj.t7.bean.Role;
import com.qhit.lh.gr3.cj.t7.bean.User;
import com.qhit.lh.gr3.cj.t7.service.BaseService;
import com.qhit.lh.gr3.cj.t7.service.impl.BaseServiceImpl;

/**
 * @author 03春杰 TODO 2017年12月20日上午9:52:47
 */
public class UserRoleTest {
	private BaseService baseservice = new BaseServiceImpl();

	@SuppressWarnings("unchecked")
	@Test
	public void add() {
		Role role = new Role();

		role.setRolename("部门负责人");
		role.setMemo("管理部门");

		User user1 = (User) baseservice.getObjectById(User.class, 1);
		User user2 = (User) baseservice.getObjectById(User.class, 2);

		role.getUsers().add(user1);
		role.getUsers().add(user2);

		baseservice.add(role);
	}

	@Test
	public void delete() {
		Role role = (Role) baseservice.getObjectById(Role.class, 7);
		baseservice.delete(role);
	}

	@SuppressWarnings("unchecked")
	@Test
	public void update() {
		Role role = (Role) baseservice.getObjectById(Role.class, 8);

		role.setMemo("管理部门人员");

		User user1 = (User) baseservice.getObjectById(User.class, 3);
		User user2 = (User) baseservice.getObjectById(User.class, 4);

		role.getUsers().add(user1);
		role.getUsers().add(user2);
		baseservice.update(role);
	}

	@Test
	public void query() {
		List<User> list = (List) baseservice.query("from User");
		for (User user : list) {
			System.out.println(user.toString());
		}
	}

	@Test
	public void getRole() {
		Role role = (Role) baseservice.getObjectById(Role.class, 3);
		System.out.println(role.toString());
		System.out.println("分配的账号");
		for (Object object : role.getUsers()) {
			System.out.println(object.toString());
		}
	}

	@Test
	public void getUser() {
		User user = (User) baseservice.getObjectById(User.class, 1);
		System.out.println(user.toString());
		System.out.println("分配的角色");
		for (Object object : user.getRoles()) {
			System.out.println(object.toString());
		}
	}
	
	//根据名字模糊查
		@Test
		public void getUserByName(){
			List<User> list=baseservice.getUserByName("%1%");
			for(User user : list){
				System.out.println(user.getUserid()+":"+user.getUsername());
				
			}
		}

}
