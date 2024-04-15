package com.jci.dao.impl;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.jci.dao.DailyPurchaseConfDao;
import com.jci.model.DailyPurchaseConfModel;
import com.jci.model.JbaModel;
import com.jci.model.RawJuteProcurementAndPayment;

@Transactional
@Repository
public class DailyPurchaseConfDaoImpl implements DailyPurchaseConfDao{

	@Autowired
	private HttpServletRequest request;
	
	@Autowired
	SessionFactory sessionFactory;
	protected Session currentSession(){
		return sessionFactory.getCurrentSession();
	}

	@Override
	public void create(DailyPurchaseConfModel dailyPurchaseConfModel) {
		currentSession().saveOrUpdate(dailyPurchaseConfModel);
	}

	@Override
	public void update(DailyPurchaseConfModel dailyPurchaseConfModel) {
		currentSession().update(dailyPurchaseConfModel);

	}

	@Override
	public DailyPurchaseConfModel edit(int id) {
		return find(id);
	}

	
	@Override
	public void delete(int id) {
		String hql = "Delete from dbo.jcidpc where dpcid = '"+id+"' " ;
		this.sessionFactory.getCurrentSession().createSQLQuery(hql).executeUpdate();
	}

	@Override
	public DailyPurchaseConfModel find(int id) {
		return (DailyPurchaseConfModel) currentSession().get(DailyPurchaseConfModel.class, id);
	}

	@Override
	public List<DailyPurchaseConfModel> getAll(String dpcid, String regionId, String zoneId) {
		Criteria c = this.sessionFactory.getCurrentSession().createCriteria(DailyPurchaseConfModel.class);

		List<Integer> result = new ArrayList<>();
	HttpSession session1 = request.getSession(false);
		
		String querystr = "";
		String roletypes = (String) session1.getAttribute("roletype");

		if(roletypes.equalsIgnoreCase("HO")) {
			querystr = "select a.*, b.centername  from jcidpc a left Join jcipurchasecenter b on a.placeofpurchase = b.CENTER_CODE";
		}else if(roletypes.equalsIgnoreCase("ZO")){
			
			querystr=" select a.*, b.centername  from jcidpc a left Join jcipurchasecenter b on a.placeofpurchase = b.CENTER_CODE LEFT JOIN jcirodetails c ON b.rocode = c.rocode where c.zonecode='"+zoneId+"'";
				
		}
		else if(roletypes.equalsIgnoreCase("RO")){
			querystr="select a.*, b.centername  from jcidpc a left Join jcipurchasecenter b on a.placeofpurchase = b.CENTER_CODE where b.rocode='"+regionId+"'";
		}else {
			querystr="select a.*, b.centername  from jcidpc a left Join jcipurchasecenter b on a.placeofpurchase = b.CENTER_CODE where a.placeofpurchase='"+dpcid+"'";
		}
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		SQLQuery query = session.createSQLQuery(querystr);
		List<Object[]> rows = query.list();
		List<DailyPurchaseConfModel> ll= new ArrayList<>();
		for(Object[] row: rows) {
			
			int dpcids = (int)row[0];
			String datepurchase = (String)row[2];
			String basis = (String)row[3];
			String cropyr = (String)row[4];
			//String createddate = (String)row[5];
			int binno = (int)row[6];
			String jutevariety = (String)row[7];
			String gquantity = (String)row[8];
			String dquantity = (String)row[9];
			double netquantity = (((BigDecimal)row[10]).doubleValue());
			//int fibervalue = (int)row[11];
			String rateslipno = (String)row[15];
	
			DailyPurchaseConfModel  dailypur= new DailyPurchaseConfModel();
			dailypur.setDpcid(dpcids);
			dailypur.setDatepurchase(datepurchase);
			dailypur.setBasis(basis);
			dailypur.setCropyr(cropyr);
			dailypur.setBinno(binno);
			dailypur.setGquantity(gquantity);
			dailypur.setDquantity(dquantity);
			dailypur.setNetquantity(netquantity);
			//dailypur.setFibervalue(fibervalue);
			dailypur.setRateslipno(rateslipno);
			dailypur.setJutevariety(jutevariety);

			
			ll.add(dailypur);
		}
		
		return ll;
	}
		
		
		
		
	
	

