
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

<link href="./assets/vendors/bootstrap/dist/css/bootstrap.min.css"
	rel="stylesheet" />
<link href="./assets/vendors/font-awesome/css/font-awesome.min.css"
	rel="stylesheet" />
<link href="./assets/vendors/themify-icons/css/themify-icons.css"
	rel="stylesheet" />
<!-- PLUGINS STYLES-->
<!-- THEME STYLES-->
<link href="assets/css/main.min.css" rel="stylesheet" />
<!-- PAGE LEVEL STYLES-->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.13.2/themes/base/jquery-ui.css">
<link rel="stylesheet" href="/resources/demos/style.css">
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
<script src="https://code.jquery.com/ui/1.13.2/jquery-ui.js"></script>
<link rel="stylesheet" href="assets/css/chosen.css">
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.5.0/js/bootstrap-datepicker.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>


<!-- CORE SCRIPTS-->

<style>
.required:after {
	content: " *";
	color: red;
}
</style>
</head>
<body class="fixed-navbar">
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

				<%--  for (Object row : getcontractList1) {
													       String field1 = (String)row;
													    %>
													    <option value="<%= field1 %>"><%= field1 %></option>
													    <%
													    }
													    %> --%>
			</div>

			<%
			List<Object> getcontractList1 = (List<Object>) request.getAttribute("getcontractList1");
			List<Object[]> getcontractList2 = (List<Object[]>) request.getAttribute("getcontractList2");
			String millname = "";
			%>




			<div class="page-content fade-in-up">
				<div class="row">
					<div class="col-md-11">
						<div class="ibox">
							<span id="flashMessage">${msg}</span>
							<div class="ibox-body">
								<form action="saveentryofpaymentinstrumentDetails.obj"
									method="POST" name="myForm" id="myForm"
									enctype="multipart/form-data">
									<div class="child-checkbox" id="disableform">
										<div class="row">
											<div class="col-sm-4 form-group">
												<label>Mill name.</label> <span class="text-danger">*
												</span>&nbsp; <span id="millname1" name="Millname"
													class="text-danger"> </span> <select name="millname65"
													id="millname12" class="form-control taxtbox" required>

													<option value="select">-Select-</option>
													<%
													for (Object[] row : getcontractList2) {
														millname = (String) row[0];
														String millcode = (String) row[1];
													%>
													<option value="<%=millcode%>"><%=millname%></option>
													<%
													}
													%>
												</select>


											</div>
											<div class="col-sm-4 form-group" id="dpc_div"">
												<label>Contract No.</label> <span class="text-danger">*</span>&nbsp;
												<span id="contractno" class="text-danger"></span> <select
													name="fullcontractno" id="contractno12"
													class="form-control taxtbox"
													style="height: = 50; width: 350px;" required>
													<option disabled selected value="">-Select</option>

												</select>
											</div>

											<div class="col-sm-4 form-group" id="instrument">
												<label>Instrument Type</label> <span class="text-danger">*
												</span>&nbsp; <span id="payment" name="payment" class="text-danger">
												</span> <select name="paymenttype" id="paymenttype"
													class="form-control taxtbox" required>
													<option value="">-Select-</option>
													<option value="NEFT/RTGS">NEFT/RTGS</option>
													<option value="Cheque/DD">Cheque/DD</option>
													<option value="Letter_of_Credit">Letter of Credit</option>
												</select>
											</div>


											<!-- 	<div class="col-sm-4 form-group">
												<label id="ContracQty2">Contract_Qty </label> <input
													class="form-control" id="ContracQty1" value=""
													readonly="readonly">
											</div>
 -->




										</div>
										<!-- <div class="row">

											<div class="col-sm-4 form-group">
												<label id="Contract_date2">Contract_date</label> <input
													class="form-control taxtbox" id="Contract_date1" value=""
													readonly="readonly">
											</div>
											<div class="col-sm-4 form-group">
												<label id="payment_dueDate2">Payment_dueDate</label> <input
													class="form-control" name="payment_dueDate12"
													id="payment_dueDate1" value="" readonly="readonly">
											</div>
											<div class="col-sm-4 form-group">
												<label id="contract_Value2">Contract_Value</label> <input
													class="form-control taxtbox" id="contract_Value1"
													name="contrcat_value23" value="" readonly="readonly">
											</div>
										</div> -->

										<div class="row">

											<!-- 
										<div class="col-sm-4 form-group">
										    <label for="Instrumentno">Instrument No</label> <span class="text-danger">*</span>
										    &nbsp; <span id="instrumentError" class="text-danger"></span>
										    <input class="form-control" name="Instrument" id="Instrumentno"
										           oninput="validateInstrumentNo(this);"
										           maxlength="16" type="text" required>
										</div> -->

											<div class="col-sm-4 form-group">
												<label>Instrumentno</label> <span class="text-danger">*</span>&nbsp;
												<span id="MR_N" name="MR_dante" class="text-danger"></span>
												<input class="form-control" name="Instrument"
													id="Instrumentno" type="text" maxlength="50"
													oninput="this.value = this.value.toUpperCase();validateInstrumentNo(this);"
													pattern="[A-Za-z0-9/-]*"
													title="Only alphanumeric characters, slashes, and hyphens are allowed"
													required >
											</div>



											<!-- oninput="validateAmount();"  -->

											<div class="col-sm-4 form-group">
												<label id="differenceLabel">Instrument Value </label> <span
													class="text-danger">* </span>&nbsp; <span
													id="InstrumentValue " name="InstrumentValue "
													class="text-danger" type="double"> </span>
												<!--  <input class="form-control taxtbox" name="InstrumentValue" min="0" type="number" placeholder="Instrument Value" required> -->
												<input class="form-control taxtbox" name="InstrumentValue"
													id="InstrumentValue12" min="0" step="1" pattern="\d+"
													type="text"
													oninput="this.value = this.value.replace(/\D/g, '')"
													placeholder="Instrument Value" required>
												<div id="errorMessage" style="color: red; display: none;">Amount
													exceeds the allowed limit!</div>
											</div>

											<div class="col-sm-4 form-group">
												<label>Instrument Date</label> <span class="text-danger">*
												</span>&nbsp; <span id="instrumentdate" name="instrumentdate"
													class="text-danger"> </span> <input class="form-control"
													name="instdate" id="instdate" type="date" required>
											</div>





										</div>

										<div class="row">


											<div class="col-sm-4 form-group" id="IFSC1">
												<label id="IFSC1">IFSC </label> <input class="form-control"
													oninput="this.value = this.value.toUpperCase()"
													maxlength="11" name="IFSC" type="text"
													placeholder="IFSC Code" id="IFSC"
													onchange="deleteErrorMsg()" required>
											</div>
											<div class="col-sm-4 form-group" id="BankName1">
												<label id="BankName1">Bank Name</label> <input
													class="form-control taxtbox" name="BankName" id="BankName"
													min="0" type="text" placeholder="Bank Name" readonly="true"
													onchange="deleteErrorMsg()">
											</div>

											<div class="col-sm-4 form-group" id="Branch1">
												<label id="Branch1">Branch</label> <input
													class="form-control taxtbox" name="Branch" id="Branch"
													min="0" type="text" placeholder="Branch" readonly="true"
													onchange="deleteErrorMsg()">
											</div>







										</div>

										<div class="row">

											<div class="col-sm-4 form-group">
												<label class="required">Supporting Document ((Only
													accepted .jpg,.jpeg,.png.pdf)330kb-1MB))</label>&nbsp; <span
													id="errRegForm" name="errRegForm" class="text-danger">
												</span> <img id="imgPreview" /><input class="form-control taxtbox"
													name="SupportingDocument" type="file"
													accept=".jpg,.jpeg,.png,.pdf"
													oninput="validateREGFileType()"
													placeholder="Supporting Document" id="SupportingDocument"
													onkeypress="deleteErrorMsg()" required>
											</div>

											<div class="col-sm-4 form-group" id="doshipment">
												<label id="doshipment">Last Shipment date</label> <input
													class="form-control" name="dateofship" id="dateofship"
													placeholder="Date of Shipment" type="date">
											</div>
											<div class="col-sm-4 form-group" id="doexpiry">
												<label id="doexpiry">Date of Expiry</label> <input
													class="form-control" name="dateofexpiry" id="dateofexpiry"
													placeholder="Date of Expiry" type="date">
											</div>
											<div class="col-sm-2 form-group" style="display: none;">
												<label"display:none;">GradeComposition </label> <span
													class="text-danger">* </span>&nbsp; <span
													id="GradeComposition1" name="GradeComposition"
													class="text-danger"> </span> <input type="hidden"
													class="form-control" name="GradeComposition"
													id="GradeComposition2" value="" readonly="readonly">
											</div>
											<div class="col-sm-2 form-group" style="display: none;">
												<label"display:none;">Contarctqty </label> <span
													class="text-danger">* </span>&nbsp; <span id="Contarctqty1"
													name="Contarctqty" class="text-danger"> </span> <input
													type="hidden" class="form-control" name="Contarctqty"
													id="Contarctqty2" value="" readonly="readonly">
											</div>
											<div class="col-sm-2 form-group" style="display: none;">
												<label>Ratio</label> <span class="text-danger">*</span>
												&nbsp; <span id="Ratio" name="Ratio" class="text-danger"></span>
												<input type="hidden" id="ratiosInput" name="ratios" value="">
											</div>




										</div>



										<div class="row">



											<div class="col-sm-4 form-group" id="autoamounta">
												<label id="autoamounta">Auto Revolving Amount</label> <input
													class="form-control taxtbox" name="autorevolvingamount"
													id="autorevolvingamount" min="0" type="number"
													placeholder="Auto Revolving Amount">
											</div>

											<div class="col-sm-2 form-group" style="display: none;">
												<label"display:none;" >millname234 </label> <span
													class="text-danger">* </span>&nbsp; <input
													class="form-control" name="millname234" id="millname23"
													value="<%=millname%>" readonly="readonly">
											</div>



										</div>



										<div class="row" id="gradesDiv">
											<!-- 	<div class="col-sm-15">
												<table class="table">
													<thead>
														<tr>
														
														</tr>
													</thead>
													<tbody>
														<tr>
															
														
														</tr>

														<tr>
														
															
														</tr>
														<tr>
														
															
														
														</tr>
														<tr>
															
															
														</tr>
														<tr>
															
															
														</tr>
														<tr>
															
														
														</tr>
														<tr>
															
														
														</tr>
													</tbody>

												</table>
											</div> -->
										</div>



										<div class="row">
											<div class="col-sm-12 form-group">
												<input type="submit" value="Submit" class="btn btn-primary"
													id="submit" onclick="">
											</div>
											<!--  <div class="clear">
 
												  <button type="submit" value="submit" name="subscribe" id="mc-embedded-subscribe" class="submit- btn btn-default" onclick="window.open('https://login.mailchimp.com/signup'), window.location = 'https://google.com'">Submit</button>
											   </div> -->
										</div>



										<!--   <div id="tableContainer"></div> -->
										<table id="contractTable" class="table table-bordered">
											<thead class="thead-light">
												<tr>
													<th>Contract No</th>
													<th>Contracted Qty(Qtls)</th>
													<th id="contractValueHeading">Contract value</th>
													<th>Contract Date</th>
													<th>Payment_due Date</th>
													<th>Instrument value</th>
													<th>Instrument Date</th>

												</tr>
											</thead>
											<tbody>
												<!-- Rows will be dynamically added here -->
											</tbody>
										</table>
										<input type="hidden" id="contractValueInput"
											name="contractValue"> <input type="hidden"
											id="paymentDueDateInput" name="paymentDueDate"> <input
											type="hidden" id="totalcontractvalue1"
											name="totalcontractvalue">








										<div class="row" id="dataofHistory" style="display: none;">
											<div class="col-sm-15">
												<table class="table" id="dataTable">
													<thead>
														<tr>
															<th id="Contarct-NO1">Contract_No</th>
															<th id="Instrument-NO1">Instrument value</th>
															<th id="Instrument-value1">Instrument date</th>
															<!--   <th id="Paid"> Qty paid</th>
												                    <th id="remaining"> Qty remaining</th> -->
														</tr>
													</thead>
													<tbody id="tableBody">
														<tr>

															<td><input type="text" id="Contarct-NO" name="g11"
																readonly="readonly" value=""
																style="width: 300px; height: 30px;"></td>
															<td><input type="text" id="Instrument-NO" name="g12"
																readonly="readonly" value=""
																style="width: 200px; height: 30px;"></td>
															<td><input type="text" id="Instrument-value"
																name="g12" readonly="readonly" value=""
																style="width: 200px; height: 30px;"></td>
															<!--   <td><input type="text" id="g12" name="g12" readonly="readonly" value="" style="width: 200px; height: 30px;"></td>
																    <td><input type="text" id="g12" name="g12" readonly="readonly" value="" style="width: 200px; height: 30px;"></td> -->
														</tr>


													</tbody>

												</table>
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


	<script src="./assets/vendors/jquery/dist/jquery.min.js"
		type="text/javascript"></script>
	<script src="assets/css/chosen.jquery.js" type="text/javascript"></script>
	<script src="./assets/vendors/popper.js/dist/umd/popper.min.js"
		type="text/javascript"></script>
	<script src="./assets/vendors/bootstrap/dist/js/bootstrap.min.js"
		type="text/javascript"></script>
	<script src="./assets/vendors/metisMenu/dist/metisMenu.min.js"
		type="text/javascript"></script>
	<script
		src="./assets/vendors/jquery-slimscroll/jquery.slimscroll.min.js"
		type="text/javascript"></script>
	<!-- PAGE LEVEL PLUGINS-->
	<!-- CORE SCRIPTS-->
	<script src="assets/js/app.min.js" type="text/javascript"></script>


	<script type="text/javascript">
