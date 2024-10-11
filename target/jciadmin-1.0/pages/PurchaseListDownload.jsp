<%@page import="java.util.HashMap"%>
<%@page import="java.util.List"%>
<%@page import="java.io.File"%>
<%@page import="com.jci.model.RoleMasterModel"%>
<%@page import="com.jci.model.ZoneModel"%>
<%@page import="com.jci.model.PurchaseRegisterDTO"%>
<%@page import="com.jci.controller.LoginController"%>
<%@page import="com.jci.common.Encry"%>


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
    	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
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
                <h1 class="page-title">Purchase Register Report</h1>
                 
            </div>
				
				<%
				List<PurchaseRegisterDTO> purchaselists = (List<PurchaseRegisterDTO>) request.getAttribute("purchaselist");	
				String cropyear = (String)request.getAttribute("cropyear");
				String Placeofp = (String)request.getAttribute("Placeofp");
				String basis = (String)request.getAttribute("basis");
				String purchasesdateFrom = (String)request.getAttribute("purchasesdateFrom");
				String purchasesdateTo = (String)request.getAttribute("purchasesdateTo");
				PurchaseRegisterDTO dtomodel = purchaselists.get(1);
				%>
				<form action ="purchaseslist_download.obj">
				<div class="row">
				<div class="col-sm-3 form-group">
				</div>
				</div>
			<div class="row">
			<div class="col-sm-1 form-group">
			</div>
						<div class="col-sm-2 form-group">
							<label class="required">Crop Year</label>
						    <input class="form-control" value="<%=cropyear%>" name="cropyear" readonly id="cropyear" type="text">
						</div>	
						<div class="col-sm-2 form-group">
						    <label class="required">Dpc</label>
						    <input class="form-control" value="<%=dtomodel.getCentername()%>" name="dpcname" readonly id="dpcname" type="text">
                            <input  value="<%=Placeofp%>" name="dpc" type="hidden">
						    
						</div>
						<div class="col-sm-2 form-group">
						    <label class="required">Basis</label>
						    <input class="form-control" value="<%=basis%>" name="basis" readonly id="basis" type="text">
						</div>
						 <div class="col-sm-2 form-group">
						    <label class="required">Purchase Date From</label>
						    <input class="form-control" value="<%=purchasesdateFrom%>" name="purchasesdatefrom" readonly id="purchasesdatefrom" type="text">
						</div>	
						<div class="col-sm-2 form-group">
						    <label class="required">Purchase Date To</label>
						    <input class="form-control" value="<%=purchasesdateTo%>" name="purchasesdateto" readonly id="purchasesdateto" type="text">
						</div>
			</div>
			<div class="row">
			<div class="col-sm-1 form-group">
			</div>
			 <div class="col-sm-2 form-group">
			     <a href="PurchaseRegisterlist.obj" class="btn btn-primary">Go Back</a>
			 </div>
                 <div class="col-sm-2 form-group">
						 <input type="submit" value="Download Report" id="submit" class="btn btn-primary">
				 </div>
			</div>
			</form>
			 <div class="page-content fade-in-up">
                <div class="ibox">
                    <span>${msg}</span>
                    <div class="ibox-body">
                    <div class="scrollmenu">
                    
                         <table class="table table-striped table-bordered table-hover tableFixHead" id="example-table" cellspacing="0" width="100%">


								<thead>
									<tr>
										<th>Sl.No</th>
										<th>Purchase Date</th>
										<th>Tally Slip No</th>
										<th>Rate slip No</th>
										<th>Farmer Number</th>
										<th>Farmer Name</th>
										<th>Jute Variety</th>
										<th>Gross Quentity</th>
										<th>Deduction Quentity</th>
										<th>Net Quentity</th>
										<th>Amount Payable</th>
										<th>Garsat rate</th>
										<th>Bin Number</th>
										<th>Tally Status</th>
									</tr>
								</thead>
								<tbody>
									 <% 
									int i= 1;
							for(PurchaseRegisterDTO plist : purchaselists){
								
							%>
									<tr>
									    <td><%=i%></td>
										<td><%=plist.getDatepurchase() %></td>
										<td><%=plist.getTallyslipno() %></td>
										<td><%=plist.getRate_slipno() %></td>
										<td><%=plist.getFarmerregno() %></td>
 	                                    <td><%=plist.getFarmername() %></td>
 	                                    <td><%=plist.getJutevariety() %></td>
										<td><%=plist.getGross_qty() %></td>
										<td><%=plist.getDeduc_qty() %></td>
 	                                    <td><%=plist.getNet_qty() %></td>
 	                                    <td><%=plist.getAmountpayable() %></td>
										<td><%=plist.getGarsat() %></td>
										<td><%=plist.getBinno() %></td>
 	                                    <td><%=plist.getTally_status() %></td>
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
    <script type="text/javascript" src="https://cdn.datatables.net/buttons/1.3.1/js/dataTables.buttons.min.js"></script> 
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/jszip/3.1.3/jszip.min.js"></script>
<script type="text/javascript" src="https://cdn.datatables.net/buttons/1.3.1/js/buttons.html5.min.js"></script>
<script type="text/javascript" src="https://code.jquery.com/jquery-3.5.1.js"></script>
<script type="text/javascript" src="https://cdn.datatables.net/1.10.25/js/jquery.dataTables.min.js"></script>
<script type="text/javascript" src="https://cdn.datatables.net/buttons/1.7.1/js/dataTables.buttons.min.js"></script>
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/jszip/3.1.3/jszip.min.js"></script>
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/pdfmake/0.1.53/pdfmake.min.js"></script>
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/pdfmake/0.1.53/vfs_fonts.js"></script>
<script type="text/javascript" src="https://cdn.datatables.net/buttons/1.7.1/js/buttons.html5.min.js"></script>
<script type="text/javascript" src="https://cdn.datatables.net/buttons/1.7.1/js/buttons.print.min.js"></script>
<link rel="stylesheet" href="https://cdn.datatables.net/1.10.25/css/jquery.dataTables.min.css">
<link rel="stylesheet" href="https://cdn.datatables.net/buttons/1.7.1/css/buttons.dataTables.min.css">
    <script type="text/javascript">
    $(document).ready(function() {
        $('#example-table').DataTable({
            fixedHeader: true,
            
            dom: 'Bfrtip',
		    buttons: [
		    	    {
		                extend: 'excelHtml5',
		                title: 'Purcase Register'
		            },
		        
		             
		            {
		                extend: 'csvHtml5',
		                title: 'Purchase Report'
		            },
		            {
		                extend: 'copyHtml5',
		                title: 'Purcase Register'
		            }
		         
		    ],
            "pageLength": 25
        });
    });
</script>
</body>

</html>