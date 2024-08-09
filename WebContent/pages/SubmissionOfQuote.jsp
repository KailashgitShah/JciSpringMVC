<%@ page import="java.util.List" %>
<%@ page import="java.time.LocalDate" %>
<%@ page import="java.time.LocalDateTime" %>
<%@ page import="java.time.format.DateTimeFormatter" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>JCI | CMS</title>
    <!-- GLOBAL MAINLY STYLES-->
    <link href="./assets/vendors/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet" />
    <link href="./assets/vendors/font-awesome/css/font-awesome.min.css" rel="stylesheet" />
    <link href="./assets/vendors/themify-icons/css/themify-icons.css" rel="stylesheet" />
    <!-- PLUGINS STYLES-->
    <!-- THEME STYLES-->
    <link href="assets/css/main.min.css" rel="stylesheet" />
    <!-- PAGE LEVEL STYLES-->
    <link rel="stylesheet" href="//code.jquery.com/ui/1.13.2/themes/base/jquery-ui.css">
    <link rel="stylesheet" href="/resources/demos/style.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
    <script src="https://code.jquery.com/ui/1.13.2/jquery-ui.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.5.0/js/bootstrap-datepicker.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    <style>
        .required:after {
            content: " *";
            color: red;
        }
  #lottable {
    width: 100%; /* Ensure the table takes the full width */
    table-layout: auto; /* Allow columns to adjust based on content */
    border-collapse: collapse; /* Ensure borders collapse into a single border */
}

#lottable th, #lottable td {
    padding: 8px 12px; /* Add padding for better spacing */
    border: 1px solid #ddd; /* Add borders for all cells */
    text-align: left; /* Align text to the left */
}

.table-container {
    max-width: 100%; /* Ensure the container doesn't exceed the parent width */
    overflow-x: auto; /* Enable horizontal scrolling if needed */
}

.table-scroll {
    max-height: 400px; /* Set the desired height */
    overflow-y: auto; /* Enable vertical scrolling */
}

.table {
    width: 100%;
    /* Optionally, you can set a min-width if needed to ensure proper column widths */
    min-width: 800px; 
}

    </style>
