--create DB table

--먼저 회원 테이블 생성
CREATE TABLE SemiMEMBER(
	id VARCHAR2(100) PRIMARY KEY,
	name VARCHAR2(100) NOT NULL, 
	tel VARCHAR2(100) NOT NULL,
	KOSTANo VARCHAR2(100) NOT NULL,
	password VARCHAR2(100) NOT NULL
)

ALTER TABLE SemiMEMBER ADD CONSTRAINT member_tel UNIQUE (tel);

select * from SemiMEMBER



ALTER TABLE SemiBoard DROP COLUMN postContent
ALTER TABLE SemiBoard ADD PostContent CLOB NOT NULL

CREATE TABLE SemiBoard(
	postNo NUMBER PRIMARY KEY,
	postContent CLOB NOT NULL,
	postDate DATE NOT NULL,
	postCategory VARCHAR2(100) NOT NULL,
	postTitle VARCHAR2(100) NOT NULL,
	id VARCHAR2(100) NOT NULL,
	hits NUMBER DEFAULT 0 NOT NULL,
	CONSTRAINT mySemiboard_fk FOREIGN KEY(id) REFERENCES SemiMEMBER(id)
)

ALTER TABLE SemiBoard ADD hits NUMBER DEFAULT 0;

--SemiBoard 시퀀스
CREATE SEQUENCE SemiBoard_seq

CREATE TABLE SemiLike(
	id VARCHAR2(100),
	postNo NUMBER,
	CONSTRAINT mySemiLike_pk PRIMARY KEY(id, postNo),
	CONSTRAINT mySemiLike_fk1 FOREIGN KEY(id) REFERENCES SemiMEMBER(id),
	CONSTRAINT mySemiLike_fk2 FOREIGN KEY(postNo) REFERENCES SemiBoard(postNo)
)

CREATE TABLE SemiFile(
	fileNo NUMBER,
	postNo NUMBER,
	originalName VARCHAR2(100) NOT NULL,
	savedName VARCHAR2(100) NOT NULL,
	filePath VARCHAR2(100) NOT NULL,
	fileSize NUMBER NOT NULL,
	fileDate DATE NOT NULL,
	CONSTRAINT mySemiFile_pk PRIMARY KEY(fileNo, postNo),
	CONSTRAINT mySemiFile_fk FOREIGN KEY(postNo) REFERENCES SemiBoard(postNo)
)

--SemiFile 시퀀스
CREATE SEQUENCE SemiFile_seq

CREATE TABLE SemiComment(
	commentNo NUMBER,
	postNo NUMBER,
	commentDate Date NOT NULL,
	commentContent CLOB NOT NULL,
	CONSTRAINT mySemiComment_pk PRIMARY KEY(commentNo, postNo),
	CONSTRAINT mySemiComment_fk FOREIGN KEY(postNo) REFERENCES SemiBoard(postNo)
)

--SemiComment 시퀀스
CREATE SEQUENCE SemiComment_seq

--SemiBoard number add
ALTER TABLE SemiBoard ADD hits NUMBER DEFAULT 0;
SELECT * FROM SemiBoard;
select * from semimember;

SELECT COUNT(*) FROM SEMIMEMBER WHERE ID='java'and password='b';

--유튜브 링크
ALTER TABLE SemiBoard ADD youtubelink VARCHAR2(100);
ALTER TABLE SemiBoard drop column youtube;

SELECT COUNT(*) FROM SemiBoard WHERE postcategory='소통'


select rnum, postNo, postTitle, postDate, postCategory, hits , name, id 
			FROM(select b.postNo, b.postTitle, b.postDate, b.postCategory, b.hits , m.name, m.id  
			from SemiBoard b , semimember m
				where m.id = b.id 
			and b.postTitle LIKE 'a%' || ? || '%a') 
			WHERE rnum between 1 and 2
			
SELECT * FROM SemiBoard

COMMIT