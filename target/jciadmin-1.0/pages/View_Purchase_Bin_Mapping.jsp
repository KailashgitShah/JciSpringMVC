<%@page import="java.util.HashMap"%>
<%@page import="java.util.List"%>
<%@page import="java.io.File"%>

<%@page import="com.jci.model.*"%>

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
<link href="./assets/vendors/DataTables/datatables.min.css"
	rel="stylesheet" />
<!-- THEME STYLES-->
<link href="assets/css/main.min.css" rel="stylesheet" />
<!-- PAGE LEVEL STYLES-->
<style>
.scrollmenu {
	overflow: auto;
	white-space: nowrap;
}

.scrollmenu a {
	display: inline-block;
	color: white;
	text-align: center;
	padding: 14px;
	text-decoration: none;
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
				<h1 class="page-title">BIN Purchase Mapping</h1>
			</div>
			<%
					String binNo="";
					String CropYr="";
					String DateofPur="";
					String DpcCode="";
					String Basis="";
					String juteVariety="";
					String PurchaseDateHeading="";
					List<BinPurchaseMappingDTO> priceList = (List<BinPurchaseMappingDTO>) request.getAttribute("binPurchaseList");	
					for(BinPurchaseMappingDTO priceListing : priceList){
						PurchaseDateHeading = priceListing.getDate_of_purchase();
					}
				%>
			<div class="page-content fade-in-up">
				<div class="">
					<div class="ibox-head">
						<div class="ibox-title"><span style="font-size: 18px;font-weight: bold;">View Purchase Data For : <%=PurchaseDateHeading %></span> </div>
					</div>
					<div class="">
						<div class="scrollmenu">
							<table class="table table-striped table-bordered table-hover"
								id="example-table" cellspacing="0" width="100%">
								<thead>
									<tr>
										<th>Sl.No</th>
										<th>Date of Purchase</th>
										<th>DPC Code</th>
										<th>Basis</th>
										<th>Jute Variety</th>
										<th>Crop Year</th>
										<th>Bin No</th>
										<th>Gross Qty</th>

										<th>Deduction Qty</th>
										<th>Net Qty</th>

										<th>Garsat Rate</th>
										<th>value</th>
								</thead>
								<tbody>
									<% 
									int i= 1;
									for(BinPurchaseMappingDTO priceListing : priceList){
									%>
									<tr>
										<td><%=i%></td>
										<td>
											<% out.print(DateofPur=priceListing.getDate_of_purchase());%>
										</td>
										<td><% out.print(DpcCode=priceListing.getDpc_code());%></td>
										<td><% out.print(Basis=priceListing.getBasis());%></td>
										<td><% out.print(juteVariety=priceListing.getJute_Variety());%></td>
										<td><% out.print(CropYr=priceListing.getCrop_Year());%></td>
										<td><% out.print(binNo=priceListing.getBinNo());%>
										</td>
										<td><%=priceListing.getGrossQty()%></td>
										<td><%=priceListing.getDeductionQty()%></td>
										<td><%=priceListing.getNetQty()%></td>
										<td><%=priceListing.getGarsatRate()%></td>
										<td><%=priceListing.getValue()%></td>
									</tr>
									<% 
									i++; }
							
							%>
								</tbody>

							</table>
							<input type="button" id="calculateTot" value="calculate"><br>
							<br>
							<div style="display:none" class="col-sm-4 form-group">
								<label>Date of Purchase</label> <input id="dateOfPurch"
									class="form-control"  type="text" name="dateOfPurch"
									value="<%=DateofPur %>" placeholder="BIN No" required="">
							</div>
							
							<div style="display:none" class="col-sm-4 form-group">
								<label>DPC Code</label> <input  
									class="form-control"  type="text" id="dpcCode" name="dpcCode"
									value="<%=DpcCode %>" placeholder="BIN No" required="">
							</div>
							<div style="display:none" class="col-sm-4 form-group">
								<label>Basis</label> <input  
									class="form-control"  type="text" id="Basis" name="Basis"
									value="<%=Basis %>" placeholder="BIN No" required="">
							</div>
							
							<div style="display:none" class="col-sm-4 form-group">
								<label>Jute Variety</label> <input  
									class="form-control"  type="text" id="JuteVariety" name="JuteVariety"
									value="<%=juteVariety %>" placeholder="BIN No" required="">
							</div>
							
							
							
							<div style="display:none" class="col-sm-4 form-group">
								<label>Crop Year</label> <input  
									class="form-control" id="CropYr" type="text" name="CropYr"
									value="<%=CropYr %>" placeholder="BIN No" required="">
							</div>
							<div style="display:none" class="col-sm-4 form-group">
								<label>BIN No</label> <input  class="form-control"
									type="text" id="binNo" name="binNo" value="<%=binNo %>"
									placeholder="BIN No" required="">
							</div>
							
							<div class="col-sm-4 form-group">
								<label>Total Net Qty</label> <input id="totNetQty"
									class="form-control" type="text" name="totNetQty"
									placeholder="Total Net Qty" required="">
							</div>
							<div class="col-sm-4 form-group">
								<label>Total Garsat Rate</label> <input id="totGarsat"
									class="form-control" type="text" name="totGarsat"
									placeholder="Total Garsat  Rate" required="">
							</div>
							<div class="col-sm-4 form-group">
								<label>Total value</label> <input id="totValue"
									class="form-control" type="text" name="totValue"
									placeholder="Total value" required="">
							</div>
							<input type="button" id="SubmitToInsert" value="Submit"><br>

						</div>
					</div>
				</div>
			</div>
			<!-- END PAGE CONTENT-->
			<%@ include file="footer.jsp"%>
		</div>
	</div>
	<!-- BEGIN THEME CONFIG PANEL-->

	<!-- END THEME CONFIG PANEL-->
	<!-- BEGIN PAGA BACKDROPS-->
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
	<!-- PAGE LEVEL PLUGINS-->
	<script src="./assets/vendors/DataTables/datatables.min.js"
		type="text/javascript"></script>
	<!-- CORE SCRIPTS-->
	<script src="assets/js/app.min.js" type="text/javascript"></script>
	<script>
    $("#calculateTot").click(function(){
    	//alert('Calculating..');
    	var  binNo=$("#binNo").val();
    	var  CropYr=$("#CropYr").val();
    	var  dateOfPurch=$("#dateOfPurch").val();
    	var dataD;
    	$.ajax({
    		url:"caculateTotalBinPurchase.obj",
    		type : 'GET',
    		data : {
    			binNo : binNo,CropYr:CropYr,dateOfPurch:dateOfPurch
    		},
    		success : function(data) {				 
    			dataD=data.toString()
    				    .replace("[[", "")  //remove the right bracket
    				    .replace("]]", "")  //remove the left bracket
    				    .trim();
    			//alert(dataD);
    			var nameArr = dataD.split(',');
    			 $("#totNetQty").val(nameArr[1]);
    			 $("#totGarsat").val(nameArr[0]);
    			 $("#totValue").val(nameArr[2]);
    			 
    			 
				 
    		}
    	});
    	
    });
    </script>
    <script>
    $("#SubmitToInsert").click(function(){
    	//alert('Hi');
    	var  dateOfPurch=$("#dateOfPurch").val();
    	var  dpcCode=$("#dpcCode").val();
    	var  Basis=$("#Basis").val();    	
    	var  JuteVariety=$("#JuteVariety").val();
    	var  CropYr=$("#CropYr").val();
    	var  binNo=$("#binNo").val();
    	var  totNetQty=$("#totNetQty").val();
    	var  totGarsat=$("#totGarsat").val();
    	var  totValue=$("#totValue").val();
    	$.ajax({
    		url:"InsertIntoTablePurchaseMapping.obj",
    		type : 'GET',
    		data : {
    			dateOfPurch : dateOfPurch,dpcCode:dpcCode,Basis:Basis,JuteVariety:JuteVariety,CropYr:CropYr,binNo:binNo,totNetQty:totNetQty,totGarsat:totGarsat,totValue:totValue
    		},
    		success : function(data) {
    			if (!$.trim(data)){   
    			   alert("if"); //Todo
    			}
    			else{   
    			    alert("Purchase data for "+dateOfPurch+" is Mapped to BIN ");
    			    window.location.href = "fingain.obj";

    			}
    		}
    	});
    	 
    	  
    	
    });
    </script>

</body>

</html>
