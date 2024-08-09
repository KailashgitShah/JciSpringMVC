
package com.jci.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "jci_commercial_factors", schema = "dbo")
public class FactorssInvolvedCommercial {

	@Id
	@Column(name="factor_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int factor_id;
	
	@Column(name = "Identification_no")
	private String Identification_no;

	@Column(name="factor_head")
	private String factor_head;

	@Column(name="unit")
	private String unit;
	
	@Column(name = "applicability")
	private String applicability;

	@Column(name="status")
	private int status;

	@Column(name="created_by")
	private String created_by;
	
	@Column(name="Created_on")
	private Date Created_on;

	public int getFactor_id() {
		return factor_id;
	}

	public void setFactor_id(int factor_id) {
		this.factor_id = factor_id;
	}

	public String getIdentification_no() {
		return Identification_no;
	}

	public void setIdentification_no(String identification_no) {
		Identification_no = identification_no;
	}

	public String getFactor_head() {
		return factor_head;
	}

	public void setFactor_head(String factor_head) {
		this.factor_head = factor_head;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public String getApplicability() {
		return applicability;
	}

	public void setApplicability(String applicability) {
		this.applicability = applicability;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getCreated_by() {
		return created_by;
	}

	public void setCreated_by(String created_by) {
		this.created_by = created_by;
	}

	public Date getCreated_on() {
		return Created_on;
	}

	public void setCreated_on(Date created_on) {
		Created_on = created_on;
	}

	public FactorssInvolvedCommercial(int factor_id, String identification_no, String factor_head, String unit,
			String applicability, int status, String created_by, Date created_on) {
		super();
		this.factor_id = factor_id;
		Identification_no = identification_no;
		this.factor_head = factor_head;
		this.unit = unit;
		this.applicability = applicability;
		this.status = status;
		this.created_by = created_by;
		Created_on = created_on;
	}

	public FactorssInvolvedCommercial() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "FactorssInvolvedCommercial [factor_id=" + factor_id + ", Identification_no=" + Identification_no
				+ ", factor_head=" + factor_head + ", unit=" + unit + ", applicability=" + applicability + ", status="
				+ status + ", created_by=" + created_by + ", Created_on=" + Created_on + "]";
	}
	
	
	
}

