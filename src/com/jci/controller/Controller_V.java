package com.jci.controller;

import static org.hamcrest.CoreMatchers.nullValue;

import java.io.BufferedReader;
import java.io.Console;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.math.BigInteger;
import java.net.URL;
import java.net.URLConnection;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Base64.Encoder;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FileUtils;
import org.apache.http.impl.bootstrap.HttpServer;
import org.apache.log4j.lf5.viewer.categoryexplorer.TreeModelAdapter;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.bouncycastle.jce.provider.BrokenJCEBlockCipher.BrokePBEWithMD5AndDES;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import com.google.gson.Gson;
import com.itextpdf.text.pdf.PdfStructTreeController.returnType;
import com.jci.common.Encry;
import com.jci.model.CashDocumentModel;
import com.jci.model.ConfirmationClaimSettlementModel;
import com.jci.model.Contractgeneration;
import com.jci.model.CreditNotes;
import com.jci.model.EntryDerivativePrice;
import com.jci.model.EntryPaymentDetailsModel;
import com.jci.model.EntryofGradeCompositionModel;
import com.jci.model.EntryofpcsoModel;
import com.jci.model.FactorssInvolvedCommercial;
import com.jci.model.FinancialConcurenceModel;
import com.jci.model.GenerationOfBillSupplyModel;
import com.jci.model.GenrationDEmandDto;
import com.jci.model.GenrationDemandNoteModel;
import com.jci.model.JciDIHoModel;
import com.jci.model.MillRecieptModel;
import com.jci.model.OperationAndTransportCostModel;
import com.jci.model.OperationCostModel;
import com.jci.model.PCSORequestLetter;
import com.jci.model.RoDetailsModel;
import com.jci.model.RoDispatchModel;
import com.jci.model.StateList;

import com.jci.model.settlemetCnDnModel;
import com.jci.service.DailyPurchaseModelConfService;
import com.jci.service.DistrictService;
import com.jci.service.PurchaseCenterService;
import com.jci.service.RoDetailsService;
import com.jci.service_phase2.ConfirmationofClaimSettlementService;
import com.jci.service_phase2.ContractGenerationService2;
import com.jci.service_phase2.CreditNoteGenerationService;
import com.jci.service_phase2.EntryDerivativePriceService2;
import com.jci.service_phase2.EntryofGradeCompositionService;
import com.jci.service_phase2.FactorssInvolvedCommercialService;
import com.jci.service_phase2.FinancialConcurenceService;
import com.jci.service_phase2.GenerationofBillService;
import com.jci.service_phase2.GenratedDemandNoteService;
import com.jci.service_phase2.GenrationCashDocumentService;
import com.jci.service_phase2.HOInstService;
import com.jci.service_phase2.MillAccept;
import com.jci.service_phase2.MillRecieptService;
import com.jci.service_phase2.OperationAndTransportCostService;
import com.jci.service_phase2.OperationCostService;
import com.jci.service_phase2.PCSOReqLetterService;
import com.jci.service_phase2.PaymentDetailService;
import com.jci.service_phase2.PaymentRealizationService;
import com.jci.service.StateService;
import com.jci.service.Impl.SendMail;
import com.jci.service.Impl_phase2.EmailSender;
import com.jci.service_phase2.PcsoentryService;
import com.jci.service_phase2.RoDispatchService;
import com.lowagie.text.DocumentException;

import antlr.TokenWithIndex;

import java.util.Calendar;

@Transactional
@Repository
@Controller
public class Controller_V {
	@Autowired
    HOInstService hoInstService;

	@Autowired
	MillAccept millacct;


	private final PdfGenerator_K pdfGenerator;

	@Autowired
	public Controller_V(PdfGenerator_K pdfGenerator) {
		this.pdfGenerator = pdfGenerator;
	}

	@Autowired
	private PaymentDetailService paymentDetailService;

	@Autowired
	FinancialConcurenceService financialConcurenceservice;

	@Autowired
	MillRecieptService millRecieptService;

	@Autowired
	GenratedDemandNoteService genratedDemandNoteService;

	@Autowired
	ConfirmationofClaimSettlementService confirmationofClaimSettlementService;

	@Autowired
	GenerationofBillService generationofBillService;

	@Autowired
	PcsoentryService pcsoentryservice;

	@Autowired
	ContractGenerationService2 contractGenerationService2;

	@Autowired
	EntryDerivativePriceService2 entryDerivativePriceService2;

	@Autowired
	EntryofGradeCompositionService entryofGradeCompositionService;

	@Autowired
	RoDispatchService roDispatchService;

	@Autowired
	StateService stateList;

	@Autowired
	DistrictService districtService;

	@Autowired
	CreditNoteGenerationService creditNoteGenerationService;

	@Autowired
	PaymentRealizationService paymentRealizationService;

	@Autowired
	RoDetailsService roDetailsservice;

	@Autowired
	DailyPurchaseModelConfService dailyPurchaseModelConfService;

	@Autowired
	PurchaseCenterService purchaseCenterService;

	@Autowired
	OperationAndTransportCostService operationCostservice;

	@Autowired
	FactorssInvolvedCommercialService factorsinvolvedservice;

//	@Autowired
//	DistrictService districtService;

	@Autowired
	SessionFactory sessionFactory;

	@Autowired
	OperationCostService operationcostservice;

	@Autowired
	GenrationCashDocumentService genrationCashDocumentService;

	protected Session currentSession() {
		return sessionFactory.getCurrentSession();
	}

	@Autowired
	PCSOReqLetterService genReqLetterService;
 
	
// generation of pcso request letter form	
	@RequestMapping("pcsoRequestLetter")

	public ModelAndView pcsoRequestLetter(HttpServletRequest request) {
		String username = (String) request.getSession().getAttribute("usrname");
		String cropYearString = (String) request.getSession().getAttribute("currCropYear");
		double contractedQty = genReqLetterService.getTotalContractedQty(cropYearString);
		ModelAndView mv = new ModelAndView("PCSORequestLetter");
       
		//get the inventory data
		List<String> cropYearList = dailyPurchaseModelConfService.getCropYear();
		List<Double> jute = dailyPurchaseModelConfService.firstLeveljute("2023-2024", "msp");
		List<Integer> bale = dailyPurchaseModelConfService.firstLevelbale("2023-2024", "msp");
		mv.addObject("jute", jute);
		mv.addObject("bale", bale);

		mv.addObject("totalContract", contractedQty);
		if (username == null) {
			mv = new ModelAndView("index");
		}

		List<PCSORequestLetter> topThreeRecords = genReqLetterService.getTopThreeRecords(cropYearString);
		mv.addObject("topThreeRecords", topThreeRecords);
		mv.addObject("distinctCropYear", cropYearList);

		return mv;
	}

	//get the letter head img path from config file
	@Value("${upload.letterHeadPath}")
	String letterHeadPath;

	//get the signature img path from config file
	@Value("${upload.SignaturePdf}")
	String SignaturePdf;

	
	//pcso request letter save controller
	@RequestMapping("generatePCSORequest")
	public ModelAndView generatePCSORequestLetter(HttpServletRequest request, RedirectAttributes redirectAttributes)
			throws ParseException, DocumentException, IOException {
		ModelAndView mv = new ModelAndView("PCSORequestLetter");
		String username = (String) request.getSession().getAttribute("usrname");
		if (username == null) {
			mv = new ModelAndView("index");
			return mv;
		}

		PCSORequestLetter requestLetter = new PCSORequestLetter();

		String referenceno = request.getParameter("referenceno");
		String reqDate = request.getParameter("reqDate");
		String crop_year = request.getParameter("cropyr");
		double system_qty = Double.parseDouble(request.getParameter("uncontractedQty"));
		double req_qty = Double.parseDouble(request.getParameter("reqQty"));
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");

		Date creationDateTime = new Date();
//		Date convertTodateDate = simpleDateFormat.parse(creationDateTime);
//		requestLetter.setCreationDateTime(creationDateTime);

		String creation_date = simpleDateFormat.format(creationDateTime);
		requestLetter.setReference_no(referenceno);
		requestLetter.setCropYear(crop_year);
		requestLetter.setSys_avail_qty(system_qty);
		requestLetter.setReq_qty(req_qty);
		requestLetter.setReqGenDate(reqDate);
		requestLetter.setCreation_date(creationDateTime);
		requestLetter.setLetter_path(referenceno + ".pdf");

		genReqLetterService.create(requestLetter);

		PdfGenerator pdfGenerator = new PdfGenerator();
		pdfGenerator.generatePdfOfRequestLetter(referenceno, crop_year, creation_date, req_qty + "",
				referenceno + ".pdf", requestLetterpath, letterHeadPath, SignaturePdf);

		redirectAttributes.addFlashAttribute("msg",
				"<div class=\"alert alert-success\"><b> Record Created successfully.</b></div>\r\n" + "");

		return new ModelAndView(new RedirectView("pcsoRequestLetterList.obj"));
	}

	
	//listing page of pcso reuqest letters
	@RequestMapping("pcsoRequestLetterList")
	public ModelAndView requestList() {
		ModelAndView mv = new ModelAndView("PCSORequestLetterList");
		List<PCSORequestLetter> letters = genReqLetterService.getLetters();

		mv.addObject("letters", letters);

		return mv;
	}
	
	//get the dir where we have to store the generated pdf
	@Value("${upload.requestLetter}")
	String requestLetterPath;

	
	//send thankyou mail to jc office
	@ResponseBody
	@RequestMapping(value = "sendThankYouEmailToJC", method = RequestMethod.GET)
	public void sendThankYouEmailToJC(HttpServletRequest request, RedirectAttributes redirectAttributes)
			throws AddressException {
		String refNo = request.getParameter("refNo");
		String date = request.getParameter("date");
		String cropYear = request.getParameter("cropYear");
		String qty = request.getParameter("qty");
		int id = Integer.parseInt(request.getParameter("id"));
		
		String filePath = requestLetterpath + File.separator + refNo + ".pdf"; 

		String sub = "Expressing Gratitude for Contract Approval";
		String body = "Dear Jute Commissioner Officer ,\n " + "Hope This email finds you well ,\n"
				+ "Thank you for accepting the pco request of reference no : " + refNo + "\n " + "contract Date : "
				+ date + "\n " + "Under this crop year " + cropYear + "\n" + " requested qty " + qty + "\n "
				+ "Thanks & Regards \n " + "Jute Corporation Of India";

		InternetAddress[] toAddresses = {  new InternetAddress("cyfuturetest@gmail.com"),
				new InternetAddress("pradeepcyf24@gmail.com") };

		SendMail sendMail = new SendMail();

		CompletableFuture.runAsync(() -> {
			try {
				sendMail.sendEmail(toAddresses, body, sub, filePath , refNo+".pdf");
				// Your email sending code here
			} catch (Exception e) {
				e.printStackTrace();
			}
		});

		genReqLetterService.setEmailStatus(id, 1);

//		return new ResponseEntity<>("{\"redirect\": \"pcsoRequestLetterList.obj\"}", HttpStatus.OK);
		// return new ModelAndView("pcsoRequestLetterList.obj");

	}

	//get file from the server
	@Value("${upload.requestLetter}")
	String requestLetterpath;
	
  
	// pcso letter download
	@RequestMapping(value = "downloadRequestLetter", method = RequestMethod.GET)
	public void downloadRequestLetter(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String fileName = request.getParameter("imagePath");
		String fullPath = requestLetterpath + File.separator + fileName;
		System.err.println(fullPath);
		File imageFile = new File(fullPath);

		if (imageFile.exists()) {
			try {
				// Set the content type based on the file type
				response.setContentType("application/pdf");

				// download
				// response.setHeader("Content-Disposition", "attachment; filename=" +
				// fileName);

				// view
				response.setHeader("Content-Disposition", "");

				// Stream the file content to the response
				FileInputStream fileInputStream = new FileInputStream(imageFile);
				OutputStream responseOutputStream = response.getOutputStream();

				byte[] buffer = new byte[1024];
				int bytesRead;
				while ((bytesRead = fileInputStream.read(buffer)) != -1) {
					responseOutputStream.write(buffer, 0, bytesRead);
				}

				fileInputStream.close();
				responseOutputStream.close();
			} catch (IOException e) {
				// Handle IO exception
				e.printStackTrace();
				response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
			}
		} else {
			response.setStatus(HttpServletResponse.SC_NOT_FOUND);
		}

	}

	//get the contract letter path
	@Value("${upload.contractLetterJava}")
	String contractLetterJava;

	//download contract letter
	@RequestMapping(value = "downloadContractLetter", method = RequestMethod.GET)
	public void downloadContractLetter(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String fileName = request.getParameter("imagePath");
		String fullPath = contractLetterJava + File.separator + fileName;
		System.err.println(fullPath);
		File imageFile = new File(fullPath);

		if (imageFile.exists()) {
			try {
				// Set the content type based on the file type
				response.setContentType("application/pdf");

				// download
				// response.setHeader("Content-Disposition", "attachment; filename=" +
				// fileName);

				// view
				response.setHeader("Content-Disposition", "");

				// Stream the file content to the response
				FileInputStream fileInputStream = new FileInputStream(imageFile);
				OutputStream responseOutputStream = response.getOutputStream();

				byte[] buffer = new byte[1024];
				int bytesRead;
				while ((bytesRead = fileInputStream.read(buffer)) != -1) {
					responseOutputStream.write(buffer, 0, bytesRead);
				}
				fileInputStream.close();
				responseOutputStream.close();
			} catch (IOException e) {
				// Handle IO exception
				e.printStackTrace();
				response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
			}
		} else {
			response.setStatus(HttpServletResponse.SC_NOT_FOUND);
		}

	}

	//delete pcso request
	@RequestMapping("pcsoRequestDelete")
	public ModelAndView requestDelete(HttpServletRequest request, RedirectAttributes redirectAttributes)
			throws ParseException {
		String username = (String) request.getSession().getAttribute("usrname");
		if (username == null) {
			return new ModelAndView("index");
		}

		int id = Integer.parseInt(request.getParameter("reqId"));
		genReqLetterService.delete(id);
		redirectAttributes.addFlashAttribute("msg",
				"<div class=\"alert alert-success\"><b>Success !</b> Record deleted successfully.</div>\r\n" + "");

		return new ModelAndView(new RedirectView("pcsoRequestLetterList.obj"));

	}

	// ---------------------------------------------------------
	// Entry Of PCSO
	// ---------------------------------------------------------
	
	//form page of entryofPcso
	@RequestMapping("entryofpcso")
	public ModelAndView EntryofpcsoModel(HttpServletRequest request, RedirectAttributes redirectAttributes) {
		String username = (String) request.getSession().getAttribute("usrname");
		ModelAndView mv = new ModelAndView("entryofpcso");
		String referenceno = request.getParameter("referenceno");
		if (referenceno != null) {
			String pcsodate = request.getParameter("pcsodate");
			String pcsoReqdate = request.getParameter("pcsoReqDate");
			String pcsoQty = request.getParameter("pcsoQty");
			String pcsoReqQty = request.getParameter("pcsoReqQty");
			String letterRefNo = request.getParameter("letterRefNo");
			String juteRatio = request.getParameter("juteRatio");
			String dispatchPeriod = request.getParameter("dispatchPeriod");

			mv.addObject("referenceno", referenceno);
			mv.addObject("pcsoQty", pcsoQty);
			mv.addObject("pcsoReqQty", pcsoReqQty);
			mv.addObject("pcsodate", pcsodate);
			mv.addObject("pcsoReqdate", pcsoReqdate);
			mv.addObject("letterRefNo", letterRefNo);
			mv.addObject("dispatchPeriod", dispatchPeriod);
			mv.addObject("juteRatio", juteRatio);

		}
		final List<Object[]> allentryofpcsolist = this.pcsoentryservice.getAlldata();
		List<String> allRequestLetterRefNo = this.pcsoentryservice.getAllRequest();
		mv.addObject("entryofpcsolist", allentryofpcsolist);
		mv.addObject("allRefNo", allRequestLetterRefNo);
		if (username == null) {
			mv = new ModelAndView("index");
		}
		return mv;
	}

