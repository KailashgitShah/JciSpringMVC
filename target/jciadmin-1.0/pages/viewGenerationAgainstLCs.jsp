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
   
     width: 150px;
    height: 10px;
    
} 

#childTable {
    width: 80%; /* Ensure the table takes the full width */
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
			/* String number = (String) request.getAttribute("serialno");  */ 
			String millname="";
			String millcode="";
			String contractNo="";
			String challanno="";
			
			String bosdate="";
		
			String[] rowData3 = new String[10];
			String[] billofsupplyno = new String[10];
			 String billofsupplynoString = String.join(",", billofsupplyno);
		
			float sumofInvoiceValue = 0;
		
		%>
          <div class="page-content fade-in-up">
                <div class="row">
                    <div class="col-md-11">
                        <div class="ibox">
                          <span id="flashMessage">${msg}</span>
                            <div class="ibox-body">
                            <div class="scrollmenu">
                       <form action="Generatebankdraftsheet.obj" method="POST" id="myForm">
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
											
											 <div class="col-sm-4 form-group">
												<label>Balance LC Amount</label> <span class="text-danger">*
												</span>&nbsp; <span id="instrumentdate" name="instrumentdate"
													class="text-danger"> </span> <input class="form-control"
													name="balenceammount" id="instdate"  value="" required readonly="readonly">
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
								                       <!--  <th>Instrument value</th> -->
								                        <th>supporting document</th>
								                        <th>Instrument value</th>
								                      <!--   <th>Auto Revolving ammount</th> -->
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
								<button id="selectAll">Select All</button>
                              <!--   <button id="deselectAll">Deselect All</button> -->
								  
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
                                    
                                          
											     <div class="col-sm-2 form-group" style="display: none;">
												    <label  "display:none; >indexes </label> <span
													class="text-danger">* </span>&nbsp;  <input
													 type="hidden" class="form-control" name="index"
													id="indexses" value="" readonly="readonly">
													 <input
													 type="hidden" class="form-control" name="hideData"
													id="hideData" value="" readonly="readonly">
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
							    <input type="submit" name="submit" value="Submit" class="btn btn-primary btn-block" id="submit12">
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
    
     $(document).ready(function() {
    	    $('#submit12').on('click', function(event) {
    	        var isChecked = $('.invoice-checkbox:checked').length > 0;

    	        if (!isChecked) {
    	            event.preventDefault();
    	            alert("Please select at least one checkbox before submitting.");
    	        }
    	        
    	        var autorevolvingAmount = parseFloat($('#instdate').val());
    	        if (autorevolvingAmount === 0) {
    	            $('#submit12').prop('disabled', true);
    	        } else {
    	            $('#submit12').prop('disabled', false);
    	        }
    	    });
    	});

	
	
  </script>





<script>
    // Reset select element to default value on page load
    document.addEventListener("DOMContentLoaded", function() {
        var selectElement = document.getElementById("millname12");
        selectElement.value = "select"; // Set to the default option value
    });

   
    function formatDate(dateStr) {
        var date = new Date(dateStr);

        if (isNaN(date.getTime())) {
            return dateStr; 
        }

        var day = ("0" + date.getDate()).slice(-2);
        var month = ("0" + (date.getMonth() + 1)).slice(-2);
        var year = date.getFullYear();

        return day + '-' + month + '-' + year;
    }
</script>

