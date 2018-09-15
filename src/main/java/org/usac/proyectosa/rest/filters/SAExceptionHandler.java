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
public class SAExceptionHandler implements ExceptionMapper<SAException> {

    @Override
    public Response toResponse(SAException exception) {
        return Response
                .status(exception.getHttpStatus())
                .entity(DefaultResponse.getErrorResponse(exception.getMessage()))
                .build();
    }

}
