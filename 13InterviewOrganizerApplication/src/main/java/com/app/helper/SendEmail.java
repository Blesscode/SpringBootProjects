package com.app.helper;

import org.springframework.stereotype.Component;

import com.lowagie.text.Document;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfWriter;

import jakarta.servlet.http.HttpServletResponse;


@Component
public class SendEmail {
	// for now we will see in a pdf format
	//1.get new a4 document
	//2.write=get writer instance
	//3.open doc to write
	//4. set font size
	//5. create paragraph and add to doc
	public void topdf(HttpServletResponse response,String pwd,String link) throws Exception{
		Document document=new Document(PageSize.A4);
		PdfWriter.getInstance(document, response.getOutputStream());
		document.open();
		//4. font size and style
		Font fontTitle = FontFactory.getFont(FontFactory.TIMES_BOLD);
		fontTitle.setSize(15);
		
		//5.create paragraph
		Paragraph paragraph = new Paragraph("Your activation password is"+" "+pwd+"to activate your account please click the following link and reset your password"+link);
		//set alignment of paragraph
		paragraph.setAlignment(Paragraph.ALIGN_CENTER);
		//add paragraph to doc
		document.add(paragraph);
		document.close();
	}
	
}
