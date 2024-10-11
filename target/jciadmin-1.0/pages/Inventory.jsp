<<<<<<< HEAD
<%@page import="java.util.HashMap"%>
<%@page import="java.util.List"%>
<%@page import="java.io.File"%>

<%@page import="com.jci.model.BalePreparationModel"%>

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
                <h1 class="page-title">Inventory</h1>
            </div>
				
			 <div class="page-content fade-in-up">
                <div class="ibox">
                   
                    <div class="ibox-body">
                        <table class="table table-striped table-bordered table-hover" id="example-table" cellspacing="0" width="100%">


								<thead>
									<tr>
										<th>Sl.No</th>
									<th>ID</th>
										<th>DPC Name</th>
										<th>Crop Year</th>
										<th>BIN No.</th>
										<th>Jute Variety</th> 										
										<th>Basis</th>
										<th>Carry-forward Loose Jute Quantity	</th>
										<th>Carry-forward Rope Quantity</th>
									</tr>
								</thead>
								<tbody>
									
									<tr>
										<td><%=i%></td>
										<td><%=baleslis.getId()%></td>
										<td><%=baleslis.getDpcnames()%></td>
				                    	<td><%=baleslis.getCropyr()%></td>
										<td><%=baleslis.getBinnumber()%>
										<td><%=baleslis.getJutevariety()%></td> 
										<td><%=baleslis.getBasis()%></td>
										<td><%=baleslis.getCarryoverlossqty()%></td>
										<td><%=baleslis.getCarryropeqty()%></td>
										<td><a href="editBaleList.obj?id=<%=baleslis.getId()%>" class="btn btn-warning btn-sm btn-block"><i class="fa fa-pencil" aria-hidden="true" style="font-size: 15px;"></i></a></td>
										<td><a href="BaleDelete.obj?id=<%=baleslis.getId()%>" onclick="return confirm('Are you sure you want to delete this item?');" class="btn btn-danger btn-sm btn-block"><i class="fa fa-trash" aria-hidden="true" style="font-size: 15px;"></i></a></td>
									</tr>
									<% 
							i++; }
							%>
								</tbody>
   
                        </table>
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
=======
<%@page import="java.util.HashMap"%>
<%@page import="java.util.List"%>
<%@page import="java.io.File"%>
<%@page import ="java.util.*" %>
<%@page import ="java.math.BigDecimal" %>
<%@page import="com.jci.model.InventoryDTO"%>
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
                <h1 class="page-title">Inventory</h1>
            </div>
				<%  
				List<Double> jute = (List<Double>)request.getAttribute("jute");
				List<Double> dispatched = (List<Double>)request.getAttribute("dispatched");
				List<Double> contractInHand = (List<Double>)request.getAttribute("contractinhand");
		        String currCropYear =(String)request.getSession().getAttribute("currCropYear");


							  %>
			  <div class="page-content fade-in-up">
                <div class="ibox">
                   
                    <div class="ibox-body">
                    <h2 style="text-align:center;">1st Level View</h2><br>
                    <div class="row">
                                   
										<div class="col-sm-3 form-group">
                                             <label>Basis</label>
                                             <span class="text-danger">* </span>&nbsp; <span id="errbasis" name="errbasis"
												class="text-danger"> </span>
                                        	 <select name="basis" id="basis" class="form-control" onchange="updateHref()">
                                        		<option value="msp">MSP</option>
                                        		<option value="commercial">Commercial</option>
                                        	</select>
                                        	</div> 
                     
                                        <div class="col-sm-3 form-group">
                                             <label>In Bales / In Qtls</label>
                                             <span class="text-danger">* </span>&nbsp; <span id="errbasis" name="errbasis"
												class="text-danger"> </span>
                                        	 <select name="Baled" id="Baled" class="form-control"onchange="updateHref()" >
                                        		<option value="Baled">Baled</option>
                                        		<option value="Quintal">Quintal</option>
                                        	</select>
                                        	</div>
                                        <div class="col-sm-3 form-group">
                                            <label>Crop Year</label> 
                                            <span class="text-danger">* </span>&nbsp; <span id="errcropyr" name="errcropyr"
												class="text-danger"> </span>
											<select name="cropyr" id="cropyr" class="form-control" onchange="updateHref()">
												<option value="<%=currCropYear %>"><%=currCropYear %></option>
												</select>
                                        </div>	
                                        <div class="col-sm-3 form-group">
                                        <label>.</label> <br>
                                          <input type="submit" value="Find" class="btn btn-primary"
													id="submit" onclick="">
                                        </div>
                                        
                                        </div>
                        <table class="table table-striped table-bordered table-hover" id="example-table" cellspacing="0" width="100%">
							

								<thead>
								<caption>1st Level view of Procured Jute</caption>
									<tr>
										<th>Sl.no</th>
								<th></th>
									
										<th>Loose</th>
										<th>Gr1</th>
										<th>Gr2</th>
										<th>Gr3</th> 										
										<th>Gr4</th>
										<th>Gr5</th>
										<th>Gr6</th>
										<th>Gr7</th>
										<th>Gr8</th>
										<th>Total</th>
									</tr>
									
								</thead>
								<tbody>
								
									
									<tr>
									
										<td>(1)</td>
										<td><a id="procuredBaledLink" href = "regionwiseinventory.obj" >Procured/Baled</a></td>
										<td id="loosejute"><%=jute.get(7) %></td>
										<td id="grade0"><%=jute.get(0) %></td>
										<td id="grade1"><%=jute.get(1) %></td>
										<td id="grade2"><%=jute.get(2) %></td>
										<td id="grade3"><%=jute.get(3) %></td>
										<td id="grade4"><%=jute.get(4) %></td>
										<td id="grade5"><%=jute.get(5) %></td>
										<td id="grade6">0</td>
										<td id="grade7">0</td>
										<td id="total"><%=jute.get(6)%></td>
										</tr>
								</tbody>
								<tbody>
									<tr>
									<%
									//Procured - Despatched = available quantity 
									%>
									    <td>(2)</td>
										<td><a id ="availableHref" href ="regionwiseAvailable.obj" >Available</a></td>
										<td id="Aloosejute"><%=jute.get(7) - dispatched.get(7)%></td>
										<td id="Agrade0"><%=jute.get(0) - dispatched.get(0)%></td>
										<td id="Agrade1"><%=jute.get(1) - dispatched.get(1)%></td>
										<td id="Agrade2"><%=jute.get(2) - dispatched.get(2)%></td>
										<td id="Agrade3"><%=jute.get(3) - dispatched.get(3)%></td>
										<td id="Agrade4"><%=jute.get(4) - dispatched.get(4)%></td>
										<td id="Agrade5"><%=jute.get(5) - dispatched.get(5)%></td>
										<td id="Agrade6">0.0</td>
										<td id="Agrade7">0.0</td>
										<td id="Atotal"><%=jute.get(6) - dispatched.get(6)%></td>
									</tr>
								</tbody>
								<tbody>
									<tr>
									    <td>(3)</td>
										<td><a id ="contracthref" href = "contractinhand.obj" >Contract In Hand</a></td>
										<td id="#">N/A</td>
										<td id="Cgrade0"><%=String.format("%.2f",(contractInHand.get(0)/ 1.5)) %></td>
										<td id="Cgrade1"><%=String.format("%.2f",(contractInHand.get(1)/ 1.5)) %></td>
										<td id="Cgrade2"><%=String.format("%.2f",(contractInHand.get(2)/ 1.5)) %></td>
										<td id="Cgrade3"><%=String.format("%.2f",(contractInHand.get(3)/ 1.5)) %></td>
										<td id="Cgrade4"><%=String.format("%.2f",(contractInHand.get(4)/ 1.5)) %></td>
										<td id="Cgrade5"><%=String.format("%.2f",(contractInHand.get(5)/ 1.5)) %></td>
										<td id="Cgrade6">0.0</td>
										<td id="Cgrade7">0.0</td>
										<td id="Ctotal"><%=String.format("%.2f",(contractInHand.get(6)/ 1.5)) %></td> 
									</tr>
								</tbody>
								<tbody>
									<tr>
									    <td>(4)</td>
										<td><a href = "#" >Contract Un-covered</a></td>
										<td id="CUloosejute"><%=jute.get(7) %></td>
										<td id="CUgrade0"><%=String.format("%.2f",(jute.get(0) - dispatched.get(0)) - (contractInHand.get(0)/ 1.5))%></td>
										<td id="CUgrade1"><%=String.format("%.2f",(jute.get(1) - dispatched.get(1)) - (contractInHand.get(1)/ 1.5))%></td>
										<td id="CUgrade2"><%=String.format("%.2f",(jute.get(2) - dispatched.get(2)) - (contractInHand.get(2)/ 1.5))%></td>
										<td id="CUgrade3"><%=String.format("%.2f",(jute.get(3) - dispatched.get(3)) - (contractInHand.get(3)/ 1.5))%></td>
										<td id="CUgrade4"><%=String.format("%.2f",(jute.get(4) - dispatched.get(4)) - (contractInHand.get(4)/ 1.5))%></td>
										<td id="CUgrade5"><%=String.format("%.2f",(jute.get(5) - dispatched.get(5)) - (contractInHand.get(5)/ 1.5))%></td>
										<td id="CUgrade6">0.0</td>
										<td id="CUgrade7">0.0</td>
										<td id="CUtotal"><%=String.format("%.2f",(jute.get(6) - dispatched.get(6)) - (contractInHand.get(6)/ 1.5))%></td>
									</tr>
								</tbody>
   
                        </table>
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
    
    
    <script>
    $(document).ready(function(){
    	 $("#submit").click(function(){
    		var cropyr = document.getElementById("cropyr").value;
    		var basis = document.getElementById("basis").value;
    		var Baled = document.getElementById("Baled").value;
    		if(basis == "")
    		{
    			alert("Please select Basis");
        	 	return false;
    		}
    	 	$.ajax({
        		type:"GET",
    			url:"inventorybale.obj",
    			data: {"cropyr" :cropyr,"basis" : basis,"Baled" : Baled}, 
    			success:function(result){
    				 var response = jQuery.parseJSON(result);

    			        // Assuming 'bale' and 'jute' are the keys in your JSON response
    			        var bale = response.bale;
    			        var dispatched = response.dispatched;
    			        var contractinhand = response.contractinhand;
    			        //alert("procured"+bale+"contractInHand"+contractInHand)
    			       // alert(bale[2] - contractInHand[2]);
    			        
    		//Procured/baled
    	 	document.getElementById("loosejute").innerHTML = bale[7].toFixed(1);
    	 	document.getElementById("grade0").innerHTML = bale[0].toFixed(1);
    	 	document.getElementById("grade1").innerHTML = bale[1].toFixed(1);
    	 	document.getElementById("grade2").innerHTML = bale[2].toFixed(1);
    	 	document.getElementById("grade3").innerHTML = bale[3].toFixed(1);
    	 	document.getElementById("grade4").innerHTML = bale[4].toFixed(1);
    	 	document.getElementById("grade5").innerHTML = bale[5].toFixed(1);
    	 	document.getElementById("total").innerHTML = bale[6].toFixed(1);
    	 	
    	 	//Available
    	 	document.getElementById("Aloosejute").innerHTML = (bale[7] - dispatched[7]).toFixed(1);
    	 	document.getElementById("Agrade0").innerHTML = (bale[0] - dispatched[0]).toFixed(1);
    	 	document.getElementById("Agrade1").innerHTML = (bale[1] - dispatched[1]).toFixed(1);
    	 	document.getElementById("Agrade2").innerHTML = (bale[2] - dispatched[2]).toFixed(1);
    	 	document.getElementById("Agrade3").innerHTML = (bale[3] - dispatched[3]).toFixed(1);
    	 	document.getElementById("Agrade4").innerHTML = (bale[4] - dispatched[4]).toFixed(1);
    	 	document.getElementById("Agrade5").innerHTML = (bale[5] - dispatched[5]).toFixed(1);
    	 	document.getElementById("Atotal").innerHTML = (bale[6] - dispatched[6]).toFixed(1);
    	 	
    	 	if(Baled == "Baled")
    	 		{
	    	 	//Contract in hand
	    	 	document.getElementById("Cgrade0").innerHTML = (contractinhand[0]/1.5).toFixed(1);
	    	 	document.getElementById("Cgrade1").innerHTML = (contractinhand[1]/1.5).toFixed(1);
	    	 	document.getElementById("Cgrade2").innerHTML = (contractinhand[2]/1.5).toFixed(1);
	    	 	document.getElementById("Cgrade3").innerHTML = (contractinhand[3]/1.5).toFixed(1);
	    	 	document.getElementById("Cgrade4").innerHTML = (contractinhand[4]/1.5).toFixed(1);
	    	 	document.getElementById("Cgrade5").innerHTML = (contractinhand[5]/1.5).toFixed(1);
	    	 	document.getElementById("Ctotal").innerHTML = (contractinhand[6]/1.5).toFixed(1);
	    	 	
	    	 	//Contract Un-covered
	    	 	document.getElementById("CUloosejute").innerHTML = bale[7].toFixed(1);
	    	 	document.getElementById("CUgrade0").innerHTML = ((bale[0] - dispatched[0]) - (contractinhand[0]/1.5)).toFixed(1);
	    	 	document.getElementById("CUgrade1").innerHTML = ((bale[1] - dispatched[1]) - (contractinhand[1]/1.5)).toFixed(1);
	    	 	document.getElementById("CUgrade2").innerHTML = ((bale[2] - dispatched[2]) - (contractinhand[2]/1.5)).toFixed(1);
	    	 	document.getElementById("CUgrade3").innerHTML = ((bale[3] - dispatched[3]) - (contractinhand[3]/1.5)).toFixed(1);
	    	 	document.getElementById("CUgrade4").innerHTML = ((bale[4] - dispatched[4]) - (contractinhand[4]/1.5)).toFixed(1);
	    	 	document.getElementById("CUgrade5").innerHTML = ((bale[5] - dispatched[5]) - (contractinhand[5]/1.5)).toFixed(1);
	    	 	document.getElementById("CUtotal").innerHTML = ((bale[6] - dispatched[6]) - (contractinhand[6]/1.5)).toFixed(1);
    	 		}else{
    	 			//Contract in hand
    	    	document.getElementById("Cgrade0").innerHTML = (contractinhand[0]).toFixed(1);
	    	 	document.getElementById("Cgrade1").innerHTML = (contractinhand[1]).toFixed(1);
	    	 	document.getElementById("Cgrade2").innerHTML = (contractinhand[2]).toFixed(1);
	    	 	document.getElementById("Cgrade3").innerHTML = (contractinhand[3]).toFixed(1);
	    	 	document.getElementById("Cgrade4").innerHTML = (contractinhand[4]).toFixed(1);
	    	 	document.getElementById("Cgrade5").innerHTML = (contractinhand[5]).toFixed(1);
	    	 	document.getElementById("Ctotal").innerHTML = (contractinhand[6]).toFixed(1);
    	    	 	
    	    	 	//Contract Un-covered
    	    	 	document.getElementById("CUloosejute").innerHTML = bale[7].toFixed(1);
    	    	 	document.getElementById("CUgrade0").innerHTML = ((bale[0] - dispatched[0]) - (contractinhand[0])).toFixed(1);
    	    	 	document.getElementById("CUgrade1").innerHTML = ((bale[1] - dispatched[1]) - (contractinhand[1])).toFixed(1);
    	    	 	document.getElementById("CUgrade2").innerHTML = ((bale[2] - dispatched[2]) - (contractinhand[2])).toFixed(1);
    	    	 	document.getElementById("CUgrade3").innerHTML = ((bale[3] - dispatched[3]) - (contractinhand[3])).toFixed(1);
    	    	 	document.getElementById("CUgrade4").innerHTML = ((bale[4] - dispatched[4]) - (contractinhand[4])).toFixed(1);
    	    	 	document.getElementById("CUgrade5").innerHTML = ((bale[5] - dispatched[5]) - (contractinhand[5])).toFixed(1);
    	    	 	document.getElementById("CUtotal").innerHTML = ((bale[6] - dispatched[6]) - (contractinhand[6])).toFixed(1);
    	 			
    	 		}
    		
    			}
    	 	});
    	}); 	
	});
    </script>
    
  <script>
 $(document).ready(function(){
	var	html = "<option selected disabled><%=currCropYear%></option>";
		var today = new Date();
		var cropyr = today.getFullYear();
		var month = parseInt(today.getMonth()) + 1 ;
		var date = parseInt(today.getDate());
		var time = today.getHours() + ":" + today.getMinutes() + ":" + today.getSeconds();
		if(date >=  1 && month >= 7 && parseInt(today.getHours()) >= 0 && parseInt(today.getMinutes()) >= 0 && parseInt(today.getSeconds()) > 0){
		html += "<option value = '"+(cropyr - 1)+"-"+cropyr+"'>"+(cropyr - 1 )+"-"+cropyr+"</option>";
		html += "<option value = '"+cropyr+"-"+(cropyr + 1)+"'>"+cropyr+"-"+(cropyr + 1)+"</option>";
		}
		else{
			html += "<option value = '"+(cropyr - 2)+"-"+(cropyr - 1)+"'>"+(cropyr - 2)+"-"+(cropyr - 1)+"</option>";
			html += "<option value = '"+(cropyr - 1)+"-"+cropyr+"'>"+(cropyr - 1 )+"-"+cropyr+"</option>";
		}
		$("#cropyr").html(html);
		$("#regioncropyr").html(html);
	}); 
	

