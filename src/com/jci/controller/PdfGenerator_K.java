
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
	public String generateBillPdf( String  Invoice_Value, String challan_No1, String supplier_Name,
			String supplier_GSTN, String supplier_Address, String recipient_Name, String recipient_GSTN,
			String recipient_Address, String consignee_Name, String consignee_GSTN, String consignee_Address,
			String bill_of_Supply, String conract_no,String Clientstate, String Clientcode,String BOS_Date, String ClientPan, List<Object[]> list) throws FileNotFoundException {
		

		String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date(0));
	     String fileName = "generatedfile_" + timestamp + ".pdf";
//
	     String filePath = "C:\\Users\\kailash.shah\\documentimage\\" + fileName;
			

		     PdfWriter pdfWriter = new PdfWriter(filePath);

		   
		     PdfDocument pdfDocument = new PdfDocument(pdfWriter);       
		
		
 try {
	 
	  pdfDocument.setDefaultPageSize(PageSize.A4);
	  
	  PdfFont boldFont = PdfFontFactory.createFont(FontConstants.HELVETICA_BOLD);

     Document document = new Document(pdfDocument);
	 document.setMargins(5, 5, 5, 5);
		addHeader(document, filePath, filePath, filePath);
		float columnWidth = PageSize.A4.getWidth() * 0.5f;
		float borderWidth = 1.0f; 
		Table contentTable1 = new Table(new float[]{columnWidth, columnWidth});
		Cell cell1199 = createCell("THE JUTE CORPORATION OF INDIA", Border.NO_BORDER, TextAlignment.LEFT).setFont(boldFont);
		contentTable1.addCell(cell1199);

        Cell cell1198 = createCell("Phone +91 (033) 2252 6720 / 7109", Border.NO_BORDER, TextAlignment.RIGHT).setFont(boldFont);
        contentTable1.addCell(cell1198);
      

        Cell cell1197 = createCell("CIN:U17232WB1971GOl027958", Border.NO_BORDER, TextAlignment.LEFT)
                .setPaddingBottom(2f).setFont(boldFont); 
        contentTable1.addCell(cell1197);

        Cell cell1196 = createCell("Email: jci@jcimail.in", Border.NO_BORDER, TextAlignment.RIGHT)
                .setPaddingBottom(2f).setFont(boldFont);
        contentTable1.addCell(cell1196);

        // Row 3
        Cell cell1195 = createCell("15N, Nellie sengupta Sani,", Border.NO_BORDER, TextAlignment.LEFT)
                .setPaddingBottom(2f).setFont(boldFont); 
        contentTable1.addCell(cell1195);

        Cell cell1194 = createCell("FAX: +91(033)2252 1771", Border.NO_BORDER, TextAlignment.RIGHT)
                .setPaddingBottom(2f).setFont(boldFont); 
        contentTable1.addCell(cell1194);

        // Row 4
        Cell cell1193 = createCell("Kolkata - 700 087", Border.NO_BORDER, TextAlignment.LEFT)
                .setPaddingBottom(2f).setFont(boldFont); 
        contentTable1.addCell(cell1193);

        Cell cell1192 = createCell("", Border.NO_BORDER, TextAlignment.RIGHT)
                .setPaddingBottom(2f).setFont(boldFont); 
        contentTable1.addCell(cell1192);

        // Row 5
        Cell cell1191 = createCell("", Border.NO_BORDER, TextAlignment.LEFT)
                .setPaddingBottom(2f).setFont(boldFont); 
        contentTable1.addCell(cell1191);

        Cell cell1190 = createCell("", Border.NO_BORDER, TextAlignment.RIGHT)
                .setPaddingBottom(2f).setFont(boldFont); 
        contentTable1.addCell(cell1190);

        document.add(contentTable1);

        
        Paragraph spacingParagraph = new Paragraph("\n\n").setFixedLeading(10f); 
        document.add(spacingParagraph);
       
        
       
        PdfFont normalFont = PdfFontFactory.createFont(FontConstants.HELVETICA);
        
		Table contentTable = new Table(new float[]{columnWidth, columnWidth})
		        .setBorder(new SolidBorder(borderWidth)).setFont(boldFont);

	
		

	
        
		Cell cell11 = createCell("DETAILS OF SUPPLIER", Border.NO_BORDER, TextAlignment.LEFT);
		cell11.setBorderRight(new SolidBorder(borderWidth));
		cell11.setBorderBottom(new SolidBorder(borderWidth));
		cell11.setBorderTop(new SolidBorder(borderWidth));
		cell11.setFont(boldFont);
		contentTable.addCell(cell11);
		 


		
		Cell cell12 = createCell("", Border.NO_BORDER, TextAlignment.LEFT);
		cell12.setBorderLeft(new SolidBorder(borderWidth));
		cell12.setBorderBottom(new SolidBorder(borderWidth));
		cell12.setBorderTop(new SolidBorder(borderWidth));
		Paragraph paragraph22 = new Paragraph()
		        .add(new Text("DETAILS OF  BILL OF SUPPLY :").setFont(boldFont))
		        .add(new Text("").setFont(normalFont));
		cell12.add(paragraph22);
        contentTable.addCell(cell12);

//	
//		
		Cell cell31 = createCell("", Border.NO_BORDER, TextAlignment.LEFT);
		cell31.setBorderRight(new SolidBorder(borderWidth));
		cell31.setBorderTop(new SolidBorder(borderWidth));
		Paragraph paragraph = new Paragraph()
		        .add(new Text("GSTIN :").setFont(boldFont))
		        .add(new Text(supplier_GSTN).setFont(normalFont));
		cell31.add(paragraph);
        contentTable.addCell(cell31);
		

//		
		Cell cell32 = createCell("", Border.NO_BORDER, TextAlignment.LEFT);
		cell32.setBorderRight(new SolidBorder(borderWidth));
		cell32.setBorderTop(new SolidBorder(borderWidth));
		Paragraph paragraph2 = new Paragraph()
		        .add(new Text("CONTRACT REF:").setFont(boldFont))
		        .add(new Text(conract_no).setFont(normalFont));
		cell32.add(paragraph2);
        contentTable.addCell(cell32);

//		
		Cell cell41 = createCell("", Border.NO_BORDER, TextAlignment.LEFT);
		cell41.setBorderRight(new SolidBorder(borderWidth));
		
		Paragraph paragraph3 = new Paragraph()
		        .add(new Text("NAME :").setFont(boldFont))
		        .add(new Text(supplier_Name).setFont(normalFont));
		cell41.add(paragraph3);
        contentTable.addCell(cell41);


        
        Cell cell42 = createCell("", Border.NO_BORDER, TextAlignment.LEFT);
        cell42.setBorderRight(new SolidBorder(borderWidth));
       
		Paragraph paragraph4 = new Paragraph()
		        .add(new Text("DI REF :").setFont(boldFont))
		        .add(new Text("").setFont(normalFont));
		cell42.add(paragraph4);
        contentTable.addCell(cell42);
        
     
        
        Cell cell51 = createCell("", Border.NO_BORDER, TextAlignment.LEFT);
        cell51.setBorderRight(new SolidBorder(borderWidth));
       
		Paragraph paragraph5 = new Paragraph()
		        .add(new Text("ADDRESS:").setFont(boldFont))
		        .add(new Text(supplier_Address).setFont(normalFont));
		cell51.add(paragraph5);
        contentTable.addCell(cell51);

        Cell cell52 = createCell("", Border.NO_BORDER, TextAlignment.LEFT);
        cell52.setBorderRight(new SolidBorder(borderWidth));
       
		Paragraph paragraph6 = new Paragraph()
		        .add(new Text("CHALLAN REF:").setFont(boldFont))
		        .add(new Text("").setFont(normalFont));
		cell52.add(paragraph6);
        contentTable.addCell(cell52);
        
//		
//		
        Cell cell61 = createCell("", Border.NO_BORDER, TextAlignment.LEFT);
        cell61.setBorderRight(new SolidBorder(borderWidth));
       
		Paragraph paragraph7 = new Paragraph()
		        .add(new Text("STATE NAME:").setFont(boldFont))
		        .add(new Text(Clientstate).setFont(normalFont));
		cell61.add(paragraph7);
        contentTable.addCell(cell61);
        
		

		
		 Cell cell62 = createCell("", Border.NO_BORDER, TextAlignment.LEFT);
		 cell62.setBorderRight(new SolidBorder(borderWidth));
	       
			Paragraph paragraph23 = new Paragraph()
			        .add(new Text("LC REF(if applicable): not any:").setFont(boldFont))
			        .add(new Text("").setFont(normalFont));
			cell62.add(paragraph23);
	        contentTable.addCell(cell62);
		

		
		Cell cell661 = createCell("", Border.NO_BORDER, TextAlignment.LEFT);
		cell661.setBorderRight(new SolidBorder(borderWidth));

		Paragraph paragraph1 = new Paragraph()
		        .add(new Text("STATE CODE: ").setFont(boldFont))
		        .add(new Text(Clientcode).setFont(normalFont));
        cell661.add(paragraph1);
        contentTable.addCell(cell661);

        
        Cell cell662 = createCell("", Border.NO_BORDER, TextAlignment.LEFT);
        cell662.setBorderRight(new SolidBorder(borderWidth));

		Paragraph paragraph8 = new Paragraph()
		        .add(new Text("BILL OF SUPPLY NO: ").setFont(boldFont))
		        .add(new Text(bill_of_Supply).setFont(normalFont));
		cell662.add(paragraph8);
        contentTable.addCell(cell662);
		
//
        

        Cell cell663 = createCell("", Border.NO_BORDER, TextAlignment.LEFT);
        cell663.setBorderRight(new SolidBorder(borderWidth));

		Paragraph paragraph9 = new Paragraph()
		        .add(new Text("PAN : ").setFont(boldFont))
		        .add(new Text(BOS_Date).setFont(normalFont));
		cell663.add(paragraph9);
        contentTable.addCell(cell663);
        
        

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

//
//		
		  Cell cell22 = createCell("", Border.NO_BORDER, TextAlignment.LEFT);
		  cell22.setBorderRight(new SolidBorder(borderWidth));
		  cell22.setBorderTop(new SolidBorder(borderWidth));
			Paragraph paragraph24 = new Paragraph()
			        .add(new Text("DETAILS OF  CONSIGNEE: ").setFont(boldFont))
			        .add(new Text("").setFont(normalFont));
			cell22.add(paragraph24);
	        contentTable.addCell(cell22);
		

		  Cell cell71 = createCell("", Border.NO_BORDER, TextAlignment.LEFT);
		  cell71.setBorderRight(new SolidBorder(borderWidth));
		  cell71.setBorderTop(new SolidBorder(borderWidth));
			Paragraph paragraph11 = new Paragraph()
			        .add(new Text("GSTIN : ").setFont(boldFont))
			        .add(new Text(recipient_GSTN).setFont(normalFont));
			cell71.add(paragraph11);
	        contentTable.addCell(cell71);
		
		

		
		
		Cell cell72 = createCell("", Border.NO_BORDER, TextAlignment.LEFT);
		cell72.setBorderRight(new SolidBorder(borderWidth));
		cell72.setBorderTop(new SolidBorder(borderWidth));
			Paragraph paragraph12 = new Paragraph()
			        .add(new Text("GSTIN : ").setFont(boldFont))
			        .add(new Text(consignee_GSTN).setFont(normalFont));
			cell72.add(paragraph12);
	        contentTable.addCell(cell72);

		Cell cell73 = createCell("", Border.NO_BORDER, TextAlignment.LEFT);
		cell73.setBorderRight(new SolidBorder(borderWidth));
		
			Paragraph paragraph13 = new Paragraph()
			        .add(new Text("NAME : ").setFont(boldFont))
			        .add(new Text(recipient_Name).setFont(normalFont));
			cell73.add(paragraph13);
	        contentTable.addCell(cell73);
		
		

		
		
		Cell cell74 = createCell("", Border.NO_BORDER, TextAlignment.LEFT);
		cell74.setBorderRight(new SolidBorder(borderWidth));
		
			Paragraph paragraph14 = new Paragraph()
			        .add(new Text("NAME : ").setFont(boldFont))
			        .add(new Text(consignee_Name).setFont(normalFont));
			cell74.add(paragraph14);
	        contentTable.addCell(cell74);
	
		
		Cell cell75 = createCell("", Border.NO_BORDER, TextAlignment.LEFT);
		cell75.setBorderRight(new SolidBorder(borderWidth));
		
			Paragraph paragraph15 = new Paragraph()
			        .add(new Text("ADDRESS : ").setFont(boldFont))
			        .add(new Text(recipient_Address).setFont(normalFont));
			cell75.add(paragraph15);
	        contentTable.addCell(cell75);

		
		Cell cell76 = createCell("", Border.NO_BORDER, TextAlignment.LEFT);
		cell76.setBorderRight(new SolidBorder(borderWidth));
		
			Paragraph paragraph16 = new Paragraph()
			        .add(new Text("ADDRESS : ").setFont(boldFont))
			        .add(new Text(consignee_Address).setFont(normalFont));
			cell76.add(paragraph16);
	        contentTable.addCell(cell76);
		
		

		
		Cell cell77 = createCell("", Border.NO_BORDER, TextAlignment.LEFT);
		cell77.setBorderRight(new SolidBorder(borderWidth));
		
			Paragraph paragraph17 = new Paragraph()
			        .add(new Text("STATE NAME : ").setFont(boldFont))
			        .add(new Text(Clientstate).setFont(normalFont));
			cell77.add(paragraph17);
	        contentTable.addCell(cell77);


		
		
		Cell cell78 = createCell("", Border.NO_BORDER, TextAlignment.LEFT);
		cell78.setBorderRight(new SolidBorder(borderWidth));
		
			Paragraph paragraph18 = new Paragraph()
			        .add(new Text("STATE NAME : ").setFont(boldFont))
			        .add(new Text(Clientstate).setFont(normalFont));
			cell78.add(paragraph18);
	        contentTable.addCell(cell78);
	        

		
		
		Cell cell778 = createCell("", Border.NO_BORDER, TextAlignment.LEFT);
		cell778.setBorderRight(new SolidBorder(borderWidth));
		
			Paragraph paragraph19 = new Paragraph()
			        .add(new Text("STATE CODE : ").setFont(boldFont))
			        .add(new Text(Clientcode).setFont(normalFont));
			cell778.add(paragraph19);
	        contentTable.addCell(cell778);
	        

	        
	        Cell cell776 = createCell("", Border.NO_BORDER, TextAlignment.LEFT);
	        cell776.setBorderRight(new SolidBorder(borderWidth));
			
				Paragraph paragraph20 = new Paragraph()
				        .add(new Text("STATE CODE : ").setFont(boldFont))
				        .add(new Text(Clientcode).setFont(normalFont));
				cell776.add(paragraph20);
		        contentTable.addCell(cell776);
		        
		        

		
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
     float[] columnWidths = {3, 5, 7, 6, 4, 2, 1, 8, 1, 2, PageSize.A4.getWidth() * 0.1f, PageSize.A4.getWidth() * 0.1f};
     float totalWidth = 0;
     for (float width : columnWidths) {
         totalWidth += width;
     }
     
     float columnWidth1 = PageSize.A4.getWidth() * 0.38f;
     float columnWidth2 = PageSize.A4.getWidth() * 0.52f;
     float columnWidth3 = PageSize.A4.getWidth() * 0.3f;

     float largerFontSize = 14f;
     
     
     
     Table contentTable34 = new Table(new float[]{columnWidth1,columnWidth2,columnWidth3})
		        .setBorder(new SolidBorder(borderWidth)).setFont(boldFont);
     float minimumHeight = 20f;
 	Cell cell1134 = createCell("", Border.NO_BORDER, TextAlignment.LEFT);
 	cell1134.setBorderRight(new SolidBorder(borderWidth));
 	//cell1134.setBorderBottom(new SolidBorder(borderWidth));
 	cell1134.setBorderTop(new SolidBorder(borderWidth));
 	cell1134.setFont(boldFont);
 	cell1134.setHeight(minimumHeight);
 	contentTable34.addCell(cell1134);
 	Cell cell11345 = createCell("Particulars of goods", Border.NO_BORDER, TextAlignment.CENTER);
 	cell11345.setBorderRight(new SolidBorder(borderWidth));
 	//cell11345.setBorderBottom(new SolidBorder(borderWidth));
 	cell11345.setBorderTop(new SolidBorder(borderWidth));
 	cell11345.setFont(boldFont);
 	
 	cell11345.setHeight(minimumHeight);
 	contentTable34.addCell(cell11345);
 	Cell cell11346 = createCell("", Border.NO_BORDER, TextAlignment.LEFT);
 	cell11346.setBorderRight(new SolidBorder(borderWidth));
 	//cell11346.setBorderBottom(new SolidBorder(borderWidth));
 	cell11346.setFont(boldFont);
 	cell11346.setHeight(minimumHeight);
 
 	document.add(contentTable34);
	 
  
     Table contentTable11 = new Table(columnWidths).setBorder(new SolidBorder(2f));

     // Add headers
    
     for (int i = 0; i < columnNames.length; i++) {
         Cell headerCell = createCell(columnNames[i], Border.NO_BORDER, TextAlignment.CENTER).setBold();
         headerCell.setBorderTop(new SolidBorder(1f));
         //headerCell.setBorderBottom(new SolidBorder(1f));

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
		        int noOfBales = ((Number) row[3]).intValue(); 
		        float nominalWt = ((Number) row[4]).floatValue(); 
		        float rate = ((Number) row[5]).floatValue();  
		        float nominalQty = ((Number) row[6]).floatValue(); 
		         strNoOfBales = String.valueOf(noOfBales);
		        strNominalWt = String.valueOf(nominalWt);
		         strRate = String.valueOf(rate);
		        strNominalQty = String.valueOf(nominalQty);

	        
	    }
		
  // Iterate over dispatchList data
     float totalqty1=0;
     float totalqty2=0;
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
                 cellData = Jute_variety; 
             } else if (j == 6) {
                 // NO OF BALES
                 cellData = strNoOfBales;
             } else if (j == 7) {
                 // NOMINAL WT./BALE
                 cellData = strNominalWt;
             } else if (j == 8) {
                 // UNIT
                 cellData = "Qtls."; 
                
             } else if (j == 9) {
                 // RATE (RS/UNIT)
                 cellData = strRate;
             } else if (j == 10) {
                 // QTY
                 cellData = strNominalQty;
                 float rate1=Float.parseFloat(strNominalQty);
                 totalqty1+=rate1;
             } else if (j == 11) {
                 // TOTAL
            	 float rate=Float.parseFloat(strRate);
            	 float rate1=Float.parseFloat(strNominalQty);
            	 float total=rate*rate1;
            	 String stringValue = Float.toString(total);
            	 
            	 cellData = stringValue ; 
            	 float rate3=Float.parseFloat(stringValue);
            	 totalqty2+=rate3;
             } 
          
          
           else {
                 cellData = "N/A";
             }

             Cell cell = createCell(cellData, Border.NO_BORDER, TextAlignment.CENTER);

             cell.setBorderTop(new SolidBorder(1f));
             //cell.setBorderBottom(new SolidBorder(1f));
             cell.setBorderLeft(new SolidBorder(1f));

             if (j < columnNames.length - 1) {
                 cell.setBorderRight(new SolidBorder(1f));
             }

             contentTable11.addCell(cell);
         }
     }
     document.add(contentTable11);
     
     
     float columnWidth7 = PageSize.A4.getWidth() * 0.9f;
     float columnWidth8 = PageSize.A4.getWidth() * 0.1f;
     Table contentTable35 = new Table(new float[]{columnWidth7,columnWidth8})
		        .setBorder(new SolidBorder(borderWidth)).setFont(boldFont);
     
     
    
   
  //float minimumHeight = 20f;
	Cell cell11371 = createCell("TCS U/S 206C(1H) @ 0.1 %", Border.NO_BORDER, TextAlignment.CENTER);
	cell11371.setBorderRight(new SolidBorder(borderWidth));

	cell11371.setFont(boldFont);
	cell11371.setHeight(minimumHeight);
	contentTable35.addCell(cell11371);
	Cell cell11372 = createCell("", Border.NO_BORDER, TextAlignment.CENTER);
	cell11372.setBorderRight(new SolidBorder(borderWidth));
	
	cell11372.setFont(boldFont);
	contentTable35.addCell(cell11372);


	document.add(contentTable35);
	
	
	 float columnWidth4 = PageSize.A4.getWidth() * 0.8f;
     float columnWidth5 = PageSize.A4.getWidth() * 0.1f;
     float columnWidth6 = PageSize.A4.getWidth() * 0.1f;
	 
	Table contentTable36 = new Table(new float[]{columnWidth4,columnWidth5,columnWidth6})
	        .setBorder(new SolidBorder(borderWidth)).setFont(boldFont);
 //float minimumHeight = 20f;
	Cell cell11374 = createCell("TOTAL", Border.NO_BORDER, TextAlignment.CENTER);
	cell11374.setBorderRight(new SolidBorder(borderWidth));
	cell11374.setBorderBottom(new SolidBorder(borderWidth));
	//cell11374.setBorderTop(new SolidBorder(borderWidth));
	cell11374.setFont(boldFont);
	cell11374.setHeight(minimumHeight);
	contentTable36.addCell(cell11374);
	
	
	String stringValue1 = Float.toString(totalqty1);
	
	Cell cell11375 = createCell( stringValue1, Border.NO_BORDER, TextAlignment.CENTER);
	cell11375.setBorderRight(new SolidBorder(borderWidth));
	cell11375.setBorderBottom(new SolidBorder(borderWidth));
	//cell11375.setBorderTop(new SolidBorder(borderWidth));
	cell11375.setFont(boldFont);

	cell11375.setHeight(minimumHeight);
	
	contentTable36.addCell(cell11375);
	
	String stringValue2 = Float.toString(totalqty2);
	Cell cell11376 = createCell(stringValue2, Border.NO_BORDER, TextAlignment.LEFT);
	cell11376.setBorderRight(new SolidBorder(borderWidth));
	cell11376.setBorderBottom(new SolidBorder(borderWidth));
	cell11376.setFont(boldFont);
	cell11376.setHeight(minimumHeight);
	contentTable36.addCell(cell11376);

	document.add(contentTable36);
 ConvertWord_k convertWord_k = new ConvertWord_k();
	double invoiceDouble = Double.parseDouble(Invoice_Value); // Parse String to double
    int convertInt = (int) invoiceDouble;
	String InvoiceNO = convertWord_k.convertToWords(convertInt);
	
    String staticTextBefore = "Invoice value in words : ";
    String staticTextMid = " Rupees";
    String staticTextAfter = " Only";
   
     Paragraph dynamicParagraph = new Paragraph()
             .add(new Text(staticTextBefore).setBold())
             .add( new Text(staticTextMid).setUnderline())
             .add( new Text(InvoiceNO).setUnderline())
             .add( new Text(staticTextAfter).setUnderline());
            
    document.add(dynamicParagraph);
  
    Paragraph spacingParagraph12 = new Paragraph("\n\n").setFixedLeading(10f); 
    document.add(spacingParagraph12);
 
  
  float columnWidth11 = PageSize.A4.getWidth() * 0.7f;
  Table contentTable22 = new Table(new float[]{columnWidth11})
	        .setBorder(new SolidBorder(borderWidth)).setFont(boldFont);

  
	Cell cell1122 = createCell("DETAILS OF TRANSPORTER", Border.NO_BORDER, TextAlignment.LEFT);
	cell1122.setBorderRight(new SolidBorder(borderWidth));
	cell1122.setBorderBottom(new SolidBorder(borderWidth));
	cell1122.setBorderTop(new SolidBorder(borderWidth));
	cell1122.setFont(boldFont);
	contentTable22.addCell(cell1122);
	
	Cell cell11223 = createCell("", Border.NO_BORDER, TextAlignment.LEFT);
	cell11223.setBorderRight(new SolidBorder(borderWidth));
	//cell11223.setBorderTop(new SolidBorder(borderWidth));
	Paragraph paragraph224 = new Paragraph()
	        .add(new Text("TRANSIT POLICY NO :").setFont(boldFont))
	        .add(new Text(supplier_GSTN).setFont(normalFont));
	cell11223.add(paragraph224);
    contentTable22.addCell(cell11223);
    
    Cell cell11224 = createCell("", Border.NO_BORDER, TextAlignment.LEFT);
    cell11224.setBorderRight(new SolidBorder(borderWidth));
    //cell11224.setBorderTop(new SolidBorder(borderWidth));
	Paragraph paragraph225 = new Paragraph()
	        .add(new Text("TRANSPORTER NAME:").setFont(boldFont))
	        .add(new Text(supplier_GSTN).setFont(normalFont));
	cell11224.add(paragraph225);
    contentTable22.addCell(cell11224);
    
    Cell cell11225 = createCell("", Border.NO_BORDER, TextAlignment.LEFT);
    cell11225.setBorderRight(new SolidBorder(borderWidth));
    //cell11225.setBorderTop(new SolidBorder(borderWidth));
	Paragraph paragraph226 = new Paragraph()
	        .add(new Text("TRUCK NO & DRIVER LIC NO :").setFont(boldFont))
	        .add(new Text(supplier_GSTN).setFont(normalFont));
	cell11225.add(paragraph226);
    contentTable22.addCell(cell11225);
    document.add(contentTable22);
 
    Paragraph spacingParagraph123 = new Paragraph("\n\n\n").setFixedLeading(10f); 
    document.add(spacingParagraph123);
   
    
    
    
    float columnWidth64 = PageSize.A4.getWidth() * 0.5f;
    float columnWidth65 = PageSize.A4.getWidth() * 0.5f;

    Table contentTable364 = new Table(new float[]{columnWidth64,columnWidth65})
	        .setFont(boldFont);
   
    
    Cell cell3164 = createCell("", Border.NO_BORDER, TextAlignment.CENTER);
   
	Paragraph paragraph345 = new Paragraph()
	        .add(new Text("Driver's Name :").setFont(boldFont))
	        .add(new Text("").setFont(normalFont));
	cell3164.add(paragraph345);
    contentTable364.addCell(cell3164);
	

//	
	Cell cell3165 = createCell("", Border.NO_BORDER, TextAlignment.CENTER);

	Paragraph paragraph2354 = new Paragraph()
	        .add(new Text("Signature (I/C):").setFont(boldFont))
	        .add(new Text("").setFont(normalFont));
	cell3165.add(paragraph2354);
    contentTable364.addCell(cell3165);
    
    
    document.add(contentTable364);
    
    
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
	
	




	private static String generateTimestamp() {
	        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd_HHmmssSSS");
	        return dateFormat.format(new Date(0));
	    }
	private Cell createHeaderCell(String content, Border border, TextAlignment alignment) {
	    Paragraph paragraph = new Paragraph(content)
	            .setBorder(border)
	            .setTextAlignment(alignment)
	            .setFontSize(12)  
	            .setBold();  

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
                .setMarginBottom(5); // Adjust margin as needed
    }
   
	 
	

}
	
   