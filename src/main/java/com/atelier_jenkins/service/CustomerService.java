package main.java.com.atelier_jenkins.service;
import main.java.com.atelier_jenkins.modele.Customer;
import main.java.com.atelier_jenkins.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class CustomerService implements UserDetailsService {

    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Objects.requireNonNull(username);
        Customer customer = customerRepository.findCustomerWithName(username)
                .orElseThrow(() -> new UsernameNotFoundException("Customer not found"));

        return customer;
    }

    public Customer getCustomer(String username) throws UsernameNotFoundException {

        Objects.requireNonNull(username);
        Customer customer = customerRepository.findCustomerWithName(username)
                .orElseThrow(() -> new UsernameNotFoundException("Customer not found"));

        return customer;
    }

}