package com.project.model;

import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class UserMapperDAO {

	private SqlSessionFactory sqlSessionFactory;
	
	public UserMapperDAO(){
		InputStream inputStream = null;

		try {
			String resource = "config/mybatis-Config.xml"; //Spring 설정으로 변경 가능
			inputStream = Resources.getResourceAsStream(resource);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream); 
	}
	
	/** ID찾기
	 * select user_id from app_user where name = ? and email = ? 
	 * @throws SQLException */
	
	public String findId(String name, String email) throws SQLException {
		
		String result = null;
		
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
}
/**
 * insert into app_user(user_id, name, pen_name, user_pw, email, tel) values(?,?,?,?,?,?);

 * */
class AppUser{
	
	private String userId;
	private String name;
	private String penName;
	private String userPw;
	private String email;
	private String tel;
	
	public AppUser(String userId, String name, String penName, String userPw, String email, String tel) {
		super();
		setUserId(userId);
		setName(name);
		setPenName(penName);
		setUserPw(userPw);
		setEmail(email);
		setTel(tel);
	}
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPenName() {
		return penName;
	}
	public void setPenName(String penName) {
		this.penName = penName;
	}
	public String getUserPw() {
		return userPw;
	}
	public void setUserPw(String userPw) {
		this.userPw = userPw;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	@Override
	public String toString() {
		return "appUser [userId=" + userId + ", name=" + name + ", penName=" + penName + ", userPw=" + userPw
				+ ", email=" + email + ", tel=" + tel + "]\n";
	}
	
	
}