	@Override
	public boolean submitform(DailyPurchaseConfModel dailyPurchaseConfModel) {
		this.sessionFactory.getCurrentSession().save(dailyPurchaseConfModel);
		return false;
	}
	@Override
	public String findGradePriceJuteVariety(String variety, int basis_no, String cropyr, String dpcid) {

		String querystr="";
		List<Object[]> result = new ArrayList<>();
		
		int count=0;
		double grade1= 0.0;
		double grade2= 0.0;
		double grade3= 0.0;
		double grade4= 0.0;
		double grade5= 0.0;
		double grade6= 0.0;
		double grade7= 0.0;
		double grade8= 0.0;
		if(basis_no==1) {
		 querystr =  "SELECT  grade1, grade2, grade3, grade4, grade5, grade6, grade7, grade8 FROM jcimspgradesprice where crop_yr='"+cropyr + "' and jute_variety like '"+ variety+"%'";
		}
		else if(basis_no==2) {
			 querystr = "SELECT  top 1 grade1, grade2, grade3, grade4, grade5, grade6, grade7, grade8 FROM jcijutepricesforcommercial where effectDate <= GETDATE() and crop_yr='"+cropyr + "' and jute_variety like '"+ variety+"%' and dpc like '%"+dpcid+"%'"+"order by effectDate desc ";
			}
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		SQLQuery query = session.createSQLQuery(querystr);
		 result=query.list();
		 for(Object[] o:result)
		 {
			 grade1= ((BigDecimal)o[0]).doubleValue();
			 grade2= ((BigDecimal)o[1]).doubleValue();
			 grade3= ((BigDecimal)o[2]).doubleValue();
			 grade4= ((BigDecimal)o[3]).doubleValue();
			 grade5= ((BigDecimal)o[4]).doubleValue();
			 grade6= ((BigDecimal)o[5]).doubleValue();
			 grade7= ((BigDecimal)o[6]).doubleValue();
			 grade8= ((BigDecimal)o[7]).doubleValue();
		
		 }
		
		return (grade1+","+grade2+","+grade3+","+grade4+","+grade5+","+grade6+","+grade7+","+grade8);
	}
	@Override
	public List<DailyPurchaseConfModel> dpc2() {
        List<DailyPurchaseConfModel> dpclist = new ArrayList<>();
        String querystr="";
        String querystr1="";
        String querystr2="";
        String querystr4="";
        int j;
        List<Object[]> result1 = new ArrayList<>();
        List<Object[]> result = new ArrayList<>();
        querystr2= "select ptsid from jciprocurement where flag_dpc2 = 0 group by ptsid,datepurchase,cropyr,jutevariety,placeofpurchase ";
        Session session2 = sessionFactory.getCurrentSession();
        Transaction tx2 = session2.beginTransaction();
        SQLQuery query2 = session2.createSQLQuery(querystr2);
        result1 = query2.list();
        String ptsid = result1.toString(); 
        ptsid = result1.toString() .replace("]", "");
        ptsid = ptsid.toString() .replace("[", "");
        //ptsid = "0000000";
        System.out.println("ptsid=="+ptsid);
        querystr1 = "SELECT DISTINCT \n" + 
                  "round(sum(j1.grade1*j1.netquantity)/sum(j1.netquantity),2) as gr1,\n" + 
                  "round(sum(j1.grade2*j1.netquantity)/sum(j1.netquantity),2) as gr2,\n" + 
                  "round(sum(j1.grade3*j1.netquantity)/sum(j1.netquantity),2) as gr3,\n" + 
                  "round(sum(j1.grade4*j1.netquantity)/sum(j1.netquantity),2) as gr4,\n" + 
                  "round(sum(j1.grade5*j1.netquantity)/sum(j1.netquantity),2) as gr5,\n" + 
                  "round(sum(j1.grade6*j1.netquantity)/sum(j1.netquantity),2) as gr6,\n" + 
                  "round(sum(j1.grade7*j1.netquantity)/sum(j1.netquantity),2) as gr7,\n" + 
                  "round(sum(j1.grade8*j1.netquantity)/sum(j1.netquantity),2) as gr8,\n" + 
                    "j1.datepurchase,\n" + 
                    "j1.cropyr,\n" + 
                    "j1.jutevariety,\n" + 
                    "\n" + 
                    "j1.placeofpurchase,\n" + 
                    "round(sum(j1.netquantity)/100,2) as net,\n" + 
                    "j1.basis,\n" + 
                    "round(sum(j1.amountpayable)*100/sum(j1.netquantity),2) as garsat,\n" + 
                    "j1.binno,\n" + 
                    "round(sum(j1.amountpayable),0) as amount,\n" + 
                    "round(sum(j1.grossquantity)/100,2) as gross,\n" + 
                    "round(sum(j1.deductionquantity)/100,2) as deduc\n" + 
                    "FROM\n" + 
                    "jciprocurement j1\n" + 
                    "WHERE\n" + 
                    "j1.flag_dpc2=0\n" + 
                    "\n" + 
                    "group by\n" + 
                    "j1.datepurchase,\n" + 
                    "j1.basis,\n" + 
                    "j1.placeofpurchase,\n" + 
                    "j1.cropyr,\n" + 
                    "j1.jutevariety,\n" + 
                    "j1.binno";
        
        Session session = sessionFactory.getCurrentSession();
        Transaction tx = session.beginTransaction();
        SQLQuery query = session.createSQLQuery(querystr1);
        result = query.list();
        //try {

              for(Object[] o: result) {
              double multi=0.0;
              double addition=0.0;
              DailyPurchaseConfModel dailyPurchaseConfModel= new DailyPurchaseConfModel();
              double grade[] = new double[8]; 
              String variety= (String)o[10];
              String cropyr=(String)o[9];
              String dpcid=(String)o[11];
              double netqty =((BigDecimal)o[12]).doubleValue();
              double garsat =((BigDecimal)o[14]).doubleValue();
              double grade0 =((BigDecimal)o[0]).doubleValue();
              double grade1 =((BigDecimal)o[1]).doubleValue();
              double grade2 =((BigDecimal)o[2]).doubleValue();
              double grade3 =((BigDecimal)o[3]).doubleValue();
              double grade4 =((BigDecimal)o[4]).doubleValue();
              double grade5 =((BigDecimal)o[5]).doubleValue();
              double grade6 =((BigDecimal)o[6]).doubleValue();
              double grade7 =((BigDecimal)o[7]).doubleValue();
              final SimpleDateFormat formatter1 = new SimpleDateFormat("dd-MM-yyyy");
              String datepurchase =(String)o[8];
              String basis= (String)o[13];
              dailyPurchaseConfModel.setGrade1(grade0);
              dailyPurchaseConfModel.setGrade2(grade1);
              dailyPurchaseConfModel.setGrade3(grade2);
              dailyPurchaseConfModel.setGrade4(grade3);
              dailyPurchaseConfModel.setGrade5(grade4);
              dailyPurchaseConfModel.setGrade6(grade5);
              dailyPurchaseConfModel.setGrade7(grade6);
              dailyPurchaseConfModel.setGrade8(grade7);
              dailyPurchaseConfModel.setDatepurchase(datepurchase);
              dailyPurchaseConfModel.setBinno((int)o[15]);
              dailyPurchaseConfModel.setGquantity(((BigDecimal)o[17]).toString());  //gross qty
              dailyPurchaseConfModel.setDquantity(((BigDecimal)o[18]).toString()); // deduction qty
              
              dailyPurchaseConfModel.setFibervalue(((BigDecimal)o[16]).doubleValue()); //amount payable
              
              if(basis.equalsIgnoreCase("commercial")) {
                   querystr = "SELECT top 1 grade1, grade2, grade3, grade4, grade5, grade6, grade7, grade8 FROM jcijutepricesforcommercial where CONVERT( date, effectDate ,105) <= GETDATE() and crop_yr='"+cropyr + "' and jute_variety like '"+ variety+"%' and dpc like '%"+dpcid+"%'"+"order by id desc ";
              }
              else if(basis.equalsIgnoreCase("msp")) {
                    querystr =  "SELECT  grade1, grade2, grade3, grade4, grade5, grade6, grade7, grade8 FROM jcimspgradesprice where crop_yr='"+cropyr + "' and jute_variety like '"+ variety+"%'";
                    
              }
              Session session1 = sessionFactory.getCurrentSession();
              Transaction tx1 = session1.beginTransaction();
              SQLQuery query1 = session1.createSQLQuery(querystr);
              List<Object[]> prices = new ArrayList<>();
              prices = query1.list();
              
              double gradeprice[] = new double[8];
              double difference[] = new double[8];
              
              for(Object[] p :prices) {
              double gradefive=((BigDecimal) p[4]).doubleValue();
              
              for (j = 0; j < 8; j++){
                    
                    
                                grade[j]= ((BigDecimal)o[j]).doubleValue();
                                            gradeprice[j]=((BigDecimal) p[j]).doubleValue();
                                                                    if(grade[j]!=0)
                                                                          {     
                                                                                      difference[j]= gradeprice[j]-gradefive ;
                                                                                
                                                                                      multi=(difference[j] *  (grade[j]/100)) ;
                                                                          
                                                                                      addition += multi;
                                                                    }  
                                                                    
              }
              dailyPurchaseConfModel.setGrade1xnetqty(grade0*gradeprice[0]);      
              dailyPurchaseConfModel.setGrade2xnetqty(grade1*gradeprice[1]);
              dailyPurchaseConfModel.setGrade3xnetqty(grade2*gradeprice[2]);
              dailyPurchaseConfModel.setGrade4xnetqty(grade3*gradeprice[3]);
              dailyPurchaseConfModel.setGrade5xnetqty(grade4*gradeprice[4]);
              dailyPurchaseConfModel.setGrade6xnetqty(grade5*gradeprice[5]);
              dailyPurchaseConfModel.setGrade7xnetqty(grade6*gradeprice[6]);
              dailyPurchaseConfModel.setGrade8xnetqty(grade7*gradeprice[7]);
              dailyPurchaseConfModel.setTdbase(garsat-addition);
                                      
              }
              querystr4= "UPDATE jciprocurement SET flag_dpc2 = 1 WHERE ptsid in ("+ptsid+");";
              Session session4 = sessionFactory.getCurrentSession();
              Transaction tx4 = session4.beginTransaction();
              SQLQuery query4 = session4.createSQLQuery(querystr4);
              int one = query4.executeUpdate();
              dailyPurchaseConfModel.setGarsat(garsat);
              dailyPurchaseConfModel.setBasis(basis);
              dailyPurchaseConfModel.setCropyr(cropyr);
              dailyPurchaseConfModel.setPlaceofpurchase(dpcid);
              dailyPurchaseConfModel.setNetquantity(netqty);
              dailyPurchaseConfModel.setJutevariety(variety);
              dpclist.add(dailyPurchaseConfModel);
  }
              /*}
   catch (Exception e) {
        System.out.println(e.getLocalizedMessage());
    }*/
        return dpclist; 
       }


