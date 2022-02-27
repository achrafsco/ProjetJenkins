package main.java.com.atelier_jenkins.repository;

import main.java.com.atelier_jenkins.modele.Customer;
import main.java.com.atelier_jenkins.modele.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

    @Query(" select c from Customer c " +
            " where c.username = ?1")
    Optional<Customer> findCustomerWithName(String username);
}
