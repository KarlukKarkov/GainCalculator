package portfolio.entity;

import java.util.List;

import comparator.entity.ComparatorEntity;
import currency.entity.CurrencyEntity;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import order.entity.OrderEntity;

@Getter
@Setter
@Entity
@Table(name = "PORTFOLIO")
public class PortfolioEntity {
	
	@Id
	private Long id;
	
	@ManyToOne
	@JoinColumn(name= "currencyID", referencedColumnName = "currencyID")
	private CurrencyEntity currency; //calculate account balance in this currency
	
	@OneToMany(mappedBy = "PORTFOLIO", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<OrderEntity> orders;
	
	@Column(name= "balance",scale = 2,nullable = false)
	private double accountBalance;
	
	@ManyToOne
	@JoinColumn(name = "comparator")
	private ComparatorEntity comparator;
}
