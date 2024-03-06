package com.jci.controller;
import org.apache.log4j.LogManager;
import com.jci.model.MSPPriceCalculationModel;
import com.jci.model.RulingMarket;
import com.jci.model.BatchIdentificationModel;
import com.jci.model.BinListFromDbDTO;
import com.jci.model.BinPurchaseMappingDTO;
import com.jci.model.CommercialJuteVarietyModel;
import com.jci.model.VerifyTallySlip;
import com.jci.model.DistributionoftallyslipModel;
import com.jci.model.CommercialCeilingPriceIntimationModel;
import com.jci.model.VerifyFarmerModel;
import com.jci.model.FarmerRegModelDTO;
import com.jci.model.MarketArrivalModel;
import com.jci.model.PaymentprocesstellyslipModel;
import com.jci.model.UserRegistrationModel;
import com.jci.model.UserRoleModel;
import com.jci.model.RoleMasterModel;
import com.jci.model.ZoneModel;
import com.jci.model.ProgOfAssortmentModel;
import com.jci.model.DailyPurchaseConfModel;
import com.jci.model.PurchaseCenterModel;
import com.jci.model.PurchaseRegisterDTO;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.jci.model.RawJuteProcurementAndPayment;
import com.jci.model.RoDetailsModel;
import com.jci.model.JbaModel;
import com.jci.model.AreaDetailCode;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.ParseException;
import com.jci.model.BalePreparation;
import javax.servlet.http.HttpSession;
import java.io.OutputStream;
import java.net.URLDecoder;
import java.io.FileOutputStream;
import java.io.IOException;
import com.jci.model.FarmerRegModel;

import static org.hamcrest.CoreMatchers.nullValue;

import java.io.File;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.google.gson.Gson;
import com.itextpdf.text.pdf.PdfStructTreeController.returnType;
import com.jci.model.SalesModel;
import java.time.temporal.TemporalAccessor;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import com.jci.model.RopeMakingModel;
import java.text.SimpleDateFormat;

import com.jci.common.Encry;
import com.jci.model.AddOrganizationModel;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.RedirectView;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;

import com.jci.model.FarmerRegistrationModel;
import com.jci.model.ImageVerificationModel;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.jci.model.DistrictModel;
import com.jci.model.StateList;
import com.jci.model.PincodeModel;
import com.jci.model.PoliceStationModel;

import java.util.List;
import java.util.Map;
import java.util.Random;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.crypto.SecretKey;
import javax.mail.internet.InternetAddress;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.jci.service.BalePrepareService;
import com.jci.service.PoliceStationService;
import com.jci.service.blockService;
import com.jci.service.Impl.SendMail;
import com.lowagie.text.Chunk;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Element;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import com.jci.service.CommercialJuteVarietyGradesPriceService;
import com.jci.service.MSPPriceCalculationService;
import com.jci.service.RulingMarketService;
import com.jci.service.CommercialCeilingPriceIntimationService;
import com.jci.service.VerifyTallySlipService;
import com.jci.service.DistributionoftallyslipService;
import com.jci.service.VerifyFarmerService;
import com.jci.service.RoleMasterService;
import com.jci.service.PurchaseCenterService;
import com.jci.service.RoDetailsService;
import com.jci.service.ZoneService;
import com.jci.service.MarketArrivalService;
import com.jci.service.ProgOfAssortmentService;
import com.jci.service.DailyPurchaseModelConfService;
import com.jci.service.RawJuteProcurementAndPaymentService;
import com.jci.service.FarmerRegService;
import com.jci.service.SalesService;
import com.jci.service.StateService;
import com.jci.service.UserActionService;
import com.jci.service.UserPriviligeService;
import com.jci.service.AreaService;
import com.jci.service.JBAService;
import com.jci.service.BalePreparationService;
import com.jci.service.DistrictService;
import com.jci.service.BatchIdentificationService;
import com.jci.service.RopeMakingService;
import com.jci.service.AddOrganisationService;
import com.jci.service.FarmerRegistrationService;
import com.jci.service.UserRegistrationService;
import com.jci.service.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;

import com.jci.service.PincodeService;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.hssf.record.crypto.Biff8EncryptionKey;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.commons.io.FileUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;

@Controller
public class InsertDataController
{
    private static int count;
    private final String farmerUpload = "E:\\Program Files\\Apache Software Foundation\\Tomcat 8.5\\webapps\\FarmerRegistration\\";
    String slipUpload;
    String mendate;
    private static Logger logger;

	@Autowired
	UserActionService useractionservice;
	
	@Autowired
	UserPriviligeService userpriviligeservice;
    @Autowired
    PincodeService pincodeService;
    @Autowired
    UserRegistrationService userRegService;
    @Autowired
    FarmerRegistrationService farmerRegistrationService;
    @Autowired
    AddOrganisationService addOrganisationService;
    @Autowired
    RopeMakingService ropeMakingService;
    @Autowired
    BatchIdentificationService batchService;
    @Autowired
    DistrictService distric;
    @Autowired
    BalePreparationService balepreparationservice;
    @Autowired
    JBAService jbaservice;
    @Autowired
    AreaService areaService;
    @Autowired
    private StateService stateList;
    @Autowired
    SalesService salesService;
    @Autowired
    FarmerRegService farmerRegService;
    @Autowired
    RawJuteProcurementAndPaymentService rawJuteProcurAndPayService;
    @Autowired
    DailyPurchaseModelConfService DailyPurchasefService;
    @Autowired
    ProgOfAssortmentService progOfAssortmentService;
    @Autowired
    MarketArrivalService marketArrivalService;
    @Autowired
    UserRegistrationService UserRegistrationService;
    @Autowired
    ZoneService zoneService;
    @Autowired
    RoDetailsService roService;
    @Autowired
    PurchaseCenterService purchaseCenterService;
    @Autowired
    RoleMasterService roleService;
    @Autowired
    VerifyFarmerService verifyFarmerService;
    @Autowired
    DistributionoftallyslipService distributionoftallyslipService;
    @Autowired
    VerifyTallySlipService verifyTallySlipService;
    @Autowired
    CommercialCeilingPriceIntimationService commercialCeilingPriceIntimationService;
    @Autowired
    RulingMarketService rulingMarketService;
    @Autowired
    BalePreparationService balePreparationService;
    @Autowired
    MSPPriceCalculationService mSPPriceCalculationService;
    @Autowired
    CommercialJuteVarietyGradesPriceService commercialJuteVarietyGradesPriceService;
    @Autowired
    blockService block;
    @Autowired
    PoliceStationService PoliceStationService;
    @Autowired
    BalePrepareService balePrepareService;
    @Autowired
	UserRoleService userroleService;
    
    @Autowired
	private HttpServletRequest request;
    
    public InsertDataController() {
        this.slipUpload = "E:\\Program Files\\Apache Software Foundation\\Tomcat 8.5\\webapps\\TallySlip\\";
        this.mendate = "E:\\Program Files\\Apache Software Foundation\\Tomcat 8.5\\webapps\\FarmerRegistration\\";
        
    }
    
    public int checkprivileges(String pagename) {
    	
    	int i = 0;
    	 try {
	   		   Integer roleId= (Integer)request.getSession().getAttribute("roleId");
	   		   String actionPer = userpriviligeservice.getactionPer(roleId);
	   		   Integer actionid = useractionservice.getactionid(pagename);
	  		   String idAction =  Integer.toString(actionid);
	   		   String[] stringArray  = actionPer.split(",");
	   		   for(String action : stringArray)
	   		   {
	   	   		   if(action.equals(idAction)) 
	   	   		   {
	   	   			 i = 1;  
	   	   		   }
	   		   }

         }   catch(Exception e) {
 		   e.printStackTrace();
 	   }
    	return i;
	}
    
