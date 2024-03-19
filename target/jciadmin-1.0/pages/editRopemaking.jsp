<!DOCTYPE html>
<html lang="en">
<%@page import="com.jci.model.RopeMakingModel"%>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width initial-scale=1.0">
    <title>JCI | CMS</title>
    <!-- GLOBAL MAINLY STYLES-->
    <link href="./assets/vendors/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet" />
    <link href="./assets/vendors/font-awesome/css/font-awesome.min.css" rel="stylesheet" />
    <link href="./assets/vendors/themify-icons/css/themify-icons.css" rel="stylesheet" />
    <script src="./assets/vendors/jquery/dist/jquery.min.js" type="text/javascript"></script>
    <script src="./assets/vendors/popper.js/dist/umd/popper.min.js" type="text/javascript"></script>
    <script src="./assets/vendors/bootstrap/dist/js/bootstrap.min.js" type="text/javascript"></script>
    <script src="./assets/vendors/metisMenu/dist/metisMenu.min.js" type="text/javascript"></script>
    <script src="./assets/vendors/jquery-slimscroll/jquery.slimscroll.min.js" type="text/javascript"></script>
    <!-- PLUGINS STYLES-->
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
                <h1 class="page-title">Update Rope Making</h1>
            </div>
            
            <%
            	RopeMakingModel ropeMakingModel = (RopeMakingModel)request.getAttribute("editRopemaking");
			%>
			      <% 
                
            String dpcCenter = (String) session.getAttribute("dpc_center");
            String dpcid = (String) session.getAttribute("dpcId");
            String region_id = (String) session.getAttribute("region");
            int refid2 = (int)session.getAttribute("refId");
                
            %>
            <div class="page-content fade-in-up">
                <div class="row">
                    <div class="col-md-11">
                        <div class="ibox">
                            <span>${msg}</span>
                            <div class="ibox-body">
                                <form action="updateRopeMakingMid.obj" method="POST">
                                    <div class="row">
                                        <!-- <div class="col-sm-4 form-group">
                                            <label>Report Date</label>
                                            <input class="form-control" type="date" name="datereport" placeholder="Report Date" required>
                                        </div> -->
                                         <div class="col-sm-4 form-group">
  <label>Place of activity</label>
