package com.jci.dao.impl_phase2;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.jci.dao_phase2.NominalOfficialDao;
import com.jci.model.ClaimSettlementReport;
import com.jci.model.Contractgeneration;
import com.jci.model.EntryPaymentDetailsModel;
import com.jci.model.FarmerRegModel;
import com.jci.model.JciDIHoModel;
import com.jci.model.JciEntryTdsModel;
import com.jci.model.Jciclaim_NominationModel;
import com.jci.model.MillRecieptModel;
import com.jci.model.RoDetailsModel;
import com.jci.model.UserRegistrationModel;

@Transactional
@Repository
public class Jciclaim_NominationImpl implements NominalOfficialDao {

	@Autowired
	private HttpServletRequest request;

	@Autowired
	SessionFactory sessionFactory;

	protected Session currentSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public void create(Jciclaim_NominationModel nominal ) {
		
		
		currentSession().save(nominal);

	}

	@Override
	public void update(Jciclaim_NominationModel nominal) {
		currentSession().update(nominal);
	}

	@Override
	public Jciclaim_NominationModel edit(int id) {
		return (Jciclaim_NominationModel) currentSession().get(Jciclaim_NominationModel.class, id);

	}

	@Override
	public void delete(int id) {
		String hql = "Delete from  dbo.jciclaim_nomination where Settlement_id = '" + id + "' ";
		this.sessionFactory.getCurrentSession().createSQLQuery(hql).executeUpdate();

	}

	@Override
	public List<Jciclaim_NominationModel> getAll() {
		// TODO Auto-generated method stub
	//String sqlQuery = "select distinct Settlement_id_generated, Created_on, DateofInspection, Mill, ContractNo, HoDi, OMOfficial, FAOfficial from jciclaim_nomination";
		  String sqlQuery = "SELECT DISTINCT Settlement_id_generated, Created_on, DateofInspection, Mill, ContractNo, HoDi, OMOfficial, FAOfficial FROM jciclaim_nomination ORDER BY Created_on DESC";
		List<Object[]> contracts = currentSession().createSQLQuery(sqlQuery).list();

		List<Jciclaim_NominationModel> list = new ArrayList<>();

		for (Object[] eleObject : contracts) {
			Jciclaim_NominationModel nomination = new Jciclaim_NominationModel();

			nomination.setSettlement_id_generated((String) eleObject[0]);
			nomination.setCreated_on((String) eleObject[1]);
			nomination.setDateofInspection((String) eleObject[2]);
			nomination.setMill((String) eleObject[3]);
			nomination.setContractNo((String) eleObject[4]);
			nomination.setHoDi((String) eleObject[5]);
			nomination.setOMOfficial((String) eleObject[6]);
			nomination.setFAOfficial((String) eleObject[7]);
			//nomination.setSettlement_id( eleObject[7]);
			list.add(nomination);

		}

		return list;

	}
		
	

	@Override
	public boolean submitform(Jciclaim_NominationModel nominal) {
		// TODO Auto-generated method stub
		String sql = "select * from jciclaim_nomination";
		List list = this.sessionFactory.getCurrentSession().createSQLQuery(sql).list();

		this.sessionFactory.getCurrentSession().saveOrUpdate(nominal);
		return false;
	}



	@Override
	public List<String> millid_MillReceipt() {
	    String q = "SELECT DISTINCT m.unit_name " +
	               "FROM jcimilldetailchild m " +
	               "JOIN jcimill_receipt r ON m.client_unit_code = r.Mill_id";
	    
	    List<String> millidList = (List<String>) this.sessionFactory.getCurrentSession().createSQLQuery(q).list();

	    return millidList;
	}



	@Override
	public List<Object> FetchMillReceiptData(String millid) {
	    // MillNamenomination is the unit name passed to the method
	    String MillNamenomination = millid;

	    // Constructing the SQL query
	    String q = "SELECT DISTINCT c.Contract_no " +
	               "FROM jcicontract c " +
	               "JOIN jcimilldetailchild m ON c.Mill_code = m.client_unit_code " +
	               "WHERE m.unit_name = '" + MillNamenomination + "' " +
	               "AND c.Contract_no NOT IN ( " +
	               "    SELECT DISTINCT ContractNo " +
	               "    FROM jciclaim_nomination " +
	               ")";

	    // Executing the SQL query and fetching the result
	    List<Object> ContractListData = (List<Object>) this.sessionFactory.getCurrentSession().createSQLQuery(q).list();
	    
	    // Returning the fetched data
	    return ContractListData;
	}

