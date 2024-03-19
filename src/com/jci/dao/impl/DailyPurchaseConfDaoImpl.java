package com.jci.dao.impl;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.jci.dao.DailyPurchaseConfDao;
import com.jci.model.DailyPurchaseConfModel;
import com.jci.model.JbaModel;
import com.jci.model.RawJuteProcurementAndPayment;

@Transactional
@Repository
public class DailyPurchaseConfDaoImpl implements DailyPurchaseConfDao {

	@Autowired
	private HttpServletRequest request;

	@Autowired
	SessionFactory sessionFactory;

	protected Session currentSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public void create(DailyPurchaseConfModel dailyPurchaseConfModel) {
		currentSession().saveOrUpdate(dailyPurchaseConfModel);
	}

	@Override
	public void update(DailyPurchaseConfModel dailyPurchaseConfModel) {
		currentSession().update(dailyPurchaseConfModel);

	}

	@Override
	public DailyPurchaseConfModel edit(int id) {
		return find(id);
	}

	@Override
	public void delete(int id) {
		String hql = "Delete from dbo.jcidpc where dpcid = '" + id + "' ";
		this.sessionFactory.getCurrentSession().createSQLQuery(hql).executeUpdate();
	}

	@Override
	public DailyPurchaseConfModel find(int id) {
		return (DailyPurchaseConfModel) currentSession().get(DailyPurchaseConfModel.class, id);
	}

	@Override
	public List<DailyPurchaseConfModel> getAll(String dpcid, String regionId, String zoneId) {
		Criteria c = this.sessionFactory.getCurrentSession().createCriteria(DailyPurchaseConfModel.class);

		List<Integer> result = new ArrayList<>();
		HttpSession session1 = request.getSession(false);

		String querystr = "";
		String roletypes = (String) session1.getAttribute("roletype");

		if (roletypes.equalsIgnoreCase("HO")) {
			querystr = "select a.*, b.centername  from jcidpc a left Join jcipurchasecenter b on a.placeofpurchase = b.CENTER_CODE";
		} else if (roletypes.equalsIgnoreCase("ZO")) {

			querystr = " select a.*, b.centername  from jcidpc a left Join jcipurchasecenter b on a.placeofpurchase = b.CENTER_CODE LEFT JOIN jcirodetails c ON b.rocode = c.rocode where c.zonecode='"
					+ zoneId + "'";

		} else if (roletypes.equalsIgnoreCase("RO")) {
			querystr = "select a.*, b.centername  from jcidpc a left Join jcipurchasecenter b on a.placeofpurchase = b.CENTER_CODE where b.rocode='"
					+ regionId + "'";
		} else {
			querystr = "select a.*, b.centername  from jcidpc a left Join jcipurchasecenter b on a.placeofpurchase = b.CENTER_CODE where a.placeofpurchase='"
					+ dpcid + "'";
		}
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		SQLQuery query = session.createSQLQuery(querystr);
		List<Object[]> rows = query.list();
		List<DailyPurchaseConfModel> ll = new ArrayList<>();
		for (Object[] row : rows) {

			int dpcids = (int) row[0];
			String datepurchase = (String) row[2];
			String basis = (String) row[3];
			String cropyr = (String) row[4];
			// String createddate = (String)row[5];
			int binno = (int) row[6];
			String jutevariety = (String) row[7];
			String gquantity = (String) row[8];
			String dquantity = (String) row[9];
			double netquantity = (((BigDecimal) row[10]).doubleValue());
			// int fibervalue = (int)row[11];
			String rateslipno = (String) row[15];

			DailyPurchaseConfModel dailypur = new DailyPurchaseConfModel();
			dailypur.setDpcid(dpcids);
			dailypur.setDatepurchase(datepurchase);
			dailypur.setBasis(basis);
			dailypur.setCropyr(cropyr);
			dailypur.setBinno(binno);
			dailypur.setGquantity(gquantity);
			dailypur.setDquantity(dquantity);
			dailypur.setNetquantity(netquantity);
			// dailypur.setFibervalue(fibervalue);
			dailypur.setRateslipno(rateslipno);
			dailypur.setJutevariety(jutevariety);

			ll.add(dailypur);
		}

		return ll;
	}

	@Override
	public boolean submitform(DailyPurchaseConfModel dailyPurchaseConfModel) {
		this.sessionFactory.getCurrentSession().save(dailyPurchaseConfModel);
		return false;
	}

