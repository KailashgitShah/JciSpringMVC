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
 <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
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
				<h1 class="page-title">View BIN Records</h1>
			</div>
			<%
				 
					List<BinListFromDbDTO> priceList = (List<BinListFromDbDTO>) request.getAttribute("binPurchaseList");	
					 
				%>
			<div class="page-content fade-in-up">
				<div class="">
					<div class="ibox-head">
						
					</div>
					<div class="">
						<div class="scrollmenu">
							<table class="table table-striped table-bordered table-hover"
								id="example-table" cellspacing="0" width="100%">
								<thead>
									<tr>
										<th>Sl.No</th>
										<th>Total Value</th>
										<th>Total NetQty</th>
										<th>Total Garset</th>
										<th>Bin No</th>
										<th>Crop year</th>
										<th>Fin Gain</th>
										<th>Weight Gain</th>
										 
								</thead>
								<tbody>
									<% 
									int i= 1;
									for(BinListFromDbDTO priceListing : priceList){
									%>
									<tr>
										<td><%=i%></td>
										 
										<td><%=priceListing.getTotalValue()%></td>
										<td><%=priceListing.getTotalNetQty()%></td>
										<td><%=priceListing.getTotalGarset()%></td>
										<td><%=priceListing.getBinNO()%></td>
										<td><%=priceListing.getCrop_Year()%></td>
										<td><%=priceListing.getFinGain()%></td>
										<td><%=priceListing.getWeightGain()%></td>
										 
									</tr>
									<% 
									i++; }
							
							%>
								</tbody>

							</table>
							 

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
    	alert('Calculating..');
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
    			    //Todo
    			}
    			else{   
    			    alert("Purchase data for "+dateOfPurch+" is Mapped to BIN ");
    			    //window.location.href = "binPurchasemapping.obj";

    			}
    		}
    	});
    	 
    	  
    	
    });
    </script>

</body>

</html>
