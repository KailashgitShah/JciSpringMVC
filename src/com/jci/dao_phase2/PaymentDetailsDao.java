package com.jci.dao_phase2;

import java.util.List;

import com.jci.model.EntryPaymentDetailsModel;

public interface PaymentDetailsDao {
	public void create(EntryPaymentDetailsModel entryPaymentDetailsModel);
	 public List<EntryPaymentDetailsModel> getAllPaymentInstruments();
	 public List<EntryPaymentDetailsModel> getAllPaymentInstrumentsentry();
	 public void update(EntryPaymentDetailsModel entryPaymentDetailsModel);
	 public void updatestatus(EntryPaymentDetailsModel entryPaymentDetailsModel);
		public EntryPaymentDetailsModel edit(int id);
		   EntryPaymentDetailsModel getById(int id);
	 
		public EntryPaymentDetailsModel find(int id);
		public void update1(String cont_no);
		public void update2(String cont_no);
		public void contratTable(String cont_no);
		public List<Object> ContractNo();
		  public  List<Object[]>paymentdetails(String  st);
		  public  List<Object[]>gradewiseqty(String st,String contractqty);
}
