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
#milldetailsTable {
    display: none; 
}
#childTable {
    display: none; 
}

 .table-cell {
   
    width: 150px;
    height: 20px;
    
} 
 .table1-cell {
   
    width: 150px;
    height: 20px;
    
}
.table4-cell .btn {
    min-width: 100px;
    height: 25px; /* Adjust the width as needed */
}

 .table3-cell {
   
    width: 80px;
    height: 10px;
    
}
 .form-check-label {
        display: inline-block;
    }
 
#childTable {
    width: 100%; /* Ensure the table takes the full width */
    table-layout: fixed; /* Fix the table layout */
}
.table-container {
    overflow-x: auto;
    width: 100%;
    max-width: 100%;
    border: 1px solid #ccc; /* Optional: Add a border for better visibility */
}

.table {
    width: 100%;
    white-space: nowrap; /* Prevents text from wrapping */
    border-collapse: collapse; /* Prevents text from wrapping */
}
.table3-cell {
  width: 80px; /* Adjust width as needed */
  height: 30px; /* Adjust height as needed */
  position: relative; /* Position relative for absolute positioning of inputs */
}

.table3-cell input[type="checkbox"],
.table3-cell input[type="number"] {
  position: absolute; /* Position absolute to overlay inputs */

  margin-left: 5px; /* Adjust horizontal spacing */
}

.table3-cell input[type="checkbox"] {
  right: -30px; /* Adjust horizontal position for checkbox */
}

/* .table3-cell input[type="number"] {
  left: calc(100% + 5px); /* Adjust horizontal position for number input */
}
 */








.colored-cell {
    color: green; 
    
}

 .colored-cell:hover {
    
    color: blue; 
  }
  
  .form-check-input {
        margin-right: 10px; 
        vertical-align: middle; 
    }

