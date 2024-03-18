<%@page import="java.util.List"%>
<%@ page import="javax.servlet.http.HttpServletRequest"%>

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
    <script src="https://code.jquery.com/jquery-3.6.0.js"></script>
  <script src="https://code.jquery.com/ui/1.13.2/jquery-ui.js"></script>
  
    <!-- PAGE LEVEL STYLES-->
     <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
       <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
       
    <script src="./assets/vendors/jquery/dist/jquery.min.js" type="text/javascript"></script>
    <script src="./assets/vendors/popper.js/dist/umd/popper.min.js" type="text/javascript"></script>
    <script src="./assets/vendors/bootstrap/dist/js/bootstrap.min.js" type="text/javascript"></script>
    <script src="./assets/vendors/metisMenu/dist/metisMenu.min.js" type="text/javascript"></script>
    <script src="./assets/vendors/jquery-slimscroll/jquery.slimscroll.min.js" type="text/javascript"></script>
    <!-- PAGE LEVEL PLUGINS-->
    <!-- CORE SCRIPTS-->
    <script src="assets/js/app.min.js" type="text/javascript"></script>
    <script type="text/javascript" src="assets/js/CommanInputValidation.js">
    <!-- PAGE LEVEL SCRIPTS-->
</head>

<script type="text/javascript">
$(document).ready(function () {
       //Global var
       
       //current date
       var dateNewFormat, onlyDate, today = new Date();
    dateNewFormat = today.getFullYear() + '-'; 
   //  alert(today.getMonth()+1);
     var month1 = (today.getMonth() + 1);
    // alert(month1);
    if (month1.toString().length== 2) {
     //alert("if");
        dateNewFormat += (today.getMonth() + 1);
    }
    else {
        dateNewFormat += '0' + (today.getMonth() + 1);
    }

    onlyDate = today.getDate();
    if (onlyDate.toString().length == 2) {

        dateNewFormat += "-" + onlyDate;
    }
    else {
        dateNewFormat += '-0' + onlyDate;
    }
    
    //7 days back
    var tommorowymd, tomdate,tommorowdate = new Date();
    tommorowdate.setDate(tommorowdate.getDate()-7);
    tommorowymd = tommorowdate.getFullYear() + '-'; 
    tommonth = (tommorowdate.getMonth() + 1);
    if (tommonth.toString().length == 2) {

       tommorowymd += (tommorowdate.getMonth() + 1);
    }
    else {
       tommorowymd += '0' + (tommorowdate.getMonth() + 1);
    }

    tomdate = tommorowdate.getDate();
    if (tomdate.toString().length == 2) {

       tommorowymd += "-" + tomdate;
    }
    else {
       tommorowymd += '-' + tomdate;
    }
    
    $('#datejba').val(dateNewFormat);
    $('#datejba').attr('max', dateNewFormat);
    $('#datejba').attr('min', tommorowymd);
    

});

</script>

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
                <h1 class="page-title">User Role</h1>
            </div>
            <div class="page-content fade-in-up">
                <div class="row">
                    <div class="col-md-11">
                        <div class="ibox">
                             <span>${msg}</span>
                            <div class="ibox-body">
                                <form action="saveuserrole.obj" method="POST" name="myForm"  onsubmit="return validateRole(this)">
                                    <div class="row">
                                    
                                                                       
                                       <div class="col-sm-4 form-group">
                                            <label>Role Type</label> 
                                                                        <select name="roletype" id="roletype" class="form-control" required="required">
                                                                               <option disabled selected value>-Select-</option>
                                                                               <option value="HO">HO</option>
                                                                               <option value="ZO">ZO</option>
                                                                               <option value="RO">RO</option>
                                                                               <option value="DPC">DPC</option>
                                                                        </select>
                                        </div>
                                        <div class="col-sm-4 form-group">
                                           <!--  <label>JBA Date</label>
                                            <input class="form-control" type="date" name="datejba" placeholder="JaBA Date" required> -->
                                        
                                           <label>Role Name</label><span id="errrole" name="errrole" class="text-danger"></span>
                                         <input type="text" name="rolename" id="rolename" onkeyup="return validateRole();" class="form-control stringValidation" placeholder="Role Name" oninput="allow_alphabets(this)"  required/>
                                       <!--  <input readonly class="form-control" id="datejba" type=date name="datejba" placeholder="JaBA Date" required> -->
                                        </div>
                                   
                                       <div class="col-sm-4 form-group">
                                            <label>User Type</label> 
                                                                        <select name="usertype" id="usertype" class="form-control" required="required">
                                                                               <option disabled selected value>-Select-</option>
                                                                               <option value="Web User">Web User</option>
                                                                               <option value="Mobile User">Mobile User</option>
                                                                        </select>
                                        </div>
          
                                    </div>   
                                                                 
                                    <div class="form-group">
                                        <button class="btn btn-default" type="submit" id="submit">Create</button>
                                        <a href="viewuserrole.obj" class="btn btn-default">View Roles</a>
      
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

function validateRole(form) {
       var rolename = document.getElementById("rolename").value;
       var data;
             $.ajax({
                          type:"GET",
                          url:"validateRole.obj",
                          data:{"rolename":rolename},
                          success:function(result){
                                 data =result;
                    
                          
                          if (data === 'false'){
                           document.getElementById("errrole").innerHTML = "&nbsp;&nbsp;&nbsp; Role already Exists!";
                          $(':input[type="submit"]').prop('disabled', true);
                          }
                          else if (data === 'true'){
                                 document.getElementById("errrole").innerHTML = "";
                                 $(':input[type="submit"]').prop('disabled', false);
                          }
                          
                          }      
               }); 
              
              
}
       
</script> 
   <script>
    function allow_alphabets(element){
        let textInput = element.value;
        textInput = textInput.replace(/[^A-Za-z- ]*$/gm, ""); 
        element.value = textInput;
    }
    
        $('form').submit(function () {
            var textInput = $('#rolename').val();
            
            // Remove characters that are not alphabets
            var cleanedInput = textInput.replace(/[^A-Za-z\s]/g, "");

            // You can also display an alert or perform additional validation if needed
            if (textInput !== cleanedInput) {
                document.getElementById("errrole").innerHTML = "&nbsp;&nbsp;&nbsp; Only alphabetic are allowed!";
                return false; // Cancel form submission
            }
            // Form submission will proceed if the input is valid
            return true;
    });

</script>
</body>
</html>
