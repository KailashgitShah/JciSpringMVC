\
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
<link href="./assets/vendors/bootstrap/dist/css/bootstrap.min.css"
	rel="stylesheet" />
<link href="./assets/vendors/font-awesome/css/font-awesome.min.css"
	rel="stylesheet" />
<link href="./assets/vendors/themify-icons/css/themify-icons.css"
	rel="stylesheet" />
<!-- PLUGINS STYLES-->
<!-- THEME STYLES-->
<link href="assets/css/main.min.css" rel="stylesheet" />
<!-- PAGE LEVEL STYLES-->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.13.2/themes/base/jquery-ui.css">
<link rel="stylesheet" href="/resources/demos/style.css">
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
<script src="https://code.jquery.com/ui/1.13.2/jquery-ui.js"></script>
<link rel="stylesheet" href="assets/css/chosen.css">
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.5.0/js/bootstrap-datepicker.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<!-- CORE SCRIPTS-->
<style>
.field-icon {
	float: right;
	margin-left: -25px;
	margin-top: -25px;
	position: relative;
	z-index: 2;
}

.container {
	padding-top: 50px;
	margin: auto;
}

.required:after {
	content: " *";
	color: red;
}

input[type="radio"] {
	display: inline;
}

.required:after {
	content: " *";
	color: red;
}
</style>

  <style>
        .text-danger {
            color: red;
        }
    </style>

</head>

<%
List<String> allDpc = (List<String>) request.getAttribute("loadAllDpc");
List<String> allHoDiNo = (List<String>) request.getAttribute("loadAllDiNo");
//int count = (int) request.getAttribute("count") + 1; //valid for next entry
%>


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
				<h1 class="page-title">Uploading of Payment Realization / Disbursal Details</h1>
			</div>
               <%
                   
                    List<Object[]> fetchMill_Name =     (List<Object[]>) request.getAttribute("fetchMill_Name");  
                    String millname="";
                    String millcode="";
                    String millCodeAndName="";
       
             %>
			<div class="page-content fade-in-up">
				<div class="row">
					<div class="col-md-11">
						<div class="ibox">
							    <span id="flashMessage">${msg}</span>
							<div class="ibox-body">
								<form id="myForm" action="saveuploadPaymentRealizationDisDetails.obj" method="POST" enctype="multipart/form-data">
									<div class="row">
									
                                                                             <div class="col-sm-6 form-group">
                                                                               <label>Mill name.</label> <span class="text-danger">*
                                                                               </span>&nbsp; <span id="millname1" name="Millname"
                                                                                     class="text-danger"> </span> <select name="millcodeName"
                                                                                     id="millname12"  class="form-control taxtbox" required>

                                                                                     <option value="select">-Select-</option>
                                                                                     <%
                                                                                    
                                                                                     for (Object[] row : fetchMill_Name) {
                                                                                            millname = (String) row[0];  
                                                                                          millcode = (String) row[1]; 
                                                                                          millCodeAndName =  millcode +"-"+millname;
                                                                                         
                                                                                     %>
                                                                                     <option value="<%=millCodeAndName%>"><%=millname%></option>
                                                                                     <%
                                                                                     }
                                                                                     %> 
                                                                               </select>


                                                                        </div>
                                                                        
                                                                        
                                                                          <div class="col-sm-5 form-group" id="dpc_div">
                                                                               <label>Contract No.</label> <span class="text-danger">*</span>&nbsp;
                                                                               <span id="contractno" class="text-danger"></span> <select
                                                                                     name="fullcontractno" id="contractno12" 
                                                                                     class="form-control taxtbox"
                                                                                     style="height: = 50; width: 350px;" required>
                                                                                     <option disabled selected value="">-Select</option>

                                                                               </select>
                                                                        </div>
                                                                        
                                                            
									</div>
									
									<div class="row">
										
									
                                                                        <div class="col-sm-6 form-group" >
																	    <label>Transaction No.</label> <span class="text-danger">*</span>&nbsp;
																	    <select
																	        name="transactionid" id="transactionid" 
																	        class="form-control taxtbox"
																	        required>
																	        <option disabled selected value="">-Select-</option>
																	    </select>
																	</div>   
                                                                        
                                                               
									
											
									<!-- <div class="col- form-group">
								   	<label>UTR Number</label> <span class="text-danger">*</span><input
												class="form-control textbox" type="text" name="utrNumber" placeholder="Enter UTR Number"
												 required >
										</div> -->
										
										  <div class="col- form-group">
									            <label for="utrNumber">UTR Number</label> <span class="text-danger">*</span>
									            <input
									                id="utrNumber"
									                class="form-control textbox"
									                type="text"
									                name="utrNumber"
									                placeholder="Enter UTR Number"
									                required
									                pattern="[A-Za-z0-9]{12,}"
									                title="UTR Number must be at least 12 alphanumeric characters."
									                oninput="restrictInput(event)"
									                
									            >
									            <div id="error-message" class="text-danger"></div>
									        </div>
										
										<div class="col-3 form-group">
								        	<label>UTR Date</label> <span class="text-danger">*</span><input
												class="form-control textbox" name="dateofUtr" placeholder="dd-mm-yyyy"
												id="DateofUtr" required oninput="restrictInput(event)" >
										</div>
										</div>
								
									
									<!-- <div class="row">
									<div class="col-4 form-group">
											<label>Upload Excel File<span class="text-danger">*</span></label>
											 <input type="file" class="form-control"
												id="excelFile" name="excelFile" />
								
										</div>
									</div> -->
									

									<div class="row">
										<div class="col-sm-12 form-group">
											<input type="submit" value="Submit" class="btn btn-primary"
												id="submit">
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
	
	
	<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
