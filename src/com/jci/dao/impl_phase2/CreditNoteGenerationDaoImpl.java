package com.jci.dao.impl_phase2;

import static org.hamcrest.CoreMatchers.nullValue;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.itextpdf.text.pdf.PdfStructTreeController.returnType;
import com.jci.dao_phase2.CreditNoteGenerationDao;
import com.jci.model.CreditNotes;
import com.jci.model.EntryDerivativePrice;
import com.jci.model.Jciclaim_NominationModel;
import com.jci.model.settlemetCnDnModel;

@Repository
public class CreditNoteGenerationDaoImpl implements CreditNoteGenerationDao {

	@Autowired
	SessionFactory sessionFactory;

	protected Session currentSession() {
		return (Session) sessionFactory.getCurrentSession();
	}

	@Override
	public List<Object[]> getAllVerifiedWeighment() {
		String sqlString = "select a.Bill_of_supply_no ,a.Contract_no ,a.Challan_No, a.Invoice_value,a.Shipment_details , b.Nominal_wt , b.Dpc_actual_wt, b.Ro_id from "
				+ "jcibos_generation a INNER JOIN jciweighment_entry b on b.Verification_status = 1 and a.Bill_of_supply_no = b.Bos_no";

		List<Object[]> list = currentSession().createSQLQuery(sqlString).list();

		return list;
	}

	@Override
	public void create(CreditNotes creditNotes) {
		currentSession().save(creditNotes);

	}

	@Override
	public List<Object[]> getAllCreditNotes() {
		Criteria c = this.sessionFactory.getCurrentSession().createCriteria(CreditNotes.class)
				.addOrder(Order.desc("creationDate")).add(Restrictions.eq("crnStatus", 0));
		List<CreditNotes> ll = c.list();

		String sql = "SELECT Credit_note_date,  Credit_note_no,ChallanNo,SUM(BOS_qty) as bos_qty,"
				+ "  SUM(Actual_qty) as actual_qty ,SUM(Short_qty) as shrt_qty ,SUM(Credit_note_amount) as crn_amt , MAX(document) as docs, MAX(Creation_date)"
				+ " as Max_Creation_date FROM jcicredit_note WHERE Crn_status = 0 "
				+ "GROUP BY  Credit_note_date, Credit_note_no, ChallanNo ORDER BY Max_Creation_date DESC";
		return (List<Object[]>) currentSession().createSQLQuery(sql).list();
	}

	@Override
	public void chageStatusTo1(int id) {
		String sql = "update jcicredit_note set Crn_Status = 1 where Crn_id = " + id + "";
		currentSession().createSQLQuery(sql).executeUpdate();
	}

	@Override
	public int getGstCount(String gstGstCode) {
		String sql = "select count( distinct Credit_note_no) from jcicredit_note where gstCode = '" + gstGstCode
				+ "' and Crn_status = 0";
		return (int) currentSession().createSQLQuery(sql).uniqueResult();

	}

	@Override
	public List<Object[]> findDetails(String table, String contractNoString) {
		String sqlString = "select * from " + table + " where Contract_no = '" + contractNoString + "'";
		return (List<Object[]>) currentSession().createSQLQuery(sqlString).list();
	}

	@Override
	public void saveSettlementOfCnDn(settlemetCnDnModel settlemetCnDnModel) {
		currentSession().save(settlemetCnDnModel);

	}

	@Override
	public List<String> getParamenterDetails(String parameter) {
		String sqlString = "";
		if (parameter.equals("Region")) {
			sqlString = "  select distinct CONCAT(b.Ro_id, '--', c.roname) from jcibos_generation a INNER JOIN jciweighment_entry b on b.Verification_status = 1 and b.Bos_no = \r\n"
					+ "(select a.Bill_of_supply_no where a.Challan_No not in (select distinct ChallanNo from jcicredit_note where Crn_status = 0)) inner join jcirodetails c on b.Ro_id = c.rocode;\r\n"
					+ "";
		} else {
			sqlString = " select distinct(a.Contract_no) from jcibos_generation a INNER JOIN "
					+ " jciweighment_entry b on b.Verification_status = 1 and b.Bos_no = (select a.Bill_of_supply_no where "
					+ " a.Challan_No not in (select distinct ChallanNo from jcicredit_note where Crn_status = 0))";
		}

		List<String> datalist = currentSession().createSQLQuery(sqlString).list();

		return datalist;
	}

