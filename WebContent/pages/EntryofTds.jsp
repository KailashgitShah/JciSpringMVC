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
</style>
</head>
<body class="fixed-navbar" onload="myFunction()">
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
				<h1 class="page-title">Entry of TDS U/s 194Q Declaration</h1>
			</div>

			<div class="page-content fade-in-up">
				<div class="row">
					<div class="col-md-11">
						<div class="ibox">
							<span>${msg}</span>
							<div class="ibox-body">
								<form action="saveentryoftds.obj" method="POST"
									enctype="multipart/form-data">
									<div class="row">

										<div class="col-sm-4 form-group">
											<label>Mill </label> <select name="Mill" id="Mill"
												class="form-control taxtbox" required>

												<option value="">-Select-</option>

												<c:forEach items="${Mill}" var="item">

													<option value="${item}">${item}</option>

												</c:forEach>

											</select>
										</div>


										<div class="col-sm-4 form-group">

											<label>Date of Intimation</label> <input
												class="form-control textbox" name="DateofIntimation" placeholder="dd-mm-yyyy"
												id="DateofIntimation" required readonly>
										</div>


									</div>

									<div class="row">

										<div class="col-sm-4 form-group">

											<label>Financial year</label>

											<!-- <input class="form-control textbox" id= "Financialyear" name="Financialyear" type="text" placeholder="Financial year" required readonly="readonly"> -->

											<input class="form-control textbox" id="Financialyear"
												name="Financialyear"
												placeholder="Financial year" required readonly="readonly">
										</div>

										<div class="col-sm-4 form-group">
											<label>Supporting Document</label> <input
												class="form-control textbox" name="SupportingDocument"
												id="SupportingDocument" type="file"
											  required>
										</div>




									</div>






									<br>
									<div class="row">

										<div class="col-sm-12 form-group">
											<input type="submit" value="Submit" class="btn btn-primary"
												id="submit" onclick="f()">
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

	<!--  AJAX Call For FEtching the Financial Year (Abhi Dummy data Fetch kr rahe h) -->

	<!--    Applying Ajax Call Here -->
	
	  <script src="assets/js/app.min.js" type="text/javascript"></script>
    <link rel="stylesheet" href="//code.jquery.com/ui/1.13.2/themes/base/jquery-ui.css">
<link rel="stylesheet" href="/resources/demos/style.css">
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
<script src="https://code.jquery.com/ui/1.13.2/jquery-ui.js"></script>
 <script>
	$( "#DateofIntimation" ).datepicker({ dateFormat: 'dd-mm-yy'    });
</script> 
<script>
function f(){
	 alert(document.getElementsByName("SupportingDocument"))
	 var fileInput = document.getElementByName("SupportingDocument");
	 alert(fileInput);
	   var file = fileInput.files[0];
	   alert("file"+file)
}
</script>

	<script type="text/javascript">
		// Wait for the document to be ready

		$(document).ready(function() {

			// Add an event listener for the change event on the dropdown

			$('#Mill').on('change', function() {

				//alert("before")

				// Get the selected option value

				var selectedOption = $(this).val();

				// alert(selectedOption + "selectedOption")
			//	alert("You have selected: " + selectedOption)

				$.ajax({

					type : 'GET', // You can adjust the HTTP method as needed (e.g., POST)

					url : 'finacialyear.obj', // Replace with the actual API endpoint

					data : {

						Mill : selectedOption

					},

					success : function(data) {

						// Handle the response data and display it.

						// console.log('Response data:', data)
						console.log('data:', data);
						var cleandata = data.replace(/"/g, '');

						$("#Financialyear").val(cleandata);

						//alert("response data" + data)
						//alert("Financial year of the mill is: " + data) 

					},

					error : function(err) {

						// Handle errors here

						console.error('AJAX request failed: ', err);

						alert("errorrrrrrrrrrr")

					}

				});

			});

		});
	</script>







	<!--  <script type="text/javascript">
       // Wait for the document to be ready
       $(document).ready(function() {
           // Add an event listener for the change event on the dropdown
           $('#Mill_name').on('change', function() {
               // Get the selected option value
               var selectedOption = $('#Mill_name').val();

               // Make an AJAX call to fetch data based on the selected value
               $.ajax({
                   type: 'GET',
                   url: 'financialyear.obj',
                   data: { Mill: selectedOption },
                   success: function(data) {
                   	alert("kkkkkkkkkkk alert");
                       // Handle the response data and display it in the 'result' div
                       alert(data);
                       // Assuming 'data' contains the financial year, update the Financialyear input
                       document.getElementById('Financialyear').value = data;
                   },
                   error: function(err) {
                       // Handle errors here
                       console.error('AJAX request failed: ' + err);
                   }
               });
           });
       });
       
   </script>  -->

	<!-- <script type="text/javascript">
	
	// Wait for the document to be ready
	 $(document).ready(function() {
	  // Add an event listener for the change event on the dropdown
	  $('#Mill').on('change', function() {
	    // Get the selected option value
	    var selectedOption = $('#Mill').val();
	    //alert(selectedOption);
	   

	    // Make an AJAX call to fetch data based on the selected value
	    $.ajax({
	      type: 'GET',  // You can adjust the HTTP method as needed (e.g., POST)
	      url: 'financialyear.obj', // Replace with the actual API endpoint
	      data: { Mill: selectedOption }, // Pass the selected option to the server
	      success: function(data) {
	        // Handle the response data and display it in the 'result' div
	        
	        alert(data);
	     
	        
	      },
	      error: function(err) {
	        // Handle errors here
	        console.error('AJAX request failed: ' + err);
	      }
	    });
	  });
	}); 
	</script>
	 -->




	<!-- <script>
     
            // Create a Date object for the current date
            var currentDate = new Date();

            // Get the year, month, and day components
            var year = currentDate.getFullYear();
            var startYear = currentDate.getMonth() >= 3 ? year : year - 1;
            var endYear = startYear + 1;
            /* var month = String(currentDate.getMonth() + 1).padStart(2, '0'); // Months are 0-based
            var day = String(currentDate.getDate()).padStart(2, '0'); */

            // Format the financial year as 'YYYY-YYYY'
            var formattedDate = startYear + '-' + endYear;
           /*  var formattedDate = year + '-' + month + '-' + day; */

            // Set the formatted date as the input's value
            document.getElementById('Financialyear').value = formattedDate;
            
    
     
    </script> -->



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
