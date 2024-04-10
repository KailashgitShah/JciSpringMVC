<%@page import="com.jci.model.JciDIHoModel"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.List"%>
<%@page import="java.io.File"%>
<%@page import="com.jci.model.RoleMasterModel"%>
<%@page import="com.jci.model.ZoneModel"%>

<%@page import="com.jci.model.UserRegistrationModel"%>

<%@page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 


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
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<!-- PLUGINS STYLES-->
<link href="./assets/vendors/DataTables/datatables.min.css"
	rel="stylesheet" />
<!-- THEME STYLES-->
<link href="assets/css/main.min.css" rel="stylesheet" />
<!-- PAGE LEVEL STYLES-->
<script type="text/javascript">
	$(document).ready(function() {
		$("#farmerVerific").DataTable({
			scrollX : true,
			"pageLength" : 50
		});
	});
</script>
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
input[type="file"] {
	color: transparent;
}

/* input[type="file"]::before {
  content: "Select File";
  color: #333; /* Set your desired text color */
}
* /

 input[type="file"]:hover::before {
	color: #555; /* Set your desired text color on hover */
}
</style>
<script src="https://code.jquery.com/jquery-3.6.4.min.js"></script>
<script>
	function f() {

		window.location.reload();

	}
</script>

<%-- <script>
    // Retrieve the value of the "username" session variable
    var useremail = '<%=session.getAttribute("usrname")%>';
    // Retrieve the value of the "rolename" session variable
    var userole= '<%=session.getAttribute("rolename")%>
	';

	// Set the value of the input fields
	document.getElementById("created_by_username").value = useremail;
	document.getElementById("created_by_role").value = userole;
</script> --%>
<script>
    // Retrieve the value of the "username" session variable
    var useremail = '<%=session.getAttribute("username")%>';
    // Retrieve the value of the "rolename" session variable
    var userrole = '<%=session.getAttribute("rolename")%>
	';

	// Set the value of the input fields
	document.getElementById("created_by_username").value = useremail;
	document.getElementById("created_by_role").value = userole;
</script>

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
				<h1 class="page-title">Mill Registration</h1>
			</div>
			<div class="page-content fade-in-up">
				<div class="row">
					<div class="col-md-11">
						<div class="ibox">
							<div class="ibox-head">

								<span>${msg}</span>
							</div>
							<div class="ibox-body">
								<form action="savemillregister.obj" method="POST">
									<input type="hidden" name="emailCheck" id="emailCheck">
									<input type="hidden" name="dubName" id="dubName">
									<div class="row">

										<div class="col-sm-4 form-group">
											<label>Mill </label> <select name="mill_name" id="Mill"
												class="form-control taxtbox" required onchange="MillCode()">

												<option value="">-Select-</option>

												<c:forEach items="${millid}" var="item">

													<option value="${item}">${item}</option>

												</c:forEach>

											</select>
										</div>
										<div class="col-sm-4 form-group">
											<label class="required">Mill Email</label> &nbsp;&nbsp;&nbsp;
											<span id="errEmail" name="errEmail" class="text-danger">
											</span> <input class="form-control" autocomplete="off" type="text"
												id="emailAddress" name="mill_emailaddress"
												placeholder="Email address"
												pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,63}$"
												onkeyup="validatemail()">

										</div>

										<div class="col-sm-4 form-group">
											<label class="required">Mill Password</label>
											&nbsp;&nbsp;&nbsp; <span id="errPass" name="errPass"
												class="text-danger"> </span> <input id="password"
												type="password" class="form-control" name="mill_password"
												value="" placeholder="Password"
												onblur="return matchpassword()"> <span
												toggle="#password"
												class="fa fa-fw fa-eye field-icon toggle-password"></span>
										</div>



									</div>
									<div class="row">

										<div class="col-sm-4 form-group">
											<label class="required">Mill Code</label> &nbsp;&nbsp;&nbsp;
											<span id="errID" name="errID" class="text-danger"> </span><span
												id="errID1" name="errID1" class="text-danger"> </span> <input
												class="form-control" name="mill_code" type="text"
												placeholder=" Code" id="millunitcode" ReadOnly>
										</div>



										<div class="col-sm-4 form-group">
											<label class="required">Created By UserName</label> <input
												class="form-control" id="created_by_username"
												name="created_by_username" value = "<%=session.getAttribute("usrname")%>"
												placeholder="<%=session.getAttribute("usrname")%>" readonly>
										</div>

										<div class="col-sm-4 form-group">
											<label class="required">Created By Role</label> <input
												class="form-control" id="created_by_role"
												name="created_by_rolename"
												value="<%=session.getAttribute("rolename")%>"
												placeholder="<%=session.getAttribute("rolename")%>" readonly>
										</div>
									</div>
									<div class="row">
										<div class="col-sm-4 form-group">
											<label class="required">Mobile Number</label>
											&nbsp;&nbsp;&nbsp; <span id="errMobile" name="errMobile"
												class="text-danger"> </span><span id="errMobile1"
												name="errMobile1" class="text-danger"> </span>
											<div class="input-group-prepend">
												<span class="input-group-text" id="basic-addon1">+91</span>
												<input class="form-control" type="tel" maxlength="10"
													minlength="10"
													onkeyup="this.value=this.value.replace(/[^0-9]/g,'');"
													" id="mobile" name="mill_mobile"
													title="10 digit mobile number" placeholder="Mobile Number">

											</div>
										</div>

									</div>









									<div class="row">
										<div class="col-sm-12 form-group">
											<input type="submit" value="Submit" id="submit"
												class="btn btn-primary">
											<!-- <input class="btn btn-primary" type="submit" id="enq_submit">Submit</button> -->
										</div>
									</div>
								</form>
							</div>
						</div>
					</div>
				</div>
				<div>
					<ul>
						<li>Length must be greater than or equal to <b>8</b>
						</li>
						<li>Must contain one or more <b>Uppercase</b> characters
						</li>
						<li>Must contain one or more <b>Lowercase</b> characters
						</li>
						<li>Must contain one or more <b>Numeric</b> values
						</li>
						<li>Must contain one or more <b>Special</b> characters
						</li>
					</ul>
				</div>

			</div>
			<!-- END PAGE CONTENT-->
			<%@ include file="footer.jsp"%>
		</div>
	</div>

	<div class="sidenav-backdrop backdrop"></div>














