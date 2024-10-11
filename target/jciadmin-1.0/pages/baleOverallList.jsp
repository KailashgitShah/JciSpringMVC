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
    
   <!--  THEME STYLES -->
    <link href="assets/css/main.min.css" rel="stylesheet" />
   


 


    <!-- <link href="css/jquery.dataTables.min.css" rel="stylesheet"> -->
   <!--  <script src="./assets/vendors/jquery/dist/jquery.min.js" type="text/javascript"></script>
    <script src="./assets/vendors/popper.js/dist/umd/popper.min.js" type="text/javascript"></script>
    <script src="./assets/vendors/bootstrap/dist/js/bootstrap.min.js" type="text/javascript"></script>
     <script src="./assets/vendors/jquery-slimscroll/jquery.slimscroll.min.js" type="text/javascript"></script> 
    <script src="./assets/vendors/DataTables/datatables.min.js" type="text/javascript"></script>
    <script src="assets/js/app.min.js" type="text/javascript"></script>   
    <link rel="stylesheet" href="//code.jquery.com/ui/1.13.2/themes/base/jquery-ui.css">
    <link rel="stylesheet" href="/resources/demos/style.css">
    <script src="https://code.jquery.com/jquery-3.6.0.js"></script>
	 <script src="https://code.jquery.com/ui/1.13.2/jquery-ui.js"></script> 
  
	 -->
	 
<!-- 	<script type="text/javascript" src="https://cdn.datatables.net/buttons/1.3.1/js/dataTables.buttons.min.js"></script> 
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/jszip/3.1.3/jszip.min.js"></script>
<script type="text/javascript" src="https://cdn.datatables.net/buttons/1.3.1/js/buttons.html5.min.js"></script>
<script type="text/javascript" src="https://code.jquery.com/jquery-3.5.1.js"></script>
<script type="text/javascript" src="https://cdn.datatables.net/1.10.25/js/jquery.dataTables.min.js"></script>
<script type="text/javascript" src="https://cdn.datatables.net/buttons/1.7.1/js/dataTables.buttons.min.js"></script>
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/jszip/3.1.3/jszip.min.js"></script>
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/pdfmake/0.1.53/pdfmake.min.js"></script>
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/pdfmake/0.1.53/vfs_fonts.js"></script>
<script type="text/javascript" src="https://cdn.datatables.net/buttons/1.7.1/js/buttons.html5.min.js"></script>
<script type="text/javascript" src="https://cdn.datatables.net/buttons/1.7.1/js/buttons.print.min.js"></script>
<link rel="stylesheet" href="https://cdn.datatables.net/1.10.25/css/jquery.dataTables.min.css">
<link rel="stylesheet" href="https://cdn.datatables.net/buttons/1.7.1/css/buttons.dataTables.min.css"> -->
    
   
  
   
    
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
				
												 <form action = "pdfallListofBalePrep.obj"  onsubmit = "return validation()">
				
			 <div class="page-content fade-in-up">
                <div class="ibox">
                    <span>${msg}</span>
                    <div class="ibox-body">
                    <div class="row">
							<div class="col-sm-4 form-group">
												<label id="regionLabel" class="required">cropyear</label>&nbsp;&nbsp;&nbsp; <span id="errRegion" name="errRegion" class="text-danger"> </span>
											<!-- <input class="form-control" type="text" name="region" placeholder="Region" required> -->
											<select class="form-control" name="cropyear" id="cropyear">
												<option disabled selected value>-Select-</option>
												<option value="2023-2024">2023-2024</option>
												<option value="2024-2025">2024-2025</option>
											</select>
												</div>
	
                                        <div class="col-sm-4 form-group">
											<label>From Date</label> 
											<span class="text-danger">* </span>&nbsp; <span id="errfromdate" name="errfromdate"
												class="text-danger"> </span>
											<input class="form-control" name="fromdate" id="fromdate"  placeholder="dd-mm-yyyy" value="" readonly>
										</div>
										
										 <div class="col-sm-4 form-group">
											<label>To Date</label> 
											<span class="text-danger">* </span>&nbsp; <span id="errfromdate" name="errfromdate"
												class="text-danger"> </span>
											<input class="form-control" name="todate" id="todate"  placeholder="dd-mm-yyyy" value="" readonly>
										</div>
			

	
</div>



			<div class ="row">
			
				<div class="col-sm-4 form-group">
    <label id="basisLabel" class="required">Basis</label>&nbsp;&nbsp;&nbsp;
    <span id="errBasis" name="errBasis" class="text-danger"> </span>
    <select class="form-control" name="basis" id="basis">
        <option disabled selected value>-Select-</option>
        <option value="MSP">MSP</option>
        <option value="Commercial">COMMERCIAL</option>
    </select>
