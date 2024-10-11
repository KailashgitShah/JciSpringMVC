package com.jci.dao.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.jci.dao.RopeMakingDao;
import com.jci.model.FarmerRegistrationModel;
import com.jci.model.RopeMakingModel;

@Transactional
@Repository
public class RopeMakingDaoImpl implements RopeMakingDao{
	
	@Autowired
	private HttpServletRequest request;
	@Autowired
	SessionFactory sessionFactory;
	protected Session currentSession(){
		return sessionFactory.getCurrentSession();
	}

	@Override
	public void create(RopeMakingModel ropeMakingModel) {

		currentSession().saveOrUpdate(ropeMakingModel);
	}

	@Override
	public void update(RopeMakingModel ropeMakingModel) {
		currentSession().update(ropeMakingModel);

	}

	@Override
	public RopeMakingModel edit(int id) {
		return find(id);
	}

	@Override
	public void delete(int id) {
		FarmerRegistrationModel farmerRegistrationModel = new FarmerRegistrationModel();
		String hql = "Delete from dbo.jcirop where rpmrefid= '"+id+"' " ;
		this.sessionFactory.getCurrentSession().createSQLQuery(hql).executeUpdate();
	}

	@Override
	public RopeMakingModel find(int id) {
		return (RopeMakingModel) currentSession().get(RopeMakingModel.class, id);
	}

	/*
	 * @Override public List<RopeMakingModel> getAll(String placeofactivity) {
	 * Criteria c =
	 * this.sessionFactory.getCurrentSession().createCriteria(RopeMakingModel.class)
	 * ;
	 * 
	 * List<Integer> result = new ArrayList<>(); HttpSession
	 * session1=request.getSession(false); String querystr = ""; int is_ho =
	 * (int)session1.getAttribute("is_ho"); System.out.println("is_hois_ho"+is_ho);
	 * if(is_ho == 1) { querystr =
	 * "select a.*, b.centername  from jcirop a left Join jcipurchasecenter b on a.placeofactivity = b.CENTER_CODE"
	 * ; }else {
	 * querystr="select a.*, b.centername  from jcirop a left Join jcipurchasecenter b on a.placeofactivity = b.CENTER_CODE where a.placeofactivity='"
	 * +placeofactivity+"'"; } Session session = sessionFactory.getCurrentSession();
	 * Transaction tx = session.beginTransaction(); SQLQuery query =
	 * session.createSQLQuery(querystr); List<Object[]> rows = query.list();
	 * List<RopeMakingModel> ll = new ArrayList<>(); for(Object[] row: rows) {
	 * 
	 * 
	 * int rpmrefid = (int)row[0]; String basis = (String)row[1]; String cropyr =
	 * (String)row[2]; String poa = (String)row[3]; String ropeUsed =
	 * (String)row[4]; String binNo = (String)row[5]; String juteVariety =
	 * (String)row[6]; String ropeMade = (String)row[7]; String crtddate =
	 * (String)row[8]; String crtdby = (String)row[9]; String ropeBalance =
	 * (String)row[10]; //String datereport = (String)row[11]; String region =
	 * (String)row[12]; String dpcName = (String)row[15]; RopeMakingModel rope = new
	 * RopeMakingModel(); rope.setBasis(basis); rope.setBinno(binNo);
	 * System.out.println("place of activity"+poa);
	 * 
	 * rope.setCreateddate(crtddate); rope.setCropyr(cropyr);
	 * rope.setPlaceofactivity(dpcName); //rope.setDatereport(datereport);
	 * rope.setRopeused(ropeUsed); rope.setRope_balance(ropeBalance);
	 * rope.setJutevariety(juteVariety); rope.setRopemade(ropeMade);
	 * rope.setRpmrefid(rpmrefid); ll.add(rope); } return ll;
	 * }
	 */
		
	

	@Override
	public boolean submitform(RopeMakingModel ropeMakingModel) {
		this.sessionFactory.getCurrentSession().save(ropeMakingModel);
		return false;
	}

