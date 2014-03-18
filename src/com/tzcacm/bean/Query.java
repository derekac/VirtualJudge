package com.tzcacm.bean;

public class Query {

	public final static int QUERY_LANGUAGE_C = 0; //GCC
	public final static int QUERY_LANGUAGE_CPP = 1; //C++
	public final static int QUERY_LANGUAGE_JAVA = 2; //JAVA++

	private int problemId;
	private int languageId;
	private String sourceCode;

	public Query(){

	}
	public Query(int problemId,int languageId,String sourceCode){
		setLanguageId(languageId);
		setProblemId(problemId);
		setSourceCode(sourceCode);
	}
	public int getProblemId() {
		return problemId;
	}
	public void setProblemId(int problemId) {
		this.problemId = problemId;
	}
	public int getLanguageId() {
		return languageId;
	}
	public void setLanguageId(int languageId) {
		this.languageId = languageId;
	}
	public String getSourceCode() {
		return sourceCode;
	}
	public void setSourceCode(String sourceCode) {
		this.sourceCode = sourceCode;
	}

}
