package com.jci.dao.impl_phase2;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.itextpdf.text.pdf.PdfStructTreeController.returnType;
import com.jci.dao_phase2.CreditNoteClaimSettlementDao;
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

		String sql = "select distinct Settlement_id from jciclaim_report_mill where Dispute_flag = 2";
		return (List<String>) currentSession().createSQLQuery(sql).list();
	}

	@Override
	public List<Object[]> viewAllChallan(String settlementId) {
		String sql = "select  c.MR_no, c.Mr_date , a.Challan_No , b.Bill_of_supply_no, c.Jute_Variety , c.Jute_Grade, c.MR_qty , a.Quality_settlement , a.Moisture_settlement , a.Ncv_settlement , a.Dust_settlement , a.Claim_Amount , a.Settlement_amt from jciclaim_report_mill a "
				+ "inner join jcibos_generation b  on a.Challan_No = b.Challan_No "
				+ "inner join jcimill_receipt c  on b.Challan_No = c.Challan_no and a.Settlement_id = '" + settlementId
				+ "'";

		return (List<Object[]>) currentSession().createSQLQuery(sql).list();
	}

	@Override
	public List<String> getDistinctChallanForSettlemtId(String settlementId) {
		String sql = "select distinct Challan_No from jciclaim_report_mill where Settlement_id = '" + settlementId
				+ "' and Dispute_flag = 2";

		return (List<String>) currentSession().createSQLQuery(sql).list();
	}

	@Override
	public List<Object[]> viewFullChallanDetails(String challan) {
		String sql = "select a.Bill_of_supply_no,a.BOS_date ,a.Contract_no ,a.Challan_No , c.MR_no , b.Created_on , \r\n"
				+ "c.Bale_mark ,c.Jute_Variety,c.Jute_Grade, c.No_of_Bales , c.Actual_qty  ,d.Rate , c.QualityPercentage,c.MoistureContent,\r\n"
				+ "c.NCV_percentage,c.DustQty,b.Quality_settlement,b.Moisture_settlement,b.Ncv_settlement,b.Dust_settlement , b.Claim_Amount from jcibos_generation a \r\n"
				+ "inner join jciclaim_report_mill b on a.Challan_No = b.Challan_No\r\n"
				+ " inner join jcimill_receipt c on b.Challan_No = c.Challan_no and c.Challan_no = '" + challan + "'"
				+ " inner join jcidispatch_details_child d on d.Challan_no = c.Challan_no\r\n";
				
		return (List<Object[]>) currentSession().createSQLQuery(sql).list();
	}

}
