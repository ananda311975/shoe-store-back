package com.it.rmu.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;

import com.it.rmu.model.ManageUserResponseModel;
import com.it.rmu.utils.Constants;
import com.it.rmu.utils.DateUtil;

@Service
public class GenExcelService {
	
	public File genExcel(List<?> data , String type) throws IOException {
		
		Path path = FileSystems.getDefault().getPath("").toAbsolutePath();
		String template = "";
		if(Constants.TYPE_CUSTOMER.equals(type)) {
			template = "customer.xlsx";
		}
		String outputPathStr = path + File.separator + Constants.PATH_FOLDER_REPORT_EXCEL + File.separator + template;
		
	   InputStream in = new FileInputStream(new File(outputPathStr));
       XSSFWorkbook workbook = new XSSFWorkbook(in); 
       XSSFSheet spreadsheet = workbook.getSheetAt(0);
       
       if(Constants.TYPE_CUSTOMER.equals(type)) {
    	
		@SuppressWarnings("unchecked")
		List<ManageUserResponseModel> listUser = (List<ManageUserResponseModel>) data;
    	this.setCellForCustomer(listUser, spreadsheet);
       }
       

       try {
           File tempFile = File.createTempFile("report", ".xlsx");
           FileOutputStream out = new FileOutputStream(tempFile);
           workbook.write(out);

           return tempFile;
       } catch (IOException e) {
           e.printStackTrace();
       }
       return null;
   }
	
	public void setCellForCustomer(List<ManageUserResponseModel> listUser,  XSSFSheet spreadsheet) {
		int i = 1;
		for(ManageUserResponseModel item : listUser) {
           XSSFRow row = spreadsheet.createRow(i);
           
           Cell cellV1 = row.createCell(0);
           cellV1.setCellValue(i++);

           Cell cellV2 = row.createCell(1);
           cellV2.setCellValue(item.getFristName() + "-" + item.getLastName());
           
           Cell cellV3 = row.createCell(2);
           cellV3.setCellValue(item.getPhone());
           
           Cell cellV4 = row.createCell(3);
           cellV4.setCellValue(item.getAge());
           
           Cell cellV5 = row.createCell(4);
           cellV5.setCellValue("1".equals(item.getStatus()) ? "ปกติ" : "ไม่ปกติ");
           
           Cell cellV6 = row.createCell(5);
           cellV6.setCellValue(DateUtil.dateToString(item.getCreateDate()));
	
	   }
	}
}
