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
												<span class="text-danger">* </span>&nbsp; <span id="challanno" name="challanno" class="text-danger"> </span>
												<input class="form-control" name="challanno1" id="challanno" value="<%=contractNo %>" readonly="readonly" required>
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
											              <th>Quality Claim Value</th>
											               <th> Moisture Content</th>
											             <th> Moisture Value</th>
											              <th> Ncv percent</th>
											              <th> Ncv Qty</th>
											              <th> Ncv Value</th>
											               <th>Dust percent </th>
											              <th> Dust Qty</th>
											              <th> Dust Value</th>
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
											
                                   
                             
                           
                                 
                                             
                                    <div class="row">
                                    <div class="col-sm-2 form-group" style="display: none;">
												    <label "display:none;">MIllCode</label> <span
													class="text-danger">* </span>&nbsp;  <input
													type="hidden" class="form-control" name="millcode"
													id="millcode1" value="<%=millcode %>" readonly="readonly">
											</div>
											  <div class="col-sm-2 form-group"  style= "display:none;">
												    <label "display:none;">firstloop</label> <span
													class="text-danger">* </span>&nbsp;  <input
													 class="form-control" name="firstloop"
													id="firstloop1" value="" readonly="readonly">
											</div>
											  <div class="col-sm-2 form-group" style= "display:none;">
												    <label "display:none;" >rowindex </label> <span
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
$(document).ready(function() {
    var contractNo = "<%= contractNo %>"; // Make sure contractNo is properly formatted
    var actualqty;
    var checkcondition = 0;
    var loadedIds = [];
    var rowIndex = 0;

    console.log(actualqty);
    alert(contractNo);

    
        $.ajax({
            type: 'GET',
            url: 'challanbaseddata.obj',
            data: { "contractno": contractNo },
            success: function(data) {
                alert(data);
                var dataArray = JSON.parse(data);
                if (dataArray.length > 0) {
                    var dateOfShipmentValue = dataArray[0][0]; 
                    var vehicleNo = dataArray[0][1];
                    var diDate = dataArray[0][2];
                    actualqty = dataArray[0][3];
                    console.log(actualqty);

                    $('#diDate').val(diDate);
                    $('#vehicleNo').val(vehicleNo);
                    $('#dateOfShipmentValue').val(dateOfShipmentValue);
                  
                }

            },
            error: function(xhr, status, error) {
                console.error('AJAX error:', error);
            }
        });
    

    // Call the AJAX function with contractNo
   

    /* $('#childTable').on('dblclick', function(e) {
        $('#childTable').hide();
    }); */
});

