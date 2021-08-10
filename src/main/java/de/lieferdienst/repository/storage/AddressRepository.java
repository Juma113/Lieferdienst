package de.lieferdienst.repository.storage;

import de.lieferdienst.model.helper.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface AddressRepository extends JpaRepository<Address,Long> {
    Optional<Address> findAddressById(long id);
}
