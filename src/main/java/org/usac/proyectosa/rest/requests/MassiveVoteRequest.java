package org.usac.proyectosa.rest.requests;

import javax.validation.constraints.NotNull;

/**
 *
 * @author esvux
 */
public class MassiveVoteRequest {
    
    @NotNull
    private String dpi;
    
    @NotNull
    private Integer partido;

    public String getDpi() {
        return dpi;
    }

    public void setDpi(String dpi) {
        this.dpi = dpi;
    }

    public Integer getPartido() {
        return partido;
    }

    public void setPartido(Integer partido) {
        this.partido = partido;
    }

}
