<!DOCTYPE html>
<html lang="en">
<%@ page import="javax.servlet.http.HttpServletRequest" %>
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
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
<script src="https://code.jquery.com/ui/1.13.2/jquery-ui.js"></script>

<!-- PAGE LEVEL STYLES-->
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
                <h1 class="page-title">Daily Purchase Confirmation</h1>
            </div>
             <% 
            	String dpcCode;
            	dpcCode = (String)session.getAttribute("dpcId");
            	  String dpcCenter = (String) session.getAttribute("dpc_center");
            %>
            <div class="page-content fade-in-up">
                <div class="row">
                    <div class="col-md-11">
                        <div class="ibox">
                            <div class="ibox-head">
                            	<span>${msg}</span>
                                <!-- <div class="ibox-title">Basic form</div> -->
                            </div>
                            <div class="ibox-body">
                                <form action="dailyPurchaseMid.obj" method="POST" name="myForm" id="form" onsubmit="return validate()" autocomplete="off" >
                                    <div class="row">
                                        <div class="col-sm-4 form-group">
                                            <label>Form No.</label><span class="text-danger">* </span>&nbsp; <span id="errformno" name="errformno"
												class="text-danger"> </span>
                                            <input class="form-control" type="number" name="formno" id="formno" placeholder="Form Number" required oninput="javascript: if (this.value.length > 11) this.value = this.value.slice(0, 11);" min="0">
                                        </div>
                                        <div class="col-sm-4 form-group">
                                            <label>Date of purchase</label><span class="text-danger">* </span>&nbsp; <span id="errdatepurchase" name="errdatepurchase"
												class="text-danger"> </span>
                                            <input readonly class="form-control"  name="datepurchase" id="datepurchase" placeholder="Date of Purchase" min="0">
                                        </div>
                                        <div class="col-sm-4 form-group">
                                            <label>Bin No.</label><span class="text-danger">* </span>&nbsp; <span id="errbinno" name="errbinno"
												class="text-danger"  min="0"> </span>
											 <input class="form-control" name="binno" id="binno" type="number" placeholder="binno" onblur="binno_check()" oninput="javascript: if (this.value.length > 3) this.value = this.value.slice(0, 3);" required min="0">
                                      
                                        	</div> 
                                        	
                                    </div>
                                    
                                    <div class="row">
                                         <div class="col-sm-4 form-group">
                                            <label>Crop Year</label> <span class="text-danger">* </span>&nbsp; <span id="errcropyr" name="errcropyr"
												class="text-danger"> </span>
											<select name="cropyr" id="cropyr" class="form-control">
												<option Selected Disabled value="">-Select-</option>
											   
											</select>
                                        </div>
                                       
										<div class="col-sm-4 form-group">
											<label>Place of Purchase </label><span class="text-danger">* </span>&nbsp; <span id="errplaceofpurchase" name="errplaceofpurchase"
												class="text-danger"> </span>
											 <input class="form-control" name="placeofpurchase" id="placeofpurchase" type="hidden" placeholder="Place of Purchase" value="<%=dpcCode%>" required  min="0">
                                        <input class="form-control" type="text" 
												 placeholder="Place of Purhase"
												 value="<%=dpcCenter%>" readonly>
                                        </div>
                                        <div class="col-sm-4 form-group">
                                          <label>Basis</label><span class="text-danger">* </span>&nbsp; <span id="errbasis" name="errbasis"
												class="text-danger"  min="0"> </span>
                                        	 <select name="basis" id="basis" class="form-control">
                                        		<option value="">-Select-</option>
                                        		<option value="msp">MSP</option>
                                        		<option value="commercial">Commercial</option>
                                        	</select>
                                         </div>
                                    </div>

                                     <div class="row">
                                        <div class="col-sm-4 form-group">
											<label>Jute Variety</label><span class="text-danger">* </span>&nbsp; <span id="errjutevariety" name="errjutevariety"
												class="text-danger"> </span>
                                        	<select name="jutevariety" id="jutevariety" class="form-control">
                                        		<option value="">-Select-</option>
                                        	
                                        	</select>
										</div>
										<div class="col-sm-4 form-group">
                                             <label>Gross Quantity (Qtls.)</label><span class="text-danger">* </span>&nbsp; <span id="errgquantity" name="errgquantity"
												class="text-danger"  > </span>
                                        	<input class="form-control" name="gquantity" id="gquantity" type="number" placeholder="Gross Quantity" onkeyup="netQuantity()" required min="0">
                                        </div>
                                        <div class="col-sm-4 form-group">
                                            <label>Deduction Quantity (Qtls.)</label><span class="text-danger">* </span>&nbsp; <span id="errdeductionQuantity" name="errdeductionQuantity"  
												class="text-danger"> </span>
                                       		<input class="form-control" name="dquantity" id="deductionQuantity" type="number" placeholder="Deduction Quantity" onkeyup="netQuantity()" min="0">
                                        </div>
                                    </div>
                                    
                                    <div class="row">
                                        <div class="col-sm-4 form-group">
											<label>Net Quantity (Qtls.)</label><span class="text-danger">* </span>&nbsp; <span id="errnetquantity" name="errdeductionQuantity"
												class="text-danger"  min="0"> </span>
                                        	<input class="form-control" name="netquantity" id="netquantity" type="number" placeholder="Net Quantity" required readonly>
										</div>
										<div class="col-sm-4 form-group">
                                             <label>Fiber Value</label><span class="text-danger">* </span>&nbsp; <span id="errfibervalue" name="errdeductionQuantity"
												class="text-danger"> </span>
                                        	<input class="form-control" name="fibervalue" id="fibervalue" type="number" placeholder="Fiber Value" required  min="0">
                                        </div>
                                        <div class="col-sm-4 form-group">
                                             <label>Rate Slip Number</label><span class="text-danger">* </span>&nbsp; <span id="errrateslipno" name="errdeductionQuantity"
												class="text-danger"> </span>
                                        	<input class="form-control" name="rateslipno" id="rateslipno" type="number" placeholder="Rate Slip Number" required oninput="javascript: if (this.value.length > 5) this.value = this.value.slice(0, 5);" min='0'>
                                        </div>
                                    </div>
                                       <div class="row">
                                    <div class="col-sm-4 form-group">
                                            <label id="lblName"></label>
                                           <div  id="form2">
                                    
                                    	   </div>
                                        </div>
                                        </div>
                                        <div class="form-group"> 
                                   <input type="hidden" id="g0" name="g0" value="0">
                                    <input type="hidden" id="g1" name="g1" value="0">
                                     <input type="hidden" id="g2" name="g2" value="0">
                                      <input type="hidden" id="g3" name="g3" value="0">
                                       <input type="hidden" id="g4" name="g4" value="0">
                                        <input type="hidden" id="g5" name="g5" value="0">
                                         <input type="hidden" id="g6" name="g6" value="0">
                                          <input type="hidden" id="g7" name="g7" value="0">
                                          </div>
                                    <div class="form-group">
                                        <button class="btn btn-default" type="submit" id="submit">Submit</button>
                                         <button class="btn btn-default" type="button" id="dpc">dpc</button>
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
    <link rel="stylesheet" href="//code.jquery.com/ui/1.13.2/themes/base/jquery-ui.css">
