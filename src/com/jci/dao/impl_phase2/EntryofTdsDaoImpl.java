package com.jci.dao.impl_phase2;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import javax.servlet.http.HttpServletResponse;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.jci.dao_phase2.EntryofTdsDao;
import com.jci.model.JciEntryTdsModel;

@Transactional
@Repository
public class EntryofTdsDaoImpl implements EntryofTdsDao {

	@Autowired
	private HttpServletRequest request;

	@Autowired
	SessionFactory sessionFactory;

	protected Session currentSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public void create(JciEntryTdsModel j) {
		// TODO Auto-generated method stub
		currentSession().save(j);

	}

	@Override
	public List<JciEntryTdsModel> getAll() {
		// TODO Auto-generated method stub
		Criteria c = this.sessionFactory.getCurrentSession().createCriteria(JciEntryTdsModel.class);
		List<JciEntryTdsModel> ll = c.list();
		return ll;
	}

	@Override
	public List<String> MillName() {
		String q = "SELECT DISTINCT Mill_name FROM jcicontract";
		List r = (List) this.sessionFactory.getCurrentSession().createSQLQuery(q).list();
		return r;

	}

//	@Override
//
//    public String contractIdentification(String Mill) {
//
//           // TODO Auto-generated method stub
//		
//		String q="SELECT DISTINCT CropYear FROM jcicontract WHERE Mill_name = '"+Mill+"'";
//
//           //String q="SELECT  Mill_name FROM jcicontract where Mill_name = '"+Mill+"'";
//
//           String contractIdentication= (String) this.sessionFactory.getCurrentSession().createSQLQuery(q).uniqueResult();
//
//             System.out.println(contractIdentication);
//
//             return contractIdentication;
//
//    }

	@Override

	public String contractIdentification(String Mill) {

		// TODO Auto-generated method stub

		String q = "SELECT DISTINCT CropYear FROM jcicontract WHERE Mill_name = '" + Mill + "'";

		// String q="SELECT Mill_name FROM jcicontract where Mill_name = '"+Mill+"'";

		String contractIdentication = (String) this.sessionFactory.getCurrentSession().createSQLQuery(q).uniqueResult();

		System.out.println(contractIdentication);

		return contractIdentication;

	}

}
