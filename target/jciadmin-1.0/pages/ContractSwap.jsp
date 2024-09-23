<%@page import="java.util.List"%>
<%@page import="com.jci.common.Encry"%>

<%@page import="com.jci.model.ZoneModel"%>
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
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<!-- PLUGINS STYLES-->
<!-- THEME STYLES-->
<link href="assets/css/main.min.css" rel="stylesheet" />
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
<script src="https://code.jquery.com/ui/1.13.2/jquery-ui.js"></script>

<!-- PAGE LEVEL STYLES-->

<script src="https://cdn.rawgit.com/harvesthq/chosen/gh-pages/chosen.jquery.min.js"></script>
<link href="https://cdn.rawgit.com/harvesthq/chosen/gh-pages/chosen.min.css" rel="stylesheet"/>


</head>
<style>
.container {
  display: grid;
  grid-template-columns: 0fr 9fr;
}

.farmerdetails {
    margin-bottom: 20px;
    margin-top: -50px;
    font-size: 20px;
    font-family: ui-monospace;
    color: darkblue;
}
  .cancel-button {
        background-color: green; /* Change to blue if needed */
        color: white;
        border: none;
        padding: 10px 15px;
        text-align: center;
        text-decoration: none;
        display: inline-block;
        font-size: 10px;
        margin: 4px 2px;
        cursor: pointer;
        border-radius: 4px;
    }
    
    .cancel-button:hover {
        background-color: darkgreen; 
    }

</style>
<!-- <script>
$(document).ready(function(){
$(".chosen-region").chosen({
	  no_results_text: "Oops, nothing found!"
	});
	
$(".chosen-dpc").chosen({
  no_results_text: "Oops, nothing found!"
});
	
$(".chosen-bin").chosen({
  no_results_text: "Oops, nothing found!"
});
});
</script> -->
<body class="fixed-navbar">
    <div class="page-wrapper">
        <!-- START HEADER  -->
        <%@ include file="header.jsp"%>
        <!-- END HEADER-->
        
        <!-- START SIDEBAR-->
        <%@ include file="sidebar.jsp"%>
        <!-- END SIDEBAR-->
        
        <div class="content-wrapper">
            <!-- START PAGE CONTENT-->
            <div class="page-heading">
            
                <h1 class="page-title">Contract Swap</h1>
            </div>
            <% 
            	
            String dpcCenter = (String) session.getAttribute("dpc_center");
            String dpcid = (String) session.getAttribute("dpcId");		
			List<Object[]> bids = (List<Object[]>) request.getAttribute("bidId");	
			String  keyid1 = (String) request.getAttribute("keyid");	
                String closingdate="";
               
            %>
         <div class="page-content fade-in-up">
                <div class="row">
                    <div class="col-md-11">
                        <div class="ibox">
                            <span>${msg}</span>
                            <div class="ibox-body">
                                <form name="myForm" autocomplete="off">
                                    <div class="row">
                                        <div class="col-sm-4 form-group">
                                            <label for="bidNo">Bid Reference No</label>
                                            <span class="text-danger">* </span>
                                            <span id="errcropyr" name="errcropyr" class="text-danger"></span>
                                            <select class="form-control" name="bidNo" id="bidNo">
                                                <option value="select">-Select-</option>
                                                <%
                                                for (Object[] row : bids) {
                                                    String bidref = (String) row[0];
                                                    closingdate = (String) row[1];
                                                %>
                                                <option value="<%=bidref%>" data-closingdate="<%=closingdate%>"><%=bidref%></option>
                                                <%
                                                }
                                                %>
                                            </select>
                                        </div>
                                    </div>

                                    <div class="scrollmenu" id="example-table" style="display: none;">
                                        <table class="table table-striped table-bordered table-hover" cellspacing="0" width="150%">
                                            <thead>
                                                <tr>
                                                    <th>Bid Reference No.</th>
                                                  
                                                    <th>Mill Name</th>
                                                    <th>Quoted Base Price</th>
                                                <th>Bid Rank</th> 
                                                <th>Quantity</th> 
                                                <th>Quantity Alloted</th> 
                                                </tr>
                                            </thead>
                                            <tbody id="table-body">
                                                <!-- Table body will be dynamically populated -->
                                            </tbody>
                                        </table>
                                    </div>

                                    <div class="form-group">
                                        <button class="btn btn-primary" type="button" onclick="result()">Show Result</button>
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
    
    <div class="sidenav-backdrop backdrop"></div>	
	

    
    <!-- PAGE LEVEL PLUGINS-->
    <!-- CORE SCRIPTS-->
    <script src="assets/js/app.min.js" type="text/javascript"></script>
    <!-- PAGE LEVEL SCRIPTS-->
