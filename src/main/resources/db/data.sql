CREATE TABLE client (
                        id INT PRIMARY KEY AUTO_INCREMENT,
                        identification_number VARCHAR(50) NOT NULL UNIQUE,
                        document_type VARCHAR(20) NOT NULL,
                        first_name VARCHAR(100) NOT NULL,
                        second_name VARCHAR(100),
                        first_last_name VARCHAR(100),
                        second_last_name VARCHAR(100),
                        phone_number VARCHAR(20),
                        address VARCHAR(255),
                        city_of_residence VARCHAR(100)
);

INSERT INTO client (
    identification_number, document_type, first_name, second_name,
    first_last_name, second_last_name, phone_number, address, city_of_residence)
VALUES
    ('23445322', 'C', 'Juan', 'Carlos','Pérez', 'Gómez', '3115551234', 'Calle 123 #45-67', 'Bogotá'),
    ('091127AA', 'P', 'Sofia', 'Andrea','Corredor', 'Suarez', '3104562291', 'Calle 23L #67B-38', 'Bogotá');