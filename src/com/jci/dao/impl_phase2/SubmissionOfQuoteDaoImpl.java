package com.jci.dao.impl_phase2;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.jci.dao_phase2.SubmissionOfQuoteDao;
import com.jci.model.BidCreation;
import com.jci.model.EntryPaymentDetailsModel;
import com.jci.model.SubmissionOfQuoteModel;

@Repository
@Transactional
public class SubmissionOfQuoteDaoImpl implements SubmissionOfQuoteDao {
	@Autowired
	SessionFactory sessionFactory;

	protected Session currentSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public void create(SubmissionOfQuoteModel submissionOfQuoteModel) {
		currentSession().saveOrUpdate(submissionOfQuoteModel);

	}

	@Override
	public List<SubmissionOfQuoteModel> getAll() {
		Criteria criteria = currentSession().createCriteria(SubmissionOfQuoteModel.class);
		return criteria.list();
	}

	@Override
	public int bidrollout_No() {

		String hql = "Select bid_roll_out from  jcibid_creation ";

		return this.sessionFactory.getCurrentSession().createSQLQuery(hql).executeUpdate();

	}

	@Override
	public List<BidCreation> getbidlist() {

		String sql = " SELECT * FROM jcibid_creation WHERE bid_roll_out IN(1) ORDER BY bid_id DESC";

		List<BidCreation> fCList = sessionFactory.getCurrentSession().createSQLQuery(sql).addEntity(BidCreation.class)
				.list();
		return fCList;
	}

	@Override
	public String getmillname(String st) {

		String hql = "  select mill_name from jcimill_Registration where mill_code='" + st + "'";

		return (String) this.sessionFactory.getCurrentSession().createSQLQuery(hql).uniqueResult();

	}

	@Override
	public String sellprice(String st) {
		String hql = "  select ReservedSalePrice from jcifreesales_rsp where lot_id='" + st + "'";

		BigDecimal result = (BigDecimal) this.sessionFactory.getCurrentSession().createSQLQuery(hql).uniqueResult();

		if (result != null) {
			return result.toString();
		} else {
			return null; // or return an appropriate default value
		}
	}

	@Override
	public String bidrank() {
		String sql = "SELECT  count(*) FROM jcibid_submission1 ";
		int total = (Integer) this.sessionFactory.getCurrentSession().createSQLQuery(sql).uniqueResult();
		total++;

		return String.valueOf(total);

	}

