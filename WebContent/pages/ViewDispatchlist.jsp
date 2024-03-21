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
			List<dispatchdetailModel> allUserRegistration = (List<dispatchdetailModel>)request.getAttribute("viewDispatchChallan");
	
		%>
                  <div class="page-content fade-in-up">
                <div class="ibox">
                    <div class="ibox-head">
                    <span>${msg}</span>
                        <div class="ibox-title"></div>
                    </div>
                    <div class="ibox-body">
                      <div class="scrollmenu">
                        <table class="table table-striped table-bordered table-hover" id="example-table" cellspacing="0" width="100%">
                               <thead>
									<tr>
										<th>Sl.No</th>
										<th>BIN No.</th>
										<th>Bale mark</th>
										<th>Challan_no</th>
										<th>Consignment_note</th>
										<th>Contract_No</th>
										<th>Contract_date</th>
										<th>Creation_date</th>
										<th>Crop_year</th>
										<th>DI_Date</th>
										<th>DI_No</th>
										<th>Date_of_shipment</th>
										<th>Di_status</th>
										<th>Driver_contact</th>
										<th>Driver_name</th>
										<th>Jute_grade</th>
										<th>Jute_value</th>
										<th>Jute_variety</th>
										<th>License_no</th>
										<th>Mill_name</th>
										<th>Mode_of_shipment</th>
										<th>No_of_bales</th>
										<th>Nominal_qty</th>
										<th>Nominal_wt</th>
										<th>Place_of_Shipment</th>
											<th>Rate</th>
										<th>Vehicle_no</th>
										
									</tr>
								</thead>
                           <tbody>
									<%
									int i = 1;
								
									for (dispatchdetailModel  dispatchdetailentry : allUserRegistration) {

										if (i <= 200) {
											
									%>
									<tr>
										<td><%=i%></td>
										<td><%= dispatchdetailentry.getBIN_no() %></td>
										<td><%= dispatchdetailentry.getBale_mark()%></td>
										<td><%= dispatchdetailentry.getChallan_no()%></td>
										<td><%= dispatchdetailentry.getConsignment_note()%></td>
										<td><%= dispatchdetailentry.getContract_No() %></td>
										<td><%= dispatchdetailentry.getContract_date() %></td>
										<td><%= dispatchdetailentry.getCreation_date() %></td>
										<td><%= dispatchdetailentry.getCrop_year()%></td>
										<td><%= dispatchdetailentry.getDI_Date()%></td>
										 <td><%=dispatchdetailentry.getDI_No() %></td>
										<td><%= dispatchdetailentry.getDate_of_shipment() %></td>
										<td><%= dispatchdetailentry.getDi_status()%></td>
										<td><%= dispatchdetailentry.getDriver_contact()%></td>
										 <td><%=dispatchdetailentry.getDriver_name() %></td>
										<td><%= dispatchdetailentry.getJute_grade()%></td>
										<td><%= dispatchdetailentry.getJute_value()%></td>
										<td><%= dispatchdetailentry.getJute_variety() %></td>
										<td><%= dispatchdetailentry.getLicense_no() %></td>
										<td><%= dispatchdetailentry.getMill_name()%></td>
									    <td><%= dispatchdetailentry.getMode_of_shipment()%></td>
										 <td><%=dispatchdetailentry.getNo_of_bales() %></td>
										<td><%= dispatchdetailentry.getNominal_qty() %></td>
										<td><%= dispatchdetailentry.getNominal_wt() %></td>
										<td><%= dispatchdetailentry.getPlace_of_Shipment()%></td>
										 <td><%=dispatchdetailentry.getRate() %></td>
										<td><%= dispatchdetailentry.getRegional_Office()%></td>
										<td><%= dispatchdetailentry.getVehicle_no() %></td>
								
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
    
    
    
 
<script>
    function openRejectModal(contractNo) {
        $('#rejectModalButton').data('contractNo', contractNo);
        $('#rejectModal').modal('show');
    }

    function closeRejectModal() {
        $('#rejectModal').modal('hide');
    }

    function rejectAndNavigate(contractNo, paymentId) {
        openRejectModal(contractNo)
    
        $('#rejectModalButton').off('click').on('click', function () {
            var remarks = $('#remarks').val().trim();

            if (remarks === "") {
                return;
            }
            $.ajax({
                type: 'POST',
                url: 'saveRemarks.obj',
                data: {
                    "remarks": remarks,
                    "con_no": contractNo,
                    "id": paymentId
                },
                success: function (data) {
                    var responseData = JSON.parse(data);
						 if (responseData.redirect) {
                        window.location.href = responseData.redirect;
                    } else {
                        
                    }
                },
                error: function (error) {
                    console.error('Ajax error:', error);
                }
            });


            closeRejectModal(); 
        });
    }
</script>
    
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


























