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

import com.jci.dao.PurchaseReportDao;
import com.jci.model.DailyReportDTO;
import com.jci.model.FarmerRegModel;
import com.jci.model.LedgerReportDTO;
import com.jci.model.PurchaseReportDTO;

@Transactional
@Repository
public class PurchaseReportDaoImpl implements PurchaseReportDao{

	@Autowired
	SessionFactory sessionFactory;

	protected Session currentSession() {
		return sessionFactory.getCurrentSession();
	}




	
	@Override
	public String finddpcbyid(String id) {
				String querystr = "select centername from jcipurchasecenter where CENTER_CODE ='" + id + "'";
				Session session = sessionFactory.getCurrentSession();
				Transaction tx = session.beginTransaction();
				SQLQuery query = session.createSQLQuery(querystr);
				String dpc = query.list().get(0).toString();
				return dpc;
	}

	
	@Override
	public String fname(String id) {
				String querystr = "select F_NAME from jcirmt where F_ID ='" + id + "'";
				Session session = sessionFactory.getCurrentSession();
				Transaction tx = session.beginTransaction();
				SQLQuery query = session.createSQLQuery(querystr);
				String name = query.list().get(0).toString();
				return name;
	}

	@Override
	public List<LedgerReportDTO> LedgerReportList(String basis, String cropyr, String farmer) {
		 List<Integer> result = new ArrayList<>();
		    String querystr = "";
		    querystr="  SELECT \r\n" + 
		    		"    p.cropyr,\r\n" + 
		    		"    p.farmerregno,\r\n" + 
		    		"    p.basis,\r\n" + 
		    		"    p.datepurchase AS Date,\r\n" + 
		    		"    p.rateslipno AS [Rate Slip Number],\r\n" + 
		    		"    p.tallyslipno AS [Tally Number],\r\n" + 
		    		"    SUM(p.grossquantity) / 100 AS [Gross Quantity (Qtls)],\r\n" + 
		    		"    SUM(p.deductionquantity) / 100 AS [Deduction (Qtls)],\r\n" + 
		    		"    SUM(p.netquantity) / 100 AS [Net Quantity (Qtls)],\r\n" + 
		    		"    SUM(p.grasatrate) / 100 AS [grasatrate (Qtls)],\r\n" + 
		    		"    SUM(SUM(p.grossquantity - p.deductionquantity)) OVER (PARTITION BY p.farmerregno ORDER BY p.datepurchase ROWS UNBOUNDED PRECEDING) / 100 AS [Communitative (Qtls)],\r\n" + 
		    		"    rmt.F_NAME,\r\n" + 
		    		"    rmt.F_AC_NO,\r\n" + 
		    		"    rmt.F_ADDRESS,\r\n" + 
		    		"    rmt.F_MOBILE,\r\n" + 
		    		"    rmt.F_ID_PROF_NO,\r\n" + 
		    		"    rmt.F_BANK_NAME,\r\n" + 
		    		"    rmt.F_BANK_IFSC,\r\n" + 
		    		"    tsp.date AS [Payment Date],\r\n" + 
		    		"    pc.centername AS CentreName\r\n" + 
		    		"FROM \r\n" + 
		    		"    jciprocurement p\r\n" + 
		    		"JOIN \r\n" + 
		    		"    jcirmt rmt ON p.farmerregno = rmt.F_REG_NO\r\n" + 
		    		"JOIN\r\n" + 
		    		"    jcitallyslippayment tsp ON rmt.F_AC_NO = tsp.beneficiaryAC_No\r\n" + 
		    		"JOIN\r\n" + 
		    		"    jcipurchasecenter pc ON rmt.dpc_id = pc.CENTER_CODE\r\n" + 
		    		"WHERE \r\n" + 
		    		"    p.cropyr = '" + cropyr + "'\r\n" + 
		    		"    AND p.basis ='" + basis + "'\r\n" + 
		    		"    AND p.farmerregno = '" + farmer + "'\r\n" + 
		    		"GROUP BY \r\n" + 
		    		"    p.cropyr,\r\n" + 
		    		"    p.farmerregno,\r\n" + 
		    		"    p.basis,\r\n" + 
		    		"    p.datepurchase,\r\n" + 
		    		"    p.rateslipno,\r\n" + 
		    		"    p.tallyslipno,\r\n" + 
		    		"    rmt.F_NAME,\r\n" + 
		    		"    rmt.F_AC_NO,\r\n" + 
		    		"    rmt.F_ADDRESS,\r\n" + 
		    		"    rmt.F_MOBILE,\r\n" + 
		    		"    rmt.F_ID_PROF_NO,\r\n" + 
		    		"    rmt.F_BANK_NAME,\r\n" + 
		    		"    rmt.F_BANK_IFSC,\r\n" + 
		    		"    rmt.F_REG_NO,\r\n" + 
		    		"    tsp.date,\r\n" + 
		    		"    pc.centername\r\n" + 
		    		"ORDER BY \r\n" + 
		    		"    p.farmerregno";
		    Session session = sessionFactory.getCurrentSession();
		    Transaction tx = session.beginTransaction();
		    SQLQuery query = session.createSQLQuery(querystr);
		    List<Object[]> rows = query.list();
		    //System.out.println("mydata" + rows.toString());
		    
		    List<LedgerReportDTO> ll = new ArrayList<>();
		    for (Object[] row : rows) {
		    	LedgerReportDTO ledgerReportDTO = new LedgerReportDTO();
		    	
		    	ledgerReportDTO.setCropyear((String) row[0]);
		    	ledgerReportDTO.setFarmerRegNo((String) row[1]);
		    	ledgerReportDTO.setBasis((String) row[2]);
		    	ledgerReportDTO.setDateofPur((String) row[3]);
		    	ledgerReportDTO.setRateSlip((Integer) row[4]);
		    	ledgerReportDTO.setTallySlip((String) row[5]);
		    	ledgerReportDTO.setGrossQty(row[6] != null ? ((BigDecimal) row[6]).doubleValue() : 0.0);
		    	ledgerReportDTO.setDedQty(row[7] != null ? ((BigDecimal) row[7]).doubleValue() : 0.0);
		    	ledgerReportDTO.setNetQty(row[8] != null ? ((BigDecimal) row[8]).doubleValue() : 0.0);
		    	ledgerReportDTO.setGrasatrate(row[9] != null ? ((BigDecimal) row[9]).doubleValue() : 0.0);
		    	ledgerReportDTO.setCumQty(row[10] != null ? ((BigDecimal) row[10]).doubleValue() : 0.0);
		    	ledgerReportDTO.setFarmerName((String) row[11]);
		    	ledgerReportDTO.setAcNo((String) row[12]);
		    	ledgerReportDTO.setAddress((String) row[13]);
		    	ledgerReportDTO.setMobNo((String) row[14]);
		    	ledgerReportDTO.setAadharNo((String) row[15]);
		    	ledgerReportDTO.setBankName((String) row[16]);
		    	ledgerReportDTO.setIfscCode((String) row[17]);
		    	ledgerReportDTO.setPayDate(row[18] == null ? "" : (String) row[18]);
		    	ledgerReportDTO.setDpc((String) row[19]);
		    	
		        ll.add(ledgerReportDTO);
		        System.err.println("ll===="+ll);
		    }
		    
		    return ll;
			}


