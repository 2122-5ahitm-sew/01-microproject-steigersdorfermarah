package at.htl.boundary;

import at.htl.control.AppointmentRepository;
import at.htl.entity.Appointment;
import at.htl.entity.Customer;
import io.quarkus.security.identity.SecurityIdentity;

import javax.annotation.security.RolesAllowed;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@RequestScoped
@Path("/appointment")
public class AppointmentResource {


    @Inject
    SecurityIdentity securityIdentity;

    @Inject
    AppointmentRepository appointmentRepository;


    @GET
    @RolesAllowed("user")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Appointment> appointments() {
        return appointmentRepository.listAll();
    }

    @POST
    @RolesAllowed("admin")
    @Path("add_appointment")
    @Produces(MediaType.APPLICATION_JSON)
    public void addAppointment(Appointment newAppointment){
        appointmentRepository.save(newAppointment);
    }

    @GET
    @Path("{id}")
    @RolesAllowed("user")
    @Produces(MediaType.APPLICATION_JSON)
    public Appointment getAppointment(@PathParam("id") long id) {
        return appointmentRepository.findById(id);
    }

    @GET
    @Path("all")
    @RolesAllowed("user")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Appointment> appointmentList (){
        return appointmentRepository.findAllAppointments();
    }


}
