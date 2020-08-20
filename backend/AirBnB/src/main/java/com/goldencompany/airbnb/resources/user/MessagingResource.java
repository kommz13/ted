package com.goldencompany.airbnb.resources.user;

import com.goldencompany.airbnb.controllers.MessageManagementController;
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
@Path("/messages")
public class MessagingResource {
    @Inject
    MessageManagementController controller;
//    
//    @GET    
//    @Path("")
//    public Response list(){     
//        List users = controller.retrieveUsers();
//        
//        return Response
//                .ok(users)
//                .build();
//    }
//    
    @GET    
    @Path("received/{id}")    
    public Response id(@PathParam("id") Integer id){     
        List message = controller.retrieveMessageByUserID(id);
        
        return Response
                .ok(message)
                .build();
    }
}
