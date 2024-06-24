<%@page import="com.jci.model.MillRecieptModel"%>
<%@page import="com.jci.model.EntryPaymentDetailsModel"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.List"%>
<%@page import="java.io.File"%>
<%@page import="com.jci.model.RoleMasterModel"%>
<%@page import="com.jci.model.GenerationofDocumentLCsModel"%>
<%@page import="com.jci.model.ZoneModel"%>
<%@ page import="java.text.SimpleDateFormat" %>
 <%@ page import="org.springframework.web.servlet.support.RequestContextUtils" %>
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
				<h1 class="page-title">View Generation Against LCs list</h1>

			</div>

			<%
			List<GenerationofDocumentLCsModel> genrationAgainstLcs = (List<GenerationofDocumentLCsModel>)request.getAttribute("genrationAgainstLcs");
			List<Object[]> fetchMill_Namelc = (List<Object[]>) request.getAttribute("fetchMill_Namelc");  
			String millname="";
			String millcode="";
			String contractNo="";
			String challanno="";
			
			String bosdate="";
		
			String[] rowData3 = new String[10];
			String[] billofsupplyno = new String[10];
			 String billofsupplynoString = String.join(",", billofsupplyno);
		
			float sumofInvoiceValue = 0;
			
			  System.out.println("challanno: " + challanno);
			    System.out.println("sumofInvoiceValue: " + sumofInvoiceValue);
			    System.out.println("billofsupplynoString: " + billofsupplynoString);
			    System.out.println("bosdate: " + bosdate);
		
			
		%>
		
		
			
		
	    
			
			<div class="page-content fade-in-up">
				<div class="ibox">
					<span>${msg}</span>
					<div class="ibox-body">
					
				
						<div class="scrollmenu">
						
							<div  class ="row">
						<div class="col-sm-4 form-group">
												<label>Mill name.</label> <span class="text-danger">*
												</span>&nbsp; <span id="millname1" name="Millname"
													class="text-danger"> </span> <select name="millname65"
													id="millname12" class="form-control taxtbox" required>

													<option value="select">-Select-</option>
													<%
													for (Object[] row : fetchMill_Namelc) {
														 millname = (String) row[0];  
													     millcode = (String) row[1]; 
													    
													%>
													<option value="<%=millcode%>"><%=millname%></option>
													<%
													}
													%> 
												</select>


											</div>
											
											<div class="col-sm-4 form-group" id="dpc_div"">
												<label>Contract No.</label> <span class="text-danger">*</span>&nbsp;
												<span id="contractno" class="text-danger"></span> <select
													name="fullcontractno" id="contractno12"
													class="form-control taxtbox"
													style="height: = 50; width: 350px;" required>
													<option disabled selected value="">-Select</option>

												</select>
											</div>
											</div>
											
											    <div class="row">
								    <div class="col-sm-10">
								        <div class="table-responsive">
								            <table id="milldetailsTable" class="table table-bordered">
								                <thead class="thead-light">
								                    <tr>
								                        <th>Bank name</th>
								                        <th>Bank Branch</th>
								                        <th>Bank ifsc</th>
								                        <th>Instrument date</th>
								                        <th>Instrument No</th>
								                        <th>Instrument value</th>
								                        <th>supporting document</th>
								                        <th>Auto Revolving ammount</th>
								                        <th>Expiry Date</th>
								                         <th>last Shipment Date</th>
								                        <th>payment type</th>
								                        <th>payment due date</th>
								                      
								                    </tr>
								                </thead>
								                <tbody>
								                    <!-- Dynamically generated rows will be appended here -->
								                </tbody>
								            </table>
								        </div>
								    </div>
								</div>
								
								
								  <div class="row">
								    <div class="col-sm-10">
								        <div class="table-responsive">
								            <table id="billofsupllydetails" class="table table-bordered">
								                <thead class="thead-light">
								                    <tr>
								                        <th>Bill of Supply no</th>
								                        <th>Bos Date</th>
								                        <th>Invoice value</th>
								                     <!--    <th>Download TopSheet</th>
								                        <th>Download bankdraft</th>
								                        <th>Download Billofexchnage</th> -->
								                  
								                      
								                    </tr>
								                </thead>
								                <tbody>
								                    <!-- Dynamically generated rows will be appended here -->
								                </tbody>
								            </table>
								        </div>
								    </div>
								</div>
							<%--  <table
								class="table table-striped table-bordered table-hover tableFixHead"
								id="example-table" cellspacing="0" width="100%">


								<thead>
									<tr>
										<th>Sl.No</th>
										<!-- <th>BOS Date</th> -->
										<th>BOS No</th>
										<th>Boe Date</th>
										<!-- <th>Bos Amt</th>
										<th>Ho DiNo</th>
										<th>Ho DiDate</th> -->
										<th>LC No</th>
										<th>Invoice Value</th>
									<!-- 	<th>Mill Code</th> -->
										<!-- <th>Quantity</th> -->
										 <th>Top Sheet</th>
										 <th>Bank Draft</th>
										<th>Bill Of Exchange</th>
								
										

									</tr>
								</thead>
								<tbody>
									<%
									int i = 1;
									SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
									for (GenerationofDocumentLCsModel  generationofDocumentLCsModel : genrationAgainstLcs) {

										if (i <= 200) {
									%>
									<tr>
										<td><%=i%></td>
										<td><%= generationofDocumentLCsModel.getbOS_Date() %></td>
										<td><%= generationofDocumentLCsModel.getbOS_No() %></td>
										<td><%= generationofDocumentLCsModel.getBoe_Date()%></td>
									 	<td><%= generationofDocumentLCsModel.getBos_Amt() %></td>
										<td><%= generationofDocumentLCsModel.getHo_di_date() %></td>
										<td><%= generationofDocumentLCsModel.getHo_di_No()%></td> 
										<td><%= generationofDocumentLCsModel.getInstrument_no() %></td>
										<td><%= generationofDocumentLCsModel.getIvoice_value()%></td>
										
										 <td>
								            <a href="downloadPDFforbos.obj?filename=<%= generationofDocumentLCsModel.getTopsheetpath() %>"
								               class="btn btn-primary btn-sm" target="_blank"> Download topsheet </a>
								        </td>
								         <td>
								            <a href="downloadPDFforbos.obj?filename=<%= generationofDocumentLCsModel.getBankdrftpath() %>"
								               class="btn btn-primary btn-sm" target="_blank"> Download bankdrft </a>
								        </td> 
								        
								        <td>
								        
								            <a href="downloadPDFforbankDraft.obj?filename=<%= generationofDocumentLCsModel.getMill_code() %>
								            &challanNO=<%= generationofDocumentLCsModel.getChallanono() %>
								            &InvoiceValue=<%= generationofDocumentLCsModel.getIvoice_value() %>
								            &BosNO=<%= generationofDocumentLCsModel.getbOS_No() %>
								            &BosDate=<%= generationofDocumentLCsModel.getbOS_Date() %>"
								               class="btn btn-primary btn-sm" target="_blank"> download bankdrft </a>
								        </td> 
								        
								         <td>
								            <a href="downloadPDFforbos.obj?filename=<%= generationofDocumentLCsModel.getBillofexchangepath() %>"
								               class="btn btn-primary btn-sm" target="_blank"> Download billofexchange </a>
								        </td>
								        
								        
								         <td>
								        
								            <a href="downloadPDFforBillofexchange.obj?challanNO=<%= generationofDocumentLCsModel.getChallanono() %>
								            &InvoiceValue=<%= generationofDocumentLCsModel.getIvoice_value() %>
								            &BosNO=<%= generationofDocumentLCsModel.getbOS_No() %>
								            &BosDate=<%= generationofDocumentLCsModel.getbOS_Date() %>"
								               class="btn btn-primary btn-sm" target="_blank"> download billofexchange </a>
								        </td> 
										
										
										<td><%= generationofDocumentLCsModel.getMill_code() %></td>
										<td><%= generationofDocumentLCsModel.getQuantity() %></td>
										
									

										

										


									</tr>
									<%
									}
									i++;
									}
									%>
								</tbody>

							</table> --%>
							
							
							
						 <!-- 
						 	     <div class="row">
							    <div class="col-sm-2 form-group" id="BankName1">
							        <a href="#" class="btn btn-primary btn-block" onclick="downloadTopsheet()">
							            Download Topsheet
							        </a>
							    </div> -->
							
							<%--    <div class="col-sm-2 form-group" id="BankDraft">
								    <a href="downloadPDFforbankDraft.obj?filename=<%= millcode %>
								            &challanNO=<%= challanno %>
								            &InvoiceValue=<%= sumofInvoiceValue %>
								            &BosNO=<%= billofsupplynoString %>
								            &BosDate=<%= bosdate %>"
								        class="btn btn-primary btn-sm" target="_blank">
								        Download BankDraft
								    </a>
								</div> --%>

							
							  <!--   <div class="col-sm-3 form-group" id="Branch2">
							        <a href="#" class="btn btn-primary btn-block" onclick="downloadBillOfExchange()">
							            Download Bill of Exchange
							        </a>
							    </div>
							   
							</div> -->


						 
						 
						 
						 
						</div>
					</div>
				</div>

			</div>
			<!-- END PAGE CONTENT-->
			<%@ include file="footer.jsp"%>
		</div>
	</div>
	
	
	<script type="text/javascript">
