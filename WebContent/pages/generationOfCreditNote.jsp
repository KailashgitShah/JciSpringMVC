<!DOCTYPE html>
<%@page import="java.util.Calendar"%>
<%@page import="java.text.DecimalFormat"%>
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
<link href="./assets/vendors/DataTables/datatables.min.css"
	rel="stylesheet" />
<!-- THEME STYLES-->
<link href="assets/css/main.min.css" rel="stylesheet" />
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
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
	// String id = (String) request.getAttribute("id");

	String roId = (String) request.getAttribute("roId");

	String bosNo = (String) request.getAttribute("bosNo");
	String bosDate = (String) request.getAttribute("bosDate");
	String diNo = (String) request.getAttribute("diNo");
	String millcode = (String) request.getAttribute("millcode");
	String ContractNo = (String) request.getAttribute("ContractNo");

	String ChallanNo = (String) request.getAttribute("ChallanNo");
	String dpc = (String) request.getAttribute("dpc");
	int Count = (int) request.getAttribute("Count") + 1;
	Double nominalWt = (Double) request.getAttribute("nominalWeight");
	Double actualWt = (Double) request.getAttribute("ActualWeight");
	String invoiceVal = (String) request.getAttribute("invoiceVal");
	Double avgJuteValue = (Double) request.getAttribute("avgJuteVal");
	List<Object[]> dispetchDetails = (List<Object[]>) request.getAttribute("dispetchDetails");
	List<Object> gradeRatio = (List<Object>) request.getAttribute("gradeRatio");
	String gstCode = (String) request.getAttribute("gst");
	int getGstCount = (int) request.getAttribute("getGstCount") + 1;
	/*

	  for (Object p : gradeRatio) {
	         System.err.println("gradeRatio => " + (Double) p);
	  } */

	int sumOfBale = 0;
	for (Object[] details : dispetchDetails) {
		sumOfBale += (int) details[3];
	}

	//double factor = Double.parseDouble(new DecimalFormat("#.##").format(actualWt / sumOfBale));
	double factor = actualWt / sumOfBale;

	/*     System.err.println("nominalWt => " + nominalWt);
	  System.err.println("actualWt => " + actualWt);
	  System.err.println("sumOfBale => " + sumOfBale);
	  System.err.println("factor => " + factor); */

	Double shortQty = nominalWt - actualWt;
	//long crnAmount = Math.round(avgJuteValue * shortQty);

	Calendar calendar = Calendar.getInstance();
	int currentYear = calendar.get(Calendar.YEAR);
	int currentMonth = calendar.get(Calendar.MONTH) + 1; // Calendar.MONTH is zero-based

	int financialYearStart, financialYearEnd;

	if (currentMonth >= 4) { // April or later
		financialYearStart = currentYear;
		financialYearEnd = currentYear + 1;
	} else { // January to March
		financialYearStart = currentYear - 1;
		financialYearEnd = currentYear;
	}

	String endYearLastTwoDigits = Integer.toString(financialYearEnd).substring(2);

	String yearCode = endYearLastTwoDigits;
	String indiaSerialNo = String.format("%06d", Count);
	String gstSerialNo = String.format("%05d", getGstCount);

	String creditNoteIdnNo = "C" + yearCode + indiaSerialNo + gstCode + gstSerialNo;

	double sumNmlQty = 0;
	double sumActQty = 0;
	double sumShrtQty = 0;
	double sumTtlCrnAmt = 0;
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
											<label>Challan No</label> <input class="form-control"
												name="challan" id="challan" type="text"
												value="<%=ChallanNo%>" readonly>
										</div>

										<div class="col-sm-4 form-group">
											<label>BOS Qty.</label> <input class="form-control"
												name="bosQty" id="bosQty" type="text" value="<%=nominalWt%>"
												readonly>
										</div>

										<div class="col-sm-4 form-group">
											<label>Actual Qty. </label> <input class="form-control"
												id="actualQty" name="actualQty" value="<%=actualWt%>"
												<%-- value="<%=new DecimalFormat("#.##").format(actualWt)%>" --%>
												readonly>
										</div>

									</div>


									<div class="row">
										<div class="col-sm-4 form-group" id="dpc">
											<label>Short Qty.</label> <input class="form-control"
												name="shortQty" id="shortQty"
												value="<%=new DecimalFormat("#.####").format(shortQty)%>"
												type="text" readonly>
										</div>

										<div class="col-sm-4 form-group" id="dpc">
											<label>Credit Note Amount </label> <input
												class="form-control" name="creditAmt" id="creditAmt"
												type="text" readonly>
										</div>


										<input class="form-control " name="ChallanNo" id="ChallanNo"
											type="hidden" value="<%=ChallanNo%>" readonly> <input
											class="form-control " name="diNo" id="diNo" type="hidden"
											value="<%=diNo%>" readonly> <input
											class="form-control " name="bosNo" id="bosNo" type="hidden"
											value="<%=bosNo%>" readonly> <input
											class="form-control " name="bosDate" id="bosDate"
											type="hidden" value="<%=bosDate%>" readonly> <input
											class="form-control " name="millcode" id="millcode"
											type="hidden" value="<%=millcode%>" readonly> <input
											class="form-control " name="roId" id="roId" type="hidden"
											value="<%=roId%>" readonly><input
											class="form-control " name="dpc" id="dpc" type="hidden"
											value="<%=dpc%>" readonly><input
											class="form-control " name="gstCode" id="gstCode" type="hidden"
											value="<%=gstCode%>" readonly>

									</div>
									<br>

									<div>
										<table class="table table-bordered">
											<thead class="thead-light">
												<tr>
													<th>Crop Year</th>
													<th>Bale Mark</th>
													<th>Variety/Grade</th>
													<th>No Of Bale</th>
													<th>Nominal Wt</th>
													<th>Rate</th>
													<th>Nominal Qty</th>
													<th>Act Qty</th>
													<th>Short Qty</th>
													<th>Amount</th>
												</tr>
											</thead>
											<tbody>
												<%
												/* 				select Crop_year,Bale_mark,Jute_grade,No_of_bales,Nominal_qty,Rate,Nominal_wt 
														from  jcidispatch_details_child where  Challan_no='242503270002' 
												*/

												for (Object[] p : dispetchDetails) {
													int noOfBale = (int) p[3];
													double rate = (double) p[5];
													double nmnlQty = (double) p[4];

													double actQty = Double.parseDouble(new DecimalFormat("#.##").format(noOfBale * factor));
													double shtQty = Double.parseDouble(new DecimalFormat("#.##").format(nmnlQty - actQty));
													double shortAmtPrice = Math.round(rate * shtQty);
													/*  double shtQty = nmnlQty - actQty;
													double shortAmtPrice = rate * shtQty; */
													sumNmlQty += nmnlQty;
													sumActQty += actQty;
													sumShrtQty += shtQty;
													sumTtlCrnAmt += shortAmtPrice;
													System.err.println("shtQty " + shtQty);
												%>
												<tr>
													<td><div class="table-cell"><%=(String) p[0]%></div></td>
													<td><div class="table-cell"><%=(String) p[1]%></div></td>
													<td><div class="table-cell"><%=(String) p[2]%></div></td>
													<td><div class="table-cell"><%=(int) p[3]%></div></td>
													<td><div class="table-cell"><%=(double) p[6]%></div></td>
													<td><div class="table-cell"><%=rate%></div></td>
													<td><div class="table-cell"><%=(double) p[4]%></div></td>
													<td><div class="table-cell"><%=actQty%></div></td>
													<td><div class="table-cell"><%=shtQty%></div></td>
													<td><div class="table-cell"><%=shortAmtPrice%></div></td>
												</tr>
												<%
												}

												sumShrtQty = Double.parseDouble(new DecimalFormat("#.##").format(sumShrtQty));
												sumActQty = Double.parseDouble(new DecimalFormat("#.##").format(sumActQty));
												sumNmlQty = Double.parseDouble(new DecimalFormat("#.##").format(sumNmlQty));
												int finalAmount = (int) Math.ceil(sumTtlCrnAmt);
												%>
												<tr>
													<td><div class="table-cell"></div></td>
													<td><div class="table-cell"></div></td>
													<td><div class="table-cell"></div></td>
													<td><div class="table-cell"></div></td>
													<td><div class="table-cell"></div></td>
													<td><div class="table-cell">Total</div></td>
													<td><div class="table-cell"><%=sumNmlQty%></div></td>
													<td><div class="table-cell"><%=sumActQty%></div></td>
													<td><div class="table-cell"><%=sumShrtQty%></div></td>
													<td><div class="table-cell"><%=finalAmount%></div></td>
												</tr>
											</tbody>
										</table>
									</div>

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
	<script src="./assets/vendors/DataTables/datatables.min.js"
		type="text/javascript"></script>
	<!-- CORE SCRIPTS-->
	<script src="assets/js/app.min.js" type="text/javascript"></script>

	<script>
	$(document).ready(function(){
	<%-- 	alert('<%=finalAmount%>'); --%>
		document.getElementById('creditAmt').value='<%=finalAmount%>';
		});
	</script>

</body>
</html>