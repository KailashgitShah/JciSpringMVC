package com.jci.dao_phase2;

import java.util.List;

import org.springframework.web.servlet.ModelAndView;

import com.jci.model.Contractgeneration;

public interface ContractGenerationDao2 {
	void create(Contractgeneration contract);
	 List<Contractgeneration> getAllContract();
	int highestDerivativePrice(String cropYear, String deliveryType);
	boolean isValidContractIdn(String contractIdn);
//	ModelAndView pcso_details(List<String> pcsoDates,String gradeComp , String deliveryType);
	ModelAndView pcso_details(List<String> pcsoDates,List<String> gradeComp, String cropyr);
	List<Object[]> getListOfGradeComposition(String gradeComp);
	int updateContractedValue(String deliveryType, String totalQtyOfMill, List<String> gradeArray,String cropyr);
	List<Contractgeneration> getContractFullDetails(String contractidn, String pcsoDates);
	List<Object> getFullAddressByMillName(String millNameString);
	public List<Contractgeneration> getAllUnAuthorizedContract();
	public void setContractAuthrizeStatus(String contactNo);
	List<Object[]> getListOfGradesPriceForExGodown(String cropYear);
	List<Object[]> getListOfGradesPriceForMillDelivery(String cropYear);
	void setPcsoFlag1(String commaSeparatedPcsoDates);
	List<String> findRefNos(String formatedPcsoDateWithQuotes);
	String getMillname(String millCode);
	List<String> getPscoDateByCropYr(String cropYr);
	String findEmailByMillCode(String millCode);
	int getContractCount(String cropyr);
	


}
