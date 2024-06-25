package com.jci.dao_phase2;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.jci.model.GenrationDEmandDto;
import com.jci.model.GenrationDemandNoteModel;


public interface GenrationDemandNoteDao {

	public void create(GenrationDemandNoteModel genrationDemandNoteModel);
	 public List<GenrationDemandNoteModel> getAll();
 
	 public void update(GenrationDemandNoteModel genrationDemandNoteModel);
		public GenrationDemandNoteModel edit(int id);
		public GenrationDemandNoteModel getById(int id);
	 
		public GenrationDemandNoteModel find(int id);
		public List<Object[]> fetchContract_no(String st);
		public List<Object> fetchcon_no();
		public String demandnono(String  st);
		public String count();
		
		
}
