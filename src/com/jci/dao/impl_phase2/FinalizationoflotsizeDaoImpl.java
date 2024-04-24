package com.jci.dao.impl_phase2;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import com.jci.dao_phase2.FinalizationoflotsizeDao;
import com.jci.model.CreationofBidOfferingModel;
import com.jci.model.FinalizationoflotsizerspModel;

@Transactional
@Repository
public class FinalizationoflotsizeDaoImpl implements FinalizationoflotsizeDao{


	@Autowired
	SessionFactory sessionFactory;
	protected Session currentSession(){
		return sessionFactory.getCurrentSession();
	}
	@Override
	public void create(FinalizationoflotsizerspModel FinalizationoflotrspModel) {
		// TODO Auto-generated method stub
		currentSession().save(FinalizationoflotrspModel);
	}
	@Override
	public List<FinalizationoflotsizerspModel> getAlllist() {
		// TODO Auto-generated method stub
		Criteria c = this.sessionFactory.getCurrentSession().createCriteria(FinalizationoflotsizerspModel.class);
		List<FinalizationoflotsizerspModel> ll=c.list();
		return ll;
	}
	@Override
	public void update(FinalizationoflotsizerspModel FinalizationoflotrspModel) {
		// TODO Auto-generated method stub
		currentSession().update(FinalizationoflotrspModel);
		
	}
	
}
