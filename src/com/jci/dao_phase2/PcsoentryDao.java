package com.jci.dao_phase2;

import java.util.List;

import com.jci.model.EntryofpcsoModel;
import com.jci.model.PcsoDateModel;

public interface PcsoentryDao {

	void create(EntryofpcsoModel entryofpcso);

	List<Object[]> getAlldata();

	List<String> getAllDates();


	List<EntryofpcsoModel> getAllPcso();

	public void delete(int id);

	EntryofpcsoModel getPcso(int refid);

	public void update(EntryofpcsoModel entryodpcso, int refid);

	List<String> getAllRequest();

	Object loadAllDetailsOfLetter(String refNo);

	List<String> getAllLables();

	List<String> getUniqueRefNos();

	List<EntryofpcsoModel> getAllMillDetailsOfRefNo(String refNo);

	int getCountOfTotalEntries();

	List<String> getMillCodeForPcoDate(String pcoDate);
}