	@Override
	public List<String> contractno_ContractTable() {
		// TODO Auto-generated method stub
		 String q = "SELECT DISTINCT jcicontract.Contract_no " +
	               "FROM jcicontract " +
	               "WHERE jcicontract.Contract_no NOT IN ( " +
	               "    SELECT DISTINCT ContractNo " +
	               "    FROM jciclaim_nomination " +
	               ")";
		//String q = "SELECT DISTINCT  Contract_no FROM jcicontract ";
		List contractNo = (List) this.sessionFactory.getCurrentSession().createSQLQuery(q).list();

		return contractNo;
	}

	@Override
	public List<String> UsernameOM_jciumt(String role) {
		// TODO Auto-generated method stub
		String q = "SELECT username from where roles_name = '" + role + "'";
		List<String> OmUsername = (List<String>) this.sessionFactory.getCurrentSession().createSQLQuery(q).list();
		//System.out.println(OmUsername);

		return OmUsername;
	}

	@Override
	public List<String> UsernameFA_jciumt(String role) {
		// TODO Auto-generated method stub
		String q = "SELECT username from where roles_name = '" + role + "'";

		List<String> FMUsername = (List<String>) this.sessionFactory.getCurrentSession().createSQLQuery(q).list();
		//System.out.println(FMUsername);

		return FMUsername;
	}

	@Override
	public List<UserRegistrationModel> getom_official() {
		// TODO Auto-generated method stub
		String rolename = "OM Role";
		String querystr = "select username from jciumt where roles_name = '" + rolename + "'";
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		SQLQuery query = session.createSQLQuery(querystr);
		List<UserRegistrationModel> rows = query.list();
		return rows;
	}

	@Override
	public List<UserRegistrationModel> getfa_official() {
		// TODO Auto-generated method stub
		String rolename = "FA Role";
		String querystr = "select username from jciumt where roles_name = '" + rolename + "'";
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		SQLQuery query = session.createSQLQuery(querystr);
		List<UserRegistrationModel> rows = query.list();
		return rows;
	}

//	@Override
//	public int CountRecord() {
//		// TODO Auto-generated method stub
//
//		    String q = "SELECT COUNT(*) FROM jciclaim_nomination";
//		  int result = (Integer) this.sessionFactory.getCurrentSession().createSQLQuery(q).uniqueResult();
//		    return result+1;
//		
//
//	}
	@Override
	public String CountRecord() {
		// TODO Auto-generated method stub

		    String q = "SELECT TOP 1 settlement_id_generated FROM jciclaim_nomination ORDER BY Settlement_id DESC";
		  String result = (String) this.sessionFactory.getCurrentSession().createSQLQuery(q).uniqueResult();
		  System.err.println(result);
		    return result;
		

	}
	@Override
	public List<Object> gradecomposition(String contractno) {
		String q = " SELECT" + "  Jcigrade_composition.Jute_combination,\r\n"
				+ "  (jcigrade_composition.Proposed_composition*jcicontract.Contract_qty)/100 as new_proposed_composition\r\n"
				+ "   FROM Jcigrade_composition  INNER JOIN  jcicontract on  jcicontract.Grade_composition=jcigrade_composition.Label_name\r\n"
				+ "  WHERE Contract_no='" + contractno + "'";
		List<Object> gradecomposition = (List<Object>) this.sessionFactory.getCurrentSession().createSQLQuery(q).list();
		return gradecomposition;

	}

	@Override
	public String getEmailForOmo(String omofficial) {
		String rolename = "OM Role";
		String q = "SELECT email FROM jciumt WHERE roles_name = '" + rolename + "' AND username = '" + omofficial + "'";
		String omoEmail = (String) this.sessionFactory.getCurrentSession().createSQLQuery(q).uniqueResult();
		// TODO Auto-generated method stub
		return omoEmail;
	}

	@Override
	public String getEmailForFA(String FAofficial) {
		// TODO Auto-generated method stub
		String rolename = "FA Role";
		String q = "SELECT email FROM jciumt WHERE roles_name = '" + rolename + "' AND username = '" + FAofficial + "'";
		String FaEmail = (String) this.sessionFactory.getCurrentSession().createSQLQuery(q).uniqueResult();
		// TODO Auto-generated method stub
		return FaEmail;

	}

