<%@ page import="java.util.Date" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@page import="org.apache.poi.util.SystemOutLogger"%>
<%@page import="com.jci.model.EntryPaymentDetailsModel"%>
<%@page import="com.jci.model.GenerationofDocumentLCsModel"%>

<%@page import="java.util.HashMap"%>
<%@page import="java.util.List"%>
<%@page import="java.io.File"%>
<%@page import="com.jci.model.RoleMasterModel"%>
<%@page import="com.jci.model.ZoneModel"%>
<%@page isELIgnored="false"%>

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
  color: white;
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



.newchildbos{
    min-width: 50px;
    height: 10px; /* Adjust the width as needed */
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
				<h1 class="page-title">Documents</h1>

			</div>

			<%
		/* 	List<GenerationofDocumentLCsModel> allUserRegistration = (List<GenerationofDocumentLCsModel>)request.getAttribute("genrationcashDocument");
			 */
			 List<Object[]> allUserRegistration = (List<Object[]>)request.getAttribute("genrationcashDocument");
			
		%>
                  <div class="page-content fade-in-up">
                <div class="ibox">
                    <div class="ibox-head">
                    <span>${msg}</span>
                        <div class="ibox-title"></div>
                    </div>
                    <div class="ibox-body">
                      <div class="scrollmenu">
                        <table class="table table-striped table-bordered table-hover" id="example-table" cellspacing="0" width="100%">
                               <thead>
									<tr>
										<th>Sl.No</th>
										<th>SerialNo</th>
										<!-- <th>BillofSupplyno</th> -->
									    <th>TopSheet Date</th> 
										<th>TopSheet</th>
										
									 	
										<th>BankDraft</th> 
										<th>BillofExchange</th>
									
										
										<th></th>
									</tr>
								</thead>
                           <tbody>
									<%
									int i = 1;
									SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
									for(Object[] row : allUserRegistration ){

										if (i <= 200) {
											
									%>
									<tr>
										<td><%=i%></td>
									
											  <td>
							                <span class="single-click" data-id="<%=row[0]%>" > <%= row[0] %></span>
							            </td>
									
										<td><%= row[1] %></td>
										
									
									
										
								
										


										<td><a href="downloadLetterofcreditdocument.obj?filename=<%= row[2] %>" target="_blank" style="color:blue;">TopSheet</a></td>
											<td><a href="downloadLetterofcreditdocument.obj?filename=<%= row[3] %>" target="_blank" style="color:blue;">bankDraft</a></td>
											<td><a href="downloadLetterofcreditdocument.obj?filename=<%= row[4] %>" target="_blank" style="color:blue;">BillofExchange</a></td>

								
								    <%--   	<td><%= generationofDocumentLCsModel.getSerialno() %></td>
								      	<td><%= generationofDocumentLCsModel.getbOS_No() %></td>
								        <td><%= sdf.format( generationofDocumentLCsModel.getBoe_Date()) %></td>
								       --%>
									
									<%--  <td>
								            <a href="downloadLetterofcreditdocument.obj?filename=<%= generationofDocumentLCsModel.getTopsheetpath() %>"  target="_blank">
								             
								               <button class="btn btn-primary btn-sm" target="_blank" type="button">View TopSheet</button>
								        </td>
								          <td>
								            <a href="downloadLetterofcreditdocument.obj?filename=<%= generationofDocumentLCsModel.getBankdrftpath() %>"  target="_blank">
								             
								               <button class="btn btn-primary btn-sm" target="_blank" type="button">View billofexchange</button>
								        </td>
								          <td>
								            <a href="downloadLetterofcreditdocument.obj?filename=<%= generationofDocumentLCsModel.getBillofexchangepath() %>"  target="_blank">
								          
								               <button class="btn btn-primary btn-sm" target="_blank" type="button">View bankdraft </button>
								        </td> --%>


									</tr>
									<%
										}
									   i++;
										} 
										%>
									
										
									
									
								</tbody>

                        </table>
                        
                                    <table id="childTable" class="newchildbos">
											    <thead class="thead-light">
											        <tr>
											            <th>BosNo</th>
											        </tr>
											    </thead>
											    <tbody>
											        <tr>
											            <td><input type="text" id="bosno1" value=""></td>
											        </tr>
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
    <!-- BEGIN THEME CONFIG PANEL-->
     
    <!-- END THEME CONFIG PANEL-->
    <!-- BEGIN PAGA BACKDROPS-->
    <div class="sidenav-backdrop backdrop"></div>
    
    
    
 

<script type="text/javascript">
$(document).ready(function() {
    $('.single-click').on('click', function(e) {
        e.preventDefault();
        var id = $(this).data('id');
       

        $.ajax({
            type: 'GET',
            url: 'listofLCBOS.obj', 
            data: { "serialno": id},
            success: function(data) {
            
            	var dataArray = JSON.parse(data);

                // Clear the existing rows in the table body
                $('#childTable tbody').empty();

                // Iterate over the data array and add rows with input elements
                dataArray.forEach(function(row, rowIndex) {
                    var newRow = $('<tr>');  // Create a new table row
                    var newCell = $('<td>');  // Create a new table cell
                    var input = $('<input>')
                        .attr('type', 'text')  // Set the input type to 'text'
                        .attr('id', 'bosno_' + rowIndex)  // Set a dynamic ID based on the row index
                        .val(row)  // Set the value of the input to the row data (assuming it's a string)
                        .prop('readonly', true);
                     newCell.append(input);   // Append the input to the cell
                     newRow.append(newCell);   // Append the cell to the row
                    $('#childTable tbody').append(newRow);  // Append the row to the table body
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


























