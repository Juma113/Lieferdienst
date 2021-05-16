package de.lieferdienst.storages.users;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private AccountRepository accountRepository;

    @BeforeEach
    public void beforeEach(){

    }

    @AfterEach
    public void afterEach()
    {
        userRepository.deleteAll();
        addressRepository.deleteAll();
        accountRepository.deleteAll();
    }

}