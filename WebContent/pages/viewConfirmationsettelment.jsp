
<%@page import="com.jci.model.ConfirmationClaimSettlementModel"%>

<%@page import="java.util.HashMap"%>
<%@page import="java.util.List"%>
<%@page import="java.io.File"%>
<%@page import="com.jci.model.RoleMasterModel"%>
<%@page import="com.jci.model.ZoneModel"%>
<%@page isELIgnored="false"%>

<%@ page import="java.text.SimpleDateFormat"%>


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
				<h1 class="page-title">View Confirmation of Claim Settlement</h1>

			</div>

			<%
			List<ConfirmationClaimSettlementModel> allUserRegistration = (List<ConfirmationClaimSettlementModel>) request
					.getAttribute("confirmationClaim");
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
										<th style="text-align: center">Sl.No</th>
										<th style="text-align: center">Settlement Id.</th>
										<!-- <th style="text-align:center">Date of inspection</th> -->
										<th style="text-align: center">Contract No.</th>
										<th style="text-align: center">Challan No</th>

										<th style="text-align: center">Quality Settlement</th>
										<th style="text-align: center">Moisture Settlement</th>
										<th style="text-align: center">NCV Settlement</th>
										
										<th style="text-align: center">Settlement Amount</th>
										<th style="text-align: center">Inspection by</th>
										<th style='text-align: center'>Supporting Document</th>


									</tr>
								</thead>
								<tbody>
									<%
									int i = 1;
									for (ConfirmationClaimSettlementModel confirmationClaimSettlementModel : allUserRegistration) {

										if (i <= 200) {
									%>
									<tr>
										<td><%=i%></td>
										<td style="text-align: center"><%=confirmationClaimSettlementModel.getSettlement_id()%></td>
										<%-- <td style="text-align:center"><%= new SimpleDateFormat("dd-MM-yyyy").format(confirmationClaimSettlementModel.getDate_of_Inspection()) %></td> --%>
										<td style="text-align: center"><%=confirmationClaimSettlementModel.getContract_No()%></td>
										<td style="text-align: center"><%=confirmationClaimSettlementModel.getChallan_No()%></td>
										<td style="text-align: center"><%=confirmationClaimSettlementModel.getQuality_settlement()%></td>
										<td style="text-align: center"><%=confirmationClaimSettlementModel.getMoisture_settlement()%></td>
										<td style="text-align: center"><%=confirmationClaimSettlementModel.getNcv_settlement()%></td>
										
										<td style="text-align: center"><%=confirmationClaimSettlementModel.getSettlement_amt()%></td>
										<td style="text-align: center"><%=confirmationClaimSettlementModel.getInspection_by()%></td>
										<%-- <td style="text-align:center"><%= confirmationClaimSettlementModel.getSupporting_doc() %></td> --%>
										<td><a
											href="downloadSupportDocument.obj?filename=<%=confirmationClaimSettlementModel.getSupporting_doc()%>"
											class="btn btn-primary btn-sm" target="_blank"> View
												Supporting docs</a></td>



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