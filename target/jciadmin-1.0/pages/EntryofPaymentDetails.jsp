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
                <h1 class="page-title">Entry of Payment Details</h1>
            </div>
            
            <% 
            List<Object>getcontractList1=(List<Object>)request.getAttribute("getcontractList1");
         
            %>
            
            
            <div class="page-content fade-in-up">
                <div class="row">
                    <div class="col-md-11">
                        <div class="ibox">
                          <span>${msg}</span>
                            <div class="ibox-body">
                       <form action="saveentryofpaymentinstrumentDetails.obj" method="POST" name ="myForm" enctype="multipart/form-data">
                           <div class="child-checkbox" id="disableform">
                                 <div class="row">
                                       <div class="col-sm-4 form-group">
	                                             <label>Contract No.</label>
	                                              <span class="text-danger">* </span>&nbsp; <span id="contractno" name="contractno" class="text-danger"> </span>
	                                        	 <select name="fullcontractno" id="fullcontractno" class="form-control taxtbox" required>
	                                        		
													    <option value="">-Select-</option>
													    <%
													    for (Object row : getcontractList1) {
													       String field1 = (String)row;
													    %>
													    <option value="<%= field1 %>"><%= field1 %></option>
													    <%
													    }
													    %>
													</select>
	                                        		
	                                        
                                        </div>
                                         <div class="col-sm-4 form-group">
	                                            <label>Instrument Type</label> 
	                                            <span class="text-danger">* </span>&nbsp; <span id="payment" name="payment" class="text-danger"> </span>
												<select name="paymenttype" id="paymenttype" class="form-control taxtbox" required>
													<option value="">-Select-</option>
													<option value="NEFT/RTGS">NEFT/RTGS</option>
													<option value="Cheque/DD">Cheque/DD</option>
													<option value="Letter_of_Credit">Letter of Credit</option>
												</select>
	                                      </div>
		                                       
                                         <div class="col-sm-4 form-group">
												<label>Instrument No</label> 
												<span class="text-danger">* </span>&nbsp; <span id="instrument" name=Instrument class="text-danger"> </span>
												<input class="form-control" name="Instrument" id="Instrumentno" type="Number" required>
										</div> 
										
										
	                                     
                                 </div>
                                  
                                    
                                    <div class="row">
                                    
                                    
                                    
                                            <div class="col-sm-4 form-group">
	                                            <label>Instrument Value </label> 
	                                            <span class="text-danger">* </span>&nbsp; <span id="InstrumentValue " name="InstrumentValue " class="text-danger" type="double"> </span>
												 <input class="form-control taxtbox" name="InstrumentValue" min="0" type="number" placeholder="Instrument Value" required>
	                                     </div>
	                                       
	                                    
	                                       
	                                        <div class="col-sm-4 form-group">
												<label>Instrument Date</label> 
												<span class="text-danger">* </span>&nbsp; <span id="instrumentdate" name="instrumentdate" class="text-danger"> </span>
												<input class="form-control" name="instdate" id="instdate" type="date" required>
										   </div>
	                                       <div class="col-sm-4 form-group">
											<label class="required">Supporting Document (330kb-1MB)</label>&nbsp; 
											<span id="errRegForm" name="errRegForm" class="text-danger"> </span>
									       <img id="imgPreview"  /><input class="form-control taxtbox" name="SupportingDocument" type="file" accept=".jpg,.jpeg,.png"
									        oninput="validateREGFileType()"  placeholder="Supporting Document" id="SupportingDocument" onkeypress="deleteErrorMsg()" required>
										</div>
										   
	                                     
	                                     
                                     </div> 
                                       
                                   <div class="row">
                                   
                                           <div class="col-sm-4 form-group">
	                                             <label id="IFSC1">IFSC </label>
	                                             <input class="form-control" oninput="this.value = this.value.toUpperCase()" maxlength="11" name="IFSC" type="text"
												placeholder="IFSC Code" id="IFSC"
												onchange="deleteErrorMsg()" >
	                                       </div>
	                                        <div class="col-sm-4 form-group">
	                                             <label id="BankName1">Bank Name</label>
	                                             <input class="form-control taxtbox" name="BankName" id="BankName" min="0" type="text" placeholder="Bank Name" onchange="deleteErrorMsg()" >
	                                       </div>
	                                     
	                                       <div class="col-sm-4 form-group">
	                                             <label id="Branch1">Branch</label>
	                                             <input class="form-control taxtbox" name="Branch" id="Branch" min="0" type="text" placeholder="Branch" onchange="deleteErrorMsg()">
	                                       </div>
	                                      
	                                       
	                                     
	                                       
	                                       
                                    </div>  
                                     
                                        <div class="row">
                                        <div class="col-sm-4 form-group">
												<label id="doshipment">Last Shipment date</label> 
												<input class="form-control" name="dateofship" id="dateofship" placeholder="Date of Shipment" type="date" >
										   </div>
                                         <div class="col-sm-4 form-group">
												<label id="doexpiry">Date of Expiry</label> 
												<input class="form-control" name="dateofexpiry" id="dateofexpiry" placeholder="Date of Expiry" type="date" disabled >
										   </div>
										   
                                   
                                            <div class="col-sm-4 form-group">
	                                             <label id="autoamounta">Auto Revolving Amount</label>
	                                             <input class="form-control taxtbox" name="autorevolvingamount" id="autorevolvingamount" min="0" type="number" placeholder="Auto Revolving Amount" 	>
	                                       </div>
	                                     
	                                      
	                                       
                                    </div>

	                                     <div class="row"> 
                                                <div class="col-sm-12 form-group">
									             <input type="submit" value="changePradeep"class="btn btn-primary" id="submit" onclick="">
									            </div>
									           <!--  <div class="clear">
												  <button type="submit" value="submit" name="subscribe" id="mc-embedded-subscribe" class="submit- btn btn-default" onclick="window.open('https://login.mailchimp.com/signup'), window.location = 'https://google.com'">Submit</button>
											   </div> -->
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
	
	
<script>
document.addEventListener("DOMContentLoaded", function () {
    var dateOfExpiryInput = document.getElementById("dateofexpiry");
    var dateOfShipmentInput = document.getElementById("dateofship");

    dateOfShipmentInput.addEventListener("input", function () {
       
        var dateOfShipment = dateOfShipmentInput.value;

        dateOfExpiryInput.disabled = !dateOfShipment;

        if (!dateOfShipment) {
            dateOfExpiryInput.value = "";
        }
    });

    dateOfExpiryInput.addEventListener("input", function () {
        
        var dateOfExpiry = dateOfExpiryInput.value;
        var dateOfShipment = dateOfShipmentInput.value;

        var isDateValid = !dateOfShipment || new Date(dateOfExpiry) > new Date(dateOfShipment);

        
        if (!isDateValid) {
            dateOfExpiryInput.value = "";
        }
    });


    dateOfExpiryInput.addEventListener("focus", function () {
        var dateOfExpiry = dateOfExpiryInput.value;
        if (dateOfExpiry) {
           
            var formattedDate = new Date(dateOfExpiry).toLocaleDateString("en-GB", {
                day: "2-digit",
                month: "2-digit",
                year: "numeric"
            });

            dateOfExpiryInput.value = formattedDate;
        }
    });
    dateOfExpiryInput.addEventListener("blur", function () {
        var dateOfExpiry = dateOfExpiryInput.value;
        if (dateOfExpiry) {
         
            dateOfExpiryInput.value = new Date(dateOfExpiry).toISOString().split('T')[0];
        }
    });
});
</script>
    
    <script>
        function myFunction() {
            // Your code to be executed when the page loads goes here
           	
      	  $("#doexpiry").hide();
      	  $("#dateofexpiry").hide();
      	  $("#doshipment").hide();
      	  $("#dateofship").hide();
      	  $("#autoamounta").hide();
      	  $("#autorevolvingamount").hide();  
      	
      	  $("#IFSC").hide();
    	  $("#BankName").hide();  
    	  $("#Branch").hide();
      	  $("#IFSC1").hide();  
      	  $("#BankName1").hide();
    	  $("#Branch1").hide();  
    	  
      	 
      	   
        }
    </script>
    <script>
    function deleteErrorMsg(){
    	var F_BANK_IFSC = document.forms["myForm"]["F_BANK_IFSC"].value; 
   		 if(F_BANK_IFSC.length>1){
	       $("#errIFSC").hide();
	    }
   		var F_REG_FORM = document.forms["myForm"]["F_REG_FORM"].value; 
        if(F_REG_FORM.length>1){
       	    $("#errRegForm").hide();
       	}

}
	}
    function allow_alphabets(element){
      let textInput = element.value;
        textInput = textInput.replace(/[^A-Za-z ]+$/gm, ""); 
        element.value = textInput; 
    }
