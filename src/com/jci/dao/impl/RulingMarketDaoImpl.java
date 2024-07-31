package com.jci.dao.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.jci.dao.RulingMarketDao;
import com.jci.model.FarmerRegModel;
import com.jci.model.MarkerArrivalModelDTO;
import com.jci.model.RulingMarket;

@Transactional
@Repository
public class RulingMarketDaoImpl implements RulingMarketDao {

	@Autowired
	SessionFactory sessionFactory;
	protected Session currentSession(){
		return sessionFactory.getCurrentSession();
	}

	@Override
	public void create(RulingMarket rulingMarket) {
		currentSession().save(rulingMarket);
	}

	@Override
	public void update(RulingMarket rulingMarket) {
		currentSession().update(rulingMarket);
	}

	@Override
	public RulingMarket edit(int id) {
		return find(id);
	}

	@Override
	public void delete(int id) {
		RulingMarket rulingMarket = new RulingMarket();
		String hql = "Delete from dbo.jcirulingmarket where jcirulingmarketid = '"+id+"' " ;
		this.sessionFactory.getCurrentSession().createSQLQuery(hql).executeUpdate();
	}

	@Override
	public RulingMarket find(int id) {
		return (RulingMarket) currentSession().get(RulingMarket.class, id);
	}

	@Override
	public List<RulingMarket> getAll() {
		Criteria c = this.sessionFactory.getCurrentSession().createCriteria(RulingMarket.class);
		List<RulingMarket> ll=c.list();
		return ll;
	}

	@Override
	public boolean submitform(RulingMarket rulingMarket) {
		this.sessionFactory.getCurrentSession().save(rulingMarket);
		return false;
	}

	@Override
	public List<MarkerArrivalModelDTO> MarketArrivalList(String arrivaldate, String region_id, String cropyear) {
		List<Integer> result = new ArrayList<>();
		String querystr = "";
			//querystr = "Select  a.*, b.verficationid, b.regno, b.ifsccode, b.accountno, b.farmername, b.address, b.status, b.verificationdate, st.state_name, d.district_name from jcirmt a left Join jcifarmerverification b on a.F_REG_NO = b.regno left join tbl_states st on a.F_STATE = st.id left join tbl_districts d on F_District = d.id where a.dpc_id ='"+dpc+"'";
			querystr = "SELECT \r\n" + 
					"        r1.cropyr,\r\n" + 
					"        p1.centername,\r\n" + 
					"        r1.datearrival,\r\n" + 
					"        r1.arrivedqty,\r\n" + 
					"        r1.grade_rate1,\r\n" + 
					"        r1.grade_rate2,\r\n" + 
					"        r1.grade_rate3,\r\n" + 
					"        r1.grade_rate4,\r\n" + 
					"        r1.grade_rate5,\r\n" + 
					"        r1.mixmois,\r\n" + 
					"        r1.maxmois,\r\n" + 
					"        ROUND(CAST(r1.grade2 AS DECIMAL), 2) AS grade2_rounded,\r\n" + 
					"        ROUND(CAST(r1.grade3 AS DECIMAL), 2) AS grade3_rounded,\r\n" + 
					"        ROUND(CAST(r1.grade4 AS DECIMAL), 2) AS grade4_rounded,\r\n" + 
					"        ROUND(CAST(r1.grade5 AS DECIMAL), 2) AS grade5_rounded,\r\n" + 
					"        r1.jutevariety\r\n" + 
					"    FROM \r\n" + 
					"        jcimra r1\r\n" + 
					"    LEFT JOIN \r\n" + 
					"        jcipurchasecenter p1 \r\n" + 
					"    ON \r\n" + 
					"        r1.dpc_code = p1.CENTER_CODE \r\n" + 
					"    WHERE \r\n" + 
					"        r1.region_id = '" + region_id + "' AND     r1.cropyr ='" + cropyear + "' \r\n" + 
							"\r\n" + 
					"        AND r1.datearrival = '" + arrivaldate + "';\r\n" + 
					"";
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		SQLQuery query = session.createSQLQuery(querystr);
		List<Object[]> rows = query.list();
		FarmerRegModel farmerReg = new FarmerRegModel();
		List<MarkerArrivalModelDTO> ll = new ArrayList<>();
		for(Object[] row: rows) {
			
			String cropyr = (String) row[0];
			String centername = (String) row[1];
			String arrival = (String)row[2];
			String arrivedqty = (String)row[3];
			int grade_rate1 = (int)row[4];
			int grade_rate2 = (int)row[5];
			int grade_rate3 = (int)row[6];
			int grade_rate4= (int)row[7];
			int grade_rate5 = (int)row[8];
			String mixmois = (String)row[9];
			String maxmois = (String) row[10];
			BigDecimal grade2 = (BigDecimal)row[11];
			BigDecimal grade3 = (BigDecimal)row[12];
			BigDecimal grade4 = (BigDecimal)row[13];
			BigDecimal grade5 = (BigDecimal)row[14];
			String jutevarity = (String) row[15];
			//System.err.println("mixmois"+mixmois);
			double grade2Double = grade2.doubleValue();
			double grade3Double = grade3.doubleValue();
			double grade4Double = grade4.doubleValue();
			double grade5Double = grade5.doubleValue();
			int mixmoisInt = Integer.parseInt(mixmois);
			int maxmoisInt = Integer.parseInt(maxmois);
			MarkerArrivalModelDTO marketArrivalDTO = new MarkerArrivalModelDTO();
			marketArrivalDTO.setCropyr(cropyr);
			marketArrivalDTO.setCentername(centername);
			marketArrivalDTO.setDatearrival(arrival);
			marketArrivalDTO.setArrivedqty(arrivedqty);
			marketArrivalDTO.setGrade_rate1(grade_rate1);
			marketArrivalDTO.setGrade_rate2(grade_rate2);
			marketArrivalDTO.setGrade_rate3(grade_rate3);
			marketArrivalDTO.setGrade_rate4(grade_rate4);
			marketArrivalDTO.setGrade_rate5(grade_rate5);
			marketArrivalDTO.setMixmois(mixmoisInt);
			marketArrivalDTO.setMaxmois(maxmoisInt);
			marketArrivalDTO.setGrade2(grade2Double);
			marketArrivalDTO.setGrade3(grade3Double);
			marketArrivalDTO.setGrade4(grade4Double);
			marketArrivalDTO.setGrade5(grade5Double);
			marketArrivalDTO.setJute_verity(jutevarity);
			ll.add(marketArrivalDTO);
		}
		 return ll;
	}

