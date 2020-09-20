package telran.warehouse.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ItemDto {
	int itemNumber;
	String name;
	double amount;
	String inventoryCode;
}