	@Override
	public List<String> farmerdetail(String F_NAME) {
		//List<Integer> result = new ArrayList<>();
	    String querystr = "";
	    
	    querystr="SELECT F_REG_NO, F_NAME\r\n" + 
	    		"FROM jcirmt\r\n" + 
	    		"WHERE F_REG_NO LIKE '%"+F_NAME+"%'\r\n" + 
	    		"   OR F_NAME LIKE '%"+F_NAME+"%'\r\n" + 
	    		"   OR F_MOBILE LIKE '%"+F_NAME+"%';";
	    
	    Session session = sessionFactory.getCurrentSession();
	    Transaction tx = session.beginTransaction();
	    SQLQuery query = session.createSQLQuery(querystr);
	    List<Object[]> rows = query.list();
	    System.out.println("mydata" + rows.toString());
	    List<String> result = new ArrayList<>();
	    List<FarmerRegModel> ll = new ArrayList<>();
	    for (Object[] row : rows) {
	    	result.add(row[0].toString()+"-"+row[1].toString());
	    }
	    return result;
	}
	
	@Override
	public List<DailyReportDTO> RegionReportList(String Basis, String Jute_Variety, String Crop_Year, String From_date, String To_date) {
	    List<DailyReportDTO> ll = new ArrayList<>();
	    String querystr = "";
	    System.out.println(Crop_Year);
        System.out.println(From_date);

        System.out.println(To_date);

        System.out.println(Basis);

        System.out.println(Jute_Variety);
	    // Check the condition for Basis and construct the query accordingly
	    if (Crop_Year.equals("MSP")) {
	        querystr = "SELECT  \r\n" + 
	        	    "    SUM(ROUND(CAST(r1.gquantity AS DECIMAL(18, 2)), 2)) AS total_gquantity, \r\n" + 
	        	    "    SUM(ROUND(CAST(r1.dquantity AS DECIMAL(18, 2)), 2)) AS total_dquantity, \r\n" + 
	        	    "    SUM(ROUND(CAST(r1.netquantity AS DECIMAL(18, 2)), 2)) AS total_netquantity,\r\n" + 
	        	    "    CAST((SUM(CAST(r1.fibervalue AS DECIMAL(18, 2))) /  NULLIF(SUM(CAST(r1.netquantity AS DECIMAL(18, 2))), 0)) AS INT) AS total_grasatrate,\r\n"+
	        	    "    SUM(CAST(r1.fibervalue AS INT)) AS total_fibervalue,\r\n" + 
	        	    "    ROUND(CAST(mspGrade.grade3 AS DECIMAL(18, 2)), 2) AS total_basisPrice, \r\n" + 
	        	    "    SUM(ROUND((CAST(r1.grade1 AS DECIMAL(18, 2)) / 100) * CAST(r1.netquantity AS DECIMAL(18,2)), 2)) AS grade1_percentage_of_netquantity,\r\n" + 
	        	    "    SUM(ROUND((CAST(r1.grade2 AS DECIMAL(18, 2)) / 100) * CAST(r1.netquantity AS DECIMAL(18, 2)), 2)) AS grade2_percentage_of_netquantity, \r\n" + 
	        	    "    SUM(ROUND((CAST(r1.grade3 AS DECIMAL(18, 2)) / 100) * CAST(r1.netquantity AS DECIMAL(18, 2)), 2)) AS grade3_percentage_of_netquantity, \r\n" + 
	        	    "    SUM(ROUND((CAST(r1.grade4 AS DECIMAL(18, 2)) / 100) * CAST(r1.netquantity AS DECIMAL(18, 2)), 2)) AS grade4_percentage_of_netquantity, \r\n" + 
	        	    "    SUM(ROUND((CAST(r1.grade5 AS DECIMAL(18, 2)) / 100) * CAST(r1.netquantity AS DECIMAL(18, 2)), 2)) AS grade5_percentage_of_netquantity, \r\n" + 
	        	    "    SUM(ROUND((CAST(r1.grade6 AS DECIMAL(18, 2)) / 100) * CAST(r1.netquantity AS DECIMAL(18, 2)), 2)) AS grade6_percentage_of_netquantity, \r\n" + 
	        	    "    SUM(ROUND((CAST(r1.grade7 AS DECIMAL(18, 2)) / 100) * CAST(r1.netquantity AS DECIMAL(18, 2)), 2)) AS grade7_percentage_of_netquantity, \r\n" + 
	        	    "    SUM(ROUND((CAST(r1.grade8 AS DECIMAL(18, 2)) / 100) * CAST(r1.netquantity AS DECIMAL(18, 2)), 2)) AS grade8_percentage_of_netquantity,\r\n" + 
	        	    "    jro.roname AS region_name\r\n" + 
	        	    "FROM \r\n" + 
	        	    "    jcidpc r1 \r\n" + 
	        	    "JOIN  \r\n" + 
	        	    "    jcipurchasecenter jpc ON r1.placeofpurchase = jpc.CENTER_CODE \r\n" + 
	        	    "JOIN \r\n" + 
	        	    "    jcirodetails jro ON r1.region = jro.rocode  \r\n" + 
	        	    "JOIN \r\n" + 
	        	    "    jcimspgradesprice mspGrade ON r1.jutevariety = mspGrade.jute_variety AND mspGrade.crop_yr ='" + Basis + "' \r\n" + 
	        	    "WHERE \r\n" + 
	        	    "    r1.jutevariety = '" + From_date + "' \r\n" + 
	        	    "    AND r1.cropyr =  '" + Basis + "' \r\n" + 
	        	    "    AND r1.basis =  '" + Crop_Year + "' \r\n" + 
	        	    "    AND TRY_CONVERT(DATE, r1.datepurchase, 105) BETWEEN '" + To_date + "' AND '" + Jute_Variety + "'\r\n" + 
	        	    "GROUP BY \r\n" + 
	        	    "    jro.roname, mspGrade.grade3 ";
	        	   

	    }
	    Session session = sessionFactory.getCurrentSession();
	    Transaction tx = session.beginTransaction();
	    SQLQuery query = session.createSQLQuery(querystr);
	    List<Object[]> rows = query.list();

    for (Object[] row : rows) {
        DailyReportDTO dailyReportDTO = new DailyReportDTO();
        dailyReportDTO.setGrossQuand(((BigDecimal) row[0]).doubleValue());
        dailyReportDTO.setDedQuand(((BigDecimal) row[1]).doubleValue());
        dailyReportDTO.setNetQuand(((BigDecimal) row[2]).doubleValue());
        dailyReportDTO.setGarsatRd((int) row[3]);
     // Assuming row[4] is an Object, check its type and cast accordingly
        dailyReportDTO.setFiberVald((int) row[4]);
        dailyReportDTO.setBasisPriced(((BigDecimal) row[5]).doubleValue());
        dailyReportDTO.setGr1d(((BigDecimal) row[6]).doubleValue());
        dailyReportDTO.setGr2d(((BigDecimal) row[7]).doubleValue());
        dailyReportDTO.setGr3d(((BigDecimal) row[8]).doubleValue());
        dailyReportDTO.setGr4d(((BigDecimal) row[9]).doubleValue());
        dailyReportDTO.setGr5d(((BigDecimal) row[10]).doubleValue());
        dailyReportDTO.setGr6d(((BigDecimal) row[11]).doubleValue());
        dailyReportDTO.setGr7d(((BigDecimal) row[12]).doubleValue());
        dailyReportDTO.setGr8d(((BigDecimal) row[13]).doubleValue());
        dailyReportDTO.setRegiond((String) row[14]);
        ll.add(dailyReportDTO);
        System.err.println("ll===="+ll);
    }
    
    return ll;
	}
	
