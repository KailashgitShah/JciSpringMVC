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
	 <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
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
				<h1 class="page-title">Bale Preparation</h1>
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
							<%--  <% 
                        	List<String> allDpcList = (List) request.getAttribute("allDpcList");
                        %> --%>
							<div class="ibox-body">
								<span>${msg}</span>
								<form action="saveBale.obj" method="POST">
									<div class="row">

										<input class="form-control" name="dpcid" id="dpcid"
											type="hidden" value="<%=dpcid%>"> <input
											class="form-control" name="region_id" id="region_id"
											type="hidden" value="<%=region_id%>"> <input
											class="form-control" name="refid" id="refid" type="hidden"
											value="<%=refid%>" >



										<%-- <input class="form-control"  type="text" placeholder="Place of Purchase" value="<%=dpcCenter%>" onkeyup="deleteErrorMsg()" oninput="javascript: if (this.value.length > 4) this.value = this.value.slice(0, 4);" >
      									<input class="form-control" name="dpcid" id="dpcid" type="hidden" value="<%=dpcid%>" > --%>

										<div class="col-sm-4 form-group">
											<label class="required">Packing Place</label> <select
												name="place_of_packing" id="place_of_packing"
												class="form-control">
												<option value="">-Select-</option>

											</select>
										</div>


										<!-- <div class="col-sm-4 form-group">
                                            <label class="required">packing_date</label> 
											<select name="packing_date" id="packing_date" class="form-control">
												<option value="">-Select-</option>
												<option value="2021-2022">2021-2022</option>
												<option value="2022-2023">2022-2023</option>
											</select>
                                        </div> -->
										<div class="col-sm-4 form-group">
											<label class="required">Crop Year</label> <select
												name="crop_year" id="crop_year" class="form-control">
												<option value="">-Select-</option>
												
											</select>
										</div>

										<div class="col-sm-4 form-group">
											<label class="required">Bin number</label> 
											<select class="form-control" name="bin_no" id="bin_no" required>
							<option disabled selected value>-Select-</option>
										</select>
											
										<!-- 	<input
												class="form-control" name="bin_no" id="binnumb"
												type="number" placeholder="Bin Number" required
												onkeyup="checkLen()" required>-->
										</div> 
									</div>
									<div class="row">
										<div class="col-sm-4 form-group">
											<label class="required">Basis</label> <select name="basis"
												id="basis" class="form-control" required>
												<option value="">-Select-</option>
												<option value="msp">MSP</option>
												<option value="commercial">Commercial</option>
											</select>
										</div>

										<div class="col-sm-4 form-group">
											<label class="required">Jute Variety</label> <select
												name="jute_variety" id="jute_variety" class="form-control"
												required>
										<option selected disabled>-Select-</option>
											</select>
										</div>

										<div class="col-sm-4 form-group">
											<label class="required">Jute Grade</label> <select
												name="jute_grade" id="jute_grade" class="form-control"
												required>
										<option selected disabled>-Select-</option>
											</select>
										</div>
									</div>
									<div class="row">
										<div class="col-sm-4 form-group">
											<label class="required">Bale Check SlipNo.(From)</label> <input
												class="form-control" name="slip_no_from" id="slip_no_from"
												type="number" placeholder="Bale Check SlipNo" required
												onkeyup="baleFromLen()" min="0">
										</div>
<!-- 
										<div class="col-sm-4 form-group">
                                             <label>Jute Grade</label>
                                        	 <input class="form-control" name="jutegrade" type="text" placeholder="Jute Grade" required>
                                        </div>  -->

										<div class="col-sm-4 form-group">
											<label class="required">Bale Check SlipNo.(To)</label> <input
												class="form-control" name="slip_no_to" id="slip_no_to"
												type="number" placeholder="Bale Check SlipNo"
												onblur="calculateNoOfBales()" min="0" required
												onkeyup="baleToLen()">
										</div>

										<div class="col-sm-4 form-group">
											<label class="required">Total Bales</label> <input
												class="form-control" name="bale_no" id="bale_no"
												type="number" placeholder="Total bales" readonly required>
										</div>


									</div>

									<div class="row">	
										<div class="form-group">
											<button class="btn btn-default" type="submit">Submit</button>
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

<script>
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
	 //function  binno_check(){
		 $("#bin_no").on("change", function(){
		 var basis;
			var jutevariety;
		 var binNo = document.getElementById("bin_no").value;
		$.ajax({
			type:"GET",
			url:"getbinno.obj",
			data: {"binno" :binNo}, 
			success:function(result){
				//alert(result);
				if(result != "null"){
					//alert("yes")
					 $('#basis option[value=""]').remove();
					
					const myArray= result.split("-");
	 					basis =myArray[0];
	 					jutevariety = myArray[1];
	 					var htm = "<option disabled selected value>-Select-</option>";
	 					htm = '<option value="'+jutevariety+'">'+jutevariety+"</option>"			
						$("#jute_variety").html(htm);
	 					if (basis == "commercial")
							 var basis_no = '2';
						else if (basis == "msp"||basis == "MSP")
							var basis_no = '1';
	 					console.log(basis_no);
	 					var html = '<option value="'+basis+'">'+basis+"</option>"			
							$("#basis").html(html);
	 					$.ajax({
							type : "GET",
							url : "findGradeOnJuteVariety.obj",
							data : jQuery.param({
								"variety" : jutevariety,
								"basis_no" : basis_no
							}),
							success : function(result) {
								
								var data = jQuery.parseJSON(result);
							//	alert(data);
								var html = "<option disabled selected value>-Select-</option>";
								for (var i = 0; i < data.length; i++) {
									var sar = data[i]
									html += "<option value="+sar+">"
											+ data[i] + "</option>"
								}
								$("#jute_grade").html(html);

							}
						});
			 				
	 					
	 					console.log(basis);
	 					console.log(jutevariety);
 					}
				else if (result == "null"){
					//alert("else");
					var htm = "<option disabled selected value>-Select-</option>";
 					htm += '<option value="msp">MSP</option>'
 					htm += '<option value="commercial">Commercial</option>'
					$("#basis").html(htm);
				}
			
			}
		});
		});
		
	</script>
