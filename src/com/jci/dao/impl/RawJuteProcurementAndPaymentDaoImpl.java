package com.jci.dao.impl;
import static org.hamcrest.CoreMatchers.nullValue;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.jci.dao.RawJuteProcurementAndPaymentDao;
import com.jci.model.RawJuteProcurementAndPayment;
import com.mashape.unirest.request.HttpRequest;

@Transactional
@Repository
public class RawJuteProcurementAndPaymentDaoImpl implements RawJuteProcurementAndPaymentDao{

	@Autowired
	SessionFactory sessionFactory;
	protected Session currentSession(){
		return sessionFactory.getCurrentSession();
	}

	@Override
	public void create(RawJuteProcurementAndPayment rawJuteProcurementAndPayment) {
		currentSession().saveOrUpdate(rawJuteProcurementAndPayment);
	}

	@Override
	public void update(RawJuteProcurementAndPayment rawJuteProcurementAndPayment) {
		currentSession().update(rawJuteProcurementAndPayment);
	}

	@Override
	public RawJuteProcurementAndPayment edit(int id) {
		return find(id);
	}

	@Override
	public void delete(int id) {
		String hql = "Delete from dbo.jciprocurement where ptsid = '"+id+"' ";
		this.sessionFactory.getCurrentSession().createSQLQuery(hql).executeUpdate();
	}

	@Override
	public RawJuteProcurementAndPayment find(int id) {
		return (RawJuteProcurementAndPayment) currentSession().get(RawJuteProcurementAndPayment.class, id);
	}

	@Override
	public List<RawJuteProcurementAndPayment> getAll() {
		Criteria c = this.sessionFactory.getCurrentSession().createCriteria(RawJuteProcurementAndPayment.class);
		List<RawJuteProcurementAndPayment> ll=c.list();
		return ll;
	}

	@Override
	public boolean submitform(RawJuteProcurementAndPayment rawJuteProcurementAndPayment) {
		this.sessionFactory.getCurrentSession().save(rawJuteProcurementAndPayment);
		return false;
	}

	@Override
	public List<String> farmerNoVarification(String farmerNo) {
		List<String> result = new ArrayList<>();
		String querystr = "select F_NAME, F_MOBILE, F_AC_NO  from jcirmt where F_REG_NO ='"+farmerNo+"'";
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		SQLQuery query = session.createSQLQuery(querystr);
		List<Object[]> data = query.list();
		for(Object[] cart : data) {
			//result.add(cart[0].toString()+"-"+cart[1].toString());
			result.add(cart[0].toString()+"-"+cart[1].toString()+"-"+cart[2].toString());
		}
		return result;
	}

	@Override
	public List<String> allDpcList() {
		List<String> result = new ArrayList<>();
		String querystr = "Select * from jcipurchasecenter";
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		SQLQuery query = session.createSQLQuery(querystr);
		List<Object[]> rows = query.list();
		for(Object[] row : rows){
			//System.out.println("CENTER_CODE ==="+ row[1].toString() + "centername==="+row[4].toString());
			result.add(row[1].toString()+"-"+row[4].toString());
		}
		return result;
	}
	@Override
	public List<String> findJuteOnBasis(int msp_no) {
		List<String> result = new ArrayList<>();
		String querystr = "SELECT distinct(jutevariety) FROM jcijutevariety where basis ='"+msp_no+"'";
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		SQLQuery query = session.createSQLQuery(querystr);
		result = query.list();

		return result;
	}

	@Override
	public List<String> findGradeOnJuteVariety(String variety, int basis_no) {
		List<String> result = new ArrayList<>();
		int count=0;

		String querystr = "SELECT grade FROM jcijutevariety where basis ='"+basis_no+"' and jutevariety like '%"+variety+"%'";

		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		SQLQuery query = session.createSQLQuery(querystr);
		result = query.list();
		//System.out.println("jute variety==================== "+result);
		return result;
	}
	@Override
	public List<String> findGradePriceJuteVariety(String variety, int basis_no, String cropyr, String dpcid) {

		String querystr="";
		List<String> result = new ArrayList<>();
		
		int count=0;

		if(basis_no==1) {
		 querystr =  "SELECT  grade1, grade2, grade3, grade4, grade5, grade6, grade7, grade8 FROM jcimspgradesprice where crop_yr='"+cropyr + "' and jute_variety like '"+ variety+"%'";
		}
		else if(basis_no==2) {
			 querystr = "SELECT  top 1 grade1, grade2, grade3, grade4, grade5, grade6, grade7, grade8 FROM jcijutepricesforcommercial where CONVERT( date, effectDate ,105) <= GETDATE() and crop_yr='"+cropyr +"' and jute_variety like '"+ variety+"%' and dpc like '%"+dpcid+"%'order by id desc"	;	}
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		SQLQuery query = session.createSQLQuery(querystr);
		result = query.list();
		//System.out.println("jute Prices==================== "+result);
		return result;
	}

