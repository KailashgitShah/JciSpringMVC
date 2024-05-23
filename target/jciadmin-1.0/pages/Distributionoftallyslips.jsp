
<%@page import="com.jci.model.ZoneModel"%>

<%@page import="java.util.List"%>

<%@ page import="javax.servlet.http.HttpServletRequest"%>
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
    <!-- THEME STYLES-->
    <link href="assets/css/main.min.css" rel="stylesheet" />
    <!-- PAGE LEVEL STYLES-->
    <link rel="stylesheet" href="/resources/demos/style.css">
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
<script src="https://code.jquery.com/ui/1.13.2/jquery-ui.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.5.0/js/bootstrap-datepicker.js"></script>   
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
                <h1 class="page-title">Distribution of Tally Slip</h1>
            </div>
            <div class="page-content fade-in-up">
                <div class="row">
                    <div class="col-md-11">
                        <div class="ibox">
                            <div class="ibox-head">
								<!-- <div class="ibox-title">Basic form</div> -->
								<span>${msg}</span>
							</div>
                            <div class="ibox-body">
                                <form action="saveDistributionoftallyslip.obj" method="POST" name="myForm" id="form" onsubmit="return validate()" autocomplete="off">
                                    
                                    <div class="row">
										
										<div class="col-sm-4 form-group">
											<label id="zoneLabel" class="required">Zone</label> <span class="text-danger">* </span> &nbsp;&nbsp;&nbsp; <span id="errZone" name="errZone" class="text-danger"> </span>
											<%
												List<ZoneModel> zoneList = (List<ZoneModel>) request.getAttribute("zoneList");
											%>
											<select class="form-control" name="zone" id="zone" required>
												<option disabled selected value>-Select-</option>
												<%
													for(ZoneModel zoneLists : zoneList) {
												%>
												<option value="<%=zoneLists.getZonecode()%>"><%=zoneLists.getZonename()%></option>
												<%
													}
												%>
											</select>
											<!-- <input class="form-control" type="text" name="zone" placeholder="Zone"> -->
										</div>
										<div class="col-sm-4 form-group">
											<label id="regionLabel" class="required">Region</label><span class="text-danger">* </span>&nbsp;&nbsp;&nbsp; <span id="errRegion" name="errRegion" class="text-danger"> </span>
											<!-- <input class="form-control" type="text" name="region" placeholder="Region" required> -->
											<select class="form-control" name="region" id="region" required>
												<option disabled selected value>-Select-</option>
											</select>
										</div>
										<div class="col-sm-4 form-group">
											<label id="dpclabel" class="required">DPC</label> <span class="text-danger">* </span>&nbsp;&nbsp;&nbsp; <span id="errDPC" name="errDPC" class="text-danger"> </span>
											<select class="form-control" name="dpccode" id="dpccode" required>
												<option disabled selected value>-Select-</option>
											</select>
										</div>
									</div>
                                    <div class="row">
                                      <!--   <div class="col-sm-4 form-group">
                                            <label>DPC Code</label>   <span class="text-danger">* </span>&nbsp; <span id="errdpccode" name="errdpccode"
												class="text-danger"> </span>
                                            <input class="form-control" type="number" name="dpccode" id="dpccode" placeholder="DPC Code" required min="0">
                                        </div> -->
                                        <div class="col-sm-4 form-group">
                                            <label>Date of Receipt</label> <span class="text-danger">* </span>&nbsp; <span id="errdateofreceipt" name="errdateofreceipt"
												class="text-danger"> </span>
                                            <input class="form-control" name="dateofreceipt" id="dateofreceipt" placeholder="Date of Receipt" required readonly>
                                        </div>
                                        
										 <div class="col-sm-4 form-group">
                                             <label>Series Start from </label> <span class="text-danger">* </span>&nbsp; <span id="errseriesstartfrom" name="errseriesstartfrom"
												class="text-danger"> </span><span id="errseriesstartfrom2" name="errseriesstartfrom2"
												class="text-danger"> </span>
                                        	 <input class="form-control" name="seriesstartfrom" id="seriesstartfrom" type="number" placeholder="Series Start from " required min="0" onblur ="slipNo();" >
                                        </div>
                                         <div class="col-sm-4 form-group">
                                            <label>Series to End</label>  <span class="text-danger">* </span>&nbsp; <span id="errseriestoend" name="errseriestoend"
												class="text-danger"> </span><span id="errseriestoend2" name="errseriestoend2"
												class="text-danger"> </span>
											<input class="form-control" name="seriestoend" id="seriestoend" type="number" placeholder="Series to End" required min="0" onblur ="slipNo();">
                                        </div>
                                    </div>
                                    
                                    <div class="row">
                                   
                                    <div class="col-sm-4 form-group">
											<label>No. of slip received</label>  <span class="text-danger">* </span>&nbsp; <span id="errslipreceived" name="errslipreceived" class="text-danger"> </span>
											<span id="errslipreceived2" name="errslipreceived2" class="text-danger"> </span>
											<input class="form-control" type="number" name="slipreceived" id="slipreceived" placeholder="No. of slip received" required min="0" onblur ="slipNo();" >
										</div>
                                       
                                       
										
                        
                                    </div>                                    
                                    <div class="form-group col-sm-12">
                                        <button class="btn btn-default" id="submit" type="submit">Submit</button>
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
     
    <!-- END PAGA BACKDROPS-->
    <!-- CORE PLUGINS-->
    <script src="./assets/vendors/jquery/dist/jquery.min.js" type="text/javascript"></script>
    <script src="./assets/vendors/popper.js/dist/umd/popper.min.js" type="text/javascript"></script>
    <script src="./assets/vendors/bootstrap/dist/js/bootstrap.min.js" type="text/javascript"></script>
    <script src="./assets/vendors/metisMenu/dist/metisMenu.min.js" type="text/javascript"></script>
    <script src="./assets/vendors/jquery-slimscroll/jquery.slimscroll.min.js" type="text/javascript"></script>
    <!-- PAGE LEVEL PLUGINS-->
    <!-- CORE SCRIPTS-->
    <script src="assets/js/app.min.js" type="text/javascript"></script>
    <!-- PAGE LEVEL SCRIPTS-->
    
