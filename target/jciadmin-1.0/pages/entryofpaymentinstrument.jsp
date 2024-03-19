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
                <h1 class="page-title">Entry of Payment Instrument</h1>
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
                       <form action="saveentryofpaymentinstrument.obj" method="POST">
                           <div class="child-checkbox" id="disableform">
                                 <div class="row">
                                       <div class="col-sm-4 form-group">
	                                             <label>Full Contract No.</label>
	                                              <span class="text-danger">* </span>&nbsp; <span id="contractno" name="contractno" class="text-danger"> </span>
	                                        	 <select name="fullcontractno" id="fullcontractno" class="form-control taxtbox" required>
	                                        		<option value="">-Select-</option>
	                                        		<option value="12345">12345</option>
	                                        		<option value="1234567">1234567</option>
	                                        		<option value="19764567">19764567</option>
	                                        	</select>
                                        </div>
		                                       
                                        <div class="col-sm-4 form-group">
												<label>Contract Date</label> 
												<span class="text-danger">* </span>&nbsp; <span id="cdate" name="cdate" class="text-danger"> </span>
												<input class="form-control" name="contractdate" id="contractdate" type="date">
										</div>
										
										 <div class="col-sm-4 form-group">
	                                            <label>Crop Year</label> 
	                                            <span class="text-danger">* </span>&nbsp; <span id="errcropyr" name="errcropyr" class="text-danger"> </span>
												<select name="cropyear" id="cropyear" class="form-control taxtbox" required>
													<option value="">-Select-</option>
													<option value="2021-2022">2021-2022</option>
													<option value="2022-2023">2022-2023</option>
													<option value="2022-2023">2023-2024</option>
													<option value="2022-2023">2024-2025</option>
													<option value="2022-2023">2025-2026</option>
													<option value="2022-2023">2026-2027</option>
													<option value="2022-2023">2027-2028</option>
													<option value="2022-2023">2028-2029</option>
													<option value="2022-2023">2029-2030</option>
													<option value="2022-2023">2030-2031</option>
												</select>
	                                     </div>
                                 </div>
                                    
                                   <div class="row">
                                   
                                           <div class="col-sm-4 form-group">
	                                             <label>Contract Quantity </label>
	                                             <input class="form-control taxtbox" name="contractquantity" min="0" type="number" placeholder="Contract Quantity" required>
	                                       </div>
	                                     
	                                       <div class="col-sm-4 form-group">
	                                             <label>Variety-Grade Wise Quantity </label>
	                                             <input class="form-control taxtbox" name="gradewiseqty" min="0" type="number" placeholder="Variety-Grade Wise Quantity" required>
	                                       </div>
	                                       
	                                       <div class="col-sm-4 form-group">
	                                             <label>Mill Office Address</label>
	                                             <input class="form-control taxtbox" name="millofficeaddress" min="0" type="text" placeholder="Mill Office Address" required>
	                                       </div>
	                                       
                                    </div>
                                    
                                    <div class="row">
                                    
                                          
	                                        <div class="col-sm-4 form-group">
	                                             <label>Mill Side Address</label>
	                                             <input class="form-control taxtbox" name="millsideaddress" min="0" type="text" placeholder="Mill Side Address" required>
	                                       </div>
	                                       
                                           <div class="col-sm-4 form-group">
	                                            <label>Payment Type</label> 
	                                            <span class="text-danger">* </span>&nbsp; <span id="payment" name="payment" class="text-danger"> </span>
												<select name="paymenttype" id="paymenttype" class="form-control taxtbox" required>
													<option value="">-Select-</option>
													<option value="neft">NEFT</option>
													<option value="rtgs">RTGS</option>
													<option value="cheque">Cheque</option>
													<option value="cash">Cash</option>
													<option value="letterofcredit">Letter of Credit</option>
												</select>
	                                      </div>
										   <div class="col-sm-4 form-group">
	                                            <label>Mill Account Code</label> 
	                                            <span class="text-danger">* </span>&nbsp; <span id="macode" name="macode" class="text-danger"> </span>
												<select name="millaccountcode" id="millaccountcode" class="form-control taxtbox" required>
													<option value="">-Select-</option>
													<option value="milldetails">Mill Details</option>
												</select>
	                                     </div>
                                     </div>   
                                     
                                        <div class="row">
                                   
                                           <div class="col-sm-4 form-group">
	                                             <label>Instrument No.</label>
	                                             <input class="form-control taxtbox" name="instrumentno" min="0" type="number" placeholder="Instrument No" required>
	                                       </div>
	                                     
	                                       <div class="col-sm-4 form-group">
												<label>Instrument Date</label> 
												<span class="text-danger">* </span>&nbsp; <span id="instrumentdate" name="instrumentdate" class="text-danger"> </span>
												<input class="form-control" name="instdate" id="instdate" type="date">
										   </div>
	                                       
	                                      <div class="col-sm-4 form-group">
	                                            <label>Bank Name</label> 
	                                            <span class="text-danger">* </span>&nbsp; <span id="bankname" name="bankname" class="text-danger"> </span>
												<select name="bankname1" id="bankname1" class="form-control taxtbox" required>
													<option value="">-Select-</option>
													<option value="hdfc">HDFC</option>
												</select>
	                                     </div>
	                                       
                                    </div>
                                    <div class="row">
                                   
                                           <div class="col-sm-4 form-group">
	                                             <label>Bank Branch</label>
	                                             <input class="form-control taxtbox" name="bankbranch" type="text" placeholder="Bank Branch" required>
	                                       </div>
	                                     
	                                       <div class="col-sm-4 form-group">
	                                             <label>Amount</label>
	                                             <input class="form-control taxtbox" name="tamount" min="0" type="number" placeholder="Amount" required>
	                                       </div>
	                                       
	                                     <div class="col-sm-4 form-group">
	                                            <label>Auto Revolving Option</label> 
	                                            <span class="text-danger">* </span>&nbsp; <span id="aroption" name="aroption" class="text-danger"> </span>
												<select name="autorevolvingoption" id="autorevolvingoption" class="form-control taxtbox" required>
													<option value="">-Select-</option>
													<option value="yes">YES</option>
													<option value="no">NO</option>
												</select>
	                                     </div>
	                                       
                                    </div>
                                    <div class="row">
                                   
                                           <div class="col-sm-4 form-group">
	                                             <label id="autoamounta">Auto Revolving Amount</label>
	                                             <input class="form-control taxtbox" name="autorevolvingamount" id="autorevolvingamount" min="0" type="number" placeholder="Auto Revolving Amount">
	                                       </div>
	                                     
	                                       <div class="col-sm-4 form-group">
												<label id="doshipment">Date of Shipment</label> 
												<input class="form-control" name="dateofship" id="dateofship" placeholder="Date of Shipment" type="date">
										   </div>
	                                       
	                                    <div class="col-sm-4 form-group">
												<label id="doexpiry">Date of Expiry</label> 
												<input class="form-control" name="dateofexpiry" id="dateofexpiry" placeholder="Date of Expiry" type="date">
										   </div>
	                                       
                                    </div>
                                        <div class="row"> 
                                                <div class="col-sm-12 form-group">
									             <input type="submit" value="Submit"class="btn btn-primary" id="submit">
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
    
     <script type="text/javascript">
    
	$(document).ready(function(){
		 $("#submit").click(function(){
		
			  var contractdate = $("#contractdate").val();
			  var instdate = $("#instdate").val();
			  var paymenttype = $("#paymenttype").val();
			  
			  if(contractdate =="" || instdate =="")
				  {
				    alert("Please select mandatory Fields!");
				  }
			  if(paymenttype =="letterofcredit")
				  {
					  var dateofship = $("#dateofship").val();
					  var dateofexpiry = $("#dateofexpiry").val();
					  if(dateofship =="" || dateofexpiry =="")
						  {
						    alert("Please select mandatory Fields!");
						  }
				  }
			  
		    });
	 });
		
	</script>
    
    <script type="text/javascript">
      function myFunction()  
	      {
    	  $("#doexpiry").hide();
    	  $("#dateofexpiry").hide();
    	  $("#doshipment").hide();
    	  $("#dateofship").hide();
    	  
	       // alert("69");
	      }
    </script>
    
     <script type="text/javascript">
     $("#autorevolvingoption").on("change", function() {
 		var autooption = $("#autorevolvingoption").val();
 		if(autooption == "no")
 			{
 			 $("#autorevolvingamount").hide();
 			 $("#autoamounta").hide();
 			}
 		else
 			{
 			 $("#autorevolvingamount").show();
 			$("#autoamounta").show();
 			}
 	 	});
    </script>
    
     <script type="text/javascript">
	$("#paymenttype").on("change", function() {
		var paymenttype = $("#paymenttype").val();
		if(paymenttype == "letterofcredit")
			{
			  $("#doexpiry").show();
	    	  $("#dateofexpiry").show();
	    	  $("#doshipment").show();
	    	  $("#dateofship").show();
			}
		else
			{
			  $("#doexpiry").hide();
	    	  $("#dateofexpiry").hide();
	    	  $("#doshipment").hide();
	    	  $("#dateofship").hide();
			}
		//alert(paymenttype);
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