	@Override
	public List<Object[]> creationlist(String lotIds) {
		// Split the comma-separated lotIds into an array
		String[] lotIdArray = lotIds.split(",");

		// Map to hold the aggregated data grouped by JuteVariety and grade index
		Map<String, Object[]> aggregatedData = new HashMap<>();

		// First query: Fetch details for each lotid
		String querystr1 = "SELECT DISTINCT " + "    a.LotIdentification, " + "    d.roname, " + "    a.JuteVariety, "
				+ "    a.Crop_year, " + "    NULL AS Gr_1, " + "    NULL AS Gr_2, " + "    NULL AS Gr_3, "
				+ "    NULL AS Gr_4, " + "    NULL AS Gr_5, " + "    NULL AS Gr_6, " + "    NULL AS Gr_7, "
				+ "    NULL AS Gr_8, " + "    NULL AS NetQty, " + "    b.Reserved_Sale_Price "
				+ "FROM jcicommercialsales_grades AS a "
				+ "LEFT JOIN jcicommercialsales_rsp AS b ON b.Lot_Identification = a.LotIdentification "
				+ "LEFT JOIN (SELECT s.roname, s.rocode " + "            FROM jcirodetails AS s "
				+ "            LEFT JOIN jcicommercialsales_grades AS b ON b.Region = s.rocode) AS d "
				+ "ON a.Region = d.rocode " + "WHERE a.LotIdentification = :lotid";

		// Second query: Fetch aggregated data for each lotid
		String querystr2 = "SELECT " + "    a.LotIdentification, " + "    NULL AS roname, " + "    a.JuteVariety, "
				+ "    NULL AS Crop_year, " + "    SUM(CAST(TRY_CAST(a.Gr_1 AS VARCHAR) AS FLOAT)) AS Gr_1, "
				+ "    SUM(CAST(TRY_CAST(a.Gr_2 AS VARCHAR) AS FLOAT)) AS Gr_2, "
				+ "    SUM(CAST(TRY_CAST(a.Gr_3 AS VARCHAR) AS FLOAT)) AS Gr_3, "
				+ "    SUM(CAST(TRY_CAST(a.Gr_4 AS VARCHAR) AS FLOAT)) AS Gr_4, "
				+ "    SUM(CAST(TRY_CAST(a.Gr_5 AS VARCHAR) AS FLOAT)) AS Gr_5, "
				+ "    SUM(CAST(TRY_CAST(a.Gr_6 AS VARCHAR) AS FLOAT)) AS Gr_6, "
				+ "    SUM(CAST(TRY_CAST(a.Gr_7 AS VARCHAR) AS FLOAT)) AS Gr_7, "
				+ "    SUM(CAST(TRY_CAST(a.Gr_8 AS VARCHAR) AS FLOAT)) AS Gr_8, "
				+ "    SUM(CAST(TRY_CAST(a.NetQty AS VARCHAR) AS FLOAT)) AS NetQty, "
				+ "    NULL AS Reserved_Sale_Price " + "FROM jcicommercialsales_grades AS a "
				+ "WHERE a.LotIdentification = :lotid " + "GROUP BY a.LotIdentification, a.JuteVariety";

		// Loop through each lotId and fetch results
		for (String lotId : lotIdArray) {
			lotId = lotId.trim(); // Remove any leading or trailing whitespace

			// Execute the first query for the current lotId
			List<Object[]> detailsList = (List<Object[]>) this.sessionFactory.getCurrentSession()
					.createSQLQuery(querystr1).setParameter("lotid", lotId).list();

			// Execute the second query for the current lotId
			List<Object[]> aggregateList = (List<Object[]>) this.sessionFactory.getCurrentSession()
					.createSQLQuery(querystr2).setParameter("lotid", lotId).list();

			// Combine the results for the current lotId
			if (!detailsList.isEmpty() && !aggregateList.isEmpty()) {
				for (Object[] details : detailsList) {
					String juteVariety = (String) details[2]; // Assuming JuteVariety is at index 2

					// Check if the juteVariety is already in the aggregatedData map
					if (!aggregatedData.containsKey(juteVariety)) {
						// Initialize the row with the correct length
						Object[] combinedRow = new Object[details.length];
						System.arraycopy(details, 0, combinedRow, 0, details.length); // Copy details
						aggregatedData.put(juteVariety, combinedRow);
					}

					Object[] combinedRow = aggregatedData.get(juteVariety);

					// Aggregate grades and net quantity for the same JuteVariety
					for (Object[] aggregate : aggregateList) {
						if (juteVariety.equals(aggregate[2])) {
							for (int i = 4; i < aggregate.length; i++) {
								if (aggregate[i] != null) {
									combinedRow[i] = (combinedRow[i] == null ? 0 : (Double) combinedRow[i])
											+ (Double) aggregate[i];
								}
							}
						}
					}
				}
			}
		}

		// Convert the map to a list
		List<Object[]> combinedList = new ArrayList<>(aggregatedData.values());

		return combinedList;
	}

