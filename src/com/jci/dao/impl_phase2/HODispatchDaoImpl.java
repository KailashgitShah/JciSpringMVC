package com.jci.dao.impl_phase2;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.management.relation.Role;
import javax.naming.spi.DirStateFactory.Result;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.itextpdf.text.pdf.PdfStructTreeController.returnType;
import com.jci.dao.HoDispatchdao;
import com.jci.dao_phase2.DispatchHODao;
import com.jci.model.HODispatchInstructionModel;
import com.jci.model.JciDIHoModel;

@Repository
@Transactional
public class HODispatchDaoImpl implements DispatchHODao {

              @Autowired
              SessionFactory sessionFactory;
              @Autowired
              HttpSession session1;

              protected Session currentSession() {
                             return sessionFactory.getCurrentSession();
              }

              @Autowired
              HttpServletRequest request;

              @Override
              public List<Object[]> getContract() {
                             // For getting Contract No from jcifinancialconcurrence which has not met the
                             // required criteria
                             String sqlString = " SELECT DISTINCT fc.Contractno, fc.FC_Ref_No "+
                                           "             FROM jcifinancial_concurrence fc"
                                           +"          LEFT JOIN ("
                                           +"              SELECT ho.Contract_No, SUM(ho.Gr1_qty + ho.Gr2_qty + ho.Gr3_qty + ho.Gr4_qty + ho.Gr5_qty + ho.Gr6_qty + ho.Gr7_qty + ho.Gr8_qty) AS TotalQty, MAX(ho.Allowed_qty) AS MaxAllowedQty"
                                           +"              FROM jciDI_ho ho"
                                           +"              GROUP BY ho.Contract_No"
                                           +"          ) subquery ON subquery.Contract_No = fc.Contractno"
                                           +"          WHERE subquery.Contract_No IS NULL OR subquery.TotalQty < subquery.MaxAllowedQty;"

                             ;
                             List<Object[]> list = this.sessionFactory.getCurrentSession().createSQLQuery(sqlString).list();

                             return list;
              }

