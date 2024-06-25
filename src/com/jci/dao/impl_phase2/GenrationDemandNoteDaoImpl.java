package com.jci.dao.impl_phase2;

import java.math.BigInteger;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.jci.dao_phase2.GenrationDemandNoteDao;
import com.jci.model.GenrationDemandNoteModel;
import com.jci.model.MillRecieptModel;
import com.jci.model.GenrationDEmandDto;

@Repository
@Transactional
public class GenrationDemandNoteDaoImpl implements GenrationDemandNoteDao  {
	@Autowired
	SessionFactory sessionFactory;
	protected Session currentSession(){
		return sessionFactory.getCurrentSession();
	}
	
	@Override
	public void create(GenrationDemandNoteModel genrationDemandNoteModel) {
		
		currentSession().saveOrUpdate(genrationDemandNoteModel);
	}
	@Override
    public List<GenrationDemandNoteModel> getAll() {
        Criteria criteria = currentSession().createCriteria(GenrationDemandNoteModel.class);
        return criteria.list();
    }
	@Override
	public void update(GenrationDemandNoteModel genrationDemandNoteModel) {
		currentSession().update(genrationDemandNoteModel);
	}

	@Override
	public GenrationDemandNoteModel edit(int id) {
		return find(id);
	}

	public GenrationDemandNoteModel find(int id) {
		// TODO Auto-generated method stub
		return (GenrationDemandNoteModel) currentSession().get(GenrationDemandNoteModel.class, id);
	}

	
	 

	 @Override
	    public GenrationDemandNoteModel getById(int id) {
	        return (GenrationDemandNoteModel) sessionFactory.getCurrentSession().get(GenrationDemandNoteModel.class, id);
	    }

	@Override
	public List<Object[]> fetchContract_no(String st) {
		
		
		
			String sql = "\r\n"
					+ "  Select a.Contract_date , b.PaymentDue_date, a.Contract_cancel_date , b.Instrument_No ,c.QtyAllowed,CONVERT(VARCHAR, b.Instrument_Date, 105) AS PaymentDate,b.Supporting_document from jcicontract a\r\n"
					+ "  Inner join jcipayment_arrangement b on a.Contract_No= b.Contract_No\r\n"
					+ "  inner join jcifinancial_concurrence c on a.Contract_no= c.Contractno\r\n"
					+ "   where a.Contract_No='"+st+"';";
    		
	
		
			 List<Object[]>resultList1= (List<Object[]>)this.sessionFactory.getCurrentSession().createSQLQuery(sql).list();
       
	     System.err.println(resultList1);
		
//	
		return   resultList1;
	}
	@Override
	public List<Object> fetchcon_no() {
	
	  	String sql="select Distinct Contractno from jcifinancial_concurrence where Carrying_Cost_Charged <>0;  ";
				
		//String sql=" select dd.Challan_no,dd.Date_of_shipment,dd.Vehicle_no,dd.Bale_mark,dd.Jute_variety,dd.Crop_year,mr.MR_No from  jcidispatch_details as dd join jcimill_receipt as mr on dd.Dientry_id=mr.Mr_id ";

		//String sql="select Challan_no,Date_of_shipment,Vehicle_no,Bale_mark,Jute_variety,Crop_year from  jcidispatch_details";
	    List<Object>resultList1= (List<Object>)this.sessionFactory.getCurrentSession().createSQLQuery(sql).list();
	    return resultList1;

//	 
		
	}

	@Override
	public String demandnono(String st) 
	{
		
		String sql ="SELECT  count(*) FROM jcidemand_note WHERE Demand_note_no = '" + st + "' ";
		int  total = (Integer)this.sessionFactory.getCurrentSession().createSQLQuery(sql).uniqueResult();		
		
		
		if(total>0)
			return "1";
		else 
			return "0";

	
	}

	@Override
	public String count() {
	    String sql = "SELECT COUNT(*) FROM jcidemand_note";
	    Number count = (Number) this.sessionFactory.getCurrentSession().createSQLQuery(sql).uniqueResult();

	    // Handle null case if count is null
	    int totalCount = (count != null) ? count.intValue() : 0;

	    // Increment the count by 1
	    int incrementedCount = totalCount + 1;

	    // Convert to String and return
	    return String.valueOf(incrementedCount);
	}


		
	}
	
	
	
	 

	    

