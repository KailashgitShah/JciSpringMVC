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
				<h1 class="page-title">Edit Farmer Registration</h1>
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
							<% 
								FarmerRegModel editFarmer = (FarmerRegModel)request.getAttribute("farmerDetailsById");
							%>
							<div class="ibox-body">
								<form action="EditsaveFarmerRegistrationMid.obj" method="POST" enctype="multipart/form-data" name="myForm" >
									<div class="row">
										<div class="col-sm-4 form-group">
											<label>Name of Farmer</label> 
											<input type="hidden" name="idPrimary" value="<%=editFarmer.getF_ID() %>" id="idPrimary" />
											<input type="hidden" name="farmerRegNo" value="<%=editFarmer.getF_REG_NO() %>" id="farmerRegNo">
											<input type="hidden" name="F_REG_BY" id="F_REG_BY" value="<%=userId%>">
											<input class="form-control"
												type="text" name="F_NAME" value="<%=editFarmer.getF_NAME() %>" id= "F_NAME" placeholder="Farmer Name" readonly>
										</div>										
										<div class="col-sm-4 form-group">
											<label>Caste</label> <select class="form-control" name="caste" value="<%=editFarmer.getCaste() %>" type="text" placeholder="Caste" id="caste" readonly>
												<option <% if(editFarmer.getCaste().equals("General")){out.print("selected");}%>value="General">General</option>
												<option <% if(editFarmer.getCaste().equals("OBC")){out.print("selected");}%>value="OBC">OBC</option>
												<option <% if(editFarmer.getCaste().equals("SC")){out.print("selected");}%>value="SC">SC</option>
												<option <% if(editFarmer.getCaste().equals("ST")){out.print("selected");}%>value="ST">ST</option>
												<!-- <option value="OBC">OBC</option>
												<option value="SC_ST">SC/ST</option> -->
											</select>
										</div>
										<div class="col-sm-4 form-group">
											<label>Gender</label> 
											<select class="form-control"
												name="gender" id="gender" value="<%=editFarmer.getGender()%>" readonly>
												<option <% if(editFarmer.getGender().equals("Male")){out.print("selected");}%>value="Male">Male</option>
												<option <% if(editFarmer.getGender().equals("Female")){out.print("selected");}%>value="Female">Female</option>
												<!-- <option id="Male" value="Male">Male</option>
												<option id="Female" value="Female">Female</option> -->
											</select>
										</div>
									</div>
									<div class="row">
										<div class="col-sm-4 form-group">
											<label>Address</label> <input class="form-control"
												type="text" value="<%=editFarmer.getF_ADDRESS() %>" name="F_ADDRESS" placeholder="Farmer Address" id="F_ADDRESS" readonly>
										</div>
										
																		<div class="col-sm-4 form-group">
									<label class="required">State</label> 
									<input class="form-control" type="text" name="f_state" placeholder="Farmer Address" value="<%=editFarmer.getF_STATE()%>" id="F_Address2" readonly>
									<%-- <%
											List<StateList> Liststate = (List<StateList>) request.getAttribute("Liststate");
											%>
											<select class="form-control" name="state" type="text"placeholder="State" id="ParentMenuID" onchange="deleteErrorMsg()">
												<option disabled selected value>-Select-</option>
												<%
													for (StateList stateLists : Liststate) {
												%>
														<option value="<%=stateLists.getId()%>"><%=stateLists.getState_name()%></option>
												<%
													}
												%>
											</select> --%>
									</div>
								
								<div class="col-sm-4 form-group">
									<label class="required">District</label> <input class="form-control"
										type="text" name="f_district" placeholder="Farmer Address" value="<%=editFarmer.getF_District()%>" id="F_Address2" readonly>
								</div>
								
								
																		<div class="col-sm-4 form-group">
									<label class="required">Block</label> <input class="form-control"
										type="text" name="f_block" placeholder="Farmer Address" value="<%=editFarmer.getF_Block()%>" id="F_Address2" readonly>
								</div>
								
																		<div class="col-sm-4 form-group">
									<label class="required">Police Station</label> <input class="form-control"
										type="text" name="f_block" placeholder="Farmer Address" value="<%=editFarmer.getPolice_station()%>" id="F_Address2" readonly>
								</div>
								
								<div class="col-sm-4 form-group">
									<label class="required">Pincode</label> <input class="form-control"
										type="text" name="F_Pincode" placeholder="Farmer Address" value="<%=editFarmer.getF_Pincode() %>" id="F_Pincode" readonly>
								</div>
			

							</div>
						<div class="row">
						   <div class="col-sm-4 form-group">
											<label class="required">Identity Type </label> <select name="F_ID_PROF_TYPE" id="F_ID_PROF_TYPE" class="form-control" value="<%=editFarmer.getF_ID_PROF_TYPE()%>" type="text" readonly>
												
												<option <% if(editFarmer.getF_ID_PROF_TYPE().equals("AadharCard")){out.print("selected");}%> value="Aadhar Card">Aadhar Card</option>
												<option <% if(editFarmer.getF_ID_PROF_TYPE().equals("VoterId")){out.print("selected");}%> value="Voter Id">Voter Id</option>
												</select>
										</div>
						    <div class="col-sm-4 form-group">
									<label class="required">Identity Proof No.</label> <input class="form-control"
										type="text" name="F_ID_PROF_NO"
										placeholder="Identity Proof No." id="F_ID_PROF_NO" value="<%=editFarmer.getF_ID_PROF_NO()%>" readonly>
								</div>
																	<div class="col-sm-4 form-group">
									<label class="required">Whether I-CARE Registered</label> 
									<select name="F_I_CARE_REGISTERED" id="F_I_CARE_REGISTERED" placeholder="Whether I-CARE Registered" class="form-control" value="<%=editFarmer.getF_I_CARE_REGISTERED()%>"  readonly>
									
										<option <% if(editFarmer.getF_I_CARE_REGISTERED().equals("Yes")){out.print("selected");}%> value="Yes">Yes</option>
										<option <% if(editFarmer.getF_I_CARE_REGISTERED().equals("No")){out.print("selected");}%> value="No">No</option>
									</select>
								</div>