              @Override
              public List<String> getDetails(String cnt) {
            	  System.err.println(cnt);
            	  
            	  String[] parts = cnt.split("\\$\\$");
            	  String contractNo = parts[0];
            	  String fc= parts[1];
            	 // System.err.println(contractNo);
            	 // System.err.println(fc);
            	

                             List<String> result = new ArrayList<>();
                             String sqlString = "SELECT TOP 1 * \r\n"
                                                          + "FROM jcicontract \r\n"
                                                          + "left join jcimilldetailchild ON jcimilldetailchild.client_unit_code = jcicontract.Mill_code \r\n"
                                                          + "WHERE jcicontract.Contract_no = '"+contractNo+"'"
                                                          + "ORDER BY jcicontract.Created_date DESC ;";
                                                          
                             String sqlString2 = "\r\n"
                             		+ "select Top 1 * from jcifinancial_concurrence where Contractno ='"+contractNo+"'  and FC_Ref_No='"+fc+"'order by Created_date DESC ";
                             String sqString3 = "select TOP 1 Last_shipment_date from jcipayment_arrangement where Contract_No ='"
                                                          + contractNo + "' Order by Created_date DESC";

                             List<String> list = this.sessionFactory.getCurrentSession().createSQLQuery(sqlString).list();
                             List<String> list2 = this.sessionFactory.getCurrentSession().createSQLQuery(sqlString2).list();
                             String list3 = (String) this.sessionFactory.getCurrentSession().createSQLQuery(sqString3).uniqueResult();

                             

                             Session session = sessionFactory.getCurrentSession();
                             Transaction tx = session.beginTransaction();
                             SQLQuery query = session.createSQLQuery(sqlString);
                             List<Object[]> rows = query.list();
                             for (Object[] row : rows) {
                                           result.add(row[6].toString());
                                           result.add(row[28].toString());
                                           result.add(row[21].toString());// Contradate-Cropyear-contractqty
                                           result.add(row[33].toString());// Mill name
                                           result.add(row[15].toString());// Label name

                             }
                             Session session2 = sessionFactory.getCurrentSession();
                             Transaction tx2 = session2.beginTransaction();
                             SQLQuery query2 = session2.createSQLQuery(sqlString2);
                             List<Object[]> rows2 = query2.list();
                             for (Object[] row : rows2) {
                                           result.add(row[5].toString());
                                           result.add(row[6].toString());// Allowed QTY

                             }

                             SimpleDateFormat sdfInput = new SimpleDateFormat("yyyy-MM-dd");
                             Date date1;
                             if(list3.length()==0) {
                                           result.add(list3);
                             }             
                             else {
                                           try {
                                                          date1 = sdfInput.parse(list3);
                                                          SimpleDateFormat sdfOutput = new SimpleDateFormat("yyyy-MM-dd");
                                                          String formattedDate = sdfOutput.format(date1);
                                                          result.add(formattedDate);

                                           } catch (ParseException e) {
                                                          // TODO Auto-generated catch block
                                                          e.printStackTrace();
                                           }
                                           
                             }
                             
              
                             /* System.err.println(result.get(4)); */
                             // Get composition and combination from jcigrade_composition
                             String sqlString4 = "select Jute_combination,Proposed_composition from jcigrade_composition where Label_name='"
                                                          + result.get(4) + "'";// Composition + percentage allowed.
                             List<String> list4 = this.sessionFactory.getCurrentSession().createSQLQuery(sqlString4).list();
                             result.addAll(list4);
                             String userRole = (String) request.getSession().getAttribute("rolename");
                             String userRoname = (String) request.getSession().getAttribute("zonename");
                             // To display sum of each grade for given contract no.
                             String sqlString9 = "SELECT   " + "   SUM(Gr1_qty) AS Total_Grade1," + "   SUM(Gr2_qty) AS Total_Grade2,"
                                                          + "   SUM(Gr3_qty) AS Total_Grade3," + "   SUM(Gr4_qty) AS Total_Grade4,"
                                                          + "   SUM(Gr5_qty) AS Total_Grade5," + "   SUM(Gr6_qty) AS Total_Grade6,"
                                                          + "   SUM(Gr7_qty) AS Total_Grade7," + "   SUM(Gr8_qty) AS Total_Grade8"
                                                          + "    FROM jciDI_ho WHERE FC_Ref_No =   '" + fc + "';";

                             List<String> list9 = this.sessionFactory.getCurrentSession().createSQLQuery(sqlString9).list();
                             result.addAll(list9);
                             // To get latest payment details
                             // Payment mode
                             String sqlString10 = "SELECT TOP 1 Payment_type from jcipayment_arrangement where Contract_No = '" + contractNo
                                                          + "'  Order by Created_date DESC;";
                             List<String> list10 = this.sessionFactory.getCurrentSession().createSQLQuery(sqlString10).list();
                             result.addAll(list10);

                             // To get latest instrument date
                             String sqString5 = "select Top 1 Instrument_Date from jcipayment_arrangement where Contract_No ='" + contractNo
                                                          + "' Order by Created_date DESC; ";
                             Date list5 = (Date) this.sessionFactory.getCurrentSession().createSQLQuery(sqString5).uniqueResult();

                             SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
                             String strDate = formatter.format(list5);
                             result.add(strDate);

                             // Previous DI against select Contract
                             String sqString6 = "SELECT jciDI_ho.DI_no, jciDI_ho.DI_Date, jcirodetails.roname, jciDI_ho.Allowed_qty, "
                                                          + "SUM([Gr1_qty] + [Gr2_qty] + [Gr3_qty] + [Gr4_qty] + [Gr5_qty] + [Gr6_qty] + [Gr7_qty] + [Gr8_qty]) AS total_sum "
                                                          + "FROM jciDI_ho " + "INNER JOIN jcirodetails ON jciDI_ho.Regional_office = jcirodetails.rocode "
                                                          + "WHERE Contract_No = '" + contractNo + "' "
                                                          + "GROUP BY jciDI_ho.DI_no, jciDI_ho.DI_Date, jcirodetails.roname, jciDI_ho.Allowed_qty;";

                             List<String> list6 = this.sessionFactory.getCurrentSession().createSQLQuery(sqString6).list();

                             result.add(String.valueOf(list6.size()));
                             result.addAll(list6);

                             String sqlString8 = "SELECT TOP 5 \r\n"
                                                          + "    jcidispatch_details.DI_No,\r\n"
                                                          + "    jcirodetails.roname\r\n"
                                                          + "FROM \r\n"
                                                          + "    jcidispatch_details\r\n"
                                                          + "INNER JOIN \r\n"
                                                          + "    jcirodetails ON jcidispatch_details.Regional_Office = jcirodetails.rocode\r\n"
                                                          + "inner join \r\n"
                                                          + "jcimilldetailchild on jcimilldetailchild.client_unit_code = jcidispatch_details.Mill_code\r\n"
                                                          + "\r\n"
                                                          + "WHERE \r\n"
                                                          + "    jcimilldetailchild.unit_name = '"+result.get(3)+"'\r\n"
                                                          + "ORDER BY \r\n"
                                                          + "    jcidispatch_details.Dientry_id DESC;";

                             List<String> list8 = this.sessionFactory.getCurrentSession().createSQLQuery(sqlString8).list();

                             result.add(String.valueOf(list8.size()));
                             System.err.println(list8);
                             result.addAll(list8);

                             return result;
              }

