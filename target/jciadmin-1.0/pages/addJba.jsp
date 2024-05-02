<!DOCTYPE html>
<html lang="en">
<%@page import="com.jci.model.AreaDetailCode"%>
<%@page import="java.util.List"%>


<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width initial-scale=1.0">
    <title>JCI | CMS</title>
    <!-- GLOBAL MAINLY STYLES-->
    <link href="./assets/vendors/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet" />
    <link href="./assets/vendors/font-awesome/css/font-awesome.min.css" rel="stylesheet" />
    <link href="./assets/vendors/themify-icons/css/themify-icons.css" rel="stylesheet" />
    	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    <!-- PLUGINS STYLES-->
    <!-- THEME STYLES-->
    <link href="assets/css/main.min.css" rel="stylesheet" />
    <script src="https://code.jquery.com/jquery-3.6.0.js"></script>
  <script src="https://code.jquery.com/ui/1.13.2/jquery-ui.js"></script>
    <!-- PAGE LEVEL STYLES-->
</head>

<script type="text/javascript">
$(document).ready(function () {
	//Global var
	var current, tomorrow;
	//current date
	var dateNewFormat, onlyDate, today = new Date();
	
	onlyDate = today.getDate();
    if (onlyDate.toString().length == 2) {

        dateNewFormat =  onlyDate+ '/';
    }
    else {
        dateNewFormat = '0' + onlyDate+ '/';
    }
    
   
     var month1 = (today.getMonth() + 1);
    if (month1.toString().length== 2) {
        dateNewFormat += (today.getMonth() + 1)+ '/';
    }
    else {
        dateNewFormat += '0' + (today.getMonth() + 1)+ '/';
    }

    dateNewFormat += today.getFullYear(); 
    
    //7 days back
    var tommorowymd, tomdate,tommorowdate = new Date();
    tommorowdate.setDate(tommorowdate.getDate()-7);
    tomdate = tommorowdate.getDate();
    
    tommonth = (tommorowdate.getMonth() + 1);
    if (tomdate.toString().length == 2) {

    	tommorowymd =  tomdate+'/';
    }
    else {
    	tommorowymd = '0' + tomdate+'/';
    }
    
    if (tommonth.toString().length == 2) {

    	tommorowymd += (tommorowdate.getMonth() + 1)+'/';
    }
    else {
    	tommorowymd += '0' + (tommorowdate.getMonth() + 1)+'/';
    }

    tommorowymd += tommorowdate.getFullYear(); 
   
    
    $('#datejba').val(dateNewFormat);
    $('#datejba').attr('max', dateNewFormat);
    $('#datejba').attr('min', tommorowymd); 
    current = dateNewFormat;
    tomorrow = tommorowymd;
   

});

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
                <h1 class="page-title">JBA Price</h1>
            </div>
            <div class="page-content fade-in-up">
                <div class="row">
                    <div class="col-md-11">
                        <div class="ibox">
                             <span>${msg}</span>
                            <div class="ibox-body">
                                <form action="saveJbaRate.obj" method="POST" name="myForm" onsubmit="return validate()">
                                    <div class="row">
                                        <div class="col-sm-4 form-group">
                                           <!--  <label>JBA Date</label>
                                            <input class="form-control" type="date" name="datejba" placeholder="JaBA Date" required> -->
                                        
                                           <label>JBA Date</label>
                                         <input  name="datejba" id="datejba" class="form-control" placeholder="JaBA Date"  readonly required/>
                                       <!--  <input readonly class="form-control" id="datejba" type=date name="datejba" placeholder="JaBA Date" required> -->
                                        </div>
                                        
                                        
                                        
                                    	<div class="col-sm-4 form-group">
											<label>Jute Variety</label>
                                        	<select name="jutevariety" id="jutevariety" class="form-control" required="required">
                                        		<option value="">-Select-</option>
                                        		<option value="tossa">Tossa</option>
                                        		<option value="white">White</option>
                                        	</select>
										</div>
										
										
									<!-- 	<div class="col-sm-4 form-group">
											<label>Area code</label>
                                        	<input type="text" name="areacode"  id="areacode" class="form-control">
                                        		
                                        	
										</div> -->
										
										<div class="col-sm-4 form-group">
											<label class="required">Area Code</label> &nbsp;&nbsp; <span
												id="errPin" name="errPin" class="text-danger"> </span>
											<%
												List<AreaDetailCode> AreaCode = (List<AreaDetailCode>) request.getAttribute("AreaCode");
											%>
											<select class="form-control" name="areacode" id="areacode"
												onchange="deleteErrorMsg()" required="required">
												<option disabled selected value>-Select-</option>
												<%
													for (AreaDetailCode areaLists : AreaCode) {
														if(areaLists.getAreaName().equals("South Bengal")){
												%>
												<option value="<%=areaLists.getAreaCode()%>" selected="selected"><%=areaLists.getAreaName()%></option>
												<%
														}}
												%>
											</select>
										</div>
										  
								                              
										
                                   
                                       <div class="col-sm-4 form-group">
                                            <label>Crop Year</label> 
											<select name="cropyr" id="cropyr" class="form-control" required="required">
												<option value="">-Select-</option>
												
											</select>
                                        </div>
                                      
                                      </div>
                                      <div class="row">
                                       <div class="col-sm-4 form-group" >
											<label><b>Northern Base Price</b></label></br>
											<label>Basis Price +</label><input  type="tel" maxlength="10" name="northernprice"  id ="northernprice" required="required" minlength="0"/></br> 
										</div>
										
										<div class="col-sm-4 form-group" >
											<label><b>Semi-Northern Base Price</b></label></br>
											<label>Basis Price +</label><input  type="tel" maxlength="10" name="seminorthernprice"  id ="seminorthernprice" required="required" minlength="0"  /></br> 
										</div>
										
										<div class="col-sm-4 form-group" >
											<label><b>Bihar Base Price</b></label></br>
											<label>Basis Price +</label><input  type="tel" maxlength="10" name="biharprice"  id ="biharprice" required="required" minlength="0" /></br> 
										</div>
										
										<!-- <div class="col-sm-4 form-group" >
											<label><b>Other State Base Price</b></label></br>
											<label>Basis Price +</label><input  type="number" name="otherprice"  id ="otherprice"  min="0"/></br> 
										</div>
                                     -->
                                    
                                   
                                
                                        <div class="col-sm-4 form-group" id ="tossadiv">
											<label><b>SB Grade Wise Price For Tossa</b></label></br>
											<label>TD1:-</label><input  type="number" name="gradewisepp1"  id ="gradewisepp1" value="0" min="0"/></br>
                                            <label>TD2:-</label><input  type="number" name="gradewisepp2" id ="gradewisepp2" value="0" min="0" /></br>
                                            <label>TD3:-</label><input  type="number" name="gradewisepp3"  id ="gradewisepp3" value="0" min="0"/></br>
                                            <label>TD4:-</label><input  type="number" name="gradewisepp4" id ="gradewisepp4" value="0" min="0"/></br>
                                            <label>TD5:-</label><input  type="number" name="gradewisepp5"  id ="gradewisepp5" value="0" min="0"/></br>
                                            <label>TD6:-</label><input  type="number" name="gradewisepp6"  id ="gradewisepp6" value="0" min="0"/></br>
                                            <label>TD7:-</label><input  type="number" name="gradewisepp7"  id ="gradewisepp7" value="0" min="0"/></br>
                                           <label>TD8:-</label><input  type="number" name="gradewisepp8"  id ="gradewisepp8" value="0" min="0"/></br>
										</div>
										
										
                                        <div class="col-sm-4 form-group" id ="whitediv">
											<label><b>SB Grade Wise Price For White</b></label></br>
											<label>W1:-</label><input  type="number" name="gradewisepp9"  id ="gradewisepp9" value="0" min="0"/></br>
                                            <label>W2:-</label><input  type="number" name="gradewisepp10" id ="gradewisepp10" value="0" min="0"/></br>
                                            <label>W3:-</label><input  type="number" name="gradewisepp11"  id ="gradewisepp11" value="0" min="0"/></br>
                                            <label>W4:-</label><input  type="number" name="gradewisepp12" id ="gradewisepp12" value="0" min="0"/></br>
                                            <label>W5:-</label><input  type="number" name="gradewisepp13"  id ="gradewisepp13" value="0" min="0"/></br>
                                            <label>W6:-</label><input  type="number" name="gradewisepp14"  id ="gradewisepp14" value="0" min="0"/></br>
                                            <label>W7:-</label><input  type="number" name="gradewisepp15"  id ="gradewisepp15" value="0" min="0"/></br>
                                            <label>W8:-</label> <input  type="number" name="gradewisepp16"  id ="gradewisepp16" value="0" min="0"/></br>
          
										</div>
										
										
										
                                    </div>   
                                   
                                 
                                    
	                                                                      
                                    <div class="form-group">
                                        <button class="btn btn-default" type="submit">Submit</button>
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
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
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
		$(document).ready(function(){
			$("#whitediv").hide();
			$("#tossadiv").hide();
			 
		});

	  
		
	$('#jutevariety').change(function () {
			 var selectedText = $(this).find("option:selected").text();
	            var selectedValue = $(this).val();
	            //console.log(" Value:" + selectedValue);
	            if(selectedValue == 'tossa' ){
	            	$("#whitediv").hide();
	            	$("#tossadiv").show();
	            }
	            if(selectedValue == 'white' ){
	            	$("#whitediv").show();
	            	$("#tossadiv").hide();
	            }
	            if(selectedValue == '' ){
	            	$("#whitediv").hide();
	            	$("#tossadiv").hide();
	            }
		
	});
	
	</script>
	<script type="text/javascript">
	function validate()
	{
		 
		var result = true;
		var grade1=0,grade2=0,grade3=0,grade4=0,grade5=0,grade6=0,grade7=0,grade8=0;
		 var selectedValue = document.forms["myForm"]["jutevariety"].value;
		 
		 if(selectedValue == 'tossa' ){
			    grade0 = Number($("#gradewisepp1").val());
			    grade1 = Number($("#gradewisepp2").val());
			    grade2 = Number($("#gradewisepp3").val());
			    grade3 = Number($("#gradewisepp4").val());
			    grade4 = Number($("#gradewisepp5").val());
			    grade5 = Number($("#gradewisepp6").val());
			    grade6 = Number($("#gradewisepp7").val());
			    grade7 = Number($("#gradewisepp8").val());
         }
         if(selectedValue == 'white' ){
        	grade0 = Number($("#gradewisepp9").val());
 		    grade1 = Number($("#gradewisepp10").val());
 		    grade2 = Number($("#gradewisepp11").val());
 		    grade3 = Number($("#gradewisepp12").val());
 		    grade4 = Number($("#gradewisepp13").val());
 		    grade5 = Number($("#gradewisepp14").val());
 		    grade6 = Number($("#gradewisepp15").val());
 		    grade7 = Number($("#gradewisepp16").val());
         }
        // alert(grade4);
         //alert(typeof grade0);
         if(grade4==0 ){
        	 alert("Pls fill the Grade 5 Price...!!!");
         	result = false;
         }
		
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
			//  alert(result);
			  return result;
	}
	</script>
	</script>
<link rel="stylesheet" href="//code.jquery.com/ui/1.13.2/themes/base/jquery-ui.css">
	<link rel="stylesheet" href="/resources/demos/style.css">
	<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
	<script src="https://code.jquery.com/ui/1.13.2/jquery-ui.js"></script>
	<script>
    
	$( "#datejba" ).datepicker({ dateFormat: 'dd/mm/yy',minDate : 'current-7', maxDate : 'current'});
	</script>
	
	
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
