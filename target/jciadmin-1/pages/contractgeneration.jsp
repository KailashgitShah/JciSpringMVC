<!DOCTYPE html>


<%@page import="java.util.HashMap"%>
<%@page import="java.util.*"%>
<%@page import="java.io.File"%>

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
<script type="text/javascript">
	var list = "";
	var data1 = "";
	var data2 = "";
	var data3 = "";
	var data4 = "";
	var data5 = "";
	const final_list = new Array();
	var pcso1;
	var pcso2;
	var pcso3;
	var pcso4;
	var pcso5;
	</script>

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
				<h1 class="page-title">Contract Generation PCSO Wise</h1>
			</div>

			<div class="page-content fade-in-up">
				<div class="row">
					<div class="col-md-11">
						<div class="ibox">

							<div class="ibox-body">
								<span>${msg}</span>
								<!--  <form action="savecontractgenerationPcsoWise.obj" method="POST"> -->
									<div class="row">
									
									
										<div class="col-sm-4 form-group">
											<label class="required">PCSO Date</label>
											 
											<% List<Date> pcso=(List<Date>)request.getAttribute("pcso");
											%>
											<select class="form-control pcso" name="pcso_date" id="pcso_date" required>
												<option disabled selected value>-Select-</option>
											<% for(int i=0; i< pcso.size(); i++){ %>
											<option value="<%= pcso.get(i) %>"><%=pcso.get(i) %>
											</option>
											<%} %>
											</select>
											

										</div>
										<div class="col-sm-4 form-group">
											<label class="required">PCSO Date</label> 
										
											<% List<Date> pcso2=(List<Date>)request.getAttribute("pcso");
											%>
											<select class="form-control  pcso" name="pcso2_date" id="pcso2_date" required>
												<option disabled selected value>-Select-</option>
											<% for(int i=0; i< pcso2.size(); i++){ %>
											<option value="<%= pcso2.get(i) %>"><%=pcso2.get(i) %>
											</option>
											<%} %>
											</select>
											

										</div>
										<div class="col-sm-4 form-group">
											<label class="required">PCSO Date</label> 
											
											<% List<Date> pcso3=(List<Date>)request.getAttribute("pcso");
											%>
											<select class="form-control pcso" name="pcso3_date" id="pcso3_date" required>
											<option disabled selected value>-Select-</option>
											<% for(int i=0; i< pcso3.size(); i++){ %>
											<option value="<%= pcso3.get(i) %>"><%=pcso3.get(i) %>
											</option>
											<%} %>
											</select>
											

										</div>
										</div>
										<div class="row">
										<div class="col-sm-4 form-group">
											<label class="required">PCSO Date</label> 
											
											<% List<Date> pcso4=(List<Date>)request.getAttribute("pcso");
											%>
											<select class="form-control pcso" name="pcso4_date" id="pcso4_date" required>
											<option disabled selected value>-Select-</option>
											<% for(int i=0; i< pcso4.size(); i++){ %>
											<option value="<%= pcso.get(i) %>"><%=pcso.get(i) %>
											</option>
											<%} %>
											</select>
											

										</div>
										<div class="col-sm-4 form-group">
											<label class="required">PCSO Date</label> 
											
											<% List<Date> pcso5=(List<Date>)request.getAttribute("pcso");
											%>
											<select class="form-control pcso" name="pcso5_date" id="pcso5_date" required>
											<option disabled selected value>-Select-</option>
											<% for(int i=0; i< pcso5.size(); i++){ %>
											
											<option value="<%= pcso5.get(i) %>"><%=pcso5.get(i) %>
											</option>
											<%} %>
											</select>
											

										</div>
										<div class="col-sm-4 form-group">
											<label class="required">Contract Quantity</label> <input
												type="number" name="contract_Qty" id="contract_Qty"
												class="form-control" placeholder="Contract Quantity" required>
										</div>
										</div>
										<div class="row">
										<div class="col-sm-4 form-group">
											<label class="required">(Contract Number) BT- </label> <input
												class="form-control" name="contactnumber"
												id="contactnumber" type="number" placeholder="Contract Number"
												required>
										
									</div>
								
									<div class="col-sm-4 form-group">
											<label class="required">Contract Date</label> <input
												type="date" name="contract_date" id="contract_date"
												class="form-control" required>

										</div>
										<div class="col-sm-4 form-group">
											<label class="required">Crop Year</label> 
											<select name="crop_year" id="crop_year" class="form-control"
												required>
												<option disabled selected value>-Select-</option>
												<option value="2021-2022">2021-2022</option>
												<option value="2022-2023">2022-2023</option>
												<option value="2022-2023">2023-2024</option>
												<option value="2022-2023">2024-2025</option>
												<option value="2022-2023">2025-2026</option>
												<option value="2022-2023">2026-2027</option>
												<option value="2022-2023">2027-2028</option>
												<option value="2022-2023">2028-2029</option>
												<option value="2022-2023">2029-2030</option>
												<option value="2022-2023">2030-2031</option>
												</select>
										</div>
										</div>
										<div class="row">
										
										<div id="list"></div>
										<div id="list1"></div>
										<div id="list2"></div>
										<div id="list3"></div>
										<div id="list4"></div>
										
										<div id="list5"></div>
										
										<!-- <table>
										<tr>
										<td>abc</td></tr>
										</table>
										</div> -->
										
										</div>
										<div class="row">
										<div class="col-sm-4 form-group">
											
											<!-- <label class="required">TD1</label>
											<input type="number" name="grade1" id="grade1" value ='0'
												class="form-control"  />
												
											<label class="required">TD2_W1</label>
											<input type="number" name="grade2" id="grade2" value ='0'
												class="form-control"  />
												<label class="required">TD3_W2_M1_B1</label>
											<input type="number" name="grade3" id="grade3" value ='0'
												class="form-control"  />
												<label class="required">TD4_W3_M2_B2</label>
											<input type="number" name="grade4" id="grade4" value ='0'
												class="form-control"  />
												<label class="required">TD5_W4_M3_B3</label>
											<input type="number" name="grade5" id="grade5" value ='0'
												class="form-control"  />
												<label class="required">TD6_W5_M4_B4</label>
											<input type="number" name="grade6" id="grade6" value ='0'
												class="form-control"  />
												<label class="required">TD7_W6_M5_B5</label>
											<input type="number" name="grade7" id="grade7" value ='0'
												class="form-control"  />
												<label class="required">TD8_W7_M6_B6</label>
											<input type="number" name="grade8" id="grade8" value ='0'
												class="form-control"  />
												<label class="required">W8</label>
											<input type="number" name="grade9" id="grade9" value ='0'
												class="form-control"  /> -->
										</div>

									</div>
									<div class="row">
										<div class="form-group">
											<button class="btn btn-primary" type="submit" value="Submit"  id="submit">Submit</button>
										</div>
									</div>
								<!--  </form>-->
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



	<!-- PAGE LEVEL SCRIPTS-->
