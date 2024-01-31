<%@page import="java.util.List"%>
<%@page import="java.time.LocalDate"%>
<%@page import="java.time.LocalDateTime"%>
<%@page import="java.time.format.DateTimeFormatter"%>
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
<!-- THEME STYLES-->
<link href="assets/css/main.min.css" rel="stylesheet" />
<!-- PAGE LEVEL STYLES-->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.13.2/themes/base/jquery-ui.css">
<link rel="stylesheet" href="/resources/demos/style.css">
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
<script src="https://code.jquery.com/ui/1.13.2/jquery-ui.js"></script>
<link rel="stylesheet" href="assets/css/chosen.css">
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.5.0/js/bootstrap-datepicker.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<!-- CORE SCRIPTS-->
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

.required:after {
	content: " *";
	color: red;
}
</style>

</head>

<%
List<String> allDpc = (List<String>) request.getAttribute("loadAllDpc");
List<String> allHoDiNo = (List<String>) request.getAttribute("loadAllDiNo");
//int count = (int) request.getAttribute("count") + 1; //valid for next entry
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
				<h1 class="page-title">Dispatch Instruction (RO)</h1>
			</div>

			<%
			// Author vishal
			%>
			<div class="page-content fade-in-up">
				<div class="row">
					<div class="col-md-11">
						<div class="ibox">
							<%--    <span>${msg}</span> --%>
							<div class="ibox-body">
								<form action="saveRoDi.obj" method="POST">
									<div class="row">

										<div class="col-sm-4 form-group">
											<label>HO DI No.</label> <select name="hoDiNo" id="hoDiNo"
												class="form-control" required>
												<option value="">-Select-</option>
												<%
												for (String no : allHoDiNo) {
												%>
												<option value="<%=no%>"><%=no%></option>
												<%
												}
												%>
											</select>
										</div>


										<div class="col-sm-4 form-group">
											<label>HO DI Date</label> <input class="form-control"
												name="hoDiDate" id="hoDiDate" type="text" value="" readonly>
										</div>

										<div class="col-sm-4 form-group">
											<label>Contract No</label> <input class="form-control "
												name="contractNo" id="contractNo" type="text" value=""
												readonly>
										</div>
									</div>

									<div class="row">

										<div class="col-sm-4 form-group">
											<label>Contract Date</label> <input class="form-control"
												name="contractDate" id="contractDate" type="text" value=""
												readonly>
										</div>

										<div class="col-sm-4 form-group">
											<label>Crop year </label> <input class="form-control"
												id="cropYear" name="CropYear" type="text" readonly>
										</div>
										<div class="col-sm-4 form-group" id="dpc">
											<label>DPC</label> <select name="dpc" id="dpc"
												class="form-control" required>
												<option value="">-Select-</option>
											</select>
										</div>

									</div>


									<div class="row">


										<div class="col-sm-4 form-group">
											<label>RO DI No</label> <input class="form-control"
												name="roDiNo" id="roDiNo" type="text" readonly>
										</div>

										<div class="col-sm-4 form-group">
											<label>RO DI Date</label> <input class="form-control"
												name="roDiDate" id="roDiDate" type="text" readonly>
										</div>

										<div class="col-sm-4 form-group">
											<label>Last date of Shipment </label> <input
												class="form-control" name="lastDateOfShipment"
												id="lastDateOfShipment" type="date"
												placeholder="last date of shipment" required />
										</div>

									</div>
									<div class="row">
										<div class="col-sm-4 form-group">
