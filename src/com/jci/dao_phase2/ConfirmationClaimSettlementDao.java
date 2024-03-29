package com.jci.dao_phase2;

import java.util.List;

import com.jci.model.ConfirmationClaimSettlementModel;

public interface ConfirmationClaimSettlementDao {
	 public void create(ConfirmationClaimSettlementModel confirmationClaimSettlementModel);
	 public List<ConfirmationClaimSettlementModel>getAll();
	 public  List<Object> SettlementId();
	 public List<Object[]> fetchdataofclaim(String st);
	 public List<Object[]> fetchdatasttlement(int st);
	 public  List<Object[]> gradecfetchingdata1omposition(String st);
}