var idcount=0;
var convalue=0;
var contract105 = 0;
var contract110 = 0;
$(document).ready(function() {
	$('#contractTable').hide();
    // Define total contract value and ratios globally
    var totalContractValue = 0;
    var ratios = [];
    var contractValues = [];
    var paymentDueDates = [];
  


    $('#millname12').on('change', function() {
        $('#contractTable tbody').empty();
        var field2Value = $(this).val();
        
        console.log(field2Value);
        $.ajax({
            type: 'GET',
            url: 'millnamebasedcontract.obj',
            data: {
                "contractno": field2Value
            },
            success: function(data) {
                console.log("Data received:", data);
                var result = JSON.parse(data); // Assign received data to the global array
                var html = "<label id='dpclabel' class='required'>Contract No</label> <select data-placeholder='Choose Contract...' class='chosen-select form-control' name='contract'  multiple tabindex='3' id='centerordpc'>";
                html += "<option disabled>-Select-</option>";
                for (var i = 0; i < result.length; i++) {
                    html += ('<option value="' + result[i] + '">' + result[i] + '</option>');
                }
                html += "</select>";
                $("#dpc_div").html(html);
              
                $("#centerordpc").chosen();
                $("#centerordpc").addClass("chosen-select");
                $('#centerordpc').trigger('chosen:updated');
                // Trigger chosen select update
                $('#centerordpc').on('change', function(evt, params) {
                    if (params && params.deselected) {
                     
                        var deselectedContract = params.deselected;
                        removeTableEntry(deselectedContract);
                    } else if (params && params.selected) {
                      
                        var selectedContract = params.selected;
                      /*   alert(selectedContract); */
                      /*   console.log("Selected data:", selectedContract); */
                        generateTables(selectedContract);
                    }
                    
                    // Clear the selection
               /*      $(this).val('').trigger('chosen:updated'); */
                });
            },
            error: function(xhr, status, error) {
                console.error("Error:", error);
            }
        });
    });

    function generateTables(selectedContracts) {
        var lastIndex = selectedContracts.length - 1;
       /*  var contractNo = selectedContracts[lastIndex]; */
        var contractNo = selectedContracts;
        $.ajax({
            type: 'GET',
            url: 'contractlistfetch.obj',
            data: { "contractno": contractNo },
            success: function(contractData) {
                console.log("Contract data received for contract", contractNo, ":", contractData);
                
                // Nested AJAX request to fetch difference and sum data
                $.ajax({
                    type: 'GET',
                    url: 'difrencecandsum.obj',
                    data: { "contractno": contractNo },
                    success: function(differenceData) {
                     /*    alert(differenceData); */
                        
                        // Assuming differenceData is a JSON string
                        var parsedData = JSON.parse(differenceData);
                    /*     alert(parsedData); */
                        var lastColumnData;
                        // Assuming parsedData is an array of objects where each object represents a row of data
                        // Iterate over parsedData to extract the last column data
                        for (var i = 0; i < parsedData.length; i++) {
                            var row = parsedData[i];
                            
                            // Assuming the row is an object and you want the last column value of each row
                            var lastColumnData = row[Object.keys(row).pop()]; // Get the last property value
                            console.log(lastColumnData);
                         /*    alert(lastColumnData); */
                        }

                        // You can now use the parsedData or lastColumnData as needed
                        updateTableWithData(contractData,lastColumnData); // Pass both datasets to the function
                    },
                    error: function(xhr, status, error) {
                        console.error("Error fetching difference data for contract", contractNo, ":", error);
                    }
                });
            },
            error: function(xhr, status, error) {
                console.error("Error fetching contract data for contract", contractNo, ":", error);
            }
        });


    }
    var contractValuesMap = {};
    function updateTableWithData(data,lastColumnData) {
        var rowData = JSON.parse(data);
        if (Array.isArray(rowData) && rowData.length > 0) {
        	$('#contractTable').show();
            // Clear existing table rows
          
             
            // Calculate total contract value and update table rows
            rowData.forEach(function(row,index) {
            	idcount++;
            	contract105 = Math.round(row[2]);
            	contract110 =  Math.round((row[2])*(110/105));
                var newRow = $('<tr>');
                newRow.append('<td>' + row[0] + '</td>');
                newRow.append('<td>' + row[1] + '</td>');
              /*   newRow.append('<td>' + row[2] + '</td>'); */
            newRow.append('<td id="uniqueId_' + index + '">' + row[2] + '</td>');
                newRow.append('<td>' + row[3] + '</td>');
                newRow.append('<td>' + row[4] + '</td>');
                if(row[5]==null&& row[6]==null){
                	newRow.append('<td>0</td>');
                    newRow.append('<td></td>');	
                }
                else {
                	
                	  var instrumentValue = row[5] || 0;
                	    var instrumentDate = row[6] || '';
                	    newRow.append('<td>' + instrumentValue + '</td>');
                	    newRow.append('<td>' + instrumentDate + '</td>');
                }
                newRow.append('<td style="display: none;">' + row[7] + '</td>');
                
                $('#contractTable tbody').append(newRow);
                
                $('#contractValueInput').append('<input type="hidden" name="contractValue[]" value="' + row[2] + '">');
                $('#paymentDueDateInput').append('<input type="hidden" name="paymentDueDate[]" value="' + row[4] + '">');
              
                
              
               /*  contractValuesMap[row[0]] = parseFloat(lastColumnData);
                totalContractValue += parseFloat(lastColumnData);
                 */
                contractValuesMap[row[0]] = parseFloat(lastColumnData !== null ? lastColumnData : row[2]);
            
              
                
            });
            if (Array.isArray(lastColumnData)) {
                // If lastColumnData is an array, sum the values
                rowData.forEach((row, index) => {
                    var value = lastColumnData[index] !== null ? parseFloat(lastColumnData[index]) : parseFloat(row[2]);
                    totalContractValue += value;
                 
                });
            } else {
                // If lastColumnData is a single value or null
                totalContractValue += (lastColumnData !== null ? parseFloat(lastColumnData) : rowData.reduce((sum, row) => sum + parseFloat(row[2]), 0));
          
            }
           
            // Update the total contract value label
           
            
         /*    $('#differenceLabel').text('Instrument Value max = ' + totalContractValue);
            */
            
            
            // Recalculate ratios
            recalculateRatios();
        } else {
            // If no data is available, display a message
            $('#contractTable').hide();
            $('#contractTable tbody').append('<tr><td colspan="5">No data available</td></tr>');
         
            /*   $('#differenceLabel').text('Instrument Value max = 0');
            */
        }
    }

    // Function to remove table entry
  function removeTableEntry(contractNo) {
    var rowsToRemove = [];

    $('#contractTable tbody tr').each(function() {
        var rowContractNo = $(this).find('td:first').text();
        if (rowContractNo === contractNo) {
            rowsToRemove.push($(this));
            var contractValue = contractValuesMap[contractNo];
            
            // Subtract the contract value from totalContractValue
            totalContractValue -= contractValue;
        }
    });

    // Remove the rows after processing all of them to avoid modifying the table while iterating
    rowsToRemove.forEach(function(row) {
        row.remove();
    });

    if (totalContractValue < 0) {
        totalContractValue = 0; // Set it to zero if it's negative
    }

    $('#differenceLabel').text('Instrument Value max = ' + totalContractValue.toFixed(2));

    recalculateRatios();

    if ($('#contractTable tbody tr').length === 0) {
        $('#contractTable').hide(); 
    }
}




    // Function to recalculate ratios
    function recalculateRatios() {
        ratios = [];
        var processedContracts = [];// Clear existing ratios
        $('#contractTable tbody tr').each(function() {
        	
        	 var contractNo = $(this).find('td:first').text(); // Assuming the contract number is in the first column

             // Check if the contract number has already been processed
             if (processedContracts.includes(contractNo)) {
                 return; // Skip this row
             }
            var contractValue = parseFloat($(this).find('td:eq(2)').text());
            var instrumentValue = parseFloat($(this).find('td:eq(7)').text());
            instrumentValue = isNaN(instrumentValue) ? 0 : instrumentValue;
            contractValue-=instrumentValue;
          /*   alert(contractValue); */
            var ratio = contractValue / totalContractValue;
            ratios.push(ratio);
            processedContracts.push(contractNo);// Store ratio for later use if needed
            console.log("Ratio for row " + ": " + ratio);
        });
        var ratiosJson = JSON.stringify(ratios);

        // Set the JSON string as the value of the hidden input field
        $('#ratiosInput').val(ratiosJson);
        $('#Ratio').text(ratiosJson);
       /*  $('#Ratio').closest('.form-group').show(); // Show the parent div
        $('#Ratio').closest('.form-group').fadeOut(2000); // Hide the parent div after 2000 milliseconds
     */
    }
});

