package org.usac.proyectosa.rest.requests;

import javax.validation.constraints.NotNull;

/**
 *
 * @author esvux
 */
public class SingleVoteRequest {
    
    @NotNull
    private String dpi;
    
    @NotNull
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
