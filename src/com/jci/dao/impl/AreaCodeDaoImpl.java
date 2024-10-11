package com.jci.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.jci.dao.AreaCodeDao;
import com.jci.model.AreaDetailCode;
@Transactional
@Repository
public class AreaCodeDaoImpl implements AreaCodeDao {
	@Autowired
	SessionFactory sessionFactory;
	protected Session currentSession(){
		return sessionFactory.getCurrentSession();
	}



	@Override
	public void create(AreaDetailCode areacode) {
		currentSession().save(areacode);

	}

	@Override
	public void update(AreaDetailCode areacode) {
		currentSession().update(areacode);

	}

	@Override
	public AreaDetailCode edit(int id) {
		return find(id);
	}

	@Override
	public void delete(int id) {
		currentSession().delete(id);

	}

	@Override
	public AreaDetailCode find(int id) {
		return (AreaDetailCode) currentSession().get(AreaDetailCode.class, id);
	}

	@Override
	public List<AreaDetailCode> getAll() {
		System.out.println("Hello From StateListModel");
		List<AreaDetailCode> ll;
		Criteria c = this.sessionFactory.getCurrentSession().createCriteria(AreaDetailCode.class);
		ll=c.list();
		return ll;
	}

	@Override
	public boolean submitform(AreaDetailCode off) {
		this.sessionFactory.getCurrentSession().save(off);
		return false;
	}

}
