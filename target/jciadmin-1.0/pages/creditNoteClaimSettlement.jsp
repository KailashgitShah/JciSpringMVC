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
											id="setId" class="form-control" required>
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

							</div>
							<div class="row">
								<div class="col-sm-6 form-group">
									<div id="form3"></div>
								</div>

								<div class="col-sm-6 form-group" style="text-align: right">
									<div id="form5"></div>
								</div>
							</div>
							<div class="row">


								<div class="col-sm-6 form-group">
									<div id="form4"></div>
								</div>
								<div class="col-sm-6 form-group" style="text-align: right">
									<div id="form6"></div>
								</div>
							</div>

							<div class="row">

								<div class="col-sm-12 form-group" >
									<div id="form2" class="scrollmenu"></div>
								</div>

							</div>
							<div class="row">
								<div class="col-sm-4 form-group">
									<div id="form7"></div>
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
	<!-- BEGIN THEME CONFIG PANEL-->

	<!-- END THEME CONFIG PANEL-->
	<!-- BEGIN PAGA BACKDROPS-->

	<!-- PAGE LEVEL SCRIPTS-->
	<div class="sidenav-backdrop backdrop"></div>

	<!-- END PAGA BACKDROPS-->
	<!-- CORE PLUGINS-->



	<script type="text/javascript">
	$(".contractLoader").hide();
		$("#setId")
				.on(
						"change",
						function() {
							var setId = $(this).val(); // Corrected line
							
							$
									.ajax({
										url : 'viewAllChallanOfSettlemetId.obj',
										method : 'GET', // Assuming you want to use GET method
										data : {
											"setId" : setId
										},
										success : function(response) {
											// Parse the JSON response
											
											var data = jQuery
													.parseJSON(response);
											// alert(data);
											// Clear the existing content of the form2 element
											$("#form2").empty();
											console.log(data);
											// Create the table structure
											var contentToDisplay = "<table style='border: 1px solid black; width: 1150px; text-align: center;'>"
													+ "<tr>"
													+ "<th style='border: 1px solid black; text-align: center;' rowspan='2'>S. No.</th>"
													+ "<th style='border: 1px solid black; width: 10%; text-align: center;' rowspan='2'>Challan</th>"
													+ " <th style='border: 1px solid black; width: 5%; text-align: center;' rowspan='2'>Bale Mark</th>"
													+ "<th style='border: 1px solid black; width: 10%; text-align: center;' rowspan='2'>Mr No.</th>"
													+ "<th style='border: 1px solid black; width: 10%; text-align: center;' rowspan='2'>Crop Year</th>"
													+ " <th style='border: 1px solid black; width: 10%; text-align: center;' rowspan='2'>Variety/Grade</th>"
													+ " <th style='border: 1px solid black; width: 10%; text-align: center;' rowspan='2'>No. of Bales</th>"
													+ "<th style='border: 1px solid black; width: 10%; text-align: center;' rowspan='2'>Actual Quantity(Qtls)</th>"
													+ " <th style='border: 1px solid black; width: 15%; text-align: center;' colspan='4'>Claim Percentage(%)</th>"
													+ " <th style='border: 1px solid black; width: 15%; text-align: center;' colspan='4'>Settlement Percentage(%)</th>"
													+ "<th style='border: 1px solid black; width: 5%; text-align: center;' rowspan='2'>Settlement Amount</th>"
													+ "</tr>"
													+ " <tr>"
													+ " <th style='border: 1px solid black; width: 2.5%; text-align: center;'>Quality</th>"
													+ "<th style='border: 1px solid black; width: 2.5%; text-align: center;'>Moisture</th>"
													+ "<th style='border: 1px solid black; width: 2.5%; text-align: center;'>NCV</th>"
													+ "<th style='border: 1px solid black; width: 2.5%; text-align: center;'>Dust</th>"
													+ "<th style='border: 1px solid black; width: 2.5%; text-align: center;'>Quality</th>"
													+ "<th style='border: 1px solid black; width: 2.5%; text-align: center;'>Moisture</th>"
													+ "<th style='border: 1px solid black; width: 2.5%; text-align: center;'>NCV</th>"
													+ "<th style='border: 1px solid black; width: 2.5%; text-align: center;'>Dust</th>"
													+ " </tr>"

											for (var i = 0; i < data.length; i++) {
												contentToDisplay += "<tr>";
												contentToDisplay += "<td style='border: 1px solid black; text-align: center;'>"
														+ (i + 1) + "</td>"; // Displaying row number

												contentToDisplay += "<td style='border: 1px solid black;'>"
														+ data[i][6] + "</td>";
												contentToDisplay += "<td style='border: 1px solid black;'>"
														+ data[i][10] + "</td>"; // Balemark
												contentToDisplay += "<td style='border: 1px solid black;'>"
														+ data[i][7] + "</td>"; // Mr no.
												contentToDisplay += "<td style='border: 1px solid black;'>"
														+ data[i][9] + "</td>";
												contentToDisplay += "<td style='border: 1px solid black;'>"
														+ data[i][12] + "</td>";
												contentToDisplay += "<td style='border: 1px solid black;'>"
														+ data[i][13] + "</td>";
												contentToDisplay += "<td style='border: 1px solid black;'>"
														+ data[i][14] + "</td>"; // Actual Qty
												contentToDisplay += "<td style='border: 1px solid black;'>"
														+ data[i][16] + "</td>";
												contentToDisplay += "<td style='border: 1px solid black;'>"
														+ data[i][17] + "</td>";
												contentToDisplay += "<td style='border: 1px solid black;'>"
														+ data[i][19] + "</td>";
												contentToDisplay += "<td style='border: 1px solid black;'>"
														+ data[i][18] + "</td>";
												contentToDisplay += "<td style='border: 1px solid black;'>"
														+ data[i][24] + "</td>";
												contentToDisplay += "<td style='border: 1px solid black;'>"
														+ data[i][25] + "</td>";
												contentToDisplay += "<td style='border: 1px solid black;'>"
														+ data[i][26] + "</td>";
												contentToDisplay += "<td style='border: 1px solid black;'>"
														+ data[i][27] + "</td>";
												contentToDisplay += "<td style='border: 1px solid black;'>"
														+ data[i][29] + "</td>";//Claim Amount
												contentToDisplay += "</tr>";
											}
											contentToDisplay += "</table>";
											$("#form3").empty();
											var MillText = "<div id='Mill'> Mill Name:<strong>"
													+ data[0][0]
													+ "</strong></div>";
											$("#form3").append(MillText);
											$("#form4").empty();
											// Append Cont value as text
											var ContText = "<div id='Cont'> Contract No.:<strong>"
													+ data[0][1]
													+ "</strong></div>";
											$("#form4").append(ContText);
											$("#form5").empty();
											// Append DI value as text
											var DIText = "<div id='DI'> DI no.:<strong>"
													+ data[0][2]
													+ "</strong></div>";
											$("#form5").append(DIText);
											$("#form6").empty();
											// Append Date value as text (assuming data[0][30] is the correct index)
											var DateText = "<div id='DateInput'> Date of Inspection:<strong>"
													+ (data[0][31] || '')
													+ "</strong></div>";
											$("#form6").append(DateText);

											//Update the content of the form2 element with the constructed table
											$("#form2").html(contentToDisplay);

											// Add space between table and file upload
											$("#form2")
													.append(
															"<div style='height: 20px;'></div>");
											var Total = "<div id='Total'> Total Settlement Amount :<strong>"
													+ (data[0][30])
													+ "</strong></div>";
											$("#form2").append(Total);
											// Add file upload input


											// Add space between file upload and checkbox
											$("#form2")
													.append(
															"<div style='height: 20px;'></div>");

											// Add checkbox and text
											 

											// Add space between checkbox and buttons
											$("#form2")
													.append(
															"<div style='height: 20px;'></div>");

											var confirmButtonHTML = "<button type='button' class='btn btn-success'  onclick='generateCrn()' style='margin-right: 10px;'>Generate Credit Note</button>";

											$("#form2").append(
													confirmButtonHTML);
											/* var rejectButtonHTML = "<button type='button'  onclick='rejectAction()'>Reject</button>"; */
											/* $("#form2").append(rejectButtonHTML); */

										},

										error : function(xhr, status, error) {
											// Handle error
										}
									});
						});

		function generateCrn() {
			 $(".contractLoader").show();
			var setId = $("#setId").val();
			$.ajax({
				type : "POST",
				url : "saveCrnForClaim.obj",
				data : {
					"settlementId" : setId
				},
				success : function(result) {
					 $(".contractLoader").hide();
					window.location.reload();
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
