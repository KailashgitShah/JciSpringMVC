
package com.jci.controller;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;

import com.jci.model.FarmerRegModel;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import com.jci.model.PaymentInstrumentModel;
import com.jci.model.PurchaseReportDTO;
import com.jci.model.RoDetailsModel;
import com.jci.model.UploadingReceiptModel;
import com.jci.model.UserActionModel;
import com.jci.model.UserPriviligeModel;
import com.jci.model.UserRoleModel;
import com.jci.model.ZoneModel;
import com.jci.model.labelGenerationModel;
import com.jci.service.DailyPurchaseModelConfService;
import com.jci.service.EntryofsaleService;
import com.jci.service.HoDispatchService;
import com.jci.service.PaymentInstrumentService;
import com.jci.service.PurchaseCenterService;
import com.jci.service.PurchaseReportService;
import com.jci.service.RawJuteProcurementAndPaymentService;
import com.jci.service.RoDetailsService;
import com.jci.service.UploadRecieptService;
import com.jci.service.UserActionService;
import com.jci.service.UserPriviligeService;
import com.jci.service.UserRoleService;
import com.jci.service.ZoneService;
import com.jci.service.labelGenerationService;
import com.lowagie.text.Element;
import com.lowagie.text.pdf.PdfPCell;

import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.engine.export.JRPdfExporterParameter;

import com.google.gson.Gson;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.layout.element.Paragraph;
import com.jci.model.DailyReportDTO;
import com.jci.model.EntryofSaleModel;
import com.jci.model.FarmerRegistrationModel;
import com.jci.model.HODispatchInstructionModel;
import com.jci.model.LedgerReportDTO;
import com.jci.model.EntryofpcsoModel;

@Controller
public class InsertDataController_2 {
	
	@Autowired
	private PaymentInstrumentService paymentinstrumentservice;
	
	@Autowired
	private HoDispatchService hodispatchservice;
	
	@Autowired
	private HttpServletRequest request;
	
	@Autowired
	RoDetailsService roService;
	
	@Autowired
    PurchaseCenterService purchaseCenterService;
	
	@Autowired
	ZoneService zoneService;
	
	@Autowired
	EntryofsaleService entryofsaleservice;

	@Autowired
	UploadRecieptService uploadrecieptservice;
	
	@Autowired
	UserRoleService userroleService;
	
	@Autowired
	UserActionService useractionservice;
	
	@Autowired
	UserPriviligeService userpriviligeservice;
	
	@Autowired
	PurchaseReportService purchaseReportService;
	
	@Autowired
	PurchaseReportService purchasereportService;
	
	@Autowired
	labelGenerationService labelgenerationService;
	
	@Autowired
	DailyPurchaseModelConfService dailyPurchaseModelConfService;
	
	 @Autowired
	 RawJuteProcurementAndPaymentService rawJuteProcurAndPayService;
	 
	 @Autowired
	 InsertDataController insertDataController;
	
	
	 private boolean isStringValid(String input) {
	        String regex = ".*[<>].*";
	        Pattern pattern = Pattern.compile(regex);
	        Matcher matcher = pattern.matcher(input);
	        return matcher.matches();
	    }

	  
	 
	@RequestMapping("userprivilige")
	public ModelAndView userpriviligeModel(HttpServletRequest request,RedirectAttributes red)
	{	String username =(String)request.getSession().getAttribute("usrname");
	    ModelAndView mv = new ModelAndView("userprivilige");
	     if(username == null) {
	     	return mv = new ModelAndView("index");
	         }
	         String pagename = "userprivilige";
	        int i = insertDataController.checkprivileges(pagename);
	        if(i != 1)
	        {
	        	 red.addFlashAttribute("errorMessage","Access denied");
				   return mv=new ModelAndView("Home");
	        }
		 final List<UserRoleModel> alluserroleList = (List<UserRoleModel>)this.userroleService.getAll();
		 mv.addObject("userroleList", (Object)alluserroleList);
		 final List<UserActionModel> alluseractionlist = (List<UserActionModel>)this.useractionservice.getAll();
		 mv.addObject("useractionlist", (Object)alluseractionlist);
		 return mv;
	}
	
	@RequestMapping("saveuserprivilige")  
	
	public ModelAndView saveuserprivilige(HttpServletRequest request, RedirectAttributes redirectAttributes)
	{			String username =(String)request.getSession().getAttribute("usrname");
		try {
			String userrole = request.getParameter("userrole");
			String useraction = request.getParameter("action");
			if(isStringValid(userrole) || isStringValid(useraction))
			  {
			    redirectAttributes.addFlashAttribute("msg", (Object)"<div class=\"alert alert-danger\"><b>Allowed only Alphabates and Numbers!</b> </div>\r\n");
			    return new ModelAndView((View)new RedirectView("userprivilige.obj"));
			  }
			UserPriviligeModel userprivilige = new UserPriviligeModel();
			userprivilige.setRole_Id(userrole);
			userprivilige.setAction_permissions(useraction);
			Date d2 = new Date();
			SimpleDateFormat dd = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
			String formattedDate1 = dd.format(d2);
			userprivilige.setCreated_date(formattedDate1);
			this.userpriviligeservice.create(userprivilige);
			redirectAttributes.addFlashAttribute("msg",
						"<div class=\"alert alert-success\"><b>Success !</b> Record created successfully.</div>\r\n"
								+ "");
	
		} catch (Exception e)
		{
			//System.out.println("++++++++++++++"+e);
			e.printStackTrace();
		}
		if(username == null) {
	     	return new ModelAndView("index");
	         }
		return new ModelAndView(new RedirectView("userprivilige.obj"));
	}
	
	@RequestMapping("userrole")
	public ModelAndView userroleModel(HttpServletRequest request,RedirectAttributes red)
	{   String username =(String)request.getSession().getAttribute("usrname");
		ModelAndView mv = new ModelAndView("userrole");
		if(username == null) {
			return mv = new ModelAndView("index");
	         }
		String pagename = "userrole";
        int i = insertDataController.checkprivileges(pagename);
        if(i != 1)
        {
        	 red.addFlashAttribute("errorMessage","Access denied");
			   return mv=new ModelAndView("Home");
        }
		return mv;
	}
	
	@RequestMapping("viewuserrole")
	public ModelAndView viewuserroleModel(HttpServletRequest request,RedirectAttributes red)
	{
		String username =(String)request.getSession().getAttribute("usrname");
		ModelAndView mv = new ModelAndView("viewuserrole");
		 final List<UserRoleModel> alluserroleList = (List<UserRoleModel>)this.userroleService.getAll();
		 mv.addObject("userroleList", (Object)alluserroleList);
		 if(username == null) 
		 {
		   return mv = new ModelAndView("index");
		 }
		 String pagename = "viewuserrole";
	        int i = insertDataController.checkprivileges(pagename);
	        if(i != 1)
	        {
	        	 red.addFlashAttribute("errorMessage","Access denied");
				   return mv=new ModelAndView("Home");
	        }
		return mv;
	}
	
	 
    @RequestMapping("saveuserrole")  
 public ModelAndView saveuserrole(HttpServletRequest request, RedirectAttributes redirectAttributes)
 {             String username =(String)request.getSession().getAttribute("usrname");
        try {
               String usertype = request.getParameter("usertype");
               String rolename = request.getParameter("rolename");
               String roletype = request.getParameter("roletype");
               if(isStringValid(usertype) || isStringValid(rolename) ||isStringValid(roletype))
               {
                   redirectAttributes.addFlashAttribute("msg", (Object)"<div class=\"alert alert-danger\"><b>Allowed only Alphabates and Numbers!</b> </div>\r\n");
                   return new ModelAndView((View)new RedirectView("userrole.obj"));
               }
               UserRoleModel userrole = new UserRoleModel();               
               userrole.setRole_name(rolename);
               userrole.setUser_type(usertype);
               userrole.setRole_type(roletype);
               Date d2 = new Date();
               SimpleDateFormat dd = new SimpleDateFormat("yyyy-MM-dd");
               String formattedDate1 = dd.format(d2);
               userrole.setCreated_date(formattedDate1);                   
               this.userroleService.create(userrole);        
               redirectAttributes.addFlashAttribute("msg",
                                   "<div class=\"alert alert-success\"><b>Success !</b> Record created successfully.</div>\r\n"+ "");
        } catch (Exception e)
        {
               System.out.println("++++++++++++++"+e);
               e.printStackTrace();
        }
        if(username == null) {
        return new ModelAndView("index");
          }
        return new ModelAndView(new RedirectView("viewuserrole.obj"));
 }

