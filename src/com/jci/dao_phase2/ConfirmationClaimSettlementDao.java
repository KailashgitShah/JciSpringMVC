package com.jci.dao_phase2;

import java.util.List;

import com.jci.model.ConfirmationClaimSettlementModel;

public interface ConfirmationClaimSettlementDao {
	public void create(ConfirmationClaimSettlementModel confirmationClaimSettlementModel);

	public List<ConfirmationClaimSettlementModel> getAll();

	public List<Object[]> SettlementId(String username);

	public List<Object[]> fetchdataofclaim(String st);

	public List<Object[]> fetchdatasttlement(String st);

	public List<Object[]> gradecfetchingdata1omposition(String st);

	public List<String> fetchContract(String settlementId);

	public List<Object[]> fetchChallan(String id);

	public String fetchPrice(String var, String gr, String dpcId, String cropyear, String contract);

	public List<Object[]> getSettlementData(String username);

	public void acceptClaim(String challan, String username, String filename);

	public void rejectClaim(String challan, String username);

	public List<Object[]> getFAData(String setId);
}