	@Override
	public List<Object[]> showFilterData(String parameter, String basedOn) {

		String sqlString = "";
		if (parameter.equals("Region")) {
			sqlString = "select a.Bill_of_supply_no,a.BOS_date,a.Contract_no ,a.Challan_No, a.Invoice_value, b.Nominal_wt , b.Dpc_actual_wt, c.Mill_name , c.DI_No , a.Ro_id , c.Mill_code,a.Bos_file_path,b.Dpc_wt_doc , c.Consignment_note from "
					+ "jcibos_generation a INNER JOIN jciweighment_entry b on b.Verification_status = 1 and b.Bos_no = (select a.Bill_of_supply_no where "
					+ " a.Challan_No not in (select distinct ChallanNo from jcicredit_note where Crn_status = 0)) and b.Ro_id = '"
					+ basedOn + "' inner JOIN jcidispatch_details c on a.Challan_No = c.Challan_no";
		} else {
			sqlString = "select a.Bill_of_supply_no,a.BOS_date ,a.Contract_no ,a.Challan_No, a.Invoice_value, b.Nominal_wt , b.Dpc_actual_wt ,c.Mill_name , c.DI_No ,a.Ro_id,c.Mill_code,a.Bos_file_path,b.Dpc_wt_doc,c.Consignment_note from  "
					+ "jcibos_generation a INNER JOIN jciweighment_entry b on b.Verification_status = 1 and b.Bos_no = (select a.Bill_of_supply_no where "
					+ " a.Challan_No not in (select distinct ChallanNo from jcicredit_note where Crn_status = 0)) and a.Contract_no = '"
					+ basedOn + "' inner JOIN jcidispatch_details c on a.Challan_No = c.Challan_no";
		}

		List<Object[]> datalist = currentSession().createSQLQuery(sqlString).list();
		return datalist;
	}

	@Override
	public double getAvgJuteValue(String challanNo) {
		String sql = "select Sum(Jute_value)/SUM(Nominal_qty) from jcidispatch_details_child where Challan_no = '"
				+ challanNo + "'";

		double result = (double) currentSession().createSQLQuery(sql).uniqueResult();
		return result;
	}

	@Override
	public List<Object[]> getShipmentDetailsByChallanNo(String challanNo) {
		String sqlString = "select  Date_of_shipment , Mode_of_shipment , Vehicle_no , Driver_name , License_no , Driver_contact from jcidispatch_details where Challan_no ='"
				+ challanNo + "'";

		List<Object[]> list = currentSession().createSQLQuery(sqlString).list();

		return list;
	}

	@Override
	public List<Object[]> getMillDetailsByCode(String millcode) {

		String sql = "SELECT  a.unit_name, a.unit_address1,  a.unit_state,   a.unit_location, b.client_gstin, b.client_pan, b.client_state, b.client_address1,  b.client_name, a.client_unit_code "
				+ " FROM  jcimilldetailchild AS a LEFT JOIN jcimilldetailmaster AS b ON a.client_code = b.client_code where a.client_unit_code='"
				+ millcode + "'";
		List<Object[]> resultList1 = (List<Object[]>) currentSession().createSQLQuery(sql).list();
		return resultList1;
	}

	@Override
	public List<Object[]> getDispatchDetails(String challanNo) {
		String sql = "select a.Crop_year,a.Bale_mark,a.Jute_grade,a.No_of_bales,a.Nominal_qty,a.Rate,a.Nominal_wt,\r\n"
				+ "   CONVERT(VARCHAR, b.Contract_date, 105) AS Contract_date,\r\n"
				+ "    CONVERT(VARCHAR, b.DI_Date, 105) AS DI_Date,\r\n"
				+ "    CONVERT(VARCHAR, b.Date_of_shipment, 105) AS Date_of_shipment ,  b.Consignment_note_text "
				+ " from  jcidispatch_details_child a INNER join jcidispatch_details b on a.Challan_no = b.Challan_no and a.Challan_no='"
				+ challanNo + "' ";
		List<Object[]> resultList1 = (List<Object[]>) currentSession().createSQLQuery(sql).list();
		return resultList1;
	}

