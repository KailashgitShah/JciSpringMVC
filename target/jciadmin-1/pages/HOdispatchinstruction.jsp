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
 <style>
.required:after {
	content: " *";
	color: red;
}
</style> 
</head>
<body class="fixed-navbar" onload="myFunction()">
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
                <h1 class="page-title">HO Dispatch Instruction</h1>
            </div>
            
            <% 
         // Author vishal
         
            %>
            <div class="page-content fade-in-up">
                <div class="row">
                    <div class="col-md-11">
                        <div class="ibox">
                          <span>${msg}</span>
                            <div class="ibox-body">
                       <form action="savehodispatch.obj" method="POST">
                           <div class="child-checkbox" id="disableform">
                                 <div class="row">
                                       <div class="col-sm-4 form-group">
	                                             <label>Full Contract No.</label>
	                                              <span class="text-danger">* </span>&nbsp; <span id="contractno" name="contractno" class="text-danger"> </span>
	                                        	 <select name="fullcontractno" id="fullcontractno" class="form-control taxtbox" required>
	                                        		<option value="">-Select-</option>
	                                        		<option value="12345">12345</option>
	                                        		<option value="1234567">1234567</option>
	                                        		<option value="19764567">19764567</option>
	                                        	</select>
                                        </div>
		                                       
                                        <div class="col-sm-4 form-group">
												<label>Contract Date</label> 
												<span class="text-danger">* </span>&nbsp; <span id="cdate" name="cdate" class="text-danger"> </span>
												<input class="form-control" name="contractdate" id="contractdate" type="date">
										</div>
										
										 <div class="col-sm-4 form-group">
	                                            <label>Crop Year</label> 
	                                            <span class="text-danger">* </span>&nbsp; <span id="errcropyr" name="errcropyr" class="text-danger"> </span>
												<select name="cropyear" id="cropyear" class="form-control taxtbox" required>
													<option value="">-Select-</option>
													<option value="2021-2022">2021-2022</option>
													<option value="2022-2023">2022-2023</option>
												</select>
	                                     </div>
                                 </div>
                                    
                                   <div class="row">
                                   
                                           <div class="col-sm-4 form-group">
	                                             <label>Contract Quantity </label>
	                                             <input class="form-control taxtbox" name="contractquantity" min="0" type="number" placeholder="Contract Quantity" required>
	                                       </div>
	                                     
	                                       <div class="col-sm-4 form-group">
	                                             <label>Variety-Grade Wise Quantity </label>
	                                             <input class="form-control taxtbox" name="gradewiseqty" min="0" type="number" placeholder="Variety-Grade Wise Quantity" required>
	                                       </div>
	                                       
	                                       <div class="col-sm-4 form-group">
	                                             <label>Regional Offices </label>
	                                             <input class="form-control taxtbox" name="regionaloffices" min="0" type="text" placeholder="Regional Offices " required>
	                                       </div>
	                                       
                                    </div>
                                    
                                     
                                        <div class="row">
                                        
                                           <div class="col-sm-4 form-group">
												<label>Last Date of Shipment</label> 
												<span class="text-danger">* </span>&nbsp; <span id="lastdate" name="lastdate" class="text-danger"> </span>
												<input class="form-control" name="lastdateofshipment" id="instdate" type="date">
										   </div>
                                   
                                           <div class="col-sm-4 form-group">
	                                             <label>Unique No.(DI no.)</label>
	                                             <input class="form-control taxtbox" name="uniqueno" min="0" type="number" placeholder="Unique No" required>
	                                       </div>
	                                     
	                                        <div class="col-sm-4 form-group">
												<label>Date (DI Date)</label> 
												<span class="text-danger">* </span>&nbsp; <span id="DIdate" name="DIdate" class="text-danger"> </span>
												<input class="form-control" name="dateofdi" id="instdate" type="date">
										   </div>
	                                       
                                    </div>
                                    <div class="row">
                                       
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
	                                             <label>Quantity</label>
	                                             <input class="form-control taxtbox" name="quantity" min="0" type="number" placeholder="Quantity" required>
	                                       </div>
	                                       
	                                       <div class="col-sm-4 form-group">
                                            <label id="lblName"></label>
                                           <div  id="form2"></div>
									
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
	 				    $('<input/>').attr({ type: 'text', id: 'grade'+i, name: 'gprice'+i, type: 'number' ,value:'0' , min:'0',oninput:'javascript: if (this.value.length > 6) this.value = this.value.slice(0, 6);'}).appendTo('#form2');
	 				    $('<br/>').appendTo('#form2');
	 				 
			        }} 
		
				     
				});
	          }
			 
			  
		
	});
	
	
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