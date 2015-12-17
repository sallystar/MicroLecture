package com.microlecture.manager;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.http.HttpSession;

import com.microlecture.bean.ChapterBean;
import com.microlecture.bean.CourseBean;
import com.microlecture.bean.CourseSourseBean;
import com.microlecture.bean.CourseVideoBean;
import com.microlecture.bean.AccuracyBean;
import com.microlecture.bean.ExamNotifyBean;
import com.microlecture.bean.FeedbackBean;
import com.microlecture.bean.HomePageBean;
import com.microlecture.bean.MentoringBean;
import com.microlecture.bean.NotificationBean;
import com.microlecture.bean.PersonBean;
import com.microlecture.bean.PostBean;
import com.microlecture.bean.ReplyBean;
import com.microlecture.bean.SubmitTestBean;
import com.microlecture.bean.TaskNotifyBean;
import com.microlecture.bean.VideoChapterBean;
import com.microlecture.bean.VideoDiscussBean;
import com.microlecture.bean.VideoInfoBean;
import com.microlecture.bean.VideoRevelance;
import com.microlecture.bean.VideoTestBean;
import com.microlecture.statictool.StaticValue;

public class SQLReader {
	private Connection conn = null;
	String SQL_DRIVER_NAME = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	String SQL_URL = "jdbc:sqlserver://localhost:1433; DatabaseName=Microlecture";
	String userName = "sa"; // 默锟斤拷锟矫伙拷锟斤拷
	String userPwd = "123456"; // 锟斤拷锟斤拷

