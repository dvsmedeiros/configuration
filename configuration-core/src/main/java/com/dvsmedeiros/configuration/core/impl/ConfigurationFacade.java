package com.dvsmedeiros.configuration.core.impl;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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
	public Configuration find(String group, String code, String defaultValue) {

		ConfigurationGroup configGroup = new ConfigurationGroup();
		configGroup.setCode(group);

		Filter<Configuration> aFilter = new Filter<Configuration>(Configuration.class);
		aFilter.getEntity().setCode(code);
		aFilter.getEntity().setGroup(configGroup);

		List<Configuration> configs = dao.filter(aFilter);

		return configs != null && !configs.isEmpty() ? configs.get(0) : new Configuration(defaultValue);
	}

	@Override
	public Map<String, Configuration> find(String group) {

		ConfigurationGroup configGroup = new ConfigurationGroup();
		configGroup.setCode(group);

		Filter<Configuration> aFilter = new Filter<Configuration>(Configuration.class);
		aFilter.getEntity().setGroup(configGroup);

		List<Configuration> configs = dao.filter(aFilter);

		return configs.stream().collect(Collectors.toMap(Configuration::getCode, config -> config));
	}

}