</script>
<script type="text/javascript">
$(document).ready(function() {
    var contractNo = "<%= contractNo %>"; // Make sure contractNo is properly formatted

    alert("KKKKK");

    $.ajax({
        type: 'GET',
        url: 'millchildbased.obj',
        data: { "contractno": contractNo },
        success: function(data) {
            alert(data);
            var dataArray = JSON.parse(data);

            dataArray.forEach(function(row, index) {
                var str = row[3];
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
                    '<div class="table2-cell"><input type="hidden" name="jutegrade[]" value="' + intValue + '">' + intValue + '</div>' +
                    '</td>' +

                    '<td>' +
                    '<div class="table2-cell"><input type="hidden" name="cropYear[]" value="' + row[4] + '">' + row[4] + '</div>' +
                    '</td>' +

                    '<td>' +
                    '<div class="table2-cell"><input type="hidden" name="challanQty[]" value="' + row[5] + '">' + row[5] + '</div>' +
                    '</td>' +

                    '<td>' +
                    '<div class="table2-cell"><input type="hidden" name="actualQty[]" value="' + row[7] + '">' + row[7] + '</div>' +
                    '</td>' +

                    '<td>' +
                    '<div class="table2-cell"><input type="hidden" name="No_of_bales[]" value="' + row[6] + '">' + row[6] + '</div>' +
                    '</td>' +

                    '<td>' +
                    '<div class="table2-cell">' +
                    '<label for="Qualitypercentage_' + index + '"></label>' +
                    '<input type="number" id="Qualitypercentage_' + index + '" name="Qualitypercentage[]" min="0" max="100" step="any" value="0">' +
                    '</div>' +
                    '</td>' +
                    '<td>' +
                    '<div class="table3-cell">' +
                    '<label for="Qualitypercentage_' + index + '"></label>' +
                    '<input type="number" id="QualityValue_' + index + '" name="QualityValue_[]"  value="0">' +
                    '</div>' +
                    '</td>' +
                    '<td>' +
                    '<div class="table2-cell">' +
                    '<select id="Nomination_' + index + '" name="Nomination[]" required oninput="calculateQtyfrompercent(this);">'+
                    '<option value="0">0</option>' +
                    '<option value="15">15</option>'+
                    '<option value="16">16</option>'+
                    '<option value="17">17</option>'+
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

                    
                    '<td>' +
                    '<div class="table3-cell">' +
                    '<label for="MoistureValue' + index + '"></label>' +
                    '<input type="number" id="MoistureValue' + index + '" name="MoistureValue[]"  value="0" >' +
                    '</div>' +
                    '</td>' +
                    
                    '<td>' +
                    '<div class="table3-cell">' +
                    '<label for="NCVamt_' + index + '"></label>' +
                    '<input class="form-check-input" type="checkbox" id="checkNcvPercentage' + index + '">' +
                    '<input type="number" id="NCVamt_' + index + '" name="NCVamt[]" min="0" max="10" step="any" value="" oninput="calculateQtyfrompercent(this);">' +
                    '</div>' +
                    '</td>' +

                    '<td>' +
                    '<div class="table3-cell">' +
                    '<label for="ncvdust_' + index + '"></label>' +
                    '<input class="form-check-input" type="checkbox" id="checkNcvQty' + index + '">' +
                    '<input type="number" id="ncvdust_' + index + '" name="ncvdust[]" step="any" value="" oninput="calculateQtyfromQty(this);">' +
                    '</div>' +
                    '</td>' +
                   
                    '<td>' +
                    '<div class="table3-cell">' +
                    '<label for="Qualitypercentage_' + index + '"></label>' +
                    '<input type="number" id="NCV_Value' + index + '" name="NCV_Value[]" value="0"  >' +
                    '</div>' +
                    '</td>' +
                    
                    
                    '<td>' +
                    '<div class="table3-cell">' +
                    '<label for="DustAMt_' + index + '"></label>' +
                    '<input class="form-check-input" type="checkbox" id="checkDustAMt_Percentage' + index + '">' +
                    '<input type="number" id="DustAMt_' + index + '" name="DustAMt_[]" min="0" max="10" step="any" value="" oninput="calculateQtyfrompercent(this);">' +
                    '</div>' +
                    '</td>' +

                    '<td>' +
                    '<div class="table3-cell">' +
                    '<label for="DustQty_' + index + '"></label>' +
                    '<input class="form-check-input" type="checkbox" id="checkDustQty_' + index + '">' +
                    '<input type="number" id="DustQty_' + index + '" name="DustQty_[]" step="any" value="" oninput="calculateQtyfromQty(this);">' +
                    '</div>' +
                    '</td>' +
                    
                    
                    '<td>' +
                    '<div class="table3-cell">' +
                    '<input type="number" id="DustValue' + index + '" name="DustValue[]"  value="0">' +
                    '</div>' +
                    '</td>' +
                  
                    
             
                    
                    '</tr>';

                $('#childTable1 tbody').append(rowHtml); // Append rowHtml to your table or container
                
                
                $('#NCVamt_' + index).prop('disabled', true).val('0');
                $('#ncvdust_' + index).prop('disabled', true).val('0');
                $('#DustAMt_' + index).prop('disabled', true).val('0');
                $('#DustQty_' + index).prop('disabled', true).val('0');
            });
        },
        error: function(xhr, status, error) {
            console.error('AJAX error:', error);
        }
    });

    /* $('#childTable').on('dblclick', function(e) {
        $('#childTable').hide();
    }); */
});


