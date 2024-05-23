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


<link
	href='https://ajax.googleapis.com/ajax/libs/jqueryui/1.12.1/themes/ui-lightness/jquery-ui.css'
	rel='stylesheet'>

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"> </script>

<script
	src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.12.1/jquery-ui.min.js"></script>
<link
	href="<%=request.getContextPath()%>/resources/css/styleUserReg.css"
	rel="stylesheet">
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
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.6.1/css/all.css"
	integrity="sha384-gfdkjb5BdAXd+lj+gudLWI+BXq4IuLW5IT+brZEZsLFm++aCMlF1V92rMkPaX4PP"
	crossorigin="anonymous">
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<!-- PLUGINS STYLES-->
<!-- THEME STYLES-->
<link href="assets/css/main.min.css" rel="stylesheet" />
<!-- PAGE LEVEL STYLES-->
<!-- zooming feature -->
<link rel="stylesheet" href="assets/css/zoom.css">
<link rel="stylesheet" href="assets/css/magnify.css">
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.5.1/jquery.min.js"
	charset="utf-8"></script>

<!-- date picker -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>

<link rel="stylesheet"
	href="//code.jquery.com/ui/1.13.2/themes/base/jquery-ui.css">

<!-- <script src="assets/css/jquery.magnify.js" type="text/javascript"  charset="utf-8"></script>
<script src="assets/js/jquery.magnify.js" type="text/javascript"  charset="utf-8"></script>
<script src="jquery.magnify.js" type="text/javascript"  charset="utf-8"></script> -->
<style>
.required:after {
	content: " *";
	color: red;
}
.glass {
	width: 150px;
	height: 150px;
	position: absolute;
	border-radius: 50%;
	cursor: crosshair;
	/* Multiple box shadows to achieve the glass effect */
	box-shadow: 0 0 0 7px rgba(255, 255, 255, 0.85), 0 0 7px 7px
		rgba(0, 0, 0, 0.25), inset 0 0 40px 2px rgba(0, 0, 0, 0.25);
	/* hide the glass by default */
	display: none;
}

* {
	box-sizing: border-box;
}

.img-magnifier-container {
	position: relative;
}

.img-magnifier-glass {
	position: absolute;
	border: 3px solid #000;
	border-radius: 50%;
	cursor: none;
	/*Set the size of the magnifier glass:*/
	width: 100px;
	height: 100px;
}
</style>

<!-- styling confirm box -->
<style type="text/css">
body {
	font-family: sans-serif
}

.dialog-ovelay {
	position: absolute;
	top: 0;
	left: 0;
	right: 0;
	bottom: 0;
	height: 140vw;
	background-color: rgba(0, 0, 0, 0.50);
	z-index: 999999
}

.dialog-ovelay .dialog {
	width: 600px;
	margin: 100px auto 0;
	background-color: #fff;
	box-shadow: 0 0 20px rgba(0, 0, 0, .2);
	border-radius: 3px;
	overflow: hidden
}

.dialog-ovelay .dialog header {
	padding: 10px 8px;
	background-color: #f6f7f9;
	border-bottom: 1px solid #e5e5e5
}

.dialog-ovelay .dialog header h3 {
	font-size: 14px;
	margin: 0;
	color: #555;
	display: inline-block
}

.dialog-ovelay .dialog header .fa-close {
	float: right;
	color: #c4c5c7;
	cursor: pointer;
	transition: all .5s ease;
	padding: 0 2px;
	border-radius: 1px
}

.dialog-ovelay .dialog header .fa-close:hover {
	color: #b9b9b9
}

.dialog-ovelay .dialog header .fa-close:active {
	box-shadow: 0 0 5px #673AB7;
	color: #a2a2a2
}

.dialog-ovelay .dialog .dialog-msg {
	padding: 12px 10px
}

.dialog-ovelay .dialog .dialog-msg p {
	margin: 0;
	font-size: 15px;
	color: #333
}

.dialog-ovelay .dialog footer {
	border-top: 1px solid #e5e5e5;
	padding: 8px 10px
}

.dialog-ovelay .dialog footer .controls {
	direction: rtl
}

.dialog-ovelay .dialog footer .controls .button {
	padding: 5px 15px;
	border-radius: 3px
}

.button {
	cursor: pointer
}

.button-default {
	background-color: rgb(248, 248, 248);
	border: 1px solid rgba(204, 204, 204, 0.5);
	color: #5D5D5D;
}

.button-danger {
	background-color: #f44336;
	border: 1px solid #d32f2f;
	color: #f5f5f5
}

.link {
	padding: 5px 10px;
	cursor: pointer
}

.scroll {
	float: left;
	width: 1000px;
	overflow-y: auto;
	height: 614px;
}

