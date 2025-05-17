-- 1. Create the database
CREATE DATABASE IF NOT EXISTS inventory;
USE inventory;

-- 2. Create 'users' table
CREATE TABLE users (
    user_id      INT AUTO_INCREMENT PRIMARY KEY,
    username     VARCHAR(50) NOT NULL UNIQUE,
    password     VARCHAR(50) NOT NULL,
    role         ENUM('admin', 'user', 'deliverer') NOT NULL
);

-- 3. Create 'products' table
CREATE TABLE products (
    product_id   INT AUTO_INCREMENT PRIMARY KEY,
    name         VARCHAR(100) NOT NULL,
    description  TEXT,
    price        DECIMAL(10,2) NOT NULL,
    stock        INT DEFAULT 0
);

-- 4. Create 'orders' table (many orders belong to one user)
CREATE TABLE orders (
    order_id     INT AUTO_INCREMENT PRIMARY KEY,
    user_id      INT,
    order_date   DATETIME DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (user_id) REFERENCES users(user_id) ON DELETE CASCADE
);

-- 5. Create 'order_items' table (many-to-many: orders <-> products)
CREATE TABLE order_items (
    order_id     INT,
    product_id   INT,
    quantity     INT NOT NULL,
    PRIMARY KEY (order_id, product_id),
    FOREIGN KEY (order_id) REFERENCES orders(order_id) ON DELETE CASCADE,
    FOREIGN KEY (product_id) REFERENCES products(product_id) ON DELETE CASCADE
);

