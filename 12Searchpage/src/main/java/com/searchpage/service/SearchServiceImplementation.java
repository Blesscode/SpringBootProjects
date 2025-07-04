package com.searchpage.service;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

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
import com.searchpage.Binding.SearchRequest;
import com.searchpage.entity.DataEntity;
import com.searchpage.repository.DataRepository;

import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletResponse;
@Service
public class SearchServiceImplementation implements SearchService {
	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
	
	//dependent on repo
	@Autowired
	private DataRepository repo;

	@Override
	public List<String> statusOptions() {
		// TODO Auto-generated method stub
		List<String> status = repo.getStatus();
		return status;
	}

	@Override
	public List<DataEntity> searchRecord(SearchRequest search) {
		// TODO Auto-generated method stub
		//1. based on the DYNAMIC obj req recive findAll records
		/*
		 * FOR DYNAMIC QUERY BASED ON PARAMETERS :  use QBE query by example
		 * Example.of() only works with entity classes
		 * Example is a wrapper object used to define search criteria dynamically using an entity object 
		 * provide a partially filled entity, and Spring Data will query the database for all entities that match the non-null fields of that objec
		 */
		//copy binding to entity
		DataEntity entity=new DataEntity();
		//BeanUtils.copyProperties(search, entity); copies empty feild also which will result in query searching for empty feilds also
		
		//manual copy
		//name
		if(search.getName()!=null && !search.getName().trim().isEmpty()) {
			entity.setName(search.getName());
		}
		//status
		if(search.getStatus()!=null && !search.getStatus().trim().isEmpty()) {
			entity.setStatus(search.getStatus());
		}
		//gender
		if(search.getGender()!=null && !search.getGender().trim().isEmpty()) {
			entity.setGender(search.getGender());
		}
		//start-date
		if(search.getStartDate()!=null ) {
			entity.setStart(search.getStartDate());
		}
		//end-date
		if(search.getEndDate()!=null ) {
			entity.setEnd(search.getEndDate());
		}

		
		List<DataEntity> listRecords = repo.findAll(Example.of(entity));

		return listRecords;
	}

	@Override
	public Boolean exportToPdf(HttpServletResponse response)throws Exception {
		// TODO Auto-generated method stub
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
		List<DataEntity> all = repo.findAll();
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
		

		return true;
	}

	@Override
	public Boolean exportToExcel(HttpServletResponse response )throws Exception {
		// TODO Auto-generated method stub
		
		//1. create woorkbook
		Workbook workbook=new HSSFWorkbook();
		//2. create sheet
		Sheet sheet = workbook.createSheet("UserDetails");
		//3. create head row
		Row headRow = sheet.createRow(0);
		headRow.createCell(0).setCellValue("S-No");
		headRow.createCell(1).setCellValue("Name");
		headRow.createCell(2).setCellValue("Status");
		headRow.createCell(3).setCellValue("Gender");
		headRow.createCell(4).setCellValue("Start Date");
		headRow.createCell(5).setCellValue("End Date");
		
		//4. create data rows of all data present
			//get data
			List<DataEntity> allData = repo.findAll();
		
		int dataRowIndex=1;
		for(DataEntity i:allData) {
			//create row -> create cells in the row ->populate data
			Row dataRow=sheet.createRow(dataRowIndex);
			dataRow.createCell(0).setCellValue(i.getId());
			dataRow.createCell(1).setCellValue(i.getName());
			dataRow.createCell(2).setCellValue(i.getStatus());
			dataRow.createCell(3).setCellValue(i.getGender());
			dataRow.createCell(4).setCellValue(i.getStart().format(formatter));
			if(null!=i.getEnd()) {
			dataRow.createCell(5).setCellValue(i.getEnd().format(formatter));
			}else {
				dataRow.createCell(5).setCellValue(" N/A ");
			}
			
			dataRowIndex++;
			
		}
		
		//create a strem to send data as download
		//=> to save the file to project folder/server = use FileOutputStream 
		//=> to save the file at browser i.e. download = send the file as the response to browser using httpservletresponse obj
		ServletOutputStream outputStream = response.getOutputStream();
		workbook.write(outputStream);
		workbook.close();

		return true;
	}

}
