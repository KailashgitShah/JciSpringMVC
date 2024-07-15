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
</head>

<%
String currCropYear = (String) request.getSession().getAttribute("currCropYear");
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
				<h1 class="page-title">Settlement of Credit And Debit Note</h1>
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
								<form action="saveEDPrice.obj" method="POST">
									<div class="row">

										<div class="col-sm-6 form-group">
											<label>Mill Name</label>

											<%
											List<String> mills = (List<String>) request.getAttribute("mills");
											%>
											<select class="form-control" name="mill" id="mill" required>
												<option value="">-Select-</option>
												<%
												for (String mill : mills) {
													String millArray[] = mill.split("&-&");
												%>
												<option value="<%=millArray[1]%>"><%=millArray[0]%></option>
												<%
												}
												%>
											</select>
										</div>

										<div class="col-sm-6 form-group">
											<label>Contract No</label> <select class="form-control"
												name="contract" id="contract" required>
												<option disabled selected value="">-Select-</option>
											</select>
										</div>
									</div>


									<div class="row">

										<div id="list"></div>
									</div>



									<div class="row">

										<div class="form-group col-sm-1">
											<button class="btn btn-success" id="submit" type="submit">Submit</button>
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

	<script>
		$("#mill")
				.on(
						"change",
						function() {

							$
									.ajax({
										type : "GET",
										url : "selectContractForSettlement.obj",
										//url : "pIcon.obj",
										data : {
											"mill" : $(this).val()
										},
										success : function(result) {

											var result = JSON.parse(result);

											var options = '<option selected value="">-Select-</option>';

											for (var i = 0; i < result.length; i++) {
												options += '<option value="' + result[i] + '">'
														+ result[i]
														+ '</option>';
											}
											$("#contract").html(options);
										}

									});

						})
	</script>

	<script>
		$("#contract")
				.on(
						"change",
						function() {
							$
									.ajax({
										type : "GET",
										url : "getFullDetailsOfCrnAndDebit.obj",
										data : {
											"contractNo" : $(this).val()
										},
										success : function(result) {

											var result = JSON.parse(result);
											alert(result);

											var htmlTable = '<table border="3px" id="table_r" class="table table-hover table-striped" style="margin-top:16px"><thead><tr><td>Select</td><td>SN.</td><td>Credit Note No.</td><td>Contract No</td><td>Crn Amount</td></tr></thead>';
											
											htmlTable += '<tbody id="body">';
											for (var i = 0; i < result.length; i++) {
												console.log(result[i]);
												htmlTable += '<tr border="2px"><td id="check'+i+'" style="text-align:center"><input type="checkbox" /></td><td>' + i + '</td>'
															+ '<td id="crn'+i+'"style="text-align:center">'+ result[i][8] + '</td>'
															+ '<td id="contract'+i+'"style="text-align:center">'+ result[i][13] + '</td>'
															+ '<td id="crnAmt'+i+'"style="text-align:center">'+ result[i][6] + '</td></tr>';

											}
											
											htmlTable += '</tbody></table>';

											$("#list").html(htmlTable);
											console.log(htmlTable);

										}

									});

						})
	</script>



	<script src="https://code.jquery.com/ui/1.13.2/jquery-ui.js"></script>
	<script src="./assets/vendors/metisMenu/dist/metisMenu.min.js"
		type="text/javascript"></script>
	<script src="assets/js/app.min.js" type="text/javascript"></script>

</body>
</html>
