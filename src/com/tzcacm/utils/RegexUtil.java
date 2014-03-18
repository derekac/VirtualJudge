package com.tzcacm.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexUtil {
	public static String getStringByRegex(String content,String regex){
		if(content == null || regex == null){
			return null;
		}
		Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE | Pattern.DOTALL);
		Matcher matcher = pattern.matcher(content);
		if(matcher.find()){
			return matcher.group(1);
		}
		return null;
	}
}
