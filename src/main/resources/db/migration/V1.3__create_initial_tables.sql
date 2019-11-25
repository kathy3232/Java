
CREATE TABLE orders (
   /*id                INTEGER NOT NULL default nextval('department_id_seq'), */
   order_id                SERIAL NOT NULL,
   order_date        date default CURRENT_DATE,
   comment           VARCHAR(150),
   order_quantity    int,
   user_id           INTEGER NOT NULL,
   item_id           INTEGER NOT NULL
);
ALTER TABLE orders ADD CONSTRAINT orders_pk PRIMARY KEY ( order_id );
CREATE TABLE users (

   user_id                  SERIAL NOT NULL,
   username            VARCHAR(30) not null unique,
   first_name          VARCHAR(30),
   last_name           VARCHAR(30),
   email               VARCHAR(50),
   address             VARCHAR(150),
   registered_date     date default CURRENT_DATE,
   birthday            date default CURRENT_DATE
);
ALTER TABLE users ADD CONSTRAINT users_pk PRIMARY KEY ( user_id );
CREATE TABLE items (
   /*id             INTEGER NOT NULL default nextval('account_id_seq'),*/
   item_id             SERIAL NOT NULL,
   price          INTEGER,
   item_name      VARCHAR(30),
   item_brand     VARCHAR(30),
   item_type      VARCHAR(30),
   quantity_in_stock int
);
ALTER TABLE items ADD CONSTRAINT items_pk PRIMARY KEY ( item_id );

ALTER TABLE orders
ADD CONSTRAINT orders_users_fk FOREIGN KEY (user_id)
REFERENCES users(user_id);


ALTER TABLE orders
ADD CONSTRAINT orders_items_fk FOREIGN KEY (item_id)
REFERENCES items (item_id);