</body>
<link rel="stylesheet" href="//code.jquery.com/ui/1.13.2/themes/base/jquery-ui.css">
<link rel="stylesheet" href="/resources/demos/style.css">
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
<script src="https://code.jquery.com/ui/1.13.2/jquery-ui.js"></script>
<script>
$( "#dateofreceipt" ).datepicker({ maxDate: '0' , minDate: '0',dateFormat: 'dd-mm-yy'});
</script>
<script>
 function validate() {
	
	 let dpccode = document.forms["myForm"]["dpccode"].value;
	
	 
	 let dateofreceipt = document.forms["myForm"]["dateofreceipt"].value;
	
	 let slipreceived = document.forms["myForm"]["slipreceived"].value;
	 
	 let seriesstartfrom = document.forms["myForm"]["seriesstartfrom"].value;
	
	 let seriestoend = document.forms["myForm"]["seriestoend"].value;
	 
	
	 if (dpccode  == "") {
		
	    document.getElementById("errdpccode").innerHTML = "DPC Code can not be empty!";
	    document.forms["myForm"]["dpccode"].focus();
	    return false;
	  }
	  else if(dateofreceipt == ""){
		  document.getElementById("errdateofreceipt").innerHTML = "Date of Receipt can not be empty!";
		  document.forms["myForm"]["dateofreceipt"].focus();
		  return false;
		  
	  }
	 
	  else if(slipreceived == ""){
		  document.getElementById("errslipreceived").innerHTML = "Slip Received can not be empty!";
		 
		  document.forms["myForm"]["slipreceived"].focus();
		  return false;
	  }
	
	  else if(seriesstartfrom == ""){
		  document.getElementById("errseriesstartfrom").innerHTML = "series Start from can not be empty!";
		  
		  document.forms["myForm"]["seriesstartfrom"].focus();
		  return false;
	  }

	  else if(seriestoend == ""){
		  document.getElementById("errseriestoend").innerHTML = "series to End can not be empty!";
		 
		  document.forms["myForm"]["seriestoend"].focus();
		  return false;
	  }
 }
	 
