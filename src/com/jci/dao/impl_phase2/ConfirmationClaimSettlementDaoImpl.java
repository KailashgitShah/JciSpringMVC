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
	public List<Object[]> SettlementId() {
		String sql = "SELECT DISTINCT nom.Settlement_id_generated \r\n"
				+ "FROM jciclaim_nomination nom\r\n"
				+ "LEFT JOIN jciclaim_report_mill rep ON nom.Settlement_id_generated = rep.Settlement_id\r\n"
				+ "WHERE rep.Settlement_id IS NULL;";
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
		String sql = " select jcimill_receipt.Mr_no,jcimill_receipt.Mr_date,jcimill_receipt.Jute_Variety,jcimill_receipt.Jute_Grade,jcimill_receipt.Actual_qty,jcimill_receipt.QualityPercentage,jcimill_receipt.MoistureContent,jcimill_receipt.NCV_percentage,jcidispatch_details_child.No_of_bales,jcidispatch_details_child.Rate,jcimill_receipt.Crop_year,jcimill_receipt.NCV_qty from jcimill_receipt inner join jcidispatch_details_child on jcimill_receipt.Jute_Grade = jcidispatch_details_child.Jute_grade  WHERE jcimill_receipt.Challan_no = '"+ st + "'";
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
	public String fetchPrice(String var, String gr, String dpcId, String cropyear,String contract) {
		// TODO Auto-generated method stub
		String resultString = "SELECT jcientry_derivative_price." + gr + "\r\n"
		        + "FROM jcientry_derivative_price \r\n"
		        + "INNER JOIN jcicontract ON jcientry_derivative_price.delivery_type = jcicontract.Delivery_type \r\n"
		        + "INNER JOIN jcipurchasecenter ON jcipurchasecenter.district = jcientry_derivative_price.district \r\n"
		        + "WHERE jcipurchasecenter.CENTER_CODE='" + dpcId + "' \r\n"
		        + "AND jcicontract.Contract_no='" + contract + "' \r\n"
		        + "AND jcientry_derivative_price.crop_year='" + cropyear + "' \r\n"
		        + "AND jcientry_derivative_price.jute_variety='" + var + "'";

		// Execute the query without casting to String
		BigDecimal result = (BigDecimal) this.sessionFactory.getCurrentSession().createSQLQuery(resultString).uniqueResult();
		return result.toString(); // Convert BigDecimal to String
 // Return the result without casting to String

	}

}
