/* 시퀀스 리셋 */
drop sequence write_no_seq;
drop sequence follow_no_seq;
drop sequence empathy_no_seq;

create sequence write_no_seq;
create sequence follow_no_seq;
create sequence empathy_no_seq;


/* 회원 */
CREATE TABLE app_user (
	user_id VARCHAR2(20) NOT NULL, /* 아이디 */
	pen_name VARCHAR2(30) NOT NULL, /* 필명 */
	user_pw VARCHAR2(30) NOT NULL, /* 비밀번호 */
	email VARCHAR2(20) NOT NULL, /* 이메일 */
	tel VARCHAR2(15) /* 전화번호 */
);
ALTER TABLE app_user ADD name VARCHAR(20) NOT NULL;

COMMENT ON TABLE app_user IS '회원';

COMMENT ON COLUMN app_user.user_id IS '아이디';

COMMENT ON COLUMN app_user.pen_name IS '필명';

COMMENT ON COLUMN app_user.user_pw IS '비밀번호';

COMMENT ON COLUMN app_user.email IS '이메일';

COMMENT ON COLUMN app_user.tel IS '전화번호';

ALTER TABLE app_user
	ADD
		CONSTRAINT PK_app_user
		PRIMARY KEY (
			user_id
		);

/* 팔로우 목록 */
CREATE TABLE follow_list (
	follow_no NUMBER NOT NULL, /* 팔로우 리스트 번호 */
	followee_id VARCHAR2(20) NOT NULL, /* 팔로우 대상 아이디 */
	follower_id VARCHAR2(20) NOT NULL, /* 요청자 아이디 */
	follow_date DATE NOT NULL /* 팔로우일자 */
);

COMMENT ON TABLE follow_list IS '팔로우 목록';

COMMENT ON COLUMN follow_list.follow_no IS '팔로우 리스트 번호';

COMMENT ON COLUMN follow_list.followee_id IS '팔로우 대상 아이디';

COMMENT ON COLUMN follow_list.follower_id IS '요청자 아이디';

COMMENT ON COLUMN follow_list.follow_date IS '팔로우일자';

ALTER TABLE follow_list
	ADD
		CONSTRAINT PK_follow_list
		PRIMARY KEY (
			follow_no
		);

/* 즐겨찾기 */
CREATE TABLE bookmark (
	user_id VARCHAR2(20) NOT NULL, /* 추가자 아이디 */
	write_no NUMBER NOT NULL, /* 게시글번호 */
	bookmark_date DATE NOT NULL /* 즐겨찾기추가일자 */
);

COMMENT ON TABLE bookmark IS '즐겨찾기';

COMMENT ON COLUMN bookmark.user_id IS '추가자 아이디';

COMMENT ON COLUMN bookmark.write_no IS '게시글번호';

COMMENT ON COLUMN bookmark.bookmark_date IS '즐겨찾기추가일자';

ALTER TABLE bookmark
	ADD
		CONSTRAINT PK_bookmark
		PRIMARY KEY (
			user_id
		);

/* 게시글 */
CREATE TABLE board (
	write_no NUMBER NOT NULL, /* 게시글번호 */
	writer_id VARCHAR2(20) NOT NULL, /* 작성자 아이디 */
	suggestion_code VARCHAR2(20) NOT NULL, /* 제시어_코드 */
	contents VARCHAR2(300) NOT NULL, /* 내용 */
	share_status VARCHAR2(10) NOT NULL, /* 공유상태 */
	write_date DATE NOT NULL /* 작성일자 */
);

COMMENT ON TABLE board IS '게시글';

COMMENT ON COLUMN board.write_no IS '게시글번호';

COMMENT ON COLUMN board.writer_id IS '작성자 아이디';

COMMENT ON COLUMN board.suggestion_code IS '제시어_코드';

COMMENT ON COLUMN board.contents IS '내용';

COMMENT ON COLUMN board.share_status IS '공유상태';

COMMENT ON COLUMN board.write_date IS '작성일자';

ALTER TABLE board
	ADD
		CONSTRAINT PK_board
		PRIMARY KEY (
			write_no
		);

