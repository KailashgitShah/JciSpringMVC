<%@page import="org.apache.poi.util.SystemOutLogger"%>
<%@page import="com.jci.model.Jciclaim_NominationModel"%>
<%@page import="java.util.List"%>
<%@page import="java.time.LocalDate"%>
<%@page import="java.time.LocalDateTime"%>
<%@page import="java.time.format.DateTimeFormatter"%>
<%@page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

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
<!-- THEME STYLES-->
<link href="assets/css/main.min.css" rel="stylesheet" />
<!-- PAGE LEVEL STYLES-->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.13.2/themes/base/jquery-ui.css">
 <link rel="stylesheet" href="/resources/demos/style.css">
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
<script src="https://code.jquery.com/ui/1.13.2/jquery-ui.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.5.0/js/bootstrap-datepicker.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<!-- CORE SCRIPTS-->


<style>
.required:after {
	content: " *";
	color: red;
}
 
 .input-container input[type="text"] {
     background-color: #E9ECEF; /* Set the background color of the input field */
     border:  1px solid rgba(0,0,0,.15);  /* Optional: Remove border for a clean look */
    
     padding :1px 5px 1px 5px;
     width:200px;
  
     
    }

   #milldetailsTable {
    border-width: 1px; /* Set the border width to 1 pixel */
    border-style: solid; /* Use solid border style */
    border-color: #ccc; /* Set border color (e.g., light gray) */
}   
   
</style>


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
				<h1 class="page-title"> Add FA Officials for Claim
					Settlement</h1>
			</div>

			
			
			<div class="page-content fade-in-up">
				<div class="row">
					<div class="col-md-11">
						<div class="ibox">
							<span>${msg}</span>
							<div class="ibox-body">
								<form action="updatesavenominalform.obj" method="POST">
									<div class="row">

										<div class="col-sm-4 form-group">
										<div id="faMessage" class="text-danger"></div>
										<label>F&A Official</label>
										<span class="text-danger">*</span>
										<select name="FAomofficial" id="FAofficial" class="form-control taxtbox" required>
										    <option value="">Select</option>
										    <c:forEach items="${FA_official}" var="item">
										        <option value="${item}">${item}</option>
										    </c:forEach>
										</select> 
										</div>
										</div>
										
										   <%
			                                 Jciclaim_NominationModel nominationProfile = (Jciclaim_NominationModel)request.getAttribute("nomination");	
										   
		                                    %>
                                        <input type = "hidden"  name="DateofInpection"           value="<%=nominationProfile.getDateofInspection()%>">                                   
										<input type = "hidden"  name="Settlement_id_generated"   value="<%=nominationProfile.getSettlement_id_generated()%>">      
										<input type = "hidden"  name="millname"                  value="<%=nominationProfile.getMill()%>">      
										<input type =  "hidden" name="omoofficial"               value="<%=nominationProfile.getOMOfficial()%>">      
										           
     
										        
									
									<div class="row">

										<div class="col-sm-4 form-group">
												<a href="viewlistnominal.obj"><button class="btn btn-warning" type="button">Back</button></a>
										        <input type="submit" value="Submit" class="btn btn-primary"id="submit">
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


<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
<script src="https://code.jquery.com/ui/1.13.2/jquery-ui.js"></script>
<!--  <script>
	$( "#DateofInpection" ).datepicker({ dateFormat: 'dd-mm-yy'    });

	
</script> -->




	<script type="text/javascript">
		$(document).ready(function() {
			$("#submit").click(function() {
				//  Write code if Required

			});
		});
	</script>






<script type="text/javascript">
    // Initialize the Datepicker
 
    // Event handler for omofficial select element
    $(" #FAofficial").change(function() {
        // Execute the logic when omofficial selection changes
        var selectedFafficial = document.getElementById("FAofficial").value;
        var selectedDate = document.getElementById("DateofInpection").value;
        var faMessageElement = document.getElementById("faMessage");

        
            $.ajax({
                type: 'GET',
                url: 'fetchdateOfInspection.obj',
                data: {
                    DateOfInspection: selectedDate
                },
                success: function(data) {
                    var response = JSON.parse(data);
                    for (var i = 0; i < response.length; i++) {
                        var innerArray = response[i];
                        var omoofficial = innerArray[0];
                        var faofficial = innerArray[1];
                        if (selectedDate  == document.getElementById("DateofInpection").value  && faofficial == selectedFafficial) {
                            faMessageElement.innerText = selectedFafficial + " is Already Occupied on this date for another claim settlement. Please Select Another Date";
                            return;
                        }
                       
                    }
                    // If no conflicting dates found, clear any existing messages
                    faMessageElement.innerText = "";
                },
                error: function(err) {
                    console.error('AJAX request failed: ' + err);
                }
            });
        
    });
</script>
 



	


	<script type="text/javascript">
		$(document).ready(function() {
			// Add an event listener for the change event on the dropdown
/* 
			$('.input-container').hide();

			$('span').hide();
 */
		/* 	$('#ContractNo').on('change', function() {
				// Get the selected option value
				var selectedOption = $(this).val();
				if (selectedOption != '') {
					$('.input-container').show();
					$('span').show();
				} else {
					$('.input-container').hide();

				}

			}); */
		});
	</script>


	<!-- END PAGA BACKDROPS-->
	<!-- CORE PLUGINS-->
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
	<!-- CORE SCRIPTS-->
	<script src="assets/js/app.min.js" type="text/javascript"></script>

	<!-- PAGE LEVEL SCRIPTS-->
</body>
</html>
