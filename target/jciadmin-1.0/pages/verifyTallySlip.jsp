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
.ab-zoom{
	position: absolute;
	top:120px;
	left:10px;
	width:50px;
}
.ab-zoom .btn {
	width: 50px;
	height: 50px;
	background: #FFF;
	border: 1px solid #005bac;
	border-radius: 50%;
	-moz-border-radius: 50%;
	-webkit-border-radius: 50%;
	color: #005bac;
	padding: 15px 10px 5px;	
	text-align: center;
	-ms-user-select: none;
	-moz-user-select: -moz-none;
	-khtml-user-select: none;
	-webkit-user-select: none;
	user-select: none;
	transition: all 0.3s ease;
	z-index: 1;
	margin-bottom:10px;
}

.scroll .btn:hover {
	background: #eef;
}
/*
.scroll .zoom {
	bottom: 190px;
}

.scroll .zoom-out {
	bottom: 120px;
}

.scroll .zoom-init {
	bottom: 50px;
}
*/
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




<body class="fixed-navbar" onload="transection()">

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
				<h1 class="page-title">Verify Tally Slip</h1>
			</div>
			<%
			String dpcCode;
			dpcCode = (String) session.getAttribute("dpcId");
			String region = (String) session.getAttribute("region");
			//String tally = (String)request.getAttribute("tally");
			String tally = (String) request.getAttribute("tallyslip");
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

									<a href="tallyapproval.obj">Go Back</a>
								</div>
							</div>

							<div class="ibox-body mainform">
								<div class="ab-zoom">
									<a class="btn zoom"><i class="fas fa-search-plus"></i></a> 
									<a class="btn zoom-out"><i class="fas fa-search-minus"></i></a>
									<a class="btn zoom-init"><i class="fas fa-recycle"></i></a>
								</div>

								<div class="row">
									<div class="col-sm-6 form-group scroll">

										<button id='turn'>
											<img style="width: 20px;"
												src="https://pic.onlinewebfonts.com/svg/img_313385.png">
											Rotate
										</button>
										
										<div class="img-magnifier-container">
											<div class="click-zoom target">

												<img name="uploadedImage" id="uploadedImage"
													src="https://placehold.jp/960x450.png" class="magniflier" />
											</div>
										</div>
									</div>
									
										<div class="col-sm-6 form-group scroll">
										<form action="saveTallySlipMid.obj" method="POST" name="myForm"
										id="myForm" onsubmit="return validate()" autocomplete="off">
										<span id="image"></span>
											<div class="form-group">
												<label>Tally No.</label> <span class="text-danger">*
												</span>&nbsp; <span id="errtallyNo" name="errtallyNo"
													class="text-danger"></span> <input class="form-control"
													type="number" Readonly name="tallyNo" id="tallyNo"
													placeholder="Tally Number" value="<%=tally%>" min="0">

											</div>
											<div class="form-group">
												<label>Farmer Registration No</label><span
													class="text-danger">* </span>&nbsp; <span
													id="errfarmerRegNo" name="errfarmerRegNo"
													class="text-danger"> </span> <input class="form-control"
													type="number" name="farmerRegNo" id="farmerRegNo"
													placeholder="Farmer Registration No"
													onkeyup="deleteErrorMsg()" min="0">
											</div>


											<div class="form-group">
												<label>Date of Purchase</label> <span class="text-danger">*
												</span>&nbsp; <span id="errdateOfPurchase" name="errdateOfPurchase"
													class="text-danger"> </span> <input class="form-control" type="text"
													  name="dateOfPurchase" id="dateOfPurchase"
													placeholder="dd-mm-yyyy" onkeyup="deleteErrorMsg()">
											</div>

											<div class=" form-group">
												<label>Place of Purchase</label> <span class="text-danger">*
												</span>&nbsp; <span id="errplaceOfPurchase"
													name="errplaceOfPurchase" class="text-danger"> </span> <input
													class="form-control" type="text" name="placeOfPurchase"
													id="placeOfPurchase" placeholder="Place of Purhase"
													onkeyup="deleteErrorMsg()"> <input
													class="form-control" type="hidden" name="popname"
													id="popname" placeholder="Place of Purhase"
													onkeyup="deleteErrorMsg()" Readonly>
											</div>

											<div class=" form-group">
												<label>Rate Slip Number</label> <span class="text-danger">*
												</span>&nbsp; <span id="errrateSlipNumber" name="errrateSlipNumber"
													class="text-danger"> </span> <input class="form-control"
													type="number" name="rateSlipNumber" id="rateSlipNumber"
													placeholder="Rate Slip number" onkeyup="deleteErrorMsg()"
													min="0"
													oninput="javascript: if (this.value.length > 6) this.value = this.value.slice(0, 6);"
													onkeyup="deleteErrorMsg()">
											</div>
											<div class="form-group">
												<label>Bin Number</label> <span class="text-danger">*
												</span>&nbsp; <span id="errbinNumber" name="errbinNumber"
													class="text-danger"> </span> <input class="form-control"
													type="number" name="binNumber" id="binNumber"
													placeholder="Bin Number" value=""
													onkeyup="deleteErrorMsg()" min="0"
													oninput="javascript: if (this.value.length > 3) this.value = this.value.slice(0, 3);">
											</div>

											<div class=" form-group">
												<label>Net Quantity</label> <span class="text-danger">*
												</span>&nbsp; <span id="errnetQuantity" name="errnetQuantity"
													class="text-danger"> </span> <input class="form-control"
													type="number" name="netQuantity" id="netQuantity"
													placeholder="Net Quantity" onkeyup="deleteErrorMsg()"
													min="0" step="any">
											</div>
											<div class=" form-group">
												<label>Garsat Rate</label> <span class="text-danger">*
												</span>&nbsp; <span id="errgarsatRate" name="errgarsatRate"
													class="text-danger"> </span> <input class="form-control"
													type="number" name="garsatRate" id="garsatRate"
													placeholder="Garsat Rate" onkeyup="deleteErrorMsg()"
													min="0" step="any">
											</div>
											<div class="form-group">
												<label>Amount Payable</label><span class="text-danger">*
												</span>&nbsp; <span id="erramountPayable" name="erramountPayable"
													class="text-danger"> </span> <input class="form-control"
													type="number" name="amountPayable" id="amountPayable"
													placeholder="Amount Payable" onkeyup="deleteErrorMsg()"
													min="0" step="any">
											</div>

											<div class=" form-group">
												<label>Jute Variety</label> <span class="text-danger">*
												</span>&nbsp; <span id="errjuteVariety" name="errjuteVariety"
													class="text-danger"> </span> <select name="juteVariety"
													id="juteVariety" class="form-control"
													onselect="deleteErrorMsg()">
													<option value="">Select</option>
													<option value="Bimli">Bimli</option>
													<option value="Mesta">Mesta</option>
													<option value="Tossa">Tossa</option>
													<option value="White">White</option>
													<option value="Tossa (New)">Tossa (New)</option>
													<option value="White (New)">White (New)</option>
												</select>

											</div>
											<div class="  form-group">
												<label>Drum-wise Quantity</label> <span class="text-danger">*
												</span>&nbsp; <span id="errdrumWiseQuantity"
													name="errdrumWiseQuantity" class="text-danger"> </span> <span
													id="sum1" style="COLOR: DARKGREEN;"></span> <input
													class="form-control" type="number" name="drumWiseQuantity1"
													id="drumWiseQuantity1" placeholder="Drum Wise Quantity 1"
												 min="0" onblur="sum();" />
											</div>
											<div class=" form-group">
												<span id="sum2" style="COLOR: DARKGREEN;"></span> <input
													class="form-control" type="number" name="drumWiseQuantity2"
													id="drumWiseQuantity2" placeholder="Drum Wise Quantity 2"
													 min="0" onblur="sum();">
											</div>
											<div class=" form-group">
												<span id="sum3" style="COLOR: DARKGREEN;"></span> <input
													class="form-control" type="number" name="drumWiseQuantity3"
													id="drumWiseQuantity3" 
													placeholder="Drum Wise Quantity 3" min="0" onblur="sum();">
											</div>
											<div class="form-group">
												<span id="sum4" style="COLOR: DARKGREEN;"></span> <input
													class="form-control" type="number" name="drumWiseQuantity4"
													id="drumWiseQuantity4" 
													placeholder="Drum Wise Quantity 4" min="0" onblur="sum();">
											</div>
											<div class=" form-group">
												<span id="sum5" style="COLOR: DARKGREEN;"></span> <input
													class="form-control" type="number" name="drumWiseQuantity5"
													id="drumWiseQuantity5"
													placeholder="Drum Wise Quantity 5" min="0" onblur="sum();">
											</div>

											<div class="form-group">
												<span id="sum6" style="COLOR: DARKGREEN;"></span> <input
													class="form-control" type="number" name="drumWiseQuantity6"
													id="drumWiseQuantity6" 
													placeholder="Drum Wise Quantity 6" min="0" onblur="sum();">
											</div>
											<div class="form-group">
												<span id="sum7" style="COLOR: DARKGREEN;"></span> <input
													class="form-control" type="number" name="drumWiseQuantity7"
													id="drumWiseQuantity7" 
													placeholder="Drum Wise Quantity 7" min="0" onblur="sum();">
											</div>
											<div class="form-group">
												<span id="sum8" style="COLOR: DARKGREEN;"></span> <input
													class="form-control" type="number" name="drumWiseQuantity8"
													id="drumWiseQuantity8" 
													placeholder="Drum Wise Quantity 8" min="0" onblur="sum();">
											</div>

											<div class="form-group">
												<span id="sum9" style="COLOR: DARKGREEN;"></span> <input
													class="form-control" type="number" name="drumWiseQuantity9"
													id="drumWiseQuantity9" 
													placeholder="Drum Wise Quantity 9" min="0" onblur="sum();">
											</div>
											<div class="form-group">
												<span id="sum10" style="COLOR: DARKGREEN;"></span> <input
													class="form-control" type="number"
													name="drumWiseQuantity10" id="drumWiseQuantity10" 
													placeholder="Drum Wise Quantity 10" min="0" onblur="sum();">
											</div>
											<div class="form-group">
												<span id="sum11" style="COLOR: DARKGREEN;"></span> <input
													class="form-control" type="number"
													name="drumWiseQuantity11" id="drumWiseQuantity11"
													placeholder="Drum Wise Quantity 11" min="0" onblur="sum();">
											</div>

											<div class="form-group">
												<span id="sum12" style="COLOR: DARKGREEN;"></span> <input
													class="form-control" type="number"
													name="drumWiseQuantity12" id="drumWiseQuantity12" 
													placeholder="Drum Wise Quantity 12" min="0" onblur="sum();">
											</div>
											<div class="form-group">
												<span id="sum13" style="COLOR: DARKGREEN;"></span> <input
													class="form-control" type="number" 
													name="drumWiseQuantity13" id="drumWiseQuantity13"
													placeholder="Drum Wise Quantity 13" min="0" onblur="sum();">
											</div>
											<div class="form-group">
												<span id="sum14" style="COLOR: DARKGREEN;"></span> <input
													class="form-control" type="number"
													name="drumWiseQuantity14" id="drumWiseQuantity14"
													placeholder="Drum Wise Quantity 14" min="0" onblur="sum();">
											</div>

											<div class="form-group">
												<span id="sum15" style="COLOR: DARKGREEN;"></span> <input
													class="form-control" type="number"
													name="drumWiseQuantity15" id="drumWiseQuantity15" 
													placeholder="Drum Wise Quantity 15" min="0" onblur="sum();">
											</div>
											<div class="form-group">
												<span id="sum16" style="COLOR: DARKGREEN;"></span> <input
													class="form-control" type="number"
													name="drumWiseQuantity16" id="drumWiseQuantity16"
													placeholder="Drum Wise Quantity 16" min="0" onblur="sum();">
											</div>
											<div class="form-group">
												<span id="sum17" style="COLOR: DARKGREEN;"></span> <input
													class="form-control" type="number"
													name="drumWiseQuantity17" id="drumWiseQuantity17" 
													placeholder="Drum Wise Quantity 17" min="0" onblur="sum();">
											</div>

											<div class="form-group">
												<span id="sum18" style="COLOR: DARKGREEN;"></span> <input
													class="form-control" type="number"
													name="drumWiseQuantity18" id="drumWiseQuantity18" 
													placeholder="Drum Wise Quantity 18" min="0" onblur="sum();">
											</div>
											<div class="form-group">
												<span id="sum19" style="COLOR: DARKGREEN;"></span> <input
													class="form-control" type="number"
													name="drumWiseQuantity19" id="drumWiseQuantity19" 
													placeholder="Drum Wise Quantity 19" min="0" onblur="sum();">
											</div>
											<div class="form-group">
												<span id="sum20" style="COLOR: DARKGREEN;"></span> <input
													class="form-control" type="number"
													name="drumWiseQuantity20" id="drumWiseQuantity20" 
													placeholder="Drum Wise Quantity 20" min="0" onblur="sum();">
											</div>


											<div class="form-group">
												<span id="sum21" style="COLOR: DARKGREEN;"></span> <input
													class="form-control" type="number"
													name="drumWiseQuantity21" id="drumWiseQuantity21" 
													placeholder="Drum Wise Quantity 21" min="0" onblur="sum();">
											</div>
											<div class="form-group">
												<span id="sum22" style="COLOR: DARKGREEN;"></span> <input
													class="form-control" type="number"
													name="drumWiseQuantity22" id="drumWiseQuantity22" 
													placeholder="Drum Wise Quantity 22 " min="0"
													onblur="sum();">
											</div>
											<div class="form-group">
												<span id="sum23" style="COLOR: DARKGREEN;"></span> <input
													class="form-control" type="number"
													name="drumWiseQuantity23" id="drumWiseQuantity23" 
													placeholder="Drum Wise Quantity 23" min="0" onblur="sum();">
											</div>

											<div class="form-group">
												<span id="sum24" style="COLOR: DARKGREEN;"></span> <input
													class="form-control" type="number"
													name="drumWiseQuantity24" id="drumWiseQuantity24" 
													placeholder="Drum Wise Quantity 24" min="0" onblur="sum();">
											</div>
											<div class="form-group">
												<span id="sum25" style="COLOR: DARKGREEN;"></span> <input
													class="form-control" type="number"
													name="drumWiseQuantity25" id="drumWiseQuantity25" 
													placeholder="Drum Wise Quantity 25" min="0" onblur="sum();">
											</div>
											<div class="form-group">
												<span id="sum26" style="COLOR: DARKGREEN;"></span> <input
													class="form-control" type="number"
													name="drumWiseQuantity26" id="drumWiseQuantity26" 
													placeholder="Drum Wise Quantity 26" min="0" onblur="sum();">
											</div>

											<div class="form-group">
												<span id="sum27" style="COLOR: DARKGREEN;"></span> <input
													class="form-control" type="number"
													name="drumWiseQuantity27" id="drumWiseQuantity27" 
													placeholder="Drum Wise Quantity 27" min="0" onblur="sum();">
											</div>

											<div class="form-group">
												<span id="sum28" style="COLOR: DARKGREEN;"></span> <input
													class="form-control" type="number"
													name="drumWiseQuantity28" id="drumWiseQuantity28" 
													placeholder="Drum Wise Quantity 28" min="0" onblur="sum();">
											</div>

											<div class="form-group">
												<span id="sum29" style="COLOR: DARKGREEN;"></span> <input
													class="form-control" type="number"
													name="drumWiseQuantity29" id="drumWiseQuantity29" 
													placeholder="Drum Wise Quantity 29" min="0" onblur="sum();">
											</div>

											<div class="form-group">
												<span id="sum30" style="COLOR: DARKGREEN;"></span> <input
													class="form-control" type="number"
													name="drumWiseQuantity30" id="drumWiseQuantity30" 
													placeholder="Drum Wise Quantity 30" min="0" onblur="sum();">
											</div>
											<div class="form-group">
												<span id="sum31" style="COLOR: DARKGREEN;"></span> <input
													class="form-control" type="number"
													name="drumWiseQuantity31" id="drumWiseQuantity31" 
													placeholder="Drum Wise Quantity 31" min="0" onblur="sum();">
											</div>
											<div class="form-group">
												<span id="sum32" style="COLOR: DARKGREEN;"></span> <input
													class="form-control" type="number"
													name="drumWiseQuantity32" id="drumWiseQuantity32" 
													placeholder="Drum Wise Quantity 32" min="0" onblur="sum();">
											</div>

											<div class="form-group">
												<span id="sum33" style="COLOR: DARKGREEN;"></span> <input
													class="form-control" type="number"
													name="drumWiseQuantity33" id="drumWiseQuantity33" 
													placeholder="Drum Wise Quantity 33" min="0" onblur="sum();">
											</div>
											<div class="form-group">
												<span id="sum34" style="COLOR: DARKGREEN;"></span> <input
													class="form-control" type="number"
													name="drumWiseQuantity34" id="drumWiseQuantity34" 
													placeholder="Drum Wise Quantity 34" min="0" onblur="sum();">
											</div>
											<div class="form-group">
												<span id="sum35" style="COLOR: DARKGREEN;"></span> <input
													class="form-control" type="number"
													name="drumWiseQuantity35" id="drumWiseQuantity35" 
													placeholder="Drum Wise Quantity 35" min="0" onblur="sum();">
											</div>

											<div class="form-group">
												<span id="sum36" style="COLOR: DARKGREEN;"></span> <input
													class="form-control" type="number"
													name="drumWiseQuantity36" id="drumWiseQuantity36" 
													placeholder="Drum Wise Quantity 36" min="0" onblur="sum();">
											</div>
											<div class="form-group">
												<span id="sum37" style="COLOR: DARKGREEN;"></span> <input
													class="form-control" type="number"
													name="drumWiseQuantity37" id="drumWiseQuantity37" 
													placeholder="Drum Wise Quantity 37" min="0" onblur="sum();">
											</div>
											<div class="form-group">
												<span id="sum38" style="COLOR: DARKGREEN;"></span> <input
													class="form-control" type="number"
													name="drumWiseQuantity38" id="drumWiseQuantity38" 
													placeholder="Drum Wise Quantity 38" min="0" onblur="sum();">
											</div>

											<div class="form-group">
												<span id="sum39" style="COLOR: DARKGREEN;"></span> <input
													class="form-control" type="number"
													name="drumWiseQuantity39" id="drumWiseQuantity39" 
													placeholder="Drum Wise Quantity 39" min="0" onblur="sum();">
											</div>
											<div class="form-group">
												<span id="sum40" style="COLOR: DARKGREEN;"></span> <input
													class="form-control" type="number"
													name="drumWiseQuantity40" id="drumWiseQuantity40" 
													placeholder="Drum Wise Quantity 40" min="0" onblur="sum();">
											</div>
											<div class="form-group">
												<span id="sum41" style="COLOR: DARKGREEN;"></span> <input
													class="form-control" type="number"
													name="drumWiseQuantity41" id="drumWiseQuantity41" 
													placeholder="Drum Wise Quantity 41" min="0" onblur="sum();">
											</div>


											<div class=" form-group">
												<span id="sum42" style="COLOR: DARKGREEN;"></span> <input
													class="form-control" type="number"
													name="drumWiseQuantity42" id="drumWiseQuantity42" 
													placeholder="Drum Wise Quantity 42" min="0" onblur="sum();">
											</div>
											<div class="form-group">
												<span id="sum43" style="COLOR: DARKGREEN;"></span> <input
													class="form-control" type="number"
													name="drumWiseQuantity43" id="drumWiseQuantity43" 
													placeholder="Drum Wise Quantity 43" min="0" onblur="sum();">
											</div>
											<div class="form-group">
												<span id="sum44" style="COLOR: DARKGREEN;"></span> <input
													class="form-control" type="number"
													name="drumWiseQuantity44" id="drumWiseQuantity44" 
													placeholder="Drum Wise Quantity 44" min="0" onblur="sum();">
											</div>

											<div class="form-group">
												<span id="sum45" style="COLOR: DARKGREEN;"></span> <input
													class="form-control" type="number"
													name="drumWiseQuantity45" id="drumWiseQuantity45" 
													placeholder="Drum Wise Quantity 45" min="0" onblur="sum();">
											</div>
											<div class="form-group">
												<span id="sum46" style="COLOR: DARKGREEN;"></span> <input
													class="form-control" type="number"
													name="drumWiseQuantity46" id="drumWiseQuantity46" 
													placeholder="Drum Wise Quantity 46" min="0" onblur="sum();">
											</div>
											<div class="form-group">
												<span id="sum47" style="COLOR: DARKGREEN;"></span> <input
													class="form-control" type="number" 
													name="drumWiseQuantity47" id="drumWiseQuantity47"
													placeholder="Drum Wise Quantity 47" min="0" onblur="sum();">
											</div>

											<div class="form-group">
												<span id="sum48" style="COLOR: DARKGREEN;"></span> <input
													class="form-control" type="number" 
													name="drumWiseQuantity48" id="drumWiseQuantity48"
													placeholder="Drum Wise Quantity 48" min="0" onblur="sum();">
											</div>
											<div class="form-group">
												<span id="sum49" style="COLOR: DARKGREEN;"></span> <input
													class="form-control" type="number" 
													name="drumWiseQuantity49" id="drumWiseQuantity49"
													placeholder="Drum Wise Quantity 49" min="0" onblur="sum();">
											</div>
											<div class="form-group">
												<span id="sum50" style="COLOR: DARKGREEN;"></span> <input
													class="form-control" type="number"
													name="drumWiseQuantity50" id="drumWiseQuantity50" 
													placeholder="Drum Wise Quantity 50" min="0" onblur="sum();">
											</div>

											<div class="form-group">
												<input class="form-control" type="hidden" name="error"
													id="error" value="">
											</div>
											<div class="form-group">
												<input class="form-control" type="hidden" name="status"
													id="status" value="">
											</div>

											<div class="form-group">
												<input class="form-control" type="hidden" name="grsqty"
													id="grsqty" value="0.0">
											</div>

											<div class="form-group">
												<button class="btn btn-default" type="submit"
													id="enq_submit"
													style="margin-left: 15px; width: 120px; background: mediumseagreen; color: white;">Verify</button>
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
 function sum(){
		var sum_gross=0;
	    for (var i=1; i<=50; i++){
	    	var value =0;
	    	if(document.getElementById("drumWiseQuantity"+i).value != "" || document.getElementById("drumWiseQuantity"+i).value != null){
	    		 value = document.getElementById("drumWiseQuantity"+i).value;
	    	}
		sum_gross += Number(value);

		  document.getElementById("sum"+i).innerHTML = sum_gross;
		
	    } 	    
 }
 
 
 </script>
