package com.jci.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.jci.dao.FarmerRegistrationDao;
import com.jci.model.FarmerRegistrationModel;
@Transactional
@Repository

public class FarmerRegistrationDaoImpl implements FarmerRegistrationDao {

	@Autowired
	SessionFactory sessionFactory;
	protected Session currentSession(){
		return sessionFactory.getCurrentSession();
	}

	@Override
	public void create(FarmerRegistrationModel farmerRegistrationModel) {
		currentSession().saveOrUpdate(farmerRegistrationModel);
	}

	@Override
	public void update(FarmerRegistrationModel farmerRegistrationModel) {
		currentSession().update(farmerRegistrationModel);
	}

	@Override
	public FarmerRegistrationModel edit(int id) {
		return find(id);
	}

	@Override
	public void delete(int id) {
		FarmerRegistrationModel farmerRegistrationModel = new FarmerRegistrationModel();
		String hql = "Delete from dbo.bna where id = '"+id+"' " ;
		this.sessionFactory.getCurrentSession().createSQLQuery(hql).executeUpdate();
	}

	@Override
	public FarmerRegistrationModel find(int id) {
		return (FarmerRegistrationModel) currentSession().get(FarmerRegistrationModel.class, id);
	}

	@Override
	public List<FarmerRegistrationModel> getAll() {
		Criteria c = this.sessionFactory.getCurrentSession().createCriteria(FarmerRegistrationModel.class);
		List<FarmerRegistrationModel> ll=c.list();
		return ll;
	}

	@Override
	public boolean submitform(FarmerRegistrationModel off) {
		this.sessionFactory.getCurrentSession().save(off);
		return false;
	}
}
