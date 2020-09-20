package telran.warehouse.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@EqualsAndHashCode (of = "itemNumber")
@Entity
public class Item {
	
	@Id
	int itemNumber;
	String name;
	double amount;
	String inventoryCode;
}