              // Get RO name and Ro code for listing
              @Override
              public List<Object[]> getRoname() {

                             String sqlString = "  Select roname,rocode from jcirodetails where officetype='R'";
                             List<Object[]> list = this.sessionFactory.getCurrentSession().createSQLQuery(sqlString).list();

                             return list;
              }

              // To get Count of previous DI issued for particular RO code.
              @Override
              public Object getCount(String reg,String crp) {
                             // TODO Auto-generated method stub
                             String sqlString = "  SELECT \r\n"
                             		+ "    COALESCE(\r\n"
                             		+ "        MAX(CAST(SUBSTRING(DI_no, CHARINDEX('/', DI_no) + 3, LEN(DI_no) - CHARINDEX('/', DI_no) - 2) AS INT)) + 1,\r\n"
                             		+ "        1\r\n"
                             		+ "    ) AS next_number\r\n"
                             		+ "FROM \r\n"
                             		+ "    jciDI_ho\r\n"
                             		+ "WHERE \r\n"
                             		+ "    Regional_office = '"+reg+"' \r\n"
                             		+ "     AND DI_no Like '"+crp+"%';\r\n"
                             		+ "";
                             Object list3 = (Object) this.sessionFactory.getCurrentSession().createSQLQuery(sqlString).uniqueResult();

                             return list3;
              }

              // Save HO_DI
              @Override
              public void save(JciDIHoModel hodispatch) {
                             // TODO Auto-generated method stub
                             currentSession().save(hodispatch);
                             String contractNoString = hodispatch.getContract_No();
                             String sqlString = "Update jcicontract set Contract_status ='DI Issued by HO' where Contract_no ='"
                                                          + contractNoString + "'";
                            currentSession().createSQLQuery(sqlString).executeUpdate();// for setting values only
                             return;
              }

