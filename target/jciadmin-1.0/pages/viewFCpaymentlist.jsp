<%@page import="org.apache.poi.util.SystemOutLogger"%>
<%@page import="com.jci.model.EntryPaymentDetailsModel"%>

<%@page import="java.util.HashMap"%>
<%@page import="java.util.List"%>
<%@page import="java.io.File"%>
<%@page import="com.jci.model.RoleMasterModel"%>
<%@page import="com.jci.model.ZoneModel"%>
<%@page isELIgnored="false"%>



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
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<!-- PLUGINS STYLES-->
<link href="./assets/vendors/DataTables/datatables.min.css"
	rel="stylesheet" />
<!-- THEME STYLES-->
<link href="assets/css/main.min.css" rel="stylesheet" />
<!-- PAGE LEVEL STYLES-->
<script type="text/javascript">
	$(document).ready(function() {
		$("#farmerVerific").DataTable({
			scrollX : true,
			"pageLength" : 50
		});
	});
</script>
<style>
.scrollmenu {
	overflow: scroll;
	white-space: nowrap;
}

.scrollmenu a {
	display: inline-block;
	color: white;
	text-align: center;
	padding: 14px;
	text-decoration: none;
}

.tableFixHead {
	overflow: auto;
	height: 100px;
	width: 240px;
}

.tableFixHead thead th {
	position: sticky;
	top: 0;
	z-index: 1;
}

.tableFixHead tbody th {
	position: sticky;
	left: 0;
}


table {
	border-collapse: collapse;
	width: 100%;
}

th, td {
	padding: 8px 16px;
	white-space: nowrap;
}