	@Override
	public String getEmaiformills(String Mill) {
		String q = "select client_email from jcimilldetailmaster where client_name = '" + Mill + "'";
		String MillEmail = (String) this.sessionFactory.getCurrentSession().createSQLQuery(q).uniqueResult();

		// TODO Auto-generated method stub
		return MillEmail;
	}

	@Override
	public void claimStatusUpdate(String ContractNoForClaimStatusUpdate) {
		String Contract_Staus_Change = "Official Nomination done";
		String hql = "UPDATE jcicontract set  Contract_status = 'Official Nomination done' where Contract_no = '" + ContractNoForClaimStatusUpdate + "' ";
	    this.sessionFactory.getCurrentSession().createSQLQuery(hql).executeUpdate();
		
	}

	@Override
	public List<String> gethodi() {
		
		//String q = "select DI_no from jciDI_ho ";
		
		String q = "select DISTINCT HO_di from jcimill_receipt ";
		List millid = (List) this.sessionFactory.getCurrentSession().createSQLQuery(q).list();

		return millid;
	}



	@Override
	public List<Object[]> getchallan(String hodi) {

		///////////////////correct
		String q = 
			    "SELECT DISTINCT jcimr.challan_no, jcimr.MR_no, jcimr.Mr_date, jci.bill_of_supply_no, jcd.Date_of_shipment, jwe.Dpc_actual_wt ,jcimr.claimAmmount " +
			    "FROM jcimill_receipt jcimr " +
			    "LEFT JOIN jcibos_generation jci ON jcimr.challan_no = jci.Challan_No " +
			    "LEFT JOIN jcidispatch_details jcd ON jcimr.challan_no = jcd.Challan_no " +
			    "LEFT JOIN jciweighment_entry jwe ON jci.bill_of_supply_no = jwe.Bos_no " +
			    "WHERE jcimr.Ho_di = '" + hodi + "' " + // Assuming hodi is a variable containing some value
			    "AND NOT EXISTS (SELECT 1 FROM jciclaim_nomination WHERE jcimr.MR_no = jciclaim_nomination.Mr_number)";
		


		
//		String q = "SELECT DISTINCT jcimr.challan_no, jcimr.MR_no, jcimr.Mr_date, jci.bill_of_supply_no, jcd.Date_of_shipment, jwe.Dpc_actual_wt, jcimr.claimAmmount , jci.Bos_file_path " +
//		           "FROM jcimill_receipt jcimr " +
//		           "LEFT JOIN jcibos_generation jci ON jcimr.challan_no = jci.Challan_No " +
//		           "LEFT JOIN jcidispatch_details jcd ON jcimr.challan_no = jcd.Challan_no " +
//		           "LEFT JOIN jciweighment_entry jwe ON jci.bill_of_supply_no = jwe.Bos_no " +
//		           "WHERE jcimr.Ho_di = '" + hodi + "'";


	    List<Object[]> contractListData = (List<Object[]>) this.sessionFactory.getCurrentSession().createSQLQuery(q).list();
	    return contractListData;
	}

	@Override
	public List<Object[]> dateofInspection(String dateOfInspection) {
		String q = "select OMOfficial , FAOfficial , Mill from jciclaim_nomination where DateofInspection ='" + dateOfInspection + "'";
		List<Object[]> gradecomposition = (List<Object[]>) this.sessionFactory.getCurrentSession().createSQLQuery(q).list();
		return gradecomposition;
	}

	@Override
	public String getcontractidentification(String ContractNo) {
		String q = "select Contract_identification_no from jcicontract where Contract_no = '" + ContractNo + "'";
		String contractidentification = (String) this.sessionFactory.getCurrentSession().createSQLQuery(q).uniqueResult();

		// TODO Auto-generated method stub
		return contractidentification;
	}

	@Override
	public String getmillcode(String millname) {
		String q = "select client_unit_code from jcimilldetailchild where  unit_name = '" + millname + "'";
		String millcode = (String) this.sessionFactory.getCurrentSession().createSQLQuery(q).uniqueResult();

		// TODO Auto-generated method stub
		return millcode;
		
	}

