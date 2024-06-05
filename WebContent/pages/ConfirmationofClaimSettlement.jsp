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
.ibox {
    padding: 0 0px;
}
.page-content .ibox .ibox-body .col-sm-12.form-group {
    padding: 0 0px;
}
div.scrollmenu {
 /*  background-color: #333; */
  overflow: auto;
  white-space: nowrap;
}

div.scrollmenu a {
  display: inline-block;
  color: white;
  text-align: center;
  padding: 14px;
  text-decoration: none;
}

div.scrollmenu a:hover {
  background-color: #777;
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
				<h1 class="page-title">Entry of Confirmation of Claim
					Settlement Report</h1>
			</div>

			<%
			List<Object[]> getSettlementid = (List<Object[]>) request.getAttribute("getSettlementidlist");
			%>


			<div class="page-content fade-in-up">
				<div class="row">
					<div class="col-md-11">
						<div class="ibox">
							<span id="flashMessage">${msg}</span>
							<div class="ibox-body">
								<form action="saveConfirmationOfClaimSettelment.obj"
									method="POST" name="myForm" enctype="multipart/form-data" onsubmit="return myFunc()">
									<div class="child-checkbox" id="disableform">
									<div id='errorcontainer'
								style='display: none; text-align: center;'></div>
										<div class="row">

											 <div class="col-sm-4 form-group">
												<label>Settlement Id</label> <span class="text-danger">*
												</span>&nbsp; <span id="Settlement_Id" name="Settlement_Id"
													class="text-danger"> </span> <select name="Settlement_Id1"
													id="SettlementId1" class="form-control taxtbox" required>
													<option value="" selected disabled>-Select-</option>
													<%
    for (Object obj : getSettlementid) {
        if (obj instanceof String) {
            String settlementId = (String) obj;
%>
            <option value="<%=settlementId%>"><%=settlementId%></option>
<%
        }
    }
%>

												</select>
											</div>
										
<div class="col-sm-4 form-group">
												<label class="required">Supporting Document
													(330kb-1MB)</label>&nbsp; <span id="errRegForm" name="errRegForm"
													class="text-danger"> </span> <img id="imgPreview" /><input
													class="form-control taxtbox" name="SupportingDocument"
													type="file" oninput="validateREGFileType()"
													placeholder="Supporting Document" id="SupportingDocument"
													onkeypress="deleteErrorMsg()" required>
											</div>
											<div class="col-sm-4 form-group">
												<label>Mill name</label> <span class="text-danger">*
												</span>&nbsp; <span id="mill1" name="mil1 "
													class="text-danger"> </span><input
													class="form-control taxtbox" type="text"
													name="mill" id="mill"  readonly
													placeholder="Mill name" required>
											</div>
											
											



										</div>


									

										<div class="row">


											
											<div class="col-sm-4 form-group">
												<label>Crop Year</label> <span class="text-danger">*
												</span>&nbsp; <span id="Crop_Year" name="Crop_Year "
													class="text-danger"> </span> <input
													class="form-control taxtbox" name="Crop_Year1"
													id="CropYear1" value="" placeholder="Crop Year" readonly
													required>
											</div>
											<!-- <div class="col-sm-4 form-group">
												<label>Inspection by</label> <span class="text-danger">*
												</span>&nbsp; <span id="Inspection_by" name="Inspection_by "
													class="text-danger"> </span> <input
													class="form-control taxtbox" name="Inspectionby1"
													placeholder="Inspection by" required>
											</div> -->
											
											
											
											
											
											<!--  <div class="col-sm-4 form-group">
												<label>MR No. </label> <span class="text-danger">*
												</span>&nbsp; <span 
													class="text-danger"> </span> <input
													class="form-control taxtbox" name="mrNo"
													id="mrNo" value="" placeholder="MR No."
													readonly required>
											</div>  -->
										</div>
										<!-- <div class="row">
										 <div class="col-sm-4 form-group">
												<label>MR Date </label> <span class="text-danger">*
												</span>&nbsp; <span 
													class="text-danger"> </span> <input
													class="form-control taxtbox" name="mrDate"
													id="mrDate" value="" placeholder="MR Date"
													readonly required>
											</div> 
										</div>
 -->
										<div class="row">
									 	<div class="scrollmenu"> 
										<div class="col-sm-12 form-group">
														<label id="lblName"></label>
														<div id="form2"></div>
														<span id="misQty"></span>
													</div>
										 	</div> 
										



										</div>

										

										<div class="row">

											<div class="col-sm-4 form-group">
    <label id="lblName"></label>
    <div id="form3"></div>
    <span id="misQty"></span>
</div>


											<div class="col-sm-12 form-group">
    <label id="lblName"></label>
    <input
													class="form-control taxtbox" name="q"
													type="number"  id="q" value=""
													placeholder="q" required>
</div>										
											






										</div>

									




										<div class="row">
											<div class="col-sm-12 form-group">
												<input type="submit" value="Submit" id ="sub" class="btn btn-primary"
													id="submit" onclick="">
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
$("#fullcontractno1").on('change', function() {
    var id = $(this).val();
    // Instead of alerting the ID directly, you might want to do something more meaningful with it
    console.log("Selected ID: " + id); // Using console.log for debugging instead of alert
    
    // Making AJAX request
    $.ajax({
        type: 'GET',
        url: 'fetchChallan.obj',
        data: {
            "id": id
        },
        success: function(result) {
            // Parse JSON response
            var data = JSON.parse(result); // jQuery.parseJSON is deprecated, using JSON.parse instead
            // Do something with the parsed data, maybe update UI or perform further operations
             
                // Append new options
             

data.forEach(function(value) {
    var splitValues = value.split(","); // Splitting at commas
    splitValues.forEach(function(item) {
        $('#ChallanNo1').append($('<option>', {
            value: item,
            text: item
        }));
    });
});

            console.log("Received data:", data); // Log the data instead of alerting
        },
        error: function(xhr, status, error) {
            // Handle error
            console.error("Error:", status, error); // Logging error details
            alert("Error: " + error); // Alerting user about the error
        }
    });
});

</script>
	 -->

	<script>
$(document).ready(function(){
	$("#sub").prop("disabled", true);
    $("#SettlementId1").on('change',function(){
        var id=$(this).val();
        //alert(id);
        $.ajax({
            type:'GET',
            url:'fetchContractNo.obj',
            data:{
                "id":id
            },
            success:function(result){
                var data = jQuery.parseJSON(result);
               // alert(data);

                // Clear existing options
                $('#fullcontractno1').empty();

                // Add default option
               
				 $('#fullcontractno1').append($('<option>', {
                        value: "-1",
                        text: "Select"
                    }));
                // Append new options
                $.each(data, function(index, value) {
                    $('#fullcontractno1').append($('<option>', {
                        value: value,
                        text: value
                    }));
                });
            },
            error:function(error){
                alert("Error: " + error);
            },
        });
    });
});

</script>

 	<!-- <script type="text/javascript">
      
	$(document).ready(function() {
	    $('#fullcontractno1').on('change', function() {
	        var field2Value = $("#fullcontractno1").val();

	        $.ajax({
	            type: 'GET',
	            url: 'fetchingdatanominactionclaim.obj',
	            data: { "contractno": field2Value },
	            success: function(result) {
	            	var data = result;
	            	alert(data);
	            	alert(typeof data);
	            	console.log(data);
	            	data = data.replace(/^\[|\]$/g, '');
	            	data = data.replace(/^\[|\]$/g, '');
	            	var parts = data.split(",");
	            	alert(parts[0] + "-----------" + parts[1]);

	            	var inspectionDate = parts[0].replace(/^"|"$/g, ''); // Remove double quotes from the beginning and end of the string
	            	var millName = parts[1].replace(/^"|"$/g, ''); // Remove double quotes from the beginning and end of the string


	            	// Parse inspection date
	            	var inspectionDateParts = inspectionDate.split("-");
	            	var year = inspectionDateParts[2];
	            	var month = inspectionDateParts[1];
	            	var day = inspectionDateParts[0];

	            	// Format the date as yyyy-MM-dd
	            	var formattedInspectionDate = year + "-" + month + "-" + day;

	            	// Setting values to respective fields
	            	$('#mill').val(millName);
	            	$('#Dateofinspection12').val(formattedInspectionDate);

	            },
	            error: function(error) {
	                console.error("Error: " + error);
	                // Handle error here
	            }
	        });
	    });
	});

      
      </script>  -->
	<script type="text/javascript">
        $(document).ready(function() {
               $("#q").hide();
            $('#SettlementId1').on('change', async function() {
                var field2Value = $("#SettlementId1").val();
                       
                try {
                    const result = await $.ajax({
                        type: 'GET',
                        url: 'fetchSettlementData.obj',
                        data: { "id": field2Value }
                    });
                               
                    var data = JSON.parse(result);
                    console.log(result)
                    var dateString = data[0][1];
                    $("#mill").val( data[0][15]);
                    $("#mrNo").val(data[0][16]);
                    
                    
                   
                    $("#mrDate").val(formattedDate1);

                    var date = new Date(dateString); // Assuming dateString is defined elsewhere
                    var day = date.getDate();
                    var month = date.getMonth() + 1;
                    var year = date.getFullYear();
                    var formattedDay = day < 10 ? '0' + day : day;
                    var formattedMonth = month < 10 ? '0' + month : month;
                    var formattedYear = year;
                    var formattedDate = formattedDay + '-' + formattedMonth + '-' + formattedYear;

                    var tableHTML = "<table border='1'>";
                    tableHTML += "<tr><th style='font-weight: bold;'>Jute Variety</th><th style='font-weight: bold;'>Jute Variety/Grade</th><th style='font-weight: bold;'>Contract No.</th><th style='font-weight: bold;'>Date of Inspection</th><th style='font-weight: bold;'>Challan No.</th><th style='font-weight: bold;'>MR No.</th><th style='font-weight: bold;'>MR Date</th><th style='font-weight: bold;'>No. of Bales</th><th style='font-weight: bold;'>Actual Weight</th><th style='font-weight: bold;'>Price(per Qtls)</th><th style='font-weight: bold;'>Quality Claim Percentage</th><th style='font-weight: bold;'>Quality Settlement Percentage</th>"+
                        "<th style='font-weight: bold;'>Moisture Content Claim Percentage</th><th style='font-weight: bold;'>Moisture Content Settlement Percentage</th><th style='font-weight: bold;'>NCV Claim Percentage </th><th style='font-weight: bold;'>NCV Claim Quantity</th><th style='font-weight: bold;'>NCV Settlement Percentage</th><th style='font-weight: bold;'>Dust Claim Percentage</th><th style='font-weight: bold;'>Dust Settlement Percentage</th><th style='font-weight: bold;'>Claim Amount</th></tr>";
                    for (var i = 0; i < data.length; i++) {
                        var grade = data[i][3];
                           var readOnly = (grade === 'TDN5' || grade === 'WN5' || grade === 'M6' || grade === 'B6') ? 'readonly' : '';
                        var date1 = new Date(data[i][17]);
                           var day1 = date1.getDate();
                           var month1 = date1.getMonth() + 1;
                           var year1 = date1.getFullYear();
                           var formattedDay1 = day1 < 10 ? '0' + day1 : day1;
                           var formattedMonth1 = month1 < 10 ? '0' + month1 : month1;
                           var formattedYear1 = year1;
                           var formattedDate1 = formattedDay1 + '-' + formattedMonth1 + '-' + formattedYear1;
                           //alert(formattedDate1);
                        tableHTML += "<tr>";
                        tableHTML += "<td style='text-align:center;'><input readonly id='jv"+i+"' name='jv"+i+"' value='" + data[i][2] + "'></td>";
    	                tableHTML += "<td style='text-align:center;'><input readonly id='jg"+i+"' name='jg"+i+"' value='" + data[i][3] + "'></td>";

    	                tableHTML += "<td style='text-align:center;'> <input readonly id='cont"+i+"' name='cont"+i+"' value='" + data[i][13] + "'></input></td>";
                        
    	                tableHTML += "<td style='text-align:center;'><input readonly id='di"+i+"' name='di"+i+"' value='" + data[i][14] + "'></td>";
    	                tableHTML += "<td style='text-align:center;'><input readonly id='ch"+i+"' name='ch"+i+"' value='" + data[i][12] + "'></td>";
    	                tableHTML += "<td style='text-align:center;'><input readonly id='mn"+i+"' name='mn"+i+"' value='" + data[i][16] + "'></td>";
    	                tableHTML += "<td style='text-align:center;'><input readonly id='md"+i+"' name='md"+i+"' value='" + formattedDate1 + "'></td>";
    	                tableHTML += "<td style='text-align:center;'><input readonly id='nob"+i+"' name='nob"+i+"' value='" + data[i][8] + "'></td>";
    	                tableHTML += "<td style='text-align:center;'><input readonly id='amt"+i+"' name='amt"+i+"' value='" + data[i][4] + "'></td>";
    	                tableHTML += "<td style='text-align:center;'><input readonly id='pr"+i+"' name='pr"+i+"' type='number' value='" + data[i][9] + "'></td>";
    	                tableHTML += "<td style='text-align:center;'><input readonly id='qc"+i+"' name='qc"+i+"' value='" + data[i][5] + "%'></td>";
    	                tableHTML += "<td style='text-align:center;'>";
    	                tableHTML += "<input type='number' style='text-align:center; width:80px;' id='qs" + i + "' name='qs" + i + "' value='0.00' " + readOnly + ">";
    	                tableHTML += "</td>";

                        tableHTML += "<td style='text-align:center;  ' id='mc"+i+"'>" + data[i][6] +"%"+ "</td>";
                        tableHTML += "<td style='text-align:center;  '><input type='number' style='text-align:center; width:80px;' id='ms" + i + "'   name='ms" + i + "' value='0.00'></td>";
                        tableHTML += "<td style='text-align:center;  ' id='nc"+i+"'>" + data[i][7] +"%"+ "</td>";
                        tableHTML += "<td style='text-align:center;  ' id='nq"+i+"'>" + data[i][11] + "</td>";
                        tableHTML += "<td style='text-align:center;  '><input type='number' style='text-align:center; width:80px;' id='ns"+i+"' name='ns"+i+"' value='0.00'></td>";
                        tableHTML += "<td style='text-align:center;  '  id='dc"+i+"'>" + data[i][7]+"%" + "</td>";
                        tableHTML += "<td style='text-align:center;  '><input type='number' style='text-align:center; width:80px;' id='ds"+i+"'  name='ds"+i+"' value='0.00'></td>";
                        tableHTML += "<td style='text-align:center;  '><input type='number' style='text-align:center; width:80px;' id='cl"+i+"'  name='cl"+i+"' value='0.00' readonly></td>";
                        tableHTML += "</tr>";
                    }
                    tableHTML += "</table>";
                    tableHTML += "<button class='settlementButton'>Calculate</button>";
                    $("#form2").html(tableHTML);
                 // Add event listeners to input fields
                    for (let i = 0; i < data.length; i++) {
                        document.getElementById('qs' + i).addEventListener('change', validateQualitySettlement);
                        document.getElementById('ms' + i).addEventListener('change', validateMoistureSettlement);
                        document.getElementById('ns' + i).addEventListener('change', validateNcvSettlement);
                        document.getElementById('ds' + i).addEventListener('change', validateDustSettlement);
                    }

                    // Validation functions
                    function validateQualitySettlement(event) {
                        const index = parseInt(event.target.id.substring(2));
                        const qualitySettlement = parseFloat(event.target.value);
                        const qc = parseFloat(document.getElementById('qc' + index).value);
                        if (qualitySettlement > qc) {
                            alert("Quality Settlement should not exceed Quality Check!");
                            event.target.value = 0.00;
                        }
                    }

                    function validateMoistureSettlement(event) {
                        const index = parseInt(event.target.id.substring(2));
                        const moistureSettlement = parseFloat(event.target.value);
                        const mc = parseFloat(document.getElementById('mc' + index).textContent);
                        if (moistureSettlement > mc) {
                            alert("Moisture Settlement should not exceed Moisture Check!");
                            event.target.value = 0.00;
                        }
                    }

                    function validateNcvSettlement(event) {
                        const index = parseInt(event.target.id.substring(2));
                        const ncvSettlement = parseFloat(event.target.value);
                        const nc = parseFloat(document.getElementById('nc' + index).textContent);
                        if (ncvSettlement > nc) {
                            alert("NCV Settlement should not exceed NCV Check!");
                            event.target.value = 0.00;
                        }
                    }

                    function validateDustSettlement(event) {
                        const index = parseInt(event.target.id.substring(2));
                        const dustSettlement = parseFloat(event.target.value);
                        const dc = parseFloat(document.getElementById('dc' + index).textContent);
                        if (dustSettlement > dc) {
                            alert("Dust Settlement should not exceed Dust Check!");
                            event.target.value = 0.00;
                        }
                    }

                    
                    
                    
                    $("#q").val(data.length);
                   
                    $("#CropYear1").val(data[0][10]);
                    $("#mrDate").val(formattedDate);
                    $("#mrNo").val(data[0][0]);

                    var settle = "<label>Settlement Amount</label> <span class='text-danger'>*</span>&nbsp; <span id='Settlement_Amount' name='Settlement_Amount' class='text-danger'></span> <input class='form-control taxtbox' name='SettlementAmount' id='SettlementAmount1' readonly placeholder='Settlement Amount' required>";
                    $("#form3").html(settle);
					
                    $(document).on('click', '.settlementButton', async function(event) {
                        event.preventDefault();
                        event.stopPropagation(); 
                        
                        var Contract = $("#fullcontractno1").val();
                        var len = data.length;
                        var totalSettlementAmount = 0;

                        for (var index = 0; index < len; index++) {
                        	  var nsValue = parseFloat($('#ns' + index).val()).toFixed(2);
      	                    var dsValue = parseFloat($('#ds' + index).val()).toFixed(2);
      	                    var amtValue = parseFloat($('#amt' + index).val()).toFixed(2);
      	                    var qsValue = parseFloat($('#qs' + index).val()).toFixed(2);
      	                    var price = parseFloat($('#pr'+index).val()).toFixed(2);
      	                   // alert("price:"+price+"nsVal"+nsValue+"ds"+dsValue+"amtValue"+amtValue+"qsVal"+qsValue);
      	                    var ms = parseFloat($('#ms'+index).val()).toFixed(2);
      	                    var quot=0;
      	                    var rem=0;
							if(qsValue >100){
								quot = qsValue/100;
								rem= qsValue%100;
								
							}
      	                    
      	                    
                            var dsAmount = (dsValue / 100) * amtValue;
                            var nsAmount = (nsValue / 100) * amtValue;
                            var dnsPrice= (dsAmount+nsAmount)* price;
    	                    var msQty= (ms / 100) * amtValue;
    					    var msAmount = (ms / 100) * amtValue * price;

                            if (!isNaN(nsValue) && !isNaN(dsValue) && !isNaN(amtValue)) {
                            	  var amti = amtValue - (dsAmount + nsAmount+msQty) ;
                                var amtiFixed = amti.toFixed(2);
                              
                                
                                try {
                                	var grade = data[index][3];
                                	
                                	if (quot >= 1) {
                                	   
                                	   

                                	    const result = await $.ajax({
                                	        type: 'GET',
                                	        url: 'fetchPrice.obj',
                                	        data: {
                                	            "variety": data[index][2],
                                	            "grade": grade,
                                	            "contract": data[index][13],
                                	            "challan": data[index][12]
                                	        }
                                	    });
                                	  //  alert(result)
                                	    var lastDigit = parseInt(grade.slice(-1)); // Extract the last digit and convert it to an integer
                                	    var newLastDigit = (lastDigit + (parseInt(quot))) % 10; // Ensure the result stays within the range 0-9
                                	    grade = grade.slice(0, -1) + newLastDigit; // Concatenate the modified last digit with the rest of the grade
                                	  //  alert(grade);
                                	    const result2 = await $.ajax({
                                	        type: 'GET',
                                	        url: 'fetchPrice.obj',
                                	        data: {
                                	            "variety": data[index][2],
                                	            "grade": grade,
                                	            "contract": data[index][13],
                                	            "challan": data[index][12]
                                	        }
                                	    });
                                	    //alert(result2);
                                	    const fetchedData1 = parseFloat(JSON.parse(result));
                                	    const fetchedData2 = parseFloat(JSON.parse(result2));
                                	    
                                	    const AmountSet1 = amtiFixed * (100-rem)/100 * (price - fetchedData1);
                                	    const AmountSet2 = amtiFixed * (rem)/100 * (price - fetchedData2);
                                	    //alert(AmountSet1 +"------------"+AmountSet2);
                                
                                	    totalSettlementAmount += parseFloat(AmountSet1) + parseFloat(msAmount) +parseFloat(dnsPrice)+parseFloat(AmountSet2);
                                	    alert("AmountSet1+++"+parseFloat(AmountSet1)+"AmountSet2---"+parseFloat(AmountSet2)+"msAmount++"+parseFloat(msAmount)+"dnsPrice++"+parseFloat(dnsPrice))
                                	    //alert(AmountSet1+"--------"+msAmount+"------"+dnsPrice+"===="+AmountSet2+"=-----")
                                	}

                                	else{
                                    const result = await $.ajax({
                                        type: 'GET',
                                        url: 'fetchPrice.obj',
                                        data: {
                                            "variety": data[index][2],
                                            "grade": grade,
                                            "contract": data[index][13],
                                            "challan": data[index][12]
                                        }
                                    });
                                    
                                    const fetchedData = parseFloat(JSON.parse(result));
                                    //alert(fetchedData);
                                    const AmountSet = amtiFixed * (qsValue/100) * (price - fetchedData);
                                    
                                    $("#cl"+index).val(parseFloat(AmountSet) + parseFloat(msAmount) +parseFloat(dnsPrice));
                                    totalSettlementAmount += parseFloat(AmountSet) + parseFloat(msAmount) +parseFloat(dnsPrice);
                                    alert("AmountSet+++"+parseFloat(AmountSet)+"msAmount++"+parseFloat(msAmount)+"dnsPrice++"+parseFloat(dnsPrice))
    	                           // alert("Amt"+AmountSet+"msAmount"+msAmount+"dnsPrice"+dnsPrice);
                                	}

                                    
                                    
                                    
                                   

                                } catch (error) {
                                    alert("Error fetching data: " + error);
                                }
                            }
                        }
                       /*  $('#Settlement_Amount').text(totalSettlementAmount); */
                      alert(totalSettlementAmount)
	                $("#SettlementAmount1").val(totalSettlementAmount.toFixed(2));

                        $("#sub").prop("disabled", false);
                    });
                } catch (error) {
                    alert("Error: " + error);
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
function myFunc(){
/* 	var maxQ = $('#Quality_Settlement1').attr('max');
	alert(maxQ);
	var maxMoisture = $('#Moisture_Settlement1').attr('max');
	alert(maxMoisture);
	var maxN = $('#NCV_Settlement1').attr('max');
	alert(maxN)
	 if($('#Quality_Settlement1').attr('max') > $('#Quality_Settlement1').val() || $('#Moisture_Settlement1').attr('max' )> $('#Moisture_Settlement1').val() || $('#NCV_Settlement1').attr('max')<$('#NCV_Settlement1').val())
	{	
		 return false;
	
	
	}
	 else */
	/* alert( $("#q").val()); */
	 
	 return true;
}
</script>

	<script type="text/javascript">
      


	

    
    



		  
    
    <!-- END PAGA BACKDROPS-->
    <!-- CORE PLUGINS-->
    <script src="./assets/vendors/jquery/dist/jquery.min.js" type="text/javascript"></script>
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

	<!-- PAGE LEVEL SCRIPTS-->
</body>
</html>