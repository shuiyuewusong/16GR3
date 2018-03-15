package com.qhit.lh.gr3.cj.exam.tkgl.utils;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.qhit.lh.gr3.cj.exam.common.utils.RandomUtil;
import com.qhit.lh.gr3.cj.exam.tkgl.bean.WrittenQuestion;

/**类名:RandomQuestionsUtils
  *创建时间:2018年3月13日
  *创建人:Disdain
  */
public class RandomQuestionsUtils {
	private static WrittenQuestion writtenQuestion;
	
	public static Set<WrittenQuestion> randomAllQuestions(
			List<WrittenQuestion> listRE,
			List<WrittenQuestion> listRN,
			List<WrittenQuestion> listRD,
			List<WrittenQuestion> listCE,
			List<WrittenQuestion> listCN,
			List<WrittenQuestion> listCD,
			int radioEasy,int radioNormal,int radioDiff,
			int cbEasy,int cbNormal,int cbDiff
			){
		Set<WrittenQuestion> lisQuestions = new HashSet<>();
		
		randomQuestions(listRE,radioEasy,lisQuestions);
		randomQuestions(listRN,radioNormal,lisQuestions);
		randomQuestions(listRD,radioDiff,lisQuestions);
		randomQuestions(listCE,cbEasy,lisQuestions);
		randomQuestions(listCN,cbNormal,lisQuestions);
		randomQuestions(listCD,cbDiff,lisQuestions);
		
		return lisQuestions;
	}
	
	public static void randomQuestions(List<WrittenQuestion> list, int num, Set<WrittenQuestion> lisQuestions){
		//从数据集合中随机获取不同的索引
		int[] questions = RandomUtil.randomCommon(1, list.size(), num);
		System.out.println(questions.length);
		for(int i=0;i<questions.length;i++){
			System.out.println(list.get(questions[i]-1).getQid());
			//获取试题
			writtenQuestion = list.get(questions[i]-1);
			lisQuestions.add(writtenQuestion);
		}
	}
}
