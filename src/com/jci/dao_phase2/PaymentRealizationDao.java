package com.jci.dao_phase2;

import java.util.List;

import com.jci.model.uploadPaymentRealisationModel;

public interface PaymentRealizationDao {
 	public void create(uploadPaymentRealisationModel uploadPaymentRealisation);

	public List<uploadPaymentRealisationModel> getAll();

}
