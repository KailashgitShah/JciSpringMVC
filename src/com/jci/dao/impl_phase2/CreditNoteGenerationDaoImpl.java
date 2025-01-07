package com.jci.dao.impl_phase2;

import static org.hamcrest.CoreMatchers.nullValue;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

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
import com.jci.model.Jciclaim_NominationModel;
import com.jci.model.settlemetCnDnModel;

@Repository
public class CreditNoteGenerationDaoImpl implements CreditNoteGenerationDao {

              @Autowired
              SessionFactory sessionFactory;
              @Autowired
              HttpSession session;

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
//                         Criteria c = this.sessionFactory.getCurrentSession().createCriteria(CreditNotes.class)
//                                                    .addOrder(Order.desc("creationDate")).add(Restrictions.eq("crnStatus", 0));
//                         List<CreditNotes> ll = c.list();

                             Integer roleId = (Integer) session.getAttribute("roleId");
                             String region = (String) session.getAttribute("region");
                             String sql = "";

                             if (roleId == 6 || roleId == 7 || roleId == 8) {

                                           sql = "SELECT Credit_note_date,  Credit_note_no,ChallanNo,SUM(BOS_qty) as bos_qty,"
                                                                        + "  SUM(Actual_qty) as actual_qty ,SUM(Short_qty) as shrt_qty ,SUM(Credit_note_amount) as crn_amt , MAX(document) as docs, MAX(Creation_date)"
                                                                        + " as Max_Creation_date FROM jcicredit_note WHERE Crn_status = 0 and Ro_id = '" + region + "' "
                                                                        + "GROUP BY  Credit_note_date, Credit_note_no, ChallanNo ORDER BY Max_Creation_date DESC";
                             } else {

                                           sql = "SELECT Credit_note_date,  Credit_note_no,ChallanNo,SUM(BOS_qty) as bos_qty,"
                                                                        + "  SUM(Actual_qty) as actual_qty ,SUM(Short_qty) as shrt_qty ,SUM(Credit_note_amount) as crn_amt , MAX(document) as docs, MAX(Creation_date)"
                                                                        + " as Max_Creation_date FROM jcicredit_note WHERE Crn_status = 0 "
                                                                        + "GROUP BY  Credit_note_date, Credit_note_no, ChallanNo ORDER BY Max_Creation_date DESC";
                             }

