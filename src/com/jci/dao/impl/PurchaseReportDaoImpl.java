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
		String querystr = "SELECT \r\n"
				+ "    cropyr,\r\n"
				+ "    farmerregno,\r\n"
				+ "    basis,\r\n"
				+ "    Date,\r\n"
				+ "    [Rate Slip Number],\r\n"
				+ "    [Tally Number],\r\n"
				+ "    [Gross Quantity (Qtls)],\r\n"
				+ "    [Deduction (Qtls)],\r\n"
				+ "    [Net Quantity (Qtls)],\r\n"
				+ "    [grasatrate (Qtls)],\r\n"
				+ "    [Communitative (Qtls)],\r\n"
				+ "    F_NAME,\r\n"
				+ "    F_AC_NO,\r\n"
				+ "    F_ADDRESS,\r\n"
				+ "    F_MOBILE,\r\n"
				+ "    F_ID_PROF_NO,\r\n"
				+ "    F_BANK_NAME,\r\n"
				+ "    F_BANK_IFSC,\r\n"
				+ "    [Payment Date],\r\n"
				+ "    CentreName\r\n"
				+ "FROM (\r\n"
				+ "    SELECT \r\n"
				+ "        p.cropyr,\r\n"
				+ "        p.farmerregno,\r\n"
				+ "        p.basis,\r\n"
				+ "        TRY_CONVERT(DATE, p.datepurchase, 105) AS Date,\r\n"
				+ "        p.rateslipno AS [Rate Slip Number],\r\n"
				+ "        p.tallyslipno AS [Tally Number],\r\n"
				+ "        p.grossquantity / 100 AS [Gross Quantity (Qtls)],\r\n"
				+ "        p.deductionquantity / 100 AS [Deduction (Qtls)],\r\n"
				+ "        p.netquantity / 100 AS [Net Quantity (Qtls)],\r\n"
				+ "        p.grasatrate / 100 AS [grasatrate (Qtls)],\r\n"
				+ "        (p.grossquantity - p.deductionquantity) / 100 AS [Communitative (Qtls)],\r\n"
				+ "        rmt.F_NAME,\r\n"
				+ "        rmt.F_AC_NO,\r\n"
				+ "        rmt.F_ADDRESS,\r\n"
				+ "        rmt.F_MOBILE,\r\n"
				+ "        rmt.F_ID_PROF_NO,\r\n"
				+ "        rmt.F_BANK_NAME,\r\n"
				+ "        rmt.F_BANK_IFSC,\r\n"
				+ "        tsp.date AS [Payment Date],\r\n"
				+ "        pc.centername AS CentreName,\r\n"
				+ "        ROW_NUMBER() OVER (PARTITION BY p.tallyslipno ORDER BY tsp.date DESC) AS rn\r\n"
				+ "    FROM jciprocurement p\r\n"
				+ "    JOIN jcirmt rmt ON p.farmerregno = rmt.F_REG_NO\r\n"
				+ "    JOIN jcitallyslippayment tsp ON rmt.F_AC_NO = tsp.beneficiaryAC_No\r\n"
				+ "    JOIN jcipurchasecenter pc ON rmt.dpc_id = pc.CENTER_CODE\r\n"
				+ "    WHERE p.cropyr = '" + cropyr + "'\r\n"
				+ "      AND p.basis = '" + basis + "'\r\n"
				+ "      AND p.farmerregno = '" + farmer + "'\r\n"
				+ ") AS ranked\r\n"
				+ "WHERE rn = 1\r\n"
				+ "ORDER BY \r\n"
				+ "    YEAR(Date), \r\n"
				+ "    MONTH(Date), \r\n"
				+ "    DAY(Date), \r\n"
				+ "    farmerregno";


	    Session session = sessionFactory.getCurrentSession();
	    Transaction tx = session.beginTransaction();
	    SQLQuery query = session.createSQLQuery(querystr);
	    List<Object[]> rows = query.list();
	    System.err.println("The query is :" + querystr);

	    List<LedgerReportDTO> ll = new ArrayList<>();
	    for (Object[] row : rows) {
	        LedgerReportDTO dto = new LedgerReportDTO();

	        dto.setCropyear((String) row[0]);
	        dto.setFarmerRegNo((String) row[1]);
	        dto.setBasis((String) row[2]);
	        dto.setDateofPur(row[3] != null ? row[3].toString() : null);
	        dto.setRateSlip((Integer) row[4]);
	        dto.setTallySlip((String) row[5]);
	        dto.setGrossQty(row[6] != null ? ((BigDecimal) row[6]).doubleValue() : 0.0);
	        dto.setDedQty(row[7] != null ? ((BigDecimal) row[7]).doubleValue() : 0.0);
	        dto.setNetQty(row[8] != null ? ((BigDecimal) row[8]).doubleValue() : 0.0);
	        dto.setGrasatrate(row[9] != null ? ((BigDecimal) row[9]).doubleValue() : 0.0);
	        dto.setCumQty(row[10] != null ? ((BigDecimal) row[10]).doubleValue() : 0.0);
	        dto.setFarmerName((String) row[11]);
	        dto.setAcNo((String) row[12]);
	        dto.setAddress((String) row[13]);
	        dto.setMobNo((String) row[14]);
	        dto.setAadharNo((String) row[15]);
	        dto.setBankName((String) row[16]);
	        dto.setIfscCode((String) row[17]);
	        dto.setPayDate(row[18] != null ? row[18].toString() : "");
	        dto.setDpc((String) row[19]);

	        ll.add(dto);
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
	public List<PurchaseReportDTO> PurchaseReportList(String DPC, String Basis, String Jute_Variety, String Crop_Year, String From_date, String To_date) {
	    List<Integer> result = new ArrayList<>();
	    String querystr = "";

	    // When the Basis is "MSP", apply the respective query
	    if (Basis.equals("MSP")) {
	        querystr = "SELECT " +
	                "    r1.datepurchase, " +
	                "    SUM(ROUND(CAST(r1.gquantity AS DECIMAL(18, 2)), 2)) AS total_gquantity, " +
	                "    SUM(ROUND(CAST(r1.dquantity AS DECIMAL(18, 2)), 2)) AS total_dquantity, " +
	                "    SUM(ROUND(CAST(r1.netquantity AS DECIMAL(18, 2)), 2)) AS total_netquantity, " +
	                "    CAST((SUM(CAST(r1.fibervalue AS DECIMAL(18, 2))) / NULLIF(SUM(CAST(r1.netquantity AS DECIMAL(18, 2))), 0)) AS INT) AS total_grasatrate, " +
	                "    SUM(CAST(r1.fibervalue AS INT)) AS total_fibervalue, " +
	                "    ROUND(CAST(mspGrade.grade3 AS DECIMAL(18, 2)), 2) AS total_basisPrice, " +
	                "    SUM(ROUND((CAST(r1.grade1 AS DECIMAL(18, 2)) / 100) * CAST(r1.netquantity AS DECIMAL(18, 2)), 2)) AS grade1_percentage_of_netquantity, " +
	                "    SUM(ROUND((CAST(r1.grade2 AS DECIMAL(18, 2)) / 100) * CAST(r1.netquantity AS DECIMAL(18, 2)), 2)) AS grade2_percentage_of_netquantity, " +
	                "    SUM(ROUND((CAST(r1.grade3 AS DECIMAL(18, 2)) / 100) * CAST(r1.netquantity AS DECIMAL(18, 2)), 2)) AS grade3_percentage_of_netquantity, " +
	                "    SUM(ROUND((CAST(r1.grade4 AS DECIMAL(18, 2)) / 100) * CAST(r1.netquantity AS DECIMAL(18, 2)), 2)) AS grade4_percentage_of_netquantity, " +
	                "    SUM(ROUND((CAST(r1.grade5 AS DECIMAL(18, 2)) / 100) * CAST(r1.netquantity AS DECIMAL(18, 2)), 2)) AS grade5_percentage_of_netquantity, " +
	                "    SUM(ROUND((CAST(r1.grade6 AS DECIMAL(18, 2)) / 100) * CAST(r1.netquantity AS DECIMAL(18, 2)), 2)) AS grade6_percentage_of_netquantity, " +
	                "    SUM(ROUND((CAST(r1.grade7 AS DECIMAL(18, 2)) / 100) * CAST(r1.netquantity AS DECIMAL(18, 2)), 2)) AS grade7_percentage_of_netquantity, " +
	                "    SUM(ROUND((CAST(r1.grade8 AS DECIMAL(18, 2)) / 100) * CAST(r1.netquantity AS DECIMAL(18, 2)), 2)) AS grade8_percentage_of_netquantity " +
	                "FROM " +
	                "    jcidpc r1 " +
	                "JOIN " +
	                "    jcimspgradesprice mspGrade ON r1.jutevariety = mspGrade.jute_variety AND mspGrade.crop_yr = '" + Crop_Year + "' " +
	                "WHERE " +
	                "    r1.placeofpurchase = '" + DPC + "' " +
	                "    AND r1.jutevariety = '" + Jute_Variety + "' " +
	                "    AND r1.cropyr = '" + Crop_Year + "' " +
	                "    AND r1.basis = '" + Basis + "' " +
	                "    AND TRY_CONVERT(DATE, r1.datepurchase, 105) BETWEEN '" + From_date + "' AND '" + To_date + "' " +
	                "GROUP BY " +
	                "    r1.datepurchase, " +
	                "    mspGrade.grade3 " +
	                "ORDER BY \r\n"
	                + "    CAST(SUBSTRING(r1.datepurchase, 7, 4) AS INT),  -- Year part (yyyy)\r\n"
	                + "    CAST(SUBSTRING(r1.datepurchase, 4, 2) AS INT),  -- Month part (MM)\r\n"
	                + "    CAST(SUBSTRING(r1.datepurchase, 1, 2) AS INT)";  // Added ORDER BY for ascending date order

	    } else {
	        querystr = "SELECT " +
	                "    r1.datepurchase, r1.gquantity, r1.dquantity, r1.netquantity, r1.grasatrate, r1.fibervalue, " +
	                "    r1.grade3 as basisPrice, r1.grade1, r1.grade2, r1.grade3, r1.grade4, r1.grade5, r1.grade6 " +
	                "FROM jcidpc r1 " +
	                "WHERE r1.placeofpurchase = '" + DPC + "' " +
	                "    AND r1.jutevariety = '" + Jute_Variety + "' " +
	                "    AND r1.cropyr = '" + Crop_Year + "' " +
	                "    AND r1.basis = '" + Basis + "' " +
	                "    AND TRY_CONVERT(DATE, r1.datepurchase, 103) BETWEEN '" + From_date + "' AND '" + To_date + "' " +
	                "ORDER BY r1.datepurchase ASC";  // Added ORDER BY for ascending date order
	    }

	    // Executing the query and mapping the results
	    Session session = sessionFactory.getCurrentSession();
	    Transaction tx = session.beginTransaction();
	    SQLQuery query = session.createSQLQuery(querystr);
	    List<Object[]> rows = query.list();
	    System.err.println("Generated SQL query is : " + querystr);

	    List<PurchaseReportDTO> ll = new ArrayList<>();
	    for (Object[] row : rows) {
	        PurchaseReportDTO dto = new PurchaseReportDTO();
	        dto.setDatepur((String) row[0]);
	        dto.setGrossQuan(((Number) row[1]).doubleValue());
	        dto.setDedQuan(((Number) row[2]).doubleValue());
	        dto.setNetQuan(((Number) row[3]).doubleValue());
	        dto.setGarsatR((int) row[4]);
	        dto.setFiberVal((int) row[5]);
	        dto.setBasisPrice(((Number) row[6]).doubleValue());
	        dto.setGr1(((Number) row[7]).doubleValue());
	        dto.setGr2(((Number) row[8]).doubleValue());
	        dto.setGr3(((Number) row[9]).doubleValue());
	        dto.setGr4(((Number) row[10]).doubleValue());
	        dto.setGr5(((Number) row[11]).doubleValue());
	        dto.setGr6(((Number) row[12]).doubleValue());
	        dto.setGr7(((Number) row[13]).doubleValue());
	        dto.setGr8(((Number) row[14]).doubleValue());

	        ll.add(dto);
	    }

	    return ll;
	}


	}