	@Override
	public List<Object> getGradeRatio(String challanNo) {
		String sql = "SELECT Nominal_wt / (SELECT SUM(Nominal_wt) FROM jcidispatch_details_child where Challan_no = '"
				+ challanNo + "' ) FROM jcidispatch_details_child where Challan_no = '" + challanNo + "' ";

		List<Object> resultList1 = (List<Object>) currentSession().createSQLQuery(sql).list();
		return resultList1;

	}

	@Override
	public List<Object> getChallanDetails(String challan) {
		String sql = "select a.Bill_of_supply_no,a.BOS_date ,a.Contract_no ,a.Challan_No,"
				+ " a.Invoice_value, b.Nominal_wt , b.Dpc_actual_wt ,c.Mill_name , c.DI_No"
				+ "  ,a.Ro_id,c.Mill_code , c.Place_of_Shipment ,a.Statecode_forBOs, c.Contract_date , c.DI_Date,c.Date_of_shipment  from  jcibos_generation a INNER JOIN jciweighment_entry b"
				+ "  on b.Verification_status = 1 and a.Bill_of_supply_no = b.Bos_no and a.Challan_No = '" + challan
				+ "'" + " inner JOIN jcidispatch_details c on a.Challan_No = c.Challan_no";

		List<Object> resultList1 = (List<Object>) currentSession().createSQLQuery(sql).list();
		return resultList1;
	}

	@Override
	public List<Object[]> getDetailsofSpp_Con_Rec(String bosNo) {
		String sql = "select Supplier_name , Supplier_address , Supplier_gSTN , Recipient_name , "
				+ "Recipient_address , Recipient_gSTN , Consignee_name , Consignee_address ,"
				+ " Consignee_gSTN from jcibos_generation where Bill_of_supply_no = '" + bosNo + "'";
		return (List<Object[]>) currentSession().createSQLQuery(sql).list();
	}

	@Override
	public List<Object[]> getStateAndPan(String millcode) {
		String sql2 = "select a.client_pan , a.client_state , b.unit_state , c.state_name , c.gov_state_code , c.state_code from jcimilldetailmaster a \r\n"
				+ "inner join \r\n" + "jcimilldetailchild b on a.client_code = b.client_code and b.client_unit_code = '"
				+ millcode + "' " + " INNER JOIN\r\n"
				+ "  tbl_states_new c on c.state_code = a.client_state or  c.gov_state_code = b.unit_state ";

		return (List<Object[]>) currentSession().createSQLQuery(sql2).list();
	}

	@Override
	public List<Object[]> getStateAndCodeOfSupplier(String dpc) {
		String sql = "select top 1 a.state_name , a.gov_state_code , e.State_GSTIN from tbl_states_new a\r\n"
				+ "INNER join tbl_districts_new b on b.state_code = a.state_code\r\n"
				+ "INNER JOIN jcipurchasecenter c on c.district = b.dist_code \r\n"
				+ "INNER JOIN jcidispatch_details d ON c.CENTER_CODE = d.Place_of_Shipment\r\n"
				+ "INNER JOIN jcigstin e on e.State_GST_Code = a.gov_state_code " + "WHERE c.CENTER_CODE = '" + dpc
				+ "'";

		return (List<Object[]>) currentSession().createSQLQuery(sql).list();
	}

	@Override
	public int getTotalCount() {
		String sql = "select count( distinct Credit_note_no) from jcicredit_note where Crn_status = 0";
		return (int) currentSession().createSQLQuery(sql).uniqueResult();
	}

	// settlement of credit and debit notes

	@Override
	public List<String> getMillNames() {
		String sqlString = "SELECT DISTINCT CONCAT(a.client_name,'&-&', b.client_unit_code) as mill FROM jcimilldetailmaster a\r\n"
				+ "INNER JOIN jcimilldetailchild b ON a.client_code = b.client_code\r\n"
				+ "INNER JOIN jcicontract c ON c.Mill_code = b.client_unit_code\r\n"
				+ "LEFT JOIN jcicredit_note d ON d.Contract_no = c.Contract_no\r\n"
				+ "LEFT JOIN jcicredit_note_settled e ON e.Contract_no = c.Contract_no\r\n"
				+ "LEFT JOIN jcidemand_note f ON f.Contract_no = c.Contract_no\r\n"
				+ "WHERE d.Contract_no IS NOT NULL OR e.Contract_no IS NOT NULL  OR f.Contract_no IS NOT NULL;";

		return (List<String>) currentSession().createSQLQuery(sqlString).list();
	}

