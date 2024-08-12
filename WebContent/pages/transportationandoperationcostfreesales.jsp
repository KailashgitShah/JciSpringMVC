
<%@page import="java.util.List"%>
<%@page import="java.time.LocalDate"%>
<%@page import="java.time.LocalDateTime"%>
<%@page import="java.time.format.DateTimeFormatter"%>
<%@page import="com.jci.model.RoDetailsModel"%>
<%@page import="com.jci.model.OperationCostModel"%>
<%@page import="com.jci.model.FactorssInvolvedCommercial"%>


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

<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
<script src="https://code.jquery.com/ui/1.13.2/jquery-ui.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.5.0/js/bootstrap-datepicker.js"></script>




<!-- CORE SCRIPTS-->


<script src="assets/js/app.min.js" type="text/javascript"></script>

<link rel="stylesheet" href="assets/css/docsupport/style.css">
<link rel="stylesheet" href="assets/css/docsupport/prism.css">
<link rel="stylesheet" href="assets/css/chosen.css">
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
<script src="https://code.jquery.com/ui/1.13.2/jquery-ui.js"></script>


<style>
.required:after {
	content: " *";
	color: red;
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
				<h1 class="page-title">Entry of Transportation and Operation
					Cost(Free Sales)</h1>
			</div>


			<%
			// Author vishal

			String cropyear = (String) session.getAttribute("currCropYear");
			String basis = (String) request.getAttribute("basis");
			%>
			<div class="page-content fade-in-up">
				<div class="row">
					<div class="col-md-11">
						<div class="ibox">
							<span>${msg}</span>
							<div class="ibox-body">
								<form id ="myForm" action="savetransportcostfreesales.obj" method="POST">
									<div class="child-checkbox" id="disableform">

										<div class="row">
											<div class="col-sm-4 form-group">
												<label>Basis</label> <input class="form-control"
													name="basis" type="text" id="basis" readonly
													value="<%=basis%>">
												
											</div>


											<div class="col-sm-4 form-group">
												<label>Crop Year</label> <input class="form-control"
													type="text" id="cropyear" name="cropyear"
													value="<%=cropyear%>" readonly>
											</div>

											<div class="col-sm-4 form-group">
												<label id="regionlabel" class="required">Region</label>
												<%
												List<RoDetailsModel> regionlist = (List<RoDetailsModel>) request.getAttribute("RegionList");
												%>
												<select class="form-control" name="region" id="region"
													required>
													<option disabled selected value>-Select-</option>
													<%
													for (RoDetailsModel regions : regionlist) {
													%>
													<option value="<%=regions.getRocode()%>"><%=regions.getRoname()%></option>
													<%
													}
													%>
												</select>
												<!-- <input class="form-control" type="text" name="zone" placeholder="Zone"> -->
											</div>




										</div>

										<div class="row">
											<div class="col-sm-4 form-group" id="dpc_div">
												<label id="dpclabel" class="required">DPC</label>
												&nbsp;&nbsp;&nbsp;
												<div class="form-control" id="dpc_div" required></div>

											</div>

										
                                     <div class="col-sm-4 form-group">
												<label id="operationcostlabel" class="required">Operation
													Cost Head</label> &nbsp;&nbsp;&nbsp;
												<%
												List<FactorssInvolvedCommercial> operationcostlist = (List<FactorssInvolvedCommercial>) request.getAttribute("operationcostlist");
												%>
												<select class="form-control" name="operationcost"
													id="operationcost" required>
													<option disabled selected value>-Select-</option>
													<%
													for (FactorssInvolvedCommercial operations : operationcostlist) {
													%>
													<option value="<%=operations.getFactor_head()%>"><%=operations.getFactor_head()%></option>
													<%
													}
													%>
												</select>
												<!-- <input class="form-control" type="text" name="zone" placeholder="Zone"> -->
											</div>
   


											<div class="col-sm-4 form-group">
												<label class="required">Rate</label> <input
													class="form-control taxtbox" name="rate" id="rate" min="0"
													type="number" placeholder="Rate" required>
											</div>



										</div>

										<div class="row">
									
											
											<div class="col-sm-4 form-group">
												<label class="required">Unit</label> 
												
												<input
													class="form-control taxtbox" name="unit" id="unit" 
													type="text" placeholder="Unit" ReadOnly>
												
												
											</div>
											<div class="col-sm-4 form-group">
												<label for="validtilldate" class="required">Valid
													Till</label> <span id="instrumentdate" class="text-danger"></span>
												<input class="form-control" type="text" id="validtilldate"
													name="validtilldate" placeholder="dd-mm-yyyy" required>
											</div>

										</div>

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
			<!-- END PAGE CONTENT-->
			<%@ include file="footer.jsp"%>
		</div>
	</div>
	<div class="sidenav-backdrop backdrop"></div>

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
	           <script>
        $(document).ready(function() {
            $('#myForm').on('submit', function(event) {
                // Disable the submit button
                $('#submit').prop('disabled', true);
                $('#submit').val('Please Wait Processing...');  

              
            });
        });
    </script> 

</body>
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.13.2/themes/base/jquery-ui.css">
<link rel="stylesheet" href="/resources/demos/style.css">
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
<script src="https://code.jquery.com/ui/1.13.2/jquery-ui.js"></script>

<script>
	$("#validtilldate").datepicker({
		dateFormat : 'dd-mm-yy'
	});
</script>

<script type="text/javascript">
	$(document).ready(function() {

		$("#submit").click(function() {

		});
	});
</script>

<script type="text/javascript">
	$(document)
			.ready(
					function() {
						$("#region")
								.on(
										"change",
										function() {
											//alert("region");
											var id = (this.value);
											//alert(id +"tttt")
											var html = "<label id='dpclabel' class='required'>DPC</label> <select data-placeholder='Choose DPC...' class='chosen-select'  multiple tabindex='4' id = 'centerordpc' name='dpc_name'>";
											if (id != null) {
												$
														.ajax({
															type : "GET",
															url : "findDpc.obj",
															data : {
																"id" : id
															},
															success : function(
																	result) {
																var data = jQuery
																		.parseJSON(result);
																  // alert(data);
																html += "";
																for (var i = 0; i < data.length; i++) {

																	html += "<option value="
																			+ data[i]
																					.split("-")[0]
																			+ "!"
																			+ data[i]
																					.split("-")[1]
																			+ ">"
																			+ data[i]
																					.split("-")[1]
																			+ "</option>"

																}
																$("#dpc_div")
																		.html(
																				html);
																$(
																		"#centerordpc")
																		.chosen();
																$(
																		"#centerordpc")
																		.addClass(
																				"chosen-select");
																$(
																		'#centerordpc option')
																		.prop(
																				'selected',
																				true);
																$(
																		'#centerordpc')
																		.trigger(
																				'chosen:updated');

															}
														});
											}
										});
					});
</script>

<script type="text/javascript">
	$(document)
			.ready(
					function() {
						$("#operationcost")
								.on(
										"change",
										function() {
										//	alert("rrrr")
											//alert("region");
											var id = $(this).find("option:selected").text();
									        var selectedValue = $(this).val();
											
										//	alert(id  )
											
											$.ajax({
															type : "GET",
															url : "findunitByFactoHead.obj",
															data : {
																"id" : id
															},
															success : function(
																	result) {
																var data = result;
																//   alert(data +"kkk");
																   $('#unit').val(result);
																
																
															
											}
										});
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
<script src="assets/css/chosen.jquery.js" type="text/javascript"></script>
<script src="assets/css/docsupport/prism.js" type="text/javascript"
	charset="utf-8"></script>
<script src="assets/css/docsupport/init.js" type="text/javascript"
	charset="utf-8"></script>
<!-- PAGE LEVEL PLUGINS-->
<!-- CORE SCRIPTS-->
<script src="assets/js/app.min.js" type="text/javascript"></script>

<!-- PAGE LEVEL SCRIPTS-->

</html>