    private boolean isStringValid(String input) {
        String regex = ".*[<>].*";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);
        return matcher.matches();
    }
    @RequestMapping({ "addGrower" })
    
    public ModelAndView Dashboard(final HttpServletRequest request) {
        final ModelAndView mv = new ModelAndView("dashboard");
        return mv;
    }
    
    @RequestMapping({ "ViewGrower" })
    public ModelAndView ViewGrower(final HttpServletRequest request) {
        final ModelAndView mv = new ModelAndView("View_page");
        return mv;
    }
    
    @RequestMapping({ "dashboard" })
   
    public ModelAndView dashboard(final HttpServletRequest request) {
    	 String username =(String)request.getSession().getAttribute("usrname");
        ModelAndView mv = new ModelAndView("dashboard");
        if(username == null) {
            return mv = new ModelAndView("index");
            }
        return mv;
    }
    
    @RequestMapping({ "FarmerRegistration" })
    public ModelAndView FarmerRegistration(final HttpServletRequest request) {
    	String usersession =(String)request.getSession().getAttribute("usrname");
    	ModelAndView mv = new ModelAndView("FarmerRegistration");
        if(usersession == null) {
        return mv = new ModelAndView("index");
        }
        else {
        	try {
        final List<PincodeModel> pincodeList = (List<PincodeModel>)this.pincodeService.getAll();
        final List<StateList> Liststate = (List<StateList>)this.stateList.getAll();
        final List<DistrictModel> DistrictList = (List<DistrictModel>)this.distric.getAll();
        mv.addObject("pincodeList", (Object)pincodeList);
        mv.addObject("Liststate", (Object)Liststate);
        mv.addObject("DistrictList", (Object)DistrictList);
        }
        catch(Exception e) {
        	e.printStackTrace();
        }
        }
        return mv;
        
    }
    @ResponseBody
    @RequestMapping(value = { "validateusername" }, method = { RequestMethod.GET })
    public String validateusername(final HttpServletRequest request) {
        final Gson gson = new Gson();
        return this.UserRegistrationService.validateusername(request.getParameter("username")) + "";
    }
    
    
    @RequestMapping({ "addFarmer" })
    public ModelAndView addFarmer(final HttpServletRequest request) {
    	 String username =(String)request.getSession().getAttribute("usrname");
         ModelAndView mv = new ModelAndView("addFarmer");
        if(username == null) {
            return mv = new ModelAndView("index");
            }
        return mv;
    }
    
    @RequestMapping({ "saveFarmerMid" })
    public ModelAndView saveFarmer(final HttpServletRequest request, final RedirectAttributes redirectAttributes) {
    	 String username =(String)request.getSession().getAttribute("usrname");
    	 if(username == null) {
             return new ModelAndView("index");
             }
    	  else {
        try {
            final String firstname = request.getParameter("firstname");
            final String lastname = request.getParameter("lastname");
            final String mobileno = request.getParameter("mobileno");
            final String useremail = request.getParameter("useremail");
            final int roleid = Integer.parseInt(request.getParameter("roleid"));
            final int orgid = Integer.parseInt(request.getParameter("orgid"));
            final String city = request.getParameter("city");
            final String state = request.getParameter("state");
            final String majorwork = request.getParameter("majorwork");
            String ipAddress = null;
            final String getWay = request.getHeader("VIA");
            ipAddress = request.getHeader("X-FORWARDED-FOR");
            if (ipAddress == null) {
                ipAddress = request.getRemoteAddr();
            }
            final FarmerRegistrationModel farmerRegistration = new FarmerRegistrationModel();
            farmerRegistration.setCity(city);
            farmerRegistration.setCreateddate(new Date());
            farmerRegistration.setEnabled(1);
            farmerRegistration.setFirstname(firstname);
            farmerRegistration.setIpaddress(ipAddress);
            farmerRegistration.setLastname(lastname);
            farmerRegistration.setMajorwork(majorwork);
            farmerRegistration.setMobileno(mobileno);
            farmerRegistration.setOrgid(orgid);
            farmerRegistration.setRoleid(roleid);
            farmerRegistration.setState(state);
            farmerRegistration.setStatus(1);
            farmerRegistration.setUseremail(useremail);
            this.farmerRegistrationService.create(farmerRegistration);
            redirectAttributes.addFlashAttribute("msg", (Object)"<div class=\"alert alert-success\"><b>Success !</b> Record saved successfully.</div>\r\n");
        }
        catch (Exception e) {
            InsertDataController.logger.fatal((Object)e);
        }
       
      
        return new ModelAndView((View)new RedirectView("addFarmer.obj"));
    	  }
    }
    
    @RequestMapping({ "viewFarmerList" })
    public ModelAndView viewFarmerList(final HttpServletRequest request,RedirectAttributes red) {
    	 String username =(String)request.getSession().getAttribute("usrname");
    	 if(username == null) {
             return new ModelAndView("index");
             }
    	 ModelAndView mv = new ModelAndView("ViewFarmer");
    	 String pagename = "viewFarmerList";
         int i = checkprivileges(pagename);
         if(i != 1)
         {
         	 red.addFlashAttribute("errorMessage","Access denied");
 			   return mv=new ModelAndView("Home");
         }
        final List<FarmerRegistrationModel> allFarmersList = (List<FarmerRegistrationModel>)this.farmerRegistrationService.getAll();
        mv.addObject("farmersList", (Object)allFarmersList);
        return mv;
    	
    }
    
    @RequestMapping({ "addOrganisation" })
    public ModelAndView addOrganisation(final HttpServletRequest request) {
    	 String username =(String)request.getSession().getAttribute("usrname");
        ModelAndView mv = new ModelAndView("addOrganisation");
        if(username == null) {
            return mv = new ModelAndView("index");
            }
        return mv;
    }
    
    @RequestMapping({ "addRopeMaking" })
    public ModelAndView addRopeMaking(final HttpServletRequest request,RedirectAttributes red) {
    	 ModelAndView mv = new ModelAndView("ropeMaking");
    	 String username =(String)request.getSession().getAttribute("usrname");
    	 if(username == null) {
             return mv = new ModelAndView("index");
             }
    	 String pagename = "addRopeMaking";
         int i = checkprivileges(pagename);
         if(i != 1)
         {
         	 red.addFlashAttribute("errorMessage","Access denied");
 			   return mv=new ModelAndView("Home");
         }
        return mv;
    }
    
    @RequestMapping({ "allOrganisationList" })
    public ModelAndView allOrganisationList(final HttpServletRequest request) {
        ModelAndView mv = new ModelAndView("organisationLists");
    	String username =(String)request.getSession().getAttribute("usrname");
    	 if(username == null) {
             return mv = new ModelAndView("index");
             }
  
        final List<AddOrganizationModel> organisationList = (List<AddOrganizationModel>)this.addOrganisationService.getAll();
        mv.addObject("organisationLists", (Object)organisationList);
       
        return mv;
    }
    
    @RequestMapping({ "saveOrganizationMid" })
    public ModelAndView saveFarmerMid(final HttpServletRequest request) {
    	String username =(String)request.getSession().getAttribute("usrname");
    	 if(username == null) {
             return new ModelAndView("index");
             }
        try {
            final String organizationtypename = request.getParameter("organizationtypename");
            final String organizationtypedisplayname = request.getParameter("organizationtypedisplayname");
            final String ipaddress = request.getParameter("ipaddress");
            final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
            final AddOrganizationModel addOrganizationModel = new AddOrganizationModel();
            addOrganizationModel.setIpaddress(ipaddress);
            addOrganizationModel.setIs_Active(1);
            addOrganizationModel.setOrganizationtypedisplayname(organizationtypedisplayname);
            addOrganizationModel.setOrganizationtypename(organizationtypename);
            addOrganizationModel.setCreateddate(new Date());
            this.addOrganisationService.create(addOrganizationModel);
        }
        catch (Exception e) {
            System.out.println(e);
        }
       
        return new ModelAndView((View)new RedirectView("addOrganisation.obj"));
    }
    
    @RequestMapping({ "ropeMakingListing" })
    public ModelAndView ropeMaking(final HttpServletRequest request,RedirectAttributes red) {
        ModelAndView mv = new ModelAndView("RopeMakingListing");
    	String username =(String)request.getSession().getAttribute("usrname");
        if(username == null) {
            return mv = new ModelAndView("index");
            }
        String pagename = "ropeMakingListing";
        int i = checkprivileges(pagename);
        if(i != 1)
        {
        	 red.addFlashAttribute("errorMessage","Access denied");
			   return mv=new ModelAndView("Home");
        }
        String placeofactivity =(String)request.getSession().getAttribute("dpcId");
     	String regionId =(String)request.getSession().getAttribute("regionId");
     	String zoneId =(String)request.getSession().getAttribute("zoneId");
   
        final List<RopeMakingModel> ropeList = (List<RopeMakingModel>)this.ropeMakingService.getAll(placeofactivity, regionId,zoneId);
        mv.addObject("ropeLists", (Object)ropeList);
        return mv;
    }
    
    @RequestMapping({ "saveRopeMakingMid" })
    public ModelAndView saveRopeMakingMid(final HttpServletRequest request, final RedirectAttributes redirectAttributes) {
    	String username =(String)request.getSession().getAttribute("usrname");
    	if(username == null) {
            return new ModelAndView("index");
            }
        try {
            final int creadtedby = 0;
            final String basis = request.getParameter("basis");
            final String cropyr = request.getParameter("cropyr");
            final String placeofactivity = request.getParameter("centerordpc");
            final String jutevariety = request.getParameter("jutevariety");
            final String ropemade = request.getParameter("ropemade");
            final String ropeUsed = request.getParameter("ropeUsed");
            final String balance = request.getParameter("balance");
            final String regionId = request.getParameter("region_id");
            final String refid = request.getParameter("refid");
            final String binno = request.getParameter("binno");
            final RopeMakingModel addRopeMaking = new RopeMakingModel();
            final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            final LocalDateTime now = LocalDateTime.now();
            final String date = dtf.format(now);
            addRopeMaking.setBasis(basis);
            addRopeMaking.setBinno(binno);
            addRopeMaking.setCreadtedby(refid);
            addRopeMaking.setRegion(regionId);
            addRopeMaking.setPlaceofactivity(placeofactivity);
            addRopeMaking.setCropyr(cropyr);
            addRopeMaking.setDatereport((new Date()).toString());
            addRopeMaking.setCreadtedby(regionId);
            addRopeMaking.setJutevariety(jutevariety);
            addRopeMaking.setRopemade(ropemade);
            addRopeMaking.setRopeused(ropeUsed);
            addRopeMaking.setRope_balance(balance);
            addRopeMaking.setCreateddate(date);
            final int ropemadeInt = Integer.parseInt(ropemade);
            final int ropeUsedInt = Integer.parseInt(ropeUsed);
            if (ropemadeInt > ropeUsedInt) {
                this.ropeMakingService.create(addRopeMaking);
                redirectAttributes.addFlashAttribute("msg", (Object)"<div class=\"alert alert-success\"><b>Success !</b> Record saved successfully.</div>\r\n");
            }
            else {
                redirectAttributes.addFlashAttribute("msg", (Object)"<div class=\"alert alert-danger\"><b>OOps!</b> Rope made must be greater than rope used. </div>\r\n");
            }
        }
        catch (Exception e) {
            System.out.println(e);
        }
        
        return new ModelAndView((View)new RedirectView("addRopeMaking.obj"));
    }
    
    @RequestMapping({ "jciSales" })
    public ModelAndView jciSales(final HttpServletRequest request) {
    	String username =(String)request.getSession().getAttribute("usrname");
        ModelAndView mv = new ModelAndView("addJciSales");
        if(username == null) {
            return mv = new ModelAndView("index");
            }
        return mv;
    }
    
    @RequestMapping({ "saveSalesMid" })
    public ModelAndView saveSales(final HttpServletRequest request) {
    	String username =(String)request.getSession().getAttribute("usrname");
    	 if(username == null) {
         	return new ModelAndView("index");
             }
        try {
            final int uniqueNumber = Integer.parseInt(request.getParameter("uniqueNumber"));
            final String juteVariety = request.getParameter("jutevariety");
            final String vargradeqty = request.getParameter("vargradeqty");
            final SalesModel salesModel = new SalesModel();
            salesModel.setCreadtedby(1);
            salesModel.setJutevariety(juteVariety);
            salesModel.setUnqno(22);
            salesModel.setVargradeqty(vargradeqty);
            this.salesService.create(salesModel);
        }
        catch (Exception e) {
            System.out.println(e);
        }
       
        return new ModelAndView((View)new RedirectView("addJciSales.obj"));
    }
    
    @RequestMapping({ "farmerRegistration" })
    public ModelAndView farmerRegistration(final HttpServletRequest request) {
    	String username =(String)request.getSession().getAttribute("usrname");
        ModelAndView mv = new ModelAndView("FarmerRegistration");
        mv.addObject("dpcCode", (Object)"0122");
        if(username == null) {
            return mv = new ModelAndView("index");
            }
        return mv;
    }
    
    @ResponseBody
    @RequestMapping(value = { "pIcon" }, method = { RequestMethod.GET })
    public String getFoosBySimplePath(final HttpServletRequest request) {
    	String username =(String)request.getSession().getAttribute("usrname");
        final String str = request.getParameter("F_District");
        final Gson gson = new Gson();
        return gson.toJson((Object)this.distric.getAllFilledPosition(str));
    }
    
    @RequestMapping({ "saveFarmerRegistrationMid" })
    public ModelAndView FarmerRegistrationSave(final HttpServletRequest request, final RedirectAttributes redirectAttributes, @RequestParam("F_ID_PROF") final MultipartFile F_ID_PROF, @RequestParam("F_BANK_DOC") final MultipartFile F_BANK_DOC, @RequestParam("F_REG_FORM") final MultipartFile F_REG_FORM) {
    	String username =(String)request.getSession().getAttribute("usrname");
    	 if(username == null) {
             return new ModelAndView("index");
             }
        final File theDir = new File("E:\\Program Files\\Apache Software Foundation\\Tomcat 8.5\\webapps\\FarmerRegistration\\");
        if (!theDir.exists()) {
            theDir.mkdirs();
        }
        final ModelAndView mv = new ModelAndView();
        try {
        	String dpc= (String)request.getSession().getAttribute("dpcId");
            final String F_NAME = request.getParameter("F_NAME");
            final String M_NAME = request.getParameter("M_NAME");
            final String L_NAME = request.getParameter("L_NAME");
            String farmerName="";
            String mname = "";
            String lname = "";
            final String fname = F_NAME.replaceAll("\\s", "");
            if(!fname.equalsIgnoreCase("") && fname != null)
            farmerName = fname;
            
            if ((M_NAME.isEmpty()) && (!L_NAME.isEmpty())) {
                lname = L_NAME.replaceAll("\\s", "");
                if(!lname.equalsIgnoreCase(""))
                farmerName = farmerName + " "+"NA"+" " + lname;
            }
            else if ((!M_NAME.isEmpty()) && (!L_NAME.isEmpty())) {
                mname = M_NAME.replaceAll("\\s", "");
                lname = L_NAME.replaceAll("\\s", "");
                if(!mname.equalsIgnoreCase(""))
                farmerName = farmerName + " " + mname;
                if(!lname.equalsIgnoreCase(""))
                	farmerName = farmerName + " " + lname;
            }
            else if (!M_NAME.isEmpty() && L_NAME.isEmpty()) {
                mname = M_NAME.replaceAll("\\s", "");
                if(!mname.equalsIgnoreCase(""))
                farmerName = farmerName + " " + mname;
            }
            else if ((M_NAME.isEmpty()) && (L_NAME.isEmpty()) && (!F_NAME.isEmpty()))  {
            	if(!fname.equalsIgnoreCase(""))
                farmerName = fname;
            }
            final String caste = request.getParameter("caste");
            final String gender = request.getParameter("gender");
            final String F_ADDRESS = request.getParameter("F_ADDRESS");
            final String F_ID_PROF_TYPE = request.getParameter("F_ID_PROF_TYPE");
            final String F_ID_PROF_NO = request.getParameter("F_ID_PROF_No");
            final String F_REG_BY = request.getParameter("F_REG_BY");
            final String F_I_CARE_REGISTERED = request.getParameter("F_I_CARE_REGISTERED");
            final String land_holding = request.getParameter("land_holding");
            final String F_MOBILE = request.getParameter("F_MOBILE");
            final String state = request.getParameter("state");
            final String F_District = request.getParameter("F_District");
           // System.out.print(" ...................." + F_District);
            final String F_Block = request.getParameter("F_Block");
            final String F_Pincode = request.getParameter("pincode");
            final String police_station = request.getParameter("policestation");
           // System.out.print(" ...................." + police_station);
            final String F_AC_NO = request.getParameter("F_AC_NO");
            final String bank_ac_type = request.getParameter("bank_ac_type");
            final String F_BANK_NAME = request.getParameter("F_BANK_NAME");
            final String F_BANK_BRANCH = request.getParameter("F_BANK_BRANCH");
            final String F_BANK_IFSC = request.getParameter("F_BANK_IFSC");
            final String F_Address2 = request.getParameter("F_Address2");
            final String duplicateMobiileNo = request.getParameter("dubMobile");
            final boolean duplicateMobiile = Boolean.parseBoolean(duplicateMobiileNo);
            final String fileUpload = F_ID_PROF.getOriginalFilename();
            final String duplicateAccNo = request.getParameter("accNoCheck");
            final boolean accountBool = Boolean.parseBoolean(duplicateAccNo);
            final String F_BANK_DOCupload = F_BANK_DOC.getOriginalFilename();
            final FarmerRegModel farmerRegModel = new FarmerRegModel();
            farmerRegModel.setF_NAME(farmerName);
            farmerRegModel.setCaste(caste);
            farmerRegModel.setGender(gender);
            farmerRegModel.setF_ADDRESS(F_ADDRESS);
            farmerRegModel.setF_ID_PROF_TYPE(F_ID_PROF_TYPE);
            farmerRegModel.setBank_ac_type(bank_ac_type);
            farmerRegModel.setF_ID_PROF_NO(F_ID_PROF_NO);
            farmerRegModel.setF_REG_BY(F_REG_BY);
            farmerRegModel.setF_I_CARE_REGISTERED(F_I_CARE_REGISTERED);
            farmerRegModel.setLand_holding(land_holding);
            farmerRegModel.setF_MOBILE(F_MOBILE);
            farmerRegModel.setF_AC_NO(F_AC_NO);
            farmerRegModel.setF_Pincode(F_Pincode);
            farmerRegModel.setF_STATE(state);
            farmerRegModel.setF_Block(F_Block);
            farmerRegModel.setF_District(F_District);
            farmerRegModel.setPolice_station(police_station);
            farmerRegModel.setBank_ac_type(bank_ac_type);
            farmerRegModel.setF_BANK_NAME(F_BANK_NAME);
            farmerRegModel.setF_BANK_BRANCH(F_BANK_BRANCH);
            farmerRegModel.setF_BANK_IFSC(F_BANK_IFSC);
            farmerRegModel.setF_Address2(F_Address2);
            farmerRegModel.setF_Pincode(F_Pincode);
            farmerRegModel.setIS_VERIFIED(0);
            farmerRegModel.setDpc_id(dpc);
            File file = null;
            String pathurl = "";
           
            final HttpSession session = request.getSession();
            String dpcid = "0000";
            String region = "00";
            if (session.getAttribute("dpcId") != null) {
                dpcid = (String)session.getAttribute("dpcId");
            }
            if (session.getAttribute("region") != null) {
                region = (String)session.getAttribute("region");
            }
         //   System.out.println("session dpc =" + dpcid + " region = " + region);
            if (accountBool && duplicateMobiile) {
                final String regno = this.farmerRegService.findRegno(dpcid, region);
            //    System.out.println("regno = " + regno);
                if (regno != null) {
                    final boolean zero = regno.startsWith("0");
                    final long reg = Long.parseLong(regno) + 1L;
                    if (zero) {
                        farmerRegModel.setF_REG_NO("0" + reg);
                    }
                    else {
                        farmerRegModel.setF_REG_NO("" + reg);
                    }
                }
                else {
                    farmerRegModel.setF_REG_NO(region + dpcid + "00001");
                }
                try {
                    String url = "";
                    if (!F_BANK_DOC.isEmpty()) {
                        file = new File("E:\\Program Files\\Apache Software Foundation\\Tomcat 8.5\\webapps\\FarmerRegistration\\bankdoc_"+farmerRegModel.getF_REG_NO()+"_" + F_BANK_DOC.getOriginalFilename());
                        try {
                            final OutputStream os = new FileOutputStream(file);
                            os.write(F_BANK_DOC.getBytes());
                            os.close();
                        }
                        catch (Exception e) {
                            System.out.println(e.getLocalizedMessage());
                            e.printStackTrace();
                        }
                        pathurl = file.getAbsolutePath();
                        final String path = url = "bankdoc_" +farmerRegModel.getF_REG_NO()+"_" + F_BANK_DOC.getOriginalFilename();
                        farmerRegModel.setF_BANK_DOC(url);
                    }
                    if (!F_ID_PROF.isEmpty()) {
                        file = new File("E:\\Program Files\\Apache Software Foundation\\Tomcat 8.5\\webapps\\FarmerRegistration\\idproof_" +farmerRegModel.getF_REG_NO()+"_" + F_ID_PROF.getOriginalFilename());
                        try {
                            final OutputStream os = new FileOutputStream(file);
                            os.write(F_ID_PROF.getBytes());
                            os.close();
                        }
                        catch (Exception e) {
                            e.printStackTrace();
                        }
                        pathurl = file.getAbsolutePath();
                        final String path = url = "idproof_" +farmerRegModel.getF_REG_NO()+"_" + F_ID_PROF.getOriginalFilename();
                        farmerRegModel.setF_ID_PROF(url);
                    }
                    if (!F_REG_FORM.isEmpty()) {
                        file = new File("E:\\Program Files\\Apache Software Foundation\\Tomcat 8.5\\webapps\\FarmerRegistration\\regform_" +farmerRegModel.getF_REG_NO()+"_" + F_REG_FORM.getOriginalFilename());
                        try {
                            final OutputStream os = new FileOutputStream(file);
                            os.write(F_REG_FORM.getBytes());
                            os.close();
                        }
                        catch (Exception e) {
                            e.printStackTrace();
                        }
                        pathurl = file.getAbsolutePath();
                        final String path = url = "regform_" +farmerRegModel.getF_REG_NO()+"_" + F_REG_FORM.getOriginalFilename();
                        farmerRegModel.setF_REG_FORM(url);
                    }
                }
                catch (Exception e2) {
                    System.out.println(e2);
                    mv.addObject("msg", (Object)"Not Saved please try again");
                }
                this.farmerRegService.create(farmerRegModel);
                redirectAttributes.addFlashAttribute("msg", (Object)"<div class=\"alert alert-success\"><b>Success !</b> Record saved successfully.</div>\r\n");
            }
            else {
                redirectAttributes.addFlashAttribute("msg", (Object)"<div class=\"alert alert-danger\"><b>OOps!</b> Duplicate account number or mobile number or Identitiy Proof Number.</div>\r\n");
            }
        }
        catch (Exception e3) {
            System.out.println(e3);
            redirectAttributes.addFlashAttribute("msg", (Object)"<div class=\"alert alert-danger\"><b>Oops !</b> Error in saving record. Please try again</div>\r\n");
        }
       
        return new ModelAndView((View)new RedirectView("FarmerRegistration.obj"));
    }
    
    @RequestMapping({ "abc" })
    public String abc(final HttpServletRequest request) {
    	
        final String regno = this.farmerRegService.findRegno("0212", "05");
      //  System.out.println("regno = " + regno);
        return null;
    }
    
    @RequestMapping({ "rawJutePaymentAndProcurement" })
    public ModelAndView rawJutePaymentAndProcurement(final HttpServletRequest request) {
    	String username =(String)request.getSession().getAttribute("usrname");
        ModelAndView mv = new ModelAndView("RawJutePaymentAndProcurement");
        if(username == null) {
            return mv = new ModelAndView("index");
            }
        final List<String> farmerNo = (List<String>)this.rawJuteProcurAndPayService.getfarmerno((String)request.getSession().getAttribute("dpcId"));
        mv.addObject("farmerNo", (Object)farmerNo);
        
        return mv;
    }
    
    @RequestMapping({ "balePreparation" })
    public ModelAndView balePreparation(final HttpServletRequest request, final HttpSession session,RedirectAttributes red) {
    	String username =(String)request.getSession().getAttribute("usrname");
        ModelAndView mv = new ModelAndView("balePrepare");
    	if(username == null) {
            return mv = new ModelAndView("index");
            }
    	String pagename = "balePreparation";
        int i = checkprivileges(pagename);
        if(i != 1)
        {
        	 red.addFlashAttribute("errorMessage","Access denied");
			   return mv=new ModelAndView("Home");
        }
        final List<String> allDpcList = (List<String>)this.purchaseCenterService.getAllDpc();
        mv.addObject("allDpcList", (Object)allDpcList);   

        return mv;
    }
    
    @RequestMapping({ "saveBalePreparation" })
    public ModelAndView saveBalePreparation(final HttpServletRequest request, final RedirectAttributes redirectAttributes) {
    	String username =(String)request.getSession().getAttribute("usrname");
    	 if(username == null) {
             return new ModelAndView("index");
             }
        return new ModelAndView((View)new RedirectView("balePreparation.obj"));
    }
    
    @RequestMapping({ "BaleDelete" })
    public ModelAndView locatorDelete(final HttpServletRequest request, final RedirectAttributes redirectAttributes) throws ParseException {
    	String username =(String)request.getSession().getAttribute("usrname");
        final ModelAndView mv = new ModelAndView("BalePrepList");
        if(username == null) {
            return new ModelAndView("index");
             }
        final int id = Integer.parseInt(request.getParameter("id"));
        this.balepreparationservice.delete(id);
        final List<BalePreparation> bale = (List<BalePreparation>)this.balepreparationservice.getAll();
        mv.addObject("baleslis", (Object)bale);
        redirectAttributes.addFlashAttribute("msg", (Object)"<div class=\"alert alert-success\"><b>Success !</b> List deleted successfully.</div>\r\n");      
        return new ModelAndView((View)new RedirectView("BalePreparationList.obj"));
    }
    
    @RequestMapping({ "BalePreparationList" })
    public ModelAndView BalePreparationList(final HttpServletRequest request,RedirectAttributes red) {
    	String username =(String)request.getSession().getAttribute("usrname");
        ModelAndView mv = new ModelAndView("BalePrepList");
        if(username == null) {
            return mv = new ModelAndView("index");
            }
        String pagename = "BalePreparationList";
        int i = checkprivileges(pagename);
        if(i != 1)
        {
        	 red.addFlashAttribute("errorMessage","Access denied");
			   return mv=new ModelAndView("Home");
        }
        return mv;
    }
    
    @RequestMapping(value = { "editBaleList" }, method = { RequestMethod.GET })
    public ModelAndView editBaleList(final HttpServletRequest request) {
    	String username =(String)request.getSession().getAttribute("usrname");
        ModelAndView mv = new ModelAndView("EditBale");
        if(username == null) {
            return mv = new ModelAndView("index");
            }
        try {
        if (request.getParameter("id") != null) {
            final int id = Integer.parseInt(request.getParameter("id"));
            final BalePreparation editBaleList = this.balepreparationservice.find(id);
            mv.addObject("editBaleList", (Object)editBaleList);
        }
        }
        catch(Exception e) {
        	e.printStackTrace();
        }
        return mv;
    }
    
    @RequestMapping({ "saveBaleList" })
    public ModelAndView saveBaleList(final HttpServletRequest request, final RedirectAttributes redirectAttributes) {
    	String username =(String)request.getSession().getAttribute("usrname");
        final ModelAndView mv = new ModelAndView();
        if(username == null) {
            return new ModelAndView("index");
            }
        return new ModelAndView((View)new RedirectView("BalePreparationList.obj"));
    }
    
    @RequestMapping({ "jbaRate" })
    public ModelAndView jbaRate(final HttpServletRequest request,RedirectAttributes red) {
    	String username =(String)request.getSession().getAttribute("usrname");
        ModelAndView mv = new ModelAndView("addJba");
    	if(username == null) {
            return mv = new ModelAndView("index");
            }
    	String pagename = "jbaRate";
        int i = checkprivileges(pagename);
        if(i != 1)
        {
        	 red.addFlashAttribute("errorMessage","Access denied");
			   return mv=new ModelAndView("Home");
        }
        return mv;
    }
    
    @RequestMapping({ "saveJbaRate" })
    public ModelAndView saveJbaRate(final HttpServletRequest request, final RedirectAttributes redirectAttributes) {
    	String username =(String)request.getSession().getAttribute("usrname"); 
    	if(username == null) {
            return new ModelAndView("index");
            }
        try {
            final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
            final LocalDateTime now = LocalDateTime.now();
            final String date = dtf.format(now);
            final int creadtedby = (int)request.getSession().getAttribute("userId");
            final String region = (String)request.getSession().getAttribute("region");
            final String dpcid = (String)request.getSession().getAttribute("dpcId");
            final String datejba = request.getParameter("datejba");
            final String jutevariety = request.getParameter("jutevariety");
            final String areacode = request.getParameter("areacode");
            final String cropyr = request.getParameter("cropyr");
            String nbaseproceString = request.getParameter("northernprice");
            String sembaspriceString = request.getParameter("seminorthernprice");
            String biharpriceString = request.getParameter("biharprice");
            final int northern = Integer.parseInt(nbaseproceString);
            final int seminorthern = Integer.parseInt(sembaspriceString);
            final int bihar = Integer.parseInt(biharpriceString);
            int grade1;
            int grade2;
            int grade3;
            int grade4;
            int grade5;
            int grade6;
            int grade7;
            int grade8;
            int td6Gradediff;
            if (jutevariety.equalsIgnoreCase("tossa")) {
                grade1 = Integer.parseInt(request.getParameter("gradewisepp1"));
                grade2 = Integer.parseInt(request.getParameter("gradewisepp2"));
                grade3 = Integer.parseInt(request.getParameter("gradewisepp3"));
                grade4 = Integer.parseInt(request.getParameter("gradewisepp4"));
                grade5 = Integer.parseInt(request.getParameter("gradewisepp5"));
                grade6 = Integer.parseInt(request.getParameter("gradewisepp6"));
                grade7 = Integer.parseInt(request.getParameter("gradewisepp7"));
                grade8 = Integer.parseInt(request.getParameter("gradewisepp8"));
                
                
            }
            else {
                grade1 = Integer.parseInt(request.getParameter("gradewisepp9"));
                grade2 = Integer.parseInt(request.getParameter("gradewisepp10"));
                grade3 = Integer.parseInt(request.getParameter("gradewisepp11"));
                grade4 = Integer.parseInt(request.getParameter("gradewisepp12"));
                grade5 = Integer.parseInt(request.getParameter("gradewisepp13"));
                grade6 = Integer.parseInt(request.getParameter("gradewisepp14"));
                grade7 = Integer.parseInt(request.getParameter("gradewisepp15"));
                grade8 = Integer.parseInt(request.getParameter("gradewisepp16"));
            }

            if(isStringValid(datejba) || isStringValid(jutevariety) || isStringValid(areacode) || isStringValid(cropyr) || isStringValid(nbaseproceString)|| isStringValid(sembaspriceString) || isStringValid(biharpriceString))
                {
                  redirectAttributes.addFlashAttribute("msg", (Object)"<div class=\"alert alert-danger\"><b>Allowed only Alphabates and Numbers!</b> </div>\r\n");
                  return new ModelAndView((View)new RedirectView("addJba.obj"));
                }
            td6Gradediff = grade5-grade6;
            
            final JbaModel jbapri = new JbaModel();
            jbapri.setJbaDate(datejba);
            jbapri.setJutevariety(jutevariety);
            jbapri.setAreaCode(areacode);
            jbapri.setAreaName("South Bengal");
            jbapri.setCropyr(cropyr);
            jbapri.setCreadtedby(creadtedby);
            jbapri.setCreateddate(date);
            jbapri.setRegion(region);
            jbapri.setDpcid(dpcid);
            if (grade1 != 0) {
                jbapri.setGradewisepp1((double)grade1);
            }
            if (grade2 != 0) {
                jbapri.setGradewisepp2((double)grade2);
            }
            if (grade3 != 0) {
                jbapri.setGradewisepp3((double)grade3);
            }
            if (grade4 != 0) {
                jbapri.setGradewisepp4((double)grade4);
            }
            if (grade5 != 0) {
                jbapri.setGradewisepp5((double)grade5);
            }
            if (grade6 != 0) {
                jbapri.setGradewisepp6((double)grade6);
            }
            if (grade7 != 0) {
                jbapri.setGradewisepp7((double)grade7);
            }
            if (grade8 != 0) {
                jbapri.setGradewisepp8((double)grade8);
            }
            this.jbaservice.create(jbapri);
            final JbaModel jbanorth = new JbaModel();
            jbanorth.setJbaDate(datejba);
            jbanorth.setJutevariety(jutevariety);
            jbanorth.setAreaCode("NB");
            jbanorth.setAreaName("Northern");
            jbanorth.setCropyr(cropyr);
            jbanorth.setCreadtedby(creadtedby);
            jbanorth.setCreateddate(date);
            jbanorth.setRegion(region);
            jbanorth.setDpcid(dpcid);
            if (grade1 != 0) {
                jbanorth.setGradewisepp1((double)(grade1 + northern+td6Gradediff));
            }
            if (grade2 != 0) {
                jbanorth.setGradewisepp2((double)(grade2 + northern+td6Gradediff));
            }
            if (grade3 != 0) {
                jbanorth.setGradewisepp3((double)(grade3 + northern+td6Gradediff));
            }
            if (grade4 != 0) {
                jbanorth.setGradewisepp4((double)(grade4 + northern+td6Gradediff));
            }
            if (grade5 != 0) {
                jbanorth.setGradewisepp5((double)(grade5 + northern+td6Gradediff));
            }
            if (grade6 != 0) {
                jbanorth.setGradewisepp6((double)(grade6 + northern+td6Gradediff));
            }
            if (grade7 != 0) {
                jbanorth.setGradewisepp7((double)(grade7 + northern+td6Gradediff));
            }
            if (grade8 != 0) {
                jbanorth.setGradewisepp8((double)(grade8 + northern+td6Gradediff));
            }
            this.jbaservice.create(jbanorth);
            final JbaModel jbasn = new JbaModel();
            jbasn.setJbaDate(datejba);
            jbasn.setJutevariety(jutevariety);
            jbasn.setAreaCode("SN");
            jbasn.setAreaName("Semi Northern");
            jbasn.setCropyr(cropyr);
            jbasn.setCreadtedby(creadtedby);
            jbasn.setCreateddate(date);
            jbasn.setRegion(region);
            jbasn.setDpcid(dpcid);
            if (grade1 != 0) {
                jbasn.setGradewisepp1((double)(grade1 + seminorthern));
            }
            if (grade2 != 0) {
                jbasn.setGradewisepp2((double)(grade2 + seminorthern));
            }
            if (grade3 != 0) {
                jbasn.setGradewisepp3((double)(grade3 + seminorthern));
            }
            if (grade4 != 0) {
                jbasn.setGradewisepp4((double)(grade4 + seminorthern));
            }
            if (grade5 != 0) {
                jbasn.setGradewisepp5((double)(grade5 + seminorthern));
            }
            if (grade6 != 0) {
                jbasn.setGradewisepp6((double)(grade6 + seminorthern));
            }
            if (grade7 != 0) {
                jbasn.setGradewisepp7((double)(grade7 + seminorthern));
            }
            if (grade8 != 0) {
                jbasn.setGradewisepp8((double)(grade8 + seminorthern));
            }
            this.jbaservice.create(jbasn);
            final JbaModel jbabr = new JbaModel();
            jbabr.setJbaDate(datejba);
            jbabr.setJutevariety(jutevariety);
            jbabr.setAreaCode("BH");
            jbabr.setAreaName("Bihar");
            jbabr.setCropyr(cropyr);
            jbabr.setCreadtedby(creadtedby);
            jbabr.setCreateddate(date);
            jbabr.setRegion(region);
            jbabr.setDpcid(dpcid);
            if (grade1 != 0) {
                jbabr.setGradewisepp1((double)(grade1 + bihar));
            }
            if (grade2 != 0) {
                jbabr.setGradewisepp2((double)(grade2 + bihar));
            }
            if (grade3 != 0) {
                jbabr.setGradewisepp3((double)(grade3 + bihar));
            }
            if (grade4 != 0) {
                jbabr.setGradewisepp4((double)(grade4 + bihar));
            }
            if (grade5 != 0) {
                jbabr.setGradewisepp5((double)(grade5 + bihar));
            }
            if (grade6 != 0) {
                jbabr.setGradewisepp6((double)(grade6 + bihar));
            }
            if (grade7 != 0) {
                jbabr.setGradewisepp7((double)(grade7 + bihar));
            }
            if (grade8 != 0) {
                jbabr.setGradewisepp8((double)(grade8 + bihar));
            }
            this.jbaservice.create(jbabr);
            redirectAttributes.addFlashAttribute("msg", (Object)"<div class=\"alert alert-success\"><b>Success !</b> Record saved successfully.</div>\r\n");
        }
        catch (Exception e) {
            System.out.println(e);
        }
        
        return new ModelAndView((View)new RedirectView("jbaRate.obj"));
    }
    
    @RequestMapping({ "JbaPriceList" })
    public ModelAndView JbaPriceList(final HttpServletRequest request, final RedirectAttributes red) {
    	String username =(String)request.getSession().getAttribute("usrname");
        ModelAndView mv = new ModelAndView("JBAList");
        if(username == null) {
            return mv = new ModelAndView("index");
            }
        String pagename = "JbaPriceList";
        int i = checkprivileges(pagename);
        if(i != 1)
        {
        	 red.addFlashAttribute("errorMessage","Access denied");
			   return mv=new ModelAndView("Home");
        }
        try {
            String dpcid =(String)request.getSession().getAttribute("dpcId");
         	String placeofactivity =(String)request.getSession().getAttribute("dpcId");
         	String regionId =(String)request.getSession().getAttribute("regionId");
         	String zoneId =(String)request.getSession().getAttribute("zoneId");
            final List<JbaModel> jbapri = (List<JbaModel>)this.jbaservice.getAll(dpcid,  regionId,  zoneId);
            final List<JbaModel> jbapril = (List<JbaModel>)this.jbaservice.getAll();
            mv.addObject("jbaList", (Object)jbapri);
            mv.addObject("jbaLists", (Object)jbapril);
            }
            catch(Exception e) {
            	e.printStackTrace();
            }
        return mv;
    }
    
    

    
    @RequestMapping(value = { "editJBAList" }, method = { RequestMethod.GET })
    public ModelAndView editJBAList(final HttpServletRequest request) {
        ModelAndView mv = new ModelAndView("EditJBA");
        String username =(String)request.getSession().getAttribute("usrname");
        if(username == null) {
            return mv = new ModelAndView("index");
            }
        try {
        if (request.getParameter("id") != null) {
        	String key = LoginController.secretkey;
	    	String decryptedString = request.getParameter("id");
	    	final int id = Integer.parseInt(Encry.decrypt(decryptedString, key));
            final JbaModel editJBAList = this.jbaservice.find(id);
            mv.addObject("editJBAList", (Object)editJBAList);
        }
        }
        catch(Exception e) {
        	e.printStackTrace();
        }
        return mv;
    }
    
    @RequestMapping({ "saveJBAList" })
    public ModelAndView saveJBAList(final HttpServletRequest request, final RedirectAttributes redirectAttributes) {
    	String username =(String)request.getSession().getAttribute("usrname");
        final ModelAndView mv = new ModelAndView();
        if(username == null) {
        	return new ModelAndView("index");
            }
        try {
            final String id = request.getParameter("id");
            final String datejba = request.getParameter("datejba");
            final String jutevariety = request.getParameter("jutevariety");
            final String areaname = request.getParameter("areacode").split(",")[0];
            final String areacode = request.getParameter("areacode").split(",")[1];
            final String cropyr = request.getParameter("cropyr");
            final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
            final LocalDateTime now = LocalDateTime.now();
            final String date = dtf.format(now);
            final int creadtedby = (int)request.getSession().getAttribute("userId");
            final String region = (String)request.getSession().getAttribute("region");
            final String dpcid = (String)request.getSession().getAttribute("dpcId");
            final double grade1 = Double.parseDouble(request.getParameter("gradewisepp1"));
            final double grade2 = Double.parseDouble(request.getParameter("gradewisepp2"));
            final double grade3 = Double.parseDouble(request.getParameter("gradewisepp3"));
            final double grade4 = Double.parseDouble(request.getParameter("gradewisepp4"));
            final double grade5 = Double.parseDouble(request.getParameter("gradewisepp5"));
            final double grade6 = Double.parseDouble(request.getParameter("gradewisepp6"));
            final double grade7 = Double.parseDouble(request.getParameter("gradewisepp7"));
            final double grade8 = Double.parseDouble(request.getParameter("gradewisepp8"));
            if(isStringValid(id) || isStringValid(datejba) ||isStringValid(jutevariety) ||isStringValid(areaname) || isStringValid(areacode) || isStringValid(cropyr)
                	)
                {
                  redirectAttributes.addFlashAttribute("msg", (Object)"<div class=\"alert alert-danger\"><b>Allowed only Alphabates and Numbers!</b> </div>\r\n");
                  return new ModelAndView((View)new RedirectView("JbaPriceList.obj"));
                }
            final JbaModel jbapri = new JbaModel();
            jbapri.setId(Integer.parseInt(id));
            jbapri.setJbaDate(datejba);
            jbapri.setJutevariety(jutevariety);
            jbapri.setAreaName(areaname);
            jbapri.setAreaCode(areacode);
            jbapri.setCropyr(cropyr);
            jbapri.setCreadtedby(creadtedby);
            jbapri.setCreateddate(date);
            jbapri.setRegion(region);
            jbapri.setDpcid(dpcid);
            if (grade1 != 0.0) {
                jbapri.setGradewisepp1(grade1);
            }
            if (grade2 != 0.0) {
                jbapri.setGradewisepp2(grade2);
            }
            if (grade3 != 0.0) {
                jbapri.setGradewisepp3(grade3);
            }
            if (grade4 != 0.0) {
                jbapri.setGradewisepp4(grade4);
            }
            if (grade5 != 0.0) {
                jbapri.setGradewisepp5(grade5);
            }
            if (grade6 != 0.0) {
                jbapri.setGradewisepp6(grade6);
            }
            if (grade7 != 0.0) {
                jbapri.setGradewisepp7(grade7);
            }
            if (grade8 != 0.0) {
                jbapri.setGradewisepp8(grade8);
            }
            this.jbaservice.create(jbapri);
            redirectAttributes.addFlashAttribute("msg", (Object)"<div class=\"alert alert-success\"><b>Success !</b> Record Edit successfully.</div>\r\n");
        }
        catch (Exception e) {
            System.out.println(e);
            redirectAttributes.addFlashAttribute("msg", (Object)"<div class=\"alert alert-dange\"><b>Failure!</b> Error While saving record. Please try againn</div>\r\n");
        }
        
        return new ModelAndView((View)new RedirectView("JbaPriceList.obj"));
    }
    
    @RequestMapping({ "JbaDelete" })
    public ModelAndView JbaDelete(final HttpServletRequest request, final RedirectAttributes redirectAttributes) throws ParseException {
    	String username =(String)request.getSession().getAttribute("usrname");
        final ModelAndView mv = new ModelAndView("JBAList");
        if(username == null) {
        	return new ModelAndView("index");
            }
        try {
        final int id = Integer.parseInt(request.getParameter("id"));
        String dpcid =(String)request.getSession().getAttribute("dpcId");
     	String placeofactivity =(String)request.getSession().getAttribute("dpcId");
     	String regionId =(String)request.getSession().getAttribute("regionId");
     	String zoneId =(String)request.getSession().getAttribute("zoneId");
        this.jbaservice.delete(id);
        final JbaModel jbapric = new JbaModel();
        final List<JbaModel> jbap = (List<JbaModel>)this.jbaservice.getAll(dpcid,regionId,zoneId);
        mv.addObject("baleslis", (Object)jbap);
        redirectAttributes.addFlashAttribute("msg", (Object)"<div class=\"alert alert-success\"><b>Success !</b> List deleted successfully.</div>\r\n");
        }
        catch(Exception e) {
        	e.printStackTrace();
        }
        return new ModelAndView((View)new RedirectView("JbaPriceList.obj"));
    }
    
    @RequestMapping({ "rawJuteProcurementAndPaymentMid" })
    public ModelAndView rawJuteProcurementAndPaymentMid(final HttpServletRequest request, final RedirectAttributes redirectAttributes, @RequestParam("tallySlipdoc") final MultipartFile tallySlipdoc) {
    	String username =(String)request.getSession().getAttribute("usrname");
    	if(username == null) {
        	return new ModelAndView("index");
            }
    	final File theDir = new File(this.slipUpload);
        if (!theDir.exists()) {
            theDir.mkdirs();
        }
        try {
            String ipAddress = null;
            final String getWay = request.getHeader("VIA");
            ipAddress = request.getHeader("X-FORWARDED-FOR");
            if (ipAddress == null) {
                ipAddress = request.getRemoteAddr();
            }
            final RawJuteProcurementAndPayment rawJuteProcAndPay = new RawJuteProcurementAndPayment();
            final String farmerregno = request.getParameter("farmerregno");
            final String datepurchase = request.getParameter("datepurchase");
            final String basis = request.getParameter("basis");
            final String cropyr = request.getParameter("cropyr");
            final String placeofpurchase = request.getParameter("placeofpurchase");
            final String rateslipno = request.getParameter("rateslipno");
            final String binno = request.getParameter("binno");
            final String jutevariety = request.getParameter("jutevariety");
            final String gquantity = request.getParameter("gquantity");
            final String dquantity = request.getParameter("deductionQuantity");
            final String netquantity = request.getParameter("netquantity");
            final String garsatRate = request.getParameter("garsatRate");
            final String tallyslipno = request.getParameter("tallyslipno");
            final String regFarmer = request.getParameter("regFarmer");
            final String regMolile = request.getParameter("regMolile");
            final String tdbaseprice = request.getParameter("tdbaseprice");
            final String dpcid = (String)request.getSession().getAttribute("dpcId");
            final int createdBy = (int)request.getSession().getAttribute("userId");
            final SimpleDateFormat formatter1 = new SimpleDateFormat("dd-MM-yyyy");
            final Date d1 = formatter1.parse(datepurchase);
            final Date n = new Date();
            final long time_difference = n.getTime() - d1.getTime();
            final long days_difference = TimeUnit.MILLISECONDS.toDays(time_difference) % 365L;
            if (days_difference == 1L || days_difference == 0L) {
                rawJuteProcAndPay.setStatus("DPC");
                rawJuteProcAndPay.setIs_varified(0);
            }
            else if (days_difference > 1L) {
                rawJuteProcAndPay.setStatus("RMA");
                rawJuteProcAndPay.setIs_varified(0);
            }
            final String grade0 = request.getParameter("g0");
            final String grade2 = request.getParameter("g1");
            final String grade3 = request.getParameter("g2");
            final String grade4 = request.getParameter("g3");
            final String grade5 = request.getParameter("g4");
            final String grade6 = request.getParameter("g5");
            final String grade7 = request.getParameter("g6");
            final String grade8 = request.getParameter("g7");
            if (grade0 != null && grade0 != "0") {
                rawJuteProcAndPay.setGrade1(Double.parseDouble(grade0));
            }
            if (grade2 != null && grade2 != "0") {
                rawJuteProcAndPay.setGrade2(Double.parseDouble(grade2));
            }
            if (grade3 != null && grade3 != "0") {
                rawJuteProcAndPay.setGrade3(Double.parseDouble(grade3));
            }
            if (grade4 != null && grade4 != "0") {
                rawJuteProcAndPay.setGrade4(Double.parseDouble(grade4));
            }
            if (grade5 != null && grade5 != "0") {
                rawJuteProcAndPay.setGrade5(Double.parseDouble(grade5));
            }
            if (grade6 != null && grade6 != "0") {
                rawJuteProcAndPay.setGrade6(Double.parseDouble(grade6));
            }
            if (grade7 != null && grade7 != "0") {
                rawJuteProcAndPay.setGrade7(Double.parseDouble(grade7));
            }
            if (grade8 != null && grade8 != "0") {
                rawJuteProcAndPay.setGrade8(Double.parseDouble(grade8));
            }
            File file = null;
            String pathurl = "";
            String url = "";
            if (!tallySlipdoc.isEmpty()) {
                file = new File(this.slipUpload + tallySlipdoc.getOriginalFilename());
                if (!tallySlipdoc.isEmpty()) {
                    file = new File(this.slipUpload + tallySlipdoc.getOriginalFilename());
                    try {
                //        System.out.println("file=====>>>>>" + file);
                        final OutputStream os = new FileOutputStream(file);
                        os.write(tallySlipdoc.getBytes());
                        os.close();
                    }
                    catch (Exception e) {
                        e.printStackTrace();
                    }
                    pathurl = file.getAbsolutePath();
                    final String path = url = tallySlipdoc.getOriginalFilename();
                    rawJuteProcAndPay.setSlip_image(url);
                }
                pathurl = file.getAbsolutePath();
                final String path = url = tallySlipdoc.getOriginalFilename();
                rawJuteProcAndPay.setSlip_image(url);
            }
            final String ro = (String)request.getSession().getAttribute("region");
            rawJuteProcAndPay.setRegionId(ro);
            rawJuteProcAndPay.setBasis(basis);
            rawJuteProcAndPay.setBinno(Integer.parseInt(binno));
            rawJuteProcAndPay.setCreateddate(new Date());
            rawJuteProcAndPay.setCropyr(cropyr);
            rawJuteProcAndPay.setIpaddress(ipAddress);
            rawJuteProcAndPay.setGrossquantity((double)Float.parseFloat(gquantity));
            rawJuteProcAndPay.setIpaddress(ipAddress);
            rawJuteProcAndPay.setJutevariety(jutevariety);
            rawJuteProcAndPay.setNetquantity((double)Float.parseFloat(netquantity));
            rawJuteProcAndPay.setPlaceofpurchase(placeofpurchase);
            rawJuteProcAndPay.setRateslipno(Integer.parseInt(rateslipno));
            rawJuteProcAndPay.setDeductionquantity((double)Float.parseFloat(dquantity));
            rawJuteProcAndPay.setGrasatrate((double)Float.parseFloat(garsatRate));
            rawJuteProcAndPay.setDatepurchase(datepurchase);
            rawJuteProcAndPay.setFarmerregno(farmerregno);
            rawJuteProcAndPay.setCreadtedby(createdBy);
            rawJuteProcAndPay.setDateof_entry(formatter1.format(n));
            rawJuteProcAndPay.setTd_base(tdbaseprice);
            rawJuteProcAndPay.setTallyslipno(tallyslipno);
            final String amountPayable = request.getParameter("amountPayable");
            int basisNo=0;
			if(basis.equalsIgnoreCase("commercial")) 
				basisNo=2;
			else if(basis.equalsIgnoreCase("msp")) 
				basisNo=1;
			  final String result =this.DailyPurchasefService.findGradePriceJuteVariety(jutevariety, basisNo, cropyr, dpcid);
			
			  final Gson gson = new Gson();
			 double[] prices=new double[8];
			 prices[0]=Double.parseDouble(result.split(",")[0]);
			 prices[1]=Double.parseDouble(result.split(",")[1]);
			 prices[2]=Double.parseDouble(result.split(",")[2]);
			 prices[3]=Double.parseDouble(result.split(",")[3]);
			 prices[4]=Double.parseDouble(result.split(",")[4]);
			 prices[5]=Double.parseDouble(result.split(",")[5]);
			 prices[6]=Double.parseDouble(result.split(",")[6]);
			 prices[7]=Double.parseDouble(result.split(",")[7]);
     
			
			
			 rawJuteProcAndPay.setGrade1xnetqty(prices[0]*Double.
			  parseDouble(netquantity));
			 rawJuteProcAndPay.setGrade2xnetqty(prices[1]*Double.
			  parseDouble(netquantity));
			 rawJuteProcAndPay.setGrade3xnetqty(prices[2]*Double.
			  parseDouble(netquantity));
			 rawJuteProcAndPay.setGrade4xnetqty(prices[3]*Double.
			  parseDouble(netquantity));
			 rawJuteProcAndPay.setGrade5xnetqty(prices[4]*Double.
			  parseDouble(netquantity));
			 rawJuteProcAndPay.setGrade6xnetqty(prices[5]*Double.
			  parseDouble(netquantity));
			 rawJuteProcAndPay.setGrade7xnetqty(prices[6]*Double.
			  parseDouble(netquantity));
			 rawJuteProcAndPay.setGrade8xnetqty(prices[7]*Double.
			  parseDouble(netquantity));
            rawJuteProcAndPay.setAmountpayable((double)Float.parseFloat(amountPayable));
            if (farmerregno == null || farmerregno == "") {
                redirectAttributes.addFlashAttribute("msg", (Object)"<div class=\"alert alert-warning\"><b>Oops! </b> Please enter correct registartion number.</div>\r\n");
            }
            else {
                this.rawJuteProcurAndPayService.create(rawJuteProcAndPay);
                redirectAttributes.addFlashAttribute("msg", (Object)"<div class=\"alert alert-success\"><b>Success !</b> Record saved successfully.</div>\r\n");
            }
        }
        catch (Exception e2) {
            System.out.println(e2.getLocalizedMessage());
        }
        
        return new ModelAndView((View)new RedirectView("rawJutePaymentAndProcurement.obj"));
    }
    
    @RequestMapping({ "juteProcurementList" })
    public ModelAndView juteProcurementList(final HttpServletRequest request,RedirectAttributes red) {
    	String username =(String)request.getSession().getAttribute("usrname");
    	ModelAndView mv = new ModelAndView("juteProcurementList");
    	if(username == null) {
        	return mv = new ModelAndView("index");
            }
    	String pagename = "juteProcurementList";
        int i = checkprivileges(pagename);
        if(i != 1)
        {
        	 red.addFlashAttribute("errorMessage","Access denied");
			   return mv=new ModelAndView("Home");
        }
            List<RawJuteProcurementAndPayment> procurementList = new ArrayList<RawJuteProcurementAndPayment>();
       
           
            try 
            {
            	 procurementList = (List<RawJuteProcurementAndPayment>)this.rawJuteProcurAndPayService.farmerDetailsList();
                 mv.addObject("procurementList", (Object)procurementList);
 			} catch(Exception e) 
            {
  		         e.printStackTrace();
  	        }
     
        
        return mv;
    }
    
    @RequestMapping({ "dailyPurchaseConf" })
    public ModelAndView dailyPurchaseConf(final HttpServletRequest request) {
    	String username =(String)request.getSession().getAttribute("usrname");
        ModelAndView mv = new ModelAndView("DailyPurchaseConf");
        if(username == null) {
        	return mv = new ModelAndView("index");
            }
        return mv;
    }
    
    @RequestMapping({ "dailyPurchaseMid" })
    public ModelAndView dailyPurchaseMid(final HttpServletRequest request, final RedirectAttributes redirectAttributes) {
    	String username =(String)request.getSession().getAttribute("usrname");
    	  if(username == null) {
          	return new ModelAndView("index");
              }
        try {
            String ipAddress = null;
            final String getWay = request.getHeader("VIA");
            ipAddress = request.getHeader("X-FORWARDED-FOR");
            if (ipAddress == null) {
                ipAddress = request.getRemoteAddr();
            }
            
            String dpcid = (String)request.getSession().getAttribute("dpcId");
            final String grade0 = request.getParameter("g0");
            final String grade2 = request.getParameter("g1");
            final String grade3 = request.getParameter("g2");
            final String grade4 = request.getParameter("g3");
            final String grade5 = request.getParameter("g4");
            final String grade6 = request.getParameter("g5");
            final String grade7 = request.getParameter("g6");
            final String grade8 = request.getParameter("g7");	
            final String datepurchase = request.getParameter("datepurchase");
            final String formno = request.getParameter("formno");
            final String basis = request.getParameter("basis");
            final String cropyr = request.getParameter("cropyr");
            final String placeofpurchase = request.getParameter("placeofpurchase");
            final String binno = request.getParameter("binno");
            final String jutevariety = request.getParameter("jutevariety");
            final String gquantity = request.getParameter("gquantity");
            final String dquantity = request.getParameter("dquantity");
            final String netquantity = request.getParameter("netquantity");
            final String fibervalue = request.getParameter("fibervalue");
            final int createdBy = (int)request.getSession().getAttribute("userId");
            final String rateslipno = request.getParameter("rateslipno");
            final DailyPurchaseConfModel DailyPurchase = new DailyPurchaseConfModel();
            DailyPurchase.setDatepurchase(datepurchase);
            DailyPurchase.setBasis(basis);
            DailyPurchase.setBinno(Integer.parseInt(binno));
            DailyPurchase.setCropyr(cropyr);
            DailyPurchase.setDquantity(dquantity);
            DailyPurchase.setFibervalue(Integer.parseInt(fibervalue));
            DailyPurchase.setFormno(formno);
            DailyPurchase.setGquantity(gquantity);
            DailyPurchase.setIpaddress(ipAddress);
            DailyPurchase.setJutevariety(jutevariety);
            DailyPurchase.setNetquantity(Double.parseDouble(netquantity));
            DailyPurchase.setPlaceofpurchase(placeofpurchase);
            DailyPurchase.setCreatedby(createdBy);
            DailyPurchase.setRateslipno(rateslipno);
            int basisNo=0;
			if(basis.equalsIgnoreCase("commercial")) 
				basisNo=2;
			else if(basis.equalsIgnoreCase("msp")) 
				basisNo=1;
			  final String result =this.DailyPurchasefService.findGradePriceJuteVariety(jutevariety, basisNo, cropyr, dpcid);
			
			  final Gson gson = new Gson();
			 double[] prices=new double[8];
			 prices[0]=Double.parseDouble(result.split(",")[0]);
			 prices[1]=Double.parseDouble(result.split(",")[1]);
			 prices[2]=Double.parseDouble(result.split(",")[2]);
			 prices[3]=Double.parseDouble(result.split(",")[3]);
			 prices[4]=Double.parseDouble(result.split(",")[4]);
			 prices[5]=Double.parseDouble(result.split(",")[5]);
			 prices[6]=Double.parseDouble(result.split(",")[6]);
			 prices[7]=Double.parseDouble(result.split(",")[7]);
            if (grade0 != null && grade0 != "0") {
                DailyPurchase.setGrade1(Double.parseDouble(grade0));
            }
            if (grade2 != null && grade2 != "0") {
                DailyPurchase.setGrade2(Double.parseDouble(grade2));
            }
            if (grade3 != null && grade3 != "0") {
                DailyPurchase.setGrade3(Double.parseDouble(grade3));
            }
            if (grade4 != null && grade4 != "0") {
                DailyPurchase.setGrade4(Double.parseDouble(grade4));
            }
            if (grade5 != null && grade5 != "0") {
                DailyPurchase.setGrade5(Double.parseDouble(grade5));
            }
            if (grade6 != null && grade6 != "0") {
                DailyPurchase.setGrade6(Double.parseDouble(grade6));
            }
            if (grade7 != null && grade7 != "0") {
                DailyPurchase.setGrade7(Double.parseDouble(grade7));
            }
            if (grade8 != null && grade8 != "0") {
                DailyPurchase.setGrade8(Double.parseDouble(grade8));
            }
			
			
			  DailyPurchase.setGrade1xnetqty(prices[0]*Double.
			  parseDouble(netquantity));
			  DailyPurchase.setGrade2xnetqty(prices[1]*Double.
			  parseDouble(netquantity));
			  DailyPurchase.setGrade3xnetqty(prices[2]*Double.
			  parseDouble(netquantity));
			  DailyPurchase.setGrade4xnetqty(prices[3]*Double.
			  parseDouble(netquantity));
			  DailyPurchase.setGrade5xnetqty(prices[4]*Double.
			  parseDouble(netquantity));
			  DailyPurchase.setGrade6xnetqty(prices[5]*Double.
			  parseDouble(netquantity));
			  DailyPurchase.setGrade7xnetqty(prices[6]*Double.
			  parseDouble(netquantity));
			  DailyPurchase.setGrade8xnetqty(prices[7]*Double.
			  parseDouble(netquantity));
			 
			 
            this.DailyPurchasefService.create(DailyPurchase);
            redirectAttributes.addFlashAttribute("msg", (Object)"<div class=\"alert alert-success\"><b>Success !</b> Record saved successfully.</div>\r\n");
        }
        catch (Exception e) {
            System.out.println(e);
        }
        return new ModelAndView((View)new RedirectView("dailyPurchaseConf.obj"));
    }
    
    @RequestMapping({ "dailyPurchaseList" })
    public ModelAndView dailyPurchaseList(final HttpServletRequest request,RedirectAttributes red) {
    	
    	String username =(String)request.getSession().getAttribute("usrname");
        ModelAndView mv = new ModelAndView("dailyPurchaseLIst");
        if(username == null) {
        	 return mv = new ModelAndView("index");
            }
        String pagename = "dailyPurchaseList";
        int i = checkprivileges(pagename);
        if(i != 1)
        {
        	 red.addFlashAttribute("errorMessage","Access denied");
			   return mv=new ModelAndView("Home");
        }
    	String placeofactivity =(String)request.getSession().getAttribute("dpcId");
     	String regionId =(String)request.getSession().getAttribute("regionId");
     	String zoneId =(String)request.getSession().getAttribute("zoneId");
        String dpcid =(String)request.getSession().getAttribute("dpcId");
        final List<DailyPurchaseConfModel> purchaseList = (List<DailyPurchaseConfModel>)this.DailyPurchasefService.getAll(dpcid, regionId, zoneId);
        mv.addObject("dailyPurchaseList", (Object)purchaseList);    
        return mv;
    }
    
    @RequestMapping({ "saveBalePreparationMid" })
    public ModelAndView saveBalePreparationMid(final HttpServletRequest request) {
    	String username =(String)request.getSession().getAttribute("usrname");
    	 if(username == null) {
         	return new ModelAndView("index");
             }
        try {
            String ipAddress = null;
            final String getWay = request.getHeader("VIA");
            ipAddress = request.getHeader("X-FORWARDED-FOR");
            if (ipAddress == null) {
                ipAddress = request.getRemoteAddr();
            }
            final String dateofpacking = request.getParameter("dateofpacking");
            final String basis = request.getParameter("basis");
            final String cropyr = request.getParameter("cropyr");
            final String placeofpacking = request.getParameter("placeofpacking");
            final String binno = request.getParameter("binno");
            final String jutevariety = request.getParameter("jutevariety");
            final String jutegrade = request.getParameter("jutegrade");
            final String balecheckslipnofrom = request.getParameter("balecheckslipnofrom");
            final String balecheckslipnoto = request.getParameter("balecheckslipnoto");
            final String numberofbales = request.getParameter("numberofbales");
            final ProgOfAssortmentModel progOfAssortmentModel = new ProgOfAssortmentModel();
            progOfAssortmentModel.setBalecheckslipnofrom(balecheckslipnofrom);
            progOfAssortmentModel.setBalecheckslipnoto(balecheckslipnoto);
            progOfAssortmentModel.setBasis(basis);
            progOfAssortmentModel.setCreateddate(new Date());
            progOfAssortmentModel.setCropyr(cropyr);
            progOfAssortmentModel.setDateofpacking(dateofpacking);
            progOfAssortmentModel.setIpaddress(ipAddress);
            progOfAssortmentModel.setJutegrade(Integer.parseInt(jutegrade));
            progOfAssortmentModel.setJutevariety(jutevariety);
            progOfAssortmentModel.setNumberofbales(Integer.parseInt(numberofbales));
            progOfAssortmentModel.setPlaceofpacking(placeofpacking);
            progOfAssortmentModel.setBinno(binno);
            this.progOfAssortmentService.create(progOfAssortmentModel);
        }
        catch (Exception e) {
            System.out.println(e);
        }
       
        return new ModelAndView((View)new RedirectView("balePreparation.obj"));
    }
    
    @RequestMapping({ "UserRegistration" })
    public ModelAndView userRegistration(final HttpServletRequest request,RedirectAttributes red) {
    	String username =(String)request.getSession().getAttribute("usrname");
        ModelAndView mv = new ModelAndView("UserRegistration");
    	   if(username == null) {
    		    return mv = new ModelAndView("index");
               }
    	   String pagename = "UserRegistration";
           int i = checkprivileges(pagename);
           if(i != 1)
           {
           	 red.addFlashAttribute("errorMessage","Access denied");
   			   return mv=new ModelAndView("Home");
           }
    	   try {
    	       final List<ZoneModel> zoneList = (List<ZoneModel>)this.zoneService.getAll();
               final List<UserRoleModel> alluserroleList = (List<UserRoleModel>)this.userroleService.getAll();
               mv.addObject("zoneList", (Object)zoneList);
               mv.addObject("roleList", (Object)alluserroleList);
       		   }
    	   catch(Exception e) {
    		   e.printStackTrace();
    	   }
        return mv;
    }
    
    @RequestMapping({ "saveUserMid" })
    public ModelAndView saveUserMid(final HttpServletRequest request, final RedirectAttributes redirectAttributes) {
    	String username =(String)request.getSession().getAttribute("usrname");
    	 if(username == null) {
         	return new ModelAndView("index");
             }
        try {
            String ipAddress = null;
            final String getWay = request.getHeader("VIA");
            ipAddress = request.getHeader("X-FORWARDED-FOR");
            if (ipAddress == null) {
                ipAddress = request.getRemoteAddr();
            }
            String zone = request.getParameter("zone");
             String region = request.getParameter("region");
             String centerordpc = request.getParameter("centerordpc");
            final String employeeid = request.getParameter("employeeid");
            final String employeename = request.getParameter("employeename");
            final String email = request.getParameter("emailAddress");
            final String mobileno = request.getParameter("mobile");
            final String password = request.getParameter("password");
            final String usertype = request.getParameter("usertype");
            final String role = request.getParameter("rolename");
            final String username1 = request.getParameter("username");
            final String roletype = request.getParameter("roletype");
            final String roleid = request.getParameter("roleid");
            final String duplicateEmail = request.getParameter("emailCheck");
            if(zone == null) {
            	zone = "";
            }
            if(region == null) {
            	region = "";
            }
            if(centerordpc == null) {
            	centerordpc = "";
            }
            
            if(isStringValid(zone) || isStringValid(region) ||isStringValid(centerordpc) ||isStringValid(employeeid) || isStringValid(employeename) || isStringValid(email)
                || isStringValid(mobileno) || isStringValid(password) ||isStringValid(usertype) ||isStringValid(role) || isStringValid(username1) || isStringValid(roletype) || isStringValid(roleid) ||isStringValid(duplicateEmail)
            	)
            {
              redirectAttributes.addFlashAttribute("msg", (Object)"<div class=\"alert alert-danger\"><b>Allowed only Alphabates and Numbers!</b> </div>\r\n");
              return new ModelAndView((View)new RedirectView("UserRegistration.obj"));
            }
            
            final boolean duplicatemail = Boolean.parseBoolean(duplicateEmail);
            final UserRegistrationModel userRegistration = new UserRegistrationModel();
            userRegistration.setDpcId(centerordpc);
            userRegistration.setDatelastchangepassword(new Date());
            userRegistration.setEmail(email);
            userRegistration.setEmployeeid(employeeid);
            userRegistration.setEmployeename(employeename);
           // userRegistration.setHo(Integer.parseInt(ho));
            userRegistration.setIpaddress(ipAddress);
            userRegistration.setIs_active(1);
            userRegistration.setUsertype(usertype);
            userRegistration.setMobileno(mobileno);
            userRegistration.setPassword(password);
            userRegistration.setRoleId(Integer.parseInt(roleid));
			userRegistration.setRegion(region);
			userRegistration.setZone(zone); 
            userRegistration.setRoles_name(role);
            userRegistration.setRole_type(roletype);
            userRegistration.setRegistrationdate(new Date());
            userRegistration.setUsername(username1);
            userRegistration.setUsertype(usertype);
            userRegistration.setFailedLoginAttempts(0);
            userRegistration.setUserStatus("Active");
            
           // userRegistration.setRoleId(Integer.parseInt(role));
            final boolean emailNotExist = this.UserRegistrationService.validateEmail(email);
            if (emailNotExist) {
                this.UserRegistrationService.create(userRegistration);
                redirectAttributes.addFlashAttribute("msg", (Object)"<div class=\"alert alert-success\"><b>Success !</b> Record saved successfully.</div>\r\n");
            }
            else {
                redirectAttributes.addFlashAttribute("msg", (Object)"<div class=\"alert alert-warning\"><b>OOps!</b> Duplicate email id.</div>\r\n");
            }
        }
        catch (Exception ex) {
        	ex.printStackTrace();
            redirectAttributes.addFlashAttribute("msg", (Object)"<div class=\"alert alert-danger\"><b>Allowed only Alphabates and Numbers!</b> </div>\r\n");
            return new ModelAndView((View)new RedirectView("UserRegistration.obj"));
         
        }
       
        return new ModelAndView((View)new RedirectView("UserRegistration.obj"));
    }
    
    @ResponseBody
    @RequestMapping(value = { "findRoByZone" }, method = { RequestMethod.GET })
    public String findRoByZone(final HttpServletRequest request) {
    	String username =(String)request.getSession().getAttribute("usrname");
        final Gson gson = new Gson();
        return gson.toJson((Object)this.roService.zonecode(request.getParameter("id")));
    }
    
    @RequestMapping({ "viewmarketArrival" })
    public ModelAndView viewmarketArrival(final HttpServletRequest request,RedirectAttributes red) {
    	String username =(String)request.getSession().getAttribute("usrname");
        ModelAndView mv = new ModelAndView("viewmarketArrival");
        if(username == null) {
        	 return mv = new ModelAndView("index");
            }
        String pagename = "viewmarketArrival";
        int i = checkprivileges(pagename);
        if(i != 1)
        {
        	 red.addFlashAttribute("errorMessage","Access denied");
			   return mv=new ModelAndView("Home");
        }
        try {
        	String placeofactivity =(String)request.getSession().getAttribute("dpcId");
         	String regionId =(String)request.getSession().getAttribute("regionId");
         	String zoneId =(String)request.getSession().getAttribute("zoneId");
            String dpc_code =(String)request.getSession().getAttribute("dpcId");
            final List<MarketArrivalModel> allmarketArrivalList = (List<MarketArrivalModel>)this.marketArrivalService.getAlldata( dpc_code,  regionId,  zoneId);
            mv.addObject("marketArrivalList", (Object)allmarketArrivalList);

            }
            catch(Exception e) {
            	e.printStackTrace();
            }
        return mv;
    }
    
    @RequestMapping({ "ViewFarmerRegistration" })
    public ModelAndView viewFarmerLists(final HttpServletRequest request,RedirectAttributes red) {
    	String username =(String)request.getSession().getAttribute("usrname");
        ModelAndView mv = new ModelAndView("ViewFarmerRegistration");
        if(username == null) {
        	 return mv = new ModelAndView("index");
            }
        String pagename = "ViewFarmerRegistration";
        int i = checkprivileges(pagename);
        if(i != 1)
        {
        	 red.addFlashAttribute("errorMessage","Access denied");
			   return mv=new ModelAndView("Home");
        }
        try {
            String dcpid = (String)request.getSession().getAttribute("dpcId"); 
         	String regionId =(String)request.getSession().getAttribute("regionId");
         	String zoneId =(String)request.getSession().getAttribute("zoneId");
            final List<FarmerRegModelDTO> allFarmersList = (List<FarmerRegModelDTO>)this.farmerRegService.verificationStatus(dcpid, regionId, zoneId); 
            final List<ZoneModel> zoneList = (List<ZoneModel>)this.zoneService.getAll();     
            mv.addObject("zoneList", (Object)zoneList);
            mv.addObject("allFarmersList", (Object)allFarmersList);
           
	   	
			  }

    catch(Exception e) {
     		   e.printStackTrace();
     	   }
            return mv;
        }
    
    @RequestMapping({ "viewjcisales" })
    public ModelAndView viewsalesList(final HttpServletRequest request) {
    	String username =(String)request.getSession().getAttribute("usrname");
        ModelAndView mv = new ModelAndView("viewjcisales");
        if(username == null) {
        	 return mv = new ModelAndView("index");
            }
        try {
        final List<SalesModel> allviewsalesList = (List<SalesModel>)this.salesService.getAll();
        mv.addObject("salesList", (Object)allviewsalesList);
        }
        catch(Exception e) {
        	e.printStackTrace();
        }
        return mv;
    }
    
    @ResponseBody
    @RequestMapping({ "findDpcByRegion" })
    public String findDpcByRegion(final HttpServletRequest request) {
    	String username =(String)request.getSession().getAttribute("usrname");
    	String role = request.getParameter("role");
    	if(role == null)
    	{
    		role = "";
    	}
    	String id = request.getParameter("id");
        final Gson gson = new Gson();
        return gson.toJson((Object)this.purchaseCenterService.purchaseCenter(id,role));
    }
    
    @RequestMapping({ "editFarmer" })
    public ModelAndView editFarmer(final HttpServletRequest request) {
    	String username =(String)request.getSession().getAttribute("usrname");
        ModelAndView mv = new ModelAndView("viewbalePreparation");
        if(username == null) {
        	 return mv = new ModelAndView("index");
            }
        try {
        final int id = Integer.parseInt(request.getParameter("id"));
        final List<ProgOfAssortmentModel> allbalePreparationList = (List<ProgOfAssortmentModel>)this.progOfAssortmentService.getAll();
        mv.addObject("balePreparationList", (Object)allbalePreparationList);
        }
        catch(Exception e) {
        	e.printStackTrace();
        }
        return mv;
    }
    
    @RequestMapping(value = { "verifyFarmer2" }, method = { RequestMethod.GET })
    public ModelAndView verifyFarmer(final HttpServletRequest request, RedirectAttributes red) {
    	String username =(String)request.getSession().getAttribute("usrname");
        ModelAndView mv = new ModelAndView();
        if(username == null) {
        	return mv = new ModelAndView("index");
            }
        String pagename = "verifyFarmer2";
        int i = checkprivileges(pagename);
        if(i != 1)
        {
        	 red.addFlashAttribute("errorMessage","Access denied");
			   return mv=new ModelAndView("Home");
        }
        try {
        String key = LoginController.secretkey;
    	String decryptedString = request.getParameter("id");
    	final int id = Integer.parseInt(Encry.decrypt(decryptedString, key));
        final FarmerRegModel farmerDetails = this.farmerRegService.find(id);
        mv.addObject("farmerDetails", (Object)farmerDetails);
        mv.setViewName("verifyFarmer");
        
	
        }
        catch(Exception e) {
        	e.printStackTrace();
        }
        
        return mv;
    }
    
    @RequestMapping(value = { "saveVerification" }, method = { RequestMethod.POST })
    public ModelAndView saveVerification(final HttpServletRequest request, RedirectAttributes redirectAttributes) {
    	String username =(String)request.getSession().getAttribute("usrname");
        final ModelAndView mv = new ModelAndView("ViewFarmerRegistration");
        if(username == null) {
        	return new ModelAndView("index");
            }
        try {
        	
            final int id = Integer.parseInt(request.getParameter("id"));
             String farmer_reg_no = request.getParameter("farmer_reg_no");
             farmer_reg_no = farmer_reg_no.replaceAll("\\s", "");
             String ifsc_code = request.getParameter("ifsc_code");
             ifsc_code = ifsc_code.replaceAll("\\s", "");
             String ac_no = request.getParameter("ac_no");
             ac_no = ac_no.replaceAll("\\s", "");
             String farmer_name = request.getParameter("farmer_name");
             farmer_name = farmer_name.replaceAll("\\s", "");
          //  final String address = request.getParameter("address");
            // removed by animesh as per instruction 28 june 23
         //   final String idProofType = request.getParameter("idProofType");
         //   final String identityProofNo = request.getParameter("identityProofNo");
            final FarmerRegModel farmerdetails = this.farmerRegService.edit(id);
             String farmerRegNoDb = farmerdetails.getF_REG_NO();
             farmerRegNoDb = farmerRegNoDb.replaceAll("\\s", "");
             String ifscDb = farmerdetails.getF_BANK_IFSC();
             ifscDb = ifscDb.replaceAll("\\s", "");
             String accNoDb = farmerdetails.getF_AC_NO();
             accNoDb = accNoDb.replaceAll("\\s", "");
             String farmerNameDb = farmerdetails.getF_NAME();
             farmerNameDb = farmerNameDb.replaceAll("\\s", "");
             
        //    final String farmerAddressDb = farmerdetails.getF_ADDRESS();
        	String placeofactivity =(String)request.getSession().getAttribute("dpcId");
         	String regionId =(String)request.getSession().getAttribute("regionId");
         	String zoneId =(String)request.getSession().getAttribute("zoneId");
            final String farmerIdProofTypeDb = farmerdetails.getF_ID_PROF_TYPE();
            final String farmerIdProodNumberDb = farmerdetails.getF_ID_PROF_NO();
            
            String farmerRegNoFinal;
            if (farmer_reg_no.equalsIgnoreCase(farmerRegNoDb)) 
            {
                farmerRegNoFinal = farmerRegNoDb;
            }
            else { farmerRegNoFinal = null;
            redirectAttributes.addFlashAttribute("msg", (Object)"<div class=\"alert alert-danger\"><b>Please Check Farmer Registration no !</b> </div>\r\n");
            return new ModelAndView((View)new RedirectView("verifyFarmer.obj"));
            }
            
            String ifscDbFinal;
            if (ifsc_code.equalsIgnoreCase(ifscDb)) {
                ifscDbFinal = ifsc_code;
            }
            else { ifscDbFinal = null;
            redirectAttributes.addFlashAttribute("msg", (Object)"<div class=\"alert alert-danger\"><b>Please Check Farmer IFSC Code !</b> </div>\r\n");
            return new ModelAndView((View)new RedirectView("verifyFarmer.obj"));
            }
            
            String accNoDbFinal;
            if (ac_no.equalsIgnoreCase(accNoDb))
            {
                accNoDbFinal = ac_no;
            }
            else {
            	accNoDbFinal = null;
            redirectAttributes.addFlashAttribute("msg", (Object)"<div class=\"alert alert-danger\"><b>Please Check Farmer Acount No !</b> </div>\r\n");
            return new ModelAndView((View)new RedirectView("verifyFarmer.obj"));
            }
            
            String farmerNameFinal;
            if (farmer_name.equalsIgnoreCase(farmerNameDb)) 
            {
                farmerNameFinal = farmer_name;
            }
            else { farmerNameFinal = null;
            redirectAttributes.addFlashAttribute("msg", (Object)"<div class=\"alert alert-danger\"><b>Please Check Farmer Name !</b> </div>\r\n");
            return new ModelAndView((View)new RedirectView("verifyFarmer.obj"));
            }
            
            final VerifyFarmerModel verifyFarmer = new VerifyFarmerModel();
            verifyFarmer.setAccountno(accNoDbFinal);
            verifyFarmer.setFarmername(farmerNameFinal);
            verifyFarmer.setIfsccode(ifscDbFinal);
            verifyFarmer.setRegno(farmerRegNoFinal);
           // verifyFarmer.setIdentityProofType(idProofTypeFinal);
            //verifyFarmer.setIdentityProofNumber(idProofNumberFinal);
            verifyFarmer.setStatus(1);
            verifyFarmer.setVerificationdate(new Date());
            verifyFarmer.setRegno(farmer_reg_no);
            final Boolean verifyRow = this.verifyFarmerService.duplicateVerificationEntryNumberCheck(farmer_reg_no);
            if (verifyRow) {
                this.verifyFarmerService.submitform(verifyFarmer);
            }
            String dcpid= (String)request.getSession().getAttribute("dpcId");
            final List<FarmerRegModelDTO> allFarmersList = (List<FarmerRegModelDTO>)this.farmerRegService.verificationStatus( placeofactivity,  regionId,  zoneId);
            final VerifyFarmerModel farmerById = this.verifyFarmerService.findbyReg(farmer_reg_no);
			if (farmerById.getRegno() != null && farmerById.getIfsccode() != null && farmerById.getAccountno() != null
					&& farmerById.getFarmername() != null) 
			{
				//System.out.println("update verification status");
                this.farmerRegService.updateVerificationStatus(id);
            }
            mv.addObject("allFarmersList", (Object)allFarmersList);
        }
        catch (Exception ex) { 
        	System.out.println("saveVerification error = "+ex.getLocalizedMessage());
        }
        mv.addObject("msg", (Object)"success");
        mv.addObject("farmerdetails", (Object)new FarmerRegModel());
        
        return new ModelAndView((View)new RedirectView("ViewFarmerRegistration.obj"));
    }
    
    @RequestMapping(value = { "editFarmerReg" }, method = { RequestMethod.GET })
    public ModelAndView editFarmerReg(final HttpServletRequest request) {
    	String username =(String)request.getSession().getAttribute("usrname");
        ModelAndView mv = new ModelAndView("editfarmerRegistration");
        if(username == null) {
        	return mv = new ModelAndView("index");
            }
        try {
        if (request.getParameter("id") != null) {
        	String key = LoginController.secretkey;
    		//String decryptedString = request.getParameter("id");
    		//String decryptedString = URLDecoder.decode(request.getParameter("id"), "UTF-8");
    		//final int id = Integer.parseInt(Encry.decrypt(decryptedString, key));
        	int id = Integer.parseInt(request.getParameter("id"));
            final FarmerRegModel farmerDetailsById = this.farmerRegService.find(id);
            String state = stateList.statebyid(farmerDetailsById.getF_STATE());
            List<String> alldistrict = distric.findByDistrictId(farmerDetailsById.getF_District());
            String district = alldistrict.get(0);
            int policestation = Integer.parseInt(farmerDetailsById.getPolice_station());
            PoliceStationModel policemodel = PoliceStationService.find(policestation);
            
            farmerDetailsById.setF_STATE(state);
            farmerDetailsById.setF_District(district);
            farmerDetailsById.setPolice_station(policemodel.getPolice_stationName());
            
            final List<StateList> Liststate = (List<StateList>)this.stateList.getAll();
            mv.addObject("Liststate", (Object)Liststate);
            mv.addObject("farmerDetailsById", (Object)farmerDetailsById);
        }
        }
        catch(Exception e) {
        	e.printStackTrace();
        }
        return mv;
    }
    @RequestMapping(value = { "viewFarmerReg" }, method = { RequestMethod.GET })
    public ModelAndView viewFarmerReg(final HttpServletRequest request, final HttpServletResponse response, RedirectAttributes red) {
    	String username =(String)request.getSession().getAttribute("usrname");
        ModelAndView mv = new ModelAndView("viewFarmerDetail");
        if(username == null) {
        	return mv = new ModelAndView("index");
            }
        String pagename = "viewFarmerReg";
        int i = checkprivileges(pagename);
        if(i != 1)
        {
        	 red.addFlashAttribute("errorMessage","Access denied");
			   return mv=new ModelAndView("Home");
        }
        try {
        if (request.getParameter("id") != null) {
        	String key = LoginController.secretkey;
    		String decryptedString = request.getParameter("id");
    		final int id = Integer.parseInt(Encry.decrypt(decryptedString, key));
            final List<FarmerRegModel> farmerDetailsById = this.farmerRegService.findDetails(id);
            final List<StateList> Liststate = (List<StateList>)this.stateList.getAll();
            System.err.println("Liststate---------------"+Liststate);
            mv.addObject("Liststate", (Object)Liststate);
            mv.addObject("farmerDetailsById", (Object)farmerDetailsById);
        }
        }
        catch(Exception e) {
        	e.printStackTrace();
        	try {
				request.getRequestDispatcher("/WebContent/errorPage.jsp").forward(request, response);
			} catch (ServletException e1) {
				e1.printStackTrace();
			} catch (IOException e1) {
				e1.printStackTrace();
			};
        }
        return mv;
    }
	
	/*
	 * @RequestMapping({ "EditsaveFarmerRegistrationMid" }) public ModelAndView
	 * EditsaveFarmerRegistrationMid(final HttpServletRequest request, final
	 * RedirectAttributes redirectAttributes, @RequestParam("F_DOC_Mandate") final
	 * MultipartFile F_DOC_Mandate) { final ModelAndView mv = new ModelAndView();
	 * try { final int idPrimary =
	 * Integer.parseInt(request.getParameter("idPrimary")); final FarmerRegModel
	 * farmerRegModel = this.farmerRegService.find(idPrimary); File file = null;
	 * String pathurl = ""; String url = ""; if (!F_DOC_Mandate.isEmpty()) { file =
	 * new
	 * File("E:\\Program Files\\Apache Software Foundation\\Tomcat 8.5\\webapps\\FarmerRegistration\\mandate_"
	 * + F_DOC_Mandate.getOriginalFilename());
	 * 
	 * try {
	 * 
	 * final OutputStream os = new FileOutputStream(file);
	 * os.write(F_DOC_Mandate.getBytes()); os.close(); } catch (Exception e) {
	 * e.printStackTrace(); } pathurl = file.getAbsolutePath(); final String path =
	 * url =F_DOC_Mandate.getOriginalFilename();
	 * farmerRegModel.setF_DOC_Mandate(url);
	 * 
	 * } this.farmerRegService.create(farmerRegModel);
	 * redirectAttributes.addFlashAttribute("msg",
	 * (Object)"<div class=\"alert alert-success\"><b>Success !</b> Record Edit successfully.</div>\r\n"
	 * ); } catch (Exception e2) { System.out.println(e2);
	 * redirectAttributes.addFlashAttribute("msg",
	 * (Object)"<div class=\"alert alert-dange\"><b>Failure !</b> Error in saving record. Please try again</div>\r\n"
	 * ); } return new ModelAndView((View)new
	 * RedirectView("ViewFarmerRegistration.obj")); }
	 */
    
	/*
	 * @RequestMapping({ "EditsaveFarmerRegistrationMid" }) public ModelAndView
	 * EditsaveFarmerRegistrationMid(final HttpServletRequest request, final
	 * RedirectAttributes redirectAttributes, @RequestParam("F_DOC_Mandate") final
	 * MultipartFile F_DOC_Mandate) { final ModelAndView mv = new ModelAndView();
	 * try { final int idPrimary =
	 * Integer.parseInt(request.getParameter("idPrimary")); final FarmerRegModel
	 * farmerRegModel = this.farmerRegService.find(idPrimary); File file = null;
	 * String pathurl = ""; String url = ""; if (!F_DOC_Mandate.isEmpty()) { //file
	 * = new File("C:\\New folder\\mandate_" + F_DOC_Mandate.getOriginalFilename());
	 * // file = new File(this.mendate + F_DOC_Mandate.getOriginalFilename()); file
	 * = new
	 * File("E:\\Program Files\\Apache Software Foundation\\Tomcat 8.5\\webapps\\FarmerRegistration\\"
	 * + F_DOC_Mandate.getOriginalFilename()); try {
	 * System.out.println("file=====>>>>>" + file); final OutputStream os = new
	 * FileOutputStream(file); os.write(F_DOC_Mandate.getBytes()); os.close(); }
	 * catch (Exception e) { e.printStackTrace();
	 * System.out.println("Exception=====>>>>>" + e.getLocalizedMessage()); }
	 * pathurl = file.getAbsolutePath(); final String path = url
	 * =F_DOC_Mandate.getOriginalFilename(); farmerRegModel.setF_DOC_Mandate(url);
	 * 
	 * } this.farmerRegService.create(farmerRegModel);
	 * redirectAttributes.addFlashAttribute("msg",
	 * (Object)"<div class=\"alert alert-success\"><b>Success !</b> Record Edit successfully.</div>\r\n"
	 * ); } catch (Exception e2) { System.out.println(e2);
	 * redirectAttributes.addFlashAttribute("msg",
	 * (Object)"<div class=\"alert alert-dange\"><b>Failure !</b> Error in saving record. Please try again</div>\r\n"
	 * ); } return null;//new ModelAndView((View)new
	 * RedirectView("ViewFarmerRegistration.obj")); }
	 */
    @RequestMapping(value = { "editGradesPrice" }, method = { RequestMethod.GET })
    public ModelAndView editGradesPrice(final HttpServletRequest request, HttpSession session, RedirectAttributes red) {
       String username =(String)request.getSession().getAttribute("usrname");
        ModelAndView mv = new ModelAndView("editGradesPrice");
        String pagename = "editGradesPrice";
        int i = checkprivileges(pagename);
        if(i != 1)
        {
        	 red.addFlashAttribute("errorMessage","Access denied");
			   return mv=new ModelAndView("Home");
        }
        if (request.getParameter("id") != null) {
       	    String key = LoginController.secretkey;
	    	String decryptedString = request.getParameter("id");
	    	final int id = Integer.parseInt(Encry.decrypt(decryptedString, key));
            session.setAttribute("msp_id", id);
          
            final MSPPriceCalculationModel msppricecal = this.mSPPriceCalculationService.find(id);
            mv.addObject("editGradesPrice", (Object)msppricecal);
        }
        if(username == null) {
             return mv = new ModelAndView("index");
            }
        return mv;
    }
       
    @RequestMapping("updateGradesPrice")
    public ModelAndView updateeditGradesPrice(final HttpServletRequest request, final RedirectAttributes redirectAttributes) {
       String username =(String)request.getSession().getAttribute("usrname");
        ModelAndView mv = new ModelAndView("editGradesPrice");
        try {
                    //int mspid =(int)request.getSession().getAttribute("msp_id");
             int mspid = Integer.parseInt(request.getParameter("id"));
              
        final String jutevariety = request.getParameter("jutevariety");
        final String cropyr = request.getParameter("cropyr");
        final String grade0 = request.getParameter("g0");
        final String grade2 = request.getParameter("g1");
        final String grade3 = request.getParameter("g2");
        final String grade4 = request.getParameter("g3");
        final String grade5 = request.getParameter("g4");
        final String grade6 = request.getParameter("g5");
        final String grade7 = request.getParameter("g6");
        final String grade8 = request.getParameter("g7");
        if(isStringValid(jutevariety) || isStringValid(cropyr) ||isStringValid(grade0) ||isStringValid(grade2) || isStringValid(grade3) || isStringValid(grade4)
                || isStringValid(grade5) || isStringValid(grade6) ||isStringValid(grade7) || isStringValid(grade8)
            	)
            {
              redirectAttributes.addFlashAttribute("msg", (Object)"<div class=\"alert alert-danger\"><b>Allowed only Alphabates and Numbers!</b> </div>\r\n");
              return new ModelAndView((View)new RedirectView("editGradesPrice.obj"));
            }
        final MSPPriceCalculationModel mspPriceCalculationModel = new MSPPriceCalculationModel();
        mspPriceCalculationModel.setmsp_id(mspid);
       
      
        mspPriceCalculationModel.setJute_variety(jutevariety);
        mspPriceCalculationModel.setCrop_yr(cropyr);
        if (grade0 != null && grade0 != "0.0") {
            mspPriceCalculationModel.setGrade1(Double.parseDouble(grade0));
        }
        if (grade2 != null && grade2 != "0.0") {
            mspPriceCalculationModel.setGrade2(Double.parseDouble(grade2));
        }
        if (grade3 != null && grade3 != "0.0") {
            mspPriceCalculationModel.setGrade3(Double.parseDouble(grade3));
        }
        if (grade4 != null && grade4 != "0.0") {
            mspPriceCalculationModel.setGrade4(Double.parseDouble(grade4));
        }
        if (grade5 != null && grade5 != "0.0") {
            mspPriceCalculationModel.setGrade5(Double.parseDouble(grade5));
        }
        if (grade6 != null && grade6 != "0.0") {
            mspPriceCalculationModel.setGrade6(Double.parseDouble(grade6));
        }
        if (grade7 != null && grade7 != "0.0") {
            mspPriceCalculationModel.setGrade7(Double.parseDouble(grade7));
        }
        if (grade8 != null && grade8 != "0.0") {
            mspPriceCalculationModel.setGrade8(Double.parseDouble(grade8));
        }

   // mspPriceCalculationModel.setCreated_date(new Date());
        this.mSPPriceCalculationService.update(mspPriceCalculationModel);
       
        if(username == null) {
             return new ModelAndView("index");
            }
        return new ModelAndView((View)new RedirectView("mspGradesPriceList.obj"));
    }
    catch (Exception e) {
        return mv;
    }
}
   
    
    @RequestMapping({ "deletemspGradesPriceList" })
    public ModelAndView deletemspGradesPriceList( final HttpServletRequest request, final RedirectAttributes redirectAttributes) {
       String username =(String)request.getSession().getAttribute("usrname");
       ModelAndView mv = new ModelAndView("mspGradesPriceList");
        try {
               final String id = request.getParameter("id");
              this.mSPPriceCalculationService.delete(Integer.parseInt(id));
        final List<MSPPriceCalculationModel> msppriceList = (List<MSPPriceCalculationModel>)this.mSPPriceCalculationService.getAll();
        mv.addObject("msppriceList", (Object)msppriceList);
        redirectAttributes.addFlashAttribute("msg", (Object)"<div class=\"alert alert-success\"><b>Success !</b> Data deleted successfully.</div>\r\n");
        if(username == null) {
             return mv = new ModelAndView("index");
            }
        return new ModelAndView((View)new RedirectView("mspGradesPriceList.obj"));
        }
          catch (Exception ex) {
               return mv;
           }
    }

    @RequestMapping({ "EditsaveFarmerRegistrationMid" })
    public ModelAndView EditsaveFarmerRegistrationMid(final HttpServletRequest request, final RedirectAttributes redirectAttributes, @RequestParam("F_DOC_Mandate") final MultipartFile F_DOC_Mandate) {
        final ModelAndView mv = new ModelAndView();
        String username =(String)request.getSession().getAttribute("usrname");
        if(username == null) {
        	return new ModelAndView("index");
            }
        try {
            final int idPrimary = Integer.parseInt(request.getParameter("idPrimary"));
            final FarmerRegModel farmerRegModel = this.farmerRegService.find(idPrimary);
            File file = null;
            String pathurl = "";
            String url = "";
            if (!F_DOC_Mandate.isEmpty()) {
                file = new File("E:\\Program Files\\Apache Software Foundation\\Tomcat 8.5\\webapps\\FarmerRegistration\\mandate_" + farmerRegModel.getF_REG_NO()+"_"+F_DOC_Mandate.getOriginalFilename());
                try {
                    final OutputStream os = new FileOutputStream(file);
                    os.write(F_DOC_Mandate.getBytes());
                    os.close();
                }
                catch (Exception e) {
                    e.printStackTrace();
                }
                pathurl = file.getAbsolutePath();
                final String path = url = "mandate_" +farmerRegModel.getF_REG_NO()+"_"+ F_DOC_Mandate.getOriginalFilename();
                farmerRegModel.setIS_VERIFIED(0);
                farmerRegModel.setF_DOC_Mandate(url);
            }
            this.farmerRegService.create(farmerRegModel);
            redirectAttributes.addFlashAttribute("msg", (Object)"<div class=\"alert alert-success\"><b>Success !</b> Record Edit successfully.</div>\r\n");
        }
        catch (Exception e2) {
            System.out.println(e2);
            redirectAttributes.addFlashAttribute("msg", (Object)"<div class=\"alert alert-dange\"><b>Failure !</b> Error in saving record. Please try again</div>\r\n");
        }
        
        return new ModelAndView((View)new RedirectView("ViewFarmerRegistration.obj"));
    }

    
    @RequestMapping({ "saveCommercialCeilingPriceIntimation" })
    public ModelAndView saveCommercialCeilingPriceIntimation(final HttpServletRequest request) {
    	String username =(String)request.getSession().getAttribute("usrname");
    	if(username == null) {
        	return new ModelAndView("index");
            }
        try {
            final SimpleDateFormat formatter1 = new SimpleDateFormat("yyyy-MM-dd");
            final String dpccode = request.getParameter("dpccode");
            final String dateofentry = request.getParameter("dateofentry");
            final Date date1 = formatter1.parse(dateofentry);
            final String dateofeffect = request.getParameter("dateofeffect");
            final Date date2 = formatter1.parse(dateofeffect);
            final String jutevariety = request.getParameter("jutevariety");
            final String ceilingquantity = request.getParameter("ceilingquantity");
            final String jutegrade = request.getParameter("jutegrade");
            final String ceilingprice = request.getParameter("ceilingprice");
            final CommercialCeilingPriceIntimationModel addCommercialCeilingPriceIntimationModel = new CommercialCeilingPriceIntimationModel();
            addCommercialCeilingPriceIntimationModel.setDpccode(dpccode);
            addCommercialCeilingPriceIntimationModel.setDateofentry(date1);
            addCommercialCeilingPriceIntimationModel.setDateofeffect(date2);
            addCommercialCeilingPriceIntimationModel.setJutevariety(jutevariety);
            addCommercialCeilingPriceIntimationModel.setCeilingquantity(ceilingquantity);
            addCommercialCeilingPriceIntimationModel.setJutegrade(jutegrade);
            addCommercialCeilingPriceIntimationModel.setCeilingprice(ceilingprice);
            addCommercialCeilingPriceIntimationModel.setCreateddate(new Date());
            this.commercialCeilingPriceIntimationService.create(addCommercialCeilingPriceIntimationModel);
        }
        catch (Exception ex) {
        	ex.printStackTrace();
        }
        
        return new ModelAndView((View)new RedirectView("CommercialCeilingPriceIntimations.obj"));
    }
    
    @RequestMapping({ "CommercialCeilingPriceIntimations" })
    public ModelAndView CommercialCeilingPriceIntimations(final HttpServletRequest request) {
    	String username =(String)request.getSession().getAttribute("usrname");
        ModelAndView mv = new ModelAndView("CommercialCeilingPriceIntimations");
        if(username == null) {
        	return new ModelAndView("index");
            }
        return mv;
    }
    
    @RequestMapping({ "Distributionoftallyslips" })
    public ModelAndView Distributionoftallyslips(final HttpServletRequest request,RedirectAttributes red) {
    	String username =(String)request.getSession().getAttribute("usrname");
         ModelAndView mv = new ModelAndView("Distributionoftallyslips");
        if(username == null) {
        	return new ModelAndView("index");
            }
        String pagename = "Distributionoftallyslips";
        int i = checkprivileges(pagename);
        if(i != 1)
        {
        	 red.addFlashAttribute("errorMessage","Access denied");
			   return mv=new ModelAndView("Home");
        }
        try {
            final List<ZoneModel> zoneList = (List<ZoneModel>)this.zoneService.getAll();
            final List<RoleMasterModel> roleList = (List<RoleMasterModel>)this.roleService.getAll();
            mv.addObject("zoneList", (Object)zoneList);
            mv.addObject("roleList", (Object)roleList);
            
            }
            catch(Exception e) {
            	e.printStackTrace();
            }
        return mv;
    }
    
    @RequestMapping({ "saveDistributionoftallyslip" })
    public ModelAndView saveDistributionoftallyslip(final HttpServletRequest request, final RedirectAttributes redirectAttributes) {
    	String username =(String)request.getSession().getAttribute("usrname");
    	 if(username == null) {
         	return new ModelAndView("index");
             }
        try {
            final SimpleDateFormat formatter1 = new SimpleDateFormat("dd-MM-yyyy");
            final String dpccode = request.getParameter("dpccode");
            final String dateofreceipt = request.getParameter("dateofreceipt");
            final Date date1 = formatter1.parse(dateofreceipt);
            final String slipreceived = request.getParameter("slipreceived");
            final String seriesstartfrom = request.getParameter("seriesstartfrom");
            final String seriestoend = request.getParameter("seriestoend");
            final String zone = request.getParameter("zone");
            final String region = request.getParameter("region");
            if(isStringValid(dpccode) || isStringValid(dateofreceipt) || isStringValid(slipreceived) || isStringValid(seriesstartfrom) || isStringValid(seriestoend)
                    || isStringValid(zone) || isStringValid(region))
                {
                  redirectAttributes.addFlashAttribute("msg", (Object)"<div class=\"alert alert-danger\"><b>Allowed only Alphabates and Numbers!</b> </div>\r\n");
                  return new ModelAndView((View)new RedirectView("Distributionoftallyslips.obj"));
                }
            
            final DistributionoftallyslipModel addDistributionoftallyslipModel = new DistributionoftallyslipModel();
            addDistributionoftallyslipModel.setDpccode(dpccode);
            addDistributionoftallyslipModel.setDateofreceipt(dateofreceipt);
            addDistributionoftallyslipModel.setSlipreceived(slipreceived);
            addDistributionoftallyslipModel.setSeriesstartfrom(seriesstartfrom);
            addDistributionoftallyslipModel.setSeriestoend(seriestoend);
            addDistributionoftallyslipModel.setCreateddate(new Date());
            addDistributionoftallyslipModel.setZone(zone);
            addDistributionoftallyslipModel.setRegion(region);
            this.distributionoftallyslipService.create(addDistributionoftallyslipModel);
            redirectAttributes.addFlashAttribute("msg", (Object)"<div class=\"alert alert-success\"><b>Success !</b> Record saved successfully.</div>\r\n");
        }
        catch (Exception ex) {
        	ex.printStackTrace();
        }
       
        return new ModelAndView((View)new RedirectView("Distributionoftallyslips.obj"));
    }
    
    @RequestMapping({ "viewDistributionoftallyslips" })
    public ModelAndView viewDistributionoftallyslips(final HttpServletRequest request,RedirectAttributes red) {
    	ModelAndView mv = new ModelAndView("viewDistributionoftallyslips");
    	String username =(String)request.getSession().getAttribute("usrname");
    	if(username == null) {
         	return mv = new ModelAndView("index");
             }
    	String pagename = "viewDistributionoftallyslips";
        int i = checkprivileges(pagename);
        if(i != 1)
        {
        	 red.addFlashAttribute("errorMessage","Access denied");
			   return mv=new ModelAndView("Home");
        }
    	try {
            String dpcId =(String)request.getSession().getAttribute("dpcId");
            
            final List<DistributionoftallyslipModel> allDistributionoftallyslips = (List<DistributionoftallyslipModel>)this.distributionoftallyslipService.getAll(dpcId);
            mv.addObject("DistributionoftallyslipsList", (Object)allDistributionoftallyslips);
    		   
        	}
           catch(Exception e) {
        	   e.printStackTrace();
           }
        return mv;
    }
    
    @ResponseBody
    @RequestMapping(value = { "validateAccount" }, method = { RequestMethod.GET })
    public String validateAccount(final HttpServletRequest request) {
        final Gson gson = new Gson();
        final boolean abc = this.farmerRegService.validateAccount(request.getParameter("accNo"));
        return this.farmerRegService.validateAccount(request.getParameter("accNo")) + "";
    }
    
    @RequestMapping({ "viewUserRegistration" })
    public ModelAndView viewUserRegistration(final HttpServletRequest request,RedirectAttributes red) {
    	String username =(String)request.getSession().getAttribute("usrname");
    	 ModelAndView mv = new ModelAndView("viewUserRegistration");
    	 String pagename = "viewUserRegistration";
         int i = checkprivileges(pagename);
         if(i != 1)
         {
         	 red.addFlashAttribute("errorMessage","Access denied");
 			   return mv=new ModelAndView("Home");
         }
    	if(username != null) {
        	String placeofactivity =(String)request.getSession().getAttribute("dpcId");
         	String regionId =(String)request.getSession().getAttribute("regionId");
         	String zoneId =(String)request.getSession().getAttribute("zoneId");
            String dpc_code =(String)request.getSession().getAttribute("dpcId");
        String dpcId =(String)request.getSession().getAttribute("dpcId");
        final List<UserRegistrationModel> allUserRegistration = (List<UserRegistrationModel>)this.UserRegistrationService.getAll( dpc_code,  regionId,  zoneId);
        mv.addObject("UserRegistrationList", (Object)allUserRegistration);
    	}
        else{
        	return mv = new ModelAndView("index");
            }
        return mv;
    }
    
    @ResponseBody
    @RequestMapping(value = { "validateMobile" }, method = { RequestMethod.GET })
    public String validateMobile(final HttpServletRequest request) {
    	
        final Gson gson = new Gson();
        return this.farmerRegService.validateMobile(request.getParameter("mobileno")) + "";
    }
    
    @ResponseBody
    @RequestMapping(value = { "validateEmail" }, method = { RequestMethod.GET })
    public String validateEmail(final HttpServletRequest request) {
    	
        final Gson gson = new Gson();
        return this.UserRegistrationService.validateEmail(request.getParameter("Email")) + "";
    }
    
    @ResponseBody
    @RequestMapping(value = { "validateAdhar" }, method = { RequestMethod.GET })
    public String validateAdhar(final HttpServletRequest request) {
        final Gson gson = new Gson();
        return this.farmerRegService.validateAdhar(request.getParameter("adharNo")) + "";
    }
    
    @RequestMapping({ "viewProcurementList" })
    public ModelAndView viewProcurementList(final HttpServletRequest request) {
    	String username =(String)request.getSession().getAttribute("usrname");
        ModelAndView mv = new ModelAndView("procurementList");
        if(username == null) {
        	return mv = new ModelAndView("index");
            }
        try {
        final List<RawJuteProcurementAndPayment> allProcurementList = (List<RawJuteProcurementAndPayment>)this.rawJuteProcurAndPayService.getAll();
        mv.addObject("procurementList", (Object)allProcurementList);
        }
        catch(Exception e) {
        	e.printStackTrace();
        }
        return mv;
    }
    
    @RequestMapping({ "verificationTallyslip" })
    public ModelAndView verificationTallyslips(final HttpServletRequest request) {
    	String username =(String)request.getSession().getAttribute("usrname");
        ModelAndView mv = new ModelAndView("verifyTallySlip");
        if(username == null) {
        	return mv = new ModelAndView("index");
            }
        final String tally = request.getParameter("tally");
        mv.addObject("tally", (Object)tally);
       
        return mv;
    }
    
    @RequestMapping({ "saveTallySlipMid" })
    public ModelAndView saveTallySlipMid(final HttpServletRequest request , final RedirectAttributes redirectAttributes) {
    	String username =(String)request.getSession().getAttribute("usrname");
        ModelAndView mv = new ModelAndView("tallyapproval");
        if(username == null) {
        	return mv = new ModelAndView("index");
            }
        try {
            final String farmerRegNo = request.getParameter("farmerRegNo");
            final String tallyNo = request.getParameter("tallyNo");
            final String dateOfPurchase = request.getParameter("dateOfPurchase");
            final String rateSlipNumber = request.getParameter("rateSlipNumber");
            final String binNumber = request.getParameter("binNumber");
            final String juteVariety = request.getParameter("juteVariety");
            String errors = request.getParameter("error");
            final String status = request.getParameter("status");
            final String grsqty = request.getParameter("grsqty");
            String placeofp = request.getParameter("placeofp");

            
            int is_verified = 0;
            if (status.equalsIgnoreCase("FA")) {
                is_verified = 1;
            }
            else {
                is_verified = 0;
            }
            final String drumWiseQuantity1 = request.getParameter("drumWiseQuantity1");
            final String drumWiseQuantity2 = request.getParameter("drumWiseQuantity2");
            final String drumWiseQuantity3 = request.getParameter("drumWiseQuantity3");
            final String drumWiseQuantity4 = request.getParameter("drumWiseQuantity4");
            final String drumWiseQuantity5 = request.getParameter("drumWiseQuantity5");
            final String drumWiseQuantity6 = request.getParameter("drumWiseQuantity6");
            final String drumWiseQuantity7 = request.getParameter("drumWiseQuantity7");
            final String drumWiseQuantity8 = request.getParameter("drumWiseQuantity8");
            final String drumWiseQuantity9 = request.getParameter("drumWiseQuantity9");
            final String drumWiseQuantity10 = request.getParameter("drumWiseQuantity10");
            final String drumWiseQuantity11 = request.getParameter("drumWiseQuantity11");
            final String drumWiseQuantity12 = request.getParameter("drumWiseQuantity12");
            final String drumWiseQuantity13 = request.getParameter("drumWiseQuantity13");
            final String drumWiseQuantity14 = request.getParameter("drumWiseQuantity14");
            final String drumWiseQuantity15 = request.getParameter("drumWiseQuantity15");
            final String drumWiseQuantity16 = request.getParameter("drumWiseQuantity16");
            final String drumWiseQuantity17 = request.getParameter("drumWiseQuantity17");
            final String drumWiseQuantity18 = request.getParameter("drumWiseQuantity18");
            final String drumWiseQuantity19 = request.getParameter("drumWiseQuantity19");
            final String drumWiseQuantity20 = request.getParameter("drumWiseQuantity20");
            final String drumWiseQuantity21 = request.getParameter("drumWiseQuantity21");
            final String drumWiseQuantity22 = request.getParameter("drumWiseQuantity22");
            final String drumWiseQuantity23 = request.getParameter("drumWiseQuantity23");
            final String drumWiseQuantity24 = request.getParameter("drumWiseQuantity24");
            final String drumWiseQuantity25 = request.getParameter("drumWiseQuantity25");
            final String drumWiseQuantity26 = request.getParameter("drumWiseQuantity26");
            final String drumWiseQuantity27 = request.getParameter("drumWiseQuantity27");
            final String drumWiseQuantity28 = request.getParameter("drumWiseQuantity28");
            final String drumWiseQuantity29 = request.getParameter("drumWiseQuantity29");
            final String drumWiseQuantity30 = request.getParameter("drumWiseQuantity30");
            final String drumWiseQuantity31 = request.getParameter("drumWiseQuantity31");
            final String drumWiseQuantity32 = request.getParameter("drumWiseQuantity32");
            final String drumWiseQuantity33 = request.getParameter("drumWiseQuantity33");
            final String drumWiseQuantity34 = request.getParameter("drumWiseQuantity34");
            final String drumWiseQuantity35 = request.getParameter("drumWiseQuantity35");
            final String drumWiseQuantity36 = request.getParameter("drumWiseQuantity36");
            final String drumWiseQuantity37 = request.getParameter("drumWiseQuantity37");
            final String drumWiseQuantity38 = request.getParameter("drumWiseQuantity38");
            final String drumWiseQuantity39 = request.getParameter("drumWiseQuantity39");
            final String drumWiseQuantity40 = request.getParameter("drumWiseQuantity40");
            final String drumWiseQuantity41 = request.getParameter("drumWiseQuantity41");
            final String drumWiseQuantity42 = request.getParameter("drumWiseQuantity42");
            final String drumWiseQuantity43 = request.getParameter("drumWiseQuantity43");
            final String drumWiseQuantity44 = request.getParameter("drumWiseQuantity44");
            final String drumWiseQuantity45 = request.getParameter("drumWiseQuantity45");
            final String drumWiseQuantity46 = request.getParameter("drumWiseQuantity46");
            final String drumWiseQuantity47 = request.getParameter("drumWiseQuantity47");
            final String drumWiseQuantity48 = request.getParameter("drumWiseQuantity48");
            final String drumWiseQuantity49 = request.getParameter("drumWiseQuantity49");
            final String drumWiseQuantity50 = request.getParameter("drumWiseQuantity50");
            final String placeOfPurchase = request.getParameter("placeOfPurchase");
            final String netQuantity = request.getParameter("netQuantity");
            final String garsatRate = request.getParameter("garsatRate");
            final String amountPayable = request.getParameter("amountPayable");
            final VerifyTallySlip verifyTallySlip = new VerifyTallySlip();
            String Region_id =(String)request.getSession().getAttribute("region");
            String zoneId =(String)request.getSession().getAttribute("zoneId");
            verifyTallySlip.setRegion_id(Region_id);
            verifyTallySlip.setZone_id(zoneId);
            verifyTallySlip.setIs_varified(is_verified);
            verifyTallySlip.setStatus(status);
            verifyTallySlip.setErrors(errors);
            verifyTallySlip.setGrossqty(Double.parseDouble(grsqty));
            verifyTallySlip.setFarmerRegNo(farmerRegNo);
            verifyTallySlip.setTallyNo(tallyNo);
            verifyTallySlip.setRateslipno(Integer.parseInt(rateSlipNumber));
            verifyTallySlip.setBinno(Integer.parseInt(binNumber));
            verifyTallySlip.setJutevariety(juteVariety);
            verifyTallySlip.setPayment_status(0);
            if (drumWiseQuantity1 != "" && drumWiseQuantity1 != null) {
                verifyTallySlip.setDrumWiseQuantity1(Double.parseDouble(drumWiseQuantity1));
            }
            if (drumWiseQuantity2 != "" && drumWiseQuantity2 != null) {
                verifyTallySlip.setDrumWiseQuantity2(Double.parseDouble(drumWiseQuantity2));
            }
            if (drumWiseQuantity3 != "" && drumWiseQuantity3 != null) {
                verifyTallySlip.setDrumWiseQuantity3(Double.parseDouble(drumWiseQuantity3));
            }
            if (drumWiseQuantity4 != "" && drumWiseQuantity4 != null) {
                verifyTallySlip.setDrumWiseQuantity4(Double.parseDouble(drumWiseQuantity4));
            }
            if (drumWiseQuantity5 != "" && drumWiseQuantity5 != null) {
                verifyTallySlip.setDrumWiseQuantity5(Double.parseDouble(drumWiseQuantity5));
            }
            if (drumWiseQuantity6 != "" && drumWiseQuantity6 != null) {
                verifyTallySlip.setDrumWiseQuantity6(Double.parseDouble(drumWiseQuantity6));
            }
            if (drumWiseQuantity7 != "" && drumWiseQuantity7 != null) {
                verifyTallySlip.setDrumWiseQuantity7(Double.parseDouble(drumWiseQuantity7));
            }
            if (drumWiseQuantity8 != "" && drumWiseQuantity8 != null) {
                verifyTallySlip.setDrumWiseQuantity8(Double.parseDouble(drumWiseQuantity8));
            }
            if (drumWiseQuantity9 != "" && drumWiseQuantity9 != null) {
                verifyTallySlip.setDrumWiseQuantity9(Double.parseDouble(drumWiseQuantity9));
            }
            if (drumWiseQuantity10 != "" && drumWiseQuantity10 != null) {
                verifyTallySlip.setDrumWiseQuantity10(Double.parseDouble(drumWiseQuantity10));
            }
            if (drumWiseQuantity11 != "" && drumWiseQuantity11 != null) {
                verifyTallySlip.setDrumWiseQuantity11(Double.parseDouble(drumWiseQuantity11));
            }
            if (drumWiseQuantity12 != "" && drumWiseQuantity12 != null) {
                verifyTallySlip.setDrumWiseQuantity12(Double.parseDouble(drumWiseQuantity12));
            }
            if (drumWiseQuantity13 != "" && drumWiseQuantity13 != null) {
                verifyTallySlip.setDrumWiseQuantity13(Double.parseDouble(drumWiseQuantity13));
            }
            if (drumWiseQuantity14 != "" && drumWiseQuantity14 != null) {
                verifyTallySlip.setDrumWiseQuantity14(Double.parseDouble(drumWiseQuantity14));
            }
            if (drumWiseQuantity15 != "" && drumWiseQuantity15 != null) {
                verifyTallySlip.setDrumWiseQuantity15(Double.parseDouble(drumWiseQuantity15));
            }
            if (drumWiseQuantity16 != "" && drumWiseQuantity16 != null) {
                verifyTallySlip.setDrumWiseQuantity16(Double.parseDouble(drumWiseQuantity16));
            }
            if (drumWiseQuantity17 != "" && drumWiseQuantity17 != null) {
                verifyTallySlip.setDrumWiseQuantity17(Double.parseDouble(drumWiseQuantity17));
            }
            if (drumWiseQuantity18 != "" && drumWiseQuantity18 != null) {
                verifyTallySlip.setDrumWiseQuantity18(Double.parseDouble(drumWiseQuantity18));
            }
            if (drumWiseQuantity19 != "" && drumWiseQuantity19 != null) {
                verifyTallySlip.setDrumWiseQuantity19(Double.parseDouble(drumWiseQuantity19));
            }
            if (drumWiseQuantity20 != "" && drumWiseQuantity20 != null) {
                verifyTallySlip.setDrumWiseQuantity20(Double.parseDouble(drumWiseQuantity20));
            }
            if (drumWiseQuantity21 != "" && drumWiseQuantity21 != null) {
                verifyTallySlip.setDrumWiseQuantity21(Double.parseDouble(drumWiseQuantity21));
            }
            if (drumWiseQuantity22 != "" && drumWiseQuantity22 != null) {
                verifyTallySlip.setDrumWiseQuantity22(Double.parseDouble(drumWiseQuantity22));
            }
            if (drumWiseQuantity23 != "" && drumWiseQuantity23 != null) {
                verifyTallySlip.setDrumWiseQuantity23(Double.parseDouble(drumWiseQuantity23));
            }
            if (drumWiseQuantity24 != "" && drumWiseQuantity24 != null) {
                verifyTallySlip.setDrumWiseQuantity24(Double.parseDouble(drumWiseQuantity24));
            }
            if (drumWiseQuantity25 != "" && drumWiseQuantity25 != null) {
                verifyTallySlip.setDrumWiseQuantity25(Double.parseDouble(drumWiseQuantity25));
            }
            if (drumWiseQuantity26 != "" && drumWiseQuantity26 != null) {
                verifyTallySlip.setDrumWiseQuantity26(Double.parseDouble(drumWiseQuantity26));
            }
            if (drumWiseQuantity27 != "" && drumWiseQuantity27 != null) {
                verifyTallySlip.setDrumWiseQuantity27(Double.parseDouble(drumWiseQuantity27));
            }
            if (drumWiseQuantity28 != "" && drumWiseQuantity28 != null) {
                verifyTallySlip.setDrumWiseQuantity28(Double.parseDouble(drumWiseQuantity28));
            }
            if (drumWiseQuantity29 != "" && drumWiseQuantity29 != null) {
                verifyTallySlip.setDrumWiseQuantity29(Double.parseDouble(drumWiseQuantity29));
            }
            if (drumWiseQuantity30 != "" && drumWiseQuantity30 != null) {
                verifyTallySlip.setDrumWiseQuantity30(Double.parseDouble(drumWiseQuantity30));
            }
            if (drumWiseQuantity31 != "" && drumWiseQuantity31 != null) {
                verifyTallySlip.setDrumWiseQuantity31(Double.parseDouble(drumWiseQuantity31));
            }
            if (drumWiseQuantity32 != "" && drumWiseQuantity32 != null) {
                verifyTallySlip.setDrumWiseQuantity32(Double.parseDouble(drumWiseQuantity32));
            }
            if (drumWiseQuantity33 != "" && drumWiseQuantity33 != null) {
                verifyTallySlip.setDrumWiseQuantity33(Double.parseDouble(drumWiseQuantity33));
            }
            if (drumWiseQuantity34 != "" && drumWiseQuantity34 != null) {
                verifyTallySlip.setDrumWiseQuantity34(Double.parseDouble(drumWiseQuantity34));
            }
            if (drumWiseQuantity35 != "" && drumWiseQuantity35 != null) {
                verifyTallySlip.setDrumWiseQuantity35(Double.parseDouble(drumWiseQuantity35));
            }
            if (drumWiseQuantity36 != "" && drumWiseQuantity36 != null) {
                verifyTallySlip.setDrumWiseQuantity36(Double.parseDouble(drumWiseQuantity36));
            }
            if (drumWiseQuantity37 != "" && drumWiseQuantity37 != null) {
                verifyTallySlip.setDrumWiseQuantity37(Double.parseDouble(drumWiseQuantity37));
            }
            if (drumWiseQuantity38 != "" && drumWiseQuantity38 != null) {
                verifyTallySlip.setDrumWiseQuantity38(Double.parseDouble(drumWiseQuantity38));
            }
            if (drumWiseQuantity39 != "" && drumWiseQuantity39 != null) {
                verifyTallySlip.setDrumWiseQuantity39(Double.parseDouble(drumWiseQuantity39));
            }
            if (drumWiseQuantity40 != "" && drumWiseQuantity40 != null) {
                verifyTallySlip.setDrumWiseQuantity40(Double.parseDouble(drumWiseQuantity40));
            }
            if (drumWiseQuantity41 != "" && drumWiseQuantity41 != null) {
                verifyTallySlip.setDrumWiseQuantity41(Double.parseDouble(drumWiseQuantity41));
            }
            if (drumWiseQuantity42 != "" && drumWiseQuantity42 != null) {
                verifyTallySlip.setDrumWiseQuantity42(Double.parseDouble(drumWiseQuantity42));
            }
            if (drumWiseQuantity43 != "" && drumWiseQuantity43 != null) {
                verifyTallySlip.setDrumWiseQuantity43(Double.parseDouble(drumWiseQuantity43));
            }
            if (drumWiseQuantity44 != "" && drumWiseQuantity44 != null) {
                verifyTallySlip.setDrumWiseQuantity44(Double.parseDouble(drumWiseQuantity44));
            }
            if (drumWiseQuantity45 != "" && drumWiseQuantity45 != null) {
                verifyTallySlip.setDrumWiseQuantity45(Double.parseDouble(drumWiseQuantity45));
            }
            if (drumWiseQuantity46 != "" && drumWiseQuantity46 != null) {
                verifyTallySlip.setDrumWiseQuantity46(Double.parseDouble(drumWiseQuantity46));
            }
            if (drumWiseQuantity47 != "" && drumWiseQuantity47 != null) {
                verifyTallySlip.setDrumWiseQuantity47(Double.parseDouble(drumWiseQuantity47));
            }
            if (drumWiseQuantity48 != "" && drumWiseQuantity48 != null) {
                verifyTallySlip.setDrumWiseQuantity48(Double.parseDouble(drumWiseQuantity48));
            }
            if (drumWiseQuantity49 != "" && drumWiseQuantity49 != null) {
                verifyTallySlip.setDrumWiseQuantity49(Double.parseDouble(drumWiseQuantity49));
            }
            if (drumWiseQuantity50 != "" && drumWiseQuantity50 != null) {
                verifyTallySlip.setDrumWiseQuantity50(Double.parseDouble(drumWiseQuantity50));
            }
            verifyTallySlip.setAmountpayable(Double.parseDouble(amountPayable));
            verifyTallySlip.setGarsatrate(Double.parseDouble(garsatRate));
            verifyTallySlip.setNetquantity(Double.parseDouble(netQuantity));
            verifyTallySlip.setPlaceOfPurchase(placeOfPurchase); 
            verifyTallySlip.setPuchasedate(dateOfPurchase);
            errors = errors.replace("</br>", "");
            errors = errors.replace("'", "");
            final HttpSession session = request.getSession();
            String dpcid = "0000";
            String region = "00";
            if (session.getAttribute("dpcId") != null) {
                dpcid = (String)session.getAttribute("dpcId");
            }
            if (session.getAttribute("region") != null) {
                region = (String)session.getAttribute("region");
            }
            final boolean procupdate = this.rawJuteProcurAndPayService.updateProcurementerror(status, is_verified, tallyNo, errors.trim(), region,placeofp);
            //System.out.println(procupdate);
            if (procupdate) {
                this.verifyTallySlipService.submitform(verifyTallySlip);
              //  mv.addObject("msg", (Object)"<div class=\"alert alert-success\"><b>Success !</b> Tally slip verified successfully.</div>\r\n");
                redirectAttributes.addFlashAttribute("msg", (Object)"<div class=\"alert alert-success\"><b>Success !</b> Tally slip verified successfully.</div>\r\n");

            }
            else {
             //   mv.addObject("msg", (Object)"<div class=\"alert alert-Failed\"><b>Fail to save !</b> Tally slip verification failed.</div>\r\n");
                redirectAttributes.addFlashAttribute("msg", (Object)"<div class=\"alert alert-Failed\"><b>Success !</b>  Tally slip verification failed.</div>\r\n");

            }
        }
        catch (Exception e) {
           e.printStackTrace();
        }
        
        return new ModelAndView((View)new RedirectView("tallyapproval.obj"));
    }
    
    
	/*
	 * @RequestMapping({ "viewVerifiedTallySlipList" }) public ModelAndView
	 * viewVerifiedTallySlipList(final HttpServletRequest request) { String username
	 * =(String)request.getSession().getAttribute("usrname"); String dpcId
	 * =(String)request.getSession().getAttribute("dpcId"); ModelAndView mv = new
	 * ModelAndView("verifiedTallySlipList"); final List<VerifyTallySlip> verifyList
	 * = (List<VerifyTallySlip>)this.verifyTallySlipService.getAll("FA", dpcId);
	 * mv.addObject("verifyTallySliList", (Object)verifyList); if(username == null)
	 * { return mv = new ModelAndView("index"); } return mv; }
	 */
    
    @RequestMapping({ "viewVerifiedTallySlipList" })
    public ModelAndView viewVerifiedTallySlipList(final HttpServletRequest request,RedirectAttributes red) {
       String username =(String)request.getSession().getAttribute("usrname");
       ModelAndView mv = new ModelAndView("verifiedTallySlipList");
       if(username == null) {
           return mv = new ModelAndView("index");
          }
       String pagename = "viewVerifiedTallySlipList";
       int i = checkprivileges(pagename);
       if(i != 1)
       {
       	 red.addFlashAttribute("errorMessage","Access denied");
			   return mv=new ModelAndView("Home");
       }
       try {

    	String role_type = (String)request.getSession().getAttribute("roletype");
        String region =(String)request.getSession().getAttribute("regionId"); 
        final List<VerifyTallySlip> verifyList = (List<VerifyTallySlip>)this.verifyTallySlipService.getAll("FA", region, role_type);
        mv.addObject("verifyTallySliList", (Object)verifyList);   

       } 
       catch(Exception e) {
    	   e.printStackTrace();
       }
        return mv;
    }

    
    @RequestMapping({ "viewCommercialCeilingPrice" })
    public ModelAndView viewCommercialCeilingPrice(final HttpServletRequest request,RedirectAttributes red) {
    	String username =(String)request.getSession().getAttribute("usrname");
        ModelAndView mv = new ModelAndView("viewCommercialCeilingPrice");
        if(username == null) {
        	return mv = new ModelAndView("index");
            }
        String pagename = "viewCommercialCeilingPrice";
        int i = checkprivileges(pagename);
        if(i != 1)
        {
        	 red.addFlashAttribute("errorMessage","Access denied");
			   return mv=new ModelAndView("Home");
        }
        try {
            final List<CommercialJuteVarietyModel> commercialList = (List<CommercialJuteVarietyModel>)this.commercialJuteVarietyGradesPriceService.getAll();
            mv.addObject("commercialList", (Object)commercialList);
            }catch(Exception e) {
            	e.printStackTrace();
            }
        return mv;
    }
    
    @RequestMapping({ "rulingMarketForm" })
    public ModelAndView rulingMarket(final HttpServletRequest request) {
    	String username =(String)request.getSession().getAttribute("usrname");
        ModelAndView mv = new ModelAndView("rulingMarket");
        if(username == null) {
        	return mv = new ModelAndView("index");
            }
        return mv;
    }
    
    @RequestMapping({ "saveRulingMarketMid" })
    public ModelAndView saveRulingMarketMid(final HttpServletRequest request, final RedirectAttributes redirectAttributes) {
    	String username =(String)request.getSession().getAttribute("usrname");
        ModelAndView mv = new ModelAndView("rulingMarket");
        if(username == null) {
        	return new ModelAndView("index");
            }
        try {
            String dpcname = request.getParameter("dpcid");
            String region_id = request.getParameter("region_id");
            String noarrival = request.getParameter("noarrival");
            if (noarrival == null) {
                noarrival = "0";
            }
            int created_by = Integer.parseInt(request.getParameter("created_by"));
            final Date dt = new Date();
            final SimpleDateFormat formatter1 = new SimpleDateFormat("yyyy-MM-dd");
            final String datearrival = request.getParameter("datearrival");
            final Date date1 = formatter1.parse(datearrival);
            final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            final LocalDateTime now = LocalDateTime.now();
            String dateTime = dtf.format(now);
			String basis = request.getParameter("basis"); 
            String jutevariety = request.getParameter("jutevariety");
            String cropyear = request.getParameter("cropyr");
            String arrivedquantity = request.getParameter("arrivedquantity");
            String minmoisture = request.getParameter("minmoisture");
            String maxmoisture = request.getParameter("maxmoisture");
            String grade1 = request.getParameter("grade0");
            String grade2 = request.getParameter("grade1");
            String grade3 = request.getParameter("grade2");
            String grade4 = request.getParameter("grade3");
            String grade5 = request.getParameter("grade4");
            String grade6 = request.getParameter("grade5");
            String grade7 = request.getParameter("grade6");
            String grade8 = request.getParameter("grade7");
            String graderate1 = request.getParameter("rate0");
            String graderate2 = request.getParameter("rate1");
            String graderate3 = request.getParameter("rate2");
            String graderate4 = request.getParameter("rate3");
            String graderate5 = request.getParameter("rate4");
            String graderate6 = request.getParameter("rate5");
            String graderate7 = request.getParameter("rate6");
            String graderate8 = request.getParameter("rate7");
            final MarketArrivalModel rulingMarket = new MarketArrivalModel();
            if (noarrival.equals("1")) {
               // dpcname = "0";
                region_id = "0";
                created_by = 0;
                basis = "0";
                jutevariety = "0";
                cropyear = "0";
                arrivedquantity = "0";
                dateTime = "0000-00-00";
                maxmoisture = "0";
                minmoisture = "0";
                grade1 = "0";
                grade2 = "0";
                grade3 = "0";
                grade4 = "0";
                grade5 = "0";
                grade6 = "0";
                grade7 = "0";
                grade8 = "0";
                graderate1 = "0";
                graderate2 = "0";
                graderate3 = "0";
                graderate4 = "0";
                graderate5 = "0";
                graderate6 = "0";
                graderate7 = "0";
                graderate8 = "0";
            }
            rulingMarket.setDpcnames(dpcname);
            rulingMarket.setRegion_id(region_id);
            rulingMarket.setNo_arrival(noarrival);
            rulingMarket.setCreadtedby(created_by);
            rulingMarket.setDatearrival(datearrival);
            rulingMarket.setBasis(basis);
            rulingMarket.setJutevariety(jutevariety);
            rulingMarket.setCropyr(cropyear);
            rulingMarket.setArrivedqty(arrivedquantity);
            rulingMarket.setCreateddate(dateTime);
            rulingMarket.setMaxmois(maxmoisture);
            rulingMarket.setMixmois(minmoisture);
            if (grade1 != null && grade1 != "0") {
                rulingMarket.setGrade1(Double.parseDouble(grade1));
                //System.out.println(grade1);
            }
            if (grade2 != null && grade2 != "0") {
                rulingMarket.setGrade2(Double.parseDouble(grade2));
            }
            if (grade3 != null && grade3 != "0") {
                rulingMarket.setGrade3(Double.parseDouble(grade3));
            }
            if (grade4 != null && grade4 != "0") {
                rulingMarket.setGrade4(Double.parseDouble(grade4));
            }
            if (grade5 != null && grade5 != "0") {
                rulingMarket.setGrade5(Double.parseDouble(grade5));
            }
            if (grade6 != null && grade6 != "0") {
                rulingMarket.setGrade6(Double.parseDouble(grade6));
            }
            if (grade7 != null && grade7 != "0") {
                rulingMarket.setGrade7(Double.parseDouble(grade7));
            }
            if (grade8 != null && grade8 != "0") {
                rulingMarket.setGrade8(Double.parseDouble(grade8));
            }
            if (graderate1 != null && graderate1 != "0") {
                rulingMarket.setGrade_rate1(Integer.parseInt(graderate1));
            }
            if (graderate2 != null && graderate2 != "0") {
                rulingMarket.setGrade_rate2(Integer.parseInt(graderate2));
            }
            if (graderate3 != null && graderate3 != "0") {
                rulingMarket.setGrade_rate3(Integer.parseInt(graderate3));
            }
            if (graderate4 != null && graderate4 != "0") {
                rulingMarket.setGrade_rate4(Integer.parseInt(graderate4));
            }
            if (graderate5 != null && graderate5 != "0") {
                rulingMarket.setGrade_rate5(Integer.parseInt(graderate5));
            }
            if (graderate6 != null && graderate6 != "0") {
                rulingMarket.setGrade_rate6(Integer.parseInt(graderate6));
            }
            if (graderate7 != null && graderate7 != "0") {
                rulingMarket.setGrade_rate7(Integer.parseInt(graderate7));
            }
            if (graderate8 != null && graderate8 != "0") {
                rulingMarket.setGrade_rate8(Integer.parseInt(graderate8));
            }
            this.marketArrivalService.create(rulingMarket);
            redirectAttributes.addFlashAttribute("msg", (Object)"<div class=\"alert alert-success\"><b>Success!</b> Record updated successfully.</div>\r\n");
            
        }
        catch (Exception e) {
            System.out.println("Error in saving ruling market data    " + e);
        }
       
        return new ModelAndView((View)new RedirectView("rulingMarketForm.obj"));
    }
    
    @RequestMapping({ "bin" })
    public ModelAndView bin(final HttpServletRequest request,RedirectAttributes red) {
    	String username =(String)request.getSession().getAttribute("usrname");
      //  final List<RawJuteProcurementAndPayment> binNumberList = (List<RawJuteProcurementAndPayment>)this.rawJuteProcurAndPayService.getAll();
        ModelAndView mv = new ModelAndView("bin");
       // mv.addObject("binNumberList", (Object)binNumberList);
        if(username == null) {
        	return mv = new ModelAndView("index");
            }
        String pagename = "bin";
        int i = checkprivileges(pagename);
        if(i != 1)
        {
        	 red.addFlashAttribute("errorMessage","Access denied");
			   return mv=new ModelAndView("Home");
        }
        return mv;
    }
    
    @RequestMapping({ "saveBinDetails" })
    public ModelAndView saveBinDetails(final HttpServletRequest request, final RedirectAttributes redirectAttributes) {
    	String username =(String)request.getSession().getAttribute("usrname");
    	 if(username == null) {
         	return new ModelAndView("index");
             }
    	 try {
    	String placeofactivity =(String)request.getSession().getAttribute("dpcId");
     	String regionId =(String)request.getSession().getAttribute("regionId");
     	String zoneId =(String)request.getSession().getAttribute("zoneId");
        final ModelAndView mv = new ModelAndView("bin");
       
            final String nameOfDpc = request.getParameter("dpcname");
            final String cropyear = request.getParameter("cropyr");
            final String binNumber = request.getParameter("binnumb");
            final String jutevariety = request.getParameter("jutevariety");
            final String basis = request.getParameter("basis");
            final String carryForwardLoose = request.getParameter("carryforwardloose");
            final String carryForwardRope = request.getParameter("carryforwardRope");
            final String date = request.getParameter("date");
            if(isStringValid(nameOfDpc) || isStringValid(cropyear) ||isStringValid(binNumber) ||isStringValid(jutevariety) || isStringValid(basis) || isStringValid(carryForwardLoose)
                    || isStringValid(carryForwardRope) || isStringValid(date))
                {
                  redirectAttributes.addFlashAttribute("msg", (Object)"<div class=\"alert alert-danger\"><b>Allowed only Alphabates and Numbers!</b> </div>\r\n");
                  return new ModelAndView((View)new RedirectView("bin.obj"));
                }
            final BatchIdentificationModel batch = new BatchIdentificationModel();
            batch.setDpcnames(nameOfDpc);
            batch.setCropyr(cropyear);
            int bin = Integer.parseInt(binNumber)+1;
            String binno =String.valueOf(bin);
            batch.setBinnumber(binno);
            batch.setJutevariety(jutevariety);
            batch.setBasis(basis);
            batch.setCarryoverlossqty(carryForwardLoose);
            batch.setCarryropeqty(carryForwardRope);
            batch.setDate(date);
            String ropeAndjutePrice =this.batchService.ropeAndJutePrice(jutevariety, basis,binNumber);
         
            double jutePrice= Double.parseDouble(ropeAndjutePrice.split(",")[1]);
            batch.setLoosejuteamount(jutePrice*Double.parseDouble(carryForwardLoose));
            double ropePrice= Double.parseDouble(ropeAndjutePrice.split(",")[0]);
            batch.setRopeamount(ropePrice*Double.parseDouble(carryForwardRope));
            this.batchService.create(batch);
            redirectAttributes.addFlashAttribute("msg", (Object)"<div class=\"alert alert-success\"><b>Success!</b> Record updated successfully.</div>\r\n");
            
        }
        catch (Exception ex) {
        	ex.printStackTrace();
        }
       
        return new ModelAndView((View)new RedirectView("bin.obj"));
    }
    
    @RequestMapping({ "binList" })
    public ModelAndView binList(final HttpServletRequest request,RedirectAttributes red) {
    	String username =(String)request.getSession().getAttribute("usrname");
    	ModelAndView mv = new ModelAndView("binList");
    	if(username == null) {
        	return new ModelAndView("index");
            }
    	String pagename = "binList";
        int i = checkprivileges(pagename);
        if(i != 1)
        {
        	 red.addFlashAttribute("errorMessage","Access denied");
			   return mv=new ModelAndView("Home");
        }
        String dpcId =(String)request.getSession().getAttribute("dpcId");
        String placeofactivity =(String)request.getSession().getAttribute("dpcId");
     	String regionId =(String)request.getSession().getAttribute("regionId");
     	String zoneId =(String)request.getSession().getAttribute("zoneId");
        final List<BatchIdentificationModel> batch = (List<BatchIdentificationModel>)this.batchService.getAll(placeofactivity, regionId, zoneId);
        mv.addObject("batch", (Object)batch);
        

        return mv;
    }
    
    @RequestMapping({ "viewRulingMarket" })
    public ModelAndView viewRulingMarket(final HttpServletRequest request,RedirectAttributes red) {
    	String username =(String)request.getSession().getAttribute("usrname");
        ModelAndView mv = new ModelAndView("viewRulingMarket");

    	   if(username == null) {
           	return new ModelAndView("index");
               }
    	   String pagename = "viewRulingMarket";
           int i = checkprivileges(pagename);
           if(i != 1)
           {
           	 red.addFlashAttribute("errorMessage","Access denied");
   			   return mv=new ModelAndView("Home");
           }
         try {
        final List<RulingMarket> rulingList = (List<RulingMarket>)this.rulingMarketService.getAll();
        mv.addObject("rulingList", (Object)rulingList);
        
		  }

         catch(Exception e) {
        	 e.printStackTrace();
         }
        return mv;
    }
    
    @RequestMapping({ "viewbalePreparation" })
    public ModelAndView viewbalePreparation(final HttpServletRequest request,RedirectAttributes red) {
    	String username =(String)request.getSession().getAttribute("usrname");
    	ModelAndView mv = new ModelAndView("viewbalePreparation");
    	if(username == null) {
        	return new ModelAndView("index");
            }
    	String pagename = "viewbalePreparation";
        int i = checkprivileges(pagename);
        if(i != 1)
        {
        	 red.addFlashAttribute("errorMessage","Access denied");
			   return mv=new ModelAndView("Home");
        }
    	try {
    
    	String placeofactivity =(String)request.getSession().getAttribute("dpcId");
     	String regionId =(String)request.getSession().getAttribute("regionId");
     	String zoneId =(String)request.getSession().getAttribute("zoneId");
		 String place_of_packing =(String)request.getSession().getAttribute("dpcId");
	        List<BalePreparation> viewBale = new ArrayList<BalePreparation>();
			viewBale = (List<BalePreparation>)this.balePrepareService.getAll(place_of_packing,regionId,  zoneId);
			final List<ZoneModel> zoneList = (List<ZoneModel>)this.zoneService.getAll();
	        mv.addObject("zoneList", (Object)zoneList);
	        mv.addObject("viewBalePreparation", (Object)viewBale);
    	}
    	catch(Exception e) {
    		e.printStackTrace();
    	}
        return mv;
    }
    
    @RequestMapping({ "deleteBaleP" })
    public ModelAndView deleteBaleP(final HttpServletRequest request) {
    	String username =(String)request.getSession().getAttribute("usrname");
        ModelAndView mv = new ModelAndView("viewbalePreparation");
        if(username == null) {
        	return mv = new ModelAndView("index");
            }
        try {
        	String placeofactivity =(String)request.getSession().getAttribute("dpcId");
         	String regionId =(String)request.getSession().getAttribute("regionId");
         	String zoneId =(String)request.getSession().getAttribute("zoneId");
            final String id = request.getParameter("id");
            this.balePreparationService.delete(Integer.parseInt(id));
            final List<BalePreparation> DeleteBalePreparation = (List<BalePreparation>)this.balePreparationService.getAll( );
            mv.addObject("viewBalePreparation", (Object)DeleteBalePreparation);
        }
        catch (Exception ex) {}
        
        return mv;
    }
    
    @RequestMapping({ "deleteRopemaking" })
    public ModelAndView deleteRopemaking(final HttpServletRequest request) {
    	String username =(String)request.getSession().getAttribute("usrname");
    	String placeofactivity =(String)request.getSession().getAttribute("placeofactivity");
        ModelAndView mv = new ModelAndView("RopeMakingListing");
        if(username == null) {
        	return new ModelAndView("index");
            }
        try {
        	
         	String regionId =(String)request.getSession().getAttribute("regionId");
         	String zoneId =(String)request.getSession().getAttribute("zoneId");
            final String id = request.getParameter("id");
            this.ropeMakingService.delete(Integer.parseInt(id));
            final List<RopeMakingModel> DeleteRopem = (List<RopeMakingModel>)this.ropeMakingService.getAll(placeofactivity, regionId, zoneId);
            mv.addObject("ropeLists", (Object)DeleteRopem);
           
            return new ModelAndView((View)new RedirectView("ropeMakingListing.obj"));
        }
        catch (Exception ex) {
            return mv;
        }
    }
    
    @RequestMapping({ "deleteDpc" })
    public ModelAndView deleteDpc(final HttpServletRequest request) {
    	String username =(String)request.getSession().getAttribute("usrname");
    	 if(username == null) {
         	return new ModelAndView("index");
             }
    	String placeofactivity =(String)request.getSession().getAttribute("dpcId");
     	String regionId =(String)request.getSession().getAttribute("regionId");
     	String zoneId =(String)request.getSession().getAttribute("zoneId");
        final ModelAndView mv = new ModelAndView();
        try {
            final String id = request.getParameter("id");
            this.DailyPurchasefService.delete(Integer.parseInt(id));
            String dpcid =(String)request.getSession().getAttribute("dpcId");
            final List<DailyPurchaseConfModel> allDailyPurchase = (List<DailyPurchaseConfModel>)this.DailyPurchasefService.getAll(placeofactivity, regionId, zoneId );
            mv.addObject("dailyPurchaseList", (Object)allDailyPurchase);
           
            return new ModelAndView((View)new RedirectView("dailyPurchaseList.obj"));
        }
        catch (Exception ex) {
            return mv;
        }
    }
    
    @RequestMapping({ "deletejuteprocurement" })
    public ModelAndView deletejuteprocurement(final HttpServletRequest request) {
    	String username =(String)request.getSession().getAttribute("usrname");
        final ModelAndView mv = new ModelAndView();
        if(username == null) {
        	return new ModelAndView("index");
            }
        try {
            final String id = request.getParameter("id");
            this.rawJuteProcurAndPayService.delete(Integer.parseInt(id));
            final List<RawJuteProcurementAndPayment> DeletejuteProcu = (List<RawJuteProcurementAndPayment>)this.rawJuteProcurAndPayService.getAll();
            mv.addObject("procurementList", (Object)DeletejuteProcu);
           
            return new ModelAndView((View)new RedirectView("juteProcurementList.obj"));
        }
        catch (Exception ex) {
            return mv;
        }
    }
    
    @RequestMapping({ "deletetallyslip" })
    public ModelAndView deletetallyslip(final HttpServletRequest request) {
    	String username =(String)request.getSession().getAttribute("usrname");
        final ModelAndView mv = new ModelAndView();
        String dpcId =(String)request.getSession().getAttribute("dpcId");
        if(username == null) {
        	return new ModelAndView("index");
            }
        try {
            final String id = request.getParameter("id");
      	   String role_type = (String)request.getSession().getAttribute("roletype");
           String region =(String)request.getSession().getAttribute("region"); 
            this.verifyTallySlipService.delete(Integer.parseInt(id));
            final List<VerifyTallySlip> Deletetallyslip = (List<VerifyTallySlip>)this.verifyTallySlipService.getAll( "", region, role_type);
            mv.addObject("verifyTallySliList", (Object)Deletetallyslip);
            
            return new ModelAndView((View)new RedirectView("viewVerifiedTallySlipList.obj"));
        }
        catch (Exception ex) {
            return mv;
        }
    }
    
    @RequestMapping({ "editjuteprocurement" })
    public ModelAndView editjuteprocurement(final HttpServletRequest request) {
    	String username =(String)request.getSession().getAttribute("usrname");
        ModelAndView mv = new ModelAndView("editJuteProcurement");
        if(username == null) {
        	return mv = new ModelAndView("index");
            }
        try {
            final String id = request.getParameter("id");
            final RawJuteProcurementAndPayment juteProc = this.rawJuteProcurAndPayService.find(Integer.parseInt(id));
            mv.addObject("juteProc", (Object)juteProc);
        }
        catch (Exception ex) {}
       
        return mv;
    }
    
    @RequestMapping({ "updateJuteProcurement" })
    public ModelAndView updateJuteProcurement(final HttpServletRequest request, final RedirectAttributes redirectAttributes) {
    	String username =(String)request.getSession().getAttribute("usrname");
    	if(username == null) {
        	return new ModelAndView("index");
            }
        try {
            String ipAddress = null;
            final String getWay = request.getHeader("VIA");
            ipAddress = request.getHeader("X-FORWARDED-FOR");
            if (ipAddress == null) {
                ipAddress = request.getRemoteAddr();
            }
            final String ptsid = request.getParameter("id");
            final String farmerregno = request.getParameter("farmerregno");
            final String datepurchase = request.getParameter("datepurchase");
            final String basis = request.getParameter("basis");
            final String cropyr = request.getParameter("cropyr");
            final String placeofpurchase = request.getParameter("placeofpurchase");
            final String rateslipno = request.getParameter("rateslipno");
            final String binno = request.getParameter("binno");
            final String jutevariety = request.getParameter("jutevariety");
            final double gquantity = Double.parseDouble(request.getParameter("gquantity"));
            final double dquantity = Double.parseDouble(request.getParameter("deductionQuantity"));
            final double garsatRate = Double.parseDouble(request.getParameter("garsatRate"));
            final double amountPayable = Double.parseDouble(request.getParameter("amountPayable"));
            final RawJuteProcurementAndPayment rawJuteProcAndPay = new RawJuteProcurementAndPayment();
            rawJuteProcAndPay.setBasis(basis);
            rawJuteProcAndPay.setBinno(Integer.parseInt(binno));
            rawJuteProcAndPay.setCreateddate(new Date());
            rawJuteProcAndPay.setCropyr(cropyr);
            final int createdBy = (int)request.getSession().getAttribute("userId");
            rawJuteProcAndPay.setPtsid(Integer.parseInt(ptsid));
            rawJuteProcAndPay.setGrossquantity(gquantity);
            rawJuteProcAndPay.setIpaddress(ipAddress);
            rawJuteProcAndPay.setJutevariety(jutevariety);
            rawJuteProcAndPay.setPlaceofpurchase(placeofpurchase);
            rawJuteProcAndPay.setRateslipno(Integer.parseInt(rateslipno));
            rawJuteProcAndPay.setDeductionquantity(dquantity);
            rawJuteProcAndPay.setGrasatrate(garsatRate);
            rawJuteProcAndPay.setAmountpayable(amountPayable);
            rawJuteProcAndPay.setFarmerregno(farmerregno);
            rawJuteProcAndPay.setCreadtedby(createdBy);
            this.rawJuteProcurAndPayService.create(rawJuteProcAndPay);
            redirectAttributes.addFlashAttribute("msg", (Object)"<div class=\"alert alert-success\"><b>Success!</b> Record updated successfully.</div>\r\n");
        }
        catch (Exception ex) {}
        
        return new ModelAndView((View)new RedirectView("juteProcurementList.obj"));
    }
    
    @RequestMapping(value = { "verifyFarmer2_landscape" }, method = { RequestMethod.GET })
    public ModelAndView verifyFarmer2_landscape(final HttpServletRequest request) {
    	String username =(String)request.getSession().getAttribute("usrname");
        ModelAndView mv = new ModelAndView();
        if(username == null) {
        	return mv = new ModelAndView("index");
            }
        final int id = Integer.parseInt(request.getParameter("id"));
        final FarmerRegModel farmerDetails = this.farmerRegService.find(id);
        mv.addObject("farmerDetails", (Object)farmerDetails);
        mv.setViewName("verifyFarmer2_landscape");
       
        return mv;
    }
    
    @RequestMapping({ "deletedistributiontally" })
    public ModelAndView deletedistributiontally(final HttpServletRequest request) {
    	String username =(String)request.getSession().getAttribute("usrname");
        ModelAndView mv = new ModelAndView("viewDistributionoftallyslips");
        if(username == null) {
        	return mv = new ModelAndView("index");
            }
        String dpcId =(String)request.getSession().getAttribute("dpcId");
        try {
            final String id = request.getParameter("id");
            this.distributionoftallyslipService.delete(Integer.parseInt(id));
            final List<DistributionoftallyslipModel> Deletedistributiontally = (List<DistributionoftallyslipModel>)this.distributionoftallyslipService.getAll(dpcId);
            mv.addObject("DistributionoftallyslipsList", (Object)Deletedistributiontally);
        }
        catch (Exception ex) {}
        
        return mv;
    }
    
    @RequestMapping({ "deletecommercialprice" })
    public ModelAndView deletecommercialprice(final HttpServletRequest request) {
    	String username =(String)request.getSession().getAttribute("usrname");
        ModelAndView mv = new ModelAndView("viewCommercialCeilingPrice");
        if(username == null) {
        	return mv = new ModelAndView("index");
            }
        try {
            final String id = request.getParameter("id");
            this.commercialJuteVarietyGradesPriceService.delete(Integer.parseInt(id));
            final List<CommercialJuteVarietyModel> deleteCommercialList = (List<CommercialJuteVarietyModel>)this.commercialJuteVarietyGradesPriceService.getAll();
            mv.addObject("commercialList", (Object)deleteCommercialList);
        }
        catch (Exception ex) {
        	ex.printStackTrace();
        }
        
        return mv;
    }
    
    @RequestMapping({ "deleteRulingMarket" })
    public ModelAndView deleteRulingMarket(final HttpServletRequest request, final RedirectAttributes redirectAttributes) {
    	String username =(String)request.getSession().getAttribute("usrname");
        ModelAndView mv = new ModelAndView("viewRulingMarket");
        if(username == null) {
        	return new ModelAndView("index");
            }
        try {
            final String id = request.getParameter("id");
            this.rulingMarketService.delete(Integer.parseInt(id));
            final List<RulingMarket> rulingList = (List<RulingMarket>)this.rulingMarketService.getAll();
            mv.addObject("rulingList", (Object)rulingList);
            redirectAttributes.addFlashAttribute("msg", (Object)"<div class=\"alert alert-success\"><b>Success !</b> List deleted successfully.</div>\r\n");
            
            return new ModelAndView((View)new RedirectView("viewRulingMarket.obj"));
        }
        catch (Exception ex) {
            return mv;
        }
    }
    
    @RequestMapping({ "editBaleP" })
    public ModelAndView editBaleP(final HttpServletRequest request, final RedirectAttributes redirectAttributes) {
    	String username =(String)request.getSession().getAttribute("usrname");
       ModelAndView mv = new ModelAndView("editBalePreparation");
       if(username == null) {
       	return mv = new ModelAndView("index");
           }
       String pagename = "editBaleP";
       int i = checkprivileges(pagename);
       if(i != 1)
       {
    	   redirectAttributes.addFlashAttribute("errorMessage","Access denied");
			   return mv=new ModelAndView("Home");
       }
        try {
            final String id = request.getParameter("id");
            final BalePreparation baleMod = this.balepreparationservice.find(Integer.parseInt(id));
            mv.addObject("baleMod", (Object)baleMod);
           
            return mv;
        }
        catch (Exception ex) {
            return mv;
        }
    }
    
    @RequestMapping({ "updateBalePreparation" })
    public ModelAndView updateBalePreparation(final HttpServletRequest request, final RedirectAttributes redirectAttributes) {
    	String username =(String)request.getSession().getAttribute("usrname");
        final ModelAndView mv = new ModelAndView("editBalePreparation");
        if(username == null) {
        	return new ModelAndView("index");
            }
        try {
            final String baleid = request.getParameter("baleId");
            final String place_of_packing = request.getParameter("place_of_packing");
            final String crop_year = request.getParameter("crop_year");
            final String bin_no = request.getParameter("bin_no");
            final String basis = request.getParameter("basis");
            final String jute_variety = request.getParameter("jute_variety");
            final String slip_no_from = request.getParameter("slip_no_from");
            final String slip_no_to = request.getParameter("slip_no_to");
            final String bale_no = request.getParameter("bale_no");
            final String jute_grade = request.getParameter("jute_grade");
            if(isStringValid(baleid) || isStringValid(place_of_packing) ||isStringValid(crop_year) ||isStringValid(bin_no) || isStringValid(basis) || isStringValid(jute_variety)
                    || isStringValid(slip_no_from) || isStringValid(slip_no_to) ||isStringValid(bale_no) ||isStringValid(jute_grade)
                	)
                {
                  redirectAttributes.addFlashAttribute("msg", (Object)"<div class=\"alert alert-danger\"><b>Allowed only Alphabates and Numbers!</b> </div>\r\n");
                  return new ModelAndView((View)new RedirectView("viewbalePreparation.obj"));
                }
          //  System.out.println(">>>>>data>>>>>>>>>>>baleid:" + baleid + "place_of_packing:" + place_of_packing + "crop_year:" + crop_year + "bin_no:" + bin_no + "basis:" + basis + "jute_variety: " + jute_variety + "slip_no_from:" + slip_no_from + "slip_no_from:" + slip_no_from + "slip_no_to:" + slip_no_to + "bale_no:" + bale_no + "jute_grade:" + jute_grade);
            final BalePreparation balePreparation = new BalePreparation();
            balePreparation.setBaleId(Integer.parseInt(baleid));
            final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
            final LocalDateTime now = LocalDateTime.now();
            final String date = dtf.format(now);
            balePreparation.setCreation_date(date);
            final long millis = System.currentTimeMillis();
            final java.sql.Date sqlDate = new java.sql.Date(millis);
          //  System.out.println(">>>>>>>>>>date>>>>>>>>>>>>>>>" + sqlDate);
            balePreparation.setPacking_date(sqlDate.toString());
            balePreparation.setPlace_of_packing(place_of_packing);
            balePreparation.setCrop_year(crop_year);
            balePreparation.setBin_no(bin_no);
            balePreparation.setBasis(basis);
            balePreparation.setJute_variety(jute_variety);
            balePreparation.setJute_grade(jute_grade);
            balePreparation.setSlip_no_from(slip_no_from);
            balePreparation.setSlip_no_to(slip_no_to);
            final int bale_no2 = Integer.parseInt(bale_no);
            balePreparation.setBale_no(bale_no2);
            balePreparation.setJute_grade(jute_grade);
            final int createdBy = (int)request.getSession().getAttribute("userId");
            balePreparation.setCreated_by(createdBy);
            final int toCheckSlipNoInt = Integer.parseInt(slip_no_to);
            final int fromCheckSlipNoInt = Integer.parseInt(slip_no_from);
            if (toCheckSlipNoInt > fromCheckSlipNoInt) {
                this.balePrepareService.update(balePreparation);
                redirectAttributes.addFlashAttribute("msg", (Object)"<div class=\"alert alert-success\"><b>Success !</b> Record updated successfully.</div>\r\n");
                return new ModelAndView((View)new RedirectView("viewbalePreparation.obj"));
            }
            redirectAttributes.addFlashAttribute("msg", (Object)"<div class=\"alert alert-danger\"><b>OOps!</b> Error in record saving. </div>\r\n");
            
            return new ModelAndView((View)new RedirectView("balePreparation.obj"));
        }
        catch (Exception e) {
            e.printStackTrace();
            return mv;
        }
    }
    
    @RequestMapping(value = { "editRopemaking" }, method = { RequestMethod.GET })
    public ModelAndView editRopemaking(final HttpServletRequest request, RedirectAttributes red) {
    	String username =(String)request.getSession().getAttribute("usrname");
    	 if(username == null) {
         	return new ModelAndView("index");
             }
        ModelAndView mv = new ModelAndView("editRopemaking");
        String pagename = "editRopemaking";
        int i = checkprivileges(pagename);
        if(i != 1)
        {
        	 red.addFlashAttribute("errorMessage","Access denied");
			   return mv=new ModelAndView("Home");
        }
        if (request.getParameter("id") != null) {
        	
       	    String key = LoginController.secretkey;
	    	String decryptedString = request.getParameter("id");
	    	final int id = Integer.parseInt(Encry.decrypt(decryptedString, key));
            final RopeMakingModel editRopmaking = this.ropeMakingService.find(id);
            mv.addObject("editRopemaking", (Object)editRopmaking);
        }
       
        return mv;
    }
    
    @RequestMapping({ "updateRopeMakingMid" })
    public ModelAndView updateRopeMakingMid(final HttpServletRequest request, final RedirectAttributes redirectAttributes) {
    	String username =(String)request.getSession().getAttribute("usrname");
    	if(username == null) {
        	return new ModelAndView("index");
            }
     	String zoneId =(String)request.getSession().getAttribute("zoneId");
        ModelAndView mv = new ModelAndView("editRopemaking");
        try {
            final String id = request.getParameter("id");
            final int creadtedby = 0;
            final String basis = request.getParameter("basis");
            final String cropyr = request.getParameter("cropyr");
            final String placeofactivity = (String)request.getSession().getAttribute("dpcId");
            final String jutevariety = request.getParameter("jutevariety");
            final String ropemade = request.getParameter("ropemade");
            final String ropeUsed = request.getParameter("ropeUsed");
            final String balance = request.getParameter("balance");
            final String regionId = request.getParameter("region_id");
            final String refid = request.getParameter("refid");
            final String binno = request.getParameter("binno");
            if(isStringValid(id) || isStringValid(basis) || isStringValid(placeofactivity) || isStringValid(jutevariety) || isStringValid(ropemade)
                    || isStringValid(ropeUsed) || isStringValid(balance) ||isStringValid(regionId) ||isStringValid(refid) || isStringValid(binno)
                	)
                {
                  redirectAttributes.addFlashAttribute("msg", (Object)"<div class=\"alert alert-danger\"><b>Allowed only Alphabates and Numbers!</b> </div>\r\n");
                  return new ModelAndView((View)new RedirectView("ropeMakingListing.obj"));
                }
            final RopeMakingModel addRopeMaking = new RopeMakingModel();
            final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            final LocalDateTime now = LocalDateTime.now();
            final String date = dtf.format(now);
            addRopeMaking.setRpmrefid(Integer.parseInt(id));
            addRopeMaking.setBasis(basis);
            addRopeMaking.setBinno(binno);
            addRopeMaking.setCreadtedby(refid);
            addRopeMaking.setRegion(regionId);
            addRopeMaking.setCropyr(cropyr);
            addRopeMaking.setDatereport((new Date()).toString());
            addRopeMaking.setCreadtedby(regionId);
            addRopeMaking.setJutevariety(jutevariety);
            addRopeMaking.setPlaceofactivity(placeofactivity);
            addRopeMaking.setRopemade(ropemade);
            addRopeMaking.setRopeused(ropeUsed);
            addRopeMaking.setRope_balance(balance);
            addRopeMaking.setCreateddate(date);
            this.ropeMakingService.create(addRopeMaking);
            redirectAttributes.addFlashAttribute("msg", (Object)"<div class=\"alert alert-success\"><b>Success !</b> Record updated successfully.</div>\r\n");
            
            return new ModelAndView((View)new RedirectView("ropeMakingListing.obj"));
        }
        catch (Exception ex) {
            return mv;
        }
    }
    
    @RequestMapping({ "editDpc" })
    public ModelAndView editDpc(final HttpServletRequest request, final RedirectAttributes redirectAttributes) {
    	String username =(String)request.getSession().getAttribute("usrname");
        ModelAndView mv = new ModelAndView("editDailypurchase");
        if(username == null) {
        	return mv = new ModelAndView("index");
            }
        try {
            final String id = request.getParameter("id");
            final DailyPurchaseConfModel dailyPurchase = this.DailyPurchasefService.find(Integer.parseInt(id));
            mv.addObject("dailyPurchase", (Object)dailyPurchase);
           
            return mv;
        }
        catch (Exception ex) {
            return mv;
        }
    }
    
    @RequestMapping({ "updateDailyPurchase" })
    public ModelAndView updateDailyPurchase(final HttpServletRequest request, final RedirectAttributes redirectAttributes) {
    	String username =(String)request.getSession().getAttribute("usrname");
        final ModelAndView mv = new ModelAndView("dailyPurchaseLIst");
        if(username == null) {
        	return new ModelAndView("index");
            }
        try {
            final String id = request.getParameter("id");
            String ipAddress = null;
            final String getWay = request.getHeader("VIA");
            ipAddress = request.getHeader("X-FORWARDED-FOR");
            if (ipAddress == null) {
                ipAddress = request.getRemoteAddr();
            }
            final String formno = request.getParameter("formno");
            final String datepurchase = request.getParameter("datepurchase");
            final String basis = request.getParameter("basis");
            final String cropyr = request.getParameter("cropyr");
            final String placeofpurchase = request.getParameter("placeofpurchase");
            final String binno = request.getParameter("binno");
            final String jutevariety = request.getParameter("jutevariety");
            final String gquantity = request.getParameter("gquantity");
            final String dquantity = request.getParameter("dquantity");
            final String netquantity = request.getParameter("netquantity");
            final String fibervalue = request.getParameter("fibervalue");
            final int createdBy = (int)request.getSession().getAttribute("userId");
            final String rateslipno = request.getParameter("rateslipno");
            final DailyPurchaseConfModel DailyPurchase = new DailyPurchaseConfModel();
            DailyPurchase.setDpcid(Integer.parseInt(id));
            DailyPurchase.setBasis(basis);
            DailyPurchase.setBinno(Integer.parseInt(binno));
            DailyPurchase.setCropyr(cropyr);
            DailyPurchase.setDquantity(dquantity);
            DailyPurchase.setFibervalue(Integer.parseInt(fibervalue));
            DailyPurchase.setFormno(formno);
            DailyPurchase.setGquantity(gquantity);
            DailyPurchase.setIpaddress(ipAddress);
            DailyPurchase.setJutevariety(jutevariety);
            DailyPurchase.setNetquantity(Double.parseDouble(netquantity));
            DailyPurchase.setPlaceofpurchase(placeofpurchase);
            DailyPurchase.setCreatedby(createdBy);
            DailyPurchase.setRateslipno(rateslipno);
           // System.out.println(DailyPurchase.toString());
            this.DailyPurchasefService.create(DailyPurchase);
            redirectAttributes.addFlashAttribute("msg", (Object)"<div class=\"alert alert-success\"><b>Success !</b> Record saved successfully.</div>\r\n");
        }
        catch (Exception ex) {
        	ex.printStackTrace();
        }
       
        return new ModelAndView((View)new RedirectView("dailyPurchaseList.obj"));
    }
    
    @ResponseBody
    @RequestMapping({ "validateFarmer" })
    public String farmerNoVarification(final HttpServletRequest request) {
    	
        final ModelAndView mv = new ModelAndView("RawJutePaymentAndProcurement");
        final Gson gson = new Gson();
        final String farmerNo = request.getParameter("farmerNo");
        return gson.toJson((Object)this.rawJuteProcurAndPayService.farmerNoVarification(farmerNo));
    }
    
    @ResponseBody
    @RequestMapping(value = { "findJuteOnBasis" }, method = { RequestMethod.GET })
    public String findJuteOnBasis(final HttpServletRequest request) {
        final Gson gson = new Gson();
        List<String> result = new ArrayList<String>();
        try {
        result = (List<String>)this.rawJuteProcurAndPayService.findJuteOnBasis(Integer.parseInt(request.getParameter("msp_no")));
        
        }
        catch(Exception e) {
        	e.printStackTrace();
        }
        return gson.toJson((Object)result);
    }
    
    @ResponseBody
    @RequestMapping(value = { "findGradeOnJuteVariety" }, method = { RequestMethod.GET })
    public String findGradeOnJuteVariety(final HttpServletRequest request) {
        final Gson gson = new Gson();
        final List<String> result = (List<String>)this.rawJuteProcurAndPayService.findGradeOnJuteVariety(request.getParameter("variety"), Integer.parseInt(request.getParameter("basis_no")));
        return gson.toJson((Object)result);
    }
    
    @ResponseBody
    @RequestMapping(value = { "findGradeOfMSP" }, method = { RequestMethod.GET })
    public String findGradeOfMSP(final HttpServletRequest request) {
        final Gson gson = new Gson();
       
        final List<String> result = (List<String>)this.mSPPriceCalculationService.findGradeOfMSP(request.getParameter("variety"), Integer.parseInt(request.getParameter("basis_no")));
        return gson.toJson((Object)result);
    }
    
    @RequestMapping({ "mspPriceCalculation" })
    public ModelAndView mspPriceCalculation(final HttpServletRequest request,RedirectAttributes red) {
    	String username =(String)request.getSession().getAttribute("usrname");
    	if(username == null) {
        	return new ModelAndView("index");
            }
         ModelAndView mv = new ModelAndView("mspPriceCalculation");
         String pagename = "mspPriceCalculation";
         int i = checkprivileges(pagename);
         if(i != 1)
         {
         	 red.addFlashAttribute("errorMessage","Access denied");
 			   return mv=new ModelAndView("Home");
         }
 		return mv;
     }
    
    @RequestMapping({ "deleteFarmer" })
    public ModelAndView deleteFarmer(final HttpServletRequest request, final RedirectAttributes redirectAttributes) {
    	String username =(String)request.getSession().getAttribute("usrname");
        final ModelAndView mv = new ModelAndView("ViewFarmerRegistration");
        if(username == null) {
        	return new ModelAndView("index");
            }
        try {
            final String id = request.getParameter("id");
            this.farmerRegService.delete(Integer.parseInt(id));
            final List<FarmerRegModel> allFarmersList = (List<FarmerRegModel>)this.farmerRegService.getAll();
            mv.addObject("allFarmersList", (Object)allFarmersList);
            redirectAttributes.addFlashAttribute("msg", (Object)"<div class=\"alert alert-success\"><b>Success !</b> Data deleted successfully.</div>\r\n");
            
            return new ModelAndView((View)new RedirectView("ViewFarmerRegistration.obj"));
        }
        catch (Exception ex) {
            return mv;
        }
    }
    
    @RequestMapping({ "editdistributiontally" })
    public ModelAndView editdistributiontally(final HttpServletRequest request, final RedirectAttributes redirectAttributes) {
    	String username =(String)request.getSession().getAttribute("usrname");
        final ModelAndView mv = new ModelAndView("editDistributiontallyslip");
        if(username == null) {
        	return new ModelAndView("index");
            }
        try {
            final String id = request.getParameter("id");
            final DistributionoftallyslipModel distributiontallyslip = this.distributionoftallyslipService.find(Integer.parseInt(id));
            mv.addObject("distributiontally", (Object)distributiontallyslip);
           
            return mv;
        }
        catch (Exception ex) {
            return mv;
        }
    }
    
    @RequestMapping({ "updateDistributionoftallyslip" })
    public ModelAndView updateDistributionoftallyslip(final HttpServletRequest request, final RedirectAttributes redirectAttributes) {
    	String username =(String)request.getSession().getAttribute("usrname");
        final ModelAndView mv = new ModelAndView("editdistributiontally");
        if(username == null) {
        	return new ModelAndView("index");
            }
        try {
            final String id = request.getParameter("id");
            final SimpleDateFormat formatter1 = new SimpleDateFormat("yyyy-MM-dd");
            final String dpccode = request.getParameter("dpccode");
            final String dateofreceipt = request.getParameter("dateofreceipt");
            final Date date1 = formatter1.parse(dateofreceipt);
            final String slipreceived = request.getParameter("slipreceived");
            final String seriesstartfrom = request.getParameter("seriesstartfrom");
            final String seriestoend = request.getParameter("seriestoend");
            final DistributionoftallyslipModel updateDistributionoftallyslipModel = new DistributionoftallyslipModel();
            updateDistributionoftallyslipModel.setRefid(Integer.parseInt(id));
            updateDistributionoftallyslipModel.setDpccode(dpccode);
            updateDistributionoftallyslipModel.setDateofreceipt(dateofreceipt);
            updateDistributionoftallyslipModel.setSlipreceived(slipreceived);
            updateDistributionoftallyslipModel.setSeriesstartfrom(seriesstartfrom);
            updateDistributionoftallyslipModel.setSeriestoend(seriestoend);
            updateDistributionoftallyslipModel.setCreateddate(new Date());
            this.distributionoftallyslipService.create(updateDistributionoftallyslipModel);
            redirectAttributes.addFlashAttribute("msg", (Object)"<div class=\"alert alert-success\"><b>Success !</b> Record updated successfully.</div>\r\n");
           
            return new ModelAndView((View)new RedirectView("viewDistributionoftallyslips.obj"));
        }
        catch (Exception ex) {
            return mv;
        }
    }
    
    @RequestMapping({ "editcommercialprice" })
    public ModelAndView editcommercialprice(final HttpServletRequest request, final RedirectAttributes redirectAttributes) {
    	String username =(String)request.getSession().getAttribute("usrname");
        ModelAndView mv = new ModelAndView("editcommercialprice");
        if(username == null) {
        	return mv = new ModelAndView("index");
            }
        try {
            final String id = request.getParameter("id");
            final CommercialCeilingPriceIntimationModel commercialCeilingPrice = this.commercialCeilingPriceIntimationService.find(Integer.parseInt(id));
            mv.addObject("commercialCeilingprice", (Object)commercialCeilingPrice);        
            return mv;
        }
        catch (Exception ex) {
            return mv;
        }
    }
    
    @RequestMapping({ "updateCommercialCeilingPriceIntimation" })
    public ModelAndView updateCommercialCeilingPriceIntimation(final HttpServletRequest request, final RedirectAttributes redirectAttributes) {
    	String username =(String)request.getSession().getAttribute("usrname");
    	final ModelAndView mv = new ModelAndView("editcommercialprice");
    	if(username == null) {
        	return new ModelAndView("index");
            }
        try {
            final String id = request.getParameter("id");
            final SimpleDateFormat formatter1 = new SimpleDateFormat("yyyy-MM-dd");
            final String dpccode = request.getParameter("dpccode");
            final String dateofentry = request.getParameter("dateofentry");
            final Date date1 = formatter1.parse(dateofentry);
            final String dateofeffect = request.getParameter("dateofeffect");
            final Date date2 = formatter1.parse(dateofeffect);
            final String jutevariety = request.getParameter("jutevariety");
            final String ceilingquantity = request.getParameter("ceilingquantity");
            final String jutegrade = request.getParameter("jutegrade");
            final String ceilingprice = request.getParameter("ceilingprice");
            final CommercialCeilingPriceIntimationModel updateCommercialCeilingPriceIntimationModel = new CommercialCeilingPriceIntimationModel();
            updateCommercialCeilingPriceIntimationModel.setRpmrefid(Integer.parseInt(id));
            updateCommercialCeilingPriceIntimationModel.setDpccode(dpccode);
            updateCommercialCeilingPriceIntimationModel.setDateofentry(date1);
            updateCommercialCeilingPriceIntimationModel.setDateofeffect(date2);
            updateCommercialCeilingPriceIntimationModel.setJutevariety(jutevariety);
            updateCommercialCeilingPriceIntimationModel.setCeilingquantity(ceilingquantity);
            updateCommercialCeilingPriceIntimationModel.setJutegrade(jutegrade);
            updateCommercialCeilingPriceIntimationModel.setCeilingprice(ceilingprice);
            updateCommercialCeilingPriceIntimationModel.setCreateddate(new Date());
            this.commercialCeilingPriceIntimationService.create(updateCommercialCeilingPriceIntimationModel);
            redirectAttributes.addFlashAttribute("msg", (Object)"<div class=\"alert alert-success\"><b>Success !</b> Record updated successfully.</div>\r\n");
            
            return new ModelAndView((View)new RedirectView("viewCommercialCeilingPrice.obj"));
        }
        catch (Exception e) {
            e.printStackTrace();
            return mv;
        }
    }
    
    @RequestMapping({ "saveGradePriceOfMSP" })
    public ModelAndView saveGradePriceOfMSP(final HttpServletRequest request, final RedirectAttributes redirectAttributes) {
    	String username =(String)request.getSession().getAttribute("usrname");
    	ModelAndView mv = new ModelAndView("mspPriceCalculation");
    	 if(username == null) {
         	return mv = new ModelAndView("index");
             }
        try {
            final String jutevariety = request.getParameter("jutevariety");
            final String cropyr = request.getParameter("cropyr");
            final String dubjuteVarietys = request.getParameter("dubjuteVariety");
            final boolean dubjuteVarietyB = Boolean.parseBoolean(dubjuteVarietys);
            final String dubcropyr = request.getParameter("dubcropyr");
            final boolean dubcropyrBool = Boolean.parseBoolean(dubcropyr);
            final String grade0 = request.getParameter("g0");
            final String grade2 = request.getParameter("g1");
            final String grade3 = request.getParameter("g2");
            final String grade4 = request.getParameter("g3");
            final String grade5 = request.getParameter("g4");
            final String grade6 = request.getParameter("g5");
            final String grade7 = request.getParameter("g6");
            final String grade8 = request.getParameter("g7");
            if(isStringValid(jutevariety) || isStringValid(cropyr) ||isStringValid(dubjuteVarietys) ||isStringValid(dubcropyr) || isStringValid(grade0) || isStringValid(grade2)
                    || isStringValid(grade3) || isStringValid(grade4) ||isStringValid(grade5) ||isStringValid(grade6) || isStringValid(grade7) || isStringValid(grade8))
                {
                  redirectAttributes.addFlashAttribute("msg", (Object)"<div class=\"alert alert-danger\"><b>Allowed only Alphabates and Numbers!</b> </div>\r\n");
                  return new ModelAndView((View)new RedirectView("mspPriceCalculation.obj"));
                }
            final MSPPriceCalculationModel mspPriceCalculationModel = new MSPPriceCalculationModel();
            mspPriceCalculationModel.setJute_variety(jutevariety);
            mspPriceCalculationModel.setCrop_yr(cropyr);
            if (grade0 != null && grade0 != "0.0") {
                mspPriceCalculationModel.setGrade1(Double.parseDouble(grade0));
            }
            if (grade2 != null && grade2 != "0.0") {
                mspPriceCalculationModel.setGrade2(Double.parseDouble(grade2));
            }
            if (grade3 != null && grade3 != "0.0") {
                mspPriceCalculationModel.setGrade3(Double.parseDouble(grade3));
            }
            if (grade4 != null && grade4 != "0.0") {
                mspPriceCalculationModel.setGrade4(Double.parseDouble(grade4));
            }
            if (grade5 != null && grade5 != "0.0") {
                mspPriceCalculationModel.setGrade5(Double.parseDouble(grade5));
            }
            if (grade6 != null && grade6 != "0.0") {
                mspPriceCalculationModel.setGrade6(Double.parseDouble(grade6));
            }
            if (grade7 != null && grade7 != "0.0") {
                mspPriceCalculationModel.setGrade7(Double.parseDouble(grade7));
            }
            if (grade8 != null && grade8 != "0.0") {
                mspPriceCalculationModel.setGrade8(Double.parseDouble(grade8));
            }
            mspPriceCalculationModel.setCreated_date(new Date());
            final int msp = this.mSPPriceCalculationService.create(mspPriceCalculationModel);
            if (msp > 0) {
                redirectAttributes.addFlashAttribute("msg", (Object)"<div class=\"alert alert-success\"><b>Success !</b> Record updated successfully.</div>\r\n");
            }
            else {
                redirectAttributes.addFlashAttribute("msg", (Object)"<div class=\"alert alert-danger\"><b>Not saved !</b> Record Not Saved.</div>\r\n");
            }
            if (dubjuteVarietyB) {
                this.mSPPriceCalculationService.create(mspPriceCalculationModel);
                redirectAttributes.addFlashAttribute("msg", (Object)"<div class=\"alert alert-success\"><b>Success !</b> Record saved successfully.</div>\r\n");
            }
            else {
                redirectAttributes.addFlashAttribute("msg", (Object)"<div class=\"alert alert-danger\"><b>OOps!</b> Duplicate jute variety</div>\r\n");
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
       
        return mv;
    }
    
    @ResponseBody
    @RequestMapping(value = { "validatejutevariety" }, method = { RequestMethod.GET })
    public String validatejutevariety(final HttpServletRequest request) {
        final Gson gson = new Gson();
        final String jutevariety = request.getParameter("jutevariety");
        final String cropyr = request.getParameter("cropyr");
        return this.mSPPriceCalculationService.validatejutevariety(jutevariety, cropyr) + "";
    }
    
    @RequestMapping({ "editRulingMarket" })
    public ModelAndView editRulingMarket(final HttpServletRequest request, final RedirectAttributes redirectAttributes) {
    	String username =(String)request.getSession().getAttribute("usrname");
    	 if(username == null) {
         	return new ModelAndView("index");
             }
    	ModelAndView mv = new ModelAndView("editRulingMarket");
        try {
            final String id = request.getParameter("id");
            final RulingMarket rulingMarket = this.rulingMarketService.find(Integer.parseInt(id));
            mv.addObject("rulingMarket", (Object)rulingMarket);
           
            return mv;
        }
        catch (Exception e) {
            System.out.println("Error in edit RulingMarket");
            return mv;
        }
    }
    
    @RequestMapping({ "commercialPriceCalculation" })
    public ModelAndView commercialPriceCalculation(final HttpServletRequest request,RedirectAttributes red) {
    	String username =(String)request.getSession().getAttribute("usrname");
        ModelAndView mv = new ModelAndView("CommercialJuteVarietyGradesPrice");

    	if(username == null) {
        	return new ModelAndView("index");
            }
    	String pagename = "commercialPriceCalculation";
        int i = checkprivileges(pagename);
        if(i != 1)
        {
        	 red.addFlashAttribute("errorMessage","Access denied");
			   return mv=new ModelAndView("Home");
        }
    	final List<ZoneModel> zoneList = (List<ZoneModel>)this.zoneService.getAll();
        final List<RoleMasterModel> roleList = (List<RoleMasterModel>)this.roleService.getAll();
        mv.addObject("zoneList", (Object)zoneList);
        mv.addObject("roleList", (Object)roleList);
        
        return mv;
    }
    
    
    @RequestMapping(value = { "saveGradePriceOfCommercial" }, method = { RequestMethod.POST })
    public ModelAndView saveGradePriceOfCommercial(final HttpServletRequest request, final RedirectAttributes redirectAttributes) {
    	String username =(String)request.getSession().getAttribute("usrname");
    	ModelAndView mv = new ModelAndView("CommercialJuteVarietyGradesPrice");
    	 if(username == null) {
         	return new ModelAndView("index");
             }
        try {
            final String zone = request.getParameter("zone");
            final String region = request.getParameter("region");
            final String dpc = request.getParameter("dpc");
            final List<String> list = (List<String>)this.purchaseCenterService.dpcbyId(dpc);
            final String jutevariety = request.getParameter("jutevariety");
            final String radioselect = request.getParameter("radioselect");
            final String entryDate = request.getParameter("entryDate");
            final String effectDate = request.getParameter("effectDate");
            final String cqty = request.getParameter("cqty");
            final String cropyr = request.getParameter("cropyr");
            final String cprice = request.getParameter("cprice");
            final String grade0 = request.getParameter("grade0");
            final String grade2 = request.getParameter("grade1");
            final String grade3 = request.getParameter("grade2");
            final String grade4 = request.getParameter("grade3");
            final String grade5 = request.getParameter("grade4");
            final String grade6 = request.getParameter("grade5");
            final String grade7 = request.getParameter("grade6");
            final String grade8 = request.getParameter("grade7");
            if(isStringValid(zone) || isStringValid(region) ||isStringValid(dpc) ||isStringValid(jutevariety) || isStringValid(radioselect) || isStringValid(entryDate)
                    || isStringValid(effectDate) || isStringValid(cqty) ||isStringValid(cropyr) ||isStringValid(cprice) || isStringValid(grade0) || isStringValid(grade2) || isStringValid(grade3) ||isStringValid(grade4) || isStringValid(grade5) || isStringValid(grade6) || isStringValid(grade7)
                	)
                {
                  redirectAttributes.addFlashAttribute("msg", (Object)"<div class=\"alert alert-danger\"><b>Allowed only Alphabates and Numbers!</b> </div>\r\n");
                  return new ModelAndView((View)new RedirectView("commercialPriceCalculation.obj"));
                }
            final CommercialJuteVarietyModel commercialJuteVarietyModel = new CommercialJuteVarietyModel();
            commercialJuteVarietyModel.setJute_variety(jutevariety);
            commercialJuteVarietyModel.setCrop_yr(cropyr);
            commercialJuteVarietyModel.setCprice(cprice);
            commercialJuteVarietyModel.setDpc(dpc);
            commercialJuteVarietyModel.setRegion(region);
            commercialJuteVarietyModel.setCqty(cqty);
            commercialJuteVarietyModel.setZone(zone);
            commercialJuteVarietyModel.setEffectDate(effectDate);
            commercialJuteVarietyModel.setCreated_on(entryDate);
            commercialJuteVarietyModel.setJute_variety(jutevariety);
            commercialJuteVarietyModel.setFormtype(radioselect);
            commercialJuteVarietyModel.setDpcname(String.join(",", list));
            if (grade0 != null) {
                commercialJuteVarietyModel.setGrade1(Double.parseDouble(grade0));
            }
            if (grade2 != null) {
                commercialJuteVarietyModel.setGrade2(Double.parseDouble(grade2));
            }
            if (grade3 != null) {
                commercialJuteVarietyModel.setGrade3(Double.parseDouble(grade3));
            }
            if (grade4 != null) {
                commercialJuteVarietyModel.setGrade4(Double.parseDouble(grade4));
            }
            if (grade5 != null) {
                commercialJuteVarietyModel.setGrade5(Double.parseDouble(grade5));
            }
            if (grade6 != null) {
                commercialJuteVarietyModel.setGrade6(Double.parseDouble(grade6));
            }
            if (grade7 != null) {
                commercialJuteVarietyModel.setGrade7(Double.parseDouble(grade7));
            }
            if (grade8 != null) {
                commercialJuteVarietyModel.setGrade8(Double.parseDouble(grade8));
            }
            this.commercialJuteVarietyGradesPriceService.create(commercialJuteVarietyModel);
        }
        catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
        }
        redirectAttributes.addFlashAttribute("msg", (Object)"<div class=\"alert alert-success\"><b>Success !</b> Record saved successfully.</div>\r\n");
       
        return new ModelAndView((View)new RedirectView("commercialPriceCalculation.obj"));
    }
    
    @ResponseBody
    @RequestMapping(value = { "findGradePriceJuteVariety" }, method = { RequestMethod.GET })
    public String findGradePriceJuteVariety(final HttpServletRequest request, final HttpSession session) {
        final int userid = (int)request.getSession().getAttribute("userId");
        final String dpcid = (String)request.getSession().getAttribute("dpcId");
        final Gson gson = new Gson();
        final List<String> result = (List<String>)this.rawJuteProcurAndPayService.findGradePriceJuteVariety(request.getParameter("variety"), Integer.parseInt(request.getParameter("basis_no")), request.getParameter("cropyr"), dpcid);
        //System.out.println("gson.toJson(result) ================== >>>>>>>>>>>>>>>> " + gson.toJson((Object)result));
        return gson.toJson((Object)result);
    }
    
    @RequestMapping({ "mspGradesPriceList" })
    public ModelAndView mspGradesPriceList(final HttpServletRequest request,RedirectAttributes red) {
    	String username =(String)request.getSession().getAttribute("usrname");
    	ModelAndView mv = new ModelAndView("mspGradesPriceList");

    	if(username == null) {
        	return new ModelAndView("index");
            }
    	String pagename = "mspGradesPriceList";
        int i = checkprivileges(pagename);
        if(i != 1)
        {
        	 red.addFlashAttribute("errorMessage","Access denied");
			   return mv=new ModelAndView("Home");
        }
        final List<MSPPriceCalculationModel> msppriceList = (List<MSPPriceCalculationModel>)this.mSPPriceCalculationService.getAll();
        mv.addObject("msppriceList", (Object)msppriceList);
        
        return mv;
    }
    
    @RequestMapping({ "updateRulingMarket" })
    public ModelAndView updateRulingMarket(final HttpServletRequest request, final RedirectAttributes redirectAttributes) {
    	String username =(String)request.getSession().getAttribute("usrname");
    	ModelAndView mv = new ModelAndView("editRulingMarket");
        try {
            final String id = request.getParameter("id");
            //System.out.println(id);
            final String dpcname = request.getParameter("dpcname");
            final String noofarrival = request.getParameter("noofarrival");
            final String dateofarrival = request.getParameter("dateofarrival");
            final String jutevariety = request.getParameter("jutevariety");
            final String cropyear = request.getParameter("cropyear");
            final String arrivedquantity = request.getParameter("arrivedquantity");
            final String minmoisture = request.getParameter("minmoisture");
            final String maxmoisture = request.getParameter("maxmoisture");
            final String gradewisefield = request.getParameter("gradewisefield");
            final String gradewiserate = request.getParameter("gradewiserate");
            final String estimatedgradecomposition = request.getParameter("estimatedgradecomposition");
            final RulingMarket updaterulingMarket = new RulingMarket();
            updaterulingMarket.setJcirulingmarketid(Integer.parseInt(id));
            updaterulingMarket.setArrivedquantity(Double.parseDouble(arrivedquantity));
            updaterulingMarket.setCropyear(cropyear);
            updaterulingMarket.setDpcname(dpcname);
            updaterulingMarket.setEstimatedgradecomposition(Integer.parseInt(estimatedgradecomposition));
            updaterulingMarket.setGradewisefield(Integer.parseInt(gradewisefield));
            updaterulingMarket.setGradewiserate(Integer.parseInt(gradewiserate));
            updaterulingMarket.setJutevariety(jutevariety);
            updaterulingMarket.setMaxmoisture(Integer.parseInt(maxmoisture));
            updaterulingMarket.setMinmoisture(Integer.parseInt(minmoisture));
            updaterulingMarket.setNoofarrival(noofarrival);
            this.rulingMarketService.create(updaterulingMarket);
            redirectAttributes.addFlashAttribute("msg", (Object)"<div class=\"alert alert-success\"><b>Success !</b> Record updated successfully.</div>\r\n");
            if(username == null) {
            	return new ModelAndView("index");
                }
            return new ModelAndView((View)new RedirectView("viewRulingMarket.obj"));
        }
        catch (Exception e) {
           e.printStackTrace();
            return mv;
        }
    }
    
    @ResponseBody
    @RequestMapping(value = { "findVByBlock" }, method = { RequestMethod.GET })
    public String getBlockdata(final HttpServletRequest request) {
        final String str = request.getParameter("F_Block");
        final int id = Integer.parseInt(str);
        final Gson gson = new Gson();
        return gson.toJson((Object)this.block.getAllFilledlock(id));
    }
    
    @ResponseBody
    @RequestMapping(value = { "findByPoliceStation" }, method = { RequestMethod.GET })
    public String getpoliceStationdata(final HttpServletRequest request) {
        final String str = request.getParameter("PoliceStation");
        final Gson gson = new Gson();
        return gson.toJson((Object)this.PoliceStationService.getAllFilledPoliceStation(str));
    }
    
    @RequestMapping({ "saveBale" })
    public ModelAndView saveBale(final HttpServletRequest request, final RedirectAttributes redirectAttributes) {
    	String username =(String)request.getSession().getAttribute("usrname");
    	final ModelAndView mv = new ModelAndView("balePreparation");
    	 if(username == null) {
         	return new ModelAndView("index");
             }
        try {
            final String place_of_packing = request.getParameter("place_of_packing");
            final String crop_year = request.getParameter("crop_year");
            final String bin_no = request.getParameter("bin_no");
            final String basis = request.getParameter("basis");
            final String jute_variety = request.getParameter("jute_variety");
            final String slip_no_from = request.getParameter("slip_no_from");
            final String slip_no_to = request.getParameter("slip_no_to");
            final String bale_no = request.getParameter("bale_no");
            final String created_by = request.getParameter("created_by");
            final String creation_date = request.getParameter("creation_date");
            final String jute_grade = request.getParameter("jute_grade");
            final BalePreparation balePreparation = new BalePreparation();
            if(isStringValid(place_of_packing) || isStringValid(crop_year) ||isStringValid(bin_no) ||isStringValid(basis) || isStringValid(jute_variety) || isStringValid(slip_no_from)
                    || isStringValid(slip_no_to) || isStringValid(bale_no) ||isStringValid(created_by) ||isStringValid(creation_date) || isStringValid(jute_grade)
                	)
                {
                  redirectAttributes.addFlashAttribute("msg", (Object)"<div class=\"alert alert-danger\"><b>Allowed only Alphabates and Numbers!</b> </div>\r\n");
                  return new ModelAndView((View)new RedirectView("balePreparation.obj"));
                }
            final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
            final LocalDateTime now = LocalDateTime.now();
            final String date = dtf.format(now);
            balePreparation.setCreation_date(date);
            final long millis = System.currentTimeMillis();
            final java.sql.Date sqlDate = new java.sql.Date(millis);
            //System.out.println("sqlDate =====   "+sqlDate);
            balePreparation.setPacking_date(sqlDate.toString());
            balePreparation.setPlace_of_packing(place_of_packing);
            balePreparation.setCrop_year(crop_year);
            balePreparation.setBin_no(bin_no);
            balePreparation.setBasis(basis);
            balePreparation.setJute_variety(jute_variety);
            balePreparation.setJute_grade(jute_grade);
            balePreparation.setSlip_no_from(slip_no_from);
            balePreparation.setSlip_no_to(slip_no_to);
            final int bale_no2 = Integer.parseInt(bale_no);
            balePreparation.setBale_no(bale_no2);
            balePreparation.setJute_grade(jute_grade);
            final int createdBy = (int)request.getSession().getAttribute("userId");
            balePreparation.setCreated_by(createdBy);
            final int toCheckSlipNoInt = Integer.parseInt(slip_no_to);
            final int fromCheckSlipNoInt = Integer.parseInt(slip_no_from);
            if (toCheckSlipNoInt > fromCheckSlipNoInt) {
                this.balePrepareService.create(balePreparation);
                redirectAttributes.addFlashAttribute("msg", (Object)"<div class=\"alert alert-success\"><b>Success !</b> Record created successfully.</div>\r\n");
                return new ModelAndView((View)new RedirectView("balePreparation.obj"));
            }
            redirectAttributes.addFlashAttribute("msg", (Object)"<div class=\"alert alert-danger\"><b>OOps!</b> Error in record saving. </div>\r\n");
           
            return new ModelAndView((View)new RedirectView("balePreparation.obj"));
        }
        catch (Exception e) {
            e.printStackTrace();
            return new ModelAndView((View)new RedirectView("balePreparation.obj"));
        }
    }
    
    @ResponseBody
    @RequestMapping(value = { "findGradeOnJute" }, method = { RequestMethod.GET })
    public String findGradeOnJute(final HttpServletRequest request) {
        final Gson gson = new Gson();
        final List<String> result = (List<String>)this.jbaservice.findGradeOnJute(request.getParameter("jvariety"));
        return gson.toJson((Object)result);
    }
    
    @ResponseBody
    @RequestMapping(value = { "RouteEditforCheck" }, method = { RequestMethod.GET })
    public String RouteEditforCheck(final HttpServletRequest request) {
        final String str = request.getParameter("id");
        final Gson gson = new Gson();
        final List<String> DaysCount = (List<String>)this.jbaservice.GetDayCountofJBA(str);
        final Integer DaysCount2 = Integer.parseInt(DaysCount.toString().replace("[", "").replace("]", ""));
        return gson.toJson((Object)DaysCount2);
    }
    
    @ResponseBody
    @RequestMapping(value = { "GetDpcName" }, method = { RequestMethod.GET })
    public String GetDpcName(final HttpServletRequest request) {
        final int dpcCode = Integer.parseInt(request.getParameter("dpcCode"));
        
        final Gson gson = new Gson();
        final List<String> DaysCount = (List<String>)this.batchService.GetDpcNamefromId(Integer.parseInt(request.getParameter("dpcCode")));
        final String d = DaysCount.toString().replace("[", "").replace("]", "");
        return gson.toJson((Object)d);
    }
    
    @ResponseBody
    @RequestMapping(value = { "transectionDetails" }, method = { RequestMethod.GET })
    public String transectionDetails(final HttpServletRequest request) {
        final String details = this.verifyTallySlipService.GettransectionDetails(request.getParameter("tallyslipNo"), request.getParameter("region"),request.getParameter("placeofp"));
        return details;
    }
    
    @RequestMapping({ "disputedtallyslip" })
    public ModelAndView viewDisputedTallySlipList(final HttpServletRequest request, RedirectAttributes red) {
    	String username =(String)request.getSession().getAttribute("usrname");
    	ModelAndView mv = new ModelAndView("disputedtallyslip");
    	if(username == null) {
        	return new ModelAndView("index");
            }
    	String pagename = "disputedtallyslip";
        int i = checkprivileges(pagename);
        if(i != 1)
        {
        	 red.addFlashAttribute("errorMessage","Access denied");
			   return mv=new ModelAndView("Home");
        }
        try {
    	 String role_type = (String)request.getSession().getAttribute("roletype");
         String region =(String)request.getSession().getAttribute("regionId"); 
    	 String dpcId =(String)request.getSession().getAttribute("dpcId");
         List<VerifyTallySlip> verifyList = (List<VerifyTallySlip>)this.verifyTallySlipService.getAll("RMD",region, role_type);
        mv.addObject("verifyTallySliList", (Object)verifyList);
        Integer userRole= (Integer)request.getSession().getAttribute("roleId");
   		//System.out.println("userRole=="+userRole);
   		  }
        catch (Exception e)
		{
			//System.out.println("++++++++++++++"+e);
			e.printStackTrace();
		}
        
        return mv;
    }
    
    @RequestMapping({ "decissionmaking" })
    public ModelAndView decissionmakingTallySlipList(final HttpServletRequest request, RedirectAttributes red) {
    	String username =(String)request.getSession().getAttribute("usrname");
    	ModelAndView mv = new ModelAndView("decissionmaking");
    	if(username == null) {
        	return new ModelAndView("index");
            }
    	
    	String pagename = "decissionmaking";
        int i = checkprivileges(pagename);
        if(i != 1)
        {
        	 red.addFlashAttribute("errorMessage","Access denied");
			   return mv=new ModelAndView("Home");
        }
    	
    	 String dpcId =(String)request.getSession().getAttribute("dpcId");
    	 String role_type = (String)request.getSession().getAttribute("roletype");
    	 String key = LoginController.secretkey;
	    // String decryptedString = request.getParameter("id");
	     final int id = Integer.parseInt(request.getParameter("id"));
        String region =(String)request.getSession().getAttribute("region"); 
        final VerifyTallySlip vrf = this.verifyTallySlipService.find(id);
        System.out.println("vrf_________________"+vrf);
        final RawJuteProcurementAndPayment raw = this.rawJuteProcurAndPayService.findbyTally(vrf.getTallyNo(), Integer.parseInt(vrf.getRegion_id()));
        System.out.println("raw_________________"+raw);
        final List<VerifyTallySlip> verifyList = (List<VerifyTallySlip>)this.verifyTallySlipService.getAll("RMD", region, role_type);
        mv.addObject("verifyTallySliList", (Object)verifyList);
        mv.addObject("vrftally", (Object)vrf);
        mv.addObject("raw", (Object)raw);
        
        return mv;
    }
    
    @ResponseBody
    @RequestMapping(value = { "rmapproval" }, method = { RequestMethod.GET })
    public String rmapproval(final HttpServletRequest request) {
        final String tally = request.getParameter("tallyno");
        final String status = request.getParameter("status");
        final int is_verified = Integer.parseInt(request.getParameter("verified"));
        String DPCpop = request.getParameter("DPCpop");
        String DEOpop = request.getParameter("DEOpop");
        final boolean raw = this.rawJuteProcurAndPayService.updateProcurement(status, is_verified, tally,DPCpop);
        
        final boolean ver = this.verifyTallySlipService.updatebyTally(status, is_verified, tally,DPCpop,DEOpop);
        if (raw && ver) {
            return "true";
        }
        return "false";
    }
    
    @RequestMapping({ "tallyapproval" })
    public ModelAndView tallyapproval(final HttpServletRequest request, RedirectAttributes red) {
    	String username =(String)request.getSession().getAttribute("usrname");
    	ModelAndView mv = new ModelAndView("tallyapproval"); 
    	if(username == null) {
        	return new ModelAndView("index");
            }
    	String pagename = "tallyapproval";
        int i = checkprivileges(pagename);
        if(i != 1)
        {
        	 red.addFlashAttribute("errorMessage","Access denied");
			   return mv=new ModelAndView("Home");
        }
        final List<RawJuteProcurementAndPayment> juteList = (List<RawJuteProcurementAndPayment>)this.rawJuteProcurAndPayService.jutelistbystatus("ROV",request);
        mv.addObject("juteList", (Object)juteList);
        return mv;
    }
    
    //(vishal)
    @RequestMapping({ "tallyListRMA" })
    public ModelAndView tallyListRMA(final HttpServletRequest request) {
    	String username =(String)request.getSession().getAttribute("usrname");
    	if(username == null) {
        	return new ModelAndView("index");
            }
    	ModelAndView mv = new ModelAndView("tallyListRMA");
    	String roletype = (String) request.getSession().getAttribute("roletype");
        final List<RawJuteProcurementAndPayment> juteList = (List<RawJuteProcurementAndPayment>)this.rawJuteProcurAndPayService.delayedenteredtallylist("RMA","DPC",request);
        mv.addObject("juteList", (Object)juteList);
        
        return mv;
    }
    
    //(vishal)
    @RequestMapping({ "approvalTallyslip" })
    public ModelAndView approvalTallyslip(final HttpServletRequest request) {
    	String username =(String)request.getSession().getAttribute("usrname");
    	if(username == null) {
        	return new ModelAndView("index");
            }
    	ModelAndView mv = new ModelAndView("tallyListRMA");
    	String tally = request.getParameter("tally");
    	String placeofp = request.getParameter("placeofp");
    	boolean status = rawJuteProcurAndPayService.updateStatus(tally,placeofp);
    	String roletype = (String) request.getSession().getAttribute("roletype");
        final List<RawJuteProcurementAndPayment> juteList = (List<RawJuteProcurementAndPayment>)this.rawJuteProcurAndPayService.delayedenteredtallylist("RMA","DPC",request);
        mv.addObject("juteList", (Object)juteList);
        mv.addObject("msg", (Object)"<div class=\"alert alert-success\"><b>Success !</b> Record updated successfully.</div>\r\n" + "");
        return mv;
    }
    
    //rejectTallyslip list (vishal)
    @RequestMapping({ "rejectTallyslip" })
    public ModelAndView rejectTallyslip(final HttpServletRequest request) {
    	String username =(String)request.getSession().getAttribute("usrname");
    	if(username == null) {
        	return new ModelAndView("index");
            }
    	ModelAndView mv = new ModelAndView("tallyListRMA");
    	String tally = request.getParameter("tally");
    	String placeofp = request.getParameter("placeofp");
    	boolean status = rawJuteProcurAndPayService.updateStatusDPCW(tally,placeofp);
    	String roletype = (String) request.getSession().getAttribute("roletype");
        final List<RawJuteProcurementAndPayment> juteList = (List<RawJuteProcurementAndPayment>)this.rawJuteProcurAndPayService.delayedenteredtallylist("RMA","DPC",request);
        mv.addObject("juteList", (Object)juteList);
        mv.addObject("msg", (Object)"<div class=\"alert alert-success\"><b>Success !</b> Record updated successfully.</div>\r\n" + "");
        return mv;
    }
    
    @ResponseBody
    @RequestMapping(value = { "validateTally" }, method = { RequestMethod.GET })
    public String validateTally(final HttpServletRequest request) {
        final String ro = (String)request.getSession().getAttribute("region");
        final String tallyslip = request.getParameter("tally");
        final Gson gson = new Gson();
        return this.rawJuteProcurAndPayService.validateTally(tallyslip, ro) + "";
    }
    
    @ResponseBody
    @RequestMapping(value = { "findBinno" }, method = { RequestMethod.GET })
    public String findBinno(final HttpServletRequest request) {
        final Gson gson = new Gson();
        //System.out.println(request.getParameter("cropyr") +"   "+request.getParameter("dpcid"));
        final List<String> result = (List<String>)this.ropeMakingService.findBinno(request.getParameter("cropyr"), request.getParameter("dpcid"));
        return gson.toJson((Object)result);
    }
    
    @RequestMapping(value = { "verificationTallyslip2" }, method = { RequestMethod.GET })
    public ModelAndView verifytallyslip(final HttpServletRequest request, RedirectAttributes red) {
    	String username =(String)request.getSession().getAttribute("usrname");
    	ModelAndView mv = new ModelAndView();
    	if(username == null) {
        	return mv = new ModelAndView("index");
            }
    	
    	String pagename = "verificationTallyslip2";
        int i = checkprivileges(pagename);
        if(i != 1)
        {
        	 red.addFlashAttribute("errorMessage","Access denied");
			   return mv=new ModelAndView("Home");
        }
	   	String key = LoginController.secretkey;
	   	String placeofp = request.getParameter("placeofp");
	 	String decryptedString = request.getParameter("tally");
	 	//final String tally = Encry.decrypt(decryptedString, key);
        mv.addObject("tallyslip", (Object)decryptedString);
        mv.addObject("placeofp", (Object)placeofp);
        //System.err.println("placeof purchases"+request.getParameter("placeofp"));
        mv.setViewName("verifyTallySlip");
        
        return mv;
    }
    
    @RequestMapping(value = { "dpc2" }, method = { RequestMethod.GET })
    public void dpc2(final HttpServletRequest request) {
        final List<DailyPurchaseConfModel> dpclist = (List<DailyPurchaseConfModel>)this.DailyPurchasefService.dpc2();
        for (int i = 0; i < dpclist.size(); ++i) {
            this.DailyPurchasefService.create((DailyPurchaseConfModel)dpclist.get(i));
        }
    }
    @ResponseBody
	@RequestMapping(value = "GetdetailsbasedonBinNo", method = RequestMethod.GET)
	public String GetdetailsbasedonBinNo(HttpServletRequest request) {
		String str = request.getParameter("binNo");
		Gson gson = new Gson();
		List<String> DaysCount = batchService.FinddetailsbasedonBinNo(str);
		String DaysCount1 = DaysCount.toString().replace("[", "").replace("]", "");
		return gson.toJson(DaysCount);
	}

	@RequestMapping("binPurchasemapping")
	public ModelAndView binPurchasemapping(HttpServletRequest request,RedirectAttributes red) {
    	String username =(String)request.getSession().getAttribute("usrname");
		ModelAndView mv = new ModelAndView("Bin_Purchase_mapping");
		if(username == null) {
        	return mv = new ModelAndView("index");
            }
		String pagename = "binPurchasemapping";
        int i = checkprivileges(pagename);
        if(i != 1)
        {
        	 red.addFlashAttribute("errorMessage","Access denied");
			   return mv=new ModelAndView("Home");
        }
		return mv;
	}

	@RequestMapping("BinPurchasemapping_mid")
	public ModelAndView BinPurchasemapping_mid(HttpServletRequest request, final RedirectAttributes redirectAttributes) {
    	String username =(String)request.getSession().getAttribute("usrname");
    	if(username == null) {
        	return new ModelAndView("index");
            }
		String cropyr = request.getParameter("cropyr");
		String dadatepurchasetepurchase = request.getParameter("datepurchase");
		String binNo = request.getParameter("binNo");	
		   if(isStringValid(cropyr) || isStringValid(dadatepurchasetepurchase) || isStringValid(binNo))
	            	
	            {
	              redirectAttributes.addFlashAttribute("msg", (Object)"<div class=\"alert alert-danger\"><b>Allowed only Alphabates and Numbers!</b> </div>\r\n");
	              return new ModelAndView((View)new RedirectView("binPurchasemapping.obj"));
	            }
		List<BinPurchaseMappingDTO> binPurchaseList = new ArrayList<>();
		try {
			binPurchaseList = batchService.GetBinPurchasemappingdetails(cropyr, dadatepurchasetepurchase, binNo);
		} catch (Exception e) {
			 System.out.println(e.getStackTrace());
		}		
		ModelAndView mv = new ModelAndView("View_Purchase_Bin_Mapping");
		
		mv.addObject("binPurchaseList", binPurchaseList);
		return mv;
	}
	
	@ResponseBody
	@RequestMapping(value = "caculateTotalBinPurchase", method = RequestMethod.GET)
	public String caculateTotalBinPurchase(HttpServletRequest request) {
    	String username =(String)request.getSession().getAttribute("usrname");
		String binNo = request.getParameter("binNo");
		String CropYr = request.getParameter("CropYr");
		String dateOfPurch = request.getParameter("dateOfPurch");
		Gson gson = new Gson();
		List<String> DaysCount = batchService.GetTotalofPurchaseParams(binNo, CropYr, dateOfPurch);
		return gson.toJson(DaysCount);
	}
	
	@ResponseBody
	@RequestMapping(value = "InsertIntoTablePurchaseMapping", method = RequestMethod.GET)
	public String InsertIntoTablePurchaseMapping(HttpServletRequest request) {
    	String username =(String)request.getSession().getAttribute("usrname");
		String dateOfPurch = request.getParameter("dateOfPurch");
		String dpcCode = request.getParameter("dpcCode");
		String Basis = request.getParameter("Basis");
		String JuteVariety = request.getParameter("JuteVariety");
		String CropYr = request.getParameter("CropYr");
		String binNo = request.getParameter("binNo");
		String totNetQty = request.getParameter("totNetQty");
		String totGarsat = request.getParameter("totGarsat");
		String totValue = request.getParameter("totValue");
		Gson gson = new Gson();
		List<String> DaysCount = batchService.InsertToBinPurchaseMapping(dateOfPurch, dpcCode, Basis, JuteVariety, CropYr, binNo, totNetQty, totGarsat, totValue);
		return gson.toJson(DaysCount);
	}
	
	@RequestMapping(value="fingain")
	public ModelAndView fingain(HttpServletRequest request,RedirectAttributes red) {
    	String username =(String)request.getSession().getAttribute("usrname");
		ModelAndView mv = new ModelAndView("FinGainAnd WeightGain");
		if(username == null) {
        	return mv = new ModelAndView("index");
            }
		String pagename = "fingain";
        int i = checkprivileges(pagename);
        if(i != 1)
        {
        	 red.addFlashAttribute("errorMessage","Access denied");
			   return mv=new ModelAndView("Home");
        }
		return mv;
	}
	
	@ResponseBody
	@RequestMapping(value = "calculateGainFromproc", method = RequestMethod.GET)
	public String calculateGainFromproc(HttpServletRequest request) {
		String FinYear = request.getParameter("FinYear");
		String binNO = request.getParameter("binNO");
		Gson gson = new Gson();
		List<String> DaysCount = batchService.CalculateGainBasedonBinFromproc(FinYear, binNO);
		return gson.toJson(DaysCount);
	}
	
	@ResponseBody
	@RequestMapping(value = "InsertBinDataTodb", method = RequestMethod.GET)
	public String InsertBinDataTodb(HttpServletRequest request) {
		String FinYear = request.getParameter("FinYear");
		String binNO = request.getParameter("binNO");
		String FinGain = request.getParameter("FinGain");
		String WeightGain = request.getParameter("WeightGain");
		Gson gson = new Gson();
		List<String> DaysCount = batchService.InsertTotalwithGaininBinTabledb(FinYear, binNO, FinGain, WeightGain);
		return gson.toJson(DaysCount);
	}
	
	@RequestMapping("BinListfromDb")
	public ModelAndView BinListfromDb(HttpServletRequest request,RedirectAttributes red) {
		String username =(String)request.getSession().getAttribute("usrname");
		ModelAndView mv = new ModelAndView("ViewBinDataFromDb");
		if(username == null) {
        	return new ModelAndView("index");
            }
		String pagename = "BinListfromDb";
        int i = checkprivileges(pagename);
        if(i != 1)
        {
        	 red.addFlashAttribute("errorMessage","Access denied");
			   return mv=new ModelAndView("Home");
        }
		List<BinListFromDbDTO> binPurchaseList = new ArrayList<>();
		try {
			binPurchaseList = batchService.GetBinListFromDb();
			 Integer roleId= (Integer)request.getSession().getAttribute("roleId");
	   		   //System.out.println("roleId===="+roleId);
	   	
		} catch (Exception e) {
			 System.out.println(e.getLocalizedMessage());
		}		
	
		mv.addObject("binPurchaseList", binPurchaseList);
		
		return mv;
	}
	 
    @ResponseBody
    @RequestMapping(value = "getbinno" , method =  RequestMethod.GET )
    public String getbinno(final HttpServletRequest request) {
        final String result = rawJuteProcurAndPayService.getbinno(request.getParameter("binno"));
        return result;
    }
    
    @ResponseBody
	@RequestMapping(value = "userProfile", method = RequestMethod.GET)
	public ModelAndView getuserprofile(HttpServletRequest request) {
    	String username =(String)request.getSession().getAttribute("usrname");
    	if(username == null) {
        	return new ModelAndView("index");
            }
		ModelAndView mv = new ModelAndView("userProfile");
		int refid = (int) request.getSession().getAttribute("userId");
		UserRegistrationModel profile=userRegService.getuserprofile(refid);
		mv.addObject("profile", profile);
		
		return mv;
	}
	
    @ResponseBody
   	@RequestMapping(value = "editprofile", method = RequestMethod.GET)
   	public ModelAndView geteditprofile(HttpServletRequest request) {
    	String username =(String)request.getSession().getAttribute("usrname");
    	if(username == null) {
        	return new ModelAndView("index");
            }
   		ModelAndView mv = new ModelAndView("editprofile");
   		int refid = (int) request.getSession().getAttribute("userId");
   		UserRegistrationModel profile=userRegService.getuserprofile(refid);
   		mv.addObject("profile", profile);
   		
   		return mv;
   	}
	
	@RequestMapping("updatesaveProfile")
	public ModelAndView updateProfile(HttpServletRequest request,RedirectAttributes redirectAttributes)
	{String username =(String)request.getSession().getAttribute("usrname");
		ModelAndView mv = new ModelAndView("userProfile");
		if(username == null) {
        	return mv = new ModelAndView("index");
            }
		try {
			boolean flag = true;
			int refid = (int) request.getSession().getAttribute("userId");
			UserRegistrationModel userRegistration = userRegService.find(refid);
			String view = "";
				//String  mobileno=  request.getParameter("mobile");
				String password =  request.getParameter("password");
				String newpassword =  request.getParameter("newpassword");
				String renewpassword =  request.getParameter("repassword");
				String currentpass = userRegistration.getPassword();
				
				if(newpassword.equals("") || renewpassword.equals(""))
			       {
			        	redirectAttributes.addFlashAttribute("msg", (Object)"<div class=\"alert alert-danger\"><b> please fill the password! </b> </div>\r\n");
			              return new ModelAndView((View)new RedirectView("editprofile.obj"));
			       }
				if(!currentpass.equals(password))
				{
					 redirectAttributes.addFlashAttribute("msg", (Object)"<div class=\"alert alert-danger\"><b> Current password is incorrect! </b> </div>\r\n");
		              return new ModelAndView((View)new RedirectView("editprofile.obj"));
				}
				if(!renewpassword.equals(newpassword))
				{
					 redirectAttributes.addFlashAttribute("msg", (Object)"<div class=\"alert alert-danger\"><b> Both passwords didn't match! </b> </div>\r\n");
		              return new ModelAndView((View)new RedirectView("editprofile.obj"));
				}
				String passwordRegex = "^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).{8,}$";
		        if (!newpassword.matches(passwordRegex) || !renewpassword.matches(passwordRegex) ) {
		        	 redirectAttributes.addFlashAttribute("msg", (Object)"<div class=\"alert alert-danger\"><b> Password didn't match with criteria! </b> </div>\r\n");
		              return new ModelAndView((View)new RedirectView("editprofile.obj"));
		        } 
		        
				userRegistration.setRefid(refid);
			//	userRegistration.setMobileno(mobileno);
				if(!password.isEmpty() && !renewpassword.isEmpty() && !newpassword.isEmpty() && password.equals(userRegistration.getPassword()) && renewpassword.equals(newpassword)) 
				{
					userRegistration.setPassword(renewpassword);
					userRegistration.setDatelastchangepassword(new Date());
					userRegistration.setUpdatedat(new Date());
					 view = "login.obj";
					 userRegService.update(userRegistration);
					 String set0 = "1";
                     userRegService.updateConcurrentlogin(username,set0);
					 HttpSession session = request.getSession();
                     session.invalidate();
					   redirectAttributes.addFlashAttribute("msg",
								"<div class=\"alert alert-success\"><b>Success !</b> Password updated successfully.</div>\r\n" + "");
				}
				
				else
				{
					view = "editprofile.obj";
				    redirectAttributes.addFlashAttribute("msg",
							"<div class=\"alert alert-danger\"><b>Failed !</b>Failed to change password.</div>\r\n" + "");
				}		 
				return new ModelAndView(new RedirectView(view));
		} catch(Exception e){
			System.out.println(e.getStackTrace());
		}
		
		return mv;
	}

	@RequestMapping({ "updateuserProfile" })
	public ModelAndView updateUserProfile(HttpServletRequest request,RedirectAttributes redirectAttributes) throws NumberFormatException, Exception
	{String username =(String)request.getSession().getAttribute("usrname");
		ModelAndView mv = new ModelAndView("edituserProfile");
		if(username == null) {
        	return mv = new ModelAndView("index");
            }
		String pagename = "updateuserProfile";
        int i = checkprivileges(pagename);
        if(i != 1)
        {
        	redirectAttributes.addFlashAttribute("errorMessage","Access denied");
			   return mv=new ModelAndView("Home");
        }
		String key = LoginController.secretkey;
		String decryptedString = request.getParameter("id");
		int refid = Integer.parseInt(Encry.decrypt(decryptedString, key));

		System.err.println("refid"+refid);
		UserRegistrationModel profile=userRegService.getuserprofile(refid);
		 final List<ZoneModel> zoneList = (List<ZoneModel>)this.zoneService.getAll();
	        final List<UserRoleModel> alluserroleList = (List<UserRoleModel>)this.userroleService.getAll();
	        mv.addObject("zoneList", (Object)zoneList);
	        mv.addObject("roleList", (Object)alluserroleList);
		mv.addObject("profile", profile);

		return mv;
	}
	

	
	@RequestMapping("updatesaveuserProfile")
	public ModelAndView updatesaveUserProfile(HttpServletRequest request,RedirectAttributes redirectAttributes)
	{
		String username =(String)request.getSession().getAttribute("usrname");
		ModelAndView mv = new ModelAndView("edituserProfile");
		if(username == null) {
        	return new ModelAndView("index");
            }
		try {
			int refid = Integer.parseInt(request.getParameter("id"));
			UserRegistrationModel userRegistration = userRegService.find(refid);
				String email = request.getParameter("emailAddress");
				if(email == null)
				{	email = "";}
				String mobileno =  request.getParameter("mobile");
				if(mobileno == null)
				{	mobileno = "";}
				String centername = request.getParameter("centerordpc");
				if(centername == null)
				{	centername = "";}
				String roname =  request.getParameter("region");
				if(roname == null)
				{	roname = "";}
				String zonename = request.getParameter("zone");
				if(zonename == null)
				{	zonename = "";}
				String usertype = request.getParameter("usertype");
				if(usertype == null)
				{	usertype = "";}
				userRegistration.setRefid(refid);
				 String role = request.getParameter("rolename");
				 if(role == null)
					{	role = "";}
		         String roletype = request.getParameter("roletype");
		         if(roletype == null)
					{	roletype = "";}
		         String roleid = request.getParameter("roleid");
		         if(roleid == null)
					{	roleid = "0";}
                if(isStringValid(email) || isStringValid(mobileno) || isStringValid(centername) || isStringValid(roname) || isStringValid(zonename)
                  || isStringValid(usertype) || isStringValid(role) || isStringValid(roletype) || isStringValid(roleid))
		            {
		              redirectAttributes.addFlashAttribute("msg", (Object)"<div class=\"alert alert-danger\"><b>Allowed only Alphabates and Numbers!</b> </div>\r\n");
		              return new ModelAndView((View)new RedirectView("viewUserRegistration.obj"));
		            }
                System.err.println("after");
		        if(roletype.equalsIgnoreCase("ho")) {
		    		userRegistration.setDpcId(null);
					userRegistration.setZone(null);
					userRegistration.setRegion(null);
		        }
		        else  if(roletype.equalsIgnoreCase("ro")) {
		        	userRegistration.setDpcId(null);
					userRegistration.setZone(zonename);
					userRegistration.setRegion(roname);
		        }
		        else  if(roletype.equalsIgnoreCase("dpc")) {
		        	userRegistration.setDpcId(centername);
					userRegistration.setZone(zonename);
					userRegistration.setRegion(roname);
		        }
				userRegistration.setEmail(email);

				userRegistration.setMobileno(mobileno);
				userRegistration.setRole_type(roletype);
				userRegistration.setRoleId(Integer.parseInt(roleid));
		
				userRegistration.setUsertype(usertype);
				userRegistration.setRoles_name(role);
				userRegistration.setUpdatedat(new Date());
				userRegService.update(userRegistration);
			    redirectAttributes.addFlashAttribute("msg",
				"<div class=\"alert alert-success\"><b>Success !</b> Record updated successfully.</div>\r\n" + "");
			return new ModelAndView(new RedirectView("viewUserRegistration.obj"));
		} catch(Exception e){
			System.out.println("Error in update user profile"+ e.getStackTrace());
		}
		
		return mv;
	}

	
	  @RequestMapping({ "bnaDelete" })
    public ModelAndView bnaDelete(final HttpServletRequest request, final RedirectAttributes redirectAttributes) {
		  final ModelAndView mv = new ModelAndView("viewUserRegistration");
		  String username =(String)request.getSession().getAttribute("usrname");
		  if(username == null) {
          	return new ModelAndView("index");
              }
		  String dpcId =(String)request.getSession().getAttribute("dpcId");
			String placeofactivity =(String)request.getSession().getAttribute("dpcId");
	     	String regionId =(String)request.getSession().getAttribute("regionId");
	     	String zoneId =(String)request.getSession().getAttribute("zoneId");
        try {
            final String id = request.getParameter("id");
            this.UserRegistrationService.delete(Integer.parseInt(id));
            final List<UserRegistrationModel> allUserRegistration = (List<UserRegistrationModel>)this.UserRegistrationService.getAll( dpcId,regionId,  zoneId);
            mv.addObject("UserRegistrationList", (Object)allUserRegistration);
            redirectAttributes.addFlashAttribute("msg", (Object)"<div class=\"alert alert-success\"><b>Success !</b> Data deleted successfully.</div>\r\n");
           
            return new ModelAndView((View)new RedirectView("viewUserRegistration.obj"));
        }
        
        catch (Exception ex) {
            return mv;
        }
    }
	  
	  @ResponseBody
	    @RequestMapping(value = { "validateEmployeeid" }, method = { RequestMethod.GET })
	    public String validateEmployeeid(final HttpServletRequest request) {
	        final Gson gson = new Gson();
	        return this.UserRegistrationService.validateEmployeeid(request.getParameter("employeeid")) + "";
	    }
	  
	  
	  @ResponseBody
	    @RequestMapping(value = { "validateUserMobile" }, method = { RequestMethod.GET })
	    public String validateUserMobile(final HttpServletRequest request) {
	        final Gson gson = new Gson();
	        return this.UserRegistrationService.validateUserMobile(request.getParameter("mobileno")) + "";
	    }
	  
	  @Value("${upload.tallyexcel}")
	    String path;
	  @ResponseBody
	    @RequestMapping(value = { "update_paymentstatus" }, method = { RequestMethod.GET })
	    public String updatedpaymentstatus(final HttpServletRequest request, final RedirectAttributes redirectAttributes, HttpSession session) {
	    	String a = "success";
	    	String tallyno = "";
	    try {
	    	String username =(String)request.getSession().getAttribute("usrname");
	    	String path1 ="E:\\Program Files\\Apache Software Foundation\\Tomcat 8.5\\webapps\\TallySlipPayments\\";
	    //	String path1 ="/Users/apple/Documents/Bob/";
	    //	String path1 ="C:\\Users\\vishal.vishwakarma\\Downloads\\";
	    	//generating crop year
	    	String cropyear = "";
			Calendar cal = new GregorianCalendar();
			int month = cal.get(Calendar.MONTH);
			month++;
		    int year = cal.get(Calendar.YEAR);
		    if(month>6)
		    {
		    	cropyear = year+"-"+(year+1);
		    }else
		    {
		    	cropyear = (year-1)+"-"+year;
		    }
	    

	     String usrname = ""; 
	     String usermail = (String) session.getAttribute("usrname"); 
	     Random num = new Random();
	     int random_no = 10000 + num.nextInt(90000);
	     usrname = cropyear +"-"+ random_no +".xlsx";
	     String tno ="";
	     String tnoemail="";
	     tallyno = request.getParameter("tallyno");
	    // System.err.println("all tallyno   ="+tallyno);
	     String roho = request.getParameter("roho");
	     tallyno = tallyno.replaceAll("\\[","").replaceAll("\\]","").replaceAll("\"", "'");
	     System.err.println("tallyno array  ="+tallyno);
	     this.verifyTallySlipService.updatestatustoPP(tallyno);
	     
	     System.err.println("Status Updated to table for tally = "+tallyno);
	     
	     String[] tally = tallyno.split(",");
	     List<PaymentprocesstellyslipModel> list = new ArrayList();
	     PaymentprocesstellyslipModel paymentlist = new PaymentprocesstellyslipModel();
	     String filename = "";
	     double totalamount = 0;
	     String jciref = "";
	         String[] columns = {"Amount","Debit A/C No","Beneficiary IFSC code","Beneficiary A/C No","A/C type","Beneficiary Name","Beneficiary Branch","JCI Ref","Sender","Beneficiary Bank","Purchase Date","UTR No","Date"};
	        // usrname = usrname+x+"payment_slip.xlsx";
	         filename = path1+usrname;
	         Workbook workbook = new XSSFWorkbook(); 
	         Sheet sheet = workbook.createSheet();
	         Font headerFont = workbook.createFont();
	         headerFont.setBold(true);
	         headerFont.setFontHeightInPoints((short)11);
	         headerFont.setColor(IndexedColors.BLACK.getIndex());
	         CellStyle headerCellStyle = workbook.createCellStyle();
	         headerCellStyle.setFont(headerFont);
	         Row headerRow =sheet.createRow(0);
	         for(int j=0; j < columns.length; j++)
		         {
		            Cell cell = headerRow.createCell(j);
		            cell.setCellValue(columns[j]);
		            cell.setCellStyle(headerCellStyle);
		         }
	                int rownum = 1; 
	          for(int i=0;i<tally.length;i++)
	            {
	        	    tno = tally[i];
	        	    paymentlist = this.verifyTallySlipService.getdataforExcelSheet(tno);
	        	    System.err.println("get data for exel for tally = "+tno);
		            tnoemail = tno.replace("\'","");
		            jciref = paymentlist.getDpc_name()+"-"+tnoemail+"-"+paymentlist.getFarmerreg_no();
		            tno = "";
	                PaymentprocesstellyslipModel createpayment = new PaymentprocesstellyslipModel();
	                createpayment.setAmount(paymentlist.getAmount());
	                createpayment.setDebitAC_no(paymentlist.getDebitAC_no());
	                createpayment.setBeneficiary_IFSC_code(paymentlist.getBeneficiary_IFSC_code());
	                createpayment.setBeneficiaryAC_No(paymentlist.getBeneficiaryAC_No());
	                createpayment.setAC_type(paymentlist.getAC_type());
	                createpayment.setBeneficiary_name(paymentlist.getBeneficiary_name());
	                createpayment.setBeneficiary_branch(paymentlist.getBeneficiary_branch());
	                createpayment.setJCI_Ref(jciref);
	                createpayment.setSender("JCI");
	                createpayment.setBeneficiary_bank(paymentlist.getBeneficiary_bank());
	                createpayment.setPurchase_date(paymentlist.getPurchase_date());
	                //createpayment.setUTR_no("UTR NO");
	                //createpayment.setDate(paymentlist.getDate());
	                createpayment.setExcel_link(filename);
	                //System.out.println("create payment controller = "+createpayment.toString());
	                try {
		                   verifyTallySlipService.savedata(createpayment);
		                   System.err.println("Row created in jcitallyslippayment");
		                }
	                catch (Exception e)
	                  {
						System.out.println("payment process createpayment controlelr exc = "+e.getLocalizedMessage());
			          }
	                
	                Row row = sheet.createRow(rownum++);
	                row.createCell(0).setCellValue(String.valueOf(paymentlist.getAmount()));
	                row.createCell(1).setCellValue(paymentlist.getDebitAC_no()); 
	                row.createCell(2).setCellValue(paymentlist.getBeneficiary_IFSC_code());  
	                row.createCell(3).setCellValue(paymentlist.getBeneficiaryAC_No());  
	                row.createCell(4).setCellValue(paymentlist.getAC_type());  
	                row.createCell(5).setCellValue(paymentlist.getBeneficiary_name());  
	                row.createCell(6).setCellValue(paymentlist.getBeneficiary_branch()); 
	                row.createCell(7).setCellValue(jciref); 
	                row.createCell(8).setCellValue("JCI");  
	                row.createCell(9).setCellValue(paymentlist.getBeneficiary_bank());  
	                DateFormat dateFormat = new SimpleDateFormat("dd/mm/yyyy");  
	                String purchasedate = paymentlist.getPurchase_date(); 
	                row.createCell(10).setCellValue(purchasedate);  
	                row.createCell(11).setCellValue("");
	                //String currentdate = dateFormat.format(paymentlist.getDate());
	                row.createCell(12).setCellValue(""); 
	                totalamount +=  paymentlist.getAmount();
	                
	           }
	             totalamount =Double.parseDouble(new DecimalFormat("##.####").format(totalamount));
		          for(int j=0; j < columns.length; j++)
		         {
		                sheet.autoSizeColumn(j);
		         }
		          FileOutputStream fileOut = new FileOutputStream(filename);  
		          workbook.write(fileOut); 
		          fileOut.close();
		          workbook.close();
		          System.err.println("Sheet created locally");
		          String subject = "NEFT Advice Sheet: "+usrname+"-Rs."+totalamount;
		          String toEmail = "";
		          String FA_approver_email = this.verifyTallySlipService.getEmailby_tally(tnoemail);
		          if(roho.equalsIgnoreCase("RO"))
		          {
		        	  //mail to RM-Finance(fa approver) and RM(Regional Manager(jo login kiya h))
		        	//  toEmail = FA_approver_email+","+usermail;
		        	  InternetAddress[] toAddresses  = {  new InternetAddress(FA_approver_email) , new InternetAddress(usermail) ,new InternetAddress("vishal.vishwakarma@cyfuture.com") ,new InternetAddress("animesh.anand@cyfuture.com"),new InternetAddress("saumyadeep@jcimail.in")};
		        	  toEmail =  FA_approver_email+", "+usermail+", vishal.vishwakarma@cyfuture.com, animesh.anand@cyfuture.com";
		              //String subject = "Invoice Generated";
		        	  SendMail sendMail = new SendMail();
		              String body = "PFA This is your payment details . ";
		              //sendMail.sendEmail(toAddresses, body, subject, filename, usrname);
		              System.err.println("Mail sent succesfully by RO = "+toEmail);
		          }
		          else if(roho.equalsIgnoreCase("HO"))
		          {
		        	  //mail to HO Finance (Finance Official of HO) and RM(Regional Manager)
		        	  toEmail = "vishal.vishwakarma@cyfuture.com,animesh.anand@cyfuture.com";
		        	  InternetAddress[] toAddresses  = {  new InternetAddress(FA_approver_email) , new InternetAddress(usermail) ,new InternetAddress("vishal.vishwakarma@cyfuture.com") ,new InternetAddress("animesh.anand@cyfuture.com"),new InternetAddress("saumyadeep@jcimail.in")};
			        	 
		        	  SendMail sendMail = new SendMail();
		             // String subject = "Invoice Generated";
		              String body = "PFA This is your payment details . ";
		              sendMail.sendEmail(toAddresses, body, subject, filename, usrname);
		              System.err.println("Mail sent succesfully by HO = "+toEmail);
		          }
		          else if(roho.equalsIgnoreCase("ZMHO"))
		          {
		        	  //Mail to ZM (jo login kiya h), HO Finance , RM
		        	  toEmail = "vishal.vishwakarma@cyfuture.com,animesh.anand@cyfuture.com";
		        	  InternetAddress[] toAddresses  = {  new InternetAddress(FA_approver_email) , new InternetAddress(usermail) ,new InternetAddress("vishal.vishwakarma@cyfuture.com") ,new InternetAddress("animesh.anand@cyfuture.com"),new InternetAddress("saumyadeep@jcimail.in")};
		        	  SendMail sendMail = new SendMail();
		              //String subject = "Invoice Generated";
		              String body = "PFA This is your payment details . ";
		              sendMail.sendEmail(toAddresses, body, subject, filename, usrname);
		              System.err.println("Mail sent succesfully by ZMHO = "+toEmail);
		          }
	             
		    	 
	            
	    }
	            catch (Exception e)   
		        {  
	            //something wrong to send mail then set status to rmzm and payment status 0 	
	            this.verifyTallySlipService.updatestatustoRMZM(tallyno);
	            System.err.println("Payment process exception in last = "+ e.getLocalizedMessage());
		              e.printStackTrace();  
		              
		         } 
	    	return a;
	    }
	    
		@RequestMapping("deleterolename")
		public ModelAndView deleterolename(HttpServletRequest request,RedirectAttributes redirectAttributes)
		{	 
			String username =(String)request.getSession().getAttribute("usrname");
			if(username == null) {
	     	return new ModelAndView("index");
        }
			
			ModelAndView mv = new ModelAndView("viewuserrole");
			String roelname = request.getParameter("rolename");
		    this.userroleService.deleteUserName(roelname);
		    final List<UserRoleModel> alluserroleList = (List<UserRoleModel>)this.userroleService.getAll();
			 mv.addObject("userroleList", (Object)alluserroleList);
			
			return mv;
		}

		/*
		 * @RequestMapping("logout") public void logoutSession(HttpServletRequest
		 * request, HttpServletResponse resp) throws IOException { HttpSession session =
		 * request.getSession(false); if (null != session) { //
		 * System.out.println("Session id : newtradeaction : "+session.getId()); if
		 * (null != session.getAttribute("usrname")) { session.setAttribute("usrname",
		 * null); session.removeAttribute("usrname"); } } //
		 * System.out.println("logoutsuccessfully.....!");
		 * resp.sendRedirect("index.obj"); }
		 */
		 @ResponseBody
		    @RequestMapping(value = { "getuserrole" }, method = { RequestMethod.GET })
		    public String getuserrole(final HttpServletRequest request) {
		       List<String> result = new ArrayList<String>();
		        final Gson gson = new Gson();
		        result = (List<String>)this.userroleService.getuserrole(request.getParameter("user_type")) ;
		        return gson.toJson((Object)result);
		       
		    }

		   @ResponseBody
	        @RequestMapping(value = { "setFaStatus" }, method = { RequestMethod.GET })
	        public String setFaStatus(final HttpServletRequest request) {
	            final Gson gson = new Gson();
	            String tno =  request.getParameter("tallyno");
	            this.verifyTallySlipService.updatefastatus(tno);
	            return gson.toJson((Object)tno);
	        }



         @RequestMapping(value="popupimage")
         public ModelAndView popupimage(HttpServletRequest request, HttpSession session,RedirectAttributes red) {
        	 String username =(String)request.getSession().getAttribute("usrname");
        	 ModelAndView mv = new ModelAndView("popupimage");
        	 if(username == null) {
                 return new ModelAndView("index");
                }
        	 String pagename = "popupimage";
             int i = checkprivileges(pagename);
             if(i != 1)
             {
             	 red.addFlashAttribute("errorMessage","Access denied");
     			   return mv=new ModelAndView("Home");
             }
               String key = LoginController.secretkey;
        	   String tallyNo = request.getParameter("tallyno");
               String farmerno = request.getParameter("farmerno");
               //String tallyNo = String.valueOf(Encry.decrypt(decryptedtallyNo, key));
               //String farmerno = String.valueOf(Encry.decrypt(decryptedfarmerno, key));
               
               session.setAttribute("farmerno", farmerno);
              // String farmerno1 =(String)request.getSession().getAttribute("farmerno");
               final List<ImageVerificationModel> images= (List<ImageVerificationModel>)verifyTallySlipService.getImages(tallyNo);
               mv.addObject("images",(Object) images);
               return mv;
         }






          @ResponseBody
          @RequestMapping(value = { "setStatusRMZM" }, method = { RequestMethod.GET })
          public String setStatusRMZM(final HttpServletRequest request) {
              final Gson gson = new Gson();
              String s="success";
              this.verifyTallySlipService.statusrmzm();
              return gson.toJson((Object)s);
          }

         @RequestMapping({ "viewVerifiedTallySlipList_RM" })
         public ModelAndView viewVerifiedTallySlipListRM(final HttpServletRequest request,RedirectAttributes red) {
            String username =(String)request.getSession().getAttribute("usrname");
            if(username == null) {
                return new ModelAndView("index");
               }
             String region =(String)request.getSession().getAttribute("regionId");
             ModelAndView mv = new ModelAndView("verifiedTallySlipList_RM");
             final List<VerifyTallySlip> verifyList = (List<VerifyTallySlip>)this.verifyTallySlipService.getAllforRM("RMZM", region);
             mv.addObject("verifiedTallyforRM", (Object)verifyList);
             try {
              	String userRole= (String)request.getSession().getAttribute("rolename");
                		   		   if("RO Operation".equals(userRole) || "DPC JI".equals(userRole)|| "OM FINANACE".equals(userRole) || "HO Finance".equals(userRole) || "HO Operation".equals(userRole) || "Mill user".equals(userRole)|| "RO Finance".equals(userRole) || "DPC JI".equals(userRole) || "DPC Manager Web".equals(userRole) || "Data Entry Operator".equals(userRole) ) {
                			 red.addFlashAttribute("errorMessage","Access denied");
                			   return mv=new ModelAndView("index");
                		   }
                		   		   }
                  catch(Exception e) {
                   		   e.printStackTrace();
                   	   }
             return mv;
         }
             

           @RequestMapping({ "viewVerifiedTallySlipList_ZM" })
           public ModelAndView viewVerifiedTallySlipListZM(final HttpServletRequest request,RedirectAttributes red) {
              String username =(String)request.getSession().getAttribute("usrname");
              ModelAndView mv = new ModelAndView("verifiedTallySlipList_ZM");
              if(username == null) {
                 return new ModelAndView("index");
                 }
              String pagename = "viewVerifiedTallySlipList_ZM";
              int i = checkprivileges(pagename);
              if(i != 1)
              {
              	 red.addFlashAttribute("errorMessage","Access denied");
      			   return mv=new ModelAndView("Home");
              }
               String region_zone =(String)request.getSession().getAttribute("zoneId");
               final List<VerifyTallySlip> verifyList = (List<VerifyTallySlip>)this.verifyTallySlipService.getAllforZM("RMZM", region_zone);
               mv.addObject("verifiedTallyforZM", (Object)verifyList);
               return mv;
           }
           @ResponseBody
           @RequestMapping(value = { "check_password" }, method = { RequestMethod.GET })
           public boolean check_password(final HttpServletRequest request) {
               final Gson gson = new Gson();
               String pass = request.getParameter("pass");
           System.out.println("pass  = "+pass);
               return false;
           }
           
           
           @RequestMapping({ "uploadexcelsheet" })
           public ModelAndView uploadexcelsheet(final HttpServletRequest request, RedirectAttributes red) {
              String username =(String)request.getSession().getAttribute("usrname");
              if(username == null) {
                 return new ModelAndView("index");
                 }
               ModelAndView mv = new ModelAndView("uploadexcelsheet");
               String pagename = "uploadexcelsheet";
               int i = checkprivileges(pagename);
               if(i != 1)
               {
               	 red.addFlashAttribute("errorMessage","Access denied");
       			   return mv=new ModelAndView("Home");
               }
               return mv;
           }
           
           @RequestMapping({ "uploadexcel" })
           public ModelAndView uploadexcel(final HttpServletRequest request, final RedirectAttributes redirectAttributes , @RequestParam("excelsheet") final MultipartFile excelsheet) throws EncryptedDocumentException, InvalidFormatException {
        	  // File file = null;
        	   ModelAndView mv = new ModelAndView("uploadexcelsheet");
        	   try (Workbook workbook = WorkbookFactory.create(excelsheet.getInputStream())){
        		   Sheet sheet = workbook.getSheetAt(0);
        		   int i = 1;
        		   int rowCount = sheet.getLastRowNum();
        		   System.out.println("rowcount"+rowCount);
        		   FormulaEvaluator formulaEvaluator=workbook.getCreationHelper().createFormulaEvaluator();  
        		   String[] tally;
        		   String tallyno ;
        		   for(i = 1; i < rowCount+1; i++)
          		 {
        			   try {
	          			   Row row = sheet.getRow(i);
	          			   Cell cell=row.getCell(7); 
	          			   String jciref = cell.getStringCellValue();
	          			   
	          			   cell=row.getCell(11); 
	          			   Integer utrno1 =(int) cell.getNumericCellValue();
	          			   String utrno =""+utrno1;
	          			   
	          			   cell=row.getCell(12); 
	          			   String strdate = "";
	                          int cellType = cell.getCellType();
	                          if (cellType == Cell.CELL_TYPE_STRING)
	                          {
	                        	  // It's a String cell
	                        	  strdate = cell.getStringCellValue();
	                          }
	                          else if (cellType == Cell.CELL_TYPE_NUMERIC) 
	                          {
	                              if (DateUtil.isCellDateFormatted(cell)) 
	                              {
	                                  // It's a date cell
	                            	  Date date = cell.getDateCellValue();
	                                  SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
	                                  strdate = dateFormat.format(date);
	                              } 
	                              else {
	                                  // It's a numeric cell
	                                  strdate = String.valueOf(cell.getNumericCellValue());
	                              }
	                          }
	          			   //DateFormat outputDateFormat = new SimpleDateFormat("dd-MM-yyyy");
	          	           //String strdate = outputDateFormat.parse(date);
	          	         //System.err.println("Date333333333"+date);
	                       //System.out.println(" jciref = "+ jciref +" utrno = "+ utrno  +" date = "+  strdate);
	                       
	                       verifyTallySlipService.updateexceldata(jciref,utrno,strdate);
	                       tally = jciref.split("-");
	                       tallyno = tally[1];
	                       //System.out.println("tallyno========="+tallyno);
	                       verifyTallySlipService.updatestatusPD(tallyno);

        			   }
        			   catch(Exception e)
        			   {
        				   System.out.println("error in catch field-________"+e);
        				   mv.addObject("msg", (Object)"<div class=\"alert alert-danger\"><b>OOps!</b> Date formate should be dd/mm/yyyy and UTR NO should be Number in excel file</div>\r\n");
        				   return mv;        			   }

          		    }  
               }
             
                   catch (IOException e)
        	   {
                   e.printStackTrace();
               } 
			   mv.addObject("msg", (Object)"<div class=\"alert alert-success\"><b>Success !</b> Excel Uploaded successfully.</div>\r\n");

			   return mv;
           
           }
           
    static {
        InsertDataController.count = 0;
        InsertDataController.logger = LogManager.getLogger((Class)InsertDataController.class);
    }
    
    
    
    //edit farmer Animesh merged from Jyoti code
    
    
    @RequestMapping(value = { "editFarmerDetails" }, method = { RequestMethod.GET })
    public ModelAndView editFarmerDetails(final HttpServletRequest request , RedirectAttributes red) {
      String username =(String)request.getSession().getAttribute("usrname");
        ModelAndView mv = new ModelAndView("editFarmerDetails");
        if(username == null) {
             return mv = new ModelAndView("index");
            }
        String pagename = "editFarmerDetails";
        int i = checkprivileges(pagename);
        if(i != 1)
        {
        	 red.addFlashAttribute("errorMessage","Access denied");
			   return mv=new ModelAndView("Home");
        }
        try {
        if (request.getParameter("id") != null) {

            final List<PincodeModel> pincodeList = (List<PincodeModel>)this.pincodeService.getAll();
            final List<StateList> Liststate = (List<StateList>)this.stateList.getAll();
            final List<DistrictModel> DistrictList = (List<DistrictModel>)this.distric.getAll();
          
            String key = LoginController.secretkey;
        	String decryptedString = request.getParameter("id");
        	final int id = Integer.parseInt(Encry.decrypt(decryptedString, key));
            final List<FarmerRegModel> farmerDetailsById = this.farmerRegService.findDetails(id);      
            mv.addObject("Liststate", (Object)Liststate);
            mv.addObject("pincodeList", (Object)pincodeList);
            mv.addObject("DistrictList", (Object)DistrictList);
            mv.addObject("isverified", (Object)request.getParameter("isverified"));
            mv.addObject("farmerDetailsById", (Object)farmerDetailsById);
        }
        }
        catch(Exception e) {
             e.printStackTrace();
        }
        return mv;
    }

    @RequestMapping(value = { "updateFarmerDetails" })
    public ModelAndView updateFarmerDetails(final HttpServletRequest request, final RedirectAttributes redirectAttributes, @RequestParam("F_ID_PROF") final MultipartFile F_ID_PROF, @RequestParam("F_BANK_DOC") final MultipartFile F_BANK_DOC, @RequestParam("F_REG_FORM") final MultipartFile F_REG_FORM) {
      String username =(String)request.getSession().getAttribute("usrname");
       if(username == null) {
            return new ModelAndView("index");
            }
       final File theDir = new File("E:\\Program Files\\Apache Software Foundation\\Tomcat 8.5\\webapps\\FarmerRegistration\\");
       if (!theDir.exists()) {
           theDir.mkdirs();
       }
       final ModelAndView mv = new ModelAndView();
       try {
             String dpc= (String)request.getSession().getAttribute("dpcId");
             final int id = Integer.parseInt(request.getParameter("id"));
             String f_reg_no = farmerRegService.getFarmerNo(id);
             List<FarmerRegModel> details = farmerRegService.findDetails(id);
             FarmerRegModel fullDetails = details.get(0);
           final String F_NAME = request.getParameter("F_NAME");
           final String M_NAME = request.getParameter("M_NAME");
           final String L_NAME = request.getParameter("L_NAME");
           String farmerName="";
           String mname = "";
           String lname = "";
           final String fname = F_NAME.replaceAll("\\s", "");
           if(!fname.equalsIgnoreCase("") && fname != null)
           farmerName = fname;
           
           if ((M_NAME.isEmpty()) && (!L_NAME.isEmpty())) {
               lname = L_NAME.replaceAll("\\s", "");
               if(!lname.equalsIgnoreCase(""))
               farmerName = farmerName + " "+"NA"+" " + lname;
           }
           else if ((!M_NAME.isEmpty()) && (!L_NAME.isEmpty())) {
               mname = M_NAME.replaceAll("\\s", "");
               lname = L_NAME.replaceAll("\\s", "");
               if(!mname.equalsIgnoreCase(""))
               farmerName = farmerName + " " + mname;
               if(!lname.equalsIgnoreCase(""))
                   farmerName = farmerName + " " + lname;
           }
           else if (!M_NAME.isEmpty() && L_NAME.isEmpty()) {
               mname = M_NAME.replaceAll("\\s", "");
               if(!mname.equalsIgnoreCase(""))
               farmerName = farmerName + " " + mname;
           }
           else if ((M_NAME.isEmpty()) && (L_NAME.isEmpty()) && (!F_NAME.isEmpty()))  {
             if(!fname.equalsIgnoreCase(""))
               farmerName = fname;
           }
           final String caste = request.getParameter("caste");
           final String gender = request.getParameter("gender");
           final String F_ADDRESS = request.getParameter("F_ADDRESS");
           final String F_ID_PROF_TYPE = request.getParameter("F_ID_PROF_TYPE");
           final String F_ID_PROF_NO = request.getParameter("F_ID_PROF_No");
           final String F_REG_BY = request.getParameter("F_REG_BY");
           final String F_I_CARE_REGISTERED = request.getParameter("F_I_CARE_REGISTERED");
           final String land_holding = request.getParameter("land_holding");
           final String F_MOBILE = request.getParameter("F_MOBILE");
           final String state = request.getParameter("state");
           final String F_District = request.getParameter("F_District");
          // System.out.print(" ...................." + F_District);
           final String F_Block = request.getParameter("F_Block");
           final String F_Pincode = request.getParameter("pincode");
           final String police_station = request.getParameter("policestation");
         //  System.out.print(" ...................." + police_station);
           final String F_AC_NO = request.getParameter("F_AC_NO");
           final String bank_ac_type = request.getParameter("bank_ac_type");
           final String F_BANK_NAME = request.getParameter("F_BANK_NAME");
           final String F_BANK_BRANCH = request.getParameter("F_BANK_BRANCH");
           final String F_BANK_IFSC = request.getParameter("F_BANK_IFSC");
           final String F_Address2 = request.getParameter("F_Address2");
           final String duplicateMobiileNo = request.getParameter("dubMobile");
           final boolean duplicateMobiile = Boolean.parseBoolean(duplicateMobiileNo);
           final String fileUpload = F_ID_PROF.getOriginalFilename();
           final String duplicateAccNo = request.getParameter("accNoCheck");
           
           if(isStringValid(F_NAME) || isStringValid(M_NAME) || isStringValid(L_NAME) ||isStringValid(caste) || isStringValid(gender)
                   ||isStringValid(F_ADDRESS) || isStringValid(F_ID_PROF_TYPE) || isStringValid(F_ID_PROF_NO) ||isStringValid(F_REG_BY)
                   || isStringValid(F_I_CARE_REGISTERED) || isStringValid(land_holding)|| isStringValid(F_MOBILE) || isStringValid(state)
                   ||isStringValid(F_District) || isStringValid(F_Block) || isStringValid(F_Pincode) || isStringValid(police_station)
                   || isStringValid(F_AC_NO) || isStringValid(bank_ac_type) ||isStringValid(F_BANK_NAME) || isStringValid(F_BANK_BRANCH)
                   ||isStringValid(F_BANK_IFSC) || isStringValid(duplicateMobiileNo) ||isStringValid(fileUpload)
                   ||isStringValid(duplicateAccNo))
 		            {
 		              redirectAttributes.addFlashAttribute("msg", (Object)"<div class=\"alert alert-danger\"><b>Allowed only Alphabates and Numbers!</b> </div>\r\n");
 		              return new ModelAndView((View)new RedirectView("ViewFarmerRegistration.obj"));
 		            }
           final boolean accountBool = Boolean.parseBoolean(duplicateAccNo);
           final String F_BANK_DOCupload = F_BANK_DOC.getOriginalFilename();
           String checkfilename = "(?i).+\\.(jpg|jpeg|png)$";
           final String b_doc = request.getParameter("BANK_DOC");
           final String id_proof = request.getParameter("ID_PROF");
           final String reg_form = request.getParameter("REG_FORM");
           
           
           if(!b_doc.matches(checkfilename) || !id_proof.matches(checkfilename) ||!reg_form.matches(checkfilename))
           {
             redirectAttributes.addFlashAttribute("msg", (Object)"<div class=\"alert alert-danger\"><b>Allowed only jpg, jpeg and png files!</b> </div>\r\n");
             return new ModelAndView((View)new RedirectView("ViewFarmerRegistration.obj"));
           }
           final FarmerRegModel farmerRegModel = new FarmerRegModel();
           farmerRegModel.setF_ID(id);
           farmerRegModel.setF_NAME(farmerName);
           farmerRegModel.setCaste(caste);
           farmerRegModel.setGender(gender);
           farmerRegModel.setF_ADDRESS(F_ADDRESS);
           farmerRegModel.setF_ID_PROF_TYPE(F_ID_PROF_TYPE);
           farmerRegModel.setBank_ac_type(bank_ac_type);
           farmerRegModel.setF_ID_PROF_NO(F_ID_PROF_NO);
           farmerRegModel.setF_UPDATE_DATE(new Date());
           farmerRegModel.setF_I_CARE_REGISTERED(F_I_CARE_REGISTERED);
           farmerRegModel.setLand_holding(land_holding);
           farmerRegModel.setF_MOBILE(F_MOBILE);
           farmerRegModel.setF_AC_NO(F_AC_NO);
           farmerRegModel.setF_Pincode(F_Pincode);
           farmerRegModel.setF_STATE(state);
           farmerRegModel.setF_Block(F_Block);
           farmerRegModel.setF_District(F_District);
           farmerRegModel.setPolice_station(police_station);
           farmerRegModel.setBank_ac_type(bank_ac_type);
           farmerRegModel.setF_BANK_NAME(F_BANK_NAME);
           farmerRegModel.setF_BANK_BRANCH(F_BANK_BRANCH);
           farmerRegModel.setF_BANK_IFSC(F_BANK_IFSC);
           farmerRegModel.setF_Address2(F_Address2);
           farmerRegModel.setF_Pincode(F_Pincode);
           farmerRegModel.setIS_VERIFIED(fullDetails.getIS_VERIFIED());
           farmerRegModel.setF_REG_BY(fullDetails.getF_REG_BY());
           int verified = fullDetails.getIS_VERIFIED();
           if(verified == 1) {
        	   farmerRegModel.setF_DOC_Mandate(fullDetails.getF_DOC_Mandate());
           }
           farmerRegModel.setDpc_id(fullDetails.getDpc_id());            
           farmerRegModel.setF_REG_NO(f_reg_no);
           File file = null;
           String pathurl = "";
           try {
               String url = "";
               if (!F_BANK_DOC.isEmpty()) {
                   file = new File("E:\\Program Files\\Apache Software Foundation\\Tomcat 8.5\\webapps\\FarmerRegistration\\bankdoc_" +farmerRegModel.getF_REG_NO()+"_"+ F_BANK_DOC.getOriginalFilename());
                   try {
                       final OutputStream os = new FileOutputStream(file);
                       os.write(F_BANK_DOC.getBytes());
                       os.close();
                   }
                   catch (Exception e) {
                       System.out.println(e.getLocalizedMessage());
                       e.printStackTrace();
                   }
                   pathurl = file.getAbsolutePath();
                   final String path = url = "bankdoc_" +farmerRegModel.getF_REG_NO()+"_"+ F_BANK_DOC.getOriginalFilename();
                   //System.out.println("F_BANK_DOC =========    "+path);
                   farmerRegModel.setF_BANK_DOC(url);
               }
            
               else if(b_doc != null) {
                     farmerRegModel.setF_BANK_DOC(b_doc);
               }
               if (!F_ID_PROF.isEmpty()) {
                   file = new File("E:\\Program Files\\Apache Software Foundation\\Tomcat 8.5\\webapps\\FarmerRegistration\\idproof_" +farmerRegModel.getF_REG_NO()+"_"+ F_ID_PROF.getOriginalFilename());
                   try {
                       final OutputStream os = new FileOutputStream(file);
                       os.write(F_ID_PROF.getBytes());
                       os.close();
                   }
                   catch (Exception e) {
                       e.printStackTrace();
                   }
                   pathurl = file.getAbsolutePath();
                   final String path = url = "idproof_" +farmerRegModel.getF_REG_NO()+"_"+ F_ID_PROF.getOriginalFilename();
                   //System.out.println("F_ID_PROF =========    "+path);
                   farmerRegModel.setF_ID_PROF(url);
               }else if(id_proof != null) {
                     farmerRegModel.setF_ID_PROF(id_proof);
               }
               if (!F_REG_FORM.isEmpty()) {
                   file = new File("E:\\Program Files\\Apache Software Foundation\\Tomcat 8.5\\webapps\\FarmerRegistration\\regform_" +farmerRegModel.getF_REG_NO()+"_"+ F_REG_FORM.getOriginalFilename());
                   try {
                       final OutputStream os = new FileOutputStream(file);
                       os.write(F_REG_FORM.getBytes());
                       os.close();
                   }
                   catch (Exception e) {
                       e.printStackTrace();
                   }
                   
                   pathurl = file.getAbsolutePath();
                   final String path = url = "regform_" +farmerRegModel.getF_REG_NO()+"_"+ F_REG_FORM.getOriginalFilename();
                  // System.out.println("F_REG_FORM =========    "+path);
                   farmerRegModel.setF_REG_FORM(url);
                  
               }
               else if(reg_form != null) {
                     farmerRegModel.setF_REG_FORM(reg_form);
               }
           }
           catch (Exception e2) {
               System.out.println(e2);
               mv.addObject("msg", (Object)"Not Save please try again");
           }
         
        //   System.out.println("session dpc =" + dpcid + " region = " + region);
          
               this.farmerRegService.update(farmerRegModel);
               redirectAttributes.addFlashAttribute("msg", (Object)"<div class=\"alert alert-success\"><b>Success !</b> Record updated successfully.</div>\r\n");
           
           
       }
       catch (Exception e3) {
           System.out.println(e3);
           redirectAttributes.addFlashAttribute("msg", (Object)"<div class=\"alert alert-danger\"><b>Oops !</b> Error in updating record. Please try again</div>\r\n");
       }
      
       return new ModelAndView((View)new RedirectView("ViewFarmerRegistration.obj"));
   }
    
	    @ResponseBody
	    @RequestMapping(value = { "setholdstatus" }, method = { RequestMethod.GET })
	    public String setholdstatus(final HttpServletRequest request) {
	        final Gson gson = new Gson();
	        String tno =  request.getParameter("tallyno");
	        String status = request.getParameter("status");
	        String placeofp = request.getParameter("placeofp");
	        this.verifyTallySlipService.setholdstatus(tno,status,placeofp);
	        return gson.toJson((Object)tno);
	    }
	    
	    
	    @RequestMapping({ "verifiedHoldTallySlipList" })
        public ModelAndView verifiedHoldTallySlipList(final HttpServletRequest request, RedirectAttributes red) {
           String username =(String)request.getSession().getAttribute("usrname");
           ModelAndView mv = new ModelAndView("verifiedHoldTallySlipList");
           if(username == null)
           {
               return mv = new ModelAndView("index");
           }
           String pagename = "verifiedHoldTallySlipList";
           int i = checkprivileges(pagename);
           if(i != 1)
           {
           	 red.addFlashAttribute("errorMessage","Access denied");
   			   return mv=new ModelAndView("Home");
           }
           try {
        	String role_type = (String)request.getSession().getAttribute("roletype");
            String region =(String)request.getSession().getAttribute("region"); 
            final List<VerifyTallySlip> verifyList = (List<VerifyTallySlip>)this.verifyTallySlipService.getAllHold(region, role_type);
            mv.addObject("verifyHoldTallySliList", (Object)verifyList);   
           } 
           catch(Exception e) {
        	   e.printStackTrace();
           }
            return mv;
        }

	    
	    

	    @RequestMapping(value = { "findByDpc" })
	    public ModelAndView findByDistrict(final HttpServletRequest request, final RedirectAttributes redirectAttributes) {
	    	String username =(String)request.getSession().getAttribute("usrname");
	    	ModelAndView mv = new ModelAndView("ViewFarmerRegistration");
	    	 if(username == null) {
	         	return new ModelAndView("index");
	             }
	        try {
	            final String dpc = request.getParameter("dpc");
	            final List<FarmerRegModelDTO> allFarmersList = (List<FarmerRegModelDTO>)this.farmerRegService.findByDpc(dpc);
	                final List<ZoneModel> zoneList = (List<ZoneModel>)this.zoneService.getAll();
	                mv.addObject("zoneList", (Object)zoneList);
	               mv.addObject("allFarmersList", (Object)allFarmersList);
	           
	        }
	        catch (Exception e) {
	            System.out.println(e.getLocalizedMessage());
	        }
	         
	        return mv;
	    }
	    
	    
	    @RequestMapping(value = { "getBalesData" })
	    public ModelAndView getBalesData(final HttpServletRequest request, final RedirectAttributes redirectAttributes) {
	    	String username =(String)request.getSession().getAttribute("usrname");
	    	ModelAndView mv = new ModelAndView("viewbalePreparation");
	    	 if(username == null) {
	         	return new ModelAndView("index");
	             }
	        try {
	            final String dpc = request.getParameter("dpc");
	            final String fromdate = request.getParameter("fromdate");
	            final String todate = request.getParameter("todate");
	            
	            List<BalePreparation> viewBale = new ArrayList<BalePreparation>();
	    		viewBale = (List<BalePreparation>)this.balePrepareService.getbyFilter(dpc,fromdate,  todate);
	    		final List<ZoneModel> zoneList = (List<ZoneModel>)this.zoneService.getAll();
	            mv.addObject("zoneList", (Object)zoneList);
	            mv.addObject("viewBalePreparation", (Object)viewBale);
	           
	        }
	        catch (Exception e) {
	            System.out.println(e.getLocalizedMessage());
	        }
	         
	        return mv;
	    }
	    @RequestMapping({ "viewmarketArrivalDetails" })
	    public ModelAndView viewmarketArrivalDetails(final HttpServletRequest request, RedirectAttributes red) {
	    	String username =(String)request.getSession().getAttribute("usrname");
	        ModelAndView mv = new ModelAndView("DetailsMarketArrival");
	        if(username == null) {
	        	return mv = new ModelAndView("index");
	            }
	        
	        String pagename = "viewmarketArrivalDetails";
	        int i = checkprivileges(pagename);
	        if(i != 1)
	        {
	        	 red.addFlashAttribute("errorMessage","Access denied");
				   return mv=new ModelAndView("Home");
	        }
	        try {
	        String key = LoginController.secretkey;
			String decryptedString = request.getParameter("id");
			final int id = Integer.parseInt(Encry.decrypt(decryptedString, key));	
	        final MarketArrivalModel marketArrival = (MarketArrivalModel)this.marketArrivalService.getAlldetails(id);
	        mv.addObject("marketArrival", (Object)marketArrival);
	        }
	        catch(Exception e) {
	        	e.printStackTrace();
	        }
	        return mv;
	    }
	    @ResponseBody
	    @RequestMapping({ "findDpcname" })
	    public String findDpcname(final HttpServletRequest request) {
	    	String dpccode = request.getParameter("dpccode");
	        final Gson gson = new Gson();
	        return gson.toJson((Object)this.purchaseCenterService.findDpcname(dpccode));
	    }
	    
	    
	    @ResponseBody
		@RequestMapping(value="checksessionpass", method= RequestMethod.GET)
			public  String checksessionpass() {
	    	String email =(String)request.getSession().getAttribute("usrname");
	    	String flagvalue = userRegService.checkConcurrentlogin(email);
			final Gson gson = new Gson();
	        return gson.toJson((Object)flagvalue);
			
		}
	    
	    @RequestMapping({ "downloadexcel" })
        public ModelAndView downloadexcel(final HttpServletRequest request, RedirectAttributes red) {
           String username =(String)request.getSession().getAttribute("usrname");
           ModelAndView mv = new ModelAndView("downloadAllExcelSheet");
           if(username == null)
              {
                  return mv = new ModelAndView("index");
              }
           try 
           {
        	   String pagename = "downloadexcel";
   	        int i = checkprivileges(pagename);
   	        if(i != 1)
   	        {
   	        	 red.addFlashAttribute("errorMessage","Access denied");
   				   return mv=new ModelAndView("Home");
   	        } 
        	   
           } 
           catch(Exception e) {
        	   e.printStackTrace();
           }
            return mv;
        }
	    
	    @RequestMapping(value = { "downloadexcels" }, method = { RequestMethod.GET })
	    public ResponseEntity<byte[]> downloadExcelFile() throws IOException {
	        String EXCEL_FOLDER_PATH = "E:/Program Files/Apache Software Foundation/Tomcat 8.5/webapps/TallySlipPayments";
	       // String EXCEL_FOLDER_PATH = "D:/JCI/AllExcel";


	       String fileName =  request.getParameter("filename");
	        File excelFile = new File(EXCEL_FOLDER_PATH, fileName);

	        // Set up HTTP headers for the response
	        HttpHeaders headers = new HttpHeaders();
	        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
	        headers.setContentDispositionFormData("attachment", fileName);

	        // Convert the Excel file to a byte array
	        byte[] excelBytes = FileUtils.readFileToByteArray(excelFile);

	        return new ResponseEntity<>(excelBytes, headers, org.springframework.http.HttpStatus.OK);
	    }
	    @RequestMapping({ "PurchaseRegisterlist" })
	    public ModelAndView PurchaseRegisterlist(final HttpServletRequest request,RedirectAttributes red) {
	    	String username =(String)request.getSession().getAttribute("usrname");
	    	String regionid =(String)request.getSession().getAttribute("regionId");
	    	ModelAndView mv = new ModelAndView("PurchaseRegisterList");
	    	if(username == null) {
	        	return new ModelAndView("index");
	            }
	    	Map<String,String> dpcnameid = new HashMap<String, String>();
	    	dpcnameid = purchaseCenterService.getdpcbyregionid(regionid);
	    	List<RoDetailsModel> Regions = roService.getAll();
	       // final List<PurchaseRegisterDTO> purchaselist = (List<PurchaseRegisterDTO>)this.verifyTallySlipService.getAllPurchase();
	        //mv.addObject("dpcnameid",(Object)dpcnameid);
	        mv.addObject("Regions",(Object)Regions);
	        return mv;
	    }
	    
	    @RequestMapping({ "purchaseslisting" })
	    public ModelAndView purchaseslisting(final HttpServletRequest request,HttpServletResponse response,final RedirectAttributes redirectAttributes) throws ParseException, IOException {
	    	String cropyear = request.getParameter("cropyear");
	    	String Placeofp = request.getParameter("dpc");
	    	String basis = request.getParameter("basis");
	    	String pdateFrom = request.getParameter("purchasesdatefrom");
	    	String pdateTo = request.getParameter("purchasesdateto");
	    	SimpleDateFormat sdfInput = new SimpleDateFormat("yyyy-MM-dd");
	        Date date = sdfInput.parse(pdateFrom);
	        Date date1 = sdfInput.parse(pdateTo);
		    DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		    String purchasesdateFrom = formatter.format(date);
		    String purchasesdateTo = formatter.format(date1);
	    	ModelAndView mv = new ModelAndView("PurchaseRegisterList");

	        final List<PurchaseRegisterDTO> purchaselist = (List<PurchaseRegisterDTO>)this.verifyTallySlipService.getAllPurchase(cropyear,Placeofp,basis,purchasesdateFrom,purchasesdateTo);

	    	if(purchaselist ==null)
	    	{
                redirectAttributes.addFlashAttribute("msg", (Object)"<div class=\"alert alert-danger\"><b> Data Not Found !!!!</b></div>\r\n");
                return new ModelAndView((View)new RedirectView("PurchaseRegisterlist.obj"));
	    	}
	    	response.setContentType("application/pdf");
	        response.setHeader("Content-Disposition", "attachment; filename=Purchase Report.pdf");

	        try {
	            Document document = new Document(PageSize.A2);
	            PdfWriter.getInstance(document, response.getOutputStream());
	            document.open();
	            Date date2 = new Date();
	            DateFormat formatter1 = new SimpleDateFormat("dd-MM-yyyy");
			    String dateforreport = formatter1.format(date2);
	           
	            Paragraph heading = new Paragraph("Purchase Register Report "+dateforreport);
	            heading.setAlignment(Element.ALIGN_CENTER);
	            document.add(heading);
	            document.add(Chunk.NEWLINE);	            // Sample list of models

	            // Create PDF table with 10 columns
	            PdfPTable table = new PdfPTable(15);

	            table.setWidthPercentage(100);
	           // table.setWidths(new float[]{100f, 100f, 100f, 100f, 100f, 100f, 100f, 100f, 100f, 100f});
	            // Add table headers
	            //addTableHeader(table);
	            table.addCell(createCell("Farmer name", 40f));
	            table.addCell(createCell("Farmer no", 40f));
	            table.addCell(createCell("Tally slip", 40f));
	            table.addCell(createCell("Rate slip", 40f));
	            table.addCell(createCell("Tally status", 40f));
	            table.addCell(createCell("Purchase date", 40f));
	            table.addCell(createCell("Place of purchases", 40f));
	            table.addCell(createCell("Jute verity", 40f));
	            table.addCell(createCell("Gross quentity", 40f));
	            table.addCell(createCell("Deduction quentity", 40f));
	            table.addCell(createCell("Net quentity", 40f));
	            table.addCell(createCell("Amount", 40f));
	            table.addCell(createCell("Garset rate", 40f));
	            table.addCell(createCell("Bin no", 40f));
	            table.addCell(createCell("Region", 40f));

	            // Add model data to the table
	            for (PurchaseRegisterDTO list : purchaselist) {
	                //addRow(table, model);
	            	table.addCell(list.getF_name());
	            	table.addCell(list.getFarmerregno());
	            	table.addCell(list.getTallyslipno());
	            	table.addCell(String.valueOf(list.getRate_slipno()));
	            	table.addCell(list.getTally_status());
	                table.addCell(list.getDatepurchase());
		            table.addCell(list.getCentername());
		            table.addCell(list.getJutevariety());
		            table.addCell(String.valueOf(list.getGross_qty()));
		            table.addCell(String.valueOf(list.getDeduc_qty()));
		            table.addCell(String.valueOf(list.getNet_qty()));
		            table.addCell(String.valueOf(list.getAmountpayable()));
		            table.addCell(String.valueOf(list.getGarsat()));
		            table.addCell(String.valueOf(list.getBinno()));
		            table.addCell(list.getRegionId());
	            }

	            document.add(table);
	            document.close();
	        } catch (DocumentException e) {
	            e.printStackTrace();
	        }
	        return mv;
	    }
	    private static PdfPCell createCell(String content, float height) {
	        PdfPCell cell = new PdfPCell();
	        cell.setFixedHeight(height);
	        // Apply regular font to the content
	        Paragraph paragraph = new Paragraph(content);
	        cell.addElement(paragraph);

	        return cell;
	    }
}