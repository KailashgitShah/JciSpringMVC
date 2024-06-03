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
	    String sql = " SELECT * FROM jcipayment_arrangement WHERE Fc_status IN(0)";
//	    String sql = " SELECT *,\r\n"
//	    		+ "       CONVERT(varchar(10), Instrument_Date, 105) AS formatted_instrument_date,\r\n"
//	    		+ "       CONVERT(varchar(10), Expiry_date, 105) AS formatted_expiry_date,\r\n"
//	    		+ "       CONVERT(varchar(10), Last_shipment_date, 105) AS formatted_last_shipment_date\r\n"
//	    		+ "FROM jcipayment_arrangement\r\n"
//	    		+ "WHERE Fc_status IN (0, 1)";
	    		
	    List<EntryPaymentDetailsModel> fCList = sessionFactory.getCurrentSession()
	            .createSQLQuery(sql)
	            .addEntity(EntryPaymentDetailsModel.class)
	            .list();
	    return fCList;
	}
	@Override
	public List<EntryPaymentDetailsModel> getAllPaymentInstrumentsentry() {
		
		
	    String sql = "SELECT * FROM jcipayment_arrangement";
//				     String sql = " SELECT *,\r\n"
//			+ "       CONVERT(varchar(10), Instrument_Date, 105) AS formatted_instrument_date,\r\n"
//			+ "       CONVERT(varchar(10), Expiry_date, 105) AS formatted_expiry_date,\r\n"
//			+ "       CONVERT(varchar(10), Last_shipment_date, 105) AS formatted_last_shipment_date\r\n"
//			+ "FROM jcipayment_arrangement\r\n";
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
	 public void update1(String cont_no,int paymentId,String remark) {
			Date date= new Date();
			 SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		     String dateString = dateFormat.format(date);
		    String hql = "UPDATE jcipayment_arrangement set Fc_status = 2,Fc_remarks='Rejected', Fc_action_date = '" + dateString + "',Remarks='" + remark + "'  where Contract_No = '" + cont_no + "' and  Payment_id = '" + paymentId + "' ";

		    
		    String hql1 = "UPDATE jcicontract set contract_status='Rejected by Finance' where Contract_no = '" + cont_no + "' ";
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

	 
//		String sql="    SELECT  c.Contract_no  FROM (SELECT  a.Contract_no, a.Contract_value, SUM(CAST(b.Instrument_value AS DECIMAL(10,2))) AS Total_Instrument_Value\r\n"
//				+ "    FROM jcicontract AS a  LEFT JOIN jcipayment_arrangement AS b  ON   a.Contract_no = b.Contract_No\r\n"
//				+ "    GROUP BY a.Contract_no,a.Contract_value) AS d  LEFT JOIN  jcicontract AS c ON  c.Contract_no = d.Contract_no WHERE  d.Contract_value > d.Total_Instrument_Value or  d.Total_Instrument_Value is NULL \r\n"
//				;
	 
	 
	 
	@Override
	public List<Object> ContractNo() {
		String sql2 = "SELECT a.Contract_no, a.Contract_value - COALESCE(SUM(TRY_CAST(b.Instrument_value AS DECIMAL(10, 2))), 0) "
				+ " AS Difference from jcicontract  as a left join jcipayment_arrangement as b on a.Contract_no = b.Contract_No group by "
				+ " a.Contract_no, a.Contract_value having a.Contract_value > COALESCE(SUM(TRY_CAST(b.Instrument_value AS DECIMAL(10, 2))), 0)"
				+ " OR SUM(TRY_CAST(b.Instrument_value AS DECIMAL(10, 2))) IS NULL";
		 List<Object>resultList1= (List<Object>)this.sessionFactory.getCurrentSession().createSQLQuery(sql2).list();
	    return resultList1;
	}

	@Override
	public void contratTable(String cont_no) {
	
		try {
	Date dateTime = new Date();
    String hql = "UPDATE jcicontract set intial_payment_flag = 1 ,intial_payment_date= '" + dateTime + "', contract_status='Payment Done' where Contract_no = '" + cont_no + "' ";
		    this.sessionFactory.getCurrentSession().createSQLQuery(hql).executeUpdate();
		}
		catch(Exception e)
		{
			 e.printStackTrace();
		}
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
	
	@Override
	public  List<Object[]>PreviousNo(String st) {
		String sql="SELECT Contract_No, Instrument_value, Instrument_Date FROM jcipayment_arrangement where Contract_No='" + st + "'";
		 List<Object[]>resultList1= (List<Object[]>)this.sessionFactory.getCurrentSession().createSQLQuery(sql).list();
		    return resultList1;
     }

	@Override
	public List<Object> getsumofInstrumentValue(String instValue) {
		String sql=" select  Instrument_value from jcipayment_arrangement WHERE  Contract_No='JCI/190/2023-2024/BT003'";
		 List<Object>resultListofsum= (List<Object>)this.sessionFactory.getCurrentSession().createSQLQuery(sql).list();
	    return resultListofsum;
	}
	
	@Override
	public void remark(String remark ,String  con_No,int id) {
		 String hql = "UPDATE  jcipayment_arrangement set Remarks =  '" + remark + "'  where Contract_No = '" + con_No + "' and Payment_id= '" + id + "' ";
		
	    this.sessionFactory.getCurrentSession().createSQLQuery(hql).executeUpdate();

	}

	@Override
	public List<Object> PreviousInstruValue(String st) {
		String sql=" select  Instrument_value from jcipayment_arrangement WHERE  Contract_No='" + st + "' ";
		 List<Object>resultListofsum= (List<Object>)this.sessionFactory.getCurrentSession().createSQLQuery(sql).list();
	    return resultListofsum;
	}

	@Override
	public List<Object> Millname() {
		
		String sql="SELECT DISTINCT Mill_name FROM jcicontract;";
		 List<Object>millNamelist= (List<Object>)this.sessionFactory.getCurrentSession().createSQLQuery(sql).list();
		    return millNamelist;
	}

	@Override
	public List<Object[]> millnamecontractvise(String st) {
		
		
		//String sql="SELECT  Contract_no from jcicontract where Mill_name='" + st + "'";
		String sql="SELECT c.Contract_no  FROM (SELECT  a.Contract_no, a.Contract_value, \r\n"
				+ "        COALESCE(SUM(CAST(b.Instrument_value AS DECIMAL(10,2))), 0) AS Total_Instrument_Value,\r\n"
				+ "        (a.Contract_value - COALESCE(SUM(CAST(b.Instrument_value AS DECIMAL(10,2))), 0)) AS Difference\r\n"
				+ "    FROM jcicontract AS a  \r\n"
				+ "    LEFT JOIN jcipayment_arrangement AS b ON a.Contract_no = b.Contract_No\r\n"
				+ "    WHERE a.Mill_name = '" + st + "' \r\n"
				+ "    GROUP BY a.Contract_no, a.Contract_value\r\n"
				+ "    HAVING a.Contract_value > COALESCE(SUM(CAST(b.Instrument_value AS DECIMAL(10,2))), 0) OR SUM(CAST(b.Instrument_value AS DECIMAL(10,2))) IS NULL\r\n"
				+ ") AS d \r\n"
				+ "LEFT JOIN jcicontract AS c ON c.Contract_no = d.Contract_no \r\n"
				+ "WHERE d.Contract_value > d.Total_Instrument_Value OR d.Total_Instrument_Value IS NULL;";
		 List<Object[]>millnamelist= (List<Object[]>)this.sessionFactory.getCurrentSession().createSQLQuery(sql).list();
		    return millnamelist;
		
	}

	@Override
	public List<Object[]> contractlistfetchdata(String st) {
		String sql="SELECT  Contract_no,Contract_qty,Contract_value,Contract_date,Payment_duedate from jcicontract where Contract_no='" + st + "'";
		 List<Object[]>millnamelist= (List<Object[]>)this.sessionFactory.getCurrentSession().createSQLQuery(sql).list();
		    return millnamelist;
	}

	@Override
	public void deleteEntry(int id) {
		String sql="delete from jcipayment_arrangement where Payment_id='" + id + "'";
		  this.sessionFactory.getCurrentSession().createSQLQuery(sql).executeUpdate();
		  
		
	}



	
	
	
}
