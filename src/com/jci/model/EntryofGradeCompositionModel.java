package com.jci.model;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "jcigrade_composition")
public class EntryofGradeCompositionModel {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "grade_id")
	public int id;
	@Column(name = "Jute_combination")
	public String Jute_combination;
	@Column(name = "System_composition")
	public Double System_composition;
	@Column(name = "Proposed_composition")
	public Double Proposed_composition;
	@Column(name = "Crop_year")
	public String Crop_year;

	@Column(name = "Available_qty")
	public double Available_qty;
	@Column(name = "Label_name")
	public String label_name;
	@Column(name = "Created_by")
	public int Created_by;
	@Column(name = "Created_date ")
	public Date created_date;
	
	@Column(name = "Remark " , length = 255)
	public String remark;
	
	@Column(name = "updateDateAndTimeDate ")
	public Date updateDateAndTimeDate;
	
	
	public Date getUpdateDateAndTime() {
		return updateDateAndTimeDate;
	}
	
	public void setUpdateDateAndTime(Date updatedDate) {
		this.updateDateAndTimeDate = updatedDate;
	}
 

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getJute_combination() {
		return Jute_combination;
	}

	public void setJute_combination(String jute_combination) {
		Jute_combination = jute_combination;
	}

	public Double getSystem_composition() {
		return System_composition;
	}

	public void setSystem_composition(Double system_composition) {
		System_composition = system_composition;
	}

	public Double getProposed_composition() {
		return Proposed_composition;
	}

	public void setProposed_composition(Double proposed_composition) {
		Proposed_composition = proposed_composition;
	}

	public String getCrop_year() {
		return Crop_year;
	}

	public void setCrop_year(String crop_year) {
		Crop_year = crop_year;
	}

	public double getAvailable_qty() {
		return Available_qty;
	}

	public void setAvailable_qty(double available_qty) {
		Available_qty = available_qty;
	}

	public String getLabel_name() {
		return label_name;
	}

	public void setLabel_name(String label_name) {
		this.label_name = label_name;
	}

	public int getCreated_by() {
		return Created_by;
	}

	public void setCreated_by(int created_by) {
		Created_by = created_by;
	}

	public Date getCreated_date() {
		return created_date;
	}

	public void setCreated_date(Date created_date) {
		this.created_date = created_date;
	}
	
	
  
	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Date getUpdateDateAndTimeDate() {
		return updateDateAndTimeDate;
	}

	public void setUpdateDateAndTimeDate(Date updateDateAndTimeDate) {
		this.updateDateAndTimeDate = updateDateAndTimeDate;
	}

	@Override
	public String toString() {
		return "EntryofGradeCompositionModel [id=" + id + ", Jute_combination=" + Jute_combination
				+ ", System_composition=" + System_composition + ", Proposed_composition=" + Proposed_composition
				+ ", Crop_year=" + Crop_year + ", Available_qty=" + Available_qty + ", label_name=" + label_name
				+ ", Created_by=" + Created_by + ", created_date=" + created_date  + "]";
	}
}
