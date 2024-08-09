package com.jci.dao.impl_phase2;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Date;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import org.hibernate.Session;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.servlet.http.HttpServletRequest;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.jci.dao_phase2.BidSubmissionDao;

@Repository
@Transactional
public class BidSubmissionDaoImpl implements BidSubmissionDao {
	
	 

	@Autowired
	private HttpServletRequest request;
	@Autowired
	SessionFactory sessionFactory;
	protected Session currentSession(){
		return sessionFactory.getCurrentSession();
	}
	


	@Override
	public List<Object[]> getbidref(){
		List<String> bidLot = new ArrayList<String>();
		
//		String querystr = "\r\n"
//				+ "    SELECT distinct a.Bid_Reference_No, a.Lot_Identification,a.bidclosingdate FROM jcibid_submission1 as a left join  jcibid_creation as b on b.bid_reference_no=a.Bid_Reference_No";
//		
//		
		
		String querystr = "\r\n"
				+ "    SELECT distinct a.Bid_Reference_No,a.bidclosingdate FROM jcibid_submission1 as a left join  jcibid_creation as b on b.bid_reference_no=a.Bid_Reference_No";
		 List<Object[]>millNamelist= (List<Object[]>)this.sessionFactory.getCurrentSession().createSQLQuery(querystr).list();
		    return millNamelist;
	}
	
	@Override
	public List<String> getbidHeader(String bidId){
		String querystr = "SELECT * from  dbo.jcibid_subission where BidRefNo = '"+bidId+"' order by QuotedBasePrice DESC";
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		SQLQuery query = session.createSQLQuery(querystr);
		List<String> rows = query.list();	
		return rows;
		}
	
	@Override
	public List<Object[]> getbidSubission(String bidId){
	
		String querystr = "          SELECT \r\n"
				+ "    Bid_Reference_No,\r\n"
				+ "    Mill_name,\r\n"
				+ "    Sell_value,Quantity,Quote,DeliveryType,frieghtvalue\r\n"
		
				
				+ "FROM \r\n"
				+ "    dbo.jcibid_submission1\r\n"
				+ "WHERE \r\n"
				+ "    Bid_Reference_No = '"+bidId+"'"
		        + "  and   submit_quote_status = '0'";
		 List<Object[]>millNamelist= (List<Object[]>)this.sessionFactory.getCurrentSession().createSQLQuery(querystr).list();
		    return millNamelist;
		    

	}

	
	@Override
	public String updateBidHeader(List<Object[]> entities) {
	    Session session = sessionFactory.getCurrentSession();
	    Transaction tx = session.beginTransaction();
	    @SuppressWarnings("unused")
		int count = 0;
	    String updateQuery = "update dbo.jcibid_subission SET Bid_rank = :Bid_rank  where BidRefNo = :bidId and MillCode = :millCode";
	    	
	    	for(Object[] obj: entities) {
	    	String bidId = (String)obj[1];
	    	String millCode = (String)obj[2];
	        SQLQuery query = session.createSQLQuery(updateQuery);// Create a new query object in each iteration
	        query.setParameter("Bid_rank", "H" + (count + 1)); 
	        query.setParameter("bidId", bidId); 
			query.setParameter("millCode", millCode);
	        int rowCount = query.executeUpdate();
	        System.out.println("Rows affected: " + rowCount);
	        count++;
            
	    //	tx.commit();
	    }
	    

	    return "Bid Result Updated successfully.";
	}

	
	@Override
	public String updateH1BidHeader(Object[] entities) {
	    Session session = sessionFactory.getCurrentSession();
	    Transaction tx = session.beginTransaction();

	    String updateQuery = "update dbo.jcibid_subission SET QuotedBasePrice = :QuotedBasePrice, Bid_rank = :Bid_rank  where BidRefNo = :bidId AND Bid_rank = 'H1'";
	    	
	        SQLQuery query = session.createSQLQuery(updateQuery);
	        query.setParameter("bidId", entities[1]);
	        query.setParameter("QuotedBasePrice", entities[5]);
	        query.setParameter("Bid_rank", "H1");
	        int rowCount = query.executeUpdate();
	        System.out.println("Updated rows: " + rowCount);
	    return "Bid Result Updated successfully.";
	}

