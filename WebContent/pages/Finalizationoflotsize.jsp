 <%@page import="com.mashape.unirest.http.options.Option"%>
<%@page import="java.util.List"%>
<%@page import="java.time.LocalDate"%>
<%@page import="java.time.LocalDateTime"%>
<%@page import="com.jci.model.RoDetailsModel"%>
<%@page import="com.jci.model.BatchIdentificationModel"%>
<%@page import="com.jci.model.PurchaseCenterModel"%>
<%@page import="com.jci.model.MillRecieptModel"%>
<%@page import="com.jci.model.EntryPaymentDetailsModel"%>
<%@page import="com.jci.model.MillreceiptDto"%>
<%@page import="java.time.format.DateTimeFormatter"%>
<!DOCTYPE html>
<html lang="en">

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
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<link rel="stylesheet" href="assets/css/docsupport/style.css">
  <link rel="stylesheet" href="assets/css/docsupport/prism.css">
  <link rel="stylesheet" href="assets/css/chosen.css">
  <script src="https://code.jquery.com/jquery-3.6.0.js"></script>
  <script src="https://code.jquery.com/ui/1.13.2/jquery-ui.js"></script>
<!-- CORE SCRIPTS-->
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

<body class="fixed-navbar"  onload="myFunction()" >
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
                <h1 class="page-title">Finalization of lot sizes and Reserve Sale Price</h1>
            </div>
            <div class="page-content fade-in-up">
                <div class="row">
                    <div class="col-md-11">
                        <div class="ibox">
                          <span>${msg}</span>
                            <div class="ibox-body">
                       <form action="saveFinalizationoflotsizesandReserveSalePrice.obj" method="POST">
                           <div class="child-checkbox" id="disableform">
                                 <div class="row">
                                 
                       	<div class="col-sm-4 form-group">
                                            <label>Crop Year</label>  <span class="text-danger">* </span>
											<select name="cropyr" id="cropyr" class="form-control" required="required" onchange="return validatejute()">
												<option value="">Select</option>
												</select>
                                        </div>
                                      	<div class="col-sm-4 form-group">
											<label id="regionLabel" class="required">Region</label>  &nbsp;&nbsp;&nbsp; 
											<span id="errRegion" name="errRegion" class="text-danger"> </span>
											<%
												List<RoDetailsModel> regionList = (List<RoDetailsModel>) request.getAttribute("regionList");
											%>
											<select class="form-control" name="region" id="region">
												<option disabled selected value>-Select-</option>
												<%
													for(RoDetailsModel regionLists : regionList) {
												%>
												<option value="<%=regionLists.getRocode()%>"><%=regionLists.getRoname()%></option>
												<%
													}
												%>
											</select>
											<!-- <input class="form-control" type="text" name="zone" placeholder="Zone"> -->
										</div>
							<div class="col-sm-4 form-group">
											<label id="dpclabel">DPC</label> <span class="text-danger">* </span>&nbsp;&nbsp;&nbsp;
											 <span id="errDPC" name="errDPC" class="text-danger"> </span>
											<select class="form-control" name="dpccode" id="dpccode" required>
												<option disabled selected value>-Select-</option>
											</select>
										
