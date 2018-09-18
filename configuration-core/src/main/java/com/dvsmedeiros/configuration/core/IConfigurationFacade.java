package com.dvsmedeiros.configuration.core;

import java.util.Map;

import com.dvsmedeiros.configuration.domain.Configuration;

public interface IConfigurationFacade {

	public Configuration find(String group, String code, String defaultValue);

	public Map<String, Configuration> find(String group);
}
