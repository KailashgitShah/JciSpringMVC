<%@page import="com.jci.model.RoleMasterModel"%>
<%@page import="com.jci.model.ZoneModel"%>

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

<link rel="stylesheet" href="assets/css/docsupport/style.css">
  <link rel="stylesheet" href="assets/css/docsupport/prism.css">
  <link rel="stylesheet" href="assets/css/chosen.css">
  <script src="https://code.jquery.com/jquery-3.6.0.js"></script>
  <script src="https://code.jquery.com/ui/1.13.2/jquery-ui.js"></script>

 

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
  
  input[type="radio"]{
    display: inline;
}
 
 
</style>


		
</head>
<script>
$(document).ready(function () {
    var dateNewFormat, onlyDate, today = new Date();
    onlyDate = today.getDate();
    if (onlyDate.toString().length == 2) {

        dateNewFormat =  onlyDate+ '-';
    }
    else {
        dateNewFormat = '0' + onlyDate+ '-';
    }
     
   //  alert(today.getMonth()+1);
     var month1 = (today.getMonth() + 1);
    // alert(month1);
    if (month1.toString().length== 2) {
     //alert("if");
        dateNewFormat += (today.getMonth() + 1)+ '-';
    }
    else {
        dateNewFormat += '0' + (today.getMonth() + 1)+ '-';
    }

    dateNewFormat += today.getFullYear();
    
    var tommorowymd, tomdate,tommorowdate = new Date();
    tommorowdate.setDate(tommorowdate.getDate()+1);
    tomdate = tommorowdate.getDate();
    if (tomdate.toString().length == 2) {

    	tommorowymd = tomdate+ '-';
    }
    else {
    	tommorowymd = '0' + tomdate+ '-';
    }
    tommonth = (tommorowdate.getMonth() + 1);
    if (tommonth.toString().length == 2) {

    	tommorowymd += (tommorowdate.getMonth() + 1)+ '-';
    }
    else {
    	tommorowymd += '0' + (tommorowdate.getMonth() + 1)+ '-';
    }

   
 
    tommorowymd += tommorowdate.getFullYear(); 
    $('#entryDate').val(dateNewFormat);
 //   $('#effectDate').val(tommorowymd);
 
 var option = "<option disabled selected value=''>-Select-</option> <option value="+dateNewFormat+">"+dateNewFormat+"</option> <option value= "+tommorowymd+">"+tommorowymd+" </option>"
   // document.getElementById("d1").innerHTML = dateNewFormat;
   // document.getElementById("d1n").innerHTML = dateNewFormat;
   // document.getElementById("d2").innerHTML = tommorowymd;
    document.getElementById("effectDate").innerHTML = option;
   // $("#centerordpc").chosen();
   
     
     
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
				<h1 class="page-title">Jute Variety Grades Price for Commercial</h1>
			</div>
		 <div class="page-content fade-in-up">
				<div class="row">
					<div class="col-md-11">
						<div class="ibox">
							<div class="ibox-head">
								<!-- <div class="ibox-title">Basic form</div> -->
								<span id="msg"></span>
							</div>
							<div class="ibox-body">
							 
								<!-- <form  action="saveGradePriceOfCommercial.obj"  method="POST" name="myForm"  > -->
								<!-- <form id ="form123">  -->
								 
							<div class="row">
							 
							 
									<div class="col-sm-4 form-group">
										 
									 <fieldset id="radioselect">
										<label style= font-size: 15px;"><input type="radio" id="radioselect" name="radioselect" value="Region" checked="checked" style="height: 18px;width: 18px;vertical-align: middle;margin-inline: 5px;">Region</label>
										 
										<label style="margin-inline: 20px;font-size: 15px;"><input type="radio"  id="radioselect" name="radioselect" value="DPC" style="height: 18px;width: 18px;vertical-align: middle;margin-inline: 5px;">DPC</label>
										 
										 </fieldset>
									</div>
									<div class="col-sm-4 form-group">
										
									</div>
									<div class="col-sm-4 form-group">
										
									</div>
							</div>
										
										<div class="row">
										
										<div class="col-sm-4 form-group">
											<label id="zoneLabel" class="required">Zone</label> 
											<%
												List<ZoneModel> zoneList = (List<ZoneModel>) request.getAttribute("zoneList");
											%>
											<select class="form-control" name="zone" id="zone">
												<option disabled selected value>-Select-</option>
												<%
													for (ZoneModel zoneLists : zoneList) {
												%>
													<option value="<%=zoneLists.getZonecode()%>"><%=zoneLists.getZonename()%></option>
												<%
													}
												%>
											</select>
											
										</div>
										<div class="col-sm-4 form-group">
											<label id="regionLabel" class="required">Region</label>&nbsp;&nbsp;&nbsp;
											<!-- <input class="form-control" type="text" name="region" placeholder="Region" required> -->
											<select class="form-control" name="region" id="region">
												<option disabled selected value>-Select-</option>
											</select>
										</div>
										<div class="col-sm-4 form-group" id="dpc_div">
											<label id="dpclabel" class="required">DPC</label> &nbsp;&nbsp;&nbsp;
											  <div class="form-control" id="dpc_div"></div> 
											
											<!-- <input class="form-control" name="centerordpc" type="number" placeholder="DPC/Center" required> -->
											<!-- <select     class="chosen-select"  data-placeholder="Choose DPC..."   multiple tabindex="4" id="centerordpc" name="centerordpc">
												<option  value="0">-Select-</option>
											</select> -->
											
										</div>
									</div>
									<div class="row"> 
                                         <div class="col-sm-4 form-group">
                                            <label>Date of Entry</label>
                                            <input type="text" name="entryDate" class="form-control"  id="entryDate"  readonly="true"> 
											 
                                        </div>
                                         <div class="col-sm-4 form-group">
                                            <label>Date of Effect</label>
                                           <!--  <input type="text" name="effectDate" class="form-control"  id="effectDate"  readonly="true">  -->
                                            <select name="effectDate" id="effectDate" class="form-control" required>
                                        	 
                                        	 
                                        	</select>
											 
                                        </div>
                                        <div class="col-sm-4 form-group">
                                            <label>Ceiling Quantity(in Qtls)</label> <span class="text-danger">* </span>
                                            <input type="number" class="form-control" required name="cqty" id="cqty" step=".01" min="0"> 
											 
                                        </div>
                                         
                                        
                                        </div>
									<div class="row">
									<!-- <div class="col-sm-4 form-group">
                                            <label>Ceiling Price</label> <span class="text-danger">* </span>
                                            <input type="number" class="form-control" required name="cprice" id="cprice" step=".01" min="0"> 
											 
                                        </div> -->
										<div class="col-sm-4 form-group">
											<label>Jute Variety</label> <span class="text-danger">* </span>
                                        	<select name="jutevariety" id="jutevariety" class="form-control" required>
                                        	<option value="0">Select</option>
                                        	<option value="Bimli">Bimli</option>
                                        	<option value="Mesta">Mesta</option>
                                        	<option value="Tossa">Tossa</option>
                                        	<option value="White">White</option>
                                        	</select>
										</div>
										
										 <div class="col-sm-4 form-group">
                                            <label>Crop Year</label>  <span class="text-danger">* </span>
											<select name="cropyr" id="cropyr" class="form-control" required>
												<option value="0">-Select-</option>
												<option value="2021-2022">2021-2022</option>
												<option value="2022-2023">2022-2023</option>
											</select>
                                        </div>
										
								
									 
									<div class="col-sm-4 form-group">
                                            <label id="lblName"></label>
                                           <div  id="form2"></div>
									
									</div>
									 
                                    </div>
                                    <div class="row">
                                    <div class="col-sm-4 form-group">
                                     
                                 <span id="error"></span>
                                     
                                      </div>
                                    </div>
                                        
                                        
                                        
                                     	
                                    
<!-- 									<div class="row">
									<div class="form-group">
										<button class="btn btn-default" type="submit">Submit</button>
									</div>
									</div> -->
														<div class="row">
								<div class="col-sm-4 form-group">
								 <input type="submit" value="Submit"class="btn btn-primary" id="submit">
									<!-- <input class="btn btn-primary" type="submit" id="enq_submit">Submit</button> -->
								</div>
							</div>
						<!--  </form>   -->
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
		$("#zone").on("change", function() {
			//alert("zone");
			var id = (this.value);
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
		//	alert("region");
			var id = (this.value);	
			var html = "<label id='dpclabel' class='required'>DPC</label> <select data-placeholder='Choose DPC...' class='chosen-select'  multiple tabindex='4' id = 'centerordpc'>";
			if(id!=null){
				$.ajax({
					type:"GET",
					url:"findDpcByRegion.obj",
					data:{"id":id},
					success:function(result){
		 				   var data= jQuery.parseJSON(result);
		 				//   alert(data);
	 	 					  html += "";
		 				     for (var i = 0; i< data.length; i++){
		 				   	   
		 					 html += "<option value=" +data[i].split("-")[0]+">"+data[i].split("-")[1]+"</option>"
		 				  } 
		 				$("#dpc_div").html(html);
		 				$("#centerordpc").chosen();
		 				$("#centerordpc").addClass("chosen-select");
		 				 var selected_val =$('input[name="radioselect"]:checked').val(); 
		 			     
		 			  //    alert ( selected_val );
		 			    if(selected_val==='Region')
		 			    	{
		 			    	 $('#centerordpc option').prop('selected', true);  
		 					 $('#centerordpc').trigger('chosen:updated');
		 			    	}
		 			    else
		 			    	{
		 			    	$('#centerordpc option:selected').removeAttr('selected');
		 			    	$('#centerordpc').trigger('chosen:updated');
		 			    	}
					}			
				});
			} 
		});
	</script>
		
	 
<script>
	$("#jutevariety").on("change", function() {
		//alert("variety");
		
		  $("#form2").empty();
		var basis_no;
			basis_no=2;
		 var variety = (this.value);
		 	 //alert("variety= "+variety+"  basis= "+basis_no);
		 	 if(variety==='0')
		 		 {
		 		$("#lblName").empty();
		 		 }
		 	 else
		  {  
			 $.ajax({
				type:"GET",
				url:"findGradeOfMSP.obj",
				data: jQuery.param({ "variety": variety, "basis_no" : basis_no}) ,
				success:function(result){
					data = jQuery.parseJSON(result);
					count = data.length;
					//alert(count);
					$('#lblName').text('Enter Grade Price');
			        for (i=0;i<data.length;i++){
			        	$('<label/>').text(data[i]+" : ").appendTo('#form2');
			         	//$('<label/>').attr({text:data[i],  fontcolor:'red'}).appendTo('#form2');
			        	// $('<br/>').appendTo('#form2');
	 				    $('<input/>').attr({ type: 'text', id: 'grade'+i, name: 'test[]'+i, type: 'number' ,value:'0' , min:'0',oninput:'javascript: if (this.value.length > 6) this.value = this.value.slice(0, 6);'}).appendTo('#form2');
	 				    $('<br/>').appendTo('#form2');
	 				 
			        }} 
		
				     
				});
	          }
			 
			  
		
	});
	
	
	</script>
	<script>
 
	    $('#radioselect input[type=radio]').change(function(){
	      var selected_val = $(this).val();
	     
	    //  alert ( selected_val );
	    if(selected_val==='Region')
	    	{
	    	 $('#centerordpc option').prop('selected', true);  
			 $('#centerordpc').trigger('chosen:updated');
				 
	    	}
	    else
	    	{
	    	$('#centerordpc option').prop('selected', false);  
	    //	$('#centerordpc option:selected').removeAttr('selected');
		    	$('#centerordpc').trigger('chosen:updated');
	    	}
	     
	    //  $('#dpc_div').hide();
	
	      
	      })
	 
	</script>
	<script type="text/javascript">
	$(document).ready(function(){
		 $("#submit").click(function(){
			  //alert("test");
			  
			  var dpc = $("#centerordpc").chosen().val();
			  var zone = $("#zone").val();
			  var jutevariety = $("#jutevariety").val();
			  var region = $("#region").val();
			  var radio =$('input[name="radioselect"]:checked').val(); 
			  var cropyr = $("#cropyr").val();
			  var cqty = $("#cqty").val();
			 // var cprice = $("#cprice").val();
			  var effectDate = $("#effectDate").val();
			 // alert(effectDate);
			  var entryDate = $("#entryDate").val();
			  var grade0 = Number($("#grade0").val());
			  var grade1 = Number($("#grade1").val());
			  var grade2 = Number($("#grade2").val());
			  var grade3 = Number($("#grade3").val());
			  var grade4 = Number($("#grade4").val());
			  var grade5 = Number($("#grade5").val());
			  var grade6 = Number($("#grade6").val());
			  var grade7 = Number($("#grade7").val());
			  var grade8 = Number($("#grade8").val());
			 
			  var result = true;
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
			 
			  if(zone!=null && jutevariety!="0"&& region!=null && cropyr!="0"&& dpc!="" &&cqty !="" && result && effectDate !=null){
				  
				  dpc = dpc.toString();
				  if(isNaN(grade6))
					  {
					  grade6="0";
					  }
				  if(isNaN(grade8))
					  {
					  grade8="0";
					  }
				  if(isNaN(grade7))
				  {
				  grade7="0";
				  }
				  //alert(dpc);
					$.ajax({
						type:"POST",
						url:"saveGradePriceOfCommercial.obj",
						data:{"dpc":dpc ,"effectDate" :effectDate, "zone":zone,"jutevariety":jutevariety,"region":region,"radioselect":radio,"cropyr":cropyr,
							"cqty":cqty,"effectDate":effectDate,"entryDate":entryDate, "grade0":grade0,"grade1":grade1,"grade2":grade2,"grade3":grade3,
							"grade4":grade4,"grade5":grade5,"grade6":grade6,"grade7":grade7,"grade8":grade8,"cprice":"0"},
						success:function(result){
							//  location.reload(true);
							  $('html, body').animate({scrollTop: '0px'}, 0);
							 $("#msg").html("<div class=\"alert alert-success\"><b>Success !</b> Record saved successfully.</div>\r\n");
							 setTimeout(function () {
							      
							        location.reload(true);
							        $("#msg").html("<div class=\"alert alert-success\"><b>Success !</b> Record saved successfully.</div>\r\n");
							       
							      }, 1000); 
							
						}
		 	 				 
						
					});
				}
			  else
				  {
				  if(result){
				  alert("Fill the mandatory fields.");}
				  }
		    
		  });
		});
	</script>
	
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
	 
	
	
	<!-- <script src="assets/css/docsupport/jquery-3.2.1.min.js" type="text/javascript"></script> -->
  <script src="assets/css/chosen.jquery.js" type="text/javascript"></script>
  <script src="assets/css/docsupport/prism.js" type="text/javascript" charset="utf-8"></script>
  <script src="assets/css/docsupport/init.js" type="text/javascript" charset="utf-8"></script>
	
</html>