	//disable screen with all prefield value
	@RequestMapping("entryofpcsosave")
	public ModelAndView saveUserMid(HttpServletRequest request, RedirectAttributes redirectAttributes) {
		String username = (String) request.getSession().getAttribute("usrname");
		ModelAndView mv = new ModelAndView("entryofpcsosave");
		if (username == null) {
			mv = new ModelAndView("index");
		}

		try {
			List<EntryofpcsoModel> ll = new ArrayList<EntryofpcsoModel>();
			int count = Integer.valueOf(request.getParameter("count"));
			String referenceno = request.getParameter("referenceno");
			String pcsoDate = request.getParameter("pcsoDate");
			String dispatchPeriod = request.getParameter("dispatchPeriod");
			String letterRef = request.getParameter("letterRefNo");
			String pcsoReqDate = request.getParameter("pcsoReqdate");
			String juteRatio = request.getParameter("juteRatio");
			Double pcsoReqQty = Double.parseDouble(request.getParameter("pcsoReqQty"));
			Double pcsoQty = Double.parseDouble(request.getParameter("pcsoQty"));
 

			for (int c = 0; c < count; c++) {

				EntryofpcsoModel entryofpcsoCopy = new EntryofpcsoModel();
				entryofpcsoCopy.setCreated_date(new Date());
				entryofpcsoCopy.setDispatch_period(dispatchPeriod);
				entryofpcsoCopy.setJuteRatio(juteRatio);
				entryofpcsoCopy.setLetterPath("/localsystem");
				entryofpcsoCopy.setLetterRef(letterRef);
				// entryofpcsoCopy.setPcso_date(pcsodate);
				entryofpcsoCopy.setPcso_req_date(pcsoReqDate);
				entryofpcsoCopy.setPcso_date(pcsoDate);
				entryofpcsoCopy.setPcsoReqQty(pcsoReqQty);
				entryofpcsoCopy.setPcsoQty(pcsoQty);
				// entryofpcsoCopy.setReference_date(referencedate);
				entryofpcsoCopy.setReference_no(referenceno);

				String millcode = request.getParameter("millcode" + c);
				String millname = request.getParameter("millname" + c);
				Double tallocation = Double.parseDouble(request.getParameter("totalallocation" + c));
				if (tallocation != 0.0 && tallocation != null) {
					entryofpcsoCopy.setMill_code(millcode);
					entryofpcsoCopy.setMill_name(millname);
					entryofpcsoCopy.setAllocatedQty(tallocation);
					ll.add(entryofpcsoCopy);

				}

			}

			mv.addObject("entryofpcso", ll);
			mv.addObject("referenceno", referenceno);
			mv.addObject("pcsoReqDate", pcsoReqDate);
			mv.addObject("pcsoDate", pcsoDate);
			mv.addObject("letterRef", letterRef);
			mv.addObject("juteRatio", juteRatio);
			mv.addObject("deliveryPeriod", dispatchPeriod);
			mv.addObject("pcsoQty", pcsoQty);
			mv.addObject("pcsoReqQty", pcsoReqQty);

		} catch (Exception e) {
			System.out.println(e);
		}

		return mv;
	}

	//save Entry of pcso
	@RequestMapping("saveentryofpcsodata")
	public ModelAndView entryofpcsosave(HttpServletRequest request, RedirectAttributes redirectAttributes) {
		String username = (String) request.getSession().getAttribute("usrname");
		try {

			int count = Integer.valueOf(request.getParameter("count"));
			Date date = new Date();
			String referenceno = request.getParameter("referenceno");
			String pcsDate = request.getParameter("pcsoDate");
			String pcsoReqdate = request.getParameter("pcsoReqDate");
			String sumoftotalallocation = request.getParameter("sumoftotalallocation");
			Double pcsoQty = Double.parseDouble(request.getParameter("pcsoQty"));
			Double pcsoReqQty = Double.parseDouble(request.getParameter("pcsoReqQty"));

			String dispatchPeriod = request.getParameter("dispatchPeriod");
			String juteRatio = request.getParameter("juteRatio");
			String letterRef = request.getParameter("letterRefNo");

			for (int i = 0; i < count; i++) {

				// default values
				EntryofpcsoModel entryofpcso = new EntryofpcsoModel();
				entryofpcso.setDispatch_period(dispatchPeriod);
				entryofpcso.setJuteRatio(juteRatio);
				entryofpcso.setLetterPath("/localsystem");
				entryofpcso.setLetterRef(letterRef);
				entryofpcso.setReference_no(referenceno);
				entryofpcso.setPcso_req_date(pcsoReqdate);
				entryofpcso.setPcso_date(pcsDate);
				entryofpcso.setCreated_date(date);
				entryofpcso.setPcsoQty(pcsoQty);
				entryofpcso.setPcsoReqQty(pcsoReqQty);

				// dynamic values
				String millcode = request.getParameter("millcode" + i);
				String millname = request.getParameter("millname" + i);
				Double tallocation = Double.parseDouble(request.getParameter("totalallocation" + i));
				entryofpcso.setMill_code(millcode);
				entryofpcso.setMill_name(millname);
				entryofpcso.setAllocatedQty(tallocation);
				pcsoentryservice.create(entryofpcso);
			}
			redirectAttributes.addFlashAttribute("msg",
					"<div class=\"alert alert-success\"><b>Record created successfully.</b></div>\r\n" + "");

		} catch (Exception e) {
			System.out.println(e);
			e.printStackTrace();
		}
		if (username == null) {
			return new ModelAndView("index");
		}
		return new ModelAndView(new RedirectView("pcsolist.obj"));
	}

	//pcso listing page
	@RequestMapping("pcsolist")
	public ModelAndView pcsolist(HttpServletRequest request) {
		String username = (String) request.getSession().getAttribute("usrname");
		ModelAndView mv = new ModelAndView("pcsolist");
		List<EntryofpcsoModel> pcso = pcsoentryservice.getAllPcso();
		List<String> refNos = pcsoentryservice.getUniqueRefNos();
		mv.addObject("refNos", refNos);
		mv.addObject("pcsolist", pcso);
		if (username == null) {
			mv = new ModelAndView("index");
		}
		return mv;
	}


	//get mill details based on refno
	@ResponseBody
	@RequestMapping(value = { "getAllMillDetails" }, method = { RequestMethod.GET })
	public String getAllMillDetails(final HttpServletRequest request) {
		String refNo = request.getParameter("refNo");
		List<EntryofpcsoModel> allMills = this.pcsoentryservice.getAllMillDetailsOfRefNo(refNo);

		Gson gson = new Gson();
		return gson.toJson(allMills);

	}


	//pcso delete
	@RequestMapping("pcsoDelete")
	public ModelAndView pcsoDelete(HttpServletRequest request, RedirectAttributes redirectAttributes)
			throws ParseException {
		String username = (String) request.getSession().getAttribute("usrname");

		int id = Integer.parseInt(request.getParameter("pcsorefid"));
		pcsoentryservice.delete(id);
		redirectAttributes.addFlashAttribute("msg",
				"<div class=\"alert alert-success\"><b>Success !</b> List deleted successfully.</div>\r\n" + "");

		if (username == null) {
			return new ModelAndView("index");
		}
		return new ModelAndView(new RedirectView("pcsolist.obj"));

	}


	//update pcso
	@RequestMapping("updatePcso")
	public ModelAndView updatePcso(HttpServletRequest request) throws ParseException {
		int refId = Integer.parseInt(request.getParameter("pcsorefid"));

		ModelAndView mv = new ModelAndView("editPcso");
		String username = (String) request.getSession().getAttribute("usrname");
		if (username == null) {
			mv = new ModelAndView("index");
		}

		EntryofpcsoModel entryofpcso = pcsoentryservice.getPcso(refId);
		System.out.println(entryofpcso.toString());
		mv.addObject("pcso", entryofpcso);

		return mv;
	}


	//updating pcso details
	@RequestMapping("updatesavePcso")
	public ModelAndView updatesavePcso(HttpServletRequest request, RedirectAttributes redirectAttributes)
			throws ParseException {
		String username = (String) request.getSession().getAttribute("usrname");
		if (username == null) {
			return new ModelAndView("index");
		}

		int refid = Integer.parseInt(request.getParameter("pcsorefid"));

		EntryofpcsoModel entryofpcsoModel = this.pcsoentryservice.getPcso(refid);

		Double totalallocation = Double.parseDouble(request.getParameter("totalallocation"));

		entryofpcsoModel.setAllocatedQty(totalallocation);

		pcsoentryservice.create(entryofpcsoModel);

		redirectAttributes.addFlashAttribute("msg",
				"<div class=\"alert alert-success\"><b>Success !</b> PCSO Record updated successfully.</div>\r\n" + "");
		return new ModelAndView(new RedirectView("pcsolist.obj"));
	}

	//contract generation page
	@RequestMapping("contractgenerationPCSOWise")
	public ModelAndView contractgenerationShow(HttpServletRequest req) {
		String username = (String) req.getSession().getAttribute("usrname");
		ModelAndView mv = new ModelAndView("contractgeneration");

		if (username == null) {
			mv = new ModelAndView("index");
			return mv;
		}

		List<String> pcso = pcsoentryservice.getAllDates();
		List<Object> allJuteCombination = entryofGradeCompositionService.getAllJuteCombination();
		int count = pcsoentryservice.getCountOfTotalEntries();
		List<String> gradeCompositionLable = pcsoentryservice.getAllLables();
		mv.addObject("pcsoDates", (Object) pcso);
		mv.addObject("count", count);
		mv.addObject("gradeCompositionLable", gradeCompositionLable);
		mv.addObject("allJuteVariety", allJuteCombination);
		return mv;
	}

	//get the contract letter path from config file
	@Value("${upload.contractLetter}")
	String contractLetterPath;
    
	//saving the grade composition and also generation of the contract letter of the mill, its also having func of pdg generation and sending email
	@ResponseBody
	@RequestMapping(value = "contractgenerationPcsoWiseSave", method = { RequestMethod.POST })
	public String saveContractGenerationPcsoWise(HttpServletRequest request,
			@RequestBody Map<String, Object> requestBody)
			throws IOException, ParseException, DocumentException, AddressException {

		String cropYear = (String) request.getSession().getAttribute("currCropYear");
		ModelAndView mv = new ModelAndView("contractgeneration");

		List<Map<String, String>> millDetails = (List<Map<String, String>>) requestBody.get("millDetails");

		int refId = (Integer) request.getSession().getAttribute("userId");

		String contractIdn = (String) requestBody.get("contractIdn");
		int SortingId = Integer.parseInt((String) requestBody.get("SortingId"));
		String contractQty = (String) requestBody.get("contractQty");
		String contractdate = (String) requestBody.get("contractdate");

		String pcsoDate = (String) requestBody.get("pcsoDate");
		String gradeComp = (String) requestBody.get("gradeComp");
		//String juteVariety = (String) requestBody.get("juteVariety");

		pcsoDate = pcsoDate.replaceAll("\\[", "").replaceAll("\\]", "").replaceAll("\"", "'");
		gradeComp = gradeComp.replaceAll("\\[", "").replaceAll("\\]", "").replaceAll("\"", "'");

		final List<String> gradeArray = Arrays.asList(gradeComp.split(","));
		//final List<String> juteArray = Arrays.asList(juteVariety.split(","));
//		
//		for(String jutString : juteArray)
//		System.err.println(jutString);

		// entry of grade composition....

		String lableName = (String) requestBody.get("labelName");
		String remarks = (String) requestBody.get("remarks");
		Double availableQty = Double.parseDouble((String) requestBody.get("availableQty"));

		Date date = new Date();
		SimpleDateFormat simpleDateTimeFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String dateFormater = simpleDateTimeFormat.format(date);
		Date created_Date = null;

		try {
			created_Date = simpleDateTimeFormat.parse(dateFormater);
		} catch (Exception e) {
			// TODO: handle exception
		}

		List<Object> allJuteCombination = entryofGradeCompositionService.getAllJuteCombination();
		List<String> varietyArray = new ArrayList<>();

		int idx = 0;
		for (Object row : allJuteCombination) {
			Object[] rowData = (Object[]) row; // Cast each row to an Object array
			// Access individual columns by their index (0-based)
			Object variety = rowData[1];
			varietyArray.add((String)variety);
			Object systemComposition = rowData[2];
			EntryofGradeCompositionModel entryofGradeCompositionModel = new EntryofGradeCompositionModel();
			Double ProposedValue = Double.parseDouble(gradeArray.get(idx));
			Double systemValue = Double.parseDouble(systemComposition + "");
			entryofGradeCompositionModel.setJute_combination((String) variety);
			entryofGradeCompositionModel.setSystem_composition(systemValue);
			entryofGradeCompositionModel.setProposed_composition(ProposedValue);
			entryofGradeCompositionModel.setRemark(remarks);
			entryofGradeCompositionModel.setCrop_year(cropYear);
			entryofGradeCompositionModel.setAvailable_qty(availableQty);
			entryofGradeCompositionModel.setLabel_name(lableName);
			entryofGradeCompositionModel.setCreated_by(refId);
			entryofGradeCompositionModel.setCreated_date(created_Date);
			entryofGradeCompositionService.create(entryofGradeCompositionModel);
			idx++;
		}

		///

		for (Map<String, String> millDetail : millDetails) {
			Contractgeneration contractgeneration = new Contractgeneration();

			Double juteValue = Double.parseDouble(millDetail.get("juteValue"));
			String millCode = millDetail.get("millCode");
			String millNameString = millDetail.get("millName");
			Double millQty = Double.parseDouble(millDetail.get("Qty"));
			String deliveryType = millDetail.get("delivery_type");
			String finalGeneratedContractNo = "JCI/" + millCode + "/" + cropYear + "/" + contractIdn;
			contractgeneration.setPcso_date(pcsoDate);
			contractgeneration.setContract_identification_no(contractIdn);
			contractgeneration.setContract_qty(contractQty);
			contractgeneration.setContract_date(contractdate);
			contractgeneration.setDelivery_type(deliveryType);
			contractgeneration.setContract_no(finalGeneratedContractNo);
			// contract value = 110% of jute value
			contractgeneration.setContract_value(juteValue * 1.1);
			contractgeneration.setCreated_date(new Date());
			contractgeneration.setCreated_by(refId);
			contractgeneration.setGrade_composition(lableName);
			contractgeneration.setMill_code(millCode);
			contractgeneration.setCropYear(cropYear);
			contractgeneration.setMill_name(millNameString);
			contractgeneration.setJute_value(juteValue);
			contractgeneration.setMill_qty(millQty);
			contractgeneration.setSortingId(SortingId);
			String fileName = contractIdn + "Contract" + millCode + ".pdf";
			contractgeneration.setContract_acceptance_doc(fileName);

			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
			LocalDate currentDate = LocalDate.now();
			LocalDate tenDaysAfter = currentDate.plusDays(10); // Add 10 days
			contractgeneration.setPayment_duedate(tenDaysAfter.format(formatter));

			PdfGenerator pdfGenerator = new PdfGenerator();
			List<Object[]> GradePriceList = contractGenerationService2.getListOfGradesPrice(cropYear);
			// List<Object[]> GradeCompList =
			// contractGenerationService2.getListOfGradeComposition(gradeComp);

			String filePath = contractLetterPath + File.separator + contractIdn;

			// System.err.println(filePath);

			File parentDir = new File(filePath);
			if (!parentDir.exists()) {
				parentDir.mkdirs();
			}

			filePath += File.separator + contractIdn + "Contract" + millCode + ".pdf";

			pdfGenerator.generatePdf(finalGeneratedContractNo, millNameString, millCode, millQty, cropYear,
					GradePriceList, gradeArray , varietyArray, fileName, deliveryType, contractdate, filePath, letterHeadPath);

			// send email
			String body = "Please find below attachment to get full details of contract grade wise..";
			String sub = "Contract Details";
			final String filePathDir = filePath;
			SendMail sendMail = new SendMail();
			InternetAddress[] toAddresses = {  new InternetAddress("cyfuturetest@gmail.com"),
					new InternetAddress("pradeepcyf24@gmail.com") };

			CompletableFuture.runAsync(() -> {
				try {
					sendMail.sendEmail(toAddresses, body, sub, filePathDir, fileName);
				} catch (Exception e) {
					e.printStackTrace();
				}
			});

			contractGenerationService2.create(contractgeneration);
		}

		return "Saved";
	}

	//listing of the contract list
	@RequestMapping("viewcontractgeneration")
	public ModelAndView viewContractGenerationList(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView("contractgenerationlist");
		String username = (String) request.getSession().getAttribute("usrname");
		if (username == null) {
			mv = new ModelAndView("index");
		}

		List<Contractgeneration> listOfAllContract = contractGenerationService2.getAllContract();
		mv.addObject("contracts", listOfAllContract);
		return mv;
	}

	//get details of the contract on the basis of the pcso dates
	@ResponseBody
	@RequestMapping(value = { "getAllContractDetails" }, method = { RequestMethod.GET })
	public String getAllContractDetails(final HttpServletRequest request) {
		String contractidn = request.getParameter("contract");
		List<Contractgeneration> allMillUnderContract = this.contractGenerationService2
				.getContractFullDetails(contractidn);

		Gson gson = new Gson();
		return gson.toJson(allMillUnderContract);

	}

//
//	@ResponseBody
//	@RequestMapping(value = "pcsoDates", method = RequestMethod.GET)
//	public List<String> pcsoDates(final HttpServletRequest request) {
//		List<String> pcso = pcsoentryservice.getAllDates();
//		return pcso;
//	}
//

	@ResponseBody
	@RequestMapping(value = "pcso_details", method = RequestMethod.GET)
	public String pcso_details(HttpServletRequest request) {

		String pcsoDates = request.getParameter("pcso_dates");
		String grades = request.getParameter("grades");

		// String deliveryType = request.getParameter("deliveryType");

		pcsoDates = pcsoDates.replaceAll("\\[", "").replaceAll("\\]", "").replaceAll("\"", "'");
		grades = grades.replaceAll("\\[", "").replaceAll("\\]", "").replaceAll("\"", "'");

		final List<String> pcsoArray = Arrays.asList(pcsoDates.split(","));
		final List<String> gradeArray = Arrays.asList(grades.split(","));

		ModelAndView pcso = contractGenerationService2.pcso_details(pcsoArray, gradeArray);
		Gson gson = new Gson();
		return gson.toJson(pcso);

	}

	//update price on the basis of delivery type
	@ResponseBody
	@RequestMapping(value = "updateContractedValue", method = RequestMethod.GET)
	public String updateContractedValue(final HttpServletRequest request) {

		String deliveryType = request.getParameter("deliveryType");
		String totalQtyOfMill = request.getParameter("totalQtyOfMill");

		System.err.println(deliveryType + " , " + totalQtyOfMill);

		int updatedVal = contractGenerationService2.updateContractedValue(deliveryType, totalQtyOfMill);

		return updatedVal + "";
	}

