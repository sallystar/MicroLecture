package com.microlecture.statictool;

public class StaticValue {
		public static final String  COURSE_QUERY = "select * from Table_Course";//锟斤拷页锟斤拷询
		public static final String  COURSE_LECTURE_QUERY = "select * from Table_Video where url not like '%swf' and courseId =";//锟斤拷询微锟斤拷
		public static final String  COURSE_SOURSE_QUERY = "select * from Table_Sourse where id ="; //锟斤拷询锟斤拷源
		public static final String  EXAM_NOTIFI_QUERY = "select * from Table_Exam";			//锟斤拷询锟斤拷锟斤拷锟斤拷息
		public static final String 	EXAM_SUBJECT_QUERY = "select name from Table_Course where id =";//锟斤拷询锟斤拷锟皆匡拷目 
		//锟斤拷锟诫到post锟斤拷
		public static final String  PUBLISH_POST_INSERT = "insert Table_Post(id,name,content,author,time,vId) values (";
		public static final String  GET_POST_COUNT = "select count(*) from Table_Post where id is not null";
		//锟截革拷锟斤拷牟锟斤拷锟�
		public static final String  REPLY_POST_SAVE = "insert Table_Replys(id,name,content,author,cId,time,mentoring_author)" +
				"values(";
		//public static final String  CHECK_ID_EXIST = "select id ";
	    public static final String  SUBMIT_TEST_SAVE = "insert Table_ ";
	    public static final String  TEST_COUNT_UPDATE = "update Table_Test_Count set ";
	    public static final String NOTIFICATION_QUERY = "select * from Notification";
}
