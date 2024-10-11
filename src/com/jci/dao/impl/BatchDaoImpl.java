package com.jci.dao.impl;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.jci.dao.BatchDao;
import com.jci.model.BalePreparation;
import com.jci.model.BatchIdentificationModel;
import com.jci.model.BinListFromDbDTO;
import com.jci.model.BinPurchaseMappingDTO;
import com.jci.model.UserRegistrationModel;


@Transactional
@Repository
public class BatchDaoImpl implements BatchDao {
	
	@Autowired
	private HttpServletRequest request;


	@Autowired
	SessionFactory sessionFactory;
	
	@Autowired
	private DataSource dataSource;

	
	protected Session currentSession(){
		return sessionFactory.getCurrentSession();
	}

	@Override
	public void create(BatchIdentificationModel batch) {
		currentSession().save(batch);
	}

	@Override
	public void update(BatchIdentificationModel batch) {
		currentSession().update(batch);
	}

	@Override
	public BatchIdentificationModel edit(int id) {
		return find(id);
	}

	@Override
	public void delete(int id) {
		BatchIdentificationModel rulingMarket = new BatchIdentificationModel();
		String hql = "Delete from dbo.jcirulingmarket where jcirulingmarketid = '"+id+"' " ;
		this.sessionFactory.getCurrentSession().createSQLQuery(hql).executeUpdate();
	}

	@Override
	public BatchIdentificationModel find(int id) {
		return (BatchIdentificationModel) currentSession().get(BatchIdentificationModel.class, id);
	}

	@Override
	public List<BatchIdentificationModel> getAll(String dpcId, String regionId, String zoneId) {
		Criteria c = this.sessionFactory.getCurrentSession().createCriteria(BatchIdentificationModel.class);
		HttpSession session1 = request.getSession(false);
		
		String querystr = "";
		String roletypes = (String) session1.getAttribute("roletype");

		if(roletypes.equalsIgnoreCase("HO")) {
	querystr = "SELECT pur.centername,bale.* FROM jcibin bale left join jcipurchasecenter pur on bale.dpcnames = pur.centername";
		}		else if(roletypes.equalsIgnoreCase("ZO")){
			
			querystr=" SELECT pur.centername,bale.* FROM jcibin bale left join jcipurchasecenter pur on bale.dpcnames = pur.centername  LEFT JOIN jcirodetails c ON pur.rocode = c.rocode where c.zonecode='"+zoneId+"'";
			
		}
		else if(roletypes.equalsIgnoreCase("RO")){
			querystr="SELECT pur.centername,bale.* FROM jcibin bale left join jcipurchasecenter pur on bale.dpcnames = pur.centername where pur.rocode='"+regionId+"'";
		}else {
			querystr = "SELECT pur.centername,bale.* FROM jcibin bale left join jcipurchasecenter pur on bale.dpcnames = pur.centername where pur.CENTER_CODE = '"+dpcId+"'";
		}
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		SQLQuery query = session.createSQLQuery(querystr);
		List<Object[]> rows = query.list();
		List<BatchIdentificationModel> ll = new ArrayList<>();
		for(Object[] row: rows) {
			BatchIdentificationModel binmodel = new BatchIdentificationModel();
			
			String dpcname =  (String) row[2];
			String jutevariety =  (String) row[2];
			String basis =  (String) row[4];
			String cropyear =  (String) row[5];
			String carrylose =  (String) row[6];
			String carryrope =  (String) row[7];
			String bin =  (String) row[12];
			
			binmodel.setDpcnames(dpcname);
			binmodel.setJutevariety(jutevariety);
			binmodel.setBasis(basis);
			binmodel.setCropyr(cropyear);
			binmodel.setCarryoverlossqty(carrylose);
			binmodel.setCarryropeqty(carryrope);
			binmodel.setBinnumber(bin);
			
			ll.add(binmodel);
		}

		return ll;
	}

	@Override
	public boolean submitform(BatchIdentificationModel batch) {
		this.sessionFactory.getCurrentSession().save(batch);
		return false;
	}

	@Override
	public List<String> GetDpcNamefromId(int dpcid) {
		List<String> result = new ArrayList<>();
		int count=0;

		//String querystr = "SELECT grade FROM jcijutevariety where  jutevariety like '"+ jvariety+"%'";
		String querystr = "select centername from dbo.jcipurchasecenter where pcid = '"+dpcid+"' ";
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		SQLQuery query = session.createSQLQuery(querystr);
		result = query.list();

		return result;
	}
	
