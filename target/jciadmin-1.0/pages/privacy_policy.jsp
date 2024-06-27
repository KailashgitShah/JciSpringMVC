<%@page import="com.jci.model.JciDIHoModel"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.List"%>
<%@page import="java.io.File"%>
<%@page import="com.jci.model.RoleMasterModel"%>
<%@page import="com.jci.model.ZoneModel"%>

<%@page import="com.jci.model.UserRegistrationModel"%>

<%@page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">

<head>

<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width initial-scale=1.0">
<title>JCI | CMS</title>
<!-- GLOBAL MAINLY STYLES-->
<link href="./assets/vendors/bootstrap/dist/css/bootstrap.min.css"
	rel="stylesheet" />
<link href="./assets/vendors/font-awesome/css/font-awesome.min.css"
	rel="stylesheet" />
<link href="./assets/vendors/themify-icons/css/themify-icons.css"
	rel="stylesheet" />
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<!-- PLUGINS STYLES-->
<link href="./assets/vendors/DataTables/datatables.min.css"
	rel="stylesheet" />
<!-- THEME STYLES-->
<link href="assets/css/main.min.css" rel="stylesheet" />
<!-- PAGE LEVEL STYLES-->
<script type="text/javascript">
	$(document).ready(function() {
		$("#farmerVerific").DataTable({
			scrollX : true,
			"pageLength" : 50
		});
	});
