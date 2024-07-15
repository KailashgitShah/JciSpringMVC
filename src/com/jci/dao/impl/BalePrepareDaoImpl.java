package com.jci.dao.impl;

import java.sql.Date;
import java.util.ArrayList;
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

import com.jci.dao.BalePrepareDao;
import com.jci.model.BalePreparation;
import com.jci.model.FarmerRegistrationModel;
import com.jci.model.RopeMakingModel;

@Transactional
@Repository
public class BalePrepareDaoImpl implements  BalePrepareDao {

	@Autowired
	private HttpServletRequest request;
	@Autowired
	SessionFactory sessionFactory;
	protected Session currentSession(){
		return sessionFactory.getCurrentSession();
	}

	@Override
	public void create(BalePreparation BalePreparation) {
		currentSession().save(BalePreparation);
	}

	@Override
	public void update(BalePreparation BalePreparation) {
		currentSession().update(BalePreparation);
	}

	@Override
	public BalePreparation edit(int id) {
		return find(id);
	}

	@Override
	public void delete(int id) {
		FarmerRegistrationModel farmerRegistrationModel = new FarmerRegistrationModel();
		String hql = "Delete from dbo.bna where id = '"+id+"' " ;
		this.sessionFactory.getCurrentSession().createSQLQuery(hql).executeUpdate();
	}

	@Override
	public BalePreparation find(int id) {
		return (BalePreparation) currentSession().get(BalePreparation.class, id);
	}

	@Override
	public List<BalePreparation> getAll(String place_of_packing, String regionId, String zoneId) {
		Criteria c = this.sessionFactory.getCurrentSession().createCriteria(BalePreparation.class);
		
		List<Integer> result = new ArrayList<>();
		
		HttpSession session1 = request.getSession(false);
		
		String querystr = "";
		String roletypes = (String) session1.getAttribute("roletype");

		if(roletypes.equalsIgnoreCase("HO")) {
		
	querystr = "SELECT pur.centername,bale.* FROM jcibalepreparation bale left join jcipurchasecenter pur on bale.place_of_packing = pur.CENTER_CODE";
		}
		else if(roletypes.equalsIgnoreCase("ZO"))
		{
			querystr = "SELECT pur.centername,bale.* FROM jcibalepreparation bale left join jcipurchasecenter pur on bale.place_of_packing = pur.CENTER_CODE LEFT JOIN jcirodetails c ON pur.rocode = c.rocode where c.zonecode='"+zoneId+"'";
			
		}
		else if(roletypes.equalsIgnoreCase("RO")){
			
			{
				//querystr = "SELECT pur.centername,bale.* FROM jcibalepreparation bale left join jcipurchasecenter pur on bale.place_of_packing = pur.CENTER_CODE where bale.where pur.rocode='"+regionId+"'";
				querystr = "SELECT pur.centername,bale.* FROM jcibalepreparation bale left join jcipurchasecenter pur on bale.place_of_packing = pur.CENTER_CODE where pur.rocode='"+regionId+"'";
				
			}	
		}
		else 
		{
		
		
			querystr = "SELECT pur.centername,bale.* FROM jcibalepreparation bale left join jcipurchasecenter pur on bale.place_of_packing = pur.CENTER_CODE where bale.place_of_packing = '"+place_of_packing+"'";
		}
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		SQLQuery query = session.createSQLQuery(querystr);
		List<Object[]> rows = query.list();
		List<BalePreparation> ll = new ArrayList<>();
		for(Object[] row: rows) {
			
			String dpcName = (String)row[0];
			int baleid = (int)row[1];
			String packddate = (String)row[2];
			String cropyr = (String)row[3];
			String binNo = (String)row[4];
			String basis = (String)row[5];
			String juteVariety = (String)row[6];
			String slipfrom = (String)row[7];
			String slipto = (String)row[8];
			int baleno = (int)row[9];
			int crtdby = (int)row[10];
			String creation = (String)row[12];
			String dpccode = (String)row[13];
			String jutegrade = (String)row[14]; 
			BalePreparation bale = new BalePreparation();
			bale.setBale_no(baleno);
			bale.setBaleId(baleid);
			bale.setBasis(basis);
			bale.setBin_no(binNo);
			bale.setCreated_by(crtdby);
			bale.setCreation_date(creation);
	        bale.setCrop_year(cropyr);
	        bale.setJute_grade(jutegrade);
	        bale.setJute_variety(juteVariety);
	        bale.setPacking_date(packddate);
	        bale.setPlace_of_packing(dpcName);
	        bale.setSlip_no_from(slipfrom);
	        bale.setSlip_no_to(slipto);
	        
			ll.add(bale);
		}
		return ll;
	}

