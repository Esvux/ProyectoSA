package org.usac.proyectosa.rest.responses;

/**
 *
 * @author esvux
 */
public class ResultadoResponseESB {
    
    private Integer idPartido;
    private String nombrePartido;
    private String candidato;
    private Long votos;

    public ResultadoResponseESB(ResultadoResponse response) {
        this.idPartido = response.getIdPartido();
        this.nombrePartido = response.getNombre();
        this.votos = response.getCantidad();
        this.candidato = "Cantidato " + this.idPartido;
    }

    public ResultadoResponseESB() {
    }

    public String getNombrePartido() {
        return nombrePartido;
    }

    public void setNombrePartido(String nombrePartido) {
        this.nombrePartido = nombrePartido;
    }

    public Long getVotos() {
        return votos;
    }

    public void setVotos(Long votos) {
        this.votos = votos;
    }

    public Integer getIdPartido() {
        return idPartido;
    }

    public void setIdPartido(Integer idPartido) {
        this.idPartido = idPartido;
    }

    public String getCandidato() {
        return candidato;
    }

    public void setCandidato(String candidato) {
        this.candidato = candidato;
    }
    
}
