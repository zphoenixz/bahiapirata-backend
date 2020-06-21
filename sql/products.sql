INSERT INTO warehouse
( warehouse_id, warehouse_name, warehouse_address, latitude, longitude,
  status, tx_id, tx_username, tx_host, tx_date)
VALUES
(  nextval('warehouse_warehouse_id_seq') , 1, 'Calle 2, Obrajes', -16.5246707, -68.1115679,
    1, 1, 'admin', 'localhost', now()
);

INSERT INTO provider
( provider_id, provider_name, cat_country, status, tx_id,
  tx_username, tx_host, tx_date)
VALUES
(  nextval('provider_provider_id_seq') , 1, 'Bolivia', 1, 1,
   'admin', 'localhost', now()
);

INSERT INTO provider
( provider_id, provider_name, cat_country, status, tx_id,
  tx_username, tx_host, tx_date)
VALUES
(  nextval('provider_provider_id_seq') , 1, 'Peru', 1, 1,
   'admin', 'localhost', now()
);

INSERT INTO product
(product_code, cat_product_type, product_name,
 product_attributes, status, tx_id, tx_username, tx_host, tx_date)
 VALUES
 ('11aa', 'DVD', 'Independence Day',
  '{
    "es": "Dia de la Independencia",
    "lenght":145,
    "director": "Joss Whedon",
    "year": "1996",
    "starring":[
      "Will Smith",
      "Bill Pullman",
      "Jeff Goldblum"
    ]
    }',1, 1,
  'admin', 'localhost', now());

INSERT INTO product
(product_code, cat_product_type, product_name,
 product_attributes, status, tx_id, tx_username, tx_host, tx_date)
VALUES
('11aa', 'DVD', 'Independence Day',
 '{
   "es": "Dia de la Independencia",
   "lenght":145,
   "director": "Joss Whedon",
   "year": "1996",
   "starring":[
     "Will Smith",
     "Bill Pullman",
     "Jeff Goldblum"
   ]
 }',1, 1,
 'admin', 'localhost', now());
/*update product set product_code = '11bb' where product_id =1;*/

INSERT INTO product
(product_code, cat_product_type, product_name,
 product_attributes, status, tx_id, tx_username, tx_host, tx_date)
VALUES
('11cc', 'DVD', 'The Matrix Reloaded',
 '{
   "es": "Matrix recargado",
   "lenght":145,
   "director": "Lana Wachowski",
   "year": "1996",
   "starring":[
     "Keanu Reeves",
     "Laurence Fishburne",
     "Carrie-Anne Moss"
   ]
 }',1, 1,
 'admin', 'localhost', now());

INSERT INTO product
(product_code, cat_product_type, product_name,
 product_attributes, status, tx_id, tx_username, tx_host, tx_date)
VALUES
('11dd', 'DVD', 'As Good as It Gets',
 '{
   "es": "Tan bien como se ponga",
   "lenght":139,
   "director": "James L. Brooks",
   "year": "1997",
   "starring":[
     "Jack Nicholson",
     "Helen Hunt",
     "Greg Kinnear"
   ]
 }',1, 1,
 'admin', 'localhost', now());

INSERT INTO product
(product_code, cat_product_type, product_name,
 product_attributes, status, tx_id, tx_username, tx_host, tx_date)
VALUES
('11ee', 'DVD', '2001: A Space Odyssey',
 '{
   "es": "2001: Una odisea en el espacio",
   "lenght":149,
   "director": "Stanley Kubrick",
   "year": "1968",
   "starring":[
     "Keir Dullea",
     "Gary Lockwood",
     "William Sylvester"
   ]
 }',1, 1,
 'admin', 'localhost', now());

INSERT INTO product
(product_code, cat_product_type, product_name,
 product_attributes, status, tx_id, tx_username, tx_host, tx_date)
VALUES
('11ff', 'DVD', 'War of the Worlds',
 '{
   "es": "La guerra de los mundos",
   "lenght":116,
   "director": "Steven Spielberg",
   "year": "2005",
   "starring":[
     "Tom Cruise",
     "Dakota Fanning",
     "Tim Robbins"
   ]
 }',1, 1,
 'admin', 'localhost', now());

INSERT INTO product
(product_code, cat_product_type, product_name,
 product_attributes, status, tx_id, tx_username, tx_host, tx_date)
VALUES
('11ii', 'DVD', 'The Time Machine',
 '{
   "es": "La maquina del tiempo",
   "lenght":103,
   "director": "George Pal",
   "year": "2005",
   "starring":[
     "Rod Taylor",
     "Alan Young",
     "Yvette Mimieux"
   ]
 }',1, 1,
 'admin', 'localhost', now());

INSERT INTO product
(product_code, cat_product_type, product_name,
 product_attributes, status, tx_id, tx_username, tx_host, tx_date)
VALUES
('11jj', 'DVD', 'Star Wars: Episode IX - The Rise of Skywalker',
 '{
   "es": "Star Wars: Episode IX - El ascenso de los Skywalker",
   "lenght":144,
   "director": " J.J. Abrams",
   "year": "2019",
   "starring":[
     "Daisy Ridley",
     "John Boyega",
     "Oscar Isaac"
   ]
 }',1, 1,
 'admin', 'localhost', now());

