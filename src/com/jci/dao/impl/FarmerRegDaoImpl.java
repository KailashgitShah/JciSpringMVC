package com.jci.dao.impl;

import java.util.ArrayList;
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
 
import com.jci.dao.FarmerRegDao;
import com.jci.model.FarmerRegModel;
import com.jci.model.FarmerRegModelDTO;

@Transactional
@Repository
public class FarmerRegDaoImpl implements FarmerRegDao{
	
	@Autowired
	private HttpServletRequest request;

	@Autowired
	SessionFactory sessionFactory;
	protected Session currentSession(){
		return sessionFactory.getCurrentSession();
	}

	public static void main(String[] args) {
		 FarmerRegDaoImpl fr = new FarmerRegDaoImpl();
		 fr.findRegno("05","0212");
	}
	
	
	@Override
	public void create(FarmerRegModel farmerRegModel) {
		currentSession().saveOrUpdate(farmerRegModel);
	}

	@Override
	public void update(FarmerRegModel farmerRegModel) {
		currentSession().update(farmerRegModel);
	}

	@Override
	public FarmerRegModel edit(int id) {
		return find(id);
	}

	@Override
	public void delete(int id) {
		FarmerRegModel farmerRegModel = new FarmerRegModel();
		String hql = "Delete from dbo.jcirmt where F_ID = '"+id+"' " ;
		this.sessionFactory.getCurrentSession().createSQLQuery(hql).executeUpdate();
	}

	@Override
	public FarmerRegModel find(int id) {
		return (FarmerRegModel) currentSession().get(FarmerRegModel.class, id);
	}

	@Override
	public List<FarmerRegModel> getAll() {
		Criteria c = this.sessionFactory.getCurrentSession().createCriteria(FarmerRegModel.class);
		List<FarmerRegModel> ll=c.list();
		return ll;
	}

	@Override
	public boolean submitform(FarmerRegModel farmerRegModel) {
		this.sessionFactory.getCurrentSession().saveOrUpdate(farmerRegModel);
		return false;
	}

	@Override
	public boolean validateMobile(String mobileNo) {
		List<Integer> result = new ArrayList<>();
		String querystr = "select * from jcirmt where F_MOBILE ='"+mobileNo+"'";
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		SQLQuery query = session.createSQLQuery(querystr);
		List<Object[]> rows = query.list();
		boolean isPresent = rows.isEmpty();
		if(isPresent) {
			return true;
		}else {
			return false;
		}
	}

	