	@Override
	public List<String> getfarmerno(String dpc) {
		String queryStr="";
		List<String> result = new ArrayList<>();
		queryStr= "select DISTINCT F_REG_NO from jcirmt where IS_VERIFIED=1 and dpc_id ='"+dpc+"'";
		Session session= sessionFactory.getCurrentSession();
		Transaction tx= session.beginTransaction();
		SQLQuery query= session.createSQLQuery(queryStr);
		result = query.list();
		//System.out.println("result========>>>>>>"+query.list());
		return result;
	}


	
	  @Override public List<RawJuteProcurementAndPayment> farmerDetailsList() {
	  
	  List<RawJuteProcurementAndPayment> list =new ArrayList<>();
	  
	  String
	  queryStr="select farmerregno,datepurchase,basis,cropyr,placeofpurchase,rateslipno,binno,jutevariety, grossquantity,deductionquantity,grasatrate,amountpayable ,ptsid,tallyslipno, tallySlipImg from jciprocurement where farmerregno Not in (select farmerregno from verificationtallyslip)"; 
	  List<RawJuteProcurementAndPayment> result = new ArrayList<>();
	  List<Object[]> res = new ArrayList<>(); 
	  Session session =
	  sessionFactory.getCurrentSession(); 
	  Transaction tx = session.beginTransaction(); 
	  SQLQuery query = session.createSQLQuery(queryStr);
	  res = query.list(); 
	  for( Object[] o : res)
	  { 
		  RawJuteProcurementAndPayment raw = new RawJuteProcurementAndPayment();
	  
	  String farmer = (String)o[0]; 
	  String datepurchase = (String)o[1]; 
	  String basis = (String)o[2]; 
	  String cropyr = (String)o[3]; 
	  String placeofpurchase = (String)o[4]; 
	  int rateslipno = (int)o[5]; 
	  int binno = (int)o[6]; 
	  String jutevariety = (String)o[7]; 
	  BigDecimal grossquantity = (BigDecimal)o[8];
	  BigDecimal deductionquantity = (BigDecimal)o[9]; 
	  BigDecimal grasatrate = (BigDecimal)o[10]; 
	  BigDecimal amountpayable = (BigDecimal)o[11]; 
	  int ptsid = (int)o[12]; 
	  String tallyslip = (String)o[13]; 
	  raw.setFarmerregno(farmer);
	  raw.setDatepurchase(datepurchase); 
	  raw.setBasis(basis);
	  raw.setCropyr(cropyr);
	  raw.setPlaceofpurchase(placeofpurchase);
	  raw.setRateslipno(rateslipno); 
	  raw.setBinno(binno);
	  raw.setJutevariety(jutevariety);
	  raw.setGrossquantity(grossquantity.doubleValue());
	  raw.setDeductionquantity(deductionquantity.doubleValue());
	  raw.setGrasatrate(grasatrate.doubleValue());
	  raw.setAmountpayable(amountpayable.doubleValue()); 
	  raw.setPtsid(ptsid);
	  raw.setTallyslipno(tallyslip); 
	  result.add(raw);
	  //System.out.println("farmer  ====== "+farmer); }
	  }
	  return result;
	  
	  }
	

	@Override
	public boolean updateProcurement(String statuss, int verified,String tallyno,String placeofp) {
		Session session = sessionFactory.getCurrentSession();
		boolean returnStatus=false;
		try {
			Query q=session.createQuery("update RawJuteProcurementAndPayment set status ='"+statuss+"', is_varified ="+verified+" where tallyslipno='"+tallyno+"' and placeofpurchase ='"+placeofp+"' ");
			int status=q.executeUpdate();
			if(status>=1) {
				returnStatus =true;
				return returnStatus;
			} else {
				returnStatus =false;
				return returnStatus;
			}
		}catch(Exception e){
			System.out.println(e.getLocalizedMessage());
		}
		return returnStatus;
	}