	//////////////////////////////////////////////////////////////////
	// Pradeep code Starts
	//////////////////////////////////////////////////////////////////

	// ---------------------------------------------------------
	// Entry Of Derivative Price
	// ---------------------------------------------------------

	//derivative price form
	@RequestMapping("entry_derivativeprice")
	public ModelAndView ViewEDPrice(HttpServletRequest request) {
		String username = (String) request.getSession().getAttribute("usrname");
		List<StateList> Liststate = stateList.getAll();
		ModelAndView mv = new ModelAndView("entry_derivativeprice2");
		mv.addObject("Liststate", Liststate);
		if (username == null) {
			mv = new ModelAndView("index");
		}
		return mv;
	}
	
	//edit page of the derivative price
	@RequestMapping("editentryderivativeprice")
	public ModelAndView editEDP(HttpServletRequest request) throws NumberFormatException, Exception {
		String username = (String) request.getSession().getAttribute("usrname");
		ModelAndView mv = new ModelAndView("editentryderivativeprice2");

		int der_id = Integer.parseInt(request.getParameter("der_id"));

		// String StringderId = request.getParameter("der_id");

		// EncodeId encodeId = new EncodeId();

		// SecretKey secretKey = (SecretKey)
		// request.getSession().getAttribute("SecretKey");

		// int der_id = Integer.parseInt(encodeId.decrypt(StringderId, secretKey));
		EntryDerivativePrice entryDerivativePrice = this.entryDerivativePriceService2.findEDPBYId(der_id);
		mv.addObject("derivativePrice", entryDerivativePrice);
		List<StateList> liststate = stateList.getAll();
		mv.addObject("Liststate", liststate);
		if (username == null) {
			mv = new ModelAndView("index");
		}
		return mv;
	}

	//update the ED price
	@RequestMapping("updateEDPrice")
	public ModelAndView updateEDC(HttpServletRequest request, RedirectAttributes redirectAttributes) {
		String username = (String) request.getSession().getAttribute("usrname");
		try {
			int der_id = Integer.parseInt(request.getParameter("der_id"));
			// System.out.println("===id model==>>>>>>>>>>>=== " + der_id);
			EntryDerivativePrice entryDerivativePrice = this.entryDerivativePriceService2.findEDPBYId(der_id);

			String grade1 = request.getParameter("grade1");
			String grade2 = request.getParameter("grade2");
			String grade3 = request.getParameter("grade3");
			String grade4 = request.getParameter("grade4");
			String grade5 = request.getParameter("grade5");
			String grade6 = request.getParameter("grade6");

			entryDerivativePrice.setDer_id(der_id);

			entryDerivativePrice.setGrade1(grade1 != "" ? grade1 : "0");
			entryDerivativePrice.setGrade2(grade2 != "" ? grade2 : "0");
			entryDerivativePrice.setGrade3(grade3 != "" ? grade3 : "0");
			entryDerivativePrice.setGrade4(grade4 != "" ? grade4 : "0");
			entryDerivativePrice.setGrade5(grade5 != "" ? grade5 : "0");
			entryDerivativePrice.setGrade6(grade6 == null || grade6 == "" ? "0" : grade6);

			Date date = new Date();
			SimpleDateFormat simpleDateTimeFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
			String dateFormater = simpleDateTimeFormat.format(date);
			Date updateDate = null;

			try {
				updateDate = simpleDateTimeFormat.parse(dateFormater);
			} catch (Exception e) {
				// TODO: handle exception
			}

			entryDerivativePrice.setUpdateDateAndTime(updateDate);
			this.entryDerivativePriceService2.update(entryDerivativePrice);
			redirectAttributes.addFlashAttribute("msg",
					"<div class=\"alert alert-success\"><b>Success !</b> Record saved successfully.</div>\r\n" + "");
		} catch (Exception e) {
			System.out.println(e);
		}
		if (username == null) {
			return new ModelAndView("index");
		}
		return new ModelAndView(new RedirectView("entryderivativepricelist.obj"));
	}

	
	//listing of the price list
	@RequestMapping("entryderivativepricelist")
	public ModelAndView EntryDerivativePrice(HttpServletRequest request) {
		String username = (String) request.getSession().getAttribute("usrname");
		List<EntryDerivativePrice> edp = entryDerivativePriceService2.getAllEDP();
		ModelAndView mv = new ModelAndView("entryderivativepricelist2");
		mv.addObject("edp", edp);
		if (username == null) {
			mv = new ModelAndView("index");
		}
		return mv;
	}

	//delete controller
	@RequestMapping("entryderivativepriceDelete")
	public ModelAndView entryderivativepriceDelete(HttpServletRequest request, RedirectAttributes redirectAttributes)
			throws ParseException {
		String username = (String) request.getSession().getAttribute("usrname");
		// ModelAndView mv = new ModelAndView("entryderivativepricelist2");
		int id = Integer.parseInt(request.getParameter("der_id"));
		entryDerivativePriceService2.delete(id);
		redirectAttributes.addFlashAttribute("msg",
				"<div class=\"alert alert-success\"><b>Success !</b> List deleted successfully.</div>\r\n" + "");
		if (username == null) {
			return new ModelAndView("index");
		}
		return new ModelAndView(new RedirectView("entryderivativepricelist.obj"));

	}

	//save ed price
	@RequestMapping("saveEDPrice")
	public ModelAndView derivativePriceHandler(HttpServletRequest request) {

		String crop_year = request.getParameter("crop_year");
		String delivery_type = request.getParameter("delivery_type");
		String state_id = request.getParameter("state");
		String state_code = stateList.getStateCode(state_id);
		String state_name = stateList.find(Integer.parseInt(state_id)).getState_name();
		int refId = (Integer) request.getSession().getAttribute("userId");

		Date date = new Date();
		SimpleDateFormat simpleDateTimeFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String dateFormater = simpleDateTimeFormat.format(date);
		Date created_Date = null;

		try {
			created_Date = simpleDateTimeFormat.parse(dateFormater);
		} catch (Exception e) {
			// TODO: handle exception
		}

		String status = "0";

		String[] district_ids = request.getParameterValues("district");

		for (String s : district_ids) {
			List<String> disStrings = Arrays.asList(s.split("-"));
			String idString = disStrings.get(0);
			String nameString = disStrings.get(1);
			String codeString = disStrings.get(2);

			EntryDerivativePrice entryDerivativePriceTossa = new EntryDerivativePrice();
			EntryDerivativePrice entryDerivativePriceWhite = new EntryDerivativePrice();
			EntryDerivativePrice entryDerivativePriceMesta = new EntryDerivativePrice();
			EntryDerivativePrice entryDerivativePriceBimli = new EntryDerivativePrice();

			entryDerivativePriceTossa.setCrop_year(crop_year);
			entryDerivativePriceTossa.setDelivery_type(delivery_type);
			entryDerivativePriceTossa.setState_id(state_id);
			entryDerivativePriceTossa.setState_name(state_name);
			entryDerivativePriceTossa.setState(state_code);
			entryDerivativePriceTossa.setDistrict_id(idString);
			entryDerivativePriceTossa.setDistrict_name(nameString);
			entryDerivativePriceTossa.setDistrict(codeString);
			entryDerivativePriceTossa.setCreated_by(refId);
			entryDerivativePriceTossa.setCreation_date(created_Date);
			entryDerivativePriceTossa.setStatus(status);

			entryDerivativePriceWhite.setCrop_year(crop_year);
			entryDerivativePriceWhite.setDelivery_type(delivery_type);
			entryDerivativePriceWhite.setState_id(state_id);
			entryDerivativePriceWhite.setState_name(state_name);
			entryDerivativePriceWhite.setState(state_code);
			entryDerivativePriceWhite.setDistrict_id(idString);
			entryDerivativePriceWhite.setDistrict_name(nameString);
			entryDerivativePriceWhite.setDistrict(codeString);
			entryDerivativePriceWhite.setCreated_by(refId);
			entryDerivativePriceWhite.setCreation_date(created_Date);
			entryDerivativePriceWhite.setStatus(status);

			entryDerivativePriceMesta.setCrop_year(crop_year);
			entryDerivativePriceMesta.setDelivery_type(delivery_type);
			entryDerivativePriceMesta.setState_id(state_id);
			entryDerivativePriceMesta.setState_name(state_name);
			entryDerivativePriceMesta.setState(state_code);
			entryDerivativePriceMesta.setDistrict_id(idString);
			entryDerivativePriceMesta.setDistrict_name(nameString);
			entryDerivativePriceMesta.setDistrict(codeString);
			entryDerivativePriceMesta.setCreated_by(refId);
			entryDerivativePriceMesta.setCreation_date(created_Date);
			entryDerivativePriceMesta.setStatus(status);

			entryDerivativePriceBimli.setCrop_year(crop_year);
			entryDerivativePriceBimli.setDelivery_type(delivery_type);
			entryDerivativePriceBimli.setState_id(state_id);
			entryDerivativePriceBimli.setState_name(state_name);
			entryDerivativePriceBimli.setState(state_code);
			entryDerivativePriceBimli.setDistrict_id(idString);
			entryDerivativePriceBimli.setDistrict_name(nameString);
			entryDerivativePriceBimli.setDistrict(codeString);
			entryDerivativePriceBimli.setCreated_by(refId);
			entryDerivativePriceBimli.setCreation_date(created_Date);
			entryDerivativePriceBimli.setStatus(status);

			// System.out.println(entryDerivativePrice.toString());

			String tgr1 = request.getParameter("tgr1") != "" ? request.getParameter("tgr1") : "0";
			String tgr2 = request.getParameter("tgr2") != "" ? request.getParameter("tgr2") : "0";
			;
			String tgr3 = request.getParameter("tgr3") != "" ? request.getParameter("tgr3") : "0";
			;
			String tgr4 = request.getParameter("tgr4") != "" ? request.getParameter("tgr4") : "0";
			;
			String tgr5 = request.getParameter("tgr5") != "" ? request.getParameter("tgr5") : "0";
			;
			String wgr1 = request.getParameter("wgr1") != "" ? request.getParameter("wgr1") : "0";
			;
			String wgr2 = request.getParameter("wgr2") != "" ? request.getParameter("wgr2") : "0";
			;
			String wgr3 = request.getParameter("wgr3") != "" ? request.getParameter("wgr3") : "0";
			;
			String wgr4 = request.getParameter("wgr4") != "" ? request.getParameter("wgr4") : "0";
			;
			String wgr5 = request.getParameter("wgr5") != "" ? request.getParameter("wgr5") : "0";
			;
			String mgr1 = request.getParameter("mgr1") != "" ? request.getParameter("mgr1") : "0";
			;
			String mgr2 = request.getParameter("mgr2") != "" ? request.getParameter("mgr2") : "0";
			;
			String mgr3 = request.getParameter("mgr3") != "" ? request.getParameter("mgr3") : "0";
			;
			String mgr4 = request.getParameter("mgr4") != "" ? request.getParameter("mgr4") : "0";
			;
			String mgr5 = request.getParameter("mgr5") != "" ? request.getParameter("mgr5") : "0";
			;
			String mgr6 = request.getParameter("mgr6") != "" ? request.getParameter("mgr6") : "0";
			;
			String bgr1 = request.getParameter("bgr1") != "" ? request.getParameter("bgr1") : "0";
			;
			String bgr2 = request.getParameter("bgr2") != "" ? request.getParameter("bgr2") : "0";
			;
			String bgr3 = request.getParameter("bgr3") != "" ? request.getParameter("bgr3") : "0";
			;
			String bgr4 = request.getParameter("bgr4") != "" ? request.getParameter("bgr4") : "0";
			;
			String bgr5 = request.getParameter("bgr5") != "" ? request.getParameter("bgr5") : "0";
			;
			String bgr6 = request.getParameter("bgr6") != "" ? request.getParameter("bgr6") : "0";
			;

			entryDerivativePriceTossa.setJute_variety("Tossa (New)");
			entryDerivativePriceTossa.setGrade1(tgr1);
			entryDerivativePriceTossa.setGrade2(tgr2);
			entryDerivativePriceTossa.setGrade3(tgr3);
			entryDerivativePriceTossa.setGrade4(tgr4);
			entryDerivativePriceTossa.setGrade5(tgr5);
			entryDerivativePriceTossa.setGrade6("0");

			entryDerivativePriceWhite.setJute_variety("White (New)");
			entryDerivativePriceWhite.setGrade1(wgr1);
			entryDerivativePriceWhite.setGrade2(wgr2);
			entryDerivativePriceWhite.setGrade3(wgr3);
			entryDerivativePriceWhite.setGrade4(wgr4);
			entryDerivativePriceWhite.setGrade5(wgr5);
			entryDerivativePriceWhite.setGrade6("0");

			entryDerivativePriceMesta.setJute_variety("Mesta");
			entryDerivativePriceMesta.setGrade1(mgr1);
			entryDerivativePriceMesta.setGrade2(mgr2);
			entryDerivativePriceMesta.setGrade3(mgr3);
			entryDerivativePriceMesta.setGrade4(mgr4);
			entryDerivativePriceMesta.setGrade5(mgr5);
			entryDerivativePriceMesta.setGrade6(mgr6);

			entryDerivativePriceBimli.setJute_variety("Bimli");
			entryDerivativePriceBimli.setGrade1(bgr1);
			entryDerivativePriceBimli.setGrade2(bgr2);
			entryDerivativePriceBimli.setGrade3(bgr3);
			entryDerivativePriceBimli.setGrade4(bgr4);
			entryDerivativePriceBimli.setGrade5(bgr5);
			entryDerivativePriceBimli.setGrade6(bgr6);

			entryDerivativePriceService2.create(entryDerivativePriceTossa);
			entryDerivativePriceService2.create(entryDerivativePriceWhite);
			entryDerivativePriceService2.create(entryDerivativePriceMesta);
			entryDerivativePriceService2.create(entryDerivativePriceBimli);

		}

		return new ModelAndView(new RedirectView("entryderivativepricelist.obj"));
	}

	// ---------------------------------------------------------
	// Entry Of Grade Composition
	// ---------------------------------------------------------

	//grade composition page
	@RequestMapping("entry_gradecomposition")
	public ModelAndView ViewGradeComposition(HttpServletRequest request) {
		String username = (String) request.getSession().getAttribute("usrname");
		ModelAndView mv = new ModelAndView("entryofgradecomposition");
		if (username == null) {
			mv = new ModelAndView("index");
		}

		List<Object> allJuteCombination = entryofGradeCompositionService.getAllJuteCombination();
		mv.addObject("allJuteVariety", allJuteCombination);
		return mv;
	}

	//save grade compo
	@RequestMapping("saveGradeComp")
	public ModelAndView saveGradeComposition(HttpServletRequest request, RedirectAttributes redirectAttributes) {

		String username = (String) request.getSession().getAttribute("usrname");
		ModelAndView mv = new ModelAndView(new RedirectView("entry_gradecomposition.obj"));
		redirectAttributes.addFlashAttribute("msg",
				"<div class=\"alert alert-success\"><b>Success !</b> Added successfully.</div>\r\n" + "");
		if (username == null) {
			mv = new ModelAndView("index");
		}

		String lableName = request.getParameter("labelname");
		String remark = request.getParameter("remark");
		String cropYear = request.getParameter("crop_year");
		int size = Integer.parseInt(request.getParameter("size"));
		Double availableQty = Double.parseDouble(request.getParameter("available_qty"));
		int refId = (Integer) request.getSession().getAttribute("userId");

		Date date = new Date();
		SimpleDateFormat simpleDateTimeFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String dateFormater = simpleDateTimeFormat.format(date);
		Date created_Date = null;

		try {
			created_Date = simpleDateTimeFormat.parse(dateFormater);
		} catch (Exception e) {
			// TODO: handle exception
		}

		for (int i = 1; i <= size; i++) {
			EntryofGradeCompositionModel entryofGradeCompositionModel = new EntryofGradeCompositionModel();
			String system_compositionString = request.getParameter("system" + i);
			String proposed_compositionString = request.getParameter("proposed" + i);
			Double ProposedValue = Double.parseDouble(proposed_compositionString);
			Double systemValue = Double.parseDouble(system_compositionString);
			entryofGradeCompositionModel.setJute_combination(request.getParameter("variety" + i));
			entryofGradeCompositionModel.setSystem_composition(systemValue);
			entryofGradeCompositionModel.setProposed_composition(ProposedValue);
			entryofGradeCompositionModel.setRemark(remark);
			entryofGradeCompositionModel.setCrop_year(cropYear);
			entryofGradeCompositionModel.setAvailable_qty(availableQty);
			entryofGradeCompositionModel.setLabel_name(lableName);
			entryofGradeCompositionModel.setCreated_by(refId);
			entryofGradeCompositionModel.setCreated_date(created_Date);

			entryofGradeCompositionService.create(entryofGradeCompositionModel);
		}

		return mv;
	}

	//delete grades
	@RequestMapping("entryofgradecompositiondelete")
	public ModelAndView entryofgradecompositiondelete(HttpServletRequest request, RedirectAttributes redirectAttributes)
			throws ParseException {
		String username = (String) request.getSession().getAttribute("usrname");
		// ModelAndView mv = new ModelAndView("entryderivativepricelist2");
		BigInteger gradeId = new BigInteger(request.getParameter("grade_id"));
		entryofGradeCompositionService.delete(gradeId);
		redirectAttributes.addFlashAttribute("msg",
				"<div class=\"alert alert-success\"><b>Success !</b> List deleted successfully.</div>\r\n" + "");
		if (username == null) {
			return new ModelAndView("index");
		}
		return new ModelAndView(new RedirectView("entrygradecompositionlist.obj"));

	}

