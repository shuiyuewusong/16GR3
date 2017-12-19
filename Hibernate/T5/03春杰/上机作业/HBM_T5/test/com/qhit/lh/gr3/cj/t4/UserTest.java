package com.qhit.lh.gr3.cj.t4;

import static org.junit.Assert.*;

import org.junit.Test;

import com.qhit.lh.gr3.cj.t4.bean.User;
import com.qhit.lh.gr3.cj.t4.bean.Work;
import com.qhit.lh.gr3.cj.t4.service.BaseService;
import com.qhit.lh.gr3.cj.t4.service.impl.BaseServiceImpl;


/**
 * @author 03春杰
 * TODO
 * 2017年12月19日下午5:33:37	
 */
public class UserTest {

	private BaseService baseService = new BaseServiceImpl();

	@Test
	public void add() {
		// 创建部门
		Work work = new Work();
		work.setWorkname("政治部");
		// 没有员工

		// 有新员工
		User dwj = new User();
		dwj.setUname("董文君");
		dwj.setSex("M");

		User wjw = new User();
		wjw.setUname("王军伟");
		wjw.setSex("M");

		work.getUsers().add(wjw);
		work.getUsers().add(dwj);
		// do
		baseService.add(work);
	}

	@Test
	public void delete() {
		Work work = (Work) baseService.getObjectById(Work.class, 4);

		baseService.delete(work);
	}

	@Test
	public void update() {
		Work work = (Work) baseService.getObjectById(Work.class, 2);
		work.setWorkname("驻美中国大使馆");

		baseService.update(work);
	}

	@Test
	public void query() {
		Work work = (Work) baseService.getObjectById(Work.class, 7);

		for (User user : work.getUsers()) {
			System.out.println(user.toString());
		}
	}
}
