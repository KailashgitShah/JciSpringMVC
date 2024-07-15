<%@page import="java.util.HashMap"%>
<%@page import="java.util.List"%>
<%@page import="java.io.File"%>
<%@page import="com.jci.model.ZoneModel"%>
<%@page import="com.jci.model.VerifyFarmerModel"%>
<%@page import="com.jci.model.FarmerRegModelDTO"%>
<%@page import="com.jci.model.StateList"%>
<%@page isELIgnored="false"%>
<%@page import="java.math.BigDecimal"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
<%
				List<Object[]> hoDiList = (List<Object[]>) request.getAttribute("AllList");
				%>
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
				<h1 class="page-title">DI HO List</h1>
			</div>


			<div class="row"></div>
			<c:if test="${not empty msg}">
				<div class="">${msg}</div>
			</c:if>
			<div class="table-responsive" style="margin-top: 20px;">
				<table id="farmerVerific"
					class="table table-striped table-bordered table-hover"
					cellspacing="0">
					<thead>
						<tr>
							<th>S.No</th>
							<th>Contract No.</th>
							<th>Regional Office </th>
							<th>Last date of Shipment</th>
							<th>DI No</th>
							<th>DI Date</th>
							<th>Jute Variety</th>
							<!-- <th>Grade Wise Allocation</th> -->
							<th>Grade-1</th>
							<th>Grade-2</th>
							<th>Grade-3</th>
							<th>Grade-4</th>
							<th>Grade-5</th>
							<th>Grade-6</th>
							<th>Grade-7</th>
							<th>Grade-8</th>
							<th>Total</th>
							<th>Delete</th>
						</tr>
					</thead>
					<tbody>
						<%
						int i = 1;
						for (Object[] row : hoDiList) {
							String s1 = (String)row[10];
						%>
						
							<tr>
								<td class="sorting_1" style="text-align: center"><%=i%></td>
								<td style="text-align: center"><%= row[4] %></td>
								<td style="text-align: center"><%= row[0] %></td>
								<td style="text-align: center"><%= row[22] %></td>
								<td style="text-align: center"><%= row[10] %></td>
								<td style="text-align: center"><%= row[9] %></td>
								<td style="text-align: center"><%= row[21] %></td>
								<td style="text-align: center"><%= row[13] %></td>
								<td style="text-align: center"><%= row[14] %></td>
								<td style="text-align: center"><%= row[15] %></td>
								<td style="text-align: center"><%= row[16] %></td>
								<td style="text-align: center"><%= row[17] %></td>
								<td style="text-align: center"><%= row[18] %></td>
								<td style="text-align: center"><%= row[19] %></td>
								<td style="text-align: center"><%= row[20] %></td>
							<td style="text-align: center">
    <%-- Calculate the sum of values from row[13] to row[20] --%>
    <% BigDecimal sum = BigDecimal.ZERO;
    for(int j = 13; j <= 20; j++) {
        sum = sum.add((BigDecimal)row[j]);
    }
    out.print(sum); // Output the sum in the <td> element
    %>
</td>
	<td><a href="deleteHO.obj?id=<%= s1 %>"
									onclick="return confirm('Are you sure you want to delete this item?');"><i
										class="btn btn-danger btn-sm btn-block"><i
											class="fa fa-trash" aria-hidden="true"
											style="font-size: 15px;"></i></i></a></td>
							</tr>
							<%
							i++;}
							%>
						
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

