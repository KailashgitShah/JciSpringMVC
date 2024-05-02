<!DOCTYPE html>
<html lang="en">
<%@page import="com.jci.model.RawJuteProcurementAndPayment"%>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width initial-scale=1.0">
    <title>JCI | CMS</title>
    <!-- GLOBAL MAINLY STYLES-->
    <link href="./assets/vendors/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet" />
    <link href="./assets/vendors/font-awesome/css/font-awesome.min.css" rel="stylesheet" />
    <link href="./assets/vendors/themify-icons/css/themify-icons.css" rel="stylesheet" />
    <!-- PLUGINS STYLES-->
    <!-- THEME STYLES-->
    <link href="assets/css/main.min.css" rel="stylesheet" />
    <!-- PAGE LEVEL STYLES-->
     <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
     <link rel="stylesheet" href="//code.jquery.com/ui/1.13.2/themes/base/jquery-ui.css">
<link rel="stylesheet" href="/resources/demos/style.css">
    <script src="https://code.jquery.com/jquery-3.6.0.js"></script>
<script src="https://code.jquery.com/ui/1.13.2/jquery-ui.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.5.0/js/bootstrap-datepicker.js"></script>  
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
                <h1 class="page-title">Jute Procurement</h1>
            </div>
            <%
				RawJuteProcurementAndPayment juteProc = (RawJuteProcurementAndPayment)request.getAttribute("juteProc");
			%>
            <div class="page-content fade-in-up">
                <div class="row">
                    <div class="col-md-11">
                        <div class="ibox">
                            <span>${msg}</span>
                            <div class="ibox-body">
                            	<span>${msg}</span>
                                <form action="updateJuteProcurement.obj" method="POST" >
                                    <div class="row">
                                        <div class="col-sm-4 form-group">
                                            <label>Farmer Registration No.</label>
                                            <input type="hidden" name="id" value="<%=juteProc.getPtsid()%>">
                                            <input class="form-control" type="text" name="farmerregno" placeholder="Farmer Registration No." value="<%=juteProc.getFarmerregno()%>" required>
                                        </div>
                                        <!--  <div class="col-sm-4 form-group">
                                            <label>Form No.</label>
                                            <input class="form-control" type="text" name="formno" placeholder="Form No." required  value="<%=juteProc.getFormno()%>">
                                        </div>-->
                                        <div class="col-sm-4 form-group">
											<label>Date of Purchase</label> 
										
											<input class="form-control" name="datepurchase" id="datepurchase" placeholder="Date of Purchase" value="<%=juteProc.getDatepurchase()%>" readonly>
										</div>
											 <div class="col-sm-4 form-group">
                                             <label>Basis</label>
                                        	 <input class="form-control" name="basis" type="text" placeholder="basis" required value="<%=juteProc.getBasis()%>">
                                        </div>
                                    </div>
                                    <div class="row">
                                    	
                                       
                                        <div class="col-sm-4 form-group">
											<label>Jute Variety</label>
                                        	<input class="form-control" name="jutevariety" id="jutevariety" placeholder="Jute Variety" value="<%=juteProc.getJutevariety()%>"  type="text">
										</div>                                       
										<div class="col-sm-4 form-group">
                                            <label>Crop Year</label> 
											<select name="cropyr" id="cropyr" class="form-control">
												<option value="">-Select-</option>
												<option value="2021-2022">2021-2022</option>
												<option value="2022-2023">2022-2023</option>
												<option value="2023-2024">2023-2024</option>
												<option value="2024-2025">2024-2025</option>
												<option value="2025-2026">2025-2026</option>
												<option value="2026-2027">2026-2027</option>
												<option value="2027-2028">2027-2028</option>
												<option value="2028-2029">2028-2029</option>
												<option value="2029-2030">2029-2030</option>
												<option value="2030-2031">2030-2031</option>
											</select>
                                        </div>
                                         <div class="col-sm-4 form-group">
											<label>Rate Slip No.</label>
                                        	<input class="form-control" name="rateslipno" type="text" placeholder="Rate Slip No." value="<%=juteProc.getRateslipno()%>">
										</div>
                                    </div>
                                    <div class="row">
                                       
										
										<div class="col-sm-4 form-group">
											<label>Bin Number</label>
                                        	<input class="form-control" name="binno" type="text" placeholder="Bin Number" value="<%=juteProc.getBinno()%>">
										</div>
										
										 <div class="col-sm-4 form-group">
                                             <label>Place of Purchase</label>
                                        	 <input class="form-control" name="placeofpurchase" type="text" placeholder="Place of Purchase" required value="<%=juteProc.getPlaceofpurchase()%>">
                                        </div>
                                         <div class="col-sm-4 form-group">
                                             <label>Gross Quantity</label>
                                        	 <input class="form-control" name="gquantity" type="text" placeholder="Gross Quantity" required value="<%=juteProc.getGrossquantity()%>">
                                        </div>
                                    </div>  
                                     
                                    <div class="row">
                                    	
                                        <div class="col-sm-4 form-group">
                                             <label>Deduction Quantity</label> 
											<input class="form-control" name="deductionQuantity" type="text" placeholder="Deduction Quantity" required value="<%=juteProc.getDeductionquantity()%>">
                                        </div>
                                        <div class="col-sm-4 form-group">
                                             <label>Garsat Rate</label>
                                        	 <input class="form-control" name="garsatRate" type="text" placeholder="Garsat Rate" required value="<%=juteProc.getGrasatrate()%>">
                                        </div>
                                        <div class="col-sm-4 form-group">
                                             <label>Amount Payable</label> 
											<input class="form-control" name="amountPayable" type="text" placeholder="Amount Payable" required value="<%=juteProc.getAmountpayable()%>">
                                        </div>
                                    </div>
                                    
                                     <div class="row">
                                    	
										<%-- <div class="col-sm-4 form-group">
                                            <label>Estimated Grade Composition</label>
	                                      	<input class="form-control" name="edtimatedGradeComposition" type="text" placeholder="Estimated Grade Composition" required value="<%=juteProc.getEstimatedgardecom()%>">
                                        </div> --%>
                                    </div>
	                                                                      
                                    <div class="form-group">
                                        <button class="btn btn-default" type="submit">Submit</button>
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
//$( "#datepurchase" ).datepicker({ maxDate: '0', minDate: '-1',dateFormat: 'yy-mm-dd'    });

</script>
    <script src="./assets/vendors/jquery/dist/jquery.min.js" type="text/javascript"></script>
    <script src="./assets/vendors/popper.js/dist/umd/popper.min.js" type="text/javascript"></script>
    <script src="./assets/vendors/bootstrap/dist/js/bootstrap.min.js" type="text/javascript"></script>
    <script src="./assets/vendors/metisMenu/dist/metisMenu.min.js" type="text/javascript"></script>
    <script src="./assets/vendors/jquery-slimscroll/jquery.slimscroll.min.js" type="text/javascript"></script>
    <!-- PAGE LEVEL PLUGINS-->
    <!-- CORE SCRIPTS-->
    <script src="assets/js/app.min.js" type="text/javascript"></script>
    <!-- PAGE LEVEL SCRIPTS-->
</body>
</html>
