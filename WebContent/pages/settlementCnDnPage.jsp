<!DOCTYPE html>
<%@page import="org.apache.commons.lang3.ObjectUtils.Null"%>
<%@page import="java.time.LocalDate"%>
<%@page import="com.jci.model.StateList"%>
<%@page import="java.util.List"%>

<html lang="en">
<%@ page import="javax.servlet.http.HttpServletRequest"%>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width initial-scale=1.0">
<title>JCI | CMS</title>
<link href="./assets/vendors/bootstrap/dist/css/bootstrap.min.css"
       rel="stylesheet" />
<link href="./assets/vendors/font-awesome/css/font-awesome.min.css"
       rel="stylesheet" />
<link href="./assets/vendors/themify-icons/css/themify-icons.css"
       rel="stylesheet" />
<link rel="stylesheet"
       href="//code.jquery.com/ui/1.13.2/themes/base/jquery-ui.css">
<link rel="stylesheet" href="/resources/demos/style.css">
<!-- PLUGINS STYLES-->
<link href="./assets/vendors/DataTables/datatables.min.css"
       rel="stylesheet" />
<!-- THEME STYLES-->
<link href="assets/css/main.min.css" rel="stylesheet" />
<link rel="stylesheet" href="assets/css/chosen.css">
<script src="https://code.jquery.com/jquery-1.11.3.min.js"
       type="text/javascript"></script>
           <script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.29.4/moment.min.js"></script>

<style>
        .bold-underline {
            font-weight: bold;
            text-decoration: underline;
        }
    </style>
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
<style>
.field-icon {
       float: right;
       margin-left: -25px;
       margin-top: -25px;
       position: relative;
       z-index: 2;
}

.container {
       padding-top: 50px;
       margin: auto;
}

.required:after {
       content: " *";
       color: red;
}

input[type="radio"] {
       display: inline;
}
</style>
</head>

