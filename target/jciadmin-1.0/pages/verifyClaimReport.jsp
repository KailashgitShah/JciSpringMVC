<%@page import="java.text.SimpleDateFormat"%>
<%@page
	import="net.sf.jasperreports.engine.util.Java14BigDecimalHandler"%>
<%@page import="java.util.List"%>
<%@page import="java.time.LocalDate"%>
<%@page import="java.time.LocalDateTime"%>
<%@page import="java.time.format.DateTimeFormatter"%>
<%@page import="java.math.BigDecimal"%>

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
<%
List<Object> getSettlementid = (List<Object>) request.getAttribute("getSettlementidlist");
%>


</head>
<style>

   .center-wrapper {
    display: flex;
    justify-content: center;
    align-items: center;
    height: 100%; /* Set the height of the wrapper to occupy full height of its parent */
}

#element {
    /* Add any styles you want for the element */
    text-align: center; /* Optionally center the text horizontally */
}
#element table {
    width: 80%; /* Set the width of the table to 80% of its container */
    margin: 0 auto; /* Center the table horizontally within its container */
}

#element table th,
#element table td {
    padding: 10px; /* Increase padding for table cells */
    font-size: 16px; /* Increase font size for table cells */
}

#element table th {
    font-weight: bold; /* Make table header cells bold */
}

</style>

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
				<h1 class="page-title">Verification of Claim Report</h1>
			</div>



			<%-- <%
			List<Object[]> Data = (List<Object[]>) request.getAttribute("Data");
			%> --%>
			<div class="page-content fade-in-up">
				<div class="row">
					<div class="col-md-11">
						<div class="ibox" id="ibox">
							<span>${msg}</span>
							<div class="ibox-body">
								<div id='errorcontainer'
									style='display: none; text-align: center;'></div>
								<form action="verifyClaimReport.obj" method="GET">
									<div class="child-checkbox" id="disableform">
										<div id="container">

											<div id="r1" style="align: right;">
												<div class="row">

													<div class="col-sm-4 form-group">
														<label>Settlement Id</label> <span class="text-danger">*
														</span>&nbsp; <span id="Settlement_Id" name="Settlement_Id"
															class="text-danger"> </span> <select
															name="Settlement_Id1" id="SettlementId1"
															class="form-control taxtbox" required>
															<option value="" selected disabled>-Select-</option>
															<%
															if (getSettlementid != null && !getSettlementid.isEmpty()) {
																for (int i = 0; i < getSettlementid.size(); i++) {
																	BigDecimal settlementId = (BigDecimal) getSettlementid.get(i);
															%>
															<option value="<%=settlementId.intValue()%>"><%=settlementId.intValue()%></option>
															<%
															}
															}
															%>
														</select>
													</div>






												</div>
											

													<div class="row">
    <div class="col-sm-12 form-group">
        <div class="center-wrapper">
            <div id="element">
                <!-- Content to be aligned -->
            </div>
        </div>
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
			<!-- END PAGE CONTENT-->
			<%@ include file="footer.jsp"%>
		</div>
	</div>

	<div class="sidenav-backdrop backdrop"></div>

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

</body>

