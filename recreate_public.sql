-- DROP SCHEMA public;

CREATE SCHEMA public AUTHORIZATION postgres;

COMMENT ON SCHEMA public IS 'standard public schema';

-- public.questions definition

-- Drop table

-- DROP TABLE public.questions;

CREATE TABLE public.questions (
	id serial NOT NULL,
	question varchar NULL,
	answerlist varchar NULL,
	correctanswer varchar NULL,
	difficulty int4 NULL,
	topic varchar NULL,
	CONSTRAINT questions_pkey PRIMARY KEY (id)
);

-- public.quizzes definition

-- Drop table

-- DROP TABLE public.quizzes;

CREATE TABLE public.quizzes (
	id serial NOT NULL,
	quizlength int4 NULL,
	startingdifficulty int4 NULL,
	topic varchar NULL,
	CONSTRAINT quizzes_pkey PRIMARY KEY (id)
);

-- public.surveys definition

-- Drop table

-- DROP TABLE public.surveys;

CREATE TABLE public.surveys (
	id serial NOT NULL,
	quizid int4 NULL,
	studentid int4 NULL,
	surveyinputfield varchar NULL,
	CONSTRAINT surveys_pkey PRIMARY KEY (id)
);

-- public.test definition

-- Drop table

-- DROP TABLE public.test;

CREATE TABLE public.test (
	id serial NOT NULL,
	n varchar NULL,
	CONSTRAINT test_pkey PRIMARY KEY (id)
);

-- public.users definition

-- Drop table

-- DROP TABLE public.users;

CREATE TABLE public.users (
	id int4 NOT NULL,
	username varchar NOT NULL,
	userpassword varchar NOT NULL,
	userrole varchar NULL,
	CONSTRAINT users_pkey PRIMARY KEY (id),
	CONSTRAINT users_username_key UNIQUE (username)
);

CREATE OR REPLACE FUNCTION public.users_id_auto_increment()
 RETURNS trigger
 LANGUAGE plpgsql
AS $function$
begin
new.id = nextval('Users_id_seq'); 
return new; --For inserts and updates, the return type should be "new".
end;
$function$
;

-- DROP TRIGGER users_id_trigger ON public.users;

CREATE TRIGGER users_id_trigger BEFORE
INSERT
    ON
    public.users FOR EACH ROW EXECUTE PROCEDURE users_id_auto_increment();

DROP SEQUENCE public.users_id_seq;
   
CREATE SEQUENCE public.users_id_seq
	INCREMENT BY 1
	NO MINVALUE
	MAXVALUE 9223372036854775807
	START 4
	CACHE 1
	NO CYCLE;
