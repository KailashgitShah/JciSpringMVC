<%@page import="com.jci.model.RawJuteProcurementAndPayment"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.List"%>
<%@page import="java.io.File"%>
<%@page import="com.jci.model.VerifyTallySlip"%>

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
.param{
font-size: 20px;
font-family: monospace;
font-weight: bold;
color: black;
}
.frstentry{
font-size: 16px;
font-family: Poppins; 
color: maroon;
}
.secentry{
font-size: 16px;
font-family: Poppins; 
color: blue;
}
.error{
font-size: 16px;
font-family: monospace; 
color: red;
}
</style>
 <script src="https://code.jquery.com/jquery-1.11.3.min.js" type="text/javascript"></script>  
 <script src="https://cdn.datatables.net/1.10.9/js/jquery.dataTables.min.js" type="text/javascript"></script>  
 <link rel="stylesheet" href="https://cdn.datatables.net/1.10.9/css/jquery.dataTables.min.css" />  
 
 <script type="text/javascript">
	$(document).ready(function ()  
	{  
		// $("#verifiedlist").DataTable({         
	         //scrollX: true,
	       //  "pageLength": 50
	      // }); 
	});  
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
                <h1 class="page-title">Disputed Tally Slip</h1>
                 
            </div>
				
				<%
					List<VerifyTallySlip> verificationList = (List<VerifyTallySlip>) request.getAttribute("verifyTallySliList");
				VerifyTallySlip vrf = (VerifyTallySlip)request.getAttribute("vrftally");
				RawJuteProcurementAndPayment raw = (RawJuteProcurementAndPayment)request.getAttribute("raw");
				//System.out.print(raw.getSlip_image());
				%>
			 <!-- <div class="page-content fade-in-up"> -->
               <!--  <div class="ibox">
                    <div class="ibox-body"> -->
                    <!-- <div class="scrollmenu"> -->
                    <div class="table-responsive" style="margin-top: 20px;"> 
                         <table id="verifiedlist"  class="table table-striped table-bordered table-hover" cellspacing="0" width="100%">
								<thead>
									<tr>
									     <th>Parametrs</th>
									    <th>DPC level Entry</th>
										<th>DEO level Entry</th>
										<th>Reason</th>
										 
							</tr>
								</thead>
								<tbody>
									 
									<tr> 
									<td class="param" > Tally No. </td> 
									<td class="frstentry"> <%=raw.getTallyslipno() %></td> 
									<td class="secentry"> <%=vrf.getTallyNo() %> </td> 
									<%if(vrf.getErrors().contains("Tally")){ %> 
									<td class="error"> <%=vrf.getErrors() %>  </td>
									<%}else{ %>
									<td>  </td>
									<%} %>
									</tr>
									
									<tr> 
									<td class="param"> Farmer Regno </td> 
									<td class="frstentry"> <%=raw.getFarmerregno() %></td> 
									<td class="secentry"> <%=vrf.getFarmerRegNo() %> </td> 
									<%if(vrf.getErrors().contains("Farmer")){ %> 
									<td class="error"> <%=vrf.getErrors() %>  </td>
									<%}else{ %>
									<td>  </td>
									<%} %>
									</tr>
									
									<tr> 
									<td class="param"> Purchase date </td>
									 <td class="frstentry"> <%=raw.getDatepurchase() %></td> 
									 <td class="secentry"> <%=vrf.getPuchasedate() %> </td> 
								     <%if(vrf.getErrors().contains("Date")){ %> 
									<td class="error"> <%=vrf.getErrors() %>  </td>
									<%}else{ %>
									<td>  </td>
									<%} %>
								     </tr>
									
									<tr> 
									<td class="param"> Rate Slip No. </td> 
									<td class="frstentry"> <%=raw.getRateslipno()%></td> 
									<td class="secentry"> <%=vrf.getRateslipno()%> </td> 
									<%if(vrf.getErrors().contains("Rate")){ %> 
									<td class="error"> <%=vrf.getErrors() %>  </td>
									<%}else{ %>
									<td>  </td>
									<%} %>
									</tr>
									
									<tr> 
									<td class="param"> Bin No. </td> 
									<td class="frstentry"> <%=raw.getBinno() %></td> 
									<td class="secentry"> <%=vrf.getBinno()%> </td> 
									<%if(vrf.getErrors().contains("Bin")){ %> 
									<td class="error"> <%=vrf.getErrors() %>  </td>
									<%}else{ %>
									<td>  </td>
									<%} %>
									 </tr>
									
									<tr> 
									<td class="param"> Jute Variety </td> 
									<td class="frstentry"> <%=raw.getJutevariety()%></td> 
									<td class="secentry"> <%=vrf.getJutevariety()%> </td> 
									<%if(vrf.getErrors().contains("Jute")){ %> 
									<td class="error"> <%=vrf.getErrors() %>  </td>
									<%}else{ %>
									<td>  </td>
									<%} %>
									</tr>
									
									<tr> 
									<td class="param"> NetQuantity</td> 
									<td class="frstentry"> <%=raw.getNetquantity() %></td> 
									<td class="secentry"> <%=vrf.getNetquantity() %> </td> 
									<%if(vrf.getErrors().contains("Net")){ %> 
									<td class="error"> <%=vrf.getErrors() %>  </td>
									<%}else{ %>
									<td>  </td>
									<%} %>
									</tr>
									
									<tr> 
									<td class="param"> Garsat Rate</td> 
									<td class="frstentry"> <%=raw.getGrasatrate() %></td> 
									<td class="secentry"> <%=vrf.getGarsatrate() %></td>
									<%if(vrf.getErrors().contains("Garsat")){ %> 
									<td class="error"> <%=vrf.getErrors() %>  </td>
									<%}else{ %>
									<td>  </td>
									<%} %>
									</tr>
									
									
									
									<tr> 
									<td class="param"> Amt Payable </td>
									 <td class="frstentry"> <%=raw.getAmountpayable() %></td> 
									 <td class="secentry"> <%=vrf.getAmountpayable() %> </td> 
									 <%if(vrf.getErrors().contains("Amount")){ %> 
									<td class="error"> <%=vrf.getErrors() %>  </td>
									<%}else{ %>
									<td>  </td>
									<%} %>
									  </tr>
									
									<tr> 
									<td class="param"> Place of Purchase </td> 
									<td class="frstentry"> <%=raw.getPlaceofpurchase() %></td> 
									<td class="secentry"> <%=vrf.getPlaceOfPurchase() %> </td> 
									<%if(vrf.getErrors().contains("Place")){ %> 
									<td class="error"> <%=vrf.getErrors() %>  </td>
									<%}else{ %>
									<td>  </td>
									<%} %>
									
									<tr> 
									<td class="param"> Gross qty </td> 
									<td class="frstentry"> <%=raw.getGrossquantity() %></td> 
									<td class="secentry"> <%=vrf.getGrossqty() %> </td>
									<%if(vrf.getErrors().contains("Gross")){ %> 
									<td class="error"> <%=vrf.getErrors() %>  </td>
									<%}else{ %>
									<td>  </td>
									<%} %>
									 </tr>
									
								</tbody>
   
                        </table>
                                   <div class="row" style="margin-left: 350px;">
										<button class="btn btn-default" type="submit" id="approve" value = <%=raw.getTallyslipno() %> style="margin-left: 15px; width: 256px;
                                        background: mediumseagreen;
                                        color: white;">Process for Financial Concurrence</button>
                                        
                                        <button class="btn btn-default" type="submit" id="decline" value = <%=raw.getTallyslipno() %> style="margin-left: 15px;  width: 221px;
                                        background: red;
                                        color: white;">Refer to DPCM for correction</button>
									</div>
                        </div>
                    <!-- </div>
                </div>
                 
            </div> -->
            
            
            <div class="doremon" style="margin-top: 60px; padding: 25px; width: 100%; ">
               
               
               		<div class="text-details">	
               		 <div class="mandt">
		            <label class="center" style="color: red; ">Tally Slip Image</label>
		            </div>	            
		            <img width="100%" src="http://49.50.79.121:8080/TallySlip/<%=raw.getSlip_image()%>"/>
		           
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
  
