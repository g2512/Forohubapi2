CREATE TABLE usuario_auth (
    login_id BIGINT AUTO_INCREMENT PRIMARY KEY,
    login VARCHAR(100) NOT NULL,
    clave VARCHAR(300) NOT NULL
);
