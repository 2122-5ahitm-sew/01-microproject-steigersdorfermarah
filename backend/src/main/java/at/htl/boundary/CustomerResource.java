package at.htl.boundary;

import at.htl.control.CustomerRepository;
import at.htl.entity.Customer;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;


@RequestScoped
@Path("/customer")
public class CustomerResource {

        @Inject
        CustomerRepository customerRepository;

        @GET
        @Produces(MediaType.APPLICATION_JSON)
        public List<Customer> customers() {
            return customerRepository.listAll();
        }

        @GET
        @Path("/{id}")
        @Produces(MediaType.APPLICATION_JSON)
        public Customer getCustomer(@PathParam("id") long id) {
            return customerRepository.findById(id);
        }

        @GET
        @Path("/all")
        @Produces(MediaType.APPLICATION_JSON)
        public List<Customer> customerList (){
            return customerRepository.findAllCustomer();
        }

        @POST
        @Path("/name")
        @Produces(MediaType.APPLICATION_JSON)
        public Customer getName(String firstName, String lastName){
            return customerRepository.findByName(firstName, lastName);
        }
    }
