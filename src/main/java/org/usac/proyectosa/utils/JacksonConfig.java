package org.usac.proyectosa.utils;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import javax.ws.rs.ext.ContextResolver;
import javax.ws.rs.ext.Provider;

/**
 *
 * @author esvux
 */
@Provider
public class JacksonConfig implements ContextResolver<ObjectMapper>{

    @Override
    public ObjectMapper getContext(Class<?> type) {
        ObjectMapper mapper = new ObjectMapper();       
        mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, true);
        mapper.configure(SerializationFeature.EAGER_SERIALIZER_FETCH, false);
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        mapper.configure(SerializationFeature.CLOSE_CLOSEABLE, true);
        mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        mapper.disable(MapperFeature.DEFAULT_VIEW_INCLUSION); 
        return mapper;        
    }
    
}
