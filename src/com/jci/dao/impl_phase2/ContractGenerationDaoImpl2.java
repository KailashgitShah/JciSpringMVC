package com.jci.dao.impl_phase2;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.context.CurrentSessionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.servlet.ModelAndView;

import com.itextpdf.text.Element;
import com.itextpdf.text.pdf.PdfStructTreeController.returnType;
import com.jci.dao_phase2.ContractGenerationDao2;
import com.jci.model.Contractgeneration;
import com.jci.model.PcsoDateModel;

@Repository
public class ContractGenerationDaoImpl2 implements ContractGenerationDao2 {

	@Autowired
	SessionFactory sessionFactory;

	@Autowired
	HttpServletRequest request;

	protected Session currentSession() {
		return sessionFactory.getCurrentSession();
	}

	List<Double> pg = new ArrayList<>();

	@Override
	public List<Object[]> getListOfGradesPriceForMillDelivery(String cropYear) {
		String sqlQueryToGetHighestPriceOfMilldelivery = "select top 1 grade1, grade2, grade3, grade4, grade5, grade6 from jcientry_derivative_price where grade1 + grade2 + grade3 + grade4 + grade5 + grade6 = (select Max(grade1+grade2+grade3+grade4+grade5+grade6) as SumGrades from jcientry_derivative_price where state_name='Assam' and crop_year='"
				+ cropYear + "'and delivery_type='Mill-Delivery')";

		List<Object[]> listOfGradesMillDelivery = currentSession()
				.createSQLQuery(sqlQueryToGetHighestPriceOfMilldelivery).list();

//		List<Object[]> combinedResult = new ArrayList<>(listOfGradesMillDelivery);
//		combinedResult.addAll(listOfGradesExGodown);

//		for (Object[] gradeP : listOfGradesMillDelivery) {
//			System.err.println("**********");
//			System.err.println("******Grade prices****");
//
//			System.err.println(((BigDecimal) gradeP[0]).doubleValue());
//			System.err.println(((BigDecimal) gradeP[1]).doubleValue());
//			System.err.println(((BigDecimal) gradeP[2]).doubleValue());
//			System.err.println(((BigDecimal) gradeP[3]).doubleValue());
//			System.err.println(((BigDecimal) gradeP[4]).doubleValue());
//			System.err.println(((BigDecimal) gradeP[5]).doubleValue());
//
//			System.err.println("**********");
//			System.err.println("**********");
//
//		}

		return listOfGradesMillDelivery;

	}

	@Override
	public List<Object[]> getListOfGradesPriceForExGodown(String cropYear) {

		String sqlQueryToGetHighestPriceOfExGodown = "select top 1 grade1, grade2, grade3, grade4, grade5, grade6 from jcientry_derivative_price where grade1 + grade2 + grade3 + grade4 + grade5 + grade6 = (select Max(grade1+grade2+grade3+grade4+grade5+grade6) as SumGrades from jcientry_derivative_price where state_name='Assam' and crop_year='"
				+ cropYear + "'and delivery_type='Ex-Godown')";
		List<Object[]> listOfGradesExGodown = currentSession().createSQLQuery(sqlQueryToGetHighestPriceOfExGodown)
				.list();

		return listOfGradesExGodown;
	}

	@Override
	public List<Object[]> getListOfGradeComposition(String gradeComp) {

		String sqlforGrades = "select Jute_combination , Proposed_composition from jcigrade_composition where Label_name='"
				+ gradeComp + "'";

		List<Object[]> list = currentSession().createSQLQuery(sqlforGrades).list();
		return list;
	}

