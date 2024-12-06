<%@page import="com.jci.model.RoDetailsModel"%>
<%@page import="com.jci.model.FarmerRegModel"%>
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
	 <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<!-- PAGE LEVEL PLUGINS-->
<!-- CORE SCRIPTS-->
<script src="assets/js/app.min.js" type="text/javascript"></script>
<!-- PAGE LEVEL STYLES-->

    <link rel="stylesheet" href="https://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.min.js"></script>

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
				<h1 class="page-title">Farmer Ledger Report</h1>
			</div>
			<%
			String fname = (String) session.getAttribute("farmer");
			%>
			<div class="page-content fade-in-up">
				<div class="row">
					<div class="col-md-11">
						<div class="ibox">
							
							<div class="ibox-body">
								<span>${msg}</span>
								<form action="LedgerReportList.obj" method="POST">
								
								
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
											<label class="required">Basis</label> <select name="basis"
												id="basis" class="form-control" required>
												<option value="">-Select-</option>
												<option value="msp">MSP</option>
												<option value="Commercial">Commercial</option>
											</select>
										</div>
						<div class="col-sm-4 form-group">
    <label class="required">Farmer</label>
    <input list="options" class="form-control"id="customInput" name="customInput"onkeyup="newmethod(this.value)">
    <datalist id="options">
    </datalist>
<!--    <input class="form-control" name="farmername" id="farmername" type="text" onkeyup="newmethod(this.value)" required >-->
        
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
    function newmethod(value) {
        const trimmedValue = value.trim(); // Trim leading/trailing whitespace
        if (trimmedValue.length >= 3) {
            $.ajax({
                type: "GET",
                url: "getfarmerdetail.obj",
                data: { "value": value },
                success: function(result) {
                    var data = JSON.parse(result);
                    var html = "<option disabled selected value>-Select-</option>";
                    for (var i = 0; i < data.length; i++) {
                        html += "<option value='" + data[i] + "'>" + data[i] + "</option>";
                    }
                    $("#options").html(html);
                },
                error: function(xhr, status, error) {
                    console.error("AJAX Error:", status, error);
                }
            });
        }
    }
</script>
<!-- 
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
		 var cropyear = $("#cropyear").val();
		 var farmername = $("#farmername").val();
		 var dpc = $("#dpc").val();
		 var basis = $("#basis").val();
		 var datefrom = $("#purchasesdatefrom").val();
		 var dateto = $("#purchasesdateto").val();
		 
		 if(cropyear == "" || farmername == "" || dpc == "" || basis == "" || datefrom == "" || dateto == "")
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




	<!-- PAGE LEVEL SCRIPTS-->
</body>
</html>