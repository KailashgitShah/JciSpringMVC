package com.jci.dao.impl_phase2;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.context.CurrentSessionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.servlet.ModelAndView;

import com.itextpdf.text.pdf.PdfStructTreeController.returnType;
import com.jci.dao_phase2.FinalizationoflotsizeDao;

import com.jci.model.FactorHeadList;
import com.jci.model.FinalizationoflotsizegradesModel;
import com.jci.model.FinalizationoflotsizerspModel;

@Transactional
@Repository
public class FinalizationoflotsizeDaoImpl implements FinalizationoflotsizeDao {

	@Autowired
	SessionFactory sessionFactory;

	protected Session currentSession() {
		return sessionFactory.getCurrentSession();
	}

// @Transactional
// @Override
// public void create(FinalizationoflotsizerspModel FinalizationoflotrspModel ) {
//               // TODO Auto-generated method stub
//               currentSession().save(FinalizationoflotrspModel);
//               
// }
	@Transactional
	public void create(FinalizationoflotsizerspModel finalizationoflotrspModel) {
		try {
			Session session = sessionFactory.getCurrentSession();
			session.save(finalizationoflotrspModel);
		} catch (Exception e) {
			// Log the error message or stack trace
			e.printStackTrace();
			throw new RuntimeException("Failed to create FinalizationoflotsizerspModel", e);
		}
	}

	@Transactional
	public void create1(FinalizationoflotsizegradesModel finalizationoflotsizegradesModel) {
		try {
			Session session = sessionFactory.getCurrentSession();
			session.save(finalizationoflotsizegradesModel);
		} catch (Exception e) {
			// Log the error message or stack trace
			e.printStackTrace();
			throw new RuntimeException("Failed to create FinalizationoflotsizegradesModel", e);
		}
	}

// 
	// @Transactional
// public void create1(FinalizationoflotsizegradesModel finalizationoflotsizegradesModel ) {
//               // TODO Auto-generated method stub
//               currentSession().save(finalizationoflotsizegradesModel);
//               
// }
	@Override
	public List<FinalizationoflotsizerspModel> getAlllist() {
		// TODO Auto-generated method stub
		Criteria c = this.sessionFactory.getCurrentSession().createCriteria(FinalizationoflotsizerspModel.class);
		List<FinalizationoflotsizerspModel> ll = c.list();
		return ll;
	}

	@Override
	public void update(FinalizationoflotsizerspModel FinalizationoflotrspModel) {
		// TODO Auto-generated method stub
		currentSession().update(FinalizationoflotrspModel);

	}

	@Override
	public List<String> Binnoget(String regionId, String cropyr, String basis) {
		String sql = "SELECT DISTINCT binno FROM jciprocurement where regionId = '" + regionId + "' and cropyr = '"
				+ cropyr + "' and basis = '" + basis + "'";
		return (List<String>) currentSession().createSQLQuery(sql).list();
	}

	@Override
	public ModelAndView JuteVarietyGradeWiseGet(String cropyr, String basis, String region, String variety) {

		ModelAndView mView = new ModelAndView();

		String q = "select binnumber,jutevariety,CONCAT(dpcId,'&',dpcnames) as dpc,grade1,grade2,grade3,grade4,grade5,grade6,grade7,grade8,startDate , endDate,pvalue,packingQuantity from jcibin WHERE cropyr='"
				+ cropyr + "' and basis='" + basis + "' and jutevariety = '" + variety + "' and region='" + region
				+ "'";

		String countQuery = "select COALESCE(MAX(Lot_Identification), 0) from jcicommercialsales_rsp where Crop_year= '"
				+ cropyr + "' and Region = '" + region + "' and Basis = '" + basis + "'";

		int count = (int) currentSession().createSQLQuery(countQuery).uniqueResult();
		List<Object[]> binDetails = (List<Object[]>) this.sessionFactory.getCurrentSession().createSQLQuery(q).list();

		if (binDetails.size() == 0) {
			mView.addObject("msg", "Bids are not ready yet !!!");
			return mView;
		}

		mView.addObject("count", count);
		mView.addObject("binDetails", binDetails);
		mView.addObject("msg", "");

		return mView;

	}

