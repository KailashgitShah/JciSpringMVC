<!DOCTYPE html>
<html lang="en">
<%@page import="java.util.List"%>
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
	
	<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<!-- PAGE LEVEL PLUGINS-->
<!-- CORE SCRIPTS-->
<script src="assets/js/app.min.js" type="text/javascript"></script>
<!-- PAGE LEVEL STYLES-->
<style>
.required:after {
	content: " *";
	color: red;
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
				<h1 class="page-title">Sale Price Calculation</h1>
			</div>
			
			<div class="page-content fade-in-up">
				<div class="row">
					<div class="col-md-11">
						<div class="ibox">
							<%--  <% 
                        	List<String> allDpcList = (List) request.getAttribute("allDpcList");
                        %> --%>
							<div class="ibox-body">
								<span>${msg}</span>
								<form action="savesalespricecalculation.obj" method="POST">
									<div class="row">

											

										<div class="col-sm-4 form-group">
											<label class="required">Crop Year</label> <select
												name="crop_year" id="crop_year" class="form-control">
												<option value="">-Select-</option>
												<option value="2021-2022">2021-2022</option>
												<option value="2022-2023">2022-2023</option>
											</select>
										</div>
										<div class="col-sm-4 form-group">
											<label class="required">Center</label> <input type="text"
												name="center" id="center" placeholder="Center"
												class="form-control">
										</div>

										<div class="col-sm-4 form-group">
											<label class="required">Sale Quantity</label> <input
												class="form-control" name="sale_quantity" id="sale_quantity"
												type="text" placeholder="Sale Quantity" required>
										</div>
									</div>
									<div class="row">
										<div class="col-sm-4 form-group">
											<label class="required">Amount</label> <input type="text" name="amount"
												id="amount" class="form-control" placeholder="Amount" required>
										</div>

										<div class="col-sm-4 form-group">
											<label class="required">Jute Variety</label> <Select type="text"
												name="jute_variety" id="jute_variety" class="form-control" 
												required>
														<option disabled selected value>-Select-</option>
												<option value="Mesta">Mesta</option>
													<option value="Bimli">Bimli</option>
												<option value="Tossa">Tossa</option>
												<option value="White">White</option>

											</select>
										</div>

										<div class="col-sm-4 form-group">
											<label class="required">Jute Grade</label> <input type="text"
												name="jute_grade" id="jute_grade" class="form-control" placeholder="Jute Grade"
												required>

										</div>
									</div>
									<div class="row">
										<div class="col-sm-4 form-group">
											<label class="required">Grade Differential</label> <input
												class="form-control" name="grade_differential" id="grade_differential"
												type="text" placeholder="Grade Differential" required>
										</div>

										<div class="col-sm-4 form-group">
											<label class="required">Garsat Rate</label> <input											
												class="form-control" name="garsat_rate" id="garsat_rate"
												type="text" placeholder="Garsat Rate">
										</div>

										<div class="col-sm-4 form-group">
											<label class="required">Base Price</label> <input
												class="form-control" name="base_price" id="base_price"
												type="text" placeholder="Base Price" required>
										</div>


									</div>
									<div class="row">
										<div class="col-sm-4 form-group">
											<label class="required">Bin Number</label> <input
												class="form-control" name="bin_number" id="bin_number"
												type="text" placeholder="Bin Number" required>
										</div>

										<div class="col-sm-4 form-group">
											<label class="required">Operation Cost</label> <input											
												class="form-control" name="operation_cost" id="operation_cost"
												type="text" placeholder="Operation Cost">
										</div>

										<div class="col-sm-4 form-group">
											<label class="required">Insurance</label> <input
												class="form-control" name="Insurance" id="Insurance"
												type="text" placeholder="Insurance" required>
										</div>


									</div>
									<div class="row">
										<div class="col-sm-4 form-group">
											<label class="required">Freight</label> <input
												class="form-control" name="freight" id="freight"
												type="text" placeholder="Freight" required>
										</div>

										<div class="col-sm-4 form-group">
											<label class="required">Provision From Claim</label> <input											
												class="form-control" name="provision_from_claim" id="provision_from_claim"
												type="text" placeholder="Provision From Claim">
										</div>

										<div class="col-sm-4 form-group">
											<label class="required">Weight Loss</label> <input
												class="form-control" name="weight_loss" id="weight_loss"
												type="text" placeholder="Weight Loss" required>
										</div>


									</div>
									<div class="row">
										<div class="col-sm-4 form-group">
											<label class="required">Marketlevy</label> <input
												class="form-control" name="marketlevy" id="marketlevy"
												type="text" placeholder="Marketlevy" required>
										</div>
		<div class="col-sm-4 form-group">
											<label class="required">Margin</label> <input
												class="form-control" name="marketlevy" id="marketlevy"
												type="text" placeholder="Margin" required>
										</div>
										<div class="col-sm-4 form-group">
											<label class="required">Opportunity Cost </label> <input											
												class="form-control" name="opportunitycostm_argin" id="opportunitycostm_argin"
												type="text" placeholder="Opportunity Cost">
										</div>

								


									</div>
									<div class="row">
		<div class="col-sm-4 form-group">
											<label class="required">Td Five Base Price</label> <input
												class="form-control" name="td_five_baseprice" id="td_five_baseprice"
												type="text" placeholder="Td Five Base Price" required>
										</div>
										</div>
									<div class="row">	
										<div class="form-group">
											<button class="btn btn-success" type="submit">Submit</button>
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

	
	<!-- PAGE LEVEL SCRIPTS-->
</body>
</html>