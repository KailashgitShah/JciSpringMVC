package com.jci.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.jfree.util.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.jci.dao.UserRegistrationDao;
import com.jci.model.ConcurrentLoginModel;
import com.jci.model.UserRegistrationModel;

@Transactional
@Repository
public class UserRegistrationDaoImpl implements UserRegistrationDao {

	@Autowired
	private HttpServletRequest request;

	@Autowired
	SessionFactory sessionFactory;

	protected Session currentSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public void create(UserRegistrationModel userRegistration) {
		currentSession().save(userRegistration);
	}

	@Override
	public void update(UserRegistrationModel userRegistration) {
		currentSession().update(userRegistration);
	}

	@Override
	public UserRegistrationModel edit(int id) {
		return find(id);
	}

	@Override
	public void delete(int id) {
		UserRegistrationModel farmerRegistrationModel = new UserRegistrationModel();
		String hql = "Delete from jciumt where refid = '" + id + "' ";
		this.sessionFactory.getCurrentSession().createSQLQuery(hql).executeUpdate();
	}

	@Override
	public UserRegistrationModel find(int id) {
		return (UserRegistrationModel) currentSession().get(UserRegistrationModel.class, id);
	}

	/*
	 * @Override public List<UserRegistrationModel> getAll() { Criteria c =
	 * this.sessionFactory.getCurrentSession().createCriteria(UserRegistrationModel.
	 * class); List<UserRegistrationModel> ll=c.list(); return ll; }
	 */

	@Override
	public List<UserRegistrationModel> getAll(String dpcId, String regionId, String zoneId) {
		List<UserRegistrationModel> result = new ArrayList<>();
		HttpSession session1 = request.getSession(false);
		String querystr = "";
		String roletypes = (String) session1.getAttribute("roletype");
		
		if(roletypes.equalsIgnoreCase("HO"))
		{
			querystr = "Select a.username, a.employeeid, a.email, a.employeename, a.mobileno, b.centername, c.roname, d.zonename, a.refid,  a.roles_name, a.usertype , a.ho from jciumt a left Join jcipurchasecenter b on a.dpcId = b.CENTER_CODE left join jcirodetails c on a.regionId = c.rocode left join jcizones d on a.zoneId=d.zonecode left join jciuserrole e on e.role_Id = a.role";
		}
		else if(roletypes.equalsIgnoreCase("ZO"))
		  { 
			  querystr = "Select a.username, a.employeeid, a.email, a.employeename, a.mobileno, b.centername, c.roname, d.zonename, a.refid,  a.roles_name, a.usertype , a.ho from jciumt a left Join jcipurchasecenter b on a.dpcId = b.CENTER_CODE left join jcirodetails c on a.regionId = c.rocode left join jcizones d on a.zoneId=d.zonecode left join jciuserrole e on e.role_Id = a.role where a.zoneId ='"+zoneId+"'"; 
		  } 
		else if(roletypes.equalsIgnoreCase("RO")) 
		  { 
			  querystr = "Select a.username, a.employeeid, a.email, a.employeename, a.mobileno, b.centername, c.roname, d.zonename, a.refid,  a.roles_name, a.usertype , a.ho from jciumt a left Join jcipurchasecenter b on a.dpcId = b.CENTER_CODE left join jcirodetails c on a.regionId = c.rocode left join jcizones d on a.zoneId=d.zonecode left join jciuserrole e on e.role_Id = a.role where a.regionId ='" +regionId+"'"; 
		  }
		 
		else {
			querystr = "Select a.username, a.employeeid, a.email, a.employeename, a.mobileno, b.centername, c.roname, d.zonename, a.refid,  a.roles_name, a.usertype , a.ho from jciumt a left Join jcipurchasecenter b on a.dpcId = b.CENTER_CODE left join jcirodetails c on a.regionId = c.rocode left join jcizones d on a.zoneId=d.zonecode left join jciuserrole e on e.role_Id = a.role where a.dpcId ='"+dpcId+"'";
		}

		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		SQLQuery query = session.createSQLQuery(querystr);
		List<Object[]> rows = query.list();
		// System.out.println(rows);

		for (Object[] row : rows) {
			UserRegistrationModel userRegistration = new UserRegistrationModel();
			String username = (String) row[0];
			String employeeid = (String) row[1];
			String email = (String) row[2];
			String employeename = (String) row[3];
			String mobileno = (String) row[4];
			String centername = (String) row[5];
			String roname = (String) row[6];
			String zonename = (String) row[7];
			int id = (int) row[8];
			String rolename = (String) row[9];
			String usertype = (String) row[10];
			int ho = (int) row[11];
			// System.out.println("zonessssss"+ zonename);
			userRegistration.setRefid(id);
			;
			userRegistration.setUsername(username);
			userRegistration.setEmployeeid(employeeid);
			userRegistration.setEmail(email);
			userRegistration.setEmployeename(employeename);
			userRegistration.setMobileno(mobileno);
			userRegistration.setCentername(centername);
			userRegistration.setRoname(roname);
			userRegistration.setZonename(zonename);
			userRegistration.setRoles_name(rolename);
			userRegistration.setUsertype(usertype);
			userRegistration.setHo(ho);
			result.add(userRegistration);
		}
		return result;
	}

