//package com.project.model;
//
//import java.sql.Date;
//
///** WriterDAO */
//
//public class BoardVO {
//
//
//	public BoardVO(
//			String writeNo
//			, String writerId
//			, String penName
//			, String contents
//			, Date writeDate
//			, String emotionCode
//			, String suggestionName
//			, String shareStatus
//			, String emotionName
//			, String suggestionCode) {
//		super();
//		setWriteNo(writeNo);
//		setWriterId(writerId);
//		setPenName(penName);
//		setContents(contents);
//		setWriteDate(writeDate);
//		setEmotionCode(emotionCode);
//		setSuggestionName(suggestionName);
//		setShareStatus(shareStatus);
//		setEmotionName(emotionName);
//		setSuggestionCode(suggestionCode);
//	}
//	
//	/**게시글 조회 -> 글번호 필요함
//	 * select b.write_no, s.suggestion_name, b.contents, a.pen_name, b.write_date, e.emotion_code
//		from app_user a, board b, suggestion s, emotion e
//		where b.writer_id = a.user_id and b.suggestion_code = s.suggestion_code and e.emotion_code = s.emotion_code
//		and e.emotion_code = ? ;
//	 *  */
//	 /**
//	  *  친구글 목록 조회 -> 글번호 필요함
//		SELECT s.suggestion_name, b.contents, a.pen_name, b.write_date, e.emotion_code
//		FROM app_user a, board b, suggestion s, emotion e, follow_list fl
//		WHERE b.writer_id = a.user_id 
//		AND b.suggestion_code = s.suggestion_code 
//		AND a.user_id = fl.followee_id
//		AND e.emotion_code = s.emotion_code
//		AND fl.follower_id = ?
//		ORDER BY write_date DESC;
//	  * */
//	/**
//	 * 즐겨찾기 글 상세조회
//	 * select b.write_no, s.suggestion_name, b.contents, a.pen_name, b.write_date, e.emotion_code
//		from board b, app_user a, bookmark bm , suggestion s, emotion e
//		WHERE a.user_id = b.writer_id
//		and b.write_no = bm.write_no
//		and b.suggestion_code = s.suggestion_code
//		and s.emotion_code = e.emotion_code 
//		and bm.user_id = 'test1'
//		AND bm.write_no = '1';
//	 * */
//	/**
//	 * --28. 트렌드별 글 조회
//		select b.write_no, s.SUGGESTION_NAME, b.contents, a.pen_name, b.write_date, , e.emotion_code 
//		from board b, suggestion s, emotion e, app_user a
//		where a.user_id = b.writer_id
//		and s.suggestion_code = b.suggestion_code
//		and e.emotion_code = s.emotion_code
//		and e.emotion_name = '즐거워요';
//	 * */
//
//	public BoardVO(String writeNo
//			, String suggestionName
//			, String contents
//			, String penName
//			, Date writeDate
//			, String emotionCode
//			, String emotionName){
//		this(writeNo, null, penName, contents, writeDate, emotionCode, suggestionName, null, emotionName, null);
//	}
//	
////	public BoardVO(String suggestionName
////			, String contents
////			, String penName
////			, Date writeDate
////			, String emotionCode) {
////		setSuggestionName(suggestionName);
////		setContents(contents);
////		setPenName(penName);
////		setWriteDate(writeDate);
////		setEmotionCode(emotionCode);
////	}
//	
//	/**새로운 게시물 목록 조회 -> 글번호 필요함
//	 * select b.write_no, s.suggestion_name, b.contents, a.pen_name, b.write_date
//		from app_user a, board b, suggestion s 
//		where b.writer_id = a.user_id and b.suggestion_code = s.suggestion_code
//		and rownum<=10
//		order by b.write_date desc;
//	 * */
//	public BoardVO(String writeNo
//			, String suggestionName
//			, String contents
//			, String penName
//			, Date writeDate) {
//		setWriteNo(writeNo);
//		setSuggestionName(suggestionName);
//		setContents(contents);
//		setPenName(penName);
//		setWriteDate(writeDate);
//	}
//	public BoardVO(
//			String suggestionName
//			, String contents
//			, String penName
//			, Date writeDate) {
//		
//		setSuggestionName(suggestionName);
//		setContents(contents);
//		setPenName(penName);
//		setWriteDate(writeDate);
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
//	
//	public BoardVO(
//			int rCnt
//			, String writeNo
//			, String contents
//			, Date writeDate
//			, String shareStatus
//			, String writerId
//			, String suggestionCode
//			, String penName
//			) {
//		setrCnt(rCnt);
//		setWriteNo(writeNo);
//		setContents(contents);
//		setWriteDate(writeDate);
//		setShareStatus(shareStatus);
//		setWriterId(writerId);
//		setSuggestionCode(suggestionCode);
//		setPenName(penName);
//	}
//	public BoardVO(
//			int rCnt
//			, int bmCnt
//			, String writeNo
//			, String contents
//			, Date writeDate
//			, String shareStatus
//			, String writerId
//			, String suggestionCode
//			) {
//		setrCnt(rCnt);
//		setBmCnt(bmCnt);
//		setWriteNo(writeNo);
//		setContents(contents);
//		setWriteDate(writeDate);
//		setShareStatus(shareStatus);
//		setWriterId(writerId);
//		setSuggestionCode(suggestionCode);
//	}
//	/**
//	    * 검색(제시어, 필명)
//		*  select b.write_date, a.pen_name, s.suggestion_name from app_user a, board b, suggestion s where s.suggestion_name = ?;
//	    * */
//	/**
//	 * --16. 즐겨찾기 글 목록 조회
//		select bo.write_no, bm.bookmark_date, s.suggestion_name, a.pen_name
//		from bookmark bm, board bo, suggestion s, app_user a
//		where bm.write_no = bo.write_no 
//		and bo.suggestion_code = s.suggestion_code
//		and a.user_id = bo.writer_id
//		and bm.USER_ID = 'test2';
//	 * 
//	 * */
//	
//	public BoardVO(
//			String writeNo
//			, Date writeDate
//			, String penName
//			, String suggestionName
//			) {
//		setWriteNo(writeNo);
//		setWriteDate(writeDate);
//		setPenName(penName);
//		setSuggestionName(suggestionName);
//	}
//	public BoardVO(Date writeDate,String penName, String suggestionName ) {
//		setWriteDate(writeDate);
//		setPenName(penName);
//		setSuggestionName(suggestionName);
//	}
//	
//	   public BoardVO(String suggestionName
//		         , String contents
//		         , String penName
//		         , Date writeDate
//		         , String emotionCode){
//		      setSuggestionName(suggestionName);
//		      setContents(contents);
//		      setPenName(penName);
//		      setWriteDate(writeDate);
//		      setEmotionCode(emotionCode);
//		   }
//	
//	private String suggestionName;
//
//	private String contents;
//	private String penName;
//	private Date writeDate;
//	private String emotionCode;
//	private String emotionName;
//	
//	private String writeNo;
//	private String shareStatus;
//	private String writerId;
//	private String suggestionCode;
//	
//	private int rCnt;
//	private int bmCnt;
//	
//	
//	public int getrCnt() {
//		return rCnt;
//	}
//
//	public void setrCnt(int rCnt) {
//		this.rCnt = rCnt;
//	}
//
//	public int getBmCnt() {
//		return bmCnt;
//	}
//
//	public void setBmCnt(int bmCnt) {
//		this.bmCnt = bmCnt;
//	}
//
//	public String getSuggestionName() {
//		return suggestionName;
//	}
//
//	public void setSuggestionName(String suggestionName) {
//		this.suggestionName = suggestionName;
//	}
//
//	public String getContents() {
//		return contents;
//	}
//
//	public void setContents(String contents) {
//		this.contents = contents;
//	}
//
//	public String getPenName() {
//		return penName;
//	}
//
//	public void setPenName(String penName) {
//		this.penName = penName;
//	}
//
//	public Date getWriteDate() {
//		return writeDate;
//	}
//
//	public void setWriteDate(Date writeDate) {
//		this.writeDate = writeDate;
//	}
//
//	public String getEmotionCode() {
//		return emotionCode;
//	}
//
//	public void setEmotionCode(String emotionCode) {
//		this.emotionCode = emotionCode;
//	}
//	
//	public String getEmotionName() {
//		return emotionName;
//	}
//
//	public void setEmotionName(String emotionName) {
//		this.emotionName = emotionName;
//	}
//
//	public String getWriteNo() {
//		return writeNo;
//	}
//
//	public void setWriteNo(String writeNo) {
//		this.writeNo = writeNo;
//	}
//
//	public String getShareStatus() {
//		return shareStatus;
//	}
//
//	public void setShareStatus(String shareStatus) {
//		this.shareStatus = shareStatus;
//	}
//
//	public String getWriterId() {
//		return writerId;
//	}
//
//	public void setWriterId(String writerId) {
//		this.writerId = writerId;
//	}
//
//	public String getSuggestionCode() {
//		return suggestionCode;
//	}
//
//	public void setSuggestionCode(String suggestionCode) {
//		this.suggestionCode = suggestionCode;
//	}
//
//	@Override
//	public String toString() {
//		return "BoardVO [suggestionName=" + suggestionName + ", contents=" + contents + ", penName=" + penName
//				+ ", writeDate=" + writeDate + ", emotionCode=" + emotionCode + ", writeNo=" + writeNo
//				+ ", shareStatus=" + shareStatus + ", writerId=" + writerId + ", suggestionCode=" + suggestionCode
//				+ "]\n";
//	}
//	
//	
//	
//	
//}
package com.project.model;