	//listing of the grade composition 
	@RequestMapping("entrygradecompositionlist")
	public ModelAndView EntryGradeComposition(HttpServletRequest request) {
		String username = (String) request.getSession().getAttribute("usrname");
		if (username == null) {
			return new ModelAndView("index");
		}

		List<EntryofGradeCompositionModel> egc = entryofGradeCompositionService.getAllEGC();

		ModelAndView mv = new ModelAndView("entryofgradecompositionlist");
		mv.addObject("egc", egc);
		return mv;
	}

	//edit grade comp.
	@RequestMapping("editentryofgradecomposition")
	public ModelAndView EditeEntryOfGradeComposition(HttpServletRequest request) {
		String username = (String) request.getSession().getAttribute("usrname");
		List<Object> allJuteCombination = entryofGradeCompositionService.getAllJuteCombination();
		
		String key = LoginController.secretkey;
		String decryptedString = request.getParameter("grade_id");
		BigInteger gradeId = new BigInteger(Encry.decrypt(decryptedString, key));
		
		
//		BigInteger gradeId = new BigInteger(request.getParameter("grade_id"));
		EntryofGradeCompositionModel egc = (EntryofGradeCompositionModel) entryofGradeCompositionService.Edit(gradeId);

		ModelAndView mv = new ModelAndView("editGradeComposition");
		mv.addObject("allJuteVariety", allJuteCombination);
		mv.addObject("egc", egc);
		if (username == null) {
			mv = new ModelAndView("index");
		}
		return mv;
	}


	//update grade comp.
	@RequestMapping("updateGradeComp")
	public ModelAndView updateEGC(HttpServletRequest request, RedirectAttributes redirectAttributes) {
		String username = (String) request.getSession().getAttribute("usrname");
		if (username == null) {
			return new ModelAndView("index");
		}

		Date date = new Date();
		SimpleDateFormat simpleDateTimeFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String dateFormater = simpleDateTimeFormat.format(date);
		Date updatedDate = null;

		try {
			updatedDate = simpleDateTimeFormat.parse(dateFormater);
		} catch (Exception e) {
			// TODO: handle exception
		}

		BigInteger grade_id = new BigInteger(request.getParameter("grade_id"));
		String juteVariety = (String) request.getParameter("juteVariety");
		double newProposedComposition = Double.parseDouble(request.getParameter("grade"));
		EntryofGradeCompositionModel entryofGradeCompositionModel = entryofGradeCompositionService
				.getSpecificGradeComposition(grade_id);
		entryofGradeCompositionModel.setProposed_composition(newProposedComposition);
		entryofGradeCompositionModel.setUpdateDateAndTime(updatedDate);
		entryofGradeCompositionModel.setJute_combination(juteVariety);
		entryofGradeCompositionService.update(entryofGradeCompositionModel);
		return new ModelAndView(new RedirectView("entrygradecompositionlist.obj"));
	}

	// ---------------------------------------------------------
	// Ro Dispatch Instruction
	// ---------------------------------------------------------

	//ro dispatch view page
	@RequestMapping("roDispatchInstruction")
	public ModelAndView viewRoDispatcher(HttpServletRequest request) throws FileNotFoundException {
		String username = (String) request.getSession().getAttribute("usrname");
		if (username == null) {
			return new ModelAndView("index");
		}
		List<String> loadAllDpc = roDispatchService.loadAllDpc();
		List<String> loadAllDiNo = roDispatchService.loadAllDiNo();
		// int countAvaiResult = roDispatchService.getCountOfAvailableEntries();
		ModelAndView mv = new ModelAndView("roDispatchInstruction");
		mv.addObject("loadAllDpc", loadAllDpc);
		mv.addObject("loadAllDiNo", loadAllDiNo);
		// mv.addObject("count",countAvaiResult);

		///// generated new file /////////////////////////

		///////////////////////////////////////////////////////////

		return mv;
	}

	//save ro dispatch instruction
	@RequestMapping("saveRoDi")
	public ModelAndView saveRoDispatch(HttpServletRequest request, @ModelAttribute RoDispatchModel roDispatchModel,
			RedirectAttributes redirectAttributes) throws ParseException {

		String username = (String) request.getSession().getAttribute("usrname");
		if (username == null) {
			return new ModelAndView("index");
		}

		Date date = new Date();
		roDispatchModel.setCreationDate(date);
		String lastDateOFShipmentString = request.getParameter("lastDateOfShipment");
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat outPutDate = new SimpleDateFormat("dd-MM-yyyy");

		Date fomatedDate = dateFormat.parse(lastDateOFShipmentString);
		String finalStringDate = outPutDate.format(fomatedDate);
		roDispatchModel.setLastDateOfShipment(finalStringDate);
		System.out.println(roDispatchModel.toString());
		this.roDispatchService.create(roDispatchModel);
		redirectAttributes.addFlashAttribute("msg",
				"<div class=\"alert alert-success\"><b>Success !</b>data successfully.</div>\r\n" + "");

		return new ModelAndView(new RedirectView("roDispatchList.obj"));
	}

	//ro list
	@RequestMapping("roDispatchList")
	public ModelAndView roDiList(HttpServletRequest request) {

		String username = (String) request.getSession().getAttribute("usrname");
		if (username == null) {
			return new ModelAndView("index");
		}

		List<RoDispatchModel> allDi = roDispatchService.getAllRoDi();

		ModelAndView mv = new ModelAndView("diRoList");
		mv.addObject("roDiList", allDi);
		return mv;
	}

	// ---------------------------------------------------------
	// Generation Of Credit Notes
	// ---------------------------------------------------------

	//listing page of the volunteer credit note generation form
	@RequestMapping("generationOfCreditNoteList")
	public ModelAndView generationOfCreditNotes(HttpServletRequest request) {

		String username = (String) request.getSession().getAttribute("usrname");
		if (username == null) {
			return new ModelAndView("index");
		}

		List<Object[]> list = creditNoteGenerationService.getAllVerifiedWeighment();

		ModelAndView mView = new ModelAndView("generationOfCreditNotelist");

		mView.addObject("list", list);

		return mView;

	}

	//set all the contract details in session and redirect to the generate credit note form page in the ajax response
	@ResponseBody
	@RequestMapping(value = { "generateCrn" }, method = { RequestMethod.POST })
	public ModelAndView generateCrn(final HttpServletRequest request, RedirectAttributes redirectAttributes,
			HttpSession session) {
		final String shipmentDetails = request.getParameter("shipmentDetails");
		final Double nominalWt = Double.parseDouble(request.getParameter("nominalWeight"));
		final Double actualWt = Double.parseDouble(request.getParameter("ActualWeight"));
		final String roId = request.getParameter("roId");
		final String invoiceVal = request.getParameter("invoiceValue");
		final String ChallanNo = request.getParameter("ChallanNo");
		final String contractNo = request.getParameter("contractNo");

		int Count = creditNoteGenerationService.getCountOfRo(roId);

		session.setAttribute("shipmentDetails", shipmentDetails);
		session.setAttribute("ContractNo", contractNo);
		session.setAttribute("nominalWeight", nominalWt);
		session.setAttribute("ActualWeight", actualWt);
		session.setAttribute("ChallanNo", ChallanNo);
		session.setAttribute("roId", roId);
		session.setAttribute("Count", Count);
		session.setAttribute("invoiceVal", invoiceVal);

		ModelAndView mView = new ModelAndView("generationOfCreditNote");
		return mView;
	}

	//credit note form page
	@RequestMapping("creditNoteForm")
	public ModelAndView creditNoteForm(HttpServletRequest request) {

		String username = (String) request.getSession().getAttribute("usrname");

		if (username == null) {
			return new ModelAndView("index");
		}

		ModelAndView mView = new ModelAndView("generationOfCreditNote");
		return mView;
	}

	@Value("${upload.creditNoteDetails}")
	String creditNoteDetails;

	//save credit note
	@ResponseBody
	@RequestMapping(value = { "saveCreditNote" }, method = { RequestMethod.POST })
	public ModelAndView saveCreditNoteDetails(final HttpServletRequest request,
			@RequestParam("file") MultipartFile file) throws IllegalStateException, IOException {

		String username = (String) request.getSession().getAttribute("usrname");
		if (username == null) {
			return new ModelAndView("index");
		}

		final String shipmentDetails = request.getParameter("shipment");
		final String crnDate = request.getParameter("cnDate");
		final String crnNo = request.getParameter("cnNo");
		final String ChallanNo = request.getParameter("ChallanNo");
		final String contractNo = request.getParameter("contractNo");

		final Double shortQty = Double.parseDouble(request.getParameter("shortQty"));
		final Double nominalWt = Double.parseDouble(request.getParameter("bosQty"));
		final Double actualWt = Double.parseDouble(request.getParameter("actualQty"));
		final Double crnAmount = Double.parseDouble(request.getParameter("creditAmt"));
		String roId = (String) request.getSession().getAttribute("roId");
		int refId = (int) request.getSession().getAttribute("userId");

		CreditNotes creditNotes = new CreditNotes();

		creditNotes.setActualQty(actualWt);
		creditNotes.setBosQty(nominalWt);
		creditNotes.setCreated_by(refId + "");
		creditNotes.setCreationDate(new Date());
		creditNotes.setCrnAmount(crnAmount);
		creditNotes.setChallanNo(ChallanNo);
		creditNotes.setContractNo(contractNo);
		creditNotes.setCrnNo(crnNo);
		creditNotes.setCrnDate(crnDate);
		creditNotes.setShipmentDetails(shipmentDetails);
		creditNotes.setRoId(roId);
		creditNotes.setShortQty(shortQty);

		if (file == null || file.isEmpty()) {
			creditNotes.setDocument("");
		} else {
			final String originalFileName = file.getOriginalFilename();
			String dirString = creditNoteDetails;

			File fileStoreAt = new File(dirString);

			if (!fileStoreAt.exists()) {
				fileStoreAt.mkdir();
			}

			File tranferFile = new File(dirString, originalFileName);
			file.transferTo(tranferFile);
			creditNotes.setDocument(originalFileName);
		}

		creditNoteGenerationService.create(creditNotes);

		return new ModelAndView(new RedirectView("creditNoteList.obj"));

	}

	//status update of credit note
	@RequestMapping("changeCrnStatus")
	public ModelAndView changeCrnStatusTo1(HttpServletRequest request, RedirectView redirectView) {

		int id = Integer.parseInt(request.getParameter("crnId"));

		String username = (String) request.getSession().getAttribute("usrname");
		if (username == null) {
			return new ModelAndView("index");
		}

		creditNoteGenerationService.chageStatusTo1(id);

		return new ModelAndView(new RedirectView("creditNoteList.obj"));
	}

	//listing page of the credit note
	@RequestMapping("creditNoteList")
	public ModelAndView creditNoteList(HttpServletRequest request) {
		String username = (String) request.getSession().getAttribute("usrname");
		if (username == null) {
			return new ModelAndView("index");
		}

		ModelAndView mView = new ModelAndView("creditNoteList");

		List<CreditNotes> ListingCreditNotes = creditNoteGenerationService.getAllCreditNotes();

		mView.addObject("list", ListingCreditNotes);
		return mView;
	}

	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// ---------------------------------------------------------
	// Settlement Of Credit and Debit notes
	// ---------------------------------------------------------

	//settlement page listing
	@RequestMapping("settlementcndn")
	public ModelAndView settlementcndn(HttpServletRequest request) {
		String username = (String) request.getSession().getAttribute("usrname");
		if (username == null) {
			return new ModelAndView("index");
		}

		List<Object[]> millsOfContract = creditNoteGenerationService.getAllMillsOfContracts();
		ModelAndView mView = new ModelAndView("settlementCnDnPage");

		mView.addObject("millsOfContract", millsOfContract);

		return mView;
	}

	//redirected page of the settlement form
	@RequestMapping("finalsettlementNoteJsp")
	public ModelAndView finalsettlementNoteJsp(HttpServletRequest request) {
		String username = (String) request.getSession().getAttribute("usrname");
		if (username == null) {
			return new ModelAndView("index");
		}

		String contractNoString = request.getParameter("contractNo");

		List<Object[]> creditList = creditNoteGenerationService.findDetails("jcicredit_note", contractNoString);
		List<Object[]> demandList = creditNoteGenerationService.findDetails("jcidemand_note", contractNoString);

		ModelAndView mView = new ModelAndView("finalSettlementPage");

		mView.addObject("creditList", creditList);
		mView.addObject("demandList", demandList);

		return mView;
	}

	//create the instance of the finalSettlelment 
	@RequestMapping("finalSettlement")
	public ModelAndView finalSettlement(HttpServletRequest request) {
		String username = (String) request.getSession().getAttribute("usrname");

		if (username == null) {
			return new ModelAndView("index");
		}

		double initiationAmt = Double.parseDouble((String) request.getParameter("initiationAmt"));
		String initiateDate = request.getParameter("initiateDate");
		String contractNo = request.getParameter("contractNo");
		String creditNoteNo = request.getParameter("creditNoteNo");
		String debitNoteNo = request.getParameter("debitNoteNo");

		Date todaysDate = new Date();
		settlemetCnDnModel settlemetCnDnModel = new settlemetCnDnModel();
		settlemetCnDnModel.setContractNo(contractNo);
		settlemetCnDnModel.setCreditNoteNo(creditNoteNo);
		settlemetCnDnModel.setDebitNoteNo(debitNoteNo);
		settlemetCnDnModel.setInitiateDate(todaysDate);
		settlemetCnDnModel.setInitiationAmt(initiationAmt);

		creditNoteGenerationService.saveSettlementOfCnDn(settlemetCnDnModel);
		return new ModelAndView(new RedirectView("settlementcndn.obj"));
	}

	/////////////////////////////////////////////////////////////////////////////////////////////////

	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// ---------------------------------------------------------
	// Uploading of Payment Realization / Disbursal Details
	// ---------------------------------------------------------

	@RequestMapping("uploadPaymentRealizationDisDetails")
	public ModelAndView uploadPaymentRealizationDisDetails(HttpServletRequest request) {
		String username = (String) request.getSession().getAttribute("usrname");
		if (username == null) {
			return new ModelAndView("index");
		}

		ModelAndView mView = new ModelAndView("uploadPaymentRealizationDisDetails");
		return mView;
	}
	

	@Value("${upload.PaymentRealizationDisDetails}")
	String paymentRealDetailsPath;
	
	@RequestMapping("saveuploadPaymentRealizationDisDetails")
	public ModelAndView saveuploadPaymentRealizationDisDetails(HttpServletRequest request,
			@RequestParam("excelFile") MultipartFile excelFile, RedirectAttributes redirectAttributes)
			throws IllegalStateException, IOException {
		String username = (String) request.getSession().getAttribute("usrname");
		if (username == null) {
			return new ModelAndView("index");
		}

		File filePathDir = new File(paymentRealDetailsPath);

		if (!filePathDir.exists()) {
			filePathDir.mkdir();
		}

		String originalFileNameString = excelFile.getOriginalFilename();

		try {

			File serveFile = new File(filePathDir, originalFileNameString);
			excelFile.transferTo(serveFile);

//			try (Workbook workbook = WorkbookFactory.create(excelFile.getInputStream())) {
//				Sheet sheet = workbook.getSheetAt(0);
//				int i = 1;
//				int rowCount = sheet.getLastRowNum();
//				System.out.println("rowcount" + rowCount);
//				// FormulaEvaluator formulaEvaluator =
//				// workbook.getCreationHelper().createFormulaEvaluator();
//				String[] tally;
//				// String tallyno;
//				for (i = 1; i < rowCount + 1; i++) {
//					try {
//						Row row = sheet.getRow(i);
//						Cell cell = row.getCell(2);
//						String jciref = cell.getStringCellValue();
//						cell = row.getCell(10);
//
//						String dataDate = cell.getStringCellValue();
//
//						cell = row.getCell(5);
//						String cell5 = cell.getStringCellValue();
//
//						System.err.println(" jciref = " + jciref + " date = " + dataDate + " cell5" + cell5);
//
//						tally = jciref.split("-");
//						// tallyno = tally[1];
//						// System.out.println("tallyno========="+tallyno);
//
//					} catch (Exception e) {
//						System.out.println("error in catch field-________" + e);
////						mv.addObject("msg",
////								(Object) "<div class=\"alert alert-danger\"><b>OOps!</b> Date formate should be dd/mm/yyyy and UTR NO should be Number in excel file</div>\r\n");
////						return mv;
//					}
//
//				}
//			}
//
//			catch (IOException e) {
//				e.printStackTrace();
//			}

			 paymentRealizationService.create(originalFileNameString);
			redirectAttributes.addFlashAttribute("msg",
					"<div class=\"alert alert-success\"><b> File Saved successfully.</b></div>\r\n" + "");

		} catch (Exception e) {

			redirectAttributes.addFlashAttribute("msg",
					"<div class=\"alert alert-danger\"><b>Something went wrong...</b></div>\r\n" + "");
		}

		return new ModelAndView(new RedirectView("uploadPaymentRealizationDisDetails.obj"));
	}

	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// ---------------------------------------------------------
	// Settlement Of Credit and Debit notes
	// ---------------------------------------------------------

	// for specific district values

