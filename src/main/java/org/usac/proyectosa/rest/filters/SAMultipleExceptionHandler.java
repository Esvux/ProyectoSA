package org.usac.proyectosa.rest.filters;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;
import org.usac.proyectosa.rest.responses.DefaultResponse;

/**
 *
 * @author esvux
 */
@Provider
public class SAMultipleExceptionHandler implements ExceptionMapper<SAMultipleException> {

    @Override
    public Response toResponse(SAMultipleException exception) {
        return Response
                .status(exception.getHttpStatus())
                .entity(DefaultResponse.getMultipleErrorResponse(exception.getErrors()))
                .build();
    }

}
