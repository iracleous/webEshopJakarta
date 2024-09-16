package gr.codehub.eshoped.webeshop.resources;

import gr.codehub.eshoped.webeshop.models.User;
import gr.codehub.eshoped.webeshop.services.ManagerService;
import jakarta.annotation.security.PermitAll;
import jakarta.annotation.security.RolesAllowed;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;

/**
 *
 * @author 
 */


/*
resource
endpoint
controller

 
@PathParam("name")
@QueryParam("name") when submitted as application/json
@HeaderParam("User-Agent")
@FormParam("name")   when submitted as application/x-www-form-urlencoded
@CookieParam
@Context UriInfo uriInfo, @Context HttpHeaders headers
*/
@Path("eshop")
public class JakartaEE11Resource {
    
    
     // Simulated data store (in-memory)
    private static Map<Integer, User> users = new HashMap<>();
    
    static {
        users.put(1, new User(1, "John Doe"));
        users.put(2, new User(2, "Jane Doe"));
    }
    
    
    @Inject
    private ManagerService managerService;
    
    @PermitAll
    @GET
    @Path("ping")
    @Produces("Application/json")
    @Consumes("Application/json")
 //   @Produces(MediaType.APPLICATION_JSON)
    public Response ping(){
        String getData = managerService.doWork("data");
        return Response
                .ok("ping Jakarta EE " + getData)
                .build();
    }
    
    
    @GET
    @Path("ping0")
    @Produces("Application/json")
    @Consumes("Application/json")
 //   @Produces(MediaType.APPLICATION_JSON)
    public Response ping0(){
        String getData = managerService.doWork("data");
        return Response
                .ok("ping Jakarta EE " + getData)
                .build();
    }
    
    
    
     @GET
    @Path("/auth")
    @RolesAllowed("ADMIN")
    @Produces("Application/json")
    public String authenticated(){
        return "you are authenticated";
    }
    
    
    
    
    
    private final ExecutorService executorService = java.util.concurrent.Executors.newCachedThreadPool();
   
    
    /**
     * 
     * @param asyncResponse
     * @param id
     * @param updatedUser 
     */
    // Update an existing user by ID
    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void updateUser(@jakarta.ws.rs.container.Suspended
    final jakarta.ws.rs.container.AsyncResponse asyncResponse, @PathParam(value = "id")
    final int id, final User updatedUser) {
        // the return value is lost , the resoutce does not return response but void
        executorService.submit(() -> {
            asyncResponse.resume(doUpdateUser(id, updatedUser));
        });
    }

    private Response doUpdateUser(@PathParam("id") int id, User updatedUser) {
        User user = users.get(id);
        if (user == null) {
            return Response.status(Response.Status.NOT_FOUND)
                    .entity("User not found with ID: " + id).build();
        }
        user.setName(updatedUser.getName());
        users.put(id, user);
        return Response.ok(user).build();
    }
 
    
}
