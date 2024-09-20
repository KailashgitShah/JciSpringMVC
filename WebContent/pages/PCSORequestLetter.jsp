<%@page import="java.text.DecimalFormat"%>
<%@page import="java.util.ArrayList"%>
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

.required:after {
	content: " *";
	color: red;
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
<!-- PLUGINS STYLES-->
<link href="./assets/vendors/DataTables/datatables.min.css"
	rel="stylesheet" />
<!-- THEME STYLES-->
<link href="assets/css/main.min.css" rel="stylesheet" />
<link rel="stylesheet" href="assets/css/chosen.css">
<script src="https://code.jquery.com/jquery-1.11.3.min.js"
	type="text/javascript"></script>
</head>
<%
String currCropYear = (String) request.getSession().getAttribute("currCropYear");
 String[] years = currCropYear.split("-");
int startYear = Integer.parseInt(years[0]);
int endYear = Integer.parseInt(years[1]);

// Calculate the past crop years
String pastCropYear1 = (startYear - 1) + "-" + (endYear - 1);
String pastCropYear2 = (startYear - 2) + "-" + (endYear - 2); 

List<PCSORequestLetter> topThreeRecords = (List<PCSORequestLetter>) request.getAttribute("topThreeRecords");
List<String> cropYr = (List<String>) request.getAttribute("distinctCropYear");
double totalContractedVal = (double) request.getAttribute("totalContract");
List<Double> jute = (List<Double>) request.getAttribute("jute");
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
							<h3 class="font-weight-bold mb-4 text-center">Latest Request
								letters</h3>
							<table class="table table-striped table-bordered table-hover"
								id="example-table" cellspacing="0" width="100%">


								<thead>
									<tr>
										<th>SN.</th>
										<th>Reference No.</th>
										<th>Date</th>
										<th>Crop Year</th>
										<th>Requested Qty. (Qtls)</th>
										<th>Uncontracted Qty.(Qtls)</th>
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

							<!-- //////////////////////////////////////Inventory//////////////////////////// -->


							<h3 class="font-weight-bold text-center">Inventory</h3>

							<div class="ibox-body">
								<form action="generatePCSORequest.obj" method="POST"
									name="myForm" id="myForm" onsubmit="return validate()">
									<div class="row">


										<!-- 	<div class="col-sm-4 form-group">
									<label>Basis</label> <span class="text-danger">* </span>&nbsp;
									<span id="errbasis" name="errbasis" class="text-danger">
									</span> 
									<select name="basis" id="basis" class="form-control">
										<option value="">-Select-</option>
										<option value="msp">MSP</option>
										<option value="commercial">Commercial</option>
									</select>
								</div> -->
										<div class="col-sm-4 form-group">
											<label>Crop Year</label> <span class="text-danger">* </span>&nbsp;
											<span id="errcropyr" name="errcropyr" class="text-danger">
											</span> <select name="cropyr" id="cropyr" class="form-control" onchange="getTotalQty()"
												>
												<option value="">-Select-</option>
												<option  value="<%=currCropYear%>" ><%=currCropYear %></option>
												<option value="<%=pastCropYear1%>"><%=pastCropYear1%></option>
												<option value="<%=pastCropYear2%>"><%=pastCropYear2%></option>
													
												 
											</select>
										</div>
									</div>
									</div>
									<table class="table table-striped table-bordered table-hover"
										id="example-table" cellspacing="0" width="100%">


										<thead>
										<caption>1st Level view of Procured Jute</caption>
										<tr>
											<th>Sl.no</th>
											<th></th>

											<th>Loose</th>
											<th>Gr1</th>
											<th>Gr2</th>
											<th>Gr3</th>
											<th>Gr4</th>
											<th>Gr5</th>
											<th>Gr6</th>
											<th>Gr7</th>
											<th>Gr8</th>
											<th>Total</th>
										</tr>

										</thead>
										<tbody>


											<tr>
												<td>(1)</td>
												<td><a href="regionwiseinventory.obj">Procured/Baled</a></td>
												<td id="loosejute"><%=jute.get(7)%></td>
												<td id="grade0"><%=jute.get(0)%></td>
												<td id="grade1"><%=jute.get(1)%></td>
												<td id="grade2"><%=jute.get(2)%></td>
												<td id="grade3"><%=jute.get(3)%></td>
												<td id="grade4"><%=jute.get(4)%></td>
												<td id="grade5"><%=jute.get(5)%></td>
												<td id="grade6">0</td>
												<td id="grade7">0</td>
												<td id="total"><%=jute.get(6)%></td>
											</tr>

										</tbody>
										<tbody>
											<tr>
												<td>(2)</td>
												<td>Available</td>
												<td id="loosejute">0.0</td>
												<td id="grade0">0.0</td>
												<td id="grade1">0.0</td>
												<td id="grade2">0.0</td>
												<td id="grade3">0.0</td>
												<td id="grade4">0.0</td>
												<td id="grade5">0.0</td>
												<td id="grade6">0.0</td>
												<td id="grade7">0.0</td>
												<td id="total">0.0</td>
											</tr>
										</tbody>
										<tbody>
											<tr>
												<td>(3)</td>
												<td>Contract In Hand</td>
												<td id="loosejute">0.0</td>
												<td id="grade0">0.0</td>
												<td id="grade1">0.0</td>
												<td id="grade2">0.0</td>
												<td id="grade3">0.0</td>
												<td id="grade4">0.0</td>
												<td id="grade5">0.0</td>
												<td id="grade6">0.0</td>
												<td id="grade7">0.0</td>
												<td id="total">0.0</td>
											</tr>
										</tbody>
										<tbody>
											<tr>
												<td>(4)</td>
												<td>Contract Un-covered</td>
												<td id="loosejute">0.0</td>
												<td id="grade0">0.0</td>
												<td id="grade1">0.0</td>
												<td id="grade2">0.0</td>
												<td id="grade3">0.0</td>
												<td id="grade4">0.0</td>
												<td id="grade5">0.0</td>
												<td id="grade6">0.0</td>
												<td id="grade7">0.0</td>
												<td id="total">0.0</td>
											</tr>
										</tbody>


									</table>

									<!-- ////////////////////////////////////////////////////////////////////////////////// -->


									<div class="row">

										<div class="col-sm-4 form-group">
											<label class="required">JCI Reference No.</label>
											<!--  &nbsp;&nbsp;&nbsp; <span
												id="errName" name="errName" class="text-danger"> </span> -->
											<input class="form-control" name="referenceno"
												autocomplete="off" id="referenceno" type="text"
												placeholder="Reference No." value="" required>
										</div>
										<!-- <div class="col-sm-4 form-group">
											<label>Crop Year </label> <input class="form-control"
												name="crop_year" type="hidden" "
												readonly>
										</div> -->
										<div class="col-sm-4 form-group">

											<label class="required">Date</label> <input
												class="form-control" name="reqDate" id="reqDate"
												autocomplete="off" type="date" min="" required>

										</div>
										<%-- <div class="col-sm-4 form-group">
											<label>Total Requsted Qty. (Qtls.) </label> <input
												class="form-control" name="totalContractedQty" type="text" id="totalContractedQty"
												value="<%=totalContractedVal%>" readonly>
										</div> --%>
										<div class="col-sm-4 form-group">
											<label>Total Requsted Qty. (Qtls.) </label> <input
												class="form-control" name="totalContractedQty" type="text" id="totalContractedQty"
												 readonly>
										</div>

									</div>
									<div class="row">
										<input class="form-control" name="uncontractedQty"
											id="uncontractedQty" type="hidden" value="<%=jute.get(6)%>"
											readonly>

										<div class="col-sm-4 form-group">
											<label class="required">Requested Qty. (Qtls.)</label> <input
												class="form-control" name="reqQty" id="reqQty" type="number"
												min="0" required /> <span id="errMsg" class="text-danger"></span>
										</div>
									</div>
									<div class="row">
										<div class="col-sm-12 form-group">
											<input type="submit" value="Submit" id="submit"
												class="btn btn-success">
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


	<script>
		$(document).ready(function() {
			var currentDate = new Date();
			var formattedDate = currentDate.toISOString().split('T')[0];
			document.getElementById("reqDate").min = formattedDate;
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
						var refVal = inputVal.replace(/[^a-zA-Z0-9-]/g, "");
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

	<script>
		$(document)
				.ready(
						function() {
							$("#cropyr")
									.on(
											'change',
											function() {
												//alert("kkkk")
												var cropyr = $("#cropyr").val();
											
												var basis = "MSP";
												//var basis = $("#basis").val();
												var loosejute = 0.0;
												var baled = 0.0;
												$
														.ajax({
															type : "GET",
															url : "inventoryjute.obj",
															data : {
																"cropyr" : cropyr,
																"basis" : basis
															},
															success : function(
																	result) {
																var jute = jQuery
																		.parseJSON(result);

																for (var i = 0; i < jute.length; i++) {

																	//console.log("jute["+i+"] =  "+ jute[i]);
																	loosejute = loosejute
																			+ jute[i];

																}
																//	console.log("loosejute = "+ loosejute);

																$
																		.ajax({
																			type : "GET",
																			url : "inventorybale.obj",
																			data : {
																				"cropyr" : cropyr,
																				"basis" : basis
																			},
																			success : function(
																					result) {
																				var bale = jQuery
																						.parseJSON(result);

																				for (var i = 0; i < bale.length; i++) {

																					//	console.log("bales["+i+"] =  " +bale[i]);
																					baled = baled
																							+ bale[i];

																				}

																				var loosefinal = loosejute
																						- baled;
																				var total = loosefinal
																						+ baled;
																				//console.log("total = "+loosefinal);
																				document
																						.getElementById("loosejute").innerHTML = loosefinal
																						.toFixed(2);
																				document
																						.getElementById("grade0").innerHTML = bale[0];
																				document
																						.getElementById("grade1").innerHTML = bale[1];
																				document
																						.getElementById("grade2").innerHTML = bale[2];
																				document
																						.getElementById("grade3").innerHTML = bale[3];
																				document
																						.getElementById("grade4").innerHTML = bale[4];
																				document
																						.getElementById("grade5").innerHTML = bale[5];
																				document
																						.getElementById("grade6").innerHTML = bale[6];
																				document
																						.getElementById("grade7").innerHTML = bale[7];
																				document
																						.getElementById("total").innerHTML = total
																						.toFixed(2);
																			}
																		});
															}
														});
										
											/* 
												$.ajax({
												    type: "GET",
												    url: "totalReqQty.obj",
												    data: {
												        "cropyr": cropyr,
												        "basis": basis
												    },
												    success: function(result) {
												        alert("totalRequested");
												        var jute = jQuery.parseJSON(result);
												        alert(jute); // If you want to alert the parsed JSON
												    },
												    error: function(xhr, status, error) {
												        alert("Error: " + error); // Improved error handling
												    }
												}); */
						});
	</script>
	
	<script>
    var basis = "MSP";

    function getTotalQty() {
        var cropyr = document.getElementById("cropyr").value; // Get the value of the dropdown
       
        $.ajax({
            type: "GET",
            url: "totalReqQty.obj",
            data: {
                cropyr: cropyr, // Use the value of cropyr
                basis: basis    // Basis is already defined
            },
            success: function(result) {
             
                    var jute = jQuery.parseJSON(result);
                    document.getElementById("totalContractedQty").value = jute;
                   // alert(jute)
                 
            },
            error: function(xhr, status, error) {
                alert("Error: " + error); // Improved error handling
            }
        });
    }
</script>

	




  <script>
        $(document).ready(function() {
            $('#myForm').on('submit', function(event) {
                // Disable the submit button
                $('#submit').prop('disabled', true);
                $('#submit').val('Please Wait Processing...');  

              
            });
        });
    </script>






	<script src="https://code.jquery.com/ui/1.13.2/jquery-ui.js"></script>
	<script src="./assets/vendors/metisMenu/dist/metisMenu.min.js"
		type="text/javascript"></script>
	<script src="assets/js/app.min.js" type="text/javascript"></script>

</body>
</html>






