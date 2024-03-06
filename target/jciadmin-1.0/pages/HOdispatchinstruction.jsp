<%@page import="java.text.SimpleDateFormat"%>
<%@page
       import="net.sf.jasperreports.engine.util.Java14BigDecimalHandler"%>
<%@page import="java.util.List"%>
<%@page import="java.time.LocalDate"%>
<%@page import="java.time.LocalDateTime"%>
<%@page import="java.time.format.DateTimeFormatter"%>


<!DOCTYPE html>
<html lang="en">
<script
       src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js">
       
</script>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width initial-scale=1.0">
<title>JCI | CMS</title>
<!-- GLOBAL MAINLY STYLES-->
<link href="./assets/vendors/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet" />
<link href="./assets/vendors/font-awesome/css/font-awesome.min.css" rel="stylesheet" />
<link href="./assets/vendors/themify-icons/css/themify-icons.css" rel="stylesheet" />
<link href="assets/css/main.min.css" rel="stylesheet" />
 <link rel="stylesheet" href="assets/css/docsupport/style.css">
<link rel="stylesheet" href="assets/css/docsupport/prism.css"> 
<link rel="stylesheet" href="assets/css/chosen.css"> 
<script src="https://code.jquery.com/jquery-1.11.3.min.js"
      type="text/javascript"></script>


<style>
.required:after {
       content: " *";
       color: red;
}

input[type="radio"] {
       display: inline;
}
#centerordpc {
    width: 90%;
}
#container {
  display: flex;
  flex-direction: row;
}

#l1, #r1 {
  margin-left: 10px; /* Adjust margin values as needed */
  margin-right:0px;
}

