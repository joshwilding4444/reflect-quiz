INSERT INTO questions(id, question, answerlist, correctanswer, difficulty, topic)
VALUES(DEFAULT, 'What is 2+2?', ' @: 3 @: 4 @: 1 @: 7', 'B', 1, 'MATH'),
(DEFAULT, 'What is 2+2?', ' @:3 @:4 @:1 @:7', 'B', 1, 'MATH'),
(DEFAULT, 'What is 1+6?', ' @:3 @:4 @:1 @:7', 'D', 1, 'MATH'),
(DEFAULT, 'What is 1+2?', ' @:3 @:4 @:1 @:7', 'A', 1, 'MATH'),
(DEFAULT, 'What is 10+4?', ' @:3 @:4 @:14 @:7', 'C', 2, 'MATH'),
(DEFAULT, 'What is 19-7?', ' @:0 @:11 @:4 @:12', 'D', 2, 'MATH'),
(DEFAULT, 'What is 13-4?', ' @:9 @:4 @:1 @:7', 'A', 2, 'MATH'),
(DEFAULT, 'What is 7x3?', ' @:44 @:30 @:21 @:17', 'C', 3, 'MATH'),
(DEFAULT, 'What is 12x12?', ' @:144 @:30 @:121 @:170', 'A', 3, 'MATH'),
(DEFAULT, 'What is 5x0?', ' @:44 @:0 @:21 @:1', 'B', 3, 'MATH'),
(DEFAULT, 'What is the capital of Utah?', ' @:Salt Lake City @:Des Moines @:Chicago @:Dallas', 'A', 1, 'GEOGRAPHY'),
(DEFAULT, 'What is the capital of Arizona?', ' @:Salt Lake City @:Phoenix @:Chicago @:Dallas', 'B', 1, 'GEOGRAPHY'),
(DEFAULT, 'What is the capital of Iowa?', ' @:Salt Lake City @:Des Moines @:Chicago @:Dallas', 'B', 1, 'GEOGRAPHY'),
(DEFAULT, 'What is the capital of Illinois?', ' @:Salt Lake City @:Des Moines @:Chicago @:Dallas', 'D', 2, 'GEOGRAPHY'),
(DEFAULT, 'How many States does the US have?', ' @:3 @:1 @:100 @:50', 'D', 2, 'GEOGRAPHY'),
(DEFAULT, 'What country borders the US on the north?', ' @:Cuba @:Canada @:Mexico @:China', 'B', 2, 'GEOGRAPHY'),
(DEFAULT, 'Which of the following is NOT a state?', ' @:Virginia @:Nebraska @:Kansas @:Puerto Rico', 'D', 3, 'GEOGRAPHY'),
(DEFAULT, 'Puerto Rico is a ...?', ' @:State @:Territory @:Commonwealth @:Sovereign Nation', 'C', 3, 'GEOGRAPHY'),
(DEFAULT, 'Which of the following is part of the continental US?', ' @:California @:Alaska @:Hawaii @:Puerto Rico', 'A', 3, 'GEOGRAPHY');
(DEFAULT, 'Which is spelled correctly?', '@:hus @:howse @:house @:hous', 'C', 1, 'ENGLISH'),
(DEFAULT, 'Which is spelled correctly?', '@:rais @:ris @:rce @:rice', 'C', 1, 'ENGLISH'),
(DEFAULT, 'Which is a noun?', '@:rice @:run @:jump @:fly', 'A', 2, 'ENGLISH'),
(DEFAULT, 'Which is a verb?', '@:pizza @:cook @:hat @:jar', 'B', 2, 'ENGLISH'),
(DEFAULT, 'Which of these is an insect?', '@:centipede @:crab @:ladybug @:spider', 'C', 2, 'SCIENCE'),
(DEFAULT, 'Which of these is an element?', '@:water @:wood @:air @:Oxygen', 'D', 2, 'SCIENCE');




INSERT INTO quizzes(id, quizlength, startingdifficulty, topic )
VALUES(DEFAULT, 4, 1, 'MATH'),
(DEFAULT, 6, 1, 'GEOGRAPHY'),
(DEFAULT, 3, 1, 'ENGLISH'),
(DEFAULT, 5, 1, 'SCIENCE');


INSERT INTO surveys(id, quizid, studentid, surveyinputfield )
VALUES(DEFAULT, , , '');

INSERT INTO public.users(id, username, userpassword, userrole)
-- VALUES(DEFAULT, 'dipperpines', 'journal', 'STUDENT'),
VALUES(DEFAULT, 'dipperpines', 'journal', 'STUDENT'),
(DEFAULT, 'maybelpines', 'smiledip', 'STUDENT'),
(DEFAULT, 'billcipher', 'triangle', 'TEACHER'),
(DEFAULT, 'mcgucket', 'hillbilly', 'TEACHER'),
(DEFAULT, 'wendy', 'redhead', 'STUDENT'),
(DEFAULT, 'robbie', 'darkness', 'STUDENT');
