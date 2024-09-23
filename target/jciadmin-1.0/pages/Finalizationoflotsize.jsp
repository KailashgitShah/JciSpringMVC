<%@page import="com.mashape.unirest.http.options.Option"%>
<%@page import="java.util.List"%>
<%@page import="java.time.LocalDate"%>
<%@page import="java.time.LocalDateTime"%>
<%@page import="com.jci.model.RoDetailsModel"%>
<%@page import="com.jci.model.PurchaseCenterModel"%>
<%@page import="com.jci.model.MillRecieptModel"%>
<%@page import="com.jci.model.EntryPaymentDetailsModel"%>
<%@page import="com.jci.model.MillreceiptDto"%>
<%@page import="java.time.format.DateTimeFormatter"%>
<!DOCTYPE html>
<html lang="en">

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
<link
	href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css"
	rel="stylesheet">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<link
	href="<%=request.getContextPath()%>/resources/css/styleUserReg.css"
	rel="stylesheet">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

<script type="text/javascript"
	src='<%=request.getContextPath()%>/resources/js/responsivevoice.js'></script>

<script type="text/javascript"
	src='<%=request.getContextPath()%>/resources/js/custom.js'></script>
<script type="text/javascript"
	src='<%=request.getContextPath()%>/resources/js/jquery.mCustomScrollbar.concat.min.js'></script>
<script type="text/javascript"
	src='<%=request.getContextPath()%>/resources/js/jquery.validate.min.js'></script>
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
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<link rel="stylesheet" href="assets/css/docsupport/style.css">
<link rel="stylesheet" href="assets/css/docsupport/prism.css">
<link rel="stylesheet" href="assets/css/chosen.css">
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
<script src="https://code.jquery.com/ui/1.13.2/jquery-ui.js"></script>
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

.disableBox {
	border: none;
	background: #e9ecef;
}

input[type="radio"] {
	display: inline;
}
</style>
<style>
/* Custom CSS to remove all spacing between columns */
.row.no-gutters {
	margin: 0; /* Remove margin */
	padding: 0; /* Remove padding */
}

.col.no-padding {
	padding: 0; /* Remove padding */
}

.input-box {
	width: 100%; /* Ensure the input fields fill the entire column width */
	box-sizing: border-box; /* Include padding and border in the width */
}

.input-box-d {
	width: 100%; /* Ensure the input fields fill the entire column width */
	box-sizing: border-box; /* Include padding and border in the width */
	background: #e9ecef;
	border: 1px solid;
}
</style>
<style>
/* Custom CSS to remove padding from columns and center the label */
.no-padding {
	padding: 0;
}

.center-label {
	text-align: center; /* Center-align the label */
	width: 100%;
	/* Ensure the label spans the entire width of its container */
	margin-bottom: 10px; /* Optional: Add space below the centered label */
}

.inputTable {
	background: #e9ecef;
	width: 100%;
	box-sizing: border-box;
	border: none;
}

/* #form6 {
       display: none;
} */
</style>

<style>
.selected-bin {
	display: inline-block;
	margin-right: 5px;
	padding: 5px;
	background-color: #f0f0f0;
	border: 1px solid #ccc;
	border-radius: 3px;
}

.remove-bin {
	margin-left: 5px;
	color: #cc0000;
	cursor: pointer;
}
</style>

</head>

