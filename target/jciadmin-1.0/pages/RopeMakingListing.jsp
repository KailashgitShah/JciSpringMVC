<%@page import="java.util.HashMap"%>
<%@page import="java.util.List"%>
<%@page import="java.io.File"%>

<%@page import="com.jci.model.RopeMakingModel"%>
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
                <h1 class="page-title">Rope Making Listing</h1>
            </div>
				<%
				String key = LoginController.secretkey;
					List<RopeMakingModel> ropeMakingList = (List<RopeMakingModel>) request.getAttribute("ropeLists");	
				
				%>
			 <div class="page-content fade-in-up">
                <div class="ibox">
                    <div class="ibox-head">
                        <div class="ibox-title"></div>
                    </div>
                    <div class="ibox-body">
                        <table class="table table-striped table-bordered table-hover" id="example-table" cellspacing="0" width="100%">
								<thead>
									<tr>
										<th>Sl.No</th>
										<th>Place of activity</th>
										<th>BIN No.</th>
										<th>Crop Year</th>
										<th>Basis</th>
										<th>Jute Variety</th>
										<th>Rope Made</th>
										<th>Rope Used</th>
										<th>Rope Balance</th>
										
										<th></th>
									</tr>
								</thead>
								<tbody>
									<% 
									int i= 1;
							for(RopeMakingModel ropeMakingListing : ropeMakingList){
        						String encryptedid = Encry.encrypt(String.valueOf(ropeMakingListing.getRpmrefid()),key);

							%>
									<tr>
										<td><%=i%></td>
										<td><%=ropeMakingListing.getPlaceofactivity()%></td>
										<td><%=ropeMakingListing.getBinno()%>
									    <td><%=ropeMakingListing.getCropyr()%>
										<td><%=ropeMakingListing.getBasis()%></td>
										<td><%=ropeMakingListing.getJutevariety()%>
										<td><%=ropeMakingListing.getRopemade()%></td>
										<td><%=ropeMakingListing.getRopeused()%></td>
										<td><%=ropeMakingListing.getRope_balance()%></td>
										<td><a href="editRopemaking.obj?id=<%=encryptedid%>" class="btn btn-warning btn-sm btn-block">  <i class="fa fa-pencil" aria-hidden="true" style="font-size: 15px;"></i></a></td>
										<td><a onclick="return confirm('Are you sure you want to delete this item?');" href="deleteRopemaking.obj?id=<%=ropeMakingListing.getRpmrefid()%>" class="btn btn-danger btn-sm btn-block">  <i class="fa fa-trash" aria-hidden="true" style="font-size: 15px;"></i></a></td>
										
										<%-- <td><%=bnaList.getEnable()==1?"Active":"Inactive"%></td>
	<td><a href="bnaDelete.obj?id=<%=bnaList.getId()%>" class="btn btn-danger btn-sm btn-block" onclick="return confirm('Are you sure you want to delete this BNA')">Delete</a></td> --%>
 						 

									</tr>
									<% 
							i++; }
							
							%>
								</tbody>
   
                        </table>
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