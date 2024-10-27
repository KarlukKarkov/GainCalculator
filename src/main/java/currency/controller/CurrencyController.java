package currency.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import currency.entity.CurrencyModel;
import currency.service.CurrencyService;

@RestController
@RequestMapping("/api/currencies")
public class CurrencyController {

	@Autowired
	private CurrencyService service;
	
	@GetMapping
	public ResponseEntity<List<CurrencyModel>> getAll(){
		return new ResponseEntity<>(service.getAll(),HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<CurrencyModel> getById(@PathVariable Long id){
		return new ResponseEntity<>(service.getById(id),HttpStatus.OK);
	}
}
