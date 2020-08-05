package com.goldencompany.airbnb.resources;

import com.goldencompany.airbnb.entity.User;
import com.goldencompany.airbnb.repositories.UserRepository;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

/**
 *
 * @author 
 */
// Endpoint -> Repository -> entityManager -> persistence unit 
// [-> resource -> connection pool -> JDBC driver -> database]

@Path("user")
public class UserResource {
    @GET
    @Path("all")
    public Response all(){                
        
        // inject repository ...
        UserRepository userRepository = new UserRepository();
        
        List<User> users = userRepository.findAll();
        
        return Response
                .ok(users)
                .build();
    }
    
    @GET
    @Path("one")
    public Response one(){
        Response r = Response.status(501).build();                      
        return r;
        
//        try {
//            EntityManager em = entityManagerFactory.createEntityManager();
//            
//            Query q = em.createQuery("Select u from User u");
//            List users = q.getResultList();                                                                                      
//            
//            
//            
//                      
//            return Response
//                .ok(users)
//                .build();
//        } catch (Exception ex) {
//               return Response
//                .ok(ex.toString())
//                .build();
//        }
         
//        UserRepository userRep = new UserRepository();
        
//        User user = userRep.findByUsername("bob");
        
     
    }
    
    
    @POST
    @Path("create")
    public Response create(){
        Response r = Response.status(501).build();                      
        return r;
    }
    
    
    @POST
    @Path("update")
    public Response update(){
        Response r = Response.status(501).build();                      
        return r;
    }
    
    
    @POST
    @Path("delete")
    public Response delete(){
        Response r = Response.status(501).build();                      
        return r;
    }
}
