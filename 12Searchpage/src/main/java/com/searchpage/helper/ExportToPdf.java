package com.searchpage.helper;

import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.stereotype.Component;

import com.lowagie.text.Document;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.CMYKColor;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import com.searchpage.entity.DataEntity;

import jakarta.servlet.http.HttpServletResponse;
@Component
public class ExportToPdf {
	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
	public void topdf(HttpServletResponse response,List<DataEntity> all)throws Exception{
//1. make pdf doc obj
		Document document=new Document(PageSize.A4);
		//2. getting instance of pdf writter to write in pdf
		PdfWriter.getInstance(document, response.getOutputStream());
		//3. open doc to write
		document.open();
		//4. font size and style
		Font fontTitle = FontFactory.getFont(FontFactory.TIMES_BOLD);
		fontTitle.setSize(15);
		
		//5.create paragraph
		Paragraph paragraph = new Paragraph("List of user details");
		//set alignment of paragraph
		paragraph.setAlignment(Paragraph.ALIGN_CENTER);
		//add paragraph to doc
		document.add(paragraph);
		
		//6. create table of columns 6 [I]
		PdfPTable table = new PdfPTable(6);
		//width,columns and spacing
		table.setWidthPercentage(100f);
		table.setWidths(new int[] {2, 3, 3, 2, 3, 3});
		table.setSpacingBefore(5);
		
		//7. table cells = header [II]
		PdfPCell cell = new PdfPCell();
		//colour of pdf
		cell.setBackgroundColor(CMYKColor.LIGHT_GRAY);
		cell.setPadding(5);
		
		//font
		Font font = FontFactory.getFont(FontFactory.TIMES_ROMAN);
		font.setColor(CMYKColor.blue);
		
		//8. heading to table = header cells [III]
		cell.setPhrase(new Phrase("ID",font));
		table.addCell(cell);
		cell.setPhrase(new Phrase("User Name",font));
		table.addCell(cell);
		cell.setPhrase(new Phrase("User Status",font));
		table.addCell(cell);
		cell.setPhrase(new Phrase("User gender",font));
		table.addCell(cell);
		cell.setPhrase(new Phrase("Start Date",font));
		table.addCell(cell);
		cell.setPhrase(new Phrase("End Date",font));
		table.addCell(cell);
		
		//9.iterate over the list of user = multiple cells [IV]
		
		for(DataEntity i:all) {
			//add 
			table.addCell(String.valueOf(i.getId()));
			table.addCell(i.getName());
			table.addCell(i.getStatus());
			table.addCell(i.getGender());
			table.addCell(String.valueOf(i.getStart().format(formatter)));
			if(null!=i.getEnd()) {
			table.addCell(String.valueOf(i.getEnd().format(formatter)));
			}else {
				table.addCell("N/A");
			}
		}
		//10.add table to doc [V]
		document.add(table);
		//11.close document	
		document.close();
	}
}
