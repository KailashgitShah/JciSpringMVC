package com.jci.dao.impl_phase2;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.type.StandardBasicTypes;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.jci.dao_phase2.millAcceptDao;
import com.jci.model.Contractgeneration;
import com.jci.model.EntryofpcsoModel;


import org.hibernate.Query;


@Transactional
@Repository
public class MillAcceptDaoImpl implements millAcceptDao{
	@Autowired
	private HttpServletRequest request;

//	@Autowired
//	SessionFactory sessionFactory;
//	
//	protected Session currentSession(){
//		return sessionFactory.getCurrentSession();
//	}
	
	@Autowired
	SessionFactory sessionFactory;
	

	

	protected Session currentSession() {
		return sessionFactory.getCurrentSession();
	}
	
	
	
		
	@Override
	public List<Contractgeneration> getAll() {
	    List<Contractgeneration> ll = new ArrayList<>();
	    List<Object[]> rows = new ArrayList<>();
	    String querystr = "select Contract_no, Contract_date, Contract_qty, Contract_value, Payment_duedate, Contract_acceptance_flag, contract_id,Delivery_type ,Mill_name, Contract_acceptance_doc,  CropYear , Intial_Payment_date, Contract_value_lc , Jute_value ,Contract_identification_no from jcicontract";
	  //  String querystr = "select Contract_no, Contract_date, Contract_qty, Contract_value, Payment_duedate, Contract_acceptance_flag, contract_id,Delivery_type ,Mill_name, Contract_acceptance_doc, Acceptance_doc_path  from jcicontract";
	    
	    Session session = sessionFactory.getCurrentSession();
	    Transaction tx = session.beginTransaction();
	    SQLQuery query = session.createSQLQuery(querystr);
	    
	    rows = query.list();
	    
	    for (Object[] row : rows) {
	        String Contract_no = (String) row[0];
	        String Contract_date = (String) row[1];
	        String Contract_qty = (String) row[2];
	        Double Contract_value =(Double) row[3]; // Use BigDecimal for Contract_value
	        String Payment_duedate = (String) row[4];
	        int Contract_acceptance_flag = ((Number) row[5]).intValue();
	        Long contract_id = ((BigDecimal) row[6]).longValue(); // Use BigDecimal's longValue()
	       String Delivery_type =(String)row[7];
	       String Mill_name=(String)row[8];
	       String Contract_acceptance_doc=(String)row[9];
	      
	        String CropYear =(String)row[10];
	     
	        String Intial_Payment_date = (String)row[11];
	        Double  Contract_value_lc =(Double)row[12];
	        Double Jute_value = (Double)row[13];
	        String Contract_identification_no =(String)row[14];
	        

	        Contractgeneration cm = new Contractgeneration();
	        cm.setContract_no(Contract_no);
	        cm.setContract_date(Contract_date);
	        cm.setContract_qty(Contract_qty);
	        
	        cm.setContract_value(Contract_value);
	        cm.setPayment_duedate(Payment_duedate);
	        cm.setContract_acceptance_flag(Contract_acceptance_flag);
	        cm.setContract_id(contract_id);
	        cm.setDelivery_type(Delivery_type);
	        cm.setMill_name(Mill_name);
	        cm.setContract_acceptance_doc(Contract_acceptance_doc);
	     
	        cm.setCropYear(CropYear);
	      //  cm.setJute_value(Jute_value);
	        cm.setIntial_Payment_date(Intial_Payment_date);
	        cm.setContractValueLc(Contract_value_lc);  
	        cm.setJute_value(Jute_value);
	        cm.setContract_identification_no(Contract_identification_no);
	        ll.add(cm);
	        System.out.println(ll.toString() + "kkkkkkkkkkkkkkkk");
	    }

	    return ll;
	}


	
	

	@Override
	public void updatemillacceptflag(String contractId ) {
		
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
		Date currentDate = new Date();
		String formattedDate = sdf.format(currentDate);
		
		
		int contractacceptflag =1;	
		String Contract_status = "Mill Accepted";
		try {
		String hql = "update jcicontract set Contract_acceptance_flag = '" + contractacceptflag + "', Contract_acceptance_date = '" + formattedDate + "',Contract_status = '" + Contract_status +"'  where contract_id = " + contractId;

				this.sessionFactory.getCurrentSession().createSQLQuery(hql).executeUpdate();
		      System.out.println("success");
		} catch (Exception e) {
			  System.out.println(e.getLocalizedMessage());
		}
		// TODO Auto-generated method stub
		
	}


	
	 
		
			

}
