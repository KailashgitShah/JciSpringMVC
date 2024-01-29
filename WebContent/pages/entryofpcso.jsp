
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
	top : 56px;
	padding:40px;
	background: #f1f1f1;
}

</style>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width initial-scale=1.0">
<title>JCI | CMS</title>
<!-- GLOBAL MAINLY STYLES-->
<link href="./assets/vendors/bootstrap/dist/css/bootstrap.min.css"
	rel="stylesheet" />
<link
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.1/css/all.min.css"
	rel="stylesheet" />
<link href="./assets/vendors/themify-icons/css/themify-icons.css"
	rel="stylesheet" />
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.13.2/themes/base/jquery-ui.css">
<link rel="stylesheet" href="/resources/demos/style.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<!-- PLUGINS STYLES-->
<!-- THEME STYLES-->
<link href="assets/css/main.min.css" rel="stylesheet" />
<!-- PAGE LEVEL STYLES-->
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

			String referenceno = (String) request.getAttribute("referenceno");
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

			}

			String currCropYear = (String) request.getSession().getAttribute("currCropYear");
			%>
			<div class="page-content fade-in-up">
				<div class="row">
					<div class="col-md-11">
						<div class="ibox">
							<div class="ibox-head">
								<span>${msg}</span>
							</div>
							<div class="ibox-body">
								<form action="entryofpcsosave.obj" method="POST">
									<div class="fixedCol row">
										<div class="row">


											<div class="col-sm-3 form-group">
												<label>JCI letter Ref.</label> <select class="form-control"
													name="letterRefNo" id="refNo" required>
													<option selected value="">-Select-</option>
													<%
													for (String ref : allRefNo) {
													%>
													<option value="<%=ref%>"
														<%if (ref.equals(letterRefNo)) {
	out.print("Selected");
} else {
	out.print("");
}%>>
														<%=ref%></option>

													<%
													}
													%>


												</select>
											</div>

											<div class="col-sm-3 form-group">
												<label>PCO Req Date</label> <input class="form-control"
													name="pcsoReqdate" id="pcsoReqdate"
													placeholder="dd-mm-yyyy" value="<%=pcsoReqdate%>" readonly>
											</div>


											<div class="col-sm-3 form-group">
												<label>PCO Requested Qty. (M.T)</label> <input
													class="form-control" name="pcsoReqQty" id="pcsoReqQty"
													value="<%=pcsoReqQty%>" readonly>
											</div>

											<div class="col-sm-3 form-group">
												<label>PCO Date</label> <input class="form-control"
													name="pcsoDate" id="pcsoDate" placeholder="dd-mm-yyyy"
													value="<%=pcsoDate%>" required>
											</div>
										</div>
										<br>
										<div class="row">


											<div class="col-sm-3 form-group">
												<label>JC Office Ref.No.</label> <input class="form-control"
													type="text" name="referenceno" placeholder="Reference.No."
													value="<%=referenceno%>" id="referenceno" required>
											</div>

											<div class="col-sm-3 form-group">
												<label>JCI Linkage Percentage.</label> <input
													class="form-control" type="number" name="juteRatio"
													id="juteRatio" min="0" step="0.01" value="<%=juteRatio%>"
													required>
											</div>



											<div class="col-sm-3 form-group">
												<label>PCO Qty. (M.T)</label> <input class="form-control"
													value="<%=pcsoQty%>" name="pcsoQty" id="pcsoQty">
											</div>




											<div class="col-sm-3 form-group">
												<label>Dispatch Period</label> <input class="form-control"
													value="<%=dispatchPeriod%>" name="dispatchPeriod"
													id="dispatchPeriod" required placeholder="dd-mm-yyyy">
											</div>

										</div>
									</div>
									<div class="row" style="margin-top: 145px;">
										<div class="col-sm-4 form-group ">
											<label class="font-weight-bold">Mill Code</label>
										</div>
										<div class="col-sm-4 form-group">
											<label class="font-weight-bold">Mill Name</label>
										</div>
										<div class="col-sm-4 form-group">
											<label class="font-weight-bold">Total allocation (MT)</label>
										</div>
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
											<input type="number" step="any" class="form-control tAll"
												min="0" name="totalallocation<%=mill%>" value="0"
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

	<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
	<script src="https://code.jquery.com/ui/1.13.2/jquery-ui.js"></script>
	<script>
		$(document).ready(function() {
			$("#pcsoDate").datepicker({
				dateFormat : 'dd-mm-yy',
				minDate : 0
			});

			$("#dispatchPeriod").datepicker({
				dateFormat : 'dd-mm-yy',
			});
		});
		/* 	$("#pcsoReqdate").datepicker({
				dateFormat : 'dd-mm-yy'
			}); */
	</script>



	<script type="text/javascript">
		var mybutton = document.getElementById("btn-back-to-top");

		// When the user scrolls down 20px from the top of the document, show the button
		window.onscroll = function() {
			scrollFunction();
		};

		function scrollFunction() {
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
		$("#pcsoDate").on(
				"change",
				function() {
					var currDate = $(this).val().split("-");
					var minDateValue = new Date(currDate[2], currDate[1] - 1,
							currDate[0]);
					$("#dispatchPeriod").datepicker('option', 'minDate',
							minDateValue);
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
						var refVal = inputVal.replace(/[^a-zA-Z0-9]/g, "");
						$(this).val(refVal);
					});

					// to set total allocation as needed
					inputFields.each(function() {
						var inputField = $(this);
						var lastVal = inputField.val();

						inputField.on("input", function() {
							var inputVal = $(this).val();
							if (inputVal === "")
								return;

							// inputVal = inputVal.replace(/[^0-9.]/g, '');

							/* 	if (isNaN(inputVal)) {
									$(this).val(lastVal);
								} else if (inputVal > 999999) {
									$(this).val(lastVal);
								} else if (inputVal < 1) {
									$(this).val(1);
									lastVal = 1;
								} else {
									lastVal = inputVal;
								} */
						});

						// to prevent +, - and e from being input
						inputFields.on("keydown", function(event) {
							if (event.key === "-" || event.key === "+"
									|| event.key === "e" || event.key === "E") {
								event.preventDefault();
							}
						});
					});

					// to check if the fields are all empty or some have values.
					function checkFields() {
						var allEmpty = true;
						inputFields.each(function() {
							if ($(this).val() != "0" && $(this).val() != "") {
								allEmpty = false;
								return true;
							}
						});
						submitButton.prop("disabled", allEmpty);
					}

					inputFields.on("input", checkFields);
					checkFields();

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
												var pcoQty = $("#pcsoQty")
														.val();
												var sum = 0;
												for (var i = 0; i < sz; i++) {
													val
													ele
															- $(
																	"#totalallocation"
																			+ i)
																	.val();
													if (ele) {
														sum += parseInt(ele);
													}
												}

												if (sum != pcoQty) {
													document
															.getElementById("errMsg").innerHTML = "Current sum = "
															+ sum
															+ " not equal to PCO Qty.";
													return false;
												} else {
													document
															.getElementById("errMsg").innerHTML = "";
													return true;
												}

											});
						});
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
					var pcsoReqdate = data[0][6];

					var reqQty = data[0][7];

					$("#pcsoReqdate").val(pcsoReqdate);
					$("#pcsoReqQty").val(reqQty);

					/* 		var contract = data.contractDetails[0];
					var count = data.count + 1;

					$("#contractDate").val(contract[2]);
					$("#contractNo").val(contract[3]);
					$("#cropYear").val(contract[7]);
					$("#roDiNo").val(val + "/" + count);
					 */
				}
			})
		});
	</script>



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
	<!-- PAGE LEVEL SCRIPTS-->
</body>
</html>