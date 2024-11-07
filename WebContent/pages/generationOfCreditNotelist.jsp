<%@page import="com.jci.model.EntryDerivativePrice"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.List"%>
<%@page import="java.io.File"%>


<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width initial-scale=1.0">
<title>JCI | CMS</title>
<link href="./assets/vendors/bootstrap/dist/css/bootstrap.min.css"
	rel="stylesheet" />
<link href="./assets/vendors/font-awesome/css/font-awesome.min.css"
	rel="stylesheet" />
<link href="./assets/vendors/themify-icons/css/themify-icons.css"
	rel="stylesheet" />
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.13.2/themes/base/jquery-ui.css">
<link rel="stylesheet" href="/resources/demos/style.css">
<!-- PLUGINS STYLES-->
<link href="./assets/vendors/DataTables/datatables.min.css"
	rel="stylesheet" />
<!-- THEME STYLES-->
<link href="assets/css/main.min.css" rel="stylesheet" />
<link rel="stylesheet" href="assets/css/chosen.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

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
<%-- <script>
	
<%/* EncodeId encodeId = new EncodeId();
SecretKey secretKey = encodeId.generateAESKey(128); */
String username = (String) request.getSession().getAttribute("usrname");%>
	$(document).ready(function() {
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
</script> --%>
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
				<h1 class="page-title">Generation Of Credit Notes</h1>
			</div>
			<%
			List<Object[]> list = (List<Object[]>) request.getAttribute("list");
			String baseIp = (String) request.getSession().getAttribute("baseIp");
			%>
			<div class="page-content fade-in-up">
				<div class="ibox">
					<div class="ibox-head">
						<span>${msg}</span>
						<div class="ibox-title"></div>
					</div>
					<div class="ibox-body">
						<div class="row">

							<div class="col-sm-4 form-group">
								<label>Do you want to show data by</label> <select
									name="decision" id="decision" class="form-control" required>
									<option disabled selected value="">-Select-</option>
									<option value="Contract">Contract Wise</option>
									<option value="Region">Region Wise</option>
								</select>
							</div>

							<div class="col-sm-4 form-group">
								<label>Data By</label> <select name="filter" id="filter"
									class="form-control" required>

								</select>
							</div>
						</div>
						<div class="scrollmenu">
							<table class="table table-striped table-bordered table-hover"
								id="example-table" cellspacing="0" width="100%">
								<thead>
									<tr>
										<th>Sl.No</th>
										<th>Generate Credit Note</th>
										<th>BOS Reference</th>
										<th>BOS Date</th>
										<th>DI No</th>
										<th>Contract No</th>
										<th>Challan No</th>
										<th>Mill Name</th>
										<th>Invoice Amount(Rs)</th>
										<th>Nominal Weight(Qtls)</th>
										<th>Actual Weight(Qtls)</th>
										<th>Short Weight(Qtls)</th>
										<th>Bos Doc</th>
										<th>Weigment Doc</th>
										<th>Consignee Note</th>
								</thead>
								<tbody class="tbody">

								</tbody>

							</table>
							<h3 class="text-center">Shipment Details</h3>
							<table id="shipmentTable" class="table table-bordered">
								<thead class="thead-light">
									<tr>
										<th>Date of shipment</th>
										<th>Mode of shipment</th>
										<th>Vehicle no</th>
										<th>Driver name</th>
										<th>License no</th>
										<th>Driver contact</th>

									</tr>
								</thead>
								<tbody>
									<!-- Data rows will be dynamically added here -->
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

		function saveCreditNote(contractNo, ChallanNo, invoiceVal,
				nominalWeight, ActualWeight, roId, bosNo, diNo, bosDate,
				millCode) {

			$.ajax({
				type : "POST",
				url : "generateCrn.obj",

				data : {
					"contractNo" : contractNo,
					"nominalWeight" : nominalWeight,
					"ActualWeight" : ActualWeight,
					"ChallanNo" : ChallanNo,
					"roId" : roId,
					"invoiceValue" : invoiceVal,
					"bosNo" : bosNo,
					"diNo" : diNo,
					"bosDate" : bosDate,
					"millCode" : millCode,

				},
				success : function() {
					window.location.href = "creditNoteForm.obj";
				}
			})
		}

		$("#decision")
				.on(
						"change",
						function() {
							$
									.ajax({
										type : "GET",
										url : "showCrdNoteBy.obj",
										data : {
											"parameter" : $(this).val()
										},
										success : function(result) {
											var filterOption = jQuery
													.parseJSON(result);
											var decisionOptions = "<option disabled selected>-Select-</option>";
											for (var i = 0; i < filterOption.length; i++) {
												
												if(filterOption[i].includes("--")){
													let parts = filterOption[i].split("--");
													decisionOptions += ('<option value="'+ parts[0]
													+ '">'
																			+ parts[1] + '</option>');
												}else{
													decisionOptions += ('<option value="'+ filterOption[i]
													+ '">'
																			+ filterOption[i] + '</option>');
												}
											
											}
											$("#filter").html(decisionOptions);
											$('#shipmentTable tbody').html(
													'<div></div>');
											$(".tbody").html('<div></div>');
										}
									})
						})
	</script>

	<script>
		$("#filter")
				.on("change",
						function() {
							var parameter = $("#decision").val();
							$
									.ajax({
										type : "GET",
										url : "showFilterdData.obj",
										data : {
											"parameter" : parameter,
											"basedOn" : $(this).val()
										},
										success : function(result) {

											var filterOption = jQuery
													.parseJSON(result);
											
                                            var baseIp = '<%=baseIp%>';
											var htmlTable = '';

											for (var i = 0; i < filterOption.length; i++) {
												var counter = i + 1;
												var shortQty = (filterOption[i][5] - filterOption[i][6])
														.toFixed(2);

												htmlTable += '<tr border="2px"><td style="text-align:center">'
														+ counter + '</td>';

												htmlTable += '<td><a href="generateCrn.obj?challan='
														+ filterOption[i][3]
														+ '" class="btn btn-warning btn-sm">Generate credit Note </a></td>';

												htmlTable += '<td style="text-align:center" name="bosNo">'
														+ filterOption[i][0]
														+ '</td>';
												htmlTable += '<td style="text-align:center" name="bosDate">'
														+ filterOption[i][1]
														+ '</td>';
												htmlTable += '<td style="text-align:center" name="diNo">'
														+ filterOption[i][8]
														+ '</td>';
												htmlTable += '<td style="text-align:center" name="contractNo">'
														+ filterOption[i][2]
														+ '</td>';
												htmlTable += '<td style="text-align:center;" name="challanNo"><a style="color: blue;" onclick="getShipmentDetails(\''
														+ filterOption[i][3]
														+ '\')">'
														+ filterOption[i][3]
														+ '</a></td>';
												htmlTable += '<td style="text-align:center" name="millName">'
														+ filterOption[i][7]
														+ '</td>';
												htmlTable += '<td style="text-align:center" name="invAmt">'
														+ filterOption[i][4]
														+ '</td>';
												htmlTable += '<td style="text-align:center" name="nmlWt">'
														+ filterOption[i][5]
														+ '</td>';
												htmlTable += '<td style="text-align:center" name="actWt">'
														+ filterOption[i][6]
														+ '</td>';

												htmlTable += '<td style="text-align:center" name="shortWt">'
														+ shortQty + '</td>';

												htmlTable += '<td><a style="color : blue" target="_blank" href="'+ baseIp + '/JCIStuff/billofsupply/'+ filterOption[i][11] 	
												+ '">View</a></td>';

												htmlTable += '<td><a style="color : blue" target="_blank" href="' + baseIp + '/WeightSlipment/' + filterOption[i][12]
														+ '">View</a></td>';

												htmlTable += '<td><a style="color: blue;" target="_blank" href="' + baseIp + '/DispatchDetail/' + filterOption[i][13]
											  + '">View</a></td>';

												htmlTable += '<td style="text-align:center;display:none" name="millCode">'
														+ filterOption[i][10]
														+ '</td>';

												htmlTable += '</tr>';
											}

											$(".tbody").html(htmlTable);
											$('#shipmentTable tbody').html(
													'<div></div>');
										}
									})
						});

		function getShipmentDetails(challanNo) {
			$.ajax({
				type : "GET",
				url : "getShipmentDetailsByChallanNo.obj",
				data : {
					"challanNo" : challanNo
				},
				success : function(result) {
					var details = jQuery.parseJSON(result)[0];

					var date = new Date(details[0]);
					var formattedDate = date.toLocaleDateString('en-GB', {
						day : '2-digit',
						month : '2-digit',
						year : 'numeric'
					}).replace(/\//g, '-');

					var rowHtml = '<tr>' + '<td><div class="table-cell">'
							+ formattedDate + '</div></td>'
							+ '<td><div class="table-cell">' + details[1]
							+ '</div></td>' + '<td><div class="table-cell">'
							+ details[2] + '</div></td>'
							+ '<td><div class="table-cell">' + details[3]
							+ '</div></td>' + '<td><div class="table-cell">'
							+ details[4] + '</div></td>'
							+ '<td><div class="table-cell">' + details[5]
							+ '</div></td>' + '</tr>';

					$('#shipmentTable tbody').html(rowHtml);
				}
			})
		}
	</script>


</body>

</html>
