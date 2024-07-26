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
								<form id="myForm" action="saveentryoftds.obj" method="POST"
									enctype="multipart/form-data">
									<div class="row">

										<div class="col-sm-4 form-group">
											<label>Mill </label> <select name="Mill" id="Mill"
												class="form-control taxtbox" required onchange="setFinancialYear()" onclick="DateFunction()">

												<option value="">-Select-</option>

												<c:forEach items="${Mill}" var="item">

													<option value="${item}">${item}</option>

												</c:forEach>

											</select>
										</div>


										<div class="col-sm-4 form-group">

											<label>Date of Intimation</label> <input
												class="form-control textbox" name="DateofIntimation" placeholder="dd-mm-yyyy"
												id="Task_Start_date" required readonly>
										</div>
										
										


									</div>

									<div class="row">

										<div class="col-sm-4 form-group">

											<label>Financial year</label>


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

												id="submit" onclick="f()  onclick="disableSubmit(event)">

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

 <script>
        $(document).ready(function() {
            $('#myForm').on('submit', function(event) {
                // Disable the submit button
                $('#submit').prop('disabled', true);
                $('#submit').val('Please Wait Processing...');  

              
            });
        });
    </script>

<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
<script src="https://code.jquery.com/ui/1.13.2/jquery-ui.js"></script>
 <script>
	$( "#DateofIntimation" ).datepicker({ dateFormat: 'dd-mm-yy'    });
</script> 

<<<<<<< HEAD
=======
<script>
        $(document).ready(function() {
            $('#myForm').on('submit', function(event) {
                // Disable the submit button
                $('#submit').prop('disabled', true);
                $('#submit').val('Please Wait Processing...');  

              
            });
        });
    </script>
>>>>>>> 09f85224a8d7417eacbc820c5c61559fc3c8fff4
<script>
function f(){
	// alert(document.getElementsByName("SupportingDocument"))
	 var fileInput = document.getElementByName("SupportingDocument");
	// alert(fileInput);
	   var file = fileInput.files[0];
	 //  alert("file"+file)
}
 </script>
 
 <script>
	function DateFunction() {
		// Get current date
		var currentDate = new Date();

		// Format the date as dd-mm-yyyy
		var day = currentDate.getDate();
		var month = currentDate.getMonth() + 1; // Month is zero-based
		var year = currentDate.getFullYear();

		if (day < 10) {
			day = '0' + day;
		}

		if (month < 10) {
			month = '0' + month;
		}

		var formattedDate = day + '-' + month + '-' + year;

		// Set the formatted date to the Task Start Date input field
		document.getElementById('Task_Start_date').value = formattedDate;
	}
</script>
 








	<script type="text/javascript">
	function getCurrentFinancialYear() {
        var fiscalyear = "";
        var today = new Date();
        if ((today.getMonth() + 1) <= 3) {
            fiscalyear = (today.getFullYear() - 1) + "-" + today.getFullYear();
        } else {
            fiscalyear = today.getFullYear() + "-" + (today.getFullYear() + 1);
        }
        return fiscalyear;
    }

    function setFinancialYear() {
        var fiscalYear = getCurrentFinancialYear();
        document.getElementById("Financialyear").value = fiscalYear;
    }

    // Initially set the financial year when the page loads
    setFinancialYear();

	
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
