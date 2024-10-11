package com.jci.dao.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.jci.dao.PurchaseCenterDao;
import com.jci.model.PurchaseCenterModel;
import com.jci.model.RoDetailsModel;

@Transactional
@Repository
public class PurchaseCenterDaoImpl implements PurchaseCenterDao {

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
		return null;
	}

	@Override
	public boolean submitform(RoDetailsModel roDetails) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<String> purchaseCenter(String region,String role) {
		List<String> result = new ArrayList<>();
		String querystr = "";
		if(role.equals("54-Co Operative"))
		{
			 querystr = "select * from jcipurchasecenter where rocode ='"+region+"'and centertypecode in ('C')";
		}
		else
		{
		 querystr = "select * from jcipurchasecenter where rocode ='"+region+"'and centertypecode in ('D', 'S')";
		}
		
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		SQLQuery query = session.createSQLQuery(querystr);
		List<Object[]> rows = query.list();
		for(Object[] row : rows){
			//System.out.println(row[0].toString());
			result.add(row[1].toString()+"-"+row[4].toString());
		}
		return result;
	}



	@Override
	public List<String> dpcbyid(String dpc) {

		List<String> result = new ArrayList<>();
		
		String querystr = "select centername from jcipurchasecenter where CENTER_CODE in ("+dpc+")";
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		SQLQuery query = session.createSQLQuery(querystr);
		List<String> rows = query.list();
		System.out.println(rows.toString());


		return rows;
	}
	
	
	
	@Override
	public List<String> getAllDpc() {
		List<String> result = new ArrayList<>();
		String querystr = "select * from jcipurchasecenter";
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		SQLQuery query = session.createSQLQuery(querystr);
		List<Object[]> rows = query.list();
		for(Object[] row : rows){
			result.add(row[0].toString()+"-"+row[1].toString());
		}
		return result;
	}

	@Override
	public String findDpcname(String dpccode) {
	
		String querystr = "SELECT centername FROM jcipurchasecenter where center_code = '"+dpccode+"'";
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		SQLQuery query = session.createSQLQuery(querystr);
		List<Object> rows = query.list();
		String result = (String)rows.get(0);
		
		return result;
	}

	@Override
	public Map<String, String> getdpcbyregionid(String regionid) {
		// TODO Auto-generated method stub

		Map<String,String> result = new HashMap<>();
		String querystr = "select CENTER_CODE,centername from jcipurchasecenter where rocode = '"+regionid+"'";
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		SQLQuery query = session.createSQLQuery(querystr);
		List<Object[]> rows = query.list();
		for(Object[] row : rows){
			//result.add(row[0].toString()+"-"+row[1].toString());
			result.put(row[0].toString(), row[1].toString());
		}
		System.out.println("Map result"+result);
		return result;
	
	}

	@Override
	public float findNominalWt(String dpc) {
		String querystr = "SELECT nominal_wt FROM jcipurchasecenter where center_code = '"+dpc+"'";
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		SQLQuery query = session.createSQLQuery(querystr);
		List<Object> rows = query.list();
		 Double resultDouble = (Double) rows.get(0); // Cast to Double
		    float result = resultDouble.floatValue();
		    return result;
	}
	

	@Override
	public String findDpIdbyName(String dpc) {
		String querystr = "SELECT  center_code FROM jcipurchasecenter where centername = '"+dpc+"'";
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		SQLQuery query = session.createSQLQuery(querystr);
		List<Object> rows = query.list();
		String result = (String)rows.get(0);
		
		return result;
	}
}
