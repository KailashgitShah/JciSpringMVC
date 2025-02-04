package com.jci.dao.impl_phase2;

import org.hibernate.SessionFactory;
import javax.servlet.http.HttpSession;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.mail.Session;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.jci.dao_phase2.FinancialConcurenceDao;
import com.jci.model.EntryPaymentDetailsModel;
import com.jci.model.FinancialConcurenceDto;
import com.jci.model.FinancialConcurenceModel;

@Repository
@Transactional
public class FinancialConcurenceDaoImpl implements FinancialConcurenceDao {
	@Autowired
	SessionFactory sessionFactory;

	protected org.hibernate.Session currentSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public void create(FinancialConcurenceModel financialConcurenceModel) {

		currentSession().saveOrUpdate(financialConcurenceModel);
	}

	@Override
	public List<FinancialConcurenceModel> getAllPaymentInstruments() {
//	        Criteria criteria = currentSession().createCriteria(FinancialConcurenceModel.class);
//	        return criteria.list();
		String sql = " SELECT * FROM jcifinancial_concurrence ORDER BY Fc_id DESC";
		List<FinancialConcurenceModel> fCList = sessionFactory.getCurrentSession().createSQLQuery(sql)
				.addEntity(FinancialConcurenceModel.class).list();
		return fCList;
	}

	public FinancialConcurenceModel find(int id) {
		return (FinancialConcurenceModel) currentSession().get(FinancialConcurenceModel.class, id);
	}

	@Override
	public void remark(String remark, String con_No, int paymentId) {
		String hql = "UPDATE  jcifinancial_concurrence set Remarks =  '" + remark + "'  where Contractno = '" + con_No
				+ "' ";
		String hql1 = "UPDATE jcipayment_arrangement set  Remarks='" + remark + "'  where Contract_No = '" + con_No
				+ "' and  Payment_id = '" + paymentId + "' ";
		this.sessionFactory.getCurrentSession().createSQLQuery(hql1).executeUpdate();
		this.sessionFactory.getCurrentSession().createSQLQuery(hql).executeUpdate();
	}

	@Override
	public int calculateCharges(int Payment_id, String cont_no) {
		System.err.println(cont_no);
		int charges = 0;
		List<Object[]> result = new ArrayList<>();
//			String sql = "select b.Created_date, c.QtyAllowed, d.Contract_date from jcipayment_arrangement\r\n"
//					+ "		    	 b left join jcifinancial_concurrence c on c.Contractno = b.Contract_No left join\r\n"
//					+ "		    	 jcicontract d on d.Contract_no = b.Contract_No where c.Contractno ='" + cont_no + "'";
//		
//			
		String sql = " select b.Instrument_Date,d.Payment_duedate from jcipayment_arrangement\r\n"
				+ "		 b left join jcicontract d on d.Contract_no = b.Contract_No  where b.Contract_No ='" + cont_no
				+ "'";

		try {
			org.hibernate.classic.Session session = sessionFactory.getCurrentSession();
			SQLQuery query = session.createSQLQuery(sql);
			result = query.list();
//			    org.hibernate.classic.Session session = sessionFactory.getCurrentSession();
//		    	Transaction tx = session.beginTransaction();
//		    	SQLQuery query = session.createSQLQuery(sql);
//		    	result = query.list();

			if (result.size() >= 1) {
				for (Object[] row : result) {

////		            Date condate = (Date) row[0];
////		            Object qtyAllowedObj = row[1];
////		            Date createddate = (Date) row[2];
//		            
//		            Timestamp contdateTimestamp = (Timestamp) row[0];
//		            Object qtyAllowedObj = row[1];
//		            String createddateString = row[2].toString(); 
//                    Date condate = new Date(contdateTimestamp.getTime());
//                    SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
//		            Date createddate = dateFormat.parse(createddateString);
//		            long diffInMilliseconds = Math.abs(condate.getTime() - createddate.getTime());
//		            long daysBetween = TimeUnit.DAYS.convert(diffInMilliseconds, TimeUnit.MILLISECONDS);
//		           // charges = qtyAllowed * daysBetween * 70;
//		             charges =  daysBetween ;

					Timestamp contdateTimestamp = (Timestamp) row[0];
					Date condate = new Date(contdateTimestamp.getTime());
					String createdDateString = (String) row[1];
					SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
					Date createddate = dateFormat.parse(createdDateString);
					// Date createddate = (Date) row[1];

					//long diffInMilliseconds = Math.abs(condate.getTime() - createddate.getTime());
					
					long diffInMilliseconds = condate.getTime() - createddate.getTime();

					System.err.println("diffInMilliseconds: " + diffInMilliseconds);
					if(diffInMilliseconds<0) {
						diffInMilliseconds=0;
					}
					
					int daysBetween = (int) TimeUnit.DAYS.convert(diffInMilliseconds, TimeUnit.MILLISECONDS);

					charges = daysBetween;
					System.err.println("daysBetween: " + daysBetween);
					System.out.println("charges: " + charges);

				}
				return charges;
			}

		} catch (Exception e) {
			e.printStackTrace();// Handle exceptions

		}
		return charges;

	}

