<%@page import="java.util.List"%>
<!DOCTYPE html>
<html lang="en">

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
<style>
.container {
  display: grid;
  grid-template-columns: 0fr 9fr;
}

.farmerdetails {
    margin-bottom: 20px;
    margin-top: -50px;
    font-size: 20px;
    font-family: ui-monospace;
    color: darkblue;
}
 

</style>

<body class="fixed-navbar">
    <div class="page-wrapper">
        <!-- START HEADER  -->
        <%@ include file="header.jsp"%>
        <!-- END HEADER-->
        
        <!-- START SIDEBAR-->
        <%@ include file="sidebar.jsp"%>
        <!-- END SIDEBAR-->
        
        <div class="content-wrapper">
            <!-- START PAGE CONTENT-->
            <div class="page-heading">
            
                <h1 class="page-title"> Raw Jute Procurement and Payment</h1>
            </div>
            <% 
            	
            String dpcCenter = (String) session.getAttribute("dpc_center");
            String dpcid = (String) session.getAttribute("dpcId");
            	
            	
                List<String> farmerno= (List<String>) request.getAttribute("farmerNo");
                // out.println("== "+farmerno);
                
                
            %>
            <div class="page-content fade-in-up">
                <div class="row">
                    <div class="col-md-11">
                        <div class="ibox">
                            <span>${msg}</span>
                            <div class="ibox-body">
                            </div>
                         </div> 
                                 <form action="rawJuteProcurementAndPaymentMid.obj" method="POST" name="myForm" id="form" onsubmit="return validate()" 
                                 autocomplete="off" enctype="multipart/form-data">
                                 <div class="farmerdetails">
                                	 <span id="regFarmer" name="regFarmer"></span>
                                 	 <span  id="regMolile" name="regMolile"></span>
                                 	 <span  id="regAccNo" name="regAccNo"> </span>
                                 	 <input type="hidden" id="count" name="count">
                                 	 </div>
                                 
                                    
                                    	   
                                    <div class="row">
                                        <div class="col-sm-4 form-group">
                                            <label id="farmerNo" >Farmer Registration No.</label>
												<span class="text-danger">* </span>&nbsp; <span id="errfarmerregno" name="errfarmerregno"
												class="text-danger"> </span>
                                            <!-- <input class="form-control"  name="farmerregno" id="farmerregno" placeholder="Farmer Registration No." type="number" onkeyup="fRegNoVarify();deleteErrorMsg();" min="0" oninput="javascript: if (this.value.length > 11) this.value = this.value.slice(0, 11);"> -->
                                        
                                       <!--   <select name="farmerregno" id="farmerregno" class="form-control" > -->
                                         
                                        <select data-placeholder='Choose Farmer Reg no' class='form-control'    tabindex='2' id = "farmerregno" id = "farmerregno"  name = "farmerregno">
                                        		<option  value="0">-Select-</option>
                                        	<% 
                                        		for(int i=0; i< farmerno.size(); i++){
                                        	%>
                                        		<option value="<%=farmerno.get(i)%>"><%=farmerno.get(i)%></option>
                                        	<%
                                        		}
                                        	%>
                                        </select> 
                                       
                                        
                                        </div>
                                        <div class="col-sm-4 form-group">
                                            <label>Tally Slip No.</label>
                                            <span class="text-danger">* </span>&nbsp; <span id="dubtally" name="dubtally" class="text-danger"></span> &nbsp;&nbsp;&nbsp;<span id="errtallyslipno" name="errtallyslipno"
												class="text-danger"> </span><span id="errortallyslipno" name="errortallyslipno"
												class="text-danger"> </span>
                                            <input class="form-control" type="number" name="tallyslipno" id="tallyslipno" onblur="return length_tallySlip()" placeholder="Tally Slip No." onblur="return validateTallySlipNo();deleteErrorMsg();" min="0" oninput="javascript: if (this.value.length > 6) this.value = this.value.slice(0, 6);">
                                        </div>
                                        
                                        <div class="col-sm-4 form-group">
                                             <label>Place of Purchase</label>
                                             <span class="text-danger">* </span>&nbsp; <span id="errplaceofpurchase" name="errplaceofpurchase"
												class="text-danger"> </span>
                                        	 <input class="form-control"  type="text" placeholder="Place of Purchase" value="<%=dpcCenter%>" onkeyup="deleteErrorMsg()" oninput="javascript: if (this.value.length > 4) this.value = this.value.slice(0, 4);" readonly>
                                        	  <input class="form-control" name="placeofpurchase" id="placeofpurchase" type="hidden" value="<%=dpcid%>" >
                                        </div>
                                        
                                       
                                    </div>
                                    
                                    <div class="row">
                                    <!-- <div class="col-sm-4 form-group">
											<label>Date of Entry</label> 
											<span class="text-danger">* </span>&nbsp; <span id="errdateentry" name="errdateentry"
												class="text-danger"> </span>
											<input class="form-control"  name="dateentry" id="dateentry"  placeholder="Date of Entry" >
										</div> -->
                                     <div class="col-sm-4 form-group">
                                            <label>Crop Year</label> 
                                            <span class="text-danger">* </span>&nbsp; <span id="errcropyr" name="errcropyr"
												class="text-danger"> </span>
											<select name="cropyr" id="cropyr" class="form-control">
												<option value="">-Select-</option>
												
												</select>
                                        </div>
                                        <div class="col-sm-4 form-group">
											<label>Bin Number</label>
											<span class="text-danger">* </span>&nbsp; <span id="errbinno" name="errbinno"
												class="text-danger"> </span><span id="errbinNo" name="errbinNo"
												class="text-danger"> </span>
                                        	<input class="form-control" name="binno" id="binno"  type="number" placeholder="Bin Number" onblur="binno_check()" onkeyup="deleteErrorMsg()" min="0" oninput="javascript: if (this.value.length > 3) this.value = this.value.slice(0, 3);">
										</div>
                                    	
                                        	<div class="col-sm-4 form-group">
											<label>Rate Slip No.</label>
											<span class="text-danger">* </span>&nbsp; <span id="errrateslipno" name="errrateslipno"
												class="text-danger"> </span><span id="errorrateslipno" name="errorrateslipno"
												class="text-danger"> </span>
                                        	<input class="form-control" name="rateslipno" id="rateslipno" type="number" placeholder="Rate Slip No."  onblur="return length_rateSlip()" onkeyup="deleteErrorMsg()" min="0" oninput="javascript: if (this.value.length > 6) this.value = this.value.slice(0, 6);" >
										</div>
									</div>
                                   
                                    <div class="row">
                                   
										<div class="col-sm-4 form-group">
                                             <label>Basis</label>
                                             <span class="text-danger">* </span>&nbsp; <span id="errbasis" name="errbasis"
												class="text-danger"> </span>
                                        	 <select name="basis" id="basis" class="form-control" >
                                        		<option value="">-Select-</option>
                                        		<option value="msp">MSP</option>
                                        		<option value="commercial">Commercial</option>
                                        	</select>
                                        	</div> 
                                     <div class="col-sm-4 form-group">
											<label>Date of Purchase</label> 
											<span class="text-danger">* </span>&nbsp; <span id="errdatepurchase" name="errdatepurchase"
												class="text-danger"> </span>
											<input class="form-control" name="datepurchase" id="datepurchase"  placeholder="dd-mm-yyyy" value="" readonly>
										</div>
                                         
                                        <div class="col-sm-4 form-group">
											<label>Jute Variety</label>
											<span class="text-danger">* </span>&nbsp; <span id="errjutevariety" name="errjutevariety"
												class="text-danger"> </span>
                                        	<select name="jutevariety" id="jutevariety" class="form-control" >
                                        		<option value="">-Select-</option>
                                        	
                                        	</select>
										</div>
                                    </div>   
                                    <div class="row">
                                    
										
                                    	 <div class="col-sm-4 form-group">
                                             <label>Gross Quantity (in Kgs.)</label>
                                             <span class="text-danger">* </span>&nbsp; <span id="errgquantity" name="errgquantity"
												class="text-danger"> </span>
                                        	 <input class="form-control" id="gquantity" name="gquantity"  placeholder="Gross Quantity (in Kgs.)" step="0.01" onkeyup="netQuantity();deleteErrorMsg();"  type="number" min="0" >
                                        </div>
                                        <div class="col-sm-4 form-group">
                                             <label>Deduction Quantity (in Kgs.)</label> 
                                             <span class="text-danger">* </span>&nbsp; <span id="errdeductionQuantity" name="errdeductionQuantity"
												class="text-danger"> </span>
											<input class="form-control" id="deductionQuantity" name="deductionQuantity" step="0.01" placeholder="Deduction Quantity (in Kgs.)"  onkeyup="netQuantity();"  type="number" min="0">
                                        </div>
                                        <div class="col-sm-4 form-group">
                                             <label>Net Quantity (in Kgs.)</label>  
        									<span class="text-danger">* </span>&nbsp; <span id="errnetquantity" name="errnetquantity "
												class="text-danger"> </span>
											<input class="form-control" id="netquantity" name="netquantity" type="number" placeholder="Net Quantity (in Kgs.)"  readonly onkeyup="deleteErrorMsg()">
                                        </div>
                                    </div>
                                    
                                     <div class="row">
                                     
                                     	<div class="col-sm-4 form-group">
                                             <label>Garsat Rate (Rs./Qtls.)</label>
                                             <span class="text-danger">* </span>&nbsp; <span id="errgarsatRate" name="errgarsatRate"
												class="text-danger"> </span>
                                        	 <input class="form-control" name="garsatRate" id="garsatRate" type="number"  placeholder="Garsat Rate (Rs./Qtls.)"  readonly="true" onkeyup="deleteErrorMsg()" min="0">
                                        </div>
                                        <div class="col-sm-4 form-group">
											<label class="required">Varification Slip (330kb-1MB)</label><span class="text-danger">* </span>&nbsp; 
											<span id="errtallySlipdoc" name="errtallySlipdoc" class="text-danger"> </span>
													 <img id="imgPreview"  />
												  <input class="form-control" required
												name="tallySlipdoc" type="file"
												placeholder="Varification Slip" id="tallySlipdoc" onchange="deleteErrorMsg()">
										</div>
                                         <div class="col-sm-4 form-group">
                                         <div id="amt">
                                             <label >Amount Payable</label> 
                                             <span class="text-danger">* </span>&nbsp; <span id="erramountPayable" name="erramountPayable" onkeyup="deleteErrorMsg()"
												class="text-danger"> </span>
											<input class="form-control" name="amountPayable" id="amountPayable" type="number" placeholder="Amount Payable" readonly="true" onkeyup="deleteErrorMsg()">
                                        </div>
                                        </div>
                                               <div class="col-sm-4 form-group">
                                        <div id="tdd">
                                             <label >TD5 base price</label> 
                                             <span class="text-danger">* </span>&nbsp; <span id="errTD5baseprice" name="errTD5baseprice" onkeyup="deleteErrorMsg()"
												class="text-danger"> </span>
											<input class="form-control" name="tdbaseprice" id="tdbaseprice" type="number" placeholder="TD5 base price"  onkeyup="deleteErrorMsg()" min="0" >
                                        </div>
                                    	
                                    </div>
                 <div class="col-sm-12 form-group">
                                            <label id="lblName"></label>
                                           <div  id="form2">
                                    
                                    	   </div>                   
                                    <div class="row">
                                   
                                     	
                                        </div>
                                       
                                     	
                                    </div>
                                   
                                  <div class="form-group"> 
                                    <button class="btn btn-primary" type="button"    id = "calc">Calculate</button>
                                     <button class="btn btn-primary" type="submit" id="button">Submit</button>
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
                                
                            </div>
                            </form>
                        </div>
                    </div>
                    
                </div>
            </div>
            <!-- END PAGE CONTENT-->
            <%@ include file="footer.jsp"%>
        </div>
    
    <div class="sidenav-backdrop backdrop"></div>	
	

    
    <!-- PAGE LEVEL PLUGINS-->
    <!-- CORE SCRIPTS-->
    <script src="assets/js/app.min.js" type="text/javascript"></script>
    <!-- PAGE LEVEL SCRIPTS-->
