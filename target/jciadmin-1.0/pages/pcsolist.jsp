<%@page import="com.jci.model.EntryofpcsoModel"%>
<%@page import="java.util.List"%>


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

<script src="./assets/vendors/DataTables/datatables.min.js"
	type="text/javascript"></script>

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
				<h1 class="page-title">PCO List</h1>
			</div>
			<%
			List<EntryofpcsoModel> pcsoList = (List<EntryofpcsoModel>) request.getAttribute("pcsolist");
			List<String> refNos = (List<String>) request.getAttribute("refNos");
			%>
			<div class="page-content fade-in-up">
				<div class="accordion" id="accordionExample">
					<%
					int i = 1;
					for (String refNo : refNos) {
					%>

					<div class="card">
						<div class="card-header" id="heading<%=i%>">
							<h5 class="mb-0">
								<button class="btn text-dark btn-link" type="button"
									onclick="findDetails('<%=refNo%>','<%=i%>')"
									data-toggle="collapse" data-target="#collapse<%=i%>"
									aria-expanded="false" aria-controls="collapse<%=i%>">
									JC Office Ref. No.&nbsp &nbsp
									<%=refNo%></button>
							</h5>
						</div>

						<div id="collapse<%=i%>" class="collapse"
							aria-labelledby="heading<%=i%>" data-parent="#accordionExample">
							<div id="table<%=i%>"></div>
						</div>


					</div>
					<%
					i++;
					}
					%>
				</div>
			</div>
			<!-- END PAGE CONTENT-->
			<%@ include file="footer.jsp"%>

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
			/* 	$(function() {
					$('#example-table').DataTable({

						fixedHeader : true

					});
				}) */

			function findDetails(refNo, id) {

				$
						.ajax({
							type : "GET",
							url : "getAllMillDetails.obj",
							data : {
								"refNo" : refNo
							},
							success : function(result) {
								var data = jQuery.parseJSON(result);
								var tableData = "<table class='table table-striped table-bordered table-hover id='example-table' cellspacing='0' width='100%'>";

								tableData += "<thead><tr>" + "<th>S.N.</th>"
										+ "<th>Reference Date</th>"
										+ "<th>JCI letter Ref.</th>"
										+ "<th>PCSO Date</th>"
										+ "<th>PCSO Qty. (M.T)</th>"
										+ "<th>Delivery Period</th>"
										+ "<th>Mill Code</th>"
										+ "<th>Mill Name</th>"
										+ "<th>Allocation</th>"
										+ "</tr></thead>";

								tableData += "<tbody id='tbody'>";

								for (var i = 0; i < data.length; i++) {
									var count = i + 1;

									tableData += "<tr><td>" + count + "</td>";

									tableData += "<td>" + data[i].pcso_date
											+ "</td>";
									tableData += "<td>" + data[i].letterRef
											+ "</td>";
									tableData += "<td>" + data[i].pcso_date
											+ "</td>";
									tableData += "<td>" + data[i].pcsoQty
											+ "</td>";
									tableData += "<td>"
											+ data[i].deliveryPeriod + "</td>";
									tableData += "<td>" + data[i].mill_code
											+ "</td>";
									tableData += "<td>" + data[i].mill_name
											+ "</td>";
									tableData += "<td>" + data[i].allocatedQty
											+ "</td>";
									tableData += "<td><a href='updatePcso.obj?pcsorefid="
											+ data[i].pcsorefid
											+ "' class='btn btn-warning btn-sm btn-block'><i class='fa fa-pencil' aria-hidden='true' style='font-size: 15px;'></i></a></td>";
									tableData += "<td><a href='pcsoDelete.obj?pcsorefid="
											+ data[i].pcsorefid
											+ "' class='btn btn-danger btn-sm btn-block'><i class='fa fa-trash' aria-hidden='true' style='font-size: 15px;'></i></a></td>";
									tableData += "</tr>";
								}
								tableData += "</tbody></table>";
								$("#table" + id).html(tableData);

							}
						})

			}
		</script>
	</div>

</body>

</html>
