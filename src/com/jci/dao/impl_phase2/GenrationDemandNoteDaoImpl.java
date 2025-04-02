
package com.jci.dao.impl_phase2;

import java.math.BigInteger;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.jci.dao_phase2.GenrationDemandNoteDao;
import com.jci.model.GenrationDemandNoteModel;
import com.jci.model.MillRecieptModel;
import com.jci.model.GenrationDEmandDto;

@Repository
@Transactional
public class GenrationDemandNoteDaoImpl implements GenrationDemandNoteDao  {
              @Autowired
              SessionFactory sessionFactory;
              protected Session currentSession(){
                             return sessionFactory.getCurrentSession();
              }
              
              @Override
              public void create(GenrationDemandNoteModel genrationDemandNoteModel) {
                             
                            currentSession().saveOrUpdate(genrationDemandNoteModel);
              }
              @Override
              public List<GenrationDemandNoteModel> getAll() {
                  Criteria criteria = currentSession().createCriteria(GenrationDemandNoteModel.class);
                  
                  // Adding an Order object to criteria to sort by Created_on column in descending order
                  criteria.addOrder(Order.desc("Created_on"));
                  
                  return criteria.list();
              }

              @Override
              public void update(GenrationDemandNoteModel genrationDemandNoteModel) {
                             currentSession().update(genrationDemandNoteModel);
              }

              @Override
              public GenrationDemandNoteModel edit(int id) {
                             return find(id);
              }

              public GenrationDemandNoteModel find(int id) {
                             // TODO Auto-generated method stub
                             return (GenrationDemandNoteModel) currentSession().get(GenrationDemandNoteModel.class, id);
              }

              
              

              @Override
                  public GenrationDemandNoteModel getById(int id) {
                      return (GenrationDemandNoteModel) sessionFactory.getCurrentSession().get(GenrationDemandNoteModel.class, id);
                  }

              @Override
              public List<Object[]> fetchContract_no(String st) {
                             
                             
                             
                                           String sql = " Select a.Contract_date , a.Payment_duedate, a.Contract_cancel_date , b.Instrument_No ,a.Mill_qty,CONVERT(VARCHAR, b.Instrument_Date, 105) AS PaymentDate,b.Supporting_document,c.fcdocumentDownload from jcicontract a\r\n"
                                                                        + "                                                                   Inner join jcipayment_arrangement b on a.Contract_No= b.Contract_No\r\n"
                                                                        + "                                                                     inner join jcifinancial_concurrence c on a.Contract_no= c.Contractno\r\n"
                                                                        + "                                                                   where a.Contract_No='"+st+"';";
                             
              
                             
                                            List<Object[]>resultList1= (List<Object[]>)this.sessionFactory.getCurrentSession().createSQLQuery(sql).list();
       
                   System.err.println(resultList1);
                             
//           
                             return   resultList1;
              }
              @Override
              public List<Object> fetchcon_no() {
              
                            String sql="select Distinct Contractno from jcifinancial_concurrence where Carrying_Cost_Charged <>0;  ";
                                                          
                             //String sql=" select dd.Challan_no,dd.Date_of_shipment,dd.Vehicle_no,dd.Bale_mark,dd.Jute_variety,dd.Crop_year,mr.MR_No from  jcidispatch_details as dd join jcimill_receipt as mr on dd.Dientry_id=mr.Mr_id ";

                             //String sql="select Challan_no,Date_of_shipment,Vehicle_no,Bale_mark,Jute_variety,Crop_year from  jcidispatch_details";
                  List<Object>resultList1= (List<Object>)this.sessionFactory.getCurrentSession().createSQLQuery(sql).list();
                  return resultList1;

//           
                             
              }

              @Override
              public String demandnono(String st) 
              {
                             
                             String sql ="SELECT  count(*) FROM jcidemand_note WHERE Demand_note_no = '" + st + "' ";
                             int  total = (Integer)this.sessionFactory.getCurrentSession().createSQLQuery(sql).uniqueResult();                             
                             
                             
                             if(total>0)
                                           return "1";
                             else 
                                           return "0";

              
              }

              @Override
              public String count() {
                  String sql = "SELECT \r\n"
                                           + "    CASE \r\n"
                                           + "        WHEN LEN(CAST(COALESCE(MAX(CAST(SUBSTRING(Demand_note_no, 4, 6) AS INT)), 0) + 1 AS VARCHAR)) > 6 \r\n"
                                           + "        THEN CAST(COALESCE(MAX(CAST(SUBSTRING(Demand_note_no, 4, 6) AS INT)), 0) + 1 AS VARCHAR)\r\n"
                                           + "        ELSE RIGHT('000000' + CAST(COALESCE(MAX(CAST(SUBSTRING(Demand_note_no, 4, 6) AS INT)), 0) + 1 AS VARCHAR), 6)\r\n"
                                           + "    END AS next_bill_of_supply_no\r\n"
                                           + "FROM jcidemand_note\r\n"
                                           + "WHERE ISNUMERIC(SUBSTRING(Demand_note_no, 4, 6)) = 1\r\n"
                                           + "AND Created_on >= DATEFROMPARTS(YEAR(GETDATE()) - CASE WHEN MONTH(GETDATE()) < 4 THEN 1 ELSE 0 END, 4, 1)  -- Start of current financial year (April 1st)\r\n"
                                           + "AND Created_on < DATEFROMPARTS(YEAR(GETDATE()) + CASE WHEN MONTH(GETDATE()) >= 4 THEN 1 ELSE 0 END, 4, 1)  -- Before next financial year (April 1st next year)\r\n"
                                           + "AND YEAR(Created_on) = YEAR(GETDATE()) - CASE WHEN MONTH(GETDATE()) < 4 THEN 1 ELSE 0 END;  -- Ensure it's the current financial year\r\n"
                                           + "";
                  String count = (String) this.sessionFactory.getCurrentSession().createSQLQuery(sql).uniqueResult();

                  // Handle null case if count is null
                
                  // Convert to String and return
                  return String.valueOf(count);
              }

