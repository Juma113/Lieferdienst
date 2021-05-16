package de.lieferdienst.storages.users;

import de.lieferdienst.domains.users.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account,Long> {

}
