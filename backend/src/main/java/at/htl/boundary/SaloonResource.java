package at.htl.boundary;

import at.htl.entity.Appointment;
import at.htl.entity.Customer;
import at.htl.entity.Hairdresser;
import io.quarkus.qute.TemplateInstance;
import io.quarkus.qute.api.CheckedTemplate;
import io.quarkus.security.identity.SecurityIdentity;

import javax.annotation.security.RolesAllowed;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("saloon")
public class SaloonResource {

    Hairdresser marah = new Hairdresser("Marah", "Steigersdorfer");
    Hairdresser helmuth = new Hairdresser("Helmuth", "Gruber");
    Hairdresser michi = new Hairdresser("Michi", "Rot");

    Customer susi = new Customer("Susi", "Snow", "06761234556");
    Customer sarah = new Customer("Sarah", "Feichtinger", "06772345792");
    Customer felix = new Customer("Felix", "Dumfarth", "066023863939");
    Customer jonas = new Customer("Jonas", "Huber", "066023812232");
    Customer marie = new Customer("Marie", "Muster", "067623920034");

    private final List<Hairdresser> hairdressers = List.of(
            marah,
            helmuth,
            michi
    );

    private final List<Appointment> appointments = List.of(
            new Appointment(marah, sarah, "09.02.22"),
            new Appointment(marah, felix, "10.02.22"),
            new Appointment(helmuth, jonas, "10.02.22"),
            new Appointment(helmuth, susi, "11.02.22"),
            new Appointment(michi, marie, "09.02.22")
    );

    @GET
    @Produces(MediaType.TEXT_HTML)
    public TemplateInstance get() {
        return Templates.hairdresser(hairdressers, appointments);
    }

    @CheckedTemplate
    public static class Templates {
        public static native TemplateInstance hairdresser(List<Hairdresser> hairdressers, List<Appointment> appointments);
    }

}
