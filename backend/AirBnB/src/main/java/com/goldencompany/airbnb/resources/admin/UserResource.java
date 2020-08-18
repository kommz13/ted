package com.goldencompany.airbnb.resources.admin;

import com.goldencompany.airbnb.controllers.admin.UserManagementController;
import java.util.List;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

// | /api/admin/users | GET | - | all users
// | /api/admin/users/:id | GET | id | user details of user with that ID

        
/**
 *
 * @author 
 */
@Path("/admin/users")
public class UserResource {
    @Inject
    UserManagementController controller;
    
    @GET    
    @Path("")
    public Response list(){     
        List users = controller.retrieveUsers();
        
        return Response
                .ok(users)
                .build();
    }
    
    @GET    
    @Path("{id}")
    public Response id(@PathParam("id") Integer id){     
        List user = controller.retrieveUserByID(id);
        
        return Response
                .ok(user)
                .build();
    }
        
    @GET    
    @Path("active")
    public Response active(){     
        List users = controller.retrieveActiveUsers();
        
        return Response
                .ok(users)
                .build();
    }
    
    @GET    
    @Path("inactive")
    public Response inactive(){     
        List users = controller.retrieveInactiveUsers();
        
        return Response
                .ok(users)
                .build();
    }
}
