package com.jci.service_phase2;

import java.util.List;

import org.springframework.stereotype.Service;


import com.jci.model.ConfirmationClaimSettlementModel;

@Service
public interface ConfirmationofClaimSettlementService {
	public void create(ConfirmationClaimSettlementModel confirmationClaimSettlementModel);
	 public List<ConfirmationClaimSettlementModel>getAll();
	  public  List<Object> SettlementId();
	  public List<Object[]> fetchdataofclaim(String st);
	  public List<Object[]> fetchdatasttlement(int st);
	  public  List<Object[]> gradecfetchingdata1omposition(String st);
	public List<String> fetchContract(String settlementId);
}
