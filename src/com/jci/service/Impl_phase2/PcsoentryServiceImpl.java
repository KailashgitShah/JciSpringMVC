package com.jci.service.Impl_phase2;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itextpdf.text.pdf.PdfStructTreeController.returnType;
import com.jci.dao_phase2.PcsoentryDao;
import com.jci.model.EntryofpcsoModel;
import com.jci.model.PcsoDateModel;
import com.jci.service_phase2.PcsoentryService;

@Service
public class PcsoentryServiceImpl implements PcsoentryService {
	
	@Autowired
	PcsoentryDao pcsoentrydao;

	public void create(EntryofpcsoModel entryofpcso) {
		// TODO Auto-generated method stub
		pcsoentrydao.create(entryofpcso);
		
	}

	public List<Object[]> getAlldata() {
		// TODO Auto-generated method stub
			return pcsoentrydao.getAlldata();
	}
	public List<EntryofpcsoModel> getAllPcso() {
		// TODO Auto-generated method stub
		return pcsoentrydao.getAllPcso();
	}

	@Override
	public List<String> getAllDates() {
		// TODO Auto-generated method stub
		return pcsoentrydao.getAllDates();
	}

	
	@Override
	public void delete(int id) {
		this.pcsoentrydao.delete(id);
	}
	
	@Override
	public EntryofpcsoModel getPcso(int refid) {
		// TODO Auto-generated method stub
		return pcsoentrydao.getPcso(refid);
	}
	
	@Override
	public void update(EntryofpcsoModel entryofpcso, int refid) {
		
		pcsoentrydao.update(entryofpcso, refid);
	}

	@Override
	public List<String> getAllRequest() {
		
		return this.pcsoentrydao.getAllRequest();
	}

	@Override
	public Object loadAllDetailsOfLetter(String refNo) {
		// TODO Auto-generated method stub
		return this.pcsoentrydao.loadAllDetailsOfLetter(refNo);
	}

	@Override
	public List<String> getAllLables() {
		return this.pcsoentrydao.getAllLables();
	}

	@Override
	public List<String> getUniqueRefNos() {
		return this.pcsoentrydao.getUniqueRefNos();
	}

	@Override
	public List<EntryofpcsoModel> getAllMillDetailsOfRefNo(String refNo) {
	return this.pcsoentrydao.getAllMillDetailsOfRefNo(refNo);
	}

	@Override
	public int getCountOfTotalEntries() {
		return this.pcsoentrydao.getCountOfTotalEntries();
	}

	@Override
	public List<String> getMillCodeForPcoDate(String pcoDate) {
		return this.pcsoentrydao.getMillCodeForPcoDate(pcoDate);
	}


}