<script>
	function validate() {
	let	 farmerRegNo = document.forms["myForm"]["farmerRegNo"].value;
	let	 tallyNo = document.forms["myForm"]["tallyNo"].value;
	let	dateOfPurchase = document.forms["myForm"]["dateOfPurchase"].value;
	let	 placeOfPurchase = document.forms["myForm"]["placeOfPurchase"].value;
	let	 rateSlipNumber = Number(document.forms["myForm"]["rateSlipNumber"].value);
	let	 binNumber = Number(document.forms["myForm"]["binNumber"].value);
	let	 juteVariety = document.forms["myForm"]["juteVariety"].value;
	
	let	 netQuantity =  Number(document.forms["myForm"]["netQuantity"].value);
	netQuantity =  netQuantity.toFixed(3);
	let	 garsatRate = Number(document.forms["myForm"]["garsatRate"].value);
	garsatRate = garsatRate.toFixed(3);
	let	 amountPayable = Number(document.forms["myForm"]["amountPayable"].value);
	amountPayable = amountPayable.toFixed(3);
	var sum_gross=0;
    for (var i=1; i<=50; i++){
	sum_gross += Number(document.getElementById("drumWiseQuantity"+i).value);
    }
    sum_gross = sum_gross.toFixed(3);
	 
	var errors= "";
	var missing= true;
	var mismatch = true;
	
	   if (farmerRegNo == "") { 
			document.getElementById("errfarmerRegNo").innerHTML = "Farmer registration number can not be empty!";
			document.forms["myForm"]["farmerRegNo"].focus();
			missing= false;
			 
		}  if (tallyNo == "") {
			document.getElementById("errtallyNo").innerHTML = "Tally slip number can not be empty!";
			missing= false;
			document.forms["myForm"]["tallyNo"].focus();

		}  

		 if (dateOfPurchase == "") { 
			document.getElementById("errdateOfPurchase").innerHTML = "Date of purchase can not be empty!";
			missing= false;
			document.forms["myForm"]["dateOfPurchase"].focus();
		}
		 
		 if (placeOfPurchase == "") {
			document.getElementById("errplaceOfPurchase").innerHTML = "Place of purchase can not be empty!";
			missing= false;
			document.forms["myForm"]["placeOfPurchase"].focus();
		}

		 if (rateSlipNumber == "") {
			document.getElementById("errrateSlipNumber").innerHTML = "Rate Slip Number can not be empty!";
			missing= false;
			document.forms["myForm"]["rateSlipNumber"].focus();
		}

		 if (binNumber == "") {
			document.getElementById("errbinNumber").innerHTML = "Bin Number can not be empty!";
			document.forms["myForm"]["binNumber"].focus();
			missing= false;
			 
		}  if (juteVariety == "") {
			document.getElementById("errjuteVariety").innerHTML = "Jute Variety can not be empty!";
			missing= false;	
			document.forms["myForm"]["juteVariety"].focus();
		}
		 
		 if (netQuantity == "") {
			document.getElementById("errnetQuantity").innerHTML = "Net Quantity can not be empty!";
			document.forms["myForm"]["netQuantity"].focus();
			missing= false;
			 
		}  if (garsatRate == "") {
			document.getElementById("errgarsatRate").innerHTML = "Garsat Rate can not be empty!";
			document.forms["myForm"]["garsatRate"].focus();
			missing= false;
			 
		}  if (amountPayable == "") {
			document.getElementById("erramountPayable").innerHTML = "Amount Payable can not be empty!";
			document.forms["myForm"]["amountPayable"].focus();
			missing= false;
			 
		}
		 if (farmerRegNo !== farmno) {
			 
			 mismatch= false;
			errors += "Farmer registration number didn't match! </br> ";
			
			 
		}  if (dateOfPurchase !== dop) {
			errors += "Date of purchase didn't match! </br> ";
			mismatch= false;
			 
		}  if (rateSlipNumber !== rsn) {
			mismatch= false;
			errors += "Rate Slip Number didn't match! </br> ";
			 
		}  if (binNumber !== bin) {
			
			mismatch= false;
			errors += "Bin Number didn't match!!  </br>";
			 
		}  if (netQuantity !== ntqty) {
			mismatch= false;
			 errors += "Net Quantity didn't match! </br>";
			 
		}  if (garsatRate !== grate) {
			mismatch= false;
			 errors += "Garsat Rate didn't match! </br> ";
			 
		}  if (amountPayable !== amtpay) {
			mismatch= false; 
			 errors += "Amount Payable didn't match! </br> ";
			 
		}  if (juteVariety.toUpperCase() !== jutevar.toUpperCase()) {
			mismatch= false;
			 errors +="Jute Variety didn't match!  </br> ";
			 
		}

		 if (placeOfPurchase !== pop) {
			 mismatch= false;
			 errors += "Place Of Purchase didn't match! </br> ";
			 
		}
		 if (sum_gross !== grossqty) {
			 mismatch= false;
			errors += "Gross quantity didn't match! </br> ";
			}
	   if(missing)
		 {
			 if(mismatch)
				 {
				 document.forms["myForm"]["error"].value  = "";
				 document.forms["myForm"]["grsqty"].value  = sum_gross;
				 document.forms["myForm"]["status"].value = 'FA';
				 return mismatch;
				 }
			 else
				 {
			 
				 var title = "Data Mismatch with the 1st level of Entry";
				 
				 var $content =  "<div class='dialog-ovelay'>" +
	             "<div class='dialog'><header>" +
	              " <h3 style = 'font-family : monospace; font-size: x-large;''> " + title + " </h3> " +
	              "<i class='fa fa-close'></i>" +
	          "</header>" +
	          "<div class='dialog-msg'>" +
	              " <p style = 'font-family : themify; color : red'> " + errors + " </p> " +
	          "</div>" +
	          "<footer>" +
	              "<div class='controls'>" +
	              " <button class='button button-default cancelAction'> Cancel</button> " +
	                  " <button class='button button-danger doAction'> Force Submit</button> " +
	                  
	              "</div>" +
	          "</footer>" +
	       "</div>" +
	     "</div>";
	     
	     
	             $('body').prepend($content);
	              $('.doAction').click(function () {	    
	             $(this).parents('.dialog-ovelay').fadeOut(500, function () {
	             $(this).remove();
	             $("form[name='myForm']").attr('onsubmit', '');
	             document.forms["myForm"]["error"].value  = errors;
	             document.forms["myForm"]["grsqty"].value  = sum_gross;
				 document.forms["myForm"]["status"].value = 'RMD';
	             $('#enq_submit').click();
	           });
	        });
	            $('.cancelAction, .fa-close').click(function () {
	            $(this).parents('.dialog-ovelay').fadeOut(500, function () {
	            $(this).remove();
	             
	            });
	          });

	           window.scrollTo(0,0);
	           return mismatch;
				 
				 }
		 }
		 else
			 {
			 //Confirm("Data Mismatch with the 1st level of Entry",errors,'Force Submit', 'Cancel');
			 
			// alert("Mai yha hoon");
			 return missing;	
			 }
			 
	 
	}
	
