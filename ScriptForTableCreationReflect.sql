
create table Users (
	id INTEGER Primary key,
	username VARCHAR unique not null,
	userPassword VARCHAR not null,
	userRole VARCHAR
);

--sequence for id

create sequence Users_id_seq
increment by 1
minvalue 0
start with 1;


create or replace function Users_id_auto_increment()
returns trigger as
$$
begin
new.id = nextval('Users_id_seq'); 
return new; --For inserts and updates, the return type should be "new".
end;
$$
language 'plpgsql';

--trigger: 
create trigger Users_id_trigger before insert on public.Users for each row execute procedure Users_id_auto_increment();

create table Quizzes (
	id Serial Primary key,
	quizLength INTEGER,
	startingDifficulty INTEGER,
	topic VARCHAR
);

create table Questions (
	id Serial Primary key,
	question VARCHAR,
	answerList VARCHAR,
	correctAnswer VARCHAR,
	difficulty INTEGER,
	topic VARCHAR
);