<body class="fixed-navbar">
	<div class="contractLoader">
		<img src="assets/img/1488.gif">
	</div>

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
				<h1 class="page-title">Finalization of lot sizes and Reserve
					Sale Price</h1>
			</div>
			<div class="page-content fade-in-up">
				<div class="row">
					<div class="col-md-11">
						<div class="ibox">
							<span>${msg}</span>
							<div class="ibox-body">
								<form id='myForm'
									action="saveFinalizationoflotsizesandReserveSalePrice.obj"
									method="POST">
									<div class="child-checkbox" id="disableform">
										<div class="row">
											<div class="col-sm-3 form-group">
												<label>Crop Year</label> <span class="text-danger">*
												</span> <select name="crop_year" id="cropyr" class="form-control"
													required="required">
													<option value="">Select</option>
												</select>
											</div>
											<div class="col-sm-3 form-group">
												<label id="regionLabel" class="required">Region</label>
												&nbsp;&nbsp;&nbsp; <span id="errRegion" name="errRegion"
													class="text-danger"> </span>
												<%
												List<RoDetailsModel> regionList = (List<RoDetailsModel>) request.getAttribute("regionList");
												String basis = (String) request.getAttribute("basis");
												%>
												<select class="form-control" name="region" id="region">
													<option disabled selected value>-Select-</option>
													<%
													for (RoDetailsModel regionLists : regionList) {
													%>
													<option value="<%=regionLists.getRocode()%>"><%=regionLists.getRoname()%></option>
													<%
													}
													%>
													<!-- regionLists.getRocode() -->
												</select>
												<!-- <input class="form-control" type="text" name="zone" placeholder="Zone"> -->
											</div>



											<div class="col-sm-3 form-group">
												<label>Variety</label>
												<%
												List<String> variety = (List<String>) request.getAttribute("juteVeriList");
												%>
												<select class="form-control" name="variety" id="variety">
													<option disabled selected value>-Select-</option>
													<%
													for (String var : variety) {
													%>
													<option value="<%=var%>"><%=var%></option>
													<%
													}
													%>

												</select>
											</div>
											<div class="col-sm-3 form-group">
												<label>Basis</label> <input class="form-control"
													name="basis" type="text" id="basis" readonly
													value="<%=basis%>">
											</div>
										</div>

										<div class="row">

											<div class="col-sm-12">
												<table class="table table-bordered">
													<thead>
														<tr>
															<th>Select</th>
															<th>Dpc</th>
															<th>Bin Number</th>
															<th>Jute Variety</th>
															<th>Net Qty
															<th>Gr1</th>
															<th>Gr2</th>
															<th>Gr3</th>
															<th>Gr4</th>
															<th>Gr5</th>
															<th>Gr6</th>
															<th>Gr7</th>
															<th>Gr8</th>
														</tr>
													</thead>
													<tbody id="binDataBody" name="binDataBody">

														<!-- Data rows will be dynamically populated -->
													</tbody>
												</table>

											</div>

										</div>

										<div class="row"></div>
										<div class="row"></div>
										<div class="row">
											<div class="col-sm-4 form-group">
												<label>Lot Identification</label> <span class="text-danger">*
												</span>&nbsp; <span class="text-danger"> </span> <input
													class="form-control" name="lotidentification" readonly
													id="lotidentification" type="text" value="" required>
											</div>
											<div class="col-sm-4 form-group">
												<label>Lot Size</label> <span class="text-danger">* </span>&nbsp;
												<input class="form-control" name="lotsize" id="lotsize"
													type="text" value="" readonly>
											</div>
											<div class="col-sm-4 form-group">
												<label>Garsat Rate</label> <span class="text-danger">*
												</span>&nbsp; <input class="form-control" name="garsatRate"
													id="garsatRate" type="text" readonly value="">
											</div>

										</div>

										<input type="hidden" id="binData" name="binData" />

										<div id="form2"></div>

										&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
										<div class="row">
											<div class="col-sm-4 form-group">
												<label>Purchase Base Price</label> <span class="text-danger">*
												</span>&nbsp; <span name="purchasebaseprice" class="text-danger">
												</span> <input class="form-control" name="purchasebaseprice"
													id="purchasebaseprice" type="text" value="" readonly>
											</div>
											<div class="col-sm-4 form-group">
												<label class="required">Delivery Type</label> <input
													type='text' class='form-control' value='Mill delivery'
													readonly />
											</div>
											<div class="col-sm-4 form-group">
												<label>Reserved Sale Base Price </label> <input
													class="form-control taxtbox" name="reservedsaleprice"
													id="reservedsaleprice" readonly type="text" value="">
											</div>


										</div>

										<div class="row no-gutters">
											<div class="col-12 center-label">
												<label><Strong>Reserved Grade Price</Strong></label>
											</div>
										</div>

										<div class="row no-gutters">
											<div class="col no-padding">
												<label> Grade 1</label> <input type="text" readonly
													id="rsp_grd1" name="rsp_grd1" class="input-box-d">
											</div>
											<div class="col no-padding">
												<label> Grade 2</label> <input type="text" readonly
													id="rsp_grd2" name="rsp_grd2" class="input-box-d">
											</div>
											<div class="col no-padding">
												<label> Grade 3</label> <input type="text" readonly
													id="rsp_grd3" name="rsp_grd3" class="input-box-d">
											</div>
											<div class="col no-padding">
												<label> Grade 4</label> <input type="text" readonly
													id="rsp_grd4" name="rsp_grd4" class="input-box-d">
											</div>
											<div class="col no-padding">
												<label> Grade 5</label> <input type="text" readonly
													id="rsp_grd5" name="rsp_grd5" class="input-box-d">
											</div>
											<div class="col no-padding">
												<label> Grade 6</label> <input type="text" readonly
													id="rsp_grd6" name="rsp_grd6" class="input-box-d">
											</div>
											<div class="col no-padding">
												<label> Grade 7</label> <input type="text" readonly
													id="rsp_grd7" name="rsp_grd7" class="input-box-d">
											</div>
											<div class="col no-padding">
												<label> Grade 8</label> <input type="text" readonly
													id="rsp_grd8" name="rsp_grd8" class="input-box-d">
											</div>
										</div>


										<div class="row no-gutters">
											<div class="col-12 center-label">
												<label><Strong>Reserved Grade Price
														Differential</Strong></label>
											</div>
										</div>

										<div class="row no-gutters">
											<div class="col no-padding">
												<label> Grade 1</label> <input type="text" readonly
													id="rsp_grd1_diff" name="rsp_grd1_diff" class="input-box-d">
											</div>
											<div class="col no-padding">
												<label> Grade 2</label> <input type="text" readonly
													id="rsp_grd2_diff" name="rsp_grd2_diff" class="input-box-d">
											</div>
											<div class="col no-padding">
												<label> Grade 3</label> <input type="text" readonly
													id="rsp_grd3_diff" name="rsp_grd3_diff" class="input-box-d">
											</div>
											<div class="col no-padding">
												<label> Grade 4</label> <input type="text" readonly
													id="rsp_grd4_diff" name="rsp_grd4_diff" class="input-box-d">
											</div>
											<div class="col no-padding">
												<label> Grade 5</label> <input type="text" readonly
													id="rsp_grd5_diff" name="rsp_grd5_diff" class="input-box-d">
											</div>
											<div class="col no-padding">
												<label> Grade 6</label> <input type="text" readonly
													id="rsp_grd6_diff" name="rsp_grd6_diff" class="input-box-d">
											</div>
											<div class="col no-padding">
												<label> Grade 7</label> <input type="text" readonly
													id="rsp_grd7_diff" name="rsp_grd7_diff" class="input-box-d">
											</div>
											<div class="col no-padding">
												<label> Grade 8</label> <input type="text" readonly
													id="rsp_grd8_diff" name="rsp_grd8_diff" class="input-box-d">
											</div>
										</div>

										<div class="row no-gutters">
											<div class="col-12 center-label">
												<label><Strong>Sell Grade Differential</Strong></label>
											</div>
										</div>

										<div class="row no-gutters">
											<div class="col no-padding">
												<label>Grade 1</label> <input type="text" id="Sell_gr1_diff"
													name="Sell_gr1_diff" class="input-box">
											</div>
											<div class="col no-padding">
												<label>Grade 2</label> <input type="text" id="Sell_gr2_diff"
													name="Sell_gr2_diff" class="input-box">
											</div>
											<div class="col no-padding">
												<label>Grade 3</label> <input type="text" id="Sell_gr3_diff"
													name="Sell_gr3_diff" class="input-box">
											</div>
											<div class="col no-padding">
												<label>Grade 4</label> <input type="text" id="Sell_gr4_diff"
													name="Sell_gr4_diff" class="input-box">
											</div>
											<div class="col no-padding">
												<label>Grade 5</label> <input type="text" id="Sell_gr5_diff"
													name="Sell_gr5_diff" class="input-box">
											</div>
											<div class="col no-padding">
												<label>Grade 6</label> <input type="text" id="Sell_gr6_diff"
													name="Sell_gr6_diff" class="input-box">
											</div>
											<div class="col no-padding">
												<label>Grade 7</label> <input type="text" id="Sell_gr7_diff"
													name="Sell_gr7_diff" class="input-box">
											</div>
											<div class="col no-padding">
												<label>Grade 8</label> <input type="text" id="Sell_gr8_diff"
													name="Sell_gr8_diff" class="input-box">
											</div>
											<div class="col no-padding">
												<label></label>
												<button class="btn-warning" type="button"
													onclick="sellingPriceCalculation()">Calculate</button>
											</div>
										</div>
										<div class="row no-gutters">
											<div class="col-12 center-label">
												<label><Strong>Sell Grade Price</Strong></label>
											</div>
										</div>

										<div class="row no-gutters">
											<div class="col no-padding">
												<label>Sell Grade 1</label> <input type="text" id="Sell_gr1"
													name="Sell_gr1" class="input-box-d" required>
											</div>
											<div class="col no-padding">
												<label>Sell Grade 2</label> <input type="text" id="Sell_gr2"
													name="Sell_gr2" class="input-box-d" required>
											</div>
											<div class="col no-padding">
												<label>Sell Grade 3</label> <input type="text" id="Sell_gr3"
													name="Sell_gr3" class="input-box-d" required>
											</div>
											<div class="col no-padding">
												<label>Sell Grade 4</label> <input type="text" id="Sell_gr4"
													name="Sell_gr4" class="input-box-d" required>
											</div>
											<div class="col no-padding">
												<label>Sell Grade 5</label> <input type="text" id="Sell_gr5"
													name="Sell_gr5" class="input-box-d" required>
											</div>
											<div class="col no-padding">
												<label>Sell Grade 6</label> <input type="text" id="Sell_gr6"
													name="Sell_gr6" class="input-box-d" required>
											</div>
											<div class="col no-padding">
												<label>Sell Grade 7</label> <input type="text" id="Sell_gr7"
													name="Sell_gr7" class="input-box-d" required>
											</div>
											<div class="col no-padding">
												<label>Sell Grade 8</label> <input type="text" id="Sell_gr8"
													name="Sell_gr8" class="input-box-d" required>
											</div>
										</div>

										<div class="col-sm-4 form-group"></div>

										<div class="col-sm-12 form-group"></div>
										<div class="row">
											<div class="col-sm-12 form-group">
												<input type="submit" value="Submit" class="btn btn-primary"
													id="submit">
											</div>
										</div>
									</div>
								</form>
							</div>

						</div>
					</div>
				</div>
			</div>
		</div>
		<!-- END PAGE CONTENT-->
		<%@ include file="footer.jsp"%>
	</div>

	<div class="sidenav-backdrop backdrop"></div>


	<script>
		$(".validation").on("keydown", function() {
			alert(event.key);
			/* 	if (event.key === "-" || event.key === "+"
						|| event.key === "e" || event.key === "E") {
					event.preventDefault();
				} */

		});
	</script>

	<script>
		// Event listener for when the bin selection changes
		$("#region , #variety ,#cropyr")
				.on(
						"change",
						function() {

							$("#lotidentification").val("");

							var cropyr = $("#cropyr").val();
							var basis = $("#basis").val();
							var variety = $("#variety").val();
							var region = $("#region").val();
							if (cropyr != null && region != null
									&& variety != null) {
								$(".contractLoader").show();

								$("#binDataBody").html("");

								$
										.ajax({
											type : "GET",
											url : "findJuteVarietyGradeWiseByBIN.obj",
											data : {
												"cropyr" : cropyr,
												"basis" : basis,
												"region" : region,
												"variety" : variety

											},
											success : function(result) {
												var model = jQuery
														.parseJSON(result).model;
												var msg = model.msg;
												if (msg.length > 0) {
													alert(msg);
													$(".contractLoader").hide();
													return;
												}
												var response = model.binDetails;
												var count = +model.count;
												//alert(count);
												$("#lotidentification").val(
														count + 1);
												//alert("isPriceDecided " + status);                                                                                        
												var tbl = "";
												var lotSize = 0;

												for (var i = 0; i < response.length; i++) {
													var innerArray1 = response[i];
													var Binno = innerArray1[0];
													var jv = innerArray1[1];
													var dpc = innerArray1[2]
															.split('&');
													var g1 = innerArray1[3];
													var g2 = innerArray1[4];
													var g3 = innerArray1[5];
													var g4 = innerArray1[6];
													var g5 = innerArray1[7];
													var g6 = innerArray1[8];
													var g7 = innerArray1[9];
													var g8 = innerArray1[10];
													var qty = g1 + g2 + g3 + g4
															+ g5 + g6 + g7 + g8;
													var startDate = innerArray1[11];
													var endDate = innerArray1[12];
													var perVal = innerArray1[13];
													var packQty = innerArray1[14];

													var newRow = "<tr>"
															+ '<td><input type="checkbox" id="checking'+i+'" class="row-checkbox" name="rowCheckbox'+i+'" value="0"></td>'
															+ '<td><div class="table-cell"><input type="hidden" name="dpc[]" value="' + dpc[0]+ '">'
															+ dpc[1]
															+ '</div></td>'
															+ '<td><div class="table-cell"><input type="hidden" name="binnumber[]" value="' + Binno+ '">'
															+ Binno
															+ '</div></td>'
															+ '<td><div class="table-cell"><input type="hidden"  name="jutevariety[]" value="' + jv+ '">'
															+ jv
															+ '</div></td>'
															+ '<td><div class="table-cell"><input type="hidden"  name="qty[]" value="' + qty+ '">'
															+ qty
															+ '</div></td>'
															+ '<td><div class="table-cell"><input type="hidden"  name="gr1[]" value="' + g1+ '">'
															+ g1
															+ '</div></td>'
															+ '<td><div class="table-cell"><input type="hidden" name="gr2[]" value="' + g2+ '">'
															+ g2
															+ '</div></td>'
															+ '<td><div class="table-cell"><input type="hidden" name="gr3[]" value="' + g3+ '">'
															+ g3
															+ '</div></td>'
															+ '<td><div class="table-cell"><input type="hidden" name="gr4[]" value="' + g4+ '">'
															+ g4
															+ '</div></td>'
															+ '<td><div class="table-cell"><input type="hidden" name="gr5[]" value="' + g5+ '">'
															+ g5
															+ '</div></td>'
															+ '<td><div class="table-cell"><input type="hidden" name="gr6[]" value="' + g6+ '">'
															+ g6
															+ '</div></td>'
															+ '<td><div class="table-cell"><input type="hidden" name="gr7[]" value="' + g7+ '">'
															+ g7
															+ '</div></td>'
															+ '<td><div class="table-cell"><input type="hidden" name="gr8[]" value="' + g8+ '">'
															+ g8
															+ '</div></td>'
															+ '<input type="hidden" name="startDate" value="' + startDate + '"/>'
															+ '<input type="hidden" name="endDate" value="' + endDate + '"/>'
															+ '<input type="hidden" name="perVal" value="' + perVal + '"/>'
															+ '<input type="hidden" name="packQty" value="' + packQty + '"/>'

													"</tr>";

													tbl += newRow;

												}

												tbl += '<tr>'
												//+ '<td colspan="2"><button class="btn btn-warning" id="calculatePrice" onclick = getCheckBoxData()>Calculate</button></td>'
												//+ '<td></td>'
												+ '<td colspan="11"></td></tr>';

												// Access the elements within the inner array

												console.log("response",
														response);

												var crop = $("#cropyr").val(); // Get the value of the element with ID 'cropyr'

												$
														.ajax({
															type : "GET",
															url : "factorlist.obj", // URL to send the GET request
															data : {
																"region" : region, // Pass selected region as parameter
																"crop" : crop,
																"basis" : basis
															// Pass selected crop as parameter
															},
															success : function(
																	result) {
																// Handle successful response here
																// Assuming 'result' contains the JSON response from the server
																var data = jQuery
																		.parseJSON(result);

																// Log the parsed data and its length for testing
																console
																		.log(data);
																console
																		.log("Length of data: "
																				+ data.length);

																// Initialize table HTML string with table tag and initial row for headers

																var tableHTML = "<table border='1'>";

																// Add table heading
																tableHTML += "<tr>";
																tableHTML += "<th colspan='3' style='font-weight: bold; border: 1px solid black; text-align: center;color:white;background:#00984c;'>Price Components</th>";
																tableHTML += "</tr>";

																var total = 0; // Variable to store the total sum

																// Create rows for the cells using the first 10 elements from 'data'
																for (var i = 0; i < data.length; i++) {
																	tableHTML += "<tr>";

																	// Table header (th) with bold text, black border
																	tableHTML += "<th style='font-weight: bold; border: 1px solid black;'>";
																	tableHTML += "<input class='inputTable' type='text' readonly id='factor"
																			+ i
																			+ "' name='factor"
																			+ i
																			+ "' value='"
																			+ data[i][0]
																			+ " (Rs/Qtl)' />";
																	tableHTML += "</th>";

																	// Data cell (td) with bold text, black border, centered text alignment
																	var value = parseFloat(data[i][1]); // Convert to float if necessary
																	tableHTML += "<td style='font-weight: bold; border: 1px solid black; text-align: center;'>";
																	tableHTML += "<input type='text' style='background:#e9ecef;' readonly id='value" + i + "' name='value" + i + "' value='" + value + "'/>";
																	tableHTML += "</td>";

																	// Add to total sum
																	total += value;

																	// Close the table row (tr)
																	tableHTML += "</tr>";
																}

																// Add Total 

																tableHTML += "<tr>";
																tableHTML += "<th style='font-weight: bold; border: 1px solid black;'>";
																tableHTML += "<input class='inputTable' type='text' readonly name='factor3' id='factor3' value='Margin (%)'/>";
																tableHTML += "</th>";
																tableHTML += "<td style='font-weight: bold; border: 1px solid black; text-align: center;'>";
																tableHTML += "<input class='validation' type='number' id='value3' name='value3' step='0.01' value='0'/>";
																tableHTML += "</td>";
																tableHTML += "<td style='font-weight: bold; border: 1px solid black; text-align: center;'>";
																tableHTML += "<input type='number' readonly class='disableBox' id='fvalue3' name='fvalue3'/>";
																tableHTML += "</td>";
																tableHTML += "</tr>";

																tableHTML += "<tr>";
																tableHTML += "<th style='font-weight: bold; border: 1px solid black;'>";
																tableHTML += "<input class='inputTable' type='text' readonly name='factor4' id='factor4' value='Claim/Weight Loss (%)'/>";
																tableHTML += "</th>";
																tableHTML += "<td style='font-weight: bold; border: 1px solid black; text-align: center;'>";
																tableHTML += "<input  class='validation'  type='number' id='value4' name='value4' step='0.01' value='0'/>";
																tableHTML += "</td>";
																tableHTML += "<td style='font-weight: bold; border: 1px solid black; text-align: center;'>";
																tableHTML += "<input class='disableBox' type='number' readonly id='fvalue4' name='fvalue4'/>";
																tableHTML += "</td>";
																tableHTML += "</tr>";


																tableHTML += "<tr>";
																tableHTML += "<th style='font-weight: bold; border: 1px solid black;'>";
																tableHTML += "<input class='inputTable' type='text' readonly name='factor6' id='factor6' value='Contingent Cost (Rs/Qtl)'/>";
																tableHTML += "</th>";
																tableHTML += "<td style='font-weight: bold; border: 1px solid black; text-align: center;'>";
																tableHTML += "<input type='number' id='value6' name='value6' value='0'/>";
																tableHTML += "</td>";
																tableHTML += "<td style='font-weight: bold; border: 1px solid black; text-align: center;'>";
																tableHTML += "<input class='disableBox' type='number' readonly id='fvalue6' name='fvalue6'/>";
																tableHTML += "</td>";
																tableHTML += "</tr>";

																tableHTML += "<tr>";
																tableHTML += "<th style='font-weight: bold; border: 1px solid black;'>";
																tableHTML += "<input class='inputTable' type='text' readonly name='factor7' id='factor7' value='Opportunity Cost (Rs/Qtl)'/>";
																tableHTML += "</th>";
																tableHTML += "<td style='font-weight: bold; border: 1px solid black; text-align: center;'>";
																tableHTML += "<input type='number' id='value7' name='value7' value='0'/>";
																tableHTML += "</td>";
																tableHTML += "<td style='font-weight: bold; border: 1px solid black; text-align: center;'>";
																tableHTML += "<input class='disableBox' type='number' readonly id='fvalue7' name='fvalue7'/>";
																tableHTML += "</td>";
																tableHTML += "</tr>";

																tableHTML += "<tr>";
																tableHTML += "<th style='font-weight: bold; border: 1px solid black;'>";
																tableHTML += "<input class='inputTable' type='text' readonly name='factor8' id='factor8' value='Market Levy (%)'/>";
																tableHTML += "</th>";
																tableHTML += "<td style='font-weight: bold; border: 1px solid black; text-align: center;'>";
																tableHTML += "<input type='number' id='value8' name='value8' step='0.01' value='0'/>";
																tableHTML += "</td>";
																tableHTML += "<td style='font-weight: bold; border: 1px solid black; text-align: center;'>";
																tableHTML += "<input type='number' readonly id='fvalue8' name='fvalue8'  class='disableBox'/>";
																tableHTML += "</td>";
																tableHTML += "</tr>";
																

																tableHTML += "<tr>";
																tableHTML += "<th style='font-weight: bold; border: 1px solid black;'><div class='table-cell'>";
																tableHTML += "<input class='inputTable' type='text' readonly name='factor5' id='factor5' value='Interest on Labour Charge (%)'/>";
																tableHTML += "</div></th>";
																tableHTML += "<td style='font-weight: bold; border: 1px solid black; text-align: center;'>";
																tableHTML += "<input type='number' id='value5' name='value5' step='0.01' value='0'/>";
																tableHTML += "</td>";
																tableHTML += "<td style='font-weight: bold; border: 1px solid black; text-align: center;'>";
																tableHTML += "<input class='disableBox' type='number' readonly id='fvalue5' name='fvalue5'/>";
																tableHTML += "</td>";
																tableHTML += "</tr>";

																// Second row with one header cell spanning two columns
																tableHTML += "<tr>";
																tableHTML += "<th style='font-weight: bold; border: 1px solid black;'>";
																tableHTML += "<input class='inputTable' type='text' readonly name='factor9' id='factor9' value='Interest (%)'/>";
																tableHTML += "</th>";

																tableHTML += "<td style='border: 1px solid black;'>";
																tableHTML += "<div style='display: flex; justify-content: space-between;'>";
																tableHTML += "<div style='flex: 1; padding: 5px; border-right: 1px solid black;'>"; // Section 1
																tableHTML += "<input type='number' name='value9' id='value9' style='width: 100%; box-sizing: border-box;' step='0.01' value='0'/>";
																tableHTML += "</div>";
																tableHTML += "<div style='flex: 1; padding: 5px;'>"; // Section 2
																tableHTML += "<input type='number' id='value10' name='value10' style='width: 100%; box-sizing: border-box;' placeholder='Period (in Months)'/>";
																tableHTML += "</div>";
																tableHTML += "</div>";
																tableHTML += "</td>";

																tableHTML += "<td style='font-weight: bold; border: 1px solid black; text-align: center;'>";
																tableHTML += "<input type='number' readonly id='fvalue9' name='fvalue9'  class='disableBox'/>";
																tableHTML += "</td>";
																tableHTML += "</tr>";

																// Calculate button
																tableHTML += "<tr>";
																tableHTML += "<td style='font-weight: bold; border: 1px solid black; text-align: center; width: 50%;'>";
																//tableHTML += "<button type='button' style='width: 100%; box-sizing: border-box;' onclick='calculatePriceComponent()'>Calculate</button>";
																tableHTML += "<button type='button' class='btn btn-warning' id='calculatePrice' onclick = getCheckBoxData()>Calculate</button>";
																tableHTML += "</td>";
																tableHTML += "<td style='font-weight: bold; border: 1px solid black; text-align: center; width: 50%;'>";
																tableHTML += "<input type='number' readonly id='priceCom' name='priceCom' class='disableBox'/>";
																tableHTML += "</td>";
																tableHTML += "</tr>";

																// Close the table tag
																tableHTML += "</table>";

																// Set the generated table HTML to the element with id 'form2'
																$("#form2")
																		.html(
																				tableHTML);

															},
															error : function(
																	xhr,
																	status,
																	error) {
																// Handle error
																console
																		.error(
																				"Error:",
																				error); // Log error to console
															}
														});

												// Append row to the table body

												$(".contractLoader").hide();
												$("#binDataBody").append(tbl);

											},
											error : function(xhr, status, error) {
												console.error(
														"An error occurred:",
														error);
												// Handle errors, e.g., displaying an error message to the user
											}
										});

							} else {
								// Clear table body if no bins are selected
								$("#binDataBody").html("");
							}
						});
	</script>

	<script>
		var potentialSellingPrice;
		var finalBinData = "";
		var sumPerVal = 0;
		var sumPackQty = 0;
		function getCheckBoxData() {
			$(".contractLoader").show();
			var binNos = [];
			var lotsize = 0;
			var isChecked = 0;

			// Iterate over each row in the table
			$("#binDataBody tr").each(
					function() {
						// Find the checkbox in the current row
						var checkbox = $(this).find(".row-checkbox");

						// Check if the checkbox is checked
						if (checkbox.is(":checked")) {
							isChecked = 1;
							$(this).each(
									function() {

										var dpcpart = $(this).find(
												"input[name='dpc[]']").val();
										var jutevariety = $(this).find(
												"input[name='jutevariety[]']")
												.val();
										var binnumber = $(this).find(
												"input[name='binnumber[]']")
												.val();

										var qty = $(this).find(
												"input[name='qty[]']").val();
										lotsize += +qty;
										var gr1 = $(this).find(
												"input[name='gr1[]']").val();
										var gr2 = $(this).find(
												"input[name='gr2[]']").val();
										var gr3 = $(this).find(
												"input[name='gr3[]']").val();
										var gr4 = $(this).find(
												"input[name='gr4[]']").val();
										var gr5 = $(this).find(
												"input[name='gr5[]']").val();
										var gr6 = $(this).find(
												"input[name='gr6[]']").val();
										var gr7 = $(this).find(
												"input[name='gr7[]']").val();
										var gr8 = $(this).find(
												"input[name='gr8[]']").val();
										var startDate = $(this).find(
												"input[name='startDate']")
												.val();
										var endDate = $(this).find(
												"input[name='endDate']").val();
										var perVal = $(this).find(
												"input[name='perVal']").val();
										var packQty = $(this).find(
												"input[name='packQty']").val();

										sumPerVal += +perVal;
										sumPackQty += +packQty;
										var formattedData = dpcpart + "#"
												+ binnumber + "#" + jutevariety
												+ "#" + qty + "#" + gr1 + "#"
												+ gr2 + "#" + gr3 + "#" + gr4
												+ "#" + gr5 + "#" + gr6 + "#"
												+ gr7 + "#" + gr8 + "#"
												+ startDate + "#" + endDate;
										binNos.push(formattedData);
										finalBinData += formattedData + "^^";

									}

							);
						}

					});

			if (isChecked == 0) {
				console.log("conditions", isChecked);
				$(".contractLoader").hide();
				alert("Please Select Bin !!!");
				return false;
			}

			$("#binData").val(finalBinData);
			console.log("sumPerVal", sumPerVal, sumPackQty);
			if (sumPackQty != 0)
				$("#garsatRate").val((sumPerVal / sumPackQty).toFixed(2));

			var cropyr = $("#cropyr").val();
			var basis = $("#basis").val();
			var region = $("#region").val();

			var priceComponent = calculatePriceComponent();

			$.ajax({
				type : "GET",
				url : "commercialPriceCalculation.obj",
				data : {
					"cropyr" : cropyr,
					"basis" : basis,
					"region" : region,
					"binNos" : JSON.stringify(binNos)

				},
				success : function(result) {

					var model = jQuery.parseJSON(result).model;
					var msg = model.msg;
					if (msg.length > 0) {
						alert(msg);
						$(".contractLoader").hide();
						return;
					}

					potentialSellingPrice = model.potentialSellingPrice;

					$("#lotsize").val(lotsize);
					var priceCmp = +$("#priceCom").val();
					//alert("priceCmp" + priceCmp);

					var baseSellPrice = +potentialSellingPrice[4];
					alert("Purchase base price " + potentialSellingPrice);

					for (var i = 0; i < potentialSellingPrice.length; i++) {
						var pSellPrice = +potentialSellingPrice[i].toFixed(2);
						$("#rsp_grd" + (i + 1)).val(
								(priceCmp + pSellPrice).toFixed(2));
						$("#rsp_grd" + (i + 1) + "_diff").val(
								(pSellPrice - baseSellPrice).toFixed(2));

					}
					$("#purchasebaseprice").val(baseSellPrice.toFixed(2));
					$("#reservedsaleprice").val(Math.round(baseSellPrice + priceCmp));
					$(".contractLoader").hide();
					// alert("avgBasePrice " + avgBasePrice);

				},
				error : function(xhr, status, error) {
					console.error("An error occurred:", error);
					// Handle errors, e.g., displaying an error message to the user
				}

			});

		}

		function sellingPriceCalculation() {
			var priceCmp = +$("#priceCom").val();
			for (var i = 0; i < 8; i++) {

				var sellPrice = +$("#Sell_gr" + (i + 1) + "_diff").val()
						+ potentialSellingPrice[i] + priceCmp;
				$("#Sell_gr" + (i + 1)).val(sellPrice.toFixed(2));
			}
		}

		// Example: Call the function when a button is clicked
		//$("#calculatePrice").on("click", getCheckedRows);
	</script>




	<script>
		$(document).ready(

				function() {
					$(".contractLoader").hide();
					var html = "<option selected disabled>-select-</option>";
					var today = new Date();
					var cropyr = today.getFullYear();
					var month = parseInt(today.getMonth()) + 1;
					var date = parseInt(today.getDate());
					var time = today.getHours() + ":" + today.getMinutes()
							+ ":" + today.getSeconds();
					if (date >= 1 && month >= 7
							&& parseInt(today.getHours()) >= 0
							&& parseInt(today.getMinutes()) >= 0
							&& parseInt(today.getSeconds()) > 0) {
						html += "<option value = '" + (cropyr - 1) + "-"
								+ cropyr + "'>" + (cropyr - 1) + "-" + cropyr
								+ "</option>";
						html += "<option value = '" + cropyr + "-"
								+ (cropyr + 1) + "'>" + cropyr + "-"
								+ (cropyr + 1) + "</option>";
					} else {
						html += "<option value = '" + (cropyr - 2) + "-"
								+ (cropyr - 1) + "'>" + (cropyr - 2) + "-"
								+ (cropyr - 1) + "</option>";
						html += "<option value = '" + (cropyr - 1) + "-"
								+ cropyr + "'>" + (cropyr - 1) + "-" + cropyr
								+ "</option>";
					}
					$("#cropyr").html(html);
				});
	</script>
	<script type="text/javascript">
		function calculatePriceComponent() {
			var finalPriceComp = 0;
			var insurance = 0;
			var freigth = 0;
			var labourRate = 0;
			var garsatRate = +$("#garsatRate").val();

			for (var i = 0; i <= 2; i++) {
				if ($("#factor" + i).val() === 'Insurance (Rs/Qtl)')
					insurance = +$("#value" + i).val();
				else if ($("#factor" + i).val() === 'Freight (Rs/Qtl)')
					freigth = +$("#value" + i).val();
				else
					labourRate = +$("#value" + i).val();
			}

			for (var i = 3; i <= 9; i++) {

				if ($("#factor" + i).val() === 'Margin (%)') {
					var marginrate = ((insurance + freigth + labourRate + garsatRate) * (+$(
							"#value" + i).val() / 100)).toFixed(2);
					finalPriceComp += +marginrate;
					$("#fvalue" + i).val(marginrate);
				} else if ($("#factor" + i).val() === 'Claim/Weight Loss (%)') {
					var claim = ((labourRate + garsatRate) * (+$("#value" + i)
							.val() / 100)).toFixed(2);
					finalPriceComp += +claim;
					$("#fvalue" + i).val(claim);
				} else if ($("#factor" + i).val() === 'Interest on Labour Charge (%)') {
					var intrstOnLbrCrg = (labourRate
							* (+$("#value" + i).val() * +$("#value10").val()) / 1200)
							.toFixed(2);
					finalPriceComp += +intrstOnLbrCrg;
					$("#fvalue" + i).val(intrstOnLbrCrg);
				} else if ($("#factor" + i).val() === 'Contingent Cost (Rs/Qtl)') {
					var contingent = +$("#value" + i).val();
					$("#fvalue" + i).val(contingent);
					finalPriceComp += +contingent;
				} else if ($("#factor" + i).val() === 'Opportunity Cost (Rs/Qtl)') {
					var opportunity = +$("#value" + i).val();
					$("#fvalue" + i).val(opportunity);
					finalPriceComp += +opportunity;
				} else if ($("#factor" + i).val() === 'Market Levy (%)') {

					var marketLevi = (garsatRate * (+$("#value" + i).val() / 100))
							.toFixed(2);
					$("#fvalue" + i).val(marketLevi);
					finalPriceComp += +marketLevi;
				} else {
					var interest = (garsatRate
							* (+$("#value" + i).val() * +$("#value10").val()) / 1200)
							.toFixed(2);
					$("#fvalue" + i).val(interest);
					finalPriceComp += +interest;
				}
			}
			console.log("finalPriceComp", finalPriceComp);
			$("#priceCom").val(finalPriceComp.toFixed(2));
			return finalPriceComp;
		}
	</script>
	
	<script type="text/javascript">
	$(document).ready(function() {
		$('#myForm').on('submit', function(event) {
			 
			
			
			$('#submit').prop('disabled', true);
			$('#submit').val('Please Wait Processing...');

		});
	});
	</script>

	<!-- <script src="assets/css/docsupport/jquery-3.2.1.min.js" type="text/javascript"></script> -->
	<script src="assets/css/chosen.jquery.js" type="text/javascript"></script>
	<script src="assets/css/docsupport/prism.js" type="text/javascript"
		charset="utf-8"></script>
	<script src="assets/css/docsupport/init.js" type="text/javascript"
		charset="utf-8"></script>
</html>