	@Override
	public List <RopeMakingModel> ropeMakingList(int regionId) {
		List<Integer> result = new ArrayList<>();
		String querystr = "select a.*, b.centername  from jcirop a Inner Join jcipurchasecenter b on a.placeofactivity = b.CENTER_CODE where a.placeofactivity='"+regionId+"'";
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		SQLQuery query = session.createSQLQuery(querystr);
		List<Object[]> rows = query.list();
		List<RopeMakingModel> ll = new ArrayList<>();
		for(Object[] row: rows) {
			int rpmrefid = (int)row[0];
			String datereport = (String)row[1];
			String basis = (String)row[2];
			String cropyr = (String)row[4];
			String ropeUsed = (String)row[6];
			String binNo = (String)row[8];
			String juteVariety = (String)row[9];
			String ropeMade = (String)row[10];
			String ropeBalance = (String)row[15];
			String dpcName = (String)row[17];
			RopeMakingModel rope = new RopeMakingModel();
			rope.setBasis(basis);
			rope.setBinno(binNo);
			rope.setCreateddate("");
			rope.setCropyr(cropyr);
			rope.setPlaceofactivity(dpcName);
			rope.setDatereport(datereport);
			rope.setRopeused(ropeUsed);
			rope.setRope_balance(ropeBalance);
			rope.setJutevariety(juteVariety);
			rope.setRopemade(ropeMade);
			rope.setRpmrefid(rpmrefid);
			ll.add(rope);
			 
		}
		 return ll;
	}

	@Override
	public List<String> findBinno(String cropyr, String dpcid) {
		List<String> result = new ArrayList<>();
		String querystr = "select distinct(binno) from jciprocurement where placeofpurchase='"+dpcid+"' and cropyr='"+cropyr+"'and binno not in(select binNo from tbl_jci_bin)";
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		SQLQuery query = session.createSQLQuery(querystr);
		result = query.list();
//System.out.println("====================>>>>>>>>>>>>>>>>>>>result  "+result);
		return result;
	}

	@Override
	public List<RopeMakingModel> getAll(String placeofactivity, String regionId, String zoneId) {

		
		List<RopeMakingModel> result = new ArrayList<>();
		HttpSession session1 = request.getSession(false);
		
		String querystr = "";
		String roletypes = (String) session1.getAttribute("roletype");

		if(roletypes.equalsIgnoreCase("HO")) {
	 querystr = "select a.*, b.centername  from jcirop a left Join jcipurchasecenter b on a.placeofactivity = b.CENTER_CODE";
		}
		else if(roletypes.equalsIgnoreCase("ZO")){
			
			querystr="  select a.*, b.centername  from jcirop a left Join jcipurchasecenter b on a.placeofactivity = b.CENTER_CODE LEFT JOIN jcirodetails c ON b.rocode = c.rocode where c.zonecode='"+zoneId+"'";
				
		}
		else if(roletypes.equalsIgnoreCase("RO")){
			querystr="select a.*, b.centername  from jcirop a left Join jcipurchasecenter b on a.placeofactivity = b.CENTER_CODE where b.rocode='"+regionId+"'";
		}
		else {
			querystr="select a.*, b.centername  from jcirop a left Join jcipurchasecenter b on a.placeofactivity = b.CENTER_CODE where a.placeofactivity='"+placeofactivity+"'";
		}
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		SQLQuery query = session.createSQLQuery(querystr);
		List<Object[]> rows = query.list();
		
		for(Object[] row: rows) {
			
			
			int rpmrefid = (int)row[0];
			String basis = (String)row[1];
			String cropyr = (String)row[2];
			String poa = (String)row[3];
			String ropeUsed = (String)row[4];
			String binNo = (String)row[5];
			String juteVariety = (String)row[6];
			String ropeMade = (String)row[7];
			String crtddate = (String)row[8];
			String crtdby = (String)row[9];
			String ropeBalance = (String)row[10];
			String datereport = (String)row[11];
			String region = (String)row[12]; 
			String dpcName = (String)row[15];
			RopeMakingModel rope = new RopeMakingModel();
			rope.setBasis(basis);
			rope.setBinno(binNo);
			System.out.println("place of activity"+poa);
		
			rope.setCreateddate(crtddate);
			rope.setCropyr(cropyr);
			rope.setPlaceofactivity(dpcName);
			rope.setDatereport(datereport);
			rope.setRopeused(ropeUsed);
			rope.setRope_balance(ropeBalance);
			rope.setJutevariety(juteVariety);
			rope.setRopemade(ropeMade);
			rope.setRpmrefid(rpmrefid);
			result.add(rope);
		}
		return result;
		
	}



}
