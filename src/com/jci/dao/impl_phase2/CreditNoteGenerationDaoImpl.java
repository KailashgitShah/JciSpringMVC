package com.jci.dao.impl_phase2;

import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jci.dao_phase2.CreditNoteGenerationDao;
import com.jci.model.CreditNotes;
import com.jci.model.EntryDerivativePrice;
import com.jci.model.settlemetCnDnModel;

@Repository
public class CreditNoteGenerationDaoImpl implements CreditNoteGenerationDao {

	@Autowired
	SessionFactory sessionFactory;

	protected Session currentSession() {
		return (Session) sessionFactory.getCurrentSession();
	}

	@Override
	public List<Object[]> getAllVerifiedWeighment() {
		String sqlString = "select a.Bill_of_supply_no ,a.Contract_no ,a.Challan_No, a.Invoice_value,a.Shipment_details , b.Nominal_wt , b.Dpc_actual_wt, b.Ro_id from "
				+ "jcibos_generation a INNER JOIN jciweighment_entry b on b.Verification_status = 1 and a.Bill_of_supply_no = b.Bos_no";

		List<Object[]> list = currentSession().createSQLQuery(sqlString).list();

		return list;
	}

	@Override
	public void create(CreditNotes creditNotes) {
		currentSession().save(creditNotes);
	}

	@Override
	public List<CreditNotes> getAllCreditNotes() {
		Criteria c = this.sessionFactory.getCurrentSession().createCriteria(CreditNotes.class)
				.addOrder(Order.desc("creationDate")).add(Restrictions.eq("crnStatus", 0));
		List<CreditNotes> ll = c.list();
		return ll;
	}

	@Override
	public void chageStatusTo1(int id) {
		String sql = "update jcicredit_note set Crn_Status = 1 where Crn_id = " + id + "";
		currentSession().createSQLQuery(sql).executeUpdate();
	}

	@Override
	public int getCountRO(String ro) {
		String sql = "select Count(Crn_id) from jcicredit_note where Ro_Id = '" + ro + "'";
		return (int) currentSession().createSQLQuery(sql).uniqueResult();

	}

	@Override
	public List<Object[]> getAllMillsOfContracts() {
		String sqlString = "select a.Mill_code , a.Mill_name, a.Contract_no from jcicontract a  where  a.Contract_no in  (SELECT Contract_no FROM jcicredit_note UNION  SELECT Contract_no FROM jcidemand_note )";

		return (List<Object[]>) currentSession().createSQLQuery(sqlString).list();
	}

	@Override
	public List<Object[]> findDetails(String table, String contractNoString) {
		String sqlString = "select * from " + table + " where Contract_no = '" + contractNoString + "'";
		return (List<Object[]>) currentSession().createSQLQuery(sqlString).list();
	}

	@Override
	public void saveSettlementOfCnDn(settlemetCnDnModel settlemetCnDnModel) {
		currentSession().save(settlemetCnDnModel);

	}

}
