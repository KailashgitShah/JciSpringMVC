package com.jci.dao.impl;

import java.util.ArrayList;
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

import com.jci.dao.JbaDao;
import com.jci.model.JbaModel;


@Transactional
@Repository
public class JBADaoImpl implements JbaDao {
	
	@Autowired
	private HttpServletRequest request;

	@Autowired
	SessionFactory sessionFactory;
	
	protected Session currentSession(){
		return sessionFactory.getCurrentSession();
	}

	@Override
	public void create(JbaModel jbaP) {
		currentSession().saveOrUpdate(jbaP);;

	}

	@Override
	public void update(JbaModel jbaP) {
		currentSession().update(jbaP);

	}
	@Override
	public JbaModel edit(int id) {
		return find(id);
	}


	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		String hql = "Delete from dbo.jcijba where jbaid = '"+id+"' " ;
		 this.sessionFactory.getCurrentSession().createSQLQuery(hql).executeUpdate();

	}



	@Override
	public JbaModel find(int id) {
		return (JbaModel) currentSession().get(JbaModel.class, id);
	}

	@Override
	public List<JbaModel> getAll(String dpcid, String regionId, String zoneId) {
		Criteria c = this.sessionFactory.getCurrentSession().createCriteria(JbaModel.class);
		List<Integer> result = new ArrayList<>();
		HttpSession session1 = request.getSession(false);
		
		String querystr = "";
		String roletypes = (String) session1.getAttribute("roletype");

		if(roletypes.equalsIgnoreCase("HO")) {
			querystr = "select a.*, b.centername  from jcijba a left Join jcipurchasecenter b on a.dpcid = b.CENTER_CODE";
		}		else if(roletypes.equalsIgnoreCase("ZO")){
			
			querystr="  select a.*, b.centername  from jcijba a left Join jcipurchasecenter b on a.dpcid = b.CENTER_CODE  LEFT JOIN jcirodetails c ON b.rocode = c.rocode where c.zonecode='"+zoneId+"'";
				
		}
		else if(roletypes.equalsIgnoreCase("RO")){
			querystr="select a.*, b.centername  from jcijba a left Join jcipurchasecenter b on a.dpcid = b.CENTER_CODE where b.rocode='"+regionId+"'";
		}else {
			querystr="select a.*, b.centername  from jcijba a left Join jcipurchasecenter b on a.dpcid = b.CENTER_CODE where a.dpcid='"+dpcid+"'";
		}
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		SQLQuery query = session.createSQLQuery(querystr);
		List<Object[]> rows = query.list();
		List<JbaModel> ll= new ArrayList<>();
		for(Object[] row: rows) {
			
			int jbaid = (int)row[0];
			String jbaDate = (String)row[1];
			String jutevariety = (String)row[2];
			String cropyr = (String)row[3];
			String areaCode = (String)row[4];
			String createddate = (String)row[5];
			int creadtedby = (int)row[6];
			/*
			 * double gradewisepp1 = (double)row[7]; double gradewisepp2 = (double)row[8];
			 * double gradewisepp3 = (double)row[9]; double gradewisepp4 = (double)row[10];
			 * double gradewisepp5 = (double)row[11]; double gradewisepp6 = (double)row[12];
			 * double gradewisepp7 = (double)row[13]; double gradewisepp8 = (double)row[14];
			 */
			String region = (String)row[15];
			String dpcId = (String)row[16];
			String area_name = (String)row[17]; 
			String dpcName = (String)row[18];
			
			JbaModel  jba= new JbaModel();
			jba.setId(jbaid);
			jba.setAreaCode(areaCode);
			jba.setAreaName(area_name);
			jba.setCreadtedby(creadtedby);
			jba.setCreateddate(createddate);
			jba.setCropyr(cropyr);
			jba.setDpcid(dpcid);
			/*
			 * jba.setGradewisepp1(gradewisepp1); jba.setGradewisepp2(gradewisepp2);
			 * jba.setGradewisepp3(gradewisepp3); jba.setGradewisepp4(gradewisepp4);
			 * jba.setGradewisepp5(gradewisepp5); jba.setGradewisepp6(gradewisepp6);
			 * jba.setGradewisepp7(gradewisepp7); jba.setGradewisepp8(gradewisepp8);
			 */
			jba.setJbaDate(jbaDate);
			jba.setJutevariety(jutevariety);
			jba.setRegion(region);
			
			
			ll.add(jba);
		}
		
		return ll;
	}

	@Override
	public boolean submitform(JbaModel jbaP) {
		this.sessionFactory.getCurrentSession().save(jbaP);
		return false;
	}

	@Override
	public List <String> GetDayCountofJBA(String jbaId) {
		// TODO Auto-generated method stub
		List<String> result = new ArrayList<>();
		int a=0;

		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();

		System.out.println("id from JBA DAO Impl is"+jbaId);
		Query query = session.createSQLQuery("{CALL GetDatediffWithCurrentDt(:PID)}");
		query.setParameter("PID", jbaId);

		List<String> results = query.list();
		return results;


	}

	@Override
	public List<String> findGradeOnJuteVariety(String jvariety) {
		List<String> result = new ArrayList<>();
		int count=0;

		String querystr = "SELECT grade FROM jcijutevariety where  jutevariety like '"+ jvariety+"%'";

		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		SQLQuery query = session.createSQLQuery(querystr);
		result = query.list();

		return result;
	}

	@Override
	public List<JbaModel> getAll() {
		Criteria c = this.sessionFactory.getCurrentSession().createCriteria(JbaModel.class);
		List<JbaModel> ll=c.list();
		return ll;
	}





}
