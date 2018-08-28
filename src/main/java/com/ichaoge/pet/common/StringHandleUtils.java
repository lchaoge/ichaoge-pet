package com.ichaoge.pet.common;

public class StringHandleUtils {

	public static String getNewResNum(String todayYearMonth, String curResNum) {

		String curYearMonth = curResNum.substring(0, 6);
		int newNo = 1;
		if (todayYearMonth.equals(curYearMonth)) {
			int no = Integer.parseInt(curResNum.substring(6));
			newNo = no + 1;
		}

		return (todayYearMonth + String.format("%04d", newNo));
	}
}