	@ResponseBody
	@RequestMapping(value = { "pIconForSelected" }, method = { RequestMethod.GET })
	public String getFoosBySimplePathForSelected(final HttpServletRequest request) {
		String username = (String) request.getSession().getAttribute("usrname");
		final String state = request.getParameter("F_District");
		String state_code = "";
		if (state != "") {
			state_code = stateList.getStateCode(state);
		}
		final String crop_year = request.getParameter("cropYear");
		final String delivery_type = request.getParameter("delivery_type");
//			System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
//			System.out.println(state_code + " " + state  + " " + crop_year + " " + delivery_type + " ");
//			System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
		final Gson gson = new Gson();
		if (state_code == "")
			return "entry_derivativeprice.obj";
		return gson.toJson((Object) districtService.getSpecificDistricts(state_code, crop_year, delivery_type));
	}

	@ResponseBody
	@RequestMapping(value = { "isValidateLabel" }, method = { RequestMethod.GET })
	public String validateEmail(final HttpServletRequest request) {
		final String labelName = request.getParameter("label");
		return this.entryofGradeCompositionService.isValidLabelName(labelName) + "";
	}

	@ResponseBody
	@RequestMapping(value = { "isValid_Identification_No" }, method = { RequestMethod.GET })
	public String Valid_Identification_No(final HttpServletRequest request) {
		final String contractIdn = request.getParameter("contractIdn");
		return this.contractGenerationService2.isValidContractIdn(contractIdn) + "";
	}

	@ResponseBody
	@RequestMapping(value = { "getContractDetails" }, method = { RequestMethod.GET })
	public String getContractDetails(final HttpServletRequest request) {
		final String diNo = request.getParameter("diNo");
		List<Object> loadFullContractDetails = this.roDispatchService.loadFullContractDetails(diNo);
		int count = this.roDispatchService.getCountOfAvailableEntries(diNo);
		Map<String, Object> mpMap = new HashMap<>();
		mpMap.put("contractDetails", loadFullContractDetails);
		mpMap.put("count", count);
		Gson gson = new Gson();

		return gson.toJson(mpMap);

	}

	@ResponseBody
	@RequestMapping(value = { "getRequestLetterDetails" }, method = { RequestMethod.GET })
	public String getRequestLetterDetails(final HttpServletRequest request) {
		final String refNo = request.getParameter("refNo");
		Object loadAllDetailsOfLetter = this.pcsoentryservice.loadAllDetailsOfLetter(refNo);

		Gson gson = new Gson();
		return gson.toJson(loadAllDetailsOfLetter);

	}

	// kailash
	@RequestMapping("EntryofPaymentDetails")
	public ModelAndView EntryofpiModelDetails(HttpServletRequest request) {
		String username = (String) request.getSession().getAttribute("usrname");
		ModelAndView mv = new ModelAndView("EntryofPaymentDetails");
		if (username == null) {
			mv = new ModelAndView("index");
		}
		List<Object> getcontractList1 = this.paymentDetailService.ContractNo();

		mv.addObject("getcontractList1", getcontractList1);
		return mv;

	}

	@RequestMapping("saveentryofpaymentinstrumentDetails")
	public ModelAndView saveentryofPID(HttpServletRequest request, RedirectAttributes redirectAttributes,
			@RequestParam("SupportingDocument") final MultipartFile SupportingDocument) {
		final File theDir = new File("upload.Imagedownload");
		if (!theDir.exists()) {
			theDir.mkdirs();
		}
		final ModelAndView mv = new ModelAndView();
		String username = (String) request.getSession().getAttribute("usrname");
		try {

			String contractno = request.getParameter("fullcontractno");
			String Instrument = request.getParameter("Instrument");
			String instdate = request.getParameter("instdate");
			String IFSC = request.getParameter("IFSC");
			String Branch = request.getParameter("Branch");
			String BankName = request.getParameter("BankName");
			String payment = request.getParameter("paymenttype");
			String InstrumentValue = request.getParameter("InstrumentValue");
			String dateofexpiry = request.getParameter("dateofexpiry");
			String dateofship = request.getParameter("dateofship");
			String autorevolvingamount = request.getParameter("autorevolvingamount");
			// String QtyAllowed = request.getParameter("QtyAllowed");
			final String filename = SupportingDocument.getOriginalFilename();
			File serverFile = new File(theDir, filename);
			SupportingDocument.transferTo(serverFile);

			// Conditionally set autorevolvingamount based on payment type

			EntryPaymentDetailsModel entryPaymentDetailsModel = new EntryPaymentDetailsModel();
			entryPaymentDetailsModel.setContractno(contractno);
			entryPaymentDetailsModel.setInstrumentno(Instrument);
			SimpleDateFormat formatter1 = new SimpleDateFormat("yyyy-MM-dd");
			Date instdate1 = formatter1.parse(instdate);
			entryPaymentDetailsModel.setInstdate(instdate1);

			entryPaymentDetailsModel.setPayment(payment);
			entryPaymentDetailsModel.setInstrumentValue(InstrumentValue);
			// entryPaymentDetailsModel.setQtyAllowed(QtyAllowed);
			entryPaymentDetailsModel.setSupportingDocument(filename);
			entryPaymentDetailsModel.setFc_status(0);

			Date date3 = new Date();
			Double flag = 0.0;

			if ("NEFT/RTGS".equalsIgnoreCase(payment)) {
				autorevolvingamount = "0";
				entryPaymentDetailsModel.setAutorevolvingamount(autorevolvingamount);
				entryPaymentDetailsModel.setDateofship(date3);
				entryPaymentDetailsModel.setDateofexpiry(date3);

				entryPaymentDetailsModel.setIFSC(IFSC);
				entryPaymentDetailsModel.setBranch(Branch);
				entryPaymentDetailsModel.setBankName(BankName);

			} else if ("Cheque/DD".equalsIgnoreCase(payment)) {

				autorevolvingamount = "0";
				entryPaymentDetailsModel.setAutorevolvingamount(autorevolvingamount);
				entryPaymentDetailsModel.setDateofship(date3);
				entryPaymentDetailsModel.setDateofexpiry(date3);

				entryPaymentDetailsModel.setIFSC(IFSC);
				entryPaymentDetailsModel.setBranch(Branch);
				entryPaymentDetailsModel.setBankName(BankName);
			} else if ("Letter_of_Credit".equalsIgnoreCase(payment)) {

				entryPaymentDetailsModel.setIFSC(IFSC);
				entryPaymentDetailsModel.setBranch(Branch);
				entryPaymentDetailsModel.setBankName(BankName);

				Date dateofship1 = formatter1.parse(dateofship);
				entryPaymentDetailsModel.setDateofship(dateofship1);
				System.err.println(dateofship1);

				Date dateofexpiry1 = formatter1.parse(dateofexpiry);
				entryPaymentDetailsModel.setDateofexpiry(dateofexpiry1);
				System.err.println(dateofship1);

				entryPaymentDetailsModel.setAutorevolvingamount(autorevolvingamount);
			}

			Date date = new Date();
			entryPaymentDetailsModel.setCreated_date(date);

			this.paymentDetailService.create(entryPaymentDetailsModel);

			this.paymentDetailService.contratTable(contractno);
			redirectAttributes.addFlashAttribute("msg",
					"<div class=\"alert alert-success\"><b>Success !</b> Record saved successfully.</div>\r\n" + "");

		} catch (Exception e) {

			e.printStackTrace();
		}
		if (username == null) {
			return new ModelAndView("index");
		}

		return new ModelAndView(new RedirectView("EntryofPaymentDetails.obj"));
	}

	@RequestMapping("downloadSupportingDocument")
	public void downloadImage(@RequestParam("filename") String filename, HttpServletResponse response) {
		String imageDirectory = "upload.Imagedownload"; // Replace with your image directory path
		String imagePath = imageDirectory + File.separator + filename;

		File imageFile = new File(imagePath);

		// Check if the file exists
		if (imageFile.exists()) {
			try {
				// Set the content type based on the file type
				String contentType = determineContentType(filename);
				response.setContentType(contentType);

				// Set the content length and attachment disposition
				response.setContentLength((int) imageFile.length());
				// response.setHeader("Content-Disposition", "attachment; filename=" +
				// filename);
				response.setHeader("Content-Disposition", "");
				// Stream the file content to the response
				FileInputStream fileInputStream = new FileInputStream(imageFile);
				OutputStream responseOutputStream = response.getOutputStream();

				byte[] buffer = new byte[1024];
				int bytesRead;
				while ((bytesRead = fileInputStream.read(buffer)) != -1) {
					responseOutputStream.write(buffer, 0, bytesRead);
				}

				fileInputStream.close();
				responseOutputStream.close();
			} catch (IOException e) {
				// Handle IO exception
				e.printStackTrace();
				response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
			}
		} else {
			response.setStatus(HttpServletResponse.SC_NOT_FOUND);
		}
	}

	// Utility method to determine content type based on filename
	private String determineContentType(String filename) {
		if (filename.endsWith(".pdf")) {
			return "application/pdf";
		} else if (filename.endsWith(".jpg") || filename.endsWith(".jpeg")) {
			return "image/jpeg";
		} else if (filename.endsWith(".png")) {
			return "image/png";
		} else {
			return "application/octet-stream"; // Default to binary data if content type is unknown
		}
	}

	@RequestMapping("EntryofFinancialConcurence")
	public ModelAndView EntryofFinancialConcurence(HttpServletRequest request) {
		String username = (String) request.getSession().getAttribute("usrname");
//		String con_no =entryPaymentDetailsModel.getContractno();
		ModelAndView mv = new ModelAndView("EntryofFinancialConcurence");
		if (username == null) {
			mv = new ModelAndView("index");
		}

		return mv;
	}

