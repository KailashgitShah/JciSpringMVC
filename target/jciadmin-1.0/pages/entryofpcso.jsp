
<%@page import="org.apache.poi.util.SystemOutLogger"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.List"%>
<%@page import="java.io.File"%>

<%@page import="com.jci.model.EntryofpcsoModel"%>
<!DOCTYPE html>
<html lang="en">

<head>

<style>
.myname {
	width: 100%;
	height: 32px;
}

.required:after {
	content: " *";
	color: red;
}

#btn-back-to-top {
	position: fixed;
	bottom: 20px;
	right: 20px;
	z-index: 100;
	display: none;
}

.fixedCol {
	position: fixed;
	z-index: 100;
	top: 56px;
	padding: 20px;
	background: #f1f1f1;
	left: 25rem;
	width: 70%;
}
</style>
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
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css">
<!-- PLUGINS STYLES-->
<link href="./assets/vendors/DataTables/datatables.min.css"
	rel="stylesheet" />
<!-- THEME STYLES-->
<link href="assets/css/main.min.css" rel="stylesheet" />
<link rel="stylesheet" href="assets/css/chosen.css">
<script src="https://code.jquery.com/jquery-1.11.3.min.js"
	type="text/javascript"></script>
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
				<h1 class="page-title">Entry of PCO (Production Control Order)</h1>
			</div>

			<button type="button" class="btn btn-success btn-floating btn-lg"
				id="btn-back-to-top">
				<i class="fas fa-arrow-up"></i>
			</button>


			<%
			List<Object[]> allentryofpcsolist = (List<Object[]>) request.getAttribute("entryofpcsolist");
			List<String> allRefNo = (List<String>) request.getAttribute("allRefNo");
			int totalMills = allentryofpcsolist.size();

			/* 			String referenceno = (String) request.getAttribute("referenceno");
				String pcsoDate = (String) request.getAttribute("pcsodate");
				
				String pcsoReqdate = (String) request.getAttribute("pcsoReqdate");
				String pcsoQty = (String) request.getAttribute("pcsoQty");
				String pcsoReqQty = (String) request.getAttribute("pcsoReqQty");
				String juteRatio = (String) request.getAttribute("juteRatio");
				String dispatchPeriod = (String) request.getAttribute("dispatchPeriod");
				String letterRefNo = (String) request.getAttribute("letterRefNo");
				
				if (referenceno == null) {
					pcsoDate = "";
					pcsoReqdate = "";
					pcsoQty = "";
					pcsoReqQty = "";
					juteRatio = "";
					dispatchPeriod = "";
					letterRefNo = "";
					referenceno = "";

				} */

			String currCropYear = (String) request.getSession().getAttribute("currCropYear");
			%>
			<div class="page-content fade-in-up">
				<div class="row">
					<div class="col-md-11">
						<div class="ibox">
							<div class="ibox-head">
								<span id="flashMessage">${msg}</span>
							</div>
							<div class="ibox-body">
								<form action="entryofpcsosave.obj" method="POST">
									<div class="fixedCol">
										<div class="row">
											<div class="col-sm-3 form-group">
												<label class="required">JCI letter Ref.</label> <select
													class="form-control" name="letterRefNo" id="refNo" required>
													<option value="">-Select-</option>
													<%
													for (String ref : allRefNo) {
													%>
													<option value="<%=ref%>">
														<%=ref%></option>

													<%
													}
													%>
												</select>
											</div>
											<div class="col-sm-3 form-group">
												<label>PCO Req. Date</label> <input class="form-control"
													name="pcsoReqdate" id="pcsoReqdate" value=""
													placeholder="dd-mm-yyyy" type="date" readonly>
											</div>
											<div class="col-sm-3 form-group">
												<label>PCO Req. Qty. (M.T)</label> <input value=""
													class="form-control" name="pcsoReqQty" id="pcsoReqQty"
													readonly>


											</div>
											<div class="col-sm-3 form-group">
												<label class="required">PCO Date</label> <input
													class="form-control" name="pcsoDate" id="pcsoDate"
													placeholder="dd-mm-yyyy" type="date" required>
											</div>
										</div>

										<div class="row">
											<div class="col-sm-3 form-group">
												<label class="required">JC Office Ref.No.</label> <input
													class="form-control" type="text" name="referenceno"
													placeholder="Reference.No." autocomplete="off"
													id="referenceno" required>
											</div>
											<div class="col-sm-3 form-group">
												<label class="required">JCI Linkage Percentage.</label> <input
													class="form-control" type="number" name="juteRatio"
													value="" id="juteRatio" min="0" step="0.01" max="100"
													required>
											</div>
											<div class="col-sm-3 form-group">
												<label class="required">PCO Qty. (M.T)</label> <input
													class="form-control" type="number" min="0" step="0.01"
													value="" name="pcsoQty" id="pcsoQty">
											</div>
											<div class="col-sm-3 form-group">
												<label class="required">Dispatch Period</label> <input
													class="form-control" name="dispatchPeriod" type="date"
													min="" placeholder="dd-mm-yyyy" id="dispatchPeriod"
													required>

											</div>
										</div>

										<div class="row" style="margin-bottom: -21px;">

											<div class="col-sm-4 text-center form-group ">
												<label class="font-weight-bold">Mill Code</label>
											</div>
											<div class="col-sm-4 form-group">
												<label class="font-weight-bold">Mill Name</label>
											</div>
											<div class="col-sm-4 form-group">
												<label class="font-weight-bold">Total allocation
													(MT)</label>
											</div>

										</div>
									</div>
									<div class="row" style="margin-top: 110px;">

										<%
										int mill = 0;
										for (Object[] entryofpcsolist : allentryofpcsolist) {
										%>
										<div class="col-sm-4 form-group">
											<input type="text" class="form-control"
												name="millcode<%=mill%>" id="millcode<%=mill%>"
												value="<%=entryofpcsolist[0]%>" readonly>
										</div>
										<div class="col-sm-4 form-group">
											<input type="text" class="form-control"
												name="millname<%=mill%>" id="millname<%=mill%>"
												value="<%=entryofpcsolist[1]%>" readonly>
										</div>
										<div class="col-sm-4 form-group">
											<input type="text" inputmode="numeric" step="any"
												class="form-control tAll" min="0"
												name="totalallocation<%=mill%>" value="0"
												id="totalallocation<%=mill%>">
										</div>
										<%
										mill++;
										}
										%>
										<div class="col-sm-4 form-group"></div>
										<div class="col-sm-4 form-group"></div>
										<div class="col-sm-4 form-group">
											<span id="errMsg" class="text-danger"></span>
										</div>

										<input name="count" id="count" type="hidden" value="<%=mill%>">
									</div>
									<div class="form-group col-sm-12">
										<button class="btn btn-default" type="submit" id="submit">Next</button>
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
	$(document).ready(function() { 
		  $("#dispatchPeriod").prop("readonly", true);	
		 $("#pcsoDate").prop("readonly", true);	
		 /*  document.getElementById("refNo").value = "";
		  $("#pcsoQty").val(""); */
	});

			
