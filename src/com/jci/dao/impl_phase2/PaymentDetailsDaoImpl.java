package com.jci.dao.impl_phase2;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

import javax.persistence.Query;
import javax.persistence.criteria.From;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.hibernate.sql.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.jci.dao_phase2.PaymentDetailsDao;
import com.jci.model.EntryPaymentDetailsModel;
@Repository
@Transactional
public class PaymentDetailsDaoImpl implements PaymentDetailsDao {
	@Autowired
	SessionFactory sessionFactory;
	protected Session currentSession(){
		return sessionFactory.getCurrentSession();
	}
	
	@Override
	public void create(EntryPaymentDetailsModel entryPaymentDetailsModel) {
		
		currentSession().saveOrUpdate(entryPaymentDetailsModel);
	}
//	
	//get all details of payment instrument
	@Override
	public List<EntryPaymentDetailsModel> getAllPaymentInstruments() {
		
		
	   // String sql = "SELECT * FROM jcipayment_arrangement WHERE Fc_status = 0 or Fc_status = 1 ";
	   // String sql = "SELECT * FROM jcipayment_arrangement WHERE Fc_status = 0 and Fc_status = 1 ";
	    String sql = " SELECT * FROM jcipayment_arrangement WHERE Fc_status IN(0,1)";
	    List<EntryPaymentDetailsModel> fCList = sessionFactory.getCurrentSession()
	            .createSQLQuery(sql)
	            .addEntity(EntryPaymentDetailsModel.class)
	            .list();
	    return fCList;
	}
	@Override
	public List<EntryPaymentDetailsModel> getAllPaymentInstrumentsentry() {
		
		
	    String sql = "SELECT * FROM jcipayment_arrangement";
	    List<EntryPaymentDetailsModel> fCList = sessionFactory.getCurrentSession()
	            .createSQLQuery(sql)
	            .addEntity(EntryPaymentDetailsModel.class)
	            .list();
	    return fCList;
	}
	@Override
	public void updatestatus(EntryPaymentDetailsModel EntryPaymentDetailsModel) {
		currentSession().update(EntryPaymentDetailsModel);
	}

	@Override
	public void update(EntryPaymentDetailsModel EntryPaymentDetailsModel) {
		currentSession().update(EntryPaymentDetailsModel);
	}

	@Override
	public EntryPaymentDetailsModel edit(int id) {
		return find(id);
	}

	public EntryPaymentDetailsModel find(int id) {
		// TODO Auto-generated method stub
		return (EntryPaymentDetailsModel) currentSession().get(EntryPaymentDetailsModel.class, id);
	}

	
	 
	
	@Override
	 public void update1(String cont_no,int paymentId) {
			Date date= new Date();
			 SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		     String dateString = dateFormat.format(date);
		    String hql = "UPDATE jcipayment_arrangement set Fc_status = 2,Fc_remarks='Rejected', Fc_action_date = '" + dateString + "'  where Contract_No = '" + cont_no + "' and  Payment_id = '" + paymentId + "' ";

		    
		    String hql1 = "UPDATE jcicontract set contract_status='Approved by Finance' where Contract_no = '" + cont_no + "' ";
		    this.sessionFactory.getCurrentSession().createSQLQuery(hql1).executeUpdate();
	        this.sessionFactory.getCurrentSession().createSQLQuery(hql).executeUpdate();
		}
	
	
	@Override
	public void update2(String cont_no) {
		Date date= new Date();
		 SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	     String dateString = dateFormat.format(date);
	    String hql = "UPDATE jcipayment_arrangement set Fc_status = 1,Fc_remarks='Accepted', Fc_action_date = '" + dateString + "'  where Contract_No = '" + cont_no + "' ";
	    
	    String hql1 = "UPDATE jcicontract set contract_status='Approved by Finance' where Contract_no = '" + cont_no + "' ";
	    this.sessionFactory.getCurrentSession().createSQLQuery(hql1).executeUpdate();
        this.sessionFactory.getCurrentSession().createSQLQuery(hql).executeUpdate();
	}
	

	
	
	
	

	

	 @Override
	    public EntryPaymentDetailsModel getById(int id) {
	        return (EntryPaymentDetailsModel) sessionFactory.getCurrentSession().get(EntryPaymentDetailsModel.class, id);
	    }

	@Override
	public List<Object> ContractNo() {
		String sql="select  Contract_no from  jcicontract";
		 List<Object>resultList1= (List<Object>)this.sessionFactory.getCurrentSession().createSQLQuery(sql).list();
	    return resultList1;
	}

	@Override
	public void contratTable(String cont_no) {
		
		
	
		Date dateTime = new Date();
		
//	        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");  
//	        String strDate = dateFormat.format(dateTime); 
//	        
//	        SimpleDateFormat formatter1 = new SimpleDateFormat("yyyy-MM-dd");
//	        Date instdate1 = null;
//			try {
//				instdate1 = formatter1.parse(strDate);
//			} catch (ParseException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
	       
		// TODO Auto-generated method stub
		 String hql = "UPDATE jcicontract set intial_payment_flag = 1 ,intial_payment_date= '" + dateTime + "', contract_status='Payment Done' where Contract_no = '" + cont_no + "' ";
		    this.sessionFactory.getCurrentSession().createSQLQuery(hql).executeUpdate();
	}

	@Override
	public  List<Object[]> paymentdetails(String st) {
		String sql="select  Contract_qty,Contract_value ,Contract_date, Payment_duedate,Mill_name,Grade_composition from  jcicontract where  Contract_no='" + st + "' ";
		 List<Object[]>resultList1= (List<Object[]>)this.sessionFactory.getCurrentSession().createSQLQuery(sql).list();
		    return resultList1;

				
	}
	
//	String sql="SELECT c.Regional_Office, s.unit_name, s.unit_address1, s.unit_state, s.unit_location, s.client_gstin, s.client_pan, s.client_state, s.client_address1, s.client_name\r\n"
//			+ "				FROM (SELECT a.unit_name, a.unit_address1, a.unit_state, a.unit_location,  b.client_gstin, b.client_pan, b.client_state, b.client_address1, b.client_name, a.client_unit_code\r\n"
//			+ "			 FROM jcimilldetailchild AS a LEFT JOIN jcimilldetailmaster AS b ON a.client_code = b.client_code)\r\n"
//			+ "				 AS s LEFT JOIN jcidispatch_details AS c ON s.client_unit_code = c.Mill_code\r\n"
//			+ "                  Label_name='" + st + "'";
	
	
	@Override
	public  List<Object[]>gradewiseqty(String st ,String contractqty) {
		String sql=" select Jute_combination,(Proposed_composition*'" + contractqty + "')/100 as ammount   from  jcigrade_composition where Label_name='" + st + "'";
		 List<Object[]>resultList1= (List<Object[]>)this.sessionFactory.getCurrentSession().createSQLQuery(sql).list();
		    return resultList1;
     }
	
	
	
}
