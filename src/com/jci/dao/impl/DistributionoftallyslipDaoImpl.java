package com.jci.dao.impl;


import java.util.ArrayList;
import java.util.List;
import java.sql.Date;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.jci.dao.DistributionoftallyslipDao;
import com.jci.model.DistributionoftallyslipModel;

@Transactional
@Repository

public class DistributionoftallyslipDaoImpl implements DistributionoftallyslipDao {
	
	@Autowired
	private HttpServletRequest request;

	@Autowired
	SessionFactory sessionFactory;
	protected Session currentSession(){
		return sessionFactory.getCurrentSession();
	}

	@Override
	public void create(DistributionoftallyslipModel distributionoftallyslipModel) {
		currentSession().saveOrUpdate(distributionoftallyslipModel);

	}

	@Override
	public void update(DistributionoftallyslipModel distributionoftallyslipModel) {
		currentSession().save(distributionoftallyslipModel);

	}

	@Override
	public DistributionoftallyslipModel edit(int id) {
		return find(id);
	}

	@Override
	public void delete(int id) {
		String hql = "Delete from dbo.jcislip where refid = '"+id+"' " ;
		this.sessionFactory.getCurrentSession().createSQLQuery(hql).executeUpdate();
	}

	@Override
	public DistributionoftallyslipModel find(int id) {
		return (DistributionoftallyslipModel) currentSession().get(DistributionoftallyslipModel.class, id);
	}

	@Override
	public List<DistributionoftallyslipModel> getAll(String dpcId) {
		Criteria c = this.sessionFactory.getCurrentSession().createCriteria(DistributionoftallyslipModel.class);
		List<Integer> result = new ArrayList<>();
		HttpSession session1=request.getSession(false); 
		String querystr = "";
		/*String roletypes = (String) session1.getAttribute("roletype");
		if(roletypes.equalsIgnoreCase("HO")){
	querystr = "  SELECT pur.centername,bale.* FROM XMWJCI.dbo.jcislip bale left join XMWJCI.dbo.jcipurchasecenter pur on bale.dpccode = pur.CENTER_CODE;";
		}*/
		/*
		 * else if(roletypes.equalsIgnoreCase("ZO")) { querystr = ""; } else
		 * if(roletypes.equalsIgnoreCase("RO")) { querystr = "  "; }
		 */
		
		/* else { */
			querystr = "SELECT pur.centername,bale.* FROM XMWJCI.dbo.jcislip bale left join XMWJCI.dbo.jcipurchasecenter pur on bale.dpccode = pur.CENTER_CODE where bale.dpccode = '"+dpcId+"'";
		/* } */
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		SQLQuery query = session.createSQLQuery(querystr);
		List<Object[]> rows = query.list();
		List<DistributionoftallyslipModel> ll = new ArrayList<>();
		for(Object[] row: rows) {
			
			String dpcName = (String)row[0];
			int refid = (int)row[1];
			String dpccode = (String)row[2];
			String dateofreceipt = (String)row[3];
			String slipreceived = (String)row[4];
			String seriesstartfrom = (String)row[5];
			String seriestoend = (String)row[6];
			//Date createddate = (Date)row[7];

			DistributionoftallyslipModel distribtally = new DistributionoftallyslipModel();
		//
			distribtally.setDateofreceipt(dateofreceipt);
			distribtally.setDpccode(dpccode);
			distribtally.setRefid(refid);
			distribtally.setSeriesstartfrom(seriesstartfrom);
			distribtally.setSeriestoend(seriestoend);
			distribtally.setSlipreceived(slipreceived);
	        
			ll.add(distribtally);
		}
		return ll;
	}

	

	@Override
	public boolean submitform(DistributionoftallyslipModel distributionoftallyslipModel) {
		this.sessionFactory.getCurrentSession().save(distributionoftallyslipModel);
		return false;
	}

}