th {
	background: #eee;
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
				<h1 class="page-title">View Payment Details List</h1>

			</div>

			<%
			List<EntryPaymentDetailsModel> allUserRegistration = (List<EntryPaymentDetailsModel>)request.getAttribute("allUserRegistration");
	/* 	    String contractNo = (String) request.getAttribute("contractNo");
		    String paymentId = (String) request.getAttribute("paymentId");
		    out.println(contractNo);
		    out.println(paymentId); */
		%>


			<div class="page-content fade-in-up">
				<div class="ibox">
					<span>${msg}</span>
					<div class="ibox-body">
						<div class="scrollmenu">
						
						
						
										   
										
							<table
								class="table table-striped table-bordered table-hover tableFixHead"
								id="example-table" cellspacing="0" width="100%">


								<thead>
									<tr>
										<th>Sl.No</th>
										<th>Contract No.</th>
										<th>Instrument No</th>
										<th>Instrument Date</th>
										<th>IFSC</th>
										<th>Bank</th>
										<th>Branch</th>
										<th>Payment Type</th>
										<th>Instrument Value</th>
										<th>Date of Expiry</th>
										<th>Last Shipment date</th>
										<th>Auto Revolving Amount</th>
									
										<th>Supporting Document</th>


									</tr>
								</thead>
								<tbody>
									<%
									int i = 1;
									for (EntryPaymentDetailsModel  entryPaymentDetailsModel : allUserRegistration) {

										if (i <= 200) {
									%>
									<tr>
										<td><%=i%></td>
										<td><%= entryPaymentDetailsModel.getContractno() %></td>
										<td><%= entryPaymentDetailsModel.getInstrumentno() %></td>
										<td><%= entryPaymentDetailsModel.getInstdate() %></td>
										<td><%= entryPaymentDetailsModel.getIFSC() %></td>
										<td><%= entryPaymentDetailsModel.getBankName() %></td>
										<td><%= entryPaymentDetailsModel.getBranch() %></td>
										<td><%= entryPaymentDetailsModel.getPayment() %></td>
										<td><%= entryPaymentDetailsModel.getInstrumentValue() %></td>
										<td><%= entryPaymentDetailsModel.getDateofexpiry() %></td>
										<td><%= entryPaymentDetailsModel.getDateofship() %></td>
										<td><%= entryPaymentDetailsModel.getAutorevolvingamount() %></td>
										<%-- <td><%= entryPaymentDetailsModel.getQtyAllowed() %></td> --%>
										<td><%= entryPaymentDetailsModel.getSupportingDocument() %></td>
                                        <td>
								            <a href="downloadSupportingDocument.obj?filename=<%= entryPaymentDetailsModel.getSupportingDocument() %>">
								              <!--  class="btn btn-primary btn-sm" target="_blank">View Supporting docs</a> -->
								               <button class="btn btn-primary btn-sm" target="_blank" type="button">View Supporting docs</button>
								        </td>

								


									<td>
									    <a href="issuePaymentDetail.obj?id=<%=entryPaymentDetailsModel.getPayment_id()%>&contno=<%=entryPaymentDetailsModel.getContractno()%>">
									        <button class="btn btn-primary custom-button" type="button">Issue FC</button>
									    </a>
									</td> 
									
						  
									<!-- 	class="btn btn-danger custom-button" -->
										
										 <td>
										    <a   onclick="rejectAndNavigate('<%=entryPaymentDetailsModel.getContractno()%>', '<%=entryPaymentDetailsModel.getPayment_id()%>')">
										        <button class="btn btn-danger custom-button" type="button">Reject</button>
										    </a>
										</td> 


									</tr>
									<%
										}
									   i++;
										} 
										%>
									
										
									
									
								</tbody>

							</table>
							
						
										
							<div class="modal fade" id="rejectModal" tabindex="-1"
								role="dialog" aria-labelledby="rejectModalLabel"
								aria-hidden="true">
								<div class="modal-dialog" role="document">
									<div class="modal-content">
										<div class="modal-header">
											<h5 class="modal-title" id="rejectModalLabel">Reject
												Confirmation</h5>
											<button type="button" class="close" data-dismiss="modal"
												aria-label="Close">
												<span aria-hidden="true">&times;</span>
											</button>
										</div>
										<div class="modal-body">
											<p>Are you sure you want to reject this record?</p>
											<label for="remarks">Remarks:</label> <input
												class="form-control" type="text" id="remarks" name="remarks">
										</div>
										<div class="modal-footer">
											<button type="button" class="btn btn-secondary"
												data-dismiss="modal">Close</button>
											<button type="button" class="btn btn-danger"
												 id="rejectModalButton" onclick="rejectRecord()">Yes, Reject</button>

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


 
<!-- <script>
    function openRejectModal(contractNo) {
     
        $('#rejectModalButton').data('contractNo', contractNo);
        $('#rejectModal').modal('show');
    }

    function closeRejectModal() {
        $('#rejectModal').modal('hide');
    }

    function rejectRecord() {
        var remarks = $('#remarks').val().trim();
        var contractNo = $('#rejectModalButton').data('contractNo');
       
        if (remarks === "") {
          
            return;
        }
        $('#rejectModal').one('hidden.bs.modal', function (e) {
            $.ajax({
                type: 'GET',
                url: 'saveRemarks.obj',
                data: {
                    "remarks": remarks,
                    "con_no": contractNo
                },
                success: function (data) {
                   
                    location.reload();
                },
            });
        }).modal('hide');
    }
</script>  -->
 
<script>
    function openRejectModal(contractNo) {
        $('#rejectModalButton').data('contractNo', contractNo);
        $('#rejectModal').modal('show');
    }

    function closeRejectModal() {
        $('#rejectModal').modal('hide');
    }

    function rejectAndNavigate(contractNo, paymentId) {
        openRejectModal(contractNo)
       alert("KKKKK");
        $('#rejectModalButton').off('click').on('click', function () {
            var remarks = $('#remarks').val().trim();

            if (remarks === "") {
                return;
            }
            $.ajax({
                type: 'POST',
                url: 'saveRemarks.obj',
                data: {
                    "remarks": remarks,
                    "con_no": contractNo,
                    "id": paymentId
                },
                success: function (data) {
                    var responseData = JSON.parse(data);
						 if (responseData.redirect) {
                        window.location.href = responseData.redirect;
                    } else {
                        
                    }
                },
                error: function (error) {
                    console.error('Ajax error:', error);
                }
            });


            closeRejectModal(); 
        });
    }
</script>







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
	<!-- PAGE LEVEL SCRIPTS-->
	<script type="text/javascript">
		$(function() {
			$('#example-table').DataTable({

				fixedHeader : true

			
			});
		})
	</script>
</body>

</html>