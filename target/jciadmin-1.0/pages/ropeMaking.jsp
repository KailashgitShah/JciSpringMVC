<!DOCTYPE html>

<html lang="en">

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
    <script src="./assets/vendors/jquery/dist/jquery.min.js" type="text/javascript"></script>
    <script src="./assets/vendors/popper.js/dist/umd/popper.min.js" type="text/javascript"></script>
    <script src="./assets/vendors/bootstrap/dist/js/bootstrap.min.js" type="text/javascript"></script>
    <script src="./assets/vendors/metisMenu/dist/metisMenu.min.js" type="text/javascript"></script>
    <script src="./assets/vendors/jquery-slimscroll/jquery.slimscroll.min.js" type="text/javascript"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
     <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
	<!-- <script src="http://code.jquery.com/jquery-1.11.3.min.js"></script> --> 
    <!-- PLUGINS STYLES-->

    <!-- THEME STYLES-->

    <link href="assets/css/main.min.css" rel="stylesheet" />

    <!-- PAGE LEVEL STYLES-->

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

                <h1 class="page-title">Rope Making</h1>

            </div>

            <%

                  List<String> allDpcList = (List) request.getAttribute("allDpcList");

            %>

            <%

            String dpcCenter = (String) session.getAttribute("dpc_center");

            String dpcid = (String) session.getAttribute("dpcId");

          String region_id = (String) session.getAttribute("region");

            int refid2 = (int)session.getAttribute("refId");

            %>

           

            <div class="page-content fade-in-up">

                <div class="row">

                    <div class="col-md-11">

                        <div class="ibox">

                            <span>${msg}</span>

                            <div class="ibox-body">

                                <form action="saveRopeMakingMid.obj" method="POST">

                                    <div class="row">

                                        <!-- <div class="col-sm-4 form-group">

                                            <label>Report Date</label>

                                            <input class="form-control" type="date" name="datereport" placeholder="Report Date" required>

                                        </div> -->

     <div class="col-sm-4 form-group">

  <label>DPC Name</label>
	<select class="form-control" name="centerordpc" id="centerordpc">
				<option disabled selected value>-Select-</option>
							</select>
							
<!--  <input class="form-control"  type="text" placeholder="Place of Purchase" value="<%=dpcCenter%>" onkeyup="deleteErrorMsg()" oninput="javascript: if (this.value.length > 4) this.value = this.value.slice(0, 4);" readonly>-->

      <input class="form-control" name="dpcid" id="dpcid" type="hidden" value="<%=dpcid%>" >

      <input class="form-control" name="region_id" id="region_id" type="hidden" value="<%=region_id%>" >

       <input class="form-control" name="refid" id="refid" type="hidden" value=""<%=refid%>"" >

     
</div>
                   <div class="col-sm-4 form-group">

                       <label class="required">Crop Year</label>

                        <select name="cropyr" id="cropyr" class="form-control" required>

                        <option value="">-Select-</option>

						</select>
 
 </div>
                          <div class="col-sm-4 form-group">

                           <label class="required">Bin Number</label>
						<select class="form-control" name="binno" id="binno">
							<option disabled selected value>-Select-</option>
								</select>
			                         <!--  <input class="form-control" id="binno" name="binno" type="number" placeholder="Bin Number" required onkeyup="checkLen()" required>
