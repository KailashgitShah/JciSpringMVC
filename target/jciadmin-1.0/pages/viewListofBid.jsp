<%@ page import="java.util.Date" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@page import="org.apache.poi.util.SystemOutLogger"%>



<%@page import="java.util.HashMap"%>
<%@page import="java.util.List"%>
<%@page import="java.io.File"%>
<%@page import="com.jci.model.RoleMasterModel"%>
<%@page import="com.jci.model.ZoneModel"%>
<%@page isELIgnored="false"%>
<%@ page import="java.time.LocalDateTime" %>
<%@ page import="java.time.Duration" %>
<%@ page import="java.time.format.DateTimeFormatter" %>

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
.disabled-link {
    pointer-events: none; /* Disable click events */
    opacity: 0.5; /* Make it appear disabled */
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
				<h1 class="page-title">View List of Bid</h1>

			</div>

			<%
			List<Object[]> allUserRegistration = (List<Object[]>)request.getAttribute("submissionOfQuoteModel");
	
			    

		%>
                  <div class="page-content fade-in-up">
                <div class="ibox">
                    <div class="ibox-head">
                    <span>${msg}</span>
                        <div class="ibox-title"></div>
                    </div>
                    <div class="ibox-body">
                      <div class="scrollmenu">
                        <table class="table table-striped table-bordered table-hover" id="example-table" cellspacing="0" width="100%">
                               <thead>
									<tr>
										<th>Sl.No</th>
										
										<th>bid_reference_no</th>
										<th>bid_date </th>
										<th>bid_closing_date </th>
										<th>Quantity(Qntls)</th>
										<th>Remaining time</th>
										
									
									
									
										<th></th>
									</tr>
								</thead>
                           <tbody>
									<%
									int i = 1;
									SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
									
									
									for (Object []  row : allUserRegistration) {
										 
										 LocalDateTime currentDate = LocalDateTime.now();
										    
										
										    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
										 
										    String currentDateStr = currentDate.format(formatter);
									
								
										    
										    DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");

										    // Define the desired date-time format for display
										    DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
										    
										    
										  
										   String bidClosingDateStr = (String) row[2];
										    String bidOpeningDateStr =  (String) row[1];
										    
										    DateTimeFormatter inputFormatter3 = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
										    DateTimeFormatter outputFormatter2 = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

										    // Example data
										    String bidOpeningDateStrfortime = (String) row[2];

										    // Parse the bid opening date using the input formatter
										    LocalDateTime bidClosingDate2 = LocalDateTime.parse(bidOpeningDateStrfortime, inputFormatter3);

										    // Format the bid closing date to the desired format
										  String bidClosingDateFormattedfortime = bidClosingDate2.format(outputFormatter2);
										    
										    

										    // Parse the bid closing date using the specified format
										  LocalDateTime bidClosingDate = LocalDateTime.parse(bidClosingDateStr, inputFormatter);
                                          LocalDateTime bidOpeningDate = LocalDateTime.parse(bidOpeningDateStr, inputFormatter);

                                          String bidClosingDateFormatted = bidClosingDate.format(outputFormatter);
                                          
                                         
                                          String bidOpeningDateFormatted = bidOpeningDate.format(outputFormatter);

										  
										  LocalDateTime bidClosingDate1 = LocalDateTime.parse(bidClosingDateStr, formatter);
										    
										    // Calculate the difference
										    Duration duration = Duration.between(currentDate,bidClosingDate1);
										    if (duration.isNegative()) {
										        duration = Duration.ZERO; // Set duration to zero if it's negative
										    }
										    // Convert duration to days, hours, and minutes
										    long days = duration.toDays();
										    long hours = duration.toHours() % 24;
										    long minutes = duration.toMinutes() % 60;

                                            long seconds = duration.getSeconds() % 60;
										    boolean isDisabled = duration.isZero();
										    
										if (i <= 200) {
											
									%>
									<tr class="bid-row" data-bid-closing-date="<%= bidClosingDateFormattedfortime %>">
										<td><%=i%></td>
									
									
											<td><%= row[0] %></td>
										   <td><%= row[1] %></td>
										 
										 	<td><%= row[2] %></td>
										 	<td><%= row[6] %></td>
										 
										  <td class ="time"><%= days + " days   " + hours + ":" + minutes + ":"+seconds+"" %></td>
										
									 <%-- 	
                                      <td>
									    <a href="EntrySubmissionofQuote.obj?id=<%=row[0]%>&contno=<%=row[4]%>&basis=<%=row[5]%>
									    &openingdate=<%=row[1]%>&closingdate=<%=row[2]%>&lotsize=<%=row[3]%>&securitydeposit=<%=row[6]%>">
									        <button class="btn btn-primary custom-button" type="button" style="display: inline-block; width: 100px; height: 15px; border-radius: 5px;">Details</button>
									    </a>
									</td>    --%>
									
						    <td>
                <% if (isDisabled) { %>
                    <a href="#" class="disabled-link">
                        <button class="btn btn-primary custom-button" type="button" style="display: inline-block; width: 100px; height: 15px; border-radius: 5px;" disabled>
                            Details
                        </button>
                    </a>
                <% } else { %>
                    <a href="EntrySubmissionofQuote.obj?id=<%=row[0]%>&contno=<%=row[3]%>&basis=<%=row[4]%>
                    &openingdate=<%=row[1]%>&closingdate=<%=row[2]%>&lotsize=<%=row[6]%>&securitydeposit=<%=row[5]%>">
                        <button class="btn btn-primary custom-button" type="button" style="display: inline-block; width: 100px; height: 15px; border-radius: 5px;">
                            Details
                        </button>
                    </a>
                <% } %>
            </td>

										
						

									</tr>
									<%
										}
									   i++;
										} 
										%>
									
										
									
									
								</tbody>

                        </table>
                        
                      <!--   				<div class="modal fade" id="rejectModal" tabindex="-1"
								role="dialog" aria-labelledby="rejectModalLabel"
								aria-hidden="true">
								<div class="modal-dialog" role="document">
									<div class="modal-content">
										<div class="modal-header">
											<h5 class="modal-title" id="rejectModalLabel">Reject
												Confirmation</h5>
											<button type="button" class="close" data-dismiss="modal"
												aria-label="Close">
												<span aria-hidden="true">&times;</span>
											</button>
										</div>
										<div class="modal-body">
											<p>Are you sure you want to reject this record?</p>
											<label for="remarks">Remarks:</label> <input
												class="form-control" type="text" id="remarks" name="remarks">
										</div>
										<div class="modal-footer">
											<button type="button" class="btn btn-secondary"
												data-dismiss="modal">Close</button>
											<button type="button" class="btn btn-danger"
												 id="rejectModalButton" onclick="rejectRecord()">Yes, Reject</button>

										</div>
									</div>
								</div>
							</div> -->
                        
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
    
   <script>
   document.addEventListener("DOMContentLoaded", function() {
	    function updateCountdown() {
	        document.querySelectorAll(".bid-row").forEach(function(row) {
	        
	            // Get the bid closing date from the data attribute
	            let bidClosingDateStr = row.getAttribute("data-bid-closing-date");
	            let bidClosingDate = new Date(bidClosingDateStr.replace(/-/g, '/'));
	           
	            // Get the current time
	            let now = new Date();
	          
	            // Calculate the remaining time
	            let remainingTime = bidClosingDate - now;
	         
	            // If the duration is negative, set it to zero
	            if (remainingTime < 0) {
	                remainingTime = 0;
	            }

	            // Convert remaining time to days, hours, and minutes
	            let days = Math.floor(remainingTime / (1000 * 60 * 60 * 24));
	           
	            let hours = Math.floor((remainingTime % (1000 * 60 * 60 * 24)) / (1000 * 60 * 60));
	          
	            let minutes = Math.floor((remainingTime % (1000 * 60 * 60)) / (1000 * 60));
	            let seconds = Math.floor((remainingTime % (1000 * 60)) / 1000);
	         
	            // Format the remaining time string
	            let justTime1 = days + " days  " + hours + ":" + minutes + ":"+seconds;
	          
	            // Update the time element
	            let timeElement = row.querySelector(".time");
	            if (timeElement) {
	                timeElement.textContent = justTime1;
	            }

	            // Check if the time is zero and disable the button if needed
	            if (remainingTime === 0) {
	                let button = row.querySelector("button");
	                if (button) {
	                    button.disabled = true;
	                }
	            }
	        });
	    }

	    // Initial call to set the countdown immediately
	    updateCountdown();

	    // Update the countdown every minute
	    setInterval(updateCountdown, 1000); // 60,000 milliseconds = 1 minute
	});

</script>
    
    
 
<!-- <script>
    function openRejectModal(contractNo) {
        $('#rejectModalButton').data('contractNo', contractNo);
        $('#rejectModal').modal('show');
    }

    function closeRejectModal() {
        $('#rejectModal').modal('hide');
    }

    function rejectAndNavigate(contractNo, paymentId) {
        openRejectModal(contractNo)
    
        $('#rejectModalButton').off('click').on('click', function () {
            var remarks = $('#remarks').val().trim();

            if (remarks === "") {
                return;
            }
            $.ajax({
                type: 'POST',
                url: 'saveRemarks.obj',
                data: {
                    "remarks": remarks,
                    "con_no": contractNo,
                    "id": paymentId
                },
                success: function (data) {
                    var responseData = JSON.parse(data);
						 if (responseData.redirect) {
                        window.location.href = responseData.redirect;
                    } else {
                        
                    }
                },
                error: function (error) {
                    console.error('Ajax error:', error);
                }
            });


            closeRejectModal(); 
        });
    }
</script>
 -->    
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


























