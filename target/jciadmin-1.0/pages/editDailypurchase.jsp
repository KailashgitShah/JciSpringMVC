<%@page import="com.jci.model.DailyPurchaseConfModel" %>
<!DOCTYPE html>
<html lang="en">
<%@ page import="javax.servlet.http.HttpServletRequest" %>
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
                <h1 class="page-title">Edit Daily Purchase Confirmation</h1>
            </div>
            <%
            	DailyPurchaseConfModel dailyPurchase = (DailyPurchaseConfModel)request.getAttribute("dailyPurchase");
            %>
            <div class="page-content fade-in-up">
                <div class="row">
                    <div class="col-md-11">
                        <div class="ibox">
                            <div class="ibox-head">
                            	<span>${msg}</span>
                                <!-- <div class="ibox-title">Basic form</div> -->
                            </div>
                            <div class="ibox-body">
                                <form action="updateDailyPurchase.obj" method="POST" >
                                    <div class="row">
                                        <div class="col-sm-4 form-group">
                                            <label>Form No.</label>
                                            <input type="hidden" name="id" value="<%=dailyPurchase.getDpcid()%>">
                                            <input class="form-control" type="text" name="formno" placeholder="Form Number" min="0" value="<%=dailyPurchase.getFormno()%>" required>
                                        </div>
                                        <div class="col-sm-4 form-group">
                                            <label>Date of purchase</label>
                                            <input class="form-control"  name="datepurchase" placeholder="Date of Purchase" value="<%=dailyPurchase.getDatepurchase()%>" >
                                        </div>
                                        <div class="col-sm-4 form-group">
											<label>Basis</label> 
											<input class="form-control" type="text" name="basis" placeholder="Basis" required value="<%=dailyPurchase.getBasis()%>">
										</div>
                                    </div>
                                    <div class="row">
                                        <div class="col-sm-4 form-group">
                                             <label>Crop Year</label>
                                        	 <input class="form-control" name="cropyr"  placeholder="Crop Year" required value="<%=dailyPurchase.getCropyr()%>">
                                        </div>
                                       
										<div class="col-sm-4 form-group">
											<label>Place of Purchase </label>
											 <input class="form-control" name="placeofpurchase" type="text" placeholder="Place of Purchase" min="0" required value="<%=dailyPurchase.getPlaceofpurchase()%>">
                                        </div>
                                        <div class="col-sm-4 form-group">
                                        <label>Bin No.</label>
											 <input class="form-control" name="binno" type="text" placeholder="binno" min="0" required value="<%=dailyPurchase.getBinno()%>">
                                        </div>
                                    </div>

                                     <div class="row">
                                        <div class="col-sm-4 form-group">
											<label>Jute variety</label>
                                        	<input class="form-control" name="jutevariety" type="text" placeholder="jute Vareity" required value="<%=dailyPurchase.getJutevariety()%>">
										</div>
										<div class="col-sm-4 form-group">
                                             <label>Gross Quantity</label>
                                        	<input class="form-control" name="gquantity" type="text" placeholder="Gross Quantity" required  min="0" value="<%=dailyPurchase.getGquantity()%>">
                                        </div>
                                        <div class="col-sm-4 form-group">
                                            <label>Deduction Quantity</label>
                                       		<input class="form-control" name="dquantity" type="text" placeholder="Deduction Quantity" min="0" value="<%=dailyPurchase.getDquantity()%>">
                                        </div>
                                    </div>
                                    
                                    <div class="row">
                                        <div class="col-sm-4 form-group">
											<label>Net Quanntity</label>
                                        	<input class="form-control" name="netquantity" type="text" placeholder="Net Quanntity" min="0" required value="<%=dailyPurchase.getNetquantity()%>">
										</div>
										<%-- <div class="col-sm-4 form-group">
                                             <label>Estimated Grade Composition</label>
                                        	<input class="form-control" name="estimatedgardecom" type="text" placeholder="Estimated Grade Composition" required value="<%=dailyPurchase.getEstimatedgardecom()%>">
                                        </div> --%>
                                        <div class="col-sm-4 form-group">
                                             <label>Rate Slip Number</label>
                                        	<input class="form-control" name="rateslipno" type="number" placeholder="Rate Slip Number"  min="0" required value="<%=dailyPurchase.getRateslipno()%>" oninput="javascript: if (this.value.length > 5) this.value = this.value.slice(0, 5);">
                                        </div>
                                    </div>
                                    <div class="row">
                                    <div class="col-sm-4 form-group">
                                             <label>Fiber Value</label>
                                        	<input class="form-control" name="fibervalue" type="text" placeholder="Fiber Value"  min="0" required value="<%=dailyPurchase.getFibervalue()%>" >
                                        </div>
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
    <!-- END PAGA BACKDROPS-->
    <!-- CORE PLUGINS-->
    <script src="./assets/vendors/jquery/dist/jquery.min.js" type="text/javascript"></script>
    <script src="./assets/vendors/popper.js/dist/umd/popper.min.js" type="text/javascript"></script>
    <script src="./assets/vendors/bootstrap/dist/js/bootstrap.min.js" type="text/javascript"></script>
    <script src="./assets/vendors/metisMenu/dist/metisMenu.min.js" type="text/javascript"></script>
    <script src="./assets/vendors/jquery-slimscroll/jquery.slimscroll.min.js" type="text/javascript"></script>
    <!-- PAGE LEVEL PLUGINS-->
    <!-- CORE SCRIPTS-->
    <script src="assets/js/app.min.js" type="text/javascript"></script>
</body>
</html>