package de.lieferdienst.storages.specialties;


import de.lieferdienst.domains.specialties.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;


public interface RestaurantRepository extends JpaRepository<Restaurant,Long> {


}