	@Override
	public List <FarmerRegModelDTO> verificationStatus(String dpcid, String region, String zone) {
		List<Integer> result = new ArrayList<>();
		//String querystr = "Select a.*, b.verficationid, b.regno, b.ifsccode, b.accountno, b.farmername, b.address, b.status, b.verificationdate, st.state_name from jcirmt a left Join jcifarmerverification b on a.F_REG_NO = b.regno left join tbl_states st on a.F_STATE = st.id";
		HttpSession session1=request.getSession(false); 
		String querystr = "";
		int is_ho = (int)session1.getAttribute("is_ho");
		String roletypes = (String) session1.getAttribute("roletype");

		if(roletypes.equalsIgnoreCase("HO")){
		
			querystr = "Select top 100 a.*, b.verficationid, b.regno, b.ifsccode, b.accountno, b.farmername, b.address, b.status, b.verificationdate, st.state_name, d.district_name from jcirmt a left Join jcifarmerverification b on a.F_REG_NO = b.regno left join tbl_states st on a.F_STATE = st.id left join tbl_districts d on F_District = d.id order by a.Mandate_flag desc";
		}	
		else if(roletypes.equalsIgnoreCase("ZO"))
		  { 
			  querystr = "Select  a.*, b.verficationid, b.regno, b.ifsccode, b.accountno, b.farmername, b.address, b.status, b.verificationdate, st.state_name, d.district_name from jcirmt a left Join jcifarmerverification b on a.F_REG_NO = b.regno left join tbl_states st on a.F_STATE = st.id left join tbl_districts d on F_District = d.id left join [jcipurchasecenter] e on a.dpc_id = e.CENTER_CODE left join [jcirodetails] f on e.rocode = f.rocode where f.zonecode ='"+zone+"' order by a.Mandate_flag desc"; 
		  } 
		else if(roletypes.equalsIgnoreCase("RO")) 
		  { 
			  querystr = "Select  a.*, b.verficationid, b.regno, b.ifsccode, b.accountno, b.farmername, b.address, b.status, b.verificationdate, st.state_name, d.district_name from jcirmt a left Join jcifarmerverification b on a.F_REG_NO = b.regno left join tbl_states st on a.F_STATE = st.id left join tbl_districts d on F_District = d.id left join [jcipurchasecenter] e on a.dpc_id = e.CENTER_CODE where e.rocode='" +region+"' and a.IS_VERIFIED = 0 order by a.Mandate_flag desc";
		  }
		else {
		 querystr = "Select  a.*, b.verficationid, b.regno, b.ifsccode, b.accountno, b.farmername, b.address, b.status, b.verificationdate, st.state_name, d.district_name from jcirmt a left Join jcifarmerverification b on a.F_REG_NO = b.regno left join tbl_states st on a.F_STATE = st.id left join tbl_districts d on F_District = d.id where a.dpc_id='"+dpcid+"' order by a.Mandate_flag desc";
			
		}
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		SQLQuery query = session.createSQLQuery(querystr);
		List<Object[]> rows = query.list();
		FarmerRegModel farmerReg = new FarmerRegModel();
		List<FarmerRegModelDTO> ll = new ArrayList<>();
		for(Object[] row: rows) {
			int F_ID = (int) row[0];
			String farmerName = (String) row[1];
			String address = (String) row[2];
			String mobile = (String)row[3];
			String branch = (String)row[4];
			String accountNumber = (String)row[12];
			String bankMandateForm = (String)row[13];
			String BankDoc= (String)row[14];
			String status = null;
			//System.err.println("check the row"+row[36]);
			byte mandate = (Byte)row[36];
			int mandateflag = mandate;
			String vRegNo = (String)row[38];
			String vIFSC = (String) row[39];
			String REGno = (String)row[19];
			String RegBy = (String)row[6];
			String state = (String)row[45];
			String district = (String)row[46];
			String block = (String)row[26];
			int isVerified =0;
			if (row[15] !=null) {
				isVerified = (int) row[15];
				//System.out.println("isVerified=================  "+isVerified);
			}
			
			/*
			 * //int a= Integer.parseInt(districtid); String querystr1 =
			 * " select state_name from tbl_states where id ="+stateid; Session session1 =
			 * sessionFactory.getCurrentSession(); Transaction tx1 =
			 * session1.beginTransaction(); SQLQuery query1 =
			 * session1.createSQLQuery(querystr1); Object state= query1.list(); String
			 * state_name= state.toString();
			 * System.out.println("state_name=====================>>>>>>>>>>>  "+state_name)
			 * ;
			 * 
			 * String querystr2 =
			 * " select district_name from tbl_districts where id="+districtid; Session
			 * session2 = sessionFactory.getCurrentSession(); Transaction tx2 =
			 * session1.beginTransaction(); SQLQuery query2 =
			 * session1.createSQLQuery(querystr2); Object district= query2.list(); String
			 * district_name= district.toString();
			 * System.out.println("district_name=====================>>>>>>>>>>>  "
			 * +district_name);
			 */
			FarmerRegModelDTO farmersDetailsDTO = new FarmerRegModelDTO();
			farmersDetailsDTO.setF_NAME(farmerName);
			farmersDetailsDTO.setF_ID(F_ID);
			farmersDetailsDTO.setAddress(address);
			farmersDetailsDTO.setF_MOBILE(mobile);
			farmersDetailsDTO.setF_BANK_BRANCH(branch);
			farmersDetailsDTO.setF_AC_NO(accountNumber);
			farmersDetailsDTO.setRegno(REGno);
			farmersDetailsDTO.setF_REG_BY(RegBy);
			farmersDetailsDTO.setF_BANK_DOC(BankDoc);
			farmersDetailsDTO.setIS_VERIFIED(isVerified);
			farmersDetailsDTO.setF_DOC_Mandate(bankMandateForm);
			farmersDetailsDTO.setState(state);
			
			farmersDetailsDTO.setDistrict(district);
			farmersDetailsDTO.setBlock(block);
			farmersDetailsDTO.setMandate_flag(mandateflag);
			ll.add(farmersDetailsDTO);
		}
		 return ll;
	}

