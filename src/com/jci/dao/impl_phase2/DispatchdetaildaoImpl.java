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
    public List<dispatchdetailModel> getviewDispatchChallan() {
//        Criteria criteria = currentSession().createCriteria(FinancialConcurenceModel.class);
//        return criteria.list();
        String sql = " SELECT a.Challan_no , a.Consignment_note,a.Contract_No,a.Contract_date,a.Creation_date,a.DI_Date,a.DI_No,a.Date_of_shipment,"
        		+ "a.Di_status,a.Driver_contact,a.Driver_name,a.License_no,a.Mill_name,a.Mode_of_shipment,a.Place_of_Shipment,a.Regional_Office,a.Vehicle_no,"
        		+ "b.BIN_no,b.Bale_mark,b.Crop_year,b.Jute_grade,b.Jute_value,b.Jute_variety,b.No_of_bales,Nominal_qty,b.Nominal_wt,b.Rate, FROM jcidispatch_details as a leftjoin jcidispatch_details_child as b on b.Challan_no=a.Challan_no ";
	    List<dispatchdetailModel> fCList = sessionFactory.getCurrentSession().createSQLQuery(sql).addEntity(dispatchdetailModel.class).list();
	    return fCList;
    }
}
