<<<<<<< HEAD
<%@page import="java.util.List"%> 
<%@page import="java.math.BigInteger"%> 
<%@page import="java.math.BigDecimal"%> 
<%@page import="java.math.RoundingMode"%> 
=======
<%-- <%@page import="java.util.List"%> --%>
>>>>>>> 8b90dcd314e47ac7172531e18ad935456d7e36f9
<%@page import="java.time.LocalDate"%>
<%@page import="java.time.LocalDateTime"%>
<%@page import="com.jci.model.EntryPaymentDetailsModel"%>
<%@page import="com.jci.model.FinancialConcurenceModel"%>
<%@page import="java.time.format.DateTimeFormatter"%>
<<<<<<< HEAD
<%@ page import="java.util.Date" %>
<%@ page import="java.sql.Timestamp" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.Locale" %>
=======
>>>>>>> 8b90dcd314e47ac7172531e18ad935456d7e36f9
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
<<<<<<< HEAD
                <h1 class="page-title">Issue of Financial Concurence</h1>
=======
                <h1 class="page-title">Entry of Financial Concurence</h1>
>>>>>>> 8b90dcd314e47ac7172531e18ad935456d7e36f9
            </div>
            <%
			EntryPaymentDetailsModel entryPaymentDetailsModel  = (EntryPaymentDetailsModel) request.getAttribute("entryPaymentDetailsModel");
		    String fetchCont_no = (String) request.getAttribute("parsedstring");
		    String Cont_qty = (String) request.getAttribute("parsedstring2");
		    String issuedate = (String) request.getAttribute("parsed");
<<<<<<< HEAD
		    String paymentDueDate = (String) request.getAttribute("paymentDueDate");
		    Object instrumentvalue =request.getAttribute("instrumentvalue");
		    Object instrumentDateObject = request.getAttribute("instrumentDate");
		    
		    Date instrumentDate1 = (Date) instrumentDateObject;
	        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy"); // Change the format as needed
	        String formattedInstrumentDate = dateFormat.format(instrumentDate1);
	        
		    String ContractValue = (String) request.getAttribute("ContractValue");
		    Double qtyallowed = (Double) request.getAttribute("qtyallowed");
		    int Payment_id = (int) request.getAttribute("Payment_id");
		    String  fcref_no2 = (String) request.getAttribute("fcref_no1");
		  
		    
		  
        /*    out.println(instrumentvalue);
            out.println(instrumentDate1); 
            */
           
		    FinancialConcurenceModel financialConcurenceModel  = (FinancialConcurenceModel) request.getAttribute("financialConcurenceModel");
		    BigInteger charge =(BigInteger) (request.getAttribute("cost"));
		    out.println(Payment_id);
		    
		
		    
		    
		   
		  
		     BigDecimal contractValueBigInt = new BigDecimal(String.valueOf(ContractValue));
		     BigDecimal instrumentValueBigInt = new BigDecimal(String.valueOf(instrumentvalue)); 
		   


		    BigDecimal qtdsub = contractValueBigInt.subtract(instrumentValueBigInt);

		    BigDecimal contractqty = new BigDecimal(String.valueOf(Cont_qty));
		    BigDecimal qtdiv = contractValueBigInt.divide(contractqty,2, RoundingMode.HALF_UP);
		  
		    BigDecimal qtdivtotal = qtdsub.divide(qtdiv,2, RoundingMode.HALF_UP); 
		    
	 	    
=======
		    
	 	     FinancialConcurenceModel financialConcurenceModel  = (FinancialConcurenceModel) request.getAttribute("financialConcurenceModel");
		    Double charge =(Double) (request.getAttribute("cost"));
>>>>>>> 8b90dcd314e47ac7172531e18ad935456d7e36f9
	 	    
			%>
            <div class="page-content fade-in-up">
                <div class="row">
                    <div class="col-md-11">
                        <div class="ibox">
<<<<<<< HEAD
                          <span id="flashMessage">${msg}</span>
                            <div class="ibox-body">
                       <form action="saveFinancialConcurence.obj" method="POST" name ="myForm" >
                           <div class="child-checkbox" id="disableform">
                                       
=======
                          <span>${msg}</span>
                            <div class="ibox-body">
                       <form action="saveFinancialConcurence.obj" method="POST" name ="myForm" >
                           <div class="child-checkbox" id="disableform">
                                       <div class="col-4">
											    <div class="form-check mb-4">
											      <input class="form-check-input" type="checkbox" id="inlineFormCheck" >
											      
											       <label class="form-check-label" for="inlineFormCheck">
											        Carrying cost
											      </label> 
											    </div>
											  </div>