	@Override
	public boolean submitform(UserRegistrationModel userRegistration) {
		this.sessionFactory.getCurrentSession().save(userRegistration);
		return false;
	}

	@Override
	public String loginCheck(String userName, String password) {
		List<Integer> result = new ArrayList<>();
		String querystr = "select * from jciumt where email ='" + userName + "' and password ='" + password + "'";
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		SQLQuery query = session.createSQLQuery(querystr);
		List<Object[]> rows = query.list();

		boolean isPresent = rows.isEmpty();
		if (isPresent) {
			return null;
		}

		else if (rows.get(0)[16].toString().equalsIgnoreCase("Mobile User")) {
			return "mobile";
		}

		else {
			return rows.get(0)[13].toString();
		}

	}

	@Override
	public boolean validateEmail(String Email) {
		String querystr = "select * from jciumt where email ='" + Email + "'";
		Session session = sessionFactory.getCurrentSession();
		SQLQuery query = session.createSQLQuery(querystr);
		List<Object[]> rows = query.list();
		boolean isPresent = rows.isEmpty();
		if (isPresent) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public String getUserId(int refid) {
		String userrole = "";
		String querystr = "select roles_name from jciumt where refid ='" + refid + "'";
		Session session = sessionFactory.getCurrentSession();
		SQLQuery query = session.createSQLQuery(querystr);
		List<String> userList = query.list();
		// System.out.println("userList==== "+userList);
		userrole = userList.get(0);
		return userrole;
	}

	@Override
	public String getUserDpc(int userId) {
		String querystr = "select dpcId from jciumt where refid ='" + userId + "'";
		Session session = sessionFactory.getCurrentSession();
		SQLQuery query = session.createSQLQuery(querystr);
		List<String> userList = query.list();
		if (userList.size() > 1) {
			Log.info("One user can't have two dpc id");
			return "0";
		} else if (userList.size() == 1) {
			String userIdString = userList.get(0);
			return userIdString;
		} else {
			Log.info("no user exist with such id");
			return "0";
		}
	}

	@Override
	public String getUserRegion(int userId) {
		// String querystr = "select regionId from jciumt where username ='"+userId+"'";
		// Session session = sessionFactory.getCurrentSession();

		String querystr = "select regionId from jciumt where refid ='" + userId + "'";
		Session session = sessionFactory.getCurrentSession();
		SQLQuery query = session.createSQLQuery(querystr);
		List<String> userList = query.list();
		if (userList.size() > 1) {
			Log.info("One user can't have two dpc id");
			return "0";
		} else if (userList.size() == 1) {
			String userIdString = userList.get(0);
			return userIdString;
		} else {
			Log.info("no user exist with such id");
			return "0";
		}
	}

	@Override
	public int getUserRoleId(int userId) {
		// String querystr = "select regionId from jciumt where username ='"+userId+"'";
		// Session session = sessionFactory.getCurrentSession();

		String querystr = "select roleId from jciumt where refid ='" + userId + "'";
		Session session = sessionFactory.getCurrentSession();
		SQLQuery query = session.createSQLQuery(querystr);
		List<Integer> userList = query.list();
	//	System.out.println(userList);
		int roleId = userList.get(0);
		return roleId;

	}

	@Override
	public UserRegistrationModel getuserprofile(int refid) {
		List<UserRegistrationModel> result = new ArrayList<>();
		String querystr = "  Select a.username, a.employeeid, a.email, a.employeename, a.mobileno, b.centername, c.roname, d.zonename, a.refid,  a.roles_name , a.usertype, a.roleId, a.role_type, a.zoneId, c.rocode, a.dpcId, a.password from jciumt a left Join jcipurchasecenter b on a.dpcId = b.CENTER_CODE left join jcirodetails c on a.regionId = c.rocode left join jcizones d on a.zoneId=d.zonecode left join jciuserrole e on e.role_Id = a.role where a.refid='"
				+ refid + "'";
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		SQLQuery query = session.createSQLQuery(querystr);
		List<Object[]> rows = query.list();
		// UserRegistrationModel ll = new UserRegistrationModel();
		UserRegistrationModel userRegistration = new UserRegistrationModel();
		for (Object[] row : rows) {
			String username = (String) row[0];
			String employeeid = (String) row[1];
			String email = (String) row[2];
			String employeename = (String) row[3];
			String mobileno = (String) row[4];
			String centername = (String) row[5];
			String roname = (String) row[6];
			String zonename = (String) row[7];
			int id = (int) row[8];
			String rolename = (String) row[9];
			String userType = (String)  row[10];
			int roleId = (int) row[11];
			String roleType = (String) row [12];
			String zoneId = (String) row[13];
			String rocode = (String) row[14];
			String dpcid = (String) row[15];
			String password = (String) row[16];
 			userRegistration.setRefid(id);
			userRegistration.setUsername(username);
			userRegistration.setEmployeeid(employeeid);
			userRegistration.setEmail(email);
			userRegistration.setEmployeename(employeename);
			userRegistration.setMobileno(mobileno);
			userRegistration.setCentername(centername);
			userRegistration.setRoname(roname);
			userRegistration.setZonename(zonename);
			userRegistration.setRoles_name(rolename);
			userRegistration.setUsertype(userType);
			userRegistration.setRoleId(roleId);
			userRegistration.setRole_type(roleType);
			userRegistration.setRegion(rocode);
			userRegistration.setZone(zoneId);
			userRegistration.setDpcId(dpcid);
			userRegistration.setPassword(password);
		}

		return userRegistration;

	}


	@Override
	public String getdpc_center(String dpcIdd) {
		String querystr = "select centername FROM jcipurchasecenter where CENTER_CODE='" + dpcIdd + "'";
		Session session = sessionFactory.getCurrentSession();
		SQLQuery query = session.createSQLQuery(querystr);
		String dpc_center = query.list().toString();
		dpc_center = dpc_center.replace("[", "");
		dpc_center = dpc_center.replace("]", "");

		// System.out.println("dpccenter==============>>>>>>>>>>>>>>>>>> "+dpc_center);
		return dpc_center;
	}

	@Override
	public int getRefId(String email) {
		// String querystr = "select dpcId from jciumt where refid ='"+userId+"'";
		String querystr = "select refid from jciumt where email='" + email + "'";
		Session session = sessionFactory.getCurrentSession();
		SQLQuery query = session.createSQLQuery(querystr);
		List<Integer> userList = query.list();
		// System.out.println("refid===>>>>> "+userList);
		if (!userList.isEmpty()) {
			return userList.get(0);
			// return "0";
		} else {
			return 0;
		}
	}

	@Override
	public boolean validateUserMobile(String mobileNo) {
		List<Integer> result = new ArrayList<>();
		String querystr = "select * from jciumt where mobileno ='" + mobileNo + "'";
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		SQLQuery query = session.createSQLQuery(querystr);
		List<Object[]> rows = query.list();
		boolean isPresent = rows.isEmpty();
		if (isPresent) {
			return true;
		} else {
			return false;
		}

	}

	@Override
	public boolean validateEmployeeid(String employeeid) {
		List<Integer> result = new ArrayList<>();
		String querystr = "select * from jciumt where employeeid ='" + employeeid + "'";
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		SQLQuery query = session.createSQLQuery(querystr);
		List<Object[]> rows = query.list();
		boolean isPresent = rows.isEmpty();
		if (isPresent) {
			return true;
		} else {
			return false;
		}

	}

	@Override
	public boolean validateusername(String username) {
		List<String> result = new ArrayList<>();
		String querystr = "select * from jciumt where email ='" + username + "'";
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		SQLQuery query = session.createSQLQuery(querystr);
		List<Object[]> rows = query.list();
		boolean isPresent = rows.isEmpty();
		if (isPresent) {
			return true;
		} else {
			return false;
		}

	}

	@Override
	public int getis_ho(String usrname) {
		String querystr = "select ho from jciumt where email='" + usrname + "'";
		Session session = sessionFactory.getCurrentSession();
		SQLQuery query = session.createSQLQuery(querystr);
		List<Integer> userList = query.list();
		// System.out.println("refid===>>>>> "+userList);
		if (!userList.isEmpty()) {
			return userList.get(0);
			// return "0";
		} else {
			return 3;
		}
	}

	@Override
	public String getroletypr(String usrname) {
		String querystr = "select role_type from jciumt where email='" + usrname + "'";
		Session session = sessionFactory.getCurrentSession();
		SQLQuery query = session.createSQLQuery(querystr);
		List<String> userList = query.list();

		if (!userList.isEmpty()) {
			return userList.get(0);
			// return "0";
		} else {
			return "0";
		}
	}

	@Override
	public String getregionId(String usrname) {
		String querystr = "select regionId from jciumt where email='" + usrname + "'";
		Session session = sessionFactory.getCurrentSession();
		SQLQuery query = session.createSQLQuery(querystr);
		List<String> userList = query.list();

		if (!userList.isEmpty()) {
			return userList.get(0);
			// return "0";
		} else {
			return "0";
		}
	}

	@Override
	public String getzoneId(String usrname) {
		String querystr = "select zoneId from jciumt where email='" + usrname + "'";
		Session session = sessionFactory.getCurrentSession();
		SQLQuery query = session.createSQLQuery(querystr);
		List<String> userList = query.list();

		if (!userList.isEmpty()) {
			return userList.get(0);
			// return "0";
		} else {
			return "0";
		}
	}

	@Override
	public String getoldpassword(int id) {
		String querystr = "select password from jciumt where refid='" + id + "'";
		Session session = sessionFactory.getCurrentSession();
		SQLQuery query = session.createSQLQuery(querystr);
		String password = (String)query.uniqueResult();

			return password;
	}

	@Override
	public String checkConcurrentlogin(String email) {
		// TODO Auto-generated method stub
		String querystr = "select password from jciumt where email='" + email + "'";
		Session session = sessionFactory.getCurrentSession();
		SQLQuery query = session.createSQLQuery(querystr);
		String password = (String)query.uniqueResult();
		System.err.println("flag"+password);
		return password;
	}

	@Override
	public void updateFlagInDatabase(String flag,String email) {
		// TODO Auto-generated method stub
		try {
			System.out.println("repo"+flag+""+email);
			String hql = "update checkConcurrentlogin set flag = 'logout' where email ='"+email+"'";
			this.sessionFactory.getCurrentSession().createSQLQuery(hql).executeUpdate();
			
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
		}
	}

	@Override
	public void updateConcurrentlogin(String email,String set) {
		// TODO Auto-generated method stub
		 try {
			 String hql = "";
			 if(set.equals("0"))
			 {
					 hql = "update jciumt set lockedchances = '0' where email ='"+email+"'";
			 }
			 else 
			 {
					 hql = "update jciumt set lockedchances = '1' where email ='"+email+"'";
			 }
				this.sessionFactory.getCurrentSession().createSQLQuery(hql).executeUpdate();
			} catch (Exception e) {
				System.out.println(e.getLocalizedMessage());
			}
	}

	@Override
	public String getName(String username) {
		String name = "";
		String querystr = "select username from jciumt where email ='" + username + "'";
		Session session = sessionFactory.getCurrentSession();
		SQLQuery query = session.createSQLQuery(querystr);
		List<String> userList = query.list();
		// System.out.println("userList==== "+userList);
		name = userList.get(0);
		return name;
	}
}
