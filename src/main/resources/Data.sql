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

insert into course(id,name)values(1,'chemistry');
insert into course(id,name)values(2,'physics');
insert into course(id,name)values(3,'maths');
insert into course(id,name)values(4,'biology');
insert into course(id,name)values(5,'english');