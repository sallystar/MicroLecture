package com.microlecture.bean;

/**
 * 
 * 
 * */
public class CourseRevelance {
	private int postId;
	private String postName;
	private int replyId;
	private String replyAuthor;
	private String replyCotent;
	private String replyTime;
	public int getPostId() {
		return postId;
	}
	public void setPostId(int postId) {
		this.postId = postId;
	}
	public String getPostName() {
		return postName;
	}
	public void setPostName(String postName) {
		this.postName = postName;
	}
	public int getReplyId() {
		return replyId;
	}
	public void setReplyId(int replyId) {
		this.replyId = replyId;
	}
	public String getReplyAuthor() {
		return replyAuthor;
	}
	public void setReplyAuthor(String replyAuthor) {
		this.replyAuthor = replyAuthor;
	}
	public String getReplyCotent() {
		return replyCotent;
	}
	public void setReplyCotent(String replyCotent) {
		this.replyCotent = replyCotent;
	}
	public String getReplyTime() {
		return replyTime;
	}
	public void setReplyTime(String replyTime) {
		this.replyTime = replyTime;
	}
	public StringBuilder getJson(){
		StringBuilder json = new StringBuilder();
		json.append("[{");
		json.append("postId:").append(this.postId).append("\",");
		json.append("postName:\"").append(this.postName).append("\",");;
		json.append("replyAuthor:\"").append(this.replyAuthor).append("\",");
		json.append("replyContent:\"").append(this.replyCotent).append("\",");
		json.append("replyContent:\"").append(this.replyTime).append("\",");
		json.append("replyId:").append(this.replyId);
		json.append("}]").append(",");
		return json; 
	}
	
}
