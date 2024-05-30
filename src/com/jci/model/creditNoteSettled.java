package com.jci.model;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "jcicredit_note_settled", schema = "dbo")
public class creditNoteSettled {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "Crn_id", unique = true)
	private int id;
	
	@Column(name = "Credit_note_date")
	private String creditNoteDate;
	
	@Column(name = "Credit_note_no")
	private String creditNoteNo;
	
	@Column(name = "Contract_No")
	private String ContractNo;
	
	@Column(name = "HoDi_No")
	private String hoDiNo;
	

	@Column(name = "Challan_No")
	private String ChallanNo;
	
	
	@Column(name = "Bales")
	private int bales;
	
	
	@Column(name = "Variety_grade")
	private String varityGrade;
	
	@Column(name = "Mr_no")
	private String mrNo;
	
	@Column(name = "Mr_date")
	private String mrDate;
	
	@Column(name = "Moisture_settlement")
	private Double moistureSettlement;

	@Column(name = "Ncv_settlement")
	private Double ncvSettlement;
	
	@Column(name = "Dust_settlement")
	private Double dustSettlement;



	@Column(name = "Settlement_amt")
	private Double settlementAmt;

	
	
	@Column(name = "Credit_note_amt")
	private Double creditNoteAmt;
	
	
	@Column(name = "Ro_id")
	private String roId;


	@Column(name = "Crn_status")
	private int crnStatus;

	@Column(name = "Created_by")
	private String createdBy;
	
	@Column(name = "Creation_date")
	private String creationDate;
	
}