<%
String currCropYear = (String) request.getSession().getAttribute("currCropYear");
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
                          <h1 class="page-title">Settlement of Credit And Debit Note</h1>
                    </div>
                    <div class="page-content fade-in-up">
                          <div class="row">
                                 <div class="col-md-11">
                                       <div class="ibox">
                                              <div class="ibox-head">
                                                    <!-- <div class="ibox-title">Basic form</div> -->
                                                     <span>${msg}</span>
                                              </div>
                                              <div class="ibox-body">
                                                    <form id ="myForm" action="saveCnAndDn.obj" method="POST">
                                                           <div class="row">

                                                                  <div class="col-sm-6 form-group">
                                                                        <label>Mill Name</label>

                                                                        <%
                                                                        List<String> mills = (List<String>) request.getAttribute("mills");
                                                                        %>
                                                                        <select class="form-control" name="mill" id="mill" required>
                                                                               <option value="">-Select-</option>
                                                                               <%
                                                                               for (String mill : mills) {
                                                                                     String millArray[] = mill.split("&-&");
                                                                               %>
                                                                               <option value="<%=millArray[1]%>"><%=millArray[0]%></option>
                                                                               <%
                                                                               }
                                                                               %>
                                                                        </select>
                                                                  </div>

                                                                  <div class="col-sm-6 form-group">
                                                                        <label>Contract No</label> <select class="form-control"
                                                                               name="contract" id="contract" required>
                                                                               <option disabled selected value="">-Select-</option>
                                                                        </select>
                                                                  </div>
                                                           </div>
                                                                                                
                                                          
                                                           
                                                         <!--   <div class= "row">
                                                           <div class="col-sm-6 form-group">
                                                            <label>Amount Value.</label>
                                                           <input type="" id="AmountDifference" name="AmountDifferenceCNDN" ReadOnly>
                                                           </div>
                                                           </div> -->
                                                           
                                                          <div class="row">
															    <div class="col-sm-12 text-center">
															        <label class="bold-underline">DETAILS OF CREDIT NOTE AND DEBIT NOTE</label>
															    </div>
															</div>
                                                                                                                                   
                                                           <div class="scrollmenu">
                                                           <div class="row">

                                                                  <div class="col-sm-6 form-group">
                                                                     <table class="table table-bordered">
                                                      <thead>
                                                      <tr>
                                                      
                                                      <th>Select</th>
                                                      <th>CN/DN No</th>
                                                       <th>Purpose</th>
                                                      <th>Date_Of_Issue</th>
                                                      <th>HODI No</th><th>
                                                      Consignment_Note </th>
                                                      <th>Bos_No</th>
                                                      <th>Date_Of_Shipment</th>
                                                      <th>Date_Of_Inspection</th>
                                                      <th>CN/DN Amount</th>
                                                      <th>Settlement_Id</th>
                                                      <th>CN/DN DOC</th>
                                                      <th>Consignment DOC</th>
                                                      <th> Bos DOC</th><th> 
                                                         
                                                      </tr>
                                                  </thead>
                                                   <tbody id="binDataBody">
                                                      <!-- Table body content -->
                                                  </tbody>
                                                           </table>     
                                                                  </div>
                                                           </div>
                                                           </div>


                                       <div class="row">
                                       <div class="col-sm-4 form-group">
                                       <input type="hidden" id="numRows" name="rows">
                                       </div>
                                        </div>   
                                         
                                                          <div class= "row">
                                                           <div class="col-sm-6 form-group">
                                                            <label>Payment Amount.</label>
                                                           <input type="" id="AmountDifference" name="AmountDifferenceCNDN" ReadOnly>
                                                           </div>
                                                           </div>
                                                           <div class="row">

                                                                  <div class="form-group col-sm-6">
                                                                    <div style="flex-grow: 1;"></div>
                                                                        <button  class="btn btn-success" id="submit" type="submit" onclick="disableSubmit(event)">Submit</button>
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
       
           <script>
        $(document).ready(function() {
            $('#myForm').on('submit', function(event) {
                // Disable the submit button
                $('#submit').prop('disabled', true);
                $('#submit').val('Please Wait Processing...');  

              
            });
        });
    </script>
            
               <script>
                                                          $("#mill").on("change",function() {
            	                                                $.ajax({
                                                                  type : "GET",
                                                                  url : "selectContractForSettlement.obj",
                                                                  //url : "pIcon.obj",
                                                                  data : {
                                                                        "mill" : $(this).val()
                                                                  },
                                                                  success : function(result) {

                                                                        var result = JSON.parse(result);

                                                                        var options = '<option selected value="">-Select-</option>';

                                                                        for (var i = 0; i < result.length; i++) {
                                                                               options += '<option value="' + result[i] + '">'
                                                                                            + result[i]
                                                                                            + '</option>';
                                                                        }
                                                                        $("#contract").html(options);
                                                                  }

                                                           });

                                       })
       </script>



       