</div>
			<div class="col-sm-4 form-group">
    <label id="juteVarietyLabel" class="required">Jute Variety</label>&nbsp;&nbsp;&nbsp;
    <span id="errJuteVariety" name="errJuteVariety" class="text-danger"> </span>
<select class="form-control" name="juteVariety" id="juteVariety" onchange="handleChange()">
     <option disabled selected value>-Select-</option>
        <option value="">-Jute Variety-</option>
                                        	
                                        	</select>
        <!-- Options will be dynamically updated based on the selection in the "Basis" dropdown -->
    </select>
</div>
						<div class="col-sm-4 form-group">
									<button id="sRfcDate"
				style="color: azure; font-family: none; background: indigo; font-size: 15px; margin: 12px;">Show</button>
		
			</div>
                       
	<div class="row">
		<div class="col-12">
			<div class="card">
				<div class="card-body">
					<div class="table-responsive">  

          <div id = "stats"  style="margin-top: 10px; margin-bottom: 5px; font-family: none;"></div>
						
					  	<table id="dprnew" class="table table-bordered table-striped">
							<thead>

								<tr>
									<th>Region Name</th>
									<th>Nominal Weight</th>
									<th>Grade 1</th>
									<th>Grade 2</th>
									<th>Grade 3</th>
									<th>Grade 4</th>
									<th>Grade 5</th>
									<th>Grade 6</th>
									<th>Grade 7</th>
									<th>Grade 8</th>

								</tr>

							</thead>



							<tbody>

								<tr>
									<td></td>
									<td></td>
									<td></td>
									<td></td>
									<td></td>
									<td></td>
									<td></td>
									<td></td>
									<td></td>
									<td></td>
							</tbody>

						</table>
					</div>
						</div>
	
						</div>
	
						</div>
	
							
                        
                    </div>
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
    
    <div class="sidenav-backdrop backdrop"></div>
    
    
   
    <!-- Include jQuery -->
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<!-- Include jQuery UI CSS -->
<link rel="stylesheet" href="https://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<!-- Include jQuery UI JavaScript -->
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.min.js"></script>  

 
    <!-- Include DataTables CSS -->
    <link rel="stylesheet" href="https://cdn.datatables.net/1.13.0/css/jquery.dataTables.min.css">
    <!-- Include DataTables JavaScript -->
    <script src="https://cdn.datatables.net/1.13.0/js/jquery.dataTables.min.js"></script>
    <!-- Include DataTables Buttons CSS -->
    <link rel="stylesheet" href="https://cdn.datatables.net/buttons/2.3.4/css/buttons.dataTables.min.css">
    <!-- Include DataTables Buttons JavaScript -->
    <script src="https://cdn.datatables.net/buttons/2.3.4/js/dataTables.buttons.min.js"></script>
    <script src="https://cdn.datatables.net/buttons/2.3.4/js/buttons.html5.min.js"></script>
    <script src="https://cdn.datatables.net/buttons/2.3.4/js/buttons.print.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jszip/3.10.1/jszip.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/pdfmake/0.2.5/pdfmake.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/pdfmake/0.2.5/vfs_fonts.js"></script>



 
    <script type="text/javascript"> 
     
	$(document).ready(function() {
 
		$('#sRfcDate').click(function() {
			//alert('hi');
			var cropyear = $('#cropyear').val();
			var fromdate = $('#fromdate').val();
			var todate = $('#todate').val();
			var basis = $('#basis').val();
			var juteVariety = $('#juteVariety').val();
			// alert(dateFrom+" to "+dateTo);
			$("#myloader").show();
			$.get('allListofBalePrep.obj', {
				cropyear : cropyear,
				fromdate : fromdate,
				todate : todate,
				basis : basis,
				juteVariety : juteVariety,
			}, function(data) {
			//	$("#myloader").hide();
		//		$("#loaderWait").hide();
				//alert(data);
				drawtable(data);
			});
		});
	});
</script>
    <script>
