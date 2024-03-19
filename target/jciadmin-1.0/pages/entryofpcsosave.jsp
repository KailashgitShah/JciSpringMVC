
<%@page import="org.apache.poi.util.SystemOutLogger"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.List"%>
<%@page import="java.io.File"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>

<%@page import="com.jci.model.EntryofpcsoModel"%>
<!DOCTYPE html>
<html lang="en">

<head>
<style>
.myname {
	width: 100%;
	height: 32px;
}

.inputMill {
	width: 100%;
	height: 32px;
}
</style>
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
				<h1 class="page-title">Save Entry of PCO</h1>
			</div>

			<%
			List<EntryofpcsoModel> allentryofpcsolist = (List<EntryofpcsoModel>) request.getAttribute("entryofpcso");
			String referencedate = (String) request.getAttribute("referencedate");
			String pcsodate = (String) request.getAttribute("pcsodate");
			String referenceNo = (String) request.getAttribute("referenceno");
			
		
		/* 	for(EntryofpcsoModel e : allentryofpcsolist){
				System.out.println(e.toString());
			} */
		
			String deliveryPeriod = (String)request.getAttribute("deliveryPeriod");
			String juteRatio = (String)request.getAttribute("juteRatio");
			String letterRef = (String)request.getAttribute("letterRef");
			Double pcsoQty = (Double)request.getAttribute("pcsoQty");
			
			%>
			<div class="page-content fade-in-up">
				<div class="row">
					<div class="col-md-11">
						<div class="ibox">
							<div class="ibox-head">
								<span>${msg}</span>
							</div>
							<div class="ibox-body">
								<form action="saveentryofpcsodata.obj" method="POST">

									<div class="row">
										<div class="col-sm-4 form-group">
											<label>Reference.No.</label> <input class="form-control"
												type="text" value="<%=referenceNo%>" readonly
												name="referenceno">
										</div>

										<div class="col-sm-4 form-group">
											<label>Reference Date</label> <input class="form-control"
												type="text" value="<%=referencedate%>" readonly
												name="referencedate">
										</div>

										<div class="col-sm-4 form-group">
											<label>PCSO Date</label> <input class="form-control"
												type="text" name="pcsodate" value="<%=pcsodate%>" readonly>
										</div>
									</div>
									<div class="row">
										<div class="col-sm-3 form-group">
											<label>JCI letter Ref.</label> <input class="form-control"
												name="letterRefNo" id="letterRefNo" value="<%=letterRef %>" readonly>	
										</div>

										<div class="col-sm-3 form-group">
											<label>Delivery Period</label> <input class="form-control"
												name="deliveryPeriod" id="deliveryPeriod" value="<%=deliveryPeriod %>" readonly
												 >
										</div>

										<div class="col-sm-3 form-group">
											<label>JCI Jute Ratio.</label> <input class="form-control"
												 name="juteRatio" id="juteRatio" readonly value="<%=juteRatio%>"
												>
										</div>
										<div class="col-sm-3 form-group">
											<label>PCSO Qty</label> <input class="form-control"
												 name="pcsoQty" id="pcsoQty" readonly value="<%=pcsoQty%>"
												>
										</div>
									</div>

									<br>
									<div class="row">
										<div class="col-sm-4 form-group">
											<label>Mill Code</label>
										</div>
										<div class="col-sm-4 form-group">
											<label>Mill Name</label>
										</div>
										<div class="col-sm-4 form-group">
											<label>Total allocation</label>
										</div>
									</div>

									<%
									double num = 0, sum = 0;
									int mill = 0;
									for (EntryofpcsoModel entryofpcsolist : allentryofpcsolist) {
							
											//SimpleDateFormat formatter = new SimpleDateFormat("yyyy/dd/MM");
											
									%>

									<div class="row">
										<div class="col-sm-4 form-group">
											<input type="text" class="form-control"
												name="millcode<%=mill%>" id="millcode<%=mill%>"
												value="<%=entryofpcsolist.getMill_code() %>" readonly>
										</div>
										<div class="col-sm-4 form-group">
											<input type="text" class="form-control"
												name="millname<%=mill%>" id="millname<%=mill%>"
												value="<%=entryofpcsolist.getMill_name()%>" readonly>
										</div>
										<div class="col-sm-4 form-group">
											<input type="text" class="myname form-control"
												name="totalallocation<%=mill%>"
												id="totalallocation<%=mill%>"
												value="<%=entryofpcsolist.getAllocatedQty() %>" readonly>
										</div>
									</div>

									<%
									mill++;

									num =  entryofpcsolist.getAllocatedQty();
									sum += num;

									}
									%>
									<div class="row">
										<div class="col-sm-4 form-group"></div>
										<div class="col-sm-4 form-group"></div>
										<div class="col-sm-4 form-group">
											<input type="text" class="form-control myname" name="sumoftotalallocation"
												id="sumoftotalallocation"
												value="Sum of total allocation = <%=sum%> " readonly>
										</div>
									</div>
									<input name="count" id="count" type="hidden" value="<%=mill%>">

									<div class="form-group col-sm-12">
										<!--<button class="btn btn-default">
											<a href="entryofpcso.obj">Reset</a>
										</button> -->
										<button class="btn btn-default" type="submit" id="submit">Submit</button>
										<button class="btn btn-default" type="submit" id="reset"
											formaction="entryofpcso.obj">Reset</button>
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




	<!-- PAGE LEVEL SCRIPTS-->
</body>
</html>