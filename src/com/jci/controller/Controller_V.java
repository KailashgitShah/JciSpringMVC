package com.jci.controller;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static org.hamcrest.CoreMatchers.nullValue;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.sql.Struct;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.digester.ObjectParamRule;
import org.apache.poi.poifs.storage.ListManagedBlock;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.type.filter.AbstractClassTestingTypeFilter;
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
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import com.google.common.base.Supplier;
import com.google.common.net.MediaType;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.itextpdf.text.Element;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.ColumnText;
import com.itextpdf.text.pdf.PdfContentByte;
//import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;
import com.itextpdf.text.pdf.PdfStructTreeController.returnType;
import com.itextpdf.text.pdf.interfaces.PdfViewerPreferences;
import com.jci.common.Encry;
import com.jci.model.BankDraftDTO;
import com.jci.model.BillOFExchangeWithout_LC_DTO;
import com.jci.model.BillOfExchangeDTO;
import com.jci.model.BillofSupplyDocDTO;
import com.jci.model.CashDocumentModel;
import com.jci.model.ClaimSettlementReport;
import com.jci.model.ConfirmationClaimSettlementModel;
import com.jci.model.Contractgeneration;
import com.jci.model.CreditNoteDTO;
import com.jci.model.CreditNoteSettled;
import com.jci.model.CreditNoteSettledDTO;
import com.jci.model.CreditNotes;
import com.jci.model.DemandNoteDto;
import com.jci.model.EntryDerivativePrice;
import com.jci.model.EntryPaymentDetailsModel;
import com.jci.model.EntryofGradeCompositionModel;
import com.jci.model.EntryofpcsoModel;
import com.jci.model.FactorssInvolvedCommercial;
import com.jci.model.FarmerRegModel;
import com.jci.model.FcDto;
import com.jci.model.FinancialConcurenceModel;
import com.jci.model.GenerationOfBillSupplyModel;
import com.jci.model.GenerationofDocumentLCsModel;
import com.jci.model.GenrationDEmandDto;
import com.jci.model.GenrationDemandNoteModel;
import com.jci.model.HoDispatchDto;
import com.jci.model.JciDIHoModel;
import com.jci.model.JciEntryTdsModel;
import com.jci.model.Jciclaim_NominationModel;
import com.jci.model.MillRecieptModel;
import com.jci.model.MillRegistrationModel;
import com.jci.model.OperationAndTransportCostModel;
import com.jci.model.OperationCostModel;
import com.jci.model.PCSORequestLetter;
import com.jci.model.RoDetailsModel;
import com.jci.model.RoDispatchModel;
import com.jci.model.StateList;
import com.jci.model.TopSheeetDTO;
import com.jci.model.TopSheetDto;
import com.jci.model.TopsheetDetailsModel;
import com.jci.model.UserRegistrationModel;

import com.jci.model.UserRoleModel;
import com.jci.model.ZoneModel;
import com.jci.model.boenonlcDTO;
import com.jci.model.jciWeighmentEntry;

import com.jci.model.settlemetCnDnModel;
import com.jci.service.DailyPurchaseModelConfService;
import com.jci.service.DistrictService;
import com.jci.service.PurchaseCenterService;
import com.jci.service.RoDetailsService;
import com.jci.service_phase2.ConfirmationofClaimSettlementService;
import com.jci.service_phase2.ContractGenerationService2;
import com.jci.service_phase2.CreditNoteClaimSettlementService;
import com.jci.service_phase2.CreditNoteGenerationService;
import com.jci.service_phase2.EntryDerivativePriceService2;
import com.jci.service_phase2.EntryofGradeCompositionService;
import com.jci.service_phase2.EntryofTdsService;
import com.jci.service_phase2.FactorssInvolvedCommercialService;
import com.jci.service_phase2.FinancialConcurenceService;
import com.jci.service_phase2.GenerationAgaistLCsService;
import com.jci.service_phase2.GenerationofBillService;
import com.jci.service_phase2.GenratedDemandNoteService;
import com.jci.service_phase2.GenrationCashDocumentService;
import com.jci.service_phase2.HOInstService;
import com.jci.service_phase2.MillAccept;
import com.jci.service_phase2.MillRecieptService;
import com.jci.service_phase2.MillRegistrationService;
import com.jci.service_phase2.NominalOfficialService;
import com.jci.service_phase2.OperationAndTransportCostService;
import com.jci.service_phase2.OperationCostService;
import com.jci.service_phase2.PCSOReqLetterService;
import com.jci.service_phase2.PaymentDetailService;
import com.jci.service_phase2.PaymentRealizationService;
import com.jci.service.StateService;
import com.jci.service.Impl.SendMail;
import com.jci.service.Impl.sendemailBOS;
import com.jci.service.Impl_phase2.EmailSender;
import com.jci.service_phase2.PcsoentryService;
import com.jci.service_phase2.RoDispatchService;
import com.jci.service_phase2.WeighmentEntryService;
import com.jci.service_phase2.generationOfCashAgainstDispatchDocument;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.PageSize;
import com.lowagie.text.Rectangle;
import com.lowagie.text.pdf.PdfImportedPage;
import com.lowagie.text.pdf.PdfWriter;
import com.microsoft.schemas.office.excel.CTClientData;
import com.microsoft.schemas.office.excel.CTClientData.Factory;

import com.lowagie.text.pdf.BadPdfFormatException;
//import com.lowagie.text.pdf.PdfContentByte;
import com.lowagie.text.pdf.PdfCopy;
import com.lowagie.text.pdf.PdfDocument;
import com.lowagie.text.pdf.PdfGraphics2D;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.engine.export.JRPdfExporterParameter;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleOutputStreamExporterOutput;

import kotlin.Unit;
import net.sf.jasperreports.engine.*;

import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
//import com.itextpdf.text.pdf.PdfContentByte;
import net.sf.jasperreports.engine.JRException;
import com.jci.service_phase2.verifyClaimService;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

@Transactional
@Repository
@Controller
public class Controller_V {
	@Autowired
	verifyClaimService verifyClaimService;
	@Autowired
	WeighmentEntryService weighmentEntryService;
	@Autowired
	HOInstService hoInstService;

	@Autowired
	MillAccept millacct;

	@Autowired
	EntryofTdsService entryofTdsService;

	@Autowired
	NominalOfficialService nominalOfficialService;

	@Autowired
	MillRegistrationService millRegistrationService;

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
	CreditNoteClaimSettlementService creditNoteClaimSettlementService;

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

	@Autowired
	GenerationAgaistLCsService generationAgaistLCsService;

	protected Session currentSession() {
		return sessionFactory.getCurrentSession();
	}

	@Autowired
	PCSOReqLetterService genReqLetterService;
	@Autowired
	generationOfCashAgainstDispatchDocument generationOfCashAgainstDispatchDocumentService;

	// number to string

	public String convertDigitToWord(int digit) {
		if (digit < 0 || digit > 9) {
			return "Invalid digit";
		}

		String[] digitsInWords = { "zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine" };
		return digitsInWords[digit];
	}

	public String convertGroup(int group) {
		if (group == 0) {
			return ""; // Return empty string for zero group
		}

		StringBuilder groupWords = new StringBuilder();
		int hundreds = group / 100;
		int tensOnes = group % 100;

		if (hundreds > 0) {
			groupWords.append(convertDigitToWord(hundreds)).append(" hundred ");
		}

		if (tensOnes > 0) {
			if (tensOnes < 20) {
				groupWords.append(convertToWordsBelowTwenty(tensOnes));
			} else {
				int tens = tensOnes / 10;
				int ones = tensOnes % 10;
				if (tens > 0) {
					String[] tensInWords = { "", "", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty",
							"ninety" };
					groupWords.append(tensInWords[tens]);
				}
				if (ones > 0) {
					groupWords.append(" ");
					groupWords.append(convertDigitToWord(ones));
				}
			}
		}

		return groupWords.toString().trim();
	}

	private String convertToWordsBelowTwenty(int number) {
		String[] wordsBelowTwenty = { "zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine",
				"ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen",
				"nineteen" };
		return wordsBelowTwenty[number];
	}

	public String convertToWords(long number) {
		if (number < 0) {
			return "minus " + convertToWords(-number); // Handle negative numbers
		}
		if (number == 0) {
			return "zero"; // Handle zero separately
		}

		// Define a HashMap mapping place values and their corresponding words (in
		// English)
		Map<Integer, String> placeValuesMap = new HashMap<>();
		placeValuesMap.put(3, "thousand");
		placeValuesMap.put(5, "lakh");
		placeValuesMap.put(7, "crore");

		StringBuilder words = new StringBuilder();

		// Process the number in chunks of two or three digits
		int chunkSize = 2;
		int i = 0; // Counter for place values
		boolean firstChunk = true;
		while (number > 0) {
			int chunk;
			if (firstChunk) {
				chunk = (int) (number % 1000); // Extract the last three digits for the first chunk
				firstChunk = false;
				chunkSize = 3;
			} else {
				chunk = (int) (number % 100); // Extract the last two digits for subsequent chunks
			}
			number /= chunkSize == 3 ? 1000 : 100; // Remove the last two or three digits from the number

			if (chunk > 0) {
				String groupWords = convertGroup(chunk);
				if (!groupWords.isEmpty()) {
					words.insert(0, groupWords + " " + placeValuesMap.getOrDefault(i, "") + " ");
				}
			}
			i += chunkSize; // Increment the counter for the next chunk
			chunkSize = 2; // From now on, process chunks of two digits
		}

		return words.toString().trim();
	}

	public String convertDecimalPartToWords(String decimalPart) {
		StringBuilder words = new StringBuilder("point");
		for (char digitChar : decimalPart.toCharArray()) {
			int digit = Character.getNumericValue(digitChar);
			if (digit < 0 || digit > 9) {
				return "Invalid digit";
			}
			words.append(" ").append(convertDigitToWord(digit));
		}
		return words.toString();
	}

	public String convertNumberToWords(double number) {
		long integerPart = (long) number;
		String words = convertToWords(integerPart);

		String decimalPart = String.valueOf(number).split("\\.")[1];
		if (!decimalPart.equals("0")) {
			words += " " + convertDecimalPartToWords(decimalPart);
		}

		return words.trim();
	}

	public String convertNumberToCurrencyWords(double number) {
		String words = convertNumberToWords(number);
		return "Rupees " + words;
	}

	///

	// convert yyyy-MM-dd to dd-MM-yyyy
	String formateDate(String date) throws ParseException {

		SimpleDateFormat simpleDateFormatyy = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat simpleDateFormatdd = new SimpleDateFormat("dd-MM-yyyy");

		Date creationDateTime = new Date();

		Date convertFormattedDate = simpleDateFormatyy.parse(date);
		String withFormatedd = simpleDateFormatdd.format(convertFormattedDate);

		return withFormatedd;
	}

// generation of pcso request letter form	
	@RequestMapping("pcsoRequestLetter")

	public ModelAndView pcsoRequestLetter(HttpServletRequest request) {
		String username = (String) request.getSession().getAttribute("usrname");
		String cropYearString = (String) request.getSession().getAttribute("currCropYear");
		double contractedQty = genReqLetterService.getTotalContractedQty(cropYearString);
		ModelAndView mv = new ModelAndView("PCSORequestLetter");

		// get the inventory data
		List<String> cropYearList = dailyPurchaseModelConfService.getCropYear();
		List<Double> jute = dailyPurchaseModelConfService.firstLeveljute("2023-2024", "msp");
		// List<Integer> bale =
		// dailyPurchaseModelConfService.firstLevelbale("2023-2024", "MSP");
		mv.addObject("jute", jute);
		// mv.addObject("bale", bale);

		mv.addObject("totalContract", contractedQty);
		if (username == null) {
			mv = new ModelAndView("index");
		}

		List<PCSORequestLetter> topThreeRecords = genReqLetterService.getTopThreeRecords(cropYearString);
		mv.addObject("topThreeRecords", topThreeRecords);
		mv.addObject("distinctCropYear", cropYearList);

		return mv;
	}

	// get the letter head img path from config file
	@Value("${upload.letterHeadPath}")
	String letterHeadPath;

	// get the signature img path from config file
	@Value("${upload.SignaturePdf}")
	String SignaturePdf;

	// pcso request letter save controller
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
//		String crop_year = (String) request.getSession().getAttribute("currCropYear");
		double system_qty = Double.parseDouble(request.getParameter("uncontractedQty"));
		double req_qty = Double.parseDouble(request.getParameter("reqQty"));

		SimpleDateFormat simpleDateFormatdd = new SimpleDateFormat("dd-MM-yyyy");

		Date creationDateTime = new Date();

		reqDate = formateDate(reqDate);

		String creation_date = simpleDateFormatdd.format(creationDateTime);
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

	// listing page of pcso reuqest letters
	@RequestMapping("pcsoRequestLetterList")
	public ModelAndView requestList() {
		ModelAndView mv = new ModelAndView("PCSORequestLetterList");
		List<PCSORequestLetter> letters = genReqLetterService.getLetters();

		mv.addObject("letters", letters);

		return mv;
	}

	// get the dir where we have to store the generated pdf
	@Value("${upload.requestLetter}")
	String requestLetterPath;

	// send thankyou mail to jc office
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

		InternetAddress[] toAddresses = { new InternetAddress("pradeepcyf24@gmail.com") };

		SendMail sendMail = new SendMail();

		CompletableFuture.runAsync(() -> {
			try {
				sendMail.sendEmail(toAddresses, body, sub, filePath, refNo + ".pdf");
				// Your email sending code here
			} catch (Exception e) {
				e.printStackTrace();
			}
		});