<script>
	$("#SettlementId1")
			.on(
					'change',
					function() {
						var id = $(this).val();
						alert(id);
						$
								.ajax({
									type : 'GET',
									url : 'fetchClaims.obj',
									data : {
										"id" : id
									},
									success : function(result) {
										var data = $.parseJSON(result);
										/* alert(data); */

										document.getElementById("element").innerHTML = "";
										var elementToUpdate = document
												.getElementById("element");
										var inputDateString = data[0][1];
										const inputDate = new Date(
												inputDateString);

										var day = inputDate.getDate()
												.toString().padStart(2, '0');
										var month = (inputDate.getMonth() + 1)
												.toString().padStart(2, '0');
										var year = inputDate.getFullYear();
										//alert(day + "-" + month + "-" + year);

										console.log(data);
										var contentToDisplay = "<h1 style='text-align: center; text-decoration: underline; font-weight: bold;'>Verification of Disputes</h1><br>";
										contentToDisplay += "<table style='border: 1px solid black; width: 100%; text-align: center;'>";
										contentToDisplay += "<tr><th style='border: 1px solid black; width: 33.33%;font-weight: bold;text-align: center;'>Fields</th><th style='border: 1px solid black; width: 33.3%; font-weight: bold;text-align: center;'>Mill Claim</th><th style='border: 1px solid black; width: 33.3% ;font-weight: bold;text-align: center; '>F&A Official Claim</th></tr>";
										contentToDisplay += "<tr><td style='border: 1px solid black; width: 33.33%;'>Claim Amount</td><td style='border: 1px solid black; width: 33.3%;'>"
												+ data[0][0]
												+ "</td><td style='border: 1px solid black; width: 20%;'>"
												+ data[0][8] + "</td></tr>";
										contentToDisplay += "<tr><td style='border: 1px solid black; width: 33.33%;'>Date of Inspection</td><td style='border: 1px solid black; width: 33.3%;'>"
												+ day
												+ "-"
												+ month
												+ "-"
												+ year
												+ "</td><td style='border: 1px solid black; width: 20%;'>"
												+ data[0][15] + "</td></tr>";
										contentToDisplay += "<tr><td style='border: 1px solid black; width: 33.33%;'>Moisture Settlement</td><td style='border: 1px solid black; width: 33.3%;'>"
												+ data[0][3]
												+ "</td><td style='border: 1px solid black; width: 20%;'>"
												+ data[0][10] + "</td></tr>";
										contentToDisplay += "<tr><td style='border: 1px solid black; width: 33.33%;'>NCV Settlement</td><td style='border: 1px solid black; width: 33.3%;'>"
												+ data[0][4]
												+ "</td><td style='border: 1px solid black; width: 20%;'>"
												+ data[0][11] + "</td></tr>";
										contentToDisplay += "<tr><td style='border: 1px solid black; width: 33.33%;'>Quality Settlement</td><td style='border: 1px solid black; width: 33.3%;'>"
												+ data[0][5]
												+ "</td><td style='border: 1px solid black; width: 20%;'>"
												+ data[0][12] + "</td></tr>";
										contentToDisplay += "<tr><td style='border: 1px solid black; width: 33.33%;'> Settlement Amount</td><td style='border: 1px solid black; width: 33.3%;'>"
												+ data[0][7]
												+ "</td><td style='border: 1px solid black; width: 20%;'>"
												+ data[0][13] + "</td></tr>";
										contentToDisplay += "<tr><td style='border: 1px solid black; width: 33.33%;'>Supporting Document</td><td style='border: 1px solid black; width: 33.3%;'><a href='C:\Users\vishwdeep.singharia\Desktop\ClaimSettlement'"">"
												+ data[0][6]
												+ "</a></td><td style='border: 1px solid black; width: 20%;'><a href='#'>"
												+ data[0][14]
												+ "</a></td></tr>";

										contentToDisplay += "</table>";
										contentToDisplay += "<button class='action-button accept-button' '>Accept</button>";
										contentToDisplay += "<button class='action-button reject-button' '>Reject</button>";
										
										// CSS style for the buttons and spacing
										contentToDisplay += "<style>.action-button { padding: 10px 20px; font-size: 16px; margin: 10px; border-radius: 5px; cursor: pointer; } .accept-button { background-color: #28a745; color: #fff; } .reject-button { background-color: #dc3545; color: #fff; }</style>";

										elementToUpdate.innerHTML = contentToDisplay;

										

										
									},
									error : function(xhr, status, error) {
										console.error(xhr.responseText);
										//alert('Error occurred while fetching data.');
									}
								});
					});
</script>
<script>
//Ensure DOM is ready before executing JavaScript
$(document).ready(function() {
    // Define acceptClaim function
    function acceptClaim(id) {
    	console.clear();
    // Perform the AJAX request to accept the claim
    $.ajax({
        type: 'GET',
        url: 'acceptClaim.obj',
        data: {
            "id": id
        },
        success: function(result) {
            console.log("Success! Result:", result);
            //alert("Success! ");
            location.reload();
            // Redirect to verifyClaimReport.obj
            //window.location.href = "verifyClaimReport.obj";
        },
        error: function(xhr, status, errorThrown) {
            console.log("Error occurred: " + status + ", " + errorThrown);
           
        }
    });
}


    // Define rejectClaim function
    function rejectClaim(id) {
    	$.ajax({
            type: 'GET',
            url: 'rejectClaim.obj',
            data: {
                "id": id
            },
            success: function(result) {
                console.log("Success! Result:", result);
                //alert("Success! ");
                location.reload();
                // Redirect to verifyClaimReport.obj
                //window.location.href = "verifyClaimReport.obj";
            },
            error: function(xhr, status, errorThrown) {
                console.log("Error occurred: " + status + ", " + errorThrown);
               
            }
        });
        
    }

    // Bind click event for accept button
    $(document).on('click', '.accept-button', function() {
        var id = $("#SettlementId1").val();
        //alert(id);
        acceptClaim(id);
    });

    // Bind click event for reject button
    $(document).on('click', '.reject-button', function() {
    	 var id = $("#SettlementId1").val();
    	 //alert(id);
        rejectClaim(id);
    });
});

</script>
</html>