-->
                                        </div>

                     

                                                                    

 

                                    </div>

                                   

                                    <div class="row">

                                       <%--  <div class="col-sm-4 form-group">

                                             <label>Place of activity</label>

                                               <select name="placeofactivity" id="placeofactivity" class="form-control">

                                              <%

                                                     String[] str;

                                                     for(int i=0; i<allDpcList.size() ; i++){

                                                            str = allDpcList.get(i).split("-");

                                                   %>

                                                     <option value="<%=str[0]%>"><%=str[1]%></option>

                                                   <%

                                                     }

                                                   %>             

                                             </select>

                                        </div> --%>

                                                                                                            <div class="col-sm-4 form-group">

                                            <label class="required">Basis</label>

                                            <select name="basis" id="basis" class="form-control" required>

                                                     <option value="">-Select-</option>

                                                     <option value="msp">MSP</option>

                                                     <option value="commercial">Commercial</option>

                                               </select>

                                        </div>

                                      

                                                                    

                                        <div class="col-sm-4 form-group">

                                             <label class="required">Jute Variety</label>

                                        <!-- <input class="form-control" name="jutevariety" type="text" placeholder="Jute Variety" required> -->

                                               <select name="jutevariety" id="jutevariety" class="form-control" required>

                                                   <option selected disabled>-Select-</option>        

                                               </select>

                                        </div>

                                        <div class="col-sm-4 form-group">

                                                                           <label class="required">Rope made</label>

                                              <input class="form-control" name="ropemade" id="ropemade" type="number" placeholder="Rope made" min="0" required onkeyup="ropeMadeLengthLen();calculateRope()">

                                                                     </div>

                                                      

                                    </div>

 

                                     <div class="row">

                                       

                                                                                  <div class="col-sm-4 form-group">

                                                                           <label class="required">Rope Used</label>

                                                                           <span id="errropeUsed" name="errropeUsed" class="text-danger"> </span>

                                              <input class="form-control" name="ropeUsed" id="ropeUsed" type="number" placeholder="Rope Used" min="0"  onkeyup="ropeUsedLengthLen();calculateRope()" required>

                                                                     </div>

                                                                     <div class="col-sm-4 form-group">

                                                                           <label class="required">Balance</label>

                                              <input class="form-control" name="balance" id="balance"  type="number" placeholder="Rope balance"  readonly>

                                                                     </div>

                                    </div>                                   

                                    <div class="form-group col-sm-12">

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
		}
		else{
			html += "<option value = '"+(cropyr - 2)+"-"+(cropyr - 1)+"'>"+(cropyr - 2)+"-"+(cropyr - 1)+"</option>";
			html += "<option value = '"+(cropyr - 1)+"-"+cropyr+"'>"+(cropyr - 1 )+"-"+cropyr+"</option>";
		}
		$("#cropyr").html(html);
	}); 
	

</script>
   

    

    <script>

       $("#basis").on("change", function() {

              var msp_no;

              var variety = (this.value);     

              if(variety=="msp"){

                     msp_no = 1;

              }

              else if(variety=="commercial"){

                     msp_no = 2;

              }

              $.ajax({

                     type:"GET",

                     url:"findJuteOnBasis.obj",

                     data:{"msp_no":msp_no},

                     success:function(result){

                             var data= jQuery.parseJSON(result);

                                         var html = "<option disabled selected value>-Select-</option>";

                               for (var i = 0; i< data.length; i++){

                                  var sar = data[i]

                                  html += "<option value="+sar+">"+data[i]+"</option>"                   

                            }

                           $("#jutevariety").html(html);

                     }                   

              });

       });

       </script>

       <script>

       function calculateRope(){

              var ropeMade = parseFloat(document.getElementById("ropemade").value);

              var ropeUsed = parseFloat(document.getElementById("ropeUsed").value);

              var balance = ropeMade - ropeUsed;

              if(balance >= 0){

                     document.getElementById("balance").value = balance;

            document.getElementById("errropeUsed").innerHTML = "";

              }

             

             

        else if (ropeUsed > ropeMade)

        {

            

               document.getElementById("balance").value ="";

               document.getElementById("errropeUsed").innerHTML = "Rope Used can not be greater than Rope made!";

               $("errropeUsed").show();

              

        }

        else{

             $("errropeUsed").hide();

        }

              return false;

       }

       </script>
<script>
	 //function  binno_check(){
		 $("#binno").on("change", function(){
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
					//alert("yes")
					 $('#basis option[value=""]').remove();
					
					const myArray= result.split("-");
	 					basis =myArray[0];
	 					jutevariety = myArray[1];
	 					var htm = "<option disabled selected value>-Select-</option>";
	 					htm = '<option value="'+jutevariety+'">'+jutevariety+"</option>"			
						$("#jutevariety").html(htm);
	 					if (basis == "commercial")
							 var basis_no = '2';
						else if (basis == "msp"||basis == "MSP")
							var basis_no = '1';
	 					console.log(basis_no);
	 					var html = '<option value="'+basis+'">'+basis+"</option>"			
							$("#basis").html(html);
	 					$.ajax({
							type : "GET",
							url : "findGradeOnJuteVariety.obj",
							data : jQuery.param({
								"variety" : jutevariety,
								"basis_no" : basis_no
							}),
							success : function(result) {
								
								var data = jQuery.parseJSON(result);
							//	alert(data);
								var html = "<option disabled selected value>-Select-</option>";
								for (var i = 0; i < data.length; i++) {
									var sar = data[i]
									html += "<option value="+sar+">"
											+ data[i] + "</option>"
								}
								$("#jute_grade").html(html);

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
				}
			
			}
		});
		});
		
	</script>