<script>
$("#place_of_packing").on("change", function() {
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
		var msp_no;
		var variety = (this.value);	
		if(variety=="msp"){
			msp_no = 2;
		}
		else if(variety=="commercial"){
			msp_no = 1;
		}
		$.ajax({
			type:"GET",
			url:"findJuteOnBasis.obj",
			data:{"msp_no":msp_no},
			success:function(result){
 				   var data= jQuery.parseJSON(result);
	 					 var html = "<option disabled selected value>-Select-</option>";
 				     for (var i = 0; i< data.length; i++){
 				    	 var sar = data[i]
 					 html += "<option value="+sar+">"+data[i]+"</option>"			
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
										data : {"id" : myVar},
										success : function(result) {

											var data = jQuery.parseJSON(result);
											var html = "<option disabled selected value>-Select-</option>";
											for (var i = 0; i < data.length; i++) {
												console.log(data[i].split("-")[0]
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
	<!-- 	<script>
	$("#jutevariety").on("change", function() {
		var basis_no;
		var grade;
		var count=0;
		var data;
		var basis = document.getElementById("basis").value;	
		if(basis=="commercial")
			basis_no=2;
		else if(basis=="msp")
			basis_no=1;
		 var variety = (this.value);
			 $.ajax({
				type:"GET",
				url:"findGradeOnJuteVariety.obj",
				data: jQuery.param({ "variety": variety, "basis_no" : basis_no}) ,
				success:function(result){
					data = jQuery.parseJSON(result);
					// alert(data);
					count = data.length;
					$('#lblName').text('Enter Grade Details');
					 if(variety=='Bimli'){
						$('#form2 input').remove();
						$('#form2 label').remove();
					}else if(variety=="Mesta"){
						$('#form2 input').remove();
						$('#form2 label').remove();
					}
					 else{
						$('#form2 input ').remove();
						$('#form2 label').remove();
					} 
					
			        for (i=0;i<data.length;i++){
			        	$('<div class="form-group">').appendTo('#form2');
			        	$('<label/>').text(data[i]+" : ").appendTo('#form2');
			        	// $('<br/>').appendTo('#form2');
	 				    $('<input/>').attr({ type: 'text', id: 'grade'+i, name: 'grade'+i,value:'' }).appendTo('#form2');
	 				   $('</div>').appendTo('#form2');
	 				    //$('<br/>').appendTo('#form2');
			        }
	 			  } 		     
				});	
	});	
	</script>
 	-->
	<!-- <script>
		$("#bin_no").on("select",function() {
							var basis_no;
							var grade;
							var count = 0;
							var data;
							var basis = document.getElementById("basis").value;
							if (basis == "commercial")
								basis_no = 2;
							else if (basis == "msp")
								basis_no = 1;
							var variety = (this.value);
							$
									.ajax({
										type : "GET",
										url : "findGradeOnJuteVariety.obj",
										data : jQuery.param({
											"variety" : variety,
											"basis_no" : basis_no
										}),
										success : function(result) {
											data = jQuery.parseJSON(result);
											var data = jQuery.parseJSON(result);

											var html = "<option disabled selected value>-Select-</option>";
											for (var i = 0; i < data.length; i++) {
												var sar = data[i]
												html += "<option value="+sar+">"
														+ data[i] + "</option>"
											}
											$("#jute_grade").html(html);

										}
									});
						});
	</script> -->
	<script>
		function checkLen() {
			var binnumber = document.getElementById("bin_no").value;
			var max_chars = 3;
			// binnumber.value = binnumber.value.substr(0, max_chars);
			if (binnumber.toString().length == 3) {
				// alert("hell");
				$("#bin_no").prop("type", "text");
				$("#bin_no").attr("maxlength", "3");
				$("#bin_no").attr("minlength", "1");
			}
		}
	</script>

	<script>
		function calculateNoOfBales() {
			var fromCheckSlipNo = document.getElementById("slip_no_from").value;
			var toCheckSlipNo = document.getElementById("slip_no_to").value;
			var noOfBales = (toCheckSlipNo - fromCheckSlipNo) + 1;
			if (noOfBales >= 0) {
				document.getElementById("bale_no").value = noOfBales;
			} else {
				alert("No of bales can not be negative or 0");
				return false;
			}
		}

		function baleFromLen() {
			var binnumber = document.getElementById("slip_no_from").value;
			if (binnumber.toString().length == 6) {
				$("#slip_no_from").prop("type", "text");
				$("#slip_no_from").attr("maxlength", "6");
				$("#slip_no_from").attr("minlength", "1");
			}
		}

		function baleToLen() {
			var binnumber = document.getElementById("slip_no_to").value;
			if (binnumber.toString().length == 6) {
				$("#slip_no_to").prop("type", "text");
				$("#slip_no_to").attr("maxlength", "6");
				$("#slip_no_to").attr("minlength", "1");
			}
		}
	</script>
	<!-- PAGE LEVEL SCRIPTS-->
</body>
</html>