import java.sql.Date;

/** WriterDAO */

public class BoardVO {


	/** 게시글 상세조회 */
	public BoardVO(
			String writeNo
			, String writerId
			, String penName
			, String contents
			, Date writeDate
			, String emotionCode
			, String suggestionName
			, String shareStatus
			, String emotionName
			, String suggestionCode) {
		super();
		setWriteNo(writeNo);
		setWriterId(writerId);
		setPenName(penName);
		setContents(contents);
		setWriteDate(writeDate);
		setEmotionCode(emotionCode);
		setSuggestionName(suggestionName);
		setShareStatus(shareStatus);
		setEmotionName(emotionName);
		setSuggestionCode(suggestionCode);
	}
	
	/**홈 게시글 조회 -> 글번호 필요함, 작성자 아이디 필요함
	 * select b.write_no, b.writer_id, s.suggestion_name, b.contents, a.pen_name, b.write_date, e.emotion_code
		from app_user a, board b, suggestion s, emotion e
		where b.writer_id = a.user_id and b.suggestion_code = s.suggestion_code and e.emotion_code = s.emotion_code
		and e.emotion_code = ? ;
	 *  */
	 /**
	  *  친구글 목록 조회 -> 글번호 필요함, 작성자아이디 필요함
		SELECT b.write_no, b.writer_id, s.suggestion_name, b.contents, a.pen_name, b.write_date, e.emotion_code, e.emotion_name
		FROM app_user a, board b, suggestion s, emotion e, follow_list fl
		WHERE b.writer_id = a.user_id 
		AND b.suggestion_code = s.suggestion_code 
		AND a.user_id = fl.followee_id
		AND e.emotion_code = s.emotion_code
		AND fl.follower_id = ?
		ORDER BY write_date DESC;
	  * */
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
	/**
	 * --28. 트렌드별 글 조회
		select b.write_no, s.SUGGESTION_NAME, b.contents, a.pen_name, b.write_date, , e.emotion_code 
		from board b, suggestion s, emotion e, app_user a
		where a.user_id = b.writer_id
		and s.suggestion_code = b.suggestion_code
		and e.emotion_code = s.emotion_code
		and e.emotion_name = '즐거워요';
	 * */

