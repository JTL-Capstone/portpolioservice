package com.hcl.jtl.portpolioservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
//import org.springframework.cloud.netflix.ribbon.RibbonClient;
//import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import com.hcl.jtl.portpolioservice.config.RibbonConfiguration;

//import com.hcl.jtl.portpolioservice.config.RibbonConfiguration;

@EnableDiscoveryClient
@SpringBootApplication
@EnableFeignClients
@LoadBalancerClient(name = "stocktradeservice", configuration = RibbonConfiguration.class)
//@RibbonClient(name = "portpolioservice", configuration = RibbonConfiguration.class)
//@RibbonClient(name = "stocktradeservicee", configuration = RibbonConfiguration.class)
public class PortpolioserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(PortpolioserviceApplication.class, args);
	}
	
//	@Bean
//	@LoadBalanced
//	public RestTemplate restTemplate() {
//		return new RestTemplate();
//	}

}
