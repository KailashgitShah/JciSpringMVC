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
			
			  <div class="page-content fade-in-up">
                <div class="ibox">
                   
                    <div class="ibox-body">
                   
                       <h2 style="text-align:center;">Availabel Jute Variety Wise</h2><br>  
				  <div class="row">
                      <%
                      List<InventoryDTO> jutevarietyavailable  = (List<InventoryDTO>)request.getAttribute("jutevarietyavailable");
                      String cropyr  = (String)request.getAttribute("cropyr");
                      String Baled  = (String)request.getAttribute("Baled");
                      String basis  = (String)request.getAttribute("basis");

                      %>     
                       <div class="col-sm-3 form-group">
	                    <label>Basis</label>
	                    <input type="text" class="form-control" id="fname" name="fname" value="<%=basis%>" readonly>
                    </div>
                     <div class="col-sm-3 form-group">
	                    <label>CropYear</label>
	                    <input type="text" class="form-control" id="fname" name="fname" value="<%=cropyr%>" readonly>
                    </div>
                     <div class="col-sm-3 form-group">
	                    <label>In Bales / In Qtls</label>
	                    <input type="text" class="form-control" id="fname" name="fname" value="<%=Baled%>" readonly>
                    </div>       
						
                      </div>
                      
				 
				 <table class="table table-striped table-bordered table-hover" id="example-table" cellspacing="0" width="100%">
							

								<thead>
								<caption>Availabel Jute Variety Wise</caption>
									<tr>
										<th>Sl.no</th>
								        <th>Jute Variety</th>
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
								
								<%
								//int i = 0;
								double sumGrade1 = 0;
					            double sumGrade2 = 0;
					            double sumGrade3 = 0;
					            double sumGrade4 = 0;
					            double sumGrade5 = 0;
					            double sumGrade6 = 0;
					            double sumGrade7 = 0;
					            double sumGrade8 = 0;
					            int i = 0;
					            for (InventoryDTO  jutevarity :jutevarietyavailable) {
								
								%>
								<tbody>	
									<tr>
										<td>(<%=i+1%>)</td>
										<td id="<%=i%>regionname"><a href ="regionwiseAvailable.obj?cropyear=<%=cropyr%>&baled=<%=Baled%>&basis=<%=basis%>&variety=<%=jutevarity.getRoname()%>"><%=jutevarity.getRoname()%></a></td>
										<td id="<%=i%>loosejute"><%=jutevarity.getGrade8()%></td>
										<td id="<%=i%>grade0"><%=jutevarity.getGrade1()%></td>
										<td id="<%=i%>grade1"><%=jutevarity.getGrade2()%></td>
										<td id="<%=i%>grade2"><%=jutevarity.getGrade3()%></td>
										<td id="<%=i%>grade3"><%=jutevarity.getGrade4()%></td>
										<td id="<%=i%>grade4"><%=jutevarity.getGrade5()%></td>
										<td id="<%=i%>grade5"><%=jutevarity.getGrade6()%></td>
										<td id="<%=i%>grade6">0.0</td>
										<td id="<%=i%>grade7">0.0</td>
										<td id="<%=i%>total"><%=jutevarity.getGrade7()%></td>
									 
										</tr>
										
							
								</tbody>
						   <%
						    sumGrade1 += jutevarity.getGrade1();
			                sumGrade2 += jutevarity.getGrade2();
			                sumGrade3 += jutevarity.getGrade3();
			                sumGrade4 += jutevarity.getGrade4();
			                sumGrade5 += jutevarity.getGrade5();
			                sumGrade6 += jutevarity.getGrade6();
			                sumGrade7 += jutevarity.getGrade7();
			                sumGrade8 += jutevarity.getGrade8();
						   i++;
								}
						   %>
						   <tfoot>
						        <tr>
						            <td><b>Total</b></td>
						            <td></td> <!-- Empty cell for Region Name -->
						            <td><%= String.format("%.2f",sumGrade8) %></td>
						            <td><%= String.format("%.2f",sumGrade1) %></td>
						            <td><%= String.format("%.2f",sumGrade2) %></td>
						            <td><%= String.format("%.2f",sumGrade3) %></td>
						            <td><%= String.format("%.2f",sumGrade4) %></td>
						            <td><%= String.format("%.2f",sumGrade5) %></td>
						            <td><%= String.format("%.2f",sumGrade6) %></td>
						            <td>0.0</td>
						            <td>0.0</td>
						            <td><%= String.format("%.2f",sumGrade7) %></td> <!-- Empty cell for Total -->
						        </tr>
						    </tfoot>
                        
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
 <script>
    $(document).ready(function(){
    	$("#regioncropyr").on('change', function(){
    		var cropyr = $("#regioncropyr").val();
    		var basis = $("#regionbasis").val();
    		if(basis == "")
    		{
    			alert("Please select Basis");
        	 	return false;
    		}
    	 	$.ajax({
        		type:"GET",
    			url:"inventoryregionwisejute.obj",
    			data: {"cropyr" :cropyr,"basis" : basis}, 
    			success:function(result){
    				var jute= jQuery.parseJSON(result);
    				var response = JSON.parse(result);
    	            var regionjute = response.regionjute; // Accessing list with key "regionjute"
    	            var length = Math.min(regionjute.length);
    	            for (var i = 0; i < length; i++) {
    	                var jutes = regionjute[i];
    	                
    	        	 	document.getElementById(i + "regionname").innerHTML = '<a href="inventory_dpcwise.obj?region=' + jutes.Roname + '">' + jutes.Roname + '</a>';

    	                document.getElementById(i+"loosejute").innerHTML = jutes.grade8.toFixed(1);
    	        	 	document.getElementById(i+"grade0").innerHTML = jutes.grade1.toFixed(1);
    	        	 	document.getElementById(i+"grade1").innerHTML = jutes.grade2.toFixed(1);
    	        	 	document.getElementById(i+"grade2").innerHTML = jutes.grade3.toFixed(1);
    	        	 	document.getElementById(i+"grade3").innerHTML = jutes.grade4.toFixed(1);
    	        	 	document.getElementById(i+"grade4").innerHTML = jutes.grade5.toFixed(1);
    	        	 	document.getElementById(i+"grade5").innerHTML = jutes.grade6.toFixed(1);
    	        	 	document.getElementById(i+"grade6").innerHTML = '0.0'
    	        	 	document.getElementById(i+"grade7").innerHTML = '0.0'
    	        	 	document.getElementById(i+"total").innerHTML = jutes.grade7.toFixed(1);
    	            }
    	            return false;
    			}
    	 	});
    	}); 	
	});
    </script>
</body>

</html>