	@Override
	public boolean updateProcurementerror(String statuss, int verified,String tallyno,String error,String region,String placeofp) {
		 
		Session session = sessionFactory.getCurrentSession();
		boolean returnStatus=false;
		try {
			Query q=session.createQuery("update  RawJuteProcurementAndPayment set status ='"+statuss+"', is_varified ="+verified+" , reason = '"+error+"' where tallyslipno='"+tallyno+"' and regionId = '"+region+"' and placeofpurchase ='"+placeofp+"' ");
			int status=q.executeUpdate();
			if(status>=1) {
				returnStatus =true;
				return returnStatus;
			} else {
				returnStatus =false;
				return returnStatus;
			}
		}catch(Exception e){
			System.out.println(e.getLocalizedMessage());
		}
		return returnStatus;
	}

	@Override
	public RawJuteProcurementAndPayment findbyTally(String tallyno, int regionId, String dpcid) {
		String	queryStr="select farmerregno,datepurchase,basis,cropyr,placeofpurchase,rateslipno,binno,jutevariety, grossquantity,deductionquantity,grasatrate,amountpayable ,ptsid,tallyslipno,netquantity,slip_image from jciprocurement where tallyslipno ='"+tallyno+"' and placeofpurchase ='"+dpcid+"' and regionId = "+regionId;
		List<RawJuteProcurementAndPayment> result = new ArrayList<>();
		List<Object[]> res = new ArrayList<>();

			Session session = sessionFactory.getCurrentSession();
			Transaction tx = session.beginTransaction();
			SQLQuery query = session.createSQLQuery(queryStr);
	        res = query.list();
	        RawJuteProcurementAndPayment raw = new RawJuteProcurementAndPayment();
	        System.err.println("res"+res);
	        if(!res.isEmpty())
	        {
			Object[] o = res.get(0);

				
				String farmer = (String)o[0];
				String datepurchase = (String)o[1];
				String basis = (String)o[2];
				String cropyr = (String)o[3];
				String placeofpurchase = (String)o[4];
				int rateslipno = (int)o[5];
				int binno = (int)o[6];
				String jutevariety = (String)o[7];
				BigDecimal grossquantity = (BigDecimal)o[8];
				//System.out.println("grossquantity  ====== "+grossquantity);
				BigDecimal deductionquantity = (BigDecimal)o[9];
				BigDecimal grasatrate = (BigDecimal)o[10];
				BigDecimal amountpayable = (BigDecimal)o[11];
				int ptsid = (int)o[12];
				String tallyslip =  (String)o[13];
				BigDecimal netqty = (BigDecimal)o[14];
				raw.setFarmerregno(farmer);
				raw.setDatepurchase(datepurchase);
				raw.setBasis(basis);
				raw.setCropyr(cropyr);
				raw.setPlaceofpurchase(placeofpurchase);
				raw.setRateslipno(rateslipno);
				raw.setBinno(binno);
				raw.setJutevariety(jutevariety);
				raw.setGrossquantity(grossquantity.doubleValue());
				raw.setDeductionquantity(deductionquantity.doubleValue());
				raw.setGrasatrate(grasatrate.doubleValue());
				raw.setAmountpayable(amountpayable.doubleValue());
				raw.setPtsid(ptsid);
				raw.setNetquantity(netqty.doubleValue());
				raw.setTallyslipno(tallyslip);
				raw.setSlip_image((String)o[15]);
			//	result.add(raw);
				//System.out.println("farmer  ====== "+farmer);
	        }
	        else {
				return raw ;
			}
			  return raw;
	}

