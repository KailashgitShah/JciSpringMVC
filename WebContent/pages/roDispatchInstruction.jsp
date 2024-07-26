<%@page import="java.util.List"%>
<%@page import="java.time.LocalDate"%>
<%@page import="java.time.LocalDateTime"%>
<%@page import="java.time.format.DateTimeFormatter"%>
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
<link rel="stylesheet" href="assets/css/chosen.css">
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

.required:after {
	content: " *";
	color: red;
}
</style>

</head>

<%
List<String> allDpc = (List<String>) request.getAttribute("loadAllDpc");
List<String> allHoDiNo = (List<String>) request.getAttribute("loadAllDiNo");
List<String> allCooperative = (List<String>) request.getAttribute("loadAllCooperativesList");
%>


<body class="fixed-navbar">
<div class="contractLoader">
		<img src="assets/img/1488.gif">
	</div>
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
				<h1 class="page-title">Dispatch Instruction (RO)</h1>
			</div>


			<div class="page-content fade-in-up">
				<div class="row">
					<div class="col-md-11">
						<div class="ibox">
							<div id='success'
								style='display: none; text-align: center; background-color: #4CAF50; color: white;'>

							</div>

							<div id='errorcontainer'
								style='display: none; text-align: center;'></div>
								<div id='dpcerror'
								style='display: none; text-align: center;'></div>
							<div class="ibox-body">
							

								<!-- <form action="saveRoDi.obj" method="POST"> -->
								<div class="row">


									<div class="col-sm-4 form-group">
										<label>HO DI No.</label><span class="text-danger">* </span>&nbsp;
										<select name="hoDiNo" id="hoDiNo" class="form-control"
											required>
											<option value="-1" selected disabled>-Select-</option>
											<%
											for (String no : allHoDiNo) {
											%>
											<option value="<%=no%>"><%=no%></option>
											<%
											}
											%>
										</select>
									</div>


									<div class="col-sm-4 form-group">
										<label>HO DI Date</label> <input class="form-control"
											name="hoDiDate" id="hoDiDate" type="text" value="" placeholder="HO DI Date" readonly>
									</div>

									<div class="col-sm-4 form-group">
										<label>Contract No</label> <input class="form-control "
											name="contractNo" id="contractNo" type="text" placeholder="Contract No"  value=""
											readonly>
									</div>
								</div>

								<div class="row">

									<div class="col-sm-4 form-group">
										<label>Contract Date</label> <input class="form-control"
											name="contractDate" id="contractDate" placeholder="Contract Date" type="text" value=""
											readonly>
									</div>

									<div class="col-sm-4 form-group">
										<label>Crop year </label> <input class="form-control"
											id="cropYear" name="CropYear" placeholder="Crop Year" type="text" readonly>
									</div>
									<div class="col-sm-4 form-group">
										<label>DPC/Cooperative</label> <span class="text-danger">* </span>&nbsp;<select
											name="dpc" id="dpc" class="form-control" required>
											<option value="-1" disabled selected>-Select-</option>
											<%
											for (String no : allCooperative) {
												
													String[] element=no.split("!");
												%>
												<option value="<%=element[0]%>"><%=element[1]%></option>
											
											
											<%
											}
											%>
										</select> <a href="#" style="color: blue;">Inventory DPC Wise</a>
									</div>


								</div>


								<div class="row">


									<div class="col-sm-4 form-group">
										<label>RO DI No</label> <input placeholder="RO DI No" class="form-control"
											name="roDiNo" id="roDiNo" type="text" readonly>
									</div>

									<div class="col-sm-4 form-group">
										<label>RO DI Date</label> <input class="form-control" placeholder="RO DI Date"
											name="roDiDate" id="roDiDate" type="text" readonly>
									</div>

									<div class="col-sm-4 form-group">
										<label>Last date of Shipment </label><span class="text-danger">*
										</span>&nbsp;<input class="form-control" name="lastDateOfShipment"
											id="lastDateOfShipment" type="date" placeholder="Last Date of Shipment"
											placeholder="last date of shipment" required />
									</div>

								</div>
								<div class="row">
									<div class="col-sm-4 form-group">


										<label>Remarks </label> <span class="text-danger"> </span>
										<textarea class="form-control taxtbox" name="Remarks"
											placeholder="Remarks"  maxlength="250" id="remarks"></textarea>


									</div>



									<input type="hidden" name="allowedQty" id="allowedQty" />
									

								</div>
								<div class="row">
								<div class="col-sm-8 form-group">
										<label id="lblName"></label>
										<div id="form3"></div>
										<span id="misQty"></span>
									</div>
								</div>
								<div class="row">
								<div class="col-sm-8 form-group">
									<label id="lblName"></label>
									<div id="form2"></div>
									<span id="misQty"></span>
								</div>
								</div>
								<br>
								<div class="row">

									<div class="col-sm-12 form-group">
										<input type="submit" value="Submit" class="btn btn-primary"
											id="submit">
									</div>
								</div>
								<!-- </form> -->
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
//Bind change event handler to #hoDiNo and #dpc
$('#hoDiNo, #dpc').change(function() {
    // Retrieve values from the select elements
    var dpc = $('#dpc').val();
    var hoDiNo = $('#hoDiNo').val();

    // Make the AJAX call
    $.ajax({
        type: "GET",
        url: "dpcCheck.obj",
        data: {
            "dpc": dpc,
            "hoDiNo": hoDiNo
        },
        success: function(result) {
            var data = jQuery.parseJSON(result);
            c1 = data; // Parsing and assigning the value

            // Alert or use check1 within the success callback
            //alert(c1);
            console.log("check:---" + c1);
            if(c1==="0"){
            $('#submit').prop('disabled', true);
            var errorMessage = " DI has been issued for this DPC/Cooperative" ;
            var errorDiv = $("<div>").text(errorMessage).css({
                "color": "red",
                "font-weight": "bold"
            });
            $("#dpcerror").append(errorDiv).show(); // Show the error container
            window.scrollTo(0, 0);
            setTimeout(function() {
                $("#dpcerror").empty().hide(); // Clear and hide the error message after 5 seconds
            }, 5000);
            }
            else{
            	 $("#dpcerror").empty().hide();
            	 $('#submit').prop('disabled', false);
            }
            // Any further operations dependent on check1 should be done here
        },
        error: function(xhr, status, error) {
            console.error("Error: " + error);
        }
    });
});

