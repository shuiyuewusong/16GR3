package com.qhit.lh.gr3.cj.t7.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;


/**
 * @author 03春杰
 * TODO
 * 2017年12月6日上午8:37:09	
 */
public class FileAction extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String username;//上传人
	private File uploadFile;//上传文件
	
	private String uploadFileFileName;//文件名
	private String uploadFileContentType;//文件类型
	
	
	
	
	
	private InputStream is;
	private OutputStream os;
	
	/**
	 *  @return
	 *	处理上传文件的业务
	 */
	public String upload() {
		if(uploadFile != null) {
			/*
			 * 上传的业务：
			 * 1，读取上传的文件：
			 * 		读：输入流--》先获取上传文件的输入流
			 * 2，保存到服务器：
			 * 		写之前：创建保存的文件（localhost:8080/T7/upload/uploadFileFileName）创建文件
			 * 		写:输出流-->根据创建的文件，写入数据
			 */
			try {
				is = new FileInputStream(uploadFile);
				//写之前：创建保存的文件（localhost:8080/Struts2T7/upload/uploadFileFileName）创建文件夹
				String savePath = ServletActionContext.getServletContext().getRealPath("/")+"upload";
				File file = new File(savePath);
				if(!file.exists()) {
					file.mkdirs();
				}
				os = new FileOutputStream(savePath+"/"+uploadFileFileName);
				//根据创建的文件，写入数据
				byte[] buffer = new byte[8096];
				int len = 0;
				while((len = is.read(buffer)) != -1) {
					os.write(buffer, 0, len);
				}
			} catch (FileNotFoundException e) {
				e.printStackTrace();
				super.addFieldError("uploadFile", "文件未找到!");
			} catch (IOException e) {
				e.printStackTrace();
				super.addFieldError("uploadFile", "文件保存失败!");
			}
		}else {
			//文件未找到
			super.addFieldError("uploadFile", "文件未找到!");
		}
		return "uplaodSuccess";
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public File getUploadFile() {
		return uploadFile;
	}

	public void setUploadFile(File uploadFile) {
		this.uploadFile = uploadFile;
	}

	public String getUploadFileFileName() {
		return uploadFileFileName;
	}

	public void setUploadFileFileName(String uploadFileFileName) {
		this.uploadFileFileName = uploadFileFileName;
	}

	public String getUploadFileContentType() {
		return uploadFileContentType;
	}

	public void setUploadFileContentType(String uploadFileContentType) {
		this.uploadFileContentType = uploadFileContentType;
	}
		
	

}
