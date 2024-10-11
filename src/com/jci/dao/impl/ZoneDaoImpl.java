package com.jci.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.jci.dao.ZoneDao;
import com.jci.model.FarmerRegistrationModel;
import com.jci.model.ZoneModel;

@Transactional
@Repository
public class ZoneDaoImpl implements ZoneDao{

	@Autowired
	SessionFactory sessionFactory;
	protected Session currentSession(){
		return sessionFactory.getCurrentSession();
	}

	@Override
	public void create(ZoneModel zone) {
		currentSession().save(zone);
	}

	@Override
	public void update(ZoneModel zone) {
		currentSession().update(zone);
	}

	@Override
	public ZoneModel edit(int id) {
		return find(id);
	}

	@Override
	public void delete(int id) {
		FarmerRegistrationModel farmerRegistrationModel = new FarmerRegistrationModel();
		String hql = "Delete from dbo.bna where id = '"+id+"' " ;
		this.sessionFactory.getCurrentSession().createSQLQuery(hql).executeUpdate();
	}

	@Override
	public ZoneModel find(int id) {
		return (ZoneModel) currentSession().get(ZoneModel.class, id);
	}

	@Override
	public List<ZoneModel> getAll() {
		Criteria c = this.sessionFactory.getCurrentSession().createCriteria(ZoneModel.class);
		List<ZoneModel> ll=c.list();
		return ll;
	}

	@Override
	public boolean submitform(ZoneModel zone) {
		this.sessionFactory.getCurrentSession().save(zone);
		return false;
	}
}
