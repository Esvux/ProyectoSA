package org.usac.proyectosa.rest.responses;

import java.io.Serializable;

/**
 *
 * @author esvux
 */
public class DefaultResponse <T> implements Serializable {
    
    private String mensaje;
    private boolean esError;
    private T obj;

    public DefaultResponse() {
    }

    public DefaultResponse(String mensaje, boolean esError, T obj) {
        this.mensaje = mensaje;
        this.esError = esError;
        this.obj = obj;
    }
    
    public DefaultResponse(String mensaje, boolean esError) {
        this(mensaje, esError, null);
    }
    
    public static DefaultResponse getErrorResponse(String mensaje) {
        DefaultResponse<String> error = new DefaultResponse<>(mensaje, true);
        return error;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public boolean isEsError() {
        return esError;
    }

    public void setEsError(boolean esError) {
        this.esError = esError;
    }

    public T getObj() {
        return obj;
    }

    public void setObj(T obj) {
        this.obj = obj;
    }

}
