package com.microlecture.bean;

import java.util.ArrayList;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * 错题集
 * */
public class AccuracyBean {
	private int videoId;	//视频id>
		private String  testName;	//测试题目1 >
		private double 	errorRate;	//错误率
		/*private String	testName2;	//test2  >
		private double 	errorRate2;
		private String 	testName3;	//test3	>	
		private double   errorRate3;
		private String 	testName4;	//test3	>	
		private double  errorRate4;*/
		public int getVideoId() {
			return videoId;
		}
		public void setVideoId(int videoId) {
			this.videoId = videoId;
		}
		public String getTestName() {
			return testName;
		}
		public void setTestName(String testName1) {
			this.testName = testName1;
		}
		public double getErrorRate() {
			return errorRate;
		}
		public void setErrorRate(double errorRate1) {
			this.errorRate = errorRate1;
		}/*
		public String getTestName2() {
			return testName2;
		}
		public void setTestName2(String testName2) {
			this.testName2 = testName2;
		}
		public double  getErrorRate2() {
			return errorRate2;
		}
		public void setErrorRate2(double errorRate2) {
			this.errorRate2 = errorRate2;
		}
		public String getTestName3() {
			return testName3;
		}
		public void setTestName3(String testName3) {
			this.testName3 = testName3;
		}
		public double getErrorRate3() {
			return errorRate3;
		}
		public void setErrorRate3(double errorRate3) {
			this.errorRate3 = errorRate3;
		}
		
		public String getTestName4() {
			return testName4;
		}
		public void setTestName4(String testName4) {
			this.testName4 = testName4;
		}
		public double getErrorRate4() {
			return errorRate4;
		}
		public void setErrorRate4(double errorRate4) {
			this.errorRate4 = errorRate4;
		}*/
		
}
