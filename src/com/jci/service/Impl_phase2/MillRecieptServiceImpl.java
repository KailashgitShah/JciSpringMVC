package com.jci.service.Impl_phase2;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jci.dao_phase2.MillReceiptDao;
import com.jci.model.MillRecieptModel;
import com.jci.model.MillreceiptDto;
import com.jci.service_phase2.MillRecieptService;
@Service
public class MillRecieptServiceImpl implements  MillRecieptService {
	@Autowired
	MillReceiptDao millRecieptDao;

	@Override
	public void create(MillRecieptModel millRecieptModel) {
		// TODO Auto-generated method stub
		millRecieptDao.create(millRecieptModel);
	}
	@Override
    public List<MillRecieptModel> getAllPaymentInstruments() {
        // Implement the method to fetch payment instruments from the DAO
        return millRecieptDao.getAllPaymentInstruments();
    }
	@Override
	public void update(MillRecieptModel millRecieptModel) {
		millRecieptDao.update(millRecieptModel);
	}

	@Override
	public MillRecieptModel edit(int id) {
		return millRecieptDao.edit(id);
	}
	

	
	
	@Override
    public MillRecieptModel getPaymentInstrumentById(int id) {
        return millRecieptDao.getById(id);
    }

    @Override
    public void updatePaymentInstrument(MillRecieptModel millRecieptModel) {
    	millRecieptDao.update(millRecieptModel);
    }
    @Override
	public   MillRecieptModel find(int id) {
		return millRecieptDao.find(id);
	}
    @Override
	public void delete(int id) {
    	millRecieptDao.delete(id);
	}

    
	 @Override
		public List<Object> fetchHODINO(String millname) {
	    	return millRecieptDao.fetchHODINO(millname);
		}
	
	@Override
	public void UpdateContractstatus( String  s) {
		 this.millRecieptDao.UpdateContractstatus(s);
	}
	 @Override
		public  MillRecieptModel Creditqty( String st) {
	    	return millRecieptDao.Creditqty(st);
		}
	@Override
	public List<Object[]> fetchdata(String st) {
		
		return millRecieptDao.fetchdata(st);
	}
	@Override
	public List<Object[]> fetchMill_NameR() {
		return millRecieptDao.fetchMill_NameR();
	}
	@Override
	public boolean findmillreceiptNOlist(String s) {
	
		return millRecieptDao.findmillreceiptNOlist(s);
	}
	@Override
	public List<Object[]> childdata(String st) {
		return millRecieptDao.childdata(st);
	}
	@Override
	public List<Object[]> challanbaseddetails(String st) {
		
		return millRecieptDao.challanbaseddetails(st);
	}
	@Override
	public List<Object[]> gradeprice(String st,String st1,String st2,String st3) {
		
		return millRecieptDao.gradeprice(st,st1,st2,st3);
	}
	
	
}
