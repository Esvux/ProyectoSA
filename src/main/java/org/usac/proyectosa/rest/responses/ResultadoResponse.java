package org.usac.proyectosa.rest.responses;

/**
 *
 * @author esvux
 */
public class ResultadoResponse {
    
    private String nombre;
    private Long cantidad;

    public ResultadoResponse(String nombre, Long cantidad) {
        this.nombre = nombre;
        this.cantidad = cantidad;
    }

    public ResultadoResponse() {
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Long getCantidad() {
        return cantidad;
    }

    public void setCantidad(Long cantidad) {
        this.cantidad = cantidad;
    }
    
}
