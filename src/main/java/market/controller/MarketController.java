package market.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import market.entity.MarketModel;
import market.service.MarketService;

@RestController
@RequestMapping("/api/market")
public class MarketController {
	@Autowired
	private MarketService service;
	
	@GetMapping
	public ResponseEntity<List<MarketModel>> getAll(){
		return new ResponseEntity<>(service.getAll(),HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<MarketModel> getById(@PathVariable Long id){
		return new ResponseEntity<>(service.getById(id),HttpStatus.OK);
	}
	
}
