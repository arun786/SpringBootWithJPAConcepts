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