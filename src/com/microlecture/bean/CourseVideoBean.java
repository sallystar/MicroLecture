package com.microlecture.bean;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * �γ���ҳ��΢��
 * */

public class CourseVideoBean {

	private int videoId;	//��ƵID
	private String	videoName;	//��Ƶ��
	private String	videoThumbUrl;	//��Ƶ����ͼRUL
	private String	videoChapter;  //��Ƶ�½�
	private String videoUrl;
	
	public CourseVideoBean() {
		super();
	}
	public int getVideoId() {
		return videoId;
	}
	public void setVideoId(int videoId) {
		this.videoId = videoId;
	}
	public String getVideoName() {
		return videoName;
	}
	public void setVideoName(String videoName) {
		this.videoName = videoName;
	}
	public String getVideoThumbUrl() {
		return videoThumbUrl;
	}
	public void setVideoThumbUrl(String videoThumbUrl) {
		this.videoThumbUrl = videoThumbUrl;
	}
	public String getVideoChapter() {
		return videoChapter;
	}
	public void setVideoChapter(String videoChapter) {
		this.videoChapter = videoChapter;
	}
	public String getVideoUrl() {
		return videoUrl;
	}
	public void setVideoUrl(String videoUrl) {
		this.videoUrl = videoUrl;
	}
	
}
