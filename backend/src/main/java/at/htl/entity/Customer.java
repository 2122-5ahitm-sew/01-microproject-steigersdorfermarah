package at.htl.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "CUSTOMER")
public class Customer extends Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @JsonIgnore
    @OneToMany(mappedBy = "customer",cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
    private List<Appointment> appointments = new ArrayList<>();

    @Column(name = "mobilenr")
    private String mobileNr;

    public Customer() {
    }

    public Customer(Long id, String firstName, String lastName, String mobileNr) {
        super(firstName, lastName);
        this.id = id;
        this.mobileNr = mobileNr;
    }

    public Customer(String firstName, String lastName, String mobileNr) {
        super(firstName, lastName);
        this.mobileNr = mobileNr;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMobileNr() {
        return mobileNr;
    }

    public void setMobileNr(String mobileNr) {
        this.mobileNr = mobileNr;
    }

    public List<Appointment> getAppointments() {
        return appointments;
    }

    @Override
    public String toString() {
        return String.format("%03d: %s %s, %s",
                id,
                super.getLastName(),
                super.getFirstName(),
                mobileNr);
    }
}