<%-- 						    <div class="col-sm-4 form-group">
									<label class="required">Registered By </label> <input class="form-control"
										type="text" name="F_REG_BY " placeholder="Registered By"
										value= "${dpcCode}" readonly>
								</div> --%>
				

									</div>


								<div class="row">

								<div class="col-sm-4 form-group">
									<label class="required">Land Holding (Bigha)</label> <input class="form-control"
										name="land_holding" type="number"
										placeholder="Land Holding (Bigha)" min=0 step="0.001" id="land_holding" value="<%=editFarmer.getLand_holding()%>" readonly>
								</div>
								<div class="col-sm-4 form-group">
									<label class="required">Mobile Number</label>
									<div class="input-group-prepend">
										<span class="input-group-text" id="basic-addon1">+91</span> <input
											class="form-control" type="number" id="F_MOBILE" name="F_MOBILE"
											title="10 digit mobile number" placeholder="Farmer Mobile" maxlength="10" minlength="10" onkeyup="myfuctions()" pattern=".{10,10}" required title="10 to 10 characters" value="<%=editFarmer.getF_MOBILE()%>" readonly>
									</div>
									</div>
									<div class="col-sm-4 form-group">
										<label>Bank A/C Type</label> 
										 <select name="bank_ac_type" id="bank_ac_type" value="<%=editFarmer.getBank_ac_type()%>" class="form-control" readonly>
											<option <% if(editFarmer.getGender().equals("Saving")){out.print("selected");}%>value="Saving">Saving</option>
											<option <% if(editFarmer.getGender().equals("Current")){out.print("selected");}%>value="Current">Current</option>										 
										</select>
									</div>
								</div>
								
								<div class="row">
									<div class="col-sm-4 form-group">
									<label>Bank A/C No.</label> 
									<input class="form-control" type="hidden" name="idPrimary" value="<%=editFarmer.getF_ID() %>" id= "idPrimary">
									<input class="form-control" name="F_AC_NO" type="text" value="<%=editFarmer.getF_AC_NO() %>" placeholder="Farmer Bank Ac No." id="F_AC_NO" readonly>
									</div>
									<div class="col-sm-4 form-group">
										<label>Bank IFSC</label> <input class="form-control"
											name="F_BANK_IFSC" type="text" value="<%=editFarmer.getF_BANK_IFSC() %>" placeholder="IFSC Code" id="F_BANK_IFSC" readonly>
									</div>
																<div class="col-sm-4 form-group">
									<label class="required">Bank Name</label> <input class="form-control"
										name="F_BANK_NAME" type="text" placeholder="Bank Name" id="F_BANK_NAME" value="<%=editFarmer.getF_BANK_NAME()%>" readonly>
								</div>
								</div>
								
								<div class="row">

								<div class="col-sm-4 form-group">
									<label>Bank Branch</label> <input class="form-control"
										name="F_BANK_BRANCH" type="text" placeholder="Farmer Bank Branch" value="<%=editFarmer.getF_BANK_BRANCH() %>" id="F_BANK_BRANCH" readonly>
								</div>		
										
		                          <div class="col-sm-4 form-group">
									<label class="required">Bank Document </label> <input class="form-control"
										name="F_BANK_DOC" type="file" placeholder="Bank Document" id="BANK_DOC" value="<%=editFarmer.getF_BANK_DOC() %>"  readonly><%=editFarmer.getF_BANK_DOC() %></input><!-- onchange="Filevalidation()" -->
			
								</div>
									<div class="col-sm-4 form-group">
										<label class="required">A/C Identity Proof</label> <input class="form-control"
											type="file" name="F_ID_PROF" placeholder="Farmer ID Proof" id="F_ID_PROF" value="<%=editFarmer.getF_ID_PROF() %>"  readonly> <%=editFarmer.getF_ID_PROF() %></input>
									</div>
					</div>
						<div class="row">
								<div class="col-sm-4 form-group">
									<label class="required">Registration Form</label> <input class="form-control"
										name="F_REG_FORM" type="file" placeholder="Registration Form" id="F_REG_FORM" value="<%=editFarmer.getF_REG_FORM() %>" readonly><%=editFarmer.getF_REG_FORM() %> </input>
								</div>
						
			
								
								<div class="col-sm-4 form-group">
									<label>Bank Mandate Document </label><img id="imgPreviewidentity"  /> <input class="form-control"
										name="F_DOC_Mandate"  accept=".jpg,.jpeg,.png" type="file" placeholder="Bank Mandate Document" id="F_DOC_Mandate" value="<%=editFarmer.getF_DOC_Mandate() %>" ><%=editFarmer.getF_DOC_Mandate() %> </input>
								</div>
								</div>
							<div class="row">
								<div class="col-sm-4 form-group">
								 <input type="submit" value="Update" class="btn btn-primary">
									<!-- <input class="btn btn-primary" type="submit" id="enq_submit">Submit</button> -->
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
$(document).ready(()=>{
    $('#F_DOC_Mandate').change(function(){
      const file = this.files[0];
      console.log(file);
      if (file){
        let reader = new FileReader();
        reader.onload = function(event){
          console.log(event.target.result);
          $('#imgPreviewidentity').attr('src', event.target.result);
          $('#imgPreviewidentity').attr('width', "150px");
        }
        reader.readAsDataURL(file);
      }
    });
  });
  </script>
	<script>
		$(document).ready(function() {
			$('#emailTosend').keyup(function(e) {
				if (e.keyCode == 8)
					//alert('backspace trapped')
			})
		});
	</script>
	<script src="build/js/intlTelInput.js"></script>
	<script>
		$('#emailTosend').keyup(function() {
			var str = this.value.replace(/(\w)[\s,]+(\w?)/g, '$1, $2');
			if (str != this.value)
				this.value = str;
		});

		$('#emailTosend').keyup(function() {
			var val = $("#emailTosend").val();
			let text = val;
			let result = text.indexOf(" ");
			if (result != -1) {
				alert(result);
			}
			/* var str = this.value.replace(/(\w)[\s,]+(\w?)/g, '$1, $2');
			 if (str!=this.value) this.value = str; */
		});
	</script>

	<script>
		function myFunction() {
			//alert("aaaa");
			let mobile = document.getElementById("F_MOBILE").value;
			let pattern = /[0-9]{10}$/g;
			let result = F_MOBILE.match(pattern);
			if (result == null)
				alert("Please enter valid number")
		}

		$("#mobile").keyup(function() {
			var mobileNo = ($(this).val());
			var mobLength = mobileNo.toString().length;
			if (mobLength == 10) {
				$.ajax({
					type : "GET",
					url : "validateMobile.obj",
					data : {
						"mobileNo" : mobileNo
					},
					success : function(result) {
						/* var data= jQuery.parseJSON(result);
						 var html = "<option disabled selected value>-Select-</option>";
						  for (var i = 0; i< data.length; i++){
						 html += "<option value=" +data[i].split("-")[0]+ ">"+data[i].split("-")[1]+"</option>" */
					}
				//$("#centerordpc").html(html);
				//}			
				});

			} else {

			}
		});
