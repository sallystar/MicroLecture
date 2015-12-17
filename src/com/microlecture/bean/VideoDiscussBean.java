package com.microlecture.bean;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * 锟斤拷频锟斤拷氐锟斤拷锟斤拷锟�
 * 
 * */
public class VideoDiscussBean {
	private int postId;				
	private String postName;
	private String postAuthor;
	private int postAuthorId;
	private String postContent;
	private String postTime;
	private int videoId;		//锟斤拷氐锟斤拷锟狡礽d
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
	public String getPostAuthor() {
		return postAuthor;
	}
	public void setPostAuthor(String postAuthor) {
		this.postAuthor = postAuthor;
	}
	public String getPostContent() {
		return postContent;
	}
	public void setPostContent(String postContent) {
		this.postContent = postContent;
	}
	public String getPostTime() {
		return postTime;
	}
	public void setPostTime(String postTime) {
		this.postTime = postTime;
	}
	public int getVideoId() {
		return videoId;
	}
	public void setVideoId(int videoId) {
		this.videoId = videoId;
	}
	public int getPostAuthorId() {
		return postAuthorId;
	}
	public void setPostAuthorId(int postAuthorId) {
		this.postAuthorId = postAuthorId;
	}
}
