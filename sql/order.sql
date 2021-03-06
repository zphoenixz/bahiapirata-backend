/* User 1 es ADMIN con BUTTON_DELETE_ORDER, PAGE_ORDER_MANAGEMENT y PAGE_USER_MANAGEMENT */
/* User 2 es WAREHOUSE_SUPERVISOR con BUTTON_DELETE_ORDER y PAGE_ORDER_MANAGEMENT */
/* User 3 es WAREHOUSE_EMPLOYEE con PAGE_ORDER_MANAGEMENT */


/*Usuarios 4 5 y 6 son clientes*/

/*Usuarios 4 tiene la orden 1 con productos 1, 2, 3*/
/*Usuarios 5 tiene la orden 2 con productos 4, 5, 6*/
/*Usuarios 5 tiene la orden 3 con productos 1*/
/*Usuarios 6 tiene la orden 4 con productos 1*/
/*Usuarios 7 tiene la orden 5 con productos 1*/


/*
 sobre el estado del pediodo preguntar, si puedo aumentar una columna de estado
 o al menos :::::
 aumentar a la tabla orden un, shipped date, received date
*/
INSERT INTO "order"
(provider_id, warehouse_id, order_user_id, order_date, order_status, status, address, tx_id, tx_username, tx_host,
 tx_date) VALUES
(1, 1, 4, now(),'paid',1, 'Calacoto calle 5, Edificio Gloria, piso 5, apt 4', 1,
 'root', 'localhost', now());

INSERT INTO "order"
(provider_id, warehouse_id, order_user_id, order_date, order_status, status, address, tx_id, tx_username, tx_host,
 tx_date) VALUES
(1, 1, 5, now(),'paid',1, 'Sopocachi, 6 de agosto, nro 4234', 1,
 'root', 'localhost', now());

INSERT INTO "order"
(provider_id, warehouse_id, order_user_id, order_date, order_status, status, address, tx_id, tx_username, tx_host,
 tx_date) VALUES
(1, 1, 5, now(), 'paid',1, 'Sopocachi, 6 de agosto, nro 4234', 1,
 'root', 'localhost', now());

INSERT INTO "order"
(provider_id, warehouse_id, order_user_id, order_date, order_status, status, address, tx_id, tx_username, tx_host,
 tx_date) VALUES
(1, 1, 6, now(), 'paid',1, 'Sopocachi, 6 de agosto, nro 4234', 1,
 'root', 'localhost', now());

INSERT INTO "order"
(provider_id, warehouse_id, order_user_id, order_date, order_status, status, address, tx_id, tx_username, tx_host,
 tx_date) VALUES
(1, 1, 7, now(), 'paid',1, 'Sopocachi, 6 de agosto, nro 4234', 1,
 'root', 'localhost', now());

INSERT INTO "product_order"
(order_id, product_id, unit_price, qtty_requested, status, tx_id, tx_username, tx_host,
 tx_date) VALUES
(1, 1, 5, 1, 1, 1,
 'root', 'localhost', now());

INSERT INTO "product_order"
(order_id, product_id, unit_price, qtty_requested, status, tx_id, tx_username, tx_host,
 tx_date) VALUES
(1, 2, 6, 2, 1, 1,
 'root', 'localhost', now());

INSERT INTO "product_order"
(order_id, product_id, unit_price, qtty_requested, status, tx_id, tx_username, tx_host,
 tx_date) VALUES
(1, 3, 7, 1, 1, 1,
 'root', 'localhost', now());

INSERT INTO "product_order"
(order_id, product_id, unit_price, qtty_requested, status, tx_id, tx_username, tx_host,
 tx_date) VALUES
(2, 4, 5, 1, 1, 1,
 'root', 'localhost', now());

INSERT INTO "product_order"
(order_id, product_id, unit_price, qtty_requested, status, tx_id, tx_username, tx_host,
 tx_date) VALUES
(2, 5, 6, 2, 1, 1,
 'root', 'localhost', now());

