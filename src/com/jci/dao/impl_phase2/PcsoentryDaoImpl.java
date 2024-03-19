package com.jci.dao.impl_phase2;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.jci.dao_phase2.PcsoentryDao;
import com.jci.model.EntryDerivativePrice;
import com.jci.model.EntryofpcsoModel;
import com.jci.model.PcsoDateModel;

import antlr.TokenWithIndex;

@Transactional
@Repository
public class PcsoentryDaoImpl implements PcsoentryDao {

	@Autowired
	SessionFactory sessionFactory;

	protected Session currentSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public void create(EntryofpcsoModel entryofpcso) {
		// TODO Auto-generated method stub
		currentSession().saveOrUpdate(entryofpcso);
	}

	@Override
	public List<Object[]> getAlldata() {
		// TODO Auto-generated method stub
		String querystr = "select client_unit_code,unit_name from jcimilldetailchild order by unit_name";

		List<Object[]> millsList = currentSession().createSQLQuery(querystr).list();

		return millsList;

	}

	@Override
	public List<EntryofpcsoModel> getAllPcso() {
		Criteria c = this.sessionFactory.getCurrentSession().createCriteria(EntryofpcsoModel.class)
				.addOrder(Order.desc("created_date"));
		List<EntryofpcsoModel> ll = c.list();
		return ll;

	}

	@Override
	public void delete(int id) {
		// String refNo = pcso.getJc_reference_no();
//		String dAll = pcso.getTotal_allocation();
//		String sTAll = pcso.getSumof_totalallocation();
//		int delAllocation = Integer.parseInt(dAll.substring(0, dAll.length() - 4));
//		int sumAllocation = Integer.parseInt(sTAll.substring(0, sTAll.length() - 4));
//		int newSum = sumAllocation - delAllocation;

//		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
//		LocalDateTime now = LocalDateTime.now();
//		String cDate = dtf.format(now);
//
		String queryStr1 = "DELETE FROM dbo.jcientryof_pcso WHERE pcsorefid = :id";
		this.sessionFactory.getCurrentSession().createSQLQuery(queryStr1).setParameter("id", id).executeUpdate();

//		String queryStr2 = "UPDATE jcientryofpcso SET sumof_totalallocation = :sTAll, created_date = :cDate WHERE Jc_reference_no = :refNo";
//		this.sessionFactory.getCurrentSession().createSQLQuery(queryStr2).setParameter("sTAll", newSum)
//				.setParameter("cDate", cDate).setParameter("refNo", refNo).executeUpdate();
	}

	@Override
	public List<String> getAllDates() {
		List<String> ll = new ArrayList<>();
		List<String> rows = new ArrayList<>();
		String querystr = "  select  distinct(pcso_date) FROM jcientryof_pcso";
		return currentSession().createSQLQuery(querystr).list();
	}

	@Override
	public EntryofpcsoModel getPcso(int refid) {
		return (EntryofpcsoModel) currentSession().get(EntryofpcsoModel.class, refid);
	}
//
//	@Override
//	public void update(EntryofpcsoModel entryofpcso, int refid) {
//
////		int tAll = Integer.parseInt(entryofpcso.getTotal_allocation());
////		int sTAll = Integer.parseInt(entryofpcso.getSumof_totalallocation());
//		String refNo = entryofpcso.getJc_reference_no();
//
//		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
//		LocalDateTime now = LocalDateTime.now();
//		String cDate = dtf.format(now);
//
//		String querystr1 = "UPDATE jcientryofpcso SET sumof_totalallocation = :sTAll, created_date = :cDate WHERE Jc_reference_no = :refNo";
//		String querystr2 = "UPDATE jcientryofpcso SET total_allocation = :tAll, sumof_totalallocation = :sTAll, created_date = :cDate WHERE Jc_reference_no = :refNo AND pcsorefid = :refId";
//
//		Session session = sessionFactory.getCurrentSession();
//
//		SQLQuery query1 = session.createSQLQuery(querystr1);
//		//query1.setParameter("sTAll", sTAll);
//		query1.setParameter("cDate", cDate);
//		query1.setParameter("refNo", refNo);
//		query1.executeUpdate();
//
//		SQLQuery query2 = session.createSQLQuery(querystr2);
////		query2.setParameter("tAll", tAll);
////		query2.setParameter("sTAll", sTAll);
//		query2.setParameter("cDate", cDate);
//		query2.setParameter("refNo", refNo);
//		query2.setParameter("refId", refid);
//		query2.executeUpdate();
//
//	}

	@Override
	public List<String> getAllRequest() {
		String sqlString = "select jci_ref_no from jcipcso_gen";
		List<String> list = currentSession().createSQLQuery(sqlString).list();
		return list;
	}

	@Override
	public Object loadAllDetailsOfLetter(String refNo) {
		String sqlString = "select * from jcipcso_gen where jci_ref_no='" + refNo + "'";
		Object list = currentSession().createSQLQuery(sqlString).list();
		return list;
	}

	@Override
	public void update(EntryofpcsoModel entryodpcso, int refid) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<String> getAllLables() {
		String sqlString = "select distinct(Label_name) from jcigrade_composition";
		return currentSession().createSQLQuery(sqlString).list();
	}

	@Override
	public List<String> getUniqueRefNos() {
		String sql = "select distinct Jc_reference_no from jcientryof_pcso";
		List<String> list = currentSession().createSQLQuery(sql).list();
		return list;
	}

	@Override
	public List<EntryofpcsoModel> getAllMillDetailsOfRefNo(String refNo) {
		String sql = "select * from jcientryof_pcso where Jc_reference_no = '"+ refNo + "'";
		
		List<Object[]> list = currentSession().createSQLQuery(sql).list();
		
		List<EntryofpcsoModel> listOfPcso = new ArrayList<>();
		
		for(Object[] eleObjects : list) {
			EntryofpcsoModel model = new EntryofpcsoModel();
			
			model.setReference_no((String)eleObjects[14]);
			model.setPcso_req_date((String)eleObjects[13]);
			model.setLetterRef((String)eleObjects[6]);
			model.setPcso_date((String)eleObjects[12]);
			model.setPcsoQty((double)eleObjects[10]);
			model.setPcsoReqQty((double)eleObjects[11]);
			model.setDispatch_period((String)eleObjects[3]);
			model.setMill_code((String)eleObjects[7]);
			model.setMill_name((String)eleObjects[8]);
			model.setAllocatedQty((double)eleObjects[1]);
			model.setPcsorefid((int)eleObjects[0]);
			System.err.println(model.toString());
			System.err.println(model.toString());
			System.err.println(model.toString());
			listOfPcso.add(model);
		}
		
		return listOfPcso;
	}



	@Override
	public int getCountOfTotalEntries() {
		String sqString = "select COUNT( distinct Contract_identification_no ) from jcicontract";
		return (int)currentSession().createSQLQuery(sqString).uniqueResult();
	}

}
