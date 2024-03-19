<!DOCTYPE html>
<%@page import="com.jci.model.Salepricecalculation"%>
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
				<h1 class="page-title">Bale Preparation</h1>
			</div>
			<%
				Salepricecalculation spc = (Salepricecalculation) request.getAttribute("salepricecalculation");
			%>
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
												<option
													<%if (spc.getCrop_year().equals("2021-2022")) {
	out.print("selected");
}%>
													value="2021-2022">2021-2022</option>
												<option
													<%if (spc.getCrop_year().equals("2022-2023")) {
	out.print("selected");
}%>
													value="2022-2023">2022-2023</option>
											</select>
										</div>
										<div class="col-sm-4 form-group">
											<label class="required">Center</label> <input type="text"
												name="center" id="center" value="<%=spc.getCenter()%>"
												class="form-control">
										</div>

										<div class="col-sm-4 form-group">
											<label class="required">Sale Quantity</label> <input
												class="form-control" name="sale_quantity" id="sale_quantity"
												value="<%=spc.getSale_quantity()%>" type="text"
												placeholder="" required>
										</div>
									</div>
									<div class="row">
										<div class="col-sm-4 form-group">
											<label class="required">Amount</label> <input type="text"
												name="amount" value="<%=spc.getAmount()%>" id="amount"
												class="form-control" required>
										</div>

										<div class="col-sm-4 form-group">
											<label class="required">Jute Variety</label> <input
												type="text" name="jute_variety" id="jute_variety"
												class="form-control" value="<%=spc.getJute_variety()%>"
												required> </select>
										</div>

										<div class="col-sm-4 form-group">
											<label class="required">Jute Grade</label> <input type="text"
												name="jute_grade" id="jute_grade" class="form-control"
												value="<%=spc.getJute_grade()%>" required>

										</div>
									</div>
									<div class="row">
										<div class="col-sm-4 form-group">
											<label class="required">Grade Differential</label> <input
												class="form-control" name="grade_differential"
												id="grade_differential"
												value="<%=spc.getGrade_differential()%>" type="text"
												placeholder="Bale Check SlipNo" required>
										</div>

										<div class="col-sm-4 form-group">
											<label class="required">Garsat Rate</label> <input
												class="form-control" name="garsat_rate" id="garsat_rate"value="<%=spc.getGarsat_rate() %>"
												type="text" placeholder="">
										</div>

										<div class="col-sm-4 form-group">
											<label class="required">Base Price</label> <input
												class="form-control" name="base_price" id="base_price"value="<%=spc.getBase_price() %>"
												type="text" placeholder="Total bales" required>
										</div>


									</div>
									<div class="row">
										<div class="col-sm-4 form-group">
											<label class="required">Bin Number</label> <input
												class="form-control" name="bin_number" id="bin_number"value="<%=spc.getBin_number() %>"
												type="text" placeholder="" required>
										</div>

										<div class="col-sm-4 form-group">
											<label class="required">Operation Cost</label> <input
												class="form-control" name="operation_cost" value="<%=spc.getOperation_cost() %>"
												id="operation_cost" type="text" placeholder="">
										</div>

										<div class="col-sm-4 form-group">
											<label class="required">Insurance</label> <input
												class="form-control" name="Insurance" id="Insurance"value="<%=spc.getInsurance() %>"
												type="text" placeholder="" required>
										</div>


									</div>
									<div class="row">
										<div class="col-sm-4 form-group">
											<label class="required">Freight</label> <input
												class="form-control" name="freight" id="freight" type="text" value="<%=spc.getFreight() %>"
												placeholder="" required>
										</div>

										<div class="col-sm-4 form-group">
											<label class="required">Provision From Claim</label> <input
												class="form-control" name="provision_from_claim" value="<%=spc.getProvision_from_claim() %>"
												id="provision_from_claim" type="text" placeholder="">
										</div>

										<div class="col-sm-4 form-group">
											<label class="required">Weight Loss</label> <input
												class="form-control" name="weight_loss" id="weight_loss"value="<%=spc.getWeight_loss() %>"
												type="text" placeholder="" required>
										</div>


									</div>
									<div class="row">
										<div class="col-sm-4 form-group">
											<label class="required">Marketlevy</label> <input
												class="form-control" name="marketlevy" id="marketlevy"value="<%=spc.getMarketlevy() %>"
												type="text" placeholder="" required>
										</div>

										<div class="col-sm-4 form-group">
											<label class="required">Opportunity Cost Margin</label> <input
												class="form-control" name="opportunitycostm_argin"value="<%=spc.getOpportunitycostm_argin() %>"
												id="opportunitycostm_argin" type="text" placeholder="">
										</div>

										<div class="col-sm-4 form-group">
											<label class="required">Td Five Base Price</label> <input
												class="form-control" name="td_five_baseprice"value="<%=spc.getTd_five_baseprice() %>"
												id="td_five_baseprice" type="text" placeholder="" required>
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