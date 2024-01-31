<%@page import="com.mashape.unirest.http.options.Option"%>
<%@page import="java.util.List"%>
<%@page import="java.time.LocalDate"%>
<%@page import="java.time.LocalDateTime"%>
<%@page import="com.jci.model.MillRecieptModel"%>
<%@page import="com.jci.model.EntryPaymentDetailsModel"%>
<%@page import="com.jci.model.MillreceiptDto"%>
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
<body class="fixed-navbar"  onload="myFunction()" >
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
                <h1 class="page-title">Entry of Mill Reciept</h1>
            </div>
            
            <% 
          
            List<Object>getdataList1=(List<Object>)request.getAttribute("getdataList1");
		    
		    String date = (String) request.getAttribute("parsed");
		
			 
			%>
         
         
         
         
         
			
            
            <div class="page-content fade-in-up">
                <div class="row">
                    <div class="col-md-11">
                        <div class="ibox">
                          <span>${msg}</span>
                            <div class="ibox-body">
                       <form action="saveentryofMillreciept.obj" method="POST">
                           <div class="child-checkbox" id="disableform">
                                 <div class="row">
                                       <div class="col-sm-4 form-group">
	                                             <label>HO DI </label>
	                                              <span class="text-danger">* </span>&nbsp; <span id="HO_DI_&_Date" name="HO_DI_&_Date" class="text-danger"> </span>
	                                        	<select name="HO_DI_&_Date" id="HODate" class="form-control taxtbox" required>
													   <option value="">-Select-</option>
													    <%
													    for (int i = 0; i < getdataList1.size(); i++) {
													        Object[] data =  (Object[])getdataList1.get(i);
													        String field1 = (String) data[0]; 
													        String field2 = (String) data[1];
													       
													    %>
													    
													       <option value="<%= field2 %>"><%= field1  %></option>
													    <%
													    }
													    %>
													</select>

                                        </div>
                                        
										  <div class="col-sm-4 form-group">
												<label>HO Date</label> 
												<span class="text-danger">* </span>&nbsp; <span id="HO_Date" name="HO_Date1" class="text-danger"> </span>
												<input class="form-control" name="HO_Date" id="HO_Date1"  value="" readonly ="true"  required>
										</div>
		                                       
		                                       
		                                          <div class="col-sm-4 form-group">
												    <label>Challan Qty</label>
												    <input class="form-control taxtbox"  id ="ChallanQty1" name="Challan_Qty" value="" min="0" step="0.01" type="number" placeholder="Challan Qty"  readonly ="true"   required>
												</div>
                                   </div>
                                    
                                   <div class="row">
                                   
                                   <div class="col-sm-4 form-group">
												<label>Vehicle No.</label> 
												<span class="text-danger">* </span>&nbsp; <span id="Vehicle_No." name="Vehicle_No." class="text-danger"> </span>
												<input class="form-control" name="Vehicle_No." id="Vehicle_No" type="text"  value=""  <%-- value="<%=millreceiptDto.getChallan_qty() %>" --%>  readonly ="true"  required>
										</div>
                                      <div class="col-sm-4 form-group">
												<label>Challan No</label> 
												<span class="text-danger">* </span>&nbsp; <span id="Challan_No" name="Challan_No" class="text-danger"> </span>
												<input class="form-control" name="Challan_No" id="Challan_No12"  type="text"    value=""  <%--  value="<%=millreceiptDto.getChallan_no() %>"  --%>  readonly ="true" required>
										</div>
										
										 <div class="col-sm-4 form-group">
												<label>Date of Shipment</label> 
												<span class="text-danger">* </span>&nbsp; <span  name="Date_of_Shipment" class="text-danger"> </span>
												<input class="form-control" name="Date_of_Shipment" id="Date_of_Shipment134"   value=""   readonly ="true" required>
										</div>
                                        
	                                                      
                                    </div>
                                    
                                      <div class="row">
                                   
                                          <div class="col-sm-4 form-group">
	                                             <label>Bale Mark</label>
	                                             <input class="form-control taxtbox" name="Bale_Mark" id ="Bale_Mark"  type="text" placeholder="Bale Mark" value="" <%--  value="<%=millreceiptDto.getBale_mark() %>"  --%>  readonly ="true" required>
	                                       </div>
	                                     
	                                       <div class="col-sm-4 form-group">
	                                             <label>Jute Variety Grade wise </label>
	                                             <input class="form-control taxtbox" name="juteewiseqty"  id="juteewiseqty"   placeholder="Jute Variety Grade wise"  value=""   <%-- value="<%=millreceiptDto.getJute_variety() %>"   --%>readonly ="true"  required>
	                                       </div>
	                                       
	                                       <div class="col-sm-4 form-group">
	                                             <label>Crop Year </label>
	                                             <input class="form-control taxtbox" name="Crop_Year"  id="Crop_Year"   type="text" placeholder="Crop Year"  value="" readonly ="true" required>
	                                       </div>
	                                     
	                                </div>
                            <div class="row">
                                    
	                                       <div class="col-sm-4 form-group">
	                                             <label>MR No</label>
	                                             <input class="form-control taxtbox" name="MR_No" type="Text" placeholder="MR No" required>
	                                       </div>
	                                       
											<div class="col-sm-4 form-group">
												<label>MR Date</label> 
												<span class="text-danger">* </span>&nbsp; <span id="MR_Date" name="MR_Date" class="text-danger"> </span>
												<input class="form-control" name="MR_Date" id="MR_Date1" type="date" required>
										</div>
										<div class="col-sm-4 form-group">
										   <label>Mill Reciept Qty. </label>
	                                             <input class="form-control taxtbox" name="Mill_Reciept_Qty"  type="text" placeholder="Mill_Reciept_Qty." required>
	                                       </div>
	                                        
                                         
	                                       
                                    </div>
                                    <div class="row">
                                   
	                                             
	                                         <div class="col-sm-4 form-group">
	                                             <label>Short Qty  </label>
	                                             <input class="form-control taxtbox" name="Short_Qty" id ="Short_Qty1"  placeholder="Short Qty" value="" required>
	                                       </div>
	                                       <div class="col-sm-4 form-group">
														  <label>Actual Qty</label>
														    <input class="form-control taxtbox" name="Actual_Qty" id ="Actual_Qty1"min="0" step="0.01" type="number" value="" placeholder="Actual Qty" required>
														</div> 
	                                       
										   <div class="col-sm-4 form-group">
	                                             <label>Quality Claim  </label>
	                                             <input type="checkbox" id="enableQualityClaim">
	                                             <select name="Quality_Claim" id="Quality_Claim" class="form-control taxtbox"  disabled>
	                                        		<option value="">-Select-</option>
	                                        		<option value="Quality" >Quality</option>
	                                        		<option value="Quantity" >Quantity</option>
	                                        		<option value="Moisture_Gain" >Moisture Gain</option>
	                                        		<option value="Dust_NCV" > Dust / NCV.</option>
	                                        	</select>
	                                       </div>
                                           
                                   </div>
                                             
                                    <div class="row">
                                    
                                         
	                                        <div class="col-sm-4 form-group">
	                                             <label id="Moisture_Cont">Moisture Content</label>
	                                             <input class="form-control taxtbox"  id ="Moisture_Content" name="MoistureContent12" min="8.0"  step="1.0"  max="40.0"  type="number" placeholder="Moisture_Content" >
	                                      
	                                            
	                                       </div>
	                                       
	                                        <div class="col-sm-4 form-group">
	                                             <label id="NCV_Percent">NCV Percentage</label>
	                                             
	                                              <input class="form-control taxtbox"  id ="NCV_Percentage1" name="NCVPercentage12" min="0.0"  step="0.01"   max="10.0"   type="number" placeholder="NCV_Percentage" >

	                                       </div>
	                                       <div class="col-sm-4 form-group">
	                                             <label id="NCV_Qty34">NCV Qty</label>
	                                             <input class="form-control taxtbox"  id ="NCV_Qty12" name="NCVQty12" min="0"  step="0.01"  type="Text" placeholder="NCV Qty." >
	                                       </div>
	                                       <div class="col-sm-4 form-group" style="display: none;"  >
														  <label "display:none;">Mill  code</label>
														    <input class="form-control taxtbox" name="Millcode2" id ="Millcode1" type="hidden" value="" placeholder="Millcode1" required>
														</div> 
	                                      
												
	                                </div>  
	                                
	                              
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
		
			  var contractdate = $("#Date_of_Shipment134").val();
			  var instdate = $("#HO_Date1").val();
			  var instdate1 = $("#MR_Date1").val();
			 
			  
			  if(contractdate =="" || instdate =="" || instdate1 =="")
				  {
				    alert("Please select mandatory Fields!");
				  }  
		    });
	 });
	
	const dateInput = document.getElementById("Date_of_Shipment");
        dateInput.addEventListener("change", function() {
	    const selectedDate = this.value;
	    const dateParts = selectedDate.split("-");
	    const formattedDate = dateParts[2] + "-" + dateParts[1] + "-" + dateParts[0];
        document.getElementById("Date_of_Shipment").textContent = formattedDate;
	});
  </script>
    
    <script>
  $(document).ready(function() {
    const checkbox = $('#enableQualityClaim');
    const qualityClaimSelect = $('#Quality_Claim');
    checkbox.change(function() {
      if (checkbox.is(':checked')) {
        qualityClaimSelect.prop('disabled', false);
      } else {
        qualityClaimSelect.prop('disabled', true);
      }
    });
  });
 </script>