	@Override
	public boolean submitform(BalePreparation BalePreparation) {
		this.sessionFactory.getCurrentSession().save(BalePreparation);
		return false;
	}

	@Override
	public List<BalePreparation> getbyFilter(String dpc,String fromdate,  String todate, String cropyear, String basis, String jutevariety){
		String querystr = "SELECT bale.bin_no,bale.packing_date, pur.centername, bale.jute_grade,  bale.crop_year, bale.jute_variety,SUM(bale.bale_no) as balesum, bale.created_by \r\n" + 
				"FROM jcibalepreparation bale\r\n" + 
				"LEFT JOIN jcipurchasecenter pur ON bale.place_of_packing = pur.CENTER_CODE\r\n" + 
				"WHERE bale.jute_grade LIKE '%' \r\n" + 
				"AND CONVERT(DATE,bale.packing_date,105) between+ '"+fromdate+"' and '"+todate+"'  \r\n" + 
				"AND bale.crop_year = '"+cropyear+"' \r\n" + 
				"AND bale.basis = '"+basis+"' \r\n" + 
				"AND bale.place_of_packing = '"+dpc+"' \r\n" + 
				"and bale.jute_variety = '"+jutevariety+"' \r\n" +
				"GROUP BY pur.centername, bale.jute_grade, bale.bin_no, bale.crop_year, bale.jute_variety,bale.packing_date, bale.created_by \r\n" + 
				"order by CONVERT(DATE,bale.packing_date,105) ASC";

		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		SQLQuery query = session.createSQLQuery(querystr);
		List<Object[]> rows = query.list();
		List<BalePreparation> ll = new ArrayList<>();
		for(Object[] row: rows) {
			
			String bin_no = (String)row[0];
			String packing_date = (String)row[1];
			String place_of_packing = (String)row[2];
			String jute_grade = (String)row[3];
			String crop_year = (String)row[4];
			String jute_variety = (String)row[5];
			int bale_no = (int)row[6];
			int created_by = (int)row[7];

			BalePreparation bale = new BalePreparation();
			bale.setBin_no(bin_no);
			bale.setPacking_date(packing_date);
			bale.setPlace_of_packing(place_of_packing);
			bale.setJute_grade(jute_grade);
			bale.setCrop_year(crop_year);
			bale.setJute_variety(jute_variety);
			bale.setBale_no(bale_no);
			bale.setCreated_by(created_by);
			
	        
			ll.add(bale);
		}
		return ll;

	}

	@Override
	public String getcropYear(String cropyear) {
		String querystr = "select crop_year from jcibalepreparation where crop_year ='" + cropyear + "'";
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		SQLQuery query = session.createSQLQuery(querystr);
		String cropyears = query.list().get(0).toString();
		return cropyears;
}

	@Override
	public String getjuteVariety(String juteVariety) {
		String querystr = "select jute_variety from jcibalepreparation where jute_variety ='" + juteVariety + "'";
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		SQLQuery query = session.createSQLQuery(querystr);
		String jutevariety = query.list().get(0).toString();
		return jutevariety;

	}

	@Override
	public String getbasis(String basis) {
		String querystr = "select basis from jcibalepreparation where basis ='" + basis + "'";
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		SQLQuery query = session.createSQLQuery(querystr);
		String jutevariety = query.list().get(0).toString();
		return jutevariety;

	}
	
