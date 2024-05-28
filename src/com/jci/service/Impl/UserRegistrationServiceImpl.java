package com.jci.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jci.dao.UserRegistrationDao;
import com.jci.model.UserRegistrationModel;
import com.jci.service.UserRegistrationService;

@Service
public class UserRegistrationServiceImpl implements UserRegistrationService{

	@Autowired
	UserRegistrationDao userRegistrationDao;

	@Override
	public void create(UserRegistrationModel userRegistration) {
		userRegistrationDao.create(userRegistration);
	}

	@Override
	public void update(UserRegistrationModel userRegistration) {
		userRegistrationDao.update(userRegistration);
	}

	@Override
	public UserRegistrationModel edit(int id) {
		return userRegistrationDao.edit(id);
	}

	@Override
	public void delete(int id) {
		userRegistrationDao.delete(id);
	}

	@Override
	public UserRegistrationModel find(int id) {
		return userRegistrationDao.find(id);
	}

	@Override
	public List<UserRegistrationModel> getAll( String dpcId, String regionId, String zoneId) {
		return userRegistrationDao.getAll(dpcId, regionId, zoneId);
	}

	@Override
	public boolean submitform(UserRegistrationModel userRegistration) {
		return userRegistrationDao.submitform(userRegistration);
	}

	@Override
	public String checkLogin(String usrname, String password) {
		return userRegistrationDao.loginCheck(usrname, password);
	}

	@Override
	public boolean validateEmail(String Email) {
		return userRegistrationDao.validateEmail(Email);
	}

	@Override
	public String getUserId(int refid) {
		return userRegistrationDao.getUserId(refid);
	}

	@Override
	public String getUserDpc(int userId) {
		return userRegistrationDao.getUserDpc(userId);
	}

	@Override
	public String getUserRegion(int userId) {
		System.out.println("service impl region method");
		return userRegistrationDao.getUserRegion(userId);
	}

	@Override
	public String getdpc_center(String dpcIdd) {
		return userRegistrationDao.getdpc_center(dpcIdd);
	}
	
	@Override
	public int getRefId(String emailId) {
		// TODO Auto-generated method stub
		return userRegistrationDao.getRefId(emailId);
	}
	
	@Override
	public int getUserRoleId(int userId) {
		// TODO Auto-generated method stub
		return userRegistrationDao.getUserRoleId(userId);
	}
	
	@Override
	public UserRegistrationModel getuserprofile(int refid) {
		// TODO Auto-generated method stub
		return userRegistrationDao.getuserprofile(refid);
	}
	@Override
	
	public boolean validateUserMobile(String mobileNo) {
		return userRegistrationDao.validateUserMobile(mobileNo);
	}

	@Override
	public boolean validateEmployeeid(String employeeid) {
		return userRegistrationDao.validateEmployeeid(employeeid);
	
	}
	
	@Override
	public boolean validateusername(String username) {
		// TODO Auto-generated method stub
		return userRegistrationDao.validateusername(username);
	}

	@Override
	public int getis_ho(String usrname) {
		// TODO Auto-generated method stub
	   return userRegistrationDao.getis_ho(usrname);
	}
	
	@Override
	public String getroletypr(String usrname) {
		// TODO Auto-generated method stub
	   return userRegistrationDao.getroletypr(usrname);
	}

	@Override
	public String getregionId(String usrname) {
		// TODO Auto-generated method stub
		return userRegistrationDao.getregionId(usrname);
	}

	@Override
	public String getzoneId(String usrname) {
		// TODO Auto-generated method stub
		return userRegistrationDao.getzoneId(usrname);
	}

	@Override
	public String checkConcurrentlogin(String email) {
		// TODO Auto-generated method stub
		return userRegistrationDao.checkConcurrentlogin(email);
	}

	@Override
	public void updateFlagInDatabase(String flag,String email) {
		// TODO Auto-generated method stub
		userRegistrationDao.updateFlagInDatabase(flag,email);
	}

	@Override
	public void updateConcurrentlogin(String email,String set) {
		// TODO Auto-generated method stub
		userRegistrationDao.updateConcurrentlogin(email,set);

	}

	@Override
	public String getName(String username) {
		// TODO Auto-generated method stub
		return userRegistrationDao.getName(username);
	}

	
}