>>>>>>> 8b90dcd314e47ac7172531e18ad935456d7e36f9
			                                  <div class="row">
			                                       <div class="col-sm-4 form-group">
				                                             <label>Contract No.</label>
				                                              <span class="text-danger">* </span>&nbsp; <span id="contractno" name="contractno" class="text-danger"> </span>
				                                        	  <input name="fullcontractno" id="fullcontractno" class="form-control taxtbox"
				                                        	    value=<%= fetchCont_no %>  readonly="true" required>
				                                        	
				                                        		
			                                        </div>
					                                       
			                                         <div class="col-sm-4 form-group">
															<label>FC Ref No. </label> 
															<span class="text-danger">* </span>&nbsp; <span id="FC_Ref_No. " name=FC_Ref_No. class="text-danger"> </span>
<<<<<<< HEAD
															<input class="form-control" name="FC_Ref_No." id="FC_Ref_No." value="<%=fcref_no2 %>" readonly ="readonly" required
=======
															<input class="form-control" name="FC_Ref_No." id="FC_Ref_No." type="Number" required
>>>>>>> 8b90dcd314e47ac7172531e18ad935456d7e36f9
													
															>
													</div> 
													
													
				                                      <div class="col-sm-4 form-group">
															<label>FC Issue Date</label> 
															<span class="text-danger">* </span>&nbsp; <span id="FC_Issue_Date" name="FC_Issue_Date" class="text-danger"> </span>
															<input class="form-control" name="FC_Issue_Date" id="FC_Issue_Date" type="date" value=<%= issuedate %> required>
													   </div>
			                                 </div>
			                                    
			                                  
			                                    
<<<<<<< HEAD
			                                    
			                                            <div class="row">
=======
			                                    <div class="row">
>>>>>>> 8b90dcd314e47ac7172531e18ad935456d7e36f9
			                                    
			                                    
			                                    
			                                            <div class="col-sm-4 form-group">
<<<<<<< HEAD
				                                            <label>Contract PaymentDue  Date </label> 
				                                            <span class="text-danger">* </span>&nbsp; <span id="Contract_PaymentDue_Date " name="Contract_PaymentDue_Date " class="text-danger" >   </span>
															 <input class="form-control taxtbox" name="Contract_PaymentDue_Date" id ="Contract_PaymentDue_Date"  value=<%= paymentDueDate %>  placeholder="Contract_PaymentDue_Date" readonly="true">
				                                     </div>
				                                  <%--    <div class="col-sm-4 form-group">
				                                            <label>Instrument type </label> 
				                                            <span class="text-danger">* </span>&nbsp; <span id="Instrument_type" name="Instrument_type" class="text-danger" > </span>
															 <input class="form-control taxtbox" name="Instrument_type" id ="Instrument_type"  value=<%= paymentType %> placeholder="Instrument_type"  readonly="true" >
				                                     </div>  --%>
				                                       <div class="col-sm-4 form-group">
				                                            <label>Instrument Date </label> 
				                                            <span class="text-danger">* </span>&nbsp; <span id="Instrument_Date" name="Instrument_Date " class="text-danger" > </span>
															 <input class="form-control taxtbox" name="Instrument_Date" id ="Instrument_Date"  value=<%= formattedInstrumentDate %> placeholder="Instrument_Date"  readonly="true" >
				                                     </div>  
				                                       <div class="col-sm-4 form-group">
					                                            <label>Remarks</label> 
					                                            <span class="text-danger">* </span>&nbsp; <span id="Remarks" name="Remarks" class="text-danger" type="varchar"> </span>
																 <input class="form-control taxtbox" name="Remarks1" id ="Remarks"  type="Remarks" placeholder="Remarks"  required>
					                                     </div>
				                                     
			
                                                </div>
				                                      
			                                    <div class="row">
			                                    
			                                    	       <div class="col-sm-4 form-group">
															    <label>Days Difference</label>
															    <span class="text-danger">*</span>&nbsp;<span class="text-danger"></span>
															    <input class="form-control taxtbox" name="Days_Diffrence" id="DaysDiffrencetotal" value="<%= charge %>" placeholder="Days_Diffrence">
															    <span id="error-message" class="text-danger"></span>
															</div>
				                                            <div class="col-sm-4 form-group">
					                                            <label>Contracted Qty</label> 
					                                            <span class="text-danger">* </span>&nbsp; <span id="Contracted_Qty. " name="Contracted_Qty. " class="text-danger" type="double"> </span>
																 <input class="form-control taxtbox" name="Contracted_Qty." id ="Contracted_Qty." min="0" type="double" placeholder="Qty Allowed" value=<%= Cont_qty %>  readonly="true" required>
					                                     </div>
					                       						<div class="col-sm-4 form-group">
																	    <label>Qty. Allowed ( max Allowed =  <%=qtdivtotal %> )</label>
																	    <span class="text-danger">*</span>
																	    <span id="Shipment_Value" class="text-danger"></span>
																	    <input class="form-control taxtbox" name="Shipment_Value1" id="Shipment_Value12"  min="0" step="1" pattern="\d+" type ="number" placeholder="Qty. Allowed" required oninput="validateAmount();calculateGST();">
																	    <div id="errorMessage" style="color: red; display: none;">Amount exceeds the allowed limit!</div>
																	</div>
																

											
			                                    
			                                    
				                                    </div>
				                      				    <div class="row">
				                      				    
				                          
				                          							<div class="col-sm-4 form-group">
																	    
																	    <div class="form-check mb-4">
																	        <input class="form-check-input me-2" type="checkbox" id="inlineFormCheck">
																	        <label class="form-check-label" for="inlineFormCheck">
																	            Carrying cost 
																	        </label> 
																	    
																	
																	<div class="col-sm-15" id="carryingCostFormGroup"
																			style="display: none;">
																			<!-- <label>Carrying cost Charged</label> --> <input
																				class="form-control taxtbox" name="SGST_Amt1" id="SGST_Amt"
																				min=0 step=0.01 placeholder="Carrying cost Charged">
																		</div> 
																		
																		
																		<div class="col-sm-15" "
																			style="display: none;">
																			 <input
																				class="form-control taxtbox" name="Payment_id" id="Payment_id"
																				value=<%=Payment_id %> placeholder="Carrying cost Charged">
																		</div> 
																		</div>
																		</div>
											
											
																						
											
										</div>
			
									
