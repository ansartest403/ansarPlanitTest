package com.planit.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import com.planit.Base.BaseClass;

public class ReadConfig {

	Properties properties;

	/*
	 * @Description : This method the read the excel file
	 * 
	 * @Return : void
	 * 
	 */

	public ReadConfig() {
		File src = new File("./Configuration/config.properties");

		try {
			FileInputStream fileInputStream = new FileInputStream(src);
			properties = new Properties();
			properties.load(fileInputStream);
		} catch (Exception message) {
			BaseClass.logger.info(message.getMessage());
		}
	}

	/*
	 * @Description : This method get the url from properties file
	 * 
	 * @Return : url
	 * 
	 */

	public String getApplicationURL() {
		String url = properties.getProperty("baseURL");
		return url;
	}

	/*
	 * @Description : This method get the excel path
	 * 
	 * @Return : excel path
	 * 
	 */

	public String getExcelPath() {
		String path = properties.getProperty("excelFilePath");
		return path;
	}

	/*
	 * @Description : This method get excel sheet name
	 * 
	 * @Return : sheet name
	 * 
	 */

	public String getExcelSheetName() {
		String sheet = properties.getProperty("excelSheet");
		return sheet;
	}

	/*
	 * @Description : This method get chrome path
	 * 
	 * @Return : chrome path
	 * 
	 */

	public String getChromePath() {
		String chromepath = properties.getProperty("chromepath");
		return chromepath;
	}

	/*
	 * @Description : This method get IE path
	 * 
	 * @Return : IE path
	 * 
	 */

	public String getIEPath() {
		String iepath = properties.getProperty("iepath");
		return iepath;
	}

	/*
	 * @Description : This method get firefox path
	 * 
	 * @Return : firefox path
	 * 
	 */

	public String getFirefoxPath() {
		String firefoxpath = properties.getProperty("firefoxpath");
		return firefoxpath;
	}

}