	 @ResponseBody
	    @RequestMapping(value = { "validateRole" }, method = { RequestMethod.GET })
	    public String validateRole(final HttpServletRequest request) {
		 String username =(String)request.getSession().getAttribute("usrname");
	        final Gson gson = new Gson();
	        return this.userroleService.validateRole(request.getParameter("rolename")) + "";
	    }
	    
	
	@RequestMapping("useraction")
	public ModelAndView useractionModel(HttpServletRequest request,RedirectAttributes red)
	{		String username =(String)request.getSession().getAttribute("usrname");
		ModelAndView mv = new ModelAndView("useraction");
		if(username == null) {
	     	mv = new ModelAndView("index");
	         }
		String pagename = "useraction";
        int i = insertDataController.checkprivileges(pagename);
        if(i != 1)
        {
        	 red.addFlashAttribute("errorMessage","Access denied");
			   return mv=new ModelAndView("Home");
        }
			return mv;
		
	}
	
	@RequestMapping("saveuseraction")  
	public ModelAndView saveuseraction(HttpServletRequest request, RedirectAttributes redirectAttributes)
	{		String username =(String)request.getSession().getAttribute("usrname");
		try {
			String actionname = request.getParameter("actionname");
			String actionstatus = request.getParameter("actionstatus");
			if(isStringValid(actionname) || isStringValid(actionstatus))
			  {
			    redirectAttributes.addFlashAttribute("msg", (Object)"<div class=\"alert alert-danger\"><b>Allowed only Alphabates and Numbers!</b> </div>\r\n");
			    return new ModelAndView((View)new RedirectView("useraction.obj"));
			  }
			UserActionModel useraction = new UserActionModel();
			
			useraction.setAction_name(actionname);
			useraction.setAction_status(actionstatus);
			Date d2 = new Date();
			SimpleDateFormat dd = new SimpleDateFormat("yyyy-MM-dd");
			String formattedDate1 = dd.format(d2);
			useraction.setCreated_date(formattedDate1);
			this.useractionservice.create(useraction);
			redirectAttributes.addFlashAttribute("msg",
						"<div class=\"alert alert-success\"><b>Success !</b> Record created successfully.</div>\r\n"
								+ "");
	
		} catch (Exception e)
		{
			System.out.println("++++++++++++++"+e);
			e.printStackTrace();
		}
		if(username == null) {
	     	return new ModelAndView("index");
	         }
		return new ModelAndView(new RedirectView("useraction.obj"));
	}
	
	
	@RequestMapping("entryofpayment")
	public ModelAndView EntryofpiModel(HttpServletRequest request)
	{	String username =(String)request.getSession().getAttribute("usrname");
		ModelAndView mv = new ModelAndView("entryofpaymentinstrument");
		if(username == null) {
	     	mv = new ModelAndView("index");
	         }
		return mv;
	}
	
	
	@RequestMapping("saveentryofpaymentinstrument")  
	public ModelAndView saveentryofPI(HttpServletRequest request, RedirectAttributes redirectAttributes)
	{		String username =(String)request.getSession().getAttribute("usrname");
		try {
		
			String fullcontractno = request.getParameter("fullcontractno");
			String contractdate = request.getParameter("contractdate");
			String cropyear = request.getParameter("cropyear");
			String contractquantity = request.getParameter("contractquantity");
			String gradewiseqty = request.getParameter("gradewiseqty");
			String millofficeaddress = request.getParameter("millofficeaddress");
			String millsideaddress = request.getParameter("millsideaddress");
			String paymenttype = request.getParameter("paymenttype");
			String millaccountcode = request.getParameter("millaccountcode");
			String instrumentno = request.getParameter("instrumentno");
			String instdate = request.getParameter("instdate");
			String bankname1 = request.getParameter("bankname1");
			String bankbranch = request.getParameter("bankbranch");
			String tamount = request.getParameter("tamount");
			String autorevolvingoption = request.getParameter("autorevolvingoption");
			String autorevolvingamount = request.getParameter("autorevolvingamount");
			String dateofship = request.getParameter("dateofship");
			String dateofexpiry = request.getParameter("dateofexpiry");
			if(autorevolvingamount =="")
			{
				autorevolvingamount = "0";
			}
			PaymentInstrumentModel paymentinstrument = new PaymentInstrumentModel();
			
			paymentinstrument.setFullcontractno(fullcontractno);
			SimpleDateFormat formatter1 = new SimpleDateFormat("yyyy-MM-dd");
			Date contdate = formatter1.parse(contractdate);
			paymentinstrument.setContractdate(contdate);
			paymentinstrument.setCropyear(cropyear);
			paymentinstrument.setContractquantity(contractquantity);
			paymentinstrument.setVarietygradewisequantity(gradewiseqty);
			paymentinstrument.setMillofficeaddress(millofficeaddress);
			paymentinstrument.setMillsideaddress(millsideaddress);
			paymentinstrument.setPaymenttype(paymenttype);
			paymentinstrument.setMillaccountcode(millaccountcode);
			paymentinstrument.setInstrumentno(instrumentno);
			Date instdate1 = formatter1.parse(instdate);
			paymentinstrument.setInstrumentdate(instdate1);
			paymentinstrument.setBankname(bankname1);
			paymentinstrument.setBankbranch(bankbranch);
			paymentinstrument.setAmount(tamount);
			paymentinstrument.setAutorevolvingoption(autorevolvingoption);
			paymentinstrument.setAutorevolvingamount(autorevolvingamount);
			Date date3 = null;
			if(dateofship =="")
				{
				  paymentinstrument.setDateofshipment(date3);
				}
			else
				{
				  Date dateofship1 = formatter1.parse(dateofship);
				  paymentinstrument.setDateofshipment(dateofship1);
				}
			if(dateofexpiry =="")
				{
				  paymentinstrument.setDateofexpiry(date3);
				}
			else
				{
				  Date dateofexpiry1 = formatter1.parse(dateofexpiry);
				  paymentinstrument.setDateofexpiry(dateofexpiry1);
				}
			//System.out.println();
			 Date date= new Date();
			 String currdate = date.toString();
		     paymentinstrument.setGenerateddate(currdate);
	
			this.paymentinstrumentservice.create(paymentinstrument);
			redirectAttributes.addFlashAttribute("msg",
						"<div class=\"alert alert-success\"><b>Success !</b> Record saved successfully.</div>\r\n"
								+ "");
	
		} catch (Exception e) 
		{
			System.out.println("++++++++++++++"+e);
			e.printStackTrace();
		}
		if(username == null) {
	     	return new ModelAndView("index");
	         }
		return new ModelAndView(new RedirectView("entryofpayment.obj"));
	}
	
	
	@RequestMapping("HOdispatch")
	public ModelAndView HODispatchInstructionModel(HttpServletRequest request)
	{	String username =(String)request.getSession().getAttribute("usrname");
		ModelAndView mv = new ModelAndView("HOdispatchinstruction");
		if(username == null) {
	     	mv = new ModelAndView("index");
	         }
		return mv;
	}
	
	@RequestMapping("savehodispatch")  
	public ModelAndView hoDispatchInstruction(HttpServletRequest request, RedirectAttributes redirectAttributes)
	{	String username =(String)request.getSession().getAttribute("usrname");
		try 
		{
			String fullcontractno = request.getParameter("fullcontractno");
			String contractdate = request.getParameter("contractdate");
			String cropyear = request.getParameter("cropyear");
			String contractquantity = request.getParameter("contractquantity");
			String gradewiseqty = request.getParameter("gradewiseqty");
			String regionaloffices = request.getParameter("regionaloffices");
			String lastdateofshipment = request.getParameter("lastdateofshipment");
			String uniqueno = request.getParameter("uniqueno");
			String dateofdi = request.getParameter("dateofdi");
			String jutevariety = request.getParameter("jutevariety");
			String quantity = request.getParameter("quantity");
			String gprice1 = request.getParameter("gprice0");
			String gprice2 = request.getParameter("gprice1");
			String gprice3 = request.getParameter("gprice2");
			String gprice4 = request.getParameter("gprice3");
			String gprice5 = request.getParameter("gprice4");
			String gprice6 = request.getParameter("gprice5");
			String gprice7 = request.getParameter("gprice6");
			String gprice8 = request.getParameter("gprice7");
			if(gprice1 == null)
			{  gprice1 = "0"; }
			if(gprice2 == null)
			{  gprice2 = "0"; }
			if(gprice3 == null)
			{  gprice3 = "0"; }
			if(gprice4 == null)
			{  gprice4 = "0"; }
			if(gprice5 == null)
			{  gprice5 = "0"; }
			if(gprice6 == null)
			{  gprice6 = "0"; }
			if(gprice7 == null)
			{  gprice7 = "0"; }
			if(gprice8 == null)
			{  gprice8 = "0"; }
			
			HODispatchInstructionModel hodispatch = new HODispatchInstructionModel();
			
			hodispatch.setFullcontractno(fullcontractno);
			SimpleDateFormat formatter1 = new SimpleDateFormat("yyyy-MM-dd");
			Date contdate = formatter1.parse(contractdate);
			hodispatch.setContractdate(contdate);
			hodispatch.setCropyear(cropyear);
			hodispatch.setContractquantity(contractquantity);
			hodispatch.setVarietygradewisequantity(gradewiseqty);
			hodispatch.setRegionaloffice(regionaloffices);
			Date shipmentdate = formatter1.parse(lastdateofshipment);
			hodispatch.setDateofshipment(shipmentdate);
			hodispatch.setUniqueno(uniqueno);
			Date didate = formatter1.parse(dateofdi);
			hodispatch.setDidate(didate);
			hodispatch.setJutevariety(jutevariety);
			hodispatch.setQuentity(quantity);
			hodispatch.setJutegrade1(gprice1);
			hodispatch.setJutegrade2(gprice2);
			hodispatch.setJutegrade3(gprice3);
			hodispatch.setJutegrade4(gprice4);
			hodispatch.setJutegrade5(gprice5);
			hodispatch.setJutegrade6(gprice6);
			hodispatch.setJutegrade7(gprice7);
			hodispatch.setJutegrade8(gprice8);
			this.hodispatchservice.create(hodispatch);
			redirectAttributes.addFlashAttribute("msg","<div class=\"alert alert-success\"><b>Success !</b> Record saved successfully.</div>\r\n"+ "");
	
		} catch (Exception e)
		{
			System.out.println("++++++++++++++"+e);
			e.printStackTrace();
		}
		if(username == null) {
	     	return new ModelAndView("index");
	         }
		return new ModelAndView(new RedirectView("HOdispatch.obj"));
	}
	
