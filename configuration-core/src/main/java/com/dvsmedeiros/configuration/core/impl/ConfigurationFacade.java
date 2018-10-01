package com.dvsmedeiros.configuration.core.impl;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.dvsmedeiros.bce.core.controller.impl.ApplicationFacade;
import com.dvsmedeiros.bce.domain.Filter;
import com.dvsmedeiros.configuration.core.IConfigurationDAO;
import com.dvsmedeiros.configuration.core.IConfigurationFacade;
import com.dvsmedeiros.configuration.domain.Configuration;
import com.dvsmedeiros.configuration.domain.ConfigurationGroup;

@Component
public class ConfigurationFacade extends ApplicationFacade<Configuration> implements IConfigurationFacade {

	@Autowired
	@Qualifier("configurationDAO")
	private IConfigurationDAO dao;

	@Override
	public Optional<Configuration> find(String group, String code, String defaultValue) {

		ConfigurationGroup configGroup = new ConfigurationGroup();
		configGroup.setCode(group);

		Filter<Configuration> aFilter = new Filter<Configuration>(Configuration.class);
		aFilter.getEntity().setCode(code);
		aFilter.getEntity().setGroup(configGroup);

		Stream<Configuration> configs = dao.filter(aFilter);
		
		Configuration configuration = new Configuration(defaultValue);

		configs.findFirst().ifPresent(config -> {			
			configuration.setActive(config.getActive());
			configuration.setCode(config.getCode());
			configuration.setDescription(config.getDescription());
			configuration.setGroup(config.getGroup());
			configuration.setInsertionDate(config.getInsertionDate());
			configuration.setValue(config.getValue());
		});
					
		return Optional.of(configuration);
	}

	@Override
	public Map<String, Configuration> find(String group) {

		ConfigurationGroup configGroup = new ConfigurationGroup();
		configGroup.setCode(group);

		Filter<Configuration> aFilter = new Filter<Configuration>(Configuration.class);
		aFilter.getEntity().setGroup(configGroup);

		Stream<Configuration> configs = dao.filter(aFilter);

		if (Optional.ofNullable(configs).isPresent()) {
			return configs.collect(Collectors.toMap(Configuration::getCode, config -> config));
		}
		return new HashMap<>();
	}

}