</script>
<script>
function slipNo(){

	var slipreceived = document.getElementById("slipreceived").value;
	var slipfrom = document.getElementById("seriesstartfrom").value;
	var slipto = document.getElementById("seriestoend").value;
if(slipfrom <0){
	document.getElementById("errseriesstartfrom2").innerHTML = "Number can't be negative !";
	$("#errseriesstartfrom2").show();
	document.getElementById("slipreceived").value = 0;
	$('#submit'). prop('disabled', true)
}
else{
	$("#errseriesstartfrom2").hide();
}
if(slipto <0){
	document.getElementById("errseriestoend2").innerHTML = "Number can't be negative !";
	$("#errseriestoend2").show();
	document.getElementById("slipreceived").value = 0;
	$('#submit'). prop('disabled', true)
}
else{
	$("#errseriestoend2").hide();
}
var result = slipto - slipfrom;
document.getElementById("slipreceived").value = result;
	if((result % 100) != 0){
		
		document.getElementById("errslipreceived").innerHTML = "No. of Slip Received should be in multiple of 100 !";
		$("#errslipreceived").show();
		$('#submit'). prop('disabled', true)
	}
	else if((result % 100) == 0){
		$('#submit'). prop('disabled', false)
		$("#errslipreceived").hide();

	}
	if(result < 0){
		
		document.getElementById("errslipreceived2").innerHTML = "No. of Slip Received can not be negative !";
		$("#errslipreceived2").show();
		$('#submit'). prop('disabled', true)
	}
	else if((result % 100) == 0){
		$('#submit'). prop('disabled', false)
		$("#errslipreceived2").hide();
		

	}
if((slipfrom <0) ||(slipto <0) || result < 0){
	$('#submit'). prop('disabled', true)
}
}




</script>
	<script>
function deleteErrorMsg(){
	
        
	 let dpccode = document.forms["myForm"]["dpccode"].value;
        if(dpccode.length>1){
               $("#errdpccode").hide();
        }
        let dateofreceipt = document.forms["myForm"]["dateofreceipt"].value;
        if(dateofreceipt.length>1){
               $("#errdateofreceipt").hide();
        }

   	 let slipreceived = document.forms["myForm"]["slipreceived"].value;
 		if(slipreceived.length>1){
   			  $("#errslipreceived").hide();
		}
 	
 	let seriesstartfrom = document.forms["myForm"]["seriesstartfrom"].value;
		if( seriesstartfrom.length>1){
   			  $("#errseriesstartfrom").hide();
		}
	let seriestoend = document.forms["myForm"]["seriestoend"].value;
		if(seriestoend.length>1){
  		  $("#errseriestoend").hide();
		}
}
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
		 				$("#dpccode").html(html);
					}			
				});
			} 
		});
		
	</script>
	</script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
    <script src="./assets/vendors/jquery/dist/jquery.min.js" type="text/javascript"></script>
    <script src="./assets/vendors/popper.js/dist/umd/popper.min.js" type="text/javascript"></script>
    <script src="./assets/vendors/bootstrap/dist/js/bootstrap.min.js" type="text/javascript"></script>
    <script src="./assets/vendors/metisMenu/dist/metisMenu.min.js" type="text/javascript"></script>
    <script src="./assets/vendors/jquery-slimscroll/jquery.slimscroll.min.js" type="text/javascript"></script>
    <!-- PAGE LEVEL PLUGINS-->
    <!-- CORE SCRIPTS-->
    <script src="assets/js/app.min.js" type="text/javascript"></script>
    <!-- PAGE LEVEL SCRIPTS-->
</html>
