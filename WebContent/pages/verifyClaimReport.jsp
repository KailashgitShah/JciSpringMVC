
<%@page import="java.util.HashMap"%>
<%@page import="java.util.List"%>
<%@page import="java.io.File"%>
<%@page import="com.jci.model.ZoneModel"%>
<%@page import="com.jci.model.VerifyFarmerModel"%>
<%@page import="com.jci.model.FarmerRegModelDTO"%>
<%@page import="com.jci.model.StateList"%>
<%@page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.Date" %>
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
<link href="./assets/vendors/DataTables/datatables.min.css"
	rel="stylesheet" />
<!-- THEME STYLES-->
<link href="assets/css/main.min.css" rel="stylesheet" />
<!-- PAGE LEVEL STYLES-->
<style>
table {
	border-collapse: collapse;
	width: 100%;
}



tr:nth-child(even) {
	background-color: #f2f2f2;
}
div.scrollmenu {
 /*  background-color: #333; */
  overflow: auto;
  white-space: nowrap;
}

div.scrollmenu a {
  display: inline-block;
  color: white;
  text-align: center;
  padding: 14px;
  text-decoration: none;
}

div.scrollmenu a:hover {
  background-color: #777;
}
</style>

<script src="https://code.jquery.com/jquery-1.11.3.min.js"
	type="text/javascript"></script>
<script
	src="https://cdn.datatables.net/1.10.9/js/jquery.dataTables.min.js"
	type="text/javascript"></script>
<link rel="stylesheet"
	href="https://cdn.datatables.net/1.10.9/css/jquery.dataTables.min.css" />
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		$("#farmerVerific").DataTable({
			scrollX : true,
			"pageLength" : 50
		});
	});
</script>
</head>
<%
List<Object[]> getSettlementid = (List<Object[]>) request.getAttribute("getSettlementidlist");
%>
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
				<h1 class="page-title">Verify Claim(F & A Official) List</h1>
			</div>


			<div class="row"></div>
			<c:if test="${not empty msg}">
				<div class="">${msg}</div>
			</c:if>
			<div class="scrollmenu"> 
			<div class="table-responsive" style="margin-top: 20px;">
