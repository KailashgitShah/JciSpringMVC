<%@page import="org.apache.poi.util.SystemOutLogger"%>
<%@page import="com.jci.model.Jciclaim_NominationModel"%>
<%@page import="java.util.List"%>
<%@page import="java.time.LocalDate"%>
<%@page import="java.time.LocalDateTime"%>
<%@page import="java.time.format.DateTimeFormatter"%>
<%@page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

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
.required:after {
	content: " *";
	color: red;
}
 
 .input-container input[type="text"] {
     background-color: #E9ECEF; /* Set the background color of the input field */
     border:  1px solid rgba(0,0,0,.15);  /* Optional: Remove border for a clean look */
    
     padding :1px 5px 1px 5px;
     width:200px;
  
     
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
				<h1 class="page-title">Nomination of Officials for Claim
					Settlement</h1>
			</div>

			<%
			// Author vishal
			%>
			<div class="page-content fade-in-up">
				<div class="row">
					<div class="col-md-11">
						<div class="ibox">
							<span>${msg}</span>
							<div class="ibox-body">
								<form action="savenominal.obj" method="POST">
									<div class="row">

										<div class="col-sm-4 form-group">
											<label> Mill</label> <span class="text-danger">* </span> <select
												name="Mill" id="Mill" class="form-control taxtbox" required>
											 	<option value="">Select</option> 
												
											<c:forEach items="${millid}" var="item">
											<!-- <option disabled selected value>-Select-</option> -->
												 <option value="${item}">${item}</option> 
												</c:forEach> 


											</select>
										</div>



										<div class="col-sm-4 form-group">
											<label>Contract No</label> <select name="ContractNo"
												id="ContractNo" class="form-control taxtbox" required>
												<option value="">Select</option>

												<c:forEach items="${contractno}" var="item">
													<option value="${item}">${item}</option>
												</c:forEach>


											</select>
										</div>

										<div class="col-sm-4 form-group">
											<label>Challan No</label> <input class="form-control taxtbox"
												name="ChallanNo" id="ChallanNo" type="text" required
												readonly="readonly">
										</div>
									</div>

									<div class="row">

										<!-- <div class="col-sm-4 form-group">
											<label>MR No</label> <input class="form-control taxtbox"
												name="MRNo" id="MRNo" type="text" required
												readonly="readonly">
										</div> -->
										<div class="col-sm-4 form-group">
											<label>MR No</label> <input class="form-control taxtbox"
												name="Mr_No" id="MRNo" type="text" required
												readonly="readonly">
										</div>
										
										<div class="col-sm-4 form-group">
											<label>Bale Mark</label> <input class="form-control taxtbox"
												id="BaleMark" name="BaleMark" type="text" required
												readonly="readonly">
										</div>
                                            <div class="col-sm-4 form-group">
											<input type="hidden"
												class="form-control taxtbox" name="Settlement_id_generated"
												id="SettlementId" type="text" required readonly="readonly">
										</div> 
										
								

									</div>


									<!--  For Showing the grade wise jute variety -->
									<div class="row" >

										<span style="font-size: 15px"> Jute Variety Grade wise</span>

									</div>

									<div class="row">

										<div class="col-sm-4 form-group">
												 <div class="input-container">
												    <label for="field1">grade 1:</label>
												    <input type="text"  id="g1" name="g1" readonly="readonly">
												  </div>

											
											<!-- <div class="input-container">
												 <label  for="field1">grade 1:</label> <input  type="text" 
													id="g1" name="g1"  readonly="readonly"> 
												</div> -->

											 <div class="input-container">
												<label for="field2">grade 2:</label> <input   type="text"
													id="g2" name="g2" readonly="readonly">
											</div> 

											<div class="input-container">
												<label for="field3">grade 3:</label> <input type="text"
													id="g3" name="g3" readonly="readonly">
											</div>

											<div class="input-container">
												<label for="field4">grade 4:</label> <input  type="text"
													id="g4" name="g4" readonly="readonly">
											</div>

											<div class="input-container">
												<label for="field5">grade 5:</label> <input  type="text"
													id="g5" name="g5" readonly="readonly">
											</div>

											<div class="input-container">
												<label for="field6">grade 6:</label> <input  type="text"
													id="g6" name="g6" readonly="readonly">
											</div>

										</div>


										<div class="col-sm-4 form-group">

											<div class="input-container">
												<label for="q1">Qty 1:</label> <input   type="text" id="q1"
													name="q1" readonly="readonly">
											</div>

											<div class="input-container">
												<label for="q2">Qty 2:</label> <input  type="text" id="q2"
													name="q2" readonly="readonly">
											</div>

											<div class="input-container">
												<label for="q3">Qty 3:</label> <input  type="text" id="q3"
													name="q3" readonly="readonly">
											</div>

											<div class="input-container">
												<label for="q4">Qty 4:</label> <input  type="text" id="q4"
													name="q4" readonly="readonly">
											</div>

											<div class="input-container">
												<label for="q5">Qty 5:</label> <input  type="text" id="q5"
													name="q5" readonly="readonly">
											</div>

											<div class="input-container">
												<label for="q6">Qty 6:</label> <input  type="text" id="q6"
													name="q6"   readonly="readonly">
											</div>



										</div>

									</div>

									<!-- End the grade wise -->
									<div class="row">

										<div class="col-sm-4 form-group">
											<label>Crop Year</label> <input class="form-control taxtbox"
												name="CropYear" id="CropYear" type="text"
												placeholder="Crop Year" required readonly="readonly">
										</div>

										<div class="col-sm-4 form-group">
											<label>Quality Claim</label> <input
												class="form-control taxtbox" name="QualityClaim"
												id="QualityClaim" type="text" placeholder="  Quality Claim"
												required readonly="readonly">
										</div>

										<div class="col-sm-4 form-group">
											<label>Moisture Content</label> <input
												class="form-control taxtbox" name="MoistureContent"
												id="MoistureContent" type="number"
												placeholder="Moisture Content" required readonly="readonly">
										</div>

									</div>
									<div class="row">

										<div class="col-sm-4 form-group">
											<label>NCV Percentage</label> <input class="form-control"
												name="NCVPercentage" id="NCVPercentage" type="number"
												readonly="readonly">
										</div>

										<div class="col-sm-4 form-group">
											<label>Claim Amount</label> <input
												class="form-control taxtbox" name="ClaimAmount"
												id="ClaimAmount" min="0" type="number">
										</div>



										<div class="col-sm-4 form-group">
											<label>O&M Official</label> <span class="text-danger">*
											</span> <select name="omofficial" id="omofficial"
												class="form-control taxtbox" required>
												<option value="">Select</option>

												<c:forEach items="${OM_official}" var="item">
													<option value="${item}">${item}</option>
												</c:forEach>


											</select>
										</div>



									</div>

									<div class="row">

										<div class="col-sm-4 form-group">
											<label>F&A Official</label> <span class="text-danger">*
											</span> <select name="FAomofficial" id="FAofficial"
												class="form-control taxtbox" required>
												<option value="">Select</option>

												<c:forEach items="${FA_official}" var="item">
													<option value="${item}">${item}</option>
												</c:forEach>


											</select>

										</div>


									<!--  <div class="col-sm-4 form-group">
											<label> Date of Inspection</label> <input
												class="form-control taxtbox" id="DateofInpection"
												name="DateofInpection" type="date"
												placeholder="Enter Date of Inspection" required>
										</div>  -->
										 <div class="col-sm-4 form-group">
											<label> Date of Inspection</label> <input
												class="form-control taxtbox" id="DateofInpection"
												name="DateofInpection" 
												placeholder="dd-mm-yyyy" required >
										</div> 
									

										

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

<link rel="stylesheet" href="//code.jquery.com/ui/1.13.2/themes/base/jquery-ui.css">
<link rel="stylesheet" href="/resources/demos/style.css"> 
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
<script src="https://code.jquery.com/ui/1.13.2/jquery-ui.js"></script>
 <script>
	$( "#DateofInpection" ).datepicker({ dateFormat: 'dd-mm-yy'    });
	
</script>




	<script type="text/javascript">
		$(document).ready(function() {
			$("#submit").click(function() {
				//  Write code if Required

			});
		});
	</script>




	<!-- 	AJAX Call for Fetching Mill Receipt Data -->

	<script type="text/javascript">
		// Wait for the document to be ready
		$(document).ready(function() {
			// Add an event listener for the change event on the dropdown

			$('#Mill').on('change', function() {
				// Get the selected option value
				var selectedOption = $(this).val();
				//alert( selectedOption)

				// Make an AJAX call to fetch data based on the selected value
				$.ajax({
					type : 'GET', // You can adjust the HTTP method as needed (e.g., POST)
					url : 'fetchmillreceiptdata.obj', // Replace with the actual API endpoint
					data : {
				
						millid : selectedOption
						//mill_name : selectedOption
					}, // Pass the selected option to the server
					success : function(data) {
						// Handle the response data and display it.
                  //   alert(data + "dataaaaaaaaaaaaa")
					

						// Parse the JSON response
					var response = JSON.parse(data);
             	//	var rolename = JSON.parse(data)
             	
                    /*  var s = "<option disabled selected value>-Select-</option>";
     				for (var i = 0; i < response.length; i++) {
     					s += '<option value="' + response[i].split("-")[0] + ','
     							+ response[i].split("-")[1] + '">'
     							+ response[i].split("-")[1] + '</option>';
     				}

					 */
                      
						var innerArray1 = response[0];

						// Access the elements within the inner array
						var ChallanNo = innerArray1[0];
						var MRNo = innerArray1[1];
						var BaleMark = innerArray1[2];
						var CropYear = innerArray1[3];
						var QualityClaim = innerArray1[4];
						var MoistureContent = innerArray1[5];
						var NCVPercentage = innerArray1[6];
						//var mill_name = innerArray1[7];
						//alert(mill_name)
						
						
						

						// For DateofInpection value settingbased on MRs
						var DateofInpection = MRNo + "0";

						$('#ChallanNo').val(ChallanNo); // Setting Data In JSP Text Field

						$('#MRNo').val(MRNo);
						$('#BaleMark').val(BaleMark);
						$('#CropYear').val(CropYear);
						$('#QualityClaim').val(QualityClaim);
						$('#MoistureContent').val(MoistureContent);
						$('#NCVPercentage').val(NCVPercentage);

						// Generating the Settlement id using MRNo and For Increment using Count

						var Settlementid = MRNo.toString() + ${total};

						$('#SettlementId').val(Settlementid);

					},
					error : function(err) {
						// Handle errors here
						console.error('AJAX request failed: ' + err);
					}

				});
			});
		});
	</script>

	<!--  For Fetching the Grade_Composition based on Contract Number -->

	<script type="text/javascript">
		$(document).ready(function() {
			// Add an event listener for the change event on the dropdown
			$('#ContractNo').on('change', function() {
				// Get the selected option value
				var selectedOption = $(this).val();
			

				$.ajax({
					type : 'GET',
					url : 'gradecomposition1.obj',
					data : {
						ContractNo : selectedOption
					},
					success : function(data) {

						// For Setting the value for Grade Composition

						// Parse the JSON response

						

						var response = JSON.parse(data);
						

						var innerArray1 = response[0];
						var innerArray2 = response[1];
						var innerArray3 = response[2];
						var innerArray4 = response[3];
						var innerArray5 = response[4];
						var innerArray6 = response[5];

						

						// Access the elements within the inner array
						var g1 = innerArray1[0];
						var q1 = innerArray1[1];

						var g2 = innerArray2[0];
						var q2 = innerArray2[1];
						

						var g3 = innerArray3[0];
						var q3 = innerArray3[1];

						var g4 = innerArray4[0];
						var q4 = innerArray4[1];

						var g5 = innerArray5[0];
						var q5 = innerArray5[1];

						var g6 = innerArray6[0];
						var q6 = innerArray6[1];

						$('#g1').val(g1); // Setting Data In JSP Text Fieldf
						$('#q1').val(q1);

						$('#g2').val(g2);
						$('#q2').val(q2);

						$('#g3').val(g3);
						$('#q3').val(q3);

						$('#g4').val(g4);
						$('#q4').val(q4);

						$('#g5').val(g5);
						$('#q5').val(q5);

						$('#g6').val(g6);
						$('#q6').val(q6);

					},
					error : function(err) {
						// Handle errors here
						console.error('AJAX request failed: ' + err);
					}
				});
			});
		});
	</script>


	<!--   For Hinding and Showing the  Grade Wise Alloction-->

	<script type="text/javascript">
		$(document).ready(function() {
			// Add an event listener for the change event on the dropdown
/* 
			$('.input-container').hide();

			$('span').hide();
 */
		/* 	$('#ContractNo').on('change', function() {
				// Get the selected option value
				var selectedOption = $(this).val();
				if (selectedOption != '') {
					$('.input-container').show();
					$('span').show();
				} else {
					$('.input-container').hide();

				}

			}); */
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

	<!-- PAGE LEVEL SCRIPTS-->
</body>
</html>