		genReqLetterService.setEmailStatus(id, 1);

//		return new ResponseEntity<>("{\"redirect\": \"pcsoRequestLetterList.obj\"}", HttpStatus.OK);
		// return new ModelAndView("pcsoRequestLetterList.obj");

	}

	// get file from the server
	@Value("${upload.requestLetter}")
	String requestLetterpath;

	// pcso letter download
	@RequestMapping(value = "downloadRequestLetter", method = RequestMethod.GET)
	public void downloadRequestLetter(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String fileName = request.getParameter("imagePath");
		String fullPath = requestLetterpath + File.separator + fileName;

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

	// get the contract letter path
	@Value("${upload.contractLetterJava}")
	String contractLetterJava;

	@Value("${upload.authorizedContracts}")
	String authorizedContracts;

	// download contract letter
	@RequestMapping(value = "downloadContractLetter", method = RequestMethod.GET)
	public void downloadContractLetter(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String fileName = request.getParameter("imagePath");
		String fullPath = authorizedContracts + File.separator + fileName;

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

	// download Unauthorized contract letter
	@RequestMapping(value = "downloadUnAuthContractLetter", method = RequestMethod.GET)
	public void downloadUnAuthContractLetter(HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		String fileName = request.getParameter("imagePath");
		String fullPath = contractLetterPath + File.separator + fileName;

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

	// delete pcso request
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

	// form page of entryofPcso
	@RequestMapping("entryofpcso")
	public ModelAndView EntryofpcsoModel(HttpServletRequest request, RedirectAttributes redirectAttributes) {
		String username = (String) request.getSession().getAttribute("usrname");
		ModelAndView mv = new ModelAndView("entryofpcso");

		// String referenceno = request.getParameter("referenceno");
//		if (referenceno != null) {
//			String pcsodate = request.getParameter("pcsoDate");
//			String pcsoReqdate = request.getParameter("pcsoReqDate");
//			String pcsoQty = request.getParameter("pcsoQty");
//			String pcsoReqQty = request.getParameter("pcsoReqQty");
//			String letterRefNo = request.getParameter("letterRefNo");
//			String juteRatio = request.getParameter("juteRatio");
//			String dispatchPeriod = request.getParameter("dispatchPeriod");
//
//			mv.addObject("referenceno", referenceno);
//			mv.addObject("pcsoQty", pcsoQty);
//			mv.addObject("pcsoReqQty", pcsoReqQty);
//			mv.addObject("pcsodate", pcsodate);
//			mv.addObject("pcsoReqdate", pcsoReqdate);
//			mv.addObject("letterRefNo", letterRefNo);
//			mv.addObject("dispatchPeriod", dispatchPeriod);
//			mv.addObject("juteRatio", juteRatio);
//
//		}

		final List<Object[]> allentryofpcsolist = this.pcsoentryservice.getAlldata();
		List<String> allRequestLetterRefNo = this.pcsoentryservice.getAllRequest();
		mv.addObject("entryofpcsolist", allentryofpcsolist);
		mv.addObject("allRefNo", allRequestLetterRefNo);
		if (username == null) {
			mv = new ModelAndView("index");
		}
		return mv;
	}

	// disable screen with all prefield value
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
			String cropyr = request.getParameter("cropyr");
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
				entryofpcsoCopy.setCropYear(cropyr);
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
			mv.addObject("cropyr", cropyr);

		} catch (Exception e) {
			System.out.println(e);
		}

		return mv;
	}

	// save Entry of pcso
	@RequestMapping("saveentryofpcsodata")
	public ModelAndView entryofpcsosave(HttpServletRequest request, RedirectAttributes redirectAttributes) {
		String username = (String) request.getSession().getAttribute("usrname");
		try {

			int count = Integer.valueOf(request.getParameter("count"));
			Date date = new Date();
			String referenceno = request.getParameter("referenceno");
			String pcsDate = request.getParameter("pcsoDate");
			String pcsoReqdate = request.getParameter("pcsoReqDate");
			String cropyr = request.getParameter("cropyr");
			String dispatchPeriod = request.getParameter("dispatchPeriod");

			pcsDate = formateDate(pcsDate);
			pcsoReqdate = formateDate(pcsoReqdate);
			dispatchPeriod = formateDate(dispatchPeriod);

			Double pcsoQty = Double.parseDouble(request.getParameter("pcsoQty")) * 10;
			Double pcsoReqQty = Double.parseDouble(request.getParameter("pcsoReqQty")) * 10;

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
				entryofpcso.setCropYear(cropyr);
				entryofpcso.setCreated_date(date);
				entryofpcso.setPcsoQty(pcsoQty);
				entryofpcso.setPcsoReqQty(pcsoReqQty);

				// dynamic values
				String millcode = request.getParameter("millcode" + i);
				String millname = request.getParameter("millname" + i);
				Double tallocation = Double.parseDouble(request.getParameter("totalallocation" + i)) * 10;
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

	// pcso listing page
	@RequestMapping("pcsolist")
	public ModelAndView pcsolist(HttpServletRequest request) {
		String username = (String) request.getSession().getAttribute("usrname");
		ModelAndView mv = new ModelAndView("pcsolist");
		List<String> refNos = pcsoentryservice.getUniqueRefNos();
		mv.addObject("refNos", refNos);
		if (username == null) {
			mv = new ModelAndView("index");
		}
		return mv;
	}

	// get mill details based on refno
	@ResponseBody
	@RequestMapping(value = { "getAllMillDetails" }, method = { RequestMethod.GET })
	public String getAllMillDetails(final HttpServletRequest request) {
		String refNo = request.getParameter("refNo");
		List<EntryofpcsoModel> allMills = this.pcsoentryservice.getAllMillDetailsOfRefNo(refNo);

		Gson gson = new Gson();
		return gson.toJson(allMills);

	}

	// pcso delete
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

	// update pcso
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

	// updating pcso details
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

	// get mill code for the particular pco date
	@ResponseBody
	@RequestMapping(value = { "getMillCodeForPcoDate" }, method = { RequestMethod.GET })
	public String getMillCodeForPcoDate(final HttpServletRequest request) {
		String pcoDate = request.getParameter("pcoDate");
		List<String> allMillCode = this.pcsoentryservice.getMillCodeForPcoDate(pcoDate);

		Gson gson = new Gson();
		return gson.toJson(allMillCode);

	}

	// ---------------------------------------------------------
	// Contract generation
	// ---------------------------------------------------------

	// contract generation page
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

	// get the contract letter path from config file
	@Value("${upload.contractLetter}")
	String contractLetterPath;

	// saving the grade composition and also generation of the contract letter of
	// the mill, its also having func of pdg generation and sending email
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

		// ArrayList<String> pcsoDate = (ArrayList<String>) requestBody.get("pcsoDate");
		// String commaSeparatedPcsoDates = String.join(",", pcsoDate);

		ArrayList<String> juteVariety = (ArrayList<String>) requestBody.get("juteGradesArray");
		ArrayList<String> systemComp = (ArrayList<String>) requestBody.get("systemComp");
		String gradeComp = (String) requestBody.get("gradeComp");
//		String sysComArray = (String) requestBody.get("systemComp");

//		pcsoDate = pcsoDate.replaceAll("\\[", "").replaceAll("\\]", "").replaceAll("\"", "'");
		gradeComp = gradeComp.replaceAll("\\[", "").replaceAll("\\]", "").replaceAll("\"", "'");
		// sysComArray = sysComArray.replaceAll("\\[", "").replaceAll("\\]",
		// "").replaceAll("\"", "'");

		final List<String> gradeArray = Arrays.asList(gradeComp.split(","));
		// final List<String> sysCompList = Arrays.asList(sysComArray.split(","));

//		for (String jutString : juteVariety)
//			System.err.println(jutString);
//
//		for (String date : pcsoDate)
//			System.err.println(date);
//
//		for (String s : systemComp)
//			System.err.println(s);
//		
//		for (String s : gradeArray)
//			System.err.println(s);

		// return null;

		// entry of grade composition....
//
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

		// entry in the grade composition table
		for (int i = 0; i < juteVariety.size(); i++) {
			EntryofGradeCompositionModel entryofGradeCompositionModel = new EntryofGradeCompositionModel();
			Double ProposedValue = Double.parseDouble(gradeArray.get(i));
			Double systemValue = Double.parseDouble(systemComp.get(i));
			entryofGradeCompositionModel.setJute_combination(juteVariety.get(i));
			entryofGradeCompositionModel.setSystem_composition(systemValue);
			entryofGradeCompositionModel.setProposed_composition(ProposedValue);
			entryofGradeCompositionModel.setRemark(remarks);
			entryofGradeCompositionModel.setCrop_year(cropYear);
			entryofGradeCompositionModel.setAvailable_qty(availableQty);
			entryofGradeCompositionModel.setLabel_name(lableName);
			entryofGradeCompositionModel.setCreated_by(refId);
			entryofGradeCompositionModel.setCreated_date(created_Date);
			entryofGradeCompositionService.create(entryofGradeCompositionModel);
		}

		List<Object[]> GradePriceList = contractGenerationService2.getListOfGradesPriceForMillDelivery(cropYear);

		for (Map<String, String> millDetail : millDetails) {

			Contractgeneration contractgeneration = new Contractgeneration();

			int juteValue = Integer.parseInt(millDetail.get("juteValue"));
			String millCode = millDetail.get("millCode");
			String millNameString = millDetail.get("millName");

			ArrayList<String> pcsoDateForMill = new ArrayList<>();

			Object pcsoDateForMillObj = millDetail.get("pcsoDateForMill");
			if (pcsoDateForMillObj instanceof ArrayList) {
				pcsoDateForMill = (ArrayList<String>) pcsoDateForMillObj;

			} else {
				System.err.println("pcsoDateForMill is not an ArrayList<String>");
			}

			List<Object> fullAddress = contractGenerationService2.getFullAddressByMillName(millNameString);

			Double millQty = Double.parseDouble(millDetail.get("Qty"));
			String deliveryType = millDetail.get("delivery_type");
			String finalGeneratedContractNo = "JCI/" + millCode + "/" + cropYear + "/" + contractIdn;

			String commaSeparatedPcsoDates = String.join(",", pcsoDateForMill);

			String[] dateStrings = commaSeparatedPcsoDates.split(",");

			String formatedPcsoDateWithQuotes = "";
			for (String dates : dateStrings) {
				formatedPcsoDateWithQuotes += "'" + dates + "',";
			}

			formatedPcsoDateWithQuotes = formatedPcsoDateWithQuotes.substring(0,
					formatedPcsoDateWithQuotes.length() - 1);

			contractGenerationService2.setPcsoFlag1(formatedPcsoDateWithQuotes);
			List<String> refNos = contractGenerationService2.findRefNos(formatedPcsoDateWithQuotes);

			String refNosString = String.join(",", refNos);

			contractgeneration.setPcso_date(commaSeparatedPcsoDates);
			contractgeneration.setContract_identification_no(contractIdn);
			contractgeneration.setContract_qty(contractQty);
			contractgeneration.setContract_date(contractdate);
			contractgeneration.setDelivery_type(deliveryType);
			contractgeneration.setContract_no(finalGeneratedContractNo);

			String millFullName = contractGenerationService2.millFullName(millCode);

			// contract value = 105% of jute value or fiberValue
			contractgeneration.setContract_value((int) (juteValue * 1.05));
			// contract value LC = 110% of jute value or fiberValue

			contractgeneration.setContractValueLc((int) (juteValue * 1.1));

			contractgeneration.setCreated_date(new Date());
			contractgeneration.setCreated_by(refId);
			contractgeneration.setGrade_composition(lableName);
			contractgeneration.setMill_code(millCode);
			contractgeneration.setCropYear(cropYear);
			contractgeneration.setMill_name(millFullName);
			contractgeneration.setJute_value(juteValue);
			contractgeneration.setMill_qty(millQty);
			contractgeneration.setSortingId(SortingId);

			String fileName = contractIdn + "Contract" + millCode + ".pdf";
			contractgeneration.setContract_acceptance_doc(fileName);

//			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
//			LocalDate currentDate = LocalDate.now();
//			LocalDate tenDaysAfter = currentDate.plusDays(14); // Add 10 days
//			contractgeneration.setPayment_duedate(tenDaysAfter.format(formatter));

			// System.err.println(contractgeneration.toString());

			PdfGenerator pdfGenerator = new PdfGenerator();
			String filePath = contractLetterPath + File.separator + contractIdn;

			File parentDir = new File(filePath);
			if (!parentDir.exists()) {
				parentDir.mkdirs();
			}

			filePath += File.separator + contractIdn + "Contract" + millCode + ".pdf";

			pdfGenerator.generatePdfOfContractLetter(finalGeneratedContractNo, millFullName, millCode, millQty,
					cropYear, GradePriceList, gradeArray, juteVariety, fileName, deliveryType, contractdate, filePath,
					letterHeadPath, fullAddress, commaSeparatedPcsoDates, refNosString);

//			// send email
//			String body = "Please find below attachment to get full details of contract grade wise..";
//			String sub = "Contract Details";
//			final String filePathDir = filePath;
//			SendMail sendMail = new SendMail();
//			InternetAddress[] toAddresses = {  new InternetAddress("cyfuturetest@gmail.com"),
//					new InternetAddress("pradeepcyf24@gmail.com") };
//
//			CompletableFuture.runAsync(() -> {
//				try {
//					sendMail.sendEmail(toAddresses, body, sub, filePathDir, fileName);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			});

			// Authorization allotment

			if (juteValue > 40000000) {
				contractgeneration.setAuthorizedBy("HO Operation");
			} else {
				contractgeneration.setAuthorizedBy("HO Manager");
			}

			contractGenerationService2.create(contractgeneration);
		}

		return "Saved";
	}

	// listing of the contract list
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

	// get details of the contract on the basis of the pcso dates
	@ResponseBody
	@RequestMapping(value = { "getAllContractDetails" }, method = { RequestMethod.GET })
	public String getAllContractDetails(final HttpServletRequest request) {
		String contractidn = request.getParameter("contract");
		String pcsoDates = request.getParameter("pcsoDates");
		List<Contractgeneration> allMillUnderContract = this.contractGenerationService2
				.getContractFullDetails(contractidn, pcsoDates);

		Gson gson = new Gson();
		return gson.toJson(allMillUnderContract);

	}

	@ResponseBody
	@RequestMapping(value = "getPscoDateByCropYr", method = RequestMethod.GET)
	public String getPscoDateByCropYr(HttpServletRequest request) {
		String cropYr = request.getParameter("cropYr");
		List<String> pcsoDates = contractGenerationService2.getPscoDateByCropYr(cropYr);
		Gson gson = new Gson();
		return gson.toJson(pcsoDates);

	}

	@ResponseBody
	@RequestMapping(value = "populateContract", method = RequestMethod.GET)
	public String pcso_details(HttpServletRequest request) {

		String pcsoDates = request.getParameter("pcso_dates");
		String grades = request.getParameter("grades");
		String cropyr = request.getParameter("cropyr");

		// String deliveryType = request.getParameter("deliveryType");

		pcsoDates = pcsoDates.replaceAll("\\[", "").replaceAll("\\]", "").replaceAll("\"", "'");
		grades = grades.replaceAll("\\[", "").replaceAll("\\]", "").replaceAll("\"", "'");

		final List<String> pcsoArray = Arrays.asList(pcsoDates.split(","));
		final List<String> gradeArray = Arrays.asList(grades.split(","));

		ModelAndView pcso = contractGenerationService2.pcso_details(pcsoArray, gradeArray, cropyr);
		Gson gson = new Gson();
		return gson.toJson(pcso);

	}

	// update price on the basis of delivery type
	@ResponseBody
	@RequestMapping(value = "updateContractedValue", method = RequestMethod.GET)
	public String updateContractedValue(final HttpServletRequest request) {

		String deliveryType = request.getParameter("deliveryType");
		String totalQtyOfMill = request.getParameter("totalQtyOfMill");
		String grades = request.getParameter("grades");
		String cropyr = request.getParameter("cropyr");
		grades = grades.replaceAll("\\[", "").replaceAll("\\]", "").replaceAll("\"", "'");
		final List<String> gradeArray = Arrays.asList(grades.split(","));

		int updatedVal = contractGenerationService2.updateContractedValue(deliveryType, totalQtyOfMill, gradeArray,
				cropyr);

		return updatedVal + "";
	}

	// listing of the Contract list for the authorization

	@RequestMapping("authorization")
	public ModelAndView contractAuthorization(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView("ContractAuthorization");
		String username = (String) request.getSession().getAttribute("usrname");
		if (username == null) {
			mv = new ModelAndView("index");
		}

		List<Contractgeneration> listOfAllUnAuthorizedContract = contractGenerationService2
				.getAllUnAuthorizedContract();
		mv.addObject("contracts", listOfAllUnAuthorizedContract);
		return mv;
	}

	// function generates JCI/870/2023-2024/BT-03,JCI/870/2023-2024/BT-04 to
	// 'JCI/870/2023-2024/BT-03','JCI/870/2023-2024/BT-04',

	public String quoteContractNo(String contract) {
		String[] contractNos = contract.split(",");
		String qutoedAns = "";
		for (String no : contractNos)
			qutoedAns += "'" + no + "',";
		return qutoedAns;
	}

	// contract authorization
	@ResponseBody
	@RequestMapping(value = "contractAuthorizationByIdnNo", method = RequestMethod.GET)
	public void Authorize(HttpServletRequest request, RedirectAttributes redirectAttributes)
			throws AddressException, IOException, com.itextpdf.text.DocumentException {

		String contractNOString = request.getParameter("contractNo");
		String[] contractNos = contractNOString.split(",");

		try {
			String quotedContractString = quoteContractNo(contractNOString);
			quotedContractString = quotedContractString.substring(0, quotedContractString.length() - 1);

			contractGenerationService2.setContractAuthrizeStatus(quotedContractString);

		} catch (Exception e) {
			// TODO: handle exception
		}
		String date = new SimpleDateFormat("dd-MM-yyyy").format(new Date());

		for (String contract : contractNos) {
			String[] contractNo = contract.split("/");

			String fileName = contractNo[3] + "Contract" + contractNo[1] + ".pdf";

			String filePath = contractNo[3] + File.separator + fileName;

			String loginName = (String) request.getSession().getAttribute("loginName");
			String completeFilePathForOutput = authorizedContracts + File.separator + filePath;

			File newOutputFile = new File(completeFilePathForOutput);
			if (!newOutputFile.getParentFile().exists()) {
				newOutputFile.getParentFile().mkdirs(); // Create parent directories if they don't exist
			}

			OutputStream outputStream = new FileOutputStream(completeFilePathForOutput);

			PdfReader reader = new PdfReader(contractLetterPath + File.separator + filePath);
			PdfStamper stamper = new PdfStamper(reader, outputStream);

			// Add your new content
			PdfContentByte content = stamper.getOverContent(1); // Page number where the new content needs to be added
			// ColumnText.showTextAligned(content, Element.ALIGN_CENTER, new Phrase("This is
			// a sample text line for pdf generation."), 300, 400, 0);

			// Add "Authorized By" content at the bottom
			ColumnText.showTextAligned(content, Element.ALIGN_RIGHT, new Phrase("Authorized By: " + loginName), 545, 50,
					0);
			ColumnText.showTextAligned(content, Element.ALIGN_RIGHT, new Phrase(date), 540, 666, 0);

			// Close the PdfStamper
			stamper.close();

			try {
				// send email
				String body = "Please find below attachment to get full details of contract grade wise..";
				String sub = "Contract Details";
				final String filePathDir = contractLetterPath + File.separator + filePath;
				SendMail sendMail = new SendMail();
				InternetAddress[] toAddresses = { new InternetAddress("pradeepcyf24@gmail.com") };

				CompletableFuture.runAsync(() -> {
					try {
						sendMail.sendEmail(toAddresses, body, sub, filePathDir, fileName);
					} catch (Exception e) {
						e.printStackTrace();
					}
				});

			} catch (Exception e) {
				// TODO: handle exception
			}

//			PdfReader reader = new PdfReader(contractLetterPath + File.separator + filePath);
//			String deString = "C:/Users/pradeep.rathor/Desktop/NewVisitor";
//			PdfWriter writer = new PdfWriter(contractLetterPath + File.separator + filePath);
//			PdfDocument pdfDoc = new PdfDocument(reader, writer);
//			
//			  PdfPTable table = new PdfPTable(2);
//			    table.getDefaultCell().setPadding(5f); // Code 1
//			    table.setHorizontalAlignment(Element.ALIGN_LEFT);
//			    PdfPCell cell; 
//			   table.addCell("Age");
//			
//			pdfDoc.close();

		}

//		return new ResponseEntity<>("{\"redirect\": \"pcsoRequestLetterList.obj\"}", HttpStatus.OK);
		// return new ModelAndView("pcsoRequestLetterList.obj");

	}

	// ---------------------------------------------------------
	// Entry Of Derivative Price
	// ---------------------------------------------------------

	// derivative price form
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

	// edit page of the derivative price
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

	// update the ED price
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

	// listing of the price list
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

	// delete controller
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

	// save ed price
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

	// grade composition page
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

	// save grade compo
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

	// delete grades
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

	// listing of the grade composition
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

	// edit grade comp.
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

	// update grade comp.
	@RequestMapping("updateGradeComp")
	public ModelAndView updateEGC(HttpServletRequest request) {
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

	// ro dispatch view page

	// ---------------------------------------------------------
	// Generation Of Credit Notes
	// ---------------------------------------------------------

	// listing page of the volunteer credit note generation form
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

	// set all the contract details in session and redirect to the generate credit
	// note form page in the ajax response
//	@ResponseBody
	@RequestMapping("generateCrn")
	public ModelAndView generateCrn(final HttpServletRequest request, RedirectAttributes redirectAttributes,
			HttpSession session) {

		String challan = (String) request.getParameter("challan");

		List<Object> list = creditNoteGenerationService.getChallanDetails(challan);

		Object[] rowObject = (Object[]) list.get(0);

//	 select a.Bill_of_supply_no,a.BOS_date ,a.Contract_no ,a.Challan_No,
//	 a.Invoice_value, b.Nominal_wt , b.Dpc_actual_wt ,c.Mill_name , c.DI_No
//	  ,a.Ro_id,c.Mill_code from  jcibos_generation a INNER JOIN jciweighment_entry b 
//	  on b.Verification_status = 1 and a.Bill_of_supply_no = b.Bos_no and a.Challan_No = '242503270002'
//	 inner JOIN jcidispatch_details c on a.Challan_No = c.Challan_no

		String bosNo = (String) rowObject[0];
		String bosDate = (String) rowObject[1];
		String contractNo = (String) rowObject[2];
		String ChallanNo = (String) rowObject[3];
		String invoiceVal = (String) rowObject[4];
		double nominalWt = (Double) rowObject[5];
		double actualWt = (Double) rowObject[6];
		String diNo = (String) rowObject[8];
		String roId = (String) rowObject[9];
		String millCode = (String) rowObject[10];
		String dpc = (String) rowObject[11];
		String gstCode = (String) rowObject[12];

		System.err.println("roId from controller => " + roId);

		int getGstCount = creditNoteGenerationService.getGstCount(gstCode);
		int count = creditNoteGenerationService.getTotalCount();
		double avgJuteVal = creditNoteGenerationService.getAvgJuteValue(ChallanNo);
		List<Object[]> dispetchDetails = creditNoteGenerationService.getDispatchDetails(ChallanNo);
		List<Object> gradeRatio = creditNoteGenerationService.getGradeRatio(ChallanNo);

		ModelAndView mv = new ModelAndView("generationOfCreditNote");
		mv.addObject("ContractNo", contractNo);
		mv.addObject("nominalWeight", nominalWt);
		mv.addObject("ActualWeight", actualWt);
		mv.addObject("ChallanNo", ChallanNo);
		mv.addObject("roId", roId);
		// all india
		mv.addObject("Count", count);
		mv.addObject("invoiceVal", invoiceVal);
		mv.addObject("avgJuteVal", avgJuteVal);
		mv.addObject("diNo", diNo);
		mv.addObject("bosNo", bosNo);
		mv.addObject("bosDate", bosDate);
		mv.addObject("millcode", millCode);
		mv.addObject("dispetchDetails", dispetchDetails);
		mv.addObject("gradeRatio", gradeRatio);
		mv.addObject("dpc", dpc);
		mv.addObject("gst", gstCode);
		// state
		mv.addObject("getGstCount", getGstCount);

		return mv;
	}

	// credit note form page
//	@RequestMapping("creditNoteForm")
//	public ModelAndView creditNoteForm(HttpServletRequest request) {
//
//		String username = (String) request.getSession().getAttribute("usrname");
//
//		if (username == null) {
//			return new ModelAndView("index");
//		}
//
//		ModelAndView mView = new ModelAndView("generationOfCreditNote");
//		return mView;
//	}

	@Value("${upload.creditNoteDetails}")
	String creditNoteFilePath;

	@Value("${upload.creditNoteJRXML}")
	String creditNoteJRXML;

	// save credit note

	@RequestMapping(value = { "saveCreditNote" })
	public ModelAndView saveCreditNoteDetails(final HttpServletRequest request, HttpServletResponse response)
			throws IllegalStateException, IOException {

		String username = (String) request.getSession().getAttribute("usrname");
		if (username == null) {
			return new ModelAndView("index");
		}
		;

		final String shipmentDetails = request.getParameter("shipment");
		final String crnDate = request.getParameter("cnDate");
		final String crnNo = request.getParameter("cnNo");
		final String ChallanNo = request.getParameter("ChallanNo");
		final String contractNo = request.getParameter("contractNo");
		final String bosNo = request.getParameter("bosNo");
		final String diNo = request.getParameter("diNo");
		final String bosDate = request.getParameter("bosDate");
		final String millcode = request.getParameter("millcode");
		final String dpc = request.getParameter("dpc");
		final String roId = request.getParameter("roId");
		final String gstCode = request.getParameter("gstCode");
		final String invoiceValue = request.getParameter("invoiceValue");

		final Double shortQty = Double.parseDouble(request.getParameter("shortQty"));
		final Double nominalWt = Double.parseDouble(request.getParameter("bosQty"));
		final Double actualWt = Double.parseDouble(request.getParameter("actualQty"));
		final Double crnAmount = Double.parseDouble(request.getParameter("creditAmt"));
		int refId = (int) request.getSession().getAttribute("userId");

		PdfGenerator pdfGenerator = new PdfGenerator();

//		String supplier_Name = "The Jute Corporation of India Limited";
//		String supplier_GSTN = "19AABCT8820B1ZH";
//		String unit_GSTN = supplier_GSTN;
//		String supplier_Address = "Vill-Dhaipukur, RMC Complex, PO-Pandua Dist-Hooghly, 712449";

//		 a.unit_name, a.unit_address1,  a.unit_state,   a.unit_location, b.client_gstin, b.client_pan,
//		 b.client_state, b.client_address1,  b.client_name, a.client_unit_code 
		// Crop_year,Bale_mark,Jute_variety,Jute_grade,No_of_bales,Nominal_wt,Rate,Nominal_qty

		List<Object[]> millFullDetailsList = creditNoteGenerationService.getMillDetailsByCode(millcode);
		List<Object[]> dispetchDetails = creditNoteGenerationService.getDispatchDetails(ChallanNo);
		List<Object[]> getDetailsofSpp_Con_Rec = creditNoteGenerationService.getDetailsofSpp_Con_Rec(bosNo);
		List<Object[]> getStateAndPan = creditNoteGenerationService.getStateAndPan(millcode);
		List<Object[]> getStateAndCodeOfSupplier = creditNoteGenerationService.getStateAndCodeOfSupplier(dpc);
		// List<Object> gradeRatio =
		// creditNoteGenerationService.getGradeRatio(ChallanNo);

//		for (Object[] row : millFullDetailsList) {
//			unit_name = (String) row[0];
//			unit_address = (String) row[1];
//			client_name = (String) row[8];
//			client_GSTN = (String) row[4];
//			client_state = (String) row[6];
//			client_code = (String) row[2];
//			client_address1 = (String) row[7];
//			client_pan = (String) row[5];
//		}

		int sumOfBale = 0;
		for (Object[] details : dispetchDetails) {
			sumOfBale += (int) details[3];
		}

		List<Object[]> finalList = new ArrayList<>();
		List<CreditNoteDTO> creditNoteDtoList = new ArrayList<>();
		// double factor = Double.parseDouble(new DecimalFormat("#.##").format(actualWt
		// / sumOfBale));
		double factor = actualWt / sumOfBale;
		int counter = 1;
		String documentName = "";
		String contractDate = "";
		String diDate = "";
		String challanDate = "";
		String consigText = "";

		for (Object[] p : dispetchDetails) {
			documentName = "";
			CreditNoteDTO creditNoteDTO = new CreditNoteDTO();
			CreditNotes creditNotes = new CreditNotes();

			Object[] data = new Object[11];

			int noOfBale = (int) p[3];
			double rate = (double) p[5];
			double nmnlQty = (double) p[4];
			double actQty = Double.parseDouble(new DecimalFormat("#.##").format(noOfBale * factor));
			double shtQty = Double.parseDouble(new DecimalFormat("#.##").format(nmnlQty - actQty));
			double shortAmtPrice = Math.round(rate * shtQty);

			contractDate = (String) p[7];
			diDate = (String) p[8];
			challanDate = (String) p[9];
			consigText = (String) p[10];

			data[0] = (String) p[0]; // crop year
			data[1] = (String) p[1]; // bale mark
			data[2] = (String) p[2];// jute grade
			data[3] = (int) p[3]; // no of bale
			data[4] = (double) p[4]; // nominal qty
			data[5] = (double) p[5]; // rate
			data[6] = (double) p[6]; // nominal wt
			data[7] = rate;
			data[8] = actQty;
			data[9] = shtQty;
			data[10] = shortAmtPrice;
			finalList.add(data);

			creditNoteDTO.setSnNo(counter++);
			creditNoteDTO.setHsnNo("53031010");
			creditNoteDTO.setDesc("Raw Jute");
			creditNoteDTO.setCropYear((String) p[0]);
			creditNoteDTO.setBaleMark((String) p[1]);
			creditNoteDTO.setJuteGrade((String) p[2]);
			creditNoteDTO.setNoOfBales(noOfBale);
			creditNoteDTO.setNominalQty(nmnlQty);
			creditNoteDTO.setRate(rate);
			creditNoteDTO.setNominalWt((double) p[6]);
			creditNoteDTO.setActQty(actQty);
			creditNoteDTO.setShrtQty(shtQty);
			creditNoteDTO.setAmt(shortAmtPrice);
			creditNoteDtoList.add(creditNoteDTO);

			creditNotes.setActualQty(actQty);
			creditNotes.setBosQty(nmnlQty);
			creditNotes.setCreated_by(refId + "");
			creditNotes.setCreationDate(new Date());
			creditNotes.setCrnAmount(shortAmtPrice);
			creditNotes.setChallanNo(ChallanNo);
			creditNotes.setContractNo(contractNo);
			creditNotes.setCrnNo(crnNo);
			creditNotes.setCrnDate(crnDate);
			creditNotes.setGstCode(gstCode);
			creditNotes.setJuteGrade((String) p[2]);
			// creditNotes.setShipmentDetails(shipmentDetails);
			creditNotes.setRoId(roId);
			creditNotes.setShortQty(shtQty);
			documentName = "creditNote" + ChallanNo + ".pdf";
			creditNotes.setDocument(documentName);
			creditNoteGenerationService.create(creditNotes);

		}

		try {
			JasperReport jasperReport1 = JasperCompileManager.compileReport(creditNoteJRXML);
			// .compileReport("C:\\Users\\pradeep.rathor\\Desktop\\creditNote.jrxml");
			Map<String, Object> parameters = new HashMap<String, Object>();

			parameters.put("crnNo", crnNo);
			parameters.put("crnDate", crnDate);
			parameters.put("ChallanNo", ChallanNo + " dt." + challanDate);

			parameters.put("contractNo", contractNo + " dt." + contractDate);
			parameters.put("bosNo", bosNo + " dt." + bosDate);
			parameters.put("diNo", diNo + " dt." + diDate);
			parameters.put("consignNo", consigText + " dt." + diDate);
			parameters.put("sumCrnAmt", crnAmount);
			parameters.put("sumAct", actualWt);
			parameters.put("sumInv", nominalWt);
			parameters.put("sumShrt", shortQty);
			String amountInWord = convertNumberToCurrencyWords(crnAmount);
			parameters.put("amountInWord", amountInWord + " Only");

			for (Object[] details : getDetailsofSpp_Con_Rec) {
				parameters.put("Supplier_name", details[0]);
				parameters.put("Supplier_address", details[1]);
				parameters.put("Supplier_gSTN", details[2]);
				parameters.put("Recipient_name", details[3]);
				parameters.put("Recipient_address", details[4]);
				parameters.put("Recipient_gSTN", details[5]);
				parameters.put("Consignee_name", details[6]);
				parameters.put("Consignee_address", details[7]);
				parameters.put("Consignee_gSTN", details[8]);
			}

			for (Object[] row : getStateAndCodeOfSupplier) {
				parameters.put("supplierState", row[0]);
				parameters.put("supplierStateCode", row[1] + "");
				String gSTIN = (String) row[2];
				String pan = gSTIN.substring(2, 12);

				parameters.put("supplierGSTIN", gSTIN);
				parameters.put("supplierPan", pan);
			}

			if (getStateAndPan.size() == 2) {
				for (Object[] obj : getStateAndPan) {
					parameters.put("recipientPan", obj[0]);

					if (obj[2].equals(obj[4] + "")) {
						parameters.put("ConsigneeState", obj[3]);
						parameters.put("ConsigneeStateCode", obj[4] + "");

					} else {
						parameters.put("recipientState", obj[3]);
						parameters.put("recipientStateCode", obj[4] + "");

					}

				}

			} else {
				for (Object[] obj : getStateAndPan) {
					parameters.put("recipientPan", obj[0]);
					parameters.put("recipientState", obj[3]);
					parameters.put("ConsigneeState", obj[3]);
					parameters.put("recipientStateCode", obj[4] + "");
					parameters.put("ConsigneeStateCode", obj[4] + "");

				}

			}

			// Prepare data sources
			JRBeanCollectionDataSource dataSource1 = new JRBeanCollectionDataSource(creditNoteDtoList);

			// Fill JasperPrints
			JasperPrint jasperPrint1 = JasperFillManager.fillReport(jasperReport1, parameters, dataSource1);
			response.setContentType("application/pdf");
			response.setHeader("Content-Disposition", "inline");
			// response.setHeader("Content-Disposition", "attachment;
			// filename=TestCreditNote.pdf");
			// try (OutputStream out = response.getOutputStream()) {

			final File theDir = new File(creditNoteFilePath);
			if (!theDir.exists()) {
				theDir.mkdirs();
			}

			String saveFile = creditNoteFilePath + File.separator + documentName;

			try (OutputStream out = new FileOutputStream(saveFile)) {
				JRPdfExporter exporter = new JRPdfExporter();
				exporter.setParameter(JRPdfExporterParameter.JASPER_PRINT, jasperPrint1);

				exporter.setParameter(JRPdfExporterParameter.OUTPUT_STREAM, out);
				exporter.exportReport();

			} catch (Exception e) {
				System.out.println(e.getLocalizedMessage());
			}

			return new ModelAndView(new RedirectView("creditNoteList.obj"));

		} catch (JRException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

//		pdfGenerator.generatePdfOfCreditNoteDoc(crnNo, crnDate, invoiceValue, ChallanNo, supplier_Name, supplier_GSTN,
//				supplier_Address, unit_name, unit_GSTN, unit_address, client_name, client_GSTN, client_address1, bosNo,
//				contractNo, client_state, client_code, bosDate, client_pan, creditNoteDTO, diNo, bosNo, creditNoteFilePath);
//		
//		pdfGenerator.generatePdfOfCreditNoteDoc(crnNo, crnDate, invoiceValue, ChallanNo, supplier_Name, supplier_GSTN,
//				supplier_Address, unit_name, unit_GSTN, unit_address, client_name, client_GSTN, client_address1, bosNo,
//				contractNo, client_state, client_code, bosDate, client_pan, finalList, diNo, bosNo, creditNoteFilePath);

		return new ModelAndView(new RedirectView("creditNoteList.obj"));
	}

	// status update of credit note
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

	// listing page of the credit note
	@RequestMapping("creditNoteList")
	public ModelAndView creditNoteList(HttpServletRequest request) {
		String username = (String) request.getSession().getAttribute("usrname");
		if (username == null) {
			return new ModelAndView("index");
		}

		ModelAndView mView = new ModelAndView("creditNoteList");

		List<Object[]> ListingCreditNotesObject = (List<Object[]>) creditNoteGenerationService.getAllCreditNotes();

		List<CreditNotes> ListingCreditNotes = new ArrayList<>();
		for (Object[] obj : ListingCreditNotesObject) {

//			
//			System.err.println((String) obj[0]);
//			System.err.println((String) obj[1]);
//			System.err.println((String) obj[2]);
//			System.err.println((double) obj[3]);
//			System.err.println((double) obj[4]);
//			System.err.println((double) obj[5]);
//			System.err.println((double) obj[6]);
//			System.err.println((String) obj[7]);

			CreditNotes creditNote = new CreditNotes();
			creditNote.setCrnDate((String) obj[0]);
			creditNote.setCrnNo((String) obj[1]);
			creditNote.setChallanNo((String) obj[2]);
			creditNote.setBosQty((double) obj[3]);
			creditNote.setActualQty((double) obj[4]);
			creditNote.setShortQty((double) obj[5]);
			creditNote.setCrnAmount((double) obj[6]);
			creditNote.setDocument((String) obj[7]);
			ListingCreditNotes.add(creditNote);

			// System.err.println(creditNote.toString() + "toString");
		}

		mView.addObject("list", ListingCreditNotes);

		return mView;
	}

	// get mill code for the particular pco date
	@ResponseBody
	@RequestMapping(value = { "showCrdNoteBy" }, method = { RequestMethod.GET })
	public String showCrdNoteBy(final HttpServletRequest request) {
		String parameter = request.getParameter("parameter");

		List<String> details = this.creditNoteGenerationService.getParamenterDetails(parameter);

		Gson gson = new Gson();
		return gson.toJson(details);

	}

	// get mill code for the particular pco date
	@ResponseBody
	@RequestMapping(value = { "showFilterdData" }, method = { RequestMethod.GET })
	public String showFilterdData(final HttpServletRequest request) {
		String parameter = request.getParameter("parameter");
		String basedOn = request.getParameter("basedOn");
		List<Object[]> details = this.creditNoteGenerationService.showFilterData(parameter, basedOn);
		Gson gson = new Gson();
		return gson.toJson(details);

	}

	@ResponseBody
	@RequestMapping(value = { "getShipmentDetailsByChallanNo" }, method = { RequestMethod.GET })
	public String getShipmentDetailsByChallanNo(final HttpServletRequest request) {
		final String challanNo = request.getParameter("challanNo");
		List<Object[]> shipmentDetails = creditNoteGenerationService.getShipmentDetailsByChallanNo(challanNo);

		Gson gson = new Gson();

		return gson.toJson(shipmentDetails);
	}

	@Value("${upload.weightmentDoc}")
	String weightmentDoc;

	@Value("${upload.dispatchDoc}")
	String dispatchDoc;

	// pcso letter download
	@RequestMapping(value = "downloadCreditNoteDocs", method = RequestMethod.GET)
	public void downloadCreditNoteDocs(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String[] fileName = request.getParameter("imagePath").split(" ");

		String fullPath = "";

		if (fileName[1].equals("creditNote"))
			fullPath = creditNoteFilePath + File.separator + fileName[0];
		else if (fileName[1].equals("weightment")) {
			fullPath = weightmentDoc + File.separator + fileName[0];
		} else if (fileName[1].equals("consignment")) {
			fullPath = dispatchDoc + File.separator + fileName[0];
		} else {
			fullPath = creditNoteFilePath + File.separator + fileName[0];
		}

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

	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// ---------------------------------------------------------
	// Credit For Claim Settlement
	// ---------------------------------------------------------

	@RequestMapping("creditNoteForClaimSettlement")
	public ModelAndView ViewCreditNoteForClaimSettmenet(HttpServletRequest request) {
		String username = (String) request.getSession().getAttribute("usrname");
		ModelAndView mv = new ModelAndView("creditNoteClaimSettlement");
		if (username == null) {
			mv = new ModelAndView("index");
		}

		List<String> allSettlementId = creditNoteClaimSettlementService.getAllSettlementId();
		mv.addObject("allSettlementId", allSettlementId);
		return mv;
	}

	@ResponseBody
	@RequestMapping(value = { "viewAllChallanOfSettlemetId" }, method = { RequestMethod.GET })
	public String viewAllChallanAgainstSettlementId(final HttpServletRequest request) {
		String settlementId = request.getParameter("setId");
		List<Object[]> details = this.creditNoteClaimSettlementService.viewAllChallan(settlementId);
		Gson gson = new Gson();
		return gson.toJson(details);

	}

	@Value("${upload.creditNoteSettledJRXML}")
	String creditNoteSettledJRXML;

	@Value("${upload.creditNoteSettlement}")
	String creditNoteSettlementPath;

	@ResponseBody
	@RequestMapping(value = { "saveCrnForClaim" }, method = { RequestMethod.POST })
	public String saveCrnForClaim(final HttpServletRequest request, HttpServletResponse response)
			throws IllegalStateException, IOException, ParseException {
		String settlementId = request.getParameter("settlementId");

		List<String> challans = this.creditNoteClaimSettlementService.getDistinctChallanOfSettlementId(settlementId);
		String todayDate = new SimpleDateFormat("dd-MM-yyyy").format(new Date());

		// crnNo
		//
		Calendar calendar = Calendar.getInstance();
		int currentYear = calendar.get(Calendar.YEAR);
		int currentMonth = calendar.get(Calendar.MONTH) + 1; // Calendar.MONTH is zero-based

		int financialYearStart, financialYearEnd;

		if (currentMonth >= 4) { // April or later
			financialYearStart = currentYear;
			financialYearEnd = currentYear + 1;
		} else { // January to March
			financialYearStart = currentYear - 1;
			financialYearEnd = currentYear;
		}

		double total = 0;
		String endYearLastTwoDigits = Integer.toString(financialYearEnd).substring(2);

		String uniqueCllan = "";
		int getGstCount = 0;
		int count = 0;
		for (String challan : challans) {
			List<CreditNoteSettledDTO> creditNoteSettleDtoList = new ArrayList<>();
			List<Object[]> detailsOfChallan = this.creditNoteClaimSettlementService.viewFullChallanDetails(challan);
			String gstCode = (String) detailsOfChallan.get(0)[26];
			String ro = (String) detailsOfChallan.get(0)[27];
			String dpc = (String) detailsOfChallan.get(0)[28];
			String mrNo = (String) detailsOfChallan.get(0)[30];
			String cropYr = (String) detailsOfChallan.get(0)[31];

			String[] roArray = ro.split("--");
			String[] dpcArray = dpc.split("--");

			if (uniqueCllan.equals("")) {
				getGstCount = creditNoteClaimSettlementService.getGstCount(gstCode) + 1;
				count = creditNoteClaimSettlementService.getTotalCount() + 1;
				uniqueCllan = challan;
			} else if (uniqueCllan.equals(challan)) {

			} else {
				getGstCount = creditNoteClaimSettlementService.getGstCount(gstCode) + 1;
				count = creditNoteClaimSettlementService.getTotalCount() + 1;
				uniqueCllan = challan;
			}

			String yearCode = endYearLastTwoDigits;
			String indiaSerialNo = String.format("%06d", count);
			String gstSerialNo = String.format("%05d", getGstCount);

			String CrnNo = "CS" + yearCode + indiaSerialNo + gstCode + gstSerialNo;

			String bosNo = (String) detailsOfChallan.get(0)[14];
			String bosDate = (String) detailsOfChallan.get(0)[15];
			String contractNo = (String) detailsOfChallan.get(0)[16];
			String millCode = (String) detailsOfChallan.get(0)[20];

			String diNo = (String) detailsOfChallan.get(0)[22];

			SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
			SimpleDateFormat fdf = new SimpleDateFormat("dd-MM-yyyy");

			String diDate = fdf.format(sf.parse((Date) detailsOfChallan.get(0)[23] + ""));
			String contractDate = fdf.format(sf.parse((Date) detailsOfChallan.get(0)[24] + ""));
			String challanDate = fdf.format(sf.parse((Date) detailsOfChallan.get(0)[25] + ""));
			String claimDate = fdf.format(sf.parse((Date) detailsOfChallan.get(0)[29] + ""));
			String mrDate = fdf.format(sf.parse((Date) detailsOfChallan.get(0)[32] + ""));
			String consignNo = (String) detailsOfChallan.get(0)[33];

			List<Object[]> getDetailsofSpp_Con_Rec = creditNoteGenerationService.getDetailsofSpp_Con_Rec(bosNo);
			List<Object[]> getStateAndPan = creditNoteGenerationService.getStateAndPan(millCode);
			List<Object[]> getStateAndCodeOfSupplier = creditNoteGenerationService
					.getStateAndCodeOfSupplier(dpcArray[0]);

			String documentName = "";
			int counter = 1;
			for (Object[] datas : detailsOfChallan) {

				CreditNoteSettledDTO creditNoteSettledDTO = new CreditNoteSettledDTO();
				String baleMark = (String) datas[0];
				String grade = (String) datas[2];
				double noOfBale = (double) datas[3];

				double actualWt = (double) datas[4];

				double qualitySettlemt = (double) datas[5];
				double moistureSettlement = (double) datas[6];
				double ncvSettlement = (double) datas[7];
				double dustSettlement = (double) datas[8];

				double qualityMill = (double) datas[9];
				double moistureMill = (double) datas[10];
				double ncvMill = (double) datas[11];
				double dustMill = (double) datas[12];

				double claimAmount = (double) datas[13];

				creditNoteSettledDTO.setSnNo(counter++);
				creditNoteSettledDTO.setBaleMark(baleMark);
				creditNoteSettledDTO.setNoOfBale(noOfBale);
				creditNoteSettledDTO.setGrade(grade);
				creditNoteSettledDTO.setActualQty(actualWt);
				creditNoteSettledDTO.setClaimAmount(claimAmount);

				creditNoteSettledDTO.setQualitySettlement(qualitySettlemt);
				creditNoteSettledDTO.setMoistureSettlement(moistureSettlement);
				creditNoteSettledDTO.setNcvSettlement(ncvSettlement);
				creditNoteSettledDTO.setDustSettlement(dustSettlement);

				creditNoteSettledDTO.setQualityMill(qualityMill);
				creditNoteSettledDTO.setMoistureMill(moistureMill);
				creditNoteSettledDTO.setNcvMill(ncvMill);
				creditNoteSettledDTO.setDustMill(dustMill);
				creditNoteSettledDTO.setCropYr(cropYr);
				creditNoteSettleDtoList.add(creditNoteSettledDTO);

				CreditNoteSettled creditNoteSettled = new CreditNoteSettled();

				creditNoteSettled.setBales((int) noOfBale);
				creditNoteSettled.setChallanNo(challan);
				creditNoteSettled.setContractNo(contractNo);
				creditNoteSettled.setCreditNoteAmt(claimAmount);
				creditNoteSettled.setSettlementAmt(claimAmount);
				creditNoteSettled.setCreationDate(new SimpleDateFormat("dd-MM-yyyy").format(new Date()));
				creditNoteSettled.setCreditNoteDate(new SimpleDateFormat("dd-MM-yyyy").format(new Date()));
				creditNoteSettled.setCreditNoteNo(CrnNo);
				creditNoteSettled.setCrnStatus(0);
				creditNoteSettled.setGstCode(gstCode);
				creditNoteSettled.setHoDiNo(diNo);
				creditNoteSettled.setSettlemetId(settlementId);
				creditNoteSettled.setMrDate(mrDate);
				creditNoteSettled.setMrNo(mrNo);
				creditNoteSettled.setRoId(roArray[0]);
				creditNoteSettled.setVarityGrade(grade);
				documentName = "creditNoteSettllemt" + CrnNo + ".pdf";

//				System.err.println("document name => " + documentName);
//				System.err.println("Crn No => " + CrnNo);
				creditNoteSettled.setDoc(documentName);
				total += claimAmount;

				creditNoteClaimSettlementService.saveCreditNoteSettled(creditNoteSettled);
			}

			creditNoteClaimSettlementService.updateContractStatus(contractNo);

			try {
				JasperReport jasperReport1 = JasperCompileManager.compileReport(creditNoteSettledJRXML);
				// .compileReport("C:\\Users\\pradeep.rathor\\Desktop\\creditNote.jrxml");

				Map<String, Object> parameters = new HashMap<String, Object>();
				parameters.put("crnNo", CrnNo);
				parameters.put("crnDate", todayDate);
				parameters.put("ChallanNo", challan + " dt." + challanDate);

				parameters.put("contractNo", contractNo + " dt." + contractDate);
				parameters.put("bosNo", bosNo + " dt." + bosDate);
				parameters.put("diNo", diNo + " dt." + diDate);
				parameters.put("consignNo", consignNo + " dt." + challanDate);

				for (Object[] details : getDetailsofSpp_Con_Rec) {
					parameters.put("Supplier_name", details[0]);
					parameters.put("Supplier_address", details[1]);
					parameters.put("Recipient_name", details[3]);
					parameters.put("Recipient_address", details[4]);
					parameters.put("Recipient_gSTN", details[5]);
					parameters.put("Consignee_name", details[6]);
					parameters.put("Consignee_address", details[7]);
					parameters.put("Consignee_gSTN", details[8]);
				}

				for (Object[] row : getStateAndCodeOfSupplier) {
					parameters.put("supplierState", row[0]);
					parameters.put("supplierStateCode", row[1] + "");
					String gSTIN = (String) row[2];
					String pan = gSTIN.substring(2, 12);

					parameters.put("supplierGSTIN", gSTIN);
					parameters.put("supplierPan", pan);
				}

				if (getStateAndPan.size() == 2) {
					for (Object[] obj : getStateAndPan) {
						parameters.put("recipientPan", obj[0]);

						if (obj[2].equals(obj[4] + "")) {
							parameters.put("recipientState", obj[3]);
							parameters.put("recipientStateCode", obj[4] + "");

						} else {
							parameters.put("ConsigneeState", obj[3]);
							parameters.put("ConsigneeStateCode", obj[4] + "");

						}

					}

				} else {
					for (Object[] obj : getStateAndPan) {
						parameters.put("recipientPan", obj[0]);
						parameters.put("recipientState", obj[3]);
						parameters.put("ConsigneeState", obj[3]);
						parameters.put("recipientStateCode", obj[4] + "");
						parameters.put("ConsigneeStateCode", obj[4] + "");

					}

				}

				String amountInWord = convertNumberToCurrencyWords(total) + " Only";

				parameters.put("total", total + "");
				parameters.put("amountInWord", amountInWord);
				parameters.put("centerName", dpcArray[1]);
				parameters.put("regionName", roArray[1]);
				parameters.put("claimDate", claimDate);
				parameters.put("mrNo", mrNo + " dt." + mrDate);

				// Prepare data sources
				JRBeanCollectionDataSource dataSource1 = new JRBeanCollectionDataSource(creditNoteSettleDtoList);

				// Fill JasperPrints
				JasperPrint jasperPrint1 = JasperFillManager.fillReport(jasperReport1, parameters, dataSource1);
				response.setContentType("application/pdf");
				response.setHeader("Content-Disposition", "inline");
				// response.setHeader("Content-Disposition", "attachment;
				// filename=TestCreditNote.pdf");
				// try (OutputStream out = response.getOutputStream()) {

				final File theDir = new File(creditNoteSettlementPath);
				if (!theDir.exists()) {
					theDir.mkdirs();
				}

				String saveFile = creditNoteSettlementPath + File.separator + documentName;

				try (OutputStream out = new FileOutputStream(saveFile)) {
					JRPdfExporter exporter = new JRPdfExporter();
					exporter.setParameter(JRPdfExporterParameter.JASPER_PRINT, jasperPrint1);

					exporter.setParameter(JRPdfExporterParameter.OUTPUT_STREAM, out);
					exporter.exportReport();

				} catch (Exception e) {
					System.out.println(e.getLocalizedMessage());
				}

				// return new ModelAndView(new RedirectView("creditNoteList.obj"));

			} catch (JRException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		Gson gson = new Gson();
		// return gson.toJson();
		return "";

	}

	@RequestMapping("creditNoteSettlementList")
	public ModelAndView creditNoteSettlementList(HttpServletRequest request) {

		String username = (String) request.getSession().getAttribute("usrname");
		if (username == null) {
			return new ModelAndView("index");
		}

		List<Object[]> list = creditNoteClaimSettlementService.getAllCreditNoteSettlement();

		List<CreditNoteSettled> ListingCreditNoteSettled = new ArrayList<>();
		for (Object[] obj : list) {

			CreditNoteSettled creditNote = new CreditNoteSettled();
			creditNote.setChallanNo((String) obj[1]);
			creditNote.setContractNo((String) obj[2]);
			creditNote.setBales((int) obj[3]);
			creditNote.setCreditNoteDate((String) obj[5]);

			creditNote.setCreditNoteNo((String) obj[8]);
			creditNote.setHoDiNo((String) obj[11]);
			creditNote.setMrDate((String) obj[12]);
			creditNote.setMrNo((String) obj[13]);
			creditNote.setVarityGrade((String) obj[16]);
			creditNote.setSettlementAmt((double) obj[15]);
			creditNote.setDoc((String) obj[17]);
			ListingCreditNoteSettled.add(creditNote);

			// System.err.println(creditNote.toString() + "toString");
		}

		ModelAndView mView = new ModelAndView("CreditNoteSettlementList");

		mView.addObject("list", ListingCreditNoteSettled);

		return mView;

	}

	@RequestMapping(value = "downloadCreditNoteSettledDocs", method = RequestMethod.GET)
	public void downloadCreditNoteSettledDocs(HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		String fileName = request.getParameter("imagePath");

		String fullPath = creditNoteSettlementPath + File.separator + fileName;

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

	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

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

	// Entry controller of payment details page
	@RequestMapping("EntryofPaymentDetails")
	public ModelAndView EntryofpiModelDetails(HttpServletRequest request) {
		String username = (String) request.getSession().getAttribute("usrname");
		ModelAndView mv = new ModelAndView("EntryofPaymentDetails");
		if (username == null) {
			mv = new ModelAndView("index");
		}

		// List<Object> getsumofInstrumentValue =
		// this.paymentDetailService.getsumofInstrumentValue();
		List<Object> getcontractList1 = this.paymentDetailService.ContractNo();
		List<Object[]> getcontractList2 = this.paymentDetailService.Millname();

		mv.addObject("getcontractList1", getcontractList1);
		mv.addObject("getcontractList2", getcontractList2);
		return mv;

	}

	// Initiate payment document path
	@Value("${upload.PaymentDocument}")
	String PaymentDocument;

	// save the data of payment detail data
	@RequestMapping("saveentryofpaymentinstrumentDetails")
	public ModelAndView saveentryofPID(HttpServletRequest request, RedirectAttributes redirectAttributes,
			@RequestParam("SupportingDocument") final MultipartFile SupportingDocument) {

		final File theDir = new File(PaymentDocument);
		if (!theDir.exists()) {
			theDir.mkdirs();
		}

		String originalFilename = SupportingDocument.getOriginalFilename();
		String uniqueFilename = generateUniqueFilename(originalFilename);
		File serverFile = new File(theDir, uniqueFilename);

		// Check if the file has already been uploaded
		if (!serverFile.exists()) {
			try {
				SupportingDocument.transferTo(serverFile);
			} catch (IllegalStateException e) {

				e.printStackTrace();
			} catch (IOException e) {

				e.printStackTrace();
			}
		}
		final ModelAndView mv = new ModelAndView();

		String username = (String) request.getSession().getAttribute("usrname");
		try {
			String[] selectedContracts = request.getParameterValues("contract");
			String[] contractValue2 = request.getParameterValues("contractValue[]");
			String[] paymentDueDate2 = request.getParameterValues("paymentDueDate[]");

			String ratiosJson = request.getParameter("ratios");
			double[] ratios = new Gson().fromJson(ratiosJson, double[].class);
			for (int i = 0; i < selectedContracts.length; i++) {

				String st = selectedContracts[i];
				double ratio = ratios[i];
				String contractvalueajax = contractValue2[i];
				String paymentDueDateajax = paymentDueDate2[i];
				System.out.println(ratio);

				String InstrumentValue = request.getParameter("InstrumentValue");
				double InstrumentValue1 = Double.parseDouble(InstrumentValue);
				double instvalue = ratio * InstrumentValue1;
				int intValue1 = (int) instvalue;

				String millname65 = request.getParameter("millname65");
				String Instrument = request.getParameter("Instrument");
				String instdate = request.getParameter("instdate");
				String IFSC = request.getParameter("IFSC");
				String Branch = request.getParameter("Branch");
				String BankName = request.getParameter("BankName");
				String payment = request.getParameter("paymenttype");

				String dateofexpiry = request.getParameter("dateofexpiry");
				String dateofship = request.getParameter("dateofship");

				System.err.println(dateofship);
				System.err.println(dateofexpiry);

				String Pyamentduedate = request.getParameter("payment_dueDate12");
				String contrcat_value23 = request.getParameter("contrcat_value23");
				String autorevolvingamount = request.getParameter("autorevolvingamount");
				// String QtyAllowed = request.getParameter("QtyAllowed");
				// String originalFilename = SupportingDocument.getOriginalFilename();

//		 	 String uniqueFilename = generateUniqueFilename(originalFilename);
////            File serverFile = new File(theDir, uniqueFilename);
////			SupportingDocument.transferTo(serverFile);
//			

//			 // Create unique identifier based on contract details
//		 	 String uniqueFilename = generateUniqueFilename(originalFilename); 
//			 File serverFile = new File(theDir,uniqueFilename);
//			 SupportingDocument.transferTo(serverFile);
//			 

				// Conditionally set autorevolvingamount based on payment type

				EntryPaymentDetailsModel entryPaymentDetailsModel = new EntryPaymentDetailsModel();

				entryPaymentDetailsModel.setInstrumentno(Instrument);
				entryPaymentDetailsModel.setMillcode(millname65);
				entryPaymentDetailsModel.setContractno(st);

				entryPaymentDetailsModel.setPaymentDue_date(paymentDueDateajax);
				entryPaymentDetailsModel.setContract_value(contractvalueajax);
//			SimpleDateFormat formatter1 = new SimpleDateFormat("yyyy-MM-dd");
//			Date instdate1 = formatter1.parse(instdate);
//			entryPaymentDetailsModel.setInstdate(instdate1);

//			
				SimpleDateFormat formatter1 = new SimpleDateFormat("yyyy-MM-dd");
				Date instdate1 = formatter1.parse(instdate);
//			SimpleDateFormat formatter2 = new SimpleDateFormat("dd-MM-yyyy");
//			String instdate3 = formatter2.format(instdate);
//			Date instdate1 = formatter2.parse(instdate3);

				// Set the time portion to midnight
				Calendar calendar = Calendar.getInstance();
				calendar.setTime(instdate1);
				calendar.set(Calendar.HOUR_OF_DAY, 0);
				calendar.set(Calendar.MINUTE, 0);
				calendar.set(Calendar.SECOND, 0);
				calendar.set(Calendar.MILLISECOND, 0);

				// Date instdateWithoutTime = calendar.getTime();
				Date instdateWithoutTime = calendar.getTime();

				// entryPaymentDetailsModel.setInstdate(instdateWithoutTime);
				entryPaymentDetailsModel.setInstdate(instdate1);
				entryPaymentDetailsModel.setPayment(payment);
				// int instruValue= Integer.parseInt(InstrumentValue);
				entryPaymentDetailsModel.setInstrumentValue(intValue1);
				// entryPaymentDetailsModel.setQtyAllowed(QtyAllowed);
				entryPaymentDetailsModel.setSupportingDocument(uniqueFilename);
				entryPaymentDetailsModel.setFc_status(0);
				String spaceString = "";

				Date date3 = new Date();
				Double flag = 0.0;

				Calendar cal = Calendar.getInstance();
				cal.setTime(instdate1);
				cal.add(Calendar.DAY_OF_MONTH, 30);
				Date newDate = cal.getTime();

				if ("NEFT/RTGS".equalsIgnoreCase(payment)) {
					autorevolvingamount = "0";
					entryPaymentDetailsModel.setAutorevolvingamount(autorevolvingamount);
					entryPaymentDetailsModel.setDateofship(spaceString);
					entryPaymentDetailsModel.setDateofexpiry(spaceString);

					entryPaymentDetailsModel.setIFSC(IFSC);
					entryPaymentDetailsModel.setBranch(Branch);
					entryPaymentDetailsModel.setBankName(BankName);

				} else if ("Cheque/DD".equalsIgnoreCase(payment)) {

					autorevolvingamount = "0";
					entryPaymentDetailsModel.setAutorevolvingamount(autorevolvingamount);
					entryPaymentDetailsModel.setDateofship(spaceString);
					entryPaymentDetailsModel.setDateofexpiry(spaceString);

					entryPaymentDetailsModel.setIFSC(IFSC);
					entryPaymentDetailsModel.setBranch(Branch);
					entryPaymentDetailsModel.setBankName(BankName);
				} else if ("Letter_of_Credit".equalsIgnoreCase(payment)) {

					entryPaymentDetailsModel.setIFSC(IFSC);
					entryPaymentDetailsModel.setBranch(Branch);
					entryPaymentDetailsModel.setBankName(BankName);

					// String dateofship1 = formatter1.parse(dateofship);
					entryPaymentDetailsModel.setDateofship(dateofship);
					System.err.println(dateofship);

					// Date dateofexpiry1 = formatter1.parse(dateofexpiry);
					entryPaymentDetailsModel.setDateofexpiry(dateofexpiry);
					System.err.println(dateofship);

					entryPaymentDetailsModel.setAutorevolvingamount(autorevolvingamount);
				}

				Date date = new Date();
				entryPaymentDetailsModel.setCreated_date(date);

				this.paymentDetailService.create(entryPaymentDetailsModel);

				this.paymentDetailService.contratTable(st);
				redirectAttributes.addFlashAttribute("msg",
						"<div class=\"alert alert-success\"><b>Success !</b> Record saved successfully.</div>\r\n"
								+ "");

			}

		} catch (Exception e) {

			e.printStackTrace();
		}
		if (username == null) {
			return new ModelAndView("index");
		}

		return new ModelAndView(new RedirectView("EntryofPaymentDetails.obj"));
	}

	String generateUniqueFilename(String originalFilename) {
		String timestamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
		return timestamp + "_" + originalFilename;
	}

	// download the support document which upload

	@RequestMapping("downloadSupportingDocument")
	public void downloadImage(@RequestParam("filename") String filename, HttpServletResponse response) {
		String imagePath = PaymentDocument + File.separator + filename;
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
				try (FileInputStream fileInputStream = new FileInputStream(imageFile);
						OutputStream responseOutputStream = response.getOutputStream()) {
					byte[] buffer = new byte[1024];
					int bytesRead;
					while ((bytesRead = fileInputStream.read(buffer)) != -1) {
						responseOutputStream.write(buffer, 0, bytesRead);
					}
				}
			} catch (IOException e) {
				// Handle IO exception
				e.printStackTrace();
				response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
			}
		} else {
			response.setStatus(HttpServletResponse.SC_NOT_FOUND);
		}
	}

	@RequestMapping("downloadDispatchDetails")
	public void downloadConsignmentNote(@RequestParam("id") String filename, HttpServletResponse response) {
		String imagePath = PaymentDocument + File.separator + filename;
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
				try (FileInputStream fileInputStream = new FileInputStream(imageFile);
						OutputStream responseOutputStream = response.getOutputStream()) {
					byte[] buffer = new byte[1024];
					int bytesRead;
					while ((bytesRead = fileInputStream.read(buffer)) != -1) {
						responseOutputStream.write(buffer, 0, bytesRead);
					}
				}
			} catch (IOException e) {
				// Handle IO exception
				e.printStackTrace();
				response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
			}
		} else {
			response.setStatus(HttpServletResponse.SC_NOT_FOUND);
		}
	}

	@Value("${upload.fcDownoad}")
	String fcDownoad;

	@RequestMapping("downloadFcdocument")
	public void downloaFcdocument(@RequestParam("filename") String filename, HttpServletResponse response) {
		String imagePath = fcDownoad + File.separator + filename;
		File imageFile = new File(imagePath);
		System.err.println(filename); // Check if the file exists
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
				try (FileInputStream fileInputStream = new FileInputStream(imageFile);
						OutputStream responseOutputStream = response.getOutputStream()) {
					byte[] buffer = new byte[1024];
					int bytesRead;
					while ((bytesRead = fileInputStream.read(buffer)) != -1) {
						responseOutputStream.write(buffer, 0, bytesRead);
					}
				}
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

	// entry Controller of the financial concurence page
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

	// ajax remark for approval and selection after fc rejection
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
			this.financialConcurenceservice.remark(remarks, contractNo, paymentId);
			this.paymentDetailService.update1(contractNo, paymentId, remarks);

			EntryPaymentDetailsModel entryPaymentDetailsModel = this.paymentDetailService.find(paymentId);
			mv.addObject("entryPaymentDetailsModel", entryPaymentDetailsModel);

			redirectAttributes.addFlashAttribute("entryPaymentDetailsModel", entryPaymentDetailsModel);

			redirectAttributes.addFlashAttribute("msg",
//
					"<div class=\"alert alert-success\"><b>Success !</b> Data rejected successfully.</div>");
			return new ResponseEntity<>("{\"redirect\":\"viewPaymentForFC.obj\"}", HttpStatus.OK);

		} catch (Exception ex) {
			return new ResponseEntity<>("Error occurred", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	// ajax remarks for bill of supply form

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

	// save the data of FC after issuing the fc and modfied data.
	@Value("${upload.fcreport}")
	String fcreport;

	@Value("${upload.fcDownoad1}")
	String fcDownoad1;

	@RequestMapping("saveFinancialConcurence")
	public ModelAndView saveentryofFC(HttpServletRequest request, RedirectAttributes redirectAttributes,
			HttpServletResponse response) {
		String username = (String) request.getSession().getAttribute("usrname");
		if (username == null) {
			return new ModelAndView("index");
		}

		try {
			String fullcontractno = request.getParameter("fullcontractno");
			String FC_Issue_Date = request.getParameter("FC_Issue_Date");
			String FC_Ref_No = request.getParameter("FC_Ref_No123");
			String Contracted_Qty = request.getParameter("Contracted_Qty.");
			String QtyAllowed = request.getParameter("Shipment_Value1");
			String carryingCostParam = request.getParameter("SGST_Amt1");
			String Payment_id = request.getParameter("Payment_id");
			int id = Integer.parseInt(Payment_id);
			String remarks = request.getParameter("Remarks1");

			this.paymentDetailService.remark(remarks, fullcontractno, id);

			BigInteger Carrying_Cost_Charged = BigInteger.ZERO;
			if (carryingCostParam != null && !carryingCostParam.isEmpty()) {
				try {
					double carryingCostDouble = Double.parseDouble(carryingCostParam);
					Carrying_Cost_Charged = BigInteger.valueOf((long) carryingCostDouble);
				} catch (NumberFormatException e) {
					e.printStackTrace();
				}
			}
			FinancialConcurenceModel financialConcurenceModel = new FinancialConcurenceModel();
			financialConcurenceModel.setFullcontractno(fullcontractno);

			SimpleDateFormat formatter1 = new SimpleDateFormat("yyyy-MM-dd");
			Date contdate = formatter1.parse(FC_Issue_Date);
			financialConcurenceModel.setFC_Issue_Date(contdate);
			financialConcurenceModel.setFC_Ref_No(FC_Ref_No);
			financialConcurenceModel.setContracted_Qty(Contracted_Qty);
			financialConcurenceModel.setQtyAllowed(QtyAllowed);
			financialConcurenceModel.setCarrying_Cost_Charged(Carrying_Cost_Charged);

			Date date = new Date();
			financialConcurenceModel.setCreated_date(date);
			financialConcurenceModel.setRemarks(remarks);

			this.financialConcurenceservice.create(financialConcurenceModel);
			this.paymentDetailService.update2(fullcontractno);

			String ifsc = "";
			String millcode1 = "";
			String labelname = "";

			Map<String, Object> parameters = new HashMap<>();

			List<FcDto> listOfFcdto = new ArrayList<>();

			double sum = 0.0;

			// Fetching details for report
			List<Object[]> documentsreport = this.financialConcurenceservice.DetailsForReport(fullcontractno);
			for (Object[] details : documentsreport) {
				millcode1 = (String) details[7];

				parameters.put("Contractno", details[0]);
				parameters.put("Instrument_No", details[1]);
				parameters.put("Instrument_Date", details[2]);
				parameters.put("Instrument_value", details[8]);
				parameters.put("Last_shipment_date", details[4]);
				parameters.put("Expiry_date", details[5]);
				parameters.put("Auto_revolving_amount", details[6]);
				parameters.put("contarctdate", details[9]);

				if (details[3] != null) {
					ifsc = details[3].toString();
					String url = "https://ifsc.razorpay.com/" + ifsc;

					try {
						RestTemplate restTemplate = new RestTemplate();
						String result = restTemplate.getForObject(url, String.class);
						JSONObject jsonObject = new JSONObject(result);

						String banknameString = jsonObject.optString("BANK");
						String bankaddressString = jsonObject.optString("ADDRESS");

						parameters.put("banknameString", banknameString);
						parameters.put("bankaddressString", bankaddressString);

						System.err.println("Bank Name: " + banknameString);
						System.err.println("Bank Address: " + bankaddressString);
					} catch (Exception e) {
						e.printStackTrace();
						System.err.println("Failed to retrieve or parse IFSC data");
					}
				}

			}

			// Fetching label name and delivery details
			List<Object[]> documentlabel = this.financialConcurenceservice.LabelnameAndDelivery(fullcontractno);
			for (Object[] row : documentlabel) {
				labelname = (String) row[0];
				parameters.put("deliveryType", row[1]);
			}

			List<Object[]> listofaddress = generationofBillService.contarctnoformaster(millcode1);
			for (Object[] row : listofaddress) {
				String millname = (String) row[0];
				parameters.put("millname", millname);

				String address = String.join("", (String) row[1], (String) row[2], (String) row[3], (String) row[4]);
				parameters.put("address", address);
			}

			// Fetching grade composition details
			double sumqty = Double.parseDouble(QtyAllowed);

			List<Object[]> documentforcomposition = this.financialConcurenceservice
					.gradecompositionfordetails(labelname);
			for (Object[] row : documentforcomposition) {
				FcDto fcDto1 = new FcDto();
				String composition = (String) row[0];
				fcDto1.setComposition(composition);

				double percentage = Double.parseDouble(row[1].toString());
				double compoqty = (sumqty * percentage) / 100;
				System.err.println("qty: " + compoqty);
				sum += compoqty;
				sum = Math.round(sum);
				fcDto1.setQty(compoqty);

				listOfFcdto.add(fcDto1);
			}

			parameters.put("total", sum);
			parameters.put("qtyAllowed", QtyAllowed);

			// Generating the report
			JasperReport jasperReport = JasperCompileManager.compileReport(new FileInputStream(fcreport));
			JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(listOfFcdto);
			JasperPrint jasperPrint1 = JasperFillManager.fillReport(jasperReport, parameters, dataSource);

			// Defining the file name and save path
			String fileName = "listOfFcdto" + FC_Ref_No + ".pdf";
			File directory = new File(fcDownoad1);

			if (!directory.exists()) {
				if (directory.mkdirs()) {
					System.out.println("Directory created successfully");
				} else {
					System.err.println("Failed to create directory: " + directory.getAbsolutePath());
					return null;
				}
			}

			String savePath = fcDownoad1 + File.separator + fileName;
			financialConcurenceModel.setFcdocumentDownload(fileName);

			try (OutputStream out = new FileOutputStream(savePath)) {
				JRPdfExporter exporter = new JRPdfExporter();
				exporter.setParameter(JRPdfExporterParameter.JASPER_PRINT, jasperPrint1);
				exporter.setParameter(JRPdfExporterParameter.OUTPUT_STREAM, out);
				exporter.exportReport();
			} catch (Exception e) {
				System.out.println(e.getLocalizedMessage());
			}

			response.setContentType("application/pdf");
			response.setHeader("Content-Disposition", "inline");

		} catch (Exception e) {
			e.printStackTrace();
			redirectAttributes.addFlashAttribute("msg",
					"<div class=\"alert alert-danger\"><b>Error !</b> " + e.getMessage() + "</div>");
			return new ModelAndView("errorPage");
		}

		redirectAttributes.addFlashAttribute("msg",
				"<div class=\"alert alert-success\"><b>Success !</b> Record saved successfully.</div>");
		return new ModelAndView(new RedirectView("viewFinancialConcurence.obj"));
	}

	private void fetchBankDetails(String ifsc) {

		Map<String, Object> parameters = new HashMap<>();
		String url = "https://ifsc.razorpay.com/" + ifsc;
		RestTemplate restTemplate = new RestTemplate();
		try {
			String result = restTemplate.getForObject(url, String.class);
			JSONObject jsonObject = new JSONObject(result);
			String banknameString = jsonObject.optString("BANK");
			parameters.put("banknameString", banknameString);
			// fcDto.setBankname(banknameString);
			String bankaddressString = jsonObject.optString("ADDRESS");
			parameters.put("bankaddressString", bankaddressString);
			// fcDto.setBankAddress(bankaddressString);

		} catch (Exception e) {
			System.err.println("Error fetching data for IFSC " + ifsc + ": " + e.getMessage());
		}
	}

	private void serveFileAsResponseforfc(String savePath, String fileName, HttpServletResponse response) {
		try {
			File file = new File(savePath);
			if (file.exists()) {
				response.setContentType("application/pdf");
				response.addHeader("Content-Disposition", "attachment; filename=" + fileName);
				response.setContentLength((int) file.length());

				FileInputStream fileInputStream = new FileInputStream(file);
				OutputStream responseOutputStream = response.getOutputStream();
				byte[] bytesBuffer = new byte[4096];
				int bytesRead;
				while ((bytesRead = fileInputStream.read(bytesBuffer)) != -1) {
					responseOutputStream.write(bytesBuffer, 0, bytesRead);
				}
				fileInputStream.close();
				responseOutputStream.flush();
				responseOutputStream.close();
			} else {
				response.sendError(HttpServletResponse.SC_NOT_FOUND, "File not found.");
			}
		} catch (FileNotFoundException ex) {
			System.err.println("File not found: " + ex.getMessage());
		} catch (IOException ex) {
			System.err.println("Error serving file: " + ex.getMessage());
		}
	}

	// entry controller of mill receipt
	@RequestMapping("EntryofMillreceipt")
	public ModelAndView EntryofMillreceipt(HttpServletRequest request)

	{
		String username = (String) request.getSession().getAttribute("usrname");
		ModelAndView mv = new ModelAndView("EntryofMillReciept");
		MillRecieptModel millRecieptModel = new MillRecieptModel();
		if (username == null) {
			mv = new ModelAndView("index");
		}

		// List<Object> getdataList1 = this.millRecieptService.fetchHODINO();
		List<Object[]> fetchMill_NameR = this.millRecieptService.fetchMill_NameR();

		// mv.addObject("getdataList1", getdataList1);
		mv.addObject("fetchMill_NameR", fetchMill_NameR);
		return mv;
	}

	@RequestMapping(value = "EntryofMillreceiptChild.obj", method = RequestMethod.GET)
	public ModelAndView entryOfMillReceiptChild(@RequestParam("contarctno") String contractNo,
			@RequestParam("millName") String millName, @RequestParam("hoDate") String hoDate,
			HttpServletRequest request) {
		System.err.println("EntryofMillreceiptChild");
		String username = (String) request.getSession().getAttribute("usrname");
		ModelAndView mv;

		if (username == null) {
			mv = new ModelAndView("index");
		} else {
			mv = new ModelAndView("EntryOFMillReceipt");
			System.err.println("EntryofMillreceiptChild");
			// Add any model attributes or business logic here if needed
		}
		mv.addObject("hoDate", hoDate);
		mv.addObject("millName", millName);
		mv.addObject("contractNo", contractNo);
		return mv;
	}

	// ajax controller for mill reciept service
	@ResponseBody
	@RequestMapping(value = "fetchingdata", method = RequestMethod.GET)
	public String hodinofetch(@RequestParam("contractno") String contractno) {

		List<Object[]> millRecieptModelt1 = millRecieptService.fetchdata(contractno);
		System.err.println("resultList++++++++++" + millRecieptModelt1);
		Gson gson = new Gson();
		String resultString = new Gson().toJson(millRecieptModelt1);
		return resultString;
	}

	@ResponseBody
	@RequestMapping(value = "listofpaymentdetails", method = RequestMethod.GET)
	public String listofpaymentdetails(@RequestParam("contractno") String contractno) {

		List<Object[]> millRecieptModelt1 = generationAgaistLCsService.listdetailsofpaymemt(contractno);
		System.err.println("resultList++++++++++" + millRecieptModelt1);
		Gson gson = new Gson();
		String resultString = new Gson().toJson(millRecieptModelt1);
		return resultString;
	}

	@ResponseBody
	@RequestMapping(value = "listofbillofsupply", method = RequestMethod.GET)
	public String listofbillofsupply(@RequestParam("contractno") String contractno) {

		List<Object[]> millRecieptModelt1 = generationAgaistLCsService.listdetailsbillofsupplly(contractno);
		System.err.println("resultList++++++++++" + millRecieptModelt1);
		Gson gson = new Gson();
		String resultString = new Gson().toJson(millRecieptModelt1);
		return resultString;
	}

	@ResponseBody
	@RequestMapping(value = "challanbaseddata", method = RequestMethod.GET)
	public String challanbaseddata(@RequestParam("contractno") String contractno) {

		List<Object[]> millRecieptModelt1 = millRecieptService.challanbaseddetails(contractno);
		System.err.println("resultList++++++++++" + millRecieptModelt1);
		Gson gson = new Gson();
		String resultString = new Gson().toJson(millRecieptModelt1);
		return resultString;
	}

	@ResponseBody
	@RequestMapping(value = "millreceiptbased", method = RequestMethod.GET)
	public String millreceiptbased(@RequestParam("millname") String millname) {
		List<Object> Mill_NameR = millRecieptService.fetchHODINO(millname);
		System.err.println("resultList++++++++++" + Mill_NameR);
		Gson gson = new Gson();
		String resultString = new Gson().toJson(Mill_NameR);
		return resultString;
	}

	@ResponseBody
	@RequestMapping(value = "millvisecontrcatforaginstLC", method = RequestMethod.GET)
	public String millvisecontrcatforaginstLC(@RequestParam("millname") String millname) {
		List<Object> Mill_NameR = generationAgaistLCsService.contractonmill(millname);
		System.err.println("resultList++++++++++" + Mill_NameR);
		Gson gson = new Gson();
		String resultString = new Gson().toJson(Mill_NameR);
		return resultString;
	}

	@ResponseBody
	@RequestMapping(value = "findmillreceiptNO", method = RequestMethod.GET)
	public String findmillreceiptNO(@RequestParam("hodino") String hodino) {

		boolean dataFound = millRecieptService.findmillreceiptNOlist(hodino);

		// Convert boolean result to JSON format
		JsonObject jsonObject = new JsonObject();
		jsonObject.addProperty("dataFound", dataFound);

		return jsonObject.toString();
	}

	@ResponseBody
	@RequestMapping(value = "contractlistfetch", method = RequestMethod.GET)
	public String contractlistfetch1(@RequestParam("contractno") String contractno) {
		System.err.println("contractlistfetch");
		List<Object[]> contractRecieptModelt1 = paymentDetailService.contractlistfetchdata(contractno);
		System.err.println("resultList++++++++++" + contractRecieptModelt1);
		Gson gson = new Gson();
		String resultString = new Gson().toJson(contractRecieptModelt1);
		return resultString;// gson.toJson((Object)millRecieptModelt1);
	}

	@ResponseBody
	@RequestMapping(value = "difrencecandsum", method = RequestMethod.GET)
	public String difrencecandsumcontarct(@RequestParam("contractno") String contractno) {
		System.err.println("contractlistfetch");
		List<Object[]> contractRecieptModelt1 = paymentDetailService.contractlistfetchdata(contractno);
		System.err.println("resultList++++++++++" + contractRecieptModelt1);
		Gson gson = new Gson();
		String resultString = new Gson().toJson(contractRecieptModelt1);
		return resultString;// gson.toJson((Object)millRecieptModelt1);
	}

	@ResponseBody
	@RequestMapping(value = "millnamebasedcontract", method = RequestMethod.GET)
	public String millnamebasedcontract(@RequestParam("contractno") String millname) {

		List<Object[]> millnamecontract = (List<Object[]>) paymentDetailService.millnamecontractvise(millname);
		System.err.println("resultList++++++++++" + millnamecontract);
		Gson gson = new Gson();
		String resultString = new Gson().toJson(millnamecontract);
		return resultString;// gson.toJson((Object)millRecieptModelt1);
	}

	// ajax call for previos data of instvalue
	@ResponseBody
	@RequestMapping(value = "PreviousEntry", method = RequestMethod.GET)
	public String PreviousEntry(@RequestParam("contractno") String contractno) {
		System.err.println("resultList++++++++++");
		List<Object[]> paymentDetailsdto = (List<Object[]>) paymentDetailService.PreviousNo(contractno);
		System.err.println("resultList++++++++++" + paymentDetailsdto);
		Gson gson = new Gson();
		String resultString = new Gson().toJson(paymentDetailsdto);
		return resultString;// gson.toJson((Object)millRecieptModelt1);
	}

	// save controller for mill reciept form
	@RequestMapping("saveentryofMillreciept")
	public ModelAndView saveentryofMR(HttpServletRequest request, RedirectAttributes redirectAttributes) {

		final ModelAndView mv = new ModelAndView();
		String username = (String) request.getSession().getAttribute("usrname");
		try {

			String secondcount = request.getParameter("rowindex2");
			System.err.println(secondcount);
			String checkcondition = request.getParameter("firstloop");

			int count = Integer.parseInt(secondcount);

			String[] baleMark = request.getParameterValues("baleMark[]");
			String[] jutegrade = request.getParameterValues("jutegrade[]");
			String[] juteVariety = request.getParameterValues("juteVariety[]");
			String[] cropYear = request.getParameterValues("cropYear[]");
			String[] challanQty = request.getParameterValues("challanQty[]");
			String[] actualqty = request.getParameterValues("actualQty[]");
			String[] no_of_bales = request.getParameterValues("No_of_bales[]");

			String[] Qualitypercentage = request.getParameterValues("Qualitypercentage[]");
//          
			String[] Nomination = request.getParameterValues("Nomination[]");
			String[] NCVamt = request.getParameterValues("NCVamt[]");
			String[] ncvdust = request.getParameterValues("ncvdust[]");

			String[] dustAmt = request.getParameterValues("DustAMt_[]");
			String[] dustQty = request.getParameterValues("DustQty_[]");
			String[] claimAmmount = request.getParameterValues("claimAmmount[]");

			String HO_DINO = request.getParameter("HO_DINO");
			String dateOfShipmentValue1 = request.getParameter("dateOfShipmentValue1");
			String vehicleNo1 = request.getParameter("vehicleNo1");
			String diDate1 = request.getParameter("diDate1");
			// String actualqty = request.getParameter("actualqty1");
			// String shortqty = request.getParameter("shortqty1");
			String MR_No2 = request.getParameter("MR_No1");
			String MR_Date1 = request.getParameter("MR_Date1");
			String millcode1 = request.getParameter("millcode");

			String challanno1 = request.getParameter("challanno1");
			// String shortqty = request.getParameter("InvoiceQty");
			String Mill_receiptQty1 = request.getParameter("Mill_receiptQty1");

			for (int i = 0; i < count; i++) {

				String Challan_Qty = challanQty[i];
				String Bale_Mark = baleMark[i];
				String juteewiseqty = juteVariety[i];
				String jutegrade1 = jutegrade[i];
				String cropYear1 = cropYear[i];
				String no_of_bales1 = no_of_bales[i];
				String actualqty1 = actualqty[i];

				String Qualitypercentage1 = Qualitypercentage[i];
				String Nomination1 = Nomination[i];
				// String NCVamt1 = NCVamt[i];
				// String ncvdust1 = ncvdust[i];
				// String dustAmt1 = dustAmt[i];
				// String dustQty1 = dustQty[i];
				String claimAmmount1 = claimAmmount[i];
				String Contractno1 = request.getParameter("Contractno");

				double Challan_Qty1 = Double.parseDouble(Challan_Qty);
				double Actual_Qty1 = Double.parseDouble(actualqty1);
				double Mill_Reciept_Qty2 = Double.parseDouble(Mill_receiptQty1);
				// double Short_Qty1 = Double.parseDouble(shortqty);
				MillRecieptModel millRecieptModel = new MillRecieptModel();
				Double flag = 0.0;
				double Qualitypercentage2 = Double.parseDouble(Qualitypercentage1);
				millRecieptModel.setQualityPercentage(Qualitypercentage2);
				// double QuantityInqtl12 = Double.parseDouble(QuantityInqtl1);
				// millRecieptModel.setQuantity(QuantityInqtl12);
				double moistureContent1 = Double.parseDouble(Nomination1);
				millRecieptModel.setMoistureContent(moistureContent1);

				String ncvdust1 = ncvdust[i];
				System.err.println(ncvdust1);
				String NCVamt1 = NCVamt[i];
				System.err.println(NCVamt1);
				String dustAmt1 = dustAmt[i];
				System.err.println(dustAmt1);
				String dustQty1 = dustQty[i];
				System.err.println(dustQty1);
				if (ncvdust != null && i < ncvdust.length && ncvdust[i] != null && !ncvdust[i].equals("null")) {

					double NCV_Percentage1 = Double.parseDouble(ncvdust1);

					double Ncv_qtyconverted = NCV_Percentage1 / Actual_Qty1;
					String formatted = String.format("%.2f", Ncv_qtyconverted);

					double roundedValue = Double.parseDouble(formatted);
					millRecieptModel.setNCV_percentage(roundedValue);
					millRecieptModel.setNCV_qty(flag);
				} else if (NCVamt != null && i < NCVamt.length && NCVamt[i] != null && !NCVamt[i].equals("null")) {

					double NCV_Qty1 = Double.parseDouble(NCVamt1);

					millRecieptModel.setNCV_qty(flag);
					millRecieptModel.setNCV_percentage(NCV_Qty1);
				} else {
					// Handle other cases
					if (NCVamt == null || i >= NCVamt.length || NCVamt[i] == null || NCVamt[i].equals("null")) {
						millRecieptModel.setNCV_percentage(flag);
					}
					if (ncvdust == null || i >= ncvdust.length || ncvdust[i] == null || ncvdust[i].equals("null")) {
						millRecieptModel.setNCV_qty(flag);
					}
				}

				if (dustAmt != null && i < dustAmt.length && dustAmt[i] != null && !dustAmt[i].equals("null")) {

					double dustAmt2 = Double.parseDouble(dustAmt1);
					millRecieptModel.setDustAmt(dustAmt2);
					millRecieptModel.setDustQty(flag);
				} else if (dustQty != null && i < dustQty.length && dustQty[i] != null && !dustQty[i].equals("null")) {

					double dustQty2 = Double.parseDouble(dustQty1);
					double dust_qtyconverted = dustQty2 / Actual_Qty1;

					String formatted = String.format("%.2f", dust_qtyconverted);

					// Converting formatted string back to double (optional)
					double roundedValue = Double.parseDouble(formatted);

					millRecieptModel.setDustQty(flag);
					millRecieptModel.setDustAmt(roundedValue);
				} else {
					// Handle other cases
					if (dustAmt == null || i >= dustAmt.length || dustAmt[i] == null || dustAmt[i].equals("null")) {
						millRecieptModel.setDustAmt(flag);
					}
					if (dustQty == null || i >= dustQty.length || dustQty[i] == null || dustQty[i].equals("null")) {
						millRecieptModel.setDustQty(flag);
					}
				}

				millRecieptModel.setHO_di(HO_DINO);
				millRecieptModel.setChallan_no(challanno1);
				millRecieptModel.setJute_Grade(jutegrade1);
				millRecieptModel.setJute_Variety(juteewiseqty);
				millRecieptModel.setDate_shipment(dateOfShipmentValue1);
				millRecieptModel.setVehicle_no(vehicleNo1);
				millRecieptModel.setChallan_qty(Challan_Qty1);
				millRecieptModel.setActual_qty(Actual_Qty1);
				millRecieptModel.setBale_mark(Bale_Mark);
				millRecieptModel.setCrop_year(cropYear1);
				millRecieptModel.setMR_no(MR_No2);
				SimpleDateFormat formatter1 = new SimpleDateFormat("yyyy-mm-dd");
				Date MR_Date = formatter1.parse(MR_Date1);
				millRecieptModel.setMr_date(MR_Date);
				Date date2 = new SimpleDateFormat("dd/MM/yyyy").parse(diDate1);
				millRecieptModel.setHo_date(date2);
				// millRecieptModel.setShort_qty(Short_Qty1);
				millRecieptModel.setMR_qty(Mill_Reciept_Qty2);
				millRecieptModel.setMill_id(millcode1);

				double no_of_bales2 = Double.parseDouble(no_of_bales1);
				millRecieptModel.setNo_of_Bales(no_of_bales2);
				double claimAmmount2 = Double.parseDouble(claimAmmount1);
				millRecieptModel.setClaimAmmount(claimAmmount2);
				Date date = new Date();
				millRecieptModel.setCreated_on(date);
				millRecieptModel.setCreated_by("Mill rceipt");
				if (moistureContent1 == 0) {
					millRecieptModel.setClaim_status(0);
				} else {
					millRecieptModel.setClaim_status(2);
				}

				this.millRecieptService.create(millRecieptModel);
				this.millRecieptService.UpdateContractstatus(Contractno1);
				redirectAttributes.addFlashAttribute("msg",
						"<div class=\"alert alert-success\"><b>Success !</b> Record saved successfully.</div>\r\n"
								+ "");

			}

		} catch (Exception e) {

			e.printStackTrace();
		}
		if (username == null) {
			return new ModelAndView("index");
		}

		return new ModelAndView(new RedirectView("EntryofMillreceipt.obj"));
	}

	@Value("${upload.BOSReports}")
	String BOSReports;

	@Value("${upload.TopSheetPathJasper}")
	String TopSheetPathJasper;

	@Value("${upload.BankDraftpathJsaper}")
	String BankDraftpathJsaper;

	@Value("${upload.BillofExchagePathJasper}")
	String BillofExchagePathJasper;

	@RequestMapping("Generatebankdraftsheet")
	public ModelAndView Generatebankdraftsheet2(HttpServletRequest request, RedirectAttributes redirectAttributes,
			HttpServletResponse response) {

		final ModelAndView mv = new ModelAndView();
		String username = (String) request.getSession().getAttribute("usrname");

		try {
			String secondCount = request.getParameter("rowindex2");
			if (secondCount == null)
				throw new IllegalArgumentException("Row index is missing.");

			int count = Integer.parseInt(secondCount);

			String index = request.getParameter("index");

			if (index == null || index.isEmpty())
				throw new IllegalArgumentException("Index is missing.");
			String[] indexArray = index.split(",");

			String[] bosNo = request.getParameterValues("bosNo[]");
			String[] millcode = request.getParameterValues("millcode[]");
			String[] challanno = request.getParameterValues("challanno[]");
			String[] bosdate = request.getParameterValues("bosdate[]");
			String[] invoicevalue = request.getParameterValues("invoicevalue[]");
			String[] contractNo = request.getParameterValues("contractNO[]");

			String autorevolving = request.getParameter("autorevolving");
			String balenceammount1 = request.getParameter("balenceammount");
			if (autorevolving == null)
				throw new IllegalArgumentException("Autorevolving is missing.");
			double autorevolving1 = Double.parseDouble(autorevolving);

			String bankDraft = request.getParameter("bankdraft");
			String topSheet = request.getParameter("Topsheet");
			String billofExchange = request.getParameter("BillofExchange");

			GenerationofDocumentLCsModel generationofDocumentLCsModel = new GenerationofDocumentLCsModel(); // Initialize
																											// the model

			String bosConcatenate = "";
			Double sumOfInvoiceValue = 0.0;
			Double sumOfInvoiceValue1 = 0.0;
			String contractno = "";
			String millcode1 = "";
			int num = 0;

			for (String idx : indexArray) {
				int k = Integer.parseInt(idx);

				if (k >= 0 && k < invoicevalue.length) { // Ensure index is within bounds
					String invoicevalue1 = invoicevalue[k]; // Use k directly as index to access invoicevalue
					sumOfInvoiceValue1 += Double.parseDouble(invoicevalue1);

					if (autorevolving1 >= sumOfInvoiceValue1) {
						num++;
					}
				}

				String bosNo1 = bosNo[k];
				millcode1 = millcode[k];

				contractno = contractNo[k];

				if (!bosConcatenate.isEmpty()) {
					bosConcatenate += ", ";
				}
				bosConcatenate += bosNo1;
			}
			System.err.println(bosConcatenate);

			final String finalBosConcatenate = bosConcatenate;
			final String finalContractno = contractno;
			final String finalMillcode1 = millcode1;
			final String finalBosdate = bosdate[0];
			final String balance = balenceammount1;
			final Double finalSumOfInvoiceValue = sumOfInvoiceValue1;
			final int finalnum = num;

			CompletableFuture<Void> bankDraftFuture = CompletableFuture.runAsync(() -> {
				try {
					generateBankDraft(finalBosConcatenate, finalContractno, finalMillcode1, finalBosdate,
							finalSumOfInvoiceValue, response);
				} catch (Exception e) {
					e.printStackTrace();
				}
			});

			CompletableFuture<Void> billOfExchangeFuture = CompletableFuture.runAsync(() -> {
				try {
					generateBillOfExchange(finalBosConcatenate, finalContractno, finalMillcode1, finalBosdate,
							finalSumOfInvoiceValue, finalnum, response);
				} catch (Exception e) {
					e.printStackTrace();
				}
			});

			CompletableFuture<Void> topSheetFuture = CompletableFuture.runAsync(() -> {
				try {
					generateTopSheet(finalBosConcatenate, finalContractno, finalMillcode1, finalBosdate,
							finalSumOfInvoiceValue, finalSumOfInvoiceValue, finalnum, bosNo, invoicevalue, indexArray,
							balance, challanno, response);
				} catch (Exception e) {
					e.printStackTrace();
				}
			});

			CompletableFuture.allOf(bankDraftFuture, billOfExchangeFuture, topSheetFuture).join();

		} catch (Exception e) {
			e.printStackTrace();
		}

		if (username == null) {
			return new ModelAndView("index");
		}

		return new ModelAndView(new RedirectView("documentListing.obj"));
	}

	private void generateBankDraft(String bosConcatenate, String contractno, String millcode1, String bosdate,
			Double finalSumOfInvoiceValue, HttpServletResponse response) throws Exception {
		JasperReport jasperReport = JasperCompileManager.compileReport(new FileInputStream(BankDraftpathJsaper));
		Map<String, Object> parameters = new HashMap<>();
		BankDraftDTO bankDraftDTO = new BankDraftDTO();
		List<BankDraftDTO> listOfBankDraft = new ArrayList<>();

		List<Object[]> dateData = generationAgaistLCsService.forIFSC(contractno);
		for (Object[] row : dateData) {
			if (row[5] != null)
				bankDraftDTO.setInstrumentNO(row[5].toString());
			if (row[6] != null)
				bankDraftDTO.setInstrumentDate(row[6].toString());
			if (row[7] != null) {
				String ifsc = row[7].toString();
				fetchBankDetails(ifsc, bankDraftDTO);
			}
		}

		List<Object[]> listOfAddress = generationofBillService.contarctnoformaster(millcode1);
		for (Object[] row : listOfAddress) {
			bankDraftDTO.setUnitname((String) row[0]);
			bankDraftDTO.setUnitaddress(
					String.join("", (String) row[1], (String) row[2], (String) row[3], (String) row[4]));
		}

		ConvertWord_k convertWord_k = new ConvertWord_k();
		String invoiceValueString = String.valueOf(finalSumOfInvoiceValue);
		double invoiceDouble = Double.parseDouble(invoiceValueString);
		int convertInt = (int) invoiceDouble;
		bankDraftDTO.setInvoicevalue(convertWord_k.convertToWords(convertInt));
		bankDraftDTO.setInvoicevalueInnumber(invoiceValueString);
		bankDraftDTO.setBillOfSupplyNo(bosConcatenate);
		bankDraftDTO.setbOS_Date(bosdate);

		Date date = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		String formattedDate = formatter.format(date);
		bankDraftDTO.setCurrentdate(formattedDate);
		listOfBankDraft.add(bankDraftDTO);
		JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(listOfBankDraft);
		JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, dataSource);

		String fileName = "bankdraft" + bosConcatenate + ".pdf";
		// String savePath = BOSReports + File.separator + fileName;
//	        JasperExportManager.exportReportToPdfFile(jasperPrint, savePath);
		// serveFileAsResponse9(savePath, fileName, response);

		// String fileName = "billofsupplydoc" + Bill_of_Supply + ".pdf";

		File directory = new File(BOSReports);

		if (!directory.exists()) {
			if (directory.mkdirs()) {
				System.out.println("Directory created successfully");
			} else {
				System.err.println("Failed to create directory: " + directory.getAbsolutePath());

			}
		}

		String savePath = BOSReports + File.separator + fileName;

		try (OutputStream out = new FileOutputStream(savePath)) {
			JRPdfExporter exporter = new JRPdfExporter();
			exporter.setParameter(JRPdfExporterParameter.JASPER_PRINT, jasperPrint);
			exporter.setParameter(JRPdfExporterParameter.OUTPUT_STREAM, out);
			exporter.exportReport();
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
		}

		response.setContentType("application/pdf");
		response.setHeader("Content-Disposition", "inline");

	}

	private void generateBillOfExchange(String bosConcatenate, String contractno, String millcode1, String bosdate,
			Double sumOfInvoiceValue, int num, HttpServletResponse response) throws Exception {
		JasperReport jasperReport = JasperCompileManager.compileReport(new FileInputStream(BillofExchagePathJasper));
		Map<String, Object> parameters = new HashMap<>();
		BillOfExchangeDTO billOfExchangeDTO = new BillOfExchangeDTO();
		List<BillOfExchangeDTO> listOfBillofExchange = new ArrayList<>();
		String instnoString = "";
		String instdate = "";
		List<Object[]> dateData = generationAgaistLCsService.forIFSC(contractno);
		for (Object[] row : dateData) {
			if (row[5] != null)
				billOfExchangeDTO.setInstrumentNo(row[5].toString());
			if (row[6] != null)
				billOfExchangeDTO.setInstrumentDate(row[6].toString());
			instnoString = row[5].toString();
			instdate = row[6].toString();
			if (row[7] != null) {
				String ifsc = row[7].toString();
				fetchBankDetails1(ifsc, billOfExchangeDTO);
			}
		}

		Calendar calendar = Calendar.getInstance();
		int currentYear = calendar.get(Calendar.YEAR);
		int currentMonth = calendar.get(Calendar.MONTH) + 1; // Calendar.MONTH is zero-based

		int financialYearStart, financialYearEnd;

		if (currentMonth >= 4) { // April or later
			financialYearStart = currentYear;
			financialYearEnd = currentYear + 1;
		} else { // January to March
			financialYearStart = currentYear - 1;
			financialYearEnd = currentYear;
		}

		String endYearLastTwoDigits = Integer.toString(financialYearEnd).substring(2);
		String StartYearLastTwoDigits = Integer.toString(financialYearStart).substring(2);
		String jciref = "JCI/ind/SALE/INT/ " + StartYearLastTwoDigits + "-" + endYearLastTwoDigits + "/";

		String subdetails = "Our bill for Rs.  " + sumOfInvoiceValue + " for collection and payment under letter of  "
				+ instnoString + " Dated " + instdate + "  A/c The Ganges Mfg. Co. Ltd";

		String invoiceValueString = String.valueOf(sumOfInvoiceValue);
		billOfExchangeDTO.setSubdetails(subdetails);
		billOfExchangeDTO.setJciref(jciref);
		billOfExchangeDTO.setJno(num);
		billOfExchangeDTO.setInvoicevalue(invoiceValueString);
		billOfExchangeDTO.setBillofsupplyNo(bosConcatenate);
		billOfExchangeDTO.setBosDate(bosdate);

		Date date = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		String formattedDate = formatter.format(date);
		billOfExchangeDTO.setCurrentdate(formattedDate);
		listOfBillofExchange.add(billOfExchangeDTO);

		JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(listOfBillofExchange);
		JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, dataSource);

		String fileName = "BankerCopy" + bosConcatenate + ".pdf";
		// String savePath = BOSReports + File.separator + fileName;
//	        JasperExportManager.exportReportToPdfFile(jasperPrint, savePath);
		// serveFileAsResponse9(savePath, fileName, response);

		File directory = new File(BOSReports);

		if (!directory.exists()) {
			if (directory.mkdirs()) {
				System.out.println("Directory created successfully");
			} else {
				System.err.println("Failed to create directory: " + directory.getAbsolutePath());

			}
		}

		String savePath = BOSReports + File.separator + fileName;

		try (OutputStream out = new FileOutputStream(savePath)) {
			JRPdfExporter exporter = new JRPdfExporter();
			exporter.setParameter(JRPdfExporterParameter.JASPER_PRINT, jasperPrint);
			exporter.setParameter(JRPdfExporterParameter.OUTPUT_STREAM, out);
			exporter.exportReport();
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
		}

		response.setContentType("application/pdf");
		response.setHeader("Content-Disposition", "inline");

	}

	private void generateTopSheet(String bosConcatenate, String contractno, String millcode1, String bosdate,
			Double sumOfInvoiceValue, Double sumOfInvoiceValue1, int num, String[] bosNo, String[] invoicevalue,
			String[] indexArray, String balance, String[] challanno, HttpServletResponse response) throws Exception {
		JasperReport jasperReport = JasperCompileManager.compileReport(new FileInputStream(TopSheetPathJasper));
		Map<String, Object> parameters = new HashMap<>();
		List<TopSheeetDTO> listOfTopSheet = new ArrayList<>();

		String lastPart = contractno.substring(contractno.lastIndexOf('/') + 1);

		String millcode2 = "";
		String hodino = "";
		String hodidate = "";
		String dtaeofshipment = "";
		String millname = "";
		String instrumentno = "";
		String instrumentdate = "";

		double totalQuantity = 0.0;

		List<Object[]> list1 = generationofBillService.DocumentLcsEntry(contractno);

		for (Object[] details : list1) {
			millcode2 = (String) details[0];
			hodino = (String) details[3];
			hodidate = (String) details[2];
			dtaeofshipment = (String) details[1];
		}

		List<Object[]> dateData = generationAgaistLCsService.forIFSC(contractno);
		List<Object[]> listOfAddress = generationofBillService.contarctnoformaster(millcode1);
		for (Object[] row : listOfAddress) {
			millname = (String) row[0];
		}

		for (Object[] row : dateData) {
			instrumentno = (String) row[5];
			instrumentdate = (String) row[6];
		}

		Date date = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		String formattedDate = formatter.format(date);

		Calendar calendar = Calendar.getInstance();
		int currentYear = calendar.get(Calendar.YEAR);
		int currentMonth = calendar.get(Calendar.MONTH) + 1; // Calendar.MONTH is zero-based

		int financialYearStart, financialYearEnd;

		if (currentMonth >= 4) { // April or later
			financialYearStart = currentYear;
			financialYearEnd = currentYear + 1;
		} else { // January to March
			financialYearStart = currentYear - 1;
			financialYearEnd = currentYear;
		}

		String endYearLastTwoDigits = Integer.toString(financialYearEnd).substring(2);

		String yearCode = endYearLastTwoDigits;

		String status = String.format("%06d", Integer.parseInt(this.generationAgaistLCsService.lcno()));

		String number = "LC" + yearCode + status;

		String fileName = "Topsheet" + bosConcatenate + ".pdf";

		String fileName1 = "BankerCopy" + bosConcatenate + ".pdf";

		String fileName2 = "bankdraft" + bosConcatenate + ".pdf";
		String invoice = String.valueOf(sumOfInvoiceValue);
		for (String idx : indexArray) {
			int j = Integer.parseInt(idx);
			List<Object[]> list = generationAgaistLCsService.forQtyintopsheet(challanno[j]);
			double sumofQty = 0.0;
			for (Object[] details : list) {
				double value4 = (details[4] instanceof Integer) ? ((Integer) details[4]).doubleValue()
						: Double.parseDouble(details[4].toString());
				double value5 = (details[5] instanceof String) ? Double.parseDouble((String) details[5])
						: ((Number) details[5]).doubleValue();
				double result = value4 * value5;
				sumofQty += result;
			}
			System.err.println(sumofQty);
			TopSheeetDTO topSheeetDTO = new TopSheeetDTO();
			topSheeetDTO.setBillOfSupplyNo(bosNo[j]);
			// topSheeetDTO.setBillOfSupplyNo(bosConcatenate);
			topSheeetDTO.setNominalQty(sumofQty);
			topSheeetDTO.setDateofShipment(dtaeofshipment);
			topSheeetDTO.setMill_code(millcode2);
			topSheeetDTO.setHodiNO(hodino);
			topSheeetDTO.setHodiDate(hodidate);
			topSheeetDTO.setContract_no(lastPart);
			topSheeetDTO.setInvoicevalue(invoicevalue[j]);
			// topSheeetDTO.setInvoicevalue(invoice);
			totalQuantity += sumofQty;
			topSheeetDTO.setTotalqty(totalQuantity);
			topSheeetDTO.setTotalamount(sumOfInvoiceValue);
			topSheeetDTO.setMillname(millname);

			String newvalueString = instrumentno + "  Dated " + instrumentdate;
			topSheeetDTO.setInstrumentno(newvalueString);
			// topSheeetDTO.setInstrumentdate(instrumentdate);
			topSheeetDTO.setCurrentdate(formattedDate);
			listOfTopSheet.add(topSheeetDTO);

			GenerationofDocumentLCsModel generationofDocumentLCsModel = new GenerationofDocumentLCsModel();
			int balance1 = Integer.parseInt(balance);
//					  BigDecimal decimalValue = new BigDecimal(balance);
//				       int intValue1 = decimalValue.intValue();
			generationofDocumentLCsModel.setBoe_Date(date);
			generationofDocumentLCsModel.setbOS_No(bosNo[j]);
			// generationofDocumentLCsModel.setbOS_No(bosConcatenate);
			generationofDocumentLCsModel.setContractno(contractno);
			generationofDocumentLCsModel.setInstrumentno(instrumentno);
			generationofDocumentLCsModel.setInstrumentdate(instrumentdate);
			generationofDocumentLCsModel.setIvoice_value(invoicevalue[j]);
			generationofDocumentLCsModel.setMill_code(millcode2);
			generationofDocumentLCsModel.setSerialno(number);
			generationofDocumentLCsModel.setTopsheetpath(fileName);
			generationofDocumentLCsModel.setBillofexchangepath(fileName2);
			generationofDocumentLCsModel.setBankdrftpath(fileName1);
			generationofDocumentLCsModel.setBalanceammount(balance);

			// generationofDocumentLCsModel.setBillofexchangepath(fileName);
			this.generationAgaistLCsService.create(generationofDocumentLCsModel);

		}

		JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(listOfTopSheet);
		JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, dataSource);

		// String savePath = BOSReports + File.separator + fileName;
//					JasperExportManager.exportReportToPdfFile(jasperPrint, savePath);
		// serveFileAsResponse(savePath, fileName, response);

		File directory = new File(BOSReports);

		if (!directory.exists()) {
			if (directory.mkdirs()) {
				System.out.println("Directory created successfully");
			} else {
				System.err.println("Failed to create directory: " + directory.getAbsolutePath());

			}
		}

		String savePath = BOSReports + File.separator + fileName;

		try (OutputStream out = new FileOutputStream(savePath)) {
			JRPdfExporter exporter = new JRPdfExporter();
			exporter.setParameter(JRPdfExporterParameter.JASPER_PRINT, jasperPrint);
			exporter.setParameter(JRPdfExporterParameter.OUTPUT_STREAM, out);
			exporter.exportReport();
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
		}

		response.setContentType("application/pdf");
		response.setHeader("Content-Disposition", "inline");

	}

	private void serveFileAsResponse9(String filePath, String fileName, HttpServletResponse response)
			throws IOException {
		File file = new File(filePath);
		if (!file.exists()) {
			throw new FileNotFoundException("File not found: " + filePath);
		}

		response.setContentType("application/pdf");
		response.setHeader("Content-Disposition", "attachment; filename=\"" + fileName + "\"");

		try (InputStream inputStream = new FileInputStream(file);
				OutputStream outputStream = response.getOutputStream()) {
			byte[] buffer = new byte[1024];
			int bytesRead;
			while ((bytesRead = inputStream.read(buffer)) != -1) {
				outputStream.write(buffer, 0, bytesRead);
			}
			outputStream.flush();
		} catch (IOException e) {
			e.printStackTrace();
			throw e;
		}
	}

	@RequestMapping("downloadLetterofcreditdocument")
	public void downloaFcdocumentLetterofcredit(@RequestParam("filename") String filename,
			HttpServletResponse response) {
		String imagePath = BOSReports + File.separator + filename;
		File imageFile = new File(imagePath);
		System.err.println(filename); // Check if the file exists
		if (imageFile.exists()) {

			try {
				// Set the content type based on the file type
				String contentType = determineContentType8(filename);
				response.setContentType(contentType);

				// Set the content length and attachment disposition
				response.setContentLength((int) imageFile.length());
				// response.setHeader("Content-Disposition", "attachment; filename=" +
				// filename);
				response.setHeader("Content-Disposition", "");
				// Stream the file content to the response
				try (FileInputStream fileInputStream = new FileInputStream(imageFile);
						OutputStream responseOutputStream = response.getOutputStream()) {
					byte[] buffer = new byte[1024];
					int bytesRead;
					while ((bytesRead = fileInputStream.read(buffer)) != -1) {
						responseOutputStream.write(buffer, 0, bytesRead);
					}
				}
			} catch (IOException e) {
				// Handle IO exception
				e.printStackTrace();
				response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
			}
		} else {
			response.setStatus(HttpServletResponse.SC_NOT_FOUND);
		}
	}

//		// Utility method to determine content type based on filename
//		private String determineContentType8(String filename) {
//			if (filename.endsWith(".pdf")) {
//				return "application/pdf";
//			} else if (filename.endsWith(".jpg") || filename.endsWith(".jpeg")) {
//				return "image/jpeg";
//			} else if (filename.endsWith(".png")) {
//				return "image/png";
//			} else {
//				return "application/octet-stream"; // Default to binary data if content type is unknown
//			}
//		}

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

	// ajax url for genrated demand note service to fetch data
	@ResponseBody
	@RequestMapping(value = "fetchingdatatocontractno", method = RequestMethod.GET)
	public String fetchingdatatocontractnoq(@RequestParam("contractno") String contractno) {
		List<Object[]> getcontractddownlist = (List<Object[]>) genratedDemandNoteService.fetchContract_no(contractno);
		System.err.println("resultList++++++++++" + getcontractddownlist);
		Gson gson = new Gson();
		String resultString = new Gson().toJson(getcontractddownlist);
		return resultString;
	}

	@ResponseBody
	@RequestMapping(value = "balanceamount", method = RequestMethod.GET)
	public String balanceamount(@RequestParam("contractno") String contractno) {
		List<Object[]> balance = this.generationAgaistLCsService.balanceammount(contractno);
		System.err.println("resultList++++++++++" + balance);
		Gson gson = new Gson();
		String resultString = new Gson().toJson(balance);
		return resultString;
	}

	@ResponseBody
	@RequestMapping(value = "millchildbased", method = RequestMethod.GET)
	public String millchildbased(@RequestParam("contractno") String contractno) {

		List<Object[]> millRecieptModelt1 = millRecieptService.childdata(contractno);
		System.err.println("resultList++++++++++" + millRecieptModelt1);
		Gson gson = new Gson();
		String resultString = new Gson().toJson(millRecieptModelt1);
		return resultString;
	}

	@ResponseBody
	@RequestMapping(value = "GradePrice", method = RequestMethod.GET)
	public String GradePricecalculation(@RequestParam("contNo") String contNo,
			@RequestParam("challanno") String challanno, @RequestParam("cropyear") String cropyear,
			@RequestParam("jutevariety") String jutevariety) {

		List<Object[]> millRecieptModelt1 = millRecieptService.gradeprice(challanno, contNo, cropyear, jutevariety);
		System.err.println("resultList++++++++++" + millRecieptModelt1);
		Gson gson = new Gson();
		String resultString = new Gson().toJson(millRecieptModelt1);
		return resultString;
	}

	// entry controller of generation demand note
	@RequestMapping("EntryofGenrationDeamandNote")
	public ModelAndView EntryofGenrationDemand(HttpServletRequest request) {
		String username = (String) request.getSession().getAttribute("usrname");

		ModelAndView mv = new ModelAndView("EntryofGenratedDemandNote");
		if (username == null) {
			mv = new ModelAndView("index");
		}
		List<Object> ContractList = this.genratedDemandNoteService.fetchcon_no();

		String demandNoteNumber = generateDemandNoteNumber(request.getSession());
		mv.addObject("demandNoteNumber", demandNoteNumber);
		mv.addObject("contract", ContractList);
		// String demandNoteNumber = generateDemandNoteNumber();

		// GenrationDEmandDto cotract_No =
		// this.genratedDemandNoteService.fetchContract_no();

//			
//			Date date =cotract_No.getContract_date();
//			SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
//			String formattedDate = dateFormat.format(date);

		// mv.addObject("demandNoteNumber", demandNoteNumber);
//			mv.addObject("cotract_No", cotract_No);
//			mv.addObject("formattedDate", formattedDate);
		return mv;
	}

	// private String generateDemandNoteNumber()
	private String generateDemandNoteNumber(HttpSession session) {

		Calendar calendar = Calendar.getInstance();
		int currentYear = calendar.get(Calendar.YEAR);
		int currentMonth = calendar.get(Calendar.MONTH) + 1; // Calendar.MONTH is zero-based

		int financialYearStart, financialYearEnd;

		if (currentMonth >= 4) { // April or later
			financialYearStart = currentYear;
			financialYearEnd = currentYear + 1;
		} else { // January to March
			financialYearStart = currentYear - 1;
			financialYearEnd = currentYear;
		}

		String endYearLastTwoDigits = Integer.toString(financialYearEnd).substring(2);

		String yearCode = endYearLastTwoDigits;
		String countString = this.genratedDemandNoteService.count();

		String stringdemand = "D" + yearCode + String.format("%06d", Integer.parseInt(countString)) + "19"
				+ String.format("%05d", Integer.parseInt(countString));

		/* + String.format("%06d", count); */
		return stringdemand;
	}

	@Value("${upload.DemandDoc}")
	String DemandNoteDoc;

	@Value("${upload.DemandNoteSave}")
	String DemandNoteSave;

	// save entry of geration demand note form field
	@RequestMapping("saveentryofGenrationDeamandNote")
	public ModelAndView saveentryofGDN(HttpServletRequest request, RedirectAttributes redirectAttributes,
			HttpServletResponse response) {

		final ModelAndView mv = new ModelAndView();
		String username = (String) request.getSession().getAttribute("usrname");
		String name = (String) request.getSession().getAttribute("loginName");
		List<DemandNoteDto> DemandNoteDtoList = new ArrayList<>();
		String documentName = "";
		try {

			String Contract_No = request.getParameter("Contract_No");
			System.err.println("123421");
			String Contract_Date = request.getParameter("Contract_Date");
			String Payment_Due_Date = request.getParameter("Payment_Due_Date");
			String Cancellation_Date = request.getParameter("Cancellation_Date.");
			System.err.println("123421");
			System.err.println("123421");
			String Delay_period = request.getParameter("Delay_period");
			String Payment_Ref = request.getParameter("Payment_Ref");
			String contractedQtyStr = request.getParameter("Contracted_Qty");
			double contractedQty = Double.parseDouble(contractedQtyStr);

			String Unit_charge_str = request.getParameter("Unit_charge");
			double Unit_charge = Double.parseDouble(Unit_charge_str);
			String Carrying_cost_str = request.getParameter("Carrying_cost");
			double Carrying_cost = Double.parseDouble(Carrying_cost_str);
			System.err.println("123421");
			System.err.println("123421");
			// String Waiver_flag = request.getParameter("Waiver_flag");
			String Remarks = request.getParameter("Remarks");
			// String Waiver_Approved_By = request.getParameter("Waiver_Approved_By");
			// String Dn_status = request.getParameter("Dn_status");
			String Demand_note_no = request.getParameter("Demand_note_no");
			String Demand_note_date = request.getParameter("Demand_note_date");
			String paymentDate = request.getParameter("q");

			String waiver = request.getParameter("Waiver_flag");

			System.err.println(waiver);
			System.err.println(waiver);
			System.err.println(waiver);
			System.err.println(waiver);
			System.err.println(waiver);
			GenrationDemandNoteModel genrationDemandNoteModel = new GenrationDemandNoteModel();

			genrationDemandNoteModel.setContract_no(Contract_No);

			SimpleDateFormat formatter1 = new SimpleDateFormat("yyyy-mm-dd");
			genrationDemandNoteModel.setDemand_note_no(Demand_note_no);
			Date instdate4 = formatter1.parse(Demand_note_date);
			genrationDemandNoteModel.setDemand_note_date(instdate4);
			System.err.println("---------");
			genrationDemandNoteModel.setContract_date(Contract_Date);
			genrationDemandNoteModel.setPayment_due_date(Payment_Due_Date);
			// genrationDemandNoteModel.setPayment_date(Cancellation_Date);
			genrationDemandNoteModel.setPayment_date(paymentDate);
			genrationDemandNoteModel.setDelay_period(Delay_period);
			genrationDemandNoteModel.setPayment_ref(Payment_Ref);
			System.err.println("++++");

			genrationDemandNoteModel.setContracted_qty(contractedQty);
			genrationDemandNoteModel.setUnit_charge(Unit_charge);
			genrationDemandNoteModel.setCarrying_cost(Carrying_cost);
			System.err.println("---------");
			if ("1".equals(waiver)) {
				genrationDemandNoteModel.setWaiver_flag(1);
				genrationDemandNoteModel.setWaiver_approved_by(name);
			} else {
				genrationDemandNoteModel.setWaiver_flag(0);
				genrationDemandNoteModel.setWaiver_approved_by("");

			}
			genrationDemandNoteModel.setRemarks(Remarks);

			genrationDemandNoteModel.setDn_status(0);
			genrationDemandNoteModel.setCreated_by("username");
			genrationDemandNoteModel.setStateCode("19");
			System.err.println("++++");
			Date date = new Date();
			// Date instdate4 = formatter1.parse(Created_on);
			genrationDemandNoteModel.setCreated_on(date);
			documentName = "DemandNote" + Demand_note_no + ".pdf";
			genrationDemandNoteModel.setDocumentName(documentName);
			// Date date= new Date();

			this.genratedDemandNoteService.create(genrationDemandNoteModel);
			this.genratedDemandNoteService.updateStatus(Contract_No);
			Map<String, Object> parameters = new HashMap<String, Object>();
//			    parameters.put("Contract_No", Contract_No);
//			    parameters.put("Contract_Date", Contract_Date);
//			    parameters.put("Payment_Due_Date", Payment_Due_Date);
//			    parameters.put("Delay_period", Delay_period);
//			    parameters.put("Payment_Ref", Payment_Ref);
//			    parameters.put("contractedQtyStr", contractedQtyStr);
//			    parameters.put("Unit_charge", Unit_charge);
//			    parameters.put("Carrying_cost_str", Carrying_cost_str);

			List<Object[]> RecipientConsigneeData = genratedDemandNoteService.getData(Contract_No);
			List<Object[]> detailsDebitList = genratedDemandNoteService.DetailsDebit(Demand_note_no);

			for (Object[] details : RecipientConsigneeData) {
				parameters.put("Consignee_name", details[0]);
				parameters.put("Consignee_address",
						details[1] + "," + details[2] + "," + details[3] + "," + details[4]);
				parameters.put("ConsigneeStateCode", details[5]);
				parameters.put("ConsigneeState", details[6]);
				parameters.put("Consignee_gSTN", details[7]);
			}

			for (Object[] row : RecipientConsigneeData) {
				parameters.put("Recipient_gSTN", row[7]);
				parameters.put("Rpt_PAN", row[8]);
				parameters.put("recipientState", row[17]);
				parameters.put("recipientstatecode", row[18]);
				System.err.println(row[18]);
				System.err.println(row[18]);
				System.err.println(row[18]);
				System.err.println(row[18]);
				parameters.put("Recipient_address", row[11] + "," + row[12] + "," + row[13] + "," + row[14]);
				parameters.put("Recipient_name", row[14]);
			}

			for (Object[] row : detailsDebitList) {
				parameters.put("contractNo", row[0]);
				parameters.put("diNo", row[1]);
				parameters.put("ChallanNo", row[2]);
				parameters.put("bosNo", row[3]);
				parameters.put("crnNo", row[4]);
				parameters.put("crnDate", row[5]);

				parameters.put("unit",
						"Carrying Cost Calculation (Carrying Cost @ Rs " + row[6] + "/- per Qtls. per month)");
				System.err.println(row[5]);
				System.err.println(row[5]);
				System.err.println(row[5]);
			}

			int counter = 1;
			List<Object[]> DemandNoteData = this.genratedDemandNoteService.DemandNoteData(Demand_note_no);
			Double total = 0.0;
			System.err.println(DemandNoteData.toString());
			for (Object[] row : DemandNoteData) {
				DemandNoteDto demandNoteDto = new DemandNoteDto();
				String contract_noString = (String) row[0];
				String ContractDate = (String) row[1];
				Double ContractQty = (Double) row[2];
				String paymentDueDate = (String) row[3];
				String paymentRef = (String) row[4];
				String delay = (String) row[5];
				String payDate = (String) row[6];
				String DemandDate = (String) row[7];
				Double CarryingCost = (Double) row[8];

				demandNoteDto.setContractNo(contract_noString);
				demandNoteDto.setContractDate(ContractDate);
				demandNoteDto.setContractqty(ContractQty);
				demandNoteDto.setScheduledpaymentdate(paymentDueDate);
				demandNoteDto.setActualpaymentdate(paymentDate);
				demandNoteDto.setDelaydays(delay);
				demandNoteDto.setPaymentrefstring(paymentRef);
				demandNoteDto.setPaydate(paymentDate);
				demandNoteDto.setCarryingcoststring(Carrying_cost);
				total += CarryingCost;
				System.err.println(demandNoteDto.toString());
				DemandNoteDtoList.add(demandNoteDto);
			}
			parameters.put("sumCrnAmt", total);
			String amountInWord = convertNumberToCurrencyWords(total);
			parameters.put("amountInWord", amountInWord + " Only.");

//                // Prepare data sources
			JasperReport jasperReport1 = JasperCompileManager.compileReport(DemandNoteDoc);
			JRBeanCollectionDataSource dataSource1 = new JRBeanCollectionDataSource(DemandNoteDtoList);
//
//                // Fill JasperPrints
			JasperPrint jasperPrint1 = JasperFillManager.fillReport(jasperReport1, parameters, dataSource1);
			response.setContentType("application/pdf");
			response.setHeader("Content-Disposition", "inline");
			// response.setHeader("Content-Disposition", "attachment;
			// filename=TestCreditNote.pdf");
			// try (OutputStream out = response.getOutputStream()) {

			final File theDir = new File(DemandNoteSave);
			if (!theDir.exists()) {
				theDir.mkdirs();
			}

			String saveFile = DemandNoteSave + File.separator + documentName;

			try (OutputStream out = new FileOutputStream(saveFile)) {
				JRPdfExporter exporter = new JRPdfExporter();
				exporter.setParameter(JRPdfExporterParameter.JASPER_PRINT, jasperPrint1);

				exporter.setParameter(JRPdfExporterParameter.OUTPUT_STREAM, out);
				exporter.exportReport();

			} catch (Exception e) {
				System.out.println(e.getLocalizedMessage());
			}

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

	// entrt page of genration bill

	@RequestMapping("EntryofGenerationBillsupply")
	public ModelAndView EntryofGenrationBillsupply(HttpServletRequest request) {
		String username = (String) request.getSession().getAttribute("usrname");

		ModelAndView mv = new ModelAndView("EntryGenerationBill");
		if (username == null) {
			mv = new ModelAndView("index");
		}
		final String challan_no = request.getParameter("id");
		final String DPC1 = request.getParameter("DPC");
		List<Object[]> list = generationofBillService.Dispatchentry(challan_no);
		final String millname = request.getParameter("millname");

//		 List<Object[]> ShipmentDetails= (List<Object[]>)

//			final GenerationOfBillSupplyModel generationOfBillSupplyModel = this.generationofBillService.find(id);
//			
		List<Object[]> ShipmentDetails = (List<Object[]>) this.generationofBillService.ChallanNo(challan_no);
		List<Object[]> Suplierdetails = (List<Object[]>) this.generationofBillService.Supplieradd(DPC1);
		List<Object[]> Perticulargoods = (List<Object[]>) this.generationofBillService.ShipmentDetails(challan_no);
		mv.addObject("ShipmentDetails", ShipmentDetails);
		mv.addObject("Perticulargoods", Perticulargoods);
		mv.addObject("Suplierdetails", Suplierdetails);

		int allIndiaSerialNo = 1;
		int stateSerialNo = 1;
		String billOfSupplyNo = generateBillOfSupplyNumber(request.getSession(), allIndiaSerialNo, stateSerialNo, DPC1);
		String Stategstcode = Stategstcode(DPC1);
		mv.addObject("billOfSupplyNo", billOfSupplyNo);
		mv.addObject("Stategstcode", Stategstcode);
		mv.addObject("challan_no", challan_no);
		mv.addObject("millname", millname);
		mv.addObject("list", list);
		mv.addObject("DPC1", DPC1);

		return mv;

	}

	private String generateBillOfSupplyNumber(HttpSession session, int allIndiaSerialNo, int stateSerialNo,
			String DPC1) {
		String prefix = "B";

		Calendar calendar = Calendar.getInstance();
		int currentYear = calendar.get(Calendar.YEAR);
		int currentMonth = calendar.get(Calendar.MONTH) + 1; // Calendar.MONTH is zero-based

		int financialYearStart, financialYearEnd;

		if (currentMonth >= 4) { // April or later
			financialYearStart = currentYear;
			financialYearEnd = currentYear + 1;
		} else { // January to March
			financialYearStart = currentYear - 1;
			financialYearEnd = currentYear;
		}

		String endYearLastTwoDigits = Integer.toString(financialYearEnd).substring(2);

		String yearCode = endYearLastTwoDigits;

		String statecode = this.generationofBillService.statecode(DPC1);

		String status = String.format("%06d", Integer.parseInt(this.generationofBillService.billofsupplyno()));

		String status1 = String.format("%05d", Integer.parseInt(this.generationofBillService.statecount(statecode)));
		System.err.println(status1);

//		String laString = prefix + yearCode + formattedAllIndiaSerialNo + stateGSTCode + formattedStateSerialNo;
		String laString = prefix + yearCode + status + statecode + status1;
		System.err.print(laString);
		System.err.print(laString);
		return laString;

	}

	private String Stategstcode(String DPC1) {
		String statecode = this.generationofBillService.statecode(DPC1);

		return statecode;
	}

	// save page of generation bill of supply

	@Value("${upload.Genrationofbill}")
	String Genrationofbill;

	@Value("${upload.billofsupply}")
	String billofsupply;

	@RequestMapping("saveentryofGenrationbill")

	public ModelAndView saveentryofGenrationbill(HttpServletRequest request, HttpServletResponse response,
			RedirectAttributes redirectAttributes) {
		final File theDir = new File("Genrationofbill");

		if (!theDir.exists()) {
			theDir.mkdirs();
		}
		final ModelAndView mv = new ModelAndView();
		String username = (String) request.getSession().getAttribute("usrname");
		try {

			String Challan_No1 = request.getParameter("Challan_No1");
			String statecode = request.getParameter("Stategstcode");
			String DPC1code = request.getParameter("DPC1");
			String Challan_Date1 = request.getParameter("Challan_Date1");
			// String Shipment_Details = request.getParameter("Shipment_Details");
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
			String TrnasitPolicyNo = request.getParameter("TrnasitPolicyNo");
			String Driver_name = request.getParameter("Driver_name");
			String Driver_Lic_no = request.getParameter("Driver_Lic_no");
			String Vehicle_no = request.getParameter("Vehicle_no");

			String Statename23 = request.getParameter("Statename23");
			String StaeCode23 = request.getParameter("StaeCode23");
			String PAN23 = request.getParameter("PAN23");
			String millcode234 = request.getParameter("millcode");

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
			// generationOfBillSupplyModel.setShipment_details(Shipment_Details);
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
			generationOfBillSupplyModel.setTrnasitPolicyno(TrnasitPolicyNo);
			generationOfBillSupplyModel.setStatecode_forBOs(statecode);
			generationOfBillSupplyModel.setDPCID(DPC1code);
			generationOfBillSupplyModel.setMillcode(millcode234);

			Date date = new Date();
			generationOfBillSupplyModel.setCreation_date(date);
			String ro_id = (String) request.getSession().getAttribute("regionId");
			System.out.println(ro_id);
			List<Object[]> RegionAndCenterName1 = generationofBillService.RegionAndCenterName(DPC1code);

			List<Object[]> Dpcname = generationofBillService.Dpcname(ro_id, DPC1code);
			generationOfBillSupplyModel.setRo_id(ro_id);
			// generationOfBillSupplyModel.setBos_file_path("documents");

			// Compile the JRXML file
//            JasperReport jasperReport1 = JasperCompileManager.compileReport(new FileInputStream("C:\\Users\\kailash.shah\\Desktop\\MSP\\JCI-CMS\\topsheet.jrxml"));
//            JasperReport jasperReport2 = JasperCompileManager.compileReport(new FileInputStream("C:\\Users\\kailash.shah\\Desktop\\MSP\\JCI-CMS\\BOEDOC.jrxml"));
//            JasperReport jasperReport3 = JasperCompileManager.compileReport(new FileInputStream("C:\\Users\\kailash.shah\\Desktop\\MSP\\JCI-CMS\\billofexchange.jrxml"));
//            JasperReport jasperReport4 = JasperCompileManager.compileReport(new FileInputStream("C:\\Users\\kailash.shah\\Desktop\\MSP\\JCI-CMS\\BOE(NON-LC).jrxml"));

			// Parameters for the report
//            Map<String, Object> parameters = new HashMap<>();
//            TopSheeetDTO topSheeetDTO = new TopSheeetDTO();
//            List<TopSheeetDTO> listOfTopSheet = new ArrayList<>();
			List<Object[]> list = generationofBillService.Dispatchentry(Challan_No1);
			List<Object[]> list1 = generationofBillService.DocumentLcsEntry(Conract_no);
			// List<Object[]> dateData = generationofBillService.ForDate(Challan_No1);
//            for (Object[] details : list) {
//            	double value4 = (details[4] instanceof Integer) ? ((Integer) details[4]).doubleValue() : Double.parseDouble(details[4].toString());
//
//            	double value5 = (details[5] instanceof String) ? Double.parseDouble((String) details[5]) : ((Number) details[5]).doubleValue();
//
//            	double result = value4 * value5;
//            	System.err.println(result);
//            
//            	    topSheeetDTO.setNominalQty(result);
//             
//          }

//            for (Object[] details : list1) {
//            	        String millcode=(String)details[0];
//            			String hodino= (String)details[3];
//            			String hodidate= (String)details[2];
//            			String dtaeofshipment=(String)details[1];
//              
//                topSheeetDTO.setDateofShipment(dtaeofshipment);
//                topSheeetDTO.setMill_code(millcode);
//                topSheeetDTO.setHodiNO(hodino);
//                topSheeetDTO.setHodiDate(hodidate);
//                
//               
//          }
//            parameters.put("millcode", Conract_no);
//            parameters.put("dateofshipment", Bill_of_Supply);
//            
//            String inputString = Conract_no;
//
//            // Split the string by '/'
//            String[] splitParts = inputString.split("/");

			// Extract the last part
//            String resultcontract = splitParts[splitParts.length - 1];
//
//            topSheeetDTO.setContract_no(resultcontract);
//            topSheeetDTO.setBillOfSupplyNo(Bill_of_Supply);
//            System.err.println(Bill_of_Supply);
//            topSheeetDTO.setInvoicevalue(Invoice_Value);
//            
//            listOfTopSheet.add(topSheeetDTO);
//            System.err.println(topSheeetDTO);
//            //JRDataSource dataSource = new JREmptyDataSource(listOfTopSheet);
//            JRBeanCollectionDataSource dataSource1 = new JRBeanCollectionDataSource(listOfTopSheet);

			// 2nd pdf

//        	BankDraftDTO bankDraftDTO = new BankDraftDTO();
//            List<BankDraftDTO> listOfBankdraft = new ArrayList<>();

			String consignment = "";
			List<Object[]> dateData = generationofBillService.ForDate(Challan_No1);
			for (Object[] row : dateData) {
				consignment = (String) row[9];

			}
			String unitname = "";
			String unitaddres = "";

			List<Object[]> listofaddress = generationofBillService.contarctnoformaster(millcode234);

//	        for (Object[] row : listofaddress) {
//			      unitname = (String) row[0];
//				  bankDraftDTO.setUnitname(unitname);
//				String strValue2 = (String) row[1];
//				String strValue3 = (String) row[2];
//				String strValue4 = (String) row[3];
//				String strValue5 = (String) row[4];
//				
//				unitaddres = strValue2 + strValue3 + strValue4+strValue5;
//				  bankDraftDTO.setUnitaddress(unitaddres);
//	        }

//	        ConvertWord_k convertWord_k = new ConvertWord_k();
//	        String stringValue5 =Invoice_Value;
//	       	double invoiceDouble = Double.parseDouble(stringValue5); // Parse String to double
//	           int convertInt = (int) invoiceDouble;
//	       	String InvoiceNO = convertWord_k.convertToWords(convertInt);
//	        bankDraftDTO.setInvoicevalue(InvoiceNO);
//	        
//	        bankDraftDTO.setBillOfSupplyNo(Bill_of_Supply);
//	        bankDraftDTO.setbOS_Date(BOS_Date);
//	        bankDraftDTO.setInvoicevalueInnumber(Invoice_Value);
//	        
//	        listOfBankdraft.add(bankDraftDTO);
//			

			///

//	       
//            JRBeanCollectionDataSource dataSource2 = new JRBeanCollectionDataSource(listOfBankdraft);
//            //3rd pdf generation
//            BillOfExchangeDTO billOfExchangeDTO = new BillOfExchangeDTO();
//            List<BillOfExchangeDTO> listOfBillofExchange = new ArrayList<>();
//            billOfExchangeDTO.setInvoicevalue(Invoice_Value);
//            billOfExchangeDTO.setInstrumentNo(InstrumentNo);
//            billOfExchangeDTO.setInstrumentDate(Instrumentdate);
//            billOfExchangeDTO.setBillofsupplyNo(Bill_of_Supply);
//            billOfExchangeDTO.setBosDate(BOS_Date);
//            billOfExchangeDTO.setBankname(bankName);
//            billOfExchangeDTO.setBankAddress(address);
//            
//            listOfBillofExchange.add(billOfExchangeDTO);
//            
//            
//           JRBeanCollectionDataSource dataSource3 = new JRBeanCollectionDataSource(listOfBillofExchange);
			// 4th pdf
			List<Object[]> contrcatnotomill = generationofBillService.contrcatnotomill(Conract_no);
//           BillOFExchangeWithout_LC_DTO billOFExchangeWithout_LC_DTO = new BillOFExchangeWithout_LC_DTO();
//           List<BillOFExchangeWithout_LC_DTO> listOfBillofExchangwithoutLC = new ArrayList<>();
//           for (Object[] row : contrcatnotomill) {
//			    String cropyear = (String) row[1];
//			    billOFExchangeWithout_LC_DTO.setCropyear(cropyear);
//				String contractdate = (String) row[2];
//				 billOFExchangeWithout_LC_DTO.setContarctdate(contractdate);
//				
//			 }

//           billOFExchangeWithout_LC_DTO.setUnitname(unitaddres);
//           billOFExchangeWithout_LC_DTO.setUnitaddress(unitaddres);
//           billOFExchangeWithout_LC_DTO.setBillofsupply(Bill_of_Supply);
//           billOFExchangeWithout_LC_DTO.setBosdate(BOS_Date);
//           billOFExchangeWithout_LC_DTO.setInvoicevalue(Invoice_Value);
//           billOFExchangeWithout_LC_DTO.setContarctno(Conract_no);

//           listOfBillofExchangwithoutLC.add(billOFExchangeWithout_LC_DTO);

//           JRBeanCollectionDataSource dataSource4 = new JRBeanCollectionDataSource(listOfBillofExchangwithoutLC);

			// Fill the report
//            JasperPrint jasperPrint1 = JasperFillManager.fillReport(jasperReport1, parameters, dataSource1);
//            JasperPrint jasperPrint2 = JasperFillManager.fillReport(jasperReport2, parameters, dataSource2);
//            JasperPrint jasperPrint3 = JasperFillManager.fillReport(jasperReport3, parameters, dataSource3);
//            JasperPrint jasperPrint4 = JasperFillManager.fillReport(jasperReport4, parameters, dataSource4);

			// Path to save the PDF

//            String fileName1 = "Topsheet" + Bill_of_Supply + ".pdf";
//            String fileName2 = "bankdraft" + Bill_of_Supply + ".pdf";
//            String fileName3 = "BankerCopy" + Bill_of_Supply + ".pdf";
//            String fileName4 = "BankerCopywithouLC" + Bill_of_Supply + ".pdf";
//            String savePath1 = "C:\\Users\\kailash.shah\\Desktop\\JCIStuff\\billOfSupplyDocument" + File.separator + fileName1;
//            String savePath2 = "C:\\Users\\kailash.shah\\Desktop\\JCIStuff\\billOfSupplyDocument" + File.separator + fileName2;
//            String savePath3 = "C:\\Users\\kailash.shah\\Desktop\\JCIStuff\\billOfSupplyDocument" + File.separator + fileName3;
//            String savePath4 = "C:\\Users\\kailash.shah\\Desktop\\JCIStuff\\billOfSupplyDocument" + File.separator + fileName4;

			// Generate and save the PDF
//            JasperExportManager.exportReportToPdfFile(jasperPrint1, savePath1);
//            JasperExportManager.exportReportToPdfFile(jasperPrint2, savePath2);
//            JasperExportManager.exportReportToPdfFile(jasperPrint3, savePath3);

//            // Send the PDF as a response
//            generateAndSendPdf1(response, jasperPrint1, savePath1);
//            generateAndSendPdf2(response, jasperPrint2, savePath2);
//            generateAndSendPdf3(response, jasperPrint3, savePath3);
//            generateAndSendPdf4(response, jasperPrint4, savePath4);

			List<Object[]> PANSTATE = generationofBillService.PANSTATE(millcode234);
			String mastterSatename = "";
			String mastterSatename2 = "";
			String CnsigneeStatecode = "";
			String ReciepentsStatecode = "";
			for (Object[] row : PANSTATE) {
				String strValue1 = (String) row[0];
				String strValue2 = (String) row[1];
				String strValue3 = (String) row[2];
				String strValue4 = (String) row[3];
				Integer Str = (Integer) row[4];
				String strValue5 = String.valueOf(Str);
				String strValue6 = (String) row[5];

				if (strValue2.equals(strValue6) && strValue3.equals(strValue5)) {
					mastterSatename = strValue4;
					mastterSatename2 = strValue4;
					ReciepentsStatecode = strValue5;

				} else if (strValue3.equals(strValue5)) {
					mastterSatename2 = strValue4;
				} else if (strValue2.equals(strValue6)) {
					mastterSatename = strValue4;
					ReciepentsStatecode = strValue5;
				}

			}

			List<Object> Non_lc = genrationCashDocumentService.Non_lc(Conract_no);
			for (Object obj : Non_lc) {
				String strValue = (String) obj;
				if (!strValue.equals("Letter_of_Credit")) {
					CashDocumentModel cashDocumentModel = new CashDocumentModel();
					cashDocumentModel.setCAD_Date(date);
					cashDocumentModel.setBOS_No(Bill_of_Supply);
					cashDocumentModel.setBOS_Date(BOS_Date);
					// cashDocumentModel.setbOEDOCpathnonlc(fileName4);
					cashDocumentModel.setMillcode(millcode234);
					cashDocumentModel.setContarctNo(Conract_no);
					cashDocumentModel.setInvoicevalue(Invoice_Value);
					this.genrationCashDocumentService.create(cashDocumentModel);

				}
			}

//		          cashDocumentModel.setBOS_Date(BOS_Date);
//		          cashDocumentModel.setBOS_No(Bill_of_Supply);

			PdfGenerator_K pdfgenereatorK = new PdfGenerator_K();

			String filePath = pdfgenereatorK.generateBillPdf(Invoice_Value, Challan_No1, Supplier_Name, Supplier_GSTN,
					Supplier_Address, Recipient_Name, Recipient_GSTN, Recipient_Address, Consignee_Name, Consignee_GSTN,
					Consignee_Address, Bill_of_Supply, Conract_no, Clientstate, Clientcode, ClientPan, BOS_Date,

					TrnasitPolicyNo, list, Vehicle_no, Driver_Lic_no, Driver_name, TCS_Amt, Genrationofbill,
					Statename23, StaeCode23, PAN23, mastterSatename, mastterSatename2, ReciepentsStatecode, dateData,
					Dpcname, millcode234, RegionAndCenterName1, consignment);
			generationOfBillSupplyModel.setBos_file_path(filePath);

			this.generationofBillService.create(generationOfBillSupplyModel);

			this.generationofBillService.billUpdation(Challan_No1);

			String contaractdate = "";
			String DiNo = "";
			String DiDate = "";
			String Challandate = "";
			String InstrumentNo = "";
			String Instrumentdate = "";
			String dpcname = " ";

			for (Object[] row : dateData) {
				if (row[0] != null)
					contaractdate = row[0].toString();
				if (row[1] != null)
					DiNo = row[1].toString();
				if (row[2] != null)
					DiDate = row[2].toString();
				if (row[3] != null)
					Challandate = row[3].toString();
				if (row[4] != null)
					InstrumentNo = row[5].toString();
				if (row[5] != null)
					Instrumentdate = row[6].toString();
			}

			String centerName = "";
			String centercode = "";
			String Roname = "";
			String Rocode = "";

			for (Object[] row : RegionAndCenterName1) {
				if (row[0] != null)
					centerName = row[0].toString();
				if (row[1] != null)
					centercode = row[1].toString();
				if (row[2] != null)
					Roname = row[2].toString();
				if (row[3] != null)
					Rocode = row[3].toString();

			}

			Map<String, Object> parameters = new HashMap<>();

			List<BillofSupplyDocDTO> listOfBillofSupplyDocDTO = new ArrayList<>();

			parameters.put("GstinSupplier", Supplier_GSTN);
			parameters.put("contractRef", Conract_no);
			parameters.put("contractdate", contaractdate);
			String Contdate = Conract_no + "  dt." + contaractdate;
			parameters.put("Contdate", Contdate);

			parameters.put("namesupplier", Supplier_Name);
			parameters.put("Diref", DiNo);
			parameters.put("didate", DiDate);
			String Didate = DiNo + "  dt." + DiDate;
			parameters.put("didateinfo", Didate);

			parameters.put("centername", centerName);
			parameters.put("centercode", centercode);

			parameters.put("roname", Roname);
			parameters.put("rocode", Rocode);

			String area = centerName + "(" + centercode + ")/" + Roname + "(" + Rocode + ")";
			parameters.put("Area", area);

			parameters.put("challanno", Challan_No1);
			parameters.put("challandate", Challandate);

			String chalandocinfo = Challan_No1 + " dt." + Challandate;
			parameters.put("challandocinfo", chalandocinfo);

			parameters.put("Cnno", consignment);

			parameters.put("addresSupplier", Supplier_Address);
			parameters.put("instrumentno", InstrumentNo);
			parameters.put("instrumendate", Instrumentdate);

			String instudocinfo = InstrumentNo + "  dt." + Instrumentdate;
			parameters.put("instudocinfo", instudocinfo);

			parameters.put("statename3", Statename23);
			parameters.put("billofsupllyno", Bill_of_Supply);

			parameters.put("statecode3", StaeCode23);
			parameters.put("billofsupplydate", BOS_Date);
			parameters.put("pan", PAN23);

			parameters.put("Receipantgstin", Recipient_GSTN);
			parameters.put("Consigneegstin", Consignee_GSTN);
			parameters.put("receipantsname", Recipient_Name);
			parameters.put("millcode", millcode234);
			parameters.put("consigneename", Consignee_Name);
			parameters.put("receipantsaddress", Recipient_Address);
			parameters.put("consigneeaddre", Consignee_Address);
			parameters.put("statename", mastterSatename);
			parameters.put("statename2", mastterSatename2);
			parameters.put("statecode", ReciepentsStatecode);
			parameters.put("statecode2", Clientcode);
			parameters.put("pan1", ClientPan);

			parameters.put("tcsamount", TCS_Amt);
			parameters.put("invoicevalue", Invoice_Value);
			parameters.put("transitpolicyno", TrnasitPolicyNo);
			parameters.put("driverlicno", Driver_Lic_no);
			parameters.put("vehicleno", Vehicle_no);
			parameters.put("drivernme", Driver_name);
			String str = Vehicle_no + "  " + Driver_name;
			parameters.put("licenceno", str);
			parameters.put("dpcname", Dpcname);

			int i = 0;
			double total = 0.0;
			double alltotal = 0.0;
			double qtygradesum = 0.0;
			for (Object[] row : list) {
				BillofSupplyDocDTO billofSupplyDocDTO = new BillofSupplyDocDTO();
				String cropyear = (String) row[0];

				billofSupplyDocDTO.setCropyear(cropyear);
				String balemark = (String) row[1];
				billofSupplyDocDTO.setBalemark(balemark);
				String jutegrade = (String) row[3];
				billofSupplyDocDTO.setVariety(jutegrade);
				billofSupplyDocDTO.setDescription("Raw jute");
				billofSupplyDocDTO.setHsn("53031010");
				billofSupplyDocDTO.setUnit("Qntls");
				billofSupplyDocDTO.setSiNo(i + 1);
				int no_ofbales = (int) row[4];
				billofSupplyDocDTO.setNo_of_bales(no_ofbales);

				double nominlwt = (double) row[5];
				double qty = (double) no_ofbales * nominlwt;
				qtygradesum += qty;
				billofSupplyDocDTO.setNominalWt(nominlwt);
				billofSupplyDocDTO.setQty(qty);
				double rate = (double) row[6];
				total = (double) rate * qty;
				billofSupplyDocDTO.setTotal(total);
				alltotal += total;

				billofSupplyDocDTO.setRate(rate);
				billofSupplyDocDTO.setRate(rate);
				i++;
				listOfBillofSupplyDocDTO.add(billofSupplyDocDTO);

			}

			double doubleValue = Double.parseDouble(TCS_Amt);
			alltotal = alltotal + doubleValue;
			alltotal = Math.round(alltotal);
			// billofSupplyDocDTO.setAlltotal(alltotal);
			// double doubleValue = Double.parseDouble(TCS_Amt);
//	            total=total+doubleValue;
			parameters.put("taotalsum", alltotal);

			ConvertWord_k convertWord_k = new ConvertWord_k();
			String stringValue5 = Double.toString(alltotal);
			double invoiceDouble = Double.parseDouble(stringValue5); // Parse String to double
			int convertInt = (int) invoiceDouble;
			String InvoiceNO = convertWord_k.convertToWords(convertInt);
			qtygradesum = Math.round(qtygradesum);
			parameters.put("invoicevalue", InvoiceNO);
			parameters.put("qtysum", qtygradesum);

			JasperReport jasperReport = JasperCompileManager.compileReport(new FileInputStream(billofsupply));
			JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(listOfBillofSupplyDocDTO);
			JasperPrint jasperPrint1 = JasperFillManager.fillReport(jasperReport, parameters, dataSource);

			// Defining the file name and save path
			String fileName = "billofsupplydoc" + Bill_of_Supply + ".pdf";
			File directory = new File(fcDownoad1);

			if (!directory.exists()) {
				if (directory.mkdirs()) {
					System.out.println("Directory created successfully");
				} else {
					System.err.println("Failed to create directory: " + directory.getAbsolutePath());
					return null;
				}
			}

			String savePath = fcDownoad1 + File.separator + fileName;

			try (OutputStream out = new FileOutputStream(savePath)) {
				JRPdfExporter exporter = new JRPdfExporter();
				exporter.setParameter(JRPdfExporterParameter.JASPER_PRINT, jasperPrint1);
				exporter.setParameter(JRPdfExporterParameter.OUTPUT_STREAM, out);
				exporter.exportReport();
			} catch (Exception e) {
				System.out.println(e.getLocalizedMessage());
			}

			response.setContentType("application/pdf");
			response.setHeader("Content-Disposition", "inline");

			List<Object[]> ListLCs = this.generationofBillService.GenrationAginstLCs(Conract_no);

//			TopSheetPdf_k pdfTopSheetPdf_k = new TopSheetPdf_k();
//			String filePath1 = pdfTopSheetPdf_k.generatePdfReport(list1);
//
//			String filePath2 = pdfTopSheetPdf_k.BOE();

			if (ListLCs == null || ListLCs.isEmpty()) {
				System.err.println("No results found for Contract No: " + Conract_no);
			} else {
				GenerationofDocumentLCsModel generationofDocumentLCsModel = null; // Declare and initialize the model
																					// outside the loop

				for (Object[] row : ListLCs) {
					String instNo = (String) row[0];
					String payentType = (String) row[1];

//					if (payentType.equalsIgnoreCase("Letter_of_Credit")) {
//						generationofDocumentLCsModel = new GenerationofDocumentLCsModel(); // Initialize the model
//																							// inside the loop for each
//																							// "Letter_of_Credit" row
//
//						generationofDocumentLCsModel.setBoe_Date(date);
//						generationofDocumentLCsModel.setbOS_No(Bill_of_Supply);
//						generationofDocumentLCsModel.setbOS_Date(BOS_Date);
//						generationofDocumentLCsModel.setIvoice_value(Invoice_Value);
//						generationofDocumentLCsModel.setInstrument_no(instNo);
//						generationofDocumentLCsModel.setMill_code(millcode234);
//						generationofDocumentLCsModel.setQuantity(Bill_of_Supply);
//						generationofDocumentLCsModel.setBos_Amt(BOS_Date);
//						//generationofDocumentLCsModel.setBillofexchangepath(fileName3);
//						
//						//generationofDocumentLCsModel.setTopsheetpath(fileName1);
//						generationofDocumentLCsModel.setChallanono(Challan_No1);
//
//						this.generationAgaistLCsService.create(generationofDocumentLCsModel);
//
//						
//						
//
//					}

				}

				if (generationofDocumentLCsModel == null) {
					System.err.println("No results found for Contract No: " + Conract_no);
				}
			}

			sendemailBOS email = new sendemailBOS();
			InternetAddress[] toAddresses = null;
			String subject = "Bill of Supply attachement";
			String body = "In this All information regarding Bill of supply . ";
			// String filename=Genrationofbill;

//	             
			// String filename = "C:\\Users\\kailash.shah\\documentimage\\neft";
			String filePathDir = Genrationofbill + File.separator + filePath;
			String username1 = "";
			try {
				// toAddresses = { new InternetAddress("vishal.vishwakarma@cyfuture.com") ,new
				// InternetAddress("animesh.anand@cyfuture.com")};
				toAddresses = new InternetAddress[] { new InternetAddress("kailashshahbro@gmail.com"),
						new InternetAddress("kailashshahsha81@gmail.com") };
			} catch (AddressException e) {

				e.printStackTrace();
			}
			email.sendEmailBos(toAddresses, body, subject, filePathDir, username1);

//		       
			this.paymentDetailService.contratTable(Conract_no);
			redirectAttributes.addFlashAttribute("msg",
					"<div class=\"alert alert-success\"><b>Success !</b> Record saved successfully.</div>\r\n" + "");

		} catch (Exception e) {

			e.printStackTrace();
		}
		if (username == null) {
			return new ModelAndView("index");
		}

		return new ModelAndView(new RedirectView("ViewofGenerationBillsupply.obj"));

	}

//	private static void generateAndSendPdf2(HttpServletResponse response, JasperPrint jasperPrint2, String savePath2) throws IOException {
//        try (ByteArrayOutputStream baos = new ByteArrayOutputStream()) {
//            byte[] bytes = JasperExportManager.exportReportToPdf(jasperPrint2);
//            baos.write(bytes);
//
//            try (FileOutputStream fos = new FileOutputStream(savePath2)) {
//                baos.writeTo(fos);
//            }
//      } catch (Exception e) {
//            e.printStackTrace();
//            response.setContentType("text/plain");
//            response.getWriter().println("Error generating PDF: " + e.getMessage());
//        }
//    }
//	private static void generateAndSendPdf3(HttpServletResponse response, JasperPrint jasperPrint3, String savePath3) throws IOException {
//        try (ByteArrayOutputStream baos = new ByteArrayOutputStream()) {
//            byte[] bytes = JasperExportManager.exportReportToPdf(jasperPrint3);
//            baos.write(bytes);
//
//            try (FileOutputStream fos = new FileOutputStream(savePath3)) {
//                baos.writeTo(fos);
//            }
//      } catch (Exception e) {
//            e.printStackTrace();
//            response.setContentType("text/plain");
//            response.getWriter().println("Error generating PDF: " + e.getMessage());
//        }
//    }

//	private static void generateAndSendPdf4(HttpServletResponse response, JasperPrint jasperPrint4, String savePath4) throws IOException {
//        try (ByteArrayOutputStream baos = new ByteArrayOutputStream()) {
//            byte[] bytes = JasperExportManager.exportReportToPdf(jasperPrint4);
//            baos.write(bytes);
//
//            try (FileOutputStream fos = new FileOutputStream(savePath4)) {
//                baos.writeTo(fos);
//            }
//      } catch (Exception e) {
//            e.printStackTrace();
//            response.setContentType("text/plain");
//            response.getWriter().println("Error generating PDF: " + e.getMessage());
//        }
//    }

	private static void generateAndSendPdf1(HttpServletResponse response, JasperPrint jasperPrint1, String savePath1)
			throws IOException {
		try (ByteArrayOutputStream baos = new ByteArrayOutputStream()) {
			byte[] bytes = JasperExportManager.exportReportToPdf(jasperPrint1);
			baos.write(bytes);

			try (FileOutputStream fos = new FileOutputStream(savePath1)) {
				baos.writeTo(fos);
			}
		} catch (Exception e) {
			e.printStackTrace();
			response.setContentType("text/plain");
			response.getWriter().println("Error generating PDF: " + e.getMessage());
		}
	}

	private static void generateAndSendPdf2(HttpServletResponse response, JasperPrint jasperPrint2, String savePath2)
			throws IOException {
		try (ByteArrayOutputStream baos = new ByteArrayOutputStream()) {
			byte[] bytes = JasperExportManager.exportReportToPdf(jasperPrint2);
			baos.write(bytes);

			try (FileOutputStream fos = new FileOutputStream(savePath2)) {
				baos.writeTo(fos);
			}
		} catch (Exception e) {
			e.printStackTrace();
			response.setContentType("text/plain");
			response.getWriter().println("Error generating PDF: " + e.getMessage());
		}
	}

	private static void generateAndSendPdf3(HttpServletResponse response, JasperPrint jasperPrint3, String savePath3)
			throws IOException {
		try (ByteArrayOutputStream baos = new ByteArrayOutputStream()) {
			byte[] bytes = JasperExportManager.exportReportToPdf(jasperPrint3);
			baos.write(bytes);

			try (FileOutputStream fos = new FileOutputStream(savePath3)) {
				baos.writeTo(fos);
			}
		} catch (Exception e) {
			e.printStackTrace();
			response.setContentType("text/plain");
			response.getWriter().println("Error generating PDF: " + e.getMessage());
		}
	}

	private static void generateAndSendPdf4(HttpServletResponse response, JasperPrint jasperPrint4, String savePath4)
			throws IOException {
		try (ByteArrayOutputStream baos = new ByteArrayOutputStream()) {
			byte[] bytes = JasperExportManager.exportReportToPdf(jasperPrint4);
			baos.write(bytes);

			try (FileOutputStream fos = new FileOutputStream(savePath4)) {
				baos.writeTo(fos);
			}
		} catch (Exception e) {
			e.printStackTrace();
			response.setContentType("text/plain");
			response.getWriter().println("Error generating PDF: " + e.getMessage());
		}
	}

	//////////////////////////////////////////////////

	@RequestMapping("downloadPDF")
	public void downloadPDF(@RequestParam("filename") String filename, HttpServletResponse response) {
		// String imageDirectory = "upload.Imagedownload";

		String imagePath = Genrationofbill + File.separator + filename;

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

				byte[] buffer = new byte[1024];
				int bytesRead;
				while ((bytesRead = fileInputStream.read(buffer)) != -1) {
					responseOutputStream.write(buffer, 0, bytesRead);
				}

				fileInputStream.close();
				responseOutputStream.close();
			} else {
				response.setStatus(HttpServletResponse.SC_NOT_FOUND);
			}
		} catch (IOException e) {

			e.printStackTrace();
			response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
		}
	}

	@RequestMapping("downloadPDFforbos")
	public void downloadPDFofafterBOS(@RequestParam("filename") String filename, HttpServletResponse response) {
		// String imageDirectory = "upload.Imagedownload";

		String imagePath = "C:\\Users\\kailash.shah\\Desktop\\JCIStuff\\billOfSupplyDocument" + File.separator
				+ filename;

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

				byte[] buffer = new byte[1024];
				int bytesRead;
				while ((bytesRead = fileInputStream.read(buffer)) != -1) {
					responseOutputStream.write(buffer, 0, bytesRead);
				}

				fileInputStream.close();
				responseOutputStream.close();
			} else {
				response.setStatus(HttpServletResponse.SC_NOT_FOUND);
			}
		} catch (IOException e) {

			e.printStackTrace();
			response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
		}
	}

	@RequestMapping("downloadPDFforbankDraft.obj")
	public void downloadPDFofafterBOSbankdraft(@RequestParam("filename") String millcode,
			@RequestParam("challanNO") String challanNO, @RequestParam("InvoiceValue") String InvoiceValue,
			@RequestParam("BosNO") String BosNO, @RequestParam("BosDate") String BosDate, HttpServletResponse response)
			throws FileNotFoundException, JRException {

		// Compile the Jasper reports
		JasperReport jasperReport2 = JasperCompileManager
				.compileReport(new FileInputStream("C:\\Users\\kailash.shah\\Desktop\\MSP\\JCI-CMS\\BOEDOC.jrxml"));

		// Set up parameters and data source
		Map<String, Object> parameters = new HashMap<>();
		BankDraftDTO bankDraftDTO = new BankDraftDTO();
		List<BankDraftDTO> listOfBankdraft = new ArrayList<>();

		// Fetch and process date data
		List<Object[]> dateData = generationofBillService.ForDate(challanNO);
		for (Object[] row1 : dateData) {
			if (row1[5] != null)
				bankDraftDTO.setInstrumentNO(row1[5].toString());
			if (row1[6] != null)
				bankDraftDTO.setInstrumentDate(row1[6].toString());
			if (row1[7] != null) {
				String ifsc = row1[7].toString();
				fetchBankDetails(ifsc, bankDraftDTO);
			}
		}

		// Fetch and process address data
		List<Object[]> listofaddress = generationofBillService.contarctnoformaster(millcode);
		for (Object[] row : listofaddress) {
			bankDraftDTO.setUnitname((String) row[0]);
			bankDraftDTO.setUnitaddress(
					String.join("", (String) row[1], (String) row[2], (String) row[3], (String) row[4]));
		}

		// Process invoice value
		ConvertWord_k convertWord_k = new ConvertWord_k();
		double invoiceDouble = Double.parseDouble(InvoiceValue);
		int convertInt = (int) invoiceDouble;
		bankDraftDTO.setInvoicevalue(convertWord_k.convertToWords(convertInt));
		bankDraftDTO.setInvoicevalueInnumber(InvoiceValue);
		bankDraftDTO.setBillOfSupplyNo(BosNO);
		bankDraftDTO.setbOS_Date(BosDate);
		Date date = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		String formattedDate = formatter.format(date);
		bankDraftDTO.setCurrentdate(formattedDate);
		listOfBankdraft.add(bankDraftDTO);
		JRBeanCollectionDataSource dataSource2 = new JRBeanCollectionDataSource(listOfBankdraft);

		// Fill the Jasper reports
		JasperPrint jasperPrint2 = JasperFillManager.fillReport(jasperReport2, parameters, dataSource2);

		// Set file names and paths
		String fileName2 = "bankdraft" + BosNO + ".pdf";
		String savePath2 = "C:\\Users\\kailash.shah\\Desktop\\JCIStuff\\billOfSupplyDocument" + File.separator
				+ fileName2;

		// Export the reports to PDF
		JasperExportManager.exportReportToPdfFile(jasperPrint2, savePath2);

		serveFileAsResponse(savePath2, fileName2, response);

		GenerationofDocumentLCsModel generationofDocumentLCsModel = new GenerationofDocumentLCsModel();
		generationofDocumentLCsModel.setBankdrftpath(fileName2);
	}

	private void fetchBankDetails(String ifsc, BankDraftDTO bankDraftDTO) {
		String url = "https://ifsc.razorpay.com/" + ifsc;
		RestTemplate restTemplate = new RestTemplate();
		try {
			String result = restTemplate.getForObject(url, String.class);
			JSONObject jsonObject = new JSONObject(result);
			bankDraftDTO.setBankName(jsonObject.optString("BANK"));
			bankDraftDTO.setBankAddress(jsonObject.optString("ADDRESS"));
		} catch (Exception e) {
			System.err.println("Error fetching data for IFSC " + ifsc + ": " + e.getMessage());
		}
	}

	private void serveFileAsResponse(String filePath, String fileName, HttpServletResponse response) {
		try {
			File file = new File(filePath);
			if (!file.exists()) {
				throw new FileNotFoundException("File not found: " + filePath);
			}
			response.setContentType("application/pdf");
			response.setHeader("Content-Disposition", "attachment; filename=\"" + fileName + "\"");
			response.setContentLength((int) file.length());
			Files.copy(file.toPath(), response.getOutputStream());
			response.getOutputStream().flush();
		} catch (IOException ex) {
			System.err.println("Error serving file: " + ex.getMessage());
		}
	}

	@RequestMapping("downloadPDFforBillofexchange.obj")
	public void downloadPDFofafterBOSbillofsupply(@RequestParam("challanNO") String challanNO,
			@RequestParam("InvoiceValue") String InvoiceValue, @RequestParam("BosNO") String BosNO,
			@RequestParam("BosDate") String BosDate, HttpServletResponse response)
			throws FileNotFoundException, JRException, IOException {

		// Compile the Jasper reports
		JasperReport jasperReport3 = JasperCompileManager.compileReport(
				new FileInputStream("C:\\Users\\kailash.shah\\Desktop\\MSP\\JCI-CMS\\billofexchange.jrxml"));

		// Set up parameters and data source
		Map<String, Object> parameters = new HashMap<>();

		BillOfExchangeDTO billOfExchangeDTO = new BillOfExchangeDTO();
		List<BillOfExchangeDTO> listOfBillofExchange = new ArrayList<>();
		// Fetch and process date data
		List<Object[]> dateData = generationofBillService.ForDate(challanNO);
		for (Object[] row1 : dateData) {
			if (row1[5] != null)
				billOfExchangeDTO.setInstrumentNo(row1[5].toString());
			if (row1[6] != null)
				billOfExchangeDTO.setInstrumentDate(row1[6].toString());
			if (row1[7] != null) {
				String ifsc = row1[7].toString();
				fetchBankDetails1(ifsc, billOfExchangeDTO);
			}
		}

		billOfExchangeDTO.setInvoicevalue(InvoiceValue);
		billOfExchangeDTO.setBillofsupplyNo(BosNO);
		billOfExchangeDTO.setBosDate(BosDate);
		Date date = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		String formattedDate = formatter.format(date);
		billOfExchangeDTO.setCurrentdate(formattedDate);

		listOfBillofExchange.add(billOfExchangeDTO);

		JRBeanCollectionDataSource dataSource3 = new JRBeanCollectionDataSource(listOfBillofExchange);
		JasperPrint jasperPrint3 = JasperFillManager.fillReport(jasperReport3, parameters, dataSource3);

		// Path to save the PDF
		String fileName3 = "BankerCopy" + BosNO + ".pdf";
		String savePath3 = "C:\\Users\\kailash.shah\\Desktop\\JCIStuff\\billOfSupplyDocument" + File.separator
				+ fileName3;

		// Ensure the directory exists
		File saveDir = new File("C:\\Users\\kailash.shah\\Desktop\\JCIStuff\\billOfSupplyDocument");
		if (!saveDir.exists()) {
			saveDir.mkdirs();
		}

		// Export to PDF
		JasperExportManager.exportReportToPdfFile(jasperPrint3, savePath3);

		serveFileAsResponse1(savePath3, fileName3, response);

		GenerationofDocumentLCsModel generationofDocumentLCsModel = new GenerationofDocumentLCsModel();
		generationofDocumentLCsModel.setBillofexchangepath(fileName3);
	}

	private void fetchBankDetails1(String ifsc, BillOfExchangeDTO billOfExchangeDTO) {
		String url = "https://ifsc.razorpay.com/" + ifsc;
		RestTemplate restTemplate = new RestTemplate();
		try {
			String result = restTemplate.getForObject(url, String.class);
			JSONObject jsonObject = new JSONObject(result);
			billOfExchangeDTO.setBankname(jsonObject.optString("BANK"));
			billOfExchangeDTO.setBankAddress(jsonObject.optString("ADDRESS"));
		} catch (Exception e) {
			System.err.println("Error fetching data for IFSC " + ifsc + ": " + e.getMessage());
		}
	}

	private void serveFileAsResponse1(String filePath, String fileName, HttpServletResponse response) {
		try {
			File file = new File(filePath);
			if (!file.exists()) {
				throw new FileNotFoundException("File not found: " + filePath);
			}
			response.setContentType("application/pdf");
			response.setHeader("Content-Disposition", "attachment; filename=\"" + fileName + "\"");
			response.setContentLength((int) file.length());
			Files.copy(file.toPath(), response.getOutputStream());
			response.getOutputStream().flush();
		} catch (IOException ex) {
			System.err.println("Error serving file: " + ex.getMessage());
		}
	}

	@RequestMapping("downloadPDFforboedocnonlc.obj")
	public void downloadPDFofafterBoedocnonlc(@RequestParam("contractno") String Conract_no,
			@RequestParam("InvoiceValue") String InvoiceValue, @RequestParam("BosNO") String BosNO,
			@RequestParam("BosDate") String BosDate, @RequestParam("millcode") String millcode,
			HttpServletResponse response) throws FileNotFoundException, JRException {

		// Compile the Jasper reports
		JasperReport jasperReport4 = JasperCompileManager.compileReport(
				new FileInputStream("C:\\Users\\kailash.shah\\Desktop\\MSP\\JCI-CMS\\BOE(NON-LC).jrxml"));

		// Set up parameters and data source
		Map<String, Object> parameters = new HashMap<>();

		// Fetch and process date data
		List<Object[]> contrcatnotomill = generationofBillService.contrcatnotomill(Conract_no);
		BillOFExchangeWithout_LC_DTO billOFExchangeWithout_LC_DTO = new BillOFExchangeWithout_LC_DTO();
		List<BillOFExchangeWithout_LC_DTO> listOfBillofExchangwithoutLC = new ArrayList<>();

		// Fetch and process address data
		List<Object[]> listofaddress = generationofBillService.contarctnoformaster(millcode);
		for (Object[] row : listofaddress) {
			billOFExchangeWithout_LC_DTO.setUnitname((String) row[0]);
			billOFExchangeWithout_LC_DTO.setUnitaddress(
					String.join("", (String) row[1], (String) row[2], (String) row[3], (String) row[4]));
		}

		// Process invoice value

		for (Object[] row : contrcatnotomill) {
			String cropyear = (String) row[1];
			billOFExchangeWithout_LC_DTO.setCropyear(cropyear);
			String contractdate = (String) row[2];
			billOFExchangeWithout_LC_DTO.setContarctdate(contractdate);

		}

		billOFExchangeWithout_LC_DTO.setBillofsupply(BosNO);
		billOFExchangeWithout_LC_DTO.setBosdate(BosDate);
		billOFExchangeWithout_LC_DTO.setInvoicevalue(InvoiceValue);
		billOFExchangeWithout_LC_DTO.setContarctno(Conract_no);

		Date date = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		String formattedDate = formatter.format(date);
		billOFExchangeWithout_LC_DTO.setCurrentdate(formattedDate);
		listOfBillofExchangwithoutLC.add(billOFExchangeWithout_LC_DTO);

		listOfBillofExchangwithoutLC.add(billOFExchangeWithout_LC_DTO);

		JRBeanCollectionDataSource dataSource4 = new JRBeanCollectionDataSource(listOfBillofExchangwithoutLC);

		JasperPrint jasperPrint4 = JasperFillManager.fillReport(jasperReport4, parameters, dataSource4);

		// Path to save the PDF

		String fileName4 = "BankerCopywithouLC" + BosNO + ".pdf";
		String savePath4 = "C:\\Users\\kailash.shah\\Desktop\\JCIStuff\\billOfSupplyDocument" + File.separator
				+ fileName4;

		// Export the reports to PDF
		JasperExportManager.exportReportToPdfFile(jasperPrint4, savePath4);

		serveFileAsResponse3(savePath4, fileName4, response);

		GenerationofDocumentLCsModel generationofDocumentLCsModel = new GenerationofDocumentLCsModel();
		// generationofDocumentLCsModel.setBankdrftpath(fileName2);
	}

	private void serveFileAsResponse3(String filePath, String fileName, HttpServletResponse response) {
		try {
			File file = new File(filePath);
			if (!file.exists()) {
				throw new FileNotFoundException("File not found: " + filePath);
			}
			response.setContentType("application/pdf");
			response.setHeader("Content-Disposition", "attachment; filename=\"" + fileName + "\"");
			response.setContentLength((int) file.length());
			Files.copy(file.toPath(), response.getOutputStream());
			response.getOutputStream().flush();
		} catch (IOException ex) {
			System.err.println("Error serving file: " + ex.getMessage());
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

	@ResponseBody
	@RequestMapping(value = "downloadPDFforbankDraftnew", method = RequestMethod.GET)
	public String saveCrnForClaim(@RequestParam("contractno") String contractno1, final HttpServletRequest request,
			HttpServletResponse response) throws IllegalStateException, IOException, ParseException {
		List<BankDraftDTO> listOfBankdraft = new ArrayList<>();
		List<Object[]> billdetails = generationAgaistLCsService.listdetailsbillofsupplly(contractno1);
		String bosno = "";

		for (Object[] datas : billdetails) {
			BankDraftDTO bankDraftDTO = new BankDraftDTO();
			bosno = (String) datas[0];
			String bosdate = (String) datas[1];
			String invoicevalue = (String) datas[2];
			String challanno = (String) datas[3]; // Corrected to proper index
			String millcode = (String) datas[4]; // Corrected to proper index
			System.err.println("Mill code: " + millcode);

			List<Object[]> dateData = generationofBillService.ForDate(challanno);
			for (Object[] row1 : dateData) {
				if (row1[5] != null)
					bankDraftDTO.setInstrumentNO(row1[5].toString());
				if (row1[6] != null)
					bankDraftDTO.setInstrumentDate(row1[6].toString());
				if (row1[7] != null) {
					String ifsc = row1[7].toString();
					fetchBankDetailslist(ifsc, bankDraftDTO);
				}
			}

			List<Object[]> listofaddress = generationofBillService.contarctnoformaster(millcode);
			for (Object[] row3 : listofaddress) {
				bankDraftDTO.setUnitname((String) row3[0]);
				bankDraftDTO.setUnitaddress(
						String.join("", (String) row3[1], (String) row3[2], (String) row3[3], (String) row3[4]));
			}

			ConvertWord_k convertWord_k = new ConvertWord_k();
			double invoiceDouble = Double.parseDouble(invoicevalue);
			int convertInt = (int) invoiceDouble;
			bankDraftDTO.setInvoicevalue(convertWord_k.convertToWords(convertInt));
			bankDraftDTO.setInvoicevalueInnumber(invoicevalue);
			bankDraftDTO.setBillOfSupplyNo(bosno);
			bankDraftDTO.setbOS_Date(bosdate);
			Date date = new Date();
			SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
			String formattedDate = formatter.format(date);
			bankDraftDTO.setCurrentdate(formattedDate);
			listOfBankdraft.add(bankDraftDTO);

			try {
				JasperReport jasperReport1 = JasperCompileManager
						.compileReport("C:\\Users\\kailash.shah\\Desktop\\MSP\\JCI-CMS\\BOEDOC.jrxml");
				// .compileReport("C:\\Users\\pradeep.rathor\\Desktop\\creditNote.jrxml");

				Map<String, Object> parameters = new HashMap<String, Object>();
				System.err.println("after jrxml file");

				// Prepare data sources
				JRBeanCollectionDataSource dataSource1 = new JRBeanCollectionDataSource(listOfBankdraft);

				// Fill JasperPrints
				JasperPrint jasperPrint1 = JasperFillManager.fillReport(jasperReport1, parameters, dataSource1);
				response.setContentType("application/pdf");
				response.setHeader("Content-Disposition", "inline");
				// response.setHeader("Content-Disposition", "attachment;
				// filename=TestCreditNote.pdf");
				// try (OutputStream out = response.getOutputStream()) {

				String filePathString = "C:\\Users\\kailash.shah\\Desktop\\JCIStuff\\billOfSupplyDocument";
				System.err.println("befor file creations");
				final File theDir = new File(filePathString);
				if (!theDir.exists()) {
					theDir.mkdirs();
				}

				String fileName2 = filePathString + File.separator + "bankdraft" + bosno + ".pdf";

				System.err.println("fileName2 => " + fileName2);

				try (OutputStream out = new FileOutputStream(fileName2)) {
					JRPdfExporter exporter = new JRPdfExporter();
					exporter.setParameter(JRPdfExporterParameter.JASPER_PRINT, jasperPrint1);

					exporter.setParameter(JRPdfExporterParameter.OUTPUT_STREAM, out);
					exporter.exportReport();

				} catch (Exception e) {
					e.printStackTrace();
					System.out.println(e.getLocalizedMessage());
				}

				// return new ModelAndView(new RedirectView("creditNoteList.obj"));

			} catch (JRException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

//	    try (FileInputStream fis = new FileInputStream("C:\\Users\\kailash.shah\\Desktop\\MSP\\JCI-CMS\\BOEDOC.jrxml")) {
//	        JasperReport jasperReport2 = JasperCompileManager.compileReport(fis);
//	        Map<String, Object> parameters = new HashMap<>();
//	        JRBeanCollectionDataSource dataSource2 = new JRBeanCollectionDataSource(listOfBankdraft);
//
//	        JasperPrint jasperPrint2 = JasperFillManager.fillReport(jasperReport2, parameters, dataSource2);
//
//	        response.setContentType("application/pdf");
//	        response.setHeader("Content-Disposition", "inline");
//
//	        String fileName2 = "bankdraft" + bosno + ".pdf";
//	        String savePath2 = "C:\\Users\\kailash.shah\\Desktop\\JCIStuff\\billOfSupplyDocument" + File.separator + fileName2;
//
//	        
//	        //JasperExportManager.exportReportToPdfFile(jasperPrint2, savePath2);
//	       // serveFileAsResponselist(savePath2, fileName2, response);
//
////	        GenerationofDocumentLCsModel generationofDocumentLCsModel = new GenerationofDocumentLCsModel();
////	        generationofDocumentLCsModel.setBankdrftpath(fileName2);
//
//	    } catch (JRException e) {
//	        e.printStackTrace();
//	        return "Error generating report: " + e.getMessage();
//	    }

		Gson gson = new Gson();
		return ""; // return the list of bank drafts as JSON
	}

	private void fetchBankDetailslist(String ifsc, BankDraftDTO bankDraftDTO) {
		String url = "https://ifsc.razorpay.com/" + ifsc;
		RestTemplate restTemplate = new RestTemplate();
		try {
			String result = restTemplate.getForObject(url, String.class);
			JSONObject jsonObject = new JSONObject(result);
			bankDraftDTO.setBankName(jsonObject.optString("BANK"));
			bankDraftDTO.setBankAddress(jsonObject.optString("ADDRESS"));
		} catch (RestClientException e) {
			System.err.println("Error fetching data for IFSC " + ifsc + ": " + e.getMessage());
		} catch (JSONException e) {
			System.err.println("Error parsing JSON response for IFSC " + ifsc + ": " + e.getMessage());
		} catch (Exception e) {
			System.err.println("General error for IFSC " + ifsc + ": " + e.getMessage());
		}
	}

	private void serveFileAsResponselist(String filePath, String fileName, HttpServletResponse response) {
		try {
			File file = new File(filePath);
			if (!file.exists()) {
				throw new FileNotFoundException("File not found: " + filePath);
			}
			response.setContentType("application/pdf");
			response.setHeader("Content-Disposition", "attachment; filename=\"" + fileName + "\"");
			response.setContentLength((int) file.length());

			Files.copy(file.toPath(), response.getOutputStream());
			response.getOutputStream().flush();
		} catch (IOException ex) {
			System.err.println("Error serving file: " + ex.getMessage());
		}
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
	@RequestMapping(value = "contrcatnotomill", method = RequestMethod.GET)
	public String contrcatnotomill(@RequestParam("contractno") String contractno1) {

		List<Object[]> contrcatnotomill = generationofBillService.contrcatnotomill(contractno1);
		System.err.println("resultList++++++++++" + contrcatnotomill);
		Gson gson = new Gson();
		String resultString = new Gson().toJson(contrcatnotomill);
		return resultString;// gson.toJson((Object)millRecieptModelt1);
	}

	@ResponseBody
	@RequestMapping(value = "paymentdetailsforshow", method = RequestMethod.GET)
	public String paymentdetails(@RequestParam("contractno") String contractno1) {

		List<Object[]> paymentdetails = paymentDetailService.paymentdetails(contractno1);
		System.err.println("resultList++++++++++" + paymentdetails);
		Gson gson = new Gson();
		String resultString = new Gson().toJson(paymentdetails);
		return resultString;// gson.toJson((Object)millRecieptModelt1);
	}

	@ResponseBody
	@RequestMapping(value = "fetchingdataforbill", method = RequestMethod.GET)
	public String fetchingdatanominactionclaimforbill(@RequestParam("contractno") String contractno) {
		System.err.println("resultList++++++++++" + contractno);
		List<Object[]> listofaddress = generationofBillService.contarctnoformaster(contractno);
		System.err.println(" listofaddress++++++++++" + listofaddress);
		Gson gson = new Gson();
		String resultString = new Gson().toJson(listofaddress);
		return resultString;
	}

	@ResponseBody
	@RequestMapping(value = "listofdispatchChild", method = RequestMethod.GET)
	public String listofdispatchChildinbos(@RequestParam("challanNo") String challanNo) {

		List<Object[]> ObjdispatchChildlist = generationofBillService.dispatchChildlist(challanNo);
		System.err.println("resultList++++++++++" + ObjdispatchChildlist);
		Gson gson = new Gson();
		String resultString = new Gson().toJson(ObjdispatchChildlist);
		return resultString;
	}

	@ResponseBody
	@RequestMapping(value = "listofLCBOS", method = RequestMethod.GET)
	public String listofLetterofcreditinbos(@RequestParam("serialno") String serialno) {

		List<Object[]> ObjdispatchChildlist = generationAgaistLCsService.bosnolist(serialno);
		System.err.println("resultList++++++++++" + ObjdispatchChildlist);
		Gson gson = new Gson();
		String resultString = new Gson().toJson(ObjdispatchChildlist);
		return resultString;
	}

	@ResponseBody
	@RequestMapping(value = "fetchingdataMillname", method = RequestMethod.GET)
	public String millnamedetails(@RequestParam("millname") String millname) {
		boolean listofaddress = generationofBillService.millnamefromTCS(millname);
		Gson gson = new Gson();
		String resultString = new Gson().toJson(listofaddress);
		return resultString;
	}

	@ResponseBody
	@RequestMapping(value = "greadewiseqty", method = RequestMethod.GET)
	public String greadewiseqtypayment(@RequestParam("contractno") String contractno,
			@RequestParam("contractqty") String contractqty) {
		List<Object[]> Graedewiseqty = paymentDetailService.gradewiseqty(contractno, contractqty);
		System.err.println("resultList++++++++++" + Graedewiseqty);
		Gson gson = new Gson();
		String resultString = new Gson().toJson(Graedewiseqty);
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

	// To load HO
	@RequestMapping("HOdispatchInst")
	public ModelAndView HODispatchInstructionModel(HttpServletRequest request, HttpSession session) {

		String username = (String) request.getSession().getAttribute("usrname");
		List<Object[]> contractList = (List<Object[]>) hoInstService.getContract();

		System.err.println(contractList);
		ModelAndView mv = new ModelAndView("HOdispatchinstruction");
		mv.addObject("ContractList", contractList);
		if (username == null) {
			mv = new ModelAndView("index");
		}

		String regionIdString = (String) session.getAttribute("region");
		List<Object[]> ronameList = (List<Object[]>) hoInstService.getRoname();
		List<String> juteVariety = (List<String>) hoInstService.getJuteVariety();
		List<String> loadAllCooperativesList = roDispatchService.getCooperative(regionIdString);
		System.err.println(ronameList);
		mv.addObject("ronameList", ronameList);
		mv.addObject("juteVariety", juteVariety);
		mv.addObject("loadAllCooperativesList", loadAllCooperativesList);

		return mv;
	}

	// To get ho Details

	@ResponseBody
	@RequestMapping(value = "HoDispatch", method = RequestMethod.GET)
	public String hoDispatchIn(@RequestParam("contract") String ContractNo) {
		System.err.println(ContractNo);
		List<String> contractDetList = (List<String>) hoInstService.getDetails(ContractNo);

		Gson gson = new Gson();
		String jsonResponse = gson.toJson(contractDetList);

		return jsonResponse;
	}

//DPC finding for Region
	@ResponseBody
	@RequestMapping({ "findDpc" })
	public String findDpcByRegion(@RequestParam("id") String id, HttpServletRequest request) {

		String username = (String) request.getSession().getAttribute("usrname");
		final Gson gson = new Gson();
		/*
		 * System.err.println((Object)
		 * this.purchaseCenterService.purchaseCenter(request.getParameter("id")));
		 */
		return gson.toJson((Object) this.purchaseCenterService.purchaseCenter(request.getParameter("id")));

	}

//To get count previous HO count dor DI no. for particular Region
	@ResponseBody
	@RequestMapping({ "countHo" })
	public String countHo(@RequestParam("reg") String reg, HttpServletRequest request) {

		final Gson gson = new Gson();
		return gson.toJson((Object) this.hoInstService.getCount(reg));

	}

	@Value("${upload.HoDiDoc}")
	String HoDiDoc;

	@Value("${upload.hodispatch}")
	String HoDI;

	@RequestMapping(value = "savehodispatchInst", method = RequestMethod.POST)
	public ModelAndView hoDispatchInstruction(HttpServletRequest request, RedirectAttributes redirectAttributes,
			HttpServletResponse response) {
		String username = (String) request.getSession().getAttribute("usrname");
		try {

			String[] variety = request.getParameterValues("jutevariety");

			List<HoDispatchDto> hoDispatchDtoList = new ArrayList<>();

			String diNoString = "";
			String documentName = "";
			Double qty = 0.0;
			for (String st : variety) {

				Integer usId = (Integer) request.getSession().getAttribute("userId");//

				String user = Integer.toString(usId);

				String contNo = request.getParameter("fullcontractno");//

				String crpyrString = request.getParameter("cropyear");//

				String contqtyString = request.getParameter("contractquantity");//

				Double cQtyDouble = Double.parseDouble(contqtyString);//

				String dIString = request.getParameter("dateofdi");//

				String dateStr = request.getParameter("dateofdi");
				SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd");
				Date result = formater.parse(dateStr);
				SimpleDateFormat newFormater = new SimpleDateFormat("dd-MM-yyyy");

				String fcString = request.getParameter("FC_Ref_No");//

				diNoString = request.getParameter("uniqueno");//

				String contDateString = request.getParameter("contractdate");//

				String allowQty = request.getParameter("qty");//

				Double qtyDouble = Double.parseDouble(allowQty);

				String regOfficeString = request.getParameter("region");//

				String[] dpcString = request.getParameterValues("dpc_name");

				String lastShipString = request.getParameter("lastdateofshipment");//

				String dateStr1 = request.getParameter("lastdateofshipment");
				SimpleDateFormat formater1 = new SimpleDateFormat("yyyy-MM-dd");
				Date result1 = formater1.parse(dateStr1);
				SimpleDateFormat newFormater1 = new SimpleDateFormat("dd-MM-yyyy");

				JciDIHoModel diHo = new JciDIHoModel();
				String gprice0 = request.getParameter(st + "-grade" + "1");
				if (gprice0 == null) {
					gprice0 = "0.0";
				}
				Double g0 = Double.parseDouble(gprice0);
				String gprice1 = request.getParameter(st + "-grade" + "2");
				if (gprice1 == null) {
					gprice1 = "0.0";
				}
				Double g1 = Double.parseDouble(gprice1);

				String gprice2 = request.getParameter(st + "-grade" + "3");
				if (gprice2 == null) {
					gprice2 = "0.0";
				}
				Double g2 = Double.parseDouble(gprice2);

				String gprice3 = request.getParameter(st + "-grade" + "4");
				if (gprice3 == null) {
					gprice3 = "0.0";
				}
				Double g3 = Double.parseDouble(gprice3);

				String gprice4 = request.getParameter(st + "-grade" + "5");
				if (gprice4 == null) {
					gprice4 = "0.0";
				}
				Double g4 = Double.parseDouble(gprice4);

				String gprice5 = request.getParameter(st + "-grade" + "6");
				if (gprice5 == null) {
					gprice5 = "0.0";
				}
				Double g5 = Double.parseDouble(gprice5);

				String gprice6 = request.getParameter(st + "-grade" + "7");
				if (gprice6 == null) {
					gprice6 = "0.0";
				}
				Double g6 = Double.parseDouble(gprice6);

				String gprice7 = request.getParameter(st + "-grade" + "8");
				if (gprice7 == null) {
					gprice7 = "0.0";
				}
				Double g7 = Double.parseDouble(gprice7);

				String remString = request.getParameter("remarks");

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
				} else
					s = "";
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

				String replacedString = diNoString.replace("/", "-");

				System.out.println(replacedString);
				documentName = "HoDIDoc" + replacedString + ".pdf";
				diHo.setHoDIDoc(documentName);
				this.hoInstService.create(diHo);

				HoDispatchDto hoDispatchDto = new HoDispatchDto();
				hoDispatchDto.setCropYearString(crpyrString);
				hoDispatchDto.setJuteVarietyString(st);
				hoDispatchDto.settotal(g0 + g1 + g2 + g3 + g4 + g5 + g6 + g7);
				System.err.println(hoDispatchDto.gettotal());
				hoDispatchDto.setgrade1(g0);
				hoDispatchDto.setgrade2(g1);
				hoDispatchDto.setgrade3(g2);
				hoDispatchDto.setgrade4(g3);
				hoDispatchDto.setgrade5(g4);
				hoDispatchDto.setgrade6(g5);
				hoDispatchDto.setgrade7(g6);
				hoDispatchDto.setgrade8(g7);
				qty += g0 + g1 + g2 + g3 + g4 + g5 + g6 + g7;

				hoDispatchDtoList.add(hoDispatchDto);

			}
			try {
				List<Object[]> list = hoInstService.getJasperData(diNoString);

				JasperReport jasperReport1 = JasperCompileManager.compileReport(HoDI);
				// .compileReport("C:\\Users\\pradeep.rathor\\Desktop\\creditNote.jrxml");

				Map<String, Object> parameters = new HashMap<String, Object>();

				for (Object[] details : list) {
					parameters.put("DI_no", details[0]);
					parameters.put("DI_Date", details[1]);
					parameters.put("Add", (String) details[2] + "," + (String) details[3] + "," + (String) details[4]
							+ "," + (String) details[5] + "," + (String) details[6]);
					parameters.put("Contract_no", details[7]);
					parameters.put("Contract_Date", details[8]);
					parameters.put("CropYear", details[9]);
					parameters.put("LastDate", details[10]);
					parameters.put("RoName", details[11] + " Regional Office");
					parameters.put("totalQty", qty);
				}

				// Prepare data sources
				JRBeanCollectionDataSource dataSource1 = new JRBeanCollectionDataSource(hoDispatchDtoList);

				// Fill JasperPrints
				JasperPrint jasperPrint1 = JasperFillManager.fillReport(jasperReport1, parameters, dataSource1);//
				response.setContentType("application/pdf");
				response.setHeader("Content-Disposition", "inline");
				// response.setHeader("Content-Disposition", "attachment;
				// filename=TestCreditNote.pdf");
				// try (OutputStream out = response.getOutputStream()) {

				String replacedString = diNoString.replace("/", "-");

				System.out.println(replacedString);
				documentName = "HoDIDoc" + replacedString + ".pdf";

				final File theDir = new File(HoDiDoc);
				if (!theDir.exists()) {
					theDir.mkdirs();
				}

				String saveFile = HoDiDoc + File.separator + documentName;

				System.err.println("save File " + saveFile);
				System.err.println("save File " + saveFile);
				System.err.println("save File " + saveFile);

				try (OutputStream out = new FileOutputStream(saveFile)) {
					JRPdfExporter exporter = new JRPdfExporter();
					exporter.setParameter(JRPdfExporterParameter.JASPER_PRINT, jasperPrint1);

					exporter.setParameter(JRPdfExporterParameter.OUTPUT_STREAM, out);
					exporter.exportReport();

				} catch (Exception e) {
					System.out.println(e.getLocalizedMessage());
				}

				// return new ModelAndView(new RedirectView("creditNoteList.obj"));

			} catch (JRException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
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

	// View JCI

	@RequestMapping("jcilist")
	public String jciHoList(Model model) {

		List<Object[]> AllList = (List<Object[]>) hoInstService.getAll();
		model.addAttribute("AllList", AllList);

		return "ViewJCIHO";
	}

	@RequestMapping("downloadSupportDocHO")
	public void downloadHODoc(@RequestParam("filename") String filename, HttpServletResponse response) {
		String imagePath = HoDiDoc + "\\" + filename;
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
				try (FileInputStream fileInputStream = new FileInputStream(imageFile);
						OutputStream responseOutputStream = response.getOutputStream()) {
					byte[] buffer = new byte[1024];
					int bytesRead;
					while ((bytesRead = fileInputStream.read(buffer)) != -1) {
						responseOutputStream.write(buffer, 0, bytesRead);
					}
				}
			} catch (IOException e) {
				// Handle IO exception
				e.printStackTrace();
				response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
			}
		} else {
			response.setStatus(HttpServletResponse.SC_NOT_FOUND);
		}
	}

	@RequestMapping("downloadSupportDocDemandNote")
	public void downloadDemandNote(@RequestParam("filename") String filename, HttpServletResponse response) {
		String imagePath = DemandNoteSave + "\\" + filename;
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
				try (FileInputStream fileInputStream = new FileInputStream(imageFile);
						OutputStream responseOutputStream = response.getOutputStream()) {
					byte[] buffer = new byte[1024];
					int bytesRead;
					while ((bytesRead = fileInputStream.read(buffer)) != -1) {
						responseOutputStream.write(buffer, 0, bytesRead);
					}
				}
			} catch (IOException e) {
				// Handle IO exception
				e.printStackTrace();
				response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
			}
		} else {
			response.setStatus(HttpServletResponse.SC_NOT_FOUND);
		}
	}
	// Delete DI for particular DI no.

	@RequestMapping({ "deleteHO" })
	public ModelAndView deleteHO(final HttpServletRequest request, RedirectAttributes redirectAttributes, Model model) {
		ModelAndView mv = new ModelAndView("ViewJCIHO");
		try {
			String id = request.getParameter("id");
			System.err.println(id);
			/*
			 * String string = hoInstService.getContractNo(id); String flag =
			 * hoInstService.check(string);
			 * 
			 * System.err.println(flag);
			 */ // Assuming these print statements are for debugging

			/*
			 * if ("0".equals(flag)) { List<Object[]> allList = hoInstService.getAll();
			 * mv.addObject("AllList", allList); redirectAttributes.addFlashAttribute("msg",
			 * "<div class=\"alert alert-danger\"><b>Error!</b> Data cannot be deleted as Dispatch has been issued.</div>"
			 * ); } else if ("1".equals(flag)) { hoInstService.delete(id); List<Object[]>
			 * allList = hoInstService.getAll(); mv.addObject("AllList", allList);
			 * redirectAttributes.addFlashAttribute("msg",
			 * "<div class=\"alert alert-success\"><b>Success !</b> Data deleted successfully.</div>"
			 * ); }
			 */
			hoInstService.delete(id);
			List<Object[]> allList = hoInstService.getAll();
			mv.addObject("AllList", allList);
		} catch (Exception e) {
			System.out.println("Error in deleting ruling market: " + e.getMessage());
			redirectAttributes.addFlashAttribute("msg",
					"<div class=\"alert alert-danger\"><b>Error!</b> An unexpected error occurred. Please try again.</div>");
		}
		return new ModelAndView(new RedirectView("jcilist.obj"));
	}

// Vishwdeep RO

	// To get Cooperatives list for particular RO

	@ResponseBody
	@RequestMapping(value = "getCooperative", method = RequestMethod.GET)
	public List<String> getList(HttpSession session) {
		String regionIdString = (String) session.getAttribute("region");

		return roDispatchService.getCooperative(regionIdString);

	}

	@ResponseBody
	@RequestMapping(value = "dpcCheck", method = RequestMethod.GET)
	public String dpcCheck(HttpServletRequest request, @RequestParam("dpc") String dpc,
			@RequestParam("hoDiNo") String hoDIno) {
		System.err.println("Reached ajax");
		final Gson gson = new Gson();
		String result = roDispatchService.dpcCheck(dpc, hoDIno);
		return gson.toJson(result);
	}

	// To get Ro Form

	@RequestMapping("roDispatchInstruction")
	public ModelAndView viewRoDispatcher(HttpServletRequest request, HttpSession session) throws FileNotFoundException {
		String username = (String) request.getSession().getAttribute("usrname");
		if (username == null) {
			return new ModelAndView("index");
		}
		String regionIdString = (String) session.getAttribute("region");
		List<String> loadAllDpc = roDispatchService.loadAllDpc();
		List<String> loadAllDiNo = roDispatchService.loadAllDiNo();
		List<String> loadAllCooperativesList = roDispatchService.getCooperative(regionIdString);
		System.err.println(loadAllCooperativesList);
		ModelAndView mv = new ModelAndView("roDispatchInstruction");
		mv.addObject("loadAllDpc", loadAllDpc);
		mv.addObject("loadAllDiNo", loadAllDiNo);
		mv.addObject("loadAllCooperativesList", loadAllCooperativesList);
		// mv.addObject("count",countAvaiResult);

		///// generated new file /////////////////////////

		///////////////////////////////////////////////////////////

		return mv;
	}

	// Save RO Multiple
	@ResponseBody
	@RequestMapping(value = "saveRoDi", method = { RequestMethod.POST })
	public String saveRoDispatch(@RequestBody Map<String, Object> requestBody, RedirectAttributes redirectAttributes)
			throws ParseException {
		List<Map<String, Object>> juteDetails = (List<Map<String, Object>>) requestBody.get("juteDetails");

		// Handle other fields from the request body
		String contractNoString = (String) requestBody.get("contractNo");

		String hoDiNo = (String) requestBody.get("hoDiNo");

		String hoDiDate = (String) requestBody.get("hoDiDate");

		String contractDate = (String) requestBody.get("contractDate");

		String cropYear = (String) requestBody.get("cropYear");

		String dpc = (String) requestBody.get("dpc");

		String roDiNo = (String) requestBody.get("roDiNo");

		String roDiDate = (String) requestBody.get("roDiDate");

		String lastDateOfShipment = (String) requestBody.get("lastDateOfShipment");

		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat outPutDate = new SimpleDateFormat("dd-MM-yyyy");
		Date fomatedDate = dateFormat.parse(lastDateOfShipment);
		String finalStringDate = outPutDate.format(fomatedDate);

		String remarksValue = (String) requestBody.get("remarksValue");
		System.err.println("Remarks Value: " + remarksValue);
		Date date = new Date();
		SimpleDateFormat simpleDateTimeFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String dateFormater = simpleDateTimeFormat.format(date);
		Date created_Date = null;
		created_Date = simpleDateTimeFormat.parse(dateFormater);
		for (Map<String, Object> entry : juteDetails) {
			RoDispatchModel roDispatchModel = new RoDispatchModel();
			String juteVar = (String) entry.get("juteVar");
			Object valuesObj = entry.get("values");
			roDispatchModel.setJuteVariety(juteVar);
			roDispatchModel.setContractDate(contractDate);
			roDispatchModel.setContractNo(contractNoString);
			roDispatchModel.setCreationDate(created_Date);
			roDispatchModel.setCropYear(cropYear);
			roDispatchModel.setDpc(dpc);
			roDispatchModel.setHoDiDate(hoDiDate);
			roDispatchModel.setHoDiNo(hoDiNo);
			roDispatchModel.setLastDateOfShipment(finalStringDate);
			roDispatchModel.setRemarks(remarksValue);
			roDispatchModel.setRoDiDate(roDiDate);
			roDispatchModel.setRoDiNo(roDiNo);

			if (valuesObj instanceof ArrayList) {
				List<String> stringValues = (ArrayList<String>) valuesObj;
				roDispatchModel.setGr1Qty(Double.parseDouble(stringValues.get(0)));
				roDispatchModel.setGr2Qty(Double.parseDouble(stringValues.get(1)));
				roDispatchModel.setGr3Qty(Double.parseDouble(stringValues.get(2)));
				roDispatchModel.setGr4Qty(Double.parseDouble(stringValues.get(3)));
				roDispatchModel.setGr5Qty(Double.parseDouble(stringValues.get(4)));
				roDispatchModel.setGr6Qty(Double.parseDouble(stringValues.get(5)));
				roDispatchModel.setGr7Qty(Double.parseDouble(stringValues.get(6)));
				roDispatchModel.setGr8Qty(Double.parseDouble(stringValues.get(7)));
				this.roDispatchService.create(roDispatchModel);

//                System.out.println("Double values: " + doubleValues);
			} else {
				System.err.println("Unexpected data type for 'values'.");

			}
		}
		roDispatchService.update(contractNoString);
		redirectAttributes.addFlashAttribute("msg", "Data saved successfully.");

		return "redirect:/roDispatchInstruction.obj";
	}

	// RO List
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

	// Fetch details for DI
	@ResponseBody
	@RequestMapping(value = "fetchDetails", method = RequestMethod.GET)
	public String fetchDetails(@RequestParam("diNo") String HOno) {

		List<String> detailsList = (List<String>) roDispatchService.getDetails(HOno);

		Gson gson = new Gson();
		String jsonResponse = gson.toJson(detailsList);

		return jsonResponse;

	}

	// To get the details of previous DIs
	@ResponseBody
	@RequestMapping(value = "getdetails", method = RequestMethod.GET)
	public String getDetails(@RequestParam("diNo") String diNo) {
		List<String> list = (List<String>) this.roDispatchService.getprevious(diNo);
		Gson gson = new Gson();
		String jsonResponse = gson.toJson(list);
		return jsonResponse;
	}
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

// Entry and Nomination of Claim Settlement
	@RequestMapping("entryofConfirmationSettelment")
	public ModelAndView entryofConfirationSettelment(HttpServletRequest request) {
		String username = (String) request.getSession().getAttribute("usrname");

		ModelAndView mv = new ModelAndView("ConfirmationofClaimSettlement");
		if (username == null) {
			mv = new ModelAndView("index");
		}
		List<Object[]> getSettlementidlist = this.confirmationofClaimSettlementService.SettlementId(username);
		System.err.println(getSettlementidlist);
		mv.addObject("getSettlementidlist", getSettlementidlist);
		return mv;
	}

	@ResponseBody
	@RequestMapping(value = "fetchSettlementData", method = RequestMethod.GET)
	public String fetchingdatatocontractnoji(@RequestParam("id") String id) {
		List<Object[]> getcontractddownlist = confirmationofClaimSettlementService.fetchdataofclaim(id);
		System.err.println("resultList++++++++++" + getcontractddownlist);
		Gson gson = new Gson();
		String resultString = new Gson().toJson(getcontractddownlist);
		return resultString;
	}

	@ResponseBody
	@RequestMapping(value = "fetchingdatanominactionclaim", method = RequestMethod.GET)
	public String fetchingdatanominactionclaim(@RequestParam("contractno") String contractno) {
		List<Object[]> getsettlementlist = confirmationofClaimSettlementService.fetchdatasttlement(contractno);
		System.err.println("resultList++++++++++" + getsettlementlist);
		Gson gson = new Gson();
		String resultString = new Gson().toJson(getsettlementlist);
		return resultString;
	}

	@ResponseBody
	@RequestMapping(value = "fetchContractNo", method = RequestMethod.GET)
	public String contractNo(@RequestParam("id") String settlementId) {
		List<String> contractList = confirmationofClaimSettlementService.fetchContract(settlementId);
		System.err.println("resultList++++++++++" + contractList);
		Gson gson = new Gson();
		String resultString = new Gson().toJson(contractList);
		return resultString;
	}

	@Value("${upload.Confirmationsettlement}")
	String ConfirmationOfClaim;

	@RequestMapping("saveConfirmationOfClaimSettelment.obj")
	public ModelAndView saveConfirmationOfClaimSettelment(HttpSession session, HttpServletRequest request,
			RedirectAttributes redirectAttributes) {

		final ModelAndView mv = new ModelAndView();
		String username = (String) request.getSession().getAttribute("usrname");
		try {
			String count = request.getParameter("q");
			int cnt = Integer.parseInt(count);
			System.err.println(count);
			System.err.println(count);
			System.err.println(count);
			System.err.println(count);
			/* String CAD_Doc_No = request.getParameter("CAD_Doc_No"); */

			String Settlement_Id1 = request.getParameter("Settlement_Id1");

			double defaultValue = 0.0;

			String Inspection_by1 = request.getParameter("Inspectionby1");

			String rolename = (String) session.getAttribute("rolename");

			String Settlement_Amount1 = request.getParameter("SettlementAmount");

			for (int i = 0; i < cnt; i++) {
				ConfirmationClaimSettlementModel confirmationClaimSettlementModel = new ConfirmationClaimSettlementModel();
				String juteVar = request.getParameter("jv" + i);
				String juteGrade = request.getParameter("jg" + i);
				String fullcontractno = request.getParameter("cont" + i);
				System.err.println(fullcontractno);
				String Challan_No1 = request.getParameter("ch" + i);
				System.err.println(Challan_No1);
				String Date_of_inspection1 = request.getParameter("di" + i);
				System.err.println(Date_of_inspection1);
				String claim_Amt1 = request.getParameter("cl" + i);
				if (Settlement_Amount1 != null) {

					double Settlement_Amount12 = Double.parseDouble(Settlement_Amount1);
					confirmationClaimSettlementModel.setSettlement_amt(Settlement_Amount12);
				} else {
					double Settlement_Amount12 = defaultValue;
					confirmationClaimSettlementModel.setClaim_Amount(Settlement_Amount12);
				}
				if (claim_Amt1 != null) {

					double claim_Amt12 = Double.parseDouble(claim_Amt1);
					confirmationClaimSettlementModel.setClaim_Amount(claim_Amt12);
				} else {
					double claim_Amt12 = defaultValue;
					confirmationClaimSettlementModel.setClaim_Amount(claim_Amt12);
				}
				String Quality_Settlement1 = request.getParameter("qs" + i);
				System.err.println("Quality_Settlement1:" + Quality_Settlement1);
				if (Quality_Settlement1 != null) {

					double Quality_Settlement12 = Double.parseDouble(Quality_Settlement1);
					System.err.println("Quality_Settlement12:" + Quality_Settlement12);
					confirmationClaimSettlementModel.setQuality_settlement(Quality_Settlement12);
				} else {
					double Quality_Settlement12 = defaultValue;
					confirmationClaimSettlementModel.setQuality_settlement(Quality_Settlement12);
				}
				String Dust_settlement1 = request.getParameter("ds" + i);
				if (Dust_settlement1 != null) {

					double Dust_Settlement12 = Double.parseDouble(Dust_settlement1);
					System.err.println("Dust_Settlement12:" + Dust_Settlement12);
					confirmationClaimSettlementModel.setDust_settlement(Dust_Settlement12);
				} else {
					double Dust_Settlement12 = defaultValue;
					confirmationClaimSettlementModel.setDust_settlement(Dust_Settlement12);
				}

				String Moisture_Settlement1 = request.getParameter("ms" + i);
				System.err.println("Moisture_Settlement1:" + Moisture_Settlement1);
				if (Moisture_Settlement1 != null) {

					double Moisture_Settlement12 = Double.parseDouble(Moisture_Settlement1);
					System.err.println("Moisture_Settlement12:" + Moisture_Settlement12);
					confirmationClaimSettlementModel.setMoisture_settlement(Moisture_Settlement12);
				} else {
					double Moisture_Settlement12 = defaultValue;
					confirmationClaimSettlementModel.setMoisture_settlement(Moisture_Settlement12);
				}

				String NCV_Settlement1 = request.getParameter("ns" + i);
				System.err.println("NCV_Settlement1:" + NCV_Settlement1);
				if (NCV_Settlement1 != null) {

					double NCV_Settlement12 = Double.parseDouble(NCV_Settlement1);
					System.err.println("NCV_Settlement12:" + NCV_Settlement12);
					confirmationClaimSettlementModel.setNcv_settlement(NCV_Settlement12);
				} else {
					double NCV_Settlement12 = defaultValue;
					confirmationClaimSettlementModel.setNcv_settlement(NCV_Settlement12);
				}

				SimpleDateFormat formatter1 = new SimpleDateFormat("dd-MM-yyyy"); // Corrected format for parsing
				Date instdate1 = formatter1.parse(Date_of_inspection1);

//           // Formatting the date for display in DD-MM-YYYY format
//            SimpleDateFormat formatter2 = new SimpleDateFormat("dd-MM-yyyy");
//           String formattedDate = formatter2.format(instdate1);
//           SimpleDateFormat originalFormat = new SimpleDateFormat("dd-MM-yyyy");
//           Date parsedDate = originalFormat.parse(formattedDate);
//           System.err.println(formattedDate); // Print formatted date string

				// Set the original Date object to the model

				confirmationClaimSettlementModel.setSettlement_id(Settlement_Id1);
				// confirmationClaimSettlementModel.setMill(Settlement_Id12);
				confirmationClaimSettlementModel.setDate_of_Inspection(instdate1);
				confirmationClaimSettlementModel.setContract_No(fullcontractno);
				confirmationClaimSettlementModel.setChallan_No(Challan_No1);

				confirmationClaimSettlementModel.setInspection_by(username);
				confirmationClaimSettlementModel.setJute_Grade(juteGrade);
				confirmationClaimSettlementModel.setJute_Variety(juteVar);

//           confirmationClaimSettlementModel.setSupporting_doc(Supporting_document1);

				Date date1 = new Date();
				String millName = request.getParameter("mill");
				confirmationClaimSettlementModel.setDispute_flag(0);
				confirmationClaimSettlementModel.setOM_Official(username);
				confirmationClaimSettlementModel.setMill(millName);
				confirmationClaimSettlementModel.setFA_Official("");
				confirmationClaimSettlementModel.setCreated_by(username);
				confirmationClaimSettlementModel.setCreated_on(date1);
				confirmationClaimSettlementModel.setActive("1");
				confirmationClaimSettlementModel.setMill_Acc("0");

				this.confirmationofClaimSettlementService.create(confirmationClaimSettlementModel);
			}

		} catch (Exception e) {
			System.err.println("overall catch inside----");
			redirectAttributes.addFlashAttribute("msg",
					"<div class=\"alert alert-danger\">" + "<b>Error!</b> Failed to save record.</div>");

		}
		if (username == null) {
			return new ModelAndView("index");
		}
		redirectAttributes.addFlashAttribute("msg",
				"<div class=\"alert alert-success\"><b>Success !</b> Record saved successfully.</div>\r\n" + "");
		return new ModelAndView(new RedirectView("entryofConfirmationSettelment.obj"));
	}

	@RequestMapping({ "ViewConfirmationsettelment" })
	public ModelAndView ViewConfirmationsettelment(final HttpServletRequest request) {
		String username = (String) request.getSession().getAttribute("usrname");
		ModelAndView mv = new ModelAndView("viewConfirmationsettelment");
		if (username == null) {
			mv = new ModelAndView("index");
		}

		final List<ConfirmationClaimSettlementModel> confirmationClaim = (List<ConfirmationClaimSettlementModel>) this.confirmationofClaimSettlementService
				.getAll();
		mv.addObject("confirmationClaim", confirmationClaim);

		return mv;
	}

	@RequestMapping("downloadSupportDocument")
	public void downloadDocs(@RequestParam("filename") String filename, HttpServletResponse response) {
		String imagePath = ConfirmationOfClaim + filename;
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
				try (FileInputStream fileInputStream = new FileInputStream(imageFile);
						OutputStream responseOutputStream = response.getOutputStream()) {
					byte[] buffer = new byte[1024];
					int bytesRead;
					while ((bytesRead = fileInputStream.read(buffer)) != -1) {
						responseOutputStream.write(buffer, 0, bytesRead);
					}
				}
			} catch (IOException e) {
				// Handle IO exception
				e.printStackTrace();
				response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
			}
		} else {
			response.setStatus(HttpServletResponse.SC_NOT_FOUND);
		}
	}

/////////////////////////////////////// MILL ACCEPTENCE START ///////////////////////////////////////////////////////////////////
	@RequestMapping("viewmillAcc")
	public String ViewMillAcceptance1(Model model, HttpServletRequest request) {

		ModelAndView mv = new ModelAndView("listMillAcceptence");

//		String username = (String) request.getSession().getAttribute("usrname");
//    	String useremail = (String) request.getSession().getAttribute("useremail");

//		if (useremail != null && username == null) {
//		    return "millLogin";
//		}  if (username != null && useremail == null ) {
//		    return "index";
//		}
//		
		String millcode = (String) request.getSession().getAttribute("millcode");
		List<Contractgeneration> AllList = (List<Contractgeneration>) millacct.getAll(millcode);
		Collections.reverse(AllList);
		model.addAttribute("AllList", AllList);
		return "listMillAcceptence";
	}

///////////////////////////////// this will be used in free sales and commercial///////////////////////////////////////////
	@RequestMapping("saveMillAcceptenceFile")
	public ModelAndView millaccept(HttpServletRequest request, RedirectAttributes redirectAttributes, HttpSession s)
			throws IllegalStateException, IOException {

		String contractId = request.getParameter("contract_id");

		millacct.updatemillacceptflag(contractId);
		redirectAttributes.addFlashAttribute("msg",
				(Object) "<div class=\"alert alert-success\"><b>Success !</b> Contract Accepted.</div>\r\n");

		return new ModelAndView(new RedirectView("viewmillAcc.obj"));

	}

	@Value("${upload.millAcceptDownolad}")
	String millAcceptDownolad;

	@RequestMapping("downloadSupportingDocumententMillAccept")
	public void downloadDocument(@RequestParam("filename") String filename, HttpServletResponse response) {

		String imageDirectory = millAcceptDownolad; // directory path
		String idn = filename.split("C")[0];
		String imagePath = imageDirectory + File.separator + idn + File.separator + filename;

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

//////////////////////////////////////////MILL ACCEPTENCE END //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

//---------------------------------------------------------
//Nomination of official for claim settlement
//---------------------------------------------------------

	// Showing the Form of Nominal form for fILLING
	@RequestMapping("viewmnominalform")
	public ModelAndView ViewNominalform(HttpServletRequest request) {
		String username = (String) request.getSession().getAttribute("usrname");
		ModelAndView mv = new ModelAndView("Nominationofofficial");
		if (username == null) {
			mv = new ModelAndView("index");
		}
		List<String> millid = nominalOfficialService.millid_MillReceipt();
		List<UserRegistrationModel> OM_official = nominalOfficialService.getom_official();
		List<UserRegistrationModel> FA_official = nominalOfficialService.getfa_official();
		List<String> contractno = nominalOfficialService.contractno_ContractTable();
		List<String> DI_no = nominalOfficialService.gethodi();
		mv.addObject("OM_official", OM_official);
		mv.addObject("FA_official", FA_official);
		mv.addObject("millid", millid);
		mv.addObject("DI_no", DI_no);
		return mv;
	}

	@ResponseBody
	@RequestMapping(value = "findByHoDi", method = RequestMethod.GET)
	public String hodinofech(@RequestParam("hodino") String hodino) {

		List<Object[]> millReceiptData = nominalOfficialService.getchallan(hodino);
		// Convert the a JSON in string
		Gson gson = new Gson();
		String jsonResponse = gson.toJson(millReceiptData);
		return jsonResponse;
	}

	// For Handling AJAX Url for Fetching the contract number Table Data.
	@ResponseBody
	@RequestMapping(value = "fetchmillreceiptdata", method = RequestMethod.GET)
	public String FetchDataMillReciept(@RequestParam("millid") String millid) {
		List<Object> millReceiptData = nominalOfficialService.FetchMillReceiptData(millid);
		Gson gson = new Gson();
		String jsonResponse = gson.toJson(millReceiptData);
		return jsonResponse;

	}

	// AJAX fetching data from grade_composition.
	@ResponseBody
	@RequestMapping(value = "gradecomposition1", method = RequestMethod.GET)
	public String GradeComposition1(@RequestParam("ContractNo") String ContractNo) {
		List<Object> gradecmposition = nominalOfficialService.gradecomposition(ContractNo);
		// Convert the a JSON in string
		Gson gson = new Gson();
		String jsonResponse = gson.toJson(gradecmposition);
		return jsonResponse;
	}

	@ResponseBody
	@RequestMapping(value = "fetchdateOfInspection", method = RequestMethod.GET)
	public String DateOfInspection(@RequestParam("DateOfInspection") String DateOfInspection) {
		List<Object[]> dateofinspection = nominalOfficialService.dateofInspection(DateOfInspection);
		Gson gson = new Gson();
		String jsonResponse = gson.toJson(dateofinspection);
		return jsonResponse;
	}

	@RequestMapping("savenominal")
	public ModelAndView saveNominalform(HttpServletRequest request, RedirectAttributes redirectAttributes) {
		int rows = Integer.parseInt(request.getParameter("rows"));
		String[] challanNos = request.getParameterValues("challans[]");
		String[] mr_no = request.getParameterValues("mr_no[]");
		String[] mr_date = request.getParameterValues("mr_date[]");
		String[] billofsupply = request.getParameterValues("billofsupply[]");
		String[] dateofshipment = request.getParameterValues("dateofshipment[]");
		String[] shipmentquantity = request.getParameterValues("shipmentquantity[]");
		String[] claimamount = request.getParameterValues("claimamount[]");

		// String SetllementIdGenerated;
		String Settlement_id_generated = request.getParameter("Settlement_id_generated");
		String HoDI = request.getParameter("HO_DI_&_Date");
		String total = nominalOfficialService.CountRecord();
		int value1;
		if (total != null) {
			String str = total;
			int secondSlashIndex = str.indexOf('/', str.indexOf('/') + 1); // Find the index of the second '/'
			String extractedValue = str.substring(secondSlashIndex + 1); // Extract the substring after the second '/'
			int value = Integer.parseInt(extractedValue); // Convert the extracted substring to an integer
			value1 = value + 1;
			System.out.println(value1);
		} else {
			value1 = 1;

		}

		// System.err.println(total);
		String SetllementIdGenerated = HoDI + "/" + value1;
		String username = (String) request.getSession().getAttribute("usrname");
		String millname = request.getParameter("client_name");
		String Mill = request.getParameter("Mill");
		String ContractNo = request.getParameter("ContractNo");
		String omofficial = request.getParameter("omofficial");
		String FAofficial = request.getParameter("FAomofficial");
		String DateofInpection = request.getParameter("DateofInpection");
		String contractIdentificationnumber = nominalOfficialService.getcontractidentification(ContractNo);
		String millcode = nominalOfficialService.getmillcode(Mill);

		for (int i = 0; i < rows; i++) {
			String check = request.getParameter("rowCheckbox" + i);
			if (check != null) {
				Jciclaim_NominationModel jciclaim_NominationModel = new Jciclaim_NominationModel();

				jciclaim_NominationModel.setMill(Mill);
				jciclaim_NominationModel.setContractNo(ContractNo);
				jciclaim_NominationModel.setOMOfficial(omofficial);
				jciclaim_NominationModel.setFAOfficial(FAofficial);
				jciclaim_NominationModel.setCreated_by(username);
				jciclaim_NominationModel.setHoDi(HoDI);
				jciclaim_NominationModel.setDateofInspection(DateofInpection);
				jciclaim_NominationModel.setChallans(challanNos[i]);
				jciclaim_NominationModel.setMr_number(mr_no[i]);
				jciclaim_NominationModel.setMr_Date(mr_date[i]);
				jciclaim_NominationModel.setBillOfSupply_number(billofsupply[i]);
				jciclaim_NominationModel.setDateofshipment(dateofshipment[i]);
				jciclaim_NominationModel.setShipmentquantity(shipmentquantity[i]);
				jciclaim_NominationModel.setClaimValuation(claimamount[i]);
				jciclaim_NominationModel.setSettlement_id_generated(SetllementIdGenerated);
				jciclaim_NominationModel.setDispute_flag(0);

				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
				LocalDate currentDate = LocalDate.now();
				String formattedDate = currentDate.format(formatter);
				jciclaim_NominationModel.setCreated_on(formattedDate);
				nominalOfficialService.create(jciclaim_NominationModel);
				String mr = mr_no[i];
				nominalOfficialService.millrecieptstatus(mr);
			}

		}

		redirectAttributes.addFlashAttribute("msg",
				(Object) "<div class=\"alert alert-success\"><b>Success !</b> Record saved successfully.</div>\r\n");

/////////////// It will change the contract_status on jci contract on form submit/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		String ContractNoForClaimStatusUpdate = request.getParameter("ContractNo");
		nominalOfficialService.claimStatusUpdate(ContractNoForClaimStatusUpdate);
///////////////// It will change claim status on Jcimill_receipt on form submit///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		return new ModelAndView(new RedirectView("viewlistnominal.obj"));
	}

	@RequestMapping(value = "updatenominalform", method = RequestMethod.GET)
	public ModelAndView updateNominalform(HttpServletRequest request) {
		String username = (String) request.getSession().getAttribute("usrname");
		ModelAndView mv = new ModelAndView("editnominationofofficial");
		if (username == null) {
			mv = new ModelAndView("index");
		}
		String id = request.getParameter("id");
		Jciclaim_NominationModel nomination = nominalOfficialService.find(id);
		mv.addObject("nomination", nomination);
		List<Jciclaim_NominationModel> findnominationdetails = this.nominalOfficialService.findnominationdetails(id);
		mv.addObject("findnominationdetails", findnominationdetails);
		List<UserRegistrationModel> FA_official = nominalOfficialService.getfa_official();
		mv.addObject("FA_official", FA_official);
		return mv;
	}

	@RequestMapping(value = "nominationdetails", method = RequestMethod.GET)
	public ModelAndView NominationDetails(HttpServletRequest request, Model model) {
		String username = (String) request.getSession().getAttribute("usrname");
		ModelAndView mv = new ModelAndView("nominationdetails");
		if (username == null) {
			mv = new ModelAndView("index");
		}

		String settlement_id = request.getParameter("id");
		List<Jciclaim_NominationModel> AllList = (List<Jciclaim_NominationModel>) nominalOfficialService
				.getAlldetails(settlement_id);
		model.addAttribute("jciclaim_NominationModel", AllList);
		return mv;
	}

	@Value("${upload.claimSettlementReportDownload}")
	String claimSettlementReportDownload;
	@Value("${upload.claimsetlmentJRXMLpath}")
	String claimsetlmentJRXMLpath;

	@RequestMapping("updatesavenominalform")
	public ModelAndView updatesavenominatiion(HttpServletRequest request, HttpServletResponse response,
			RedirectAttributes redirectAttributes) {
		String username = (String) request.getSession().getAttribute("usrname");
		ModelAndView mv = new ModelAndView("editnominationofofficial");
		if (username == null) {
			return new ModelAndView("index");
		}
		try {
			String FAomofficial = request.getParameter("FAomofficial");
			String id = request.getParameter("Settlement_id_generated");
			nominalOfficialService.updatefa(id, FAomofficial);

			redirectAttributes.addFlashAttribute("msg",
					"<div class=\"alert alert-success\"><b>Success !</b> Record saved successfully.</div>\r\n");
			String Mill = request.getParameter("millname");
			String omofficial = request.getParameter("omoofficial");
			String DateofInpection = request.getParameter("DateofInpection");
			List<ClaimSettlementReport> pdfnomination = nominalOfficialService.getNominationReportData(id);
			// System.err.println(pdfnomination);
			String id1 = id.replace('/', '-');
			String directoryPath = claimSettlementReportDownload;
			// String directoryPath = "C:\\Users\\Mansi.Gupta\\Documents\\newreportsave\\";
			// System.err.println(directoryPath);
			String filename = id1 + "claimSettlementReport.pdf"; // Change this to your desired filename
			String filepath = directoryPath + filename;

			// System.out.println(filepath + "kkkkk");

			try {
				JasperReport jasperReport1 = JasperCompileManager.compileReport(claimsetlmentJRXMLpath);
				Map<String, Object> parameters = new HashMap<String, Object>();
				// Prepare data sources
				JRBeanCollectionDataSource dataSource1 = new JRBeanCollectionDataSource(pdfnomination);
				// Fill JasperPrints
				JasperPrint jasperPrint1 = JasperFillManager.fillReport(jasperReport1, parameters, dataSource1);
				// Create the file on the server
				JasperExportManager.exportReportToPdfFile(jasperPrint1, filepath);
			} catch (JRException e) {
				e.printStackTrace();
			}

			// Email sending code
			// 1- This email is for FaOfficial
			EmailSender emailfa = new EmailSender();
			InternetAddress[] toAddresses = null;
			String subjectfa = "Nomination for Claim Settlement";
			String bodyfa = "Dear " + FAomofficial + ",\n" + "I hope this email finds you well.\n"
					+ "We are pleased to inform you that you have been nominated for the claim settlement for " + Mill
					+ " on Date: " + DateofInpection + " .\n" + "\n" + "Thanks & Regards,\n"
					+ "Jute Corporation of India";

			String filenamefa1 = filepath;
			String usernamefa = filename;
			String userEmailFA = nominalOfficialService.getEmailForFA(FAomofficial);
			try {
				toAddresses = new InternetAddress[] {
						// new InternetAddress("mansi.gupta@cyfuture.com")
						new InternetAddress(userEmailFA) };

			} catch (AddressException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			emailfa.sendEmail(toAddresses, bodyfa, subjectfa, filenamefa1, usernamefa);

			// 2- email is for omoofficial
			EmailSender emailomo = new EmailSender();
			InternetAddress[] toAddressesomo = null;
			String subjectomo = "Nomination for Claim Settlement";
			String bodyomo = "Dear " + omofficial + ",\n" + "I hope this email finds you well.\n"
					+ "We are pleased to inform you that you have been nominated for the claim settlement for " + Mill
					+ " on Date: " + DateofInpection + ".\n" + "\n" + "Thanks & Regards,\n"
					+ "Jute Corporation of India";
			String filenameomo = filepath;

			String usernameomo = filename;
			String userEmailOmo = nominalOfficialService.getEmailForOmo(omofficial);
			try {
				toAddressesomo = new InternetAddress[] {
						// new InternetAddress("mansi.gupta@cyfuture.com")
						// new InternetAddress("mansigupta18001@gmail.com")
						new InternetAddress(userEmailOmo)

				};

			} catch (AddressException e) {
				e.printStackTrace();
			}
			emailomo.sendEmail(toAddressesomo, bodyomo, subjectomo, filenameomo, usernameomo);

			// 3- email is for mill
			EmailSender emailmill = new EmailSender();
			InternetAddress[] toAddressesmill = null;
			String subjectmill = "Nomination for Claim Settlement";

			String bodymill = "Dear " + Mill + ",\n" + "I hope this email finds you well.\n"
					+ "We are pleased to inform you that " + Mill
					+ " have been nominated for the claim settlement  on Date: " + DateofInpection + ".\n" + "\n"
					+ "Thanks & Regards,\n" + "Jute Corporation of India";

			String filenamemill = filepath;
			String usernamemill = filename;

			String userEmailmill = nominalOfficialService.getEmailForOmo(omofficial);
			try {
				toAddressesmill = new InternetAddress[] {
						// new InternetAddress("mansi.gupta@cyfuture.com")
						new InternetAddress("mansigupta18001@gmail.com")

				};

			} catch (AddressException e) {

				e.printStackTrace();
			}
			emailmill.sendEmail(toAddressesmill, bodymill, subjectmill, filenamemill, usernamemill);

			redirectAttributes.addFlashAttribute("msg",
					"<div class=\"alert alert-success\"><b>Success !</b> Record saved successfully.</div>\r\n");

			return new ModelAndView((View) new RedirectView("viewlistnominal.obj"));

		} catch (Exception e) {
			System.out.println("Error in update user profile" + e.getStackTrace());
			return mv;
		}
	}

	@RequestMapping("viewlistnominal")
	public ModelAndView ViewNominal(Model model, HttpServletRequest request) {
		ModelAndView mv = new ModelAndView("viewlistnominal");
		String username = (String) request.getSession().getAttribute("usrname");

		if (username == null) {
			mv = new ModelAndView("index");
		}
		List<Jciclaim_NominationModel> AllList = (List<Jciclaim_NominationModel>) nominalOfficialService.getAll();
		Collections.reverse(AllList);
		model.addAttribute("jciclaim_NominationModel", AllList);
		String omofficial = request.getParameter("omofficial");
		return mv;
	}

	@Value("${upload.GenrationofbillDownload}")
	String GenrationofbillDownload;

	@RequestMapping("downloadBillOfSupplyDocument")
	public void downloadbosdocument(@RequestParam("filename") String filename, HttpServletResponse response) {
		// String imageDirectory = "upload.Imagedownload";

		String imagePath = GenrationofbillDownload + File.separator + filename;
		File imageFile = new File(imagePath);

		try {

			if (imageFile.exists()) {

				String contentType = determineContentType4(filename);
				response.setContentType(contentType);

				response.setContentLength((int) imageFile.length());
				response.setHeader("Content-Disposition", "attachment; filename=billofsupplyfinal.pdf");
//			                //response.setHeader("Content-Disposition", "");

				FileInputStream fileInputStream = new FileInputStream(imageFile);
				OutputStream responseOutputStream = response.getOutputStream();

				byte[] buffer = new byte[1024];
				int bytesRead;
				while ((bytesRead = fileInputStream.read(buffer)) != -1) {
					responseOutputStream.write(buffer, 0, bytesRead);
				}

				fileInputStream.close();
				responseOutputStream.close();
			} else {
				response.setStatus(HttpServletResponse.SC_NOT_FOUND);
			}
		} catch (IOException e) {

			e.printStackTrace();
			response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
		}
	}

	private String determineContentType4(String filePath4) {
		if (filePath4.endsWith(".pdf")) {
			return "application/pdf";
		} else if (filePath4.endsWith(".jpg") || filePath4.endsWith(".jpeg")) {
			return "image/jpeg";
		} else if (filePath4.endsWith(".png")) {
			return "image/png";
		} else {
			return "application/octet-stream";
		}
	}

////////////////////////////////////////////// NOMINATION OF OFFICIAL FOR CLAIM SETTLEMENT END //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

///////////////////////////////////////////////ENTRY OF TDS START////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

//---------------------------------------------------------
//Entry of tds 
//---------------------------------------------------------

	@RequestMapping("entryoftds")
	public ModelAndView EntryofTDSForm(HttpServletRequest request) {

		String username = (String) request.getSession().getAttribute("usrname");

		ModelAndView mv = new ModelAndView("EntryofTds");

		if (username == null) {

			mv = new ModelAndView("index");

		}

		// Adding the Mill Name as a Drop Down List In Entry Of TDS Form

		List<String> Mill = entryofTdsService.MillName();

		mv.addObject("Mill", Mill);

		return mv;

	}

	// Handling the Ajax Call URL For FEtching Financial Year Based On Mill Name
	// Saving the Entry of TDS Data
	@Value("${upload.EntryTdsSupportingDocument}")
	String EntryTdsSupportingDocument;

	@RequestMapping("saveentryoftds")

	public ModelAndView saveEntryOfTds(HttpServletRequest request, RedirectAttributes redirectAttributes,
			@RequestParam("SupportingDocument") final MultipartFile SupportingDocument, HttpSession s)
			throws IllegalStateException, IOException {

		String username = (String) request.getSession().getAttribute("usrname");

		String Mill = request.getParameter("Mill");

		String DateofIntimation = request.getParameter("DateofIntimation");

		String Financialyear = request.getParameter("Financialyear");
		String fullPath = EntryTdsSupportingDocument;

		final File theDir = new File(fullPath);

//	     final File theDir = new File("C:\\Users\\Mansi.Gupta\\Downloads\\upload\\millAcceptence");

		if (!theDir.exists()) {

			theDir.mkdirs();

		}

		final String filename = SupportingDocument.getOriginalFilename();

		File serverFile = new File(theDir, filename);

		SupportingDocument.transferTo(serverFile);

		// Creating object of

		JciEntryTdsModel jciEntryTdsModel = new JciEntryTdsModel();

		jciEntryTdsModel.setMill(Mill);

		jciEntryTdsModel.setFinancial_year(Financialyear);

		jciEntryTdsModel.setDate_of_Intimation(DateofIntimation);

		jciEntryTdsModel.setSupporting_document(filename);
		System.err.println(filename);
		// setting Static Value for Remaining

		entryofTdsService.create(jciEntryTdsModel);

		redirectAttributes.addFlashAttribute("msg",
				(Object) "<div class=\"alert alert-success\"><b>Success !</b> Record saved successfully.</div>\r\n");

		return new ModelAndView(new RedirectView("viewentryoftds.obj"));

	}

	@RequestMapping("viewentryoftds")

	public ModelAndView ViewEntryofTds(Model model, HttpServletRequest request) {

		String username = (String) request.getSession().getAttribute("usrname");

		ModelAndView mv = new ModelAndView("ViewEntryOfTds");

		if (username == null) {

			mv = new ModelAndView("index");

		}

		List<JciEntryTdsModel> AllList = (List<JciEntryTdsModel>) entryofTdsService.getAll();
		Collections.reverse(AllList);
		model.addAttribute("AllList", AllList);

		return mv;

	}

	@Value("${upload.EntryOfTdsDownolad}")
	String EntryOfTdsDownload;

	@RequestMapping("downloadSupportingDocumententrytds")

	public void downloadDoc(@RequestParam("filename") String filename, HttpServletResponse response) {

		String imageDirectory = EntryOfTdsDownload; // Replace with your image
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

	private String determineContentType3(String filename) {

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

	// For Handling AJax Url

	@ResponseBody

	@RequestMapping(value = "finacialyear", method = RequestMethod.GET)

	public String fetchFContractIdentifcation_jcicontract(@RequestParam("Mill") String Mill) {

		String contractIdentication = (String) entryofTdsService.contractIdentification(Mill);

		System.out.println(contractIdentication);

		// Convert the a JSON in string

		Gson gson = new Gson();

		String jsonResponse = gson.toJson(contractIdentication);

		return jsonResponse;

	}

////////////////////////////////////////////////////// Entry of TDS END ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/// ///////////////////////////////////////////////mill registration Start//////////////////////////////////////

	@RequestMapping("millRegisteration")
	public ModelAndView millregistration(Model model, HttpServletRequest request) {
		// String username = (String) request.getSession().getAttribute("usrname");

		ModelAndView mv = new ModelAndView("millRegistration");
		String username = (String) request.getSession().getAttribute("usrname");
		if (username == null) {

			mv = new ModelAndView("index");

		}
		List<String> millid = millRegistrationService.MillName();
		mv.addObject("millid", millid);

		// model.addAttribute("AllList", AllList);
		return mv;
	}

	@ResponseBody
	@RequestMapping(value = "millcodefetch", method = RequestMethod.GET)
	public String MillCodeFetch(@RequestParam("millid") String millid) {

		List<Object> millReceiptData = millRegistrationService.FetchMillReceiptData(millid);

		Gson gson = new Gson();
		String jsonResponse = gson.toJson(millReceiptData);

		return jsonResponse;

	}

	@ResponseBody
	@RequestMapping(value = { "validatemillEmail" }, method = { RequestMethod.GET })
	public String validatemillEmail(final HttpServletRequest request) {

		final Gson gson = new Gson();
		return this.millRegistrationService.validatemillEmail(request.getParameter("Email")) + "";
	}

	@ResponseBody
	@RequestMapping(value = { "validatemill" }, method = { RequestMethod.GET })
	public String validatemill(final HttpServletRequest request) {

		final Gson gson = new Gson();
		return this.millRegistrationService.validatemill(request.getParameter("millName")) + "";
	}

	@RequestMapping("savemillregister")
	public ModelAndView saveMillRegisration(HttpServletRequest request, RedirectAttributes redirectAttributes,
			HttpSession s) throws IllegalStateException, IOException {

		String username = (String) request.getSession().getAttribute("usrname");

		String mill_name = request.getParameter("mill_name");

		String mill_password = request.getParameter("mill_password");
		String confirm_mill_password = request.getParameter("confirm_mill_password");

		String mill_code = request.getParameter("mill_code");
		String mill_emailaddress = request.getParameter("mill_emailaddress");

		String mill_mobile = request.getParameter("mill_mobile");
		String official_name = request.getParameter("official_name");
		String official_designation = request.getParameter("official_designation");

		// Creating object of

		MillRegistrationModel millRegistrationModel = new MillRegistrationModel();
		millRegistrationModel.setMill_name(mill_name);
		millRegistrationModel.setOfficial_name(official_name);
		millRegistrationModel.setOfficial_designation(official_designation);
		millRegistrationModel.setMill_code(mill_code);
		millRegistrationModel.setMill_emailaddress(mill_emailaddress);
		millRegistrationModel.setMill_mobile(mill_mobile);
		millRegistrationModel.setMill_password(mill_password);
		millRegistrationModel.setConfirm_mill_password(confirm_mill_password);
		// ModelAndView mv = new ModelAndView();
		final boolean emailNotExist = this.millRegistrationService.validatemillEmail(mill_emailaddress);
		final boolean millNotRegistered = this.millRegistrationService.validatemill(mill_name);

		if (emailNotExist && mill_password.equals(confirm_mill_password) && millNotRegistered == false) {
			// Create mill registration
			millRegistrationService.create(millRegistrationModel);
			// Redirect with success message
			redirectAttributes.addFlashAttribute("msg",
					"<div class=\"alert alert-success\"><b>Success !</b> Record saved successfully.</div>\r\n");
			return new ModelAndView(new RedirectView("viewmillRegistration.obj"));
		} else if (!mill_password.equals(confirm_mill_password)) {
			// Redirect with password mismatch message
			redirectAttributes.addFlashAttribute("msg",
					"<div class=\"alert alert-warning\"><b>OOps!</b> Mill Password and Confirm Mill Password are different. Please fill in the same Mill Password and Confirm Mill Password. </div>\r\n");
			return new ModelAndView(new RedirectView("millRegisteration.obj"));
		} else if (millNotRegistered == true) {
			redirectAttributes.addFlashAttribute("msg",
					"<div class=\"alert alert-warning\"><b>OOps!</b> Mill Already Registered.Please Select another Mill Name.</div>\r\n");
			return new ModelAndView(new RedirectView("millRegisteration.obj"));
		} else {
			// Redirect with duplicate email message
			redirectAttributes.addFlashAttribute("msg",
					"<div class=\"alert alert-warning\"><b>OOps!</b> Duplicate email id Can't Submit Please fill Form with another email.</div>\r\n");
			return new ModelAndView(new RedirectView("millRegisteration.obj"));
		}
		// return new ModelAndView(new RedirectView("viewmillRegistration.obj"));

	}

	@RequestMapping("viewmillRegistration")

	public ModelAndView ViewmillRegistration(Model model, HttpServletRequest request) {
		ModelAndView mv = new ModelAndView("viewMillRegistration");
		String username = (String) request.getSession().getAttribute("usrname");
		if (username == null) {

			mv = new ModelAndView("index");

		}

		List<MillRegistrationModel> AllList = (List<MillRegistrationModel>) millRegistrationService.getAll();

		Collections.reverse(AllList);

		model.addAttribute("AllList", AllList);
		// int MillRegistrationId =
		// Integer.parseInt(request.getParameter("MillRegistration_id"));

		// return "viewMillRegistration";
		return mv;

	}

	@RequestMapping({ "updateMillRegistration" })
	public ModelAndView updateMillRegistration(HttpServletRequest request, RedirectAttributes redirectAttributes)
			throws NumberFormatException, Exception {
		String username = (String) request.getSession().getAttribute("usrname");
		ModelAndView mv = new ModelAndView();
		if (username == null) {
			mv = new ModelAndView("index");
		}
		int MillRegistrationId = Integer.parseInt(request.getParameter("id"));

		millRegistrationService.ResetPassword(MillRegistrationId);

		redirectAttributes.addFlashAttribute("msg",
				(Object) "<div class=\"alert alert-success\"><b>Success !</b> Password has been Reset.</div>\r\n");
		return new ModelAndView(new RedirectView("viewmillRegistration.obj"));
	}

	///////////////////////////////////////// mill registration end
	///////////////////////////////////////// //////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////// mill login start ////////////////////////////////////////////////////////////////////////////////////////////
	@RequestMapping("millLogin")
	public ModelAndView login(HttpServletRequest request) {
		HttpSession session = request.getSession();
		session.invalidate();

		ModelAndView mv = new ModelAndView("millLogin");
		return mv;
	}

	@RequestMapping("millloginAction")
	public ModelAndView loginDetailsCheck1(HttpServletRequest request, RedirectAttributes redirectAttributes,
			HttpSession session) {
		ModelAndView mv = new ModelAndView("millLogin");

		try {
			String email = request.getParameter("email");
			String password = request.getParameter("password");

			if (email != null && password != null) {
				String ifExist = millRegistrationService.checkLogin(email, password);
				String millcode = millRegistrationService.checkmillcode(email);
				String useremail = millRegistrationService.checkmillemail(email);

				if (ifExist == null) {
					mv.addObject("msg",
							"<div class=\"alert alert-danger\"><b>Failure !</b>Please Enter correct username and password.</div> \r\n");
				} else {
					// session.setAttribute("email", email);
					session.setAttribute("millcode", millcode);
					session.setAttribute("useremail", useremail);
					mv = new ModelAndView(new RedirectView("viewmillAcc.obj"));

				}
			}

		} catch (Exception e) {
			System.out.println(e);
		}
		return mv;
	}

///////////////////////////////////// mill login end ////////////////////////////////////////////////////////////////////////////////////////////

//////////////////////////////////////Privacy policy page start ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	@RequestMapping("privacypolicy")
	public ModelAndView privacy_policy(HttpServletRequest request) {

		String username = (String) request.getSession().getAttribute("usrname");

		ModelAndView mv = new ModelAndView("privacy_policy");

		if (username == null) {

			mv = new ModelAndView("index");

		}

		return mv;
	}
////////////////////////////////////////////////////privacy policy page end /////////////////////////////////////////////////////////////////////////////////////////////////////////////////

//////////////////////////////////////////////////////////////cash against dispatch document /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////		

//	            @RequestMapping({ "viewCash_against_Dispatch_document" })
//				public ModelAndView DispatchDocument(final HttpServletRequest request) {
//				String username = (String) request.getSession().getAttribute("usrname");
//				ModelAndView mv = new ModelAndView("View_CAD_Document");
//				if (username == null) {
//				mv = new ModelAndView("index");
//				}
//				
//				
//				final List<CashDocumentModel> allUserRegistration = (List<CashDocumentModel>)
//				this.genrationCashDocumentService.getAll();
//				List<Object[]> fetchMill_Name = this.genrationCashDocumentService.fetchMill_Name();
//				mv.addObject("fetchMill_Name", fetchMill_Name);
//				mv.addObject("genrationcashDocument", allUserRegistration);
//				
//				
//				return mv;
//				}

	@RequestMapping({ "viewCash_against_Dispatch_document" })
	public ModelAndView viewCash_against_Dispatch_document(final HttpServletRequest request) {
		String username = (String) request.getSession().getAttribute("usrname");
		ModelAndView mv = new ModelAndView("View_CAD_Document");
		if (username == null) {
			mv = new ModelAndView("index");
		}

		List<Object[]> fetchMill_Name = this.genrationCashDocumentService.fetchMill_Name();
		System.err.println();

		final List<CashDocumentModel> allUserRegistration = (List<CashDocumentModel>) this.genrationCashDocumentService
				.getAll();
		mv.addObject("genrationcashDocument", allUserRegistration);
		mv.addObject("fetchMill_Name", fetchMill_Name);

		return mv;
	}

	@ResponseBody
	@RequestMapping(value = "listofbillofsupplyNonLC", method = RequestMethod.GET)
	public String listofbillofsupply1(@RequestParam("contractno") String contractno) {

		List<Object[]> millRecieptModelt1 = generationOfCashAgainstDispatchDocumentService
				.listdetailsbillofsuppllycash(contractno);
		// System.err.println("resultList++++++++++" + millRecieptModelt1);
		Gson gson = new Gson();
		String resultString = new Gson().toJson(millRecieptModelt1);
		return resultString;
	}

	@ResponseBody
	@RequestMapping(value = "balanceAmount", method = RequestMethod.GET)
	public String listbalanceAmount(@RequestParam("contractno") String contractno) {

		String balanceAmount = generationOfCashAgainstDispatchDocumentService.listbalanceAmount(contractno);
		return balanceAmount;
	}

	@ResponseBody
	@RequestMapping(value = "contrcatforCahAginstDispatchDocument", method = RequestMethod.GET)
	public String millvisecontrcatforaginst(@RequestParam("millname") String millname) {
		List<Object> Mill_NameR = generationOfCashAgainstDispatchDocumentService.contractonmill1(millname);
		// System.err.println("resultList++++++++++" + Mill_NameR);
		Gson gson = new Gson();
		String resultString = new Gson().toJson(Mill_NameR);
		return resultString;
	}

	@Value("${upload.BOENONLCJasperReport}")
	String BOENONLCJasperReport;
	@Value("${upload.BOENONLCDownload}")
	String BOENONLCDownload;

	@RequestMapping("downloadBillOfExchangeDocument")
	public void downloadboedocument(@RequestParam("filename") String filename, HttpServletResponse response)
			throws JRException {
		List<boenonlcDTO> pdfBOENONLC = generationOfCashAgainstDispatchDocumentService.getBOENONLC(filename);

		String sumofBos = "";
		double totalinvoiceamount = 0.0;
		String bosDate = "";

		for (boenonlcDTO pdfBOENONLC1 : pdfBOENONLC) {
			sumofBos += pdfBOENONLC1.getBos_no();

			if (pdfBOENONLC.indexOf(pdfBOENONLC1) < pdfBOENONLC.size() - 1) {
				sumofBos += ",";
			}

			totalinvoiceamount += Double.valueOf(pdfBOENONLC1.getInvoiceValue());

			pdfBOENONLC1.setAllBos(sumofBos);
			pdfBOENONLC1.setSumInvoice(totalinvoiceamount);

		}

		// Now get the values from the last element in the list
		boenonlcDTO lastBOENONLC = pdfBOENONLC.get(pdfBOENONLC.size() - 1);
		String lastAllBos = lastBOENONLC.getAllBos();
		double lastSumInvoice = lastBOENONLC.getSumInvoice();
		boenonlcDTO firstBOENONLC = pdfBOENONLC.get(0);
		firstBOENONLC.setAllBos(lastAllBos);
		firstBOENONLC.setSumInvoice(lastSumInvoice);
		String subject = "Submission of our Bill of Supply bearing No." + " " + sumofBos + " " + "dt "
				+ firstBOENONLC.getBos_date() + " " + "Amounting to " + totalinvoiceamount + " "
				+ "under CAD/Direct Cash/Pay Order.";
		firstBOENONLC.setSubject(subject);
		// Display the last allBos and sumInvoice

		// System.err.println("pdfBOENONLC " + pdfBOENONLC);

		// System.out.println("Last SumInvoice: " + lastSumInvoice);

//					JasperReport jasperReportboe = JasperCompileManager.compileReport("C:\\Users\\Mansi.Gupta\\Documents\\mspcodemerge_1july\\JCI-CMS\\BOENONLC.jrxml");
		JasperReport jasperReportboe = JasperCompileManager.compileReport(BOENONLCJasperReport);
		Map<String, Object> parametersboe = new HashMap<String, Object>();
		// Prepare data sources
		JRBeanCollectionDataSource dataSourceboe = new JRBeanCollectionDataSource(pdfBOENONLC);

		// Fill JasperPrints
		JasperPrint jasperPrintboe = JasperFillManager.fillReport(jasperReportboe, parametersboe, dataSourceboe);

		// Set response content type

		response.setContentType("application/pdf");

		// Set filename

		String fileNameboe = "BOE" + filename + ".pdf";

		// Set content disposition to attachment to trigger download
		response.setHeader("Content-Disposition", "attachment; filename=" + fileNameboe);

		try (OutputStream outboe = response.getOutputStream()) {
			// Export report to PDF
			JRPdfExporter exporterboe = new JRPdfExporter();
			exporterboe.setParameter(JRPdfExporterParameter.JASPER_PRINT, jasperPrintboe);
			exporterboe.setParameter(JRPdfExporterParameter.OUTPUT_STREAM, outboe);
			exporterboe.exportReport();
		} catch (Exception e) {
			e.printStackTrace(); // Handle exception
		}

		// Save PDF to a specific path on the server
		try {
//					String filePath1 = "C:\\Users\\Mansi.Gupta\\Documents\\filesave" + fileNameboe; // Modify the path accordingly
			String filePath1 = BOENONLCDownload + fileNameboe;
			FileOutputStream outputStreamboe = new FileOutputStream(filePath1);
			JasperExportManager.exportReportToPdfStream(jasperPrintboe, outputStreamboe);
			outputStreamboe.close();
			System.out.println("PDF saved at: " + filePath1);
		} catch (Exception e) {
			e.printStackTrace(); // Handle exception
		}

	}

	@Value("${upload.TopSheetNONLCJasperReport}")
	String TopSheetNONLCJasperReport;
	@Value("${upload.TopSheetNONLCDownload}")
	String TopSheetNONLCDownload;

	@RequestMapping("downloadTopSheet")
	public void downloadTopSheet(@RequestParam("filename") String filename, HttpServletResponse response)
			throws JRException {
		List<TopSheetDto> pdfTopSheet = generationOfCashAgainstDispatchDocumentService
				.getTopSheetDatacashAgainstDispatchDocument(filename);

		double totalQuantity = 0.0;
		double totalAmount = 0.0;

		for (TopSheetDto TopSheet1 : pdfTopSheet) {
//							totalQuantity  += Double.valueOf(TopSheet1.getQuantity());
			totalAmount += Double.valueOf(TopSheet1.getInvoiceValue());
//							TopSheet1.setTotalQuantity(totalQuantity);
			TopSheet1.setTotalAmount(totalAmount);
		}
		Double totalQty = 0.0;
		for (TopSheetDto TopSheet2 : pdfTopSheet) {
			String challan = TopSheet2.getChallan_no();
			// System.err.println(challan + "challan");
			String nominal_qty = generationOfCashAgainstDispatchDocumentService.getNominalWt(challan);

			// System.err.println(nominal_qty + "nominal_qty");
			totalQty += Double.valueOf(nominal_qty);

			TopSheet2.setTotalQuantity(totalQty);
			TopSheet2.setQuantity(nominal_qty);

			Date instrumentDate = generationOfCashAgainstDispatchDocumentService
					.getInstrumentDate(TopSheet2.getFullContractNumber());
			// System.err.println( instrumentDate + "instrumentDate instrumentDate" +
			// TopSheet2.getFullContractNumber());
			SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
			String formattedDate = sdf.format(instrumentDate);
			TopSheet2.setInstrument_Date(formattedDate);
			// TopSheet2.setInstrument_Date(instrumentDate);

		}

		// System.err.println("r"+pdfTopSheet);

		JasperReport jasperReport1 = JasperCompileManager.compileReport(TopSheetNONLCJasperReport);
		Map<String, Object> parameters = new HashMap<String, Object>();
		// Prepare data sources
		JRBeanCollectionDataSource dataSource1 = new JRBeanCollectionDataSource(pdfTopSheet);

		// Fill JasperPrints
		JasperPrint jasperPrint1 = JasperFillManager.fillReport(jasperReport1, parameters, dataSource1);

		// Set response content type

		response.setContentType("application/pdf");

		// Set filename

		String fileName = "TopSheet" + filename + ".pdf";

		// Set content disposition to attachment to trigger download
		response.setHeader("Content-Disposition", "attachment; filename=" + fileName);

		try (OutputStream out = response.getOutputStream()) {
			// Export report to PDF
			JRPdfExporter exporter = new JRPdfExporter();
			exporter.setParameter(JRPdfExporterParameter.JASPER_PRINT, jasperPrint1);
			exporter.setParameter(JRPdfExporterParameter.OUTPUT_STREAM, out);
			exporter.exportReport();
		} catch (Exception e) {
			e.printStackTrace(); // Handle exception
		}

		// Save PDF to a specific path on the server
		try {
			String filePath = TopSheetNONLCDownload + fileName; // Modify the path accordingly
			FileOutputStream outputStream = new FileOutputStream(filePath);
			JasperExportManager.exportReportToPdfStream(jasperPrint1, outputStream);
			outputStream.close();
			// System.out.println("PDF saved at: " + filePath);
		} catch (Exception e) {
			e.printStackTrace(); // Handle exception
		}

	}

	@RequestMapping("viewtopSheet")
	public ModelAndView ViewTopSheet(Model model, HttpServletRequest request) {
		ModelAndView mv = new ModelAndView("viewCashAgainstDispatchDocument");
		String username = (String) request.getSession().getAttribute("usrname");

		if (username == null) {
			mv = new ModelAndView("index");
		}
		List<TopsheetDetailsModel> AllList = (List<TopsheetDetailsModel>) generationOfCashAgainstDispatchDocumentService
				.getAlltopsheetdata();
		// Collections.reverse(AllList);
		model.addAttribute("topsheetdata", AllList);

		return mv;
	}

	@RequestMapping(value = "billOfSupplyDetails", method = RequestMethod.GET)
	public ModelAndView billOfSupplyDetails(HttpServletRequest request, Model model) {
		String username = (String) request.getSession().getAttribute("usrname");
		ModelAndView mv = new ModelAndView("cadDetails");
		if (username == null) {
			mv = new ModelAndView("index");
		}

		String topSheetId = request.getParameter("id");
		List<TopsheetDetailsModel> AllList = (List<TopsheetDetailsModel>) generationOfCashAgainstDispatchDocumentService
				.getAlldetails(topSheetId);
		model.addAttribute("topSheetDetails", AllList);
		return mv;
	}

	@RequestMapping("savecashAgainstDispatchDocument")
	public ModelAndView savecashAgainstDispatchDocument(final HttpServletRequest request, HttpServletResponse response)
			throws JRException {
		String username = (String) request.getSession().getAttribute("usrname");
		ModelAndView mv = new ModelAndView("viewGenerationAgainstLCs");
		if (username == null) {
			mv = new ModelAndView("index");
		}

		String millcode1 = request.getParameter("millname65");
		String contractNo = request.getParameter("fullcontractno");
		String topSheet = request.getParameter("Topsheet");
		String billofExchange = request.getParameter("BillofExchange");

		int rows = Integer.parseInt(request.getParameter("rows"));
		String[] bosNo = request.getParameterValues("bosNo1[]");
		String[] bosDate = request.getParameterValues("bosDate1[]");
		String[] invoiceValue = request.getParameterValues("invoiceValue1[]");
		String[] challan = request.getParameterValues("challan[]");
		String[] millcode = request.getParameterValues("millcode[]");
		String[] milll_name = request.getParameterValues("unit_name[]");
		String[] mill_address = request.getParameterValues("unit_address1[]");
		String[] Contract_identification_no = request.getParameterValues("Contract_identification_no[]");
		String[] Contract_no = request.getParameterValues("Contract_no[]");
		String[] Contract_date = request.getParameterValues("Contract_date[]");
		String[] CropYear = request.getParameterValues("CropYear[]");
		String[] hodiNo = request.getParameterValues("hodiNo[]");
		String[] hodiDate = request.getParameterValues("hodiDate[]");
		String balance = request.getParameter("balanceAmount");

		LocalDate currentDate = LocalDate.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		String formattedDate = currentDate.format(formatter);
		Calendar calendar = Calendar.getInstance();
		int currentYear = calendar.get(Calendar.YEAR);
		int currentMonth = calendar.get(Calendar.MONTH) + 1; // Calendar.MONTH is zero-based

		int financialYearStart, financialYearEnd;

		if (currentMonth >= 4) { // April or later
			financialYearStart = currentYear;
			financialYearEnd = currentYear + 1;
		} else { // January to March
			financialYearStart = currentYear - 1;
			financialYearEnd = currentYear;
		}
		String startYearLastTwoDigits = Integer.toString(financialYearStart).substring(2);
		String endYearLastTwoDigits = Integer.toString(financialYearEnd).substring(2);

		String yearCode = endYearLastTwoDigits;
//				    String  financialYearCurrent = startYearLastTwoDigits + endYearLastTwoDigits;
		String financialYearCurrent = endYearLastTwoDigits;
		String status = String.format("%06d",
				Integer.parseInt(this.generationOfCashAgainstDispatchDocumentService.topSheetId()));

		String topSheetGeneratedId = "NL" + financialYearCurrent + status;
		// System.err.println(topSheetGeneratedId);

		Double amount = 0.0;
		for (int i = 0; i < rows; i++) {

			String check = request.getParameter("rowCheckbox" + i);
			if (check != null) {
				amount += Double.valueOf(invoiceValue[i]);

			}
		}
		String totalamount = String.valueOf(amount);
		Double balance1 = Double.valueOf(balance) - amount;
		String totalBalance = String.valueOf(balance1);
		System.err.println(totalBalance + " totalBalance");
		System.err.println(amount + " amount");
		System.err.println(totalamount + " totalamount");

		for (int i = 0; i < rows; i++) {

			String check = request.getParameter("rowCheckbox" + i);
			if (check != null) {
				System.err.println(bosNo[i] + "bossnumber" + challan[i]);
				TopsheetDetailsModel topsheetDetailsModel = new TopsheetDetailsModel();
				topsheetDetailsModel.setTopsheet_generated_id(topSheetGeneratedId);
				topsheetDetailsModel.setTopSheetCreateDate(formattedDate);
				// topsheetDetailsModel.setAmount(check);
				topsheetDetailsModel.setBillOfSupplyNo(bosNo[i]);
				topsheetDetailsModel.setBosDate(bosDate[i]);
				topsheetDetailsModel.setInvoiceValue(invoiceValue[i]);
				topsheetDetailsModel.setContract_no(contractNo);
				topsheetDetailsModel.setContract_identification_no(Contract_identification_no[i]);
				topsheetDetailsModel.setContract_date(Contract_date[i]);
				topsheetDetailsModel.setCropYear(CropYear[i]);
				topsheetDetailsModel.setMillcode(millcode1);
				topsheetDetailsModel.setMillname(milll_name[i]);
				topsheetDetailsModel.setMilladdress(mill_address[i]);
				topsheetDetailsModel.setAmount(totalamount);
				topsheetDetailsModel.setHodiNo(hodiNo[i]);
				topsheetDetailsModel.setHodiDate(hodiDate[i]);
				topsheetDetailsModel.setBalanceAmount(totalBalance);
				;
				generationOfCashAgainstDispatchDocumentService.create(topsheetDetailsModel);

			}

		}

		return new ModelAndView(new RedirectView("viewtopSheet.obj"));
		// return viewtopSheet;

	}

	@ResponseBody
	@RequestMapping(value = "listOfTopSheetDetails", method = RequestMethod.GET)
	public String listOfTopSheetDetails(@RequestParam("contractno") String contractno) {

		List<Object[]> millRecieptModelt1 = generationOfCashAgainstDispatchDocumentService.listOfTopSheetDetails();
		System.err.println("resultList++++++++++" + millRecieptModelt1);
		Gson gson = new Gson();
		String resultString = new Gson().toJson(millRecieptModelt1);
		return resultString;
	}

	@ResponseBody
	@RequestMapping(value = "listofpaymentdetails1", method = RequestMethod.GET)
	public String listofpaymentdetails1(@RequestParam("contractno") String contractno) {

		List<Object[]> millRecieptModelt1 = generationOfCashAgainstDispatchDocumentService
				.listdetailsofpaymemt1(contractno);
		System.err.println("resultList++++++++++" + millRecieptModelt1);
		Gson gson = new Gson();
		String resultString = new Gson().toJson(millRecieptModelt1);
		return resultString;
	}

	@Value("${upload.paymentDocumentDownload}")
	String paymentDocumentDownload;

	@RequestMapping("downloadSupportingDocumentenPaymentArrangement")
	public void downloadDocumentpayment1(@RequestParam("filename") String filename, HttpServletResponse response) {

		String imagePath = paymentDocumentDownload + File.separator + filename;
//							imageDirectory + File.separator + idn + File.separator + filename;

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

	private String determineContentType8(String filename) {

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


	@RequestMapping("downloadSupportingDocumententContract")
	public void downloadDocumentcashAagainstDispatchDocumentContract(@RequestParam("filename") String filename,
			HttpServletResponse response) {

//					String imageDirectory = millAcceptDownolad; // directory path
//					String idn = filename.split("C")[0];
		String imagePath = authorizedContracts + File.separator + filename;
//							imageDirectory + File.separator + idn + File.separator + filename;

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

//////////////////////////////////////////////////////////// cash against dispatch document end//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

//	
	@ResponseBody
	@RequestMapping(value = { "fetchChallan" }, method = { RequestMethod.GET })
	public String fetchClaim(@RequestParam("id") String id, HttpServletRequest request, HttpSession session) {
		System.err.println("Reached challan");
		String username = (String) request.getSession().getAttribute("usrname");
		List<Object[]> list = confirmationofClaimSettlementService.fetchChallan(id);
		Gson gson = new Gson();
		String resultString = new Gson().toJson(list);
		System.err.println("-----------------------" + list);
		return resultString;

	}

	@ResponseBody
	@RequestMapping(value = { "fetchPrice" }, method = { RequestMethod.GET })
	public String fetchPrice(@RequestParam("variety") String var, @RequestParam("grade") String gr,
			@RequestParam("contract") String Contract, @RequestParam("challan") String Challan,
			HttpServletRequest request, HttpSession session) {
		System.err.println("Reached Price" + gr + "var" + var);
		System.err.println(var + "0000000000000" + gr);
		char lastChar = gr.charAt(gr.length() - 1); // Extract the last character
		int gradeNumber = Character.getNumericValue(lastChar); // Convert the character to an integer
		gradeNumber++; // Increment the integer by 1
		String grade = "grade" + gradeNumber; // Concatenate with "grade_"

		String username = (String) request.getSession().getAttribute("usrname");
		/* String dpcId = (String) request.getSession().getAttribute("dpcId"); */

		String cropyear = (String) request.getSession().getAttribute("currCropYear");
		System.err.println(Challan + "-" + cropyear + "--" + var + "--" + grade + "--" + Contract);
		String priceString = confirmationofClaimSettlementService.fetchPrice(var, grade, Challan, cropyear, Contract);
//         verifyClaimService.rejectClaim(id, username);
		Gson gson = new Gson();
		String resultString = new Gson().toJson(priceString);
		System.err.println("----------------" + resultString);
		return resultString;

	}

	@RequestMapping({ "WeightmentSlipList" })
	public ModelAndView WeightmentSlipList(HttpSession session, HttpServletRequest request) {
		String username = (String) request.getSession().getAttribute("usrname");
		if (username == null) {
			return new ModelAndView("index");
		}
		String Ro_id = (String) session.getAttribute("region");
		List<Object[]> list = weighmentEntryService.WeightmentSlipList(Ro_id);

		ModelAndView mv = new ModelAndView("WeightmentSlipList");
		mv.addObject("WeightmentList", list);
		System.err.println(list.toString());
		return mv;
	}

	@RequestMapping(value = { "WeightmentById" }, method = RequestMethod.GET)
	public ModelAndView ListOFWeightmentSlipById(HttpServletRequest request) {
		String username = (String) request.getSession().getAttribute("usrname");
		if (username == null) {
			return new ModelAndView("index");
		}
		String id = request.getParameter("id");
		System.err.println(id);
		System.err.println(id);
		System.err.println(id);
		ModelAndView mv = new ModelAndView("VerificationOfWeightment");
		List<Object[]> list = weighmentEntryService.getSlipDetails(id);
		mv.addObject("Data", list);
		/*
		 * jciWeighmentEntry list =
		 * weighmentEntryService.ListOFWeightmentSlipById(Weighment_id);
		 */

		/*
		 * if(list!=null) { return new ServiceResponse<>(new
		 * BaseMessageResponse<>(HttpStatus.OK.value(), list, "true", "Success"),
		 * HttpStatus.OK);}else { return new ServiceResponse<>(new
		 * BaseMessageResponse<>(HttpStatus.NOT_FOUND.value(), list, "false",
		 * "No Data Found"), HttpStatus.NOT_FOUND); }
		 */
		return mv;
	}

	@RequestMapping(value = { "verifyWeightmentSlip" }, method = RequestMethod.POST)
	public ModelAndView saveWeightmentSlip(@ModelAttribute jciWeighmentEntry weighmentSlip, HttpServletRequest request,
			HttpSession session) {
		String username = (String) request.getSession().getAttribute("usrname");
		if (username == null) {
			return new ModelAndView("index");
		}
		System.err.println(weighmentSlip);
		try {
			Date currDate = new Date();

			String BosNo = request.getParameter("billNo");
			Double gross = Double.parseDouble(request.getParameter("DPCGrossWt"));
			Double actual = Double.parseDouble(request.getParameter("DPCqty"));
			Double net = Double.parseDouble(request.getParameter("DPCNetqty"));

			weighmentEntryService.editVerification(gross, actual, net, currDate, BosNo);

		} catch (Exception e) {
			// Handle IO exception

		}
		String Ro_id = (String) session.getAttribute("region");
		List<Object[]> list = weighmentEntryService.WeightmentSlipList(Ro_id);

		ModelAndView model = new ModelAndView("WeightmentSlipList");
		model.addObject("WeightmentList", list);
		return model;
	}

	@Value("${upload.ConfirmationsettlementFA}")
	String ConfirmationOfClaimFA;

	@ResponseBody
	@RequestMapping(value = { "acceptClaim" }, method = { RequestMethod.POST })
	public String acceptClaim(@RequestParam("settleId") String settleId,
			@RequestParam("file") MultipartFile SupportingDocument, HttpServletRequest request, HttpSession session) {
		System.err.println(":Reached Accept");
		String username = (String) request.getSession().getAttribute("usrname");
		System.err.println("File" + SupportingDocument.getOriginalFilename());
		final File theDir = new File("Confirmationsettlement");
		if (!theDir.exists()) {
			theDir.mkdirs();
		}
		File file = null;
		String url = "";
		String pathurl = "";
		if (!SupportingDocument.isEmpty()) {
			try {
				file = new File(ConfirmationOfClaimFA + SupportingDocument.getOriginalFilename());
				final OutputStream os = new FileOutputStream(file);
				os.write(SupportingDocument.getBytes());
				os.close();
			} catch (Exception e) {
				System.err.println(e.getLocalizedMessage());
				e.printStackTrace();
				System.err.println("inside catch file----");
			}
			pathurl = file.getAbsolutePath();
			final String path = url = SupportingDocument.getOriginalFilename();

			System.err.println("outside catch file----");

		}
		this.confirmationofClaimSettlementService.acceptClaim(settleId, username,
				SupportingDocument.getOriginalFilename());
		return null;
	}

	@ResponseBody
	@RequestMapping(value = { "rejectClaim" }, method = { RequestMethod.POST })
	public String rejectClaim(@RequestParam("settleId") String settleId, HttpServletRequest request,
			HttpSession session) {
		System.err.println(":Reached Rejecr");
		String username = (String) request.getSession().getAttribute("usrname");
		this.confirmationofClaimSettlementService.rejectClaim(settleId, username);
		return null;
	}

	@RequestMapping(value = { "verifyClaimReport" }, method = RequestMethod.GET)
	public ModelAndView VerifyClaimReport(HttpSession session, HttpServletRequest request,
			RedirectAttributes redirectAttributes) {
		String username = (String) request.getSession().getAttribute("usrname");
		if (username == null) {
			return new ModelAndView("index");
		}

		List<Object[]> getSettlementidlist = this.confirmationofClaimSettlementService.getSettlementData(username);
		System.err.println(getSettlementidlist);
		redirectAttributes.addFlashAttribute("msg",
				"<div class=\"alert alert-success\"><b>Success !</b> Record saved successfully.</div>\r\n" + "");
		ModelAndView mv = new ModelAndView("verifyClaimReport");
		mv.addObject("getSettlementidlist", getSettlementidlist);

		return mv;
	}

	@ResponseBody
	@RequestMapping(value = { "settlementFA" }, method = RequestMethod.GET)
	public String settlementFA(HttpSession session, HttpServletRequest request, @RequestParam("setId") String setId) {
		String username = (String) request.getSession().getAttribute("usrname");
		System.err.println("Reached++" + setId);
		List<Object[]> setIdData = confirmationofClaimSettlementService.getFAData(setId);
		System.err.println(setIdData.toString());
		Gson gson = new Gson();
		String resultString = new Gson().toJson(setIdData);
		System.err.println("-----------------------" + setIdData);
		return resultString;
	}

	@RequestMapping(value = { "verifyMillClaim" }, method = RequestMethod.GET)
	public ModelAndView verifyMillClaim(HttpSession session, HttpServletRequest request,
			RedirectAttributes redirectAttributes) {

		// String Ro_id = (String) session.getAttribute("region");
		List<Object[]> getContractList = this.confirmationofClaimSettlementService.getContract();
		List<Object[]> getSettlementidlist = this.confirmationofClaimSettlementService.getSettlementDataMill();// Settlement
																												// Id
		System.err.println(getContractList);
		redirectAttributes.addFlashAttribute("msg",
				"<div class=\"alert alert-success\"><b>Success !</b> Record saved successfully.</div>\r\n" + "");
		ModelAndView mv = new ModelAndView("verifyMillClaim");
		mv.addObject("getSettlementidlist", getContractList);

		return mv;
	}

	@ResponseBody
	@RequestMapping(value = { "settlementMill" }, method = RequestMethod.GET)
	public String settlementMill(HttpSession session, HttpServletRequest request, @RequestParam("setId") String setId) {
		System.err.println("ReachedMillClaim");
		System.err.println("Reached++" + setId);

		List<Object[]> setIdData = confirmationofClaimSettlementService.getMillData(setId);
		System.err.println(setIdData.toString());
		Gson gson = new Gson();
		String resultString = new Gson().toJson(setIdData);
		System.err.println("-----------------------" + setIdData);
		return resultString;
	}

	@RequestMapping("downloadSupportDocumentFA")
	public void downloadDocsFA(@RequestParam("filename") String filename, HttpServletResponse response) {
		String imagePath = ConfirmationOfClaimFA + filename;
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
				try (FileInputStream fileInputStream = new FileInputStream(imageFile);
						OutputStream responseOutputStream = response.getOutputStream()) {
					byte[] buffer = new byte[1024];
					int bytesRead;
					while ((bytesRead = fileInputStream.read(buffer)) != -1) {
						responseOutputStream.write(buffer, 0, bytesRead);
					}
				}
			} catch (IOException e) {
				// Handle IO exception
				e.printStackTrace();
				response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
			}
		} else {
			response.setStatus(HttpServletResponse.SC_NOT_FOUND);
		}
	}

	@ResponseBody
	@RequestMapping(value = { "acceptClaimMill" }, method = { RequestMethod.GET })
	public String acceptClaimMill(@RequestParam("settleId") String settleId, HttpServletRequest request,
			HttpSession session) {
		System.err.println(":Reached Accept Mill");

		this.confirmationofClaimSettlementService.acceptClaimMill(settleId);
		return null;
	}

	@ResponseBody
	@RequestMapping(value = { "GetSettlementId" }, method = { RequestMethod.GET })
	public String SettlementByContract(@RequestParam("Contract") String contract, HttpServletRequest request,
			HttpSession session) {
		System.err.println(":Reached Accept Mill");

		List<Object[]> list = this.confirmationofClaimSettlementService.getSettlementId(contract);
		Gson gson = new Gson();
		String resultString = new Gson().toJson(list);
		System.err.println("-----------------------" + list);
		return resultString;
	}


	
///////////////////////////////////////////////// Settlement Of Credit and Debit notes //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// ---------------------------------------------------------

// settlement page listing
				@RequestMapping("settlementcndn")
				public ModelAndView settlementcndn(HttpServletRequest request) {
				String username = (String) request.getSession().getAttribute("usrname");
				if (username == null) {
				return new ModelAndView("index");
				}
				
				List<String> millsOfContract = creditNoteGenerationService.getMillNames();
				ModelAndView mView = new ModelAndView("settlementCnDnPage");
				
				mView.addObject("mills", millsOfContract);
				
				return mView;
				}
				
				@ResponseBody
				@RequestMapping(value = { "selectContractForSettlement" }, method = { RequestMethod.GET })
				public String selectContractForSettlement(final HttpServletRequest request) {
				final String mill = request.getParameter("mill");
				List<String> contractNos = creditNoteGenerationService.getAllContractNos(mill);
				
				Gson gson = new Gson();
				
				return gson.toJson(contractNos);
				}
				
				@ResponseBody
				@RequestMapping(value = { "getFullDetailsOfCrnAndDebit" }, method = { RequestMethod.GET })
				public String getFullDetailsOfCrnAndDebit(final HttpServletRequest request) {
				final String contract = request.getParameter("contractNo");
				List<Object[]> contractNos = creditNoteGenerationService.getFullDetailsOfCrnAndDebit(contract);
				
				Gson gson = new Gson();
				
				return gson.toJson(contractNos);
				}
				
				// redirected page of the settlement form
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
				
				
				@Value("${upload.cndnuploadxl}")
				String cndnuploadxl;
				@RequestMapping("saveCnAndDn")
				public ModelAndView finalSettlement(HttpServletRequest request) {
				String username = (String) request.getSession().getAttribute("usrname");
				
				if (username == null) {
				return new ModelAndView("index");
				}
				
				String mill = request.getParameter("mill");
				String contract = request.getParameter("contract");
				int rows = Integer.parseInt(request.getParameter("rows"));
				String[] creditNoteNo = request.getParameterValues("creditNoteNo[]");
				String[] DateOfIssue  = request.getParameterValues("DateOfIssue[]");
				String[] Hodi = request.getParameterValues("Hodi[]");
				String[] consigneeNoteText = request.getParameterValues("consigneeNoteText[]");
				String[] bosNo  = request.getParameterValues("bosNo[]");
				String[] dateOfShipment = request.getParameterValues("dateOfShipment[]");
				String[] dateOfInspection = request.getParameterValues("dateOfInspection[]");
				String[] creditNoteAmount = request.getParameterValues("creditNoteAmount[]");
				String[] settlementId = request.getParameterValues("settlementId[]");
				String[] consigneeDoc = request.getParameterValues("consigneeDoc[]");
				String[] BosDoc = request.getParameterValues("BosDoc[]");
				String[] creditNoteDoc = request.getParameterValues("creditNoteDoc[]");
				
				
				
				String total = creditNoteGenerationService.CountRecord();
				int value1;
				if (total != null) {
				
				
				value1 =Integer.valueOf(total)+1;
				} else {
				value1 = 1;
				
				}
				//System.err.println(value1 + "rrrrrrrrrrrr");
				String UniqueIdentification = contract + "/" +String.valueOf(value1);
				
				
				Double creditNoteSum = 0.0;
				Double debitNoteSum = 0.0;
				
				// Calculate sums for credit and debit notes
				for (int i = 0; i < rows; i++) {
				String check = request.getParameter("rowCheckbox" + i);
				if (check != null) {
				String cnDnNo = creditNoteNo[i];
				// Check if the first character of cnDnNo is 'C'
				if (cnDnNo != null && !cnDnNo.isEmpty() && cnDnNo.charAt(0) == 'C') {
				creditNoteSum += Double.valueOf(creditNoteAmount[i]);
				} else {
				debitNoteSum += Double.valueOf(creditNoteAmount[i]);
				}
				}
				}
				
				Double CnAndDnAmountDifference = creditNoteSum - debitNoteSum;
				System.err.println("Credit Note Sum: " + creditNoteSum + " | Debit Note Sum: " + debitNoteSum);
				
				// Get current date in dd-MM-yyyy format
				LocalDate today = LocalDate.now();
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
				String formattedDate = today.format(formatter);
				
				// Create an Excel workbook and sheet
				Workbook workbook = new XSSFWorkbook();
				Sheet sheet = workbook.createSheet("Settlement Data");
				Font headerFont = workbook.createFont();
				headerFont.setBold(true);
				headerFont.setFontHeightInPoints((short)11);
				headerFont.setColor(IndexedColors.BLACK.getIndex());
				CellStyle headerCellStyle = workbook.createCellStyle();
				headerCellStyle.setFont(headerFont);
				
				String filepath =  cndnuploadxl;
				// String filepath = "C:\\Users\\Mansi.Gupta\\Documents\\CNDNExcelSave";
				//     "C:\\Users\\Mansi.Gupta\\Documents";
				//  String filename = filepath +File.separator + UniqueIdentification+"cndn"+ ".xlsx";  // Change path as needed
				
				String filename = filepath +File.separator +String.valueOf(value1) +"cndn"+ ".xlsx"; 
				String filenameSave =  String.valueOf(value1) +"cndn"+ ".xlsx";
				// Define the columns for the Excel sheet
				String[] columns = {"Mill Code", "Contract No", "Credit Note No", "Date Of Issue", "Hodi", "Consignee Note Text",
				"BOS No", "Date Of Shipment", "Date Of Inspection", "Credit Note Amount", "Settlement ID",
				"Consignee Doc", "BOS Doc", "Credit Note Doc", "Create Date", "Amount Difference"};
				Row headerRow = sheet.createRow(0);
				for (int j = 0; j < columns.length; j++) {
				Cell cell = headerRow.createCell(j);
				cell.setCellValue(columns[j]);
				cell.setCellStyle(headerCellStyle);
				}
				
				int rownum = 1;
				for (int i = 0; i < rows; i++) {
				String check = request.getParameter("rowCheckbox" + i);
				if (check != null) {
				settlemetCnDnModel settlemetCnDnModel = new settlemetCnDnModel();
				settlemetCnDnModel.setMillCode(mill);
				settlemetCnDnModel.setContractNo(contract);
				settlemetCnDnModel.setCreditNoteNo(creditNoteNo[i]);
				settlemetCnDnModel.setDateOfIssue(DateOfIssue[i]);
				settlemetCnDnModel.setHodi(Hodi[i]);
				settlemetCnDnModel.setConsigneeNoteText(consigneeNoteText[i]);
				settlemetCnDnModel.setBosNo(bosNo[i]);
				settlemetCnDnModel.setDateOfShipment(dateOfShipment[i]);
				settlemetCnDnModel.setDateOfInspection(dateOfInspection[i]);
				settlemetCnDnModel.setCreditNoteAmount(creditNoteAmount[i]);
				settlemetCnDnModel.setSettlementId(settlementId[i]);
				settlemetCnDnModel.setConsigneeDoc(consigneeDoc[i]);
				settlemetCnDnModel.setBosDoc(BosDoc[i]);
				settlemetCnDnModel.setCreditNoteDoc(creditNoteDoc[i]);
				settlemetCnDnModel.setCreate_date_cndn(formattedDate);
				settlemetCnDnModel.setAmountDiffCnAndDn(CnAndDnAmountDifference);
				settlemetCnDnModel.setCndnExcel_link(filenameSave);
				settlemetCnDnModel.setRowNumber(value1);
				settlemetCnDnModel.setIdentificationCnDn(UniqueIdentification);
				creditNoteGenerationService.saveSettlementOfCnDn(settlemetCnDnModel);
				
				// Add data to the Excel sheet
				Row row = sheet.createRow(rownum++);
				row.createCell(0).setCellValue(mill);
				row.createCell(1).setCellValue(contract);
				row.createCell(2).setCellValue(creditNoteNo[i]);
				row.createCell(3).setCellValue(DateOfIssue[i]);
				row.createCell(4).setCellValue(Hodi[i]);
				row.createCell(5).setCellValue(consigneeNoteText[i]);
				row.createCell(6).setCellValue(bosNo[i]);
				row.createCell(7).setCellValue(dateOfShipment[i]);
				row.createCell(8).setCellValue(dateOfInspection[i]);
				row.createCell(9).setCellValue(creditNoteAmount[i]);
				row.createCell(10).setCellValue(settlementId[i]);
				row.createCell(11).setCellValue(consigneeDoc[i]);
				row.createCell(12).setCellValue(BosDoc[i]);
				row.createCell(13).setCellValue(creditNoteDoc[i]);
				row.createCell(14).setCellValue(formattedDate);
				row.createCell(15).setCellValue(CnAndDnAmountDifference);
				}
				}
				
				// Resize columns to fit the content
				for (int j = 0; j < columns.length; j++) {
				sheet.autoSizeColumn(j);
				}
				
				// Save the Excel file
				//String filename = "C:\\Users\\Mansi.Gupta\\Documents" + "cndn"+ formattedDate + ".xlsx";  // Change path as needed
				try (FileOutputStream fileOut = new FileOutputStream(filename)) {
				workbook.write(fileOut);
				} catch (IOException e) {
				e.printStackTrace();
				} finally {
				try {
				workbook.close();
				} catch (IOException e) {
				e.printStackTrace();
				}
				}
				
				return new ModelAndView(new RedirectView("viewlistCnAndDn.obj"));
				}
				
				
				
				@RequestMapping("viewlistCnAndDn")
				public ModelAndView ViewCnAndDn(Model model, HttpServletRequest request) {
				ModelAndView mv = new ModelAndView("viewCnAndDn");
				String username = (String) request.getSession().getAttribute("usrname");
				
				if (username == null) {
				mv = new ModelAndView("index");
				}
				List<settlemetCnDnModel> AllList = (List<settlemetCnDnModel>) creditNoteGenerationService.getAll();
				// List<Jciclaim_NominationModel> AllList = (List<Jciclaim_NominationModel>)
				// nominalOfficialService.getAll();
				Collections.reverse(AllList);
				model.addAttribute("cnAndDnModel", AllList);
				//String omofficial = request.getParameter("omofficial");
				return mv;
				}
				
	
				@RequestMapping("downloadSupportingbosDoc")
				public void downloadDocumentpayment(@RequestParam("filename") String filename, HttpServletResponse response) {
				//     String imagePath = paymentDocumentDownload;
				String imagePath = billofsupply+ File.separator + filename;
				//imageDirectory + File.separator + idn + File.separator + filename;
				
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
				@Value("${upload.ConsigneeDocDownloadForSettlementOfCNDN}")
				String ConsigneeDocDownloadForSettlementOfCNDN;
				@RequestMapping("downloadSupportingConsigneeDoc")
				public void downloadSupportingConsigneeDoc(@RequestParam("filename") String filename,
				HttpServletResponse response) {
				
				String imagePath = ConsigneeDocDownloadForSettlementOfCNDN + File.separator + filename;
				//imageDirectory + File.separator + idn + File.separator + filename;
				
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
				
				@RequestMapping("downloadSupportingCreditNoteDoc")
				public void downloadSupportingCreditNoteDoc(@RequestParam("filename") String filename,
				HttpServletResponse response) {
				
				String imagePath = creditNoteFilePath + File.separator + filename;
				//imageDirectory + File.separator + idn + File.separator + filename;
				
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
				
				@Value("${upload.cndndownloadxl}")
				String cndndownloadxl;
				@RequestMapping("downloadcndnXsl")
				public void downloadcndnXsl(@RequestParam("filename") String filename, HttpServletResponse response) {
				// Path where files are stored. Use the filename parameter to dynamically
				// specify the file.
				
				// "C:\\Users\\Mansi.Gupta\\Documents";
				// String filename = filepath +File.separator + "cndn"+ ".xlsx";
				// String filePath = "C:\\Users\\Mansi.Gupta\\Documents" ;
				// String fileName = filePath +filename;
				
				//String filepath = "C:\\Users\\Mansi.Gupta\\Documents\\CNDNExcelSave";
				String filepath =      cndndownloadxl;
				String fileName = filepath + File.separator + filename;
				System.err.println(fileName);
				
				// Create a File object
				File file = new File(fileName);
				
				// Check if the file exists
				if (!file.exists()) {
				response.setStatus(HttpServletResponse.SC_NOT_FOUND);
				return;
				}
				
				// Set the content type based on the file extension
				response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
				response.setHeader("Content-Disposition", "attachment; filename=" + fileName);
				response.setContentLength((int) file.length());
				
				// Try-with-resources to ensure that InputStream and OutputStream are closed
				// properly
				try (InputStream inputStream = new FileInputStream(file);
				// Explicit type instead of var for Java 8 or 9
				java.io.OutputStream outputStream = response.getOutputStream()) {
				
				// Read the file and write it to the response output stream
				byte[] buffer = new byte[1024];
				int bytesRead;
				while ((bytesRead = inputStream.read(buffer)) != -1) {
				outputStream.write(buffer, 0, bytesRead);
				}
				
				} catch (IOException e) {
				// Log the exception and set response status code
				e.printStackTrace();
				response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
				}
				}
				@Value("${upload.downloadSupportingDemandNoteDocForCNDN}")
				String downloadSupportingDemandNoteDocForCNDN;
				@RequestMapping("downloadSupportingCreditNoteDocForDN")
				public void downloadSupportingDemandNoteDocForCNDN(@RequestParam("filename") String filename,
				HttpServletResponse response) {
				String imagePath = downloadSupportingDemandNoteDocForCNDN+ File.separator + filename;
				
				//String imagePath = "C:\\Users\\Mansi.Gupta\\Documents\\CreditNoteDOc DownLoad" + File.separator + filename;
				//imageDirectory + File.separator + idn + File.separator + filename;
				
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
//////////////////////////////////////////////////////////Settlement Of Credit and Debit notes End  ///////////////////////////////////////


}

//	  ******************************************>>>>>>>>Code ends here<<<<<<<<<<*********************************************************
//	  ******************************************>>>>>>>>Code ends here<<<<<<<<<<*********************************************************
//	  ******************************************>>>>>>>>Code ends here<<<<<<<<<<*********************************************************
//	  ******************************************>>>>>>>>Code ends here<<<<<<<<<<*********************************************************