	@Override
	public String ContractedQty(String cont_no) {
		String hql1 = " Select Mill_qty from jcicontract where Contract_no ='" + cont_no + "' ";
		double qty = (Double) this.sessionFactory.getCurrentSession().createSQLQuery(hql1).uniqueResult();
		return qty + "";

	}

	@Override
	public int paymentid(String cont_no) {
		String hql1 = " Select Payment_id from jcipayment_arrangement  where Contract_No = '" + cont_no + "' ";
		this.sessionFactory.getCurrentSession().createSQLQuery(hql1).executeUpdate();

		int payid = Integer.parseInt("hql1");
		return payid;

	}

	@Override
	public List<Object> dataofdates(String con_no, int Payment_id) {
		// String hql1 = " Select
		// PaymentDue_date,Payment_type,Instrument_Date,Instrument_value,Contract_value
		// from jcipayment_arrangement where Contract_no ='" + con_no + "' and
		// Payment_id ='" + Payment_id + "'";

		String hql1 = "SELECT PaymentDue_date, MAX(Instrument_Date) AS Latest_Instrument_Date, SUM(TRY_CAST(Instrument_value AS DECIMAL(18,3))) AS Total_Instrument_Value,Contract_value FROM jcipayment_arrangement"
				+ " WHERE Contract_no =  '" + con_no + "' GROUP BY  PaymentDue_date,Contract_value";

		return (List<Object>) this.sessionFactory.getCurrentSession().createSQLQuery(hql1).list();

	}

	@Override
//	public String fcref_nocheck(String fcref_no) {
		public String fcref_nocheck() {
//		String sql = "SELECT  count(*) FROM jcifinancial_concurrence WHERE FC_Ref_No = '" + fcref_no + "' ";
//		int total = (Integer) this.sessionFactory.getCurrentSession().createSQLQuery(sql).uniqueResult();
//
//		if (total > 0)
//			return "1";
//		else
//			return "0";
		
		String sql = "SELECT \r\n"
				+ "    CASE \r\n"
				+ "        WHEN LEN(CAST(COALESCE(MAX(CAST(FC_Ref_No AS INT)), 0) + 1 AS VARCHAR)) > 6 \r\n"
				+ "        THEN CAST(COALESCE(MAX(CAST(FC_Ref_No AS INT)), 0) + 1 AS VARCHAR)\r\n"
				+ "        ELSE RIGHT('000000' + CAST(COALESCE(MAX(CAST(FC_Ref_No AS INT)), 0) + 1 AS VARCHAR), 6)\r\n"
				+ "    END AS Next_FC_Ref_No\r\n"
				+ "FROM jcifinancial_concurrence;";
		 String fcref = (String) this.sessionFactory.getCurrentSession().createSQLQuery(sql).uniqueResult();

		
		 return fcref;

	}

