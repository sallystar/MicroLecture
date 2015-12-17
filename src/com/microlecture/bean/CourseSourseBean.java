package com.microlecture.bean;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * �γ�    ��Դ
 * */
public class CourseSourseBean {
	private int sourseId;				//��Դid
	private String sourseName;			//��Դ���?
	private String sourseThumbUrl;		//��Դ����ͼ��url
	private String sourseForm;			//��Դ��ʽ
	private String updateTime;
	private String sourseUrl;
	private String sourseAuthor;
	private	long sourseLength;
	private String sourseType;
	private int courseId;
	public int getSourseId() {
		return sourseId;
	}
	public void setSourseId(int sourseId) {
		this.sourseId = sourseId;
	}
	public String getSourseName() {
		return sourseName;
	}
	public void setSourseName(String sourseName) {
		this.sourseName = sourseName;
	}
	public String getSourseForm() {
		return sourseForm;
	}
	public void setSourseForm(String sourseForm) {
		this.sourseForm = sourseForm;
	}
	public String getSourseThumbUrl() {
		return sourseThumbUrl;
	}
	public void setSourseThumbUrl(String sourseThumbUrl) {
		this.sourseThumbUrl = sourseThumbUrl;
	}
	public String getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}
	public String getSourseUrl() {
		return sourseUrl;
	}
	public void setSourseUrl(String sourseUrl) {
		this.sourseUrl = sourseUrl;
	}
	public String getSourseAuthor() {
		return sourseAuthor;
	}
	public void setSourseAuthor(String sourseAuthor) {
		this.sourseAuthor = sourseAuthor;
	}
	public long getSourseLength() {
		return sourseLength;
	}
	public void setSourseLength(long sourseLength) {
		this.sourseLength = sourseLength;
	}
	public String getSourseType() {
		return sourseType;
	}
	public void setSourseType(String sourseType) {
		this.sourseType = sourseType;
	}
	public int getCourseId() {
		return courseId;
	}
	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}
	
}