=======
				                                            <label>Contracted Qty.</label> 
				                                            <span class="text-danger">* </span>&nbsp; <span id="Contracted_Qty. " name="Contracted_Qty. " class="text-danger" type="double"> </span>
															 <input class="form-control taxtbox" name="Contracted_Qty." id ="Contracted_Qty." min="0" type="double" placeholder="Qty Allowed" value=<%= Cont_qty %> readonly="true" required>
				                                     </div>
			                                    
			                                           <div class="col-sm-4 form-group">
				                                            <label> Qty. Allowed</label> 
				                                            <span class="text-danger">* </span>&nbsp; <span id="QtyAllowed " name="QtyAllowed " class="text-danger" type="double"> </span>
															 <input class="form-control taxtbox" name="QtyAllowed" id ="QtyAllowed"  min="0" type="double" placeholder="Qty Allowed" required>
				                                     </div>
				                                    <div class="col-sm-4 form-group" id="carryingCostFormGroup" style="display: none;">
														  <label>Carrying cost Charged</label>
														  <span class="text-danger">*</span>&nbsp;
														  <span id="Carrying_cost" name="Carrying_cost" class="text-danger"></span>
														  <input class="form-control" name="Carrying_cost" id="Carrying_cost" type="number" min="0"  value= <%= charge %>  required>
														</div> 
				                                    </div> 
				                                      
>>>>>>> 8b90dcd314e47ac7172531e18ad935456d7e36f9
			                                       
			                                        
				                                     <div class="row"> 
			                                                <div class="col-sm-12 form-group">
<<<<<<< HEAD
												             <input type="submit"  value="Submit"class="btn btn-primary" id="submit">
=======
												             <input type="submit" value="Submit"class="btn btn-primary" id="submit">
>>>>>>> 8b90dcd314e47ac7172531e18ad935456d7e36f9
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
			    
			    
			    <!-- <script type="text/javascript">
			    function calculate(refid)
			    {
			    	alert(refid);
			    	
			    }
			    
			    </script> -->
			     <script type="text/javascript">
<<<<<<< HEAD
					$(document).ready(function(){
					    function validateForm() {
					        var contractdate = $("#contractdate").val();
					        var Days_Diffrence = $("#DaysDiffrencetotal").val();
					       
					        var instdate = $("#instdate").val();
					        var paymenttype = $("#paymenttype").val();
					        var contQty = parseFloat($("#Shipment_Value12").val()); 
					        var contQty1 = parseFloat(<%= Cont_qty %>);
					        
					        if (contractdate === "" || instdate === "") {
					            alert("Please select mandatory Fields!");
					            return false;
					        }
					        if (contQty > contQty1) {
					            alert("Please give lesser value than contract Qty");
					            return false;
					        }
					        if (Days_Diffrence > 35) {
					            alert("Please give lesser value than 35");
					            return false;
					        }
					        if (paymenttype === "letterofcredit") {
					            var dateofship = $("#dateofship").val();
					            var dateofexpiry = $("#dateofexpiry").val();
					            if (dateofship === "" || dateofexpiry === "") {
					                alert("Please select mandatory Fields!");
					                return false;
					            }
					        }
					        
					        return true; // Form is valid, allow submission
					    }
					});
					</script>
					
					
					<script>
    window.onload = function() {
        document.getElementById("submit").addEventListener("click", function(event) {
            var daysDifferenceValue = parseInt(document.getElementById("DaysDiffrencetotal").value);

            if (daysDifferenceValue > 35) {
                // Show error message or take any other action
                alert("Days Difference should not exceed 35.");
                event.preventDefault(); // Prevent form submission
            }
            calculateGST();
        });
    };