	@Override
	public String findGradePriceJuteVariety(String variety, int basis_no, String cropyr, String dpcid) {

		String querystr = "";
		List<Object[]> result = new ArrayList<>();

		int count = 0;
		double grade1 = 0.0;
		double grade2 = 0.0;
		double grade3 = 0.0;
		double grade4 = 0.0;
		double grade5 = 0.0;
		double grade6 = 0.0;
		double grade7 = 0.0;
		double grade8 = 0.0;
		if (basis_no == 1) {
			querystr = "SELECT  grade1, grade2, grade3, grade4, grade5, grade6, grade7, grade8 FROM jcimspgradesprice where crop_yr='"
					+ cropyr + "' and jute_variety like '" + variety + "%'";
		} else if (basis_no == 2) {
			querystr = "SELECT  top 1 grade1, grade2, grade3, grade4, grade5, grade6, grade7, grade8 FROM jcijutepricesforcommercial where effectDate <= GETDATE() and crop_yr='"
					+ cropyr + "' and jute_variety like '" + variety + "%' and dpc like '%" + dpcid + "%'"
					+ "order by effectDate desc ";
		}
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		SQLQuery query = session.createSQLQuery(querystr);
		result = query.list();
		for (Object[] o : result) {
			grade1 = ((BigDecimal) o[0]).doubleValue();
			grade2 = ((BigDecimal) o[1]).doubleValue();
			grade3 = ((BigDecimal) o[2]).doubleValue();
			grade4 = ((BigDecimal) o[3]).doubleValue();
			grade5 = ((BigDecimal) o[4]).doubleValue();
			grade6 = ((BigDecimal) o[5]).doubleValue();
			grade7 = ((BigDecimal) o[6]).doubleValue();
			grade8 = ((BigDecimal) o[7]).doubleValue();

		}

		return (grade1 + "," + grade2 + "," + grade3 + "," + grade4 + "," + grade5 + "," + grade6 + "," + grade7 + ","
				+ grade8);
	}

