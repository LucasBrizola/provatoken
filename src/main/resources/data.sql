INSERT INTO PARENT (ID, NAME)
VALUES (1, 'John'),
       (2, 'Paul'),
       (3, 'Mary'),
       (4, 'Lucy'),
       (5, 'Mark');

INSERT INTO CHILD (ID, NAME, FATHER_ID, MOTHER_ID)
VALUES (1, 'John', 1, 3),
       (2, 'Paul', 1, 3),
       (3, 'Lucy', 2, 4),
       (4, 'Claire', 1, 4),
       (5, 'Simon', NULL, 4);