INSERT INTO currency(id, "name") VALUES(1, 'SEK');
INSERT INTO currency(id, "name") VALUES(2, 'DKK');
INSERT INTO currency(id, "name") VALUES(3, 'USD');
INSERT INTO currency(id, "name") VALUES(4, 'GBP');
INSERT INTO currency(id, "name") VALUES(5, 'EUR');

INSERT INTO exchangerate(id, from_id, to_id, price) VALUES(1, 1, 2, 1.34);
INSERT INTO exchangerate(id, from_id, to_id, price) VALUES(2, 1, 3, 8.43);
INSERT INTO exchangerate(id, from_id, to_id, price) VALUES(3, 1, 4, 11.28);
INSERT INTO exchangerate(id, from_id, to_id, price) VALUES(4, 1, 5, 9.94);

INSERT INTO exchangerate(id, from_id, to_id, price) VALUES(5, 2, 1, 0.75);
INSERT INTO exchangerate(id, from_id, to_id, price) VALUES(6, 2, 3, 6.31);
INSERT INTO exchangerate(id, from_id, to_id, price) VALUES(7, 2, 4, 8.45);
INSERT INTO exchangerate(id, from_id, to_id, price) VALUES(8, 2, 5, 7.44);

INSERT INTO exchangerate(id, from_id, to_id, price) VALUES(9, 3, 5, 1.18);
INSERT INTO exchangerate(id, from_id, to_id, price) VALUES(10, 5, 3, 0.85);
