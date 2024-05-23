<!DOCTYPE html>
<html lang="en">
<%@ page import="javax.servlet.http.HttpServletRequest" %>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width initial-scale=1.0">
    <title>JCI | CMS</title>
    <!-- GLOBAL MAINLY STYLES-->
    <link href="./assets/vendors/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet" />
    <link href="./assets/vendors/font-awesome/css/font-awesome.min.css" rel="stylesheet" />
    <link href="./assets/vendors/themify-icons/css/themify-icons.css" rel="stylesheet" />
    <!-- PLUGINS STYLES-->
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
                <h1 class="page-title">Add Farmer Details</h1>
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
                                <form action="saveFarmerMid.obj" method="POST">
                                    <div class="row">
                                        <div class="col-sm-4 form-group">
                                            <label>First Name</label>
                                            <input class="form-control" type="text" name="firstname" placeholder="First Name" required>
                                        </div>
                                        <div class="col-sm-4 form-group">
                                            <label>Last Name</label>
                                            <input class="form-control" type="text" name="lastname" placeholder="First Name">
                                        </div>
                                        <div class="col-sm-4 form-group">
											<label>Email</label> <input class="form-control" type="text" name="useremail" placeholder="Email address" required>
										</div>
                                    </div>
                                    
                                    <div class="row">
                                        <div class="col-sm-4 form-group">
                                             <label>Mobile Number</label>
                                        	 <input class="form-control" name="mobileno" type="number" placeholder="mobileno" required>
                                        </div>
                                       
										<div class="col-sm-4 form-group">
                                            <!-- <label>Role</label> 
											<input class="form-control" name="roleid" type="text" placeholder="Role"> -->
											<label>Choose Role</label>
											<select name="roleid" id="roleid" class="form-control">
											  <option value="1">Admin</option>
											  <option value="2">Farmer</option>
											</select>
                                        </div>
                                        <div class="col-sm-4 form-group">
                                        <!-- <label>Organisation</label>
                                        <input class="form-control" name="orgid" type="text" placeholder="Organisation" required> -->
                                        
                                        <label>Choose Organisation</label>
											<select name="orgid" id="orgid" class="form-control">
											  <option value="1">Orgnisation 1</option>
											  <option value="2">Organisation 2</option>
											</select>
                                        
                                        </div>
                                    </div>

                                     <div class="row">
                                        <div class="col-sm-4 form-group">
											<label>City</label>
                                        	<input class="form-control" name="city" type="text" placeholder="City" required>
										</div>
										<div class="col-sm-4 form-group">
                                             <label>State</label>
                                        	<input class="form-control" name="state" type="text" placeholder="State" required>
                                        </div>
                                        <div class="col-sm-4 form-group">
                                            <label>Major Work</label>
                                       		<input class="form-control" name="majorwork" type="text" placeholder="Major Work">
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <button class="btn btn-default" type="submit">Submit</button>
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
    <script src="./assets/vendors/jquery/dist/jquery.min.js" type="text/javascript"></script>
    <script src="./assets/vendors/popper.js/dist/umd/popper.min.js" type="text/javascript"></script>
    <script src="./assets/vendors/bootstrap/dist/js/bootstrap.min.js" type="text/javascript"></script>
    <script src="./assets/vendors/metisMenu/dist/metisMenu.min.js" type="text/javascript"></script>
    <script src="./assets/vendors/jquery-slimscroll/jquery.slimscroll.min.js" type="text/javascript"></script>
    <!-- PAGE LEVEL PLUGINS-->
    <!-- CORE SCRIPTS-->
    <script src="assets/js/app.min.js" type="text/javascript"></script>
</body>
</html>