//package com.project.model;
//
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.sql.Statement;
//import java.util.ArrayList;
//import java.util.Collection;
//
//public class WriterDAO {
//
//	private Connection conn;
//	public WriterDAO() {
//		try {
//		Class.forName("oracle.jdbc.driver.OracleDriver");
//		System.out.println("1.driver loading OK");
//
//		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
//		String id = "hr";
//		String pw = "hr";
//		conn = DriverManager.getConnection(url, id, pw);}
//		catch(Exception e) {
//			e.printStackTrace();
//		}
//		System.out.println("2.dbms OK");
//	}
//
//	   /** 게시글작성
//	    * insert into board(write_no, contents, write_date, share_status, writer_id, suggestion_code)
//		values(write_no_seq.nextval, ?, sysdate, '전체', ?, ?)
//	    * @throws SQLException */
//	   
//	   public boolean diaryWrite(String contents, String writer_id, String suggestion_code) 
//			   throws SQLException {
//	      
//	      boolean result = false;
//	      String sql = "insert into board(write_no, contents, write_date, share_status, writer_id, suggestion_code) "
//	            + "values(write_no_seq.nextval, ?, sysdate, '전체', ?, ?)";
//	      
//	      PreparedStatement pstmt = conn.prepareStatement(sql);
//	      pstmt.setString(1, contents);
//	      pstmt.setString(2, writer_id);
//	      pstmt.setString(3, suggestion_code);
//	   
//	      int num = pstmt.executeUpdate();
//	      result = (num==1);
//	      
//	      conn.commit();
//	      return result;
//	   }
//	   
//	   /** 게시글수정
//	    * update board set contents = ? where writer_id = ? and write_no = ?
//	    * @throws SQLException */
//	   
//	   public boolean diaryModify( String writer_id, String write_no, String contents) 
//			   throws SQLException {
//	      boolean result = false;
//	      String sql = "update board set contents = ? where writer_id = ? and write_no = ?";
//	      PreparedStatement pstmt = conn.prepareStatement(sql);
//	      pstmt.setString(1, contents);
//	      pstmt.setString(2, writer_id);
//	      pstmt.setString(3, write_no);
//	      
//	      int num = pstmt.executeUpdate();
//	      result=(num==1);
//	      
//	      //conn.commit();
//	      return result;
//	   }
//	
//	/**게시글 삭제
//	 * delete from board where writer_id = ? and write_no = ?;
//	 *  */
//   public boolean diaryRemove( String writer_id, String write_no) 
//		   throws SQLException {
//	      boolean result = false;
//	      String sql = "delete from board where writer_id = ? and write_no = ?";
//	      PreparedStatement pstmt = conn.prepareStatement(sql);
//	      pstmt.setString(1, writer_id);
//	      pstmt.setString(2, write_no);
//	      
//	      int num = pstmt.executeUpdate();
//	      result=(num==1);
//	      
//	      conn.commit();
//	      return result;
//	   }
//	  
//   
//   //필명으로 검색
//   public Collection<BoardVO> searchByPenName(String searchText, String writeDate){
//      Collection<BoardVO> result = new ArrayList<BoardVO>();
//      String sql = "select b.write_no, to_char(b.write_date,'yyyy-mm-dd'), a.pen_name, s.suggestion_name from app_user a, board b, suggestion s " + 
//            "where a.user_id = b.writer_id " + 
//            "and b.suggestion_code = s.suggestion_code " + 
//            "and to_char(b.write_date,'yyyy-mm-dd') = ? and b.share_status = '전체' order by 1 desc";
//      PreparedStatement pstmt;
//      try {
//         pstmt = conn.prepareStatement(sql);
//         
//         pstmt.setString(1, writeDate);
//         ResultSet rs = pstmt.executeQuery();
//         while(rs.next()) {
//        	 if (rs.getString(3).contains(searchText)) {
//        		 result.add(new BoardVO(rs.getString(1),rs.getDate(2), rs.getString(3), rs.getString(4)));
//			}
//            
//         }
//
//         
//         pstmt.close();
//         rs.close();
//         
//      } catch (SQLException e) {
//         // TODO Auto-generated catch block
//         e.printStackTrace();
//      }
//      return result;
//   }
//   //제시어로 검색
//   public Collection<BoardVO> searchBySuggestionName(String searchText, String writeDate){
//      Collection<BoardVO> result = new ArrayList<BoardVO>();
//      String sql = "select b.write_no, to_char(b.write_date,'yyyy-mm-dd'), a.pen_name, s.suggestion_name from app_user a, board b, suggestion s " + 
//            "where a.user_id = b.writer_id " + 
//            "and b.suggestion_code = s.suggestion_code " + 
//            "and to_char(b.write_date,'yyyy-mm-dd') = ? and b.share_status = '전체' order by 1 desc";
//      PreparedStatement pstmt;
//      try {
//         pstmt = conn.prepareStatement(sql);
//         
//         pstmt.setString(1, writeDate);
//         ResultSet rs = pstmt.executeQuery();
//         
//         while(rs.next()) {
//        	 if (rs.getString(4).contains(searchText)) {
//        		 result.add(new BoardVO(rs.getString(1),rs.getDate(2), rs.getString(3), rs.getString(4)));
//			}
//            
//         }
//         
//         pstmt.close();
//         rs.close();
//         
//      } catch (SQLException e) {
//         // TODO Auto-generated catch block
//         e.printStackTrace();
//      }
//      
//      return result;
//   }     
//   
//	/**홈 게시글목록 조회 
//	 * select s.suggestion_name, b.contents, a.pen_name, b.write_date, e.emotion_code
//		from app_user a, board b, suggestion s, emotion e
//		where b.writer_id = a.user_id and b.suggestion_code = s.suggestion_code and e.emotion_code = s.emotion_code
//		and e.emotion_code = ? ;
//	 *  */
//	public Collection<BoardVO> getHomeBoardList(String emotionCode, String userId) 
//									throws SQLException {
//		Collection<BoardVO> list = new ArrayList<BoardVO>();
//		String sql = "select b.write_no, s.suggestion_name, b.contents, a.pen_name, b.write_date, e.emotion_code, e.emotion_name " + 
//				"from app_user a, board b, suggestion s, emotion e " + 
//				"where b.writer_id = a.user_id and b.suggestion_code = s.suggestion_code and e.emotion_code = s.emotion_code " + 
//				"and e.emotion_code = ? and a.user_id != ?";
//		try {
//			PreparedStatement pstmt = conn.prepareStatement(sql);
//			pstmt.setString(1, emotionCode);
//			pstmt.setString(2, userId);
//			
//			ResultSet rs = pstmt.executeQuery();
//			while(rs.next()) {
//				list.add(new BoardVO(rs.getString(1)
//						, rs.getString(2)
//						, rs.getString(3)
//						, rs.getString(4)
//						, rs.getDate(5)
//						, rs.getString(6)
//						, rs.getString(7)));
//					
//				}
//			for (BoardVO b : list) {
//				b.setContents(b.getContents().replace("\r\n", "<br>"));
//			}
//		}catch(Exception e) {
//			e.printStackTrace();
//		}
//		return list;
//	}
//	
//   
//	/**공유상태 설정 
//	 * update board set share_status = ? where write_no = ? and writer_id = ?;
//	 * */
//   public boolean setShareStatus(String shareStatus, String writer_no, String write_id) 
//		   throws SQLException {
//	      boolean result = false;
//	      String sql = "update board set share_status = ? where write_no = ? and writer_id = ?";
//	      PreparedStatement pstmt = conn.prepareStatement(sql);
//	      pstmt.setString(1, shareStatus);
//	      pstmt.setString(2, writer_no);
//	      pstmt.setString(3, write_id);
//	      
//	      int num = pstmt.executeUpdate();
//	      result=(num==1);
//	      
//	      conn.commit();
//	      return result;
//	   }
//	   
//	/**새로운 게시물 목록 조회 -> 글번호 필요함
//	 * select b.write_no, s.suggestion_name, b.contents, a.pen_name, b.write_date
//		from app_user a, board b, suggestion s 
//		where b.writer_id = a.user_id and b.suggestion_code = s.suggestion_code
//		and rownum<=10
//		order by b.write_date desc;
//	 * */
//	public Collection<BoardVO> getNewBoardList() 
//							throws SQLException {
//		Collection<BoardVO> list = new ArrayList<BoardVO>();
//		String sql = "select b.write_no, s.suggestion_name, b.contents, a.pen_name, b.write_date " + 
//				"from app_user a, board b, suggestion s " + 
//				"where b.writer_id = a.user_id and b.suggestion_code = s.suggestion_code " + 
//				"and rownum<=10 " + 
//				"order by b.write_date desc";
//		try {
//			Statement stmt = conn.createStatement();
//			
//			ResultSet rs = stmt.executeQuery(sql);
//			while(rs.next()) {
//				list.add(new BoardVO(
//						rs.getString(1)
//						, rs.getString(2)
//						, rs.getString(3)
//						, rs.getString(4)
//						, rs.getDate(5)));
//
//			}
//			for (BoardVO b : list) {
//				b.setContents(b.getContents().replace("\r\n", "<br>"));
//			}
//		}catch(Exception e) {
//			e.printStackTrace();
//		}
//		
//		return list;
//	}
//	   
//	/**실시간 추천글 조회  
//	 * 
//	  SELECT (SElECT count(*) 
//        FROM reaction 
//        WHERE write_no = b.write_no) AS rCnt ,
//       (SElECT count(*) 
//        FROM bookmark 
//        WHERE write_no = b.write_no) AS bmCnt ,
//        b.write_no, b.contents, b.write_date, b.share_status, b.writer_id, b.suggestion_code
//	    FROM board b, bookmark bm, reaction r
//	    WHERE b.write_no = bm.write_no AND b.write_no = r.write_no AND rownum <= 10
//	    ORDER BY b.write_date desc, rCnt, bmCnt desc;
//	 * 
//	 * */
//	/**
//	 * SELECT (SElECT count(*) 
//        FROM reaction 
//        WHERE write_no = b.write_no) AS rCnt ,
//        b.write_no, b.contents, b.write_date, b.share_status, b.writer_id, b.suggestion_code
//	    FROM board b, reaction r
//	    WHERE b.write_no = r.write_no AND rownum <= 10
//	    ORDER BY b.write_date, rCnt desc
//	 * */
//	public Collection<BoardVO> getNowRecommendedBoardList() 
//			throws SQLException {
//		Collection<BoardVO> list = new ArrayList<BoardVO>();
//		String sql = "SELECT (SElECT count(*) " + 
//				"        FROM reaction " + 
//				"        WHERE write_no = b.write_no) AS rCnt ," + 
//				"        b.write_no, b.contents, b.write_date, b.share_status, b.writer_id, b.suggestion_code, a.pen_name" + 
//				"	    FROM board b, reaction r, app_user a" + 
//				"	    WHERE b.write_no = r.write_no AND rownum <= 3"+ 
//				"		AND a.user_id=b.writer_id" + 
//				"	    ORDER BY rCnt DESC, b.write_date DESC";
//		try {
//			Statement stmt = conn.createStatement();
//			
//			ResultSet rs = stmt.executeQuery(sql);
//			while(rs.next()) {
//				list.add(new BoardVO(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDate(4), rs.getString(5), rs.getString(6), rs.getString(6), rs.getString(7)));
//			}
//			for (BoardVO b : list) {
//				b.setContents(b.getContents().replace("\r\n", "<br>"));
//			}
//		}catch(Exception e) {
//			e.printStackTrace();
//		}
//		return list;
//	}
//	
////	public Collection<BoardVO> getNowRecommendedBoardList_witthBookmark() 
////			throws SQLException {
////		Collection<BoardVO> list = new ArrayList<BoardVO>();
////		String sql = "SELECT (SElECT count(*)  " + 
////				" FROM reaction  " + 
////				" WHERE write_no = b.write_no) AS rCnt, " + 
////				" (SElECT count(*) " + 
////				" FROM bookmark " + 
////				" WHERE write_no = b.write_no) AS bmCnt, " + 
////				" b.write_no"
////				+ " , b.contents"
////				+ " , b.write_date"
////				+ " , b.share_status"
////				+ " , b.writer_id"
////				+ " , b.suggestion_code" + 
////					" FROM board b, bookmark bm, reaction r " + 
////					" WHERE b.write_no = bm.write_no AND b.write_no = r.write_no AND rownum <= 10 " + 
////					" ORDER BY b.write_date desc, rCnt, bmCnt desc";
////		try {
////			Statement stmt = conn.createStatement();
////			
////			ResultSet rs = stmt.executeQuery(sql);
////			while(rs.next()) {
////				list.add(new BoardVO(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4)
////						, rs.getDate(5), rs.getString(6), rs.getString(7), rs.getString(8)));
////			}
////		}catch(Exception e) {
////			e.printStackTrace();
////		}
////		return list;
////	}
//	
//	/**emotionName으로 emotionCode 가져오기*/
//	   public String getEmotionCode(String emotionName) throws SQLException {
//		   String result = "";
//	      String sql = "select emotion_code from emotion where emotion_name = ?";
//	      
//	      
//	      PreparedStatement pstmt = conn.prepareStatement(sql);
//	      pstmt.setString(1, emotionName);
//	      ResultSet rs = pstmt.executeQuery();
//	      
//	      if(rs.next()) result = rs.getString(1);
//	      
//	      return result;
//	   }
//	   
//	 /**
//	  *  친구글 목록 조회 
//		SELECT b.write_no, s.suggestion_name, b.contents, a.pen_name, b.write_date, e.emotion_code
//		FROM app_user a, board b, suggestion s, emotion e, follow_list fl
//		WHERE b.writer_id = a.user_id 
//		AND b.suggestion_code = s.suggestion_code 
//		AND a.user_id = fl.followee_id
//		AND e.emotion_code = s.emotion_code
//		AND fl.follower_id = ?
//		ORDER BY write_date DESC;
//	  * */
//	   public Collection<BoardVO> getFriendWriteList(String followerId) 
//			   throws SQLException {
//			Collection<BoardVO> list = new ArrayList<BoardVO>();
//			String sql = "SELECT b.write_no, s.suggestion_name, b.contents, a.pen_name, b.write_date, e.emotion_code, e.emotion_name" + 
//					"		FROM app_user a, board b, suggestion s, emotion e, follow_list fl" + 
//					"		WHERE b.writer_id = a.user_id " + 
//					"		AND b.suggestion_code = s.suggestion_code " + 
//					"		AND a.user_id = fl.followee_id" + 
//					"		AND e.emotion_code = s.emotion_code" + 
//					"		AND fl.follower_id = ?" + 
//					"		ORDER BY write_date DESC";
//			try {
//				 PreparedStatement pstmt = conn.prepareStatement(sql);
//			     pstmt.setString(1, followerId);
//				 ResultSet rs = pstmt.executeQuery();
//				while(rs.next()) {
//					list.add(new BoardVO(rs.getString(1)
//							, rs.getString(2)
//							, rs.getString(3)
//							, rs.getString(4)
//							, rs.getDate(5)
//							, rs.getString(6)
//							, rs.getString(7)));
//					}
//				for (BoardVO b : list) {
//					b.setContents(b.getContents().replace("\r\n", "<br>"));
//				}
//			}catch(Exception e) {
//				e.printStackTrace();
//			}
//			return list;
//		} 
//	   
//	   
//	   /**
//	    * 감정 트렌드 조회
//	     select emotion_name from (select e.emotion_name, count(*) 
//	     from empathy p, emotion e 
//	     where e.emotion_code = p.emotion_code
//	     group by emotion_name
//	     order by 2 desc)
//	     where rownum <= 3;
//	    * 
//	    * 
//	    * */
//
//	   /**
//	    *  트렌드별 글 조회  -> 글번호필요함
//		   select s.sugguestion_name, b.contents, a.pen_name, b.write_date 
//		   from board b, suggestion s, emotion e, app_user a
//		   where and a.user_id = b.writer_id
//		   and s.suggestion_code = b.suggestion_code
//		   and e.emotion_code = s.emotion_code
//		   and e.emotion_name = ?;
//	    * */
//		public Collection<BoardVO> getTrendWrite(String emotionCode) throws SQLException{
//			Collection<BoardVO> list = new ArrayList();
//			
//			String sql = "select b.write_no, s.suggestion_name, b.contents, a.pen_name, b.write_date, e.emotion_code, e.emotion_name " + 
//					"from app_user a, board b, suggestion s, emotion e, bookmark bm " + 
//					"where b.writer_id = a.user_id " + 
//					"and b.writer_id = bm.user_id " + 
//					"and b.suggestion_code = s.suggestion_code " + 
//					"and e.emotion_code = s.emotion_code " + 
//					"and e.emotion_code = ? ";
//			
//			PreparedStatement pstmt = conn.prepareStatement(sql);
//			pstmt.setString(1, emotionCode);
//			ResultSet rs = pstmt.executeQuery();
//			
//			while (rs.next()) {
//				list.add(new BoardVO(rs.getString(1)
//						, rs.getString(2)
//						, rs.getString(3)
//						, rs.getString(4)
//						, rs.getDate(5)
//						, rs.getString(6)
//						, rs.getString(7)));
//			}
//			for (BoardVO b : list) {
//				b.setContents(b.getContents().replace("\r\n", "<br>"));
//			}
//			pstmt.close();
//			rs.close();
//			
//			return list;
//		}
//
//		/**
//		 * 즐겨찾기 글 목록 조회
//		 * select bo.write_no, bm.bookmark_date, s.suggestion_name, a.pen_name
//			from bookmark bm, board bo, suggestion s, app_user a
//			where bm.write_no = bo.write_no 
//			and bo.suggestion_code = s.suggestion_code
//			and a.user_id = bo.writer_id
//			and bm.USER_ID = 'test2';
//		 * */
//		public Collection<BoardVO> getBookmarkedWriteList(String userId) throws SQLException{
//			Collection<BoardVO> list = new ArrayList();
//			
//			String sql = "select bo.write_no, bm.bookmark_date, s.suggestion_name, a.pen_name " + 
//						"	from bookmark bm, board bo, suggestion s, app_user a " + 
//						"	where bm.write_no = bo.write_no  " + 
//						"	and bo.suggestion_code = s.suggestion_code " + 
//						"	and a.user_id = bo.writer_id " + 
//						"	and bm.USER_ID = ?";
//			
//			PreparedStatement pstmt = conn.prepareStatement(sql);
//			pstmt.setString(1, userId);
//			ResultSet rs = pstmt.executeQuery();
//			
//			while (rs.next()) {
//				list.add(new BoardVO(rs.getString(1)
//						, rs.getDate(2)
//						, rs.getString(3)
//						, rs.getString(4)));
//			}
//			for (BoardVO b : list) {
//				b.setContents(b.getContents().replace("\r\n", "<br>"));
//			}
//			pstmt.close();
//			rs.close();
//			
//			return list;
//		}
//		
//		/**
//		 * 즐겨찾기 글 상세조회
//		 * select b.write_no, s.suggestion_name, b.contents, a.pen_name, b.write_date, e.emotion_code
//			from board b, app_user a, bookmark bm , suggestion s, emotion e
//			WHERE a.user_id = b.writer_id
//			and b.write_no = bm.write_no
//			and b.suggestion_code = s.suggestion_code
//			and s.emotion_code = e.emotion_code 
//			and bm.user_id = 'test1'
//			AND bm.write_no = '1';
//		 * */
//		public BoardVO getBookmarkedWrite(String emotionCode) throws SQLException{
//			BoardVO v = null;
//			
//			String sql = "select b.write_no, s.suggestion_name, b.contents, a.pen_name, b.write_date, e.emotion_code, e.emotion_name " + 
//					"	from board b, app_user a, bookmark bm , suggestion s, emotion e " + 
//					"	WHERE a.user_id = b.writer_id " + 
//					"	and b.write_no = bm.write_no " + 
//					"	and b.suggestion_code = s.suggestion_code " + 
//					"	and s.emotion_code = e.emotion_code  " + 
//					"	and bm.user_id = ? " + 
//					"	AND bm.write_no = ?";
//			
//			PreparedStatement pstmt = conn.prepareStatement(sql);
//			pstmt.setString(1, emotionCode);
//			ResultSet rs = pstmt.executeQuery();
//			
//			while (rs.next()) {
//				v = new BoardVO(rs.getString(1)
//						, rs.getString(2)
//						, rs.getString(3)
//						, rs.getString(4)
//						, rs.getDate(5)
//						, rs.getString(6)
//						, rs.getString(7));
//				v.setContents(v.getContents().replace("\r\n", "<br>"));
//			}
//			pstmt.close();
//			rs.close();
//			
//			return v;
//		} 
//		
//		// 검색글 상세 글보기
//		public Collection<BoardVO> getSearchResultWrite(String writeNo) {
//	Collection<BoardVO> list = new ArrayList();
//			
//			String sql = "select b.write_no, s.suggestion_name, b.contents, a.pen_name, b.write_date " + 
//					"from app_user a, board b, suggestion s, emotion e " + 
//					"where a.user_id = b.writer_id " + 
//					"and b.suggestion_code = s.suggestion_code " + 
//					"and s.emotion_code = e.emotion_code " + 
//					"and write_no = ?";
//			
//			PreparedStatement pstmt;
//			try {
//				pstmt = conn.prepareStatement(sql);
//				pstmt.setString(1, writeNo);
//				ResultSet rs = pstmt.executeQuery();
//				
//				if(rs.next()) {
//					list.add(new BoardVO(rs.getString(1),rs.getString(2), rs.getString(3), rs.getString(4), rs.getDate(5)));
//				}
//				for (BoardVO b : list) {
//					b.setContents(b.getContents().replace("\r\n", "<br>"));
//				}
//				pstmt.close();
//				rs.close();
//			} catch (SQLException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			return list;
//		}
//		
//
///**랭킹 게시글 클릭
//	 * */
//	public Collection<BoardVO> getRankBoard(String writeNo) {
//		Collection<BoardVO> list = new ArrayList<BoardVO>();
//		String sql = "select b.write_no, s.suggestion_name, b.contents, a.pen_name, b.write_date, e.emotion_code, e.emotion_name " + 
//				"from app_user a, board b, suggestion s, emotion e " + 
//				"where b.writer_id = a.user_id and b.suggestion_code = s.suggestion_code and e.emotion_code = s.emotion_code " + 
//				"and b.write_no = ?";
//		try {
//			PreparedStatement pstmt = conn.prepareStatement(sql);
//			pstmt.setString(1, writeNo);
//			
//			ResultSet rs = pstmt.executeQuery();
//			while(rs.next()) {
//				list.add(new BoardVO(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getDate(5),rs.getString(6),rs.getString(7)));
//			}
//			for (BoardVO b : list) {
//				b.setContents(b.getContents().replace("\r\n", "<br>"));
//			}
//		}catch(Exception e) {
//			e.printStackTrace();
//		}
//		return list;
//	}
//	  //mypage
//	   public Collection<BoardVO> myWriting(String userId){
//	      Collection<BoardVO> list = new ArrayList<BoardVO>();
//	      String sql = "select b.write_no, to_char(b.write_date,'yyyy-mm-dd'), a.pen_name, s.suggestion_name from app_user a, board b, suggestion s " + 
//	            "where a.user_id = b.writer_id " + 
//	            "and b.suggestion_code = s.suggestion_code " + 
//	            "and a.user_id = ? order by 1 desc";
//	      PreparedStatement pstmt;
//	      try {
//	         pstmt = conn.prepareStatement(sql);
//	         pstmt.setString(1, userId);
//	         ResultSet rs = pstmt.executeQuery();
//	         while(rs.next()) {
//	        	 list.add(new BoardVO(rs.getString(1),rs.getDate(2), rs.getString(3), rs.getString(4)));
//	         }
//	         
//	         pstmt.close();
//	         rs.close();
//	         
//	      } catch (SQLException e) {
//	         e.printStackTrace();
//	      }
//	      return list;
//	   }
//	 
//	//마이페이지 비동기 글 목록 조회
//	public Collection<BoardVO> getMyPageSearch(String userId, String date) {
//		Collection<BoardVO> list = new ArrayList<BoardVO>();
//	      String sql = "select b.write_no, to_char(b.write_date,'yyyy-mm-dd'), a.pen_name, s.suggestion_name from app_user a, board b, suggestion s " + 
//	            "where a.user_id = b.writer_id " + 
//	            "and b.suggestion_code = s.suggestion_code " + 
//	            "and a.user_id = ? and to_char(b.write_date,'yyyy-mm-dd') = ? order by 1 desc";
//	      PreparedStatement pstmt;
//	      try {
//	         pstmt = conn.prepareStatement(sql);
//	         pstmt.setString(1, userId);
//	         pstmt.setString(2, date);
//	         ResultSet rs = pstmt.executeQuery();
//	         while(rs.next()) {
//	        	 list.add(new BoardVO(rs.getString(1), rs.getDate(2), rs.getString(3), rs.getString(4)));
//	         }
//	         
//	         pstmt.close();
//	         rs.close();
//	         
//	      } catch (SQLException e) {
//	         e.printStackTrace();
//	      }
//	      return list;
//	}
//	//마이페이지 글 상세목록 조회
//	public Collection<BoardVO> getMyPageWrite(String userId,String writeNo) {
//		Collection<BoardVO> result = new ArrayList();
//
//		String sql = "select s.suggestion_name, b.contents, a.pen_name, b.write_date " + 
//				"from app_user a, board b, suggestion s, emotion e " + 
//				"where a.user_id = b.writer_id\r\n" + 
//				"and b.suggestion_code = s.suggestion_code " + 
//				"and s.emotion_code = e.emotion_code " + 
//				"and a.user_id = ? " + 
//				"and b.write_no = ? ";
//
//		PreparedStatement pstmt;
//		try {
//			pstmt = conn.prepareStatement(sql);
//			pstmt.setString(1, userId);
//			pstmt.setString(2, writeNo);
//			ResultSet rs = pstmt.executeQuery();
//
//			if(rs.next()) {
//				result.add(new BoardVO(rs.getString(1), rs.getString(2), rs.getString(3), rs.getDate(4)));
//				for (BoardVO b : result) {
//					b.setContents(b.getContents().replace("\r\n", "<br>"));
//				}
//			}
//			pstmt.close();
//			rs.close();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return result;
//	}
//
//	//글번호로 감정명 가져오기
//	public String[] getemotionName(String writeNo) throws SQLException {
//		   String[] result = null;
//		      String sql = "select e.emotion_name, b.contents from board b, suggestion s, emotion e "
//		      		+ "where b.suggestion_code = s.suggestion_code "
//		      		+ "and s.emotion_code = e.emotion_code "
//		      		+ "and b.write_no = ?";
//		      
//		      
//		      PreparedStatement pstmt = conn.prepareStatement(sql);
//		      pstmt.setString(1, writeNo);
//		      ResultSet rs = pstmt.executeQuery();
//		      
//		      if(rs.next()) {
//		    	  result = new String[2];
//		    	  result[0] = rs.getString(1);
//		    	  result[1] = rs.getString(2);
//		      }
//		      
//		      return result;
//	}
//	   /**
//	    * 게시글 상세조회
//	    * select b.write_no, b.writer_id, s.suggestion_name, b.contents, a.pen_name, b.write_date, e.emotion_code, e.emotion_name
//			from app_user a, board b, suggestion s, emotion e
//			where b.writer_id = a.user_id and b.suggestion_code = s.suggestion_code and e.emotion_code = s.emotion_code
//			and b.write_no = '1';
//	    * */
//		public BoardVO getWriteDetail(String writeNo) throws SQLException {
//			BoardVO v = null;
//
//			String sql = "select b.write_no, b.writer_id, a.pen_name, b.contents,  b.write_date, e.emotion_code, s.suggestion_name, b.share_status,  e.emotion_name, s.suggestion_code" + 
//					"	from app_user a, board b, suggestion s, emotion e" + 
//					"	where b.writer_id = a.user_id and b.suggestion_code = s.suggestion_code and e.emotion_code = s.emotion_code" + 
//					"	and b.write_no = ?";
//			
//			PreparedStatement pstmt = conn.prepareStatement(sql);
//			pstmt.setString(1, writeNo);
//			ResultSet rs = pstmt.executeQuery();
//			
//			while (rs.next()) {
//				v = new BoardVO(rs.getString(1)
//						, rs.getString(2)
//						, rs.getString(3)
//						, rs.getString(4)
//						, rs.getDate(5)
//						, rs.getString(6)
//						, rs.getString(7)
//						, rs.getString(8)
//						, rs.getString(9)
//						, rs.getString(10));
//				v.setContents(v.getContents().replace("\r\n ", "<br>"));
//			}
//
//			pstmt.close();
//			rs.close();
//			
//			return v;
//		}
//}
package com.project.model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;

