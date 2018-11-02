package org.usac.proyectosa.rest.filters;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;
import javax.ws.rs.core.Response;

/**
 *
 * @author esvux
 */
public class SAMultipleException extends Exception implements Serializable {
    
    private Response.Status httpStatus;
    private List<String> errors;
    
    public SAMultipleException() {
        super();
        this.errors = Collections.EMPTY_LIST;
        httpStatus = Response.Status.BAD_REQUEST;
    }
    
    public SAMultipleException(List<String> errors) {
        super(errors.toString());
        this.errors = errors;
        httpStatus = Response.Status.BAD_REQUEST;
    }
    
    public SAMultipleException(List<String> errors, Exception e) {
        super(errors.toString(), e);
        this.errors = errors;
        httpStatus = Response.Status.BAD_REQUEST;
    }

    public SAMultipleException(Response.Status httpStatus) {
        this();
    }
    
    public SAMultipleException(List<String> errors, Response.Status httpStatus) {
        this(errors);
	this.httpStatus = httpStatus;
    }
    
    public SAMultipleException(List<String> errors, Response.Status httpStatus, Exception e) {
        this(errors, e);
	this.httpStatus = httpStatus;
    }
    
    public Response.Status getHttpStatus() {
	return this.httpStatus;
    }
    
    public List<String> getErrors() {
        return this.errors;
    }
    
}
