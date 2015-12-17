package com.microlecture.bean;

/**
 * ����Ƶ��ص�
 * 
 * */
public class VideoRevelance {
	private int relevanceId;		//��ص�id
	private String relevanceName;	//��
	private String uploadAuthor;	//����
	private String uploadTime;		//�ϴ�ʱ��
	private String relevanceUrl;	//����
	public int getRelevanceId() {
		return relevanceId;
	}
	public void setRelevanceId(int relevanceId) {
		this.relevanceId = relevanceId;
	}
	public String getRelevanceName() {
		return relevanceUrl;
	}
	public void setRelevanceName(String relevanceName) {
		relevanceUrl = relevanceName;
	}
	public String getUploadAuthor() {
		return uploadAuthor;
	}
	public void setUploadAuthor(String uploadAuthor) {
		this.uploadAuthor = uploadAuthor;
	}
	public String getUploadTime() {
		return uploadTime;
	}
	public void setUploadTime(String uploadTime) {
		this.uploadTime = uploadTime;
	}
	public String getRelevanceUrl() {
		return relevanceUrl;
	}
	public void setRelevanceUrl(String relevanceUrl) {
		this.relevanceUrl = relevanceUrl;
	}
}
