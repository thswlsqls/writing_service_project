/* ������ ���� */
drop sequence write_no_seq;
drop sequence follow_no_seq;
drop sequence empathy_no_seq;

create sequence write_no_seq;
create sequence follow_no_seq;
create sequence empathy_no_seq;


/* ȸ�� */
CREATE TABLE app_user (
	user_id VARCHAR2(20) NOT NULL, /* ���̵� */
	pen_name VARCHAR2(30) NOT NULL, /* �ʸ� */
	user_pw VARCHAR2(30) NOT NULL, /* ��й�ȣ */
	email VARCHAR2(20) NOT NULL, /* �̸��� */
	tel VARCHAR2(15) /* ��ȭ��ȣ */
);
ALTER TABLE app_user ADD name VARCHAR(20) NOT NULL;

COMMENT ON TABLE app_user IS 'ȸ��';

COMMENT ON COLUMN app_user.user_id IS '���̵�';

COMMENT ON COLUMN app_user.pen_name IS '�ʸ�';

COMMENT ON COLUMN app_user.user_pw IS '��й�ȣ';

COMMENT ON COLUMN app_user.email IS '�̸���';

COMMENT ON COLUMN app_user.tel IS '��ȭ��ȣ';

ALTER TABLE app_user
	ADD
		CONSTRAINT PK_app_user
		PRIMARY KEY (
			user_id
		);

/* �ȷο� ��� */
CREATE TABLE follow_list (
	follow_no NUMBER NOT NULL, /* �ȷο� ����Ʈ ��ȣ */
	followee_id VARCHAR2(20) NOT NULL, /* �ȷο� ��� ���̵� */
	follower_id VARCHAR2(20) NOT NULL, /* ��û�� ���̵� */
	follow_date DATE NOT NULL /* �ȷο����� */
);

COMMENT ON TABLE follow_list IS '�ȷο� ���';

COMMENT ON COLUMN follow_list.follow_no IS '�ȷο� ����Ʈ ��ȣ';

COMMENT ON COLUMN follow_list.followee_id IS '�ȷο� ��� ���̵�';

COMMENT ON COLUMN follow_list.follower_id IS '��û�� ���̵�';

COMMENT ON COLUMN follow_list.follow_date IS '�ȷο�����';

ALTER TABLE follow_list
	ADD
		CONSTRAINT PK_follow_list
		PRIMARY KEY (
			follow_no
		);

/* ���ã�� */
CREATE TABLE bookmark (
	user_id VARCHAR2(20) NOT NULL, /* �߰��� ���̵� */
	write_no NUMBER NOT NULL, /* �Խñ۹�ȣ */
	bookmark_date DATE NOT NULL /* ���ã���߰����� */
);

COMMENT ON TABLE bookmark IS '���ã��';

COMMENT ON COLUMN bookmark.user_id IS '�߰��� ���̵�';

COMMENT ON COLUMN bookmark.write_no IS '�Խñ۹�ȣ';

COMMENT ON COLUMN bookmark.bookmark_date IS '���ã���߰�����';

ALTER TABLE bookmark
	ADD
		CONSTRAINT PK_bookmark
		PRIMARY KEY (
			user_id
		);

/* �Խñ� */
CREATE TABLE board (
	write_no NUMBER NOT NULL, /* �Խñ۹�ȣ */
	writer_id VARCHAR2(20) NOT NULL, /* �ۼ��� ���̵� */
	suggestion_code VARCHAR2(20) NOT NULL, /* ���þ�_�ڵ� */
	contents VARCHAR2(300) NOT NULL, /* ���� */
	share_status VARCHAR2(10) NOT NULL, /* �������� */
	write_date DATE NOT NULL /* �ۼ����� */
);

COMMENT ON TABLE board IS '�Խñ�';

COMMENT ON COLUMN board.write_no IS '�Խñ۹�ȣ';

COMMENT ON COLUMN board.writer_id IS '�ۼ��� ���̵�';

COMMENT ON COLUMN board.suggestion_code IS '���þ�_�ڵ�';

COMMENT ON COLUMN board.contents IS '����';

COMMENT ON COLUMN board.share_status IS '��������';

COMMENT ON COLUMN board.write_date IS '�ۼ�����';

ALTER TABLE board
	ADD
		CONSTRAINT PK_board
		PRIMARY KEY (
			write_no
		);

/* ���� */
CREATE TABLE emotion (
	emotion_code VARCHAR2(20) NOT NULL, /* ����_�ڵ� */
	main_emotion VARCHAR2(20) NOT NULL, /* ������з� */
	emotion_name VARCHAR2(20) NOT NULL /* ������ */
);

