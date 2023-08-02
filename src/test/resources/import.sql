INSERT INTO users (name, role) VALUES('Pere', 0);
INSERT INTO users (name, role) VALUES('David', 1);
INSERT INTO users (name, role) VALUES('Oscar', 1);
INSERT INTO forms (question) VALUES('What is your favorite position?');
INSERT INTO forms (question) VALUES('Are you right hand or left hand?');
INSERT INTO answers (answer, question, user_id) VALUES('Right','What is your favorite position?', 1);
INSERT INTO answers (answer, question, user_id) VALUES('Left','Are you right hand or left hand?', 1);