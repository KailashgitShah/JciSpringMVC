<!DOCTYPE html>
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
       <!-- START HEADER-->
		<%@ include file="header.jsp"%>
		<!-- END HEADER-->
        <!-- END HEADER-->
        
        <!-- START SIDEBAR-->
         <%@ include file="sidebar.jsp"%>
        <!-- END SIDEBAR-->
        
        <div class="content-wrapper">
            <!-- START PAGE CONTENT-->
            
            <div class="page-content fade-in-up">
                
                <div class="banner-page">
                    <h1>Dashboard</h1>
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
                                       <p>Dispatch Instruction</p>
                                    </a>
                                </li>
                                <li>
                                    <a href="#">
                                        <span><img src="assets/img/farm-icon7.png"></span>
                                        <p>Dispatch of Raw Jute</p>
                                    </a>
                                </li>
                            </ul>
                        </div><!-- famers-content -->
                    </div><!-- farmer-box -->
                    <script>
                        var header = document.getElementById("myDIV");
                        var btns = header.getElementsByClassName("btn");
                        for (var i = 0; i < btns.length; i++) {
                          btns[i].addEventListener("click", function() {
                          var current = document.getElementsByClassName("active");
                          current[0].className = current[0].className.replace(" active", "");
                          this.className += " active";
                          });
                        }
                    </script>
                
                
                
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