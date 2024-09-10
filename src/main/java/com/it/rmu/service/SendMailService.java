package com.it.rmu.service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.it.rmu.model.RegisterResponseModel;
import com.it.rmu.utils.Constants;
import com.it.rmu.utils.SendEmailUtils;

import io.micrometer.common.util.StringUtils;
import jakarta.mail.MessagingException;

@Service
public class SendMailService {

	 @Autowired
	 private SendEmailUtils sendEmailUtils;
	 
	 public void sendMail(Object object,String email, String subJect, String type) {
		 
		 try {
			 Path path = FileSystems.getDefault().getPath("").toAbsolutePath();
				String output = path + File.separator + Constants.PATH_FOLDER_EMAIL + File.separator;
			 if(Constants.TYPE_SENDMAIL_REGISTER.equals(type)) {
				 RegisterResponseModel obj = (RegisterResponseModel) object;
				 File file = new File(output + "registerEmailTemplate.txt");
				 BufferedReader reader = new BufferedReader(new FileReader(file));
				 String emailTo = email;
				 StringBuilder stringBuilder = new StringBuilder();
				 String line = null;
				 String ls = System.getProperty("line.separator");
				while ((line = reader.readLine()) != null) {
				 	stringBuilder.append(line);
				 	stringBuilder.append(ls);
				 }
				 stringBuilder.deleteCharAt(stringBuilder.length() - 1);
				 reader.close();

				 String content = stringBuilder.toString();
				 content = setParam(content, obj);
				 
				 sendEmailUtils.sendMail(emailTo, subJect, content);
			 }
			 
			 

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 }
	 
	 private String setParam(String content,RegisterResponseModel obj) {

		 if(content.contains("{FULL_NAME}")) {
			 content = content.replace("{FULL_NAME}",isNull(obj.getFristName() + "-" + obj.getLastName())); 
		 }
		 
		 if(content.contains("{DETAIL}")) {
			 StringBuilder detail = new StringBuilder();
			 
			 detail.append("เข้าสู่ระบบโดย :");
			 detail.append(" Username = " + obj.getUserName());
			 detail.append(" Password = " + obj.getPassword());
			 content = content.replace("{DETAIL}",detail.toString()); 
		 }
		 return content;
	 }
	 
	 private String isNull(String str) {
		 if(StringUtils.isNotBlank(str)) {
			 return str;
		 }
		 return "";
	 }
}
