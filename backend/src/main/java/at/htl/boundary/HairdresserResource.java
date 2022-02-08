package at.htl.boundary;

import at.htl.control.HairdresserRepository;
import at.htl.entity.Hairdresser;
import io.quarkus.qute.TemplateInstance;
import io.quarkus.qute.api.CheckedTemplate;
import io.quarkus.security.identity.SecurityIdentity;

import javax.annotation.security.RolesAllowed;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@RequestScoped
@Path("/haidresser")
public class HairdresserResource {

    @Inject
    SecurityIdentity securityIdentity;

    @Inject
    HairdresserRepository hairdresserRepository;

    @GET
    @RolesAllowed("user")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Hairdresser> hairdressers() {
        return hairdresserRepository.listAll();
    }

    @POST
    @Path("/add_hairdresser")
    @RolesAllowed("admin")
    @Produces(MediaType.APPLICATION_JSON)
    public void addHairdresser(Hairdresser newHairdresser){
        hairdresserRepository.save(newHairdresser);
    }

    @GET
    @Path("/{id}")
    @RolesAllowed("user")
    @Produces(MediaType.APPLICATION_JSON)
    public Hairdresser getStudent(@PathParam("id") long id) {
        return hairdresserRepository.findById(id);
    }

}
