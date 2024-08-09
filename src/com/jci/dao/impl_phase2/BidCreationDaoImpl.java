package com.jci.dao.impl_phase2;

import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.jci.dao_phase2.BidCreationDao;
import com.jci.model.BidCreation;

@Transactional
@Repository
public class BidCreationDaoImpl implements BidCreationDao {
              
                  @Autowired
                             SessionFactory sessionFactory;
        protected Session currentSession() {
                                           return sessionFactory.getCurrentSession();
                             }
                             @Override
                             public List<BidCreation> getAllbid() {
                                           Criteria c = this.sessionFactory.getCurrentSession().createCriteria(BidCreation.class);
                                           List<BidCreation> ll=c.list();
                                           return ll;
                             }
                             @Override
                             public void create(BidCreation bidCreation) {
                             
              System.err.println("At the Daoimpl:::"+bidCreation.toString());   
              currentSession().save(bidCreation);
                                           
                             }
                             @Override
                             public List<Object[]> getLot(String basis) {
                                           // TODO Auto-generated method stub
                                           String querystr = "  Select Lot_Identification from jcicommercialsales_rsp where Basis='"+basis+"'; ";
                                           List<Object[]> rows = currentSession().createSQLQuery(querystr).list();
                                           return rows;
                             }
                             @Override
                             public List<Object[]> getList() {
                                           // TODO Auto-generated method stub
                                           String querystr ="SELECT \r\n"
                                                                        + "    a.bid_reference_no, \r\n"
                                                                        + "    a.bid_date, \r\n"
                                                                        + "    a.bid_closing_date,\r\n"
                                                                        + "    COALESCE(COUNT(b.Bid_Reference_No), 0) AS submission_count,\r\n"
                                                                        + "    a.basis\r\n"
                                                                        + "FROM \r\n"
                                                                        + "    jcibid_creation a\r\n"
                                                                        + "LEFT JOIN \r\n"
                                                                        + "    jcibid_submission1 b ON a.bid_reference_no = b.Bid_Reference_No\r\n"
                                                                        + "                          where a.bid_roll_out = 1\r\n"
                                                                        
                                                                        + "GROUP BY \r\n"
                                                                        + "    a.bid_reference_no, \r\n"
                                                                        + "    a.bid_date, \r\n"
                                                                        + "    a.bid_closing_date,\r\n"
                                                                        + "    a.basis;";
                                           List<Object[]> rows = currentSession().createSQLQuery(querystr).list();
                                           return rows;
                             }
                             @Override
                             public List<Object[]> getBidDetails(String decryptId) {
                                           // TODO Auto-generated method stub
                                           String querystr ="   Select * from jcibid_creation where bid_reference_no ='"+decryptId+"';";
                                           List<Object[]> rows = currentSession().createSQLQuery(querystr).list();
                                           return rows;
                             }
                             @Override
                             public void updatebid(Date d, Integer bid, String bidclosingdate, String bidref) {
                                           // TODO Auto-generated method stub
                                           String querystr = "Update jcibid_creation set bid_roll_out='"+bid+"' , bid_closing_date='"+bidclosingdate+"' , updation_date=GETDATE() where bid_reference_no='"+bidref+"'";
                                           int rows = currentSession().createSQLQuery(querystr).executeUpdate();

                                           
                             }
                             @Override
                             public List<Object[]> getNonActiveList() {
                                           String querystr ="   SELECT *\r\n"
                                                                        + "FROM jcibid_creation\r\n"
                                                                        + "WHERE bid_roll_out IN (0, 2);";
                                           List<Object[]> rows = currentSession().createSQLQuery(querystr).list();
                                           return rows;
                             }
                             @Override
                             public void deleteBid(String decryptId) {
                                           // TODO Auto-generated method stub
                                           String querystr ="   Delete from jcibid_creation where bid_reference_no='"+decryptId+"';";
                                           currentSession().createSQLQuery(querystr).executeUpdate();

                                           return;
                             }
                             @Override
                             public void updateFlag() {
                                           // TODO Auto-generated method stub
                                           String query="\r\n"
                                                                        + " UPDATE jcibid_creation\r\n"
                                                                        + "SET bid_roll_out = \r\n"
                                                                        + "    CASE\r\n"
                                                                        + "        WHEN GETDATE() >= CONVERT(datetime, bid_date, 105) AND GETDATE() <= CONVERT(datetime, bid_closing_date, 105) THEN 1\r\n"
                                                                        + "        WHEN GETDATE() > CONVERT(datetime, bid_closing_date, 105)THEN 0\r\n"
                                                                        + "        ELSE 2\r\n"
                                                                        + "    END;";
                                                                        
                                           currentSession().createSQLQuery(query).executeUpdate();
                                           return;
                                           
                             }
                             @Override
                             public void updateNonActiveBid(String basis, Integer pClaim, String bid_Reference, String formattedDate1,
                                     String formattedDate2, String securityDepositAmount, String daystoAccept, String daystodeposit,
                                     String delivery_Period) {

                                 String query = "UPDATE jcibid_creation " +
                                                "SET basis='" + basis + "', " +
                                                "    provision_claim='" + pClaim + "', " +
                                                "    bid_date='" + formattedDate1 + "', " +
                                                "    bid_closing_date='" + formattedDate2 + "', " +
                                                "    security_deposit_amount='" + securityDepositAmount + "', " +
                                                "    day_to_accept='" + daystoAccept + "', " +
                                                "    delivery_period='" + delivery_Period + "', " +
                                                "    updation_date=GETDATE() " +
                                                "WHERE bid_reference_no='" + bid_Reference + "';";

                                 currentSession().createSQLQuery(query).executeUpdate();
                                 
                                 // Remember to handle exceptions and close resources properly in a real application
                             }

              
                                           
                             }

                             


