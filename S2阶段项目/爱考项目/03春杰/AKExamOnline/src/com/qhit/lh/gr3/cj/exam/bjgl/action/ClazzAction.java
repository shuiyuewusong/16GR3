package com.qhit.lh.gr3.cj.exam.bjgl.action;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
import com.qhit.lh.gr3.cj.exam.bjgl.bean.ClassInfo;
import com.qhit.lh.gr3.cj.exam.bjgl.service.ClazzService;
import com.qhit.lh.gr3.cj.exam.bjgl.service.ClazzServiceImpl;

/**类名:ClazzAction
  *创建时间:2018年3月13日
  *创建人:Disdain
  */
public class ClazzAction extends ActionSupport {
	private ClazzService clazzService = new ClazzServiceImpl();
	private List<ClassInfo> listClazz;

	public String getClazzList() {
		listClazz = clazzService.getClazzList();
		return "getClazzList";
	}

	public List<ClassInfo> getListClazz() {
		return listClazz;
	}

	public void setListClazz(List<ClassInfo> listClazz) {
		this.listClazz = listClazz;
	}
}
