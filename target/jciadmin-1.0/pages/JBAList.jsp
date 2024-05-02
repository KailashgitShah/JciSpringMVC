<%@page import="java.util.HashMap"%>
<%@page import="java.util.List"%>
<%@page import="java.io.File"%>

<%@page import="com.jci.model.JbaModel"%>
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
                <h1 class="page-title">JBA  Details</h1>
            </div>
				<%
				 String key = LoginController.secretkey;
					List<JbaModel> jbapri = (List<JbaModel>) request.getAttribute("jbaList");	
				List<JbaModel> jbapril = (List<JbaModel>) request.getAttribute("jbaLists");	
				%>
			 <div class="page-content fade-in-up">
                <div class="ibox">
                    <div class="ibox-body">
                    	<span>${msg}</span>
                        <table class="table table-striped table-bordered table-hover" id="example-table" cellspacing="0" width="100%">
								<thead>
									<tr>
										<th>Sl.No</th>
										<th>Date</th>
										<th>Jute Variety</th>
										<th>Crop Year</th>
										<th>Area code</th> 
										<th>Created on</th> 	
										<th>Edit</th>
										<th>Delete</th>									
									</tr>
								</thead>
								<tbody>
									<% 
									int i= 1;
							for(JbaModel jbaList : jbapri){
						           String encryptedid = Encry.encrypt(String.valueOf(jbaList.getId()),key);

							%>
									<tr>
										<td><%=i%></td>
										<td><%=jbaList.getJbaDate()%></td>
										<td><%=jbaList.getJutevariety()%></td>
										 <td><%=jbaList.getCropyr()%>
										<td><%=jbaList.getAreaName()%></td> 
										<td><%=jbaList.getCreateddate()%></td> 
									    <td><a onClick="EditBtn_click('<%=jbaList.getId()%>','<%=encryptedid%>')" class="btn btn-warning btn-sm btn-block"><i class="fa fa-pencil" aria-hidden="true" style="font-size: 15px;"></i></a></td>
										<td><a href="JbaDelete.obj?id=<%=jbaList.getId()%>" onclick="return confirm('Are you sure you want to delete this item?');"><i class="btn btn-danger btn-sm btn-block"><i class="fa fa-trash" aria-hidden="true" style="font-size: 15px;"></i></a></td>
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
    <script>
    function EditBtn_click(id,encryptid) {
        //alert(encryptid);
        $.ajax({
    		url:"RouteEditforCheck.obj",
    		type : 'GET',
    		data : {
    			id : id
    		},
    		success : function(data) {				 
    			//alert(data);
    			if(data>7){
    				alert('JBA List is not editable after 7 Days');
    			}else{
    				window.open("editJBAList.obj?id="+encryptid,"_self")

    			}
    			//$("#TotalL2pending").html(data);
    		}
    	});
    }  
    </script>
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