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
	List<Object> allJuteVariety = (List<Object>) request.getAttribute("allJuteVariety");
	//List<String> allLabelName = (List<String>) request.getAttribute("allLabelName"); 
	int sizeOfJuteVariey = allJuteVariety.size();

	//System.out.println(allLabelName.size());
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
				<h1 class="page-title">Entry of Grade Composition</h1>
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
								<form action="saveGradeComp.obj" method="POST">
									<div class="row">

										<div class="col-sm-4 form-group">

											<%
											LocalDate obj = LocalDate.now();
											//LocalDate obj = LocalDate.of(2020, 1, 8)

											int currentyear = obj.getYear();
											int nextyear = 0;
											int month = obj.getMonthValue();

											if (month >= 7) {
												nextyear = currentyear + 1;
											} else {
												nextyear = currentyear;
												currentyear -= 1;
											}
											%>

											<label>Crop Year </label> <select name="crop_year"
												id="crop_year" class="form-control" required>
												<option disabled selected value>-Select-</option>
												<option value="<%=currentyear%>-<%=nextyear%>"><%=currentyear%>-<%=nextyear%></option>
											</select>
										</div>

										<div class="col-sm-4 form-group">
											<label>Available Qty</label> <input name="available_qty"
												id="available_qty" type="text" class="form-control" required />


										</div>

										<div class="col-sm-4 form-group">
											<label>Label Name</label> <input name="labelname"
												id="labelname" type="text" class="form-control" required />
											<span id="labelMsg" class="text-danger"></span>
										</div>
									</div>

									<div class="row table-responsive-sm m-4">

										<!-- 		<label>Jute Composition</label> -->
										<table>
											<thead>
												<tr class="row">
													<th class="col-sm-6" scope="col">Variety</th>
													<th class="col-sm-2" scope="col">System
														Composition(%)</th>
													<th class="col-sm-2" scope="col">Proposed
														Composition(%)</th>
															<th class="col-sm-2" scope="col">Remarks
														</th>
												</tr>
											</thead>
											<tbody>

												<%
												int i = 1;
												for (Object row : allJuteVariety) {
													Object[] rowData = (Object[]) row; // Cast each row to an Object array
													// Access individual columns by their index (0-based)
													Object variety = rowData[1];
													Object rate = rowData[2];
												%>

												<tr class="row">
													<td class="col-sm-6"><input class="form-control"
														name="variety<%=i%>" value="<%=variety%>" /></td>
													<td class="col-sm-2"><input
														class="clrSys form-control" name="system<%=i%>"
														value="<%=rate%>" readonly /></td>
													<td class="col-sm-2"><input type="number"
														name="proposed<%=i%>" id="grade<%=i%>" step="any"
														class="clrPro form-control" data-decimal="2" min="0"
														required /></td>

													<%
													if (i == 1) {
													%>
													<td class="col-sm-2"><input type="text"
														name="remark"
														class="form-control" required /></td>
													<%
													}
													%>

												</tr>
												<%
												i++;
												}
												%>
												<tr class="row">
													<td class="col-sm-6"></td>
													<td class="col-sm-2"></td>
													<td class="col-sm-2"><small id="error"
														class="text-danger"></small></td>
												</tr>
											</tbody>
										</table>
									</div>

									<div>
										<button class="btn btn-success submit" id="disableButton"
											type="submit" disabled>Submit</button>
									</div>
									<input type="hidden" name="size" value="<%=sizeOfJuteVariey%>">
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

	<script>
		$("#labelname").on("input", function() {
			$("#disableButton").attr("disabled");
		})

		$("#labelname")
				.on(
						"blur",
						function() {
							var val = $(this).val();

							$
									.ajax({
										type : "GET",
										url : "isValidateLabel.obj",
										data : {
											"label" : val
										},
										success : function(result) {

											if (result === 'false') {
												document
														.getElementById("labelMsg").innerHTML = "label name already exist";
											}

											else {
												document
														.getElementById("labelMsg").innerHTML = "";
												$("#disableButton").removeAttr(
														"disabled");
											}
										}

									});
						});

		$(".clrPro").on(
				"keypress",
				function() {
					if (event.key === "-" || event.key === "+"
							|| event.key === "e" || event.key === "E") {
						event.preventDefault();
					}
				})
	</script>

	<script>
		$(".submit")
				.click(
						function() {

							let totel = 0;
							var flag = true;

							for (var i = 1; i <=
	<%=sizeOfJuteVariey%>
		; i++) {
								let temp = $('#grade' + i).val();
								if (temp == '')
									temp = 0;
								//console.log(parseFloat(temp));
								totel += parseFloat(temp);
								//console.log(totel);
							}

							if ((+totel != 100)) {
								flag = false;
								document.getElementById("error").innerHTML = "total should be 100 !";
							} else {
								document.getElementById("error").innerHTML = "";
							}

							return flag;
						})
	</script>

</body>
</html>