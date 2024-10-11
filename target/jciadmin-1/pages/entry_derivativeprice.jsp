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
				<h1 class="page-title">Add Entry Derivative Price</h1>
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
										<div class="col-sm-4 form-group">
											<label>Crop Year </label> <select name="crop_year"
												id="crop_year" class="form-control">
												<option disabled selected value>-Select-</option>
												<option value="2021-2022">2021-2022</option>
												<option value="2022-2023">2022-2023</option>
												<option value="2021-2022">2023-2024</option>
												<option value="2022-2023">2024-2025</option>
												<option value="2021-2022">2025-2026</option>
												<option value="2022-2023">2026-2027</option>
												<option value="2021-2022">2027-2028</option>
												<option value="2022-2023">2028-2029</option>
												<option value="2021-2022">2029-2030</option>
												<option value="2022-2023">2030-2031</option>
												
											</select>
										</div>

										
										<div class="col-sm-4 form-group">
											<label>State</label>

											<%
												List<StateList> Liststate = (List<StateList>) request.getAttribute("Liststate");
											%>
											<select class="form-control" name="state" type="text"
												placeholder="State" id="ParentMenuID">
												<option disabled selected value>-Select-</option>
												<%
													for (StateList stateLists : Liststate) {
												%>
												<option value="<%=stateLists.getId()%>"><%=stateLists.getState_name()%></option>
												<%
													}
												%>
											</select>


										</div>

									
									
										<div class="col-sm-4 form-group">
											<label>District</label>
											<select id="child" name="district"	class="form-control ">
												<option disabled selected value>-Select District-</option>
											</select>

										</div>
										</div>

									<div class="row">
										<div class="col-sm-4 form-group">
											<label>Delivery Type</label> <select name="delivery_type"
												id="delibry_type" class="form-control" required>
												<option value="">-Select-</option>
												<option value="mill">Mill Delivery</option>
												<option value="ex-godown">Ex-Godown</option>
											</select>

										</div>
										<!-- <div class="col-sm-4 form-group">
											<label>Jute Variety</label> <select name="jute_variety"
												id="jute_variety" class="form-control" required>

											</select>

										</div> -->


										<div class="col-sm-8 form-group">

											<label>Jute Grade</label> 
											<table>
											<tr><th></th><th>GR1</th><th>GR2</th><th>GR3</th><th>GR4</th><th>GR5</th><th>GR6</th></tr>
											<tr><td>Tossa (New)</td><td><input type="text" name="tgr1" class="form-control" ></td><td><input type="text" name="tgr2" class="form-control"></td><td><input type="text" name="tgr3" class="form-control" ></td><td><input type="text" name="tgr4" class="form-control"></td><td><input type="text" name="tgr5" class="form-control"></td></tr>
											<tr><td>White (New)</td><td><input type="text" name="wgr1" class="form-control" ></td><td><input type="text" name="wgr2" class="form-control"></td><td><input type="text" name="wgr3" class="form-control" ></td><td><input type="text" name="wgr4" class="form-control"></td><td><input type="text" name="wgr5" class="form-control"></td></tr>
											<tr><td>Mesta</td><td><input type="text" name="mgr1" class="form-control"  ><td><input type="text" name="mgr2" class="form-control"></td><td><input type="text" name="mgr3" class="form-control" ></td><td><input type="text" name="mgr4" class="form-control"></td><td><input type="text" name="mgr5" class="form-control"></td><td><input type="text" name="mgr6" class="form-control"></td></tr>
											<tr><td>Bimli</td><td><input type="text" name="bgr1" class="form-control" ></td><td><input type="text" name="bgr2" class="form-control"></td><td><input type="text" name="bgr3" class="form-control" ></td><td><input type="text" name="bgr4" class="form-control"></td><td><input type="text" name="bgr5" class="form-control"></td><td><input type="text" name="bgr6" class="form-control"></td></tr>
											</table>
											
											
											
										</div>
									</div>

									<div class="row">
										
										<div class="form-group">

											<button class="btn btn-success " type="submit">Submit</button>
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

	<script>
		$(".chosen-select").chosen({
			no_results_text : "Oops, nothing found!"
		})
	</script>
	<script>
	$("#delibry_type").on("change", function() {
		var msp_no;
		var variety = (this.value);	
		if(variety=="msp"){
			msp_no = 2;
		}
		else if(variety=="commercial"){
			msp_no = 1;
		}
		$.ajax({
			type:"GET",
			url:"findJuteOnBasis.obj",
			data:{"msp_no":msp_no},
			success:function(result){
 				   var data= jQuery.parseJSON(result);
	 					 var html = "<option disabled selected value>-Select-</option>";
 				     for (var i = 0; i< data.length; i++){
 				    	 var sar = data[i]
 					 html += "<option value="+sar+">"+data[i]+"</option>"			
 				  } 
 				$("#jute_variety").html(html);
			}		
		});
	});
	</script>
	<script>
		$("#jute_variety")
				.on(
						"change",
						function() {
							var basis_no;
							var grade;
							var count = 0;
							var data;
							var basis = document.getElementById("delibry_type").value;
							if (basis == "commercial")
								basis_no = 2;
							else if (basis == "msp")
								basis_no = 1;
							var variety = (this.value);
							$
									.ajax({
										type : "GET",
										url : "findGradeOnJuteVariety.obj",
										data : jQuery.param({
											"variety" : variety,
											"basis_no" : basis_no
										}),
										success : function(result) {
											data = jQuery.parseJSON(result);
											var data = jQuery.parseJSON(result);

											var html = "<option disabled selected value>-Select-</option>";
											for (var i = 0; i < data.length; i++) {
												var sar = data[i]
												html += "<option value="+sar+">"
														+ data[i] + "</option>"
											}
											$("#jute_grade").html(html);

										}
									});
						});
	</script>
	<script>
		$("#ParentMenuID")
				.change(
						function() {
							var val = $(this).val();
							//alert(val);
							if (val != "") {
								$
										.ajax({
											type : "GET",
											url : "pIcon.obj",
											data : {
												"F_District" : val
											},
											success : function(result) {
												if (result.length > 0) {
													var result = JSON
															.parse(result);
													var s = "<option disabled selected value>-Select-</option>";
													for (var i = 0; i < result.length; i++) {
														s += '<option value="'
																+ result[i]
																		.split("-")[0]
																+ '">'
																+ result[i]
																		.split("-")[1]
																+ '</option>';
													}
													$('#child').html(s);
												} else {
													document
															.getElementById("child").style.display = "none";
													document
															.getElementById("selectedArea").value = "";
													//document.getElementById("selectedAreaDiv").style.display="none";
													//alert("No Record Found!");
												}
											}
										});
							}
						});
	</script>

</body>
</html>