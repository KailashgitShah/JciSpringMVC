

<%@page import="java.util.HashMap"%>
<%@page import="java.util.List"%>
<%@page import="java.io.File"%>
<%@page import="com.jci.model.OperationAndTransportCostModel"%>

<%@page import="com.jci.model.UserRegistrationModel"%>

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
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<!-- PLUGINS STYLES-->
<link href="./assets/vendors/DataTables/datatables.min.css"
	rel="stylesheet" />
<!-- THEME STYLES-->
<link href="assets/css/main.min.css" rel="stylesheet" />
<!-- PAGE LEVEL STYLES-->
<script type="text/javascript">
	$(document).ready(function() {
		$("#farmerVerific").DataTable({
			scrollX : true,
			"pageLength" : 50
		});
	});
</script>
<style>
.ibox {
	padding: 0 0px;
}

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
				<h1 class="page-title">View Transportation and Operation Cost</h1>

			</div>

			<%
			List<Object[]> Modulelist = (List<Object[]>) request.getAttribute("list");
			String basis = (String) request.getAttribute("basis");
			%>
			<div class="page-content fade-in-up">
				<div class="ibox">
					<span>${msg}</span>
					<div class="ibox-body">
						<div class="scrollmenu">
							<table
								class="table table-striped table-bordered table-hover tableFixHead"
								id="example-table" cellspacing="0" width="850px">
								<thead>

									<tr>
										<th style="text-align: center">S.No</th>
										<th style="text-align: center">Basis</th>
										<th style="text-align: center">Crop Year</th>
										<th style="text-align: center">Regional Office</th>
										<th style="text-align: center">DPC</th>
										<th style="text-align: center">Operation Cost Head</th>
										<th style="text-align: center">Rate(Qtls)</th>
										<th style="text-align: center">Unit</th>
										<!-- <th>Grade Wise Allocation</th> -->
										<th style="text-align: center">Valid Till</th>
										<th style="text-align: center">Delete</th>

									</tr>
								</thead>
								<tbody>

									<%
									for (Object[] row : Modulelist) {
									%>
									<%
									int i = 1;
									%>
									<tr>
										<%
										String s = "";
										%>
										<td class="sorting_1" style="text-align: center"><%=i%></td>
										<%-- <td style="text-align: center"><%=row[7]%></td> --%>
										<td><%=basis%></td>										<td style="text-align: center"><%=row[0]%></td>
										<td style="text-align: center"><%=row[1]%></td>

										<%
										String entriesString = (String) row[2];
										String[] entries = entriesString.split(",");
										String combinedEntries = "";
										for (int j = 0; j < entries.length; j++) {
											String[] parts = entries[j].split("!");
											String textAfterExclamation = parts[1].trim(); // Extract text after '!'
											combinedEntries += textAfterExclamation;

											// Append comma only if it's not the last entry
											if (j < entries.length - 1) {
												combinedEntries += ", ";
											}
										}
										%>



										<td style="text-align: center"><%=combinedEntries%></td>
										<td style="text-align: center"><%=row[3]%></td>
										<td style="text-align: center"><%=row[4]%></td>
										<td style="text-align: center"><%=row[5]%></td>
										<td style="text-align: center"><%=row[6]%></td>
										<%--  <td style="text-align: center"><%= row[8] %></td> --%>
										<td><a
											href="transportationOperationDelete.obj?id=<%=row[8]%>"
											class="btn btn-danger btn-sm btn-block"
											onclick="return confirm('Are you sure you want to delete this Transportation and Operation Cost')">Delete</a></td>
									</tr>
									<%
									i++;
									%>
									<%
									} // end of outer for loop
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

