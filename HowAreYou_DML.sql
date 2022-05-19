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

--1. 로그인 
select pen_name from app_user where user_id = ? and user_pw = ?;

--2. 회원가입 
insert into app_user(user_id, name, pen_name, user_pw, email, tel) values(?,?,?,?,?,?);

--3. ID찾기 
select user_id from app_user where name = ? and email = ?;

--4. PW 찾기 

--5. 게시글 작성 
insert into board(write_no, contents, write_date, share_status, writer_id, suggestion_code)
values(write_no_seq.nextval, ?, sysdate, '전체', ?, ?);

--6. 게시글 수정 
update board set contents = ? where writer_id = ? and write_no = ?;

--7 게시글 삭제
delete from board where writer_id = ? and write_no = ?;

--8. 공유상태 설정 
update board set share_status = ? where write_no = ? and writer_id = ?;

--9. 검색(필명)
select b.write_date, a.pen_name, s.suggestion_name from app_user a, board b, suggestion s where a.pen_name = ?;

--10. 검색(제시어)
select b.write_date, a.pen_name, s.suggestion_name from app_user a, board b, suggestion s where s.suggestion_name = ?;

--11. 게시글 조회(메인)
select s.suggestion_name, b.contents, a.pen_name, b.write_date, e.emotion_code
from app_user a, board b, suggestion s, emotion e
where b.writer_id = a.user_id and b.suggestion_code = s.suggestion_code and e.emotion_code = s.emotion_code
and e.emotion_code = ? ;

--12. 좋아요 개수 조회
select count(user_id) from reaction where write_no = ?;

--13. reaction 테이블 게시글번호 제약사항 primary키 해제
-- 내가 좋아요 눌렀는지 안눌렀는지 확인(하트에 불들어오는거)
select reaction_date from reaction where write_no = ? and user_id = ?;

--14. 새로운(최근게시물 조회)
select s.suggestion_name, b.contents, a.pen_name, b.write_date
from app_user a, board b, suggestion s 
where b.writer_id = a.user_id and b.suggestion_code = s.suggestion_code
and rownum<=10
order by b.write_date desc;

--15. 실시간추천 - 좋아요와 북마크 개수를 기준으로
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
    
--15 - 1. 실시간추천 - 좋아요 개수를 기준으로
SELECT (SElECT count(*) 
FROM reaction 
WHERE write_no = b.write_no) AS rCnt ,
b.write_no, b.contents, b.write_date, b.share_status, b.writer_id, b.suggestion_code
FROM board b, reaction r
WHERE b.write_no = r.write_no AND rownum <= 10
ORDER BY b.write_date, rCnt desc;
    
--InteractionDAO
--16. 즐겨찾기 글 목록 조회
select bm.bookmark_date, s.suggestion_name, a.pen_name
from bookmark bm, board bo, suggestion s, app_user a
where bm.write_no = bo.write_no 
and bo.suggestion_code = s.suggestion_code
and a.user_id = bo.writer_id
and user_id = ?;

--17. 즐겨찾기 글 추가
insert into bookmark values(?,sysdate,?);

--18. 즐겨찾기 글 삭제
delete from bookmark where write_no=? and write_id=?;

--19. 즐겨찾기 글 상세조회
select s.suggestion_name, b.contents, a.pen_name, b.write_date, e.emotion_code
from app_user a, board b, suggestion s, emotion e, bookmark bm
where b.writer_id = a.user_id 
and b.writer_id = bm.user_id
and b.suggestion_code = s.suggestion_code 
and e.emotion_code = s.emotion_code
and e.emotion_code = ?;

--20. 팔로우(친구추가)
insert into follow_list values(?,sysdate,?,?);

--21. 팔로워 조회
select follow_date, followee_id 
from follow_list
where follower_id = ?;

--22. 좋아요 추가
insert into reaction values(?,?,sysdate);

--23. 좋아요 삭제
delete from reaction where user_id = ? and write_no = ?;

--EmotionDAO
--24. 감정 8개 뿌리기/새로고침
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

--25. 감정선택
insert into empathy values(?,?,sysdate);

--26. 감정선택 -> 제시어 추출
select * from (select s.suggestion_name from suggestion s, emotion e, empathy p
where s.emotion_code = e.emotion_code
and e.emotion_code = p.emotion_code
and p.user_id = ?
order by dbms_random.random)
where rownum <= 2;

--27. 감정 트렌드 조회
select emotion_name from (select e.emotion_name, count(*) 
from empathy p, emotion e 
where e.emotion_code = p.emotion_code
group by emotion_name
order by 2 desc)
where rownum <= 3;

--28. 트렌드별 글 조회
select s.sugguestion_name, b.contents, a.pen_name, b.write_date 
from board b, suggestion s, emotion e, app_user a
where and a.user_id = b.writer_id
and s.suggestion_code = b.suggestion_code
and e.emotion_code = s.emotion_code
and e.emotion_name = ?;

--29. 실시간 추천 글
select s.suggestion_name, b.contents, a.pen_name, b.write_date, e.emotion_code
from app_user a, board b, suggestion s, emotion e
where b.writer_id = a.user_id and b.suggestion_code = s.suggestion_code and e.emotion_code = s.emotion_code
and e.emotion_code = ? ;

--30. 글작성 시 제시어를 2개씩 새로고침
select suggestion_name from 
(select distinct s.suggestion_name from app_user a, empathy p, emotion e, suggestion s 
where a.user_id = 'test1'
and a.user_id = p.user_id
and p.emotion_code = e.emotion_code
and e.emotion_code = s.emotion_code
order by dbms_random.random)
where rownum<=2

--31. 좋아요 등록여부 조회
SELECT user_id FROM reaction WHERE user_id = ? AND write_no = ?;

