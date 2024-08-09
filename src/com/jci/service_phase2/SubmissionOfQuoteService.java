package com.jci.service_phase2;

import java.util.List;

import org.springframework.stereotype.Service;

import com.jci.model.BidCreation;
import com.jci.model.SubmissionOfQuoteModel;
@Service
public interface SubmissionOfQuoteService {
	public void create(SubmissionOfQuoteModel submissionOfQuoteModel);
	 public List<SubmissionOfQuoteModel>getAll();
	 public List<BidCreation>getbidlist();
	 public List<Object[]>creationlist(String lotid);
	 public List<Object[]>listdata();
	 public List<Object[]>freightCalculation(String lotid);
	 public List<Object[]>exgodowndeliverytype(String lotid);
	//public String fetchBos_No();
	 public int bidrollout_No();
	 public String getmillname(String st);
	 public String sellprice(String st);
	 public String bidrank();
}