</head>
<body class="fixed-navbar" onload="myFunction()">
<div class="page-wrapper">
    <!-- START HEADER-->
    <c:choose>
        <c:when test="${not empty sessionScope.roleId}">
            <%@ include file="header.jsp"%>
        </c:when>
        <c:otherwise>
            <header class="header">
                <div class="page-brand">
                    <a class="link" href="index.html">
                        <span class="brand">Admin
                            <span class="brand-tip">CAST</span>
                        </span>
                        <span class="brand-mini">AC</span>
                    </a>
                </div>
            </header>
        </c:otherwise>
    </c:choose>
    <!-- END HEADER-->
    <!-- START SIDEBAR-->
    <c:choose>
        <c:when test="${not empty sessionScope.roleId}">
            <!-- Sidebar 1 -->
            <%--   <%@ include file="sidebar.jsp"%>  --%>
        </c:when>
        <c:otherwise>
            <!-- Sidebar 2 -->
            <style>
                body {
                    zoom: 85%;
                }

                .side-menu li a {
                    color: #fff;
                }

                .sidebarleft {
                    /* Add your styles for the sidebar container */
                }

                /* Add more styles as needed */
            </style>

            <nav class="page-sidebar" id="sidebar" style="height: 90%; overflow-y: auto;">
                <div class="page-brand">
                    <a class="link" href="#">
                        <span class="brand">
                            <span class="brand-tip">
                                <img src="assets/img/logo5.png">
                            </span>
                        </span>
                        <span class="brand-mini">
                            <img src="assets/img/logo5.png">
                        </span>
                    </a>
                </div>

                <div class="admin-info">
                    <div class="font-strong">
                        Welcome <br> <span style="color: #ffc107;">
                            <%
                            String useremail = (String) request.getSession().getAttribute("useremail");
                            if (useremail == null) {
                                String redirectURL = "http://localhost:8080/jciadmin/index.obj";
                                response.sendRedirect(redirectURL);
                            }
                            %>
                        </span>
                    </div>
                </div>

                <div id="sidebar-collapse" class="sidebarleft">
                    <!--  <ul class="side-menu metismenu">
                        <li><a href="milldash.obj"><i class="sidebar-item-icon fa fa-th-large"></i> <span class="nav-label">Dashboard</span></a></li>
                    </ul> -->

                    <ul class="side-menu metismenu">
                                        <li><a href="viewmillAcc.obj"><i class="sidebar-item-icon fa fa-th-large"></i> <span class="nav-label">Mill Acceptance list</span></a></li>
                        <li><a href="verifyMillClaim.obj"><i class="sidebar-item-icon fa fa-th-large"></i> <span class="nav-label">Mill Claim Settlement</span></a></li> 

                        <li><a href="EntrySubmissionofQuote.obj"><i class="sidebar-item-icon fa fa-th-large"></i> <span class="nav-label">Submission of Quote</span></a></li> 
                     <li><a href="viewlistofbid.obj"><i class="sidebar-item-icon fa fa-th-large"></i> <span class="nav-label">List of BID</span></a></li>
                 <li><a href="viewsubmissionOfQuotedel.obj"><i class="sidebar-item-icon fa fa-th-large"></i> <span class="nav-label">List of BID Submitted</span></a></li>
               
                    </ul>
                </div>
            </nav>
        </c:otherwise>
    </c:choose>
    <!-- END SIDEBAR-->
    <div class="content-wrapper">
        <!-- START PAGE CONTENT-->
        <div class="page-heading">
            <h1 class="page-title"> Submission of Quote</h1>
        </div>

        <%
            List<Object> getcontractList1 = (List<Object>) request.getAttribute("getcontractList1");
            String bidref = (String) request.getAttribute("bidno");
            String lotid = (String) request.getAttribute("lotid");
            String millname1 = (String) request.getAttribute("millname");
            String millcode = (String) request.getAttribute("millcode");
            String sellprice1 = (String) request.getAttribute("sellprice1");
            String basis = (String) request.getAttribute("basis");
            String openingdate = (String) request.getAttribute("openingdate");
            String closingdate = (String) request.getAttribute("closingdate");
            String lotsize = (String) request.getAttribute("lotsize");
            String securitydeposit = (String) request.getAttribute("securitydeposit");
            int frieght=0;
        %>
        <div class="page-content fade-in-up">
            <div class="row">
                <div class="col-md-11">
                    <div class="ibox">
                        <span>${msg}</span>
                        <div class="ibox-body">
                            <form action="saveentryofSubmissionofQoute.obj" method="POST" name="myForm" enctype="multipart/form-data">
                                <div class="child-checkbox" id="disableform">
                                    <div class="row">
                                        <div class="col-sm-4 form-group">
                                            <label>Bid Reference No</label>
                                            <span class="text-danger">*</span>&nbsp;<span id="Bid_Reference_No" name="Bid_Reference_No" class="text-danger"></span>
                                            <input class="form-control" name="Bid_Reference_No1" id="Bid_Reference_No" value="<%= bidref %>" readonly="readonly" required>
                                        </div>
                                        <div class="col-sm-4 form-group">
                                            <label>Bid opening  date   </label>
                                            <span class="text-danger">*</span>&nbsp;<span id="openingdate2" name="openingdate2" class="text-danger"></span>
                                            <input class="form-control" name="openingdate" id="openingdate1" value="<%= openingdate %>" readonly="readonly" required>
                                        </div>
                                      <div class="col-sm-4 form-group">
                                            <label>Bid Closing date   </label>
                                            <span class="text-danger">*</span>&nbsp;<span id="closingdate" name="closingdate1" class="text-danger"></span>
                                            <input class="form-control" name="closingdate" id="closingdate2" value="<%= closingdate %>" readonly="readonly" required>
                                        </div>
                                        
                                        
                                        <div class="col-sm-4 form-group"  style="display: none;"">
                                            <label "display:none;" >Lot Identification </label>
                                            <span class="text-danger">*</span>&nbsp;<span id="Lot_Identification" name="Lot_Identification" class="text-danger"></span>
                                            <input class="form-control" name="Lot_Identification" id="Lot_Identification" value="<%= lotid %>" readonly="readonly" required>
                                        </div>
                                    </div>
										<div class="row">
										     <div class="col-sm-4 form-group">
                                            <label>Quantity</label>
                                            <span class="text-danger">*</span>&nbsp;<span id="Qunatity1" name="Qunatity" class="text-danger"></span>
                                            <input class="form-control" name="Qunatity" id="Qunatity2" value="<%= lotsize %>" readonly="readonly" required>
                                        </div>
                                        <div class="col-sm-4 form-group">
                                            <label>Security Deposit Amount  </label>
                                            <span class="text-danger">*</span>&nbsp;<span id="Security_Deposit_Amount " name="Security_Deposit_Amount" class="text-danger"></span>
                                            <input class="form-control" name="Security_Deposit_Amount" id="Security_Deposit_Amount2" value="<%= securitydeposit%> " readonly="readonly" required>
                                        </div>
                                        <!-- 	<div class="col-sm-4 form-group" id="instrument">
												<label>Delivery Type</label> <span class="text-danger">*
												</span>&nbsp; <select name="DeliveryType" id="DeliveryType1"
													class="form-control taxtbox" required>
													<option value="">-Select-</option>
													<option value="Mill_Delivery">Mill Delivey</option>
													<option value="Ex-Godown">Ex-Godown</option>
												
												</select>
											</div> -->
                                     <div class="col-sm-4 form-group">
                                            <label>Remaining Time </label>
                                            <span class="text-danger">*</span>&nbsp;<span id="Remaining_time" name="Remaining_time1" class="text-danger"></span>
                                            <input class="form-control" name="Remaining_time2" id="Remaining_time3" value="" readonly="readonly" required>
                                        </div>  
                                        
										
										
											</div>
                                    <div class="row">
                                    <!-- 	<div class="col-sm-4 form-group" id="instrument">
												<label>Whether Claim is Allowed</label> <span class="text-danger">*
												</span>&nbsp; <select name="Claim_is_Allowed" id="Claim_is_Allowed1"
													class="form-control taxtbox" required>
													<option value="">-Select-</option>
													<option value="Yes">Yes</option>
													<option value="No">No</option>
												
												</select>
											</div> -->
                                    <!--     <div class="col-sm-4 form-group">
                                            <label>Quoted Base Price</label>
                                            <input class="form-control" name="Quoted_Base_Price" type="text" placeholder="Quoted_Base_Price" id="Quoted_Base_Price1" required>
                                            <div id="errorMessage" style="color: red; display: none;">Amount is lesser than the Sell price input high value!</div>
                                        </div>
                                        <div class="col-sm-4 form-group">
                                            <label>Bid Quote Document</label>
                                            <input class="form-control taxtbox" name="Bid_Quote_Document" id="Bid_Quote_Document" min="0" type="file" placeholder="Bid Quote Document" onchange="deleteErrorMsg()" required>
                                        </div> -->
                                        	 <div class="col-sm-2 form-group" >
												    <label  >basis </label> <span
													class="text-danger">* </span>&nbsp;  <input
													class="form-control" name="basis1"
													id="millname23" value="<%=basis %>" readonly="readonly">
											</div>
											   <div class="col-sm-4 form-group"style="display: none;>
                                            <label "display:none;">millname   </label>
                                            <span class="text-danger">*</span>&nbsp;<span id="Mill_name" name="Mill_name" class="text-danger"></span>
                                            <input class="form-control" name="Mill_name" id="Mill_name" value="<%= millname1 %>" readonly="readonly" required>
                                        </div>
											
											 <div class="col-sm-2 form-group"  style="display: none;">
												    <label "display:none;" >Millcode</label> <span
													class="text-danger">* </span>&nbsp;  <input
													class="form-control" name="millcode234"
													id="millname23" value="<%=millcode %>" readonly="readonly">
											</div>
                                    </div>


                                    <div class="table-container">
                                    <div class="table-scroll">
								  <table id="lottable" name="lottable" class="table table-bordered">
											    <thead class="thead-light">
											        <tr>
											           
											             <th>Lot Id </th>
											              <th>Region</th>
											              <th>JuteVariety</th>
											              <th>CropYear</th>
											              <th>Grade1</th>
											              <th>Grade2</th>
											              <th>Grade3</th>
											              <th>Grade4</th>
											              <th>Grade5</th>
											              <th>Grade6</th>
											              <th>Grade7</th>
											              <th>Grade8</th>
											              <th>Total</th>
											              <th> Delivery Type</th>
											          <th> Reserved Sale price(Mill delivery)</th> 
											          <th> Reserved Sale price(Ex godown)</th>
											           	
											              <th> Quote</th>
											            
											            
											         </tr>
											    </thead>
											    <tbody>
											        <!-- Data rows will be dynamically added here -->
											    </tbody>
											</table>
											</div>
											</div>
											<div class="row">
											<!--    <div class="col-sm-4 form-group">
                                            <label>Sell value </label>
                                            <span class="text-danger">*</span>&nbsp;<span id="sell_value " name="sell_value1" class="text-danger"></span>
                                            <input class="form-control" type="number" name="sell_value2" id="sell_value3"   required>
                                        </div> -->
                                        	 <div class="col-sm-2 form-group" style= "display:none;" >
												    <label  "display:none;" >rowindex </label> <span
													class="text-danger">* </span>&nbsp;  <input
													class="form-control" name="rowindex2"
													id="rowindex2" value="" readonly="readonly">
											</div>
											  <div class="col-sm-2 form-group" style="display: none;">
												    <label  "display:none; >indexes </label> <span
													class="text-danger">* </span>&nbsp;  <input
													 type="hidden" class="form-control" name="index"
													id="indexses" value="" readonly="readonly">
													 <input
													 type="hidden" class="form-control" name="hideData"
													id="hideData" value="" readonly="readonly">
											</div>
											
										<!-- 	 <div class="col-sm-2 form-group"   >
												    <label  >frieght </label> <span
													class="text-danger">* </span>&nbsp;  <input
													class="form-control" name="frieght1"
													id="frieght" value="" readonly="readonly">
											</div>
											<div class="col-sm-2 form-group"  >
												    <label  >exgodown </label> <span
													class="text-danger">* </span>&nbsp;  <input
													class="form-control" name="exgodown"
													id="exgodown" value="" readonly="readonly">
											</div> -->
                                        </div>
											
											
											
                                    <div class="row">
                                        <div class="col-sm-12 form-group">
                                            <input type="submit" value="Submit" class="btn btn-primary" id="submit">
                                        </div>
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




