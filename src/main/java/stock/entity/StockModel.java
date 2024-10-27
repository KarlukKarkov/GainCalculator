package stock.entity;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class StockModel {
	
	@NotNull
	private Long id;
	
	@NotNull
	private String stockName;
	
	@NotNull
	private String stockCode;
	
	private int market;
}
