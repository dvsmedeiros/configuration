package com.dvsmedeiros.configuration.controller;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dvsmedeiros.configuration.domain.ConfigurationGroup;
import com.dvsmedeiros.rest.rest.controller.DomainSpecificEntityController;

@Controller
@RequestMapping("${server.controller.prefix}/configuration/group")
public class ConfigurationGroupController extends DomainSpecificEntityController<ConfigurationGroup> {

	public ConfigurationGroupController() {
		super(ConfigurationGroup.class);
	}

	@Override
	@CacheEvict(value = "cacheConfigurationsGroup", allEntries = true)
	public ResponseEntity<?> updateEntity(@RequestBody ConfigurationGroup entity) {
		return super.updateEntity(entity);
	}

}
