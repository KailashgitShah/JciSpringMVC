<%@page import="com.jci.model.PaymentInstrumentModel"%>
<%@page import="com.jci.model.FinancialConcurenceModel"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.List"%>
<%@page import="java.io.File"%>
<%@page import="com.jci.model.RoleMasterModel"%>
<%@page import="com.jci.model.ZoneModel"%>
<%@page isELIgnored="false"%>

<%@page import="com.jci.model.PaymentInstrumentModel"%>

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
				<h1 class="page-title">View Financial Concurence</h1>

			</div>

			<%
			List<FinancialConcurenceModel> allUserRegistration = (List<FinancialConcurenceModel>) request.getAttribute("financialConcurenceModel");
			
			%>
			
			<div class="page-content fade-in-up">
				<div class="ibox">
					<span id="flashMessage">${msg}</span>
					<div class="ibox-body">
						<div class="scrollmenu">
							<table
								class="table table-striped table-bordered table-hover tableFixHead"
								id="example-table" cellspacing="0" width="100%">


								<thead>
									<tr>
										<th>Sl.No</th>
										<th>Contract no</th>
										<th>FC_Issue_Date </th>
										<th>FC_Ref_No</th>
										<th>Contracted_Qty</th>
										<th>QtyAllowed</th>
										<th>Carrying_Cost_Charged</th>
										<th>Created_date</th>
										<th>Remarks</th>
										
									

									</tr>
								</thead>
								<tbody>
									<%
									int i = 1;
									for (FinancialConcurenceModel financialConcurenceModel : allUserRegistration) {

										if (i <= 200) {
									%>
									<tr>
										<td><%=i%></td>
										<td><%=financialConcurenceModel.getFullcontractno()%></td>
										<td><%=financialConcurenceModel.getFC_Issue_Date()%></td>
										<td><%=financialConcurenceModel.getFC_Ref_No()%></td>
										<td><%=financialConcurenceModel.getContracted_Qty()%></td>
										<td><%=financialConcurenceModel.getQtyAllowed()%></td>
										<td><%=financialConcurenceModel.getCarrying_Cost_Charged()%></td>
										<td><%=financialConcurenceModel.getCreated_date()%></td>
										<td><%=financialConcurenceModel.getRemarks()%></td>
										



									


										<%-- <td><a
											href="editPaymentInstrument.obj?id=<%=financialConcurenceModel.getFc_id()%>">
												<button class="btn btn-primary btn-sm" type="button">Issue FC / Edit</button>
										</a></td>

										<td><a
											href="bnaDeletePay.obj?id=<%=financialConcurenceModel.getFc_id()%>"
											class="btn btn-danger btn-sm btn-block"
											onclick="return confirm('Are you sure you want to delete this record')">Reject</a></td>


									</tr> --%>
									<%
									}
									i++;
									}
									%>
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
	
		<script>
    $(document).ready(function(){
      
        setTimeout(function(){
            $('#flashMessage').fadeOut('slow');
        }, 3000); ded
    });
</script>
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