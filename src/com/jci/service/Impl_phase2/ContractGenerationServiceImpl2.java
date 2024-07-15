package com.jci.service.Impl_phase2;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.itextpdf.text.pdf.PdfStructTreeController.returnType;
import com.jci.dao_phase2.ContractGenerationDao2;
import com.jci.model.Contractgeneration;
import com.jci.service_phase2.ContractGenerationService2;

@Service
public class ContractGenerationServiceImpl2 implements ContractGenerationService2 {

	@Autowired
	ContractGenerationDao2 contractGenerationDao2;
	
	@Override
	public void create(Contractgeneration contract) {

		contractGenerationDao2.create(contract);
	}

	@Override
	public boolean isValidContractIdn(String contractIdn) {
	return contractGenerationDao2.isValidContractIdn(contractIdn);
	}

	@Override
	public ModelAndView pcso_details(List<String> pcso,List<String> gradeComp,String cropyr) {
		return this.contractGenerationDao2.pcso_details(pcso,gradeComp,cropyr);
	}

	@Override
	public List<Object[]> getListOfGradesPriceForExGodown(String cropYear) {
		return contractGenerationDao2.getListOfGradesPriceForExGodown(cropYear);
	}
	@Override
	public List<Object[]> getListOfGradesPriceForMillDelivery(String cropYear) {
		return contractGenerationDao2.getListOfGradesPriceForMillDelivery(cropYear);
	}

	@Override
	public List<Object[]> getListOfGradeComposition(String gradeComp) {
		return contractGenerationDao2.getListOfGradeComposition(gradeComp);
	}

	@Override
	public List<Contractgeneration> getAllContract() {
	return contractGenerationDao2.getAllContract();
	}

	@Override
	public int updateContractedValue(String deliveryType ,String totalQtyOfMill, List<String> gradeArray,String cropyr) {
		return contractGenerationDao2.updateContractedValue(deliveryType,totalQtyOfMill,gradeArray,cropyr);
	}

	@Override
	public List<Contractgeneration> getContractFullDetails(String contractidn , String pcsoDates) {
		return contractGenerationDao2.getContractFullDetails(contractidn,pcsoDates);
	}

	@Override
	public List<Object> getFullAddressByMillName(String millNameString) {
	 return contractGenerationDao2.getFullAddressByMillName(millNameString);
	}

	@Override
	public List<Contractgeneration> getAllUnAuthorizedContract() {
		return contractGenerationDao2.getAllUnAuthorizedContract();
	}

	@Override
	public void setContractAuthrizeStatus(String contractNOString) {
		 contractGenerationDao2.setContractAuthrizeStatus(contractNOString);
		
	}

	@Override
	public void setPcsoFlag1(String commaSeparatedPcsoDates) {
		contractGenerationDao2.setPcsoFlag1(commaSeparatedPcsoDates);
		
	}

	@Override
	public List<String> findRefNos(String formatedPcsoDateWithQuotes) {
		return (List<String>) contractGenerationDao2.findRefNos(formatedPcsoDateWithQuotes);
	}

	@Override
	public String millFullName(String millCode) {
		// TODO Auto-generated method stub
		
		return contractGenerationDao2.getMillname(millCode);
	}

	@Override
	public List<String> getPscoDateByCropYr(String cropYr) {
		return contractGenerationDao2.getPscoDateByCropYr(cropYr);
	}


 

}
