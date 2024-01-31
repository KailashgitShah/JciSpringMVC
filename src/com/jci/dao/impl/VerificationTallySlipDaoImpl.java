package com.jci.dao.impl;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.google.gson.Gson;
import com.jci.dao.VerificationTallySlipDao;
import com.jci.model.FarmerRegistrationModel;
import com.jci.model.ImageVerificationModel;
import com.jci.model.PaymentprocesstellyslipModel;
import com.jci.model.UserRegistrationModel;
import com.jci.model.VerifyTallySlip;

@Transactional
@Repository
public class VerificationTallySlipDaoImpl implements VerificationTallySlipDao {

	@Autowired
	private HttpServletRequest request;

	@Autowired
	SessionFactory sessionFactory;

	protected Session currentSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public void create(VerifyTallySlip verifyTallySlip) {
		currentSession().save(verifyTallySlip);
	}

	@Override
	public void update(VerifyTallySlip verifyTallySlip) {
		currentSession().update(verifyTallySlip);
	}

	@Override
	public VerifyTallySlip edit(int id) {
		return find(id);
	}

	@Override
	public void delete(int id) {
		FarmerRegistrationModel farmerRegistrationModel = new FarmerRegistrationModel();
		String hql = "Delete from dbo.verificationtallyslip where tallyslipno= '" + id + "' ";
		this.sessionFactory.getCurrentSession().createSQLQuery(hql).executeUpdate();
	}

	@Override
	public VerifyTallySlip find(int id) {
		return (VerifyTallySlip) currentSession().get(VerifyTallySlip.class, id);
	}

	/*
	 * @Override public VerifyTallySlip findByTally(String tallyslipno) { return
	 * (VerifyTallySlip) currentSession().get(VerifyTallySlip.class, tallyslipno); }
	 */

	@Override
	public List<VerifyTallySlip> getAll(String status, String region, String role_type) {
		List<VerifyTallySlip> r = new ArrayList<>();
		List<Object[]> result = new ArrayList<>();

		/*
		 * String querystr =
		 * "select a.tallyid,a.tallyNo, a.farmerregno, a.puchasedate, a.netquantity, a.amountpayable, a.facheck_flag, b.basis, c.centername, "
		 * +
		 * "d.F_NAME from verificationtallyslip a left join jciprocurement b on b.tallyslipno = a.tallyNo left join "
		 * +
		 * "jcipurchasecenter c on c.CENTER_CODE = a.placeOfPurchase left join jcirmt d on d.F_REG_NO = a.farmerregno"
		 * + " where a.status ='"+status+"' and a.payment_status='0' and a.region_id ="
		 * +region;
		 */
		try {
			String querystr = "";
			if (role_type.equalsIgnoreCase("RO")) {
				querystr = "select a.tallyid,a.tallyNo, a.farmerregno, a.puchasedate, a.netquantity, a.amountpayable, a.facheck_flag, b.basis, c.centername, "
						+ "d.F_NAME from verificationtallyslip a left join jciprocurement b on b.tallyslipno = a.tallyNo left join "
						+ "jcipurchasecenter c on c.CENTER_CODE = a.placeOfPurchase left join jcirmt d on d.F_REG_NO = a.farmerregno"
						+ " where a.status ='" + status + "' and a.payment_status='0' and a.region_id =" + region;
			} else if (role_type.equalsIgnoreCase("HO")) {
				querystr = "select a.tallyid,a.tallyNo, a.farmerregno, a.puchasedate, a.netquantity, a.amountpayable, a.facheck_flag, b.basis, c.centername, "
						+ "d.F_NAME from verificationtallyslip a left join jciprocurement b on b.tallyslipno = a.tallyNo left join "
						+ "jcipurchasecenter c on c.CENTER_CODE = a.placeOfPurchase left join jcirmt d on d.F_REG_NO = a.farmerregno"
						+ " where a.status ='" + status + "' and a.payment_status='0'";
			}

			Session session = sessionFactory.getCurrentSession();
			Transaction tx = session.beginTransaction();
			SQLQuery query = session.createSQLQuery(querystr);
			result = query.list();
			if (result.size() >= 1) {
				// Object[] row = result.get(0);
				for (Object[] row : result) {
					VerifyTallySlip verifyTallySlip = new VerifyTallySlip();
					String dateString = (String) row[3];

					verifyTallySlip.setTallyid(((int) row[0]));
					verifyTallySlip.setDop(dateString);
					verifyTallySlip.setNetquantity(((BigDecimal) row[4]).doubleValue());
					verifyTallySlip.setAmountpayable(((BigDecimal) row[5]).doubleValue());
					verifyTallySlip.setFarmerRegNo((String) row[2]);
					verifyTallySlip.setTallyNo((String) row[1]);
					verifyTallySlip.setFacheck_flag((String) row[6]);
					verifyTallySlip.setBasis((String) row[7]);
					verifyTallySlip.setCentername((String) row[8]);
					verifyTallySlip.setFarmer_name((String) row[9]);
					r.add(verifyTallySlip);
				}

				return r;
			} else {
				return null;
			}
		} catch (Exception e) {
		//	System.out.println(e.getLocalizedMessage());
			return null;
		}
	}