	@Override
	public List<Object[]> listdata() {
//		String querystr = "   SELECT a.bid_reference_no, a.bid_date,a.bid_closing_date,b.Lot_Size,a.lot_identification,a.basis,a.security_deposit_amount from jcibid_creation as a \r\n"
//				+ "			     LEFT JOIN jcicommercialsales_rsp as b on b.Lot_Identification=a.lot_identification WHERE a.bid_roll_out=1 \r\n"
//				+ "                   ";

		String querystr = "\r\n" + "WITH FlattenedLotIds AS (\r\n" + "    SELECT \r\n"
				+ "        a.bid_reference_no,\r\n" + "        a.bid_date,\r\n" + "        a.bid_closing_date,\r\n"
				+ "        a.lot_identification,\r\n" + "        a.basis,\r\n"
				+ "        a.security_deposit_amount,\r\n"
				+ "        TRY_CAST(b.Lot_Size AS DECIMAL(18, 2)) AS Lot_Size,\r\n"
				+ "        split_lot.value AS LotId\r\n" + "    FROM \r\n" + "        jcibid_creation AS a\r\n"
				+ "    CROSS APPLY \r\n" + "        STRING_SPLIT(a.lot_identification, ',') AS split_lot\r\n"
				+ "    LEFT JOIN \r\n" + "        jcicommercialsales_rsp AS b \r\n"
				+ "        ON b.Lot_Identification = split_lot.value\r\n" + "    WHERE \r\n"
				+ "        a.bid_roll_out = 1\r\n" + "),\r\n" + "AggregatedLotSizes AS (\r\n" + "    SELECT \r\n"
				+ "        bid_reference_no,\r\n" + "        COUNT(DISTINCT LotId) AS LotIdCount,\r\n"
				+ "        SUM(Lot_Size) AS TotalLotSize\r\n" + "    FROM \r\n" + "        FlattenedLotIds\r\n"
				+ "    GROUP BY \r\n" + "        bid_reference_no\r\n" + ")\r\n" + "SELECT \r\n"
				+ "    f.bid_reference_no,\r\n" + "    f.bid_date,\r\n" + "    f.bid_closing_date,\r\n"
				+ "    f.lot_identification,\r\n" + "    f.basis,\r\n" + "    f.security_deposit_amount,\r\n"
				+ "    CASE \r\n" + "        WHEN a.LotIdCount > 1 THEN a.TotalLotSize\r\n"
				+ "        ELSE MAX(f.Lot_Size)\r\n" + "    END AS Total_Lot_Size\r\n" + "FROM \r\n"
				+ "    FlattenedLotIds f\r\n" + "JOIN \r\n" + "    AggregatedLotSizes a \r\n"
				+ "    ON f.bid_reference_no = a.bid_reference_no\r\n" + "GROUP BY \r\n" + "    f.bid_reference_no,\r\n"
				+ "    f.bid_date,\r\n" + "    f.bid_closing_date,\r\n" + "    f.lot_identification,\r\n"
				+ "    f.basis,\r\n" + "    f.security_deposit_amount,\r\n" + "    a.LotIdCount,\r\n"
				+ "    a.TotalLotSize; ";

		List<Object[]> listdata = (List<Object[]>) this.sessionFactory.getCurrentSession().createSQLQuery(querystr)
				.list();
		return listdata;
	}

	@Override
	public List<Object[]> freightCalculation(String lotid) {
		String[] lotidArray = lotid.split(",");

		String inClause = String.join(",",
				Arrays.stream(lotidArray).map(id -> "'" + id.trim() + "'").toArray(String[]::new));

		String queryStr = "SELECT * FROM jciFactorsList WHERE LotNumber IN (" + inClause + ")";

		// Use a parameterized query to prevent SQL injection
		List<Object[]> listdata = (List<Object[]>) this.sessionFactory.getCurrentSession().createSQLQuery(queryStr)
				.list();

		return listdata;
	}

	@Override
	public List<Object[]> exgodowndeliverytype(String lotid) {
		String[] lotidArray = lotid.split(",");

		String inClause = String.join(",",
				Arrays.stream(lotidArray).map(id -> "'" + id.trim() + "'").toArray(String[]::new));

		// Construct the query with the IN clause
		String queryStr = "SELECT Delivery_Type, Reserved_Sale_Price,Lot_Identification FROM jcicommercialsales_rsp WHERE Lot_Identification IN ("
				+ inClause + ")";

		// Execute the query
		List<Object[]> listdata1 = (List<Object[]>) this.sessionFactory.getCurrentSession().createSQLQuery(queryStr)
				.list();

		return listdata1;
	}

}
