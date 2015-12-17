package com.microlecture.bean;

public class ReplyBean {
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
	public int getPost_id() {
		return post_id;
	}
	public void setPost_id(int post_id) {
		this.post_id = post_id;
	}
	public int getPostor_id() {
		return postor_id;
	}
	public void setPostor_id(int postor_id) {
		this.postor_id = postor_id;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public int getAuthor_id() {
		return author_id;
	}
	public void setAuthor_id(int author_id) {
		this.author_id = author_id;
	}
	public PersonBean getUser() {
		return user;
	}
	public void setUser(PersonBean user) {
		this.user = user;
	}
	public PersonBean getReplyUser() {
		return replyUser;
	}
	public void setReplyUser(PersonBean replyUser) {
		this.replyUser = replyUser;
	}
	public PostBean getPostBean() {
		return postBean;
	}
	public void setPostBean(PostBean postBean) {
		this.postBean = postBean;
	}

	private int id;
	private String content;
	private int post_id;
	private int postor_id;
	private String time;
	private int author_id;
	private PersonBean user;
	private PersonBean replyUser;
	private PostBean postBean;

	
}
