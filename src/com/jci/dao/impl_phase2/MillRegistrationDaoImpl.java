package com.jci.dao.impl_phase2;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.jci.dao_phase2.MillRegistrationDao;
import com.jci.model.JciEntryTdsModel;
import com.jci.model.MillRegistrationModel;
@Transactional
@Repository
public class MillRegistrationDaoImpl implements MillRegistrationDao {
	@Autowired
	private HttpServletRequest request;

	@Autowired
	SessionFactory sessionFactory;

	protected Session currentSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public List<String> MillName() {
		String q = "SELECT DISTINCT unit_name FROM jcimilldetailchild";
		List r = (List) this.sessionFactory.getCurrentSession().createSQLQuery(q).list();
		return r;
		
	}

	@Override
	public List<Object> FetchMillReceiptData(String millid) {
		String q = "SELECT DISTINCT client_unit_code FROM jcimilldetailchild  WHERE jcimilldetailchild.unit_name = '" + millid + "'";

		List<Object> ContractListData = (List<Object>) this.sessionFactory.getCurrentSession().createSQLQuery(q).list();
		//System.out.println(ContractListData);

		return ContractListData;
	}

	@Override
	public void create(MillRegistrationModel millsave) {
		currentSession().save(millsave);

		// TODO Auto-generated method stub
		
	}

	@Override
	public List<MillRegistrationModel> getAll() {
		// TODO Auto-generated method stub
		Criteria c = this.sessionFactory.getCurrentSession().createCriteria(MillRegistrationModel.class);
		List<MillRegistrationModel> ll = c.list();
		return ll;
	}
	

}
