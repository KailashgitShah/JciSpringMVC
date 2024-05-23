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
<!-- PAGE LEVEL PLUGINS-->
<!-- CORE SCRIPTS-->
<script src="assets/js/app.min.js" type="text/javascript"></script>
 <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
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
				<h1 class="page-title">Entry of Operation Cost & other price variables </h1>
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
								<form action="saveentryofoperationcost.obj" method="POST">
									<div class="row">

										<div class="col-sm-4 form-group">
											<label class="required">Date Of Effect</label> <input type="date"
												name="date_of_effect" id="date_of_effect"
												class="form-control">
										</div>


										<div class="col-sm-4 form-group">
											<label class="required">Crop Year</label> <select
												name="crop_year" id="crop_year" class="form-control">
												<option option disabled selected value>-Select-</option>
												<option value="2021-2022">2021-2022</option>
												<option value="2022-2023">2022-2023</option>
											</select>
										</div>

										<div class="col-sm-4 form-group">
											<label class="required">Operation Cost</label> <input
												class="form-control" name="operation_cost" id="operation_cost"
												type="number" placeholder="Operation Cost" >
										</div>
									</div>
									<div class="row">
										<div class="col-sm-4 form-group">
											<label class="required">Insurance</label> <input type="number" name="insurance"
												id="insurance" class="form-control" placeholder="Insurance" required>
												
										</div>

										<div class="col-sm-4 form-group">
											<label class="required">Freight</label> <input type="number"
												name="freight" id="freight" class="form-control" placeholder="Freight"
												required>

											
										</div>

										<div class="col-sm-4 form-group">
											<label class="required">Provision From Claim</label> <input type="number"
												name="provision_from_claim" id="provision_from_claim" class="form-control" placeholder="Provision From Claim"
												required>

											</select>
										</div>
									</div>
									<div class="row">
										<div class="col-sm-4 form-group">
											<label class="required">Weight Loss</label> <input
												class="form-control" name="weight_loss" id="weight_loss"
												type="number" placeholder="Weight Loss" required>
										</div>

										
										<div class="col-sm-4 form-group">
											<label class="required">Market Levy</label> <input
												class="form-control" name="market_levy" id="market_levy"
												type="number" placeholder="Market Levy">
										</div>

										<div class="col-sm-4 form-group">
											<label class="required">Margin</label> <input
												class="form-control" name="margin" id="margin"
												type="number" placeholder="Margin" required>
										</div>
										<div class="col-sm-4 form-group">
											<label class="required">Opportunity Cost</label> <input
												class="form-control" name="opportunity_cost" id="opportunity_cost"
												type="number" placeholder="Opportunity Cost" required>
										</div>

									</div>

									<div class="row">	
										<div class="form-group">
											<button class="btn btn-default" type="submit">Submit</button>
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