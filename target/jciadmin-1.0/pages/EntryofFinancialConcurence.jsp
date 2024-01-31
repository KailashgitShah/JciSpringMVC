<%-- <%@page import="java.util.List"%> --%>
<%@page import="java.time.LocalDate"%>
<%@page import="java.time.LocalDateTime"%>
<%@page import="com.jci.model.EntryPaymentDetailsModel"%>
<%@page import="com.jci.model.FinancialConcurenceModel"%>
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
                <h1 class="page-title">Entry of Financial Concurence</h1>
            </div>
            <%
			EntryPaymentDetailsModel entryPaymentDetailsModel  = (EntryPaymentDetailsModel) request.getAttribute("entryPaymentDetailsModel");
		    String fetchCont_no = (String) request.getAttribute("parsedstring");
		    String Cont_qty = (String) request.getAttribute("parsedstring2");
		    String issuedate = (String) request.getAttribute("parsed");
		    
	 	     FinancialConcurenceModel financialConcurenceModel  = (FinancialConcurenceModel) request.getAttribute("financialConcurenceModel");
		    Double charge =(Double) (request.getAttribute("cost"));
	 	    
			%>
            <div class="page-content fade-in-up">
                <div class="row">
                    <div class="col-md-11">
                        <div class="ibox">
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
															<input class="form-control" name="FC_Ref_No." id="FC_Ref_No." type="Number" required
													
															>
													</div> 
													
													
				                                      <div class="col-sm-4 form-group">
															<label>FC Issue Date</label> 
															<span class="text-danger">* </span>&nbsp; <span id="FC_Issue_Date" name="FC_Issue_Date" class="text-danger"> </span>
															<input class="form-control" name="FC_Issue_Date" id="FC_Issue_Date" type="date" value=<%= issuedate %> required>
													   </div>
			                                 </div>
			                                    
			                                  
			                                    
			                                    <div class="row">
			                                    
			                                    
			                                    
			                                            <div class="col-sm-4 form-group">
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
			    
			    
			    <!-- <script type="text/javascript">
			    function calculate(refid)
			    {
			    	alert(refid);
			    	
			    }
			    
			    </script> -->
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
			   
			
				
			    function allow_alphabets(element){
			      let textInput = element.value;
			        textInput = textInput.replace(/[^A-Za-z ]+$/gm, ""); 
			        element.value = textInput; 
			    }
			</script>
						<script>
			    // Generate a random number between 0 and 999999 (inclusive)
			    var num = Math.floor(Math.random() * 1000000);
			
			    // Find the input field and set its value to the generated random number
			    var inputField = document.getElementById("FC_Ref_No.");
			        inputField.value = num;
			</script>
			
			
			
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