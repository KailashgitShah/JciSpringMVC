<!DOCTYPE html>
<%@page import="java.time.LocalDate"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.*"%>
<%@page import="java.io.File"%>

<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width initial-scale=1.0">
<title>JCI | CMS</title>
<link href="./assets/vendors/bootstrap/dist/css/bootstrap.min.css"
	rel="stylesheet" />
<link href="./assets/vendors/font-awesome/css/font-awesome.min.css"
	rel="stylesheet" />
<link href="./assets/vendors/themify-icons/css/themify-icons.css"
	rel="stylesheet" />
<!-- PLUGINS STYLES-->
<link href="./assets/vendors/DataTables/datatables.min.css"
	rel="stylesheet" />
<!-- THEME STYLES-->
<link href="assets/css/main.min.css" rel="stylesheet" />
<link rel="stylesheet" href="assets/css/chosen.css">
<script src="https://code.jquery.com/jquery-1.11.3.min.js"
	type="text/javascript"></script>
<!-- PAGE LEVEL STYLES-->
<style>
.required:after {
	content: " *";
	color: red;
}
</style>

</head>
<%
String cropYear = (String) request.getSession().getAttribute("currCropYear");
int count = (int) request.getAttribute("count") + 1;
List<Object> allJuteVariety = (List<Object>) request.getAttribute("allJuteVariety");
int sizeOfJuteVariey = allJuteVariety.size();
String contactIdnNo = "BT-" + count;
%>

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
								<form method="POST">

									<div class="row">
										<div class="col-sm-5 form-group">
											<label>Crop Year</label> <input class="form-control"
												name="crop_year" id="crop_year" value="<%=cropYear%>"
												readonly>
										</div>

										<div class="col-sm-5 form-group">
											<label class="required">Contract identification No.</label> <input
												class="form-control" name="contractIdn" id="contractIdn"
												type="text" value="<%=contactIdnNo%>" readonly>

										</div>

									</div>

									<div class="ibox-body" id="gradeCompostion">

										<div class="row">

											<div class="col-sm-4 form-group">
												<label>Available Qty</label> <input name="available_qty"
													id="available_qty" type="number" class="form-control"
													 />
											</div>

											<div class="col-sm-4 form-group">
												<label>Label Name</label> <input name="labelname"
													id="labelname" type="text" class="form-control"
													value="<%=contactIdnNo%>/<%=cropYear%>" readonly />
											</div>
										</div>

										<div class="row table-responsive-sm m-4">
											<table>
												<thead>
													<tr class="row">
														<th class="col-sm-6" scope="col">Variety</th>
														<th class="col-sm-2" scope="col">System
															Composition(%)</th>
														<th class="col-sm-2" scope="col">Proposed
															Composition(%)</th>
														<th class="col-sm-2" scope="col">Remarks</th>
													</tr>
												</thead>
												<tbody>

													<%
													int i = 1;
													for (Object row : allJuteVariety) {
														Object[] rowData = (Object[]) row; // Cast each row to an Object array
														// Access individual columns by their index (0-based)
														Object variety = rowData[1];
														Object rate = rowData[2];
													%>

													<tr class="row">
														<td class="col-sm-6"><input class="form-control"
															name="variety<%=i%>" value="<%=variety%>"
															id="variety<%=i%>" /></td>
														<td class="col-sm-2"><input
															class="clrSys form-control" name="system<%=i%>"
															value="<%=rate%>" readonly /></td>
														<td class="col-sm-2"><input type="number"
															name="proposed<%=i%>" id="grade<%=i%>" step="any"
															class="clrPro form-control" data-decimal="2" min="0"
															required /></td>

														<%
														if (i == 1) {
														%>
														<td class="col-sm-2"><textarea name="remark"
																id="remark" class="form-control" ></textarea></td>
														<%
														}
														%>

													</tr>
													<%
													i++;
													}
													%>
													<tr class="row">
														<td class="col-sm-6"></td>
														<td class="col-sm-2"></td>
														<td class="col-sm-2"><small id="error"
															class="text-danger"></small></td>
													</tr>
												</tbody>
											</table>
										</div>

										<input type="hidden" name="size" value="<%=sizeOfJuteVariey%>">

									</div>


									<div class="ibox-body" id="contractgeneration">

								<div class="row">
											<div class="col-sm-4 form-group">
												<label class="required">PCSO Date</label>

												<%
												List<Date> pcsoDates = (List<Date>) request.getAttribute("pcsoDates");
												%>
												<select data-placeholder='Choose Dates..'
													class='chosen-select form-control pcso' multiple
													tabindex='3' name="pcso_date" id="pcso_date" required>
													<option disabled>-Select-</option>
													<%
													for (int p = 0; p < pcsoDates.size(); p++) {
													%>
													<option value="<%=pcsoDates.get(p)%>"><%=pcsoDates.get(p)%>
													</option>
													<%
													}
													%>
												</select>
											</div>
								

											<div class="col-sm-3 form-group">

												<label class="required">Contact Date</label> <input
													class="form-control" name="contractDate" id="contactDate"
													type="text" readonly
													value="<%=new java.text.SimpleDateFormat("dd-MM-yyyy").format(new java.util.Date())%>">
											</div>

											<div class="col-sm-3 form-group">
												<label class="required">Contract Qty.</label> <input
													class="form-control" name="contract_qty" id="contract_qty"
													type="number" readonly>
											</div>
									</div>

										
										<div id="list"></div>
										<div>
											<button class="btn btn-success float-right submit" type="submit">Submit</button>
										</div>
									</div>


									<div class="row">
										<input class="form-control" type="hidden" name="count"
											id="count">
										<div class=" col-sm-4 form-group">
											<button class="btn btn-warning" type="button" id="toggle">Next</button>
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
  <div class="preloader-backdrop" id="loader">
            <div class="page-preloader">Loading</div>
      </div> 
	<!-- PAGE LEVEL SCRIPTS-->
