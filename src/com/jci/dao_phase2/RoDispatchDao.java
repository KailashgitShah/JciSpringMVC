package com.jci.dao_phase2;

import java.util.List;

import com.jci.model.RoDispatchModel;

public interface RoDispatchDao {

	public List<String> loadAllDpc();

	public List<String> loadAllDiNo();

	public List<Object> loadAllContractDetails(String diNo);

	public int getCountOfAvailableEntries(String hoNo);

	public void create(RoDispatchModel roDispatchModel);

	public List<RoDispatchModel> getAllRoDi();

	public List<String> getCooperative(String regionIdString);

	public List<String> getDetails(String hOno);

	public List<String> getprevious(String diNo);

	public void update(String contractNoString);

	public String dpcCheck(String dpc, String hoDIno);
}
