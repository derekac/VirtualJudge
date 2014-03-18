package com.tzcacm.utils;

import com.tzcacm.bean.Query;
import com.tzcacm.bean.Status;

public class JudgeUtil {
	
	/**
	 * 如果ID不符合标准 默认使用C++
	 * 提交语言的参数转变
	 * @param id
	 * @return
	 */
	public static String getLanguageTagZju(int id){
		switch(id){
			case Query.QUERY_LANGUAGE_C : return "1";
			case Query.QUERY_LANGUAGE_JAVA : return "4";
			default : return "2";
		}
	}
	/**
	 * 
	 * @param judgeStatus
	 * @return zju judge status
	 */
	public static int getJudgeStatusZju(String judgeStatus){
		String[] keys = 
		{		
				"Queuing",
				"Accepted",
				"Presentation Error",
				"Wrong Answer",
				"Time Limit Exceeded",
				"Memory Limit Exceeded",
				"Segmentation Fault",
				"Non-zero Exit Code",
				"Floating Point Error",
				"Compilation Error",
				"Output Limit Exceeded",
		};
		int[] values = 
		{
				Status.JUDGE_STATUS_QUEUING,
				Status.JUDGE_STATUS_ACCEPT,
				Status.JUDGE_STATUS_PRESENTATION_ERROR,
				Status.JUDGE_STATUS_WRONG_ANSWER,
				Status.JUDGE_STATUS_TIME_LIMIT_EXCEEDED,
				Status.JUDGE_STATUS_MEMORY_LIMIT_EXCEEDED,
				Status.JUDGE_STATUS_SEGMENTATION_FAULT,
				Status.JUDGE_STAUTS_NON_ZERO_EXIT_CODE,
				Status.JUDGE_STATUS_OTHER_RESPONSE,
				Status.JUDGE_STATUS_COMPILEERROR,
				Status.JUDGE_STATUS_OUTPUT_LIMIT_EXCEEDED,
		};
		for(int i = 0; i < keys.length; i++){
			if(keys[i].equals(judgeStatus)){
				return values[i];
			}
		}
		return Status.JUDGE_STATUS_ERROR;
	}
	/**
	 * 
	 * @param memory
	 * @return zju judge memory
	 */
	public static int getMemoryZju(String memory){
		
		return 0;
	}
}
