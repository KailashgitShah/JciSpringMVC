<!DOCTYPE html>
<html lang="en">
<head>
<script src="./assets/vendors/jquery/dist/jquery.min.js"
	type="text/javascript"></script>
<script src="./assets/vendors/popper.js/dist/umd/popper.min.js"
	type="text/javascript"></script>
<script src="./assets/vendors/bootstrap/dist/js/bootstrap.min.js"
	type="text/javascript"></script>
<script src="./assets/vendors/metisMenu/dist/metisMenu.miR.js"
	type="text/javascript"></script>

</head>
<style>
/* .hidden{
display:none;
} */
body {
	zoom: 85%;
}

.side-menu li a {
	color: #fff;
}

.sidebarleft {
	
}
</style>
<nav class="page-sidebar" id="sidebar"
	style="height: 90%; overflow-y: auto;">
	<div class="page-brand">
		<a class="link" href="#"> <span class="brand"> <span
				class="brand-tip"> <img src="assets/img/logo5.png">
			</span>
		</span> <span class="brand-mini"> <img src="assets/img/logo5.png">
		</span>
		</a>
	</div>
	<div id="sidebar-collapse" class="sidebarleft">
		<div class="admin-block d-flex">
			<div>
				<img style="border-radius: 37px;"
					src="https://placehold.jp/100x100.png" width="45px" />
			</div>

			<div class="admin-info">

				<div class="font-strong">
					Welcome <br> <span style="color: #ffc107;"> <%
 String userpass = (String) request.getSession().getAttribute("userpass");
 String Email = (String) request.getSession().getAttribute("usrname");
 out.println(Email);
 if (Email == null) {
 	//String redirectURL = "http://49.50.79.121:8080/jcicms/index.obj";
 	String redirectURL = "http://localhost:8080/jciadmin/index.obj";
 	response.sendRedirect(redirectURL);

 }
 %>
					</span>


				</div>
			</div>

		</div>

		<ul class="side-menu metismenu">
			<!-- 	<li><a href="dashboard.obj"><i
					class="sidebar-item-icon fa fa-th-large"></i> <span
					class="nav-label">Dashboard</span> </a></li> -->

			<!-- <li><a href="javascript:void(0);"><i
					class="sidebar-item-icon fa fa-th-large"></i> <span
					class="nav-label"> &nbsp;Privileges</span> <i
					class="fa fa-angle-left arrow"></i></a>
				<ul class="nav-2-level ">
					<li class="nav-label" data-pre="1" id="o1"><a
						href="userrole.obj"><b><i
								class="sidebar-item-icon fa fa-th-large"></i>Add Role</b></a></li>
					<li class="nav-label" data-pre="2" id="o2"><a
						href="useraction.obj"><i
							class="sidebar-item-icon fa fa-th-large"></i><b>Add Action</b></a></li>
					<li class="nav-label" data-pre="3" id="o3"><a
						href="userprivilige.obj"><i
							class="sidebar-item-icon fa fa-th-large"></i><b>Add
								Privileges</b></a></li>
					<li class="nav-label" data-pre="4" id="o4"><a href="viewuserrole.obj"><i class="sidebar-item-icon fa fa-th-large"></i><b>View User Role</b></a></li>
					
				</ul></li> -->

			<!-- <li><a href="javascript:void(0);;"><i
					class="sidebar-item-icon fa fa-th-large"></i> <span
					class="nav-label"> &nbsp;User Management</span><i
					class="fa fa-angle-left arrow"></i></a>
				<ul class="nav-2-level">
					<li data-pre="5" id="o5"><a href="UserRegistration.obj"><i
							class="sidebar-item-icon fa fa-th-large"></i><b>User
								Registration</b></a></li>
					<li data-pre="6" id="o6"><a href="viewUserRegistration.obj"><i
							class="sidebar-item-icon fa fa-th-large"></i><b>View User
								Registration</b></a></li>
								<li data-pre="5" id="o5"><a href="millRegisteration.obj"><i
							class="sidebar-item-icon fa fa-th-large"></i><b>Mill Registration
								</b></a></li>
								<li data-pre="5" id="o5"><a href="viewmillRegistration.obj"><i
							class="sidebar-item-icon fa fa-th-large"></i><b>View Mill Registration
								List</b></a></li>
								<li data-pre="5" id="o5"><a href="privacypolicy.obj"><i
							class="sidebar-item-icon fa fa-th-large"></i><b>Privacy policy 
								</b></a></li>

				</ul></li>
			<li><a href="javascript:void(0);;"><i
					class="sidebar-item-icon fa fa-th-large"></i> <span
					class="nav-label"> &nbsp;Farmer Registration</span><i
					class="fa fa-angle-left arrow"></i></a>
				<ul class="nav-2-level">
					<li  data-pre="7" id="o7"><a  href="FarmerRegistration.obj"><i class="sidebar-item-icon fa fa-th-large"></i><b>Farmer Registration</b></a></li>
					<li data-pre="8" id="o8"><a href="ViewFarmerRegistration.obj"><i
							class="sidebar-item-icon fa fa-th-large"></i><b>View Farmer
								List Reg</b></a></li>
				</ul></li>

			<li><a href="javascript:void(0);"><i
					class="sidebar-item-icon fa fa-th-large"></i> <span
					class="nav-label"> &nbsp;Market Arrival</span> <i
					class="fa fa-angle-left arrow"></i></a>
				<ul class="nav-2-level ">
										<li  data-pre="9" id="o9"><a href="rulingMarketForm.obj"><i class="sidebar-item-icon fa fa-th-large"></i><b>Ruling Market Rate at DPC</b></a></li>
					<li data-pre="10" id="o10"><a href="viewmarketArrival.obj"><i
							class="sidebar-item-icon fa fa-th-large"></i><b>View Ruling
								Market List</b></a></li>
					<li data-pre="11" id="o11"><a href="jbaRate.obj"><i
							class="sidebar-item-icon fa fa-th-large"></i><b>JBA Rate</b></a></li>
					<li data-pre="12" id="o12"><a href="JbaPriceList.obj"><i
							class="sidebar-item-icon fa fa-th-large"></i><b>JBA List</b></a></li>
				</ul></li>

			<li><a href="javascript:void(0);"><i
					class="sidebar-item-icon fa fa-th-large"></i> <span
					class="nav-label"> &nbsp;Raw Jute Procurement</span> <i
					class="fa fa-angle-left arrow"></i></a>
				<ul class="nav-2-level ">
					<li data-pre="13" id="o13"><a href="mspPriceCalculation.obj"><i
							class="sidebar-item-icon fa fa-th-large"></i><b>Enter Minimum
								Support Price </b></a></li>
					<li data-pre="14" id="o14"><a
						href="commercialPriceCalculation.obj"><i
							class="sidebar-item-icon fa fa-th-large"></i><b>Commercial
								Ceiling Price Intimation </b></a></li>
										<li data-pre="15" id="o15"><a href="rawJutePaymentAndProcurement.obj"><i class="sidebar-item-icon fa fa-th-large"></i><b>Raw Jute Procurement & Payment</b></a></li>	
										<li data-pre="16" id="o16"><a href="dailyPurchaseConf.obj"><i class="sidebar-item-icon fa fa-th-large"></i><b>Daily Purchase Confirmation</b></a></li>
					<li data-pre="17" id="o15"><a
						href="Distributionoftallyslips.obj"><i
							class="sidebar-item-icon fa fa-th-large"></i><b>Distribution
								of tally Slip</b></a></li>
					<li data-pre="18" id="o18"><a href="mspGradesPriceList.obj"><i
							class="sidebar-item-icon fa fa-th-large"></i><b>View MSP </b></a></li>
					<li data-pre="19" id="o19"><a
						href="viewCommercialCeilingPrice.obj"><i
							class="sidebar-item-icon fa fa-th-large"></i><b>View
								Commercial Ceiling Price Intimation</b></a></li>
					<li data-pre="20" id="o20"><a href="tallyapproval.obj"><i
							class="sidebar-item-icon fa fa-th-large"></i><b>Verification
								of Tally Slip</b></a></li>
					<li data-pre="21" id="o74"><a
						href="viewVerifiedTallySlipList.obj"><i
							class="sidebar-item-icon fa fa-th-large"></i><b>RO Finance
								Verification of Tally Slip</b></a></li>
					<li data-pre="53" id="o53"><a
						href="viewVerifiedTallySlipList_RM.obj"><i
							class="sidebar-item-icon fa fa-th-large"></i><b>RM Payment
								Process of Tally Slip</b></a></li>
					<li data-pre="54" id="o54"><a
						href="viewVerifiedTallySlipList_ZM.obj"><i
							class="sidebar-item-icon fa fa-th-large"></i><b>HO Payment
								Process of Tally Slip</b></a></li>
					<li data-pre="22" id="o22"><a href="disputedtallyslip.obj"><i
							class="sidebar-item-icon fa fa-th-large"></i><b>Disputed
								Tally Slip</b></a></li>
					<li data-pre="55" id="o55"><a href="tallyListRMA.obj"><i
							class="sidebar-item-icon fa fa-th-large"></i><b>RM Purchase
								Date Approval- Tally Slip</b></a></li>
					<li data-pre="23" id="o23"><a href="dailyPurchaseList.obj"><i
							class="sidebar-item-icon fa fa-th-large"></i><b>Daily
								Purchase List</b></a></li>
					<li data-pre="24" id="o24"><a
						href="viewDistributionoftallyslips.obj"><i
							class="sidebar-item-icon fa fa-th-large"></i><b>View
								Distribution of Tally Slip</b></a></li>
					<li data-pre="59" id="o75"><a href="SearchTally.obj"><i
							class="sidebar-item-icon fa fa-th-large"></i><b>Tally Slip
								Status</b></a></li>
					<li data-pre="58" id="o58"><a
						href="verifiedHoldTallySlipList.obj"><i
							class="sidebar-item-icon fa fa-th-large"></i><b>F & A Hold
								Tally Slip List</b></a></li>
					<li data-pre="76" id="o76"><a href="uploadexcelsheet.obj"><i
							class="sidebar-item-icon fa fa-th-large"></i><b>Upload
								Payment Excel Sheet</b></a></li>
				</ul></li>
			<li><a href="javascript:void(0);"><i
					class="sidebar-item-icon fa fa-th-large"></i> <span
					class="nav-label"> &nbsp;Progress of Assortment</span> <i
					class="fa fa-angle-left arrow"></i></a>
				<ul class="nav-2-level ">
					<li data-pre="25" id="o25"><a href="balePreparation.obj"><i
							class="sidebar-item-icon fa fa-th-large"></i><b>Bale
								Preparation</b></a></li>
					<li data-pre="26" id="o26"><a href="viewbalePreparation.obj"><i
							class="sidebar-item-icon fa fa-th-large"></i> <b>View Bale
								Preparation</b></a></li>
										<li  data-pre="27" id="o27"><a href="addRopeMaking.obj"><i class="sidebar-item-icon fa fa-th-large"></i><b>Rope Making</b></a></li>
					<li data-pre="28" id="o28"><a href="ropeMakingListing.obj"><i
							class="sidebar-item-icon fa fa-th-large"></i><b>View Rope
								Making</b></a></li>

				</ul></li>

			<li><a href="javascript:void(0);"><i
					class="sidebar-item-icon fa fa-th-large"></i> <span
					class="nav-label">&nbsp;BIN Performance Calculation</span> <i
					class="fa fa-angle-left arrow"></i></a>
				<ul class="nav-2-level ">
					<li data-pre="29" id="o29"><a href="bin.obj"><i
							class="sidebar-item-icon fa fa-th-large"></i><b>Batch
								Identification Number</b></a></li>
					<li data-pre="30" id="o30"><a href="binList.obj"><i
							class="sidebar-item-icon fa fa-th-large"></i><b>BIN List</b></a></li>
					<li data-pre="31" id="o31"><a href="binPurchasemapping.obj"><i
							class="sidebar-item-icon fa fa-th-large"></i><b>BIN Purchase
								Mapping</b></a></li>
					<li data-pre="32" id="o32"><a href="fingain.obj"><i
							class="sidebar-item-icon fa fa-th-large"></i><b>FinGainAnd
								WeightGain</b></a></li>
					<li data-pre="33" id="o33"><a href="BinListfromDb.obj"><i
							class="sidebar-item-icon fa fa-th-large"></i><b>BIN Gain List</b></a></li>

				</ul></li> -->

			<li><a href="javascript:void(0);;"><i
					class="sidebar-item-icon fa fa-th-large"></i> <span
					class="nav-label"> &nbsp;Mill Registration</span><i
					class="fa fa-angle-left arrow"></i></a>
				<ul class="nav-2-level">

					<li data-pre="5" id="o5"><a href="millRegisteration.obj"><i
							class="sidebar-item-icon fa fa-th-large"></i><b>Mill
								Registration </b></a></li>
					<li data-pre="5" id="o5"><a href="viewmillRegistration.obj"><i
							class="sidebar-item-icon fa fa-th-large"></i><b>View Mill
								Registration List</b></a></li>

					<li data-pre="5" id="o5"><a href="privacypolicy.obj"><i
							class="sidebar-item-icon fa fa-th-large"></i><b>Privacy
								policy </b></a></li>

				</ul></li>

			<li><a href="javascript:void(0);"><i
					class="sidebar-item-icon fa fa-th-large"></i> <span
					class="nav-label">&nbsp;Contract</span> <i
					class="fa fa-angle-left arrow"></i></a>
				<ul class="nav-2-level">
					<li data-pre="1107" id="o1107"><a href="pcsoRequestLetter.obj"><i
							class="sidebar-item-icon fa fa-th-large"></i><b>Generation of
								PCO Request Letter</b> </a></li>
					<li data-pre="1108" id="o1108"><a
						href="pcsoRequestLetterList.obj"><i
							class="sidebar-item-icon fa fa-th-large"></i><b> PCO Request
								Letter List</b> </a></li>
					<li data-pre="1109" id="o1109"><a href="entryofpcso.obj"><i
							class="sidebar-item-icon fa fa-th-large"></i><b>Entry of PCO</b>
					</a></li>
					<li data-pre="1110" id="o1110"><a href="pcsolist.obj"><i
							class="sidebar-item-icon fa fa-th-large"></i><b>PCO List</b></a></li>
					<li data-pre="1111" id="o1111"><a
						href="entry_derivativeprice.obj"><i
							class="sidebar-item-icon fa fa-th-large"></i><b>Entry of
								Derivative Price</b></a></li>
					<li data-pre="1112" id="o1112"><a
						href="entryderivativepricelist.obj"><i
							class="sidebar-item-icon fa fa-th-large"></i><b>Derivative
								Price List</b></a></li>
					<!-- 	<li data-pre="" id=""><a href="entry_gradecomposition.obj"><i
							class="sidebar-item-icon fa fa-th-large"></i><b>Entry of
								Grade Composition</b></a></li> -->
					<!-- <li data-pre="" id=""><a href="entrygradecompositionlist.obj"><i
							class="sidebar-item-icon fa fa-th-large"></i><b>List of Grade
								Composition</b></a></li> -->
					<li data-pre="1136" id="o1136"><a
						href="contractgenerationPCSOWise.obj"><i
							class="sidebar-item-icon fa fa-th-large"></i><b>Contract
								Generation PCO Wise</b></a></li>
					<!--  <li data-pre="39" id="o39"><a
						href="contractgenerationMillWise.obj"><i
							class="sidebar-item-icon fa fa-th-large"></i><b>Contract
								Generation Mill Wise</b></a></li> -->
					<li data-pre="1137" id="o1137"><a
						href="viewcontractgeneration.obj"><i
							class="sidebar-item-icon fa fa-th-large"></i><b>Contract
								Generation List</b></a></li>
					<li data-pre="1138" id="o1138"><a href="authorization.obj"><i
							class="sidebar-item-icon fa fa-th-large"></i><b>Authorization</b></a></li>
					<li data-pre="1139" id="o1139"><a href="viewmillAcc.obj"><i
							class="sidebar-item-icon fa fa-th-large"></i><b>Mill
								Acceptence List</b></a></li>
				</ul></li>


			<li><a href="javascript:void(0);"><i
					class="sidebar-item-icon fa fa-th-large"></i> <span
					class="nav-label">&nbsp;Payment Arrangement</span> <i
					class="fa fa-angle-left arrow"></i></a>
				<ul class="nav-2-level ">

					<li data-pre="1113" id="o1113"><a
						href="EntryofPaymentDetails.obj"><i
							class="sidebar-item-icon fa fa-th-large"></i><b>Entry of
								payment Details</b></a></li>
					<li data-pre="1114" id="o1114"><a
						href="viewPaymentEntryDetails.obj"><i
							class="sidebar-item-icon fa fa-th-large"></i><b>View User
								Payment list</b></a></li>








					<!-- <li data-pre="41" id="o41"><a href="entryofpayment.obj"><i
							class="sidebar-item-icon fa fa-th-large"></i><b>Entry of
								payment instrument</b></a></li> -->

					<!-- 	<li data-pre="42" id="o42"><a href="HOdispatch.obj"><i
							class="sidebar-item-icon fa fa-th-large"></i><b>HO Dispatch
								Instruction</b></a></li> -->
					<!-- 	<li data-pre="43" id="o43"><a href="entryofsale.obj"><i
							class="sidebar-item-icon fa fa-th-large"></i><b>Entry of Sale</b></a></li> -->
					<!-- <li data-pre="44" id="o44"><a href="uploadingreceipt.obj"><i
							class="sidebar-item-icon fa fa-th-large"></i><b>Uploading of

								receipt</b></a></li> -->



				</ul></li>

			<li><a href="javascript:void(0);"><i
					class="sidebar-item-icon fa fa-th-large"></i> <span
					class="nav-label">8.&nbsp;Issue financial concurrence</span> <i
					class="fa fa-angle-left arrow"></i></a>
				<ul class="nav-2-level ">
					<li data-pre="1115" id="o1115"><a href="viewPaymentForFC.obj"><i
							class="sidebar-item-icon fa fa-th-large"></i><b>View FC
								Payment list</b></a></li>
					<li data-pre="1116" id="o1116"><a
						href="viewFinancialConcurence.obj"><i
							class="sidebar-item-icon fa fa-th-large"></i><b>View
								Financial Concuerence list</b></a></li>

				</ul></li>

			<li><a href="javascript:void(0);"><i
					class="sidebar-item-icon fa fa-th-large"></i> <span
					class="nav-label">&nbsp;Dispatch Instruction HO</span> <i
					class="fa fa-angle-left arrow"></i></a>
				<ul class="nav-2-level ">

					<li data-pre="1099" id="o1099"><a href="HOdispatchInst.obj"><i
							class="sidebar-item-icon fa fa-th-large"></i><b>HO Dispatch
								Instruction</b></a></li>

					<li data-pre="1100" id="o1100"><a href="jcilist.obj"><i
							class="sidebar-item-icon fa fa-th-large"></i><b>View HO
								Dispatch </b></a></li>

				</ul></li>

			<li><a href="javascript:void(0);"><i
					class="sidebar-item-icon fa fa-th-large"></i> <span
					class="nav-label">&nbsp;Dispatch Instruction RO</span> <i
					class="fa fa-angle-left arrow"></i></a>
				<ul class="nav-2-level ">

					<li data-pre="1101" id="o1101"><a
						href="roDispatchInstruction.obj"><i
							class="sidebar-item-icon fa fa-th-large"></i><b>Ro Dispatch
								Instruction</b></a></li>
					<li data-pre="1102" id="o1102"><a href="roDispatchList.obj"><i
							class="sidebar-item-icon fa fa-th-large"></i><b>Ro Dispatch
								List</b></a></li>

				</ul></li>

			<li><a href="javascript:void(0);"><i
					class="sidebar-item-icon fa fa-th-large"></i> <span
					class="nav-label">&nbsp;Dispatch Menu(BOS)</span> <i
					class="fa fa-angle-left arrow"></i></a>
				<ul class="nav-2-level ">
					<li data-pre="1117" id="o1117"><a
						href="viewDispatchChallan.obj"><i
							class="sidebar-item-icon fa fa-th-large"></i><b>Listing Of
								Dispatch Details</b></a></li>
					<li data-pre="1118" id="o1118"><a
						href="ViewofGenerationBillsupply.obj"><i
							class="sidebar-item-icon fa fa-th-large"></i><b>View of

								Generation Bill of supply</b></a></li>

				</ul></li>
			<li><a href="javascript:void(0);"><i
					class="sidebar-item-icon fa fa-th-large"></i> <span
					class="nav-label">&nbsp;Verification of Weightment Slip</span> <i
					class="fa fa-angle-left arrow"></i></a>
				<ul class="nav-2-level ">


					<li data-pre="1103" id="o1103"><a
						href="WeightmentSlipList.obj"><i
							class="sidebar-item-icon fa fa-th-large"></i><b>Weightment
								Slip</b></a></li>
				</ul></li>





			<li><a href="javascript:void(0);"><i
					class="sidebar-item-icon fa fa-th-large"></i> <span
					class="nav-label">&nbsp;Generation Of Credit Notes</span> <i
					class="fa fa-angle-left arrow"></i></a>
				<ul class="nav-2-level ">

					<li data-pre="1119" id="o1119"><a
						href="generationOfCreditNoteList.obj"><i
							class="sidebar-item-icon fa fa-th-large"></i><b>Generation of
								Credit Notes</b></a></li>

					<li data-pre="1120" id="o1120"><a href="creditNoteList.obj"><i
							class="sidebar-item-icon fa fa-th-large"></i><b>All Credit
								Notes </b></a></li>
				</ul></li>

			<li><a href="javascript:void(0);"><i
					class="sidebar-item-icon fa fa-th-large"></i> <span
					class="nav-label">&nbsp;Mill Receipt</span> <i
					class="fa fa-angle-left arrow"></i></a>
				<ul class="nav-2-level ">
					<li data-pre="1121" id="o1121"><a
						href="EntryofMillreceipt.obj"><i
							class="sidebar-item-icon fa fa-th-large"></i><b>Entry of Mill
								Receipt</b></a></li>
					<li data-pre="1122" id="o1122"><a href="viewMillReciept.obj"><i
							class="sidebar-item-icon fa fa-th-large"></i><b>View of Mill
								Receipt</b></a></li>
				</ul></li>






			<li><a href="javascript:void(0);"><i
					class="sidebar-item-icon fa fa-th-large"></i> <span
					class="nav-label">&nbsp;Claim Settlement</span> <i
					class="fa fa-angle-left arrow"></i></a>
				<ul class="nav-2-level ">

					<li data-pre="1123" id="o1123"><a href="viewmnominalform.obj"><i
							class="sidebar-item-icon fa fa-th-large"></i><b>Nomination of
								Officials for Claim Settlement</b></a></li>
					<li data-pre="1124" id="o1124"><a href="viewlistnominal.obj"><i
							class="sidebar-item-icon fa fa-th-large"></i><b>View
								Nomination of Officials for Claim Settlement</b></a></li>
					<li data-pre="1104" id="o1104"><a
						href="entryofConfirmationSettelment.obj"><i
							class="sidebar-item-icon fa fa-th-large"></i><b>Entry of
								Confirmation of Claim Settlement Report </b></a></li>
					<li data-pre="1105" id="o1105"><a
						href="ViewConfirmationsettelment.obj"><i
							class="sidebar-item-icon fa fa-th-large"></i><b>View of
								Confirmation of Claim Settlement Report </b></a></li>

					<li data-pre="1106" id="o1106"><a href="verifyClaimReport.obj"><i
							class="sidebar-item-icon fa fa-th-large"></i><b>Verify Claim
								Report </b></a></li>
					<li data-pre="o1141" id="1141"><a href="verifyMillClaim.obj"><i
							class="sidebar-item-icon fa fa-th-large"></i><b>Mill
								Settlement Acceptance</b></a></li>
					<li data-pre="" id=""><a
						href="creditNoteForClaimSettlement.obj"><i
							class="sidebar-item-icon fa fa-th-large"></i><b>Credit Note
								For Claim Settlement </b></a></li>

					<li data-pre="" id=""><a href="creditNoteSettlementList.obj"><i
							class="sidebar-item-icon fa fa-th-large"></i><b>Credit Note
								Settlement List </b></a></li>
				</ul></li>

			<li><a href="javascript:void(0);"><i
					class="sidebar-item-icon fa fa-th-large"></i> <span
					class="nav-label">&nbsp; Demand Note</span> <i
					class="fa fa-angle-left arrow"></i></a>
				<ul class="nav-2-level ">
					<li data-pre="1127" id="o1127"><a
						href="EntryofGenrationDeamandNote.obj"><i
							class="sidebar-item-icon fa fa-th-large"></i><b>Entry of
								Generation demand Note</b></a></li>
					<li data-pre="1128" id="o1128"><a
						href="viewGenrationdemandNote.obj"><i
							class="sidebar-item-icon fa fa-th-large"></i><b>View
								Generation demand Note list</b></a></li>
					<li data-pre="1130" id="o1130"><a
						href="viewCash_against_Dispatch_document.obj"><i
							class="sidebar-item-icon fa fa-th-large"></i><b> Cash Against
								Dispatch document</b></a></li>
					<li data-pre="1130" id="o1130"><a href="viewtopSheet.obj"><i
							class="sidebar-item-icon fa fa-th-large"></i><b>View Cash
								Against Dispatch document</b></a></li>
					<li data-pre="1131" id="o1131"><a
						href="viewCash_against_LCs.obj"><i
							class="sidebar-item-icon fa fa-th-large"></i><b>View Against
								LCs list</b></a></li>

					<li data-pre="1131" id="o1131"><a href="documentListing.obj"><i
							class="sidebar-item-icon fa fa-th-large"></i><b>DocumentListing</b></a></li>


				</ul></li>

			<li><a href="javascript:void(0);"><i
					class="sidebar-item-icon fa fa-th-large"></i> <span
					class="nav-label">&nbsp;TDS Entry</span> <i
					class="fa fa-angle-left arrow"></i></a>
				<ul class="nav-2-level ">

					<li data-pre="1132" id="o1132"><a href="entryoftds.obj"><i
							class="sidebar-item-icon fa fa-th-large"></i><b> Entry of TDS
								U/s 194Q Declaration </b></a></li>
					<li data-pre="1133" id="o1133"><a href="viewentryoftds.obj"><i
							class="sidebar-item-icon fa fa-th-large"></i><b> View Entry
								of TDS U/s 194Q Declaration </b></a></li>
				</ul></li>


			<li><a href="javascript:void(0);"><i
					class="sidebar-item-icon fa fa-th-large"></i> <span
					class="nav-label">&nbsp;Settlement of Credit and Debit note</span>
					<i class="fa fa-angle-left arrow"></i></a>
				<ul class="nav-2-level ">

					<li data-pre="1134" id="o1134"><a href="settlementcndn.obj"><i
							class="sidebar-item-icon fa fa-th-large"></i><b> Settlement
								Of Credit And Debit Notes</b></a></li>
					<li data-pre="1134" id="o1134"><a href="viewlistCnAndDn.obj"><i
							class="sidebar-item-icon fa fa-th-large"></i><b>View
								Settlement Of Credit And Debit Notes</b></a></li>

				</ul></li>
				
				<li><a href="javascript:void(0);"><i
					class="sidebar-item-icon fa fa-th-large"></i> <span
					class="nav-label">&nbsp;Payment Realisation</span>
					<i class="fa fa-angle-left arrow"></i></a>
				<ul class="nav-2-level ">

					<li data-pre="1135" id="o1135"><a
						href="uploadPaymentRealizationDisDetails.obj"><i
							class="sidebar-item-icon fa fa-th-large"></i><b>Uploading of
								Payment Realization / Disbursal Details</b></a></li>

                           	<li data-pre="1135" id="o1135"><a
						href="viewpaymentRealisation.obj"><i
							class="sidebar-item-icon fa fa-th-large"></i><b>
								View Uploaded Payment Realization / Disbursal Details</b></a></li>
                           

				</ul></li>
				
					<li><a href="javascript:void(0);"><i
					class="sidebar-item-icon fa fa-th-large"></i> <span
					class="nav-label">&nbsp;Report</span>
					<i class="fa fa-angle-left arrow"></i></a>
				<ul class="nav-2-level ">

					<li data-pre="1135" id="o1135"><a
						href="viewconlidateReort.obj"><i
							class="sidebar-item-icon fa fa-th-large"></i><b>Consolidate Report
								</b></a></li>

                           

				</ul></li>
		</ul>

	</div>


	<script>
 
		$(document).ready(function() {

			var passuser = '<%=userpass%>
			';
							//alert(passuser);
							$.ajax({
								url : "checksessionpass.obj",
								type : "GET",
								async : false,
								success : function(result) {
									var updatedpass = jQuery.parseJSON(result);
									if (updatedpass != passuser) {
										window.location.href = "index.obj";
									}
								}
							});
							for (var i = 1; i <= 100; i++) {
								$("#o" + i).hide();

							}
							//alert("yes");
							var roleid =
	<%=(int) request.getSession().getAttribute("roleId")%>
		;
							//alert(roleid);
							var userAction = new Array();
							var allActions = new Array();
							$
									.get(
											'userpriviligeajax.obj',
											{
												roleId : roleid
											},
											function(responseText) {

												var text = responseText
														.replace("[", "")
														.replace("]", "");
												userAction = text.split(",");
												//	alert("userAction >>>>> "+ userAction);

												$
														.ajax({
															url : "userpriviligeajaxallData.obj",
															type : "GET",
															success : function(
																	result) {
																var data = jQuery
																		.parseJSON(result);
																allActions = result
																		.split(",");
																//	alert("allActions >>>>> "+ allActions);

																$
																		.each(
																				allActions,
																				function(
																						key,
																						value) {

																					var keys = value
																							.split(":")[0]
																							.replace(
																									'["',
																									"")
																							.replace(
																									'"',
																									"");
																					values = value
																							.split(":")[1]
																							.replace(
																									'"]',
																									"")
																							.replace(
																									'"',
																									"");
																					//	console.log("keys"+ keys);
																					//	console.log("values "+values);

																					for (var j = 0; j < userAction.length; j++) {
																						for (var i = 0; i <= 100; i++) {
																							if ($(
																									"#o"
																											+ i)
																									.data(
																											"pre") == userAction[j]) {
																								//console.log(userAction[j]);
																								$(
																										"#o"
																												+ i)
																										.show();
																							}
																						}
																					}

																				});
															}

														});
											});

							//var one = $("#one").data("pre");
							//var one= this.getAttribute("data-pre");
							//alert(one);

						});
	</script>
	<!-- <div class="foter-bottom">
		<div>
			<img src="assets/img/icon1.png" class="sidebar-item-icon"><span>Logout</span>
		</div>
	</div> -->
	<!-- foter-bottom -->
</nav>
</html>