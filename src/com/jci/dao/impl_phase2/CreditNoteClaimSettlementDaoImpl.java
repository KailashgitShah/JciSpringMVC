package com.jci.dao.impl_phase2;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.itextpdf.text.pdf.PdfStructTreeController.returnType;
import com.jci.dao_phase2.CreditNoteClaimSettlementDao;
import com.jci.model.CreditNoteSettled;
import com.jci.service_phase2.CreditNoteClaimSettlementService;

@Repository
public class CreditNoteClaimSettlementDaoImpl implements CreditNoteClaimSettlementDao {

	@Autowired
	SessionFactory sessionFactory;

	protected Session currentSession() {
		return (Session) sessionFactory.getCurrentSession();
	}

	@Override
	public List<String> getAllSettlementId() {

		String sql = "select distinct Settlement_id from jciclaim_report_mill where Mill_Acc = 2";
		return (List<String>) currentSession().createSQLQuery(sql).list();
	}

	@Override
	public List<Object[]> viewAllChallan(String settlementId) {
		  String sqlQuery = " SELECT Distinct\r\n"
                  + "    nom.Mill,\r\n"
                  + "    nom.ContractNo,\r\n"
                  + "    nom.HoDi,\r\n"
                  + "    diHo.DI_Date,\r\n"
                  + "    diHo.Regional_office,\r\n"
                  + "    rodetails.roname,\r\n"
                  + "    nom.Challans,\r\n"
                  + "    nom.Mr_number,\r\n"
                  + "    nom.Mr_Date,\r\n"
                  + "    mill.Crop_year,\r\n"
                  + "    mill.Bale_mark,\r\n"
                  + "    mill.Jute_Variety,\r\n"
                  + "    mill.Jute_Grade,\r\n"
                  + "    mill.No_of_Bales,\r\n"
                  + "    mill.Actual_qty,\r\n"
                  + "    mill.MR_qty,\r\n"
                  + "    mill.QualityPercentage,\r\n"
                  + "    mill.MoistureContent,\r\n"
                  + "    mill.DustAmt,\r\n"
                  + "    mill.NCV_percentage,\r\n"
                  + "    nom.Settlement_id_generated,\r\n"
                  + "    nom.dateofshipment,\r\n"
                  + "    dispatchdetails.Place_of_Shipment,\r\n"
                  + "    jcipurchase.centername,\r\n"
                  + "    claim_report.Quality_settlement,\r\n"
                  + "    claim_report.Moisture_settlement,\r\n"
                  + "    claim_report.Ncv_settlement,\r\n"
                  + "    claim_report.Dust_settlement,\r\n"
                  +" claim_report.FA_doc,\r\n "
                  + "    claim_report.Claim_Amount,\r\n"
                  + "    claim_report.Settlement_amt,\r\n"
                  + "     CONVERT(varchar(10), claim_report.Date_of_Inspection, 103) AS Formatted_Date_of_Inspection\r\n"
                  + "FROM\r\n"
                  + "    jciclaimNomination nom\r\n"
                  + "INNER JOIN\r\n"
                  + "    jcimill_receipt mill ON mill.MR_no = nom.Mr_number\r\n"
                  + "INNER JOIN\r\n"
                  + "    jciDI_ho diHo ON diHo.DI_no = nom.HoDi\r\n"
                  + "INNER JOIN\r\n"
                  + "    jcirodetails rodetails ON rodetails.rocode = diHo.Regional_office\r\n"
                  + "INNER JOIN\r\n"
                  + "    jcidispatch_details dispatchdetails ON dispatchdetails.Challan_no = nom.Challans\r\n"
                  + "INNER JOIN\r\n"
                  + "    jcipurchasecenter jcipurchase ON jcipurchase.CENTER_CODE = dispatchdetails.Place_of_Shipment\r\n"
                  + "INNER JOIN\r\n"
                  + "    jciclaim_report_mill claim_report ON nom.Settlement_id_generated = claim_report.Settlement_id\r\n"
                  + "WHERE\r\n"
                  + "    nom.Settlement_id_generated = '"+ settlementId +"'\r\n"
                  + "    AND claim_report.Jute_Grade=mill.Jute_Grade AND mill.Jute_Variety=claim_report.Jute_Variety AND claim_report.Mill_Acc='2';";

				
		return (List<Object[]>) currentSession().createSQLQuery(sqlQuery).list();
	}