//hide the flash message
	        setTimeout(function() {
	            document.getElementById('flashMessage').style.display = 'none';
	        }, 1500);
	</script>



	<script type="text/javascript">
		var mybutton = document.getElementById("btn-back-to-top");

		// When the user scrolls down 20px from the top of the document, show the button
		window.onscroll = function() {
			scrollFunction();
		};
      
		function scrollFunction() {
			//if the page scrolled grater then 20 then this line will trigger
			if (document.body.scrollTop > 20
					|| document.documentElement.scrollTop > 20) {
				mybutton.style.display = "block";
			} else {
				mybutton.style.display = "none";
			}
		}
 
		let options = {top: 0, left: 0, behavior: 'smooth'};  
		mybutton.addEventListener('click', () => { window.scroll(options) });
				 
	</script>
	
	<script>
		$("#refNo").on("change", function() {
			var val = $(this).val();

			$.ajax({
				type : "GET",
				url : "getRequestLetterDetails.obj",
				data : {
					"refNo" : val
				},
				success : function(result) {
					var data = jQuery.parseJSON(result);
                    
					var details = data[0]
					var pcsoReqdate = data[0][6].split("-");
					var newDate = pcsoReqdate[2]+"-"+pcsoReqdate[1]+"-"+pcsoReqdate[0];
					
				    
					var reqQty = data[0][7]/10;
					// $("#pcsoDate").prop("readonly", false);
					$("#pcsoReqdate").val(newDate);
					$("#pcsoReqQty").val(reqQty);
					document.getElementById("pcsoDate").min = newDate;
					 $("#pcsoDate").prop("readonly", false);

				}
			})
		});
	</script>
	
	
	
	
	
	
	
	
	

	<script>
		$("#pcsoDate").on(
				"change",
				function() {
					var date = $(this).val();
					document.getElementById("dispatchPeriod").min = date;
					document.getElementById("dispatchPeriod").value = "";
					 $("#dispatchPeriod").prop("readonly", false);
					 
						var pcsoDate = date.split("-");
						var formattedDate = pcsoDate[2]+"-"+pcsoDate[1]+"-"+pcsoDate[0];
					 
						
						 $.ajax({
							type : "GET",
							url : "getMillCodeForPcoDate.obj",
							data : {
								"pcoDate" : formattedDate
							},
							success : function(result) {
								var millCodes = jQuery.parseJSON(result);
                                
							   //console.log(millCodes);
							   var totalCountOfMills = '<%=totalMills%>'
							   
							   for(var j = 0 ; j < totalCountOfMills ; j++){
								   var millCode =  $("#millcode" + j).val();
								   
								   if(millCodes.includes(millCode)){
									   //console.log(millCode , "inside the function");
									   $("#totalallocation" + j).prop('readonly', true); 
								   }else{
									   $("#totalallocation"+j).attr('readonly' , false); 
								   }
							   }
							}
						})
					})

				//jute ratio validation

				$("#juteRatio").on("input" , function(){
					var ratio = $(this).val();
					if(ratio > 100){
						$(this).val(0);
					}
				})	
	</script>


	<script type="text/javascript">
		$(document).ready(
				function() {
					// to not enter a value less than 0
					var inputFields = $(".tAll");
					var submitButton = $("#submit");
					var refNo = $("#referenceno");

					// to set ref number to alphanumeric
					refNo.on("input", function() {
						var inputVal = $(this).val();
						var refVal = inputVal.replace(/[^a-zA-Z0-9-\/()]/g, "");

						$(this).val(refVal);
					});

					// to set total allocation as needed
					inputFields.each(function() {
						var inputField = $(this);
						var lastVal = inputField.val();

				/* 		inputField.on("input", function() {
							var inputVal = $(this).val();
							if (inputVal === "")
								return;

						}); */

						// to prevent +, - and e from being input
						inputFields.on("keydown", function(event) {
							if (event.key === "-" || event.key === "+"
									|| event.key === "e" || event.key === "E") {
								event.preventDefault();
							}
						});
					});

					// to check if the fields are all empty or some have values.

				});
	</script>

	<script type="text/javascript">
		$(document)
				.ready(
						function() {
							$("#submit")
									.click(
											function() {
												var pcsoDate = document
														.getElementById("pcsoDate").value;
												var pcsoReqdate = document
														.getElementById("pcsoReqdate").value;

												if (pcsoDate == "") {
													alert("Please Select Reference Date!!!");
													return false;
												}
												if (pcsoReqdate == "") {
													alert("Please Select pcsoReqdate Date!!!");
													return false;
												}

												var sz = $("#count").val();
												
												var pcoQty = parseFloat($("#pcsoQty").val());
												var sum = 0;
												for (var i = 0; i < sz; i++) {
													var ele =  $("#totalallocation"+ i).val();
													
												    if (ele !== null && ele !== '' && !isNaN(parseFloat(ele))) {
												        sum += parseFloat(ele);
													}else{
														 $("#totalallocation" + i).val(0);
													}
												}
												
												sum = sum.toFixed(2);
												pcoQty = pcoQty.toFixed(2);
												 
												
												if (sum != pcoQty) {
													document.getElementById("errMsg").innerHTML = "Current sum = "
															+ sum
															+ " not equal to PCO Qty.";
													return false;
												} else {
													document.getElementById("errMsg").innerHTML = "";
													return true;
												}

											});
						});
	</script>

	<script src="https://code.jquery.com/ui/1.13.2/jquery-ui.js"></script>
	<script src="./assets/vendors/metisMenu/dist/metisMenu.min.js"
		type="text/javascript"></script>
	<script src="assets/js/app.min.js" type="text/javascript"></script>

</body>
</html>