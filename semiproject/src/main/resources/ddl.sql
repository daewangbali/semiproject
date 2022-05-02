--create DB table

--먼저 회원 테이블 생성
CREATE TABLE SemiMEMBER(
	id VARCHAR2(100) PRIMARY KEY,
	name VARCHAR2(100) NOT NULL, 
	tel VARCHAR2(100) NOT NULL,
	KOSTANo VARCHAR2(100) NOT NULL,
	password VARCHAR2(100) NOT NULL
)

CREATE TABLE SemiBoard(
	postNo NUMBER PRIMARY KEY,
	postContent BLOB NOT NULL,
	postDate DATE NOT NULL,
	postCategory VARCHAR2(100) NOT NULL,
	postTitle VARCHAR2(100) NOT NULL,
	id VARCHAR2(100) NOT NULL,
	CONSTRAINT mySemiboard_fk FOREIGN KEY(id) REFERENCES SemiMEMBER(id)
)

CREATE TABLE SemiLike(
	id VARCHAR2(100),
	postNo NUMBER,
	CONSTRAINT mySemiLike_pk PRIMARY KEY(id, postNo),
	CONSTRAINT mySemiLike_fk1 FOREIGN KEY(id) REFERENCES SemiMEMBER(id),
	CONSTRAINT mySemiLike_fk2 FOREIGN KEY(postNo) REFERENCES SemiBoard(postNo)
)

--------
CREATE TABLE SemiFile(
	fileNo NUMBER,
	postNo NUMBER,
	originalName VARCHAR2(100) NOT NULL,
	savedName VARCHAR2(100) NOT NULL,
	path VARCHAR2(100) NOT NULL,
	size NUMBER NOT NULL,
	fileDate DATE NOT NULL,
	CONSTRAINT mySemiFile_pk PRIMARY KEY(fileNo, postNo),
	CONSTRAINT mySemiFile_fk FOREIGN KEY(postNo) REFERENCES SemiBoard(postNo)
)

---------
DROP TABLE SemiCOMMENT

CREATE TABLE SemiComment(
	commentNo NUMBER,
	postNo NUMBER,
	commentDate Date NOT NULL,
	commentContent BLOB NOT NULL,
	CONSTRAINT mySemiComment_pk PRIMARY KEY(commentNo, postNo),
	CONSTRAINT mySemiComment_fk FOREIGN KEY(postNo) REFERENCES SemiBoard(postNo)
)
