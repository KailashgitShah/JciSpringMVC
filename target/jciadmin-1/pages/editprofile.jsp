<%@page import="java.util.HashMap"%>
<%@page import="java.util.List"%>
<%@page import="java.io.File"%>
<%@page import="com.jci.model.UserRoleModel"%>
<%@page import="com.jci.model.ZoneModel"%>
<%@page import="java.util.List"%>
<%@page import="com.jci.model.UserRegistrationModel"%>
<%@page import="java.text.SimpleDateFormat"%>




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
    <!-- PAGE LEVEL STYLES-->
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
                <h1 class="page-title">Change password</h1>
                 
            </div>
				
				<%
					UserRegistrationModel userProfile = (UserRegistrationModel)request.getAttribute("profile");
				
					
				%>
			            <div class="page-content fade-in-up">
                <div class="row">
                    <div class="col-md-11">
                        <div class="ibox">
                            <span>${msg}</span>
                            <div class="ibox-body">
                                <form action="updatesaveProfile.obj" method="POST" onsubmit ="return matchpassword();">
                                   <div class="row">
                     
                                            
										
											<%-- 	<div class="col-sm-4 form-group">
											<label>Mobile Number</label><span id="errMob" name="errMob" class="text-danger"> </span>
                                        	<input type ="number" class="form-control"  id="mobile" name="mobile" placeholder="Mobile Number" value = "<%=userProfile.getMobileno()%>" readonly >
										</div> --%>
										 
                                  
                                   <div class="col-sm-4 form-group">
											<label>current password</label>&nbsp; &nbsp;&nbsp;
										
											<span id = "erroldPass" class="text-danger"></span>
											<span id = "errPass" class="text-danger"></span>
                                        	<input  type ="password" class="form-control"  id="password" name="password" placeholder="current password" onblur = "return matchPreviousPassword()" >
										</div>
											</div>
											<div class="row">
										<div class="col-sm-4 form-group">
											<label>New password</label>&nbsp; &nbsp;&nbsp;
											<span id = "errorPass" class="text-danger"></span>
                                        	<input  type ="password" class="form-control"  id="newpassword" name="newpassword" placeholder="new password" onblur = "return matchpassword()" >
										</div>
									
									
										<div class="col-sm-4 form-group">
											<label>Re Enter New password</label>&nbsp; &nbsp;&nbsp;
											<span id = "errorRepass" class="text-danger"></span>
                                        	<input  type ="password" class="form-control"  id="repassword" name="repassword" placeholder="new password" onblur = "return matchpassword()" >
										</div>
                                            </div>
                                             <div class="row">              
                                    <div class="form-group col-sm-12">
                                    <button class="btn btn-default" type="submit" >Submit</button>
                                    </div>
                                    </div>
                                    <div>
                                    
                                  <li>   	Length must be greater than or equal to <b>8</b> </li>
  					   			<li> 	Must contain one or more <b>uppercase</b> characters </li>
								  <li> 	Must contain one or more <b>lowercase</b> characters </li>
								  <li> 	Must contain one or more <b>numeric</b> values </li>
								  <li> 	Must contain one or more <b>special</b> characters </li>
								                                    
                                    </div>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
             <script>
             function matchPreviousPassword(){
            	var oldpassword =  $("#password").val();
           
            	var database_pass = '<%=userProfile.getPassword() %>';
            
            	if(oldpassword != database_pass){
            		console.log("current password is incorrect");
            		
            		  document.getElementById("erroldPass").innerHTML = "current password is incorrect!"
            			  $("#erroldPass").show();
            		
            			  $(':input[type="submit"]').prop('disabled', true);
            		return false;
            	}
            	else{
            		$("#erroldPass").hide();
          
            		  $(':input[type="submit"]').prop('disabled', false);
            	}
            	
            }
            
            function matchpassword(){
            	var oldpassword =  $("#password").val();
            	var database_pass = '<%=userProfile.getPassword() %>'
            	var password = $("#newpassword").val();
            	var repassword = $("#repassword").val();
            	var regex = /^(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}$/; 
            	if(password != "" && repassword != ""){
            	if(password != repassword){
            		 console.log("Both passwords didn't match"); 
            		 document.getElementById("errorPass").innerHTML = "Both passwords didn't match!"
                		 $("#errorPass").show();
            		 $(':input[type="submit"]').prop('disabled', true);
            		 return false;
            	}
            	else {
            		 $("#errorPass").hide();
            	}
            	if( regex.test(password)) { 	 
            		console.log("password matched with regex"); 
            		 $(':input[type="submit"]').prop('disabled', false);
            
            	 } 
            	else {  
            		  document.getElementById("errorPass").innerHTML = "Password didn't match with criteria!"
            		 $("#errorPass").show();
            		console.log("password didn't match with regex");
            		 $(':input[type="submit"]').prop('disabled', true);
            		return false;} 
            	
            	}
            	if(repassword == ""){
            	
            		  document.getElementById("errorPass").innerHTML = "please fill the password!"
                 		 $("#errorRepass").show();
            		  $(':input[type="submit"]').prop('disabled', true);
            		  return false;
            	}
            	
            	 if(password == ""){
                	
          		  document.getElementById("errorPass").innerHTML = "please fill the password!"
               		 $("#errorPass").show();
          		 $(':input[type="submit"]').prop('disabled', true);
          		  return false;
          	}
            	 
            }
            </script>
            	<script>

		function validate() {
			
			var value = $("#mobile").val();
			var curr_pass =$("#password").val();
			var new_pass =$("#newpassword").val();
			var repass_pass =$("#repassword").val();
			
		  if(value.length < '10' || value.length > '10' ){
			 
			  document.getElementById("errMob").innerHTML = "&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; Mobile Number should be 10 digits!!";
			  $('#errMob').show();
			  $(':input[type="submit"]').prop('disabled', true);
			  return false;
		  }
		
		  
		  if(curr_pass == ""){
			  document.getElementById("errPass").innerHTML = "&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; current password can not be empty!";
			  $('#errPass').show();
			  $(':input[type="submit"]').prop('disabled', true);
			  return false;
		  }
		  if(new_pass == ""){
			  document.getElementById("errorPass").innerHTML = "&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; New password can not be empty!";
			  $('#errorPass').show();
			  $(':input[type="submit"]').prop('disabled', true);
			  return false;
		  }
		  if(repass_pass == ""){
			  document.getElementById("errorRepass").innerHTML = "&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; New password can not be empty!";
			  $('#errorRepass').show();
			  $(':input[type="submit"]').prop('disabled', true);
			  return false;
		  }
		}
	</script>
            <script>
		$("#zone").on("change", function() {
			var id = (this.value);
		
			if(id!=null){
				$.ajax({
					type:"GET",
					url:"findRoByZone.obj",
					data:{"id":id},
					success:function(result){				 
		 				var data= jQuery.parseJSON(result);
	 	 				var html = "<option disabled selected value>-Select-</option>";
		 				  for (var i = 0; i< data.length; i++){
		 					 html += "<option value=" +data[i].split("-")[0]+ ">"+data[i].split("-")[1]+"</option>"
		 				  }
		 				  //alert(html)
		 				$("#region").html(html);
					}			
				});
			}
		});
		
		$("#region").on("change", function() {
			var id = (this.value);	
			if(id!=null){
				$.ajax({
					type:"GET",
					url:"findDpcByRegion.obj",
					data:{"id":id},
					success:function(result){
		 				   var data= jQuery.parseJSON(result);
	 	 					 var html = "<option disabled selected value>-Select-</option>";
		 				     for (var i = 0; i< data.length; i++){
		 					 html += "<option value=" +data[i].split("-")[0]+ ">"+data[i].split("-")[1]+"</option>"
		 				  } 
		 				$("#centerordpc").html(html);
					}			
				});
			} 
		});
	</script>
            <!-- END PAGE CONTENT-->
            <%@ include file="footer.jsp"%>
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
    
    <!-- END PAGA BACKDROPS-->
    <!-- CORE PLUGINS-->
    <script src="./assets/vendors/jquery/dist/jquery.min.js" type="text/javascript"></script>
    <script src="./assets/vendors/popper.js/dist/umd/popper.min.js" type="text/javascript"></script>
    <script src="./assets/vendors/bootstrap/dist/js/bootstrap.min.js" type="text/javascript"></script>
    <script src="./assets/vendors/metisMenu/dist/metisMenu.min.js" type="text/javascript"></script>
    <script src="./assets/vendors/jquery-slimscroll/jquery.slimscroll.min.js" type="text/javascript"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
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