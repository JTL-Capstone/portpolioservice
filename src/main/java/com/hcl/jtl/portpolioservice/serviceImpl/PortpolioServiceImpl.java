package com.hcl.jtl.portpolioservice.serviceImpl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.jtl.portpolioservice.entity.Portpolio;
import com.hcl.jtl.portpolioservice.exception.ObjectNotExistsException;
import com.hcl.jtl.portpolioservice.repository.PortpolioRepository;
import com.hcl.jtl.portpolioservice.service.PortpolioService;
import com.hcl.jtl.portpolioservice.service.feign.StockTradeService;
import com.hcl.jtl.portpolioservice.service.feign.UserService;
import com.hcl.jtl.portpolioservice.util.Constants;

import jakarta.transaction.Transactional;

@Service
public class PortpolioServiceImpl implements PortpolioService{
	
	Logger logger = LoggerFactory.getLogger(PortpolioServiceImpl.class);

	@Autowired
	PortpolioRepository portpolioRepository;
	
	@Autowired
	StockTradeService stockTradeService;
	
	@Autowired
	UserService userService;
	
	@Override
	@Transactional
	public List<Portpolio> getPortpolioByUserId(String userId) {
		return portpolioRepository.findPortpolioByUserId(userId);
	}

	@Override
	public List<Portpolio> getAllPortpolios() {
		return portpolioRepository.findAll();
	}

	@Override
	public Portpolio createPortPolio(Portpolio portpolio) throws ObjectNotExistsException {
		if(userService.getUserByUserId(portpolio.getUserId()).isEmpty()) {
			logger.error("User Id "+portpolio.getUserId()+" "+Constants.RECORD_NOT_EXISTS);
			throw new ObjectNotExistsException("User Id "+portpolio.getUserId()+" "+Constants.RECORD_NOT_EXISTS);
		}else {
			if(stockTradeService.getStockTradeDetailsByStockCode(portpolio.getStockCode()).isEmpty()) {
				logger.error("Stock Code "+portpolio.getStockCode()+" "+Constants.RECORD_NOT_EXISTS);
				throw new ObjectNotExistsException("Stock Code "+portpolio.getStockCode()+" "+Constants.RECORD_NOT_EXISTS);
			}else {
				logger.info("portpolio is created");
				return portpolioRepository.save(portpolio);
			}
		}
	}

	@Override
	@Transactional
	public void deletePortPolioByUserId(String userId) {
		portpolioRepository.deletePortpolioByUserId(userId);
	}

	@Override
	public void deleteAllPortPolios() {
		portpolioRepository.deleteAll();
		
	}

}
