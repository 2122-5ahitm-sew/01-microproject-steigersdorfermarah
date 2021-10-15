package at.htl.control;


import at.htl.entity.Appointment;
import at.htl.entity.Customer;
import at.htl.entity.Hairdresser;
import io.quarkus.runtime.StartupEvent;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;
import javax.inject.Inject;
import javax.transaction.Transactional;

@ApplicationScoped
public class InitBean {

    @Inject
    HairdresserRepository hairdresserRepository;

    @Inject
    CustomerRepository customerRepository;

    @Inject
    AppointmentRepository appointmentRepository;

    @Transactional
    void onStartup(@Observes StartupEvent event) {
        System.out.println("It works!");

        Hairdresser helmuth = new Hairdresser("Helmuth", "Gruber", 1400);
        Hairdresser michi = new Hairdresser("Michi", "Rot", 1800);
        Customer michaela = new Customer("Michaela", "Steiner", "06648298478");
        Customer silvia = new Customer("Silvia", "Fichte", "06768284759");

        hairdresserRepository.persist(helmuth);
        hairdresserRepository.persist(michi);
        customerRepository.persist(michaela);
        customerRepository.persist(silvia);
        appointmentRepository.persist(new Appointment(helmuth, silvia, "12.02.21"));
        appointmentRepository.persist(new Appointment(michi, michaela, "02.02.21"));
    }
}
