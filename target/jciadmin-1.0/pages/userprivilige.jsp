<!DOCTYPE html>
<html lang="en">
<%@page import="com.jci.model.UserRoleModel"%>
<%@page import="com.jci.model.UserActionModel"%>
<%@page import="java.util.List"%>
<%@ page import="javax.servlet.http.HttpServletRequest"%>
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
				<h1 class="page-title">User Privilege</h1>

				<div class="page-content fade-in-up">

					<div class="ibox">
						<span>${msg}</span>
						<div class="ibox-body">
							<form action="saveuserprivilige.obj" method="POST" name="myForm"
								onsubmit="return validate()">
								<div class="row">
									<div class="col-sm-4 form-group">


										<label>User Role</label>
										
										<input name="action" id="action" type="hidden" value="">
										<input name="action1" id="action1" type="hidden" value="">
										 <select type="text" name="userrole"id="userrole" class="form-control" placeholder="User Role"required>
										<option disabled selected value>Select</option>
<%
											List<UserRoleModel> alluserroleList = (List<UserRoleModel>) request.getAttribute("userroleList");
										//out.println("====="+request.getAttribute("arrOfStr"));
										%>
										<%
											for (UserRoleModel userrole : alluserroleList) {
										%>
										<option value="<%=userrole.getRole_Id()%>"><%=userrole.getRole_name()%></option>
										<%
											}
										%>
										</select>
									</div>


								</div>
							<div class="row">
									<div class="col-sm-4">
										<div class="mydataty"></div>
									</div>	
									<div class="col-sm-4 ">
										<div class="mydatatx"></div>
									</div>	
									<div class="col-sm-4 ">
										<div class="mydatatz"></div>
									</div>	
										</div>
								<div class="row">
									<div class="col-sm-4 form-group">


										<button class="btn btn-default" type="submit" id="create">Save</button>
										
									</div>
								</div>
							</form>


						</div>
					</div>


				</div>
			</div>
		</div>

	</div>

	<!-- END PAGE CONTENT-->
	<%@ include file="footer.jsp"%>


	<div class="sidenav-backdrop backdrop"></div>
	<script>
		$(document).ready(function() {
							var userAction = new Array();
							var allActions = new Array();
							$('select[name="userrole"]').on('change',function() {
								$('.mydataty').empty();
								$('.mydatatx').empty();
								$('.mydatatz').empty();
												cval = this.value;
												
												//alert("cval  "+ cval);
												$.get('userpriviligeajax.obj',{'roleId' : cval},
																function(responseText) {
																	var text = responseText.replace("[","").replace("]","");
																	userAction = text.split(",");
																//	console.log(">>>>> "+ userAction);
																	document.getElementById("action1").value=userAction;

												$.ajax({
															url : "userpriviligeajaxallData.obj",
															type : "GET",
															success : function(result) {
																var data = jQuery.parseJSON(result);
																allActions = result.split(",");
																//console.log("allActions "+ allActions[0]);
															    var res=allActions[0];
																let newRowAdd='';
																let values;
																var check = "";
																let cvalue ="cvalue";
																var count = 0;
																$.each(allActions,function(key,value) {
																	//console.log(value);
																var keys=value.split(":")[0].replace('["',"").replace('"',"");
																values=value.split(":")[1].replace('"]',"").replace('"',"");
															//	console.log("keys--=========>>>"+keys);
																count++;
																newRowAdd = '<div class="col-sm-12 form-group">'
																+ '<div class="input-group-prepend">'
																+ '<input type="checkbox" '+check+' value='+keys
																+ ' id='+cvalue+""+key
																+ ' name='+cvalue
																+ '><label>'+'&nbsp;&nbsp;'+values
																+ '</label>'
																+ '</div >'
																+ '</div >';
																if((count % 3) == 1 ){
																$('.mydatatx').append(newRowAdd);
																}
																else if((count % 3) == 2){
																$('.mydataty').append(newRowAdd);
																}
																else {
																$('.mydatatz').append(newRowAdd);
																}
															
																});
																
																var g = 0;
																//alert("Hello userAction==="+userAction);
																for (var j = 0; j < userAction.length; j++)
																{
																	for (var i = 0; i < allActions.length; i++)
																	{
																		var val1 = document.getElementById("cvalue"+g).value;
																	
																		if (userAction[j] == val1)
																			{
																			 document.getElementById("cvalue"+g).checked = true;
																			}
																		g++;
																	}
																	g = 0;
																}
																
															}
														});
												
												});
												
											});
						
					
		
	
			 $("#create").click(function(){
				  var ress="";
				  var c = 0;
				  for (let i = 0; i < allActions.length; i++)
				  {
					 var l1 = document.getElementById("cvalue"+c); 
					 if (l1.checked == true)
					  { 
						 var Pl1 = document.getElementById("cvalue"+c).value;
					     ress += Pl1 + ","; 
					  }
					 c++;
				  }
				  
				  var totalaction = ress.substring(0, ress.length-1);
				  alert("action"+totalaction);
				  document.getElementById("action").value=totalaction;
				  return true;
			 });
		 });
		
	
		
	</script>



<link href="<%=request.getContextPath() %>/resources/css/styleUserReg.css" rel="stylesheet">
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<script type="text/javascript" src='<%=request.getContextPath() %>/resources/js/responsivevoice.js'></script>
<script type="text/javascript" src='<%=request.getContextPath() %>/resources/js/custom.js'></script>
<script type="text/javascript" src='<%=request.getContextPath() %>/resources/js/jquery.mCustomScrollbar.concat.min.js'></script>
<script type="text/javascript" src='<%=request.getContextPath() %>/resources/js/jquery.validate.min.js'></script>

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
	</div>
</body>
</html>