.click-zoom input[type=checkbox] {
	display: none
}

/* .click-zoom img {
  margin: 100px;
  transition: transform 0.25s ease;
  cursor: zoom-in
}

.click-zoom input[type=checkbox]:checked~img {
  transform: scale(2);
  cursor: zoom-out
} */
.scroll .btn {
	width: 50px;
	height: 50px;
	background: #FFF;
	border: 1px solid #005bac;
	border-radius: 50%;
	-moz-border-radius: 50%;
	-webkit-border-radius: 50%;
	color: #005bac;
	padding: 15px 10px 5px;
	position: absolute;
	text-align: center;
	-ms-user-select: none;
	-moz-user-select: -moz-none;
	-khtml-user-select: none;
	-webkit-user-select: none;
	user-select: none;
	transition: all 0.3s ease;
	z-index: 1;
}

.scroll .btn:hover {
	background: #eef;
}

.scroll .zoom {
	bottom: 190px;
}

.scroll .zoom-out {
	bottom: 120px;
}

.scroll .zoom-init {
	bottom: 50px;
}

button#turn {
	position: relative;
	z-index: 999;
}
</style>

<script type="text/javascript">
	$(document).ready(function() {
		$('#turn').on('click', function() {
			var angle = ($('#uploadedImage').data('angle') + 90) || 90;
			$('#uploadedImage').css({
				'transform' : 'rotate(' + angle + 'deg)'
			});
			$('#uploadedImage').data('angle', angle);
		});
		
		// $('.zoom').magnify();
	});
</script>



<script>
 function magnify(imgID, zoom)
 {
	  var img, glass, w, h, bw;
	  img = document.getElementById(imgID);
	  /*create magnifier glass:*/
	  glass = document.createElement("DIV");
	  glass.setAttribute("class", "img-magnifier-glass");
	  /*insert magnifier glass:*/
	  img.parentElement.insertBefore(glass, img);
	  /*set background properties for the magnifier glass:*/
	  glass.style.backgroundImage = "url('" + img.src + "')";
	  glass.style.backgroundRepeat = "no-repeat";
	  glass.style.backgroundSize = (img.width * zoom) + "px " + (img.height * zoom) + "px";
	  bw = 3;
	  w = glass.offsetWidth / 2;
	  h = glass.offsetHeight / 2;
	  /*execute a function when someone moves the magnifier glass over the image:*/
	  glass.addEventListener("mousemove", moveMagnifier);
	  img.addEventListener("mousemove", moveMagnifier);
	  /*and also for touch screens:*/
	  glass.addEventListener("touchmove", moveMagnifier);
	  img.addEventListener("touchmove", moveMagnifier);
		  function moveMagnifier(e) 
		  {
			    var pos, x, y;
			    /*prevent any other actions that may occur when moving over the image*/
			    e.preventDefault();
			    /*get the cursor's x and y positions:*/
			    pos = getCursorPos(e);
			    x = pos.x;
			    y = pos.y;
			    /*prevent the magnifier glass from being positioned outside the image:*/
			    if (x > img.width - (w / zoom)) {x = img.width - (w / zoom);}
			    if (x < w / zoom) {x = w / zoom;}
			    if (y > img.height - (h / zoom)) {y = img.height - (h / zoom);}
			    if (y < h / zoom) {y = h / zoom;}
			    /*set the position of the magnifier glass:*/
			    glass.style.left = (x - w) + "px";
			    glass.style.top = (y - h) + "px";
			    /*display what the magnifier glass "sees":*/
			    glass.style.backgroundPosition = "-" + ((x * zoom) - w + bw) + "px -" + ((y * zoom) - h + bw) + "px";
		  }
		  function getCursorPos(e)
		  {
			    var a, x = 0, y = 0;
			    e = e || window.event;
			    /*get the x and y positions of the image:*/
			    a = img.getBoundingClientRect();
			    /*calculate the cursor's x and y coordinates, relative to the image:*/
			    x = e.pageX - a.left;
			    y = e.pageY - a.top;
			    /*consider any page scrolling:*/
			    x = x - window.pageXOffset;
			    y = y - window.pageYOffset;
			    return {x : x, y : y};
		  }
	} 

 </script>
<script type="text/javascript">
 var tallyno, farmno, dop,pop,rsn,bin, ntqty,grate,amtpay,jutevar,grossqty,tallyimage , msg, popname  ;
 </script>





</head>




