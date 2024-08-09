package com.jci.dao_phase2;

import java.text.ParseException;
import java.util.List;
public interface BidSubmissionDao {
	public void delete(int id);
	public List<Object[]> getbidref();
	public List <String> getbidHeader(String bidId);
	public List <Object[]> getbidSubission(String bidId);
	public List <Object[]> bidresult(String bidId);
	public List <Object[]> biddatareport(String bidId);
	public List <Object[]> bid_data_result(String bidId);
	public String  millcode(String bidId);
	public List <Object[]> contrcatswap(String bidId);
	public List <Object[]> creationlist(String lotid);
	public boolean getbidupdate(List <Object[]> bidId);
	public boolean bidDelete(String bidId,String mill,String price);
	public String updateBidHeader(List<Object[]> entities);
	public String updateH1BidHeader(Object[] entities);
	public String updateH1BidHeaderNew(int bidId, int sidId);
	public String findH1MillEmail(String millCode);
	public String getemailforMill(String mill);
	
	public String deleteH1Bidder(int id);
	
}