	@Override
	public List<DailyPurchaseConfModel> dpc2() {
		List<DailyPurchaseConfModel> dpclist = new ArrayList<>();
		String querystr = "";
		String querystr1 = "";
		String querystr2 = "";
		String querystr4 = "";
		int j;
		List<Object[]> result1 = new ArrayList<>();
		List<Object[]> result = new ArrayList<>();
		querystr2 = "select ptsid from jciprocurement where flag_dpc2 = 0 group by ptsid,datepurchase,cropyr,jutevariety,placeofpurchase ";
		Session session2 = sessionFactory.getCurrentSession();
		Transaction tx2 = session2.beginTransaction();
		SQLQuery query2 = session2.createSQLQuery(querystr2);
		result1 = query2.list();
		String ptsid = result1.toString();
		ptsid = result1.toString().replace("]", "");
		ptsid = ptsid.toString().replace("[", "");

		querystr1 = "SELECT DISTINCT\n"
				+ "round(sum(j1.grade1*j1.netquantity)/NULLIF(sum(j1.netquantity), 0),2) as gr1,\n"
				+ "round(sum(j1.grade2*j1.netquantity)/NULLIF(sum(j1.netquantity), 0),2) as gr2,\n"
				+ "round(sum(j1.grade3*j1.netquantity)/NULLIF(sum(j1.netquantity), 0),2) as gr3,\n"
				+ "round(sum(j1.grade4*j1.netquantity)/NULLIF(sum(j1.netquantity), 0),2) as gr4,\n"
				+ "round(sum(j1.grade5*j1.netquantity)/NULLIF(sum(j1.netquantity), 0),2) as gr5,\n"
				+ "round(sum(j1.grade6*j1.netquantity)/NULLIF(sum(j1.netquantity), 0),2) as gr6,\n"
				+ "round(sum(j1.grade7*j1.netquantity)/NULLIF(sum(j1.netquantity), 0),2) as gr7,\n"
				+ "round(sum(j1.grade8*j1.netquantity)/NULLIF(sum(j1.netquantity), 0),2) as gr8,\n"
				+ "j1.datepurchase,\n" + "j1.cropyr,\n" + "j1.jutevariety,\n" + "\n" + "j1.placeofpurchase,\n"
				+ "round(sum(j1.netquantity)/NULLIF(100,0),2) as net,\n" + "j1.basis,\n"
				+ "round(sum(j1.amountpayable)*100/NULLIF(sum(j1.netquantity),0),2) as garsat,\n" + "j1.binno,\n"
				+ "round(sum(j1.amountpayable),0) as amount,\n"
				+ "round(sum(j1.grossquantity)/NULLIF(100,0),2) as gross,\n"
				+ "round(sum(j1.deductionquantity)/NULLIF(100,0),2) as deduc\n" + "FROM\n" + "jciprocurement j1\n"
				+ "WHERE\n" + "j1.flag_dpc2=0\n" + "\n" + "group by\n" + "j1.datepurchase,\n" + "j1.basis,\n"
				+ "j1.placeofpurchase,\n" + "j1.cropyr,\n" + "j1.jutevariety,\n" + "j1.binno";

		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		SQLQuery query = session.createSQLQuery(querystr1);
		result = query.list();
		// try {
		double garsat = 0.0;
		double grade0 = 0.0;
		double grade1 = 0.0;
		double grade2 = 0.0;
		double grade3 = 0.0;
		double grade4 = 0.0;
		double grade5 = 0.0;
		double grade6 = 0.0;
		double grade7 = 0.0;
		for (Object[] o : result) {
			double multi = 0.0;
			double addition = 0.0;
			DailyPurchaseConfModel dailyPurchaseConfModel = new DailyPurchaseConfModel();
			double grade[] = new double[8];
			String variety = (String) o[10];
			String cropyr = (String) o[9];
			String dpcid = (String) o[11];
			double netqty = ((BigDecimal) o[12]).doubleValue();
			if (o[14] != null)
				garsat = ((BigDecimal) o[14]).doubleValue();
			if (o[0] != null)
				grade0 = ((BigDecimal) o[0]).doubleValue();
			if (o[1] != null)
				grade1 = ((BigDecimal) o[1]).doubleValue();
			if (o[2] != null)
				grade2 = ((BigDecimal) o[2]).doubleValue();
			if (o[3] != null)
				grade3 = ((BigDecimal) o[3]).doubleValue();
			if (o[4] != null)
				grade4 = ((BigDecimal) o[4]).doubleValue();
			if (o[5] != null)
				grade5 = ((BigDecimal) o[5]).doubleValue();
			if (o[6] != null)
				grade6 = ((BigDecimal) o[6]).doubleValue();
			if (o[7] != null)
				grade7 = ((BigDecimal) o[7]).doubleValue();
			final SimpleDateFormat formatter1 = new SimpleDateFormat("dd-MM-yyyy");
			// System.out.println("date purchase = "+o[8]);
			String datepurchase = (String) o[8];
			// System.out.println("date purchase = "+datepurchase);
			String basis = (String) o[13];
			dailyPurchaseConfModel.setGrade1(grade0);
			dailyPurchaseConfModel.setGrade2(grade1);
			dailyPurchaseConfModel.setGrade3(grade2);
			dailyPurchaseConfModel.setGrade4(grade3);
			dailyPurchaseConfModel.setGrade5(grade4);
			dailyPurchaseConfModel.setGrade6(grade5);
			dailyPurchaseConfModel.setGrade7(grade6);
			dailyPurchaseConfModel.setGrade8(grade7);
			dailyPurchaseConfModel.setDatepurchase(datepurchase);
			dailyPurchaseConfModel.setBinno((int) o[15]);
			// System.out.println("o[17]"+o[17]);
			dailyPurchaseConfModel.setGquantity(((BigDecimal) o[17]).toString()); // gross qty
			// System.out.println("o[17] = "+ ((BigDecimal)o[17]).toString());
			dailyPurchaseConfModel.setDquantity(((BigDecimal) o[18]).toString()); // deduction qty

			dailyPurchaseConfModel.setFibervalue(((BigDecimal) o[16]).doubleValue()); // amount payable

			if (basis.equalsIgnoreCase("commercial")) {
				querystr = "SELECT top 1 grade1, grade2, grade3, grade4, grade5, grade6, grade7, grade8 FROM jcijutepricesforcommercial where CONVERT( date, effectDate ,105) <= GETDATE() and crop_yr='"
						+ cropyr + "' and jute_variety like '" + variety + "%' and dpc like '%" + dpcid + "%'"
						+ "order by id desc ";
			} else if (basis.equalsIgnoreCase("msp")) {
				querystr = "SELECT  grade1, grade2, grade3, grade4, grade5, grade6, grade7, grade8 FROM jcimspgradesprice where crop_yr='"
						+ cropyr + "' and jute_variety like '" + variety + "%'";

			}
			Session session1 = sessionFactory.getCurrentSession();
			Transaction tx1 = session1.beginTransaction();
			SQLQuery query1 = session1.createSQLQuery(querystr);
			List<Object[]> prices = new ArrayList<>();
			prices = query1.list();

			double gradeprice[] = new double[8];
			double difference[] = new double[8];

			for (Object[] p : prices) {
				double gradefive = ((BigDecimal) p[4]).doubleValue();

				for (j = 0; j < 8; j++) {

					grade[j] = ((BigDecimal) o[j]).doubleValue();
					gradeprice[j] = ((BigDecimal) p[j]).doubleValue();
					if (grade[j] != 0) {
						difference[j] = gradeprice[j] - gradefive;

						multi = (difference[j] * (grade[j] / 100));

						addition += multi;
					}

				}
				dailyPurchaseConfModel.setGrade1xnetqty(grade0 * gradeprice[0]);
				dailyPurchaseConfModel.setGrade2xnetqty(grade1 * gradeprice[1]);
				dailyPurchaseConfModel.setGrade3xnetqty(grade2 * gradeprice[2]);
				dailyPurchaseConfModel.setGrade4xnetqty(grade3 * gradeprice[3]);
				dailyPurchaseConfModel.setGrade5xnetqty(grade4 * gradeprice[4]);
				dailyPurchaseConfModel.setGrade6xnetqty(grade5 * gradeprice[5]);
				dailyPurchaseConfModel.setGrade7xnetqty(grade6 * gradeprice[6]);
				dailyPurchaseConfModel.setGrade8xnetqty(grade7 * gradeprice[7]);
				dailyPurchaseConfModel.setTdbase(garsat - addition);

			}
			querystr4 = "UPDATE jciprocurement SET flag_dpc2 = 1 WHERE ptsid in (" + ptsid + ");";
			Session session4 = sessionFactory.getCurrentSession();
			Transaction tx4 = session4.beginTransaction();
			SQLQuery query4 = session4.createSQLQuery(querystr4);
			int one = query4.executeUpdate();
			dailyPurchaseConfModel.setGarsat(garsat);
			dailyPurchaseConfModel.setBasis(basis);
			dailyPurchaseConfModel.setCropyr(cropyr);
			dailyPurchaseConfModel.setPlaceofpurchase(dpcid);
			dailyPurchaseConfModel.setNetquantity(netqty);
			dailyPurchaseConfModel.setJutevariety(variety);
			dpclist.add(dailyPurchaseConfModel);
		}
		/*
		 * } catch (Exception e) { System.out.println(e.getLocalizedMessage()); }
		 */
		return dpclist;
	}

