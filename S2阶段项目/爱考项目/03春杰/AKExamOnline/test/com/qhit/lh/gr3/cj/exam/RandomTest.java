package com.qhit.lh.gr3.cj.exam;

import org.junit.Test;

import com.qhit.lh.gr3.cj.exam.common.utils.RandomUtil;

public class RandomTest {

	@Test
	public void getRandom(){
		int[] qs = RandomUtil.randomCommon(1,2,1);
		for (int i = 0; i < qs.length; i++) {
			System.out.println(qs[i]);
		}
	}
	
	@Test
	public void getStuNo() {
		System.out.println(Math.floor(Math.random()*36));
	}
}
