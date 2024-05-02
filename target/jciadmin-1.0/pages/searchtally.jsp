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
<!-- 
<link rel="stylesheet" href="assets/css/docsupport/style.css">
  <link rel="stylesheet" href="assets/css/docsupport/prism.css">
  <link rel="stylesheet" href="assets/css/chosen.css">
  <script src="https://code.jquery.com/jquery-3.6.0.js"></script>
  <script src="https://code.jquery.com/ui/1.13.2/jquery-ui.js"></script> -->
  
 <!-- datatable -->
 
 	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
 <script src="js/jquery.min.js" type="text/javascript"></script>
<script src="js/jquery.dataTables.min.js" type="text/javascript"></script>
<script src="https://cdn.datatables.net/1.10.9/js/jquery.dataTables.min.js" type="text/javascript"></script>  
 <link rel="stylesheet" href="https://cdn.datatables.net/1.10.9/css/jquery.dataTables.min.css" />
 

<!-- PAGE LEVEL STYLES-->
<style>
.colorgreen {
  color: crimson;
 
}
.colorred {
  color: crimson;
  
}
.colormod {
  color: darkslateblue;

}
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
  .important {
  font-weight: bold;
  font-size: xx-large;
  color:#EFEFEF;
}
/* Center the loader */
.loader {
  position: absolute;
  left: 50%;
  top: 50%;
  z-index: 1;
  width: 50px;
  height: 50px;
  margin: 0 0 0 0;
  border: 3px solid #f3f3f3;
  border-radius: 50%;
  border-top: 3px solid red;
  -webkit-animation: spin 2s linear infinite;
  animation: spin 2s linear infinite;
}
.loaderWait {
  position: absolute;
  color: red;
  left: 50%;
  top: 50%;
  z-index: 1;
  width: 100%;
  height: 50px;
  margin: 0 0 0 0;
   
   
}

@-webkit-keyframes spin {
  0% { -webkit-transform: rotate(0deg); }
  100% { -webkit-transform: rotate(360deg); }
}

@keyframes spin {
  0% { transform: rotate(0deg); }
  100% { transform: rotate(360deg); }
}

/* Add animation to "page content" */
.animate-bottom {
  position: relative;
  -webkit-animation-name: animatebottom;
  -webkit-animation-duration: 1s;
  animation-name: animatebottom;
  animation-duration: 1s
}

@-webkit-keyframes animatebottom {
  from { bottom:-100px; opacity:0 } 
  to { bottom:0px; opacity:1 }
}

@keyframes animatebottom { 
  from{ bottom:-100px; opacity:0 } 
  to{ bottom:0; opacity:1 }
}


.overlay {
    background-color:#EFEFEF;
    position: fixed;
    width: 100%;
    height: 100%;
    z-index: 1000;
    top: 0px;
    left: 0px;
    opacity: .5; /* in FireFox */ 
    filter: alpha(opacity=50); /* in IE */
}

/* When the body has the loading class, we turn
   the scrollbar off with overflow:hidden */
div.loading .loader {
    overflow: hidden;   
}

/* Anytime the body has the loading class, our
   modal element will be visible */
div.loading .loader {
    display: block;
}
  
  input[type="radio"]{
    display: inline;
}
 
 
</style>

