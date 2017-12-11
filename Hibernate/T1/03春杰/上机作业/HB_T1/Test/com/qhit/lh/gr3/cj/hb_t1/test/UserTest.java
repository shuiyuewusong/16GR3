/**
 * 
 */
package com.qhit.lh.gr3.cj.hb_t1.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import com.qhit.lh.gr3.cj.hb_t1.bean.User;
import com.qhit.lh.gr3.cj.hb_t1.service.BaseService;
import com.qhit.lh.gr3.cj.hb_t1.service.impl.BaseServiceImpl;

/**
 * @author 03春杰
 * TODO
 * 2017年12月11日上午10:27:10	
 */
public class UserTest {
	private BaseService baseService = new BaseServiceImpl();
	/**
	 * 查询
	 */

	@Test
	public void query() {
		List<Object> list = baseService.query("from User");
		for (Object object : list) {
			User user  = (User) object;
			System.out.println(user.toString());
		}
	}
	/**
	 * 添加
	 */
	@Test
	public  void add(){
		User user = new User("fmfmffmfmf","2222222","1997","f",1 );
		baseService.add(user);
	}
	/**
	 * 修改
	 */
	@Test
	public void update(){
		User user = new User(4,"rtrtrtrf","222trt2222","19r97","f",0 );
		baseService.update(user);
		
	}
	
	/**
	 * 删除
	 */
	@Test
	public void delete(){
		User user = new User();
		user.setId(10);
		baseService.delete(user);
		
	}


}
