#Lis�t��n kysely 'Luminen kysely'
#ja siihen kysymykset:
#'Onnistuiko transaction?' ja 'Viel�k� toimii?'
START TRANSACTION;
SET autocommit=0;
INSERT INTO Enquiries (description)
	VALUES ('Luminen kysely');
SET @enquiryID = LAST_INSERT_ID();
INSERT INTO Query (question)
	VALUES ('Onnistuiko transaction?');
SET @queryID = LAST_INSERT_ID();
INSERT INTO Queries (enquiry_id, query_id)
	VALUES (@enquiryID, @queryID);
INSERT INTO Query (question)
	VALUES ('Viel�k� toimii?');
SET @queryID = LAST_INSERT_ID();
INSERT INTO Queries (enquiry_id, query_id)
	VALUES (@enquiryID, @queryID);
COMMIT;
