package com.jci.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "jcimill_Registration", schema = "dbo")
public class MillRegistrationModel {
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name = "MillRegistration_id")
	    private Long MillRegistration_id ;
	 
	   @Column(name = "mill_name") 
	   private String mill_name;
	   
		@Column(name="mill_password")
		private String mill_password;
		
		@Column(name="confirm_mill_password")
		private String confirm_mill_password;
		@Column(name="mill_code")
		private String mill_code;
		
		@Column(name="mill_emailaddress")
		private String mill_emailaddress;
		

		@Column(name="mill_mobile")
		private String mill_mobile;
        
		@Column(name="official_name")
		private String official_name;
		
		@Column(name="official_designation")
		private String official_designation;
		
		public Long getMillRegistration_id() {
			return MillRegistration_id;
		}

		public void setMillRegistration_id(Long millRegistration_id) {
			MillRegistration_id = millRegistration_id;
		}

		public String getMill_name() {
			return mill_name;
		}

		public void setMill_name(String mill_name) {
			this.mill_name = mill_name;
		}

		public String getMill_password() {
			return mill_password;
		}

		public void setMill_password(String mill_password) {
			this.mill_password = mill_password;
		}

		public String getMill_code() {
			return mill_code;
		}

		public void setMill_code(String mill_code) {
			this.mill_code = mill_code;
		}

		public String getMill_emailaddress() {
			return mill_emailaddress;
		}

		public void setMill_emailaddress(String mill_emailaddress) {
			this.mill_emailaddress = mill_emailaddress;
		}

	
		public String getMill_mobile() {
			return mill_mobile;
		}

		public void setMill_mobile(String mill_mobile) {
			this.mill_mobile = mill_mobile;
		}

		
		

		public String getOfficial_name() {
			return official_name;
		}

		public void setOfficial_name(String official_name) {
			this.official_name = official_name;
		}

		public String getOfficial_designation() {
			return official_designation;
		}

		public void setOfficial_designation(String official_designation) {
			this.official_designation = official_designation;
		}
        
		
		public String getConfirm_mill_password() {
			return confirm_mill_password;
		}

		public void setConfirm_mill_password(String confirm_mill_password) {
			this.confirm_mill_password = confirm_mill_password;
		}

		public MillRegistrationModel() {
			super();
		}

		public MillRegistrationModel(Long millRegistration_id, String mill_name, String mill_password,
				String confirm_mill_password, String mill_code, String mill_emailaddress, String mill_mobile,
				String official_name, String official_designation) {
			super();
			MillRegistration_id = millRegistration_id;
			this.mill_name = mill_name;
			this.mill_password = mill_password;
			this.confirm_mill_password = confirm_mill_password;
			this.mill_code = mill_code;
			this.mill_emailaddress = mill_emailaddress;
			this.mill_mobile = mill_mobile;
			this.official_name = official_name;
			this.official_designation = official_designation;
		}

		@Override
		public String toString() {
			return "MillRegistrationModel [MillRegistration_id=" + MillRegistration_id + ", mill_name=" + mill_name
					+ ", mill_password=" + mill_password + ", confirm_mill_password=" + confirm_mill_password
					+ ", mill_code=" + mill_code + ", mill_emailaddress=" + mill_emailaddress + ", mill_mobile="
					+ mill_mobile + ", official_name=" + official_name + ", official_designation="
					+ official_designation + "]";
		}

		
	
		
	 

}