</script>
	<script>
	// Get today's date in string format
	const currentDate = new Date();
	const day = String(currentDate.getDate()).padStart(2, '0');
	const month = String(currentDate.getMonth() + 1).padStart(2, '0'); // Months are zero-based
	const year = String(currentDate.getFullYear());
	const formattedDate = day + "-" + month + "-" + year;
	const minDateOfShipment = year + "-" + month + "-" + day;

	$('#roDiDate').val(formattedDate);

	$("#hoDiNo").on("change", function() {
	    var val = $(this).val();
		var size;
	    $.ajax({
	        type: "GET",
	        url: "getContractDetails.obj",
	        data: {
	            "diNo": val
	        },
	        success: function(result) {
	            var data = jQuery.parseJSON(result);

	            var numberOfContractDetails = data.contractDetails.length;
	            size=numberOfContractDetails;
	            var contract = data.contractDetails[0];
	            var count = data.count + 1;

	            var contractData = data.contractDetails[0][10];
	            var dataArray = contractData.split(',');

	            var dpcDropdown = $('#dpc');
	            var allOptions = [];

	            dataArray.forEach(function(value) {
	                if (value !== null && value !== undefined && value !=='') {
	                    allOptions.push(value);
	                }
	            });
	            dataArray.forEach(function(value) {
	                // Check if value is null, undefined, or an empty string
	                if (value === null || value === undefined || value === '') {
	                    // If the value meets the condition, execute the following code
	                    <% for (String no : allCooperative) {
	                        String[] commaSD = no.split(",");
	                        for(String s : commaSD) { %> 
	                            allOptions.push("<%= s %>");
	                        <% }
	                    } %>
	                }
	            });

	            
	           
	            	
	           
      

	            dpcDropdown.empty();
				dpcDropdown.append($('<option>',{
					value:"-1",
					text:"Select"
				}));
	            allOptions.forEach(function(value) {
	            	
	            	var code = value.split("!");
	                dpcDropdown.append($('<option>', {
	                    value: code[0],
	                    text: code[1]
	                }));
	            });

	            $("#contractDate").val(contract[2]);
	            $("#contractNo").val(contract[3]);
	            $("#cropYear").val(contract[7]);
	            $("#roDiNo").val(val + "/0" + count);

	            const unFormatedDate = contract[21].split("-");
	            const lastDateOfShipment = unFormatedDate[2] + "-" + unFormatedDate[1] + "-" + unFormatedDate[0];

	            const today = new Date();
	            const year = today.getFullYear();
	            const month = String(today.getMonth() + 1).padStart(2, '0');
	            const day = String(today.getDate()).padStart(2, '0');
	            const todayDate = year + "-" + month + "-" + day;

	            $("#lastDateOfShipment").val(lastDateOfShipment).attr({
	                "max": lastDateOfShipment,
	                "min": todayDate
	            });

	            $('#hoDiDate').val(contract[6].substring(0, contract[6].length - 8));

	            var juteArray = [];
	            $("#form2").html("");
	            var elementToUpdate = $("#form2");
	            var contentToDisplay = "<table id='table_r' style='border-collapse: collapse;width: 100%;'>";
	            var headerDisplayed = false;

	            for (var k = 0; k < numberOfContractDetails; k++) {
	                contentToDisplay += "<tr>";

	                if (!headerDisplayed) {
	                    contentToDisplay += "<th style='border: 1px solid black;text-align: center;'>Jute Variety</th><th style='text-align: center; border: 1px solid black;'>Specification</th><th style='text-align: center; border: 1px solid black;'>Grade 1</th><th style='text-align: center; border: 1px solid black;'>Grade 2</th><th style='text-align: center; border: 1px solid black;'>Grade 3</th><th style='text-align: center; border: 1px solid black;'>Grade 4</th><th style='text-align: center; border: 1px solid black;'>Grade 5</th><th style='text-align: center; border: 1px solid black;'>Grade 6</th><th style='text-align: center; border: 1px solid black;'>Grade 7</th><th style='text-align: center; border: 1px solid black;'>Grade 8</th><th style='text-align: center; border: 1px solid black;'>Total</th>";
	                    headerDisplayed = true;
	                    contentToDisplay += "</tr>";
	                } else {
	                    contentToDisplay += "<td style=' text-align: center;border: 1px solid black;'> </td>";
	                }

	                contentToDisplay += "<tbody id='body'>";
	                contentToDisplay += "<tr>";
	                contentToDisplay += "<td rowspan='5' id='juteVariety' name='juteVariety' style='text-align: center; border: 1px solid black; color:'blue''> <span style='color: blue;'>"+ data.contractDetails[k][20]+"</span></td>";

	                juteArray.push(data.contractDetails[k][20]);

	                contentToDisplay += "<td style='border: 1px solid black;text-align: center;'>DI Received</td>";
	                var t1 = 0;

	                for (var i = 1; i <= 8; i++) {
	                    t1 += parseFloat(data.contractDetails[k][11 + i].toFixed(2));
	                    contentToDisplay += "<td style='text-align: center; border: 1px solid black;'><input type='number' id='DI_" + k + i + "' style='width: 70px;' value='" + parseFloat(data.contractDetails[k][11 + i].toFixed(2))+ "' readonly></td>";
	                }

	                t1 = parseFloat(t1.toFixed(2)); 

	                contentToDisplay += "<td style='text-align: center; border: 1px solid black;'>" + t1 + "</td></tr>";
	                contentToDisplay += "<tr>";
	                contentToDisplay += "<td style='text-align: center; border: 1px solid black;'>Allocated</td>";

	                for (var i = 1; i <= 8; i++) {
	                    contentToDisplay += "<td style='text-align: center; border: 1px solid black;'><input type='number' id='alloc_" + k +""+ i+"' style='width: 70px;' value='0' readonly></td>";
	                }
	                contentToDisplay += "<td style='text-align: center; border: 1px solid black;'><input type='number' id='total_alloc" + k + "' style='width: 70px;' value='0' readonly></td></tr>";

	                contentToDisplay += "<tr>";
	                contentToDisplay += "<td style='text-align: center; border: 1px solid black;'>Balance</td>";

	                for (var i = 1; i <= 8; i++) {
	                    contentToDisplay += "<td style='text-align: center; border: 1px solid black;'><input type='number' id='bal_" + k +""+ i+"' style='width: 70px;' value='0' readonly></td>";
	                }

	                contentToDisplay += "<td style='text-align: center; border: 1px solid black;'><input type='number' id='total_bal" + k + "' style='width: 70px;' value='0' readonly></td></tr>";

	                contentToDisplay += "<tr>";
	                contentToDisplay += "<td style='text-align: center; border: 1px solid black; color: blue;'><strong>DI Issue</strong></td>";

	                for (var i = 1; i <= 8; i++) {
	                    if (data.contractDetails[k][20] == "Mesta" || data.contractDetails[k][20] == "Bimli") {
	                        if (i >= 7) {
	                        	contentToDisplay += "<td style='text-align: center; border: 1px solid black;' value='0'><input type='number' id='GR" + i + "_QTY' style='width: 70px;' value='0' disabled min='0'></td>";
	                        } else {
	                            contentToDisplay += "<td style='text-align: center; border: 1px solid black;'><input type='number' id='GR" + k+i + "_QTY' style='width: 70px;' value=0 min='0'></td>";
	                        }
	                    }else if(data.contractDetails[k][20] == "White" || data.contractDetails[k][20] == "Tossa"){
	                    	 if (i > 5) {
		                        	contentToDisplay += "<td style='text-align: center; border: 1px solid black;' value='0'><input type='number' id='GR" + i + "_QTY' style='width: 70px;' value='0' disabled min='0'></td>";
		                        } else {
		                            contentToDisplay += "<td style='text-align: center; border: 1px solid black;'><input type='number' id='GR" + k+i + "_QTY' style='width: 70px;' value=0 min='0'></td>";
		                        }
	                    }
	                    else {
	                        contentToDisplay += "<td style='text-align: center; border: 1px solid black;'><input type='number' id='GR" +k+ i + "_QTY' style='width: 70px;' value=0 min='0'></td>";
	                    }
	                }

	                contentToDisplay += "<td style='text-align: center; border: 1px solid black;'><input type='number' id='GR" +k + "'style='width: 70px;' value=0 min='0' readonly></td></tr>";
	            }

	            contentToDisplay += "</tbody>";
	            contentToDisplay += "</table>";
				contentToDisplay+="<div id='errorContainer' style='display: none;  text-align: center;'></div>";
				contentToDisplay+="<div id='errorCont' style='display: none;  text-align: center;'></div>";
	            elementToUpdate.html(contentToDisplay);
	            
	           
	            
	            
	          
	        }
	    });
	  
	    
	   setTimeout(function(){
		   $.ajax({type:"GET",
				url:"fetchDetails.obj",
				data:{
					"diNo":val
				},
				success:function(result){
					   var data = jQuery.parseJSON(result);
				
					   
					   for (var i = 0; i < data.length; i++) {
						   var total =0;
						   var total2=0;
						    for (var j = 0; j < data[i].length; j++) {
						        $("#form2 #alloc_" + i + (j + 1)).val(data[i][j].toFixed(2));
						        $("#form2 #bal_" + i + (j + 1)).val(($("#form2 #DI_" + i + (j + 1)).val() - data[i][j]).toFixed(2));
						        console.log( $("#form2 #bal_" + i + (j + 1)).val(($("#form2 #DI_" + i + (j + 1)).val() - data[i][j]).toFixed(2)));
						        total += data[i][j];
						        total2 += $("#form2 #DI_" + i + (j + 1)).val() - data[i][j].toFixed(2);
						        /* alert(($("#form2 #DI_" + i + (j + 1)).val() - data[i][j])); */
						         $("#form2 #GR" + i + (j + 1) + "_QTY").attr('max', ($("#form2 #DI_" + i + (j + 1)).val() - data[i][j].toFixed(2)));
						        console.log("#GR" + i + (j+1) + "_QTY"+":"+($("#form2 #DI_" + i + (j + 1)).val() - data[i][j].toFixed(2)));
						        

						    }
						    $("#form2 #total_alloc"+i).val(total.toFixed(2));
							$("#form2 #total_bal"+i).val(total2.toFixed(2));
						}

					
					
			
					
					  



				}
				});
		// Assuming this code is placed after the dynamic table structure has been added to the DOM
		// Assuming this is within a $(document).ready() block
		   $(document).ready(function() {
		       // Attach event listener to input elements
		       $("input[type='number']").on("input", function() {
		           // Extract k value from input ID
		           var n = $(this).attr('id').match(/\d+/)[0];
		           computeAndSetSum(n, size); // Compute sum when input value changes
		       });
		   });

		   function computeAndSetSum(n, size) {
		       
		       for (var j = 0; j <= size; j++) {
		    	   var sum = 0;
		           for (var i = 1; i <= 8; i++) {
		               var inputId = "#GR" + j + i + "_QTY";
		               var inputValue = parseFloat($(inputId).val()) || 0; // Parse input value to integer, default to 0 if NaN
		               sum += inputValue;
		               console.log(sum)
		           }
		           $("#GR" + j).val(sum); // Set the sum in the specified element
		       }
		   }

			
	   },2500);
			
	});


	

						
	</script>

	<script>
