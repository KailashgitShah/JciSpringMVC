package com.jci.service_phase2;

import java.util.List;

import org.springframework.stereotype.Service;

import com.jci.model.GenrationDEmandDto;
import com.jci.model.GenrationDemandNoteModel;
import com.jci.model.MillRecieptModel;

@Service
public interface GenratedDemandNoteService {
	public void create(GenrationDemandNoteModel GenrationDemandNoteModel);
	 public List<GenrationDemandNoteModel>getAll();
	 public void update(GenrationDemandNoteModel genrationDemandNoteModel);
		public GenrationDemandNoteModel edit(int id);
		GenrationDemandNoteModel getPaymentInstrumentById(int id);
		 public  void updatePaymentInstrument(GenrationDemandNoteModel genrationDemandNoteModel);
		public GenrationDemandNoteModel find(int id);
		public List<Object[]> fetchContract_no(String st);
		public List<Object> fetchcon_no();
		public String demandnono(String  st);
		public String count();
		public List<Object[]> getData(String contract_No);
		public List<Object[]> DemandNoteData(String demand_note_no);
		public List<Object[]> DetailsDebit(String demand_note_no);
		public void updateStatus(String contract_No);
		

}
