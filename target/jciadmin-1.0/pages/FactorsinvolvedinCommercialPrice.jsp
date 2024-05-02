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
                <h1 class="page-title">Entry of Factors involved in Commercial Price</h1>
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
                       <form >  <!-- action="saveentryofpaymentinstrument.obj" method="POST"> -->
                           <div class="child-checkbox" id="disableform">
                                 <div class="row">
                                       <div class="col-sm-3 form-group">
	                                             <label>Identification No</label>
	                                             <input class="form-control taxtbox" id="identification" name="identification" min="0" type="text" placeholder="Identification No" required>
	                                       </div>
		                           </div> 
		                           <div class="row">           
                                        <div class="col-sm-3 form-group">
                                           <div id='TextBoxesGroup'> 
	                                             <label>Factor Head 1</label>
	                                             <input class="form-control taxtbox" id="factorhead1" name="factorhead1" min="0" type="text" placeholder="Factor Head" required>
	                                       </div>  
	                                   </div>
										
										 <div class="col-sm-3 form-group">
										     <div id='unitdiv'>
	                                            <label>Unit 1</label> 
												<select name="unit1" id="unit1" class="form-control taxtbox" required>
													<option value="">-Select-</option>
													<option value="perqtls">Per Qtls</option>
													<option value="perbale">Per Bale</option>
												</select>
	                                     </div>
                                      </div>
                                
								 <div class="col-sm-3 form-group">
								 <div id='Applicabilitydiv'>
									  <label>Applicability 1</label><span  id="apperror1" class = "text-danger"></span><br>
									  <input class="checkedvalue1" type="checkbox" id="applicable1" name="applicable1" value="Purchase price" onclick="onlyOne(this,this.id)">
									<label>Purchase price</label><br>
									<input class="checkedvalue1" type="checkbox" id="applicable1" name="applicable1" value=" Operation cost" onclick="onlyOne(this,this.id)">
									<label> Operation cost</label><br>
									<input class="checkedvalue1" type="checkbox" id="applicable1" name="applicable1" value="Transport Cost" onclick="onlyOne(this,this.id)">
									<label> Transport Cost</label><br>
                              
                              </div>
								</div>
									<div class="col-sm-3 form-group">
									 <div id='Statusdiv'>
									  <label>Status 1</label><span  id="sattuserr1" class = "text-danger"></span><br>
									  <input class="status1" type="checkbox" id="yes1" name="yes1" value="0" onclick="onlyOne(this,this.id)">
									<label> Yes</label><br>
									<input class="status1" type="checkbox" id="yes1" name="yes1" value="1" onclick="onlyOne(this,this.id)">
									<label> No</label><br>
									<label>&nbsp;</label><br>
									
                                     </div>
									</div>
									           
                                  </div>
                                    
                                        <div class="row"> 
                                                <div class="col-sm-12 form-group">
									             <input type="submit" value="Submit"class="btn btn-primary" id="submit">
									             <input type="button" value="Add More"class="btn btn-primary" id="addButton">
									            </div>
									          </div>	
                                <input type ="hidden" id="counter" name="counter" value="" >
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
    <script type="text/javascript">
    $(document).ready(function(){

    var counter = 2;

    $("#addButton").click(function () {

    var newTextBoxDiv = $(document.createElement('div'))
    .attr("id", 'TextBoxDiv' + counter);
    newTextBoxDiv.after().html('<label>&nbsp;</label><br>'+
    '<br>'+
    '<label>Factor Head '+ counter + ' : </label>'+
    '<input type="text" name="factorhead' + counter + 
    '" id="factorhead' + counter + '" value="" class="form-control" required>');
    newTextBoxDiv.appendTo("#TextBoxesGroup");
    
    
    var unit2 = $(document.createElement('div'))
    .attr("id", 'unit2' + counter);
    unit2.after().html('<label>&nbsp;</label><br>'+
     '<br>'+
     '<label>Unit '+ counter + ' : </label>'+
     '<select name="unit' + counter + 
     '" id="unit' + counter + '" value="" class="form-control" required>'+
     '<option value="">-Select-</option>'+	
     '<option value="perqtls">Per Qtls</option>'+
     '<option value="perbale">Per Bale</option>'+
     '</select>');
    unit2.appendTo("#unitdiv");
    
    
    var Applicability = $(document.createElement('div'))
    .attr("id", 'Applicability' + counter);
    
    Applicability.after().html(
     '<label>Applicability '+ counter + ' : </label><span  id="apperror' + counter + '" class = "text-danger"></span><br>'+
     '<input class="checkedvalue' + counter + '" type="checkbox" name="applicable' + counter + '" id="applicable' + counter + '" value="Purchase price" onclick="onlyOne(this,this.id)">'+
     '<label>&nbsp; Purchase price</label><br>'+
     '<input class="checkedvalue' + counter + '" type="checkbox" name="applicable' + counter + '" id="applicable' + counter + '" value="Operation cost" onclick="onlyOne(this,this.id)">'+
     '<label>&nbsp; Operation cost</label><br>'+
     '<input class="checkedvalue' + counter + '" type="checkbox" name="applicable' + counter + '" id="applicable' + counter + '" value="Transport Cost" onclick="onlyOne(this,this.id)">'+
     '<label>&nbsp; Transport Cost</label>'+
     '<label>&nbsp;&nbsp;</label>');
    
    Applicability.appendTo("#Applicabilitydiv");
    
    var Status = $(document.createElement('div'))
    .attr("id", 'Status' + counter);
    
    Status.after().html(
     '<label>Status '+ counter + ' : </label><span  id="sattuserr' + counter + '" class = "text-danger"></span><br>'+
     '<input class="status' + counter + '" type="checkbox" name="yes' + counter + '" id="yes' + counter + '" value="0" onclick="onlyOne(this,this.id)">'+
     '<label>&nbsp; Yes</label><br>'+
     '<input class="status' + counter + '" type="checkbox" name="yes' + counter + '" id="yes' + counter + '" value="1" onclick="onlyOne(this,this.id)">'+
     '<label>&nbsp; No</label><br>'+
     '<label>&nbsp;&nbsp;</label>');
    
    Status.appendTo("#Statusdiv");    
    
    var count = counter;
  
	  document.getElementById("counter").value = count;
    counter++;
   
    
     });
    
    
    $("#submit").click(function () {
 
    
   var identification = $("#identification").val();
   let Factor_Head = [];
   let Unit  = [];
   let Applicability  = [];
   let Status  = [];
   
   var checkedValue = $('.checkedvalue1:checked').val();
   
   for (let i = 1; i < counter; i++)
   {
	   var ver1 = document.getElementById("factorhead"+i).value;
	   var ver2 = document.getElementById("unit"+i).value; 
	   var ver3 = $('.checkedvalue'+i+':checked').val();
	   var ver4 = $('.status'+i+':checked').val();
	   if(typeof ver3 == "undefined")
	   {
		   document.getElementById("apperror"+i).innerHTML = " Required !";
		   return false;
	   }
	   if(typeof ver4 == "undefined")
	   {
		   document.getElementById("sattuserr"+i).innerHTML = " Required !";
		   return false;
	   }
	   Factor_Head.push(ver1);
	   Unit.push(ver2);
	   Applicability.push(ver3);
	   Status.push(ver4);
	 
	 }
   
	 $.ajax({
         type:'GET',
         url:'saveFactorCommercial.obj',
         data:{"Factor_Head":JSON.stringify(Factor_Head),"Unit":JSON.stringify(Unit),"Applicability":JSON.stringify(Applicability),"Status":JSON.stringify(Status),"identification":identification},
         success:function(result){
				alert("hello"+result);
 				 
			}	
         });
	   alert();
    });
    
  });
</script>


  <script type="text/javascript">  
    function onlyOne(checkbox,id) {
    var checkboxes = document.getElementsByName(id)
    checkboxes.forEach((item) => {
        if (item !== checkbox) item.checked = false;
       })
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