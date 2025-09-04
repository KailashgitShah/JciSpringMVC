package com.jci.dao.impl_phase2;

import static org.hamcrest.CoreMatchers.nullValue;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.itextpdf.text.pdf.PdfStructTreeController.returnType;
import com.jci.dao_phase2.WeightmentDao;
import com.jci.model.jciWeighmentEntry;
@Transactional
@Repository
public class WeightmentDaoImpl implements WeightmentDao{
	@Autowired
	private HttpServletRequest request;
	 @Autowired
     HttpSession session1;
	@Autowired
	SessionFactory sessionFactory;

	protected Session currentSession() {
		return sessionFactory.getCurrentSession();
	}
	@Override
	public List<Object[]> WeightmentSlipList(String ro_id) {
		// TODO Auto-generated method stub
		 String regionString=(String)session1.getAttribute("regionId");
         Integer roleId = (Integer)session1.getAttribute("roleId");
         String dpcId = (String)session1.getAttribute("dpcId");
         String listString ="";
          if(roleId == 52|| roleId==53|| roleId == 54) {//DPC roles
        	  listString ="  SELECT * \r\n"
        	  		+ "      				FROM jciweighment_entry \r\n"
        	  		+ "      				JOIN jcibos_generation ON jciweighment_entry.Bos_no = jcibos_generation.Bill_of_supply_no\r\n"
        	  		+ "      				JOIN jcidispatch_details ON jcibos_generation.Challan_No = jcidispatch_details.Challan_no \r\n"
        	  		+ "                    join jcipurchasecenter on jcipurchasecenter.CENTER_CODE= jcibos_generation.DPCID\r\n"
        	  		+ "      				WHERE jcibos_generation.DPCID='"+dpcId+"' \r\n"
        	  		+ "      				ORDER BY jciweighment_entry.Weighment_id DESC;";
		 }
          else {
        	  
		   listString ="  SELECT * \r\n"
				+ "FROM jciweighment_entry \r\n"
				+ "JOIN jcibos_generation ON jciweighment_entry.Bos_no = jcibos_generation.Bill_of_supply_no\r\n"
				+ "JOIN jcidispatch_details ON jcibos_generation.Challan_No = jcidispatch_details.Challan_no \r\n"
				//+ "WHERE jciweighment_entry.Ro_id = '"+ro_id+"' \r\n"
				+ "ORDER BY jciweighment_entry.Weighment_id DESC;";
          }
		List<Object[]> list = currentSession().createSQLQuery(listString).list();
		
//		System.err.println(list.toString());
		return list;	
		
	}