<script type="text/javascript">
$(document).ready(function() {
    var lotid = "<%=lotid %>";

    // Fetch the main data
    $.ajax({
        type: 'GET',
        url: 'creationdetails.obj',
        data: { "lotid": lotid },
        success: function(data) {
            try {
                var dataArray = JSON.parse(data);
                var index = 0;

                dataArray.forEach(function(row) {
                    var lotid = row[0];
                    var exgodown_value = row[13];

                    var rowHtml = '<tr>' +
                        '<td>' +
                        '<div class="table2-cell"><input type="hidden" name="lotid[]" value="' + row[0] + '"> ' + row[0] + '</div>' +
                        '</td>' +
                        '<td>' +
                        '<div class="table2-cell"><input type="hidden" name="region[]" value="' + row[1] + '">' + row[1] + '</div>' +
                        '</td>' +
                        '<td>' +
                        '<div class="table2-cell"><input type="hidden" name="jutevariety[]" value="' + row[2] + '">' + row[2] + '</div>' +
                        '</td>' +
                        '<td>' +
                        '<div class="table2-cell"><input type="hidden" name="cropYear[]" value="' + row[3] + '">' + row[3] + '</div>' +
                        '</td>' +
                        '<td>' +
                        '<div class="table2-cell"><input type="hidden" name="grade1[]" value="' + row[4] + '">' + row[4] + '</div>' +
                        '</td>' +
                        '<td>' +
                        '<div class="table2-cell"><input type="hidden" name="grade2[]" value="' + row[5] + '">' + row[5] + '</div>' +
                        '</td>' +
                        '<td>' +
                        '<div class="table2-cell"><input type="hidden" name="grade3[]" value="' + row[6] + '">' + row[6] + '</div>' +
                        '</td>' +
                        '<td>' +
                        '<div class="table2-cell"><input type="hidden" name="grade4[]" value="' + row[7] + '">' + row[7] + '</div>' +
                        '</td>' +
                        '<td>' +
                        '<div class="table2-cell"><input type="hidden" name="grade5[]" value="' + row[8] + '">' + row[8] + '</div>' +
                        '</td>' +
                        '<td>' +
                        '<div class="table2-cell"><input type="hidden" name="grade6[]" value="' + row[9] + '">' + row[9] + '</div>' +
                        '</td>' +
                        '<td>' +
                        '<div class="table2-cell"><input type="hidden" name="grade7[]" value="' + row[10] + '">' + row[10] + '</div>' +
                        '</td>' +
                        '<td>' +
                        '<div class="table2-cell"><input type="hidden" name="grade8[]" value="' + row[11] + '">' + row[11] + '</div>' +
                        '</td>' +
                        '<td>' +
                        '<div class="table2-cell"><input type="hidden" name="totalqty[]" value="' + row[12] + '">' + row[12] + '</div>' +
                        '</td>' +
                        '<td>' +
                        '<div class="table2-cell">' +
                        '<select id="deliverytype' + index + '" name="Nomination[]" required>' +
                        '<option value="0">Select</option>' +
                        '<option value="Mill Delivery">Mill Delivery</option>' +
                        '<option value="Ex-Godown">Ex Godown</option>' +
                        '</select>' +
                        '</div>' +
                        '</td>' +
                        '<td>' +
                        '<div class="table2-cell"><input id="Reserved_sell_priceMill' + index + '" name="Reserved_sell_price(Mill_Delivery)[]" value="" readonly="true"></div>' +
                        '</td>' +
                        '<td>' +
                        '<div class="table2-cell"><input id="Reserved_sell_priceEX' + index + '" name="Reserved_sell_price(Ex_Godown)[]" value="' + row[13] + '" readonly="true"></div>' +
                        '</td>' +
                        '<td>' +
                        '<div class="table3-cell">' +
                        '<input type="number" id="sell_value' + index + '" name="sell_value[]" value="">' +
                        '<div id="errorMessage' + (index + 1) + '" class="error-message">Value must be greater than sell price.</div>' +
                        '</div>' +
                        '</td>' +
                        '<td><div class="table-cell"><input type="checkbox" id="checkbox_' + index + '" name="selectRow[]" class="invoice-checkbox"></div></td>' +
                        '</tr>';

                    $('#lottable tbody').append(rowHtml); // Append rowHtml to your table or container
                    fetchFreightValue(lotid, exgodown_value, index); // Pass the index as well
                    index++;
                    $('#rowindex2').val(index);
                });

                // Checkbox change event
                $('.invoice-checkbox').on('change', function() {
                    if ($(this).is(':checked')) {
                        let closestRow = $(this).closest('tr');
                        let rowIndex = closestRow.index();
                        updateBalanceIndex(rowIndex);
                    }
                });

            } catch (e) {
                console.error("Error parsing JSON data:", e);
            }
        },
        error: function(xhr, status, error) {
            console.error('AJAX error:', error);
        }
    });

    function fetchFreightValue(lotid, exgodown_value, index) {
        $.ajax({
            type: 'GET',
            url: 'freightValue.obj',
            data: { "lotid": lotid },
            success: function(data) {
                try {
                    var dataArray = JSON.parse(data);
                    console.log("Received data array:", dataArray);
                    var foundFreight = false;

                    for (var i = 0; i < dataArray.length; i++) {
                        for (var j = 0; j < dataArray[i].length; j++) {
                            if (dataArray[i][j] === "Freight (Rs/Qtl)") {
                                // Assuming the value is right after "Freight"
                                var nextValue = parseFloat(dataArray[i][j + 1]) + parseFloat(exgodown_value);
                                console.log("Freight value found and added to Ex-Godown value:", nextValue);
                                // Update the specific Mill Delivery field for the current row
                                $('#Reserved_sell_priceMill' + index).val(nextValue);
                                foundFreight = true;
                                break;
                            }
                        }
                        if (foundFreight) break;
                    }

                    if (!foundFreight) {
                        console.log("Freight not found or no value follows 'Freight'");
                    }

                } catch (e) {
                    console.error("Error parsing JSON data:", e);
                }
            },
            error: function(xhr, status, error) {
                console.error('AJAX error:', error);
            }
        });
    }

    function updateBalanceIndex(idx) {
        let selectedRowIndices = [];

        $('.invoice-checkbox:checked').each(function() {
            let closestRow = $(this).closest('tr');
            let rowIndex = closestRow.index();
            selectedRowIndices.push(rowIndex);
        });

        $('#indexses').val(selectedRowIndices.join(','));
        console.log(selectedRowIndices);
    }
});
</script>


