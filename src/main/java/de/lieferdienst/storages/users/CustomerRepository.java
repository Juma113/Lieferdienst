package de.lieferdienst.storages.users;


import de.lieferdienst.domains.users.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer,Long> {

}
