
<%@page import="java.util.HashMap"%>
<%@page import="java.util.List"%>
<%@page import="java.io.File"%>

<%@page import="java.util.Date"%>
<%@page isELIgnored="false"%>
<%@page import="java.math.BigDecimal"%>
<%@page import="com.jci.common.Encry"%>
<%@page import="com.jci.controller.LoginController"%>
<%@ page import="java.text.SimpleDateFormat"%>
<%@ page import="java.text.ParseException"%>
<%@ page import="java.util.Date"%>
<%@ page import="java.util.List"%>

<%@ page contentType="text/html; charset=UTF-8"%>
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
String key = LoginController.secretkey;
List<Object[]> list = (List<Object[]>) request.getAttribute("Data");
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
				<h1 class="page-title">Non-Active Bids List</h1>
			</div>




			<div class="table-responsive" style="margin-top: 20px;">
				<table id="farmerVerific"
					class="table table-striped table-bordered table-hover">
					<thead>
						<tr>
							<th>S.No</th>
							<th>Bid Reference No.</th>
							<th>Bid Opening Date & Time</th>
							<th>Bid Closing Date & Time</th>
							<th>Bid Status</th>
							<th>Basis</th>

							<!-- <th>Bid Roll out</th> -->

							<th>Edit</th>
							<th>Delete</th>

							<!--   <th>Edit</th> -->

						</tr>
					</thead>
					<tbody>
						<%
						int i = 1;
						for (Object[] row : list) {
							System.err.println(row[4]);
							/* String encryptedid = Encry.encrypt(String.valueOf(row[4]), key);
							
							System.err.println(encryptedid); */
						%>

						<tr>
							<td class="sorting_1" style="text-align: center"><%=i%></td>
							<td style="text-align: center"><%=row[4]%></td>


							<td style="text-align: center"><%=row[3]%></td>

							<td style="text-align: center"><%=row[2]%></td>

							<%
							if ((Integer) row[5] == 2) {
							%>
							<td style="text-align: center">Proposed</td>
							<%
							} else {
							%>
							<td style="text-align: center">Completed</td>
							<%
							}
							%>
							<td style="text-align: center"><%=row[1]%></td>
							<%
							if ((Integer) row[5] == 2) {
							%>
							<td><a href="editNonActiveBid.obj?id=<%=row[4]%>">Edit
									Details</a></td>
							<td><a href="deleteBid.obj?id=<%=row[4]%>">Delete Bid</a></td>
							<%
							} else {
							%>
							<td>-</td>
							<td>-</td>

							<%
							}
							%>

						</tr>

						<%
						i++;
						}
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


