package com.hcl.jtl.portpolioservice.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/portpolioconfig")
public class ConfigClientController {

	@Value("${spring.datasource.url}")
    private String exampleProperty;

    @GetMapping("/get-config")
    public String getConfig() {
        return "Configuration property value: " + exampleProperty;
    }
}
