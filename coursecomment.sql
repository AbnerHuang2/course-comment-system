create database coursecomment;
use coursecomment;
/*学生表*/
create table student (
s_id varchar(10) primary key ,
s_password varchar(40) not null,
s_name varchar(20) not null,
s_headImg varchar(30) ,
s_class varchar(10) ,
s_school varchar(20) ,
s_phone varchar(11) ,
s_email varchar(25)
)

insert into student values('16204101',md5('123'),'Agnes','images/headImg/1.jpg','162041','南昌航空大学','110','110@qq.com');
update student set s_password=md5('123') where s_id='16204101';
insert into student values('16204102',md5('123'),'cherry','images/headImg/2.jpg','162041','南昌航空大学','112','112@qq.com');

select * from student;

/*老师表*/
create table teacher(
t_id varchar(10) primary key,
t_password varchar(30) not null,
t_name varchar(20) ,
t_gz varchar(10) 
)

insert into teacher values('9901','123','徐佳莹','教授');
insert into teacher values('9902','123','Maner','教授');
insert into teacher values('9903','123','田馥甄','讲师');
insert into teacher values('9904','123','马云','讲师');

select * from teacher;

/*课程表*/
create table course(
c_id varchar(10) primary key ,
c_name varchar(20) not null,
c_time int not null,	/*所占课时*/
c_score int not null,	/*所占学分*/
cjbz varchar(10) ,		/*成绩比重*/
s_description varchar(50),	/*试卷描述*/
w_description varchar(50)	/*问卷描述*/
)

alter table course add pj_description varchar(255) ;	/*评价大纲*/
alter table course modify s_description varchar(255);
alter table course modify w_description varchar(255);

desc course;

insert into course values('3001','Java网络编程',64,3,'50%','test3001','question3001');
insert into course values('3002','Oracle',64,2,'60%','test3002','question3002');
insert into course values('3003','web高级编程',64,4,'50%','test3003','question3003');
insert into course values('3004','项目管理',64,4,'50%','0','question3004');
insert into course values('3005','软件建模技术',64,4,'50%','test3005','question3005');
insert into course values('3006','就业指导',64,4,'50%','0','0');

select * from course;
desc course;


/*教师课程加督导评分表*/
create table teacher_course(
t_id varchar(10) references teacher(t_id),
c_id varchar(10) references course(c_id),
location varchar(20) ,
tc_time datetime ,
tc_pl varchar(20),
tc_score varchar(5) ,
evaluater varchar(10) references teacher(t_id),
primary key (t_id,c_id)
)

/*学生-课程表*/
create table student_course(
s_id varchar(10) references student(s_id),
c_id varchar(10) references course(c_id),
cq varchar(30) ,	/*出勤*/
score float ,
sj_details varchar(30) ,	/*试卷细节*/
primary key(s_id,c_id)
)
alter table student_course add t_id varchar(10) references teacher(t_id);

insert into student_course values('16204101','3001','100%',90,'选择题30,填空题20，表达题40','9901');
insert into student_course values('16204101','3002','100%',90,'选择题30,填空题20，表达题40','9902');
insert into student_course values('16204101','3003','100%',90,'选择题30,填空题20，表达题40','9903');
insert into student_course values('16204101','3005','100%',90,'选择题30,填空题20，表达题40','9904');

/*查询16204101选的课*/
select c.c_name,t.t_name,c.c_score,c.c_time,sc.score from student_course sc,course c,teacher t where c.c_id=sc.c_id and t.t_id=sc.t_id and s_id='16204101' ;

/*听课记录表*/
create table record(
r_id int auto_increment primary key,
t_id varchar(10) references teacher(t_id),
r_time datetime not null,
c_id varchar(10) references course(c_id),
r_feel varchar(100) not null
)

/*学生评价表*/
create table student_remark(
id int auto_increment primary key,
s_id varchar(10) references student(s_id),
c_id varchar(10) references course(c_id),
t_id varchar(10) references teacher(t_id),
content varchar(255) not null	/*评价内容*/
)
desc student_remark;

/*班级表*/
create table _class(
b_id varchar(10) primary key,
dept varchar(10) not null,
stu_num int 
)