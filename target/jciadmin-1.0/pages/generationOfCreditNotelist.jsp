
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
                <h1 class="page-title">Generation Of Credit Notes</h1>
            </div>
				<%
				List<Object[]> list = (List<Object[]>) request.getAttribute("list");
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
										<th>Bill No</th>
										<th>Contract No</th>
										<th>Invoice Amount</th>
										<th>Shipment Details</th>
										<th>Nominal Weight</th>
										<th>Actual Weight</th>
										<th>Ro Id</th>
										<th></th>																								
								</thead>
								<tbody>
									<%
									int i= 1;
									for(Object[] ele : list){
										//String codid = encodeId.encrypt(edpl.getDer_id()+"",key);
									%>
									<tr>
										<td><%=i%></td>
										<td><%=ele[0]%></td>
										<td><%=ele[1]%></td>
				                    	<td><%=ele[2]%></td>
										<td><%=ele[3]%></td>
										<td><%=ele[4]%></td>
										<td><%=ele[5]%></td>
										<td><%=ele[6]%></td>
									
									 
																		
							 
									 <%-- <td><a href="editentryderivativeprice.obj?der_id=<%=codid%>" class="btn btn-warning btn-sm btn-block">  <i class="fa fa-pencil" aria-hidden="true" style="font-size: 15px;"></i></a></td> --%>
                                     <td><a onclick="saveCreditNote('<%=ele[1]%>','<%=ele[2]%>','<%=ele[3]%>','<%=ele[4]%>','<%=ele[5]%>','<%=ele[6]%>')" class="btn btn-warning btn-sm btn-block">Generate credit Note </a></td>  
									
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
    <script src="./assets/vendors/DataTables/datatables.min.js" śtype="text/javascript"></script>
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
        
        
      function saveCreditNote(contractNo,invoiceVal , shipmentDetails , nominalWeight , ActualWeight , roId ){
        	
        
         $.ajax({
        		type : "POST",
        		url : "generateCrn.obj",
        		data : {
        			"contractNo":contractNo,
        			"shipmentDetails":shipmentDetails,
        			"nominalWeight" : nominalWeight,
        			"ActualWeight" : ActualWeight,
        			"roId" : roId,
        			"invoiceValue" : invoiceVal
        		},
        		success : function(){
        			window.location.href = "creditNoteForm.obj"
        		}
        	})
        }
       
    </script>
</body>

</html>
