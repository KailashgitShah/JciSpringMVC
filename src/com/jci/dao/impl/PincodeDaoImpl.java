package com.jci.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.jci.dao.PincodeDao;
import com.jci.model.PincodeModel;

@Transactional
@Repository
public class PincodeDaoImpl implements PincodeDao {

	@Autowired
	SessionFactory sessionFactory;
	protected Session currentSession(){
		return sessionFactory.getCurrentSession();
	}

	@Override
	public void create(PincodeModel pincode) {
		currentSession().save(pincode);

	}

	@Override
	public void update(PincodeModel pincode) {
		currentSession().update(pincode);

	}

	@Override
	public PincodeModel edit(int id) {
		return find(id);
	}

	@Override
	public PincodeModel find(int id) {
		return (PincodeModel) currentSession().get(PincodeModel.class, id);
	}

	@Override
	public List<PincodeModel> getAll() {
		Criteria c = this.sessionFactory.getCurrentSession().createCriteria(PincodeModel.class);
		List<PincodeModel> ll=c.list();
		return ll;
	}

	@Override
	public boolean submitform(PincodeModel pincode) {
		this.sessionFactory.getCurrentSession().save(pincode);
		return false;
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}

}
