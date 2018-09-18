package com.dvsmedeiros.configuration.core.impl;

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

		Configuration config = dao.filter(aFilter);

		return config != null ? config : new Configuration(defaultValue);
	}

}
