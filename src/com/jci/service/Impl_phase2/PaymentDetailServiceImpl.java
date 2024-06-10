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
	public void update1(String cont_no,int paymentId,String remark) {
    	 this.paymentDetailsdao.update1(cont_no,paymentId,remark);
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
	@Override
	public List<Object> getsumofInstrumentValue(String instValue) {
	
		return this.paymentDetailsdao.getsumofInstrumentValue(instValue);
	}
	@Override
	public void remark(String remark,String  con_No,int id) {
		paymentDetailsdao.remark(remark,con_No,id);
		
	}
	
	@Override
	public List<Object[]>PreviousNo(String st) {
		
		return  paymentDetailsdao.PreviousNo(st);
	}
	@Override
	public List<Object> PreviousInstruValue(String st) {

		return  paymentDetailsdao.PreviousInstruValue(st);
	
	}
	@Override
	public List<Object[]> Millname() {
		return paymentDetailsdao.Millname();
	}
	@Override
	public List<Object[]> millnamecontractvise(String st) {
	
		return  paymentDetailsdao.millnamecontractvise(st);
	}
	@Override
	public List<Object[]> contractlistfetchdata(String st) {
		return  paymentDetailsdao.contractlistfetchdata(st);
	}
	@Override
	public void deleteEntry(int id) {
		paymentDetailsdao.deleteEntry(id);
		
	}
	@Override
	public List<Object[]> difrencecandsum(String st) {
		
		return paymentDetailsdao.difrencecandsum(st);
	}
	

}