	@RequestMapping("entryofsale")
	public ModelAndView EntryofSaleForm(HttpServletRequest request)
	{	String username =(String)request.getSession().getAttribute("usrname");
		ModelAndView mv = new ModelAndView("entryofsale");
		 if(username == null) {
		     	mv = new ModelAndView("index");
		         }
		return mv;
	}
	
	@RequestMapping("saveentryofsale")  
	public ModelAndView saveEntryofsale(HttpServletRequest request, RedirectAttributes redirectAttributes)
	{		String username =(String)request.getSession().getAttribute("usrname");
		try 
		{
			String dpc10no = request.getParameter("dpc10no");
			String dpc10date = request.getParameter("dpc10date");
			String millsname = request.getParameter("millsname");
			String contractnodate = request.getParameter("contractnodate");
			String dinoanddate = request.getParameter("dinoanddate");
			String centername = request.getParameter("centername");
			String agency = request.getParameter("agency");
			String region = request.getParameter("region");
			String challanno = request.getParameter("challanno");
			String challandate = request.getParameter("challandate");
			String lotno = request.getParameter("lotno");
			String transportno = request.getParameter("transportno");
			String cropyear = request.getParameter("cropyear");
			String jutevariety = request.getParameter("jutevariety");
			String jutegrade = request.getParameter("jutegrade");
			String nominalweight = request.getParameter("nominalweight");
			String quantity = request.getParameter("quantity");
			String rateperquintals = request.getParameter("rateperquintals");	
			if(lotno =="")
			{
				lotno ="0";
			}
			EntryofSaleModel entryofsale = new EntryofSaleModel();	
			entryofsale.setDpcno(dpc10no);
			SimpleDateFormat formatter1 = new SimpleDateFormat("yyyy-MM-dd");
			Date dpcdate = formatter1.parse(dpc10date);
			entryofsale.setDpcdate(dpcdate);
			entryofsale.setMillsname(millsname);
			entryofsale.setContractnoanddate(contractnodate);
			entryofsale.setDinoanddate(dinoanddate);
			entryofsale.setCentername(centername);
			entryofsale.setAgency(agency);
			entryofsale.setRegion(region);
			entryofsale.setChallanno(challanno);
			Date challandate1 = formatter1.parse(challandate);
			entryofsale.setChallandate(challandate1);
			entryofsale.setLotno(lotno);
			entryofsale.setTransportno(transportno);
			entryofsale.setCropyear(cropyear);
			entryofsale.setJutevariety(jutevariety);
			entryofsale.setJutegrade(jutegrade);
			entryofsale.setNominalweight(nominalweight);
			entryofsale.setQuantity(quantity);
			entryofsale.setRateperquintals(rateperquintals);
			
			this.entryofsaleservice.create(entryofsale);
			redirectAttributes.addFlashAttribute("msg","<div class=\"alert alert-success\"><b>Success !</b> Record saved successfully.</div>\r\n"
								+ "");
	
		} catch (Exception e)
		{
			System.out.println("++++++++++++++"+e);
			e.printStackTrace();
		}
		 if(username == null) {
		     	return new ModelAndView("index");
		         }
		return new ModelAndView(new RedirectView("entryofsale.obj"));
	}
	
	@RequestMapping("uploadingreceipt")
	public ModelAndView UploadingofreceiptBos(HttpServletRequest request)
	{		String username =(String)request.getSession().getAttribute("usrname");
		ModelAndView mv = new ModelAndView("uploadingofreceiptbos");
		 if(username == null) {
		     	mv = new ModelAndView("index");
		         }
		return mv;
	}
	
	@RequestMapping("saveuploadingreceipt")  
	public ModelAndView uploadingreceipt(HttpServletRequest request, RedirectAttributes redirectAttributes)
	{		String username =(String)request.getSession().getAttribute("usrname");
		try 
		{
			String dpc10no = request.getParameter("dpc10no");
			String jutevariety = request.getParameter("jutevariety");
			String jutegrade = request.getParameter("jutegrade");
			String actualweight = request.getParameter("actualweight");
			UploadingReceiptModel uploadrecipt = new UploadingReceiptModel();
			Date d2 = new Date();
			uploadrecipt.setDpc_number(dpc10no);
			SimpleDateFormat dd = new SimpleDateFormat("YYYY-MM-dd");
			String formattedDate1 = dd.format(d2);
			uploadrecipt.setJute_variety(jutevariety);
			uploadrecipt.setJute_grade(jutegrade);
			uploadrecipt.setActual_weight(actualweight);
			uploadrecipt.setReciept_date(formattedDate1);
			this.uploadrecieptservice.create(uploadrecipt);
			redirectAttributes.addFlashAttribute("msg",
						"<div class=\"alert alert-success\"><b>Success !</b> Record saved successfully.</div>\r\n"
								+ "");
	
		} catch (Exception e)
		{
			System.out.println("++++++++++++++"+e);
			e.printStackTrace();
		}
		 if(username == null) {
		     	return new ModelAndView("index");
		         }
		return new ModelAndView(new RedirectView("uploadingreceipt.obj"));
	}
	
	@ResponseBody
	@RequestMapping(value="userpriviligeajax", method = RequestMethod.GET)
	public String userpriviligeajax(HttpServletRequest request) {
		 String uPri="";
		int role_Id= 0;
		try{
			role_Id= Integer.parseInt(request.getParameter("roleId"));
		  uPri= userpriviligeservice.getUserPrivilegeListing(role_Id);
		}catch(Exception ex){
			System.out.println(ex.getStackTrace());
		}
		return uPri;
	}
	@ResponseBody
	@RequestMapping(value="userpriviligeajaxallData", method= RequestMethod.GET)
		public  String getuserpriviligeajaxallData() {
		 List<String> list=new ArrayList();
		 String res="";
		 
		try {
			list= userpriviligeservice.getuserpriviligeajaxallData();
			
			}
		
		catch(Exception e) {
			System.out.println(e.getStackTrace());
			
		}
		final Gson gson = new Gson();
        return gson.toJson((Object)list);
		
	}
	
	
	@RequestMapping("MSPgradesCombination")
	public ModelAndView MSPgradesCombination(HttpServletRequest request)
	{	String username =(String)request.getSession().getAttribute("usrname");
		ModelAndView mv = new ModelAndView("MSPgradesCombination");
		if(username == null) {
        	mv = new ModelAndView("index");
            }
		return mv;
	}

	
	  @RequestMapping("savegradesCombination") 
	  public ModelAndView savegradesCombination(HttpServletRequest request, RedirectAttributes redirectAttributes,HttpSession session) {

		  try { 
			  String username =(String)request.getSession().getAttribute("usrname");
			  if(username == null) {
			     	return new ModelAndView("index");
			         }
				 labelGenerationModel labelgenerationModel = new labelGenerationModel(); 
			  String basis = request.getParameter("basis"); 
			  String cropyr = request.getParameter("cropyr"); 
			  String label1 = request.getParameter("textbox1"); 
			  String label2 = request.getParameter("textbox2"); 
			  String label3 = request.getParameter("textbox3"); 
			  String label4 = request.getParameter("textbox4"); 
			  String label5 = request.getParameter("textbox5"); 
			  String label6 = request.getParameter("textbox6"); 
			  String label7 = request.getParameter("textbox7"); 
			  String label8 = request.getParameter("textbox8"); 
			  String label9 = request.getParameter("textbox9"); 
			  String label10 = request.getParameter("textbox10"); 
			  labelgenerationModel.setLabel1(label1);
			  labelgenerationModel.setLabel2(label2);
			  labelgenerationModel.setLabel3(label3);
			  labelgenerationModel.setLabel4(label4);
			  labelgenerationModel.setLabel5(label5);
			  labelgenerationModel.setLabel6(label6);
			  labelgenerationModel.setLabel7(label7);
			  labelgenerationModel.setLabel8(label8);
			  labelgenerationModel.setLabel9(label9);
			  labelgenerationModel.setLabel10(label10); 
			  labelgenerationModel.setBasis(basis);
			  labelgenerationModel.setCreatedBy((String)session.getAttribute("usrname")+"  role id{"+session.getAttribute("roleId")+"}");
			  labelgenerationModel.setCreatedOn(new Date());
			  labelgenerationModel.setCropyr(cropyr);
			  
			  this.labelgenerationService.create(labelgenerationModel);
	  
	  redirectAttributes.addFlashAttribute("msg",
	  "<div class=\"alert alert-success\"><b>Success !</b> Record saved successfully.</div>\r\n"
	  + "");
	  
	  } catch (Exception e) { 
		  System.out.println("++++++++++++++"+e);
	  e.printStackTrace(); 
	  } 
	
	 return new ModelAndView(new RedirectView("MSPgradesCombination.obj")); }
	  
//	  @RequestMapping(value = "inventory")
//	  public void firstLevel(HttpServletRequest request, RedirectAttributes redirectAttributes,HttpSession session) {
//		  ModelAndView mv = new ModelAndView("Inventory");
//		  dailyPurchaseModelConfService.firstLevel("2022-2023", "msp");
//	  }
	  
	  
	  @RequestMapping(value = "SearchTally")
	  public ModelAndView searchTally(HttpServletRequest request,HttpSession session, RedirectAttributes red) {
		  ModelAndView mv = new ModelAndView("searchtally");
		  String username =(String)request.getSession().getAttribute("usrname");
		  if(username == null) {
	        	mv = new ModelAndView("index");
	            }
		  String pagename = "SearchTally";
	        int i = insertDataController.checkprivileges(pagename);
	        if(i != 1)
	        {
	        	 red.addFlashAttribute("errorMessage","Access denied");
				   return mv=new ModelAndView("Home");
	        }
		  return mv;
		 
	  }
	  
