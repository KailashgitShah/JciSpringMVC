<%@page import="com.jci.model.Salepricecalculation"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.List"%>
<%@page import="java.io.File"%>
<%@page import="com.jci.model.DailyPurchaseConfModel"%>
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
    <script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
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
                <h1 class="page-title">Sale Price Calculation List</h1>
            </div>
			   <%
				 List<Salepricecalculation>  salepricecalculationl = (List <Salepricecalculation>) request.getAttribute("salepricecalculationlist");
			%>
			 <div class="page-content fade-in-up">
                <div class="ibox">
                    <span>${msg}</span>
                    <div class="ibox-body">
                    <div class="scrollmenu">
                         <table class="table table-striped table-bordered table-hover" id="example-table" cellspacing="0" width="100%">
								<thead>
									<tr>
										<th>Sl.No</th>
										<th>Crop Year</th>
										<th>Center</th>
										<th>Sale Quantity</th>
										<th>Amount</th>
										<th>Jute Variety</th>
										<th>Jute Grade</th>
										<th>Grade Differential</th>
										<th>Garsat Rate</th>
										<th>Base Price</th>
										<th>Bin Number</th>
										<th>Operation Cost</th>
										<th>Insurance</th>
										<th>Freight</th>
										<th>Provision From Claim</th>
										<th>Weight Loss</th>
										<th>Marketlevy</th>
										<th>Opportunity Cost Margin</th>
										<th>Td Five Base Price</th>
										<th></th>
										<th></th>
									</tr>
								</thead>
								<tbody>
									<%
									int i= 1;
								for(Salepricecalculation spclist : salepricecalculationl){
									%>
									<tr role="row" class="odd">
										<td class="sorting_1"><%=i%></td>
										<td><%=spclist.getCrop_year()%></td>
										<td><%=spclist.getCenter()%></td> 
										<td><%=spclist.getSale_quantity()%></td>
										<td><%=spclist.getAmount()%></td>
										<td><%=spclist.getJute_variety()%></td>
										<td><%=spclist.getJute_grade()%></td>
										<td><%=spclist.getGrade_differential()%></td>
										<td><%=spclist.getGarsat_rate()%></td>
										<td><%=spclist.getBase_price()%></td> 
										<td><%=spclist.getBin_number()%></td>
										<td><%=spclist.getOperation_cost()%></td>
										<td><%=spclist.getInsurance()%></td>
										<td><%=spclist.getFreight()%></td>
										<td><%=spclist.getProvision_from_claim()%></td>
										<td><%=spclist.getWeight_loss()%></td>
										<td><%=spclist.getMarketlevy()%></td> 
										<td><%=spclist.getOpportunitycostm_argin()%></td>
										<td><%=spclist.getTd_five_baseprice()%></td>
									<td><a href="salespricecalculationedit.obj?spc_id=<%=spclist.getSpc_id()%>" class="btn btn-warning btn-sm btn-block"><i class="fa fa-pencil" aria-hidden="true" style="font-size: 15px;"></i></a></td>
									<td><a href="salespricecalculationdelete.obj?spc_id=<%=spclist.getSpc_id()%>" ><i class="btn btn-danger btn-sm btn-block"><i class="fa fa-trash" aria-hidden="true" style="font-size: 15px;"></i></a></td>
							
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
