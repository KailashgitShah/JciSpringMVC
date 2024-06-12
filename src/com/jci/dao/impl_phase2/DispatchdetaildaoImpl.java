package com.jci.dao.impl_phase2;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.jci.dao_phase2.Dispatchdetaildao;
import com.jci.model.FinancialConcurenceModel;
import com.jci.model.dispatchdetailModel;


@Repository
@Transactional
public class DispatchdetaildaoImpl implements Dispatchdetaildao {
	
	@Autowired
	SessionFactory sessionFactory;
	
	protected org.hibernate.Session currentSession(){
		return sessionFactory.getCurrentSession();
	}
	@Override
	public List<Object[]> getviewDispatchChallan() {
	    String sql = 
	    	    " 	    SELECT DISTINCT  a.Challan_no, a.Contract_No,  a.Mill_name,\r\n"
	    	    + "	     CONVERT(VARCHAR(10), a.Contract_date, 105) AS Formatted_Contract_date, \r\n"
	    	    + "	    	   a.DI_No, \r\n"
	    	    + "	      CONVERT(VARCHAR(10), a.DI_Date, 105) AS Formatted_DI_Date,\r\n"
	    	    + "	    	 CONVERT(VARCHAR(10), a.Date_of_shipment, 105) AS Formatted_Date_of_shipment, \r\n"
	    	    + "	    	\r\n"
	    	    + "	    a.Place_of_Shipment,  \r\n"
	    	    + "	    	  b.Bale_mark,a.Consignment_note_text \r\n"
	    	    + "	    	 FROM jcidispatch_details AS a\r\n"
	    	    + "	    	 LEFT JOIN jcidispatch_details_child AS b ON b.Challan_no = a.Challan_no  where a.Di_status='0' ";

	    List<Object[]> fCList = (List<Object[]>) sessionFactory.getCurrentSession().createSQLQuery(sql).list();
	    return fCList;
	}

}
