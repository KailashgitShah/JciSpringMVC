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
                <h1 class="page-title">Commercial Ceiling Price Intimation</h1>
            </div>
            <div class="page-content fade-in-up">
                <div class="row">
                    <div class="col-md-11">
                        <div class="ibox">
                            
                            <div class="ibox-body">
                                <form action="saveCommercialCeilingPriceIntimation.obj" method="POST">
                                    <div class="row">
                                        <div class="col-sm-4 form-group">
                                            <label>DPC Code</label>
                                            <input class="form-control" type="text" name="dpccode" placeholder="DPC Code" required>
                                        </div>
                                        <div class="col-sm-4 form-group">
                                            <label>Date of Entry</label>
                                            <input class="form-control" type="date" name="dateofentry" placeholder="Date of Entry" required>
                                        </div>
                                        <div class="col-sm-4 form-group">
											<label>Date of Effect</label> 
											<input class="form-control" type="date" name="dateofeffect" placeholder="Date of Effect" required>
										</div>
                                    </div>
                                    
                                    <div class="row">
                                        <div class="col-sm-4 form-group">
                                             <label>Jute Variety</label>
                                        	 <input class="form-control" name="jutevariety" type="text" placeholder="Jute Variety" required>
                                        </div>
                                       
										<div class="col-sm-4 form-group">
                                            <label>Ceiling Quantity</label> 
											<input class="form-control" name="ceilingquantity" type="text" placeholder="Ceiling Quantity" required>
                                        </div>
                                        <div class="col-sm-4 form-group">
                                             <label>Jute Grade</label>
                                        <input class="form-control" name="jutegrade" type="text" placeholder="Jute Grade" required>
                                        </div>
                                    </div>

                                     <div class="row">
                                        <div class="col-sm-4 form-group">
											<label>Ceiling Price</label>
                                        	<input class="form-control" name="ceilingprice" type="text" placeholder="Ceiling Price" required>
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