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
<!-- THEME STYLES-->
<link href="assets/css/main.min.css" rel="stylesheet" />
<link href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<link href="<%=request.getContextPath() %>/resources/css/styleUserReg.css" rel="stylesheet">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<script type="text/javascript" src='<%=request.getContextPath() %>/resources/js/responsivevoice.js'></script>
<script type="text/javascript" src='<%=request.getContextPath() %>/resources/js/custom.js'></script>
<script type="text/javascript" src='<%=request.getContextPath() %>/resources/js/jquery.mCustomScrollbar.concat.min.js'></script>
<script type="text/javascript" src='<%=request.getContextPath() %>/resources/js/jquery.validate.min.js'></script>
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
                <h1 class="page-title">Rope Making</h1>
            </div>
            <div class="page-content fade-in-up">
                <div class="row">
                    <div class="col-md-11">
                        <div class="ibox">
                            
                            <div class="ibox-body">
                                <form action="saveMarketArrivalMid.obj" method="POST">
                                    <div class="row">
                                        <div class="col-sm-4 form-group">
                                            <label>DPC Name</label>
                                            <input class="form-control" type="text" name="dpcnames" placeholder="Name of DPC" required>
                                        </div>
                                        <div class="col-sm-4 form-group">
                                            <label>Arrival Date</label>
                                            <input class="form-control" type="date" name="datearrival" placeholder="Date of Arrival" required>
                                        </div>
                                        <div class="col-sm-4 form-group">
											<label>Jute Variety</label> 
											<input class="form-control" type="text" name="jutevariety" placeholder="Jute Variety" required>
										</div>
                                    </div>
                                    <div class="row">
                                        <div class="col-sm-4 form-group">
                                             <label>Crop Year</label>
                                        <!-- 	 <input class="form-control" name="cropyr" type="text" placeholder="Crop Year" required> -->
                                        	 <select name="cropyr" id="cropyr"  class="form-control" required>
												<option value="">-Select-</option>
												<option value="2021-2022">2021-2022</option>
												<option value="2022-2023">2022-2023</option>
												<option value="2023-2024">2023-2024</option>
												<option value="2024-2025">2024-2025</option>
												<option value="2025-2026">2025-2026</option>
												<option value="2026-2027">2026-2027</option>
												<option value="2027-2028">2027-2028</option>
												<option value="2028-2029">2028-2029</option>
												<option value="2029-2030">2029-2030</option>
												<option value="2030-2031">2030-2031</option>
											</select>
                                        </div>
										<div class="col-sm-4 form-group">
                                            <label>Arrived Quantity</label> 
											<input class="form-control" name="arrivedqty" type="text" placeholder="Arived Quantity" required>
                                        </div>
                                        <div class="col-sm-4 form-group">
                                             <label>Min Moisture</label>
                                        <input class="form-control" name="mixmois" type="text" placeholder="Minimum Moisture" required>
                                        </div>
                                    </div>
                                    <div class="row">
                                        <div class="col-sm-4 form-group">
											<label>Maximum Moisture</label>
                                        	<input class="form-control" name="maxmois" type="text" placeholder="Maximum Moitsure">
										</div>
										<div class="col-sm-4 form-group">
                                             <label>Estimated Grade Out-turn</label>
                                        	 <input class="form-control" name="esgradeoutturn" type="text" placeholder="Estimated Grade Out-turn" required>
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

</body>
</html>