	@Override
	public ModelAndView pcso_details(List<String> pcsoDates, List<String> gradeComp, String cropyr) {

		pg.clear();
		// gc.clear();

		List<Object[]> rows = new ArrayList<>();

		StringJoiner selectColumns = new StringJoiner(", ");
		pcsoDates.forEach(date -> selectColumns
				.add("SUM(CASE WHEN pcso_date = " + date + " THEN Allocated_qty ELSE 0 END) AS " + date));

		String querystr = "SELECT mill_name, mill_code, " + selectColumns.toString()
				+ " , SUM(Allocated_qty) AS Total_Allocation FROM jcientryof_pcso WHERE pcso_date IN (";

		StringJoiner dateJoiner = new StringJoiner(", ");
		pcsoDates.forEach(date -> {
			dateJoiner.add(date);
		});
		// querystr.deleteCharAt(uerystr.length() - 1);
		querystr += dateJoiner + ")  and Pcso_contract_flag = 0 GROUP BY mill_name, mill_code ORDER by mill_name";

		SQLQuery query = currentSession().createSQLQuery(querystr.toString());
		rows = query.list();

		int i = 0;
//		for (String price : gradeComp) {
//			// gc.add((Double) price);
//			System.out.println("Grade" + i + " " + price + " ");
//			i++;
//		}

		List<Object[]> listOfGradesPrice = getListOfGradesPriceForMillDelivery(cropyr);
		String isPrice = "1";
		if (listOfGradesPrice.size() == 0) {
			isPrice = "0";
		}

		for (Object[] gradeP : listOfGradesPrice) {
			// pg.add(gradeP.);

			pg.add(((BigDecimal) gradeP[0]).doubleValue());
			pg.add(((BigDecimal) gradeP[1]).doubleValue());
			pg.add(((BigDecimal) gradeP[2]).doubleValue());
			pg.add(((BigDecimal) gradeP[3]).doubleValue());
			pg.add(((BigDecimal) gradeP[4]).doubleValue());
			pg.add(((BigDecimal) gradeP[5]).doubleValue());

			// System.out.println((Double)gradeP[0]);

//			System.out.println(((BigDecimal) gradeP[0]).doubleValue());
//			System.out.println(((BigDecimal) gradeP[1]).doubleValue());
//			System.out.println(((BigDecimal) gradeP[2]).doubleValue());
//			System.out.println(((BigDecimal) gradeP[3]).doubleValue());
//			System.out.println(((BigDecimal) gradeP[4]).doubleValue());
//			System.out.println(((BigDecimal) gradeP[5]).doubleValue());

		}

		int totalContractedValue = 0;

		List<Integer> contractedValueList = new ArrayList<Integer>();

		for (Object[] row : rows) {
			int size = row.length;
			BigDecimal totalAllocatedToMill = (BigDecimal) row[size - 1];
			// System.err.println(pg.size());
			int sizeOfComponents = pg.size();
			int contractedValueForPerticularMill = 0;
			for (int j = 0; j < sizeOfComponents; j++) {
				// System.out.println(Double.parseDouble(gradeComp.get(j)) / 100 + "<->" +
				// totalAllocatedToMill + "<->" + pg.get(j));
				Double millqty = new BigDecimal(
				        (Double.parseDouble(gradeComp.get(j)) / 100) * totalAllocatedToMill.doubleValue())
				        .setScale(2, RoundingMode.HALF_UP)
				        .doubleValue();
				
				contractedValueForPerticularMill +=  millqty * pg.get(j);
				System.err.println("Mill Qty : "  + millqty);
				System.err.println("Price  : "  + pg.get(j));
			}
			System.out.println("-------------------------------------------");
			System.out.println(contractedValueForPerticularMill);
			System.out.println("-------------------------------------------");
			// contractedValueForPerticularMill =
			// Math.round(contractedValueForPerticularMill * 100.0) / 100.0;
			contractedValueList.add(contractedValueForPerticularMill);
			 System.out.println("temp : " + contractedValueForPerticularMill);
			totalContractedValue += contractedValueForPerticularMill;
		}
		// totalContractedValue = Math.round(totalContractedValue * 100.0) / 100.0;
		 System.err.println(totalContractedValue);

		ModelAndView mView = new ModelAndView();
		mView.addObject("List", rows);
		mView.addObject("isPrice", isPrice);
		mView.addObject("totelContractedValue", totalContractedValue);
		mView.addObject("contractedValueMillWise", contractedValueList);
		return mView;
	}

	@Override
	public void create(Contractgeneration contract) {
		currentSession().save(contract);
	}

	@Override
	public int highestDerivativePrice(String cropYear, String deliveryType) {
		return 0;
	}

	@Override
	public boolean isValidContractIdn(String contractIdn) {
		String sql = "select count(contract_id) from jcicontract where Contract_identification_no='" + contractIdn
				+ "'";
		int count = (Integer) currentSession().createSQLQuery(sql).uniqueResult();

		return count > 0 ? true : false;
	}

	@Override
	public List<Contractgeneration> getAllContract() {

//		String sqlQuery = "select distinct Contract_identification_no , Pcso_date , Contract_date, Contract_qty, SortingId  from jcicontract where Authorize_Status = 1 order by SortingId ASC";
		String sqlQuery = "select distinct Contract_identification_no , Pcso_date , Contract_qty , cropyear , SortingId  from jcicontract where Authorize_Status = 1 order by SortingId ASC";

		List<Object[]> contracts = currentSession().createSQLQuery(sqlQuery).list();

		List<Contractgeneration> list = new ArrayList<>();

		for (Object[] eleObject : contracts) {
			Contractgeneration contractgeneration = new Contractgeneration();

			contractgeneration.setContract_identification_no((String) eleObject[0]);
			contractgeneration.setPcso_date((String) eleObject[1]);
			contractgeneration.setCropYear((String) eleObject[3]);
			/* contractgeneration.setContract_date((String) eleObject[2]); */
			contractgeneration.setContract_qty((String) eleObject[2]);

			list.add(contractgeneration);

		}

		return list;

	}