	public SQLReader() {
		try {
			Class.forName(SQL_DRIVER_NAME);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			conn = DriverManager.getConnection(SQL_URL, userName, userPwd);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * 锟斤拷取锟斤拷锟接筹拷
	 * 
	 * @return conn
	 * */
	public Connection getConnection() {
		return this.conn;
	}

	public void closeConn() {
		try {
			this.conn.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * 锟斤拷页锟斤拷锟斤拷 锟斤拷取锟斤拷锟斤拷支锟街的课程碉拷锟斤拷息
	 * */
	public ArrayList<HomePageBean> getCourse() {
		ArrayList<HomePageBean> list = new ArrayList<HomePageBean>();

		try {
			PreparedStatement ps = conn
					.prepareStatement(StaticValue.COURSE_QUERY);
			ResultSet rs = ps.executeQuery();
			while (rs.next() && rs != null) {
				HomePageBean course = new HomePageBean();
				System.out.println(rs.getInt("id"));
				course.setId(rs.getInt("id"));
				course.setCourse(rs.getString("name"));
				course.setIconPath(rs.getString("thumbnail"));
				list.add(course);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	/**
	 * 锟斤拷取锟斤拷锟脚课程碉拷锟斤拷锟斤拷锟铰节碉拷锟斤拷频锟斤拷锟斤拷息
	 * 
	 * @param id
	 *            锟轿筹拷id
	 * @return 微锟斤拷锟斤拷锟叫碉拷锟斤拷频锟斤拷息
	 * */
	public ArrayList<CourseVideoBean> getCourseVideo(int id) {
		ArrayList<CourseVideoBean> list = new ArrayList<CourseVideoBean>();

		try {
			PreparedStatement ps = conn
					.prepareStatement(StaticValue.COURSE_LECTURE_QUERY + id);
			ResultSet rs = ps.executeQuery();
			while (rs.next() && rs != null) {
				CourseVideoBean lecture = new CourseVideoBean();
				lecture.setVideoId(rs.getInt("id"));
				lecture.setVideoChapter(rs.getString("chapter"));
				lecture.setVideoName(rs.getString("name"));
				lecture.setVideoThumbUrl(rs.getString("thumbnail_url"));
				list.add(lecture);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	public ArrayList<CourseVideoBean> getCourseSWF(int id) {
		ArrayList<CourseVideoBean> list = new ArrayList<CourseVideoBean>();

		try {
			PreparedStatement ps = conn
					.prepareStatement("select * from Table_Video where url like '%swf' and courseId ="
							+ id);
			ResultSet rs = ps.executeQuery();
			while (rs.next() && rs != null) {
				CourseVideoBean lecture = new CourseVideoBean();
				lecture.setVideoId(rs.getInt("id"));
				lecture.setVideoChapter(rs.getString("chapter"));
				lecture.setVideoName(rs.getString("name"));
				lecture.setVideoThumbUrl(rs.getString("thumbnail_url"));
				lecture.setVideoUrl(rs.getString("url"));
				list.add(lecture);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	/**
	 * 锟斤拷取某锟斤拷锟轿程碉拷锟斤拷氐锟斤拷锟皆�
	 * 
	 * @param 锟矫课程碉拷id
	 * @return 锟斤拷锟斤拷锟斤拷每纬锟斤拷锟截碉拷锟斤拷源锟斤拷息
	 * 
	 * */
	/*
	 * public ArrayList<CourseSourseBean> getCourseSourse(int courseId) {
	 * ArrayList<CourseSourseBean> list = new ArrayList<CourseSourseBean>();
	 * CourseSourseBean bean = new CourseSourseBean(); try { PreparedStatement
	 * ps = conn .prepareStatement(StaticValue.COURSE_SOURSE_QUERY + courseId);
	 * ResultSet rs = ps.executeQuery(); while (rs.next() && rs != null) {
	 * bean.setSourseId(rs.getInt("id"));
	 * bean.setSourseName(rs.getString("name"));
	 * bean.setSourseThumbUrl("thumbnail_url"); bean.setUpdateTime("time");
	 * bean.setSourseUrl("url"); bean.setSourseAuthor("author"); list.add(bean);
	 * // bean.setSourseForm(sourseForm) } } catch (SQLException e) { // TODO
	 * Auto-generated catch block e.printStackTrace(); }
	 * 
	 * return list; }
	 */

	/**
	 * 锟斤拷取锟轿筹拷锟斤拷氐锟斤拷锟皆达拷锟斤拷锟较�
	 * 
	 * @param vid
	 *            锟斤拷频锟斤拷id
	 * @return
	 * */
	/*
	 * public ArrayList<CourseRevelance> getCourseRevelance(int vId){
	 * ArrayList<CourseRevelance> list = new ArrayList<CourseRevelance>();
	 * CourseRevelance bean = new CourseRevelance(); try { PreparedStatement ps
	 * = conn.prepareStatement(StaticValue.COURSE_SOURSE_QUERY + vId); ResultSet
	 * rs = ps.executeQuery(); while(rs.next() && rs!=null){
	 * bean.setPostId(rs.getInt("id")); bean.setPostName("name");
	 * list.add(bean); } } catch (SQLException e) { // TODO Auto-gene rated
	 * catch block e.printStackTrace(); }
	 * 
	 * return list; }
	 */
	/**
	 * 锟斤拷取锟斤拷锟斤拷通知
	 * 
	 * @return
	 * */
	public ArrayList<ExamNotifyBean> getExamNotify() {
		ArrayList<ExamNotifyBean> list = new ArrayList<ExamNotifyBean>();
		ExamNotifyBean bean = new ExamNotifyBean();
		try {
			PreparedStatement ps = conn
					.prepareStatement(StaticValue.EXAM_NOTIFI_QUERY);
			ResultSet rs = ps.executeQuery();
			while (rs.next() && rs != null) {
				bean.setExamId(rs.getInt("id"));
				bean.setExamSchedule(rs.getString("examSchedule"));
				bean.setExamTime(rs.getString("examTime"));
				bean.setUpdateTime(rs.getString("updateTime"));
				int courseId = rs.getInt("courseId");
				// PreparedStatement ps0 =
				// conn.prepareStatement(StaticValue.EXAM_SUBJECT_QUERY +
				// courseId);
				ResultSet rs0 = ps.executeQuery(StaticValue.EXAM_SUBJECT_QUERY);
				bean.setExamSubject(rs0.getString("name"));
				list.add(bean);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	/**
	 * 锟斤拷锟斤拷锟斤拷锟斤拷荽娲�锟斤拷荽娲拷锟斤拷锟斤拷锟斤拷盏锟斤拷锟斤拷锟捷憋拷锟芥到锟斤拷菘锟�
	 * */
	public boolean publishPostSave(PostBean bean) {
		boolean success = false;
		try {

			int id = 10000 + getRowCount("Table_Post") + 1;
			PreparedStatement ps = conn
					.prepareStatement(StaticValue.PUBLISH_POST_INSERT + id
							+ "," + bean.getTitle() + "," + bean.getContent()
							+ "," + bean.getAuthor_id() + "," + bean.getTime()
							+ "," + bean.getvId() + ")");
			success = ps.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return success;
	}

	/**
	 * 统锟斤拷锟杰癸拷锟叫硷拷锟斤拷
	 * 
	 * @param table
	 *            锟斤拷锟斤拷
	 * @return 锟斤拷锟斤拷
	 * */
	public int getRowCount(String table) {
		int count = 0;
		try {
			PreparedStatement ps = conn
					.prepareStatement("select count(*)  as count from " + table);
			ResultSet rs = ps.executeQuery();
			while (rs.next())
				count = rs.getInt("count");
			// rs.get
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}

	/**
	 * 锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷息锟斤拷锟芥到锟斤拷菘猓�
	 * 
	 * @param bean
	 *            锟截革拷锟斤拷锟斤拷锟絙ean
	 * @return 锟斤拷锟絫able_post锟�锟斤拷锟斤拷要锟截革拷锟斤拷锟斤拷锟斤拷锟絠d锟津返伙拷false
	 *         锟斤拷锟斤拷锟斤拷锟津返伙拷true
	 * */
	
	  public boolean replyInsert(ReplyBean bean) {
		  String sql = "insert into Table_Replys(content,time,post_id,author_id,postor_id)" +
		  		"select '"+bean.getContent()+"','"+bean.getTime()+"',"+bean.getPost_id()+","
		  		+"Table_Person.id as authorId,(select Table_Person.id as authorIds from " +
		  		"Table_Person where name = '" +bean.getUser().getName()+
		  		"') from Table_Person where name ='"+bean.getReplyUser().getName()+"'";
		  return insert(sql); 
	 }
	 public boolean postInsert(VideoDiscussBean bean){
		 String sql = "insert into Table_Post(content,time,vId,author_id)" +
			  		"select '"+bean.getPostContent()+"','"+bean.getPostTime()+"',"+bean.getVideoId()+","
			  		+"id from Table_Person where name ='"+bean.getPostAuthor()+"'";
		  System.out.println(sql);
		 return insert(sql);
	 }
	/**
	 * 锟斤拷锟絠d锟角凤拷锟斤拷锟�
	 * 
	 * @param table
	 *            锟斤拷锟斤拷
	 * @return锟斤拷锟斤拷 false 锟斤拷锟斤拷锟节ｏ拷锟斤拷锟斤拷true 锟斤拷锟斤拷锟斤拷
	 * */
	public boolean checkIfIdExist(String sql) {
		int count = 0;
		try {
			PreparedStatement ps = conn
					.prepareStatement("select count(*)  as count from " + sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next())
				count = rs.getInt("count");
			if (count >= 1)
				return true;
			// rs.get
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	/**
	 * 锟结交锟金案ｏ拷锟斤拷锟斤拷息锟斤拷锟斤拷锟斤拷菘锟�
	 * 
	 * */
	/*public void submitTestSave(SubmitTestBean bean) {
		int count = 0;
		count = getCount("Table_Test_Count", bean.getSelectAnswer());
		count++;
		update(StaticValue.TEST_COUNT_UPDATE + bean.getSelectAnswer() + "="
				+ count);
		count = getCount("Table_Test_Count", "submit_count");
		count++;
		update(StaticValue.TEST_COUNT_UPDATE + "submit_count" + count);
	}
*/
	/*
	 * 锟斤拷取某一锟叫碉拷统锟斤拷值
	 * 
	 * @param table 锟斤拷锟斤拷
	 * 
	 * @param row 锟斤拷锟斤拷
	 * 
	 * @return 锟斤拷值
	 */
	public int getCount(String table, String row) {
		int count = 0;
		try {
			PreparedStatement ps = conn.prepareStatement("select " + row
					+ " from " + table);
			ResultSet rs = ps.executeQuery();
			while (rs.next())
				count = rs.getInt(row);
			rs.close();
			ps.close();
			return count;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	/**
	 * 锟斤拷锟斤拷
	 * */
	public boolean insert(String sql) {
		boolean success = false;
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			success = ps.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return success;
	}

	/**
	 * 锟斤拷锟斤拷
	 * 
	 * */
	public int  update(String sql) {
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			int i = ps.executeUpdate();
			ps.close();
			return i;
		} catch (SQLException e) {
			e.printStackTrace();
			return -1;
		}
	}

	/**
	 * 锟斤拷询锟街凤拷
	 * */
	public String queryString(String sql, String column) {
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next() && rs != null) {
				return rs.getString(column);
			}

		} catch (SQLException e) {

		}
		return null;
	}

	public int queryInt(String table, int vId) {
		int count = 0;
		String sql = "select * from " + table + "where id=" + vId;
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			count = ps.executeQuery().getInt("count");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}

	/**
	 * 锟斤拷询
	 * */
	public ResultSet query(String sql) {
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			return ps.executeQuery();
		} catch (SQLException e) {

		}
		return null;
	}

	/**
	 * 锟斤拷业锟侥憋拷锟斤拷
	 * 
	 * */
	public boolean taskNotifiSave(TaskNotifyBean bean) {
		String sql = "insert Table_Task(id,task,task_submit_time,update_time,course_id)values(";
		sql = sql + bean.getTaskId() + "," + bean.getTask() + ","
				+ bean.getTaskSubmitTime() + "," + bean.getUpdateTime() + ","
				+ bean.getCourseId();
		return insert(sql);
	}

	/**
	 * 锟斤拷取锟斤拷业锟侥帮拷锟斤拷
	 * 
	 * @return 锟斤拷锟斤拷list TaskNotifybean
	 * */
	public ArrayList<TaskNotifyBean> getTaskNotify() {
		ArrayList<TaskNotifyBean> list = new ArrayList<TaskNotifyBean>();
		TaskNotifyBean bean = new TaskNotifyBean();
		try {
			PreparedStatement ps = conn
					.prepareStatement(StaticValue.EXAM_NOTIFI_QUERY);
			ResultSet rs = ps.executeQuery();
			while (rs.next() && rs != null) {
				bean.setTaskId(rs.getInt("id"));
				bean.setTask(rs.getString("task"));
				bean.setTaskSubmitTime(rs.getString("task_submit_time"));
				bean.setUpdateTime(rs.getString("updateTime"));
				int courseId = rs.getInt("courseId");
				bean.setCourseId(courseId);
				// PreparedStatement ps0 =
				// conn.prepareStatement(StaticValue.EXAM_SUBJECT_QUERY +
				// courseId);
				ResultSet rs0 = ps.executeQuery(StaticValue.EXAM_SUBJECT_QUERY);
				bean.setCourseName(rs0.getString("name"));
				list.add(bean);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public ArrayList<VideoDiscussBean> getVideoDiscuss(int videoId) {
		ArrayList<VideoDiscussBean> list = new ArrayList<VideoDiscussBean>();

		String sql = "select Table_Person.id as authorId, Table_Person.name as author,Table_Post.id as id,content,time "
				+ "from Table_Post,Table_Person "
				+ "where Table_Post.author_id = Table_Person.id and Table_Post.vId =";
		ResultSet rs = query(sql + videoId);
		try {
			while (rs != null && rs.next()) {
				VideoDiscussBean bean = new VideoDiscussBean();
				bean.setPostId(rs.getInt("id"));
				bean.setPostAuthor(rs.getString("author"));
				bean.setPostAuthorId(rs.getInt("authorId"));
				bean.setPostContent(rs.getString("content"));
				bean.setPostTime(rs.getTime("time").toString());
				bean.setVideoId(videoId);
				list.add(bean);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	/**
	 * 锟斤拷取锟斤拷频锟斤拷息
	 * 
	 * @return 锟斤拷锟斤拷斜锟�
	 * 
	 * */
	public VideoInfoBean getVideoInfo(int videoId) {

		String sql = "select * from Table_video where id=" + videoId;
		ResultSet rs = query(sql);
		VideoInfoBean bean = new VideoInfoBean();
		try {
			while (rs != null && rs.next()) {
				bean.setThumbnail_url(rs.getString("thumbnail_url"));
				bean.setVideoChapter(rs.getString("chapter"));
				bean.setVideoDetails(rs.getString("introduce"));
				bean.setVideoId(rs.getInt("id"));
				bean.setVideoLength(rs.getInt("length"));
				bean.setVideoName(rs.getString("name"));
				bean.setVideoTeacher(rs.getString("teacher"));
				bean.setVideoUploadTime(rs.getString("upload_time"));
				bean.setVideoUrl(rs.getString("url"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return bean;

	}

	/**
	 * 锟斤拷频锟斤拷氐模锟�
	 * 
	 * @param vid
	 *            锟斤拷频id
	 * @return list
	 * */
	public ArrayList<VideoRevelance> getVideoRevelance(int vId) {
		ArrayList<VideoRevelance> list = new ArrayList<VideoRevelance>();

		String sql = "select Table_Recommend.id,Table_Recommend.upload_time,Table_Recommend.content," +
				" Table_Person.name as name from Table_Recommend," +
				"Table_Person where Table_Person.id = Table_Recommend.uploader and vId="+ vId;
		ResultSet rs = query(sql);
		System.out.println(sql);
		try {
			while (rs != null && rs.next()) {
				VideoRevelance bean = new VideoRevelance();
				bean.setRelevanceId(rs.getInt("id"));
				bean.setRelevanceName(rs.getString("content"));
				bean.setUploadAuthor(rs.getString("name"));
				bean.setUploadTime(rs.getString("upload_time"));
				list.add(bean);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	public int submitTest(ArrayList<SubmitTestBean> list){
		int FLAG = 0;
		
		try {
			
			for(int i = 0;i<list.size();i++){
				String sql = new String();
				sql = "update Table_Test_Count set "+ list.get(i).getSelectAnswer()
					+"=1+(select "+list.get(i).getSelectAnswer()+ " from Table_Test_Count where " +
							"test_id="+list.get(i).getTestId()+"),submit_count=1+(select submit_count" +
									" from Table_Test_Count where test_id="+list.get(i).getTestId()+")"
									+" where test_id="+list.get(i).getTestId();
			ResultSet rs = query("select * from Table_Test_Count where test_id ="+list.get(i).getTestId());
			System.out.println(sql);
			if(rs.next()){
			 FLAG = update(sql);
			}else{
				String insertSql = "insert into Table_Test_Count(test_id,"+list.get(i).getSelectAnswer()+")values("+
						list.get(i).getTestId()+",1)";
				if( insert(insertSql))
					FLAG = 1;
				else FLAG = -1;
			}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return FLAG;
	}
	/**
	 * 锟斤拷取锟斤拷频锟斤拷应锟侥诧拷锟斤拷锟斤拷
	 * 
	 * @param vId
	 *            锟斤拷频锟斤拷Id
	 * @return
	 * */
	public ArrayList<VideoTestBean> getVideoTest(int vId) {
		ArrayList<VideoTestBean> list = new ArrayList<VideoTestBean>();
		String sql = "select * from Table_test where vId=" + vId;
		ResultSet rs = query(sql);
		try {
			while (rs != null && rs.next()) {
				VideoTestBean bean = new VideoTestBean();
				bean.setTestId(rs.getInt("id"));
				bean.setVideoId(rs.getInt("vId"));
				bean.setAnswer(rs.getString("answer"));
				bean.setTestA(rs.getString("A"));
				bean.setTestB(rs.getString("B"));
				bean.setTestC(rs.getString("C"));
				bean.setTestD(rs.getString("D"));
				bean.setTestName(rs.getString("subject"));
				bean.setVideoId(vId);
				list.add(bean);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	public int getCount(String sql){
		ResultSet rs = query(sql);
		try {
			while(rs!= null&& rs.next()){
				return rs.getInt("nums");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
	public ArrayList<AccuracyBean> getAccuracy(int vId) {
		ArrayList<AccuracyBean> list = new ArrayList<AccuracyBean>();
		String sql = "select answer from Table_Test,Table_Test_Count where Table_Test.vId=" + vId+" and Table_Test.id = Table_Test_Count.test_id";
		String sql_count = "select count(answer) as nums from Table_Test where Table_Test.vId="+vId;
		int count = getCount(sql_count);
		System.out.println(sql);
		ResultSet rs = query(sql);
		try {
			while (rs != null && rs.next()) {
				//count--;
				String answer = rs.getString(1);
				String sql_subject = "select Table_Test_Count."+answer+",subject,submit_count " +
						" from Table_Test,Table_Test_Count where " +
						"Table_Test.id = Table_Test_Count.test_id and Table_Test.vId="+vId;
				System.out.println(answer);
				AccuracyBean bean = new AccuracyBean();
				ResultSet r = query(sql_subject);
				if(r!=null && r.next()){
					if(count == 3);
					else if(count == 2){
						r.next();
					}
					else if(count == 1){
						r.next();
						r.next();
					}
					count--;
					bean.setErrorRate((double)r.getInt(answer) / (double)r.getInt("submit_count"));
					bean.setTestName(r.getString("subject"));
					list.add(bean);
				}else{
					//return null;
				}
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			if(null!= rs&&!rs.isClosed())
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	/**
	 * 锟斤拷取锟铰斤拷锟皆硷拷锟铰斤拷锟斤拷锟叫碉拷锟斤拷频
	 * */
	public ArrayList<VideoChapterBean> getVideoChapter(int courseId) {
		ArrayList<VideoChapterBean> list = new ArrayList<VideoChapterBean>();
		String sql = "select distinct(convert(varchar(100),chapter)) from Table_Video where courseId="
				+ courseId;
		String sql_name = "select name from Table_Video where chapter like '";
		ResultSet rs = query(sql);
		try {
			while (rs != null && rs.next()) {
				VideoChapterBean bean = new VideoChapterBean();
				bean.setChapter(rs.getString("chapter"));
				ResultSet r = query(sql_name + rs.getString("chapter") + "'");
				ArrayList<String> l = new ArrayList<String>();
				while (r != null && r.next()) {
					l.add(r.getString("name"));
				}
				bean.setVideoName(l);
				list.add(bean);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}


	/*
	 * public PostBean getPost(int videoId){ String sql =
	 * "select * from Table_Post where vId="+videoId; ResultSet rs = query(sql);
	 * PostBean bean = null; try{ while(rs!=null && rs.next()){ bean = new
	 * PostBean(); bean.setPostAuthor(rs.getString("author"));
	 * bean.setPostContent(rs.getString("content"));
	 * bean.setPostId(rs.getInt("id")); bean.setPostTime(rs.getString("time"));
	 * bean.setvId(rs.getInt("vId")); } }catch (SQLException e){
	 * e.printStackTrace(); } return bean; }
	 */
	public ArrayList<MentoringBean> getMentoring(int pId) {
		ArrayList<MentoringBean> list = new ArrayList<MentoringBean>();
		MentoringBean bean = null;
		String sql = "select * from Table_Mentoring where pId=" + pId;
		ResultSet rs = query(sql);
		try {
			while (rs != null && rs.next()) {
				bean = new MentoringBean();
				bean.setAuthor(rs.getString("author"));
				bean.setPostAuthor(rs.getString("post_author"));
				bean.setPostId(rs.getInt("pId"));
				bean.setContent(rs.getString("content"));
				bean.setMentoringTime(rs.getString("time"));
				bean.setPostId(rs.getInt("pId"));
				list.add(bean);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	/**
	 * 锟斤拷取锟截革拷锟斤拷锟斤拷锟斤拷
	 * */
	public ArrayList<ReplyBean> getReply(int pId) {
		ArrayList<ReplyBean> list = new ArrayList<ReplyBean>();
		ReplyBean bean = null;
		String sql = "select u.name ,u.status,r.id ,u.account,r.content,r.id,r.post_id,r.postor_id," +
				"r.time from Table_Person as u," +
				"Table_Replys as r where u.id = r.author_id and post_id=" + pId+" order by r.time desc";
		ResultSet rs = query(sql);
		System.out.println(sql);
		try {
			while (rs != null && rs.next()) {
				String sql_user = " select p.name as replied_author,p.account,p.status " +
						"from Table_Person as p where p.id = "+rs.getString("postor_id");
				System.out.println(sql_user);
				ResultSet r = query(sql_user);
				PersonBean postor = new PersonBean();
				while(r!=null && r.next()){
					postor.setAccount(r.getString("account"));
					postor.setName(r.getString("replied_author"));
					postor.setStatus(r.getString("status"));
				}
				if(r!=null)
				r.close();
				bean = new ReplyBean();
				PersonBean user = new PersonBean();
				user.setAccount(rs.getString("account"));
				user.setName(rs.getString("name"));
				user.setStatus(rs.getString("status"));
				bean.setReplyUser(user);
				bean.setUser(postor);
				bean.setContent(rs.getString("content"));
				bean.setId(rs.getInt("id"));
				bean.setPost_id(rs.getInt("post_id"));
				bean.setTime(rs.getString("time"));
				//bean.set
				list.add(bean);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	/**
	 * 
	 * @param feedbackJSON
	 * @return
	 */
	public int feedback(String feedbackJSON) {
		FeedbackBean feedbackBean = (FeedbackBean) JSONUtil.JSONToBean(
				feedbackJSON, FeedbackBean.class);
		try {
			PreparedStatement ps = conn
					.prepareStatement("insert Table_Feedback(feedbackType,content,QQ) values(?,?,?) ");
			ps.setString(1, feedbackBean.getFeedbackType());
			ps.setString(2, feedbackBean.getContent());
			ps.setString(3, feedbackBean.getQQ());
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 1;

	}

	public ArrayList<ChapterBean> getChapters(int courseId) {
		ArrayList<ChapterBean> list = new ArrayList<ChapterBean>();
		/*
		 * String sql =
		 * "select distinct(chapter) from Table_Video where courseId=" +
		 * courseId; ResultSet rs = query(sql);
		 */
		String sql = "select distinct(chapter) from Table_Video where courseId=?";
		PreparedStatement ps;
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, courseId);
			ResultSet rs = ps.executeQuery();
			int i = 0;
			while (rs != null && rs.next()) {
				ChapterBean bean = new ChapterBean();
				bean.setChapterName(rs.getString("chapter"));
				ArrayList<VideoInfoBean> videoList = getVideoList(bean
						.getChapterName());
				bean.setVideoList(videoList);
				list.add(bean);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	public ArrayList<VideoInfoBean> getVideoList(String chapterName) {
		ResultSet resultSet = query("select * from Table_Video where chapter like'"
				+ chapterName + "'");
		ArrayList<VideoInfoBean> list = new ArrayList<VideoInfoBean>();
		try {
			while (resultSet != null && resultSet.next()) {
				VideoInfoBean bean = new VideoInfoBean();
				bean.setVideoId(resultSet.getInt("id"));
				bean.setVideoName(resultSet.getString("name"));
				list.add(bean);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;

	}

	public ArrayList<CourseBean> getCourseList() {
		ArrayList<CourseBean> list = new ArrayList<CourseBean>();
		try {
			PreparedStatement ps = conn
					.prepareStatement(StaticValue.COURSE_QUERY);
			ResultSet rs = ps.executeQuery();
			while (rs.next() && rs != null) {
				CourseBean course = new CourseBean();
				System.out.println(rs.getInt("id"));
				course.setId(rs.getInt("id"));
				course.setCourse(rs.getString("name"));
				course.setIconPath(rs.getString("thumbnail"));
				list.add(course);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;

	}

	public ArrayList<NotificationBean> getNotification() {
		ArrayList<NotificationBean> list = new ArrayList<NotificationBean>();

		try {
			PreparedStatement ps = conn
					.prepareStatement(StaticValue.NOTIFICATION_QUERY);
			ResultSet rs = ps.executeQuery();
			while (rs.next() && rs != null) {
				NotificationBean bean = new NotificationBean();
				bean.setId(rs.getInt("id"));
				bean.setType(rs.getInt("type"));
				bean.setContent(rs.getString("content"));
				bean.setTime(rs.getString("Time"));
				bean.setUpdateTime(rs.getString("update_Time"));
				int courseId = rs.getInt("course_id");
				bean.setCourseID(courseId);
				list.add(bean);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}

	public String getUserProfile(String account, String status) {
		String sql = "select top 1 * from Table_Person where account like ? and status like ?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, account);
			ps.setString(2, status);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				PersonBean personBean = new PersonBean();
				personBean.setName(rs.getString("name"));
				personBean.setAccount(rs.getString("account"));
				personBean.setMail(rs.getString("mail"));
				personBean.setPassWord(rs.getString("passWord"));
				personBean.setStatus(rs.getString("status"));
				System.out.println(JSONUtil.beanToJSON(personBean));
				return JSONUtil.beanToJSON(personBean);
			} else {
				return "";
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return "";
		}

	}

	public ArrayList<ReplyBean> getRevelanceList(String account, String status) {
		// TODO Auto-generated method stub
		/*String sql = "select u.id as [u.id], u.name as [u.name],"
				+ "u.mail as [u.mail],u.account as [u.account],"
				+ "u.status as [u.status],replyUser.id as [replyUser.id],"
				+ " replyUser.name as [replyUser.name],"
				+ "replyUser.mail as [replyUser.mail],"
				+ "replyUser.account as [replyUser.account],"
				+ "replyUser.status as [replyUser.status],"
				+ "p.id as [p.id],p.content as [p.content],"
				+ "p.author_id as [p.author_id],p.time as [p.time],"
				+ "p.vId as [p.vId],r.id as [r.id],"
				+ "r.content as [r.content]," + "r.author_id as [r.author_id],"
				+ "r.post_id as [r.post_id]," + "r.postor_id as[r.postor_id],"
				+ "r.time as [r.time] from Table_Person as u,"
				+ "Table_Person as replyUser,Table_Post as p,"
				+ "Table_Replys as r where " +
				"r.time>u.get_msg_time and u.account=? "
				+ "and u.status=? and p.author_id=u.id "
				+ "and p.id=r.post_id and r.author_id=replyUser.id";*/
		String sql = "	select ru.account as rAccount" +
				",ru.name as rAuthor" +
				",ru.status as rAStatus" +
				",pu.name as pAuthor" +
				",pu.account as pAccount"+
				",pu.status as pStatus"+
				",p.content as pContent" +
				",p.id as pId" +
				" ,p.vId" +
				",P.author_id as pAId" +
				",p.time as pTime" +
				",r.postor_id as rPId" +
				",r.author_id as rAId" +
				",r.id as rId,r.content as rContent" +
				" ,r.time as rTime from Table_Person as u," +
				"Table_Post as p,Table_Replys as r " +
				",Table_Person as pu" +
				",Table_Person as ru " +
				"where p.id = r.post_id " +
				"and pu.id = r.postor_id " +
				"and ru.id = r.author_id " +
				"and (r.author_id = u.id or r.postor_id = u.id)"+
				"and u.id =(select u.id as uId from Table_Person as u where u.account="+account+")";
		
		ArrayList<ReplyBean> list = new ArrayList<ReplyBean>();
		try {

			ResultSet rs = query(sql);

			// 试验性
			while (rs.next() && rs != null) {
				ReplyBean bean = new ReplyBean();
				bean.setId(rs.getInt("rId"));
				bean.setPost_id(rs.getInt("pId"));
				bean.setPostor_id(rs.getInt("rPId"));
				bean.setAuthor_id(rs.getInt("rAId"));
				bean.setContent(rs.getString("rContent"));
				bean.setTime(rs.getString("rTime"));

				PersonBean postor = new PersonBean();
				postor.setAccount(rs.getString("pAccount"));
				postor.setName(rs.getString("pAuthor"));
				postor.setStatus(rs.getString("pStatus"));
				bean.setUser(postor);

				PostBean post = new PostBean();
				post.setId(rs.getInt("pId"));
				post.setContent(rs.getString("pContent"));
				post.setTime(rs.getString("pTime"));
				post.setvId(rs.getInt("vId"));
				post.setAuthor_id(rs.getInt("pAId"));
				bean.setPostBean(post);

				PersonBean replyUser = new PersonBean();
				replyUser.setAccount(rs.getString("rAccount"));
				replyUser.setName(rs.getString("rAuthor"));
				replyUser.setStatus(rs.getString("rAStatus"));
				bean.setReplyUser(replyUser);
				list.add(bean);

			}
			SimpleDateFormat formatter = new SimpleDateFormat(
					"yyyy-MM-dd HH:mm:ss");
			Date curDate = new Date(System.currentTimeMillis());// 鑾峰彇褰撳墠鏃堕棿
			String time = formatter.format(curDate);
			String update_sql = "update Table_Person set get_msg_time='"+time+"'";
			update(update_sql);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}

	public String login(String account, String password, String status) {
		// TODO Auto-generated method stub
		PersonBean bean = new PersonBean();
		String sql = "select * from Table_Person where account like ? and passWord like ? and status like ?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, account);
			ps.setString(2, password);
			ps.setString(3, status);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				SimpleDateFormat formatter = new SimpleDateFormat(
						"yyyy-MM-dd HH:mm:ss");
				Date curDate = new Date(System.currentTimeMillis());// 获取当前时间
				String loginTime = formatter.format(curDate);
				updateLoginTime(account, password, status, loginTime);
				return rs.getString("name");
			} else {
				return null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public int updateLoginTime(String account, String password, String status,
			String loginTime) {
		String sql = "update Table_Person set login_time = ? where account like ? and passWord like ? and status like ?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, loginTime);
			ps.setString(2, account);
			ps.setString(3, password);
			ps.setString(4, status);
			int result = ps.executeUpdate();
			return result;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	public int publishNotification(NotificationBean bean) {
		try {
			PreparedStatement ps = conn
					.prepareStatement("insert Notification(type,content,time,update_time,course_id) values(?,?,?,?,?)");
			ps.setInt(1, bean.getType());
			ps.setString(2, bean.getContent());
			ps.setString(3, bean.getTime());
			ps.setString(4, bean.getUpdateTime());
			ps.setInt(5, bean.getCourseID());
			return ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	public int register(PersonBean bean) {

		try {
			String selectSql = "select count(*) as count from Table_Person where account like ? and status like ?";
			PreparedStatement select_ps = conn.prepareStatement(selectSql);
			select_ps.setString(1, bean.getAccount());
			select_ps.setString(2, bean.getStatus());
			ResultSet rs = select_ps.executeQuery();
			rs.next();
			if (rs.getInt("count") != 0)
				return 2;
			else {

				String insertSql = "insert Table_Person(name,account,password,mail,status) values(?,?,?,?,?)";
				PreparedStatement insert_ps = conn.prepareStatement(insertSql);
				insert_ps.setString(1, bean.getName());
				insert_ps.setString(2, bean.getAccount());
				insert_ps.setString(3, bean.getPassWord());
				insert_ps.setString(4, bean.getMail());
				insert_ps.setString(5, bean.getStatus());
				if (insert_ps.executeUpdate() >= 1) {
					SimpleDateFormat formatter = new SimpleDateFormat(
							"yyyy-MM-dd HH:mm:ss");
					Date curDate = new Date(System.currentTimeMillis());// 鑾峰彇褰撳墠鏃堕棿
					String time = formatter.format(curDate);
					update("update Table_Person set get_msg_time='2000-01-01 00:00:00' where account='"+bean.getAccount()+"'");
					return 1;
				} else
					return 0;
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return -1;
	}

	public ArrayList<CourseSourseBean> getResource(int courseId) {
		ArrayList<CourseSourseBean> list = new ArrayList<CourseSourseBean>();
		String sql = "select * from Resource where course_id =" + courseId;
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				CourseSourseBean bean = new CourseSourseBean();
				bean.setSourseId(rs.getInt("id"));
				bean.setSourseName(rs.getString("name"));
				bean.setSourseLength(rs.getLong("length"));
				bean.setSourseAuthor(rs.getString("author"));
				bean.setSourseUrl(rs.getString("url"));
				bean.setSourseThumbUrl("thumbnail_url");
				bean.setSourseType(rs.getString("type"));
				list.add(bean);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	/*public ArrayList<ReplyBean> getReply(int postId){
		return null;
	}*/

}
