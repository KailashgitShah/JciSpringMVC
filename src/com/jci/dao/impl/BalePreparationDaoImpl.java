package com.jci.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.jci.dao.BalePreparationdao;
import com.jci.model.BalePreparation;

@Transactional
@Repository
public class BalePreparationDaoImpl implements BalePreparationdao{

	@Autowired
	SessionFactory sessionFactory;
	protected Session currentSession(){
		return sessionFactory.getCurrentSession();
	}

	@Override
	public void create(BalePreparation balemod) {
		currentSession().saveOrUpdate(balemod);
	}

	@Override
	public void update(BalePreparation balemod) {
		currentSession().update(balemod);
	}

	@Override
	public BalePreparation edit(int id) {
		return find(id);
	}

	@Override
	public void delete(int id) {
		String hql = "Delete from dbo.jcibalepreparation where bale_id = '"+id+"'";
		this.sessionFactory.getCurrentSession().createSQLQuery(hql).executeUpdate();
	}

	/*
	 * @Override public void delete(int id) { BalePreparationModel
	 * BalePreparationModel = new BalePreparationModel(); String hql =
	 * "Delete from dbo.jcibin where id = '"+id+"' " ;
	 * this.sessionFactory.getCurrentSession().createSQLQuery(hql).executeUpdate();
	 *
	 * }
	 */

	@Override
	public BalePreparation find(int id) {
		return (BalePreparation) currentSession().get(BalePreparation.class, id);
	}

	@Override

	public List<BalePreparation> getAll() {
		Criteria c = this.sessionFactory.getCurrentSession().createCriteria(BalePreparation.class);
		List<BalePreparation> ll=c.list();
		return ll;
	}

	@Override
	public boolean submitform(BalePreparation balemod) {
		this.sessionFactory.getCurrentSession().save(balemod);
		return false;
	}



}
