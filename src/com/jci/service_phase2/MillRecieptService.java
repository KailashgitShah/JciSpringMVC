package com.jci.service_phase2;

import java.util.List;

import org.springframework.stereotype.Service;

import com.jci.model.MillRecieptModel;
import com.jci.model.MillreceiptDto;
@Service
public interface MillRecieptService {
	public void create(MillRecieptModel millRecieptModel);
	 public List<MillRecieptModel>getAllPaymentInstruments();
	 public void update(MillRecieptModel millRecieptModel);
		public MillRecieptModel edit(int id);
		MillRecieptModel getPaymentInstrumentById(int id);
		 public  void updatePaymentInstrument(MillRecieptModel millRecieptModel);
		public MillRecieptModel find(int id);
		public void delete(int id);
		
		
		public List<Object[]> fetchdata(String st);
		public List<Object[]> challanbaseddetails(String st);
		public List<Object[]> childdata(String st);
		public List<Object[]> gradeprice(String st,String st1,String st2,String st3);
		public List<Object[]> fetchMill_NameR();
		
		public MillRecieptModel Creditqty(String contractno);
		public void UpdateContractstatus( String s);
		public boolean  findmillreceiptNOlist( String s);
		List<Object> fetchHODINO(String millname, String contractNo);
		List<Object> fetchAllContractNos(String millname);
		
		
		
		
}
