-- DROP DATABASE elecciones;
-- CREATE DATABASE elecciones;
USE elecciones;

CREATE TABLE partido (
                id_partido INT NOT NULL,
                nombre VARCHAR(150) NOT NULL,
                nombre_candidato VARCHAR(150) NOT NULL,
                PRIMARY KEY (id_partido)
);


CREATE TABLE departamento (
                id_departamento INT NOT NULL,
                nombre VARCHAR(150) NOT NULL,
                PRIMARY KEY (id_departamento)
);


CREATE TABLE municipio (
                id_municipio INT NOT NULL,
                nombre VARCHAR(150) NOT NULL,
                id_departamento INT NOT NULL,
                PRIMARY KEY (id_municipio)
);


CREATE TABLE centro_votacion (
                id_centro INT NOT NULL,
                nombre VARCHAR(150) NOT NULL,
                direccion VARCHAR(150) NOT NULL,
                extra_direccion VARCHAR(150),
                id_municipio INT NOT NULL,
                PRIMARY KEY (id_centro)
);


CREATE TABLE mesa_votacion (
                id_mesa INT NOT NULL,
                num_mesa INT NOT NULL,
                cant_nulos INT DEFAULT 0 NOT NULL,
                cant_blancos INT DEFAULT 0 NOT NULL,
                id_centro INT NOT NULL,
                PRIMARY KEY (id_mesa)
);


CREATE TABLE voto (
                id_voto INT NOT NULL,
                id_mesa INT NOT NULL,
                id_partido INT NOT NULL,
                PRIMARY KEY (id_voto)
);


CREATE TABLE elector (
                id_elector INT NOT NULL,
                dpi VARCHAR(20) NOT NULL,
                num_padron VARCHAR(20) NOT NULL,
                nombres VARCHAR(150) NOT NULL,
                apellidos VARCHAR(150) NOT NULL,
                fecha_nacimiento DATE NOT NULL,
                genero VARCHAR(1) NOT NULL,
                direccion VARCHAR(150) NOT NULL,
                extra_direccion VARCHAR(150),
                id_mesa INT NOT NULL,
                PRIMARY KEY (id_elector)
);


ALTER TABLE voto ADD CONSTRAINT partido_voto_fk
FOREIGN KEY (id_partido)
REFERENCES partido (id_partido)
ON DELETE NO ACTION
ON UPDATE NO ACTION;

ALTER TABLE municipio ADD CONSTRAINT departamento_municipio_fk
FOREIGN KEY (id_departamento)
REFERENCES departamento (id_departamento)
ON DELETE NO ACTION
ON UPDATE NO ACTION;

ALTER TABLE centro_votacion ADD CONSTRAINT municipio_centro_votacion_fk
FOREIGN KEY (id_municipio)
REFERENCES municipio (id_municipio)
ON DELETE NO ACTION
ON UPDATE NO ACTION;

ALTER TABLE mesa_votacion ADD CONSTRAINT centro_votacion_mesa_votacion_fk
FOREIGN KEY (id_centro)
REFERENCES centro_votacion (id_centro)
ON DELETE NO ACTION
ON UPDATE NO ACTION;

ALTER TABLE elector ADD CONSTRAINT mesa_votacion_elector_fk
FOREIGN KEY (id_mesa)
REFERENCES mesa_votacion (id_mesa)
ON DELETE NO ACTION
ON UPDATE NO ACTION;

ALTER TABLE voto ADD CONSTRAINT mesa_votacion_voto_fk
FOREIGN KEY (id_mesa)
REFERENCES mesa_votacion (id_mesa)
ON DELETE NO ACTION
ON UPDATE NO ACTION;