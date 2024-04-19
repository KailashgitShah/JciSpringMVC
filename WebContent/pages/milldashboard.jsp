<%-- <!DOCTYPE html>
<html lang="en">
<%@page import="com.jci.model.UserRegistrationModel"%>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width initial-scale=1.0">
    <title>JCI</title>
    <!-- GLOBAL MAINLY STYLES-->
    <link href="./assets/vendors/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet" />
    <link href="./assets/vendors/font-awesome/css/font-awesome.min.css" rel="stylesheet" />
    <link href="./assets/vendors/themify-icons/css/themify-icons.css" rel="stylesheet" />
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-bO5pIFiiOq9ATKxIep9tiCxN7D5h/W/g5lZx3H+6EE1X1uUq1hYFF4XfcMufj+Il" crossorigin="anonymous"></script>
    <!-- PLUGINS STYLES-->
    <link href="./assets/vendors/jvectormap/jquery-jvectormap-2.0.3.css" rel="stylesheet" />
    <!-- THEME STYLES-->
    <link href="assets/css/main.min.css" rel="stylesheet" />
   
    <!-- PAGE LEVEL STYLES-->
</head>

<body class="fixed-navbar">
    <div class="page-wrapper">
        <!-- START HEADER-->
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
                    <li> <a class="dropdown-item" href="millLogin.obj"><i class="fa fa-power-off"></i>Logout</a></li>
                   
                </ul>
                <!-- END TOP-RIGHT TOOLBAR-->
            </div>
            <div>
           
        </header>
        <!-- END HEADER-->
        
        <!-- START SIDEBAR-->
    
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
 /* String userpass = (String) request.getSession().getAttribute("userpass");
 String Email = (String) request.getSession().getAttribute("usrname");
 out.println(Email);
	String useremail = (String) request.getSession().getAttribute("useremail");
 if (Email == null) {
 	//String redirectURL = "http://49.50.79.121:8080/jcicms/index.obj";
 	String redirectURL = "http://localhost:8080/jciadmin/index.obj";
 	response.sendRedirect(redirectURL); }*/

	String useremail = (String) request.getSession().getAttribute("useremail");
 	 out.println(useremail);
 %>
	</span>			
</div>
				</div>
    
    <div id="sidebar-collapse" class="sidebarleft">
    
    <ul class="side-menu metismenu">
			<li><a href="milldash.obj"><i
					class="sidebar-item-icon fa fa-th-large"></i> <span
					class="nav-label">Dashboard</span> </a></li>
					</ul>
    
        <ul class="side-menu metismenu">
            <li><a href="viewmillAcc.obj"><i class="sidebar-item-icon fa fa-th-large"></i> <span class="nav-label">Mill Acceptence list</span></a></li>
        </ul>
    </div>
</nav>



        <div class="content-wrapper">
            <!-- START PAGE CONTENT-->
            
            <div class="page-content fade-in-up">
                
                <div class="banner-page">
                   <!--  <h1>Mill Dashboard</h1> -->
                    <div class="banner-image">
                        <img src="assets/img/banner.png">
                    </div><!-- banner-image -->
                </div><!-- banner-page -->
                
                    <div class="farmer-box">
                        <div class="famers-content">
                             <ul>
                                <li>
                                    <a href="#">
                                        <span><img src="assets/img/farm-icon.png"></span>
                                        <p>Farmer's Registration</p>
                                    </a>
                                </li>
                                <li>
                                    <a href="#">
                                        <span><img src="assets/img/farm-icon2.png"></span>
                                        <p>Raw Jute Procurement& Payment</p>
                                    </a>
                                </li>

                                <li class="">
                                    <a href="#">
                                        <span><img src="assets/img/farm-icon8.png"></span>
                                        <p>Progress of Assortment</p>
                                    </a>
                                </li>

                                <li>
                                    <a href="#">
                                        <span><img src="assets/img/farm-icon3.png"></span>
                                        <p>BIN Performance Calculation</p>
                                    </a>
                                </li>
                                <li>
                                    <a href="#">
                                        <span><img src="assets/img/farm-icon4.png"></span>
                                        <p>Market Arrival</p>
                                    </a>
                                </li>
                                <li>
                                    <a href="#">
                                        <span><img src="assets/img/farm-icon5.png"></span>
                                        <p>Sale of Raw Jute</p>
                                    </a>
                                </li>
                                <li>
                                    <a href="#">
                                        <span><img src="assets/img/farm-icon6.png"></span>
                                       <p>Despatch Instruction</p>
                                    </a>
                                </li>
                                <li>
                                    <a href="#">
                                        <span><img src="assets/img/farm-icon7.png"></span>
                                        <p>Despatch of Raw Jute</p>
                                    </a>
                                </li>
                            </ul>
                        </div><!-- famers-content -->
                    </div><!-- farmer-box -->
       
                
                 <style>
                    .visitors-table tbody tr td:last-child {
                        display: flex;
                        align-items: center;
                    }

                    .visitors-table .progress {
                        flex: 1;
                    }

                    .visitors-table .progress-parcent {
                        text-align: right;
                        margin-left: 10px;
                    }
                </style>
           <!--      <style>
    .banner-image img {
        height: 1000px; /* Adjust the height as per your requirement */
        /* You can also use other CSS properties like max-height or min-height */
    }
</style> -->
                 
            </div>
            <!-- END PAGE CONTENT-->
            <footer class="page-footer">
                <div class="font-13">2022 © <b>JCI CMS</b> - All rights reserved.</div>
               
                <div class="to-top"><i class="fa fa-angle-double-up"></i></div>
            </footer>
        </div>
    </div>
    <!-- BEGIN THEME CONFIG PANEL-->
     
    <!-- END THEME CONFIG PANEL-->
    <!-- BEGIN PAGA BACKDROPS-->
    <div class="sidenav-backdrop backdrop"></div>
    <div class="preloader-backdrop">
        <div class="page-preloader">Loading</div>
    </div>
    <!-- END PAGA BACKDROPS-->
    <!-- CORE PLUGINS-->
    <script src="./assets/vendors/jquery/dist/jquery.min.js" type="text/javascript"></script>
    <script src="./assets/vendors/popper.js/dist/umd/popper.min.js" type="text/javascript"></script>
    <script src="./assets/vendors/bootstrap/dist/js/bootstrap.min.js" type="text/javascript"></script>
    <script src="./assets/vendors/metisMenu/dist/metisMenu.min.js" type="text/javascript"></script>
    <script src="./assets/vendors/jquery-slimscroll/jquery.slimscroll.min.js" type="text/javascript"></script>
    <!-- PAGE LEVEL PLUGINS-->
    <script src="./assets/vendors/chart.js/dist/Chart.min.js" type="text/javascript"></script>
    <script src="./assets/vendors/jvectormap/jquery-jvectormap-2.0.3.min.js" type="text/javascript"></script>
    <script src="./assets/vendors/jvectormap/jquery-jvectormap-world-mill-en.js" type="text/javascript"></script>
    <script src="./assets/vendors/jvectormap/jquery-jvectormap-us-aea-en.js" type="text/javascript"></script>
    <!-- CORE SCRIPTS-->
    <script src="assets/js/app.min.js" type="text/javascript"></script>
    <!-- PAGE LEVEL SCRIPTS-->
    <script src="./assets/js/scripts/dashboard_1_demo.js" type="text/javascript"></script>
</body>

</html>  
                
                
 --%>