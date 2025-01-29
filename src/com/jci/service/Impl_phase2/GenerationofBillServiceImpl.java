package com.jci.service.Impl_phase2;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.jci.dao_phase2.GenerationofBillDao;
import com.jci.model.GenerationOfBillSupplyModel;

import com.jci.service_phase2.GenerationofBillService;


@Service
public class GenerationofBillServiceImpl implements GenerationofBillService {

	
	
	@Autowired
	GenerationofBillDao generationofBillDao;


	@Override
	public void create(GenerationOfBillSupplyModel generationOfBillSupplyModel) {
	
		generationofBillDao.create(generationOfBillSupplyModel);
		
	}

	
	
	@Override
	public List<GenerationOfBillSupplyModel> getAll() {
		
		 return generationofBillDao.getAll();
	}

	@Override
	public List<Object[]>ChallanNo(String st) {
		return generationofBillDao.ChallanNo(st);
	}

//	
	@Override
	public  List<Object[]> contarctno( String st) {
		return generationofBillDao.contarctno(st);
	}

	@Override
	public  List<Object[]> Dispatchentry( String st) {
		return generationofBillDao.Dispatchentry(st);
	}

	@Override
	public String billofsupplyno() {
		
		return generationofBillDao.billofsupplyno();
	}

	@Override
	public List<Object[]>contarctnoformaster(String st) {
		
		return generationofBillDao.contarctnoformaster(st);
	}



	@Override
	public  String billUpdation(String st) {
	
		return generationofBillDao.billUpdation(st);
		
	}

	@Override
	public void remark(String remark,String  con_No) {
		
		generationofBillDao.remark(remark,con_No);
		
	}



	@Override
	public GenerationOfBillSupplyModel find(int id) {
		
		return generationofBillDao.find(id);
	}



	@Override
	public List<Object[]> contrcatnotomill(String st) {
		
		return generationofBillDao.contrcatnotomill(st);
	}



	@Override
	public boolean millnamefromTCS(String millname) {
	
		return  generationofBillDao.millnamefromTCS(millname);
	}

	@Override
	public boolean challanduplicate(String challanno) {
	
		return  generationofBillDao.challanduplicate(challanno);
	}


	@Override
	public List<Object[]> ShipmentDetails(String st) {
		
		return generationofBillDao.ShipmentDetails(st);
	}



	@Override
	public List<Object[]> dispatchChildlist(String st) {
		
		return generationofBillDao.dispatchChildlist(st);
	}



	@Override
	public List<Object[]> GenrationAginstLCs(String st) {
	
		return generationofBillDao.GenrationAginstLCs(st);
	}



	@Override
	public List<Object[]> DocumentLcsEntry(String st) {
		
		return generationofBillDao.DocumentLcsEntry(st);
	}



	@Override
	public List<Object[]> Supplieradd(String st) {
		
		return generationofBillDao.Supplieradd(st);
	}



	@Override
	public List<Object[]> PANSTATE(String st) {
		
		return  generationofBillDao.PANSTATE(st);
	}



	@Override
	public String statecode(String st) {
	
		return generationofBillDao.statecode(st);
	}



	@Override
	public String statecount(String St) {
		
		return generationofBillDao.statecount(St);
	}



	@Override
	public List<Object[]> ForDate(String st) {
	
		return  generationofBillDao.ForDate(st);
	}



	@Override
	public List<Object[]> Dpcname(String st,String st1) {
	
		return  generationofBillDao.Dpcname(st,st1);
	}



	@Override
	public List<Object[]> RegionAndCenterName(String st) {
		
		return generationofBillDao.RegionAndCenterName(st);
	}



	@Override
	public Double sumofInvoicevalue(String st) {
		return generationofBillDao.sumofInvoicevalue(st);
	}


	


}
