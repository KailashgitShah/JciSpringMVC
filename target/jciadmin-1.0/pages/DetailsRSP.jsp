<%@page import="java.util.HashMap"%>
<%@page import="java.util.List"%>
<%@page import="java.io.File"%>

<%@page import="com.jci.controller.LoginController"%>
<%@ page import="java.text.SimpleDateFormat"%>
<%@ page import="java.text.ParseException"%>
<%@ page import="java.util.Date"%>
<%@ page import="java.util.List"%>


<%@page isELIgnored="false"%>
<%@page import="java.math.BigDecimal"%>
<%@page import="com.jci.common.Encry"%>
<%@page import="com.jci.controller.LoginController"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
table {
	border-collapse: collapse;
	width: 100%;
}

th, td {
	text-align: left;
	padding: 8px;
}

tr:nth-child(even) {
	background-color: #f2f2f2;
}

.input-box-d {
	width: 100%; /* Ensure the input fields fill the entire column width */
	box-sizing: border-box; /* Include padding and border in the width */
	background: #e9ecef;
	border: 1px solid;
}
</style>

<script src="https://code.jquery.com/jquery-1.11.3.min.js"
	type="text/javascript"></script>
<script
	src="https://cdn.datatables.net/1.10.9/js/jquery.dataTables.min.js"
	type="text/javascript"></script>
<link rel="stylesheet"
	href="https://cdn.datatables.net/1.10.9/css/jquery.dataTables.min.css" />
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		$("#farmerVerific").DataTable({
			scrollX : true,
			"pageLength" : 50
		});
	});
