package com.jci.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.jci.dao.MSPPriceCalculationDao;
import com.jci.model.MSPPriceCalculationModel;

@Transactional
@Repository
public class MSPPriceCalculationDaoImpl implements MSPPriceCalculationDao{

	@Autowired
	SessionFactory sessionFactory;
	protected Session currentSession(){
		return sessionFactory.getCurrentSession();
	}

	@Override
	public List<String> findGradeOfMSP(String variety, int basis_no) {
		List<String> result = new ArrayList<>();
		int count=0;

		String querystr = "SELECT grade FROM jcijutevariety where basis ='"+basis_no+"' and jutevariety like '"+ variety+"%'";


		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		SQLQuery query = session.createSQLQuery(querystr);
		result = query.list();

		 count = query.list().size();


		return result;
	}

	@Override
	public int create(MSPPriceCalculationModel mspPrices) {
		currentSession().saveOrUpdate( mspPrices);
		int msp =  (int) currentSession().save(mspPrices);
		return msp;
	}


	@Override
	public List<MSPPriceCalculationModel> getAll() {
		Criteria c = this.sessionFactory.getCurrentSession().createCriteria(MSPPriceCalculationModel.class);
		List<MSPPriceCalculationModel> ll=c.list();
		return ll;
	}

	@Override
	public boolean validatejutevariety(String jutevariety, String cropyr) {

		jutevariety = jutevariety.substring(1, jutevariety.length() - 1);
		cropyr = cropyr.substring(1, cropyr.length() - 1);
		List<Integer> result = new ArrayList<>();
		String querystr = "select crop_yr from jcimspgradesprice where jute_variety ='"+jutevariety+"' and crop_yr='"+cropyr+"'";
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		SQLQuery query = session.createSQLQuery(querystr);
		List<Object[]> rows = query.list();
		//System.out.println("you are in DAO layer");
		boolean juteMatched = rows.isEmpty();
		if(juteMatched) {
			return true;
		}else {
			return false;
		}
	}
	
	@Override
    public void delete(int id) {
          String hql = "Delete from jcimspgradesprice where msp_id = '" + id + "' ";
    this.sessionFactory.getCurrentSession().createSQLQuery(hql).executeUpdate();
    }

    @Override
    public MSPPriceCalculationModel find(int id) {
          // TODO Auto-generated method stub
          return (MSPPriceCalculationModel) currentSession().get(MSPPriceCalculationModel.class, id);
    }

    @Override
    public void update(MSPPriceCalculationModel mspPriceCalculationModel) {
          currentSession().update( mspPriceCalculationModel);
          
    }



}
