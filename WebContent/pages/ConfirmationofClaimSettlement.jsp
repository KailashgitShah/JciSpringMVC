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
			List<Object> getSettlementid = (List<Object>) request.getAttribute("getSettlementidlist");
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
													for (int i = 0; i < getSettlementid.size(); i++) {
														BigDecimal settlementId = (BigDecimal) getSettlementid.get(i);
													%>
													<option value="<%=settlementId.intValue()%>"><%=settlementId.intValue()%></option>
													<%
													}
													%>
												</select>
											</div>


											<div class="col-sm-4 form-group">
												<label>Date_of_inspection</label> <span class="text-danger">*
												</span>&nbsp; <span id="Date_of_inspection"
													name="Date_of_inspection" class="text-danger"> </span> <input
													class="form-control" name="Dateofinspection"
													id="Dateofinspection12" value="" type="date" required>
											</div>
											<div class="col-sm-4 form-group">
												<label>Contract No.</label> <span class="text-danger">*
												</span>&nbsp; <span id="contractno" name="contractno"
													class="text-danger"> </span> <select name="fullcontractno"
													id="fullcontractno1" class="form-control taxtbox" required>

													<option value="-1" selected disabled>-Select-</option>

												</select>


											</div>



										</div>


										<div class="row">



											<div class="col-sm-4 form-group">
												<label>Challan No</label> <span class="text-danger">*
												</span>&nbsp; <span id="Challan_No" name="Challan_No "
													class="text-danger"> </span> <!-- <input
													class="form-control taxtbox" name="Challan_No1"
													id="ChallanNo1" placeholder="Challan_No" required readonly> -->
													<select name="Challan_No1"
													id="ChallanNo1" class="form-control taxtbox" required>

													<option value="-1" selected disabled>-Select-</option>

												</select>
													
											</div>

											<div class="col-sm-4 form-group">
												<label>MR No</label> <span class="text-danger">* </span>&nbsp;
												<span id="MR_No" name="MR_No " class="text-danger"> </span>
												<input class="form-control taxtbox" name="MR_No1" id="MRNo1"
													value="" placeholder="MR No" required readonly>
											</div>
											<div class="col-sm-4 form-group">
												<label>Bale Mark</label> <span class="text-danger">*
												</span>&nbsp; <span id="Bale_Mark" name="Bale_Mark "
													class="text-danger"> </span> <input
													class="form-control taxtbox" name="Bale_Mark1" value=""
													id="BaleMark1" placeholder="Bale Mark" required readonly>
											</div>





										</div>

										<div class="row">


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
												<label>Crop Year</label> <span class="text-danger">*
												</span>&nbsp; <span id="Crop_Year" name="Crop_Year "
													class="text-danger"> </span> <input
													class="form-control taxtbox" name="Crop_Year1"
													id="CropYear1" value="" placeholder="Crop Year" readonly
													required>
											</div>
											<div class="col-sm-4 form-group">
												<label>Quality Claim </label> <span class="text-danger">*
												</span>&nbsp; <span id="Quality_Claim " name="Quality_Claim  "
													class="text-danger"> </span> <input
													class="form-control taxtbox" name="Quality_Claim1"
													id="QualityClaim1" value="" placeholder="Quality Claim"
													readonly required>
											</div>
										</div>

										<div class="row">
											<div class="col-sm-4 form-group">
												<label>Moisture Content</label> <span class="text-danger">*
												</span>&nbsp; <span id="Moisture_Content" name="Moisture_Content "
													class="text-danger"> </span> <input
													class="form-control taxtbox" name="Moisture Content"
													id="MoistureContent1" value=""
													placeholder="Moisture Content" readonly required>
											</div>

											<div class="col-sm-4 form-group">
												<label>NCV Percentage </label> <span class="text-danger">*
												</span>&nbsp; <span id="NCV_Percentage " name="NCV Percentage "
													class="text-danger"> </span> <input
													class="form-control taxtbox" name="NCV_Percentage1"
													id="NCVPercentage1" value="" placeholder="NCV Percentage"
													readonly required>
											</div>
											<div class="col-sm-4 form-group">
												<label>Quality Settlement</label> <span class="text-danger">
												</span>&nbsp; <span id="Quality_Settlement"
													name="Quality_Settlement" class="text-danger"> </span> <input
													class="form-control taxtbox" name="Quality_Settlement"
													id="Quality_Settlement1" value="" type="number" step="0.01"
													placeholder=" Quality Settlement" required>


											</div>



										</div>

										<div class="row">


											<div class="col-sm-4 form-group">
												<label>Moisture Settlement</label> <span class="text-danger"></span>&nbsp;
												<span id="Moisture_Settlement" name="Moisture_Settlement"
													class="text-danger"> </span> <input
													class="form-control taxtbox" name="Moisture_Settlement"
													id="Moisture_Settlement1" value="" type="number"
													step="0.01" placeholder="Moisture Settlement" required>



											</div>
											<div class="col-sm-4 form-group">
												<label>NCV Settlement</label> <span class="text-danger">
												</span>&nbsp; <span id="NCV_Settlement" name="NCV_Settlement"
													class="text-danger"> </span> <input
													class="form-control taxtbox" name="NCV_Settlement"
													type="number" step="0.01" id="NCV_Settlement1" value=""
													placeholder=" NCV Settlement" required>



											</div>
											<div class="col-sm-4 form-group">
												<label>Claim Amount</label> <span class="text-danger">*
												</span>&nbsp; <span id="Claim_Amount" name="Claim_Amount "
													class="text-danger"> </span> <input
													class="form-control taxtbox" type="number"
													name="ClaimAmount" id="ClaimAmount1" value="" readonly
													placeholder="Claim Amount" required>
											</div>



										</div>

										<div class="row">




											<div class="col-sm-4 form-group">
												<label>Settlement Amount</label> <span class="text-danger">*
												</span>&nbsp; <span id="Settlement_Amount"
													name="Settlement_Amount " class="text-danger"> </span> <input
													class="form-control taxtbox" name="SettlementAmount"
													id="SettlementAmount1" value="" readonly
													placeholder="Settlement Amount" required>
											</div>

											<div class="col-sm-4 form-group">
												<label>Inspection by</label> <span class="text-danger">*
												</span>&nbsp; <span id="Inspection_by" name="Inspection_by "
													class="text-danger"> </span> <input
													class="form-control taxtbox" name="Inspectionby1"
													placeholder="Inspection by" required>
											</div>







										</div>

										<!--  For Showing the grade wise jute variety -->

										<div class="row">
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
															<td id="g111"><strong>Grade 1:</strong></td>
															<td><input type="text" id="g11" name="g11"
																readonly="readonly" value=""
																style="width: 200px; height: 30px;"></td>
															<td><input type="text" id="g12" name="g12"
																readonly="readonly" value=""
																style="width: 100px; height: 30px;"></td>
														</tr>

														<tr>
															<td id="g211"><strong>Grade 2:</strong></td>
															<td><input type="text" id="g21" name="g21"
																readonly="readonly" value=""
																style="width: 200px; height: 30px;"></td>
															<td><input type="text" id="g22" name="g22"
																readonly="readonly" value=""
																style="width: 100px; height: 30px;"></td>
														</tr>
														<tr>
															<td id="g311"><strong>Grade 3:</strong></td>
															<td><input type="text" id="g31" name="g31"
																readonly="readonly" value=""
																style="width: 200px; height: 30px;"></td>
															<td><input type="text" id="g32" name="g32"
																readonly="readonly" value=""
																style="width: 100px; height: 30px;"></td>
														</tr>
														<tr>
															<td id="g411"><strong>Grade 4:</strong></td>
															<td><input type="text" id="g41" name="g41"
																readonly="readonly" value=""
																style="width: 200px; height: 30px;"></td>
															<td><input type="text" id="g42" name="g42"
																readonly="readonly" value=""
																style="width: 100px; height: 30px;"></td>
														</tr>
														<tr>
															<td id="g511"><strong>Grade 5:</strong></td>
															<td><input type="text" id="g51" name="g51"
																readonly="readonly" value=""
																style="width: 200px; height: 30px;"></td>
															<td><input type="text" id="g52" name="g52"
																readonly="readonly" value=""
																style="width: 100px; height: 30px;"></td>
														</tr>
														<tr>
															<td id="g611"><strong>Grade 6:</strong></td>
															<td><input type="text" id="g61" name="g61"
																readonly="readonly" value=""
																style="width: 200px; height: 30px;"></td>
															<td><input type="text" id="g62" name="g62"
																readonly="readonly" value=""
																style="width: 100px; height: 30px;"></td>
														</tr>
														<tr>
															<td id="g21"></td>
															<td align="right"><input type="text" id="g71"
																name="g71" readonly="readonly" value="Total"
																style="width: 60px; height: 30px; text-align: center; font-weight: bold;"></td>
															<!--  <td><strong style ="text-align:right">Total</strong></td> -->
															<td><input type="number" id="g72" name="g72"
																readonly="readonly" value=""
																style="width: 100px; height: 30px; font-weight: bold;"></td>
														</tr>
													</tbody>

												</table>
											</div>
										</div>



										<!-- End the grade wise -->




										<div class="row">
											<div class="col-sm-12 form-group">
												<input type="submit" value="Submit" class="btn btn-primary"
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
$(document).ready(function(){
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

	<script type="text/javascript">
      
 $(document).ready(function() {
	    $('#SettlementId1').on('change', function() {
	    var field2Value = $(this).val();
	    
	 
	     
	    $.ajax({
	        type: 'GET',
	        url: 'fetchingdatanominactionclaim.obj',
	        data: { "contractno": field2Value },
	        success: function(data) {
	           //alert("nominationClaim"+data);
	           data = data.replace(/^\[|\]$/g, '');
	           data = data.replace(/^\[|\]$/g, '');
	           var valuesArray = data.split(',');
	           for (var i = 0; i < valuesArray.length; i++) {
	        	    valuesArray[i] = valuesArray[i].replace(/^"|"$/g, '');
	        	}
	           
	               // Set the value of the <select> element
	               $('#Quality_Settlement1').attr('max',valuesArray[0]);
	               $('#Quality_Settlement1').val(valuesArray[0]);
	               $('#Moisture_Settlement1').val(valuesArray[1]);
	               $('#NCV_Settlement1').val(valuesArray[2]);
	               $('#SettlementAmount1').val(valuesArray[3]); 
	               $('#ClaimAmount1').val(valuesArray[4]);
	               $('#Moisture_Settlement1').attr('max', valuesArray[1]);
	               $('#NCV_Settlement1').attr('max', valuesArray[2]);
	               $('#SettlementAmount1').attr('max', valuesArray[3]);
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
	<script type="text/javascript">
      
 $(document).ready(function() {
	    $('#fullcontractno1').on('change', function() {
	    var field2Value = $(this).val();
	    var id=$("#SettlementId1").val();
	    //alert()
	     
	    $.ajax({
	        type: 'GET',
	        url: 'fetchSettlementData.obj',
	        data: { "id": field2Value },
	        success: function(result) {
	        	alert("Before:" + result);

	        	var data = JSON.parse(result);

	        	console.log(data);
	        	//alert(data);
	        	//alert(data.length);

	        	for (var i = 0; i < data.length; i++) {
	        	    var option = document.createElement("option");

	        	    // Set the value attribute of the option
	        	    option.value = data[i][1]; // Assuming data[i][1] contains the value for the option

	        	    // Set the text content of the option
	        	    option.textContent = data[i][1]; // Assuming data[i][1] contains the text to display

	        	    // Append the option to the select dropdown
	        	    document.getElementById("ChallanNo1").appendChild(option);
	        	}

	        	$("#ChallanNo1").on('change', function() {
	        		//alert();
	        	    var selectedChallanNo = $(this).val(); // Get the selected value of ChallanNo1
	        	    //alert(selectedChallanNo)
	        	    for (var i = 0; i < data.length; i++) {
	        	    	//alert(data[i][1]+"=="+selectedChallanNo);
	        	        if (selectedChallanNo === data[i][1]) {
	        	            $("#BaleMark1").val(data[i][2]); 
	        	            $("#CropYear1").val(data[i][3]);
	        	            $("#QualityClaim1").val(data[i][4]);
	        	            $("#MoistureContent1").val(data[i][5]);
	        	            $("#NCVPercentage1").val(data[i][6]);
	        	           
	        	        }
	        	    }
	        	});

	        	$("#MRNo1").val(data[0][0]);
	        },
	        error: function(error) {
	            alert("Error: " + error);
	        }
	    });

	    });
	  
	});

      
      </script>

	



	<script type="text/javascript">
      
 $(document).ready(function() {
	    $('#fullcontractno1').on('change', function() {
	    var field2Value = $(this).val();
	   
	      $.ajax({
	            type: 'GET',
	            url: 'paymentdetailsforshow.obj',
	            data: { "contractno": field2Value },
	            success: function(data) {
	            //alert(data)
	            	 try {
	        	            var dataArray = JSON.parse(data);

	        	            if (dataArray && dataArray.length > 0) {
	        	                var Contarctqty = dataArray[0][0];
	        	                var Contarctdate = dataArray[0][2];
	        	                var ContarctValue = dataArray[0][1];
	        	                var Paymentduedate = dataArray[0][3];
	        	                var mill_name = dataArray[0][4];
	        	                
	        	               var GradeComposition = dataArray[0][5];
	     					
	        	               $.ajax({
	     			                  type: 'GET',
	     			                  url: 'greadewiseqty.obj',
	     			                  data: { "contractno": GradeComposition, 
	     			                	  "contractqty": Contarctqty },
	     			                      success: function(secondData) {
	     			                    // alert(secondData)
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
	     		        	           /*  alert(typeof dataArray[5][1]); */
	     		        	                  var totalsum = 0; 

	     		        	                  for (var i = 0; i < dataArray.length; i++) {
	     		        	                      totalsum += (dataArray[i][1]);
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
	     		        	              $('#g72').val(totalsum.toFixed(2)); 
	     			                    	 
	     			                     }
	     			             	        } catch (error) {
	     			             	            console.error("Error parsing JSON: " + error);
	     			             	        }
	     		},
	     			                  error: function(error) {
	     			                      console.error('Second Ajax call error:', error);
	     			                  }
	     			              });
	        	            }
	            	 }
	        	         catch (error) {
	        	            console.error("Error parsing JSON: " + error);
	        	        }
	        	           
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
<script>
function myFunc(){
	var maxQ = $('#Quality_Settlement1').attr('max');
	alert(maxQ);
	var maxMoisture = $('#Moisture_Settlement1').attr('max');
	alert(maxMoisture);
	var maxN = $('#NCV_Settlement1').attr('max');
	alert(maxN)
	 if($('#Quality_Settlement1').attr('max') > $('#Quality_Settlement1').val() || $('#Moisture_Settlement1').attr('max' )> $('#Moisture_Settlement1')val() || $('#NCV_Settlement1').attr('max')<$('#NCV_Settlement1').val())
	{	
		 return false;
	
	
	}
	 else return true;
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