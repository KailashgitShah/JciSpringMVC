package com.jci.dao.impl_phase2;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.jci.dao_phase2.Dispatchdetaildao;
import com.jci.model.FinancialConcurenceModel;
import com.jci.model.dispatchdetailModel;

import org.hibernate.Session;



@Repository
@Transactional
public class DispatchdetaildaoImpl implements Dispatchdetaildao {
       
       @Autowired
       SessionFactory sessionFactory;
       
       @Autowired
       HttpSession session;
       
       protected org.hibernate.Session currentSession(){
             return sessionFactory.getCurrentSession();
       }
       @Override
       public List<Object[]> getviewDispatchChallan() {
       
        Integer roleId = (Integer) session.getAttribute("roleId");
      
        String dpcId = (String) session.getAttribute("dpcId");
        
        String sql = "";
        
        if(roleId==6 || roleId==7 || roleId==8 ) {
             //ro
                sql = 
                  "     SELECT DISTINCT \r\n"
                 + "    a.Challan_no, \r\n"
                 + "    a.Contract_No,  \r\n"
                 + "    a.Mill_name,\r\n"
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
                 + "    a.Di_status = '0' and a.Regional_Office='"+roleId+"' ";
             
        }else  if (roleId==52 || roleId==53 ){
             sql = 
                  "     SELECT DISTINCT \r\n"
                  + "    a.Challan_no, \r\n"
                  + "    a.Contract_No,  \r\n"
                  + "    a.Mill_name,\r\n"
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
                  + "    a.Di_status = '0' and a.Place_of_Shipment='"+dpcId+"' ";

             
        }
        else {
              sql = 
                  "     SELECT DISTINCT \r\n"
                  + "    a.Challan_no, \r\n"
                  + "    a.Contract_No,  \r\n"
                  + "    a.Mill_name,\r\n"
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
                  + "    a.Di_status = '0'  ";
             
        

        }

       
         

           List<Object[]> fCList = (List<Object[]>) sessionFactory.getCurrentSession().createSQLQuery(sql).list();
           return fCList;
       }
       
       
       
       
       
		/*
		 * @Override public boolean forRoleCheck(String regionId) { String sql =
		 * "SELECT COUNT(*) FROM jciumt WHERE regionId = :regionId";
		 * 
		 * Integer count = (Integer) sessionFactory.getCurrentSession()
		 * .createSQLQuery(sql) .setParameter("regionId", regionId) .uniqueResult();
		 * 
		 * return count != null && count > 0; }
		 * 
		 * @Override public boolean forRoleCheckDPC(String dpcId) { String sql =
		 * "SELECT COUNT(*) FROM jciumt WHERE dpcId = :dpcId";
		 * 
		 * Integer count = (Integer) sessionFactory.getCurrentSession()
		 * .createSQLQuery(sql) .setParameter("dpcId", dpcId) .uniqueResult();
		 * 
		 * return count != null && count > 0; }
		 */

}