	@Override
	public int updateContractedValue(String deliveryType, String totalQtyOfMill, List<String> gradeArray,
			String cropyr) {
		pg.clear();
		List<Object[]> listOfGradesPrice = new ArrayList<>();
		if (deliveryType.equals("Ex-Godown")) {
			listOfGradesPrice = getListOfGradesPriceForExGodown(cropyr);
		} else {
			listOfGradesPrice = getListOfGradesPriceForMillDelivery(cropyr);
		}

		// System.out.println(listOfGradesPrice.size());

		for (Object[] gradeP : listOfGradesPrice) {
			// pg.add(gradeP.);

			pg.add(((BigDecimal) gradeP[0]).doubleValue());
			pg.add(((BigDecimal) gradeP[1]).doubleValue());
			pg.add(((BigDecimal) gradeP[2]).doubleValue());
			pg.add(((BigDecimal) gradeP[3]).doubleValue());
			pg.add(((BigDecimal) gradeP[4]).doubleValue());
			pg.add(((BigDecimal) gradeP[5]).doubleValue());

			// System.out.println(deliveryType + "grade price");

//			System.out.println(((BigDecimal) gradeP[0]).doubleValue());
//			System.out.println(((BigDecimal) gradeP[1]).doubleValue());
//			System.out.println(((BigDecimal) gradeP[2]).doubleValue());
//			System.out.println(((BigDecimal) gradeP[3]).doubleValue());
//			System.out.println(((BigDecimal) gradeP[4]).doubleValue());
//			System.out.println(((BigDecimal) gradeP[5]).doubleValue());

		}

		if (pg.size() != 0) {

			double totalAllocatedToMill = Double.parseDouble(totalQtyOfMill);
			int updatedContractedValue = 0;

//		System.err.println("updated function called in i value starts from " + i + "---");
//
//		System.err.println(gradeArray.size() + " " + pg.size());

			for (int j = 0; j < gradeArray.size(); j++) {

				updatedContractedValue += ((int)Math.round((Double.parseDouble(gradeArray.get(j)) / 100) * totalAllocatedToMill))
						* pg.get(j);
//			System.err.println(((int)Math.round((Double.parseDouble(gradeArray.get(j)) / 100) * totalAllocatedToMill)) + " *********** " + pg.get(j));
//			System.err.println("j = " + j + " " + "i = " + i);

			}

			// System.err.println(updatedContractedValue);

			return updatedContractedValue;

		} else {
			return -1;
		}

	}

	@Override
	public List<Contractgeneration> getContractFullDetails(String contractidn, String pcsoDates) {

//		String[] dateList = pcsoDates.split(",");
//		String withCommaString = "";
//
//		for (String s : dateList) {
//			withCommaString += "'" + s + "',";
//		}
//		

		// withCommaString= withCommaString.substring(0, withCommaString.length() - 1);

		String sql = "select * from jcicontract where Contract_identification_no = '" + contractidn
				+ "' and Authorize_Status = 1 and Pcso_date ='" + pcsoDates + "'";

		List<Object[]> list = currentSession().createSQLQuery(sql).list();

		List<Contractgeneration> listOfContract = new ArrayList<>();

		for (Object[] eleObjects : list) {
			Contractgeneration model = new Contractgeneration();
			model.setContract_acceptance_doc((String) eleObjects[2]);
			model.setGrade_composition((String) eleObjects[15]);
			model.setMill_code((String) eleObjects[19]);
			model.setMill_name((String) eleObjects[20]);
			model.setMill_qty((double) eleObjects[21]);
			model.setPcso_date((String) eleObjects[23]);
			model.setDelivery_type((String) eleObjects[14]);
			model.setContract_date((String) eleObjects[6]);
			model.setPayment_duedate((String) eleObjects[22]);
			model.setIntial_Payment_flag((int) eleObjects[17]);

			listOfContract.add(model);
		}

		return listOfContract;
	}

	@Override
	public List<Object> getFullAddressByMillName(String millNameString) {
		String sql = "select client_address1 , client_address2 , client_location , client_pin from jcimilldetailmaster where client_name = '"
				+ millNameString + "'";
		return (List<Object>) currentSession().createSQLQuery(sql).list();

	}

