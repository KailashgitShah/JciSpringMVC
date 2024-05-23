<%@page import="java.util.Date"%>
<%@page import="java.util.Arrays"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.jci.model.EntryDerivativePrice"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>

<%@page import="com.jci.model.StateList"%>
<%@page import="java.util.List"%>
<html lang="en">
<%@ page import="javax.servlet.http.HttpServletRequest"%>
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
<script type="text/javascript" src='./resources/js/responsivevoice.js'></script>
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

<!-- PAGE LEVEL STYLES-->
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
</head>

<body class="fixed-navbar">

	<%
	EntryDerivativePrice derivativePrice = (EntryDerivativePrice) request.getAttribute("derivativePrice");
	int defaultDerId = derivativePrice.getDer_id();
	String defaultCropYear = derivativePrice.getCrop_year();
	String defaultDeliveyType = derivativePrice.getDelivery_type();

	String defaultStateName = derivativePrice.getState_name();
	String defaultDistrictName = derivativePrice.getDistrict_name();
	String defaultJuteType = derivativePrice.getJute_variety();
	String grade1 = derivativePrice.getGrade1();
	String grade2 = derivativePrice.getGrade2();
	String grade3 = derivativePrice.getGrade3();
	String grade4 = derivativePrice.getGrade4();
	String grade5 = derivativePrice.getGrade5();
	String grade6 = derivativePrice.getGrade6();

	/* 	boolean disableInputT = true;
		boolean disableInputW = true;
		boolean disableInputM = true;
		boolean disableInputB = true;
		if (defaultJuteType.startsWith("T")) {
			disableInputT = false;
		} ;
		if (defaultJuteType.startsWith("W")) {
			disableInputW = false;
		} ;
		if (defaultJuteType.startsWith("M")) {
			disableInputM = false;
		} ;
		if (defaultJuteType.startsWith("B")) {
			disableInputB = false;
		} ; */

	// 	System.out.print(defaultDeliveyType.equals("ex-godown") + " "
	// 			+ "/////////////////////////////////////////////////////////////////");

	// 	System.out.print(defaultDeliveyType.equals("mill") + " " + "<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
	//System.out.print(disableInputT + "+" + disableInputW + "+" + disableInputM + "+" + disableInputB + " "
	%>

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
				<h1 class="page-title">Edit Derivative Price</h1>
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
								<form action="updateEDPrice.obj" method="POST">
									<div class="row">

										<div class="col-sm-4 form-group">
											<label>Crop Year </label> <select name="crop_year" disabled
												id="crop_year" class="form-control">
												<option selected><%=defaultCropYear%></option>
											</select>
										</div>

										<div class="col-sm-4 form-group">
											<label>Delivery Type</label> <select name="delivery_type"
												disabled id="delibry_type" class="form-control">
												<option><%=defaultDeliveyType%></option>
											</select>
										</div>


										<div class="col-sm-4 form-group">
											<label>State</label> <select class="form-control"
												name="state" type="text" disabled placeholder="State"
												id="ParentMenuID">
												<option><%=defaultStateName%></option>
											</select>
										</div>
									</div>

									<div class="row mt-4">
										<div class="col-sm-4 form-group">
											<label>District</label> <select class="form-control"
												id="child" name="district" disabled>
												<option><%=defaultDistrictName%></option>
											</select>

										</div>



										<div class="col-sm-8 form-group">

											<label>Jute Grade</label>
											<table>
												<tr>
													<th></th>
													<th>GR1</th>
													<th>GR2</th>
													<th>GR3</th>
													<th>GR4</th>
													<th>GR5</th>
													<%
													if (defaultJuteType.matches("Bimli|Mesta")) {
													%>
													<th>GR6</th>
													<%
													}
													%>
												</tr>
												<tr>
													<td class="font-weight-bold"><%=defaultJuteType%></td>
													<td><input class="form-control" type="number" min="0"
														step="any" name="grade1" id="grade1" value="<%=grade1%>" /></td>
													<td><input class="form-control" type="number" min="0"
														step="any" name="grade2" id="grade2" value="<%=grade2%>" /></td>
													<td><input class="form-control" type="number" min="0"
														step="any" name="grade3" id="grade3" value="<%=grade3%>" /></td>
													<td><input class="form-control" type="number" min="0"
														step="any" name="grade4" id="grade4" value="<%=grade4%>" /></td>
													<td><input class="form-control" type="number" min="0"
														step="any" name="grade5" id="grade5" value="<%=grade5%>" /></td>

													<%
													if (defaultJuteType.matches("Bimli|Mesta")) {
													%>

													<td><input class="form-control" type="number" min="0"
														step="any" name="grade6" id="grade6" value="<%=grade6%>" /></td>
													<%
													}
													%>
												</tr>


											</table>
										</div>
									</div>

									<div class="row">

										<div class="form-group">
											<input name="der_id" type="hidden" value=<%=defaultDerId%> />
											<button class="btn btn-success" id="btn" type="submit">Update</button>
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

	</div>

	<!-- END PAGA BACKDROPS-->
	<!-- CORE PLUGINS-->
	<script src="assets/css/chosen.jquery.js" type="text/javascript">
		
	</script>
	<script src="assets/css/docsupport/prism.js" type="text/javascript"
		charset="utf-8"></script>
	<script src="assets/css/docsupport/init.js" type="text/javascript"
		charset="utf-8"></script>

	<script>
		$(".chosen-select").chosen({
			no_results_text : "Oops, nothing found!"
		})
	</script>

	<script>
		
	</script>


</body>
</html>