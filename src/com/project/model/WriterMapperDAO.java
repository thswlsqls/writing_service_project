package com.project.model;

import java.io.IOException;
import java.io.InputStream;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class WriterMapperDAO {

	private SqlSessionFactory sqlSessionFactory;
	
	public WriterMapperDAO(){
		InputStream inputStream = null;

		try {
			String resource = "config/mybatis-Config.xml"; //Spring 설정으로 변경 가능
			inputStream = Resources.getResourceAsStream(resource);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream); 
	}
	
	  /**
	  * 친구글 목록 조회  -> 글번호 필요함, 작성자 아이디 필요함
		SELECT b.write_no, b.writer_id, s.suggestion_name, b.contents, a.pen_name, b.write_date, e.emotion_code, e.emotion_name
		FROM app_user a, board b, suggestion s, emotion e, follow_list fl
		WHERE b.writer_id = a.user_id 
		AND b.suggestion_code = s.suggestion_code 
		AND a.user_id = fl.followee_id
		AND e.emotion_code = s.emotion_code
		"       and b.share_status = '전체' " +
		AND fl.follower_id = ?
		ORDER BY write_date DESC;
	   **/
	   public Collection<BoardVO> getFriendWriteList(String followerId) 
			   throws SQLException {
			Collection<BoardVO> list = new ArrayList<BoardVO>();

			SqlSession session = sqlSessionFactory.openSession();

			try {
				list = session.selectList("writerMapper.selectFriendsBoards", followerId);
		      }catch(Exception e){
		    	  e.printStackTrace();
		      }finally{
		    	  session.close();
		      }
			
			return list;
		} 
	   
	   
	   /**
	    * 게시글 상세조회
	    * select b.write_no, b.writer_id, s.suggestion_name, b.contents, a.pen_name, b.write_date, e.emotion_code, e.emotion_name
			from app_user a, board b, suggestion s, emotion e
			where b.writer_id = a.user_id and b.suggestion_code = s.suggestion_code and e.emotion_code = s.emotion_code
			and b.write_no = '1';
	    **/
		public BoardVO getWriteDetail(String writeNo) throws SQLException {
			BoardVO v = null;

			SqlSession session = sqlSessionFactory.openSession();

			try {
		    	  v = session.selectOne("writerMapper.selectBoardDetails", writeNo);
		      }catch(Exception e){
		    	  e.printStackTrace();
		      }finally{
		    	  session.close();
		      }
			
			return v;
		}
	    
	    
}
