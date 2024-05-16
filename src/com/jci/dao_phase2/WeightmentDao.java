package com.jci.dao_phase2;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.jci.model.jciWeighmentEntry;

public interface WeightmentDao {
	List<Object[]> WeightmentSlipList(String ro_id);
	 Date getcreationdate(int id);

	 String getDpc_wt_doc(int id);

	 String getRo_id(int id);

	String getMill_bos_copy(int id);

	 String getMill_wt_doc(int id);

	 jciWeighmentEntry ListOFWeightmentSlipById(int weighment_id);
	List<Object[]> SlipDetails(String id);
	void editDetails(Double gross, Double actual, Double net, Date currDate, String bosNo);
}
