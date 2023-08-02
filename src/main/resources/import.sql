INSERT INTO users (name) VALUES('Pere');
INSERT INTO users (name) VALUES('David');
INSERT INTO users (name) VALUES('Oscar');
INSERT INTO forms (question, user_id) VALUES('What is your favorite position?', 1);
INSERT INTO forms (question, user_id) VALUES('Are you right hand or left hand?', 1);
INSERT INTO answers (answer_question, question, user_id) VALUES('Right','What is your favorite position?', 1);
INSERT INTO answers (answer_question, question, user_id) VALUES('Left','Are you right hand or left hand?', 1);