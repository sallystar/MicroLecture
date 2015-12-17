package com.microlecture.bean;

public class MentoringBean {
	private int id ;		//mentoring Id  ���д��ɱ�id
	private String content;	//��������
	private String author;	//��������
	private	String postAuthor;	//�������ߣ�������ʵ�����
	private	String mentoringTime;	//����ʱ��
	private int postId;			//����id ������ʵ�id
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