	  @ResponseBody
      @RequestMapping(value = { "talystatus" }, method = { RequestMethod.GET })
      public String talystatus(final HttpServletRequest request) {
		  
		 Gson gson = new Gson();
		  JSONArray arr =   rawJuteProcurAndPayService.searchTally(request.getParameter("tally"));
		 // System.out.println(arr.toString());
         return arr.toString();
      }
	  
		 @RequestMapping(value = { "LedgerReport" })
		  public ModelAndView LedgerReport(final HttpServletRequest request,RedirectAttributes red) {
		    	String username =(String)request.getSession().getAttribute("usrname");
		        ModelAndView mv = new ModelAndView("LedgerReport");
		        System.out.println("jhfhfghfjhgk");
		    	   if(username == null) {
		    		    return mv = new ModelAndView("index");
		               }
			
			  try { 
				  final List<FarmerRegModel> farmerList= null;//(List<FarmerRegModel>)this.farmerService.getAll();
			       mv.addObject("farmerList",(Object)farmerList);
			  
			  } catch(Exception e) { 
				  e.printStackTrace(); 
				  }
			 
			 
		        return mv;
		    }
		 
		 
		 @RequestMapping("LedgerReportList")
		    public ModelAndView LedgerReportList(final HttpServletRequest request, RedirectAttributes redirectAttributes, HttpServletResponse response) {
		    	String username =(String)request.getSession().getAttribute("usrname");
		    	 
		    	   String Crop_Year = request.getParameter("crop_year");
		    	    String Basis = request.getParameter("basis");
		    	    Basis = Basis.toUpperCase();
		    	    String Farmer = request.getParameter("customInput");
		    	    Farmer=Farmer.split("-")[0];
		    	    System.err.println(Farmer);
		    	   ModelAndView mv = new ModelAndView("LedgerReportList");
			        System.out.println("bbbbbbbbhfgdgh");

		    	   
		    	 if(username == null)
		    	 {
		         	return new ModelAndView("index");
		          }
		        try {
		            final List<LedgerReportDTO> allLedgerReport = (List<LedgerReportDTO>)this.purchasereportService.LedgerReportList( Basis,Crop_Year, Farmer);
		            System.err.println("allDailyReport===77"+allLedgerReport);

		            if(allLedgerReport ==null)
		            {
		                redirectAttributes.addFlashAttribute("msg", (Object)"<div class=\"alert alert-danger\"><b> Data Not Found !!!!</b></div>\r\n");
		                return new ModelAndView((View)new RedirectView("LedgerReportList.obj"));
			    	}
		               mv.addObject("allLedgerReport", (Object)allLedgerReport);
		               mv.addObject("basis", (Object)Basis);
		               mv.addObject("customInput", (Object)Farmer);
		              mv.addObject("crop_year", (Object)Crop_Year);
		              
		           System.err.println("mmmmmmmmmmmmmmmmmm");
		        }
		        catch (Exception e) {
		            System.out.println(e.getLocalizedMessage());
		        }
		         
		        return mv;
		    }
	  
		 
		 @RequestMapping(value = { "LedgerReportDownload" })
		 public ModelAndView LedgerReportDownload(final HttpServletRequest request, final RedirectAttributes redirectAttributes, HttpServletResponse response) {
		     String username = (String) request.getSession().getAttribute("usrname");

		     String Crop_Year = request.getParameter("crop_year");
		     String Basis = request.getParameter("basis").toUpperCase();
		     String Farmer = request.getParameter("farmer");

		     ModelAndView mv = new ModelAndView("LedgerReport");
		     if (username == null) {
		         return new ModelAndView("index");
		     }

		     try {
		         final List<LedgerReportDTO> allLedgerReport = this.purchasereportService.LedgerReportList(Basis, Crop_Year, Farmer);
		         System.out.println("my list" + allLedgerReport);

		         for (LedgerReportDTO ledgerlist : allLedgerReport) {
		             //ledgerlist.setCropyear(Crop_Year);
		             ledgerlist.setFarmerRegNo(Farmer);
		             //ledgerlist.setBasis(Basis);

		             // Mask Aadhaar number
		             String aadharNum = ledgerlist.getAadharNo();
		             if (aadharNum != null) {
		                 String aadharNo = "********" + aadharNum.substring(aadharNum.length() - 4);
		                 ledgerlist.setAadharNo(aadharNo);
		                 System.err.println(aadharNo);
		             }
		         }

		         mv.addObject("allLedgerReport", allLedgerReport);

		         JasperReport jasperReport1 = JasperCompileManager.compileReport("E:\\\\Program Files\\\\Apache Software Foundation\\\\Tomcat 8.5\\\\webapps\\\\PDF_Report\\Farmer_LEDGER.jrxml");

		         Map<String, Object> parameters = new HashMap<>();
		         JRBeanCollectionDataSource dataSource1 = new JRBeanCollectionDataSource(allLedgerReport);

		         JasperPrint jasperPrint1 = JasperFillManager.fillReport(jasperReport1, parameters, dataSource1);
		         response.setContentType("application/pdf");
		         response.setHeader("Content-Disposition", "attachment; filename=Ledger Report.pdf");

		         try (ServletOutputStream out = response.getOutputStream()) {
		             JRPdfExporter exporter = new JRPdfExporter();
		             exporter.setParameter(JRPdfExporterParameter.JASPER_PRINT, jasperPrint1);
		             exporter.setParameter(JRPdfExporterParameter.OUTPUT_STREAM, out);
		             exporter.exportReport();
		         } catch (Exception e) {
		             System.out.println(e.getLocalizedMessage());
		         }

		     } catch (Exception e) {
		         System.out.println(e.getLocalizedMessage());
		     }

		     return mv;
		 }

		 @ResponseBody
		    @RequestMapping({ "getfarmerdetail" })
		    public String findDpcByRegion(final HttpServletRequest request) {
			  String value =  request.getParameter("value");
			  final Gson gson = new Gson();
		        return gson.toJson((Object) this.purchaseReportService.farmerdetail(request.getParameter("value")));

		    }
		 