	@Override
	public ModelAndView commercialPriceCalculation(String cropyr, String basis, String region, String binNos) {

		String binDeatisArray[] = binNos.split(",");
		ModelAndView mView = new ModelAndView();

		List<Object[]> binDetails = new ArrayList<>();
		System.err.println(binNos);
		System.err.println(cropyr);
		System.err.println(basis);

		for (String str : binDeatisArray) {
			String[] parts = str.split("#");
			Object[] objArray = new Object[parts.length];
			for (int i = 0; i < parts.length; i++) {
				objArray[i] = parts[i];
				System.err.println(parts[i]);
			}
			binDetails.add(objArray);
		}

		List<Double> potentialSellingPrice = new ArrayList<>(Collections.nCopies(8, 0.0));
		List<Double> gQtySum = new ArrayList<>(Collections.nCopies(8, 0.0));
		List<Double> wtXPotentialSellingPrice = new ArrayList<>(Collections.nCopies(8, 0.0));

		// avg purchase price calculation
		for (Object[] row : binDetails) {
			String dpc = (String) row[0];
			String binNo = (String) row[1];
			String juteVariety = (String) row[2];
			// double netQty = Double.parseDouble((String) row[3]);
//			double garsatRate = Double.parseDouble((String) row[12]);
//			double amount = garsatRate * netQty;
			String startDate = (String) row[12];
			String endDate = (String) row[13];
			List<Double> gQty = new ArrayList<>(Collections.nCopies(8, 0.0));

			for (int p = 0; p < 8; p++) {
				gQty.set(p, Double.parseDouble((String) row[p + 4]));
			}

			String priceQuery = "SELECT a.grade1, a.grade2,a.grade3,a.grade4,a.grade5,a.grade6,a.grade7,a.grade8 from jcijutepricesforcommercial a \r\n"
					+ "where  CONVERT(date ,'" + startDate + "' , 105) <= CONVERT(date , a.effectDate , 105)"
					+ "and CONVERT(date , a.effectDate , 105) <= CONVERT(date , '" + endDate
					+ "' , 105) and dpc like '%" + dpc + "%' and a.crop_yr = '" + cropyr + "' and a.jute_variety = '"
					+ juteVariety + "'";

			List<Object[]> pricesList = (List<Object[]>) currentSession().createSQLQuery(priceQuery).list();
			List<Double> priceDiff = new ArrayList<>(Collections.nCopies(8, 0.0));
			List<Double> gPrice = new ArrayList<>(Collections.nCopies(8, 0.0));
			List<Double> wtXprice = new ArrayList<>(Collections.nCopies(8, 0.0));

			if (pricesList.size() == 0) {
				mView.addObject("msg", "Price is not decided for " + juteVariety + " crop yr " + cropyr);
				return mView;
			}

			double amount = 0;
			for (Object[] price : pricesList) {
				for (int i = 0; i < 8; i++) {
					wtXprice.set(i, wtXprice.get(i) + gQty.get(i) * ((BigDecimal) price[i]).doubleValue());
				}
			}

			for (int i = 0; i < 8; i++) {
				if (gQty.get(i) != 0)
					gPrice.set(i, wtXprice.get(i) / gQty.get(i));
				System.err.println("price" + (i + 1) + " " + gPrice.get(i));
			}

			for (int i = 0; i < 8; i++) {
				amount += gPrice.get(i) * gQty.get(i);
				gQtySum.set(i, gQtySum.get(i) + gQty.get(i));
			}

			for (int i = 0; i < 8; i++) {
				priceDiff.set(i, gPrice.get(i) - gPrice.get(4));
			}

			double newg5P = 0;

			double qtySum = 0;
			for (int i = 0; i < 8; i++) {
				amount -= priceDiff.get(i) * gQty.get(i);
				qtySum += gQty.get(i);
			}

			if (qtySum != 0)
				newg5P = amount / qtySum;

			List<Double> newPriceForGrade = new ArrayList<>(Collections.nCopies(8, 0.0));

			for (int i = 0; i < 8; i++) {
				newPriceForGrade.set(i, priceDiff.get(i) + newg5P);
				double preVal = wtXPotentialSellingPrice.get(i);

				double currValDouble = gQty.get(i) * newPriceForGrade.get(i);
				wtXPotentialSellingPrice.set(i, preVal + currValDouble);
			}

		}

		for (int j = 0; j < 8; j++) {
			if (gQtySum.get(j) != 0) {
				potentialSellingPrice.set(j, wtXPotentialSellingPrice.get(j) / gQtySum.get(j));
				System.err.println("basePrice" + j + " " + potentialSellingPrice.get(j));
			}
		}

		mView.addObject("potentialSellingPrice", potentialSellingPrice);
		mView.addObject("msg", "");

		return mView;

	}

	@Override
	public List<Object[]> getFactorList(String region, String cropyear, String basis) {
		// TODO Auto-generated method stub
		String querystr = "WITH CTE AS (\r\n" + "    SELECT operation_cost_head, rate, created_date,\r\n"
				+ "           ROW_NUMBER() OVER (PARTITION BY operation_cost_head ORDER BY created_date DESC) AS rn\r\n"
				+ "    FROM jcioperationfreesales_cost\r\n" + "    WHERE region = '" + region + "'\r\n"
				+ "      AND crop_year = '" + cropyear + "'\r\n" + "      and basis='" + basis + "'\r\n" + ")\r\n"
				+ "SELECT operation_cost_head, rate, created_date\r\n" + "FROM CTE\r\n" + "WHERE rn = 1\r\n"
				+ "ORDER BY created_date DESC;\r\n" + "";
		List<Object[]> rows = currentSession().createSQLQuery(querystr).list();
		return rows;
	}

