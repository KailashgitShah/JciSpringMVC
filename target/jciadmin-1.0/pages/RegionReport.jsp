<%@page import="com.jci.model.RoDetailsModel"%>
<%@page import="java.util.List"%>
<!DOCTYPE html>
<html lang="en">
<%@page import="java.util.List"%>
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
<!-- PLUGINS STYLES-->
<!-- THEME STYLES-->
<link href="assets/css/main.min.css" rel="stylesheet" />
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
<!-- GLOBAL MAINLY STYLES-->
<link href="./assets/vendors/bootstrap/dist/css/bootstrap.min.css"
	rel="stylesheet" />
<link href="./assets/vendors/font-awesome/css/font-awesome.min.css"
	rel="stylesheet" />
<link href="./assets/vendors/themify-icons/css/themify-icons.css"
	rel="stylesheet" />

<!--  THEME STYLES -->
<link href="assets/css/main.min.css" rel="stylesheet" />
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<!-- PAGE LEVEL PLUGINS-->
<!-- CORE SCRIPTS-->
<script src="assets/js/app.min.js" type="text/javascript"></script>
<!-- PAGE LEVEL STYLES-->
<style>
.required:after {
	content: " *";
	color: red;
}
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
				<h1 class="page-title">Purchase Report</h1>
			</div>
			<%
				List<String> allDpcList = (List) request.getAttribute("allDpcList");
			%>

			<%
				String dpcCenter = (String) session.getAttribute("dpc_center");

				String dpcid = (String) session.getAttribute("dpcId");

				String region_id = (String) session.getAttribute("region");

				int refid2 = (int) session.getAttribute("refId");
			%>
			<div class="page-content fade-in-up">
				<div class="row">
					<div class="col-md-11">
						<div class="ibox">

							<div class="ibox-body">
								<span>${msg}</span>
				<form action="RegionReportDownload.obj" method="POST" onsubmit="return validate()">
    <div class="row">
        <div class="col-sm-4 form-group" style="display: none;">
            <label class="required">Region</label>
            <%
                List<RoDetailsModel> Regions = (List<RoDetailsModel>) request.getAttribute("regionList");
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
    </div>
    <div class="row">
       
        		<div class="col-sm-4 form-group">
											<label>Crop Year</label> <select name="crop_year"
												id="crop_year" class="form-control" required>
												<option value="">-Select-</option>
												<option value="2023-2024">2023-2024</option>
												<option value="2024-2025">2024-2025</option>
											</select>

										</div>
        <div class="col-sm-4 form-group">
            <label class="required">Basis</label>
            <select name="basis" id="basis" class="form-control" required>
                <option value="">-Select-</option>                                       
                <option value="MSP">MSP</option>
                <option value="Commercial">Commercial</option>
            </select>
        </div>
        <div class="col-sm-4 form-group">
            <label class="required">Jute Variety</label>
            <select name="jute_variety" id="jute_variety" class="form-control" required>
                <option selected disabled>-Select-</option>
            </select>
        </div>
    </div>
    <div class="row">
        <div class="col-sm-4 form-group">
            <label>From Date</label> <span class="text-danger">*</span>
            <input class="form-control" name="fromdate" id="fromdate" type="date" placeholder="dd-mm-yyyy" required>
        </div>
        <div class="col-sm-4 form-group">
            <label>To Date</label> <span class="text-danger">*</span>
            <input class="form-control" name="todate" id="todate" type="date" placeholder="dd-mm-yyyy" required>
        </div>
    </div>
    <div class="col-sm-4 form-group">
        <button id="sRfcDate" type="button" class="btn btn-primary" style="margin: 12px;">Show</button>
    </div>
    <div class="row">
        <div class="col-12">
            <div class="card">
                <div class="card-body">
                    <div class="table-responsive">
                        <div id="stats" style="margin-top: 10px; margin-bottom: 5px;"></div>
                        <table id="dprnew" class="table table-bordered table-striped">
                            <thead>
                                <tr>
                                    <th class="text-center">Region</th>
                                    <th class="text-center">Gross Quantity</th>
                                    <th class="text-center">Deduction Quantity</th>
                                    <th class="text-center">Net Quantity</th>
                                    <th class="text-center">Garsat Rate</th>
                                    <th class="text-center">Fiber Value</th>
                                    <th class="text-center">Basis Price</th>
                                    <th class="text-center">Gr.1</th>
                                    <th class="text-center">Gr.2</th>
                                    <th class="text-center">Gr.3</th>
                                    <th class="text-center">Gr.4</th>
                                    <th class="text-center">Gr.5</th>
                                    <th class="text-center">Gr.6</th>
                                    <th class="text-center">Gr.7</th>
                                    <th class="text-center">Gr.8</th>
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
                                    <td></td>
                                    <td></td>
                                    <td></td>
                                    <td></td>
                                    <td></td>
                                </tr>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div class="row">
      <div class="col-sm-4 form-group">
        <button  type="submit" class="btn btn-primary" style="margin: 12px;">Download</button>
    </div>
    </div>
