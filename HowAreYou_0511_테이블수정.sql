-- ����ڰ� ���ã�� ������ ����� �� �ֵ��� ���ѿ��� -> ���ѿ������� ������

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