COMMENT ON TABLE emotion IS '����';

COMMENT ON COLUMN emotion.emotion_code IS '����_�ڵ�';

COMMENT ON COLUMN emotion.main_emotion IS '������з�';

COMMENT ON COLUMN emotion.emotion_name IS '������';

ALTER TABLE emotion
	ADD
		CONSTRAINT PK_emotion
		PRIMARY KEY (
			emotion_code
		);

/* ���þ� */
CREATE TABLE suggestion (
	suggestion_code VARCHAR2(20) NOT NULL, /* ���þ�_�ڵ� */
	emotion_code VARCHAR2(20) NOT NULL, /* ����_�ڵ� */
	suggestion_name VARCHAR2(20) NOT NULL /* ���þ�� */
);

COMMENT ON TABLE suggestion IS '���þ�';

COMMENT ON COLUMN suggestion.suggestion_code IS '���þ�_�ڵ�';

COMMENT ON COLUMN suggestion.emotion_code IS '����_�ڵ�';

COMMENT ON COLUMN suggestion.suggestion_name IS '���þ��';

ALTER TABLE suggestion
	ADD
		CONSTRAINT PK_suggestion
		PRIMARY KEY (
			suggestion_code
		);

/* �������̺� */
CREATE TABLE picture (
	picture_code VARCHAR2(20) NOT NULL, /* ����_�ڵ� */
	emotion_code VARCHAR2(20) NOT NULL, /* ����_�ڵ� */
	picture_path VARCHAR2(100) NOT NULL /* ���� ��� */
);

COMMENT ON TABLE picture IS '�������̺�';

COMMENT ON COLUMN picture.picture_code IS '����_�ڵ�';

COMMENT ON COLUMN picture.emotion_code IS '����_�ڵ�';

COMMENT ON COLUMN picture.picture_path IS '���� ���';

ALTER TABLE picture
	ADD
		CONSTRAINT PK_picture
		PRIMARY KEY (
			picture_code,
			emotion_code
		);

/* ���ƿ� */
CREATE TABLE reaction (
	user_id VARCHAR2(20) NOT NULL, /* ����� ���̵� */
	write_no NUMBER NOT NULL, /* �Խñ۹�ȣ */
	reaction_date DATE NOT NULL /* ���ƿ������� */
);

COMMENT ON TABLE reaction IS '���ƿ�';

COMMENT ON COLUMN reaction.user_id IS '����� ���̵�';

COMMENT ON COLUMN reaction.write_no IS '�Խñ۹�ȣ';

COMMENT ON COLUMN reaction.reaction_date IS '���ƿ�������';

ALTER TABLE reaction
	ADD
		CONSTRAINT PK_reaction
		PRIMARY KEY (
			user_id,
			write_no
		);

/* ������ */
CREATE TABLE Empathy (
	empathy_no NUMBER NOT NULL, /* ������ȣ */
	user_id VARCHAR2(20) NOT NULL, /* ������ ������ ȸ���� ���̵� */
	emotion_code VARCHAR2(20) NOT NULL, /* ������ �����ڵ� */
	empathy_date DATE NOT NULL /* ������������ */
);

COMMENT ON TABLE Empathy IS '������';

COMMENT ON COLUMN Empathy.empathy_no IS '������ȣ';

COMMENT ON COLUMN Empathy.user_id IS '������ ������ ȸ���� ���̵�';

COMMENT ON COLUMN Empathy.emotion_code IS '������ �����ڵ�';

COMMENT ON COLUMN Empathy.empathy_date IS '������������';

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
INCREMENT BY 1  -- �������� 1
START WITH 1    -- ���۰� 1
MINVALUE 1 --  �ּҰ� 1
NOCYCLE;  -- ��ȯ����

CREATE SEQUENCE WRITE_NO_SEQ
INCREMENT BY 1  -- �������� 1
START WITH 1    -- ���۰� 1
MINVALUE 1 --  �ּҰ� 1
NOCYCLE;  -- ��ȯ����

CREATE SEQUENCE EMPATHY_NO_SEQ
INCREMENT BY 1  -- �������� 1
START WITH 1    -- ���۰� 1
MINVALUE 1 --  �ּҰ� 1
NOCYCLE;  -- ��ȯ����

ALTER TABLE empathy ADD empathy_no NUMBER NOT NULL;
SELECT * FROM empathy;

ALTER TABLE empathy ADD PRIMARY KEY(empathy_no);



    