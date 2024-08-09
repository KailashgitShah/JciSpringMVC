package com.jci.service.Impl_phase2;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jci.dao_phase2.BidSubmissionDao;
import com.jci.service_phase2.BidsubmissionService;


@Service
public class BidSubmissionServiceImpl implements BidsubmissionService {

	@Autowired
	BidSubmissionDao bidSubmissionDao;
	
	@Override
	public List<Object[]> getbidref() {
		
		return bidSubmissionDao.getbidref();
	}

	@Override
	public List <Object[]> getbidSubission(String bidId){
		return bidSubmissionDao.getbidSubission(bidId);
		
	}

	@Override
	public List<Object[]> bidresult(String bidId) {
		// TODO Auto-generated method stub
		return bidSubmissionDao.bidresult(bidId);
	}
	@Override
	public List<Object[]> contrcatswap(String bidId) {
	
		return bidSubmissionDao.contrcatswap(bidId);
	}
	@Override
	public boolean bidDelete(String bidId,String mill,String price) {
	
		return bidSubmissionDao.bidDelete(bidId,mill,price);
	}
	@Override
	public List<Object[]> creationlist(String lotid) {
	
		return bidSubmissionDao.creationlist(lotid);
	}
	@Override
	public boolean getbidupdate(List<Object[]> bidId) {
		return bidSubmissionDao.getbidupdate(bidId);
	}
	@Override
	public List<Object[]> bid_data_result(String lotid) {
		return bidSubmissionDao.bid_data_result(lotid);
	}
	@Override
	public String millcode(String bidid) {
		return bidSubmissionDao.millcode(bidid);
	}
	
	@Override
    public String getemailforMill(String mill) {
          return bidSubmissionDao.getemailforMill(mill);
    }
	@Override
	public List<Object[]> biddatareport(String bidId) {
		return bidSubmissionDao.biddatareport(bidId);
	}
}



