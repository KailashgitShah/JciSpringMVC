<%@page import="org.apache.poi.util.SystemOutLogger"%>
<%@page import="com.jci.model.Jciclaim_NominationModel"%>
<%@page import="java.util.List"%>
<%@page import="java.time.LocalDate"%>
<%@page import="java.time.LocalDateTime"%>
<%@page import="java.time.format.DateTimeFormatter"%>
<%@page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

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
<!-- THEME STYLES-->
<link href="assets/css/main.min.css" rel="stylesheet" />
<!-- PAGE LEVEL STYLES-->
<script
src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<link rel="stylesheet"
href="//code.jquery.com/ui/1.13.2/themes/base/jquery-ui.css">
<link rel="stylesheet" href="/resources/demos/style.css">
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
<script src="https://code.jquery.com/ui/1.13.2/jquery-ui.js"></script>
<script
src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.5.0/js/bootstrap-datepicker.js"></script>
<script
src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script
src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<!-- CORE SCRIPTS-->


<style>
.required:after {
      content: " *";
      color: red;
}

 .input-container input[type="text"] {
     background-color: #E9ECEF; /* Set the background color of the input field */
     border:  1px solid rgba(0,0,0,.15);  /* Optional: Remove border for a clean look */
    
     padding :1px 5px 1px 5px;
     width:200px;
  
     
    }

   #milldetailsTable {
    border-width: 1px; /* Set the border width to 1 pixel */
    border-style: solid; /* Use solid border style */
    border-color: #ccc; /* Set border color (e.g., light gray) */
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
                      <h1 class="page-title">Nomination of Officials for Claim
                            Settlement</h1>
                 </div>
                 

           
                 <div class="page-content fade-in-up">
                      <div class="row">
                            <div class="col-md-11">
                                 <div class="ibox">
                                       <span>${msg}</span>
                                       <div class="ibox-body">
                                            <form action="savenominal.obj" method="POST">
                                                  <div class="row">

                                                        <div class="col-sm-4 form-group">
                                                             <label> Mill</label> <span class="text-danger">* </span> <select
                                                                   name="Mill" id="Mill" class="form-control taxtbox" required>
                                                                  <option value="">Select</option> 
                                                                   
                                                             <c:forEach items="${millid}" var="item">
                                                                   <option value="${item}">${item}</option> 
                                                                   </c:forEach> 


                                                             </select>
                                                        </div>
                                    
                                                  <div class="col-sm-4 form-group" id="contractNoContainer" style="display:none;">
                                                  <label>Contract No</label>
                                                  <select name="ContractNo" id="ContractNo" class="form-control taxtbox" required>
                                               <option disabled selected value="-Select-">-Select-</option>
                                                  </select>
                                                  </div>                                 
                                                          <div class="col-sm-4 form-group">
                                                   <label>HO DI </label>
                                                    <span class="text-danger">* </span>&nbsp; <span id="HO_DI_&_Date" name="HO_DI_&_Date" class="text-danger"> </span>
                                                    <select name="HO_DI_&_Date" id="HODate" class="form-control taxtbox" required>
                                                                           <option value="">-Select-</option>
                                                                           <c:forEach items="${DI_no}" var="item">
                                                                         <option value="${item}">${item}</option> 
                                                                        </c:forEach> 
                                                                        </select>
                                                                     </div>
                                                                      </div>
                                                                      
                                                                <div class="row">                                                            
                                                  
                                                         <div class="col-sm-4 form-group">
                                                        <div id="omMessage" class="text-danger"></div>
                                                        <label>O&M Official</label>
                                                        <span class="text-danger">*</span>
                                                        <select name="omofficial" id="omofficial" class="form-control taxtbox" required>
                                                            <option value="">Select</option>
                                                            <c:forEach items="${OM_official}" var="item">
                                                                <option value="${item}">${item}</option>
                                                            </c:forEach>
                                                        </select>
                                                        </div>
                                                  
                                                        
                                                        
                                                        <div class="col-sm-4 form-group">
                                         <label>Date of Inspection</label>
                                        <input class="form-control taxtbox" id="DateofInpection" 
                                        name="DateofInpection" placeholder="dd-mm-yyyy" required>                                   
                                                   </div>
                                                                
                                                              
     
                                                                   <div class="row">

                                                        
                                             
                                              <div class="row mt-3">
                                                          <table class="table table-bordered">
                                                              <thead>
                                                                  <tr>
                                                                       <th></th> 
                                                                      <th>Challan</th>
                                                                      <th>Mr_No</th>
                                                                       <th>Mr_Date</th>
                                                                        <th>Bill_Of_Supply_Number</th>
                                                                      <th>Date_Of_Shipment</th>                                                                 
                                                                      <th>Shipment_Quantity</th>
                                                                      <th>Claim Valuation</th>
                                                                      
                                                                   
                                                                  </tr>
                                                              </thead>
                                                              <tbody id="binDataBody">
                                                              
                                                                  <!-- Data rows will be dynamically populated -->
                                                              </tbody>
                                                          </table>
                                                      </div>           
                                                               
                                                      <div class="row">
                                        
                                           <%--  <div class="col-sm-4 form-group">
                                                             <input type="hidden"
                                                                   class="form-control taxtbox"  name="Settlement_id_generated"
                                                                   id="SettlementId" type="text" required readonly="readonly">
                                                        </div>  --%>
                                                        
                                                        <div class="col-sm-4 form-group">
                                                             <input type="hidden"
                                                                   class="form-control taxtbox" value = "${total}" name="Settlement_id_generated"
                                                                   type="text" required readonly="readonly">
                                                        </div> 
                                                  </div>
                                   
                                    <input type="hidden" id="numRows" name="rows">
                                    
                                                  <br>
                                                  
                                                  <div class="row">
                                               <div class="col-sm-12 form-group">
                                                        <br>
                                                      <br>
                                                      <br>
                                                      <br>
                                                  
                                                        <input type="submit" value="Submit" class="btn btn-primary"
                                                                   id="submit">
                                                        </div>
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


