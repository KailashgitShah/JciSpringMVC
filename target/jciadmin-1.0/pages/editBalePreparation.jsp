<!DOCTYPE html>
<%@page import="java.util.List"%>
<html lang="en">
<%@page import="com.jci.model.BalePreparationModel"%>
<%@page import="com.jci.model.BalePreparation"%>
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
				List<String> allDpcList = (List) request.getAttribute("allDpcList");
			%>

			<%
			String dpcCenter = (String) session.getAttribute("dpc_center");

			String dpcid = (String) session.getAttribute("dpcId");

			String region_id = (String) session.getAttribute("region");

			int refid2 = (int) session.getAttribute("refId");
			%>
			<%
				BalePreparation baleData = (BalePreparation) request.getAttribute("baleMod");
			
			%>
			<div class="page-content fade-in-up">
				<div class="row">
					<div class="col-md-11">
						<div class="ibox">

							<div class="ibox-body">
								<form action="updateBalePreparation.obj" method="POST">
									     <input type="hidden" id="baleId" name="baleId"value="<%=baleData.getBaleId()%>">
										 <input type="hidden" id="juteVarietyjs"name="jute_variety"value="<%=baleData.getJute_variety()%>"> 
										 <%-- <input type="hidden" id="place_of_packing"name="place_of_packing"value="<%=baleData.getPlace_of_packing()%>"> --%>
										 
										 <input class="form-control" name="dpcid" id="dpcid"
											type="hidden" value="<%=dpcid%>"> <input
											class="form-control" name="region_id" id="region_id"
											type="hidden" value="<%=region_id%>"> <input
											class="form-control" name="refid" id="refid" type="hidden"
											value="<%=refid%>" >

									<div class="row">
									<div class="col-sm-4 form-group">
											<label class="required">Packing Place</label>
											 <input class="form-control" name="place_of_packing" id="place_of_packing" type="text"  readonly>
										</div>

										<div class="col-sm-4 form-group">
											<label>Crop Year</label> <select name="crop_year" id="cropyr"
												class="form-control">
												<option value="">-Select-</option>
												<option
													<%if (baleData.getCrop_year().equals("2021-2022")) {
	out.print("selected");
}%>
													value="2021-2022">2021-2022</option>
												<option
													<%if (baleData.getCrop_year().equals("2022-2023")) {
	out.print("selected");
}%>
													value="2022-2023">2022-2023</option>
											</select>
										</div>

										<div class="col-sm-4 form-group">
											<label>Bin number</label> <input class="form-control"
												name="bin_no" id="binnumb" type="number"
												placeholder="Bin Number" required onkeyup="checkLen()"
												value="<%=baleData.getBin_no()%>">
										</div>
</div>
									<div class="row">	<div class="col-sm-4 form-group">
											<label>Basis</label> <select name="basis" id="basis"
												class="form-control" >
												<option value="">-Select-</option>
												<%-- <% 
                                        			if(baleData.getBasis()!=null){
                                        		%>
                                        				<option value="<%baleData.getBasis();%>" selected><%=baleData.getBasis()%></option>
                                        		<%
                                        			}
                                        		 %> --%>
												<option
													<%if (baleData.getBasis().equalsIgnoreCase("msp")) {out.print("selected");}%>
													value="msp">MSP</option>
												<option
													<%if (baleData.getBasis().equalsIgnoreCase("commercial")) {out.print("selected");}%>
													value="commercial">Commercial</option>
											</select>
										</div>

										<div class="col-sm-4 form-group">
											<label>Jute Variety</label> <select name="jute_variety"
												id="jutevariety" class="form-control">
												<%
													if (baleData.getJute_variety() != null) {
												%>
												<option selected value="<%=baleData.getJute_variety()%>"><%=baleData.getJute_variety()%></option>
												<%
													}
												%>
											</select>
										</div>

										<div class="col-sm-4 form-group">
											<label>Jute Grade</label> <select name="jute_grade"
												id="jutegarde" class="form-control"
												value="<%=baleData.getJute_grade()%>">
												<%
													if (baleData.getJute_grade() != null) {
												%>
												<option selected value="<%=baleData.getJute_grade()%>" ><%=baleData.getJute_grade()%></option>
												<%
													}
												%>
											</select>
										</div>