<!--        <script>
             $("#contract")
                          .on(
                                       "change",
                                       function() {
                                              $
                                                            .ajax({
                                                                  type : "GET",
                                                                  url : "getFullDetailsOfCrnAndDebit.obj",
                                                                  data : {
                                                                        "contractNo" : $(this).val()
                                                                  },
                                                                  success : function(result) {
                                                                        $("#binDataBody").empty();
                                                                        var result = JSON.parse(result);
                                                                    // alert(result);
                                                                       if (result.length === 0) {
																	        alert("No Credit Note And Debit Note  Are Present On this Contract.");  // Show alert message
																	        return;  // Exit function early
																	    }
                                                                       
                                                                        

                                                                  
                                                                     for (var i = 0; i < result.length; i++) {
                                                                    	
                                                                    	 var num_of_rows = result.length;
                                                                         
                                                                         $('#numRows').val(num_of_rows);

                                                                    	    var doi = result[i][2];
                                                                    	    var dateOfIssue = moment(doi).format('DD-MM-YYYY');
                                                                    	    
                                                                    	    var newRow = "<tr>";
                                                                    	    
                                                                    	    newRow +=
                                                                    	        '<td><input type="checkbox" onclick="myFunction(this)" id="checking' + i + '" class="row-checkbox" name="rowCheckbox' + i + '" value="0"></td>';
                                                                              
                                                                    	    
                                                                    	    // Check the conditions and add the respective content to the newRow variable
                                                                    	    if (result[i][0].charAt(0) == 'C' && result[i][0].charAt(1) != 'S') {
                                                                    	        var dos = result[i][6];
                                                                        	    var dateOfShipments = moment(dos).format('DD-MM-YYYY');
                                                                    	    	var purpose = "Short Weight";

                                                                    	        newRow +=
                                                                    	        	'<td style="text-align:center"><input type="hidden" name="creditNoteNo[]" value="' + result[i][0] + '">' + result[i][0] + '</td>'
                                                                    	            +'<td style="text-align:center"><input type="hidden" name="purpose[]" value="' + purpose + '">' + purpose + '</td>'
                                                                    	            + '<td style="text-align:center"><input type="hidden" name="DateOfIssue[]" value="' + result[i][2] + '">' + result[i][2]+ '</td>'
                                                                    	            + '<td style="text-align:center"><input type="hidden" name="Hodi[]" value="' + result[i][8] + '">' + result[i][8] + '</td>'
                                                                    	            + '<td style="text-align:center"><input type="hidden" name="consigneeNoteText[]" value="' + result[i][4] + '">' + result[i][4] + '</td>'
                                                                    	            + '<td style="text-align:center"><input type="hidden" name="bosNo[]" value="' + result[i][5] + '">' + result[i][5] + '</td>'
                                                                    	            + '<td style="text-align:center"><input type="hidden" name="dateOfShipment[]" value="' + result[i][6] + '">' + result[i][6] + '</td>'
                                                                    	            + '<td style="text-align:center"><input type="hidden" name="dateOfInspection[]" value=""></td>'
                                                                    	            + '<td style="text-align:center"><input type="hidden" name="creditNoteAmount[]" value="' + result[i][1] + '">' + result[i][1] + '</td>'
                                                                    	            + '<td style="text-align:center"><input type="hidden" name="settlementId[]" value=""></td>'
                                                                    	            + '<td><a href="downloadSupportingCreditNoteDoc.obj?filename=' + result[i][10] + '" class="btn btn-primary" target="_blank"> View Document</a></td>'
                                                                    	            + '<td><a href="http://49.50.118.112:8080/DispatchDetail/' + result[i][9] + '" class="btn btn-primary" target="_blank"> View Document</a></td>'
                                                                    	            + '<td><a href="downloadSupportingbosDoc.obj?filename=' + result[i][7] + '" class="btn btn-primary" target="_blank"> View Document</a></td>'
                                                                    	            + '<td style="text-align:center"><input type="hidden" name="consigneeDoc[]" value="' + result[i][9] + '"></td>'
                                                                    	            + '<td style="text-align:center"><input type="hidden" name="BosDoc[]" value="' + result[i][7] + '"></td>'
                                                                    	            + '<td style="text-align:center"><input type="hidden" name="creditNoteDoc[]" value="' + result[i][10] + '"></td>';
                                                                    	    } else if (result[i][0].charAt(0) == 'C' && result[i][0].charAt(1) == 'S') {
                                                                    	       
                                                                    	       
                                                                        	    var purpose = "Claim";
                                                                                 alert(result[i][0])
                                                                    	        newRow +=
                                                                    	        	'<td style="text-align:center"><input type="hidden" name="creditNoteNo[]" value="' + result[i][12] + '">' + result[i][12] + '</td>'
                                                                    	            + '<td style="text-align:center"><input type="hidden" name="purpose[]" value="' + purpose + '">' + purpose + '</td>'
                                                                    	            + '<td style="text-align:center"><input type="hidden" name="DateOfIssue[]" value="' + result[i][2] + '">' + result[i][2] + '</td>'
                                                                    	            + '<td style="text-align:center"><input type="hidden" name="Hodi[]" value="' + result[i][10] + '">' + result[i][10] + '</td>'
                                                                    	            + '<td style="text-align:center"><input type="hidden" name="consigneeNoteText[]" value="' + result[i][4] + '">' + result[i][4] + '</td>'
                                                                    	            + '<td style="text-align:center"><input type="hidden" name="bosNo[]" value="' + result[i][5] + '">' + result[i][5] + '</td>'
                                                                    	            + '<td style="text-align:center"><input type="hidden" name="dateOfShipment[]" value="' + result[i][6] + '">' + result[i][6] + '</td>'
                                                                    	            + '<td style="text-align:center"><input type="hidden" name="dateOfInspection[]" value="' + result[i][7] + '">' + result[i][7] + '</td>'
                                                                    	            + '<td style="text-align:center"><input type="hidden" name="creditNoteAmount[]" value="' + result[i][1] + '">' + result[i][1] + '</td>'
                                                                    	            + '<td style="text-align:center"><input type="hidden" name="settlementId[]" value="' + result[i][8] + '">' + result[i][8] + '</td>'
                                                                    	            + '<td><a href="creditNoteSettleDoc.obj?filename=' + result[i][13] + '" class="btn btn-primary" target="_blank"> View Document</a></td>'
                                                                    	            + '<td><a href="http://49.50.118.112:8080/DispatchDetail/' + result[i][11] + '" class="btn btn-primary" target="_blank"> View Document</a></td>'
                                                                    	            + '<td><a href="downloadSupportingbosDoc.obj?filename=' + result[i][9] + '" class="btn btn-primary" target="_blank"> View Document</a></td>'
                                                                    	            + '<td style="text-align:center"><input type="hidden" name="consigneeDoc[]" value="' + result[i][11] + '"></td>'
                                                                    	            + '<td style="text-align:center"><input type="hidden" name="BosDoc[]" value="' + result[i][9] + '"></td>'
                                                                    	            + '<td style="text-align:center"><input type="hidden" name="creditNoteDoc[]" value="' + result[i][13] + '"></td>';
                                                                    	    } else {
                                                                    	        var dateOfIssued = moment(result[i][2]).format('DD-MM-YYYY');

                                                                    	        newRow +=
                                                                    	        	+'<td style="text-align:center"><input type="hidden" name="creditNoteNo[]" value="' + result[i][0] + '">' + result[i][0] + '</td>'
                                                                    	            '<td style="text-align:center"><input type="hidden" name="purpose[]" value=""></td>'
                                                                    	            + '<td style="text-align:center"><input type="hidden" name="DateOfIssue[]" value="' + result[i][2] + '">' + result[i][2] + '</td>'
                                                                    	            + '<td style="text-align:center"><input type="hidden" name="Hodi[]" value=""></td>'
                                                                    	            + '<td style="text-align:center"><input type="hidden" name="consigneeNoteText[]" value=""></td>'
                                                                    	            + '<td style="text-align:center"><input type="hidden" name="bosNo[]" value=""></td>'
                                                                    	            + '<td style="text-align:center"><input type="hidden" name="dateOfShipment[]" value=""></td>'
                                                                    	            + '<td style="text-align:center"><input type="hidden" name="dateOfInspection[]" value=""></td>'
                                                                    	            + '<td style="text-align:center"><input type="hidden" name="creditNoteAmount[]" value="' + result[i][1] + '">' + result[i][1] + '</td>'
                                                                    	            + '<td style="text-align:center"><input type="hidden" name="settlementId[]" value=""></td>'
                                                                    	            + '<td><a href="downloadSupportingCreditNoteDocForDN.obj?filename=' + result[i][3] + '" class="btn btn-primary" target="_blank"> View Document</a></td>'
                                                                    	            + '<td style="text-align:center"><input type="hidden" name="consigneeDoc[]" value=""></td>'
                                                                    	            + '<td style="text-align:center"><input type="hidden" name="BosDoc[]" value=""></td>'
                                                                    	            + '<td style="text-align:center"><input type="hidden" name="creditNoteDoc[]" value="' + result[i][3] + '"></td>';
                                                                    	    }

                                                                    	    newRow += "</tr>";
                                                                    	    $("#binDataBody").append(newRow);        
                                                                    	}

                                                                        htmlTable += '</tbody></table>';

                                                                        $("#list").html(htmlTable);
                                                                        console.log(htmlTable);

                                                                  }

                                                           });

                                       })
                                       function myFunction(checking,i) {
       
    if (!checking.checked) {
        $(checking).val(0);
        //alert("no")
      
    } else {
        $(checking).val(1);
       // alert("yes")
     
    }
}  
       </script> -->
       
