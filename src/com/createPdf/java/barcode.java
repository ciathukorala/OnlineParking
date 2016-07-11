package com.createPdf.java;

import java.io.FileOutputStream;
import java.util.Date;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Element;
import com.itextpdf.text.Image;
import com.itextpdf.text.List;
import com.itextpdf.text.ListItem;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.lowagie.text.Document;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.Barcode39;
import com.lowagie.text.pdf.BarcodeEAN;
import com.lowagie.text.pdf.PdfContentByte;
import com.lowagie.text.pdf.PdfWriter;

import java.io.File;
import java.io.OutputStream;

public class barcode {

  public static void main(String[] args) throws Exception {
    Document document = new Document();
    PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(
        "C:\\Users\\Ishara\\Desktop\\PDF_Java4s222.pdf"));
    

  //Inserting Image in PDF
   
//Inserting Table in PDF
    PdfPTable table=new PdfPTable(3);

          PdfPCell cell = new PdfPCell();

	      cell.setColspan (3);
	      cell.setHorizontalAlignment (Element.ALIGN_CENTER);
	      cell.setPadding (10.0f);
	      cell.setBackgroundColor (new BaseColor (140, 221, 8));					               

	      table.addCell(cell);						               

	      table.addCell("Name");
	      table.addCell("Address");
	      table.addCell("Country");
         table.addCell("Java4s");
	      table.addCell("NC");
	      table.addCell("United States");
	      table.setSpacingBefore(30.0f);       // Space Before table starts, like margin-top in CSS
	      table.setSpacingAfter(30.0f);        // Space After table starts, like margin-Bottom in CSS								          

//Inserting List in PDF
	      List list=new List(true,30);
         list.add(new ListItem("Java4s"));
	      list.add(new ListItem("Php4s"));
	      list.add(new ListItem("Some Thing..."));		

//Text formating in PDF
       Chunk chunk=new Chunk("Welecome To Java4s Programming Blog...");
		chunk.setUnderline(+1f,-2f);//1st co-ordinate is for line width,2nd is space between
		Chunk chunk1=new Chunk("Php4s.com");
		chunk1.setUnderline(+4f,-8f);
		chunk1.setBackground(new BaseColor (17, 46, 193));      

    
		document.open();
    
    PdfContentByte cb = writer.getDirectContent();
    BarcodeEAN codeEAN = new BarcodeEAN();
    codeEAN.setCode("4512345678906");
    Paragraph p = new Paragraph();
    
    

    // CODE 39
    document.add(new Paragraph("Barcode 3 of 9"));
    Barcode39 code39 = new Barcode39();
    code39.setCode("ITEXT IN ACTION");
    document.add(code39.createImageWithBarcode(cb, null, null));
    
    
    document.add(p);
    
    com.lowagie.text.Image image01 = com.lowagie.text.Image.getInstance("F:\\JSP\\WorkSpace\\ParkingSystem\\WebContent\\images\\park.jpg");
    document.add(image01);

   
	 
	   //Something like in HTML :-)

    document.add(new Paragraph("Dear Java4s.com"));
    document.add(new Paragraph("Document Generated On - "+new Date().toString()));	

	

	
		document.newPage();            //Opened new page
	
    
    document.close();
  }
}