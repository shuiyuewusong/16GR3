package com.qhit.t3.convertor;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import org.apache.struts2.util.StrutsTypeConverter;

public class DateConvertor extends StrutsTypeConverter{
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");

	@Override
	public Object convertFromString(Map arg0, String[] arg1, Class arg2) {
		String strDate = arg1[0];
		Date date = null;
		try {
			date = sdf.parse(strDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		return date;
	}

	@Override
	public String convertToString(Map arg0, Object arg1) {
		
		
		
		
		return sdf.format(arg1);
	}

}
