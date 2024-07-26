package com.jci.dao.impl;

import static org.hamcrest.CoreMatchers.nullValue;

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
import com.jci.model.PurchaseRegisterDTO;
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
				
				querystr = "select distinct a.tallyid,a.tallyNo,a.farmerregno,a.puchasedate,a.netquantity,a.amountpayable,a.facheck_flag,b.basis,c.centername,d.F_NAME,a.placeOfPurchase from verificationtallyslip a left join jciprocurement b on b.tallyslipno = a.tallyNo and b.rateslipno=a.rateslipno and b.datepurchase=a.puchasedate left join jcipurchasecenter c on c.CENTER_CODE = a.placeOfPurchase left join jcirmt d on d.F_REG_NO = a.farmerregno where a.status ='" + status + "' and a.payment_status='0' and a.region_id = " + region; 
						
				//querystr = "select a.tallyid,a.tallyNo, a.farmerregno, a.puchasedate, a.netquantity, a.amountpayable, a.facheck_flag, b.basis, c.centername, "
				//		+ "d.F_NAME from verificationtallyslip a left join jciprocurement b on b.tallyslipno = a.tallyNo left join "
				//		+ "jcipurchasecenter c on c.CENTER_CODE = a.placeOfPurchase left join jcirmt d on d.F_REG_NO = a.farmerregno"
				//		+ " where a.status ='" + status + "' and a.payment_status='0' and a.region_id =" + region;
			} else if (role_type.equalsIgnoreCase("HO")) {
				querystr = "select distinct a.tallyid,a.tallyNo,a.farmerregno,a.puchasedate,a.netquantity,a.amountpayable,a.facheck_flag,b.basis,c.centername,d.F_NAME,a.placeOfPurchase from verificationtallyslip a left join jciprocurement b on b.tallyslipno = a.tallyNo and b.rateslipno=a.rateslipno and b.datepurchase=a.puchasedate left join jcipurchasecenter c on c.CENTER_CODE = a.placeOfPurchase left join jcirmt d on d.F_REG_NO = a.farmerregno where a.status ='" + status + "' and a.payment_status='0'"; 

				//querystr = "select a.tallyid,a.tallyNo, a.farmerregno, a.puchasedate, a.netquantity, a.amountpayable, a.facheck_flag, b.basis, c.centername, "
				//		+ "d.F_NAME from verificationtallyslip a left join jciprocurement b on b.tallyslipno = a.tallyNo left join "
				//		+ "jcipurchasecenter c on c.CENTER_CODE = a.placeOfPurchase left join jcirmt d on d.F_REG_NO = a.farmerregno"
				//		+ " where a.status ='" + status + "' and a.payment_status='0'";
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
					verifyTallySlip.setErrors((String) row[10]);
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
	public String GettransectionDetails(String tallyNo, String region,String placeofp) {

		 System.err.println("***********"+ tallyNo);
		List<VerifyTallySlip> r = new ArrayList<>();
		List<Object[]> result = new ArrayList<>();
		String querystr = "Select  datepurchase, rateslipno, binno, netquantity, grasatrate, amountpayable, jutevariety, grossquantity, farmerregno, slip_image, tallyslipno,placeofpurchase, pur.centername  from jciprocurement  jci left join jcipurchasecenter pur on jci.placeofpurchase = pur.CENTER_CODE where tallyslipno='"
				+ tallyNo + "' and regionId = '" + region + "' and is_varified = 0 and placeofpurchase ='" + placeofp + "'  and jci.status = 'ROV'";

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
	public boolean updatebyTally(String statuss, int verified, String tallyno,String DPCpop,String DEOpop) {
		Session session = sessionFactory.getCurrentSession();
		boolean returnStatus = false;
		List<Object[]> result = new ArrayList<>();

		try {
			Query q = null;
			if(statuss.equals("DPCW"))
			{
				q = session.createQuery("delete VerifyTallySlip where tallyNo='"+ tallyno +"' and placeOfPurchase ='"+ DEOpop +"' ");
			}
			else if(statuss.equals("FA"))
			{
			String querystr = "select tallyslipno,farmerregno,datepurchase,rateslipno,binno,jutevariety,netquantity,grasatrate,"
			+ "amountpayable,placeofpurchase,grossquantity from jciprocurement where tallyslipno='"+tallyno+"' and placeofpurchase ='"+DPCpop+"'";
			

			Transaction tx = session.beginTransaction();
			SQLQuery query = session.createSQLQuery(querystr);
			result = query.list();
			String tallyslipno = "";
			String farmerregno = "";
			String datepurchase = "";
			int rateslipno = 0;
			int binno = 0;
			String jutevariety = "";
			double netquantity = 0.0;
			double grasatrate = 0.0;
			double amountpayable = 0.0;
			String placeofpurchase = "";
			double grossquantity = 0.0;
			if (result.size() >= 1) {
				for (Object[] row : result) {
					 tallyslipno = (String) row[0];
					 farmerregno = (String) row[1];
					 datepurchase = (String) row[2];
					 rateslipno = (int) row[3]; 
					 binno = (int) row[4]; 
					 jutevariety = (String) row[5];
					 netquantity = ((BigDecimal) row[6]).doubleValue(); 
					 grasatrate = ((BigDecimal) row[7]).doubleValue();
					 amountpayable = ((BigDecimal) row[8]).doubleValue();
					 placeofpurchase = (String) row[9];
					 grossquantity = ((BigDecimal) row[10]).doubleValue();
					
				}
				
				}
	 q = session.createQuery("update VerifyTallySlip set status ='"+statuss+"', is_varified ="+verified+",tallyNo='"+tallyslipno+"',"
	 		+ "farmerregno='"+farmerregno+"',puchasedate='"+datepurchase+"',rateslipno="+rateslipno+",binno="+binno+",jutevariety='"+jutevariety+"',"
	 				+ "netquantity="+netquantity+",garsatrate="+grasatrate+",amountpayable="+amountpayable+",placeOfPurchase='"+placeofpurchase+"',"
	 						+ "grossqty="+grossquantity+" where tallyNo='"+tallyno+"' and placeOfPurchase ='"+ DEOpop +"' ");
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
	public PaymentprocesstellyslipModel getdataforExcelSheet(String tno,String dpcid) {
		// TODO Auto-generated method stub
		String Region_id = (String) request.getSession().getAttribute("region");
		tno = tno.replace("\"", "");
		System.out.println("verification dao dpcid = " + dpcid);
		List<Object[]> list = new ArrayList();
		PaymentprocesstellyslipModel paymentdetails = new PaymentprocesstellyslipModel();
		try {

			String querystr = "select v.puchasedate,v.amountpayable,j.F_BANK_IFSC,j.F_AC_NO,j.bank_ac_type,j.F_NAME,j.F_BANK_BRANCH,j.F_BANK_NAME,"
					+ " p.centername, v.farmerregno, ro.bankACno from verificationtallyslip v left join jcirmt j on j.F_REG_NO = v.farmerregno left join "
					+ "jcipurchasecenter p on p.CENTER_CODE = v.placeOfPurchase left join jcirodetails ro on ro.rocode = v.region_id where v.region_id = '"+Region_id+"' and "
							+ "v.tallyNo ="+ tno+" and v.placeOfPurchase = "+dpcid+"";

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
		  String region =(String)request.getSession().getAttribute("regionId"); 
		try {

			List<Object[]> list = new ArrayList();
			String querystr = "select a.F_DOC_Mandate, a.F_BANK_DOC, a.F_ID_PROF, a.F_REG_FORM, b.slip_image, b.tallyslipno,a.F_NAME,b.farmerregno,b.datepurchase,b.dateof_entry,b.basis,b.cropyr,pur.centername,b.rateslipno,b.jutevariety,b.grossquantity,b.deductionquantity,b.netquantity,b.amountpayable,b.grasatrate FROM jcirmt a left join jciprocurement b on b.farmerregno = a.F_REG_NO left join jcipurchasecenter pur on b.placeofpurchase = pur.CENTER_CODE where b.tallyslipno = '"+ tallyNo +"' and b.regionId = '"+region+"'"; 
					
					
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
					images.setFname((String) rows[6]);
					images.setRegno((String) rows[7]);
					images.setPurchasedate((String) rows[8]);
					images.setDateofentry((String) rows[9]);
					images.setBasis((String) rows[10]);
					images.setCropyear((String) rows[11]);
					images.setPlacepurchase((String) rows[12]);
					images.setRateslipno((int) rows[13]);
					images.setJutevarity((String) rows[14]);
					images.setGrossqty(((BigDecimal) rows[15]).doubleValue());
					images.setDedqty(((BigDecimal) rows[16]).doubleValue());
					images.setNetqty(((BigDecimal) rows[17]).doubleValue());
					images.setAmountpayble(((BigDecimal) rows[18]).doubleValue());
					images.setGarsatrate(((BigDecimal) rows[19]).doubleValue());
					result.add(images);
                  System.err.println("result+++++++++++"+result);
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
        String currCropYear =(String)request.getSession().getAttribute("currCropYear");
		List<VerifyTallySlip> r = new ArrayList<>();
		List<Object[]> result = new ArrayList<>();
		//HttpSession session1 = request.getSession(false);
		String querystr = "select distinct a.tallyNo, a.farmerregno, a.puchasedate, a.netquantity, a.amountpayable, a.facheck_flag, b.basis, "
				+ "c.centername, d.F_NAME,a.placeOfPurchase from verificationtallyslip a left join jciprocurement b on b.tallyslipno = a.tallyNo "
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
				verifyTallySlip.setErrors((String) row[9]);
				r.add(verifyTallySlip);
			}
			return r;
		} else {
			return null;
		}
	}

	@Override
	public String getEmailby_tally(String tnoemail) {
		String Region_id = (String) request.getSession().getAttribute("region");

		// TODO Auto-generated method stub
		String querystr = "select fa_approver_email	from verificationtallyslip where tallyNo ='" + tnoemail + "' and region_id = '"+Region_id+"'";
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
        String currCropYear =(String)request.getSession().getAttribute("currCropYear");
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
	public void setholdstatus(String tno,String status,String placeofp) {
		// TODO Auto-generated method stub
		try {
			String hql = "update jciprocurement set status = '"+status+"' where tallyslipno ='"+tno+"' and placeofpurchase ='"+placeofp+"' ";
			this.sessionFactory.getCurrentSession().createSQLQuery(hql).executeUpdate();
			
			String hql1 = "update verificationtallyslip set status = '"+status+"' where tallyNo ='"+tno+"' and placeOfPurchase ='"+placeofp+"'";
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
				querystr = "select a.tallyid,a.tallyNo,a.farmerregno,a.puchasedate,a.netquantity,a.amountpayable,a.facheck_flag,b.basis,c.centername,d.F_NAME,a.placeOfPurchase from verificationtallyslip a left join jciprocurement b on b.tallyslipno = a.tallyNo and b.rateslipno=a.rateslipno and b.datepurchase=a.puchasedate left join jcipurchasecenter c on c.CENTER_CODE = a.placeOfPurchase left join jcirmt d on d.F_REG_NO = a.farmerregno where a.status ='" + status + "' and a.payment_status='0' and a.region_id = " + region; 

				//querystr = "select a.tallyid,a.tallyNo, a.farmerregno, a.puchasedate, a.netquantity, a.amountpayable, a.facheck_flag, b.basis, c.centername, "
				//		+ "d.F_NAME from verificationtallyslip a left join jciprocurement b on b.tallyslipno = a.tallyNo left join "
				//		+ "jcipurchasecenter c on c.CENTER_CODE = a.placeOfPurchase left join jcirmt d on d.F_REG_NO = a.farmerregno"
				//		+ " where a.status ='" + status + "' and a.payment_status='0' and a.region_id =" + region;
			} else if (role_type.equalsIgnoreCase("HO")) {
				querystr = "select a.tallyid,a.tallyNo,a.farmerregno,a.puchasedate,a.netquantity,a.amountpayable,a.facheck_flag,b.basis,c.centername,d.F_NAME,a.placeOfPurchase from verificationtallyslip a left join jciprocurement b on b.tallyslipno = a.tallyNo and b.rateslipno=a.rateslipno and b.datepurchase=a.puchasedate left join jcipurchasecenter c on c.CENTER_CODE = a.placeOfPurchase left join jcirmt d on d.F_REG_NO = a.farmerregno where a.status ='" + status + "' and a.payment_status='0'"; 

				//querystr = "select a.tallyid,a.tallyNo, a.farmerregno, a.puchasedate, a.netquantity, a.amountpayable, a.facheck_flag, b.basis, c.centername, "
				//		+ "d.F_NAME from verificationtallyslip a left join jciprocurement b on b.tallyslipno = a.tallyNo left join "
				//		+ "jcipurchasecenter c on c.CENTER_CODE = a.placeOfPurchase left join jcirmt d on d.F_REG_NO = a.farmerregno"
				//		+ " where a.status ='" + status + "' and a.payment_status='0'";
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
					verifyTallySlip.setErrors((String) row[10]);
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
	public void updatestatustoPP(String[] tallyslipno,String[] dpc) {
		try {
			String Region_id = (String) request.getSession().getAttribute("region");
			String sql ="update verificationtallyslip set payment_status = 1, status ='pp' WHERE ";
			for (int i = 0; i < tallyslipno.length; i++) {
			    if (i > 0) {
			        sql = sql+" OR ";
			    }
			    sql = sql+"region_id = '"+Region_id+"' AND tallyNo = '"+tallyslipno[i].replace("\'","")+"' AND placeOfPurchase = '"+dpc[i].replace("\'","")+"'";
			}
			System.err.println("hql = "+sql);
			this.sessionFactory.getCurrentSession().createSQLQuery(sql).executeUpdate();
			
			//String hql1 = "update jciprocurement set status = 'PP' where regionId = '"+Region_id+"' and tallyslipno in (" + tallyslipno+")";
			String hql1 ="update jciprocurement set status ='pp' WHERE ";
			for (int i = 0; i < tallyslipno.length; i++) {
			    if (i > 0) {
			    	hql1 = hql1+" OR ";
			    }
			    hql1 = hql1+"regionId = '"+Region_id+"' AND tallyslipno = '"+tallyslipno[i].replace("\'","")+"' AND placeofpurchase = '"+dpc[i].replace("\'","")+"'";
			}
			System.err.println("hql1 = "+hql1);
			this.sessionFactory.getCurrentSession().createSQLQuery(hql1).executeUpdate();
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
		}
	}

	@Override
	public void updatestatustoRMZM(String[] tallyno,String[] dpc) {
		try {
			String Region_id = (String) request.getSession().getAttribute("region");
			String sql ="update verificationtallyslip set payment_status = 0, status ='RMZM' WHERE ";
			for (int i = 0; i < tallyno.length; i++) {
			    if (i > 0) {
			        sql = sql+" OR ";
			    }
			    sql = sql+"region_id = '"+Region_id+"' AND tallyNo = '"+tallyno[i].replace("\'","")+"' AND placeOfPurchase = '"+dpc[i].replace("\'","")+"'";
			}
			System.err.println("hql = "+sql);
			this.sessionFactory.getCurrentSession().createSQLQuery(sql).executeUpdate();
			
			//String hql1 = "update jciprocurement set status = 'PP' where regionId = '"+Region_id+"' and tallyslipno in (" + tallyslipno+")";
			String hql1 ="update jciprocurement set status ='RMZM' WHERE ";
			for (int i = 0; i < tallyno.length; i++) {
			    if (i > 0) {
			    	hql1 = hql1+" OR ";
			    }
			    hql1 = hql1+"regionId = '"+Region_id+"' AND tallyslipno = '"+tallyno[i].replace("\'","")+"' AND placeofpurchase = '"+dpc[i].replace("\'","")+"'";
			}
			System.err.println("hql1 = "+hql1);
			this.sessionFactory.getCurrentSession().createSQLQuery(hql1).executeUpdate();
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
		}
	}

	@Override
	public List<PurchaseRegisterDTO> getAllPurchase(String cropyear, String placeofp, String basis,
			String purchasesdateFrom,String purchasesdateTo) {	// TODO Auto-generated method stub
		List<PurchaseRegisterDTO> r = new ArrayList<>();
		List<Object[]> result = new ArrayList<>();
		try {
			String querystr = "";
			querystr = "SELECT ro.roname,j2.centername,j1.tallyslipno,j1.datepurchase,j1.farmerregno,j1.placeofpurchase,j1.cropyr,j1.basis,j1.jutevariety,j1.grossquantity/100 as gross_qty,j1.deductionquantity/100 as deduc_qty,j1.netquantity/100 as net_qty,j1.amountpayable,j1.grasatrate as garsat,j1.td_base,j1.binno,jr.F_NAME,j1.rateslipno,CASE WHEN j1.status='PP'THEN'Payment Initiated'WHEN j1.[status]='ROV'THEN'Pending at DEO End' WHEN j1.status='RMD'THEN'Pending at RM End - Disputed Entry'WHEN j1.status='RMA'THEN'Pending at RM End - Delayed Entry'WHEN j1.status='RMZM'THEN'Pending at RM End - Payment Approval'WHEN j1.status='DPC'THEN'Pending at DPCM End - Confirmation'WHEN j1.status='DPCW'THEN'Pending at DPCM End - Correction' WHEN j1.status='FA'THEN'Pending at RO F&A End'ELSE'Contact IT Helpdesk'END tally_status FROM jciprocurement j1 left join jcirmt jr on jr.F_REG_NO = j1.farmerregno left join jcirodetails ro on ro.rocode = j1.regionId,jcipurchasecenter j2 WHERE j1.cropyr = '"+cropyear+"' and j1.basis = '"+basis+"' and j1.placeofpurchase = '"+placeofp+"' and CONVERT(datetime,j1.datepurchase,103) between '"+purchasesdateFrom+"' and '"+purchasesdateTo+"' and j1.placeofpurchase=j2.CENTER_CODE ORDER BY j1.regionId, j1.placeofpurchase,CONVERT(DATETIME,j1.datepurchase,105)"; 
            Session session = sessionFactory.getCurrentSession();
			Transaction tx = session.beginTransaction();
			SQLQuery query = session.createSQLQuery(querystr);
			result = query.list();
			if (result.size() >= 1) {
				// Object[] row = result.get(0);
				for (Object[] row : result) {
					PurchaseRegisterDTO purchaseRegister = new PurchaseRegisterDTO();
					purchaseRegister.setRegionId((String) row[0]);
					purchaseRegister.setCentername((String) row[1]);
					purchaseRegister.setTallyslipno((String) row[2]);
					purchaseRegister.setDatepurchase((String) row[3]);
					purchaseRegister.setFarmerregno((String) row[4]);
					purchaseRegister.setPlaceofpurchase((String) row[5]);
					purchaseRegister.setCropyr((String) row[6]);
					purchaseRegister.setBasis((String) row[7]);
					purchaseRegister.setJutevariety((String) row[8]);
					purchaseRegister.setGross_qty(((BigDecimal) row[9]).doubleValue());
					purchaseRegister.setDeduc_qty(((BigDecimal) row[10]).doubleValue());
					purchaseRegister.setNet_qty(((BigDecimal) row[11]).doubleValue());
					purchaseRegister.setAmountpayable(((BigDecimal) row[12]).doubleValue());
					purchaseRegister.setGarsat(((BigDecimal) row[13]).doubleValue());
					purchaseRegister.setTd_base((String) row[14]);
					purchaseRegister.setBinno((int) row[15]);
					purchaseRegister.setFarmername((String) row[16]);
					purchaseRegister.setRate_slipno((int) row[17]);
					purchaseRegister.setTally_status((String) row[18]);
					System.err.println("purchaseRegister___________"+purchaseRegister);
					r.add(purchaseRegister);
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
	public List<String> getexcelpath(String regionId) {
		// TODO Auto-generated method stub
		List<String> result = new ArrayList<>();
		try {
		    String querystr = "select distinct excel_link from jcitallyslippayment where region_id = '"+regionId+"'";
		    Session session = sessionFactory.getCurrentSession();
		    Transaction tx = session.beginTransaction();
		    SQLQuery query = session.createSQLQuery(querystr);
		    result = query.list();
		} catch (Exception e) {
		    System.out.println(e.getLocalizedMessage());
		}
		return result;
	}



}
