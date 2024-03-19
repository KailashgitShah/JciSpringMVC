<<<<<<< HEAD
letest code of entry payment
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
<link href="./assets/vendors/DataTables/datatables.min.css"
	rel="stylesheet" />
<!-- THEME STYLES-->
<link href="assets/css/main.min.css" rel="stylesheet" />

<link rel="stylesheet" href="assets/css/chosen.css">

  <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">


<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>



<!-- CORE SCRIPTS-->

<style>
=======
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
>>>>>>> 8b90dcd314e47ac7172531e18ad935456d7e36f9
.required:after {
	content: " *";
	color: red;
}
<<<<<<< HEAD
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
=======
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
>>>>>>> 8b90dcd314e47ac7172531e18ad935456d7e36f9
													       String field1 = (String)row;
													    %>
													    <option value="<%= field1 %>"><%= field1 %></option>
													    <%
													    }
<<<<<<< HEAD
													    %> --%>
			</div>

			<%
			List<Object> getcontractList1 = (List<Object>) request.getAttribute("getcontractList1");
			List<Object> getcontractList2 = (List<Object>) request.getAttribute("getcontractList2");
			%>




			<div class="page-content fade-in-up">
				<div class="row">
					<div class="col-md-11">
						<div class="ibox">
							<span id="flashMessage">${msg}</span>
							<div class="ibox-body">
								<form action="saveentryofpaymentinstrumentDetails.obj"
									method="POST" name="myForm" enctype="multipart/form-data">
									<div class="child-checkbox" id="disableform">
										<div class="row">
											<div class="col-sm-4 form-group">
												<label>Mill name.</label> <span class="text-danger">*
												</span>&nbsp; <span id="millname1" name="Millname"
													class="text-danger"> </span> <select name="millname65"
													id="millname12" class="form-control taxtbox" required>

													<option value="select">-Select-</option>
													<%
													for (Object row : getcontractList2) {

														String millname = (String) row;
													%>
													<option value="<%=millname%>"><%=millname%></option>
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
=======
													    %>
													</select>
	                                        		
	                                        
                                        </div>
                                         <div class="col-sm-4 form-group">
	                                            <label>Instrument Type</label> 
	                                            <span class="text-danger">* </span>&nbsp; <span id="payment" name="payment" class="text-danger"> </span>
												<select name="paymenttype" id="paymenttype" class="form-control taxtbox" required>
>>>>>>> 8b90dcd314e47ac7172531e18ad935456d7e36f9
													<option value="">-Select-</option>
													<option value="NEFT/RTGS">NEFT/RTGS</option>
													<option value="Cheque/DD">Cheque/DD</option>
													<option value="Letter_of_Credit">Letter of Credit</option>
												</select>
<<<<<<< HEAD
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
											

											<div class="col-sm-4 form-group">
												<label>Instrument No</label> <span class="text-danger">*
												</span>&nbsp; <span id="instrument" name=Instrument
													class="text-danger"> </span> <input class="form-control"
													name="Instrument" id="Instrumentno"
													oninput="this.value = this.value.toUpperCase();validateInstrumentNo(this);"
													maxlength="16" type="text" pattern="[A-Za-z0-9/-]*"
													title="Only alphanumeric characters, slashes, and hyphens are allowed"
													required>
											</div>



											<div class="col-sm-4 form-group">
												<label id="differenceLabel">Instrument Value </label> <span
													class="text-danger">* </span>&nbsp; <span
													id="InstrumentValue " name="InstrumentValue "
													class="text-danger" type="double"> </span>
												<!--  <input class="form-control taxtbox" name="InstrumentValue" min="0" type="number" placeholder="Instrument Value" required> -->
												<input class="form-control taxtbox" name="InstrumentValue"
													id="InstrumentValue12" min="0" step="1" pattern="\d+"
													type="number" placeholder="Instrument Value" required
													oninput="validateAmount();">
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
													onchange="deleteErrorMsg()">
											</div>
												<div class="col-sm-4 form-group" id="BankName1">
												<label id="BankName1">Bank Name</label> <input
													class="form-control taxtbox" name="BankName" id="BankName"
													min="0" type="text" placeholder="Bank Name"
													onchange="deleteErrorMsg()">
											</div>

											<div class="col-sm-4 form-group" id="Branch1">
												<label id="Branch1">Branch</label> <input
													class="form-control taxtbox" name="Branch" id="Branch"
													min="0" type="text" placeholder="Branch"
													onchange="deleteErrorMsg()">
											</div>
											
											





										</div>

										<div class="row">
										
											<div class="col-sm-4 form-group">
												<label class="required">Supporting Document
													(330kb-1MB)</label>&nbsp; <span id="errRegForm" name="errRegForm"
													class="text-danger"> </span> <img id="imgPreview" /><input
													class="form-control taxtbox" name="SupportingDocument"
													type="file" accept=".jpg,.jpeg,.png.pdf"
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



										</div>



										<div class="row">
											


											<div class="col-sm-4 form-group" id="autoamounta">
												<label id="autoamounta">Auto Revolving Amount</label> <input
													class="form-control taxtbox" name="autorevolvingamount"
													id="autorevolvingamount" min="0" type="number"
													placeholder="Auto Revolving Amount">
											</div>



										</div>



										<div class="row" id="gradesDiv">
											<div class="col-sm-15">
												<table class="table">
													<thead>
														<tr>
															<th id="grade">Grade</th>
															<th id="grade1">Jute combination</th>
															<th id="grade2">Quantity</th>
														</tr>
													</thead>
													<tbody>
														<tr>
															<td id="g111">Grade 1:</td>
															<td><input type="text" id="g11" name="g11"
																readonly="readonly" value=""
																style="width: 300px; height: 30px;"></td>
															<td><input type="text" id="g12" name="g12"
																readonly="readonly" value=""
																style="width: 200px; height: 30px;"></td>
														</tr>

														<tr>
															<td id="g211">Grade 2:</td>
															<td><input type="text" id="g21" name="g21"
																readonly="readonly" value=""
																style="width: 300px; height: 30px;"></td>
															<td><input type="text" id="g22" name="g22"
																readonly="readonly" value=""
																style="width: 200px; height: 30px;"></td>
														</tr>
														<tr>
															<td id="g311">Grade 3:</td>
															<td><input type="text" id="g31" name="g31"
																readonly="readonly" value=""
																style="width: 300px; height: 30px;"></td>
															<td><input type="text" id="g32" name="g32"
																readonly="readonly" value=""
																style="width: 200px; height: 30px;"></td>
														</tr>
														<tr>
															<td id="g411">Grade 4:</td>
															<td><input type="text" id="g41" name="g41"
																readonly="readonly" value=""
																style="width: 300px; height: 30px;"></td>
															<td><input type="text" id="g42" name="g42"
																readonly="readonly" value=""
																style="width: 200px; height: 30px;"></td>
														</tr>
														<tr>
															<td id="g511">Grade 5:</td>
															<td><input type="text" id="g51" name="g51"
																readonly="readonly" value=""
																style="width: 300px; height: 30px;"></td>
															<td><input type="text" id="g52" name="g52"
																readonly="readonly" value=""
																style="width: 200px; height: 30px;"></td>
														</tr>
														<tr>
															<td id="g611">Grade 6:</td>
															<td><input type="text" id="g61" name="g61"
																readonly="readonly" value=""
																style="width: 300px; height: 30px;"></td>
															<td><input type="text" id="g62" name="g62"
																readonly="readonly" value=""
																style="width: 200px; height: 30px;"></td>
														</tr>
														<tr>
															<td id="g21"></td>
															<td><input type="text" id="g71" name="g71"
																readonly="readonly" value="Total"
																style="width: 300px; height: 30px; text-align: right; font-weight: bold;"></td>
															<!--  <td><strong style ="text-align:right">Total</strong></td> -->
															<td><input type="text" id="g72" name="g72"
																readonly="readonly" value=""
																style="width: 200px; height: 30px; font-weight: bold;"></td>
														</tr>
													</tbody>

												</table>
											</div>
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
											            <th>Contract Qty</th>
											            <th>Contract value</th>
											            <th>Contract Date</th>
											            <th>Payment_due Date</th>
											          
											        </tr>
											    </thead>
											    <tbody>
											        <!-- Rows will be dynamically added here -->
											    </tbody>
											</table>

										  
                                






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


	<script defer src="assets/css/chosen.jquery.js" type="text/javascript"></script>
	<script src="./assets/vendors/jquery/dist/jquery.min.js"
		type="text/javascript"></script>
	<script src="./assets/vendors/popper.js/dist/umd/popper.min.js"
		type="text/javascript"></script>
	<script src="./assets/vendors/bootstrap/dist/js/bootstrap.min.js"
		type="text/javascript"></script>
<!-- 	<script src="./assets/vendors/metisMenu/dist/metisMenu.min.js"
		type="text/javascript"></script> -->
	<script
		src="./assets/vendors/jquery-slimscroll/jquery.slimscroll.min.js"
		type="text/javascript"></script>
	<!-- PAGE LEVEL PLUGINS-->
	<script src="./assets/vendors/DataTables/datatables.min.js"
		type="text/javascript"></script>
	<!-- CORE SCRIPTS-->
<script src="assets/js/app.min.js" type="text/javascript"></script>


<script type="text/javascript">
$(document).ready(function() {
    $('#millname12').on('change', function() {
        $('#contractTable tbody').empty();
        var field2Value = $(this).val();
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
                $('#centerordpc').trigger('chosen:updated'); // Trigger chosen select update
                $('#centerordpc').on('change', function(evt, params) {
                    if (params.deselected) {
                        var deselectedContract = params.deselected;
                        removeTableEntry(deselectedContract);
                    } else {
                        selectedDataArray = $(this).val();
                        console.log("Selected data:", selectedDataArray);
                        generateTables(selectedDataArray);
                    }
                });
            },
            error: function(xhr, status, error) {
                console.error("Error:", error);
            }
        });
    });

    function generateTables(selectedContracts) {
        var lastIndex = selectedContracts.length - 1;
        var contractNo = selectedContracts[lastIndex];
        $.ajax({
            type: 'GET',
            url: 'contractlistfetch.obj',
            data: { "contractno": contractNo },
            success: function(data) {
                console.log("Data received for contract", contractNo, ":", data);
                updateTableWithData(data);
            },
            error: function(xhr, status, error) {
                console.error("Error for contract", contractNo, ":", error);
            }
        });
    }
    var totalContractValue = 0;
    
    function updateTableWithData(data) {
        var rowData = JSON.parse(data);
        if (Array.isArray(rowData) && rowData.length > 0) {
            rowData.forEach(function(row) {
                var newRow = $('<tr>');
                newRow.append('<td>' + row[0] + '</td>');
                newRow.append('<td>' + row[1] + '</td>');
                newRow.append('<td>' + row[2] + '</td>');
                newRow.append('<td>' + row[3] + '</td>');
                newRow.append('<td>' + row[4] + '</td>');
                $('#contractTable tbody').append(newRow);
                totalContractValue += parseFloat(row[2]);
                $('#differenceLabel').text('Instrument Value max = ' + totalContractValue);
                
            });
        } else {
            $('#contractTable tbody').append('<tr><td colspan="4">No data available</td></tr>');
        }
    }

    // Function to remove table entry
    function removeTableEntry(contractNo) {
        $('#contractTable tbody tr').each(function() {
            var rowContractNo = $(this).find('td:first').text();
            if (rowContractNo === contractNo) {
                var contractValue = parseFloat($(this).find('td:eq(2)').text()); // Get the contract value from the row
                totalContractValue -= contractValue; // Subtract contract value from totalContractValue
                $(this).remove();
                $('#differenceLabel').text('Instrument Value max = ' + totalContractValue); // Update the displayed totalContractValue
                return false; // Stop the loop once the entry is removed
            }
        });
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
        } else if (paymenttype === "NEFT/RTGS") {
            document.getElementById("autoamounta").style.setProperty("display", 'none');
            document.getElementById("doexpiry").style.setProperty("display", 'none');
            document.getElementById("BankName1").style.setProperty("display", 'none');
            document.getElementById("doshipment").style.setProperty("display", 'none');
            document.getElementById("Branch1").style.setProperty("display", 'none');
            document.getElementById("IFSC1").style.setProperty("display", 'none');
        } else if (paymenttype === "Cheque/DD") {
            document.getElementById("autoamounta").style.setProperty("display", 'none');
            document.getElementById("doexpiry").style.setProperty("display", 'none');
            document.getElementById("doshipment").style.setProperty("display", 'none');
            document.getElementById("BankName1").style.setProperty("display", 'block');
            document.getElementById("Branch1").style.setProperty("display", 'block');
            document.getElementById("IFSC1").style.setProperty("display", 'block');
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
        //checking validation for different  ID for client side validation
        $("#submit").click(function() {
            var contractdate = $("#contractdate").val();
            var instdate = $("#instdate").val();
            var paymenttype = $("#paymenttype").val();

            if (contractdate == "" || instdate == "") {
                alert("Please select mandatory Fields!");
            }
            if (paymenttype == "letterofcredit") {
                var dateofship = $("#dateofship").val();
                var dateofexpiry = $("#dateofexpiry").val();
                if (dateofship == "" || dateofexpiry == "") {
                    alert("Please select mandatory Fields!");
                }
            }
        });
    });
