<%@page import="com.jci.model.RoleMasterModel"%>
<%@page import="com.jci.model.ZoneModel"%>
<%@page import="com.jci.model.MSPPriceCalculationModel"%>
<%@page import="java.util.List"%>
<!DOCTYPE html>
<html lang="en">
<%@ page import="javax.servlet.http.HttpServletRequest"%>
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
<link href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<link href="<%=request.getContextPath() %>/resources/css/styleUserReg.css" rel="stylesheet">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

<script type="text/javascript" src='<%=request.getContextPath() %>/resources/js/responsivevoice.js'></script>

<script type="text/javascript" src='<%=request.getContextPath() %>/resources/js/custom.js'></script>
<script type="text/javascript" src='<%=request.getContextPath() %>/resources/js/jquery.mCustomScrollbar.concat.min.js'></script>
<script type="text/javascript" src='<%=request.getContextPath() %>/resources/js/jquery.validate.min.js'></script>
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
.field-icon {
  float: right;
  margin-left: -25px;
  margin-top: -25px;
  position: relative;
  z-index: 2;
}

.container{
  padding-top:50px;
  margin: auto;
}

 .required:after {
    content:" *";
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
				<h1 class="page-title">Jute Variety Grades Price for MSP</h1>
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
							
 
								<form  action="saveGradePriceOfMSP.obj" method="POST"  name="myForm" onsubmit="return validate()" >
								
								    <input type="hidden" name="dubjuteVariety" id="dubjuteVariety">
									<input type="hidden" name="dubcropyr" id="dubcropyr"> 
							<div class="row">

										<div class="col-sm-4 form-group">
											<label>Jute Variety</label> <span class="text-danger">* </span>
											<span id="errJuteVariety" name="errJuteVariety" class="text-danger "> </span>
                                        	<select name="jutevariety" id="jutevariety" class="form-control"   onchange="return validatejute()" required>   
                                        	<option disabled selected value>-Select-</option>
                                        	<option value="Bimli">Bimli</option>
                                        	<option value="Mesta">Mesta</option>
                                        	<option value="Tossa (New)">Tossa (New)</option>
                                        	<option value="White (New)">White (New)</option>
                                        	</select>
										</div>
										
										<div class="col-sm-4 form-group">
                                            <label>Crop Year</label>  <span class="text-danger">* </span>
											<select name="cropyr" id="cropyr" class="form-control" required="required" onchange="return validatejute()">
												<option value="">Select</option>
											
												
											</select>
                                        </div>								
									
									<div class="col-sm-4 form-group">
                                            <label id="lblName"></label>
                                           <div  id="form2">
                                    
                                    </div>
									
									</div>
									
                                     	
                                        </div>
                                        
                                     	
                                    
									<div class="row">
									<div class="form-group"> 
                                   <input type="hidden" id="g0" name="g0" value="0.0">
                                    <input type="hidden" id="g1" name="g1" value="0.0">
                                     <input type="hidden" id="g2" name="g2" value="0.0">
                                      <input type="hidden" id="g3" name="g3" value="0.0">
                                       <input type="hidden" id="g4" name="g4" value="0.0">
                                        <input type="hidden" id="g5" name="g5" value="0.0">
                                         <input type="hidden" id="g6" name="g6" value="0.0">
                                          <input type="hidden" id="g7" name="g7" value="0.0">
                                          </div>
                                          </div>
														<div class="row">
								<div class="col-sm-4 form-group">
								 <input type="submit" value="Submit" class="btn btn-primary" id="submit">
									<!-- <input class="btn btn-primary" type="submit" id="enq_submit">Submit</button> -->
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
		</body>

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
	}); 
	

</script>
		
<script>
	$("#jutevariety").on("change", function() {
		//alert("variety");
		var basis_no;
			basis_no=1;
		 var variety = (this.value);
		 	 //alert("variety= "+variety+"  basis= "+basis_no);
			 $.ajax({
				type:"GET",
				url:"findGradeOfMSP.obj",
				data: jQuery.param({ "variety": variety, "basis_no" : basis_no}) ,
				success:function(result){
					data = jQuery.parseJSON(result);
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
			       
	 				    $('<input/>').attr({ type: 'number', id: 'grade'+i, name: 'test[]',value:'0' , min:'0' }).appendTo('#form2');
	 				   
	 				   $('</div>').appendTo('#form2');
	 				   
	 				  
			        }
			        
			              
	 				 } 
		
				     
				});
			 
			  
		
	});
	
	
	</script>
