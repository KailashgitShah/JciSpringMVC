<!DOCTYPE html>
<html lang="en">
<%@page import="com.jci.model.FarmerRegModel"%>
<%@ page import="javax.servlet.http.HttpServletRequest"%>
<%@page import="com.jci.model.StateList"%>
<%@page import="java.util.List"%>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width initial-scale=1.0">
<title>JCI | CMS</title>
<!-- GLOBAL MAINLY STYLES-->
<link
	href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css"
	rel="stylesheet">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<link rel="stylesheet" href="build/css/intlTelInput.css">
<link rel="stylesheet" href="build/css/demo.css">
<link
	href="<%=request.getContextPath()%>/resources/css/styleUserReg.css"
	rel="stylesheet">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<script type="text/javascript"
	src='<%=request.getContextPath()%>/resources/js/responsivevoice.js'></script>
<script type="text/javascript"
	src='<%=request.getContextPath()%>/resources/js/custom.js'></script>
<script type="text/javascript"
	src='<%=request.getContextPath()%>/resources/js/jquery.mCustomScrollbar.concat.min.js'></script>
<script type="text/javascript"
	src='<%=request.getContextPath()%>/resources/js/jquery.validate.min.js'></script>
<link href="./assets/vendors/font-awesome/css/font-awesome.min.css"
	rel="stylesheet" />
