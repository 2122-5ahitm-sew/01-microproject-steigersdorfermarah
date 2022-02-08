package at.htl.control;

import at.htl.entity.Customer;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;
import java.util.List;

@ApplicationScoped
public class CustomerRepository implements PanacheRepository<Customer> {

    @Transactional
    public Customer save(Customer customer) {
        return getEntityManager().merge(customer);
    }

    public Customer findById(long id){
        return find("id", id).firstResult();
    }

    public List<Customer> findAllCustomer(){
        var query = getEntityManager().createQuery("Select c from Customer c", Customer.class);
        return query.getResultList();
    }
}
