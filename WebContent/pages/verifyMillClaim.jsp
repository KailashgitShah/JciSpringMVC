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
<%
List<Object[]> getSettlementid = (List<Object[]>) request.getAttribute("getSettlementidlist");
%>
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
        .ibox {
    padding: 0 0px;
}
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
                <li><a href="verifyMillClaim.obj"><i class="sidebar-item-icon fa fa-th-large"></i> <span class="nav-label">Mill Claim Settlement</span></a></li>
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
					<div id='errorcontainer'
								style='display: none; text-align: center;'></div>
								<div id='errorcontainer1'
								style='display: none; text-align: center;'></div>
			
			<div class="row">
			<div class="col-sm-4 form-group">
    <label>Contract No.</label> 
    <span class="text-danger">*</span>&nbsp; 
    <span id="contractno" name="contractno" class="text-danger"></span> 
    <select name="Contract" id="Contract" class="form-control textbox" required>
        <option value="" disabled selected>Select</option>
     <% for (Object[] setId : getSettlementid) { %>
            <option value="<%=setId[0]%>" readonly><%=setId[0]%></option>
        <% } %>
    </select>
</div>

													<div class="col-sm-4 form-group">
    <label>Settlement Id</label> 
    <span class="text-danger">*</span>&nbsp; 
    <span id="contractno" name="contractno" class="text-danger"></span> 
    <select name="setId" id="setId" class="form-control textbox" required>
        <option value="" disabled selected>Select</option>
       
    </select>
</div>
					</div>
				<div class="row">
    <div class="col-sm-6 form-group">
        <div id="form3"></div>
    </div>
    
     <div class="col-sm-6 form-group" style="text-align:right ">
        <div id="form5"></div>
    </div>
</div>
	<div class="row">
    
     
     <div class="col-sm-6 form-group">
        <div id="form4"></div>
    </div>
    <div class="col-sm-6 form-group" style="text-align:right">
        <div id="form6"></div>
    </div>
</div>
		
	<div class="row">
    <div class="col-sm-12 form-group">
        <div id="form2"></div>
    </div>