	@Override
	public List<Double> firstLeveljute(String cropyr, String basis) {

		String querystr1 = "";
		querystr1 = "select cast(sum(grade1*netquantity/100)as numeric(36,2)) as grade1, cast(sum(grade2*netquantity/100)as numeric(36,2)) as grade2, cast(sum(grade3*netquantity/100)as numeric(36,2)) as grade3, cast(sum(grade4*netquantity/100)as numeric(36,2)) as grade4, cast(sum(grade5*netquantity/100)as numeric(36,2)) as grade5, cast(sum(grade6*netquantity/100)as numeric(36,2)) as grade6, cast(sum(grade7*netquantity/100)as numeric(36,2)) as grade7, cast(sum(grade8*netquantity/100)as numeric(36,2)) as grade8  FROM [XMWJCI].[dbo].[jciprocurement] where basis = '"
				+ basis + "' and cropyr ='" + cropyr + "' ";
		Session session1 = sessionFactory.getCurrentSession();
		Transaction tx1 = session1.beginTransaction();
		SQLQuery query1 = session1.createSQLQuery(querystr1);

		List<Object[]> result1 = query1.list();
		List<Double> result2 = new ArrayList<Double>();
		if (result1 != null) {
			for (Object[] p : result1) {
				if (p[0] != null)
					result2.add(((BigDecimal) p[0]).doubleValue());
				else
					result2.add(0.0);
				if (p[1] != null)
					result2.add(((BigDecimal) p[1]).doubleValue());
				else
					result2.add(0.0);
				if (p[2] != null)
					result2.add(((BigDecimal) p[2]).doubleValue());
				else
					result2.add(0.0);
				if (p[3] != null)
					result2.add(((BigDecimal) p[3]).doubleValue());
				else
					result2.add(0.0);
				if (p[4] != null)
					result2.add(((BigDecimal) p[4]).doubleValue());
				else
					result2.add(0.0);
				if (p[5] != null)
					result2.add(((BigDecimal) p[5]).doubleValue());
				else
					result2.add(0.0);
				if (p[6] != null)
					result2.add(((BigDecimal) p[6]).doubleValue());
				else
					result2.add(0.0);
				if (p[7] != null)
					result2.add(((BigDecimal) p[7]).doubleValue());
				else
					result2.add(0.0);

			}
		}
		return result2;
	}

