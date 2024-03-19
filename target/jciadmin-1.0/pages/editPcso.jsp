<%@page import="java.util.HashMap"%>
<%@page import="java.util.List"%>
<%@page import="java.io.File"%>
<%@page import="com.jci.model.EntryofpcsoModel"%>
<%@page import="java.util.List"%>
<%@page import="java.text.SimpleDateFormat"%>




<!DOCTYPE html>
<html lang="en">

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
<!-- PAGE LEVEL STYLES-->

<style>
.required:after {
	content: " *";
	color: red;
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
				<h1 class="page-title">PCSO</h1>

			</div>

			<%
			EntryofpcsoModel pcsoEl = (EntryofpcsoModel) request.getAttribute("pcso");
			%>
			<div class="page-content fade-in-up">
				<div class="row">
					<div class="col-md-11">
						<div class="ibox">
							<span>${msg}</span>
							<div class="ibox-body">
								<form action="updatesavePcso.obj" method="POST">
									<div class="row">
										<div class="col-sm-4 form-group">
											<label class="required">JCI letter Ref.</label> <input
												class="form-control" name="letterRef" type="text"
												id="letterRef" value="<%=pcsoEl.getLetterRef()%>" readonly>
										</div>
										<div class="col-sm-4 form-group">
											<label class="required">Reference No.</label> <input
												type="hidden" name="pcsorefid"
												value="<%=pcsoEl.getPcsorefid()%>"> <input
												class="form-control" name="referenceno" id="referenceno"
												value="<%=pcsoEl.getReference_no()%>" readonly>
										</div>
										<div class="col-sm-4 form-group">
											<label class="required">Reference Date</label> <input
												class="form-control" name="referencedate" id="referencedate"
												value="<%=pcsoEl.getReference_date()%>" readonly>

										</div>


									</div>
									<div class="row">

										<div class="col-sm-4 form-group">
											<label class="required">PCSO Date</label> <input
												class="form-control" name="pcsodate" id="pcsodate"
												value="<%=pcsoEl.getPcso_date()%>" readonly>

										</div>

										<div class="col-sm-4 form-group">
											<label class="required">Mill Code</label> <input
												class="form-control" name="millcode" type="text"
												placeholder="Mill code" id="millcode"
												value="<%=pcsoEl.getMill_code()%>" readonly>
										</div>
										<div class="col-sm-4 form-group">
											<label class="required">Mill Name</label> <input
												class="form-control" name="millname" type="text"
												placeholder="Mill code" id="millname"
												value="<%=pcsoEl.getMill_name()%>" readonly>
										</div>

									</div>
									<div class="row">

										<div class="col-sm-4 form-group">
											<label class="required">PCSO Qty.</label> <input
												class="form-control" name="pscoQty" type="number"
												id="pscoQty" readonly value="<%=pcsoEl.getPcsoQty()%>">
										</div>
										<div class="col-sm-4 form-group">
											<label class="required">Total Allocation</label> <input
												class="form-control" name="totalallocation" type="number"
												id="totalallocation"  value="<%=pcsoEl.getAllocatedQty()%>">
										</div>\
										<div class="col-sm-4 form-group">
											 <input
												class="form-control" name="pcsorefid" type="hidden"
												id="pcsorefid" value="<%=pcsoEl.getPcsorefid()%>">
										</div>


									</div>

									<div class="form-group col-sm-12">
										<button class="btn btn-default" type="submit">Submit</button>
									</div>
								</form>
							</div>
						</div>
					</div>
				</div>
			</div>

			<div class="sidenav-backdrop backdrop"></div>

			<!-- END PAGE CONTENT-->
			<%@ include file="footer.jsp"%>
		</div>
	</div>
	<!-- END PAGE CONTENT-->
	<%@ include file="footer.jsp"%>
	</div>
	</div>
	<!-- BEGIN THEME CONFIG PANEL-->

	<!-- END THEME CONFIG PANEL-->
	<!-- BEGIN PAGA BACKDROPS-->
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
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
	<!-- PAGE LEVEL PLUGINS-->
	<script src="./assets/vendors/DataTables/datatables.min.js"
		type="text/javascript"></script>
	<!-- CORE SCRIPTS-->
	<script src="assets/js/app.min.js" type="text/javascript"></script>
	<!-- PAGE LEVEL SCRIPTS-->
	<script type="text/javascript">
		$(function() {
			$('#example-table').DataTable({
				pageLength : 10,
			//"ajax": './assets/demo/data/table_data.json',
			/*"columns": [
			    { "S": "name" },
			    { "data": "office" },
			    { "data": "extn" },
			    { "data": "start_date" },
			    { "data": "salary" }
			]*/
			});
		})
	</script>
	<script type="text/javascript">
		$(document).ready(function() {

			var sTAll = $("#sumoftotalallocation");
			var tAll = $("#totalallocation");
			var sTAllVal = parseFloat(sTAll.val());
			var tAllVal = parseFloat(tAll.val());

			tAll.on("input", function() {
				sTAll.val(sTAllVal - tAllVal + parseFloat(tAll.val()))
				console.log("hi")
			})
			console.log(sTAllVal);

		})
	</script>


</body>

</html>