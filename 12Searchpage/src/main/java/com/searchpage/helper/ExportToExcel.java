package com.searchpage.helper;

import java.io.File;
import java.io.FileOutputStream;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.stereotype.Component;

import com.searchpage.entity.DataEntity;

import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletResponse;
@Component
public class ExportToExcel {
	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
	
	
@SuppressWarnings("resource")
public void toexcel(HttpServletResponse response,List<DataEntity> allData)throws Exception{
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
		FileOutputStream outputStream2 = new FileOutputStream(new File("Data.xls"));
		workbook.write(outputStream2);
		outputStream2.close();
		//=> to save the file at browser i.e. download = send the file as the response to browser using httpservletresponse obj
		ServletOutputStream outputStream = response.getOutputStream();
		workbook.write(outputStream);
		workbook.close();

}
		
}
