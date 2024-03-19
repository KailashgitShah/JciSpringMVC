<%@page import="com.jci.model.EntryDerivativePrice"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.List"%>
<%@page import="java.io.File"%>

<%@page import="com.jci.model.RawJuteProcurementAndPayment"%>

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
</style>
<script>

<%

/* EncodeId encodeId = new EncodeId();
SecretKey secretKey = encodeId.generateAESKey(128); */
 
%>

$(document).ready(function() {
	alert();
    var table = $('#example-table').DataTable( {
        scrollY:        "300px",
        scrollX:        true,
        scrollCollapse: true,
        paging:         false,
        fixedColumns:   {
            left: 1,
            right: 1
        }
    } );
} );
</script>
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
                <h1 class="page-title">Entry Derivative Price List</h1>
            </div>
				<%
				List<EntryDerivativePrice> edpList = (List<EntryDerivativePrice>) request.getAttribute("edp");
				//SecretKey key = (SecretKey) request.getSession().getAttribute("SecretKey");
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
										<th>Crop Year</th>
										<th>Delivery Type</th>
										<th>State Name</th>
										<th>District</th>
										<th>Jute Variety</th>
										<th>Grade 1</th>
										<th>Grade 2</th>
										<th>Grade 3</th>
										<th>Grade 4</th>
										<th>Grade 5</th>
										<th>Grade 6</th>
									
						
										
										<th></th>
											<th></th>
																								
								</thead>
								<tbody>
									<%
									int i= 1;
									for(EntryDerivativePrice edpl : edpList){
										//String codid = encodeId.encrypt(edpl.getDer_id()+"",key);
									%>
									<tr>
										<td><%=i%></td>
										<td><%=edpl.getCrop_year()%></td>
										<td><%=edpl.getDelivery_type()%></td>
				                    	<td><%=edpl.getState_name()%></td>
										<td><%=edpl.getDistrict_name()%></td>
										<td><%=edpl.getJute_variety()%></td>
										<td><%=edpl.getGrade1()%></td>
										<td><%=edpl.getGrade2()%></td>
										<td><%=edpl.getGrade3()%></td>
										<td><%=edpl.getGrade4()%></td>
										<td><%=edpl.getGrade5()%></td>
										<td><%=edpl.getGrade6()%></td>
									
							 
									 <%-- <td><a href="editentryderivativeprice.obj?der_id=<%=codid%>" class="btn btn-warning btn-sm btn-block">  <i class="fa fa-pencil" aria-hidden="true" style="font-size: 15px;"></i></a></td> --%>
										 <td><a href="editentryderivativeprice.obj?der_id=<%=edpl.getDer_id()%>" class="btn btn-warning btn-sm btn-block">  <i class="fa fa-pencil" aria-hidden="true" style="font-size: 15px;"></i></a></td> 
										<td><a onclick="return confirm('Are you sure you want to delete this item?');" href="entryderivativepriceDelete.obj?der_id=<%=edpl.getDer_id()%>" class="btn btn-danger btn-sm btn-block">  <i class="fa fa-trash" aria-hidden="true" style="font-size: 15px;"></i></a></td>
										
									</tr>
									<% 
							i++; }
							
							%>
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
