<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.List"%>
<%@page import="java.time.LocalDate"%>
<%@page import="java.time.LocalDateTime"%>
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
<!-- PAGE LEVEL STYLES-->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.13.2/themes/base/jquery-ui.css">
<link rel="stylesheet" href="/resources/demos/style.css">
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
<script src="https://code.jquery.com/ui/1.13.2/jquery-ui.js"></script>
<link rel="stylesheet" href="assets/css/chosen.css">
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

.required:after {
	content: " *";
	color: red;
}
</style>

</head>

<%
List<Object[]> demandList = (List<Object[]>) request.getAttribute("demandList");
List<Object[]> creditList = (List<Object[]>) request.getAttribute("creditList");

String debitNoteNo = "";
String creditNoteNo = "";
String contractNo = "";
double creditAmount = 0;
double debitAmount = 0;

 for(Object[] ele : demandList){
	 debitNoteNo = (String)ele[9];
	 contractNo = (String)ele[3];
	 debitAmount += (double)ele[1];
 }
 for(Object[] ele : creditList){
	 creditNoteNo = (String)ele[8];
	 contractNo = (String)ele[13];
	 creditAmount += (double)ele[6];
 }
 
 double finalAmount = creditAmount - debitAmount;
 
%>


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
				<h1 class="page-title">Final Settlement </h1>
			</div>

			<%
			// Author vishal
			%>
			<div class="page-content fade-in-up">
				<div class="row">
					<div class="col-md-11">
						<div class="ibox">
							<%--    <span>${msg}</span> --%>
							<div class="ibox-body">
								<form action="finalSettlement.obj" method="POST">
									<div class="row">

										<div class="col-sm-4 form-group">
											<label>Initiation date</label> <input class="form-control"
												name="initiateDate" id="initiateDate"
												value="<%=new SimpleDateFormat("dd-MM-yyyy").format(new Date())%>"
												readonly>
										</div>

										<div class="col-sm-4 form-group">
											<label>Credit Note Number</label> <input
												class="form-control " name="creditNoteNo" id="creditNoteNo"
												value="<%=creditNoteNo %>" readonly>
										</div>
										<div class="col-sm-4 form-group">
											<label>Debit Note Number</label> <input class="form-control "
												name="debitNoteNo" id="debitNoteNo" value="<%=debitNoteNo %>" readonly>
										</div>
									</div>

									<div class="row">

										<div class="col-sm-4 form-group">
											<label>Contract No</label> <input class="form-control"
												name="contractNo" id="contractNo" type="text" value="<%=contractNo %>"
												readonly>
										</div>

										<div class="col-sm-4 form-group">
											<label>Credit Note Amount</label> <input class="form-control"
												name="creditNoteAmount" id="creditNoteAmount" value="<%=creditAmount %>" readonly>
										</div>
										<div class="col-sm-4 form-group">
											<label>Debite Note Amount</label> <input class="form-control"
												name="debitNoteAmount" id="debitNoteAmount" value="<%=debitAmount %>" readonly>
										</div>
								
									</div>
									<div class="row">
											<div class="col-sm-4 form-group">
											<label>Initiation Amount</label> <input class="form-control"
												name="initiationAmt" id="initiationAmt" value="<%=finalAmount %>" readonly>
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
	<script src="assets/css/chosen.jquery.js" type="text/javascript"></script>

	<!-- PAGE LEVEL SCRIPTS-->
</body>
</html>