</script>

<script>
function validate() {

	 let x = document.forms["myForm"]["F_NAME"].value;
	 let y = document.forms["myForm"]["caste"].value;
	 let z = document.forms["myForm"]["gender"].value;
	 let a = document.forms["myForm"]["F_ADDRESS"].value;
	 let b = document.forms["myForm"]["F_ID_PROF_TYPE"].value;
	 let c = document.forms["myForm"]["F_ID_PROF"].value;
	 let d = document.forms["myForm"]["F_ID_PROF_No"].value; 
	 let e = document.forms["myForm"]["F_I_CARE_REGISTERED"].value; 
	 let f = document.forms["myForm"]["land_holding"].value; 
	 let g = document.forms["myForm"]["F_MOBILE"].value;
	 let h = document.forms["myForm"]["bank_ac_type"].value;
	 let i = document.forms["myForm"]["F_AC_NO"].value;
	 let j = document.forms["myForm"]["F_BANK_IFSC"].value; 
	 let k = document.forms["myForm"]["F_BANK_NAME"].value; 
	 let l = document.forms["myForm"]["F_BANK_BRANCH"].value; 
	 let m = document.forms["myForm"]["BANK_DOC"].value; 
	 let n = document.forms["myForm"]["reg_form"].value; 
	  if (x == "") {
	    alert("Name must be filled out");
	    return false;
	  }
	  else if(y == ""){
		  alert("Caste must be filled out");
		  return false;
	  }
	  else if(z == ""){
		  alert("Gender must be filled out");
		  return false;
	  }
	  else if(a == ""){
		  alert("Address must be filled out");
		  return false;
	  }
	  else if(b == ""){
		  alert("Identity Type be filled out");
		  return false;
	  }
	  else if(c == ""){
		  alert("Identity Proof must be filled out");
		  return false;
	  }
	  else if(d == ""){
		  alert("Identity Proof No. must be filled out");
		  return false;
	  }
	  else if(e == ""){
		  alert("Whether I-CARE Registered must be filled out");
		  return false;
	  }
	  else if(f == ""){
		  alert("Land Holding (Bigha) must be filled out");
		  return false;
	  }
	  else if(g == ""){
		  alert("Mobile Number must be filled out");
		  return false;
	  }
	  else if(h == ""){
		  alert("Bank A/C Type must be filled out");
		  return false;
	  }
	  else if(i == ""){
		  alert("Bank A/C No. must be filled out");
		  return false;
	  }
	  else if(j == ""){
		  alert("Bank IFSC must be filled out");
		  return false;
	  }
	  else if(k == ""){
		  alert("Bank Name must be filled out");
		  return false;
	  }
	  else if(l == ""){
		  alert("Bank Branch must be filled out");
		  return false;
	  }
	  else if(m == ""){
		  alert("Bank Document must be filled out");
		  return false;
	  }
	  else if(n == ""){
		  alert("Registration Form must be filled out");
		  return false;
	  }
}

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