</form>

					</div>
				</div>
			</div>

		</div>
	</div>
	<!-- END PAGE CONTENT-->
	<%@ include file="footer.jsp"%>
	</div>
	</div>

	<div class="sidenav-backdrop backdrop"></div>
	<!-- Include jQuery -->
	<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
	<!-- Include jQuery UI CSS -->
	<link rel="stylesheet"
		href="https://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
	<!-- Include jQuery UI JavaScript -->
	<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.min.js"></script>


	<!-- Include DataTables CSS -->
	<link rel="stylesheet"
		href="https://cdn.datatables.net/1.13.0/css/jquery.dataTables.min.css">
	<!-- Include DataTables JavaScript -->
	<script
		src="https://cdn.datatables.net/1.13.0/js/jquery.dataTables.min.js"></script>
	<!-- Include DataTables Buttons CSS -->
	<link rel="stylesheet"
		href="https://cdn.datatables.net/buttons/2.3.4/css/buttons.dataTables.min.css">
	<!-- Include DataTables Buttons JavaScript -->
	<script
		src="https://cdn.datatables.net/buttons/2.3.4/js/dataTables.buttons.min.js"></script>
	<script
		src="https://cdn.datatables.net/buttons/2.3.4/js/buttons.html5.min.js"></script>
	<script
		src="https://cdn.datatables.net/buttons/2.3.4/js/buttons.print.min.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/jszip/3.10.1/jszip.min.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/pdfmake/0.2.5/pdfmake.min.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/pdfmake/0.2.5/vfs_fonts.js"></script>




<!-- 	<script>
 $(document).ready(function(){
	var	html = "<option selected disabled>-select-</option>";
		var today = new Date();
		var cropyr = today.getFullYear();
		var month = parseInt(today.getMonth()) + 1 ;
		var date = parseInt(today.getDate());
		var time = today.getHours() + ":" + today.getMinutes() + ":" + today.getSeconds();
		if(date == '31'&& month == '6' && time == '23:59:59'){
		html += "<option value = '"+(cropyr - 1)+"-"+cropyr+"'>"+(cropyr - 1 )+"-"+cropyr+"</option>";
		html += "<option value = '"+cropyr+"-"+(cropyr + 1)+"'>"+cropyr+"-"+(cropyr + 1)+"</option>";
		}
		else{
			html += "<option value = '"+(cropyr - 2)+"-"+(cropyr - 1)+"'>"+(cropyr - 2)+"-"+(cropyr - 1)+"</option>";
			html += "<option value = '"+(cropyr - 1)+"-"+cropyr+"'>"+(cropyr - 1 )+"-"+cropyr+"</option>";
		}
		$("#crop_year").html(html);
	}); 
	

</script> -->
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
		 var cropyear = $("#crop_year").val();
		 var region = $("#region").val();
		 var dpc = $("#dpc").val();
		 var basis = $("#basis").val();
		 var datefrom = $("#fromdate").val();
		 var dateto = $("#fromdate").val();
		 
		 if(cropyear == "" || region == "" || dpc == "" || basis == "" || fromdate == "" || fromdate == "")
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

	<script>
	$(function(){
	    var dtToday = new Date();
	    var month = dtToday.getMonth() + 1;
	    var day = dtToday.getDate();
	    var year = dtToday.getFullYear();
	    if(month < 10)
	        month = '0' + month.toString();
	    if(day < 10)
	        day = '0' + day.toString();
	    var maxDate = year + '-' + month + '-' + day;    
	    $('#datepurchase').attr('max', maxDate);
	});
		
	</script>
	<script>
