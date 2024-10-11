package com.jci.dao.impl;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.jci.dao.MarketArrivalDao;
import com.jci.model.FarmerRegModel;
import com.jci.model.FarmerRegModelDTO;
import com.jci.model.FarmerRegistrationModel;
import com.jci.model.MarketArrivalModel;


@Transactional
@Repository
public class MarketArrivalDaoImpl implements MarketArrivalDao{

	@Autowired
	private HttpServletRequest request;
	
	@Autowired
	SessionFactory sessionFactory;
	protected Session currentSession(){
		return sessionFactory.getCurrentSession();
	}

	@Override
	public void create(MarketArrivalModel marketArrival) {
		currentSession().save(marketArrival);

	}

	@Override
	public void update(MarketArrivalModel marketArrival) {
		currentSession().update(marketArrival);

	}

	@Override
	public MarketArrivalModel edit(int id) {
		return find(id);
	}

	@Override
	public void delete(int id) {
		FarmerRegistrationModel farmerRegistrationModel = new FarmerRegistrationModel();
		String hql = "Delete from dbo.bna where id = '"+id+"' " ;
		this.sessionFactory.getCurrentSession().createSQLQuery(hql).executeUpdate();
	}

	@Override
	public MarketArrivalModel find(int id) {
		return (MarketArrivalModel) currentSession().get(MarketArrivalModel.class, id);
	}

	/*
	 * @Override public List<MarketArrivalModel> getAlldata(String dpc_code, String
	 * regionId, String zoneId) { List<MarketArrivalModel> ll = new ArrayList<>();
	 * HttpSession session1 = request.getSession(false); String querystr = "";
	 * String roletypes = (String) session1.getAttribute("roletype"); List<Object[]>
	 * rows = new ArrayList<>();
	 * 
	 * if(roletypes.equalsIgnoreCase("HO")) { querystr =
	 * "Select a.*, b.centername from jcimra a left Join jcipurchasecenter b on a.dpc_code = b.CENTER_CODE"
	 * ; } else if(roletypes.equalsIgnoreCase("ZO")) { querystr =
	 * "Select a.*, b.centername from jcimra a left Join jcipurchasecenter b on a.dpc_code = b.CENTER_CODE LEFT JOIN jcirodetails c ON b.rocode = c.rocode where c.zonecode='"
	 * +zoneId+"'"; } else if(roletypes.equalsIgnoreCase("RO")) { querystr =
	 * "Select a.*, b.centername from jcimra a left Join jcipurchasecenter b on a.dpc_code = b.CENTER_CODE where b.rocode='"
	 * +regionId+"'"; } else { querystr =
	 * "Select a.*, b.centername from jcimra a left Join jcipurchasecenter b on a.dpc_code = b.CENTER_CODE  where a.dpc_code = '"
	 * +dpc_code+"'"; } Session session = sessionFactory.getCurrentSession();
	 * Transaction tx = session.beginTransaction(); SQLQuery query =
	 * session.createSQLQuery(querystr); rows = query.list();
	 * System.out.println(rows); for(Object[] row: rows) { int id= (int) row[0];
	 * String datearrival= (String) row[2]; String jutevariety= (String) row[3];
	 * String cropyr= (String) row[4]; String arrivedqty= (String) row[5]; String
	 * min= (String) row[6]; String max= (String) row[7]; String ro= (String)row[8];
	 * String centername= (String) row[29]; String region_name =(String) row[30];
	 * BigDecimal grade1= (BigDecimal)row[12]; BigDecimal grade2=
	 * (BigDecimal)row[13]; BigDecimal grade3= (BigDecimal)row[14]; BigDecimal
	 * grade4= (BigDecimal)row[15]; BigDecimal grade5= (BigDecimal)row[16];
	 * BigDecimal grade6= (BigDecimal)row[17]; BigDecimal grade7=
	 * (BigDecimal)row[18]; BigDecimal grade8= (BigDecimal)row[19]; int grade_rate1=
	 * (int)row[20]; int grade_rate2= (int)row[21]; int grade_rate3= (int)row[22];
	 * int grade_rate4= (int)row[23]; int grade_rate5= (int)row[24]; int
	 * grade_rate6= (int)row[25]; int grade_rate7= (int)row[26]; int grade_rate8=
	 * (int)row[27]; String basis= (String)row[28]; MarketArrivalModel maketarrival
	 * = new MarketArrivalModel(); maketarrival.setMrarefid(id);
	 * maketarrival.setDatearrival(datearrival);
	 * maketarrival.setJutevariety(jutevariety); maketarrival.setCropyr(cropyr);
	 * maketarrival.setArrivedqty(arrivedqty); maketarrival.setMaxmois(max);
	 * maketarrival.setMixmois(min); maketarrival.setDpcnames(centername);
	 * maketarrival.setRegion_id(ro); maketarrival.setGrade1(grade1.doubleValue());
	 * maketarrival.setGrade2(grade2.doubleValue());
	 * maketarrival.setGrade3(grade3.doubleValue());
	 * maketarrival.setGrade4(grade4.doubleValue());
	 * maketarrival.setGrade5(grade5.doubleValue());
	 * maketarrival.setGrade6(grade6.doubleValue());
	 * maketarrival.setGrade7(grade7.doubleValue());
	 * maketarrival.setGrade8(grade8.doubleValue());
	 * maketarrival.setGrade_rate1(grade_rate1);
	 * maketarrival.setGrade_rate2(grade_rate2);
	 * maketarrival.setGrade_rate3(grade_rate3);
	 * maketarrival.setGrade_rate4(grade_rate4);
	 * maketarrival.setGrade_rate5(grade_rate5);
	 * maketarrival.setGrade_rate6(grade_rate6);
	 * maketarrival.setGrade_rate7(grade_rate7);
	 * maketarrival.setGrade_rate8(grade_rate8); maketarrival.setBasis(basis);
	 * maketarrival.setRegionName(region_name); ll.add(maketarrival); }
	 * System.out.println("=========== "+ll.toString()); return ll; }
	 */