<body class="fixed-navbar" >

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
			String id = request.getParameter("id");
			FarmerRegModel farmerModel = null;
			try {
				farmerModel = (FarmerRegModel) request.getAttribute("farmerDetails");
			} catch (Exception e) {
				out.println("Something went wrong");
			}
			String firstname = "";
			String middlename = "";
			String lastname = "";
			String fname = "";
			String[] farmerName = new  String[3];
			farmerName = farmerModel.getF_NAME().split(" ");
			if(farmerName.length == 1){
			firstname = farmerModel.getF_NAME().split(" ")[0];
			fname = firstname;
			}
			else if(farmerName.length == 2){
			 firstname = farmerModel.getF_NAME().split(" ")[0];
			 middlename = farmerModel.getF_NAME().split(" ")[1];
			
			 fname = firstname +" "+middlename;
			}
			else if(farmerName.length == 3){
				firstname = farmerModel.getF_NAME().split(" ")[0];
				middlename = farmerModel.getF_NAME().split(" ")[1];
				lastname = farmerModel.getF_NAME().split(" ")[2];
				if (middlename.equalsIgnoreCase("NA"))
					 fname = firstname+" "+lastname;
				else
				 fname = firstname +" "+middlename+" "+lastname;
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




							<div class="ibox-body mainform">

								<div class="row">
									<div class="col-sm-6 form-group scroll">
                                            <%
											String filepath = "http://49.50.79.121:8080/FarmerRegistration/";
											String imagepath = farmerModel.getF_DOC_Mandate();
											%>
										<button id='turn'>
											<img style="width: 20px;"
												src="https://pic.onlinewebfonts.com/svg/img_313385.png">
											Rotate
										</button>
										<a class="btn zoom"><i class="fas fa-search-plus"></i></a> <a
											class="btn zoom-out"><i class="fas fa-search-minus"></i></a>
										<a class="btn zoom-init"><i class="fas fa-recycle"></i></a>
										<div class="img-magnifier-container">
											<div class="click-zoom target">

												<img name="uploadedImage" id="uploadedImage"
													src="<%=filepath + farmerModel.getF_DOC_Mandate()%>" class="magniflier" />
											</div>
										</div>
									</div>
									
										<div class="col-sm-6 form-group scroll">
										<form action="saveVerification.obj" method="POST" name="myForm" id="myForm" onsubmit="return validate()" autocomplete="off">
										<span id="image"></span>
											
											<input type="hidden" name="id" id="id" value="<%=farmerModel.getF_ID()%>"> 
									       <input type="hidden" name="fIfsc" id="fIfsc" value="<%=farmerModel.getF_BANK_IFSC()%>"> 
									       <input type="hidden" name="facNo" id="facNo" value="<%=farmerModel.getF_AC_NO()%>"> 
									       <input type="hidden" name="fName" id="fName" value="<%=fname%>"> 
									       <input type="hidden" name="faddress" id="faddress" value="<%=farmerModel.getF_ADDRESS()%>"> 
									       <input type="hidden" name="fidProofType" id="fidProofType" value="<%=farmerModel.getF_ID_PROF_TYPE()%>"> 
									       <input type="hidden" name="fidProofNo" id="fidProofNo" value="<%=farmerModel.getF_ID_PROF_NO()%>">
									       
									       <div class="form-group">
											<label>Farmer Registration No</label> <input
													class="form-control" type="text" name="farmer_reg_no"
													id="farmer_reg_no" placeholder="Farmer Registration No"
													value="<%=farmerModel.getF_REG_NO()%>" readonly required>
											</div>
											
											<div class="form-group">
												<label class="required">IFSC Code</label> <span class="err"
													name="ifsc_span" id="ifsc_span"></span> <input
													class="form-control"
													oninput="this.value = this.value.toUpperCase()"
													maxlength="11" name="ifsc_code" type="text"
													placeholder="IFSC Code" id="ifsc_code" required>
											</div>
											
											<div class="form-group">
												<label class="required">Bank A/C Number</label> <span
													class="err" name="aspan" id="aspan"></span> <input
													class="form-control" min="0" name="ac_no" type="number"
													placeholder="Bank A/C Number" id="ac_no" required
													oninput="javascript: if (this.value.length > 18) this.value = this.value.slice(0, 18);">
											</div>
											
											<div class="form-group">
												<label class="required">Name of farmer </label> <span
													class="err" name="name_span" id="name_span"></span> <input
													type="text" class="form-control" name="farmer_name"
													id="farmer_name" placeholder="Name of farmer" required>
											</div>

											<!-- <div class="form-group">
												<label class="required">Address</label> <span class="err" name="address_span" id="address_span"></span>
												<input class="form-control" type="text" name="address" id="address" placeholder="Address"  required>
											</div> -->

											<!-- <div class="form-group">
												<label>Identity Proof Type</label> <span class="err" name="idProofType_span" id="idProofType_span"></span>
												<select  name="idProofType" id="idProofType" class="form-control" >
													<option id="default" value="">-Select-</option>
													<option id="AadharCard" value="Aadhar Card">Aadhar Card</option>
													<option id="VoterId" value="Voter Id">Voter Id</option>
												</select>
											</div>
											
											<div class="form-group">
 
												<label>Identity Proof Number</label> <span class="err" name="idProofNo_span" id="idProofNo_span"></span>
 
												<input class="form-control"	type="text" name="identityProofNo" id="identityProofNo" placeholder="Identity Proof Number" value="" >
											</div>  -->

											<div class="form-group">
												 
													
													<button   type="submit"
													id="enq_submit"
													style="margin: 15px; width: 120px; border-radius: 9px;height: 30px; background: mediumseagreen; color: white;">Verify</button>
											
											</div>
											 
                                         </form>
										</div>
									
								</div>

							</div>
							<!-- ibox mainframe -->

						</div>

					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- END PAGE CONTENT-->
	<%@ include file="footer.jsp"%>


	<div class="sidenav-backdrop backdrop"></div>

	<script>
/* Initiate Magnify Function with the id of the image, and the strength of the magnifier glass:*/
//magnify("uploadedImage", 2);

  </script>


	<script src="build/js/intlTelInput.js"></script>



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
	<!-- CORE SCRIPTS <script src="assets/js/app.min.js" type="text/javascript"></script>-->




</body>
 
<script>
	function validate() {
	//	alert("validate");
		var missing=false;
		
		var fIfsc = '<%=farmerModel.getF_BANK_IFSC()%>';
	//	alert(fIfsc);
		var facNo = '<%=farmerModel.getF_AC_NO()%>';
		//alert(facNo);
		var fName = '<%=fname%>';
	//	fName =  fName.trim();
		//alert(fName);
		<%-- var fidProofType = <%=farmerModel.getF_ID_PROF_TYPE()%>;
		var fidProofNo = <%=farmerModel.getF_ID_PROF_NO()%>; --%>
		var ifsc_code = document.getElementById("ifsc_code").value;
	//	alert(ifsc_code+" "+fIfsc);
		var ac_no = document.getElementById("ac_no").value;
		//alert(ac_no==facNo);
		var farmer_name = document.getElementById("farmer_name").value;
		farmer_name = farmer_name.trim();
		//alert(farmer_name+"12"+fName+"23");
		//remove proof id n dtype by animesh - 28 june 23
	//	var idProofType = document.getElementById("idProofType").value;
	//	var identityProofNo = document.getElementById("identityProofNo").value;
	
		if(fIfsc!==ifsc_code){
		  //  alert("if fifs");
			document.getElementById("ifsc_span").textContent= "Please check IFSC code";
			//return false;
			missing = true;
			//document.getElementById("enquiry_form").setAttribute("onsubmit", "event.preventDefault()");
		}
		else{
			document.getElementById("ifsc_span").textContent= "";
			
		}
		if(facNo!==ac_no){
			//alert("hi");
			document.getElementById("aspan").textContent= "Please check account number";
			missing = true;
			
			//document.getElementById("enquiry_form").setAttribute("onsubmit", "event.preventDefault()");
		}
		else{
			
			document.getElementById("aspan").textContent= "";
		}
		if(fName.toUpperCase()!==farmer_name.toUpperCase()){
			//alert(fName.toUpperCase());
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
		
		if(missing == true)
			{
			return false;
			}
	 
	}
	
</script>

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
<script src="./assets/vendors/DataTables/datatables.min.js"
	type="text/javascript"></script>
<!-- CORE SCRIPTS-->
<script src="assets/js/app.min.js" type="text/javascript"></script>
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.13.2/themes/base/jquery-ui.css">
<link rel="stylesheet" href="/resources/demos/style.css">
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
<script src="https://code.jquery.com/ui/1.13.2/jquery-ui.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/fontawesome-iconpicker/3.2.0/js/fontawesome-iconpicker.min.js"></script>


<script>
	$(document).ready(function(){
	 $( "#dateOfPurchase" ).datepicker({ dateFormat: 'dd-mm-yy'    });
 });

	</script>
</script>

<script type="text/javascript">
	var zoom = 1;
	
	$('.zoom').on('click', function(){
		zoom += 0.1;
		$('.target').css('transform', 'scale(' + zoom + ')');
	});
	$('.zoom-init').on('click', function(){
		zoom = 1;
		$('.target').css('transform', 'scale(' + zoom + ')');
	});
	$('.zoom-out').on('click', function(){
		zoom -= 0.1;
		$('.target').css('transform', 'scale(' + zoom + ')');
	});
 </script>



</html>
