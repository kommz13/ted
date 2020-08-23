package com.goldencompany.airbnb.resources.account;

import com.goldencompany.airbnb.controllers.AccountManagementController;
import com.goldencompany.airbnb.dto.input.RegisterDTO;
import com.goldencompany.airbnb.exceptions.UserValidationException;
import java.util.List;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

/**
 *
 * @author
 */
//| /api/admin/account/active | GET | - | all active accounts
//| /api/admin/account/inactive | GET | - | all inactive accounts
//| /api/admin/account/activate/:id | POST | - | success / fail
//| /api/admin/account/deactivate/:id | POST | - | success / fail
@Path("/account")
public class AccountResource {

    @Inject
    AccountManagementController controller;

    @POST
    @Path("/register")
    public Response register(RegisterDTO input) {
        try {
            List user = controller.createUser(input);
            return Response.ok(user).build();
        } catch (UserValidationException ex) {
            return Response.ok(ex.getErrors()).status(Response.Status.NOT_ACCEPTABLE).build();
        }

        
        
    }
    //peiramata
    @GET    
    @Path("{id}")
    public Response id(@PathParam("id") Integer id){     
//        List user = controller.retrieveUserByID(id);        
        if(id==1){
        return Response
                .ok("id = 1")
                .build();
        }else{
            return Response
                .ok("id = something else")
                .build();
        }
    }
}
