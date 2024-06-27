<%-- <%@page import="java.util.Date"%> --%>
<%@page import="java.util.List"%>
<%@page import="java.time.LocalDate"%>
<%@page import="java.time.LocalDateTime"%>
<%@page import="com.jci.model.GenrationDemandNoteModel"%>
<%@page import="java.time.format.DateTimeFormatter"%>
<%@page import="com.jci.model.GenrationDEmandDto"%>
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
				<h1 class="page-title">Entry of Generation Demand Note</h1>
			</div>

			<%
	/* 		GenrationDEmandDto genrationDemandNoteModel  = (GenrationDEmandDto) request.getAttribute("cotract_No"); */
		 	List<Object>getdataList1=(List<Object>)request.getAttribute("contract"); 
			String demandNoteNo= (String)request.getAttribute("demandNoteNumber");
			
				String formattedDate = (String)request.getAttribute("formattedDate");
			
			
			%>
			<div class="page-content fade-in-up">
				<div class="row">
					<div class="col-md-11">
						<div class="ibox">
							<span id="flashMessage">${msg}</span>
							<div class="ibox-body">
								<form action="saveentryofGenrationDeamandNote.obj" method="POST">
									<!--  <div class="child-checkbox" id="disableform">  -->
									   <div class="col-4">
											   <div class="form-check mb-4">
    <input class="form-check-input" type="checkbox" id="waiverflag" name="Waiver_flag" value="1">
    <label class="form-check-label" for="waiverflag">Waiver Flag</label>
</div>

											  </div>  
										<div class="row">
											<div class="col-sm-4 form-group">
												<label>Contract No </label> <span class="text-danger">*
												</span>&nbsp; <span id="Contract_No" name="Contract_No"
													class="text-danger"> </span> <select name="Contract_No"
													id="ContractNo1" class="form-control taxtbox" required>
													<option value="">-Select-</option>
													<%
													    for (int i = 0; i < getdataList1.size(); i++) {
													   
													        String field1 = (String) getdataList1.get(i); 
													     %>
													    
													       <option value="<%= field1 %>"><%= field1  %></option>
													    <%
													    }
													    %>
													
												</select>
											</div>

											<div class="col-sm-4 form-group">
												<label>Contract Date</label> <span class="text-danger">*
												</span>&nbsp; <span id="Contract_Date" name="Contract_Date"
													class="text-danger"> </span> <input class="form-control"
													name="Contract_Date" id="ContractDate1" readonly="readonly"
													 value=""  required>
											</div>
											<div class="col-sm-4 form-group">
												<label>Payment Due Date </label> <span class="text-danger">*
												</span>&nbsp; <span id="Payment_Due_Date" name="Payment_Due_Date"
													class="text-danger"> </span> <input class="form-control"
													name="Payment_Due_Date" id="PaymentDueDate234"
													readonly="readonly"  value=""  required>
											</div>

										</div>

										<div class="row">

											<div class="col-sm-4 form-group">
												<label>Payment / Cancellation Date </label> <span
													class="text-danger">* </span>&nbsp; <span
													id="Cancellation_Date" name="Cancellation_Date"
													class="text-danger"> </span> <input class="form-control"
													name="Cancellation_Date" id="CancellationDate1"
													readonly="readonly"  value=""  required>
											</div>

											<div class="col-sm-4 form-group">
												<label>Delay period</label> <span class="text-danger">*
												</span>&nbsp; <span id="Delayperiod1" name="Delay_period"
													class="text-danger"> </span> <input class="form-control"
													name="Delay_period" id="Delayperiod234" value=""   readonly="readonly"
													type="text" required>
											</div>

											<div class="col-sm-4 form-group">
												<label>Payment Ref</label> <span class="text-danger">*
												</span>&nbsp; <span id="Payment_Ref" name="Payment_Ref"
													class="text-danger"> </span> <input class="form-control"
													name="Payment_Ref" id="PaymentRef1"  value="" readonly="readonly"
													 required>
											</div>


										</div>

										<div class="row">
											<div class="col-sm-4 form-group">
												<label>Allowed Quantity </label> <input
													class="form-control taxtbox" name="Contracted_Qty" id="Contracted_Qty" min="0"
													step="0.01" readonly="readonly"   value=""
													placeholder="Contracted_Qty" required>
											</div>
											<div class="col-sm-4 form-group">
												<label>Unit_charge</label> <input
													class="form-control taxtbox" name="Unit_charge"
													id="Unit_charge" min="0" step="0.01" type="number" 
													placeholder="0" required>
											</div>
											<div class="col-sm-4 form-group">
												<label>Carrying_cost</label> <input
													class="form-control taxtbox" name="Carrying_cost" id ="Carrying_cost" min="0"
													step="0.01" readonly="readonly"  value=""
													placeholder="Carrying_cost" required>
											</div>
											
											






										</div>

										<div class="row">

										
											<div class="col-sm-4 form-group">
												<label>Demand note no</label> <input
													class="form-control taxtbox" name="Demand_note_no" 
													 placeholder="Demand_note_no" value="<%= demandNoteNo %>"required>
											</div>
											
											
											<div class="col-sm-4 form-group">
												<label>Demand note date</label> <span class="text-danger">*
												</span>&nbsp; <span id="Created_on" name="Created_on"
													class="text-danger"> </span> <input class="form-control"
													name="Demand_note_date" id="Created_on" type="date" required value="<%=new java.text.SimpleDateFormat("yyyy-MM-dd").format(new java.util.Date())%>" readonly>
											</div>
											

											<div class="col-sm-4 form-group">
												<label>Remarks </label> <input class="form-control taxtbox"
													name="Remarks" id="Remarks" type="text" placeholder="Remarks" >
											</div>

											
										</div>
										<div class="row">
											<div class="col-sm-4 form-group">
    <label id="lblName"></label>
    <div id="form3"></div>
    <span id="misQty"></span>
