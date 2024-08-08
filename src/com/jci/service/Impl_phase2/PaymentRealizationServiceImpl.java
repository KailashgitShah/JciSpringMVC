package com.jci.service.Impl_phase2;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jci.dao_phase2.PaymentRealizationDao;
import com.jci.model.uploadPaymentRealisationModel;
import com.jci.service_phase2.PaymentRealizationService;

@Service
public class PaymentRealizationServiceImpl implements PaymentRealizationService {
	
	@Autowired
	PaymentRealizationDao paymentRealizationDao;

	@Override
	public void create(uploadPaymentRealisationModel uploadPaymentRealisation) {
		paymentRealizationDao.create(uploadPaymentRealisation);
		
	}

	@Override
	public List<uploadPaymentRealisationModel> getAll() {
		// TODO Auto-generated method stub
		return paymentRealizationDao.getAll();
	}

	@Override
	public List<Object[]> fetchMill_Name() {
		// TODO Auto-generated method stub
		return paymentRealizationDao.fetchMill_Name();
	}

	@Override
	public List<Object[]> contractForMill(String millname) {
		// TODO Auto-generated method stub
		return paymentRealizationDao.contractForMill(millname);
	}

	@Override
	public List<Object[]> TransactionForContract(String contractNo) {
		// TODO Auto-generated method stub
		return paymentRealizationDao.TransactionForContract(contractNo);
	}

	@Override
	public void update(String contractNo) {
		// TODO Auto-generated method stub
		paymentRealizationDao.update( contractNo);
	}

	@Override
	public List<String> cropYear() {
		// TODO Auto-generated method stub
		return paymentRealizationDao.cropYear();
	}

}