</body>
<script>	

$("#pcso_date").on("change", function() {
	pcso1= this.value;
	var array = [];
	array.push(pcso1);
	//alert(array);
	$.ajax({
		type:'GET',
		url:'pcso_details.obj',
		data:{"pcso1":JSON.stringify(array)},
		success: function(result){
			//alert(result);
		
			var htmlTable='<table border="3px" id="table_tr">';
			   var data1= jQuery.parseJSON(result);
			   htmlTable+='<tr><th style="text-align:center">Mill code</th><th style="text-align:center">Mill Name</th><th style="text-align:center">Total allocation</th></tr>';
			   for (i=0;i<data1.length;i++){
				   
				   htmlTable+='<tr><td style="text-align:center">'+data1[i]["mill_code"]+'</td><td style="text-align:center">'+data1[i]["name"]+'</td><td style="text-align:center">'+data1[i]["qty"]+'</td></tr>';
		        }
			   htmlTable+='</table>';
			   $("#list").html(htmlTable);
			   var tableToSave='<table border="3px" id="tableData">';
				for (i=0;i<data1.length;i++){
					
				tableToSave += '<tr><td>'+data1[i]["mill_code"]+'</td><td>'+data1[i]["qty"]+'</td></tr>';
				
				}
				tableToSave += '</table>';
				 $("#list5").html(tableToSave);
		       
			
		}
	});
	
}); 