</script>

<script>


</script>

<script>
    function validateInstrumentNo(input) {
        var pattern = /^[A-Za-z0-9/-]*$/;
        if (!pattern.test(input.value)) {
            input.setCustomValidity("Only alphanumeric characters, slashes, and hyphens are allowed.");
        } else {
            input.setCustomValidity("");
        }
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
        //getting details of grade composition and contract table
        $('#contractno12').on('change', function() {
            var field2Value = $(this).val();

            if (field2Value === "select") {
                document.getElementById("gradesDiv").style.setProperty("display", 'none');
                document.getElementById("dataofHistory").style.setProperty("display", 'none');
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
                                    url: 'greadewiseqty.obj',
                                    data: {
                                        "contractno": GradeComposition,
                                        "contractqty": Contarctqty
                                    },
                                    success: function(secondData) {
                                        try {
                                            var dataArray = JSON.parse(secondData);
                                            if (dataArray && dataArray.length > 0) {
                                                var g11 = dataArray[0][0];
                                                var g12 = dataArray[0][1];
                                                var g21 = dataArray[1][0];
                                                var g22 = dataArray[1][1];
                                                var g31 = dataArray[2][0];
                                                var g32 = dataArray[2][1];
                                                var g41 = dataArray[3][0];
                                                var g42 = dataArray[3][1];
                                                var g51 = dataArray[4][0];
                                                var g52 = dataArray[4][1];
                                                var g61 = dataArray[5][0];
                                                var g62 = dataArray[5][1];

                                                var totalsum = 0;

                                                for (var i = 0; i < dataArray.length; i++) {
                                                    totalsum += dataArray[i][1];
                                                }

                                                $('#g11').val(g11);
                                                $('#g12').val(g12);
                                                $('#g21').val(g21);
                                                $('#g22').val(g22);
                                                $('#g31').val(g31);
                                                $('#g32').val(g32);
                                                $('#g41').val(g41);
                                                $('#g42').val(g42);
                                                $('#g51').val(g51);
                                                $('#g52').val(g52);
                                                $('#g61').val(g61);
                                                $('#g62').val(g62);
                                                $('#g72').val(totalsum);

                                                document.getElementById("gradesDiv").style.setProperty("display", 'block');
                                            }
                                        } catch (error) {
                                            console.error("Error parsing JSON: " + error);
                                        }
                                    },
                                    error: function(error) {
                                        console.error('Second Ajax call error:', error);
                                    }
                                });

                                $.ajax({
                                    type: 'GET',
                                    url: 'PreviousEntry.obj',
                                    data: {
                                        "contractno": field2Value
                                    },
                                    success: function(data) {
                                        var data1 = JSON.parse(data);
                                        if (data1 && data1.length > 0) {
                                            var tableBody = $('#tableBody');
                                            tableBody.empty();

                                            data1.forEach(function(rowData) {
                                                var newRow = $('<tr>');

                                                var contractNoCell = $('<td>').appendTo(newRow);
                                                $('<input>').attr({
                                                    type: 'text',
                                                    id: 'Contarct-NO',
                                                    name: 'g11',
                                                    readonly: 'readonly',
                                                    value: rowData[0],
                                                    style: 'width: 300px; height: 30px;'
                                                }).appendTo(contractNoCell);

                                                var instrumentNoCell = $('<td>').appendTo(newRow);
                                                $('<input>').attr({
                                                    type: 'text',
                                                    id: 'Instrument-NO',
                                                    name: 'g12',
                                                    readonly: 'readonly',
                                                    value: rowData[1],
                                                    style: 'width: 200px; height: 30px;'
                                                }).appendTo(instrumentNoCell);

                                                var instrumentValueCell = $('<td>').appendTo(newRow);
                                                var date = new Date(rowData[2]);
                                                var formattedDate = date.getDate() + '-' + (date.getMonth() + 1) + '-' + date.getFullYear();
                                                $('<input>').attr({
                                                    type: 'text',
                                                    id: 'Instrument-value',
                                                    name: 'g12',
                                                    readonly: 'readonly',
                                                    value: formattedDate,
                                                    style: 'width: 200px; height: 30px;'
                                                }).appendTo(instrumentValueCell);

                                                tableBody.append(newRow);
                                            });
                                            document.getElementById("dataofHistory").style.setProperty("display", 'block');
                                        } else {
                                            document.getElementById("dataofHistory").style.setProperty("display", 'none');
                                        }
                                    }
                                });
                            }
                        } catch (error) {
                            console.error("Error parsing JSON: " + error);
                        }
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
        // Define a function to fetch and update data of Razorpay API
        function updateData(F_BANK_IFSC) {
            var len = F_BANK_IFSC.length;
            if (len == 11) {
                $.ajax({
                    type: "GET",
                    url: "https://ifsc.razorpay.com/" + F_BANK_IFSC,
                    dataType: "json",
                    processData: false,
                    success: function(data) {
                        // Update the form fields with the fetched data
                        $("#Branch").val(JSON.stringify(data.BRANCH).replace(/\"/g, ""));
                        $("#BankName").val(JSON.stringify(data.BANK).replace(/\"/g, ""));
                    },
                    error: function(jqXHR, exception) {
                        alert("Enter a valid IFSC code!!!");
                    }
                });
            } else if (len > 11) {
                alert('IFSC Code cannot be more than 11 characters');
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
			if (extFile == "jpg" || extFile == "jpeg" || extFile == "png") {

			} else {
				alert("Only jpg/jpeg and png files are allowed!");
			}
		}
	</script>




</body>
</html>










=======
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
>>>>>>> 8b90dcd314e47ac7172531e18ad935456d7e36f9
