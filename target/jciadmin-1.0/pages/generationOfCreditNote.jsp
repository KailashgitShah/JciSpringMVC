<!DOCTYPE html>
<%@page import="com.jci.service_phase2.CreditNoteGenerationService"%>
<%@page import="org.springframework.beans.factory.annotation.Autowired"%>
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
	String shipmentDetails = (String) request.getSession().getAttribute("shipmentDetails");
	String ContractNo = (String) request.getSession().getAttribute("ContractNo");
	String roId = (String) request.getSession().getAttribute("roId");
	int Count = (int) request.getSession().getAttribute("Count") + 1;
	Double nominalWt = (Double) request.getSession().getAttribute("nominalWeight");

	Double actualWt = (Double) request.getSession().getAttribute("ActualWeight");
	Double invoiceVal = Double.parseDouble((String) request.getSession().getAttribute("invoiceVal"));
	Double shortQty = nominalWt - actualWt;

	Double price = invoiceVal / nominalWt;
	int crnAmount = (int) (price * shortQty);

	String currCropYear = (String) request.getSession().getAttribute("currCropYear");
	//generation of credit Note No.
	String lastDigitOfCropYear = currCropYear.substring(currCropYear.length() - 2);
	String indiaSerialNo = "001640";
	String creditNoteIdnNo = "C" + lastDigitOfCropYear + indiaSerialNo + roId + "00" + Count;
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
				<h1 class="page-title">Generation of Credit Notes</h1>
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
								<form action="saveCreditNote.obj" method="POST"
									enctype="multipart/form-data">
									<div class="row">

										<div class="col-sm-4 form-group">
											<label>Credit Note Date</label> <input name="cnDate"
												id="cnDate" class="form-control" placeholder="dd-mm-yyyy"
												value="<%=new java.text.SimpleDateFormat("dd-MM-yyyy").format(new java.util.Date())%>"
												readonly />
										</div>


										<div class="col-sm-4 form-group">
											<label>Credit Note No </label> <input class="form-control"
												name="cnNo" id="cnNo" type="text"
												value="<%=creditNoteIdnNo%>" readonly>
										</div>
										
										<div class="col-sm-4 form-group">
											<label>Contract No </label> <input class="form-control"
												name="contractNo" id="contractNo" type="text"
												value="<%=ContractNo%>" readonly>
										</div>


									</div>

									<div class="row">

										<div class="col-sm-4 form-group">
											<label>BOS Qty.</label> <input class="form-control"
												name="bosQty" id="bosQty" type="text" value="<%=nominalWt%>"
												readonly>
										</div>

										<div class="col-sm-4 form-group">
											<label>Actual Qty. </label> <input class="form-control"
												id="actualQty" name="actualQty" value="<%=actualWt%>"
												readonly>
										</div>
										<div class="col-sm-4 form-group" id="dpc">
											<label>Short Qty.</label> <input class="form-control"
												name="shortQty" id="shortQty" value="<%=shortQty%>"
												type="text" readonly>
										</div>
									</div>


									<div class="row">

										<div class="col-sm-4 form-group" id="dpc">
											<label>Credit Note Amount </label> <input
												class="form-control" name="creditAmt" id="creditAmt"
												type="text" value="<%=crnAmount%>" readonly>
										</div>
										<div class="col-sm-4 form-group">
											<label>Shipment Details</label> <input class="form-control "
												name="shipment" id="shipment" type="text"
												value="<%=shipmentDetails%>" readonly>
										</div>
										<div class="col-sm-4 form-group" for="formFile">
											<label>File Upload </label> <input class="form-control"
												name="file" id="formFile" type="file">
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

	<!-- END PAGA BACKDROPS-->
	<!-- CORE PLUGINS-->
	<script src="assets/css/chosen.jquery.js" type="text/javascript"></script>
	<script src="assets/css/docsupport/prism.js" type="text/javascript"
		charset="utf-8"></script>
	<script src="assets/css/docsupport/init.js" type="text/javascript"
		charset="utf-8"></script>
	<script src="https://code.jquery.com/ui/1.13.2/jquery-ui.js"></script>


</body>
</html>