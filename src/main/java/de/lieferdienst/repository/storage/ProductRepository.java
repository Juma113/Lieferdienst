package de.lieferdienst.repository.storage;

import de.lieferdienst.model.productManagment.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {

    Iterable<Product> findProductByCategoryId(long category_id);

}
