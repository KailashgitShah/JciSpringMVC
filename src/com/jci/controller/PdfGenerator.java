package com.jci.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.time.Month;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;

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
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.IBlockElement;
import com.itextpdf.layout.element.Image;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Tab;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.element.Text;
import com.itextpdf.layout.property.TextAlignment;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Font;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.BaseFont;
import com.lowagie.text.pdf.GrayColor;

public class PdfGenerator {

              public void generatePdfOfContractLetter(String contractNo, String millNameString, String millCode, Double qty,
                                           String cropyear, List<Object[]> priceList, List<String> compList, List<String> varietyArray,
                                           String deliveryType, String contractDate, String filePath, String letterHeadPath,
                                           List<Object> fullAddress, String pcsoDates,String refNos) throws DocumentException, IOException {

                             PdfWriter pdfWriter = new PdfWriter(filePath);
                             
                             System.err.println(filePath);
                             System.err.println(filePath);
                             PdfDocument pdfDocument = new PdfDocument(pdfWriter);

                             pdfDocument.setDefaultPageSize(PageSize.A4);

                             Document document = new Document(pdfDocument);
                             document.setMargins(0, document.getLeftMargin(), document.getBottomMargin(), document.getRightMargin());
                             float fullWidth = PageSize.A4.getWidth();
                             float equalThreeColumWidth = fullWidth / 3f;
                             float columnHalfWidth = fullWidth * 0.5f;
                             float columnWidth60 = fullWidth * 0.60f;
                             float columnWidth20 = fullWidth * 0.20f;
                             float widthOfTwoColumn[] = { columnHalfWidth * 0.7f, columnHalfWidth * 0.77f };
                             float widthOfThreeCoulmn[] = { columnWidth60, columnWidth20, columnWidth20 };
                             float widthOfThreeEqualCoulmn[] = { equalThreeColumWidth, equalThreeColumWidth, equalThreeColumWidth };

                             String add1 = "";
                             String add2 = "";
                             String areaAndpincode = "";

                             for (Object details : fullAddress) {
                                           Object[] row = (Object[]) details;
                                           add1 = row[0] + "";
                                           add2 = row[1] + "";
                                           areaAndpincode = row[2] + "-" + row[3];
                             }

//                         System.err.println(add1);
//                         System.err.println(add2);
//                         System.err.println(areaAndpincode);
//                         
//                         System.err.println(add1);
//                         System.err.println(add2);
//                         System.err.println(areaAndpincode);

                             Table table = new Table(widthOfTwoColumn);

                             Image letterHead = new Image(ImageDataFactory.create(letterHeadPath));

                             table.addCell(new Cell().add(new Paragraph().add(new Text("No, ").setBold()).add(new Text(contractNo)))
                                                     .setBorder(Border.NO_BORDER).setTextAlignment(TextAlignment.LEFT));

                             table.addCell(new Cell().add(new Paragraph().add(new Text("Date : "))).setBold().setBorder(Border.NO_BORDER))
                                                          .setTextAlignment(TextAlignment.RIGHT);

                             Color grayColor = new DeviceGray(0.5f);
                             Color Black = new DeviceGray(0f);

                             table.addCell(new Cell()
                                                          .add(new Paragraph().add(new Text("To, ").setBold().setFontColor(Black)).add(new Text(millNameString))
                                                                                      .add("\n").add(new Text(add1)).add("\n").add(new Text(add2)).add("\n")
                                                                                      .add(new Text(areaAndpincode)).setFontColor(grayColor))
                                                          .add(new Paragraph()).setBorder(Border.NO_BORDER).setTextAlignment(TextAlignment.LEFT));

                             Paragraph subHeading = new Paragraph(new Text("Sub : ").setBold())
                                                          .add(new Text("Sale of raw jute under B.Twill Linkage sale").setUnderline())
                                                         .setTextAlignment(TextAlignment.CENTER).setMarginTop(15);

                             Paragraph RefParagraph = new Paragraph(new Text("Ref No : ").setBold()).add(refNos)
                                                          .add(new Text(" dt. "))
                                                          .add(pcsoDates)
                                                          .add(" of Dy. Director (Mktg), Office of the Jute Commissioner(MoT), Kolkata against PCO dtd. ")
                                                  .add(pcsoDates).setUnderline().setTextAlignment(TextAlignment.CENTER);

                             Paragraph messageParagraph = new Paragraph().add("Dear Sir(s)").add("\n")
                                                          .add("We have this day sold to you " + (int) Math.round(qty)
                                                                                      + " quintals of raw jute / Mesta under linkage of " + cropyear
                                                                                      + " Crop of the following variety and grades at prices and terms and conditions specified .")
                                                          .add("\n").add("The details of sale is as under : ");

                             Paragraph innerParagraph = new Paragraph().add(new Text(deliveryType).setBold())
                                                          .setBorderBottom(new SolidBorder(1)).setWidth(columnWidth20).setTextAlignment(TextAlignment.CENTER);

                             Paragraph deliveryTypeParagraph = new Paragraph().setTextAlignment(TextAlignment.RIGHT);
                             deliveryTypeParagraph.add(innerParagraph);

                             Table distributionTable = new Table(widthOfThreeCoulmn).setMargin(10f);
                             distributionTable.addCell(new Cell().add("Jute Variety").setBold()).setTextAlignment(TextAlignment.CENTER);
                             distributionTable.addCell(new Cell().add("Quantity (Qtls.)").setBold()).setTextAlignment(TextAlignment.CENTER);
                             distributionTable.addCell(new Cell().add("Price (Rs./Qtl.)").setBold()).setTextAlignment(TextAlignment.CENTER);

                             int totalCompositionInt = 0;
                             double totalContractedprice = 0.0;
                             for (int i = 0; i < compList.size(); i++) {
                                           Double rObject1 = Double.parseDouble(compList.get(i));
                                           Object[] rObject2 = priceList.get(0);
            System.err.println("grade"+i+1 + " ");
                                           Double composition = (rObject1 / 100) * qty; // Qty in Qtls
                                           Double priceDouble = ((BigDecimal) rObject2[i]).doubleValue();
                                           totalContractedprice += composition * priceDouble;
                                           System.err.println("composition " + composition);
                                           System.err.println("gradePrice " + priceDouble);
                                           System.err.println("Amount of grade " + priceDouble);

                                           int compositionInt = (int) Math.round(composition);
                                           totalCompositionInt += compositionInt;
                                           distributionTable.addCell(new Cell().add(varietyArray.get(i) + "")).setTextAlignment(TextAlignment.CENTER);
                                           distributionTable.addCell(new Cell().add(compositionInt + "").setTextAlignment(TextAlignment.CENTER));

                                           distributionTable.addCell(new Cell().add("##.##").setTextAlignment(TextAlignment.CENTER));
                             }

                             int finalPrice = (int) totalContractedprice;

                             distributionTable.addCell(new Cell().add("Total").setBold());
                             distributionTable.addCell(new Cell().add(totalCompositionInt + "").setBold());
                             distributionTable.addCell(new Cell().add(" Rs " + finalPrice));
                             
                             System.err.println("Total " + finalPrice);

                             Paragraph footer = new Paragraph("2252-7027 / 7028 / 6952 / 6779 / 6770 / 6773 / 7108 / 6776")
                                                         .setTextAlignment(TextAlignment.CENTER).setFontSize(10);
                             Table footerTable = new Table(widthOfThreeEqualCoulmn).setBorder(Border.NO_BORDER);

                             footerTable.addCell(new Cell().add(new Paragraph("E-mail : jci@jcimail.in")).setBold()
                                           .setBorder(Border.NO_BORDER).setFontSize(8)).setMarginLeft(0).setTextAlignment(TextAlignment.LEFT);
                             footerTable.addCell(
                                                          new Cell().add(new Paragraph().add(new Text("Fax : ").setBold()).add(" 91-033-2252-1771 / 6890 / 6951"))
                                                                                      .setBorder(Border.NO_BORDER).setFontSize(8));

                             footerTable
                                                          .addCell(new Cell().add(new Paragraph().add(new Text("Website : ").setBold()).add(" www.jutecorp.in"))
                                                                                      .setBorder(Border.NO_BORDER).setFontSize(8))
                                                          .setTextAlignment(TextAlignment.RIGHT);

                             letterHead.setWidth(PageSize.A4.getWidth());
                             letterHead.setHeight(160);
                             letterHead.setRelativePosition(-23, 0, 0, 0);

                             document.add(letterHead);
                             /* document.add(new Paragraph("\n")); */
                             document.add(table);
                             document.add(subHeading);
                             /* document.add(new Paragraph("\n")); */
                             document.add(RefParagraph);
                             /* document.add(new Paragraph("\n")); */
                             document.add(messageParagraph);
                             document.add(deliveryTypeParagraph);
                             document.add(distributionTable);
                             document.add(new Paragraph("\n"));
                             document.add(new Paragraph("").setBorder(new SolidBorder(Color.GRAY, 1))).setFixedPosition(0,
                                                          PageSize.A4.getHeight(), 1);
                             document.add(footer);
                             document.add(footerTable);

                             document.close();

              }