</body>
<script>
	function matchpassword() {

		var password = $("#password").val();

		var regex = /^(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}$/;
		if (regex.test(password)) {
			$("#errPass").hide();
			$(':input[type="submit"]').prop('disabled', false);
			return true;
		} else {
			document.getElementById("errPass").innerHTML = "Password didn't match with criteria!"
			$("#errPass").show();
			$(':input[type="submit"]').prop('disabled', true);
			return false;

		}
	}
</script>
<script type="text/javascript">
	$(document).ready(function() {

		$('#Mill').on('change', function() {

			var selectedOption = $(this).val();

			$.ajax({
				type : 'GET',
				url : 'millcodefetch.obj',
				data : {

					millid : selectedOption

				},
				success : function(data) {

					var response = JSON.parse(data);
					response[0]
					$('#millunitcode').val(response[0]);

				},
				error : function(err) {
					// Handle errors here
					console.error('AJAX request failed: ' + err);
				}

			});
		});
	});
</script>

<!-- CORE PLUGINS-->
    <script src="./assets/vendors/jquery/dist/jquery.min.js" type="text/javascript"></script>
    <script src="./assets/vendors/popper.js/dist/umd/popper.min.js" type="text/javascript"></script>
    <script src="./assets/vendors/bootstrap/dist/js/bootstrap.min.js" type="text/javascript"></script>
    <script src="./assets/vendors/metisMenu/dist/metisMenu.min.js" type="text/javascript"></script>
    <script src="./assets/vendors/jquery-slimscroll/jquery.slimscroll.min.js" type="text/javascript"></script>
    <!-- PAGE LEVEL PLUGINS-->
    <script src="./assets/vendors/DataTables/datatables.min.js" type="text/javascript"></script>
    <!-- CORE SCRIPTS-->
    <script src="assets/js/app.min.js" type="text/javascript"></script>
    <!-- PAGE LEVEL SCRIPTS-->
    <script type="text/javascript">
        $(function() {
            $('#example-table').DataTable({
            	
            	    fixedHeader: true
            
            });
        })
  
    </script>
</html>