<input class="form-control"  type="text" placeholder="Place of Purchase" value="<%=dpcCenter%>" onkeyup="deleteErrorMsg()" oninput="javascript: if (this.value.length > 4) this.value = this.value.slice(0, 4);" readonly>
      <input class="form-control" name="dpcid" id="dpcid" type="hidden" value="<%=dpcid%>" >
      <input class="form-control" name="region_id" id="region_id" type="hidden" value="<%=region_id%>" >
            <input class="form-control" name="refid" id="refid" type="hidden" value="<%=refid%>" >
            <input class="form-control" name="id" id="id" type="hidden" value="<%=ropeMakingModel.getRpmrefid()%>" >
            
     </div>
                                        <div class="col-sm-4 form-group">
                                            <label>Bin Number</label> 
											<input class="form-control" id="binno" name="binno" type="number" placeholder="Bin Number" value="<%=ropeMakingModel.getBinno()%>" required onkeyup="checkLen()">
                                        </div>
                                        <div class="col-sm-4 form-group">
											<label>Crop Year</label> 
											<select name="cropyr" id="cropyr" class="form-control">
	
                                        	<option <%if(ropeMakingModel.getCropyr().equals("2021-2022")){out.print("selected");} %> value="2021-2022">2021-2022</option>
											<option <%if(ropeMakingModel.getCropyr().equals("2022-2023")){out.print("selected");} %> value="2022-2023">2022-2023</option>
											<option <%if(ropeMakingModel.getCropyr().equals("2023-2024")){out.print("selected");} %> value="2023-2024">2023-2024</option>
											<option <%if(ropeMakingModel.getCropyr().equals("2024-2025")){out.print("selected");} %> value="2024-2025">2024-2025</option>
											<option <%if(ropeMakingModel.getCropyr().equals("2025-2026")){out.print("selected");} %> value="2025-2026">2025-2026</option>
											<option <%if(ropeMakingModel.getCropyr().equals("2026-2027")){out.print("selected");} %> value="2026-2027">2026-2027</option>
											<option <%if(ropeMakingModel.getCropyr().equals("2027-2028")){out.print("selected");} %> value="2027-2028">2027-2028</option>
											<option <%if(ropeMakingModel.getCropyr().equals("2028-2029")){out.print("selected");} %> value="2028-2029">2028-2029</option>
											<option <%if(ropeMakingModel.getCropyr().equals("2029-2030")){out.print("selected");} %> value="2029-2030">2029-2030</option>
											<option <%if(ropeMakingModel.getCropyr().equals("2030-2031")){out.print("selected");} %> value="2030-2031">2030-2031</option>
											
											</select>
										</div>
										</div>
										<div class="row">
										<div class="col-sm-4 form-group">
                                            <label>Basis</label>
                                            <select name="basis" id="basis" class="form-control" value="<%=ropeMakingModel.getBasis()%>">
                                          <option <%if(ropeMakingModel.getBasis().equals("msp")){out.print("selected");} %> value="msp">MSP</option>
												<option <%if(ropeMakingModel.getBasis().equals("commercial")){out.print("selected");} %> value="commercial">Commercial</option>
                                        	 </select>
                                        </div>
                               
                                    
                                    
                                       <%--  <div class="col-sm-4 form-group">
                                             <label>Place of activity</label>
                                        	 <select name="placeofactivity" id="placeofactivity" class="form-control">
                                            	<%
                                            		String[] str;
	                                            	for(int i=0; i<allDpcList.size() ; i++){
	                                            		str = allDpcList.get(i).split("-");
	                                            %>
	                                            	<option value="<%=str[0]%>"><%=str[1]%></option>
	                                            <% 
	                                            	}
	                                            %>		
                                             </select>
                                        </div> --%>
                                       
										
                                        <div class="col-sm-4 form-group">
                                             <label>Jute Variety</label>
                                        <!-- <input class="form-control" name="jutevariety" type="text" placeholder="Jute Variety" required> -->
	                                        <select name="jutevariety" id="jutevariety" class="form-control">
	                                    
												<option <%if(ropeMakingModel.getJutevariety().equals("Bimli")){out.print("selected");} %> value="Bimli">Bimli</option>
												<option <%if(ropeMakingModel.getJutevariety().equals("Mesta")){out.print("selected");} %> value="Mesta">Mesta</option>
												<option <%if(ropeMakingModel.getJutevariety().equals("Tossa")){out.print("selected");} %> value="Tossa">Tossa</option>
												<option <%if(ropeMakingModel.getJutevariety().equals("White")){out.print("selected");} %> value="White">White</option>
												<option <%if(ropeMakingModel.getJutevariety().equals("Tossa (New)")){out.print("selected");} %> value="Tossa (New)">Tossa (New)</option>
												<option <%if(ropeMakingModel.getJutevariety().equals("White (New)")){out.print("selected");} %> value="White (New)"">White (New)"</option>
	                                        </select>
                                        </div>
                                        <div class="col-sm-4 form-group">
											<label>Rope made</label>
                                        	<input class="form-control" name="ropemade" id="ropemade" type="number" placeholder="Rope made"  value="<%=ropeMakingModel.getRopemade()%>">
										</div>
										</div>
										   <div class="row">
										<div class="col-sm-4 form-group">
											<label>Rope Used</label>
                                        	<input class="form-control" name="ropeUsed" id="ropeUsed" type="number" placeholder="Rope Used" onblur="calculateRope()" value="<%=ropeMakingModel.getRopeused()%>">
										</div>
                                    

                                 
 										<div class="col-sm-4 form-group">
											<label>Balance</label>
                                        	<input class="form-control" name="balance" id="balance"  type="number" placeholder="Rope balance" value = "<%=ropeMakingModel.getRope_balance()%>" readonly>
										</div>
                                    </div>                                    
                                    <div class="form-group col-sm-12">
                                        <button class="btn btn-default" type="submit">Submit</button>
                                    </div>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <!-- END PAGE CONTENT-->
            <%@ include file="footer.jsp"%>
        </div>
    </div>
        <script>
	$("#basis").on("change", function() {
		var msp_no;
		var variety = (this.value);	
		if(variety=="msp"){
			msp_no = 1;
		}
		else if(variety=="commercial"){
			msp_no = 2;
		}
		$.ajax({
			type:"GET",
			url:"findJuteOnBasis.obj",
			data:{"msp_no":msp_no},
			success:function(result){
 				   var data= jQuery.parseJSON(result);
	 					 var html = "<option disabled selected value>-Select-</option>";
 				     for (var i = 0; i< data.length; i++){
 				    	 var sar = data[i]
 					 html += "<option value="+sar+">"+data[i]+"</option>"			
 				  } 
 				$("#jutevariety").html(html);
			}			
		});
	});
	</script>
	<script>
	function calculateRope(){
		var ropeMade = document.getElementById("ropemade").value;
		var ropeUsed = document.getElementById("ropeUsed").value;
		ropeBalance = ropeMade - ropeUsed;
		if(ropeBalance > 0){
			document.getElementById("balance").value = ropeBalance;
		}else{
			alert("Please enter valid rope values");
			return false;
		}
	}
	</script>
	<script>
	function checkLen(){
		var binnumber = document.getElementById("binno").value;
		if(binnumber.toString().length == 3){
			// alert("hell");
			$("#binno").prop("type", "text");
			$("#binno").attr("maxlength", "3");
			$("#binno").attr("minlength", "1");
		}
	}
	</script>
    
    <div class="sidenav-backdrop backdrop"></div>
     
    <!-- END PAGA BACKDROPS-->
    <!-- CORE PLUGINS-->
    <!-- PAGE LEVEL PLUGINS-->
    <!-- CORE SCRIPTS-->
    <script src="assets/js/app.min.js" type="text/javascript"></script>
    <!-- PAGE LEVEL SCRIPTS-->
</body>
</html>