package com.jci.dao.impl_phase2;

import java.math.BigDecimal;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.jci.dao_phase2.ConfirmationClaimSettlementDao;
import com.jci.model.CashDocumentModel;
import com.jci.model.ConfirmationClaimSettlementModel;

@Repository
@Transactional
public class ConfirmationClaimSettlementDaoImpl implements ConfirmationClaimSettlementDao {
	@Autowired
	SessionFactory sessionFactory;

	protected Session currentSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public void create(ConfirmationClaimSettlementModel confirmationClaimSettlementModel) {
	
		currentSession().save(confirmationClaimSettlementModel);
	}

	@Override
	public List<ConfirmationClaimSettlementModel> getAll() {
		Criteria criteria = currentSession().createCriteria(ConfirmationClaimSettlementModel.class);
		criteria.addOrder(Order.desc("Created_on"));
		return criteria.list();
	}

	@Override
	public List<Object[]> SettlementId(String username) {
		String sql = "SELECT DISTINCT nom.Settlement_id_generated \r\n"
				+ "FROM jciclaim_nomination nom\r\n"
				+ "LEFT JOIN jciclaim_report_mill rep ON nom.Settlement_id_generated = rep.Settlement_id\r\n"
				+ "WHERE nom.OMOfficial ='"+username+"'AND (rep.Settlement_id IS NULL OR rep.Dispute_flag=1);";

		List<Object[]> resultList1 = (List<Object[]>) this.sessionFactory.getCurrentSession().createSQLQuery(sql).list();
		return resultList1;
	}

	@Override
	public List<Object[]> gradecfetchingdata1omposition(String contractno) {
		String q = "  SELECT     Jcigrade_composition.Jute_combination,\r\n"
				+ "                      (jcigrade_composition.Proposed_composition*jcicontract.Contract_qty)/100 as new_proposed_composition\r\n"
				+ "                     FROM Jcigrade_composition  INNER JOIN  jcicontract on  jcicontract.Grade_composition=jcigrade_composition.Label_name\r\n"
				+ "                    WHERE Contract_no='" + contractno + "';";
		List<Object[]> gradecomposition = (List<Object[]>) this.sessionFactory.getCurrentSession().createSQLQuery(q)
				.list();
		return gradecomposition;

	}

//	
	@Override
	public List<Object[]> fetchdataofclaim(String st) {
		String sql = " select jcimill_receipt.Mr_no,jcimill_receipt.Mr_date,jcimill_receipt.Jute_Variety,jcimill_receipt.Jute_Grade,jcimill_receipt.Actual_qty,jcimill_receipt.QualityPercentage,jcimill_receipt.MoistureContent,jcimill_receipt.NCV_percentage,jcidispatch_details_child.No_of_bales,jcidispatch_details_child.Rate,jcimill_receipt.Crop_year,jcimill_receipt.NCV_qty,jcimill_receipt.Challan_no,jciclaim_nomination.ContractNo,jciclaim_nomination.DateofInspection,jciclaim_nomination.Mill,jciclaim_nomination.Mr_number,jciclaim_nomination.Mr_Date from jcimill_receipt left  join jcidispatch_details_child on jcimill_receipt.Jute_Grade = jcidispatch_details_child.Jute_grade inner join jciclaim_nomination on jciclaim_nomination.Challans = jcimill_receipt.Challan_no   WHERE jciclaim_nomination.Settlement_id_generated =  '"+ st + "'";
		List<Object[]> resultList1 = (List<Object[]>) this.sessionFactory.getCurrentSession().createSQLQuery(sql)
				.list();
		return resultList1;
	}

//	@Override
//	public List<Object[]>fetchdataofclaim( String st) {
//		String sql =" select a.MR_no,a.Bale_mark,a.Crop_year,a.Quality_claim,a.MoistureContent,a.NCV_percentage,a.Challan_no,b.Contract_qty,b.Grade_composition from jcicontract as b left join jcimill_receipt  as a on a.HO_di =b.Contract_no WHERE HO_di =  '" +st+"'"; 
//		  		 List<Object[]>resultList1= (List<Object[]>)this.sessionFactory.getCurrentSession().createSQLQuery(sql).list();
//		    return resultList1;
//		}