	@Override
	public List<Integer> firstLevelbale(String cropyr, String basis) {

		String qry = "	 select NULLIF(sum(bale_no), 0)  FROM [XMWJCI].[dbo].[jcibalepreparation] where jute_grade like '%1' and crop_year = '2022-2023' and basis = 'msp'\n"
				+ "			 union all\n"
				+ "			   select NULLIF(sum(bale_no), 0 )  FROM [XMWJCI].[dbo].[jcibalepreparation] where jute_grade like '%2' and crop_year = '2022-2023' and basis = 'msp'\n"
				+ "			    union all\n"
				+ "			   select NULLIF(sum(bale_no), 0 )  FROM [XMWJCI].[dbo].[jcibalepreparation] where jute_grade like '%3' and crop_year = '2022-2023' and basis = 'msp'\n"
				+ "			     union all\n"
				+ "			   select NULLIF(sum(bale_no), 0 )  FROM [XMWJCI].[dbo].[jcibalepreparation] where jute_grade like '%4' and crop_year = '2022-2023' and basis = 'msp'\n"
				+ "			     union all\n"
				+ "			   select NULLIF(sum(bale_no), 0 )  FROM [XMWJCI].[dbo].[jcibalepreparation] where jute_grade like '%5' and crop_year = '2022-2023' and basis = 'msp' \n"
				+ "			     union all \n"
				+ "			   select NULLIF(sum(bale_no), 0 )  FROM [XMWJCI].[dbo].[jcibalepreparation] where jute_grade like '%6' and crop_year = '2022-2023' and basis = 'msp' \n"
				+ "						     union all \n"
				+ "			   select NULLIF(sum(bale_no), 0 )  FROM [XMWJCI].[dbo].[jcibalepreparation] where jute_grade like '%7' and crop_year = '2022-2023' and basis = 'msp'\n"
				+ "               			     union all \n"
				+ "			   select NULLIF(sum(bale_no), 0 )  FROM [XMWJCI].[dbo].[jcibalepreparation] where jute_grade like '%8' and crop_year = '2022-2023' and basis = 'msp'	";
		Session session2 = sessionFactory.getCurrentSession();
		Transaction tx2 = session2.beginTransaction();
		Query query2 = session2.createSQLQuery(qry);
		List<Integer> result1 = query2.list();
		List<Integer> bales = new ArrayList<Integer>();
		if (result1.get(0) != null)
			bales.add(result1.get(0));
		else
			bales.add(0);
		if (result1.get(1) != null)
			bales.add(result1.get(1));
		else
			bales.add(0);
		if (result1.get(2) != null)
			bales.add(result1.get(2));
		else
			bales.add(0);
		if (result1.get(3) != null)
			bales.add(result1.get(3));
		else
			bales.add(0);
		if (result1.get(4) != null)
			bales.add(result1.get(4));
		else
			bales.add(0);
		if (result1.get(5) != null)
			bales.add(result1.get(5));
		else
			bales.add(0);
		if (result1.get(6) != null)
			bales.add(result1.get(6));
		else
			bales.add(0);
		if (result1.get(7) != null)
			bales.add(result1.get(7));
		else
			bales.add(0);

		return bales;
	}

