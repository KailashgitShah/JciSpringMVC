<%@page import="java.util.HashMap"%>
<%@page import="java.util.List"%>
<%@page import="java.io.File"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="com.jci.model.RoDetailsModel"%>

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
                <h1 class="page-title">Purchase Register Report</h1>
            </div>
			<%
		    String currCropYear = (String) session.getAttribute("currCropYear");
		    String priviouscropyear = (String) session.getAttribute("priviouscropyear");
				 //List <PurchaseRegisterDTO>  batch = null; //= (List <PurchaseRegisterDTO>) request.getAttribute("purchaselist");
			%>
<div class="page-content fade-in-up">
	<div class="row">
		<div class="col-md-11">
		<span>${msg}</span>
			<div class="ibox">	
			<form action="purchaseslisting.obj" method="POST">		
			<div class="row">
				<div class="col-sm-3 form-group">
					<label class="required">Crop Year</label>
					<select class="form-control" name="cropyear" id="cropyear">
					    <option disabled selected value>-Select-</option>
					      <option value="<%=currCropYear%>"><%=currCropYear %></option>
					      <option value="<%=priviouscropyear%>"><%=priviouscropyear%></option>
					       
					</select>
				</div>
				<div class="col-sm-3 form-group">
					<label class="required">Region</label>
		    <%
				List<RoDetailsModel> Regions = (List<RoDetailsModel>)request.getAttribute("Regions");
			%>
                   <select class="form-control" name="region" id="region">
					<option disabled selected value>-Select-</option>
					<%
					 for (RoDetailsModel region : Regions) {
					%>
					<option value="<%=region.getRocode()%>"><%=region.getRoname()%></option>
					<%
						}
					%>
				</select>	
		 </div>
				
				<div class="col-sm-3 form-group">
				<label id="dpclabel" class="required">DPC</label>
				<select class="form-control" name="dpc" id="dpc">
					<option disabled selected value>-Select-</option>
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
		    </div>
		    <div class="row">
		        <div class="col-sm-3 form-group">
					<label class="required">Date of Purchases From</label>
					<input class="form-control" name="purchasesdatefrom" id="purchasesdatefrom" type="Date">
				</div>
				<div class="col-sm-3 form-group">
					<label class="required">Date of Purchases To</label>
					<input class="form-control" name="purchasesdateto" id="purchasesdateto" type="Date">
				</div>
		     </div>
		    <div class="row">
			    <div class="col-sm-12 form-group">
					 <input type="submit" value="Generate Report" id="submit" class="btn btn-primary">
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
            
            function reloadPage() {
                window.location.reload(true); // true parameter forces a reload from the server
            }
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
		 var region = $("#region").val();
		 var dpc = $("#dpc").val();
		 var basis = $("#basis").val();
		 var datefrom = $("#purchasesdatefrom").val();
		 var dateto = $("#purchasesdateto").val();
		 
		 if(cropyear == "" || region == "" || dpc == "" || basis == "" || datefrom == "" || dateto == "")
			 {
			   alert("All Fields Are Mandatory");
			   return false;
			 }
		 
		 //alert(purchasesdate);
		 //return false;
	 });
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
				 				$("#dpc").html(html);
							}			
						});
					} 
				});	
					 
</script>
</body>

</html>
