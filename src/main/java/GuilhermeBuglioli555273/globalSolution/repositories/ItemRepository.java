package GuilhermeBuglioli555273.globalSolution.repositories;

import GuilhermeBuglioli555273.globalSolution.entities.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item,Long> {
}