		 @RequestMapping(value = { "RegionReport" })
		  public ModelAndView RegionReport(final HttpServletRequest request,RedirectAttributes red) {
		    	String username =(String)request.getSession().getAttribute("usrname");
		        ModelAndView mv = new ModelAndView("RegionReport");
		    	   if(username == null) {
		    		    return mv = new ModelAndView("index");
		               }
		    	
		    	   try {
		    		   final List<RoDetailsModel> regionList = (List<RoDetailsModel>)this.roService.getAll();
		    		   mv.addObject("regionList", (Object)regionList);
		    	       final List<ZoneModel> zoneList = (List<ZoneModel>)this.zoneService.getAll();
		               mv.addObject("zoneList", (Object)zoneList);
		       		   }
		    	   catch(Exception e) {
		    		   e.printStackTrace();
		    	   }
		        return mv;
		    }
		 @ResponseBody
		 @RequestMapping("RegionReportList")
		    public String RegionReportList(@RequestParam("cropyear") String cropyear,@RequestParam("fromdate") String fromdate ,@RequestParam("todate") String todate , @RequestParam("basis") String basis, @RequestParam("juteVariety") String juteVariety) {
		    	String username =(String)request.getSession().getAttribute("usrname");
		    	JSONObject objParent = new JSONObject();
	            JSONArray arr = new JSONArray();
		    	   
		        try {
		            final List<DailyReportDTO> allRegionReport = (List<DailyReportDTO>)this.purchasereportService.RegionReportList(cropyear, todate,basis,juteVariety,fromdate);
		            System.err.println("allDailyReport===77"+allRegionReport.toString());
		            List<DailyReportDTO> dailylist = new ArrayList<DailyReportDTO>();
	                Set<String> uniqueCombos = new HashSet<>();
	                List<DailyReportDTO> filteredList = new ArrayList<>();
	                int s1=0, s2 =0, s3=0, s4=0, s5 = 0, s6=0, s7=0, s8=0,ded=0,Basis=0,gross=0,net=0,grasat=0,fiber=0;
	                
	                
		            for(DailyReportDTO dalydto : allRegionReport) {
	        	          JSONObject obj = new JSONObject();

	        	          DailyReportDTO dailydto=new DailyReportDTO();
	         	           
	                                       s1 += dalydto.getGr1d();

	                                       dailydto.setGr1d(s1);
	                             
	                          s2 += dalydto.getGr2d();

	                          dailydto.setGr2d(s2);
	                   
	                          s3 += dalydto.getGr3d();

	                          dailydto.setGr3d(s3);
	                          
	                     s4 += dalydto.getGr4d();

	                          dailydto.setGr4d(s4);
	                  
	                          s5 += dalydto.getGr5d();

	                          dailydto.setGr5d(s5);
	                 
	                          s6 += dalydto.getGr6d();

	                          dailydto.setGr6d(s6);
	                   
	                          s7 += dalydto.getGr7d();

	                          dailydto.setGr7d(s7);
	                   
	                          s8 += dalydto.getGr8d();

	                          dailydto.setGr8d(s8);
	                   
	                    	  ded += dalydto.getDedQuand();

	                          dailydto.setDedQuand(ded);
	                  
	                          Basis += dalydto.getBasisPriced();

	                          dailydto.setBasisPriced(Basis);
	                  
	                          Basis += dalydto.getBasisPriced();

	                          dailydto.setBasisPriced(Basis);
	                 
	                    	  gross += dalydto.getGrossQuand();

	                          dailydto.setGrossQuand(gross);
	                
	                    	  net += dalydto.getNetQuand();

	                          dailydto.setNetQuand(net);
	                 
	                    	  grasat += dalydto.getGarsatRd();

	                          dailydto.setGarsatRd(grasat);
	                   
	                    	  fiber += dalydto.getFiberVald();

	                          dailydto.setFiberVald(fiber);
	                  
	        	          
	                      obj.put("Ded", dalydto.getDedQuand());
	                      obj.put("Basis", dalydto.getBasisPriced());
	                      obj.put("Gross", dalydto.getGrossQuand());
	                      obj.put("Net", dalydto.getNetQuand());
	                      obj.put("Grasat", dalydto.getGarsatRd());
	                      obj.put("Fiber", dalydto.getFiberVald());
	                      obj.put("Gr1", dalydto.getGr1d());
	                      obj.put("Gr2", dalydto.getGr2d());
	                      obj.put("Gr3", dalydto.getGr3d());
	                      obj.put("Gr4", dalydto.getGr4d());
	                      obj.put("Gr5", dalydto.getGr5d());
	                      obj.put("Gr6", dalydto.getGr6d());
	                      obj.put("Gr7", dalydto.getGr7d());
	                      obj.put("Gr8", dalydto.getGr8d());
	                      obj.put("Region", dalydto.getRegiond());
	                      
	                      dalydto.setDedQuand(dailydto.getDedQuand());
	                      dalydto.setBasisPriced(dailydto.getBasisPriced());
	                      dalydto.setGrossQuand(dailydto.getGrossQuand());
	                      dalydto.setNetQuand(dailydto.getNetQuand());
	                      dalydto.setGarsatRd(dailydto.getGarsatRd());
	                      dalydto.setFiberVald(dailydto.getFiberVald());
	                      dalydto.setGr1d(dailydto.getGr1d());
	                      dalydto.setGr2d(dailydto.getGr2d());
	                      dalydto.setGr3d(dailydto.getGr3d());
	                      dalydto.setGr4d(dailydto.getGr4d());
	                      dalydto.setGr5d(dailydto.getGr5d());
	                      dalydto.setGr6d(dailydto.getGr6d());
	                      dalydto.setGr7d(dailydto.getGr7d());
	                      dalydto.setGr8d(dailydto.getGr8d());
	                 

			               	 arr.put(obj);

		            }
		       	 objParent.put("data", arr);
	             System.err.println("objParent = "+objParent);
	             return objParent.toString();
		        }
		        catch (Exception e) {
		            System.out.println(e.getLocalizedMessage());
	                return objParent.toString();

		        }
		         
		    }
		 @RequestMapping(value = { "RegionReportDownload" })
		    public ModelAndView RegionReportDownload(final HttpServletRequest request, final RedirectAttributes redirectAttributes, HttpServletResponse response)  {
		    	String username =(String)request.getSession().getAttribute("usrname");
		    	System.err.println("dshfkjdhglsdjkgjdghsdkh");
		    	//String Regionname=request.getParameter("region");
	          //String Region = request.getParameter("rocode");
		            String From_date = request.getParameter("fromdate");
		            String To_date = request.getParameter("todate");
		            String DPC=request.getParameter("dpcid");	    	   
		             String Crop_Year = request.getParameter("crop_year");
		    	    String Basis = request.getParameter("basis");
		    	    String Jute_Variety = request.getParameter("jute_variety");
			    	 String Date_of_Purchase = request.getParameter("dateofpurchase");
			    	 
			    	 String[] fromDateParts = From_date.split("-");
			    	    String[] toDateParts = To_date.split("-");

			    	    // Rebuild the dates in desired format (DD-MM-YYYY)
			    	    String formattedFromDate = fromDateParts[2] + "-" + fromDateParts[1] + "-" + fromDateParts[0];
			    	    String formattedToDate = toDateParts[2] + "-" + toDateParts[1] + "-" + toDateParts[0];

			    	    // Combine the formatted dates with separator
			    	    String fromtoDated = formattedFromDate + " to " + formattedToDate;

			    	    System.out.println(fromtoDated);

		    	    
		    	   
		    	 ModelAndView mv = new ModelAndView("RegionReport");
		    	 if(username == null)
		    	     {
		         	   return new ModelAndView("index");
		             }
		        try {
		            final List<DailyReportDTO> allRegionReport = (List<DailyReportDTO>)this.purchasereportService.RegionReportList(Crop_Year,To_date, Basis, Jute_Variety,From_date);
		        System.out.println("my list" +allRegionReport);
		            double gtotald = 0.0;                            
		            double dtotald = 0.0;
		            double ntotald = 0.0;
		            double gatotald = 0.0;
		            int ftotald = 0;
		            double batotald =0.0;
		            double gr1totd = 0.0;
		            double gr2totd = 0.0;
		            double gr3totd = 0.0;
		            double gr4totd = 0.0;
		            double gr5totd = 0.0;
		            double gr6totd = 0.0;
		            double gr7totd = 0.0;
		            double gr8totd = 0.0;
		            String placeopur = "";
		            for(DailyReportDTO purchaselist : allRegionReport)
		            {
		            	gtotald += purchaselist.getGrossQuand();
		            	BigDecimal total = new BigDecimal(gtotald).setScale(2, RoundingMode.HALF_UP);
		            	gtotald = total.doubleValue();
		            	
		            	dtotald += purchaselist.getDedQuand();
		            	BigDecimal total1 = new BigDecimal(dtotald).setScale(2, RoundingMode.HALF_UP);
		            	dtotald = total1.doubleValue();
		            	
		            	ntotald += purchaselist.getNetQuand();
		            	BigDecimal total2 = new BigDecimal(ntotald).setScale(2, RoundingMode.HALF_UP);
		            	ntotald = total2.doubleValue();
		            	
		                gatotald += purchaselist.getGarsatRd();
		                ftotald += purchaselist.getFiberVald();
		                batotald += purchaselist.getBasisPriced();
		                
		                gr1totd += purchaselist.getGr1d();
		            	BigDecimal total3 = new BigDecimal(gr1totd).setScale(2, RoundingMode.HALF_UP);
		            	gr1totd = total3.doubleValue();
		            	
		            	gr2totd += purchaselist.getGr2d();
		            	BigDecimal total4 = new BigDecimal(gr2totd).setScale(2, RoundingMode.HALF_UP);
		            	gr2totd = total4.doubleValue();
		            	
		            	gr3totd += purchaselist.getGr3d();
		            	BigDecimal total5 = new BigDecimal(gr3totd).setScale(2, RoundingMode.HALF_UP);
		            	gr3totd = total5.doubleValue();
		            	
		            	gr4totd += purchaselist.getGr4d();
		            	BigDecimal total6 = new BigDecimal(gr4totd).setScale(2, RoundingMode.HALF_UP);
		            	gr4totd = total6.doubleValue();
		            	
		            	gr5totd += purchaselist.getGr5d();
		            	BigDecimal total7 = new BigDecimal(gr5totd).setScale(2, RoundingMode.HALF_UP);
		            	gr5totd = total7.doubleValue();
		            	
		            	gr6totd += purchaselist.getGr6d();
		            	BigDecimal total8 = new BigDecimal(gr6totd).setScale(2, RoundingMode.HALF_UP);
		            	gr6totd = total8.doubleValue();
		            	
		            	gr7totd += purchaselist.getGr7d();
		            	BigDecimal total9 = new BigDecimal(gr7totd).setScale(2, RoundingMode.HALF_UP);
		            	gr7totd = total9.doubleValue();
		            	
		            	gr8totd += purchaselist.getGr8d();
		            	BigDecimal total10 = new BigDecimal(gr8totd).setScale(2, RoundingMode.HALF_UP);
		            	gr8totd = total10.doubleValue();
		            	
		                placeopur = purchaselist.getPlacepurd();
		                
	                System.err.println(placeopur+"hhdjdjhjh");



		                purchaselist.setGtotald(gtotald);
		                purchaselist.setDtotald(dtotald);
		                purchaselist.setNtotald(ntotald);
		                purchaselist.setGatotald(gatotald);
		                purchaselist.setFtotald(ftotald);
		                purchaselist.setBatotald(batotald);
		                purchaselist.setGr1totd(gr1totd);
		                purchaselist.setGr2totd(gr2totd);
		                purchaselist.setGr3totd(gr3totd);
		                purchaselist.setGr4totd(gr4totd);
		                purchaselist.setGr5totd(gr5totd);
		                purchaselist.setGr6totd(gr6totd);
		                purchaselist.setGr7totd(gr7totd);
		                purchaselist.setGr8totd(gr8totd);

		                purchaselist.setBasisd(Basis);
		                purchaselist.setJutevard(Jute_Variety);
		                purchaselist.setCropYeard(Crop_Year);
		                //purchaselist.setRegiond(Regionname);
		                purchaselist.setDatepurd(Date_of_Purchase);
		                purchaselist.setFromtodated(fromtoDated);
		                purchaselist.setPlacepurd(placeopur);
		                
		                
		                
		            }
		            mv.addObject("allRegionReport", allRegionReport);
		            JasperReport jasperReport1 = JasperCompileManager.compileReport("E:\\Program Files\\Apache Software Foundation\\Tomcat 8.5\\webapps\\PDF_Report\\RegionPurchaseReport.jrxml");
		        	
	             Map<String, Object> parameters = new HashMap<String, Object>();
	             // Prepare data sources
	             JRBeanCollectionDataSource dataSource1 = new JRBeanCollectionDataSource(allRegionReport);

	             // Fill JasperPrints
	             JasperPrint jasperPrint1 = JasperFillManager.fillReport(jasperReport1, parameters, dataSource1);
	          response.setContentType("application/pdf");
	             response.setHeader("Content-Disposition", "attachment; filename=Region Report.pdf");
	              try (ServletOutputStream out = response.getOutputStream()) {
	              JRPdfExporter exporter = new JRPdfExporter();
	              exporter.setParameter(JRPdfExporterParameter.JASPER_PRINT, jasperPrint1);
	           //   exporter.setParameter(JRPdfExporterParameter.JASPER_PRINT, jasperPrint.get(1));
	              exporter.setParameter(JRPdfExporterParameter.OUTPUT_STREAM, out);
	              exporter.exportReport();
	          }
	          catch (Exception e) {
		            System.out.println(e.getLocalizedMessage());
		        }
	        
	 }
	 catch (Exception e) {
	     System.out.println(e.getLocalizedMessage());
	 }
	 
	  
	 return mv;
	}
		 @RequestMapping(value = { "DailyReport" })
		  public ModelAndView DailyReport(final HttpServletRequest request,RedirectAttributes red) {
		    	String username =(String)request.getSession().getAttribute("usrname");
		        ModelAndView mv = new ModelAndView("DailyReport");
		    	   if(username == null) {
		    		    return mv = new ModelAndView("index");
		               }
		    
		    	   try {
		    		   final List<RoDetailsModel> regionList = (List<RoDetailsModel>)this.roService.getAll();
		    		   mv.addObject("regionList", (Object)regionList);
		    	       final List<ZoneModel> zoneList = (List<ZoneModel>)this.zoneService.getAll();
		               mv.addObject("zoneList", (Object)zoneList);
		       		   }
		    	   catch(Exception e) {
		    		   e.printStackTrace();
		    	   }
		        return mv;
		    }

