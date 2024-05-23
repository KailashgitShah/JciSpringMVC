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
                <h1 class="page-title">Grades Combination</h1>
            </div>
            <div class="page-content fade-in-up">
                <div class="row">
                    <div class="col-md-11">
                        <div class="ibox">
                            <div class="ibox-head">
                                <!-- <div class="ibox-title">Basic form</div> -->
                                <span>${msg}</span>
                            </div>
                            <div class="ibox-body">
                                <form action="savegradesCombination.obj" method="POST">
                                
                                <div class ="row">
                                
                                <div class ="col-md-4 form-group">
                                <label>Basis</label>
                                <select name="basis" id="basis" class="form-control">
                                <option value = "0" selected disabled>-Select-</option>
                                <option value = "msp">MSP</option>
                                <option value = "commercial">Commercial</option>
                                </select>
                                <div class ="row">
                                <div class ="col-md-12 form-group">
                                </div>
 								</div>
 								<div class ="row">
                                <div class ="col-md-12 form-group">
                                </div>
 								</div>
 								<div class ="row">
                                <div class ="col-md-12 form-group">
                                </div>
 								</div>
 								<div class ="row">
                                <div class ="col-md-12 form-group">
                                </div>
 								</div>
                                 <div class ="row">
                                <div class ="col-md-12 form-group">
                                
									<button class="btn btn-default" type="button" id='addButton'>Add Label</button>
									<button class="btn btn-default" type="button" id='removeButton'>Remove Label</button>
									<button class="btn btn-default" type="submit" id='submit'>Submit</button>
 									</div>
 									</div>
                                </div>
                                   <div class="col-sm-4 form-group">
                                            <label>Crop Year</label> 
                                            <span class="text-danger">* </span>&nbsp; <span id="errcropyr" 
												class="text-danger"> </span>
											<select name="cropyr" id="cropyr" class="form-control">
												<option value="">-Select-</option>
												
											
											</select>
                                        </div>
                                        
                                  <div class= "col-md-4 form-group">
                             	  <div id='TextBoxesGroup'>
                                  <div id="TextBoxDiv1">
									<label> Label 1 : </label><input type='text' id='textbox1' name='textbox1' class="form-control" >
								  </div>
								  </div>
								  <div id='TextBoxesGroup2'>
                                  <div id="TextBoxDiv2">
									<input type='hidden' id='text1' name='text1' class="form-control" >
								  </div>
								  </div>
								  </div>
								  </div>
                                <input type ="hidden" id="counter" name="counter" value="" >
                                
                               
                               
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
<script type="text/javascript">

$(document).ready(function(){

    var counter = 2;

    $("#addButton").click(function () {

    if(counter>10){
            alert("You've reached max limit!");
            return false;
    }   

    var newTextBoxDiv = $(document.createElement('div'))
         .attr("id", 'TextBoxDiv' + counter);

    newTextBoxDiv.after().html('<label>Label '+ counter + ' : </label>'+
    '<input type="text" name="textbox' + counter + 
          '" id="textbox' + counter + '" value="" class="form-control" >');

    newTextBoxDiv.appendTo("#TextBoxesGroup");
    var count = counter;
  
	  document.getElementById("counter").value = count;
	
    counter++;
    
     });

     $("#removeButton").click(function () {
    if(counter==2){
          alert("No more textbox to remove");
          return false;
       }   
   
    counter--;
    document.getElementById("counter").value="1";
        $("#TextBoxDiv" + counter).remove();
        count = counter;
        document.getElementById("counter").value = count;

     });

    
  });
</script>
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
    <!-- PAGE LEVEL SCRIPTS-->
</body>
</html>


