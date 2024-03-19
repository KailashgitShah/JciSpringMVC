
package com.jci.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import com.jci.model.PaymentInstrumentModel;
import com.jci.model.UploadingReceiptModel;
import com.jci.model.UserActionModel;
import com.jci.model.UserPriviligeModel;
import com.jci.model.UserRoleModel;
import com.jci.model.labelGenerationModel;
import com.jci.service.DailyPurchaseModelConfService;
import com.jci.service.EntryofsaleService;
import com.jci.service.HoDispatchService;
import com.jci.service.PaymentInstrumentService;
import com.jci.service.RawJuteProcurementAndPaymentService;
import com.jci.service.UploadRecieptService;
import com.jci.service.UserActionService;
import com.jci.service.UserPriviligeService;
import com.jci.service.UserRoleService;
import com.jci.service.labelGenerationService;
import com.google.gson.Gson;
import com.jci.model.EntryofSaleModel;
import com.jci.model.FarmerRegistrationModel;
import com.jci.model.HODispatchInstructionModel;
import com.jci.model.EntryofpcsoModel;

@Controller
public class InsertDataController_2 {
	
	@Autowired
	private PaymentInstrumentService paymentinstrumentservice;
	
	@Autowired
	private HoDispatchService hodispatchservice;
	
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
		  System.err.println("#########"+uPri.toString());
		  
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
	  
	  
		///////////// inventory////////////////////////

		@RequestMapping(value = "inventory")
		public ModelAndView firstLevel(HttpServletRequest request, RedirectAttributes redirectAttributes,
				HttpSession session) {
			String username = (String) request.getSession().getAttribute("usrname");
			if (username == null) {
				return new ModelAndView("index");
			} else {

				ModelAndView mv = new ModelAndView("Inventory");
				List<Double> jute = dailyPurchaseModelConfService.firstLeveljute("2022-2023", "msp");
				List<Integer> bale = dailyPurchaseModelConfService.firstLevelbale("2022-2023", "msp");
				mv.addObject("jute", jute);
				mv.addObject("bale", bale);

				return mv;
			}
		}

		@ResponseBody
		@RequestMapping(value = { "inventoryjute" }, method = { RequestMethod.GET })
		public String inventoryjute(HttpServletRequest request, RedirectAttributes redirectAttributes,
				HttpSession session) {

			String cropyr = request.getParameter("cropyr");
			String basis = request.getParameter("basis");

			List<Double> jute = dailyPurchaseModelConfService.firstLeveljute(cropyr, basis);
			final Gson gson = new Gson();
			return gson.toJson((Object) (jute));

		}

		@ResponseBody
		@RequestMapping(value = { "inventorybale" }, method = { RequestMethod.GET })
		public String inventorybale(HttpServletRequest request, RedirectAttributes redirectAttributes,
				HttpSession session) {

			String cropyr = request.getParameter("cropyr");
			String basis = request.getParameter("basis");
			List<Integer> bale = dailyPurchaseModelConfService.firstLevelbale(cropyr, basis);
			final Gson gson = new Gson();
			return gson.toJson((Object) (bale));

		}


		/////////////////////////////////////////////////

	 
}
