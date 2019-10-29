CREATE SEQUENCE ADDRESSES_ADDR_ID_SEQ;
CREATE SEQUENCE STUDENTS_STUD_ID_SEQ;
CREATE SEQUENCE TUTORS_TUTOR_ID_SEQ;
CREATE SEQUENCE COURSES_COURSE_ID_SEQ;
CREATE SEQUENCE COURSE_ENROLLMENT_COURSE_ID;
CREATE SEQUENCE USER_PICS_ID;


CREATE TABLE ADDRESSES 
(
  ADDR_ID NUMBER(11) NOT NULL,
  STREET VARCHAR2(50) NOT NULL,
  CITY VARCHAR2(50) NOT NULL,
  STATE VARCHAR2(50) NOT NULL,
  ZIP VARCHAR2(10) DEFAULT NULL,
  COUNTRY VARCHAR2(50) NOT NULL,
  PRIMARY KEY (ADDR_ID)
);
CREATE TABLE STUDENTS 
(
  STUD_ID NUMBER(11) NOT NULL,
  NAME VARCHAR2(50) NOT NULL,
  EMAIL VARCHAR2(50) NOT NULL,
  PHONE VARCHAR2(15) DEFAULT NULL,  
  DOB DATE DEFAULT NULL,
  BIO CLOB DEFAULT NULL,
  PIC BLOB DEFAULT NULL,
  ADDR_ID NUMBER(11) DEFAULT NULL, 
  PRIMARY KEY (STUD_ID),
  CONSTRAINT FK_STUDENTS_ADDR FOREIGN KEY (ADDR_ID) REFERENCES ADDRESSES (ADDR_ID)
);

CREATE TABLE TUTORS 
(
  TUTOR_ID NUMBER(11) NOT NULL,
  NAME VARCHAR2(50) NOT NULL,
  EMAIL VARCHAR2(50) NOT NULL,
  PHONE VARCHAR2(15) DEFAULT NULL,  
  DOB DATE DEFAULT NULL,
  BIO CLOB DEFAULT NULL,
  PIC BLOB DEFAULT NULL,
  ADDR_ID NUMBER(11) DEFAULT NULL,
  PRIMARY KEY (TUTOR_ID),
  CONSTRAINT FK_TUTORS_ADDR FOREIGN KEY (ADDR_ID) REFERENCES ADDRESSES (ADDR_ID)  
);


CREATE TABLE COURSES 
(
  COURSE_ID NUMBER(11) NOT NULL,
  NAME VARCHAR2(100) NOT NULL,
  DESCRIPTION VARCHAR2(512) DEFAULT NULL,
  START_DATE DATE DEFAULT NULL,
  END_DATE DATE DEFAULT NULL,
  TUTOR_ID NUMBER(11) NOT NULL,
  PRIMARY KEY (COURSE_ID),
  CONSTRAINT FK_COURSE_TUTOR FOREIGN KEY (TUTOR_ID) REFERENCES TUTORS (TUTOR_ID)
);


CREATE TABLE COURSE_ENROLLMENT
(
  COURSE_ID NUMBER(11) NOT NULL,
  STUD_ID NUMBER(11) NOT NULL,
  PRIMARY KEY (COURSE_ID,STUD_ID),
  CONSTRAINT FK_ENROLLMENT_STUD FOREIGN KEY (STUD_ID) REFERENCES STUDENTS (STUD_ID),
  CONSTRAINT FK_ENROLLMENT_COURSE FOREIGN KEY (COURSE_ID) REFERENCES COURSES (COURSE_ID)
);



CREATE TABLE USER_PICS 
(
  ID NUMBER(11) NOT NULL,
  NAME VARCHAR2(50) DEFAULT NULL,
  PIC BLOB,
  BIO CLOB,
  PRIMARY KEY (ID)
); 
