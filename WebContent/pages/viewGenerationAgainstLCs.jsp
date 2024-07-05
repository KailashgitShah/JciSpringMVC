<%@page import="com.mashape.unirest.http.options.Option"%>
<%@page import="java.util.List"%>
<%@page import="java.time.LocalDate"%>
<%@page import="java.time.LocalDateTime"%>
<%@page import="com.jci.model.MillRecieptModel"%>
<%@page import="com.jci.model.EntryPaymentDetailsModel"%>
<%@page import="com.jci.model.MillreceiptDto"%>
<%@page import="java.time.format.DateTimeFormatter"%>
<%@page import="com.jci.model.GenerationofDocumentLCsModel"%>
<!DOCTYPE html>
<html lang="en">

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
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<!-- CORE SCRIPTS-->
  
 <style>
.required:after {
	content: " *";
	color: red;
}
#milldetailsTable {
    display: none; 
}
#childTable {
    display: none; 
}
/* CSS classes for the green link */
 .table-cell {
   
     width: 200px;
    height: 10px;
    
} 

#childTable {
    width: 100%; /* Ensure the table takes the full width */
    table-layout: fixed; /* Fix the table layout */
}

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


.colored-cell {
    color: green; 
    
}

 .colored-cell:hover {
    
    color: blue; 
  }
  
  .form-check-input {
        margin-right: 10px; 
        vertical-align: middle; 
    }

.alert {
        padding: 10px;
        margin-bottom: 20px;
        border: 1px solid transparent;
        border-radius: 4px;
        /* Match width and height */
        width: 100%;
        height: 100%;
    }

    .alert-info {
        color: #31708f;
        background-color: #d9edf7;
        border-color: #bce8f1;
    }
