package com.it.rmu.service;

import java.awt.Color;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.List;

import org.springframework.stereotype.Service;

import com.it.rmu.model.ManageUserResponseModel;
import com.it.rmu.utils.Constants;
import com.it.rmu.utils.DateUtil;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Font;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.BaseFont;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

@Service
public class GenPdfService {

	public File genPDF(List<?> data, String type) throws DocumentException, IOException {
		Document document = new Document(PageSize.A4);
		File tempFile = File.createTempFile("report", ".pdf");
		FileOutputStream out = new FileOutputStream(tempFile);
		PdfWriter.getInstance(document, out);

		document.open();
		Path path = FileSystems.getDefault().getPath("").toAbsolutePath();
		String outputPathStr = path + File.separator + Constants.PATH_FOLDER_FRONT + File.separator + "THSarabun.ttf";
		BaseFont baseFont =
                BaseFont.createFont(outputPathStr, BaseFont.IDENTITY_H,
                true);
        Font font = new Font(baseFont);
//		Font font = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
		font.setSize(24);
		font.setColor(Color.black);
		
		String projectName = "ระบบคลังสินค้า";

		Paragraph p = new Paragraph(projectName, font);
		p.setAlignment(Paragraph.ALIGN_CENTER);

		document.add(p);

		if(Constants.TYPE_CUSTOMER.equals(type)) {
			PdfPTable table = new PdfPTable(5);
			table.setWidthPercentage(100f);
			table.setWidths(new float[] { 4.0f, 4f, 2.5f,4.0f, 7.2f });
			table.setSpacingBefore(10);
			
			@SuppressWarnings("unchecked")
			List<ManageUserResponseModel> listUser = (List<ManageUserResponseModel>) data;
			writeTableHeaderCustomer(table,baseFont);
			writeTableDataCustomer(table,baseFont,listUser);
			document.add(table);
		}

		document.close();

		return tempFile;
	}

	private void writeTableHeaderCustomer(PdfPTable table, BaseFont baseFont) throws DocumentException, IOException {
		PdfPCell cell = new PdfPCell();
		
		cell.setBackgroundColor(Color.yellow);
		cell.setPadding(7);

//		Font font = FontFactory.getFont(FontFactory.HELVETICA);
//		font.setColor(Color.WHITE);
		
        Font font = new Font(baseFont);
        font.setSize(15);
		
		cell.setPhrase(new Phrase("ชื่อ-นามสกุล", font));
		table.addCell(cell);
		
		cell.setPhrase(new Phrase("เบอร์โทรศัทพ์", font));
		table.addCell(cell);

		cell.setPhrase(new Phrase("อายุ", font));
		table.addCell(cell);

		cell.setPhrase(new Phrase("สถานะ", font));
		table.addCell(cell);
		
		cell.setPhrase(new Phrase("วันที่ลงทะเบียน", font));
		table.addCell(cell);
	}

	private void writeTableDataCustomer(PdfPTable table, BaseFont baseFont,List<ManageUserResponseModel> listUser) throws DocumentException, IOException {

		PdfPCell cell = new PdfPCell();
		cell.setPadding(3);

        Font font = new Font(baseFont);
        font.setSize(13);
		for (ManageUserResponseModel user : listUser) {

			cell.setPhrase(new Phrase( user.getFristName() +"-"+ user.getLastName(), font));
			table.addCell(cell);
			
			cell.setPhrase(new Phrase( user.getPhone(),font));
			table.addCell(cell);
			
			cell.setPhrase(new Phrase( user.getAge(), font));
			table.addCell(cell);
			
			cell.setPhrase(new Phrase( "1".equals(user.getStatus()) ? "ปกติ" : "ไม่ปกติ" , font));
			table.addCell(cell);
			
			cell.setPhrase(new Phrase( DateUtil.dateToString(user.getCreateDate()), font));
			table.addCell(cell);
		}
	}
}
