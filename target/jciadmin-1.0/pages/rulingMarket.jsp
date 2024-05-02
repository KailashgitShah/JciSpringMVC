<%@page import="java.util.List"%>
<%@page import="java.time.LocalDate"%>
<%@page import="java.time.LocalDateTime"%>
<%@page import="java.time.format.DateTimeFormatter"%>
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
     <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
     <link rel="stylesheet" href="//code.jquery.com/ui/1.13.2/themes/base/jquery-ui.css">
<link rel="stylesheet" href="/resources/demos/style.css">
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
<script src="https://code.jquery.com/ui/1.13.2/jquery-ui.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.5.0/js/bootstrap-datepicker.js"></script>  
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<!-- CORE SCRIPTS-->

  <link rel="stylesheet" href="assets/css/docsupport/style.css">
  <link rel="stylesheet" href="assets/css/docsupport/prism.css">
  <link rel="stylesheet" href="assets/css/chosen.css">
  <script src="https://code.jquery.com/jquery-3.6.0.js"></script>
  <script src="https://code.jquery.com/ui/1.13.2/jquery-ui.js"></script>
  
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
                <h1 class="page-title">Ruling Market Rate at DPC</h1>
            </div>
            
            <% 
         // Author vishal
         
	            String region_id = (String) session.getAttribute("region");	
	            int created_by = (int)session.getAttribute("userId");
	            String dpcCenter = (String) session.getAttribute("dpc_center");
	            String dpcid = (String) session.getAttribute("dpcId");
	            LocalDate date = LocalDate.now();
	            
            %>
            
            <script>
            $(document).ready(function(){
            	var day = <%= LocalDate.now().getDayOfMonth() %>
            	 if (day.toString().length == 2) {

            		 day =  day;
            	    }
            	    else {
            	    	day = '0' + day;
            	    }
            	var month = <%= LocalDate.now().getMonthValue() %>
            	var year = <%= LocalDate.now().getYear() %>
            	var fulldate = day+"-"+month+"-"+year;
            	$('#datearrival').val(fulldate);
            	
            });
            </script>
            <div class="page-content fade-in-up">
                <div class="row">
                    <div class="col-md-11">
                        <div class="ibox">
                          <span>${msg}</span>
                            <div class="ibox-body">
                       <form action="saveRulingMarketMid.obj" method="POST">
                           <div class="child-checkbox" id="disableform">
                                <div class="row">
                                   <div class="col-sm-4 form-group">
	                                  <input type="checkbox" id="noarrival" name="noarrival" onclick="enableCreateUser()" value="0">
			                          <label> No Arrival</label>
		                           </div>
		                        </div> 
                                  
                                 <div class="row">
                                        <div class="col-sm-4 form-group">
	                                            <label>DPC Name</label>
	                                            <input class="form-control"  type="text" placeholder="Place of Purchase" value="<%=dpcCenter%>" onkeyup="deleteErrorMsg()" oninput="javascript: if (this.value.length > 4) this.value = this.value.slice(0, 4);" readonly>
	                                            <input class="form-control" name="dpcid" id="dpcid" type="hidden" value="<%=dpcid%>" >
	                                            <input class="form-control" name="region_id" id="region_id" type="hidden" value="<%=region_id%>" >
	                                            <input class="form-control" name="created_date" id="created_date" type="hidden" value="" >
	                                            <input class="form-control" name="created_by" id="created_by" type="hidden" value="<%=created_by%>" >
                                        </div>
		                                       
                                        <div class="col-sm-4 form-group">
												<label>Date of Arrival</label> 
												<span class="text-danger">* </span>&nbsp; <span id="errdatepurchase" name="errdatepurchase" class="text-danger"> </span>
												<input class="form-control" name="datearrival" id="datearrival" placeholder="Date of Arrival" value="<%=date%>"type="text" readonly>
										</div>
										
										<!-- <div class="col-sm-4 form-group">
	                                             <label>Basis</label>
	                                              <span class="text-danger">* </span>&nbsp; <span id="errbasis" name="errbasis" class="text-danger"> </span>
	                                        	 <select name="basis" id="basis" class="form-control taxtbox" required>
	                                        		<option value="">-Select-</option>
	                                        		<option value="msp">MSP</option>
	                                        		<option value="commercial">Commercial</option>
	                                        	</select>
                                        </div>  -->
                                         <div class="col-sm-4 form-group">
												<label>Jute Variety</label>
												<span class="text-danger">* </span>&nbsp; <span id="errjutevariety" name="errjutevariety" class="text-danger"> </span>
	                                        	<select name="jutevariety" id="jutevariety" class="form-control taxtbox" required>
	                                        
	                                        	  <option value="">-Select-</option>
													<option value="Bimli">Bimli</option>
													<option value="Mesta">Mesta</option>
													<option value="Tossa">Tossa</option>
													<option value="White">White</option>
													<option value="Tossa (New)">Tossa (New)</option>
													<option value="White (New)">White (New)</option>
	                                        	</select>
										 </div>
                                   </div>
                                    
                                   <div class="row">
	                                    
	                                       
										 <div class="col-sm-4 form-group">
	                                            <label>Crop Year</label> 
	                                            <span class="text-danger">* </span>&nbsp; <span id="errcropyr" name="errcropyr" class="text-danger"> </span>
												<select name="cropyr" id="cropyr" class="form-control taxtbox" required>
													<option value="">-Select-</option>											
												
												</select>
	                                     </div>
	                                     
	                                     <div class="col-sm-4 form-group">
	                                             <label>Arrived Quantity</label>
	                                        <input class="form-control taxtbox" name="arrivedquantity" min="0" type="number" placeholder="Arrived Quantity" required>
	                                     </div>
	                                     <div class="col-sm-4 form-group">
												<label>Minimum Moisture</label>
												<span  id="errminno" class = "text-danger"></span>
	                                        	<input class="form-control taxtbox" id="minmoisture" name="minmoisture" min="0" type="number" placeholder="Minimum Moisture" onkeyup = "calminmax()" required>
										  </div>	
                                    </div>
                                    
                                    <div class="row">
                                          
										  <div class="col-sm-4 form-group">
												<label class="required">Maximum Moisture</label>
												<span  id="errmaxno" class = "text-danger"></span>
	                                        	<input class="form-control taxtbox" id="maxmoisture" name="maxmoisture" min="0" type="number" placeholder="Maximum Moisture" onkeyup = "calminmax()" required>
										  </div>
                                     </div>   
                                     
                                     <div class="row"> 
	                                       <div class="col-sm-4 form-group">
	                                            <label id="lblName"></label>
	                                             <div  id="form2"> </div>
			                                        <div class="form-group"> 
				                                         <input  type="hidden" id="g0" name="g0" value="0">
				                                         <input type="hidden" id="g1" name="g1" value="0">
				                                         <input type="hidden" id="g2" name="g2" value="0">
				                                         <input type="hidden" id="g3" name="g3" value="0">
				                                         <input type="hidden" id="g4" name="g4" value="0">
				                                         <input type="hidden" id="g5" name="g5" value="0">
				                                         <input type="hidden" id="g6" name="g6" value="0">
				                                         <input type="hidden" id="g7" name="g7" value="0">
			                                        </div>
		                                     </div>   
		                                     <div class="col-sm-4 form-group">
				                                 <label id="lblName1"></label>
				                                  <div  id="form3"> </div>
						                             <div class="form-group"> 
								                          <input type="hidden" id="gr0" name="gr0" value="0">
								                          <input type="hidden" id="gr1" name="gr1" value="0">
								                          <input type="hidden" id="gr2" name="gr2" value="0">
								                          <input type="hidden" id="gr3" name="gr3" value="0">
								                          <input type="hidden" id="gr4" name="gr4" value="0">
								                          <input type="hidden" id="gr5" name="gr5" value="0">
								                          <input type="hidden" id="gr6" name="gr6" value="0">
								                          <input type="hidden" id="gr7" name="gr7" value="0">
						                             </div>
				                              </div>
				                             
                                      </div>
                                        <div class="row"> 
                                                <div class="col-sm-12 form-group">
									             <input type="submit" value="Submit"class="btn btn-primary" id="submit">
									            </div>
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
		html += "<option value = '"+(cropyr + 1)+"-"+(cropyr + 2)+"'>"+(cropyr + 1)+"-"+(cropyr + 2)+"</option>";
		}
		else{
			html += "<option value = '"+(cropyr - 2)+"-"+(cropyr - 1)+"'>"+(cropyr - 2)+"-"+(cropyr - 1)+"</option>";
			html += "<option value = '"+(cropyr - 1)+"-"+cropyr+"'>"+(cropyr - 1 )+"-"+cropyr+"</option>";
			html += "<option value = '"+cropyr+"-"+(cropyr + 1)+"'>"+cropyr+"-"+(cropyr + 1)+"</option>";
		}
		$("#cropyr").html(html);
	}); 
	

