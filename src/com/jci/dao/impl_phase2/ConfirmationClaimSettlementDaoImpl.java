package com.jci.dao.impl_phase2;

import java.math.BigDecimal;
import java.util.List;

import javax.servlet.http.HttpSession;

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
	@Autowired
	HttpSession session;

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
				+ "FROM jciclaimNomination nom\r\n"
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
		String sql = "select distinct jcimill_receipt.Mr_no,jcimill_receipt.Mr_date,jcimill_receipt.Jute_Variety,\r\n"
				+ "jcimill_receipt.Jute_Grade,jcimill_receipt.Actual_qty,jcimill_receipt.QualityPercentage,\r\n"
				+ "jcimill_receipt.MoistureContent,jcimill_receipt.NCV_percentage,jcidispatch_details_child.No_of_bales,\r\n"
				+ "jcidispatch_details_child.Rate,jcimill_receipt.Crop_year,jcimill_receipt.NCV_qty,jcimill_receipt.Challan_no,\r\n"
				+ "jciclaimNomination.ContractNo,jciclaimNomination.DateofInspection,jciclaimNomination.Mill,\r\n"
				+ "jciclaimNomination.Mr_number,jciclaimNomination.Mr_Date from jcimill_receipt\r\n"
				+ "left  join jcidispatch_details_child on jcimill_receipt.Jute_Grade = jcidispatch_details_child.Jute_grade\r\n"
				+ "AND jcidispatch_details_child.Challan_no = jcimill_receipt.Challan_no\r\n"
				+ "inner join jciclaimNomination on jciclaimNomination.Challans = jcimill_receipt.Challan_no   \r\n"
				+ "WHERE jciclaimNomination.Settlement_id_generated =  '"+st+"' \r\n"
				+ "   ;    ";
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
		String sql = " select top 1 DateofInspection ,Mill from jciclaimNomination WHERE ContractNo = '"
				+ st + "' order by Created_on DESC";
		List<Object[]> resultList1 = (List<Object[]>) this.sessionFactory.getCurrentSession().createSQLQuery(sql)
				.list();
		System.err.println(resultList1);
		return resultList1;
	}

	@Override
	public List<String> fetchContract(String settlementId) {
		// TODO Auto-generated method stub
		String sqlString = "Select DISTINCT ContractNo from jciclaimNomination where Settlement_id_generated='" + settlementId + "';";
		List<String> resultList1 = (List<String>) this.sessionFactory.getCurrentSession().createSQLQuery(sqlString)
				.list();
		return resultList1;
	}

	@Override
	public List<Object[]> fetchChallan(String id) {
		String string ="Select Distinct Challans from jciclaimNomination where ContractNo='"+id+"';";
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
		
		 String resultString= "Select DISTINCT jciclaim_report_mill.Settlement_id,jciclaim_report_mill.Dispute_flag From jciclaim_report_mill JOIN jciclaimNomination on jciclaimNomination.Settlement_id_generated = jciclaim_report_mill.Settlement_id where jciclaimNomination.FAOfficial='"+username+"' and jciclaim_report_mill.Active='1' AND jciclaim_report_mill.Dispute_flag = 0;";
		 List<Object[]> resultList1 = (List<Object[]>) this.sessionFactory.getCurrentSession().createSQLQuery(resultString)
					.list();
			System.err.println(resultList1);
			return resultList1;
	
	}

	@Override
	public void acceptClaim(String challan,String username,String filename) {
		// TODO Auto-generated method stub
		String resultString ="Update jciclaim_report_mill SET Dispute_flag=2 ,FA_Official='"+username+"',FA_doc='"+filename+"' where Settlement_id='"+challan+"' AND Active='1';";
		currentSession().createSQLQuery(resultString).executeUpdate();
		return;
	}

	@Override
	public void rejectClaim(String challan, String username) {
		// TODO Auto-generated method stub
		String resultString ="Update jciclaim_report_mill SET Dispute_flag=1 ,Active='0' ,FA_Official='"+username+"' where Settlement_id='"+challan+"' AND Active='1';";
		currentSession().createSQLQuery(resultString).executeUpdate();
		return;
	}

	@Override
	public List<Object[]> getFAData(String setId) {
		// TODO Auto-generated method stub
		   String sqlQuery ="SELECT DISTINCT\r\n"
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
		   		+ "    nom.Settlement_id_generated = '"+setId+"'\r\n"
		   		+ "    AND claim_report.Active = '1' \r\n"
		   		+ "    AND claim_report.Jute_Grade = mill.Jute_Grade \r\n"
		   		+ "    AND mill.Jute_Variety = claim_report.Jute_Variety;\r\n"
		   		+ ";";
		   List<Object[]> resultList1 = (List<Object[]>) this.sessionFactory.getCurrentSession().createSQLQuery(sqlQuery)
					.list();
			System.err.println(resultList1);
			return resultList1;
	}

	@Override
	public List<Object[]> getMillAcc() {
		// TODO Auto-generated method stub
	 String millcode= (String) session.getAttribute("millcode");
		   String sqlQuery ="Select Distinct jciclaim_report_mill.Settlement_id,jciclaim_report_mill.Dispute_flag from jciclaim_report_mill  Inner join jciclaimNomination \r\n"
		   		+ "on jciclaimNomination.Settlement_id_generated=jciclaim_report_mill.Settlement_id Inner join jcimilldetailchild \r\n"
		   		+ "on jcimilldetailchild.unit_name=jciclaimNomination.Mill Where  jciclaim_report_mill.Dispute_flag=2 and\r\n"
		   		+ " jcimilldetailchild.client_unit_code='"+millcode+"' AND jciclaim_report_mill.Mill_Acc='0' ;";
		   List<Object[]> resultList1 = (List<Object[]>) this.sessionFactory.getCurrentSession().createSQLQuery(sqlQuery)
					.list();
			System.err.println(resultList1);
			return resultList1;
	}

	@Override
	public List<Object[]> getMillData(String setId) {
		// TODO Auto-generated method stub
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
			   		+ "    nom.Settlement_id_generated = '"+setId+"'\r\n"
			   		+ "    AND claim_report.Active = '1' AND claim_report.Jute_Grade=mill.Jute_Grade AND mill.Jute_Variety=claim_report.Jute_Variety AND claim_report.Dispute_flag='2';";

			   List<Object[]> resultList1 = (List<Object[]>) this.sessionFactory.getCurrentSession().createSQLQuery(sqlQuery)
						.list();
				System.err.println(resultList1);
				return resultList1;
	}

	@Override
	public void acceptMill(String settleId) {
		// TODO Auto-generated method stub
		String resultString ="Update jciclaim_report_mill SET Mill_Acc=2 where Settlement_id='"+settleId+"' AND Active='1';";
		currentSession().createSQLQuery(resultString).executeUpdate();
		return;
	}

	@Override
	public List<Object[]> getContract() {
		// TODO Auto-generated method stub
		String millcode= (String) session.getAttribute("millcode");
		String sqlString="     Select distinct jciclaimNomination.ContractNo,jciclaimNomination.Settlement_id_generated  from jciclaimNomination INNER join jciclaim_report_mill on jciclaim_report_mill.Settlement_id = jciclaimNomination.Settlement_id_generated\r\n"
				+ "inner join jcimilldetailchild on  jcimilldetailchild.unit_name=jciclaimNomination.Mill\r\n"
				+ "  where jcimilldetailchild.client_unit_code='"+millcode+"' AND jciclaim_report_mill.Mill_Acc='0';";
		 List<Object[]> resultList1 = (List<Object[]>) this.sessionFactory.getCurrentSession().createSQLQuery(sqlString)
					.list();
		return resultList1;
	}

	@Override
	public List<Object[]> getSettlementId(String contract) {
		// TODO Auto-generated method stub
		
		return null;
	}




}
