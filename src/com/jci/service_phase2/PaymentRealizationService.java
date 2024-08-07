package com.jci.service_phase2;

import java.util.List;

import com.jci.model.uploadPaymentRealisationModel;

public interface PaymentRealizationService {

	public void create(uploadPaymentRealisationModel uploadPaymentRealisation);

	public List<uploadPaymentRealisationModel> getAll();

	public List<Object[]> fetchMill_Name();

	public List<Object[]> contractForMill(String millname);

	public List<Object[]> TransactionForContract(String contractNo);

	public void update(String contractNo);

	public List<String> cropYear();
}