</script>
    	<script type="text/javascript">
	$(document).ready(function(){
		 $("#submit").click(function(){
			 // alert("test");
		
			  var dpcname = $("#dpcname").val();
			  var noarrival = $("#noarrival").val();
			  var darrival = $("#datearrival").val();
			  var basis = $("#basis").val();
			  var cropyr = $("#cropyr").val();
			  var arrivedqty = $("#arrivedquantity").val();
			  var minmoisture = $("#minmoisture").val(); 
			  var maxmoisture = $("#maxmoisture").val();
			  var JuteVariety = $("#jutevariety").val();
			  var grade0 = Number($("#rate0").val());
			  var grade1 = Number($("#rate1").val());
			  var grade2 = Number($("#rate2").val());
			  var grade3 = Number($("#rate3").val());
			  var grade4 = Number($("#rate4").val());
			  var grade5 = Number($("#rate5").val());
			  var grade6 = Number($("#rate6").val());
			  var grade7 = Number($("#rate7").val());
			  var grade8 = Number($("#rate8").val());
			  var result = true;
			 
			  
			  if(noarrival !=1)
				  {
				  
					  if(basis=="" || JuteVariety=="" || cropyr=="" ||arrivedqty=="" || minmoisture=="" || maxmoisture=="")
					  {
					   alert("Please fill the mandatory fields!");
					   return false;
					  }
				  
					  var minmois = parseFloat(document.getElementById("minmoisture").value);
						var maxmois = parseFloat(document.getElementById("maxmoisture").value);
						
						if(minmois > 100.00 || minmois > maxmois)
							{
							alert("Min Moisture should be less than max moisture and should not greater than 100!");
							return false;
							}
						if(maxmois > 100.00 || minmois > maxmois){
							alert("Max Moisture should be greater than min moisture and should not greater than 100!");
							return false;
						}
						
					 
						var b=0;
			  		    var total=0;
			  			
			  			if(JuteVariety =='Tossa (New)' || JuteVariety =='White (New)' )
			  				{
			  				 b=5;
			  				}
			  			else if(JuteVariety =='Tossa' || JuteVariety =='White' )
							{
							 b=8;
							}
			  			else
			  				{
			  				b=6;
			  				}
			  				
			  				
			  			for (var i = 0; i < b; i++)
			  			{
			  				var id = "grade"+i;
			  				var grade = document.getElementById(id).value;
			  	    		total += parseFloat(grade);
			  			}
			  			if(parseInt(total)==100.00)
			  			{
			  				result= true;
			  			}
			  			else
						{
							alert("Estimated Grade composition addition should be 100!");
							result= false;
						}   
					  
						// alert(typeof grade0);
						 
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
								  if(result)
									  {
									  return true;
									  }
								  else
									  {
									  	return false;
									  }
				  }
		    });
	 });
		
		</script>
		  
    <script type="text/javascript">
		   function enableCreateUser() 
		   {
					  if (document.getElementById("noarrival").checked) {
						  disableForm(true);
						  $('#noarrival').val(1);
						  $("#form2").hide();
						  $("#lblName").hide();
						  $("#lblName1").hide();
						  $("#form3").hide();
						  
					  } 
					  if (!document.getElementById("noarrival").checked) {
						  disableForm(false);
						  $('#noarrival').val(0);
						  $("#form2").show();
						  $("#lblName").show();
						  $("#lblName1").show();
						  $("#form3").show();
					  }
			}
		   
		   function disableForm(flag) 
		   {
			   var elements = document.getElementsByClassName("taxtbox");
			   for (var i = 0, len = elements.length; i < len; ++i) 
			   {
			     elements[i].readOnly = flag;
			     elements[i].disabled = flag;
			   }
		   }
		
   </script>
   
