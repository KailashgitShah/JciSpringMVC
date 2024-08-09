
package com.jci.dao.impl_phase2;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.jci.dao_phase2.FactorssInvolvedCommercialDao;
import com.jci.model.EntryDerivativePriceModel;
import com.jci.model.FactorssInvolvedCommercial;
import com.jci.model.OperationAndTransportCostModel;


@Transactional
@Repository
public class FactorssInvolvedCommercialDaoImpl implements FactorssInvolvedCommercialDao {


	@Autowired
	SessionFactory sessionFactory;

	protected Session currentSession() {
		return sessionFactory.getCurrentSession();
	}
	
	@Override
	public void create(List<FactorssInvolvedCommercial> allList) {
		// TODO Auto-generated method stub
		for(FactorssInvolvedCommercial list : allList) {
			currentSession().save(list);
		}
	}

	@Override
	public List<FactorssInvolvedCommercial> getAll() {
		Criteria c = this.sessionFactory.getCurrentSession().createCriteria(FactorssInvolvedCommercial.class).addOrder(Order.desc("Created_on"));
		List<FactorssInvolvedCommercial> ll = c.list();
		return ll;
	}

}

