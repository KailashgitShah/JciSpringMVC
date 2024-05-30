package com.jci.dao.impl_phase2;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.persistence.criteria.From;
import javax.servlet.http.HttpServletRequest;

import org.apache.xmlbeans.impl.xb.xsdschema.TotalDigitsDocument.TotalDigits;
import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.sql.Insert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.servlet.ModelAndView;

import com.jci.dao_phase2.MillReceiptDao;
//import com.jci.model.ConfirmationClaimSettlementModel;
import com.jci.model.EntryPaymentDetailsModel;
import com.jci.model.MillRecieptModel;
@Repository
@Transactional
public class MillReceiptDaoImpl implements  MillReceiptDao{
	
	@Autowired
	private HttpServletRequest request;
	@Autowired
	SessionFactory sessionFactory;
	protected Session currentSession(){
		return sessionFactory.getCurrentSession();
	}
	
	@Override
	public void create(MillRecieptModel MillRecieptModel) {
		
		currentSession().saveOrUpdate(MillRecieptModel);
	}
	@Override
    public List<MillRecieptModel> getAllPaymentInstruments() {
        Criteria criteria = currentSession().createCriteria(MillRecieptModel.class);
        return criteria.list();
    }
	@Override
	public void update(MillRecieptModel MillRecieptModel) {
		currentSession().update(MillRecieptModel);
	}

	@Override
	public MillRecieptModel edit(int id) {
		return find(id);
	}

	public MillRecieptModel find(int id) {
		// TODO Auto-generated method stub
		return (MillRecieptModel) currentSession().get(MillRecieptModel.class, id);
	}

	
	 
	 @Override
		public void delete(int id) {
		 MillRecieptModel millRecieptModel = new MillRecieptModel();
			String hql = "Delete from jcipayment_arrangement where dopiid = '" + id + "' ";
			this.sessionFactory.getCurrentSession().createSQLQuery(hql).executeUpdate();
		}
	 
		
		  
		  
		
		  
		  @Override 
		  public MillRecieptModel Creditqty(String st) {
		  
		  List<Object[]> list = new ArrayList();
		  MillRecieptModel resultList1 =  new MillRecieptModel();
		  try 
		  { 
			  String sql ="SELECT Actual_qty,Short_qty  FROM jcicredit_note  WHERE Crn_id = 3"; 
			 
			  Session session = sessionFactory.getCurrentSession();
			  Transaction tx = session.beginTransaction();
			  SQLQuery query = session.createSQLQuery(sql);
			  list = query.list();
		     
		     
		     for(  Object[] element:list) {
		    	 resultList1.setActual_qty((Double)element[0]);
			      resultList1.setShort_qty((Double) element[1]);
			  }
		  }
		  catch (Exception e)
		  {
			  System.out.println(e.getLocalizedMessage());
		  } 
		    return  resultList1;
		  
		  }
		 @Override
			public List<Object> fetchHODINO(String millname) {
			
			  	String sql=  "SELECT  distinct a.DI_no,b.Mill_code,a.Contract_No from jciDI_ho as a Left join jcicontract as b on b.Contract_no = a.Contract_No "
			  			+ "where b.Mill_name= '" + millname + "' ";
			  	 List<Object>resultList1= (List<Object>)this.sessionFactory.getCurrentSession().createSQLQuery(sql).list();
			    return resultList1;

//			 
				
			}
	 @Override
	    public MillRecieptModel getById(int id) {
	        return (MillRecieptModel) sessionFactory.getCurrentSession().get(MillRecieptModel.class, id);
	    }

	

	@Override
	public void UpdateContractstatus(String s) {
		
		   
		 String hql = "UPDATE jcicontract set Contract_status = ‘Mill Raised Claim’  where Contract_no = '" + s + "' ";
		 this.sessionFactory.getCurrentSession().createSQLQuery(hql).executeUpdate();
		
	}

	@Override
	public List<Object[]> fetchdata(String st) {
	      String sql ="  SELECT distinct a.Challan_no, a.Date_of_shipment, a.Vehicle_no, CONVERT(varchar, a.DI_Date, 103) AS DI_Date,a.Contract_No,a.Mill_code "
	      		+ "		 			FROM   jcicredit_note AS s LEFT JOIN jcidispatch_details AS a ON s.ChallanNo = a.Challan_no"
		 		+ " WHERE a.DI_No =  '" +st+"'"; 
			 		
			
			 List<Object[]>resultList1= (List<Object[]>)this.sessionFactory.getCurrentSession().createSQLQuery(sql).list();
			 return resultList1;
	}

