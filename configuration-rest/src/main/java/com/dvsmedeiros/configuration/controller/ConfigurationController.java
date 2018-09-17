package com.dvsmedeiros.configuration.controller;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dvsmedeiros.configuration.domain.Configuration;
import com.dvsmedeiros.rest.rest.controller.DomainSpecificEntityController;

@SuppressWarnings("rawtypes")
@Controller
@RequestMapping("configuration")
public class ConfigurationController extends DomainSpecificEntityController<Configuration> {

	public ConfigurationController() {
		super(Configuration.class);
	}

	@Override
	@CacheEvict(value = "cacheConfigurations", allEntries = true)
	public ResponseEntity updateEntity(@RequestBody Configuration entity) {
		return super.updateEntity(entity);
	}

}
