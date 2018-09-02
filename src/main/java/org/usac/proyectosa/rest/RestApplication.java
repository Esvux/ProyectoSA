package org.usac.proyectosa.rest;

import java.util.HashSet;
import java.util.Set;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

/**
 *
 * @author esvux
 */

@ApplicationPath("rest")
public class RestApplication extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new HashSet<>();
        resources.add(CentrosVotacionEndpoint.class);
        resources.add(MesasVotacionEndpoint.class);
        resources.add(ElectorEndpoint.class);        
        return resources;
    }    
    
}
