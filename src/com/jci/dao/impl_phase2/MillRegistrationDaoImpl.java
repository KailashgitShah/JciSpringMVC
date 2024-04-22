package com.jci.dao.impl_phase2;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.servlet.http.HttpServletRequest;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.jci.dao_phase2.MillRegistrationDao;
import com.jci.model.JciEntryTdsModel;
import com.jci.model.MillRegistrationModel;
import com.jci.model.UserRegistrationModel;
import com.jci.service.Impl_phase2.EmailSender;
@Transactional
@Repository
public class MillRegistrationDaoImpl implements MillRegistrationDao {
	@Autowired
	private HttpServletRequest request;

	@Autowired
	SessionFactory sessionFactory;

	protected Session currentSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public List<String> MillName() {
		String q = "SELECT DISTINCT unit_name FROM jcimilldetailchild";
		List r = (List) this.sessionFactory.getCurrentSession().createSQLQuery(q).list();
		return r;
		
	}

	@Override
	public List<Object> FetchMillReceiptData(String millid) {
		String q = "SELECT DISTINCT client_unit_code FROM jcimilldetailchild  WHERE jcimilldetailchild.unit_name = '" + millid + "'";

		List<Object> ContractListData = (List<Object>) this.sessionFactory.getCurrentSession().createSQLQuery(q).list();
		//System.out.println(ContractListData);

		return ContractListData;
	}

	@Override
	public void create(MillRegistrationModel millsave) {
		currentSession().save(millsave);

		// TODO Auto-generated method stub
		
	}

	@Override
	public List<MillRegistrationModel> getAll() {
		// TODO Auto-generated method stub
		Criteria c = this.sessionFactory.getCurrentSession().createCriteria(MillRegistrationModel.class);
		List<MillRegistrationModel> ll = c.list();
		return ll;
	}

	@Override
	public String loginCheck(String userName, String password) {
		// TODO Auto-generated method stub
		//jcimill_Registration
		List<Integer> result = new ArrayList<>();
		String querystr = "select * from jcimill_Registration where mill_emailaddress ='" + userName + "' and mill_password ='" + password + "'";
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		SQLQuery query = session.createSQLQuery(querystr);
		List<Object[]> rows = query.list();
		 if (rows.isEmpty()) {
		        return null; // No matching user found
		    } else {
		      
		        Object[] firstRow = rows.get(0);
		        return firstRow.toString(); // Return the desired value
		    }
		
	}

	@Override
	public String checkmillcode(String email) {
	
			String querystr = "select mill_code from jcimill_Registration where mill_emailaddress ='" + email + "'";
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
	public String checkmillemail(String email) {

		String querystr = "select mill_emailaddress  from jcimill_Registration where mill_emailaddress ='" + email + "'";
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
	public boolean validatemillEmail(String Email) {
		String querystr = "select * from jcimill_Registration where mill_emailaddress ='" + Email + "'";
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
	public MillRegistrationModel getmillRegistrationProfile(int MillRegistrationId) {
		List<MillRegistrationModel> result = new ArrayList<>();
		String querystr ="Select mill_password , mill_emailaddress  , mill_name , confirm_mill_password  , mill_code  , official_name , official_designation , mill_mobile  from jcimill_Registration where MillRegistration_id ='" + MillRegistrationId + "'";		
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		SQLQuery query = session.createSQLQuery(querystr);
		List<Object[]> rows = query.list();
	int	 id = MillRegistrationId;
	
		MillRegistrationModel millRegistration = new MillRegistrationModel();
		   for (Object[] row : rows) {
			String mill_password = (String) row[0];
			String mill_emailaddress =(String) row[1];
			String mill_name = (String)row[2];
			String confirm_mill_password  = (String)row[3];
			String mill_code = (String)row[4];
			String official_name  = (String)row[5];
			String official_designation = (String)row[6];
			String mill_mobile = (String)row[7];
			//int MillRegistration_id =(int)row[8];
			 millRegistration.setMill_password(mill_password);
			 millRegistration.setConfirm_mill_password(confirm_mill_password);
			 millRegistration.setMillRegistration_id(id);
			 

		}
		 return millRegistration;
	}

	@Override
	public void ResetPassword(int MillRegistrationId) {
	    String new_mill_password = generatePassword();
	    String confirm_mill_password = new_mill_password;
	   
	    try {
	        String hql = "update jcimill_Registration set mill_password = '" + new_mill_password + "', confirm_mill_password = '" + confirm_mill_password + "'  where MillRegistration_id = " + MillRegistrationId;
	        String emailQuery = "SELECT mill_emailaddress FROM jcimill_Registration WHERE MillRegistration_id = " + MillRegistrationId;
	        Query emailQuery1 = this.sessionFactory.getCurrentSession().createSQLQuery(emailQuery);
	        String millemail = (String) emailQuery1.uniqueResult();
            this.sessionFactory.getCurrentSession().createSQLQuery(hql).executeUpdate();
	        System.out.println("Success");
	        EmailSender email = new EmailSender();
			InternetAddress[] toAddresses = null;
			String subject = "your new password !!";
			String username1 ="";
					String body = "Dear Mill ,\n " + "Hope This email finds you well ,\n"
							+ "We are pleased to inform you that your password has been successfully reset .\n"+ " This is Your New Password for Mill Login: \n " + new_mill_password + "\n " + 
							
							 "Thanks & Regards \n " + "Jute Corporation Of India";
			try {
				//toAddresses = new InternetAddress[]{new InternetAddress(millemail) };
				toAddresses = new InternetAddress[] { new InternetAddress(millemail)
				};
			} catch (AddressException e) {
				e.printStackTrace();
			}
			email.sendEmailMill(toAddresses, body, subject, username1);
	    } catch (Exception e) {
	        System.out.println(e.getLocalizedMessage());
	    }
	}
	
	private String generatePassword() {
	    // Define criteria for the password
	    int minLength = 8;
	    String uppercaseChars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	    String lowercaseChars = "abcdefghijklmnopqrstuvwxyz";
	    String numericChars = "0123456789";
	    String specialChars = "!@#$%^&*+";

	    // Generate the password
	    StringBuilder password = new StringBuilder();
	    Random random = new Random();
	    boolean hasUppercase = false;
	    boolean hasLowercase = false;
	    boolean hasNumeric = false;
	    boolean hasSpecial = false;

	    while (password.length() < minLength || !hasUppercase || !hasLowercase || !hasNumeric || !hasSpecial) {
	        password.setLength(0); // Clear the password
	        hasUppercase = false;
	        hasLowercase = false;
	        hasNumeric = false;
	        hasSpecial = false;

	        for (int i = 0; i < minLength; i++) {
	            int type = random.nextInt(4); // Randomly choose character type
	            switch (type) {
	                case 0:
	                    password.append(uppercaseChars.charAt(random.nextInt(uppercaseChars.length())));
	                    hasUppercase = true;
	                    break;
	                case 1:
	                    password.append(lowercaseChars.charAt(random.nextInt(lowercaseChars.length())));
	                    hasLowercase = true;
	                    break;
	                case 2:
	                    password.append(numericChars.charAt(random.nextInt(numericChars.length())));
	                    hasNumeric = true;
	                    break;
	                case 3:
	                    password.append(specialChars.charAt(random.nextInt(specialChars.length())));
	                    hasSpecial = true;
	                    break;
	            }
	        }
	    }

	    return password.toString();
	}
	
	
	

	
	
	

}
