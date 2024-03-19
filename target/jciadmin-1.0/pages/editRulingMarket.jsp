<!DOCTYPE html>
<html lang="en">
<%@page import="com.jci.model.RulingMarket"%>
<%@ page import="javax.servlet.http.HttpServletRequest"%>
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
				<h1 class="page-title">Edit BIN</h1>
			</div>
			<div class="page-content fade-in-up">
				<div class="row">
					<div class="col-md-11">
						<div class="ibox">
							<div class="ibox-head">
								<!-- <div class="ibox-title">Basic form</div> -->
								<span>${msg}</span>
							</div>
							<% 
							RulingMarket rulingMarket = (RulingMarket) request.getAttribute("rulingMarket");
							%>
							<div class="ibox-body">
							     <form action="updateRulingMarket.obj" method="POST">
                                    <div class="row">
                                        <div class="col-sm-4 form-group">
                                            <label>DPC Name</label>
                                            <input type="hidden" name="id" value="<%=rulingMarket.getJcirulingmarketid()%>">
                                            <input class="form-control" type="text" name="dpcname" placeholder="DPC Name" value="<%=rulingMarket.getDpcname()%>" required>
                                        </div>
                                        <div class="col-sm-4 form-group">
                                            <label>Number of Arrival</label>
                                            <input class="form-control" type="text" name="noofarrival" placeholder="Number of Arrival" value="<%=rulingMarket.getNoofarrival()%>" required>
                                        </div>
                                        <div class="col-sm-4 form-group">
											<label>Date of Effect</label> 
											<input class="form-control" type="date" name="dateofarrival" placeholder="Date of Arrival" value="<%=rulingMarket.getDateofarrival()%>" required>
										</div>
                                    </div>
                                    
                                    <div class="row">
                                        <div class="col-sm-4 form-group">
                                             <label>Jute Variety</label>
                                        	 <input class="form-control" name="jutevariety" type="text" placeholder="Jute Variety" value="<%=rulingMarket.getJutevariety()%>" required>
                                        </div>
                                       
										<div class="col-sm-4 form-group">
                                            <label>Crop Year</label> 
											<input class="form-control" name="cropyear" type="text" placeholder="Crop Year" value="<%=rulingMarket.getCropyear()%>" required>
                                        </div>
                                        <div class="col-sm-4 form-group">
                                             <label>Arrived Quantity</label>
                                        <input class="form-control" name="arrivedquantity" type="text" placeholder="Arrived Quantity" value="<%=rulingMarket.getArrivedquantity()%>" required>
                                        </div>
                                    </div>
                                    <div class="row">
                                        <div class="col-sm-4 form-group">
											<label>Minimum Moisture</label>
                                        	<input class="form-control" name="minmoisture" type="text" placeholder="Minimum Moisture" value="<%=rulingMarket.getMinmoisture()%>" required>
										</div>
										<div class="col-sm-4 form-group">
											<label>Maximum Moisture</label>
                                        	<input class="form-control" name="maxmoisture" type="text" placeholder="Maximum Moisture" value="<%=rulingMarket.getMaxmoisture()%>" required>
										</div>
										<div class="col-sm-4 form-group">
											<label>Grade Wise Field</label>
                                        	<input class="form-control" name="gradewisefield" type="text" placeholder="Grade Wise Field" value="<%=rulingMarket.getGradewisefield()%>" required>
										</div>
                                    </div>
                                    <div class="row">
                                        <div class="col-sm-4 form-group">
											<label>Grade Wise Rate</label>
                                        	<input class="form-control" name="gradewiserate" type="text" placeholder="Grade Wise Rate" value="<%=rulingMarket.getGradewiserate()%>"  required>
										</div>
										<div class="col-sm-4 form-group">
											<label>Estimated Grade Composition</label>
                                        	<input class="form-control" name="estimatedgradecomposition" type="text" placeholder="Estimated Grade Composition" value="<%=rulingMarket.getEstimatedgradecomposition()%>" required>
										</div>
                                    </div>                                    
                                    <div class="form-group col-sm-12">
                                        <button class="btn btn-default" type="submit">Update</button>
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