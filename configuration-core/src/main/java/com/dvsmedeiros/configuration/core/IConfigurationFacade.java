package com.dvsmedeiros.configuration.core;

import com.dvsmedeiros.configuration.domain.Configuration;

public interface IConfigurationFacade {
	
	public Configuration find(String group, String code, String defaultValue);
	
}