$("#pcso2_date").on("change", function() {
	
	 pcso2= this.value;
	var array = [];
	array.push(pcso1);
	array.push(pcso2);
	$.ajax({
		type:'GET',
		url:'pcso_details.obj',
		data:{"pcso1":JSON.stringify(array) },
		success: function(d){
	//		alert(d);
			var htmlTable='<table border="3px" id="table_tr">';
			  var data2= jQuery.parseJSON(d);
			  
		
			  htmlTable+='<tr><th style="text-align:center">Mill code</th><th style="text-align:center">Mill Name</th><th style="text-align:center">'+pcso1+'</th><th style="text-align:center">'+pcso2+'</th><th>Total</th></tr>';
			
					  for(j=0; j<data2.length; j++){
				  var allocate = data2[j]["date_wise"];
						
						 var myarray=allocate.split(",")[0]; 
						 var myarray1=allocate.split(",")[1];
						 
						 if(typeof myarray == "undefined"){
						  myarray=0;
						 }
					
						 if(typeof myarray1 == "undefined"){
							  myarray1=0;
							 }
						 
							 htmlTable+='<tr><td style="text-align:center">'+data2[j]["mill_code"]+'</td><td style="text-align:center">'+data2[j]["name"]+'</td><td style="text-align:center">'+myarray1+'</td><td style="text-align:center">'+myarray+'</td><td style="text-align:center">'+data2[j]["qty"]+'</td></tr>';
							 
				   }
				   htmlTable+='</table>';
				   $("#list").html(htmlTable);
			  
				   var tableToSave='<table border="3px" id="tableData">';
					for (i=0;i<data2.length;i++){
						
					tableToSave += '<tr><td>'+data2[i]["mill_code"]+'</td><td>'+data2[i]["qty"]+'</td></tr>';
					
					}
					tableToSave += '</table>';	
					 $("#list5").html(tableToSave);
		}			
	
		
	});
}); 


 $("#pcso3_date").on("change", function() {
	 pcso3= this.value;
	var array = [];
	array.push(pcso1);
	array.push(pcso2);
	array.push(pcso3);
	$.ajax({
		type:'GET',
		url:'pcso_details.obj',
		data:{"pcso1":JSON.stringify(array)},
		success: function(a){
		//	alert(a);
			var htmlTable='<table border="3px" id="table_tr"><tr><th></th></tr>';
			   var data3= jQuery.parseJSON(a);
			   htmlTable+='<tr><th style="text-align:center">Mill code</th><th style="text-align:center">Mill Name</th><th style="text-align:center">Date1 Allocation</th><th style="text-align:center">Date2 Allocation</th><th>Total</th></tr>';
				
			   for (j=0;j<data3.length;j++){
				   
				   htmlTable+='<tr><td style="text-align:center">'+data3[j]["mill_code"]+'</td><td style="text-align:center">'+data3[j]["name"]+'</td><td style="text-align:center">0</td><td style="text-align:center">'+data3[j]["date_wise"]+'</td><td style="text-align:center">'+data3[j]["qty"]+'</td></tr>';
		        }
			   htmlTable+='</table>';
			   $("#list").html(htmlTable);
			   
			   var tableToSave='<table border="3px" id="tableData">';
				for (i=0;i<data3.length;i++){
					
				tableToSave += '<tr><td>'+data3[i]["mill_code"]+'</td><td>'+data3[i]["qty"]+'</td></tr>';
				
				}
				tableToSave += '</table>'; 
				 $("#list5").html(tableToSave);
			
		}
	});
	
}); 

 $("#pcso4_date").on("change", function() {
	//alert("yes");
	
	 pcso4= this.value;
	//alert(pcso4);
	var array = [];
	array.push(pcso1);
	array.push(pcso2);
	array.push(pcso3);
	array.push(pcso4);
	//alert(array);
	//alert(pcso);
	$.ajax({
		type:'GET',
		url:'pcso_details.obj',
		data:{"pcso1":JSON.stringify(array)},
		success: function(result){
			//alert(result);
		var htmlTable='<table border="3px" id="table_tr"><tr><th></th></tr>';
			   var data4= jQuery.parseJSON(result);
			   htmlTable+='<tr><th style="text-align:center">Mill code</th><th style="text-align:center">Mill Name</th><th style="text-align:center">Date1 Allocation</th><th style="text-align:center">Date2 Allocation</th><th>Total</th></tr>';
				
			   for (j=0;j<data4.length;j++){
				   
				   htmlTable+='<tr><td style="text-align:center">'+data4[j]["mill_code"]+'</td><td style="text-align:center">'+data4[j]["name"]+'</td><td style="text-align:center">0</td><td style="text-align:center">'+data4[j]["date_wise"]+'</td><td style="text-align:center">'+data4[j]["qty"]+'</td></tr>';
		        }
			   htmlTable+='</table>';
			   $("#list").html(htmlTable);
			  
		       
			   var tableToSave='<table border="3px" id="tableData">';
				for (i=0;i<data4.length;i++){
					
				tableToSave += '<tr><td>'+data4[i]["mill_code"]+'</td><td>'+data4[i]["qty"]+'</td></tr>';
				
				}
				tableToSave += '</table>';
				 $("#list5").html(tableToSave);
		}
	});
	
}); 

 $("#pcso5_date").on("change", function() {
		 pcso5= this.value;
		var array = [];
		array.push(pcso1);
		array.push(pcso2);
		array.push(pcso3);
		array.push(pcso4);
		array.push(pcso5);

	$.ajax({
		type:'GET',
		url:'pcso_details.obj',
		data:{"pcso1":JSON.stringify(array)},
		success: function(result){
		//	alert(result);
			var htmlTable='<table border="3px" id="table_tr"><tr><th></th></tr>';
			   var data5= jQuery.parseJSON(result);
			   htmlTable+='<tr><th style="text-align:center">Mill code</th><th style="text-align:center">Mill Name</th><th style="text-align:center">Date1 Allocation</th><th style="text-align:center">Date2 Allocation</th><th>Total</th></tr>';
				
  for (j=0;j<data5.length;j++){
				   
				   htmlTable+='<tr><td style="text-align:center">'+data5[j]["mill_code"]+'</td><td style="text-align:center">'+data5[j]["name"]+'</td><td style="text-align:center">0</td><td style="text-align:center">'+data5[j]["date_wise"]+'</td><td style="text-align:center">'+data5[j]["qty"]+'</td></tr>';
		        }
			   htmlTable+='</table>';
			   $("#list").html(htmlTable);
			  
			   var tableToSave='<table border="3px" id="tableData">';
				for (i=0;i<data5.length;i++){
					
				tableToSave += '<tr><td>'+data5[i]["mill_code"]+'</td><td>'+data5[i]["qty"]+'</td></tr>';
				
				}
				tableToSave += '</table>'; 
				
		}
	});
});  

		 $("#submit").click(function(){
		
			  var contractQuants = $("#contract_Qty").val();			  
			  var contactnumber = $("#contactnumber").val();			  
			  var contractdate = $("#contract_date").val();
			  var cropyear = $("#crop_year").val();
			  var millcode = $("#mill_code").val();
			  var totalallocate = $("#date_wise").val();
			  var grade1 = $("#grade1").val();
				  var grade2 = $("#grade2").val();
				  var grade3 = $("#grade3").val();
				  var grade4 = $("#grade4").val();
				  var grade5 = $("#grade5").val();
				  var grade6 = $("#grade6").val();
				  var grade7 = $("#grade7").val();
				  var grade8 = $("#grade8").val();
				  var grade9 = $("#grade9").val();
			  
			  var result = true;
			  
			  $.ajax({
					type:"POST",
					url:"savecontractgenerationPcsoWise.obj",
					data:{"contractQuants":contractQuants ,"contactnumber" :contactnumber, "contractdate":contractdate,"cropyear":cropyear,"millcode":millcode,"date":totalallocate, "grade1":grade1,"grade2":grade2,"grade3":grade3,
						"grade4":grade4,"grade5":grade5,"grade6":grade6,"grade7":grade7,"grade9":grade9,"grade8":grade8},
					success:function(result){
						//location.reload(true)
					//	$("#msg").html("<div class=\"alert alert-success\"><b>Success !</b> Record saved successfully.</div>\r\n");
						//alert("Result Saved Succesfully");
		 				//var data= jQuery.parseJSON(result);
	 	 			
					}
				});
			  if(result){
				  for(var w=0; w< document.getElementById("tableData").rows.length; w++){
					
					  $.ajax({
							type:"POST",
							url:"saveUpdatedQty.obj",
							data:{"millcode":document.getElementById("tableData").rows[w].cells[0].innerHTML ,"qty" :document.getElementById("tableData").rows[w].cells[1].innerHTML,"contactnumber" :contactnumber, "contractdate":contractdate,"cropyear":cropyear},
							success:function(result){
								location.reload(true)
								$("#msg").html("<div class=\"alert alert-success\"><b>Success !</b> Table saved successfully.</div>\r\n");
								
				 			
			 	 				 
							}			
						});
					  }
				  alert("Result Saved Succesfully");
				  }
			  
	  });
	
</script>
			  
			  
			  
 <script>
 function removeTableTr(){
	 
	 var seen = {};
	 $('table#table_tr tr').each(function() {
	   var txt = $(this).text();
	   if (seen[txt])
	     $(this).remove();
	   else
	     seen[txt] = true;
	 });
	 
	 console.log(seen);
	 
 }

	</script>
</html>