	@Override
	public List<BalePreparation> RegionWiseData(String roname,String fromdate,  String purchasesdateTo,String cropyear, String basis, String jutevariety){
		String querystr = "SELECT \r\n" + 
				"    ro.roname, \r\n" + 
				"    pur.nominal_wt,  \r\n" + 
				"    bale.basis,  \r\n" + 
				"    bale.packing_date,  \r\n" + 
				"    pur.centername,  \r\n" + 
				"    bale.crop_year,  \r\n" + 
				"    bale.jute_variety, \r\n" + 
				"    SUM(bale.bale_no) AS balesum, \r\n" + 
				"    bale.jute_grade, pur.CENTER_CODE\r\n" + 
				"FROM  \r\n" + 
				"    jcibalepreparation bale \r\n" + 
				"LEFT JOIN  \r\n" + 
				"    jcipurchasecenter pur  \r\n" + 
				"ON  \r\n" + 
				"    bale.place_of_packing = pur.CENTER_CODE \r\n" + 
				"LEFT JOIN  \r\n" + 
				"    jcirodetails ro \r\n" + 
				"ON  \r\n" + 
				"    bale.region = ro.rocode \r\n" + 
				"WHERE  \r\n" + 
				"    bale.jute_grade LIKE '%'  \r\n" + 
				"    AND TRY_CONVERT(DATE, bale.packing_date, 105) BETWEEN '"+fromdate+"' AND '"+purchasesdateTo+"'\r\n" + 
				"    AND bale.crop_year = '"+cropyear+"'   \r\n" + 
				"    AND bale.basis =  '"+basis+"'   \r\n" + 
				"    AND bale.jute_variety = '"+jutevariety+"'   \r\n" + 
				"    AND bale.region = '"+roname+"'   \r\n" + 
				"GROUP BY  \r\n" + 
				"    ro.roname, \r\n" + 
				"    pur.nominal_wt,  \r\n" + 
				"    pur.centername,  \r\n" + 
				"    bale.basis,  \r\n" + 
				"    bale.packing_date,  \r\n" + 
				"    bale.crop_year,  \r\n" + 
				"    bale.jute_variety, \r\n" + 
				"    bale.jute_grade , pur.CENTER_CODE\r\n" + 
				"ORDER BY  \r\n" + 
				"    pur.CENTER_CODE ASC;\r\n" + 
				"";

		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		SQLQuery query = session.createSQLQuery(querystr);
		List<Object[]> rows = query.list();
		List<BalePreparation> ll = new ArrayList<>();
		for(Object[] row: rows) {
			
			String region = (String)row[0];
			double doubleValue = (Double) row[1];
			float nominalWt = (float) doubleValue;
			String basisdb = (String)row[2];
			String packing_date = (String)row[3];
			String place_of_packing = (String)row[4];
			String crop_year = (String)row[5];
			String jute_variety = (String)row[6];
			int bale_no = (int)row[7];
			String jute_grade = (String)row[8];

		    
			BalePreparation bale = new BalePreparation();
			bale.setRegion(region);
			bale.setNominalWt(nominalWt);
			bale.setBasis(basis);
			bale.setPacking_date(packing_date);
			bale.setPlace_of_packing(place_of_packing);
			bale.setCrop_year(crop_year);
			bale.setJute_variety(jute_variety);
			bale.setBale_no(bale_no);
			bale.setJute_grade(jute_grade);
	        
			ll.add(bale);
		}
		return ll;

	}

	@Override
	public List<BalePreparation> DpcWiseData(String purchasesdateFrom, String purchasesdateTo,
			String cropyear, String basis, String juteVariety, String dpc) {
		String querystr = "\r\n" + 
				"  SELECT \r\n" + 
				"    ro.roname, \r\n" + 
				"    pur.nominal_wt,  \r\n" + 
				"    bale.basis,  \r\n" + 
				"    bale.packing_date,  \r\n" + 
				"    pur.centername,  \r\n" + 
				"    bale.crop_year,  \r\n" + 
				"    bale.jute_variety, \r\n" + 
				"    SUM(bale.bale_no) AS balesum, \r\n" + 
				"    bale.jute_grade \r\n" + 
				"FROM  \r\n" + 
				"    jcibalepreparation bale \r\n" + 
				"LEFT JOIN  \r\n" + 
				"    jcipurchasecenter pur  \r\n" + 
				"ON  \r\n" + 
				"    bale.place_of_packing = pur.CENTER_CODE \r\n" + 
				"LEFT JOIN  \r\n" + 
				"    jcirodetails ro \r\n" + 
				"ON  \r\n" + 
				"    bale.region = ro.rocode \r\n" + 
				"WHERE  \r\n" + 
				"    bale.jute_grade LIKE '%'  \r\n" + 
				"    AND TRY_CONVERT(DATE, bale.packing_date, 105) BETWEEN '"+purchasesdateFrom+"' AND '"+purchasesdateTo+"'\r\n" + 
				"    AND bale.crop_year = '"+cropyear+"'  \r\n" + 
				"    AND bale.basis =  '"+basis+"'  \r\n" + 
				"    AND bale.jute_variety = '"+juteVariety+"'   \r\n" + 
				"   \r\n" + 
				"    AND bale.place_of_packing = '"+dpc+"'\r\n" + 
				"GROUP BY  \r\n" + 
				"    ro.roname, \r\n" + 
				"    pur.nominal_wt,  \r\n" + 
				"    pur.centername,  \r\n" + 
				"    bale.basis,  \r\n" + 
				"    bale.packing_date,  \r\n" + 
				"    bale.crop_year,  \r\n" + 
				"    bale.jute_variety, \r\n" + 
				"    bale.jute_grade \r\n" + 
				"ORDER BY  \r\n" + 
				"    TRY_CONVERT(DATE, bale.packing_date, 105) ASC;\r\n" + 
				"" + 
				"";

		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		SQLQuery query = session.createSQLQuery(querystr);
		List<Object[]> rows = query.list();
		List<BalePreparation> ll = new ArrayList<>();
		for(Object[] row: rows) {
			
			String region = (String)row[0];
			double doubleValue = (Double) row[1];
			float nominalWt = (float) doubleValue;
			String basisdb = (String)row[2];
			String packing_date = (String)row[3];
			String place_of_packing = (String)row[4];
			String crop_year = (String)row[5];
			String jute_variety = (String)row[6];
			int bale_no = (int)row[7];
			String jute_grade = (String)row[8];

		    
			BalePreparation bale = new BalePreparation();
			bale.setRegion(region);
			bale.setNominalWt(nominalWt);
			bale.setBasis(basis);
			bale.setPacking_date(packing_date);
			bale.setPlace_of_packing(place_of_packing);
			bale.setCrop_year(crop_year);
			bale.setJute_variety(jute_variety);
			bale.setBale_no(bale_no);
			bale.setJute_grade(jute_grade);
	        
			ll.add(bale);
		}
		return ll;

	}

