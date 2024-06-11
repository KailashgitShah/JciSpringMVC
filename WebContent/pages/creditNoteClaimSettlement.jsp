<!DOCTYPE html>
<%@page import="org.apache.commons.lang3.ObjectUtils.Null"%>
<%@page import="java.time.LocalDate"%>
<%@page import="com.jci.model.StateList"%>
<%@page import="java.util.List"%>
<html lang="en">
<%@ page import="javax.servlet.http.HttpServletRequest"%>
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
<script src="https://code.jquery.com/jquery-1.11.3.min.js"
	type="text/javascript"></script>

<style>
.field-icon {
	float: right;
	margin-left: -25px;
	margin-top: -25px;
	position: relative;
	z-index: 2;
}

.container {
	padding-top: 50px;
	margin: auto;
}

.required:after {
	content: " *";
	color: red;
}

input[type="radio"] {
	display: inline;
}
</style>

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

<%
String currCropYear = (String) request.getSession().getAttribute("currCropYear");
List<String> allSettlementId = (List<String>) request.getAttribute("allSettlementId");
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
				<h1 class="page-title">Credit Note For Claim Settlement</h1>
			</div>
			<div class="page-content fade-in-up">
				<div class="row">
					<div class="col-md-11">
						<div class="ibox">
							<div class="ibox-head">
								<!-- <div class="ibox-title">Basic form</div> -->
								<span>${msg}</span>
							</div>
							<div class="ibox-body">

								<div class="row">
									<div class="col-sm-4 form-group">
										<label>Settlement Id</label> <select name="settlemtId"
											id="settlemtId" class="form-control" required>
											<option disabled selected value="">-Select-</option>
											<%
											for (String settlementId : allSettlementId) {
											%>
											<option value="<%=settlementId%>"><%=settlementId%></option>
											<%
											}
											%>
										</select>
									</div>
								</div>

								<div class="scrollmenu">
									<table class="table table-striped table-bordered table-hover"
										id="example-table" cellspacing="0" width="100%">
										<thead>
											<tr>


												<th>Sl.No</th>
												<th>MR No</th>
												<th>MR Date</th>
												<th>Challan No</th>
												<th>BOS No</th>
												<th>Jute Variety</th>
												<th>Qty</th>
												<th>Quality Settlement</th>
												<th>Moisture settlement</th>
												<th>Ncv settlement</th>
												<th>Dust settlement</th>
												<th>Claim Amount</th>
												<th>Settlement amt</th>
										</thead>
										<tbody class="tbody">
										</tbody>
									</table>
								</div>

								<div class="row">
									<button class="btn btn-success" onclick="generateCrn()">Submit</button>
								</div>

							</div>
						</div>
					</div>
				</div>
			</div>


			<!-- END PAGE CONTENT-->
			<%@ include file="footer.jsp"%>
		</div>
	</div>

	<div class="sidenav-backdrop backdrop"></div>
	<script defer src="assets/css/chosen.jquery.js" type="text/javascript"></script>
	<script>
		$(".chosen-select").chosen({
			no_results_text : "Oops, nothing found!"
		})
	</script>


	<script>
		$("#settlemtId")
				.on(
						"change",
						function() {
							var settlementId = $("#settlemtId").val();

							$
									.ajax({
										type : "GET",
										url : "viewAllChallanOfSettlemetId.obj",
										data : {
											"settlementId" : settlementId
										},
										success : function(result) {
											$(".tbody").html('<div></div>');
											var filterOption = jQuery
													.parseJSON(result);

											var htmlTable = '';

											for (var i = 0; i < filterOption.length; i++) {
												var counter = i + 1;

												htmlTable += '<tr border="2px"><td style="text-align:center">'
														+ counter + '</td>';

												htmlTable += '<td style="text-align:center" name="mrNo">'
														+ filterOption[i][0]
														+ '</td>';

												htmlTable += '<td style="text-align:center" name="mrNo">'
														+ filterOption[i][1]
														+ '</td>';

												htmlTable += '<td style="text-align:center" name="challanNo">'
														+ filterOption[i][2]
														+ '</td>';
												htmlTable += '<td style="text-align:center" name="bosNo">'
														+ filterOption[i][3]
														+ '</td>';
												htmlTable += '<td style="text-align:center" name="juteVariety">'
														+ filterOption[i][4]
														+ " "
														+ +filterOption[i][5]
														+ '</td>';

												htmlTable += '<td style="text-align:center" name="mrQty">'
														+ filterOption[i][6]
														+ '</td>';
												htmlTable += '<td style="text-align:center" name="Quality_settlement">'
														+ filterOption[i][7]
														+ '</td>';
												htmlTable += '<td style="text-align:center" name="Moisture_settlement">'
														+ filterOption[i][8]
														+ '</td>';
												htmlTable += '<td style="text-align:center" name="Ncv_settlement">'
														+ filterOption[i][9]
														+ '</td>';
												htmlTable += '<td style="text-align:center" name="Dust_settlement">'
														+ filterOption[i][10]
														+ '</td>';
												htmlTable += '<td style="text-align:center" name="Claim_Amount">'
														+ filterOption[i][11]
														+ '</td>';
												htmlTable += '<td style="text-align:center" name="Settlement_amt">'
														+ filterOption[i][12]
														+ '</td>';

												htmlTable += '</tr>';
											}

											$(".tbody").html(htmlTable);

										}
									})
						})

		function generateCrn() {
			var settlementId = $("#settlemtId").val();

			$.ajax({
				type : "POST",
				url : "saveCrnForClaim.obj",
				data : {
					"settlementId" : settlementId
				},
				success : function(result) {
					alert("data saved success");
				}
			})
		}

		/* function getShipmentDetails(challanNo) {
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
		} */
	</script>



	<script src="https://code.jquery.com/ui/1.13.2/jquery-ui.js"></script>
	<script src="./assets/vendors/metisMenu/dist/metisMenu.min.js"
		type="text/javascript"></script>
	<script src="assets/js/app.min.js" type="text/javascript"></script>

</body>
</html>
