package com.microlecture.bean;

public class TaskNotifyBean {
	private int taskId;				//作业id
	private String task;			//作业安排
	private String taskSubmitTime;	//作业上交时间
	private String updateTime;		//更新时间
	private int courseId;		//课程id
	private	String courseName;		//课程名
	

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