	@Override
	public List<String> getFactorList(char c) {
		String sql = "select distinct jutevariety from jcijutevariety where basis = '" + c + "'";
		return (List<String>) currentSession().createSQLQuery(sql).list();
	}

	@Override
	public void createModel(FactorHeadList factorList) {
		// TODO Auto-generated method stub
		try {
			Session session = sessionFactory.getCurrentSession();

			System.err.println(factorList.toString());
			session.save(factorList);
		} catch (Exception e) {
			// Log the error message or stack trace
			e.printStackTrace();
			throw new RuntimeException("Failed to create FinalizationoflotsizerspModel", e);
		}

	}

	@Override
	public void creategrade(FinalizationoflotsizegradesModel gradeModel) {
		// TODO Auto-generated method stub
		try {
			Session session = sessionFactory.getCurrentSession();
			System.err.println(gradeModel.toString());
			session.save(gradeModel);
		} catch (Exception e) {
			// Log the error message or stack trace
			e.printStackTrace();
			throw new RuntimeException("Failed to create FinalizationoflotsizerspModel", e);
		}

	}

	@Override
	public List<Object[]> getLotData(String basis) {
		// TODO Auto-generated method stub
		String query = " select Crop_year ,Lot_Identification,Lot_Size,Purchase_Base_Price from jcicommercialsales_rsp where and basis = '"
				+ basis + "'";
		List<Object[]> rows = currentSession().createSQLQuery(query).list();
		return rows;
	}

	@Override
	public List<Object[]> getDetails(String id) {
		// TODO Auto-generated method stub
		String query = "SELECT \r\n" + "    a.Rsp_grd1, a.Rsp_grd2, a.Rsp_grd3, a.Rsp_grd4, \r\n"
				+ "    a.Rsp_grd5, a.Rsp_grd6, a.Rsp_grd7, a.Rsp_grd8, \r\n"
				+ "    a.Rsp_grd1_diff, a.Rsp_grd2_diff, a.Rsp_grd3_diff, a.Rsp_grd4_diff, \r\n"
				+ "    a.Rsp_grd5_diff, a.Rsp_grd6_diff, a.Rsp_grd7_diff, a.Rsp_grd8_diff, \r\n"
				+ "    a.Sell_gr1, a.Sell_gr2, a.Sell_gr3, a.Sell_gr4, \r\n"
				+ "    a.Sell_gr5, a.Sell_gr6, a.Sell_gr7, a.Sell_gr8, \r\n"
				+ "    a.Sell_gr1_diff, a.Sell_gr2_diff, a.Sell_gr3_diff, a.Sell_gr4_diff, \r\n"
				+ "    a.Sell_gr5_diff, a.Sell_gr6_diff, a.Sell_gr7_diff, a.Sell_gr8_diff, \r\n"
				+ "    a.Crop_year, a.Lot_Identification, a.Lot_Size, a.Purchase_Base_Price ,\r\n"
				+ "    c.roname,b.JuteVariety\r\n" + "FROM \r\n" + "    jcicommercialsales_rsp a\r\n"
				+ "    inner join  jcicommercialsales_grades b on a.Lot_Identification= b.LotIdentification\r\n"
				+ "    inner join jcirodetails c on c.rocode= b.Region\r\n" + "WHERE \r\n"
				+ "    a.Lot_Identification = '" + id + "'\r\n" + "\r\n" + " group by\r\n"
				+ "   a.Rsp_grd1, a.Rsp_grd2, a.Rsp_grd3, a.Rsp_grd4, \r\n"
				+ "    a.Rsp_grd5, a.Rsp_grd6, a.Rsp_grd7, a.Rsp_grd8, \r\n"
				+ "    a.Rsp_grd1_diff, a.Rsp_grd2_diff, a.Rsp_grd3_diff, a.Rsp_grd4_diff, \r\n"
				+ "    a.Rsp_grd5_diff, a.Rsp_grd6_diff, a.Rsp_grd7_diff, a.Rsp_grd8_diff, \r\n"
				+ "    a.Sell_gr1, a.Sell_gr2, a.Sell_gr3, a.Sell_gr4, \r\n"
				+ "    a.Sell_gr5, a.Sell_gr6, a.Sell_gr7, a.Sell_gr8, \r\n"
				+ "    a.Sell_gr1_diff, a.Sell_gr2_diff, a.Sell_gr3_diff, a.Sell_gr4_diff, \r\n"
				+ "    a.Sell_gr5_diff, a.Sell_gr6_diff, a.Sell_gr7_diff, a.Sell_gr8_diff, \r\n"
				+ "    a.Crop_year, a.Lot_Identification, a.Lot_Size, a.Purchase_Base_Price ,c.roname,b.JuteVariety\r\n"
				+ "\r\n" + "";
		List<Object[]> rows = currentSession().createSQLQuery(query).list();
		return rows;
	}

}