</script>


<script>
	function transection() {
		 tallyNo = document.forms["myForm"]["tallyNo"].value;
		 if (tallyNo.length >= 3) {
            var reg = '<%=region%>';
			 $.ajax({
						type : "GET",
						url : "transectionDetails.obj",
						data : jQuery.param({"tallyslipNo" : tallyNo,"region" : reg}),
						success : function(result) {
						if(result)
						  {
							var parsedJSON = JSON.parse(result);
							 farmno = parsedJSON.farmerRegNo;
							 tallyno = parsedJSON.tallyNo;
							 dop = parsedJSON.dop;
							 rsn = parsedJSON.rateslipno;
							 bin = parsedJSON.binno;
							 jutevar = parsedJSON.jutevariety;
							 ntqty = parsedJSON.netquantity.toFixed(3);
							 grate = parsedJSON.garsatrate.toFixed(3);
							 tallyimage = parsedJSON.tallySlipImg;
							 grossqty =  parsedJSON.grossqty.toFixed(3);
							 amtpay = parsedJSON.amountpayable.toFixed(3);
							 pop = parsedJSON.placeOfPurchase;
							 popname = parsedJSON.popname;
							 $("#uploadedImage").attr("src","http://49.50.79.121:8080/TallySlip/"+tallyimage);
							// $("#placeOfPurchase").attr("value",pop);
							 $("#popname").attr("value",popname);
							// magnify("uploadedImage", 2);
						  }
						else{
							
							alert("No data found for the entered Tally slip.");
							}
						}
					});

		}
		 
	}