              @Override
              public List<Object[]> getData(String contract_No) {
                             // TODO Auto-generated method stub
                             String sql ="SELECT\r\n"
                                                         + "    a.unit_name,\r\n"
                                                         + "    a.unit_address1,\r\n"
                                                         + "    a.unit_address2,\r\n"
                                                         + "    a.unit_location,\r\n"
                                                         + "    a.unit_pin,\r\n"
                                                         + "    a.unit_state,\r\n"
                                                         + "    d.state_name,\r\n"
                                                         + "    b.client_gstin,\r\n"
                                                         + "    b.client_pan,\r\n"
                                                         + "    b.client_state,\r\n"
                                                         + "    b.client_address1,\r\n"
                                                         + "    b.client_address2,\r\n"
                                                         + "    b.client_location,\r\n"
                                                         + "    b.client_pin,\r\n"
                                                         + "    b.client_name,\r\n"
                                                         + "    a.client_unit_code,\r\n"
                                                         + "    b.client_pan,\r\n"
                                                         + "    tbl_states_new.state_name,\r\n"
                                                         + "    tbl_states_new.gov_state_code\r\n"
                                                         + "FROM\r\n"
                                                         + "    jcimilldetailchild AS a\r\n"
                                                         + "LEFT JOIN\r\n"
                                                         + "    jcimilldetailmaster AS b ON a.client_code = b.client_code\r\n"
                                                         + "INNER JOIN\r\n"
                                                         + "    jcicontract AS c ON c.Mill_code = a.client_unit_code\r\n"
                                                         + "INNER JOIN\r\n"
                                                         + "    tbl_states_new AS d ON d.gov_state_code = a.unit_state\r\n"
                                                         + "inner join \r\n"
                                                         + "tbl_states_new on tbl_states_new.state_code=b.client_state\r\n"
                                                         + "WHERE\r\n"
                                                         + "    c.Contract_no = '"+contract_No+"';";
                                                          List<Object[]>resultList1= (List<Object[]>)this.sessionFactory.getCurrentSession().createSQLQuery(sql).list();
                                 return resultList1;
              }

              @Override
              public List<Object[]> getDemandNote(String demand_note_no) {
                             // TODO Auto-generated method stub
                             String sql ="SELECT \r\n"
                                                         + "    a.Contract_no,\r\n"
                                                         + "    a.Contract_date,\r\n"
                                                         + "    a.Contracted_qty,\r\n"
                                                         + "    a.Payment_due_date,\r\n"
                                                         + "    a.Payment_ref,\r\n"
                                                         + "    a.Delay_period,\r\n"
                                                         + "    CONVERT(VARCHAR(10), b.Instrument_Date, 105) AS Payment_Date,\r\n"
                                                         + "    CONVERT(VARCHAR(10), a.Demand_note_date, 105) AS DemandDate,\r\n"
                                                         + "    a.Carrying_cost\r\n"
                                                         + "FROM \r\n"
                                                         + "    jcidemand_note a\r\n"
                                                         + "INNER JOIN \r\n"
                                                         + "    jcipayment_arrangement b ON b.Contract_No = a.Contract_no\r\n"
                                                         + "WHERE \r\n"
                                                         + "    a.Demand_note_no = '"+demand_note_no+"';";
                             List<Object[]>resultList1= (List<Object[]>)this.sessionFactory.getCurrentSession().createSQLQuery(sql).list();
                                 return resultList1;
              }

              @Override
              public List<Object[]> Debitdetails(String demand_note_no) {
                             // TODO Auto-generated method stub
                             String sqlString ="Select a.Contract_no,a.Contract_date,b.Instrument_No,CONVERT(VARCHAR(10), b.Instrument_Date, 105) as Payment_Date,CONVERT(VARCHAR(10), a.Demand_note_date, 105) as DemandDatefrom, a.Demand_note_no ,a.Unit_charge from jcidemand_note a inner join jcipayment_arrangement b\r\n"
                                                          + "on b.Contract_No = a.Contract_no \r\n"
                                                          + "where a.Demand_note_no='"+demand_note_no+"';";
                                                          List<Object[]>resultList1= (List<Object[]>)this.sessionFactory.getCurrentSession().createSQLQuery(sqlString).list();
                                                              return resultList1;
              }

              @Override
              public void UpdateStatus(String contract_No) {
                             // TODO Auto-generated method stub
                             String sqlString="Update jcicontract SET Contract_status='Demand Note Generated' where Contract_no='"+contract_No+"';";
                             currentSession().createSQLQuery(sqlString).executeUpdate();
                             return;
              }


                             
              }
              


