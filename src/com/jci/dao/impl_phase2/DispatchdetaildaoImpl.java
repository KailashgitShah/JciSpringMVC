package com.jci.dao.impl_phase2;

import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.jci.dao_phase2.Dispatchdetaildao;

@Repository
@Transactional
public class DispatchdetaildaoImpl implements Dispatchdetaildao {

    @Autowired
    SessionFactory sessionFactory;

    @Autowired
    HttpSession session;

    protected org.hibernate.Session currentSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public List<Object[]> getviewDispatchChallan() {

        String regionId = (String) session.getAttribute("regionId");
        String dpcId = (String) session.getAttribute("dpcId");

        String sql = "";

        if (Arrays.asList("02", "03", "04", "05", "06", "07", "08", "11", "12", "13", "21", "31", "41")
                .contains(regionId)) {

        	if (Arrays.asList("04", "07", "05", "02").contains(regionId) && (dpcId != null && !dpcId.isEmpty())) {
              sql =
                        "SELECT DISTINCT \r\n"
                                + "    a.Challan_no, \r\n"
                                + "    a.Contract_No,  \r\n"
                                + "    a.Mill_name, \r\n"
                                + "    CONVERT(VARCHAR(10), a.Contract_date, 105) AS Formatted_Contract_date, \r\n"
                                + "    a.DI_No, \r\n"
                                + "    CONVERT(VARCHAR(10), a.DI_Date, 105) AS Formatted_DI_Date,\r\n"
                                + "    CONVERT(VARCHAR(10), a.Date_of_shipment, 105) AS Formatted_Date_of_shipment, \r\n"
                                + "    a.Place_of_Shipment, \r\n"
                                + "    a.Consignment_note_text,\r\n"
                                + "    a.Consignment_note\r\n"
                                + "FROM \r\n"
                                + "    jcidispatch_details AS a\r\n"
                                + "WHERE \r\n"
                                + "    a.Di_status = '0' AND a.Place_of_Shipment='" + dpcId + "' ";
            } else {
                sql =
                        "SELECT DISTINCT \r\n"
                                + "    a.Challan_no, \r\n"
                                + "    a.Contract_No,  \r\n"
                                + "    a.Mill_name, \r\n"
                                + "    CONVERT(VARCHAR(10), a.Contract_date, 105) AS Formatted_Contract_date, \r\n"
                                + "    a.DI_No, \r\n"
                                + "    CONVERT(VARCHAR(10), a.DI_Date, 105) AS Formatted_DI_Date,\r\n"
                                + "    CONVERT(VARCHAR(10), a.Date_of_shipment, 105) AS Formatted_Date_of_shipment, \r\n"
                                + "    a.Place_of_Shipment, \r\n"
                                + "    a.Consignment_note_text,\r\n"
                                + "    a.Consignment_note\r\n"
                                + "FROM \r\n"
                                + "    jcidispatch_details AS a\r\n"
                                + "WHERE \r\n"
                                + "    a.Di_status = '0' AND a.Regional_Office='" + regionId + "' ";
            }
        } else {
            sql =
                    "SELECT DISTINCT \r\n"
                            + "    a.Challan_no, \r\n"
                            + "    a.Contract_No,  \r\n"
                            + "    a.Mill_name, \r\n"
                            + "    CONVERT(VARCHAR(10), a.Contract_date, 105) AS Formatted_Contract_date, \r\n"
                            + "    a.DI_No, \r\n"
                            + "    CONVERT(VARCHAR(10), a.DI_Date, 105) AS Formatted_DI_Date,\r\n"
                            + "    CONVERT(VARCHAR(10), a.Date_of_shipment, 105) AS Formatted_Date_of_shipment, \r\n"
                            + "    a.Place_of_Shipment, \r\n"
                            + "    a.Consignment_note_text,\r\n"
                            + "    a.Consignment_note\r\n"
                            + "FROM \r\n"
                            + "    jcidispatch_details AS a\r\n"
                            + "WHERE \r\n"
                            + "    a.Di_status = '0' ";
        }

        List<Object[]> fCList = (List<Object[]>) sessionFactory.getCurrentSession().createSQLQuery(sql).list();
        return fCList;
    }
}

