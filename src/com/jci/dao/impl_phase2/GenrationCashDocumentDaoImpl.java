package com.jci.dao.impl_phase2;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.jci.dao_phase2.GenrationCashDocumentDao;
import com.jci.model.CashDocumentModel;


@Repository
@Transactional
public class GenrationCashDocumentDaoImpl implements GenrationCashDocumentDao {
	@Autowired
	SessionFactory sessionFactory;
	protected Session currentSession(){
		return sessionFactory.getCurrentSession();
	}
	
	@Override
	public void create(CashDocumentModel cashDocumentModel) {
		
		currentSession().saveOrUpdate(cashDocumentModel);
	}
	@Override
    public List<CashDocumentModel> getAll() {
        Criteria criteria = currentSession().createCriteria(CashDocumentModel.class);
        return criteria.list();
    }

	@Override
	public String fetchBos_No() {
	
       String sql="select  Bill_of_suply_no from  jcibos_generation";
		
		  //String resultList12= this.sessionFactory.getCurrentSession().createSQLQuery(sql);
	    return null;
	}
}