$("#crop_year").on("change", function() {
	var cropyr=document.getElementById("crop_year").value;
	  var dpcid=  document.getElementById("place_of_packing").value;
	//alert(cropyr);
	 $.ajax({
		   type:"GET",
		   url:"findBinno.obj",
		   data:jQuery.param({"cropyr":cropyr, "dpcid":dpcid}),
		   success:function(result){
			   var data= jQuery.parseJSON(result);
			   var html = "<option disabled selected value>-Select-</option>";
			     for (var i = 0; i< data.length; i++){
			    	 
				 html += "<option value=" +data[i]+">"+data[i]+"</option>"
				// alert(data);
			   }
			   $("#bin_no").html(html);
		   
	   }
		   
	   }); 
});
</script>

	<script>
	$("#basis").on("change", function() {
		var msp_no=0;
		var variety = (this.value);	
		if(variety=="MSP"){
			msp_no = 1;
		}
		else if(variety=="Commercial"){
			msp_no = 2;
		}
		var s1 = "Tossa (New)";
		$.ajax({
			type:"GET",
			url:"findJuteOnBasis.obj",
			data:{"msp_no":msp_no},
			success:function(result){
 				   var data= jQuery.parseJSON(result);
	 					 var html = '<option disabled selected value>-Select-</option>';
 				     for (var i = 0; i< data.length; i++){
 				    	 var sar = data[i];
 					 html += '<option value="' +data[i] +'">' + data[i]+ '</option>';		
 				  } 
 				$("#jute_variety").html(html);
			}		
		});
	});
	</script>
	<script>

       $(document).ready(function(){
    	   var myVar = '<%=(String) session.getAttribute("region")%>';

							// alert(myVar);
							$
									.ajax({
										type : "GET",
										url : "findDpcByRegion.obj",
										data : {
											"id" : myVar
										},
										success : function(result) {

											var data = jQuery.parseJSON(result);
											var html = "<option disabled selected value>-Select-</option>";
											for (var i = 0; i < data.length; i++) {
												console
														.log(data[i].split("-")[0]
																+ " "
																+ data[i]
																		.split("-")[1]);
												html += "<option value="
														+ data[i].split("-")[0]
														+ ">"
														+ data[i].split("-")[1]
														+ "</option>"
											}
											$("#place_of_packing").html(html);

										}

									});

						});
	</script>
	
	<script type="text/javascript">
		$(document).ready(function() {

			$('#sRfcDate').click(function() {

				var cropyear = $('#crop_year').val();
				var fromdate = $('#fromdate').val();

				var todate = $('#todate').val();

				var basis = $('#basis').val();

				var juteVariety = $('#jute_variety').val();

				$("#myloader").show();
				$.get('RegionReportList.obj', {
					cropyear : cropyear,
					fromdate : fromdate,
					todate : todate,
					basis : basis,
					juteVariety : juteVariety,
				}, function(data) {
					//	$("#myloader").hide();
					//		$("#loaderWait").hide();
					//alert(data);
					console.log("from 479", data);
					drawtable(data);
				});
			});
		});

		function drawtable(data) {
			//alert('fromdatess');

			var cropyear = document.getElementById("crop_year").value;
			var juteVariety = document.getElementById("jute_variety").value;
			var basis = document.getElementById("basis").value;
			var todate = document.getElementById("todate").value;
			var fromdate = document.getElementById("fromdate").value;
			// juteVariety = decodeURIComponent(juteVariety);
			var datam = JSON.parse(data);
			console.log("data from 496 ", datam)
			console.log(datam['data']);
			var KeyValueData = tableData(JSON.stringify(datam['data']));

			var drawdata = {
				"data" : KeyValueData
			};
			console.log("=-=-=-=-=-=-=-=>", drawdata);
			var table = $('#dprnew').DataTable({
				processing : true,
				destroy : true,
				autoWidth : false,
				data : drawdata.data,
				scrollY : 580,
				scrollX : true,
				paging : false,
				ordering : true,
				dom: 'Bfrtip',
				buttons : [ {
					extend : 'excelHtml5',
					title : 'Report export'
				}, {
					extend : 'csvHtml5',
					title : 'Report export'
				}, {
					extend : 'copyHtml5',
					title : 'Report export'
				} ],
				columnDefs : [ {
					defaultContent : "",
					targets : "_all"
				} ],
				columns : [
					
					  {
					    	render : function(data, type, row) {
								var region = row.Region;
								var location = $("#locationlist").val();
								return '<a  href="DailyReportList.obj?cropyear='
										+ cropyear + '&fromdate=' +fromdate+'&todate='+todate +'&basis='+basis +'&juteVariety='+juteVariety+ '&region=' +region
										+ '" target="_blank" >' + region + '</a>';
							}
						},
					 {
					"data" : "Gross"
				}, {
					"data" : "Ded"
				}, {
					"data" : "Net"
				}, {
					"data" : "Grasat"
				}, {
					"data" : "Fiber"
				}, {
					"data" : "Basis"
				}, {
					"data" : "Grade1"
				}, {
					"data" : "Grade2"
				}, {
					"data" : "Grade3"
				}, {
					"data" : "Grade4"
				}, {
					"data" : "Grade5"
				}, {
					"data" : "Grade6"
				}, {
					"data" : "Grade7"
				}, {
					"data" : "Grade8"
				} ],
				order : [ [ 7, "desc" ] ]
			});

		}

		function tableData(data) {

			var datalist = new Array();
			var sum = 0;

			var result = {};
			result.data = JSON.parse(data);
			console.log("length from 601 ", result.data.length);
			for (var i = 0; i < result.data.length; i++) {
				var Region = result.data[i].Region;
				var Gross = result.data[i].Gross;
				var Ded = result.data[i].Ded;
				var Net = result.data[i].Net;
				var Grasat = result.data[i].Grasat;
				var Fiber = result.data[i].Fiber;
				var Basis = result.data[i].Basis;
				var Grade1 = result.data[i].Gr1;
				var Grade2 = result.data[i].Gr2;
				var Grade3 = result.data[i].Gr3;
				var Grade4 = result.data[i].Gr4;
				var Grade5 = result.data[i].Gr5;
				var Grade6 = result.data[i].Gr6;
				var Grade7 = result.data[i].Gr7;
				var Grade8 = result.data[i].Gr8;

				datalist[i] = {
					"Region" : Region,
					"Gross" : Gross,
					"Ded" :Ded ,
					"Net" :Net ,
					"Grasat" : Grasat,
					"Fiber" : Fiber,
					"Basis" : Basis,
					"Grade1" : Grade1,
					"Grade2" : Grade2,
					"Grade3" : Grade3,
					"Grade4" : Grade4,
					"Grade5" : Grade5,
					"Grade6" : Grade6,
					"Grade7" : Grade7,
					"Grade8" : Grade8
				};
			}
			console.log("lengthddhdhdhdh ", JSON.stringify(datalist));

			return datalist;
		}
	</script>

	<!-- <script type="text/javascript">
		$("#todate").datepicker({
			dateFormat : 'dd-mm-yy'
		});
		$("#fromdate").datepicker({
			dateFormat : 'dd-mm-yy'
		});
	</script> -->
	<script>
		// Get references to the dropdowns
		var basisDropdown = document.getElementById("basis");
		var juteVarietyDropdown = document.getElementById("jute_variety");

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
				juteVarietyDropdown.options.add(new Option("Tossa (New)",
						"Tossa (New)"));
				juteVarietyDropdown.options.add(new Option("White (New)",
						"White (New)"));
			} else if (selectedBasis === "Commercial") {

				juteVarietyDropdown.options.add(new Option("Mesta", "Mesta"));
				juteVarietyDropdown.options.add(new Option("Bimli", "Bimli"));
				juteVarietyDropdown.options.add(new Option("Tossa", "Tossa"));
				juteVarietyDropdown.options.add(new Option("White", "White"));
			} else {
				// Default options if no selection is made
				juteVarietyDropdown.options
						.add(new Option("-Jute Variety-", ""));
			}
		});
	</script>
	<script>
		$("#zone")
				.on(
						"change",
						function() {
							var id = (this.value);
							//alert(id);
							if (id != null) {
								$
										.ajax({
											type : "GET",
											url : "findRoByZone.obj",
											data : {
												"id" : id
											},
											success : function(result) {
												var data = jQuery
														.parseJSON(result);
												var html = "<option disabled selected value>-Select-</option>";
												for (var i = 0; i < data.length; i++) {
													html += "<option value="
															+ data[i]
																	.split("-")[0]
															+ ">"
															+ data[i]
																	.split("-")[1]
															+ "</option>"
												}
												//alert(html)
												$("#region").html(html);
											}
										});
							}
						});

		$("#region")
				.on(
						"change",
						function() {
							var id = (this.value);
							if (id != null) {
								$
										.ajax({
											type : "GET",
											url : "findDpcByRegion.obj",
											data : {
												"id" : id
											},
											success : function(result) {
												var data = jQuery
														.parseJSON(result);
												var html = "<option disabled selected value>-Select-</option>";
												for (var i = 0; i < data.length; i++) {
													html += "<option value="
															+ data[i]
																	.split("-")[0]
															+ ">"
															+ data[i]
																	.split("-")[1]
															+ "</option>"
												}
												$("#dpc").html(html);
											}
										});
							}
						});
	</script>

	<script>
		function validation() {
			var dpc = $("#dpc").find(":selected").val();
			var fromDate = $("#fromdate").val();
			var toDate = $("#todate").val();
			if (dpc != "" && toDate != "" && fromDate != "") {
				return true;
			} else {
				alert("please fill all the fields!");
				return false;
			}
		}
	</script>
	<script>
		$("#search").click(function() {
			var dpc = $("#dpc").find(":selected").val();

			if (dpc != "") {
				return true;
			} else {
				alert("please select a dpc!");
				return false;
			}
		});
</script>
		<!--PAGE LEVEL SCRIPTS-->
</body>
</html>
	