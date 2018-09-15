package org.usac.proyectosa.rest;

import java.util.HashSet;
import java.util.Set;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import org.glassfish.jersey.jackson.JacksonFeature;
import org.usac.proyectosa.rest.filters.SAExceptionHandler;
import org.usac.proyectosa.utils.JacksonConfig;

/**
 *
 * @author esvux
 */

@ApplicationPath("rest")
public class RestApplication extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new HashSet<>();

        //Endpoints
        resources.add(CentroVotacionEndpoint.class);
        resources.add(MesaVotacionEndpoint.class);
        resources.add(_ElectorEndpoint.class);
        resources.add(DepartamentoEndpoint.class);
        resources.add(MunicipioEndpoint.class);

        //Configurations
        resources.add(JacksonFeature.class);
        resources.add(JacksonConfig.class);
        resources.add(SAExceptionHandler.class);
        return resources;
    }    

}