	@Override
	public List<Object> RemainingQty(String cont_no) {
		String hql1 = " SELECT \r\n"
				+ "    COALESCE(TRY_CAST(b.Contracted_Qty AS DECIMAL(10, 2)), 0) AS Contracted_Qty,  \r\n"
				+ "    COALESCE(TRY_CAST(b.QtyAllowed AS DECIMAL(10, 2)), 0) AS QtyAllowed,\r\n"
				+ "    a.Contract_No,\r\n"
				+ "    (COALESCE(TRY_CAST(b.Contracted_Qty AS DECIMAL(10, 2)), 0) - COALESCE(TRY_CAST(b.QtyAllowed AS DECIMAL(10, 2)), 0)) AS remainingAmount\r\n"
				+ "FROM  jcipayment_arrangement AS a \r\n"
				+ "LEFT JOIN  jcifinancial_concurrence AS b  \r\n"
				+ "ON  b.Contractno = a.Contract_No\r\n"
				+ "WHERE a.Contract_No='" + cont_no + "'";

		return (List<Object>) this.sessionFactory.getCurrentSession().createSQLQuery(hql1).list();

	}

	@Override
	public List<Object[]> DetailsForReport(String cont_no) {
		  String sql =" SELECT \r\n"
		  		+ "   b.Contract_No,\r\n"
		  		+ "  \r\n"
		  		+ "    b.Instrument_No,\r\n"
		  		+ "    CONVERT(VARCHAR, b.Instrument_Date, 105) AS Instrument_Date,\r\n"
		  		+ "    b.ifsc,\r\n"
		  		+ "    CONVERT(VARCHAR, b.Last_shipment_date, 105) AS Last_shipment_date,\r\n"
		  		+ "    CONVERT(VARCHAR, b.Expiry_date, 105) AS Expiry_date,\r\n"
		  		+ "    b.Auto_revolving_amount,\r\n"
		  		+ "    b.millcode,\r\n"
		  		+ "    b.Instrument_value,\r\n"
		  		+ "     CONVERT(VARCHAR, c.Contract_date, 105) AS Contract_date\r\n"
		  		+ "FROM \r\n"
		  		+ "  \r\n"
		  		+ "    jcipayment_arrangement AS b   LEFT JOIN jcicontract as c on c.Contract_no=b.Contract_No\r\n"
		  		
		  		+ "WHERE \r\n"
		  		+ "    b.Contract_No ='" +cont_no+"' "; 
			    
					 		
					
					 List<Object[]>resultList1= (List<Object[]>)this.sessionFactory.getCurrentSession().createSQLQuery(sql).list();
					 return resultList1;
	}

	@Override
	public List<Object[]> LabelnameAndDelivery(String cont_no) {
		String sql ="select a.Grade_composition,a.Delivery_type,a.Contract_no from jcicontract as a	 WHERE a.Contract_no= '" +cont_no+"'"; 
			     List<Object[]>resultList1= (List<Object[]>)this.sessionFactory.getCurrentSession().createSQLQuery(sql).list();
					 return resultList1;
	}

	@Override
	public List<Object[]> gradecompositionfordetails(String cont_no) {
	
		String sql ="select Jute_combination,Proposed_composition from jcigrade_composition where Label_name= '" +cont_no+"'"; 
	     List<Object[]>resultList1= (List<Object[]>)this.sessionFactory.getCurrentSession().createSQLQuery(sql).list();
			 return resultList1;
	}

	@Override
	public void updateFCDoc(String fileName, String fC_Ref_No) {
		// TODO Auto-generated method stub
		String sqlString ="Update jcifinancial_concurrence set fcdocumentDownload ='"+fileName+"' where FC_Ref_No='"+fC_Ref_No+"';";
		this.sessionFactory.getCurrentSession().createSQLQuery(sqlString).executeUpdate();
	}

}