<script src="https://code.jquery.com/ui/1.13.2/jquery-ui.js"></script>
<script>
	
     function restrictInput(event) {
         // Replace < and > with an empty string
         event.target.value = event.target.value.replace(/[<>]/g, '');
     }
 </script>
 <script>
        $(document).ready(function() {
            $('#myForm').on('submit', function(event) {
                // Disable the submit button
                $('#submit').prop('disabled', true);
                $('#submit').val('Please Wait Processing...');  

              
            });
        });
    </script>
 <script>
	$( "#DateofUtr" ).datepicker({ dateFormat: 'dd-mm-yy'    });
</script> 
	<script type = "text/javascript">
	
	
	$("#submit").on("click" , function(){
		var inputFile = document.getElementById('excelFile');
	    var fileName = inputFile.value;
	    if (fileName.endsWith('.xls') || fileName.endsWith('.xlsx')) {
	       return true;
	    }else if(fileName == ""){
	    	alert("please Select file..");
	    	return false;	
	    }
	    	else {
	    	alert("Please select excel file only..");
	        inputFile.value = '';
	        return false;
	    }
	})
	
	</script>
	<script>
        document.getElementById('utrForm').addEventListener('submit', function(event) {
            var utrInput = document.getElementById('utrNumber');
            var errorMessage = document.getElementById('error-message');
            
            // Clear any previous error messages
            errorMessage.textContent = '';

            // Validate the input
            if (utrInput.value.length < 12) {
                errorMessage.textContent = 'UTR Number must be at least 12 characters long.';
                event.preventDefault(); // Prevent form submission
            }
        });
    </script>
    <script>
	
     function restrictInput(event) {
         // Replace < and > with an empty string
         event.target.value = event.target.value.replace(/[<>]/g, '');
     }
 </script>
	<script type="text/javascript">
	  $(document).ready(function() {
	        
	      // Millname change event handler
	      $('#millname12').on('change', function() {
	    	  
	          const field2Value = $(this).val();
	          const millcode = field2Value.split('-')[0]; 
	         // alert(millcode)
              //alert(field2Value)
	            $.ajax({
	              type: 'GET',
	              url: 'contrcatForPaymentRealisation.obj',
	              data: { "millname": millcode },
	              success: function(data) {
	              
	                  const dataArray = JSON.parse(data);
	                  //alert(dataArray)
	                  const dropdownElement = document.getElementById('contractno12');

	                  // Clear previous options
	                  dropdownElement.innerHTML = '';

	                  // Add the default option
	                  const selectOption = document.createElement('option');
	                  selectOption.value = ''; 
	                  selectOption.textContent = '-Select-';
	                  dropdownElement.appendChild(selectOption);

	                  // Populate new options
	                  dataArray.forEach(function(innerArray) {
	                      const option = document.createElement('option');
	                      option.textContent = innerArray;
	                      option.value = innerArray;
	                      option.setAttribute('data-value1', innerArray); // Value for backend
	                   
	                      dropdownElement.appendChild(option);
	                  });
	              },
	              error: function(xhr, status, error) {
	                  console.error('AJAX request failed:', status, error);
	                  // Handle the error as needed
	              }
	          }); 
	          
	      });
	      });
	</script>
	
	<script type="text/javascript">
    $(document).ready(function() {
        $("#contractno12").on('change', function() {
            const fieldValue = $(this).val();

            $.ajax({
                type: 'GET',
                url: 'transactionidcontract.obj',
                data: { "contractNo": fieldValue },
                success: function(data) {
                    let dropdownElement = document.getElementById('transactionid');
                    const dataArray = JSON.parse(data);

                    if (dataArray === null || dataArray.length === 0) {
                        dropdownElement.innerHTML = '';
                        alert("No Transaction No Is Available On this Contract");
                        
                        return; // Exit the function if no transactions are available
                    } else {
                        dropdownElement.innerHTML = '';

                        // Add the default option
                        const selectOption = document.createElement('option');
                        selectOption.value = ''; 
                        selectOption.textContent = '-Select-';
                        dropdownElement.appendChild(selectOption);

                        // Populate new options
                        dataArray.forEach(function(innerArray) {
                            const option = document.createElement('option');
                            option.textContent = innerArray;
                            option.value = innerArray;
                            option.setAttribute('data-value1', innerArray); // Value for backend
                            
                            dropdownElement.appendChild(option);
                        });
                    }
                },
                error: function(xhr, status, error) {
                    console.error('AJAX request failed:', status, error);
                    alert('An error occurred while processing your request.');
                }
            });
        });
    });
</script>

	    <script>
	    //for hide the displayed message
            setTimeout(function() {
                document.getElementById('flashMessage').style.display = 'none';
            }, 1500);
        </script>

	<!-- END PAGA BACKDROPS-->
	<!-- CORE PLUGINS-->
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
	<script src="assets/css/chosen.jquery.js" type="text/javascript"></script>

	<!-- PAGE LEVEL SCRIPTS-->
</body>
</html>