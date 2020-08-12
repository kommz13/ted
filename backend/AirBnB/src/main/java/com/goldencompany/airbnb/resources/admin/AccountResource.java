//package com.goldencompany.airbnb.resources.admin;
//
//import com.goldencompany.airbnb.controllers.admin.UserManagementController;
//import java.util.List;
//import javax.inject.Inject;
//import javax.ws.rs.GET;
//import javax.ws.rs.Path;
//import javax.ws.rs.core.Response;
//
///**
// *
// * @author 
// */
//
////| /api/admin/account/active | GET | - | all active accounts
////| /api/admin/account/inactive | GET | - | all inactive accounts
////| /api/admin/account/activate/:id | POST | - | success / fail
////| /api/admin/account/deactivate/:id | POST | - | success / fail
//
//
//@Path("/admin/account")
//public class AccountResource {
//    @Inject
//    UserManagementController controller;
//    
//    @GET
//    @Path("list")
//    public Response list(){     
//        List users = controller.retrieveUsers();
//        
//        return Response
//                .ok(users)
//                .build();
//    }
//    
//    
//    
//        
//}