	@Override
	public List<String> getAllContractNos(String millCode) {
		String sql = "SELECT DISTINCT a.Contract_no from jcicontract a\r\n"
				+ "LEFT JOIN jcicredit_note d ON d.Contract_no = a.Contract_no\r\n"
				+ "LEFT JOIN jcicredit_note_settled e ON e.Contract_no = a.Contract_no\r\n"
				+ "LEFT JOIN jcidemand_note f ON f.Contract_no = a.Contract_no\r\n" + "where a.Mill_code ='" + millCode
				+ "'";
		return (List<String>) currentSession().createSQLQuery(sql).list();
	}


	

	
//	@Override
//	public List<Object[]> getFullDetailsOfCrnAndDebit(String contract) {
//	    // Define the first SQL query
//	     String sql = "SELECT DISTINCT a.Credit_note_no, a.Credit_note_amount, a.Credit_note_date, a.ChallanNo, "
//	               + "c.Consignment_note_text, d.Bill_of_supply_no, c.Date_of_shipment, "
//	               + "e.DateofInspection, e.Settlement_id_generated, d.Bos_file_path, c.DI_No, "
//	               + "c.Consignment_note, a.document "
//	               + "FROM jcicredit_note a "
//	               + "LEFT JOIN jcicredit_note_settled b ON a.ChallanNo = b.Challan_No "
//	               + "LEFT JOIN jcidispatch_details c ON c.Challan_no = a.ChallanNo "
//	               + "LEFT JOIN jcibos_generation d ON d.Challan_No = a.ChallanNo "
//	               + "LEFT JOIN jciclaimNomination e ON e.Challans = a.ChallanNo "
//	               + "WHERE b.Challan_No IS NULL "
//	               + "  AND a.Contract_no = '"+contract+"' "
//	               + "  AND a.Credit_note_no NOT IN ("
//	               + "      SELECT Credit_note_no "
//	               + "      FROM jcisettlement_cndn"
//	               + "  );";
//
//	    
//	    String sql1 = "SELECT DISTINCT f.Demand_note_no, f.Carrying_cost, f.Demand_note_date, f.DocumentName "
//                + "FROM jcidemand_note f "
//                + "WHERE f.Contract_no = '"+contract+"' "
//                + "  AND f.Demand_note_no NOT IN ("
//                + "      SELECT Credit_note_no "
//                + "      FROM jcisettlement_cndn"
//                + "  );";
//
//
//	    // Execute the first query
//	    List<Object[]> creditNoteDetails = (List<Object[]>) currentSession().createSQLQuery(sql).list();
//
//	    // Execute the second query
//	    List<Object[]> demandNoteDetails = (List<Object[]>) currentSession().createSQLQuery(sql1).list();
//
//	    // Create a list to hold the combined results
//	    List<Object[]> combinedResults = new ArrayList<>();
//
//	    // Add results from the first query
//	    for (Object[] record : creditNoteDetails) {
//	        combinedResults.add(record);
//	    }
//
//	    // Add results from the second query
//	    for (Object[] record : demandNoteDetails) {
//	        combinedResults.add(record);
//	    }
//
//	    // Return the combined results
//	    return combinedResults;
//	}
//
//	

