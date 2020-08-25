package com.goldencompany.airbnb.resources.listing;

import com.goldencompany.airbnb.controllers.listing.ListingManagementController;
import com.goldencompany.airbnb.entity.constants.UserConstants;
import com.goldencompany.airbnb.exceptions.UserValidationException;
import java.util.List;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

// | /api/admin/users | GET | - | all users
// | /api/admin/users/:id | GET | id | user details of user with that ID
/**
 *
 * @author
 */
@Path("/listing")
public class ListingResource {

    @Inject
    ListingManagementController controller;

    @GET
    @Path("/all")
    public Response list() {
        List listings = controller.retrieveListings();

        return Response
                .ok(listings)
                .build();
    }

//    @GET
//    @Path("{id}")
//    public Response id(@PathParam("id") Integer id) {
//        List user = controller.retrieveUserByID(id);
//
//        return Response
//                .ok(user)
//                .build();
//    }
//
//    @GET
//    @Path("active")
//    public Response active() {
//        List users = controller.retrieveActiveUsers();
//
//        return Response
//                .ok(users)
//                .build();
//    }
//
//    @GET
//    @Path("inactive")
//    public Response inactive() {
//        List users = controller.retrieveInactiveUsers();
//
//        return Response
//                .ok(users)
//                .build();
//    }
//
//    @GET
//    @Path("approved")
//    public Response approved() {
//        List users = controller.retrieveUsersByStatus(UserConstants.APPROVED);
//
//        return Response
//                .ok(users)
//                .build();
//    }
//
//    @GET
//    @Path("pending")
//    public Response pending() {
//        List users = controller.retrieveUsersByStatus(UserConstants.PENDING);
//
//        return Response
//                .ok(users)
//                .build();
//    }
//
//    @GET
//    @Path("rejected")
//    public Response rejected() {
//        List users = controller.retrieveUsersByStatus(UserConstants.REJECTED);
//
//        return Response
//                .ok(users)
//                .build();
//    }
//
//    @POST
//    @Path("approve/{id}")
//    public Response approve(@PathParam("id") Integer id) {
//        try {
//            List users = controller.approveUser(id);
//
//            return Response
//                    .ok(users)
//                    .build();
//        } catch (UserValidationException ex) {
//            return Response.ok(ex.getErrors()).status(Response.Status.NOT_ACCEPTABLE).build();
//        }
//    }
//
//    @POST
//    @Path("unapprove/{id}")
//    public Response unapprove(@PathParam("id") Integer id) {
//        try {
//            List users = controller.unapproveUser(id);
////            List users = controller.approveUser(id);
//
//            return Response
//                    .ok(users)
//                    .build();
//        } catch (UserValidationException ex) {
//            return Response.ok(ex.getErrors()).status(Response.Status.NOT_ACCEPTABLE).build();
//        }
//    }
//
//    @POST
//    @Path("unapprove_approved/{id}")
//    public Response unapprove_approved(@PathParam("id") Integer id) {
//        try {
//            List users = controller.unapproveApprovedUser(id);
////            List users = controller.approveUser(id);
//
//            return Response
//                    .ok(users)
//                    .build();
//        } catch (UserValidationException ex) {
//            return Response.ok(ex.getErrors()).status(Response.Status.NOT_ACCEPTABLE).build();
//        }
//    }
//
//    @POST
//    @Path("approve_unapproved/{id}")
//    public Response approve_unapproved(@PathParam("id") Integer id) {
//        try {
//            List users = controller.approveUnapprovedUser(id);
////            List users = controller.approveUser(id);
//
//            return Response
//                    .ok(users)
//                    .build();
//        } catch (UserValidationException ex) {
//            return Response.ok(ex.getErrors()).status(Response.Status.NOT_ACCEPTABLE).build();
//        }
//    }
}
