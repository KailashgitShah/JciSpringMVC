package com.jci.dao.impl_phase2;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.jci.dao_phase2.PCSOReqLetterDao;
import com.jci.model.PCSORequestLetter;

@Transactional
@Repository
public class PCSOReqLetterDaoImpl implements PCSOReqLetterDao {

	@Autowired
	SessionFactory sessionFactory;

	protected Session currentSession() {
		return sessionFactory.getCurrentSession();
	}

	public void create(PCSORequestLetter requestLetter) {
		currentSession().save(requestLetter);
	}

	public List<PCSORequestLetter> getAllRequestLetters() {
		return this.sessionFactory.getCurrentSession().createCriteria(PCSORequestLetter.class)
				.addOrder(Order.desc("creation_date")).list();

	}

	public PCSORequestLetter getAllRequestLetter(int reqId) {
		return new PCSORequestLetter();
	}

	public void delete(int id) {
		PCSORequestLetter request = (PCSORequestLetter) currentSession().load(PCSORequestLetter.class, id);
		if (request != null) {
			currentSession().delete(request);
		}
	}

	@Override
	public List<PCSORequestLetter> getTopThreeRecords(String cropString) {
		String sqlString = "select Top 5 * from jcipcso_gen ORDER by convert(datetime,ReqGenDate,103) desc";
		
//		String sqlString = "select Top 5 * from jcipcso_gen where crop_year='" + cropString
//				+ "' ORDER by ReqGenDate desc";
		List<Object[]> list = currentSession().createSQLQuery(sqlString).list();

		List<PCSORequestLetter> reqList = new ArrayList<>();

		for (Object[] reqObjects : list) {
			PCSORequestLetter requestLetter = new PCSORequestLetter();
			requestLetter.setReference_no((String) reqObjects[5]);
			requestLetter.setCropYear((String) reqObjects[2]);
			requestLetter.setReqGenDate((String) reqObjects[6]);
			requestLetter.setSys_avail_qty((Double) reqObjects[8]);
			requestLetter.setReq_qty((Double) reqObjects[7]);
			requestLetter.setCreation_date((Date) reqObjects[1]);

			reqList.add(requestLetter);
		}

		return reqList;
	}

	@Override
	public void setEmailStatus(int id, int status) {
		
		SimpleDateFormat formater = new SimpleDateFormat("dd-MM-yyyy");
		String currDate = formater.format(new Date());
		String sqlString = "update jcipcso_gen set emailStatus = " + status + ", emailSentOn = '"+currDate+"' where pcso_gen_id = " + id;
		currentSession().createSQLQuery(sqlString).executeUpdate();
		
	}

	@Override
	public double getTotalContractedQty(String cropYear) {
		String sqlString = "SELECT COALESCE(SUM(req_qty), 0) FROM jcipcso_gen WHERE emailStatus = 1";
		Object result = currentSession().createSQLQuery(sqlString).uniqueResult();

		// Check for null and return a default value if needed
		if (result != null) {
			return (Double) result;
		} else {
			// You can return 0 or any other default value as per your requirement
			return 0.0;
		}

	}

}
