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
				<h1 class="page-title">View Mill Registration</h1>

			</div>


			<div class="page-content fade-in-up">
				<div class="ibox">
					<span>${msg}</span>
					<div class="ibox-body">
						<div class="scrollmenu">
							<table
								class="table table-striped table-bordered table-hover tableFixHead"
								id="example-table" cellspacing="0" width="100%">


								<thead>
									<tr>
										<th>Sl.No</th>
										<th>Mill Name</th>
										<th>Mill Code</th>
										<th>Mill Email</th>
										<th>Mill Password</th>
										<th>Confirm Mill Password</th>
										<th>Mill Mobile Number</th>
										<th>Mill Official Name</th>
										<th>Designation</th>
										<th>Password Reset</th>


									</tr>
								</thead>
								<tbody>
									<%
									int i = 1;
									%>
									<c:forEach items="${AllList}" var="item">


										<tr>

											<td><%=i%></td>

											<td>${item. getMill_name()}</td>
											<td>${item.getMill_code() }</td>
											<td>${item. getMill_emailaddress()}</td>
											<td>${item.getMill_password() }</td>
											<td>${item.getConfirm_mill_password() }</td>
											<td>${item.getMill_mobile() }</td>
											<td>${item.getOfficial_name()}</td>
											<td>${item.getOfficial_designation()}</td>

											<%--     <td><a href="updateMillRegistration.obj?id=${item.getMillRegistration_id()}"><button class="btn btn-secondary" type="submit">RESET</button></a></td>   --%>

											<td><a href="#"
												onclick="confirmReset('${item.getMillRegistration_id()}')">
													<button class="btn btn-secondary" type="button">RESET PASSWORD</button>
											</a></td>

											<%--    <td>
				 				     <form action="ResetMillRegistrationPassword.obj" method="POST">
											
												<input type="hidden" value="${item.getMillRegistration_id()}"
													name="MillRegistration_id"  >
												 <button class="btn btn-default" type="submit">Reset</button>
												
											
											</form> 
							</td>
							 --%>
										</tr>
										<%
										i++;
										%>
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
	<script>
		function confirmReset(registrationId) {
			// Display a confirmation dialog
			var confirmation = confirm("Are you sure you want to reset the password?");

			// If user clicks "OK" (true)
			if (confirmation) {
				// Redirect to the reset password page
				window.location.href = "updateMillRegistration.obj?id="
						+ registrationId;
			}
			// If user clicks "Cancel" (false), do nothing
		}
	</script>

</body>

</html>