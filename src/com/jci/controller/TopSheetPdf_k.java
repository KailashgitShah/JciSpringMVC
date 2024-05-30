
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


public class TopSheetPdf_k {
	public String generatePdfReport( List<Object[]> list1) throws FileNotFoundException {
		 
		String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date(0));
	     String fileName = "generatedfile_" + timestamp + ".pdf";

	     String filePath = "C:\\Users\\kailash.shah\\Topsheet\\" + fileName;
	     //String filePath = "C:\\Program Files\\Apache Software Foundation\\Tomcat 8.5\\webapps\\JCIStuff\\documentimage" + fileName;
	     
	 	
	     
	     PdfWriter pdfWriter = new PdfWriter(filePath);
            PdfDocument pdfDocument = new PdfDocument(pdfWriter);       
 try {
	 pdfDocument.setDefaultPageSize(PageSize.A4);
	  PdfFont boldFont = PdfFontFactory.createFont(FontConstants.HELVETICA_BOLD);
      Document document = new Document(pdfDocument);
	  document.setMargins(2, 4, 4, 2);
		addHeader(document, filePath, filePath, filePath);
		float columnWidth = PageSize.A4.getWidth() * 1.0f;
		float borderWidth = 1.0f; 
		Table contentTable1 = new Table(new float[]{columnWidth});
		Cell cell1199 = createCell("THE JUTE CORPORATION OF INDIA LIMITED", Border.NO_BORDER, TextAlignment.CENTER);
		contentTable1.addCell(cell1199);

        Cell cell1198 = createCell("(A Government of India Enterprise)", Border.NO_BORDER, TextAlignment.CENTER);
        contentTable1.addCell(cell1198);
      

        Cell cell1197 = createCell("15N, NELLIE SENGUPTA SARANI", Border.NO_BORDER, TextAlignment.CENTER)
                .setPaddingBottom(2f); 
        contentTable1.addCell(cell1197);

        Cell cell1196 = createCell("KOLKATA - 700 087", Border.NO_BORDER, TextAlignment.CENTER)
                .setPaddingBottom(2f);
        contentTable1.addCell(cell1196);

        
        Paragraph spacingParagraph = new Paragraph("\n\n").setFixedLeading(10f); 
        document.add(spacingParagraph);
        // Row 3
        Cell cell1195 = createCell("BILL OF SUPPLY TOP SHEET DATED 25-01-2024", Border.NO_BORDER, TextAlignment.CENTER)
                .setPaddingBottom(2f).setFont(boldFont); 
        contentTable1.addCell(cell1195);

        
        Paragraph spacingParagraph1 = new Paragraph("\n").setFixedLeading(10f); 
        document.add(spacingParagraph1);
        
        Cell cell1194 = createCell("Mill Name: The Empire Jute Co. Ltd.,", Border.NO_BORDER, TextAlignment.CENTER)
                .setPaddingBottom(2f); 
        contentTable1.addCell(cell1194);

        // Row 4
        
        Paragraph spacingParagraph2 = new Paragraph("\n").setFixedLeading(10f); 
        document.add(spacingParagraph2);
        Cell cell1193 = createCell("LC/Cheque/RTGS No: RTGS-KVBLR52024010999486377      Dated:09/01/2024", Border.NO_BORDER, TextAlignment.CENTER)
                .setPaddingBottom(2f); 
        contentTable1.addCell(cell1193);

      

        document.add(contentTable1);
    
        document.add(spacingParagraph);
        PdfFont normalFont = PdfFontFactory.createFont(FontConstants.HELVETICA);
        
        String[] columnNames = {"MILL CODE", "CONTRACT NO", "HO_DI NO", "HO_DI DATE",  "DATE OF SHIPMENT","BILL OF SUPPLY NO", "QUANTITY", "BILL OF SUPPLY AMMOUNT"};
        float[] columnWidths = {0.125f,0.125f,0.125f,0.125f,0.125f,0.125f,0.125f,0.125f,};
      
        
        
        
        Table contentTable11 = new Table(columnWidths).setBorder(new SolidBorder(2f));

      
       
        for (int i = 0; i < columnNames.length; i++) {
            Cell headerCell = createCell(columnNames[i], Border.NO_BORDER, TextAlignment.CENTER).setBold();
            headerCell.setBorderTop(new SolidBorder(1f));
            //headerCell.setBorderBottom(new SolidBorder(1f));

            if (i < columnNames.length - 1) {
                headerCell.setBorderRight(new SolidBorder(1f));
            }

            contentTable11.addHeaderCell(headerCell);
          
        }
       
        
        String millcode = "";
        String contractno = "";
        String hodino = "";
        String hodidate = "";
        String dtaeofshipment = "";
        String billofsupplyno = "";
        String Quantity = "";
        String billofsupplyamount = "";
        
        for (Object[] row : list1) {
        	millcode = (String) row[0];
			 
        	contractno = (String) row[1];
		     
        	hodino = (String) row[2];
		       
        	hodidate = (String) row[3];
		        
        	dtaeofshipment = (String) row[0];
			 
        	billofsupplyno = (String) row[1];
		     
        	Quantity = (String) row[2];
		       
        	billofsupplyamount = (String) row[3];
//		        int dtaeofshipment = ((Number) row[4]).intValue(); 
//		        
//		        float billofsupplyno = ((Number) row[5]).floatValue();
//		        
//		        float Quantity = ((Number) row[6]).floatValue(); 
//		      
//		        float billofsupplyamount = ((Number) row[7]).floatValue(); 
//		       
//		         strNoOfBales = String.valueOf(noOfBales);
//		        strNominalWt = String.valueOf(nominalWt);
//		         strRate = String.valueOf(rate7);
//		        strNominalQty = String.valueOf(nominalQty);

        for (int j = 0; j < columnNames.length; j++) {
            String cellData;
            if (j == 0) {
                // SI NO
           	 cellData =millcode ;
            } else if (j == 1) {
                // HSN
                cellData = contractno;
            } else if (j == 2) {
                // DESCRIPTION
                cellData = hodino;
            } else if (j == 3) {
                // CROP YEAR
                cellData = hodidate;
               
            } else if (j == 4) {
                // BALE MARK
                cellData = dtaeofshipment;
            } else if (j == 5) {
                // VARIETY/GRADE
                cellData = billofsupplyno; 
            }
            else if (j == 6) {
                // NO OF BALES
                cellData = Quantity;
            }else if (j == 7) {
                // NO OF BALES
                cellData = billofsupplyamount;
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
  return filePath;

   
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
	    document.add(createUnderlinedParagraph(""));
	}


 
	    
	 // Create a cell with left-aligned and right-aligned paragraphs
	

    private Paragraph createUnderlinedParagraph(String staticValue) {
        return new Paragraph(staticValue)
                .setBold()
                .setUnderline()
                .setTextAlignment(TextAlignment.CENTER)
                .setMarginBottom(5); // Adjust margin as needed
    }
   
	public String BOE() throws DocumentException, IOException {
		String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date(0));
	     String fileName = "generatedfile_" + timestamp + ".pdf";

	     String filePath = "C:\\Users\\kailash.shah\\Topsheet\\BOE\\" + fileName;
	     
	     
         PdfWriter pdfWriter = new PdfWriter(filePath);
         PdfDocument pdfDocument = new PdfDocument(pdfWriter);       
try {
	 pdfDocument.setDefaultPageSize(PageSize.A4);
	  PdfFont boldFont = PdfFontFactory.createFont(FontConstants.HELVETICA_BOLD);
   Document document = new Document(pdfDocument);
	  document.setMargins(5, 5, 5, 5);
		addHeader(document, filePath, filePath, filePath);
		float columnWidth = PageSize.A4.getWidth() * 0.6f;
		float columnWidth1 = PageSize.A4.getWidth() * 0.4f;
		float borderWidth = 1.0f; 
		Table contentTable1 = new Table(new float[]{columnWidth, columnWidth1});
		Cell cell1199 = createCell("THE JUTE CORPORATION OF INDIA LIMITED", Border.NO_BORDER, TextAlignment.RIGHT).setFont(boldFont);
		contentTable1.addCell(cell1199);
		
		  Cell cell1198 = createCell("PHONE : 2252-6720 / 6951 / 6770-74 / 6777-79", Border.NO_BORDER, TextAlignment.RIGHT).setFont(boldFont);
		     contentTable1.addCell(cell1198);
		
		 Cell cell1197 = createCell("", Border.NO_BORDER, TextAlignment.RIGHT)
	             .setPaddingBottom(2f).setFont(boldFont); 
	     contentTable1.addCell(cell1197);
	     
	     Cell cell1196 = createCell("GRAM : JUTECORPIND", Border.NO_BORDER, TextAlignment.RIGHT)
	             .setPaddingBottom(2f).setFont(boldFont);
	     contentTable1.addCell(cell1196);
	     
	     // Row 3
	     Cell cell1195 = createCell("Registered Office", Border.NO_BORDER, TextAlignment.RIGHT)
	             .setPaddingBottom(2f).setFont(boldFont); 
	     contentTable1.addCell(cell1195);
	     
	     

	     Cell cell1194 = createCell("FAX NO : 91-033-2252-1771", Border.NO_BORDER, TextAlignment.RIGHT)
	             .setPaddingBottom(2f).setFont(boldFont); 
	     contentTable1.addCell(cell1194);

	     // Row 5
	     Cell cell1191 = createCell("15N, NELLIE SENGUPTA SARANI", Border.NO_BORDER, TextAlignment.RIGHT)
	             .setPaddingBottom(2f).setFont(boldFont); 
	     contentTable1.addCell(cell1191);
	     
	     


	     Cell cell1192 = createCell("E-MAIL : jci@jcimail.in", Border.NO_BORDER, TextAlignment.RIGHT)
	             .setPaddingBottom(2f).setFont(boldFont); 
	     contentTable1.addCell(cell1192);

	     // Row 4
	     Cell cell1193 = createCell("Kolkata - 700 087", Border.NO_BORDER, TextAlignment.RIGHT)
	             .setPaddingBottom(2f).setFont(boldFont); 
	     contentTable1.addCell(cell1193);
	     

     Cell cell1190 = createCell("WEBSITE : www.jutecorp.in", Border.NO_BORDER, TextAlignment.RIGHT)
             .setPaddingBottom(2f).setFont(boldFont); 
     contentTable1.addCell(cell1190);

     document.add(contentTable1);
     Paragraph spacingParagraph = new Paragraph("\n").setFixedLeading(10f); 
     document.add(spacingParagraph);
     PdfFont normalFont = PdfFontFactory.createFont(FontConstants.HELVETICA);
     Table contentTable = new Table(new float[]{columnWidth, columnWidth1})
		        .setBorder(new SolidBorder(borderWidth)).setFont(boldFont);
    
		
		Cell cell21 = createCell("DETAILS OF  RECIEPIENTS", Border.NO_BORDER, TextAlignment.LEFT);
		cell21.setBorderRight(new SolidBorder(borderWidth));
		cell21.setBorderBottom(new SolidBorder(borderWidth));
		cell21.setBorderTop(new SolidBorder(borderWidth));
		contentTable.addCell(cell21);

		
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
			        .add(new Text("").setFont(normalFont));
			cell71.add(paragraph11);
	        contentTable.addCell(cell71);
		
		

		Cell cell72 = createCell("", Border.NO_BORDER, TextAlignment.LEFT);
		cell72.setBorderRight(new SolidBorder(borderWidth));
		cell72.setBorderTop(new SolidBorder(borderWidth));
			Paragraph paragraph12 = new Paragraph()
			        .add(new Text("GSTIN : ").setFont(boldFont))
			        .add(new Text("").setFont(normalFont));
			cell72.add(paragraph12);
	        contentTable.addCell(cell72);

		Cell cell73 = createCell("", Border.NO_BORDER, TextAlignment.LEFT);
		cell73.setBorderRight(new SolidBorder(borderWidth));
		
			Paragraph paragraph13 = new Paragraph()
			        .add(new Text("NAME : ").setFont(boldFont))
			        .add(new Text("").setFont(normalFont));
			cell73.add(paragraph13);
	        contentTable.addCell(cell73);
		 
	        Cell cell74 = createCell("", Border.NO_BORDER, TextAlignment.LEFT);
		cell74.setBorderRight(new SolidBorder(borderWidth));
		
			Paragraph paragraph14 = new Paragraph()
			        .add(new Text("NAME : ").setFont(boldFont))
			        .add(new Text("").setFont(normalFont));
			cell74.add(paragraph14);
	        contentTable.addCell(cell74);
	
		
		Cell cell75 = createCell("", Border.NO_BORDER, TextAlignment.LEFT);
		cell75.setBorderRight(new SolidBorder(borderWidth));
		
			Paragraph paragraph15 = new Paragraph()
			        .add(new Text("ADDRESS : ").setFont(boldFont))
			        .add(new Text("").setFont(normalFont));
			cell75.add(paragraph15);
	        contentTable.addCell(cell75);

		
		Cell cell76 = createCell("", Border.NO_BORDER, TextAlignment.LEFT);
		cell76.setBorderRight(new SolidBorder(borderWidth));
		
			Paragraph paragraph16 = new Paragraph()
			        .add(new Text("ADDRESS : ").setFont(boldFont))
			        .add(new Text("").setFont(normalFont));
			cell76.add(paragraph16);
	        contentTable.addCell(cell76);
		
		

		
		Cell cell77 = createCell("", Border.NO_BORDER, TextAlignment.LEFT);
		cell77.setBorderRight(new SolidBorder(borderWidth));
		
			Paragraph paragraph17 = new Paragraph()
			        .add(new Text("STATE NAME : ").setFont(boldFont))
			        .add(new Text("").setFont(normalFont));
			cell77.add(paragraph17);
	        contentTable.addCell(cell77);


		
		
		Cell cell78 = createCell("", Border.NO_BORDER, TextAlignment.LEFT);
		cell78.setBorderRight(new SolidBorder(borderWidth));
		
			Paragraph paragraph18 = new Paragraph()
			        .add(new Text("STATE NAME : ").setFont(boldFont))
			        .add(new Text("").setFont(normalFont));
			cell78.add(paragraph18);
	        contentTable.addCell(cell78);
	    Cell cell778 = createCell("", Border.NO_BORDER, TextAlignment.LEFT);
		cell778.setBorderRight(new SolidBorder(borderWidth));
		
			Paragraph paragraph19 = new Paragraph()
			        .add(new Text("STATE CODE : ").setFont(boldFont))
			        .add(new Text("").setFont(normalFont));
			cell778.add(paragraph19);
	        contentTable.addCell(cell778);
	        

	        
	        Cell cell776 = createCell("", Border.NO_BORDER, TextAlignment.LEFT);
	        cell776.setBorderRight(new SolidBorder(borderWidth));
			
				Paragraph paragraph20 = new Paragraph()
				        .add(new Text("STATE CODE : ").setFont(boldFont))
				        .add(new Text("").setFont(normalFont));
				cell776.add(paragraph20);
		        contentTable.addCell(cell776);
		        
		        

		
		  Cell cell775 = createCell("", Border.NO_BORDER, TextAlignment.LEFT);
		  cell775.setBorderRight(new SolidBorder(borderWidth));
			
				Paragraph paragraph21 = new Paragraph()
				        .add(new Text("PAN : ").setFont(boldFont))
				        .add(new Text("").setFont(normalFont));
				cell775.add(paragraph21);
		        contentTable.addCell(cell775);

		Cell cell774 = createCell("", Border.NO_BORDER, TextAlignment.RIGHT);
		cell774.setBorderLeft(new SolidBorder(borderWidth));
		
		contentTable.addCell(cell774);
		        
		document.add(contentTable);
		
		
 
 
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

return filePath;
		

	}
 
	

}
	
   