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
			public List<Object> fetchHODINO() {
			
			  	String sql=  "SELECT  distinct b.DI_no,a.Contract_No FROM jcicontract AS a LEFT JOIN jciDI_ho AS b ON a.Contract_no = b.Contract_no where b.Contract_no is not null ";
				
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
		 String sql ="  SELECT distinct a.Challan_no, a.Date_of_shipment, a.Vehicle_no, c.Bale_mark, c.Jute_variety, c.Crop_year, a.DI_Date,s.Actual_qty, s.Short_qty ,c.Nominal_qty \r\n"
		 		+ "FROM   jcicredit_note AS s LEFT JOIN jcidispatch_details AS a ON s.Contract_no = a.Contract_No\r\n"
		 		+ "LEFT JOIN(SELECT d.Bale_mark,  d.Jute_variety,d.Crop_year, e.Challan_No,  e.Contract_No,d.Nominal_qty FROM jcidispatch_details AS e \r\n"
		 		+ "LEFT JOIN jcidispatch_details_child AS d ON d.Challan_no = e.Challan_no) AS c\r\n"
		 		+ "ON  c.Contract_No = a.Contract_No WHERE a.Contract_No =  '" +st+"'"; 
		 				  		  
			 
			
			 List<Object[]>resultList1= (List<Object[]>)this.sessionFactory.getCurrentSession().createSQLQuery(sql).list();
			 return resultList1;
	}

	@Override
	public List<Object[]> fetchMill_NameR() {
		
		String sql ="SELECT a.Mill_name, b.Contract_No FROM jcicontract AS a LEFT JOIN jciDI_ho AS b ON a.Contract_no = b.Contract_No where b.Contract_No is NOT NULL";
			
		 List<Object[]>resultList1= (List<Object[]>)this.sessionFactory.getCurrentSession().createSQLQuery(sql).list();
		 return resultList1;
	}

	  //  
 }

		

