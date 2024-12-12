package com.jci.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.jci.dao.UserActionDao;
import com.jci.model.UserActionModel;
import com.jci.model.UserRoleModel;

@Transactional
@Repository
public class UserActionDaoImpl implements UserActionDao {

	@Autowired
	SessionFactory sessionFactory;

	protected Session currentSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public void create(UserActionModel useraction) {
		currentSession().save(useraction);

	}

	@Override
	public List<UserActionModel> getAll() {
		Criteria c = this.sessionFactory.getCurrentSession().createCriteria(UserActionModel.class);
		List<UserActionModel> ll = c.list();
		return ll;
	}

	@Override
	public Integer getactionid(String useraction) {
		Integer getId = 0;
		String querystr = "select action_id from jciuseraction where action_name='" + useraction + "'";
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		SQLQuery query = session.createSQLQuery(querystr);
		List<Integer> actionId = query.list();
		getId = actionId.get(0);

		return getId;
	}

	@Override
	public void deleteAction(String actionname) {
		// TODO Auto-generated method stub
		String hql = "Delete from jciuseraction where action_name = '" + actionname + "' ";
		this.sessionFactory.getCurrentSession().createSQLQuery(hql).executeUpdate();
	}

}
