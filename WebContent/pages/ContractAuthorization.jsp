<%@page import="java.util.ArrayList"%>
<%@page import="com.jci.model.Contractgeneration"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.List"%>
<%@page import="java.net.URLEncoder"%>
<%@ page import="javax.servlet.http.HttpServletRequest"%>

<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width initial-scale=1.0">
<title>JCI | CMS</title>
  <link href="./assets/vendors/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet" />
    <link href="./assets/vendors/font-awesome/css/font-awesome.min.css" rel="stylesheet" />
    <link href="./assets/vendors/themify-icons/css/themify-icons.css" rel="stylesheet" />
    <!-- PLUGINS STYLES-->
    <link href="./assets/vendors/DataTables/datatables.min.css" rel="stylesheet" />
    <!-- THEME STYLES-->
    <link href="assets/css/main.min.css" rel="stylesheet" />
    
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

<style>
.scrollmenu {
	overflow: auto;
	white-space: nowrap;
}

/* .scrollmenu a {
	display: inline-block;
	color: white;
	text-align: center;
	padding: 14px;
	text-decoration: none;
}  */
</style>
</head>

<%
String contractNos ="";
%>

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
				<h1 class="page-title">Contract Authorization</h1>
			</div>
			<%
			List<Contractgeneration> contract = (List<Contractgeneration>) request.getAttribute("contracts");
			%>
			<div class="page-content fade-in-up">
				<div class="ibox">
					<div class="ibox-head">
						<span id="flashMessage">${msg}</span>
					</div>

					<div class="ibox-body">
						<div class="scrollmenu">
						
						<% if(contract.size() == 0){ %>
						<h2 class = "text-center">No Contract Available for the Authorization</h2>
						
						<%} else{ %>
						
							<table id="example-table"
								class="table table-striped table-bordered table-hover">
								<thead>
									<tr>
										<th>SN.</th>
										<th>Mill Code</th>
										<th>Mill Name</th>
										<th>Allocated Qty(Qtls.)</th>
										<th>Jute Value</th>
										<th>Contract No</th>
										<th>PCSO Date</th>
										<th>Delivery Period</th>
										<th></th>
										<th></th>
									</tr>

								</thead>
								<tbody>
									<%
									int i = 1;
									for (Contractgeneration requestEl : contract) {
										String fullFolder = requestEl.getContract_identification_no() + "\\" + requestEl.getContract_acceptance_doc();
										//String date=new SimpleDateFormat("dd-MM-yyyy").format(requestEl.getCreation_date());
										String encodedFilePath = URLEncoder.encode(fullFolder, "UTF-8");
										contractNos += requestEl.getContract_no() + ",";
									%>
									<tr>

										<td><%=i%></td>
										<td><%=requestEl.getMill_code()%></td>
										<td><%=requestEl.getMill_name()%></td>
										<td><%=requestEl.getMill_qty()%></td>
										<td><%=requestEl.getJute_value()%></td>
										<td><%=requestEl.getContract_no()%></td>
										<td><%=requestEl.getPcso_date()%></td>
										<td><%=requestEl.getDelivery_type()%></td>
										<td class="text-center"><a target='_blank'
											href="downloadUnAuthContractLetter.obj?imagePath=<%=encodedFilePath%>"
											class='btn btn-success'><i class='fa fa-download'
												aria-hidden='true'></i></a></td>

										<td><button class="btn btn-outline-warning selectId"
												onclick="Authorize('<%=requestEl.getContract_no()%>')">Authorize</button></td>
									</tr>
									<%
									i++;
									}
									%>
									<tr>
										<td></td>
										<td></td>
										<td></td>
										<td></td>
										<td></td>
										<td></td>
										<td></td>
										<td></td>
										<td><button class="btn btn-info" id="selectAllBtn"
												onclick="selectAll()">Select All</button></td>
										<td><button class="btn btn-success d-none"
												id="authoriseAllBtn" onclick="authorizedAll()">Authorize
												All</button></td>
									</tr>

								</tbody>

							</table>
							
							<%} %>

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
	<script type="text/javascript">
		setTimeout(function() {
			document.getElementById('flashMessage').style.display = 'none';
		}, 1500);
	</script>
	<script>
		
	var selectAllStatus = 1;
		//send mail funtion
		function Authorize(contractNo) {
			
		if(	!confirm("Do you want to Authorize this contract")){
			return false;
		}
			
				$.ajax({
					url : "contractAuthorizationByIdnNo.obj",
					type : "GET",
					data : {
						"contractNo" : contractNo
					},
					success : function(result) {
						location.reload();
						//window.location.href = "entryofpcso.obj";
					}
				})
			} 
		
		//select all functinality
	
		function selectAll(){
			let i = 1;
			if(selectAllStatus){
				$(".selectId").attr('disabled' , 'disabled');
				$(".selectId").removeClass("btn-outline-warning");
				$("#authoriseAllBtn").removeClass("d-none");
				$("#authoriseAllBtn").addClass("d-block");
				document.getElementById("selectAllBtn").innerHTML = "Deselect";
				console.log(i++);
			}
		
			else {
				$(".selectId").removeAttr("disabled" , false);
				$(".selectId").addClass("btn-outline-warning");
				$("#authoriseAllBtn").removeClass("d-block");
				$("#authoriseAllBtn").addClass("d-none");
				document.getElementById("selectAllBtn").innerHTML = "Select All";
				
			}
			selectAllStatus = !selectAllStatus;
		}
		
		function authorizedAll(){
			
			if(	!confirm("Do you want to Authorize All the contracts together..")){
				return false;
			}
				
			
			var allContractNos = '<%=contractNos%>';

			
			$.ajax({
				url : "contractAuthorizationByIdnNo.obj",
				type : "GET",
				data : {
					"contractNo" : allContractNos
				},
				success : function(result) {
					location.reload();
				}
			})
		
			
		}
	</script>

 <script src="./assets/vendors/jquery/dist/jquery.min.js" type="text/javascript"></script>
    <script src="./assets/vendors/popper.js/dist/umd/popper.min.js" type="text/javascript"></script>
    <script src="./assets/vendors/bootstrap/dist/js/bootstrap.min.js" type="text/javascript"></script>
    <script src="./assets/vendors/metisMenu/dist/metisMenu.min.js" type="text/javascript"></script>
    <script src="./assets/vendors/jquery-slimscroll/jquery.slimscroll.min.js" type="text/javascript"></script>
    <!-- PAGE LEVEL PLUGINS-->
    <script src="./assets/vendors/DataTables/datatables.min.js" type="text/javascript"></script>
    <!-- CORE SCRIPTS-->
    <script src="assets/js/app.min.js" type="text/javascript"></script>
    
     <script type="text/javascript">
        $(function() {
            $('#example-table').DataTable({
                pageLength: 20,
                //"ajax": './assets/demo/data/table_data.json',
                /*"columns": [
                    { "S": "name" },
                    { "data": "office" },
                    { "data": "extn" },
                    { "data": "start_date" },
                    { "data": "salary" }
                ]*/
            });
        })
    </script>
</body>

</html>










