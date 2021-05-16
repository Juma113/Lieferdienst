package de.lieferdienst.storages.lists;

import de.lieferdienst.core.H2Controller;
import de.lieferdienst.domains.lists.ShoppingCart;
import de.lieferdienst.storages.BaseRepository;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ShoppingCartRepository extends JpaRepository<ShoppingCart,Long> {


}
