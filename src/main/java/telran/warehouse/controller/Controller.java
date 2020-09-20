package telran.warehouse.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import telran.warehouse.dto.ItemDto;
import telran.warehouse.service.WarehouseService;

@RestController
public class Controller {
	
	@Autowired
	WarehouseService warehouseService;
	
	@GetMapping("/get/{itemNumber}")
	public ItemDto getItem(@PathVariable Integer itemNumber) {
		return warehouseService.getItem(itemNumber);
	}
	
	@PutMapping("/withdraw/{itemNumber}/{amount}")
	public Double itemWithdraw(@PathVariable Integer itemNumber, @PathVariable Double amount) {
		return warehouseService.itemWithdrawal(itemNumber, amount);
	}
	
	@PutMapping("/deposit/{itemNumber}/{amount}")
	public Double itemDeposit(@PathVariable Integer itemNumber, @PathVariable Double amount) {
		return warehouseService.itemDeposit(itemNumber, amount);
	}
	
	@PostMapping("/addItem/{itemNumber}")
	public boolean addItem(@RequestBody ItemDto itemDto) {
		return warehouseService.addItem(itemDto);
	}
	
	@DeleteMapping("/deleteItem/{itemNumber}")
	public boolean deleteItem(@PathVariable Integer itemNumber) {
		return warehouseService.deleteItem(itemNumber);
	}
}
