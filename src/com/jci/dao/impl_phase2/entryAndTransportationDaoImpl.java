package com.jci.dao.impl_phase2;

import org.springframework.stereotype.Repository;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.jci.dao_phase2.entryAndTransportationDao;
import com.jci.model.FactorssInvolvedCommercial;
import com.jci.model.OperationCostModel;
import com.jci.model.OperationFreeSales;
@Transactional
@Repository
public class entryAndTransportationDaoImpl implements entryAndTransportationDao{
	@Autowired
	SessionFactory sessionFactory;

	protected Session currentSession() {
		return sessionFactory.getCurrentSession();
	}
	
	public List<OperationCostModel> getAll() {
		
		   
		// TODO Auto-generated method stub
		Criteria c = this.sessionFactory.getCurrentSession().createCriteria(OperationCostModel.class);
		List<OperationCostModel> ll=c.list();
		return ll;
	}

	public List<Object[]> getDetails() {
		// TODO Auto-generated method stub
		String sqlString ="Select a.crop_year,b.roname,a.dpc,a.operation_cost_head,a.rate,a.unit,a.valid_till,a.basis ,a.ofc_id from jcioperationfreesales_cost a inner join jcirodetails b on a.region = b.rocode;";
		
		List<Object[]> list1 = this.sessionFactory.getCurrentSession().createSQLQuery(sqlString).list();
		return list1;
	}

	@Override
	public void  saveDataInFreeOperationModelsaveDataInFreeOperationModel(OperationFreeSales operationcostmodel) {
		System.out.println("saving  savetransportcostfreesales");
		currentSession().save(operationcostmodel);
		
	}

	@Override
	public String findunitByFactoHead(String factorHead) {
		String sql  =  "  SELECT unit from  jci_commercial_factors Where factor_head ='"+factorHead+"'";
		
		
		 String balanceAmount = (String)this.sessionFactory.getCurrentSession().createSQLQuery(sql).uniqueResult();		
		

		  return balanceAmount;  
	}
	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		String hql = "Delete from jcioperationfreesales_cost where ofc_id = '" + id + "' ";
		this.sessionFactory.getCurrentSession().createSQLQuery(hql).executeUpdate();
	}
	@Override
	public Double nominalWeight(String rocode) {
		
		String sql  =  "SELECT Distinct nominal_wt from jcipurchasecenter WHERE rocode = '"+rocode+"'";
		
		
		 Double nominalWeight = (Double)this.sessionFactory.getCurrentSession().createSQLQuery(sql).uniqueResult();		
		System.err.println(nominalWeight + "nominalWeight");
          
		  return nominalWeight;  
		// TODO Auto-generated method stub
	
	}

	@Override
	public List<FactorssInvolvedCommercial> getAllFactorHead() {
		// TODO Auto-generated method stub
		Criteria c = this.sessionFactory.getCurrentSession().createCriteria(FactorssInvolvedCommercial.class);
		List<FactorssInvolvedCommercial> ll=c.list();
		return ll;
	}


}
