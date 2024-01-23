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
    
    <style>
    
    .required:after {
    content:" *";
    color: red;
  }</style>
</head>

<body class="fixed-navbar" >
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
                <h1 class="page-title">Update Profile</h1>
                 
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
                                <form action="updatesaveuserProfile.obj" method="POST">
                                    <div class="row">
                      
                          <div class="col-sm-4 form-group">
                                            <label class="required">User Name</label> 
                                            <input type ="hidden" name="id" value ="<%=userProfile.getRefid()%>">
											<input class="form-control" name="username" id="username" placeholder="User Name" value="<%=userProfile.getUsername()%>" readonly>
                                        </div>
                                        <div class="col-sm-4 form-group">
                                        <label class="required">Employee Id</label> 
										<input class="form-control" name="employeeid" placeholder="Employee Id" id="employeeid" value="<%=userProfile.getEmployeeid()%>" readonly>
											
										</div>
													<div class="col-sm-4 form-group">
                                            <label class="required">Email</label>
                                            <input class="form-control" id="emailAddress"  name="emailAddress"  placeholder="Bin Email" value="<%=userProfile.getEmail()%>" >
                                          
                                        </div>
										</div>
										<div class="row">
				
                                        <div class="col-sm-4 form-group">
                                             <label class="required">Employee Name</label>
                                        <input class="form-control"  name="employeename" type="text" placeholder="Employee Name" id="employeename" value="<%=userProfile.getEmployeename()%>" readonly>
                                        </div>
                                        <div class="col-sm-4 form-group">
											<label class="required">Mobile Number</label>
                                        	<input class="form-control"  id="mobile" name="mobile" placeholder="Mobile Number" value = "<%=userProfile.getMobileno()%>" >
										</div>
										 <div class="col-sm-4 form-group">
											<label class="required">User Type </label> &nbsp;&nbsp;&nbsp; <span id="errUserType" name="errUserType" class="text-danger" > </span>
											<select class="form-control" name="usertype" id="usertype" required>
												<option disabled selected value>-Select-</option>
												<option <% if(userProfile.getUsertype().equalsIgnoreCase("Web User")){out.println("selected");}%>value="Web User">Web User</option>
												<option <% if(userProfile.getUsertype().equalsIgnoreCase("Mobile User")){out.println("selected");}%>value="Mobile User">Mobile User</option>
											</select>
										</div>
										</div>
										   
												
										
												<div class ="row">
										
										<div class="col-sm-4 form-group">
											<label class="required">Role</label>  &nbsp;&nbsp;&nbsp; <span id="errType" name="errType" class="text-danger"> </span>
											
											<select class="form-control" name="role" id="role">
												<option disabled selected value>-Select-</option>
												
											</select>
											 <input class="form-control" type="hidden" name="roletype" id="roletype">     
                                                    <input class="form-control" type="hidden" name="roleid" id="roleid">   
                                                    <input class="form-control" type="hidden" name="rolename" id="rolename">         
                                       
										</div>
                                               
                                    
										   <div class="col-sm-4 form-group">
											<label id="zoneLabel" class="required">Zone Name</label>

                                        	<%
												List<ZoneModel> zoneList = (List<ZoneModel>) request.getAttribute("zoneList");
											%>
											<select class="form-control" name="zone" id="zone">
												<option disabled selected value>-Select-</option>
												<%
													for(ZoneModel zoneLists : zoneList) {
														
															
														
												%>
												<option <% if(zoneLists.getZonecode().equalsIgnoreCase(userProfile.getZone())){ out.println("selected");} %>value="<%=zoneLists.getZonecode()%>"><%=zoneLists.getZonename()%></option>
												<%
													}
												%>
											</select>
										</div>
                                        <div class="col-sm-4 form-group">
											<label  id="regionLabel" class="required">Region Name</label>
                                        	<select class="form-control" name="region" id="region">
												<option disabled selected value>-Select-</option>
											</select></div>
                                   </div>
                                   <div class="row">
							<div class="col-sm-4 form-group">
											<label  id="dpclabel" class="required">Center Name</label>
                                        	<select class="form-control" name="centerordpc" id="centerordpc">
												<option disabled selected value>-Select-</option>
											</select></div>
											
 										</div>                       
                                    <div class="form-group col-sm-12">
                                    <button class="btn btn-default" type="submit" onclick="setroles()">Submit</button>
                                    </div>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <script>
            $(document).ready(function(){
            	var user_type;
                var variety = document.getElementById("usertype").value;
            
                if(variety=="Web User"){
                       user_type="Web User";
                }
                
                else if(variety=="Mobile User"){
                       user_type="Mobile User";
                }
                
                         $.ajax({
                                    type:"GET",
                                    url:"getuserrole.obj",
                                    data:{"user_type":user_type},
                                    success:function(result){
                                          var data= jQuery.parseJSON(result);
                                     //     console.log(data);
                                           var html = "<option disabled  value>-Select-</option>";
                                        for (var i = 0; i< data.length; i++){
                                       	
                                       	 if(data[i].split("-")[0] == <%= userProfile.getRoleId()%>){
                                       
                                           html += '<option selected data-id="'+data[i].split("-")[2]+'" value="' +data[i].split("-")[0]+'-'+data[i].split("-")[1]+ '">'+data[i].split("-")[1]+'</option>'
                                       	 }
                                       	 else{
                                        		
                                                html += '<option  data-id="'+data[i].split("-")[2]+'" value="' +data[i].split("-")[0]+'-'+data[i].split("-")[1]+ '">'+data[i].split("-")[1]+'</option>'
                                            	 }
                                            
                                      } 
                                    $("#role").html(html);
                                    }
                         });
       $("#usertype").on("change", function(){
   
             var user_type;
             var variety = document.getElementById("usertype").value;
         
             if(variety=="Web User"){
                    user_type="Web User";
             }
             
             else if(variety=="Mobile User"){
                    user_type="Mobile User";
             }
             
                      $.ajax({
                                 type:"GET",
                                 url:"getuserrole.obj",
                                 data:{"user_type":user_type},
                                 success:function(result){
                                       var data= jQuery.parseJSON(result);
                                      // console.log(data);
                                        var html = "<option disabled  selected value>-Select-</option>";
                                     for (var i = 0; i< data.length; i++){
                                    	
                                        html += '<option  data-id="'+data[i].split("-")[2]+'" value="' +data[i].split("-")[0]+'-'+data[i].split("-")[1]+ '">'+data[i].split("-")[1]+'</option>'
                                    	 }
                                    	
                                         
                                   
                                 $("#role").html(html);
                                 }
                      });
       
       });
            });
