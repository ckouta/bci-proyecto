
CREATE TABLE usuario (
                uuid VARCHAR(255) NOT NULL,
                created DATE,
                email VARCHAR(255),
                isactive BOOLEAN NOT NULL,
                last_login DATE,
                modified DATE,
                user_name VARCHAR(255),
                user_password VARCHAR(255),
                token VARCHAR(255),
                PRIMARY KEY (uuid)
);


CREATE TABLE phone (
                phone_number VARCHAR(255) NOT NULL,
                uuid VARCHAR(255) NOT NULL,
                citycode VARCHAR(255),
                contrycode VARCHAR(255),
                PRIMARY KEY (phone_number, uuid)
);


ALTER TABLE phone ADD CONSTRAINT usuario_phone_fk
FOREIGN KEY (uuid)
REFERENCES usuario (uuid)
ON DELETE NO ACTION
ON UPDATE NO ACTION;


insert into usuario (uuid,created,email, user_name, user_password,isactive) values ('1233223423','2021-10-26',null, 'alvaro', 'password',true);