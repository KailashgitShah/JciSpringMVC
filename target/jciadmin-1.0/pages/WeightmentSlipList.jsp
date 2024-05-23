<%@page import="java.util.HashMap"%>
<%@page import="java.util.List"%>
<%@page import="java.io.File"%>
<%@page import="com.jci.model.ZoneModel"%>
<%@page import="com.jci.model.VerifyFarmerModel"%>
<%@page import="com.jci.model.FarmerRegModelDTO"%>
<%@page import="com.jci.model.StateList"%>
<%@page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.text.SimpleDateFormat" %>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width initial-scale=1.0">
<title>JCI | CMS</title>
<!-- GLOBAL MAINLY STYLES-->
<link href="./assets/vendors/bootstrap/dist/css/bootstrap.min.css"
	rel="stylesheet" />
<link href="./assets/vendors/font-awesome/css/font-awesome.min.css"
	rel="stylesheet" />
<link href="./assets/vendors/themify-icons/css/themify-icons.css"
	rel="stylesheet" />
<!-- PLUGINS STYLES-->
<link href="./assets/vendors/DataTables/datatables.min.css"
	rel="stylesheet" />
<!-- THEME STYLES-->
<link href="assets/css/main.min.css" rel="stylesheet" />
<!-- PAGE LEVEL STYLES-->
<style>
table {
	border-collapse: collapse;
	width: 100%;
}

th, td {
	text-align: left;
	padding: 8px;
}

tr:nth-child(even) {
	background-color: #f2f2f2;
}
</style>

<script src="https://code.jquery.com/jquery-1.11.3.min.js"
	type="text/javascript"></script>
<script
	src="https://cdn.datatables.net/1.10.9/js/jquery.dataTables.min.js"
	type="text/javascript"></script>
<link rel="stylesheet"
	href="https://cdn.datatables.net/1.10.9/css/jquery.dataTables.min.css" />
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		$("#farmerVerific").DataTable({
			scrollX : true,
			"pageLength" : 50
		});
	});
</script>
</head>
<% List<Object[]> WeightmentList = (List<Object[]>) request.getAttribute("WeightmentList");%>
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
				<h1 class="page-title">Weightment List</h1>
			</div>


			<div class="row"></div>
			<c:if test="${not empty msg}">
				<div class="">${msg}</div>
			</c:if>
			<div class="table-responsive" style="margin-top: 20px;">
		<table id="farmerVerific" class="table table-striped table-bordered table-hover" cellspacing="0">
    <thead>
        <tr>
            <th>S.No</th>
            <th>Bill of Supply no</th>
            <th>Bill of Supply date</th>
           <th>Nominal Weight(Qtls)</th>
            <th>DPC End Actual Weight (Qtls)</th>
            <th>Mill End Actual Weight (Qtls)</th>
            <th>PC End Truck Gross Weight</th>
            <th>DPC End Truck Tare Weight</th>
            <th>DPC End Truck Net Weight</th>
            <th>DPC Wt Document</th>
            <th>Mill Wt Document</th>
            <th>Mill Receipt Document</th>
            <th>Bill of Supply</th>
            <th>Challan document</th>
        </tr>
    </thead>
   <tbody>
    <% int i = 1;
    SimpleDateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd"); // Assuming the current format of row[1] is yyyy-MM-dd
    SimpleDateFormat outputFormat = new SimpleDateFormat("dd-MM-yyyy"); // Desired output format
       for (Object[] row : WeightmentList) { %>
    <tr>
        <td class="sorting_1" style="text-align: center"><%= i %></td>
       
            <% if ((int)row[10] == 0) { %>
             <td style="text-align: center">
                <a href="WeightmentById.obj?id=<%= row[2] %>"><%= row[2] %></a>  </td>
            <% } else { %>
              <td style="text-align: center;color:green" > <%= row[2] %></td>
            <% } %>
      
          <td style="text-align: center"><%= outputFormat.format(inputFormat.parse(row[1].toString())) %></td>
        <td style="text-align: center"><%= row[7] %></td> 
        <td style="text-align: center"><%= row[4] %></td> 
        <td style="text-align: center"><%= row[6] %></td> 
        
        <td style="text-align: center"><%= (row[13] != null) ? row[13] : '-' %></td> 
       <td style="text-align: center"><%= (row[15] != null) ? row[15] : '-' %></td> 
        <td style="text-align: center"><%= (row[14] != null) ? row[14] : '-' %></td> 
        <td>  <a href="http://49.50.118.112:8080/WeightSlipment/<%= row[5] %>" target="_blank">DPC Wt Document</a></td>

        <td style="text-align: center"><a href="http://49.50.118.112:8080/WeightSlipment/<%= row[12] %>"  target="_blank">Mill Weight Document</a></td> 
        <td style="text-align: center"><a href="http://49.50.118.112:8080/WeightSlipment/<%= row[11] %>"  target="_blank">Mill Receipt Document</a></td> 
        <td style="text-align: center"><a href="http://49.50.118.112:8080/WeightSlipment/<%= row[19] %>"  target="_blank">Bill Of Supply</a></td>
        <td style="text-align: center"><a href="http://49.50.118.112:8080/DispatchDetail/<%= row[48] %>"  target="_blank">Challan Document</a></td>
    </tr>
    <% i++; } %>
</tbody>

</table>


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
	<script src="./assets/vendors/jquery/dist/jquery.min.js"
		type="text/javascript"></script>
	<script src="./assets/vendors/popper.js/dist/umd/popper.min.js"
		type="text/javascript"></script>
	<script src="./assets/vendors/bootstrap/dist/js/bootstrap.min.js"
		type="text/javascript"></script>
	<script src="./assets/vendors/metisMenu/dist/metisMenu.min.js"
		type="text/javascript"></script>
	<script
		src="./assets/vendors/jquery-slimscroll/jquery.slimscroll.min.js"
		type="text/javascript"></script>
	<!-- PAGE LEVEL PLUGINS-->
	<script src="./assets/vendors/DataTables/datatables.min.js"
		type="text/javascript"></script>
	<!-- CORE SCRIPTS-->
	<script src="assets/js/app.min.js" type="text/javascript"></script>
	<!-- PAGE LEVEL SCRIPTS-->







</body>

</html>

