package com.jci.dao.impl_phase2;

import java.util.List;



import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.jci.dao_phase2.ConfirmationClaimSettlementDao;
import com.jci.model.CashDocumentModel;
import com.jci.model.ConfirmationClaimSettlementModel;

@Repository
@Transactional
public class ConfirmationClaimSettlementDaoImpl implements ConfirmationClaimSettlementDao  {
	@Autowired
	SessionFactory sessionFactory;
	protected Session currentSession(){
		return sessionFactory.getCurrentSession();
	}
	
	@Override
	public void create(ConfirmationClaimSettlementModel confirmationClaimSettlementModel) {
		
		currentSession().save(confirmationClaimSettlementModel);
	}
		@Override
	    public List<ConfirmationClaimSettlementModel> getAll() {
	        Criteria criteria = currentSession().createCriteria(ConfirmationClaimSettlementModel.class);
	        criteria.addOrder(Order.desc("Created_on"));
	        return criteria.list();
	    }

	@Override
	public List<Object>SettlementId() {
	String sql="select  Settlement_id from  jciclaim_nomination";
			 List<Object>resultList1= (List<Object>)this.sessionFactory.getCurrentSession().createSQLQuery(sql).list();
		    return resultList1;
		}
	@Override
    public List<Object[]> gradecfetchingdata1omposition(String contractno) {
          String q="  SELECT     Jcigrade_composition.Jute_combination,\r\n"
          		+ "                      (jcigrade_composition.Proposed_composition*jcicontract.Contract_qty)/100 as new_proposed_composition\r\n"
          		+ "                     FROM Jcigrade_composition  INNER JOIN  jcicontract on  jcicontract.Grade_composition=jcigrade_composition.Label_name\r\n"
          		+ "                    WHERE Contract_no='"+contractno+"';";
               List<Object[]> gradecomposition= (List<Object[]>) this.sessionFactory.getCurrentSession().createSQLQuery(q).list();
                   return gradecomposition;
          
          
    }

//	
	@Override
	public List<Object[]>fetchdataofclaim( String st) {
		String sql =" select MR_no,Bale_mark,Crop_year,Quality_claim,MoistureContent,NCV_percentage,Challan_no from jcimill_receipt WHERE HO_di =  '" +st+"'"; 
		  		 List<Object[]>resultList1= (List<Object[]>)this.sessionFactory.getCurrentSession().createSQLQuery(sql).list();
		    return resultList1;
		}
    
    
//	@Override
//	public List<Object[]>fetchdataofclaim( String st) {
//		String sql =" select a.MR_no,a.Bale_mark,a.Crop_year,a.Quality_claim,a.MoistureContent,a.NCV_percentage,a.Challan_no,b.Contract_qty,b.Grade_composition from jcicontract as b left join jcimill_receipt  as a on a.HO_di =b.Contract_no WHERE HO_di =  '" +st+"'"; 
//		  		 List<Object[]>resultList1= (List<Object[]>)this.sessionFactory.getCurrentSession().createSQLQuery(sql).list();
//		    return resultList1;
//		}
	
	@Override
	public List<Object[]>fetchdatasttlement(int st) {
		String sql =" select Quality_settlement,Moisture_settlement,Ncv_settlement,Settlement_amt,ClaimAmount,DateofInspection,Supporting_doc from jciclaim_nomination WHERE Settlement_id = '" +st+"'"; 
		  		 List<Object[]>resultList1= (List<Object[]>)this.sessionFactory.getCurrentSession().createSQLQuery(sql).list();
		    return resultList1;
		}

	@Override
	public List<String> fetchContract(String settlementId) {
		// TODO Auto-generated method stub
		String sqlString ="Select ContractNo from jciclaim_nomination where Settlement_id='"+settlementId+"';";
		List<String>resultList1= (List<String>)this.sessionFactory.getCurrentSession().createSQLQuery(sqlString).list();
		return resultList1;
	}
	
	

	

}