</body>
<script>
 $(document).ready(function(){
	var	html = "<option selected disabled>-select-</option>";
		var today = new Date();
		var cropyr = today.getFullYear();
		var month = parseInt(today.getMonth()) + 1 ;
		var date = parseInt(today.getDate());
		var time = today.getHours() + ":" + today.getMinutes() + ":" + today.getSeconds();
		if(date ==  1 && month == 7 && parseInt(today.getHours()) >= 0 && parseInt(today.getMinutes()) >= 0 && parseInt(today.getSeconds()) > 0){
		
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
	$('#amountPayable').on('change', function() {
		
	    var amountPayable = document.getElementById('amountPayable').value;
	    
	    amountPayable = parseFloat(amountPayable).toFixed(2);
	     $('input[name=amountPayable').val(amountPayable);
	})
	</script>
	
	<script>
	$('#garsatRate').on('change', function() {
		
	    var garsatRate = document.getElementById('garsatRate').value;
	    
	     garsatRate = parseFloat(garsatRate).toFixed(2);
	     $('input[name=garsatRate').val(garsatRate);
	})
	</script>
	
	
	<script>
	$('#deductionQuantity').on('change', function() {
		
	    var deductionQuantity = document.getElementById('deductionQuantity').value;
	    
	     deductionQuantity = parseFloat(deductionQuantity).toFixed(2);
	     $('input[name=deductionQuantity').val(deductionQuantity);
	     var netquantity = document.getElementById('netquantity').value;
		    
		     netquantity = parseFloat(netquantity).toFixed(2);
		     $('input[name=netquantity').val(netquantity);
	})
	</script>
	
	<script>
	$('#gquantity').on('change', function() {
		
	    var gquantity = document.getElementById('gquantity').value;
	    
	    var gquantity = parseFloat(gquantity).toFixed(2);
	     $('input[name=gquantity').val(gquantity);
	     var netquantity = document.getElementById('netquantity').value;
		    
		    var netquantity = parseFloat(netquantity).toFixed(2);
		     $('input[name=netquantity').val(netquantity);
	})
	</script>
	
	
	
	<script>
    function allow_alphabets(element){
        let textInput = element.value;
        textInput = textInput.replace(/[^A-Za-z ]*$/gm, ""); 
        element.value = textInput;
    }
</script>
	  <script>
	function netQuantity() {
       var gQuantity = parseFloat(document.getElementById('gquantity').value);
       var dQuantity = parseFloat(document.getElementById('deductionQuantity').value);
        if (gQuantity == "")
    	   gQuantity = 0;
       if (dQuantity == "")
    	   dQuantity = 0; 
		if(gQuantity>dQuantity){
			document.getElementById("errdeductionQuantity").innerHTML ="";
   		   var result = gQuantity - dQuantity;
      		 if (result>=0) {
  			//	document.getElementById("netquantity").value = Math.round(((result + Number.EPSILON) * 100) / 100);
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
	function length_rateSlip(){
		var lengthr= $("#rateslipno").val();
		if(lengthr.length< 3) {
			 document.getElementById("errorrateslipno").innerHTML = "Rate Slip Number should be between 3-6 digits!";
			 $("#errorrateslipno").show();
			  return false;
		}
		else if(lengthr.length >=3 || lengthr.length <= 6)  {
	   			  $("#errorrateslipno").hide();
		}
	}
	
	</script>
	<script>
	function length_tallySlip(){
		var lengthr= $("#tallyslipno").val();
		if(lengthr.length< 3) {
			 document.getElementById("errortallyslipno").innerHTML = "Tally Slip Number should be between 3-6 digits!";
			 $("#errortallyslipno").show();
			  return false;
		}
		else if(lengthr.length >=3 || lengthr.length <= 6)  {
	   			  $("#errortallyslipno").hide();
		}
	}
	
	</script>
	<script type="text/javascript">
	$(document).ready(function(){
		  $('#farmerregno').on('change', function(evt, params) {
			  var farmerNo = $("#farmerregno").chosen().val().toString();
			  if(farmerNo.length==11){
		        	 $.ajax({
		 				type:"GET",
		 			url:"validateFarmer.obj",
		 			data:{"farmerNo":farmerNo},
		 				success:function(result){
		 					if(result=="[]"){
		 						alert("Please Enter Correct Registartion Number");
		 					}
		 					else{
		 						var data= jQuery.parseJSON(result);
			 					for (var i = 0; i< data.length; i++){
				 					document.getElementById("regFarmer").innerHTML = "<b>Farmer's Name:-</b>   "+data[i].split("-")[0]+"<br>";
				 					 
				 					document.getElementById("regMolile").innerHTML = "<b>Mobile No.:-</b>  "+data[i].split("-")[1]+"<br>";
				 					
				 					document.getElementById("regAccNo").innerHTML = "<b>Account No.:-</b>  "+data[i].split("-")[2]+"<br>"; 
				 				}
		 					}	 					
		 				}	
		 		  });
		        }
			   
			  });
		});
	</script>
	<script>
	function fRegNoVarify(){
		 var farmerNo = document.getElementById("farmerregno").value;
	        if(farmerNo.length==11){
	        	 $.ajax({
	 				type:"GET",
	 			url:"validateFarmer.obj",
	 			data:{"farmerNo":farmerNo},
	 				success:function(result){
	 					if(result=="[]"){
	 						alert("Please Enter Correct Registartion Number");
	 					}
	 					else{
	 						var data= jQuery.parseJSON(result);
		 					for (var i = 0; i< data.length; i++){
			 					document.getElementById("regFarmer").innerHTML = "<b>Farmer's Name:-</b>   "+data[i].split("-")[0]+"<br>";
			 					 
			 					document.getElementById("regMolile").innerHTML = "<b>Mobile No.:-</b>  "+data[i].split("-")[1]+"<br>";
			 					
			 					document.getElementById("regAccNo").innerHTML = "<b>Account No.:-</b>  "+data[i].split("-")[2]+"<br>"; 
			 				}
	 					}	 					
	 				}	
	 		  });
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
				if(result != "null" && result != "empty"){
					//alert("yes")
					 $('#basis option[value=""]').remove();
					 $("#errbinNo").html("");
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
	 						$ ("#amt").show();
	 						  $('#garsatRate').prop('readonly', true);
	 							$("#tdd").hide();
	 					}
	 					else if(basis=="commercial"){
	 						 msp_no=2;
	 						$("#tdd").show();
	 						$('#garsatRate').prop('readonly', false);
	 						$('#tdbaseprice').prop('readonly', true);
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

 					}
				else if (result == "null"){
					var htm = "<option disabled selected value>-Select-</option>";
 					htm += '<option value="msp">MSP</option>'
 					htm += '<option value="commercial">Commercial</option>'
					$("#basis").html(htm);
 					$("#form2").html("");
 					htm = '<option value="">-Select-</option>'			
					$("#jutevariety").html(htm);
 					
 					$("#errbinNo").html("Bin has been closed! ");
 					
				}
				else if (result == "empty"){
					var htm = "<option disabled selected value>-Select-</option>";
 					htm += '<option value="msp">MSP</option>'
 					htm += '<option value="commercial">Commercial</option>'
					$("#basis").html(htm);
 					$("#form2").html("");
 					htm = '<option value="">-Select-</option>'			
					$("#jutevariety").html(htm);
 					
 					$("#errbinNo").html("");
 					
				}
			
			
			}
		});
		}
		
	</script>
		<script>
	$("#basis").on("change", function() {
		var msp_no;
		var variety = (this.value);	
		if(variety=="msp"){
			 msp_no=1;
		
		  $ ("#amt").show();
		  $('#garsatRate').prop('readonly', true);
			$("#tdd").hide();
		}
		else if(variety=="commercial"){
			 msp_no=2;
		
			$("#tdd").show();
			$('#garsatRate').prop('readonly', false);
			$('#tdbaseprice').prop('readonly', true);
			 
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
	</script>
	<script>
	$("#jutevariety").on("change", function() {
		//alert("variety");
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
					$('#lblName').text('Enter Grade Percentage');
					
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
			       
	 				    $('<input/>').attr({ type: 'number', id: 'grade'+i, name: 'test[]',value:'0', min:'0'  }).appendTo('#form2');
	 				   
	 				   $('</div>').appendTo('#form2');
	 				   
	 				  
			        }
			       
			        
	 				 } 
		
			 
				});
			 
	});
	
	
	</script>
	<script>
	/* function dateformat(){
		const date = $("#datepurchase").val().split("-");
		alert(date[2]+"-"+date[1]+"-"+date[0]);
		$("#datepurchase").val(date[2]+"-"+date[1]+"-"+date[0])
	} */
	</script>
<script>
 $(document).ready(function(){
	//alert("doc ready");
	$("#farmerregno").chosen();
	$("#farmerregno").addClass("chosen-select");
	 
	  $("#tdd").hide();
  $("#calc").click(function(){
  
  
	
	 	var k=0;
		var a=0;
		var garsat=0.0;
		let garsatrate = 0.0;
		var gradePrice= 0.0;
		var qntl=0;
		
		var variety = document.getElementById("jutevariety").value;	
		if(variety == ""  || variety == null)
			alert("Please select a jute variety.")
			
		var basis = document.getElementById("basis").value;
		
		var cropyr = document.getElementById("cropyr").value;	
		if(cropyr == ""  || cropyr == null)
			alert("Please select a crop year.")
			
		var input = document.getElementsByName('test[]');
		
		var total=parseFloat(document.getElementById("netquantity").value);
		if(total == ""  || cropyr == null)
			alert("Please fill net quantity.")
		
		if(basis=="commercial"){
			
			basis_no=2;
			}
			else if(basis=="msp"){
				basis_no=1;
				 
			}

		for (var i = 0; i < input.length; i++) {
               a = input[i];

         	  document.getElementById("g"+i).value = parseFloat(a.value);
              k +=  parseFloat(a.value);
             count++;
          }
		if(parseInt(k)==100.00){
		     $.ajax({
				type:"GET",
				url:"findGradePriceJuteVariety.obj",
				data: jQuery.param({ "variety": variety, "basis_no": basis_no, "cropyr":cropyr}),
				success:function(result){
					data = jQuery.parseJSON(result);
					

						if(basis=="msp"){
							var gradefive = data[0][4];
							//console.log(gradefive);
							//console.log(data);
									for (var i = 0; i < input.length; i++) {
										for( var j=0;j < data.length;j++){
								 		 grade=data[j];

				            	 				var rate = parseFloat(grade[i]);

				          			 				var  gradesPersent= parseFloat(((input[i].value*rate)/100));
				          			 				garsatrate  = parseFloat(garsatrate)+ parseFloat(gradesPersent );
				          			 				console.log("garsatrate = "+garsatrate);
				          			 				console.log("gradesPersent = "+gradesPersent);
										}
										
								 	} 	
						 				var netPercent = parseFloat(total/100);
						 				console.log("netPercent = "+netPercent);
						 				netAmount=parseFloat(garsatrate * netPercent);
						 				
						 				document.getElementById("amountPayable").value = netAmount;
						 				//alert("garsatrate = "+garsatrate);
										document.getElementById("garsatRate").value = garsatrate;
							}
						
						else if(basis=="commercial"){
							var b= new Array();
							var addition=0;
							var  gradesPersent;
							var multi;
							 gradefive = data[0][4];
							//console.log("data  "+data);
							//console.log("gradefive  "+gradefive);
								for (var i = 0; i < input.length; i++) {
									for (var j = 0; j < data.length; j++){
										
										 gradesPersent= parseFloat((input[i].value) /100);
										
													
										if(data[0][i]!=0)
										{
											if(data[0][i] > gradefive){
												b[i]= parseFloat(data[0][i]-gradefive);
									     
									      		multi=(b[i] *  gradesPersent) ;
									      
									      		addition += multi;
									      	
												}
											else if(data[0][i] < gradefive){
												 b[i]= parseFloat(data[0][i]-gradefive);
										
												multi=(b[i] *  gradesPersent) ;
										
												addition += multi;
										
												      		
												}  
											}
										//console.log("addition  "+addition);
											}
										}
								var garsatt=document.getElementById("garsatRate").value;
						
							var td=	(garsatt - (addition));
							//console.log("td "+td);
							var netPercent = parseFloat(total/100);
			 				
			 				netAmount=parseFloat(garsatt * netPercent);
			 		
			 				document.getElementById("amountPayable").value = Math.round(netAmount,2);
								
								document.getElementById("tdbaseprice").value = Math.round(td,2);
								
								$('#tdbaseprice').prop('readonly', true);
						}
					}
		     }); 
		}
					else{
						alert("Summation of Estimated Grade Composition must be 100!");
					
					}
					
				 
 
  });
}); 
</script>

<link rel="stylesheet" href="//code.jquery.com/ui/1.13.2/themes/base/jquery-ui.css">
<link rel="stylesheet" href="/resources/demos/style.css">
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
<script src="https://code.jquery.com/ui/1.13.2/jquery-ui.js"></script>
<script>
$( "#datepurchase" ).datepicker({ dateFormat: 'dd-mm-yy'    });

</script>
	<script>
	
	function validateTallySlipNo(){
		
		var tally = document.getElementById("tallyslipno").value;
		var tallyLen = tally.length;
		  if(tallyLen >= 6){
			 
			  $.ajax({
					type:"GET",
					url:"validateTally.obj",
					data:{"tally":tally},
					success:function(result){
						console.log(result);
						//document.getElementById("accNoCheck").value = result;
						if(result == 'false'){
							document.getElementById("dubtally").innerHTML = "Duplicate Tally number";
							document.getElementById("button").disabled = true;
							return false;
						}else if(result == 'true'){
							document.getElementById("dubtally").innerHTML = "";
							document.getElementById("button").disabled = false;
							return true;
						}
					}	
			  });
		 }  
		  else
			  {
			  alert("Tally Slip No. should be of 6 digit");
			  }
	}
	
	</script>
	 	<script>
 function validate() {
	
	 let farmerregno = document.forms["myForm"]["farmerregno"].value;
	
	 
	 let tallyslipno = document.forms["myForm"]["tallyslipno"].value;
	
	 let placeofpurchase = document.forms["myForm"]["placeofpurchase"].value;
	
	// let dateentry = document.forms["myForm"]["dateentry"].value;
	 
	 let cropyr = document.forms["myForm"]["cropyr"].value;
	
	 let basis = document.forms["myForm"]["basis"].value;
	 
	 let rateslipno = document.forms["myForm"]["rateslipno"].value; 
	
	 let binno = document.forms["myForm"]["binno"].value;
	
	 let datepurchase = document.forms["myForm"]["datepurchase"].value; 
	// alert(datepurchase);
	
	// let formno = document.forms["myForm"]["formno"].value; 

	 let jutevariety = document.forms["myForm"]["jutevariety"].value;

	 let gquantity = document.forms["myForm"]["gquantity"].value;
	
	
	 let deductionQuantity = document.forms["myForm"]["deductionQuantity"].value;
	
	
	 let netquantity = document.forms["myForm"]["netquantity"].value; 
	
	 let garsatRate = document.forms["myForm"]["garsatRate"].value; 
	 
	 let slipImage = document.forms["myForm"]["tallySlipdoc"].value; 
	 
	 if(basis == "msp"){
	 let amountPayable = document.forms["myForm"]["amountPayable"].value; 
	 }
	 
	 if (farmerregno  == "") {
		
	    document.getElementById("errfarmerregno").innerHTML = "Farmer registration number can not be empty!";
	    document.forms["myForm"]["farmerregno"].focus();
	    return false;
	  }
	 else if(slipImage == ""){
		  document.getElementById("errtallySlipdoc").innerHTML = "Tally slip image can not be empty!";
		  document.forms["myForm"]["tallySlipdoc"].focus();
		  return false;
		  
	  }
	  else if(tallyslipno == ""){
		  document.getElementById("errtallyslipno").innerHTML = "Tally slip number can not be empty!";
		  document.forms["myForm"]["tallyslipno"].focus();
		  return false;
		  
	  }
	 /* else if(tallyslipno.length>5) {
			  document.getElementById("errtallyslipno").innerHTML = "Tally slip number can be greater than 5!";
			  return false;
		}  */
		
	  else if(placeofpurchase == ""){
		  document.getElementById("errplaceofpurchase").innerHTML = "Place of purchase can not be empty!";
		 
		  document.forms["myForm"]["placeofpurchase"].focus();
		  return false;
	  }
	/*   else if(dateentry == ""){
		  document.getElementById("errdateentry").innerHTML = "Date entry can not be empty!";
		
		  document.forms["myForm"]["dateentry"].focus();
		  return false;
	  } */
	  else if(cropyr == ""){
		  document.getElementById("errcropyr").innerHTML = "Crop year can not be empty!";
		  
		  document.forms["myForm"]["cropyr"].focus();
		  return false;
	  }

	  else if(basis == ""){
		  document.getElementById("errbasis").innerHTML = "Basis can not be empty!";
		 
		  document.forms["myForm"]["basis"].focus();
		  return false;
	  }
	  else if(rateslipno == ""){
		  document.getElementById("errrateslipno").innerHTML = "Rate Slip Number Type can not be empty!";
		 
		  document.forms["myForm"]["rateslipno"].focus();
		  return false;
	  } 
	  else if(binno == ""){
		  document.getElementById("errbinno").innerHTML = "Bin Number can not be empty!";
		  
		  document.forms["myForm"]["binno"].focus();
		  return false;
	  }
	  else if(datepurchase == ""){
		  document.getElementById("errdatepurchase").innerHTML = "Date of Purchase can not be empty!";
		  document.forms["myForm"]["datepurchase"].focus();
		  return false;
	  }
	//  else if(formno == ""){
	//	  document.getElementById("errformno").innerHTML = "Form Number can not be empty!";
		  //alert("Land Holding (Bigha) must be filled out");
	//	  document.forms["myForm"]["formno"].focus();
	//	  return false;
	  //}
	  else if(jutevariety == ""){
		  document.getElementById("errjutevariety").innerHTML = "Jute Variety can not be empty!";
		  
		  document.forms["myForm"]["jutevariety"].focus();
		  return false;
	  }
	  else if(gquantity == ""){
		  document.getElementById("errgquantity").innerHTML = "Gross Quantity can not be empty!";
		 
		  document.forms["myForm"]["gquantity"].focus();
		  return false;
	  }
	  else if(deductionQuantity == ""){
		  document.getElementById("errdeductionQuantity").innerHTML = "Deduction Quantity can not be empty!";
		 
		  document.forms["myForm"]["deductionQuantity"].focus();
		  return false;
	  }
	  else if(netquantity == ""){
		  document.getElementById("errnetquantity").innerHTML = "Net Quantity can not be empty!";
		
		  document.forms["myForm"]["netquantity"].focus();
		  return false;
	  }
	   else if(garsatRate == ""){
		  document.getElementById("errgarsatRate").innerHTML = "Garsat Rate can not be empty!";
		 
		  return false;
	  } 
	   else if(basis == "msp" && amountPayable == ""){
		  document.getElementById("erramountPayable").innerHTML = "Amount Payable can not be empty!";
		 
		  return false;
	  } 
	 
}

</script>

	<script>
function deleteErrorMsg(){
	
        
	 let farmerregno = document.forms["myForm"]["farmerregno"].value;
        if(farmerregno.length>1){
               $("#errfarmerregno").hide();
        }
     let tallyslipno = document.forms["myForm"]["tallyslipno"].value;
        if(tallyslipno.length>1){
               $("#errtallyslipno").hide();
        }
     let placeofpurchase = document.forms["myForm"]["placeofpurchase"].value;
 		if(placeofpurchase.length>1){
   			  $("#errplaceofpurchase").hide();
		}
 	 /* let dateentry = document.forms["myForm"]["dateentry"].value;
 		if(dateentry.length>1){
  			  $("#errdateentry").hide();
		} */
 	 let cropyr = document.forms["myForm"]["cropyr"].value;
		if( cropyr.length>1){
   			  $("#errcropyr").hide();
		}
	 let basis = document.forms["myForm"]["basis"].value;
		if(basis.length>1){
  			  $("#errbasis").hide();
		}
	let rateslipno = document.forms["myForm"]["rateslipno"].value; 
		if(rateslipno.length>1){
   			 $("#errrateslipno").hide();
		} 
	let binno = document.forms["myForm"]["binno"].value;
		if(binno.length>1){
  			  $("#errbinno").hide();
		}

	let datepurchase = document.forms["myForm"]["datepurchase"].value; 
		if(datepurchase.length>1){
  			  $("#errdatepurchase").hide();
		}
		 let slipImage = document.forms["myForm"]["tallySlipdoc"].value;
		 if(slipImage.length>1){
 			  $("#errtallySlipdoc").hide();
		}
	//let formno = document.forms["myForm"]["formno"].value;  
	//	if(formno.length>1){
   	//		  $("#errformno").hide();
	//	}
	let jutevariety = document.forms["myForm"]["jutevariety"].value;
		if(jutevariety.length>1){
  			  $("#errjutevariety").hide();
		}
	let gquantity = document.forms["myForm"]["gquantity"].value;
 		if(gquantity.length>1){
	   		 $("#errgquantity").hide();
		}
 	/* let deductionQuantity = document.forms["myForm"]["deductionQuantity"].value;
 		if(deductionQuantity.length>1){
	  		  $("#errdeductionQuantity").hide();
		} */
 	let netquantity = document.forms["myForm"]["netquantity"].value; 
		 if(netquantity.length>1){
	  		  $("#errnetquantity").hide();
		}
	 let garsatRate = document.forms["myForm"]["garsatRate"].value;  
 		if(garsatRate.length>1){
		    $("#errgarsatRate").hide();
		}
 		if(basis == "msp"){
 	let amountPayable = document.forms["myForm"]["amountPayable"].value;
 		if(amountPayable.length>1){
	 	   $("#erramountPayable").hide();
		} 
 	}
}
        
</script>
	<script type="text/javascript">

	
		
    $('#tallySlipdoc').change(function(){
      const file = this.files[0];
      console.log(file);
      if (file){
        let reader = new FileReader();
        reader.onload = function(event){
          console.log(event.target.result);
          $('#imgPreview').attr('src', event.target.result);
          $('#imgPreview').attr('width', "150px");
        }
        reader.readAsDataURL(file);
      }
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
   
	<script src="assets/css/chosen.jquery.js" type="text/javascript"></script>
  <script src="assets/css/docsupport/prism.js" type="text/javascript" charset="utf-8"></script>
  <script src="assets/css/docsupport/init.js" type="text/javascript" charset="utf-8"></script> 

  <link rel="stylesheet" href="assets/css/docsupport/prism.css">
  <link rel="stylesheet" href="assets/css/chosen.css">
  
  
</html>