              public void generatePdfOfRequestLetter(String jciRefNo, String cropyear, String date, String qty, String fileName,
                                           String path, String letterHeadPath, String signaturePath) throws DocumentException, IOException {

                             final File theDir = new File(path);
                             if (!theDir.exists()) {
                                           theDir.mkdirs();
                             }

                             path += "\\" + fileName;

                             String[] dateArray = date.split("-");
                             int monthIdx = Integer.parseInt(dateArray[1]);
                             Month month = Month.values()[monthIdx - 1];
                             String monthString = month.toString();
                             PdfWriter pdfWriter = new PdfWriter(path);
                             PdfDocument pdfDocument = new PdfDocument(pdfWriter);

                             pdfDocument.setDefaultPageSize(PageSize.A4);

                             Document document = new Document(pdfDocument);
                             document.setMargins(0, document.getLeftMargin(), document.getBottomMargin(), document.getRightMargin());

                             float fullWidth = PageSize.A4.getWidth();
                             float columnHalfWidth = fullWidth * 0.5f;
                             float columnWidth60 = fullWidth * 0.60f;
                             float columnWidth20 = fullWidth * 0.20f;
                             float widthOfTwoColumn[] = { columnHalfWidth, columnHalfWidth };
                             float widthOfHeader[] = { columnWidth20, columnWidth60, columnWidth20 };

                             Image letterHead = new Image(ImageDataFactory.create(letterHeadPath));
                             Image signature = new Image(ImageDataFactory.create(signaturePath));

                             signature.setWidth(140);
                             signature.setHeight(60);
                             signature.setRelativePosition(25, 0, 0, 0);

                             // Setting font of the text

                             Table table = new Table(widthOfTwoColumn);

                             table.addCell(new Cell().add(new Paragraph().add(new Text("Ref.No. ").setBold()).add(new Text(jciRefNo)))
                                                     .setBorder(Border.NO_BORDER).setTextAlignment(TextAlignment.LEFT));

                             table.addCell(new Cell().add(new Paragraph().add(new Text("Date : " + date))).setBold()
                                                  .setBorder(Border.NO_BORDER).setTextAlignment(TextAlignment.RIGHT));

                             Color grayColor = new DeviceGray(0.5f);

                             table.addCell(new Cell()
                                                          .add(new Paragraph().add(new Text(" \n To, ").setBold()).add("\n")
                                                                                      .add(new Text("Dy, Jute Commissioner,\n Ministry of Textiles,"
                                                                                                                   + " \n Government of India, \n CGO Complex, 3rd MSO Building, "
                                                                                                                   + "\n DF Block, E & F Wing, 4th Floor, " + "\n Sector-1 Salt Lake City,"
                                                                                                                   + "\n Kolkata- 700 064.").setFontSize(11))
                                                                                      .setFontColor(grayColor))
                                                     .setTextAlignment(TextAlignment.LEFT).setBorder(Border.NO_BORDER));

                             Paragraph subHeading = new Paragraph(new Text("Sub : ").setBold()).add(new Text(
                                                          "Request for providing B.Twill linkage of raw jute procured under MSP operation for the crop year "
                                                                                      + cropyear + " ."))
                                                         .setTextAlignment(TextAlignment.CENTER).setMarginTop(45);

                             Paragraph RefParagraph = new Paragraph(new Text("Respected sir, \n"));

                             Paragraph messageParagraph = new Paragraph()
                                                          .add("This is to bring to your kind notice for providing linkage of " + qty
                                                                                      + " quintals of raw jute of crop year " + cropyear + " for the month of " + monthString + " "
                                                                                      + dateArray[2] + " so that MSP stock may be liquidated. " + "\n" + "Thanking You ");

                             Table tableForSignature = new Table(widthOfTwoColumn);
                             Paragraph signatueParagraph = new Paragraph().add("Yours faithfully,\n").add(signature)
                                                          .add("\n ( Kalyan Mazumdar ) \n").add("General Manager (Operation & Marketing)")
                                                          .setTextAlignment(TextAlignment.CENTER);

                             tableForSignature.addCell(new Cell().add("").setBorder(Border.NO_BORDER));
                             tableForSignature.addCell(
                                                          new Cell().add(signatueParagraph).setBorder(Border.NO_BORDER).setTextAlignment(TextAlignment.RIGHT));

                             Paragraph copyToParagraph = new Paragraph()
                                                          .add("Copy to : \n" + "\t\t\t1. Shri. Moloy Chandan Ckarabortty (Jute Commissioner), Kolkata. \n");

                             // footer

                             Paragraph footer1 = new Paragraph("Telephone : 91 33 2252 6720/ 7109 / 7107 / 6770")
                                                         .setTextAlignment(TextAlignment.CENTER).setFontSize(10);

                             Paragraph footer2 = new Paragraph("Fax:91-33-2252-1771 | E-mail:jci@jcimail.in | Website:www.jutecorp.in")
                                                         .setTextAlignment(TextAlignment.CENTER).setFontSize(10);

                             letterHead.setWidth(PageSize.A4.getWidth());
                             letterHead.setHeight(160);

                             letterHead.setRelativePosition(-23, 0, 0, 0);

                             document.add(letterHead);
                             document.add(new Paragraph("").setBorder(new SolidBorder(Color.GRAY, 1))).setFixedPosition(0,
                                                          PageSize.A4.getHeight(), 1);
                             document.add(table);

                             document.add(subHeading);
                             document.add(RefParagraph);
                             document.add(messageParagraph);
                             document.add(new Paragraph("\n"));

                             document.add(tableForSignature);

                             document.add(copyToParagraph);
                             document.add(new Paragraph("\n"));
                             document.add(new Paragraph("").setBorder(new SolidBorder(Color.GRAY, 1))).setFixedPosition(0,
                                                          PageSize.A4.getHeight(), 1);
                             document.add(footer1);
                             document.add(footer2);

                             document.close();

              }

