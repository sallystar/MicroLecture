package com.microlecture.bean;

public class ExamNotifyBean {
	private int examId;					
	private String examSchedule;		//���Լƻ�
	private String examTime;			//����ʱ��
	private	String updateTime;			//����ʱ��
	private	String examSubject;			//���Կ�Ŀ
	public int getExamId() {	
		return examId;
	}
	public void setExamId(int examId) {
		this.examId = examId;
	}
	public String getExamSchedule() {
		return examSchedule;
	}
	public void setExamSchedule(String examSchedule) {
		this.examSchedule = examSchedule;
	}
	public String getExamTime() {
		return examTime;
	}
	public void setExamTime(String examTime) {
		this.examTime = examTime;
	}
	public String getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}
	
	public String getExamSubject() {
		return examSubject;
	}
	public void setExamSubject(String examSubject) {
		this.examSubject = examSubject;
	}
	public StringBuilder getJson(){
		StringBuilder json = new StringBuilder();
		json.append("[{");
		json.append("examId:").append(this.examId).append(",");
		json.append("examSchedule:\"").append(this.examSchedule).append("\",");
		json.append("examTime:\"").append(this.examTime).append("\",");
		json.append("updateTime:\"").append(this.updateTime).append("\",");
		json.append("examSubject:\"").append(this.examSubject).append("\"");
		json.append("}]").append(",");
		return json; 
	}
	
}