</div>
<div class="row">
    <div class="col-sm-4 form-group">
        <div id="form7"></div>
    </div>
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
	
	<!-- PAGE LEVEL SCRIPTS-->
	<div class="sidenav-backdrop backdrop"></div>

	<!-- END PAGA BACKDROPS-->
	<!-- CORE PLUGINS-->
	
	
	
	<script type="text/javascript">
	$("#setId").on("change", function() {
	    var setId = $(this).val(); // Corrected line
	    alert(setId);
	    $.ajax({
	        url: 'settlementMill.obj',
	        method: 'GET', // Assuming you want to use GET method
	        data: {
	            "setId": setId
	        },
	        success: function(response) {
	            // Parse the JSON response
	            var data = jQuery.parseJSON(response);
	           // alert(data);
	            // Clear the existing content of the form2 element
	            $("#form2").empty();
	            console.log(data);
	            // Create the table structure
	           var contentToDisplay = "<table style='border: 1px solid black; width: 1150px; text-align: center;'>"+
	        	    "<tr>"+
	          "<th style='border: 1px solid black; text-align: center;' rowspan='2'>S. No.</th>"+
	          "<th style='border: 1px solid black; width: 10%; text-align: center;' rowspan='2'>Challan</th>"+
	         " <th style='border: 1px solid black; width: 5%; text-align: center;' rowspan='2'>Bale Mark</th>"+
	          "<th style='border: 1px solid black; width: 10%; text-align: center;' rowspan='2'>Mr No.</th>"+
	          "<th style='border: 1px solid black; width: 10%; text-align: center;' rowspan='2'>Crop Year</th>"+
	         " <th style='border: 1px solid black; width: 10%; text-align: center;' rowspan='2'>Variety/Grade</th>"+
	         " <th style='border: 1px solid black; width: 10%; text-align: center;' rowspan='2'>No. of Bales</th>"+
	          "<th style='border: 1px solid black; width: 10%; text-align: center;' rowspan='2'>Actual Quantity(Qtls)</th>"+
	         " <th style='border: 1px solid black; width: 15%; text-align: center;' colspan='4'>Claim Percentage(%)</th>"+
	         " <th style='border: 1px solid black; width: 15%; text-align: center;' colspan='4'>Settlement Percentage(%)</th>"+
	          "<th style='border: 1px solid black; width: 5%; text-align: center;' rowspan='2'>Settlement Amount</th>"+
	      "</tr>"+
	     " <tr>"+
	         " <th style='border: 1px solid black; width: 2.5%; text-align: center;'>Quality</th>"+
	          "<th style='border: 1px solid black; width: 2.5%; text-align: center;'>Moisture</th>"+
	          "<th style='border: 1px solid black; width: 2.5%; text-align: center;'>NCV</th>"+
	          "<th style='border: 1px solid black; width: 2.5%; text-align: center;'>Dust</th>"+
	          "<th style='border: 1px solid black; width: 2.5%; text-align: center;'>Quality</th>"+
	          "<th style='border: 1px solid black; width: 2.5%; text-align: center;'>Moisture</th>"+
	          "<th style='border: 1px solid black; width: 2.5%; text-align: center;'>NCV</th>"+
	          "<th style='border: 1px solid black; width: 2.5%; text-align: center;'>Dust</th>"+
	     " </tr>"
	            
	           
	          for (var i = 0; i < data.length; i++) {
	              contentToDisplay += "<tr>";
	                contentToDisplay += "<td style='border: 1px solid black; text-align: center;'>" + (i + 1) + "</td>"; // Displaying row number
	            
	                contentToDisplay += "<td style='border: 1px solid black;'>" + data[i][6] + "</td>";
	                contentToDisplay += "<td style='border: 1px solid black;'>" + data[i][10] + "</td>"; // Balemark
	                contentToDisplay += "<td style='border: 1px solid black;'>" + data[i][7] + "</td>"; // Mr no.
	                contentToDisplay += "<td style='border: 1px solid black;'>" + data[i][9] + "</td>";
	                contentToDisplay += "<td style='border: 1px solid black;'>" + data[i][12] + "</td>";
	                contentToDisplay += "<td style='border: 1px solid black;'>" + data[i][13] + "</td>";
	                contentToDisplay += "<td style='border: 1px solid black;'>" + data[i][14] + "</td>"; // Actual Qty
	                contentToDisplay += "<td style='border: 1px solid black;'>" + data[i][16] + "</td>";
	                contentToDisplay += "<td style='border: 1px solid black;'>" + data[i][17] + "</td>";
	                contentToDisplay += "<td style='border: 1px solid black;'>" + data[i][19] + "</td>";
	                contentToDisplay += "<td style='border: 1px solid black;'>" + data[i][18] + "</td>";
	                contentToDisplay += "<td style='border: 1px solid black;'>" + data[i][24] + "</td>";
	                contentToDisplay += "<td style='border: 1px solid black;'>" + data[i][25] + "</td>";
	                contentToDisplay += "<td style='border: 1px solid black;'>" + data[i][26] + "</td>";
	                contentToDisplay += "<td style='border: 1px solid black;'>" + data[i][27] + "</td>";
	                contentToDisplay += "<td style='border: 1px solid black;'>" + data[i][29] + "</td>";//Claim Amount
	                contentToDisplay += "</tr>";
}
contentToDisplay += "</table>";

var MillText = "<div id='Mill'> Mill Name:<strong>" + data[0][0] + "</strong></div>";
$("#form3").append(MillText);

// Append Cont value as text
var ContText = "<div id='Cont'> Contract No.:<strong>" + data[0][1] + "</strong></div>";
$("#form4").append(ContText);

// Append DI value as text
var DIText = "<div id='DI'> DI no.:<strong>" + data[0][2] + "</strong></div>";
$("#form5").append(DIText);

// Append Date value as text (assuming data[0][30] is the correct index)
var DateText = "<div id='DateInput'> Date of Inspection:<strong>" + (data[0][31] || '') + "</strong></div>";
$("#form6").append(DateText);


//Update the content of the form2 element with the constructed table
$("#form2").html(contentToDisplay);

// Add space between table and file upload
$("#form2").append("<div style='height: 20px;'></div>");
var Total = "<div id='Total'> Total Settlement Amount :<strong>" + (data[0][30] ) + "</strong></div>";
$("#form2").append(Total);
// Add file upload input

var fileUploadHTML = "<a href='downloadSupportDocumentFA.obj?filename=" + data[0][28] + "' class='btn btn-primary btn-sm' target='_blank'>View Supporting docs</a>";
$("#form2").append(fileUploadHTML);


// Add space between file upload and checkbox
$("#form2").append("<div style='height: 20px;'></div>");

// Add checkbox and text
var checkboxHTML = "<label><input type='checkbox' id='confirmCheckbox' name='confirmCheckbox' required><strong> I do hereby confirm the settlement record</strong></label>";
$("#form2").append(checkboxHTML);

// Add space between checkbox and buttons
$("#form2").append("<div style='height: 20px;'></div>");


var confirmButtonHTML = "<button type='button'  onclick='confirmAction()' style='margin-right: 10px;'>Confirm</button>";

$("#form2").append(confirmButtonHTML);
/* var rejectButtonHTML = "<button type='button'  onclick='rejectAction()'>Reject</button>"; */
/* $("#form2").append(rejectButtonHTML); */



	        },

	        error: function(xhr, status, error) {
	            // Handle error
	        }
	    });
	});
	// Function for Confirm action
	function confirmAction() {
	    alert("Confirmed"); 
	    var setId = $("#setId").val();
	    
	    
	   
	      

	     
	    
	    if (!$("#confirmCheckbox").is(":checked")) {
            var errorMessage = "Please confirm the settlement record.";
            var errorDiv = $("<div>").text(errorMessage).css({
                "color": "red",
                "font-weight": "bold"
            });
            $("#errorcontainer1").empty().append(errorDiv).show(); // Show the error container
            window.scrollTo(0, 0); // Scroll to the top of the window

            setTimeout(function() {
                $("#errorcontainer1").empty().hide(); // Clear and hide the error message after 5 seconds
            }, 5000);
	    }
	    else{
	    
	    handleConfirmation(setId);
	    }
	}

	// Function for Reject action
	function rejectAction() {
	    alert("Rejected");
	    var setId = $("#setId").val();
	    
	    alert(setId+"-----");
	    handleRejection(setId);
	}
	 // Function to handle confirmation action
	  function handleConfirmation(settleId) {
	    // Your code to handle confirmation action goes here
	    console.log('Confirmation action for settlement ID:', settleId);
	   
	   
	   
	    
		alert();
	    $.ajax({
	        url: 'acceptClaimMill.obj',
	        method: 'GET', // Assuming you want to use POST method for file upload
	        data: {"settleId":settleId},
	       
	        success: function(response) {
	            // Handle success response
	        	  window.location.reload();
	        },
	        error: function(xhr, status, error) {
	            // Handle error
	        }
	    }); 
	 }
	  /*   function handleRejection(settleId) {
	        // Your code to handle rejection action goes here
	        console.log('Rejection action for settlement ID:', settleId);
	     

	     
	       //  formData.append('file', file); 

	        $.ajax({
	            url: 'rejectClaim.obj',
	            method: 'POST', // Assuming you want to use POST method for file upload
	            data: {"setId",setId},
	            
	            success: function(response) {
	                // Handle success response
	            	  window.location.reload();
	                
	            },
	            error: function(xhr, status, error) {
	                // Handle error
	            }
	        }); 
	    } */
	</script>
	
	<script>
	$("#Contract").on("change", function() {
	    var setId = $(this).val();  // Get the selected value of the #Contract element
	    alert(setId);  // Display an alert with the selected value
	    $.ajax({
	        url: 'GetSettlementId.obj',
	        method: 'GET', // Assuming you want to use POST method for file upload
	        data: {"Contract":setId},
	       
	        success: function(response) {
	            // Handle success response
	        	
	        },
	        error: function(xhr, status, error) {
	            // Handle error
	        }
	    }); 
	    
	});


	</script>
	
	
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






























	
	
	
	
	
	
	





</body>

</html>


