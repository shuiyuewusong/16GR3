/**
 * 
 */
package com.qhit.lh.gr3.cj.exam.common.interceptor;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import com.qhit.lh.gr3.cj.exam.common.bean.User;
import com.qhit.lh.gr3.cj.exam.common.utils.Constans;

/**类名:LoginInterceptor
  *创建时间:2018年3月13日
  *创建人:Disdain
  */
public class LoginInterceptor extends AbstractInterceptor {

	@Override
	public String intercept(ActionInvocation arg0) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("登录校验拦截器执行");
		User user = (User) ServletActionContext.getRequest().getSession().getAttribute("user");
		if(user == null){
			//未登录
			return Constans.VIEW_LOGIN;
		}
		return arg0.invoke();
	}

}