	@Override
	public boolean updateVerificationStatus(int id) {
		Session session = sessionFactory.getCurrentSession();
		boolean returnStatus=false;
		try {
			Query q=session.createQuery("update FarmerRegModel set IS_VERIFIED=1 where F_ID=:m");
			//Query q=session.createQuery("update FarmerRegModel set IS_VERIFIED=1, F_VERFIED_DATE=SYSDATETIME() where F_ID=:m");
			q.setParameter("m",id);
			int status=q.executeUpdate();
			if(status==1) {
				returnStatus =true;
				return returnStatus;
			} else {
				returnStatus =false;
				return returnStatus;
			}
		}catch(Exception e){
			System.out.println(e.getStackTrace());
		}
		return returnStatus;
	}

	@Override
	public boolean validateAccount(String accountNo) {
		List<Integer> result = new ArrayList<>();
		//System.out.println(accountNo);
		String querystr = "select * from jcirmt where F_AC_NO ='"+accountNo+"'";
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		SQLQuery query = session.createSQLQuery(querystr);
		List<Object[]> rows = query.list();
		boolean accMatched = rows.isEmpty();		// returns true if no account found in db
		if(accMatched) {
			return true;
		}else {
			return false;
		}
	}

	@Override
	public boolean validateAdhar(String aadharNo) {
		List<Integer> result = new ArrayList<>();
		String querystr = "select * from jcirmt where F_ID_PROF_No ='"+aadharNo+"'";
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		SQLQuery query = session.createSQLQuery(querystr);
		List<Object[]> rows = query.list();
		//System.out.println("you are in DAO layer");
		boolean adhrMatched = rows.isEmpty();		// returns true if no aadhar number is found in db
		if(adhrMatched) {
			return true;
		}else {
			return false;
		}
	}

	@Override
	public String findRegno(String dpcid, String region) { 
		
		String querystr = "select max(F_REG_NO) from jcirmt where F_REG_NO like '"+region+dpcid+"%'";
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		SQLQuery query = session.createSQLQuery(querystr);
	 
		List<Object[]> rows = query.list();
		//System.out.println("rows = "+rows.toString()+rows.size());
		Object row = rows.get(0);
		 
		if(row!=null) {
		//System.out.println("row = "+row.toString());
	 
		return row.toString(); }
		else {
			return null;
		}
	}

	@Override
    public List<FarmerRegModel> findDetails(int id) {
          List<FarmerRegModel> list = new ArrayList<FarmerRegModel>();
          String querystr = "select a.* ,b.state_name, c.district_name, d.police_station as police_name from jcirmt a   join tbl_states b on a.F_STATE = b.id join tbl_districts c on a.F_District = c.id join tbl_policeStation d on a.police_station = d.id   where F_ID = '"+id+"'";
          Session session = sessionFactory.getCurrentSession();
          Transaction tx = session.beginTransaction();
          SQLQuery query = session.createSQLQuery(querystr);
          List<Object[]> rows = query.list();
    //     System.out.println("rows.size ==  "+ rows.size());
          for(Object[] r : rows)
          { 
                 FarmerRegModel farmerRegModel = new FarmerRegModel();
                 farmerRegModel.setF_ID((int)r[0]);
                 farmerRegModel.setF_NAME((String)r[1]);
                 farmerRegModel.setF_ADDRESS((String)r[2]);
                 farmerRegModel.setF_MOBILE((String)r[3]);
                 farmerRegModel.setF_ID_PROF((String)r[4]);
                 farmerRegModel.setF_ID_PROF_NO((String)r[5]);
                 farmerRegModel.setF_REG_BY((String)r[6]);
                 farmerRegModel.setF_I_CARE_REGISTERED((String)r[7]);
                 farmerRegModel.setLand_holding((String)r[8]);
                 farmerRegModel.setF_BANK_NAME((String)r[9]);
                 farmerRegModel.setF_BANK_BRANCH((String)r[10]);
                 farmerRegModel.setF_BANK_IFSC((String)r[11]);
                 farmerRegModel.setF_AC_NO((String)r[12]);
                 farmerRegModel.setF_DOC_Mandate((String)r[13]);
                 farmerRegModel.setF_BANK_DOC((String)r[14]);
                 farmerRegModel.setIS_VERIFIED((int)r[15]);
                 farmerRegModel.setF_REG_NO((String)r[19]);
                 farmerRegModel.setBank_ac_type((String)r[20]);
                 farmerRegModel.setF_ID_PROF_TYPE((String)r[21]);
                 farmerRegModel.setCaste((String)r[22]);
                 farmerRegModel.setF_District(r[24].toString());
                 farmerRegModel.setState_name((String)r[37]);
                 farmerRegModel.setDistrict_name((String)r[38]);
                 farmerRegModel.setF_Pincode((String)r[25]);
                 farmerRegModel.setF_Block((String)r[26]);
                 farmerRegModel.setGender((String)r[27]);
                 farmerRegModel.setF_REG_FORM((String)r[28]);
                 farmerRegModel.setPolice_station((String)r[39]);
                 farmerRegModel.setF_DOC_PATH((String)r[31]);
                 farmerRegModel.setDpc_id((String)r[35]);
                 list.add(farmerRegModel);
          }
          return list;
    }


