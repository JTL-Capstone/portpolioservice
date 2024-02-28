package com.hcl.jtl.portpolioservice.service.feign;

import java.util.Map;

//import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.hcl.jtl.portpolioservice.config.FeignConfig;
//import com.hcl.jtl.portpolioservice.config.RibbonConfiguration;
import com.hcl.jtl.portpolioservice.serviceImpl.feign.FallbackStockTradeService;

@Service
@FeignClient(name = "stocktradeservice", contextId = "stocktradeservice", configuration = FeignConfig.class, fallback = FallbackStockTradeService.class)
public interface StockTradeService {

	@GetMapping(path ="stocktradeservice/stocks/{stockCode}")
    Map<String, Object> getStockTradeDetailsByStockCode(@PathVariable("stockCode") int stockCode);
}