                             return (List<Object[]>) currentSession().createSQLQuery(sql).list();
              }

              @Override
              public void chageStatusTo1(int id) {
                             String sql = "update jcicredit_note set Crn_Status = 1 where Crn_id = " + id + "";
                             currentSession().createSQLQuery(sql).executeUpdate();
              }

              @Override
              public int getGstCount(String gstGstCode) {
                             String sql = "select count( distinct Credit_note_no) from jcicredit_note where gstCode = '" + gstGstCode
                                                          + "' and Crn_status = 0";
                             return (int) currentSession().createSQLQuery(sql).uniqueResult();

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

                             Integer roleId = (Integer) session.getAttribute("roleId");
                             String region = (String) session.getAttribute("region");

                             if (roleId == 6 || roleId == 7 || roleId == 8) {

                                           if (parameter.equals("Region")) {
//                                                          sqlString = "  select distinct CONCAT(b.Ro_id, '--', c.roname) from jcibos_generation a INNER JOIN jciweighment_entry b on b.Verification_status = 1 and b.Bos_no = \r\n"
//                                                                                      + "(select a.Bill_of_supply_no where a.Challan_No not in (select distinct ChallanNo from jcicredit_note where Crn_status = 0)) inner join jcirodetails c on b.Ro_id = c.rocode and b.Ro_id = '"
//                                                                                      + region + "'";
                                                          
                                                          sqlString = "select distinct CONCAT(d.rocode, '--', c.roname) from jcibos_generation a INNER JOIN jciweighment_entry b on b.Verification_status = 1 and b.Bos_no = \r\n"
                                                          		+ "(select a.Bill_of_supply_no where a.Challan_No not in (select distinct ChallanNo from jcicredit_note where Crn_status = 0)) \r\n"
                                                          		+ "inner join jcipurchasecenter d on d.CENTER_CODE = a.DPCID\r\n"
                                                          		+ "inner join jcirodetails c on d.rocode = c.rocode  and d.rocode = '" + region + "'";
                                                        
                                           } else {
                                                          sqlString = " select distinct(a.Contract_no) from jcibos_generation a INNER JOIN "
                                                                                      + " jciweighment_entry b on b.Verification_status = 1 and b.Bos_no = (select a.Bill_of_supply_no where "
                                                                                      + " a.Challan_No not in (select distinct ChallanNo from jcicredit_note where Crn_status = 0)) and a.Ro_id = '"
                                                                                      + region + "'";
                                           }

                             } else {

                                           if (parameter.equals("Region")) {
//                                                          sqlString = "  select distinct CONCAT(b.Ro_id, '--', c.roname) from jcibos_generation a INNER JOIN jciweighment_entry b on b.Verification_status = 1 and b.Bos_no = \r\n"
//                                                                                      + "(select a.Bill_of_supply_no where a.Challan_No not in (select distinct ChallanNo from jcicredit_note where Crn_status = 0)) inner join jcirodetails c on b.Ro_id = c.rocode ";
                                        	                                               
                                               sqlString = "select distinct CONCAT(d.rocode, '--', c.roname) from jcibos_generation a INNER JOIN jciweighment_entry b on b.Verification_status = 1 and b.Bos_no = \r\n"
                                               		+ "(select a.Bill_of_supply_no where a.Challan_No not in (select distinct ChallanNo from jcicredit_note where Crn_status = 0)) \r\n"
                                               		+ "inner join jcipurchasecenter d on d.CENTER_CODE = a.DPCID\r\n"
                                               		+ "inner join jcirodetails c on d.rocode = c.rocode ";

                                           } else {
                                                          sqlString = " select distinct(a.Contract_no) from jcibos_generation a INNER JOIN "
                                                                                      + " jciweighment_entry b on b.Verification_status = 1 and b.Bos_no = (select a.Bill_of_supply_no where "
                                                                                      + " a.Challan_No not in (select distinct ChallanNo from jcicredit_note where Crn_status = 0))";
                                           }
                             }

                             List<String> datalist = currentSession().createSQLQuery(sqlString).list();

                             return datalist;
              }

              @Override
              public List<Object[]> showFilterData(String parameter, String basedOn) {

                             Integer roleId = (Integer) session.getAttribute("roleId");
                             String region = (String) session.getAttribute("region");

                             String sqlString = "";

                             if (roleId == 6 || roleId == 7 || roleId == 8) {

                                           if (parameter.equals("Region")) {
                                                          sqlString = "select a.Bill_of_supply_no,a.BOS_date,a.Contract_no ,a.Challan_No, a.Invoice_value, b.Nominal_wt , b.Dpc_actual_wt, c.Mill_name , c.DI_No , a.Ro_id , c.Mill_code,a.Bos_file_path,b.Dpc_wt_doc , c.Consignment_note from "
                                                                                      + "jcibos_generation a INNER JOIN jciweighment_entry b on b.Verification_status = 1 and b.Bos_no = (select a.Bill_of_supply_no where "
                                                                                      + " a.Challan_No not in (select distinct ChallanNo from jcicredit_note where Crn_status = 0)) and b.Ro_id = '"
                                                                                      + basedOn + "' inner JOIN jcidispatch_details c on a.Challan_No = c.Challan_no and a.Ro_id = '"
                                                                                      + region + "'";
                                           } else {
                                                          sqlString = "select a.Bill_of_supply_no,a.BOS_date ,a.Contract_no ,a.Challan_No, a.Invoice_value, b.Nominal_wt , b.Dpc_actual_wt ,c.Mill_name , c.DI_No ,a.Ro_id,c.Mill_code,a.Bos_file_path,b.Dpc_wt_doc,c.Consignment_note from  "
                                                                                      + "jcibos_generation a INNER JOIN jciweighment_entry b on b.Verification_status = 1 and b.Bos_no = (select a.Bill_of_supply_no where "
                                                                                      + " a.Challan_No not in (select distinct ChallanNo from jcicredit_note where Crn_status = 0)) and a.Contract_no = '"
                                                                                      + basedOn + "' inner JOIN jcidispatch_details c on a.Challan_No = c.Challan_no and a.Ro_id = '"
                                                                                      + region + "'";
                                           }

                             } else {

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
                             String sql = "select a.Crop_year,a.Bale_mark,a.Jute_grade,a.No_of_bales,a.Nominal_qty,a.Rate,a.Nominal_wt,\r\n"
                                                          + "   CONVERT(VARCHAR, b.Contract_date, 105) AS Contract_date,\r\n"
                                                          + "    CONVERT(VARCHAR, b.DI_Date, 105) AS DI_Date,\r\n"
                                                          + "    CONVERT(VARCHAR, b.Date_of_shipment, 105) AS Date_of_shipment ,  b.Consignment_note_text "
                                                          + " from  jcidispatch_details_child a INNER join jcidispatch_details b on a.Challan_no = b.Challan_no and a.Challan_no='"
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
                                                          + "  ,a.Ro_id,c.Mill_code , c.Place_of_Shipment ,a.Statecode_forBOs, c.Contract_date , c.DI_Date,c.Date_of_shipment  from  jcibos_generation a INNER JOIN jciweighment_entry b"
                                                          + "  on b.Verification_status = 1 and a.Bill_of_supply_no = b.Bos_no and a.Challan_No = '" + challan
                                                          + "'" + " inner JOIN jcidispatch_details c on a.Challan_No = c.Challan_no";

                             List<Object> resultList1 = (List<Object>) currentSession().createSQLQuery(sql).list();
                             return resultList1;
              }

              @Override
              public List<Object[]> getDetailsofSpp_Con_Rec(String bosNo) {
                             String sql = "select Supplier_name , Supplier_address , Supplier_gSTN , Recipient_name , "
                                                          + "Recipient_address , Recipient_gSTN , Consignee_name , Consignee_address ,"
                                                          + " Consignee_gSTN from jcibos_generation where Bill_of_supply_no = '" + bosNo + "'";
                             return (List<Object[]>) currentSession().createSQLQuery(sql).list();
              }

              @Override
              public List<Object[]> getStateAndPan(String millcode) {
                             String sql2 = "select a.client_pan , a.client_state , b.unit_state , c.state_name , c.gov_state_code , c.state_code from jcimilldetailmaster a \r\n"
                                                          + "inner join \r\n" + "jcimilldetailchild b on a.client_code = b.client_code and b.client_unit_code = '"
                                                          + millcode + "' " + " INNER JOIN\r\n"
                                                          + "  tbl_states_new c on c.state_code = a.client_state or  c.gov_state_code = b.unit_state ";

                             return (List<Object[]>) currentSession().createSQLQuery(sql2).list();
              }

              @Override
              public List<Object[]> getStateAndCodeOfSupplier(String dpc) {
                             String sql = "select top 1 a.state_name , a.gov_state_code , e.State_GSTIN from tbl_states_new a\r\n"
                                                          + "INNER join tbl_districts_new b on b.state_code = a.state_code\r\n"
                                                          + "INNER JOIN jcipurchasecenter c on c.district = b.dist_code \r\n"
                                                          + "INNER JOIN jcidispatch_details d ON c.CENTER_CODE = d.Place_of_Shipment\r\n"
                                                          + "INNER JOIN jcigstin e on e.State_GST_Code = a.gov_state_code " + "WHERE c.CENTER_CODE = '" + dpc
                                                          + "'";

                             return (List<Object[]>) currentSession().createSQLQuery(sql).list();
              }

              @Override
              public int getTotalCount() {
                             String sql = "select count( distinct Credit_note_no) from jcicredit_note where Crn_status = 0";
                             return (int) currentSession().createSQLQuery(sql).uniqueResult();
              }

              ///////////////////////////////////////////// settlement of credit and debit
              ///////////////////////////////////////////// notes
              ///////////////////////////////////////////// /////////////////////////////////////////////////////////////////////////////////////////////////

              @Override
              public List<String> getMillNames() {

                             Integer roleId = (Integer) session.getAttribute("roleId");
                             String region = (String) session.getAttribute("region");

                             String sqlString = "";

                             if (roleId == 6 || roleId == 7 || roleId == 8) {
                                           sqlString = "SELECT DISTINCT CONCAT(a.client_name,'&-&', b.client_unit_code) as mill FROM jcimilldetailmaster a\r\n"
                                                                        + "INNER JOIN jcimilldetailchild b ON a.client_code = b.client_code\r\n"
                                                                        + "INNER JOIN jcicontract c ON c.Mill_code = b.client_unit_code\r\n"
                                                                        + "LEFT JOIN jcicredit_note d ON d.Contract_no = c.Contract_no\r\n"
                                                                        + "LEFT JOIN jcicredit_note_settled e ON e.Contract_no = c.Contract_no\r\n"
                                                                        + "LEFT JOIN jcidemand_note f ON f.Contract_no = c.Contract_no\r\n" + "WHERE d.Ro_id = '" + region
                                                                        + "' and d.Contract_no IS NOT NULL OR e.Contract_no IS NOT NULL  OR f.Contract_no IS NOT NULL";

                             } else {
                                           sqlString = "SELECT DISTINCT CONCAT(a.client_name,'&-&', b.client_unit_code) as mill FROM jcimilldetailmaster a\r\n"
                                                                        + "INNER JOIN jcimilldetailchild b ON a.client_code = b.client_code\r\n"
                                                                        + "INNER JOIN jcicontract c ON c.Mill_code = b.client_unit_code\r\n"
                                                                        + "LEFT JOIN jcicredit_note d ON d.Contract_no = c.Contract_no\r\n"
                                                                        + "LEFT JOIN jcicredit_note_settled e ON e.Contract_no = c.Contract_no\r\n"
                                                                        + "LEFT JOIN jcidemand_note f ON f.Contract_no = c.Contract_no\r\n"
                                                                        + "WHERE d.Contract_no IS NOT NULL OR e.Contract_no IS NOT NULL  OR f.Contract_no IS NOT NULL ";
                             }

                             return (List<String>) currentSession().createSQLQuery(sqlString).list();
              }

//           @Override
//    public List<String> getAllContractNos(String millCode) {
//          String sql ="SELECT DISTINCT C.Contract_no " +
//             "FROM jcicredit_note C " +
//             "INNER JOIN jcicontract a ON C.Contract_no = a.Contract_no " +
//             "WHERE a.Mill_code = '"+millCode+"' " +
//             "UNION " +
//             "SELECT DISTINCT d.Contract_no " +
//             "FROM jcidemand_note d " +
//             "INNER JOIN jcicontract a ON d.Contract_no = a.Contract_no " +
//             "WHERE a.Mill_code = '"+millCode+"'";
//          return (List<String>) currentSession().createSQLQuery(sql).list();
//    }
              @Override
              public List<String> getAllContractNos(String millCode) {

                             Integer roleId = (Integer) session.getAttribute("roleId");
                             String region = (String) session.getAttribute("region");

                             String sql = "";

                             if (roleId == 6 || roleId == 7 || roleId == 8) {
                                           sql = "SELECT DISTINCT C.Contract_no " + "FROM jcicredit_note C "
                                                                        + "INNER JOIN jcicontract a ON C.Contract_no = a.Contract_no " + "WHERE a.Mill_code = '" + millCode
                                                                        + "' " + "UNION " + "SELECT DISTINCT d.Contract_no " + "FROM jcidemand_note d "
                                                                        + "INNER JOIN jcicontract a ON d.Contract_no = a.Contract_no " + "WHERE a.Mill_code = '" + millCode
                                                                        + "' " + "UNION " + "SELECT DISTINCT s.Contract_no " + "FROM jcicredit_note_settled s "
                                                                        + "INNER JOIN jcicontract a ON s.Contract_no = a.Contract_no " + "WHERE a.Mill_code = '" + millCode
                                                                        + "' and C.Ro_id = '" + region + "'";
                             }else {
                                           sql = "SELECT DISTINCT C.Contract_no " + "FROM jcicredit_note C "
                                                                        + "INNER JOIN jcicontract a ON C.Contract_no = a.Contract_no " + "WHERE a.Mill_code = '" + millCode
                                                                        + "' " + "UNION " + "SELECT DISTINCT d.Contract_no " + "FROM jcidemand_note d "
                                                                        + "INNER JOIN jcicontract a ON d.Contract_no = a.Contract_no " + "WHERE a.Mill_code = '" + millCode
                                                                        + "' " + "UNION " + "SELECT DISTINCT s.Contract_no " + "FROM jcicredit_note_settled s "
                                                                        + "INNER JOIN jcicontract a ON s.Contract_no = a.Contract_no " + "WHERE a.Mill_code = '" + millCode
                                                                        + "'";
                             }
                             
              
                             return (List<String>) currentSession().createSQLQuery(sql).list();
              }

//           @Override
//           public List<Object[]> getFullDetailsOfCrnAndDebit(String contract) {
//               // Define the first SQL query
//                         
//                         //credit note
//                String creditNote =  "SELECT DISTINCT " +
//                                 "    a.Credit_note_no, " +
//                                 "    SUM(a.Credit_note_amount) AS creditNoteAmount, " +
//                                 "    a.Credit_note_date, " +
//                                 "    a.ChallanNo, " +
//                                 "    c.Consignment_note_text, " +
//                                 "    d.Bill_of_supply_no, " +
//                                 "    CONVERT(VARCHAR(10), c.Date_of_shipment, 103) AS Date_of_Shipment, " +
//                                 "    d.Bos_file_path, " +
//                                 "    c.DI_No, " +
//                                 "    c.Consignment_note, " +
//                                 "    a.document " +
//                                 "FROM " +
//                                 "    jcicredit_note a " +
//                                 "LEFT JOIN " +
//                                 "    jcicredit_note_settled b ON a.ChallanNo = b.Challan_No " +
//                                 "LEFT JOIN " +
//                                 "    jcidispatch_details c ON c.Challan_no = a.ChallanNo " +
//                                 "LEFT JOIN " +
//                                 "    jcibos_generation d ON d.Challan_No = a.ChallanNo " +
//                                "WHERE " +
//                                 "    b.Challan_No IS NULL " +
//                                 "    AND a.Contract_no = '"+contract+"' " +  // Parameterized query
//                                 "    AND a.Credit_note_no NOT IN ( " +
//                                 "        SELECT Credit_note_no " +
//                                 "        FROM jcisettlement_cndn " +
//                                 "    ) " +
//                                 "GROUP BY " +
//                                 "    a.Credit_note_no, " +
//                                 "    a.Credit_note_date, " +
//                                 "    a.ChallanNo, " +
//                                 "    c.Consignment_note_text, " +
//                                 "    d.Bill_of_supply_no, " +
//                                 "    c.Date_of_shipment, " +
//                                 "    d.Bos_file_path, " +
//                                 "    c.DI_No, " +
//                                 "    c.Consignment_note, " +
//                                 "    a.document";
//               
//               String creditNoteSettle ="SELECT Distinct\r\n"
//                                        + "    s.Credit_note_no,\r\n"
//                                        + "    SUM(s.Credit_note_amt) AS Credit_note_amt,  -- Sum the Credit_note_amt\r\n"
//                                        + "    s.Credit_note_date,\r\n"
//                                        + "    s.Challan_No,\r\n"
//                                        + "    d.Consignment_note_text,\r\n"
//                                        + "    b.Bill_of_supply_no,\r\n"
//                                        + "    CONVERT(VARCHAR(10), d.Date_of_shipment, 103) AS Date_of_Shipment,\r\n"
//                                        + "    CONVERT(VARCHAR(10),  n.Date_of_Inspection, 103) As  Date_of_Inspection,\r\n"
//                                        + "\r\n"
//                                        + "    s.SettlementId,\r\n"
//                                        + "    b.Bos_file_path,\r\n"
//                                        + "    s.HoDi_No,\r\n"
//                                        + "    d.Consignment_note,\r\n"
//                                        + "    s.doc\r\n"
//                                        + "FROM\r\n"
//                                        + "    jcicredit_note_settled s\r\n"
//                                        + "INNER JOIN\r\n"
//                                        + "    jcidispatch_details d ON   s.Challan_No = d.Challan_no \r\n"
//                                        + "INNER JOIN\r\n"
//                                        + "    jcibos_generation b ON s.Challan_No = b.Challan_No \r\n"
//                                        + "INNER JOIN\r\n"
//                                        + "  jciclaim_report_mill n ON s.Challan_No= n.Challan_No and s.Variety_grade = n.Jute_Grade and s.SettlementId = n.Settlement_id\r\n"
//                                        + "WHERE\r\n"
//                                        + "    s.Contract_no = '"+contract+"'    -- Replace @contract with your actual contract number or variable\r\n"
//                                        + "    AND s.Credit_note_no NOT IN (\r\n"
//                                        + "        SELECT Credit_note_no\r\n"
//                                        + "        FROM jcisettlement_cndn\r\n"
//                                        + "    )\r\n"
//                                        + "GROUP BY\r\n"
//                                        + "    s.Credit_note_no,\r\n"
//                                        + "    s.Credit_note_date,\r\n"
//                                        + "    s.Challan_No,\r\n"
//                                        + "    d.Consignment_note_text,\r\n"
//                                        + "    b.Bill_of_supply_no,\r\n"
//                                        + "    Date_of_shipment,\r\n"
//                                        + "    Date_of_Inspection,\r\n"
//                                        + "    s.SettlementId,\r\n"
//                                        + "    b.Bos_file_path,\r\n"
//                                        + "    s.HoDi_No,\r\n"
//                                        + "    d.Consignment_note,\r\n"
//                                        + "    s.doc\r\n"
//                                        + "";
//              
//               String demadNote =   "SELECT " +
//                       "    f.Demand_note_no, " +
//                       "    f.Carrying_cost, " +
//                       "    CONVERT(VARCHAR(10), f.Demand_note_date, 103) AS Demand_note_date, "+
//                                                      /* "    f.Demand_note_date, " + */
//                       "    f.DocumentName " +
//                       "FROM " +
//                       "    jcidemand_note f " +
//                       "WHERE " +
//                       "    f.Contract_no = '"+contract+"' " +
//                       "    AND f.Demand_note_no NOT IN ( " +
//                       "        SELECT Credit_note_no " +
//                       "        FROM jcisettlement_cndn " +
//                       "    )";
//
//
//               // Execute the first query
//               List<Object[]> creditNote1= (List<Object[]>) currentSession().createSQLQuery(creditNote).list();
//
//               // Execute the second query
//               List<Object[]> creditNoteSettle1 = (List<Object[]>) currentSession().createSQLQuery(creditNoteSettle).list();
//
//           // Execute the third query
//               List<Object[]> demandNote1 = (List<Object[]>) currentSession().createSQLQuery(demadNote).list();
//               // Create a list to hold the combined results
//               List<Object[]> combinedResults = new ArrayList<>();
//
//               // Add results from the first query
//               for (Object[] record : creditNote1) {
//                   combinedResults.add(record);
//               }
//               for (Object[] record : creditNoteSettle1) {
//                   combinedResults.add(record);
//               }
//
//               // Add results from the second query
//               for (Object[] record : demandNote1) {
//                   combinedResults.add(record);
//               }
//
//               // Return the combined results
//               return combinedResults;
//           }

              @Override
              public List<Object[]> getFullDetailsOfCrnAndDebit(String contract) {
                             // Define the first SQL query

                             // credit note
                             String creditNote = "SELECT DISTINCT " + "    a.Credit_note_no, "
                                                          + "    SUM(a.Credit_note_amount) AS creditNoteAmount, " + "    a.Credit_note_date, "
                                                          + "    a.ChallanNo, " + "    c.Consignment_note_text, " + "    d.Bill_of_supply_no, "
                                                          + "    CONVERT(VARCHAR(10), c.Date_of_shipment, 103) AS Date_of_Shipment, " + "    d.Bos_file_path, "
                                                          + "    c.DI_No, " + "    c.Consignment_note, " + "    a.document " + "FROM " + "    jcicredit_note a "
                                                          + "LEFT JOIN " + "    jcicredit_note_settled b ON a.ChallanNo = b.Challan_No " + "LEFT JOIN "
                                                          + "    jcidispatch_details c ON c.Challan_no = a.ChallanNo " + "LEFT JOIN "
                                                          + "    jcibos_generation d ON d.Challan_No = a.ChallanNo " + "WHERE " + "    b.Challan_No IS NULL "
                                                          + "    AND a.Contract_no = '" + contract + "' " + // Parameterized query
                                                          "    AND a.Credit_note_no NOT IN ( " + "        SELECT Credit_note_no "
                                                          + "        FROM jcisettlement_cndn " + "    ) " + "GROUP BY " + "    a.Credit_note_no, "
                                                          + "    a.Credit_note_date, " + "    a.ChallanNo, " + "    c.Consignment_note_text, "
                                                          + "    d.Bill_of_supply_no, " + "    c.Date_of_shipment, " + "    d.Bos_file_path, " + "    c.DI_No, "
                                                          + "    c.Consignment_note, " + "    a.document";

                             String creditNoteSettle = "SELECT DISTINCT\r\n" + "    s.Credit_note_no,\r\n"
                                                          + "    SUM(s.Credit_note_amt) AS Credit_note_amt,  -- Sum the Credit_note_amt\r\n"
                                                          + "    s.Credit_note_date,\r\n" + "    s.Challan_No,\r\n" + "    d.Consignment_note_text,\r\n"
                                                          + "    b.Bill_of_supply_no,\r\n"
                                                          + "    CONVERT(VARCHAR(10), d.Date_of_shipment, 103) AS Date_of_Shipment,\r\n"
                                                          + "    CONVERT(VARCHAR(10), n.Date_of_Inspection, 103) AS Date_of_Inspection,\r\n"
                                                          + "    s.SettlementId,\r\n" + "    b.Bos_file_path,\r\n" + "    s.HoDi_No,\r\n"
                                                          + "    d.Consignment_note,\r\n" + "   c.Credit_note_no As creditnote,\r\n" + "    s.doc\r\n" + "\r\n"
                                                          + "FROM\r\n" + "    jcicredit_note_settled s\r\n"
                                                          + "INNER JOIN jcicredit_note c ON s.Challan_No = c.ChallanNo AND s.Variety_grade = c.Jute_Grade\r\n"
                                                          + "INNER JOIN jcidispatch_details d ON s.Challan_No = d.Challan_no\r\n"
                                                          + "INNER JOIN jcibos_generation b ON s.Challan_No = b.Challan_No\r\n"
                                                          + "INNER JOIN jciclaim_report_mill n ON s.Challan_No = n.Challan_No AND s.Variety_grade = n.Jute_Grade AND s.SettlementId = n.Settlement_id\r\n"
                                                          + "WHERE\r\n" + "    s.Contract_no = '" + contract
                                                          + "'  -- Replace @contract with your actual contract number or variable\r\n"
                                                          + "    AND c.Credit_note_no NOT IN (\r\n" + "        SELECT Credit_note_no\r\n"
                                                          + "        FROM jcisettlement_cndn\r\n" + "    )\r\n" + "GROUP BY\r\n" + "    s.Credit_note_no,\r\n"
                                                          + "    s.Credit_note_date,\r\n" + "    s.Challan_No,\r\n" + "    d.Consignment_note_text,\r\n"
                                                          + "    b.Bill_of_supply_no,\r\n" + "    d.Date_of_shipment,\r\n" + "    n.Date_of_Inspection,\r\n"
                                                          + "    s.SettlementId,\r\n" + "    b.Bos_file_path,\r\n" + "    s.HoDi_No,\r\n"
                                                          + "    d.Consignment_note,\r\n" + "    c.Credit_note_no,\r\n" + "    s.doc";
                             String demadNote = "SELECT " + "    f.Demand_note_no, " + "    f.Carrying_cost, "
                                                          + "    CONVERT(VARCHAR(10), f.Demand_note_date, 103) AS Demand_note_date, " +
                                                          /* "    f.Demand_note_date, " + */
                                                          "    f.DocumentName " + "FROM " + "    jcidemand_note f " + "WHERE " + "    f.Contract_no = '"
                                                          + contract + "' " + "    AND f.Demand_note_no NOT IN ( " + "        SELECT Credit_note_no "
                                                          + "        FROM jcisettlement_cndn " + "    )";

                             // Execute the first query
                             List<Object[]> creditNote1 = (List<Object[]>) currentSession().createSQLQuery(creditNote).list();

                             // Execute the second query
                             List<Object[]> creditNoteSettle1 = (List<Object[]>) currentSession().createSQLQuery(creditNoteSettle).list();

                             // Execute the third query
                             List<Object[]> demandNote1 = (List<Object[]>) currentSession().createSQLQuery(demadNote).list();
                             // Create a list to hold the combined results
                             List<Object[]> combinedResults = new ArrayList<>();

                             // Add results from the first query
                             for (Object[] record : creditNote1) {
                                           combinedResults.add(record);
                             }
                             for (Object[] record : creditNoteSettle1) {
                                           combinedResults.add(record);
                             }

                             // Add results from the second query
                             for (Object[] record : demandNote1) {
                                           combinedResults.add(record);
                             }

                             // Return the combined results
                             return combinedResults;
              }

              @Override
              public List<settlemetCnDnModel> getAll() {

//                           String sqlQuery = "SELECT Contract_no, Credit_note_no, bosNo, "
//                       + "consigneeNoteText, creditNoteAmount,  dateOfInspection, "
//                       + "dateOfIssue, dateOfShipment, hodi, settlementId , cndnExcel_link, IdentificationCnDn ,AmountDiffCnAndDn, purpose ,cbiMandateDoc FROM jcisettlement_cndn";

                             String sqlQuery = "SELECT distinct Contract_no, cndnExcel_link, IdentificationCnDn , cbiMandateDoc FROM jcisettlement_cndn";
                             List<Object[]> contracts = currentSession().createSQLQuery(sqlQuery).list();

                             List<settlemetCnDnModel> list = new ArrayList<>();

//                         for (Object[] result : contracts) {
//                                        settlemetCnDnModel settlementCnDn = new settlemetCnDnModel();
//                                        String difference = String.valueOf(result[12]);
//                                        settlementCnDn.setContractNo((String) result[0]);
//                   settlementCnDn.setCreditNoteNo((String) result[1]);
//                   settlementCnDn.setBosNo((String) result[2]);
//                   settlementCnDn.setConsigneeNoteText((String) result[3]);
//                   settlementCnDn.setCreditNoteAmount((String) result[4]);
//                   settlementCnDn.setDateOfInspection((String) result[5]);
//                   settlementCnDn.setDateOfIssue((String) result[6]);
//                   settlementCnDn.setDateOfShipment((String) result[7]);
//                   settlementCnDn.setHodi((String) result[8]);
//                   settlementCnDn.setSettlementId((String) result[9]);
//                   settlementCnDn.setCndnExcel_link((String) result[10]);
//                   settlementCnDn.setIdentificationCnDn((String)result[11]);
//                   settlementCnDn.setBosDoc(difference);
//                   settlementCnDn.setPurpose((String)result[13]);
//                   settlementCnDn.setCbiMandateDoc((String)result[14]);
//                   list.add(settlementCnDn);
//
//                         }

                             for (Object[] result : contracts) {
                                           settlemetCnDnModel settlementCnDn = new settlemetCnDnModel();

                                           settlementCnDn.setContractNo((String) result[0]);
                                           settlementCnDn.setCndnExcel_link((String) result[1]);
                                           settlementCnDn.setIdentificationCnDn((String) result[2]);
                                           settlementCnDn.setCbiMandateDoc((String) result[3]);
                                           list.add(settlementCnDn);

                             }

                             return list;

              }

              @Override
              public int CountRecord() {

                             String q = "SELECT MAX(RowNumber) AS LastRowNumber FROM jcisettlement_cndn";

                             Object result = this.sessionFactory.getCurrentSession().createSQLQuery(q).uniqueResult();

                        
                              int lastRowNumber = (result != null) ? ((Number) result).intValue() : 0; 

                         
                             return lastRowNumber;

              }
//           

              @Override
              public List<Object[]> getMillDetails(String millcode) {

                             String milldetails = "SELECT  m.client_bank_ifsc ,m.client_bank_ac  ,m.client_name , m.client_bank  from jcimilldetailchild c\r\n"
                                                          + "INNER JOIN jcimilldetailmaster m ON c.client_code=m.client_code\r\n" + " where c.client_unit_code='"
                                                          + millcode + "'";

                             List<Object[]> getallmilldetails = (List<Object[]>) currentSession().createSQLQuery(milldetails).list();

                             List<Object[]> combinedResults = new ArrayList<>();

                             for (Object[] record : getallmilldetails) {
                                           combinedResults.add(record);
                             }

                             return combinedResults;
              }

              @Override
              public List<settlemetCnDnModel> getAlldetails(String cndnIdentificationNumber) {
                             // TODO Auto-generated method stub

                             String sqlQuery = "\r\n"
                                                          + "SELECT distinct Credit_note_no,purpose, dateOfIssue,hodi,consigneeNoteText,bosNo,dateOfShipment,dateOfInspection,creditNoteAmount,AmountDiffCnAndDn,settlementId  from jcisettlement_cndn WHERE IdentificationCnDn='"
                                                          + cndnIdentificationNumber + "'";

                             List<Object[]> contracts = currentSession().createSQLQuery(sqlQuery).list();

                             List<settlemetCnDnModel> list = new ArrayList<>();

                             for (Object[] object : contracts) {
                                           settlemetCnDnModel cndn = new settlemetCnDnModel();

                                           String amountDiff = String.valueOf(object[9]);

                                           cndn.setCreditNoteNo((String) object[0]);
                                           cndn.setPurpose((String) object[1]);
                                           cndn.setDateOfIssue((String) object[2]);
                                           cndn.setHodi((String) object[3]);
                                           cndn.setConsigneeNoteText((String) object[4]);
                                           cndn.setBosNo((String) object[5]);
                                           cndn.setDateOfShipment((String) object[6]);
                                           cndn.setDateOfInspection((String) object[7]);
                                           cndn.setCreditNoteAmount((String) object[8]);
                                           cndn.setAmountDiffCnAndDn(Double.parseDouble((String) object[9]));
                                           cndn.setSettlementId((String) object[10]);

                                           list.add(cndn);

                             }

                             return list;

              }

              @Override
              public String getAccountNo() {
                             // TODO Auto-generated method stub
                             String sql = "SELECT bankACno from jcirodetails WHERE officetype ='H'";

                             String result = (String) currentSession().createSQLQuery(sql).uniqueResult();
                             return result;

              }

}