	@Override
    public String getFarmerNo(int id) {
          // TODO Auto-generated method stub
          String regNo ="";
          String querystr = "  select F_REG_NO from jcirmt where F_ID = '"+id+"'";
          Session session = sessionFactory.getCurrentSession();
          Transaction tx = session.beginTransaction();
          SQLQuery query = session.createSQLQuery(querystr);
          regNo = (String)query.uniqueResult();
         // System.out.println("regNo " + regNo);
          return regNo;
    }

	@Override
	public List<FarmerRegModelDTO> findByDpc(String dpc) {
		List<Integer> result = new ArrayList<>();
		String querystr = "";

		
			querystr = "Select  a.*, b.verficationid, b.regno, b.ifsccode, b.accountno, b.farmername, b.address, b.status, b.verificationdate, st.state_name, d.district_name from jcirmt a left Join jcifarmerverification b on a.F_REG_NO = b.regno left join tbl_states st on a.F_STATE = st.id left join tbl_districts d on F_District = d.id where a.dpc_id ='"+dpc+"' order by a.Mandate_flag desc";
					
	
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		SQLQuery query = session.createSQLQuery(querystr);
		List<Object[]> rows = query.list();
		FarmerRegModel farmerReg = new FarmerRegModel();
		List<FarmerRegModelDTO> ll = new ArrayList<>();
		for(Object[] row: rows) {
			int F_ID = (int) row[0];
			String farmerName = (String) row[1];
			String address = (String) row[2];
			String mobile = (String)row[3];
			String branch = (String)row[4];
			String accountNumber = (String)row[12];
			String bankMandateForm = (String)row[13];
			String BankDoc= (String)row[14];
			String status = null;
			String vRegNo = (String)row[38];
			String vIFSC = (String) row[39];
			String REGno = (String)row[19];
			String RegBy = (String)row[6];
			String state = (String)row[45];
			String district = (String)row[46];
			String block = (String)row[26];
			int isVerified =0;
			if (row[15] !=null) {
				isVerified = (int) row[15];
			}
			FarmerRegModelDTO farmersDetailsDTO = new FarmerRegModelDTO();
			farmersDetailsDTO.setF_NAME(farmerName);
			farmersDetailsDTO.setF_ID(F_ID);
			farmersDetailsDTO.setAddress(address);
			farmersDetailsDTO.setF_MOBILE(mobile);
			farmersDetailsDTO.setF_BANK_BRANCH(branch);
			farmersDetailsDTO.setF_AC_NO(accountNumber);
			farmersDetailsDTO.setRegno(REGno);
			farmersDetailsDTO.setF_REG_BY(RegBy);
			farmersDetailsDTO.setF_BANK_DOC(BankDoc);
			farmersDetailsDTO.setIS_VERIFIED(isVerified);
			farmersDetailsDTO.setF_DOC_Mandate(bankMandateForm);
			farmersDetailsDTO.setState(state);
			
			farmersDetailsDTO.setDistrict(district);
			farmersDetailsDTO.setBlock(block);
			ll.add(farmersDetailsDTO);
		}
		 return ll;
	}

	
	
}