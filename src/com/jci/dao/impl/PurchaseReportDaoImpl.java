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
import com.jci.model.FarmerRegModel;
import com.jci.model.LedgerReportDTO;

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
		    querystr="SELECT \r\n" + 
		    		"    p.cropyr,\r\n" + 
		    		"    p.farmerregno,\r\n" + 
		    		"    p.basis,\r\n" + 
		    		"    p.datepurchase AS Date,\r\n" + 
		    		"    p.rateslipno AS [Rate Slip Number],\r\n" + 
		    		"    p.tallyslipno AS [Tally Number],\r\n" + 
		    		"    SUM(p.grossquantity) / 100 AS [Gross Quantity (Qtls)],\r\n" + 
		    		"    SUM(p.deductionquantity) / 100 AS [Deduction (Qtls)],\r\n" + 
		    		"    SUM(p.netquantity) / 100 AS [Net Quantity (Qtls)],\r\n" + 
		    		"    SUM(p.grasatrate) / 100 AS [Value (Qtls)],\r\n" + 
		    		"    SUM(SUM(p.grossquantity - p.deductionquantity)) OVER (PARTITION BY p.farmerregno ORDER BY p.datepurchase ROWS UNBOUNDED PRECEDING) / 100 AS [Communitative (Qtls)],\r\n" + 
		    		"    rmt.F_NAME,\r\n" + 
		    		"    rmt.F_AC_NO,\r\n" + 
		    		"    rmt.F_ADDRESS,\r\n" + 
		    		"    rmt.F_MOBILE,\r\n" + 
		    		"    rmt.F_ID_PROF_NO,\r\n" + 
		    		"    rmt.F_BANK_NAME,\r\n" + 
		    		"    rmt.F_BANK_IFSC,\r\n" + 
		    		"    rmt.F_REG_NO,\r\n" + 
		    		"    tsp.purchase_date AS PurchaseDate,\r\n" + 
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
		    		"    tsp.purchase_date,\r\n" + 
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
		    	ledgerReportDTO.setFarmerRegNo((String) row[18]);
		    	ledgerReportDTO.setPayDate((String) row[19]);
		    	ledgerReportDTO.setDpc((String) row[20]);
		    	
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
	      
	}


