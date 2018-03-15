/**
 * 
 */
package com.qhit.lh.gr3.cj.exam.common.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.qhit.lh.gr3.cj.exam.common.utils.HibernateSessionFactory;

/**类名:BaseDao
  *创建时间:2018年3月13日
  *创建人:Disdain
  */
public class BaseDao {

	public Session getSession(){
		return HibernateSessionFactory.getSession();
	}
}
