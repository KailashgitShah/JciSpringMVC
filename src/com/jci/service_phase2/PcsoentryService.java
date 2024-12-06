package com.jci.service_phase2;

import java.util.Date;
import java.util.List;

import com.jci.model.EntryofpcsoModel;
import com.jci.model.PcsoDateModel;

public interface PcsoentryService {
	
	void create(EntryofpcsoModel entryofpcso);

	List<Object[]> getAlldata();

	List<EntryofpcsoModel> getAllPcso();

	List<String> getAllDates();

	void delete(int id);

	public EntryofpcsoModel getPcso(int refid);

	public void update(EntryofpcsoModel entryofpcso, int refid);

	List<String> getAllRequest();

	Object loadAllDetailsOfLetter(String refNo);

	List<String> getAllLables();

	List<String> getUniqueRefNos();

	List<EntryofpcsoModel> getAllMillDetailsOfRefNo(String refNo, String date);



	List<String> getMillCodeForPcoDate(String pcoDate);
}