	public BoardVO(String writeNo
			, String suggestionName
			, String contents
			, String penName
			, Date writeDate
			, String emotionCode
			, String emotionName){
		this(writeNo, null, penName, contents, writeDate, emotionCode, suggestionName, null, emotionName, null);
	}
	
	/**게시글 조회 -> 글번호 필요함, 작성자아이디 필요함*/
	public BoardVO(String writeNo
			, String writerId
			, String suggestionName
			, String contents
			, String penName
			, Date writeDate
			, String emotionCode
			, String emotionName){
		this(writeNo, writerId, penName, contents, writeDate, emotionCode, suggestionName, null, emotionName, null);
	}
	
//	public BoardVO(String suggestionName
//			, String contents
//			, String penName
//			, Date writeDate
//			, String emotionCode) {
//		setSuggestionName(suggestionName);
//		setContents(contents);
//		setPenName(penName);
//		setWriteDate(writeDate);
//		setEmotionCode(emotionCode);
//	}
	
	/**새로운 게시물 목록 조회 -> 글번호 필요함, 작성자아이디 필요함
	 * select b.write_no, b.writer_id, s.suggestion_name, b.contents, a.pen_name, b.write_date
		from app_user a, board b, suggestion s 
		where b.writer_id = a.user_id and b.suggestion_code = s.suggestion_code
		and rownum<=10
		order by b.write_date desc;
	 * */
	public BoardVO(String writeNo
			, String writerId
			, String suggestionName
			, String contents
			, String penName
			, Date writeDate) {
		setWriteNo(writeNo);
		setWriterId(writerId);
		setSuggestionName(suggestionName);
		setContents(contents);
		setPenName(penName);
		setWriteDate(writeDate);
	}
	
