package com.qhit.sbms.util;

import java.util.UUID;

public class IDUtil {

	public static String getUUID(){
		return UUID.randomUUID().toString().replaceAll("-", "");
	}
}