	@Override
	public List<Object[]> getFullDetailsOfCrnAndDebit(String contract) {
	    // Define the first SQL query
	     String sql =  "SELECT DISTINCT a.Credit_note_no, "
	               + "SUM(a.Credit_note_amount) AS Credit_note_amount, "
	               + "a.Credit_note_date, "
	               + "a.ChallanNo, "
	               + "c.Consignment_note_text, "
	               + "d.Bill_of_supply_no, "
	               + "c.Date_of_shipment, "
	               + "e.DateofInspection, "
	               + "e.Settlement_id_generated, "
	               + "d.Bos_file_path, "
	               + "c.DI_No, "
	               + "c.Consignment_note, "
	               + "a.document "
	               + "FROM jcicredit_note a "
	               + "LEFT JOIN jcicredit_note_settled b ON a.ChallanNo = b.Challan_No "
	               + "LEFT JOIN jcidispatch_details c ON c.Challan_no = a.ChallanNo "
	               + "LEFT JOIN jcibos_generation d ON d.Challan_No = a.ChallanNo "
	               + "LEFT JOIN jciclaimNomination e ON e.Challans = a.ChallanNo "
	               + "WHERE b.Challan_No IS NULL "
	               + "  AND a.Contract_no = '"+contract+"' "
	               + "  AND a.Credit_note_no NOT IN ("
	               + "      SELECT Credit_note_no "
	               + "      FROM jcisettlement_cndn"
	               + "  ) "
	               + "GROUP BY a.Credit_note_no, "
	               + "         a.Credit_note_date, "
	               + "         a.ChallanNo, "
	               + "         c.Consignment_note_text, "
	               + "         d.Bill_of_supply_no, "
	               + "         c.Date_of_shipment, "
	               + "         e.DateofInspection, "
	               + "         e.Settlement_id_generated, "
	               + "         d.Bos_file_path, "
	               + "         c.DI_No, "
	               + "         c.Consignment_note, "
	               + "         a.document";

	    
	    String sql1 = "SELECT f.Demand_note_no, "
                + "       SUM(f.Carrying_cost) AS Total_Carrying_cost, "
                + "       f.Demand_note_date, "
                + "       f.DocumentName "
                + "FROM jcidemand_note f "
                + "WHERE f.Contract_no = '"+contract+"' "
                + "  AND f.Demand_note_no NOT IN ("
                + "      SELECT Credit_note_no "
                + "      FROM jcisettlement_cndn "
                + "  ) "
                + "GROUP BY f.Demand_note_no, f.Demand_note_date, f.DocumentName";


	    // Execute the first query
	    List<Object[]> creditNoteDetails = (List<Object[]>) currentSession().createSQLQuery(sql).list();

	    // Execute the second query
	    List<Object[]> demandNoteDetails = (List<Object[]>) currentSession().createSQLQuery(sql1).list();

	    // Create a list to hold the combined results
	    List<Object[]> combinedResults = new ArrayList<>();

	    // Add results from the first query
	    for (Object[] record : creditNoteDetails) {
	        combinedResults.add(record);
	    }

	    // Add results from the second query
	    for (Object[] record : demandNoteDetails) {
	        combinedResults.add(record);
	    }

	    // Return the combined results
	    return combinedResults;
	}

	


	@Override
	public List<settlemetCnDnModel> getAll() {
	
		
		  String sqlQuery = "SELECT Contract_no, Credit_note_no, bosNo, "
	            + "consigneeNoteText, creditNoteAmount,  dateOfInspection, "
	            + "dateOfIssue, dateOfShipment, hodi, settlementId , cndnExcel_link, IdentificationCnDn ,AmountDiffCnAndDn FROM jcisettlement_cndn";
		List<Object[]> contracts = currentSession().createSQLQuery(sqlQuery).list();

		List<settlemetCnDnModel> list = new ArrayList<>();

		for (Object[] result : contracts) {
			settlemetCnDnModel settlementCnDn = new settlemetCnDnModel();
			String difference = String.valueOf(result[12]);
			settlementCnDn.setContractNo((String) result[0]);
	        settlementCnDn.setCreditNoteNo((String) result[1]);
	        settlementCnDn.setBosNo((String) result[2]);
	        settlementCnDn.setConsigneeNoteText((String) result[3]);
	        settlementCnDn.setCreditNoteAmount((String) result[4]);
	        settlementCnDn.setDateOfInspection((String) result[5]);
	        settlementCnDn.setDateOfIssue((String) result[6]);
	        settlementCnDn.setDateOfShipment((String) result[7]);
	        settlementCnDn.setHodi((String) result[8]);
	        settlementCnDn.setSettlementId((String) result[9]);
	        settlementCnDn.setCndnExcel_link((String) result[10]);
	        settlementCnDn.setIdentificationCnDn((String)result[11]);
	        settlementCnDn.setBosDoc(difference);
			list.add(settlementCnDn);

		}

		return list;
		
	
	}

	@Override
	public String CountRecord() {
		
		
		String q = "SELECT MAX(RowNumber) AS LastRowNumber FROM jcisettlement_cndn";
		
		 String result = (String) this.sessionFactory.getCurrentSession().createSQLQuery(q).uniqueResult();
		  System.err.println(result);
		    return result;
		
	}
//	

}
