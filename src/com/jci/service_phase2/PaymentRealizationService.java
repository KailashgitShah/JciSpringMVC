package com.jci.service_phase2;

import java.util.List;

import com.jci.model.uploadPaymentRealisationModel;

public interface PaymentRealizationService {

	public void create(uploadPaymentRealisationModel uploadPaymentRealisation);

	public List<uploadPaymentRealisationModel> getAll();
}