	@Override
	public Jciclaim_NominationModel find(String id) {
		List<Jciclaim_NominationModel> result = new ArrayList<>();
		String querystr = "select DateofInspection , FAOfficial , OMOfficial , Settlement_id_generated,Mill from jciclaim_nomination where Settlement_id_generated ='" + id + "'";
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		SQLQuery query = session.createSQLQuery(querystr);
		List<Object[]> rows = query.list();		
		Jciclaim_NominationModel nominationofficial = new Jciclaim_NominationModel();
		for (Object[] row : rows) {
			String DateofInspection = (String) row[0];
			String FAOfficial = (String) row[1];
			String OMOfficial = (String) row[2];
			String id1 = (String)row[3];
			String mill =(String)row[4];
			nominationofficial.setDateofInspection(DateofInspection);
			nominationofficial.setSettlement_id_generated(id1);
			nominationofficial.setOMOfficial(OMOfficial);
			nominationofficial.setMill(mill);
			
			
		}

		return nominationofficial;
		

	}

	@Override
	public void millrecieptstatus(String mr) {
		
		int Contract_Staus_Change = 1;
		String hql = "UPDATE jcimill_receipt set  Claim_status= '"+ Contract_Staus_Change+"' where MR_no = '" + mr + "' ";
	    this.sessionFactory.getCurrentSession().createSQLQuery(hql).executeUpdate();
	}

	@Override
	public void updatefa(String id, String FAomofficial) {
		
		String hql = "UPDATE jciclaim_nomination set  FAOfficial = '"+ FAomofficial +"' where Settlement_id_generated= '" +id+ "' ";
	    this.sessionFactory.getCurrentSession().createSQLQuery(hql).executeUpdate();
	}


	@Override
	public List<Jciclaim_NominationModel> getAlldetails(String settlement_id) {

		String sqlQuery = "SELECT DISTINCT " +
                "jciclaim_nomination.Challans, " +
                "jciclaim_nomination.Mr_number, " +
                "jciclaim_nomination.Mr_Date, " +
                "jciclaim_nomination.billOfSupply_number, " +
                "jciclaim_nomination.dateofshipment, " +
                "jciclaim_nomination.shipmentquantity, " +
                "jciclaim_nomination.claimValuation, " +
                "jciclaim_nomination.Settlement_id_generated, " +
                "jcibos_generation.Bos_file_path, " +
                "jcimill_receipt.MR_qty, " +
                "jcimill_receipt.QualityPercentage " +
            "FROM jciclaim_nomination " +
            "LEFT JOIN jcibos_generation ON jciclaim_nomination.billOfSupply_number = jcibos_generation.bill_of_supply_no " +
            "LEFT JOIN jcimill_receipt ON jciclaim_nomination.Mr_number = jcimill_receipt.MR_no " +
            "WHERE jciclaim_nomination.Settlement_id_generated = '"+settlement_id+"'";

		List<Object[]> contracts = currentSession().createSQLQuery(sqlQuery).list();

		List<Jciclaim_NominationModel> list = new ArrayList<>();

		for (Object[] eleObject : contracts) {
			Jciclaim_NominationModel nomination = new Jciclaim_NominationModel();

			nomination.setChallans((String) eleObject[0]);
			nomination.setMr_number((String) eleObject[1]);
			nomination.setMr_Date((String) eleObject[2]);
			nomination.setBillOfSupply_number((String) eleObject[3]);
			nomination.setDateofshipment((String) eleObject[4]);
			nomination.setShipmentquantity((String) eleObject[5]);
			nomination.setClaimValuation((String) eleObject[6]);
			nomination.setSettlement_id_generated((String) eleObject[7]);
			nomination.setBos_file_path((String) eleObject[8]);
			nomination.setMR_qty((Double) eleObject[9]);
			nomination.setQualityPercentage((Double) eleObject[10]);
			
			
//			nomination.setOMOfficial((String) eleObject[6]);
			//nomination.setSettlement_id((Long) eleObject[7]);
			//nomination.setSettlement_id( eleObject[7]);
			list.add(nomination);

		}

		return list;

	}