	public BoardVO(
			String suggestionName
			, String contents
			, String penName
			, Date writeDate) {
		
		setSuggestionName(suggestionName);
		setContents(contents);
		setPenName(penName);
		setWriteDate(writeDate);
	}
	
	/**실시간 추천글 조회 
	 * 
	  SELECT (SElECT count(*) 
        FROM reaction 
        WHERE write_no = b.write_no) AS rCnt ,
       (SElECT count(*) 
        FROM bookmark 
        WHERE write_no = b.write_no) AS bmCnt ,
        b.write_no, b.contents, b.write_date, b.share_status, b.writer_id, b.suggestion_code, a.pen_name, b.suggestion_name
	    FROM board b, bookmark bm, reaction r
	    WHERE b.write_no = bm.write_no AND b.write_no = r.write_no AND rownum <= 10
	    ORDER BY b.write_date desc, rCnt, bmCnt desc;
	 * 
	 * */
	
	public BoardVO(
			int rCnt
			, String writeNo
			, String contents
			, Date writeDate
			, String shareStatus
			, String writerId
			, String suggestionCode
			, String penName
			, String suggestionName
			) {
		setrCnt(rCnt);
		setWriteNo(writeNo);
		setContents(contents);
		setWriteDate(writeDate);
		setShareStatus(shareStatus);
		setWriterId(writerId);
		setSuggestionCode(suggestionCode);
		setPenName(penName);
		setSuggestionName(suggestionName);
	}
	public BoardVO(
			int rCnt
			, int bmCnt
			, String writeNo
			, String contents
			, Date writeDate
			, String shareStatus
			, String writerId
			, String suggestionCode
			) {
		setrCnt(rCnt);
		setBmCnt(bmCnt);
		setWriteNo(writeNo);
		setContents(contents);
		setWriteDate(writeDate);
		setShareStatus(shareStatus);
		setWriterId(writerId);
		setSuggestionCode(suggestionCode);
	}
	/**
	    * 검색(제시어, 필명)
		*  select b.write_date, a.pen_name, s.suggestion_name from app_user a, board b, suggestion s where s.suggestion_name = ?;
	    * */
	/**
	 * --16. 즐겨찾기 글 목록 조회
		select bo.write_no, bm.bookmark_date, s.suggestion_name, a.pen_name
		from bookmark bm, board bo, suggestion s, app_user a
		where bm.write_no = bo.write_no 
		and bo.suggestion_code = s.suggestion_code
		and a.user_id = bo.writer_id
		and bm.USER_ID = 'test2';
	 * 
	 * */
	
