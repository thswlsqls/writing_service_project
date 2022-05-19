package com.project.model;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class UserDAO {
	
		private Connection conn;	
		
		private SqlSessionFactory sqlSessionFactory;
		public UserDAO() {
			try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("1.driver loading OK");

			String url = "jdbc:oracle:thin:@127.0.0.1:1521:XE";
			String id = "hr";
			String pw = "hr";
			conn = DriverManager.getConnection(url, id, pw);
			}catch(Exception e) {
				e.printStackTrace();
			}
			System.out.println("dbms OK");
		
			InputStream inputStream = null;

			try {
				String resource = "config/mybatis-Config.xml"; //Spring 설정으로 변경 가능
				inputStream = Resources.getResourceAsStream(resource);
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream); 

	}
		
/** 로그인
 *  select pen_name from app_user where user_id = ? and user_pw = ? 
 * @throws SQLException */		
		public String login(String userId, String userPw) throws SQLException {
			
			String name = null;
			String sql = "select pen_name from app_user where user_id = ? and user_pw = ?";
			
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userId);
			pstmt.setString(2, userPw);
			ResultSet rs = pstmt.executeQuery();
			
			if(rs.next()) {
				name = rs.getString(1);
			}
		
			rs.close();
			pstmt.close();
			
			return name;			
		}

		
		/** 회원가입
		 *  insert into app_user(user_id, name, pen_name, user_pw, email, tel) values(?,?,?,?,?,?)
		 * @throws SQLException */

		public boolean addUser(String userId, String name, String penName, String userPw, String email, String tel) throws SQLException {
				
			String sql = "insert into app_user(user_id, name, pen_name, user_pw, email, tel) values(?,?,?,?,?,?)";
			boolean result = false;
				PreparedStatement pstmt = conn.prepareStatement(sql);
				
				pstmt.setString(1, userId);
				pstmt.setString(2, name);
				pstmt.setString(3, penName);
				pstmt.setString(4, userPw);
				pstmt.setString(5, email);
				pstmt.setString(6, tel);
				
				int num = pstmt.executeUpdate();
				
				result = (num==1);
				
				return result;
			}
			
		/** ID찾기
		 * select user_id from app_user where name = ? and email = ? 
		 * @throws SQLException */
		
		public String findId(String name, String email) throws SQLException {
			
			String result = null;
//			String sql = "select user_id from app_user where name = ? and email = ?";
//			PreparedStatement pstmt = conn.prepareStatement(sql);
//			pstmt.setString(1, name);
//			pstmt.setString(2, email);
//			ResultSet rs = pstmt.executeQuery();
//			
//			if(rs.next()) result = rs.getString(1);
			
			
			SqlSession session = sqlSessionFactory.openSession();

			try {
		    	  result = session.selectOne("userMapper.selectUserId"
		    			  , new AppUser(null, name, null, null, email, null));
		      }catch(Exception e){
		    	  e.printStackTrace();
		      }finally{
		    	  session.close();
		      }
						
			return result;
		}
		
		/** --4. PW 찾기 
			select user_pw from app_user where name = ? and email = ?;
		 */
		
		public String findPw(String name, String email) throws SQLException {
			
			String result = null;
//			String sql = "select user_pw from app_user where name = ? and email = ?";
//			PreparedStatement pstmt = conn.prepareStatement(sql);
//			pstmt.setString(1, name);
//			pstmt.setString(2, email);
//			ResultSet rs = pstmt.executeQuery();
//			
//			if(rs.next()) result = rs.getString(1);
			
			SqlSession session = sqlSessionFactory.openSession();
	 		
	 	      try {
	 	    	  result = session.selectOne("userMapper.selectUserPw"
	 	    			  , new AppUser(null, name, null, null, email, null));
	 	      }catch(Exception e){
	 	    	  e.printStackTrace();
	 	      }finally{
	 	    	  session.close();
	 	      }
						
			return result;
		}
		
		//아이디 중복체크
		public boolean checkUserId(String userId) throws SQLException {
			boolean result = true;
			
			String sql="select user_id from app_user where user_id = ?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userId);
			ResultSet rs = pstmt.executeQuery();
			
			if (rs.next()) {
				if (rs.getString(1)!=null) {
					result = false;//중복되는 Id가 있을 경우 false
					
				}
				
			}
			
			return result;
		}
		
		//필명 중복체크
		public boolean checkPenName(String penName) throws SQLException {
			boolean result = true;
			
			String sql="select pen_name from app_user where pen_name = ?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, penName);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				if (rs.getString(1)!=null) {
					result = false;//중복되는 필명이 있을 경우 false
				}
				
			}
			
			return result;
		}
		

		   //인증번호 확인용
        public String checkIdEmail(String userId, String email) throws SQLException {
           String result = "";
           
           String sql = "select pen_name from app_user where user_id = ? and email = ?";
           PreparedStatement pstmt = conn.prepareStatement(sql);
           pstmt.setString(1, userId);
           pstmt.setString(2, email);
           ResultSet rs = pstmt.executeQuery();
           if(rs.next()) result = rs.getString(1);
                          
           return result;
          
        }
		
      //인증번호와 아이디로 비밀번호 바꾸기
        public boolean setTemporaryPw(String userId, String userPw) throws SQLException {
           
           boolean result = false;
           String sql = "update app_user set user_pw = ? where user_id = ?";
           PreparedStatement pstmt = conn.prepareStatement(sql);
           pstmt.setString(1, userPw);
           pstmt.setString(2, userId);

           int num = pstmt.executeUpdate();
           
           result = (num==1);
           
           return result;
        }
        
}
