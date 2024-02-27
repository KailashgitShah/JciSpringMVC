package com.jci.dao.impl_phase2;

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
		  public MillRecieptModel fetchdata(String st) {
		  
		  List<Object[]> list = new ArrayList();
		  MillRecieptModel resultList =  new MillRecieptModel();
		  try 
		  { 
			  //String sql ="SELECT a.Challan_no, a.Date_of_shipment, a.Vehicle_no, a.Bale_mark, a.Jute_variety, a.Crop_year, b.DI_Date FROM jcidispatch_details a left join jciDI_ho b on b.Contract_No = a.Contract_no WHERE a.Contract_No = '"  +st+"'"; 
//			  String sql =" SELECT a.Challan_no, a.Date_of_shipment, a.Vehicle_no, a.Bale_mark, a.Jute_variety, a.Crop_year, a.DI_Date,a.Nominal_qty,s.Actual_qty, s.Short_qty from ( SELECT a.Credit_note_amount,a.Contract_no, a.Mr_no, b.Actual_qty, b.Short_qty FROM jcicredit_note_settled AS a LEFT JOIN jcicredit_note AS b ON a.Credit_note_no = b.Credit_note_no)  AS s"
//			  		+ " LEFT JOIN jcidispatch_details AS a ON s.Contract_no = a.Contract_No "
//			  		+ "  WHERE a.Contract_No =  '" +st+"'"; 
			  
			  String sql ="     SELECT a.Challan_no, a.Date_of_shipment, a.Vehicle_no, a.Bale_mark, a.Jute_variety, a.Crop_year, a.DI_Date,a.Nominal_qty,a.Mill_code,s.Actual_qty, s.Short_qty  FROM jcicredit_note as s\r\n"
			  		+ "			  	     LEFT JOIN jcidispatch_details AS a ON s.Contract_no = a.Contract_No \r\n"
			  		+ "			  		  WHERE a.Contract_No =  '" +st+"'"; 
			  
			  Session session = sessionFactory.getCurrentSession();
			  Transaction tx = session.beginTransaction();
			  SQLQuery query = session.createSQLQuery(sql);
			  
		     list = query.list();
		  
		  for (Object[] row : list) {
		  
		   resultList.setChallan_no((String)row[0]);
		   resultList.setDate_shipment((Date)row[1]);
		   resultList.setVehicle_no((String)row[2]);
		   resultList.setBale_mark((String)row[3]);
		  // resultList.setJute_variety((String)row[4]);
		   resultList.setCrop_year((String)row[5]);
		   resultList.setHo_date((Date)row[6]);
		   resultList.setChallan_qty((Double)row[7]);
		   resultList.setMill_id((String)row[8]);
		
		   resultList.setActual_qty((Double)row[9]);
		   resultList.setShort_qty((Double)row[10]);
		
		   }
		  
		  
		  }
		  catch (Exception e)
		  {
			  System.out.println(e.getLocalizedMessage());
		  } 
		  //this.sessionFactory.getCurrentSession().createSQLQuery(sql).setParameter( "st", st).list();
		  return  resultList;
		  
		  }  
		  
		  
		
		  
		  @Override 
		  public MillRecieptModel Creditqty(String st) {
		  
		  List<Object[]> list = new ArrayList();
		  MillRecieptModel resultList1 =  new MillRecieptModel();
		  try 
		  { 
			  //String sql ="SELECT a.Challan_no, a.Date_of_shipment, a.Vehicle_no, a.Bale_mark, a.Jute_variety, a.Crop_year, b.DI_Date FROM jcidispatch_details a left join jciDI_ho b on b.Contract_No = a.Contract_no WHERE a.Contract_No = '"  +st+"'"; 
			  String sql ="SELECT Actual_qty,Short_qty  FROM jcicredit_note  WHERE Crn_id = 3"; 
			 
			  Session session = sessionFactory.getCurrentSession();
			  Transaction tx = session.beginTransaction();
			  SQLQuery query = session.createSQLQuery(sql);
			  //System.out.println("KKKKKKKKKKKK"+query);
		     list = query.list();
		     
		     
		     for(  Object[] element:list) {
		    	
			      
			      

			      // Convert the float values to String and set them in the resultList1 model
			      resultList1.setActual_qty((Double)element[0]);
			      resultList1.setShort_qty((Double) element[1]);
			     
			   
					/*
					 * resultList1.setActual_qty((String)element[0]);
					 * resultList1.setShort_qty((String)element[1]);
					 */
		    
		      
		    }
		  }
		  catch (Exception e)
		  {
			  System.out.println(e.getLocalizedMessage());
		  } 
		  //this.sessionFactory.getCurrentSession().createSQLQuery(sql).setParameter( "st", st).list();
		  return  resultList1;
		  
		  }
		 @Override
			public List<Object> fetchHODINO() {
			
			  	String sql="select DI_no, Contract_no from  jciDI_ho";
						
				//String sql=" select dd.Challan_no,dd.Date_of_shipment,dd.Vehicle_no,dd.Bale_mark,dd.Jute_variety,dd.Crop_year,mr.MR_No from  jcidispatch_details as dd join jcimill_receipt as mr on dd.Dientry_id=mr.Mr_id ";

				//String sql="select Challan_no,Date_of_shipment,Vehicle_no,Bale_mark,Jute_variety,Crop_year from  jcidispatch_details";
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
		// TODO Auto-generated method stub
		 //String hql = "UPDATE jcicontract set Contract_status = ‘Mill Raised Claim’  where Payment_id = '" + id + "' ";
		    
		 String hql = "UPDATE jcicontract set Contract_status = ‘Mill Raised Claim’  where Payment_id = '" + s + "' ";
		 this.sessionFactory.getCurrentSession().createSQLQuery(hql).executeUpdate();
		
	}

	    
 }

		

