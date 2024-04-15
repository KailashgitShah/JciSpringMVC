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
	public List<BalePreparation> getbyFilter(String dpc, String fromdate, String todate,String cropyear, String basiss) {
		//String querystr = "SELECT pur.centername,bale.* FROM jcibalepreparation bale left join jcipurchasecenter pur on bale.place_of_packing = pur.CENTER_CODE where bale.place_of_packing = '"+dpc+"' and packing_date between '"+fromdate+"' and'"+todate+"' and bale.basis = '"+basiss+"' and bale.crop_year = '"+cropyear+"'";
				
				String querystr = "SELECT pur.centername, bale.jute_grade, bale.bin_no, bale.crop_year, bale.jute_variety, bale.packing_date, SUM(bale.bale_no) as balesum " +
		                "FROM jcibalepreparation bale " +
		                "LEFT JOIN jcipurchasecenter pur ON bale.place_of_packing = pur.CENTER_CODE " +
		                "WHERE bale.jute_grade LIKE '%1' AND bale.crop_year = '"+cropyear+"' AND bale.basis = '"+todate+"' AND bale.place_of_packing = '"+todate+"' and bale.jute_variety='"+todate+"' " +
		                "GROUP BY pur.centername, bale.jute_grade, bale.bin_no, bale.crop_year, bale.jute_variety,bale.packing_date " +
		                "UNION ALL " +
		                "SELECT pur.centername, bale.jute_grade, bale.bin_no, bale.crop_year, bale.jute_variety, bale.packing_date, SUM(bale.bale_no) as balesum " +
		                "FROM jcibalepreparation bale " +
		                "LEFT JOIN jcipurchasecenter pur ON bale.place_of_packing = pur.CENTER_CODE " +
		                "WHERE bale.jute_grade LIKE '%2' AND bale.crop_year = '2023-2024' AND bale.basis = 'MSP' AND bale.place_of_packing = '0084' and bale.jute_variety='Tossa (New)' " +
		                "GROUP BY pur.centername, bale.jute_grade, bale.bin_no, bale.crop_year, bale.jute_variety,bale.packing_date " +
		                "UNION ALL " +
		                "SELECT pur.centername, bale.jute_grade, bale.bin_no, bale.crop_year, bale.jute_variety, bale.packing_date, SUM(bale.bale_no) as balesum " +
		                "FROM jcibalepreparation bale " +
		                "LEFT JOIN jcipurchasecenter pur ON bale.place_of_packing = pur.CENTER_CODE " +
		                "WHERE bale.jute_grade LIKE '%3' AND bale.crop_year = '2023-2024' AND bale.basis = 'MSP' AND bale.place_of_packing = '0084' and bale.jute_variety='Tossa (New)' " +
		                "GROUP BY pur.centername, bale.jute_grade, bale.bin_no, bale.crop_year, bale.jute_variety,bale.packing_date " +
		                "UNION ALL " +
		                "SELECT pur.centername, bale.jute_grade, bale.bin_no, bale.crop_year, bale.jute_variety, bale.packing_date, SUM(bale.bale_no) as balesum " +
		                "FROM jcibalepreparation bale " +
		                "LEFT JOIN jcipurchasecenter pur ON bale.place_of_packing = pur.CENTER_CODE " +
		                "WHERE bale.jute_grade LIKE '%4' AND bale.crop_year = '2023-2024' AND bale.basis = 'MSP' AND bale.place_of_packing = '0084' and bale.jute_variety='Tossa (New)' " +
		                "GROUP BY pur.centername, bale.jute_grade, bale.bin_no, bale.crop_year, bale.jute_variety,bale.packing_date " +
		                "UNION ALL " +
		                "SELECT pur.centername, bale.jute_grade, bale.bin_no, bale.crop_year, bale.jute_variety, bale.packing_date, SUM(bale.bale_no) as balesum " +
		                "FROM jcibalepreparation bale " +
		                "LEFT JOIN jcipurchasecenter pur ON bale.place_of_packing = pur.CENTER_CODE " +
		                "WHERE bale.jute_grade LIKE '%5' AND bale.crop_year = '2023-2024' AND bale.basis = 'MSP' AND bale.place_of_packing = '0084' and bale.jute_variety='Tossa (New)' " +
		                "GROUP BY pur.centername, bale.jute_grade, bale.bin_no, bale.crop_year, bale.jute_variety,bale.packing_date " +
		                "UNION ALL " +
		                "SELECT pur.centername, bale.jute_grade, bale.bin_no, bale.crop_year, bale.jute_variety, bale.packing_date, SUM(bale.bale_no) as balesum " +
		                "FROM jcibalepreparation bale " +
		                "LEFT JOIN jcipurchasecenter pur ON bale.place_of_packing = pur.CENTER_CODE " +
		                "WHERE bale.jute_grade LIKE '%6' AND bale.crop_year = '2023-2024' AND bale.basis = 'MSP' AND bale.place_of_packing = '0084' and bale.jute_variety='Tossa (New)' " +
		                "GROUP BY pur.centername, bale.jute_grade, bale.bin_no, bale.crop_year, bale.jute_variety,bale.packing_date " +
		                "UNION ALL " +
		                "SELECT pur.centername, bale.jute_grade, bale.bin_no, bale.crop_year, bale.jute_variety, bale.packing_date, SUM(bale.bale_no) as balesum " +
		                "FROM jcibalepreparation bale " +
		                "LEFT JOIN jcipurchasecenter pur ON bale.place_of_packing = pur.CENTER_CODE " +
		                "WHERE bale.jute_grade LIKE '%7' AND bale.crop_year = '2023-2024' AND bale.basis = 'MSP' AND bale.place_of_packing = '0084' and bale.jute_variety='Tossa (New)' " +
		                "GROUP BY pur.centername, bale.jute_grade, bale.bin_no, bale.crop_year, bale.jute_variety,bale.packing_date " +
		                "UNION ALL " +
		                "SELECT pur.centername, bale.jute_grade, bale.bin_no, bale.crop_year, bale.jute_variety, bale.packing_date, SUM(bale.bale_no) as balesum " +
		                "FROM jcibalepreparation bale " +
		                "LEFT JOIN jcipurchasecenter pur ON bale.place_of_packing = pur.CENTER_CODE " +
		                "WHERE bale.jute_grade LIKE '%8' AND bale.crop_year = '2023-2024' AND bale.basis = 'MSP' AND bale.place_of_packing = '0084' and bale.jute_variety='Bimli' " +
		                "GROUP BY pur.centername, bale.jute_grade, bale.bin_no, bale.crop_year, b";

	
				
				
				
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

}
