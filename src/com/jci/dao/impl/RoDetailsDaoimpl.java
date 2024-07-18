package com.jci.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.jci.dao.RoDetailsDao;
import com.jci.model.RoDetailsModel;
import com.jci.model.ZoneModel;

@Transactional
@Repository
public class RoDetailsDaoimpl implements RoDetailsDao {

	@Autowired
	SessionFactory sessionFactory;

	protected Session currentSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public void create(RoDetailsModel roDetails) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(RoDetailsModel roDetails) {
		// TODO Auto-generated method stub

	}

	@Override
	public RoDetailsModel edit(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub

	}

	@Override
	public RoDetailsModel find(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<RoDetailsModel> getAll() {
		// TODO Auto-generated method stub
		Criteria c = this.sessionFactory.getCurrentSession().createCriteria(RoDetailsModel.class);
		List<RoDetailsModel> ll=c.list();
		return ll;
	}

	@Override
	public boolean submitform(RoDetailsModel roDetails) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<String> zonecode(String zoneCode) {
		List<String> result = new ArrayList<>();
		String querystr = "select * from jcirodetails where zonecode ='" + zoneCode + "'";
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		SQLQuery query = session.createSQLQuery(querystr);
		List<Object[]> rows = query.list();
		for(Object[] row : rows){
			result.add(row[2].toString()+"-"+row[3].toString());
		}
		return result;
	}

	@Override
	public String getRoname(String region_id) {
		// TODO Auto-generated method stub

		String querystr = "select roname from jcirodetails where rocode ='" + region_id + "'";
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		SQLQuery query = session.createSQLQuery(querystr);
		String region = query.list().get(0).toString();
		return region;

	}
	
	public String findregionbyname(String region) {
		String querystr = "select rocode from jcirodetails where roname ='" + region + "'";
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		SQLQuery query = session.createSQLQuery(querystr);
		String regions = query.list().get(0).toString();
		return regions;
	}
	
	@Override
	public String getregionIdbyName(String region) {
		String querystr = "select rocode from jcirodetails where roname ='" + region + "'";
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		SQLQuery query = session.createSQLQuery(querystr);
		String regions = query.list().get(0).toString();
		return regions;

}
}
