
package com.jci.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Date;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Month;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.print.attribute.standard.DialogOwner;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.itextpdf.io.font.FontConstants;
import com.itextpdf.io.font.PdfEncodings;
import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.kernel.color.Color;
import com.itextpdf.kernel.color.DeviceGray;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.border.Border;
import com.itextpdf.layout.border.SolidBorder;
import com.itextpdf.layout.element.AreaBreak;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.IBlockElement;
import com.itextpdf.layout.element.Image;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Tab;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.element.Text;
import com.itextpdf.layout.property.HorizontalAlignment;
import com.itextpdf.layout.property.TextAlignment;
import com.itextpdf.layout.property.UnitValue;
import com.itextpdf.text.pdf.PdfPTable;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Font;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.BaseFont;
import com.lowagie.text.pdf.GrayColor;
import java.io.FileOutputStream;

import org.springframework.stereotype.Component;
@Component

//		
public class PdfGenerator_K {
	public String generateBillPdf( String  Invoice_Value, String challan_No1, String shipment_Details, String supplier_Name,
			String supplier_GSTN, String supplier_Address, String recipient_Name, String recipient_GSTN,
			String recipient_Address, String consignee_Name, String consignee_GSTN, String consignee_Address,
			String bill_of_Supply, String conract_no,String Clientstate, String Clientcode,String BOS_Date, String ClientPan, List<Object[]> list) throws FileNotFoundException {
		

	
		
//		String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date(0, 0, 0));
//        String fileName = "generatedfile_" + timestamp + ".pdf";
//        
//        String filePath = "C:\\Users\\kailash.shah\\documentimage\\" + fileName;
		
		
		String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date(0));
	     String fileName = "generatedfile_" + timestamp + ".pdf";
//
	     String filePath = "C:\\Users\\kailash.shah\\documentimage\\" + fileName;
			

