CREATE DATABASE "performance_postgres" WITH ENCODING 'UTF8';

\c performance_postgres

CREATE TABLE "order"
(
    "id"          SERIAL PRIMARY KEY,
    "name"        VARCHAR(255)                                                   NOT NULL,
    "des"         TEXT,
    "price"       DECIMAL(10, 2)                                                 NOT NULL DEFAULT 0.00,
    "status"      TEXT CHECK ("status" IN ('CREATED', 'CANCELLED', 'COMPLETED')) NOT NULL,
    "user_id"     INT                                                            NOT NULL,
    "user_name"   VARCHAR(255)                                                   NOT NULL,
    "create_time" TIMESTAMP                                                      NOT NULL DEFAULT CURRENT_TIMESTAMP,
    "update_time" TIMESTAMP                                                      NOT NULL DEFAULT CURRENT_TIMESTAMP
);
CREATE INDEX "idx_user_id" ON "order" ("user_id");
CREATE INDEX "idx_status" ON "order" ("status");
CREATE INDEX "idx_price" ON "order" ("price");