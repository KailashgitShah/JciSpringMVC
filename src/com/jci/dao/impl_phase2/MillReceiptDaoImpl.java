package com.jci.dao.impl_phase2;

import java.util.ArrayList;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.jci.dao_phase2.MillReceiptDao;
//import com.jci.model.ConfirmationClaimSettlementModel;
import com.jci.model.MillRecieptModel;

@Repository
@Transactional
public class MillReceiptDaoImpl implements MillReceiptDao {

	@Autowired
	private HttpServletRequest request;
	@Autowired
	SessionFactory sessionFactory;

	protected Session currentSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public void create(MillRecieptModel MillRecieptModel) {

		currentSession().saveOrUpdate(MillRecieptModel);
	}

	@Override
	public List<MillRecieptModel> getAllPaymentInstruments() {
		Criteria criteria = currentSession().createCriteria(MillRecieptModel.class);
		return criteria.list();
	}

	@Override
	public void update(MillRecieptModel MillRecieptModel) {
		currentSession().update(MillRecieptModel);
	}

	@Override
	public MillRecieptModel edit(int id) {
		return find(id);
	}

	public MillRecieptModel find(int id) {
		// TODO Auto-generated method stub
		return (MillRecieptModel) currentSession().get(MillRecieptModel.class, id);
	}

	@Override
	public void delete(int id) {
		MillRecieptModel millRecieptModel = new MillRecieptModel();
		String hql = "Delete from jcipayment_arrangement where dopiid = '" + id + "' ";
		this.sessionFactory.getCurrentSession().createSQLQuery(hql).executeUpdate();
	}

	@Override
	public MillRecieptModel Creditqty(String st) {

		List<Object[]> list = new ArrayList();
		MillRecieptModel resultList1 = new MillRecieptModel();
		try {
			String sql = "SELECT Actual_qty,Short_qty  FROM jcicredit_note  WHERE Crn_id = 3";

			Session session = sessionFactory.getCurrentSession();
			Transaction tx = session.beginTransaction();
			SQLQuery query = session.createSQLQuery(sql);
			list = query.list();

			for (Object[] element : list) {
				resultList1.setActual_qty((Double) element[0]);
				resultList1.setShort_qty((Double) element[1]);
			}
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
		}
		return resultList1;

	}

	@Override
	public List<Object> fetchHODINO(String millname,String contractNo) {

//                                                         String sql=  " SELECT  distinct a.DI_no,b.Mill_code,a.Contract_No from jcidispatch_details as a Left join jcicontract as b on b.Contract_no = a.Contract_No \r\n"
//                                                                                       + " INNER JOIN jcicredit_note AS d ON d.Contract_no = a.Contract_No "
//                                                                                       + "where b.Mill_code= '" + millname + "' "
//                                                                                                                     + "  AND a.Challan_no IN (SELECT ChallanNo FROM jcicredit_note)\r\n"
//                                                                                                                     + "  AND a.Challan_no NOT IN (SELECT Challan_no FROM jcimill_receipt);";
//                                                         

		String sql = "  SELECT  distinct  a.DI_no , b.Mill_code , a.Contract_No from jcidispatch_details as a Left join jcicontract as b on b.Contract_no = a.Contract_No \r\n"
				+ "                                                                      INNER JOIN jcibos_generation as d  on  b.Contract_no=d.Contract_No\r\n"
				+ "                                                                      where b.Mill_code= '"
				+ millname + "' and d.Contract_No = '" + contractNo +"' AND a.Challan_no NOT IN (SELECT Challan_no FROM jcimill_receipt);";
		List<Object> resultList1 = (List<Object>) this.sessionFactory.getCurrentSession().createSQLQuery(sql).list();
		return resultList1;

//                                                       
	}
	
	@Override
	public List<Object> fetchAllContractNos(String millname) {

//                                                         String sql=  " SELECT  distinct a.DI_no,b.Mill_code,a.Contract_No from jcidispatch_details as a Left join jcicontract as b on b.Contract_no = a.Contract_No \r\n"
//                                                                                       + " INNER JOIN jcicredit_note AS d ON d.Contract_no = a.Contract_No "
//                                                                                       + "where b.Mill_code= '" + millname + "' "
//                                                                                                                     + "  AND a.Challan_no IN (SELECT ChallanNo FROM jcicredit_note)\r\n"
//                                                                                                                     + "  AND a.Challan_no NOT IN (SELECT Challan_no FROM jcimill_receipt);";
//                                                         

		String sql = "  SELECT distinct a.Contract_No from jcidispatch_details as a Left join jcicontract as b on b.Contract_no = a.Contract_No \r\n"
				+ "                                                                      INNER JOIN jcibos_generation as d  on  b.Contract_no=d.Contract_No\r\n"
				+ "                                                                      where b.Mill_code= '"
				+ millname + "' AND a.Challan_no NOT IN (SELECT Challan_no FROM jcimill_receipt)";
		
		List<Object> resultList1 = (List<Object>) this.sessionFactory.getCurrentSession().createSQLQuery(sql).list();
		return resultList1;

//                                                       
	}

