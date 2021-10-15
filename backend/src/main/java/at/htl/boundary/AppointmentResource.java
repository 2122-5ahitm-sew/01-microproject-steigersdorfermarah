package at.htl.boundary;

import at.htl.control.AppointmentRepository;
import at.htl.entity.Appointment;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@RequestScoped
@Path("/appointment")
public class AppointmentResource {

    @Inject
    AppointmentRepository appointmentRepository;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Appointment> appointments() {
        return appointmentRepository.listAll();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Appointment getAppointment(@PathParam("id") long id) {
        return appointmentRepository.findById(id);
    }

    @GET
    @Path("/all")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Appointment> appointmentList (){
        return appointmentRepository.findAllAppointments();
    }
}
