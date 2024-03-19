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
     <link rel="stylesheet" href="//code.jquery.com/ui/1.13.2/themes/base/jquery-ui.css">
<link rel="stylesheet" href="/resources/demos/style.css">
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
<script src="https://code.jquery.com/ui/1.13.2/jquery-ui.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.5.0/js/bootstrap-datepicker.js"></script>  
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
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
                <h1 class="page-title">Entry of Sale Form</h1>
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
                       <form action="saveentryofsale.obj" method="POST">
                                 <div class="row">
                                   
	                                       <div class="col-sm-4 form-group">
	                                             <label>DPC 10 No</label>
	                                             <input class="form-control taxtbox" name="dpc10no"type="text" placeholder="DPC -10 No" required>
	                                       </div>
                                      
		                                       
                                        <div class="col-sm-4 form-group">
												<label>DPC 10 Date</label> 
												<input class="form-control" name="dpc10date" id="dpc10date" type="date">
										</div>
										
										 <div class="col-sm-4 form-group">
	                                             <label>Mills Name</label>
	                                             <input class="form-control taxtbox" name="millsname"type="text" placeholder="Mills Name" required>
	                                       </div>
                                 </div>
                                    
                                   <div class="row">
                                   
                                           <div class="col-sm-4 form-group">
	                                             <label>Contract No & Date</label>
	                                             <input class="form-control taxtbox" name="contractnodate"type="text" placeholder="it will autofetch" required>
	                                       </div>
	                                     
	                                       <div class="col-sm-4 form-group">
	                                             <label>DI No & Date</label>
	                                             <input class="form-control taxtbox" name="dinoanddate"type="text" placeholder="DI No & Date" required>
	                                       </div>
	                                       
		                                   <div class="col-sm-4 form-group">
		                                             <label>Center Name</label>
		                                        	 <select name="centername" id="centername" class="form-control taxtbox" required>
		                                        		<option value="">-Select-</option>
		                                        		<option value="a">A</option>
		                                        		<option value="b">B</option>
		                                        		<option value="c">C</option>
		                                        	</select>
	                                        </div>
	                                       
                                    </div>
                                    
                                     
                                        <div class="row">
                                        
                                          <div class="col-sm-4 form-group">
	                                             <label>Agency</label>
	                                             <input class="form-control taxtbox" name="agency"type="text" placeholder="Agency will autofetch" required>
	                                       </div>
                                   
                                            <div class="col-sm-4 form-group">
	                                             <label>Region</label>
	                                             <input class="form-control taxtbox" name="region"type="text" placeholder="Region will autofetch" required>
	                                       </div>
	                                     
	                                         <div class="col-sm-4 form-group">
	                                             <label>Challan No</label>
	                                             <input class="form-control taxtbox" name="challanno"type="text" placeholder="Challan No" required>
	                                       </div>
	                                       
                                    </div>
                                    <div class="row">
                                    
                                        <div class="col-sm-4 form-group">
												<label>Challan Date</label> 
												<input class="form-control" name="challandate" id="challandate" type="date">
										</div>
                                   
	                                       <div class="col-sm-4 form-group">
	                                             <label>Lot No.(Optional)</label>
	                                             <input class="form-control taxtbox" name="lotno" min="0" type="number" placeholder="Lot No.">
	                                       </div>
	                                       
	                                       <div class="col-sm-4 form-group">
	                                             <label>Transport No.</label>
	                                             <input class="form-control taxtbox" name="transportno"type="text" placeholder="Transport No." required>
	                                       </div>
	                                    
	                                      
                                    </div>
                                     <div class="row">
                                     
                                      <div class="col-sm-4 form-group">
	                                            <label>Crop Year</label> 
	                                            <span class="text-danger">* </span>&nbsp; <span id="errcropyr" name="errcropyr" class="text-danger"> </span>
												<select name="cropyear" id="cropyear" class="form-control taxtbox" required>
													<option value="">-Select-</option>
													<option value="2021-2022">2021-2022</option>
													<option value="2022-2023">2022-2023</option>
												</select>
	                                     </div>
                                       <div class="col-sm-4 form-group">
											<label>Jute Variety</label> 
											<span class="text-danger">* </span>
                                        	<select name="jutevariety" id="jutevariety" class="form-control taxtbox" required>
                                        	<option value="">Select</option>
                                        	<option value="Bimli">Bimli</option>
                                        	<option value="Mesta">Mesta</option>
                                        	<option value="Tossa">Tossa</option>
                                        	<option value="White">White</option>
                                        	</select>
										</div>
		                                       
                                         <div class="col-sm-4 form-group">
	                                             <label>Jute Grade</label>
	                                             <input class="form-control taxtbox" name="jutegrade"type="text" placeholder="Jute Grade" required>
	                                     </div>
										
										
                                 </div>
                                 
                                  <div class="row">
                                   
                                           <div class="col-sm-4 form-group">
	                                             <label>Nominal Weight</label>
	                                             <input class="form-control taxtbox" name="nominalweight" min="0" type="number" placeholder="Nominal Weight" required>
	                                       </div>
	                                     
	                                       <div class="col-sm-4 form-group">
	                                             <label>Quantity</label>
	                                             <input class="form-control taxtbox" name="quantity" min="0" type="number" placeholder="Quantity" required>
	                                       </div>
	                                       
	                                       <div class="col-sm-4 form-group">
	                                             <label>Rate per Quintals</label>
	                                             <input class="form-control taxtbox" name="rateperquintals" min="0" type="number" placeholder="Rate per Quintals" required>
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