	@Override
	public String updateH1BidHeaderNew(int bidId, int sidId) {
	    Session session = sessionFactory.getCurrentSession();
	    Transaction tx = session.beginTransaction();
	    String updateQuery = "update dbo.jcibid_subission SET  Bid_rank = :Bid_rank  where  MillCode = :bidId AND Sid = :sidId";
	        SQLQuery query = session.createSQLQuery(updateQuery);
	        query.setParameter("Bid_rank", "H1");
	        query.setParameter("bidId", bidId);
	        query.setParameter("sidId", sidId);
	        int rowCount = query.executeUpdate();
	        System.out.println("Updated rows: " + rowCount);
	    return "Bid H1 Result Updated successfully.";
	}
	
	

	
	@Override
	public String deleteH1Bidder(int id) {
		String hql = "Delete from dbo.jcibid_subission where Sid = '"+id+"' " ;
		this.sessionFactory.getCurrentSession().createSQLQuery(hql).executeUpdate();
		return "delte H1 Bidder";
	}


		
	    @Override 
	      public String findH1MillEmail(String millCode) {
          String querystr = "SELECT a.client_email FROM dbo.jcimilldetailmaster a JOIN dbo.jcimilldetailchild b ON a.client_code = b.client_code  WHERE b.client_unit_code = '840'";
		  Session session = sessionFactory.getCurrentSession(); 
		  Transaction tx = session.beginTransaction(); 
		  SQLQuery query = session.createSQLQuery(querystr); 
		  List<String> rows = query.list(); 	 
		  return rows.toString(); 
		  }
	   
	  
	
	   
	   @Override
	   public boolean getbidupdate(List<Object[]> bidData) {
	       // Flag to determine if any update was successful
	       boolean updateSuccessful = false;

	       try {
	    	   for (Object[] data : bidData) {
	                String millName = (String) data[1];
	                Integer rank = (Integer) data[3];
	                String bidref = (String) data[0];
	                String qtyAlloted =String.valueOf(data[5]);
	             
	               

	              
	                
	                String querystr = "UPDATE dbo.jcibid_submission1 " +
                            "SET Bid_rank = '"+rank+"', " +
                            "    Quote = '"+qtyAlloted+"' " +
                           
                            "WHERE Mill_name = '"+millName+"' " +
                            "AND Bid_Reference_No = '"+bidref+"'";

	                 int result = this.sessionFactory.getCurrentSession().createSQLQuery(querystr).executeUpdate();
	               
	               
	            }
	       } catch (Exception e) {
	           e.printStackTrace();
	           return false; // Return false if an exception occurs
	       }

	       return updateSuccessful;
	   }

	@Override
	public List<Object[]> bidresult(String bidId) {
		String querystr = "  select Bid_Reference_No,Mill_code,Mill_name,Quoted_Base_Price,Bid_rank  from jcibid_submission1 WHERE \r\n"
				+ "    Bid_Reference_No = '"+bidId+"' ORDER BY \r\n"
				+ "    Bid_rank ASC  ";
				
		 List<Object[]>millNamelist= (List<Object[]>)this.sessionFactory.getCurrentSession().createSQLQuery(querystr).list();
		    return millNamelist;
	}

	@Override
	public List<Object[]> contrcatswap(String bidId) {
		String querystr = "  select Bid_Reference_No,Mill_code,Mill_name,Quoted_Base_Price,Bid_rank  from jcibid_submission1 WHERE \r\n"
				+ "    Bid_Reference_No = '"+bidId+"' ORDER BY \r\n"
				+ "    Bid_rank ASC  ";
				
		 List<Object[]>millNamelist= (List<Object[]>)this.sessionFactory.getCurrentSession().createSQLQuery(querystr).list();
		    return millNamelist;
	}

