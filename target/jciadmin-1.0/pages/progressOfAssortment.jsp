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
                <h1 class="page-title">Bale Preparation</h1>
            </div>
            <div class="page-content fade-in-up">
                <div class="row">
                    <div class="col-md-11">
                        <div class="ibox">
                            
                            <div class="ibox-body">
                                <form action="saveBalePreparationMid.obj" method="POST">
                                    <div class="row">
                                        <div class="col-sm-4 form-group">
                                            <label>Date of Packing</label>
                                            <input class="form-control" type="date" name=dateofpacking placeholder="Date of Packing" required>
                                        </div>
                                        <div class="col-sm-4 form-group">
                                            <label>Basis</label>
                                            <input class="form-control" type="text" name="basis" placeholder="Basis" required>
                                        </div>
                                        <div class="col-sm-4 form-group">
											<label>Crop Year</label> 
											<input class="form-control" type="text" name="cropyr" placeholder="Crop Year" required>
										</div>
                                    </div>  
                                                                     
                                    <div class="row">
                                        <div class="col-sm-4 form-group">
                                             <label>Place of activity</label>
                                        	 <input class="form-control" name="placeofpacking" type="text" placeholder="Place of Packing" required>
                                        </div>
										<div class="col-sm-4 form-group">
                                            <label>Bin Number</label> 
											<input class="form-control" name="binno" type="text" placeholder="Bin Number" required>
                                        </div>
                                        <div class="col-sm-4 form-group">
                                             <label>Jute Variety</label>
                                        <input class="form-control" name="jutevariety" type="text" placeholder="Jute Variety" required>
                                        </div>
                                    </div>

                                    <div class="row">
                                        <div class="col-sm-4 form-group">
											<label>Jute Grade</label>
                                        	<input class="form-control" name="jutegrade" type="number" placeholder="Jute Grade">
										</div>
										<div class="col-sm-4 form-group">
											<label>Bale Check Slip No.(from)</label>
                                        	<input class="form-control" name="balecheckslipnofrom" type="text" placeholder="Jute Grade">
										</div>
										<div class="col-sm-4 form-group">
											<label>Bale Check Slip No. (to)</label>
                                        	<input class="form-control" name="balecheckslipnoto" type="text" placeholder="Bale Check Slip No.(to)">
										</div>
                                    </div>
                                    <div class="row">
                                        <div class="col-sm-4 form-group">
											<label>No. of Bales	</label>
                                        	<input class="form-control" name="numberofbales" type="text" placeholder="No. of Bales">
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
    <!-- PAGE LEVEL SCRIPTS-->
</body>
</html>