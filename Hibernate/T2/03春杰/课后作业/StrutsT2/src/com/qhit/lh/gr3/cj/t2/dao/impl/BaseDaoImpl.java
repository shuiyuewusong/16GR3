/**
 * 
 */
package com.qhit.lh.gr3.cj.t2.dao.impl;

import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.qhit.lh.gr3.cj.t2.dao.BaseDao;
import com.qhit.lh.gr3.cj.t2.utils.HibernateSessionFactory;



/**
 * @author 03春杰
 * TODO
 * 2017年12月11日上午9:50:40	
 */
public class BaseDaoImpl implements BaseDao {
	
	
	
	/* (non-Javadoc)
	 * @see com.qhit.lh.gr3.cj.hb_t1.dao.BaseDao#add(java.lang.Object)
	 */
	@Override
	public void add(Object object) {
		Session session = HibernateSessionFactory.getSession();			//获取session对象
		Transaction transaction = session.beginTransaction();			//开机事务transaction
		session.save(object);					//传入参数
		transaction.commit();					//提交事务
		HibernateSessionFactory.closeSession();	//提交事务
						
	}

	/* (non-Javadoc)
	 * @see com.qhit.lh.gr3.cj.hb_t1.dao.BaseDao#delete(java.lang.Object)
	 */
	@Override
	public void delete(Object object) {
		Session session = HibernateSessionFactory.getSession();			//获取session对象
		Transaction transaction = session.beginTransaction();			//开机事务transaction
		session.delete(object);					//传入参数
		transaction.commit();					//提交事务
		HibernateSessionFactory.closeSession();	//提交事务

	}

	/* (non-Javadoc)
	 * @see com.qhit.lh.gr3.cj.hb_t1.dao.BaseDao#update(java.lang.Object)
	 */
	@Override
	public void update(Object object) {
		Session session = HibernateSessionFactory.getSession();			//获取session对象
		Transaction transaction = session.beginTransaction();			//开机事务transaction
		session.update(object);					//传入参数
		transaction.commit();					//提交事务
		HibernateSessionFactory.closeSession();	//提交事务

	}

	/* (non-Javadoc)
	 * @see com.qhit.lh.gr3.cj.hb_t1.dao.BaseDao#query(java.lang.String)
	 */
	@Override
	public List<Object> query(String formtable) {
		Session session = HibernateSessionFactory.getSession();			//获取session对象
		Transaction transaction = session.beginTransaction();			//开机事务transaction
		Query query = session.createQuery(formtable);	//获取查询对象
		List<Object> list = query.list();				//获取数据
		transaction.commit();							//提交事务
		HibernateSessionFactory.closeSession();			//提交事务
		return list;									//返回参数
	}

	/* (non-Javadoc)
	 * @see com.qhit.lh.gr3.cj.t2.dao.BaseDao#getObjectById(java.lang.Object, int)
	 */
	@Override
	public Object getObjectById(Object object, int id) {
		//1,获取session对象
		Session session = HibernateSessionFactory.getSession();
		//2，开启事务
		Transaction ts = session.beginTransaction();
		//3，获取查询器对象
		object = session.get(object.getClass(), id);
		//4,提交事务
		ts.commit();
		//5，释放资源
		HibernateSessionFactory.closeSession();
		return object;
	}
	


}
