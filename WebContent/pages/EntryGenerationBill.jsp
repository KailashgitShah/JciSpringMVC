<%@page import="java.util.List"%>
<%@page import="java.time.LocalDate"%>
<%@page import="java.time.LocalDateTime"%>
<%@page import="java.time.format.DateTimeFormatter"%>
<%@ page import="java.text.SimpleDateFormat"%>
<%@ page import="java.util.Calendar"%>
<%@ page import="java.util.Locale"%>
<%@page import="java.util.Date"%>
<%@ page import="java.util.*" %>

<%@ page import="java.text.ParseException"%>
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
				<h1 class="page-title">Generation of Bill of Supply</h1>
			</div>

			<%
			List<Object[]> getChallanlist = (List<Object[]>) request.getAttribute("getChallanlist");
			List<Object[]> list = (List<Object[]>) request.getAttribute("list");
			String billOfSupplyNo = (String) request.getAttribute("billOfSupplyNo");
			String challan_no = (String) request.getAttribute("challan_no");
			String Stategstcode = (String) request.getAttribute("Stategstcode");
			String DPC1code = (String) request.getAttribute("DPC1");
			String millname = (String) request.getAttribute("millname");
			List<Object[]>  ShipmentDetails = (List<Object[]>) request.getAttribute("ShipmentDetails");
			List<Object[]>  Perticulargoods = (List<Object[]>) request.getAttribute("Perticulargoods");
			List<Object[]>  Suplierdetails = (List<Object[]>) request.getAttribute("Suplierdetails");
			SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
			String serverCurrentDate = dateFormat.format(new Date());
			
			 String StateName = "";
		     int StateCode = 0;
		     String StateGSTIN = "";
		     String Address1 = "";
		     String Address2 = "";
		     String Address3 = "";
		     String Address4 = "";
		     String PAN = "";
		     String concatenatedString = "";
		     String financialYear = "";
		     for (Object[] row : Suplierdetails) {
		    	 
			        
		    	     StateName= (String )row[0];
		    	  /*    Integer Statecode1= (Integer )row[2];
		    	     StateCode = String.valueOf(Statecode1); */
		    	     
		    	     if (row[1] instanceof Integer) {
		    	    	 StateCode = (Integer) row[1];
		    	    
		    	         }
		    	     
					 
					 StateGSTIN= (String )row[2];
					 PAN = StateGSTIN.substring(2, StateGSTIN.length() - 3);
					 Address1= (String )row[4];
					 Address2= (String )row[5];
					 Address3= (String )row[6];
					 Address4= (String )row[7];
					 
					 LocalDate currentDate = LocalDate.now();
				        int currentYear = currentDate.getYear();
				        int currentMonth = currentDate.getMonthValue();

				      
				        if (currentMonth >= 4) {
				            // If the current month is April or later, the financial year is currentYear-currentYear+1
				            financialYear = currentYear + "-" + (currentYear + 1);
				        } else {
				            // If the current month is before April, the financial year is (currentYear-1)-currentYear
				            financialYear = (currentYear - 1) + "-" + currentYear;
				        }
				
					 
					 concatenatedString = Address1 + " " + Address2 + " " + Address3 + " " + Address4;
					
				
				      
			    }
		    
			
			
			     String strNominalWt = "";
			     String strRate = "";
			     String strNominalQty = "";
			     String Tcsname = "";
			     float total=0;
			     // Iterate over dispatchList data
			     for (Object[] row : list) {
			    	 
				        // Assuming you need to extract values
						 
					        float nominalWt = ((Number) row[4]).floatValue(); 
					        float rate = ((Number) row[5]).floatValue();  
					        float nominalQty = ((Number) row[6]).floatValue(); 
					        float shipmentvalue = ((Number) row[8]).floatValue(); 
					   /*      total+=rate*nominalQty; */
					        total+=shipmentvalue;
					      
				    }
			%>




			<div class="page-content fade-in-up">
				<div class="row">
					<div class="col-md-11">
						<div class="ibox">
							<span id="flashMessage">${msg}</span>
							<div class="ibox-body">
								<form action="saveentryofGenrationbill.obj" method="POST"
									name="myForm" enctype="multipart/form-data">
									<div class="child-checkbox" id="disableform">
										<div class="row">
											<div class="col-sm-4 form-group">
												<label>Challan No</label> <span class="text-danger">*
												</span>&nbsp; <span id="Challan_No" name="Challan_No"
													class="text-danger"> </span>
													<input class="form-control"
													name="Challan_No1" id=Challan_No1 value="<%= challan_no%>" required
													readonly="readonly">
													 <%-- <select name="Challan_No1"
													id="Challan_No1" class="form-control taxtbox"
													onChange="fun()" required>

													<option value="">-Select-</option>
													<%
													for (Object[] row : getChallanlist) {
														String field1 = (String) row[0];
														String field2 = (String) row[1];
													%>
													<option value="<%=field1%>"><%=field1%></option>




													<%
													}
													%>
												</select> --%>


											</div>
											<div class="col-sm-4 form-group">
												<label>Challan Date</label> <span class="text-danger">*
												</span>&nbsp; <span id="Challan_Date" name="Challan_Date"
													class="text-danger"> </span> <input class="form-control"
													name="Challan_Date1" id="ChallanDate1" value="" required
													readonly="readonly">
											</div>




										<!-- 	<div class="col-sm-4 form-group">
												<label>Shipment Details</label> <span class="text-danger">*
												</span>&nbsp; <span id="Shipment_Details" name=Shipment_Details
													class="text-danger"> </span> <input class="form-control"
													name="Shipment_Details" id="Shipment_Details1"
													placeholder="Shipment Details"  readonly="readonly"required>
											</div> -->

											<div class="col-sm-4 form-group">
												<label>Contarct no</label> <span class="text-danger">*
												</span>&nbsp; <span id="Contarct_no" name="Contarct_no"
													class="text-danger"> </span> <input class="form-control"
													name="Contarct_no" id="Contarctno" value=""
													readonly="readonly">
											</div>

										</div>
										
									


									

										<div class="row">

                                                <div class="col-sm-4 form-group">
												<label>Shipment Value</label> <span class="text-danger">*
												</span>&nbsp; <span id="Shipment_Value " name="Shipment_Value "
													class="text-danger"> </span> <input
													class="form-control taxtbox" name="Shipment_Value1" min="0" value="<%=total %>" readonly="readonly"
													 placeholder="Shipment_Value"
													required   >
											</div>
											
											<div class="col-sm-4 form-group">
												<label>Bill of Supply No</label> <input class="form-control"
													name="Bill_of_Supply" id="Bill_of_Supply"
													value="<%=billOfSupplyNo%>" placeholder="Bill_of_Supply"
													readonly="readonly">
											</div>
										
											<div class="col-sm-4 form-group">
												<label>BOS Date</label> <input class="form-control"
													name="BOS_Date" id="BOS_Date"
													value="<%=serverCurrentDate%>" placeholder="BOS_Date"
													readonly="readonly">
											</div>

											
											









										</div>

										<div class="row">
										
										<div class="col-sm-4 form-group">
												<label>IGST Amt</label> <input class="form-control taxtbox"
													name="IGST_Amt" min="0" step="0.01" pattern="[0-9]*"
													id="IGST_Amt" placeholder="IGST_Amt" readonly ="readonly">
											</div>
											
											<div class="col-sm-4 form-group">
												<label>SGST Amt</label> <input class="form-control taxtbox"
													name="SGST_Amt" id="SGST_Amt" min=0 step=0.01
													placeholder="SGST_Amt" readonly="readonly">
											</div>
											<div class="col-sm-4 form-group">
												<label>CGST Amt</label> <input class="form-control taxtbox"
													name="CGST_Amt" id="CGST_Amt" min=0 step=0.01
													placeholder="CGST_Amt" readonly="readonly">
											</div>
											





										</div>

									

										<div class="row">

											<div class="col-sm-4 form-group">
												<label>Recipient Name</label> <input
													class="form-control taxtbox" name="Recipient_Name"
													id="Recipient_Name" placeholder="Recipient_Name" readonly="readonly">
											</div>

											<div class="col-sm-4 form-group">
												<label>Recipient GSTN </label> <input
													class="form-control taxtbox" name="Recipient_GSTN"
													id="Recipient_GSTN" placeholder="Recipient_GSTN" readonly="readonly">
											</div>
											<div class="col-sm-4 form-group">
												<label>Recipient Address</label> <input
													class="form-control taxtbox" name="Recipient_Address"
													id="Recipient_Address" placeholder="Recipient_Address" readonly="readonly">

											</div>





										</div>

										<div class="row">

											<div class="col-sm-4 form-group">
												<label>Consignee Name</label> <input
													class="form-control taxtbox" name="Consignee_Name"
													id="Consignee_Name" placeholder="Consignee_Name" readonly="readonly">
											</div>

											<div class="col-sm-4 form-group">
												<label>Consignee GSTN </label> <input
													class="form-control taxtbox" name="Consignee_GSTN"
													id="Consignee_GSTN" placeholder="Consignee_GSTN" readonly="readonly">
											</div>
											<div class="col-sm-4 form-group">
												<label>Consignee Address</label> <input
													class="form-control taxtbox" name="Consignee_Address"
													id="Consignee_Address" placeholder="Consignee_Address" readonly="readonly">
											</div>




										</div>
									
											<div class="row">
											<div class="col-sm-4 form-group">
												<label>Supplier Name</label> <input
													class="form-control taxtbox" name="Supplier_Name"
													id="Supplier_Name"  value="The Jute Corporation of India limited"placeholder="Supplier_Name" readonly="readonly">
											</div>

											<div class="col-sm-4 form-group">
												<label>Supplier GSTN</label> <input class="form-control"
													name="Supplier_GSTN" id="Supplier_GSTN" value="<%=StateGSTIN %>"
													placeholder="Supplier_GSTN" readonly="readonly">
											</div>
											<div class="col-sm-4 form-group">
												<label>Supplier Address</label> <input class="form-control"
													name="Supplier_Address" id="Supplier_Address" VALUE ="<%=concatenatedString %>"
													placeholder="Supplier_Address" readonly="readonly">
											</div>





										</div>
										
										
										
											
											
										<div class="row">
										
												
											<div class="col-sm-4 form-group">
												<label>TCS Amt</label> <input class="form-control taxtbox"
													name="TCS_Amt" min="0" step="0.01" 
													id="TCS_Amt" placeholder="TCS_Amt" readonly="readonly">
											</div>

											<div class="col-sm-4 form-group">
												<label>TDS Amt</label><span class="text-danger">*
												</span> <input class="form-control taxtbox"
													name="TDS_Amt" min="0" step="0.01" pattern="[0-9]*" required
													id="TDS_Amt" placeholder="TDS_Amt" value="0" readonly="readonly">
											</div>
												<div class="col-sm-4 form-group">
												<label>Financial year</label> <span class="text-danger">*
												</span>&nbsp; <span id="Financial_year4" name="Financial_year3"
													class="text-danger"> </span> <input class="form-control"
													name="Financial_year2" id="Financial_year1" value="<%=financialYear %>"
													readonly="readonly">
											</div>
											
											<div class="col-sm-2 form-group" style="display: none;">
												<label "display:none;">Clientstate </label> <span
													class="text-danger">* </span>&nbsp; <span id="Contarct_no"
													name="Contarct_no" class="text-danger"> </span> <input
													type="hidden" class="form-control" name="Clientstate"
													id="Clientstate" value="" readonly="readonly">
											</div>
											<div class="col-sm-2 form-group" style="display: none;">
												<label "display:none;">Clientcode </label> <span
													class="text-danger">* </span>&nbsp; <span id="Contarct_no"
													name="Contarct_no" class="text-danger"> </span> <input
													type="hidden" class="form-control" name="Clientcode"
													id="Clientcode" value="" readonly="readonly">
											</div>
											<div class="col-sm-2 form-group" style="display: none;">
												<label "display:none;">ClientPan </label> <span
													class="text-danger">* </span>&nbsp; <span id="Contarct_no"
													name="Contarct_no" class="text-danger"> </span> <input
													type="hidden" class="form-control" name="ClientPan"
													id="ClientPan" value="" readonly="readonly">
											</div>
												<div class="col-sm-2 form-group" style="display: none;">
												<label "display:none;">PAN </label> <span
													class="text-danger">* </span>&nbsp; <span id="Contarct_no"
													name="Contarct_no" class="text-danger"> </span> <input
													type="hidden" class="form-control" name="PAN23"
													id="PAN1" value="<%=PAN %>" readonly="readonly">
											</div>
											
											<div class="col-sm-2 form-group" style="display: none;">
												<label "display:none;">Sategstcode </label> <span
													class="text-danger">* </span>&nbsp; <span id="Stategstcode"
													name="Stategstcode" class="text-danger"> </span> <input
													type="hidden" class="form-control" name="Stategstcode"
													id="Stategstcode" value="<%=Stategstcode %>" readonly="readonly">
											</div>
											
											<div class="col-sm-2 form-group" style="display: none;">
												<label "display:none;">DPC1 </label> <span
													class="text-danger">* </span>&nbsp; <span id="ro_id"
													name="ro_id" class="text-danger"> </span> <input
													type="hidden" class="form-control" name="DPC1"
													id="DPC12" value="<%=DPC1code %>" readonly="readonly">
											</div>
											
											
									     	<%
												for (Object[] row : ShipmentDetails) {
												%>
												<div class="col-sm-2 form-group">
												    <label style="display:none;">Driver name</label>
												    <span class="text-danger"> </span>
												    <input type="hidden" class="form-control" name="Driver_name" id="Driver_name" value="<%= row[4] %>" readonly="readonly">
												</div>
												<div class="col-sm-2 form-group">
												    <label style="display:none;">Driver Lic no</label>
												    <span class="text-danger"> </span>
												    <input type="hidden" class="form-control" name="Driver_Lic_no" id="Driver_Lic_no" value="<%= row[3] %>" readonly="readonly">
												</div>
												<div class="col-sm-2 form-group">
												    <label style="display:none;">Vehicle no</label>
												    <span class="text-danger"> </span>
												    <input type="hidden" class="form-control" name="Vehicle_no" id="Vehicle_no" value="<%= row[2] %>" readonly="readonly">
												</div>
												<%
												}
												%>

											
											
										
										</div>
										
										<div class="row">
									
												<div class="col-sm-4 form-group">
												<label>Invoice Value</label> <input
													class="form-control taxtbox" name="Invoice_Value"
													id="Invoice_Value" min="0" step="0.01" pattern="[0-9]*"
													placeholder="Invoice_Value" readonly="readonly">
											</div>
											
												<div class="col-sm-4 form-group">
												<label>Transit policy No</label> <span class="text-danger">*
												</span>&nbsp; <input class="form-control"
												oninput="this.value = this.value.toUpperCase();"
													maxlength="16" type="text" pattern="[A-Za-z0-9/-]*"
													name="TrnasitPolicyNo" id="TrnasitPolicyno" required 
													>
											</div>
											
											<div class="col-sm-2 form-group" style="display: none;">
												<label"display:none;">Contarctqty </label> <span
													class="text-danger">* </span>&nbsp; <span id="Contarctqty1"
													name="Contarctqty" class="text-danger"> </span> <input
													type="hidden" class="form-control" name="Statename23"
													id="Statename2" value="<%=StateName %>" readonly="readonly">
											</div>
											<div class="col-sm-2 form-group" style="display: none;">
												<label"display:none;">Contarctqty </label> <span
													class="text-danger">* </span>&nbsp; <span id="Contarctqty1"
													name="Contarctqty" class="text-danger"> </span> <input
													type="hidden" class="form-control" name="StaeCode23"
													id="StaeCode2" value="<%=StateCode %>" readonly="readonly">
											</div>
											<div class="col-sm-2 form-group" style="display: none;">
												<label"display:none;">MIllcode </label> <span
													class="text-danger">* </span>&nbsp; <span id="Contarctqty1"
													name="Contarctqty" class="text-danger"> </span> <input
													type="hidden" class="form-control" name="millcode"
													id="millcode23" value="<%=StateCode %>" readonly="readonly">
											</div>
											
											
										</div> 
										
												
										 <table id="Shipmenttabel" class="table table-bordered">
											  
											    <thead class="thead-light">
											   
											    <tr>
											            <th style="width: 200px;">SHIPMENT DETAILS</th>
											       </tr>
											        <tr>
											            <th>Date_of_shipment</th>
											            <th>Mode_of_shipment</th>
											            <th>Vehicle_no</th>
											            <th>Driver_name</th>
											            <th>License_no</th>
											            <th>Driver_contact</th>
											          
											          
											        </tr>
											    </thead>
											    <tbody>
											        	<% 
											        	
											        	for (Object[] row : ShipmentDetails) {
															%>
															<tr>
															<td><%= row[0] %></td>
															<td><%= row[1] %></td>
															<td><%= row[2] %></td>
															<td><%= row[3] %></td>
															<td><%= row[4] %></td>
															<td><%= row[5] %></td>
															
															<% 
															}
											        	%>
			
													
											    </tbody>
											</table>
											
												 <table id="shipmentdetailsTable" class="table table-bordered">
											    <thead class="thead-light">
											       <tr>
											            <th style="width: 200px;">Particulars of Goods</th>
											       </tr>
											        <tr>
											            <th>Crop year </th>
											            <th> Bale Mark</th>
											            <th>Variety/Grade</th>
											            <th> No of bales</th>
											            <th>Nominal wt/bale</th>
											            <th>Nominal Qty</th>
											            <th>Rate(RS/UNIT)</th>
											          
											        </tr>
											    </thead>
											    <tbody>
											     <% 
											        	
											        	for (Object[] row : Perticulargoods) {
															%>
															<tr>
															<td><%= row[0] %></td>
															<td><%= row[1] %></td>
															<td><%= row[2] %></td>
															<td><%= row[3] %></td>
															<td><%= row[4] %></td>
															<td><%= row[5] %></td>
															<td><%= row[6] %></td>
															
															<% 
															}
											        	%>
											    </tbody>
											</table>
										
								
											
											<div class="row">

											<div class="col-sm-0.7 form-group">
												<input type="submit" value="GenerateBILLSupply"
													class="btn btn-primary" id="submit">
											</div>
											<!--   <div class="clear">
												  <button type="submit" value="submit" name="subscribe" id="mc-embedded-subscribe" class="submit- btn btn-default" onclick="window.open('https://login.mailchimp.com/signup'), window.location = 'https://google.com'">Submit</button>
											   </div>  -->
											<div class="col-sm-1 form-group">
												<!-- <input type="cancel" value="cancel"class="btn btn-primary" id="cancel"> -->
												<!--   <input type='submit' name='submit' id='submitBtn' class='enableOnInput' disabled='disabled' /> -->

												<button class="btn btn-primary custom-button" type="button"
													
													onclick="rejectAndNavigate()">Cancel</button>

											</div>
										</div>

										<div class="modal fade" id="rejectModal" tabindex="-1"
											role="dialog" aria-labelledby="rejectModalLabel"
											aria-hidden="true">
											<div class="modal-dialog" role="document">
												<div class="modal-content">
													<div class="modal-header">
														<h5 class="modal-title" id="rejectModalLabel">Reject
															Confirmation</h5>
														<button type="button" class="close" data-dismiss="modal"
															aria-label="Close">
															<span aria-hidden="true">&times;</span>
														</button>
													</div>
													<div class="modal-body">
														<p>Are you sure you want to reject this record?</p>
														<label for="remarks">Remarks:</label> <input
															class="form-control" type="text" id="remarks"
															name="remarks">
													</div>
													<div class="modal-footer">
														<button type="button" class="btn btn-secondary"
															data-dismiss="modal">Close</button>
														<button type="button" class="btn btn-danger"
															id="rejectModalButton" onclick="rejectRecord()">Yes,
															Reject</button>

													</div>
												</div>
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
		$(document).ready(function() {
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
		function openRejectModal() {

			$('#rejectModal').modal('show');
		}

		function closeRejectModal() {
			$('#rejectModal').modal('hide');
		}

		function rejectAndNavigate() {
			openRejectModal()
		  
			$('#rejectModalButton').off('click').on('click', function() {
				var remarks = $('#remarks').val().trim();
		
				
				if (remarks === "") {
					return;
				}
				var contno = document.getElementById('Contarctno').value;
		      
				$.ajax({
					type : 'POST',
					url : 'saveRemarksofbill.obj',
					data : {
						"remarks" : remarks,
						"con_no" : contno,
					},
					success : function(data) {
					
						var responseData = JSON.parse(data);
						if (responseData.redirect) {
							
							 window.history.back();
 
 
 
						} else {

						}
					},
					error : function(error) {
						console.error('Ajax error:', error);
					}
				});

				closeRejectModal();
			});
		}
	</script>



	
	
    <script type="text/javascript">
    $(document).ready(function() {
        function formatDate(date) {
            var day = date.getDate().toString().padStart(2, '0');
            var month = (date.getMonth() + 1).toString().padStart(2, '0');
            var year = date.getFullYear();
            return day + '/' + month + '/' + year;
        }

        var field2Value = <%= challan_no %>;
    
        console.log(field2Value);

        $.ajax({
            type: 'GET',
            url: 'fetchingdata1.obj',
            data: { "contractno": field2Value },
            success: function(data) {
            	
               
                try {
                    var dataArray = JSON.parse(data);

                    if (dataArray && dataArray.length > 0) {
                        var contractNo = dataArray[0][0];
                        var creationDateStr = dataArray[0][1];
                        var millcode = dataArray[0][2];
                        var creationDate = new Date(creationDateStr);
                        console.log("Creation Date as Date object: ", creationDate);

                        $('#Contarctno').val(contractNo);
                        $('#ChallanDate1').val(formatDate(creationDate));
                        
                    

                        $.ajax({
                            type: 'GET',
                            url: 'contrcatnotomill.obj',
                            data: { "contractno": contractNo },
                            success: function(secondData) {
                            	
                            
                                var dataArray = JSON.parse(secondData);
                              
                                if (dataArray && dataArray.length > 0) {
                                    var millcode = dataArray[0][0];
                                    alert(millcode);
                                    var cropyear = dataArray[0][1];
                                    /* $('#Financial_year1').val(cropyear); */
                                  
                                    $('#millcode23').val(millcode);
                                    

                                    $.ajax({
                                        type: 'GET',
                                        url: 'fetchingdataforbill.obj',
                                        data: { "contractno": millcode },
                                       
                                        success: function(thirdData) {
                                           alert(thirdData);
                                           
                                            try {
                                                var dataArray = JSON.parse(thirdData);
                                                if (dataArray && dataArray.length > 0) {
                                                	 var  unit_name = dataArray[0][0];
                                                     
                                                     var unit_address1 = dataArray[0][1] || '';
                                                     var unit_address2 = dataArray[0][2] || '';
                                                     var unit_address3 = dataArray[0][3] || '';
                                                     var unit_address4 = dataArray[0][4] || '';

                                                     var full_address = (unit_address1 + ' ' + unit_address2 + ' ' + unit_address3 + ' ' + unit_address4).trim();

                                                     
                                                     
                                                     var unit_address5 = dataArray[0][9] || '';
                                                     var unit_address6 = dataArray[0][10] || '';
                                                     var unit_address7 = dataArray[0][11] || '';
                                                     var unit_address8 = dataArray[0][12] || '';

                                                     var full_address1 = (unit_address5 + ' ' + unit_address6 + ' ' + unit_address7 + ' ' + unit_address8).trim();

                                                     
                                                    
                                                     var unit_state = dataArray[0][5];
                                                
                                                     var client_gstin = dataArray[0][6];
                                                     
                                                     var client_pan = dataArray[0][7];
                                                     var client_state = dataArray[0][8];
                                                    var client_name = dataArray[0][13];
                                                    
                                                    alert(client_name);
                                                   
                                                    $('#Recipient_Name').val(unit_name);
                                                    $('#Recipient_GSTN').val(client_gstin);
                                                    $('#Recipient_Address').val(full_address);
                                                    $('#Consignee_Name').val(client_name);
                                                    $('#Consignee_GSTN').val(client_gstin);
                                                    $('#Consignee_Address').val(full_address1);
                                                    $('#Clientstate').val(client_state);
                                                    $('#Clientcode').val(unit_state);
                                                    $('#ClientPan').val(client_pan);
                                                    
                                                     calculateTCS(unit_name);
                                                    
                                                    
                                                }
                                            } catch (error) {
                                                console.error("Error parsing JSON: " + error);
                                            }
                                        },
                                        error: function(error) {
                                            console.error('Third Ajax call error:', error);
                                        }
                                    });
                                    
                                    

                                }
                            },
                            error: function(error) {
                                console.error('Second Ajax call error:', error);
                            }
                        });

                        var formattedDate = formatDate(creationDate);
                        $('#Contarctno').val(contractNo);
                        $('#ChallanDate1').val(formattedDate);
                    }
                } catch (error) {
                    console.error("Error parsing JSON: " + error);
                }
            },
            error: function(error) {
                console.error('First Ajax call error:', error);
            }
        });
    });


         
         </script>
         
        <script>

            window.addEventListener('load', function() {

		    calculateGST();
		   
		});
		</script>
         
         
         
         <script>
		function calculateGST() {
			// Retrieve the shipment value entered by the user
		/* 	var shipmentValue = parseFloat(document
					.getElementsByName("Shipment_Value1")[0].value);
 */
 
          var shipmentValue =<%=total%>;
			// Check if the entered value is a valid number
			if (!isNaN(shipmentValue)) {
				// Calculate SGST and CGST amounts (assuming 18% GST rate)
				var gstRate = 0.0;
				var sgstAmt = (gstRate / 2) * shipmentValue;
				var cgstAmt = (gstRate / 2) * shipmentValue;
				var totalGstAmt = sgstAmt + cgstAmt;
				var invoiceValue = shipmentValue + totalGstAmt;

				// Set the calculated amounts to the respective input fields
				document.getElementById("SGST_Amt").value = sgstAmt.toFixed(2);
				document.getElementById("CGST_Amt").value = cgstAmt.toFixed(2);
				document.getElementById("IGST_Amt").value = cgstAmt.toFixed(2);
				document.getElementById("Invoice_Value").value = invoiceValue
						.toFixed(2);
			}
		}
	</script>
	
	
	<script>
    function calculateTCS(unit_name) {
     
      /*   var shipmentValue = parseFloat(document.getElementsByName("Shipment_Value1")[0].value);
        */
        var shipmentValue =<%=total%>;
       

        
        if (!isNaN(shipmentValue)) {
           
            $.ajax({
                type: 'GET',
                url: 'fetchingdataMillname.obj',
                data: { "millname": unit_name },
                success: function(milldata) {
                  
                    console.log("Mill data:", milldata);
                    
                    var tsccount = (milldata === 'true') ? 0.0 : 0.01;
                    var Tcsammount = (tsccount / 100) * shipmentValue;
                    
                   
                    var Tcsammount = (tsccount / 100) * shipmentValue;
                    
                 
                    document.getElementById("TCS_Amt").value = Tcsammount.toFixed(2);
                },
                error: function(error) {
                   
                    console.error('Ajax call error:', error);
                }
            });
        }
    }
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