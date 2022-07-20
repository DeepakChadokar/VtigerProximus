package com.crm.proximus.genericUtility;

import java.io.FileInputStream;
import java.util.Properties;

/**
 * It contains property file related methods
 * @author Deepak
 *
 */

public class FileUtility {
	
	/**
	 * its used to read the data from commonData.properties File based on Key which you pass as an argument
	 * @param key
	 * @throws Throwable 
	 * @author Deepak
	 */
    public String getPropertyKeyValue(String key) throws Throwable {
    	 FileInputStream fis = new FileInputStream(IConstants.propertyFilePath);
    	 Properties p = new Properties();
    	 p.load(fis);
    	 String kV = p.getProperty(key);
		return kV;
    	
    }
}
