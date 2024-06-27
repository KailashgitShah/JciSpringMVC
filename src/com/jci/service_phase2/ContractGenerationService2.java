package com.jci.service_phase2;

import java.util.List;

import org.springframework.web.servlet.ModelAndView;

import com.jci.model.Contractgeneration;

public interface ContractGenerationService2 {
	public void create(Contractgeneration contract);
	public List<Contractgeneration> getAllContract();
	public boolean isValidContractIdn(String contractIdn);
	public List<Object[]> getListOfGradesPriceForMillDelivery(String cropYear) ;
	public List<Object[]> getListOfGradesPriceForExGodown(String cropYear) ;
	public List<Object[]> getListOfGradeComposition(String gradeComp);
//	ModelAndView pcso_details(List<String> pcso,String gradeComp , String deliveryType);
	ModelAndView pcso_details(List<String> pcso,List<String> gradeArray);
	public int updateContractedValue(String deliveryType, String totalQtyOfMill, List<String> gradeArray);
	public List<Contractgeneration> getContractFullDetails(String contractidn, String pcsoDates);
	public List<Object> getFullAddressByMillName(String millNameString);
	public List<Contractgeneration> getAllUnAuthorizedContract();
	public void setContractAuthrizeStatus(String contractNOString);
	public void setPcsoFlag1(String commaSeparatedPcsoDates);
	public List<String> findRefNos(String formatedPcsoDateWithQuotes);
	public String millFullName(String millCode);

}
