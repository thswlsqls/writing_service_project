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

public class EmotionMapperDAO {
	private SqlSessionFactory sqlSessionFactory;
	
	public EmotionMapperDAO(){
		InputStream inputStream = null;

		try {
			String resource = "config/mybatis-Config.xml"; //Spring 설정으로 변경 가능
			inputStream = Resources.getResourceAsStream(resource);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream); 
	}
	
	// 감정 8개 추출 / 새로고침
		public Collection<String> getEmotionName() throws SQLException {
			Collection<String> result = new ArrayList<String>();
//			String[] emotionCode = {"100","200","300","400","500","600","700","800"};
			String[] mainEmotions = {"기쁨","행복","설렘","흥미","슬픔","분노","지루함","놀람"};
			
			SqlSession session = sqlSessionFactory.openSession();
			
			int num = 0;
			while(num < 8) {
//				String sql = "select emotion_name from (select * from emotion where main_emotion = ? order by dbms_random.random) " + 
//						"where rownum = 1 ";
//				PreparedStatement pstmt = conn.prepareStatement(sql);
//				pstmt.setString(1, mainEmotions[num]);
//				ResultSet rs = pstmt.executeQuery();
//				while (rs.next()) {
//					result.add(rs.getString(1));
//				}
//				pstmt.close();
//				rs.close();
				String mainEmotion = mainEmotions[num];
				String ename = session.selectOne("emotionMapper.selectRandomEmotionName", mainEmotion);
				result.add(ename);
				
				num++;
			}
			
			return result;
		}
		
		public boolean getMyEmotionName(String id) throws SQLException {
			boolean result=false;
			
			SqlSession session = sqlSessionFactory.openSession();
			
			/**String sql = "select emotion_code from empathy where user_id = ? "
					+ "and to_char(empathy_date,'yyyy-mm-dd') = to_char(sysdate,'yyyy-mm-dd')";
			PreparedStatement pstmt = conn.prepareStatement(sql);
		    pstmt.setString(1, id);
		    int num = pstmt.executeUpdate();
		    ResultSet rs = pstmt.executeQuery();
		    rs.next();
		    if (rs.getString(1).length() == 0) {
				result = true;
			}*/
			
			String s = session.selectOne("emotionMapper.setlectMyEmotionName", id);
			if(s != null) result = true;
			
			return result;
		}
		
	
	
}
