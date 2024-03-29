package com.jci.model;

import java.math.BigInteger;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class DispatchDetailsModelDto {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "DientryDto_id")
	private BigInteger DientryDto_id ;

	private String Challan_no;
	
	private Date Consignment_note;

	private String Contract_No;

	private Date Contract_date;

	private String Creation_date;

	private String DI_Date;

	private String DI_No;

	private Date Date_of_shipment;

	private String Di_status;

	private String Driver_contact;

	
	private String Driver_name;

	private String License_no;


	private String Mill_name;

	
	private String Mode_of_shipment;

	private String Place_of_Shipment;

	private Integer Regional_Office;


	private String Vehicle_no;

	private String Bale_mark;

	private String Crop_year;

	private Double Jute_grade;

	private Double Jute_value;

	
	private Double Jute_variety;


	private Double No_of_bales;

	
	private Double Nominal_qty;

	
	private Date Nominal_wt;
	

	private Double Rate;
	
	
}