<%
    // Format date on the server side
    DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
    DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");
    String bidClosingDateStr = (String) request.getAttribute("closingdate");

    LocalDateTime bidClosingDate = LocalDateTime.parse(bidClosingDateStr, inputFormatter);
    String bidClosingDateFormatted = bidClosingDate.format(outputFormatter);
%>
<script>
    var closingDate = "<%= bidClosingDateFormatted %>"; // Pass formatted date to JavaScript
</script>


<script>
document.addEventListener("DOMContentLoaded", function() {
    function updateCountdown() {
        // Ensure closingDate is a valid date string
        let bidClosingDate = new Date(closingDate); // Use the formatted date from JSP
        let now = new Date();

        // Calculate the remaining time
        let remainingTime = bidClosingDate - now;

        // If the duration is negative, set it to zero
        if (remainingTime < 0) {
            remainingTime = 0;
        }

        // Convert remaining time to days, hours, and minutes
        let days = Math.floor(remainingTime / (1000 * 60 * 60 * 24));
        let hours = Math.floor((remainingTime % (1000 * 60 * 60 * 24)) / (1000 * 60 * 60));
        let minutes = Math.floor((remainingTime % (1000 * 60 * 60)) / (1000 * 60));
        let seconds = Math.floor((remainingTime % (1000 * 60)) / 1000);


        // Format the remaining time string
        let justTime1 = days + " days " + hours + ":" + minutes + " :"+seconds+"";
        $('#Remaining_time3').val(justTime1);
        // Update the time element
        let timeElement = document.getElementById("time"); // Use the correct ID selector
        if (timeElement) {
            timeElement.textContent = justTime1;
        }

        // Check if the time is zero and disable the button if needed
        if (remainingTime <= 0) {
          
            let button = document.getElementById("submit"); // Correctly select the button by ID
            if (button) {
                button.disabled = true;
            }
        }
    }

    // Initial call to set the countdown immediately
    updateCountdown();

    // Update the countdown every minute
    setInterval(updateCountdown, 1000); // 60,000 milliseconds = 1 minute
});
</script>