public class WriterDAO {

	private Connection conn;
	public WriterDAO() {
		try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		System.out.println("1.driver loading OK");

		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		String id = "hr";
		String pw = "hr";
		conn = DriverManager.getConnection(url, id, pw);}
		catch(Exception e) {
			e.printStackTrace();
		}
		System.out.println("2.dbms OK");
	}

	   /** 게시글작성
	    * insert into board(write_no, contents, write_date, share_status, writer_id, suggestion_code)
		values(write_no_seq.nextval, ?, sysdate, '전체', ?, ?)
	    * @throws SQLException */
	   
	   public boolean diaryWrite(String contents, String writer_id, String suggestion_code) 
			   throws SQLException {
	      
	      boolean result = false;
	      String sql = "insert into board(write_no, contents, write_date, share_status, writer_id, suggestion_code) "
	            + "values(write_no_seq.nextval, ?, sysdate, '전체', ?, ?)";
	      
	      PreparedStatement pstmt = conn.prepareStatement(sql);
	      pstmt.setString(1, contents);
	      pstmt.setString(2, writer_id);
	      pstmt.setString(3, suggestion_code);
	   
	      int num = pstmt.executeUpdate();
	      result = (num==1);
	      
	      conn.commit();
	      return result;
	   }
	   
	   /** 게시글수정
	    * update board set contents = ? where writer_id = ? and write_no = ?
	    * @throws SQLException */
	   
	   public boolean diaryModify( String writer_id, String write_no, String contents) 
			   throws SQLException {
	      boolean result = false;
	      String sql = "update board set contents = ? where writer_id = ? and write_no = ?";
	      PreparedStatement pstmt = conn.prepareStatement(sql);
	      pstmt.setString(1, contents);
	      pstmt.setString(2, writer_id);
	      pstmt.setString(3, write_no);
	      
	      int num = pstmt.executeUpdate();
	      result=(num==1);
	      
	      //conn.commit();
	      return result;
	   }
	
	/**게시글 삭제
	 * delete from board where writer_id = ? and write_no = ?;
	 *  */
   public boolean diaryRemove( String writer_id, String write_no) 
		   throws SQLException {
	      boolean result = false;
	      String sql = "delete from board where writer_id = ? and write_no = ?";
	      PreparedStatement pstmt = conn.prepareStatement(sql);
	      pstmt.setString(1, writer_id);
	      pstmt.setString(2, write_no);
	      
	      int num = pstmt.executeUpdate();
	      result=(num==1);
	      
	      conn.commit();
	      return result;
	   }
	  
   
   //필명으로 검색
   public Collection<BoardVO> searchByPenName(String searchText, String writeDate){
      Collection<BoardVO> result = new ArrayList<BoardVO>();
      String sql = "select b.write_no, to_char(b.write_date,'yyyy-mm-dd'), a.pen_name, s.suggestion_name from app_user a, board b, suggestion s " + 
            "where a.user_id = b.writer_id " + 
            "and b.suggestion_code = s.suggestion_code " + 
            "and to_char(b.write_date,'yyyy-mm-dd') = ? and b.share_status = '전체' order by 1 desc";
      PreparedStatement pstmt;
      try {
         pstmt = conn.prepareStatement(sql);
         
         pstmt.setString(1, writeDate);
         ResultSet rs = pstmt.executeQuery();
         while(rs.next()) {
        	 if (rs.getString(3).contains(searchText)) {
        		 result.add(new BoardVO(rs.getString(1),rs.getDate(2), rs.getString(3), rs.getString(4)));
			}
            
         }

         pstmt.close();
         rs.close();
         
      } catch (SQLException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }
      return result;
   }
   //제시어로 검색
   public Collection<BoardVO> searchBySuggestionName(String searchText, String writeDate){
      Collection<BoardVO> result = new ArrayList<BoardVO>();
      String sql = "select b.write_no, to_char(b.write_date,'yyyy-mm-dd'), a.pen_name, s.suggestion_name from app_user a, board b, suggestion s " + 
            "where a.user_id = b.writer_id " + 
            "and b.suggestion_code = s.suggestion_code " + 
            "and to_char(b.write_date,'yyyy-mm-dd') = ? and b.share_status = '전체' order by 1 desc";
      PreparedStatement pstmt;
      try {
         pstmt = conn.prepareStatement(sql);
         
         pstmt.setString(1, writeDate);
         ResultSet rs = pstmt.executeQuery();
         
         while(rs.next()) {
        	 if (rs.getString(4).contains(searchText)) {
        		 result.add(new BoardVO(rs.getString(1),rs.getDate(2), rs.getString(3), rs.getString(4)));
			}
            
         }
         
         pstmt.close();
         rs.close();
         
      } catch (SQLException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }
      
      return result;
   }     
	/**홈 게시글목록 조회  -> 글번호 필요함, 작성자 아이디 필요함
	 * select b.write_no, b.writer_id, s.suggestion_name, b.contents, a.pen_name, b.write_date, e.emotion_code, e.emotion_name
		from app_user a, board b, suggestion s, emotion e
		where b.writer_id = a.user_id and b.suggestion_code = s.suggestion_code and e.emotion_code = s.emotion_code
		and e.emotion_code = ? ;
	 *  */
	public Collection<BoardVO> getHomeBoardList(String emotionCode, String userId) 
									throws SQLException {
		Collection<BoardVO> list = new ArrayList<BoardVO>();
		String sql = "SELECT b.write_no, b.writer_id, s.suggestion_name, b.contents, a.pen_name, b.write_date, e.emotion_code, e.emotion_name" + 
				"  FROM app_user a, board b, suggestion s, emotion e " + 
				"  WHERE b.writer_id = a.user_id and b.suggestion_code = s.suggestion_code and e.emotion_code = s.emotion_code " + 
				"  and b.share_status = '전체' " +
				"  AND a.user_id != ?" + 
				"  AND e.emotion_code = ?"+
				"  AND rownum <= 10"+
				"  order by 6";
		
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userId);
			pstmt.setString(2, emotionCode);
			
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				list.add(new BoardVO(rs.getString(1)
						, rs.getString(2)
						, rs.getString(3)
						, rs.getString(4)
						, rs.getString(5)
						, rs.getDate(6)
						, rs.getString(7)
						, rs.getString(8)));
					
				}
			for (BoardVO b : list) {
				b.setContents(b.getContents().replace("\r\n", "<br>"));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return list;
	}
