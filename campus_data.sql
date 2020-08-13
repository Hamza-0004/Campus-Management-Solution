CREATE DATABASE campus_data;

USE campus_data;

CREATE TABLE student
(
cmsID VARCHAR(11) PRIMARY KEY CHECK(char_length(cmsID)=11),
pass VARCHAR(20) NOT NULL,
stname VARCHAR(25) NOT NULL,
fname VARCHAR(25) NOT NULL,
department VARCHAR(50), 
degree VARCHAR(40),
address VARCHAR(50),
contact VARCHAR(13),
university VARCHAR(50),
photo BLOB
);

CREATE TABLE teacher
(
cmsID VARCHAR(11) PRIMARY KEY CHECK(char_length(cmsID)=11),
pass VARCHAR(20) NOT NULL,
tname VARCHAR(25) NOT NULL,
fname VARCHAR(25) NOT NULL,
department VARCHAR(50),
address VARCHAR(50),
contact VARCHAR(13),
university VARCHAR(50),
designation VARCHAR(25),
photo BLOB
);

CREATE TABLE course
(
cid VARCHAR(7) PRIMARY KEY CHECK(CHAR_LENGTH(cid)=7),
cname VARCHAR(40) NOT NULL
);

CREATE TABLE course_teacher
(
cid VARCHAR(15),
tid VARCHAR(11),
FOREIGN KEY(cid) REFERENCES course(cid) ON DELETE CASCADE,
FOREIGN KEY(tid) REFERENCES teacher(cmsID) ON DELETE CASCADE
);

CREATE TABLE student_course
(
sid VARCHAR(11),
cid VARCHAR(15),
FOREIGN KEY(cid) REFERENCES course(cid) ON DELETE CASCADE,
FOREIGN KEY(sid) REFERENCES student(cmsID) ON DELETE CASCADE
);

/*------------------temp----------------------*/
/*
INSERT INTO student(cmsID,pass,stname,fName,Department,Degree,Address,contact,university,photo) values('023-11-0011','asd','asdad','asda','asda','asda','asdad','qweq','yer4','fgdr4');
INSERT INTO course(cid,cname) values('023-111','WHAKSDKBSJHBFJHABJAH');
DELETE FROM COURSE WHERE CID = '023-111';
delete from student where cmsID = '023-11-0011';
select * from student;
select * from teacher;
select * from course;
select * from course_teacher;
select * from student_course;

select * from course_teacher;

select * from teacher inner join course_teacher ON cmsID = tid;

select count(*) from course_teacher where tid = "011-44-3340";

select cid from student_course where sid='053-18-0001';

update student set pass='1234' where cmsid='053-18-0001';

delete from teacher where cmsID = '000-00-0000';
*/