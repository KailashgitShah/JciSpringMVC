package com.jci.dao_phase2;

import java.util.List;

import com.jci.model.MillRecieptModel;
import com.jci.model.MillreceiptDto;

public interface MillReceiptDao {
	public void create(MillRecieptModel millRecieptModel);
	 public List<MillRecieptModel> getAllPaymentInstruments();
  
	 public void update(MillRecieptModel millRecieptModel);
		public MillRecieptModel edit(int id);
		MillRecieptModel getById(int id);
	 
		public MillRecieptModel find(int id);
		public void delete(int id);
		public List<Object> fetchHODINO(String millname);
	
		public  List<Object[]> fetchdata(String st);
		public  List<Object[]> challanbaseddetails(String st);
		public  List<Object[]> childdata(String st);
		public  List<Object> fetchMill_NameR();
		
		public void UpdateContractstatus( String s);
		public MillRecieptModel Creditqty(String st);
		public boolean  findmillreceiptNOlist(String st);
		
}