	@Override
	public List<Contractgeneration> getAllUnAuthorizedContract() {

		String roleName = (String) request.getSession().getAttribute("rolename");

		String sql = "select * from jcicontract where Authorized_By ='" + roleName
				+ "' and Authorize_Status = 0 order by created_date desc";
		List<Object[]> list = currentSession().createSQLQuery(sql).list();

		List<Contractgeneration> listOfContract = new ArrayList<>();

		for (Object[] eleObjects : list) {
			Contractgeneration model = new Contractgeneration();
			model.setContract_acceptance_doc((String) eleObjects[2]);
			model.setGrade_composition((String) eleObjects[15]);
			model.setMill_code((String) eleObjects[19]);
			model.setMill_name((String) eleObjects[20]);
			model.setMill_qty((double) eleObjects[21]);
			model.setPcso_date((String) eleObjects[23]);
			model.setDelivery_type((String) eleObjects[14]);
			model.setContract_identification_no((String) eleObjects[7]);
			// model.setMill_qty((double) eleObjects[20]);
			model.setJute_value((int) eleObjects[18]);
			model.setContract_no((String) eleObjects[8]);

			listOfContract.add(model);
		}

		return listOfContract;
	}

	@Override

	public void setContractAuthrizeStatus(String contractNo) {
		String sqlString = "update jcicontract set Authorize_Status = 1 , Contract_acceptance_flag = 1 , Contract_status = 'Mill Accepted', Contract_date = FORMAT(GETDATE(), 'dd-MM-yyyy'),Payment_duedate = FORMAT(DATEADD(DAY, 14, GETDATE()), 'dd-MM-yyyy') where Contract_no in ("
				+ contractNo + ")";

		currentSession().createSQLQuery(sqlString).executeUpdate();
	}

	@Override
	public void setPcsoFlag1(String commaSeparatedPcsoDates) {

		String sqlString = "update jcientryof_pcso set Pcso_contract_flag = 1 where pcso_date in ("
				+ commaSeparatedPcsoDates + ")";

		currentSession().createSQLQuery(sqlString).executeUpdate();
	}

	@Override
	public List<String> findRefNos(String formatedPcsoDateWithQuotes) {
		String sqlString = "select distinct Jc_reference_no from jcientryof_pcso where pcso_date in ("
				+ formatedPcsoDateWithQuotes + ")";

		return currentSession().createSQLQuery(sqlString).list();
	}

	@Override
	public String getMillname(String millCode) {
		// String sql = "select unit_name from jcimilldetailchild where client_unit_code
		// = '" + millCode + "'";
//		String sql = "select concat( b.client_name , '#P#' ,  a.unit_name , '#P#',  b.client_address1 , '#P#', Concat(b.client_location ,'-' , b.client_pin)) from jcimilldetailchild a inner join jcimilldetailmaster b on a.client_code = b.client_code where client_unit_code = '"
//				+ millCode + "'";
		
		String sql = "SELECT CONCAT(b.client_name, '#P#', a.unit_name, '#P#', b.client_address1,'#P#', b.client_address2, '#P#', CONCAT(b.client_location, '-', b.client_pin)) AS client_info\r\n"
				+ "FROM jcimilldetailchild a\r\n"
				+ "INNER JOIN jcimilldetailmaster b \r\n"
				+ "    ON a.client_code = b.client_code\r\n"
				+ "WHERE a.client_unit_code = '"+millCode+"'";

		return (String) currentSession().createSQLQuery(sql).uniqueResult();
	}

	@Override
	public List<String> getPscoDateByCropYr(String cropYr) {
//		String sql = "select distinct pcso_date from jcientryof_pcso where cropYear ='" + cropYr
//				+ "' and Pcso_contract_flag = 0";

		String sql = "SELECT DISTINCT pcso_date,CONVERT(DATETIME, pcso_date, 105) FROM  jcientryof_pcso 	WHERE  cropYear = '"
				+ cropYr + "' AND Pcso_contract_flag = 0 ORDER BY CONVERT(DATETIME, pcso_date, 105) DESC";

		List<Object[]> obj = currentSession().createSQLQuery(sql).list();
		List<String> pcso_dates = new ArrayList<>();
		
	    for(Object[] ele : obj) {
	    	pcso_dates.add((String)ele[0]);
	    }
	   
		return (List<String>) pcso_dates;
	}

	@Override
	public String findEmailByMillCode(String millCode) {
		String sql = "select client_email from jcimilldetailmaster a INNER join jcimilldetailchild b on a.client_code = b.client_code and b.client_unit_code = '"
				+ millCode + "'";
		return (String) currentSession().createSQLQuery(sql).uniqueResult();
	}

	@Override
	public int getContractCount(String cropyr) {
		String sqString = "select "
				+ "COALESCE(MAX(CAST(SUBSTRING(Contract_identification_no, CHARINDEX('-', Contract_identification_no) + 1, LEN(Contract_identification_no)) AS INT)),0) + 1 "
				+ "from jcicontract where CropYear ='" + cropyr + "'";
		return (int) currentSession().createSQLQuery(sqString).uniqueResult();
	}

}
