package com.tzcacm.bean;
/**
 *
 * @author yyrookie
 * @version 1.0
 */
public class Status {
	/**
	 * may be http connectting error
	 */
	public final static int JUDGE_STATUS_ERROR = -1;
	
	/**
	 * The judge is so busy that it can't judge your submit at the moment, 
	 * usualy you just need to wait a minute and your submit will be judged.
	 */
	public final static int JUDGE_STATUS_QUEUING = 0;
	
	/**
	 * OK! Your program is correct!.
	 */
	public final static int JUDGE_STATUS_ACCEPT = 1;
	
	/**
	 * Your output format is not exactly the same as the judge's output, 
	 * although your answer to the problem is correct. Check your output for spaces, 
	 * blank lines,etc against the problem output specification.
	 */
	public final static int JUDGE_STATUS_PRESENTATION_ERROR = 2;
	
	/**
	 * Correct solution not reached for the inputs. The inputs and outputs 
	 * that we use to test the programs are not public (it is recomendable 
	 * to get accustomed to a true contest dynamic ;-).
	 */
	public final static int JUDGE_STATUS_WRONG_ANSWER = 3;
	
	/**
	 * Your program tried to run during too much time.
	 */
	public final static int JUDGE_STATUS_TIME_LIMIT_EXCEEDED = 4;
	
	/**
	 * Your program tried to use more memory than the judge default settings. 
	 */
	public final static int JUDGE_STATUS_MEMORY_LIMIT_EXCEEDED = 5;
	
	/**
	 * Your program tried to write too much information. This usually occurs if it goes into a infinite loop. 
	 */
	public final static int JUDGE_STATUS_OUTPUT_LIMIT_EXCEEDED = 6;
	
	/**
	 * Your program exited returning a non-zero value to the shell. For languages such as C, this probably means you forgot to add "return 0" at the end of the program. For interpreted languages NZEC will usually mean that your program either crashed or raised an uncaught exception.
	 */
	public final static int JUDGE_STAUTS_NON_ZERO_EXIT_CODE = 7;
	
	/**
	 * The compiler (gcc, g++, fpc, etc) could not compile your program. 
	 * Of course, warning messages are not error messages. 
	 * Click the link at the judge reply to see the actual error message.
	 */
	public final static int JUDGE_STATUS_COMPILEERROR = 8;
	
	/**
	 * The possible cases of your encountering this error are:
		1.buffer overflow --- usually caused by a pointer reference out of range.
		2.stack overflow --- please keep in mind that the default stack size is 8192K.
	 */
	public final static int JUDGE_STATUS_SEGMENTATION_FAULT = 9;
	
	/**
	 * Other judge status;
	 */
	public final static int JUDGE_STATUS_OTHER_RESPONSE = 10;
	
	private int problemId;
	private int judgeStatus;
	private int memory;
	private int submitId;
	private int runtime;
	
	public int getRuntime() {
		return runtime;
	}
	public void setRuntime(int runtime) {
		this.runtime = runtime;
	}
	public int getProblemId() {
		return problemId;
	}
	public int getSubmitId() {
		return submitId;
	}
	public void setSubmitId(int submitId) {
		this.submitId = submitId;
	}
	public void setProblemId(int problemId) {
		this.problemId = problemId;
	}
	public int getJudgeStatus() {
		return judgeStatus;
	}
	public void setJudgeStatus(int judgeStatus) {
		this.judgeStatus = judgeStatus;
	}
	public int getMemory() {
		return memory;
	}
	public void setMemory(int memory) {
		this.memory = memory;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "judgeStatus : " + getJudgeStatus() + "\n" + 
				"Memory : " + getMemory() + " kb \n" + 
				"ProblemId : " + getProblemId() + "\n" + 
				"RunTime : " + getRuntime() + " ms \n" + 
				"SubmitId : " + getSubmitId() + "\n";
	}
}