<script type="text/javascript">
$(document).ready(function() {  
    // Form submission validation
    document.getElementById("submit").addEventListener("click", function(event) {
        var isValid = true;
        var hasCheckedRows = false;

        // Get all select elements and input elements with the name "Nomination[]" and "sell_value[]"
        var selectElements = document.getElementsByName("Nomination[]");
        var inputElements = document.getElementsByName("sell_value[]");

        // Iterate over each row
        for (var i = 0; i < selectElements.length; i++) {
            // Check if the checkbox in this row is checked
            var checkbox = document.getElementById('checkbox_' + i);
            if (checkbox && checkbox.checked) {
                hasCheckedRows = true; // At least one checkbox is checked

                var selectedValue = selectElements[i].value;
                var sellValue = parseFloat(inputElements[i].value) || 0;
                var maxAllowedAmount;

                if (selectedValue === "0") {
                    alert("Please select a delivery type for row " + (i+1));
                    selectElements[i].focus();
                    isValid = false;
                    break;
                }

                // Determine maxAllowedAmount based on selectedValue
                if (selectedValue === "Mill Delivery") {
                    maxAllowedAmount = parseFloat($('#Reserved_sell_priceMill' + i).val()) || 0;
                } else if (selectedValue === "Ex-Godown") {
                    maxAllowedAmount = parseFloat($('#Reserved_sell_priceEX' + i).val()) || 0;
                } else {
                    maxAllowedAmount = 0; // Default or undefined delivery type
                }

                // Validate the sell value
                if (sellValue === 0) {
                    alert("Sell value cannot be zero for row " + (i+1));
                    inputElements[i].focus();
                    isValid = false;
                    break;
                }

                if (!validateAmount(sellValue, maxAllowedAmount, inputElements[i], i)) {
                    isValid = false;
                }
            }
        }

        // Check if at least one checkbox is checked
        if (!hasCheckedRows) {
            alert("Please select at least one checkbox.");
            isValid = false;
        }

        // Prevent form submission if validation fails
        if (!isValid) {
            event.preventDefault();
        }
    });

    function validateAmount(inputValue, maxAllowedAmount, inputElement, index) {
        var errorMessageElement = document.getElementById("errorMessage" + (index + 1));

        if (isNaN(inputValue)) {
            inputValue = 0; // Treat NaN as 0 for validation
        }

        if (inputValue < maxAllowedAmount) {
            errorMessageElement.style.display = "block"; // Show error message
            inputElement.value = ""; // Clear the input value
            inputElement.focus(); // Focus the input field
            return false; // Prevent form submission
        } else {
            errorMessageElement.style.display = "none"; // Hide error message
            return true; // Allow form submission
        }
    }
});
</script>


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
