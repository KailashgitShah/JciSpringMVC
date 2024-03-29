package com.jci.controller;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.time.Month;
import java.util.List;

import javax.print.attribute.standard.DialogOwner;

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
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.element.Text;
import com.itextpdf.layout.property.TextAlignment;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Font;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.BaseFont;
import com.lowagie.text.pdf.GrayColor;

public class PdfGenerator {

	public void generatePdfOfContractLetter(String jciRefNojciRefNo, String millNameString, String millCode, Double qty,
			String cropyear, List<Object[]> priceList, List<String> compList, List<String> varietyArray,
			String fileName, String deliveryType, String contractDate, String filePath, String letterHeadPath,
			List<Object> fullAddress, String pcsoDates) throws DocumentException, IOException {

		PdfWriter pdfWriter = new PdfWriter(filePath);
		PdfDocument pdfDocument = new PdfDocument(pdfWriter);

		pdfDocument.setDefaultPageSize(PageSize.A4);

		Document document = new Document(pdfDocument);
		document.setMargins(0, document.getLeftMargin(), document.getBottomMargin(), document.getRightMargin());
		float fullWidth = PageSize.A4.getWidth();
		float equalThreeColumWidth = fullWidth / 3f;
		float columnHalfWidth = fullWidth * 0.5f;
		float columnWidth60 = fullWidth * 0.60f;
		float columnWidth20 = fullWidth * 0.20f;
		float widthOfTwoColumn[] = { columnHalfWidth*0.7f, columnHalfWidth*0.77f };
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
//		
//		System.err.println(add1);
//		System.err.println(add2);
//		System.err.println(areaAndpincode);
//		
//		System.err.println(add1);
//		System.err.println(add2);
//		System.err.println(areaAndpincode);

		Table table = new Table(widthOfTwoColumn);

		Image letterHead = new Image(ImageDataFactory.create(letterHeadPath));

		table.addCell(new Cell().add(new Paragraph().add(new Text("No, ").setBold()).add(new Text(jciRefNojciRefNo)))
				.setBorder(Border.NO_BORDER).setTextAlignment(TextAlignment.LEFT));

		table.addCell(new Cell().add(new Paragraph().add(new Text("Date : "))).setBold()
				.setBorder(Border.NO_BORDER)).setTextAlignment(TextAlignment.RIGHT);

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

		Paragraph RefParagraph = new Paragraph(new Text("Ref No : ").setBold()).add(new Text("Jute(Mktg)/42/2004 dt. "))
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

			Double composition = (rObject1 / 100) * qty * 10; // Qty in Qtls
			Double priceDouble = ((BigDecimal) rObject2[i]).doubleValue();
			totalContractedprice += composition * priceDouble;

			int compositionInt = (int) Math.round(composition);
			totalCompositionInt += compositionInt;
			distributionTable.addCell(new Cell().add(varietyArray.get(i) + "")).setTextAlignment(TextAlignment.CENTER);
			distributionTable.addCell(new Cell().add(compositionInt + "").setTextAlignment(TextAlignment.CENTER));

			distributionTable.addCell(new Cell().add("##.##").setTextAlignment(TextAlignment.CENTER));
		}

		int finalPrice = (int) totalContractedprice;

		distributionTable.addCell(new Cell().add("Total").setBold());
		distributionTable.addCell(new Cell().add(totalCompositionInt + "").setBold());
		distributionTable.addCell(new Cell().add(finalPrice + " Rs"));

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
}
