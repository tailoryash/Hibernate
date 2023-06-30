--Course data
insert into course(id, name,  created_date, last_updated_date)
values(10001, 'JPA in 50steps', CURRENT_TIMESTAMP,CURRENT_TIMESTAMP );
insert into course(id, name,  created_date, last_updated_date)
values(10002, 'Cloud in 50steps', CURRENT_TIMESTAMP,CURRENT_TIMESTAMP );
insert into course(id, name,  created_date, last_updated_date)
values(10003, 'Docker in 50steps', CURRENT_TIMESTAMP,CURRENT_TIMESTAMP );


--Passport data
insert into passport(id, number)
values(40001, 'E1234D');
insert into passport(id, number)
values(40002, 'N123334D');
insert into passport(id, number)
values(40003, 'ED12f34D');

--Student data
insert into student(id, name, passport_id)
values(20001, 'Yash', 40001);
insert into student(id, name, passport_id)
values(20002, 'Hardeek', 40002);
insert into student(id, name,passport_id)
values(20003, 'Mihir', 40003);


--Review data
insert into review(id, rating, description, course_id)
values(50001, '5', 'Great course', 10001);
insert into review(id, rating, description, course_id)
values(50002, '5', 'Wonderful course', 10003);
insert into review(id, rating, description, course_id)
values(50003, '5', 'Excellent course', 10002);