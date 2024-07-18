
<%@page import="java.util.HashMap"%>
<%@page import="java.util.List"%>
<%@page import="java.io.File"%>
<%@page import="com.jci.model.ZoneModel"%>

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
				<h1 class="page-title">Verify Settlement(F & A Official) List</h1>
			</div>


			<div class="row"></div>
			<c:if test="${not empty msg}">
				<div class="">${msg}</div>
			</c:if>

			<div id='errorcontainer'
								style='display: none; text-align: center;'></div>
								<div id='errorcontainer1'
								style='display: none; text-align: center;'></div>
			
			<div class="row">

													<div class="col-sm-4 form-group">
    <label>Settlement Id</label> 
    <span class="text-danger">*</span>&nbsp; 
    <span id="contractno" name="contractno" class="text-danger"></span> 
    <select name="setId" id="setId" class="form-control textbox" required>
        <option value="" disabled selected>Select</option>
        <% for (Object[] setId : getSettlementid) { %>
            <option value="<%=setId[0]%>" readonly><%=setId[0]%></option>
        <% } %>
    </select>
</div>
</div>
			<!-- END PAGE CONTENT-->
			<%@ include file="footer.jsp"%>
			
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
	<!-- BEGIN THEME CONFIG PANEL-->

	<!-- END THEME CONFIG PANEL-->
	<!-- BEGIN PAGA BACKDROPS-->
	<div class="sidenav-backdrop backdrop"></div>
	<!-- END PAGA BACKDROPS-->
	<!-- CORE PLUGINS-->
<!-- 	<script>
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
}</script> -->

	
	<script type="text/javascript">
	$("#setId").on("change", function() {
	    var setId = $(this).val(); // Corrected line
	    //alert(setId);
	    $.ajax({
	        url: 'settlementFA.obj',
	        method: 'GET', // Assuming you want to use GET method
	        data: {
	            "setId": setId
	        },
	        success: function(response) {
	            // Parse the JSON response
	            var data = jQuery.parseJSON(response);
	            console.log(data);
	            // Clear the existing content of the form2 element
	            $("#form2").empty();
	            
	            // Create the table structure
	          var contentToDisplay = "<table style='border: 1px solid black; width: 1250px; text-align: center;'>"+
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
	       /*          contentToDisplay += "<td style='border: 1px solid black;'>" + data[i][1] + "</td>";
	                contentToDisplay += "<td style='border: 1px solid black;'>" + data[i][2] + "</td>"; */
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
	                contentToDisplay += "<td style='border: 1px solid black;'>" + data[i][28] + "</td>";//Claim Amount
	                contentToDisplay += "</tr>";
}
contentToDisplay += "</table>";
//Append Mill value as text
$("#form3").empty();

var MillText = "<div id='Mill'> Mill Name:<strong>" + data[0][0] + "</strong></div>";
$("#form3").append(MillText);
$("#form4").empty();

// Append Cont value as text
var ContText = "<div id='Cont'> Contract No.:<strong>" + data[0][1] + "</strong></div>";
$("#form4").append(ContText);
$("#form5").empty();

// Append DI value as text
var DIText = "<div id='DI'> DI no.:<strong>" + data[0][2] + "</strong></div>";
$("#form5").append(DIText);
$("#form6").empty();

// Append Date value as text (assuming data[0][30] is the correct index)
var DateText = "<div id='DateInput'> Date of Inspection:<strong>" + (data[0][30] || '') + "</strong></div>";
$("#form6").append(DateText);

/* var Total = "<div id='Total'> Total :<strong>" + (data[0][29] ) + "</strong></div>";
$("#form7").append(Total); */
//Update the content of the form2 element with the constructed table
$("#form2").html(contentToDisplay);

// Add space between table and file upload
$("#form2").append("<div style='height: 20px;'></div>");
var Total = "<div id='Total'> Total Settlement Amount :<strong>" + (data[0][29] ) + "</strong></div>";
$("#form2").append(Total);
// Add file upload input
var fileUploadHTML = "<input type='file' id='fileUpload' required name='fileUpload' accept='.pdf,.doc,.docx'>";
$("#form2").append(fileUploadHTML);

// Add space between file upload and checkbox
$("#form2").append("<div style='height: 20px;'></div>");

// Add checkbox and text
var checkboxHTML = "<label><input type='checkbox' id='confirmCheckbox' name='confirmCheckbox' required><strong> I do hereby confirm the settlement record</strong></label>";
$("#form2").append(checkboxHTML);

// Add space between checkbox and buttons
$("#form2").append("<div style='height: 20px;'></div>");


var confirmButtonHTML = "<button type='button'  onclick='confirmAction()' style='margin-right: 10px;'>Confirm</button>";
 var rejectButtonHTML = "<button type='button'  onclick='rejectAction()'>Reject</button>"; 
$("#form2").append(confirmButtonHTML);
 $("#form2").append(rejectButtonHTML); 



	        },

	        error: function(xhr, status, error) {
	            // Handle error
	        }
	    });
	});
	// Function for Confirm action
	function confirmAction() {
	   // alert("Confirmed"); 
	    var setId = $("#setId").val();
	    
	    
	    const fileInput = $('#fileUpload')[0].files[0];
	    if (fileInput === undefined || fileInput === null) {
	        var errorMessage = "Please upload the file for confirmation.";
	        var errorDiv = $("<div>").text(errorMessage).css({
	            "color": "red",
	            "font-weight": "bold"
	        });
	        $("#errorcontainer").append(errorDiv).show(); // Show the error container
	        window.scrollTo(0, 0); // Scroll to the top of the window

	        setTimeout(function() {
	            $("#errorcontainer").empty().hide(); // Clear and hide the error message after 5 seconds
	        }, 5000);
	    }
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
	   // alert(setId+"-----"+fileInput);
	    handleConfirmation(setId,fileInput);
	    }
	}

	// Function for Reject action
	function rejectAction() {
	  //  alert("Rejected");
	    var setId = $("#setId").val();
	    
	  //  alert(setId+"-----");
	 /*    const fileInput = $('#fileUpload')[0].files[0]; */
	   /*  if (fileInput === undefined || fileInput === null) {
	        var errorMessage = "Please upload the file for confirmation.";
	        var errorDiv = $("<div>").text(errorMessage).css({
	            "color": "red",
	            "font-weight": "bold"
	        });
	        $("#errorcontainer").append(errorDiv).show(); // Show the error container
	        window.scrollTo(0, 0); // Scroll to the top of the window

	        setTimeout(function() {
	            $("#errorcontainer").empty().hide(); // Clear and hide the error message after 5 seconds
	        }, 5000);
	    } */
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
	   // alert(setId+"-----");
	    handleRejection(setId);
	    }
	   
	}
	 // Function to handle confirmation action
	  function handleConfirmation(settleId, file) {
	    // Your code to handle confirmation action goes here
	    console.log('Confirmation action for settlement ID:', settleId);
	    console.log('File:', file);
	    alert();
	    var formData = new FormData();
	    formData.append('settleId', settleId);
	    formData.append('file', file);
		//alert();
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
	   function handleRejection(settleId) {
	        // Your code to handle rejection action goes here
	        console.log('Rejection action for settlement ID:', settleId);
	     

	        var formData = new FormData();
	        formData.append('settleId', settleId);
	       //  formData.append('file', file); 

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