<!-- 	<script type="text/javascript">
	$(document).ready(function(){
		  $("#submit").click(function(){
			// alert("hiii");
			  var a=0;
			 
			 var input = document.getElementsByName('test[]');
			 for(var i=0; i<input.length;i++){
				 a = input[i];
	         	  document.getElementById("g"+i).value = parseFloat(a.value);
	         	  
			 }
			
		    
		  });
		});
	</script> -->
	
	
	<script type="text/javascript">
 function validate(){
			// alert("hiii");
			  var a=0;
			 var input = document.getElementsByName('test[]');
			 
			 for(var i=0; i<input.length;i++){
				 a = input[i];
				 if(a.value != null && a.value !=0 && a.value != "")
	         	  document.getElementById("g"+i).value = parseFloat(a.value);
				 
				 else
				 	  document.getElementById("g"+i).value = 0.0;
			 }
			  var grade0 =Number( $("#grade0").val());
			  
			  var grade1 = Number($("#grade1").val());
			  var grade2 = Number($("#grade2").val());
			  var grade3 = Number($("#grade3").val());
			  var grade4 = Number($("#grade4").val());
			  var grade5 = Number($("#grade5").val());
			  var grade6 = Number($("#grade6").val());
			  var grade7 = Number($("#grade7").val());
		
			 var result = true;
					// alert(grade0+grade1+grade2+grade3+grade4+grade5+grade6+grade7);
				
					  if( (grade1 > grade0)) {
						  if(grade0!=0)
							  {
							  alert("price of grade 2 can not be greater than price of grade 1!!");
							  result = false;
							  }
						 
					  }
					  if ( (grade2 > grade1) || (grade2 > grade0) ){
						  if(grade1!=0 && grade2>grade1)
							  {
							  alert("price of grade 3 can not be greater than price of grade 2!!");
							  result = false;
							  }
						  else if(grade0!=0 && grade2>grade0)
							  {
							  alert("price of grade 3 can not be greater than price of grade 1!!");
							  result = false;
							  }
						 
					  }
					  if( (grade3 > grade2) || (grade3 > grade1) || (grade3 > grade0) ){
						 
						  if(grade2!=0 && grade3>grade2){
						  alert("price of grade 4 can not be greater than price of grade 3!!");
						  result = false;
					      }
						  else if(grade1!=0 && grade3>grade1)
							  {
							  alert("price of grade 4 can not be greater than price of grade 2!!");
							  result = false;
							  }
						  else if(grade0!=0 && grade3>grade0)
						  {
						  alert("price of grade 4 can not be greater than price of grade 1!!");
						  result = false;
						  }
					  }
					  if( (grade4 > grade3) || (grade4 > grade2) || (grade4 > grade1)  || (grade4 > grade0)){
						 
						      if(grade3!=0 && grade4>grade3){
							  alert("price of grade 5 can not be greater than price of grade 4!!");
							  result = false;
						      }
							  else if(grade2!=0 && grade4>grade2)
							  {
							  alert("price of grade 5 can not be greater than price of grade 3!!");
							  result = false;
							  }
							  else if(grade1!=0 && grade4>grade1)
							  {
							  alert("price of grade 5 can not be greater than price of grade 2!!");
							  result = false;
							  }
							  else if(grade0!=0 && grade4>grade0)
							  {
							  alert("price of grade 5 can not be greater than price of grade 1!!");
							  result = false;
							  }
					  }
  					  if( (grade5 > grade4) || (grade5 > grade3) || (grade5 > grade2) || (grade5 > grade1)  || (grade5 > grade0)){
  						 
  						  
  						      if(grade4!=0 && grade5>grade4){
  						      alert("price of grade 6 can not be greater than price of grade 5!!");
  	  						  result = false;
						      }
							  else if(grade3!=0 && grade5>grade3)
							  {
							  alert("price of grade 6 can not be greater than price of grade 4!!");
							  result = false;
							  }
							  else if(grade2!=0 && grade5>grade2)
							  {
							  alert("price of grade 6 can not be greater than price of grade 3!!");
							  result = false;
							  }
							  else if(grade1!=0 && grade4>grade1)
							  {
							  alert("price of grade 6 can not be greater than price of grade 2!!");
							  result = false;
							  }
							  else if(grade0!=0 && grade4>grade0)
							  {
							  alert("price of grade 6 can not be greater than price of grade 1!!");
							  result = false;
							  }
					  }
  					  if((grade6 > grade5) || (grade6 > grade4) || (grade6 > grade3) || (grade6 > grade2) || (grade6 > grade1)  || (grade6 > grade0)){
  						 
  						     if(grade5!=0 && grade6>grade5){
							  alert("price of grade 7 can not be greater than price of grade 6!!");
	  						  result = false;
						      }
  						     else if(grade4!=0 && grade6>grade4){
  							  alert("price of grade 7 can not be greater than price of grade 5!!");
  	  						  result = false;
						      }
							  else if(grade3!=0 && grade6>grade3)
							  {
							  alert("price of grade 7 can not be greater than price of grade 4!!");
							  result = false;
							  }
							  else if(grade2!=0 && grade6>grade2)
							  {
							  alert("price of grade 7 can not be greater than price of grade 3!!");
							  result = false;
							  }
							  else if(grade1!=0 && grade6>grade1)
							  {
							  alert("price of grade 7 can not be greater than price of grade 2!!");
							  result = false;
							  }
							  else if(grade0!=0 && grade6>grade0)
							  {
							  alert("price of grade 7 can not be greater than price of grade 1!!");
							  result = false;
							  }
					  }
  					  if((grade7 > grade6) || (grade7 > grade5) || (grade7 > grade4) || (grade7 > grade3) || (grade7 > grade2) || (grade7 > grade1)  || (grade7 > grade0)){
  						 
  						    if(grade6!=0 && grade7>grade6){
							  alert("price of grade 8 can not be greater than price of grade 7!!");
	  						  result = false;
						      }
  					         else if(grade5!=0 && grade7>grade5){
  							  alert("price of grade 8 can not be greater than price of grade 6!!");
  	  						  result = false;
						      }
						     else if(grade4!=0 && grade7>grade4){
							  alert("price of grade 8 can not be greater than price of grade 5!!");
	  						  result = false;
						      }
							  else if(grade3!=0 && grade7>grade3)
							  {
							  alert("price of grade 8 can not be greater than price of grade 4!!");
							  result = false;
							  }
							  else if(grade2!=0 && grade7>grade2)
							  {
							  alert("price of grade 8 can not be greater than price of grade 3!!");
							  result = false;
							  }
							  else if(grade1!=0 && grade7>grade1)
							  {
							  alert("price of grade 8 can not be greater than price of grade 2!!");
							  result = false;
							  }
							  else if(grade0!=0 && grade7>grade0)
							  {
							  alert("price of grade 8 can not be greater than price of grade 1!!");
							  result = false;
							  }
					  }
					 
			//alert(result);
			return result ;
		    
		  } 
		 
	
		
	</script>
	
	 
<script>

function validatejute() {
	var jutevariety = document.getElementById("jutevariety").value;
	var cropyr = document.getElementById("cropyr").value;
	var flag = false;
	var jutevarietyLen = jutevariety.length;
	flag =  true;
	if(jutevarietyLen> 0){
		  $.ajax({
				type:"GET",
				url:"validatejutevariety.obj?jutevariety='"+jutevariety+"'&cropyr='"+cropyr+"'",
				success:function(result){
					var data = result;
				
					if(data == 'false'){
						document.getElementById("errJuteVariety").innerHTML ="Jute Variety Exists IN "+cropyr;
						document.getElementById("submit").disabled = true;
						return false;
					}
					else if(data == 'true'){
						document.getElementById("errJuteVariety").innerHTML = "";
						document.getElementById("submit").disabled = false;
						return true;
					}
					
				}
		  });
	 }
}
</script>

	 
	
</html>
