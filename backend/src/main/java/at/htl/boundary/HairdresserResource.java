package at.htl.boundary;

import at.htl.control.HairdresserRepository;
import at.htl.entity.Hairdresser;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@RequestScoped
@Path("/haidresser")
public class HairdresserResource {

    @Inject
    HairdresserRepository hairdresserRepository;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Hairdresser> hairdressers() {
        return hairdresserRepository.listAll();
    }

    @POST
    @Path("/name")
    @Produces(MediaType.APPLICATION_JSON)
    public Hairdresser getName(String firstName, String lastName){
        return hairdresserRepository.findByName(firstName, lastName);
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Hairdresser getStudent(@PathParam("id") long id) {
        return hairdresserRepository.findById(id);
    }
}