	@Override
	public MillRecieptModel getById(int id) {
		return (MillRecieptModel) sessionFactory.getCurrentSession().get(MillRecieptModel.class, id);
	}

	@Override
	public void UpdateContractstatus(String s) {
		String hql = "UPDATE jcicontract set Contract_status = 'Mill Raised Claim'   where Contract_no = '" + s + "' ";

		this.sessionFactory.getCurrentSession().createSQLQuery(hql).executeUpdate();

	}

	@Override
	public List<Object[]> fetchdata(String st) {

		String sql = "  SELECT distinct a.Challan_no, a.Date_of_shipment, a.Vehicle_no, CONVERT(varchar, a.DI_Date, 103) AS DI_Date,a.Contract_No,a.Mill_code,a.DI_No \r\n"
				+ "                                                       FROM   jcibos_generation AS s LEFT JOIN jcidispatch_details AS a ON s.Challan_No = a.Challan_no\r\n"
				+ "                                                       WHERE a.DI_No in " + st
				+ "  AND a.Challan_no NOT IN (SELECT Challan_no FROM jcimill_receipt)";

//                           String sql ="  SELECT distinct a.Challan_no, a.Date_of_shipment, a.Vehicle_no, CONVERT(varchar, a.DI_Date, 103) AS DI_Date,a.Contract_No,a.Mill_code "
//                                          + "                                                                     FROM   jcicredit_note AS s LEFT JOIN jcidispatch_details AS a ON s.ChallanNo = a.Challan_no"
//                                                        + " WHERE a.DI_No =  '" +st+"'  AND a.Challan_no NOT IN (SELECT Challan_no FROM jcimill_receipt);"; 

		List<Object[]> resultList1 = (List<Object[]>) this.sessionFactory.getCurrentSession().createSQLQuery(sql)
				.list();
		return resultList1;
	}

	@Override
	public List<Object[]> fetchMill_NameR() {

		// String sql =" SELECT distinct a.Mill_name,b.Contract_No FROM jcicontract AS a
		// LEFT JOIN jciDI_ho AS b ON a.Contract_no = b.Contract_No where b.Contract_No
		// is NOT NULL";
//                           String sql ="  SELECT  distinct a.Mill_name FROM jcicontract AS a LEFT JOIN jciDI_ho AS b ON a.Contract_no = b.Contract_No where b.Contract_No is NOT NULL";
//                           

//                           String sql ="                        select  distinct s.client_name,s.client_unit_code from \r\n"
//                                                         + "                                                                                     (SELECT d.client_name,c.client_unit_code FROM jcimilldetailchild as c INNER join jcimilldetailmaster as d on c.client_code=d.client_code) as s \r\n"
//                                                         + "                                                    INNER join (SELECT a.Contract_no,b.Mill_code from jcibos_generation as a INNER JOIN  jcicontract as b on  b.Contract_no=a.Contract_No ) as z on z.Mill_code=s.client_unit_code "; 
//                           
//                              String sql ="   select  distinct s.client_name,s.client_unit_code from \r\n"
//                                                            + "                                                                                     (SELECT d.client_name,c.client_unit_code FROM jcimilldetailchild as c INNER join jcimilldetailmaster as d on c.client_code=d.client_code) as s \r\n"
//                                                            + "                                                    INNER join (SELECT a.Contract_no,b.Mill_code from jcibos_generation as a INNER JOIN  jcicontract as b on  b.Contract_no=a.Contract_No ) as z on z.Mill_code=s.client_unit_code \r\n"
//                                                            + " "; 

		String sql = " select  distinct s.client_name,s.client_unit_code, s.unit_name from \r\n"
				+ " (SELECT d.client_name,c.client_unit_code , c.unit_name FROM jcimilldetailchild as c\r\n"
				+ "  INNER join jcimilldetailmaster as d on c.client_code=d.client_code) as s \r\n"
				+ " INNER join (SELECT a.Contract_no,b.Mill_code from jcibos_generation as a\r\n"
				+ "  INNER JOIN  jcicontract as b on  b.Contract_no=a.Contract_No ) as z\r\n"
				+ "   on z.Mill_code=s.client_unit_code ORDER by s.client_name ASC";

		List<Object[]> resultList1 = (List<Object[]>) this.sessionFactory.getCurrentSession().createSQLQuery(sql)
				.list();
		return resultList1;
	}

	@Override
	public boolean findmillreceiptNOlist(String st) {
		String sql = "SELECT DISTINCT MR_no FROM jcimill_receipt WHERE HO_di = '" + st + "'";
		List<Object> resultList = (List<Object>) this.sessionFactory.getCurrentSession().createSQLQuery(sql).list();

		// Check if resultList is not empty
		boolean dataFound = !resultList.isEmpty();

		return dataFound;
	}

