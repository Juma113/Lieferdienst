package de.lieferdienst.storages.users;

import de.lieferdienst.domains.users.Address;
import org.springframework.data.jpa.repository.JpaRepository;


public interface AddressRepository extends JpaRepository<Address,Long> {

}
