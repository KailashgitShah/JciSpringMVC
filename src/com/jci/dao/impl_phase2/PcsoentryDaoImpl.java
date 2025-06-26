package com.jci.dao.impl_phase2;

import java.math.BigDecimal;
import java.math.RoundingMode;
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

import com.itextpdf.text.pdf.PdfStructTreeController.returnType;
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
		String querystr = "select client_unit_code,short_name from jcimilldetailchild order by short_name";
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
		String querystr = "select distinct(pcso_date),CONVERT(date , pcso_date , 105)  FROM jcientryof_pcso where Pcso_contract_flag = 0 ORDER by CONVERT(date , pcso_date , 105)  desc";
		List<Object[]> pcsoDateList = currentSession().createSQLQuery(querystr).list();
		List<String> dates = new ArrayList<>();

		for (Object[] row : pcsoDateList) {
			dates.add((String) row[0]);
		}

		return dates;

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
		String sqlString = "select jci_ref_no from jcipcso_gen ORDER by pcso_gen_id desc";
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
		String sql = "SELECT DISTINCT \r\n" + "    Jc_reference_no, \r\n"
				+ "     CONVERT(date, pcso_date, 103)  AS formatted_date\r\n" + "FROM \r\n" + "    jcientryof_pcso\r\n"
				+ "ORDER BY \r\n" + "     CONVERT(date, pcso_date, 103)  DESC;";
		// String sql = "select distinct (Jc_reference_no),created_date from
		// jcientryof_pcso order by created_date desc";
		List<Object[]> list = currentSession().createSQLQuery(sql).list();
		List<String> Jc_reference_nos = new ArrayList<>();

		for (Object[] row : list) {
			String pcsoDate = new SimpleDateFormat("dd-MM-yyyy").format((Date) row[1]);
			Jc_reference_nos.add((String) row[0] + "," + pcsoDate);
		}

		return Jc_reference_nos;
	}

	@Override
	public List<EntryofpcsoModel> getAllMillDetailsOfRefNo(String refNo, String date) {
		String sql = "select * from jcientryof_pcso where Jc_reference_no = '" + refNo + "' and pcso_date = '" + date
				+ "'";

		List<Object[]> list = currentSession().createSQLQuery(sql).list();

		List<EntryofpcsoModel> listOfPcso = new ArrayList<>();

		for (Object[] eleObjects : list) {
			EntryofpcsoModel model = new EntryofpcsoModel();

			model.setReference_no((String) eleObjects[14]);
			model.setPcso_req_date((String) eleObjects[13]);
			model.setLetterRef((String) eleObjects[6]);
			model.setPcso_date((String) eleObjects[12]);
			BigDecimal originalpcsoqty = (BigDecimal) eleObjects[10];
			BigDecimal dividedpcsoqty = originalpcsoqty.divide(BigDecimal.TEN, 2, RoundingMode.HALF_UP);
			model.setPcsoQty(dividedpcsoqty);

			model.setPcsoReqQty((double) eleObjects[11]);
			model.setDispatch_period((String) eleObjects[3]);
			model.setMill_code((String) eleObjects[7]);
			model.setMill_name((String) eleObjects[8]);
			
			BigDecimal original = (BigDecimal) eleObjects[1];
			BigDecimal divided = original.divide(BigDecimal.TEN, 2, RoundingMode.HALF_UP);
			model.setAllocatedQty(divided);
	
			model.setPcsorefid((int) eleObjects[0]);
			listOfPcso.add(model);
		}

		return listOfPcso;
	}


	@Override
	public List<String> getMillCodeForPcoDate(String pcoDate) {
		String sqString = "select mill_code from jcientryof_pcso where pcso_date = '" + pcoDate + "'";
		List<Object> pcodates = currentSession().createSQLQuery(sqString).list();
		List<String> pcsoDateString = new ArrayList<>();

		for (Object eleObjects : pcodates) {
			pcsoDateString.add((String) eleObjects);
		}

		return pcsoDateString;
	}

}
