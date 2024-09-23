<%@page import="java.time.LocalDate"%>
<%@page import="java.time.LocalDateTime"%>
<%@page import="java.time.format.DateTimeFormatter"%>
<%@page import="com.jci.model.RoDetailsModel"%>
<%@page import="com.jci.model.BidCreation"%>
<%@page import="com.jci.model.OperationCostModel"%>
<%@ page import="java.util.List" %>

<%@page import="com.jci.controller.LoginController"%>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.text.ParseException" %>
<%@ page import="java.util.Date" %>
<%@ page import="java.util.List" %>

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
<link href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<link href="<%=request.getContextPath() %>/resources/css/styleUserReg.css" rel="stylesheet">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

<script type="text/javascript" src='<%=request.getContextPath() %>/resources/js/responsivevoice.js'></script>

<script type="text/javascript" src='<%=request.getContextPath() %>/resources/js/custom.js'></script>
<script type="text/javascript" src='<%=request.getContextPath() %>/resources/js/jquery.mCustomScrollbar.concat.min.js'></script>
<script type="text/javascript" src='<%=request.getContextPath() %>/resources/js/jquery.validate.min.js'></script>
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

<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
<script src="https://code.jquery.com/ui/1.13.2/jquery-ui.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.5.0/js/bootstrap-datepicker.js"></script>   


<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<link rel="stylesheet" href="https://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.min.js"></script>

<!-- CORE SCRIPTS-->
  
  
  <script src="assets/js/app.min.js" type="text/javascript"></script>

<link rel="stylesheet" href="assets/css/docsupport/style.css">
  <link rel="stylesheet" href="assets/css/docsupport/prism.css">
  <link rel="stylesheet" href="assets/css/chosen.css">
  <script src="https://code.jquery.com/jquery-3.6.0.js"></script>
  <script src="https://code.jquery.com/ui/1.13.2/jquery-ui.js"></script>


 <style>
.required:after {
       content: " *";
       color: red;
}
</style> 
</head>

<body class="fixed-navbar" onload="myFunction()">
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
                <h1 class="page-title">Edit Bid Creation</h1>
            </div>
     <%

                          List<Object[]> list = (List<Object[]>) request.getAttribute("Details");
                          System.out.println(list);
                          %>
            <div class="page-content fade-in-up">
                <div class="row">
                    <div class="col-md-11">
                        <div class="ibox">
                          <span>${msg}</span>
                            <div class="ibox-body">
                       <form action="editcreationofNonActivebid.obj" method="POST">
                           <div class="child-checkbox" id="disableform">
                        
                                                                        <div class="row">
    <div class="col-sm-4 form-group">
        <label id="regionlabel" class="required">Basis</label>
        <input class="form-control taxtbox" name="basis" id="basis" value="<%= list.get(0)[1] %>" required readonly>
    </div>

   <div class="col-sm-4 form-group">
    <input type="checkbox" id="provisionofclaim" name="provisionofclaim"  <% if(list.get(0)[12].equals(0)) out.print("checked"); %> >
    <label>Provision of Claim</label>
</div>
       

    <%-- <div class="col-sm-4 form-group">
        <input type="checkbox" id="bidrollout" name="bidrollout" onclick="enableCreateUser1()" <% if(list.get(0)[11].equals(1)) out.print("checked"); %>>
        <label>Bid Roll Out</label>
    </div> --%>
</div>

                         
  <div class="row">
                            
                                                           <div class="col-sm-4 form-group">
                                                    <label  class="required">Bid Reference No. </label>
                                                    <input class="form-control taxtbox" name="Bid_Reference" id ="Bid_Reference"  placeholder="Bid Reference" value="<%= list.get(0)[4] %>"  readonly required >
                                              </div>
                                         
