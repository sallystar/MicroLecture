package com.microlecture.bean;

public class MentoringBean {
	private int id ;		//mentoring Id  进行答疑表id
	private String content;	//答疑内容
	private String author;	//答疑作者
	private	String postAuthor;	//主贴作者，提出疑问的作者
	private	String mentoringTime;	//答疑时间
	private int postId;			//主贴id 提出疑问的id
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getPostAuthor() {
		return postAuthor;
	}
	public void setPostAuthor(String postAuthor) {
		this.postAuthor = postAuthor;
	}
	public String getMentoringTime() {
		return mentoringTime;
	}
	public void setMentoringTime(String mentoringTime) {
		this.mentoringTime = mentoringTime;
	}
	public int getPostId() {
		return postId;
	}
	public void setPostId(int postId) {
		this.postId = postId;
	}
	public StringBuilder getJson(){
		StringBuilder json = new StringBuilder();
		json.append("[{");
		json.append("id:").append(this.id).append(",");
		json.append("content:\"").append(this.content).append("\",");
		json.append("mentoring_author:\"").append(this.author).append("\",");
		json.append("mentoringTime:\"").append(this.mentoringTime).append("\",");
		json.append("postAuthor:\"").append(this.postAuthor).append("\",");
		json.append("postId:").append(this.postId);
		json.append("}]").append(",");
		return json; 
	}
	
}