INSERT INTO "product_order"
(order_id, product_id, unit_price, qtty_requested, status, tx_id, tx_username, tx_host,
 tx_date) VALUES
(2, 6, 7, 3, 1, 1,
 'root', 'localhost', now());

INSERT INTO "product_order"
(order_id, product_id, unit_price, qtty_requested, status, tx_id, tx_username, tx_host,
 tx_date) VALUES
(3, 1, 7, 1, 1, 1,
 'root', 'localhost', now());

INSERT INTO "product_order"
(order_id, product_id, unit_price, qtty_requested, status, tx_id, tx_username, tx_host,
 tx_date) VALUES
(4, 1, 7, 1, 1, 1,
 'root', 'localhost', now());

INSERT INTO "product_order"
(order_id, product_id, unit_price, qtty_requested, status, tx_id, tx_username, tx_host,
 tx_date) VALUES
(5, 1, 7, 1, 1, 1,
 'root', 'localhost', now());

SELECT order_id, provider_id, warehouse_id, order_user_id, order_date FROM "order" WHERE status = 1;

SELECT ord.order_id, ord.warehouse_id, ord.date,
       usr.user_id, usr.username, usr.email, usr.phone_number, usr.cat_user_status,
        prov.provider_id, prov.provider_name, prov.cat_country
FROM "order" ord
JOIN "user" usr ON ord.order_user_id = usr.user_id
JOIN "provider" prov ON ord.provider_id = prov.provider_id
WHERE
    usr.status =  1
     AND ord.status = 1
     AND prov.status = 1;


SELECT ord.order_id, ord.warehouse_id, ord.date,
	   usr.user_id, usr.username, usr.email, usr.phone_number, usr.cat_user_status,
	   prov.provider_id, prov.provider_name, prov.cat_country
FROM "order" ord
		 JOIN "user" usr ON ord.order_user_id = usr.user_id
		 JOIN "provider" prov ON ord.provider_id = prov.provider_id
WHERE
		ord.order_id = 1
	AND usr.status =  1
	 AND ord.status = 1
	 AND prov.status = 1;

SELECT pord.provider_product_id, pord.order_id,
       prod.product_id, prod.product_code, prod.cat_product_type, prod.product_name, prod.product_description, prod.product_attributes,
       pord.unit_price, pord.qtty_requested, pord.qtty_commit, pord.qtty_received
FROM "product_order" pord
         JOIN "order" ord ON ord.order_id = pord.order_id
         JOIN "product" prod ON pord.product_id = prod.product_id
WHERE
    pord.order_id = 1
  AND pord.status =  1
  AND ord.status = 1
  AND prod.status = 1;

/*int productOrderId, int qttyCommit, int qttyReceived, int idUsuario*/
UPDATE "product_order"
SET    qtty_commit = 1,
        qtty_received = 1,
        tx_id = usr.user_id,
        tx_username = usr.username,
        tx_host = 'local',
        tx_date = now()
FROM  "user" usr
WHERE provider_product_id = 7
    AND usr.user_id = 1
RETURNING *;

UPDATE "order" ord
SET    order_status = 'prepared',
       prepared_date = now(),
       shipped_date = null,
       delivered_date = null,
       tx_id = usr.user_id,
       tx_username = usr.username,
       tx_host = 'local',
       tx_date = now()
FROM  "user" usr
WHERE order_id = 1
  AND usr.user_id = 2
RETURNING *;

UPDATE "order" ord
SET    order_status = 'prepared',
       tx_id = usr.user_id,
       tx_username = usr.username,
       tx_host = 'local',
       tx_date = now()
FROM  "user" usr
WHERE order_id = 1
  AND usr.user_id = 2
  AND ord.status = 1
RETURNING *;

UPDATE "order" ord
SET    status = 0,
       tx_id = usr.user_id,
       tx_username = usr.username,
       tx_host = 'local',
       tx_date = now()
FROM  "user" usr
WHERE order_id = 1
  AND usr.user_id = 2
  AND ord.status = 1
  AND usr.status = 1
RETURNING *;

select * from "order";
select * from "product_order";