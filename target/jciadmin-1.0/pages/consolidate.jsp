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

.tableFixHead {
	overflow: auto;
	height: 100px;
	width: 240px;
}

.tableFixHead thead th {
	position: sticky;
	top: 0;
	z-index: 1;
}

.tableFixHead tbody th {
	position: sticky;
	left: 0;
}

table {
	border-collapse: collapse;
	width: 100%;
}

th, td {
	padding: 8px 16px;
	white-space: nowrap;
}

th {
	background: #eee;
}
</style>
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
   
   #binDataBody {
    font-size: 20px; /* Adjust the font size as per your preference */
}
    th {
        font-size: 18px; /* Adjust the font size as per your preference */
    }
        #millsListDiv {
         color: #007bff; /* Change "red" to any color you prefer */
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
                      <h1 class="page-title">Consolidate Report</h1>
                 </div>
                 
		
			<div class="page-content fade-in-up">
				<div class="row">
					<div class="col-md-11">
						<div class="ibox">
							<span>${msg}</span>
							<div class="ibox-body">

								<form id="myForm" action="saveconsolidate.obj" method="POST">

									<div class="row">
										<div class="col-sm-4 form-group">
											<label> crop year</label> <span class="text-danger">* </span> <select
												name="cropYear" id="Mill" class="form-control taxtbox" required>
											 	<option value="">Select</option> 
											    <c:forEach items="${cropyear}" var="item">
												  <option value="${item}">${item}</option> 
												</c:forEach> 
											</select>
										</div>
                                    </div>
									
					<div class="row">
                   <div class="col-sm-4 form-group">
                    <div style="flex-grow: 1;"></div> <!-- This creates space to push the button to the bottom -->
                   <input type="submit" value="Submit" class="btn btn-primary" id="submit" onclick="disableSubmit(event)">
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
<!-- <script>
      $( "#DateofInpection" ).datepicker({ dateFormat: 'dd-mm-yy'    });

      
</script>  -->

<script>
        $(document).ready(function() {
            $('#myForm').on('submit', function(event) {
                // Disable the submit button
                $('#submit').prop('disabled', true);
                $('#submit').val('Please Wait Processing...');  

              
            });
        });
    </script>



	<script type="text/javascript">
		$(document).ready(function() {
			$("#submit").click(function() {
                 });
           });
      </script>




      <!--   For Hinding and Showing the  Grade Wise Alloction-->

      <script type="text/javascript">
           $(document).ready(function() {
           
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