$(document).ready(function() {
	 $(".contractLoader").hide();
    // Define a function to gather data
    var c1="";
    function gatherData() {
        var juteDetails = [];
         var flag = 1;
         var juteVarietyName = "";
        $('#table_r tbody tr').each(function(index, row) {
            var juteVar = $(row).find('td:first').text().trim();
            if( juteVar =='Bimli' || juteVar == 'Mesta' || juteVar == 'White' || juteVar =='Tossa') juteVarietyName = juteVar;
            
            var values = [];
       	 	console.log(juteVar);
            // Check if the juteVar is not empty and not 'Allocated' or 'Balance'
            if (juteVar == 'DI Issue') {
                // Loop through each input field in the row
                $(row).find('input').each(function(i, input) {
                    var value = $(input).val() || '0'; // Use '0' if the value is not present
                    values.push(value);
                
                });
                
                // Create a juteDetail object with jute variety and its values
                var juteDetail = {
                    "juteVar": juteVarietyName,
                    "values": values
                };

                // Push the juteDetail object to the juteDetails array
                juteDetails.push(juteDetail);
                flag++;
                juteVarietyName = "";
            }
        });

        // Gather other form data
        var hoDiNo = $("#hoDiNo").val();
        var hoDiDate = $("#hoDiDate").val();
        var contractNo = $("#contractNo").val();
        var contractDate = $("#contractDate").val();
        var cropYear = $("#cropYear").val();
        var dpc = $("#dpc").val();
        var roDiNo = $("#roDiNo").val();
        var roDiDate = $("#roDiDate").val();
        var lastDate = $("#lastDateOfShipment").val();
        var remarksValue = $("#remarks").val();

        // Create an object with all the data
        var dataToSend = {
            "hoDiNo": hoDiNo,
            "hoDiDate": hoDiDate,
            "contractNo": contractNo,
            "contractDate": contractDate,
            "cropYear": cropYear,
            "dpc": dpc,
            "roDiNo": roDiNo,
            "roDiDate": roDiDate,
            "lastDateOfShipment": lastDate,
            "remarksValue": remarksValue,
            "juteDetails": juteDetails
        };

        // Return the gathered data
        return dataToSend;
    }

    // Call gatherData function
    $("#submit").on("click", function(event) {
        // Prevent default form submission behavior
        event.preventDefault();
        

        // Call the gatherData function
   var gatheredData = gatherData();
var size = gatheredData.juteDetails;

for (var i = 0; i < size.length; i++) {
    for (var j = 0; j < 8; j++) {
        if ($("#form2 #GR" + i + (j + 1) + "_QTY").val() > ($("#form2 #DI_" + i + (j + 1)).val() - $("#form2 #alloc_" + i + (j + 1)).val())) {
            var errorMessage = " Allocated quantitites are more than the balance quantities" ;
            var errorDiv = $("<div>").text(errorMessage).css({
                "color": "red",
                "font-weight": "bold"
            });
            $("#errorContainer").append(errorDiv).show(); // Show the error container
            setTimeout(function() {
                $("#errorContainer").empty().hide(); // Clear and hide the error message after 5 seconds
            }, 5000);
            return false;
        }
    }
}

//To check if Remarks is empty or not
if(/* $("#remarks").val().length ==0 || */ $("#dpc").val() =="-1"){
	 var errorMessage = " Fill all the marked fields" ;
     var errorDiv = $("<div>").text(errorMessage).css({
         "color": "red",
         "font-weight": "bold"
     });
     $("#errorcontainer").append(errorDiv).show(); // Show the error container
     window.scrollTo(0, 0);
     setTimeout(function() {
         $("#errorcontainer").empty().hide(); // Clear and hide the error message after 5 seconds
     }, 5000);
	return false}
	
	//To check if allocations done or not
var total = 0;
//Loop through each row in the juteDetails array
for (var i = 0; i < size.length; i++) {
    
    console.log("Jute variety:", size[i].juteVar);
    // Check if the jute variety is "DI Issue"
    if (size[i].juteVar == "Mesta"||(size[i].juteVar == "Bimli")||(size[i].juteVar == "Tossa")||(size[i].juteVar == "White")) {
        
   		
        // Loop through the values in the row
        for (var j = 0; j < size[i].values.length; j++) {
            // Convert each value to a number and add it to the total
            total += parseFloat(size[i].values[j], 10);
           
        }
       
        
    }
}
if (total === 0) {
    var errorMessage = "Please allocate the jute varities";
    var errorDiv = $("<div>").text(errorMessage).css({
        "color": "red",
        "font-weight": "bold"
    });
    $("#errorCont").append(errorDiv).show(); // Show the error container
  
    setTimeout(function() {
        $("#errorCont").empty().hide(); // Clear and hide the error message after 5 seconds
    }, 5000);
    return false;
}


var dpc = $("#dpc").val();
var hoDiNo = $("#hoDiNo").val();


/* $.ajax({
    type: "GET",
    url: "dpcCheck.obj",
    data: {
        "dpc": dpc,
        "hoDiNo": hoDiNo
    },
   
    success: function(result) {
        var data = jQuery.parseJSON(result);
        c1 = data; // Parsing and assigning the value

        // Alert or use check1 within the success callback
        //alert(c1);
        console.log("check:---" + c1);
        return false;
        console.log("after cgeck");
        // Any further operations dependent on check1 should be done here
    },
    error: function(xhr, status, error) {
        console.error("Error: " + error);
    }
    
}); */

$(".contractLoader").show();

        //  AJAX request to save the data
        $.ajax({
            type: "POST",
            url: "saveRoDi.obj",
            data: JSON.stringify(gatheredData),
            contentType: "application/json",
            success: async (result) => {
            	
            	 const successDiv = document.getElementById('success');
                 successDiv.textContent = "Data saved successfully";
                 successDiv.style.display = 'block'; // Show the success message
                 window.scrollTo(0, 0);
                 // Set timeout to hide the success message and redirect to the next page
                 setTimeout(async function(){
                     // Hide the success message
                     successDiv.style.display = 'none';
                   
                     // Redirect to the next page
                     window.location.href = "roDispatchInstruction.obj";
                     $(".contractLoader").hide();
                     // Hide loader if needed
                     await loader("none");

                    
                 }, 2000);
               
                
            },
            error: function(xhr, status, error) {
                console.error("Error: " + error);
            }
        });
        
 
    });
});