	@Override
	public List<Object> fetchMill_NameR() {
		
		//String sql ="  SELECT  distinct a.Mill_name,b.Contract_No FROM jcicontract AS a LEFT JOIN jciDI_ho AS b ON a.Contract_no = b.Contract_No where b.Contract_No is NOT NULL";
//		String sql ="  SELECT  distinct a.Mill_name FROM jcicontract AS a LEFT JOIN jciDI_ho AS b ON a.Contract_no = b.Contract_No where b.Contract_No is NOT NULL";
//		
		String sql =" SELECT  distinct c.Recipient_name FROM  jcibos_generation AS c  left JOIN  jciDI_ho as b on b.Contract_No=c.Contract_no ";
		
		 List<Object>resultList1= (List<Object>)this.sessionFactory.getCurrentSession().createSQLQuery(sql).list();
		 return resultList1;
	}

	@Override
	public boolean findmillreceiptNOlist(String st) {
	    String sql = "SELECT DISTINCT MR_no FROM jcimill_receipt WHERE HO_di = '" + st + "'";
	    List<Object> resultList = (List<Object>) this.sessionFactory.getCurrentSession().createSQLQuery(sql).list();
	    
	    // Check if resultList is not empty
	    boolean dataFound = !resultList.isEmpty();
	    
	    return dataFound;
	}

	@Override
	public List<Object[]> childdata(String st) {
		 String sql =" SELECT distinct d.Challan_No,d.Bale_mark,  d.Jute_variety,d.Jute_grade,  d.Crop_year,d.Nominal_qty,d.No_of_bales,s.Actual_qty FROM "
		 		+ "		 	 jcidispatch_details_child AS d  Inner join jcicredit_note as s on s.ChallanNo = d.Challan_no   WHERE d.Challan_no = '" +st+"' and  Crn_status='0'  and d.Jute_grade=s.Jute_grade ";
		 		
				
				 List<Object[]>resultList1= (List<Object[]>)this.sessionFactory.getCurrentSession().createSQLQuery(sql).list();
				 return resultList1;
		
	}

	@Override
	public List<Object[]> challanbaseddetails(String st) {
		 String sql = "SELECT distinct  CONVERT(varchar, a.Date_of_shipment, 103) AS Date_of_shipment, a.Vehicle_no, CONVERT(varchar, a.DI_Date, 103) AS DI_Date,s.Actual_qty, s.Short_qty,a.Contract_No,a.Mill_code "
			 		+ "		      	FROM   jcicredit_note AS s LEFT JOIN jcidispatch_details AS a ON s.ChallanNo = a.Challan_no"
			 		+ "			 	 WHERE a.Challan_no =  '" +st+"'"; 

				 List<Object[]>resultList1= (List<Object[]>)this.sessionFactory.getCurrentSession().createSQLQuery(sql).list();
				 return resultList1;
	}

	@Override
	public List<Object[]> gradeprice( String Challan, String contract) {
	
	
	         
//		 String sql= "a.grade1, a.grade2, a.grade3, a.grade4, a.grade5, a.grade6\n"
//	                   + "FROM jcientry_derivative_price as a \n"
//	                   + "INNER JOIN jcicontract ON a.delivery_type = jcicontract.Delivery_type\n"
//	                   + "INNER JOIN jcipurchasecenter ON jcipurchasecenter.district = a.district\n"
//	                   + "INNER JOIN jcidispatch_details ON jcidispatch_details.Challan_no = '" + Challan + "'\n"
//	                   + "WHERE jcipurchasecenter.CENTER_CODE = jcidispatch_details.Place_of_Shipment\n"
//	                   + "AND jcicontract.Contract_no = '" + contract + "'\n"
//	                   + "AND a.crop_year = '" + cropyear + "'\n"
//	                   + "AND a.jute_variety = '" + var + "'";
		 
		 String sql= "SELECT distinct  a.grade1, a.grade2, a.grade3, a.grade4, a.grade5, a.grade6\n"
		 		+ "FROM jcientry_derivative_price as a\n"
		 		+ "INNER JOIN jcicontract ON a.delivery_type = jcicontract.Delivery_type\n"
		 		+ "INNER JOIN jcipurchasecenter ON jcipurchasecenter.district = a.district\n"
		 		+ "INNER JOIN jcidispatch_details ON jcidispatch_details.Challan_no ='" + Challan + "'\n"
		 		+ "INNER join(select  b.Crop_year,b.jute_variety from  jcidispatch_details as a LEFT JOIN jcidispatch_details_child  as b on a.Challan_no=b.Challan_no\n"
		 		+ ")  as s   ON s.Crop_year = a.Crop_year \n"
		 		+ "    AND s.jute_variety = a.jute_variety\n"
		 		+ "WHERE jcipurchasecenter.CENTER_CODE = jcidispatch_details.Place_of_Shipment\n"
		 		+ "AND jcicontract.Contract_no = '" + contract + "'\n";


		List<Object[]>resultList1= (List<Object[]>)this.sessionFactory.getCurrentSession().createSQLQuery(sql).list();
		 return resultList1;
}

	

	  
 }
