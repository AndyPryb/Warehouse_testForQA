package telran.warehouse.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import telran.warehouse.dto.ItemDto;
import telran.warehouse.exceptions.ItemExistsException;
import telran.warehouse.exceptions.ItemNotFoundException;
import telran.warehouse.model.Item;
import telran.warehouse.repository.WarehouseRepository;

@Component
public class WarehouseServiceImpl implements WarehouseService {
	
	@Autowired
	WarehouseRepository warehouseRepository;
	
	@Autowired
	ModelMapper modelMapper;
	
	@Override
	public ItemDto getItem(int itemNumber) {
		Item item = warehouseRepository.findById(itemNumber).orElseThrow(() -> new ItemNotFoundException());
		return modelMapper.map(item, ItemDto.class);
	}

	@Override
	public double itemWithdrawal(int itemNumber, double amount) {
		Item item = warehouseRepository.findById(itemNumber).orElseThrow(() -> new ItemNotFoundException());
		item.setAmount(item.getAmount()-amount);
		warehouseRepository.save(item);
		return item.getAmount();
	}

	@Override
	public double itemDeposit(int itemNumber, double amount) {
		Item item = warehouseRepository.findById(itemNumber).orElseThrow(() -> new ItemNotFoundException());
		item.setAmount(item.getAmount()+amount);
		warehouseRepository.save(item);
		return item.getAmount();
	}

	@Override
	public boolean addItem(ItemDto itemDto) {
		Item item = modelMapper.map(itemDto, Item.class);
		if(warehouseRepository.existsById(itemDto.getItemNumber())) {
			throw new ItemExistsException();
		}
		warehouseRepository.save(item);
		return true;
	}

	@Override
	public boolean deleteItem(int itemNumber) {
		if (!warehouseRepository.existsById(itemNumber)) {
			throw new ItemNotFoundException();
		}
		warehouseRepository.deleteById(itemNumber);
		return true;
	}
}
