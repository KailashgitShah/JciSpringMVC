package com.jci.service.Impl_phase2;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jci.dao_phase2.PaymentDetailsDao;
import com.jci.model.EntryPaymentDetailsModel;
import com.jci.service_phase2.PaymentDetailService;
@Service
public class PaymentDetailServiceImpl implements PaymentDetailService {
	@Autowired
    PaymentDetailsDao paymentDetailsdao;

	@Override
	public void create(EntryPaymentDetailsModel paymentDetailServiceImpl) {
		// TODO Auto-generated method stub
		paymentDetailsdao.create(paymentDetailServiceImpl);
	}
	@Override
    public List<EntryPaymentDetailsModel> getAllPaymentInstruments() {
        // Implement the method to fetch payment instruments from the DAO
        return paymentDetailsdao.getAllPaymentInstruments();
    }
	@Override
    public List<EntryPaymentDetailsModel> getAllPaymentInstrumentsentry() {
        // Implement the method to fetch payment instruments from the DAO
        return paymentDetailsdao.getAllPaymentInstrumentsentry();
    }
	@Override
	public void update(EntryPaymentDetailsModel EntryPaymentDetailsModel) {
		paymentDetailsdao.update(EntryPaymentDetailsModel);
	}
	@Override
	public void updatestatus(EntryPaymentDetailsModel EntryPaymentDetailsModel) {
		paymentDetailsdao.update(EntryPaymentDetailsModel);
	}

	@Override
	public EntryPaymentDetailsModel edit(int id) {
		return paymentDetailsdao.edit(id);
	}

	
	
	@Override
    public EntryPaymentDetailsModel getPaymentInstrumentById(int id) {
        return paymentDetailsdao.getById(id);
    }

    @Override
    public void updatePaymentInstrument(EntryPaymentDetailsModel EntryPaymentDetailsModel) {
    	paymentDetailsdao.update(EntryPaymentDetailsModel);
    }
    @Override
	public   EntryPaymentDetailsModel find(int id) {
		return paymentDetailsdao.find(id);
	}
    @Override
	public void update1(String cont_no) {
    	 this.paymentDetailsdao.update1(cont_no);
	}
    @Override
	public void update2(String cont_no) {
    	 this.paymentDetailsdao.update2(cont_no);
	}
    
    
	@Override
	public List<Object> ContractNo() {
		// TODO Auto-generated method stub
		return paymentDetailsdao.ContractNo();
	}
	@Override
	public void contratTable(String cont_no) {
		// TODO Auto-generated method stub
		this.paymentDetailsdao.contratTable(cont_no);
	}
	@Override
	public List<Object[]>paymentdetails(String st) {
		
		return paymentDetailsdao.paymentdetails(st);
	}
	@Override
	public List<Object[]>gradewiseqty(String st,String contractqty) {
		
		return  paymentDetailsdao.gradewiseqty(st,contractqty);
	}
	
//	@Override
//	public  List<Object[]> paymentdetails(String st) {
//		return paymentDetailsdao.paymentdetails(st);
//	}
}