<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
<script src="https://code.jquery.com/ui/1.13.2/jquery-ui.js"></script>
<!--  <script>
      $( "#DateofInpection" ).datepicker({ dateFormat: 'dd-mm-yy'    });

      
</script> -->




      <script type="text/javascript">
           $(document).ready(function() {
                 $("#submit").click(function() {
                      //  Write code if Required

                 });
           });
      </script>








<script type="text/javascript">
    // Initialize the Datepicker
    $("#DateofInpection").datepicker({
        dateFormat: 'dd-mm-yy',
        onSelect: function(selectedDate) {
            var selectedOption = selectedDate;
            // alert(selectedOption); // Uncomment this line for debugging
            $.ajax({
                type: 'GET',
                url: 'fetchdateOfInspection.obj',
                data: {
                    DateOfInspection: selectedOption
                },
                success: function(data) {
                    var response = JSON.parse(data);                               
                    var selectedOmofficial = document.getElementById("omofficial").value;
                    var omMessageElement = document.getElementById("omMessage");
                    for (var i = 0; i < response.length; i++) {
                        var innerArray = response[i];
                        var omoofficial = innerArray[0];
                        var faofficial = innerArray[1];
                           
                        if (selectedOption == document.getElementById("DateofInpection").value && omoofficial == selectedOmofficial ) {
                            omMessageElement.innerText = selectedOmofficial + " is Already Occupied on this date for another claim settlement. Please Select Another Date";
                            return;
                        } 
                     
                    }
                    // If no conflicting dates found, clear any existing messages
                    omMessageElement.innerText = "";
                   
                },
                error: function(err) {
                    console.error('AJAX request failed: ' + err);
                }
            });
        }
    });
    $("#omofficial").change(function() { // Corrected the typo here
        // Execute the logic when omofficial selection changes
        var selectedOmofficial = document.getElementById("omofficial").value;       
        var selectedDate = document.getElementById("DateofInpection").value;
        var omMessageElement = document.getElementById("omMessage");
        

        
            $.ajax({
                type: 'GET',
                url: 'fetchdateOfInspection.obj',
                data: {
                    DateOfInspection: selectedDate
                },
                success: function(data) {
                    var response = JSON.parse(data);
                    for (var i = 0; i < response.length; i++) {
                        var innerArray = response[i];
                        var omoofficial = innerArray[0];
                        var faofficial = innerArray[1];
                        if (selectedDate  == document.getElementById("DateofInpection").value && omoofficial == selectedOmofficial ) {
                            omMessageElement.innerText = selectedOmofficial + " is Already Occupied on this date for another claim settlement. Please Select Another Date";
                            return;
                        }
                        
                    }
                    // If no conflicting dates found, clear any existing messages
                    omMessageElement.innerText = "";
                },
                error: function(err) {
                    console.error('AJAX request failed: ' + err);
                }
            });
        
    });
</script>

 