function handleChange() {
    var selectedVariety = document.getElementById("juteVariety").value;
    console.log("Selected Jute Variety: " + selectedVariety);
    // Add more functionality here as needed
}
</script>
<script>
	function drawtable(data) {
		var cropyear = document.getElementById("cropyear").value;
		var juteVariety = document.getElementById("juteVariety").value;
		var basis = document.getElementById("basis").value;
		var todate = document.getElementById("todate").value;
		var fromdate = document.getElementById("fromdate").value;
		juteVariety = decodeURIComponent(juteVariety);


		var datam = data;
		console.log(datam.data);
		var KeyValueData = tableData(datam);
		 
		var drawdata = {
			"data" : KeyValueData
		};
		console.log("=-=-=-=-=-=-=-=>", drawdata.data);
 
		table = $('#dprnew').DataTable(
						{
							processing : true,
							destroy : true,
							autoWidth : false,
							data : drawdata.data,
							scrollY : 580,
							scrollX : true,
							paging : false,
							ordering : true,
							dom: 'Bfrtip',
						    buttons: [
						    	  {
						                extend: 'excelHtml5',
						                title: 'Report export'
						            },
						             
						            {
						                extend: 'csvHtml5',
						                title: 'Report export'
						            },
						            {
						                extend: 'copyHtml5',
						                title: 'Report export'
						            }
						         
						    ],
						    columnDefs: [{
						        defaultContent : "",
						        targets : "_all"
						      }],
							
							columns : [
								
								    {
								    	render : function(data, type, row) {
											var region = row.Region;
											var agent_id = row.agent_id; 
											var from_date = row.from_date;
											var to_date = row.to_date;
											var location = $("#locationlist").val();
											return '<a  href="RegionWiseBaleData.obj?cropyear='
													+ cropyear + '&fromdate=' +fromdate+'&todate='+todate +'&basis='+basis +'&juteVariety='+juteVariety+ '&region=' +region
													+ '" target="_blank" >' + region + '</a>';
										}
									},
									 
									{
										"data" : "Nominal",
										 
										
									},
									 
									  {
										   "data" : "Grade1",
									    	
									  },
									  {
										   "data" : "Grade2",
									    	
									  },
									  {
										     "data" : "Grade3",
											    	
									   },
									   {
										     "data" : "Grade4",
											    	
									   },
									  
									 {
										   "data" : "Grade5",
									    	
									  },
									  {
										   "data" : "Grade6",
									    	
									  },
									  {
										   "data" : "Grade7",
									    	
									  },
									  {
										   "data" : "Grade8",
									    	
									  }
									   
									
									
									],
							 

							
						});
		

	}
</script>
<script>
	function tableData(data) {
		var datalist = new Array();
		 
		var result = JSON.parse(data);
		var sum=0;
		for (var i = 0; i < result.data.length; i++) {
			//alert('hi');
			var Region = result.data[i].Region;
			//alert(Region);
			var Nominal = result.data[i].Nominal;
			var Grade1 = result.data[i].Grade1;
			var Grade2 = result.data[i].Grade2;
			var Grade3 = result.data[i].Grade3;
			var Grade4 = result.data[i].Grade4;
			var Grade5 = result.data[i].Grade5;
			var Grade6 = result.data[i].Grade6;
			var Grade7 = result.data[i].Grade7;
			var Grade8 = result.data[i].Grade8;
			//sum=sum+parseFloat(hr);
			//alert(task);
			//$("#stats").html("<ul><li style='font-size: 15px;color: darkgreen;font-family: sans-serif;'><i> Total Hrs :- "+sum+"</i></li></ul>");
			 //alert('yot');
			datalist[i] = {
				"Region" : Region,
				"Nominal" : Nominal,
				"Grade1" : Grade1,
				"Grade2"   :Grade2,
				"Grade3" : Grade3,
				"Grade4" : Grade4,
				"Grade5" : Grade5,
				
				"Grade6" : Grade6,
                 "Grade7" : Grade7,
				
				"Grade8" : Grade8,
				 
				 
				
				 
			};
			// alert('tot');

		}
		 
		return datalist;
	}
</script>  
 
    
<script>
$( "#todate" ).datepicker({ dateFormat: 'dd-mm-yy'    });
$( "#fromdate" ).datepicker({ dateFormat: 'dd-mm-yy'    });
</script>
<script>
    // Get references to the dropdowns
    var basisDropdown = document.getElementById("basis");
    var juteVarietyDropdown = document.getElementById("juteVariety");

    // Add event listener to the "Basis" dropdown
    basisDropdown.addEventListener("change", function() {
        // Clear existing options
        juteVarietyDropdown.innerHTML = "";

        // Get the selected value from the "Basis" dropdown
        var selectedBasis = basisDropdown.value;

        // Add options to the "Jute Variety" dropdown based on the selected value
        if (selectedBasis === "MSP") {
      
            juteVarietyDropdown.options.add(new Option("Mesta", "Mesta"));
            juteVarietyDropdown.options.add(new Option("Bimli", "Bimli"));
            juteVarietyDropdown.options.add(new Option("Tossa (New)", "Tossa (New)"));
            juteVarietyDropdown.options.add(new Option("White (New)", "White (New)"));
        } else if (selectedBasis === "Commercial") {
  
            juteVarietyDropdown.options.add(new Option("Mesta", "Mesta"));
            juteVarietyDropdown.options.add(new Option("Bimli", "Bimli"));
            juteVarietyDropdown.options.add(new Option("Tossa", "Tossa"));
            juteVarietyDropdown.options.add(new Option("White", "White"));
        } else {
            // Default options if no selection is made
            juteVarietyDropdown.options.add(new Option("-Jute Variety-", ""));
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