	@Override
	public List<Object[]> firstLeveljuteRegionwise(String cropyr, String basis) {

		String querystr1 = "";
		querystr1 = "select cast(sum((a.grade1 * a.netquantity)/100 + (a.grade2 * a.netquantity)/100 + (a.grade3 * a.netquantity)/100 + (a.grade4 * a.netquantity)/100 + (a.grade5 * a.netquantity)/100 + (a.grade6 * a.netquantity)/100 + (a.grade7 * a.netquantity)/100 + (a.grade8 * a.netquantity)/100)as numeric(36,2)) sum, b.roname, b.rocode from [XMWJCI].[dbo].[jciprocurement] a left join [XMWJCI].[dbo].[jcirodetails] b on a.regionId = b.rocode group by b.roname , b.rocode;";
		Session session1 = sessionFactory.getCurrentSession();
		Transaction tx1 = session1.beginTransaction();
		SQLQuery query1 = session1.createSQLQuery(querystr1);
		List<Object[]> list = new ArrayList<Object[]>();
		List<Object[]> result1 = query1.list();

		if (result1 != null) {
			for (Object[] p : result1) {

				String qry = "select NULLIF(sum(a.bale_no), 0 ) grade_sum, grade =1   FROM [XMWJCI].[dbo].[jcibalepreparation] a join  [XMWJCI].[dbo].[jcirodetails] b on a.region = b.rocode where jute_grade like '%1' and crop_year = '"
						+ cropyr + "' and a.basis = '" + basis + "' and region = '" + p[2] + "' group by  b.roname\n"
						+ "union all \n"
						+ "select NULLIF(sum(a.bale_no), 0 ) grade_sum, grade =2   FROM [XMWJCI].[dbo].[jcibalepreparation] a join  [XMWJCI].[dbo].[jcirodetails] b on a.region = b.rocode where jute_grade like '%2' and a.crop_year = '"
						+ cropyr + "' and a.basis = '" + basis + "' and region = '" + p[2] + "' group by  b.roname\n"
						+ "union all\n"
						+ "select NULLIF(sum(a.bale_no), 0 ) grade_sum, grade =3   FROM [XMWJCI].[dbo].[jcibalepreparation] a join  [XMWJCI].[dbo].[jcirodetails] b on a.region = b.rocode where jute_grade like '%3' and a.crop_year = '"
						+ cropyr + "' and a.basis = '" + basis + "' and region = '" + p[2] + "' group by  b.roname\n"
						+ "union all\n"
						+ "select NULLIF(sum(a.bale_no), 0 ) grade_sum, grade =4   FROM [XMWJCI].[dbo].[jcibalepreparation] a join  [XMWJCI].[dbo].[jcirodetails] b on a.region = b.rocode where jute_grade like '%4' and a.crop_year = '"
						+ cropyr + "' and a.basis = '" + basis + "' and region = '" + p[2] + "' group by  b.roname\n"
						+ "union all\n"
						+ "select NULLIF(sum(a.bale_no), 0 ) grade_sum , grade =5 FROM [XMWJCI].[dbo].[jcibalepreparation] a join  [XMWJCI].[dbo].[jcirodetails] b on a.region = b.rocode where jute_grade like '%5' and a.crop_year = '"
						+ cropyr + "' and a.basis = '" + basis + "' and region = '" + p[2] + "' group by  b.roname\n"
						+ "union all \n"
						+ "select NULLIF(sum(a.bale_no), 0 ) grade_sum , grade =6  FROM [XMWJCI].[dbo].[jcibalepreparation] a join  [XMWJCI].[dbo].[jcirodetails] b on a.region = b.rocode where jute_grade like '%6' and a.crop_year = '"
						+ cropyr + "' and a.basis = '" + basis + "' and region = '" + p[2] + "' group by  b.roname\n"
						+ "union all \n"
						+ "select NULLIF(sum(a.bale_no), 0 ) grade_sum , grade =7  FROM [XMWJCI].[dbo].[jcibalepreparation] a join  [XMWJCI].[dbo].[jcirodetails] b on a.region = b.rocode where jute_grade like '%7' and a.crop_year = '"
						+ cropyr + "' and a.basis = '" + basis + "' and region = '" + p[2] + "' group by  b.roname\n"
						+ "union all \n"
						+ "select NULLIF(sum(a.bale_no), 0 ) grade_sum, grade =8  FROM [XMWJCI].[dbo].[jcibalepreparation] a join  [XMWJCI].[dbo].[jcirodetails] b on a.region = b.rocode where jute_grade like '%8' and a.crop_year = '"
						+ cropyr + "' and a.basis = '" + basis + "'	and region = '" + p[2] + "' group by  b.roname";
				Session session2 = sessionFactory.getCurrentSession();
				Transaction tx2 = session2.beginTransaction();
				Query query2 = session2.createSQLQuery(qry);
				List<Object[]> result2 = query2.list();
				if (result2 != null) {

					Object[] b = new Object[12];
					b[0] = 0;
					b[1] = 0;
					b[2] = 0;
					b[3] = 0;
					b[4] = 0;
					b[5] = 0;
					b[6] = 0;
					b[7] = 0;
					for (Object[] r : result2) {

						switch ((int) r[1]) {
						case 1: {
							b[0] = r[0];
							break;
						}
						case 2: {
							b[1] = r[0];
							break;
						}
						case 3: {
							b[2] = r[0];
							break;
						}
						case 4: {
							b[3] = r[0];
							break;
						}
						case 5: {
							b[4] = r[0];
							break;
						}
						case 6: {
							b[5] = r[0];
							break;
						}
						case 7: {
							b[6] = r[0];
							break;
						}
						case 8: {
							b[7] = r[0];
							break;
						}

						}
						b[8] = p[0];
						b[9] = p[1];
						b[10] = p[2];

						list.add(b);

						/*
						 * if((int)r[1] == 1) b[0] = r[0];
						 * 
						 * if((int)r[1] == 2) b[1] = r[0];
						 * 
						 * if((int)r[1] == 3) b[2] = r[0];
						 * 
						 * if((int)r[1] == 4) b[3] = r[0];
						 * 
						 * if((int)r[1] == 5) b[4] = r[0];
						 * 
						 * if((int)r[1] == 6) b[5] = r[0];
						 * 
						 * if((int)r[1] == 7) b[6] = r[0];
						 * 
						 * if((int)r[1] == 8) b[7] = r[0];
						 * 
						 * b[8] = p[0]; b[9] = p[1]; b[10] = p[2];
						 * 
						 * list.add(b);
						 */
					}
				}
			}

		}

		for (Object[] z : list) {

			System.out.println("sum  " + z[8]);
			System.out.println("region name  " + z[9]);
			System.out.println("region code  " + z[10]);
			System.out.println("g1 " + z[0]);
			System.out.println("g2 " + z[1]);
			System.out.println("g3 " + z[2]);
			System.out.println("g4 " + z[3]);
			System.out.println("g5 " + z[4]);
			System.out.println("g6 " + z[5]);
			System.out.println("g7 " + z[6]);
			System.out.println("g8 " + z[7]);

		}
		return list;
	}

