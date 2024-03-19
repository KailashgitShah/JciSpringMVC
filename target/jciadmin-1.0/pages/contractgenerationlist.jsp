<%@page import="com.jci.model.Contractgeneration"%>
<%@page import="com.jci.model.EntryDerivativePrice"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.List"%>
<%@page import="java.io.File"%>

<%@page import="com.jci.model.RawJuteProcurementAndPayment"%>

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
<script>
	$(document).ready(function() {
		alert();
		var table = $('#example-table').DataTable({
			scrollY : "300px",
			scrollX : true,
			scrollCollapse : true,
			paging : false,
			fixedColumns : {
				left : 1,
				right : 1
			}
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
				<h1 class="page-title">All Contracts</h1>
			</div>
			<%
			List<Contractgeneration> contracts = (List<Contractgeneration>) request.getAttribute("contracts");
			%>
			<div class="page-content fade-in-up">
				<table class="w-100 text-center">
					<thead>
						<tr class="row p-3">
							<th class="col-sm-3 text-center">S.N.</th>
							<th class="col-sm-3 text-center">Contract Identification No</th>
							<th class="col-sm-3 text-center">Contract Date</th>
							<th class="col-sm-3 text-center">Contracted Qty</th>
							<!-- <th class="col-sm-3 text-center">Contracted Value</th> -->
						</tr>
					</thead>
				</table>
				<div class="accordion" id="accordionExample">
					<%
					int i = 1;
					for (Contractgeneration contract : contracts) {
					%>

					<div class="card">
						<div class="card-header" id="heading<%=i%>">
							<h5 class="mb-0">
								<button class="btn text-dark btn-link w-100" type="button"
									onclick="findDetails('<%=contract.getContract_identification_no()%>','<%=i%>')"
									data-toggle="collapse" data-target="#collapse<%=i%>"
									aria-expanded="false" aria-controls="collapse<%=i%>">

									<div class="row">
										<div class="col-sm-3"><%=i%></div>
										<div class="col-sm-3"><%=contract.getContract_identification_no()%></div>
										<div class="col-sm-3"><%=contract.getContract_date()%></div>
										<div class="col-sm-3"><%=contract.getContract_qty()%></div>
									</div>

								</button>
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
		$(function() {
			$('#example-table').DataTable({
				pageLength : 10,
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

	<script type="text/javascript">
		function findDetails(contractId, id) {

			$
					.ajax({
						type : "GET",
						url : "getAllContractDetails.obj",
						data : {
							"contract" : contractId
						},
						success : function(result) {
							var data = jQuery.parseJSON(result);
							var path = contractId + "\\";

							var tableData = "<table class='table table-striped table-bordered table-hover id='example-table' cellspacing='0' width='100%'>";

							tableData += "<thead><tr>" + "<th>S.N.</th>"
									+ "<th>Mill Code</th>"
									+ "<th>Mill Name</th>"
									+ "<th>Allocated Qty(Qtls.)</th>"
									+ "<th>Grade Composition</th>"
									+ "<th>PCSO Date</th>"
									+ "<th>Delivery Period</th>"
									+ "</tr></thead>";

							tableData += "<tbody id='tbody'>";

							for (var i = 0; i < data.length; i++) {
								var count = i + 1;
								var filePath = path
										+ data[i].Contract_acceptance_doc;

								tableData += "<tr><td>" + count + "</td>";

								tableData += "<td>" + data[i].Mill_code
										+ "</td>";
								tableData += "<td>" + data[i].Mill_name
										+ "</td>";
								tableData += "<td>" + data[i].Mill_qty
										+ "</td>";
								tableData += "<td>" + data[i].Grade_composition
										+ "</td>";
								tableData += "<td>" + data[i].Pcso_date
										+ "</td>";
								tableData += "<td>" + data[i].Delivery_type
										+ "</td>";

								tableData += "<td><a target='_blank' href='downloadContractLetter.obj?imagePath="
										+ encodeURIComponent(filePath)
										+ "' class='btn btn-success'><i class='fa fa-download' aria-hidden='true';'></i></a></td>";

								tableData += "</tr>";
							}

							tableData += "</tbody></table>";
							$("#table" + id).html(tableData);

						}
					})

		}
	</script>

</body>

</html>
