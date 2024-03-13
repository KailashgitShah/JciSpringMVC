package com.jci.dao.impl_phase2;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.servlet.ModelAndView;

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
	List<Double> gc = new ArrayList<>();

	@Override
	public List<Object[]> getListOfGradesPrice(String cropYear) {
		String sqlQueryToGetHighestPriceOfExGodown = "select top 1 grade1, grade2, grade3, grade4, grade5, grade6 from jcientry_derivative_price where grade1 + grade2 + grade3 + grade4 + grade5 + grade6 = (select Max(grade1+grade2+grade3+grade4+grade5+grade6) as SumGrades from jcientry_derivative_price where state_name='West Bengal' and crop_year='"
				+ cropYear + "'and delivery_type='Ex-Godown')";

		String sqlQueryToGetHighestPriceOfMilldelivery = "select top 1 grade1, grade2, grade3, grade4, grade5, grade6 from jcientry_derivative_price where grade1 + grade2 + grade3 + grade4 + grade5 + grade6 = (select Max(grade1+grade2+grade3+grade4+grade5+grade6) as SumGrades from jcientry_derivative_price where state_name='Assam' and crop_year='"
				+ cropYear + "'and delivery_type='Mill-Delivery')";

		List<Object[]> listOfGradesMillDelivery = currentSession()
				.createSQLQuery(sqlQueryToGetHighestPriceOfMilldelivery).list();
		List<Object[]> listOfGradesExGodown = currentSession().createSQLQuery(sqlQueryToGetHighestPriceOfExGodown)
				.list();
		List<Object[]> combinedResult = new ArrayList<>(listOfGradesMillDelivery);
		combinedResult.addAll(listOfGradesExGodown);

		for (Object[] gradeP : combinedResult) {
			System.err.println("**********");
			System.err.println("******Grade prices****");

			System.err.println(((BigDecimal) gradeP[0]).doubleValue());
			System.err.println(((BigDecimal) gradeP[1]).doubleValue());
			System.err.println(((BigDecimal) gradeP[2]).doubleValue());
			System.err.println(((BigDecimal) gradeP[3]).doubleValue());
			System.err.println(((BigDecimal) gradeP[4]).doubleValue());
			System.err.println(((BigDecimal) gradeP[5]).doubleValue());

			System.err.println("**********");
			System.err.println("**********");

		}

		return combinedResult;

	}

	@Override
	public List<Object[]> getListOfGradeComposition(String gradeComp) {

		String sqlforGrades = "select Jute_combination , Proposed_composition from jcigrade_composition where Label_name='"
				+ gradeComp + "'";

		List<Object[]> list = currentSession().createSQLQuery(sqlforGrades).list();
		return list;
	}

	@Override
	public ModelAndView pcso_details(List<String> pcsoDates, List<String> gradeComp) {

		pg.clear();
		// gc.clear();

		String currCropYear = (String) request.getSession().getAttribute("currCropYear");

		List<Object[]> rows = new ArrayList<>();

		StringBuilder querystr = new StringBuilder("SELECT  mill_name, mill_code,");
		pcsoDates.forEach(date -> {
			querystr.append("SUM(CASE WHEN pcso_date =" + date + "THEN Allocated_qty ELSE 0 END) AS " + date + ",");
		});

		querystr.append(
				"SUM(Allocated_qty) AS Total_Allocation FROM [XMWJCI].[dbo].[jcientryof_pcso] WHERE pcso_date IN (");

		pcsoDates.forEach(date -> {
			querystr.append(date + ",");
		});
		querystr.deleteCharAt(querystr.length() - 1);
		querystr.append(") GROUP BY mill_name, mill_code");

		SQLQuery query = currentSession().createSQLQuery(querystr.toString());
		rows = query.list();

		int i = 0;
		for (String price : gradeComp) {
			// gc.add((Double) price);
			System.out.println("Grade" + i + " " + price + " ");
			i++;
		}

		List<Object[]> listOfGradesPrice = getListOfGradesPrice(currCropYear);

		// System.out.println(listOfGradesPrice.size());

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

		Double totalContractedValue = 0.0;

		List<Double> contractedValueList = new ArrayList<Double>();

		for (Object[] row : rows) {
			int size = row.length;
			Double totalAllocatedToMill = (Double) row[size - 1];
			int sizeOfComponents = pg.size() / 2;
			Double contractedValueForPerticularMill = 0.0;
			for (int j = 0; j < sizeOfComponents; j++) {
				System.out.println(
						Double.parseDouble(gradeComp.get(j)) / 100 + "<->" + totalAllocatedToMill + "<->" + pg.get(j));
				contractedValueForPerticularMill += (Double.parseDouble(gradeComp.get(j)) / 100)
						* (totalAllocatedToMill * pg.get(j));
			}
			System.out.println("-------------------------------------------");
			System.out.println(contractedValueForPerticularMill);
			System.out.println("-------------------------------------------");
			contractedValueForPerticularMill = Math.round(contractedValueForPerticularMill * 100.0) / 100.0;
			contractedValueList.add(contractedValueForPerticularMill);
			System.out.println("temp : " + contractedValueForPerticularMill);
			totalContractedValue += contractedValueForPerticularMill;
		}
		totalContractedValue = Math.round(totalContractedValue * 100.0) / 100.0;
		System.err.println(totalContractedValue);

		ModelAndView mView = new ModelAndView();
		mView.addObject("List", rows);
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

		String sqlQuery = "select distinct Contract_identification_no , Pcso_date , Contract_date, Contract_qty, SortingId  from jcicontract where Authorize_Status = 1 order by SortingId ASC";

		List<Object[]> contracts = currentSession().createSQLQuery(sqlQuery).list();

		List<Contractgeneration> list = new ArrayList<>();

		for (Object[] eleObject : contracts) {
			Contractgeneration contractgeneration = new Contractgeneration();

			contractgeneration.setContract_identification_no((String) eleObject[0]);
			contractgeneration.setPcso_date((String) eleObject[1]);
			contractgeneration.setContract_date((String) eleObject[2]);
			contractgeneration.setContract_qty((String) eleObject[3]);

			list.add(contractgeneration);

		}

		return list;

	}

	@Override
	public int updateContractedValue(String deliveryType, String totalQtyOfMill) {

		int i = deliveryType.equals("Ex-Godown") ? 6 : 0;
		int totalAllocatedToMill = Integer.parseInt(totalQtyOfMill);
		int updatedContractedValue = 0;

		System.err.println("updated function called in i value starts from " + i + "---");

		System.err.println(gc.size() + " " + pg.size());

		for (int j = 0; j < gc.size(); j++) {

			updatedContractedValue += (gc.get(j) / 100) * (totalAllocatedToMill * pg.get(i));
			System.err.println(gc.get(j) + " *********** " + pg.get(i));
			System.err.println("j = " + j + " " + "i = " + i);
			i++;
		}

		System.err.println(updatedContractedValue);

		return updatedContractedValue;

	}

	@Override
	public List<Contractgeneration> getContractFullDetails(String contractidn) {
		String sql = "select * from jcicontract where Contract_identification_no = '" + contractidn + "' and Authorize_Status = 1";

		List<Object[]> list = currentSession().createSQLQuery(sql).list();

		List<Contractgeneration> listOfContract = new ArrayList<>();

		for (Object[] eleObjects : list) {
			Contractgeneration model = new Contractgeneration();
			model.setContract_acceptance_doc((String) eleObjects[2]);
			model.setGrade_composition((String) eleObjects[15]);
			model.setMill_code((String) eleObjects[18]);
			model.setMill_name((String) eleObjects[19]);
			model.setMill_qty((double) eleObjects[20]);
			model.setPcso_date((String) eleObjects[22]);
			model.setDelivery_type((String) eleObjects[14]);

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
		
		String roleName = (String)request.getSession().getAttribute("rolename");
		
		String sql = "select * from jcicontract where Authorized_By ='" + roleName + "' and Authorize_Status = 0";
		List<Object[]> list = currentSession().createSQLQuery(sql).list();

		List<Contractgeneration> listOfContract = new ArrayList<>();

		for (Object[] eleObjects : list) {
			Contractgeneration model = new Contractgeneration();
			model.setContract_acceptance_doc((String) eleObjects[2]);
			model.setGrade_composition((String) eleObjects[15]);
			model.setMill_code((String) eleObjects[18]);
			model.setMill_name((String) eleObjects[19]);
			model.setMill_qty((double) eleObjects[20]);
			model.setPcso_date((String) eleObjects[22]);
			model.setDelivery_type((String) eleObjects[14]);
			model.setContract_identification_no((String) eleObjects[7]);
			model.setMill_qty((double) eleObjects[20]);
			model.setContract_no( (String)eleObjects[8]);

			listOfContract.add(model);
		}

		return listOfContract;
	}

	@Override
	public void setContractAuthrizeStatus(String contractNo) {
		String sqlString = "update jcicontract set Authorize_Status = 1 , Contract_date = FORMAT(GETDATE(), 'dd-MM-yyyy') where Contract_no in (" + contractNo + ")";

		currentSession().createSQLQuery(sqlString).executeUpdate();	
	}

}
