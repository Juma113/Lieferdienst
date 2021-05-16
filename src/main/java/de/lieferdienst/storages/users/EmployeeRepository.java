package de.lieferdienst.storages.users;


import de.lieferdienst.domains.users.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface   EmployeeRepository extends JpaRepository<Employee,Long> {

}
