package com.jci.service.Impl_phase2;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jci.dao_phase2.GenrationDemandNoteDao;
import com.jci.model.GenrationDEmandDto;
import com.jci.model.GenrationDemandNoteModel;
import com.jci.service_phase2.GenratedDemandNoteService;


@Service
public class GenrationDemandNoteSeviceImpl  implements GenratedDemandNoteService{
	
	@Autowired
	GenrationDemandNoteDao GenrationdemandNoteDao;

	@Override
	public void create(GenrationDemandNoteModel genrationDemandNoteModel) {
		// TODO Auto-generated method stub
		GenrationdemandNoteDao.create(genrationDemandNoteModel);
	}
	@Override
    public List<GenrationDemandNoteModel> getAll() {
        // Implement the method to fetch payment instruments from the DAO
        return GenrationdemandNoteDao.getAll();
    }
	@Override
	public void update(GenrationDemandNoteModel genrationDemandNoteModel) {
		GenrationdemandNoteDao.update(genrationDemandNoteModel);
	}

	@Override
	public GenrationDemandNoteModel edit(int id) {
		return GenrationdemandNoteDao.edit(id);
	}
	

	
	
	@Override
    public GenrationDemandNoteModel getPaymentInstrumentById(int id) {
        return GenrationdemandNoteDao.getById(id);
    }

    @Override
    public void updatePaymentInstrument(GenrationDemandNoteModel genrationDemandNoteModel) {
    	GenrationdemandNoteDao.update(genrationDemandNoteModel);
    }
    @Override
	public   GenrationDemandNoteModel find(int id) {
		return GenrationdemandNoteDao.find(id);
	}
	@Override
	public List<Object[]> fetchContract_no(String st) {
		// TODO Auto-generated method stub
		return GenrationdemandNoteDao.fetchContract_no(st);
	}
	 @Override
		public List<Object> fetchcon_no() {
	    	return GenrationdemandNoteDao.fetchcon_no();
		}
	@Override
	public String demandnono(String st) {
		
		return GenrationdemandNoteDao.demandnono(st);
	}
	@Override
	public String count() {
		// TODO Auto-generated method stub
		return GenrationdemandNoteDao.count();
	}
	
   
    
}
