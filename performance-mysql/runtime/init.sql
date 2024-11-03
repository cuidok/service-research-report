CREATE DATABASE `performance-mysql` DEFAULT CHARACTER SET UTF8MB4 COLLATE utf8mb4_general_ci;

use `performance-mysql`;

CREATE TABLE `order`
(
    `id`          INT                                        NOT NULL AUTO_INCREMENT COMMENT 'Primary key, auto-incremented',
    `name`        VARCHAR(255)                               NOT NULL COMMENT 'Name of the order',
    `des`         TEXT COMMENT 'Description of the order',
    `price`       DECIMAL(10, 2)                             NOT NULL DEFAULT 0.00 COMMENT 'Price of the order',
    `status`      ENUM ('CREATED', 'CANCELLED', 'COMPLETED') NOT NULL COMMENT 'Status of the order',
    `user_id`     INT                                        NOT NULL COMMENT 'ID of the user who placed the order',
    `user_name`   VARCHAR(255)                               NOT NULL COMMENT 'Name of the user who placed the order',
    `create_time` TIMESTAMP                                  NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT 'Time when the order was created',
    `update_time` TIMESTAMP                                  NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT 'Time when the order was last updated',
    PRIMARY KEY (`id`),
    INDEX `idx_user_id` (`user_id`),
    INDEX `idx_status` (`status`),
    INDEX `idx_price` (`price`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4 COMMENT ='Table to store order information';