<link href="./assets/vendors/themify-icons/css/themify-icons.css"
	rel="stylesheet" />
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<!-- PLUGINS STYLES-->
<!-- THEME STYLES-->
<link href="assets/css/main.min.css" rel="stylesheet" />
<!-- PAGE LEVEL STYLES-->
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
				<h1 class="page-title">Farmer Details</h1>
			</div>
			<%
				int userId = 0;
				if(session.getAttribute("userId")!=null){
					 userId = (int) (session.getAttribute("userId"));
				} 
			%>
			<div class="page-content fade-in-up">
				<div class="row">
					<div class="col-md-11">
						<div class="ibox">
							<div class="ibox-head">
								<!-- <div class="ibox-title">Basic form</div> -->
								<span>${msg}</span>
							</div>
								<div class="row">
							<div class="col-sm-4 form-group">
							
							<a href="ViewFarmerRegistration.obj">Go Back</a>
							</div>
					</div>
							<% 
								List<FarmerRegModel> editFarmers = (List<FarmerRegModel>)request.getAttribute("farmerDetailsById");
							FarmerRegModel editFarmer = editFarmers.get(0);
							%>
							<div class="ibox-body">
								
									<table>
									<tr>
											<td ><b>Name of Farmer</b></td> 
											
											<td><b>:&nbsp;&nbsp;&nbsp;<%=editFarmer.getF_NAME() %></b></td>
											</tr>
											<tr>
											<td ><b>Caste</b></td> 
											
											<td><b>:&nbsp;&nbsp;&nbsp;<%=editFarmer.getCaste() %></b></td>
											</tr>
											<tr>
											<td ><b>Gender</b></td> 
											
											<td><b>:&nbsp;&nbsp;&nbsp;<%=editFarmer.getGender() %></b></td>
											</tr>
											<tr>
											<td ><b>Address</b></td> 
											
											<td><b>:&nbsp;&nbsp;&nbsp;<%=editFarmer.getF_ADDRESS() %></b></td>
											</tr>
											<tr>
											<td ><b>State</b></td> 
											
											<td><b>:&nbsp;&nbsp;&nbsp;<%=editFarmer.getState_name() %></b></td>
											</tr>
											<tr>
											<td ><b>District</b></td> 
											
											<td><b>:&nbsp;&nbsp;&nbsp;<%=editFarmer.getDistrict_name() %></b></td>
											</tr>
											<tr>
											<td ><b>Block</b></td> 
											
											<td><b>:&nbsp;&nbsp;&nbsp;<%=editFarmer.getF_Block() %></b></td>
											</tr>
											<tr>
											<td ><b>Police Station</b></td> 
											
											<td><b>:&nbsp;&nbsp;&nbsp;<%=editFarmer.getPolice_station() %></b></td>
											</tr>
											<tr>
											<td ><b>Pincode</b></td> 
											
											<td><b>:&nbsp;&nbsp;&nbsp;<%=editFarmer.getF_Pincode() %></b></td>
											</tr>
											<tr>
											<td ><b>Identity Type</b></td> 
											
											<td><b>:&nbsp;&nbsp;&nbsp;<%=editFarmer.getF_ID_PROF_TYPE() %></b></td>
											</tr>
											<tr>
											<td ><b>Identity Proof No.</b></td> 
											
											<td><b>:&nbsp;&nbsp;&nbsp;<%=editFarmer.getF_ID_PROF_NO() %></b></td>
											</tr>
											<tr>
											<td ><b>I-CARE Registration</b></td> 
											
											<td><b>:&nbsp;&nbsp;&nbsp;<%=editFarmer.getF_I_CARE_REGISTERED() %></b></td>
											</tr>
											<tr>
											<td ><b>Land Holding (Bigha)</b></td> 
											
											<td><b>:&nbsp;&nbsp;&nbsp;<%=editFarmer.getLand_holding()%></b></td>
											</tr>
											<tr>
											<td ><b>Mobile Number</b></td> 
											
											<td><b>:&nbsp;&nbsp;&nbsp;<%=editFarmer.getF_MOBILE()%></b></td>
											</tr>
											<tr>
											<td ><b>Bank A/C Type</b></td> 
											
											<td><b>:&nbsp;&nbsp;&nbsp;<%=editFarmer.getBank_ac_type() %></b></td>
											</tr>
											<tr>
											<td ><b>Bank A/C No.</b></td> 
											
											<td><b>:&nbsp;&nbsp;&nbsp;<%=editFarmer.getF_AC_NO() %></b></td>
											</tr>
											<tr>
											<td ><b>Bank IFSC</b></td> 
											
											<td><b>:&nbsp;&nbsp;&nbsp;<%=editFarmer.getF_BANK_IFSC()%></b></td>
											</tr>
											<tr>
											<td ><b>Bank Name </b></td> 
											
											<td><b>:&nbsp;&nbsp;&nbsp;<%=editFarmer.getF_BANK_NAME() %></b></td>
											</tr>
											<tr>
											<td ><b>Bank Branch</b></td> 
											
											<td><b>:&nbsp;&nbsp;&nbsp;<%=editFarmer.getF_BANK_BRANCH() %></b></td>
											</tr>
											</table>

						
						
						
            <h1 class="page-title" class="center">Documents</h1>
            <div class="doremon">
            <div class="row">
	            <div class="col-md-6">
	            <div class="text-details">	            
		         <a href="http://49.50.79.121:8080/FarmerRegistration/<%=editFarmer.getF_DOC_Mandate() %>" target = "_blank">   <img src="http://49.50.79.121:8080/FarmerRegistration/<%=editFarmer.getF_DOC_Mandate() %>" /></a>
		            <div class="mandt">
		            <label class="center">Farmer mandate Image</label>
		            </div>
		            </div>
	            </div>
	             <div class="col-md-6">		 
	             <div class="text-details">	           
		         <a href="http://49.50.79.121:8080/FarmerRegistration/<%=editFarmer.getF_BANK_DOC() %>" target = "_blank">     <img src="http://49.50.79.121:8080/FarmerRegistration/<%=editFarmer.getF_BANK_DOC() %>" /></a>
		            <div class="mandt">
		            <label class="center">Farmer Bank Document</label>
		            </div>
		            </div>
	            </div>	             
	           </div> 
	           </div>
	           <div class="doremon">
	           <div class="row">
	           <div class="col-md-6">	
	           <div class="text-details">		            
		          <a href="http://49.50.79.121:8080/FarmerRegistration/<%=editFarmer.getF_ID_PROF() %>" target = "_blank">    <img src="http://49.50.79.121:8080/FarmerRegistration/<%=editFarmer.getF_ID_PROF() %>" target = "_blank"/></a>
		            <div class="mandt">
		            <label class="center">Farmer Id Proof</label>
		            </div>
		            </div>
		            
	            </div>
	             <div class="col-md-6">		
	             <div class="text-details">            
		     <a href="http://49.50.79.121:8080/FarmerRegistration/<%=editFarmer.getF_REG_FORM() %>" target = "_blank">         <img src="http://49.50.79.121:8080/FarmerRegistration/<%=editFarmer.getF_REG_FORM() %>" target = "_blank"/></a>
		            <div class="mandt">
		            <label class="center">Farmer Registration Form</label>
		            </div>
		            </div>
	            </div>
	            </div>
	            </div>
	         
            
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
	<link
		href="https://cdnjs.cloudflare.com/ajax/libs/sweetalert/1.1.3/sweetalert.min.css"
		rel="stylesheet" />
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/sweetalert/1.1.3/sweetalert.min.js"></script>
	<script
		src="<%=request.getContextPath()%>/resources/js/owl.carousel.min.js"></script>
	<!-- PAGE LEVEL PLUGINS-->
	<!-- CORE SCRIPTS-->
	<script src="assets/js/app.min.js" type="text/javascript"></script>


</body>
</html>