package currency.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import currency.dataAccess.CurrencyRepo;
import currency.entity.CurrencyEntity;
import currency.entity.CurrencyModel;
import jakarta.persistence.EntityNotFoundException;


@Service
public class CurrencyService {
	
	@Autowired
	private CurrencyRepo repository;
	
	public List<CurrencyModel> getAll() {
		List<CurrencyEntity> entities=  repository.findAll();
		return convertToModels(entities);
	}
	
	public CurrencyModel getById(Long id){
		CurrencyEntity entity= repository.findById(id)
				.orElseThrow(()-> new EntityNotFoundException("Currency did not found in database."));
		return convertToModel(entity);
	}
	
	
	
	
	//used locally
	private CurrencyModel convertToModel(CurrencyEntity entity) {
		CurrencyModel model= new CurrencyModel();
		model.setId(entity.getId());
		model.setCurrencyCode(entity.getCurrencyCode());
		model.setCurrencyName(entity.getCurrencyName());
		return model;
	}
	
	private List<CurrencyModel> convertToModels(List<CurrencyEntity> entities){
		ArrayList<CurrencyModel> models= new ArrayList<>(entities.size());
		for(var i: entities) models.add(this.convertToModel(i));
		return models;
	}
}