/* 감정 */
CREATE TABLE emotion (
	emotion_code VARCHAR2(20) NOT NULL, /* 감정_코드 */
	main_emotion VARCHAR2(20) NOT NULL, /* 감정대분류 */
	emotion_name VARCHAR2(20) NOT NULL /* 감정명 */
);

COMMENT ON TABLE emotion IS '감정';

COMMENT ON COLUMN emotion.emotion_code IS '감정_코드';

COMMENT ON COLUMN emotion.main_emotion IS '감정대분류';

COMMENT ON COLUMN emotion.emotion_name IS '감정명';

ALTER TABLE emotion
	ADD
		CONSTRAINT PK_emotion
		PRIMARY KEY (
			emotion_code
		);

/* 제시어 */
CREATE TABLE suggestion (
	suggestion_code VARCHAR2(20) NOT NULL, /* 제시어_코드 */
	emotion_code VARCHAR2(20) NOT NULL, /* 감정_코드 */
	suggestion_name VARCHAR2(20) NOT NULL /* 제시어명 */
);

COMMENT ON TABLE suggestion IS '제시어';

COMMENT ON COLUMN suggestion.suggestion_code IS '제시어_코드';

COMMENT ON COLUMN suggestion.emotion_code IS '감정_코드';

COMMENT ON COLUMN suggestion.suggestion_name IS '제시어명';

ALTER TABLE suggestion
	ADD
		CONSTRAINT PK_suggestion
		PRIMARY KEY (
			suggestion_code
		);

/* 사진테이블 */
CREATE TABLE picture (
	picture_code VARCHAR2(20) NOT NULL, /* 사진_코드 */
	emotion_code VARCHAR2(20) NOT NULL, /* 감정_코드 */
	picture_path VARCHAR2(100) NOT NULL /* 사진 경로 */
);

COMMENT ON TABLE picture IS '사진테이블';

COMMENT ON COLUMN picture.picture_code IS '사진_코드';

COMMENT ON COLUMN picture.emotion_code IS '감정_코드';

COMMENT ON COLUMN picture.picture_path IS '사진 경로';

ALTER TABLE picture
	ADD
		CONSTRAINT PK_picture
		PRIMARY KEY (
			picture_code,
			emotion_code
		);

/* 좋아요 */
CREATE TABLE reaction (
	user_id VARCHAR2(20) NOT NULL, /* 등록자 아이디 */
	write_no NUMBER NOT NULL, /* 게시글번호 */
	reaction_date DATE NOT NULL /* 좋아요등록일자 */
);

COMMENT ON TABLE reaction IS '좋아요';

COMMENT ON COLUMN reaction.user_id IS '등록자 아이디';

COMMENT ON COLUMN reaction.write_no IS '게시글번호';

COMMENT ON COLUMN reaction.reaction_date IS '좋아요등록일자';

ALTER TABLE reaction
	ADD
		CONSTRAINT PK_reaction
		PRIMARY KEY (
			user_id,
			write_no
		);

/* 공감빈도 */
CREATE TABLE Empathy (
	empathy_no NUMBER NOT NULL, /* 공감번호 */
	user_id VARCHAR2(20) NOT NULL, /* 감정을 선택한 회원의 아이디 */
	emotion_code VARCHAR2(20) NOT NULL, /* 선택한 감정코드 */
	empathy_date DATE NOT NULL /* 공감생성일자 */
);

COMMENT ON TABLE Empathy IS '공감빈도';

COMMENT ON COLUMN Empathy.empathy_no IS '공감번호';

COMMENT ON COLUMN Empathy.user_id IS '감정을 선택한 회원의 아이디';

COMMENT ON COLUMN Empathy.emotion_code IS '선택한 감정코드';

COMMENT ON COLUMN Empathy.empathy_date IS '공감생성일자';

ALTER TABLE Empathy
	ADD
		CONSTRAINT PK_Empathy
		PRIMARY KEY (
			empathy_no,
			user_id,
			emotion_code
		);

