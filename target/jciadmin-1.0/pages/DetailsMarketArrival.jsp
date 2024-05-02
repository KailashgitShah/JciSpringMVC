<!DOCTYPE html>
<html lang="en">
<%@page import="com.jci.model.FarmerRegModel"%>
<%@ page import="javax.servlet.http.HttpServletRequest"%>
<%@page import="com.jci.model.StateList"%>
<%@page import="java.util.List"%>
<%@page import="com.jci.model.MarketArrivalModel"%>
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
				<h1 class="page-title">Market Details</h1>
			</div>
			
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
							
							<a href="viewmarketArrival.obj">Go Back</a>
							</div>
					</div>
							<% 
							MarketArrivalModel allmarketArrivalList = (MarketArrivalModel) request.getAttribute("marketArrival");	
							
							%>
							<div class="ibox-body">
								
									<table>
									<tr>
											<td ><b>Arrival Date</b></td> 
											
											<td><b>:&nbsp;&nbsp;&nbsp;<%=allmarketArrivalList.getDatearrival() %></b></td>
											</tr>
											<tr>
											<td ><b>DPC Name</b></td> 
											
											<td><b>:&nbsp;&nbsp;&nbsp;<%=allmarketArrivalList.getCentername() %></b></td>
											</tr>
											<tr>
											<td ><b>Jute Variety</b></td> 
											
											<td><b>:&nbsp;&nbsp;&nbsp;<%=allmarketArrivalList.getJutevariety() %></b></td>
											</tr>
											<tr>
											<td ><b>Crop Year</b></td> 
											
											<td><b>:&nbsp;&nbsp;&nbsp;<%=allmarketArrivalList.getCropyr() %></b></td>
											</tr>
											<tr>
											<td ><b>Arrived Quantity</b></td> 
											
											<td><b>:&nbsp;&nbsp;&nbsp;<%=allmarketArrivalList.getArrivedqty() %></b></td>
											</tr>
											<tr>
											<td ><b>Minimum Moisture</b></td> 
											
											<td><b>:&nbsp;&nbsp;&nbsp;<%=allmarketArrivalList.getMixmois() %></b></td>
											</tr>
											<tr>
											<td ><b>Maximum Moisture</b></td> 
											
											<td><b>:&nbsp;&nbsp;&nbsp;<%=allmarketArrivalList.getMaxmois() %></b></td>
											</tr>
											<tr>
											<td ><b>Grade1</b></td> 
											
											<td><b>:&nbsp;&nbsp;&nbsp;<%=allmarketArrivalList.getGrade1() %></b></td>
											</tr>
											<tr>
											<td ><b>Grade2</b></td> 
											
											<td><b>:&nbsp;&nbsp;&nbsp;<%=allmarketArrivalList.getGrade2() %></b></td>
											</tr>
											<tr>
											<td ><b>Grade3</b></td> 
											
											<td><b>:&nbsp;&nbsp;&nbsp;<%=allmarketArrivalList.getGrade3() %></b></td>
											</tr>
											<tr>
											<td ><b>Grade4</b></td> 
											
											<td><b>:&nbsp;&nbsp;&nbsp;<%=allmarketArrivalList.getGrade4() %></b></td>
											</tr>
											<tr>
											<td ><b>Grade5</b></td> 
											
											<td><b>:&nbsp;&nbsp;&nbsp;<%=allmarketArrivalList.getGrade5() %></b></td>
											</tr>
											<tr>
											<td ><b>Grade6</b></td> 
											
											<td><b>:&nbsp;&nbsp;&nbsp;<%=allmarketArrivalList.getGrade6()%></b></td>
											</tr>
											<tr>
											<td ><b>Grade7</b></td> 
											
											<td><b>:&nbsp;&nbsp;&nbsp;<%=allmarketArrivalList.getGrade7()%></b></td>
											</tr>
											<tr>
											<td ><b>Grade8</b></td> 
											
											<td><b>:&nbsp;&nbsp;&nbsp;<%=allmarketArrivalList.getGrade8() %></b></td>
											</tr>
											<tr>
											<td ><b>Grade 1 Price</b></td> 
											
											<td><b>:&nbsp;&nbsp;&nbsp;<%=allmarketArrivalList.getGrade_rate1() %></b></td>
											</tr>
											<tr>
											<td ><b>Grade 2 Price</b></td> 
											
											<td><b>:&nbsp;&nbsp;&nbsp;<%=allmarketArrivalList.getGrade_rate2()%></b></td>
											</tr>
											<tr>
											<td ><b>Grade 3 Price</b></td> 
											
											<td><b>:&nbsp;&nbsp;&nbsp;<%=allmarketArrivalList.getGrade_rate3() %></b></td>
											</tr>
											<tr>
											<td ><b>Grade 4 Price</b></td> 
											
											<td><b>:&nbsp;&nbsp;&nbsp;<%=allmarketArrivalList.getGrade_rate4() %></b></td>
											</tr>
											<tr>
											<td ><b>Grade 5 Price</b></td> 
											
											<td><b>:&nbsp;&nbsp;&nbsp;<%=allmarketArrivalList.getGrade_rate5() %></b></td>
											</tr>
											<tr>
											<td ><b>Grade 6 Price</b></td> 
											
											<td><b>:&nbsp;&nbsp;&nbsp;<%=allmarketArrivalList.getGrade_rate6() %></b></td>
											</tr>
											<tr>
											<td ><b>Grade 7 Price</b></td> 
											
											<td><b>:&nbsp;&nbsp;&nbsp;<%=allmarketArrivalList.getGrade_rate7() %></b></td>
											</tr>
											<tr>
											<td ><b>Grade 8 Price</b></td> 
										
											<td><b>:&nbsp;&nbsp;&nbsp;<%=allmarketArrivalList.getGrade_rate8() %></b></td>
											</tr>
											</table>

						
						
						
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