package com.qhit.lh.gr3.cj.t2.action;

import java.util.List;

import com.opensymphony.xwork2.Action;
import com.qhit.lh.gr3.cj.t2.bean.Account;
import com.qhit.lh.gr3.cj.t2.service.BaseService;
import com.qhit.lh.gr3.cj.t2.service.impl.BaseServiceImpl;




/**
 * @author 03春杰
 * TODO
 * 2017年12月13日上午11:34:48	
 */
public class LoginAction implements Action {
	private BaseService baseService = new BaseServiceImpl();
	private String name;
	private String password;
	@Override
	public String execute() throws Exception {
		List list = (List) baseService.query("from Account");
		for (Object object : list) {
			Account account = (Account) object;
			if(password.equalsIgnoreCase( account.getPassword() ) &&name.equalsIgnoreCase( account.getUname() ) ){
				return SUCCESS;
			}	
		}
		return ERROR;
		
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	

}
