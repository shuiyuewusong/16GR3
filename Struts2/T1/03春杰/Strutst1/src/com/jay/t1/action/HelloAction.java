package com.jay.t1.action;

import com.opensymphony.xwork2.Action;

public class HelloAction implements Action {
	private String  content;//保存回应结果数据
	private String uname;//获取表单提交的参数
	
	
	@Override
	public String execute() throws Exception {
		content = "你好"+uname;
		
		return Action.SUCCESS ;
	}


	public String getContent() {
		return content;
	}


	public void setContent(String content) {
		this.content = content;
	}


	public String getUname() {
		return uname;
	}


	public void setUname(String uname) {
		this.uname = uname;
	}
			
}
