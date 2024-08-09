<%@ page import="java.util.Date" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@page import="org.apache.poi.util.SystemOutLogger"%>

<%@page import="com.jci.model.BidCreation"%>
<%@page import="com.jci.model.SubmissionOfQuoteModel"%>

<%@page import="java.util.HashMap"%>
<%@page import="java.util.List"%>
<%@page import="java.io.File"%>
<%@page import="com.jci.model.RoleMasterModel"%>
<%@page import="com.jci.model.ZoneModel"%>
<%@page isELIgnored="false"%>
<%@page import="com.jci.common.Encry"%>

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
    <link href="./assets/vendors/DataTables/datatables.min.css" rel="stylesheet" />
    <!-- THEME STYLES-->
    <link href="assets/css/main.min.css" rel="stylesheet" />
    
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
     

    <!-- PAGE LEVEL STYLES-->
    <style>
.scrollmenu {

  overflow: auto;
  white-space: nowrap;
}

.scrollmenu a {
  display: inline-block;
  color: white;
  text-align: center;
  padding: 14px;
  text-decoration: none;
}
</style>

</head>

<body class="fixed-navbar">
    <div class="page-wrapper">
        <!-- START HEADER-->
       <%--   <%@ include file="header.jsp"%> --%>
         
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
    <%--   <%@ include file="sidebar.jsp"%>  --%>
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
								 	response.sendRedirect(redirectURL);
								 }
								 
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
                <li><a href="verifyMillClaim.obj"><i class="sidebar-item-icon fa fa-th-large"></i> <span class="nav-label">Mill Claim Settlement</span></a></li>
                  
                 <li><a href="viewlistofbid.obj"><i class="sidebar-item-icon fa fa-th-large"></i> <span class="nav-label">List of BID</span></a></li>
                 <li><a href="viewsubmissionOfQuotedel.obj"><i class="sidebar-item-icon fa fa-th-large"></i> <span class="nav-label">List of BID Submitted</span></a></li>
                </ul>
            </div>
        </nav>
    </c:otherwise> 
</c:choose>
        <!-- END SIDEBAR-->
        <div class="content-wrapper">
            <!-- START PAGE CONTENT-->
            	<div class="page-heading">
				<h1 class="page-title">View List of Bid submitted</h1>

			</div>

			<%
			List<SubmissionOfQuoteModel> genrationlist = (List<SubmissionOfQuoteModel>)request.getAttribute("submissionOfQuoteModel");
		   
			%>
        <div class="page-content fade-in-up">
            <div class="ibox">
            <span id="flashMessage">${msg}</span>
                <div class="ibox-body">
                    <div class="scrollmenu">
                        <table class="table table-striped table-bordered table-hover tableFixHead" id="example-table">
                            <thead>
                                <tr>
                                    <th>Sl.No</th>
                                    <th>Bid Reference No</th>
                                    <th>Mill name</th>
                                    <th>Lot Identification</th>
                                    <th>sell_value</th>
                                 <!--    <th>Reserved_sell_price</th> -->
                                    <th>Resgion</th>
                                    <th>CropYear</th>
                                    <th>Grade1</th>
                                    <th>Grade2</th>
                                    <th>Grade3</th>
                                    <th>Grade4</th>
                                    <th>Grade5</th>
                                    <th>Grade6</th>
                                    <th>Grade7</th>
                                    <th>Grade8</th>
                                    <th>Total</th>
                                    <th>Security Deposit Amount</th>
                                </tr>
                            </thead>
                            <tbody>
                                <% int i = 1;
                                   for (SubmissionOfQuoteModel submissionOfQuoteModel : genrationlist) {
                                	     String keyid=submissionOfQuoteModel.getKeyId();
                                	     String decryptedString=submissionOfQuoteModel.getSell_value() ;
                                	   
                                	   final String sellvalue = Encry.decrypt(decryptedString, keyid);
                                       if (i <= 200) { %>
                                           <tr>
                                               <td><%= i %></td>
                                               <td><%= submissionOfQuoteModel.getBid_Reference_No() %></td>
                                               <td><%= submissionOfQuoteModel.getMill_name() %></td>
                                               <td><%= submissionOfQuoteModel.getLot_Identification() %></td>
                                           <%--     <td><%= submissionOfQuoteModel.getSell_value() %></td> --%>
                                            <td><%= sellvalue%></td>
                                              <%--  <td><%= submissionOfQuoteModel.getReserved_sell_price() %></td> --%>
                                               <td><%= submissionOfQuoteModel.getRegion() %></td>
                                               <td><%= submissionOfQuoteModel.getCropYear() %></td>
                                               <td><%= submissionOfQuoteModel.getGrade1() %></td>
                                               <td><%= submissionOfQuoteModel.getGrade2() %></td>
                                               <td><%= submissionOfQuoteModel.getGrade3() %></td>
                                               <td><%= submissionOfQuoteModel.getGrade4() %></td>
                                               <td><%= submissionOfQuoteModel.getGrade5()%></td>
                                               <td><%= submissionOfQuoteModel.getGrade6() %></td>
                                               <td><%= submissionOfQuoteModel.getGrade7() %></td>
                                               <td><%= submissionOfQuoteModel.getGrade8() %></td>
                                               <td><%= submissionOfQuoteModel.getTotalqty()%></td>
                                               
                                               <td><%= submissionOfQuoteModel.getSecurityDepositammount() %></td>
                                             
                                       
                                               
                                           </tr>
                                           <% i++;
                                       }
                                   } %>
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
    $(document).ready(function() {
        setTimeout(function() {
            $('#flashMessage').fadeOut('slow');
        }, 3000);
    });
</script>
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
    	<script>
    $(document).ready(function() {
        setTimeout(function() {
            $('#flashMessage').fadeOut('slow');
        }, 3000);
    });
</script>

</body>

</html>


























