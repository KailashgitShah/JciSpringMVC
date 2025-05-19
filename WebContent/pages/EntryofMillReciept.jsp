<%@page import="com.mashape.unirest.http.options.Option"%>
<%@page import="java.util.List"%>
<%@page import="java.time.LocalDate"%>
<%@page import="java.time.LocalDateTime"%>
<%@page import="com.jci.model.MillRecieptModel"%>
<%@page import="com.jci.model.EntryPaymentDetailsModel"%>
<%@page import="com.jci.model.MillreceiptDto"%>
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
<link rel="stylesheet" href="assets/css/chosen.css">

<!-- PAGE LEVEL STYLES-->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.13.2/themes/base/jquery-ui.css">
<link rel="stylesheet" href="/resources/demos/style.css">
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
<script src="https://code.jquery.com/ui/1.13.2/jquery-ui.js"></script>
<!-- <script
	src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.5.0/js/bootstrap-datepicker.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script> -->
<!-- CORE SCRIPTS-->

<style>
.required:after {
	content: " *";
	color: red;
}

#milldetailsTable {
	display: none;
}

#childTable {
	display: none;
}
/* CSS classes for the green link */
.table-cell {
	width: 250px;
	height: 20px;
}

#childTable {
	width: 100%; /* Ensure the table takes the full width */
	table-layout: fixed; /* Fix the table layout */
}

.colored-cell {
	color: green;
}

.colored-cell:hover {
	color: blue;
}

.form-check-input {
	margin-right: 10px;
	vertical-align: middle;
}

.alert {
	padding: 10px;
	margin-bottom: 20px;
	border: 1px solid transparent;
	border-radius: 4px;
	/* Match width and height */
	width: 100%;
	height: 100%;
}

.alert-info {
	color: #31708f;
	background-color: #d9edf7;
	border-color: #bce8f1;
}

