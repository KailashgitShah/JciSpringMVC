package com.jci.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.jci.dao.CommercialJuteVarietyGradesPriceDao;
import com.jci.model.CommercialJuteVarietyModel;

@Transactional
@Repository
public class CommercialJuteVarietyGradesPriceDaoImpl implements CommercialJuteVarietyGradesPriceDao {

	@Autowired
	SessionFactory sessionFactory;
	protected Session currentSession(){
		return sessionFactory.getCurrentSession();
	}

	@Override
	public void create(CommercialJuteVarietyModel commercialJuteVarietyModel) {
		System.out.println("########### "+commercialJuteVarietyModel);
		currentSession().saveOrUpdate(commercialJuteVarietyModel);
	}

	@Override
	public List<CommercialJuteVarietyModel> getAll() {
		Criteria c = this.sessionFactory.getCurrentSession().createCriteria(CommercialJuteVarietyModel.class);
		List<CommercialJuteVarietyModel> ll=c.list();
		return ll;
	}

	@Override
	public void delete(int id) {
		String hql = "Delete from dbo.jcijutepricesforcommercial where id= '"+id+"' " ;
		this.sessionFactory.getCurrentSession().createSQLQuery(hql).executeUpdate();
	}

}
