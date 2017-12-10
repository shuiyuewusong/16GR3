package com.qhit.lh.gr3.cj.sbms.utils;


import java.util.UUID;

/**
 * @author 03春杰
 * TODO
 * 2017年12月10日下午3:26:58	
 */
public class IDUtil {
	
	public static String getUUID(){
		return UUID.randomUUID().toString().replaceAll("-", "");
	}

}
