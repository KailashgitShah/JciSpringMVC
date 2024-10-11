package com.jci.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.jci.dao.AddOrganizationDao;
import com.jci.model.AddOrganizationModel;


@Transactional
@Repository
public class AddOrganizationDaoImpl implements AddOrganizationDao {

	@Autowired
	SessionFactory sessionFactory;
	protected Session currentSession(){
		return sessionFactory.getCurrentSession();
	}

	@Override
	public void create(AddOrganizationModel addOrganizationModel) {
		currentSession().save(addOrganizationModel);
	}

	@Override
	public void update(AddOrganizationModel addOrganizationModel) {
		currentSession().update(addOrganizationModel);

	}

	@Override
	public AddOrganizationModel edit(int id) {
		return find(id);
	}

	@Override
	public void delete(int id) {
		AddOrganizationModel addOrganizationModel= new AddOrganizationModel();
		String hql = "Delete from dbo.bna where id = '"+id+"' " ;
		this.sessionFactory.getCurrentSession().createSQLQuery(hql).executeUpdate();
	}

	@Override
	public AddOrganizationModel find(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<AddOrganizationModel> getAll() {
		Criteria c = this.sessionFactory.getCurrentSession().createCriteria(AddOrganizationModel.class);
		List<AddOrganizationModel> ll=c.list();
		return ll;
	}

	@Override
	public boolean submitform(AddOrganizationModel addOrganizationModel) {
		// TODO Auto-generated method stub
		return false;
	}

}