	@Override
	public List<String> getDistinctChallanForSettlemtId(String settlementId) {
		String sql = "select distinct Challan_No from jciclaim_report_mill where Settlement_id = '" + settlementId
				+ "' and Mill_Acc = 2";

		return (List<String>) currentSession().createSQLQuery(sql).list();
	}

	@Override
	public List<Object[]> viewFullChallanDetails(String challan) {
		String sql ="select c.Bale_mark ,c.Jute_Variety,c.Jute_Grade, c.No_of_Bales , c.Actual_qty ,\r\n"
				+ "b.Quality_settlement,b.Moisture_settlement,b.Ncv_settlement,b.Dust_settlement,\r\n"
				+ "c.QualityPercentage, c.MoistureContent,c.NCV_percentage,c.DustQty,b.Claim_Amount,\r\n"
				+ "a.Bill_of_supply_no , a.BOS_date ,a.Contract_no ,a.Challan_No , c.MR_no , b.Created_on,c.Mill_id,e.Place_of_Shipment,e.DI_No,convert(date,e.DI_Date, 105) as di_date, convert(date, e.Contract_date, 105) as contract_date , convert(date , e.Creation_date, 105) as challan_date , \r\n"
				+ "a.Statecode_forBOs , CONCAT(a.Ro_id ,'--' , g.roname ) as ro_name , CONCAT(e.Place_of_Shipment , '--' , f.centername) as dpc,\r\n"
				+ "convert(date , b.Created_on, 105) as claim_date , c.MR_no , d.Crop_year , convert(date , c.Mr_date, 105) , e.Consignment_note_text \r\n"
				+ "from jcibos_generation a\r\n"
				+ "inner join jciclaim_report_mill b on a.Challan_No = b.Challan_No \r\n"
				+ "inner join jcimill_receipt c on b.Challan_No = c.Challan_no and c.Challan_no ='" + challan + "' and c.Jute_Grade = b.Jute_Grade and c.Jute_Variety = b.Jute_Variety\r\n"
				+ "inner join jcidispatch_details_child d on d.Challan_no = c.Challan_no and c.Jute_Grade = d.Jute_grade and c.Jute_Variety = d.Jute_variety\r\n"
				+ "inner join jcidispatch_details e on e.Challan_no = d.Challan_no\r\n"
				+ "inner join jcipurchasecenter f on f.CENTER_CODE = e.Place_of_Shipment\r\n"
				+ "inner join jcirodetails g on g.rocode = a.Ro_id";
				
		return (List<Object[]>) currentSession().createSQLQuery(sql).list();
	}

	@Override
	public List<String> getDistinctChallanOfSettlementId(String settlementId) {
		
		String sql = "select distinct a.Challan_No from jciclaim_report_mill a \r\n"
				+ "inner join jcibos_generation b  on a.Challan_No = b.Challan_No \r\n"
				+ "inner join jcimill_receipt c on b.Challan_No = c.Challan_no and a.Settlement_id = '" + settlementId + "'"; 
	   
	   return (List<String>)currentSession().createSQLQuery(sql).list();
	}

	@Override
	public int getTotalCount() {
		String sql = "select count( distinct Credit_note_no) from jcicredit_note_settled where Crn_status = 0";
		return (int) currentSession().createSQLQuery(sql).uniqueResult();
	}
	
	@Override
	public int getGstCount(String gstGstCode) {
		String sql = "select count( distinct Credit_note_no) from jcicredit_note_settled where gstCode = '" + gstGstCode + "' and Crn_status = 0";
		return (int) currentSession().createSQLQuery(sql).uniqueResult();

	}

	@Override
	public void updateContractStatus(String contractNo) {
		String sql = "update jcicontract set Contract_status = 'Credit Note Settled' where Contract_no = '" + contractNo + "'";
		currentSession().createSQLQuery(sql).executeUpdate();
		
	}

	@Override
	public void saveCreditNoteSettled(CreditNoteSettled creditNoteSettled) {
		currentSession().save(creditNoteSettled);
		
	}

	@Override
	public List<Object[]> getAllCreditNoteSettlement() {
		String sql = "select * from jcicredit_note_settled"; 
		return (List<Object[]>)currentSession().createSQLQuery(sql).list();
	}

}
