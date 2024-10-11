package com.jci.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.jci.dao.SalesDao;
import com.jci.model.FarmerRegistrationModel;
import com.jci.model.SalesModel;


@Transactional
@Repository
public class SalesDaoImpl implements SalesDao{

	@Autowired
	SessionFactory sessionFactory;
	protected Session currentSession(){
		return sessionFactory.getCurrentSession();
	}

	@Override
	public void create(SalesModel salesModel) {
		currentSession().save(salesModel);
	}

	@Override
	public void update(SalesModel salesModel) {
		currentSession().update(salesModel);
	}

	@Override
	public SalesModel edit(int id) {
		return find(id);
	}

	@Override
	public void delete(int id) {
		FarmerRegistrationModel farmerRegistrationModel = new FarmerRegistrationModel();
		String hql = "Delete from dbo.bna where id = '"+id+"' " ;
		this.sessionFactory.getCurrentSession().createSQLQuery(hql).executeUpdate();

	}

	@Override
	public SalesModel find(int id) {
		return (SalesModel) currentSession().get(SalesModel.class, id);
	}

	@Override
	public List<SalesModel> getAll() {
		Criteria c = this.sessionFactory.getCurrentSession().createCriteria(SalesModel.class);
		List<SalesModel> ll=c.list();
		return ll;
	}

	@Override
	public boolean submitform(SalesModel salesModel) {
		this.sessionFactory.getCurrentSession().save(salesModel);
		return false;
	}
}
