CREATE TABLE t_orders (
                          order_id BIGINT NOT NULL AUTO_INCREMENT,
                          order_number VARCHAR(255),
                          sku_code VARCHAR(255),
                          price DECIMAL(19, 2),
                          quantity INT,
                          customer_id VARCHAR(255),

                          PRIMARY KEY (order_id)
);