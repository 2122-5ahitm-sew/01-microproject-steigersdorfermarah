package at.htl.control;

import at.htl.entity.Appointment;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;
import java.util.List;

@ApplicationScoped
public class AppointmentRepository implements PanacheRepository<Appointment> {

    @Transactional
    public Appointment save(Appointment appointment) {
        return getEntityManager().merge(appointment);
    }

    public List<Appointment> findAllAppointments(){
        var query = getEntityManager().createQuery("Select a from Appointment a", Appointment.class);
        return query.getResultList();
    }

    public Appointment findById(long id){
        return find("id", id).firstResult();
    }
}
