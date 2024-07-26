<%@page import="java.text.SimpleDateFormat"%>
<%@page
	import="net.sf.jasperreports.engine.util.Java14BigDecimalHandler"%>
<%@page import="java.util.List"%>
<%@page import="java.time.LocalDate"%>
<%@page import="java.time.LocalDateTime"%>
<%@page import="java.time.format.DateTimeFormatter"%>
<%@page import="java.util.List"%>
<%@page import="java.time.LocalDate"%>

<%@ page import="java.math.BigDecimal" %>

<!DOCTYPE html>
<html lang="en">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js">
	
</script>
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
<link href="assets/css/main.min.css" rel="stylesheet" />
<link rel="stylesheet" href="assets/css/docsupport/style.css">
<link rel="stylesheet" href="assets/css/docsupport/prism.css">
<link rel="stylesheet" href="assets/css/chosen.css">
<script src="https://code.jquery.com/jquery-1.11.3.min.js"
	type="text/javascript"></script>




</head>
<style>
.img-magnifier-container {
	position: relative;
}

.img-magnifier-glass {
	position: absolute;
	border: 3px solid #000;
	border-radius: 50%;
	cursor: none;
	/*Set the size of the magnifier glass:*/
	width: 100px;
	height: 100px;
}
.ibox {
    padding: 0 5px;
}
</style>
<style>
    .magnifier {
        /* Your existing styles */
        /* Ensure the image fits within its container */
        max-width: 100%;
        max-height: 100%;
    }

    #controls {
        /* Style for control buttons */
        
         z-index: 1;
    }
</style>

<script>
    var rotation = 0;
    var scale = 1.0;

    function zoomIn() {
        scale += 0.1;
        applyTransform();
    }

    function zoomOut() {
        scale -= 0.1;
        applyTransform();
    }

    function rotateLeft() {
        rotation -= 90;
        applyTransform();
    }

    function rotateRight() {
        rotation += 90;
        applyTransform();
    }

    function applyTransform() {
        var img = document.getElementById("uploadedImage");
        img.style.transform = "rotate(" + rotation + "deg) scale(" + scale + ")";
    }
</script>

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
				<h1 class="page-title">Verification of Weighment Slip</h1>
			</div>



			<%
			List<Object[]> Data = (List<Object[]>) request.getAttribute("Data");
			%>
			<div class="page-content fade-in-up">
    <div class="row">
        <div class="col-md-11">
            <div class="ibox" id="ibox">
                <span>${msg}</span>
                <div class="ibox-body">
                    <div id='errorcontainer' style='display: none; text-align: center;'></div>
                    <form action="verifyWeightmentSlip.obj" method="POST" onsubmit="return myFunc()" id="myForm">
                        <div class="child-checkbox" id="disableform">
                            <div id="container" style="display: flex;">
                          <div id="l1" style="flex: 1; position: relative; overflow: hidden;">
    <div id="elementId" style="text-align: left; position: relative;">
        <img name="uploadedImage" id="uploadedImage" src="http://49.50.118.125:8080/WeightSlipment/<%=Data.get(0)[5]%>" class="magnifier">
        <div id="controls" style="position: absolute; top: 10px; right: 10px; z-index: 1;">
            <button type="button" onclick="zoomIn()">Zoom In</button>
            <button type="button" onclick="zoomOut()">Zoom Out</button>
            <button type="button" onclick="rotateLeft()">Rotate Left</button>
            <button type="button" onclick="rotateRight()">Rotate Right</button>
        </div>
    </div>
</div>


                                <div id="r1" style="flex: 1; margin-left: 10px;">
                                    <div class="row">
                                        <div class="col-sm-4 form-group">
                                            <label>Bill of Supply no.</label>
                                            <span class="text-danger">*</span>&nbsp;
                                            <span class="text-danger">
                                                <input class="form-control textbox" name="billNo" id="billNo" value="<%=Data.get(0)[2]%>" readonly>
                                            </span>
                                        </div>
                                        <div class="col-sm-4 form-group">
                                            <label>Bill of Supply date</label>
                                            <span class="text-danger">*</span>&nbsp;
                                            <span id="cdate" name="cdate" class="text-danger"></span>
                                            <input class="form-control" name="billDate" id="billDate" type="text" readonly placeholder="DD/MM/YYYY" value="<%=Data.get(0)[1]%>">
                                        </div>
                                        <div class="col-sm-4 form-group">
                                            <label>Nominal Weight</label>
                                            <span class="text-danger">*</span>&nbsp;
                                            <input name="Nominal" id="Nominal" class="form-control textbox" required readonly placeholder="Nominal Weight" value="<%=Data.get(0)[7]%>">
                                        </div>
                                    </div>
                                    <div class="row">
                                        <div class="col-sm-4 form-group d-none">
    <label>DPC End Actual Weight (Qtls)</label>
    <input class="form-control textbox" name="DpcEndWt" min="0" type="number" id="DpcEndWt" placeholder="DpcEndWt" required readonly value="<%=Data.get(0)[4] %>">
