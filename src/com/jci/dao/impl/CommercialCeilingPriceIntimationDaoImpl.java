package com.jci.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.jci.dao.CommercialCeilingPriceIntimationDao;
import com.jci.model.CommercialCeilingPriceIntimationModel;


@Transactional
@Repository
public class CommercialCeilingPriceIntimationDaoImpl implements CommercialCeilingPriceIntimationDao {

	@Autowired
	SessionFactory sessionFactory;
	protected Session currentSession(){
		return sessionFactory.getCurrentSession();
	}



	@Override
	public void create(CommercialCeilingPriceIntimationModel commercialCeilingPriceIntimationModel) {
		currentSession().save(commercialCeilingPriceIntimationModel);
	}

	@Override
	public void update(CommercialCeilingPriceIntimationModel commercialCeilingPriceIntimationModel) {
		currentSession().save(commercialCeilingPriceIntimationModel);

	}

	@Override
	public CommercialCeilingPriceIntimationModel edit(int id) {
		return find(id);
	}

	@Override
	public void delete(int id) {
		String hql = "Delete from dbo.jcicomme where refid= '"+id+"' " ;
		this.sessionFactory.getCurrentSession().createSQLQuery(hql).executeUpdate();
	}

	@Override
	public CommercialCeilingPriceIntimationModel find(int id) {
		return (CommercialCeilingPriceIntimationModel) currentSession().get(CommercialCeilingPriceIntimationModel.class, id);
	}

	@Override
	public List<CommercialCeilingPriceIntimationModel> getAll() {
		Criteria c = this.sessionFactory.getCurrentSession().createCriteria(CommercialCeilingPriceIntimationModel.class);
		List<CommercialCeilingPriceIntimationModel> ll=c.list();
		return ll;
	}

	@Override
	public boolean submitform(CommercialCeilingPriceIntimationModel commercialCeilingPriceIntimationModel) {
		this.sessionFactory.getCurrentSession().save(commercialCeilingPriceIntimationModel);
		return false;
	}

}