		     PdfWriter pdfWriter = new PdfWriter(filePath);

		   
		     PdfDocument pdfDocument = new PdfDocument(pdfWriter);       
		
		
 try {
	 
	 
	 

    
   

    
     pdfDocument.setDefaultPageSize(PageSize.A4);

     Document document = new Document(pdfDocument);
		
		
		
		document.setMargins(10, 10, 10, 10);
		
		
		

		addHeader(document, filePath, filePath, filePath);
		//addSubHeading(document);
		//addRefParagraph(document);
		//addMessageParagraph(document, Supplier_GSTN, Supplier_Address);
		//addFirstParagraph(document, billNo, Challan_No1);

		float columnWidth = PageSize.A4.getWidth() * 0.5f;
		float borderWidth = 2.0f; 
		Table contentTable1 = new Table(new float[]{columnWidth, columnWidth});
		Cell cell1199 = createCell("THE JUTE CORPORATION OF INDIA", Border.NO_BORDER, TextAlignment.LEFT);
		contentTable1.addCell(cell1199);

        Cell cell1198 = createCell("Phone +91 (033) 2252 6720 / 7109", Border.NO_BORDER, TextAlignment.RIGHT);
        contentTable1.addCell(cell1198);
      

        Cell cell1197 = createCell("CIN:U17232WB1971GOl027958", Border.NO_BORDER, TextAlignment.LEFT)
                .setPaddingBottom(2f); 
        contentTable1.addCell(cell1197);

        Cell cell1196 = createCell("Email: jci@jcimail.in", Border.NO_BORDER, TextAlignment.RIGHT)
                .setPaddingBottom(2f);
        contentTable1.addCell(cell1196);

        // Row 3
        Cell cell1195 = createCell("15N, Nellie sengupta Sani,", Border.NO_BORDER, TextAlignment.LEFT)
                .setPaddingBottom(2f); 
        contentTable1.addCell(cell1195);

        Cell cell1194 = createCell("FAX: +91(033)2252 1771", Border.NO_BORDER, TextAlignment.RIGHT)
                .setPaddingBottom(2f); 
        contentTable1.addCell(cell1194);

        // Row 4
        Cell cell1193 = createCell("Kolkata - 700 087", Border.NO_BORDER, TextAlignment.LEFT)
                .setPaddingBottom(2f); 
        contentTable1.addCell(cell1193);

        Cell cell1192 = createCell("", Border.NO_BORDER, TextAlignment.RIGHT)
                .setPaddingBottom(2f); 
        contentTable1.addCell(cell1192);

        // Row 5
        Cell cell1191 = createCell("", Border.NO_BORDER, TextAlignment.LEFT)
                .setPaddingBottom(2f); 
        contentTable1.addCell(cell1191);

        Cell cell1190 = createCell("", Border.NO_BORDER, TextAlignment.RIGHT)
                .setPaddingBottom(2f); 
        contentTable1.addCell(cell1190);

        document.add(contentTable1);

        
        Paragraph spacingParagraph = new Paragraph("\n\n").setFixedLeading(10f); 
        document.add(spacingParagraph);
       
        
        PdfFont boldFont = PdfFontFactory.createFont(FontConstants.HELVETICA_BOLD);
        PdfFont normalFont = PdfFontFactory.createFont(FontConstants.HELVETICA);
        
		Table contentTable = new Table(new float[]{columnWidth, columnWidth})
		        .setBorder(new SolidBorder(borderWidth)).setFont(boldFont);

	
		//PdfFont boldFont = PdfFontFactory.createFont(FontConstants.HELVETICA_BOLD);
		

	
        
		Cell cell11 = createCell("DETAILS OF SUPPLIER", Border.NO_BORDER, TextAlignment.LEFT);
		cell11.setBorderRight(new SolidBorder(borderWidth));
		cell11.setBorderBottom(new SolidBorder(borderWidth));
		cell11.setBorderTop(new SolidBorder(borderWidth));
		cell11.setFont(boldFont);
		contentTable.addCell(cell11);

//		Cell cell12 = createCell("DETAILS OF  BILL OF SUPPLY", Border.NO_BORDER, TextAlignment.RIGHT);
//		cell12.setBorderLeft(new SolidBorder(borderWidth));
//		cell12.setBorderBottom(new SolidBorder(borderWidth));
//		cell12.setBorderTop(new SolidBorder(borderWidth));
//		contentTable.setFont(boldFont);
//		contentTable.addCell(cell12);
		
		Cell cell12 = createCell("", Border.NO_BORDER, TextAlignment.LEFT);
		cell12.setBorderLeft(new SolidBorder(borderWidth));
		cell12.setBorderBottom(new SolidBorder(borderWidth));
		cell12.setBorderTop(new SolidBorder(borderWidth));
		Paragraph paragraph22 = new Paragraph()
		        .add(new Text("DETAILS OF  BILL OF SUPPLY :").setFont(boldFont))
		        .add(new Text("").setFont(normalFont));
		cell12.add(paragraph22);
        contentTable.addCell(cell12);

//		Cell cell31 = createCell("GSTIN :" +supplier_GSTN, Border.NO_BORDER, TextAlignment.LEFT);
//		cell31.setBorderRight(new SolidBorder(borderWidth));
//		cell31.setBorderTop(new SolidBorder(borderWidth));
//		contentTable.addCell(cell31);
//		
		Cell cell31 = createCell("", Border.NO_BORDER, TextAlignment.LEFT);
		cell31.setBorderRight(new SolidBorder(borderWidth));
		cell31.setBorderTop(new SolidBorder(borderWidth));
		Paragraph paragraph = new Paragraph()
		        .add(new Text("GSTIN :").setFont(boldFont))
		        .add(new Text(supplier_GSTN).setFont(normalFont));
		cell31.add(paragraph);
        contentTable.addCell(cell31);
		

//		Cell cell32 = createCell("CONTRACT REF:"+ conract_no, Border.NO_BORDER, TextAlignment.RIGHT);
//		cell32.setBorderLeft(new SolidBorder(borderWidth));
//		cell32.setBorderTop(new SolidBorder(borderWidth));
//		contentTable.addCell(cell32);
//		
		Cell cell32 = createCell("", Border.NO_BORDER, TextAlignment.LEFT);
		cell32.setBorderRight(new SolidBorder(borderWidth));
		cell32.setBorderTop(new SolidBorder(borderWidth));
		Paragraph paragraph2 = new Paragraph()
		        .add(new Text("CONTRACT REF:").setFont(boldFont))
		        .add(new Text(conract_no).setFont(normalFont));
		cell32.add(paragraph2);
        contentTable.addCell(cell32);

//		Cell cell41 = createCell("NAME :" +supplier_Name, Border.NO_BORDER, TextAlignment.LEFT);
//		cell41.setBorderRight(new SolidBorder(borderWidth));
//		contentTable.addCell(cell41);
//		
		Cell cell41 = createCell("", Border.NO_BORDER, TextAlignment.LEFT);
		cell41.setBorderRight(new SolidBorder(borderWidth));
		
		Paragraph paragraph3 = new Paragraph()
		        .add(new Text("NAME :").setFont(boldFont))
		        .add(new Text(supplier_Name).setFont(normalFont));
		cell41.add(paragraph3);
        contentTable.addCell(cell41);

//		Cell cell42 = createCell("DI REF:", Border.NO_BORDER, TextAlignment.RIGHT);
//		cell42.setBorderLeft(new SolidBorder(borderWidth));
//		contentTable.addCell(cell42);
        
        Cell cell42 = createCell("", Border.NO_BORDER, TextAlignment.LEFT);
        cell42.setBorderRight(new SolidBorder(borderWidth));
       
		Paragraph paragraph4 = new Paragraph()
		        .add(new Text("DI REF :").setFont(boldFont))
		        .add(new Text("").setFont(normalFont));
		cell42.add(paragraph4);
        contentTable.addCell(cell42);
        
        
		// Row 5
//		Cell cell51 = createCell("ADDRESS:"+supplier_Address, Border.NO_BORDER, TextAlignment.LEFT);
//		cell51.setBorderRight(new SolidBorder(borderWidth));
//		contentTable.addCell(cell51);
        
        Cell cell51 = createCell("", Border.NO_BORDER, TextAlignment.LEFT);
        cell51.setBorderRight(new SolidBorder(borderWidth));
       
		Paragraph paragraph5 = new Paragraph()
		        .add(new Text("ADDRESS:").setFont(boldFont))
		        .add(new Text(supplier_Address).setFont(normalFont));
		cell51.add(paragraph5);
        contentTable.addCell(cell51);

//		Cell cell52 = createCell("CHALLAN REF:", Border.NO_BORDER, TextAlignment.RIGHT);
//		cell52.setBorderLeft(new SolidBorder(borderWidth));
//		contentTable.addCell(cell52);
        Cell cell52 = createCell("", Border.NO_BORDER, TextAlignment.LEFT);
        cell52.setBorderRight(new SolidBorder(borderWidth));
       
		Paragraph paragraph6 = new Paragraph()
		        .add(new Text("CHALLAN REF:").setFont(boldFont))
		        .add(new Text("").setFont(normalFont));
		cell52.add(paragraph6);
        contentTable.addCell(cell52);
        
//		// Row 6
//		Cell cell61 = createCell("STATE NAME :"+Clientstate, Border.NO_BORDER, TextAlignment.LEFT);
//		cell61.setBorderRight(new SolidBorder(borderWidth));
//		contentTable.addCell(cell61);
//		
        Cell cell61 = createCell("", Border.NO_BORDER, TextAlignment.LEFT);
        cell61.setBorderRight(new SolidBorder(borderWidth));
       
		Paragraph paragraph7 = new Paragraph()
		        .add(new Text("STATE NAME:").setFont(boldFont))
		        .add(new Text(Clientstate).setFont(normalFont));
		cell61.add(paragraph7);
        contentTable.addCell(cell61);
        
		

//		Cell cell62 = createCell("LC REF(if applicable): not any", Border.NO_BORDER, TextAlignment.RIGHT);
//		cell62.setBorderLeft(new SolidBorder(borderWidth));
//		contentTable.addCell(cell62);
		
		 Cell cell62 = createCell("", Border.NO_BORDER, TextAlignment.LEFT);
		 cell62.setBorderRight(new SolidBorder(borderWidth));
	       
			Paragraph paragraph23 = new Paragraph()
			        .add(new Text("LC REF(if applicable): not any:").setFont(boldFont))
			        .add(new Text("").setFont(normalFont));
			cell62.add(paragraph23);
	        contentTable.addCell(cell62);
		
//		Cell cell661 = createCell("STATE CODE :"+Clientcode, Border.NO_BORDER, TextAlignment.LEFT);
//		cell661.setBorderRight(new SolidBorder(borderWidth));
//		contentTable.addCell(cell661);
		
		Cell cell661 = createCell("", Border.NO_BORDER, TextAlignment.LEFT);
		cell661.setBorderRight(new SolidBorder(borderWidth));

		Paragraph paragraph1 = new Paragraph()
		        .add(new Text("STATE CODE: ").setFont(boldFont))
		        .add(new Text(Clientcode).setFont(normalFont));
        cell661.add(paragraph1);
        contentTable.addCell(cell661);

//		Cell cell662 = createCell("BILL OF SUPPLY NO:"+bill_of_Supply , Border.NO_BORDER, TextAlignment.RIGHT);
//		cell662.setBorderLeft(new SolidBorder(borderWidth));
//		contentTable.addCell(cell662);
        
        Cell cell662 = createCell("", Border.NO_BORDER, TextAlignment.LEFT);
        cell662.setBorderRight(new SolidBorder(borderWidth));

		Paragraph paragraph8 = new Paragraph()
		        .add(new Text("BILL OF SUPPLY NO: ").setFont(boldFont))
		        .add(new Text(bill_of_Supply).setFont(normalFont));
		cell662.add(paragraph8);
        contentTable.addCell(cell662);
		
//		Cell cell663 = createCell("PAN :"+ClientPan , Border.NO_BORDER, TextAlignment.LEFT);
//		cell663.setBorderRight(new SolidBorder(borderWidth));
//		contentTable.addCell(cell663);
        

        Cell cell663 = createCell("", Border.NO_BORDER, TextAlignment.LEFT);
        cell663.setBorderRight(new SolidBorder(borderWidth));

		Paragraph paragraph9 = new Paragraph()
		        .add(new Text("PAN : ").setFont(boldFont))
		        .add(new Text(BOS_Date).setFont(normalFont));
		cell663.add(paragraph9);
        contentTable.addCell(cell663);
        
        

//		Cell cell664 = createCell("BILL OF SUPPLY DATE:"+BOS_Date, Border.NO_BORDER, TextAlignment.RIGHT);
//		cell664.setBorderLeft(new SolidBorder(borderWidth));
//		contentTable.addCell(cell664);
//		

        

        Cell cell664 = createCell("", Border.NO_BORDER, TextAlignment.LEFT);
        cell664.setBorderRight(new SolidBorder(borderWidth));

		Paragraph paragraph10 = new Paragraph()
		        .add(new Text("BILL OF SUPPLY DATE : ").setFont(boldFont))
		        .add(new Text(ClientPan).setFont(normalFont));
		cell664.add(paragraph10);
        contentTable.addCell(cell664);
		
		Cell cell21 = createCell("DETAILS OF  RECIEPIENTS", Border.NO_BORDER, TextAlignment.LEFT);
		cell21.setBorderRight(new SolidBorder(borderWidth));
		cell21.setBorderBottom(new SolidBorder(borderWidth));
		cell21.setBorderTop(new SolidBorder(borderWidth));
		contentTable.addCell(cell21);

//		Cell cell22 = createCell("DETAILS OF  CONSIGNEE", Border.NO_BORDER, TextAlignment.RIGHT);
//		cell22.setBorderLeft(new SolidBorder(borderWidth));
//		cell22.setBorderBottom(new SolidBorder(borderWidth));
//		cell22.setBorderTop(new SolidBorder(borderWidth));
//		contentTable.addCell(cell22);
//		
		  Cell cell22 = createCell("", Border.NO_BORDER, TextAlignment.LEFT);
		  cell22.setBorderRight(new SolidBorder(borderWidth));
		  cell22.setBorderTop(new SolidBorder(borderWidth));
			Paragraph paragraph24 = new Paragraph()
			        .add(new Text("DETAILS OF  CONSIGNEE: ").setFont(boldFont))
			        .add(new Text("").setFont(normalFont));
			cell22.add(paragraph24);
	        contentTable.addCell(cell22);
		

//		Cell cell71 = createCell("GSTIN :"+recipient_GSTN, Border.NO_BORDER, TextAlignment.LEFT);
//		cell71.setBorderRight(new SolidBorder(borderWidth));
//		cell71.setBorderTop(new SolidBorder(borderWidth));
//		contentTable.addCell(cell71);
		
		  Cell cell71 = createCell("", Border.NO_BORDER, TextAlignment.LEFT);
		  cell71.setBorderRight(new SolidBorder(borderWidth));
		  cell71.setBorderTop(new SolidBorder(borderWidth));
			Paragraph paragraph11 = new Paragraph()
			        .add(new Text("GSTIN : ").setFont(boldFont))
			        .add(new Text(recipient_GSTN).setFont(normalFont));
			cell71.add(paragraph11);
	        contentTable.addCell(cell71);
		
		

//		Cell cell72 = createCell("GSTIN :"+consignee_GSTN, Border.NO_BORDER, TextAlignment.RIGHT);
//		cell72.setBorderLeft(new SolidBorder(borderWidth));
//		cell72.setBorderTop(new SolidBorder(borderWidth));
//		contentTable.addCell(cell72);
		
		
		Cell cell72 = createCell("", Border.NO_BORDER, TextAlignment.LEFT);
		cell72.setBorderRight(new SolidBorder(borderWidth));
		cell72.setBorderTop(new SolidBorder(borderWidth));
			Paragraph paragraph12 = new Paragraph()
			        .add(new Text("GSTIN : ").setFont(boldFont))
			        .add(new Text(consignee_GSTN).setFont(normalFont));
			cell72.add(paragraph12);
	        contentTable.addCell(cell72);

//		Cell cell73 = createCell("NAME :"+recipient_Name, Border.NO_BORDER, TextAlignment.LEFT);
//		cell73.setBorderRight(new SolidBorder(borderWidth));
//		contentTable.addCell(cell73);
		
		Cell cell73 = createCell("", Border.NO_BORDER, TextAlignment.LEFT);
		cell73.setBorderRight(new SolidBorder(borderWidth));
		
			Paragraph paragraph13 = new Paragraph()
			        .add(new Text("NAME : ").setFont(boldFont))
			        .add(new Text(recipient_Name).setFont(normalFont));
			cell73.add(paragraph13);
	        contentTable.addCell(cell73);
		
		

//		Cell cell74 = createCell("NAME :"+consignee_Name, Border.NO_BORDER, TextAlignment.RIGHT);
//		cell74.setBorderLeft(new SolidBorder(borderWidth));
//		contentTable.addCell(cell74);
		
		
		Cell cell74 = createCell("", Border.NO_BORDER, TextAlignment.LEFT);
		cell74.setBorderRight(new SolidBorder(borderWidth));
		
			Paragraph paragraph14 = new Paragraph()
			        .add(new Text("NAME : ").setFont(boldFont))
			        .add(new Text(consignee_Name).setFont(normalFont));
			cell74.add(paragraph14);
	        contentTable.addCell(cell74);
		// Row 5
	        
	        
//		Cell cell75 = createCell("ADDRESS:"+recipient_Address, Border.NO_BORDER, TextAlignment.LEFT);
//		cell75.setBorderRight(new SolidBorder(borderWidth));
//		contentTable.addCell(cell75);
		
		Cell cell75 = createCell("", Border.NO_BORDER, TextAlignment.LEFT);
		cell75.setBorderRight(new SolidBorder(borderWidth));
		
			Paragraph paragraph15 = new Paragraph()
			        .add(new Text("ADDRESS : ").setFont(boldFont))
			        .add(new Text(recipient_Address).setFont(normalFont));
			cell75.add(paragraph15);
	        contentTable.addCell(cell75);

//		Cell cell76 = createCell("ADDRESS:"+consignee_Address, Border.NO_BORDER, TextAlignment.RIGHT);
//		cell76.setBorderLeft(new SolidBorder(borderWidth));
//		contentTable.addCell(cell76);
		
		Cell cell76 = createCell("", Border.NO_BORDER, TextAlignment.LEFT);
		cell76.setBorderRight(new SolidBorder(borderWidth));
		
			Paragraph paragraph16 = new Paragraph()
			        .add(new Text("ADDRESS : ").setFont(boldFont))
			        .add(new Text(consignee_Address).setFont(normalFont));
			cell76.add(paragraph16);
	        contentTable.addCell(cell76);
		
		
		// Row 6
//		Cell cell77 = createCell("STATE NAME :"+Clientstate, Border.NO_BORDER, TextAlignment.LEFT);
//		cell77.setBorderRight(new SolidBorder(borderWidth));
//		contentTable.addCell(cell77);
		
		Cell cell77 = createCell("", Border.NO_BORDER, TextAlignment.LEFT);
		cell77.setBorderRight(new SolidBorder(borderWidth));
		
			Paragraph paragraph17 = new Paragraph()
			        .add(new Text("STATE NAME : ").setFont(boldFont))
			        .add(new Text(Clientstate).setFont(normalFont));
			cell77.add(paragraph17);
	        contentTable.addCell(cell77);

//		Cell cell78 = createCell("STATE NAME :"+Clientstate, Border.NO_BORDER, TextAlignment.RIGHT);
//		cell78.setBorderLeft(new SolidBorder(borderWidth));
//		contentTable.addCell(cell78);
		
		
		Cell cell78 = createCell("", Border.NO_BORDER, TextAlignment.LEFT);
		cell78.setBorderRight(new SolidBorder(borderWidth));
		
			Paragraph paragraph18 = new Paragraph()
			        .add(new Text("STATE NAME : ").setFont(boldFont))
			        .add(new Text(Clientstate).setFont(normalFont));
			cell78.add(paragraph18);
	        contentTable.addCell(cell78);
	        
	        
//		Cell cell778 = createCell("STATE CODE :"+Clientcode, Border.NO_BORDER, TextAlignment.LEFT);
//		cell778.setBorderRight(new SolidBorder(borderWidth));
//		contentTable.addCell(cell778);

		
		
		Cell cell778 = createCell("", Border.NO_BORDER, TextAlignment.LEFT);
		cell778.setBorderRight(new SolidBorder(borderWidth));
		
			Paragraph paragraph19 = new Paragraph()
			        .add(new Text("STATE CODE : ").setFont(boldFont))
			        .add(new Text(Clientcode).setFont(normalFont));
			cell778.add(paragraph19);
	        contentTable.addCell(cell778);
	        
//		Cell cell776 = createCell("STATE CODE :"+Clientcode, Border.NO_BORDER, TextAlignment.RIGHT);
//		cell776.setBorderLeft(new SolidBorder(borderWidth));
//		contentTable.addCell(cell776);
	
	        
	        Cell cell776 = createCell("", Border.NO_BORDER, TextAlignment.LEFT);
	        cell776.setBorderRight(new SolidBorder(borderWidth));
			
				Paragraph paragraph20 = new Paragraph()
				        .add(new Text("STATE CODE : ").setFont(boldFont))
				        .add(new Text(Clientcode).setFont(normalFont));
				cell776.add(paragraph20);
		        contentTable.addCell(cell776);
		        
		        
//		Cell cell775 = createCell("PAN:"+ClientPan, Border.NO_BORDER, TextAlignment.LEFT);
//		cell775.setBorderRight(new SolidBorder(borderWidth));
//		contentTable.addCell(cell775);
		
		  Cell cell775 = createCell("", Border.NO_BORDER, TextAlignment.LEFT);
		  cell775.setBorderRight(new SolidBorder(borderWidth));
			
				Paragraph paragraph21 = new Paragraph()
				        .add(new Text("PAN : ").setFont(boldFont))
				        .add(new Text(BOS_Date).setFont(normalFont));
				cell775.add(paragraph21);
		        contentTable.addCell(cell775);

		Cell cell774 = createCell("", Border.NO_BORDER, TextAlignment.RIGHT);
		cell774.setBorderLeft(new SolidBorder(borderWidth));
		
		contentTable.addCell(cell774);
		        
		            
		
	
		document.add(contentTable);
		
		Paragraph spacingParagraph1 = new Paragraph("\n\n").setFixedLeading(10f); 
        document.add(spacingParagraph1);
        
		
     String[] columnNames = {"SI NO", "HSN", "DESCRIPTION", "CROP YEAR", "BALE MARK", "VARIETY/GRADE", "NO OF BALES", "NOMINAL WT./BALE", "UNIT", "RATE (RS/UNIT)", "QTY", "TOTAL"};
     float[] columnWidths = {3, 5, 7, 6, 4, 2, 1, 8, 1, 2, 1, 2};

     Table contentTable11 = new Table(columnWidths).setBorder(new SolidBorder(2f));

     // Add headers
     for (int i = 0; i < columnNames.length; i++) {
         Cell headerCell = createCell(columnNames[i], Border.NO_BORDER, TextAlignment.CENTER).setBold();
         headerCell.setBorderTop(new SolidBorder(1f));
         headerCell.setBorderBottom(new SolidBorder(1f));

         if (i < columnNames.length - 1) {
             headerCell.setBorderRight(new SolidBorder(1f));
         }

         contentTable11.addHeaderCell(headerCell);
     }
     String cropYear = "";
     String baleMark = "";
     String strNoOfBales = "";
     String strNominalWt = "";
     String Jute_variety = "";
     String strRate = "";
     String strNominalQty = "";
     // Iterate over dispatchList data
     for (Object[] row : list) {
	        // Assuming you need to extract values
			  cropYear = (String) row[0];
		        baleMark = (String) row[1];
		        Jute_variety = (String) row[2];
		        int noOfBales = ((Number) row[3]).intValue();  // Assuming the value is a number
		        float nominalWt = ((Number) row[4]).floatValue();  // Assuming the value is a number
		        float rate = ((Number) row[5]).floatValue();  // Assuming the value is a number
		        float nominalQty = ((Number) row[6]).floatValue(); 
		         strNoOfBales = String.valueOf(noOfBales);
		        strNominalWt = String.valueOf(nominalWt);
		         strRate = String.valueOf(rate);
		        strNominalQty = String.valueOf(nominalQty);

	        // Do something with these values if needed
	    }
		
  // Iterate over dispatchList data
     for (Object[] row : list) {
         for (int j = 0; j < columnNames.length; j++) {
             String cellData;

             // Check the index and assign either static or dynamic value
             if (j == 0) {
                 // SI NO
            	 cellData = String.valueOf(list.indexOf(row) + 1);
             } else if (j == 1) {
                 // HSN
                 cellData = "53031010";
             } else if (j == 2) {
                 // DESCRIPTION
                 cellData = "Raw Jute";
             } else if (j == 3) {
                 // CROP YEAR
                 cellData = cropYear;
             } else if (j == 4) {
                 // BALE MARK
                 cellData = baleMark;
             } else if (j == 5) {
                 // VARIETY/GRADE
                 cellData = Jute_variety; // You need to replace this with the appropriate value
             } else if (j == 6) {
                 // NO OF BALES
                 cellData = strNoOfBales;
             } else if (j == 7) {
                 // NOMINAL WT./BALE
                 cellData = strNominalWt;
             } else if (j == 8) {
                 // UNIT
                 cellData = "Qtls."; // You need to replace this with the appropriate value
             } else if (j == 9) {
                 // RATE (RS/UNIT)
                 cellData = strRate;
             } else if (j == 10) {
                 // QTY
                 cellData = strNominalQty; // You need to replace this with the appropriate value
             } else if (j == 11) {
                 // TOTAL
                 cellData = "total"; // You need to replace this with the appropriate value
             } 
          
          
           else {
                 cellData = "N/A";
             }

             Cell cell = createCell(cellData, Border.NO_BORDER, TextAlignment.CENTER);

             cell.setBorderTop(new SolidBorder(1f));
             cell.setBorderBottom(new SolidBorder(1f));
             cell.setBorderLeft(new SolidBorder(1f));

             if (j < columnNames.length - 1) {
                 cell.setBorderRight(new SolidBorder(1f));
             }

             contentTable11.addCell(cell);
         }
     }
     document.add(contentTable11);

     // Now contentTable11 has been populated with your data

     
//  
//  contentTable11.addCell(createCell("Total", Border.NO_BORDER, TextAlignment.CENTER)
//          .setBorderTop(new SolidBorder(1f))
//          .setBorderBottom(new SolidBorder(1f))
//          .setBorderLeft(new SolidBorder(1f))
//          .setBorderRight(new SolidBorder(1f))); // First cell in the last row
//
//  contentTable11.addCell(createCell("Qty total=", Border.NO_BORDER, TextAlignment.CENTER)
//          .setBorderTop(new SolidBorder(1f))
//          .setBorderBottom(new SolidBorder(1f))
//          .setBorderRight(new SolidBorder(1f))); // Second cell in the last row
//
//  contentTable11.addCell(createCell(" overall=", Border.NO_BORDER, TextAlignment.CENTER)
//          .setBorderTop(new SolidBorder(1f))
//          .setBorderBottom(new SolidBorder(1f))
//          .setBorderRight(new SolidBorder(1f))); // Third cell in the last row
//  
//  document.add(contentTable11);
  
 

 
//     String invoiceValue1 = Invoice_Value; // Replace with your actual invoice value
//
//     
//         int number = Integer.parseInt(invoiceValue1);
//         String words = convertToWords(number);
//         String dynamicValue = "Invoice value in words: " + words;
//         Paragraph dynamicParagraph = new Paragraph(dynamicValue);
//         document.add(dynamicParagraph);
//     
//
//     
     
//   int number = Integer.parseInt(invoiceValue);
//     String words = convertToWords(number);
   
//
  String dynamicValue = "Invoice value in words =" +Invoice_Value;
  Paragraph dynamicParagraph = new Paragraph(dynamicValue);
  document.add(dynamicParagraph);

 
		document.close(); 
//		 return filePath;
		pdfDocument.close(); 
	}catch (Exception e) {
        e.printStackTrace();
    } finally {
        try {
            if (pdfDocument != null) {
                pdfDocument.close(); 
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
  return fileName;

   
}
	
	
	public static String convertToWords(int number) {
	    String[] units = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"};
	    String[] teens = {"", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
	    String[] tens = {"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};

	    if (number == 0) {
	        return "Zero";
	    }

	    if (number < 0) {
	        return "Minus " + convertToWords(-number);
	    }

	    String words = "";

	    if ((number / 1000) > 0) {
	        words += convertToWords(number / 1000) + " Thousand ";
	        number %= 1000;
	    }

	    if ((number / 100) > 0) {
	        words += convertToWords(number / 100) + " Hundred ";
	        number %= 100;
	    }

	    if (number > 0) {
	        if (number < 10) {
	            words += units[number];
	        } else if (number < 20) {
	            words += teens[number - 10];
	        } else {
	            words += tens[number / 10] + " " + units[number % 10];
	        }
	    }

	    return words;
	}



	private static String generateTimestamp() {
	        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd_HHmmssSSS");
	        return dateFormat.format(new Date(0));
	    }
	private Cell createHeaderCell(String content, Border border, TextAlignment alignment) {
	    Paragraph paragraph = new Paragraph(content)
	            .setBorder(border)
	            .setTextAlignment(alignment)
	            .setFontSize(12)  // Adjust font size as needed for the header
	            .setBold();  // Keep the header bold if needed

	    return new Cell().add(paragraph);
	}


	private Cell createCell(String content, Border border, TextAlignment alignment) {
	    return new Cell().add(new Paragraph(content))
	            .setBorder(border)
	            .setTextAlignment(alignment)
	            .setFontSize(10); // Adjust font size as needed for the content
	}
	public Cell createCell(String content, TextAlignment alignment) {
	    Cell cell = new Cell().add(content);
	    cell.setTextAlignment(alignment);
	    cell.setBorder(Border.NO_BORDER); // Optional: Set border to NO_BORDER if you don't want any visible borders
	    return cell;
	}
	
	
	private void addHeader(Document document, String Challan_No1, String instdate1, String Shipment_Details) {
	    document.add(createUnderlinedParagraph("BILL OF SUPPLY"));
	}

	private Paragraph createRightAlignedHeaderCell(String content) {
	    Tab tab = new Tab();
	    tab.setHeight(20); // Adjust margin as needed

	    Paragraph paragraph = new Paragraph().add(tab).add(content)
	            .setTextAlignment(TextAlignment.RIGHT)
	            .setFontSize(12)  // Adjust font size as needed for the header
	            .setBold();  // Keep the header bold if needed

	    return paragraph;
	}

 
	    
	 // Create a cell with left-aligned and right-aligned paragraphs
	 

	private Paragraph createHeaderCell(String content, TextAlignment alignment) {
	    return new Paragraph(content)
	            .setTextAlignment(alignment)
	            .setFontSize(12)  // Adjust font size as needed for the header
	            .setBold();  // Keep the header bold if needed
	}


    private Paragraph createUnderlinedParagraph(String staticValue) {
        return new Paragraph(staticValue)
                .setBold()
                .setUnderline()
                .setTextAlignment(TextAlignment.CENTER)
                .setMarginBottom(10); // Adjust margin as needed
    }
   
	 
	

}
	
	
	
	
//
//    