<%-- <%@page import="java.util.List"%> --%>
<%@page import="java.util.List"%>
<%@page import="java.time.LocalDate"%>
<%@page import="java.math.BigDecimal"%>
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
                <h1 class="page-title">Entry of Confirmation of Claim Settlement Report</h1>
            </div>
            
            <% 
            List<Object>getSettlementid=(List<Object>)request.getAttribute("getSettlementidlist");
          
            %>
            
            
            <div class="page-content fade-in-up">
                <div class="row">
                    <div class="col-md-11">
                        <div class="ibox">
                          <span>${msg}</span>
                            <div class="ibox-body">
                       <form action="saveConfirmationOfClaimSettelment.obj" method="POST" name ="myForm" enctype="multipart/form-data">
                           <div class="child-checkbox" id="disableform">
                                 <div class="row">
                                 
                                   <div class="col-sm-4 form-group">
	                                             <label>Settlement Id</label>
	                                              <span class="text-danger">* </span>&nbsp; <span id="Settlement_Id" name="Settlement_Id" class="text-danger"> </span>
	                                        	 <select name="Settlement_Id1" id="SettlementId1" class="form-control taxtbox" required>
	                                        		
													    <option value="">-Select-</option>
													    <%
													    for (int i = 0; i < getSettlementid.size(); i++) {
													    	 Object[] data =  (Object[])getSettlementid.get(i);
														     BigDecimal bigDecimalValue = (BigDecimal) data[0];
													        int field1 = bigDecimalValue.intValue();
													        String field2 = (String) data[1];
													    %>
													    <option value="<%= field1 %>"><%= field1 %></option>
													    <%
													    }
													    %> 
													</select>
	                                        		
	                                        
                                        </div>
                                         <div class="col-sm-4 form-group">
												<label>Date_of_inspection</label> 
												<span class="text-danger">* </span>&nbsp; <span id="Date_of_inspection" name="Date_of_inspection" class="text-danger"> </span>
												<input class="form-control" name="Dateofinspection" id="Dateofinspection12"  value ="" type="date"  >
										   </div>
                                       <div class="col-sm-4 form-group">
	                                             <label>Contract No.</label>
	                                              <span class="text-danger">* </span>&nbsp; <span id="contractno" name="contractno" class="text-danger"> </span>
	                                        	 <select name="fullcontractno" id="fullcontractno1" class="form-control taxtbox" required>
	                                        		
													    <option value="">-Select-</option>
													     <%
													    for (int i = 0; i < getSettlementid.size(); i++) {
													    	 Object[] data =  (Object[])getSettlementid.get(i);
														     BigDecimal bigDecimalValue = (BigDecimal) data[0];
													        int field1 = bigDecimalValue.intValue();
													        String field2 = (String) data[1];
													    %>
													    <option value="<%= field2 %>"><%= field2 %></option>
													    <%
													    }
													    %> 
													</select>
	                                        		
	                                        
                                        </div>
                               
										
	                                     
                                 </div>
                                  
                                    
                                    <div class="row">
                                    
                                    
                                    
                                            <div class="col-sm-4 form-group">
	                                            <label>Challan No</label> 
	                                            <span class="text-danger">* </span>&nbsp; <span id="Challan_No" name="Challan_No " class="text-danger" > </span>
												 <input class="form-control taxtbox" name="Challan_No1"  id ="ChallanNo1" placeholder="Challan_No" required>
	                                     </div>
	                                     
	                                     <div class="col-sm-4 form-group">
	                                            <label>MR No</label> 
	                                            <span class="text-danger">* </span>&nbsp; <span id="MR_No" name="MR_No " class="text-danger" > </span>
												 <input class="form-control taxtbox" name="MR_No1" id ="MRNo1" value =""  placeholder="MR_No" required>
	                                     </div>
	                                      <div class="col-sm-4 form-group">
	                                            <label>Bale Mark</label> 
	                                            <span class="text-danger">* </span>&nbsp; <span id="Bale_Mark" name="Bale_Mark " class="text-danger" > </span>
												 <input class="form-control taxtbox" name="Bale_Mark1" value =""  id ="BaleMark1" placeholder="Bale_Mark" required>
	                                     </div>
	                                       
	                                    
	                           
	                                     
	                                     
                                     </div> 
                                       
                                   <div class="row">
                                    
                                    
                                         <div class="col-sm-4 form-group">
											<label class="required">Supporting Document (330kb-1MB)</label>&nbsp; 
											<span id="errRegForm" name="errRegForm" class="text-danger"> </span>
									       <img id="imgPreview"  /><input class="form-control taxtbox" name="SupportingDocument" type="file" accept=".jpg,.jpeg,.png"
									        oninput="validateREGFileType()"  placeholder="Supporting Document" id="SupportingDocument" onkeypress="deleteErrorMsg()" required>
										</div>
                                      <div class="col-sm-4 form-group">
	                                            <label>Crop Year</label> 
	                                            <span class="text-danger">* </span>&nbsp; <span id="Crop_Year" name="Crop_Year " class="text-danger" > </span>
												 <input class="form-control taxtbox" name="Crop_Year1" id ="CropYear1" value =""  placeholder="Crop_Year" required>
	                                     </div>
	                                      <div class="col-sm-4 form-group">
	                                            <label>Quality Claim </label> 
	                                            <span class="text-danger">* </span>&nbsp; <span id="Quality_Claim " name="Quality_Claim  " class="text-danger" > </span>
												 <input class="form-control taxtbox" name="Quality_Claim1"  id ="QualityClaim1"  value =""  placeholder="Quality_Claim" required>
	                                     </div>
	                                   </div>  
                                     
                                        <div class="row">
                                         <div class="col-sm-4 form-group">
	                                            <label>Moisture Content</label> 
	                                            <span class="text-danger">* </span>&nbsp; <span id="Moisture_Content" name="Moisture_Content " class="text-danger" > </span>
												 <input class="form-control taxtbox" name="Moisture_Content1"  id ="MoistureContent1" value ="" placeholder="Moisture_Content" required>
	                                     </div>
	                                     
	                                     <div class="col-sm-4 form-group">
	                                            <label>NCV Percentage </label> 
	                                            <span class="text-danger">* </span>&nbsp; <span id="NCV_Percentage " name="NCV_Percentage " class="text-danger" > </span>
												 <input class="form-control taxtbox" name="NCV_Percentage1"   id= "NCVPercentage1" value ="" placeholder="NCV Percentage" required>
	                                     </div>
	                                        <div class="col-sm-4 form-group">
	                                             <label>Quality Settlement</label>
	                                              <span class="text-danger"> </span>&nbsp; <span id="Quality_Settlement" name="Quality_Settlement" class="text-danger"> </span>
	                                        	 
	                                        		 <input class="form-control taxtbox" name="Quality_Settlement"   id="Quality_Settlement1" value ="" placeholder=" Quality_Settlement" required>
	                                    
	                                        
                                        </div>
                                       
	                                      
	                                       
                                    </div>
                                    
                                        <div class="row">
                                         
	                                     
	                                      <div class="col-sm-4 form-group">
	                                             <label>Moisture Settlement</label>
	                                              <span class="text-danger"></span>&nbsp; <span id="Moisture_Settlement" name="Moisture_Settlement" class="text-danger"> </span>
	                                        	 <input class="form-control taxtbox" name="Moisture_Settlement"   id="Moisture_Settlement1" value ="" placeholder="Moisture_Settlement" required>
	                                    
	                                        		
	                                        
                                        </div>
	                                        <div class="col-sm-4 form-group">
	                                             <label>NCV Settlement</label>
	                                              <span class="text-danger"> </span>&nbsp; <span id="NCV_Settlement" name="NCV_Settlement" class="text-danger"> </span>
	                                         <input class="form-control taxtbox" name="NCV_Settlement"   id="NCV_Settlement1" value ="" placeholder=" NCV_Settlement" required>
	                                    
	                                        		
	                                        
                                        </div>
                                        <div class="col-sm-4 form-group">
	                                            <label>Claim Amount</label> 
	                                            <span class="text-danger">* </span>&nbsp; <span id="Claim_Amount" name="Claim_Amount " class="text-danger" > </span>
												<input class="form-control taxtbox" type="text" name="ClaimAmount" id="ClaimAmount1" value="" placeholder="Claim_Amount1" required>
    									</div>
                                       
	                                      
	                                       
                                    </div>
                                    
                                    <div class="row">
                                   
                                   
                                 
	                                       
                                            <div class="col-sm-4 form-group">
	                                            <label>Settlement Amount</label> 
	                                            <span class="text-danger">* </span>&nbsp; <span id="Settlement_Amount" name="Settlement_Amount " class="text-danger" > </span>
												 <input class="form-control taxtbox" name="SettlementAmount"  id="SettlementAmount1" value =""  placeholder="Settlement_Amount1" required>
	                                     </div>
	                                     
	                                     <div class="col-sm-4 form-group">
	                                            <label>Inspection by</label> 
	                                            <span class="text-danger">* </span>&nbsp; <span id="Inspection_by" name="Inspection_by " class="text-danger" > </span>
												 <input class="form-control taxtbox" name="Inspectionby1"   placeholder="Inspection_by" required>
	                                     </div>
	                                     
	                                       
	                                      
	                                       
	                                     
	                                       
	                                       
                                    </div>  
                                     
                                     <!--  For Showing the grade wise jute variety -->
                                                           <div class="row">

                                                                  <span style="font-size: 15px"> Jute Variety Grade wise</span>

                                                           </div>

                                                           <div class="row">

                                                                  <div class="col-sm-3 form-group ">



                                                                        <div class="input-container">
                                                                               <label for="field1">grade 1:</label> <input type="text"
                                                                                     id="g1" name="g1">
                                                                        </div>

                                                                        <div class="input-container">
                                                                               <label for="field2">grade 2:</label> <input type="text"
                                                                                     id="g2" name="g2">
                                                                        </div>

                                                                        <div class="input-container">
                                                                               <label for="field3">grade 3:</label> <input type="text"
                                                                                     id="g3" name="g3">
                                                                        </div>

                                                                        <div class="input-container">
                                                                               <label for="field4">grade 4:</label> <input type="text"
                                                                                     id="g4" name="g4">
                                                                        </div>

                                                                        <div class="input-container">
                                                                               <label for="field5">grade 5:</label> <input type="text"
                                                                                     id="g5" name="g5">
                                                                        </div>

                                                                        <div class="input-container">
                                                                               <label for="field6">grade 6:</label> <input type="text"
                                                                                     id="g6" name="g6">
                                                                        </div>

                                                                  </div>


                                                                  <div class="col-sm-4 form-group">

                                                                        <div class="input-container">
                                                                               <label for="q1">Qty 1:</label> <input type="text" id="q1"
                                                                                     name="q1">
                                                                        </div>

                                                                        <div class="input-container">
                                                                               <label for="q2">Qty 2:</label> <input type="text" id="q2"
                                                                                     name="q2">
                                                                        </div>

                                                                        <div class="input-container">
                                                                               <label for="q3">Qty 3:</label> <input type="text" id="q3"
                                                                                     name="q3">
                                                                        </div>

                                                                        <div class="input-container">
                                                                               <label for="q4">Qty 4:</label> <input type="text" id="q4"
                                                                                     name="q4">
                                                                        </div>

                                                                        <div class="input-container">
                                                                               <label for="q5">Qty 5:</label> <input type="text" id="q5"
                                                                                     name="q5">
                                                                        </div>

                                                                        <div class="input-container">
                                                                               <label for="q6">Qty 6:</label> <input type="text" id="q6"
                                                                                     name="q6">
                                                                        </div>



                                                                  </div>

                                                           </div>

                                                           <!-- End the grade wise -->


                                     

	                                     <div class="row"> 
                                                <div class="col-sm-12 form-group">
									             <input type="submit" value="Submit"class="btn btn-primary" id="submit" onclick="">
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
	<script type="text/javascript">
      
 $(document).ready(function() {
	    $('#fullcontractno1').on('change', function() {
	    var field2Value = $(this).val();
	    alert(field2Value);
	     
	    $.ajax({
	        type: 'GET',
	        url: 'fetchingdatamillrecept.obj',
	        data: { "contractno": field2Value },
	        success: function(data) {
	           alert(data);
	           data = data.replace(/^\[|\]$/g, '');
	           data = data.replace(/^\[|\]$/g, '');
	           var valuesArray = data.split(',');
	           for (var i = 0; i < valuesArray.length; i++) {
	        	    valuesArray[i] = valuesArray[i].replace(/^"|"$/g, '');
	        	}

	           $('#MRNo1').val(valuesArray[0]);
	           $('#BaleMark1').val(valuesArray[1]);
	          
	           $('#CropYear1').val(valuesArray[2]);
	      
	           $('#QualityClaim1').val(valuesArray[3]);
	           $('#MoistureContent1').val(valuesArray[4]);
	           $('#NCVPercentage1').val(valuesArray[5]); 
	           $('#ChallanNo1').val(valuesArray[6]); 

	        },
	        error: function(error) {
	            alert("Error: " + error);
	        }
	    });

	    });
	});

      
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
      <!--  For Fetching the Grade_Composition based on Contract Number -->

       <script type="text/javascript">
             $(document).ready(function() {
                  
                    $('#fullcontractno1').on('change', function() {
                         
                          var selectedOption = $(this).val();
                    

                          $.ajax({
                                 type : 'GET',
                                 url : 'gradecomposition.obj',
                                 data : {
                                       ContractNo : selectedOption
                                 },
                                 success : function(data) {
										  var response = JSON.parse(data);
										  var innerArray1 = response[0];
	                                       var innerArray2 = response[1];
	                                       var innerArray3 = response[2];
	                                       var innerArray4 = response[3];
	                                       var innerArray5 = response[4];
	                                       var innerArray6 = response[5];

                                       var g1 = innerArray1[0];
                                       var q1 = innerArray1[1];

                                       var g2 = innerArray2[0];
                                       var q2 = innerArray2[1];
                                       

                                       var g3 = innerArray3[0];
                                       var q3 = innerArray3[1];

                                       var g4 = innerArray4[0];
                                       var q4 = innerArray4[1];

                                       var g5 = innerArray5[0];
                                       var q5 = innerArray5[1];

                                       var g6 = innerArray6[0];
                                       var q6 = innerArray6[1];

                                       $('#g1').val(g1); 
                                       $('#q1').val(q1);

                                       $('#g2').val(g2);
                                       $('#q2').val(q2);

                                       $('#g3').val(g3);
                                       $('#q3').val(q3);

                                       $('#g4').val(g4);
                                       $('#q4').val(q4);

                                       $('#g5').val(g5);
                                       $('#q5').val(q5);

                                       $('#g6').val(g6);
                                       $('#q6').val(q6);

                                 },
                                 error : function(err) {
                                   
                                       console.error('AJAX request failed: ' + err);
                                 }
                          });
                    });
             });
       </script>

       
      
      	<script type="text/javascript">
      
 $(document).ready(function() {
	    $('#SettlementId1').on('change', function() {
	    var field2Value = $(this).val();
	    alert(field2Value);
	     
	    $.ajax({
	        type: 'GET',
	        url: 'fetchingdatanominactionclaim.obj',
	        data: { "contractno": field2Value },
	        success: function(data) {
	           alert(data);
	           data = data.replace(/^\[|\]$/g, '');
	           data = data.replace(/^\[|\]$/g, '');
	           var valuesArray = data.split(',');
	           for (var i = 0; i < valuesArray.length; i++) {
	        	    valuesArray[i] = valuesArray[i].replace(/^"|"$/g, '');
	        	}
	           
	               // Set the value of the <select> element
	               $('#Quality_Settlement1').val(valuesArray[0]);
	               $('#Moisture_Settlement1').val(valuesArray[1]);
	               $('#NCV_Settlement1').val(valuesArray[2]);
	               $('#SettlementAmount1').val(valuesArray[3]); 
	               $('#ClaimAmount1').val(valuesArray[4]);
	        
	               var dateParts = valuesArray[5].split("-");
	               var formattedDate = dateParts[2] + "-" + dateParts[1] + "-" + dateParts[0];
	               $('#Dateofinspection12').val(formattedDate);
	             
	               $('#Supportingdocument1').val(valuesArray[6]);
	              
	           

	        },
	        error: function(error) {
	            alert("Error: " + error);
	        }
	    });

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