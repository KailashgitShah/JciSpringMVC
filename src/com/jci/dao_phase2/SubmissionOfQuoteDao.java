package com.jci.dao_phase2;

import java.util.List;

import com.jci.model.BidCreation;
import com.jci.model.SubmissionOfQuoteModel;

public interface SubmissionOfQuoteDao {
	public void create(SubmissionOfQuoteModel submissionOfQuoteModel);
	 public List<SubmissionOfQuoteModel> getAll();
	 public List<BidCreation> getbidlist();
	 public List<Object[]> creationlist(String lotid);
	 public List<Object[]> listdata();
	 public List<Object[]> freightCalculation(String lotid);
	 public List<Object[]> exgodowndeliverytype(String lotid);
	 public int bidrollout_No();
	 public String getmillname(String st);
	 public String sellprice(String st);
	 public String bidrank();
}
