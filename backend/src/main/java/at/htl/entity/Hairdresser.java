package at.htl.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "HAIRDRESSER")
public class Hairdresser extends Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "salary")
    private int salary;

    @OneToMany(mappedBy = "hairdresser",cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
    private List<Appointment> appointments = new ArrayList<>();

    public Hairdresser() {
    }

    public Hairdresser(String firstName, String lastName, int salary) {
        super(firstName, lastName);
        this.salary = salary;
    }

    public Hairdresser(String firstName, String lastName) {
        super(firstName, lastName);
    }

    public Hairdresser(String firstName, String lastName, int salary, List<Appointment> appointments) {
        super(firstName, lastName);
        this.salary = salary;
        this.appointments = appointments;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public List<Appointment> getAppointments() {
        return appointments;
    }

    public void addAppointment(Hairdresser hairdresser, Customer customer, String date) {
        appointments.add(new Appointment(hairdresser,customer,date));
    }

    @Override
    public String toString() {
        return String.format("%03d: %s %s, %d",
                id,
                super.getLastName(),
                super.getFirstName(),
                salary);

    }
}