	@Override
	public List<Object[]> childdata(String st) {

		String sql = "    SELECT distinct d.Challan_No,d.Bale_mark,  d.Jute_variety,d.Jute_grade,  d.Crop_year,d.Nominal_qty,d.No_of_bales,d.Nominal_qty  FROM \r\n"
				+ "                                        jcidispatch_details_child AS d  Inner join jcibos_generation as s on s.Challan_No = d.Challan_no   WHERE d.Challan_no = '"
				+ st + "'   and d.Jute_grade=d.Jute_grade \r\n"
				+ "                                                       ";

//                           String sql =" SELECT distinct d.Challan_No,d.Bale_mark,  d.Jute_variety,d.Jute_grade,  d.Crop_year,d.Nominal_qty,d.No_of_bales,s.Actual_qty FROM "
//                                                        + "                                        jcidispatch_details_child AS d  Inner join jcicredit_note as s on s.ChallanNo = d.Challan_no   WHERE d.Challan_no = '" +st+"' and  Crn_status='0'  and d.Jute_grade=s.Jute_grade ";
//                                                        
//                                                         
		List<Object[]> resultList1 = (List<Object[]>) this.sessionFactory.getCurrentSession().createSQLQuery(sql)
				.list();
		return resultList1;

	}

	@Override
	public List<Object[]> challanbaseddetails(String st) {
	    String sql = "SELECT DISTINCT " +
	            "CONVERT(varchar, a.Date_of_shipment, 103) AS Date_of_shipment, " +
	            "a.Vehicle_no, " +
	            "CONVERT(varchar, a.DI_Date, 103) AS DI_Date, " +
	            "d.Nominal_qty, " +
	            "d.Nominal_qty * 100 AS CalculatedQty, " +
	            "a.Contract_No, " +
	            "a.Mill_code, " +
	            "d.Crop_year, " +
	            "d.Jute_variety, " +
	            "a.Regional_Office, " +
	            "CONVERT(varchar, s.BOS_date, 103) AS BOS_date " +
	            "FROM jcidispatch_details AS a " +
	            "INNER JOIN jcidispatch_details_child AS d ON d.Challan_no = a.Challan_no " +
	            "INNER JOIN jcibos_generation AS s ON s.Challan_No = a.Challan_no " +
	            "WHERE a.Challan_no = :challanNo";

	    List<Object[]> resultList1 = (List<Object[]>) this.sessionFactory
	        .getCurrentSession()
	        .createSQLQuery(sql)
	        .setParameter("challanNo", st)
	        .list();

	    return resultList1;
	}


	@Override
	public List<Object[]> gradeprice(String Challan, String contract, String cropyear, String jutevarirty) {

//                           String sql= "a.grade1, a.grade2, a.grade3, a.grade4, a.grade5, a.grade6\n"
//                               + "FROM jcientry_derivative_price as a \n"
//                               + "INNER JOIN jcicontract ON a.delivery_type = jcicontract.Delivery_type\n"
//                               + "INNER JOIN jcipurchasecenter ON jcipurchasecenter.district = a.district\n"
//                               + "INNER JOIN jcidispatch_details ON jcidispatch_details.Challan_no = '" + Challan + "'\n"
//                               + "WHERE jcipurchasecenter.CENTER_CODE = jcidispatch_details.Place_of_Shipment\n"
//                               + "AND jcicontract.Contract_no = '" + contract + "'\n"
//                               + "AND a.crop_year = '" + cropyear + "'\n"
//                               + "AND a.jute_variety = '" + jutevarirty + "'";

		String sql = " SELECT jcientry_derivative_price. grade1,jcientry_derivative_price. grade2,jcientry_derivative_price. grade3,jcientry_derivative_price. grade4,"
				+ "  jcientry_derivative_price. grade5,jcientry_derivative_price. grade6 "
				+ "   FROM jcientry_derivative_price "
				+ "   INNER JOIN jcicontract ON jcientry_derivative_price.delivery_type = jcicontract.Delivery_type "
				+ "  INNER JOIN jcipurchasecenter ON jcipurchasecenter.district = jcientry_derivative_price.district "
				+ "  INNER JOIN jcidispatch_details ON jcidispatch_details.Challan_no ='" + Challan + "'"
				+ "   WHERE jcipurchasecenter.CENTER_CODE = jcidispatch_details.Place_of_Shipment\r\n"
				+ "   AND jcicontract.Contract_no = '" + contract + "'"
				+ "  AND jcientry_derivative_price.crop_year = '" + cropyear + "'"
				+ " AND jcientry_derivative_price.jute_variety ='" + jutevarirty + "'";

		List<Object[]> resultList1 = (List<Object[]>) this.sessionFactory.getCurrentSession().createSQLQuery(sql)
				.list();
		return resultList1;
	}

}
