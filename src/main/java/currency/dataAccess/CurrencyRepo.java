package currency.dataAccess;

import org.springframework.stereotype.Repository;

import currency.entity.CurrencyEntity;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

@Repository
public interface CurrencyRepo extends JpaRepository<CurrencyEntity,Long> {
	
}
