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
	public int getCountRO(String ro) {
		String sql = "select Count(Crn_id) from jcicredit_note where Ro_Id = '" + ro + "'";
		return (int) currentSession().createSQLQuery(sql).uniqueResult();

	}

	@Override
	public List<Object[]> getAllMillsOfContracts() {
		String sqlString = "select a.Mill_code , a.Mill_name, a.Contract_no from jcicontract a  where  a.Contract_no in  (SELECT Contract_no FROM jcicredit_note UNION  SELECT Contract_no FROM jcidemand_note )";

		return (List<Object[]>) currentSession().createSQLQuery(sqlString).list();
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
			sqlString = " select distinct(b.Ro_id) from jcibos_generation a INNER JOIN "
					+ " jciweighment_entry b on b.Verification_status = 1 and b.Bos_no = (select a.Bill_of_supply_no where "
					+ " a.Challan_No not in (select distinct ChallanNo from jcicredit_note where Crn_status = 0))";
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
		String sql = "select Crop_year,Bale_mark,Jute_grade,No_of_bales,Nominal_qty,Rate,Nominal_wt from  jcidispatch_details_child where  Challan_no='"
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
				+ "  ,a.Ro_id,c.Mill_code , c.Place_of_Shipment ,a.Statecode_forBOs from  jcibos_generation a INNER JOIN jciweighment_entry b"
				+ "  on b.Verification_status = 1 and a.Bill_of_supply_no = b.Bos_no and a.Challan_No = '" + challan
				+ "'" + " inner JOIN jcidispatch_details c on a.Challan_No = c.Challan_no";

		List<Object> resultList1 = (List<Object>) currentSession().createSQLQuery(sql).list();
		return resultList1;
	}

	@Override
	public List<Object[]> getDetailsofSpp_Con_Rec(String bosNo) {
		String sql = "select Supplier_name , Supplier_address , Supplier_gSTN , Recipient_name , "
				+ "Recipient_address , Recipient_gSTN , Consignee_name , Consignee_address ,"
				+ " Consignee_gSTN from jcibos_generation where Bill_of_supply_no = '"
				+ bosNo + "'";		
		return (List<Object[]>) currentSession().createSQLQuery(sql).list();
	}

	@Override
	public List<Object[]> getStateAndPan(String millcode) {
		String sql2 = "select a.client_pan , a.client_state , b.unit_state , c.state_name , c.gov_state_code , c.state_code from jcimilldetailmaster a \r\n"
				+ "inner join \r\n"
				+ "jcimilldetailchild b on a.client_code = b.client_code and b.client_unit_code = '" + millcode + "' "
				+ " INNER JOIN\r\n"
				+ "  tbl_states_new c on c.state_code = a.client_state or  c.gov_state_code = b.unit_state ";
		
		
		return (List<Object[]>) currentSession().createSQLQuery(sql2).list();
	}

	@Override
	public List<Object[]> getStateAndCodeOfSupplier(String dpc) {
		String sql = "select top 1 a.state_name , a.gov_state_code , e.State_GSTIN from tbl_states_new a\r\n"
				+ "INNER join tbl_districts_new b on b.state_code = a.state_code\r\n"
				+ "INNER JOIN jcipurchasecenter c on c.district = b.dist_code \r\n"
				+ "INNER JOIN jcidispatch_details d ON c.CENTER_CODE = d.Place_of_Shipment\r\n"
				+ "INNER JOIN jcigstin e on e.State_GST_Code = a.gov_state_code "
				+ "WHERE c.CENTER_CODE = '" + dpc + "'";
		
		return (List<Object[]>) currentSession().createSQLQuery(sql).list();
	}

}
