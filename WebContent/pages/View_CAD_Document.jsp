<%@ page import="java.util.Date" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@page import="org.apache.poi.util.SystemOutLogger"%>
<%@page import="com.jci.model.EntryPaymentDetailsModel"%>

<%@page import="java.util.HashMap"%>
<%@page import="com.jci.model.CashDocumentModel"%>
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
.warning-background {
    background-color: #3498DB; /* Yellow as warning */
    padding: 10px;
    display: inline-block;
    cursor: pointer;
    color: white;
    font-weight: bold;
}

.primary-background {
    background-color: #007bff; /* Blue as primary */
}

</style>
<style>
.custom-label {
    font-size: 20px; /* Adjust the font size as needed */
    text-decoration: underline; /* Underline the text */
    font-weight: bold; /* Make the text bold */
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
                          <h1 class="page-title">View Cash against dispatch Document</h1>

                    </div>

                    <%
                    List<CashDocumentModel> allUserRegistration = (List<CashDocumentModel>)request.getAttribute("genrationcashDocument");
                    List<Object[]> fetchMill_Name =     (List<Object[]>) request.getAttribute("fetchMill_Name");  
                    String millname="";
                    String millcode="";
                    
       
             %>
                  <div class="page-content fade-in-up">
                <div class="ibox">
                    <div class="ibox-head">
                    <span>${msg}</span>
                        <div class="ibox-title"></div>
                    </div>
                    <div class="ibox-body">
                      <!-- <div class="scrollmenu"> -->
                        
<<<<<<< HEAD
                         <form id="myForm" action="savecashAgainstDispatchDocument.obj" method="POST">
=======
                         <form  id = "myForm" action="savecashAgainstDispatchDocument.obj" method="POST">
>>>>>>> 09f85224a8d7417eacbc820c5c61559fc3c8fff4
                      
                                       <div  class ="row">
                                                        <div class="col-sm-3 form-group">
                                                                               <label>Mill name.</label> <span class="text-danger">*
                                                                               </span>&nbsp; <span id="millname1" name="Millname"
                                                                                     class="text-danger"> </span> <select name="millname65"
                                                                                     id="millname12"  class="form-control taxtbox" required>

                                                                                     <option value="select">-Select-</option>
                                                                                     <%
                                                                                     for (Object[] row : fetchMill_Name) {
                                                                                            millname = (String) row[0];  
                                                                                          millcode = (String) row[1]; 
                                                                                         
                                                                                     %>
                                                                                     <option value="<%=millcode%>"><%=millname%></option>
                                                                                     <%
                                                                                     }
                                                                                     %> 
                                                                               </select>


                                                                        </div>
                                                                        
                                                                        <div class="col-sm-3 form-group" id="dpc_div">
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
                                                                    <div class="col-sm-10 form-group">
                                                                    <label>Balance Value.</label>
                                                                    <div>
                                                                     <input type="" id="balanceAmount" name="balanceAmount" ReadOnly>
                                                                     </div>
                                                                    </div>
                                                                  </div>      
                                                                  
                                              
                                          
                                                                        <div class="row">
                                                                    <div class="col-sm-100 form-group"></div>
                                                                  </div>
                                                                  <div class="row">
                                                                    <div class="col-sm-100 form-group"></div>
                                                                  </div>
                                                              <div class="row">
                                                                        <div class="col-sm-10 text-center"> <!-- Added 'text-center' class for center alignment -->
                                                                       <input  value="PAYMENT DETAILS" class="btn btn-secondary btn-block" >
                                                                        </div>
                                                                        </div>
                                                                       <div class="row"> </div>
                                                                        
                                                                
                                                                  <div class="row">
                                                                    <div class="col-sm-20 form-group"></div>
                                                                  </div>      
                                                    <div class="row">
                                                        <div class="col-sm-10">
                                                           <div class="table-responsive"> 
                                                                <table id="milldetailsTable" class="table table-bordered">
                                                                    <thead class="thead-light">
                                                                        <tr>
                                                                         <th>payment type</th>
                                                                          <th>Instrument No</th>
                                                                          <th>Instrument date</th>
                                                                           <th>Instrument value</th>
                                                                            <th>Bank name</th>
                                                                            <th>Bank Branch</th>
                                                                            <th>Bank ifsc</th>
                                                                            <th>Payment Document</th>
                                                                            <th>Contract Document</th>
                                                                           
                                                                        </tr>
                                                                    </thead>
                                                                    <tbody>
                                                                        <!-- Dynamically generated rows will be appended here -->
                                                                      
                                                                    </tbody>
                                                                </table>
                                                            </div>
                                                        </div>
                                                    
                                                     
                                                     
                                                                        
                                                    <div class="row">
                                                                    <div class="col-sm-500 form-group"></div>
                                                                  </div>
                                                                  <div class="row">
                                                                    <div class="col-sm-500 form-group"></div>
                                                                  </div>
                                                                    <div class="row">
                                                                    <div class="col-sm-500 form-group"></div>
                                                                  </div>
                                                                  
                                                                   
                                    <div class="col-sm-10 text-center">
                                      <!--  <input  value="DETAILS OF GENERATED TOPSHEET" class="btn btn-secondary btn-block" > -->
                                                                            </div>
                                                                        </div>
                                                                        
                                                                        <div class="row">
                                                                    <div class="col-sm-20 form-group"></div>
                                                                  </div>
                                                               
                                                    
                                                    <div class="row">
                                                                    <div class="col-sm-500 form-group"></div>
                                                                  </div>
                                                                  <div class="row">
                                                                    <div class="col-sm-500 form-group"></div>
                                                                  </div>
                                                                    <div class="row">
                                                                    <div class="col-sm-500 form-group"></div>
                                                                  </div>
                                                                  
                                                                  <div class ="row"> 
                                    <div class="col-sm-10 text-center">
                                       <input  value="DETAILS OF PENDING BILL OF SUPPLY / DEMAND NOTE" class="btn btn-secondary btn-block" >
                                                                            </div>
                                                                        </div>
                                                                        
                                                                        <div class="row">
                                                                    <div class="col-sm-20 form-group"></div>
                                                                  </div>
                                                         
                                                                
                                                        <div class="row">
                                                        <div class="col-sm-10">
                                                         <div id="controlBox" class="warning-background">
                                                                                   <label onclick="selectAllCheckboxes()">Select All</label>
                                                                               </div>
                                                                    </div>
                                                                     <div class="col-sm-10"></div>
                                                        <div class="col-sm-10">
                                                            <div class="table-responsive">
                                                                <table id="billofsupllydetails" class="table table-bordered">
                                                                    <thead class="thead-light">
                                                                    <!-- <label onclick="selectAllCheckboxes()">Select All</label>  -->
                                                                  <!--   <div id="controlBox" class="warning-background">
                                                                                   <label onclick="selectAllCheckboxes()">Select All</label>
                                                                               </div> -->
                                                                    
                                                                        <tr>
                                                                        <th>Check Box</th>
                                                                       
                                                                            <th>Bill of Supply no</th>
                                                                            <th>Bos Date</th>
                                                                             <th>Invoice value</th>
                                                                            
                                                                        </tr>
                                                                    </thead>
                                                                    <tbody>
                                                                        <!-- Dynamically generated rows will be appended here -->
                                                                    </tbody>
                                                                </table>
                                                            </div>
                                                        </div>
                                                    </div>
                                                    </div>
                                                       <div class="row">
                                       <div class="col-sm-4 form-group">
                                       <input type="hidden" id="numRows" name="rows">
                                       
                                       
                                       </div>
                                       <div class="row">
                   <div class="col-sm-14 form-group">
                    <div style="flex-grow: 1;"></div> <!-- This creates space to push the button to the bottom -->
                   <input type="submit" value="Submit" class="btn btn-primary" id="submit"  onclick="disableSubmit(event)">
                   </div>
                   </div>
                                       
                                 </form>
                
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
    
    
     <script>
        $(document).ready(function() {
            $('#myForm').on('submit', function(event) {
                // Disable the submit button
                $('#submit').prop('disabled', true);
                $('#submit').val('Please Wait Processing...');  

              
            });
        });
    </script>
    
 
    
    <!-- END PAGA BACKDROPS-->
    <!-- CORE PLUGINS-->

<script>
        $(document).ready(function() {
            $('#myForm').on('submit', function(event) {
                // Disable the submit button
                $('#submit').prop('disabled', true);
                $('#submit').val('Please Wait Processing...');  

              
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
            url: 'contrcatforCahAginstDispatchDocument.obj',
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
                    option.textContent = innerArray;
                    option.value = innerArray;
                    option.setAttribute('data-value1', innerArray); // Value for backend
                   /*  option.setAttribute('data-value2', innerArray[1]); */
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
        /* alert(field2Value);
        alert(field1Value); */

        $('#milldetailsTable tbody').empty();
        $('#milldetailsTable').css('display', 'none');

        // First AJAX call
        $.ajax({
            type: 'GET',
            url: 'listofpaymentdetails1.obj',
            data: { "contractno": field1Value },
            success: function(data) {
              // alert(data);
                const dataArray = JSON.parse(data);
                $('#milldetailsTable tbody').empty();

                if (dataArray.length > 0) {
                    dataArray.forEach(function(rowData) {
                          /* autorevolvingammount=rowData[7];
                          alert(rowData[12])
                          alert(rowData[6]) */
                          //alert(autorevolvingammount);
                          //alert(rowData[6])
                        const rowHtml = '<tr>' +
                        '<td><div class="table-cell"><input type="hidden" name="paymenttype[]" value="' + rowData[10] + '">' + rowData[10] + '</div></td>' +
                        '<td><div class="table-cell"><input type="hidden" name="instrumentnNO[]" value="' + rowData[4] + '">' + rowData[4] + '</div></td>' +
                        '<td><div class="table-cell"><input type="hidden" name="instrumentdate[]" value="' + rowData[3] + '">' + rowData[3] + '</div></td>' +
                        '<td><div class="table-cell"><input type="hidden" name="instrumentnValue[]" value="' + rowData[5] + '">' + rowData[5] + '</div></td>' +
                       '<td><div class="table-cell"><input type="hidden" name="bank[]" value="' + rowData[0] + '">' + rowData[0] + '</div></td>' +
                       '<td><div class="table-cell"><input type="hidden" name="branch[]" value="' + rowData[1] + '">' + rowData[1] + '</div></td>' +
                       '<td><div class="table-cell"><input type="hidden" name="ifsc[]" value="' + rowData[2] + '">' + rowData[2] + '</div></td>' +
                     '<td><a href="downloadSupportingDocumentenPaymentArrangement.obj?filename=' + rowData[6] + '" class="btn btn-primary" target="_blank"> View Document</a></button></td>'+
                     '<td><a href=downloadSupportingDocumententContract.obj?filename=' + rowData[12] + ' class="btn btn-primary" target="_blank"> View Document</a></button></td>'
                    
                 
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
        /* second ajax */
        $.ajax({
            type: 'GET',
            url: 'balanceAmount.obj',
            data: { "contractno": field1Value },
            success: function(data) {
             $('#balanceAmount').val(data);
          //  alert(data)
            },
            error: function(xhr, status, error) {
                console.error('AJAX request failed:', status, error);
                // Handle the error as needed
            }
        });

        
                 /* third ajax */
     
       $.ajax({
           type: 'GET',
           url: 'listofbillofsupplyNonLC.obj',
           data: { "contractno": field1Value },
           success: function(data) {
              // alert(data +"bos");
                $('#billofsupllydetails tbody').empty();
               const dataArray = JSON.parse(data);
               var idx = 0;
             var sumofInvoiceValue = 0;
              var billofsupplyno = [];
               var challanno, bosdate;
               
              var num_of_rows = dataArray.length;
               $('#numRows').val(num_of_rows);
             //  alert(num_of_rows +"hhhhhhhh")

               if (dataArray.length > 0) {
                    
                   dataArray.forEach(function(rowData1) {
                       // Assuming rowData1[0], rowData1[1], rowData1[2], etc. contain the necessary data
                      // alert(idx)
                       challanno = rowData1[3];
                       bosdate = rowData1[1];
                       const rowHtml = '<tr>' +
                           '<td><input type="checkbox" onclick="myFunction(this)" id="checking'+idx+'" class="row-checkbox" name="rowCheckbox'+idx+'" value="0"></td>' +
                           '<td><div class="table-cell"><input type="hidden" name="bosNo1[]" value="'+rowData1[0]+'">' + rowData1[0] + '</div></td>' +
                           '<td><div class="table-cell"><input type="hidden" name="bosDate1[]" value="'+ rowData1[1] +'">' + rowData1[1] + '</div></td>' +
                           '<td><div class="table-cell"><input type="hidden" name="invoiceValue1[]" value="'+ rowData1[2] +'">' + rowData1[2] + '</div></td>' +
                           '<td><div class="table-cell"><input type="hidden" name="challan[]" value="'+ rowData1[3] +'"></div></td>' +
                           '<td><div class="table-cell"><input type="hidden" name="millcode[]" value="'+ rowData1[4] +'"></div></td>' +
                           '<td><div class="table-cell"><input type="hidden" name="unit_name[]" value="'+ rowData1[5] +'"></div></td>' +
                           '<td><div class="table-cell"><input type="hidden" name="unit_address1[]" value="'+ rowData1[6] +'"></div></td>' +
                           '<td><div class="table-cell"><input type="hidden" name="Contract_identification_no[]" value="'+ rowData1[7] +'"></div></td>' +
                           '<td><div class="table-cell"><input type="hidden" name="Contract_no[]" value="'+ rowData1[8] +'"></div></td>' +
                           '<td><div class="table-cell"><input type="hidden" name="Contract_date[]" value="'+ rowData1[9] +'"></div></td>' +
                           '<td><div class="table-cell"><input type="hidden" name="CropYear[]" value="'+ rowData1[10] +'"></div></td>' +
                           '<td><div class="table-cell"><input type="hidden" name="hodiNo[]" value="'+ rowData1[11] +'"></div></td>' +
                           '<td><div class="table-cell"><input type="hidden" name="hodiDate[]" value="'+ rowData1[12] +'"></div></td>' +
                           '</tr>';
                       sumofInvoiceValue += parseFloat(rowData1[2]);
                       billofsupplyno[idx] = rowData1[0];
                       idx++;
                       $('#billofsupllydetails tbody').append(rowHtml);
                   });

                  
               } else {
                   
               }
           }
       });
     
   
        
    

    });
});


function selectAllCheckboxes() {
    var confirmed = confirm("Are you sure you want to select all?");
    if (confirmed) {
      $('input.row-checkbox').prop('checked', true); // Check all checkboxes
      updateCheckboxValues();
    }
  }
  
  // Function to update hidden input values based on checkbox state
  function updateCheckboxValues() {
    $('input.row-checkbox').each(function() {
      if ($(this).prop('checked')) {
        $(this).val(1); // Set value to 1 if checked
      } else {
        $(this).val(0); // Set value to 0 if unchecked
      }
    });
  }
function myFunction(checking,idx) {
       
    if (!checking.checked) {
        $(checking).val(0);
       // alert("no" +  $(checking).val(0);)
      
    } else {
        $(checking).val(1);
       // alert("yes" +  $(checking).val(1);)
    } 
}   

function myFunction(checking) {
    // Handle checkbox change
    if (checking.checked) {
        $(checking).val(1);
    } else {
        $(checking).val(0);
    }
    calculateSum(); // Recalculate the sum whenever a checkbox is changed
}

// Function to calculate the sum of invoice values for checked checkboxes
function calculateSum() {
    let sum = 0;
    $('input.row-checkbox:checked').each(function() {
        const row = $(this).closest('tr');
        const invoiceValue = parseFloat(row.find('input[name="invoiceValue1[]"]').val());
        sum += invoiceValue;
    });
    $('#sumOfInvoiceValue').text('Total Invoice Value: ' + sum.toFixed(2)); // Display the sum in an element with id 'sumOfInvoiceValue'
}

$('#submit').click(function(event) {
    // Call calculateSum to make sure the sum is up to date
    calculateSum();
    
    // Retrieve the balance amount from the input field
    const balanceAmount = parseFloat($('#balanceAmount').val()) || 0;
    
    // Calculate the total of checked invoice values
    const total = $('input.row-checkbox:checked').map(function() {
        const row = $(this).closest('tr');
        return parseFloat(row.find('input[name="invoiceValue1[]"]').val());
    }).get().reduce((acc, value) => acc + value, 0);
    
    // Calculate the remaining balance
    const remainingBalance = balanceAmount - total;
    
    // Check if the remaining balance is negative
    if (remainingBalance < 0) {
        // Show an alert with the remaining balance
        alert(' Your Availabe Balance Amount is: '+ balanceAmount + ' And Sum Of All Your Invoice Value is:  '+ total + '\nPlease review the selected invoices value  so that Total Invoice Value Should not Exceed the  Balance Value.');
        // Prevent the form submission
        event.preventDefault();
    } else {
        // Allow the form submission
        // You might also want to add any form submission logic here
    }
});


  
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
    <!-- PAGE LEVEL SCRIPTS-->
    <script type="text/javascript">
        $(function() {
            $('#example-table').DataTable({
                pageLength: 10,
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



