		 @RequestMapping("DailyReportList")
		 public ModelAndView DailyReportList(@RequestParam String cropyear ,@RequestParam String fromdate ,@RequestParam String todate , @RequestParam String juteVariety ,@RequestParam String region , @RequestParam String basis ,final HttpServletRequest request, final RedirectAttributes redirectAttributes,HttpServletResponse response) {
		    	String username =(String)request.getSession().getAttribute("usrname");
		    	 
		    	
		            String regions = this.roService.findregionbyname(region);
		    	   ModelAndView mv = new ModelAndView("DailyReportList");

		    	   
		    	 if(username == null)
		    	 {
		         	return new ModelAndView("index");
		          }
				try {
		            final List<DailyReportDTO> allDailyReport = (List<DailyReportDTO>)this.purchasereportService.DailyReportList( basis, juteVariety,cropyear,fromdate,todate,regions);
		            System.err.println("allDailyReport===77"+allDailyReport);

		            if(allDailyReport ==null)
		            {
		                redirectAttributes.addFlashAttribute("msg", (Object)"<div class=\"alert alert-danger\"><b> Data Not Found !!!!</b></div>\r\n");
		                return new ModelAndView((View)new RedirectView("DailyReportList.obj"));
			    	}
		            System.out.println("Region"+regions);
		           // String roname = roService.findregionbyid(Region);
		               mv.addObject("allDailyReport", (Object)allDailyReport);
		               mv.addObject("basis", (Object)basis);
		               mv.addObject("region", (Object)region);
		             mv.addObject("roname", (Object)region);
		              mv.addObject("jute_variety", (Object)juteVariety);
		              mv.addObject("dateofpurchase", (Object)todate);
		              mv.addObject("crop_year", (Object)cropyear);
		              mv.addObject("fromdate", (Object)fromdate);
		              mv.addObject("todate", (Object)todate);

		            //  mv.addObject("dpcid", (Object)DPC);
		              
		           System.err.println("Volume 1");
		        }
		        catch (Exception e) {
		            System.out.println(e.getLocalizedMessage());
		        }
		         
		        return mv;
		    }
		 @RequestMapping(value = { "DailyReportDownload" })
		    public ModelAndView DailyReportDownload(final HttpServletRequest request, final RedirectAttributes redirectAttributes, HttpServletResponse response)  {
		    	String username =(String)request.getSession().getAttribute("usrname");
		    	
		    	String Regionname=request.getParameter("region");
	             String Region = request.getParameter("rocode");
		            String From_date = request.getParameter("fromdate");
		            String To_date = request.getParameter("todate");
		            String DPC=request.getParameter("dpcid");	    	   
		             String Crop_Year = request.getParameter("crop_year");
		    	    String Basis = request.getParameter("basis");
		    	    String Jute_Variety = request.getParameter("jute_variety");
			    	 String Date_of_Purchase = request.getParameter("dateofpurchase");
			            String regions = this.roService.findregionbyname(Regionname);

			    	 
			    	 String[] fromDateParts = From_date.split("-");
			    	    String[] toDateParts = To_date.split("-");

			    	    // Rebuild the dates in desired format (DD-MM-YYYY)
			    	    String formattedFromDate = fromDateParts[2] + "-" + fromDateParts[1] + "-" + fromDateParts[0];
			    	    String formattedToDate = toDateParts[2] + "-" + toDateParts[1] + "-" + toDateParts[0];

			    	    // Combine the formatted dates with separator
			    	    String fromtoDated = formattedFromDate + " to " + formattedToDate;

			    	    System.out.println(fromtoDated);

		    	    
		    	   
		    	 ModelAndView mv = new ModelAndView("DailyReport");
		    	 if(username == null)
		    	     {
		         	   return new ModelAndView("index");
		             }
		        try {
		            final List<DailyReportDTO> allDailyReport = (List<DailyReportDTO>)this.purchasereportService.DailyReportList( Basis, Jute_Variety,Crop_Year,From_date,To_date,regions);
		        System.out.println("my list" +allDailyReport);
		            double gtotald = 0.0;
		            double dtotald = 0.0;
		            double ntotald = 0.0;
		            double gatotald = 0.0;
		            int ftotald = 0;
		            double batotald =0.0;
		            double gr1totd = 0.0;
		            double gr2totd = 0.0;
		            double gr3totd = 0.0;
		            double gr4totd = 0.0;
		            double gr5totd = 0.0;
		            double gr6totd = 0.0;
		            double gr7totd = 0.0;
		            double gr8totd = 0.0;
		            String placeopur = "";
		            for(DailyReportDTO purchaselist : allDailyReport)
		            {
		            	gtotald += purchaselist.getGrossQuand();
		            	BigDecimal total = new BigDecimal(gtotald).setScale(2, RoundingMode.HALF_UP);
		            	gtotald = total.doubleValue();
		            	
		            	dtotald += purchaselist.getDedQuand();
		            	BigDecimal total1 = new BigDecimal(dtotald).setScale(2, RoundingMode.HALF_UP);
		            	dtotald = total1.doubleValue();
		            	
		            	ntotald += purchaselist.getNetQuand();
		            	BigDecimal total2 = new BigDecimal(ntotald).setScale(2, RoundingMode.HALF_UP);
		            	ntotald = total2.doubleValue();
		        
		                
		                gr1totd += purchaselist.getGr1d();
		            	BigDecimal total3 = new BigDecimal(gr1totd).setScale(2, RoundingMode.HALF_UP);
		            	gr1totd = total3.doubleValue();
		            	
		            	gr2totd += purchaselist.getGr2d();
		            	BigDecimal total4 = new BigDecimal(gr2totd).setScale(2, RoundingMode.HALF_UP);
		            	gr2totd = total4.doubleValue();
		            	
		            	gr3totd += purchaselist.getGr3d();
		            	BigDecimal total5 = new BigDecimal(gr3totd).setScale(2, RoundingMode.HALF_UP);
		            	gr3totd = total5.doubleValue();
		            	
		            	gr4totd += purchaselist.getGr4d();
		            	BigDecimal total6 = new BigDecimal(gr4totd).setScale(2, RoundingMode.HALF_UP);
		            	gr4totd = total6.doubleValue();
		            	
		            	gr5totd += purchaselist.getGr5d();
		            	BigDecimal total7 = new BigDecimal(gr5totd).setScale(2, RoundingMode.HALF_UP);
		            	gr5totd = total7.doubleValue();
		            	
		            	gr6totd += purchaselist.getGr6d();
		            	BigDecimal total8 = new BigDecimal(gr6totd).setScale(2, RoundingMode.HALF_UP);
		            	gr6totd = total8.doubleValue();
		            	
		            	gr7totd += purchaselist.getGr7d();
		            	BigDecimal total9 = new BigDecimal(gr7totd).setScale(2, RoundingMode.HALF_UP);
		            	gr7totd = total9.doubleValue();
		            	
		            	gr8totd += purchaselist.getGr8d();
		            	BigDecimal total10 = new BigDecimal(gr8totd).setScale(2, RoundingMode.HALF_UP);
		            	gr8totd = total10.doubleValue();

		                gatotald += purchaselist.getGarsatRd();
		                ftotald += purchaselist.getFiberVald();
		                batotald += Double.valueOf(purchaselist.getBasisPriced());
		                
		                placeopur = purchaselist.getPlacepurd();
		                
		                
		                
	                   System.err.println(placeopur+"hhdjdjhjh");



		                purchaselist.setGtotald(gtotald);
		                purchaselist.setDtotald(dtotald);
		                purchaselist.setNtotald(ntotald);
		                purchaselist.setGr1totd(gr1totd);
		                purchaselist.setGr2totd(gr2totd);
		                purchaselist.setGr3totd(gr3totd);
		                purchaselist.setGr4totd(gr4totd);
		                purchaselist.setGr5totd(gr5totd);
		                purchaselist.setGr6totd(gr6totd);
		                purchaselist.setGr7totd(gr7totd);
		                purchaselist.setGr8totd(gr8totd);
		                purchaselist.setGatotald(gatotald);
		                purchaselist.setFtotald(ftotald);
		                purchaselist.setBatotald(batotald);
		                
		                purchaselist.setBasisd(Basis);
		                purchaselist.setJutevard(Jute_Variety);
		                purchaselist.setCropYeard(Crop_Year);
		                purchaselist.setRegiond(Regionname);
		                purchaselist.setDatepurd(Date_of_Purchase);
		                purchaselist.setFromtodated(fromtoDated);
		                purchaselist.setPlacepurd(placeopur);

		                
		                
		                
		            }
		            mv.addObject("allDailyReport", allDailyReport);
		            JasperReport jasperReport1 = JasperCompileManager.compileReport("E:\\Program Files\\Apache Software Foundation\\Tomcat 8.5\\webapps\\PDF_Report\\Daily Purchase Report2.jrxml");
		        	
	                Map<String, Object> parameters = new HashMap<String, Object>();
	                // Prepare data sources
	                JRBeanCollectionDataSource dataSource1 = new JRBeanCollectionDataSource(allDailyReport);

	                // Fill JasperPrints
	                JasperPrint jasperPrint1 = JasperFillManager.fillReport(jasperReport1, parameters, dataSource1);
	             response.setContentType("application/pdf");
	                response.setHeader("Content-Disposition", "attachment; filename=Daily Report.pdf");
	                 try (ServletOutputStream out = response.getOutputStream()) {
	                 JRPdfExporter exporter = new JRPdfExporter();
	                 exporter.setParameter(JRPdfExporterParameter.JASPER_PRINT, jasperPrint1);
	              //   exporter.setParameter(JRPdfExporterParameter.JASPER_PRINT, jasperPrint.get(1));
	                 exporter.setParameter(JRPdfExporterParameter.OUTPUT_STREAM, out);
	                 exporter.exportReport();
	             }
	             catch (Exception e) {
	 	            System.out.println(e.getLocalizedMessage());
	 	        }
	           
	    }
	    catch (Exception e) {
	        System.out.println(e.getLocalizedMessage());
	    }
	    
	     
	    return mv;
	}
		 @RequestMapping(value = { "PurchaseReport" })
		  public ModelAndView PurchaseReport(final HttpServletRequest request,RedirectAttributes red) {
		    	String username =(String)request.getSession().getAttribute("usrname");
		        ModelAndView mv = new ModelAndView("PurchaseReport");
		    	   if(username == null) {
		    		    return mv = new ModelAndView("index");
		               }
		    
		    	   try {
		    		   final List<RoDetailsModel> regionList = (List<RoDetailsModel>)this.roService.getAll();
		    		   mv.addObject("regionList", (Object)regionList);
		    	       final List<ZoneModel> zoneList = (List<ZoneModel>)this.zoneService.getAll();
		               mv.addObject("zoneList", (Object)zoneList);
		       		   }
		    	   catch(Exception e) {
		    		   e.printStackTrace();
		    	   }
		        return mv;
		    }
		 
