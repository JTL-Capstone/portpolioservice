package com.hcl.jtl.portpolioservice.controller;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.jtl.portpolioservice.entity.Portpolio;
import com.hcl.jtl.portpolioservice.exception.ObjectNotExistsException;
import com.hcl.jtl.portpolioservice.service.PortpolioService;
import com.hcl.jtl.portpolioservice.service.feign.StockTradeService;
import com.hcl.jtl.portpolioservice.service.feign.UserService;

@RestController
@RequestMapping("/portpolio")
public class PortpolioController {
	
	Logger logger = LoggerFactory.getLogger(PortpolioController.class);
	
	@Autowired
	PortpolioService portpolioService;
	
	@Autowired
	StockTradeService stockTradeService;
	
	@Autowired
	UserService userService;
	
	@GetMapping("/welcome")
	public ResponseEntity<String> sayWelcome() {
		return new ResponseEntity<>("Welcome to Microservice Capstone Project for PortPolio Service", HttpStatus.OK);
	}

	@GetMapping
	public ResponseEntity<List<Portpolio>> getPortPolios() {
		try {
			return new ResponseEntity<>(portpolioService.getAllPortpolios(), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping
	public ResponseEntity<Portpolio> createPortPolio(@RequestBody Portpolio portpolio) throws ObjectNotExistsException {
			logger.info("createPortPolio()");
			return new ResponseEntity<>(portpolioService.createPortPolio(portpolio), HttpStatus.OK);
	}

	@DeleteMapping("/{userId}")
	public ResponseEntity<String> deletePortPolioByUserId(@PathVariable String userId)throws ObjectNotExistsException {
		portpolioService.deletePortPolioByUserId(userId);
		logger.info("Portpolio is deleted successffully for user id "+userId);
		return new ResponseEntity<>("Portpolio is deleted successfully for user id "+userId, HttpStatus.OK);
	}
	
	@DeleteMapping
	public ResponseEntity<String> deleteAllPortPolio()throws ObjectNotExistsException {
		portpolioService.deleteAllPortPolios();
		logger.info("All Portpolios are deleted successffully...");
		return new ResponseEntity<>("All Portpolios are deleted successffully...", HttpStatus.OK);
	}


	@GetMapping("/{userId}")
	public ResponseEntity<List<Portpolio>> getPortPolioByUserId(@PathVariable String userId) {
		return new ResponseEntity<>(portpolioService.getPortpolioByUserId(userId), HttpStatus.OK);
	}
	
	//For Checking
	
	@GetMapping("/stock/{stockCode}")
	public ResponseEntity<Map<String, Object>> checkApiFromStock(@PathVariable int stockCode) {
		return new ResponseEntity<>(stockTradeService.getStockTradeDetailsByStockCode(stockCode), HttpStatus.OK);
	}
	
	@GetMapping("/user/{userId}")
	public ResponseEntity<Map<String, Object>> checkApiFromAuth(@PathVariable String userId) {
		return new ResponseEntity<>(userService.getUserByUserId(userId), HttpStatus.OK);
	}

	
}