</div>

                                        <div class="col-sm-4 form-group">
                                            <label>Mill End Actual Weight (Qtls)</label>
                                            <input class="form-control textbox" name="MillWt" type="number" id="MillWt" placeholder="MillWt" required readonly value="<%=Data.get(0)[6]%>">
                                        </div>
                                        <div class="col-sm-4 form-group">
                                            <label>DPC End Truck Gross Weight (Qtls)</label>
                                            <input class="form-control textbox" name="DPCGrossWt" type="number" step="0.01" id="DPCGrossWt" min=0 placeholder="DPC End Truck Wt" value="0.0" required>
                                        </div>
                                         <div class="col-sm-4 form-group">
                                            <label>DPC End Truck Tare Weight (Qtls)</label>
                                            <input class="form-control textbox" name="DPCqty" type="number" step="0.01" id="DPCqty" min=0 placeholder="DPC End Truck Tare Wt" value="0.0" required>
                                        </div>
                                    </div>
                                    <div class="row">
                                       
                                        <div class="col-sm-4 form-group">
                                            <label>DPC End Truck Net Weight</label>
                                            <input class="form-control textbox" name="DPCNetqty" type="number" step="0.01" id="DPCNetqty" min=0 placeholder="DPC End Truck Net Wt" value="0.0" required>
                                        </div>
                                    </div>
                                    <div class="row">
                                        <div class="col-sm-12 form-group">
                                            <input type="submit" value="Submit" class="btn btn-primary" id="submit">
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>


	<div class="sidenav-backdrop backdrop"></div>
<script>
function myFunc(){
	var actual = $("#DpcEndWt").val();
	var net = $("#DPCNetqty").val();
	//alert("Actual"+actual);
	//alert("Net"+net);
	if(net === actual) {return true;}
	 var errorMessage = "DPC-end Truck Net Weight must be matched with the DPC-end Actual Weight" ;
     var errorDiv = $("<div>").text(errorMessage).css({
         "color": "red",
         "font-weight": "bold"
     });
	 $("#errorcontainer").append(errorDiv).show(); // Show the error container
     window.scrollTo(0, 0);
     setTimeout(function() {
         $("#errorcontainer").empty().hide(); // Clear and hide the error message after 5 seconds
     }, 5000);
	return false;
}
</script>
<script>
<script type="text/javascript">
$(document).ready(function() {
	$('#turn').on('click', function() {
		var angle = ($('#uploadedImage').data('angle') + 90) || 90;
		$('#uploadedImage').css({
			'transform' : 'rotate(' + angle + 'deg)'
		});
		$('#uploadedImage').data('angle', angle);
	});
	
	// $('.zoom').magnify();
});
</script>
<script>
$(document).ready(function() {
    $('#DPCGrossWt, #DPCqty').on('input', function() {
        calculateNetWeight(); // Call the function to calculate net weight
    });
});
//Function to calculate DPC End Truck Net Weight
function calculateNetWeight() {
    // Get values of DPC End Truck Gross Weight and DPC End Truck Tare Weight
    var grossWeight = parseFloat(document.getElementById('DPCGrossWt').value).toFixed(2);
    var tareWeight = parseFloat(document.getElementById('DPCqty').value).toFixed(2);
    
    // Check if both values are valid numbers
    if (!isNaN(grossWeight) && !isNaN(tareWeight)) {
        // Calculate net weight
        var netWeight = grossWeight - tareWeight;
        
        // Update the value of DPC End Truck Net Weight input field
        document.getElementById('DPCNetqty').value = netWeight.toFixed(2);
    } else {
        // Handle invalid input (optional)
    	/*  var errorMessage = "DPC-end Truck Net Weight must be matched with the DPC-end Actual Weight" ;
         var errorDiv = $("<div>").text(errorMessage).css({
             "color": "red",
             "font-weight": "bold"
         });
    	 $("#errorcontainer").append(errorDiv).show(); // Show the error container
         window.scrollTo(0, 0);
         setTimeout(function() {
             $("#errorcontainer").empty().hide(); // Clear and hide the error message after 5 seconds
         }, 5000); */
    }
}


</script>
	<script src="assets/css/chosen.jquery.js" type="text/javascript"></script>
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
<script>
        $(document).ready(function() {
            $('#myForm').on('submit', function(event) {
                // Disable the submit button
                $('#submit').prop('disabled', true);
                $('#submit').val('Please Wait Processing...');  

              
            });
        });
    </script>
</body>


</html>