//	/**홈 게시글목록 조회  -> 글번호 필요함, 작성자 아이디 필요함
//	 * select b.write_no, b.writer_id, s.suggestion_name, b.contents, a.pen_name, b.write_date, e.emotion_code, e.emotion_name
//		from app_user a, board b, suggestion s, emotion e
//		where b.writer_id = a.user_id and b.suggestion_code = s.suggestion_code and e.emotion_code = s.emotion_code
//		and e.emotion_code = ? ;
//	 *  */
//	public Collection<BoardVO> getHomeBoardList(String emotionCode) 
//									throws SQLException {
//		Collection<BoardVO> list = new ArrayList<BoardVO>();
//		String sql = "SELECT b.write_no, b.writer_id, s.suggestion_name, b.contents, a.pen_name, b.write_date, e.emotion_code, e.emotion_name" + 
//				"  FROM app_user a, board b, suggestion s, emotion e " + 
//				"  WHERE b.writer_id = a.user_id and b.suggestion_code = s.suggestion_code and e.emotion_code = s.emotion_code " + 
//				"  and b.share_status = '전체' " +
//				"  AND e.emotion_code = ?";
//		try {
//			PreparedStatement pstmt = conn.prepareStatement(sql);
//			pstmt.setString(1, emotionCode);
//			
//			ResultSet rs = pstmt.executeQuery();
//			while(rs.next()) {
//				list.add(new BoardVO(rs.getString(1)
//						, rs.getString(2)
//						, rs.getString(3)
//						, rs.getString(4)
//						, rs.getString(5)
//						, rs.getDate(6)
//						, rs.getString(7)
//						, rs.getString(8)));
//					
//				}
//			for (BoardVO b : list) {
//				b.setContents(b.getContents().replace("\r\n", "<br>"));
//			}
//		}catch(Exception e) {
//			e.printStackTrace();
//		}
//		return list;
//	}
	
   
	/**공유상태 설정 
	 * update board set share_status = ? where write_no = ? and writer_id = ?;
	 * */
   public boolean setShareStatus(String shareStatus, String writer_no, String write_id) 
		   throws SQLException {
	      boolean result = false;
	      String sql = "update board set share_status = ? where write_no = ? and writer_id = ?";
	      PreparedStatement pstmt = conn.prepareStatement(sql);
	      pstmt.setString(1, shareStatus);
	      pstmt.setString(2, writer_no);
	      pstmt.setString(3, write_id);
	      
	      int num = pstmt.executeUpdate();
	      result=(num==1);
	      
	      conn.commit();
	      return result;
	   }
	   
	/**새로운 게시물 목록 조회 -> 글번호 필요함, 작성자아이디 필요함
	 * select b.write_no, b.writer_id, s.suggestion_name, b.contents, a.pen_name, b.write_date
		from app_user a, board b, suggestion s 
		where b.writer_id = a.user_id and b.suggestion_code = s.suggestion_code
		and rownum<=10
		order by b.write_date desc;
	 * */
	public Collection<BoardVO> getNewBoardList() 
							throws SQLException {
		Collection<BoardVO> list = new ArrayList<BoardVO>();
		String sql = "select b.write_no, b.writer_id, s.suggestion_name, b.contents, a.pen_name, b.write_date " + 
				"from app_user a, board b, suggestion s " + 
				"where b.writer_id = a.user_id and b.suggestion_code = s.suggestion_code " + 
				"and b.share_status = '전체' " +
				"and rownum<=10 " + 
				"order by b.write_date desc";
		try {
			Statement stmt = conn.createStatement();
			
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
				list.add(new BoardVO(
						rs.getString(1)
						, rs.getString(2)
						, rs.getString(3)
						, rs.getString(4)
						, rs.getString(5)
						, rs.getDate(6)));

			}
			for (BoardVO b : list) {
				b.setContents(b.getContents().replace("\r\n", "<br>"));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}
	   
	/**실시간 추천글 조회  
	 * 
	  SELECT (SElECT count(*) 
        FROM reaction 
        WHERE write_no = b.write_no) AS rCnt ,
       (SElECT count(*) 
        FROM bookmark 
        WHERE write_no = b.write_no) AS bmCnt ,
        b.write_no, b.contents, b.write_date, b.share_status, b.writer_id, b.suggestion_code
	    FROM board b, bookmark bm, reaction r
	    WHERE b.write_no = bm.write_no AND b.write_no = r.write_no AND rownum <= 10
	    ORDER BY b.write_date desc, rCnt, bmCnt desc;
	 * 
	 * */
	/**
	 * SELECT (SElECT count(*) 
        FROM reaction 
        WHERE write_no = b.write_no) AS rCnt ,
        b.write_no, b.contents, b.write_date, b.share_status, b.writer_id, b.suggestion_code
	    FROM board b, reaction r
	    WHERE b.write_no = r.write_no AND rownum <= 10
	    ORDER BY b.write_date, rCnt desc
	 * */
	public Collection<BoardVO> getNowRecommendedBoardList() 
			throws SQLException {
		Collection<BoardVO> list = new ArrayList<BoardVO>();
		String sql = "select * from(SELECT distinct (SElECT count(*) " + 
				"FROM reaction " + 
				"WHERE write_no = b.write_no) AS rCnt, " + 
				"b.write_no, b.contents, b.write_date, b.share_status, b.writer_id, b.suggestion_code, a.pen_name, s.suggestion_name " + 
				"FROM board b, reaction r, app_user a, suggestion s " + 
				"WHERE b.write_no = r.write_no  " + 
				"AND a.user_id=b.writer_id " + 
				"AND b.suggestion_code = s.suggestion_code " + 
				"and b.share_status = '전체' " + 
				"ORDER BY rCnt DESC, b.write_date DESC) " + 
				"where rownum <= 3";
		try {
			Statement stmt = conn.createStatement();
			
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
				list.add(new BoardVO(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDate(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9)));
			}
			for (BoardVO b : list) {
				b.setContents(b.getContents().replace("\r\n", "<br>"));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
//	public Collection<BoardVO> getNowRecommendedBoardList_witthBookmark() 
//			throws SQLException {
//		Collection<BoardVO> list = new ArrayList<BoardVO>();
//		String sql = "SELECT (SElECT count(*)  " + 
//				" FROM reaction  " + 
//				" WHERE write_no = b.write_no) AS rCnt, " + 
//				" (SElECT count(*) " + 
//				" FROM bookmark " + 
//				" WHERE write_no = b.write_no) AS bmCnt, " + 
//				" b.write_no"
//				+ " , b.contents"
//				+ " , b.write_date"
//				+ " , b.share_status"
//				+ " , b.writer_id"
//				+ " , b.suggestion_code" + 
//					" FROM board b, bookmark bm, reaction r " + 
//					" WHERE b.write_no = bm.write_no AND b.write_no = r.write_no AND rownum <= 10 " + 
//					" ORDER BY b.write_date desc, rCnt, bmCnt desc";
//		try {
//			Statement stmt = conn.createStatement();
//			
//			ResultSet rs = stmt.executeQuery(sql);
//			while(rs.next()) {
//				list.add(new BoardVO(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4)
//						, rs.getDate(5), rs.getString(6), rs.getString(7), rs.getString(8)));
//			}
//		}catch(Exception e) {
//			e.printStackTrace();
//		}
//		return list;
//	}
	
	/**emotionName으로 emotionCode 가져오기*/
	   public String getEmotionCode(String emotionName) throws SQLException {
		   String result = "";
	      String sql = "select emotion_code from emotion where emotion_name = ?";
	      
	      
	      PreparedStatement pstmt = conn.prepareStatement(sql);
	      pstmt.setString(1, emotionName);
	      ResultSet rs = pstmt.executeQuery();
	      
	      if(rs.next()) result = rs.getString(1);
	      
	      return result;
	   }
	   
	 /**
	  *  친구글 목록 조회  -> 글번호 필요함, 작성자 아이디 필요함
		SELECT b.write_no, b.writer_id, s.suggestion_name, b.contents, a.pen_name, b.write_date, e.emotion_code, e.emotion_name
		FROM app_user a, board b, suggestion s, emotion e, follow_list fl
		WHERE b.writer_id = a.user_id 
		AND b.suggestion_code = s.suggestion_code 
		AND a.user_id = fl.followee_id
		AND e.emotion_code = s.emotion_code
		"       and b.share_status = '전체' " +
		AND fl.follower_id = ?
		ORDER BY write_date DESC;
	  * */
	   public Collection<BoardVO> getFriendWriteList(String followerId) 
			   throws SQLException {
			Collection<BoardVO> list = new ArrayList<BoardVO>();
			String sql = "SELECT b.write_no, b.writer_id, s.suggestion_name, b.contents, a.pen_name, b.write_date, e.emotion_code, e.emotion_name" + 
					"		FROM app_user a, board b, suggestion s, emotion e, follow_list fl" + 
					"		WHERE b.writer_id = a.user_id " + 
					"		AND b.suggestion_code = s.suggestion_code " + 
					"		AND a.user_id = fl.followee_id" + 
					"		AND e.emotion_code = s.emotion_code" + 
					"       and b.share_status = '전체' " +
					"		AND fl.follower_id = ?" + 
					"		ORDER BY write_date DESC";
			try {
				 PreparedStatement pstmt = conn.prepareStatement(sql);
			     pstmt.setString(1, followerId);
				 ResultSet rs = pstmt.executeQuery();
				while(rs.next()) {
					list.add(new BoardVO(rs.getString(1)
							, rs.getString(2)
							, rs.getString(3)
							, rs.getString(4)
							, rs.getString(5)
							, rs.getDate(6)
							, rs.getString(7)
							, rs.getString(8)));
					}
				for (BoardVO b : list) {
					b.setContents(b.getContents().replace("\r\n", "<br>"));
				}
			}catch(Exception e) {
				e.printStackTrace();
			}
			return list;
		} 
	   
	   
	   /**
	    * 감정 트렌드 조회
	     select emotion_name from (select e.emotion_name, count(*) 
	     from empathy p, emotion e 
	     where e.emotion_code = p.emotion_code
	     group by emotion_name
	     order by 2 desc)
	     where rownum <= 3;
	    * 
	    * 
	    * */

	   /**
	    *  트렌드별 글 조회  -> 글번호필요함
		   select s.sugguestion_name, b.contents, a.pen_name, b.write_date 
		   from board b, suggestion s, emotion e, app_user a
		   where and a.user_id = b.writer_id
		   and s.suggestion_code = b.suggestion_code
		   and e.emotion_code = s.emotion_code
		   and e.emotion_name = ?;
	    * */
		public Collection<BoardVO> getTrendWrite(String emotionCode) throws SQLException{
			Collection<BoardVO> list = new ArrayList();
			
			String sql = "select b.write_no, s.suggestion_name, b.contents, a.pen_name, b.write_date, e.emotion_code, e.emotion_name " + 
					"from app_user a, board b, suggestion s, emotion e, bookmark bm " + 
					"where b.writer_id = a.user_id " + 
					"and b.writer_id = bm.user_id " + 
					"and b.suggestion_code = s.suggestion_code " + 
					"and e.emotion_code = s.emotion_code " + 
					"and b.share_status = '전체' " +
					"and e.emotion_code = ? ";
			
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, emotionCode);
			ResultSet rs = pstmt.executeQuery();
			
			while (rs.next()) {
				list.add(new BoardVO(rs.getString(1)
						, rs.getString(2)
						, rs.getString(3)
						, rs.getString(4)
						, rs.getDate(5)
						, rs.getString(6)
						, rs.getString(7)));
			}
			for (BoardVO b : list) {
				b.setContents(b.getContents().replace("\r\n", "<br>"));
			}
			pstmt.close();
			rs.close();
			
			return list;
		}

		/**
		 * 즐겨찾기 글 목록 조회
		 * select bo.write_no, bm.bookmark_date, s.suggestion_name, a.pen_name
			from bookmark bm, board bo, suggestion s, app_user a
			where bm.write_no = bo.write_no 
			and bo.suggestion_code = s.suggestion_code
			and a.user_id = bo.writer_id
			"   and bo.share_status = '전체' " +
			and bm.USER_ID = 'test2';
		 * */
		public Collection<BoardVO> getBookmarkedWriteList(String userId) throws SQLException{
			Collection<BoardVO> list = new ArrayList();
			
			String sql = "select bo.write_no, bm.bookmark_date, s.suggestion_name, a.pen_name " + 
						"	from bookmark bm, board bo, suggestion s, app_user a " + 
						"	where bm.write_no = bo.write_no  " + 
						"	and bo.suggestion_code = s.suggestion_code " + 
						"	and a.user_id = bo.writer_id " + 
						"   and bo.share_status = '전체' " +
						"	and bm.USER_ID = ?";
			
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userId);
			ResultSet rs = pstmt.executeQuery();
			
			while (rs.next()) {
				list.add(new BoardVO(rs.getString(1)
						, rs.getDate(2)
						, rs.getString(3)
						, rs.getString(4)));
			}
			for (BoardVO b : list) {
				b.setContents(b.getContents().replace("\r\n", "<br>"));
			}
			pstmt.close();
			rs.close();
			
			return list;
		}
		
		/**
		 * 즐겨찾기 글 상세조회
		 * select b.write_no, s.suggestion_name, b.contents, a.pen_name, b.write_date, e.emotion_code
			from board b, app_user a, bookmark bm , suggestion s, emotion e
			WHERE a.user_id = b.writer_id
			and b.write_no = bm.write_no
			and b.suggestion_code = s.suggestion_code
			and s.emotion_code = e.emotion_code 
			and bm.user_id = 'test1'
			AND bm.write_no = '1';
		 * */
		public BoardVO getBookmarkedWrite(String emotionCode) throws SQLException{
			BoardVO v = null;
			
			String sql = "select b.write_no, s.suggestion_name, b.contents, a.pen_name, b.write_date, e.emotion_code, e.emotion_name " + 
					"	from board b, app_user a, bookmark bm , suggestion s, emotion e " + 
					"	WHERE a.user_id = b.writer_id " + 
					"	and b.write_no = bm.write_no " + 
					"	and b.suggestion_code = s.suggestion_code " + 
					"	and s.emotion_code = e.emotion_code  " + 
					"	and bm.user_id = ? " + 
					"	AND bm.write_no = ?";
			
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, emotionCode);
			ResultSet rs = pstmt.executeQuery();
			
			while (rs.next()) {
				v = new BoardVO(rs.getString(1)
						, rs.getString(2)
						, rs.getString(3)
						, rs.getString(4)
						, rs.getDate(5)
						, rs.getString(6)
						, rs.getString(7));
				v.setContents(v.getContents().replace("\r\n", "<br>"));
			}
			pstmt.close();
			rs.close();
			
			return v;
		} 
		
		// 검색글 상세 글보기
		public Collection<BoardVO> getSearchResultWrite(String penName, String suggestionName, String writeDate) {
	Collection<BoardVO> list = new ArrayList();
			
			String sql = "select s.suggestion_name, b.contents, a.pen_name, b.write_date " + 
					"from app_user a, board b, suggestion s, emotion e " + 
					"where a.user_id = b.writer_id " + 
					"and b.suggestion_code = s.suggestion_code " + 
					"and s.emotion_code = e.emotion_code " + 
					"and a.pen_name = ? " + 
					"and s.suggestion_name = ? " + 
					"and to_char(b.write_date,'yyyy-mm-dd') = ?";
			
			PreparedStatement pstmt;
			try {
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, penName);
				pstmt.setString(2, suggestionName);
				pstmt.setString(3, writeDate);
				ResultSet rs = pstmt.executeQuery();
				
				if(rs.next()) {
					list.add(new BoardVO(rs.getString(1), rs.getString(2), rs.getString(3), rs.getDate(4)));
				}
				for (BoardVO b : list) {
					b.setContents(b.getContents().replace("\r\n", "<br>"));
				}
				pstmt.close();
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return list;
		}
		

     /**랭킹 게시글 클릭 -> 게시글 상세보기 메서드로 대체함
	 * */
