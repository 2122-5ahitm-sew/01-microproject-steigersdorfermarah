package at.htl.boundary;

import at.htl.control.CustomerRepository;
import at.htl.entity.Customer;
import at.htl.entity.Hairdresser;
import io.quarkus.security.identity.SecurityIdentity;

import javax.annotation.security.RolesAllowed;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;


@RequestScoped
@Path("/customer")
public class CustomerResource {

        @Inject
        SecurityIdentity securityIdentity;

        @Inject
        CustomerRepository customerRepository;

        @GET
        @RolesAllowed("user")
        @Produces(MediaType.APPLICATION_JSON)
        public List<Customer> customers() {
            return customerRepository.listAll();
        }

        @POST
        @Path("/add_customer")
        @RolesAllowed("admin")
        @Produces(MediaType.APPLICATION_JSON)
        public void addCustomer(Customer newCustomer){
                customerRepository.save(newCustomer);
        }

        @GET
        @Path("/{id}")
        @RolesAllowed("user")
        @Produces(MediaType.APPLICATION_JSON)
        public Customer getCustomer(@PathParam("id") long id) {
            return customerRepository.findById(id);
        }

        @GET
        @Path("/all")
        @RolesAllowed("user")
        @Produces(MediaType.APPLICATION_JSON)
        public List<Customer> customerList (){
            return customerRepository.findAllCustomer();
        }

    }
