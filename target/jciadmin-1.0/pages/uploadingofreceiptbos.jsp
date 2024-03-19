<%@page import="java.util.List"%>
<%@page import="java.time.LocalDate"%>
<%@page import="java.time.LocalDateTime"%>
<%@page import="java.time.format.DateTimeFormatter"%>
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
    <!-- THEME STYLES-->
    <link href="assets/css/main.min.css" rel="stylesheet" />
    <!-- PAGE LEVEL STYLES-->
     <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
  
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
     <link rel="stylesheet" href="//code.jquery.com/ui/1.13.2/themes/base/jquery-ui.css">
<link rel="stylesheet" href="/resources/demos/style.css">
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
                <h1 class="page-title">Uploading of receipt BoS with entry of actual weight</h1>
            </div>
            
            <% 
         // Author vishal
         
            %>
            <div class="page-content fade-in-up">
                <div class="row">
                    <div class="col-md-11">
                        <div class="ibox">
                          <span>${msg}</span>
                            <div class="ibox-body">
                       <form action="saveuploadingreceipt.obj" method="POST">
                                 <div class="row">
                                   
	                                       <div class="col-sm-4 form-group">
	                                             <label>DPC 10 No</label>
	                                             <input class="form-control taxtbox" name="dpc10no"type="text" placeholder="DPC -10 No" required>
	                                       </div>
                                      
		                                       
                                         <div class="col-sm-4 form-group">
	                                             <label>Jute Variety</label>
	                                             <input class="form-control taxtbox" name="jutevariety"type="text" placeholder="Jute Variety" required>
	                                       </div>
										
										 <div class="col-sm-4 form-group">
	                                             <label>Jute Grade</label>
	                                             <input class="form-control taxtbox" name="jutegrade" min="0" type="number" placeholder="Jute Grade" required>
	                                       </div>
                                 </div>
                                    
                                   <div class="row">
                                   
                                           <div class="col-sm-4 form-group">
	                                             <label>Actual Weight</label>
	                                            <input class="form-control taxtbox" name="actualweight" min="0" type="number" placeholder="Actual Weight" required>
	                                       </div>
	                                     
                                    </div><br>
                                        <div class="row"> 
                                        
                                                <div class="col-sm-12 form-group">
									             <input type="submit" value="Submit"class="btn btn-primary" id="submit">
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
    
    <script type="text/javascript">
    
	$(document).ready(function(){
		 $("#submit").click(function(){
		
			  var dpcdate = $("#dpc10date").val();
			  var challandate = $("#challandate").val();
			  if(dpcdate =="" || challandate =="")
				  {
				    alert("Please select mandatory Fields!");
				  }
			  
		    });
	 });
		
	</script>
	
    
    <!-- END PAGA BACKDROPS-->
    <!-- CORE PLUGINS-->
    <script src="./assets/vendors/jquery/dist/jquery.min.js" type="text/javascript"></script>
    <script src="./assets/vendors/popper.js/dist/umd/popper.min.js" type="text/javascript"></script>
    <script src="./assets/vendors/bootstrap/dist/js/bootstrap.min.js" type="text/javascript"></script>
    <script src="./assets/vendors/metisMenu/dist/metisMenu.min.js" type="text/javascript"></script>
    <script src="./assets/vendors/jquery-slimscroll/jquery.slimscroll.min.js" type="text/javascript"></script>
    <!-- PAGE LEVEL PLUGINS-->
    <!-- CORE SCRIPTS-->
    <script src="assets/js/app.min.js" type="text/javascript"></script>
    
    <!-- PAGE LEVEL SCRIPTS-->
</body>
</html>