<%@ page import="java.util.Date" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@page import="org.apache.poi.util.SystemOutLogger"%>

<%@page import="com.jci.model.dispatchdetailModel"%>

<%@page import="java.util.HashMap"%>
<%@page import="java.util.List"%>
<%@page import="java.io.File"%>
<%@page import="com.jci.model.RoleMasterModel"%>
<%@page import="com.jci.model.ZoneModel"%>
<%@page isELIgnored="false"%>
<%@ page import="java.time.LocalDateTime" %>
<%@ page import="java.time.format.DateTimeFormatter" %>

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
    <link href="./assets/vendors/DataTables/datatables.min.css" rel="stylesheet" />
    <!-- THEME STYLES-->
    <link href="assets/css/main.min.css" rel="stylesheet" />
    
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
     

    <!-- PAGE LEVEL STYLES-->
    <style>
.scrollmenu {

  overflow: auto;
  white-space: nowrap;
}

.scrollmenu a {
  display: inline-block;
  text-align: center;
  padding: 14px;
  text-decoration: none;
}

.single-click {
    color: blue; 
    cursor: pointer; 
}
.single-click:hover {
    text-decoration: underline;
}

#childTable {
    display: none; 
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
				<h1 class="page-title">Dispatch Detail List</h1>

			</div>
			
			

			
<%
   List<Object[]> allUserRegistration = (List<Object[]>) request.getAttribute("viewDispatchChallan");
%>

                  <div class="page-content fade-in-up">
                <div class="ibox">
                    <div class="ibox-head">
                    <span id="flashMessage">${msg}</span>
                        <div class="ibox-title"></div>
                    </div>
                      
                    
                    <div class="ibox-body">
                      <div class="scrollmenu">
                        <table class="table table-striped table-bordered table-hover" id="example-table" cellspacing="0" width="100%">
                               <thead>
									<tr>
										<th>Sl.No</th>
										
										<th>Challan_no</th>
										 
										<th>Contract_No</th>
										<th>Mill_name</th>
										<th>Contract_date</th>
								     	<th>DI_No</th>
										<th>DI_Date</th>
										<th>Date_of_shipment</th>
										<th>Consignment_note text</th>
										<th>Consignment_note </th>
									   <th></th>
										
										
									</tr>
								</thead>
								
								
                           <tbody>
                           
					
						 			<%
									int i = 1;
						 			
						 			
						 			
								for(Object[] row : allUserRegistration ){
									
									if (i <= 200) {
									%>
									<tr>
										<td><%=i%></td>	
										  <td>
							                <span class="single-click" data-id="<%=row[0]%>" > <%= row[0] %></span>
							            </td>
										<%-- <td><%= row[0] %></td> --%>
										<%-- <td><%= row[1] %></td> --%>
										<td><%= row[1] %></td>
										
										<td><%= row[2] %></td>
										<td><%= row[3] %></td>
								        <td><%= row[4] %></td>
										<td><%= row[5] %></td>
										<td><%= row[6] %></td>
										
										<td><%= row[8] %></td>
										<td hidden><%= row[7] %></td>
<<<<<<< HEAD
										<td style="text-align: center">
								    <a href="http://49.50.118.112:8080/DispatchDetail/<%= row[9] %>" target="_blank" style="color: blue;">Challan Document</a>
								</td>

   
										<%-- <td><%= row[9] %></td> --%>
=======

										 <td style="text-align: center;color:blue"><a href="http://49.50.118.112:8080/DispatchDetail/<%= row[9] %>" 
										  target="_blank" >Consignment Note</a></td>
    

>>>>>>> a978ade5c24cee589b55ff1dd3143cf067e14914
									
										
											<td>
									    <a href="EntryofGenerationBillsupply.obj?id=<%=row[0]%>&millname=<%= row[2]%>&DPC=<%= row[7]%>">
									        <button class="btn btn-primary custom-button" type="button">Generate BOS</button>
									    </a>
									</td> 
									
									
										
							    </tr>
									<%
										}
									   i++;
										} 
								
								
										%>
		
									 
									
								</tbody>

                        </table>
                            <table id="childTable" class="table table-bordered">
											    <thead class="thead-light">
											        <tr>
											            
											             <th>Challan NO</th>
											             <th>Bale Mark</th>
											             <th>Crop_year</th>
											            <th>Variety/Grade</th>
											            <th>Jute_value</th>
											           <th>No of bales</th>
											            <th>Nominal wt/bale</th>
											            <th>Nominal_qty</th>
											            <th>Rate</th>
											        </tr>
											    </thead>
											    <tbody>
											        <!-- Data rows will be dynamically added here -->
											    </tbody>
											</table>
											
                        
                     
                     </div>
                   </div>
                 </div>
            </div>
            <!-- END PAGE CONTENT-->
            <%@ include file="footer.jsp"%>
        </div>
    </div>
    
   



 <script type="text/javascript">
        $(document).ready(function() {
            $('.single-click').on('click', function(e) {
                e.preventDefault();
                var id = $(this).data('id');
               

                $.ajax({
                    type: 'GET',
                    url: 'listofdispatchChild.obj', 
                    data: { "challanNo": id},
                    success: function(data) {
                      
                        var dataArray = JSON.parse(data);

                        $('#childTable tbody').empty();

                        dataArray.forEach(function(row) {
                            var newRow = $('<tr>');
                           
                            for (var i = 0; i < row.length; i++) {
                                newRow.append($('<td>').text(row[i]));
                            }
                            $('#childTable tbody').append(newRow);
                        });
                        $('#childTable').show();
                       
                    },
                    error: function(xhr, status, error) {
                        console.error(xhr.responseText);
                    }
                });
            });
            
            $('#childTable').on('dblclick', function(e) {
                $('#childTable').hide();
            });
        });
    </script>
 
 
    <!-- BEGIN THEME CONFIG PANEL-->
     
    <!-- END THEME CONFIG PANEL-->
    <!-- BEGIN PAGA BACKDROPS-->
    <div class="sidenav-backdrop backdrop"></div>
    

    
 

    
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
    <script>
    $(document).ready(function() {
        setTimeout(function() {
            $('#flashMessage').fadeOut('slow');
        }, 3000);
    });
</script>
    <!-- PAGE LEVEL SCRIPTS-->
    <script type="text/javascript">
        $(function() {
            $('#example-table').DataTable({
                pageLength: 10,
                //"ajax": './assets/demo/data/table_data.json',
                /*"columns": [
                    { "S": "name" },
                    { "data": "office" },
                    { "data": "extn" },
                    { "data": "start_date" },
                    { "data": "salary" }
                ]*/
            });
        })
    </script>

</body>

</html>


























