package com.jci.dao.impl_phase2;

import java.math.BigDecimal;
import java.util.ArrayList;

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
import com.jci.model.Contractgeneration;
import com.jci.model.EntryPaymentDetailsModel;
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
		String sqlQuery = "select distinct Settlement_id_generated, Created_on, DateofInspection, Mill, ContractNo, HoDi, OMOfficial, FAOfficial from jciclaim_nomination";
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
		
	
//	@Override
//	public List<Jciclaim_NominationModel> getAll() {
//	    String hql = "FROM Jciclaim_NominationModel";
//	    Query query = this.sessionFactory.getCurrentSession().createQuery(hql);
//	    List<Jciclaim_NominationModel> resultList = ((Object) query).getResultList();
//	    return resultList;
//	}
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
		// TODO Auto-generated method stub
		
		
		String q = "SELECT DISTINCT unit_name " +
		           "FROM jcimilldetailchild " +
		           "RIGHT JOIN jcimill_receipt ON jcimilldetailchild.client_unit_code = jcimill_receipt.Mill_id;";


		
		List millid = (List) this.sessionFactory.getCurrentSession().createSQLQuery(q).list();

		return millid;
	}


	@Override
	public List<Object> FetchMillReceiptData(String millid) {
		// TODO Auto-generated method stub

		

//		
		String q = "SELECT DISTINCT " +
		           "jcimill_receipt.Challan_no, jcimill_receipt.MR_no, jcimill_receipt.Bale_mark, jcimill_receipt.Crop_year, " +
		           "jcimill_receipt.Quality_claim, jcimill_receipt.MoistureContent, jcimill_receipt.NCV_percentage, jcimilldetailchild.unit_name " +
		           "FROM jcimill_receipt " +
		           "LEFT JOIN jcimilldetailchild ON jcimill_receipt.Mill_id = jcimilldetailchild.client_unit_code " +
		           "WHERE jcimilldetailchild.unit_name = '" + millid + "'";

		List<Object> ContractListData = (List<Object>) this.sessionFactory.getCurrentSession().createSQLQuery(q).list();
		//System.out.println(ContractListData);

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

	@Override
	public int CountRecord() {
		// TODO Auto-generated method stub

		String q = "SELECT COUNT(*) FROM jciclaim_nomination";
		int total = (Integer) this.sessionFactory.getCurrentSession().createSQLQuery(q).uniqueResult();
		if (total > 0)
			return total;
		else
			return 0;

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
//	    String q = 
//	        "SELECT DISTINCT jcimr.challan_no, jcimr.MR_no, jcimr.Mr_date, jci.bill_of_supply_no, jcd.Date_of_shipment, jwe.Dpc_actual_wt " +
//	        "FROM jcimill_receipt jcimr " +
//	        "LEFT JOIN jcibos_generation jci ON jcimr.challan_no = jci.Challan_No " +
//	        "LEFT JOIN jcidispatch_details jcd ON jcimr.challan_no = jcd.Challan_no " +
//	        "LEFT JOIN jciweighment_entry jwe ON jci.bill_of_supply_no = jwe.Bos_no " +
//	        "WHERE jcimr.Ho_di = '" + hodi + "'";
		
		///////////////////correct
		String q = 
			    "SELECT DISTINCT jcimr.challan_no, jcimr.MR_no, jcimr.Mr_date, jci.bill_of_supply_no, jcd.Date_of_shipment, jwe.Dpc_actual_wt " +
			    "FROM jcimill_receipt jcimr " +
			    "LEFT JOIN jcibos_generation jci ON jcimr.challan_no = jci.Challan_No " +
			    "LEFT JOIN jcidispatch_details jcd ON jcimr.challan_no = jcd.Challan_no " +
			    "LEFT JOIN jciweighment_entry jwe ON jci.bill_of_supply_no = jwe.Bos_no " +
			    "WHERE jcimr.Ho_di = '" + hodi + "' " + // Assuming hodi is a variable containing some value
			    "AND NOT EXISTS (SELECT 1 FROM jciclaim_nomination WHERE jcimr.MR_no = jciclaim_nomination.Mr_number)";
//		String q = 
//			    "SELECT DISTINCT jcimr.challan_no, jcimr.MR_no, jcimr.Mr_date, jcd.Date_of_shipment " +
//			    "FROM jcimill_receipt jcimr " +
//			    
//			    "LEFT JOIN jcidispatch_details jcd ON jcimr.challan_no = jcd.Challan_no " +
//			  
//			    "WHERE jcimr.Ho_di = '" + hodi + "' " + // Assuming hodi is a variable containing some value
//			    "AND NOT EXISTS (SELECT 1 FROM jciclaim_nomination WHERE jcimr.MR_no = jciclaim_nomination.Mr_number)";


	    List<Object[]> contractListData = (List<Object[]>) this.sessionFactory.getCurrentSession().createSQLQuery(q).list();
	    return contractListData;
	}

	@Override
	public List<Object[]> dateofInspection(String dateOfInspection) {
		String q = "select OMOfficial , FAOfficial from jciclaim_nomination where DateofInspection ='" + dateOfInspection + "'";
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
		String querystr = "select DateofInspection , FAOfficial , OMOfficial , Settlement_id_generated from jciclaim_nomination where Settlement_id_generated ='" + id + "'";
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
			nominationofficial.setDateofInspection(DateofInspection);
			nominationofficial.setSettlement_id_generated(id1);
			
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
		String sqlQuery = "select distinct Challans ,Mr_number ,Mr_Date , billOfSupply_number ,dateofshipment ,shipmentquantity from jciclaim_nomination Where Settlement_id_generated='"+settlement_id+"'";
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
//			nomination.setOMOfficial((String) eleObject[6]);
			//nomination.setSettlement_id((Long) eleObject[7]);
			//nomination.setSettlement_id( eleObject[7]);
			list.add(nomination);

		}

		return list;

	}




	

}
