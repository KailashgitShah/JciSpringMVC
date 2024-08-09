package com.jci.service_phase2;
import java.util.List;

public interface BidsubmissionService {
	public List<Object[]> getbidref();
	public List <Object[]> getbidSubission(String bidId);
	public List <Object[]> bidresult(String bidId);
	public List <Object[]> biddatareport(String bidId);
	public List <Object[]> contrcatswap(String bidId);
	public List <Object[]> creationlist(String lotid);
	public List <Object[]> bid_data_result(String lotid);
	public String millcode(String bidid);
	public boolean getbidupdate(List <Object[]> bidId);
	public boolean bidDelete(String bidId,String mill,String price);
	public String getemailforMill(String mill);
	

}
