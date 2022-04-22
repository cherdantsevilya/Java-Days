INSERT INTO "User" (login, password) VALUES ('Tom', '12345');
INSERT INTO "User" (login, password) VALUES ('Jerry', '0000');
INSERT INTO "User" (login, password) VALUES ('Kevin', '1111');
INSERT INTO "User" (login, password) VALUES ('Bob', '5555');
INSERT INTO "User" (login, password) VALUES ('Alex', '10101');

INSERT INTO "Chatroom" (name, owner) VALUES ('general', '1');
INSERT INTO "Chatroom" (name, owner) VALUES ('internship', '2');
INSERT INTO "Chatroom" (name, owner) VALUES ('random', '3');
INSERT INTO "Chatroom" (name, owner) VALUES ('announcements', '4');
INSERT INTO "Chatroom" (name, owner) VALUES ('april2021', '5');

INSERT INTO "Message" (author, room, text, localdatetime) VALUES ('1', '1', 'hello general!', '[2022-04-22 11:46:14]');
INSERT INTO "Message" (author, room, text, localdatetime) VALUES ('2', '2', 'hello internship!', '[2022-04-22 11:46:14]');
INSERT INTO "Message" (author, room, text, localdatetime) VALUES ('3', '3', 'hello random!', '[2022-04-22 11:46:14]');
INSERT INTO "Message" (author, room, text, localdatetime) VALUES ('4', '4', 'hello announcements!', '[2022-04-22 11:46:14]');
INSERT INTO "Message" (author, room, text, localdatetime) VALUES ('5', '5', 'hello april2021!', '[2022-04-22 11:46:14]');