package currency.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CurrencyModel {
	
	private Long id;
	
	private String currencyCode;
	
	private String currencyName;  //pulling data from yahoo
}