//	public Collection<BoardVO> getRankBoard(String writeNo) {
//		Collection<BoardVO> list = new ArrayList<BoardVO>();
//		String sql = "select b.write_no, s.suggestion_name, b.contents, a.pen_name, b.write_date, e.emotion_code, e.emotion_name " + 
//				"from app_user a, board b, suggestion s, emotion e " + 
//				"where b.writer_id = a.user_id and b.suggestion_code = s.suggestion_code and e.emotion_code = s.emotion_code " + 
//				"and b.write_no = ?";
//		try {
//			PreparedStatement pstmt = conn.prepareStatement(sql);
//			pstmt.setString(1, writeNo);
//			
//			ResultSet rs = pstmt.executeQuery();
//			while(rs.next()) {
//				list.add(new BoardVO(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getDate(5),rs.getString(6),rs.getString(7)));
//			}
//			for (BoardVO b : list) {
//				b.setContents(b.getContents().replace("\r\n", "<br>"));
//			}
//		}catch(Exception e) {
//			e.printStackTrace();
//		}
//		return list;
//	}
		
	  //mypage
	   public Collection<BoardVO> myWriting(String userId){
	      Collection<BoardVO> list = new ArrayList<BoardVO>();
	      String sql = "select b.write_no, to_char(b.write_date,'yyyy-mm-dd'), a.pen_name, s.suggestion_name from app_user a, board b, suggestion s " + 
	            "where a.user_id = b.writer_id " + 
	            "and b.suggestion_code = s.suggestion_code " + 
	            "and a.user_id = ? order by 1 desc";
	      PreparedStatement pstmt;
	      try {
	         pstmt = conn.prepareStatement(sql);
	         pstmt.setString(1, userId);
	         ResultSet rs = pstmt.executeQuery();
	         while(rs.next()) {
	        	 list.add(new BoardVO(rs.getString(1),rs.getDate(2), rs.getString(3), rs.getString(4)));
	         }
	         
	         pstmt.close();
	         rs.close();
	         
	      } catch (SQLException e) {
	         e.printStackTrace();
	      }
	      return list;
	   }

	//마이페이지 비동기 글 목록 조회
	public Collection<BoardVO> getMyPageSearch(String userId, String date) {
		Collection<BoardVO> list = new ArrayList<BoardVO>();
	      String sql = "select b.write_no, to_char(b.write_date,'yyyy-mm-dd'), a.pen_name, s.suggestion_name from app_user a, board b, suggestion s " + 
	            "where a.user_id = b.writer_id " + 
	            "and b.suggestion_code = s.suggestion_code " + 
	            "and a.user_id = ? and to_char(b.write_date,'yyyy-mm-dd') = ? order by 1 desc";
	      PreparedStatement pstmt;
	      try {
	         pstmt = conn.prepareStatement(sql);
	         pstmt.setString(1, userId);
	         pstmt.setString(2, date);
	         ResultSet rs = pstmt.executeQuery();
	         while(rs.next()) {
	        	 list.add(new BoardVO(rs.getString(1), rs.getDate(2), rs.getString(3), rs.getString(4)));
	         }
	         
	         pstmt.close();
	         rs.close();
	         
	      } catch (SQLException e) {
	         e.printStackTrace();
	      }
	      return list;
	}
	//마이페이지 글 상세목록 조회
