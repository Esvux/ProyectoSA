
-- Reiniciar votos
update elector set voto_emitido = false;
delete from voto;
update mesa_votacion set cant_nulos=0, cant_blancos=0;