</style> 
</head>
<body class="fixed-navbar"  onload="myFunction()" >
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
                <h1 class="page-title">View Generation of Document Against LC</h1>
            </div>
            
            <% 
          
        	List<GenerationofDocumentLCsModel> genrationAgainstLcs = (List<GenerationofDocumentLCsModel>)request.getAttribute("genrationAgainstLcs");
			List<Object[]> fetchMill_Namelc = (List<Object[]>) request.getAttribute("fetchMill_Namelc");  
			String number = (String) request.getAttribute("serialno");  
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
                <div class="row">
                    <div class="col-md-11">
                        <div class="ibox">
                          <span id="flashMessage">${msg}</span>
                            <div class="ibox-body">
                            <div class="scrollmenu">
                       <form action="Generatebankdraftsheet.obj" method="POST">
                           <div class="child-checkbox" id="disableform">
                                 <div class="row">
                                
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
											  <div class="col-sm-2 form-group"  style="display: none;">
												    <label "display:none;" >rowindex </label> <span
													class="text-danger">* </span>&nbsp;  <input
													class="form-control" name="rowindex2"
													id="rowindex2" value="" readonly="readonly">
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
								                        <th></th>
								                    
								                        <th>Bill of Supply no</th>
								                        <th>Bos Date</th>
								                        <th>Invoice value</th>
								                         <th>ChallanNo</th>
								                        <th>ContarctNo</th>
								                        <th>Millcode</th>
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
                                   
                             
                           
                                 
                                             
                                    <div class="row">
                                    
                                           <div class="col-sm-4 form-group">
												<label>Balance Amount</label> <span class="text-danger">*
												</span>&nbsp; <span id="instrumentdate" name="instrumentdate"
													class="text-danger"> </span> <input class="form-control"
													name="instdate" id="instdate"  value="" required>
											</div>
	                                      
												
	                                </div>  
	                                
	                              
                               <div class="container mt-5">
						        <div class="row">
						            <!-- <div class="col-sm-4 form-group">
						                <input type="submit"  name="bankdraft" value="Download BankDraft" class="btn btn-primary btn-block" id="submit1">
						            </div>
						            <div class="col-sm-4 form-group">
						                <input type="submit"  name="Topsheet" value="Download TopSheet" class="btn btn-primary btn-block" id="submit2">
						            </div>
						            <div class="col-sm-4 form-group">
						                <input type="submit" name="BillofExchange" value="Download BillofExchange" class="btn btn-primary btn-block" id="submit3">
						            </div> -->
						            
						            
						            
						            
						                <div class="col-sm-4 form-group">
						                <input type="submit"  name="submit" value="submit" class="btn btn-primary btn-block" id="submit1">
						            </div>
						           
						        </div>
						    </div>

                                </form>
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
    
    
  
 
     <script type="text/javascript">
    
	$(document).ready(function(){
		 $("#submit").click(function(){
		
			  var contractdate = $("#Date_of_Shipment134").val();
			  var instdate = $("#HO_Date1").val();
			  var instdate1 = $("#MR_Date1").val();
			 
			  
			  if(contractdate =="" || instdate =="" || instdate1 =="")
				  {
				    alert("Please select mandatory Fields!");
				  }  
		    });
	 });
	
	
  </script>

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
      

        $('#milldetailsTable tbody').empty();
        $('#milldetailsTable').css('display', 'none');
   
        // First AJAX call
        $.ajax({
            type: 'GET',
            url: 'listofpaymentdetails.obj',
            data: { "contractno": field1Value },
            success: function(data) {

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
                         /*    '<td><div class="table-cell"><input type="hidden" name="supportingdoc[]" value="' + rowData[6] + '">' + rowData[6] + '</div></td>' +
                           */  
                           
                         '<td>' +
                           '<a href="downloadSupportingDocument.obj?filename=' + rowData[6] + '">' +
                               '<button class="btn btn-primary btn-sm" target="_blank" type="button">View Supporting docs</button>' +
                           '</a>' +
                          '</td>'+
                        
                           '<td><div class="table-cell"><input type="hidden" name="autorevolving" value="' + rowData[7] + '">' + rowData[7] + '</div></td>' +
                             
                         
                          
                            '<td><div class="table-cell"><input type="hidden" name="expirydate[]" value="' + rowData[8] + '">' + rowData[8] + '</div></td>' +
                            '<td><div class="table-cell"><input type="hidden" name="lastshipment[]" value="' + rowData[9] + '">' + rowData[9] + '</div></td>' +
                            '<td><div class="table-cell"><input type="hidden" name="paymenttype[]" value="' + rowData[10] + '">' + rowData[10] + '</div></td>' +
                            '<td><div class="table-cell"><input type="hidden" name="paymentduedate[]" value="' + rowData[11] + '">' + rowData[11] + '</div></td>' +
                            '</tr>';
                         

                        $('#milldetailsTable tbody').append(rowHtml);
                        $('#instdate').val(rowData[7]);
                      
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
                const dataArray = JSON.parse(data);
                var idx = 0;
                var sumofInvoiceValue = 0;
                var billofsupplyno = [];
                var challanno, bosdate;
                $('#billofsupllydetails tbody').empty();

                if (dataArray.length > 0) {
                 

                    dataArray.forEach(function(rowData1) {
                        challanno = rowData1[3];
                        bosdate = rowData1[1];

                        // Set autorevolvingAmount once
                       

                        // Construct HTML for table row
                        const rowHtml = '<tr>' +
                        '<td><div class="table-cell"><input type="checkbox" name="selectRow[]" class="invoice-checkbox"></div></td>' +
                          '<td><div class="table-cell"><input type="hidden" name="bosNo[]" value="' + rowData1[0] + '">' + rowData1[0] + '</div></td>' +
                            '<td><div class="table-cell"><input type="hidden" name="bosdate[]" value="' + rowData1[1] + '">' + rowData1[1] + '</div></td>' +
                            '<td><div class="table-cell"><input type="hidden" name="invoicevalue[]" value="' + rowData1[2] + '">' + rowData1[2] + '</div></td>' +
                            '<td><div class="table-cell"><input type="hidden" name="challanno[]" value="' + rowData1[3] + '">' + rowData1[3] + '</div></td>' +
                            '<td><div class="table-cell"><input type="hidden" name="contractNO[]" value="' + rowData1[4] + '">' + rowData1[4] + '</div></td>' +
                            '<td><div class="table-cell"><input type="hidden" name="millcode[]" value="' + rowData1[5] + '">' + rowData1[5] + '</div></td>' +
                            '</tr>';

                        sumofInvoiceValue += parseFloat(rowData1[2]);
                        billofsupplyno[idx] = rowData1[0];
                        idx++;
                        document.getElementById("rowindex2").value = idx;
                        $('#billofsupllydetails tbody').append(rowHtml);
                    });

                    // Function to update the Balance Amount
         function updateBalanceAmount() {
    alert("hjk");
    let autorevolvingAmount = parseFloat(document.getElementById('instdate').value);
    let checkedTotal = 0;
    let selectedRows = [];

    $('.invoice-checkbox:checked').each(function() {
        let invoiceValue = parseFloat($(this).closest('tr').find('input[name="invoicevalue[]"]').val());
        checkedTotal += invoiceValue;

        if (invoiceValue <= autorevolvingAmount) {
            selectedRows.push($(this).closest('tr'));
        }
    });

    let dataToSubmit = [];
    selectedRows.forEach(function(row) {
        let rowData = {
            'bosNo': row.find('input[name="bosNo[]"]').val(),
            'bosdate': row.find('input[name="bosdate[]"]').val(),
            'invoicevalue': row.find('input[name="invoicevalue[]"]').val(),
            'challanno': row.find('input[name="challanno[]"]').val(),
            'contractNO': row.find('input[name="contractNO[]"]').val(),
            'millcode': row.find('input[name="millcode[]"]').val()
            // Add more fields as needed
        };
        dataToSubmit.push(rowData);
    });

    // Display selected data for submission
    console.log(dataToSubmit);

    // Update balance amount field
    let balanceAmount = autorevolvingAmount - checkedTotal;
    $('#instdate').val(balanceAmount.toFixed(2));
    autorevolvingAmount = balanceAmount; // Update the Balance Amount input field
}

// Attach event listener to checkboxes
$('.invoice-checkbox').on('change', function() {
    updateBalanceAmount();
});


                    $('#billofsupllydetails').css('display', 'block');

                    // Convert billofsupplyno array to a string
                    var billofsupplynoString = billofsupplyno.join(',');

                } else {
                    $('#billofsupllydetails').css('display', 'none');
                }
            }
        });


    });
});
</script>
 













<script>
    $(document).ready(function(){
      
        setTimeout(function(){
            $('#flashMessage').fadeOut('slow');
        }, 3000); ded
    });
</script>



		   
    
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
    
    <!-- PAGE LEVEL SCRIPTS-->
</body>
</html>
		