	public List<Object[]> firstLeveljutedpcwise(String cropyr, String basis, String region) {

		String qry = "select NULLIF(sum(a.bale_no), 0 ) grade_sum , grade =1,  b.centername FROM [XMWJCI].[dbo].[jcibalepreparation] a left join  [XMWJCI].[dbo].[jcipurchasecenter] b on a.place_of_packing = b.CENTER_CODE where jute_grade like '%1' and crop_year = '2022-2023' and a.basis = 'commercial' and region = '07' group by  b.centername \r\n"
				+ "union all \r\n"
				+ "select NULLIF(sum(a.bale_no), 0 ) grade_sum , grade =2,  b.centername FROM [XMWJCI].[dbo].[jcibalepreparation] a left join  [XMWJCI].[dbo].[jcipurchasecenter] b on a.place_of_packing = b.CENTER_CODE where jute_grade like '%2' and a.crop_year = '2022-2023' and a.basis = 'commercial' and region = '07' group by  b.centername \r\n"
				+ "union all\r\n"
				+ "select NULLIF(sum(a.bale_no), 0 ) grade_sum , grade =3,  b.centername FROM [XMWJCI].[dbo].[jcibalepreparation] a left join  [XMWJCI].[dbo].[jcipurchasecenter] b on a.place_of_packing = b.CENTER_CODE where jute_grade like '%3' and a.crop_year = '2022-2023' and a.basis = 'commercial' and region = '07' group by  b.centername \r\n"
				+ "union all\r\n"
				+ "select NULLIF(sum(a.bale_no), 0 ) grade_sum , grade =4,  b.centername FROM [XMWJCI].[dbo].[jcibalepreparation] a left join  [XMWJCI].[dbo].[jcipurchasecenter] b on a.place_of_packing = b.CENTER_CODE where jute_grade like '%4' and a.crop_year = '2022-2023' and a.basis = 'commercial' and region = '07' group by  b.centername \r\n"
				+ "union all\r\n"
				+ "select NULLIF(sum(a.bale_no), 0 ) grade_sum , grade =5,  b.centername FROM [XMWJCI].[dbo].[jcibalepreparation] a left join  [XMWJCI].[dbo].[jcipurchasecenter] b on a.place_of_packing = b.CENTER_CODE where jute_grade like '%5' and a.crop_year = '2022-2023' and a.basis = 'commercial' and region = '07' group by  b.centername \r\n"
				+ "union all \r\n"
				+ "select NULLIF(sum(a.bale_no), 0 ) grade_sum , grade =6,  b.centername FROM [XMWJCI].[dbo].[jcibalepreparation] a left join  [XMWJCI].[dbo].[jcipurchasecenter] b on a.place_of_packing = b.CENTER_CODE where jute_grade like '%6' and a.crop_year = '2022-2023' and a.basis = 'commercial' and region = '07' group by  b.centername \r\n"
				+ "union all \r\n"
				+ "select NULLIF(sum(a.bale_no), 0 ) grade_sum , grade =7,  b.centername FROM [XMWJCI].[dbo].[jcibalepreparation] a left join  [XMWJCI].[dbo].[jcipurchasecenter] b on a.place_of_packing = b.CENTER_CODE where jute_grade like '%7' and a.crop_year = '2022-2023' and a.basis = 'commercial' and region = '07' group by  b.centername \r\n"
				+ "union all \r\n"
				+ "select NULLIF(sum(a.bale_no), 0 ) grade_sum , grade =8,  b.centername FROM [XMWJCI].[dbo].[jcibalepreparation] a left join  [XMWJCI].[dbo].[jcipurchasecenter] b on a.place_of_packing = b.CENTER_CODE where jute_grade like '%8' and a.crop_year = '2022-2023' and a.basis = 'commercial' and region = '07' group by  b.centername \r\n";
		Session session2 = sessionFactory.getCurrentSession();
		Transaction tx2 = session2.beginTransaction();
		Query query2 = session2.createSQLQuery(qry);
		List<Object[]> result1 = query2.list();
		for (Object[] a : result1) {
			System.out.println("sum of bales  " + a[0]);
			System.out.println("grades  " + a[1]);
			System.out.println("dpc_name  " + a[2]);

		}
		return result1;
	}

