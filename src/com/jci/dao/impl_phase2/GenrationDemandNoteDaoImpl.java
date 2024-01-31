package com.jci.dao.impl_phase2;

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
	public GenrationDEmandDto fetchContract_no(String st) {
		GenrationDEmandDto resultList12 =  new GenrationDEmandDto();
		List<Object[]> result = new ArrayList<>();
		try 
		  {
			String sql = "select a.Contract_no, a.Contract_date,c.Payment_duedate, c.Contract_cancel_date ,d.Payment_id, f.Contracted_qty, f.Carrying_Cost_Charged\r\n"
					+ "									from jcidispatch_details a left join jcicontract c on c.Contract_no = a.Contract_No left join\r\n"
					+ "										jcipayment_arrangement d on d.Contract_No = a.Contract_No \r\n"
					+ "											left join jcifinancial_concurrence f on f.Contractno = a.Contract_No \r\n"
					+ "											   where f.Contractno = '" + st + "' ";
    		
	
		
		Session session = sessionFactory.getCurrentSession();
		  Transaction tx = session.beginTransaction();
		  SQLQuery query = session.createSQLQuery(sql);
		  System.out.println("KKKKKKKKKKKK"+query);
		  result = query.list();
        for(  Object[] element:result) {
	    	 
	    	  resultList12.setContract_date((Date)element[1]);
		      resultList12.setPayment_duedate((String) element[2]);
		      resultList12.setContract_cancel_date((String) element[3]);
		      resultList12.setPayment_id((int) element[4]);
		      resultList12.setContracted_qty( (String) element[5]);
		      resultList12.setCarrying_Cost_Charged((String) element[6]);
		     
		     
//	        
	         }
	     System.err.println(resultList12);
		  }
		  catch (Exception e)
		  {
			  System.out.println(e.getLocalizedMessage());
			  e.printStackTrace();
		  }
//	
		return   resultList12;
	}
	@Override
	public List<Object> fetchcon_no() {
	
	  	String sql="select Contract_no from jcicontract   ";
				
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

		
	}
	
	
	
	 

	    

