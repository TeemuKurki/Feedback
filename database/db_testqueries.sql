#Tables:
#Enquiries, Query, Answer, Queries, Answers

#Hae kyselyt
SELECT * FROM Enquiries;

#Hae kyselyn 1 kysymykset
SELECT question FROM Query 
INNER JOIN Queries 
	ON Query.id = Queries.query_id 
WHERE enquery_id = 1;

#Hae kysymyksen 1 vastaukset
SELECT answer FROM Answer 
INNER JOIN Answers 
	ON Answer.id = Answers.answer_id
INNER JOIN Query
	ON query_id = Query.id
WHERE Query.id = 1;
	
#Hae kyselyn 1 kysymys 2
SELECT description, question FROM Query
INNER JOIN Queries
	ON Query.id = query_id
INNER JOIN Enquiries
	ON Enquiries.id = Queries.enquery_id
WHERE Enquiries.id = 1
	AND Query.id = 2;

#Hae kyselyn 1 kysymys 1 vastaus 1
SELECT answer FROM Answer
INNER JOIN Answers
	ON Answer.id = Answers.answer_id
INNER JOIN Query
	ON Query.id = Answers.query_id
INNER JOIN Queries
	ON Queries.query_id = Query.id
INNER JOIN Enquiries
	ON Enquiries.id = Queries.enquery_id
WHERE Enquiries.id = 1
	AND Query.id = 1
	AND Answer.id = 1;