<script type="text/javascript">
      
 $(document).ready(function() {
	    $('#HODate').on('change', function() {
	    var field2Value = $(this).val();
	   
	      $.ajax({
	            type: 'GET',
	            url: 'fetchingdata.obj',
	            data: { "contractno": field2Value },
	            success: function(data) {
	            	alert(data);
	            	
	            	var data1 = JSON.parse(data);
	                var Date_of_shipment = data1.Date_shipment;
	                var mill = data1.Mill_id;
	                alert(mill);
	                var DI_Date = data1.Ho_date;
	              
	                
	                var date = new Date(Date_of_shipment);
                    var month = (date.getMonth() + 1).toString().padStart(2, '0'); 
	                var day = date.getDate().toString().padStart(2, '0');
	                var year = date.getFullYear();
	                var formattedDate = day + '/' + month + '/' + year;
	              
	                
	                var date1 = new Date(DI_Date);
                    var month1 = (date1.getMonth() + 1).toString().padStart(2, '0'); 
	                var day1 = date1.getDate().toString().padStart(2, '0');
	                var year1 = date1.getFullYear();
	                var formattedDate1 = day1 + '/' + month1 + '/' + year1;
	                
	                $('#Challan_No12').val(data1.Challan_no);
	                $('#Date_of_Shipment134').val(formattedDate); 
	               /*  $('#Date_of_Shipment134').val(Date_of_shipment); */
	                 $('#Vehicle_No').val(data1.Vehicle_no);
	                 $('#Bale_Mark').val(data1.Bale_mark);
	                 $('#juteewiseqty').val(data1.Jute_variety);
	                 $('#Crop_Year').val(data1.Crop_year); 
	                 $('#HO_Date1').val(formattedDate1);
	                 $('#ChallanQty1').val(data1.Challan_qty);
	                 $('#Millcode1').val(data1.Mill_id);
	               
	                 $('#Short_Qty1').val(data1.Actual_qty);
	                 $('#Actual_Qty1').val(data1.Short_qty);
	                 
	            }
	             
	        }); 
	    });
	});

      
      </script> 
 
 
 
 <script>
        function myFunction() {
            // Your code to be executed when the page loads goes here
           	
      	   $("#Moisture_Cont").hide();
      	  $("#Moisture_Content").hide();
      	   $("#NCV_Percent").hide();
      	  $("#NCV_Percentage1").hide();
      	  
      	   $("#NCV_Qty34").hide();
      	  $("#NCV_Qty12").hide();  
      	 
      	   
        }
    </script>
<script>
$(document).ready(function() {
  $("#Quality_Claim").on("change", function() {
    var selectedOption = $(this).val();
    
    if (selectedOption === "Dust_NCV") {
 
        $('#NCV_Qty34, #NCV_Percent, #NCV_Percentage1, #NCV_Qty12').show();
        $('#Moisture_Content, #Moisture_Cont').hide();
      }
    
    else if (selectedOption === "Moisture_Gain") {
      $('#Moisture_Content, #Moisture_Cont').show();
      $('#NCV_Qty34, #NCV_Percent, #NCV_Percentage1, #NCV_Qty12').hide();
    } 
    
     else {
      $('#Moisture_Content, #Moisture_Cont, #NCV_Percent, #NCV_Qty34, #NCV_Percentage1, #NCV_Qty12').hide();
    }
  });
});
</script>



		   -->
    
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