	@Override
	public List<String> FinddetailsbasedonBinNo(String BinNo) {
		String querystr="";
		List<String> result = new ArrayList<>();
		//querystr = "select grasatrate,basis,jutevariety,netquantity,amountpayable from dbo.jciprocurement where binno='"+BinNo+"' ";
		querystr="select Date_of_purchase,Dpc_code,Basis,Jute_Variety,Crop_Year,Bin_No,Total_Net_Qty,Total_Garsat_Rate,Total_Value from BIN_Purchase_Mappping where Bin_No='"+BinNo+"' ";
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		SQLQuery query = session.createSQLQuery(querystr);
		result = query.list();	 
		return result;
	}
	
//	@Override
//	public List<BinPurchaseMappingDTO> GetBinPurchasemappingdetails(String cropyr,String dadatepurchasetepurchase,String binNo) {
//		String querystr="";
//		List<BinPurchaseMappingDTO> result = new ArrayList<>();
//		querystr = "select * from jcidpc where binno='1' AND cropyr='2023-2024' ";
//			
//		Session session = sessionFactory.getCurrentSession();
//		Transaction tx = session.beginTransaction();
//		SQLQuery query = session.createSQLQuery(querystr);
//		result = query.list();	 
//		return result;
//	}
	
	@Override
	public List<BinPurchaseMappingDTO> GetBinPurchasemappingdetails(String cropyr,String dadatepurchasetepurchase,String binNo) {
		StringBuilder sb = new StringBuilder();

		sb.append( "select * FROM jcidpc where binno='"+binNo+"' AND cropyr='"+cropyr+"'");
		String sql = sb.toString();
		List<BinPurchaseMappingDTO> ll = new ArrayList<>();		
		try {
			Connection connection =  dataSource.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			//preparedStatement.setString(1,BenefId);	
			ResultSet rs = preparedStatement.executeQuery();
			while(rs.next()){				 
				BinPurchaseMappingDTO binPurchaseMappingDTO = new BinPurchaseMappingDTO();				
				binPurchaseMappingDTO.setDate_of_purchase(rs.getString("datepurchase"));
				binPurchaseMappingDTO.setDpc_code(rs.getString("placeofpurchase"));
				binPurchaseMappingDTO.setBasis(rs.getString("basis"));
				binPurchaseMappingDTO.setJute_Variety(rs.getString("jutevariety"));				
				binPurchaseMappingDTO.setCrop_Year(rs.getString("cropyr"));
				binPurchaseMappingDTO.setBinNo(rs.getString("binno"));
				binPurchaseMappingDTO.setGrossQty(rs.getString("gquantity"));				
				binPurchaseMappingDTO.setDeductionQty(rs.getString("dquantity"));
				binPurchaseMappingDTO.setNetQty(rs.getString("netquantity")); 				
				binPurchaseMappingDTO.setGarsatRate(rs.getString("grasatrate"));
				binPurchaseMappingDTO.setValue(rs.getString("fibervalue"));
				/*
				 * binPurchaseMappingDTO.setGrossQty(rs.getString("fibervalue"));
				 * binPurchaseMappingDTO.setNetQty(rs.getString("fibervalue"));
				 */
				ll.add(binPurchaseMappingDTO);	
			}

		} catch (SQLException e) {
			//Todo
			System.out.println("Error from Function All Pending"+e.getMessage());
		}
		return ll;

	}
	
	@Override
	public List<String> GetTotalofPurchaseParams(String BinNo,String cropYr,String dateOfPurchase) {
		/*
		 * System.out.println("GetTotalofPurchaseParams"+BinNo);
		 * System.out.println("GetTotalofPurchaseParams"+cropYr);
		 * System.out.println("GetTotalofPurchaseParams"+dateOfPurchase);
		 */

		String querystr="";
		List<String> result = new ArrayList<>();
		/*
		 * querystr =
		 * "select SUM(grasatrate)TotalGarsate,SUM(netquantity)TotalNetQty,SUM(amountpayable)TotalValue from jciprocurement where binno='"
		 * +BinNo+"' AND cropyr='"+cropYr+"' AND datepurchase='"+dateOfPurchase+"'";
		 */
		querystr = "select SUM(grasatrate)TotalGarsate,SUM(netquantity)TotalNetQty,SUM(fibervalue)TotalValue from  jcidpc where binno='"+BinNo+"' AND cropyr='"+cropYr+"'";
				 
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		SQLQuery query = session.createSQLQuery(querystr);
		result = query.list();	 
		return result;
	}
	
