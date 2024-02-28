package com.hcl.jtl.portpolioservice.serviceImpl.feign;

import java.util.Collections;
import java.util.Map;

import com.hcl.jtl.portpolioservice.service.feign.StockTradeService;
import com.hcl.jtl.portpolioservice.service.feign.UserService;

public class FallbackStockTradeService implements StockTradeService, UserService{

	@Override
	public Map<String, Object> getStockTradeDetailsByStockCode(int stockCode) {
		return (Map<String, Object>) Collections.EMPTY_LIST;
	}

	@Override
	public Map<String, Object> getUserByUserId(String userId) {
		return (Map<String, Object>) Collections.EMPTY_LIST;
	}

}