	@Override
    public List<MarketArrivalModel> getAlldata(String dpc_code, String regionId, String zoneId) {
          List<MarketArrivalModel> ll = new ArrayList<MarketArrivalModel>();
    HttpSession session1 = request.getSession(false);
          String querystr = "";
          String roletypes = (String) session1.getAttribute("roletype");
          List<Object[]> rows = new ArrayList<>();
          if(roletypes.equalsIgnoreCase("HO"))
          {
querystr = "Select a.*, b.centername, c.roname from jcimra a left Join jcipurchasecenter b on a.dpc_code = b.CENTER_CODE join [XMWJCI].[dbo].[jcirodetails] c on b.rocode = c.rocode ";
          }
          else if(roletypes.equalsIgnoreCase("ZO"))
          {
                 querystr = "Select a.*, b.centername from jcimra a left Join jcipurchasecenter b on a.dpc_code = b.CENTER_CODE LEFT JOIN jcirodetails c ON b.rocode = c.rocode where c.zonecode='"+zoneId+"'";
          }            
          else if(roletypes.equalsIgnoreCase("RO"))
          {
                 querystr = "Select a.*, b.centername, c.roname from jcimra a left Join jcipurchasecenter b on a.dpc_code = b.CENTER_CODE join [XMWJCI].[dbo].[jcirodetails] c on b.rocode = c.rocode  where b.rocode='"+regionId+"'";
          }
          else 
          {
                 querystr = "Select a.*, b.centername, c.roname from jcimra a left Join jcipurchasecenter b on a.dpc_code = b.CENTER_CODE  join [XMWJCI].[dbo].[jcirodetails] c on b.rocode = c.rocode  where a.dpc_code = '"+dpc_code+"'";
          }
          Session session = sessionFactory.getCurrentSession();
          Transaction tx = session.beginTransaction();
          SQLQuery query = session.createSQLQuery(querystr);
          rows = query.list();
          //System.out.println(rows);
          for(Object[] row: rows) {
                 int id= (int) row[0];
                 String datearrival= (String) row[6];
                 String jutevariety= (String) row[24];
                 String cropyr= (String) row[5];
                 String arrivedqty= (String) row[1];
                 String min= (String) row[26];
                 String max= (String) row[25];
                 String ro= (String)row[28];
                 String centername= (String) row[29];
                 String region_name =(String) row[30];
                   Double grade1= (Double)row[8]; 
                   Double grade2= (Double)row[9]; 
                   Double grade3= (Double)row[10]; 
                   Double grade4= (Double)row[11]; 
                   Double grade5= (Double)row[12]; 
                   Double grade6= (Double)row[13]; 
                   Double grade7= (Double)row[14]; 
                   Double grade8= (Double)row[15];
                   int grade_rate1= (int)row[16];
                   int grade_rate2= (int)row[17];
                   int grade_rate3= (int)row[18];
                   int grade_rate4= (int)row[19];
                   int grade_rate5= (int)row[20];
                   int grade_rate6= (int)row[21];
                   int grade_rate7= (int)row[22];
                   int grade_rate8= (int)row[23];
                   String basis= (String)row[2];
                 MarketArrivalModel maketarrival = new MarketArrivalModel();
                 maketarrival.setMrarefid(id);
                 maketarrival.setDatearrival(datearrival);
                 maketarrival.setJutevariety(jutevariety);
                 maketarrival.setCropyr(cropyr);
                 maketarrival.setArrivedqty(arrivedqty);
                 maketarrival.setMaxmois(max);
                 maketarrival.setMixmois(min);
                 maketarrival.setDpcnames(centername);
                 maketarrival.setRegion_id(ro);
                 maketarrival.setGrade1(grade1.doubleValue());
                 maketarrival.setGrade2(grade2.doubleValue());
                 maketarrival.setGrade3(grade3.doubleValue());
                 maketarrival.setGrade4(grade4.doubleValue());
                 maketarrival.setGrade5(grade5.doubleValue());
                 maketarrival.setGrade6(grade6.doubleValue());
                 maketarrival.setGrade7(grade7.doubleValue());
                 maketarrival.setGrade8(grade8.doubleValue());
                 maketarrival.setGrade_rate1(grade_rate1);
                 maketarrival.setGrade_rate2(grade_rate2);
                 maketarrival.setGrade_rate3(grade_rate3);
                 maketarrival.setGrade_rate4(grade_rate4);
                 maketarrival.setGrade_rate5(grade_rate5);
                 maketarrival.setGrade_rate6(grade_rate6);
                 maketarrival.setGrade_rate7(grade_rate7);
                 maketarrival.setGrade_rate8(grade_rate8);
                 maketarrival.setBasis(basis);
                 maketarrival.setRegionName(region_name);
                 maketarrival.setCentername(centername);
                 ll.add(maketarrival);     
          }
    //     System.out.println("=========== "+ll.toString());
          return ll;
    }


