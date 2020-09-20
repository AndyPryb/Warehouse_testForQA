package telran.warehouse.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import telran.warehouse.model.Item;

public interface WarehouseRepository extends JpaRepository<Item, Integer>{
	
}
