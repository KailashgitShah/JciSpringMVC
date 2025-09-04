package com.jci.service_phase2;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.jci.model.jciWeighmentEntry;

public interface WeighmentEntryService {
	

	/* public ArrayList<WeighmentEntryDto> getWeighmentEntry(); */

	public List<Object[]> WeightmentSlipList(String ro_id);

	public Date getcreationdate(int id);

	public String getDpc_wt_doc(int id);

	public String getRo_id(int id);

	public String getMill_bos_copy(int id);

	public String getMill_wt_doc(int id);

	public jciWeighmentEntry ListOFWeightmentSlipById(int weighment_id);

	public List<Object[]> getSlipDetails(String id);

	public void editVerification(Double gross, Double actual, Double net, Date currDate, String bosNo);

	public List<Object[]> getAllPendingWeightmentSlip(String ro_id);
}