		 @RequestMapping("PurchaseReportList")
		    public ModelAndView PurchaseReportList(@RequestParam String basis, @RequestParam String CropYear ,@RequestParam String fromdate, @RequestParam String todate,@RequestParam String juteVariety ,@RequestParam String dpc ,final HttpServletRequest request, final RedirectAttributes redirectAttributes) throws Exception {
		    	String username =(String)request.getSession().getAttribute("usrname");
		    	 
		            String dpcId = this.purchaseCenterService.findDpIdbyName(dpc);

		    	ModelAndView mv = new ModelAndView("PurchaseReportList");
		    	 if(username == null)
		    	 {
		         	return new ModelAndView("index");
		          }
		        try {
		            final List<PurchaseReportDTO> allPurchaseReport = (List<PurchaseReportDTO>)this.purchasereportService.PurchaseReportList(dpcId, basis, juteVariety,CropYear, fromdate, todate);
		           
		            if(allPurchaseReport ==null)
		            {
		                redirectAttributes.addFlashAttribute("msg", (Object)"<div class=\"alert alert-danger\"><b> Data Not Found !!!!</b></div>\r\n");
		                return new ModelAndView((View)new RedirectView("PurchaseReportList.obj"));
			    	}
		            System.out.println("jdgjkgfhdkghdkgksgh" +allPurchaseReport);
		               mv.addObject("allPurchaseReport", (Object)allPurchaseReport);
				
				/*
				 * List<String> dpcname = purchaseService.dpcbyId(DPC);
				 * mv.addObject("dpcname",(Object)dpcname);
				 */
				     
		               mv.addObject("dpcname",(Object)dpc);
		               mv.addObject("DPCid",(Object)dpcId);
		               mv.addObject("basis", (Object)basis);
		              mv.addObject("jute_variety", (Object)juteVariety);
		              mv.addObject("fromdate", (Object)fromdate);
		              mv.addObject("todate", (Object)todate);
		              mv.addObject("crop_year", (Object)CropYear);
		           
		        }
		        catch (Exception e) {
		            System.out.println(e.getLocalizedMessage());
		        }
		         
		        return mv;
		    }
		 