	@Override
	public  List<String> InsertToBinPurchaseMapping(String Date_of_purchase,String Dpc_code,String Basis,String Jute_variety,String CropYr,String binNo,String TotalNetQty,String TotalGarsatRate,String TotalValue) {
		List<String> result = new ArrayList<>();
		int a=0;
		//int TotalGarsatRatei=(Integer.p(TotalGarsatRate));
        float TotalGarsatRatei = Float.parseFloat(TotalValue)/Float.parseFloat(TotalNetQty);
        
       //double roundOff = Math.round(TotalGarsatRatei* 100.0)/100.0;
        BigDecimal ba = new BigDecimal(TotalGarsatRatei);
        BigDecimal roundOff = ba.setScale(2, BigDecimal.ROUND_HALF_EVEN);
        System.out.println("TotalValue"+TotalValue);
        System.out.println("TotalNetQty"+TotalNetQty);
        System.out.println("TotalGarsatRatei"+TotalGarsatRatei*100);
        
        
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();

		//System.out.println("id from JBA DAO Impl is"+jbaId);
		Query query = session.createSQLQuery("{CALL [InsertIntoBinPurchasemapping](:P1,:P2,:P3,:P4,:P5,:P6,:P7,:P8,:P9)}");
		query.setParameter("P1", Date_of_purchase);
		query.setParameter("P2", Dpc_code);
		query.setParameter("P3", Basis);
		query.setParameter("P4", Jute_variety);
		query.setParameter("P5", CropYr);
		query.setParameter("P6", binNo);
		query.setParameter("P7", Float.parseFloat(TotalNetQty)/100 );
		//query.setParameter("P8", Float.parseFloat(TotalGarsatRate)/100);
		query.setParameter("P8", TotalGarsatRatei*100);
		query.setParameter("P9", TotalValue);		

		List<String> results = query.list();
		//System.out.println("binPurchaseMappingData===========-----  "+results);
		
		CalculateGainBasedonBinFromproc(CropYr,binNo);
		return results;

	}
	
	@Override
	public  List<String> CalculateGainBasedonBinFromproc(String FinYear,String binNO) {
		List<String> result = new ArrayList<>();
		int a=0;
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();

		//System.out.println("id from JBA DAO Impl is"+jbaId);
		Query query = session.createSQLQuery("{CALL [GetValue_fromBale_Preperation](:P1,:P2)}");
		query.setParameter("P1", Integer.parseInt(binNO));
		query.setParameter("P2", FinYear);
	//	System.out.println("GetValue_fromBale_Preperation=============--------- "+query.list());
		List<String> results = query.list();
		
		return results;

	}
	
	@Override
	public  List<String> InsertTotalwithGaininBinTabledb(String FinYear,String binNO,String Fingain,String WeightGain) {
		List<String> result = new ArrayList<>();
		int a=0;
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();

		//System.out.println("id from JBA DAO Impl is"+jbaId);
		Query query = session.createSQLQuery("{CALL [InsertTotalWithGaininBinTable](:P1,:P2,:P3,:P4)}");
		query.setParameter("P1", Integer.parseInt(binNO));
		query.setParameter("P2", FinYear);
		query.setParameter("P3", Fingain);
		query.setParameter("P4", WeightGain);
		List<String> results = query.list();
		return results;

	}
	
	 
	
