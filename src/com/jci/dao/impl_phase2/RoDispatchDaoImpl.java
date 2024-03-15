package com.jci.dao.impl_phase2;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.jci.dao_phase2.RoDispatchDao;
import com.jci.model.EntryDerivativePrice;
import com.jci.model.RoDispatchModel;

@Transactional
@Repository
public class RoDispatchDaoImpl implements RoDispatchDao {

	@Autowired
	private HttpServletRequest request;

	@Autowired
	SessionFactory sessionFactory;


	protected Session currentSession() {
		return sessionFactory.getCurrentSession();
	}
	
	@Override
	public List<String> loadAllDpc() {
		String regionCode = (String) request.getSession().getAttribute("region");
		String sqlString = "select centername from jcipurchasecenter where rocode='"+regionCode+"'";
		List<String> list = currentSession().createSQLQuery(sqlString).list();
		return list;
	}

	@Override
	public List<String> loadAllDiNo() {
		String regionCode = (String) request.getSession().getAttribute("region");
		String sqlString = "select Distinct DI_no from jciDI_ho where Regional_office='" + regionCode + "' and  DPC <> '';";
		List<String> list = currentSession().createSQLQuery(sqlString).list();
		return list;
	}
	//Returns object of all DI details 
	@Override
	public List<Object> loadAllContractDetails(String diNo) {
		String sqlString = "select * from jciDI_ho where DI_no='"+diNo+"'";
		List<Object> list = currentSession().createSQLQuery(sqlString).list();
		return list;
	}
	@Override
	public int getCountOfAvailableEntries(String hoNo) {
		String sqlString = "select count(HO_DI_NO) from jciDI_ro where HO_DI_NO = '"+hoNo+"'";
		return (int) this.currentSession().createSQLQuery(sqlString).uniqueResult();
	
	}

	@Override
	public void create(RoDispatchModel roDispatchModel) {
		this.currentSession().save(roDispatchModel);
		
	}

	@Override
	public List<RoDispatchModel> getAllRoDi() {
		Criteria c = this.sessionFactory.getCurrentSession().createCriteria(RoDispatchModel.class).addOrder(Order.desc("creationDate"));
		List<RoDispatchModel> ll = c.list();
			return ll;
	
	}
	

	@Override
	public List<String> getCooperative(String regionIdString) {
		String sqlString ="Select centername from jcipurchasecenter where rocode='"+regionIdString+"';";
		List<String> list = currentSession().createSQLQuery(sqlString).list();
		// TODO Auto-generated method stub
		return list;
	}

}
