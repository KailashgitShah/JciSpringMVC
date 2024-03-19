<%@page import="java.util.HashMap"%>
<%@page import="java.util.List"%>
<%@page import="java.io.File"%>

<%@page import="com.jci.model.CommercialJuteVarietyModel"%>

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
                <h1 class="page-title">View Commercial Ceiling Price</h1>
                 
            </div>
				
				<%
					List<CommercialJuteVarietyModel> commercialList = (List<CommercialJuteVarietyModel>) request.getAttribute("commercialList");	
					//System.out.println("====== "+commercialList);
				%>
			 <div class="page-content fade-in-up">
                <div class="ibox">               
                    <div class="ibox-body">
                      <div class="scrollmenu">
                        <table class="table table-striped table-bordered table-hover" id="example-table" cellspacing="0" width="100%">
								<thead>
									<tr>
										<th>Sl.No</th>
										<th>DPC Code</th>
										<th>Date of Entry</th>
									    <th>Date of Effect</th>
									    <th>Crop Yr</th>
										<th>Jute Variety</th> 										
										<th>Ceiling Quantity</th>
										<th>Grade 1</th>
										<th>Grade 2</th>
										<th>Grade 3</th>
										<th>Grade 4</th>
										<th>Grade 5</th>
										<th>Grade 6</th>
										<th>Grade 7</th>
										<th>Grade 8</th>
									
										
									</tr>
								</thead>
								<tbody>
									<% 
									int i= 1;
									
									for( CommercialJuteVarietyModel CommercialCeilingPriceList : commercialList){
									%>
									<tr>
										<td><%=i%></td>
										
										<td style="white-space: normal;"><%=CommercialCeilingPriceList.getDpcname()%></td>
										<td><%=CommercialCeilingPriceList.getCreated_on()%></td>
										<td><%=CommercialCeilingPriceList.getEffectDate()%></td>
										<td><%=CommercialCeilingPriceList.getCrop_yr()%></td>
										<td><%=CommercialCeilingPriceList.getJute_variety()%></td>
										<td><%=CommercialCeilingPriceList.getCqty()%></td>
										<td><%=CommercialCeilingPriceList.getGrade1()%></td>
										<td><%=CommercialCeilingPriceList.getGrade2()%></td>
										<td><%=CommercialCeilingPriceList.getGrade3()%></td>
										<td><%=CommercialCeilingPriceList.getGrade4()%></td>
										<td><%=CommercialCeilingPriceList.getGrade5()%></td>
										<td><%=CommercialCeilingPriceList.getGrade6()%></td>
										<td><%=CommercialCeilingPriceList.getGrade7()%></td>
										<td><%=CommercialCeilingPriceList.getGrade8()%></td>
										<!--  <td><a href="editcommercialprice.obj?id=<%=CommercialCeilingPriceList.getId()%>" class="btn btn-warning btn-sm btn-block"><i class="fa fa-pencil" aria-hidden="true" style="font-size: 15px;"></i></a></td>
										<td><a onclick="return confirm('Are you sure you want to delete this item?');" href="deletecommercialprice.obj?id=<%=CommercialCeilingPriceList.getId()%>" class="btn btn-danger btn-sm btn-block">  <i class="fa fa-trash" aria-hidden="true" style="font-size: 15px;"></i></a></td>
									-->
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
