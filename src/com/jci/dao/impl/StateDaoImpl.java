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

import com.jci.dao.StateDao;
import com.jci.model.StateList;
@Transactional
@Repository
public class StateDaoImpl implements StateDao {
	@Autowired
	SessionFactory sessionFactory;
	protected Session currentSession(){
		return sessionFactory.getCurrentSession();
	}



	@Override
	public void create(StateList statelist) {
		currentSession().save(statelist);

	}

	@Override
	public void update(StateList statelist) {
		currentSession().update(statelist);

	}

	@Override
	public StateList edit(int id) {
		return find(id);
	}

	@Override
	public void delete(int id) {
		currentSession().delete(id);

	}

	@Override
	public StateList find(int id) {
		return (StateList) currentSession().get(StateList.class, id);
	}

	@Override
	public List<StateList> getAll() {
		//System.out.println("Hello From StateListModel");
		List<StateList> ll;
		Criteria c = this.sessionFactory.getCurrentSession().createCriteria(StateList.class);
		ll=c.list();
		return ll;
	}

	@Override
	public boolean submitform(StateList off) {
		this.sessionFactory.getCurrentSession().save(off);
		return false;
	}



	@Override
	public String statebyid(String state_name) {
		// TODO Auto-generated method stub
		String State = "";
		String querystr = "select state_name from tbl_states where state_code='"+state_name+"'";
    	   Session session = sessionFactory.getCurrentSession();
    	   Transaction tx = session.beginTransaction();
    	   SQLQuery query = session.createSQLQuery(querystr);
    	   List<String> stateid= query.list();
    	   System.err.println("stateid+stateid"+stateid);
    	   if (!stateid.isEmpty()) {
    		   State = stateid.get(0);
           } 
		return State;
	}

}
