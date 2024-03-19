<%@page import="java.util.HashMap"%>
<%@page import="java.util.List"%>
<%@page import="java.io.File"%>

<%@page import="com.jci.model.UserRegistrationModel"%>
<%@page import="java.text.SimpleDateFormat"%>




<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width initial-scale=1.0">
     <title>JCI | CMS</title>
    <!-- GLOBAL MAINLY STYLES-->
    <link href="./assets/vendors/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet" />
    <link href="./assets/vendors/font-awesome/css/font-awesome.min.css" rel="stylesheet" />
    <link href="./assets/vendors/themify-icons/css/themify-icons.css" rel="stylesheet" />
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    <!-- PLUGINS STYLES-->
    <link href="./assets/vendors/DataTables/datatables.min.css" rel="stylesheet" />
    <!-- THEME STYLES-->
    <link href="assets/css/main.min.css" rel="stylesheet" />
    <!-- PAGE LEVEL STYLES-->
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
                <h1 class="page-title">User Profile</h1>
                 
            </div>
				
				<%
					UserRegistrationModel userProfile = (UserRegistrationModel)request.getAttribute("profile");
				String roname = userProfile.getRoname();
				String zone = userProfile.getZonename();
				String dpc = userProfile.getCentername();
					if(roname == null)
						roname = "NA";
					if(zone == null)
						zone = "NA";
					if(dpc == null)
						dpc = "NA";

					
				%>
			            <div class="page-content fade-in-up">
                <div class="row">
                    <div class="col-md-11">
                        <div class="ibox">
                            <span>${msg}</span>
                            <div class="ibox-body">
                                <form action="updateuserProfile.obj" method="POST">
                                    <div class="row">
                                        <!-- <div class="col-sm-4 form-group">
                                            <label>Report Date</label>
                                            <input class="form-control" type="date" name="datereport" placeholder="Report Date" required>
                                        </div> -->
                          <div class="col-sm-4 form-group">
                                            <label>User Name</label> 
											<input class="form-control" name="username" id="username" type="text" placeholder="User Name"value="<%=userProfile.getUsername()%>" readonly>
                                        </div>
                                        <div class="col-sm-4 form-group">
                                        <label>Employee Id</label> 
										<input class="form-control" name="employeeid" placeholder="Employee Id" id="employeeid" value="<%=userProfile.getEmployeeid()%>" readonly>
											
										</div>
													<div class="col-sm-4 form-group">
                                            <label>Email</label>
                                            <input class="form-control" id="emailAddress"  name="emailAddress"  placeholder="Bin Email" value="<%=userProfile.getEmail()%>" readonly>
                                          
                                        </div>
										</div>
										<div class="row">
							
                               
                            
                                       
										
                                        <div class="col-sm-4 form-group">
                                             <label>Employee Name</label>
                                        <input class="form-control"  name="employeename" type="text" placeholder="Employee Name" id="employeename" value="<%=userProfile.getEmployeename()%>" readonly>
                                        </div>
                                       <div class="col-sm-4 form-group">
											<label>Zone Name</label>
                                        	<input class="form-control"  name="zone" id="zone" placeholder="Rope balance" value = "<%=zone%>" readonly>
										</div>
													<div class="col-sm-4 form-group">
											<label>Region Name</label>
                                        	<input class="form-control" name="region" id="region" placeholder="Zone Name" value="<%=roname%>" readonly>
										</div>
                                    
										</div>
										   <div class="row">
							
										 <div class="col-sm-4 form-group">
											<label>Center Name</label>
                                        	<input class="form-control"  name="centerordpc" id="centerordpc" placeholder="Rope made"  value="<%=dpc%>" readonly>
										</div>
											<div class="col-sm-4 form-group">
											<label>Mobile Number</label>
                                        	<input class="form-control"  id="mobile" name="mobile" placeholder="Mobile Number" value = "<%=userProfile.getMobileno()%>" readonly>
										</div>
										
                                    </div>                                    
                                    <div class="form-group col-sm-12">
                                     <a href="editprofile.obj"><button class="btn btn-default" type="button">Edit</button></a>
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
    <script src="./assets/vendors/jquery/dist/jquery.min.js" type="text/javascript"></script>
    <script src="./assets/vendors/popper.js/dist/umd/popper.min.js" type="text/javascript"></script>
    <script src="./assets/vendors/bootstrap/dist/js/bootstrap.min.js" type="text/javascript"></script>
    <script src="./assets/vendors/metisMenu/dist/metisMenu.min.js" type="text/javascript"></script>
    <script src="./assets/vendors/jquery-slimscroll/jquery.slimscroll.min.js" type="text/javascript"></script>
    <!-- PAGE LEVEL PLUGINS-->
    <script src="./assets/vendors/DataTables/datatables.min.js" type="text/javascript"></script>
    <!-- CORE SCRIPTS-->
    <script src="assets/js/app.min.js" type="text/javascript"></script>
    <!-- PAGE LEVEL SCRIPTS-->
    <script type="text/javascript">
        $(function() {
            $('#example-table').DataTable({
                pageLength: 10,
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
</body>

</html>