</script>
	<script type="text/javascript">
		$(".validation").on(
				"keypress",
				function() {
					if (event.key === "-" || event.key === "+"
							|| event.key === "e" || event.key === "E") {
						event.preventDefault();
					}

				})
	</script>
	<script>
$("#hoDiNo").on("change", function() {
	var val = $(this).val();
	//alert(val);
	
	var hoNo = $("#hoDiNo").val();
	$.ajax({
		type:"GET",
		url:"getdetails.obj",
		data: {
			"diNo":val
		},
        contentType: "application/json",
        success: async (result) => {
            // Redirect to another page after successful save
        	 var data = jQuery.parseJSON(result);
            console.log(data);
            //alert(data.length);
            $("#form3").html("");
     		    var elementToUpdate = $("#form3");
 			    var contentToDisplay="<h5 style='text-align: center; text-decoration: underline; font-weight: bold;'>Previous Issued DI</h5>";
       		    contentToDisplay+="<table id='table_r' style='border-collapse: collapse; width: 100%;'>";
             	contentToDisplay+="<tr><th style='border: 1px solid black; text-align: center;'>S.no</th><th style='border: 1px solid black; text-align: center;'>RO DI no.</th><th style='border: 1px solid black; text-align: center;'>RO DI Date</th><th style='border: 1px solid black; text-align: center;'>DPC/Cooperative</th><th style='border: 1px solid black; text-align: center;'>Allocated Qty(Qtls)</th></tr> ";
				var totalAllocatedQty = 0; // Variable to store the total allocated quantity

			for(var i=0; i<data.length; i++){
			 contentToDisplay += "<tr><td style='border: 1px solid black; text-align: center; color: blue;'>" + (i + 1) + "</td><td style='border: 1px solid black; text-align: center; width: 30%; color: blue;'>" + data[i][0] + "</td><td style='border: 1px solid black; text-align: center; width: 60%; color: blue;'>" + data[i][1] + "</td><td style='border: 1px solid black; text-align: center; width: 60%; color: blue;'>" + data[i][2] + "</td><td style='border: 1px solid black; text-align: center; color: green;'>" + data[i][3] + "</td></tr>";
  			  totalAllocatedQty += parseFloat(data[i][3].toFixed(2)) // Accumulate the allocated quantity for total calculation
			}

		contentToDisplay+="<tr><td colspan='4' style='text-align: right; border: 1px solid black; '><strong>Total</strong></td><td style='border: 1px solid black;  text-align: center;color: green;'>" + totalAllocatedQty.toFixed(2) + "</td></tr>"; // Adding the total row
		contentToDisplay+="</table>";
		elementToUpdate.html(contentToDisplay);


        },
        error: function(xhr, status, error) {
            console.error("Error: " + error);
        }
	});
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
	<script src="assets/css/chosen.jquery.js" type="text/javascript"></script>

	<!-- PAGE LEVEL SCRIPTS-->
</body>
</html>