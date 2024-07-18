<%@page import="com.jci.model.RoDispatchModel"%>

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
    <script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
     

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
                <h1 class="page-title">Ro Di List </h1>
            </div>
				<%
				List<RoDispatchModel> roDiList = (List<RoDispatchModel>) request.getAttribute("roDiList");
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
										<th>Contract No</th>
										<th>Last date of Shipment</th>
										<th>RO DI No</th>
										<th>RO DI Date </th>
										<th>Jute Variety</th>
										<th>Grade 1</th>
										<th>Grade 2</th>
										<th>Grade 3</th>
										<th>Grade 4</th>
										<th>Grade 5</th>
										<th>Grade 6</th>
										<th>Grade 7</th>
										<th>Grade 8</th>			
										<th>Total</th>																					
								</thead>
								<tbody>
<%
    int i = 1; // Declare i outside the loop

    for (RoDispatchModel di : roDiList) {
        String regId = (String) session.getAttribute("regionId");
        String input = di.getRoDiNo();
        String[] parts = input.split("/");

        // Check if the regionId matches the first two characters of the second part
        if (parts.length > 1 && parts[1].startsWith(regId)) {
%>
<tr>
    <td style='text-align:center;'><%= i %></td>
    <td style='text-align:center;'><%= di.getContractNo() %></td>
    <td style='text-align:center;'><%= di.getLastDateOfShipment() %></td>
    <td style='text-align:center;'><%= di.getRoDiNo() %></td>
    <td style='text-align:center;'><%= di.getRoDiDate() %></td>
    <td style='text-align:center;'><%= di.getJuteVariety() %></td>
    <td style='text-align:center;'><%= di.getGr1Qty() %></td>
    <td style='text-align:center;'><%= di.getGr2Qty() %></td>
    <td style='text-align:center;'><%= di.getGr3Qty() %></td>
    <td style='text-align:center;'><%= di.getGr4Qty() %></td>
    <td style='text-align:center;'><%= di.getGr5Qty() %></td>
    <td style='text-align:center;'><%= di.getGr6Qty() %></td>
    <td style='text-align:center;'><%= di.getGr7Qty() %></td>
    <td style='text-align:center;'><%= di.getGr8Qty() %></td>
    <td style='text-align:center;'><%= di.getGr1Qty() + di.getGr2Qty() + di.getGr3Qty() + di.getGr4Qty() + di.getGr5Qty() + di.getGr6Qty() + di.getGr7Qty() + di.getGr8Qty() %></td>
</tr>
<%
        i++; // Increment i within the loop
        }
    }
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
               
            });
        })
    </script>
</body>

</html>
