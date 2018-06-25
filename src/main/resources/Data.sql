--create table student
--(
--id integer not null,
--name varchar(10) not null,
--standard varchar(10) not null,
--location varchar(10) not null,
--date_of_admission date,
--primary key(id)
--);

insert into student(id, name, standard, location, date_of_admission)values(1,'arun','10','shillong',sysdate);
insert into student(id, name, standard, location, date_of_admission)values(2,'adwiti','1','shillong',sysdate);
insert into student(id, name, standard, location, date_of_admission)values(3,'pushpa','4','shillong',sysdate);

insert into course(id,name,last_updated_timestamp,create_timestamp)values(1,'chemistry',sysdate,sysdate);
insert into course(id,name,last_updated_timestamp,create_timestamp)values(2,'physics',sysdate,sysdate);
insert into course(id,name,last_updated_timestamp,create_timestamp)values(3,'maths',sysdate,sysdate);
insert into course(id,name,last_updated_timestamp,create_timestamp)values(4,'biology',sysdate,sysdate);
insert into course(id,name,last_updated_timestamp,create_timestamp)values(5,'english',sysdate,sysdate);


insert into subject(id,name,author)values(1,'As the crow flies', 'Jeffrey Archer');
insert into subject(id,name,author)values(2,'Prodigal Daughter', 'Jeffrey Archer');
insert into subject(id,name,author)values(3,'Da Vinci Code', 'Dan Brown');

insert into college(id,name,address,ranking,create_time_Stamp,update_Time_Stamp)values(1,'St. Mary','Mumbai',109,sysdate,sysdate);
insert into college(id,name,address,ranking,create_Time_Stamp,update_Time_Stamp)values(2,'St. Anthonys','Shillong',23,sysdate,sysdate);
insert into college(id,name,address,ranking,create_Time_Stamp,update_Time_Stamp)values(3,'St. Edmunds','Shillong',25,sysdate,sysdate);

insert into company(id,name)values(10001,'tcs');
insert into company(id,name)values(10002,'infosys');
insert into company(id,name)values(10003,'ibm');
insert into company(id,name)values(10004,'intraedge');

insert into passport(id,number)values(30001,'P001');
insert into passport(id,number)values(30002,'P002');
insert into passport(id,number)values(30003,'P003');

insert into employee(id,name,passport_id)values(20001,'arun',30001);
insert into employee(id,name,passport_id)values(20002,'adwiti',30002);
insert into employee(id,name,passport_id)values(20003,'pushpa',30003);



insert into review(id,rating,description)values(40001,'1','Best');
insert into review(id,rating,description)values(40002,'1','Good');
insert into review(id,rating,description)values(40003,'1','Ok');