	@Override
	public List<DailyReportDTO> DailyReportList(String Basis, String Jute_Variety, String Crop_Year, String From_date, String To_date, String region) {
	    List<Integer> result = new ArrayList<>();
	    String querystr = "";
	    
	    // Check the condition for Basis and construct the query accordingly
	    if (Basis.equals("MSP")) {
	        querystr = "SELECT  \r\n" + 
	        		"    SUM(ROUND(CAST(r1.gquantity AS DECIMAL(18, 2)), 2)) AS total_gquantity, \r\n" + 
	        		"    SUM(ROUND(CAST(r1.dquantity AS DECIMAL(18, 2)), 2)) AS total_dquantity,\r\n" + 
	        		"    SUM(ROUND(CAST(r1.netquantity AS DECIMAL(18, 2)), 2)) AS total_netquantity,\r\n" + 
	        	    "    CAST((SUM(CAST(r1.fibervalue AS DECIMAL(18, 2))) /  NULLIF(SUM(CAST(r1.netquantity AS DECIMAL(18, 2))), 0)) AS INT) AS total_grasatrate,\r\n"+
	        		"    SUM(CAST(r1.fibervalue AS INT)) AS total_fibervalue,\r\n" + 
	        		"    ROUND(CAST(mspGrade.grade3 AS DECIMAL(18, 2)), 2) AS total_basisPrice, \r\n" + 
	        		"    SUM(ROUND((CAST(r1.grade1 AS DECIMAL(18, 2)) / 100) * CAST(r1.netquantity AS DECIMAL(18,2)), 2)) AS grade1_percentage_of_netquantity,\r\n" + 
	        		"    SUM(ROUND((CAST(r1.grade2 AS DECIMAL(18, 2)) / 100) * CAST(r1.netquantity AS DECIMAL(18, 2)), 2)) AS grade2_percentage_of_netquantity, \r\n" + 
	        		"    SUM(ROUND((CAST(r1.grade3 AS DECIMAL(18, 2)) / 100) * CAST(r1.netquantity AS DECIMAL(18, 2)), 2)) AS grade3_percentage_of_netquantity, \r\n" + 
	        		"    SUM(ROUND((CAST(r1.grade4 AS DECIMAL(18, 2)) / 100) * CAST(r1.netquantity AS DECIMAL(18, 2)), 2)) AS grade4_percentage_of_netquantity, \r\n" + 
	        		"    SUM(ROUND((CAST(r1.grade5 AS DECIMAL(18, 2)) / 100) * CAST(r1.netquantity AS DECIMAL(18, 2)), 2)) AS grade5_percentage_of_netquantity, \r\n" + 
	        		"    SUM(ROUND((CAST(r1.grade6 AS DECIMAL(18, 2)) / 100) * CAST(r1.netquantity AS DECIMAL(18, 2)), 2)) AS grade6_percentage_of_netquantity, \r\n" + 
	        		"    SUM(ROUND((CAST(r1.grade7 AS DECIMAL(18, 2)) / 100) * CAST(r1.netquantity AS DECIMAL(18, 2)), 2)) AS grade7_percentage_of_netquantity, \r\n" + 
	        		"    SUM(ROUND((CAST(r1.grade8 AS DECIMAL(18, 2)) / 100) * CAST(r1.netquantity AS DECIMAL(18, 2)), 2)) AS grade8_percentage_of_netquantity,\r\n" + 
	        		"    jpc.centername\r\n" + 
	        		"FROM jcidpc r1\r\n" + 
	        		"JOIN jcipurchasecenter jpc ON r1.placeofpurchase = jpc.CENTER_CODE\r\n" + 
	        		"JOIN jcimspgradesprice mspGrade ON r1.jutevariety = mspGrade.jute_variety AND mspGrade.crop_yr = '" + Crop_Year + "' \r\n" + 
	        		"WHERE r1.jutevariety = '" + Jute_Variety + "' \r\n" + 
	        		"    AND r1.cropyr = '" + Crop_Year + "' \r\n" + 
	        		"    AND r1.basis = '" + Basis + "' \r\n" + 
	        		"    AND r1.region = '" + region + "' \r\n" + 
	        		"    AND TRY_CONVERT(DATE, r1.datepurchase, 105) BETWEEN '" + From_date + "' AND '" + To_date + "'\r\n" + 
	        		"GROUP BY \r\n" + 
	        		"    jpc.centername,\r\n" + 
	        		"    mspGrade.grade3";
	    } else {
	        querystr = "SELECT r1.gquantity, r1.dquantity, r1.netquantity, r1.grasatrate, r1.fibervalue, r1.grade3 AS basisPrice, " +
	                   "r1.grade1, r1.grade2, r1.grade3, r1.grade4, r1.grade5, r1.grade6, jpc.centername " +
	                   "FROM jcidpc r1 " +
	                   "JOIN jcipurchasecenter jpc ON r1.placeofpurchase = jpc.CENTER_CODE " +
	                   "WHERE r1.jutevariety = '" + Jute_Variety + "' " +
	                   "AND r1.cropyr = '" + Crop_Year + "' " +
	                   "AND r1.basis = '" + Basis + "' " +
	                   "AND r1.region = '" + region + "' " +
	                   "AND TRY_CONVERT(DATE, r1.datepurchase, 105) BETWEEN '" + From_date + "' AND '" + To_date + "'";
	    }
	    
	    // Execute the query and map the results
	    Session session = sessionFactory.getCurrentSession();
	    Transaction tx = session.beginTransaction();
	    SQLQuery query = session.createSQLQuery(querystr);
	    List<Object[]> rows = query.list();
	    System.out.println("mydata" + rows.toString());
	    
	    List<DailyReportDTO> ll = new ArrayList<>();
	    for (Object[] row : rows) {
	        DailyReportDTO dailyReportDTO = new DailyReportDTO();
	        dailyReportDTO.setGrossQuand(((BigDecimal) row[0]).doubleValue());
	        dailyReportDTO.setDedQuand(((BigDecimal) row[1]).doubleValue());
	        dailyReportDTO.setNetQuand(((BigDecimal) row[2]).doubleValue());
	        dailyReportDTO.setGarsatRd((int) row[3]);
	        dailyReportDTO.setFiberVald((int) row[4]);
	        dailyReportDTO.setBasisPriced(row[5] != null ? ((BigDecimal) row[5]).doubleValue() : 0.0);
	        dailyReportDTO.setGr1d(((BigDecimal) row[6]).doubleValue());
	        dailyReportDTO.setGr2d(((BigDecimal) row[7]).doubleValue());
	        dailyReportDTO.setGr3d(((BigDecimal) row[8]).doubleValue());
	        dailyReportDTO.setGr4d(((BigDecimal) row[9]).doubleValue());
	        dailyReportDTO.setGr5d(((BigDecimal) row[10]).doubleValue());
	        dailyReportDTO.setGr6d(((BigDecimal) row[11]).doubleValue());
	        dailyReportDTO.setGr7d(((BigDecimal) row[12]).doubleValue());
	        dailyReportDTO.setGr8d(((BigDecimal) row[13]).doubleValue());
	        dailyReportDTO.setPlacepurd((String) row[14]);
	        ll.add(dailyReportDTO);
	        System.err.println("ll===="+ll);
	    }
	    
	    
	    return ll;
	}
	@Override
	public List<PurchaseReportDTO> PurchaseReportList( String DPC, String Basis,String Jute_Variety, String Crop_Year, String From_date,String To_date) {
		List<Integer> result = new ArrayList<>();
		String querystr = "";
		
		if (Basis.equals("MSP")) {
			querystr= "SELECT\r\n" + 
					"    r1.datepurchase,\r\n" + 
					"    SUM(ROUND(CAST(r1.gquantity AS DECIMAL(18, 2)), 2)) AS total_gquantity, \r\n" + 
					"    SUM(ROUND(CAST(r1.dquantity AS DECIMAL(18, 2)), 2)) AS total_dquantity,\r\n" +
					"    SUM(ROUND(CAST(r1.netquantity AS DECIMAL(18, 2)), 2)) AS total_netquantity,\r\n" + 
	        	    "    CAST((SUM(CAST(r1.fibervalue AS DECIMAL(18, 2))) /  NULLIF(SUM(CAST(r1.netquantity AS DECIMAL(18, 2))), 0)) AS INT) AS total_grasatrate,\r\n"+
					"    SUM(CAST(r1.fibervalue AS INT)) AS total_fibervalue,\r\n" + 
					"    ROUND(CAST(mspGrade.grade3 AS DECIMAL(18, 2)), 2) AS total_basisPrice,\r\n" + 
					"    SUM(ROUND((CAST(r1.grade1 AS DECIMAL(18, 2)) / 100) * CAST(r1.netquantity AS DECIMAL(18, 2)), 2)) AS grade1_percentage_of_netquantity,\r\n" + 
					"    SUM(ROUND((CAST(r1.grade2 AS DECIMAL(18, 2)) / 100) * CAST(r1.netquantity AS DECIMAL(18, 2)), 2)) AS grade2_percentage_of_netquantity, \r\n" + 
					"    SUM(ROUND((CAST(r1.grade3 AS DECIMAL(18, 2)) / 100) * CAST(r1.netquantity AS DECIMAL(18, 2)), 2)) AS grade3_percentage_of_netquantity, \r\n" + 
					"    SUM(ROUND((CAST(r1.grade4 AS DECIMAL(18, 2)) / 100) * CAST(r1.netquantity AS DECIMAL(18, 2)), 2)) AS grade4_percentage_of_netquantity, \r\n" + 
					"    SUM(ROUND((CAST(r1.grade5 AS DECIMAL(18, 2)) / 100) * CAST(r1.netquantity AS DECIMAL(18, 2)), 2)) AS grade5_percentage_of_netquantity, \r\n" + 
					"    SUM(ROUND((CAST(r1.grade6 AS DECIMAL(18, 2)) / 100) * CAST(r1.netquantity AS DECIMAL(18, 2)), 2)) AS grade6_percentage_of_netquantity, \r\n" + 
					"    SUM(ROUND((CAST(r1.grade7 AS DECIMAL(18, 2)) / 100) * CAST(r1.netquantity AS DECIMAL(18, 2)), 2)) AS grade7_percentage_of_netquantity, \r\n" + 
					"    SUM(ROUND((CAST(r1.grade8 AS DECIMAL(18, 2)) / 100) * CAST(r1.netquantity AS DECIMAL(18, 2)), 2)) AS grade8_percentage_of_netquantity\r\n" + 
					
					"FROM\r\n" + 
					"    jcidpc r1\r\n" + 
					"JOIN \r\n" + 
					"    jcimspgradesprice mspGrade ON r1.jutevariety = mspGrade.jute_variety AND mspGrade.crop_yr = '" + Crop_Year + "'\r\n" + 
					"WHERE \r\n" + 
					"    r1.placeofpurchase = '" + DPC + "' \r\n" + 
					"    AND r1.jutevariety = '" + Jute_Variety + "' \r\n" + 
					"    AND r1.cropyr = '" + Crop_Year + "' \r\n" + 
					"    AND r1.basis = '" + Basis + "' \r\n" + 
					"    AND TRY_CONVERT(DATE, r1.datepurchase, 105) BETWEEN '" + From_date + "' AND '" + To_date + "'" +
					"GROUP BY \r\n" + 
					"    r1.datepurchase, \r\n" + 
					"    mspGrade.grade3";



		} else {
			querystr ="Select r1.datepurchase,r1.gquantity, r1.dquantity, r1.netquantity, r1.grasatrate, r1.fibervalue,r1.grade3 as basisPrice, r1.grade1,r1.grade2, r1.grade3, r1.grade4,r1.grade5, r1.grade6 FROM jcidpc r1  WHERE r1.placeofpurchase = '"+DPC+"' and r1.jutevariety='"+Jute_Variety+"' and r1.cropyr='"+Crop_Year+"' and r1.basis = '"+Basis+"' and TRY_CONVERT(DATE, r1.datepurchase, 103) BETWEEN '"+From_date+"' AND '"+To_date+"'";

		}
							
	
	Session session = sessionFactory.getCurrentSession();
					Transaction tx = session.beginTransaction();
					SQLQuery query = session.createSQLQuery(querystr);
					List<Object[]> rows = query.list();
					System.out.println("mydata" +rows.toString());
					//FarmerRegModel farmerReg = new FarmerRegModel();//jcidpc lena h
					List<PurchaseReportDTO> ll = new ArrayList<>();
					for(Object[] row: rows) {
					
						PurchaseReportDTO PurchaseReportDTO = new PurchaseReportDTO();
						PurchaseReportDTO.setDatepur((String) row[0]);
						PurchaseReportDTO.setGrossQuan(((Number) row[1]).doubleValue());
						PurchaseReportDTO.setDedQuan(((Number) row[2]).doubleValue());
						PurchaseReportDTO.setNetQuan(((Number) row[3]).doubleValue());
						PurchaseReportDTO.setGarsatR((int) row[4]);
						PurchaseReportDTO.setFiberVal((int) row[5]);
					     PurchaseReportDTO.setBasisPrice(((Number) row[6]).doubleValue());// abhi add kiya h 
						PurchaseReportDTO.setGr1(((Number) row[7]).doubleValue());
						PurchaseReportDTO.setGr2(((Number) row[8]).doubleValue());
						PurchaseReportDTO.setGr3(((Number) row[9]).doubleValue());
						PurchaseReportDTO.setGr4(((Number) row[10]).doubleValue());
						PurchaseReportDTO.setGr5(((Number) row[11]).doubleValue());
						PurchaseReportDTO.setGr6(((Number) row[12]).doubleValue());
						PurchaseReportDTO.setGr7(((Number) row[13]).doubleValue());
						PurchaseReportDTO.setGr8(((Number) row[14]).doubleValue());
						

						ll.add(PurchaseReportDTO);
					}
					 return ll;
	}

	      
	}


