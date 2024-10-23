package utilities;

import java.util.ResourceBundle;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class Constants {
	
	
	public static ResourceBundle configProp = ResourceBundle.getBundle("configProp");
	public static ExcelReader xlutils=new ExcelReader(configProp.getString("XLpath"));


	public static Logger log = LogManager.getLogger();

	public static String baseURL = configProp.getString("BaseUrl");


}
	
