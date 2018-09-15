package org.usac.proyectosa.rest.filters;

import java.io.Serializable;
import javax.ws.rs.core.Response;

/**
 *
 * @author esvux
 */
public class SAException extends Exception implements Serializable {
    
    private Response.Status httpStatus;
    
    public SAException() {
        super();
    }
    
    public SAException(String msg) {
        super(msg);
    }
    
    public SAException(String msg, Exception e) {
        super(msg, e);
    }

    public SAException(Response.Status httpStatus) {
        super();
	this.httpStatus = httpStatus;
    }
    
    public SAException(String msg, Response.Status httpStatus) {
        super(msg);
	this.httpStatus = httpStatus;
    }
    
    public SAException(String msg, Response.Status httpStatus, Exception e) {
        super(msg, e);
	this.httpStatus = httpStatus;
    }
    
    public Response.Status getHttpStatus() {
	return this.httpStatus;
    }
    
}