<script>
$(document).ready(function() {
    // Hide the milldetailsTable initially
    $('#milldetailsTable').hide();

    // Add an event listener for the change event on the dropdown
    $('#HODate').on('change', function() {
        
        var selectedOption = $(this).val();
        
        // Make an AJAX request to fetch data based on the selected HO DI
        $.ajax({
            type: 'GET',
            url: 'findByHoDi.obj',
            data: {
                hodino: selectedOption
            },
            dataType: 'json', // Set the dataType to 'json'
            success: function(data) {
                // Parse the JSON response
                var dataArray = data;
                $("#binDataBody").empty();
               
                var num_of_rows = dataArray.length;
                
                $('#numRows').val(num_of_rows);
             
                for (var i = 0; i < dataArray.length; i++) {
                    var newRow = "<tr>";
                    newRow +=
                       /*  '<td><input type="checkbox" onclick="myFunction(this)" id="checkbox_' + i + '" class="row-checkbox" name="rowCheckbox[]" value="0"></td>' + */
                        '<td><div class="table-cell"><input type="hidden"  name="challans[]" value="' + dataArray[i][0] + '">' + dataArray[i][0] + '</div></td>' +
                        '<td><div class="table-cell"><input type="hidden"  name="mr_no[]" value="' + dataArray[i][1] + '">' + dataArray[i][1] + '</div></td>' +                  
                        '<td><div class="table-cell"><input type="hidden"  name="mr_date[]" value="' + dataArray[i][2] + '">' + dataArray[i][2] + '</div></td>' +                  
                        '<td><div class="table-cell"><input type="hidden"  name="billofsupply[]" value="' + dataArray[i][3] + '">' + dataArray[i][3] + '</div></td>' +                  
                        '<td><div class="table-cell"><input type="hidden"  name="dateofshipment[]" value="' + dataArray[i][4] + '">' + dataArray[i][4] + '</div></td>' +                  
                        '<td><div class="table-cell"><input type="hidden"  name="shipmentquantity[]" value="' + dataArray[i][5] + '">' + dataArray[i][5] + '</div></td>'+
                        '<td><div class="table-cell"><input type="hidden"  name="claimamount[]" value="' + dataArray[i][6] + '">' + dataArray[i][6] + '</div></td>'+
                         '<td><input type="checkbox" onclick="myFunction(this)" id="checking'+i+'" class="row-checkbox" name="rowCheckbox'+i+'" value="0"></td>' ; 
                    newRow += "</tr>";
                    $("#binDataBody").append(newRow);
                }
            },
            error: function(err) {
                console.error('AJAX request failed: ' + err);
            }
        });
    });
});

function myFunction(checking,i) {
       /*  alert(checking.value);
       var k = document.getElementById("checking"); */
       /* alert( k +"id")  */
    if (!checking.checked) {
        $(checking).val(0);
       // alert($(checking).val());
    } else {
        $(checking).val(1);
       // alert($(checking).val());
    }
}  


</script> 

<!-- 
                <script type="text/javascript">
                function myFunction()() 
                {
                    if (!document.getElementById("checkbox1").checked) {
                      alert("rrrrr")
                             var k =   $('#checkbox1').val(0);
                                alert(k)
                    }else{
                              var k =  $('#checkbox1').val(1);
                              alert(K)
                    }
                }
                
             
   </script> -->
   
    
       <script type="text/javascript">
    $(document).ready(function() {
        $('#Mill').on('change', function() {
            var selectedOption = $(this).val();
            $.ajax({
                type: 'GET',
                url: 'fetchmillreceiptdata.obj',
                data: {
                    millid: selectedOption
                },
                success: function(data) {
                    var response = JSON.parse(data);
                    var html = "<option disabled selected value='-Select-'>-Select-</option>";

                    for (var i = 0; i < response.length; i++) {
                        html += "<option value='" + response[i] + "'>" + response[i] + "</option>";
                    }

                    $("#ContractNo").html(html);
                    $("#contractNoContainer").show(); // Show contract number container
                },
                error: function(err) {
                    console.error('AJAX request failed: ' + err);
                }
            });
        });
    });
</script>
     

      <!-- AJAX Call for Fetching Mill Receipt Data -->

      

      <!--  For Fetching the Grade_Composition based on Contract Number -->

      <!--   For Hinding and Showing the  Grade Wise Alloction-->

      <script type="text/javascript">
           $(document).ready(function() {
           
           });
      </script>


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
      <!-- CORE SCRIPTS-->
      <script src="assets/js/app.min.js" type="text/javascript"></script>
      

      <!-- PAGE LEVEL SCRIPTS-->
</body>
</html>