	@Override 
	public List<RawJuteProcurementAndPayment> jutelistbystatus(String status,HttpServletRequest request) {
         
		 String dpcid = (String)request.getSession().getAttribute("dpcId");
		 String roletype =(String) request.getSession().getAttribute("roletype");
		 String regionid = (String) request.getSession().getAttribute("regionId");
		 
		 String queryStr = "";
		 if(roletype.equalsIgnoreCase("RO")) {
			 queryStr=" select farmerregno,datepurchase,basis,cropyr,c.centername,rateslipno,binno,jutevariety,grossquantity,deductionquantity,grasatrate,amountpayable, ptsid,tallyslipno, slip_image,netquantity,dateof_entry,placeofpurchase from jciprocurement p left join jcipurchasecenter c on p.placeofpurchase = c.CENTER_CODE where p.status ='"+status+"' and regionId = '"+regionid+"'";
		 }
		 else if (roletype.equalsIgnoreCase("HO")) {
			 queryStr=" select farmerregno,datepurchase,basis,cropyr,c.centername,rateslipno,binno,jutevariety,grossquantity,deductionquantity,grasatrate,amountpayable, ptsid,tallyslipno, slip_image,netquantity,dateof_entry,placeofpurchase from jciprocurement p left join jcipurchasecenter c on p.placeofpurchase = c.CENTER_CODE where p.status ='"+status+"'";
		 }
		 else if (roletype.equalsIgnoreCase("DPC")) {
			 queryStr=" select farmerregno,datepurchase,basis,cropyr,c.centername,rateslipno,binno,jutevariety,grossquantity,deductionquantity,grasatrate,amountpayable, ptsid,tallyslipno, slip_image,netquantity,dateof_entry,placeofpurchase from jciprocurement p left join jcipurchasecenter c on p.placeofpurchase = c.CENTER_CODE where p.status ='"+status+"' and placeofpurchase = '"+dpcid+"'";
		 }
		 else {
			 queryStr=" select farmerregno,datepurchase,basis,cropyr,c.centername,rateslipno,binno,jutevariety,grossquantity,deductionquantity,grasatrate,amountpayable, ptsid,tallyslipno, slip_image,netquantity,dateof_entry,placeofpurchase from jciprocurement p left join jcipurchasecenter c on p.placeofpurchase = c.CENTER_CODE where p.status ='"+status+"'";
		 }
		
		List<RawJuteProcurementAndPayment> result = new ArrayList<>();
		List<Object[]> res = new ArrayList<>();

			Session session = sessionFactory.getCurrentSession();
			Transaction tx = session.beginTransaction();
			SQLQuery query = session.createSQLQuery(queryStr);
	        res = query.list();
			for(Object[] o : res) {

				RawJuteProcurementAndPayment raw = new RawJuteProcurementAndPayment();
				String farmer = (String)o[0];
				String datepurchase = (String)o[1];
				String basis = (String)o[2];
				String cropyr = (String)o[3];
				String placeofpurchase = (String)o[4];
				int rateslipno = (int)o[5];
				int binno = (int)o[6];
				String jutevariety = (String)o[7];
				BigDecimal grossquantity = (BigDecimal)o[8];
				//System.out.println("grossquantity  ====== "+grossquantity);
				BigDecimal deductionquantity = (BigDecimal)o[9];
				BigDecimal grasatrate = (BigDecimal)o[10];
				BigDecimal amountpayable = (BigDecimal)o[11];
				BigDecimal netqty = (BigDecimal)o[15];
				String dateofentry = (String)o[16];
				int ptsid = (int)o[12];
				String tallyslip =  (String)o[13];
				String placeofp = (String)o[17];
				
				raw.setFarmerregno(farmer);
				raw.setDatepurchase(datepurchase);
				raw.setBasis(basis);
				raw.setCropyr(cropyr);
				raw.setPlaceofpurchase(placeofpurchase);
				raw.setRateslipno(rateslipno);
				raw.setBinno(binno);
				raw.setJutevariety(jutevariety);
				raw.setGrossquantity(grossquantity.doubleValue());
				raw.setDeductionquantity(deductionquantity.doubleValue());
				raw.setGrasatrate(grasatrate.doubleValue());
				raw.setAmountpayable(amountpayable.doubleValue());
				raw.setPtsid(ptsid);
				raw.setTallyslipno(tallyslip);
				raw.setDateof_entry(dateofentry);
				//raw.setPlaceofpurchase(placeofp);
				raw.setNetquantity(netqty.doubleValue());
				//in setcreatedfrom the value is placeofpurchases code
				raw.setCreatedfrom(placeofp);
				result.add(raw);
				//System.out.println("farmer  ====== "+farmer);
			}

			  return result;
	}

	@Override
	public boolean validateTally(String tally, String ro) {
		List<Integer> result = new ArrayList<>();
		String querystr = "select * from jciprocurement where tallyslipno ='"+tally+"' and regionId='"+ro+"'";
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		SQLQuery query = session.createSQLQuery(querystr);
		List<Object[]> rows = query.list();
		//System.out.println("you are in DAO layer");
		boolean tallyMatched = rows.isEmpty();		// returns true if no tally number is found in db
		if(tallyMatched) {
			return true;
		}else {
			return false;
		}
		
	}

