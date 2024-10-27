package market.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import currency.entity.CurrencyEntity;
import currency.entity.CurrencyModel;
import jakarta.persistence.EntityNotFoundException;
import market.dataAcess.MarketRepository;
import market.entity.MarketEntity;
import market.entity.MarketModel;

@Service
public class MarketService {

	@Autowired
	private MarketRepository repository;
	
	public List<MarketModel> getAll(){
		return convertToModels(repository.findAll());
	}
	
	public MarketModel getById(Long id){
		MarketEntity entity= repository.findById(id)
						.orElseThrow(()->new EntityNotFoundException("Market is not in the database"));
		return convertToModel(entity);
	}
	
	
	//locally
	private MarketModel convertToModel(MarketEntity entity) {
		MarketModel model= new MarketModel();
		model.setCurrency(entity.getCurrency());
		model.setMarketCode(entity.getMarketCode());
		model.setMarketID(entity.getMarketID());
		model.setMarketName(entity.getMarketName());
		return model;
	}
	
	private List<MarketModel> convertToModels(List<MarketEntity> entities){
		ArrayList<MarketModel> models= new ArrayList<>(entities.size());
		for(var i: entities) models.add(this.convertToModel(i));
		return models;
	}
}
