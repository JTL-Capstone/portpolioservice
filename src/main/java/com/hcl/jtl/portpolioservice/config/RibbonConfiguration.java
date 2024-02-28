package com.hcl.jtl.portpolioservice.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

//import com.netflix.loadbalancer.IPing;
//import com.netflix.loadbalancer.IRule;
//import com.netflix.loadbalancer.RandomRule;

@Configuration
public class RibbonConfiguration {

//	@Bean
//	IRule rule() {
//		return new RandomRule();
//	}
	
//	@Bean
//    public IRule ribbonRule() {
//        // Specify the load balancing rule (e.g., RoundRobinRule)
//        return new com.netflix.loadbalancer.RoundRobinRule();
//    }
//
//    @Bean
//    public IPing ribbonPing() {
//        // Specify the ping strategy
//        return new com.netflix.loadbalancer.NoOpPing();
//    }
	
	@Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
