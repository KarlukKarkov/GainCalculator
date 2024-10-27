package market.dataAcess;

import org.springframework.data.jpa.repository.JpaRepository;

import market.entity.MarketEntity;

public interface MarketRepository extends JpaRepository<MarketEntity, Long> {
	
}
