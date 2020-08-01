package com.goldencompany.airbnb.resources;

import com.goldencompany.airbnb.model.Human;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

/**
 *
 * @author 
 */
@Path("javaee8")
public class JavaEE8Resource {
    
    @GET
    public Response ping(){
        return Response
                .ok("ping")
                .build();
    }
    
    @GET
    @Path("pong")
    public Response pong(){
        Human a = new Human("Bob", "Bobious");
        
        
        return Response
                .ok(a)
                .build();
    }
    
}
