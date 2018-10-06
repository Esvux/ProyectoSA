package org.usac.proyectosa.rest.requests;

/**
 *
 * @author esvux
 */
public class EmitirVotoRequest {
    private String dpi;
    private String partido;

    public String getDpi() {
        return dpi;
    }

    public void setDpi(String dpi) {
        this.dpi = dpi;
    }

    public String getPartido() {
        return partido;
    }

    public void setPartido(String partido) {
        this.partido = partido;
    }
    
}
