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
String[] years = cropYear.split("-");
int startYear = Integer.parseInt(years[0]);
int endYear = Integer.parseInt(years[1]);

//Calculate the past crop years
String pastCropYear1 = (startYear - 1) + "-" + (endYear - 1);
String pastCropYear2 = (startYear - 2) + "-" + (endYear - 2);

int count = (int) request.getAttribute("count") + 1;
List<Object> allJuteVariety = (List<Object>) request.getAttribute("allJuteVariety");
int sizeOfJuteVariey = allJuteVariety.size();
String contactIdnNo = "BT-" + count;
%>

<body class="fixed-navbar">
	<div class="contractLoader">
		<img src="assets/img/1488.gif">
	</div>

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
											<label>Crop Year</label> <select name="crop_year"
												id="crop_year" class="form-control">
												<option value="">-Select-</option>
												<option value="<%=cropYear%>"><%=cropYear%></option>
												<option selected value="<%=pastCropYear1%>"><%=pastCropYear1%></option>
												<option value="<%=pastCropYear2%>"><%=pastCropYear2%></option>
											</select>
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
												<label class="required">Available Qty (Qtls.)</label> <input
													name="available_qty" id="available_qty" type="number"
													class="form-control" min='0' />
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
														<th class="col-sm-2 required" scope="col">Remarks</th>
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
															value="<%=rate%>" id="system<%=i%>" readonly /></td>
														<td class="col-sm-2"><input type="number"
															name="proposed<%=i%>" id="grade<%=i%>" step="0.01"
															class="clrPro form-control" min="0" required /></td>

														<%
														if (i == 1) {
														%>
														<td class="col-sm-2"><textarea name="remark"
																id="remark" class="form-control"></textarea></td>
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

											<%-- 		<%
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
													%> --%>
											<!--</select> -->
											<div class="col-sm-4 form-group" id="pcso_div">
												<label id="pcsoDateLable" class="required">PCSO Date</label>
												&nbsp;&nbsp;&nbsp; <select name="pcso_date" id="pcso_div"
													class="form-control" required>
													<option disabled selected value="">-Select</option>
												</select>
											</div>



											<div class="col-sm-3 form-group">

												<label class="required">Contact Date</label> <input
													class="form-control" name="contractDate" id="contactDate"
													type="text" readonly
													value="<%=new java.text.SimpleDateFormat("dd-MM-yyyy").format(new java.util.Date())%>">
											</div>

											<div class="col-sm-3 form-group">
												<label class="required">Contract Qty.(Qtls)</label> <input
													class="form-control" name="contract_qty" id="contract_qty"
													type="number" readonly>
											</div>
										</div>


										<div id="list"></div>
										<div>
											<button class="btn btn-success float-right submit"
												type="submit">Submit</button>
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


<script type="text/javascript">

</script>

<script type="text/javascript">
 
 function loadPcsoDateBasedOnCropYr(cropyr){
	 var pcsoDateHtml = "<label id='pcsoDateLable' class='required'>Pcso Date</label> <select data-placeholder='Choose Pcso Date...' class='chosen-select form-control pcso' name='pcso_date'  multiple tabindex='3' id = 'pcso_date'>";

	    $
		.ajax({
			type : 'GET',
			url : 'getPscoDateByCropYr.obj',
			data : {
				"cropYr" :cropyr
			},
			success : function(result) {	
				var finalresult = jQuery.parseJSON(result);
				pcsoDateHtml += "<option disabled>-Select-</option>";
				for (var i = 0; i < finalresult.length; i++) {
					pcsoDateHtml += "<option value='"+finalresult[i]+"'>"+finalresult[i]+ "</option>";
				}
				pcsoDateHtml += "</select>"
				

				$("#list").html('<div></div>'); 
				$("#pcso_div").html(pcsoDateHtml);
				 $("#pcso_date").chosen();
				 $("#pcso_date").addClass("chosen-select");
				
			
			}
	    })
 }
 
$("#crop_year").on("change" , function(){   
	loadPcsoDateBasedOnCropYr($(this).val()); 
})

</script>

<script>
$(".contractLoader").hide();

var flag = 1; //user for show and hide the content
$("#toggle").on("click" ,async () => {

	loadPcsoDateBasedOnCropYr($("#crop_year").val());
/* 	by pass */
/*  	document.getElementById("contractgeneration").style.setProperty('display' , 'block');
	document.getElementById("gradeCompostion").style.setProperty('display' , 'none'); 
	return true;  */
	
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
	var totel = 0.0;
	for (var i = 1; i <='<%=sizeOfJuteVariey%>'; i++) {
		let temp = $('#grade' + i).val();
		let variety = $('#variety' + i).val();
		if (temp == '') temp = 0.0; 
		totel += parseFloat(temp);
	}
	
	totel = totel.toFixed(2);
	
	//console.log(totel , totel == 100.00000);

	
	
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
var contractedValueMillWise = [];
var listOfTotalQty = [];
var parsedArray = [];
var jsonGrades = [];
var jsonPcsoDates = [];
var count = 0;
var array = [];
var gradeArray = [];

	$("#pcso_div")
			.on(
					"change",
					function() {
						contractedValueMillWise = [];
						listOfTotalQty = [];
						parsedArray = [];
						jsonPcsoDates = []
						jsonGrades = [];
						listOfTotalQty = [];
						
						 array = [];
						 gradeArray = [];
						 
						 var cropyr = $("#crop_year").val();
				
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
									url : 'populateContract.obj',
									data : {
										"pcso_dates" : jsonPcsoDates,
										"grades" : jsonGrades,
										"cropyr":cropyr
									},
									success : function(result) {										
										var data1 = jQuery.parseJSON(result).model;
										var isPrice = data1.isPrice;
										
										
										if(isPrice == 0){
											alert("Derivate Price is not decided yet !!!");
											return;
										}
										
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
									   
									
													
									   htmlTable += '<td id="allocated'+i+'" style="text-align:center">'
							            + List[i][sizeOfSingleResultArray-1].toFixed(2)
							            + '</td><td style="text-align:center" id="contractedValue'+i+'">' + contractedValueMillWise[i] + '</td><td><select onchange="updateOnChange('+i+')" class="form-control pcso" name="deliveryType'+i+'" id="deliveryType'+i+'"><option value="Mill-Delivery" selected >Mill Delivery</option><option value="Ex-Godown">Ex-Godown</option></select></td></tr>';


											sum += List[i][sizeOfSingleResultArray-1];
										}
										
										 sum = sum.toFixed(2);
										
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
					
                         $(".contractLoader").show();
										    
						var pcsoDate = parsedArray;
						var contractIdn = $("#contractIdn").val();
						var contractdate = $("#contactDate").val();
						var contractQty = $("#contract_qty").val();
						var labelName = $("#labelname").val();
						var availableQty = $("#available_qty").val();
						var remarks = $("#remark").val();						
						var millDetails = [];
						
						var juteGradesArray = [];
						var sysComArry = [];

						for(var i=1 ; i <= 6 ; i++){
							var variety = $("#variety"+i).val();
							var sysComp = $("#system"+i).val();
							juteGradesArray.push(variety);
							sysComArry.push(sysComp);
						}
						
				
						
						if(pcsoDate.length == 0){
							alert("Please select PCSO Date");
							return false;
						}
				
						// Loop through the rows of the table (skipping the header row)
						$('#table_r #body tr').each(function(index, row) {
						  var cells = $(row).find('td');
						
						  var millName = $(cells[1]).text();
						  var millCode = $(cells[0]).text();
						  var contractedValue = $(cells[cells.length - 2]).text();
						  var Qty = $(cells[cells.length - 3]).text(); // Assuming Quantity is in the third last cell
						  var delivery_type = $("#deliveryType"+index).val(); // Assuming this is in the last cell
						  
						  var pcsoDateForMill = [];
						  
						  for(var count=2 ; count < cells.length - 3 ; count++){
							  if($(cells[count]).text() != 0){
								  /* console.log(array[count-2] , $(cells[count]).text()); */
								  pcsoDateForMill.push(array[count-2]);
							  }
						  }
						  
						 /*  console.log(pcsoDateForMill); */
						  
						  millDetails.push({
							  "millCode" : millCode,
							  "millName" : millName,
							  "juteValue" : contractedValue,
							  "Qty" : Qty,
							  "delivery_type" : delivery_type,
							  "pcsoDateForMill" : pcsoDateForMill
						  })

						})
						
						//console.log(millDetails,"millDetails");
						
						var data = {
								"pcsoDate" : array,
								"contractIdn" : contractIdn,
								"contractdate" : contractdate,
								"contractQty" : contractQty,
								"gradeComp" : jsonGrades,
								"millDetails":millDetails,	
								"SortingId": '<%=count%>',
								"labelName": labelName,
								"availableQty": availableQty,
								"remarks": remarks,
		                        "juteGradesArray" : juteGradesArray,
		                        "systemComp" : sysComArry
						 };
				
						//return false;
					
                 if(jsonPcsoDates.length > 4){
                	// alert("true");
				   $.ajax({
							type : "POST",
							url : "contractgenerationPcsoWiseSave.obj",
							data :JSON.stringify(data),
							//async: false,
							contentType: "application/json",
							success : async (result) => {
							  	$(".contractLoader").hide();
								window.location.href = "authorization.obj";
							},
							error: function(xhr, status, error) {
								alert("error");
						        console.error("Error: " + error);
						    }
						}); 
				 }
                  else{
                	  alert("false");
                	  return false;
                  }
		 
	 }); 
</script>


<script>
//alert("script called");
function updateOnChange(id){ 
var prevQty = listOfTotalQty[id];
var currDeleType = $("#deliveryType"+id).val();
var prevDelType = currDeleType == "Ex-Godown" ? "Mill-Delivery" : "Ex-Godown";
var cropyr = $("crop_year").val();
//console.log(currDeleType , prevDelType);

//console.log(contractedValueMillWise , listOfTotalQty ,prevQty, "inside change funtion");

	  $.ajax({
		type:"GET",
		url:"updateContractedValue.obj",
		data:{
			"deliveryType" : currDeleType,
			"totalQtyOfMill":prevQty,
			"grades" : jsonGrades,
			"cropyr" : cropyr
		},
		success : function(result){
			//console.log(result);
			   if(result == -1){
				   alert("derivative price for the delivery type is not decided");
				   $('#deliveryType' + id).val(prevDelType);
				   return false;
			   }else{
				contractedValueMillWise[id] = result;
				$('#contractedValue' + id).text(result);
				
			   }
		}
	})   
}
</script>



</html>