              // For Listing
              @Override
              public List<Object[]> getAll() {
            	  String regionString=(String)session1.getAttribute("regionId");
                  Integer roleId = (Integer)session1.getAttribute("roleId");
              String sqlString="";
                  if(roleId ==6||roleId == 7 || roleId ==8) {
                	  sqlString  = "SELECT ro.roname, diho.*\r\n"
                	  		+ "                   	   		FROM jciDI_ho diho\r\n"
                	  		+ "                   	   		LEFT JOIN jcirodetails ro \r\n"	
                	  		+ "                   	   		   ON diho.Regional_office = ro.rocode\r\n"
                	  		+ "                   	   		WHERE diho.Regional_office ='"+regionString+"';\r\n"
                	  		+ "                   	   		;";
                 	
                  }
                  else if(roleId == 51 || roleId ==1103||roleId==3|| roleId ==4 ||roleId == 1104){
                	 
                	  sqlString  = "Select ro.roname, diho.*  from jciDI_ho diho left join jcirodetails ro on diho.Regional_office = ro.rocode ;";
                      
                  }
                  else {
                	  return null;
                  }
                  List<Object[]> list1 = this.sessionFactory.getCurrentSession().createSQLQuery(sqlString).list();
                  return list1;
              }

              // Delete query
              @Override
              public void delete(String parseInt) {
                             System.err.println(parseInt);
                             String sql1 = "DELETE FROM jciDI_ho WHERE DI_no = '" + parseInt
                                                          + "';";

                             currentSession().createSQLQuery(sql1).executeUpdate();

                             return;

              }

              // Get contract no. for the given DI_HO_ID
              @Override
              public String getContractNo(String id) {
                             // TODO Auto-generated method stub
                             String sqlString = "SELECT Contract_No from jciDI_ho where DI_HO_ID='" + id + "'";
                             String string = (String) this.sessionFactory.getCurrentSession().createSQLQuery(sqlString).uniqueResult();
                             return string;

              }

              // Checking for DI Contract No exist in bill of Supply
              @Override
              public String check(String string) {
                             String string2 = "SELECT CASE" + "        WHEN EXISTS (SELECT * FROM jcibos_generation WHERE Contract_no = '"
                                                          + string + "') " + "        THEN '0'" + "        ELSE '1'" + "        END AS result;";

                             String str = (String) this.sessionFactory.getCurrentSession().createSQLQuery(string2).uniqueResult();
                             return str;
              }

              @Override
              public List<String> juteVariety() {
                             // TODO Auto-generated method stub
                             String sqlString = "select distinct jutevariety from jcijutevarietyPhase2 where basis='1';";
                             List<String> list = this.sessionFactory.getCurrentSession().createSQLQuery(sqlString).list();
                             return list;
              }

              @Override
              public List<Object[]> getJasperData(String diNoString) {
                             // TODO Auto-generated method stub
                             String sqlString ="SELECT \r\n"
                                                          + "    a.DI_no,\r\n"
                                                          + "    a.DI_Date,\r\n"
                                                          + "    c.unit_name,\r\n"
                                                          + "    c.unit_address1,\r\n"
                                                          + "    c.unit_address2,\r\n"
                                                          + "    c.unit_location,\r\n"
                                                          + "    c.unit_pin,\r\n"
                                                          + "    a.Contract_No,\r\n"
                                                          + "    b.Contract_date,\r\n"
                                                          + "    b.CropYear,\r\n"
                                                          + "    a.Last_date_of_Shipment,\r\n"
                                                          + " \r\n"
                                                          + "    d.roname\r\n"
                                                          + "   \r\n"
                                                          + "FROM \r\n"
                                                          + "    jciDI_ho a\r\n"
                                                          + "INNER JOIN \r\n"
                                                          + "    jcicontract b ON a.Contract_No = b.Contract_no\r\n"
                                                          + "INNER JOIN \r\n"
                                                          + "    jcimilldetailchild c ON b.Mill_code = c.client_unit_code\r\n"
                                                          + "Inner join \r\n"
                                                          + "   jcirodetails d on a.Regional_office = d.rocode\r\n"
                                                          + "WHERE  \r\n"
                                                          + "    a.DI_no = '"+diNoString+"';";
                             List<Object[]> list1 = this.sessionFactory.getCurrentSession().createSQLQuery(sqlString).list();
                             return list1;
                             
              }

}