</body>
<script src="assets/css/chosen.jquery.js" type="text/javascript"></script>
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

<script>
$("#pcso_date").chosen();
$("#pcso_date").addClass("chosen-select");



async function loader(val) {
    await new Promise((resolve) => {
        document.getElementById("loader").style.setProperty('display', val);
        setTimeout(resolve, 100); // Resolves the promise after 100ms
    });
}


var flag = 1; //user for show and hide the content
$("#toggle").on("click" ,async () => {
	
	var avaQty =$('#available_qty').val();
	var remark = $('#remark').val();
	
	if(avaQty.length == 0){
		alert("Please fill Available Qty");
		return false;
	}
	
	if(remark.length == 0){
		alert("Please add Remarks..");
		return false;
	}
	
	
	//grade composition validations
	let totel = 0;
	for (var i = 1; i <='<%=sizeOfJuteVariey%>'; i++) {
		let temp = $('#grade' + i).val();
		let variety = $('#variety' + i).val();
		if (temp == '') temp = 0; 
		totel += parseFloat(temp);
	}
	
	
	if ((+totel != 100)) {
		document.getElementById("error").innerHTML = "total should be equal to 100 !";
	 	return false;
	} else {
		document.getElementById("error").innerHTML = "";
	}
	
	
	
	
	//display properties
    flag = flag == 1 ? 0 : 1;
	document.getElementById("toggle").innerHTML = flag == 1 ? "Next" : "Prev";
	
	document.getElementById("gradeCompostion").style.setProperty('display',flag==1 ? 'block' : 'none');
	//document.getElementById("contractgeneration").style.setProperty('visibility',flag==1 ? 'visible' : 'hidden');
	document.getElementById("contractgeneration").style.setProperty('display',flag==1 ? 'none' : 'block');
	
 
})


	document.getElementById("gradeCompostion").style.setProperty('display',flag==1 ? 'block' : 'none');
	//document.getElementById("contractgeneration").style.setProperty('visibility',flag==1 ? 'visible' : 'hidden');
	document.getElementById("contractgeneration").style.setProperty('display',flag==1 ? 'none' : 'block');

