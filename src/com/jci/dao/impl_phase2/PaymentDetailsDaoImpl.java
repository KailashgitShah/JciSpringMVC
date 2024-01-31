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
	
	@Override
	public List<EntryPaymentDetailsModel> getAllPaymentInstruments() {
		
		
	   // String sql = "SELECT * FROM jcipayment_arrangement WHERE Fc_status = 0 or Fc_status = 1 ";
	    String sql = "SELECT * FROM jcipayment_arrangement WHERE Fc_status = 0";
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
	 public void update1(String cont_no) {
			Date date= new Date();
			 SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		     String dateString = dateFormat.format(date);
		    String hql = "UPDATE jcipayment_arrangement set Fc_status = 2,Fc_remarks='Rejected', Fc_action_date = '" + dateString + "'  where Contract_No = '" + cont_no + "' ";
		    
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
}
