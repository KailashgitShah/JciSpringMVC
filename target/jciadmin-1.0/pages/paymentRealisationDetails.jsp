<%@page import="com.jci.model.JciDIHoModel"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.List"%>
<%@page import="java.io.File"%>
<%@page import="com.jci.model.RoleMasterModel"%>
<%@page import="com.jci.model.ZoneModel"%>

<%@page import="com.jci.model.UserRegistrationModel"%>

<%@page isELIgnored="false"%>
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
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<!-- PLUGINS STYLES-->
<link href="./assets/vendors/DataTables/datatables.min.css"
	rel="stylesheet" />
<!-- THEME STYLES-->
<link href="assets/css/main.min.css" rel="stylesheet" />
<!-- PAGE LEVEL STYLES-->
<script type="text/javascript">
	$(document).ready(function() {
		$("#farmerVerific").DataTable({
			scrollX : true,
			"pageLength" : 50
		});
	});
</script>
<style>
.scrollmenu {
	overflow: scroll;
	white-space: nowrap;
}

.scrollmenu a {
	display: inline-block;
	color: white;
	text-align: center;
	padding: 14px;
	text-decoration: none;
}

.tableFixHead {
	overflow: auto;
	height: 100px;
	width: 240px;
}

.tableFixHead thead th {
	position: sticky;
	top: 0;
	z-index: 1;
}

.tableFixHead tbody th {
	position: sticky;
	left: 0;
}

table {
	border-collapse: collapse;
	width: 100%;
}

th, td {
	padding: 8px 16px;
	white-space: nowrap;
}

th {
	background: #eee;
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
				<h1 class="page-title">Credit And Debit Note Details</h1>

			</div>


			<div class="page-content fade-in-up">
				<div class="ibox">
					<span>${msg}</span>
					<div class="ibox-body">
						<div class="scrollmenu">
							<div text-center><a href="viewpaymentRealisation.obj"><button class="btn btn-primary" type="button">Back</button></a></div>
							<table
								class="table table-striped table-bordered table-hover tableFixHead"
								id="example-table" cellspacing="0" width="100%">


								<thead>
									<tr>
									<th>Sl.NO</th>
									<th>CN/DN No</th>
									<th>Purpose</th>
									<th>Date Of Issue</th>
									<th>HODI No</th>
									<th>Consignment_Note</th>
									<th>Bos_No</th> 
									<th>Date_Of_Shipment</th>
									<th>Date_Of_Inspection</th>	
									<th>CN/DN Amount</th>
									<th>CN/DN Amount Difference</th>
									<th>Settlement_Id</th>
									 <th></th> 
									
													
									</tr>
								</thead>
								<tbody>
								<%int i=1; %>

									 <c:forEach items="${creditdebit}" var="item">



										<tr>
										<td  class="sorting_1"><%=i%></td>
								            <td>${item.getCreditNoteNo()}</td>
                                           <td>${item.getPurpose()}</td>
                                            <td>${item.getDateOfIssue()}</td>
											<td>${item.getHodi()}</td>
											 <td>${item.getConsigneeNoteText()}</td>
											 <td>${item.getBosNo()}</td>	
											 	 <td>${item.getDateOfShipment()}</td>	
											 	  <td>${item.getDateOfInspection()}</td>	
											 	   <td>${item.getCreditNoteAmount()}</td>
											 	   <td>${item.getAmountDiffCnAndDn()}
											 	    <td>${item.getSettlementId()}</td>	
										</tr>
										<%i++; %>
									</c:forEach>
 


								</tbody>

							</table>
						</div>
					</div>
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
	<!-- PAGE LEVEL PLUGINS-->
	<script src="./assets/vendors/DataTables/datatables.min.js"
		type="text/javascript"></script>
	<!-- CORE SCRIPTS-->
	<script src="assets/js/app.min.js" type="text/javascript"></script>
	<!-- PAGE LEVEL SCRIPTS-->
	<script type="text/javascript">
		$(function() {
			$('#example-table').DataTable({

				fixedHeader : true

			//"ajax": './assets/demo/data/table_data.json',
			/*"columns": [
			    { "S": "name" },
			    { "data": "office" },
			    { "data": "extn" },
			    { "data": "start_date" },
			    { "data": "salary" }
			] */
			});
		})
	</script>
</body>

</html>