</body>

<script type="text/javascript">

function parseDateString(dateString) {
    var parts = dateString.split(/[- :]/); // Split by dashes, spaces, and colons
    var day = parseInt(parts[0], 10);
    var month = parseInt(parts[1], 10) - 1; // Month is zero-based in JavaScript Date
    var year = parseInt(parts[2], 10);
    var hours = parseInt(parts[3], 10);
    var minutes = parseInt(parts[4], 10);
    return new Date(year, month, day, hours, minutes);
}

  function result() {
       
        
        var selectedOption = $("#bidNo option:selected");
        var bid = selectedOption.val();
        var closingDateStr = selectedOption.attr("data-closingdate");

        if (!bid || closingDateStr === undefined) {
            alert("Please select a valid bid reference.");
            return;
        }
      
       
        

         var specificDate = parseDateString(closingDateStr);
         var currentDate = new Date();

         if (specificDate < currentDate) {
             alert("Yes, the closing date is before the current date.");
         } else {
             alert("No, the closing date is not before the current date.");
         }
         
      // Define the decryption function outside the AJAX success callback
        function decrypt(encryptedValue, key) {
    console.log("Attempting to decrypt...");
    console.log("Encrypted value:", encryptedValue);
    console.log("Decryption key:", key);

    if (typeof Encry !== "undefined" && Encry.decrypt) {
        try {
            var decryptedValue = Encry.decrypt(encryptedValue, key);
            console.log("Decrypted value:", decryptedValue);
            return decryptedValue;
        } catch (error) {
            console.error("Decryption error:", error);
            return encryptedValue; // Fallback to the encrypted value if decryption fails
        }
    } else {
        console.error("Encry.decrypt function is not available or Encry is undefined.");
        return encryptedValue; // Fallback to the encrypted value if decryption function is missing
    }
}


        $.ajax({
            type: "GET",
            url: "findH1Bidder.obj",
            data: { "bidNo": bid },  // Ensure 'bid' is defined and contains the correct value
            success: function(data) {
                // For debugging purposes, remove in production
                const dataArray = JSON.parse(data);
                $("#table-body").empty(); 
                var table = document.getElementById("example-table");
                table.style.display = "table";
                let millNamesWithRank1 = [];// Display the table if hidden initially
                
                if (dataArray.length > 0) {
                    // Sort dataArray based on rank (index 3)
                    dataArray.sort(function(a, b) {
                        return a[3] - b[3]; // Compare based on rank
                    });
                    
                    // Iterate through the sorted dataArray
                    dataArray.forEach(function(rowData1) {
                    	  if (rowData1[3] == 1) {
                             
                             millNamesWithRank1.push(rowData1[1]);
                         }
               
                        var cancelButton = "";
                        
                        // Add cancel button if rank (index 3) is 1
                        if (rowData1[3] === 1) {
                            cancelButton = "<button  class='cancel-button' onclick='cancelBid(\"" + rowData1[0] + "\",\"" + rowData1[1] + "\",\"" + rowData1[2] + "\",\"" + millNamesWithRank1 + "\")'>Cancel</button>";
                        }
                        
                        var row = "<tr>" +
                            "<td>" + rowData1[0] + "</td>" +
                            "<td>" + rowData1[1] + "</td>" +
                            "<td>" + rowData1[2] + "</td>" +
                            "<td>" + rowData1[3] + "</td>" +
                            "<td>" + rowData1[4] + "</td>" +
                            "<td>" + rowData1[5] + "</td>" +
                            "<td>" + cancelButton + "</td>" +
                            "</tr>";
                        
                        $("#table-body").append(row); // Append row to the table body
                    });
                   
                }
            },
            error: function(xhr, status, error) {
                console.error("AJAX error:", status, error);
            }
        });
    }

    function cancelBid(bidId, millName, quotedPrice,millNamesWithRank1) {
        // Handle bid cancellation logic here
        
        $.ajax({
            type: "GET",
            url: "contractswap.obj",
            data: { "bidNo": bidId,
            	    "millname": millName,
            	    "Quotedprice": quotedPrice },  // Ensure 'bid' is defined and contains the correct value
            success: function(data) {
               // For debugging purposes, remove in production
                const dataArray = JSON.parse(data);
                $("#table-body").empty(); 
                var table = document.getElementById("example-table");
                table.style.display = "table";  // Display the table if hidden initially
                let millNamesWithRank1 = [];
                if (dataArray.length > 0) {
                    // Sort dataArray based on rank (index 3)
                    dataArray.sort(function(a, b) {
                        return a[3] - b[3]; // Compare based on rank
                    });
                    
                    // Iterate through the sorted dataArray
                    dataArray.forEach(function(rowData1) {
                    	  if (rowData1[3] == 1) {
                             
                             millNamesWithRank1.push(rowData1[1]);
                         }
                        var cancelButton = "";
                        
                        // Add cancel button if rank (index 3) is 1
                        if (rowData1[3] === 1) {
                            cancelButton = "<button  class='cancel-button' onclick='cancelBid(\"" + rowData1[0] + "\",\"" + rowData1[1] + "\",\"" + rowData1[2] + "\",\"" + millNamesWithRank1 + "\")'>Cancel</button>";
                              }
                        
                        var row = "<tr>" +
                            "<td>" + rowData1[0] + "</td>" +
                            "<td>" + rowData1[1] + "</td>" +
                            "<td>" + rowData1[2] + "</td>" +
                            "<td>" + rowData1[3] + "</td>" +
                            "<td>" + rowData1[4] + "</td>" +
                            "<td>" + rowData1[5] + "</td>" +
                            "<td>" + cancelButton + "</td>" +
                            "</tr>";
                        
                        $("#table-body").append(row); // Append row to the table body
                    });
                    
                }
                
                var millnames = millNamesWithRank1;
               
                
                $.ajax({
                    type: "GET",
                    url: "h1bidderEmail.obj",
                    data: {"millnames": JSON.stringify(millnames)}, // Serialize list as JSON
                    success: function(response) {
                    
                        console.log("Data successfully sent to the controller:", response);
                    },
                    error: function(xhr, status, error) {
                        console.error("Error sending data to controller:", status, error);
                    }
                });
                
            },
            error: function(xhr, status, error) {
                console.error("AJAX error:", status, error);
            }
        });
    }
     
    
  
     </script>


<link rel="stylesheet" href="//code.jquery.com/ui/1.13.2/themes/base/jquery-ui.css">
<link rel="stylesheet" href="/resources/demos/style.css">
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
<script src="https://code.jquery.com/ui/1.13.2/jquery-ui.js"></script>
	
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>

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
   
	<script src="assets/css/chosen.jquery.js" type="text/javascript"></script>
  <script src="assets/css/docsupport/prism.js" type="text/javascript" charset="utf-8"></script>
  <script src="assets/css/docsupport/init.js" type="text/javascript" charset="utf-8"></script> 

  <link rel="stylesheet" href="assets/css/docsupport/prism.css">
  <link rel="stylesheet" href="assets/css/chosen.css">
  
  
</html>
