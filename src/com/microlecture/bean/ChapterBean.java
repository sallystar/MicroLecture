package com.microlecture.bean;

import java.util.ArrayList;

public class ChapterBean {

	private String chapterName;
	private int videoSum;
	private ArrayList<VideoInfoBean> videoList;

	public ArrayList<VideoInfoBean> getVideoList() {
		return videoList;
	}

	public void setVideoList(ArrayList<VideoInfoBean> videoList) {
		this.videoList = videoList;
		videoSum =videoList.size();
	}

	public ChapterBean() {
		super();
	}

	public String getChapterName() {
		return chapterName;
	}

	public void setChapterName(String chapterName) {
		this.chapterName = chapterName;
	}

	public int getVideoSum() {
		return videoList.size();
	}
}