//	public Collection<BoardVO> getMyPageWrite(String userId,String writeNo) {
//		Collection<BoardVO> result = new ArrayList();
//
//		String sql = "select s.suggestion_name, b.contents, a.pen_name, b.write_date " + 
//				"from app_user a, board b, suggestion s, emotion e " + 
//				"where a.user_id = b.writer_id " + 
//				"and b.suggestion_code = s.suggestion_code " + 
//				"and s.emotion_code = e.emotion_code " + 
//				"and a.user_id = ? " + 
//				"and b.write_no = ? ";
//
//		PreparedStatement pstmt;
//		try {
//			pstmt = conn.prepareStatement(sql);
//			pstmt.setString(1, userId);
//			pstmt.setString(2, writeNo);
//			ResultSet rs = pstmt.executeQuery();
//
//			if(rs.next()) {
//				result.add(new BoardVO(rs.getString(1), rs.getString(2), rs.getString(3), rs.getDate(4)));
//				for (BoardVO b : result) {
//					b.setContents(b.getContents().replace("\r\n", "<br>"));
//				}
//			}
//			pstmt.close();
//			rs.close();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return result;
//	}
	//마이페이지 글 상세목록 조회
	public BoardVO getMyPageWrite(String userId,String writeNo) {
		BoardVO result = null;

		String sql = "select s.suggestion_name, b.contents, a.pen_name, b.write_date " + 
				"from app_user a, board b, suggestion s, emotion e " + 
				"where a.user_id = b.writer_id " + 
				"and b.suggestion_code = s.suggestion_code " + 
				"and s.emotion_code = e.emotion_code " + 
				"and a.user_id = ? " + 
				"and b.write_no = ? ";

		PreparedStatement pstmt;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userId);
			pstmt.setString(2, writeNo);
			ResultSet rs = pstmt.executeQuery();

			if(rs.next()) {
				result = new BoardVO(rs.getString(1), rs.getString(2), rs.getString(3), rs.getDate(4));
			}
			pstmt.close();
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	
	   /**
	    * 게시글 상세조회
	    * select b.write_no, b.writer_id, s.suggestion_name, b.contents, a.pen_name, b.write_date, e.emotion_code, e.emotion_name
			from app_user a, board b, suggestion s, emotion e
			where b.writer_id = a.user_id and b.suggestion_code = s.suggestion_code and e.emotion_code = s.emotion_code
			and b.write_no = '1';
	    * */
		public BoardVO getWriteDetail(String writeNo) throws SQLException {
			BoardVO v = null;

			String sql = "select b.write_no, b.writer_id, a.pen_name, b.contents,  b.write_date, e.emotion_code, s.suggestion_name, b.share_status,  e.emotion_name, s.suggestion_code" + 
					"	from app_user a, board b, suggestion s, emotion e" + 
					"	where b.writer_id = a.user_id and b.suggestion_code = s.suggestion_code and e.emotion_code = s.emotion_code" + 
					"	and b.write_no = ?";
			
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, writeNo);
			ResultSet rs = pstmt.executeQuery();
			
			while (rs.next()) {
				v = new BoardVO(rs.getString(1)
						, rs.getString(2)
						, rs.getString(3)
						, rs.getString(4)
						, rs.getDate(5)
						, rs.getString(6)
						, rs.getString(7)
						, rs.getString(8)
						, rs.getString(9)
						, rs.getString(10));
				v.setContents(v.getContents().replace("\r\n", "<br>"));
			}

			pstmt.close();
			rs.close();
			
			return v;
		}
		//글번호로 제시어 가져오기
		public String[] getSuggestionName(String writeNo) throws SQLException {
			   String[] result = null;
			      String sql = "select s.suggestion_name, b.contents from board b, suggestion s, emotion e "
			      		+ "where b.suggestion_code = s.suggestion_code "
			      		+ "and s.emotion_code = e.emotion_code "
			      		+ "and b.write_no = ?";
			      
			      
			      PreparedStatement pstmt = conn.prepareStatement(sql);
			      pstmt.setString(1, writeNo);
			      ResultSet rs = pstmt.executeQuery();
			      
			      if(rs.next()) {
			    	  result = new String[2];
			    	  result[0] = rs.getString(1);
			    	  result[1] = rs.getString(2);
			      }
			      
			      return result;
		}
		
}

