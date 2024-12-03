package com.jci.dao.impl;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
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
import com.jci.model.InventoryDTO;

import com.jci.model.RoDetailsModel;
import com.jci.model.ZoneModel;

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
                    "round(sum(j1.netquantity)/NULLIF(100,0),2) as net,\n" + 
                    "j1.basis,\n" + 
                    "round(sum(j1.amountpayable)*100/NULLIF(sum(j1.netquantity),0),2) as garsat,\n" + 
                    "j1.binno,\n" + 
                    "round(sum(j1.amountpayable),0) as amount,\n" + 
                    "round(sum(j1.grossquantity)/NULLIF(100,0),2) as gross,\n" + 
                    "round(sum(j1.deductionquantity)/NULLIF(100,0),2) as deduc\n" + 
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
        double garsat = 0.0;
        double grade0 = 0.0;
        double grade1 = 0.0;
        double grade2 = 0.0;
        double grade3 = 0.0;
        double grade4 = 0.0;
        double grade5 = 0.0;
        double grade6 = 0.0;
        double grade7 = 0.0;
              for(Object[] o: result) {
              double multi=0.0;
              double addition=0.0;
              DailyPurchaseConfModel dailyPurchaseConfModel= new DailyPurchaseConfModel();
              double grade[] = new double[8]; 
              String variety= (String)o[10];
              String cropyr=(String)o[9];
              String dpcid=(String)o[11];
              double netqty =((BigDecimal)o[12]).doubleValue();
              if(o[14] != null)
               garsat =((BigDecimal)o[14]).doubleValue();
              if(o[0] != null)
               grade0 =((BigDecimal)o[0]).doubleValue();
              if(o[1] != null)
               grade1 =((BigDecimal)o[1]).doubleValue();
              if(o[2] != null)
               grade2 =((BigDecimal)o[2]).doubleValue();
              if(o[3] != null)
               grade3 =((BigDecimal)o[3]).doubleValue();
              if(o[4] != null)
               grade4 =((BigDecimal)o[4]).doubleValue();
              if(o[5] != null)
               grade5 =((BigDecimal)o[5]).doubleValue();
              if(o[6] != null)
               grade6 =((BigDecimal)o[6]).doubleValue();
              if(o[7] != null)
               grade7 =((BigDecimal)o[7]).doubleValue();
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

    //first level Baled view 
	@Override
	public List<Double> firstLeveljute(String cropyr, String basis,String baled) {
		List<Double> result2 = new ArrayList<Double>();

		try {
		 String querystr1="";
		 if("Baled".equals(baled))  
		 {
		 querystr1 = "SELECT \r\n" + 
		 		"    SUM(GRADE1) AS Total_GRADE1,\r\n" + 
		 		"    SUM(GRADE2) AS Total_GRADE2,\r\n" + 
		 		"    SUM(GRADE3) AS Total_GRADE3,\r\n" + 
		 		"    SUM(GRADE4) AS Total_GRADE4,\r\n" + 
		 		"    SUM(GRADE5) AS Total_GRADE5,\r\n" + 
		 		"    SUM(GRADE6) AS Total_GRADE6,\r\n" + 
		 		"    SUM(TOTAL) AS Total_Bales,\r\n" + 
		 		"    SUM(LOOSE) AS Total_Loose\r\n" + 
		 		"FROM (\r\n" + 
		 		"SELECT DISTINCT\r\n" + 
		 		"(SELECT SUM(J.bale_no) FROM jcibalepreparation J WHERE J.place_of_packing=j1.place_of_packing AND J.basis=j1.basis AND J.jute_variety=j1.jute_variety AND J.crop_year=j1.CROP_YEAR AND J.jute_grade LIKE '%1%') AS GRADE1,\r\n" + 
		 		"(SELECT SUM(J.bale_no) FROM jcibalepreparation J WHERE J.place_of_packing=j1.place_of_packing AND J.basis=j1.basis AND J.jute_variety=j1.jute_variety AND J.crop_year=j1.CROP_YEAR AND J.jute_grade LIKE '%2%') AS GRADE2,\r\n" + 
		 		"(SELECT SUM(J.bale_no) FROM jcibalepreparation J WHERE J.place_of_packing=j1.place_of_packing AND J.basis=j1.basis AND J.jute_variety=j1.jute_variety AND J.crop_year=j1.CROP_YEAR AND J.jute_grade LIKE '%3%') AS GRADE3,\r\n" + 
		 		"(SELECT SUM(J.bale_no) FROM jcibalepreparation J WHERE J.place_of_packing=j1.place_of_packing AND J.basis=j1.basis AND J.jute_variety=j1.jute_variety AND J.crop_year=j1.CROP_YEAR AND J.jute_grade LIKE '%4%') AS GRADE4,\r\n" + 
		 		"(SELECT SUM(J.bale_no) FROM jcibalepreparation J WHERE J.place_of_packing=j1.place_of_packing AND J.basis=j1.basis AND J.jute_variety=j1.jute_variety AND J.crop_year=j1.CROP_YEAR AND J.jute_grade LIKE '%5%') AS GRADE5,\r\n" + 
		 		"(SELECT SUM(J.bale_no) FROM jcibalepreparation J WHERE J.place_of_packing=j1.place_of_packing AND J.basis=j1.basis AND J.jute_variety=j1.jute_variety AND J.crop_year=j1.CROP_YEAR AND J.jute_grade LIKE '%6%') AS GRADE6,\r\n" + 
		 		"(SELECT SUM(J.bale_no) FROM jcibalepreparation J WHERE J.place_of_packing=j1.place_of_packing AND J.basis=j1.basis AND J.jute_variety=j1.jute_variety AND J.crop_year=j1.CROP_YEAR) AS TOTAL,\r\n" + 
		 		"(SELECT SUM(J.netquantity) FROM jcidpc J WHERE J.placeofpurchase=J1.place_of_packing AND J.basis=j1.basis AND J.jutevariety=J1.jute_variety AND J.cropyr=j1.crop_year) AS LOOSE\r\n" + 
		 		"FROM jcibalepreparation j1\r\n" + 
		 		"WHERE\r\n" + 
		 		"j1.crop_year='"+cropyr+"' and j1.basis = '"+basis+"'\r\n" + 
		 		")as results;";
		 }
		 else {
			 querystr1 ="SELECT \n"
			 		+ "    SUM(GRADE1) AS Total_GRADE1,\n"
			 		+ "    SUM(GRADE2) AS Total_GRADE2,\n"
			 		+ "    SUM(GRADE3) AS Total_GRADE3,\n"
			 		+ "    SUM(GRADE4) AS Total_GRADE4,\n"
			 		+ "    SUM(GRADE5) AS Total_GRADE5,\n"
			 		+ "    SUM(GRADE6) AS Total_GRADE6,\n"
			 		+ "    SUM(TOTAL) AS Total_Bales,\n"
			 		+ "    SUM(LOOSE) AS Total_Loose\n"
			 		+ "FROM (\n"
			 		+ "SELECT DISTINCT\n"
			 		+ "(SELECT SUM(J.bale_no * pur.nominal_wt) FROM jcibalepreparation J left join jcipurchasecenter pur on j.place_of_packing = pur.CENTER_CODE WHERE J.place_of_packing=j1.place_of_packing AND J.basis=j1.basis AND J.jute_variety=j1.jute_variety AND J.crop_year=j1.CROP_YEAR AND J.jute_grade LIKE '%1%') AS GRADE1,\n"
			 		+ "(SELECT SUM(J.bale_no * pur.nominal_wt) FROM jcibalepreparation J left join jcipurchasecenter pur on j.place_of_packing = pur.CENTER_CODE WHERE J.place_of_packing=j1.place_of_packing AND J.basis=j1.basis AND J.jute_variety=j1.jute_variety AND J.crop_year=j1.CROP_YEAR AND J.jute_grade LIKE '%2%') AS GRADE2,\n"
			 		+ "(SELECT SUM(J.bale_no * pur.nominal_wt) FROM jcibalepreparation J left join jcipurchasecenter pur on j.place_of_packing = pur.CENTER_CODE WHERE J.place_of_packing=j1.place_of_packing AND J.basis=j1.basis AND J.jute_variety=j1.jute_variety AND J.crop_year=j1.CROP_YEAR AND J.jute_grade LIKE '%3%') AS GRADE3,\n"
			 		+ "(SELECT SUM(J.bale_no * pur.nominal_wt) FROM jcibalepreparation J left join jcipurchasecenter pur on j.place_of_packing = pur.CENTER_CODE WHERE J.place_of_packing=j1.place_of_packing AND J.basis=j1.basis AND J.jute_variety=j1.jute_variety AND J.crop_year=j1.CROP_YEAR AND J.jute_grade LIKE '%4%') AS GRADE4,\n"
			 		+ "(SELECT SUM(J.bale_no * pur.nominal_wt) FROM jcibalepreparation J left join jcipurchasecenter pur on j.place_of_packing = pur.CENTER_CODE WHERE J.place_of_packing=j1.place_of_packing AND J.basis=j1.basis AND J.jute_variety=j1.jute_variety AND J.crop_year=j1.CROP_YEAR AND J.jute_grade LIKE '%5%') AS GRADE5,\n"
			 		+ "(SELECT SUM(J.bale_no * pur.nominal_wt) FROM jcibalepreparation J left join jcipurchasecenter pur on j.place_of_packing = pur.CENTER_CODE WHERE J.place_of_packing=j1.place_of_packing AND J.basis=j1.basis AND J.jute_variety=j1.jute_variety AND J.crop_year=j1.CROP_YEAR AND J.jute_grade LIKE '%6%') AS GRADE6,\n"
			 		+ "(SELECT SUM(J.bale_no * pur.nominal_wt) FROM jcibalepreparation J left join jcipurchasecenter pur on j.place_of_packing = pur.CENTER_CODE  WHERE J.place_of_packing=j1.place_of_packing AND J.basis=j1.basis AND J.jute_variety=j1.jute_variety AND J.crop_year=j1.CROP_YEAR) AS TOTAL,\n"
			 		+ "(SELECT SUM(J.netquantity) FROM jcidpc J WHERE J.placeofpurchase=J1.place_of_packing AND J.basis=j1.basis AND J.jutevariety=J1.jute_variety AND J.cropyr=j1.crop_year) AS LOOSE\n"
			 		+ "FROM jcibalepreparation j1\n"
			 		+ "WHERE\n"
			 		+ "j1.crop_year='"+cropyr+"' and j1.basis = '"+basis+"'\n"
			 		+ ")as results;";
		 }
		Session session1 = sessionFactory.getCurrentSession();
		Transaction tx1 = session1.beginTransaction();
		SQLQuery query1 = session1.createSQLQuery(querystr1);
		 
		List<Object[]> result1 = query1.list();
		if(result1 != null) {
		 for(Object[] p :result1) {
			 System.err.println("jute baled"+p.toString());
			 if(p[0] != null) {
				 if (p[0] instanceof Integer)
				 {
					 result2.add(((Integer) p[0]).doubleValue());
				 } 
				 else if (p[0] instanceof Double)
				 {
					result2.add(((Double) p[0]).doubleValue());
				 }
			 }else {
				 result2.add(0.0); 
			 }
			 
			 if(p[1] != null) {
				 if (p[1] instanceof Integer)
				 {
					 result2.add(((Integer) p[1]).doubleValue());
				 } 
				 else if (p[1] instanceof Double)
				 {
					result2.add(((Double) p[1]).doubleValue());
				 }
			 }else {
				 result2.add(0.0); 
			 }
			 if(p[2] != null) {
				 if (p[2] instanceof Integer)
				 {
					 result2.add(((Integer) p[2]).doubleValue());
				 } 
				 else if (p[2] instanceof Double)
				 {
					result2.add(((Double) p[2]).doubleValue());
				 }
			 }else {
				 result2.add(0.0); 
			 }
			 
			 if(p[3] != null) {
				 if (p[3] instanceof Integer)
				 {
					 result2.add(((Integer) p[3]).doubleValue());
				 } 
				 else if (p[3] instanceof Double)
				 {
					result2.add(((Double) p[3]).doubleValue());
				 }
			 }else {
				 result2.add(0.0); 
			 }
			 if(p[4] != null) {
				 if (p[4] instanceof Integer)
				 {
					 result2.add(((Integer) p[4]).doubleValue());
				 } 
				 else if (p[4] instanceof Double)
				 {
					result2.add(((Double) p[4]).doubleValue());
				 }
			 }else {
				 result2.add(0.0); 
			 }
			 if(p[5] != null) {
				 if (p[5] instanceof Integer)
				 {
					 result2.add(((Integer) p[5]).doubleValue());
				 } 
				 else if (p[5] instanceof Double)
				 {
					result2.add(((Double) p[5]).doubleValue());
				 }
			 }else {
				 result2.add(0.0); 
			 }
			 if(p[6] != null) {
				 if (p[6] instanceof Integer)
				 {
					 result2.add(((Integer) p[6]).doubleValue());
				 } 
				 else if (p[6] instanceof Double)
				 {
					result2.add(((Double) p[6]).doubleValue());
				 }
			 }else {
				 result2.add(0.0); 
			 }
             if(p[7] != null) 
            	 result2.add(((BigDecimal) p[7]).doubleValue());
             else
    			 result2.add(0.0); 
              
             
		 }
		}
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		System.err.println("result2PPPPPPPPPPPP"+result2);
		return result2;
	}

		@Override
		public List<Double> firstLevelbale(String cropyr, String basis,String baled) {
			String querystr1="";
			if("msp".equals(basis))
			{
				if("Baled".equals(baled))
				{
			querystr1 = "SELECT \n"
					+ "    SUM(GRADE1) AS Total_GRADE1,\n"
					+ "    SUM(GRADE2) AS Total_GRADE2,\n"
					+ "    SUM(GRADE3) AS Total_GRADE3,\n"
					+ "    SUM(GRADE4) AS Total_GRADE4,\n"
					+ "    SUM(GRADE5) AS Total_GRADE5,\n"
					+ "    SUM(GRADE6) AS Total_GRADE6,\n"
					+ "    SUM(TOTAL) AS Total_Bales,\n"
					+ "    SUM(LOOSE) AS Total_Loose\n"
					+ "FROM (\n"
					+ "SELECT DISTINCT\n"
					+ "(SELECT SUM(J.No_of_bales) FROM jcidispatch_details_child J WHERE J.jute_variety=j1.jute_variety AND J.crop_year=j1.CROP_YEAR AND J.jute_grade LIKE '%1%') AS GRADE1,\n"
					+ "(SELECT SUM(J.No_of_bales) FROM jcidispatch_details_child J  WHERE J.jute_variety=j1.jute_variety AND J.crop_year=j1.CROP_YEAR AND J.jute_grade LIKE '%2%') AS GRADE2,\n"
					+ "(SELECT SUM(J.No_of_bales) FROM jcidispatch_details_child J WHERE  J.jute_variety=j1.jute_variety AND J.crop_year=j1.CROP_YEAR AND J.jute_grade LIKE '%3%') AS GRADE3,\n"
					+ "(SELECT SUM(J.No_of_bales) FROM jcidispatch_details_child J  WHERE  J.jute_variety=j1.jute_variety AND J.crop_year=j1.CROP_YEAR AND J.jute_grade LIKE '%4%') AS GRADE4,\n"
					+ "(SELECT SUM(J.No_of_bales) FROM jcidispatch_details_child J  WHERE  J.jute_variety=j1.jute_variety AND J.crop_year=j1.CROP_YEAR AND J.jute_grade LIKE '%5%') AS GRADE5,\n"
					+ "(SELECT SUM(J.No_of_bales) FROM jcidispatch_details_child J WHERE  J.jute_variety=j1.jute_variety AND J.crop_year=j1.CROP_YEAR AND J.jute_grade LIKE '%6%') AS GRADE6,\n"
					+ "(SELECT SUM(J.No_of_bales) FROM jcidispatch_details_child J WHERE  J.jute_variety=j1.jute_variety AND J.crop_year=j1.CROP_YEAR) AS TOTAL,\n"
					+ "(SELECT SUM(J.netquantity) FROM jcidpc J WHERE J.jutevariety=J1.jute_variety AND J.cropyr=j1.crop_year) AS LOOSE\n"
					+ "FROM jcidispatch_details_child j1\n"
					+ "WHERE\n"
					+ "j1.crop_year='"+cropyr+"' \n"
					+ ")as results;";
				}
				else {
					querystr1 ="SELECT \n"
							+ "    SUM(GRADE1) AS Total_GRADE1,\n"
							+ "    SUM(GRADE2) AS Total_GRADE2,\n"
							+ "    SUM(GRADE3) AS Total_GRADE3,\n"
							+ "    SUM(GRADE4) AS Total_GRADE4,\n"
							+ "    SUM(GRADE5) AS Total_GRADE5,\n"
							+ "    SUM(GRADE6) AS Total_GRADE6,\n"
							+ "    SUM(TOTAL) AS Total_Bales,\n"
							+ "    SUM(LOOSE) AS Total_Loose\n"
							+ "FROM (\n"
							+ "SELECT DISTINCT\n"
							+ "(SELECT SUM(J.No_of_bales * j.nominal_wt) FROM jcidispatch_details_child J WHERE J.jute_variety=j1.jute_variety AND J.crop_year=j1.CROP_YEAR AND J.jute_grade LIKE '%1%') AS GRADE1,\n"
							+ "(SELECT SUM(J.No_of_bales * j.nominal_wt) FROM jcidispatch_details_child J  WHERE J.jute_variety=j1.jute_variety AND J.crop_year=j1.CROP_YEAR AND J.jute_grade LIKE '%2%') AS GRADE2,\n"
							+ "(SELECT SUM(J.No_of_bales * j.nominal_wt) FROM jcidispatch_details_child J WHERE  J.jute_variety=j1.jute_variety AND J.crop_year=j1.CROP_YEAR AND J.jute_grade LIKE '%3%') AS GRADE3,\n"
							+ "(SELECT SUM(J.No_of_bales * j.nominal_wt) FROM jcidispatch_details_child J  WHERE  J.jute_variety=j1.jute_variety AND J.crop_year=j1.CROP_YEAR AND J.jute_grade LIKE '%4%') AS GRADE4,\n"
							+ "(SELECT SUM(J.No_of_bales * j.nominal_wt) FROM jcidispatch_details_child J  WHERE  J.jute_variety=j1.jute_variety AND J.crop_year=j1.CROP_YEAR AND J.jute_grade LIKE '%5%') AS GRADE5,\n"
							+ "(SELECT SUM(J.No_of_bales * j.nominal_wt) FROM jcidispatch_details_child J WHERE  J.jute_variety=j1.jute_variety AND J.crop_year=j1.CROP_YEAR AND J.jute_grade LIKE '%6%') AS GRADE6,\n"
							+ "(SELECT SUM(J.No_of_bales * j.nominal_wt) FROM jcidispatch_details_child J WHERE  J.jute_variety=j1.jute_variety AND J.crop_year=j1.CROP_YEAR) AS TOTAL,\n"
							+ "(SELECT SUM(J.netquantity) FROM jcidpc J WHERE J.jutevariety=J1.jute_variety AND J.cropyr=j1.crop_year) AS LOOSE\n"
							+ "FROM jcidispatch_details_child j1\n"
							+ "WHERE\n"
							+ "j1.crop_year='"+cropyr+"' \n"
							+ ")as results;";
				}
			}else
			{
				return null;
				//for commercial write query here
			}
			Session session1 = sessionFactory.getCurrentSession();
			Transaction tx1 = session1.beginTransaction();
			SQLQuery query1 = session1.createSQLQuery(querystr1);
			List<Object[]> list = new ArrayList<Object[]>();
			List<Double> result2 = new ArrayList<Double>();
			List<Object[]> result1 = query1.list();
			
			if(result1 != null) {
			 for(Object[] p :result1) {
				 System.err.println("jute baled"+p.toString());
				 if(p[0] != null) {
					 if (p[0] instanceof Integer)
					 {
						 result2.add(((Integer) p[0]).doubleValue());
					 } 
					 else if (p[0] instanceof Double)
					 {
						result2.add(((Double) p[0]).doubleValue());
					 }
				 }else {
					 result2.add(0.0); 
				 }
				 
				 if(p[1] != null) {
					 if (p[1] instanceof Integer)
					 {
						 result2.add(((Integer) p[1]).doubleValue());
					 } 
					 else if (p[1] instanceof Double)
					 {
						result2.add(((Double) p[1]).doubleValue());
					 }
				 }else {
					 result2.add(0.0); 
				 }
				 if(p[2] != null) {
					 if (p[2] instanceof Integer)
					 {
						 result2.add(((Integer) p[2]).doubleValue());
					 } 
					 else if (p[2] instanceof Double)
					 {
						result2.add(((Double) p[2]).doubleValue());
					 }
				 }else {
					 result2.add(0.0); 
				 }
				 
				 if(p[3] != null) {
					 if (p[3] instanceof Integer)
					 {
						 result2.add(((Integer) p[3]).doubleValue());
					 } 
					 else if (p[3] instanceof Double)
					 {
						result2.add(((Double) p[3]).doubleValue());
					 }
				 }else {
					 result2.add(0.0); 
				 }
				 if(p[4] != null) {
					 if (p[4] instanceof Integer)
					 {
						 result2.add(((Integer) p[4]).doubleValue());
					 } 
					 else if (p[4] instanceof Double)
					 {
						result2.add(((Double) p[4]).doubleValue());
					 }
				 }else {
					 result2.add(0.0); 
				 }
				 if(p[5] != null) {
					 if (p[5] instanceof Integer)
					 {
						 result2.add(((Integer) p[5]).doubleValue());
					 } 
					 else if (p[5] instanceof Double)
					 {
						result2.add(((Double) p[5]).doubleValue());
					 }
				 }else {
					 result2.add(0.0); 
				 }
				 if(p[6] != null) {
					 if (p[6] instanceof Integer)
					 {
						 result2.add(((Integer) p[6]).doubleValue());
					 } 
					 else if (p[6] instanceof Double)
					 {
						result2.add(((Double) p[6]).doubleValue());
					 }
				 }else {
					 result2.add(0.0); 
				 }
	             if(p[7] != null) 
	            	 result2.add(((BigDecimal) p[7]).doubleValue());
	             else
	    			 result2.add(0.0); 
	              
	             
			 }
			}
			System.err.println("gggggggresult2"+result2.toString());
			return result2;
		}


		@Override
		public List<Object[]> firstLeveljuteRegionwise(String cropyr, String basis) {

			String querystr1="";
			querystr1 = "select cast(sum((a.grade1 * a.netquantity)/100 + (a.grade2 * a.netquantity)/100 + (a.grade3 * a.netquantity)/100 + (a.grade4 * a.netquantity)/100 + (a.grade5 * a.netquantity)/100 + (a.grade6 * a.netquantity)/100 + (a.grade7 * a.netquantity)/100 + (a.grade8 * a.netquantity)/100)as numeric(36,2)) sum, b.roname, b.rocode from [XMWJCI].[dbo].[jciprocurement] a left join [XMWJCI].[dbo].[jcirodetails] b on a.regionId = b.rocode group by b.roname , b.rocode;";
			Session session1 = sessionFactory.getCurrentSession();
			Transaction tx1 = session1.beginTransaction();
			SQLQuery query1 = session1.createSQLQuery(querystr1);
			List<Object[]> list = new ArrayList<Object[]>();
			List<Object[]> result1 = query1.list();
			
			if(result1 != null) {
			 for(Object[] p :result1) {
				 
			   String qry = "select NULLIF(sum(a.bale_no), 0 ) grade_sum, grade =1   FROM [XMWJCI].[dbo].[jcibalepreparation] a join  [XMWJCI].[dbo].[jcirodetails] b on a.region = b.rocode where jute_grade like '%1' and crop_year = '"+cropyr+"' and a.basis = '"+basis+"' and region = '"+p[2]+"' group by  b.roname\n" + 
							"union all \n" + 
							"select NULLIF(sum(a.bale_no), 0 ) grade_sum, grade =2   FROM [XMWJCI].[dbo].[jcibalepreparation] a join  [XMWJCI].[dbo].[jcirodetails] b on a.region = b.rocode where jute_grade like '%2' and a.crop_year = '"+cropyr+"' and a.basis = '"+basis+"' and region = '"+p[2]+"' group by  b.roname\n" + 
							"union all\n" + 
							"select NULLIF(sum(a.bale_no), 0 ) grade_sum, grade =3   FROM [XMWJCI].[dbo].[jcibalepreparation] a join  [XMWJCI].[dbo].[jcirodetails] b on a.region = b.rocode where jute_grade like '%3' and a.crop_year = '"+cropyr+"' and a.basis = '"+basis+"' and region = '"+p[2]+"' group by  b.roname\n" + 
							"union all\n" + 
							"select NULLIF(sum(a.bale_no), 0 ) grade_sum, grade =4   FROM [XMWJCI].[dbo].[jcibalepreparation] a join  [XMWJCI].[dbo].[jcirodetails] b on a.region = b.rocode where jute_grade like '%4' and a.crop_year = '"+cropyr+"' and a.basis = '"+basis+"' and region = '"+p[2]+"' group by  b.roname\n" + 
							"union all\n" + 
							"select NULLIF(sum(a.bale_no), 0 ) grade_sum , grade =5 FROM [XMWJCI].[dbo].[jcibalepreparation] a join  [XMWJCI].[dbo].[jcirodetails] b on a.region = b.rocode where jute_grade like '%5' and a.crop_year = '"+cropyr+"' and a.basis = '"+basis+"' and region = '"+p[2]+"' group by  b.roname\n" + 
							"union all \n" + 
							"select NULLIF(sum(a.bale_no), 0 ) grade_sum , grade =6  FROM [XMWJCI].[dbo].[jcibalepreparation] a join  [XMWJCI].[dbo].[jcirodetails] b on a.region = b.rocode where jute_grade like '%6' and a.crop_year = '"+cropyr+"' and a.basis = '"+basis+"' and region = '"+p[2]+"' group by  b.roname\n" + 
							"union all \n" + 
							"select NULLIF(sum(a.bale_no), 0 ) grade_sum , grade =7  FROM [XMWJCI].[dbo].[jcibalepreparation] a join  [XMWJCI].[dbo].[jcirodetails] b on a.region = b.rocode where jute_grade like '%7' and a.crop_year = '"+cropyr+"' and a.basis = '"+basis+"' and region = '"+p[2]+"' group by  b.roname\n" + 
							"union all \n" + 
							"select NULLIF(sum(a.bale_no), 0 ) grade_sum, grade =8  FROM [XMWJCI].[dbo].[jcibalepreparation] a join  [XMWJCI].[dbo].[jcirodetails] b on a.region = b.rocode where jute_grade like '%8' and a.crop_year = '"+cropyr+"' and a.basis = '"+basis+"'	and region = '"+p[2]+"' group by  b.roname";
					Session session2 = sessionFactory.getCurrentSession();
					Transaction tx2 = session2.beginTransaction();
					Query query2 = session2.createSQLQuery(qry);
					List<Object[]> result2 = query2.list();
					if(result2 != null) {
					
						Object[] b = new Object[12];
						b[0] = 0;
						b[1] = 0;
						b[2] = 0;
						b[3] = 0;
						b[4] = 0;
						b[5] = 0;
						b[6] = 0;
						b[7] = 0;
						for(Object[] r : result2) {
							
							switch((int)r[1]) {
							case 1:
							{
								b[0] = r[0];
								break;
								}
							case 2:
							{
								b[1] = r[0];
								break;
								}
							case 3:
							{
								b[2] = r[0];
								break;
								}
							case 4:
							{
								b[3] = r[0];
								break;
								}
							case 5:
							{
								b[4] = r[0];
								break;
								}
							case 6:
							{
								b[5] = r[0];
								break;
								}
							case 7:
							{
								b[6] = r[0];
								break;
								}
							case 8:
							{
								b[7] = r[0];
								break;
								}
							
							}
							b[8] = p[0];
							b[9] = p[1];
							b[10] = p[2];
						
							list.add(b);
							
						}
			      }
			 }
			 
		}
			
			for(Object[] z :list) {
				
			 System.out.println("sum  "+z[8]);
			 System.out.println("region name  "+z[9]);
			 System.out.println("region code  "+z[10]);
			 System.out.println("g1 "+z[0]);
			 System.out.println("g2 "+z[1]);
			 System.out.println("g3 "+z[2]);
			 System.out.println("g4 "+z[3]);
			 System.out.println("g5 "+z[4]);
			 System.out.println("g6 "+z[5]);
			 System.out.println("g7 "+z[6]);
			 System.out.println("g8 "+z[7]);
		
		
			 }
			return list;
		}
	public List<Object[]> firstLeveljutedpcwise(String cropyr, String basis, String region){
			
	String qry = "select NULLIF(sum(a.bale_no), 0 ) grade_sum , grade =1,  b.centername FROM [XMWJCI].[dbo].[jcibalepreparation] a left join  [XMWJCI].[dbo].[jcipurchasecenter] b on a.place_of_packing = b.CENTER_CODE where jute_grade like '%1' and crop_year = '2022-2023' and a.basis = 'commercial' and region = '07' group by  b.centername \r\n" + 
			"union all \r\n" + 
			"select NULLIF(sum(a.bale_no), 0 ) grade_sum , grade =2,  b.centername FROM [XMWJCI].[dbo].[jcibalepreparation] a left join  [XMWJCI].[dbo].[jcipurchasecenter] b on a.place_of_packing = b.CENTER_CODE where jute_grade like '%2' and a.crop_year = '2022-2023' and a.basis = 'commercial' and region = '07' group by  b.centername \r\n" + 
			"union all\r\n" + 
			"select NULLIF(sum(a.bale_no), 0 ) grade_sum , grade =3,  b.centername FROM [XMWJCI].[dbo].[jcibalepreparation] a left join  [XMWJCI].[dbo].[jcipurchasecenter] b on a.place_of_packing = b.CENTER_CODE where jute_grade like '%3' and a.crop_year = '2022-2023' and a.basis = 'commercial' and region = '07' group by  b.centername \r\n" + 
			"union all\r\n" + 
			"select NULLIF(sum(a.bale_no), 0 ) grade_sum , grade =4,  b.centername FROM [XMWJCI].[dbo].[jcibalepreparation] a left join  [XMWJCI].[dbo].[jcipurchasecenter] b on a.place_of_packing = b.CENTER_CODE where jute_grade like '%4' and a.crop_year = '2022-2023' and a.basis = 'commercial' and region = '07' group by  b.centername \r\n" + 
			"union all\r\n" + 
			"select NULLIF(sum(a.bale_no), 0 ) grade_sum , grade =5,  b.centername FROM [XMWJCI].[dbo].[jcibalepreparation] a left join  [XMWJCI].[dbo].[jcipurchasecenter] b on a.place_of_packing = b.CENTER_CODE where jute_grade like '%5' and a.crop_year = '2022-2023' and a.basis = 'commercial' and region = '07' group by  b.centername \r\n" + 
			"union all \r\n" + 
			"select NULLIF(sum(a.bale_no), 0 ) grade_sum , grade =6,  b.centername FROM [XMWJCI].[dbo].[jcibalepreparation] a left join  [XMWJCI].[dbo].[jcipurchasecenter] b on a.place_of_packing = b.CENTER_CODE where jute_grade like '%6' and a.crop_year = '2022-2023' and a.basis = 'commercial' and region = '07' group by  b.centername \r\n" + 
			"union all \r\n" + 
			"select NULLIF(sum(a.bale_no), 0 ) grade_sum , grade =7,  b.centername FROM [XMWJCI].[dbo].[jcibalepreparation] a left join  [XMWJCI].[dbo].[jcipurchasecenter] b on a.place_of_packing = b.CENTER_CODE where jute_grade like '%7' and a.crop_year = '2022-2023' and a.basis = 'commercial' and region = '07' group by  b.centername \r\n" + 
			"union all \r\n" + 
			"select NULLIF(sum(a.bale_no), 0 ) grade_sum , grade =8,  b.centername FROM [XMWJCI].[dbo].[jcibalepreparation] a left join  [XMWJCI].[dbo].[jcipurchasecenter] b on a.place_of_packing = b.CENTER_CODE where jute_grade like '%8' and a.crop_year = '2022-2023' and a.basis = 'commercial' and region = '07' group by  b.centername \r\n" ;
	Session session2 = sessionFactory.getCurrentSession();
	Transaction tx2 = session2.beginTransaction();
	Query query2 = session2.createSQLQuery(qry);
	List<Object[]> result1= query2.list();
	for(Object[] a: result1) {
	System.out.println("sum of bales  "+a[0]);
	System.out.println("grades  "+a[1]);
	System.out.println("dpc_name  "+a[2]);

    	}
			return  result1;
		}

@Override
public List<Object[]> firstLevelbaleRegionwise(String cropyr, String basis) {
				
   String qry = "select NULLIF(sum(a.bale_no), 0 ) grade_sum, jute_grade = 1,  b.roname FROM [XMWJCI].[dbo].[jcibalepreparation] a join  [XMWJCI].[dbo].[jcirodetails] b on a.region = b.rocode where jute_grade like '%1' and crop_year = '"+cropyr+"' and a.basis = '"+basis+"' group by  b.roname\n" + 
				"union all \n" + 
				"select NULLIF(sum(a.bale_no), 0 ) grade_sum, jute_grade = 2,  b.roname FROM [XMWJCI].[dbo].[jcibalepreparation] a join  [XMWJCI].[dbo].[jcirodetails] b on a.region = b.rocode where jute_grade like '%2' and a.crop_year = '"+cropyr+"' and a.basis = '"+basis+"' group by  b.roname\n" + 
				"union all\n" + 
				"select NULLIF(sum(a.bale_no), 0 ) grade_sum, jute_grade = 3,  b.roname FROM [XMWJCI].[dbo].[jcibalepreparation] a join  [XMWJCI].[dbo].[jcirodetails] b on a.region = b.rocode where jute_grade like '%3' and a.crop_year = '"+cropyr+"' and a.basis = '"+basis+"' group by  b.roname\n" + 
				"union all\n" + 
				"select NULLIF(sum(a.bale_no), 0 ) grade_sum, jute_grade = 4,  b.roname FROM [XMWJCI].[dbo].[jcibalepreparation] a join  [XMWJCI].[dbo].[jcirodetails] b on a.region = b.rocode where jute_grade like '%4' and a.crop_year = '"+cropyr+"' and a.basis = '"+basis+"' group by  b.roname\n" + 
				"union all\n" + 
				"select NULLIF(sum(a.bale_no), 0 ) grade_sum, jute_grade = 5,  b.roname FROM [XMWJCI].[dbo].[jcibalepreparation] a join  [XMWJCI].[dbo].[jcirodetails] b on a.region = b.rocode where jute_grade like '%5' and a.crop_year = '"+cropyr+"' and a.basis = '"+basis+"' group by  b.roname\n" + 
				"union all \n" + 
				"select NULLIF(sum(a.bale_no), 0 ) grade_sum, jute_grade = 6,  b.roname FROM [XMWJCI].[dbo].[jcibalepreparation] a join  [XMWJCI].[dbo].[jcirodetails] b on a.region = b.rocode where jute_grade like '%6' and a.crop_year = '"+cropyr+"' and a.basis = '"+basis+"' group by  b.roname\n" + 
				"union all \n" + 
				"select NULLIF(sum(a.bale_no), 0 ) grade_sum, jute_grade = 7,  b.roname FROM [XMWJCI].[dbo].[jcibalepreparation] a join  [XMWJCI].[dbo].[jcirodetails] b on a.region = b.rocode where jute_grade like '%7' and a.crop_year = '"+cropyr+"' and a.basis = '"+basis+"' group by  b.roname\n" + 
				"union all \n" + 
				"select NULLIF(sum(a.bale_no), 0 ) grade_sum, jute_grade = 8,  b.roname FROM [XMWJCI].[dbo].[jcibalepreparation] a join  [XMWJCI].[dbo].[jcirodetails] b on a.region = b.rocode where jute_grade like '%8' and a.crop_year = '"+cropyr+"' and a.basis = '"+basis+"'	group by  b.roname";
		Session session2 = sessionFactory.getCurrentSession();
		Transaction tx2 = session2.beginTransaction();
		Query query2 = session2.createSQLQuery(qry);
		List<Object[]> result1= query2.list();
		for(Object[] a: result1) {
		System.out.println("sum of bales  "+a[0]);
		System.out.println("grades  "+a[1]);
		System.out.println("region_name  "+a[2]);
		System.out.println("firstLevelbaleRegionwise");
	
		}
	return  result1;
	}
	
	@Override
	public List<InventoryDTO> secondLeveljuteRegionwise(String cropyear, String basis,String baled,String variety) {
		// TODO Auto-generated method stub
		Criteria c = this.sessionFactory.getCurrentSession().createCriteria(RoDetailsModel.class);
		List<RoDetailsModel> Regionlists=c.list();
		List<InventoryDTO> inventoryDTOlist = new ArrayList<>();
		for(RoDetailsModel region : Regionlists)
		{
			 String querystr1="";
			 if("Baled".equals(baled))  
			 {
			 querystr1 = "SELECT \r\n" + 
			 		"    SUM(GRADE1) AS Total_GRADE1,\r\n" + 
			 		"    SUM(GRADE2) AS Total_GRADE2,\r\n" + 
			 		"    SUM(GRADE3) AS Total_GRADE3,\r\n" + 
			 		"    SUM(GRADE4) AS Total_GRADE4,\r\n" + 
			 		"    SUM(GRADE5) AS Total_GRADE5,\r\n" + 
			 		"    SUM(GRADE6) AS Total_GRADE6,\r\n" + 
			 		"    SUM(TOTAL) AS Total_Bales,\r\n" + 
			 		"    SUM(LOOSE) AS Total_Loose\r\n" + 
			 		"FROM (\r\n" + 
			 		"SELECT DISTINCT\r\n" + 
			 		"(SELECT SUM(J.bale_no) FROM jcibalepreparation J WHERE J.place_of_packing=j1.place_of_packing AND J.basis=j1.basis AND J.jute_variety=j1.jute_variety AND J.crop_year=j1.CROP_YEAR AND J.jute_grade LIKE '%1%') AS GRADE1,\r\n" + 
			 		"(SELECT SUM(J.bale_no) FROM jcibalepreparation J WHERE J.place_of_packing=j1.place_of_packing AND J.basis=j1.basis AND J.jute_variety=j1.jute_variety AND J.crop_year=j1.CROP_YEAR AND J.jute_grade LIKE '%2%') AS GRADE2,\r\n" + 
			 		"(SELECT SUM(J.bale_no) FROM jcibalepreparation J WHERE J.place_of_packing=j1.place_of_packing AND J.basis=j1.basis AND J.jute_variety=j1.jute_variety AND J.crop_year=j1.CROP_YEAR AND J.jute_grade LIKE '%3%') AS GRADE3,\r\n" + 
			 		"(SELECT SUM(J.bale_no) FROM jcibalepreparation J WHERE J.place_of_packing=j1.place_of_packing AND J.basis=j1.basis AND J.jute_variety=j1.jute_variety AND J.crop_year=j1.CROP_YEAR AND J.jute_grade LIKE '%4%') AS GRADE4,\r\n" + 
			 		"(SELECT SUM(J.bale_no) FROM jcibalepreparation J WHERE J.place_of_packing=j1.place_of_packing AND J.basis=j1.basis AND J.jute_variety=j1.jute_variety AND J.crop_year=j1.CROP_YEAR AND J.jute_grade LIKE '%5%') AS GRADE5,\r\n" + 
			 		"(SELECT SUM(J.bale_no) FROM jcibalepreparation J WHERE J.place_of_packing=j1.place_of_packing AND J.basis=j1.basis AND J.jute_variety=j1.jute_variety AND J.crop_year=j1.CROP_YEAR AND J.jute_grade LIKE '%6%') AS GRADE6,\r\n" + 
			 		"(SELECT SUM(J.bale_no) FROM jcibalepreparation J WHERE J.place_of_packing=j1.place_of_packing AND J.basis=j1.basis AND J.jute_variety=j1.jute_variety AND J.crop_year=j1.CROP_YEAR) AS TOTAL,\r\n" + 
			 		"(SELECT SUM(J.netquantity) FROM jcidpc J WHERE J.placeofpurchase=J1.place_of_packing AND J.basis=j1.basis AND J.jutevariety=J1.jute_variety AND J.cropyr=j1.crop_year) AS LOOSE\r\n" + 
			 		"FROM jcibalepreparation j1\r\n" + 
			 		"WHERE\r\n" + 
			 		"j1.crop_year='"+cropyear+"' and j1.basis = '"+basis+"' and j1.region = '"+region.getRocode()+"' and j1.jute_variety = '"+variety+"'\r\n" + 
			 		")as results;";
			 }
			 else
			 {
				 querystr1 ="SELECT \n"
				 		+ "    SUM(GRADE1) AS Total_GRADE1,\n"
				 		+ "    SUM(GRADE2) AS Total_GRADE2,\n"
				 		+ "    SUM(GRADE3) AS Total_GRADE3,\n"
				 		+ "    SUM(GRADE4) AS Total_GRADE4,\n"
				 		+ "    SUM(GRADE5) AS Total_GRADE5,\n"
				 		+ "    SUM(GRADE6) AS Total_GRADE6,\n"
				 		+ "    SUM(TOTAL) AS Total_Bales,\n"
				 		+ "    SUM(LOOSE) AS Total_Loose\n"
				 		+ "FROM (\n"
				 		+ "SELECT DISTINCT\n"
				 		+ "(SELECT SUM(J.bale_no * pur.nominal_wt) FROM jcibalepreparation J left join jcipurchasecenter pur on j.place_of_packing = pur.CENTER_CODE WHERE J.place_of_packing=j1.place_of_packing AND J.basis=j1.basis AND J.jute_variety=j1.jute_variety AND J.crop_year=j1.CROP_YEAR AND J.jute_grade LIKE '%1%') AS GRADE1,\n"
				 		+ "(SELECT SUM(J.bale_no * pur.nominal_wt) FROM jcibalepreparation J left join jcipurchasecenter pur on j.place_of_packing = pur.CENTER_CODE WHERE J.place_of_packing=j1.place_of_packing AND J.basis=j1.basis AND J.jute_variety=j1.jute_variety AND J.crop_year=j1.CROP_YEAR AND J.jute_grade LIKE '%2%') AS GRADE2,\n"
				 		+ "(SELECT SUM(J.bale_no * pur.nominal_wt) FROM jcibalepreparation J left join jcipurchasecenter pur on j.place_of_packing = pur.CENTER_CODE WHERE J.place_of_packing=j1.place_of_packing AND J.basis=j1.basis AND J.jute_variety=j1.jute_variety AND J.crop_year=j1.CROP_YEAR AND J.jute_grade LIKE '%3%') AS GRADE3,\n"
				 		+ "(SELECT SUM(J.bale_no * pur.nominal_wt) FROM jcibalepreparation J left join jcipurchasecenter pur on j.place_of_packing = pur.CENTER_CODE WHERE J.place_of_packing=j1.place_of_packing AND J.basis=j1.basis AND J.jute_variety=j1.jute_variety AND J.crop_year=j1.CROP_YEAR AND J.jute_grade LIKE '%4%') AS GRADE4,\n"
				 		+ "(SELECT SUM(J.bale_no * pur.nominal_wt) FROM jcibalepreparation J left join jcipurchasecenter pur on j.place_of_packing = pur.CENTER_CODE WHERE J.place_of_packing=j1.place_of_packing AND J.basis=j1.basis AND J.jute_variety=j1.jute_variety AND J.crop_year=j1.CROP_YEAR AND J.jute_grade LIKE '%5%') AS GRADE5,\n"
				 		+ "(SELECT SUM(J.bale_no * pur.nominal_wt) FROM jcibalepreparation J left join jcipurchasecenter pur on j.place_of_packing = pur.CENTER_CODE WHERE J.place_of_packing=j1.place_of_packing AND J.basis=j1.basis AND J.jute_variety=j1.jute_variety AND J.crop_year=j1.CROP_YEAR AND J.jute_grade LIKE '%6%') AS GRADE6,\n"
				 		+ "(SELECT SUM(J.bale_no * pur.nominal_wt) FROM jcibalepreparation J left join jcipurchasecenter pur on j.place_of_packing = pur.CENTER_CODE  WHERE J.place_of_packing=j1.place_of_packing AND J.basis=j1.basis AND J.jute_variety=j1.jute_variety AND J.crop_year=j1.CROP_YEAR) AS TOTAL,\n"
				 		+ "(SELECT SUM(J.netquantity) FROM jcidpc J WHERE J.placeofpurchase=J1.place_of_packing AND J.basis=j1.basis AND J.jutevariety=J1.jute_variety AND J.cropyr=j1.crop_year) AS LOOSE\n"
				 		+ "FROM jcibalepreparation j1\n"
				 		+ "WHERE\n"
				 		+ "j1.crop_year='"+cropyear+"' and j1.basis = '"+basis+"' and j1.region = '"+region.getRocode()+"' and j1.jute_variety = '"+variety+"'\n"
				 		+ ")as results;\n"
				 		+ "\n"
				 		+ "";
			 }
			Session session1 = sessionFactory.getCurrentSession();
			Transaction tx1 = session1.beginTransaction();
			SQLQuery query1 = session1.createSQLQuery(querystr1);
			List<Object[]> result1 = query1.list();
			
			if(result1 != null) {
				InventoryDTO inventoryDTO = new InventoryDTO();
				for(Object[] p :result1) {
					inventoryDTO.setGrade1(p[0] != null ? toDouble((Number) p[0]) : 0.0);
					inventoryDTO.setGrade2(p[1] != null ? toDouble((Number) p[1]) : 0.0);
					inventoryDTO.setGrade3(p[2] != null ? toDouble((Number) p[2]) : 0.0);
					inventoryDTO.setGrade4(p[3] != null ? toDouble((Number) p[3]) : 0.0);
					inventoryDTO.setGrade5(p[4] != null ? toDouble((Number) p[4]) : 0.0);
					inventoryDTO.setGrade6(p[5] != null ? toDouble((Number) p[5]) : 0.0);
					inventoryDTO.setGrade7(p[6] != null ? toDouble((Number) p[6]) : 0.0);
					inventoryDTO.setGrade8(p[7] != null ? ((BigDecimal) p[7]).doubleValue() : 0.0);
					inventoryDTO.setRoname(region.getRoname());
			}
				inventoryDTOlist.add(inventoryDTO);
		}
	    	
		System.out.println("inventoryDTOlist"+inventoryDTOlist);
		
	  }
		return inventoryDTOlist;
	}
	  private double toDouble(Number number) 
		 {
		    return number != null ? number.doubleValue() : 0.0;
		 }
	@Override
	public List<InventoryDTO> secondLevelbaleRegionwise(String cropyear, String basis) {
		// TODO Auto-generated method stub
		Criteria c = this.sessionFactory.getCurrentSession().createCriteria(RoDetailsModel.class);
		List<RoDetailsModel> Regionlists=c.list();
		List<InventoryDTO> inventoryDTOlistbale = new ArrayList<>();
		for(RoDetailsModel region : Regionlists)
		{
		
		String qry ="	 select NULLIF(sum(bale_no), 0)  FROM [XMWJCI].[dbo].[jcibalepreparation] where jute_grade like '%1' and crop_year = '"+cropyear+"' and basis = '"+basis+"' and region = '"+region.getRocode()+"'\n" + 
				"			 union all\n" + 
				"			   select NULLIF(sum(bale_no), 0 )  FROM [XMWJCI].[dbo].[jcibalepreparation] where jute_grade like '%2' and crop_year = '"+cropyear+"' and basis = '"+basis+"' and region = '"+region.getRocode()+"'\n" + 
				"			    union all\n" + 
				"			   select NULLIF(sum(bale_no), 0 )  FROM [XMWJCI].[dbo].[jcibalepreparation] where jute_grade like '%3' and crop_year = '"+cropyear+"' and basis = '"+basis+"' and region = '"+region.getRocode()+"'\n" + 
				"			     union all\n" + 
				"			   select NULLIF(sum(bale_no), 0 )  FROM [XMWJCI].[dbo].[jcibalepreparation] where jute_grade like '%4' and crop_year = '"+cropyear+"' and basis = '"+basis+"' and region = '"+region.getRocode()+"'\n" + 
				"			     union all\n" + 
				"			   select NULLIF(sum(bale_no), 0 )  FROM [XMWJCI].[dbo].[jcibalepreparation] where jute_grade like '%5' and crop_year = '"+cropyear+"' and basis = '"+basis+"' and region = '"+region.getRocode()+"'\n" + 
				"			     union all \n" + 
				"			   select NULLIF(sum(bale_no), 0 )  FROM [XMWJCI].[dbo].[jcibalepreparation] where jute_grade like '%6' and crop_year = '"+cropyear+"' and basis = '"+basis+"' and region = '"+region.getRocode()+"' \n" + 
				"						     union all \n" + 
				"			   select NULLIF(sum(bale_no), 0 )  FROM [XMWJCI].[dbo].[jcibalepreparation] where jute_grade like '%7' and crop_year = '"+cropyear+"' and basis = '"+basis+"' and region = '"+region.getRocode()+"'\n" + 
				"               			     union all \n" + 
				"			   select NULLIF(sum(bale_no), 0 )  FROM [XMWJCI].[dbo].[jcibalepreparation] where jute_grade like '%8' and crop_year = '"+cropyear+"' and basis = '"+basis+"' and region = '"+region.getRocode()+"'" ; 
					Session session2 = sessionFactory.getCurrentSession();
					Transaction tx2 = session2.beginTransaction();
					Query query2 = session2.createSQLQuery(qry);
					List<Integer> result1= query2.list();
					if(result1 != null) {
						InventoryDTO inventoryDTO = new InventoryDTO();
							inventoryDTO.setGrade1(result1.get(0) != null ? result1.get(0) : 0.0);
							inventoryDTO.setGrade2(result1.get(1) != null ? result1.get(1) : 0.0);
							inventoryDTO.setGrade3(result1.get(2) != null ? result1.get(2) : 0.0);
							inventoryDTO.setGrade4(result1.get(3) != null ? result1.get(3) : 0.0);
							inventoryDTO.setGrade5(result1.get(4) != null ? result1.get(4) : 0.0);
							inventoryDTO.setGrade6(result1.get(5) != null ? result1.get(5) : 0.0);
							inventoryDTO.setGrade7(result1.get(6) != null ? result1.get(6) : 0.0);
							inventoryDTO.setGrade8(result1.get(7) != null ? result1.get(7) : 0.0);
							inventoryDTO.setRoname(region.getRoname());
					
						inventoryDTOlistbale.add(inventoryDTO);
				}
					
					
					
	}
		return inventoryDTOlistbale;
  }

	@Override
	public List<InventoryDTO> second_level_jute_DPCwise(String cropyear, String basis, String region,String baled,String variety) {
		// TODO Auto-generated method stub
		String querystr = "SELECT jc.CENTER_CODE,jc.centername FROM jcipurchasecenter jc JOIN jcirodetails rn ON jc.rocode = rn.rocode WHERE rn.roname ='"+region+"'";
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		SQLQuery query = session.createSQLQuery(querystr);
		List<Object[]> rows = query.list();
		List<InventoryDTO> inventoryDTOlist = new ArrayList<>();
		for(Object[] row : rows)
		{
			 String querystr1="";
			 if("Baled".equals(baled))  
			 {
			 querystr1 = "SELECT \r\n" + 
			 		"    SUM(GRADE1) AS Total_GRADE1,\r\n" + 
			 		"    SUM(GRADE2) AS Total_GRADE2,\r\n" + 
			 		"    SUM(GRADE3) AS Total_GRADE3,\r\n" + 
			 		"    SUM(GRADE4) AS Total_GRADE4,\r\n" + 
			 		"    SUM(GRADE5) AS Total_GRADE5,\r\n" + 
			 		"    SUM(GRADE6) AS Total_GRADE6,\r\n" + 
			 		"    SUM(TOTAL) AS Total_Bales,\r\n" + 
			 		"    SUM(LOOSE) AS Total_Loose\r\n" + 
			 		"FROM (\r\n" + 
			 		"SELECT DISTINCT\r\n" + 
			 		"(SELECT SUM(J.bale_no) FROM jcibalepreparation J WHERE J.place_of_packing=j1.place_of_packing AND J.basis=j1.basis AND J.jute_variety=j1.jute_variety AND J.crop_year=j1.CROP_YEAR AND J.jute_grade LIKE '%1%') AS GRADE1,\r\n" + 
			 		"(SELECT SUM(J.bale_no) FROM jcibalepreparation J WHERE J.place_of_packing=j1.place_of_packing AND J.basis=j1.basis AND J.jute_variety=j1.jute_variety AND J.crop_year=j1.CROP_YEAR AND J.jute_grade LIKE '%2%') AS GRADE2,\r\n" + 
			 		"(SELECT SUM(J.bale_no) FROM jcibalepreparation J WHERE J.place_of_packing=j1.place_of_packing AND J.basis=j1.basis AND J.jute_variety=j1.jute_variety AND J.crop_year=j1.CROP_YEAR AND J.jute_grade LIKE '%3%') AS GRADE3,\r\n" + 
			 		"(SELECT SUM(J.bale_no) FROM jcibalepreparation J WHERE J.place_of_packing=j1.place_of_packing AND J.basis=j1.basis AND J.jute_variety=j1.jute_variety AND J.crop_year=j1.CROP_YEAR AND J.jute_grade LIKE '%4%') AS GRADE4,\r\n" + 
			 		"(SELECT SUM(J.bale_no) FROM jcibalepreparation J WHERE J.place_of_packing=j1.place_of_packing AND J.basis=j1.basis AND J.jute_variety=j1.jute_variety AND J.crop_year=j1.CROP_YEAR AND J.jute_grade LIKE '%5%') AS GRADE5,\r\n" + 
			 		"(SELECT SUM(J.bale_no) FROM jcibalepreparation J WHERE J.place_of_packing=j1.place_of_packing AND J.basis=j1.basis AND J.jute_variety=j1.jute_variety AND J.crop_year=j1.CROP_YEAR AND J.jute_grade LIKE '%6%') AS GRADE6,\r\n" + 
			 		"(SELECT SUM(J.bale_no) FROM jcibalepreparation J WHERE J.place_of_packing=j1.place_of_packing AND J.basis=j1.basis AND J.jute_variety=j1.jute_variety AND J.crop_year=j1.CROP_YEAR) AS TOTAL,\r\n" + 
			 		"(SELECT SUM(J.netquantity) FROM jcidpc J WHERE J.placeofpurchase=J1.place_of_packing AND J.basis=j1.basis AND J.jutevariety=J1.jute_variety AND J.cropyr=j1.crop_year) AS LOOSE\r\n" + 
			 		"FROM jcibalepreparation j1\r\n" + 
			 		"WHERE\r\n" + 
			 		"j1.crop_year='"+cropyear+"' and j1.basis = '"+basis+"' and j1.place_of_packing = '"+row[0].toString()+"' and j1.jute_variety = '"+variety+"'\r\n" + 
			 		")as results";
			 }
			 else
			 {
				 querystr1 ="SELECT \n"
				 		+ "    SUM(GRADE1) AS Total_GRADE1,\n"
				 		+ "    SUM(GRADE2) AS Total_GRADE2,\n"
				 		+ "    SUM(GRADE3) AS Total_GRADE3,\n"
				 		+ "    SUM(GRADE4) AS Total_GRADE4,\n"
				 		+ "    SUM(GRADE5) AS Total_GRADE5,\n"
				 		+ "    SUM(GRADE6) AS Total_GRADE6,\n"
				 		+ "    SUM(TOTAL) AS Total_Bales,\n"
				 		+ "    SUM(LOOSE) AS Total_Loose\n"
				 		+ "FROM (\n"
				 		+ "SELECT DISTINCT\n"
				 		+ "(SELECT SUM(J.bale_no * pur.nominal_wt) FROM jcibalepreparation J left join jcipurchasecenter pur on j.place_of_packing = pur.CENTER_CODE WHERE J.place_of_packing=j1.place_of_packing AND J.basis=j1.basis AND J.jute_variety=j1.jute_variety AND J.crop_year=j1.CROP_YEAR AND J.jute_grade LIKE '%1%') AS GRADE1,\n"
				 		+ "(SELECT SUM(J.bale_no * pur.nominal_wt) FROM jcibalepreparation J left join jcipurchasecenter pur on j.place_of_packing = pur.CENTER_CODE WHERE J.place_of_packing=j1.place_of_packing AND J.basis=j1.basis AND J.jute_variety=j1.jute_variety AND J.crop_year=j1.CROP_YEAR AND J.jute_grade LIKE '%2%') AS GRADE2,\n"
				 		+ "(SELECT SUM(J.bale_no * pur.nominal_wt) FROM jcibalepreparation J left join jcipurchasecenter pur on j.place_of_packing = pur.CENTER_CODE WHERE J.place_of_packing=j1.place_of_packing AND J.basis=j1.basis AND J.jute_variety=j1.jute_variety AND J.crop_year=j1.CROP_YEAR AND J.jute_grade LIKE '%3%') AS GRADE3,\n"
				 		+ "(SELECT SUM(J.bale_no * pur.nominal_wt) FROM jcibalepreparation J left join jcipurchasecenter pur on j.place_of_packing = pur.CENTER_CODE WHERE J.place_of_packing=j1.place_of_packing AND J.basis=j1.basis AND J.jute_variety=j1.jute_variety AND J.crop_year=j1.CROP_YEAR AND J.jute_grade LIKE '%4%') AS GRADE4,\n"
				 		+ "(SELECT SUM(J.bale_no * pur.nominal_wt) FROM jcibalepreparation J left join jcipurchasecenter pur on j.place_of_packing = pur.CENTER_CODE WHERE J.place_of_packing=j1.place_of_packing AND J.basis=j1.basis AND J.jute_variety=j1.jute_variety AND J.crop_year=j1.CROP_YEAR AND J.jute_grade LIKE '%5%') AS GRADE5,\n"
				 		+ "(SELECT SUM(J.bale_no * pur.nominal_wt) FROM jcibalepreparation J left join jcipurchasecenter pur on j.place_of_packing = pur.CENTER_CODE WHERE J.place_of_packing=j1.place_of_packing AND J.basis=j1.basis AND J.jute_variety=j1.jute_variety AND J.crop_year=j1.CROP_YEAR AND J.jute_grade LIKE '%6%') AS GRADE6,\n"
				 		+ "(SELECT SUM(J.bale_no * pur.nominal_wt) FROM jcibalepreparation J left join jcipurchasecenter pur on j.place_of_packing = pur.CENTER_CODE  WHERE J.place_of_packing=j1.place_of_packing AND J.basis=j1.basis AND J.jute_variety=j1.jute_variety AND J.crop_year=j1.CROP_YEAR) AS TOTAL,\n"
				 		+ "(SELECT SUM(J.netquantity) FROM jcidpc J WHERE J.placeofpurchase=J1.place_of_packing AND J.basis=j1.basis AND J.jutevariety=J1.jute_variety AND J.cropyr=j1.crop_year) AS LOOSE\n"
				 		+ "FROM jcibalepreparation j1\n"
				 		+ "WHERE\n"
				 		+ "j1.crop_year='"+cropyear+"' and j1.basis = '"+basis+"' and j1.place_of_packing = '"+row[0].toString()+"'and j1.jute_variety = '"+variety+"'\n"
				 		+ ")as results;\n"
				 		+ "\n"
				 		+ "";
			 }
			Session session1 = sessionFactory.getCurrentSession();
			Transaction tx1 = session1.beginTransaction();
			SQLQuery query1 = session1.createSQLQuery(querystr1);
			List<Object[]> result1 = query1.list();
			if(result1 != null) {
				InventoryDTO inventoryDTO = new InventoryDTO();
				for(Object[] p :result1) {
					inventoryDTO.setGrade1(p[0] != null ? toDouble((Number) p[0]) : 0.0);
					inventoryDTO.setGrade2(p[1] != null ? toDouble((Number) p[1]) : 0.0);
					inventoryDTO.setGrade3(p[2] != null ? toDouble((Number) p[2]) : 0.0);
					inventoryDTO.setGrade4(p[3] != null ? toDouble((Number) p[3]) : 0.0);
					inventoryDTO.setGrade5(p[4] != null ? toDouble((Number) p[4]) : 0.0);
					inventoryDTO.setGrade6(p[5] != null ? toDouble((Number) p[5]) : 0.0);
					inventoryDTO.setGrade7(p[6] != null ? toDouble((Number) p[6]) : 0.0);
					inventoryDTO.setGrade8(p[7] != null ? ((BigDecimal) p[7]).doubleValue() : 0.0);
					inventoryDTO.setRoname(row[1].toString());//setting dpc name
			}
				inventoryDTOlist.add(inventoryDTO);
		}
	    	
		System.out.println("inventoryDTOlist"+inventoryDTOlist);
		
	  }
		return inventoryDTOlist;
	}

	@Override
	public List<InventoryDTO> second_level_bale_DPCwise(String cropyear, String basis, String region) {
		// TODO Auto-generated method stub
		String querystr = "SELECT jc.CENTER_CODE,jc.centername FROM jcipurchasecenter jc JOIN jcirodetails rn ON jc.rocode = rn.rocode WHERE rn.roname ='"+region+"'";
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		SQLQuery query = session.createSQLQuery(querystr);
		List<Object[]> rows = query.list();
		List<InventoryDTO> inventoryDTOlistbale = new ArrayList<>();
		for(Object[] row : rows)
		{
		
		String qry ="	 select NULLIF(sum(bale_no), 0)  FROM [XMWJCI].[dbo].[jcibalepreparation] where jute_grade like '%1' and crop_year = '"+cropyear+"' and basis = '"+basis+"' and place_of_packing = '"+row[0].toString()+"'\n" + 
				"			 union all\n" + 
				"			   select NULLIF(sum(bale_no), 0 )  FROM [XMWJCI].[dbo].[jcibalepreparation] where jute_grade like '%2' and crop_year = '"+cropyear+"' and basis = '"+basis+"' and place_of_packing = '"+row[0].toString()+"'\n" + 
				"			    union all\n" + 
				"			   select NULLIF(sum(bale_no), 0 )  FROM [XMWJCI].[dbo].[jcibalepreparation] where jute_grade like '%3' and crop_year = '"+cropyear+"' and basis = '"+basis+"' and place_of_packing = '"+row[0].toString()+"'\n" + 
				"			     union all\n" + 
				"			   select NULLIF(sum(bale_no), 0 )  FROM [XMWJCI].[dbo].[jcibalepreparation] where jute_grade like '%4' and crop_year = '"+cropyear+"' and basis = '"+basis+"' and place_of_packing = '"+row[0].toString()+"'\n" + 
				"			     union all\n" + 
				"			   select NULLIF(sum(bale_no), 0 )  FROM [XMWJCI].[dbo].[jcibalepreparation] where jute_grade like '%5' and crop_year = '"+cropyear+"' and basis = '"+basis+"' and place_of_packing = '"+row[0].toString()+"'\n" + 
				"			     union all \n" + 
				"			   select NULLIF(sum(bale_no), 0 )  FROM [XMWJCI].[dbo].[jcibalepreparation] where jute_grade like '%6' and crop_year = '"+cropyear+"' and basis = '"+basis+"' and place_of_packing = '"+row[0].toString()+"' \n" + 
				"						     union all \n" + 
				"			   select NULLIF(sum(bale_no), 0 )  FROM [XMWJCI].[dbo].[jcibalepreparation] where jute_grade like '%7' and crop_year = '"+cropyear+"' and basis = '"+basis+"' and place_of_packing = '"+row[0].toString()+"'\n" + 
				"               			     union all \n" + 
				"			   select NULLIF(sum(bale_no), 0 )  FROM [XMWJCI].[dbo].[jcibalepreparation] where jute_grade like '%8' and crop_year = '"+cropyear+"' and basis = '"+basis+"' and place_of_packing = '"+row[0].toString()+"'" ; 
					Session session2 = sessionFactory.getCurrentSession();
					Transaction tx2 = session2.beginTransaction();
					Query query2 = session2.createSQLQuery(qry);
					List<Integer> result1= query2.list();
					if(result1 != null) {
						InventoryDTO inventoryDTO = new InventoryDTO();
							inventoryDTO.setGrade1(result1.get(0) != null ? result1.get(0) : 0.0);
							inventoryDTO.setGrade2(result1.get(1) != null ? result1.get(1) : 0.0);
							inventoryDTO.setGrade3(result1.get(2) != null ? result1.get(2) : 0.0);
							inventoryDTO.setGrade4(result1.get(3) != null ? result1.get(3) : 0.0);
							inventoryDTO.setGrade5(result1.get(4) != null ? result1.get(4) : 0.0);
							inventoryDTO.setGrade6(result1.get(5) != null ? result1.get(5) : 0.0);
							inventoryDTO.setGrade7(result1.get(6) != null ? result1.get(6) : 0.0);
							inventoryDTO.setGrade8(result1.get(7) != null ? result1.get(7) : 0.0);
							inventoryDTO.setRoname(row[1].toString());//setting dpc name
					
						inventoryDTOlistbale.add(inventoryDTO);
				}
					
					
					
	}
		return inventoryDTOlistbale;
  }

	@Override
	public List<Double> contractInHand_firstlevel(String currCropYear, String basis) {
		// TODO Auto-generated method stub
		String querystr1 = "";
		if("msp".equals(basis))
		{
		 querystr1="SELECT \r\n" + 
				"    COALESCE(SUM(CASE WHEN g.Jute_combination LIKE '%1%' THEN g.Proposed_composition ELSE 0 END), 0.0) AS Total_GRADE1,\r\n" + 
				"    COALESCE(SUM(CASE WHEN g.Jute_combination LIKE '%2%' THEN g.Proposed_composition ELSE 0 END), 0.0) AS Total_GRADE2,\r\n" + 
				"    COALESCE(SUM(CASE WHEN g.Jute_combination LIKE '%3%' THEN g.Proposed_composition ELSE 0 END), 0.0) AS Total_GRADE3,\r\n" + 
				"    COALESCE(SUM(CASE WHEN g.Jute_combination LIKE '%4%' THEN g.Proposed_composition ELSE 0 END), 0.0) AS Total_GRADE4,\r\n" + 
				"    COALESCE(SUM(CASE WHEN g.Jute_combination LIKE '%5%' THEN g.Proposed_composition ELSE 0 END), 0.0) AS Total_GRADE5,\r\n" + 
				"    COALESCE(SUM(CASE WHEN g.Jute_combination LIKE '%6%' THEN g.Proposed_composition ELSE 0 END), 0.0) AS Total_GRADE6,\r\n" + 
				"    COALESCE(SUM(g.Proposed_composition), 0.0) AS Total_All_Grades\r\n" + 
				"FROM \r\n" + 
				"    jcicontract c\r\n" + 
				"LEFT JOIN \r\n" + 
				"    jcigrade_composition g ON c.Grade_composition = g.Label_name\r\n" + 
				"WHERE \r\n" + 
				"    c.Contract_status = 'Approved by Finance' \r\n" + 
				"    AND c.CropYear = '"+currCropYear+"'";
		}else
		{
			//write quary for commercial
			return null;
		}
		Session session1 = sessionFactory.getCurrentSession();
		Transaction tx1 = session1.beginTransaction();
		SQLQuery query1 = session1.createSQLQuery(querystr1);
		List<Object[]> list = new ArrayList<Object[]>();
		List<Double> result2 = new ArrayList<Double>();
		List<Object[]> result1 = query1.list();
		
		if(result1 != null) {
		 for(Object[] p :result1) {
				 result2.add((Double)p[0]);
				 result2.add((Double)p[1]);
				 result2.add((Double)p[2]);
				 result2.add((Double)p[3]);
				 result2.add((Double)p[4]);
				 result2.add((Double)p[5]);
				 result2.add((Double)p[6]);
		 }
		}
		System.out.println("result2"+result2.toString());
		return result2;
	}

	@Override
	public List<InventoryDTO> regionAvailable(String cropyr, String basis,String baled,String variety) {
		Criteria c = this.sessionFactory.getCurrentSession().createCriteria(RoDetailsModel.class);
		List<RoDetailsModel> Regionlists=c.list();
		List<InventoryDTO> inventoryDTOAvailable = new ArrayList<>();
		String querystr1="";
		if("msp".equals(basis))
		{
			for(RoDetailsModel region : Regionlists)
			{
				 if("Baled".equals(baled))  
				 {
		           querystr1 = "SELECT \n"
		           		+ "    SUM(GRADE1) AS Total_GRADE1,\n"
		           		+ "    SUM(GRADE2) AS Total_GRADE2,\n"
		           		+ "    SUM(GRADE3) AS Total_GRADE3,\n"
		           		+ "    SUM(GRADE4) AS Total_GRADE4,\n"
		           		+ "    SUM(GRADE5) AS Total_GRADE5,\n"
		           		+ "    SUM(GRADE6) AS Total_GRADE6,\n"
		           		+ "    SUM(TOTAL) AS Total_Bales,\n"
		           		+ "    SUM(LOOSE) AS Total_Loose\n"
		           		+ "FROM (\n"
		           		+ "SELECT DISTINCT\n"
		           		+ "(SELECT SUM(J.No_of_bales ) FROM jcidispatch_details_child J left join jcidispatch_details dis on j.Challan_no = dis.Challan_no WHERE dis.Regional_Office = '"+region.getRocode()+"' and  J.jute_variety=j1.jute_variety AND J.crop_year=j1.CROP_YEAR AND J.jute_grade LIKE '%1%') AS GRADE1,\n"
		           		+ "(SELECT SUM(J.No_of_bales ) FROM jcidispatch_details_child J left join jcidispatch_details dis on j.Challan_no = dis.Challan_no WHERE dis.Regional_Office = '"+region.getRocode()+"' and J.jute_variety=j1.jute_variety AND J.crop_year=j1.CROP_YEAR AND J.jute_grade LIKE '%2%') AS GRADE2,\n"
		           		+ "(SELECT SUM(J.No_of_bales ) FROM jcidispatch_details_child J left join jcidispatch_details dis on j.Challan_no = dis.Challan_no WHERE dis.Regional_Office = '"+region.getRocode()+"' and  J.jute_variety=j1.jute_variety AND J.crop_year=j1.CROP_YEAR AND J.jute_grade LIKE '%3%') AS GRADE3,\n"
		           		+ "(SELECT SUM(J.No_of_bales ) FROM jcidispatch_details_child J left join jcidispatch_details dis on j.Challan_no = dis.Challan_no WHERE dis.Regional_Office = '"+region.getRocode()+"' and   J.jute_variety=j1.jute_variety AND J.crop_year=j1.CROP_YEAR AND J.jute_grade LIKE '%4%') AS GRADE4,\n"
		           		+ "(SELECT SUM(J.No_of_bales ) FROM jcidispatch_details_child J left join jcidispatch_details dis on j.Challan_no = dis.Challan_no WHERE dis.Regional_Office = '"+region.getRocode()+"' and  J.jute_variety=j1.jute_variety AND J.crop_year=j1.CROP_YEAR AND J.jute_grade LIKE '%5%') AS GRADE5,\n"
		           		+ "(SELECT SUM(J.No_of_bales ) FROM jcidispatch_details_child J left join jcidispatch_details dis on j.Challan_no = dis.Challan_no WHERE dis.Regional_Office = '"+region.getRocode()+"' and J.jute_variety=j1.jute_variety AND J.crop_year=j1.CROP_YEAR AND J.jute_grade LIKE '%6%') AS GRADE6,\n"
		           		+ "(SELECT SUM(J.No_of_bales ) FROM jcidispatch_details_child J left join jcidispatch_details dis on j.Challan_no = dis.Challan_no WHERE dis.Regional_Office = '"+region.getRocode()+"' and   J.jute_variety=j1.jute_variety AND J.crop_year=j1.CROP_YEAR) AS TOTAL,\n"
		           		+ "(SELECT SUM(J.netquantity) FROM jcidpc J WHERE J.jutevariety=J1.jute_variety AND J.cropyr=j1.crop_year) AS LOOSE\n"
		           		+ "FROM jcidispatch_details_child j1\n"
		           		+ "WHERE\n"
		           		+ "j1.crop_year='"+cropyr+"' and j1.Jute_variety = '"+variety+"' \n"
		           		+ ")as results;\n"
		           		+ "";
				 }
				 else {
					 querystr1 = "SELECT \n"
					 		+ "    SUM(GRADE1) AS Total_GRADE1,\n"
					 		+ "    SUM(GRADE2) AS Total_GRADE2,\n"
					 		+ "    SUM(GRADE3) AS Total_GRADE3,\n"
					 		+ "    SUM(GRADE4) AS Total_GRADE4,\n"
					 		+ "    SUM(GRADE5) AS Total_GRADE5,\n"
					 		+ "    SUM(GRADE6) AS Total_GRADE6,\n"
					 		+ "    SUM(TOTAL) AS Total_Bales,\n"
					 		+ "    SUM(LOOSE) AS Total_Loose\n"
					 		+ "FROM (\n"
					 		+ "SELECT DISTINCT\n"
					 		+ "(SELECT SUM(J.No_of_bales * j.nominal_wt) FROM jcidispatch_details_child J left join jcidispatch_details dis on j.Challan_no = dis.Challan_no WHERE dis.Regional_Office ='"+region.getRocode()+"'  and  J.jute_variety=j1.jute_variety AND J.crop_year=j1.CROP_YEAR AND J.jute_grade LIKE '%1%') AS GRADE1,\n"
					 		+ "(SELECT SUM(J.No_of_bales * j.nominal_wt) FROM jcidispatch_details_child J left join jcidispatch_details dis on j.Challan_no = dis.Challan_no WHERE dis.Regional_Office ='"+region.getRocode()+"'  and J.jute_variety=j1.jute_variety AND J.crop_year=j1.CROP_YEAR AND J.jute_grade LIKE '%2%') AS GRADE2,\n"
					 		+ "(SELECT SUM(J.No_of_bales * j.nominal_wt) FROM jcidispatch_details_child J left join jcidispatch_details dis on j.Challan_no = dis.Challan_no WHERE dis.Regional_Office ='"+region.getRocode()+"'  and  J.jute_variety=j1.jute_variety AND J.crop_year=j1.CROP_YEAR AND J.jute_grade LIKE '%3%') AS GRADE3,\n"
					 		+ "(SELECT SUM(J.No_of_bales * j.nominal_wt) FROM jcidispatch_details_child J left join jcidispatch_details dis on j.Challan_no = dis.Challan_no WHERE dis.Regional_Office ='"+region.getRocode()+"'  and   J.jute_variety=j1.jute_variety AND J.crop_year=j1.CROP_YEAR AND J.jute_grade LIKE '%4%') AS GRADE4,\n"
					 		+ "(SELECT SUM(J.No_of_bales * j.nominal_wt) FROM jcidispatch_details_child J left join jcidispatch_details dis on j.Challan_no = dis.Challan_no WHERE dis.Regional_Office ='"+region.getRocode()+"'  and  J.jute_variety=j1.jute_variety AND J.crop_year=j1.CROP_YEAR AND J.jute_grade LIKE '%5%') AS GRADE5,\n"
					 		+ "(SELECT SUM(J.No_of_bales * j.nominal_wt) FROM jcidispatch_details_child J left join jcidispatch_details dis on j.Challan_no = dis.Challan_no WHERE dis.Regional_Office ='"+region.getRocode()+"'  and J.jute_variety=j1.jute_variety AND J.crop_year=j1.CROP_YEAR AND J.jute_grade LIKE '%6%') AS GRADE6,\n"
					 		+ "(SELECT SUM(J.No_of_bales * j.nominal_wt) FROM jcidispatch_details_child J left join jcidispatch_details dis on j.Challan_no = dis.Challan_no WHERE dis.Regional_Office ='"+region.getRocode()+"' and   J.jute_variety=j1.jute_variety AND J.crop_year=j1.CROP_YEAR) AS TOTAL,\n"
					 		+ "(SELECT SUM(J.netquantity) FROM jcidpc J WHERE J.jutevariety=J1.jute_variety AND J.cropyr=j1.crop_year) AS LOOSE\n"
					 		+ "FROM jcidispatch_details_child j1\n"
					 		+ "WHERE\n"
					 		+ "j1.crop_year='"+cropyr+"' and j1.Jute_variety = '"+variety+"' \n"
					 		+ ")as results;\n"
					 		+ "";
				 }
			
			Session session1 = sessionFactory.getCurrentSession();
			Transaction tx1 = session1.beginTransaction();
			SQLQuery query1 = session1.createSQLQuery(querystr1);
			List<Object[]> result1 = query1.list();
			if(result1 != null) {
				InventoryDTO inventoryDTO = new InventoryDTO();
				for(Object[] p :result1) {
					inventoryDTO.setGrade1(p[0] != null ? toDouble((Number) p[0]) : 0.0);
					inventoryDTO.setGrade2(p[1] != null ? toDouble((Number) p[1]) : 0.0);
					inventoryDTO.setGrade3(p[2] != null ? toDouble((Number) p[2]) : 0.0);
					inventoryDTO.setGrade4(p[3] != null ? toDouble((Number) p[3]) : 0.0);
					inventoryDTO.setGrade5(p[4] != null ? toDouble((Number) p[4]) : 0.0);
					inventoryDTO.setGrade6(p[5] != null ? toDouble((Number) p[5]) : 0.0);
					inventoryDTO.setGrade7(p[6] != null ? toDouble((Number) p[6]) : 0.0);
					inventoryDTO.setGrade8(p[7] != null ? ((BigDecimal) p[7]).doubleValue() : 0.0);
					inventoryDTO.setRoname(region.getRoname());//setting region  name
			}
				inventoryDTOAvailable.add(inventoryDTO);
				System.err.println("inventoryDTOAvailable---"+inventoryDTO.toString());

			}
		  }
			return inventoryDTOAvailable;
		}else
		{
			return null;
			//for commercial write query here
		}
		
	}

	@Override
	public List<InventoryDTO> dpc_wise_available(String currCropYear, String basis, String region,String baled,String variety) {
		// TODO Auto-generated method stub
		String querystr = "SELECT jc.CENTER_CODE,jc.centername FROM jcipurchasecenter jc JOIN jcirodetails rn ON jc.rocode = rn.rocode WHERE rn.roname ='"+region+"'";
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		SQLQuery query = session.createSQLQuery(querystr);
		List<Object[]> rows = query.list();
		List<InventoryDTO> inventoryDTOlist = new ArrayList<>();
		String querystr1 = "";
		for(Object[] row : rows)
		{
			if("Baled".equals(baled))  
			 {
			querystr1 = "SELECT \n"
					+ "    SUM(GRADE1) AS Total_GRADE1,\n"
					+ "    SUM(GRADE2) AS Total_GRADE2,\n"
					+ "    SUM(GRADE3) AS Total_GRADE3,\n"
					+ "    SUM(GRADE4) AS Total_GRADE4,\n"
					+ "    SUM(GRADE5) AS Total_GRADE5,\n"
					+ "    SUM(GRADE6) AS Total_GRADE6,\n"
					+ "    SUM(TOTAL) AS Total_Bales,\n"
					+ "    SUM(LOOSE) AS Total_Loose\n"
					+ "FROM (\n"
					+ "SELECT DISTINCT\n"
					+ "(SELECT SUM(J.No_of_bales) FROM jcidispatch_details_child J left join jcidispatch_details dis on j.Challan_no = dis.Challan_no WHERE dis.Place_of_Shipment = '"+row[0].toString()+"' and  J.jute_variety=j1.jute_variety AND J.crop_year=j1.CROP_YEAR AND J.jute_grade LIKE '%1%') AS GRADE1,\n"
					+ "(SELECT SUM(J.No_of_bales) FROM jcidispatch_details_child J left join jcidispatch_details dis on j.Challan_no = dis.Challan_no WHERE dis.Place_of_Shipment = '"+row[0].toString()+"'  and J.jute_variety=j1.jute_variety AND J.crop_year=j1.CROP_YEAR AND J.jute_grade LIKE '%2%') AS GRADE2,\n"
					+ "(SELECT SUM(J.No_of_bales) FROM jcidispatch_details_child J left join jcidispatch_details dis on j.Challan_no = dis.Challan_no WHERE dis.Place_of_Shipment = '"+row[0].toString()+"'  and  J.jute_variety=j1.jute_variety AND J.crop_year=j1.CROP_YEAR AND J.jute_grade LIKE '%3%') AS GRADE3,\n"
					+ "(SELECT SUM(J.No_of_bales) FROM jcidispatch_details_child J left join jcidispatch_details dis on j.Challan_no = dis.Challan_no WHERE dis.Place_of_Shipment = '"+row[0].toString()+"' and   J.jute_variety=j1.jute_variety AND J.crop_year=j1.CROP_YEAR AND J.jute_grade LIKE '%4%') AS GRADE4,\n"
					+ "(SELECT SUM(J.No_of_bales) FROM jcidispatch_details_child J left join jcidispatch_details dis on j.Challan_no = dis.Challan_no WHERE dis.Place_of_Shipment = '"+row[0].toString()+"'  and  J.jute_variety=j1.jute_variety AND J.crop_year=j1.CROP_YEAR AND J.jute_grade LIKE '%5%') AS GRADE5,\n"
					+ "(SELECT SUM(J.No_of_bales) FROM jcidispatch_details_child J left join jcidispatch_details dis on j.Challan_no = dis.Challan_no WHERE dis.Place_of_Shipment = '"+row[0].toString()+"'  and J.jute_variety=j1.jute_variety AND J.crop_year=j1.CROP_YEAR AND J.jute_grade LIKE '%6%') AS GRADE6,\n"
					+ "(SELECT SUM(J.No_of_bales) FROM jcidispatch_details_child J left join jcidispatch_details dis on j.Challan_no = dis.Challan_no WHERE dis.Place_of_Shipment = '"+row[0].toString()+"'  and   J.jute_variety=j1.jute_variety AND J.crop_year=j1.CROP_YEAR) AS TOTAL,\n"
					+ "(SELECT SUM(J.netquantity) FROM jcidpc J WHERE J.jutevariety=J1.jute_variety AND J.cropyr=j1.crop_year) AS LOOSE\n"
					+ "FROM jcidispatch_details_child j1\n"
					+ "WHERE\n"
					+ "j1.crop_year='"+currCropYear+"' and j1.Jute_variety = '"+variety+"' \n"
					+ ")as results;";
			 }
			else {
				querystr1 ="SELECT \n"
						+ "    SUM(GRADE1) AS Total_GRADE1,\n"
						+ "    SUM(GRADE2) AS Total_GRADE2,\n"
						+ "    SUM(GRADE3) AS Total_GRADE3,\n"
						+ "    SUM(GRADE4) AS Total_GRADE4,\n"
						+ "    SUM(GRADE5) AS Total_GRADE5,\n"
						+ "    SUM(GRADE6) AS Total_GRADE6,\n"
						+ "    SUM(TOTAL) AS Total_Bales,\n"
						+ "    SUM(LOOSE) AS Total_Loose\n"
						+ "FROM (\n"
						+ "SELECT DISTINCT\n"
						+ "(SELECT SUM(J.No_of_bales * j.nominal_wt) FROM jcidispatch_details_child J left join jcidispatch_details dis on j.Challan_no = dis.Challan_no WHERE dis.Place_of_Shipment = '"+row[0].toString()+"' and  J.jute_variety=j1.jute_variety AND J.crop_year=j1.CROP_YEAR AND J.jute_grade LIKE '%1%') AS GRADE1,\n"
						+ "(SELECT SUM(J.No_of_bales * j.nominal_wt) FROM jcidispatch_details_child J left join jcidispatch_details dis on j.Challan_no = dis.Challan_no WHERE dis.Place_of_Shipment = '"+row[0].toString()+"'  and J.jute_variety=j1.jute_variety AND J.crop_year=j1.CROP_YEAR AND J.jute_grade LIKE '%2%') AS GRADE2,\n"
						+ "(SELECT SUM(J.No_of_bales * j.nominal_wt) FROM jcidispatch_details_child J left join jcidispatch_details dis on j.Challan_no = dis.Challan_no WHERE dis.Place_of_Shipment = '"+row[0].toString()+"'  and  J.jute_variety=j1.jute_variety AND J.crop_year=j1.CROP_YEAR AND J.jute_grade LIKE '%3%') AS GRADE3,\n"
						+ "(SELECT SUM(J.No_of_bales * j.nominal_wt) FROM jcidispatch_details_child J left join jcidispatch_details dis on j.Challan_no = dis.Challan_no WHERE dis.Place_of_Shipment = '"+row[0].toString()+"' and   J.jute_variety=j1.jute_variety AND J.crop_year=j1.CROP_YEAR AND J.jute_grade LIKE '%4%') AS GRADE4,\n"
						+ "(SELECT SUM(J.No_of_bales * j.nominal_wt) FROM jcidispatch_details_child J left join jcidispatch_details dis on j.Challan_no = dis.Challan_no WHERE dis.Place_of_Shipment = '"+row[0].toString()+"'  and  J.jute_variety=j1.jute_variety AND J.crop_year=j1.CROP_YEAR AND J.jute_grade LIKE '%5%') AS GRADE5,\n"
						+ "(SELECT SUM(J.No_of_bales * j.nominal_wt) FROM jcidispatch_details_child J left join jcidispatch_details dis on j.Challan_no = dis.Challan_no WHERE dis.Place_of_Shipment = '"+row[0].toString()+"'  and J.jute_variety=j1.jute_variety AND J.crop_year=j1.CROP_YEAR AND J.jute_grade LIKE '%6%') AS GRADE6,\n"
						+ "(SELECT SUM(J.No_of_bales * j.nominal_wt) FROM jcidispatch_details_child J left join jcidispatch_details dis on j.Challan_no = dis.Challan_no WHERE dis.Place_of_Shipment = '"+row[0].toString()+"'  and   J.jute_variety=j1.jute_variety AND J.crop_year=j1.CROP_YEAR) AS TOTAL,\n"
						+ "(SELECT SUM(J.netquantity) FROM jcidpc J WHERE J.jutevariety=J1.jute_variety AND J.cropyr=j1.crop_year) AS LOOSE\n"
						+ "FROM jcidispatch_details_child j1\n"
						+ "WHERE\n"
						+ "j1.crop_year='"+currCropYear+"'and j1.Jute_variety = '"+variety+"' \n"
						+ ")as results;\n"
						+ "";
			}
			Session session1 = sessionFactory.getCurrentSession();
			Transaction tx1 = session1.beginTransaction();
			SQLQuery query1 = session1.createSQLQuery(querystr1);
			List<Object[]> result1 = query1.list();
			if(result1 != null) {
				InventoryDTO inventoryDTO = new InventoryDTO();
				for(Object[] p :result1) {
					inventoryDTO.setGrade1(p[0] != null ? toDouble((Number) p[0]) : 0.0);
					inventoryDTO.setGrade2(p[1] != null ? toDouble((Number) p[1]) : 0.0);
					inventoryDTO.setGrade3(p[2] != null ? toDouble((Number) p[2]) : 0.0);
					inventoryDTO.setGrade4(p[3] != null ? toDouble((Number) p[3]) : 0.0);
					inventoryDTO.setGrade5(p[4] != null ? toDouble((Number) p[4]) : 0.0);
					inventoryDTO.setGrade6(p[5] != null ? toDouble((Number) p[5]) : 0.0);
					inventoryDTO.setGrade7(p[6] != null ? toDouble((Number) p[6]) : 0.0);
					inventoryDTO.setGrade8(p[7] != null ? ((BigDecimal) p[7]).doubleValue() : 0.0);
					inventoryDTO.setRoname(row[1].toString());//setting dpc name
			}
				inventoryDTOlist.add(inventoryDTO);
		}
	    	
		System.err.println("inventoryDTOlist"+inventoryDTOlist);
		
	  }
		return inventoryDTOlist;
	}

	@Override
	public List<Double> contractInHand_2ndlevel(String currCropYear, String basis, String status) {
		// TODO Auto-generated method stub
		String querystr1 = "";
		if("msp".equals(basis))
		{
			
//		 querystr1="SELECT \r\n" + 
//				"    COALESCE(SUM(CASE WHEN g.Jute_combination LIKE '%1%' THEN g.Proposed_composition ELSE 0 END), 0.0) AS Total_GRADE1,\r\n" + 
//				"    COALESCE(SUM(CASE WHEN g.Jute_combination LIKE '%2%' THEN g.Proposed_composition ELSE 0 END), 0.0) AS Total_GRADE2,\r\n" + 
//				"    COALESCE(SUM(CASE WHEN g.Jute_combination LIKE '%3%' THEN g.Proposed_composition ELSE 0 END), 0.0) AS Total_GRADE3,\r\n" + 
//				"    COALESCE(SUM(CASE WHEN g.Jute_combination LIKE '%4%' THEN g.Proposed_composition ELSE 0 END), 0.0) AS Total_GRADE4,\r\n" + 
//				"    COALESCE(SUM(CASE WHEN g.Jute_combination LIKE '%5%' THEN g.Proposed_composition ELSE 0 END), 0.0) AS Total_GRADE5,\r\n" + 
//				"    COALESCE(SUM(CASE WHEN g.Jute_combination LIKE '%6%' THEN g.Proposed_composition ELSE 0 END), 0.0) AS Total_GRADE6,\r\n" + 
//				"    COALESCE(SUM(g.Proposed_composition), 0.0) AS Total_All_Grades\r\n" + 
//				"FROM \r\n" + 
//				"    jcicontract c\r\n" + 
//				"LEFT JOIN \r\n" + 
//				"    jcigrade_composition g ON c.Grade_composition = g.Label_name\r\n" + 
//				"WHERE \r\n" + 
//				"    c.Contract_status = '"+status+"' \r\n" + 
//				"    AND c.CropYear = '"+currCropYear+"'";
			if("Mill Accepted".equals(status))
			{
				querystr1 = "SELECT \r\n"
						+ "    Round(COALESCE(SUM(CASE WHEN g.Jute_combination LIKE '%1%' THEN g.Proposed_composition/100 * c.Mill_qty ELSE 0 END), 0.0), 2) AS Total_GRADE1,\r\n"
						+ "    Round(COALESCE(SUM(CASE WHEN g.Jute_combination LIKE '%2%' THEN g.Proposed_composition/100 * c.Mill_qty ELSE 0 END), 0.0), 2) AS Total_GRADE2,\r\n"
						+ "    Round(COALESCE(SUM(CASE WHEN g.Jute_combination LIKE '%3%' THEN g.Proposed_composition/100 * c.Mill_qty ELSE 0 END), 0.0), 2) AS Total_GRADE3,\r\n"
						+ "    Round(COALESCE(SUM(CASE WHEN g.Jute_combination LIKE '%4%' THEN g.Proposed_composition/100 * c.Mill_qty ELSE 0 END), 0.0), 2) AS Total_GRADE4,\r\n"
						+ "    Round(COALESCE(SUM(CASE WHEN g.Jute_combination LIKE '%5%' THEN g.Proposed_composition/100 * c.Mill_qty ELSE 0 END), 0.0), 2) AS Total_GRADE5,\r\n"
						+ "    Round(COALESCE(SUM(CASE WHEN g.Jute_combination LIKE '%6%' THEN g.Proposed_composition/100 * c.Mill_qty ELSE 0 END), 0.0), 2) AS Total_GRADE6,\r\n"
						+ "    Round(\r\n"
						+ "        COALESCE(\r\n"
						+ "            SUM(CASE WHEN g.Jute_combination LIKE '%1%' THEN g.Proposed_composition / 100 * c.Mill_qty ELSE 0 END) +\r\n"
						+ "            SUM(CASE WHEN g.Jute_combination LIKE '%2%' THEN g.Proposed_composition / 100 * c.Mill_qty ELSE 0 END) +\r\n"
						+ "            SUM(CASE WHEN g.Jute_combination LIKE '%3%' THEN g.Proposed_composition / 100 * c.Mill_qty ELSE 0 END) +\r\n"
						+ "            SUM(CASE WHEN g.Jute_combination LIKE '%4%' THEN g.Proposed_composition / 100 * c.Mill_qty ELSE 0 END) +\r\n"
						+ "            SUM(CASE WHEN g.Jute_combination LIKE '%5%' THEN g.Proposed_composition / 100 * c.Mill_qty ELSE 0 END) +\r\n"
						+ "            SUM(CASE WHEN g.Jute_combination LIKE '%6%' THEN g.Proposed_composition / 100 * c.Mill_qty ELSE 0 END), \r\n"
						+ "        0.0), 2) AS Total_All_Grades\r\n"
						+ "FROM \r\n"
						+ "    jcicontract c\r\n"
						+ "LEFT JOIN \r\n"
						+ "    jcigrade_composition g ON c.Grade_composition = g.Label_name\r\n"
						+ "WHERE \r\n"
						+ "    c.Contract_status IN (\r\n"
						+ "        'Approved by Finance',\r\n"
						+ "        'DI Issued by HO',\r\n"
						+ "        'DI Issued by RO',\r\n"
						+ "        'Mill Accepted',\r\n"
						+ "        'Mill Raised Claim',\r\n"
						+ "        'Official Nomination done',\r\n"
						+ "        'Payment Done',\r\n"
						+ "        'Verification of Weighment Slip done',\r\n"
						+ "		'Demand note generated',\r\n"
						+ "		'credit note generated',\r\n"
						+ "		'Entry of weighment slip done',\r\n"
						+ "		'Bill of Supply Generated',\r\n"
						+ "		'Dispatch Details Entered'\r\n"
						+ "    )\r\n"
						+ "    AND c.CropYear = '"+currCropYear+"'";
			}else if("DI Issued by RO".equals(status))
			{
				querystr1 = "SELECT \r\n"
						+ "    COALESCE(SUM(CASE WHEN g.Jute_grade LIKE '%1%' THEN g.No_of_bales ELSE 0 END), 0.0) AS Total_GRADE1,\r\n"
						+ "    COALESCE(SUM(CASE WHEN g.Jute_grade LIKE '%2%' THEN g.No_of_bales ELSE 0 END), 0.0) AS Total_GRADE2,\r\n"
						+ "    COALESCE(SUM(CASE WHEN g.Jute_grade LIKE '%3%' THEN g.No_of_bales ELSE 0 END), 0.0) AS Total_GRADE3,\r\n"
						+ "    COALESCE(SUM(CASE WHEN g.Jute_grade LIKE '%4%' THEN g.No_of_bales ELSE 0 END), 0.0) AS Total_GRADE4,\r\n"
						+ "    COALESCE(SUM(CASE WHEN g.Jute_grade LIKE '%5%' THEN g.No_of_bales ELSE 0 END), 0.0) AS Total_GRADE5,\r\n"
						+ "    COALESCE(SUM(CASE WHEN g.Jute_grade LIKE '%6%' THEN g.No_of_bales ELSE 0 END), 0.0) AS Total_GRADE6,\r\n"
						+ "    COALESCE(SUM(g.No_of_bales), 0.0) AS Total_All_Grades\r\n"
						+ "FROM \r\n"
						+ "    jcidispatch_details_child g \r\n"
						+ "    where g.Crop_year = '"+currCropYear+"'";
			}
			else if("Payment not done".equals(status))
			{
				querystr1 = "SELECT \r\n"
						+ "    Round(COALESCE(SUM(CASE WHEN g.Jute_combination LIKE '%1%' THEN g.Proposed_composition/100 * c.Mill_qty ELSE 0 END), 0.0), 2) AS Total_GRADE1,\r\n"
						+ "    Round(COALESCE(SUM(CASE WHEN g.Jute_combination LIKE '%2%' THEN g.Proposed_composition/100 * c.Mill_qty ELSE 0 END), 0.0), 2) AS Total_GRADE2,\r\n"
						+ "    Round(COALESCE(SUM(CASE WHEN g.Jute_combination LIKE '%3%' THEN g.Proposed_composition/100 * c.Mill_qty ELSE 0 END), 0.0), 2) AS Total_GRADE3,\r\n"
						+ "    Round(COALESCE(SUM(CASE WHEN g.Jute_combination LIKE '%4%' THEN g.Proposed_composition/100 * c.Mill_qty ELSE 0 END), 0.0), 2) AS Total_GRADE4,\r\n"
						+ "    Round(COALESCE(SUM(CASE WHEN g.Jute_combination LIKE '%5%' THEN g.Proposed_composition/100 * c.Mill_qty ELSE 0 END), 0.0), 2) AS Total_GRADE5,\r\n"
						+ "    Round(COALESCE(SUM(CASE WHEN g.Jute_combination LIKE '%6%' THEN g.Proposed_composition/100 * c.Mill_qty ELSE 0 END), 0.0), 2) AS Total_GRADE6,\r\n"
						+ "    Round(\r\n"
						+ "        COALESCE(\r\n"
						+ "            SUM(CASE WHEN g.Jute_combination LIKE '%1%' THEN g.Proposed_composition / 100 * c.Mill_qty ELSE 0 END) +\r\n"
						+ "            SUM(CASE WHEN g.Jute_combination LIKE '%2%' THEN g.Proposed_composition / 100 * c.Mill_qty ELSE 0 END) +\r\n"
						+ "            SUM(CASE WHEN g.Jute_combination LIKE '%3%' THEN g.Proposed_composition / 100 * c.Mill_qty ELSE 0 END) +\r\n"
						+ "            SUM(CASE WHEN g.Jute_combination LIKE '%4%' THEN g.Proposed_composition / 100 * c.Mill_qty ELSE 0 END) +\r\n"
						+ "            SUM(CASE WHEN g.Jute_combination LIKE '%5%' THEN g.Proposed_composition / 100 * c.Mill_qty ELSE 0 END) +\r\n"
						+ "            SUM(CASE WHEN g.Jute_combination LIKE '%6%' THEN g.Proposed_composition / 100 * c.Mill_qty ELSE 0 END), \r\n"
						+ "        0.0), 2) AS Total_All_Grades\r\n"
						+ "FROM \r\n"
						+ "    jcicontract c\r\n"
						+ "LEFT JOIN \r\n"
						+ "    jcigrade_composition g ON c.Grade_composition = g.Label_name\r\n"
						+ "WHERE \r\n"
						+ "    c.Contract_status IN (\r\n"
						+ "        'Mill Accepted'\r\n"
						+ "    )\r\n"
						+ "    AND c.CropYear = '"+currCropYear+"'";
			}
			else if("Bill of supply generated".equals(status))
			{
				querystr1 = "SELECT \r\n"
						+ "    COALESCE(SUM(CASE WHEN g.Jute_grade LIKE '%1%' THEN g.No_of_bales ELSE 0 END), 0.0) AS Total_GRADE1,\r\n"
						+ "    COALESCE(SUM(CASE WHEN g.Jute_grade LIKE '%2%' THEN g.No_of_bales ELSE 0 END), 0.0) AS Total_GRADE2,\r\n"
						+ "    COALESCE(SUM(CASE WHEN g.Jute_grade LIKE '%3%' THEN g.No_of_bales ELSE 0 END), 0.0) AS Total_GRADE3,\r\n"
						+ "    COALESCE(SUM(CASE WHEN g.Jute_grade LIKE '%4%' THEN g.No_of_bales ELSE 0 END), 0.0) AS Total_GRADE4,\r\n"
						+ "    COALESCE(SUM(CASE WHEN g.Jute_grade LIKE '%5%' THEN g.No_of_bales ELSE 0 END), 0.0) AS Total_GRADE5,\r\n"
						+ "    COALESCE(SUM(CASE WHEN g.Jute_grade LIKE '%6%' THEN g.No_of_bales ELSE 0 END), 0.0) AS Total_GRADE6,\r\n"
						+ "    COALESCE(SUM(g.No_of_bales), 0.0) AS Total_All_Grades\r\n"
						+ "FROM \r\n"
						+ "    jcidispatch_details_child g \r\n"
						+ "    INNER join jcibos_generation c on g.Challan_no = c.Challan_no\r\n"
						+ "    where g.Crop_year = '"+currCropYear+"'";
			}

		}else
		{
			//write quary for commercial
			return null;
		}
		Session session1 = sessionFactory.getCurrentSession();
		Transaction tx1 = session1.beginTransaction();
		SQLQuery query1 = session1.createSQLQuery(querystr1);
		List<Object[]> list = new ArrayList<Object[]>();
		List<Double> result2 = new ArrayList<Double>();
		List<Object[]> result1 = query1.list();
		
		if(result1 != null) {
		 for(Object[] p :result1) {
			 for (int i = 0; i <= 6; i++) {
				    if (p[i] instanceof Double) {
				        result2.add((Double) p[i]); // Directly add if it's already a Double
				    } else if (p[i] instanceof BigDecimal) {
				        result2.add(((BigDecimal) p[i]).doubleValue()); // Convert BigDecimal to Double
				    } else {
				        result2.add(0.0); // Handle unexpected or null values
				    }
				}
		 }
		}
		System.out.println("result2"+result2.toString());
		return result2;
	}

	@Override
	public List<InventoryDTO> contract3rd_level(String currCropYear, String basis) {
		List<InventoryDTO> inventoryDTOAvailable = new ArrayList<>();
		String querystr1="";
		if("msp".equals(basis))
		{
		querystr1 = "SELECT \r\n" + 
				"   Distinct c.contract_no,\r\n" + 
				"    COALESCE(SUM(CASE WHEN g.Jute_combination LIKE '%1%' THEN g.Proposed_composition ELSE 0 END), 0.0) AS Total_GRADE1,\r\n" + 
				"    COALESCE(SUM(CASE WHEN g.Jute_combination LIKE '%2%' THEN g.Proposed_composition ELSE 0 END), 0.0) AS Total_GRADE2,\r\n" + 
				"    COALESCE(SUM(CASE WHEN g.Jute_combination LIKE '%3%' THEN g.Proposed_composition ELSE 0 END), 0.0) AS Total_GRADE3,\r\n" + 
				"    COALESCE(SUM(CASE WHEN g.Jute_combination LIKE '%4%' THEN g.Proposed_composition ELSE 0 END), 0.0) AS Total_GRADE4,\r\n" + 
				"    COALESCE(SUM(CASE WHEN g.Jute_combination LIKE '%5%' THEN g.Proposed_composition ELSE 0 END), 0.0) AS Total_GRADE5,\r\n" + 
				"    COALESCE(SUM(CASE WHEN g.Jute_combination LIKE '%6%' THEN g.Proposed_composition ELSE 0 END), 0.0) AS Total_GRADE6,\r\n" + 
				"    COALESCE(SUM(g.Proposed_composition), 0.0) AS Total_All_Grades\r\n" + 
				"FROM \r\n" + 
				"    jcicontract c\r\n" + 
				"LEFT JOIN \r\n" + 
				"    jcigrade_composition g ON c.Grade_composition = g.Label_name	\r\n" + 
				"WHERE \r\n" + 
				"    c.Contract_status = 'Payment not done' \r\n" + 
				"    AND c.CropYear = '"+currCropYear+"'\r\n" + 
				"Group by  c.contract_no";
			
			Session session1 = sessionFactory.getCurrentSession();
			Transaction tx1 = session1.beginTransaction();
			SQLQuery query1 = session1.createSQLQuery(querystr1);
			List<Object[]> result1 = query1.list();
			if(result1 != null) {
			
				for(Object[] p :result1) {
					InventoryDTO inventoryDTO = new InventoryDTO();
					inventoryDTO.setRoname((String)p[0]);//set Contract no
					inventoryDTO.setGrade1(p[1] != null ? (Double) p[1] : 0.0);
					inventoryDTO.setGrade2(p[2] != null ? (Double) p[2] : 0.0);
					inventoryDTO.setGrade3(p[3] != null ? (Double) p[3] : 0.0);
					inventoryDTO.setGrade4(p[4] != null ? (Double) p[4] : 0.0);
					inventoryDTO.setGrade5(p[5] != null ? (Double) p[5] : 0.0);
					inventoryDTO.setGrade6(p[6] != null ? (Double) p[6] : 0.0);
					inventoryDTO.setGrade7(p[7] != null ? (Double) p[7] : 0.0); //set total grade
					inventoryDTOAvailable.add(inventoryDTO);
			   }
			}
		  
			return inventoryDTOAvailable;
		}else
		{
			return null;
			//for commercial write query here
		}
		
	}

	@Override
	public List<InventoryDTO> contract4th_level(String currCropYear, String basis, String contractno) {
		List<InventoryDTO> inventoryDTOAvailable = new ArrayList<>();
		String querystr1="";
		if("msp".equals(basis))
		{
		querystr1 = "\r\n" + 
				"SELECT \r\n" + 
				"    DISTINCT CONCAT(c.Mill_code, '-', c.Mill_name) AS Mill,\r\n" + 
				"    COALESCE(SUM(CASE WHEN g.Jute_combination LIKE '%1%' THEN g.Proposed_composition ELSE 0 END), 0.0) AS Total_GRADE1,\r\n" + 
				"    COALESCE(SUM(CASE WHEN g.Jute_combination LIKE '%2%' THEN g.Proposed_composition ELSE 0 END), 0.0) AS Total_GRADE2,\r\n" + 
				"    COALESCE(SUM(CASE WHEN g.Jute_combination LIKE '%3%' THEN g.Proposed_composition ELSE 0 END), 0.0) AS Total_GRADE3,\r\n" + 
				"    COALESCE(SUM(CASE WHEN g.Jute_combination LIKE '%4%' THEN g.Proposed_composition ELSE 0 END), 0.0) AS Total_GRADE4,\r\n" + 
				"    COALESCE(SUM(CASE WHEN g.Jute_combination LIKE '%5%' THEN g.Proposed_composition ELSE 0 END), 0.0) AS Total_GRADE5,\r\n" + 
				"    COALESCE(SUM(CASE WHEN g.Jute_combination LIKE '%6%' THEN g.Proposed_composition ELSE 0 END), 0.0) AS Total_GRADE6,\r\n" + 
				"    COALESCE(SUM(g.Proposed_composition), 0.0) AS Total_All_Grades\r\n" + 
				"FROM \r\n" + 
				"    jcicontract c\r\n" + 
				"LEFT JOIN \r\n" + 
				"    jcigrade_composition g ON c.Grade_composition = g.Label_name\r\n" + 
				"WHERE \r\n" + 
				"    c.Contract_status = 'Payment not done' \r\n" + 
				"    AND c.CropYear = '"+currCropYear+"'\r\n" + 
				"    AND c.Contract_no = '"+contractno+"'\r\n" + 
				"GROUP BY  \r\n" + 
				"    c.Mill_code, c.Mill_name;";
			
			Session session1 = sessionFactory.getCurrentSession();
			Transaction tx1 = session1.beginTransaction();
			SQLQuery query1 = session1.createSQLQuery(querystr1);
			List<Object[]> result1 = query1.list();
			if(result1 != null) {
			
				for(Object[] p :result1) {
					InventoryDTO inventoryDTO = new InventoryDTO();
					inventoryDTO.setRoname((String)p[0]);//set Contract no
					inventoryDTO.setGrade1(p[1] != null ? (Double) p[1] : 0.0);
					inventoryDTO.setGrade2(p[2] != null ? (Double) p[2] : 0.0);
					inventoryDTO.setGrade3(p[3] != null ? (Double) p[3] : 0.0);
					inventoryDTO.setGrade4(p[4] != null ? (Double) p[4] : 0.0);
					inventoryDTO.setGrade5(p[5] != null ? (Double) p[5] : 0.0);
					inventoryDTO.setGrade6(p[6] != null ? (Double) p[6] : 0.0);
					inventoryDTO.setGrade7(p[7] != null ? (Double) p[7] : 0.0); //set total grade
					inventoryDTOAvailable.add(inventoryDTO);
			   }
			}
		  
			return inventoryDTOAvailable;
		}else
		{
			return null;
			//for commercial write query here
		}
		
	}

	@Override
	public List<InventoryDTO> juteVarityAvailable(String cropyr, String basis, String baled) {
		
		List<InventoryDTO> inventoryDTOJuteVariety = new ArrayList<>();
		try {
			int basiss = 2;
			if("msp".equals(basis)) 
			{
				basiss = 1;
			}
		// TODO Auto-generated method stub
		String querystr = "SELECT DISTINCT jutevariety FROM jcijutevariety where basis = '"+basiss+"'";
		Session session = null;
		session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		SQLQuery query = session.createSQLQuery(querystr);
		List<String> rows = query.list(); // Assuming jutevariety is a String
		for (String variety : rows) {
			List<Double> result2 = new ArrayList<Double>();

			 String querystr1="";
			 if("Baled".equals(baled))  
			 {
			 querystr1 = "SELECT \r\n" + 
			 		"    SUM(GRADE1) AS Total_GRADE1,\r\n" + 
			 		"    SUM(GRADE2) AS Total_GRADE2,\r\n" + 
			 		"    SUM(GRADE3) AS Total_GRADE3,\r\n" + 
			 		"    SUM(GRADE4) AS Total_GRADE4,\r\n" + 
			 		"    SUM(GRADE5) AS Total_GRADE5,\r\n" + 
			 		"    SUM(GRADE6) AS Total_GRADE6,\r\n" + 
			 		"    SUM(TOTAL) AS Total_Bales,\r\n" + 
			 		"    SUM(LOOSE) AS Total_Loose\r\n" + 
			 		"FROM (\r\n" + 
			 		"SELECT DISTINCT\r\n" + 
			 		"(SELECT SUM(J.bale_no) FROM jcibalepreparation J WHERE J.place_of_packing=j1.place_of_packing AND J.basis=j1.basis AND J.jute_variety=j1.jute_variety AND J.crop_year=j1.CROP_YEAR AND J.jute_grade LIKE '%1%') AS GRADE1,\r\n" + 
			 		"(SELECT SUM(J.bale_no) FROM jcibalepreparation J WHERE J.place_of_packing=j1.place_of_packing AND J.basis=j1.basis AND J.jute_variety=j1.jute_variety AND J.crop_year=j1.CROP_YEAR AND J.jute_grade LIKE '%2%') AS GRADE2,\r\n" + 
			 		"(SELECT SUM(J.bale_no) FROM jcibalepreparation J WHERE J.place_of_packing=j1.place_of_packing AND J.basis=j1.basis AND J.jute_variety=j1.jute_variety AND J.crop_year=j1.CROP_YEAR AND J.jute_grade LIKE '%3%') AS GRADE3,\r\n" + 
			 		"(SELECT SUM(J.bale_no) FROM jcibalepreparation J WHERE J.place_of_packing=j1.place_of_packing AND J.basis=j1.basis AND J.jute_variety=j1.jute_variety AND J.crop_year=j1.CROP_YEAR AND J.jute_grade LIKE '%4%') AS GRADE4,\r\n" + 
			 		"(SELECT SUM(J.bale_no) FROM jcibalepreparation J WHERE J.place_of_packing=j1.place_of_packing AND J.basis=j1.basis AND J.jute_variety=j1.jute_variety AND J.crop_year=j1.CROP_YEAR AND J.jute_grade LIKE '%5%') AS GRADE5,\r\n" + 
			 		"(SELECT SUM(J.bale_no) FROM jcibalepreparation J WHERE J.place_of_packing=j1.place_of_packing AND J.basis=j1.basis AND J.jute_variety=j1.jute_variety AND J.crop_year=j1.CROP_YEAR AND J.jute_grade LIKE '%6%') AS GRADE6,\r\n" + 
			 		"(SELECT SUM(J.bale_no) FROM jcibalepreparation J WHERE J.place_of_packing=j1.place_of_packing AND J.basis=j1.basis AND J.jute_variety=j1.jute_variety AND J.crop_year=j1.CROP_YEAR) AS TOTAL,\r\n" + 
			 		"(SELECT SUM(J.netquantity) FROM jcidpc J WHERE J.placeofpurchase=J1.place_of_packing AND J.basis=j1.basis AND J.jutevariety=J1.jute_variety AND J.cropyr=j1.crop_year) AS LOOSE\r\n" + 
			 		"FROM jcibalepreparation j1\r\n" + 
			 		"WHERE\r\n" + 
			 		"j1.crop_year='"+cropyr+"' and j1.basis = '"+basis+"' and j1.jute_variety ='"+variety+"'\r\n" + 
			 		")as results;";
			 }
			 else {
				 querystr1 ="SELECT \n"
				 		+ "    SUM(GRADE1) AS Total_GRADE1,\n"
				 		+ "    SUM(GRADE2) AS Total_GRADE2,\n"
				 		+ "    SUM(GRADE3) AS Total_GRADE3,\n"
				 		+ "    SUM(GRADE4) AS Total_GRADE4,\n"
				 		+ "    SUM(GRADE5) AS Total_GRADE5,\n"
				 		+ "    SUM(GRADE6) AS Total_GRADE6,\n"
				 		+ "    SUM(TOTAL) AS Total_Bales,\n"
				 		+ "    SUM(LOOSE) AS Total_Loose\n"
				 		+ "FROM (\n"
				 		+ "SELECT DISTINCT\n"
				 		+ "(SELECT SUM(J.bale_no * pur.nominal_wt) FROM jcibalepreparation J left join jcipurchasecenter pur on j.place_of_packing = pur.CENTER_CODE WHERE J.place_of_packing=j1.place_of_packing AND J.basis=j1.basis AND J.jute_variety=j1.jute_variety AND J.crop_year=j1.CROP_YEAR AND J.jute_grade LIKE '%1%') AS GRADE1,\n"
				 		+ "(SELECT SUM(J.bale_no * pur.nominal_wt) FROM jcibalepreparation J left join jcipurchasecenter pur on j.place_of_packing = pur.CENTER_CODE WHERE J.place_of_packing=j1.place_of_packing AND J.basis=j1.basis AND J.jute_variety=j1.jute_variety AND J.crop_year=j1.CROP_YEAR AND J.jute_grade LIKE '%2%') AS GRADE2,\n"
				 		+ "(SELECT SUM(J.bale_no * pur.nominal_wt) FROM jcibalepreparation J left join jcipurchasecenter pur on j.place_of_packing = pur.CENTER_CODE WHERE J.place_of_packing=j1.place_of_packing AND J.basis=j1.basis AND J.jute_variety=j1.jute_variety AND J.crop_year=j1.CROP_YEAR AND J.jute_grade LIKE '%3%') AS GRADE3,\n"
				 		+ "(SELECT SUM(J.bale_no * pur.nominal_wt) FROM jcibalepreparation J left join jcipurchasecenter pur on j.place_of_packing = pur.CENTER_CODE WHERE J.place_of_packing=j1.place_of_packing AND J.basis=j1.basis AND J.jute_variety=j1.jute_variety AND J.crop_year=j1.CROP_YEAR AND J.jute_grade LIKE '%4%') AS GRADE4,\n"
				 		+ "(SELECT SUM(J.bale_no * pur.nominal_wt) FROM jcibalepreparation J left join jcipurchasecenter pur on j.place_of_packing = pur.CENTER_CODE WHERE J.place_of_packing=j1.place_of_packing AND J.basis=j1.basis AND J.jute_variety=j1.jute_variety AND J.crop_year=j1.CROP_YEAR AND J.jute_grade LIKE '%5%') AS GRADE5,\n"
				 		+ "(SELECT SUM(J.bale_no * pur.nominal_wt) FROM jcibalepreparation J left join jcipurchasecenter pur on j.place_of_packing = pur.CENTER_CODE WHERE J.place_of_packing=j1.place_of_packing AND J.basis=j1.basis AND J.jute_variety=j1.jute_variety AND J.crop_year=j1.CROP_YEAR AND J.jute_grade LIKE '%6%') AS GRADE6,\n"
				 		+ "(SELECT SUM(J.bale_no * pur.nominal_wt) FROM jcibalepreparation J left join jcipurchasecenter pur on j.place_of_packing = pur.CENTER_CODE  WHERE J.place_of_packing=j1.place_of_packing AND J.basis=j1.basis AND J.jute_variety=j1.jute_variety AND J.crop_year=j1.CROP_YEAR) AS TOTAL,\n"
				 		+ "(SELECT SUM(J.netquantity) FROM jcidpc J WHERE J.placeofpurchase=J1.place_of_packing AND J.basis=j1.basis AND J.jutevariety=J1.jute_variety AND J.cropyr=j1.crop_year) AS LOOSE\n"
				 		+ "FROM jcibalepreparation j1\n"
				 		+ "WHERE\n"
				 		+ "j1.crop_year='"+cropyr+"' and j1.basis = '"+basis+"' and j1.jute_variety ='"+variety+"'\n"
				 		+ ")as results;";
			 }
			//Session session1 = sessionFactory.getCurrentSession();
			Transaction tx1 = session.beginTransaction();
			SQLQuery query1 = session.createSQLQuery(querystr1);
			List<Object[]> result1 = query1.list();
			if(result1 != null) {
			 for(Object[] p :result1) {
				 if(p[0] != null) {
					 if (p[0] instanceof Integer)
					 {
						 result2.add(((Integer) p[0]).doubleValue());
					 } 
					 else if (p[0] instanceof Double)
					 {
						result2.add(((Double) p[0]).doubleValue());
					 }
				 }else {
					 result2.add(0.0); 
				 }
				 
				 if(p[1] != null) {
					 if (p[1] instanceof Integer)
					 {
						 result2.add(((Integer) p[1]).doubleValue());
					 } 
					 else if (p[1] instanceof Double)
					 {
						result2.add(((Double) p[1]).doubleValue());
					 }
				 }else {
					 result2.add(0.0); 
				 }
				 if(p[2] != null) {
					 if (p[2] instanceof Integer)
					 {
						 result2.add(((Integer) p[2]).doubleValue());
					 } 
					 else if (p[2] instanceof Double)
					 {
						result2.add(((Double) p[2]).doubleValue());
					 }
				 }else {
					 result2.add(0.0); 
				 }
				 
				 if(p[3] != null) {
					 if (p[3] instanceof Integer)
					 {
						 result2.add(((Integer) p[3]).doubleValue());
					 } 
					 else if (p[3] instanceof Double)
					 {
						result2.add(((Double) p[3]).doubleValue());
					 }
				 }else {
					 result2.add(0.0); 
				 }
				 if(p[4] != null) {
					 if (p[4] instanceof Integer)
					 {
						 result2.add(((Integer) p[4]).doubleValue());
					 } 
					 else if (p[4] instanceof Double)
					 {
						result2.add(((Double) p[4]).doubleValue());
					 }
				 }else {
					 result2.add(0.0); 
				 }
				 if(p[5] != null) {
					 if (p[5] instanceof Integer)
					 {
						 result2.add(((Integer) p[5]).doubleValue());
					 } 
					 else if (p[5] instanceof Double)
					 {
						result2.add(((Double) p[5]).doubleValue());
					 }
				 }else {
					 result2.add(0.0); 
				 }
				 if(p[6] != null) {
					 if (p[6] instanceof Integer)
					 {
						 result2.add(((Integer) p[6]).doubleValue());
					 } 
					 else if (p[6] instanceof Double)
					 {
						result2.add(((Double) p[6]).doubleValue());
					 }
				 }else {
					 result2.add(0.0); 
				 }
	             if(p[7] != null) 
	            	 result2.add(((BigDecimal) p[7]).doubleValue());
	             else
	    			 result2.add(0.0); 
	              
	             
			 }
			}
			
		    
			//find dispatched jute variety wise
			

			String query2="";
			if("msp".equals(basis))
			{
				if("Baled".equals(baled))
				{
					query2 = "SELECT \n"
					+ "    SUM(GRADE1) AS Total_GRADE1,\n"
					+ "    SUM(GRADE2) AS Total_GRADE2,\n"
					+ "    SUM(GRADE3) AS Total_GRADE3,\n"
					+ "    SUM(GRADE4) AS Total_GRADE4,\n"
					+ "    SUM(GRADE5) AS Total_GRADE5,\n"
					+ "    SUM(GRADE6) AS Total_GRADE6,\n"
					+ "    SUM(TOTAL) AS Total_Bales,\n"
					+ "    SUM(LOOSE) AS Total_Loose\n"
					+ "FROM (\n"
					+ "SELECT DISTINCT\n"
					+ "(SELECT SUM(J.No_of_bales) FROM jcidispatch_details_child J WHERE J.jute_variety=j1.jute_variety AND J.crop_year=j1.CROP_YEAR AND J.jute_grade LIKE '%1%') AS GRADE1,\n"
					+ "(SELECT SUM(J.No_of_bales) FROM jcidispatch_details_child J  WHERE J.jute_variety=j1.jute_variety AND J.crop_year=j1.CROP_YEAR AND J.jute_grade LIKE '%2%') AS GRADE2,\n"
					+ "(SELECT SUM(J.No_of_bales) FROM jcidispatch_details_child J WHERE  J.jute_variety=j1.jute_variety AND J.crop_year=j1.CROP_YEAR AND J.jute_grade LIKE '%3%') AS GRADE3,\n"
					+ "(SELECT SUM(J.No_of_bales) FROM jcidispatch_details_child J  WHERE  J.jute_variety=j1.jute_variety AND J.crop_year=j1.CROP_YEAR AND J.jute_grade LIKE '%4%') AS GRADE4,\n"
					+ "(SELECT SUM(J.No_of_bales) FROM jcidispatch_details_child J  WHERE  J.jute_variety=j1.jute_variety AND J.crop_year=j1.CROP_YEAR AND J.jute_grade LIKE '%5%') AS GRADE5,\n"
					+ "(SELECT SUM(J.No_of_bales) FROM jcidispatch_details_child J WHERE  J.jute_variety=j1.jute_variety AND J.crop_year=j1.CROP_YEAR AND J.jute_grade LIKE '%6%') AS GRADE6,\n"
					+ "(SELECT SUM(J.No_of_bales) FROM jcidispatch_details_child J WHERE  J.jute_variety=j1.jute_variety AND J.crop_year=j1.CROP_YEAR) AS TOTAL,\n"
					+ "(SELECT SUM(J.netquantity) FROM jcidpc J WHERE J.jutevariety=J1.jute_variety AND J.cropyr=j1.crop_year) AS LOOSE\n"
					+ "FROM jcidispatch_details_child j1\n"
					+ "WHERE\n"
					+ "j1.crop_year='"+cropyr+"' and j1.Jute_variety = '"+variety+"' \n"
					+ ")as results;";
				}
				else {
					query2 ="SELECT \n"
							+ "    SUM(GRADE1) AS Total_GRADE1,\n"
							+ "    SUM(GRADE2) AS Total_GRADE2,\n"
							+ "    SUM(GRADE3) AS Total_GRADE3,\n"
							+ "    SUM(GRADE4) AS Total_GRADE4,\n"
							+ "    SUM(GRADE5) AS Total_GRADE5,\n"
							+ "    SUM(GRADE6) AS Total_GRADE6,\n"
							+ "    SUM(TOTAL) AS Total_Bales,\n"
							+ "    SUM(LOOSE) AS Total_Loose\n"
							+ "FROM (\n"
							+ "SELECT DISTINCT\n"
							+ "(SELECT SUM(J.No_of_bales * j.nominal_wt) FROM jcidispatch_details_child J WHERE J.jute_variety=j1.jute_variety AND J.crop_year=j1.CROP_YEAR AND J.jute_grade LIKE '%1%') AS GRADE1,\n"
							+ "(SELECT SUM(J.No_of_bales * j.nominal_wt) FROM jcidispatch_details_child J  WHERE J.jute_variety=j1.jute_variety AND J.crop_year=j1.CROP_YEAR AND J.jute_grade LIKE '%2%') AS GRADE2,\n"
							+ "(SELECT SUM(J.No_of_bales * j.nominal_wt) FROM jcidispatch_details_child J WHERE  J.jute_variety=j1.jute_variety AND J.crop_year=j1.CROP_YEAR AND J.jute_grade LIKE '%3%') AS GRADE3,\n"
							+ "(SELECT SUM(J.No_of_bales * j.nominal_wt) FROM jcidispatch_details_child J  WHERE  J.jute_variety=j1.jute_variety AND J.crop_year=j1.CROP_YEAR AND J.jute_grade LIKE '%4%') AS GRADE4,\n"
							+ "(SELECT SUM(J.No_of_bales * j.nominal_wt) FROM jcidispatch_details_child J  WHERE  J.jute_variety=j1.jute_variety AND J.crop_year=j1.CROP_YEAR AND J.jute_grade LIKE '%5%') AS GRADE5,\n"
							+ "(SELECT SUM(J.No_of_bales * j.nominal_wt) FROM jcidispatch_details_child J WHERE  J.jute_variety=j1.jute_variety AND J.crop_year=j1.CROP_YEAR AND J.jute_grade LIKE '%6%') AS GRADE6,\n"
							+ "(SELECT SUM(J.No_of_bales * j.nominal_wt) FROM jcidispatch_details_child J WHERE  J.jute_variety=j1.jute_variety AND J.crop_year=j1.CROP_YEAR) AS TOTAL,\n"
							+ "(SELECT SUM(J.netquantity) FROM jcidpc J WHERE J.jutevariety=J1.jute_variety AND J.cropyr=j1.crop_year) AS LOOSE\n"
							+ "FROM jcidispatch_details_child j1\n"
							+ "WHERE\n"
							+ "j1.crop_year='"+cropyr+"' and j1.Jute_variety = '"+variety+"' \n"
							+ ")as results;";
				}
			}else
			{
				return null;
				//for commercial write query here
			}
			//Session newsession1 = sessionFactory.getCurrentSession();
			Transaction newtx1 = session.beginTransaction();
			SQLQuery newquery1 = session.createSQLQuery(query2);
			List<Double> newresult2 = new ArrayList<Double>();
			List<Object[]> newresult1 = newquery1.list();
			 
			if(newresult1 != null) {
			 for(Object[] p :newresult1) {
				 if(p[0] != null) {
					 if (p[0] instanceof Integer)
					 {
						 newresult2.add(((Integer) p[0]).doubleValue());
					 } 
					 else if (p[0] instanceof Double)
					 {
						 newresult2.add(((Double) p[0]).doubleValue());
					 }
				 }else {
					 newresult2.add(0.0); 
				 }
				 
				 if(p[1] != null) {
					 if (p[1] instanceof Integer)
					 {
						 newresult2.add(((Integer) p[1]).doubleValue());
					 } 
					 else if (p[1] instanceof Double)
					 {
						 newresult2.add(((Double) p[1]).doubleValue());
					 }
				 }else {
					 newresult2.add(0.0); 
				 }
				 if(p[2] != null) {
					 if (p[2] instanceof Integer)
					 {
						 newresult2.add(((Integer) p[2]).doubleValue());
					 } 
					 else if (p[2] instanceof Double)
					 {
						 newresult2.add(((Double) p[2]).doubleValue());
					 }
				 }else {
					 newresult2.add(0.0); 
				 }
				 
				 if(p[3] != null) {
					 if (p[3] instanceof Integer)
					 {
						 newresult2.add(((Integer) p[3]).doubleValue());
					 } 
					 else if (p[3] instanceof Double)
					 {
						 newresult2.add(((Double) p[3]).doubleValue());
					 }
				 }else {
					 newresult2.add(0.0); 
				 }
				 if(p[4] != null) {
					 if (p[4] instanceof Integer)
					 {
						 newresult2.add(((Integer) p[4]).doubleValue());
					 } 
					 else if (p[4] instanceof Double)
					 {
						 newresult2.add(((Double) p[4]).doubleValue());
					 }
				 }else {
					 newresult2.add(0.0); 
				 }
				 if(p[5] != null) {
					 if (p[5] instanceof Integer)
					 {
						 newresult2.add(((Integer) p[5]).doubleValue());
					 } 
					 else if (p[5] instanceof Double)
					 {
						 newresult2.add(((Double) p[5]).doubleValue());
					 }
				 }else {
					 newresult2.add(0.0); 
				 }
				 if(p[6] != null) {
					 if (p[6] instanceof Integer)
					 {
						 newresult2.add(((Integer) p[6]).doubleValue());
					 } 
					 else if (p[6] instanceof Double)
					 {
						 newresult2.add(((Double) p[6]).doubleValue());
					 }
				 }else {
					 newresult2.add(0.0); 
				 }
	             if(p[7] != null) 
	            	 newresult2.add(((BigDecimal) p[7]).doubleValue());
	             else
	            	 newresult2.add(0.0); 
	              
	             
			 }
			}
			InventoryDTO JuteVarietyavailable = new InventoryDTO();
			JuteVarietyavailable.setGrade1(result2.get(0) - newresult2.get(0));
			JuteVarietyavailable.setGrade2(result2.get(1) - newresult2.get(1));
			JuteVarietyavailable.setGrade3(result2.get(2) - newresult2.get(2));
			JuteVarietyavailable.setGrade4(result2.get(3) - newresult2.get(3));
			JuteVarietyavailable.setGrade5(result2.get(4) - newresult2.get(4));
			JuteVarietyavailable.setGrade6(result2.get(5) - newresult2.get(5));
			JuteVarietyavailable.setGrade7(result2.get(6) - newresult2.get(6));
			JuteVarietyavailable.setGrade8(result2.get(7) - newresult2.get(7));
			JuteVarietyavailable.setRoname(variety);
			inventoryDTOJuteVariety.add(JuteVarietyavailable);
			
		}
		System.err.println("inventoryDTOJuteVariety"+inventoryDTOJuteVariety);
		return inventoryDTOJuteVariety;
	}catch(Exception e)
		{
		throw new RuntimeException("Failed to retrieve Jute variety", e);
		  
		}
		
		
		
	}

	@Override
	public List<InventoryDTO> juteVarityProcured(String cropyr, String basis, String baled) {
		
		List<InventoryDTO> inventoryDTOJuteVariety = new ArrayList<>();
		try {
			int basiss = 2;
			if("msp".equals(basis)) 
			{
				basiss = 1;
			}
		// TODO Auto-generated method stub
		String querystr = "SELECT DISTINCT jutevariety FROM jcijutevariety where basis = '"+basiss+"'";
		Session session = null;
		session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		SQLQuery query = session.createSQLQuery(querystr);
		List<String> rows = query.list(); // Assuming jutevariety is a String
		for (String variety : rows) {
			List<Double> result2 = new ArrayList<Double>();

			 String querystr1="";
			 if("Baled".equals(baled))  
			 {
			 querystr1 = "SELECT \r\n" + 
			 		"    SUM(GRADE1) AS Total_GRADE1,\r\n" + 
			 		"    SUM(GRADE2) AS Total_GRADE2,\r\n" + 
			 		"    SUM(GRADE3) AS Total_GRADE3,\r\n" + 
			 		"    SUM(GRADE4) AS Total_GRADE4,\r\n" + 
			 		"    SUM(GRADE5) AS Total_GRADE5,\r\n" + 
			 		"    SUM(GRADE6) AS Total_GRADE6,\r\n" + 
			 		"    SUM(TOTAL) AS Total_Bales,\r\n" + 
			 		"    SUM(LOOSE) AS Total_Loose\r\n" + 
			 		"FROM (\r\n" + 
			 		"SELECT DISTINCT\r\n" + 
			 		"(SELECT SUM(J.bale_no) FROM jcibalepreparation J WHERE J.place_of_packing=j1.place_of_packing AND J.basis=j1.basis AND J.jute_variety=j1.jute_variety AND J.crop_year=j1.CROP_YEAR AND J.jute_grade LIKE '%1%') AS GRADE1,\r\n" + 
			 		"(SELECT SUM(J.bale_no) FROM jcibalepreparation J WHERE J.place_of_packing=j1.place_of_packing AND J.basis=j1.basis AND J.jute_variety=j1.jute_variety AND J.crop_year=j1.CROP_YEAR AND J.jute_grade LIKE '%2%') AS GRADE2,\r\n" + 
			 		"(SELECT SUM(J.bale_no) FROM jcibalepreparation J WHERE J.place_of_packing=j1.place_of_packing AND J.basis=j1.basis AND J.jute_variety=j1.jute_variety AND J.crop_year=j1.CROP_YEAR AND J.jute_grade LIKE '%3%') AS GRADE3,\r\n" + 
			 		"(SELECT SUM(J.bale_no) FROM jcibalepreparation J WHERE J.place_of_packing=j1.place_of_packing AND J.basis=j1.basis AND J.jute_variety=j1.jute_variety AND J.crop_year=j1.CROP_YEAR AND J.jute_grade LIKE '%4%') AS GRADE4,\r\n" + 
			 		"(SELECT SUM(J.bale_no) FROM jcibalepreparation J WHERE J.place_of_packing=j1.place_of_packing AND J.basis=j1.basis AND J.jute_variety=j1.jute_variety AND J.crop_year=j1.CROP_YEAR AND J.jute_grade LIKE '%5%') AS GRADE5,\r\n" + 
			 		"(SELECT SUM(J.bale_no) FROM jcibalepreparation J WHERE J.place_of_packing=j1.place_of_packing AND J.basis=j1.basis AND J.jute_variety=j1.jute_variety AND J.crop_year=j1.CROP_YEAR AND J.jute_grade LIKE '%6%') AS GRADE6,\r\n" + 
			 		"(SELECT SUM(J.bale_no) FROM jcibalepreparation J WHERE J.place_of_packing=j1.place_of_packing AND J.basis=j1.basis AND J.jute_variety=j1.jute_variety AND J.crop_year=j1.CROP_YEAR) AS TOTAL,\r\n" + 
			 		"(SELECT SUM(J.netquantity) FROM jcidpc J WHERE J.placeofpurchase=J1.place_of_packing AND J.basis=j1.basis AND J.jutevariety=J1.jute_variety AND J.cropyr=j1.crop_year) AS LOOSE\r\n" + 
			 		"FROM jcibalepreparation j1\r\n" + 
			 		"WHERE\r\n" + 
			 		"j1.crop_year='"+cropyr+"' and j1.basis = '"+basis+"' and j1.jute_variety ='"+variety+"'\r\n" + 
			 		")as results;";
			 }
			 else {
				 querystr1 ="SELECT \n"
				 		+ "    SUM(GRADE1) AS Total_GRADE1,\n"
				 		+ "    SUM(GRADE2) AS Total_GRADE2,\n"
				 		+ "    SUM(GRADE3) AS Total_GRADE3,\n"
				 		+ "    SUM(GRADE4) AS Total_GRADE4,\n"
				 		+ "    SUM(GRADE5) AS Total_GRADE5,\n"
				 		+ "    SUM(GRADE6) AS Total_GRADE6,\n"
				 		+ "    SUM(TOTAL) AS Total_Bales,\n"
				 		+ "    SUM(LOOSE) AS Total_Loose\n"
				 		+ "FROM (\n"
				 		+ "SELECT DISTINCT\n"
				 		+ "(SELECT SUM(J.bale_no * pur.nominal_wt) FROM jcibalepreparation J left join jcipurchasecenter pur on j.place_of_packing = pur.CENTER_CODE WHERE J.place_of_packing=j1.place_of_packing AND J.basis=j1.basis AND J.jute_variety=j1.jute_variety AND J.crop_year=j1.CROP_YEAR AND J.jute_grade LIKE '%1%') AS GRADE1,\n"
				 		+ "(SELECT SUM(J.bale_no * pur.nominal_wt) FROM jcibalepreparation J left join jcipurchasecenter pur on j.place_of_packing = pur.CENTER_CODE WHERE J.place_of_packing=j1.place_of_packing AND J.basis=j1.basis AND J.jute_variety=j1.jute_variety AND J.crop_year=j1.CROP_YEAR AND J.jute_grade LIKE '%2%') AS GRADE2,\n"
				 		+ "(SELECT SUM(J.bale_no * pur.nominal_wt) FROM jcibalepreparation J left join jcipurchasecenter pur on j.place_of_packing = pur.CENTER_CODE WHERE J.place_of_packing=j1.place_of_packing AND J.basis=j1.basis AND J.jute_variety=j1.jute_variety AND J.crop_year=j1.CROP_YEAR AND J.jute_grade LIKE '%3%') AS GRADE3,\n"
				 		+ "(SELECT SUM(J.bale_no * pur.nominal_wt) FROM jcibalepreparation J left join jcipurchasecenter pur on j.place_of_packing = pur.CENTER_CODE WHERE J.place_of_packing=j1.place_of_packing AND J.basis=j1.basis AND J.jute_variety=j1.jute_variety AND J.crop_year=j1.CROP_YEAR AND J.jute_grade LIKE '%4%') AS GRADE4,\n"
				 		+ "(SELECT SUM(J.bale_no * pur.nominal_wt) FROM jcibalepreparation J left join jcipurchasecenter pur on j.place_of_packing = pur.CENTER_CODE WHERE J.place_of_packing=j1.place_of_packing AND J.basis=j1.basis AND J.jute_variety=j1.jute_variety AND J.crop_year=j1.CROP_YEAR AND J.jute_grade LIKE '%5%') AS GRADE5,\n"
				 		+ "(SELECT SUM(J.bale_no * pur.nominal_wt) FROM jcibalepreparation J left join jcipurchasecenter pur on j.place_of_packing = pur.CENTER_CODE WHERE J.place_of_packing=j1.place_of_packing AND J.basis=j1.basis AND J.jute_variety=j1.jute_variety AND J.crop_year=j1.CROP_YEAR AND J.jute_grade LIKE '%6%') AS GRADE6,\n"
				 		+ "(SELECT SUM(J.bale_no * pur.nominal_wt) FROM jcibalepreparation J left join jcipurchasecenter pur on j.place_of_packing = pur.CENTER_CODE  WHERE J.place_of_packing=j1.place_of_packing AND J.basis=j1.basis AND J.jute_variety=j1.jute_variety AND J.crop_year=j1.CROP_YEAR) AS TOTAL,\n"
				 		+ "(SELECT SUM(J.netquantity) FROM jcidpc J WHERE J.placeofpurchase=J1.place_of_packing AND J.basis=j1.basis AND J.jutevariety=J1.jute_variety AND J.cropyr=j1.crop_year) AS LOOSE\n"
				 		+ "FROM jcibalepreparation j1\n"
				 		+ "WHERE\n"
				 		+ "j1.crop_year='"+cropyr+"' and j1.basis = '"+basis+"' and j1.jute_variety ='"+variety+"'\n"
				 		+ ")as results;";
			 }
			//Session session1 = sessionFactory.getCurrentSession();
			Transaction tx1 = session.beginTransaction();
			SQLQuery query1 = session.createSQLQuery(querystr1);
			List<Object[]> result1 = query1.list();
			if(result1 != null) {
			 for(Object[] p :result1) {
				 if(p[0] != null) {
					 if (p[0] instanceof Integer)
					 {
						 result2.add(((Integer) p[0]).doubleValue());
					 } 
					 else if (p[0] instanceof Double)
					 {
						result2.add(((Double) p[0]).doubleValue());
					 }
				 }else {
					 result2.add(0.0); 
				 }
				 
				 if(p[1] != null) {
					 if (p[1] instanceof Integer)
					 {
						 result2.add(((Integer) p[1]).doubleValue());
					 } 
					 else if (p[1] instanceof Double)
					 {
						result2.add(((Double) p[1]).doubleValue());
					 }
				 }else {
					 result2.add(0.0); 
				 }
				 if(p[2] != null) {
					 if (p[2] instanceof Integer)
					 {
						 result2.add(((Integer) p[2]).doubleValue());
					 } 
					 else if (p[2] instanceof Double)
					 {
						result2.add(((Double) p[2]).doubleValue());
					 }
				 }else {
					 result2.add(0.0); 
				 }
				 
				 if(p[3] != null) {
					 if (p[3] instanceof Integer)
					 {
						 result2.add(((Integer) p[3]).doubleValue());
					 } 
					 else if (p[3] instanceof Double)
					 {
						result2.add(((Double) p[3]).doubleValue());
					 }
				 }else {
					 result2.add(0.0); 
				 }
				 if(p[4] != null) {
					 if (p[4] instanceof Integer)
					 {
						 result2.add(((Integer) p[4]).doubleValue());
					 } 
					 else if (p[4] instanceof Double)
					 {
						result2.add(((Double) p[4]).doubleValue());
					 }
				 }else {
					 result2.add(0.0); 
				 }
				 if(p[5] != null) {
					 if (p[5] instanceof Integer)
					 {
						 result2.add(((Integer) p[5]).doubleValue());
					 } 
					 else if (p[5] instanceof Double)
					 {
						result2.add(((Double) p[5]).doubleValue());
					 }
				 }else {
					 result2.add(0.0); 
				 }
				 if(p[6] != null) {
					 if (p[6] instanceof Integer)
					 {
						 result2.add(((Integer) p[6]).doubleValue());
					 } 
					 else if (p[6] instanceof Double)
					 {
						result2.add(((Double) p[6]).doubleValue());
					 }
				 }else {
					 result2.add(0.0); 
				 }
	             if(p[7] != null) 
	            	 result2.add(((BigDecimal) p[7]).doubleValue());
	             else
	    			 result2.add(0.0); 
	              
	             
			 }
			}
			
		    
			//find dispatched jute variety wise
			
			InventoryDTO JuteVarietyavailable = new InventoryDTO();
			JuteVarietyavailable.setGrade1(result2.get(0));
			JuteVarietyavailable.setGrade2(result2.get(1));
			JuteVarietyavailable.setGrade3(result2.get(2));
			JuteVarietyavailable.setGrade4(result2.get(3));
			JuteVarietyavailable.setGrade5(result2.get(4));
			JuteVarietyavailable.setGrade6(result2.get(5));
			JuteVarietyavailable.setGrade7(result2.get(6));
			JuteVarietyavailable.setGrade8(result2.get(7));
			JuteVarietyavailable.setRoname(variety);
			inventoryDTOJuteVariety.add(JuteVarietyavailable);
			
		}
		System.err.println("inventoryDTOJuteVariety"+inventoryDTOJuteVariety);
		return inventoryDTOJuteVariety;
	}catch(Exception e)
		{
		throw new RuntimeException("Failed to retrieve Jute variety", e);
		  
		}
		
		
		
	}
}