	@Override
	public List<Object[]> fetchdatasttlement(String st) {
		String sql = " select top 1 DateofInspection ,Mill from jciclaim_nomination WHERE ContractNo = '"
				+ st + "' order by Created_on DESC";
		List<Object[]> resultList1 = (List<Object[]>) this.sessionFactory.getCurrentSession().createSQLQuery(sql)
				.list();
		System.err.println(resultList1);
		return resultList1;
	}

	@Override
	public List<String> fetchContract(String settlementId) {
		// TODO Auto-generated method stub
		String sqlString = "Select DISTINCT ContractNo from jciclaim_nomination where Settlement_id_generated='" + settlementId + "';";
		List<String> resultList1 = (List<String>) this.sessionFactory.getCurrentSession().createSQLQuery(sqlString)
				.list();
		return resultList1;
	}

	@Override
	public List<Object[]> fetchChallan(String id) {
		String string ="Select Distinct Challans from jciclaim_nomination where ContractNo='"+id+"';";
		List<Object[]> resultList1 = (List<Object[]>) this.sessionFactory.getCurrentSession().createSQLQuery(string)
				.list();;
		return resultList1;
	}

	@Override


    public String fetchPrice(String var, String gr, String Challan, String cropyear,String contract) {
           // TODO Auto-generated method stub
           String resultString = "SELECT jcientry_derivative_price." + gr + "\n"
                   + "FROM jcientry_derivative_price\n"
                   + "INNER JOIN jcicontract ON jcientry_derivative_price.delivery_type = jcicontract.Delivery_type\n"
                   + "INNER JOIN jcipurchasecenter ON jcipurchasecenter.district = jcientry_derivative_price.district\n"
                   + "INNER JOIN jcidispatch_details ON jcidispatch_details.Challan_no = '" + Challan + "'\n"
                   + "WHERE jcipurchasecenter.CENTER_CODE = jcidispatch_details.Place_of_Shipment\n"
                   + "AND jcicontract.Contract_no = '" + contract + "'\n"
                   + "AND jcientry_derivative_price.crop_year = '" + cropyear + "'\n"
                   + "AND jcientry_derivative_price.jute_variety = '" + var + "'";


           // Execute the query without casting to String
           BigDecimal result = (BigDecimal) this.sessionFactory.getCurrentSession().createSQLQuery(resultString).uniqueResult();
           return result.toString(); // Convert BigDecimal to String
//Return the result without casting to String

    }

	@Override
	public List<Object[]> getSettlementData(String username) {
		// TODO Auto-generated method stub
		
		 String resultString= "Select jciclaim_report_mill.Settlement_id,jciclaim_report_mill.Challan_No,jciclaim_report_mill.Contract_No,jciclaim_report_mill.Date_of_Inspection,jciclaim_report_mill.Inspection_by,jciclaim_report_mill.Mill,jciclaim_report_mill.Moisture_settlement,jciclaim_report_mill.Ncv_settlement,jciclaim_report_mill.Quality_settlement,jciclaim_report_mill.Settlement_amt,jciclaim_report_mill.Dust_settlement,jciclaim_report_mill.Dispute_flag,jciclaim_report_mill.Claim_Amount,jciclaim_nomination.HoDi from jciclaim_report_mill INNER JOIN jciclaim_nomination on jciclaim_nomination.Settlement_id_generated = jciclaim_report_mill.Settlement_id where jciclaim_nomination.FAOfficial='"+username+"';";
		 List<Object[]> resultList1 = (List<Object[]>) this.sessionFactory.getCurrentSession().createSQLQuery(resultString)
					.list();
			System.err.println(resultList1);
			return resultList1;
	
	}

	@Override
	public void acceptClaim(String challan,String username,String filename) {
		// TODO Auto-generated method stub
		String resultString ="Update jciclaim_report_mill SET Dispute_flag=2 ,FA_Official='"+username+"',FA_doc='"+filename+"' where Settlement_id='"+challan+"';";
		currentSession().createSQLQuery(resultString).executeUpdate();
		return;
	}

	@Override
	public void rejectClaim(String challan, String username) {
		// TODO Auto-generated method stub
		String resultString ="Update jciclaim_report_mill SET Dispute_flag=1 ,FA_Official='"+username+"' where Settlement_id='"+challan+"';";
		currentSession().createSQLQuery(resultString).executeUpdate();
		return;
	}




}
