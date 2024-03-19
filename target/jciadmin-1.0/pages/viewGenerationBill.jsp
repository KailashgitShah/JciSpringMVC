<%@page import="com.jci.model.GenerationOfBillSupplyModel"%>
<%@page import="com.jci.model.MillRecieptModel"%>
<%@page import="com.jci.model.EntryPaymentDetailsModel"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.List"%>
<%@page import="java.io.File"%>
<%@page import="com.jci.model.RoleMasterModel"%>
<%@page import="com.jci.model.ZoneModel"%>
 <%@ page import="org.springframework.web.servlet.support.RequestContextUtils" %>
<%@page isELIgnored="false"%>
<%@ page import="java.net.URLEncoder" %>

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
    	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    <!-- PLUGINS STYLES-->
    <link href="./assets/vendors/DataTables/datatables.min.css" rel="stylesheet" />
    <!-- THEME STYLES-->
    <link href="assets/css/main.min.css" rel="stylesheet" />
    <!-- PAGE LEVEL STYLES-->
    
<style>
.scrollmenu {
	overflow: scroll;
	white-space: nowrap;
}

.scrollmenu a {
	display: inline-block;
	color: white;
	text-align: center;
	padding: 14px;
	text-decoration: none;
}

.tableFixHead {
	overflow: auto;
	height: 100px;
	width: 240px;
}

.tableFixHead thead th {
	position: sticky;
	top: 0;
	z-index: 1;
}

.tableFixHead tbody th {
	position: sticky;
	left: 0;
}

table {
	border-collapse: collapse;
	width: 100%;
}

th, td {
	padding: 8px 16px;
	white-space: nowrap;
}

th {
	background: #eee;
}
</style>

<script type="text/javascript">
	$(document).ready(function() {
		$("#farmerVerific").DataTable({
			scrollX : true,
			"pageLength" : 50
		});
	});
</script>
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
				<h1 class="page-title">View  Generation of bill List</h1>

			</div>

			<%
			/* List<MillRecieptModel> millList = (List<MillRecieptModel>)request.getAttribute("millRecieptModel"); */
			List<GenerationOfBillSupplyModel> GenerationofbillList = (List<GenerationOfBillSupplyModel>)request.getAttribute("GenerationOfBill");
			
			
			
		%>
		
		
			
		
	    
			
			<div class="page-content fade-in-up">
				<div class="ibox">
					<span>${msg}</span>
					<div class="ibox-body">
						<div class="scrollmenu">
							<table
								class="table table-striped table-bordered table-hover tableFixHead"
								id="example-table" cellspacing="0" width="100%">


								<thead>
									<tr>
										<th>Sl.No</th>
										<th>Challan No </th>
										<th>Challan Date</th>
										<th>Shipment Details</th>
										<th>Shipment Value</th>
										<th>SGST Amt</th>
										<th>CGST Amt</th>
										<th>IGST Amt</th>
										<th>TCS Amt</th>
										<th>TDS Amt</th>
										<th>Invoice Value</th>
										<th>Bill of Supply No</th>
										<th>BOS Date</th>
								        <th>Supplier Name</th>
										<th>Supplier GSTN</th>
										<th>Supplier Address</th>
										<th>Recipient Name</th>
										<th>Recipient GSTN</th>
										<th>Recipient Address</th>
										<th>Consignee Name</th>
										<th>Consignee GSTN</th>
										<th>Consignee Address</th>

									</tr>
								</thead>
								<tbody>
									<%
									int i = 1;
									for (GenerationOfBillSupplyModel  generationOfBillSupplyModel : GenerationofbillList) {

										if (i <= 200) {
									%>
									<tr>
										<td><%=i%></td>
										<td><%= generationOfBillSupplyModel.getChallan_No() %></td>
										<td><%= generationOfBillSupplyModel.getChallan_date() %></td>
										<td><%= generationOfBillSupplyModel.getShipment_details() %></td>
										<td><%= generationOfBillSupplyModel.getShipment_value() %></td>
										<td><%= generationOfBillSupplyModel.getSGST_amt() %></td>
										<td><%= generationOfBillSupplyModel.getCGST_amt() %></td>
										<td><%= generationOfBillSupplyModel.getIGST_amt() %></td>
										<td><%= generationOfBillSupplyModel.getTCS_amt() %></td>
										<td><%= generationOfBillSupplyModel.getTDS_amt() %></td>
										<td><%= generationOfBillSupplyModel.getInvoice_value() %></td>
										<td><%= generationOfBillSupplyModel.getBill_of_supply_no() %></td>
										<td><%= generationOfBillSupplyModel.getBOS_date() %></td>
										<td><%= generationOfBillSupplyModel.getSupplier_name() %></td>
										<td><%= generationOfBillSupplyModel.getSupplier_gSTN() %></td>
										<td><%= generationOfBillSupplyModel.getSupplier_address() %></td>
										<td><%= generationOfBillSupplyModel.getRecipient_name() %></td>
										<td><%= generationOfBillSupplyModel.getRecipient_gSTN() %></td>
										<td><%= generationOfBillSupplyModel.getRecipient_address() %></td>
										
										<td><%= generationOfBillSupplyModel.getConsignee_name() %></td>
										<td><%= generationOfBillSupplyModel.getConsignee_gSTN()%></td>
										<td><%= generationOfBillSupplyModel.getConsignee_address() %></td>
										
										
							
										
                                       <td>
								            <a href="downloadPDF.obj?filename=<%= generationOfBillSupplyModel.getBos_file_path()%>"
								               class="btn btn-primary btn-sm" target="_blank"> Generate BOS</a>
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

				fixedHeader : true

			//"ajax": './assets/demo/data/table_data.json',
			/*"columns": [
			    { "S": "name" },
			    { "data": "office" },
			    { "data": "extn" },
			    { "data": "start_date" },
			    { "data": "salary" }
			] */
			});
		})
	</script>
</body>

</html>