	@Override
	public boolean bidDelete(String bidId,String mill,String price) {
		   String querystr = "update  jcibid_submission1 set submit_quote_status='2' where Bid_Reference_No='"+bidId+"' and Mill_name='"+mill+"' and Bid_rank=1";
		   String querystr1 = "update  jcibid_submission1 set  Sell_value='"+price+"' where Bid_Reference_No='"+bidId+"'  and Bid_rank=2";
	   		
	

 try {
     int result = this.sessionFactory.getCurrentSession().createSQLQuery(querystr).executeUpdate();
     int result1 = this.sessionFactory.getCurrentSession().createSQLQuery(querystr1).executeUpdate();
     return result > 0; // Return true if the update affected one or more rows
 } catch (Exception e) {
     e.printStackTrace();
     return false; // Return false if an exception occurs
 }
	}

	@Override
	public List<Object[]> creationlist(String lotid) {
		String querystr = " select a.Region,a.JuteVariety,a.Crop_year,a.Gr_1,a.Gr_2,a.Gr_3,a.Gr_4,a.Gr_5,a.Gr_6,a.Gr_7,a.Gr_8,a.NetQty,b.Delivery_Type,b.Reserved_Sale_Price from jcicommercialsales_grades as a left join jcicommercialsales_rsp as b\r\n"
				+ "   on b.Lot_Identification=a.LotIdentification where b.Lot_Identification='"+lotid+"'";
				
		 List<Object[]>millNamelist= (List<Object[]>)this.sessionFactory.getCurrentSession().createSQLQuery(querystr).list();
		    return millNamelist;
	}

	@Override
	public List<Object[]> bid_data_result(String bidId) {
		String querystr = "   select Lot_Identification,Mill_name,SecurityDepositammount,cropyear,jutevariety,Quantity,DeliveryType,"
				+ "Bid_rank,Quote from jcibid_submission1 WHERE Bid_Reference_No='"+bidId+"' and submit_quote_status=0";
				
		 List<Object[]>millNamelist= (List<Object[]>)this.sessionFactory.getCurrentSession().createSQLQuery(querystr).list();
		    return millNamelist;
	}

	@Override
	public String millcode(String bidId) {
		String querystr = "  Select Mill_code from jcibid_submission1 WHERE Bid_Reference_No='"+bidId+"' and Mill_name='"+bidId+'"';
				
	 String millNamelist= (String)this.sessionFactory.getCurrentSession().createSQLQuery(querystr).uniqueResult();
		    return millNamelist;
	}
    @Override
    public String getemailforMill(String mill) {
          String q = "select client_email from jcimilldetailmaster where client_name = '" + mill + "'";
          String MillEmail = (String) this.sessionFactory.getCurrentSession().createSQLQuery(q).uniqueResult();

          // TODO Auto-generated method stub
          return MillEmail;
    }

	@Override
	public List<Object[]> biddatareport(String bidId) {
		String querystr = " SELECT DISTINCT\r\n"
				+ "    a.LotIdentification,\r\n"
				+ "    d.roname,\r\n"
				+ "    a.JuteVariety,\r\n"
				+ "     b.Lot_Size,\r\n"
				+ "    b.Reserved_Sale_Price,\r\n"
				+ "    f.frieghtvalue+Reserved_Sale_Price as MillDelivery_Price,\r\n"
				+ "    f.Mill_name,\r\n"
				+ "    f.Sell_value\r\n"
				+ "FROM jcicommercialsales_grades AS a\r\n"
				+ "LEFT JOIN jcicommercialsales_rsp AS b\r\n"
				+ "    ON b.Lot_Identification = a.LotIdentification\r\n"
				+ "     LEFT join jcibid_submission1 as f on f.Lot_Identification= a.LotIdentification\r\n"
				+ "LEFT JOIN (\r\n"
				+ "    SELECT s.roname, s.rocode\r\n"
				+ "    FROM\r\n"
				+ "  jcirodetails AS s\r\n"
				+ "    LEFT JOIN jcicommercialsales_grades AS b\r\n"
				+ "   \r\n"
				+ "        ON b.Region = s.rocode\r\n"
				+ ") AS d\r\n"
				+ "    ON a.Region = d.rocode\r\n"
				+ "WHERE a.LotIdentification ='" + bidId + "'";
				
		 List<Object[]>millNamelist= (List<Object[]>)this.sessionFactory.getCurrentSession().createSQLQuery(querystr).list();
		    return millNamelist;
	}



	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}



}