	@Override
	public List<Jciclaim_NominationModel>findnominationdetails(String id) {
		
	
		String sqlQuery = "select OMOfficial , DateofInspection , Mill from jciclaim_nomination where Settlement_id_generated='"+id+"'";
		List<Object[]> contracts = currentSession().createSQLQuery(sqlQuery).list();

		List<Jciclaim_NominationModel> list = new ArrayList<>();

		for (Object[] eleObject : contracts) {
			Jciclaim_NominationModel nomination = new Jciclaim_NominationModel();

			nomination.setOMOfficial((String) eleObject[0]);
			nomination.setDateofInspection((String) eleObject[1]);
			nomination.setMill((String) eleObject[2]);
			
			list.add(nomination);

		}
		  System.err.println(list);

		return list;
	}





	@Override
	public List<ClaimSettlementReport> getNominationReportData(String settlement_id) {
	    String sqlQuery = "SELECT DISTINCT " +
	        "nom.Mill, " +
	        "nom.ContractNo, " +
	        "nom.HoDi, " +
	        "diHo.DI_Date, " +
	        "diHo.Regional_office, " +
	        "rodetails.roname, " +
	        "nom.Challans, " +
	        "nom.Mr_number, " +
	        "nom.Mr_Date, " +
	        "mill.Crop_year, " +
	        "mill.Bale_mark, " +
	        "mill.Jute_Variety, " +
	        "mill.Jute_Grade, " +
	        "mill.No_of_Bales, " +
	        "mill.Actual_qty, " +
	        "mill.MR_qty, " +
	        "mill.QualityPercentage, " +
	        "mill.MoistureContent, " +
	        "mill.DustAmt, " +
	        "mill.NCV_percentage, " +
	        "nom.Settlement_id_generated, " +
	        "nom.dateofshipment, " +
	        "dispatchdetails.Place_of_Shipment, " +
	        "jcipurchase.centername " + // Add the centername field here
	    "FROM " +
	        "jciclaim_nomination nom " +
	    "INNER JOIN " +
	        "jcimill_receipt mill ON mill.MR_no = nom.Mr_number " +
	    "INNER JOIN " +
	        "jciDI_ho diHo ON diHo.DI_no = nom.HoDi " +
	    "INNER JOIN " +
	        "jcirodetails rodetails ON rodetails.rocode = diHo.Regional_office " +
	    "INNER JOIN " +
	        "jcidispatch_details dispatchdetails ON dispatchdetails.Challan_no = nom.Challans " +
	    "INNER JOIN " +
	        "jcipurchasecenter jcipurchase ON jcipurchase.CENTER_CODE = dispatchdetails.Place_of_Shipment " +
	    "WHERE " +
	        "nom.Settlement_id_generated = '"+settlement_id+"'"; // Using the settlement_id parameter here

	    List<ClaimSettlementReport> list1 = new ArrayList<>();
	    List<Object[]> contracts = currentSession().createSQLQuery(sqlQuery).list();

	    for (Object[] eleObject : contracts) {
	        ClaimSettlementReport nomination = new ClaimSettlementReport();

	        nomination.setMillname((String) eleObject[0]);
	        nomination.setContract_no((String) eleObject[1]);
	        nomination.setDi_no((String) eleObject[2]);
	        nomination.setDi_date((String) eleObject[3]);
	        nomination.setRoCode((String) eleObject[4]);
	        nomination.setRegionName((String) eleObject[5]);
	        nomination.setChallan((String) eleObject[6]);
	        nomination.setMr_no((String) eleObject[7]);
	        nomination.setMrDate((String) eleObject[8]);
	        nomination.setCropYear((String) eleObject[9]);
	        nomination.setBale_mark((String) eleObject[10]);
	        nomination.setJuteVariety((String) eleObject[11]);
	        nomination.setGrade((String) eleObject[12]);
	        nomination.setNo_of_bales((Double) eleObject[13]);
	        nomination.setActualqty((Double) eleObject[14]);
	        nomination.setMrQty((Double) eleObject[15]);
	        nomination.setQualityPercent((Double) eleObject[16]);
	        nomination.setMoisturePercent((Double) eleObject[17]);
	        nomination.setDustAmount((Double) eleObject[18]);
	        nomination.setNcvPercentage((Double) eleObject[19]);
	        nomination.setSettlement((String) eleObject[20]);	    
	        nomination.setDateOfDespatch((String) eleObject[21]);
	        //INCREASE  THIS
	        nomination.setPlaceOfDespatch((String) eleObject[23]);
	        

	        list1.add(nomination);
	    }

	    return list1;
	}

	

}
