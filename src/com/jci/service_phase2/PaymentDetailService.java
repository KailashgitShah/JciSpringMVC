package com.jci.service_phase2;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.jci.model.EntryPaymentDetailsModel;
//import com.jci.model.MillRecieptModel;
@Service
public interface PaymentDetailService {
	public void create(EntryPaymentDetailsModel entryPaymentDetailsModel);
	 public List<EntryPaymentDetailsModel>getAllPaymentInstruments();
	 public void update(EntryPaymentDetailsModel EntryPaymentDetailsModel);
	 public void updatestatus(EntryPaymentDetailsModel EntryPaymentDetailsModel);
		public EntryPaymentDetailsModel edit(int id);
		EntryPaymentDetailsModel getPaymentInstrumentById(int id);
		 public  void updatePaymentInstrument(EntryPaymentDetailsModel EntryPaymentDetailsModel);
		public EntryPaymentDetailsModel find(int id);
		public void update1(String cont_no,int paymentId,String remark);
		public void update2(String cont_no);
		public void deleteEntry(int id);
		
		public List<EntryPaymentDetailsModel> getAllPaymentInstrumentsentry();
		public List<Object>ContractNo();
		public List<Object[]>Millname();
		public List<Object>getsumofInstrumentValue(String continstValue);
		public void contratTable(String cont_no);
		  public  List<Object[]>paymentdetails(String  st);
		  public  List<Object[]>gradewiseqty(String  st,String contractqty);
		  public  List<Object[]>PreviousNo(String  st);
		
		  public  List<Object[]>contractlistfetchdata(String  st);
		  public  List<Object[]>difrencecandsum(String  st);
		  public  List<Object[]>millnamecontractvise(String  st);
		  public  List<Object>PreviousInstruValue(String  st);
		  
		  public void remark(String cont_no,String  con_No,int id);
		public void deleteupdate(String contract2, int payid);
}