$(document).ready(function() {
    // Initial disabling of input fields
    $('input[name="NCVamt[]"], input[name="ncvdust[]"],input[name="DustAMt_[]"], input[name="DustQty_[]"]').prop('disabled', true);
    $('input[name="NCVamt[]"], input[name="ncvdust[]"],input[name="DustAMt_[]"], input[name="DustQty_[]"]').val('0');
    // Event handler for Ncv percentage checkbox
    $(document).on('change', 'input[id^="checkNcvPercentage"]', function() {
        var checkbox = $(this);
        var tableRow = checkbox.closest('tr');
        var inputFields = tableRow.find('input[name="NCVamt[]"]');
       
        checkcondition = 1; 
        toggleInputFields(checkbox, inputFields);
        $('input[name="ncvdust[]"]').val('0');
      
    });
    
    $(document).on('change', 'input[id^="checkDustAMt_Percentage"]', function() {
        var checkbox = $(this);
        var tableRow = checkbox.closest('tr');
    
        var inputFields = tableRow.find('input[name="DustAMt_[]"]');
        checkcondition = 1; 
        toggleInputFields1(checkbox, inputFields);
     
        $('input[name="DustQty_[]"]').val('0');
    });

    // Event handler for Ncv Qty checkbox
    $(document).on('change', 'input[id^="checkNcvQty"]', function() {
        var checkbox = $(this);
        var tableRow = checkbox.closest('tr');
        var inputFields = tableRow.find('input[name="ncvdust[]"]');
       
        checkcondition = 2; 
        toggleInputFields(checkbox, inputFields);
        $('input[name="NCVamt[]"]').val('0');
     
    });
   
    $(document).on('change', 'input[id^="checkDustQty_"]', function() {
        var checkbox = $(this);
        var tableRow = checkbox.closest('tr');
      
        var inputFields = tableRow.find('input[name="DustQty_[]"]');
        checkcondition = 2; 
        toggleInputFields1(checkbox, inputFields);
       
        $('input[name="DustAMt_[]"]').val('0');
    });

    function toggleInputFields(checkbox, inputFields) {
        inputFields.prop('disabled', !checkbox.is(':checked'));
       
        if (checkbox.attr('id').startsWith('checkNcvPercentage')) {
            checkbox.closest('tr').find('input[name="NCVamt[]"]').prop('disabled', !checkbox.is(':checked'));
            checkbox.closest('tr').find('input[name="ncvdust[]"]').prop('checked', checkbox.is(':checked')).prop('disabled', checkbox.is(':checked'));
            checkbox.closest('tr').find('input[id^="checkNcvQty"]').prop('disabled', checkbox.is(':checked'));
            if (!checkbox.is(':checked')) {
                checkbox.closest('tr').find('input[name="NCVamt[]"]').val('');
            }
        } else if (checkbox.attr('id').startsWith('checkNcvQty')) {
            checkbox.closest('tr').find('input[name="ncvdust[]"]').prop('disabled', !checkbox.is(':checked'));
            checkbox.closest('tr').find('input[name="NCVamt[]"]').prop('checked', checkbox.is(':checked')).prop('disabled', checkbox.is(':checked'));
            checkbox.closest('tr').find('input[id^="checkNcvPercentage"]').prop('disabled', checkbox.is(':checked'));
            $('input[name="NCVamt[]"]').val('');
            if (!checkbox.is(':checked')) {
                checkbox.closest('tr').find('input[name="ncvdust[]"]').val('');
            }
        } else {
        	
            console.log('Unknown checkbox triggered.'); // Log if an unknown checkbox triggers the function
        }
    }
    
    
    
    function toggleInputFields1(checkbox, inputFields) {
        inputFields.prop('disabled', !checkbox.is(':checked'));
       
        if (checkbox.attr('id').startsWith('checkDustAMt_Percentage')) {
            checkbox.closest('tr').find('input[name="DustAMt_[]"]').prop('disabled', !checkbox.is(':checked'));
            checkbox.closest('tr').find('input[name="DustQty_[]"]').prop('checked', checkbox.is(':checked')).prop('disabled', checkbox.is(':checked'));
            checkbox.closest('tr').find('input[id^="checkDustQty_"]').prop('disabled', checkbox.is(':checked'));
            if (!checkbox.is(':checked')) {
                checkbox.closest('tr').find('input[name="DustAMt_[]"]').val('');
            }
        } else if (checkbox.attr('id').startsWith('checkDustQty_')) {
            checkbox.closest('tr').find('input[name="DustQty_[]"]').prop('disabled', !checkbox.is(':checked'));
            checkbox.closest('tr').find('input[name="DustAMt_[]"]').prop('checked', checkbox.is(':checked')).prop('disabled', checkbox.is(':checked'));
            checkbox.closest('tr').find('input[id^="checkDustAMt_Percentage"]').prop('disabled', checkbox.is(':checked'));
            $('input[name="NCVamt[]"]').val('');
            if (!checkbox.is(':checked')) {
                checkbox.closest('tr').find('input[name="DustQty_[]"]').val('');
            }
        } else {
        	
            console.log('Unknown checkbox triggered.'); // Log if an unknown checkbox triggers the function
        }
    }
});

$('#firstloop1').val(checkcondition);

document.getElementById("rowindex2").value = rowIndex;

loadedIds.push(id);
$('#childTable1').show();
</script>





 
 <script>
        function myFunction() {
          
           	
      	   $("#Moisture_Cont").hide();
      	  $("#Moisture_Content").hide();
      	   $("#NCV_Percent").hide();
      	  $("#NCV_Percentage1").hide();
      	  
      	   $("#NCV_Qty34").hide();
      	  $("#NCV_Qty12").hide();  
      	 
      	   
        }
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
</script> -->

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