	@Override
	public String getdatArrival(String arrivaldate) {
		// TODO Auto-generated method stub

		String querystr = "select datearrival from jcimra where datearrival ='" + arrivaldate + "'";
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		SQLQuery query = session.createSQLQuery(querystr);
		String region = query.list().get(0).toString();
		return region;

	}

	@Override
	public List<MarkerArrivalModelDTO> MarketArrivalListRegion(String arrivaldate, String cropYear) {
	    List<Integer> result = new ArrayList<>();
	    String querystr = "";
	  querystr = 
			    "SELECT \r\n" + 
			    	    "    p1.roname, \r\n" + 
			    	    "    r1.datearrival, \r\n" + 
			    	    "    SUM(CAST(r1.arrivedqty AS NUMERIC)) AS total_arrivedqty, \r\n" + 
			    	    "    COALESCE(AVG(NULLIF(CAST(r1.grade_rate1 AS NUMERIC), 0)), 0) AS avg_grade_rate1, \r\n" + 
			    	    "    COALESCE(AVG(NULLIF(CAST(r1.grade_rate2 AS NUMERIC), 0)), 0) AS avg_grade_rate2, \r\n" + 
			    	    "    COALESCE(AVG(NULLIF(CAST(r1.grade_rate3 AS NUMERIC), 0)), 0) AS avg_grade_rate3, \r\n" + 
			    	    "    COALESCE(AVG(NULLIF(CAST(r1.grade_rate4 AS NUMERIC), 0)), 0) AS avg_grade_rate4, \r\n" + 
			    	    "    COALESCE(AVG(NULLIF(CAST(r1.grade_rate5 AS NUMERIC), 0)), 0) AS avg_grade_rate5, \r\n" + 
			    	    "    COALESCE(AVG(CAST(r1.mixmois AS NUMERIC)), 0) AS avg_mixmois, \r\n" + 
			    	    "    COALESCE(AVG(CAST(r1.maxmois AS NUMERIC)), 0) AS avg_maxmois, \r\n" + 
			    	    "    COALESCE(ROUND(AVG(CAST(r1.grade2 AS DECIMAL)), 2), 0) AS avg_grade2, \r\n" + 
			    	    "    COALESCE(ROUND(AVG(CAST(r1.grade3 AS DECIMAL)), 2), 0) AS avg_grade3, \r\n" + 
			    	    "    COALESCE(ROUND(AVG(CAST(r1.grade4 AS DECIMAL)), 2), 0) AS avg_grade4, \r\n" + 
			    	    "    COALESCE(ROUND(AVG(CAST(r1.grade5 AS DECIMAL)), 2), 0) AS avg_grade5, \r\n" + 
			    	    "    r1.jutevariety, \r\n" + 
			    	    "    r1.cropyr \r\n" + 
			    	    "FROM \r\n" + 
			    	    "    jcimra r1 \r\n" + 
			    	    "LEFT JOIN \r\n" + 
			    	    "    jcirodetails p1 \r\n" + 
			    	    "ON \r\n" + 
			    	    "    r1.region_id = p1.rocode \r\n" + 
			    	    "WHERE \r\n" + 
			    	    "    r1.cropyr = '" + cropYear + "' \r\n" + 
			    	    "    AND r1.datearrival = '" +arrivaldate + "' \r\n" + 
			    	    "GROUP BY \r\n" + 
			    	    "    p1.roname, \r\n" + 
			    	    "    r1.datearrival, \r\n" + 
			    	    "    r1.jutevariety, \r\n" + 
			    	    "    r1.cropyr\r\n" + 
			    	    "";


	    Session session = sessionFactory.getCurrentSession();
	    Transaction tx = session.beginTransaction();
	    SQLQuery query = session.createSQLQuery(querystr);
	    List<Object[]> rows = query.list();
	    List<MarkerArrivalModelDTO> ll = new ArrayList<>();
	    for (Object[] row : rows) {
	        String roname = (String) row[0];
	        String arrival = (String) row[1];
	        BigDecimal arrivedqty = (BigDecimal) row[2];
	        BigDecimal grade_rate1 = (BigDecimal) row[3];
	        BigDecimal grade_rate2 = (BigDecimal) row[4];
	        BigDecimal grade_rate3 = (BigDecimal) row[5];
	        BigDecimal grade_rate4 = (BigDecimal) row[6];
	        BigDecimal grade_rate5 = (BigDecimal) row[7];
	        BigDecimal mixmois = (BigDecimal) row[8];
	        BigDecimal maxmois = (BigDecimal) row[9];
	        int mixmoisInt = mixmois.intValue();
	        int maxmoisInt = maxmois.intValue();
	        BigDecimal grade2 = (BigDecimal) row[10];
	        BigDecimal grade3 = (BigDecimal) row[11];
	        BigDecimal grade4 = (BigDecimal) row[12];
	        BigDecimal grade5 = (BigDecimal) row[13];
	        String jutevarity = (String) row[14];
	        String cropyear = (String) row[15];

double grade2Double = grade2.doubleValue();
double grade3Double = grade3.doubleValue();
double grade4Double = grade4.doubleValue();
double grade5Double = grade5.doubleValue();

	        MarkerArrivalModelDTO marketArrivalDTO = new MarkerArrivalModelDTO();
	        marketArrivalDTO.setRo_name(roname);
	        marketArrivalDTO.setDatearrival(arrival);
	        marketArrivalDTO.setArrivedqty(arrivedqty.toString());
	        marketArrivalDTO.setGrade_rate1(grade_rate1.intValue());
	        marketArrivalDTO.setGrade_rate2(grade_rate2.intValue());
	        marketArrivalDTO.setGrade_rate3(grade_rate3.intValue());
	        marketArrivalDTO.setGrade_rate4(grade_rate4.intValue());
	        marketArrivalDTO.setGrade_rate5(grade_rate5.intValue());
	        marketArrivalDTO.setMixmois(mixmoisInt);
	        marketArrivalDTO.setMaxmois(maxmoisInt);
	        marketArrivalDTO.setGrade2(grade2Double);
	        marketArrivalDTO.setGrade3(grade3Double);
	        marketArrivalDTO.setGrade4(grade4Double);
	        marketArrivalDTO.setGrade5(grade5Double);
	        marketArrivalDTO.setJute_verity(jutevarity);
	        marketArrivalDTO.setCropyr(cropyear);
	        ll.add(marketArrivalDTO);
	    }
	    return ll;
	}
}