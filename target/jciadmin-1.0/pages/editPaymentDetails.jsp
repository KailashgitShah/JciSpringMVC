<%@page import="org.apache.poi.util.SystemOutLogger"%>

<%@page import="com.jci.model.EntryPaymentDetailsModel"%>
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
				<h1 class="page-title">Edit the Payment Instrument</h1>
			</div>

			<%
			EntryPaymentDetailsModel entryPaymentDetailsModel  = (EntryPaymentDetailsModel) request.getAttribute("entryPaymentDetailsModel");
		    
		    //String date = (String) request.getAttribute("parsed");
		    String date1 = (String) request.getAttribute("parsed");
			String date3 = (String) request.getAttribute("parsed1");
			String date4 = (String) request.getAttribute("parsed2"); 
			%>

			<div class="page-content fade-in-up">
				<div class="row">
					<div class="col-md-11">
						<div class="ibox">
							<span>${msg}</span>
							<div class="ibox-body">
								<form action="updatePaymentDetail.obj" method="post">
									<div class="child-checkbox" id="disableform">
										<%
										if (entryPaymentDetailsModel != null) {
										%>
										<input type="hidden" name="Payment_id"
											value="<%=entryPaymentDetailsModel.getPayment_id() %>">
										<%
										}
										%>

									
										<div class="row">
											<%

											%>
											<div class="col-sm-4 form-group">
										    <label>Contract No.</label>
										    <span class="text-danger">*</span>
										    <span id="contractno" name="contractno" class="text-danger"></span>
										    <select name="fullcontractno" id="fullcontractno" class="form-control taxtbox"  required >
										        <option value="">-Select-</option>
										        <option value="12345"  <% if(entryPaymentDetailsModel.getContractno().equals("12345")) { out.print("selected"); } %>>12345</option>
										        <option value="1234567"  <% if(entryPaymentDetailsModel.getContractno().equals("1234567")) { out.print("selected"); } %>>1234567</option>
										        <option value="19764567"  <% if(entryPaymentDetailsModel.getContractno().equals("19764567")) { out.print("selected"); } %>>19764567</option>
										    </select>
										</div>
										       
                                         <div class="col-sm-4 form-group">
												<label>Instrument No</label> 
												<span class="text-danger">* </span>&nbsp; <span id="instrument" name=instrument class="text-danger" value="<%=entryPaymentDetailsModel.getInstrumentno() %>"  "> </span>
												<input class="form-control" name="instrument" id="instrument" type="Number" value="<%=entryPaymentDetailsModel.getInstrumentno() %>" required>
										</div> 
										 <div class="col-sm-4 form-group">
												<label>Instrument Date</label> 
												<span class="text-danger">* </span>&nbsp; <span id="instdate" name="instdate" class="text-danger"> </span>
												<input class="form-control" name="instdate" id="instdate" type="date" value=<%= date1 %> required>
										   </div>
																					
										</div>

										<div class="row">
										 
										 <div class="col-sm-4 form-group">
	                                             <label>IFSC </label>
	                                             <input class="form-control taxtbox" name="IFSC"  type="text" placeholder="IFSC"  value="<%=entryPaymentDetailsModel.getIFSC() %>" required>
	                                       </div>
	                                       
	                                       <div class="col-sm-4 form-group">
	                                             <label>Bank Name</label>
	                                             <input class="form-control taxtbox" name="BankName" min="0" type="text" placeholder="Branch" onchange="deleteErrorMsg()"  value="<%=entryPaymentDetailsModel.getBankName() %>"required>
	                                       </div>
	                                       
	                                       <div class="col-sm-4 form-group">
	                                             <label>Branch</label>
	                                             <input class="form-control taxtbox" name="Branch" min="0" type="text" placeholder="Branch" value="<%=entryPaymentDetailsModel.getBranch() %>" required>
	                                       </div>
	                                       
	                                       

											

										</div>

										<div class="row">


											<%-- <div class="col-sm-4 form-group">
	                                            <label> Qty. Allowed</label> 
	                                            <span class="text-danger">* </span>&nbsp; <span id="QtyAllowed " name="QtyAllowed " class="text-danger" type="double"> </span>
												 <input class="form-control taxtbox" name="QtyAllowed" min="0" type="double" placeholder="Qty Allowed" value="<%=entryPaymentDetailsModel.getQtyAllowed() %>" required>
	                                     </div> --%>
	                                     <div class="col-sm-4 form-group">
	                                             <label>Supporting Document</label>
	                                             <input class="form-control taxtbox" name="SupportingDocument" min="0" type="file" placeholder="Supporting Document" value="<%=entryPaymentDetailsModel.getSupportingDocument() %>" required>
	                                       </div>
										
											<div class="col-sm-4 form-group">
												<label>Payment Type</label> <span class="text-danger">*</span>
												&nbsp; <span id="paymenttype" name="paymenttype"
													class="text-danger"> </span> <select name="paymenttype"
													id="paymenttype" class="form-control taxtbox" required>
													<option value="" >-Select-</option>
													<!-- <option value="neft">NEFT</option> -->

													<option
														<%if (entryPaymentDetailsModel.getPayment().equals("NEFT")) {out.print("selected");}%>
														value="NEFT">NEFT</option>
													<option
														<%if (entryPaymentDetailsModel.getPayment().equals("RTGS")) {out.print("selected");}%>
														value="RTGS">RTGS</option>
													<option
														<%if (entryPaymentDetailsModel.getPayment().equals("Cheque")) {out.print("selected");}%>
														value="CHEQUE">CHEQUE</option>
													<option
														<%if (entryPaymentDetailsModel.getPayment().equals("Cash")) {out.print("selected");}%>
														value="Cash">CASH</option>
													<option
														<%if (entryPaymentDetailsModel.getPayment().equals("Letter_of_Credit"))  {out.print("selected");}%>
														value="Letter_of_Credit">letter of credit</option>
												</select>
											</div>
											
										</div>

										<div class="row">

											<div class="col-sm-4 form-group">
												<label id="doexpiry">Date of Expiry</label> 
												<input class="form-control" name="dateofexpiry" id="dateofexpiry" placeholder="Date of Expiry" type="date"  value="<%= date3 %>"required>
										   </div>
										   <div class="col-sm-4 form-group">
												<label id="doshipment">Last Shipment date</label> 
												<input class="form-control" name="dateofship" id="dateofship" placeholder="Date of Shipment" type="date" value="<%= date4 %>" required>
										   </div>
                                   
                                            <div class="col-sm-4 form-group">
	                                             <label id="autoamounta">Auto Revolving Amount</label>
	                                             <input class="form-control taxtbox" name="autorevolvingamount" id="autorevolvingamount" min="0" type="number" placeholder="Auto Revolving Amount" 	value="<%=entryPaymentDetailsModel.getAutorevolvingamount()%>" required>
	                                       </div>   	

										</div>
					
										<div class="row">
										<div class="col-sm-4 form-group">
	                                            <label>Instrument Value </label> 
	                                            <span class="text-danger">* </span>&nbsp; <span id="InstrumentValue " name="InstrumentValue " class="text-danger" type="double"> </span>
												 <input class="form-control taxtbox" name="InstrumentValue" min="0" type="double" placeholder="Instrument Value" value="<%=entryPaymentDetailsModel.getInstrumentValue() %>" required>
	                                     </div>
	                                     </div>
	                                     <div class="row">
											<div class="col-sm-12 form-group">
												<button type="submit" class="btn btn-primary">ADD</button>
												<!-- <input type="submit" value="Submit" class="btn btn-primary"
													id="submit"> -->
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
    
    <script type="text/javascript">
      function myFunction()  
	      {
    	  $("#doexpiry").hide();
    	  $("#dateofexpiry").hide();
    	  $("#doshipment").hide();
    	  $("#dateofship").hide();
    	  $("autorevolvingamount")hide();
    	  
	       // alert("69");
	      }
    </script> 
    
  
    
      <script type="text/javascript">
	$("#paymenttype").on("change", function() {
		var paymenttype = $("#paymenttype").val();
		if(paymenttype == "Letter_of_Credit")
			{
			  $("#doexpiry").show();
	    	  $("#dateofexpiry").show();
	    	  $("#doshipment").show();
	    	  $("#dateofship").show();
	    	  $("#autoamounta").show();
	    	  $("#autorevolvingamount").show();
			}
		else
			{
			  $("#doexpiry").hide();
	    	  $("#dateofexpiry").hide();
	    	  $("#doshipment").hide();
	    	  $("#dateofship").hide();
	    	  $("#autoamounta").hide();
	    	  $("#autorevolvingamount").hide();
			}
		//alert(paymenttype);
	});
	</script> 
 -->

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
										