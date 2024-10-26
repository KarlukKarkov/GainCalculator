package order.entity;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "ORDER")
public class OrderEntity {
	
	@Id
	private int orderID;
	
	@ManyToOne
	@JoinColumn(name = "stockID", referencedColumnName = "stockID")
	private int stockID;
	
	@Column(name="start_date")
	private Date startDate; //no start date= start in 2015 1 january
	
	@Enumerated(EnumType.STRING)
	@Column(name= "frequency")
	private Frequency frequency; //no frequency= no autoinvest
	
	@Column(name= "buy_price")
	private double buyPrice;
	
	
}
