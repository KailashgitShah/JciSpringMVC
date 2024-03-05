package com.jci.dao.impl_phase2;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.management.relation.Role;
import javax.naming.spi.DirStateFactory.Result;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.jci.dao.HoDispatchdao;
import com.jci.dao_phase2.DispatchHODao;
import com.jci.model.HODispatchInstructionModel;
import com.jci.model.JciDIHoModel;

@Repository
@Transactional
public class HODispatchDaoImpl implements DispatchHODao {

                @Autowired
                SessionFactory sessionFactory;

                protected Session currentSession() {
                                return sessionFactory.getCurrentSession();
                }

                @Autowired
                HttpServletRequest request;

                @Override
                public List<String> getContract() {

                                String sqlString =" SELECT fc.Contractno  "
                                                                + "  FROM jcifinancial_concurrence fc  "
                                                                + "  LEFT JOIN ("
                                                                + "  SELECT ho.Contract_No, SUM(ho.Gr1_qty + ho.Gr2_qty + ho.Gr3_qty + ho.Gr4_qty + ho.Gr5_qty + ho.Gr6_qty + ho.Gr7_qty + ho.Gr8_qty) AS TotalQty, MAX(ho.Allowed_qty) AS MaxAllowedQty  "
                                                                + "  FROM jciDI_ho ho"
                                                                + "  GROUP BY ho.Contract_No  "
                                                                + ") subquery  "
                                                                + "  ON subquery.Contract_No = fc.Contractno  "
                                                                + "  WHERE subquery.Contract_No IS NULL OR subquery.TotalQty < subquery.MaxAllowedQty;  ";
;
                                List<String> list = this.sessionFactory.getCurrentSession().createSQLQuery(sqlString).list();

                                return list;
                }

