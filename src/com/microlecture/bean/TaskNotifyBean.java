package com.microlecture.bean;

public class TaskNotifyBean {
	private int taskId;				//��ҵid
	private String task;			//��ҵ����
	private String taskSubmitTime;	//��ҵ�Ͻ�ʱ��
	private String updateTime;		//����ʱ��
	private int courseId;		//�γ�id
	private	String courseName;		//�γ���
	

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public int getTaskId() {
		return taskId;
	}
	public void setTaskId(int taskId) {
		this.taskId = taskId;
	}
	public String getTask() {
		return task;
	}
	public void setTask(String task) {
		this.task = task;
	}
	public String getTaskSubmitTime() {
		return taskSubmitTime;
	}
	public void setTaskSubmitTime(String taskSubmitTime) {
		this.taskSubmitTime = taskSubmitTime;
	}
	public String getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}
	public int getCourseId() {
		return courseId;
	}
	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}
	public String getCourseName() {
		return courseName;
	}
	public StringBuilder getJson(){
		StringBuilder json = new StringBuilder();
		json.append("[{");
		json.append("courseId:\"").append(this.courseId).append(",");
		json.append("courseName:\"").append(this.courseName).append("\",");
		json.append("task:\"").append(this.task).append("\",");
		json.append("taskId:\"").append(this.taskId).append("\",");
		json.append("taskSubmitTime:\"").append(this.taskSubmitTime).append("\",");
		json.append("updateTime:\"").append(this.updateTime).append("\"");
		json.append("}]").append(",");
		return json; 
	}
	
}