</div>
										</div> 
  

										<div class="row">
											
<div class="col-sm-12 form-group">
    <label id="lblName"></label>
   <input class="form-control taxtbox" name="q" type="text" id="q" value="" placeholder="q" style="display: none;">
</div>										
											

											
											<!--   <div class="col-sm-4 form-group" id="carryingCostFormGroup" style="display: none;">
														  <label>Waiver Approved By</label>
														  <span class="text-danger">*</span>&nbsp;
														  <span id="WaiverApprovedBy1" name="Waiver_Approved_By" class="text-danger"></span>
														   <select class="form-control" name="Waiver_Approved_By" id="WaiverApprovedBy2" >
														       <option value="">-Select-</option>
														        <option value="JCI_Mill_officer_1">JCI_Mill_officer_1</option>
														        <option value="MllOfficer_2">MllOfficer_2</option>
														       <option value="Mill_officer_3">Mill_officer_3</option>
														        Add more options as needed
														    </select>
														  
				                                    </div>   -->
				                                    



										</div>
										
										<div class="row">
											<div class="col-sm-12 form-group">
												<input type="submit" value="Submit" class="btn btn-primary"
													id="submit">
											</div>
										 </div>
										<!-- </div> -->
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
<script>
document.addEventListener('DOMContentLoaded', function() {
    var waiverCheckbox = document.getElementById('waiverflag');
    var remarksField = document.getElementById('Remarks');

    // Check initial state of the checkbox
    if (waiverCheckbox.checked) {
    	
        remarksField.setAttribute('required', ''); // Make remarks field mandatory
    } else {
        remarksField.removeAttribute('required'); // Remove mandatory requirement
    }

    // Add change event listener to checkbox
    waiverCheckbox.addEventListener('change', function() {
        if (this.checked) {
            remarksField.setAttribute('required', ''); // Make remarks field mandatory
        } else {
            remarksField.removeAttribute('required'); // Remove mandatory requirement
        }
    });
});
</script>

	<script type="text/javascript">
		$(document).ready(function() {
			$("#submit").click(function() {

				var contractdate = $("#Contract_Date").val();
				var instdate = $("#Payment_Due_Date").val();
				var instdate1 = $("#Cancellation_Date").val();
				var paymenttype = $("#Unit_charge").val();
				var Remarks = $("#Remarks").val();
			
				
				
			

				

				
				
				
				if (contractdate == "" || instdate == "" || instdate1 == "" || paymenttype == "" || Remarks == "") {
					alert("Please select mandatory Fields!");
				}
			});
		});
		
					const dateInput = document.getElementById("Contract_Date");
					dateInput.addEventListener("change",function() {
							const selectedDate = this.value;
							const dateParts = selectedDate.split("-");
							const formattedDate = dateParts[2] + "-"+ dateParts[1] + "-" + dateParts[0];
							document.getElementById("Contract_Date").textContent = formattedDate;
						});
						const dateInput = document.getElementById("Payment_Due_Date");
						dateInput.addEventListener("change",function() {
							const selectedDate = this.value;
							const dateParts = selectedDate.split("-");
							const formattedDate = dateParts[2] + "-"
									+ dateParts[1] + "-" + dateParts[0];
							document.getElementById("Payment_Due_Date").textContent = formattedDate;
						});
					const dateInput = document.getElementById("Cancellation_Date");
					dateInput.addEventListener("change",function() {
							const selectedDate = this.value;
							const dateParts = selectedDate.split("-");
							const formattedDate = dateParts[2] + "-"
									+ dateParts[1] + "-" + dateParts[0];
							document.getElementById("Cancellation_Date").textContent = formattedDate;
						});
	</script>

				
			<script type="text/javascript">
			$(document).ready(function () {
				$("#q").hide();
			    function formatDate(date) {
			        var day = date.getDate().toString().padStart(2, '0');
			        var month = (date.getMonth() + 1).toString().padStart(2, '0');
			        var year = date.getFullYear();
			        return day + '/' + month + '/' + year;
			    }

			    function parseCustomDate(dateString) {
			        var parts = dateString.split("-");
			        return new Date(parts[2], parts[1] - 1, parts[0]);
			    }

			    $('#ContractNo1').on('change', function () {
			        var field2Value = $(this).val();

			        $.ajax({
			            type: 'GET',
			            url: 'fetchingdatatocontractno.obj',
			            data: { "contractno": field2Value },
			            success: function (result) {
			               
			            	 var data = JSON.parse(result);
			                alert(data);
			                var Payment_due_date_str = data[0][1]; // Assuming '23-06-2024'
			                var Payment_date_str = data[0][5]; // Assuming '13-06-2024'

			                // Function to convert 'DD-MM-YYYY' formatted date string to 'YYYY-MM-DD' format
			                function convertDateFormat(dateStr) {
			                    var parts = dateStr.split('-');
			                    if (parts.length === 3) {
			                        return parts[2] + '-' + parts[1] + '-' + parts[0]; // Convert to 'YYYY-MM-DD' format
			                    }
			                    return null; // Return null if dateStr is not in expected format
			                }

			                // Convert date strings to 'YYYY-MM-DD' format
			                var Payment_due_date_iso = convertDateFormat(Payment_due_date_str); // '2024-06-23'
			                var Payment_date_iso = convertDateFormat(Payment_date_str); // '2024-06-13'

			                if (Payment_due_date_iso && Payment_date_iso) {
			                    // Parse dates into Date objects
			                    var Payment_due_date = new Date(Payment_due_date_iso);
			                    var Payment_date = new Date(Payment_date_iso);

			                    // Calculate the difference in days
			                    var timeDifference = Math.abs(Payment_due_date.getTime() - Payment_date.getTime());
			                    var daysDifference = Math.floor(timeDifference / (1000 * 60 * 60 * 24)); // Convert milliseconds to days

			                    alert("Payment due date: " + Payment_due_date_iso + "\nPayment date: " + Payment_date_iso + "\nDays difference: " + daysDifference);
			                } else {
			                    alert("Invalid date format detected.");
			                }
			                $('#ContractDate1').val(data[0][0]);
			                $('#PaymentDueDate234').val(data[0][1]);
			              /*   $('#CancellationDate1').val(data[0][2]); */
			              console.log(data[0][2])
			                 $('#Delayperiod234').val(daysDifference); 
			                $('#PaymentRef1').val(data[0][3]);
			                $('#Contracted_Qty').val(data[0][4]);
			               $("#q").val(data[0][5]);//Payment date
			               alert();
			               if (data[0][2] === null) {
			            	   $('#CancellationDate1').val(data[0][5]);
			               }
			               else{
			            	   $('#CancellationDate1').val(data[0][2]);
			               }
			                $("#Unit_charge").on('input', function() {
			                    var unitCharge = $(this).val(); // Get the input value from #Unit_charge
			                    
			                    var carryingCost = data[0][4] * daysDifference * (unitCharge)/30; // Calculate carrying cost

			                    // Update #Carrying_cost input with calculated value, rounded to 2 decimal places
			                    $('#Carrying_cost').val(Math.ceil(carryingCost.toFixed(2)));
			                });
			                
			                var downloadLink = $('<a></a>').attr({
			                    href: 'downloadSupportingDocument.obj?filename=' + encodeURIComponent(data[0][6]),
			                    class: 'btn btn-primary btn-sm mt-2',
			                    target: '_blank'
			                }).text('View Payment doc');

			                // Append the download link to the form inside .col-sm-4.form-group
			                $("#form3").append(downloadLink);

			              
			            },
			            error: function (error) {
			                alert("Error: " + error);
			            }
			        });
			    });
			});

