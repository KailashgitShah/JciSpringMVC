package com.jci.service_phase2;

import java.math.BigInteger;
import java.util.List;

import org.springframework.stereotype.Service;


import com.jci.model.FinancialConcurenceModel;

@Service
public interface FinancialConcurenceService {
	public void create(FinancialConcurenceModel financialConcurenceModel);
	 public List<FinancialConcurenceModel>getAllPaymentInstruments();
//	 public void update(FinancialConcurenceModel financialConcurenceModel);
//		public FinancialConcurenceModel edit(int id);
//	
//		FinancialConcurenceModel getPaymentInstrumentById(int id);
//		 public  void updatePaymentInstrument(FinancialConcurenceModel financialConcurenceModel);
		public FinancialConcurenceModel find(int id);
	 public int calculateCharges(int  id, String contno);
	 public void remark(String cont_no,String  con_No,int paymentId);
	 public String ContractedQty(String cont_no);
	 public String fcref_nocheck();
	 public List<Object> dataofdates(String Con_no,int Payment_id);
	 
	 public int  paymentid(String cont_no);
	
}

