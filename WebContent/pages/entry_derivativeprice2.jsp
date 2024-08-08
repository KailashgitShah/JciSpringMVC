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
				<h1 class="page-title">Entry Of Derivative Price (Rs.)</h1>
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
								<form action="saveEDPrice.obj" id="myForm" method="POST">
									<div class="row">

										<div class="col-sm-4 form-group">


											<label>Crop Year </label> <select name="crop_year"
												id="crop_year" class="form-control" required>
												<option disabled selected value="">-Select-</option>
												<option value="<%=currCropYear%>"><%=currCropYear%></option>
											</select>
										</div>

										<div class="col-sm-4 form-group">
											<label>Delivery Type</label> <select name="delivery_type"
												id="delibry_type" class="form-control" required>
												<option value="">-Select-</option>
												<option value="Mill-Delivery">Mill Delivery</option>
												<option value="Ex-Godown">Ex-Godown</option>
											</select>

										</div>

										<div class="col-sm-4 form-group">
											<label>State</label>

											<%
											List<StateList> Liststate = (List<StateList>) request.getAttribute("Liststate");
											%>
											<select class="form-control" name="state" id="ParentMenuID"
												required>
												<option disabled selected value="">-Select-</option>
												<%
												for (StateList stateLists : Liststate) {
												%>
												<option value="<%=stateLists.getId()%>"><%=stateLists.getState_name()%></option>
												<%
												}
												%>
											</select>
										</div>
									</div>
									<div class="row">
										<div class="col-sm-4 form-group" id="dpc_div">
											<label id="dpclabel" class="required">District</label>
											&nbsp;&nbsp;&nbsp; <select name="district" id="dpc_div"
												class="form-control" required>
												<option disabled selected value="">-Select</option>
											</select>
										</div>
									</div>

									<div class="row">
										<div class="col-sm-10 form-group">

											<label>Jute Grade</label>
											<table>
												<tr>
													<th></th>
													<th>GR1</th>
													<th>GR2</th>
													<th>GR3</th>
													<th>GR4</th>
													<th>GR5</th>
													<th>GR6</th>
												</tr>
												<tr>
													<td>Tossa (New)</td>
													<td><input type="number" name="tgr1" id="tgr1"
														step="any" class="form-control validation"
														data-decimal="2" min="0" /></td>
													<td><input type="number" name="tgr2" id="tgr2"
														step="any" data-decimal="2" min="0"
														class="form-control validation" /></td>
													<td><input type="number" name="tgr3" id="tgr3"
														step="any" data-decimal="2" min="0"
														class="form-control validation" /></td>
													<td><input type="number" name="tgr4" id="tgr4"
														step="any" data-decimal="2" min="0"
														class="form-control validation" /></td>
													<td><input type="number" name="tgr5" id="tgr5"
														step="any" data-decimal="2" min="0"
														class="form-control validation" /></td>
													<td><small id="errEmailtgr" class="text-danger"></small></td>

												</tr>
												<tr>
													<td>White (New)</td>
													<td><input type="number" name="wgr1" id="wgr1"
														step="any" data-decimal="2" min="0"
														class="form-control validation" /></td>
													<td><input type="number" name="wgr2" id="wgr2"
														step="any" data-decimal="2" min="0"
														class="form-control validation" /></td>
													<td><input type="number" name="wgr3" id="wgr3"
														step="any" data-decimal="2" min="0"
														class="form-control validation" /></td>
													<td><input type="number" name="wgr4" id="wgr4"
														step="any" data-decimal="2" min="0"
														class="form-control validation" /></td>
													<td><input type="number" name="wgr5" id="wgr5"
														step="any" data-decimal="2" min="0"
														class="form-control validation" /></td>
													<td><small id="errEmailwgr" class="text-danger"></small></td>
												</tr>
												<tr>
													<td>Mesta</td>
													<td><input type="number" name="mgr1" id="mgr1"
														step="any" data-decimal="2" min="0"
														class="form-control validation" />
													<td><input type="number" name="mgr2" id="mgr2"
														step="any" data-decimal="2" min="0"
														class="form-control validation" /></td>
													<td><input type="number" name="mgr3" id="mgr3"
														step="any" data-decimal="2" min="0"
														class="form-control validation" /></td>
													<td><input type="number" name="mgr4" id="mgr4"
														step="any" data-decimal="2" min="0"
														class="form-control validation" /></td>
													<td><input type="number" name="mgr5" id="mgr5"
														step="any" data-decimal="2" min="0"
														class="form-control validation" /></td>
													<td><input type="number" name="mgr6" id="mgr6"
														step="any" data-decimal="2" min="0"
														class="form-control validation" /></td>
													<td><small id="errEmailmgr" class="text-danger"></small></td>
												</tr>
												<tr>
													<td>Bimli</td>
													<td><input type="number" name="bgr1" id="bgr1"
														step="any" data-decimal="2" min="0"
														class="form-control validation" /></td>
													<td><input type="number" name="bgr2" id="bgr2"
														step="any" data-decimal="2" min="0"
														class="form-control validation" /></td>
													<td><input type="number" name="bgr3" id="bgr3"
														step="any" data-decimal="2" min="0"
														class="form-control validation" /></td>
													<td><input type="number" name="bgr4" id="bgr4"
														step="any" data-decimal="2" min="0"
														class="form-control validation" /></td>
													<td><input type="number" name="bgr5" id="bgr5"
														step="any" data-decimal="2" min="0"
														class="form-control validation" /></td>
													<td><input type="number" name="bgr6" id="bgr6"
														step="any" data-decimal="2" min="0"
														class="form-control validation" /></td>
													<td><small id="errEmailbgr" class="text-danger"></small></td>
												</tr>
											</table>
										</div>
									</div>

									<div class="row">

										<div class="form-group col-sm-1">
											<button class="btn btn-success" id="submit" type="submit">Submit</button>
										</div>
										<div class="form-group col-sm-1">
											<a class="btn btn-primary"
												href="entryderivativepricelist.obj">Check Price List</a>
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
	<script defer src="assets/css/chosen.jquery.js" type="text/javascript"></script>
	<script>
		$(".chosen-select").chosen({
			no_results_text : "Oops, nothing found!"
		})
	</script>
	
	<script>
		function validOptions() {
			var val = $('#ParentMenuID').val();
			var cropYear = $("#crop_year").val();
			var delivery_type = $("#delibry_type").val();
			var html = "<label id='dpclabel' class='required'>District</label> <select data-placeholder='Choose District...' class='chosen-select form-control' name='district'  multiple tabindex='3' id = 'centerordpc'>";
			if (val != null && val != '' && cropYear != null && cropYear != ""
					&& delivery_type != '' && delivery_type != null) {
		
				//get the data based on delivery type and crop year and district
				$
						.ajax({
							type : "GET",
							url : "pIconForSelected.obj",
							//url : "pIcon.obj",
							data : {
								"F_District" : val,
								"cropYear" : cropYear,
								"delivery_type" : delivery_type
							},
							success : function(result) {
								if (result.length > 0) {
									var result = JSON.parse(result);

									html += "<option disabled>-Select-</option>";
									for (var i = 0; i < result.length; i++) {
										html += ('<option value="'
												+ result[i].split("-")[0] + '-'
												+ result[i].split("-")[1] + '-'
												+ result[i].split("-")[2] + '"'
												+ '>' + result[i].split("-")[1] + '</option>');
									}
									html += "</select>"

									$("#dpc_div").html(html);
									$("#centerordpc").chosen();
									$("#centerordpc").addClass("chosen-select");

									/* $('#centerordpc option').prop('selected',
											true);
									$('#centerordpc').trigger('chosen:updated'); */

								} else {
									document.getElementById("child").style.display = "none";
									document.getElementById("selectedArea").value = "";
									//document.getElementById("selectedAreaDiv").style.display="none";
									//alert("No Record Found!");
								}
							}
						});
			}
		}

		$("#ParentMenuID").on("change", validOptions);
		$("#delibry_type").on("change", validOptions);
		$("#crop_year").on("change", validOptions);
	</script>

	<script>
		
		//input validation
		$(".validation").on(
				"keydown",
				function() {
					if (event.key === "-" || event.key === "+"
							|| event.key === "e" || event.key === "E") {
						event.preventDefault();
					}

				})

	</script>

	<script>
		$("#submit").click(function(){
 
		  if( $("#centerordpc").val().length === 0){
			  alert("Please choose district");
			  return false;
		  };
		 
			// grade validations...
 
			let groupIDs = {
			  t: ['#tgr1', '#tgr2', '#tgr3', '#tgr4', '#tgr5'],
			  w: ['#wgr1', '#wgr2', '#wgr3', '#wgr4', '#wgr5'],
			  m: ['#mgr1', '#mgr2', '#mgr3', '#mgr4', '#mgr5', '#mgr6'],
			  b: ['#bgr1', '#bgr2', '#bgr3', '#bgr4', '#bgr5', '#bgr6']
			};
			
			let grIds = ["t","w","m","b"];
			var flag = true;
			grIds.map(ch => {
				
				var ids = groupIDs[ch];
			    let i = 0;
				for(i = 0 ; i < ids.length - 1 ; i++){
				/* 	console.log(+$(ids[i]).val() , +$(ids[i+1]).val());
					console.log(+$(ids[i]).val() > +$(ids[i+1]).val()); */
					if(+$(ids[i]).val() < +$(ids[i+1]).val()){
						break;
					}
				}
				var errorId = "errEmail"+ch+"gr";
				if(i != ids.length-1){
					
					flag = false;
					document.getElementById(errorId).innerHTML = "Price should be in descending order";
				}else{
					document.getElementById(errorId).innerHTML = "";
				}
				
			})
			
			return flag;
		})
	</script>

	<script src="https://code.jquery.com/ui/1.13.2/jquery-ui.js"></script>
	<script src="./assets/vendors/metisMenu/dist/metisMenu.min.js"
		type="text/javascript"></script>
	<script src="assets/js/app.min.js" type="text/javascript"></script>
	
	  <script>
        $(document).ready(function() {
            $('#myForm').on('submit', function(event) {
                // Disable the submit button
                $('#submit').prop('disabled', true);
                $('#submit').val('Please Wait Processing...');
                sessionStorage.setItem('formSubmitted', 'true');
                             
            });
        });
        
        window.addEventListener('load', function() {
            if (sessionStorage.getItem('formSubmitted') === 'true') {
                document.getElementById('myForm').reset();
                sessionStorage.removeItem('formSubmitted');
            }
        });

    </script>

</body>
</html>
