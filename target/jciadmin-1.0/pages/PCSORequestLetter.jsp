<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.jci.model.PCSORequestLetter"%>
<%@page import="org.apache.poi.util.SystemOutLogger"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.List"%>
<%@page import="java.io.File"%>

<%@page import="com.jci.model.EntryofpcsoModel"%>
<!DOCTYPE html>
<html lang="en">

<head>

<style>
.myname {
	width: 100%;
	height: 32px;
}
</style>
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
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.13.2/themes/base/jquery-ui.css">
<link rel="stylesheet" href="/resources/demos/style.css">

<script src="http://code.jquery.com/jquery-1.9.1.js"></script>
<script src="http://code.jquery.com/ui/1.11.0/jquery-ui.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<!-- PLUGINS STYLES-->
<!-- THEME STYLES-->
<link href="assets/css/main.min.css" rel="stylesheet" />
<!-- PAGE LEVEL STYLES-->
<script src="https://code.jquery.com/jquery-1.11.3.min.js"
	type="text/javascript"></script>
</head>
<%
String currCropYear = (String) request.getSession().getAttribute("currCropYear");
List<PCSORequestLetter> topThreeRecords = (List<PCSORequestLetter>) request.getAttribute("topThreeRecords");
double totalContractedVal = (double) request.getAttribute("totalContract");
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
				<h1 class="page-title">Generation of PCO Request Letter</h1>
			</div>
			<div class="page-content fade-in-up">
				<div class="row">
					<div class="col-md-11">
						<div class="ibox">
							<div class="ibox-head">

								<span>${msg}</span>
							</div>
							<div class="ibox-body">
								<form action="generatePCSORequest.obj" method="POST"
									name="myForm" onsubmit="return validate()">

									<div class="row">

										<div class="col-sm-4 form-group">
											<label class="required">JCI Reference No.</label>
											<!--  &nbsp;&nbsp;&nbsp; <span
												id="errName" name="errName" class="text-danger"> </span> -->
											<input class="form-control" name="referenceno"
												autocomplete="off" id="referenceno" type="text"
												placeholder="Reference No." value="" required>
										</div>
										<div class="col-sm-4 form-group">
											<label>Crop Year </label> <input class="form-control"
												name="crop_year" type="text" value="<%=currCropYear%>"
												readonly>
										</div>
										<div class="col-sm-4 form-group">
											<label>Total Contracted Qty. (Qtls.) </label> <input class="form-control"
												name="totalContractedQty" type="text" value="<%=totalContractedVal %>"
												readonly>
										</div>

									</div>
									<div class="row">
										<div class="col-sm-4 form-group">
											<label class="required">Uncontracted Qty</label> <input
												class="form-control" name="uncontractedQty"
												id="uncontractedQty" type="number" value="432245" readonly>
										</div>
										<div class="col-sm-4 form-group">
											<label class="required">Requested Qty.</label> <input
												class="form-control" name="reqQty" id="reqQty" type="number"
												min="0" required /> <span id="errMsg" class="text-danger"></span>
										</div>
									</div>
									<div class="row">


										<div class="col-sm-4 form-group">

											<label class="required">Date</label> <input
												class="form-control" name="reqDate" id="reqDate"
												placeholder="dd-mm-yyyy" required>

											<!--  <input
												class="form-control" name="date" id="date" placeholder="dd-mm-yyyy" 
												> -->
										</div>
									</div>


									<div class="row">
										<div class="col-sm-12 form-group">
											<input type="submit" value="Submit" id="submit"
												class="btn btn-success">
										</div>
									</div>

									<table class="table table-striped table-bordered table-hover"
										id="example-table" cellspacing="0" width="100%">
										<thead>
											<tr>
												<th>SN.</th>
												<th>Reference No.</th>
												<th>Date</th>
												<th>Crop Year</th>
												<th>Requested Qty.</th>
												<th>Uncontracted Qty.</th>
											</tr>
										</thead>
										<tbody>
											<%
											int i = 1;
											for (PCSORequestLetter requestEl : topThreeRecords) {
												//String date = new SimpleDateFormat("dd-MM-yyyy").format(requestEl.getCreation_date());
												//String filePath = requestEl.getLetter_path();
											%>
											<tr>
												<td><%=i%></td>
												<td><%=requestEl.getReference_no()%></td>
												<td><%=requestEl.getReqGenDate()%></td>
												<td><%=requestEl.getCropYear()%></td>
												<td><%=requestEl.getReq_qty()%></td>
												<td><%=requestEl.getSys_avail_qty()%></td>

											</tr>
											<%
											i++;
											}
											%>
										</tbody>
									</table>

								</form>
							</div>
						</div>
					</div>
				</div>
			</div>
			<!-- END PAGE CONTENT-->
			<%@ include file="footer.jsp"%>
		</div>
	</div>


	<script>
		$(document).ready(function() {
			$("#reqDate").datepicker({
				dateFormat : 'dd-mm-yy'
			});
		});
	</script>

	<script type="text/javascript">
		$(document).ready(

				function() {

					// to not enter a value less than 0
					var inputField = $("#reqQty");
					var submitButton = $("#submit");
					var refNo = $("#referenceno");
					var reqErr = $("#errMsg");

					// to set ref number to alphanumeric
					refNo.on("input", function() {
						var inputVal = $(this).val();
						var refVal = inputVal.replace(/[^a-zA-Z0-9-/]/g, "");
						$(this).val(refVal);
					});

					// to set requested quantity as needed

					/* 		inputField
									.on(
											"input",
											function() {
												var inputVal = parseInt($(this)
														.val());
												var max = parseInt(sAQty.val());
												if (inputVal > max) {
													submitButton.prop(
															"disabled", true);
													$("#errMsg")
															.html(
																	"Requested quantity must be less than Available Quantity!");
												} else {
													submitButton.prop(
															"disabled", false);
													reqErr.html("");

												}
											}); */

					// to prevent + and - from being input
					inputField.on("keydown", function(event) {
						if (event.key === "-" || event.key === "+"
								|| event.key === "e" || event.key === "E") {
							event.preventDefault();
						}
					});

				});
	</script>

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
	<!-- CORE SCRIPTS-->
	<script src="assets/js/app.min.js" type="text/javascript"></script>

	<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
	<script src="https://code.jquery.com/ui/1.13.2/jquery-ui.js"></script>



	<!--  	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
	<script src="./assets/vendors/jquery/dist/jquery.min.js"
		type="text/javascript"></script>  -->




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
	<!-- CORE SCRIPTS-->
	<script src="assets/js/app.min.js" type="text/javascript"></script>
	<!-- PAGE LEVEL SCRIPTS-->
</body>
</html>