</script>
			<script>
			$(document).ready(function(){
			  // Define a function to fetch and update data
			  function updateData(F_BANK_IFSC) {
			    var len = F_BANK_IFSC.length;
			    if (len == 11) {
			      $.ajax({
			        type: "GET",
			        url: "https://ifsc.razorpay.com/" + F_BANK_IFSC,
			        dataType: "json",
			        processData: false,
			        success: function (data) {
			          // Update the form fields with the fetched data
			          $("#Branch").val(JSON.stringify(data.BRANCH).replace(/\"/g, ""));
			          $("#BankName").val(JSON.stringify(data.BANK).replace(/\"/g, ""));
			        },
			        error: function (jqXHR, exception) {
			          alert("Enter valid IFSC!!!");
			        }
			      });
			    } else if (len > 11) {
			      alert('IFSC Code cannot be more than 11 characters');
			    }
			    
			  }
			
			  // Bind the updateData function to the input event of #IFSC
			  $("#IFSC").on("input", function () {
			    var F_BANK_IFSC = $(this).val();
			    updateData(F_BANK_IFSC);
			  });
			});
			</script>
     
     
    
  
    
      <script type="text/javascript">
      $("#paymenttype").on("change", function() {
    	    var paymenttype = $(this).val();
    	    if (paymenttype === "Letter_of_Credit") {
    	        $('#autorevolvingamount, #autoamounta, #dateofship, #doshipment, #dateofexpiry, #doexpiry, #Branch1, #BankName1, #IFSC1, #Branch, #BankName, #IFSC').show();
    	    } else if (paymenttype === "NEFT/RTGS") {
    	        $('#autorevolvingamount, #autoamounta, #dateofship, #doshipment, #dateofexpiry, #doexpiry, #Branch1, #BankName1, #IFSC1, #Branch, #BankName, #IFSC').hide();
    	    } else if (paymenttype === "Cheque/DD") {
    	        $('#autorevolvingamount, #autoamounta, #dateofship, #doshipment, #dateofexpiry, #doexpiry').hide();
    	        $('#Branch1, #BankName1, #IFSC1, #Branch, #BankName, #IFSC').show();
    	    }
    	    // alert(paymenttype);
    	});
      </script>

   <script>
    function validateREGFileType(){
     var F_REG_FORM = document.getElementById("SupportingDocument").value;
        var idxDot = F_REG_FORM.lastIndexOf(".") + 1;
        var extFile = F_REG_FORM.substr(idxDot, F_REG_FORM.length).toLowerCase();
        if (extFile=="jpg" || extFile=="jpeg" || extFile=="png")
        {
            
        }else{
            alert("Only jpg/jpeg and png files are allowed!");
        }   
    }
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