<%@ page import="java.util.Date" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@page import="org.apache.poi.util.SystemOutLogger"%>

<%@page import="com.jci.model.dispatchdetailModel"%>

<%@page import="java.util.HashMap"%>
<%@page import="java.util.List"%>
<%@page import="java.io.File"%>
<%@page import="com.jci.model.RoleMasterModel"%>
<%@page import="com.jci.model.ZoneModel"%>
<%@page isELIgnored="false"%>
<%@ page import="java.time.LocalDateTime" %>
<%@ page import="java.time.format.DateTimeFormatter" %>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width initial-scale=1.0">
     <title>JCI | CMS</title>
    <!-- GLOBAL MAINLY STYLES-->
    <link href="./assets/vendors/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet" />
    <link href="./assets/vendors/font-awesome/css/font-awesome.min.css" rel="stylesheet" />
    <link href="./assets/vendors/themify-icons/css/themify-icons.css" rel="stylesheet" />
    <!-- PLUGINS STYLES-->
    <link href="./assets/vendors/DataTables/datatables.min.css" rel="stylesheet" />
    <!-- THEME STYLES-->
    <link href="assets/css/main.min.css" rel="stylesheet" />
    
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
     

    <!-- PAGE LEVEL STYLES-->
    <style>
.scrollmenu {

  overflow: auto;
  white-space: nowrap;
}

.scrollmenu a {
  display: inline-block;
  color: white;
  text-align: center;
  padding: 14px;
  text-decoration: none;
}
</style>

</head>

<body class="fixed-navbar">
    <div class="page-wrapper">
        <!-- START HEADER-->
         <%@ include file="header.jsp"%>
        <!-- END HEADER-->
        <!-- START SIDEBAR-->
         <%@ include file="sidebar.jsp"%>
        <!-- END SIDEBAR-->
        <div class="content-wrapper">
            <!-- START PAGE CONTENT-->
            	<div class="page-heading">
				<h1 class="page-title">Dispatch Detail List</h1>

			</div>

			
<%
   List<Object[]> allUserRegistration = (List<Object[]>) request.getAttribute("viewDispatchChallan");
%>

                  <div class="page-content fade-in-up">
                <div class="ibox">
                    <div class="ibox-head">
                    <span id="flashMessage">${msg}</span>
                        <div class="ibox-title"></div>
                    </div>
                      
                    
                    <div class="ibox-body">
                      <div class="scrollmenu">
                        <table class="table table-striped table-bordered table-hover" id="example-table" cellspacing="0" width="100%">
                               <thead>
									<tr>
										<th>Sl.No</th>
										
										<th>Challan_no</th>
										<!-- <th>Consignment_note</th> -->
										<th>Contract_No</th>
										<th>Contract_date</th>
										<th>Creation_date</th>
										<th>DI_Date</th>
										<th>DI_No</th>
										<th>Date_of_shipment</th>
										<th>Di_status</th>
										<th>Driver_contact</th>
										<th>Driver_name</th>
										<th>License_no</th>
										<th>Mill_name</th>
										<th>Mode_of_shipment</th>
										<th>Place_of_Shipment</th>
										<th>Regional_Office</th>
										<th>Vehicle_no</th>
										<th>Bale_mark</th>
										<th>Crop_year</th>
										<th>Jute_grade</th>
										<th>Jute_value</th>
										<th>Jute_variety</th>
										<th>No_of_bales</th>
										<th>Nominal_qty</th>
										<th>Nominal_wt</th>
										<th>Rate</th>
										<th></th>
										
										
									</tr>
								</thead>
								
								
                           <tbody>