</script>
 <style>
        body {
            font-size: 18px; /* Adjust the base font size as needed */
            line-height: 1.6; /* Adjust the line height for readability */
            font-family: Arial, sans-serif; /* Choose a suitable font */
        }
        h2, h3, h4 {
            font-size: 24px; /* Increase the size of headings */
            font-weight: bold; /* Make headings bold */
            margin-top: 1.5em; /* Add spacing above headings */
        }
        p, ul, li {
            margin-bottom: 1em; /* Add spacing below paragraphs and lists */
        }
        strong {
            font-weight: bold; /* Make strong elements bold */
        }
        sup {
            font-size: 0.8em; /* Adjust the size of superscript text */
        }
    </style>
    <style>
        body {
            font-family: Arial, sans-serif; /* Choose a suitable font */
            font-size: 16px; /* Adjust the base font size as needed */
            line-height: 1.6; /* Adjust the line height for readability */
            color: #333; /* Set default text color */
        }
        h2, h3, h4 {
          /*   color: blue; */ /* Set the color of headings to blue */
           color: #5DADE2 ;
        }
    </style>
    <style>
        /* Define a CSS class for red text */
        .red-text {
            color: red;
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
				<h1 class="page-title">Privacy Policy Page
					</h1>

			</div>


			<div class="page-content fade-in-up">
				<div class="ibox">
					<span>${msg}</span>
					<div class="ibox-body">
					<body>
<p>
    <strong class="large-text">Privacy  Policy</strong>
</p>
<p>
    This  Privacy Policy describes Our policies and procedures on the
    collection, use and  disclosure of Your information when You use the Service
    and tells You about  Your privacy rights and how the law protects You.
</p>
<p>
    We  use Your Personal data to provide and improve the Service. By using the
    Service, You agree to the collection and use of information in accordance
    with  this Privacy Policy. 
   
    <p>
    This Privacy Policy has been created with the help of the
    <a href="https://www.freeprivacypolicy.com/free-privacy-policy-generator/">
        Free Privacy  Policy Generator.
    </a>
   
<h2>
    Interpretation and  Definitions
</h2>
<h3>
    Interpretation
</h3>
<p>
    The  words of which the initial letter is capitalized have meanings defined
    under  the following conditions. The following definitions shall have the
    same meaning  regardless of whether they appear in singular or in plural.
</p>
<h3>
    Definitions
</h3>
<p>
    For  the purposes of this Privacy Policy:
</p>
<p>
    <strong>Account</strong> means a unique account created  for You to access
    our Service or parts of our Service.
</p>
<p>
    <strong>Application</strong> refers  to .............., the software program
    provided by the Company.
</p>
<p>
    <strong>Company</strong> (referred  to as either "the Company", "We", "Us"
    or  "Our" in this Agreement) refers to The Jute Corporation of India
    Limited, 15N, Nellie Sengupta Sarani 7 <sup>th</sup> Floor Kolkata 700087.
</p>
<p>
    <strong>Country</strong> refers to:  West Bengal, India
</p>
<p>
    <strong>Device</strong> means any  device that can access the Service such
    as a computer, a cellphone or a digital  tablet.
</p>
<p>
    <strong>Personal Data</strong> is  any information that relates to an
    identified or identifiable individual.
</p>
<p>
    <strong>Service</strong> refers to  the Application.
</p>
<p>
    <strong>Service Provider</strong> means any natural or legal person who
    processes the data on behalf of the  Company. It refers to third-party
    companies or individuals employed by the  Company to facilitate the Service,
    to provide the Service on behalf of the  Company, to perform services
    related to the Service or to assist the Company in  analyzing how the
    Service is used.
</p>
<p>
    <strong>Usage Data</strong> refers  to data collected automatically, either
    generated by the use of the Service or  from the Service infrastructure
    itself (for example, the duration of a page  visit).
</p>
<p>
    <strong>You</strong> means the individual accessing or  using the Service,
    or the company, or other legal entity on behalf of which  such individual is
    accessing or using the Service, as applicable.
</p>
<h2>
    Collecting and  Using Your Personal Data
</h2>
<h3>
    Types of Data  Collected
</h3>
<h4>
    Personal Data
</h4>
<p>
    While  using Our Service, We may ask You to provide Us with certain
    personally  identifiable information that can be used to contact or identify
    You.  Personally identifiable information may include, but is not limited
    to:
</p>
<p>
    Name
</p>
<p>
    Caste
</p>
<p>
    Gender
</p>
<p>
    Aadhar / Voter Id
</p>
<p>
    Phone number
</p>
<p>
    Address, State, Province, ZIP/Postal code, City
</p>
<p>
    Bank A/c No.
</p>
<p>
    Bank A/c Type
</p>
<p>
    Bank Name
</p>
<p>
    Bank Branch
</p>
<p>
    Bank IFSC
</p>
<p>
    Bank Document
</p>
<p>
    Bank  Mandate
</p>
<h4>
    Information  Collected while Using the Application
</h4>
<p>
    While  using Our Application, in order to provide features of Our
    Application, We may  collect, with Your prior permission:
</p>
<p>
    Information  regarding your location
</p>
<p>
    Pictures  and other information from your Device's camera and photo library
</p>
<p>
    We  use this information to provide features of Our Service, to improve and
    customize Our Service. The information may be uploaded to the Company's
    servers  and/or a Service Provider's server or it may be simply stored on
    Your device.
</p>
<p>
    You  can enable or disable access to this information at any time, through
    Your  Device settings.
</p>
<h3>
    Use of Your  Personal Data
</h3>
<p>
    The  Company may use Personal Data for the following purposes:
</p>
<p>
    <strong>To provide and maintain our Service</strong>,  including to monitor
    the usage of our Service.
</p>
<!-- <p>
    <strong>For business transfers:</strong> We may use Your  information for
    bank transfers.
</p> -->
<p>
 <strong class="red-text">For business transfers:</strong> 
        <!-- Apply inline style to the <span> for red color -->
        <span style="color: red;">We may use Your information for bank transfers.</span></p>
<p>
    <strong>For other purposes</strong>: We may use Your  information for other
    purposes, such as data analysis, identifying usage  trends, determining the
    effectiveness of our promotional campaigns and to  evaluate and improve our
    Service, products, services, marketing, and your  experience.
</p>
<h3>
    Retention of Your  Personal Data
</h3>
<p>
    The  Company will retain Your Personal Data only for as long as is necessary
    for the  purposes set out in this Privacy Policy. We will retain and use
    Your Personal  Data to the extent necessary to comply with our legal
    obligations (for example,  if we are required to retain your data to comply
    with applicable laws), resolve  disputes, and enforce our legal agreements
    and policies.
</p>
<p>
    The  Company will also retain Usage Data for internal analysis purposes.
    Usage Data  is generally retained for a shorter period of time, except when
    this data is  used to strengthen the security or to improve the
    functionality of Our Service,  or We are legally obligated to retain this
    data for longer time periods.
</p>
<h3>
    Transfer of Your  Personal Data
</h3>
<p>
    Your  information, including Personal Data, is processed at the Company's
    operating  offices and in any other places where the parties involved in the
    processing  are located. It means that this information may be transferred
    to - and  maintained on - computers located outside of Your state, province,
    country or  other governmental jurisdiction where the data protection laws
    may differ than  those from Your jurisdiction.
</p>
<p>
    Your  consent to this Privacy Policy followed by Your submission of such
    information  represents Your agreement to that transfer.
</p>
<p>
    The  Company will take all steps reasonably necessary to ensure that Your
    data is  treated securely and in accordance with this Privacy Policy and no
    transfer of  Your Personal Data will take place to an organization or a
    country unless there  are adequate controls in place including the security
    of Your data and other  personal information.
</p>
<h3>
    Delete Your  Personal Data
</h3>
<p>
    You  have the right to delete or request that We assist in deleting the
    Personal Data  that We have collected about You.
</p>
<p>
    Our  Service may give You the ability to delete certain information about
    You from  within the Service.
</p>
<p>
    You  may update, amend, or delete Your information at any time by signing in
    to Your  Account, if you have one, and visiting the account settings section
    that allows  you to manage Your personal information. You may also contact
    Us to request  access to, correct, or delete any personal information that
    You have provided  to Us.
</p>
<p>
    Please  note, however, that We may need to retain certain information when
    we have a  legal obligation or lawful basis to do so.
</p>
<h3>
    Disclosure of Your  Personal Data
</h3>
<h4>
    Business  Transactions
</h4>
<p>
    If  the Company is involved in a merger, acquisition or asset sale, Your
    Personal  Data may be transferred. We will provide notice before Your
    Personal Data is  transferred and becomes subject to a different Privacy
    Policy.
</p>
<h4>
    Law enforcement
</h4>
<p>
    Under  certain circumstances, the Company may be required to disclose Your
    Personal  Data if required to do so by law or in response to valid requests
    by public  authorities (e.g. a court or a government agency).
</p>
<h4>
    Other legal  requirements
</h4>
<p>
    The  Company may disclose Your Personal Data in the good faith belief that
    such  action is necessary to:
</p>
<ul>
    <li>
        Comply with a legal obligation
    </li>
</ul>

<ul>
    <li>
        Protect and defend the rights or property of the  Company
    </li>
</ul>
<ul>
    <li>
        Prevent or investigate possible wrongdoing in  connection with the
    Service
    </li>
</ul>
<ul>
    <li>
        Protect the personal safety of Users of the  Service or the public
    </li>
</ul>
<ul>
    <li>
        Protect against legal liability
    </li>
</ul>
<h3>
    Security of Your  Personal Data
</h3>
<p>
    The  security of Your Personal Data is important to Us, but remember that no
    method  of transmission over the Internet, or method of electronic storage
    is 100%  secure. While We strive to use commercially acceptable means to
    protect Your  Personal Data, We cannot guarantee its absolute security.
</p>
<h2>
    Changes to this  Privacy Policy
</h2>
<p>
    We  may update Our Privacy Policy from time to time. We will notify You of
    any  changes by posting the new Privacy Policy on this page.
</p>
<p>
    We  will let You know via email and/or a prominent notice on Our Service,
    prior to  the change becoming effective and update the "Last updated" date
    at  the top of this Privacy Policy.
</p>
<p>
    You  are advised to review this Privacy Policy periodically for any changes.
    Changes  to this Privacy Policy are effective when they are posted on this
    page.
</p>
<h2>
    Contact Us
</h2>
<p>
    If  you have any questions about this Privacy Policy, You can contact us:
</p>
<p>
    By  email: saumyadeep@jcimail.in
</p>
<p>
    By  mail: 15N, Nellie Sengupta Sarani 7 <sup>th</sup> Floor Kolkata 700087
</p>
</body>
						
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
	<script src="./assets/vendors/jquery/dist/jquery.min.js"
		type="text/javascript"></script>
	<script src="./assets/vendors/popper.js/dist/umd/popper.min.js"
		type="text/javascript"></script>
	<script src="./assets/vendors/bootstrap/dist/js/bootstrap.min.js"
		type="text/javascript"></script>
	<script src="./assets/vendors/metisMenu/dist/metisMenu.min.js"
		type="text/javascript"></script>
	<script
		src="./assets/vendors/jquery-slimscroll/jquery.slimscroll.min.js"
		type="text/javascript"></script>
	<!-- PAGE LEVEL PLUGINS-->
	<script src="./assets/vendors/DataTables/datatables.min.js"
		type="text/javascript"></script>
	<!-- CORE SCRIPTS-->
	<script src="assets/js/app.min.js" type="text/javascript"></script>
	<!-- PAGE LEVEL SCRIPTS-->
	<script type="text/javascript">
		$(function() {
			$('#example-table').DataTable({

				fixedHeader : true

			//"ajax": './assets/demo/data/table_data.json',
			/*"columns": [
			    { "S": "name" },
			    { "data": "office" },
			    { "data": "extn" },
			    { "data": "start_date" },
			    { "data": "salary" }
			] */
			});
		})
	</script>
</body>

</html>