	@Override
	public void firstLevel(String cropyr, String basis) {
		String querystr="";
		 querystr = "select sum(a.grade1 + a.grade2 + a.grade3 + a.grade4 + a.grade5 + a.grade6+a.grade7+a.grade8) - sum(b.bale_no) FROM [XMWJCI].[dbo].[jciprocurement] a join [XMWJCI].[dbo].[jcibalepreparation] b on a.basis = b.basis where a.basis = '"+basis+"' and a.cropyr ='"+cropyr+"'"; 	
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		SQLQuery query = session.createSQLQuery(querystr);
		BigDecimal result=(BigDecimal)query.uniqueResult();
		 System.out.println("loose jute        ==============        "+result);
		 
		 String querystr1="";
		 querystr1 = "select jutevariety, sum(grade1) as grade1, sum(grade2) as grade2, sum(grade3) as grade3, sum(grade4) as grade4, sum(grade5) as grade5, sum(grade6) as grade6, sum(grade7) as grade7, sum(grade8) as grade8 FROM [XMWJCI].[dbo].[jciprocurement] where basis = '"+basis+"' and cropyr ='"+cropyr+"' group by jutevariety ";
		Session session1 = sessionFactory.getCurrentSession();
		Transaction tx1 = session1.beginTransaction();
		SQLQuery query1 = session1.createSQLQuery(querystr1);
		List<Object[]> result1= query1.list();
		for(Object[] r : result1) {
		 System.out.println("grades procured        ==============        "+r[0] +" , "+r[1]+" , "+r[2]+" , "+r[3]+" , "+r[4]+" , "+r[5]+" , "+r[6]+" , "+r[7]+" , "+r[8] );
			}
		
	
	String querystr2="";
	 querystr2 = "select  jute_grade, sum(bale_no)   FROM jcibalepreparation where crop_year = '"+cropyr+"' and basis = '"+basis+"' group by jute_grade";
	Session session2 = sessionFactory.getCurrentSession();
	Transaction tx2 = session2.beginTransaction();
	Query query2 = session2.createQuery(querystr2);
	List<Object[]> result2 = query2.list();
	 System.out.println("baled        ==============        "+querystr2.getClass().getName().toString());
	
	 System.out.println("baled        ==============        "+result2.get(0)[0] +" , "+result2.get(0)[1] );
	 System.out.println("baled        ==============        "+result2.get(1)[0] +" , "+result2.get(1)[1] );
		
	}
}