<script type="text/javascript">
 
	$(document).ready(function() {
		
		$("#myInput").keyup(function(event) {
		    if (event.keyCode === 13) {
		        $("#sBP").click();
		    }
		});

		$('#sBP').click(function() {
		//	alert("clicked");
			var tally = $('#myInput').val();
		//	alert(tally);
		if(tally){
			$("#myloader").show();
			$.get('talystatus.obj', {
				tally : tally,
			}, function(data) {
			//	alert(data);
			$("#myloader").hide();
				const myArr = JSON.parse(data);
				var datam = JSON.stringify(data);
			//	alert(myArr);
				 
				var KeyValueData = tableData(data);
	            var drawdata = { "data": KeyValueData };
	            table = $('#farmerVerific').DataTable({
	            
	                processing: true,
	                destroy: true,
	                autoWidth: false,
	                data: drawdata.data,
	                scrollY: 380,
	                scrollX: true,
	                paging: false,
	                ordering: false,
	                columnDefs: [{
				        defaultContent : "-",
				        targets : "_all"
				      }],
	                columns: [
	                	
	                    { 
	                    	"data": "tally",
							"className": "colormod"
					    },
						{ 
								"data": "status",
								"className": "colorgreen" 
						} 
	                ], 
	                order: [[0, "desc"]],
	                "fnRowCallback": function( nRow, aData, iDisplayIndex, iDisplayIndexFull ) {
				       
				      $('td', nRow).css('font-size', '15px')
				      $('td', nRow).css('text-align', 'center')
				    }
	            });
			} 
			);

			 
		}//*if condition
 
		});


	});

	
	
</script>

<script>

function tableData(result) {
	
    var datalist = new Array();
  //  alert(result);
    var data = jQuery.parseJSON(result);
 //   alert(data.length);
    for (var i = 0; i < data.length; i++) {
        var tally = data[i].tally;
        var status = data[i].status;
        
        
        

        datalist[i] = {
        "tally": tally, 
        "status": status
        };

    }
    return datalist;
}
</script>

<script type="text/javascript">

   $(window).ready(function () {
	   document.getElementById("myloader").style.display = "none";
	   document.getElementById("loaderWait").style.display = "none";
	  
   });
   $(document).ready(function () {
	    $('.rightpanel').css('display', 'block');
	});
</script>	
</head>

<div id = "myloader" class="loader"> </div>
 <div id = "loaderWait" class="loaderWait"><p ></br></br>Loading..Please Wait</p> </div>

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
				<h1 class="page-title">Tally Slip Status</h1>
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
										 
									<div class="row"> 
									
									<input type="text" id="myInput" onkeyup="" placeholder="400005896" title="Type in a name" 
				                      style="width: 65%;background: beige; height: 45px;">
				
				                    <button id = "sBP"  style="color: azure; margin-inline: 30px; background: green;">Get Tally Status</button>
                                         
                                     
								</div>
								
								<div class = "row">
								
								 <div class="table-responsive" style="margin-top: 20px;">                    
                                 <table id="farmerVerific" class="table table-striped table-bordered table-hover" cellspacing="0"  >
								<thead>
									<tr> 
										<th style="text-align: center;">Tally No</th>
										<th style="text-align: center;">Status</th>
										 
									</tr>
								</thead>
								<tbody>
								 
								 
								    <tr role="row" class="odd"> 
									<td></td>
									<td></td> 
									 
									</tr>
									 
									</tbody>
                        </table>
                </div>
								</div>
							</div>
						 
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
		 
	  
  <script src="assets/css/chosen.jquery.js" type="text/javascript"></script>
  <script src="assets/css/docsupport/prism.js" type="text/javascript" charset="utf-8"></script>
  <script src="assets/css/docsupport/init.js" type="text/javascript" charset="utf-8"></script>
 
    <div class="sidenav-backdrop backdrop"></div>
    
    <script src="./assets/vendors/jquery/dist/jquery.min.js" type="text/javascript"></script>
    <script src="./assets/vendors/popper.js/dist/umd/popper.min.js" type="text/javascript"></script>
    <script src="./assets/vendors/bootstrap/dist/js/bootstrap.min.js" type="text/javascript"></script>
    <script src="./assets/vendors/metisMenu/dist/metisMenu.min.js" type="text/javascript"></script>
    <script src="./assets/vendors/jquery-slimscroll/jquery.slimscroll.min.js" type="text/javascript"></script>
    
    <script src="./assets/vendors/DataTables/datatables.min.js" type="text/javascript"></script>
    
    <script src="assets/js/app.min.js" type="text/javascript"></script>
   
	
</html>