[]											<label>Jute Variety</label> <input class="form-control mb-3"
												type="text" name="juteVariety" id="juteVariety" readonly>

											<label>Remarks </label> <input class="form-control"
												name="Remarks" type="text" required>

											<!--  <select name="juteVariety"
												id="juteVariety" class="form-control" required>
												<option value="">-Select-</option>
												<option value="Tossa (New)">Tossa (New)</option>
												<option value="White (New)">White (New)</option>
												<option value="Mesta">Mesta</option>
												<option value="Bimli">Bimli</option>
											</select> -->
										</div>
										<div class="col-sm-1 mt-2 form-group">
											<label></label>

											<%
											for (int i = 1; i <= 8; i++) {
											%>
											<p>
												Grade<%=i%></p>
											<%
											}
											%>
										</div>
										<div class="col-sm-3 form-group">
											<label>Grade Wise Allocated</label>
											<%
											for (int i = 1; i <= 8; i++) {
											%>
											<input class="form-control" name="Gr<%=i%>_qty"
												id="Gr<%=i%>_qty" type="number" readonly>
											<%
											}
											%>
										</div>
										<div class="col-sm-3 form-group">
											<label>Grade Wise Allocation</label>
											<%
											for (int i = 1; i <= 8; i++) {
											%>
											<input class="validation form-control" name="gr<%=i%>Qty"
												id="gr<%=i%>Qty" min="0" type="number" required>
											<%
											}
											%>
											<small id="error" name="error" class="text-danger"></small>
										</div>

										<input type="hidden" name="allowedQty" id="allowedQty" />

									</div>
									<br>
									<div class="row">

										<div class="col-sm-12 form-group">
											<input type="submit" value="Submit" class="btn btn-primary"
												id="submit">
										</div>
									</div>
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

	<div class="sidenav-backdrop backdrop"></div>

	<script>
		//get todays date in string format 
		const currentDate = new Date();
		const day = String(currentDate.getDate()).padStart(2, '0');
		const month = String(currentDate.getMonth() + 1).padStart(2, '0'); // Months are zero-based
		const year = String(currentDate.getFullYear());
		const formattedDate = day + "-" + month + "-" + year;
		const minDateOfShipment = year + "-" + month + "-" + day;

		//   alert(minDateOfShipment , formattedDate);

		$('#hoDiDate').val(formattedDate);
		$('#roDiDate').val(formattedDate);

		$("#hoDiNo")
				.on(
						"change",
						function() {
							var val = $(this).val();

							$
									.ajax({
										type : "GET",
										url : "getContractDetails.obj",
										data : {
											"diNo" : val
										},
										success : function(result) {
											var data = jQuery.parseJSON(result);

											var contract = data.contractDetails[0];
											var count = data.count + 1;

											$("#contractDate").val(contract[2]);
											$("#contractNo").val(contract[3]);
											$("#cropYear").val(contract[7]);
											$("#roDiNo").val(val + "/" + count);

											const unFormatedDate = contract[21]
													.split("-");
											
											
											
											/* 	const d = "10-10-2023";
												const unFormatedDate = d.split("-"); */
											const lastDateOfShipment = unFormatedDate[2]
													+ "-"
													+ unFormatedDate[1]
													+ "-" + unFormatedDate[0];
											$("#lastDateOfShipment").attr({
												"max" : lastDateOfShipment,
												"min" : minDateOfShipment
											});

											$("#juteVariety").val(contract[20]);
											$("#GVariety").val(contract[12]);
											$("#allowedQty").val(contract[1]);
											$("#allowedQty").val(contract[1]);
											
											/* console.log(minDateOfShipment);
											console.log(lastDateOfShipment); */
											
											var allDps = contract[10]
													.split(",");

											//console.log(allDps);

											var html = "<label id='dpclabel' class='required'>DPC</label> <select data-placeholder='Choose Dps...' class='chosen-select form-control' name='dpc'  multiple tabindex='3'  id='centerordpc'>";

											for (var i = 0; i < allDps.length; i++) {
												html += ('<option value="'
										+ allDps[i]+'">'
														+ allDps[i] + '</option>');
											}
											html += "</select>"
											$("#dpc").html(html);
											$("#centerordpc").chosen();
											$("#centerordpc").addClass("chosen-select");

											$('#centerordpc option').prop('selected',
													true);
											$('#centerordpc').trigger('chosen:updated');

											/* 	var tableElement = allDps.map(ele => {
													return "<option></option>";
												}); */

											for (i = 1; i <= 8; i++) {
												no = 11 + i;
												if (contract[no] != null
														&& contract[no] !== undefined) {

													$("#Gr" + i + "_qty").val(
															contract[no]);
												}
											}
										}
									})
						})
	</script>

	<script type="text/javascript">
		$(".validation").on(
				"keypress",
				function() {
					if (event.key === "-" || event.key === "+"
							|| event.key === "e" || event.key === "E") {
						event.preventDefault();
					}

				})
	</script>

	<script type="text/javascript">
		$(document)
				.ready(
						function() {

							$("#submit")
									.click(
											function() {
												var allowedQty = $(
														"#allowedQty").val();
												var sum = 0;
												for (i = 1; i <= 8; i++) {
													sum += parseInt($(
															"#gr" + i + "Qty")
															.val());
													//console.log(allowedQty ,  parseInt($("#gr" + i + "Qty").val()), "dateforminput")
												}
												/* 			console.log(allowedQty == sum , allowedQty , sum); */
												if (!(allowedQty == sum)) {
													document
															.getElementById("error").innerHTML = "Total sum should be equal to "
															+ allowedQty
															+ " (allowed quantity)";

												} else {
													document
															.getElementById("error").innerHTML = "";
												}
												return allowedQty == sum;
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
	<script src="assets/css/chosen.jquery.js" type="text/javascript"></script>

	<!-- PAGE LEVEL SCRIPTS-->
</body>
</html>