		 @RequestMapping(value = { "PurchaseReportDownload" })
		    public ModelAndView MarketArrivalDownload(final HttpServletRequest request, final RedirectAttributes redirectAttributes,HttpServletResponse response) throws ParseException {
		    	String username =(String)request.getSession().getAttribute("usrname");
		    	    
		            String From_date = request.getParameter("fromdate");
		            String To_date = request.getParameter("todate");
		    	    String DPC = request.getParameter("DPCid");
		    	    String dpcname = request.getParameter("dpcname");
		    	    String Crop_Year = request.getParameter("crop_year");
		    	    String Basis = request.getParameter("basis");
		    	    String Jute_Variety = request.getParameter("jute_variety");
		    	    //String Region = request.getParameter("Region");
			    	String Regionname=request.getParameter("Region");

		    	    //String fromtoDate=From_date+ "-" +To_date;
		    	    
		    	    String[] fromDateParts = From_date.split("-");
		    	    String[] toDateParts = To_date.split("-");

		    	    // Rebuild the dates in desired format (DD-MM-YYYY)
		    	    String formattedFromDate = fromDateParts[2] + "-" + fromDateParts[1] + "-" + fromDateParts[0];
		    	    String formattedToDate = toDateParts[2] + "-" + toDateParts[1] + "-" + toDateParts[0];

		    	    // Combine the formatted dates with separator
		    	    String fromtoDate = formattedFromDate + " to " + formattedToDate;

		    	    System.out.println(fromtoDate);
		    	    
		    	   //final String Region=request.getParameter("region");
		    	   
		    	 ModelAndView mv = new ModelAndView("PurchaseReport");
		    	 if(username == null)
		    	     {
		         	   return new ModelAndView("index");
		             }
		        try {
		        	final List<PurchaseReportDTO> allPurchaseReport = (List<PurchaseReportDTO>)this.purchasereportService.PurchaseReportList(DPC, Basis, Jute_Variety,Crop_Year, From_date, To_date);	            	            
		            double gtotal = 0.0;
		            double dtotal = 0.0;
		            double ntotal = 0.0;
		            double gatotal = 0.0;
		            int ftotal = 0;
		            double batotal =0.0;
		            double gr1tot = 0.0;
		            double gr2tot = 0.0;
		            double gr3tot = 0.0;
		            double gr4tot = 0.0;
		            double gr5tot = 0.0;
		            double gr6tot = 0.0;
		            double gr7tot = 0.0;
		            double gr8tot = 0.0;
		            for(PurchaseReportDTO purchaselist : allPurchaseReport)
		            {
		            	gtotal += purchaselist.getGrossQuan();
		            	BigDecimal total = new BigDecimal(gtotal).setScale(2, RoundingMode.HALF_UP);
		            	gtotal = total.doubleValue();
		            	
		            	dtotal += purchaselist.getDedQuan();
		            	BigDecimal total1 = new BigDecimal(dtotal).setScale(2, RoundingMode.HALF_UP);
		            	dtotal = total1.doubleValue();
		            	
		            	ntotal += purchaselist.getNetQuan();
		            	BigDecimal total2 = new BigDecimal(ntotal).setScale(2, RoundingMode.HALF_UP);
		            	ntotal = total2.doubleValue();
		        
		                
		                gr1tot += purchaselist.getGr1();
		            	BigDecimal total3 = new BigDecimal(gr1tot).setScale(2, RoundingMode.HALF_UP);
		            	gr1tot = total3.doubleValue();
		            	
		            	gr2tot += purchaselist.getGr2();
		            	BigDecimal total4 = new BigDecimal(gr2tot).setScale(2, RoundingMode.HALF_UP);
		            	gr2tot = total4.doubleValue();
		            	
		            	gr3tot += purchaselist.getGr3();
		            	BigDecimal total5 = new BigDecimal(gr3tot).setScale(2, RoundingMode.HALF_UP);
		            	gr3tot = total5.doubleValue();
		            	
		            	gr4tot += purchaselist.getGr4();
		            	BigDecimal total6 = new BigDecimal(gr4tot).setScale(2, RoundingMode.HALF_UP);
		            	gr4tot = total6.doubleValue();
		            	
		            	gr5tot += purchaselist.getGr5();
		            	BigDecimal total7 = new BigDecimal(gr5tot).setScale(2, RoundingMode.HALF_UP);
		            	gr5tot = total7.doubleValue();
		            	
		            	gr6tot += purchaselist.getGr6();
		            	BigDecimal total8 = new BigDecimal(gr6tot).setScale(2, RoundingMode.HALF_UP);
		            	gr6tot = total8.doubleValue();
		            	
		            	gr7tot += purchaselist.getGr7();
		            	BigDecimal total9 = new BigDecimal(gr7tot).setScale(2, RoundingMode.HALF_UP);
		            	gr7tot = total9.doubleValue();
		            	
		            	gr8tot += purchaselist.getGr8();
		            	BigDecimal total10 = new BigDecimal(gr8tot).setScale(2, RoundingMode.HALF_UP);
		            	gr8tot = total10.doubleValue();
		            	
		            	
		                gatotal += purchaselist.getGarsatR();
		                ftotal += purchaselist.getFiberVal();
		                batotal += Double.valueOf(purchaselist.getBasisPrice());
		              
		                
		           
		                

		              BigDecimal formattedGtotal = new BigDecimal(gtotal).setScale(2, RoundingMode.HALF_UP);
		             // Setting the rounded value to purchaselist
		             purchaselist.setGtotal(formattedGtotal.doubleValue());	               
		             purchaselist.setDtotal(dtotal);
		                purchaselist.setNtotal(ntotal);
		                purchaselist.setGatotal(gatotal);
		                purchaselist.setFtotal(ftotal);
		                purchaselist.setBatotal(batotal);
		                purchaselist.setGr1tot(gr1tot);
		                purchaselist.setGr2tot(gr2tot);
		                purchaselist.setGr3tot(gr3tot);
		                purchaselist.setGr4tot(gr4tot);
		                purchaselist.setGr5tot(gr5tot);
		                purchaselist.setGr6tot(gr6tot);
		                purchaselist.setGr7tot(gr7tot);
		                purchaselist.setGr8tot(gr8tot);
		              
		              
		                purchaselist.setJutevar(Jute_Variety);
		                purchaselist.setPlacepur(dpcname);
		                purchaselist.setCropYear(Crop_Year);
		                purchaselist.setBasis(Basis);
		                purchaselist.setFromtoDate(fromtoDate);
		                
		                
		            }
		            mv.addObject("allPurchaseReport", allPurchaseReport);
		            JasperReport jasperReport1 = JasperCompileManager.compileReport("E:\\Program Files\\Apache Software Foundation\\Tomcat 8.5\\webapps\\PDF_Report\\DPC-WISE PURCHASE REPORT1.jrxml");
		        	
	                Map<String, Object> parameters = new HashMap<String, Object>();
	                // Prepare data sources
	                JRBeanCollectionDataSource dataSource1 = new JRBeanCollectionDataSource(allPurchaseReport);

	                // Fill JasperPrints
	                JasperPrint jasperPrint1 = JasperFillManager.fillReport(jasperReport1, parameters, dataSource1);
	             response.setContentType("application/pdf");
	                response.setHeader("Content-Disposition", "attachment; filename=Purchase Report.pdf");
	                 try (ServletOutputStream out = response.getOutputStream()) {
	                 JRPdfExporter exporter = new JRPdfExporter();
	                 exporter.setParameter(JRPdfExporterParameter.JASPER_PRINT, jasperPrint1);
	              //   exporter.setParameter(JRPdfExporterParameter.JASPER_PRINT, jasperPrint.get(1));
	                 exporter.setParameter(JRPdfExporterParameter.OUTPUT_STREAM, out);
	                 exporter.exportReport();
	             }
	             catch (Exception e) {
	 	            System.out.println(e.getLocalizedMessage());
	 	        }
	           
	    }
	    catch (Exception e) {
	        System.out.println(e.getLocalizedMessage());
	    }
	    
	     
	    return mv;
	}
		 
		 
			@RequestMapping("viewAction")
			public ModelAndView viewAction(HttpServletRequest request,RedirectAttributes red)
			{	String username =(String)request.getSession().getAttribute("usrname");
			    ModelAndView mv = new ModelAndView("viewAction");
			     if(username == null) {
			     	return mv = new ModelAndView("index");
			         }
				 final List<UserActionModel> alluseractionlist = (List<UserActionModel>)this.useractionservice.getAll();
				 mv.addObject("useractionlist", (Object)alluseractionlist);
				 return mv;
			}
			
			@RequestMapping("deleteAction")
			public ModelAndView deleterolename(HttpServletRequest request,RedirectAttributes redirectAttributes)
			{	 
				String username =(String)request.getSession().getAttribute("usrname");
				if(username == null) {
		     	return new ModelAndView("index");
	        }
				
				ModelAndView mv = new ModelAndView("viewAction");
				String actionname = request.getParameter("actionname");
			    this.useractionservice.deleteAction(actionname);
			    final List<UserActionModel> alluseractionlist = (List<UserActionModel>)this.useractionservice.getAll();
				 mv.addObject("useractionlist", (Object)alluseractionlist);
				
				return mv;
			}
	 
}
