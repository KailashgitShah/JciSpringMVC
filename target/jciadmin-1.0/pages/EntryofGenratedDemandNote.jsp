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
				<h1 class="page-title">Entry of Genration Demand Note</h1>
			</div>

			<%
			GenrationDEmandDto genrationDemandNoteModel  = (GenrationDEmandDto) request.getAttribute("cotract_No");
			List<Object>getdataList1=(List<Object>)request.getAttribute("getdataList1");
			String demandNoteNo= (String)request.getAttribute("demandNoteNumber");
			
				String formattedDate = (String)request.getAttribute("formattedDate");
			
			
			%>
			<div class="page-content fade-in-up">
				<div class="row">
					<div class="col-md-11">
						<div class="ibox">
							<span>${msg}</span>
							<div class="ibox-body">
								<form action="saveentryofGenrationDeamandNote.obj" method="POST">
									 <!-- <div class="child-checkbox" id="disableform"> -->
									 <!--   <div class="col-4">
											    <div class="form-check mb-4">
											      <input class="form-check-input" type="checkbox" id="inlineFormCheck" name ="Waiver_flag" >
											      
											       <label class="form-check-label" for="inlineFormCheck">
											       Waiver_flag
											      </label> 
											    </div>
											  </div> -->
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
												<label>Contracted Qty </label> <input
													class="form-control taxtbox" name="Contracted_Qty" id="Contracted_Qty" min="0"
													step="0.01" readonly="readonly"   value=""
													placeholder="Contracted_Qty" required>
											</div>
											<div class="col-sm-4 form-group">
												<label>Carrying_cost</label> <input
													class="form-control taxtbox" name="Carrying_cost" id ="Carrying_cost" min="0"
													step="0.01" readonly="readonly"  value=""
													placeholder="Carrying_cost" required>
											</div>
											<div class="col-sm-4 form-group">
												<label>Unit_charge</label> <input
													class="form-control taxtbox" name="Unit_charge"
													id=" Unit_charge" min="0" step="0.01" type="number" 
													placeholder="Unit_charge" required>
											</div>
											






										</div>

										<div class="row">

											<!-- <div class="col-sm-4 form-group">
												<label>Waiver_flag</label> <input
													class="form-control taxtbox" name="Waiver_flag"
													type="number" min="1" step="1" placeholder="Waiver_flag"
													required>
											</div> -->

											<div class="col-sm-4 form-group">
												<label>Remarks </label> <input class="form-control taxtbox"
													name="Remarks" id="Remarks" type="text" placeholder="Remarks" required>
											</div>

											<div class="col-sm-4 form-group">
												<label>Demand note no</label> <input
													class="form-control taxtbox" name="Demand_note_no" 
													 placeholder="Demand_note_no" value="<%= demandNoteNo %>"required>
											</div>
											
											
											<div class="col-sm-4 form-group">
												<label>Demand note date</label> <span class="text-danger">*
												</span>&nbsp; <span id="Created_on" name="Created_on"
													class="text-danger"> </span> <input class="form-control"
													name="Demand_note_date" id="Created_on" type="date" required>
											</div>

										</div>


										<div class="row">
											

											

											
											<!--  <div class="col-sm-4 form-group" id="carryingCostFormGroup" style="display: none;">
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
														  
				                                    </div>  -->
				                                    



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
		<script>
				
				  $(document).ready(function() {
					  const checkbox = $('#inlineFormCheck');
				      const carryingCostFormGroup = $('#carryingCostFormGroup');
					 /*  const waiverApprovedByLabel = $('#WaiverApprovedBy1');
					  const waiverApprovedBySelect = $('#WaiverApprovedBy2'); */

					  // ...

					  checkbox.change(function() {
					      if (checkbox.is(':checked')) {
					          carryingCostFormGroup.show();
					        /*   waiverApprovedByLabel.show();
					          waiverApprovedBySelect.show(); */
					      } else {
					          carryingCostFormGroup.hide();
					     /*      waiverApprovedByLabel.hide();
					          waiverApprovedBySelect.hide(); */
					      }
					  });
				  });
				</script>
				
				
			<script type="text/javascript">
			$(document).ready(function () {
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
			            success: function (data) {
			                console.log(data);
			                var data1 = JSON.parse(data);

			                var Contract_date = new Date(data1.Contract_date);
			                var Payment_due_date = parseCustomDate(data1.Payment_duedate);
			                var Payment_date = new Date(data1.Contract_cancel_date);

			                var formattedDate = formatDate(Contract_date);
			                var formattedDate1 = formatDate(Payment_due_date);
			                var formattedDate2 = formatDate(Payment_date);

			                var timeDifference = Math.abs(Payment_due_date - Contract_date);
			                var daysDifference = Math.floor(timeDifference / (1000 * 60 * 60 * 24));

			                $('#ContractDate1').val(formattedDate);
			                $('#PaymentDueDate234').val(formattedDate1);
			                $('#CancellationDate1').val(formattedDate2);
			                $('#Delayperiod234').val(daysDifference);
			                $('#PaymentRef1').val(data1.Payment_id);
			                $('#Contracted_Qty').val(data1.Contracted_qty);
			                $('#Carrying_cost').val(data1.Carrying_Cost_Charged);
			            },
			            error: function (error) {
			                alert("Error: " + error);
			            }
			        });
			    });
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