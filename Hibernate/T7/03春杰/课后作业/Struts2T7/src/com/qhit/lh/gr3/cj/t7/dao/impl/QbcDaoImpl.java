/**
 * 
 */
package com.qhit.lh.gr3.cj.t7.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import com.qhit.lh.gr3.cj.t7.dao.QbcDao;
import com.qhit.lh.gr3.cj.t7.utils.HibernateSessionFactory;

/**
 * @author 03春杰 TODO 2017年12月25日上午10:09:26
 */
public class QbcDaoImpl implements QbcDao {

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.qhit.lh.gr3.cj.t7.dao.QbcDao#getObjectByEq(java.lang.Class,
	 * java.lang.String, int)
	 * 
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public List<Object> getObjectByEq(Class clazz, String string1, String string2) {

		Session session = HibernateSessionFactory.getSession(); // 获取session对象

		Criteria criteria = session.createCriteria(clazz).add(Restrictions.eq(string1, string2));

		List<Object> list = criteria.list();

		HibernateSessionFactory.closeSession(); // 关闭事务
		return list;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.qhit.lh.gr3.cj.t7.dao.QbcDao#getObjectByLike(java.lang.Class,
	 * java.lang.String, java.lang.String)
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public List<Object> getObjectByLike(Class clazz, String string1, Object string2) {
		Session session = HibernateSessionFactory.getSession(); // 获取session对象

		Criteria criteria = session.createCriteria(clazz).add(Restrictions.like(string1, string2));

		List<Object> list = criteria.list();

		HibernateSessionFactory.closeSession(); // 关闭事务
		return list;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.qhit.lh.gr3.cj.t7.dao.QbcDao#getObjectByLikeAndProjections(java.lang.
	 * Class, java.lang.String, java.lang.String)
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public List<Object[]> getObjectByLikeAndProjections(Class clazz, String string1, String string2,List<String> lists) {
		Session session = HibernateSessionFactory.getSession(); // 获取session对象

		Criteria criteria = session.createCriteria(clazz).add(Restrictions.like(string1, string2));
		
		
		ProjectionList projectionList = Projections.projectionList();
		for (String str : lists) {
			projectionList.add(Projections.property(str));
		}
		criteria.setProjection(projectionList);
		List<Object[]> list = criteria.list();

		return list;
	}

}
