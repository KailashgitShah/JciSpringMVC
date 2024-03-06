<%@page import="java.util.HashMap"%>
<%@page import="java.util.List"%>
<%@page import="java.io.File"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="com.jci.model.PurchaseRegisterDTO"%>

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
     <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    <!-- PLUGINS STYLES-->
    <link href="./assets/vendors/DataTables/datatables.min.css" rel="stylesheet" />
    <!-- THEME STYLES-->
    <link href="assets/css/main.min.css" rel="stylesheet" />
    <!-- PAGE LEVEL STYLES-->
    
<style>
table {
  border-collapse: collapse;
  width: 100%;
}

th, td {
  text-align: left;
  padding: 8px;
}

tr:nth-child(even) {background-color: #f2f2f2;}
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
                <h1 class="page-title">Purchase Register List</h1>
            </div>
			<%
				 List <PurchaseRegisterDTO>  batch = null; //= (List <PurchaseRegisterDTO>) request.getAttribute("purchaselist");
			%>
<div class="page-content fade-in-up">
	<div class="row">
		<div class="col-md-11">
			<div class="ibox">	
			<form action="purchaseslisting.obj" method="POST">		
			<div class="row">
				<div class="col-sm-3 form-group">
					<label class="required">Crop Year</label>
					<select class="form-control" name="cropyear" id="cropyear">
					    <option disabled selected value>-Select-</option>
					      <option value="2023-2024">2023-2024</option>
					      <option value="2022-2023">2022-2023</option>
					       
					</select>
				</div>
				<div class="col-sm-3 form-group">
					<label class="required">Place of Purchases</label>
		    <%
				Map<String,String> dpcidname = (Map<String,String>)request.getAttribute("dpcnameid");
			%>
                   <select class="form-control" name="Placeofp" id="Placeofp">
					<option disabled selected value>-Select-</option>
					<%
					 for (Map.Entry<String, String> entry : dpcidname.entrySet()) {
					%>
					<option value="<%=entry.getKey()%>"><%=entry.getValue()%></option>
					<%
						}
					%>
				</select>	
		 </div>
				
				
				<div class="col-sm-3 form-group">
					<label class="required">Basis</label>
					<select class="form-control" name="basis" id="basis">
					    <option disabled selected value>-Select-</option>
					      <option value="MSP">MSP</option>
                          <option value="Commercial">Commercial</option>
					</select>
				</div>
				<div class="col-sm-3 form-group">
					<label class="required">Date of Purchases</label>
					<input class="form-control" name="purchasesdate" id="purchasesdate" type="Date">
				</div>
		    </div>
		    <div class="row">
			    <div class="col-sm-12 form-group">
					 <input type="submit" value="Find" id="" class="btn btn-primary">
				</div>
		    </div>
		    </form>
                   <div class="table-responsive">                    
                        </div>
                       </div>
                     </div>
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
    <!-- PAGE LEVEL PLUGINS-->
    <script src="./assets/vendors/DataTables/datatables.min.js" type="text/javascript"></script>
    <!-- CORE SCRIPTS-->
    <script src="assets/js/app.min.js" type="text/javascript"></script>
    <!-- PAGE LEVEL SCRIPTS-->
    <script type="text/javascript">
        $(document).ready(function () {
            $("#farmerVerific").DataTable({         
              scrollX: true
            });
          }); 
    </script>
     <script type="text/javascript">
        $(document).ready(function () {
        	var x = document.getElementById("farmerVerific");
        	// x.style.display = "block";
        	 x.setAttribute("hidden", "hidden");
        	alert(x);
        }); 
        </script>
        
        <script type="text/javascript">
$(document).ready(function(){
	 $("#submit").click(function(){
		 var cropyear = $("#cropyear").val();
		 var Placeofp = $("#Placeofp").val();
		 var basis = $("#basis").val();
		 var purchasesdate = $("#purchasesdate").val();
		 
		 //alert(purchasesdate);
		 //return false;
		 $.ajax({
				type:"GET",
				url:"purchaseslisting.obj",
				data:jQuery.param({"cropyear":cropyear ,"Placeofp" :Placeofp, "basis":basis,"purchasesdate":purchasesdate}),
				success:function(result){
	 				 alert(result);
				}			
			});
		 
	 });
});
	 
</script>
</body>

</html>
