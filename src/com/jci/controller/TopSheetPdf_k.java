
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
	     //String filePath = "C:\\Program Files\\Apache Software Foundation\\Tomcat 8.5\\webapps\\BillofSupply" + fileName;
	     
	 	
	     
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
   
	 
	

}
	
   