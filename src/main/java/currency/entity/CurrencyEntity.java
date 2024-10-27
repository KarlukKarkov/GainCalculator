package currency.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name= "CURRENCY")
public class CurrencyEntity {
	
	@Id
	private Long id;
	
	@Column(name = "Currency_Code",nullable = false, unique = true)
	private String currencyCode;
	
	@Column(name= "Currency_Name", nullable = false, unique = true) 
	private String currencyName;  //pulling data from yahoo
	
}
