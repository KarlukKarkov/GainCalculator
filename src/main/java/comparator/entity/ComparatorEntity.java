package comparator.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import portfolio.entity.PortfolioEntity;

@Getter
@Setter
@Entity
@Table(name = "COMPARATOR")
public class ComparatorEntity {
	
	@Id 
	private int comparatorID;
	
	@OneToMany(mappedBy = "COMPARATOR", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<PortfolioEntity> portfolios;
}