</div>
</div>
                                   <div class="row">
                                   
                                  <div class="col-sm-4 form-group">
											<label id="binLabel" class="required">BIN</label> 
											 &nbsp;&nbsp;&nbsp; 
											<span id="bin" name="bin" class="text-danger"> </span>
											<%
												List<BatchIdentificationModel> binList = (List<BatchIdentificationModel>) request.getAttribute("binList");
											%>
											<select class="form-control" name="bin" id="bin">
												<option disabled selected value>-Select-</option>
												<%
													for(BatchIdentificationModel binLists : binList) {
												%>
									           <option value="<%=binLists.getBinnumber()%>"><%=binLists.getBinnumber()%></option>
												<%
													}
												%>
											</select>
											<!-- <input class="form-control" type="text" name="zone" placeholder="Zone"> -->
										</div>
                                      <div class="col-sm-4 form-group">
												<label>Jute Variety</label> 
												<span class="text-danger">* </span>&nbsp; <span id="jutevariety" name="jutevariety" class="text-danger"> </span>
												<input class="form-control" name="jutevariety" id="jutevariety"  type="text"  placeholder="readonly"  value="" required >
										</div>
										
										 <div class="col-sm-4 form-group">
												<label>Lot Identification</label> 
												<span class="text-danger">* </span>&nbsp; <span id="lotidentification" name="lotidentification" class="text-danger"> </span>
												<input class="form-control" name="lotidentification" id="lotidentification" type="text"  value="" required>
										</div>
										</div>
                                    
                                      <div class="row">
                                   
                                         <div class="col-sm-4 form-group">
												<label>Lot Size</label> 
												<span class="text-danger">* </span>&nbsp; <span id="lotsize" name="lotsize" class="text-danger"> </span>
												<input class="form-control" name="lotsize" id="lotsize"  type="text"    value="" placeholder="readonly" required  >
										</div>
	                                     
	                                     <div class="col-sm-4 form-group">
												<label>Purchase Base Price</label> 
												<span class="text-danger">* </span>&nbsp; <span  name="purchasebaseprice" class="text-danger"> </span>
												<input class="form-control" name="purchasebaseprice" id="purchasebaseprice" type="text"  placeholder="readonly"  value="" required >
										</div>
	                                <div class="col-sm-4 form-group">
	                                             <label>Purchase Grade Differential</label>
	                                              <input class="form-control taxtbox" name="purchasegrade" id ="purchasegrade"  type="text" placeholder="readonly" value="" required >
	                                       </div>
	                                     
	                                </div>
                            <div class="row">
                                      
	                                       <div class="col-sm-4 form-group">
	                                             <label>Factor Head wise rate </label>
	                                             <input class="form-control taxtbox" name="factorhead"  id="factorhead"   type="text" placeholder="Factor Head"  value="">
	                                       </div>
	                                             <div class="col-sm-4 form-group">
                                                 <label class="required">Delivery Type</label> &nbsp;&nbsp;&nbsp; <span id="deliverytype" name="deliverytype" class="text-danger" > </span>
                                                 <select class="form-control" name="deliverytype" id="deliverytype"  required>
                                                 <option disabled selected value>-Select-</option>
                                                  <option value="Ex-Godown">Ex-Godown</option>
                                                  <option value="Mill delivery">Mill delivery</option>
                                                  </select>
                                                   </div>
										<div class="col-sm-4 form-group">
	                                             <label>Reserved Sale Price </label>
	                                             <input class="form-control taxtbox" name="reservedsaleprice"  id="reservedsaleprice"   type="text" placeholder="Reserved_Sale_Price"  value="">
	                                       </div>
										</div>
										<div class="row">
										<div class="col-sm-4 form-group">
										   <label>Sell Grade Differential </label>
	                                             <input class="form-control taxtbox" name="sellgradedifferential"  type="text" placeholder="sell_grade_differential" required>
	                                       </div>
	                                       <div class="col-sm-4 form-group">
										
									</div>
	                                       
	                                       <div class="col-sm-4 form-group">
										
									</div>
	                                       
	                                       </div>
	                                       
                             
                                    <div class="row"> 
                                                <div class="col-sm-12 form-group">
									             <input type="submit" value="Submit"class="btn btn-primary" id="submit">
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
		$("#DPC").on("change", function() {
			//	alert("region");
				var id = (this.value);	
				var html = "<label id='binLabel' class='required'>BIN</label> <select data-placeholder='Choose BIN...' class='chosen-select'  multiple tabindex='4' id = 'bin'>";
				if(id!=null){
					$.ajax({
						type:"GET",
						url:"findBinByDPC.obj",
						data:{"id":id},
						success:function(result){
			 				   var data= jQuery.parseJSON(result);
			 				//   alert(data);
		 	 					  html += "";
			 				     for (var i = 0; i< data.length; i++){
			 				   	   
			 					 html += "<option value=" +data[i].split("-")[0]+">"+data[i].split("-")[1]+"</option>"
			 				  } 
			 				$("#binLabel").html(html);
			 				$("#bin").chosen();
			 				$("#bin").addClass("chosen-select");
			 				 var selected_val =$('input[name="radioselect"]:checked').val(); 
			 			     
			 			  //    alert ( selected_val );
			 			    if(selected_val==='Region')
			 			    	{
			 			    	 $('#bin option').prop('selected', true);  
			 					 $('#bin').trigger('chosen:updated');
			 			    	}
			 			    else
			 			    	{
			 			    	$('#bin option:selected').removeAttr('selected');
			 			    	$('#bin').trigger('chosen:updated');
			 			    	}
						}			
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

	
</html>