              public String generatePdfOfCreditNoteDoc(String crnNo, String crnDate, String Invoice_Value, String challan_No1,
                                           String supplier_Name, String supplier_GSTN, String supplier_Address, String recipient_Name,
                                           String recipient_GSTN, String recipient_Address, String consignee_Name, String consignee_GSTN,
                                           String consignee_Address, String bill_of_Supply, String conract_no, String Clientstate, String Clientcode,
                                           String BOS_Date, String ClientPan, List<Object[]> list, String diNo, String bosNo, String filePath) throws FileNotFoundException {

                             final File theDir = new File(filePath);
                             if (!theDir.exists()) {
                                           theDir.mkdirs();
                             }

                             //String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date(0));
                             String fileName = "creditNote" + challan_No1 + ".pdf";

                             // String filePath = "C:\\Users\\kailash.shah\\documentimage\\" + fileName;
                             String FinalfilePath = filePath + "\\" + fileName;

                             PdfWriter pdfWriter = new PdfWriter(FinalfilePath);
                             PdfDocument pdfDocument = new PdfDocument(pdfWriter);
                             try {
                                           pdfDocument.setDefaultPageSize(PageSize.A4);
                                           PdfFont boldFont = PdfFontFactory.createFont(FontConstants.HELVETICA_BOLD);
                                           Document document = new Document(pdfDocument);
                                           //document.setMargins(5, 5, 5, 5);
                                           //document.setMargins(0, document.getLeftMargin(), document.getBottomMargin(), document.getRightMargin());
                                           addHeader(document, filePath, filePath, filePath);
                                           float columnWidth = PageSize.A4.getWidth() * 0.5f;
                                           float borderWidth = 0.5f;
                                           Table contentTable1 = new Table(new float[] { columnWidth, columnWidth });
                                           Cell cell1199 = createCell("THE JUTE CORPORATION OF INDIA", Border.NO_BORDER, TextAlignment.LEFT)
                                                                        .setFont(boldFont);
                                           contentTable1.addCell(cell1199);

                                           Cell cell1198 = createCell("Phone +91 (033) 2252 6720 / 7109", Border.NO_BORDER, TextAlignment.RIGHT)
                                                                        .setFont(boldFont);
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
                                           Cell cell1193 = createCell("Kolkata - 700 087", Border.NO_BORDER, TextAlignment.LEFT).setPaddingBottom(2f)
                                                                        .setFont(boldFont);
                                           contentTable1.addCell(cell1193);

                                           Cell cell1192 = createCell("", Border.NO_BORDER, TextAlignment.RIGHT).setPaddingBottom(2f)
                                                                        .setFont(boldFont);
                                           contentTable1.addCell(cell1192);

// Row 5
                                           Cell cell1191 = createCell("", Border.NO_BORDER, TextAlignment.LEFT).setPaddingBottom(2f).setFont(boldFont);
                                           contentTable1.addCell(cell1191);

                                           Cell cell1190 = createCell("", Border.NO_BORDER, TextAlignment.RIGHT).setPaddingBottom(2f)
                                                                        .setFont(boldFont);
                                           contentTable1.addCell(cell1190);

                                           document.add(contentTable1);
                                           Paragraph spacingParagraph = new Paragraph("\n").setFixedLeading(10f);
                                           document.add(spacingParagraph);
                                           PdfFont normalFont = PdfFontFactory.createFont(FontConstants.HELVETICA);

                                           Table contentTable = new Table(new float[] { columnWidth, columnWidth })
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
                                           Paragraph paragraph22 = new Paragraph().add(new Text("DETAILS OF  BILL OF SUPPLY :").setFont(boldFont))
                                                                        .add(new Text("").setFont(normalFont));
                                           cell12.add(paragraph22);
                                           contentTable.addCell(cell12);

                                           Cell cell31 = createCell("", Border.NO_BORDER, TextAlignment.LEFT);
                                           cell31.setBorderRight(new SolidBorder(borderWidth));
                                           cell31.setBorderTop(new SolidBorder(borderWidth));
                                           Paragraph paragraph = new Paragraph().add(new Text("GSTIN :").setFont(boldFont))
                                                                        .add(new Text(supplier_GSTN).setFont(normalFont));
                                           cell31.add(paragraph);
                                           contentTable.addCell(cell31);

                                           Cell cell32 = createCell("", Border.NO_BORDER, TextAlignment.LEFT);
                                           cell32.setBorderRight(new SolidBorder(borderWidth));
                                           cell32.setBorderTop(new SolidBorder(borderWidth));
                                           Paragraph paragraph2 = new Paragraph().add(new Text("CONTRACT REF:").setFont(boldFont))
                                                                        .add(new Text(conract_no).setFont(normalFont));
                                           cell32.add(paragraph2);
                                           contentTable.addCell(cell32);

//
                                           Cell cell41 = createCell("", Border.NO_BORDER, TextAlignment.LEFT);
                                           cell41.setBorderRight(new SolidBorder(borderWidth));

                                           Paragraph paragraph3 = new Paragraph().add(new Text("NAME :").setFont(boldFont))
                                                                        .add(new Text(supplier_Name).setFont(normalFont));
                                           cell41.add(paragraph3);
                                           contentTable.addCell(cell41);

                                           Cell cell42 = createCell("", Border.NO_BORDER, TextAlignment.LEFT);
                                           cell42.setBorderRight(new SolidBorder(borderWidth));

                                           Paragraph paragraph4 = new Paragraph().add(new Text("DI REF :").setFont(boldFont))
                                                                        .add(new Text(diNo).setFont(normalFont));
                                           cell42.add(paragraph4);
                                           contentTable.addCell(cell42);

                                           Cell cell51 = createCell("", Border.NO_BORDER, TextAlignment.LEFT);
                                           cell51.setBorderRight(new SolidBorder(borderWidth));

                                           Paragraph paragraph5 = new Paragraph().add(new Text("ADDRESS:").setFont(boldFont))
                                                                        .add(new Text(supplier_Address).setFont(normalFont));
                                           cell51.add(paragraph5);
                                           contentTable.addCell(cell51);

                                           Cell cell52 = createCell("", Border.NO_BORDER, TextAlignment.LEFT);
                                           cell52.setBorderRight(new SolidBorder(borderWidth));

                                           Paragraph paragraph6 = new Paragraph().add(new Text("CHALLAN REF:").setFont(boldFont))
                                                                        .add(new Text(challan_No1).setFont(normalFont));
                                           cell52.add(paragraph6);
                                           contentTable.addCell(cell52);

                                           Cell cell61 = createCell("", Border.NO_BORDER, TextAlignment.LEFT);
                                           cell61.setBorderRight(new SolidBorder(borderWidth));
                                           Paragraph paragraph7 = new Paragraph().add(new Text("STATE NAME:").setFont(boldFont))
                                                                        .add(new Text(Clientstate).setFont(normalFont));
                                           cell61.add(paragraph7);
                                           contentTable.addCell(cell61);

                                           Cell cell62 = createCell("", Border.NO_BORDER, TextAlignment.LEFT);
                                           cell62.setBorderRight(new SolidBorder(borderWidth));
                                           Paragraph paragraph23 = new Paragraph().add(new Text("LC REF(if applicable): not any:").setFont(boldFont))
                                                                        .add(new Text("").setFont(normalFont));
                                           cell62.add(paragraph23);
                                           contentTable.addCell(cell62);

                                           Cell cell661 = createCell("", Border.NO_BORDER, TextAlignment.LEFT);
                                           cell661.setBorderRight(new SolidBorder(borderWidth));

                                           Paragraph paragraph1 = new Paragraph().add(new Text("STATE CODE: ").setFont(boldFont))
                                                                        .add(new Text(Clientcode).setFont(normalFont));
                                           cell661.add(paragraph1);
                                           contentTable.addCell(cell661);

                                           Cell cell662 = createCell("", Border.NO_BORDER, TextAlignment.LEFT);
                                           cell662.setBorderRight(new SolidBorder(borderWidth));

                                           Paragraph paragraph8 = new Paragraph().add(new Text("BILL OF SUPPLY NO: ").setFont(boldFont))
                                                                        .add(new Text(bill_of_Supply).setFont(normalFont));
                                           cell662.add(paragraph8);
                                           contentTable.addCell(cell662);

                                           Cell cell663 = createCell("", Border.NO_BORDER, TextAlignment.LEFT);
                                           cell663.setBorderRight(new SolidBorder(borderWidth));

                                           Paragraph paragraph9 = new Paragraph().add(new Text("PAN : ").setFont(boldFont))
                                                                        .add(new Text(ClientPan).setFont(normalFont));
                                           cell663.add(paragraph9);
                                           contentTable.addCell(cell663);

                                           Cell cell664 = createCell("", Border.NO_BORDER, TextAlignment.LEFT);
                                           cell664.setBorderRight(new SolidBorder(borderWidth));

                                           Paragraph paragraph10 = new Paragraph().add(new Text("BILL OF SUPPLY DATE : ").setFont(boldFont))
                                                                        .add(new Text(BOS_Date).setFont(normalFont));
                                           cell664.add(paragraph10);
                                           contentTable.addCell(cell664);

                                           contentTable.addCell(createCell("", null));

                                           Cell cell6664 = createCell("", Border.NO_BORDER, TextAlignment.LEFT);
                                           cell6664.setBorderLeft(new SolidBorder(borderWidth));

                                           Paragraph paragraph110 = new Paragraph().add(new Text("CREDIT NOTE NO : ").setFont(boldFont))
                                                                        .add(new Text(crnNo).setFont(normalFont));
                                           cell6664.add(paragraph110);
                                           contentTable.addCell(cell6664);

                                           contentTable.addCell(createCell("", null));

                                           Cell cell6665 = createCell("", Border.NO_BORDER, TextAlignment.LEFT);
                                           cell6665.setBorderLeft(new SolidBorder(borderWidth));

                                           Paragraph paragraph111 = new Paragraph().add(new Text("CREDIT NOTE DATE : ").setFont(boldFont))
                                                                        .add(new Text(crnDate).setFont(normalFont));
                                           cell6665.add(paragraph111);
                                           contentTable.addCell(cell6665);

                                           Cell cell21 = createCell("DETAILS OF  RECIEPIENTS", Border.NO_BORDER, TextAlignment.LEFT);
                                           cell21.setBorderRight(new SolidBorder(borderWidth));
                                           cell21.setBorderBottom(new SolidBorder(borderWidth));
                                           cell21.setBorderTop(new SolidBorder(borderWidth));
                                           contentTable.addCell(cell21);

                                           Cell cell22 = createCell("", Border.NO_BORDER, TextAlignment.LEFT);
                                           cell22.setBorderRight(new SolidBorder(borderWidth));
                                           cell22.setBorderTop(new SolidBorder(borderWidth));
                                           Paragraph paragraph24 = new Paragraph().add(new Text("DETAILS OF  CONSIGNEE: ").setFont(boldFont))
                                                                        .add(new Text("").setFont(normalFont));
                                           cell22.add(paragraph24);
                                           contentTable.addCell(cell22);

                                           Cell cell71 = createCell("", Border.NO_BORDER, TextAlignment.LEFT);
                                           cell71.setBorderRight(new SolidBorder(borderWidth));
                                           cell71.setBorderTop(new SolidBorder(borderWidth));
                                           Paragraph paragraph11 = new Paragraph().add(new Text("GSTIN : ").setFont(boldFont))
                                                                        .add(new Text(recipient_GSTN).setFont(normalFont));
                                           cell71.add(paragraph11);
                                           contentTable.addCell(cell71);

                                           Cell cell72 = createCell("", Border.NO_BORDER, TextAlignment.LEFT);
                                           cell72.setBorderRight(new SolidBorder(borderWidth));
                                           cell72.setBorderTop(new SolidBorder(borderWidth));
                                           Paragraph paragraph12 = new Paragraph().add(new Text("GSTIN : ").setFont(boldFont))
                                                                        .add(new Text(consignee_GSTN).setFont(normalFont));
                                           cell72.add(paragraph12);
                                           contentTable.addCell(cell72);

                                           Cell cell73 = createCell("", Border.NO_BORDER, TextAlignment.LEFT);
                                           cell73.setBorderRight(new SolidBorder(borderWidth));

                                           Paragraph paragraph13 = new Paragraph().add(new Text("NAME : ").setFont(boldFont))
                                                                        .add(new Text(recipient_Name).setFont(normalFont));
                                           cell73.add(paragraph13);
                                           contentTable.addCell(cell73);

                                           Cell cell74 = createCell("", Border.NO_BORDER, TextAlignment.LEFT);
                                           cell74.setBorderRight(new SolidBorder(borderWidth));

                                           Paragraph paragraph14 = new Paragraph().add(new Text("NAME : ").setFont(boldFont))
                                                                        .add(new Text(consignee_Name).setFont(normalFont));
                                           cell74.add(paragraph14);
                                           contentTable.addCell(cell74);

                                           Cell cell75 = createCell("", Border.NO_BORDER, TextAlignment.LEFT);
                                           cell75.setBorderRight(new SolidBorder(borderWidth));

                                           Paragraph paragraph15 = new Paragraph().add(new Text("ADDRESS : ").setFont(boldFont))
                                                                        .add(new Text(recipient_Address).setFont(normalFont));
                                           cell75.add(paragraph15);
                                           contentTable.addCell(cell75);

                                           Cell cell76 = createCell("", Border.NO_BORDER, TextAlignment.LEFT);
                                           cell76.setBorderRight(new SolidBorder(borderWidth));

                                           Paragraph paragraph16 = new Paragraph().add(new Text("ADDRESS : ").setFont(boldFont))
                                                                        .add(new Text(consignee_Address).setFont(normalFont));
                                           cell76.add(paragraph16);
                                           contentTable.addCell(cell76);

                                           Cell cell77 = createCell("", Border.NO_BORDER, TextAlignment.LEFT);
                                           cell77.setBorderRight(new SolidBorder(borderWidth));

                                           Paragraph paragraph17 = new Paragraph().add(new Text("STATE NAME : ").setFont(boldFont))
                                                                        .add(new Text(Clientstate).setFont(normalFont));
                                           cell77.add(paragraph17);
                                           contentTable.addCell(cell77);

                                           Cell cell78 = createCell("", Border.NO_BORDER, TextAlignment.LEFT);
                                           cell78.setBorderRight(new SolidBorder(borderWidth));

                                           Paragraph paragraph18 = new Paragraph().add(new Text("STATE NAME : ").setFont(boldFont))
                                                                        .add(new Text(Clientstate).setFont(normalFont));
                                           cell78.add(paragraph18);
                                           contentTable.addCell(cell78);
                                           Cell cell778 = createCell("", Border.NO_BORDER, TextAlignment.LEFT);
                                           cell778.setBorderRight(new SolidBorder(borderWidth));

                                           Paragraph paragraph19 = new Paragraph().add(new Text("STATE CODE : ").setFont(boldFont))
                                                                        .add(new Text(Clientcode).setFont(normalFont));
                                           cell778.add(paragraph19);
                                           contentTable.addCell(cell778);

                                           Cell cell776 = createCell("", Border.NO_BORDER, TextAlignment.LEFT);
                                           cell776.setBorderRight(new SolidBorder(borderWidth));

                                           Paragraph paragraph20 = new Paragraph().add(new Text("STATE CODE : ").setFont(boldFont))
                                                                        .add(new Text(Clientcode).setFont(normalFont));
                                           cell776.add(paragraph20);
                                           contentTable.addCell(cell776);

                                           Cell cell775 = createCell("", Border.NO_BORDER, TextAlignment.LEFT);
                                           cell775.setBorderRight(new SolidBorder(borderWidth));

                                           Paragraph paragraph21 = new Paragraph().add(new Text("PAN : ").setFont(boldFont))
                                                                        .add(new Text(ClientPan).setFont(normalFont));
                                           cell775.add(paragraph21);
                                           contentTable.addCell(cell775);

                                           Cell cell774 = createCell("", Border.NO_BORDER, TextAlignment.RIGHT);
                                           cell774.setBorderLeft(new SolidBorder(borderWidth));

                                           contentTable.addCell(cell774);

                                           document.add(contentTable);

                                           Paragraph spacingParagraph1 = new Paragraph("").setFixedLeading(10f);
                                           document.add(spacingParagraph1);

                                           String[] columnNames = { "SI NO", "HSN", "DESCRIPTION", "CROP YEAR", "BALE MARK", "VARIETY", "NO OF BALES",
                                                                        "NOMINAL WT./BALE", "UNIT", "RATE (RS/UNIT)", "Inv QTY", "Act QTY", "Short_QTY", "TOTAL" };
                                           float[] columnWidths = { 1, 1, 3, 3, 1, 2, 1, 1, 1, 2, 2, 2, 4, 4 };
                                           float totalWidth = 0;
                                           for (float width : columnWidths) {
                                                          totalWidth += width;
                                           }

                                           float columnWidth1 = PageSize.A4.getWidth() * 0.3f;
                                           float columnWidth2 = PageSize.A4.getWidth() * 0.4f;

//float largerFontSize = 14f;

                                           Table contentTable34 = new Table(new float[] { columnWidth1, columnWidth2, columnWidth1 })
                                                                        .setBorder(new SolidBorder(borderWidth)).setFont(boldFont);
                                           float minimumHeight = 20f;
                                           Cell cell1134 = createCell("", Border.NO_BORDER, TextAlignment.LEFT);
                                           cell1134.setBorderRight(new SolidBorder(borderWidth));
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
                                                          Cell headerCell = createCell(columnNames[i], Border.NO_BORDER, TextAlignment.CENTER).setBold().setFontSize(6f);
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
                                           String Jute_grade = "";
                                           String strNominalQty = "";
                                           
                                           
              

                                           int total = 0;
                                           double totalActQty = 0;
                                           double totalInvQty = 0;
                                           double totalShortQty = 0;
                             
                                           for (int i = 0; i < list.size(); i++) {
                                                          
                                                          Object[] row = list.get(i);

                                                          //Object gradeObject = gradeRatio.get(i);

                                                          //double perticularShortQty = (Double) gradeObject * shortQty;
                                                          cropYear = (String) row[0];
                                                          baleMark = (String) row[1];
                                                          Jute_grade = (String) row[2];
                                                          int noOfBales = (int) row[3];
                                                          Double nominalQty = (Double) row[4];
                                                          Double rate = (Double) row[5];
                                                          Double nominalWt = (Double) row[6];
                                                          Double actwt = (Double) row[8];
                                                          Double shrtWt = (Double) row[9];
                                                          double amt = (double) row[10];
                             
                                                          
                                                          strNoOfBales = String.valueOf(noOfBales);
                                                          strNominalQty = String.valueOf(nominalQty);
                                                          
//                                                      System.err.println("cropYear: " + cropYear + ", baleMark: " + baleMark +
//                                            ", Jute_grade: " + Jute_grade + ", noOfBales: " + noOfBales +
//                                            ", nominalQty: " + nominalQty + ", rate: " + rate +
//                                            ", nominalWt: " + nominalWt + ", actwt: " + actwt +
//                                            ", shrtWt: " + shrtWt + ", amt: " + amt);
//                         
                                                          

                                                          for (int j = 0; j < columnNames.length; j++) {
                                                          
                                                                        String cellData;
                                                                        if (j == 0) {
// SI NO
                                                                                      cellData = (i + 1) + "";
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
                                                                                      cellData = Jute_grade;
                                                                        } else if (j == 6) {
// NO OF BALES
                                                                                      cellData = strNoOfBales;
                                                                        } else if (j == 7) {
// NO OF BALES
                                                                                      cellData = nominalWt + "";
                                                                        } else if (j == 8) {
// NOMINAL WT./BALE
                                                                                      cellData = "Qtls.";
                                                                        } else if (j == 9) {
// UNIT
                                                                           cellData = rate + "";
                                                                        } else if (j == 10) {
// RATE (RS/UNIT)
                                                                                      totalInvQty += nominalQty;
                                                                                      cellData = nominalQty + "";
                                                                        } else if (j == 11) {
// QTY               
                                                                                      cellData = actwt + "";
                                                                                      totalActQty += actwt;
                                                                                      
                                                                        } else if (j == 12) {
// QTY              
                                                                                      totalShortQty += shrtWt;
                                                                                      cellData = shrtWt + "";
                                                                        } else {
                                                                                      // QTY
                                                                                      double totalAmt = Math.round(amt);
                                                                                      cellData = totalAmt + "";
                                                                                      total += totalAmt;
                                                          
                                                                        }

                                                                        Cell cell = createCell(cellData, Border.NO_BORDER, TextAlignment.CENTER);

                                                                        cell.setBorderTop(new SolidBorder(1f));
//cell.setBorderBottom(new SolidBorder(1f));
                                                                        cell.setBorderLeft(new SolidBorder(1f));

                                                                        if (j <= columnNames.length - 1) {
                                                                                      cell.setBorderRight(new SolidBorder(1f));
                                                                        }

                                                                        contentTable11.addCell(cell);
                                                          }

                                           }

                                           document.add(contentTable11);

//float minimumHeight = 20f;

                                           // Cell cell11372 = createCell(TCS_Amt, Border.NO_BORDER, TextAlignment.CENTER);
                                           // cell11372.setBorderRight(new SolidBorder(borderWidth));

                                           // cell11372.setFont(boldFont);
                                           // contentTable35.addCell(cell11372);

                                           float columnWidth4 = PageSize.A4.getWidth() * 0.705f;
                                           float columnWidth5 = PageSize.A4.getWidth() * 0.048f;
                                           float columnWidth6 = PageSize.A4.getWidth() * 0.065f;
                                           
                                           totalActQty = Double.parseDouble(new DecimalFormat("#.####").format(totalActQty));
                                           totalShortQty = Double.parseDouble(new DecimalFormat("#.####").format(totalShortQty));
                                           totalInvQty = Double.parseDouble(new DecimalFormat("#.####").format(totalInvQty));

                                           Table contentTable36 = new Table(new float[] { columnWidth4, columnWidth5,columnWidth5,columnWidth6,columnWidth5 })
                                                                        .setBorder(new SolidBorder(borderWidth)).setFont(boldFont);
//float minimumHeight = 20f;
                                           Cell cell11374 = createCell("TOTAL", Border.NO_BORDER, TextAlignment.CENTER);
                                           cell11374.setBorderRight(new SolidBorder(borderWidth));
                                           cell11374.setBorderBottom(new SolidBorder(borderWidth));
                                           cell11374.setFont(boldFont);
                                           cell11374.setHeight(minimumHeight);
                                           contentTable36.addCell(cell11374);
                                           
                                           Cell cell001 = createCell(totalInvQty+"", Border.NO_BORDER, TextAlignment.CENTER);
                                           cell001.setBorderRight(new SolidBorder(borderWidth));
                                           cell001.setBorderTop(new SolidBorder(borderWidth));
                                           cell001.setFont(boldFont);
                                           cell001.setHeight(minimumHeight);
                                           contentTable36.addCell(cell001);
                                           
                             
                                           
                                           
                                           Cell cell002 = createCell(totalActQty+"", Border.NO_BORDER, TextAlignment.CENTER);
                                           cell002.setBorderRight(new SolidBorder(borderWidth));
                                           cell002.setBorderTop(new SolidBorder(borderWidth));
                                           cell002.setFont(boldFont);
                                           cell002.setHeight(minimumHeight);
                                           contentTable36.addCell(cell002);
                                           
                                           Cell cell003 = createCell(totalShortQty+"", Border.NO_BORDER, TextAlignment.CENTER);
                                           cell003.setBorderRight(new SolidBorder(borderWidth));
                                           cell003.setBorderTop(new SolidBorder(borderWidth));
                                           cell003.setFont(boldFont);
                                           cell003.setHeight(minimumHeight);
                                           contentTable36.addCell(cell003);
                                           
                                           

                                           Cell cell11376 = createCell(total + "", Border.NO_BORDER, TextAlignment.CENTER);
                                           cell11376.setBorderRight(new SolidBorder(borderWidth));
                                           cell11376.setBorderBottom(new SolidBorder(borderWidth));
                                           cell11376.setFont(boldFont);
                                           cell11376.setHeight(minimumHeight);
                                           contentTable36.addCell(cell11376);

                                           document.add(contentTable36);
                                           ConvertWord_k convertWord_k = new ConvertWord_k();
                                           String stringValue5 = Float.toString(total);
                                           double invoiceDouble = Double.parseDouble(stringValue5); // Parse String to double
                                           int convertInt = (int) invoiceDouble;
                                           String InvoiceNO = convertWord_k.convertToWords(convertInt);

                                           String staticTextBefore = "Invoice value in words : ";
                                           String staticTextMid = " Rupees ";
                                           String staticTextAfter = " Only";

                                           Paragraph dynamicParagraph = new Paragraph().add(new Text(staticTextBefore).setBold())
                                                                        .add(new Text(staticTextMid).setUnderline()).add(new Text(InvoiceNO).setUnderline())
                                                                        .add(new Text(staticTextAfter).setUnderline());

                                           document.add(dynamicParagraph);

                                           Paragraph spacingParagraph12 = new Paragraph("\n").setFixedLeading(10f);
                                           document.add(spacingParagraph12);

                                           float columnWidth11 = PageSize.A4.getWidth() * 0.7f;

                                           Paragraph spacingParagraph123 = new Paragraph("\n\n").setFixedLeading(10f);
                                           document.add(spacingParagraph123);
                                           float columnWidth64 = PageSize.A4.getWidth() * 0.5f;

                                           Table contentTable364 = new Table(new float[] { columnWidth64, columnWidth64 }).setFont(boldFont);

                                           Cell cell3164 = createCell("", Border.NO_BORDER, TextAlignment.CENTER);

                                           contentTable364.addCell(cell3164);

//
                                           Cell cell3165 = createCell("", Border.NO_BORDER, TextAlignment.CENTER);

                                           Paragraph paragraph2354 = new Paragraph().add(new Text("Signature (I/C):").setFont(boldFont))
                                                                        .add(new Text("").setFont(normalFont));
                                           cell3165.add(paragraph2354);
                                           contentTable364.addCell(cell3165);

                                           document.add(contentTable364);

                                           document.close();
//return filePath;
                                           pdfDocument.close();
                             } catch (Exception e) {
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

              private Cell createCell(String content, Border border, TextAlignment alignment) {
                             return new Cell().add(new Paragraph(content)).setBorder(border).setTextAlignment(alignment).setFontSize(10); // Adjust
                                                                                                                                                                                                                                                                                                                                                                                                                                                 // fon
                                                                                                                                                                                                                                                                                                                                                                                                                                                 // //
                                                                                                                                                                                                                                                                                                                                                                                                                                                 // content
              }

              public Cell createCell(String content, TextAlignment alignment) {
                             Cell cell = new Cell().add(content);
                             cell.setTextAlignment(alignment);
                             cell.setBorder(Border.NO_BORDER); // Optional: Set border to NO_BORDER if you don't want any visible borders
                             return cell;
              }

              private void addHeader(Document document, String Challan_No1, String instdate1, String Shipment_Details) {
                             document.add(createUnderlinedParagraph("CREDIT NOTE"));
              }

              private Paragraph createUnderlinedParagraph(String staticValue) {
                             return new Paragraph(staticValue).setBold().setUnderline().setTextAlignment(TextAlignment.CENTER)
                                                          .setMarginBottom(5); // Adjust margin as needed
              }

}