	@Override
	public String getbinno(String binno) {
	
	 String basis_variety= "null";
	 String querystr1= "select * from tbl_jci_bin where binNo = '" +binno+"'";
	 Session session1 = sessionFactory.getCurrentSession();
		Transaction tx1 = session1.beginTransaction();
		SQLQuery query1 = session1.createSQLQuery(querystr1);
		List<Object[]> rows1=query1.list();
		if(rows1.isEmpty()) {
	 String querystr= "SELECT top 1 basis, jutevariety FROM jciprocurement where binno = '" +binno+"'";
	 Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		SQLQuery query = session.createSQLQuery(querystr);
		List<Object[]> rows=query.list();
		if(!rows.isEmpty()) {
		for(Object[] cart : rows) 
			basis_variety= (cart[0].toString()+"-"+cart[1].toString());	
			}
		else basis_variety ="empty";
		}
		else basis_variety = "null";
		return basis_variety;
		}
	
	
	@Override
	public boolean updateStatus(String tally,String placeofp) {
		boolean returnStatus=false;
		String querystr = "update jciprocurement set status= 'ROV' where tallyslipno = '" +tally+"' and placeofpurchase ='" +placeofp+"' ";
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		SQLQuery query = session.createSQLQuery(querystr);
		int status = query.executeUpdate();
		System.out.println("status  ===   "+status);
		if(status>=1) {
			returnStatus =true;
			return returnStatus;
		} else {
			returnStatus =false;
			return returnStatus;
		}
		
	}

	@Override
	public JSONArray searchTally(String tallyno) {
		JSONArray arr = new JSONArray();
		String	queryStr="select tallyslipno,status from jciprocurement where tallyslipno in ('"+tallyno+"')";
		List<RawJuteProcurementAndPayment> result = new ArrayList<>();
		List<Object[]> res = new ArrayList<>();

			Session session = sessionFactory.getCurrentSession();
			Transaction tx = session.beginTransaction();
			SQLQuery query = session.createSQLQuery(queryStr);
	        res = query.list();
	        for(Object[] o : res) {
 
				String tally = (String)o[0];
				System.out.println(tally);
				String status = (String)o[1];
				if(status.equalsIgnoreCase("DPC")) {
					status = "Pending for Confirmation by DPCM";
				}
				else if(status.equalsIgnoreCase("RMA")) {
					status = "Pending for Confirmation by RM";
				}
				else if(status.equalsIgnoreCase("DPCW")) {
					status = "Withheld by DPCM";
				}
				else if(status.equalsIgnoreCase("ROV")) {
					status = "Pending for verification by DEO";
				}else if(status.equalsIgnoreCase("FA")) {
					status = "Pending for financial approval by F&A Official";
				}else if(status.equalsIgnoreCase("RMD")) {
					status = "Pending for administrative approval by RM";
				}else {
					status = "Payment Intiated";
				} 
				
				JSONObject obj = new JSONObject();
				obj.put("tally", tally);
 				obj.put("status", status);
 				 
 				arr.put(obj);
			}
			 
			  return arr;
	}
	
	@Override
	public boolean updateStatusDPCW(String tally,String placeofp) {
		boolean returnStatus=false;
		String querystr = "update jciprocurement set status= 'DPCW' where tallyslipno = '" +tally+"' and placeofpurchase = '" +placeofp+"'";
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		SQLQuery query = session.createSQLQuery(querystr);
		int status = query.executeUpdate();
		System.out.println("status  ===   "+status);
		if(status>=1) {
			returnStatus =true;
			return returnStatus;
		} else {
			returnStatus =false;
			return returnStatus;
		}
		
	}

