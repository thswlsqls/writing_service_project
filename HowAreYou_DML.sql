select * from follow_list;
select * from bookmark;
select * from board;
select * from emotion;
select * from reaction;
select * from suggestion;
select * from picture;
select * from Empathy;
select * from app_user;
ALTER TABLE app_user ADD name VARCHAR(20) NOT NULL;

--1. �α��� 
select pen_name from app_user where user_id = ? and user_pw = ?;

--2. ȸ������ 
insert into app_user(user_id, name, pen_name, user_pw, email, tel) values(?,?,?,?,?,?);

--3. IDã�� 
select user_id from app_user where name = ? and email = ?;

--4. PW ã�� 

--5. �Խñ� �ۼ� 
insert into board(write_no, contents, write_date, share_status, writer_id, suggestion_code)
values(write_no_seq.nextval, ?, sysdate, '��ü', ?, ?);

--6. �Խñ� ���� 
update board set contents = ? where writer_id = ? and write_no = ?;

--7 �Խñ� ����
delete from board where writer_id = ? and write_no = ?;

--8. �������� ���� 
update board set share_status = ? where write_no = ? and writer_id = ?;

--9. �˻�(�ʸ�)
select b.write_date, a.pen_name, s.suggestion_name from app_user a, board b, suggestion s where a.pen_name = ?;

--10. �˻�(���þ�)
select b.write_date, a.pen_name, s.suggestion_name from app_user a, board b, suggestion s where s.suggestion_name = ?;

--11. �Խñ� ��ȸ(����)
select s.suggestion_name, b.contents, a.pen_name, b.write_date, e.emotion_code
from app_user a, board b, suggestion s, emotion e
where b.writer_id = a.user_id and b.suggestion_code = s.suggestion_code and e.emotion_code = s.emotion_code
and e.emotion_code = ? ;

--12. ���ƿ� ���� ��ȸ
select count(user_id) from reaction where write_no = ?;

--13. reaction ���̺� �Խñ۹�ȣ ������� primaryŰ ����
-- ���� ���ƿ� �������� �ȴ������� Ȯ��(��Ʈ�� �ҵ����°�)
select reaction_date from reaction where write_no = ? and user_id = ?;

--14. ���ο�(�ֱٰԽù� ��ȸ)
select s.suggestion_name, b.contents, a.pen_name, b.write_date
from app_user a, board b, suggestion s 
where b.writer_id = a.user_id and b.suggestion_code = s.suggestion_code
and rownum<=10
order by b.write_date desc;

--15. �ǽð���õ - ���ƿ�� �ϸ�ũ ������ ��������
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
    
--15 - 1. �ǽð���õ - ���ƿ� ������ ��������
SELECT (SElECT count(*) 
FROM reaction 
WHERE write_no = b.write_no) AS rCnt ,
b.write_no, b.contents, b.write_date, b.share_status, b.writer_id, b.suggestion_code
FROM board b, reaction r
WHERE b.write_no = r.write_no AND rownum <= 10
ORDER BY b.write_date, rCnt desc;
    
--InteractionDAO
--16. ���ã�� �� ��� ��ȸ
select bm.bookmark_date, s.suggestion_name, a.pen_name
from bookmark bm, board bo, suggestion s, app_user a
where bm.write_no = bo.write_no 
and bo.suggestion_code = s.suggestion_code
and a.user_id = bo.writer_id
and user_id = ?;

--17. ���ã�� �� �߰�
insert into bookmark values(?,sysdate,?);

--18. ���ã�� �� ����
delete from bookmark where write_no=? and write_id=?;

--19. ���ã�� �� ����ȸ
select s.suggestion_name, b.contents, a.pen_name, b.write_date, e.emotion_code
from app_user a, board b, suggestion s, emotion e, bookmark bm
where b.writer_id = a.user_id 
and b.writer_id = bm.user_id
and b.suggestion_code = s.suggestion_code 
and e.emotion_code = s.emotion_code
and e.emotion_code = ?;

--20. �ȷο�(ģ���߰�)
insert into follow_list values(?,sysdate,?,?);

--21. �ȷο� ��ȸ
select follow_date, followee_id 
from follow_list
where follower_id = ?;

--22. ���ƿ� �߰�
insert into reaction values(?,?,sysdate);

--23. ���ƿ� ����
delete from reaction where user_id = ? and write_no = ?;

--EmotionDAO
--24. ���� 8�� �Ѹ���/���ΰ�ħ
select emotion_name 
from (select * from emotion order by dbms_random.random)
where rownum = 1
and main_emotion = ?;

BEGIN
    FOR I IN 1..8
    LOOP
      select emotion_name 
      from (select * from emotion order by dbms_random.random)
      where rownum = 1
      and main_emotion = "";
    END LOOP;
END;

--25. ��������
insert into empathy values(?,?,sysdate);

--26. �������� -> ���þ� ����
select * from (select s.suggestion_name from suggestion s, emotion e, empathy p
where s.emotion_code = e.emotion_code
and e.emotion_code = p.emotion_code
and p.user_id = ?
order by dbms_random.random)
where rownum <= 2;

--27. ���� Ʈ���� ��ȸ
select emotion_name from (select e.emotion_name, count(*) 
from empathy p, emotion e 
where e.emotion_code = p.emotion_code
group by emotion_name
order by 2 desc)
where rownum <= 3;

--28. Ʈ���庰 �� ��ȸ
select s.sugguestion_name, b.contents, a.pen_name, b.write_date 
from board b, suggestion s, emotion e, app_user a
where and a.user_id = b.writer_id
and s.suggestion_code = b.suggestion_code
and e.emotion_code = s.emotion_code
and e.emotion_name = ?;

--29. �ǽð� ��õ ��
select s.suggestion_name, b.contents, a.pen_name, b.write_date, e.emotion_code
from app_user a, board b, suggestion s, emotion e
where b.writer_id = a.user_id and b.suggestion_code = s.suggestion_code and e.emotion_code = s.emotion_code
and e.emotion_code = ? ;

--30. ���ۼ� �� ���þ 2���� ���ΰ�ħ
select suggestion_name from 
(select distinct s.suggestion_name from app_user a, empathy p, emotion e, suggestion s 
where a.user_id = 'test1'
and a.user_id = p.user_id
and p.emotion_code = e.emotion_code
and e.emotion_code = s.emotion_code
order by dbms_random.random)
where rownum<=2

--31. ���ƿ� ��Ͽ��� ��ȸ
SELECT user_id FROM reaction WHERE user_id = ? AND write_no = ?;

