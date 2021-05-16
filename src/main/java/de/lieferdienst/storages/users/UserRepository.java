package de.lieferdienst.storages.users;

import de.lieferdienst.domains.users.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long> {

    @Query("SELECT user FROM User user WHERE user.lastName = :lastName")
    public Optional<User> findByLastName(String lastName);

}

