package com.hcl.jtl.portpolioservice.service.feign;

import java.util.Map;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.hcl.jtl.portpolioservice.config.FeignConfig;
import com.hcl.jtl.portpolioservice.serviceImpl.feign.FallbackStockTradeService;

@Service
@FeignClient(name = "authserver", contextId = "authserver", configuration = FeignConfig.class, fallback = FallbackStockTradeService.class)
public interface UserService {

	@GetMapping("authserver/user/{userId}")
	public Map<String, Object> getUserByUserId(@PathVariable String userId);
}