#r1 {
  flex: 1; /* Expand to fill remaining space initially */
  margin-right:-100px;
}
#ibox{
       padding: 0 0px;
}
.cell-input {
    width: 80px; /* Set the desired width for the cell */
    height: 40px; /* Set the desired height for the cell */
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
                            <h1 class="page-title">HO Dispatch Instruction</h1>
                     </div>

                     <%
                     // Author vishal
                     %>

                     <%
                     List<String> contractList = (List<String>) request.getAttribute("ContractList");
                     %>
                     <%
                     List<Object[]> roList = (List<Object[]>) request.getAttribute("ronameList");
                     %>
                     <div class="page-content fade-in-up">
                           <div class="row">
                                  <div class="col-md-11">
                                         <div class="ibox" id="ibox">
                                                <span>${msg}</span>
                                                <div class="ibox-body">
                                                       <form action="savehodispatchInst.obj" method="POST"
                                                              onsubmit="return myFunc()">
                                                              <div class="child-checkbox" id="disableform">
                                                              <div id="container">
                                                              <div id="l1">
                                                                           <div id="elementId" style="text-align: left;"></div>
                                                                            </div>
                                                                           <div id="r1" style="align:right;">
                                                                     <div class="row">

                                                                           <div class="col-sm-4 form-group">
                                                                                  <label>Full Contract No.</label> <span class="text-danger">*
                                                                                  </span>&nbsp; <span id="contractno" name="contractno"
                                                                                         class="text-danger"> </span> <select name="fullcontractno"
                                                                                         id="fullcontractno" class="form-control textbox" required>
                                                                                         <option value="" disabled selected>Select</option>
                                                                                         <%
                                                                                         for (String Contract : contractList) {
                                                                                         %>
                                                                                         <option value="<%=Contract%>" readonly><%=Contract%></option>
                                                                                         <%
                                                                                         }
                                                                                         %>
                                                                                  </select>
                                                                          </div>



                                                                           <div class="col-sm-4 form-group">
                                                                                  <label>Contract Date</label> <span class="text-danger">*
                                                                                  </span>&nbsp; <span id="cdate" name="cdate" class="text-danger">
                                                                                  </span> <input class="form-control" name="contractdate"
                                                                                         id="contractdate" type="text" readonly
                                                                                         placeholder="DD/MM/YYYY">
                                                                           </div>

                                                                           <div class="col-sm-4 form-group">
                                                                                  <label>Crop Year</label> <span class="text-danger">*
                                                                                  </span>&nbsp; <input name="cropyear" id="cropyear"
                                                                                         class="form-control textbox" required readonly
                                                                                         placeholder="Crop Year">



                                                                           </div>
                                                                     </div>

                                                                     <div class="row">

                                                                           <div class="col-sm-4 form-group">
                                                                                  <label>Contract Quantity </label> <input
                                                                                         class="form-control textbox" name="contractquantity"
                                                                                         min="0" type="number" id="contractquantity"
                                                                                         placeholder="Contract Quantity" required readonly>
                                                                           </div>

                                                                           <div class="col-sm-4 form-group">
                                                                                  <label>FC Ref No. </label> <input
                                                                                         class="form-control textbox" name="FC_Ref_No" type="number"
                                                                                         id="fc" placeholder="FC Ref No." required readonly>
                                                                           </div>

                                                                           <div class="col-sm-4 form-group">
                                                                                  <label>Allowed Quantity </label> <input
                                                                                         class="form-control textbox" name="qty" type="number"
                                                                                         id="qty" placeholder="Allowed Quantity" required readonly>
                                                                           </div>
                                                                     </div>

                                                                     <input type="radio" name="opt" value="head" id="regId" checked>
                                                                     Region <input type="radio" name="opt" value="bod"> DPC
                                                                     <div class="row">
                                                                           <div class="col-sm-4 form-group">
                                                                                  <label>Regional Office </label> <span class="text-danger">*
                                                                                   </span>&nbsp;<select name="region" id="region"
                                                                                         class="form-control textbox" required>
                                                                                         <option value="" disabled selected>Select</option>
                                                                                         <%
                                                                                         for (Object[] ro : roList) {
                                                                                         %>
                                                                                         <option value="<%=(String) ro[1]%>"><%=(String) ro[0]%></option>
                                                                                         <%
                                                                                         }
                                                                                         %>
                                                                                  </select>


                                                                           </div>
                                                                           <div class="col-sm-4 form-group" id="dpc_div">
                                                                                  <label id="dpclabel" class="required">DPC</label>
                                                                                  &nbsp;&nbsp;&nbsp;
                                                                                  <div class="form-control" id="dpc_div" ></div>


                                                                           </div>
                                                                           <span></span>
                                                                           <div class="col-sm-4 form-group">
                                                                                  <label>Issued Quantity.</label> <input class="form-control taxtbox"
                                                                                         name="IssQty" type="number" placeholder="Issued Qty"
                                                                                         id="IssQty" readonly required>
                                                                           </div>
                                                                     </div>

                                                                     <div class="row">

                                                                           <div class="col-sm-4 form-group">
                                                                                  <label>Last Date of Shipment</label> <span
                                                                                        class="text-danger">* </span>&nbsp; <span id="lastdate"
                                                                                         name="lastdate" class="text-danger"> </span> <input
                                                                                         class="form-control" name="lastdateofshipment"
                                                                                         id="instdate" type="date" required>
                                                                           </div>

                                                                           <div class="col-sm-4 form-group">
                                                                                  <label>DI no.</label> <input class="form-control taxtbox"
                                                                                         name="uniqueno" type="text" placeholder="Unique No"
                                                                                         id="uniq" readonly required>
                                                                           </div>

                                                                           <div class="col-sm-4 form-group">
                                                                                  <label>Date (DI Date)</label> <span class="text-danger">*
                                                                                  </span>&nbsp; <span id="DIdate" name="DIdate" class="text-danger">
                                                                                  </span> <input class="form-control" name="dateofdi" id="instdate"
                                                                                         type="date"
                                                                                         value="<%=new java.text.SimpleDateFormat("yyyy-MM-dd").format(new java.util.Date())%>"
                                                                                         readonly>
                                                                           </div>

                                                                     </div>
                                                                     <div class="row">

                                                                           <div class="col-sm-4 form-group">
                                                                                  <label>Jute Variety</label> <span class="text-danger">*
                                                                                  </span> <select name="jutevariety" id="jutevariety"
                                                                                         class="form-control" required style="width:200px;" multiple>
                                                                                         <!-- <option value="0" disabled selected>Select</option> -->
                                                                                         <option value="Bimli">Bimli</option>
                                                                                         <option value="Mesta">Mesta</option>
                                                                                         <option value="Tossa">Tossa</option>
                                                                                         <option value="White">White</option>
                                                                                  </select>
                                                                           </div>

                                                                           
                                                                           <div class="col-sm-4 form-group">
                                                                                  <label>Remarks</label><span class="text-danger">* </span>&nbsp;
                                                                                  <textarea class="form-control taxtbox" name="remarks"
                                                                                         placeholder="Remarks" required maxlength="250"></textarea>
                                                                           </div>

                                                                           <!-- <div class="col-sm-4 form-group">
                                                                                  <label id="lblName"></label>
                                                                                  <div id="form2"></div>
                                                                                  <span id="misQty"></span>
                                                                           </div> -->
                                                                           
                                                                        </div>
                                                                        <div class="row">
                                                                        <div class="col-sm-4 form-group">
                                                                                  <label id="lblName"></label>
                                                                                  <div id="form2"></div>
                                                                                  <span id="misQty"></span>
                                                                           </div>
                                                                           </div>
                                                                     <div class="row">
                                                                           <div class="col-sm-12 form-group">
                                                                                  <input type="submit" value="Submit" class="btn btn-primary"
                                                                                         id="submit">
                                                                           </div>
                                                                     </div>
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
       <script>
       $(document).ready(function() {
              
                $("#jutevariety").chosen(); //  select element with the Chosen plugin
                $("#jutevariety").addClass("chosen-select"); // Add the 'chosen-select' 

                $("#jutevariety").on("change", function() {
                  var selectedVal = $(this).val(); // Get the selected value 
                
                });

                $("#jutevariety option").prop('selected', false); // Deselect all options initially
                $("#jutevariety").trigger('chosen:updated'); // Update the Chosen
                
              });

       </script>
       
       <script>

       $(document).ready(function() {
           $("#jutevariety").on("change", function() {
               var selectedValue = $(this).val(); // Get the selected value
           
               console.log(selectedValue);
               
                var row = selectedValue.length;
               console.log(row); 
               var col=8;
               displayTable(row+1,col+1,selectedValue,"small-cell");
               
           });
       });
            function displayTable(rows, columns,selectedValue) {
               console.log(selectedValue);
               if (selectedValue.length > 0) {
               var tableHTML = "<table border='1'>";
              tableHTML+= "<tr><th style='width:100px; font-weight: bold;'>Jute Variety</th><td style='font-weight: bold;'>Grade1</td><td style='font-weight: bold;'>Grade2</td><td style='font-weight: bold;'>Grade3</td><td style='font-weight: bold;'>Grade4</td><td style='font-weight: bold;'>Grade5</td><td style='font-weight: bold;'>Grade6</td><td style='font-weight: bold;'>Grade7</td><td style='font-weight: bold;'>Grade8</td></tr>";
               for (var i = 0; i < rows-1; i++) {
                    var variety = selectedValue[i];
                    tableHTML += "<tr>";
                    tableHTML += "<th style='font-weight: bold;'>" + variety + "</th>";
                    for (var j = 0; j < columns - 1; j++) {
                             if ((variety === "Mesta" || variety === "Bimli") && j > 5) {
                               tableHTML += "<td><input class='cell-input' type='number' min='0.00' name='" + selectedValue[i] + j + "' value='0.00'  readonly/></td>";
                             } else {
                               tableHTML += "<td><input class='cell-input' type='number' min='0.00' name='" + selectedValue[i] + j + "' value='0.00' /></td>";
                             }
                           }

                    tableHTML += "</tr>";

               }
               tableHTML += "</table>";
               // Place the table inside the div with id "form2"
               $("#form2").html(tableHTML);
               }
               else {
                         $("#form2").empty(); // Clear the content of the "form2" element if juteVariety is empty
                       }
           } 

       </script>
       
       <script>if (hasData) {
                document.getElementById("l1").classList.add("has-data");
       }</script>
       
       <script>
              $(document)
                           .ready(
                                         function() {
                                                $("#fullcontractno")
                                                              .on(
                                                                           "change",
                                                                           function() {
                                                                                  
                                                                                  var cont = $(this).val();
                                                                                  //alert(cont);
                                                                                  $
                                                                                                .ajax({
                                                                                                       type : "GET",
                                                                                                       url : "HoDispatch.obj",
                                                                                                       data : {
                                                                                                              "contract" : cont
                                                                                                       },
                                                                                                       success : function(
                                                                                                                     data) {
                                                                                                              displayContr(
                                                                                                                           data,
                                                                                                                           cont);
                                                                                                              //alert(data);
                                                                                                       },
                                                                                                       error : function(
                                                                                                                     err) {
                                                                                                              // Handle errors here
                                                                                                              console
                                                                                                                           .error('AJAX request failed: '
                                                                                                                                         + err);
                                                                                                       }

                                                                                                });

                                                                           });
                                                function displayContr(data, cont) {
                                                       //alert(data);
                                                       var d = jQuery.parseJSON(data);
                                                       console.log(d);
                                                       //alert(d);
                                                       document.getElementById("contractdate").value = d[0];
                                                       document.getElementById("cropyear").value = d[1];
                                                       document.getElementById("contractquantity").value = d[2];
                                                       //alert(d[3]);//Mill name
                                                       //alert(d[4]);//Label name
                                                       document.getElementById("fc").value = d[5];
                                                       document.getElementById("qty").value = d[6];
                                                       if(d[15] == "Letter_of_Credit"){
                                                              
                                                              const today = new Date();

                                                              // Format the date in YYYY-MM-DD format
                                                              const formattedDate = today.toISOString().slice(0, 10);

                                                              // Set the value of the "instdate" element
                                                              document.getElementById("instdate").value = formattedDate;
                                                              //alert(instdate);
                                                       }
                                                       else{
                                                       document.getElementById("instdate")
                                                                     .setAttribute("min", d[7]);
                                                       document.getElementById("instdate").value = d[7];
                                                       const baseDate = new Date(d[7]);

                                                       // Add one month to the base date
                                                       baseDate.setMonth(baseDate.getMonth() + 1);

                                                       // Format the updated date in the same format as d[7] (yyyy-mm-dd)
                                                       const updatedDate = baseDate.toISOString().slice(0, 10);

                                                       // Access the element with ID "instdate" using JavaScript (assuming you have access to it)
                                                       const instdateElement = document.getElementById("instdate");

                                                       // Set the min attribute of the element to the updated date
                                                       instdateElement.setAttribute("max", updatedDate);
                                                       } 
                                                       //alert(d[8][1]);//Grade Comp
                                                       //alert(d[13]);//Grade Comp end;
                                                       //alert(d[14]);//Instrument-Issue date
                                                       //alert("count--------------" + d[15]);//Previous DI;
                                                       console.log(d[5]);
                                                       document.getElementById("elementId").innerHTML = "";
                                                       var elementToUpdate = document
                                                                     .getElementById("elementId"); // Replace 'elementId' with the actual ID of your target element

                                                       // Construct the HTML content to display
                                                       var contentToDisplay = "";
                                                       contentToDisplay += "<h1 style='text-align: center; text-decoration: underline; font-weight: bold;'>Contract Details</h1><br>";

                                                       contentToDisplay += "<p>Contract No.                               :"
                                                                     + "<strong><span style='color: blue'>"
                                                                     + cont + "</span></strong>" + "</p>";
                                                       contentToDisplay += "<p>Crop Year                                  : "
                                                                     + "<strong><span style='color: blue'>"
                                                                     + d[1] + "</span></strong>" + "</p>";
                                                       contentToDisplay += "<p>Mill Name                                  :"
                                                                     + "<strong><span style='color: green'>"
                                                                     + d[3] + "</span></strong>" + "</p>";
                                                       contentToDisplay += "<p>Contract Date: <span style='color: blue;'>"
                                                                     + d[0]
                                                                     + "</span></p><p>Contract Qty: <span style='color: blue;'>"
                                                                     + d[2] + "</span></p>";

                                                       contentToDisplay += "<h1 style='text-align: center; text-decoration: underline; font-weight: bold;'>Contract Quantity</h1><br>";
                                                       contentToDisplay += "<table style='border: 1px solid black; width: 100%; text-align: center;'><tr><th style='border: 1px solid black; width: 33.33%;'>Jute Variety Grade</th><th style='border: 1px solid black;'>Contract Qty (Qtls.)</th><th style='border: 1px solid black; width: 10%;'>Balance Qty (Qtls.)</th></tr>";

                                                       for (var i = 8; i <= 13; i++) {
                                                              var no = (+(d[i][1] * d[2] / 100)  - +d[14][i-8]).toFixed(2);
                                                              console.log(parseInt(d[i][1] * d[2] / 100)  - parseInt(d[14][i-8]));
                                                              contentToDisplay += "<tr><td style='border: 1px solid black; width: 50%;'><span style='color: blue;'>"
                                                                          + d[i][0]
                                                                           + "</span></td><td style='border: 1px solid black; width: 20%;'><span style='color: green;'>"
                                                                           + (d[i][1] * d[2] / 100)
                                                                           + "</span></td>"
                                                                           +"</span></td><td style='border: 1px solid black; width: 20%;'><span style='color: green;'>"
                                                                           +  no
                                                                           + "</span></td></tr>";
                                                       }
                                                       
                                                       contentToDisplay += "</table><br>";

                                                       contentToDisplay += "<br><h1 style='text-align: center; text-decoration: underline; font-weight: bold;'>Contract Payment Arrangement Details</h1><br>";
                                                       contentToDisplay += "<p>Contracted Qty: <span style='color: blue;'>"
                                                                     + d[2] + "</span></p>";
                                                       contentToDisplay += "<p>Allowed Qty: <span style='color: blue;'>"
                                                                     + d[6] + "</span></p>";
                                                       contentToDisplay += "<p>Date of Issue: <span style='color: blue;'>"
                                                                     + d[16] + "</span></p>";
                                                       var dateParts = document.getElementById("instdate").value.split("-");
                                                
                                                       var formattedDate = dateParts[2] + "-"
                                                                     + dateParts[1] + "-" + dateParts[0]; //DD_MM_YYYY form
                                                       contentToDisplay += "<p>Last Date of Shipment: <span style='color: blue;'>"
                                                                     + formattedDate + "</span></p>";

                                                       contentToDisplay += "<br><h1 style='text-align: center; text-decoration: underline; font-weight: bold;'>DI's Against this Contract</h1><br>";
                                                       contentToDisplay += "<table style='border: 1px solid black; width: 100%; text-align: center;'><tr><th style='border: 1px solid black; width: 20%;'>Previous HO DI's</th><th style='border: 1px solid black; width: 20%;'>Issue Date</th><th style='border: 1px solid black; width: 20%;'>To</th><th style='border: 1px solid black; width: 40%;'>Quantity(Qtls)</th></tr>";
                                                       //alert(d[16][4]);
                                                       var total = 0;
                                                       var size = 18 + +d[17];
                                                       //alert(size);
                                                       for (var i = 18; i < size; i++) {
                                                              contentToDisplay += "<tr><td style='border: 1px solid black;'><span style='color: blue; width: 50%;'>"
                                                                           + d[i][0]
                                                                           + "</span></td><td style='border: 1px solid black;'><span style='color: blue;'>"
                                                                           + d[i][1]
                                                                           + "</span></td><td style='border: 1px solid black;'><span style='color: green;'>"
                                                                           + d[i][2]
                                                                           + "</span></td><td style='border: 1px solid black;'><span style='color: blue;'>"
                                                                           + d[i][4] + "</span></td></tr>";
                                                              total += d[i][4];
                                                       }
                                                       
                                                       
                                                       
                                                       // Adding the total at the end of the table
                                                       contentToDisplay += "<tr><td colspan='3' style='text-align: right;'><strong>Total:</strong></td><td style='border: 1px solid black;'><span style='color: blue;'>"
                                                                     + total + "</span></td></tr>";

                                                       contentToDisplay += "</table><br>";
                                                       
                                                       document.getElementById("IssQty").value=total;//Issued QTY
                                                       contentToDisplay += "<br><h1 style='text-align: center; text-decoration: underline; font-weight: bold;'>Last Five DI's for the Particular Mill</h1><br>";
                                                       contentToDisplay += "<table style='border: 1px solid black; width: 100%; text-align: center;'><tr><th style='border: 1px solid black; width: 20%;'>DI No.</th><th style='border: 1px solid black; width: 20%;'>To</th></tr>";
                                                       //alert(parseInt(d[16 + parseInt(d[15])])
                                                                     //+ parseInt(16 + parseInt(d[15])));
                                                       //alert(size + 2);
                                                       for (var i = size + 1; i <= Math
                                                                     .max(
                                                                                  parseInt(d[18 + parseInt(d[17])])
                                                                                                + parseInt(18 + parseInt(d[17])),
                                                                                  parseInt(d[18 + parseInt(d[17])])); i++) {
                                                       
                                                              contentToDisplay += "<tr><td style='border: 1px solid black;'><span style='color: blue; width: 50%;'>"
                                                                           + d[i][0]
                                                                            + "</span></td><td style='border: 1px solid black;'><span style='color: blue;'>"
                                                                           + d[i][1] + "</span></td></tr>";
                                                       }
                                                       contentToDisplay += "</table><br>";

                                                       elementToUpdate.innerHTML = contentToDisplay;

                                                }
                                                $("#region")//DPC list auto selected when region is selected
                                                              .on(
                                                                           "change",
                                                                           function() {

                                                                                  var id = (this.value);

                                                                                  var html = "<label id='dpclabel' class='required'>DPC</label> <select data-placeholder='Choose DPC...'  class='chosen-select' name='dpc_name' multiple tabindex='4' id = 'centerordpc'>";
                                                                                  if (id != null) {
                                                                                         $
                                                                                                       .ajax({
                                                                                                              type : "GET",
                                                                                                              url : "findDpc.obj",
                                                                                                              data : {
                                                                                                                     "id" : id
                                                                                                              },
                                                                                                              success : function(
                                                                                                                           result) {

                                                                                                                     var data = jQuery
                                                                                                                                  .parseJSON(result);

                                                                                                                     html += "";
                                                                                                                     for (var i = 0; i < data.length; i++) {

                                                                                                                           html += "<option value="
                                                                                                                                         + data[i]
                                                                                                                                                       .split("-")[1]
                                                                                                                                         + ">"
                                                                                                                                         + data[i]
                                                                                                                                                       .split("-")[1]
                                                                                                                                         + "</option>"

                                                                                                                     }

                                                                                                                     $(
                                                                                                                                  "#dpc_div")
                                                                                                                                  .html(
                                                                                                                                                html);

                                                                                                                     $(
                                                                                                                                  "#centerordpc")
                                                                                                                                  .chosen();
                                                                                                                     $(
                                                                                                                                  "#centerordpc")
                                                                                                                                  .addClass(
                                                                                                                                                "chosen-select");
                                                                                                                     var selected_val = $(
                                                                                                                                  'input[name="opt"]:checked')
                                                                                                                                  .val();
                                                                                                                     /*  var selected_val =$('input[name="radioselect"]:checked').val();  */
                                                                                                                     if (selected_val === 'head') {
                                                                                                                           //alert('Region selected'); // Optional: Providing a message in the alert
                                                                                                                           $(
                                                                                                                                         "#centerordpc option")
                                                                                                                                         .prop(
                                                                                                                                                       'selected',
                                                                                                                                                       true);
                                                                                                                           $(
                                                                                                                                         '#centerordpc')
                                                                                                                                         .trigger(
                                                                                                                                                       'chosen:updated');

                                                                                                                           $(
                                                                                                                                         "#dpc_div")
                                                                                                                                         .html(
                                                                                                                                                       "");
                                                                                                                     }
                                                                                                                     if (selected_val === 'bod') {
                                                                                                                           //alert('DPC selected'); // Optional: Providing a message in the alert
                                                                                                                           $(
                                                                                                                                         "#centerordpc option")
                                                                                                                                         .prop(
                                                                                                                                                       'selected',
                                                                                                                                                       true);
                                                                                                                           $(
                                                                                                                                         '#centerordpc')
                                                                                                                                         .trigger(
                                                                                                                                                       'chosen:updated');

                                                                                                                     } else {
                                                                                                                           $(
                                                                                                                                         "#centerordpc option:selected")
                                                                                                                                         .removeAttr(
                                                                                                                                                       'selected');
                                                                                                                           $(
                                                                                                                                         '#centerordpc')
                                                                                                                                         .trigger(
                                                                                                                                                       'chosen:updated');
                                                                                                                     }

                                                                                                              }
                                                                                                       });
                                                                                  }

                                                                           });

                                         });
       </script>

       <script>//DI No. generation
              $("#region").on("change", function() {
                     //alert("DI no.");
                     var cp = $("#cropyear").val();
                     var reg = (this.value);
                     /*  alert(cp +"----------------"+reg); */
                     $.ajax({
                           type : "GET",
                           url : "countHo.obj",
                           data : {
                                  "reg" : reg
                           },
                           success : function(result) {
                                  /* alert(result+"Result") */
                                  var data = jQuery.parseJSON(result);
                                  //alert(data);
                                  //alert(typeof data);
                                  data=data+1;
                                  var DI;
                                  if (data < 10)
                                         DI = cp + "/" + reg + "00" + data;
                                  else if (data < 99)
                                         DI = cp + "/" + reg + "0" + data;
                                  else
                                         DI = cp + "/" + reg  + data;

                                  
                                  document.getElementById("uniq").value = DI;
                           }
                     });
              });
       </script>



       
       <script>
       function myFunc() {
              
              
                 var allow = parseInt(document.getElementById("qty").value);
                // alert(allow);
                var issued = parseInt(document.getElementById("IssQty").value);
                //alert(issued);
                var selectedValue = $("#jutevariety").val();
                var n = selectedValue.length;
                //alert(n);
                var total = 0;
              
                for (var i = 0; i < n; i++) {
                       var variety = selectedValue[i];
                       for (var j = 0; j < 8; j++) {
                         console.log(parseInt($("input[name='" + selectedValue[i] + j + "']").val()));
                         var inputValue = parseInt($("input[name='" + selectedValue[i] + j + "']").val()) || 0;
                         total += inputValue;
                       }
                     }

              //alert(total);
                console.log("issued: " + issued);
                console.log("total: " + total);
                console.log("allow: " + allow);
                if(total == 0)return false;
                 if (issued + total <= allow) {
                  return true; // Proceed with form submission
                } else {
                       document.getElementById("misQty").innerText = "Allocated quantity should be less than or equal to remaining quantity";
                           document.getElementById("misQty").style.color = "red";
                  return false; // Prevent form submission
                }  
               
              
       }

       </script>

       
       <script type="text/javascript">
       $(document).ready(function() {
           // Trigger the click event on the initially checked radio button
           $("#dpclabel").hide();
                   $("#dpc_div").hide();
           $("input:radio:checked").click();

           $("input:radio").click(function() {
               if ($(this).val() == "head") {
                   /*  $("#head").show(); */
                   $("#dpclabel").hide();
                   $("#dpc_div").hide();
               } else {
                   /*  $("#head").hide(); */
                   $("#region").val("");
                   $("#centerordpc").val(null);
                   $("#dpclabel").show();
                   $("#dpc_div").show();
               }
           });
       });
       </script>
       <script>
              // "Full Contract No." dropdown has ID "fullcontractno"
              //  "Regional Office" dropdown has ID "region"

              
              $(document).ready(function() {
                     // Disable the "Regional Office" dropdown initially
                     $("#region").prop('disabled', true);

                     // Add change event listener to "Full Contract No." dropdown
                     $("#fullcontractno").on('change', function() {
                           // If a valid option is selected in "Full Contract No.", enable the "Regional Office" dropdown
                           if ($(this).val()) {
                                  $("#region").prop('disabled', false);
                           } else {
                                  // If no option selected in "Full Contract No.", disable the "Regional Office" dropdown
                                  $("#region").prop('disabled', true);
                           }
                     });
              });
              
              
              
              
              
              
              //For Jute Variety till region is not selected 
              $(document).ready(function() {
  // Disable the "Jute Variety" dropdown initially
  $("#jutevariety").prop('disabled', true);

  // Add change event listener to "Regional Office" dropdown
  $("#region").on('change', function() {
    // If a valid option is selected in "Regional Office", enable the "Jute Variety" dropdown
    if ($(this).val()) {
      $("#jutevariety").prop('disabled', false);
    } else {
      // If no option is selected in "Regional Office", disable the "Jute Variety" dropdown
      $("#jutevariety").prop('disabled', true);
    }
  });
});
       </script>
<script src="assets/css/chosen.jquery.js" type="text/javascript"></script>
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

</body>


</html>

