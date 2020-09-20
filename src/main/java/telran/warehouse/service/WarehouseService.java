package telran.warehouse.service;

import java.util.List;

import telran.warehouse.dto.ItemDto;

public interface WarehouseService {
	
	public ItemDto getItem(int itemNumber);
	
	public double itemWithdrawal(int itemNumber, double amount);
	
	public double itemDeposit(int itemNumber, double amount);
	
	public boolean addItem(ItemDto itemDto);
	
	public boolean deleteItem(int itemNumber);

	public List<ItemDto> getAllItems();
	
}
