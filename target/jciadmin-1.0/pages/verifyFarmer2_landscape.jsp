<!DOCTYPE html>
<html lang="en">
<%@ page import="javax.servlet.http.HttpServletRequest"%>
<%@page import="com.jci.model.FarmerRegModel"%>
<%@page import="com.jci.common.*"%>
<%@page import="java.io.File"%>
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
<style>
.err {
	color: red;
}
.rotate90 {
  -webKit-transform:rotate(90deg);
  -moz-transform: rotate(90deg);
  -ms-transform: rotate(90deg);
  -o-transform: rotate(90deg);
  transform: rotate(90deg);
   display: flex;
  flex-wrap: wrap;
  margin-right: -$gutter / 2;
  margin-left: -$gutter / 2;
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
				<h1 class="page-title">Verify Farmer</h1>
			</div>
			<%
				FarmerRegModel farmerModel = null;
				try {
					farmerModel = (FarmerRegModel) request.getAttribute("farmerDetails");
				} catch (Exception e) {
					out.println("Something went wrong");
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
							<%
							String id=request.getParameter("id");
;
								%>
								<a href="verifyFarmer2.obj?id=<%=id%>">
									<span>
									<img style="width: 20px;" src="https://pic.onlinewebfonts.com/svg/img_313385.png">
									Rotate Page
									</span>								
								</a>
								<%
							%>
							
							<div class="ibox-body mainform">
								<form action="saveVerification.obj" method="POST"  name="enquiry_form" id="enquiry_form" onsubmit="return validate()">
									<input type="hidden" name="id" value="<%=farmerModel.getF_ID()%>">
									<%-- <input type="hidden" name="fid" id="fid" value="<%=farmerModel.getF_ID()%>"> --%>
									<input type="hidden" name="fIfsc" id="fIfsc" value="<%=farmerModel.getF_BANK_IFSC()%>">
									<input type="hidden" name="facNo" id="facNo" value="<%=farmerModel.getF_AC_NO()%>">
									<input type="hidden" name="fName" id="fName" value="<%=farmerModel.getF_NAME()%>">
								<%-- 	<input type="hidden" name="faddress" id="faddress" value="<%=farmerModel.getF_ADDRESS()%>"> --%>
									<input type="hidden" name="fidProofType" id="fidProofType" value="<%=farmerModel.getF_ID_PROF_TYPE()%>">
									<input type="hidden" name="fidProofNo" id="fidProofNo" value="<%=farmerModel.getF_ID_PROF_NO()%>">
									<div class="">
									<div class="col">
									<%
 
									String filepath = "http://49.50.79.121:8080/FarmerRegistration/";
									String imagepath =farmerModel.getF_DOC_Mandate() ;
 
									if(farmerModel.getF_DOC_Mandate()!=null){
										//System.out.println("Bank Mandate Form Value is "+farmerModel.getF_DOC_Mandate() );
										%>
 
											<img src="<%=filepath+farmerModel.getF_DOC_Mandate() %>" class="rotate90" />
 
										<%	
									}else{
										%>
											<img src="https://placehold.jp/960x450.png" class="rotate90"/>
										<%
									}
									%>
									</div>
									<br>
									<div class="row">
										<div class="col-sm-6">
												<div class="form-group">
												<label>Farmer Registration No</label> 
												<input class="form-control" type="text" name="farmer_reg_no" placeholder="Farmer Registration No" value="<%=farmerModel.getF_REG_NO()%>" readonly required>
												</div>
										</div>
										<div class="col-sm-6">
										<div class="form-group">
													<label>IFSC Code</label> <span class="err" name="ifsc_span" id="ifsc_span"></span>
												 <input class="form-control" oninput="this.value = this.value.toUpperCase()" maxlength="11" name="ifsc_code" type="text"
												placeholder="IFSC Code" id="ifsc_code"
												onchange="deleteErrorMsg()" required>	
												</div>
										</div>
									</div>
									<div class="row">
										<div class="col-sm-6">
												<div class="form-group">
												<label>Bank A/C Number</label> <span class="err" name="ac_span" id="ac_span"></span>
										<input class="form-control" min="0" name="ac_no" type="number" placeholder="Bank A/C Number" id="ac_no" required oninput="javascript: if (this.value.length > 18) this.value = this.value.slice(0, 18);">
										</div>
										</div>
										<div class="col-sm-6">
										<div class="form-group">
											<label>Name of farmer</label> <span class="err" name="name_span" id="name_span"></span>
											<input type="text" class="form-control"   name="farmer_name" id="farmer_name" placeholder="Name of farmer" required onkeypress="return (event.charCode > 64 && event.charCode < 91) || (event.charCode > 96 && event.charCode < 123)">
											
											</div>
										</div>
									</div>
									<div class="row">
										<!-- <div class="col-sm-6">
												<div class="form-group">
											<label>Address</label> <span class="err" name="address_span" id="address_span"></span> 
											<input class="form-control" type="text" name="address" id="address" placeholder="Address" value="" required>
											</div>
										</div> -->
										<div class="col-sm-6">
											<div class="form-group">
												<label>Identity Proof Type</label> <span class="err" name="idProofType_span" id="idProofType_span"></span>
												<select  name="idProofType" id="idProofType" class="form-control" required>
													<option id="default" value="">-Select-</option>
													<option id="AadharCard" value="Aadhar Card">Aadhar Card</option>
													<option id="VoterId" value="Voter Id">Voter Id</option>
												</select>
											</div>
										</div>	
																				<div class="col-sm-6">
											<div class="form-group">
												<label>Identity Proof Number</label> <span class="err" id="idProofNo_span" name="idProofNo_span"></span>
												<input class="form-control"	type="text" name="identityProofNo" id="identityProofNo" placeholder="Identity Proof Number" value="" required>
											</div>	
										</div>									
									</div>

									<div class="col-sm-6">
									 	<div class="form-group">
											<button class="btn btn-default" type="submit" id="enq_submit"  >Verify</button>
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
	<!-- <script>
		$(document).ready(function() {
			$('#emailTosend').keyup(function(e) {
				if (e.keyCode == 8)
				{
					//alert('backspace trapped')
				}
			})
		});
	</script> -->
	
<script>
	$(document).ready(function(){
		$("#ac_no").keyup(function() {
			var value = $(this).val();
		
		  if(value.length < '6'  ){
			 
			  document.getElementById("ac_span").innerHTML = "Account No. should be between 6-18 digits!!";
			  $('#ac_span').show();
		  }
		  else
		    $('#ac_span').hide();
		   
		});
	});
</script>
	
	
	 <script>
    $('#idProofType').on('change', function() {
    	var  idProofType = $("#idProofType").find(':selected').val();
    	if(idProofType == "Aadhar Card"){
    		$("#identityProofNo").prop("type", "number");
    		 $("#identityProofNo").keyup(function() {
    			 var inputVal = ($(this).val());
    			 var len = inputVal.toString().length;
    			 if(len==12){
    				 $("#identityProofNo").prop("type", "text");
    				 $("#identityProofNo").attr("maxlength", "12");
    			 }
    		});
    	}else{
    		$("#identityProofNo").prop("type", "text");
    		$("#identityProofNo").attr("maxlength", "10");
    	}
    });
    </script>
	
	<!-- <script>
		function validate(){
			var fIfsc = document.getElementById("fIfsc").value;
			var facNo = document.getElementById("facNo").value;
			var fName = document.getElementById("fName").value;
			var faddress = document.getElementById("faddress").value;
			var fidProofType = document.getElementById("fidProofType").value;
			var fidProofNo = document.getElementById("fidProofNo").value;
			
			var ifsc_code = document.getElementById("ifsc_code").value;
			var ac_no = document.getElementById("ac_no").value;
			var farmer_name = document.getElementById("farmer_name").value;
			var address = document.getElementById("address").value;
			var idProofType = document.getElementById("idProofType").value;
			var identityProofNo = document.getElementById("identityProofNo").value;
			// console.log("from db==="+"fIfsc "+fIfsc+" facNo "+facNo+" fName "+fName+" faddress "+faddress+" fidProofType "+fidProofType+" fidProofNo "+fidProofNo);
			// console.log("from form==="+"ifsc_code "+ifsc_code+" ac_no "+ac_no+" farmer_name "+farmer_name+" address "+address+" fidProofType "+idProofType+" identityProofNo "+identityProofNo);
 
			if(fIfsc!==ifsc_code){
				document.getElementById("ifsc_span").textContent= "Please check IFSC code";
				return false;
				//document.getElementById("enquiry_form").setAttribute("onsubmit", "event.preventDefault()");
			}
			else if(facNo!==ac_no){
				document.getElementById("ac_span").textContent= "Please check account number";
				return false;
				//document.getElementById("enquiry_form").setAttribute("onsubmit", "event.preventDefault()");
			}
			else if(fName.toUpperCase()!==farmer_name.toUpperCase()){
				document.getElementById("name_span").textContent= "Please check farmer name";
				return false;
			//	document.getElementById("enquiry_form").setAttribute("onsubmit", "event.preventDefault()");
			}
		/* 	else if(faddress.toUpperCase()!==address.toUpperCase()){
				document.getElementById("address_span").textContent= "Please check farmer address";
				//document.getElementById("enquiry_form").setAttribute("onsubmit", "event.preventDefault()");
				return false; */
			}
			else if(fidProofType!==idProofType){
				document.getElementById("idProofType_span").textContent= "Please check Id proof type";
				//document.getElementById("enquiry_form").setAttribute("onsubmit", "event.preventDefault()");
				return false;
			}
			else if(fidProofNo.toUpperCase()!=identityProofNo.toUpperCase()){
				document.getElementById("idProofNo_span").textContent= "Please check proof no";
			//	document.getElementById("enquiry_form").setAttribute("onsubmit", "event.preventDefault()");
				return false;
			}
		}
		
	</script> -->
	<script>
		function validate(){
			var missing=false;
	
			var fIfsc = document.getElementById("fIfsc").value;
			var facNo = document.getElementById("facNo").value;
			var fName = document.getElementById("fName").value;
			var fidProofType = document.getElementById("fidProofType").value;
			var fidProofNo = document.getElementById("fidProofNo").value;
			var ifsc_code = document.getElementById("ifsc_code").value;
			var ac_no = document.getElementById("ac_no").value;
			var farmer_name = document.getElementById("farmer_name").value;
			var idProofType = document.getElementById("idProofType").value;
			var identityProofNo = document.getElementById("identityProofNo").value;
		
			if(fIfsc!==ifsc_code){
			
				document.getElementById("ifsc_span").textContent= "Please check IFSC code";
				//return false;
				missing = true;
				//document.getElementById("enquiry_form").setAttribute("onsubmit", "event.preventDefault()");
			}
			else{
				document.getElementById("ifsc_span").textContent= "";
				
			}
			if(facNo!==ac_no){
				
				document.getElementById("ac_span").textContent= "Please check account number";
				missing = true;
				
				//document.getElementById("enquiry_form").setAttribute("onsubmit", "event.preventDefault()");
			}
			else{
				
				document.getElementById("ac_span").textContent= "";
			}
			if(fName.toUpperCase()!==farmer_name.toUpperCase()){
				
				document.getElementById("name_span").textContent= "Please check farmer name";
				missing = true;
				//return false;
				//document.getElementById("enquiry_form").setAttribute("onsubmit", "event.preventDefault()");
			}
		else{
				
			document.getElementById("name_span").textContent= "";
			}
			/* else if(faddress.toUpperCase()!==address.toUpperCase()){
				document.getElementById("address_span").textContent= "Please check farmer address";
				document.getElementById("enquiry_form").setAttribute("onsubmit", "event.preventDefault()");
				return false;
			} */
			if(fidProofType!==idProofType){
				missing = true;
				document.getElementById("idProofType_span").textContent= "Please check Id proof type";
				//document.getElementById("enquiry_form").setAttribute("onsubmit", "event.preventDefault()");
				//return false;
			}
			else{
				document.getElementById("idProofType_span").textContent= "";
			}
			if(fidProofNo!=identityProofNo){
				missing = true;
				document.getElementById("idProofNo_span").textContent= "Please check proof no";
				//document.getElementById("enquiry_form").setAttribute("onsubmit", "event.preventDefault()");
				//return false;
			}
			else{
				document.getElementById("idProofNo_span").textContent= "";
				
			}
			if(missing == true)
				{
				return false;
				}
		}
		
	</script>
	<script src="build/js/intlTelInput.js"></script>
	<!-- 		<script>
		$('#enquiry_form').validate({
			  rules:{
			  name:"required",
			  email:{
			  required:true,
			  email:true
			  },
			  mobile:{
			      required:true,
			  minlength:9,
			  maxlength:10,
			  number: true
			  },
			  messages:{
			  name:"Please enter your username..!",
			  email:"Please enter your email..!",
			      mobile:"Enter your mobile no"
			  },
			  submitHandler: function(form) {alert("working");
			  //write your success code here  
			  }
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