	@Override
	public boolean submitform(MarketArrivalModel marketArrival) {
		this.sessionFactory.getCurrentSession().save(marketArrival);
		return false;
	}

	@Override
	public MarketArrivalModel getAlldetails(int id_) {
		   
        MarketArrivalModel maketarrival = new MarketArrivalModel();
        HttpSession session1 = request.getSession(false);
        String querystr = "";
        List<Object[]> rows = new ArrayList<>();       
        querystr = "Select a.*, b.centername, c.roname from jcimra a left Join jcipurchasecenter b on a.dpc_code = b.CENTER_CODE join [XMWJCI].[dbo].[jcirodetails] c on b.rocode = c.rocode  where a.mrarefid ="+id_;  
        Session session = sessionFactory.getCurrentSession();
        Transaction tx = session.beginTransaction();
        SQLQuery query = session.createSQLQuery(querystr);
        rows = query.list();
        //System.out.println(rows);
        for(Object[] row: rows) {
               int id= (int) row[0];
               String datearrival= (String) row[6];
               String jutevariety= (String) row[24];
               String cropyr= (String) row[5];
               String arrivedqty= (String) row[1];
               String min= (String) row[26];
               String max= (String) row[25];
               String ro= (String)row[28];
               String centername= (String) row[29];
               String region_name =(String) row[30];
                 Double grade1= (Double)row[8]; 
                 Double grade2= (Double)row[9]; 
                 Double grade3= (Double)row[10]; 
                 Double grade4= (Double)row[11]; 
                 Double grade5= (Double)row[12]; 
                 Double grade6= (Double)row[13]; 
                 Double grade7= (Double)row[14]; 
                 Double grade8= (Double)row[15];
                 int grade_rate1= (int)row[16];
                 int grade_rate2= (int)row[17];
                 int grade_rate3= (int)row[18];
                 int grade_rate4= (int)row[19];
                 int grade_rate5= (int)row[20];
                 int grade_rate6= (int)row[21];
                 int grade_rate7= (int)row[22];
                 int grade_rate8= (int)row[23];
                 String basis= (String)row[2];
            
               maketarrival.setMrarefid(id);
               maketarrival.setDatearrival(datearrival);
               maketarrival.setJutevariety(jutevariety);
               maketarrival.setCropyr(cropyr);
               maketarrival.setArrivedqty(arrivedqty);
               maketarrival.setMaxmois(max);
               maketarrival.setMixmois(min);
               maketarrival.setDpcnames(centername);
               maketarrival.setRegion_id(ro);
               maketarrival.setGrade1(grade1.doubleValue());
               maketarrival.setGrade2(grade2.doubleValue());
               maketarrival.setGrade3(grade3.doubleValue());
               maketarrival.setGrade4(grade4.doubleValue());
               maketarrival.setGrade5(grade5.doubleValue());
               maketarrival.setGrade6(grade6.doubleValue());
               maketarrival.setGrade7(grade7.doubleValue());
               maketarrival.setGrade8(grade8.doubleValue());
               maketarrival.setGrade_rate1(grade_rate1);
               maketarrival.setGrade_rate2(grade_rate2);
               maketarrival.setGrade_rate3(grade_rate3);
               maketarrival.setGrade_rate4(grade_rate4);
               maketarrival.setGrade_rate5(grade_rate5);
               maketarrival.setGrade_rate6(grade_rate6);
               maketarrival.setGrade_rate7(grade_rate7);
               maketarrival.setGrade_rate8(grade_rate8);
               maketarrival.setBasis(basis);
               maketarrival.setRegionName(region_name);
               maketarrival.setCentername(centername);
                    
        }
 
        return maketarrival;
        
	}

}
