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
				List<Double> Contracted = (List<Double>)request.getAttribute("Contracted");
				List<Double> Despatched = (List<Double>)request.getAttribute("Despatched");
				List<Double> Payment_not_received = (List<Double>)request.getAttribute("Payment_not_received");
				List<Double> DI_in_hand = (List<Double>)request.getAttribute("DI_in_hand");

							  %>
			  <div class="page-content fade-in-up">
                <div class="ibox">
                   
                    <div class="ibox-body">
                    <h2 style="text-align:center;">2nd Level Contract In Hand</h2><br>
                    <div class="row">
                    <div class="col-sm-3 form-group">
                    </div>
                                   
										<!-- <div class="col-sm-3 form-group">
                                             <label>Basis</label>
                                             <span class="text-danger">* </span>&nbsp; <span id="errbasis" name="errbasis"
												class="text-danger"> </span>
                                        	 <select name="basis" id="basis" class="form-control" >
                                        		<option value="">-Select-</option>
                                        		<option value="msp">MSP</option>
                                        		<option value="commercial">Commercial</option>
                                        	</select>
                                        	</div> 
                     <div class="col-sm-3 form-group">
                                            <label>Crop Year</label> 
                                            <span class="text-danger">* </span>&nbsp; <span id="errcropyr" name="errcropyr"
												class="text-danger"> </span>
											<select name="cropyr" id="cropyr" class="form-control">
												<option value="">-Select-</option>
												
												</select>
                                        </div> -->
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
										<td>Contracted</td>
										<td id="loosejute">N/A</td>
										<td id="Cgrade0"><%=Contracted.get(0) %></td>
										<td id="Cgrade1"><%=Contracted.get(1) %></td>
										<td id="Cgrade2"><%=Contracted.get(2) %></td>
										<td id="Cgrade3"><%=Contracted.get(3) %></td>
										<td id="Cgrade4"><%=Contracted.get(4) %></td>
										<td id="Cgrade5"><%=Contracted.get(5) %></td>
										<td id="Cgrade6">0.0</td>
										<td id="Cgrade7">0.0</td>
										<td id="Ctotal"><%=Contracted.get(6) %></td>
										</tr>
								</tbody>
								<tbody>
									<tr>
									<%
									//Procured - Despatched = available quantity 
									%>
									    <td>(2)</td>
										<td>Despatched</td>
										<td id="Aloosejute">N/A</td>
										<td id="Cgrade0"><%=Despatched.get(0) %></td>
										<td id="Cgrade1"><%=Despatched.get(1) %></td>
										<td id="Cgrade2"><%=Despatched.get(2) %></td>
										<td id="Cgrade3"><%=Despatched.get(3) %></td>
										<td id="Cgrade4"><%=Despatched.get(4) %></td>
										<td id="Cgrade5"><%=Despatched.get(5) %></td>
										<td id="Cgrade6">0.0</td>
										<td id="Cgrade7">0.0</td>
										<td id="Ctotal"><%=Despatched.get(6) %></td>
									</tr>
								</tbody>
								<tbody>
									<tr>
									    <td>(3)</td>
										<td><a href = "contractnumber.obj" >Payment not received</a></td>
										<td id="#">N/A</td>
										<td id="Cgrade0"><%=Payment_not_received.get(0) %></td>
										<td id="Cgrade1"><%=Payment_not_received.get(1) %></td>
										<td id="Cgrade2"><%=Payment_not_received.get(2) %></td>
										<td id="Cgrade3"><%=Payment_not_received.get(3) %></td>
										<td id="Cgrade4"><%=Payment_not_received.get(4) %></td>
										<td id="Cgrade5"><%=Payment_not_received.get(5) %></td>
										<td id="Cgrade6">0.0</td>
										<td id="Cgrade7">0.0</td>
										<td id="Ctotal"><%=Payment_not_received.get(6) %></td>
									</tr>
								</tbody>
								<tbody>
									<tr>
									    <td>(4)</td>
										<td>DI in-hand</td>
										<td id="#">N/A</td>
										<td id="Cgrade0"><%=DI_in_hand.get(0) %></td>
										<td id="Cgrade1"><%=DI_in_hand.get(1) %></td>
										<td id="Cgrade2"><%=DI_in_hand.get(2) %></td>
										<td id="Cgrade3"><%=DI_in_hand.get(3) %></td>
										<td id="Cgrade4"><%=DI_in_hand.get(4) %></td>
										<td id="Cgrade5"><%=DI_in_hand.get(5) %></td>
										<td id="Cgrade6">0.0</td>
										<td id="Cgrade7">0.0</td>
										<td id="Ctotal"><%=DI_in_hand.get(6) %></td>
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
    
    
      	<script type="text/javascript">
	$(document).ready(function(){
		 $("#submit").click(function(){
			alert();
			
			
			return false;
		     });
		  });
	
	 </script>
    <script>
    $(document).ready(function(){
    	$("#cropyr").on('change', function(){
    		var cropyr = $("#cropyr").val();
    		var basis = $("#basis").val();
    		if(basis == "")
    		{
    			alert("Please select Basis");
        	 	return false;
    		}
    	 	$.ajax({
        		type:"GET",
    			url:"inventorybale.obj",
    			data: {"cropyr" :cropyr,"basis" : basis}, 
    			success:function(result){
    				 var response = jQuery.parseJSON(result);

    			        // Assuming 'bale' and 'jute' are the keys in your JSON response
    			        var bale = response.bale;
    			        var dispatched = response.dispatched;
    			        var contractInHand = response.contractInHand;
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
    	 	document.getElementById("Agrade0").innerHTML = (bale[0] - dispatched[1]).toFixed(1);
    	 	document.getElementById("Agrade1").innerHTML = (bale[1] - dispatched[2]).toFixed(1);
    	 	document.getElementById("Agrade2").innerHTML = (bale[2] - dispatched[3]).toFixed(1);
    	 	document.getElementById("Agrade3").innerHTML = (bale[3] - dispatched[4]).toFixed(1);
    	 	document.getElementById("Agrade4").innerHTML = (bale[4] - dispatched[5]).toFixed(1);
    	 	document.getElementById("Agrade5").innerHTML = (bale[5] - dispatched[6]).toFixed(1);
    	 	document.getElementById("Atotal").innerHTML = (bale[6] - dispatched[0]).toFixed(1);
    	 	
    	 	//Contract in hand
    	 	document.getElementById("Cgrade0").innerHTML = contractInHand[0].toFixed(1);
    	 	document.getElementById("Cgrade1").innerHTML = contractInHand[1].toFixed(1);
    	 	document.getElementById("Cgrade2").innerHTML = contractInHand[2].toFixed(1);
    	 	document.getElementById("Cgrade3").innerHTML = contractInHand[3].toFixed(1);
    	 	document.getElementById("Cgrade4").innerHTML = contractInHand[4].toFixed(1);
    	 	document.getElementById("Cgrade5").innerHTML = contractInHand[5].toFixed(1);
    	 	document.getElementById("Ctotal").innerHTML = contractInHand[6].toFixed(1);
    	 	
    		//Contract Un-covered
    	 	document.getElementById("CUgrade0").innerHTML = (bale[0] - contractInHand[0]).toFixed(1);
    	 	document.getElementById("CUgrade1").innerHTML = (bale[1] - contractInHand[1]).toFixed(1);
    	 	document.getElementById("CUgrade2").innerHTML = (bale[2] - contractInHand[2]).toFixed(1);
    	 	document.getElementById("CUgrade3").innerHTML = (bale[3] - contractInHand[3]).toFixed(1);
    	 	document.getElementById("CUgrade4").innerHTML = (bale[4] - contractInHand[4]).toFixed(1);
    	 	document.getElementById("CUgrade5").innerHTML = (bale[5] - contractInHand[5]).toFixed(1);
    	 	document.getElementById("CUtotal").innerHTML = (bale[6] - contractInHand[6]).toFixed(1);
    			}
    	 	});
    	}); 	
	});
    </script>
    
  <script>
 $(document).ready(function(){
	var	html = "<option selected disabled>-select-</option>";
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
 
</body>

</html>