<script type="text/javascript">
$(document).ready(function() {
    var record = [];
    var billofsupplyno = [];
    var index = 0;
    var sumofInvoiceValue = 0; // Initialize sumofInvoiceValue
    var autorevolvingAmount = 0;
    var dataToSubmit = [];

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
                    autorevolvingAmount = rowData[7];

                    const rowHtml = '<tr>' +
                        '<td><div class="table-cell"><input type="hidden" name="bank[]" value="' + rowData[0] + '">' + rowData[0] + '</div></td>' +
                        '<td><div class="table-cell"><input type="hidden" name="branch[]" value="' + rowData[1] + '">' + rowData[1] + '</div></td>' +
                        '<td><div class="table-cell"><input type="hidden" name="ifsc[]" value="' + rowData[2] + '">' + rowData[2] + '</div></td>' +
                        '<td><div class="table-cell"><input type="hidden" name="instrumentdate[]" value="' + rowData[3] + '">' + rowData[3] + '</div></td>' +
                        '<td><div class="table-cell"><input type="hidden" name="instrumentnNO[]" value="' + rowData[4] + '">' + rowData[4] + '</div></td>' +
                        /* '<td><div class="table-cell"><input type="hidden" name="instrumentnValue[]" value="' + rowData[5] + '">' + rowData[5] + '</div></td>' + */
                        '<td>' +
                            '<a href="downloadSupportingDocument.obj?filename=' + rowData[6] + '">' +
                                '<button class="btn btn-primary btn-sm" target="_blank" type="button">View Supporting docs</button>' +
                            '</a>' +
                        '</td>' +
                        '<td><div class="table-cell"><input type="hidden" name="autorevolving" value="' + rowData[7] + '">' + rowData[7] + '</div></td>' +
                        '<td><div class="table-cell"><input type="hidden" name="expirydate[]" value="' + formatDate(rowData[8]) + '">' + formatDate(rowData[8]) + '</div></td>' +
                        '<td><div class="table-cell"><input type="hidden" name="lastshipment[]" value="' + formatDate(rowData[9]) + '">' + formatDate(rowData[9]) + '</div></td>' +
                        '<td><div class="table-cell"><input type="hidden" name="paymenttype[]" value="' + rowData[10] + '">' + rowData[10] + '</div></td>' +
                        '<td><div class="table-cell"><input type="hidden" name="paymentduedate[]" value="' + formatDate(rowData[11]) + '">' + formatDate(rowData[11]) + '</div></td>' +
                        '</tr>';

                    $('#milldetailsTable tbody').append(rowHtml);
                });
                $('#milldetailsTable').css('display', 'block');
            } else {
                $('#milldetailsTable').css('display', 'none');
            }
               
                $.ajax({
                    type: 'GET',
                    url: 'balanceamount.obj',
                    data: { "contractno": field1Value },
                    success: function(data) {
                        try {
                            const parsedData = JSON.parse(data);
                          

                            if (parsedData == 0) {
                                $('#instdate').val(autorevolvingAmount);
                                $('#hideData').val(autorevolvingAmount);
                            } else {
                                $('#instdate').val(parsedData);
                                $('#hideData').val(parsedData);
                            }
                        } catch (e) {
                            console.error('Error parsing JSON response:', e);
                            alert('Failed to parse server response.');
                        }
                    },
                    error: function(xhr, status, error) {
                        console.error('AJAX request failed:', status, error);
                        // Handle the error as needed
                    }
                });

                
                
            },
            error: function(xhr, status, error) {
                console.error('AJAX request failed:', status, error);
                // Handle the error as needed
            }
        });

      

        // Second AJAX call
        let selectedRowIndices = []; // Declare selectedRowIndices globally

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
                    dataArray.forEach(function(rowData1, index) {
                        challanno = rowData1[3];
                        bosdate = rowData1[1];

                        // Construct HTML for table row
                        const rowHtml = '<tr>' +
                            '<td><div class="table-cell"><input type="checkbox" id="checkbox_' + index + '" name="selectRow[]" class="invoice-checkbox"></div></td>' +
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

                    $('#billofsupllydetails').css('display', 'block');

                    var billofsupplynoString = billofsupplyno.join(',');

                    // Bind change event for checkboxes
                    $('.invoice-checkbox').on('change', function() {
                    	  if ($(this).is(':checked')) {
                    		 
                    		  let closestRow = $(this).closest('tr');
                              let rowIndex = closestRow.index();
                              updateBalanceAmount(rowIndex);
                          } else {
                        	
                        	  updateBalanceAmount();
                             // updateBalanceAmountForUncheck();
                          }
                    });
                } else {
                    $('#billofsupllydetails').css('display', 'none');
                }
            },
            error: function(xhr, status, error) {
                console.error("Error occurred while fetching data:", error);
            }
        });


        function updateBalanceAmountForUncheck() {
            let autorevolvingAmount1 = parseFloat(document.getElementById('instdate').value);

            console.log(autorevolvingAmount1); // Log the original amount stored in data attribute

            let balanceAmount = autorevolvingAmount;

            // Get the index of unchecked checkbox
            let uncheckedIndex = -1;
            $('.invoice-checkbox').each(function(index) {
                if (!$(this).is(':checked')) {
                    uncheckedIndex = index;
                    return false; // Exit the loop
                }
            });

            if (uncheckedIndex !== -1) {
                // Remove the unchecked index from selectedRowIndices
                selectedRowIndices = selectedRowIndices.filter(index => index !== uncheckedIndex);
            }

            $('.invoice-checkbox:checked').each(function() {
                let closestRow = $(this).closest('tr');
                let invoiceValue = parseFloat(closestRow.find('input[name="invoicevalue[]"]').val());
                balanceAmount += invoiceValue;
            });

            $('#instdate').val(balanceAmount);
            $('#indexses').val(selectedRowIndices.join(','));
        }

        // Ensure the original amount is stored in data attribute
        $('#instdate').data('originalAmount', $('#instdate').val());

    
        
          function updateBalanceAmount(idx) {
        let autorevolvingAmount = parseFloat($("#hideData").val());
        let checkedTotal = 0;
        let selectedRowIndices = [];

        $('.invoice-checkbox:checked').each(function() {
            let closestRow = $(this).closest('tr');
            let rowIndex = closestRow.index();
            let invoiceValue = parseFloat(closestRow.find('input[name="invoicevalue[]"]').val());

         /*    // Check if adding the current invoice value exceeds autorevolvingAmount
            if (checkedTotal + invoiceValue <= autorevolvingAmount) {
                checkedTotal += invoiceValue;
                selectedRowIndices.push(rowIndex);
            } else {
                // If adding the invoice value exceeds autorevolvingAmount, uncheck the checkbox
                let checkbox = closestRow.find('.invoice-checkbox');
                checkbox.prop('checked', false);
            } */
            
            
            checkedTotal += invoiceValue;

         
            if (checkedTotal > autorevolvingAmount) {
         
                let checkbox = closestRow.find('.invoice-checkbox');
                checkbox.prop('checked', false);
                checkedTotal -= invoiceValue; // Adjust checkedTotal
                alert("Balance Amount is less then total invoice value");
            } else {
                
                selectedRowIndices.push(rowIndex);
            }
            
        });

        let balanceAmount = autorevolvingAmount - checkedTotal;
        $('#instdate').val(balanceAmount);
        $('#indexses').val(selectedRowIndices.join(','));
        console.log(selectedRowIndices);
    } 
      
        // Function to update the balance amount when checkboxes are unchecked
        function updateBalanceAmountForUncheck() {
            let autorevolvingAmount = parseFloat(document.getElementById('instdate').value);
            let balanceAmount = autorevolvingAmount;
            let selectedRowIndices = [];

            $('.invoice-checkbox:checked').each(function() {
                let closestRow = $(this).closest('tr');
                let rowIndex = closestRow.index();
                let invoiceValue = parseFloat(closestRow.find('input[name="invoicevalue[]"]').val());
                balanceAmount -= invoiceValue;
                selectedRowIndices.push(rowIndex);
            });

            $('#instdate').val(balanceAmount);
            $('#indexses').val(selectedRowIndices.join(','));
            console.log(selectedRowIndices);
        }

        // "Select All" button click event
        $('#selectAll').on('click', function(event) {
            event.preventDefault(); // Prevent form submission
            $('.invoice-checkbox').each(function() {
                $(this).prop('checked', true);
                updateBalanceAmount();
            });
            
            $('#selectAll').prop('disabled', true);
        });

        // "Deselect All" button click event
      /*   $('#deselectAll').on('click', function(event) {
            event.preventDefault(); // Prevent form submission
            $('.invoice-checkbox').each(function() {
                $(this).prop('checked', false);
            });
            updateBalanceAmountForUncheck();
        }); */


    });
});
</script>

 
<script>
        $(document).ready(function() {
            $('#myForm').on('submit', function(event) {
                // Disable the submit button
                $('#submit12').prop('disabled', true);
                $('#submit12').val('Please Wait Processing...');  

              
            });
        });
    </script>



<script>
    $(document).ready(function(){
      
        setTimeout(function(){
            $('#flashMessage').fadeOut('slow');
        }, 3000);
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
		