$(document).ready(function() {
	var record=[];
	var billofsupplyno=[];
	var index=0;
	    var sumofInvoiceValue = 0; // Initialize sumofInvoiceValue
	    var autorevolvingammount = 0;

    // Millname change event handler
    $('#millname12').on('change', function() {
        const field2Value = $(this).val();

        $.ajax({
            type: 'GET',
            url: 'millvisecontrcatforaginstLC.obj',
            data: { "millname": field2Value },
            success: function(data) {
                const dataArray = JSON.parse(data);
                const dropdownElement = document.getElementById('contractno12');

                // Clear previous options
                dropdownElement.innerHTML = '';

                // Add the default option
                const selectOption = document.createElement('option');
                selectOption.value = ''; 
                selectOption.textContent = '-Select-';
                dropdownElement.appendChild(selectOption);

                // Populate new options
                dataArray.forEach(function(innerArray) {
                    const option = document.createElement('option');
                    option.textContent = innerArray[0];
                    option.value = innerArray[0];
                    option.setAttribute('data-value1', innerArray[0]); // Value for backend
                    option.setAttribute('data-value2', innerArray[1]);
                    dropdownElement.appendChild(option);
                });
            },
            error: function(xhr, status, error) {
                console.error('AJAX request failed:', status, error);
                // Handle the error as needed
            }
        });
    });

    // Contractno change event handler
    $('#contractno12').on('change', function() {
        const selectedOption = $(this).find(':selected');
        const field2Value = selectedOption.attr('data-value2');
        const field1Value = selectedOption.attr('data-value1');
        contractNo = field1Value;
        alert(field2Value);
        alert(field1Value);

        $('#milldetailsTable tbody').empty();
        $('#milldetailsTable').css('display', 'none');

        // First AJAX call
        $.ajax({
            type: 'GET',
            url: 'listofpaymentdetails.obj',
            data: { "contractno": field1Value },
            success: function(data) {
                alert(data);
                const dataArray = JSON.parse(data);
                $('#milldetailsTable tbody').empty();

                if (dataArray.length > 0) {
                    dataArray.forEach(function(rowData) {
                    	autorevolvingammount=rowData[7];
                    	alert(autorevolvingammount);
                        const rowHtml = '<tr>' +
                            '<td><div class="table-cell"><input type="hidden" name="bank[]" value="' + rowData[0] + '">' + rowData[0] + '</div></td>' +
                            '<td><div class="table-cell"><input type="hidden" name="branch[]" value="' + rowData[1] + '">' + rowData[1] + '</div></td>' +
                            '<td><div class="table-cell"><input type="hidden" name="ifsc[]" value="' + rowData[2] + '">' + rowData[2] + '</div></td>' +
                            '<td><div class="table-cell"><input type="hidden" name="instrumentdate[]" value="' + rowData[3] + '">' + rowData[3] + '</div></td>' +
                            '<td><div class="table-cell"><input type="hidden" name="instrumentnNO[]" value="' + rowData[4] + '">' + rowData[4] + '</div></td>' +
                            '<td><div class="table-cell"><input type="hidden" name="instrumentnValue[]" value="' + rowData[5] + '">' + rowData[5] + '</div></td>' +
                            '<td><div class="table-cell"><input type="hidden" name="supportingdoc[]" value="' + rowData[6] + '">' + rowData[6] + '</div></td>' +
                            '<td><div class="table-cell"><input type="hidden" name="autorevolving[]" value="' + rowData[7] + '">' + rowData[7] + '</div></td>' +
                            '<td><div class="table-cell"><input type="hidden" name="expirydate[]" value="' + rowData[8] + '">' + rowData[8] + '</div></td>' +
                            '<td><div class="table-cell"><input type="hidden" name="lastshipment[]" value="' + rowData[9] + '">' + rowData[9] + '</div></td>' +
                            '<td><div class="table-cell"><input type="hidden" name="paymenttype[]" value="' + rowData[10] + '">' + rowData[10] + '</div></td>' +
                            '<td><div class="table-cell"><input type="hidden" name="paymentduedate[]" value="' + rowData[11] + '">' + rowData[11] + '</div></td>' +
                            '</tr>';
                         

                        $('#milldetailsTable tbody').append(rowHtml);
                    });
                    $('#milldetailsTable').css('display', 'block');
                } else {
                    $('#milldetailsTable').css('display', 'none');
                }
            },
            error: function(xhr, status, error) {
                console.error('AJAX request failed:', status, error);
                // Handle the error as needed
            }
        });

        // Second AJAX call
        $.ajax({
            type: 'GET',
            url: 'listofbillofsupply.obj',
            data: { "contractno": field1Value },
            success: function(data) {
                alert(data);
                const dataArray = JSON.parse(data);
                var idx = 0;
                var sumofInvoiceValue = 0;
                var billofsupplyno = [];
                var challanno, bosdate;

                if (dataArray.length > 0) {
                    dataArray.forEach(function(rowData1) {
                        // Assuming rowData1[0], rowData1[1], rowData1[2], etc. contain the necessary data
                        challanno = rowData1[3];
                        bosdate = rowData1[1];
                        const rowHtml = '<tr>' +
                            '<td><div class="table-cell"><input type="hidden" name="bosNo' + idx + '" value="' + rowData1[0] + '">' + rowData1[0] + '</div></td>' +
                            '<td><div class="table-cell"><input type="hidden" name="branch[]' + idx + '" value="' + rowData1[1] + '">' + rowData1[1] + '</div></td>' +
                            '<td><div class="table-cell"><input type="hidden" name="ifsc[]' + idx + '" value="' + rowData1[2] + '">' + rowData1[2] + '</div></td>' +
                            '</tr>';
                        sumofInvoiceValue += parseFloat(rowData1[2]);
                        billofsupplyno[idx] = rowData1[0];
                        idx++;
                        $('#billofsupllydetails tbody').append(rowHtml);
                    });

                    $('#billofsupllydetails').css('display', 'block');

                    // Convert billofsupplyno array to a string
                    var billofsupplynoString = billofsupplyno.join(',');

                    // Log values to check if they are updated
                    console.log({
                        sumofInvoiceValue: sumofInvoiceValue,
                        challanno: challanno,
                        bosdate: bosdate,
                        billofsupplynoString: billofsupplynoString
                    });

                    alert(challanno);
                    alert(sumofInvoiceValue);
                    alert(billofsupplynoString);
                    alert(bosdate);

                    // Ensure millcode is assigned correctly
                    var millcode = '<%= millcode %>'; // Replace with the correct method of passing millcode from server-side to client-side
                    alert(millcode);

                    // Constructing the download link dynamically
                    const bankDraftHtml = `
                        <div class="col-sm-2 form-group" id="BankDraft">
                            <a href="downloadPDFforbankDraft.obj?filename=${millcode}
                                    &challanNO=${challanno}
                                    &InvoiceValue=${sumofInvoiceValue}
                                    &BosNO=${billofsupplynoString}
                                    &BosDate=${bosdate}"
                                class="btn btn-primary btn-sm" target="_blank">
                                Download BankDraft
                            </a>
                        </div>`;
                    $('#billofsupllydetails').after(bankDraftHtml);

                } else {
                    $('#billofsupllydetails').css('display', 'none');
                }
            }
        });


    });
});
</script>

<script>

function downloadBankDraft(contractno){
	alert("contarctNo  "+contractno)
	
	$.ajax({
        type: 'GET',
        url: 'downloadPDFforbankDraftnew.obj',
        data: { "contractno": contractno },
        success: function(data) {
          alert("data saved..");
        },
        error: function(xhr, status, error) {
            console.error('AJAX request failed:', status, error);
           
        }
    });
}

</script>



 
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
	<!-- PAGE LEVEL SCRIPTS-->
	<script type="text/javascript">
		$(function() {
			$('#example-table').DataTable({

				fixedHeader : true

			//"ajax": './assets/demo/data/table_data.json',
			/*"columns": [
			    { "S": "name" },
			    { "data": "office" },
			    { "data": "extn" },
			    { "data": "start_date" },
			    { "data": "salary" }
			] */
			});
		})
	</script>
</body>

</html>