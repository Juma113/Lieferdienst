package de.lieferdienst.storages.lists;

import de.lieferdienst.domains.lists.LineItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LineItemRepository extends JpaRepository<LineItem,Long> {

}