<link rel="stylesheet" href="/resources/demos/style.css">
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
<script src="https://code.jquery.com/ui/1.13.2/jquery-ui.js"></script>

<script>
$( "#datepurchase" ).datepicker({ maxDate: '0' , minDate: '-1',dateFormat: 'dd-mm-yy'});
$(binno).attr('maxlength',3);
</script>

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
	function netQuantity() {
       var gQuantity = parseFloat(document.getElementById('gquantity').value);
       var dQuantity = parseFloat(document.getElementById('deductionQuantity').value);
       if (gQuantity == "")
    	   gQuantity = 0;
       if (dQuantity == "")
    	   dQuantity = 0;
		if(gQuantity>=dQuantity){
			document.getElementById("errdeductionQuantity").innerHTML ="";
   		   var result = gQuantity - dQuantity;
      		 if (result>=0) {
  				document.getElementById("netquantity").value = result;
       		}
      		
		}
		else if(gQuantity<dQuantity){
			document.getElementById("netquantity").value ="";
			document.getElementById("errdeductionQuantity").innerHTML = "Deduction Quantity can not be greater than Gross Quantity!";
		}
	}
	</script>
	<script>
	 function  binno_check(){
		 var basis;
			var jutevariety;
		 var binNo = document.getElementById("binno").value;
		$.ajax({
			type:"GET",
			url:"getbinno.obj",
			data: {"binno" :binNo}, 
			success:function(result){
				//alert(result);
				if(result != "null"){
				//	alert("yes")
					 $('#basis option[value=""]').remove();
					// $("p").off("click");
					const myArray= result.split("-");
	 					basis =myArray[0];
	 					jutevariety = myArray[1];
	 					var htm = "<option disabled selected value>-Select-</option>";
	 					htm = '<option value="'+jutevariety+'">'+jutevariety+"</option>"			
						$("#jutevariety").html(htm);
	 					
	 					
	 					
	 					var html = '<option value="'+basis+'">'+basis+"</option>"			
							$("#basis").html(html);
	 					
	 					var msp_no;
	 					if(basis=="msp" ||basis=="MSP"){
	 						 msp_no=1;
	 					
	 					}
	 					else if(basis=="commercial"){
	 						 msp_no=2;
	 					}
	 					$.ajax({
	 						type:"GET",
	 						url:"findGradeOnJuteVariety.obj",
	 						data: jQuery.param({ "variety": jutevariety, "basis_no" : msp_no}) ,
	 						success:function(result){
	 							data = jQuery.parseJSON(result);
	 							count = data.length;
	 							$('#lblName').text('Enter Grade Percentage');
	 							
	 							 if(jutevariety=='Bimli'){
	 								$('#form2 input').remove();
	 								$('#form2 label').remove();
	 								
	 							}else if(jutevariety=="Mesta"){
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
	 					       
	 			 				    $('<input/>').attr({ type: 'number', id: 'grade'+i, name: 'test[]',value:'0', min:'0'  }).appendTo('#form2');
	 			 				   
	 			 				   $('</div>').appendTo('#form2');
	 			 				   
	 			 				  
	 					        }
	 					       
	 					        
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
 					$("#form2").html("");
 					$("#jutevariety").html("-Select-");
				}
			
			}
		});
		}
		
	</script>
	<script>
	$("#basis").on("change", function() {
		var msp_no;
		var variety = (this.value);	
		if(variety=="msp")
			 msp_no=1;
		else if(variety=="commercial")
			 msp_no=2;
			$.ajax({
				type:"GET",
				url:"findJuteOnBasis.obj",
				data:{"msp_no":msp_no},
				success:function(result){
					
	 				   var data= jQuery.parseJSON(result);
 	 					 var html = "<option disabled selected value>-Select-</option>";
	 				     for (var i = 0; i< data.length; i++){
	 				    	 var sar = data[i]
	 				    	 
	 					 html += "<option value="+sar
	 					 +">"+data[i]+"</option>"			
	 				  } 
	 				$("#jutevariety").html(html);
				}			
			});
		 
	});
	</script>
	<script>
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
	 				    $('<input/>').attr({ type: 'text', id: 'grade'+i, name: 'test[]',value:'0', min:'0', required:'true' ,oninput:'javascript: if (this.value.length > 3) this.value = this.value.slice(0, 3);' }).appendTo('#form2');
	 				   
	 				   $('</div>').appendTo('#form2');
	 				    //$('<br/>').appendTo('#form2');
	 				  
			        }
			      
			         document.getElementById("count").value=count;  
			              
	 				 } 
		
			 
				});
			
	});
	
	
	</script>
	<script>
	$(document).ready(function(){
		 $("#dpc").click(function(){
		//alert("yes");
		$.ajax({
			type:"GET",
			url:"dpc2.obj",
			
			success:function(result){
				alert("record saved");
			}
			});
		});
	});
	</script>
	<script type="text/javascript">
	$(document).ready(function(){
		  $("#submit").click(function(){
			
			  var a=0;
			 var input = document.getElementsByName('test[]');
			 for(var i=0; i<input.length;i++){
				 a = input[i];
	         	  document.getElementById("g"+i).value = parseFloat(a.value);
			 }
		   
		  });
		});
	</script>
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>


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
	<!-- PAGE LEVEL SCRIPTS-->
</html>
