package de.lieferdienst.storages.specialties;

import de.lieferdienst.domains.specialties.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category,Long> {

}
