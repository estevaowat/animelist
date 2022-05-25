DROP TABLE IF EXISTS anime;

CREATE TABLE anime
(
    id       BIGINT AUTO_INCREMENT PRIMARY KEY,
    name     VARCHAR(255) UNIQUE NOT NULL,
    status   varchar(255),
    episodes int,
    type     VARCHAR(100),
    genre    VARCHAR(250),
    rating   VARCHAR(10)
);