</script>


	<script>
 $(document).ready(function() {
 
    $('#InstrumentValue12').on('input', function() {
    
        var enteredValue = parseFloat($(this).val());
        console.log('Entered value:', enteredValue);
        
        var maxAllowedValue = parseFloat($('#differenceLabel').text().split('=')[1].trim()); // Extract max allowed value from the label
        console.log('Entered value:', maxAllowedValue);
        if (enteredValue > maxAllowedValue) {
          
            $('#errorMessage').show();
           
            $('form').submit(function(event) {
                event.preventDefault();
            });
        } else {
         
            $('#errorMessage').hide();
           
            $('form').off('submit');
        }
    });
}); 


</script>


	<script type="text/javascript">
    //Through ajax call on paymenttype id  we can hide and visible the parameters.
    $("#paymenttype").on("change", function() {
        var paymenttype = $(this).val();
        if (paymenttype === "Letter_of_Credit") {
            document.getElementById("autoamounta").style.setProperty("display", 'block');
            document.getElementById("doexpiry").style.setProperty("display", 'block');
            document.getElementById("BankName1").style.setProperty("display", 'block');
            document.getElementById("doshipment").style.setProperty("display", 'block');
            document.getElementById("Branch1").style.setProperty("display", 'block');
            document.getElementById("IFSC1").style.setProperty("display", 'block');
        
            
 
           /* for(var i=0;i<idcount;i++) {
               var currentValue = document.getElementById("uniqueId_" + i).innerText; 
               var numericValue = parseFloat(currentValue);
               if (!isNaN(numericValue)) {
                   var newValue = Math.round(numericValue * (110 / 105));
                   document.getElementById("uniqueId_" + i).innerText = newValue; 
                   document.getElementById("contractValueHeading").innerText = "Contract value (110% of jute value in RS)";
                   
                   
               }
           } */
           
            for(var i=0;i<idcount;i++) {     
                document.getElementById("uniqueId_" + i).innerText = contract110; 
                document.getElementById("contractValueHeading").innerText = "Contract value (110% of jute value in RS)";
            }  

        } else if (paymenttype === "NEFT/RTGS") {
            document.getElementById("autoamounta").style.setProperty("display", 'none');
            document.getElementById("doexpiry").style.setProperty("display", 'none');
            document.getElementById("BankName1").style.setProperty("display", 'block');
            document.getElementById("doshipment").style.setProperty("display", 'none');
            document.getElementById("Branch1").style.setProperty("display", 'block');
            document.getElementById("IFSC1").style.setProperty("display", 'block');
            
            /* for(var i=0;i<idcount;i++) {
                var currentValue = document.getElementById("uniqueId_" + i).innerText; 
                var numericValue = parseFloat(currentValue);
                if (!isNaN(numericValue)) {
                    var newValue = Math.round(numericValue * (105 / 105));
                    document.getElementById("uniqueId_" + i).innerText = newValue; 
                    document.getElementById("contractValueHeading").innerText = "Contract value (105% of jute value in RS)";   
                }
            } */
            
            for(var i=0;i<idcount;i++) {     
                document.getElementById("uniqueId_" + i).innerText = contract105; 
                document.getElementById("contractValueHeading").innerText = "Contract value (105% of jute value in RS)";
            }  

        } else if (paymenttype === "Cheque/DD") {
            document.getElementById("autoamounta").style.setProperty("display", 'none');
            document.getElementById("doexpiry").style.setProperty("display", 'none');
            document.getElementById("doshipment").style.setProperty("display", 'none');
            document.getElementById("BankName1").style.setProperty("display", 'block');
            document.getElementById("Branch1").style.setProperty("display", 'block');
            document.getElementById("IFSC1").style.setProperty("display", 'block');
            document.getElementById("contractValueHeading").innerText = "Contract value (105% of jute value in RS)";
       
            /* for(var i=0;i<idcount;i++) {
                var currentValue = document.getElementById("uniqueId_" + i).innerText; 
                var numericValue = parseFloat(currentValue);
                if (!isNaN(numericValue)) {
                    var newValue = Math.round(numericValue * (105 / 105));
                    document.getElementById("uniqueId_" + i).innerText = newValue; 
                    document.getElementById("contractValueHeading").innerText = "Contract value (105% of jute value in RS)";
                     }
            } */
            
            for(var i=0;i<idcount;i++) {     
                document.getElementById("uniqueId_" + i).innerText = contract105; 
                document.getElementById("contractValueHeading").innerText = "Contract value (105% of jute value in RS)";
            }  
        }
    });
