create database productos;
use productos;
CREATE TABLE productos (
    id INT AUTO_INCREMENT PRIMARY KEY,
    referencia VARCHAR(255) NOT NULL,
    nombre VARCHAR(255) NOT NULL,
    precios FLOAT NOT NULL,
    categoria INT NOT NULL
);

select * from productos;