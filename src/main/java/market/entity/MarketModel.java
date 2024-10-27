package market.entity;

import currency.entity.CurrencyEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class MarketModel {
	
	@NotNull
	private Long id;
	
	@NotNull
	private String marketName;
	
	@NotNull
	private String marketCode;
	
	@NotNull
	private CurrencyEntity currency;
}
