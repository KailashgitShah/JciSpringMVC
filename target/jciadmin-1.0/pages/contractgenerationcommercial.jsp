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
				<h1 class="page-title">Contract Generation </h1>
			</div>

			<div class="page-content fade-in-up">
				<div class="row">
					<div class="col-md-11">
						<div class="ibox">

							<div class="ibox-body">
								<span>${msg}</span>
								<form action="savecontractgenerationcommercial.obj" method="POST">
									<div class="row">
										<div class="col-sm-4 form-group">
											<label class="required">Contract Type</label> <Select
												type="text" name="contracttype" id="contracttype"
												class="form-control">
													<option disabled selected value>-Select-</option>
												<option value="Commercial ">Commercial </option>
												<option value="Daily Sales ">Daily Sales </option>
												<option value="Free Sale">Free Sale</option>
												</select>
										</div>
												<div class="col-sm-4 form-group">
											<label class="required">Contract Number</label> <input
												type="number" name="contract_num"
												id="contract_num" class="form-control" placeholder="Contract Number" required>

										</div>

										<div class="col-sm-4 form-group">
											<label class="required">Contract Date</label> <input
												type="date" name="contract_date" id="contract_date"
												class="form-control">

										</div>

								
									</div>
									<div class="row">
									
											<div class="col-sm-4 form-group">
											<label class="required">Full Contract Number</label> <input
												class="form-control" name="fullPcontactnum"
												id="fullPcontactnum" type="text" placeholder="Full Contract Number"
												required>
										</div>
					

										<div class="col-sm-4 form-group">
											<label class="required">Variety-Grade Wise Quantity</label> <input
												type="text" name="variety_grade_wise_quantity"
												id="variety_grade_wise_quantity" class="form-control" placeholder="Variety-Grade Wise Quantity" required>

										</div>

													<div class="col-sm-4 form-group">
											<label class="required">Crop Year</label> <select
												name="crop_year" id="crop_year" class="form-control"
												required>
												<option disabled selected value >-Select-</option>
												<option value="2021-2022">2021-2022</option>
												<option value="2022-2023">2022-2023</option>
												<option value="2022-2023">2023-2024</option>
												<option value="2022-2023">2024-2025</option>
												<option value="2022-2023">2025-2026</option>
												<option value="2022-2023">2026-2027</option>
												<option value="2022-2023">2027-2028</option>
												<option value="2022-2023">2028-2029</option>
												<option value="2022-2023">2029-2030</option>
												<option value="2022-2023">2030-2031</option>
												</select>
										</div>
									</div>
									
									<div class="row">
									
											<div class="col-sm-4 form-group">
											<label class="required">Variety Grade Wise Sale Price</label> <input type="number"
												placeholder = "Variety Grade Wise Sale Price" name="variety_grade_Wise_sale_price" id="variety_grade_Wise_sale_price" class="form-control"
												required>
										</div>
										<div class="col-sm-4 form-group">
											<label class="required">Location Region</label> <input placeholder="Location Region" type="text"
												name="locationRegion" id="locationRegion" class="form-control"
												required>
										</div>

								

										<div class="col-sm-4 form-group">
											<label class="required"></label>Types of Delivery <Select type="text"
												name="delibrytype" id="delibrytype" class="form-control"
												required>
													<option disabled selected value>-Select-</option>
												<option value="Mill Delivery">Mill Delivery</option>
												<option value="Ex-Godown">Ex-Godown</option>
												</select>
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