<table id="farmerVerific" class="table table-striped table-bordered table-hover" cellspacing="0" style="width: 100%">
    <thead>
        <tr>
            <th style="width: 5%">S.No</th>
            <th style="width: 10%">Settlement Id</th>
            <th style="width: 10%">Challan No</th>
            <th style="width: 10%">Contract No</th>
            <th style="width: 10%">Date of Inspection</th>
            
           <!--  <th style="width: 10%">Mill Name</th> -->
           <th style="width: 10%">Quality Settlement</th>
            <th style="width: 10%">Moisture Content Settlement</th>
            <th style="width: 5%">NCV Settlement</th>
            
             <th style="width: 10%">Dust Settlement</th>
             <th style="width: 5%">HO DI </th>
            <th style="width: 10%">Claim Amount</th>
            <th style="width: 10%">Settlement Amount</th>
            <th style="width: 10%">Entry by</th>
            <th style="width: 10%">File Upload</th>
            
            <th style="width: 5%">Confirm/Reject</th>
        </tr>
    </thead>
    <tbody>
        <% int i = 1;
           for (Object[] row : getSettlementid) { %>
        <tr>
            <td style="width: 5%"><%= i %></td>
            <td style="width: 10%" ; text-align: center; id='<%= "st" + i %>'><%= row[0] %></td>
            <td style="width: 10%" ; text-align: center; id='<%= "ch" + i %>'><%= row[1] %></td> 
            <td style="width: 10%"; text-align: center;  id='<%= "cont" + i %>'><%= row[2] %></td> 
            <%
// Assuming row[3] contains the date string "2024-05-17 00:00:00.0"
String dateString = row[3].toString();
SimpleDateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S");
SimpleDateFormat outputFormat = new SimpleDateFormat("dd-MM-yyyy");

Date date = inputFormat.parse(dateString);
String formattedDate = outputFormat.format(date);
%>

            <td style="width: 10%; text-align: center;"><%= formattedDate %></td>
            
           <td style="width: 10%; text-align: center;"><%= row[8] %></td>
           <%--  <td style="width: 10%"><%= row[5] %></td>    --%>
            <td style="width: 10%; text-align: center;"><%= row[6] %></td> 
            <td style="width: 10%; text-align: center;"><%= row[7] %></td> 
            
            <td style="width: 10%; text-align: center;"><%= row[10] %></td>  
             <td style="width: 10%; text-align: center;"><%= row[13] %></td>    
             <td style="width: 10%; text-align: center;"><%= row[12] %></td>  
            <td style="width: 10%; text-align: center;"><%= row[9] %></td> 
            <td style="width: 10%; text-align: center;"><%= row[4] %></td> 
                    <% 
                    
                 // Assuming row[11] is of type Integer
                 if (row[11] != null && ((Integer)row[11]) == 0) { %>
                     <td style="width: 5%">
                         <input type="file" id="fileUpload-<%= i %>" name="fileUpload-<%= i %>" accept=".pdf,.doc,.docx">
                     </td>
                     <td style="width: 5%">
                         <button id="confirm-btn-<%= i %>" class="confirm-btn" data-row-id="<%= i %>">Confirm</button>
                         <button id="reject-btn-<%= i %>" class="reject-btn" data-row-id="<%= i %>">Reject</button>
                     </td>
                 <% } else { %>
                     <td colspan="2" style="; text-align: center; width: 20%">Verification Completed</td>
                 <% } %>


        </tr>
        <% i++; } %>
    </tbody>
</table>

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
	<script>
  // Attach click event listeners to each confirm button
  $('.confirm-btn').click(function() {
    const rowId = $(this).data('row-id');
    // Call function to handle confirmation action
   
    var settleId=$("#st" + rowId).html();
    const fileInput = $('#fileUpload-' + rowId)[0].files[0];
    alert(fileInput);
    handleConfirmation(settleId,fileInput);
  });

  // Attach click event listeners to each reject button
  $('.reject-btn').click(function() {
    const rowId = $(this).data('row-id');
    // Call function to handle rejection action
    
    var settleId=$("#st" + rowId).html();
    const fileInput = $('#fileUpload-' + rowId)[0].files[0];
    alert();
    handleRejection(settleId,fileInput);
    
  });

  // Function to handle confirmation action
  function handleConfirmation(settleId, file) {
    // Your code to handle confirmation action goes here
    console.log('Confirmation action for settlement ID:', settleId);
    console.log('File:', file);
    alert();
    var formData = new FormData();
    formData.append('settleId', settleId);
    formData.append('file', file);
	alert();
    $.ajax({
        url: 'acceptClaim.obj',
        method: 'POST', // Assuming you want to use POST method for file upload
        data: formData,
        contentType: false,
        processData: false,
        success: function(response) {
            // Handle success response
        	  window.location.reload();
        },
        error: function(xhr, status, error) {
            // Handle error
        }
    }); 
}

// Function to handle rejection action
function handleRejection(settleId, file) {
    // Your code to handle rejection action goes here
    console.log('Rejection action for settlement ID:', settleId);
    console.log('File:', file);

    var formData = new FormData();
    formData.append('settleId', settleId);
   /*  formData.append('file', file); */

    $.ajax({
        url: 'rejectClaim.obj',
        method: 'POST', // Assuming you want to use POST method for file upload
        data: formData,
        contentType: false,
        processData: false,
        success: function(response) {
            // Handle success response
        	  window.location.reload();
            
        },
        error: function(xhr, status, error) {
            // Handle error
        }
    }); 
}
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
	<!-- PAGE LEVEL SCRIPTS-->







</body>

</html>


