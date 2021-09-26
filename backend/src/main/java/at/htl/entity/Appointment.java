package at.htl.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

import javax.persistence.*;

@Entity
@Table(name = "APPOINTMENT")
public class Appointment extends PanacheEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH})
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH})
    @JoinColumn(name = "hairdresser_id")
    private Hairdresser hairdresser;

    @Column(name = "date")
    private String date;


    public Appointment() {
    }

    public Appointment(Hairdresser hairdresser, Customer customer, String date) {
        this.hairdresser = hairdresser;
        this.customer = customer;
        this.date = date;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Hairdresser getHairdresser() {
        return hairdresser;
    }

    public void setHairdresser(Hairdresser hairdresser) {
        this.hairdresser = hairdresser;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;

    }

    @Override
    public String toString() {
        return String.format("%03d: %s %s, %s %s, %s",
                id,
                hairdresser.getLastName(),
                hairdresser.getFirstName(),
                customer.getLastName(),
                customer.getFirstName(),
                getDate());
    }
}
