package com.microlecture.bean;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * ѡ�񵥸���Ƶ�����ҳ
 * */
public class VideoInfoBean {
	private int videoId;			//��Ƶid
	private String videoUrl;		//��ƵURL
	private String videoName;		//��Ƶ���
	private String videoDetails;	//��Ƶ����
	private String videoTeacher;
	private float  videoLength;
	private String thumbnail_url;
	private String videoChapter;
	private String videoUploadTime;
	public int getVideoId() {
		return videoId;
	}
	public void setVideoId(int videoId) {
		this.videoId = videoId;
	}
	public String getVideoUrl() {
		return videoUrl;
	}
	public void setVideoUrl(String videoUrl) {
		this.videoUrl = videoUrl;
	}
	public String getVideoName() {
		return videoName;
	}
	public void setVideoName(String videoName) {
		this.videoName = videoName;
	}
	public String getVideoDetails() {
		return videoDetails;
	}
	public void setVideoDetails(String videoDetails) {
		this.videoDetails = videoDetails;
	}
	
	public String getVideoTeacher() {
		return videoTeacher;
	}
	public void setVideoTeacher(String videoTeacher) {
		this.videoTeacher = videoTeacher;
	}
	public float getVideoLength() {
		return videoLength;
	}
	public void setVideoLength(float videoLength) {
		this.videoLength = videoLength;
	}
	public String getThumbnail_url() {
		return thumbnail_url;
	}
	public void setThumbnail_url(String thumbnail_url) {
		this.thumbnail_url = thumbnail_url;
	}
	public String getVideoChapter() {
		return videoChapter;
	}
	public void setVideoChapter(String videoChapter) {
		this.videoChapter = videoChapter;
	}
	
	public String getVideoUploadTime() {
		return videoUploadTime;
	}
	public void setVideoUploadTime(String videoUploadTime) {
		this.videoUploadTime = videoUploadTime;
	}
}