<!--    <script type="text/javascript">
	$("#basis").on("change", function() {
		var msp_no;
		var variety = (this.value);	
			if(variety=="msp")
			{
				 msp_no=1;
			}
			else if(variety=="commercial")
			{
				 msp_no=2;
		    }
		
			$.ajax({
				type:"GET",
				url:"findJuteOnBasis.obj",
				data:{"msp_no":msp_no},
				success:function(result){
					
	 				   var data= jQuery.parseJSON(result);
 	 					 var html = "<option disabled selected value>-Select-</option>";
	 				     for (var i = 0; i< data.length; i++){
	 				    	 var sar = data[i];
	 					 html += '<option value="'+sar+'">'+data[i]+"</option>"			
	 				  } 
	 				$("#jutevariety").html(html);
				}			
			});
		 
	});
	</script> -->
	
	<script>
	$("#jutevariety").on("change", function() {
		var basis_no;
		var grade;
		var count=0;
		var data;
		var basis = document.getElementById("jutevariety").value;	
		
			if(basis=="Bimli" || basis=="Mesta" || basis=="Tossa" || basis=="White")
				basis_no=2;
			else if(basis=="Tossa (New)" || basis=="White (New)" )
				basis_no=1;
		 var variety = (this.value);
			 $.ajax({
				type:"GET",
				url:"findGradeOnJuteVariety.obj",
				data: jQuery.param({ "variety": variety, "basis_no" : basis_no}) ,
				success:function(result)
				{
					data = jQuery.parseJSON(result);
					count = data.length;
					$('#lblName').text('Estimated Grade composition');
					
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
					
			        for (i=0;i<data.length;i++)
			           {
				        	$('<div class="form-group">').appendTo('#form2');
				        	$('<label/>').text(data[i]+" : ").appendTo('#form2');
				       
		 				    $('<input/>').attr({ type: 'number', id: 'grade'+i, name: 'grade'+i,value:'0', min:'0'  }).appendTo('#form2');
		 				   
		 				   $('</div>').appendTo('#form2');
			            }
			        //Start Grade Wise rate
					 $('#lblName1').text('Grade Wise Rate');
					 if(variety=='Bimli'){
							$('#form3 input').remove();
							$('#form3 label').remove();
							
						}else if(variety=="Mesta"){
							$('#form3 input').remove();
							$('#form3 label').remove();
						}
						 else{
							$('#form3 input ').remove();
							$('#form3 label').remove();
						} 
			         
						for (i=0;i<data.length;i++)
						{
				        	$('<div class="form-group">').appendTo('#form3');
				        	$('<label/>').text(data[i]+" : ").appendTo('#form3');
		 				    $('<input/>').attr({ type: 'number', id: 'rate'+i, name: 'rate'+i,value:'0', min:'0'  }).appendTo('#form3');
		 				    $('</div>').appendTo('#form3');
				 				   
					    }
	 		      } 
			});
			 
	});
	
	
	</script>
	
	<script>
	function calminmax() {
		var minmois = parseFloat(document.getElementById("minmoisture").value);
		var maxmois = parseFloat(document.getElementById("maxmoisture").value);
		
		if(minmois > 100.00 || minmois > maxmois)
			{
			 document.getElementById("errminno").innerHTML = "Min Moisture should be less than max moisture and should not greater than 100!";
			}
		else
			{
			  document.getElementById("errminno").innerHTML = "";
			}
			if(maxmois > 100.00 || minmois > maxmois)
			{
				document.getElementById("errmaxno").innerHTML = "Max Moisture should be greater than min moisture and should not greater than 100!";
			}
			else
			{
				document.getElementById("errmaxno").innerHTML = "";
			}
			return false;
	}
	</script>
	
    
    
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
</html>