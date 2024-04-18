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
                <h1 class="page-title">Market Arrival Report</h1>
            </div>
                            <% List<MarkerArrivalModelDTO> marketList = (List<MarkerArrivalModelDTO>) request.getAttribute("allMarketArrival"); 
                 String region =  (String)request.getAttribute("roName"); 
                 String region_id =  (String)request.getAttribute("region_id");
                 String dateArrival =  (String)request.getAttribute("dateArrival"); %>
            
          
								
            <div class="page-content fade-in-up">
            <form action = "MarketArrivalDownload.obj">
            <div class="row">
              <div class="col-sm-4 form-group">
									<label class="required">Region</label> <input class="form-control"
										type="text" name="binnumb" placeholder="Farmer Address" value="<%=region %>">
								<input type="hidden" name="region_id" value="<%=region_id %>">
								</div>
								  <div class="col-sm-4 form-group">
									<label class="required">Arival Dtae</label> <input class="form-control"
										type="text" name="datearrival" value="<%=dateArrival %>">
								</div>
								<div class="form-group">
                                        <button class="btn btn-default" type="submit">Download</button>
                                    </div>
			</div>
			</form>
            <div class="ibox">
                    <span>${msg}</span>
                    <div class="ibox-body">
                    <div class="scrollmenu">
                        <table class="table table-striped table-bordered table-hover" id="example-table" cellspacing="0" width="100%">
                    <thead>
                        <tr>
                            <th class="col-sm-3 text-center">S.N.</th>
                            <th class="col-sm-3 text-center">Crop Year</th>
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
                            <td><%= list.getCropyr() %></td>
                            <td><%= list.getCentername() %></td>
                            <td><%= list.getDatearrival() %></td>
                            <td><%= list.getArrivedqty() %></td>
                            <td><%= list.getJute_verity() %></td>
                            <td><%= list.getGrade_rate1() %></td>
                            <td><%= list.getGrade_rate2() %></td>
                            <td><%= list.getGrade_rate3() %></td>
                            <td><%= list.getGrade_rate4() %></td>
                            <td><%= list.getGrade_rate5() %></td>
                            <td><%= list.getMixmois() %></td>
                            <td><%= list.getMaxmois() %></td>
                            <td><%= list.getGrade2() %></td>
                            <td><%= list.getGrade3() %></td>
                            <td><%= list.getGrade4() %></td>
                            <td><%= list.getGrade5() %></td>
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
    <!-- PAGE LEVEL SCRIPTS-->
    <script type="text/javascript">
        $(function () {
            $('#example-table').DataTable({
                pageLength: 10,
            });
        })
    </script>
 <script type="text/javascript">
    $(document).ready(function() {
        $('#example-table').DataTable({
            fixedHeader: true,
            scrollX: true,
            "paging": true,
            "pageLength": 25
        });
    });
</script>
</body>

</html>