</script>


<script>
    $(document).ready(function(){
      
        setTimeout(function(){
            $('#flashMessage').fadeOut('slow');
        }, 3000); 
    });
</script>
				
	
	<!-- <script type="text/javascript">
      
 $(document).ready(function() {
	    $('#ContractNo1').on('change', function() {
	    var field2Value = $(this).val();
	    
	     
	    $.ajax({
	        type: 'GET',
	        url: 'fetchingdatatocontractno.obj',
	        data: { "contractno": field2Value },
	        success: function(data) {
	        	
	        	alert(data)
	           
	            
	            var data1 = JSON.parse(data);
	        	alert(data1);
                var Contract_date = data1.Contract_date;
                var Payment_due_date = data1.Payment_duedate;
                
                var Payment_date = data1.Contract_cancel_date;
                
                var date = new Date(Contract_date);
                var month = (date.getMonth() + 1).toString().padStart(2, '0'); 
                var day = date.getDate().toString().padStart(2, '0');
                var year = date.getFullYear();
                var formattedDate = day + '/' + month + '/' + year;
                var calculated_date = year + '/' + month + '/' + day;
                
                var date1 = new Date(Payment_due_date);
                var month1 = (date1.getMonth() + 1).toString().padStart(2, '0'); 
                var day1 = date1.getDate().toString().padStart(2, '0');
                var year1 = date1.getFullYear();
                var formattedDate1 = day1 + '/' + month1 + '/' + year1;
                var calculated_date1 = year + '/' + month + '/' + day;
                
                var timeDifference= calculated_date1-calculated_date;
                var daysDifference = Math.floor(timeDifference / (1000 * 60 * 60 * 24));

                var date1 = new Date(Payment_date);
                var month1 = (date1.getMonth() + 1).toString().padStart(2, '0'); 
                var day1 = date1.getDate().toString().padStart(2, '0');
                var year1 = date1.getFullYear();
                var formattedDate2 = day1 + '/' + month1 + '/' + year1;
                
                $('#ContractDate1').val(formattedDate);
                $('#PaymentDueDate1').val(formattedDate1); 
               
                  $('#CancellationDate1').val(formattedDate2);
                // $('#Delay_period').val(data1.Delay_period);
                 $('#PaymentRef1').val(data1.Payment_id);
                 $('#Contracted_Qty').val(data1.Contracted_qty); 
                 $('#Carrying_cost').val(data1.Carrying_Cost_Charged); 
                 $('#Delayperiod1').val(daysDifference);
	     
	        },
	        error: function(error) {
	            alert("Error: " + error);
	        }
	    });

	    });
	});

      
      </script>  -->

	<!-- END PAGA BACKDROPS-->
	<!-- CORE PLUGINS-->
	<script src="./assets/vendors/jquery/dist/jquery.min.js"
		type="text/javascript"></script>
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