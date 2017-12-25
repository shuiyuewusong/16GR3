package com.qhit.lh.gr3.cj.t7.dao.impl;

import java.util.List;


import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.qhit.lh.gr3.cj.t7.bean.User;
import com.qhit.lh.gr3.cj.t7.dao.BaseDao;
import com.qhit.lh.gr3.cj.t7.utils.HibernateSessionFactory;



/**
 * @author 03春杰
 * TODO
 * 2017年12月20日上午9:36:30	
 */
public class BaseDaoImpl implements BaseDao {
	
	
	

	/* (non-Javadoc)
	 * @see com.qhti.chunjie.dao.BaseDao#add(java.lang.Object)
	 * 添加数据
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
	 * @see com.qhti.chunjie.dao.BaseDao#delete(java.lang.Object)
	 * 删除数据
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
	 * @see com.qhti.chunjie.dao.BaseDao#update(java.lang.Object)
	 * 修改数据
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
	 * @see com.qhti.chunjie.dao.BaseDao#query(java.lang.String)
	 * 查询数据
	 */
	@Override
	public List<Object> query(String formtable) {
		Session session = HibernateSessionFactory.getSession();			//获取session对象
		Transaction transaction = session.beginTransaction();			//开机事务transaction
		Query query = session.createQuery(formtable);	//获取查询对象
		@SuppressWarnings("unchecked")
		List<Object> list = query.list();				//获取数据
		transaction.commit();							//提交事务
		HibernateSessionFactory.closeSession();			//提交事务
		return list;									//返回参数
	}


	/* (non-Javadoc)
	 * @see com.qhti.chunjie.dao.BaseDao#getObjectById(java.lang.Object, int)
	 * 根据id去查
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public Object getObjectById(Class clazz, int id) {
		//1,获取session对象
		Session session = HibernateSessionFactory.getSession();
		//2，开启事务
		Transaction ts = session.beginTransaction();
		//3，获取查询器对象
		Object object = session.get(clazz, id);
		//4,提交事务
		ts.commit();
		//5，释放资源
		HibernateSessionFactory.closeSession();
		return object;
	}
	
	/* (non-Javadoc)
	 * @see com.qhit.lh.gr3.cj.t7.dao.BaseDao#getUserByName(java.lang.String)
	 * 根据名字模糊查
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<User> getUserByName(String name){
		String hql="select u from User u where u.username like :name";
		Session session = HibernateSessionFactory.getSession();
		//2，开启事务
		Transaction ts = session.beginTransaction();
		//3，获取查询器对象
		Query query=session.createQuery(hql);
			//类似预编译陈述对象赋值
		query.setString("name", name);
		List<User> list=query.list();
		//4,提交事务
		ts.commit();
		//5，释放资源
		HibernateSessionFactory.closeSession();
		return list;
	}
}
