package stock.dataAccess;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import stock.entity.StockEntity;

public interface StockRepository extends JpaRepository<StockEntity, Long> {
	@Query(value ="SELECT * FROM STOCK WHERE Stock_Code = :stockCode", nativeQuery = true)
	public StockEntity getByCode(@Param("stockCode") String stockCode);
	
	@Query(value= "SELECT * FROM STOCK WHERE Stock_Name = :stockName",nativeQuery = true)
	public StockEntity getByName(@Param("stockName") String stockName);

}
