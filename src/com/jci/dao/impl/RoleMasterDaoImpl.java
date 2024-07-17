package com.jci.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.jci.dao.RoleMasterDao;
import com.jci.model.RoleMasterModel;

@Transactional
@Repository
public class RoleMasterDaoImpl implements RoleMasterDao{

	@Autowired
	SessionFactory sessionFactory;
	protected Session currentSession(){
		return sessionFactory.getCurrentSession();
	}

	@Override
	public void create(RoleMasterModel roleMaster) {
		currentSession().save(roleMaster);
	}

	@Override
	public void update(RoleMasterModel roleMaster) {
		currentSession().update(roleMaster);

	}

	@Override
	public RoleMasterModel edit(int id) {
		return find(id);
	}


	@Override
	public RoleMasterModel find(int id) {
		return (RoleMasterModel) currentSession().get(RoleMasterModel.class, id);
	}

	@Override
	public List<RoleMasterModel> getAll() {
		Criteria c = this.sessionFactory.getCurrentSession().createCriteria(RoleMasterModel.class);
		List<RoleMasterModel> ll=c.list();
		return ll;
	}

	@Override
	public boolean submitform(RoleMasterModel roleMaster) {
		this.sessionFactory.getCurrentSession().save(roleMaster);
		return false;
	}

	

}