</body>

<script type="text/javascript">
$(document).ready(function(){
	 $("#approve").click(function(){
		 var tally = $("#approve").val();
		 $.ajax({
				type:"GET",
				url:"rmapproval.obj",
				data:jQuery.param({"tallyno":tally ,"status" :"FA", "verified":1}),
				success:function(result){
					if(result=="true")
						{
						alert("Succesfully Updated");
						location.reload();
						//window.history.back();
					//	window.location.href = "disputedtallyslip.obj";
						}
					else
						{
						alert("Updation Failed !!");
						}
				//	$("#msg").html("<div class=\"alert alert-success\"><b>Success !</b> Record saved successfully.</div>\r\n");
					 
					//alert("Result Saved Succesfully");
	 				//var data= jQuery.parseJSON(result);
	 				 
				}			
			});
		 
	 });
});
	 
</script>

<script type="text/javascript">
$(document).ready(function(){
	 $("#decline").click(function(){
		 var tally = $("#decline").val();
		 $.ajax({
				type:"GET",
				url:"rmapproval.obj",
				data:jQuery.param({"tallyno":tally ,"status" :"DPCW", "verified":0}),
				success:function(result){
					if(result=="true")
						{
						alert("Succesfully Updated");
						//location.reload();
						//window.history.back();
						window.location.href = "disputedtallyslip.obj";
						}
					else
						{
						alert("Updation Failed !!");
						}
				//	$("#msg").html("<div class=\"alert alert-success\"><b>Success !</b> Record saved successfully.</div>\r\n");
					 
					//alert("Result Saved Succesfully");
	 				//var data= jQuery.parseJSON(result);
	 				 
				}			
			});
		 
	 });
});
	 
</script>

</html>
