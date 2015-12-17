package com.microlecture.bean;


/**
 *  the bean for submit test 
 *  
 * */
public class SubmitTestBean {
	private int testId;				//锟斤拷锟斤拷锟斤拷锟絠d
	private int testRightWrong;		//0锟截达拷锟斤拷确锟斤拷1 锟截达拷锟斤拷锟�
	//private int connerId;			//锟斤拷锟斤拷锟斤拷锟�
	private String selectAnswer;	//锟截达拷拇锟�
	private String submitTime;
	private int videoId;
	public String getSubmitTime() {
		return submitTime;
	}
	public void setSubmitTime(String submitTime) {
		this.submitTime = submitTime;
	}
	public int getTestId() {
		return testId;
	}
	public void setTestId(int testId) {
		this.testId = testId;
	}
	public int getTestRightWrong() {
		return testRightWrong;
	}
	public void setTestRightWrong(int testRightWrong) {
		this.testRightWrong = testRightWrong;
	}
	/*public int getConnerId() {
		return connerId;
	}
	public void setConnerId(int connerId) {
		this.connerId = connerId;
	}*/
	
	public String getSelectAnswer() {
		return selectAnswer;
	}
	public void setSelectAnswer(String selectAnswer) {
		this.selectAnswer = selectAnswer;
	}
	public int getVideoId() {
		return videoId;
	}
	public void setVideoId(int videoId) {
		this.videoId = videoId;
	}
	
}
