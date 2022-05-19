-- 사용자가 즐겨찾기 복수개 등록할 수 있도록 약한연관 -> 강한연관으로 변경함

ALTER TABLE bookmark
DROP CONSTRAINT PK_bookmark; 

ALTER TABLE bookmark
	ADD
		CONSTRAINT PK_bookmark
		PRIMARY KEY (
			user_id,
      write_no
		);
		
commit;