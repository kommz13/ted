package com.goldencompany.airbnb.resources.admin;

import com.goldencompany.airbnb.controllers.admin.UserManagementController;
import java.util.List;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

/**
 *
 * @author 
 */
@Path("admin/users")
public class UserResource {
    @Inject
    UserManagementController controller;
    
    @GET
    @Path("list")
    public Response list(){     
        List users = controller.retrieveUsers();
        
        return Response
                .ok(users)
                .build();
    }
}
