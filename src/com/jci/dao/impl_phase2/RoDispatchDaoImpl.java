package com.jci.dao.impl_phase2;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.digester.ObjectParamRule;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.itextpdf.text.pdf.PdfStructTreeController.returnType;
import com.jci.dao_phase2.RoDispatchDao;
import com.jci.model.EntryDerivativePrice;
import com.jci.model.RoDispatchModel;

@Transactional
@Repository
public class RoDispatchDaoImpl implements RoDispatchDao {

	@Autowired
	private HttpServletRequest request;

	@Autowired
	SessionFactory sessionFactory;

	protected Session currentSession() {
		return sessionFactory.getCurrentSession();
	}
	// Get purhcase center for particular Region
	@Override
	public List<String> loadAllDpc() {
		String regionCode = (String) request.getSession().getAttribute("region");
		String sqlString = "select CENTER_CODE,centername from jcipurchasecenter where rocode='" + regionCode + "'";
		
		List<Object[]> list = currentSession().createSQLQuery(sqlString).list();
		List<String> newlList = new ArrayList<>();
		for(Object[] ro: list) {
			newlList.add(ro[0]+"!"+ro[1]);
		}
		// TODO Auto-generated method stub
		return newlList;
		
	}

	//To load all DI no. in RO form
	@Override
	public List<String> loadAllDiNo() {
		String regionCode = (String) request.getSession().getAttribute("region");

		String sqlString =" SELECT a.DI_no, " 
			      +" a.TotalSum, "
			      +" a.Regional_office, " 
			      +" b.roSum"
		+"	FROM ("
		+"	    SELECT DI_no," 
			       +"    SUM(Gr1_qty + Gr2_qty + Gr3_qty + Gr4_qty + Gr5_qty + Gr6_qty + Gr7_qty + Gr8_qty) AS TotalSum, "
			         +"  Regional_office "
			    +" FROM jciDI_ho "
			    +" GROUP BY DI_no, Regional_office "
		+" 	) a "
		+"	 LEFT JOIN ( "
		+"	    SELECT HO_DI_NO, "
		+"	           SUM(Gr1_qty + Gr2_qty + Gr3_qty + Gr4_qty + Gr5_qty + Gr6_qty + Gr7_qty + Gr8_qty) AS roSum "
		+"	    FROM jciDI_ro "
			+"    GROUP BY HO_DI_NO "
		+"	) b "
		+"	ON a.DI_no = b.HO_DI_NO "
		+" WHERE(a.TotalSum > b.roSum or roSum is NULL) " 
			 +" AND a.Regional_office = '"+regionCode+"';";



		List<Object[]> list = currentSession().createSQLQuery(sqlString).list();
		List<String> list1=new ArrayList<>();
		for(Object[] row: list) {
			 list1.add((String)row[0]);
		}
		return list1;
	}

	// Returns object of all DI details
	@Override
	public List<Object> loadAllContractDetails(String diNo) {
		String sqlString = "select * from jciDI_ho where DI_no='" + diNo + "'";
		List<Object> list = currentSession().createSQLQuery(sqlString).list();
		return list;
	}

	//To get count of RO entries for RO no. generation
	@Override
	public int getCountOfAvailableEntries(String hoNo) {
		String sqlString = "select count(HO_DI_NO) from jciDI_ro where HO_DI_NO = '" + hoNo + "'";
		return (int) this.currentSession().createSQLQuery(sqlString).uniqueResult();

	}
	//Create

	@Override
	public void create(RoDispatchModel roDispatchModel) {
		this.currentSession().save(roDispatchModel);

	}
	//To get All RO

	@Override
	public List<RoDispatchModel> getAllRoDi() {
		Criteria c = this.sessionFactory.getCurrentSession().createCriteria(RoDispatchModel.class)
				.addOrder(Order.desc("creationDate"));
		List<RoDispatchModel> ll = c.list();
		return ll;

	}
//To get Cooperatives
	@Override
	public List<String> getCooperative(String regionIdString) {
		String sqlString = "SELECT CENTER_CODE, centername "+
				" FROM jcipurchasecenter "+
				"WHERE rocode = '" + regionIdString + "'"+ 
				 " AND (centertypecode = 'C' OR centertypecode='D');";
		List<Object[]> list = currentSession().createSQLQuery(sqlString).list();
		List<String> newlList = new ArrayList<>();
		for(Object[] ro: list) {
			newlList.add(ro[0]+"!"+ro[1]);
		}
		// TODO Auto-generated method stub
		return newlList;
	}
	
//To get details for DI no.
	@Override
	public List<String> getDetails(String hOno) {
		String sqlString = "SELECT    SUM(Gr1_qty) AS T1 ,  SUM(Gr2_qty) AS T2,"
				+ "			SUM(Gr3_qty) AS T3 , SUM(Gr4_qty) AS T4,"
				+ "			  SUM(Gr5_qty) AS T5,   SUM(Gr6_qty) AS T6 ,"
				+ "			SUM(Gr7_qty) AS T7,  SUM(Gr8_qty) AS T8" + "			 FROM jciDI_ro WHERE HO_DI_NO =   '"
				+ hOno + "' Group BY Jute_variety;";
		List<String> list = currentSession().createSQLQuery(sqlString).list();
		return list;
	}
//TO get previous DI  for RO
	@Override
	public List<String> getprevious(String diNo) {
		// TODO Auto-generated method stub
		String sqlString = " SELECT jciDI_ro.RO_DI_NO,  jciDI_ro.RO_DI_DATE, jcipurchasecenter.centername , SUM(jciDI_ro.GR1_QTY + jciDI_ro.GR2_QTY + jciDI_ro.GR3_QTY + jciDI_ro.GR4_QTY + jciDI_ro.GR5_QTY + jciDI_ro.GR6_QTY + jciDI_ro.GR7_QTY + jciDI_ro.GR8_QTY) AS Allocation FROM jciDI_ro "
		+"INNER JOIN jcipurchasecenter ON jciDI_ro.DPC = jcipurchasecenter.CENTER_CODE "
		+ " WHERE jciDI_ro.HO_DI_NO = '"+diNo+ "' " 
			+"  GROUP BY jciDI_ro.RO_DI_NO, jciDI_ro.RO_DI_DATE, jciDI_ro.DPC, jcipurchasecenter.centername;";
		List<String> list = currentSession().createSQLQuery(sqlString).list();
		return list;
	}
	
	
	//To update contract status

	@Override
	public void update(String contractNoString) {
		// TODO Auto-generated method stub
		String sqlString = "Update jcicontract set Contract_status ='DI Issued by RO' where Contract_no ='"
				+ contractNoString + "'";
		currentSession().createSQLQuery(sqlString).executeUpdate();// for setting values only
		return;
		
	}
	@Override
	public String dpcCheck(String dpc,String hoDIno) {
		// TODO Auto-generated method stub
		String sqlString = "SELECT CASE WHEN EXISTS " +
                " (SELECT * FROM jciDI_ro WHERE HO_DI_NO = '" + hoDIno + "' AND DPC = '" + dpc + "') " +
                " THEN '0' ELSE '1' END AS result;";

		 String list = (String) currentSession().createSQLQuery(sqlString).uniqueResult();
		 return list;
	}

}
