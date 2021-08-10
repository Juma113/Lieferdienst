package de.lieferdienst;

import de.lieferdienst.repository.storage.UserRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication
@EnableJpaRepositories(basePackageClasses = UserRepository.class)
public class LieferdienstApplication {


    public static void main(String[] args) {

        SpringApplication.run(LieferdienstApplication.class, args);
    }
}