ALTER TABLE follow_list
	ADD
		CONSTRAINT FK_app_user_TO_follow_list2
		FOREIGN KEY (
			followee_id
		)
		REFERENCES app_user (
			user_id
		);

ALTER TABLE follow_list
	ADD
		CONSTRAINT FK_app_user_TO_follow_list
		FOREIGN KEY (
			follower_id
		)
		REFERENCES app_user (
			user_id
		);

ALTER TABLE bookmark
	ADD
		CONSTRAINT FK_board_TO_bookmark
		FOREIGN KEY (
			write_no
		)
		REFERENCES board (
			write_no
		);

ALTER TABLE bookmark
	ADD
		CONSTRAINT FK_app_user_TO_bookmark
		FOREIGN KEY (
			user_id
		)
		REFERENCES app_user (
			user_id
		);

ALTER TABLE board
	ADD
		CONSTRAINT FK_app_user_TO_board
		FOREIGN KEY (
			writer_id
		)
		REFERENCES app_user (
			user_id
		);

ALTER TABLE board
	ADD
		CONSTRAINT FK_suggestion_TO_board
		FOREIGN KEY (
			suggestion_code
		)
		REFERENCES suggestion (
			suggestion_code
		);

ALTER TABLE suggestion
	ADD
		CONSTRAINT FK_emotion_TO_suggestion
		FOREIGN KEY (
			emotion_code
		)
		REFERENCES emotion (
			emotion_code
		);

ALTER TABLE picture
	ADD
		CONSTRAINT FK_emotion_TO_picture
		FOREIGN KEY (
			emotion_code
		)
		REFERENCES emotion (
			emotion_code
		);

ALTER TABLE reaction
	ADD
		CONSTRAINT FK_app_user_TO_reaction
		FOREIGN KEY (
			user_id
		)
		REFERENCES app_user (
			user_id
		);

ALTER TABLE reaction
	ADD
		CONSTRAINT FK_board_TO_reaction
		FOREIGN KEY (
			write_no
		)
		REFERENCES board (
			write_no
		);

ALTER TABLE Empathy
	ADD
		CONSTRAINT FK_app_user_TO_Empathy
		FOREIGN KEY (
			user_id
		)
		REFERENCES app_user (
			user_id
		);

ALTER TABLE Empathy
	ADD
		CONSTRAINT FK_emotion_TO_Empathy
		FOREIGN KEY (
			emotion_code
		)
		REFERENCES emotion (
			emotion_code
		);
    SELECT (SElECT count(*) 
            FROM reaction 
            WHERE write_no = b.write_no) AS rCnt ,
           (SElECT count(*) 
            FROM bookmark 
            WHERE write_no = b.write_no) AS bmCnt ,
            b.write_no, b.contents, b.write_date, b.share_status, b.writer_id, b.suggestion_code
    FROM board b, bookmark bm, reaction r
    WHERE b.write_no = bm.write_no AND b.write_no = r.write_no AND rownum <= 5
    ORDER BY b.write_date desc, rCnt, bmCnt desc;
    
    
drop table app_user;
drop table follow_list;
drop table bookmark;
drop table board;
drop table emotion;
drop table reaction;
drop table suggestion;
drop table picture;
drop table Empathy;


CREATE SEQUENCE FOLLOW_NO_SEQ
INCREMENT BY 1  -- 증가숫자 1
START WITH 1    -- 시작값 1
MINVALUE 1 --  최소값 1
NOCYCLE;  -- 순환안함

CREATE SEQUENCE WRITE_NO_SEQ
INCREMENT BY 1  -- 증가숫자 1
START WITH 1    -- 시작값 1
MINVALUE 1 --  최소값 1
NOCYCLE;  -- 순환안함

CREATE SEQUENCE EMPATHY_NO_SEQ
INCREMENT BY 1  -- 증가숫자 1
START WITH 1    -- 시작값 1
MINVALUE 1 --  최소값 1
NOCYCLE;  -- 순환안함

ALTER TABLE empathy ADD empathy_no NUMBER NOT NULL;
SELECT * FROM empathy;

ALTER TABLE empathy ADD PRIMARY KEY(empathy_no);



    