<script>
$("#cropyr").on("change", function() {
	var cropyr=document.getElementById("cropyr").value;
	  var dpcid=  document.getElementById("centerordpc").value;
	//alert(cropyr);
	 $.ajax({
		   type:"GET",
		   url:"findBinno.obj",
		   data:jQuery.param({"cropyr":cropyr, "dpcid":dpcid}),
		   success:function(result){
			   var data= jQuery.parseJSON(result);
			   var html = "<option disabled selected value>-Select-</option>";
			     for (var i = 0; i< data.length; i++){
			    	 
				 html += "<option value=" +data[i]+">"+data[i]+"</option>"
				// alert(data);
			   }
			   $("#binno").html(html);
		   
	   }
		   
	   }); 
});
</script>
<script>
$("#centerordpc").on("change", function() {
	var cropyr=document.getElementById("cropyr").value;
	  var dpcid=  document.getElementById("centerordpc").value;
	//alert(cropyr);
	 $.ajax({
		   type:"GET",
		   url:"findBinno.obj",
		   data:jQuery.param({"cropyr":cropyr, "dpcid":dpcid}),
		   success:function(result){
			   var data= jQuery.parseJSON(result);
			   var html = "<option disabled selected value>-Select-</option>";
			     for (var i = 0; i< data.length; i++){
			    	 
				 html += "<option value=" +data[i]+">"+data[i]+"</option>"
				// alert(data);
			   }
			   $("#binno").html(html);
		   
	   }
		   
	   }); 
});
</script>
             <script>

       $(document).ready(function(){
    	   var myVar = '<%= (String) session.getAttribute("region")%>';
    	
    	   
    	 //  alert(myVar);
    	
    	   $.ajax({
    		   type:"GET",
    		   url:"findDpcByRegion.obj",
    		   data:{"id":myVar},
    		   success:function(result){
    			   
    			   var data= jQuery.parseJSON(result);
    			   var html = "<option disabled selected value>-Select-</option>";
				     for (var i = 0; i< data.length; i++){
				    	 console.log(data[i].split("-")[0] +" "+ data[i].split("-")[1]);
					 html += "<option value=" +data[i].split("-")[0]+ ">"+data[i].split("-")[1]+"</option>"
    			   }
    			   $("#centerordpc").html(html);
    		   
    	   }
    		   
    	   });
    	   
    	  
       });
      
</script>


       <script>

       function checkLen(){

              var binnumber = document.getElementById("binno").value;

              if(binnumber.toString().length == 3){

                     // alert("hell");

                     $("#binno").prop("type", "text");

                     $("#binno").attr("maxlength", "3");

                     $("#binno").attr("minlength", "1");

              }

       }

      
       function ropeMadeLengthLen(){
    	  
              var binnumber = document.getElementById("ropemade").value;

              if(binnumber.toString().length == 2){

                     // alert("hell");

                     $("#ropemade").prop("type", "text");

                     $("#ropemade").attr("maxlength", "2");

                     $("#ropemade").attr("minlength", "1");

              }

       }

 

      

       function ropeUsedLengthLen(){

              var binnumber = document.getElementById("ropeUsed").value;

              if(binnumber.toString().length == 2){

                     // alert("hell");

                     $("#ropeUsed").prop("type", "text");

                     $("#ropeUsed").attr("maxlength", "2");

                     $("#ropeUsed").attr("minlength", "1");

              }

       }

 

       </script>

    <div class="sidenav-backdrop backdrop"></div>

    

    <!-- END PAGA BACKDROPS-->

    <!-- CORE PLUGINS-->

 

    <!-- PAGE LEVEL PLUGINS-->

    <!-- CORE SCRIPTS-->

    <script src="assets/js/app.min.js" type="text/javascript"></script>

    <!-- PAGE LEVEL SCRIPTS-->

</body>

</html>