	public BoardVO(
			String writeNo
			, Date writeDate
			, String penName
			, String suggestionName
			) {
		setWriteNo(writeNo);
		setWriteDate(writeDate);
		setPenName(penName);
		setSuggestionName(suggestionName);
	}
	public BoardVO(Date writeDate,String penName, String suggestionName ) {
		setWriteDate(writeDate);
		setPenName(penName);
		setSuggestionName(suggestionName);
	}
	
	   public BoardVO(String suggestionName
		         , String contents
		         , String penName
		         , Date writeDate
		         , String emotionCode){
		      setSuggestionName(suggestionName);
		      setContents(contents);
		      setPenName(penName);
		      setWriteDate(writeDate);
		      setEmotionCode(emotionCode);
		   }
	
	private String suggestionName;

	private String contents;
	private String penName;
	private Date writeDate;
	private String emotionCode;
	private String emotionName;
	
	private String writeNo;
	private String shareStatus;
	private String writerId;
	private String suggestionCode;
	
	private int rCnt;
	private int bmCnt;
	
	
	public int getrCnt() {
		return rCnt;
	}

	public void setrCnt(int rCnt) {
		this.rCnt = rCnt;
	}

	public int getBmCnt() {
		return bmCnt;
	}

	public void setBmCnt(int bmCnt) {
		this.bmCnt = bmCnt;
	}

	public String getSuggestionName() {
		return suggestionName;
	}

	public void setSuggestionName(String suggestionName) {
		this.suggestionName = suggestionName;
	}

	public String getContents() {
		return contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}

	public String getPenName() {
		return penName;
	}

	public void setPenName(String penName) {
		this.penName = penName;
	}

	public Date getWriteDate() {
		return writeDate;
	}

	public void setWriteDate(Date writeDate) {
		this.writeDate = writeDate;
	}

	public String getEmotionCode() {
		return emotionCode;
	}

	public void setEmotionCode(String emotionCode) {
		this.emotionCode = emotionCode;
	}
	
	public String getEmotionName() {
		return emotionName;
	}

	public void setEmotionName(String emotionName) {
		this.emotionName = emotionName;
	}

	public String getWriteNo() {
		return writeNo;
	}

	public void setWriteNo(String writeNo) {
		this.writeNo = writeNo;
	}

	public String getShareStatus() {
		return shareStatus;
	}

	public void setShareStatus(String shareStatus) {
		this.shareStatus = shareStatus;
	}

	public String getWriterId() {
		return writerId;
	}

	public void setWriterId(String writerId) {
		this.writerId = writerId;
	}

	public String getSuggestionCode() {
		return suggestionCode;
	}

	public void setSuggestionCode(String suggestionCode) {
		this.suggestionCode = suggestionCode;
	}

	@Override
	public String toString() {
		return "BoardVO [suggestionName=" + suggestionName + ", contents=" + contents + ", penName=" + penName
				+ ", writeDate=" + writeDate + ", emotionCode=" + emotionCode + ", writeNo=" + writeNo
				+ ", shareStatus=" + shareStatus + ", writerId=" + writerId + ", suggestionCode=" + suggestionCode
				+ "]\n";
	}
	
	
	
	
}
