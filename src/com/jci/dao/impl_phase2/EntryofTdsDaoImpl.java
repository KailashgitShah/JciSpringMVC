package com.jci.dao.impl_phase2;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import java.io.IOException;
import java.time.LocalDate;

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
	public List<Object[]> MillName() {
//		
		LocalDate today = LocalDate.now();
		int currentYear = today.getYear();
		

		String financialYear;
		if (today.getMonthValue() < 4) {
			financialYear = (currentYear - 1) + "-" + currentYear;
		} else {
			financialYear = currentYear + "-" + (currentYear + 1);
		}

	        System.err.println("Fiscal Year: " + financialYear);
		String q = "SELECT DISTINCT m.client_name ,c.client_unit_code\r\n"
				+ "FROM jcimilldetailmaster m\r\n"
				+ "LEFT join jcimilldetailchild as c on c.client_code=m.client_code\r\n"
				+ "WHERE NOT EXISTS (\r\n"
				+ "    SELECT 1 \r\n"
				+ "    FROM jcitds_entry e \r\n"
				+ "    WHERE m.client_name = e.mill \r\n"
				+ "    AND e.Financial_year = '"+financialYear+"'\r\n"
				+ ")";
		
		List r = (List) this.sessionFactory.getCurrentSession().createSQLQuery(q).list();
		return r;

	}



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
