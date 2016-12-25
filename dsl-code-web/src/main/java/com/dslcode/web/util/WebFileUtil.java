package com.dslcode.web.util;

import com.dslcode.core.file.FileUtil;

import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * 文件操作Util
 * @author 董思林
 * @date 2016-07-14
 */
public class WebFileUtil {

	
	/**
	 * 文件下载
	 * @param sourcePath 源文件绝对路径
	 * @param fileName 文件名称
	 * @param fileType 文件路径
	 * @param response
	 * @throws Exception
	 */
	public static void download(String sourcePath, String fileName, String fileType, HttpServletResponse response) throws Exception{
		InputStream is = new FileInputStream(FileUtil.getFile(sourcePath, 1));
		download(is, fileName, fileType, response);
		if(null != is) is.close();
	}
	
	/**
	 * 文件下载
	 * @param is 源文件输入流
	 * @param fileName 文件名称
	 * @param fileType 文件路径
	 * @param response
	 * @throws Exception
	 */
	public static void download(InputStream is, String fileName, String fileType, HttpServletResponse response) throws Exception{
		response.setContentType(fileType + "; charset=UTF-8");
		response.setHeader("Content-Disposition", "attachment;filename=" + new String(fileName.getBytes("UTF-8"), "ISO-8859-1"));
		OutputStream os = response.getOutputStream();
		FileUtil.copy(is, os);
		if(null != os) os.close();
	}

}