	@Override
	public boolean submitform(VerifyTallySlip verifyTallySlip) {
		this.sessionFactory.getCurrentSession().save(verifyTallySlip);
		return false;
	}

	@Override
	public String GettransectionDetails(String tallyNo, String region) {

		 System.err.println("***********"+ tallyNo);
		List<VerifyTallySlip> r = new ArrayList<>();
		List<Object[]> result = new ArrayList<>();
		String querystr = "Select  datepurchase, rateslipno, binno, netquantity, grasatrate, amountpayable, jutevariety, grossquantity, farmerregno, slip_image, tallyslipno,placeofpurchase, pur.centername  from jciprocurement  jci left join jcipurchasecenter pur on jci.placeofpurchase = pur.CENTER_CODE where tallyslipno='"
				+ tallyNo + "' and regionId = '" + region + "' and is_varified = 0 and jci.status = 'ROV'";

		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		SQLQuery query = session.createSQLQuery(querystr);
		result = query.list();
		if (result.size() >= 1) {
			Object[] row = result.get(0);

			VerifyTallySlip verifyTallySlip = new VerifyTallySlip();
			String date = (String) row[0];
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			/*
			 * String dateString = format.format(date); System.out.println(dateString);
			 */
			/*
			 * try { date = format.parse ( dateString ); } catch (ParseException e) { //
			 * TODO Auto-generated catch block e.printStackTrace(); }
			 */
			verifyTallySlip.setDop(date);
			verifyTallySlip.setRateslipno((int) row[1]);
			verifyTallySlip.setBinno((int) row[2]);
			verifyTallySlip.setNetquantity(((BigDecimal) row[3]).doubleValue());
			verifyTallySlip.setGarsatrate(((BigDecimal) row[4]).doubleValue());
			verifyTallySlip.setAmountpayable(((BigDecimal) row[5]).doubleValue());
			verifyTallySlip.setJutevariety((String) row[6]);
			verifyTallySlip.setGrossqty(((BigDecimal) row[7]).doubleValue());
			verifyTallySlip.setFarmerRegNo((String) row[8]);
			verifyTallySlip.setTallySlipImg((String) row[9]);
			verifyTallySlip.setTallyNo((String) row[10]);
			verifyTallySlip.setPlaceOfPurchase((String) row[11]);
			verifyTallySlip.setPopname((String) row[12]);
			 System.err.println("############"+ verifyTallySlip);

			// System.out.println("================>>>>>>>>>>>result "+result.toString());
			// r.add(verifyTallySlip);
			Gson gson = new Gson();
			gson.toJson(verifyTallySlip);
			// System.out.println("================>>>>>>>>>>>result
			// "+gson.toJson(verifyTallySlip));
			return gson.toJson(verifyTallySlip);
		} else {
			return null;
		}

	}

