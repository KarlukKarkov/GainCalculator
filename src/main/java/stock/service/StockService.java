package stock.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import currency.entity.CurrencyEntity;
import currency.entity.CurrencyModel;
import jakarta.persistence.EntityNotFoundException;
import stock.dataAccess.StockRepository;
import stock.entity.StockEntity;
import stock.entity.StockModel;

@Service
public class StockService {
	
	@Autowired
	private StockRepository repository;
	
	public List<StockModel> getAll(){
		return convertToModels(repository.findAll());
	}
	
	public StockModel getById(Long id) {
		return convertToModel(
					repository.findById(id)
					.orElseThrow(()-> new EntityNotFoundException("Stock is not in database"))
				);
	}
	
	public StockModel getByCode(String code) {
		return convertToModel(
					repository.getByCode(code)
				);
				
	}
	
	public StockModel getByName(String name) {
		return convertToModel(
					repository.getByName(name)
				);
	}
	
	
	//local
	private StockModel convertToModel(StockEntity entity) {
		StockModel model= new StockModel();
		model.setMarket(entity.getMarket());
		model.setStockCode(entity.getStockCode());
		model.setId(entity.getId());
		model.setStockName(entity.getStockName());
		return model;
	}
	
	private List<StockModel> convertToModels(List<StockEntity> entities){
		ArrayList<StockModel> models= new ArrayList<>(entities.size());
		for(var i: entities) models.add(this.convertToModel(i));
		return models;
	}
}
