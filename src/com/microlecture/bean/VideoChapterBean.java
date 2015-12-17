package com.microlecture.bean;

import java.util.ArrayList;

public class VideoChapterBean {
	private String chapter;	//�½�
	public ArrayList<String> videoNames; //��Ƶ���
	public String getChapter() {
		return chapter;
	}
	public void setChapter(String chapter) {
		this.chapter = chapter;
	}
	public ArrayList<String> getVideoName() {
		return videoNames;
	}
	public void setVideoName(ArrayList<String> videoName) {
		this.videoNames = videoName;
	}
}
