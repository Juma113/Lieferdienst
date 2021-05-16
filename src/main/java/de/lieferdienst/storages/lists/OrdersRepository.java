package de.lieferdienst.storages.lists;

import de.lieferdienst.domains.lists.Orders;
import org.springframework.data.jpa.repository.JpaRepository;


public interface OrdersRepository extends JpaRepository<Orders,Long> {

}
