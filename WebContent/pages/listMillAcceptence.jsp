<%@page import="com.jci.model.JciDIHoModel"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.List"%>
<%@page import="java.io.File"%>
<%@page import="com.jci.model.RoleMasterModel"%>
<%@page import="com.jci.model.ZoneModel"%>

<%@page import="com.jci.model.UserRegistrationModel"%>

<%@page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


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
<style>
input[type="file"] {
	color: transparent;
}

/* input[type="file"]::before {
  content: "Select File";
  color: #333; /* Set your desired text color */
}
* /

 input[type="file"]:hover::before {
	color: #555; /* Set your desired text color on hover */
}
</style>
<script src="https://code.jquery.com/jquery-3.6.4.min.js"></script>
<script>
	function f() {

		window.location.reload();

	}
</script>



</head>

<body class="fixed-navbar">
	<div class="page-wrapper">
		<!-- START HEADER-->
		<c:choose>
    <c:when test="${not empty sessionScope.roleId}">
		<%@ include file="header.jsp"%>
		</c:when>
		<c:otherwise>
		 <header class="header">
            <div class="page-brand">
                <a class="link" href="index.html">
                    <span class="brand">Admin
                        <span class="brand-tip">CAST</span>
                    </span>
                    <span class="brand-mini">AC</span>
                </a>
            </div>
               
            
            <div class="flexbox flex-1">
                <!-- START TOP-LEFT TOOLBAR-->
                <ul class="nav navbar-toolbar">
                    <li>
                        <a class="nav-link sidebar-toggler js-sidebar-toggler"><i class="ti-menu"></i></a>
                    </li>
                </ul>
                <!-- END TOP-LEFT TOOLBAR-->
                <!-- START TOP-RIGHT TOOLBAR-->
                 <ul class="nav navbar-toolbar ">
               
                 <!--    <li class="bell"><i class="fa fa-bell-o"></i>
                        <span>10</span>
                    </li> -->
                    <li> <a class="dropdown-item" href="index.obj"><i class="fa fa-power-off"></i>Logout</a></li>
                   
                </ul>
                <!-- END TOP-RIGHT TOOLBAR-->
            </div>
            <div>
           
        </header>
		
		</c:otherwise>
		</c:choose>
		<!-- END HEADER-->
		<!-- START SIDEBAR-->
		

	
<c:choose>
    <c:when test="${not empty sessionScope.roleId}">
        <!-- Sidebar 1 -->
        <%@ include file="sidebar.jsp"%> 
    </c:when>
  <c:otherwise>
        <!-- Sidebar 2 -->
        <style>
            body {
                zoom: 85%;
            }

            .side-menu li a {
                color: #fff;
            }

            .sidebarleft {
                /* Add your styles for the sidebar container */
            }

            /* Add more styles as needed */
        </style>

        <nav class="page-sidebar" id="sidebar" style="height: 90%; overflow-y: auto;">
            <div class="page-brand">
                <a class="link" href="#"> 
                    <span class="brand"> 
                        <span class="brand-tip"> 
                            <img src="assets/img/logo5.png">
                        </span>
                    </span> 
                    <span class="brand-mini"> 
                        <img src="assets/img/logo5.png">
                    </span>
                </a>
            </div>
            
             <div class="admin-info">

				<div class="font-strong">
					Welcome <br> <span style="color: #ffc107;"> <%
	String useremail = (String) request.getSession().getAttribute("useremail");
 	if (useremail == null) {
 	 	//String redirectURL = "http://49.50.79.121:8080/jcicms/index.obj";
 	 	String redirectURL = "http://localhost:8080/jciadmin/index.obj";
 	 	response.sendRedirect(redirectURL); }
 	 out.println(useremail);
 %>
	</span>			
</div>
				</div>
            
            <div id="sidebar-collapse" class="sidebarleft">
               <!--  <ul class="side-menu metismenu">
                    <li><a href="milldash.obj"><i class="sidebar-item-icon fa fa-th-large"></i> <span class="nav-label">Dashboard</span></a></li>
                </ul> -->

                <ul class="side-menu metismenu">
                    <li><a href="viewmillAcc.obj"><i class="sidebar-item-icon fa fa-th-large"></i> <span class="nav-label">Mill Acceptance list</span></a></li>
                    
                </ul>
            </div>
        </nav>
    </c:otherwise> 
</c:choose>
	
		<!-- END SIDEBAR-->
		<div class="content-wrapper">
			<!-- START PAGE CONTENT-->
			<div class="page-heading">
				<h1 class="page-title">Mill Acceptance List</h1>
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
									<th>Sl.NO</th>
                                        <th>Mill name</th>
										<th>Contract Identification No.</th>
										<th>Crop Year</th>
										<th>Contract Quantity(Qtls)</th>				  
									    <th>Contract Date</th>
										<th>Payment Due Date</th>
										<th>Fibre Value</th>
										<th>Contract Value (In Case of Non Lc)</th>
										<th>Contract Value (In Case of LC)</th>								
										<th>View Contract Document</th>
										<th>Action</th>										
									</tr>
								    </thead>
								    <tbody>
                                   <%int i=1; %>
									<c:forEach items="${AllList}" var="item">
										<tr>
										<td><%=i%></td>
										    <td>${item.getMill_name()}</td>
										    <td>${item. getContract_identification_no()}</td>
											<td>${item.getCropYear()}</td> 
										     <td>${item.getMill_qty()}</td>
											<td>${item.getContract_date()}</td>
											 <td>${item. getPayment_duedate()}</td>
											<td>${item.getJute_value()}</td> 
											 <td>${item.getContract_value()}</td> 
											<td>${item.getContractValueLc()}</td>
											
										
 										 <td>  <a href="downloadSupportingDocumententMillAccept.obj?filename=${item. getContract_acceptance_doc()}" class="btn btn-primary" target="_blank"> View Document</a></button></td>	
 
                                         <td><button class="btn btn-success" disabled>Recieved</button></td>

                                              <!-- this will work in free sales and commercial  -->
											<%-- <form action="saveMillAcceptenceFile.obj" method="POST"
												enctype="multipart/form-data">
											
												<input type="hidden" value="${item.contract_id}"
													name="contract_id" >
												<td>
											 <c:choose>
														<c:when test="${item.contract_acceptance_flag eq '0'}">
															<button class="btn btn-danger" style="width: 60px"
																type="submit">Accept</button>
														</c:when>
														<c:otherwise>
															<button class="btn btn-success" disabled>Accepted</button>
														</c:otherwise>
													</c:choose> 
												
													</td> 
											</form> --%>
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