	@Override
	public String regionId(String roname) {
		String querystr = "select region from jcibalepreparation where region ='" + roname + "'";
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		SQLQuery query = session.createSQLQuery(querystr);
		String jutevariety = query.list().get(0).toString();
		return jutevariety;

	}
	@Override
	public List<BalePreparation> allBaleDataList(String purchasesdateFrom, String purchasesdateTo, String cropyear, String basis, String juteVariety) {
	    String querystr = "SELECT \r\n" + 
	            "    ro.roname, \r\n" + 
	            "    pur.nominal_wt,  \r\n" + 
	            "    bale.basis,  \r\n" + 
	            "    bale.packing_date,  \r\n" + 
	            "    bale.crop_year,  \r\n" + 
	            "    bale.jute_variety, \r\n" + 
	            "    SUM(bale.bale_no) AS balesum, \r\n" + 
	            "    bale.jute_grade, ro.rocode \r\n" + 
	            "FROM  \r\n" + 
	            "    jcibalepreparation bale \r\n" + 
	            "LEFT JOIN  \r\n" + 
	            "    jcipurchasecenter pur  \r\n" + 
	            "ON  \r\n" + 
	            "    bale.place_of_packing = pur.CENTER_CODE \r\n" + 
	            "LEFT JOIN  \r\n" + 
	            "    jcirodetails ro \r\n" + 
	            "ON  \r\n" + 
	            "    bale.region = ro.rocode \r\n" + 
	            "WHERE  \r\n" + 
	            "    bale.jute_grade LIKE '%'  \r\n" + 
				"    AND TRY_CONVERT(DATE, bale.packing_date, 105) BETWEEN '"+purchasesdateFrom+"' AND '"+purchasesdateTo+"'\r\n" + 
	            "    AND bale.crop_year = '"+cropyear+"'   \r\n" + 
	            "    AND bale.basis =  '"+basis+"'   \r\n" + 
	            "    AND bale.jute_variety = '"+juteVariety+"'   \r\n" + 
	            "GROUP BY  \r\n" + 
	            "    ro.roname, \r\n" + 
	            "    pur.nominal_wt,  \r\n" + 
	            "    bale.basis,  \r\n" + 
	            "    bale.packing_date,  \r\n" + 
	            "    bale.crop_year,  \r\n" + 
	            "    bale.jute_variety, \r\n" + 
	            "    bale.jute_grade, ro.rocode \r\n" + 
	            "ORDER BY  \r\n" + 
	            "    ro.rocode ASC\r\n";

	    Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		SQLQuery query = session.createSQLQuery(querystr);
		List<Object[]> rows = query.list();
		List<BalePreparation> ll = new ArrayList<>();
		for(Object[] row: rows) {
			
			String region = (String)row[0];
			double doubleValue = (Double) row[1];
			float nominalWt = (float) doubleValue;
			String basisdb = (String)row[2];
			String packing_date = (String)row[3];
			String crop_year = (String)row[4];
			String jute_variety = (String)row[5];
			int bale_no = (int)row[6];
			String jute_grade = (String)row[7];

		    
			BalePreparation bale = new BalePreparation();
			bale.setRegion(region);
			bale.setNominalWt(nominalWt);
			bale.setBasis(basis);
			bale.setPacking_date(packing_date);
			bale.setCrop_year(crop_year);
			bale.setJute_variety(jute_variety);
			bale.setBale_no(bale_no);
			bale.setJute_grade(jute_grade);
	        
			ll.add(bale);
		}
		return ll;

	}


	
}
