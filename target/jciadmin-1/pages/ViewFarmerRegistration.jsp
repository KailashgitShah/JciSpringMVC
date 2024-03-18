<%@page import="java.util.HashMap"%>
<%@page import="java.util.List"%>
<%@page import="java.io.File"%>
<%@page import="com.jci.model.ZoneModel"%>
<%@page import="com.jci.model.VerifyFarmerModel"%>
<%@page import="com.jci.model.FarmerRegModelDTO"%>
<%@page import="com.jci.model.StateList"%>
<%@page import="com.jci.controller.LoginController"%>
<%@page import="com.jci.common.Encry"%>
<%@page import="java.net.URLEncoder"%>

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

 <script src="https://code.jquery.com/jquery-1.11.3.min.js" type="text/javascript"></script>  
 <script src="https://cdn.datatables.net/1.10.9/js/jquery.dataTables.min.js" type="text/javascript"></script>  
 <link rel="stylesheet" href="https://cdn.datatables.net/1.10.9/css/jquery.dataTables.min.css" />  
 	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
 <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.0/jquery.min.js"></script>
 <script type="text/javascript">
	$(document).ready(function ()  
	{  
		 $("#farmerVerific").DataTable({         
	         scrollX: true,
	         "pageLength": 50
	       }); 
	});  
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
                <h1 class="page-title">Farmer List</h1>
            </div>
			<%
			     String key = LoginController.secretkey;
				 List <FarmerRegModelDTO>  allFarmersList = (List <FarmerRegModelDTO>) request.getAttribute("allFarmersList");
			%>
			<form action ="findByDpc.obj" onsubmit ="return findByDpc()">
			<span>${msg}</span>
			<div class="row">
				<div class="col-sm-3 form-group">
											<label id="zoneLabel" class="required">Zone</label>  &nbsp;&nbsp;&nbsp; <span id="errZone" name="errZone" class="text-danger"> </span>
											<%
												List<ZoneModel> zoneList = (List<ZoneModel>) request.getAttribute("zoneList");
											%>
											<select class="form-control" name="zone" id="zone">
												<option disabled selected value>-Select-</option>
												<%
													for(ZoneModel zoneLists : zoneList) {
												%>
												<option value="<%=zoneLists.getZonecode()%>"><%=zoneLists.getZonename()%></option>
												<%
													}
												%>
											</select>
												</div>
										<div class="col-sm-3 form-group">
											<label id="regionLabel" class="required">Region</label>&nbsp;&nbsp;&nbsp; <span id="errRegion" name="errRegion" class="text-danger"> </span>
											<!-- <input class="form-control" type="text" name="region" placeholder="Region" required> -->
											<select class="form-control" name="region" id="region">
												<option disabled selected value>-Select-</option>
											</select>
										</div>
										
										<div class="col-sm-3 form-group">
											<label id="dpclabel" class="required">DPC</label> &nbsp;&nbsp;&nbsp; <span id="errDPC" name="errDPC" class="text-danger"> </span>
											<select class="form-control" name="dpc" id="dpc">
												<option disabled selected value>-Select-</option>
											</select>
										</div>
										<div>
										<label> </label> &nbsp;&nbsp;&nbsp; 
										
										<input type = "submit" id="search" value ="search" class="btn btn-primary"/ style ="display: block;">
										</div>
									
			</div>
			</form>
                   <div class="table-responsive" style="margin-top: 20px;">                    
                        <table id="farmerVerific" class="table table-striped table-bordered table-hover" cellspacing="0"  >
								<thead>
									<tr>
										<th>Sl.No</th>
										<th>Registration No</th>
										<th>Farmer Name</th>
										<th>Mobile No</th>
										<th>State</th>
										<th>District</th>
										<th>Block</th>
										<!-- <th>Land Holding</th> -->
										<th>Is verified</th>
										<!--<th>Registered By</th>-->
										<th>Verify/Update Mandate</th>
										 <th>Edit</th>
										<th>Delete</th>
									</tr>
								</thead>
								<tbody>
								<% if(allFarmersList.size() != 0){
									
									int i = 1;
									for(FarmerRegModelDTO farmerRegModelList : allFarmersList){
										/*String firstname = "";
										String middlename = "";
										String lastname = "";
										String fname = "";
										String nfname = "";
										String[] farmerName = new  String[3];
										farmerName = farmerRegModelList.getF_NAME().split(" ");
										
									    for(int k = 0; k< farmerName.length ; k++)
									    {
									    	String farmername = farmerName[k];
									    	nfname = nfname+farmername+" ";
									    }
									 	
										if(farmerName.length == 1){
										firstname = farmerRegModelList.getF_NAME().split(" ")[0];
										fname = firstname;
										}
										else if(farmerName.length == 2){
										 firstname = farmerRegModelList.getF_NAME().split(" ")[0];
										 middlename = farmerRegModelList.getF_NAME().split(" ")[1];
										 if(middlename.equalsIgnoreCase("NA"))
											 middlename = "";
										 fname = firstname +" "+middlename;
										}
										else if(farmerName.length == 3){
											firstname = farmerRegModelList.getF_NAME().split(" ")[0];
											middlename = farmerRegModelList.getF_NAME().split(" ")[1];
											if (middlename.equalsIgnoreCase("NA"))
												middlename = "";
											lastname = farmerRegModelList.getF_NAME().split(" ")[2];
											 if(middlename.equalsIgnoreCase("NA"))
												 middlename = "";
											 fname = firstname +" "+middlename+" "+lastname;
											} */
     						           //String encryptedid = Encry.encrypt(String.valueOf(farmerRegModelList.getF_ID()),key);
     						          String encryptedid = URLEncoder.encode(Encry.encrypt(String.valueOf(farmerRegModelList.getF_ID()), key), "UTF-8");
								%>
									<tr role="row" class="odd">
									<td class="sorting_1"><%=i%></td>
									<td><a href = "viewFarmerReg.obj?id=<%=encryptedid%>" ><u><%=farmerRegModelList.getRegno() %></u></a></td>
									<td><%=farmerRegModelList.getF_NAME() %></td> 
									<td><%=farmerRegModelList.getF_MOBILE() %></td>
									<td><%=farmerRegModelList.getState() %></td>
									<td><%=farmerRegModelList.getDistrict() %></td>
									<td><%=farmerRegModelList.getBlock() %></td>
									<td>
								<%
										if(farmerRegModelList.getIS_VERIFIED()==0){
											out.print("Not Verified");
										}else{
											out.print("Verified");
											//ss
										}
										%>
										</td>
										<%-- <td><%=farmerRegModelList.getF_REG_BY() %></td> --%>
										<% if(farmerRegModelList.getF_DOC_Mandate()==null || farmerRegModelList.getF_DOC_Mandate().equalsIgnoreCase("null") ){
											if(farmerRegModelList.getMandate_flag() == 0)
											{
											%>
											<td><a href="editFarmerReg.obj?id=<%=farmerRegModelList.getF_ID()%>"class="btn btn-danger btn-sm btn-block" style="background: darkgreen;">Update Mandate</a></td>
									<% 
											}
											}
										else{
											if(farmerRegModelList.getIS_VERIFIED()==0)
											{
										%>
												<td><a href="verifyFarmer2.obj?id=<%=encryptedid%>" class="btn btn-danger btn-sm btn-block">Verify</a></td>
										<% 
											}else{
										%>
												<td></td>
										 <%}} %>

							<td><a
								href="editFarmerDetails.obj?id=<%=encryptedid%>" />EditDetails</a></td>
							



							<td><a href="deleteFarmer.obj?id=<%=farmerRegModelList.getF_ID()%>" onclick="return confirm('Are you sure you want to delete this item?');"><i class="btn btn-danger btn-sm btn-block"><i class="fa fa-trash" aria-hidden="true" style="font-size: 15px;"></i></a></td>
										</tr>
									<%
									i++; 
									}
								}
								%>
									</tbody>
                        </table>
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
        /* $(function() {
            $('#example-table').DataTable({
                pageLength: 10,
                "scrollX": true
                //"ajax": './assets/demo/data/table_data.json',
                /*"columns": [
                    { "S": "name" },
                    { "data": "office" },
                    { "data": "extn" },
                    { "data": "start_date" },
                    { "data": "salary" }
                ]
            });
        }) */
        
        
    </script>
    
    <script>
	$(document).ready(function () {
    $('#farmerVerific tfoot th').each(function () {
        var title = $(this).text();
        $(this).html('<input type="text" placeholder="Search ' + title + '" />');
    });
 
     
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
		 				$("#dpc").html(html);
					}			
				});
			} 
		});
	</script>
	
<script>

$("#search").click(function(){

	var dpc = $("#dpc").find(":selected").val();
	
	if(dpc!="")
	{
		 return true;
	   }
	else{
		alert("please select a dpc!");
		return false;
	}
	});

</script>
<script>
function findByDpc(){
	var dpc = $("#dpc").find(":selected").val();
	
	if(dpc!="")
	{
		 return true;
	   }
	else{
		alert("please select a dpc!");
		return false;
	}
}
</script>
<script>
      $(document).ready(function() {
          $('body').bind('cut copy', function(e) {
              e.preventDefault();
            });
        });
    </script>
</body>

</html>
