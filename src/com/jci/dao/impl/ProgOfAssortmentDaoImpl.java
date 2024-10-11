package com.jci.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.jci.dao.ProgOfAssortmentDao;
import com.jci.model.ProgOfAssortmentModel;

@Transactional
@Repository
public class ProgOfAssortmentDaoImpl implements ProgOfAssortmentDao{

	@Autowired
	SessionFactory sessionFactory;
	protected Session currentSession(){
		return sessionFactory.getCurrentSession();
	}

	@Override
	public void create(ProgOfAssortmentModel progOfAssortment) {
		currentSession().save(progOfAssortment);

	}

	@Override
	public void update(ProgOfAssortmentModel progOfAssortment) {
		currentSession().update(progOfAssortment);

	}

	@Override
	public ProgOfAssortmentModel edit(int id) {
		return find(id);
	}

	@Override
	public void delete(int id) {
		ProgOfAssortmentModel progOfAssortment = new ProgOfAssortmentModel();
		String hql = "Delete from dbo.bna where id = '"+id+"' " ;
		this.sessionFactory.getCurrentSession().createSQLQuery(hql).executeUpdate();
	}

	@Override
	public ProgOfAssortmentModel find(int id) {
		return (ProgOfAssortmentModel) currentSession().get(ProgOfAssortmentModel.class, id);
	}

	@Override
	public List<ProgOfAssortmentModel> getAll() {
		Criteria c = this.sessionFactory.getCurrentSession().createCriteria(ProgOfAssortmentModel.class);
		List<ProgOfAssortmentModel> ll=c.list();
		return ll;
	}

	@Override
	public boolean submitform(ProgOfAssortmentModel progOfAssortment) {
		this.sessionFactory.getCurrentSession().save(progOfAssortment);
		return false;
	}

}
