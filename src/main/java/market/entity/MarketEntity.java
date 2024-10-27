package market.entity;

import org.aspectj.weaver.tools.Trace;

import currency.entity.CurrencyEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "MARKET")
public class MarketEntity {
	
	@Id
	private Long id;
	
	@Column(name = "market", nullable = false, unique = true)
	private String marketName;
	
	@Column(name= "market_code", nullable = false, unique = true)
	private String marketCode;
	
	@ManyToOne
	@JoinColumn(name="currency", nullable = false)
	private CurrencyEntity currency;
	
}