</script>
</head>
<%
String key = LoginController.secretkey;
List<Object[]> list = (List<Object[]>) request.getAttribute("Data");
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
				<h1 class="page-title">Details RSP Page</h1>
			</div>
			<%
			for (Object[] row : list) {
				/* String encryptedid = Encry.encrypt(String.valueOf(row[0]),key); */
			%>
			<div class="row"></div>

			<div class="row mt-5">
				<div class="col-sm-4 form-group">
					<label>Crop Year</label> <span class="text-danger"> </span>&nbsp; <input
						class="form-control" name="lotsize" id="lotsize" type="text"
						value="<%=row[32]%>" readonly>
				</div>
				<div class="col-sm-4 form-group">
					<label>Lot Id</label> <span class="text-danger"> </span>&nbsp; <input
						class="form-control" name="lotsize" id="lotsize" type="text"
						value="<%=row[33]%>" readonly>
				</div>
				<div class="col-sm-4 form-group">
					<label>Lot Size</label> <span class="text-danger"> </span>&nbsp; <input
						class="form-control" name="lotsize" id="lotsize" type="text"
						value="<%=row[34]%>" readonly>
				</div>

			</div>
			<div class="row">
				<div class="col-sm-4 form-group">
					<label>TD5 Base Price</label> <span class="text-danger"> </span>&nbsp;
					<input class="form-control" name="lotsize" id="lotsize" type="text"
						value="<%=row[35]%>" readonly>
				</div>
				<div class="col-sm-4 form-group">
					<label>Jute Variety</label> <span class="text-danger"> </span>&nbsp;
					<input class="form-control" name="lotsize" id="lotsize" type="text"
						value="<%=row[37]%>" readonly>
				</div>
				<div class="col-sm-4 form-group">
					<label>Region</label> <span class="text-danger"> </span>&nbsp; <input
						class="form-control" name="lotsize" id="lotsize" type="text"
						value="<%=row[36]%>" readonly>
				</div>
			</div>

			<div class="row mt-5 no-gutters">
				<div class="col-12 center-label">
					<label><strong>RSP Grade Price</strong></label>
				</div>
			</div>

			<div class="row no-gutters">
				<div class="col-1 no-padding">
					<label>Grade 1</label> <input type="text" readonly id="Pur_grd1"
						name="Pur_grd1" class="input-box-d" value="<%=row[0]%>" readonly>
				</div>
				<div class="col-1 no-padding">
					<label>Grade 2</label> <input type="text" readonly id="Pur_grd2"
						name="Pur_grd2" class="input-box-d" value="<%=row[1]%>" readonly>
				</div>
				<div class="col-1 no-padding">
					<label>Grade 3</label> <input type="text" readonly id="Pur_grd3"
						name="Pur_grd3" class="input-box-d" value="<%=row[2]%>" readonly>
				</div>
				<div class="col-1 no-padding">
					<label>Grade 4</label> <input type="text" readonly id="Pur_grd4"
						name="Pur_grd4" class="input-box-d" value="<%=row[3]%>" readonly>
				</div>
				<div class="col-1 no-padding">
					<label>Grade 5</label> <input type="text" readonly id="Pur_grd5"
						name="Pur_grd5" class="input-box-d" value="<%=row[4]%>" readonly>
				</div>
				<div class="col-1 no-padding">
					<label>Grade 6</label> <input type="text" readonly id="Pur_grd6"
						name="Pur_grd6" class="input-box-d" value="<%=row[5]%>" readonly>
				</div>
				<div class="col-1 no-padding">
					<label>Grade 7</label> <input type="text" readonly id="Pur_grd7"
						name="Pur_grd7" class="input-box-d" value="<%=row[6]%>" readonly>
				</div>
				<div class="col-1 no-padding">
					<label>Grade 8</label> <input type="text" readonly id="Pur_grd8"
						name="Pur_grd8" class="input-box-d" value="<%=row[7]%>" readonly>
				</div>
			</div>

			<div class="row mt-5 no-gutters">
				<div class="col-12 center-label">
					<label><strong>RSP Grade Differential</strong></label>
				</div>
			</div>

			<div class="row no-gutters">
				<div class="col-1 no-padding">
					<label>Grade 1</label> <input type="text" readonly
						id="Pur_grd1_diff" name="Pur_grd1_diff" class="input-box-d"
						value="<%=row[8]%>" readonly>
				</div>
				<div class="col-1 no-padding">
					<label>Grade 2</label> <input type="text" readonly
						id="Pur_grd2_diff" name="Pur_grd2_diff" class="input-box-d"
						value="<%=row[9]%>" readonly>
				</div>
				<div class="col-1 no-padding">
					<label>Grade 3</label> <input type="text" readonly
						id="Pur_grd3_diff" name="Pur_grd3_diff" class="input-box-d"
						value="<%=row[10]%>" readonly>
				</div>
				<div class="col-1 no-padding">
					<label>Grade 4</label> <input type="text" readonly
						id="Pur_grd4_diff" name="Pur_grd4_diff" class="input-box-d"
						value="<%=row[11]%>" readonly>
				</div>
				<div class="col-1 no-padding">
					<label>Grade 5</label> <input type="text" readonly
						id="Pur_grd5_diff" name="Pur_grd5_diff" class="input-box-d"
						value="<%=row[12]%>" readonly>
				</div>
				<div class="col-1 no-padding">
					<label>Grade 6</label> <input type="text" readonly
						id="Pur_grd6_diff" name="Pur_grd6_diff" class="input-box-d"
						value="<%=row[13]%>" readonly>
				</div>
				<div class="col-1 no-padding">
					<label>Grade 7</label> <input type="text" readonly
						id="Pur_grd7_diff" name="Pur_grd7_diff" class="input-box-d"
						value="<%=row[14]%>" readonly>
				</div>
				<div class="col-1 no-padding">
					<label>Grade 8</label> <input type="text" readonly
						id="Pur_grd8_diff" name="Pur_grd8_diff" class="input-box-d"
						value="<%=row[15]%>" readonly>
				</div>
			</div>

			<div class="row mt-5 no-gutters">
				<div class="col-12 center-label">
					<label><strong>Sell Grade Differential</strong></label>
				</div>
			</div>

			<div class="row no-gutters">
				<div class="col-1 no-padding">
					<label>Sell Grade 1</label> <input type="text" id="Sell_gr1"
						name="Sell_gr1" class="input-box-d" value="<%=row[24]%>" readonly>
				</div>
				<div class="col-1 no-padding">
					<label>Sell Grade 2</label> <input type="text" id="Sell_gr2"
						name="Sell_gr2" class="input-box-d" value="<%=row[25]%>" readonly>
				</div>
				<div class="col-1 no-padding">
					<label>Sell Grade 3</label> <input type="text" id="Sell_gr3"
						name="Sell_gr3" class="input-box-d" value="<%=row[26]%>" readonly>
				</div>
				<div class="col-1 no-padding">
					<label>Sell Grade 4</label> <input type="text" id="Sell_gr4"
						name="Sell_gr4" class="input-box-d" value="<%=row[27]%>" readonly>
				</div>
				<div class="col-1 no-padding">
					<label>Sell Grade 5</label> <input type="text" id="Sell_gr5"
						name="Sell_gr5" class="input-box-d" value="<%=row[28]%>" readonly>
				</div>
				<div class="col-1 no-padding">
					<label>Sell Grade 6</label> <input type="text" id="Sell_gr6"
						name="Sell_gr6" class="input-box-d" value="<%=row[29]%>" readonly>
				</div>
				<div class="col-1 no-padding">
					<label>Sell Grade 7</label> <input type="text" id="Sell_gr7"
						name="Sell_gr7" class="input-box-d" value="<%=row[30]%>" readonly>
				</div>
				<div class="col-1 no-padding">
					<label>Sell Grade 8</label> <input type="text" id="Sell_gr8"
						name="Sell_gr8" class="input-box-d" value="<%=row[31]%>" readonly>
				</div>
			</div>


			<div class="row  mt-5 no-gutters">
				<div class="col-12 center-label">
					<label><strong>Sell Grade Price </strong></label>
				</div>
			</div>


			<div class="row  no-gutters">
				<div class="col-1 no-padding">
					<label>Grade 1</label> <input type="text" id="Sell_gr1_diff"
						name="Sell_gr1_diff" class="input-box-d" value="<%=row[16]%>"
						readonly>
				</div>
				<div class="col-1 no-padding">
					<label>Grade 2</label> <input type="text" id="Sell_gr2_diff"
						name="Sell_gr2_diff" class="input-box-d" value="<%=row[17]%>"
						readonly>
				</div>
				<div class="col-1 no-padding">
					<label>Grade 3</label> <input type="text" id="Sell_gr3_diff"
						name="Sell_gr3_diff" class="input-box-d" value="<%=row[18]%>"
						readonly>
				</div>
				<div class="col-1 no-padding">
					<label>Grade 4</label> <input type="text" id="Sell_gr4_diff"
						name="Sell_gr4_diff" class="input-box-d" value="<%=row[19]%>"
						readonly>
				</div>
				<div class="col-1 no-padding">
					<label>Grade 5</label> <input type="text" id="Sell_gr5_diff"
						name="Sell_gr5_diff" class="input-box-d" value="<%=row[20]%>"
						readonly>
				</div>
				<div class="col-1 no-padding">
					<label>Grade 6</label> <input type="text" id="Sell_gr6_diff"
						name="Sell_gr6_diff" class="input-box-d" value="<%=row[21]%>"
						readonly>
				</div>
				<div class="col-1 no-padding">
					<label>Grade 7</label> <input type="text" id="Sell_gr7_diff"
						name="Sell_gr7_diff" class="input-box-d" value="<%=row[22]%>"
						readonly>
				</div>
				<div class="col-1 no-padding">
					<label>Grade 8</label> <input type="text" id="Sell_gr8_diff"
						name="Sell_gr8_diff" class="input-box-d" value="<%=row[23]%>"
						readonly>
				</div>

			</div>






			<%
			}
			%>



		</div>
		<!-- END PAGE CONTENT-->
		<%@ include file="footer.jsp"%>
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
	<!-- PAGE LEVEL PLUGINS-->
	<script src="./assets/vendors/DataTables/datatables.min.js"
		type="text/javascript"></script>
	<!-- CORE SCRIPTS-->
	<script src="assets/js/app.min.js" type="text/javascript"></script>
	<!-- PAGE LEVEL SCRIPTS-->







</body>

</html>


