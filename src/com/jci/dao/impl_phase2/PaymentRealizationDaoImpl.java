package com.jci.dao.impl_phase2;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jci.dao_phase2.PaymentRealizationDao;
import com.jci.model.JciEntryTdsModel;
import com.jci.model.uploadPaymentRealisationModel;

@Repository
public class PaymentRealizationDaoImpl implements PaymentRealizationDao{
	
	@Autowired
	SessionFactory sessionFactory;

	protected Session currentSession() {
		return (Session) sessionFactory.getCurrentSession();
	}

	@Override
	public void create(uploadPaymentRealisationModel uploadPaymentRealisation) {

		currentSession().save(uploadPaymentRealisation);
		 
	}

	@Override
	public List<uploadPaymentRealisationModel> getAll() {
		// TODO Auto-generated method stub
		Criteria c = this.sessionFactory.getCurrentSession().createCriteria(uploadPaymentRealisationModel.class);
		List<uploadPaymentRealisationModel> ll = c.list();
		return ll;
	}

	
}
