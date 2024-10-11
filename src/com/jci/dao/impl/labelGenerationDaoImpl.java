package com.jci.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.jci.dao.labelGenerationDao;
import com.jci.model.Contractgeneration;
import com.jci.model.JbaModel;
import com.jci.model.labelGenerationModel;

@Transactional
@Repository
public class labelGenerationDaoImpl implements labelGenerationDao {

	@Autowired
	SessionFactory sessionFactory;
	
	protected Session currentSession() {
		return sessionFactory.getCurrentSession();
	}
	
	@Override
	public void create(labelGenerationModel label) {
		// TODO Auto-generated method stub
		currentSession().save(label);
	}

	@Override
	public void update(labelGenerationModel label) {
		// TODO Auto-generated method stub
		currentSession().update(label);
	}

	@Override
	public labelGenerationModel edit(int id) {
		// TODO Auto-generated method stub
		return find(id);
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		String hql = " Delete from dbo.labelGeneration where id = '"+id+"' " ;
		 this.sessionFactory.getCurrentSession().createSQLQuery(hql).executeUpdate();
	}

	@Override
	public labelGenerationModel find(int id) {
		// TODO Auto-generated method stub
		return (labelGenerationModel) currentSession().get(labelGenerationModel.class, id);
	}

	@Override
	public List<labelGenerationModel> getAll() {
		// TODO Auto-generated method stub
		Criteria c = this.sessionFactory.getCurrentSession().createCriteria(labelGenerationModel.class);
		List<labelGenerationModel> ll=c.list();
		return ll;
	}

}
