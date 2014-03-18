package com.tzcacm.judge;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;

import com.tzcacm.bean.Query;
import com.tzcacm.bean.Status;
import com.tzcacm.bean.User;
import com.tzcacm.utils.RegexUtil;
import com.tzcacm.utils.SpiderUtil;
import com.tzcacm.utils.JudgeUtil;

public class SimpleJudgeClient implements JudgeClient {
	public static volatile SimpleJudgeClient instance = null;

	private SimpleJudgeClient() {

	}

	public static SimpleJudgeClient getJudgeClient() {
		if (instance == null) {
			synchronized (SimpleJudgeClient.class) {
				if (instance == null) {
					instance = new SimpleJudgeClient();
				}
			}
		}
		return instance;
	}

	/**
	 * judge in zoj
	 * 
	 * @param user
	 * @param query
	 * @return Status
	 */
	public int submitZju(User user, Query query) throws Exception {
		String loginUrl = "http://acm.zju.edu.cn/onlinejudge/login.do";
		String cookie = SpiderUtil.getCookie(loginUrl, "handle",
				user.getUsername(), "password", user.getPassword());
		String problemStr = query.getProblemId() + "";
		String languageStr = JudgeUtil.getLanguageTagZju(query.getLanguageId());
		List<NameValuePair> nvps = new ArrayList<NameValuePair>();
		nvps = SpiderUtil.getParameterListCookie(nvps, "problemId",
				problemStr.toString());
		nvps = SpiderUtil.getParameterListCookie(nvps, "languageId",
				languageStr.toString());
		nvps = SpiderUtil.getParameterListCookie(nvps, "source",
				query.getSourceCode());
		String submitString = SpiderUtil.crawInPost(
				"http://acm.zju.edu.cn/onlinejudge/submit.do", nvps, 6000,
				"utf-8", cookie);
		String submitIdstr = RegexUtil.getStringByRegex(submitString,
				"<font\\s+color=\\'red\\'>(\\d+)</font>.");
		int submitId = Integer.parseInt(submitIdstr);
		// TODO Auto-generated method stub
		return submitId;
	}

	public Status getStatusZju(int submitId, User user) {
		Status status = new Status();
		status.setSubmitId(submitId);
		List<NameValuePair> nvps = new ArrayList<NameValuePair>();
		nvps = SpiderUtil.getParameterListCookie(nvps, "contestId", "1");
		nvps = SpiderUtil
				.getParameterListCookie(nvps, "idStart", submitId + "");
		nvps = SpiderUtil.getParameterListCookie(nvps, "idEnd", submitId + "");
		String searchPage = null;
		String statusJudge = null;
		String memoryStr = null;
		String runtimeStr = null;
		String problemIdStr = null;
		try {
			searchPage = SpiderUtil.crawInPost(
					"http://acm.zju.edu.cn/onlinejudge/showRuns.do", nvps,
					90000, "utf-8", "");
			statusJudge = RegexUtil.getStringByRegex(searchPage,
					"<span\\s+class=\"judgeReply.*?\">([\\S|\\s]*?)</span>");
			memoryStr = RegexUtil.getStringByRegex(searchPage,
					"<td class=\"runMemory\">(\\d+)</td>");
			runtimeStr = RegexUtil.getStringByRegex(searchPage,
					"<td class=\"runTime\">(\\d+)</td>");
			problemIdStr = RegexUtil.getStringByRegex(searchPage,
					"<td class=\"runProblemId\"><a[^>]+>(\\d+)");
			statusJudge = statusJudge.trim();
			status.setJudgeStatus(JudgeUtil.getJudgeStatusZju(statusJudge));
			status.setProblemId(Integer.parseInt(problemIdStr));
			status.setSubmitId(submitId);
			status.setMemory(Integer.parseInt(memoryStr));
			status.setRuntime(Integer.parseInt(runtimeStr));
		} catch (Exception e) {
			status.setJudgeStatus(Status.JUDGE_STATUS_ERROR);
		}
		return status;
	}

	public static void main(String[] args) throws Exception {
		JudgeClient judgeClient = SimpleJudgeClient.getJudgeClient();
		Query query = new Query(4313, Query.QUERY_LANGUAGE_JAVA, "good");
		 int submitid = judgeClient.submitZju(new
		 User("tzcjudge", "tzcjudge"), query);
		Status status = judgeClient.getStatusZju(3529674, null);
		System.out.println(status);
	}
}
