INSERT INTO centro_votacion(id_centro, nombre, direccion, extra_direccion, id_municipio)
SELECT
id_municipio AS id_centro,
concat("Centro de votación de ", nombre) AS nombre,
concat("Algún lugar de ", nombre) AS direccion,
"más..." AS extra_direccion,
id_municipio
FROM municipio;

DELETE FROM elector;
DELETE FROM voto;

DELETE FROM mesa_votacion
WHERE id_centro IN (
	SELECT id_centro
	FROM centro_votacion c, municipio m
	WHERE c.id_municipio = m.id_municipio
	AND m.id_departamento NOT IN (2, 21, 11, 10)
);

DELETE FROM centro_votacion
WHERE id_municipio IN (
	SELECT id_municipio 
	FROM municipio 
	WHERE id_departamento NOT IN (2, 21, 11, 10)
);

DELETE FROM municipio
WHERE id_departamento NOT IN (2, 21, 11, 10);

DELETE FROM departamento
WHERE id_departamento NOT IN (2, 21, 11, 10);