<script>
    var creditnotesum = 0.0;
    var debitnotesum = 0.0;

    $("#contract").on("change", function() {
    	document.getElementById('AmountDifference').value = '';
    	$.ajax({
            type: "GET",
            url: "getFullDetailsOfCrnAndDebit.obj",
            data: {
                "contractNo": $(this).val()
            },
            success: function(result) {
                $("#binDataBody").empty();
                var result = JSON.parse(result);
                
                if (result.length === 0) {
                    alert("No Credit Note And Debit Note Are Present On this Contract.");  // Show alert message
                    return;  // Exit function early
                }

                // Reset sums for new data
                creditnotesum = 0.0;
                debitnotesum = 0.0;

                var htmlTable = '<table><thead><tr>'
                    + '<th>Select</th><th>Credit Note No</th><th>Purpose</th><th>Date of Issue</th><th>Hodi</th><th>Consignee Note Text</th><th>BOS No</th><th>Date of Shipment</th><th>Date of Inspection</th><th>Credit Note Amount</th><th>Settlement Id</th><th>Supporting Credit Note Document</th><th>Dispatch Detail Document</th><th>BOS Document</th><th>Consignee Document</th><th>BOS Doc</th><th>Credit Note Doc</th>'
                    + '</tr></thead><tbody>';

                for (var i = 0; i < result.length; i++) {
                    var num_of_rows = result.length;
                    $('#numRows').val(num_of_rows);

                    var doi = result[i][2];
                    var dateOfIssue = moment(doi).format('DD-MM-YYYY');

                    var newRow = "<tr>";
                    newRow += '<td><input type="checkbox" onclick="myFunction(this, ' + i + ')" id="checking' + i + '" class="row-checkbox" name="rowCheckbox' + i + '" value="0"></td>';

                    if (result[i][0].charAt(0) == 'C' && result[i][0].charAt(1) != 'S') {
                        var dos = result[i][6];
                        var dateOfShipments = moment(dos).format('DD-MM-YYYY');
                        var purpose = "Short Weight";

                        newRow +=
                            '<td style="text-align:center"><input type="hidden" name="creditNoteNo[]" value="' + result[i][0] + '">' + result[i][0] + '</td>'
                            + '<td style="text-align:center"><input type="hidden" name="purpose[]" value="' + purpose + '">' + purpose + '</td>'
                            + '<td style="text-align:center"><input type="hidden" name="DateOfIssue[]" value="' + result[i][2] + '">' + result[i][2] + '</td>'
                            + '<td style="text-align:center"><input type="hidden" name="Hodi[]" value="' + result[i][8] + '">' + result[i][8] + '</td>'
                            + '<td style="text-align:center"><input type="hidden" name="consigneeNoteText[]" value="' + result[i][4] + '">' + result[i][4] + '</td>'
                            + '<td style="text-align:center"><input type="hidden" name="bosNo[]" value="' + result[i][5] + '">' + result[i][5] + '</td>'
                            + '<td style="text-align:center"><input type="hidden" name="dateOfShipment[]" value="' + result[i][6] + '">' + result[i][6] + '</td>'
                            + '<td style="text-align:center"><input type="hidden" name="dateOfInspection[]" value=""></td>'
                            + '<td style="text-align:center"><input type="hidden" name="creditNoteAmount[]" value="' + result[i][1] + '">' + result[i][1] + '</td>'
                            + '<td style="text-align:center"><input type="hidden" name="settlementId[]" value=""></td>'
                            + '<td><a href="downloadSupportingCreditNoteDoc.obj?filename=' + result[i][10] + '" class="btn btn-primary" target="_blank"> View Document</a></td>'
                            + '<td><a href="http://49.50.118.112:8080/DispatchDetail/' + result[i][9] + '" class="btn btn-primary" target="_blank"> View Document</a></td>'
                            + '<td><a href="downloadSupportingbosDoc.obj?filename=' + result[i][7] + '" class="btn btn-primary" target="_blank"> View Document</a></td>'
                            + '<td style="text-align:center"><input type="hidden" name="consigneeDoc[]" value="' + result[i][9] + '"></td>'
                            + '<td style="text-align:center"><input type="hidden" name="BosDoc[]" value="' + result[i][7] + '"></td>'
                            + '<td style="text-align:center"><input type="hidden" name="creditNoteDoc[]" value="' + result[i][10] + '"></td>';
                    } else if (result[i][0].charAt(0) == 'C' && result[i][0].charAt(1) == 'S') {
                        var purpose = "Claim";
                        newRow +=
                            '<td style="text-align:center"><input type="hidden" name="creditNoteNo[]" value="' + result[i][12] + '">' + result[i][12] + '</td>'
                            + '<td style="text-align:center"><input type="hidden" name="purpose[]" value="' + purpose + '">' + purpose + '</td>'
                            + '<td style="text-align:center"><input type="hidden" name="DateOfIssue[]" value="' + result[i][2] + '">' + result[i][2] + '</td>'
                            + '<td style="text-align:center"><input type="hidden" name="Hodi[]" value="' + result[i][10] + '">' + result[i][10] + '</td>'
                            + '<td style="text-align:center"><input type="hidden" name="consigneeNoteText[]" value="' + result[i][4] + '">' + result[i][4] + '</td>'
                            + '<td style="text-align:center"><input type="hidden" name="bosNo[]" value="' + result[i][5] + '">' + result[i][5] + '</td>'
                            + '<td style="text-align:center"><input type="hidden" name="dateOfShipment[]" value="' + result[i][6] + '">' + result[i][6] + '</td>'
                            + '<td style="text-align:center"><input type="hidden" name="dateOfInspection[]" value="' + result[i][7] + '">' + result[i][7] + '</td>'
                            + '<td style="text-align:center"><input type="hidden" name="creditNoteAmount[]" value="' + result[i][1] + '">' + result[i][1] + '</td>'
                            + '<td style="text-align:center"><input type="hidden" name="settlementId[]" value="' + result[i][8] + '">' + result[i][8] + '</td>'
                            + '<td><a href="creditNoteSettleDoc.obj?filename=' + result[i][13] + '" class="btn btn-primary" target="_blank"> View Document</a></td>'
                            + '<td><a href="http://49.50.118.112:8080/DispatchDetail/' + result[i][11] + '" class="btn btn-primary" target="_blank"> View Document</a></td>'
                            + '<td><a href="downloadSupportingbosDoc.obj?filename=' + result[i][9] + '" class="btn btn-primary" target="_blank"> View Document</a></td>'
                            + '<td style="text-align:center"><input type="hidden" name="consigneeDoc[]" value="' + result[i][11] + '"></td>'
                            + '<td style="text-align:center"><input type="hidden" name="BosDoc[]" value="' + result[i][9] + '"></td>'
                            + '<td style="text-align:center"><input type="hidden" name="creditNoteDoc[]" value="' + result[i][13] + '"></td>';
                    } else {
                        newRow +=
                            '<td style="text-align:center"><input type="hidden" name="creditNoteNo[]" value="' + result[i][0] + '">' + result[i][0] + '</td>'
                            + '<td style="text-align:center"><input type="hidden" name="purpose[]" value=""></td>'
                            + '<td style="text-align:center"><input type="hidden" name="DateOfIssue[]" value="' + result[i][2] + '">' + result[i][2] + '</td>'
                            + '<td style="text-align:center"><input type="hidden" name="Hodi[]" value=""></td>'
                            + '<td style="text-align:center"><input type="hidden" name="consigneeNoteText[]" value=""></td>'
                            + '<td style="text-align:center"><input type="hidden" name="bosNo[]" value=""></td>'
                            + '<td style="text-align:center"><input type="hidden" name="dateOfShipment[]" value=""></td>'
                            + '<td style="text-align:center"><input type="hidden" name="dateOfInspection[]" value=""></td>'
                            + '<td style="text-align:center"><input type="hidden" name="creditNoteAmount[]" value="' + result[i][1] + '">' + result[i][1] + '</td>'
                            + '<td style="text-align:center"><input type="hidden" name="settlementId[]" value=""></td>'
                            + '<td><a href="downloadSupportingCreditNoteDocForDN.obj?filename=' + result[i][3] + '" class="btn btn-primary" target="_blank"> View Document</a></td>'
                            + '<td style="text-align:center"><input type="hidden" name="consigneeDoc[]" value=""></td>'
                            + '<td style="text-align:center"><input type="hidden" name="BosDoc[]" value=""></td>'
                            + '<td style="text-align:center"><input type="hidden" name="creditNoteDoc[]" value="' + result[i][3] + '"></td>';
                    }

                    newRow += "</tr>";
                    $("#binDataBody").append(newRow);
                }

                htmlTable += '</tbody></table>';
                $("#list").html(htmlTable);
                console.log(htmlTable);
            }
        });
    });

    function myFunction(checking, i) {
        // Get the credit note amount from the hidden input field
        var amount = parseFloat($(checking).closest('tr').find('input[name="creditNoteAmount[]"]').val());
        //alert(amount)

        if (checking.checked) {
            $(checking).val(1);

            // Update the sums based on the type of note
            var noteNo = $(checking).closest('tr').find('input[name="creditNoteNo[]"]').val();
            if (noteNo.charAt(0) == 'C' && noteNo.charAt(1) != 'S') {
                creditnotesum += amount;
            } else if (noteNo.charAt(0) == 'C' && noteNo.charAt(1) == 'S') {
                creditnotesum += amount;
            } else {
                debitnotesum += amount;
            }
        } else {
            $(checking).val(0);
        
            // Update the sums based on the type of note
            var noteNo = $(checking).closest('tr').find('input[name="creditNoteNo[]"]').val();
            if (noteNo.charAt(0) == 'C' && noteNo.charAt(1) != 'S') {
                creditnotesum -= amount;
            } else if (noteNo.charAt(0) == 'C' && noteNo.charAt(1) == 'S') {
                creditnotesum -= amount;
            } else {
                debitnotesum -= amount;
            }
        }

        var  amountdifference =  creditnotesum - debitnotesum; 
        
        if(amountdifference >0 ){
        	amountdifference =  creditnotesum - debitnotesum; 
        	//alert(amountdifference + "correct")
        	
        
        }
        else if( creditnotesum ==0  &&  amountdifference <0)
        {
        	amountdifference = debitnotesum
        	
        	
        }
        else if( amountdifference <0){
        	document.getElementById('AmountDifference').value = amountdifference
        	alert(amountdifference + "credit and debit note differenct is negative" )
        }
        // alert(amountdifference)
       document.getElementById('AmountDifference').value = amountdifference
         // Display the sums (you can update this to show the sums somewhere in the UI)
      /*   console.log('Credit Note Sum:', creditnotesum);
        console.log('Debit Note Sum:', debitnotesum); */
    }
</script>

       




       <script src="https://code.jquery.com/ui/1.13.2/jquery-ui.js"></script>
       <script src="./assets/vendors/metisMenu/dist/metisMenu.min.js"
             type="text/javascript"></script>
       <script src="assets/js/app.min.js" type="text/javascript"></script>

</body>
</html>