#HODate {
	height: 150px;
	width: 100%;
	overflow-x: auto;
	white-space: nowrap;
}
</style>
</head>
<body class="fixed-navbar" onload="myFunction()">
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
				<h1 class="page-title">Entry of Mill Reciept</h1>
			</div>

			<%
			List<Object> getdataList1 = (List<Object>) request.getAttribute("getdataList1");
			List<Object[]> fetchMill_NameR = (List<Object[]>) request.getAttribute("fetchMill_NameR");

			String date = (String) request.getAttribute("parsed");

			String millnameMR = "";
			String field1 = "";
			%>
			<div class="page-content fade-in-up">
				<div class="row">
					<div class="col-md-11">
						<div class="ibox">
							<span id="flashMessage">${msg}</span>
							<div class="ibox-body">
								<form action="saveentryofMillreciept.obj" method="POST">
									<div class="child-checkbox" id="disableform">
										<div class="row">
											<div id="messageContainer" style="display: none;"
												class="alert alert-info">MR No has been received for
												this HO DI.</div>
											<div class="col-sm-4 form-group">
												<label>Mill name </label> <span class="text-danger">*
												</span>&nbsp; <span id="Mill_name" name="Mill_name"
													class="text-danger"> </span> <select name="Mill_name"
													id="Mill_name1" class="form-control taxtbox" required>
													<option value="">-Select-</option>
													<%
													for (Object[] row : fetchMill_NameR) {
														field1 = (String) row[0];
														millnameMR = (String) row[0];
														String field2 = (String) row[1];
														String unit = (String) row[2];
													%>
													<option value="<%=field2%>"><%=field1%> - Unit:
														<%=unit%>
													</option>
													<%
													}
													%>
												</select>

											</div>

											<!--   <div class="col-sm-4 form-group">
	                                             <label>HO DI </label>
	                                              <span class="text-danger">* </span>&nbsp; <span id="HO_DI_&_Date" name="HO_DI_&_Date" class="text-danger"> </span>
	                                        	<select name="HO_DI_&_Date" id="HODate" class="form-control taxtbox" required>
													   <option value="">-Select-</option> 
													</select>
                                        </div>   -->

											<!-- 			<div class="col-sm-4 form-group">
												<label>HO DI </label> <span class="text-danger">* </span>&nbsp;
												<span id="HO_DI_&_Date" name="HO_DI_&_Date"
													class="text-danger"> </span> <select name="HO_DI_&_Date"
													id="HODate" class="form-control " required multiple>
												</select>

											</div> -->
											<div class="col-sm-4 form-group" id="HODateDiv">
												<label class="required">HO DI</label> &nbsp; <select
													name="HO_DI_&_Date" id="HODate" class="form-control"
													required multiple>
													<option disabled selected value="">-Select</option>
												</select>
											</div>


											<div class="row">
												<div class="col-sm-10">
													<div class="table-responsive">
														<table id="milldetailsTable" class="table table-bordered">
															<thead class="thead-light">
																<tr>
																	<th>Challan No</th>
																	<th>Date of Shipment</th>
																	<th>Vehicle No</th>
																	<th>DI date</th>
																	<th>ContractNO</th>

																</tr>
															</thead>
															<tbody>
																<!-- Dynamically generated rows will be appended here -->
															</tbody>
														</table>
													</div>
												</div>
											</div>



										</div>

										<table id="childTable" name="chilnametable"
											class="table table-bordered">
											<thead class="thead-light">
												<tr>
													<th>Challan no</th>
													<th>Bale Mark</th>
													<th>Jute_variety</th>
													<th>Jute_grade</th>
													<th>Crop_year</th>
													<th>Nominal_qty</th>
													<!--  <th>claim </th>
											              <th>Claim Type </th>
											              <th> </th> -->
													<th>Quality percent</th>
													<th>Shortage qty</th>
													<th>Moisture Content</th>
													<th>Ncv percentage</th>
													<th>Ncv qty</th>
													<th>Mill receipt qty</th>

												</tr>
											</thead>
											<tbody>
												<!-- Data rows will be dynamically added here -->
											</tbody>
										</table>






										<div class="row">

											<div class="col-sm-2 form-group" style="display: none;">
												<label"display:none;">ClientPan </label> <span
													class="text-danger">* </span>&nbsp; <input type="hidden"
													class="form-control" name="millcode" id="millcode1"
													value="" readonly="readonly">
											</div>
											<div class="col-sm-2 form-group" style="display: none;">
												<label"display:none;">firstloop</label> <span
													class="text-danger">* </span>&nbsp; <input
													class="form-control" name="firstloop" id="firstloop1"
													value="" readonly="readonly">
											</div>
											<div class="col-sm-2 form-group" style="display: none;">
												<label"display:none;" >rowindex </label> <span
													class="text-danger">* </span>&nbsp; <input
													class="form-control" name="rowindex2" id="rowindex2"
													value="" readonly="readonly">
											</div>

											<div class="col-sm-2 form-group" style="display: none;">
												<label"display:none;"  >millname234 </label> <span
													class="text-danger">* </span>&nbsp; <input
													class="form-control" name="rowindex2" id="millname234"
													value="" readonly="readonly">
											</div>






										</div>


										<!--   <div class="row">
                                      
                                    	
                                                <div class="col-sm-12 form-group">
									             <input type="submit" value="Submit"class="btn btn-primary" id="submit">
									            </div>
									           
									          </div> -->
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


	<!-- <script>
		$(document).ready(function() {

			$("#HODate").chosen(); //  select element with the Chosen plugin
			$("#HODate").addClass("chosen-select"); // Add the 'chosen-select' 

			$("#HODate").on("change", function() {
				var selectedVal = $(this).val(); // Get the selected value 

			});

			$("#HODate option").prop('selected', false); // Deselect all options initially
			$("#HODate").trigger('chosen:updated'); // Update the Chosen

		});
	</script> -->


	<script type="text/javascript">
		$(document).ready(function() {
			$("#submit").click(function() {

				var contractdate = $("#Date_of_Shipment134").val();
				var instdate = $("#HO_Date1").val();
				var instdate1 = $("#MR_Date1").val();

				if (contractdate == "" || instdate == "" || instdate1 == "") {
					alert("Please select mandatory Fields!");
				}
			});
		});

		const dateInput = document.getElementById("Date_of_Shipment");
		dateInput
				.addEventListener(
						"change",
						function() {
							const selectedDate = this.value;
							const dateParts = selectedDate.split("-");
							const formattedDate = dateParts[2] + "-"
									+ dateParts[1] + "-" + dateParts[0];
							document.getElementById("Date_of_Shipment").textContent = formattedDate;
						});
	</script>


	<script type="text/javascript">
		$(document)
				.ready(
						function() {
							$('#Mill_name1')
									.on(
											'change',
											function() {
												// Clear values and hide table
												$('#HODate').val('');
												$('#millcode1').val('');
												$('#milldetailsTable').css(
														'display', 'none');

												var field2Value = $(this).val();

												$
														.ajax({
															type : 'GET',
															url : 'millreceiptbased.obj',
															data : {
																"millname" : field2Value
															},
															success : function(
																	data) {
																var dataArray = JSON
																		.parse(data);

																//var htmlEle = "<label class='required'>HO DI</label> <select data-placeholder='Choose HO DI...' class='chosen-select form-control ' name='HODate'  multiple tabindex='3' id = 'HODate'>";

																var htmlEle = "";

																dataArray
																		.forEach(function(
																				innerArray) {
																			htmlEle += "<option value='"+innerArray[0]+"' data-value1='"+innerArray[0]+"' data-value2='"+innerArray[2]+"' >"
																					+ innerArray[0]
																					+ "</option>";
																		});

																//	htmlEle += "</select>";

																$("#HODate")
																		.html(
																				htmlEle);
																//$("#HODate").chosen();
																//$("#HODate").addClass("chosen-select");
															},
															error : function(
																	xhr,
																	status,
																	error) {
																console
																		.error(
																				"AJAX Error:",
																				status,
																				error);
															}
														});
											});
						});
	</script>

	<script type="text/javascript">
		// Use delegated event binding
		$(document)
				.on(
						'change',
						'#HODate',
						function() {

							var hoDiNos = [];
							var contractNos = [];
							$("#HODate").find("option:selected").each(
									function() {
										var hodi = $(this).val();
										var contract = $(this).attr(
												"data-value2");
										hoDiNos.push(hodi);
										contractNos.push(contract);
									});

							function formatDate(date) {
								var day = date.getDate().toString().padStart(2,
										'0');
								var month = (date.getMonth() + 1).toString()
										.padStart(2, '0');
								var year = date.getFullYear();
								return day + '/' + month + '/' + year;
							}

							var jsonhoDiNos = JSON.stringify(hoDiNos);

							$
									.ajax({
										type : 'GET',
										url : 'fetchingdata.obj',
										data : {
											"hoDiNos" : jsonhoDiNos
										},
										success : function(data) {

											var dataArray = JSON.parse(data);

											$('#milldetailsTable tbody')
													.empty();
											if (dataArray.length > 0) {
												var count = 0;
												dataArray
														.forEach(function(
																rowData) {

															
															var millNameValue1 = $('#millname234').val();
															
															var currentDate = new Date()
																	.toISOString()
																	.split('T')[0];
															 
															var rowHtml = '<tr>'
																	/*  + '<td><div class="table-cell colored-cell" id="myCell"' + count + '" data-id="' + rowData[0] + '" ><input type="hidden" name="challanNo[]" value="' + rowData[0] + '"> <a href="#" class="green-link">${rowData[0]}</a> '
																	 + rowData[0]
																	 + '</div></td>' */

																	+ '<td><a href="EntryofMillreceiptChild.obj?challanno='
																	+ rowData[0]
																	+ '&millName='
																	+ encodeURIComponent(millNameValue1)
																	+ '&cropyear='
																	+  encodeURIComponent(rowData[6])
																	+ '" class="green-link" target="_blank">'+rowData[0]+'</a> '
							
																	+ '</div></td>'

																	+ '<td><div class="table-cell"><input type="hidden" name="dateOfShipment[]" value="'
																	+ formatDate(new Date(
																			rowData[1]))
																	+ '">'
																	+ formatDate(new Date(
																			rowData[1]))
																	+ '</div></td>'
																	+ '<td><div class="table-cell"><input type="hidden" name="vehicleNo[]" value="' + rowData[2] + '">'
																	+ rowData[2]
																	+ '</div></td>'
																	+ '<td><div class="table-cell"><input type="hidden" name="diDate[]" value="' + rowData[3] + '">'
																	+ rowData[3]
																	+ '</div></td>'
																	+ '<td><div class="table-cell"><input type="hidden" name="ContractNo[]" value="' + rowData[4] + '">'
																	+ rowData[4]
																	+ '</div></td>'
																	+ '<td style="display:none;"><div class="table-cell"><input type="hidden" name="millcode[]" value="' + rowData[4] + '">'
																	+ rowData[7]
																	+ '</div></td>'
																	+

																	'</tr>';

															$(
																	'#milldetailsTable tbody')
																	.append(
																			rowHtml);

														});

												$('#milldetailsTable').css(
														'display', 'block');
											} else {
												$('#milldetailsTable').css(
														'display', 'none');
											}
										}
									});

						});
	</script>



	<!-- <script type="text/javascript">
		$(document)
				.ready(
						function() {

							$('#HODate')
									.on(
											'change',
											function() {
												var field2Value = $(this).find(
														':selected').attr(
														'data-value2');
												var field1Value = $(this).find(
														':selected').attr(
														'data-value1');

												// Function to format date
												function formatDate(date) {
													var day = date.getDate()
															.toString()
															.padStart(2, '0');
													var month = (date
															.getMonth() + 1)
															.toString()
															.padStart(2, '0');
													var year = date
															.getFullYear();
													return day + '/' + month
															+ '/' + year;
												}

												$
														.ajax({
															type : 'GET',
															url : 'findmillreceiptNO.obj',
															data : {
																"hodino" : field1Value
															},
															success : function(
																	data) {

																var jsonResponse = JSON
																		.parse(data);
																var dataFoundValue = jsonResponse.dataFound;

																/*  if (dataFoundValue === false) { */
																$('#MR_No')
																		.prop(
																				'readonly',
																				false);
																$('#MR_Date1')
																		.prop(
																				'readonly',
																				false);
																$(
																		'#Mill_Reciept_Qty')
																		.prop(
																				'readonly',
																				false);

																$(
																		'#messageContainer')
																		.hide();
																// AJAX request for fetching data
																$
																		.ajax({
																			type : 'GET',
																			url : 'fetchingdata.obj',
																			data : {
																				"contractno" : field1Value
																			},
																			success : function(
																					data) {

																				var dataArray = JSON
																						.parse(data);
																				$(
																						'#milldetailsTable tbody')
																						.empty();
																				if (dataArray.length > 0) {
																					var millNameValue1 = $(
																							'#millname234')
																							.val();
																					dataArray
																							.forEach(function(
																									rowData) {
																								var currentDate = new Date()
																										.toISOString()
																										.split(
																												'T')[0];
																								var rowHtml = '<tr>'
																										/*    + '<td><div class="table-cell colored-cell" id="myCell" data-id="' + rowData[0] + '" ><input type="hidden" name="challanNo[]" value="' + rowData[0] + '"> <a href="#" class="green-link">${rowData[0]}</a> '
																										   + rowData[0]
																										   + '</div></td>' */

																										+ '<td><div class="table-cell colored-cell" id="myCell" data-id="' + rowData[0] + '" ><a href="EntryofMillreceiptChild.obj?challanno='
																										+ rowData[0]
																										+ '&millName='
																										+ encodeURIComponent(millNameValue1)
																										+ '&cropyear='
																										+ encodeURIComponent(cropyear)
																										+ ' class="green-link">${rowData[0]}</a> '
																										+ rowData[0]
																										+ '</div></td>'

																										/*      	var url = 'EntryofMillreceiptChild.obj';
																												url += '?challanno=' + encodeURIComponent(id);
																												url += '&millName='
																														+ encodeURIComponent(millNameValue1);
																												url += '&cropyear='
																														+ encodeURIComponent(cropyear); */

																										+ '<td><div class="table-cell"><input type="hidden" name="dateOfShipment[]" value="'
																										+ formatDate(new Date(
																												rowData[1]))
																										+ '">'
																										+ formatDate(new Date(
																												rowData[1]))
																										+ '</div></td>'
																										+ '<td><div class="table-cell"><input type="hidden" name="vehicleNo[]" value="' + rowData[2] + '">'
																										+ rowData[2]
																										+ '</div></td>'
																										+ '<td><div class="table-cell"><input type="hidden" name="diDate[]" value="' + rowData[3] + '">'
																										+ rowData[3]
																										+ '</div></td>'
																										+ '<td><div class="table-cell"><input type="hidden" name="ContractNo[]" value="' + rowData[4] + '">'
																										+ rowData[4]
																										+ '</div></td>'
																										+
																										/*  '<td><div class="table-cell"><input type="hidden" name="shortQty[]" value="' + rowData[5] + '">' + rowData[5] + '</div></td>' +
																										 */'<td style="display:none;"><div class="table-cell"><input type="hidden" name="millcode[]" value="' + rowData[4] + '">'
																										+ rowData[7]
																										+ '</div></td>'
																										+

																										'</tr>';

																								$(
																										'#milldetailsTable tbody')
																										.append(
																												rowHtml);

																							});

																					document
																							.getElementById("firstloop1").value = firstloopindex;
																					$(
																							'#milldetailsTable')
																							.css(
																									'display',
																									'block');
																				} else {
																					$(
																							'#milldetailsTable')
																							.css(
																									'display',
																									'none');
																				}
																			}
																		});

															}
														});
											});
						});
	</script>
 -->


	<!-- <script>
		$(document).ready(
				function() {
					$('#milldetailsTable').on(
							'click',
							'#myCell',
							function(e) {
								e.preventDefault();
								var id = $(this).data('id');
								var millNameValue1 = $('#millname234').val(); // Get the value from #Mill_name1
								var cropyear = $('#HODate').find(':selected')
										.attr('data-value1'); // Get the data-value2 attribute
								// Get the data-value2 attribute

								// Construct the URL with the parameters
								var url = 'EntryofMillreceiptChild.obj';
								url += '?challanno=' + encodeURIComponent(id);
								url += '&millName='
										+ encodeURIComponent(millNameValue1);
								url += '&cropyear='
										+ encodeURIComponent(cropyear);
								console.log(id, millNameValue1, cropyear);
								window.open(url, '_blank');
							});
				});
	</script> -->



	<script>
		$(document).ready(function() {

			$('#Mill_name1').on('change', function() {

				var selectedText = $("#Mill_name1 option:selected").text();

				$('#millname234').val(selectedText);

			});
		});
	</script>



	<script>
		$(document).ready(function() {

			setTimeout(function() {
				$('#flashMessage').fadeOut('slow');
			}, 3000);
			ded
		});
	</script>





	<!-- END PAGA BACKDROPS-->
	<!-- CORE PLUGINS-->
	<script src="./assets/vendors/jquery/dist/jquery.min.js"
		type="text/javascript"></script>
	<script src="assets/css/chosen.jquery.js" type="text/javascript"></script>

	<!-- 	<script src="./assets/vendors/popper.js/dist/umd/popper.min.js"
		type="text/javascript"></script>
	<script src="./assets/vendors/bootstrap/dist/js/bootstrap.min.js"
		type="text/javascript"></script>
	<script src="./assets/vendors/metisMenu/dist/metisMenu.min.js"
		type="text/javascript"></script>
	<script
		src="./assets/vendors/jquery-slimscroll/jquery.slimscroll.min.js"
		type="text/javascript"></script>
	PAGE LEVEL PLUGINS
	CORE SCRIPTS
	<script src="assets/js/app.min.js" type="text/javascript"></script> -->

	<!-- PAGE LEVEL SCRIPTS-->
</body>
</html>