</script>

	<script type="text/javascript">
    document.getElementById("gradesDiv").style.setProperty("display", 'none');
    document.getElementById("autoamounta").style.setProperty("display", 'none');
    document.getElementById("doexpiry").style.setProperty("display", 'none');
    document.getElementById("doshipment").style.setProperty("display", 'none');
    document.getElementById("Branch1").style.setProperty("display", 'none');
    document.getElementById("BankName1").style.setProperty("display", 'none');
    document.getElementById("IFSC1").style.setProperty("display", 'none');

    $(document).ready(function() {
  
        $("#submit").click(function(event) {
         
            var isValid = true;

            var contractdate = $("#contractdate").val();
            var instdate = $("#instdate").val();
            var paymenttype = $("#paymenttype").val();
            var ifscCode = $("#IFSC").val();

            if (contractdate == "" || instdate == "") {
                alert("Please select mandatory Fields!");
                isValid = false; 
            }

            
            if (paymenttype == "letterofcredit") {
                var dateofship = $("#dateofship").val();
                var dateofexpiry = $("#dateofexpiry").val();
                if (dateofship == "" || dateofexpiry == "") {
                    alert("Please select mandatory Fields!");
                    isValid = false; // Set the flag to false if validation fails
                }
            }

            if (paymenttype == "Letter_of_Credit" || paymenttype == "Cheque/DD") {
                if (ifscCode.length !== 11) {
                    alert("Please enter a valid 11-character IFSC code!");
                    isValid = false; // Set the flag to false if validation fails
                }
              }

            // Prevent form submission if the form is not valid
            if (!isValid) {
                event.preventDefault(); // Prevents the default action (form submission)
            }
        });
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




	<script>
    $(document).ready(function() {
        setTimeout(function() {
            $('#flashMessage').fadeOut('slow');
        }, 3000);
    });
</script>

	<script>
    document.addEventListener('DOMContentLoaded', function() {
        // Get references to the date input fields
        var instDateInput = document.getElementById('instdate');
        var shipDateInput = document.getElementById('dateofship');
        var expiryDateInput = document.getElementById('dateofexpiry');
        var currentDate = new Date();
        var currentDateString = currentDate.toISOString().split('T')[0];
        instDateInput.setAttribute('max', currentDateString);

        // Add change event listener to the instrument date input
        instDateInput.addEventListener('change', function() {
            updateShipmentMinDate();
        });

        shipDateInput.addEventListener('change', function() {
            updateExpiryMinDate();
        });

        // Function to update the minimum selectable date for the shipment date input
        function updateShipmentMinDate() {
            var selectedInstrumentDate = new Date(instDateInput.value);
            var minShipmentDate = new Date(selectedInstrumentDate);
            minShipmentDate.setDate(selectedInstrumentDate.getDate() + 1);
            var minShipmentDateString = minShipmentDate.toISOString().split('T')[0];
            shipDateInput.setAttribute('min', minShipmentDateString);
            shipDateInput.disabled = false;
        }

        function updateExpiryMinDate() {
            var selectedShipmentDate = new Date(shipDateInput.value);
            var minExpiryDate = new Date(selectedShipmentDate);
            minExpiryDate.setDate(selectedShipmentDate.getDate() + 1);
            var minExpiryDateString = minExpiryDate.toISOString().split('T')[0];
            expiryDateInput.setAttribute('min', minExpiryDateString);
            expiryDateInput.disabled = false;
        }
    });
</script>



	<script type="text/javascript">
$(document).ready(function() {
    $('#contractno12').on('change', function() {
        var field2Value = $(this).val();

        if (field2Value === "select") {
            $('#gradesDiv').hide();
            $('#dataofHistory').hide();
            $('#GradeComposition2').val('');
            $('#Contract_date1').val('');
            $('#contract_Value1').val('');
            $('#payment_dueDate1').val('');
            $('#Mill_name1').val('');
            $('#ContracQty1').val('');
        } else {
            $.ajax({
                type: 'GET',
                url: 'paymentdetailsforshow.obj',
                data: {
                    "contractno": field2Value
                },
                success: function(data) {
                 // This should display the data returned by the server

                    try {
                        var dataArray = JSON.parse(data);
                        if (dataArray && dataArray.length > 0) {
                            var Contarctqty = dataArray[0][0];
                            var Contarctdate = dataArray[0][2];
                            var ContarctValue = dataArray[0][1];
                            var Paymentduedate = dataArray[0][3];
                            var mill_name = dataArray[0][4];
                            var GradeComposition = dataArray[0][5];

                            $('#GradeComposition2').val(GradeComposition);
                            $('#Contract_date1').val(Contarctdate);
                            $('#contract_Value1').val(ContarctValue);
                            $('#payment_dueDate1').val(Paymentduedate);
                            $('#Mill_name1').val(mill_name);
                            $('#ContracQty1').val(Contarctqty);

                            $.ajax({
                                type: 'GET',
                                url: 'PreviousEntry.obj',
                                data: {
                                    "contractno": field2Value
                                },
                                success: function(data) {
                                
                                
                                	 console.log("data"+data)
                                    try {
                                        var data1 = JSON.parse(data);
                                        if (data1 && data1.length > 0) {
                                            var tableBody = $('#tableBody');
                                            tableBody.empty();

                                            data1.forEach(function(rowData) {
                                                var newRow = $('<tr>');

                                                $('<td>').append(
                                                    $('<input>').attr({
                                                        type: 'text',
                                                        readonly: true,
                                                        value: rowData[0],
                                                        style: 'width: 300px; height: 30px;'
                                                    })
                                                ).appendTo(newRow);

                                                $('<td>').append(
                                                    $('<input>').attr({
                                                        type: 'text',
                                                        readonly: true,
                                                        value: rowData[1],
                                                        style: 'width: 200px; height: 30px;'
                                                    })
                                                ).appendTo(newRow);

                                                var date = new Date(rowData[2]);
                                                var formattedDate = date.getDate() + '-' + (date.getMonth() + 1) + '-' + date.getFullYear();

                                                $('<td>').append(
                                                    $('<input>').attr({
                                                        type: 'text',
                                                        readonly: true,
                                                        value: formattedDate,
                                                        style: 'width: 200px; height: 30px;'
                                                    })
                                                ).appendTo(newRow);

                                                tableBody.append(newRow);
                                            });

                                            $('#dataofHistory').show();
                                        } else {
                                            $('#dataofHistory').hide();
                                        }
                                    } catch (error) {
                                        console.error("Error parsing JSON from PreviousEntry: " + error);
                                    }
                                },
                                error: function(xhr, status, error) {
                                    console.error("AJAX error in PreviousEntry: " + status + " - " + error);
                                }
                            });
                        }
                    } catch (error) {
                        console.error("Error parsing JSON from paymentdetailsforshow: " + error);
                    }
                },
                error: function(xhr, status, error) {
                    console.error("AJAX error in paymentdetailsforshow: " + status + " - " + error);
                }
            });
        }
    });
});

</script>





	<script>
		function deleteErrorMsg() {
			var F_BANK_IFSC = document.forms["myForm"]["F_BANK_IFSC"].value;
			if (F_BANK_IFSC.length > 1) {
				$("#errIFSC").hide();
			}
			var F_REG_FORM = document.forms["myForm"]["F_REG_FORM"].value;
			if (F_REG_FORM.length > 1) {
				$("#errRegForm").hide();
			}

		}
		function allow_alphabets(element) {
			let textInput = element.value;
			textInput = textInput.replace(/[^A-Za-z ]+$/gm, "");
			element.value = textInput;
		}
	</script>

	<script>
		function myFunction() {
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

			// Your code to be executed when the page loads goes here

		}
	</script>




	<script>
$(document).ready(function() {
   
    function updateData(F_BANK_IFSC) {
        var len = F_BANK_IFSC.length;

        if (len === 11) {
            $.ajax({
                type: "GET",
                url: "https://ifsc.razorpay.com/" + F_BANK_IFSC,
                dataType: "json",
                processData: false,
                success: function(data) {
                 
                    $("#Branch").val(data.BRANCH || '');
                    $("#BankName").val(data.BANK || '');
                    
                    $("#submitBtn").prop('disabled', false);
                },
                error: function(jqXHR, exception) {
                    alert("Enter a valid IFSC code!!!");
              
                    $("#Branch").val('');
                    $("#BankName").val('');
                   
                    $("#submitBtn").prop('disabled', true);
                }
            });
        } else {
      
            $("#Branch").val('');
            $("#BankName").val('');
  

            if (len > 11) {
                alert('IFSC Code cannot be more than 11 characters');
            }
     
        }
    }

    // Bind the updateData function to the input event of #IFSC
    $("#IFSC").on("input", function() {
        var F_BANK_IFSC = $(this).val();
        updateData(F_BANK_IFSC);
    });

   
});

</script>








	<script>
		function validateREGFileType() {
			var F_REG_FORM = document.getElementById("SupportingDocument").value;
			var idxDot = F_REG_FORM.lastIndexOf(".") + 1;
			var extFile = F_REG_FORM.substr(idxDot, F_REG_FORM.length)
					.toLowerCase();
			if (extFile == "jpg" || extFile == "jpeg" || extFile == "png" || extFile == "pdf") {

			} else {
				alert("Only jpg/jpeg and png files are allowed!");
			}
		}
	</script>


	<script>
        $(document).ready(function() {
            $('#myForm').on('submit', function(event) {
                // Disable the submit button
                $('#submit').prop('disabled', true);
                $('#submit').val('Please Wait Processing...');  

              
            });
        });
    </script>


</body>
</html>










