<!DOCTYPE html>
<html lang="en">
<%@page import="com.jci.model.MSPPriceCalculationModel "%>
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
    <link href="./assets/vendors/DataTables/datatables.min.css" rel="stylesheet" />
    <!-- THEME STYLES-->
    <link href="assets/css/main.min.css" rel="stylesheet" />
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
                <h1 class="page-title">Update MSP Grade Price</h1>
            </div>
            
            <%
            MSPPriceCalculationModel msppricecal = (MSPPriceCalculationModel )request.getAttribute("editGradesPrice");
			%>
	
            <div class="page-content fade-in-up">
                <div class="row">
                    <div class="col-md-11">
                        <div class="ibox">
                            <span>${msg}</span>
                            <div class="ibox-body">
                                <form action="updateGradesPrice.obj" method="POST">
                                    
 <div class="col-sm-4 form-group">
  <input class="form-control" name="id" id="id" type="hidden" value="<%=msppricecal.getmsp_id()%>" >

  </div>
        <div class="row">
 <div class="col-sm-4 form-group">
                                   <label>Jute Variety</label> <span class="text-danger">* </span>
                                    
											<span id="errJuteVariety" name="errJuteVariety" class="text-danger "> </span>
                                        	<select name="jutevariety" id="jutevariety" class="form-control"   onchange="return validatejute()" required>   
	                                    
												<option <%if(msppricecal.getJute_variety().equals("Bimli")){out.print("selected");} %> value="Bimli">Bimli</option>
												<option <%if(msppricecal.getJute_variety().equals("Mesta")){out.print("selected");} %> value="Mesta">Mesta</option>
												<option <%if(msppricecal.getJute_variety().equals("Tossa (New)")){out.print("selected");} %> value="Tossa (New)">Tossa (New)</option>
												
											<option <%if(msppricecal.getJute_variety().equals("White (New)")){out.print("selected");} %> value="White (New)">White (New)</option>
	                                        </select>
	                                        
	                                        
                                        </div>
                                        <div class="col-sm-4 form-group">
											<label>Crop Year</label>  <span class="text-danger">* </span>
											<select name="cropyr" id="cropyr" class="form-control" required="required" onchange="return validatejute()">
										
	
                                        		<option <%if(msppricecal.getCrop_yr().equals("2021-2022")){out.print("selected");} %> value="2021-2022">2021-2022</option>
												<option <%if(msppricecal.getCrop_yr().equals("2022-2023")){out.print("selected");} %> value="2022-2023">2022-2023</option>
											</select>
										</div>
										
										
										<div class="col-sm-4 form-group">
										
                                            <label id="lblName">Enter Grade Details</label>
                                            <div  id="form2">
										<div class="form-group"> 
                                   <input type="number" id="g0" name="g0" value="<%=msppricecal.getGrade1()%>">
                                    <input type="number" id="g1" name="g1" value="<%=msppricecal.getGrade2()%>">
                                     <input type="number" id="g2" name="g2" value="<%=msppricecal.getGrade3()%>">
                                      <input type=number id="g3" name="g3" value="<%=msppricecal.getGrade4()%>">
                                       <input type="number" id="g4" name="g4" value="<%=msppricecal.getGrade5()%>">
                                        <input type="number" id="g5" name="g5" value="<%=msppricecal.getGrade6()%>">
                                         <input type="number" id="g6" name="g6" value="<%=msppricecal.getGrade7()%>">
                                          <input type="number" id="g7" name="g7" value="<%=msppricecal.getGrade8()%>">
                                          </div>
                                           </div>
                                          </div>
										</div>
										
		  <div class="form-group col-sm-12">
                                        <button class="btn btn-default"type="submit">Submit</button>
                                        </div>
                                   </form>
                            </div>
                        </div>
                    </div>
                </div>
            
            <!-- END PAGE CONTENT-->
            <%@ include file="footer.jsp"%>
        </div>
    </div>
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
			       
	 				    $('<input/>').attr({ type: 'number', id: 'grade'+i, name: 'test[]' , min:'0' }).appendTo('#form2');
	 				   
	 				   $('</div>').appendTo('#form2');
	 				   
	 				  
			        }
			        
			              
	 				 } 
		
				     
				});
			 
			  
		
	});
	
	
	</script>
	
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
	
	  <!-- END PAGA BACKDROPS-->
    <!-- CORE PLUGINS-->
    <script src="./assets/vendors/jquery/dist/jquery.min.js" type="text/javascript"></script>
    <script src="./assets/vendors/popper.js/dist/umd/popper.min.js" type="text/javascript"></script>
    <script src="./assets/vendors/bootstrap/dist/js/bootstrap.min.js" type="text/javascript"></script>
    <script src="./assets/vendors/metisMenu/dist/metisMenu.min.js" type="text/javascript"></script>
    <script src="./assets/vendors/jquery-slimscroll/jquery.slimscroll.min.js" type="text/javascript"></script>
    <!-- PAGE LEVEL PLUGINS-->
    <script src="./assets/vendors/DataTables/datatables.min.js" type="text/javascript"></script>
    <!-- CORE SCRIPTS-->
    <script src="assets/js/app.min.js" type="text/javascript"></script>
    <!-- PAGE LEVEL SCRIPTS-->
 


										
</body>
</html>