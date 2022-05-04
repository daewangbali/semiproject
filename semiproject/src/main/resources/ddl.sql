--create DB table

--먼저 회원 테이블 생성
CREATE TABLE SemiMEMBER(
	id VARCHAR2(100) PRIMARY KEY,
	name VARCHAR2(100) NOT NULL, 
	tel VARCHAR2(100) NOT NULL,
	KOSTANo VARCHAR2(100) NOT NULL,
	password VARCHAR2(100) NOT NULL
)

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
SELECT * FROM SemiBoard

SELECT postNo,postTitle,postDate,hits,id 
FROM ( SELECT ROW_NUMBER() OVER(ORDER BY no DESC) as rnum,postno,posttitle,TO_CHAR(postDate,'YYYY.MM.DD') as postDate,hits,id 
			FROM semiboard 
			) b , semimember m 
			WHERE b.id=m.id AND rnum BETWEEN 1 AND 5
			
			SELECT b.rnum,b.postNo, b.postTitle, m.id, TO_CHAR(b.postDate,'yyyy.mm.dd') as postDate, b.hits 
			FROM(SELECT ROW_NUMBER() OVER(ORDER BY postno DESC) as rnum, postno, posttitle, to_char(postdate,'yyyy.mm.dd') as postDate, hits, id, postCategory FROM semiboard WHERE postCategory='소통') b, SemiMember m 
			WHERE m.id=b.id 
			AND b.rnum between 1 and 2;
			ORDER BY b.postNo desc 
			
			SELECT rnum, postNo, postTitle,id, postDate, postCategory, hits
			FROM(SELECT ROW_NUMBER() OVER(ORDER BY postno DESC) as rnum, postno, posttitle, to_char(postdate,'yyyy.mm.dd') as postDate, hits, id, postCategory FROM semiboard WHERE postCategory='소통')
			WHERE rnum between 1 and 2
			
			
			