	@Override
	public List<Object[]> firstLevelbaleRegionwise(String cropyr, String basis) {

		String qry = "select NULLIF(sum(a.bale_no), 0 ) grade_sum, jute_grade = 1,  b.roname FROM [XMWJCI].[dbo].[jcibalepreparation] a join  [XMWJCI].[dbo].[jcirodetails] b on a.region = b.rocode where jute_grade like '%1' and crop_year = '"
				+ cropyr + "' and a.basis = '" + basis + "' group by  b.roname\n" + "union all \n"
				+ "select NULLIF(sum(a.bale_no), 0 ) grade_sum, jute_grade = 2,  b.roname FROM [XMWJCI].[dbo].[jcibalepreparation] a join  [XMWJCI].[dbo].[jcirodetails] b on a.region = b.rocode where jute_grade like '%2' and a.crop_year = '"
				+ cropyr + "' and a.basis = '" + basis + "' group by  b.roname\n" + "union all\n"
				+ "select NULLIF(sum(a.bale_no), 0 ) grade_sum, jute_grade = 3,  b.roname FROM [XMWJCI].[dbo].[jcibalepreparation] a join  [XMWJCI].[dbo].[jcirodetails] b on a.region = b.rocode where jute_grade like '%3' and a.crop_year = '"
				+ cropyr + "' and a.basis = '" + basis + "' group by  b.roname\n" + "union all\n"
				+ "select NULLIF(sum(a.bale_no), 0 ) grade_sum, jute_grade = 4,  b.roname FROM [XMWJCI].[dbo].[jcibalepreparation] a join  [XMWJCI].[dbo].[jcirodetails] b on a.region = b.rocode where jute_grade like '%4' and a.crop_year = '"
				+ cropyr + "' and a.basis = '" + basis + "' group by  b.roname\n" + "union all\n"
				+ "select NULLIF(sum(a.bale_no), 0 ) grade_sum, jute_grade = 5,  b.roname FROM [XMWJCI].[dbo].[jcibalepreparation] a join  [XMWJCI].[dbo].[jcirodetails] b on a.region = b.rocode where jute_grade like '%5' and a.crop_year = '"
				+ cropyr + "' and a.basis = '" + basis + "' group by  b.roname\n" + "union all \n"
				+ "select NULLIF(sum(a.bale_no), 0 ) grade_sum, jute_grade = 6,  b.roname FROM [XMWJCI].[dbo].[jcibalepreparation] a join  [XMWJCI].[dbo].[jcirodetails] b on a.region = b.rocode where jute_grade like '%6' and a.crop_year = '"
				+ cropyr + "' and a.basis = '" + basis + "' group by  b.roname\n" + "union all \n"
				+ "select NULLIF(sum(a.bale_no), 0 ) grade_sum, jute_grade = 7,  b.roname FROM [XMWJCI].[dbo].[jcibalepreparation] a join  [XMWJCI].[dbo].[jcirodetails] b on a.region = b.rocode where jute_grade like '%7' and a.crop_year = '"
				+ cropyr + "' and a.basis = '" + basis + "' group by  b.roname\n" + "union all \n"
				+ "select NULLIF(sum(a.bale_no), 0 ) grade_sum, jute_grade = 8,  b.roname FROM [XMWJCI].[dbo].[jcibalepreparation] a join  [XMWJCI].[dbo].[jcirodetails] b on a.region = b.rocode where jute_grade like '%8' and a.crop_year = '"
				+ cropyr + "' and a.basis = '" + basis + "'	group by  b.roname";
		Session session2 = sessionFactory.getCurrentSession();
		Transaction tx2 = session2.beginTransaction();
		Query query2 = session2.createSQLQuery(qry);
		List<Object[]> result1 = query2.list();
		for (Object[] a : result1) {
			System.out.println("sum of bales  " + a[0]);
			System.out.println("grades  " + a[1]);
			System.out.println("region_name  " + a[2]);

		}
		return result1;
	}

	@Override
	public List<String> getCropYear() {

		String sql = "select distinct cropyr from jciprocurement where cropyr is not NULL";
		List<String> list = currentSession().createSQLQuery(sql).list();
		return list;
	}
}