	@Override
	public List<RawJuteProcurementAndPayment> delayedenteredtallylist(String status1, String status2,
			HttpServletRequest request) {
        
		 String dpcid = (String)request.getSession().getAttribute("dpcId");
		 String roletype =(String) request.getSession().getAttribute("roletype");
		 String regionid = (String) request.getSession().getAttribute("regionId");
		 String queryStr = "";
		 if(roletype.equalsIgnoreCase("RO")) {
			 queryStr=" select farmerregno,datepurchase,basis,cropyr,c.centername,rateslipno,binno,jutevariety,grossquantity,deductionquantity,grasatrate,amountpayable, ptsid,tallyslipno, slip_image,netquantity,dateof_entry,placeofpurchase from jciprocurement p left join jcipurchasecenter c on p.placeofpurchase = c.CENTER_CODE where (p.status = 'RMA' OR  (p.status = 'DPC' AND DATEDIFF(D, CONVERT(date, datepurchase, 105), GETDATE()) >= 2 )) and regionId = '"+regionid+"'";
		 }
		 else if (roletype.equalsIgnoreCase("HO")) {
			 queryStr=" select farmerregno,datepurchase,basis,cropyr,c.centername,rateslipno,binno,jutevariety,grossquantity,deductionquantity,grasatrate,amountpayable, ptsid,tallyslipno, slip_image,netquantity,dateof_entry,placeofpurchase from jciprocurement p left join jcipurchasecenter c on p.placeofpurchase = c.CENTER_CODE where p.status = 'RMA' OR  (p.status = 'DPC' AND DATEDIFF(D, CONVERT(date, datepurchase, 105), GETDATE()) >= 2 )";
		 }
		 else if (roletype.equalsIgnoreCase("DPC")) {
			 queryStr=" select farmerregno,datepurchase,basis,cropyr,c.centername,rateslipno,binno,jutevariety,grossquantity,deductionquantity,grasatrate,amountpayable, ptsid,tallyslipno, slip_image,netquantity,dateof_entry,placeofpurchase from jciprocurement p left join jcipurchasecenter c on p.placeofpurchase = c.CENTER_CODE where (p.status = 'RMA' OR  (p.status = 'DPC' AND DATEDIFF(D, CONVERT(date, datepurchase, 105), GETDATE()) >= 2 )) and placeofpurchase = '"+dpcid+"'";
		 }
		 else {
			 queryStr=" select farmerregno,datepurchase,basis,cropyr,c.centername,rateslipno,binno,jutevariety,grossquantity,deductionquantity,grasatrate,amountpayable, ptsid,tallyslipno, slip_image,netquantity,dateof_entry,placeofpurchase from jciprocurement p left join jcipurchasecenter c on p.placeofpurchase = c.CENTER_CODE where p.status = 'RMA' OR  (p.status = 'DPC' AND DATEDIFF(D, CONVERT(date, datepurchase, 105), GETDATE()) >= 2 )";
		 }
		
		List<RawJuteProcurementAndPayment> result = new ArrayList<>();
		List<Object[]> res = new ArrayList<>();

			Session session = sessionFactory.getCurrentSession();
			Transaction tx = session.beginTransaction();
			SQLQuery query = session.createSQLQuery(queryStr);
	        res = query.list();
			for(Object[] o : res) {

				RawJuteProcurementAndPayment raw = new RawJuteProcurementAndPayment();
				String farmer = (String)o[0];
				String datepurchase = (String)o[1];
				String basis = (String)o[2];
				String cropyr = (String)o[3];
				String placeofpurchase = (String)o[4];
				int rateslipno = (int)o[5];
				int binno = (int)o[6];
				String jutevariety = (String)o[7];
				BigDecimal grossquantity = (BigDecimal)o[8];
				//System.out.println("grossquantity  ====== "+grossquantity);
				BigDecimal deductionquantity = (BigDecimal)o[9];
				BigDecimal grasatrate = (BigDecimal)o[10];
				BigDecimal amountpayable = (BigDecimal)o[11];
				BigDecimal netqty = (BigDecimal)o[15];
				String dateofentry = (String)o[16];
				int ptsid = (int)o[12];
				String tallyslip =  (String)o[13];
				String placeofp = (String)o[17];
				
				raw.setFarmerregno(farmer);
				raw.setDatepurchase(datepurchase);
				raw.setBasis(basis);
				raw.setCropyr(cropyr);
				raw.setPlaceofpurchase(placeofpurchase);
				raw.setRateslipno(rateslipno);
				raw.setBinno(binno);
				raw.setJutevariety(jutevariety);
				raw.setGrossquantity(grossquantity.doubleValue());
				raw.setDeductionquantity(deductionquantity.doubleValue());
				raw.setGrasatrate(grasatrate.doubleValue());
				raw.setAmountpayable(amountpayable.doubleValue());
				raw.setPtsid(ptsid);
				raw.setTallyslipno(tallyslip);
				raw.setDateof_entry(dateofentry);
				raw.setNetquantity(netqty.doubleValue());
				//set placeofpurchases in createdfrom
				raw.setCreatedfrom(placeofp);
				result.add(raw);
				//System.out.println("farmer  ====== "+farmer);
			}

			  return result;
	}
	
	
	
}