</script>


<script>
document.getElementById("loader").style.setProperty('display','none' );
var contractedValueMillWise = [];
var listOfTotalQty = [];
$("#pcso_date").chosen();
$("#pcso_date").addClass("chosen-select");
var parsedArray = [];
var jsonGrades = [];
var jsonPcsoDates = [];
var count = 0;

	$(".pcso")
			.on(
					"change",
					function() {
						
						contractedValueMillWise = [];
						listOfTotalQty = [];
						parsedArray = [];
						jsonPcsoDates = []
						jsonGrades = [];
						listOfTotalQty = [];
						
						var array = [];
						var gradeArray = [];
					
						
						for(var i=1 ; i<= 6 ;i++){
							var grade = $("#grade"+i).val();
							if(grade != '') gradeArray.push(+grade);
							else  gradeArray.push(0);
						}
						
						/* console.log(gradeArray,"gradeArray"); */
						 
						//var deliveryType = $("#deliveryType").val();

						$("#pcso_date").find("option:selected").each(function() {
							array.push($(this).val());
						});
						
					/* 	console.log(array , "Array"); */

						 jsonPcsoDates = JSON.stringify(array);
						 jsonGrades = JSON.stringify(gradeArray);
			
					/* 	console.log(jsonPcsoDates , "jsonPcsoDates");
						console.log(jsonGrades , "jsonGrades"); */
						
					    var lastIndex = array.length-1;
					    
					    if(array.length == 0){
					    	$("#list").html("<div></div>");
					    	$("#contract_qty").val(0);
					    	return;
					    }
					    
					    if(array.length != 0){	
					   
						 $
								.ajax({
									type : 'GET',
									url : 'pcso_details.obj',
									data : {
										"pcso_dates" : jsonPcsoDates,
										"grades" : jsonGrades
										//"deliveryType":deliveryType
									},
									success : function(result) {
										var data1 = jQuery.parseJSON(result).model;
										parsedArray = JSON.parse(jsonPcsoDates);
										var List = data1.List;
										var TotelContractedValue = data1.totelContractedValue;
									     contractedValueMillWise = data1.contractedValueMillWise;
									     
										count = List.length;
										
										var sizeOfSingleResultArray = List[0].length; 
										
								 	    var htmlTable = '<table border="3px" id="table_r" class="table table-hover table-striped" style="margin-top:16px">';
										var sum = 0;
										var dateStringAsColumnName = parsedArray.map(ele => {
											return '<th style="text-align:center">'+ ele + '</th>';
										})
										
									
										
										htmlTable += '<thead><tr><th style="text-align:center">Mill code</th><th style="text-align:center">Mill Name</th>'+dateStringAsColumnName+'<th style="text-align:center">Total allocation</th><th style="text-align:center">Jute Value</th><th style="text-align:center">Delivery Type</th></tr></thead>';
									
										htmlTable += '<tbody id="body">';
										for (i = 0; i < List.length; i++) {
											 
											listOfTotalQty.push(List[i][sizeOfSingleResultArray-1]);
											
											htmlTable += '<tr border="2px"><td id="code'+i+'" style="text-align:center">'
													+ List[i][1]
													+ '</td><td id="name'+i+'"style="text-align:center">'
													+ List[i][0] + '</td>';
													
									   for(j = 2 ; j < sizeOfSingleResultArray-1 ; j++){
										htmlTable += '</td><td style="text-align:center">'
										+ List[i][j] + '</td>';
									   }
													
									   htmlTable +=	'<td id="allocated'+i+'" style="text-align:center">'
													+ List[i][sizeOfSingleResultArray-1]
													+ '</td><td style="text-align:center">' +contractedValueMillWise[i]+'</td><td><select onchange={updateOnChange('+i+')} class="form-control pcso" name="deliveryType'+i+'" id="deliveryType'+i+'"><option value="Mill-Delivery" selected >Mill Delivery</option><option value="Ex-Godown">Ex-Godown</option></select></td></tr>';
													
									   htmlTable +="<input type='hidden' id='contractedValue"+i+"' value='"+contractedValueMillWise[i]+"'>";
													
											sum += List[i][sizeOfSingleResultArray-1];
										}
										
// 										htmlTable += '<tr border="2px"><td style="text-align:center"></td><td style="text-align:center"> Total Allocation </td><td style="text-align:center">' 
// 													+ sum + '</td></tr>';
										htmlTable += '</tbody></table>';
									 htmlTable += '<br><h4> Total Allocation = ' + sum + '</h6>';
									
										$("#list").html(htmlTable); 
										$("#contract_qty").val(sum);
										$("#count").val(count);
										//$("#contractValue").val(TotelContractedValue);
								
									}
								});
					    }

					});

 $(".submit")
			.click(
					async () => {
						
						//loader active 
						await loader("block");
										    
						var pcsoDate = parsedArray;
						var contractIdn = $("#contractIdn").val();
						var contractdate = $("#contactDate").val();
						var contractQty = $("#contract_qty").val();
						var labelName = $("#labelname").val();
						var availableQty = $("#available_qty").val();
						var remarks = $("#remark").val();						
						var millDetails = [];
						
						if(pcsoDate.length == 0){
							alert("Please select PCSO Date");
							return false;
						}
				
						// Loop through the rows of the table (skipping the header row)
						$('#table_r #body tr').each(function(index, row) {
						  var cells = $(row).find('td');
						
						  var millName = $(cells[1]).text();
						  var millCode = $(cells[0]).text();
						  var contractedValue = $("#contractedValue"+index).val();
						  var Qty = $(cells[cells.length - 2]).text(); // Assuming Quantity is in the last cell
						  var delivery_type = $("#deliveryType"+index).val(); // Assuming Quantity is in the last cell
						  millDetails.push({
							  "millCode" : millCode,
							  "millName" : millName,
							  "juteValue" : contractedValue,
							  "Qty" : Qty,
							  "delivery_type" : delivery_type
						  })

						})
						
						//console.log(millDetails,"millDetails");
						
						var data = {
								"pcsoDate" : jsonPcsoDates,
								"contractIdn" : contractIdn,
								"contractdate" : contractdate,
								"contractQty" : contractQty,
								"gradeComp" : jsonGrades,
								"millDetails":millDetails,	
								"SortingId": '<%=count%>',
								"labelName": labelName,
								"availableQty": availableQty,
								"remarks": remarks
						 };
						
					
                 if(jsonPcsoDates.length > 4){
                	 
				   $.ajax({
							type : "POST",
							url : "contractgenerationPcsoWiseSave.obj",
							data :JSON.stringify(data),
							async: false,
							contentType: "application/json",
							success : async (result) => {
							  
							  	window.location.href = "viewcontractgeneration.obj";
							  	//loader hide
								await loader("none");
								// window.open("viewcontractgeneration.obj");
								
							},
							error: function(xhr, status, error) {
						        console.error("Error: " + error);
						    }
						}); 
				 }
                  else{
                	  return false;
                  }
		 
	 }); 
</script>


<script>
//alert("script called");
function updateOnChange(id){ 
var prevQty = listOfTotalQty[id];

console.log(contractedValueMillWise);

	 $.ajax({
		type:"GET",
		url:"updateContractedValue.obj",
		data:{
			"deliveryType" : $("#deliveryType"+id).val(),
			"totalQtyOfMill":listOfTotalQty[id]
		},
		success : function(result){
			contractedValueMillWise[id] = +result;
			console.log(contractedValueMillWise);
			for(var ele of contractedValueMillWise){
				currSum += ele;
			}
			
			$("#contractValue").val(currSum);
		}
	}) 
	
	var currSum = 0;
	

	
}
</script>




</html>