</div>
									<div class="row">
										<div class="col-sm-4 form-group">
											<label>Bale Check SlipNo.(From)</label> <input
												class="form-control" name="slip_no_from"
												id="slip_no_from" type="text"
												placeholder="Bale Check SlipNo"
												value="<%=baleData.getSlip_no_from()%>">
										</div>


										<div class="col-sm-4 form-group">
											<label>Bale Check SlipNo.(To)</label> <input
												class="form-control" name="slip_no_to" id="slip_no_to"
												type="text" placeholder="Bale Check SlipNo"
												onblur="calculateNoOfBales()"
												value="<%=baleData.getSlip_no_to()%>">
										</div>

										<div class="col-sm-4 form-group">
											<label>Total Bales</label> <input class="form-control"
												name="bale_no" id="bale_no" type="text"
												placeholder="Total bales"
												value="<%=baleData.getBale_no()%>" readonly>
										</div>
									</div>

									<div class="row">
									<div class="form-group">
										<button class="btn btn-default" type="submit">Submit</button>
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

       $(document).ready(function(){
    	   var myVar = '<%=(String) session.getAttribute("region")%>';

							//  alert(myVar);

							$
									.ajax({
										type : "GET",
										url : "findDpcByRegion.obj",
										data : {
											"id" : myVar
										},
										success : function(result) {

											var data = jQuery.parseJSON(result);
										
											var html = "<option disabled selected value>-Select-</option>";
											for (var i = 0; i < data.length; i++) {
												console.log(data[i].split("-")[0]+ " "+ data[i].split("-")[1]);
												html += "<option value="+ data[i].split("-")[0]+ ">"+ data[i].split("-")[1]+ "</option>"
											}
											$("#place_of_packing").html(html);

										}

									});

						});
	</script>
	<script>

       $(document).ready(function(){
    	   var myVar = '<%=baleData.getPlace_of_packing()%>';

							//  alert(myVar);

							$
									.ajax({
										type : "GET",
										url : "findDpcname.obj",
										data : {
											"dpccode" : myVar
										},
										success : function(result) {
											//alert(result.replace(/['"]+/g, ''));
											$("#place_of_packing").val(result.replace(/['"]+/g, ''));

										}

									});

						});
	</script>
	<script>
		$(function() {
			var dtToday = new Date();
			var month = dtToday.getMonth() + 1;
			var day = dtToday.getDate();
			var year = dtToday.getFullYear();
			if (month < 10)
				month = '0' + month.toString();
			if (day < 10)
				day = '0' + day.toString();
			var maxDate = year + '-' + month + '-' + day;
			$('#datepurchase').attr('max', maxDate);
		});
	</script>

	<script>
		$("#basis")
				.on("change",
						function() {
							var msp_no;
							var variety = (this.value);
							if (variety == "msp") {
								msp_no = 2;
							} else if (variety == "commercial") {
								msp_no = 1;
							}
							$
									.ajax({
										type : "GET",
										url : "findJuteOnBasis.obj",
										data : {
											"msp_no" : msp_no
										},
										success : function(result) {
											var data = jQuery.parseJSON(result);
											var html = "<option disabled selected value>-Select-</option>";
											for (var i = 0; i < data.length; i++) {
												var sar = data[i];
												html += "<option value="+sar+">"
														+ data[i] + "</option>"
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
							var basis = document.getElementById("basis").value;
							if (basis == "commercial")
								basis_no = 2;
							else if (basis == "msp")
								basis_no = 1;
							var variety = (this.value);
							$.ajax({
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
												var sar = data[i];
												html += "<option value="+sar+">"
														+ data[i] + "</option>"
											}
											$("#jute_grade").html(html);
										}
									});
						});
	</script>

	<script>
		function checkLen() {
			var binnumber = document.getElementById("bin_no").value;
			var max_chars = 3;
			// binnumber.value = binnumber.value.substr(0, max_chars);
			if (binnumber.toString().length == 3) {
				// alert("hell");
				$("#bin_no").prop("type", "text");
				$("#bin_no").attr("maxlength", "3");
				$("#bin_no").attr("minlength", "1");
			}
		}
	</script>

	<script>
		function calculateNoOfBales() {
			var fromCheckSlipNo = document.getElementById("slip_no_from").value;
			var toCheckSlipNo = document.getElementById("slip_no_to").value;
			var noOfBales = (toCheckSlipNo - fromCheckSlipNo) + 1;
			if (noOfBales >= 0) {
				document.getElementById("bale_no").value = noOfBales;
			} else {
				alert("No of bales can not be negative or 0");
				return false;
			}
		}

		function baleFromLen() {
			var binnumber = document.getElementById("slip_no_from").value;
			if (binnumber.toString().length == 6) {
				$("#slip_no_from").prop("type", "text");
				$("#slip_no_from").attr("maxlength", "6");
				$("#slip_no_from").attr("minlength", "1");
			}
		}

		function baleToLen() {
			var binnumber = document.getElementById("slip_no_to").value;
			if (binnumber.toString().length == 6) {
				$("#slip_no_to").prop("type", "text");
				$("#slip_no_to").attr("maxlength", "6");
				$("#slip_no_to").attr("minlength", "1");
			}
		}
	</script>
	<!-- PAGE LEVEL PLUGINS-->
	<!-- CORE SCRIPTS-->
	<script src="assets/js/app.min.js" type="text/javascript"></script>
	<!-- PAGE LEVEL SCRIPTS-->
</body>
</html>