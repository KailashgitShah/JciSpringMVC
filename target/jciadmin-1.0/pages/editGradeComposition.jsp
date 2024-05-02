<!DOCTYPE html>
<%@page import="org.bouncycastle.jce.provider.JDKGOST3410Signer.ecgost3410"%>
<%@page import="com.jci.model.EntryofGradeCompositionModel"%>
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
	EntryofGradeCompositionModel egc = (EntryofGradeCompositionModel) request.getAttribute("egc");
	//List<Object> allJuteVariety = (List<Object>) request.getAttribute("allJuteVariety");

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
				<h1 class="page-title">Edit Grade Composition</h1>
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
								<form action="updateGradeComp.obj" method="POST">
									<div class="row">

										<div class="col-sm-4 form-group">
											<label>Crop Year </label> <select name="crop_year"
												id="crop_year" class="form-control" disabled>
												<option selected value="<%=egc.getCrop_year()%>"><%=egc.getCrop_year()%></option>
												
											
											</select>
										</div>

										<div class="col-sm-4 form-group">
											<label>Available Qty</label> <input name="available_qty" value="<%=egc.getAvailable_qty()%>"
												id="available_qty" type="text" class="form-control" readonly/>


										</div>

										<div class="col-sm-4 form-group">
											<label>Label Name</label> <input name="labelname"
												id="labelname" type="text" class="form-control"  value="<%=egc.getLabel_name()%>"  readonly />
					
										</div>
									</div>

									<div class="row table-responsive-sm">

										<!-- 		<label>Jute Composition</label> -->
										<table class="m-4">
											<thead>
												<tr class="row">
													<th class="col-sm-5" scope="col">Variety</th>
													<th class="col-sm-3" scope="col">System Composition</th>
													<th class="col-sm-4" scope="col">Proposed Composition</th>
												</tr>
											</thead>
											<tbody>
												<tr class="row">
													<td class="col-sm-5"><input class="form-control" value="<%=egc.getJute_combination()%>" name="juteVariety"/></td>
													<td class="col-sm-3"><input class="clrSys form-control"
														value="<%=egc.getSystem_composition()%>" disabled/></td>
									
													<td class="col-sm-4"><input type="number" name="grade" value="<%=egc.getProposed_composition()%>"
														id="grade" step="any" class="clrPro form-control"
														data-decimal="2" min="0" required/></td>
												</tr>
												
													<input type="hidden" name="grade_id" value="<%=egc.getId()%>" />
													
								
											</tbody>
										</table>
									</div>

									<div>
										<button class="btn btn-success" type="submit">Update</button>
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

	<script>
			
	
		 $(".clrPro").on("keypress" ,function(){  
		    	if (event.key === "-" || event.key === "+") {
					event.preventDefault();
				}
		    })
			
		</script>


</body>
</html>