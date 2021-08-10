package de.lieferdienst.repository.storage;

import de.lieferdienst.model.errors.NotFounfException;
import de.lieferdienst.model.userManagment.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService  {

    @Autowired
    private UserRepository userRepository;


    public User getUserByID (Long id) throws NotFounfException
    {
        Optional<User> result = userRepository.findById(id);
        if (result.isPresent())
        {
            return result.get();
        }
        throw new NotFounfException("No Persons found for id " + id);
    }

    public User getUserByEmail (String email) throws NotFounfException
    {
        Optional<User> result = userRepository.findByEmail(email);
        if (result.isPresent())
        {
            return result.get();
        }
        throw new NotFounfException("No Persons found for id " + email);
    }
}