.alert {
        padding: 10px;
        margin-bottom: 20px;
        border: 1px solid transparent;
        border-radius: 4px;
        /* Match width and height */
        width: 100%;
        height: 100%;
    }

    .alert-info {
        color: #31708f;
        background-color: #d9edf7;
        border-color: #bce8f1;
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
          
            String millName=(String)request.getAttribute("millName");
            String hoDate=(String)request.getAttribute("hoDate");
            String contractNo=(String)request.getAttribute("contractNo");
           
            String actualQty=(String)request.getAttribute("actualQty");
          
            String shortQty=(String)request.getAttribute("shortQty");
            String millcode=(String)request.getAttribute("millcode");
            
            String date = (String) request.getAttribute("parsed");
		%>
          <div class="page-content fade-in-up">
                <div class="row">
                    <div class="col-md-11">
                        <div class="ibox">
                          <span id="flashMessage">${msg}</span>
                            <div class="ibox-body">
                       <form action="saveentryofMillreciept.obj" method="POST">
                           <div class="child-checkbox" id="disableform">
                                 <div class="row">
                                  
                                       <div class="col-sm-4 form-group">
												<label>Mill name</label> 
												<span class="text-danger">* </span>&nbsp; <span id="Mill_name" name="MR_Date" class="text-danger"> </span>
												<input class="form-control" name="Mill_name" id="Mill_name" value="<%=millName %>"  readonly="readonly" required>
										</div>
                                        
                                        <div class="col-sm-4 form-group">
												<label>HO_DINO</label> 
												<span class="text-danger">* </span>&nbsp; <span id="MR_Date" name="MR_Date" class="text-danger"> </span>
												<input class="form-control" name="HO_DINO" id="HO_DINO1"  value="<%=hoDate %>"  readonly="readonly" required>
										</div>
										 <div class="col-sm-4 form-group">
												<label>Di_date</label> 
												<span class="text-danger">* </span>&nbsp; <span id="MR_Date" name="MR_Date" class="text-danger"> </span>
												<input class="form-control" name="diDate1" id="diDate"  value="" readonly="readonly" required>
										</div>
										 
                                     </div>
                                     
                                      <div class="row">
                                      
                                       <div class="col-sm-4 form-group">
												<label>Challan no</label> 
												<span class="text-danger">* </span>&nbsp; <span id="challanno2" name="challanno3" class="text-danger"> </span>
												<input class="form-control" name="challanno1" id="challanno4" value="<%=contractNo %>" readonly="readonly" required>
										</div>
                                       <div class="col-sm-4 form-group">
												<label>Date of Shipment</label> 
												<span class="text-danger">* </span>&nbsp; <span id="MR_Date" name="MR_Date" class="text-danger"> </span>
												<input class="form-control" name="dateOfShipmentValue1" id="dateOfShipmentValue" value="" readonly="readonly" required>
										</div>
                                       <div class="col-sm-4 form-group">
												<label>Vehicle no</label> 
												<span class="text-danger">* </span>&nbsp; <span id="Mill_name" name="MR_Date" class="text-danger"> </span>
												<input class="form-control" name="vehicleNo1" id="vehicleNo" value="" readonly="readonly" required>
										</div>
                                        
                                       
										 
                                     </div>
                                     
                                    <!--    <div class="row">
                                         <div class="col-sm-4 form-group">
												<label>Invoice Qty </label> 
												<span class="text-danger">* </span>&nbsp; <span id="InvoiceQty" name="InvoiceQty" class="text-danger"> </span>
												<input class="form-control" name="InvoiceQty" id="InvoiceQty1"  value="" readonly="readonly"required>
										</div>
                                     <div class="col-sm-4 form-group">
												<label>Actual Qty</label> 
												<span class="text-danger">* </span>&nbsp; <span id="MR_Date" name="MR_Date" class="text-danger"> </span>
												<input class="form-control" name="actualqty1" id="actualqty"  value="" readonly="readonly" required>
										</div> -->
                                     
							
                                       
                                  
                                     
                                 <div class="row">
                                
	                                       <div class="col-sm-4 form-group">
										        <label>MR No</label>
										        <span class="text-danger">*</span>&nbsp;
										        <span id="MR_N" name="MR_dante" class="text-danger"></span>
										        <input class="form-control" name="MR_No1" id="MR_No" type="text" maxlength="16"
										            oninput="this.value = this.value.toUpperCase();validateInstrumentNo(this);" pattern="[A-Za-z0-9/-]*"
										            title="Only alphanumeric characters, slashes, and hyphens are allowed" required>
										    </div>
	                                       
											<div class="col-sm-4 form-group">
												<label>MR Date</label> 
												<span class="text-danger">* </span>&nbsp; <span id="MR_Date" name="MR_Date" class="text-danger"> </span>
												<input class="form-control" name="MR_Date1" id="MR_Date1" type="date" required>
										</div>
										<div class="col-sm-4 form-group">
												<label>Mill Receipt Qty</label> 
												<span class="text-danger">* </span>&nbsp; <span id="Mill_receiptQty" name="Mill_receiptQty" class="text-danger"> </span>
												<input class="form-control" name="Mill_receiptQty1" id="Mill_receiptQty" type="double" required>
										</div>
                                 </div>
                                 
                                  <div class="row">
                                <div class="col-sm-4 form-group">
												<label>Contractno</label> 
												<span class="text-danger">* </span>&nbsp; <span id="Contractno3" name="Contractno4" class="text-danger"> </span>
												<input class="form-control" name="Contractno" id="Contractno12"  value="" required>
										</div>
                                 </div>
								
								
						
								  <div class="table-container">
								  <table id="childTable1" name="chilnametable1" class="table table-bordered">
											    <thead class="thead-light">
											        <tr>
											           
											             <th>Bale Mark</th>
											              <th>Jute_variety</th>
											              <th>Jute_grade</th>
											              <th>Crop_year</th>
											              <th>Invoice qty</th>
											              
											              <th> Actual Qty</th>
											               <th> No of Bales</th>
											             <!--  <th>claim </th>
											              <th>Claim Type </th>
											              <th> </th> -->
											              <th>Quality Claim Percentage</th>
											             <!--  <th>Quality Claim Value</th> -->
											               <th> Moisture Content</th>
											           <!--   <th> Moisture Value</th> -->
											              <th> Ncv percent</th>
											              <th> Ncv Qty</th>
											            <!--   <th> Ncv Value</th> -->
											               <th>Dust percent </th>
											              <th> Dust Qty</th>
											           <!--    <th> Dust Value</th> -->
											             <th> </th>
											              <th> Claim Ammount</th>
											            <!--  <th>
													        <div class="form-check">
													            
													           
													           <label class="form-check-label" for="checkNcvPercentage" >Ncv percent &nbsp; &nbsp;&nbsp; <input class="form-check-input" type="checkbox"  id="checkNcvPercentage"></label>
													        </div>
													      </th>
													      <th>
													        <div class="form-check">
													         
													           
													            <label class="form-check-label" for="checkNcvQty">Ncv Qty &nbsp; &nbsp;&nbsp; <input class="form-check-input" type="checkbox"   id="checkNcvQty"></label>
													        </div>
													      </th> -->
											             
											            
											             
											             
											           
											        </tr>
											    </thead>
											    <tbody>
											        <!-- Data rows will be dynamically added here -->
											    </tbody>
											</table>
											</div>
											
                                   
                             
                           
                                 
                                             
                                    <div class="row">
                                    <div class="col-sm-2 form-group" style="display: none;">
												    <label "display:none;">MIllCode</label> <span
													class="text-danger">* </span>&nbsp;  <input
													type="hidden" class="form-control" name="millcode"
													id="millcode1" value="" readonly="readonly">
											</div>
											  <div class="col-sm-2 form-group"  style= "display:none;">
												    <label "display:none;">firstloop</label> <span
													class="text-danger">* </span>&nbsp;  <input
													 class="form-control" name="firstloop"
													id="firstloop1" value="" readonly="readonly">
											</div>
										 <div class="col-sm-2 form-group" style= "display:none;" >
												    <label  "display:none;" >rowindex </label> <span
													class="text-danger">* </span>&nbsp;  <input
													class="form-control" name="rowindex2"
													id="rowindex2" value="" readonly="readonly">
											</div>
	                                      
												
	                                </div>  
	                                
	                              
                                    <div class="row">
                                      	 
                                    	
                                                <div class="col-sm-12 form-group">
									             <input type="submit" value="Submit"class="btn btn-primary" id="submit">
									            <!--  <input type="button" value="Back" class="btn btn-primary" id="backButton">
												 -->	
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
        function validateInstrumentNo(input) {
        	  var pattern = /^[A-Za-z0-9/-]*$/; // Pattern to allow alphanumeric characters, slashes, and hyphens
        	    var inputValue = input.value; // Get the input value

        	    if (!pattern.test(inputValue)) {
        	        input.setCustomValidity("Only alphanumeric characters, slashes (/), and hyphens (-) are allowed.");
        	        document.getElementById("MR_N").textContent = "Only alphanumeric characters, slashes, and hyphens are allowed"; 
        	        input.value = inputValue.slice(0, -1);// Display error message near the input
        	    } else {
        	        input.setCustomValidity("");
        	        document.getElementById("MR_N").textContent = ""; // Clear error message if input is valid
        	    } // Update input value to uppercase
        }
    </script>
    
 <!--    <script>
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
  -->

 <script>
 $(document).ready(function() {
	    // Use event delegation for dynamically added buttons
	    $(document).on('click', '#backButton', function() {
	        window.history.back();
	    });
	});

</script>

<script>
    document.addEventListener('DOMContentLoaded', function() {
        // Get references to the date input fields
        var instDateInput = document.getElementById('MR_Date1');
   
        var currentDate = new Date();
        var currentDateString = currentDate.toISOString().split('T')[0];
        instDateInput.setAttribute('max', currentDateString);
 
    });
</script> 




<script type="text/javascript">

var resultsArray = [];
var grade1 = [];
var grade2 = [];
var grade3 = [];
var grade4 = [];
var grade5 = [];
var grade6 = [];
var some = [];
var claimAmount=[];
var numberOfElements = 10; 


for (var i = 0; i < numberOfElements; i++) {
 some.push(0.00);
}




for (var i = 0; i < numberOfElements; i++) {
	claimAmount.push(0.00);
}

$(document).ready(function() {
    var contractNo = "<%= contractNo %>";
   // Make sure contractNo is properly formatted
    var Contract_No;
    var actualqty;
    var checkcondition = 0;
    var loadedIds = [];
    var index = 0;
  

    console.log(actualqty);
   

    $.ajax({
        type: 'GET',
        url: 'challanbaseddata.obj',
        data: { "contractno": contractNo },
        success: function(data) {
        
            var dataArray = JSON.parse(data);
            if (dataArray.length > 0) {
                var dateOfShipmentValue = dataArray[0][0]; 
                var vehicleNo = dataArray[0][1];
                var diDate = dataArray[0][2];
                actualqty = dataArray[0][3];
                Contract_No = dataArray[0][5];
                Millcode = dataArray[0][6];
                var  cropyear  = dataArray[0][7];
             
                var  jutevariety = dataArray[0][8];
               
                
                console.log(actualqty);

                $('#diDate').val(diDate);
                $('#vehicleNo').val(vehicleNo);
                $('#dateOfShipmentValue').val(dateOfShipmentValue);
                $('#Contractno12').val(Contract_No);
                $('#millcode1').val(Millcode);

                var contNo1 = document.getElementById('Contractno12').value;
           
                var challanno = document.getElementById('challanno4').value;
              
             

             

                $.ajax({
                    type: 'GET',
                    url: 'GradePrice.obj',
                    data: { 
                        "contNo": contNo1,
                        "challanno": challanno,
                        "cropyear": cropyear,
                        "jutevariety": jutevariety,
                    },
                    success: function(data) {
                    
                         var dataArray = JSON.parse(data);
                         if (dataArray.length > 0) {
                           
                          
                             resultsArray = dataArray[0].slice(0); // Copy the elements from dataArray[0] to resultsArray
                            
                			
                			grade1=resultsArray[0]; 
                		
                			grade2=resultsArray[1];
                			
                			grade3=resultsArray[2]; 
                		
                			grade4=resultsArray[3];
                			
                			grade5=resultsArray[4];
                		
                			grade6=resultsArray[5];
                		
                			
                        	 loadMillChildBasedData(contractNo,grade1,grade2,grade3,grade4,grade5,grade6);
                        }
                        
                        
                    },
                    error: function(xhr, status, error) {
                        console.error('AJAX error:', error);
                    }
                });
            }
        },
        error: function(xhr, status, error) {
            console.error('AJAX error:', error);
        }
    });


});


function loadMillChildBasedData(contractNo,resultsArray) {
  
    

    $.ajax({
        type: 'GET',
        url: 'millchildbased.obj',
        data: { "contractno": contractNo },
        success: function(data) {
          
            var dataArray = JSON.parse(data);

            dataArray.forEach(function(row, index) {
                var str = row[3];
                var actualvalue1 = row[7];
                var actualvalue = parseFloat(actualvalue1);
                var match = str.match(/\d+/);
                var numericPartStr = match ? match[0] : "";
                var intValue = parseInt(numericPartStr, 10);
                

                var rowHtml = '<tr>' +
                    '<td>' +
                    '<div class="table2-cell"><input type="hidden" name="baleMark[]" value="' + row[1] + '"> ' + row[1] + '</div>' +
                    '</td>' +


 

                    '<td>' +
                    '<div class="table2-cell"><input type="hidden" name="juteVariety[]" value="' + row[2] + '"> ' + row[2] + '</div>' +
                    '</td>' +

                    '<td>' +



                    '<div class="table2-cell"><input type="hidden" name="jutegrade[]" value="' + row[3] + '">' + intValue + '</div>' +
                    '</td>' +

                    '<td>' +
                    '<div class="table2-cell"><input type="hidden" name="cropYear[]" value="' + row[4] + '">' + row[4] + '</div>' +
                    '</td>' +

                    '<td>' +
                    '<div class="table2-cell"><input type="hidden" name="challanQty[]" value="' + row[5] + '">' + row[5] + '</div>' +
                    '</td>' +

                    '<td>' +
                    '<div class="table2-cell"><input type="hidden" id="actualQty_" name="actualQty[]" value="' + row[7] + '">' + row[7] + '</div>' +
                    '</td>' +

                    '<td>' +
                    '<div class="table2-cell"><input type="hidden" name="No_of_bales[]" value="' + row[6] + '">' + row[6] + '</div>' +
                    '</td>' +

                    '<td>' +
                    '<div class="table2-cell">' +
                    '<label for="Qualitypercentage_' + index + '"></label>' +
                    '<input type="double" id="Qualitypercentage_' + index + '" name="Qualitypercentage[]" min="0" max="299"  step="any" value="0" oninput="if (this.value > 299) this.value = 299;">' +
                    '</div>' +
                    '</td>' +
                   /*  '<td>' +
                    '<div class="table2-cell">' +
                    '<label for="Qualitypercentage_' + index + '"></label>' +
                    '<input type="double" id="QualityValue_' + index + '" name="QualityValue_[]"  value="0"  readonly>' +
                    '</div>' +
                    '</td>' + */
                    
                    '<td>' +
                    '<div class="table2-cell">' +
                    '<select id="Nomination_' + index + '" name="Nomination[]" required >'+
                    '<option value="0">0</option>' +
                    '<option value="18">18</option>'+
                    '<option value="19">19</option>'+
                    '<option value="20">20</option>'+
                    '<option value="21">21</option>'+
                    '<option value="22">22</option>'+
                    '<option value="23">23</option>'+
                    '<option value="24">24</option>'+
                    '<option value="25">25</option>'+
                    '<option value="26">26</option>'+
                    '<option value="27">27</option>'+
                    '<option value="28">28</option>'+
                    '<option value="29">29</option>'+
                    '<option value="30">30</option>'+
                    '<option value="31">31</option>'+
                    '<option value="32">32</option>'+
                    '<option value="33">33</option>'+
                    '<option value="34">34</option>'+
                    '<option value="35">35</option>'+
                    '<option value="36">36</option>'+
                    '<option value="37">37</option>'+
                    '<option value="38">38</option>'+
                    '<option value="39">39</option>'+
                    '<option value="40">40</option>'+
                    '</select>' +
                    '</div>' +
                    '</td>' +

                    
                  /*   '<td>' +
                    '<div class="table3-cell">' +
                    '<label for="MoistureValue' + index + '"></label>' +
                    '<input type="double" id="MoistureValue' + index + '" name="MoistureValue[]"  value="0"  readonly>' +
                    '</div>' +
                    '</td>' + */
                    
                    '<td>' +
                    '<div class="table3-cell">' +
                    '<label for="NCVamt_' + index + '"></label>' +
                    '<input class="form-check-input" type="checkbox" id="checkNcvPercentage' + index + '">' +
                    '<input type="number" id="NCVamt_' + index + '" name="NCVamt[]" min="0" max="10" step="any" value="" >' +
                    '</div>' +
                    '</td>' +

                    '<td>' +
                    '<div class="table3-cell">' +
                    '<label for="ncvdust_' + index + '"></label>' +
                    '<input class="form-check-input" type="checkbox" id="checkNcvQty' + index + '">' +
                    '<input type="number" id="ncvdust_' + index + '" name="ncvdust[]" step="any" value="" >' +
                    '</div>' +
                    '</td>' +
                   
                  /*   '<td>' +
                    '<div class="table3-cell">' +
                    '<label for="Qualitypercentage_' + index + '"></label>' +
                    '<input type="double" id="NCV_Value' + index + '" name="NCV_Value[]" value="0" readonly >' +
                    '</div>' +
                    '</td>' + */
                    
                    
                    '<td>' +
                    '<div class="table3-cell">' +
                    '<label for="DustAMt_' + index + '"></label>' +
                    '<input class="form-check-input" type="checkbox" id="checkDustAMt_Percentage' + index + '">' +
                    '<input type="number" id="DustAMt_' + index + '" name="DustAMt_[]" min="0" max="10" step="any" value="" >' +
                    '</div>' +
                    '</td>' +

                    '<td>' +
                    '<div class="table3-cell">' +
                    '<label for="DustQty_' + index + '"></label>' +
                    '<input class="form-check-input" type="checkbox" id="checkDustQty_' + index + '">' +
                    '<input type="number" id="DustQty_' + index + '" name="DustQty_[]" step="any" value="" >' +
                    '</div>' +
                    '</td>' +
                    
                    
                  /*   '<td>' +
                    '<div class="table3-cell">' +
                    '<input type="double" id="DustValue' + index + '" name="DustValue[]"  value="0" readonly>' +
                    '</div>' +
                    '</td>' + */
                    
                    
                    '<td>' +
                    '<div class="table4-cell">' +
                        '<button type="button" class="btn btn-primary" id="DustValue1_' + index + '" name="calculate" ' +
                        'onclick="calculateQtyfrompercent(\'Qualitypercentage_' + index + '\', \'Nomination_' + index + '\', \'NCVamt_' + index + '\', \'DustAMt_' + index + '\', \'ncvdust_' + index + '\', \'DustQty_' + index + '\', \'' + actualvalue + '\', ' + intValue + ', ' + index + ')">Calculate</button>' +
                    '</div>' +
                '</td>' +
                '<td>' +
                    '<div class="table3-cell">' +
                        '<input type="double" id="claimAmmount' + index + '" name="claimAmmount[]" value="0" readonly>' +
                    '</div>' +
                '</td>';

                '</tr>';
                   

           
               	
                  
                

                $('#childTable1 tbody').append(rowHtml); // Append rowHtml to your table or container
                
                
                $('#NCVamt_' + index).prop('disabled', true).val('0');
                $('#ncvdust_' + index).prop('disabled', true).val('0');
                $('#DustAMt_' + index).prop('disabled', true).val('0');
                $('#DustQty_' + index).prop('disabled', true).val('0');
                
                index++;
                document.getElementById("rowindex2").value = index;
                
            });
        },
        error: function(xhr, status, error) {
            console.error('AJAX error:', error);
        }
    });

    /* $('#childTable').on('dblclick', function(e) {
        $('#childTable').hide();
    }); */
}



$(document).ready(function() {
    // Initial disabling of input fields
   $('input[name="NCVamt[]"], input[name="ncvdust[]"], input[name="DustAMt_[]"], input[name="DustQty_[]"]').prop('disabled', true).val('0');
// Event handler for Ncv percentage checkbox
   $(document).on('change', 'input[id^="checkNcvPercentage"]', function() {
       var checkbox = $(this);
       var tableRow = checkbox.closest('tr');
       var index = checkbox.attr('id').replace('checkNcvPercentage', '');
       var inputFields = tableRow.find('input[id="NCVamt_' + index + '"]');
       
       checkcondition = 1; 
       toggleInputFields(checkbox, inputFields, index);
       tableRow.find('input[id="ncvdust_' + index + '"]').val('0');
   });

   // Event handler for DustAMt percentage checkbox
   $(document).on('change', 'input[id^="checkDustAMt_Percentage"]', function() {
       var checkbox = $(this);
       var tableRow = checkbox.closest('tr');
       var index = checkbox.attr('id').replace('checkDustAMt_Percentage', '');
       var inputFields = tableRow.find('input[name="DustAMt_[]"]');
      
       checkcondition = 1; 
       toggleInputFields1(checkbox, inputFields, index);
       tableRow.find('input[id="DustQty_' + index + '"]').val('0');
   });

   // Event handler for Ncv Qty checkbox
   $(document).on('change', 'input[id^="checkNcvQty"]', function() {
       var checkbox = $(this);
       var tableRow = checkbox.closest('tr');
       var index = checkbox.attr('id').replace('checkNcvQty', '');
       var inputFields = tableRow.find('input[name="ncvdust[]"]');
      
       checkcondition = 2; 
       toggleInputFields(checkbox, inputFields, index);
       tableRow.find('input[id="NCVamt_' + index + '"]').val('0');
   });
  
   // Event handler for DustQty checkbox
   $(document).on('change', 'input[id^="checkDustQty_"]', function() {
       var checkbox = $(this);
       var tableRow = checkbox.closest('tr');
       var index = checkbox.attr('id').replace('checkDustQty_', '');
       var inputFields = tableRow.find('input[name="DustQty_[]"]');
       checkcondition = 2; 
       toggleInputFields1(checkbox, inputFields, index);
      
       tableRow.find('input[id="DustAMt_' + index + '"]').val('0');
   });
});
    
   

       
    
    
function toggleInputFields(checkbox, inputFields, index) {
    inputFields.prop('disabled', !checkbox.is(':checked'));

    if (checkbox.attr('id').startsWith('checkNcvPercentage')) {
        checkbox.closest('tr').find('input[id="NCVamt_' + index + '"]').prop('disabled', !checkbox.is(':checked'));
        checkbox.closest('tr').find('input[id="ncvdust_' + index + '"]').prop('checked', checkbox.is(':checked')).prop('disabled', checkbox.is(':checked'));
        checkbox.closest('tr').find('input[id^="checkNcvQty_' + index + '"]').prop('disabled', checkbox.is(':checked'));
        // $('input[name="ncvdust[]"]').val('0'); // Commented out as it might not be necessary
        if (!checkbox.is(':checked')) {
            checkbox.closest('tr').find('input[id="NCVamt_' + index + '"]').val('');
        }
    } else if (checkbox.attr('id').startsWith('checkNcvQty')) {
        checkbox.closest('tr').find('input[id="ncvdust_' + index + '"]').prop('disabled', !checkbox.is(':checked'));
        checkbox.closest('tr').find('input[id="NCVamt_' + index + '"]').prop('checked', checkbox.is(':checked')).prop('disabled', checkbox.is(':checked'));
        checkbox.closest('tr').find('input[id^="checkNcvPercentage_' + index + '"]').prop('disabled', checkbox.is(':checked'));
        // $('input[name="NCVamt[]"]').val('0'); // Commented out as it might not be necessary
        if (!checkbox.is(':checked')) {
            checkbox.closest('tr').find('input[name="ncvdust_' + index + '"]').val('');
        }
    } else {
        console.log('Unknown checkbox triggered.'); // Log if an unknown checkbox triggers the function
    }
}

function toggleInputFields1(checkbox, inputFields, index) {
    inputFields.prop('disabled', !checkbox.is(':checked'));

    if (checkbox.attr('id').startsWith('checkDustAMt_Percentage')) {
        checkbox.closest('tr').find('input[name="DustAMt_' + index + '"]').prop('disabled', !checkbox.is(':checked'));
        checkbox.closest('tr').find('input[name="DustQty_' + index + '"]').prop('checked', checkbox.is(':checked')).prop('disabled', checkbox.is(':checked'));
        checkbox.closest('tr').find('input[id^="checkDustQty_' + index + '"]').prop('disabled', checkbox.is(':checked'));
        // $('input[name="DustQty_[]"]').val('0'); // Commented out as it might not be necessary
        if (!checkbox.is(':checked')) {
            checkbox.closest('tr').find('input[name="DustAMt_' + index + '"]').val('');
        }
    } else if (checkbox.attr('id').startsWith('checkDustQty_')) {
        checkbox.closest('tr').find('input[name="DustQty_' + index + '"]').prop('disabled', !checkbox.is(':checked'));
        checkbox.closest('tr').find('input[name="DustAMt_' + index + '"]').prop('checked', checkbox.is(':checked')).prop('disabled', checkbox.is(':checked'));
        checkbox.closest('tr').find('input[id^="checkDustAMt_Percentage_' + index + '"]').prop('disabled', checkbox.is(':checked'));
        // $('input[name="DustAMt_[]"]').val('0'); // Commented out as it might not be necessary
        if (!checkbox.is(':checked')) {
            checkbox.closest('tr').find('input[name="DustQty_' + index + '"]').val('');
        }
    } else {
        console.log('Unknown checkbox triggered.'); // Log if an unknown checkbox triggers the function
    }
}

$('#firstloop1').val(checkcondition);



loadedIds.push(id);
$('#childTable1').show();
</script>
<script>


 
 
function calculateQtyfrompercent(QualitypercentageId, NominationId, NCVamtId, DustAmtId, NCVQty, DUSTQty, actualvalue, intvalue, index) {
    // Retrieve the actual input values using the IDs
    var Qualitypercentage = document.getElementById(QualitypercentageId).value;
    var Nomination = document.getElementById(NominationId).value;
    var NCVamt = document.getElementById(NCVamtId).value;
    var NCVQty = document.getElementById(NCVQty).value;
    var DUSTQty = document.getElementById(DUSTQty).value;
    var DustAmt = document.getElementById(DustAmtId).value;


   
    
    let gradeprice = resultsArray[intvalue - 1];
    let gradeprice1 = gradeprice;
  


    let qty1 = ((actualvalue * parseFloat(NCVamt)) / 100);
    let valueinprice = (gradeprice * qty1).toFixed(2);
    let ncvValue = parseFloat(valueinprice);



    let qty2 = ((actualvalue * parseFloat(DustAmt)) / 100);
    let valueinprice1 = (gradeprice * qty2).toFixed(2);
    let dustValue = parseFloat(valueinprice1);

   


    let qty3 = ((actualvalue * parseFloat(Nomination)) / 100);
    let valueinprice2 = (gradeprice * qty3).toFixed(2);
    let moisturevalue = parseFloat(valueinprice2);

    
    var currentMonth = new Date().getMonth() + 1;
    if (currentMonth > 6 && currentMonth <= 10) {
         Nomination = Nomination - 20;
    } else {
     Nomination = Nomination - 18;
    }
   if (Nomination < 0) {
        Nomination = 0;
    }
        qty3 = ((actualvalue * parseFloat(Nomination)) / 100);
        valueinprice2 = (gradeprice * qty3).toFixed(2);
        moisturevalue = parseFloat(valueinprice2);
        alert(moisturevalue);

    let qty4 = parseFloat(NCVQty);
    let valueinprice3 = (gradeprice * qty4).toFixed(2);
    let ncvqty = parseFloat(valueinprice3);

    
    let qty5 =  parseFloat(DUSTQty);
    let valueinprice4 = (gradeprice * qty5).toFixed(2);
    let dustqty = parseFloat(valueinprice4);

    let totalvalue=0;
    totalvalue = ncvValue + dustValue + moisturevalue+dustqty+ncvqty;
    totalvalue = Math.round(totalvalue);
    let totalqty = (qty1 + qty2 + qty3+qty4+qty5).toFixed(2);

  

    let newactualqty = (actualvalue - totalqty).toFixed(2);
   

    let integerResult = (parseInt(Qualitypercentage) / 100);
  

    let qs = integerResult;
    let rem = parseFloat(Qualitypercentage) % 100;


    let gradeprice6 = resultsArray[intvalue - 1];
   

    if (qs < 1) {
      

        intvalue++;
     
        gradeprice = resultsArray[intvalue - 1];
      
        gradeprice = gradeprice1 - gradeprice;
     


        let qty = ((newactualqty * parseFloat(Qualitypercentage)) / 100);
       
        valueinprice = (gradeprice * qty).toFixed(2);
      
        totalvalue += parseFloat(valueinprice);
        totalvalue = Math.round(totalvalue);
        console.log('qs is 0, valueinprice:', valueinprice);

    } else if (qs > 1 && qs < 2 || qs == 1) {
        rem = parseFloat(Qualitypercentage) % 100;
        if (rem === 0) {
            intvalue++;
            gradeprice = resultsArray[intvalue - 1];
            gradeprice = gradeprice1 - gradeprice;

            let qty = ((newactualqty * parseFloat(Qualitypercentage)) / 100);
            valueinprice = (gradeprice * qty).toFixed(2);
          
            totalvalue += parseFloat(valueinprice);
            totalvalue = Math.round(totalvalue);
            console.log('qs is 1, rem is 0, valueinprice:', valueinprice);

        } else {
            intvalue++;
            intvalue++;
          
            gradeprice = resultsArray[intvalue - 1];
            let grade = gradeprice;
      
            gradeprice = gradeprice1 - gradeprice;
        

            let inputValue = parseFloat(rem) || 0;
            let qty = (newactualqty * inputValue) / 100;
         

            valueinprice1 = (gradeprice * qty).toFixed(2);
          

            intvalue--;
            gradeprice = resultsArray[intvalue - 1];

            gradeprice = gradeprice6 - gradeprice;
         

            let qty24 = 100.0 - qty;
            valueinprice1 = (parseFloat(valueinprice1) + gradeprice * qty24).toFixed(2);
            
            totalvalue += parseFloat(valueinprice1);
            totalvalue = Math.round(totalvalue);
            console.log('qs is 1, rem is not 0, valueinprice:', valueinprice1);
        }

    } else if (qs > 2 && qs < 3 || qs == 2) {
        rem = parseFloat(Qualitypercentage) % 100;
        if (rem === 0) {
            intvalue++;
            intvalue++;
            gradeprice = resultsArray[intvalue - 1];
            gradeprice = gradeprice1 - gradeprice;

            let qty = ((newactualqty * parseFloat(Qualitypercentage)) / 100);
            valueinprice = (gradeprice * qty).toFixed(2);
            
            totalvalue += parseFloat(valueinprice);
            totalvalue = Math.round(totalvalue);

        } else {
            intvalue++;
            intvalue++;
            intvalue++;
         
            gradeprice = resultsArray[intvalue - 1];
            let grade = gradeprice;
         
            gradeprice = gradeprice1 - gradeprice;
        

            let inputValue = parseFloat(rem) || 0;
            let qty = (newactualqty * inputValue) / 100;
          

            valueinprice1 = (gradeprice * qty).toFixed(2);
      

            intvalue--;
            gradeprice = resultsArray[intvalue - 1];
            gradeprice = grade - gradeprice;
       

            let qty23 = 100.0 - qty;
            let qty7 = ((newactualqty * qty23) / 100);
            valueinprice1 = (parseFloat(valueinprice1) + gradeprice * qty7).toFixed(2);
            valueinprice = valueinprice1;
           
            totalvalue += parseFloat(valueinprice);
            totalvalue = Math.round(totalvalue);
        }
    }

    // Update the value of the input field
    document.getElementById('claimAmmount' + index).value = totalvalue.toFixed(2);
}
	

    </script>


<script type="text/javascript">
$(document).ready(function() {
	
	
});
</script>



<!-- <script>
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

<script>
    $(document).ready(function(){
      
        setTimeout(function(){
            $('#flashMessage').fadeOut('slow');
        }, 3000); ded
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
