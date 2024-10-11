package com.jci.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.jci.dao.VerifyFarmerDao;
import com.jci.model.FarmerRegModel;
import com.jci.model.FarmerRegistrationModel;
import com.jci.model.VerifyFarmerModel;

@Transactional
@Repository
public class VerifyFarmerDaoImpl implements VerifyFarmerDao {

	@Autowired
	SessionFactory sessionFactory;
	protected Session currentSession(){
		return sessionFactory.getCurrentSession();
	}

	@Override
	public void create(VerifyFarmerModel VerifyFarmer) {
		currentSession().save(VerifyFarmer);
	}

	@Override
	public void update(VerifyFarmerModel VerifyFarmer) {
		currentSession().update(VerifyFarmer);
	}

	@Override
	public VerifyFarmerModel edit(int id) {
		return find(id);
	}

	@Override
	public void delete(int id) {
		FarmerRegistrationModel farmerRegistrationModel = new FarmerRegistrationModel();
		String hql = "Delete from dbo.bna where id = '"+id+"' " ;
		this.sessionFactory.getCurrentSession().createSQLQuery(hql).executeUpdate();
	}

	@Override
	public VerifyFarmerModel find(int id) {
		return (VerifyFarmerModel) currentSession().get(VerifyFarmerModel.class, id);
	}


	@Override
	public VerifyFarmerModel findbyReg(String regNo) {
		//currentSession().findByRegno();
		System.out.println("findbyReg====== "+ regNo);
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(VerifyFarmerModel.class);
		VerifyFarmerModel yourObject = (VerifyFarmerModel) criteria.add(Restrictions.eq("regno", regNo)).uniqueResult();
		System.out.println("yourObject====== "+ yourObject.toString());
		return yourObject;
	//	return (VerifyFarmerModel) currentSession().get;
		/*List<Integer> result = new ArrayList<Integer>();
		String querystr = "select * from jcifarmerverification where regno ='"+regNo+"'";
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		SQLQuery query = session.createSQLQuery(querystr);
		List<Object[]> rows = query.list();

		// System.out.println("result===== "+ listEmpty);
		if(listEmpty) {
			return true;
		}else {
			return false;
		}*/
	}


	@Override
	public List<VerifyFarmerModel> getAll() {
		Criteria c = this.sessionFactory.getCurrentSession().createCriteria(VerifyFarmerModel.class);
		List<VerifyFarmerModel> ll=c.list();
		return ll;
	}

	@Override
	public boolean submitform(VerifyFarmerModel off) {
		this.sessionFactory.getCurrentSession().saveOrUpdate(off);
		return false;
	}

	@Override
	public int verifyFarmer(String farmer_reg_no, String ifsc_code, String ac_no, String farmer_name, String address, int id) {
		return 0;
	}

	@Override
	public FarmerRegModel verificationStatus(int regNo) {
		List<Integer> result = new ArrayList<>();
		String querystr = "Select a.*, b.verficationid, b.regno, b.ifsccode, b.accountno, b.farmername, b.address, b.status, b.verificationdate from jcirmt a inner Join jcifarmerverification b on a.F_REG_NO = b.regno";
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		SQLQuery query = session.createSQLQuery(querystr);
		List<Object[]> rows = query.list();
		FarmerRegModel verifyFarmer = new FarmerRegModel();
		for(Object[] row: rows) {
			int F_ID = (int) row[0];
//			System.out.println(row[0]);
//			System.out.println(row[1]);
//			System.out.println(row[2]);
//			System.out.println(row[3]);
//			System.out.println("it should be regno "+row[28]);
//			System.out.println("it should be ifsc "+row[29]);
//			System.out.println("it should be accno "+row[30]);
//			System.out.println("farmer name "+row[31]);
//			System.out.println("farmer name "+row[32]);
		}
		return verifyFarmer;
	}

	@Override
	public boolean duplicateVerificationEntryNumberCheck(String regNo) {
		List<Integer> result = new ArrayList<>();
		String querystr = "select * from jcifarmerverification where regno ='"+regNo+"'";
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		SQLQuery query = session.createSQLQuery(querystr);
		List<Object[]> rows = query.list();
		boolean listEmpty = rows.isEmpty();		// returns true if no row is found in db
		// System.out.println("result===== "+ listEmpty);
		if(listEmpty) {
			return true;
		}else {
			return false;
		}
	}


}
