<%@page import="java.util.HashMap"%>
<%@page import="java.util.List"%>
<%@page import="java.io.File"%>
<%@page import="com.jci.model.BalePreparationModel"%>
<%@page import="com.jci.model.BalePreparation"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.jci.model.ZoneModel"%>



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
                <h1 class="page-title">Packing Register</h1>
                 
            </div>
				
				<%
					List<BalePreparation> viewBalePreparation = (List<BalePreparation>) request.getAttribute("balePrepList");
				System.out.println("viewBalePreparation==99"+viewBalePreparation.toString());
				  String cropYear =  (String)request.getAttribute("cropYear"); 
	                // String placeofPurchase =  (String)request.getAttribute("placeOfPurchase");
	                 String juteVariety =  (String)request.getAttribute("jutevariety");
	                 String fromdate =  (String)request.getAttribute("fromdate");
	                 String todate =  (String)request.getAttribute("todate");
	                 String Basis =  (String)request.getAttribute("Basises");
	                 String dpc =  (String)request.getAttribute("dpc");
	                 String roname =  (String)request.getAttribute("roname");
	                 //String dpc =  (String)request.getAttribute("dpc");
				
				%>
				 <form action = "pdfDpcBalePrep.obj"  onsubmit = "return validation()">
				       <div class="page-content fade-in-up">
				       
				    
										
		   
									
				      
            <div class="row">
              <div class="col-sm-4 form-group">
              
								
									<label class="required">Crop Year</label> <input class="form-control"
										type="text" name="cropyear" id ="cropyear" placeholder="Crop Year" value="<%=cropYear %>">
								</div>
								
									  <div class="col-sm-4 form-group">
									<label class="required">Jute Variety</label> <input class="form-control"
										type="text" name="juteVariety" id ="juteVariety" placeholder="Jute Variety" value="<%=juteVariety %>">
								</div>
										<div class="col-sm-4 form-group">
									<label class="required">Basis</label> <input class="form-control"
										type="text" name="basis" id="basis" placeholder="Basis" value="<%=Basis %>">
								</div>	
							</div>
							<div class ="row">
					
			 <div class="col-sm-4 form-group">
											<label>From Date</label> 
											<span class="text-danger">* </span>&nbsp; <span id="errfromdate" name="errfromdate"
												class="text-danger"> </span>
											<input class="form-control" name="fromdate" id="fromdate"  placeholder="dd-mm-yyyy" value="<%=fromdate%>" readonly>
										</div>
			<div class="col-sm-4 form-group">
											<label>To Date</label> 
											<span class="text-danger">* </span>&nbsp; <span id="errtodate" name="errtodate"
												class="text-danger"> </span>
											<input class="form-control" name="todate" id="todate"  placeholder="dd-mm-yyyy" value="<%=todate%>" readonly>
										</div>
										
										<div class="col-sm-4 form-group">
											<label id="dpclabel" class="required">DPC</label> <input class="form-control"
										 name="dpc" id="dpc" placeholder="dpc" value="<%=dpc %>">
										</div>
										</div>
										<div class="row">
			
			<div class="form-group">
								<label></label> <br>
    <a href="http://localhost:8080/jciadmin/RegionWiseBaleData.obj?cropyear=2023-2024&fromdate=05-04-2024&todate=03-07-2024&basis=MSP&juteVariety=Tossa%20(New)&region=Krishnanagar">Go Back</a>
                                        
        			</div>
                                        
                                    </div>
										
<div class="ibox">
		
                    <span>${msg}</span>
                    <div class="ibox-body">
                    <div class="scrollmenu">
                        <table class="table table-striped table-bordered table-hover" id="example-table" cellspacing="0" width="100%">							
								
								<thead>
									<tr>
										<th>S.No.</th> 
											 <th>Packing Date </th>	
									    <th>Nominal Weight</th>
									    <th>Grade 1</th>
									    <th>Grade 2</th>
									    <th>Grade 3</th>
									    <th>Grade 4</th>
									    <th>Grade 5</th>	
									    <th>Grade 6</th>
									    <th>Grade 7</th>	
									    <th>Grade 8</th>
						
									<th>Total</th>
										<!-- <th></th>
										<th></th> -->
									</tr>
								</thead>
								<tbody>
									<% 
									int i= 1;
									for(BalePreparation balePreparationLists : viewBalePreparation){
									
									%>
									<tr>
										<td><%=i%></td>
										<td><%=balePreparationLists.getPacking_date()%></td>
										<td><%=balePreparationLists.getNominalWt()%></td>
										<td><%=balePreparationLists.getGarde1()%></td>
										<td><%=balePreparationLists.getGarde2()%></td>
										<td><%=balePreparationLists.getGarde3()%></td>
										<td><%=balePreparationLists.getGarde4()%></td>
										<td><%=balePreparationLists.getGarde5()%></td>
										<td><%=balePreparationLists.getGarde6()%></td>
										<td><%=balePreparationLists.getGarde7()%></td>
										<td><%=balePreparationLists.getGarde8()%></td>
										<%
					int total = balePreparationLists.getGarde1() + balePreparationLists.getGarde2() + balePreparationLists.getGarde3() + balePreparationLists.getGarde4() + balePreparationLists.getGarde5() + balePreparationLists.getGarde6() + balePreparationLists.getGarde7() +balePreparationLists.getGarde8();
				
				%>
				<td><%=total%></td>
									</tr>
									<%
							i++; }
							
							%>
								</tbody>

	   		
	
							
                        </table>
                    </div>
                    	<div class="col-sm-4 form-group">
										<label> </label> &nbsp;&nbsp;&nbsp; 
										
 <button class="btn btn-default" type="submit">Download</button>										</div>
                </div>
                 </form>
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
    <link rel="stylesheet" href="//code.jquery.com/ui/1.13.2/themes/base/jquery-ui.css">
<link rel="stylesheet" href="/resources/demos/style.css">
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
<script src="https://code.jquery.com/ui/1.13.2/jquery-ui.js"></script>
<script>
$( "#todate" ).datepicker({ dateFormat: 'dd-mm-yy'    });
$( "#fromdate" ).datepicker({ dateFormat: 'dd-mm-yy'    });
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


	function validation(){
	var dpc = $("#dpc").find(":selected").val();
	var fromDate = $("#fromdate").val();
	var toDate = $("#todate").val();
	if(dpc!="" && toDate != "" && fromDate != "")
	{
		 return true;
	   }
	else{
		alert("please fill all the fields!");
		return false;
	}
}

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
</body>

</html>