<div class="col-sm-4 form-group">
    <label>Bid Date</label>
    <input type="datetime-local" name="biddate" class="form-control" id="biddate" required 
         value="<%
                    String timestamp = (String) list.get(0)[3];
                    SimpleDateFormat inputFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm");
                    SimpleDateFormat outputFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm");
                    String formattedDate = "";
                    try {
                        Date date = inputFormat.parse(timestamp);
                        formattedDate = outputFormat.format(date);
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                    out.print(formattedDate);
                %>"
           > 
</div>

<div class="col-sm-4 form-group">
    <label>Bid Closing Date</label> 
    <span class="text-danger">*</span>&nbsp; 
    <span id="instrumentdate" name="instrumentdate" class="text-danger"></span>
     <input type="datetime-local" class="form-control" name="bidclosingdate" id="bidclosingdate" placeholder="dd-mm-yyyy" required  value="<%
                    String timestamp1 = (String) list.get(0)[2];
                    SimpleDateFormat inputFormat1 = new SimpleDateFormat("dd-MM-yyyy HH:mm");
                    SimpleDateFormat outputFormat1 = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm");
                    String formattedDate1 = "";
                    try {
                        Date date1 = inputFormat1.parse(timestamp1);
                        formattedDate1 = outputFormat1.format(date1);
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                    out.print(formattedDate1);
                %>">
</div>
                                 </div>
                                    
                                   <div class="row">
                                   
                                    <div class="col-sm-4 form-group">
                                                    <label class="required">Security Deposit Amount</label>
                                                    <input class="form-control taxtbox" name="SecurityDepositAmount" id="SecurityDepositAmount" min="0" type="number" placeholder="Security Deposit Amount" required  value="<%= list.get(0)[13] %>">
                                              </div>
                                   
                                    <div class="col-sm-4 form-group">
                                                    <label class="required">Days to Accept</label>
                                                    <input class="form-control taxtbox" name="DaystoAccept" id="DaystoAccept" min="0" type="number" placeholder="Days to Accept"  value="<%= list.get(0)[14] %>" required >
                                              </div>
                               
                                  <div class="col-sm-4 form-group">
                                                                                              <label class="required">Days to deposit</label>
                                                                                                <input class="form-control taxtbox" name="daystodeposit" id ="daystodeposit"min="0"  type="number"  placeholder="Days to deposit" value="<%= list.get(0)[9] %>"  required >
                                                                                            </div> 
                                  
                                    </div>
                                    
                                    <div class="row">
                                         
                                               <div class="col-sm-4 form-group">
                                                                                              <label>Delivery Period</label>
                                                                                                <input class="form-control taxtbox" name="Delivery_Period" id ="Delivery_Period"min="0"  type="number"  value="<%= list.get(0)[11] %>"  required >
                                                                                            </div> 
                                     
                                              <div class="col-sm-4 form-group">
                                                                        <label id="lotidentification" class="required">Lot Identification</label> <span class="text-danger">
                                                                        </span> &nbsp;&nbsp;&nbsp; 
                                                                        <span id="lotidentification" name="lotidentification" class="text-danger"> </span>
                                                                  <input class="form-control taxtbox" name="Delivery_Period" id ="Delivery_Period"min="0"  type="number"  placeholder="Delivery Period" value="<%= list.get(0)[10] %>" readonly required >
                                                                                            
                                                                        
                                                           </div>
                                                                  </div>  
                                     
                                        <div class="row"> 
                                                <div class="col-sm-12 form-group">
                                                                        <input type="submit" value="Submit"class="btn btn-primary" id="submit">
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
<link rel="stylesheet" href="//code.jquery.com/ui/1.13.2/themes/base/jquery-ui.css">
<link rel="stylesheet" href="/resources/demos/style.css">
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
<script src="https://code.jquery.com/ui/1.13.2/jquery-ui.js"></script>

    
    
  

     
            <script type="text/javascript">
          
                function enableCreateUser() 
                {
                                   if (document.getElementById("provisionofclaim").checked) {
                                         alert();
                                         $('#provisionofclaim').val(0);
                                       //    alert( $('#provisionofclaim').val());
                                         
                                   } 
                                   if (!document.getElementById("provisionofclaim").checked) {
                                         alert();
                                         $('#provisionofclaim').val(1);
                                       // alert(  $('#provisionofclaim').val());
                                   }
                    }
                
                $(document).ready(function() {
                        // Function to set minimum value for bid closing date based on bid opening date
                        $('#biddate').on('change', function() {
                            // Get the selected date and time from bid opening date input
                            var bidOpeningDateTime = new Date($('#biddate').val());
                            
                            // Calculate minimum bid closing date: Add 1 minute to bid opening date
                            var minBidClosingDateTime = new Date(bidOpeningDateTime.getTime() + 60000); // Adding 1 minute in milliseconds
                            
                            // Format the minimum bid closing date in datetime-local format
                            var minBidClosingDateTimeString = minBidClosingDateTime.toISOString().slice(0,16);
                            
                            // Set the minimum value for bid closing date input
                            $('#bidclosingdate').attr('min', minBidClosingDateTimeString);
                            
                            // Clear any previous value in bid closing date to ensure it validates correctly
                            $('#bidclosingdate').val('');
                        });
                    });

</script>






   
  
  
    <!-- END PAGA BACKDROPS-->
    <!-- CORE PLUGINS-->
    <script src="./assets/vendors/jquery/dist/jquery.min.js" type="text/javascript"></script>
    <script src="./assets/vendors/popper.js/dist/umd/popper.min.js" type="text/javascript"></script>
    <script src="./assets/vendors/bootstrap/dist/js/bootstrap.min.js" type="text/javascript"></script>
    <script src="./assets/vendors/metisMenu/dist/metisMenu.min.js" type="text/javascript"></script>
    <script src="./assets/vendors/jquery-slimscroll/jquery.slimscroll.min.js" type="text/javascript"></script>
      <script src="assets/css/chosen.jquery.js" type="text/javascript"></script>
  <script src="assets/css/docsupport/prism.js" type="text/javascript" charset="utf-8"></script>
  <script src="assets/css/docsupport/init.js" type="text/javascript" charset="utf-8"></script>
    <!-- PAGE LEVEL PLUGINS-->
    <!-- CORE SCRIPTS-->
    <script src="assets/js/app.min.js" type="text/javascript"></script>

    
    <!-- PAGE LEVEL SCRIPTS-->

</html>

</html>

