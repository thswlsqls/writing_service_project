package com.project.model;

import java.io.IOException;
import java.io.InputStream;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class InteractionMapperDAO {
	
	private SqlSessionFactory sqlSessionFactory;
	
	public InteractionMapperDAO(){
		InputStream inputStream = null;

		try {
			String resource = "config/mybatis-Config.xml"; //Spring �������� ���� ����
			inputStream = Resources.getResourceAsStream(resource);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream); 
	}
	//�ȷο�(ģ���߰�)
	/**
	 * INSERT INTO follow_list(follow_no, followee_id, follower_id, follow_date) VALUES(FOLLOW_NO_SEQ.nextval, ?, ?, sysdate);
	 * */
	public int addFollow(FollowListVO vo){
		SqlSession session = sqlSessionFactory.openSession();
		int result = 0;
		
		try {
			result = session.insert("interactionMapper.addFollow", vo);
			session.commit();
		} catch(Exception e){
			e.printStackTrace();
		} finally {
			session.close();
		}
		return result;
	}
	
   //�ȷο� ��� ��ȸ
   /**
    * select fl.follow_no, to_char(fl.follow_date, 'yyyy.mm.dd'), fl.followee_id, fl.follower_id, a.pen_name
      from follow_list fl, app_user a
      where fl.followee_id = a.user_id
      AND fl.follower_id = 'test2';
    * 
    * */
   public Collection<FollowListVO> getFollowList(String followerId) 
         throws SQLException{
	  
      Collection<FollowListVO> list = new ArrayList();
      
      SqlSession session = sqlSessionFactory.openSession();
      try {
    	  list = session.selectList("interactionMapper.selectFollowList");
      }catch(Exception e){
    	  e.printStackTrace();
      }finally{
    	  session.close();
      }
      
      return list;
   }
	   
   /**
  *�ȷο�(ģ��) ����� �ֽż� ������ ��ȸ
    select fl.follow_no, to_char(fl.follow_date, 'yyyy.mm.dd'), fl.followee_id, fl.follower_id, a.pen_name
          from follow_list fl, app_user a
          where fl.followee_id = a.user_id
          AND fl.follower_id = 'test2'
    ORDER BY fl.follow_date;
  * 
  * */
   public Collection<FollowListVO> getSortedByDateFollowList(String followerId) 
		   throws SQLException{
	   
	   Collection<FollowListVO> list = new ArrayList();
	   
	   SqlSession session = sqlSessionFactory.openSession();
	      try {
	    	  list = session.selectList("interactionMapper.selectFollowListOrderByDate");
	      }catch(Exception e){
	    	  e.printStackTrace();
	      }finally{
	    	  session.close();
	      }
	   
	   return list;
   }
   
   /**
    * �ȷο�(ģ��) ����� �ʸ� �����ټ� ������ ��ȸ
    *    select fl.follow_no, to_char(fl.follow_date, 'yyyy.mm.dd'), fl.followee_id, fl.follower_id, a.pen_name
         from follow_list fl, app_user a
         where fl.followee_id = a.user_id
         AND fl.follower_id = 'test2
      ORDER BY a.pen_name;
    * */
   
   public Collection<FollowListVO> getSortedByPenNameFollowList(String followerId) 
         throws SQLException{
      Collection<FollowListVO> list = new ArrayList();
      
      SqlSession session = sqlSessionFactory.openSession();
      try {
    	  list = session.selectList("interactionMapper.selectFollowListOrderByPenName");
    	  session.commit();
      }catch(Exception e){
    	  e.printStackTrace();
      }finally{
    	  session.close();
      }
      
      return list;
   }
   
 //���ƿ� �߰�
 	public int addReaction(String userId, String writeNo) 
 			throws SQLException {
 		  int result = 0;
 	      SqlSession session = sqlSessionFactory.openSession();

 	      try {
 	    	  result = session.insert("interactionMapper.addReaction", new Reaction(writeNo, userId));
 	    	  session.commit();
 	      }catch(Exception e){
 	    	  e.printStackTrace();
 	      }finally{
 	    	  session.close();
 	      }
 		return result;
 	} 
 	
 	//���ƿ� ����
 	public int deleteReaction(String userId, String writeNo) 
 			throws SQLException {
		  int result = 0;
 	      SqlSession session = sqlSessionFactory.openSession();
 		
 	      try {
 	    	  result = session.delete("interactionMapper.deleteReaction", new Reaction(writeNo, userId));
 	    	  session.commit();
 	      }catch(Exception e){
 	    	  e.printStackTrace();
 	      }finally{
 	    	  session.close();
 	      }
 	      
 		return result;
 	} 

 		
 		// ���ƿ� ��Ͽ��� ��ȸ
		//SELECT COUNT(user_id) FROM reaction WHERE user_id = ? AND write_no = ?;
		public int isReacted(String userId, String writeNo) 
				throws SQLException{
			int result = 0;
			
 	      SqlSession session = sqlSessionFactory.openSession();
 	 		
 	      try {
 	    	  result = session.selectOne("interactionMapper.isReacted", new Reaction(writeNo, userId));
 	      }catch(Exception e){
 	    	  e.printStackTrace();
 	      }finally{
 	    	  session.close();
 	      }
			return result;
		}
 		
		/**
	  	 * ���ƿ� �� ���� ��ȸ
	  	 * SELECT count(*) FROM reaction WHERE write_no = '1';
	  	 * */
	  	public int countReactions(String writeNo) 
				throws SQLException {
			  int cnt=0;
	 	      SqlSession session = sqlSessionFactory.openSession();
	 	 		
	 	      try {
	 	    	  cnt = session.selectOne("interactionMapper.selectReactionsCnt", writeNo);
	 	      }catch(Exception e){
	 	    	  e.printStackTrace();
	 	      }finally{
	 	    	  session.close();
	 	      }
			
			return cnt;
		}
	  	
	  	/**
	     * ���ã�� ���� ��ȸ
	     * SELECT * FROM bookmark WHERE user_id='test1' AND write_no='6';
	     * */
	  	public int isBookmarked(String userId, String writeNo) 
				throws SQLException {
	  		int result= 0;
			
			SqlSession session = sqlSessionFactory.openSession();
 	 		
	 	      try {
	 	    	  result = session.selectOne("interactionMapper.selectIsBookmarked"
	 	    			  , new BookmarkVO(writeNo, userId, null));
	 	      }catch(Exception e){
	 	    	  e.printStackTrace();
	 	      }finally{
	 	    	  session.close();
	 	      }
	 	      
			return result;
		}

	  	
}


class Reaction{
	
	private String writeNo;
	private String userId;

	public Reaction(String writeNo, String userId) {
		super();
		setWriteNo(writeNo);
		setUserId(userId);
	}
	
	public String getWriteNo() {
		return writeNo;
	}
	public void setWriteNo(String writeNo) {
		this.writeNo = writeNo;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	@Override
	public String toString() {
		return "Reaction [writeNo=" + writeNo + ", userId=" + userId + "]\n";
	}
	
}

class Bookmark{
	private String writeNo;
	private String userId;

	public Bookmark(String writeNo, String userId) {
		super();
		setWriteNo(writeNo);
		setUserId(userId);
	}
	
	public String getWriteNo() {
		return writeNo;
	}
	public void setWriteNo(String writeNo) {
		this.writeNo = writeNo;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	@Override
	public String toString() {
		return "Reaction [writeNo=" + writeNo + ", userId=" + userId + "]\n";
	}
	
}


