package com.nks.restApi;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.nks.entity.Business;
import com.nks.service.BusinessService;

@RestController
@CrossOrigin
public class BusinessTemplate {

	private final Logger logger  = Logger.getLogger(BusinessTemplate.class);
	
	private final BusinessService businessService;
	
	public BusinessTemplate(BusinessService businessService) {
		this.businessService = businessService;
	}
		
	@PostMapping("/business/add")
	public Business saveEmployee(@RequestBody Business business) {
		logger.info("Inside post method");
		try {
			businessService.save(business);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return business;
	}
	
	@PutMapping("/business")
	public Business updateEmployee(@RequestBody Business business) {
		logger.info("Inside post method");
		try {
			businessService.save(business);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return business;
	}
	
	@GetMapping("/business")
	public List<Business> getEmployee() {
		logger.info("Inside get method");
		List<Business> businesses = new ArrayList<Business>();
		try {
			businesses = businessService.retrieve();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return businesses;
	}
	
	@GetMapping("/business/edit/{id}")
	public Business saveEmployee(@PathVariable Long id) {
		logger.info("Inside put method");
		Optional<Business> business = null;
		try {
			business = businessService.findById(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return business.get();
	}
	
	@DeleteMapping("/business/delete/{id}")
	public String deleteEmployee(@PathVariable  Long id) {
		logger.info("Inside delete method");
		businessService.deleteEmployee(id);
		return id + " was deleted";
	}
}