</script>



<script>
	function deleteErrorMsg() {

		let farmerRegNo = document.forms["myForm"]["farmerRegNo"].value;
		if (farmerRegNo.length > 1) {
			$("#errfarmerRegNo").hide();
		}
		let tallyNo = document.forms["myForm"]["tallyNo"].value;
		if (tallyNo.length > 1) {
			//$("#errtallyNo").hide();
		}
		let dateOfPurchase = document.forms["myForm"]["dateOfPurchase"].value;
		if (dateOfPurchase.length > 1) {
			$("#errdateOfPurchase").hide();
		}

		let placeOfPurchase = document.forms["myForm"]["placeOfPurchase"].value;
		if (placeOfPurchase.length > 1) {
			$("#errplaceOfPurchase").hide();
		}
		let rateSlipNumber = document.forms["myForm"]["rateSlipNumber"].value;
		if (rateSlipNumber.length > 1) {
			$("#errrateSlipNumber").hide();
		}
		/* let rateslipno = document.forms["myForm"]["rateslipno"].value; 
			if(rateslipno.length>1){
				 $("#errrateslipno").hide();
			}  */
		let binNumber = document.forms["myForm"]["binNumber"].value;
		if (binNumber.length > 1) {
			$("#errbinNumber").hide();
		}

		let juteVariety = document.forms["myForm"]["juteVariety"].value;
		if (juteVariety.length > 1) {
			$("#errjuteVariety").hide();
		}
		/* let drumWiseQuantity = document.forms["myForm"]["drumWiseQuantity"].value; 
			if(drumWiseQuantity.length>1){
				  $("#errdrumWiseQuantity").hide();
			} */
		let netQuantity = document.forms["myForm"]["netQuantity"].value;
		if (netQuantity.length > 1) {
			$("#errnetQuantity").hide();
		}
		let garsatRate = document.forms["myForm"]["garsatRate"].value;
		if (garsatRate.length > 1) {
			$("#errgarsatRate").hide();
		}

		let amountPayable = document.forms["myForm"]["amountPayable"].value;
		if (amountPayable.length > 1) {
			$("#erramountPayable").hide();
		}

	}
	
	
	
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
	var zoom = 100;
	
	$('.zoom').on('click', function(){
		zoom += 50;
		$('.target').css('width', zoom +'%' );
	});
	$('.zoom-init').on('click', function(){
		zoom = 100;
		$('.target').css('width', zoom + '%');
	});
	$('.zoom-out').on('click', function(){
		zoom -= 50;
		$('.target').css('width', zoom + '%');
	});
 </script>



</html>