</script>

				
	   <script>
		function calculateGST() {
			
			var shipmentValue = parseFloat(document
					.getElementsByName("Shipment_Value1")[0].value);
			 var charge = parseFloat(document.getElementById("DaysDiffrencetotal").value);

			var contQty = <%= Cont_qty %>;
              if(shipmentValue>contQty){
            	  alert("Qty allowed exceed the limit of contracted qty");
            	  return false;
              }
              
			
			if (!isNaN(shipmentValue)) {
				
			
				var sgstAmt = (charge  * 70) * shipmentValue;
				document.getElementById("SGST_Amt").value = sgstAmt.toFixed(2);
				
				
			}
			return true; 
		}
	</script>
	
	<script>
	
	function validateAmount() {
	    var inputValue = parseFloat(document.getElementById("Shipment_Value12").value);
	  
	     var maxAllowedAmount = <%=qtdivtotal%>; 

	    var errorMessageElement = document.getElementById("errorMessage");

	    if (inputValue > maxAllowedAmount) {
	        errorMessageElement.style.display = "block";
	    } else {
	        errorMessageElement.style.display = "none";
	    }
	  
	}

	
	
	
	</script>
=======
			    
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
>>>>>>> 8b90dcd314e47ac7172531e18ad935456d7e36f9
		
			    <script>
			   
			
				
			    function allow_alphabets(element){
			      let textInput = element.value;
			        textInput = textInput.replace(/[^A-Za-z ]+$/gm, ""); 
			        element.value = textInput; 
			    }
<<<<<<< HEAD
		</script>
						<!-- <script>
=======
			</script>
						<script>
>>>>>>> 8b90dcd314e47ac7172531e18ad935456d7e36f9
			    // Generate a random number between 0 and 999999 (inclusive)
			    var num = Math.floor(Math.random() * 1000000);
			
			    // Find the input field and set its value to the generated random number
			    var inputField = document.getElementById("FC_Ref_No.");
			        inputField.value = num;
			</script>
<<<<<<< HEAD
			  -->
			
			
		
			
			
			<!-- 	<script>
				
				$(document).ready(function() {
				    // Get references to the checkbox and form group elements
				    const checkbox = $('#inlineFormCheck');
				    const carryingCostFormGroup = $('#carryingCostFormGroup');

				    // Add an event listener to the checkbox
				    checkbox.change(function() {
				        // Assuming DaysDiffrencetotal is defined somewhere else
				        if (checkbox.is(':checked')) {
				            carryingCostFormGroup.show();
				        } else {
				            carryingCostFormGroup.hide();
				        }
				    });
				});

				</script>  -->
				
				<script>
				
				$(document).ready(function() {
				   
				    const checkbox = $('#inlineFormCheck');
				    const carryingCostFormGroup = $('#carryingCostFormGroup');
				    const carryingCostInput = $('#SGST_Amt');

				    checkbox.change(function() {
				        if (checkbox.is(':checked')) {
				            
				            let calculatedValue = calculateValue(); 
				            
				            carryingCostInput.val(calculatedValue);
				            carryingCostFormGroup.show();
				        } else {
				         
				            carryingCostFormGroup.hide();
				        }
				    });

				  
				    function calculateValue() {
				      
				        return 10; 
				    }
				});

				</script>
				
				
				

				
				
				
							
							
							<script>
    $(document).ready(function(){
      
        setTimeout(function(){
            $('#flashMessage').fadeOut('slow');
        }, 3000); ded
    });
</script>
=======
			
			
			
				<script>
				
				  $(document).ready(function() {
				    // Get references to the checkbox and form group elements
				    const checkbox = $('#inlineFormCheck');
				    const carryingCostFormGroup = $('#carryingCostFormGroup');
				    
				    // Add an event listener to the checkbox
				    checkbox.change(function() {
				      if (checkbox.is(':checked')) {
				        carryingCostFormGroup.show();
				      } else {
				        carryingCostFormGroup.hide();
				      }
				    });
				  });
				</script>
							
>>>>>>> 8b90dcd314e47ac7172531e18ad935456d7e36f9
					 	 

					    
			  
			    
			  
				    <!-- END PAGA BACKDROPS-->
			    <!-- CORE PLUGINS-->
			    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
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