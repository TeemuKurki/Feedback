INSERT INTO Enquiries (description)
VALUES ("Testikysely");

INSERT INTO Enquiries (description)
VALUES ("Toinen testikysely");

INSERT INTO Query (question)
VALUES ("Onko Lorem ipsun hyvä?");

INSERT INTO Query (question)
VALUES ("Onko hyvä päivä?");

INSERT INTO Query (question)
VALUES ("Voittaako suomi?");

INSERT INTO Query (question)
VALUES ("Tavataanko torilla?");

INSERT INTO Answer (answer)
VALUES ("On, on se hyvä!");

INSERT INTO Answer (answer)
VALUES ("Itse en ole fani...");

INSERT INTO Answer (answer)
VALUES ("Kyllä");

INSERT INTO Answer (answer)
VALUES ("Aina on hyvä päivä. Ja joulu xdd");

INSERT INTO Queries (enquiry_id, query_id)
VALUES (1,1);

INSERT INTO Queries (enquiry_id, query_id)
VALUES (1,2);

INSERT INTO Queries (enquiry_id, query_id)
VALUES (2,3);

INSERT INTO Queries (enquiry_id, query_id)
VALUES (2,4);

INSERT INTO Answers (query_id, answer_id)
VALUES (1,1);

INSERT INTO Answers (query_id, answer_id)
VALUES (1,2);

INSERT INTO Answers (query_id, answer_id)
VALUES (2,3);

INSERT INTO Answers (query_id, answer_id)
VALUES (2,4);