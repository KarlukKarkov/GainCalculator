package stock.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import stock.entity.StockModel;
import stock.service.StockService;

@RestController
@RequestMapping("/api/stocks")
public class StockController{
	
	@Autowired
	private StockService service;
	
	@GetMapping
	public List<StockModel> getAll(){
		return service.getAll();
	}
	
	@GetMapping("/{id}")
	public StockModel getById(@Param("id") Long id) {
		return service.getById(id);
	}
	
	@GetMapping("/codes")
	public List<String> getAllCodes(){
		List<StockModel> models= service.getAll();
		ArrayList<String> stockCodes= new ArrayList<>(models.size());
		for(var i: models) stockCodes.add(i.getStockCode());
		return stockCodes;
	}
	
	@GetMapping("/codes/{code}")
	public StockModel getByCode(@Param("code")String code) {
		return service.getByCode(code);
	}
	
	@GetMapping("/names")
	public List<String> getAllNames(){
		List<StockModel> models= service.getAll();
		ArrayList<String> stockCodes= new ArrayList<>(models.size());
		for(var i: models) stockCodes.add(i.getStockName());
		return stockCodes;
	}
	
	@GetMapping("/names/{name}")
	public StockModel getByName(@Param("name")String name) {
		return service.getByName(name);
	}
	
	
	
	
	
	
	
}