	@Override
	public Date getcreationdate(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getDpc_wt_doc(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getRo_id(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getMill_bos_copy(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getMill_wt_doc(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public jciWeighmentEntry ListOFWeightmentSlipById(int weighment_id) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<Object[]> SlipDetails(String id) {
		// TODO Auto-generated method stub
		String listString ="Select * from jciweighment_entry where Bos_no ='"+id+"' ";
		List<Object[]> list = currentSession().createSQLQuery(listString).list();
		
		System.err.println(list.toString());
		return list;
	}
	@Override
	public void editDetails(Double gross, Double actual, Double net, Date currDate, String bosNo) {
		String query = " UPDATE jciweighment_entry SET " +
                " Verification_date = CURRENT_TIMESTAMP, " +
                " Verification_Status = '" + 1 + "', " +
                " truck_gross_wt = '" + gross + "', " +
                " truck_net_wt = '" + net + "', " +
                " truck_tare_wt = '" + actual + "' " +
                " WHERE Bos_no = '" + bosNo + "'; " +
                " UPDATE [XMWJCI].[dbo].[jcicontract] " +
                " SET Contract_status = 'Verification of Weighment Slip done' " +
                " WHERE Contract_no IN (SELECT jcibos_generation.Contract_no " +
                                      " FROM jcibos_generation " +
                                      " INNER JOIN jciweighment_entry ON jciweighment_entry.Bos_no = jcibos_generation.Bill_of_supply_no " +
                                      " WHERE jciweighment_entry.Bos_no = '" + bosNo + "');";

		int value= (int) currentSession().createSQLQuery(query).executeUpdate();
		
		String q1 ="UPDATE jcidispatch_details\r\n"
				+ "SET jcidispatch_details.Di_status = 2\r\n"
				+ "WHERE EXISTS (\r\n"
				+ "    SELECT 1\r\n"
				+ "    FROM jcibos_generation\r\n"
				+ "    WHERE jcidispatch_details.Challan_No = jcibos_generation.Challan_No\r\n"
				+ "    AND jcibos_generation.Bill_of_supply_no = '"+bosNo+"'\r\n"
				+ ");";
		int v1= (int) currentSession().createSQLQuery(q1).executeUpdate();
		
		return ;
		
		
	}
	@Override
	public List<Object[]> getAllPendingWeightmentSlip(String ro_id) {
		 String regionString=(String)session1.getAttribute("regionId");
         Integer roleId = (Integer)session1.getAttribute("roleId");
         String dpcId = (String)session1.getAttribute("dpcId");
         String listString ="";
          if(roleId == 52|| roleId==53|| roleId == 54) {//DPC roles
        	  listString ="select (bos.Ro_id+'-'+ro.roname) as ro ,(bos.DPCID+'-'+pur.centername) as center,\r\n"
        	  		+ " bos.Bill_of_supply_no , bos.BOS_date from \r\n"
        	  		+ "jcibos_generation bos \r\n"
        	  		+ "inner join jcirodetails ro on ro.roid = bos.Ro_id\r\n"
        	  		+ "inner join jcipurchasecenter pur on bos.DPCID = pur.CENTER_CODE \r\n"
        	  		+ "where bos.DPCID = '"+dpcId+"' and  bos.Bill_of_supply_no not in (select Bos_no from jciweighment_entry) and bos.Bos_file_path <> null \r\n"
        	  		+ "order by ro.roname asc,pur.centername asc , convert(date , bos.BOS_date,105) desc\r\n"
        	  		+ "\r\n"
        	  		+ "";
		 }else if(roleId == 6 || roleId==7 || roleId == 8 || roleId == 49) {
			  listString ="select (bos.Ro_id+'-'+ro.roname) as ro ,(bos.DPCID+'-'+pur.centername) as center,\r\n"
	        	  		+ " bos.Bill_of_supply_no , bos.BOS_date from \r\n"
	        	  		+ "jcibos_generation bos \r\n"
	        	  		+ "inner join jcirodetails ro on ro.roid = bos.Ro_id\r\n"
	        	  		+ "inner join jcipurchasecenter pur on bos.DPCID = pur.CENTER_CODE \r\n"
	        	  		+ "where  bos.Ro_id = '"+regionString+"' and  bos.Bill_of_supply_no not in (select Bos_no from jciweighment_entry) and bos.Bos_file_path <> null \r\n"
	        	  		+ "order by ro.roname asc,pur.centername asc , convert(date , bos.BOS_date,105) desc\r\n"
	        	  		+ "\r\n"
	        	  		+ "";
		 }
          else {
        	  listString ="select (bos.Ro_id+'-'+ro.roname) as ro ,(bos.DPCID+'-'+pur.centername) as center,\r\n"
          	  		+ " bos.Bill_of_supply_no , bos.BOS_date from \r\n"
          	  		+ "jcibos_generation bos \r\n"
          	  		+ "inner join jcirodetails ro on ro.roid = bos.Ro_id\r\n"
          	  		+ "inner join jcipurchasecenter pur on bos.DPCID = pur.CENTER_CODE \r\n"
          	  		+ "where bos.Bill_of_supply_no not in (select Bos_no from jciweighment_entry) and bos.Bos_file_path <> null \r\n"
          	  		+ "order by ro.roname asc,pur.centername asc , convert(date , bos.BOS_date,105) desc\r\n"
          	  		+ "\r\n"
          	  		+ "";
          }
		List<Object[]> list = currentSession().createSQLQuery(listString).list();
		return list;
	}

}
