package com.jci.dao.impl_phase2;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.jci.dao_phase2.verifyClaimDao;
@Transactional
@Repository
public class verifyClaimDaoImpl implements verifyClaimDao{
	@Autowired
	SessionFactory sessionFactory;
	protected Session currentSession() {
		return sessionFactory.getCurrentSession();
	}
	@Override
	public List<Object[]> fetchClaimsMill(String settlementId) {
	String liString="\r\n"
			+ "SELECT  jciclaim_report_mill.Claim_Amount,jciclaim_report_mill.Date_of_Inspection , jciclaim_report_mill.created_by, jciclaim_report_mill.Moisture_settlement,jciclaim_report_mill.Ncv_settlement,  jciclaim_report_mill.Quality_settlement, jciclaim_report_mill.Supporting_doc, jciclaim_report_mill.Settlement_amt,jciclaim_nomination.ClaimAmount, jciclaim_nomination.Created_by, jciclaim_nomination.Moisture_settlement, jciclaim_nomination.Ncv_settlement,jciclaim_nomination.Quality_settlement, jciclaim_nomination.Settlement_Amt, jciclaim_nomination.Supporting_doc AS ytest,jciclaim_nomination.DateofInspection FROM jciclaim_report_mill  INNER JOIN jciclaim_nomination  ON jciclaim_report_mill.Settlement_id = jciclaim_nomination.Settlement_id WHERE jciclaim_report_mill.Settlement_id = '"+settlementId+"'";
		List<Object[]> list = currentSession().createSQLQuery(liString).list();
		return list;
	}
	@Override
	public void acceptClaim(Integer id, String username) {
		// TODO Auto-generated method stub
		try {
		String liString = "UPDATE jciclaim_report_mill SET Dispute_flag = 2, FA_Official = '" + username + "', Inspection_date = GETDATE() WHERE Settlement_id = '" + id + "'";
		this.sessionFactory.getCurrentSession().createSQLQuery(liString).executeUpdate();
		}catch (Exception e) {
			// TODO: handle exception
		}
	}
	@Override
	public void rejectClaim(Integer id, String username) {
		// TODO Auto-generated method stub
		String liString = "UPDATE jciclaim_report_mill SET Dispute_flag = 1, FA_Official = '" + username + "', Inspection_date = GETDATE() WHERE Settlement_id = '" + id + "'";

		currentSession().createSQLQuery(liString).executeUpdate();
		return;
	}

}