</script>
	
	<script>
	$(document).ready(function(){
	    
        var val = '<%= userProfile.getRole_type() %>';
        document.getElementById("roletype").value =  val;
      
        if(val=="HO"){
               $("#zoneLabel, #regionLabel, #dpclabel").hide();
               $("#zone, #region, #centerordpc").hide();

        }
        if(val=="ZO"){
               $("#zoneLabel").show();
               $("#zone").show();
               $("#regionLabel, #dpclabel").hide();
               $("#region, #centerordpc").hide();
        }
        
        if(val=="RO"){
               $("#zoneLabel, #regionLabel").show();
               $("#zone, #region").show();
               $("#dpclabel").hide();
               $("#centerordpc").hide();
        }
        
        if(val=="DPC"){
       	 
               $("#zoneLabel, #regionLabel, #dpclabel").show();
               $("#zone, #region, #centerordpc").show();
  
        }

       $("#role").change(function () {
             
             var val = $('#role option:selected').data("id");
             document.getElementById("roletype").value =  val;
           
             if(val=="HO"){
                    $("#zoneLabel, #regionLabel, #dpclabel").hide();
                    $("#zone, #region, #centerordpc").hide();

             }
             if(val=="ZO"){
                    $("#zoneLabel").show();
                    $("#zone").show();
                    $("#regionLabel, #dpclabel").hide();
                    $("#region, #centerordpc").hide();
             }
             
             if(val=="RO"){
                    $("#zoneLabel, #regionLabel").show();
                    $("#zone, #region").show();
                    $("#dpclabel").hide();
                    $("#centerordpc").hide();
             }
             
             if(val=="DPC"){
            	 
                    $("#zoneLabel, #regionLabel, #dpclabel").show();
                    $("#zone, #region, #centerordpc").show();
       
             }
      
             document.getElementById("roletype").value =  $('#role option:selected').data("id");
             document.getElementById("roleid").value =	$('#role option:selected').val().split("-")[0];
             document.getElementById("rolename").value =	$('#role option:selected').val().split("-")[1];
           
     });
	});
       </script>
       
       <script>
          function setroles()
          {
              document.getElementById("roletype").value =  $('#role option:selected').data("id");
              document.getElementById("roleid").value =	$('#role option:selected').val().split("-")[0];
              document.getElementById("rolename").value =	$('#role option:selected').val().split("-")[1];
          }
          
       </script>
	<script>
	 $("#ho").change(function () {
		//var val = this.val;
		var val = $('#ho option:selected').val();
		if(val==1){
			$("#zoneLabel, #regionLabel, #dpclabel").hide();
			$("#zone, #region, #centerordpc").hide();
		}
		if(val==0){
			$("#zoneLabel, #regionLabel, #dpclabel").show();
			$("#zone, #region, #centerordpc").show();
		}
     });
	
	</script>
	<script>
	$(document).ready(function () {
		$("#mobile").keyup(function() {
	var mobileno = document.getElementById("mobile").value;
	flag =  false;
	 
	var molilelen = mobileno.length;
	if(molilelen==10){
		$("#F_MOBILE").prop("type", "text");
		$("#F_MOBILE").attr("maxlength", "10");
		$("#F_MOBILE").attr("minlength", "10");
		flag =  true;
		 $.ajax({
				type:"GET",
				url:"validateUserMobile.obj",
				data:{"mobileno":mobileno},
				success:function(result){
					if(result === 'false'){
					document.getElementById("errMobile1").innerHTML = "Duplicate mobile number";
					hasError1 = true;
				
					 $(':input[type="submit"]').prop('disabled', true);
					
				}else{
					document.getElementById("errMobile1").innerHTML = "";
					if(hasError2 == false)
					 $(':input[type="submit"]').prop('disabled', false);
					hasError1 = false;
					
					}
					}
		  	});
		}
	 }); 
	}); 
		</script>
		<!-- <script>
		$(document).ready(function () {
		$('#role').change(function(){
	
			document.getElementById("rolename").value = $(this).find(':selected').attr('data-id');
			});
		});
		</script> -->
		<script>
		$(document).ready(function () {
		$("#employeeid").keyup(function() {
			var employeeid = document.getElementById("employeeid").value;
		   
				 $.ajax({
						type:"GET",
						url:"validateEmployeeid.obj",
						data:{"employeeid":employeeid},
						success:function(result){
							if(result === 'false'){
							document.getElementById("errID1").innerHTML = "Duplicate Employee ID";
							hasError2 = true;
						
							 $(':input[type="submit"]').prop('disabled', true);
						}else{
							document.getElementById("errID1").innerHTML = "";
							hasError2 = false;
							if(hasError1 == false)
							 $(':input[type="submit"]').prop('disabled', false);
						}
					}
						
				  }); 
				
			});
		
		
		}); 
		
