package com.qhit.lh.gr3.cj.exam.tkgl.dao;

import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Transaction;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import com.qhit.lh.gr3.cj.exam.common.bean.PageBean;
import com.qhit.lh.gr3.cj.exam.common.dao.BaseDao;
import com.qhit.lh.gr3.cj.exam.kmgl.bean.Course;
import com.qhit.lh.gr3.cj.exam.tkgl.bean.WrittenQuestion;

/**类名:QuestionDaoImpl
  *创建时间:2018年3月13日
  *创建人:Disdain
  */
public class QuestionDaoImpl extends BaseDao implements QuestionDao {

	@Override
	public List<Course> getCourseInfo(Map parameter) {
		StringBuffer hql = new StringBuffer();
		hql.append("select course from Course course where 1 = 1");
		//拼接HQL
		if(parameter.get("major") != null && !"".equals(parameter.get("major"))){
			hql.append(" and course.major = :major");
		}
		if(parameter.get("stage") != null && !"".equals(parameter.get("stage"))){
			hql.append(" and course.stage = :stage");
		}
		//获取查询器
		Query query = getSession().createQuery(hql.toString());
		//设置参数
		if(parameter.get("major") != null && !"".equals(parameter.get("major"))){
			query.setString("major", (String) parameter.get("major"));
		}
		if(parameter.get("stage") != null && !"".equals(parameter.get("stage"))){
			query.setString("stage", (String) parameter.get("stage"));
		}
		//执行查询
		return query.list();
	}

	@Override
	public PageBean<WrittenQuestion> getWrittenList(
			PageBean<WrittenQuestion> pageBean, 
			Course course,
			int pageIndex) {
		//hql语句
		StringBuffer hql = new StringBuffer();
		hql.append("select w from WrittenQuestion w where w.csId = :csId");
		//获取查询器
		Query query = getSession().createQuery(hql.toString());
		//设置分页查询参数
		query.setInteger("csId", course.getCsId());
		//总记录数
		int count = query.list().size();
		pageBean.setTotalNumber(count);
		pageBean.setCurrentIndex(pageIndex);
		//当前页数据
		List<WrittenQuestion> items = query.setFirstResult((pageBean.getCurrentIndex()-1)*pageBean.getPageSize())
				.setMaxResults(pageBean.getPageSize())
				.list();
		//设置pagebean的数据集合
		pageBean.setItems(items);
		
		return pageBean;
	}

	@Override
	public void addWrittenQuestion(WrittenQuestion writtenQuestion) {
		//开启事务
		Transaction ts = getSession().beginTransaction();
		//执行添加，返回新纪录的主键
		long id = (Integer) getSession().save(writtenQuestion);
		//提交事务
		ts.commit();
	}

	@Override
	public WrittenQuestion getWrittenQuestionById(
			WrittenQuestion writtenQuestion) {
		
		return (WrittenQuestion) getSession().get(WrittenQuestion.class, writtenQuestion.getQid());
	}

	@Override
	public void updateWrittenQuestion(WrittenQuestion writtenQuestion) {
		//清除session中缓存对象:http://blog.csdn.net/jayliu1989/article/details/78979022
		getSession().clear();
		Transaction ts = getSession().beginTransaction();
		getSession().update(writtenQuestion);
		ts.commit();
	}
	
	@Override
	public void inportWrittenQuestions(List<WrittenQuestion> listWQuestions) {
		//开启事务
		Transaction ts = getSession().beginTransaction();
		for (WrittenQuestion writtenQuestion : listWQuestions) {
			//执行添加，返回新纪录的主键
			getSession().save(writtenQuestion);
		}
		//提交事务
		ts.commit();
	}

	@Override
	public int getQuestionsMax(int csId,String qtype,String degree) {
		// TODO Auto-generated method stub
		Criteria criteria = getSession().createCriteria(WrittenQuestion.class)
				.add(Restrictions.eq("csId", csId))
				.add(Restrictions.eq("qtype", qtype))
				.add(Restrictions.eq("degree", degree));
		
		ProjectionList projectionList = Projections.projectionList()
				.add(Projections.count("qid"));
		
		criteria.setProjection(projectionList);
		long num = (long) criteria.list().get(0);
		return (int)num;
	}

	@Override
	public List<WrittenQuestion> getQuestionsByType(int csId, String qtype,
			String degree) {
		Criteria criteria = getSession().createCriteria(WrittenQuestion.class)
				.add(Restrictions.eq("csId", csId))
				.add(Restrictions.eq("qtype", qtype))
				.add(Restrictions.eq("degree", degree));
		
		return criteria.list();
	}

}