	@Override
	public List<BinListFromDbDTO> GetBinListFromDb() {
		StringBuilder sb = new StringBuilder();
		 

		sb.append("select * from tbl_jci_bin");
		String sql = sb.toString();
		List<BinListFromDbDTO> ll = new ArrayList<>();		
		try {
			Connection connection =  dataSource.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			//preparedStatement.setString(1,BenefId);	
			ResultSet rs = preparedStatement.executeQuery();
			while(rs.next()){				 
				BinListFromDbDTO binListFromDbDTO = new BinListFromDbDTO();				
				binListFromDbDTO.setTotalValue(rs.getString("total_value"));
				binListFromDbDTO.setTotalNetQty(rs.getString("total_netqty"));
				binListFromDbDTO.setTotalGarset(rs.getString("total_garset"));
				binListFromDbDTO.setBinNO(rs.getString("binNo"));
				binListFromDbDTO.setCrop_Year(rs.getString("crop_yr"));
				binListFromDbDTO.setFinGain(rs.getString("Fin_gain"));
				binListFromDbDTO.setWeightGain(rs.getString("weight_gain"));
				
				ll.add(binListFromDbDTO);	
			}

		} catch (SQLException e) {
			//Todo
			System.out.println("Error from Function All Pending"+e.getMessage());
		}
		return ll;

	}

	@Override
	public String ropeAndJutePrice(String juteVariety, String basis,String binNumber) {
		List<Object[]> ropeprice= new ArrayList<>();
		List<Object[]> juteprice = new ArrayList<>();
		String ropePrice=null;
		String jutePrice=null;
		

		
		
		jutePrice= "select cast(sum(fibervalue)/sum(netquantity)AS DECIMAL(20, 2))    FROM jcidpc where binno ='"+binNumber+"'";
				
				
		  Session session = sessionFactory.getCurrentSession(); 
		  Transaction tx=session.beginTransaction(); 
		  SQLQuery query=session.createSQLQuery(jutePrice); 
		  juteprice= query.list(); 
		  String jute= juteprice.toString().replace("[", "").replace("]", "");;
		  if(jute.contentEquals("null"))
			  jute="0.0";
		 // System.out.println("priceOfJute====>>>> "+jute);
		  
		  
	if(basis.equalsIgnoreCase("msp")) {
			
		if(juteVariety.equalsIgnoreCase("bimli")||juteVariety.equalsIgnoreCase("mesta")) 
			ropePrice="select cast((sum(a.grade6xnetqty)+sum(b.grade6xnetqty))/(sum(a.netquantity)+sum(b.netquantity))AS DECIMAL(20, 2))  FROM jciprocurement a join jcidpc b on a.binno=b.binno where b.binno='"+binNumber+"' and  b.formno IS NULL"  ;		
			
			
		else if (juteVariety.equalsIgnoreCase("tossa (new)")||juteVariety.equalsIgnoreCase("white (new)")) 
			ropePrice="select cast((sum(a.grade8xnetqty)+sum(b.grade8xnetqty))/(sum(a.netquantity)+sum(b.netquantity))AS DECIMAL(20, 2)) FROM jciprocurement a join jcidpc b on a.binno=b.binno where b.binno='"+binNumber+"' and  b.formno IS NULL" ;		
			
	}
	else if(basis.equalsIgnoreCase("commercial")) {
			
		if(juteVariety.equalsIgnoreCase("bimli")||juteVariety.equalsIgnoreCase("mesta")) 
			ropePrice="select cast((sum(a.grade6xnetqty)+sum(b.grade6xnetqty))/(sum(a.netquantity)+sum(b.netquantity))AS DECIMAL(20, 2)) FROM jciprocurement a join jcidpc b on a.binno=b.binno where b.binno='"+binNumber+"' and  b.formno IS NULL" ;	
			
			
		else if (juteVariety.equalsIgnoreCase("tossa")||juteVariety.equalsIgnoreCase("white")) 
			ropePrice="select cast((sum(a.grade5xnetqty)+sum(b.grade5xnetqty))/(sum(a.netquantity)+sum(b.netquantity))AS DECIMAL(20, 2)) FROM jciprocurement a join jcidpc b on a.binno=b.binno where b.binno='"+binNumber+"' and  b.formno IS NULL" ;		
			
	}
				Session sessionn = sessionFactory.getCurrentSession();
				Transaction txx= sessionn.beginTransaction();
				SQLQuery querystr= sessionn.createSQLQuery(ropePrice);
				ropeprice= querystr.list();
				String rope= ropeprice.toString().replace("[", "").replace("]", "");
				//System.out.println("ropeprice====>>>> "+rope);
				 if(rope.contentEquals("null") )
					 rope="0.0";
			  
			 
		return (rope+","+jute);
	}
	
	
}
