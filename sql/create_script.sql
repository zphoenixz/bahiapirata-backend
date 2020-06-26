-- Created by Vertabelo (http://vertabelo.com)
-- Last modification date: 2020-05-08 01:36:40.693

-- tables
-- Table: attribute
CREATE TABLE attribute (
    attribute_id serial  NOT NULL,
    product_id int  NOT NULL,
    attr_name varchar(30)  NOT NULL,
    attr_value varchar(200)  NOT NULL,
    attr_data_type varchar(100)  NOT NULL,
    status int  NOT NULL,
    tx_id int  NOT NULL,
    tx_username varchar(100)  NOT NULL,
    tx_host varchar(100)  NOT NULL,
    tx_date timestamp  NOT NULL,
    CONSTRAINT attribute_pk PRIMARY KEY (attribute_id)
);

-- Table: catalog
CREATE TABLE catalog (
    catalog_id serial  NOT NULL,
    catalog_name int  NOT NULL,
    catalog_description int  NOT NULL,
    status int  NOT NULL,
    tx_id int  NOT NULL,
    tx_username varchar(100)  NOT NULL,
    tx_host varchar(100)  NOT NULL,
    tx_date timestamp  NOT NULL,
    CONSTRAINT catalog_pk PRIMARY KEY (catalog_id)
);

-- Table: customer
CREATE TABLE customer (
    customer_id serial  NOT NULL,
    user_id int  NOT NULL,
    person_id int  NOT NULL,
    status int  NOT NULL,
    tx_id int  NOT NULL,
    tx_username varchar(100)  NOT NULL,
    tx_host varchar(100)  NOT NULL,
    tx_date timestamp  NOT NULL,
    CONSTRAINT customer_pk PRIMARY KEY (customer_id)
);

-- Table: employee
CREATE TABLE employee (
    employee_id serial  NOT NULL,
    user_id int  NOT NULL,
    person_person_id int  NOT NULL,
    status int  NOT NULL,
    tx_id int  NOT NULL,
    tx_username varchar(100)  NOT NULL,
    tx_host varchar(100)  NOT NULL,
    tx_date timestamp  NOT NULL,
    CONSTRAINT employee_pk PRIMARY KEY (employee_id)
);

-- Table: employee_wh
CREATE TABLE employee_wh (
    employe_wh_id serial  NOT NULL,
    warehouse_id int  NOT NULL,
    employee_id int  NOT NULL,
    status int  NOT NULL,
    tx_id int  NOT NULL,
    tx_username varchar(100)  NOT NULL,
    tx_host varchar(100)  NOT NULL,
    tx_date timestamp  NOT NULL,
    CONSTRAINT employee_wh_pk PRIMARY KEY (employe_wh_id)
);

-- Table: feature
CREATE TABLE feature (
    feature_id serial  NOT NULL,
    feature_code varchar(50)  NOT NULL,
    feature_name varchar(100)  NOT NULL,
    status int  NOT NULL,
    tx_id int  NOT NULL,
    tx_username varchar(100)  NOT NULL,
    tx_host varchar(100)  NOT NULL,
    tx_date timestamp  NOT NULL,
    CONSTRAINT feature_pk PRIMARY KEY (feature_id)
);

-- Table: inicial
CREATE TABLE inicial (
    _id serial  NOT NULL,
    status int  NOT NULL,
    tx_id int  NOT NULL,
    tx_username varchar(100)  NOT NULL,
    tx_host varchar(100)  NOT NULL,
    tx_date timestamp  NOT NULL,
    CONSTRAINT inicial_pk PRIMARY KEY (_id)
);

-- Table: item
CREATE TABLE item (
    item_id serial  NOT NULL,
    catalog_id int  NOT NULL,
    item_code varchar(30)  NOT NULL,
    item_name varchar(100)  NOT NULL,
    item_description text  NOT NULL,
    status int  NOT NULL,
    tx_id int  NOT NULL,
    tx_username varchar(100)  NOT NULL,
    tx_host varchar(100)  NOT NULL,
    tx_date timestamp  NOT NULL,
    CONSTRAINT item_pk PRIMARY KEY (item_id)
);

-- Table: order
CREATE TABLE "order" (
     order_id serial  NOT NULL,
     provider_id int  NOT NULL,
     warehouse_id int  NOT NULL,
     order_user_id int  NOT NULL,
     address varchar(100)  NOT NULL,
     order_date timestamp  NOT NULL,
     prepared_date timestamp NULL,
     shipped_date timestamp NULL,
     delivered_date timestamp NULL,
     order_status varchar(100) NOT NULL,
     status int  NOT NULL,
     tx_id int  NOT NULL,
     tx_username varchar(100)  NOT NULL,
     tx_host varchar(100)  NOT NULL,
     tx_date timestamp  NOT NULL,
     CONSTRAINT order_pk PRIMARY KEY (order_id)
);
-- Table: person
CREATE TABLE person (
    person_id serial  NOT NULL,
    first_name int  NOT NULL,
    second_name int  NULL,
    third_name int  NULL,
    first_surname int  NOT NULL,
    second_suname int  NULL,
    third_surname int  NULL,
    birthdate date  NULL,
    document_id varchar(100)  NOT NULL,
    document_expedition varchar(30)  NULL,
    cat_document_type varchar(30)  NULL,
    cat_genre varchar(30)  NULL,
    cat_marital_status varchar(30)  NULL,
    status int  NOT NULL,
    tx_id int  NOT NULL,
    tx_username varchar(100)  NOT NULL,
    tx_host varchar(100)  NOT NULL,
    tx_date timestamp  NOT NULL,
    CONSTRAINT person_pk PRIMARY KEY (person_id)
);

-- Table: product
CREATE TABLE product (
    product_id serial  NOT NULL,
    product_code varchar(30)  NOT NULL,
    cat_product_type varchar(30)  NOT NULL,
    product_name varchar(100)  NOT NULL,
    product_description int  NULL,
    product_attributes json  NOT NULL,
    status int  NOT NULL,
    tx_id int  NOT NULL,
    tx_username varchar(100)  NOT NULL,
    tx_host varchar(100)  NOT NULL,
    tx_date timestamp  NOT NULL,
    CONSTRAINT product_pk PRIMARY KEY (product_id)
);

-- Table: product_order
CREATE TABLE product_order (
    provider_product_id serial  NOT NULL,
    order_id int  NOT NULL,
    product_id int  NOT NULL,
    unit_price decimal(10,5)  NOT NULL,
    qtty_requested int  NOT NULL,
    qtty_commit int  NULL,
    qtty_received int  NULL,
    status int  NOT NULL,
    tx_id int  NOT NULL,
    tx_username varchar(100)  NOT NULL,
    tx_host varchar(100)  NOT NULL,
    tx_date timestamp  NOT NULL,
    CONSTRAINT product_order_pk PRIMARY KEY (provider_product_id)
);

-- Table: provider
CREATE TABLE provider (
    provider_id serial  NOT NULL,
    provider_name int  NOT NULL,
    cat_country varchar(30)  NOT NULL,
    status int  NOT NULL,
    tx_id int  NOT NULL,
    tx_username varchar(100)  NOT NULL,
    tx_host varchar(100)  NOT NULL,
    tx_date timestamp  NOT NULL,
    CONSTRAINT provider_pk PRIMARY KEY (provider_id)
);

-- Table: role
CREATE TABLE role (
    role_id serial  NOT NULL,
    role_name varchar(100)  NOT NULL,
    status int  NOT NULL,
    tx_id int  NOT NULL,
    tx_username varchar(100)  NOT NULL,
    tx_host varchar(100)  NOT NULL,
    tx_date timestamp  NOT NULL,
    CONSTRAINT role_pk PRIMARY KEY (role_id)
);

-- Table: role_feature
CREATE TABLE role_feature (
    role_feature_id serial  NOT NULL,
    role_id int  NOT NULL,
    feature_id int  NOT NULL,
    status int  NOT NULL,
    tx_id int  NOT NULL,
    tx_username varchar(100)  NOT NULL,
    tx_host varchar(100)  NOT NULL,
    tx_date timestamp  NOT NULL,
    CONSTRAINT role_feature_pk PRIMARY KEY (role_feature_id)
);

-- Table: user
CREATE TABLE "user" (
    user_id serial  NOT NULL,
    username varchar(100)  NOT NULL,
    password varchar(100)  NOT NULL,
    email varchar(100)  NOT NULL,
    phone_number varchar(50)  NOT NULL,
    cat_user_status varchar(30)  NOT NULL,
    status int  NOT NULL,
    tx_id int  NOT NULL,
    tx_username varchar(100)  NOT NULL,
    tx_host varchar(100)  NOT NULL,
    tx_date timestamp  NOT NULL,
    CONSTRAINT user_pk PRIMARY KEY (user_id)
);

-- Table: user_role
CREATE TABLE user_role (
    user_role_id serial  NOT NULL,
    role_id int  NOT NULL,
    user_id int  NOT NULL,
    status int  NOT NULL,
    tx_id int  NOT NULL,
    tx_username varchar(100)  NOT NULL,
    tx_host varchar(100)  NOT NULL,
    tx_date timestamp  NOT NULL,
    CONSTRAINT user_role_pk PRIMARY KEY (user_role_id)
);

-- Table: warehouse
CREATE TABLE warehouse (
    warehouse_id serial  NOT NULL,
    warehouse_name int  NOT NULL,
    warehouse_address text  NOT NULL,
    latitude real  NULL,
    longitude real  NULL,
    status int  NOT NULL,
    tx_id int  NOT NULL,
    tx_username varchar(100)  NOT NULL,
    tx_host varchar(100)  NOT NULL,
    tx_date timestamp  NOT NULL,
    CONSTRAINT warehouse_pk PRIMARY KEY (warehouse_id)
);

-- foreign keys
-- Reference: attribute_product (table: attribute)
ALTER TABLE attribute ADD CONSTRAINT attribute_product
    FOREIGN KEY (product_id)
    REFERENCES product (product_id)
    NOT DEFERRABLE
    INITIALLY IMMEDIATE
;

-- Reference: customer_person (table: customer)
ALTER TABLE customer ADD CONSTRAINT customer_person
    FOREIGN KEY (person_id)
    REFERENCES person (person_id)
    NOT DEFERRABLE
    INITIALLY IMMEDIATE
;

-- Reference: customer_user (table: customer)
ALTER TABLE customer ADD CONSTRAINT customer_user
    FOREIGN KEY (user_id)
    REFERENCES "user" (user_id)
    NOT DEFERRABLE
    INITIALLY IMMEDIATE
;

-- Reference: employee_person (table: employee)
ALTER TABLE employee ADD CONSTRAINT employee_person
    FOREIGN KEY (person_person_id)
    REFERENCES person (person_id)
    NOT DEFERRABLE
    INITIALLY IMMEDIATE
;

-- Reference: employee_user (table: employee)
ALTER TABLE employee ADD CONSTRAINT employee_user
    FOREIGN KEY (user_id)
    REFERENCES "user" (user_id)
    NOT DEFERRABLE
    INITIALLY IMMEDIATE
;

-- Reference: employee_warehouse_employee (table: employee_wh)
ALTER TABLE employee_wh ADD CONSTRAINT employee_warehouse_employee
    FOREIGN KEY (employee_id)
    REFERENCES employee (employee_id)
    NOT DEFERRABLE
    INITIALLY IMMEDIATE
;

-- Reference: employee_warehouse_warehouse (table: employee_wh)
ALTER TABLE employee_wh ADD CONSTRAINT employee_warehouse_warehouse
    FOREIGN KEY (warehouse_id)
    REFERENCES warehouse (warehouse_id)
    NOT DEFERRABLE
    INITIALLY IMMEDIATE
;

-- Reference: item_catalog (table: item)
ALTER TABLE item ADD CONSTRAINT item_catalog
    FOREIGN KEY (catalog_id)
    REFERENCES catalog (catalog_id)
    NOT DEFERRABLE
    INITIALLY IMMEDIATE
;

-- Reference: order_provider (table: order)
ALTER TABLE "order" ADD CONSTRAINT order_provider
    FOREIGN KEY (provider_id)
    REFERENCES provider (provider_id)
    NOT DEFERRABLE
    INITIALLY IMMEDIATE
;

-- Reference: order_user (table: order)
ALTER TABLE "order" ADD CONSTRAINT order_user
    FOREIGN KEY (order_user_id)
    REFERENCES "user" (user_id)
    NOT DEFERRABLE
    INITIALLY IMMEDIATE
;

-- Reference: order_warehouse (table: order)
ALTER TABLE "order" ADD CONSTRAINT order_warehouse
    FOREIGN KEY (warehouse_id)
    REFERENCES warehouse (warehouse_id)
    NOT DEFERRABLE
    INITIALLY IMMEDIATE
;

-- Reference: product_order_order (table: product_order)
ALTER TABLE product_order ADD CONSTRAINT product_order_order
    FOREIGN KEY (order_id)
    REFERENCES "order" (order_id)
    NOT DEFERRABLE
    INITIALLY IMMEDIATE
;

-- Reference: provider_product_product (table: product_order)
ALTER TABLE product_order ADD CONSTRAINT provider_product_product
    FOREIGN KEY (product_id)
    REFERENCES product (product_id)
    NOT DEFERRABLE
    INITIALLY IMMEDIATE
;

-- Reference: role_feature_feature (table: role_feature)
ALTER TABLE role_feature ADD CONSTRAINT role_feature_feature
    FOREIGN KEY (feature_id)
    REFERENCES feature (feature_id)
    NOT DEFERRABLE
    INITIALLY IMMEDIATE
;

-- Reference: role_feature_role (table: role_feature)
ALTER TABLE role_feature ADD CONSTRAINT role_feature_role
    FOREIGN KEY (role_id)
    REFERENCES role (role_id)
    NOT DEFERRABLE
    INITIALLY IMMEDIATE
;

-- Reference: user_role_role (table: user_role)
ALTER TABLE user_role ADD CONSTRAINT user_role_role
    FOREIGN KEY (role_id)
    REFERENCES role (role_id)
    NOT DEFERRABLE
    INITIALLY IMMEDIATE
;

-- Reference: user_role_user (table: user_role)
ALTER TABLE user_role ADD CONSTRAINT user_role_user
    FOREIGN KEY (user_id)
    REFERENCES "user" (user_id)
    NOT DEFERRABLE
    INITIALLY IMMEDIATE
;

-- End of file.