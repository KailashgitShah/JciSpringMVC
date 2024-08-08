package com.jci.dao.impl_phase2;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jci.dao_phase2.PaymentRealizationDao;
import com.jci.model.JciEntryTdsModel;
import com.jci.model.uploadPaymentRealisationModel;

@Repository
public class PaymentRealizationDaoImpl implements PaymentRealizationDao{
	
	@Autowired
	SessionFactory sessionFactory;

	protected Session currentSession() {
		return (Session) sessionFactory.getCurrentSession();
	}

	@Override
	public void create(uploadPaymentRealisationModel uploadPaymentRealisation) {

		currentSession().save(uploadPaymentRealisation);
		 
	}

	@Override
	public List<uploadPaymentRealisationModel> getAll() {
		// TODO Auto-generated method stub
		Criteria c = this.sessionFactory.getCurrentSession().createCriteria(uploadPaymentRealisationModel.class);
		List<uploadPaymentRealisationModel> ll = c.list();
		return ll;
	}

	@Override
	public List<Object[]> fetchMill_Name() {
		
		String sql =" SELECT distinct c.unit_name,c.client_unit_code from jcimilldetailchild c INNER join jcisettlement_cndn AS s ON s.millCode =c.client_unit_code";
		
		
		List<Object[]>resultList1= (List<Object[]>)this.sessionFactory.getCurrentSession().createSQLQuery(sql).list();
		 return resultList1;
	
	}

	@Override
	public List<Object[]> contractForMill(String  millcode) {
	    String sql = "SELECT distinct Contract_no from jcisettlement_cndn WHERE millCode ='" + millcode + "'";

	    List<Object[]>resultList1= (List<Object[]>)this.sessionFactory.getCurrentSession().createSQLQuery(sql).list();
	    return resultList1;
	}

	@Override
	public List<Object[]> TransactionForContract(String contractNo) {
		// TODO Auto-generated method stub
		//String sql = "SELECT distinct IdentificationCnDn from jcisettlement_cndn where Contract_no='"+contractNo+"'";
		String sql = "SELECT DISTINCT IdentificationCnDn " +
	             "FROM jcisettlement_cndn " +
	             "WHERE Contract_no = '" + contractNo + "' " +
	             "AND IdentificationCnDn NOT IN (" +
	             "    SELECT transactionid " +
	             "    FROM jciuploadpaymentRealisation" +
	             ")";
 
		List<Object[]>resultList1= (List<Object[]>)this.sessionFactory.getCurrentSession().createSQLQuery(sql).list();
		    return resultList1;
	}

	@Override
	public void update(String contractNo) {
		
		String sql ="update  jcicontract set Contract_status='payment Realisation Uploaded'  WHERE Contract_no ='"+contractNo+"'";
		// TODO Auto-generated method stub

		this.sessionFactory.getCurrentSession().createSQLQuery(sql).executeUpdate();
		
	}

	@Override
	public List<String> cropYear() {
		String q ="select distinct CropYear from jcicontract";
		List<String> FMUsername = (List<String>) this.sessionFactory.getCurrentSession().createSQLQuery(q).list();
		//System.out.println(FMUsername);

		return FMUsername;
		
		//List cropyear= (List) this.sessionFactory.getCurrentSession().createSQLQuery(sql).list();

	//	return cropyear;
		// TODO Auto-generated method stub
		
	}

	
}
