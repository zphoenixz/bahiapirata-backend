INSERT INTO "user"
    ( user_id, username, password, email, phone_number,
    cat_user_status, status, tx_id, tx_username, tx_host,
    tx_date)
VALUES
    (  nextval('user_user_id_seq') , 'mgomez', '6b9ffd71631dd64e1231ef41e138cd29b933c687073c1f72a66571998d9bd2a3', 'mgomez@gmail.com', '70655567',
        'ACTIVE', 1, 1, 'root', '127.0.0.1',
        now()
    );

INSERT INTO "user"
    ( user_id, username, password, email, phone_number,
    cat_user_status, status, tx_id, tx_username, tx_host,
    tx_date)
VALUES
    (  nextval('user_user_id_seq') , 'jramiro', '6b9ffd71631dd64e1231ef41e138cd29b933c687073c1f72a66571998d9bd2a3', 'mgomez@gmail.com', '70655567',
        'ACTIVE', 1, 1, 'root', '127.0.0.1',
        now()
    );

INSERT INTO "user"
( user_id, username, password, email, phone_number,
  cat_user_status, status, tx_id, tx_username, tx_host,
  tx_date)
VALUES
(  nextval('user_user_id_seq') , 'jperez', '6b9ffd71631dd64e1231ef41e138cd29b933c687073c1f72a66571998d9bd2a3', 'jperez@gmail.com', '70655570',
   'ACTIVE', 1, 1, 'root', '127.0.0.1',
   now()
);

INSERT INTO "user"
( user_id, username, password, email, phone_number,
  cat_user_status, status, tx_id, tx_username, tx_host,
  tx_date)
VALUES
(  nextval('user_user_id_seq') , 'jjoan', '12345678', 'jjoan@gmail.com', '70655567',
   'ACTIVE', 1, 1, 'root', 'localhost',
   now()
);

INSERT INTO "user"
( user_id, username, password, email, phone_number,
  cat_user_status, status, tx_id, tx_username, tx_host,
  tx_date)
VALUES
(  nextval('user_user_id_seq') , 'amedina', '12345678', 'amedina@gmail.com', '70655567',
   'ACTIVE', 1, 1, 'root', 'localhost',
   now()
);

INSERT INTO "user"
( user_id, username, password, email, phone_number,
  cat_user_status, status, tx_id, tx_username, tx_host,
  tx_date)
VALUES
(  nextval('user_user_id_seq') , 'amaria', '12345678', 'amaria@gmail.com', '70655567',
   'ACTIVE', 1, 1, 'root', 'localhost',
   now()
);

INSERT INTO feature (feature_code, feature_name, status, tx_id, tx_username, tx_host, tx_date)
VALUES ('PAGE_USER_MANAGEMENT', 'Gestión de usuarios', 1, 1, 'admin', 'localhost', now());
/* PAGE_USER_MANAGEMENT */
INSERT INTO feature (feature_code, feature_name, status, tx_id, tx_username, tx_host, tx_date)
VALUES ('PAGE_ORDER_MANAGEMENT', 'Gestión de ordenes', 1, 1, 'admin', 'localhost', now());
/* PAGE_PRODUCT_MANAGEMENT */
INSERT INTO feature (feature_code, feature_name, status, tx_id, tx_username, tx_host, tx_date)
VALUES ('BUTTON_DELETE_ORDER', 'Botón para eliminar una orden', 1, 1, 'admin', 'localhost', now());
/* BUTTON_DELETE_USER */
INSERT INTO role ( role_name, status, tx_id, tx_username, tx_host, tx_date)
VALUES ('ADMIN', 1,  1, 'admin', 'localhost', now());

INSERT INTO role ( role_name, status, tx_id, tx_username, tx_host, tx_date)
VALUES ('WAREHOUSE_SUPERVISOR', 1,  1, 'admin', 'localhost', now());

INSERT INTO role ( role_name, status, tx_id, tx_username, tx_host, tx_date)
VALUES ('WAREHOUSE_EMPLOYEE', 1,  1, 'admin', 'localhost', now());

-- ADMIN role
INSERT INTO role_feature ( role_id, feature_id, status, tx_id, tx_username, tx_host, tx_date)
VALUES (1, 1, 1,  1, 'admin', 'localhost', now());

INSERT INTO role_feature ( role_id, feature_id, status, tx_id, tx_username, tx_host, tx_date)
VALUES (1, 2, 1,  1, 'admin', 'localhost', now());

INSERT INTO role_feature ( role_id, feature_id, status, tx_id, tx_username, tx_host, tx_date)
VALUES (1, 3, 1,  1, 'admin', 'localhost', now());

-- WAREHOUSE_SUPERVISOR
INSERT INTO role_feature ( role_id, feature_id, status, tx_id, tx_username, tx_host, tx_date)
VALUES (2, 2, 1,  1, 'admin', 'localhost', now());

INSERT INTO role_feature ( role_id, feature_id, status, tx_id, tx_username, tx_host, tx_date)
VALUES (2, 3, 1,  1, 'admin', 'localhost', now());

-- WAREHOUSE_EMPLOY
INSERT INTO role_feature ( role_id, feature_id, status, tx_id, tx_username, tx_host, tx_date)
VALUES (3, 2, 1,  1, 'admin', 'localhost', now());

-- CONFIGURACIÓN DE USUARIOS

INSERT INTO user_role ( user_id, role_id, status, tx_id, tx_username, tx_host, tx_date)
VALUES (1, 1, 1,  1, 'admin', 'localhost', now());

INSERT INTO user_role ( user_id, role_id, status, tx_id, tx_username, tx_host, tx_date)
VALUES (2, 2, 1,  1, 'admin', 'localhost', now());

INSERT INTO user_role ( user_id, role_id, status, tx_id, tx_username, tx_host, tx_date)
VALUES (3, 3, 1,  1, 'admin', 'localhost', now());


SELECT
    DISTINCT fea.feature_code
FROM
    "user" usr
    JOIN user_role uro ON usr.user_id = uro.user_id
    JOIN "role" rle ON rle.role_id = uro.role_id
    JOIN role_feature rfe ON rfe.role_id = rle.role_id
    JOIN feature fea ON fea.feature_id = rfe.feature_id
WHERE
    usr.user_id = 1
    AND usr.status = 1
    AND uro.status = 1
    AND rle.status = 1
    AND rfe.status = 1
    AND fea.status = 1;

