package com.crm.proximus.genericUtility;

import java.util.Random;

/**
 * This class is used to help reusablilty of java code
 * @author Deepak
 *
 */
public class JavaUtility {
	/**
	 * This method is used to generate random number
	 * @return int
	 */
	public int generateRandomNum() {
		Random ran = new Random();
		int rNum = ran.nextInt(10000);
		return rNum;
		
	}

}
