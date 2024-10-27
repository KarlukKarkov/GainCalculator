package stock.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import static jakarta.persistence.GenerationType.AUTO;

@Getter
@Setter
@Entity
@Table(name = "STOCK")
public class StockEntity {
	
	@Id
	private Long id;
	
	@Column(unique = true, nullable = false, name = "Stock_Name")
	private String stockName;
	
	@Column(unique = true,nullable = false, name= "Stock_Code")
	private String stockCode;
	
	@ManyToOne
	@JoinColumn(name ="market_id")
	private int market;
	
	
}
