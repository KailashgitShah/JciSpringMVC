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
		public void update1(String cont_no,int paymentId,String remark);
		public void update2(String cont_no);
		public void deleteEntry(int id);
		public void contratTable(String cont_no);
		public List<Object> ContractNo();
		public List<Object[]> Millname();
		public List<Object> getsumofInstrumentValue(String instValue);
		  public  List<Object[]>paymentdetails(String  st);
		  public  List<Object[]>gradewiseqty(String st,String contractqty);
		  public  List<Object[]>PreviousNo(String st);
		 
		  public  List<Object[]>contractlistfetchdata(String st);
		  public  List<Object[]>difrencecandsum(String st);
		  public  List<Object[]>millnamecontractvise(String st);
		  public  List<Object>PreviousInstruValue(String st);
		  public void remark(String remark,String  con_No,int id);
		public void deleteupdate(String contract2, int payid);
}