                @Override
                public List<String> getDetails(String contractNo) {
                                List<String> result = new ArrayList<>();
                                String sqlString = "select Top 1 * from jcicontract where Contract_no ='" + contractNo + "' Order by Created_date DESC ";
                                String sqlString2 = "select Top 1 * from jcifinancial_concurrence where Contractno ='" + contractNo + "' Order by Created_date DESC ";
                                String sqString3 = "select TOP 1 Last_shipment_date from jcipayment_arrangement where Contract_No ='" + contractNo + "' Order by Created_date DESC";

                                List<String> list = this.sessionFactory.getCurrentSession().createSQLQuery(sqlString).list();
                                List<String> list2 = this.sessionFactory.getCurrentSession().createSQLQuery(sqlString2).list();
                                Date list3 = (Date) this.sessionFactory.getCurrentSession().createSQLQuery(sqString3).uniqueResult();

                                SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
                                String strDate = formatter.format(list3);

                                Session session = sessionFactory.getCurrentSession();
                                Transaction tx = session.beginTransaction();
                                SQLQuery query = session.createSQLQuery(sqlString);
                                List<Object[]> rows = query.list();
                                for (Object[] row : rows) {
                                                result.add(row[6].toString());
                                                result.add(row[23].toString());
                                                result.add(row[9].toString());// Contradate-Cropyear-contractqty
                                                result.add(row[19].toString());// Mill name
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
                                
                
                                
                                
                                
                                
                                
                                result.add(strDate);
                                System.err.println(result.get(4));
                                String sqlString4 = "select Jute_combination,System_composition from jcigrade_composition where Label_name='"
                                                                + result.get(4) + "'";// Composition + percentage allowed.
                                List<String> list4 = this.sessionFactory.getCurrentSession().createSQLQuery(sqlString4).list();
                                result.addAll(list4);
                                String userRole = (String) request.getSession().getAttribute("rolename");
                                String userRoname = (String) request.getSession().getAttribute("zonename");

                                String sqlString9 = "SELECT   "+
                                                   "   SUM(Gr1_qty) AS Total_Grade1,"+
                                                   "   SUM(Gr2_qty) AS Total_Grade2,"+
                                                   "   SUM(Gr3_qty) AS Total_Grade3,"+
                                                   "   SUM(Gr4_qty) AS Total_Grade4,"+
                                                   "   SUM(Gr5_qty) AS Total_Grade5,"+
                                                   "   SUM(Gr6_qty) AS Total_Grade6,"+
                                                   "   SUM(Gr7_qty) AS Total_Grade7,"+
                                                   "   SUM(Gr8_qty) AS Total_Grade8"+
                                                "    FROM jciDI_ho WHERE Contract_No =   '"+contractNo+"';";

                                
                                List<String> list9 = this.sessionFactory.getCurrentSession().createSQLQuery(sqlString9).list();
                                result.addAll(list9);
                                
                                //Payment mode 
                                String sqlString10 = "SELECT TOP 1 Payment_type from jcipayment_arrangement where Contract_No = '"+contractNo+"'  Order by Created_date DESC;";
                                List<String> list10 =  this.sessionFactory.getCurrentSession().createSQLQuery(sqlString10).list();
                                result.addAll(list10);
                                
                                
                                System.err.println(result);//
                                
                                String sqString5 = "select Top 1 Instrument_Date from jcipayment_arrangement where Contract_No ='" + contractNo + "' Order by Created_date DESC; ";
                                Date list5 = (Date) this.sessionFactory.getCurrentSession().createSQLQuery(sqString5).uniqueResult();

                                SimpleDateFormat formatter1 = new SimpleDateFormat("dd-MM-yyyy");
                                String strDate1 = formatter1.format(list5);
                                result.add(strDate1);

                                // Previous DI against select Contract
                                String sqString6 ="SELECT jciDI_ho.DI_no, jciDI_ho.DI_Date, jcirodetails.roname, jciDI_ho.Allowed_qty, " +
                                                                "SUM([Gr1_qty] + [Gr2_qty] + [Gr3_qty] + [Gr4_qty] + [Gr5_qty] + [Gr6_qty] + [Gr7_qty] + [Gr8_qty]) AS total_sum " +
                                                                "FROM jciDI_ho " +
                                                                "INNER JOIN jcirodetails ON jciDI_ho.Regional_office = jcirodetails.rocode " +
                                                                "WHERE Contract_No = '" + contractNo + "' " +
                                                                "GROUP BY jciDI_ho.DI_no, jciDI_ho.DI_Date, jcirodetails.roname, jciDI_ho.Allowed_qty;";

                                List<String> list6 = this.sessionFactory.getCurrentSession().createSQLQuery(sqString6).list();

                                result.add(String.valueOf(list6.size()));
                                result.addAll(list6);

                                System.err.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++" + result.get(3));
                                System.err.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++" + result.get(3));
                                System.err.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++" + result.get(3));
                                System.err.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++" + result.get(3));

                                
                                  String sqlString8 =
                                  "SELECT TOP 5 jcidispatch_details.DI_No, jcirodetails.roname FROM jcidispatch_details INNER JOIN jcirodetails ON jcidispatch_details.Regional_Office = jcirodetails.rocode WHERE Mill_name = '"+result.get(3)+"' ORDER BY Dientry_id DESC          ;";
                                
                                  List<String> list8 = this.sessionFactory.getCurrentSession().createSQLQuery(sqlString8).list();
                                  
                                  
                                  result.add(String.valueOf(list8.size()));
                                  System.err.println(list8);
                                  result.addAll(list8);
                                

                                return result;
                }

                @Override
                public List<Object[]> getRoname() {

                                String sqlString = "Select roname,rocode from jcirodetails";
                                List<Object[]> list = this.sessionFactory.getCurrentSession().createSQLQuery(sqlString).list();

                                return list;
                }

                @Override
                public Object getCount(String reg) {
                                // TODO Auto-generated method stub
                                String sqlString = "select Count(DI_HO_ID) from jciDI_ho where Regional_office ='" + reg + "'";
                                Object list3 = (Object) this.sessionFactory.getCurrentSession().createSQLQuery(sqlString).uniqueResult();

                                return list3;
                }

                @Override
                public void save(JciDIHoModel hodispatch) {
                                // TODO Auto-generated method stub
                                currentSession().save(hodispatch);
                                String contractNoString = hodispatch.getContract_No();
                                String sqlString ="Update jcicontract set Contract_status ='DI Issued by HO' where Contract_no ='" + contractNoString + "'";
                                currentSession().createSQLQuery(sqlString).executeUpdate();// for setting values only
                                return;
                }

                @Override
                public List<JciDIHoModel> getAll() {
                                Criteria c = this.sessionFactory.getCurrentSession().createCriteria(JciDIHoModel.class);

                                c.addOrder(Order.desc("DI_HO_ID"));
                                List<JciDIHoModel> ll = c.list();
                                return ll;
                }

                @Override
                public void delete(int parseInt) {
                                String sqlString = "DELETE FROM jciDI_ho WHERE DI_HO_ID ='"+parseInt+"'";
                                currentSession().createSQLQuery(sqlString).executeUpdate();
                                
                                return;
                                
                }

                @Override
                public String getContractNo(String id) {
                                // TODO Auto-generated method stub
                                String sqlString ="SELECT Contract_No from jciDI_ho where DI_HO_ID='"+id+"'";
                                String string=(String) this.sessionFactory.getCurrentSession().createSQLQuery(sqlString).uniqueResult();
                                return string;
                                
                }

                @Override
                public String check(String string) {
                                String string2 ="SELECT CASE"
                                                                + "        WHEN EXISTS (SELECT * FROM jcibos_generation WHERE Contract_no = '"+string+"') "
                                                                + "        THEN '0'"
                                                                + "        ELSE '1'"
                                                                + "        END AS result;";
                                
                                String str=(String) this.sessionFactory.getCurrentSession().createSQLQuery(string2).uniqueResult();
                                return str;
                }

}