</script>

	<script>
	 function validate() {
	
	 var username = document.forms["myForm"]["username"].value;
	 var password = document.forms["myForm"]["password"].value;
	 var ho = document.forms["myForm"]["ho"].value;
	 var zone = document.forms["myForm"]["zone"].value;
	 var region = document.forms["myForm"]["region"].value;
	 var centerordpc = document.forms["myForm"]["centerordpc"].value;
	 var usertype = document.forms["myForm"]["usertype"].value;
	 var employeeid = document.forms["myForm"]["employeeid"].value;
	 var employeename = document.forms["myForm"]["employeename"].value;
	 var emailAddress = document.forms["myForm"]["emailAddress"].value;
	 var mobile = document.forms["myForm"]["mobile"].value;
	 	  if (username == "") {
		    document.getElementById("errName").innerHTML = "Name can not be empty!";
		    document.getElementById("username").focus();
		    return false;
	 	  }
		  else if(password == ""){
			 document.getElementById("errPass").innerHTML = "Password can not be empty!";
			document.getElementById("password").focus();
			return false;
	     }
		 
		  else if(zone == ""){
				    
				  document.getElementById("errZone").innerHTML = "Zone can not be empty!";
					document.getElementById("zone").focus();
					return false;
				 
		  }
		  else if(region == ""){
				 document.getElementById("errRegion").innerHTML = "Region can not be empty!";
				document.getElementById("region").focus();
				return false;
		  }
		  else if(centerordpc == ""){
			  alert("dpc");
				 document.getElementById("errDPC").innerHTML = "Dpc can not be empty!";
				document.getElementById("centerordpc").focus();
				return false;
		  }
		  else if(usertype == ""){
				 document.getElementById("errType").innerHTML = "Usertype can not be empty!";
				document.getElementById("usertype").focus();
				return false;
		  }
		  else if(employeeid == ""){
				 document.getElementById("errID").innerHTML = "Employeeid can not be empty!";
				document.getElementById("employeeid").focus();
				return false;
		     }
		  else if(employeename == ""){
					 document.getElementById("errEMP").innerHTML = "Employeename can not be empty!";
					document.getElementById("employeename").focus();
					return false;
			  }
		  
		  else if(emailAddress == ""){
				 document.getElementById("errEmail").innerHTML = "Email Address can not be empty!";
				document.getElementById("emailAddress").focus();
				return false;
		  }
		  else if(mobile == ""){
				 document.getElementById("errMobile").innerHTML = "Mobile No. can not be empty!";
				document.getElementById("mobile").focus();
				return false;
		  }
	  
		  
}
	  </script>
	  
	  <script>
