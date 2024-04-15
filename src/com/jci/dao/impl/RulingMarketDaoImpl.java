package com.jci.dao.impl;

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
	public List<MarkerArrivalModelDTO> MarketArrivalList(String arrivaldate, String region_id) {
		List<Integer> result = new ArrayList<>();
		String querystr = "";
			//querystr = "Select  a.*, b.verficationid, b.regno, b.ifsccode, b.accountno, b.farmername, b.address, b.status, b.verificationdate, st.state_name, d.district_name from jcirmt a left Join jcifarmerverification b on a.F_REG_NO = b.regno left join tbl_states st on a.F_STATE = st.id left join tbl_districts d on F_District = d.id where a.dpc_id ='"+dpc+"'";
			querystr = "	Select r1.cropyr, p1.centername, r1.datearrival, r1.arrivedqty, r1.grade_rate1, r1.grade_rate2, r1.grade_rate3, r1.grade_rate4, r1.grade_rate5, r1.mixmois, r1.maxmois, r1.grade2, r1.grade3, r1.grade4, r1.grade5, r1.jutevariety FROM jcimra r1 left join jcipurchasecenter p1 on r1.dpc_code = p1.CENTER_CODE where r1.region_id = '"+region_id+"' and r1.datearrival = '"+arrivaldate+"'";
	
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
			double grade2 = (double)row[11];
			double grade3 = (double)row[12];
			double grade4 = (double)row[13];
			double grade5 = (double)row[14];
			String jutevarity = (String) row[15];
			
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
			marketArrivalDTO.setMixmois(mixmois);
			marketArrivalDTO.setMaxmois(maxmois);
			marketArrivalDTO.setGrade2(grade2);
			marketArrivalDTO.setGrade3(grade3);
			marketArrivalDTO.setGrade4(grade4);
			marketArrivalDTO.setGrade5(grade5);
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
}
