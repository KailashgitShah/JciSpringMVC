<%@page import="com.jci.model.MarkerArrivalModelDTO"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.List"%>
<%@page import="java.io.File"%>

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
 
  overflow: scroll;
  white-space: nowrap;
}

.scrollmenu a {
  display: inline-block;
  color: white;
  text-align: center;
  padding: 14px;
  text-decoration: none;
}
.tableFixHead          { overflow: auto; height: 100px; width: 240px; }
.tableFixHead thead th { position: sticky; top: 0; z-index: 1; }
.tableFixHead tbody th { position: sticky; left: 0; }
table  { border-collapse: collapse; width: 100%; }
th, td { padding: 8px 16px; white-space: nowrap; }
th     { background:#eee; }
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
                <h1 class="page-title">Daily Market Report</h1>
            </div>
                            <% List<MarkerArrivalModelDTO> marketList = (List<MarkerArrivalModelDTO>) request.getAttribute("allMarketArrival"); 
                 String region =  (String)request.getAttribute("region"); 
                 String region_id =  (String)request.getAttribute("region_id");
                 String arrivaldates =  (String)request.getAttribute("arrivaldates"); 
                 String cropyear =  (String)request.getAttribute("cropyear");%>
            
          
								
            <div class="page-content fade-in-up">
           <form action = "MarketArrivalDownload.obj">
            <div class="row">
              <div class="col-sm-4 form-group">
									<label class="required">Region</label> <input class="form-control"
										type="text" name="binnumb" placeholder="Farmer Address" value="<%=region %>" readonly>
								<input type="hidden" id="region_id" name="region_id" value="<%=region_id %>">
								</div>
								
								    <div class="col-sm-4 form-group">
											<label>Date Arrival</label> 
											<span class="text-danger">* </span>&nbsp; <span id="errfromdate" name="errfromdate"
												class="text-danger"> </span>
											<input class="form-control" name="datearrival" id="datearrival"  placeholder="dd-mm-yyyy" value="<%=arrivaldates %>" readonly>
										</div>
												    <div class="col-sm-4 form-group">
											<label>Crop Year</label> 
											<span class="text-danger">* </span>&nbsp; <span id="errcropyear" name="errcropyear"
												class="text-danger"> </span>
											<input class="form-control" name="cropyear" id="cropyear"  placeholder="Crop Year" value="<%=cropyear %>" readonly>
										</div>
								
								
			</div>
			            <div class="row">
			
			<div class="form-group">
								<label></label> <br>
                                        <button class="btn btn-primary" type="submit">Download</button>
    <a href="http://localhost:8080/jciadmin/MarketArrivalRegions.obj">Go Back</a>
                                        
        			</div>
                                        
                                    </div>
			
            <div class="ibox">
                    <span>${msg}</span>
                    <div class="ibox-body">
                    <div class="scrollmenu">
                        <table class="table table-striped table-bordered table-hover" id="example-table" cellspacing="0" width="100%">
                    <thead>
                        <tr>
                            <th class="col-sm-3 text-center">S.N.</th>
                             <th class="col-sm-3 text-center">Center Name</th>
                            <th class="col-sm-3 text-center">Arrival Date</th>
                            <th class="col-sm-3 text-center">Arrived Quantity</th>
                            <th class="col-sm-3 text-center">Jute Varity</th>
                            <th class="col-sm-3 text-center">Grade 1 Rate</th>
                            <th class="col-sm-3 text-center">Grade 2 Rate</th>
                            <th class="col-sm-3 text-center">Grade 3 Rate</th>
                            <th class="col-sm-3 text-center">Grade 4 Rate</th>
                            <th class="col-sm-3 text-center">Grade 5 Rate</th>
                            <th class="col-sm-3 text-center">Min Moisture</th>
                            <th class="col-sm-3 text-center">Max Moisture</th>
                            <th class="col-sm-3 text-center">Grade 2</th>
                            <th class="col-sm-3 text-center">Grade 3</th>
                            <th class="col-sm-3 text-center">Grade 4</th>
                            <th class="col-sm-3 text-center">Grade 5</th>
                        </tr>
                    </thead>
                    <tbody>
                        <% int i = 1;
                        for (MarkerArrivalModelDTO list : marketList) { %>
                        <tr>
                                                    <td><%= i %></td>
                        
                            <td><%= list.getCentername() %></td>
                            <td>  <%= list.getDatearrival() %></td>

                   <td>
    <%
        if ("0".equals(list.getArrivedqty())) {
            out.print("No Arrival");
        } else {
            out.print(list.getArrivedqty());
        }
    %>
</td>
              <td>
    <%
        if ("0".equals(list.getJute_verity())) {
            out.print("No Arrival");
        } else {
            out.print(list.getJute_verity());
        }
    %>
</td>
                            <td>  <%= list.getGrade_rate1() %></td>

                            <td>  <%= list.getGrade_rate2() %></td>

                            <td>  <%= list.getGrade_rate3() %></td>

                            <td>  <%= list.getGrade_rate4() %></td>

                            <td>  <%= list.getGrade_rate5() %></td>
    <td>  <%= list.getMixmois() %></td>


                            <td>  <%= list.getMaxmois()%></td>
                            <td>  <%= list.getGrade2() %></td>


                            <td>  <%= list.getGrade3() %></td>


                            <td>  <%= list.getGrade4() %></td>

                             <td>  <%= list.getGrade5() %></td>



                        </tr>
                        <% i++;
                        } %>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
       </div>
    </div>
    <!-- END PAGE CONTENT-->
    <%@ include file="footer.jsp"%>

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
       
    <!-- Include jQuery -->
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<!-- Include jQuery UI CSS -->
<link rel="stylesheet" href="https://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<!-- Include jQuery UI JavaScript -->
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.min.js"></script>  

 
    <!-- Include DataTables CSS -->
    <link rel="stylesheet" href="https://cdn.datatables.net/1.13.0/css/jquery.dataTables.min.css">
    <!-- Include DataTables JavaScript -->
    <script src="https://cdn.datatables.net/1.13.0/js/jquery.dataTables.min.js"></script>
    <!-- Include DataTables Buttons CSS -->
    <link rel="stylesheet" href="https://cdn.datatables.net/buttons/2.3.4/css/buttons.dataTables.min.css">
    <!-- Include DataTables Buttons JavaScript -->
    <script src="https://cdn.datatables.net/buttons/2.3.4/js/dataTables.buttons.min.js"></script>
    <script src="https://cdn.datatables.net/buttons/2.3.4/js/buttons.html5.min.js"></script>
    <script src="https://cdn.datatables.net/buttons/2.3.4/js/buttons.print.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jszip/3.10.1/jszip.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/pdfmake/0.2.5/pdfmake.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/pdfmake/0.2.5/vfs_fonts.js"></script>
    <!-- PAGE LEVEL SCRIPTS-->
    <!-- <script type="text/javascript">
        $(function () {
            $('#example-table').DataTable({
                pageLength: 25,
            });
        })
    </script> -->
    
 <script>
        function goBack() {
            window.location.href = "http://localhost:8080/jciadmin/MarketArrivalRegions.obj";
        }
    </script>
    
 <script type="text/javascript">
    $(document).ready(function() {
        $('#example-table').DataTable({
            fixedHeader: true,
            scrollX: true,
            pageLength : 25,
            "paging": true
            
        });
    });
</script>
<script>
$( "#datearrival" ).datepicker({ dateFormat: 'dd-mm-yy'    });
</script>

</body>

</html>