	@ResponseBody
	@RequestMapping("saveRemarks")
	public ResponseEntity<String> saveRemarks(@RequestParam("remarks") String remarks,
			@RequestParam("con_no") String contractNo, @RequestParam("id") int paymentId, HttpServletRequest request,
			RedirectAttributes redirectAttributes) {
		final ModelAndView mv = new ModelAndView("viewFCpaymentlist");

		String username = (String) request.getSession().getAttribute("usrname");
		if (username == null) {
			return new ResponseEntity<>("Unauthorized", HttpStatus.UNAUTHORIZED);
		}
		try {
			this.financialConcurenceservice.remark(remarks, contractNo);
			this.paymentDetailService.update1(contractNo);

			EntryPaymentDetailsModel entryPaymentDetailsModel = this.paymentDetailService.find(paymentId);
			mv.addObject("entryPaymentDetailsModel", entryPaymentDetailsModel);

////				request.getSession().setAttribute("myModel", entryPaymentDetailsModel);
//////
////				redirectAttributes.addFlashAttribute("contractNo", entryPaymentDetailsModel.getContractno());
////				redirectAttributes.addFlashAttribute("paymentId", entryPaymentDetailsModel.getPayment_id());
//
//				//String modelQueryString = "contractNo=" + entryPaymentDetailsModel.getContractno() + "&paymentType="
////						+ entryPaymentDetailsModel.getPayment_id();

			redirectAttributes.addFlashAttribute("entryPaymentDetailsModel", entryPaymentDetailsModel);

			redirectAttributes.addFlashAttribute("msg",
//
					"<div class=\"alert alert-success\"><b>Success !</b> Data rejected successfully.</div>");
			return new ResponseEntity<>("{\"redirect\":\"viewPaymentForFC.obj\"}", HttpStatus.OK);

		} catch (Exception ex) {
			return new ResponseEntity<>("Error occurred", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@ResponseBody
	@RequestMapping("saveRemarksofbill")
	public ResponseEntity<String> saveRemarksofbill(@RequestParam("remarks") String remarks,
			@RequestParam("con_no") String contractNo, HttpServletRequest request,
			RedirectAttributes redirectAttributes) {
		final ModelAndView mv = new ModelAndView("EntryGenerationBill");

		String username = (String) request.getSession().getAttribute("usrname");
		if (username == null) {
			return new ResponseEntity<>("Unauthorized", HttpStatus.UNAUTHORIZED);
		}
		try {

			System.err.println(remarks);
			System.err.println(contractNo);
			this.generationofBillService.remark(remarks, contractNo);
			System.err.println("coming");

			redirectAttributes.addFlashAttribute("msg",
//
					"<div class=\"alert alert-success\"><b>Success !</b> Data rejected successfully.</div>");
			return new ResponseEntity<>("{\"redirect\":\"EntryofGenerationBillsupply.obj\"}", HttpStatus.OK);

		} catch (Exception ex) {
			return new ResponseEntity<>("Error occurred", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@RequestMapping("saveFinancialConcurence")
	public ModelAndView saveentryofFC(HttpServletRequest request, RedirectAttributes redirectAttributes) {
		String username = (String) request.getSession().getAttribute("usrname");
		try {

			String fullcontractno = request.getParameter("fullcontractno");
			String FC_Issue_Date = request.getParameter("FC_Issue_Date");
			String FC_Ref_No = request.getParameter("FC_Ref_No.");
			String Contracted_Qty = request.getParameter("Contracted_Qty.");
			String QtyAllowed = request.getParameter("QtyAllowed");
			String carryingCostParam = request.getParameter("Carrying_cost");
			double Carrying_Cost_Charged = 0.0; // Default value if the parameter is not present or cannot be parsed

			if (carryingCostParam != null && !carryingCostParam.isEmpty()) {
				try {
					Carrying_Cost_Charged = Double.parseDouble(carryingCostParam);
				} catch (NumberFormatException e) {
				}
			}

			// double Carrying_Cost_Charged = request.getParameter("Carrying_cost");

			FinancialConcurenceModel financialConcurenceModel = new FinancialConcurenceModel();
			System.out.print(financialConcurenceModel);
			financialConcurenceModel.setFullcontractno(fullcontractno);
			SimpleDateFormat formatter1 = new SimpleDateFormat("yyyy-MM-dd");
			Date contdate = formatter1.parse(FC_Issue_Date);

			financialConcurenceModel.setFC_Issue_Date(contdate);
			financialConcurenceModel.setFC_Ref_No(FC_Ref_No);
			financialConcurenceModel.setContracted_Qty(Contracted_Qty);
			financialConcurenceModel.setQtyAllowed(QtyAllowed);
			financialConcurenceModel.setCarrying_Cost_Charged(Carrying_Cost_Charged);

			Date date = new Date();
			// Date currdate = date.toString();
			financialConcurenceModel.setCreated_date(date);
			financialConcurenceModel.setRemarks("Not any");
			this.financialConcurenceservice.create(financialConcurenceModel);
			redirectAttributes.addFlashAttribute("msg",
					"<div class=\"alert alert-success\"><b>Success !</b> Record saved successfully.</div>\r\n" + "");

		} catch (Exception e) {
			System.out.println("++++++++++++++" + e);
			e.printStackTrace();
		}
		if (username == null) {
			return new ModelAndView("index");
		}
		return new ModelAndView(new RedirectView("viewFinancialConcurence.obj"));
	}

	@RequestMapping("EntryofMillreceipt")
	public ModelAndView EntryofMillreceipt(HttpServletRequest request)

	{
		String username = (String) request.getSession().getAttribute("usrname");
		ModelAndView mv = new ModelAndView("EntryofMillReciept");
		MillRecieptModel millRecieptModel = new MillRecieptModel();
		if (username == null) {
			mv = new ModelAndView("index");
		}

		// List<Object[]>getdataList = this.millRecieptService.fetchdata();
		List<Object> getdataList1 = this.millRecieptService.fetchHODINO();

		mv.addObject("getdataList1", getdataList1);
		return mv;
	}

	@ResponseBody
	@RequestMapping(value = "fetchingdata", method = RequestMethod.GET)
	public String hodinofetch(@RequestParam("contractno") String contractno) {

		MillRecieptModel millRecieptModelt1 = millRecieptService.fetchdata(contractno);
		System.err.println("resultList++++++++++" + millRecieptModelt1);
		Gson gson = new Gson();
		String resultString = new Gson().toJson(millRecieptModelt1);
		return resultString;// gson.toJson((Object)millRecieptModelt1);
	}

	@RequestMapping("saveentryofMillreciept")
	public ModelAndView saveentryofMR(HttpServletRequest request, RedirectAttributes redirectAttributes) {

		final ModelAndView mv = new ModelAndView();
		String username = (String) request.getSession().getAttribute("usrname");
		try {

			String HO_DI = request.getParameter("HO_DI_&_Date");
			String Challan_No = request.getParameter("Challan_No");
			// Date Date_of_Shipment = new
			// SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("Date_of_Shipment"));

			String Date_of_Shipment = request.getParameter("Date_of_Shipment");
			System.out.println(Date_of_Shipment + "Date_of_Shipment");
			String Vehicle_No = request.getParameter("Vehicle_No.");
			String Challan_Qty = request.getParameter("Challan_Qty");
			double Challan_Qty1 = Double.parseDouble(Challan_Qty);
			String Actual_Qty = request.getParameter("Actual_Qty");
			double Actual_Qty1 = Double.parseDouble(Actual_Qty);
			// float Actual_Qty1 = Float.parseFloat(Actual_Qty);
			String Quality_Claim = request.getParameter("Quality_Claim");

			String Bale_Mark = request.getParameter("Bale_Mark");
			String juteewiseqty = request.getParameter("juteewiseqty");
			String Crop_Year = request.getParameter("Crop_Year");

			String MR_No = request.getParameter("MR_No");
			String MR_Date1 = request.getParameter("MR_Date");
			String HR_Date1 = request.getParameter("HO_Date");
			String Mill_code = request.getParameter("Millcode2");
			System.err.println(Mill_code);

			// String mill_id = request.getParameter("HO_Date");

			String Mill_Reciept_Qty = request.getParameter("Mill_Reciept_Qty");
			double Mill_Reciept_Qty1 = Double.parseDouble(Mill_Reciept_Qty);
			String Short_Qty = request.getParameter("Short_Qty");
			double Short_Qty1 = Double.parseDouble(Short_Qty);
			// float Short_Qty1 = Float.parseFloat(Short_Qty);

			MillRecieptModel millRecieptModel = new MillRecieptModel();

			Double flag = 0.0;

			if ("Quality".equalsIgnoreCase(Quality_Claim)) {
				millRecieptModel.setNCV_percentage(flag);
				millRecieptModel.setNCV_qty(flag);
				millRecieptModel.setMoistureContent(flag);
			} else if ("Quantity".equalsIgnoreCase(Quality_Claim)) {
				millRecieptModel.setNCV_percentage(flag);
				millRecieptModel.setNCV_qty(flag);
				millRecieptModel.setMoistureContent(flag);
			} else if ("Moisture_Gain".equalsIgnoreCase(Quality_Claim)) {

				String Moisture_Content = request.getParameter("MoistureContent12");
				System.out.println("Moisture_Content===" + Moisture_Content);
				double moistureContent1 = Double.parseDouble(Moisture_Content);
				millRecieptModel.setMoistureContent(moistureContent1);
				millRecieptModel.setNCV_percentage(flag);
				millRecieptModel.setNCV_qty(flag);
			} else if ("Dust_NCV".equalsIgnoreCase(Quality_Claim)) {
				String NCV_Percentage = request.getParameter("NCVPercentage12");
				double NCV_Percentage1 = Double.parseDouble(NCV_Percentage);
				millRecieptModel.setNCV_percentage(NCV_Percentage1);
				String NCV_Qty = request.getParameter("NCVQty12");
				double NCV_Qty1 = Double.parseDouble(NCV_Qty);
				millRecieptModel.setNCV_qty(NCV_Qty1);
				millRecieptModel.setMoistureContent(flag);
			}

			millRecieptModel.setHO_di(HO_DI);
			millRecieptModel.setChallan_no(Challan_No);
			SimpleDateFormat formatter1 = new SimpleDateFormat("yyyy-MM-dd");
			Date date1 = new SimpleDateFormat("dd/MM/yyyy").parse(Date_of_Shipment);
			System.err.println(date1);
			// Date instdate1 = formatter1.parse(Date_of_Shipment);
			millRecieptModel.setDate_shipment(date1);
			millRecieptModel.setVehicle_no(Vehicle_No);
			millRecieptModel.setChallan_qty(Challan_Qty1);
			millRecieptModel.setActual_qty(Actual_Qty1);
			millRecieptModel.setQuality_claim(Quality_Claim);
			// millRecieptModel.setMoistureContent(Moisture_Content);
			// millRecieptModel.setNCV_percentage(NCV_Percentage);
			millRecieptModel.setBale_mark(Bale_Mark);

			millRecieptModel.setCrop_year(Crop_Year);
			// millRecieptModel.setNCV_qty(NCV_Qty);
			millRecieptModel.setMR_no(MR_No);
			// Date date= new Date();

			Date MR_Date = formatter1.parse(MR_Date1);
			millRecieptModel.setMr_date(MR_Date);

			Date date2 = new SimpleDateFormat("dd/MM/yyyy").parse(HR_Date1);
//				Date MR_Date3 = formatter1.parse(HR_Date1);
			millRecieptModel.setHo_date(date2);

			// millRecieptModel.setMr_date(MR_Date);
			// millRecieptModel.setMi(Mill_Reciept_Qty);
			millRecieptModel.setShort_qty(Short_Qty1);
			millRecieptModel.setMR_qty(Mill_Reciept_Qty1);
			System.out.println(Mill_code);
			millRecieptModel.setMill_id(Mill_code);
			// millRecieptModel.setDie(Mill_code);
			Date date = new Date();
			// Date currdate = date.toString();
			millRecieptModel.setCreated_on(date);
			// millRecieptModel.setHo_date(date);
			millRecieptModel.setCreated_by("kailash");
			// millRecieptModel.setMR_qty(123.0);
			millRecieptModel.setClaim_status(2);

			this.millRecieptService.create(millRecieptModel);
			// this.millRecieptService.UpdateContractstatus(HO_DI);
			redirectAttributes.addFlashAttribute("msg",
					"<div class=\"alert alert-success\"><b>Success !</b> Record saved successfully.</div>\r\n" + "");

		} catch (Exception e) {

			e.printStackTrace();
		}
		if (username == null) {
			return new ModelAndView("index");
		}

		return new ModelAndView(new RedirectView("EntryofMillreceipt.obj"));
	}

	@RequestMapping({ "viewMillReciept" })
	public ModelAndView viewMillReciept(final HttpServletRequest request) {
		String username = (String) request.getSession().getAttribute("usrname");
		ModelAndView mv = new ModelAndView("viewMillReciept");
		if (username == null) {
			mv = new ModelAndView("index");
		}

		final List<MillRecieptModel> allUserRegistration = (List<MillRecieptModel>) this.millRecieptService
				.getAllPaymentInstruments();
		mv.addObject("millRecieptModel", allUserRegistration);

		return mv;
	}

	@ResponseBody
	@RequestMapping(value = "fetchingdatatocontractno", method = RequestMethod.GET)
	public String fetchingdatatocontractnoq(@RequestParam("contractno") String contractno) {
		GenrationDEmandDto getcontractddownlist = genratedDemandNoteService.fetchContract_no(contractno);
		System.err.println("resultList++++++++++" + getcontractddownlist);
		Gson gson = new Gson();
		String resultString = new Gson().toJson(getcontractddownlist);
		return resultString;
	}

	@RequestMapping("EntryofGenrationDeamandNote")
	public ModelAndView EntryofGenrationDemand(HttpServletRequest request) {
		String username = (String) request.getSession().getAttribute("usrname");

		ModelAndView mv = new ModelAndView("EntryofGenratedDemandNote");
		if (username == null) {
			mv = new ModelAndView("index");
		}
		List<Object> getdataList1 = this.genratedDemandNoteService.fetchcon_no();

		int lastSerialNumber = 1640;
		String demandNoteNumber = generateDemandNoteNumber(request.getSession(), lastSerialNumber);
		mv.addObject("demandNoteNumber", demandNoteNumber);

		// String demandNoteNumber = generateDemandNoteNumber();
		mv.addObject("demandNoteNumber", demandNoteNumber);
		// GenrationDEmandDto cotract_No =
		// this.genratedDemandNoteService.fetchContract_no();

//			System.out.println("cotract_No>>>>>>>>>>>>>"+cotract_No);
//			Date date =cotract_No.getContract_date();
//			SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
//			String formattedDate = dateFormat.format(date);
		mv.addObject("getdataList1", getdataList1);
		// mv.addObject("demandNoteNumber", demandNoteNumber);
//			mv.addObject("cotract_No", cotract_No);
//			mv.addObject("formattedDate", formattedDate);
		return mv;
	}

//		
	// private String generateDemandNoteNumber()
	private String generateDemandNoteNumber(HttpSession session, int lastSerialNumber) {
		Date currentDate = new Date();
		SimpleDateFormat yearFormat = new SimpleDateFormat("yy");
		String fiscalYear = yearFormat.format(currentDate);

//		    int lastSerialNumber = getLastSerialNumberFromDatabase();
		int newSerialNumber = lastSerialNumber + 1;

		String stringdemand = "D" + fiscalYear + String.format("%06d", newSerialNumber);
		String status = this.genratedDemandNoteService.demandnono(stringdemand);
		if ("1".equals(status)) {

			return generateDemandNoteNumber(session, newSerialNumber);
		} else {

			return stringdemand;
		}

	}

	@RequestMapping("saveentryofGenrationDeamandNote")
	public ModelAndView saveentryofGDN(HttpServletRequest request, RedirectAttributes redirectAttributes) {

		final ModelAndView mv = new ModelAndView();
		String username = (String) request.getSession().getAttribute("usrname");
		try {

			String Contract_No = request.getParameter("Contract_No");
			String Contract_Date = request.getParameter("Contract_Date");
			String Payment_Due_Date = request.getParameter("Payment_Due_Date");
			String Cancellation_Date = request.getParameter("Cancellation_Date.");
			String Delay_period = request.getParameter("Delay_period");
			String Payment_Ref = request.getParameter("Payment_Ref");
			String contractedQtyStr = request.getParameter("Contracted_Qty");
			double contractedQty = Double.parseDouble(contractedQtyStr);

			String Unit_charge_str = request.getParameter("Unit_charge");
			double Unit_charge = Double.parseDouble(Unit_charge_str);
			String Carrying_cost_str = request.getParameter("Carrying_cost");
			double Carrying_cost = Double.parseDouble(Carrying_cost_str);
			// String Waiver_flag = request.getParameter("Waiver_flag");
			String Remarks = request.getParameter("Remarks");
			// String Waiver_Approved_By = request.getParameter("Waiver_Approved_By");
			// String Dn_status = request.getParameter("Dn_status");
			String Demand_note_no = request.getParameter("Demand_note_no");
			String Demand_note_date = request.getParameter("Demand_note_date");

			GenrationDemandNoteModel genrationDemandNoteModel = new GenrationDemandNoteModel();

			genrationDemandNoteModel.setContract_no(Contract_No);

			SimpleDateFormat formatter1 = new SimpleDateFormat("yyyy-mm-dd");
			genrationDemandNoteModel.setDemand_note_no(Demand_note_no);
			Date instdate4 = formatter1.parse(Demand_note_date);
			genrationDemandNoteModel.setDemand_note_date(instdate4);
			genrationDemandNoteModel.setContract_date(Contract_Date);
			genrationDemandNoteModel.setPayment_due_date(Payment_Due_Date);
			// genrationDemandNoteModel.setPayment_date(Cancellation_Date);
			genrationDemandNoteModel.setPayment_date("somevalue");
			genrationDemandNoteModel.setDelay_period(Delay_period);
			genrationDemandNoteModel.setPayment_ref(Payment_Ref);
			genrationDemandNoteModel.setContracted_qty(contractedQty);
			genrationDemandNoteModel.setUnit_charge(Unit_charge);
			genrationDemandNoteModel.setCarrying_cost(Carrying_cost);
			genrationDemandNoteModel.setWaiver_flag(0);
			genrationDemandNoteModel.setRemarks(Remarks);
			genrationDemandNoteModel.setWaiver_approved_by("kailash");
			genrationDemandNoteModel.setDn_status(0);
			genrationDemandNoteModel.setCreated_by("kailash");

			Date date = new Date();
			// Date instdate4 = formatter1.parse(Created_on);
			genrationDemandNoteModel.setCreated_on(date);
			// Date date= new Date();

			this.genratedDemandNoteService.create(genrationDemandNoteModel);
			redirectAttributes.addFlashAttribute("msg",
					"<div class=\"alert alert-success\"><b>Success !</b> Record saved successfully.</div>\r\n" + "");

		} catch (Exception e) {

			e.printStackTrace();
		}
		if (username == null) {
			return new ModelAndView("index");
		}

		return new ModelAndView(new RedirectView("EntryofGenrationDeamandNote.obj"));
	}

	@RequestMapping("entryofConfirationSettelment")
	public ModelAndView entryofConfirationSettelment(HttpServletRequest request) {
		String username = (String) request.getSession().getAttribute("usrname");

		ModelAndView mv = new ModelAndView("ConfirmationofClaimSettlement");
		if (username == null) {
			mv = new ModelAndView("index");
		}
		List<Object> getSettlementidlist = this.confirmationofClaimSettlementService.SettlementId();

		mv.addObject("getSettlementidlist", getSettlementidlist);
		return mv;
	}

	@ResponseBody
	@RequestMapping(value = "fetchingdatamillrecept", method = RequestMethod.GET)
	public String fetchingdatatocontractnoji(@RequestParam("contractno") String contractno) {
		List<Object[]> getcontractddownlist = confirmationofClaimSettlementService.fetchdataofclaim(contractno);
		System.err.println("resultList++++++++++" + getcontractddownlist);
		Gson gson = new Gson();
		String resultString = new Gson().toJson(getcontractddownlist);
		return resultString;
	}

	@ResponseBody
	@RequestMapping(value = "gradecomposition", method = RequestMethod.GET)
	public String GradeComposition(@RequestParam("ContractNo") String ContractNo) {
		List<Object> gradecmposition = confirmationofClaimSettlementService.gradecomposition(ContractNo);
		Gson gson = new Gson();
		String jsonResponse = gson.toJson(gradecmposition);
		return jsonResponse;

	}

	@ResponseBody
	@RequestMapping(value = "fetchingdatanominactionclaim", method = RequestMethod.GET)
	public String fetchingdatanominactionclaim(@RequestParam("contractno") int contractno) {
		List<Object[]> getsettlementlist = confirmationofClaimSettlementService.fetchdatasttlement(contractno);
		System.err.println("resultList++++++++++" + getsettlementlist);
		Gson gson = new Gson();
		String resultString = new Gson().toJson(getsettlementlist);
		return resultString;
	}

	@RequestMapping("EntryofGenerationBillsupply")
	public ModelAndView EntryofGenrationBillsupply(HttpServletRequest request) {
		String username = (String) request.getSession().getAttribute("usrname");

		ModelAndView mv = new ModelAndView("EntryGenerationBill");
		if (username == null) {
			mv = new ModelAndView("index");
		}
		List<Object[]> getChallanlist = (List<Object[]>) this.generationofBillService.ChallanNo();
		mv.addObject("getChallanlist", getChallanlist);

		int allIndiaSerialNo = 1;
		int stateSerialNo = 1;
		String billOfSupplyNo = generateBillOfSupplyNumber(request.getSession(), allIndiaSerialNo, stateSerialNo);
		mv.addObject("billOfSupplyNo", billOfSupplyNo);

		return mv;

	}

	private String generateBillOfSupplyNumber(HttpSession session, int allIndiaSerialNo, int stateSerialNo) {
		String prefix = "B";

		int currentYear = Calendar.getInstance().get(Calendar.YEAR) % 100;
		String yearCode = String.format("%02d", currentYear);

		if (session.getAttribute("allIndiaSerialNo") != null) {
			allIndiaSerialNo = (int) session.getAttribute("allIndiaSerialNo");
			allIndiaSerialNo++;
		}
		session.setAttribute("allIndiaSerialNo", allIndiaSerialNo);

		String formattedAllIndiaSerialNo = String.format("%06d", allIndiaSerialNo);

		String stateGSTCode = "19";

		if (session.getAttribute("stateSerialNo") != null) {
			stateSerialNo = (int) session.getAttribute("stateSerialNo");
			stateSerialNo++;
		}
		session.setAttribute("stateSerialNo", stateSerialNo);

		String formattedStateSerialNo = String.format("%05d", stateSerialNo);

		String laString = prefix + yearCode + formattedAllIndiaSerialNo + stateGSTCode + formattedStateSerialNo;
		String status = this.generationofBillService.billofsupplyno(laString);
		if ("1".equals(status)) {

			return generateBillOfSupplyNumber(session, allIndiaSerialNo + 1, stateSerialNo + 1);
		} else {

			return laString;
		}
	}

	@RequestMapping("saveConfirmationOfClaimSettelment.obj")
	public ModelAndView saveConfirmationOfClaimSettelment(HttpServletRequest request,
			RedirectAttributes redirectAttributes,
			@RequestParam("SupportingDocument") final MultipartFile SupportingDocument) {
		final File theDir = new File("upload.Imagedownload");
		if (!theDir.exists()) {
			theDir.mkdirs();
		}
		final ModelAndView mv = new ModelAndView();
		String username = (String) request.getSession().getAttribute("usrname");
		try {

			/* String CAD_Doc_No = request.getParameter("CAD_Doc_No"); */
			String Settlement_Id1 = request.getParameter("Settlement_Id1");
			int Settlement_Id12 = Integer.parseInt(Settlement_Id1);
			String Date_of_inspection1 = request.getParameter("Dateofinspection");
			String fullcontractno = request.getParameter("fullcontractno");
			String Challan_No1 = request.getParameter("Challan_No1");
			// String MR_No1 = request.getParameter("MR_No1");
			// String Bale_Mark1 = request.getParameter("Bale_Mark1");
			// String Jute_Variety_Grade_wise1 =
			// request.getParameter("Jute_Variety_Grade_wise1");
			// String Crop_Year1 = request.getParameter("Crop_Year1");
			// String Quality_Claim1 = request.getParameter("Quality_Claim1");
			// double Quality_Claim12 = Double.parseDouble(Quality_Claim1);
			// String Moisture_Content1 = request.getParameter("Moisture_Content1");
			// double Moisture_Content12 = Double.parseDouble(Moisture_Content1);
			// String NCV_Percentage1 = request.getParameter("NCV_Percentage1");
			// double NCV_Percentage12 = Double.parseDouble(NCV_Percentage1);

			final String filename = SupportingDocument.getOriginalFilename();
			File serverFile = new File(theDir, filename);
			SupportingDocument.transferTo(serverFile);
			double defaultValue = 0.0;

			String Inspection_by1 = request.getParameter("Inspectionby1");
			String Supporting_document1 = request.getParameter("Supportingdocument1");

			ConfirmationClaimSettlementModel confirmationClaimSettlementModel = new ConfirmationClaimSettlementModel();

			String Claim_Amount1 = request.getParameter("ClaimAmount");

			if (Claim_Amount1 != null) {

				double Claim_Amount12 = Double.parseDouble(Claim_Amount1);
				confirmationClaimSettlementModel.setClaim_Amount(Claim_Amount12);
			} else {
				double Claim_Amount12 = defaultValue;
				confirmationClaimSettlementModel.setClaim_Amount(Claim_Amount12);
			}

			String Quality_Settlement1 = request.getParameter("Quality_Settlement1");
			if (Quality_Settlement1 != null) {

				double Quality_Settlement12 = Double.parseDouble(Quality_Settlement1);
				confirmationClaimSettlementModel.setQuality_settlement(Quality_Settlement12);
			} else {
				double Quality_Settlement12 = defaultValue;
				confirmationClaimSettlementModel.setQuality_settlement(Quality_Settlement12);
			}

			String Moisture_Settlement1 = request.getParameter("Moisture_Settlement1");
			if (Moisture_Settlement1 != null) {

				double Moisture_Settlement12 = Double.parseDouble(Moisture_Settlement1);
				confirmationClaimSettlementModel.setMoisture_settlement(Moisture_Settlement12);
			} else {
				double Moisture_Settlement12 = defaultValue;
				confirmationClaimSettlementModel.setMoisture_settlement(Moisture_Settlement12);
			}

			String NCV_Settlement1 = request.getParameter("NCV_Settlement1");
			if (NCV_Settlement1 != null) {

				double NCV_Settlement12 = Double.parseDouble(NCV_Settlement1);
				confirmationClaimSettlementModel.setNcv_settlement(NCV_Settlement12);
			} else {
				double NCV_Settlement12 = defaultValue;
				confirmationClaimSettlementModel.setNcv_settlement(NCV_Settlement12);
			}

			String Settlement_Amount1 = request.getParameter("SettlementAmount");

			if (Settlement_Amount1 != null) {

				double Settlement_Amount12 = Double.parseDouble(Settlement_Amount1);
				confirmationClaimSettlementModel.setSettlement_amt(Settlement_Amount12);
			} else {
				double Settlement_Amount12 = defaultValue;
				confirmationClaimSettlementModel.setSettlement_amt(Settlement_Amount12);
			}

			SimpleDateFormat formatter1 = new SimpleDateFormat("yyyy-mm-dd");
			Date instdate1 = formatter1.parse(Date_of_inspection1);
			confirmationClaimSettlementModel.setSettlement_id(Settlement_Id12);
			// confirmationClaimSettlementModel.setMill(Settlement_Id12);
			confirmationClaimSettlementModel.setDate_of_Inspection(instdate1);
			confirmationClaimSettlementModel.setContract_No(fullcontractno);
			confirmationClaimSettlementModel.setChallan_No(Challan_No1);

			confirmationClaimSettlementModel.setInspection_by(Inspection_by1);
			confirmationClaimSettlementModel.setSupporting_doc(Supporting_document1);

			Date date1 = new Date();
			confirmationClaimSettlementModel.setInspection_date(date1);
			confirmationClaimSettlementModel.setDispute_flag(0);
			confirmationClaimSettlementModel.setOM_Official("vishal");
			confirmationClaimSettlementModel.setMill("1");
			confirmationClaimSettlementModel.setFA_Official("Pradeep");
			confirmationClaimSettlementModel.setCreated_by("kailash");
			confirmationClaimSettlementModel.setCreated_on(date1);

			this.confirmationofClaimSettlementService.create(confirmationClaimSettlementModel);
			redirectAttributes.addFlashAttribute("msg",
					"<div class=\"alert alert-success\"><b>Success !</b> Record saved successfully.</div>\r\n" + "");

		} catch (Exception e) {

			e.printStackTrace();
		}
		if (username == null) {
			return new ModelAndView("index");
		}

		return new ModelAndView(new RedirectView("entryofConfirationSettelment.obj"));
	}

	@RequestMapping("saveentryofGenrationbill")
	public ModelAndView saveentryofGenrationbill(HttpServletRequest request, RedirectAttributes redirectAttributes) {
		final File theDir = new File("C:\\Users\\kailash.shah\\documentimage");
		if (!theDir.exists()) {
			theDir.mkdirs();
		}
		final ModelAndView mv = new ModelAndView();
		String username = (String) request.getSession().getAttribute("usrname");
		try {

			String Challan_No1 = request.getParameter("Challan_No1");
			String Challan_Date1 = request.getParameter("Challan_Date1");
			String Shipment_Details = request.getParameter("Shipment_Details");
			String Shipment_Value1 = request.getParameter("Shipment_Value1");
			String SGST_Amt = request.getParameter("SGST_Amt");
			String CGST_Amt = request.getParameter("CGST_Amt");
			String IGST_Amt = request.getParameter("IGST_Amt");
			String TCS_Amt = request.getParameter("TCS_Amt");
			String TDS_Amt = request.getParameter("TDS_Amt");
			String Bill_of_Supply = request.getParameter("Bill_of_Supply");
			String Invoice_Value = request.getParameter("Invoice_Value");
			String BOS_Date = request.getParameter("BOS_Date");
			String Supplier_Name = request.getParameter("Supplier_Name");
			String Supplier_GSTN = request.getParameter("Supplier_GSTN");
			String Supplier_Address = request.getParameter("Supplier_Address");
			String Recipient_Name = request.getParameter("Recipient_Name");
			String Recipient_GSTN = request.getParameter("Recipient_GSTN");
			String Recipient_Address = request.getParameter("Recipient_Address");
			String Consignee_Name = request.getParameter("Consignee_Name");
			String Consignee_GSTN = request.getParameter("Consignee_GSTN");
			String Consignee_Address = request.getParameter("Consignee_Address");
			String Conract_no = request.getParameter("Contarct_no");
			String Clientstate = request.getParameter("Clientstate");
			String Clientcode = request.getParameter("Clientcode");
			String ClientPan = request.getParameter("ClientPan");
//		       // String QtyAllowed = request.getParameter("QtyAllowed");
////		        final String filename = SupportingDocument.getOriginalFilename();
////		        File serverFile = new File(theDir, filename);
////		        SupportingDocument.transferTo(serverFile);
////		        
//		        // Conditionally set autorevolvingamount based on payment type
			SimpleDateFormat formatter1 = new SimpleDateFormat("yyyy-MM-dd");
			// Date instdate1 = formatter1.parse(Challan_Date1);
			// Date instdate2 = formatter1.parse(Challan_Date1);
			GenerationOfBillSupplyModel generationOfBillSupplyModel = new GenerationOfBillSupplyModel();
			generationOfBillSupplyModel.setChallan_No(Challan_No1);
			generationOfBillSupplyModel.setChallan_date(Challan_Date1);
			generationOfBillSupplyModel.setShipment_details(Shipment_Details);
			generationOfBillSupplyModel.setShipment_value(Shipment_Value1);
			generationOfBillSupplyModel.setSGST_amt(SGST_Amt);
			generationOfBillSupplyModel.setCGST_amt(CGST_Amt);
			generationOfBillSupplyModel.setIGST_amt(IGST_Amt);
			generationOfBillSupplyModel.setTCS_amt(TCS_Amt);
			generationOfBillSupplyModel.setTDS_amt(TDS_Amt);
			generationOfBillSupplyModel.setBill_of_supply_no(Bill_of_Supply);
			generationOfBillSupplyModel.setInvoice_value(Invoice_Value);
			generationOfBillSupplyModel.setBOS_date(BOS_Date);
			generationOfBillSupplyModel.setSupplier_name(Supplier_Name);
			generationOfBillSupplyModel.setSupplier_gSTN(Supplier_GSTN);
			generationOfBillSupplyModel.setSupplier_address(Supplier_Address);
			generationOfBillSupplyModel.setRecipient_name(Recipient_Name);
			generationOfBillSupplyModel.setRecipient_gSTN(Recipient_GSTN);
			generationOfBillSupplyModel.setRecipient_address(Recipient_Address);
			generationOfBillSupplyModel.setConsignee_name(Consignee_Name);
			generationOfBillSupplyModel.setConsignee_gSTN(Consignee_GSTN);
			generationOfBillSupplyModel.setConsignee_address(Consignee_Address);
			generationOfBillSupplyModel.setContract_no(Conract_no);

			Date date = new Date();
			generationOfBillSupplyModel.setCreation_date(date);
			generationOfBillSupplyModel.setRo_id("1");
			// generationOfBillSupplyModel.setBos_file_path("documents");
			List<Object[]> list = generationofBillService.Dispatchentry(Challan_No1);

			CashDocumentModel cashDocumentModel = new CashDocumentModel();
			cashDocumentModel.setCAD_Date(date);
			cashDocumentModel.setBOS_No(Bill_of_Supply);
			cashDocumentModel.setBOS_Date(BOS_Date);

//		          cashDocumentModel.setBOS_Date(BOS_Date);
//		          cashDocumentModel.setBOS_No(Bill_of_Supply);

			PdfGenerator_K pdfgenereatorK = new PdfGenerator_K();
			String filePath = pdfgenereatorK.generateBillPdf(Invoice_Value, Challan_No1, Shipment_Details,
					Supplier_Name, Supplier_GSTN, Supplier_Address, Recipient_Name, Recipient_GSTN, Recipient_Address,
					Consignee_Name, Consignee_GSTN, Consignee_Address, Bill_of_Supply, Conract_no, Clientstate,
					Clientcode, ClientPan, BOS_Date, list);

			generationOfBillSupplyModel.setBos_file_path(filePath);
			System.out.println(filePath);
			System.out.println(filePath);
			System.out.println(filePath);

			this.generationofBillService.create(generationOfBillSupplyModel);
			this.genrationCashDocumentService.create(cashDocumentModel);
			this.generationofBillService.billUpdation(Conract_no);

//		        
//		       
//		        this.paymentDetailService.contratTable(contractno);
			redirectAttributes.addFlashAttribute("msg",
					"<div class=\"alert alert-success\"><b>Success !</b> Record saved successfully.</div>\r\n" + "");

		} catch (Exception e) {

			e.printStackTrace();
		}
		if (username == null) {
			return new ModelAndView("index");
		}

		// Starting Email Sender

		EmailSender email = new EmailSender();
		InternetAddress[] toAddresses = null;

		String subject = "Bill of Supply attachement";

		String body = "In this All information regarding Bill of supply . ";

		String filename = "C:\\Users\\kailash.shah\\Downloads\\website.jpg";
		// String filename = "C:\\Users\\kailash.shah\\documentimage\\" + filePath;
		String username1 = "";
		try {
			// toAddresses = { new InternetAddress("vishal.vishwakarma@cyfuture.com") ,new
			// InternetAddress("animesh.anand@cyfuture.com")};

			toAddresses = new InternetAddress[] { new InternetAddress("shahkailash2000@gmail.com"),
					new InternetAddress("kailashshahsha81@gmail.com") };

		} catch (AddressException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		email.sendEmail(toAddresses, body, subject, filename, username1);

		// End Email

//
		return new ModelAndView(new RedirectView("EntryofGenerationBillsupply.obj"));
	}

	@RequestMapping("downloadPDF")
	public void downloadPDF(@RequestParam("filename") String filename, HttpServletResponse response) {
		String imageDirectory = "upload.Imagedownload";

		String imagePath = imageDirectory + File.separator + filename;

		File imageFile = new File(imagePath);

		try {

			if (imageFile.exists()) {

				String contentType = determineContentType1(filename);
				response.setContentType(contentType);

				response.setContentLength((int) imageFile.length());
				response.setHeader("Content-Disposition", "attachment; filename=billofsupplyfinal.pdf");
//			                //response.setHeader("Content-Disposition", "");

				FileInputStream fileInputStream = new FileInputStream(imageFile);
				OutputStream responseOutputStream = response.getOutputStream();
//
				byte[] buffer = new byte[1024];
				int bytesRead;
				while ((bytesRead = fileInputStream.read(buffer)) != -1) {
					responseOutputStream.write(buffer, 0, bytesRead);
				}
//
				fileInputStream.close();
				responseOutputStream.close();
			} else {
				response.setStatus(HttpServletResponse.SC_NOT_FOUND);
			}
		} catch (IOException e) {
//			            
			e.printStackTrace();
			response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
		}
	}

	private String determineContentType1(String filePath) {
		if (filePath.endsWith(".pdf")) {
			return "application/pdf";
		} else if (filePath.endsWith(".jpg") || filePath.endsWith(".jpeg")) {
			return "image/jpeg";
		} else if (filePath.endsWith(".png")) {
			return "image/png";
		} else {
			return "application/octet-stream";
		}
	}
//			 

	@RequestMapping({ "ViewofGenerationBillsupply" })
	public ModelAndView viewBillofSupplyReciept(final HttpServletRequest request) {
		String username = (String) request.getSession().getAttribute("usrname");
		ModelAndView mv = new ModelAndView("viewGenerationBill");
		if (username == null) {
			mv = new ModelAndView("index");
		}

		final List<GenerationOfBillSupplyModel> GenerationOfBill = (List<GenerationOfBillSupplyModel>) this.generationofBillService
				.getAll();
		mv.addObject("GenerationOfBill", GenerationOfBill);

		return mv;
	}

	@ResponseBody
	@RequestMapping(value = "fetchingdata1", method = RequestMethod.GET)
	public String hodinofetch1(@RequestParam("contractno") String contractno1) {

		List<Object[]> BI_no = generationofBillService.contarctno(contractno1);
		System.err.println("resultList++++++++++" + BI_no);
		Gson gson = new Gson();
		String resultString = new Gson().toJson(BI_no);
		return resultString;// gson.toJson((Object)millRecieptModelt1);
	}

	@ResponseBody
	@RequestMapping(value = "fetchingdataforbill", method = RequestMethod.GET)
	public String fetchingdatanominactionclaimforbill(@RequestParam("contractno") String contractno) {
		List<Object[]> millRecieptModelt1 = generationofBillService.contarctnoformaster(contractno);
		System.err.println("resultList++++++++++" + millRecieptModelt1);
		Gson gson = new Gson();
		String resultString = new Gson().toJson(millRecieptModelt1);
		return resultString;// gson.toJson((Object)millRecieptModelt1);
	}

	@RequestMapping("entry_of_transportation_and_operation_cost")
	public ModelAndView entry_of_transportation_and_operation_cost(HttpServletRequest request) {
		String username = (String) request.getSession().getAttribute("usrname");
		ModelAndView mv = new ModelAndView("entryoftransportandoperationcost");
		if (username == null) {
			mv = new ModelAndView("index");
		}
		final List<RoDetailsModel> RegionList = (List<RoDetailsModel>) this.roDetailsservice.getAll();
		final List<OperationCostModel> operationcostlist = (List<OperationCostModel>) this.operationcostservice
				.getAll();

		mv.addObject("RegionList", (Object) RegionList);
		mv.addObject("operationcostlist", (Object) operationcostlist);
		return mv;
	}

	@RequestMapping("savetransportcost")
	public ModelAndView savetransportcost(HttpServletRequest request, RedirectAttributes redirectAttributes) {
		String username = (String) request.getSession().getAttribute("usrname");
		if (username == null) {
			return new ModelAndView("index");
		}
		try {
			Date date = new Date();
			int istransport = Integer.valueOf(request.getParameter("istransport"));
			String dpc = request.getParameter("alldpc");
			final List<String> list = (List<String>) this.purchaseCenterService.dpcbyId(dpc);
			String cropyear = request.getParameter("cropyear");
			String rocode = request.getParameter("region");
			String region = this.roDetailsservice.findregionbyid(rocode);
			String operationcost = request.getParameter("operationcost");
			Double rate = Double.valueOf(request.getParameter("rate"));
			String unit = request.getParameter("unit");
			String validtilldate = request.getParameter("validtilldate");
			int i = (int) request.getSession().getAttribute("userId");
			String createdBy = String.valueOf(i);

			System.out.println("DPCCCCC" + dpc);
			OperationAndTransportCostModel operationcostmodel = new OperationAndTransportCostModel();

			operationcostmodel.setIs_transport(istransport);
			operationcostmodel.setDpc(String.join(",", list));
			operationcostmodel.setCrop_year(cropyear);
			operationcostmodel.setRegion(region);
			operationcostmodel.setOperation_cost_head(operationcost);
			operationcostmodel.setRate(rate);
			operationcostmodel.setUnit(unit);
			operationcostmodel.setValid_till(validtilldate);
			operationcostmodel.setCreated_date(date);
			operationcostmodel.setCreated_by(createdBy);

			this.operationCostservice.create(operationcostmodel);

			redirectAttributes.addFlashAttribute("msg",
					"<div class=\"alert alert-success\"><b>Success !</b> Record created successfully.</div>\r\n" + "");
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
		}
		redirectAttributes.addFlashAttribute("msg",
				(Object) "<div class=\"alert alert-success\"><b>Success !</b> Record saved successfully.</div>\r\n");

		return new ModelAndView(new RedirectView("entryoftransportandoperationcost.obj"));
	}

	@RequestMapping({ "view_transportation_and_operation_cost" })
	public ModelAndView view_transportation_and_operation_cost(final HttpServletRequest request) {
		String username = (String) request.getSession().getAttribute("usrname");
		ModelAndView mv = new ModelAndView("Viewtransportationandoperationcost");
		if (username == null) {
			return new ModelAndView("index");
		}
		try {

			List<OperationAndTransportCostModel> viewcostlist = (List<OperationAndTransportCostModel>) operationCostservice
					.getAlllist();
			mv.addObject("viewcostlist", (Object) viewcostlist);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mv;
	}

	@RequestMapping("Factors_involved_in_Commercial_Price")
	public ModelAndView Factors_involved_in_Commercial_Price(HttpServletRequest request) {
		String username = (String) request.getSession().getAttribute("usrname");
		ModelAndView mv = new ModelAndView("FactorsinvolvedinCommercialPrice");
		if (username == null) {
			mv = new ModelAndView("index");
		}
		// final List<RoDetailsModel> RegionList =
		// (List<RoDetailsModel>)this.roDetailsservice.getAll();
		// final List<OperationCostModel> operationcostlist =
		// (List<OperationCostModel>)this.operationcostservice.getAll();

		// mv.addObject("RegionList", (Object)RegionList);
		// mv.addObject("operationcostlist", (Object)operationcostlist);
		return mv;
	}

	@RequestMapping(value = { "saveFactorCommercial" }, method = { RequestMethod.GET })
	public ModelAndView saveFactorCommercial(final HttpServletRequest request,
			final RedirectAttributes redirectAttributes, HttpSession session) {
		try {
			String username = (String) request.getSession().getAttribute("usrname");
			if (username == null) {
				return new ModelAndView("index");
			}
			int user = (int) request.getSession().getAttribute("userId");
			String createdBy = String.valueOf(user);

			String Factor_Head = request.getParameter("Factor_Head");
			String Unit = request.getParameter("Unit");
			String Applicability = request.getParameter("Applicability");
			String Status = request.getParameter("Status");
			String identification = request.getParameter("identification");
			Factor_Head = Factor_Head.replaceAll("\\[", "").replaceAll("\\]", "").replaceAll("\"", "");
			Unit = Unit.replaceAll("\\[", "").replaceAll("\\]", "").replaceAll("\"", "");
			Applicability = Applicability.replaceAll("\\[", "").replaceAll("\\]", "").replaceAll("\"", "");
			Status = Status.replaceAll("\\[", "").replaceAll("\\]", "").replaceAll("\"", "");
			String[] allstatus = Status.split(",");
			String[] allapplicability = Applicability.split(",");
			String[] allunit = Unit.split(",");
			String[] allfactorhead = Factor_Head.split(",");

			Date currentdate = new Date();

			final List<FactorssInvolvedCommercial> allList = new ArrayList();
			int i = 0;
			for (String unit1 : allunit) {

				FactorssInvolvedCommercial factorsinvolved = new FactorssInvolvedCommercial();
				factorsinvolved.setIdentification_no(identification);
				factorsinvolved.setFactor_head(allfactorhead[i]);
				factorsinvolved.setUnit(allunit[i]);
				factorsinvolved.setApplicability(allapplicability[i]);
				factorsinvolved.setStatus(Integer.parseInt(allstatus[i]));
				factorsinvolved.setCreated_by(createdBy);
				factorsinvolved.setCreated_on(currentdate);
				allList.add(factorsinvolved);
				i++;
			}
			this.factorsinvolvedservice.create(allList);

			// System.out.println(allList);
			redirectAttributes.addFlashAttribute("msg",
					"<div class=\"alert alert-success\"><b>Success !</b> Record created successfully.</div>\r\n" + "");

			return new ModelAndView(new RedirectView("listofFactorsinvolvedinCommercialPrice.obj"));
		} catch (Exception e) {
			e.printStackTrace();
		}

		return new ModelAndView(new RedirectView("listofFactorsinvolvedinCommercialPrice.obj"));
	}

	@RequestMapping("listofFactorsinvolvedinCommercialPrice")
	public ModelAndView list_of_lFactors_involvedin_CommercialPrice(HttpServletRequest request) {
		String username = (String) request.getSession().getAttribute("usrname");
		ModelAndView mv = new ModelAndView("viewFactorsinvolvedinCommercialPrice");
		if (username == null) {
			mv = new ModelAndView("index");
		}

		List<FactorssInvolvedCommercial> list = (List<FactorssInvolvedCommercial>) this.factorsinvolvedservice.getAll();
		mv.addObject("allFIC", list);

		return mv;
	}
	@RequestMapping("HOdispatchInst")
    public ModelAndView HODispatchInstructionModel(HttpServletRequest request) {
           String username = (String) request.getSession().getAttribute("usrname");
           List<String> contractList = (List<String>) hoInstService.getContract();

           System.err.println(contractList);
           ModelAndView mv = new ModelAndView("HOdispatchinstruction");
           mv.addObject("ContractList", contractList);
           if (username == null) {
                  mv = new ModelAndView("index");
           }

           List<Object[]> ronameList = (List<Object[]>) hoInstService.getRoname();
           System.err.println(ronameList);
           mv.addObject("ronameList", ronameList);

           return mv;
    }

    @ResponseBody
    @RequestMapping(value = "HoDispatch", method = RequestMethod.GET)
    public String hoDispatchIn(@RequestParam("contract") String ContractNo) {
           System.err.println(ContractNo);
           List<String> contractDetList = (List<String>) hoInstService.getDetails(ContractNo);

           Gson gson = new Gson();
           String jsonResponse = gson.toJson(contractDetList);

           return jsonResponse;
    }

    @ResponseBody
    @RequestMapping({ "findDpc" })
    public String findDpcByRegion(@RequestParam("id") String id, HttpServletRequest request) {

           String username = (String) request.getSession().getAttribute("usrname");
           final Gson gson = new Gson();
           return gson.toJson((Object) this.purchaseCenterService.purchaseCenter(request.getParameter("id")));

    }

    @ResponseBody
    @RequestMapping({ "countHo" })
    public String countHo(@RequestParam("reg") String reg, HttpServletRequest request) {

           final Gson gson = new Gson();
           return gson.toJson((Object) this.hoInstService.getCount(reg));

    }

    @RequestMapping(value = "savehodispatchInst", method = RequestMethod.POST)
    public ModelAndView hoDispatchInstruction(HttpServletRequest request, RedirectAttributes redirectAttributes) {
           String username = (String) request.getSession().getAttribute("usrname");
           try {
                  
                  /*
                  * String juteString = request.getParameter("jutevariety");//
                  * System.err.println("++++++++++++"); System.err.println("++++++++++++");
                  * System.err.println("++++++++++++"); System.err.println("++++++++++++");
                  * System.err.println("++++++++++++"); System.err.println(juteString);
                  * System.err.println(juteString); System.err.println(juteString);
                  * System.err.println(juteString); System.err.println(juteString);
                  * System.err.println(juteString);
                  */
                  
                  String[] variety = request.getParameterValues("jutevariety");
                  
                  for(String st: variety) {
                        System.err.println(st);
                        System.err.println(st);
                        Integer usId = (Integer) request.getSession().getAttribute("userId");//
                        System.err.println(usId);
                        String user = Integer.toString(usId);
                        System.err.println(user);
                        String contNo = request.getParameter("fullcontractno");//
                        System.err.println(contNo);
                        String crpyrString = request.getParameter("cropyear");//
                        System.err.println(crpyrString);
                        String contqtyString = request.getParameter("contractquantity");//
                        System.err.println(contqtyString);
                        Double cQtyDouble = Double.parseDouble(contqtyString);//
                        System.err.println(cQtyDouble);
                        String dIString = request.getParameter("dateofdi");//
                        
                        String dateStr = request.getParameter("dateofdi");
                       SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd");
                       Date result = formater.parse(dateStr);
                       SimpleDateFormat newFormater = new SimpleDateFormat("dd-MM-yyyy");
                      
                        
                        
                        System.err.println(dIString);
                        String fcString = request.getParameter("FC_Ref_No");//
                        System.err.println(fcString);
                        String diNoString = request.getParameter("uniqueno");//
                        System.err.println(diNoString);
                        String contDateString = request.getParameter("contractdate");//
                        System.err.println(contDateString);
                        String allowQty = request.getParameter("qty");//
                        System.err.println(allowQty);
                        Double qtyDouble = Double.parseDouble(allowQty);
                        System.err.println(qtyDouble);
                        String regOfficeString = request.getParameter("region");//
                        System.err.println(regOfficeString);
                        String[] dpcString = request.getParameterValues("dpc_name");
                        System.err.println(dpcString);
                        String lastShipString = request.getParameter("lastdateofshipment");//
                        
                        String dateStr1 = request.getParameter("lastdateofshipment");
                       SimpleDateFormat formater1 = new SimpleDateFormat("yyyy-MM-dd");
                       Date result1 = formater1.parse(dateStr1);
                       SimpleDateFormat newFormater1 = new SimpleDateFormat("dd-MM-yyyy");
                        System.err.println(lastShipString);
                        JciDIHoModel diHo = new JciDIHoModel();
                               String gprice0 = request.getParameter(st+"0");
                               if (gprice0 == null) {
                                      gprice0 = "0";
                               }
                               Double g0 = Double.parseDouble(gprice0);
                               String gprice1 = request.getParameter(st+"1");
                               if (gprice1 == null) {
                                      gprice1 = "0";
                               }
                               Double g1 = Double.parseDouble(gprice1);
                               
                               String gprice2 = request.getParameter(st+"2");
                                if (gprice2 == null) {
                                      gprice2 = "0";
                               }
                               Double g2 = Double.parseDouble(gprice2);
                               
                               String gprice3 = request.getParameter(st+"3");
                               if (gprice3 == null) {
                                      gprice3 = "0";
                               }
                               Double g3 = Double.parseDouble(gprice3);
                               
                               String gprice4 = request.getParameter(st+"4");
                               if (gprice4 == null) {
                                      gprice4 = "0";
                               }
                               Double g4 = Double.parseDouble(gprice4);
                               
                               String gprice5 = request.getParameter(st+"5");
                               if (gprice5 == null) {
                                      gprice5 = "0";
                               }
                               Double g5 = Double.parseDouble(gprice5);
                               
                               String gprice6 = request.getParameter(st+"6");
                               if (gprice6 == null) {
                                      gprice6 = "0";
                               }
                               Double g6 = Double.parseDouble(gprice6);
                               
                               String gprice7 = request.getParameter(st+"7");
                               if (gprice7 == null) {
                                      gprice7 = "0";
                               }
                               Double g7 = Double.parseDouble(gprice7);
                               
                               
                               
                               String remString = request.getParameter("remarks");
                               System.err.println(remString);
                               Date date = new Date(); // your Date object
                               SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
                               String formattedDate = formatter.format(date);
                               System.err.println(date);
                               diHo.setContracted_Qty(cQtyDouble);
                               diHo.setContract_No(contNo);
                               diHo.setFC_Ref_No(fcString);
                               diHo.setContract_Date(contDateString);
                               diHo.setDI_Date(newFormater.format(result));
                               diHo.setDI_no(diNoString);
                               diHo.setAllowed_qty(qtyDouble);
                               diHo.setRegional_office(regOfficeString);
                               String s = "";
                               /* int n = dpcString.length; */
                               if (dpcString != null) {
                               int n = dpcString.length;
                               for (int i = 0; i < dpcString.length; i++) {
                                      if (i == n - 1) {
                                             s += dpcString[i];
                                      } else
                                             s += dpcString[i] + ",";
                                      System.err.println(s);
                               }
                               }
                               else s="";
                               diHo.setDPC(s);
                               diHo.setLast_date_of_Shipment(newFormater1.format(result1));
                               diHo.setJute_variety(st);
                               diHo.setRemarks(remString);
                               
                                 diHo.setGr1_qty(g0); 
                                 diHo.setGr2_qty(g1);
                                 diHo.setGr3_qty(g2);
                                 diHo.setGr4_qty(g3);
                                 diHo.setGr5_qty(g4); 
                                 diHo.setGr6_qty(g5);
                                 diHo.setGr7_qty(g6); 
                                 diHo.setGr8_qty(g7);
                               
                               diHo.setCreated_by(user);
                                diHo.setCrop_year(crpyrString);
                               diHo.setCreation_date(formattedDate);
                               this.hoInstService.create(diHo);
                        
                  }
                  
                  
                  
                  
                  
                  
                  
                  
                  redirectAttributes.addFlashAttribute("msg",
                               "<div class=\"alert alert-success\"><b>Success !</b> Record saved successfully.</div>\r\n" + "");

           } catch (Exception e) {
                  System.out.println("++++++++++++++" + e);
                  e.printStackTrace();

           }
           if (username == null) {
                  return new ModelAndView("index");
           }
           return new ModelAndView(new RedirectView("HOdispatchInst.obj"));
    }

    @RequestMapping("jcilist")
    public String jciHoList(Model model) {

           List<JciDIHoModel> AllList = (List<JciDIHoModel>) hoInstService.getAll();
           model.addAttribute("AllList", AllList);

           return "ViewJCIHO";
    }
    
    @RequestMapping({"deleteHO"})
    public ModelAndView deleteHO(final HttpServletRequest request, RedirectAttributes redirectAttributes, Model model) {
           ModelAndView mv = new ModelAndView("ViewJCIHO");
             try {
               String id = request.getParameter("id");
               String string = hoInstService.getContractNo(id);
               String flag = hoInstService.check(string);
               
               System.err.println(flag); // Assuming these print statements are for debugging
               
               if ("0".equals(flag)) {
                 List<JciDIHoModel> allList = hoInstService.getAll();
                 mv.addObject("AllList",allList);
                 redirectAttributes.addFlashAttribute("msg", "<div class=\"alert alert-danger\"><b>Error!</b> Data cannot be deleted as Dispatch has been issued.</div>");
               } else if ("1".equals(flag)) {
                 hoInstService.delete(Integer.parseInt(id));
                 List<JciDIHoModel> allList = hoInstService.getAll();
                 mv.addObject("AllList",allList);
                 redirectAttributes.addFlashAttribute("msg", "<div class=\"alert alert-success\"><b>Success !</b> Data deleted successfully.</div>");
               }
             } catch (Exception e) {
               System.out.println("Error in deleting ruling market: " + e.getMessage());
               redirectAttributes.addFlashAttribute("msg", "<div class=\"alert alert-danger\"><b>Error!</b> An unexpected error occurred. Please try again.</div>");
             }
             return new ModelAndView(new RedirectView("jcilist.obj"));
           }

// List Mill Acceptence 

    @RequestMapping("viewmillAcc")
	public String ViewMillAcceptance1(Model model, HttpServletRequest request) {
		String username = (String) request.getSession().getAttribute("usrname");

		ModelAndView mv = new ModelAndView("listMillAcceptence");

		if (username == null) {

			return "index";

		}
		List<Contractgeneration> AllList = (List<Contractgeneration>) millacct.getAll();
		System.out.println(AllList + "allistttttttttttttt");
		model.addAttribute("AllList", AllList);
		return "listMillAcceptence";
	}

	

	@RequestMapping("saveMillAcceptenceFile")
	public ModelAndView millaccept(HttpServletRequest request, RedirectAttributes redirectAttributes,
			 HttpSession s)
			throws IllegalStateException, IOException {

        String  contractId= request.getParameter("contract_id"); 
    
        millacct.updatemillacceptflag(contractId);
		 redirectAttributes.addFlashAttribute("msg",
					(Object) "<div class=\"alert alert-success\"><b>Success !</b> Contract Accepted.</div>\r\n");
		
		

		return new ModelAndView(new RedirectView("viewmillAcc.obj"));

	}
	@RequestMapping("downloadSupportingDocumententMillAccept")

	public void downloadDocument(@RequestParam("filename") String filename, HttpServletResponse response) {

		String imageDirectory = "C:\\Users\\Mansi.Gupta\\Documents\\millAcceptFile"; // Replace with your image
																						// directory path

		String imagePath = imageDirectory + File.separator + filename;

		File imageFile = new File(imagePath);

		// Check if the file exists

		if (imageFile.exists()) {

			try {

				// Set the content type based on the file type

				String contentType = determineContentType(filename);

				response.setContentType(contentType);

				// Set the content length and attachment disposition

				response.setContentLength((int) imageFile.length());

				// response.setHeader("Content-Disposition", "attachment; filename=" +
				// filename);

				response.setHeader("Content-Disposition", "");

				// Stream the file content to the response

				FileInputStream fileInputStream = new FileInputStream(imageFile);

				OutputStream responseOutputStream = response.getOutputStream();

				byte[] buffer = new byte[1024];

				int bytesRead;

				while ((bytesRead = fileInputStream.read(buffer)) != -1) {

					responseOutputStream.write(buffer, 0, bytesRead);

				}

				fileInputStream.close();

				responseOutputStream.close();

			} catch (IOException e) {

				// Handle IO exception

				e.printStackTrace();

				response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);

			}

		} else {

			response.setStatus(HttpServletResponse.SC_NOT_FOUND);

		}

	}

	// Utility method to determine content type based on filename

	private String determineContentType2(String filename) {

		if (filename.endsWith(".pdf")) {

			return "application/pdf";

		} else if (filename.endsWith(".jpg") || filename.endsWith(".jpeg")) {

			return "image/jpeg";

		} else if (filename.endsWith(".png")) {

			return "image/png";

		} else {

			return "application/octet-stream"; // Default to binary data if content type is unknown

		}

	}

    
    


}

//	  ******************************************>>>>>>>>Code ends here<<<<<<<<<<*********************************************************
//	  ******************************************>>>>>>>>Code ends here<<<<<<<<<<*********************************************************
//	  ******************************************>>>>>>>>Code ends here<<<<<<<<<<*********************************************************
//	  ******************************************>>>>>>>>Code ends here<<<<<<<<<<*********************************************************
