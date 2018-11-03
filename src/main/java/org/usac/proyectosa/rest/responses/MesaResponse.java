package org.usac.proyectosa.rest.responses;

import java.io.Serializable;

/**
 *
 * @author esvux
 */
public class MesaResponse implements Serializable {

    private Integer codDepartamento;
    private Integer codMunicipio;
    private Integer codCentroVotacion;
    private String direccion;
    private Integer numMesa;
    private Integer numLinea;
    private String resume;

    public MesaResponse() {
    }

    public MesaResponse(
            Integer codDepartamento,
            String departamento,
            Integer codMunicipio,
            String municipio,
            Integer codCentroVotacion,
            String centroVotacion,
            String direccion,
            Integer numMesa,
            Integer numLinea
    ) {
        this.codDepartamento = codDepartamento;
        this.codMunicipio = codMunicipio;
        this.codCentroVotacion = codCentroVotacion;
        this.direccion = direccion;
        this.numMesa = numMesa;
        this.numLinea = numLinea;
        this.resume = String.format("Lugar de votación: %s, %s, %s. Ubicado en %s", departamento, municipio, centroVotacion, this.direccion);
    }

    public Integer getCodDepartamento() {
        return codDepartamento;
    }

    public void setCodDepartamento(Integer codDepartamento) {
        this.codDepartamento = codDepartamento;
    }

    public Integer getCodMunicipio() {
        return codMunicipio;
    }

    public void setCodMunicipio(Integer codMunicipio) {
        this.codMunicipio = codMunicipio;
    }

    public Integer getCodCentroVotacion() {
        return codCentroVotacion;
    }

    public void setCodCentroVotacion(Integer codCentroVotacion) {
        this.codCentroVotacion = codCentroVotacion;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Integer getNumMesa() {
        return numMesa;
    }

    public void setNumMesa(Integer numMesa) {
        this.numMesa = numMesa;
    }

    public Integer getNumLinea() {
        return numLinea;
    }

    public void setNumLinea(Integer numLinea) {
        this.numLinea = numLinea;
    }
    
    @Override
    public String toString() {
        return this.resume;
    }

}