</script>
<script type="text/javascript">
        function updateHref() {
            // Get the selected value from the dropdown
        	var basis = document.getElementById("basis").value;
            var cropyear = document.getElementById("cropyr").value;
            var baled = document.getElementById("Baled").value;

            // Construct the new href value with query parameters
            var newHref = "regionwiseinventory.obj?basis=" + encodeURIComponent(basis) +
                          "&cropyear=" + encodeURIComponent(cropyear) +
                          "&baled=" + encodeURIComponent(baled);

            var availableHref = "regionwiseAvailable.obj?basis=" + encodeURIComponent(basis) +
            "&cropyear=" + encodeURIComponent(cropyear) +
            "&baled=" + encodeURIComponent(baled);
            
            var contrathref =  "contractinhand.obj?basis=" + encodeURIComponent(basis) +
            "&cropyear=" + encodeURIComponent(cropyear) +
            "&baled=" + encodeURIComponent(baled);
            // Update the href attribute of the <a> tag
            document.getElementById("procuredBaledLink").href = newHref;
            document.getElementById("availableHref").href = availableHref;
            document.getElementById("contracthref").href = contrathref;


        }

        // Optionally, initialize the link when the page loads
        window.onload = updateHref;
</script>    		
    		
</body>

</html>
>>>>>>> 8d18cac28d2d316bbcf7768a43d8d15bcda137d5
