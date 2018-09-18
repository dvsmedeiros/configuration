package com.dvsmedeiros.configuration.core.impl;

import com.dvsmedeiros.bce.core.dao.impl.GenericDAO;
import com.dvsmedeiros.configuration.core.IConfigurationDAO;
import com.dvsmedeiros.configuration.domain.Configuration;

import ch.qos.logback.core.filter.Filter;

public class ConfigurationDAO extends GenericDAO<Configuration> implements IConfigurationDAO{

	@Override
	public Configuration filter(Filter<Configuration> filter) {
		return null;
	}

}