	@Override
	public boolean updatebyTally(String statuss, int verified, String tallyno) {
		Session session = sessionFactory.getCurrentSession();
		boolean returnStatus = false;
		try {
			Query q = null;
			if(statuss.equals("DPCW"))
			{
				q = session.createQuery("delete VerifyTallySlip where tallyNo='"+ tallyno +"'");
			}
			else if(statuss.equals("FA"))
			{
			    q = session.createQuery("update VerifyTallySlip set status ='"+statuss+"', is_varified ="+verified+" where tallyNo='"+tallyno+"'");
			}
			
			int status = q.executeUpdate();
			if (status >= 1) {
				returnStatus = true;
				return returnStatus;
			} else {
				returnStatus = false;
				return returnStatus;
			}
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
		}
		return returnStatus;
	}

	@Override
	public PaymentprocesstellyslipModel getdataforExcelSheet(String tno) {
		// TODO Auto-generated method stub
		tno = tno.replace("\"", "");
		System.out.println("verification dao tno = " + tno);
		List<Object[]> list = new ArrayList();
		PaymentprocesstellyslipModel paymentdetails = new PaymentprocesstellyslipModel();
		try {

			String querystr = "select v.puchasedate,v.amountpayable,j.F_BANK_IFSC,j.F_AC_NO,j.bank_ac_type,j.F_NAME,j.F_BANK_BRANCH,j.F_BANK_NAME,"
					+ " p.centername, v.farmerregno, ro.bankACno from verificationtallyslip v left join jcirmt j on j.F_REG_NO = v.farmerregno left join "
					+ "jcipurchasecenter p on p.CENTER_CODE = v.placeOfPurchase left join jcirodetails ro on ro.rocode = v.region_id where v.tallyNo ="
					+ tno;

			Session session = sessionFactory.getCurrentSession();
			Transaction tx = session.beginTransaction();
			SQLQuery query = session.createSQLQuery(querystr);
			list = query.list();
			for (Object[] row : list) {

				paymentdetails.setPurchase_date((String) row[0]);
				paymentdetails.setAmount(((BigDecimal) row[1]).doubleValue());
				paymentdetails.setBeneficiary_IFSC_code((String) row[2]);
				paymentdetails.setBeneficiaryAC_No((String) row[3]);
				paymentdetails.setAC_type((String) row[4]);
				paymentdetails.setBeneficiary_name((String) row[5]);
				paymentdetails.setBeneficiary_branch((String) row[6]);
				paymentdetails.setBeneficiary_bank((String) row[7]);
				paymentdetails.setDpc_name((String) row[8]);
				paymentdetails.setFarmerreg_no((String) row[9]);
				paymentdetails.setDebitAC_no((String) row[10]);
				paymentdetails.setSender("JCI");
				//paymentdetails.setDate(date);
			}

		}

		catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
		}
		return paymentdetails;
	}

	@Override
	public void savepaymentdata(PaymentprocesstellyslipModel createpayment) {
		System.out.println("createpayment = " + createpayment.toString());
		// TODO Auto-generated method stub
		try {
			currentSession().save(createpayment);
		} catch (Exception e) {
			System.out.println("savepayment method = " + e.getLocalizedMessage());
		}

	}

	@Override
	public void updatefastatus(String tno) {
		String status = "checked";
		try {
			String hql = "update verificationtallyslip set facheck_flag = '" + status + "' where tallyNo=" + tno;
			this.sessionFactory.getCurrentSession().createSQLQuery(hql).executeUpdate();
			System.out.println("success");
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
		}
	}

	@Override
	public void statusrmzm() {
		// TODO Auto-generated method stub
		String Region_id = (String) request.getSession().getAttribute("region");
		String useremail = (String) request.getSession().getAttribute("usrname");

		String status = "RMZM";
		try {
			String hql1 = "update jciprocurement set status = 'RMZM' where status='FA' and regionId ="+Region_id;
			this.sessionFactory.getCurrentSession().createSQLQuery(hql1).executeUpdate();
			
			String hql = "update verificationtallyslip set status = '" + status + "', fa_approver_email = '" + useremail
					+ "' where status='FA' and region_id ="+Region_id;
			this.sessionFactory.getCurrentSession().createSQLQuery(hql).executeUpdate();
			System.out.println("success");
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
		}
	}

	@Override
	public List<ImageVerificationModel> getImages(String tallyNo) {
		// TODO Auto-generated method stub
		List<ImageVerificationModel> result = new ArrayList<>();

		try {

			List<Object[]> list = new ArrayList();
			String querystr = "select a.F_DOC_Mandate, a.F_BANK_DOC, a.F_ID_PROF, a.F_REG_FORM, b.slip_image, b.tallyslipno FROM jcirmt a left join jciprocurement b on b.farmerregno = a.F_REG_NO where b.tallyslipno ='"
					+ tallyNo + "'";
			Session session = sessionFactory.getCurrentSession();
			Transaction tx = session.beginTransaction();
			SQLQuery query = session.createSQLQuery(querystr);
			list = query.list();
			if (list.isEmpty()) {

			} else {
				for (Object[] rows : list) {
					System.out.println("----------" + (String) rows[0]);
					ImageVerificationModel images = new ImageVerificationModel();
					images.setF_DOC_Mandate((String) rows[0]);
					images.setF_BANK_DOC((String) rows[1]);
					images.setF_ID_PROF((String) rows[2]);
					images.setF_REG_FORM((String) rows[3]);
					images.setSlip_image((String) rows[4]);
					images.setGettally((String) rows[5]);
					result.add(images);
				}
			}

		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
		}
		return result;
	}

	@Override
	public List<VerifyTallySlip> getAllforRM(String status, String region_zone) {
		// TODO Auto-generated method stub
		List<VerifyTallySlip> r = new ArrayList<>();
		List<Object[]> result = new ArrayList<>();
		//HttpSession session1 = request.getSession(false);
		String querystr = "select a.tallyNo, a.farmerregno, a.puchasedate, a.netquantity, a.amountpayable, a.facheck_flag, b.basis, "
				+ "c.centername, d.F_NAME from verificationtallyslip a left join jciprocurement b on b.tallyslipno = a.tallyNo "
				+ "left join jcipurchasecenter c on c.CENTER_CODE = a.placeOfPurchase left join jcirmt d on d.F_REG_NO = a.farmerregno "
				+ "where a.status ='" + status
				+ "' and a.amountpayable <= 500000 and payment_status = 0 and a.region_id ='" + region_zone + "'";
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		SQLQuery query = session.createSQLQuery(querystr);
		result = query.list();
		if (result.size() >= 1) {
			for (Object[] row : result) {
				VerifyTallySlip verifyTallySlip = new VerifyTallySlip();
				// Date date = (Date)row[2];
				// SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
				String dateString = (String) row[2];
				verifyTallySlip.setDop(dateString);
				verifyTallySlip.setNetquantity(((BigDecimal) row[3]).doubleValue());
				verifyTallySlip.setAmountpayable(((BigDecimal) row[4]).doubleValue());
				verifyTallySlip.setFarmerRegNo((String) row[1]);
				verifyTallySlip.setTallyNo((String) row[0]);
				verifyTallySlip.setFacheck_flag((String) row[5]);
				verifyTallySlip.setBasis((String) row[6]);
				verifyTallySlip.setCentername((String) row[7]);
				verifyTallySlip.setFarmer_name((String) row[8]);
				r.add(verifyTallySlip);
			}
			return r;
		} else {
			return null;
		}
	}

	@Override
	public String getEmailby_tally(String tnoemail) {
		// TODO Auto-generated method stub
		String querystr = "select fa_approver_email	from verificationtallyslip where tallyNo ='" + tnoemail + "'";
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		SQLQuery query = session.createSQLQuery(querystr);
		String fa_approver_email = query.list().get(0).toString();
		System.out.println(query.list());
		return fa_approver_email;
	}

	@Override
	public List<VerifyTallySlip> getAllforZM(String status, String region_zone) {
		// TODO Auto-generated method stub
		List<VerifyTallySlip> r = new ArrayList<>();
		List<Object[]> result = new ArrayList<>();
		HttpSession session1 = request.getSession(false);
		String querystr = "select a.tallyNo, a.farmerregno, a.puchasedate, a.netquantity, a.amountpayable, a.facheck_flag, b.basis, c.centername, d.F_NAME from verificationtallyslip a left join jciprocurement b on b.tallyslipno = a.tallyNo left join jcipurchasecenter c on c.CENTER_CODE = a.placeOfPurchase left join jcirmt d on d.F_REG_NO = a.farmerregno where a.status ='"
				+ status + "' and a.amountpayable > 500000 and payment_status = 0 and a.zone_id ='" + region_zone + "'";
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		SQLQuery query = session.createSQLQuery(querystr);
		result = query.list();
		if (result.size() >= 1) {
			for (Object[] row : result) {
				VerifyTallySlip verifyTallySlip = new VerifyTallySlip();
				// Date date = (Date)row[2];
				// SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
				String dateString = (String) row[2];
				verifyTallySlip.setDop(dateString);
				verifyTallySlip.setNetquantity(((BigDecimal) row[3]).doubleValue());
				verifyTallySlip.setAmountpayable(((BigDecimal) row[4]).doubleValue());
				verifyTallySlip.setFarmerRegNo((String) row[1]);
				verifyTallySlip.setTallyNo((String) row[0]);
				verifyTallySlip.setFacheck_flag((String) row[5]);
				verifyTallySlip.setBasis((String) row[6]);
				verifyTallySlip.setCentername((String) row[7]);
				verifyTallySlip.setFarmer_name((String) row[8]);
				r.add(verifyTallySlip);
			}
			return r;
		} else {
			return null;
		}
	}

	@Override
	public void updateexceldata(String jciref, String utrno, String date) {
		// TODO Auto-generated method stub
		try {
			
			String hql1 = "update jcitallyslippayment set UTR_no = '" + utrno + "', date = '"+date+"' where JCI_Ref ='"+ jciref+"'";
			this.sessionFactory.getCurrentSession().createSQLQuery(hql1).executeUpdate();
			
		
			
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
		}
	}

	@Override
	public void updatestatusPD(String tallyno) {
		// TODO Auto-generated method stub
	try {
		
		String hql1 = "update jciprocurement set status = 'PD' where tallyslipno ='"+tallyno+"'";
		this.sessionFactory.getCurrentSession().createSQLQuery(hql1).executeUpdate();
			
		String hql2 = "update verificationtallyslip set status = 'PD' where tallyNo ='"+tallyno+"'";
		this.sessionFactory.getCurrentSession().createSQLQuery(hql2).executeUpdate();		
		
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
		}
	}

	@Override
	public void setholdstatus(String tno) {
		// TODO Auto-generated method stub
		try {
			String hql = "update jciprocurement set status = 'hold' where tallyslipno ='"+tno+"'";
			this.sessionFactory.getCurrentSession().createSQLQuery(hql).executeUpdate();
			
			String hql1 = "update verificationtallyslip set status = 'hold' where tallyNo ='"+tno+"'";
			this.sessionFactory.getCurrentSession().createSQLQuery(hql1).executeUpdate();
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
		}
	}

	@Override
	public List<VerifyTallySlip> getAllHold(String region, String role_type) {
		// TODO Auto-generated method stub
		List<VerifyTallySlip> r = new ArrayList<>();
		List<Object[]> result = new ArrayList<>();
		try {
			String status ="hold";
			String querystr = "";
			if (role_type.equalsIgnoreCase("RO")) {
				querystr = "select a.tallyid,a.tallyNo, a.farmerregno, a.puchasedate, a.netquantity, a.amountpayable, a.facheck_flag, b.basis, c.centername, "
						+ "d.F_NAME from verificationtallyslip a left join jciprocurement b on b.tallyslipno = a.tallyNo left join "
						+ "jcipurchasecenter c on c.CENTER_CODE = a.placeOfPurchase left join jcirmt d on d.F_REG_NO = a.farmerregno"
						+ " where a.status ='" + status + "' and a.payment_status='0' and a.region_id =" + region;
			} else if (role_type.equalsIgnoreCase("HO")) {
				querystr = "select a.tallyid,a.tallyNo, a.farmerregno, a.puchasedate, a.netquantity, a.amountpayable, a.facheck_flag, b.basis, c.centername, "
						+ "d.F_NAME from verificationtallyslip a left join jciprocurement b on b.tallyslipno = a.tallyNo left join "
						+ "jcipurchasecenter c on c.CENTER_CODE = a.placeOfPurchase left join jcirmt d on d.F_REG_NO = a.farmerregno"
						+ " where a.status ='" + status + "' and a.payment_status='0'";
			}

			Session session = sessionFactory.getCurrentSession();
			Transaction tx = session.beginTransaction();
			SQLQuery query = session.createSQLQuery(querystr);
			result = query.list();
			if (result.size() >= 1) {
				// Object[] row = result.get(0);
				for (Object[] row : result) {
					VerifyTallySlip verifyTallySlip = new VerifyTallySlip();
					String dateString = (String) row[3];

					verifyTallySlip.setTallyid(((int) row[0]));
					verifyTallySlip.setDop(dateString);
					verifyTallySlip.setNetquantity(((BigDecimal) row[4]).doubleValue());
					verifyTallySlip.setAmountpayable(((BigDecimal) row[5]).doubleValue());
					verifyTallySlip.setFarmerRegNo((String) row[2]);
					verifyTallySlip.setTallyNo((String) row[1]);
					verifyTallySlip.setFacheck_flag((String) row[6]);
					verifyTallySlip.setBasis((String) row[7]);
					verifyTallySlip.setCentername((String) row[8]);
					verifyTallySlip.setFarmer_name((String) row[9]);
					r.add(verifyTallySlip);
				}

				return r;
			} else {
				return null;
			}
		} catch (Exception e) {
		//	System.out.println(e.getLocalizedMessage());
			return null;
		}
	}

	@Override
	public void updatestatustoPP(String tallyslipno) {
		try {
			String hql = "update verificationtallyslip set payment_status = 1, status ='PP' where tallyNo in (" + tallyslipno+")";
			System.err.println("hql = "+hql);
			this.sessionFactory.getCurrentSession().createSQLQuery(hql).executeUpdate();
			
			String hql1 = "update jciprocurement set status = 'PP' where tallyslipno in (" + tallyslipno+")";
			System.err.println("hql1 = "+hql1);
			this.sessionFactory.getCurrentSession().createSQLQuery(hql1).executeUpdate();
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
		}
	}

	@Override
	public void updatestatustoRMZM(String tallyno) {
		// TODO Auto-generated method stub
		try {
			String hql = "update verificationtallyslip set payment_status = 0, status ='RMZM' where tallyNo in (" + tallyno+")";
			System.err.println("hql = "+hql);
			this.sessionFactory.getCurrentSession().createSQLQuery(hql).executeUpdate();
			
			String hql1 = "update jciprocurement set status = 'RMZM' where tallyslipno in (" + tallyno+")";
			System.err.println("hql1 = "+hql1);
			this.sessionFactory.getCurrentSession().createSQLQuery(hql1).executeUpdate();
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
		}
		
	}

}