<script>
// Function to format the date as "DD-MM-YYYY"
function formatDate(dateString) {
    try {
        if (dateString) {
            const date = new Date(dateString);
            const day = String(date.getDate()).padStart(2, '0');
            const month = String(date.getMonth() + 1).padStart(2, '0');
            const year = date.getFullYear();
            return `${day}-${month}-${year}`;
        } else {
            return ""; // Return empty string if date string is null or empty
        }
    } catch (error) {
        console.error('Error formatting date:', error);
        return dateString; // Return original date string if unable to parse
    }
}
</script>    
						 			<%
									int i = 1;
						 			
						 			
						 			
								for(Object[] row : allUserRegistration ){
									
									if (i <= 200) {
									%>
									<tr>
										<td><%=i%></td>
										<td><%= row[0] %></td>
										<%-- <td><%= row[1] %></td> --%>
										<td><%= row[2] %></td>
										<td><%= row[3] %></td>
										<td><%= row[4] %></td>
								
										
									  
										
										<td><%= row[5] %></td>
										<td><%= row[6] %></td>
										<td><%= row[7] %></td>
										<td><%= row[8] %></td>
										<td><%= row[9] %></td>
										<td><%= row[10] %></td>
										<td><%= row[11] %></td>
										<td><%= row[12] %></td>
										<td><%= row[13] %></td>
										<td><%= row[14] %></td>
										<td><%= row[15] %></td>
										<td><%= row[16] %></td>
										<td><%= row[17] %></td>
										<td><%= row[18] %></td>
										<td><%= row[19] %></td>
										<td><%= row[20] %></td>
										<td><%= row[21] %></td>
										<td><%= row[22] %></td>
										<td><%= row[23] %></td>
										<td><%= row[24] %></td>
										<td><%= row[25] %></td>
										
											<td>
									    <a href="EntryofGenerationBillsupply.obj?id=<%=row[0]%>&millname=<%= row[12]%>">
									        <button class="btn btn-primary custom-button" type="button">Generate BOS</button>
									    </a>
									</td> 
										
							    </tr>
									<%
										}
									   i++;
										} 
								
								
										%>
		
									 
									
								</tbody>

                        </table>
                        
                     
                     </div>
                   </div>
                 </div>
            </div>
            <!-- END PAGE CONTENT-->
            <%@ include file="footer.jsp"%>
        </div>
    </div>
    
    
 
    <!-- BEGIN THEME CONFIG PANEL-->
     
    <!-- END THEME CONFIG PANEL-->
    <!-- BEGIN PAGA BACKDROPS-->
    <div class="sidenav-backdrop backdrop"></div>
    

    
 

    
    <!-- END PAGA BACKDROPS-->
    <!-- CORE PLUGINS-->
    <script src="./assets/vendors/jquery/dist/jquery.min.js" type="text/javascript"></script>
    <script src="./assets/vendors/popper.js/dist/umd/popper.min.js" type="text/javascript"></script>
    <script src="./assets/vendors/bootstrap/dist/js/bootstrap.min.js" type="text/javascript"></script>
    <script src="./assets/vendors/metisMenu/dist/metisMenu.min.js" type="text/javascript"></script>
    <script src="./assets/vendors/jquery-slimscroll/jquery.slimscroll.min.js" type="text/javascript"></script>
    <!-- PAGE LEVEL PLUGINS-->
    <script src="./assets/vendors/DataTables/datatables.min.js" type="text/javascript"></script>
    <!-- CORE SCRIPTS-->
    <script src="assets/js/app.min.js" type="text/javascript"></script>
    <script>
    $(document).ready(function() {
        setTimeout(function() {
            $('#flashMessage').fadeOut('slow');
        }, 3000);
    });
</script>
    <!-- PAGE LEVEL SCRIPTS-->
    <script type="text/javascript">
        $(function() {
            $('#example-table').DataTable({
                pageLength: 10,
                //"ajax": './assets/demo/data/table_data.json',
                /*"columns": [
                    { "S": "name" },
                    { "data": "office" },
                    { "data": "extn" },
                    { "data": "start_date" },
                    { "data": "salary" }
                ]*/
            });
        })
    </script>

</body>

</html>


