function deleteErrorMsg(){
        
 var username = document.forms["myForm"]["username"].value;
        if(username.length>2){
               $("#errName").hide();
        }
}
	  
</script> 
<script>
$(document).ready(function(){
	
		var id1 = '<%= userProfile.getZone()%>';
		//alert(id1);
		if(id1!=null){
			$.ajax({
				type:"GET",
				url:"findRoByZone.obj",
				data:{"id":id1},
				success:function(result){				 
	 				var data= jQuery.parseJSON(result);
 	 				var html = "<option disabled  value>-Select-</option>";
	 				  for (var i = 0; i< data.length; i++){
	 					  if( data[i].split("-")[0] == <%= userProfile.getRegion() %>){
	 					 html += "<option selected value=" +data[i].split("-")[0]+ ">"+data[i].split("-")[1]+"</option>"
	 				  }
	 				  else{
	 					 html += "<option  value=" +data[i].split("-")[0]+ ">"+data[i].split("-")[1]+"</option>"
	 				    
	 				  }
	 				  }
	 				  //alert(html)
	 				$("#region").html(html);
				}			
			});
		}
		else{
			$("#zoneLabel, #regionLabel, #dpclabel").hide();
			$("#zone, #region, #centerordpc").hide();
		}
		
		var id2 = '<%= userProfile.getRegion() %>';	
		if(id2!=null){
			$.ajax({
				type:"GET",
				url:"findDpcByRegion.obj",
				data:{"id":id2},
				success:function(result){
	 				   var data= jQuery.parseJSON(result);
 	 					 var html = "<option disabled  value>-Select-</option>";
	 				     for (var i = 0; i< data.length; i++){
	 				    	 if(data[i].split("-")[0] == <%= userProfile.getDpcId()%>){
	 					 html += "<option selected value=" +data[i].split("-")[0]+ ">"+data[i].split("-")[1]+"</option>"
	 				  } else{
	 					 html += "<option  value=" +data[i].split("-")[0]+ ">"+data[i].split("-")[1]+"</option>"
	 	 				  
	 				  }
	 				     }
	 				$("#centerordpc").html(html);
				}			
			});
		} 
		else{
			$(" #regionLabel, #dpclabel").hide();
			$(" #region, #centerordpc").hide();
		}
	
});
</script>
<script>
		$("#zone").on("change", function() {
			var id = (this.value);
			//alert(id);
			if(id!=null){
				$.ajax({
					type:"GET",
					url:"findRoByZone.obj",
					data:{"id":id},
					success:function(result){				 
		 				var data= jQuery.parseJSON(result);
	 	 				var html = "<option disabled selected value>-Select-</option>";
	 	 				var html2 = "<option disabled selected value>-Select-</option>";
		 				  for (var i = 0; i< data.length; i++){
		 					 html += "<option value=" +data[i].split("-")[0]+ ">"+data[i].split("-")[1]+"</option>"
		 				  }
		 				  //alert(html)
		 				$("#region").html(html);
		 				$("#centerordpc").html(html2);
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
	
	<script>
		$(document).ready(function() {
			$('#emailTosend').keyup(function(e) {
				if (e.keyCode == 8){}
					//alert('backspace trapped')
					
					
					
			})
		});
		</script>
		
		<script>
		$('#emailTosend').keyup(function(){
			   var str = this.value.replace(/(\w)[\s,]+(\w?)/g, '$1, $2');
			   if (str!=this.value) this.value = str; 
		});
		
		$('#emailTosend').keyup(function(){
		    var val = $("#emailTosend").val();
		    let text = val;
		    let result = text.indexOf(" ");
		    if(result != -1){
		    	alert(result);
		    }
			
			/* var str = this.value.replace(/(\w)[\s,]+(\w?)/g, '$1, $2');
		     if (str!=this.value) this.value = str; */ 
		});
		</script>
		
		<script>
$(document).ready(function() {
	
	  $("#EmailError").hide();
   	  $('#emailAddress').keyup(function() { 
        $("#EmailError").hide();
       
        var emailReg = /^([\w-\.]+@([\w-]+\.)+[\w-]{2,4})?$/; 
        var emailaddressVal = $("#emailAddress").val();
        if(emailaddressVal == '') {
            $("#EmailError").show();
            hasError = true;
        } 
        else if(!emailReg.test(emailaddressVal)) {
        	$("#EmailError").show();
            hasError = true;
        }
        if(hasError == true) { return false; }
 
    });
});
</script>
<script>
$(document).ready(function () {
if(hasError == true){
	//alert("if "+hasError);
	 $(':input[type="submit"]').prop('disabled', true);
}
else{
	$(':input[type="submit"]').prop('disabled', false);
}
});
</script>

 		<script>
$(document).ready(function() {
	
	  $("#usenameError").hide();
   	  $('#username').keyup(function() { 
        $("#usenameError").hide();
        var hasError = false;
        var emailReg = /^([\w-\.]+@([\w-]+\.)+[\w-]{2,4})?$/; 
        var emailaddressVal = $("#username").val();
        if(emailaddressVal == '') {
            $("#usenameError").show();
            hasError = true;
        } 
   /*      else if(!emailReg.test(emailaddressVal)) {
        	$("#usenameError").show();
            hasError = true;
        } */
        if(hasError == true) { return false; }
 
    });
});
</script> 
  <div class="sidenav-backdrop backdrop"></div>
<!--      <script>
		$(document).ready(function() {
			$('#emailTosend').keyup(function(e) {
				if (e.keyCode == 8){}
					//alert('backspace trapped')
			})
		});
		</script>
		<script src="build/js/intlTelInput.js"></script>
		<script>
		$('#emailTosend').keyup(function(){
			   var str = this.value.replace(/(\w)[\s,]+(\w?)/g, '$1, $2');
			   if (str!=this.value) this.value = str; 
		});
		
		$('#emailTosend').keyup(function(){
		    var val = $("#emailTosend").val();
		    let text = val;
		    let result = text.indexOf(" ");
		    if(result != -1){
		    	alert(result);
		    }
			/* var str = this.value.replace(/(\w)[\s,]+(\w?)/g, '$1, $2');
		     if (str!=this.value) this.value = str; */ 
		});
		</script> -->
		
<!-- 		
		<script>
		$('#mob_frm').submit(function(e) {
            e.preventDefault();
            if(!$('#mobile').val().match('[0-9]{10}'))  {
                alert("Please put 10 digit mobile number");
                return;
            }  
        });
		
		</script>
		
		
		<script>
			$('#mob_frm').submit(function(e) {
            e.preventDefault();
            if(!$('#mobile').val().match('[0-9]{10}'))  {
                alert("Please put 10 digit mobile number");
                return;
            }  

        });</script> -->
        
        
        
        <script>
        $(".toggle-password").click(function() {

        	  $(this).toggleClass("fa-eye fa-eye-slash");
        	  var input = $($(this).attr("toggle"));
        	  if (input.attr("type") == "password") {
        	    input.attr("type", "text");
        	  } else {
        	    input.attr("type", "password");
        	  }
        	});
        </script>
        
        
        
        
<!--  <script>
function validate() {

	 let username = document.forms["myForm"]["username"].value;
	 let password = document.forms["myForm"]["password-field"].value;
	 
	 
	 if (username == "") {
		    alert("Name must be filled out");
		    document.forms["myForm"]["username"].focus();
		    return false;
		  }
		  else if(password == ""){
			  alert("Caste must be filled out");
			  document.forms["myForm"]["password-field"].focus();
			  return false;
		  }
}
        
 </script>   -->  
<script>
$(document).ready(function() {
	
	  $("#EmailError").hide();
     $('#emailAddress').keyup(function() { 
        $("#EmailError").hide();
        var hasError = false;
        var emailReg = /^([\w-\.]+@([\w-]+\.)+[\w-]{2,4})?$/;
 
        var emailaddressVal = $("#emailAddress").val();
        if(emailaddressVal == '') {
            $("#EmailError").show();
            hasError = true;
        }
 
        else if(!emailReg.test(emailaddressVal)) {
        	//alert('error');
        	 $("#EmailError").show();
            hasError = true;
        }
        if(hasError == true) { return false; }
 
    });
});
</script>
<script>
    function allow_alphabets(element){
        let textInput = element.value;
        textInput = textInput.replace(/[^A-Za-z ]*$/gm, ""); 
        element.value = textInput;
    }
</script>
<script>
function validatemail(){
	var email = document.getElementById("emailAddress").value;
	var flag = false;
	for(var i=0; i<email.length; i++){
		if(email[i]=='@'){
			flag =  true
			  $.ajax({
					type:"GET",
					url:"validateEmail.obj",
					data:{"Email":email},
					success:function(result){
						document.getElementById("emailCheck").value = result;
    					if(result == 'false'){
    						document.getElementById("errEmail").innerHTML = " Email Already Exists!";
    					}
    					else{
    						document.getElementById("errEmail").innerHTML = "";
    					}
    				}			
			  });
		}
	}
	
}
</script>
	<script>
	function deleteErrorMsg(){
		
	
	var username = document.getElementById("username").value;
	var flag = false;
	var name = username.length;

	if(name != " ")
		{
		
			  $.ajax({
					type:"GET",
					url:"validateusername.obj",
					data:{"username":username},
					success:function(result){
						document.getElementById("dubName").value = result;
						if(result == 'false'){
							document.getElementById("errName").innerHTML = " User Name Already Exists!";
						}
						else{
							document.getElementById("errName").innerHTML = "";
						}
					}
			  });
		 
	
		}
	}
	
		</script>
           <!--  <script>
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
	</script> -->
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