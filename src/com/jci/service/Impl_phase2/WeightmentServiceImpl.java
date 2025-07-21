package com.jci.service.Impl_phase2;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itextpdf.text.pdf.PdfStructTreeController.returnType;
import com.jci.dao_phase2.WeightmentDao;
import com.jci.model.jciWeighmentEntry;
import com.jci.service_phase2.WeighmentEntryService;
@Service
public class WeightmentServiceImpl implements WeighmentEntryService{
	
	@Autowired
	WeightmentDao weightmentDao;

	@Override
	public List<Object[]> WeightmentSlipList(String ro_id) {
		// TODO Auto-generated method stub
		
		return weightmentDao.WeightmentSlipList(ro_id);
	}

	@Override
	public Date getcreationdate(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getDpc_wt_doc(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getRo_id(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getMill_bos_copy(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getMill_wt_doc(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public jciWeighmentEntry ListOFWeightmentSlipById(int weighment_id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Object[]> getSlipDetails(String id) {
		// TODO Auto-generated method stub
		return weightmentDao.SlipDetails(id);
	}

	@Override
	public void editVerification(Double gross, Double actual, Double net, Date currDate, String bosNo) {
		// TODO Auto-generated method stub
		weightmentDao.editDetails(gross,actual,net,currDate,bosNo);
	}

	@Override
	public List<Object[]> getAllPendingWeightmentSlip(String ro_id) {
		return weightmentDao.getAllPendingWeightmentSlip(ro_id);
	}

}
